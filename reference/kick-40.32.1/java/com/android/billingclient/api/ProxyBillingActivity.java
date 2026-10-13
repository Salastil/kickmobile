package com.android.billingclient.api;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.core.content.ContextCompat;
import com.android.billingclient.BuildConfig;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzla;
import com.google.android.gms.internal.play_billing.zzld;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public class ProxyBillingActivity extends Activity {
    static final String EXTERNAL_BROADCAST_PERMISSION = "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST";
    private static final String KEY_ACTIVITY_CODE = "activity_code";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    static final int RESULT_CODE_PLAY_CANCELED_WITH_ON_CREATE_RUNTIME_EXCEPTION = 5;
    static final int RESULT_CODE_PLAY_CANCELLED = 3;
    static final int RESULT_CODE_PLAY_CANCELLED_WITHOUT_COMPLETE_ACTION = 4;
    private static final String TAG = "ProxyBillingActivity";
    private int activityCode;
    private long billingClientTransactionId;
    zzdd billingLogger;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    zzej proxyBillingBroadcastReceiver;
    private boolean sendCancelledBroadcastIfFinished;
    private boolean wasServiceAutoReconnected;

    private zzjs getLoggingErrorReason(int i, Intent intent) {
        if (intent != null) {
            if (intent.getExtras() == null) {
                return zzjs.NULL_BUNDLE_IN_ACTIVITY_RESULT;
            }
            return i == 5 ? zzjs.PLAY_STORE_ON_CREATE_RUNTIME_EXCEPTION : zzjs.REASON_UNSPECIFIED;
        }
        if (i == -1) {
            return zzjs.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i == 0) {
            return zzjs.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i != 3) {
            return i != 4 ? zzjs.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzjs.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE;
        }
        return zzjs.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE;
    }

    private boolean isInAppMessageFlow(Bundle bundle) {
        if (bundle != null) {
            return bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
        }
        if (getIntent() == null) {
            return false;
        }
        return getIntent().hasExtra("IN_APP_MESSAGE_INTENT");
    }

    private boolean isKnownError(int i, Intent intent) {
        return !getLoggingErrorReason(i, intent).equals(zzjs.REASON_UNSPECIFIED);
    }

    private boolean isProxyBillingBroadcastReceiverRegistered() {
        return this.proxyBillingBroadcastReceiver != null;
    }

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0068  */
    private Intent makePurchaseUpdatedIntentWithResponseCodeAndReason(zzjs zzjsVar, long j, boolean z) {
        Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        if (!z) {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(6);
            builderNewBuilder.setDebugMessage("An internal error occurred.");
            BillingResult billingResultBuild = builderNewBuilder.build();
            int i = zzdc.zza;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzdc.zzb(zzjsVar, 2, billingResultBuild, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        } else if (isProxyBillingBroadcastReceiverRegistered() && this.proxyBillingBroadcastReceiver.zza() != null) {
            BillingResult billingResultZza = this.proxyBillingBroadcastReceiver.zza();
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", billingResultZza.getResponseCode());
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", billingResultZza.getDebugMessage());
        } else if (!isProxyBillingBroadcastReceiverRegistered() || this.proxyBillingBroadcastReceiver.zzc()) {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
            BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
            builderNewBuilder2.setResponseCode(6);
            builderNewBuilder2.setDebugMessage("An internal error occurred.");
            BillingResult billingResultBuild2 = builderNewBuilder2.build();
            int i2 = zzdc.zza;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzdc.zzb(zzjsVar, 2, billingResultBuild2, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        } else {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 3);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Play Store is blocked.");
            BillingResult.Builder builderNewBuilder3 = BillingResult.newBuilder();
            builderNewBuilder3.setResponseCode(3);
            builderNewBuilder3.setDebugMessage("Play Store is blocked.");
            BillingResult billingResultBuild3 = builderNewBuilder3.build();
            zzjs zzjsVar2 = zzjs.PLAY_STORE_APP_BLOCKED;
            int i3 = zzdc.zza;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzdc.zzb(zzjsVar2, 2, billingResultBuild3, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        }
        intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j);
        intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return intentMakePurchasesUpdatedIntent;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0038 A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #1 {all -> 0x0064, blocks: (B:5:0x001d, B:20:0x0030, B:23:0x0038, B:25:0x005b, B:24:0x004a, B:30:0x0066), top: B:32:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004a A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:5:0x001d, B:20:0x0030, B:23:0x0038, B:25:0x005b, B:24:0x004a, B:30:0x0066), top: B:32:0x0001 }] */
    private synchronized void registerProxyBillingBroadcastReceiver() throws Throwable {
        ProxyBillingActivity proxyBillingActivity;
        boolean z;
        zzdd zzddVar;
        try {
            try {
                this.proxyBillingBroadcastReceiver = new zzej(this.billingLogger);
                IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.IN_APP_BILLING_RESULT_UPDATE_ACTION");
                intentFilter.addAction("com.android.vending.billing.PLAY_BILLING_ACTIVITY_CREATED_ACTION");
                proxyBillingActivity = this;
                try {
                    ContextCompat.registerReceiver(proxyBillingActivity, this.proxyBillingBroadcastReceiver, intentFilter, EXTERNAL_BROADCAST_PERMISSION, null, 2);
                    return;
                } catch (NoSuchMethodError e) {
                    e = e;
                    Throwable th = e;
                    proxyBillingActivity.proxyBillingBroadcastReceiver = null;
                    z = th instanceof NoSuchMethodError;
                    zzddVar = proxyBillingActivity.billingLogger;
                    if (z) {
                        zzla zzlaVarZza = zzld.zza();
                        zzlaVarZza.zza(2);
                        zzddVar.zzl((zzld) zzlaVarZza.zzi());
                    } else {
                        zzla zzlaVarZza2 = zzld.zza();
                        zzlaVarZza2.zza(1);
                        zzddVar.zzl((zzld) zzlaVarZza2.zzi());
                    }
                    com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to register receiver.", th);
                    return;
                } catch (RuntimeException e2) {
                    e = e2;
                    Throwable th2 = e;
                    proxyBillingActivity.proxyBillingBroadcastReceiver = null;
                    z = th2 instanceof NoSuchMethodError;
                    zzddVar = proxyBillingActivity.billingLogger;
                    if (z) {
                        zzla zzlaVarZza3 = zzld.zza();
                        zzlaVarZza3.zza(2);
                        zzddVar.zzl((zzld) zzlaVarZza3.zzi());
                    } else {
                        zzla zzlaVarZza4 = zzld.zza();
                        zzlaVarZza4.zza(1);
                        zzddVar.zzl((zzld) zzlaVarZza4.zzi());
                    }
                    com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to register receiver.", th2);
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (NoSuchMethodError e3) {
            e = e3;
            proxyBillingActivity = this;
            Throwable th4 = e;
            proxyBillingActivity.proxyBillingBroadcastReceiver = null;
            z = th4 instanceof NoSuchMethodError;
            zzddVar = proxyBillingActivity.billingLogger;
            if (z) {
                zzla zzlaVarZza5 = zzld.zza();
                zzlaVarZza5.zza(2);
                zzddVar.zzl((zzld) zzlaVarZza5.zzi());
            } else {
                zzla zzlaVarZza6 = zzld.zza();
                zzlaVarZza6.zza(1);
                zzddVar.zzl((zzld) zzlaVarZza6.zzi());
            }
            com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to register receiver.", th4);
            return;
        } catch (RuntimeException e4) {
            e = e4;
            proxyBillingActivity = this;
            Throwable th5 = e;
            proxyBillingActivity.proxyBillingBroadcastReceiver = null;
            z = th5 instanceof NoSuchMethodError;
            zzddVar = proxyBillingActivity.billingLogger;
            if (z) {
                zzla zzlaVarZza7 = zzld.zza();
                zzlaVarZza7.zza(2);
                zzddVar.zzl((zzld) zzlaVarZza7.zzi());
            } else {
                zzla zzlaVarZza8 = zzld.zza();
                zzlaVarZza8.zza(1);
                zzddVar.zzl((zzld) zzlaVarZza8.zzi());
            }
            com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to register receiver.", th5);
            return;
        } catch (Throwable th6) {
            th = th6;
            throw th;
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:25:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066 A[PHI: r10
      0x0066: PHI (r10v1 int) = (r10v0 int), (r10v15 int) binds: [B:24:0x0061, B:26:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:30:0x0099  */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f1  */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0066, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0082, please report this as an issue */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        int responseCode;
        int i3;
        String string;
        Intent intentMakePurchasesUpdatedIntent;
        boolean z2;
        int iZza;
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (intent == null) {
                z = false;
            } else {
                z = true;
            }
            responseCode = com.google.android.gms.internal.play_billing.zzc.zzi(intent, TAG).getResponseCode();
            i3 = -1;
            if (i2 != -1) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            } else if (responseCode != 0) {
                i2 = -1;
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            }
            if (true != z) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null data with resultCode " + i3 + "!");
            } else if (intent.getExtras() == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null bundle!");
            }
            if (isKnownError(i3, intent)) {
                zzjs loggingErrorReason = getLoggingErrorReason(i3, intent);
                long j = this.billingClientTransactionId;
                if (intent == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithResponseCodeAndReason(loggingErrorReason, j, z2);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i == 110) {
            if (intent == null) {
                z = false;
            } else {
                z = true;
            }
            responseCode = com.google.android.gms.internal.play_billing.zzc.zzi(intent, TAG).getResponseCode();
            i3 = -1;
            if (i2 != -1) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            } else if (responseCode != 0) {
                i2 = -1;
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            }
            if (true != z) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null data with resultCode " + i3 + "!");
            } else if (intent.getExtras() == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null bundle!");
            }
            if (isKnownError(i3, intent)) {
                zzjs loggingErrorReason2 = getLoggingErrorReason(i3, intent);
                long j2 = this.billingClientTransactionId;
                if (intent == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithResponseCodeAndReason(loggingErrorReason2, j2, z2);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i == 101) {
            int i4 = com.google.android.gms.internal.play_billing.zzc.zza;
            if (intent == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null intent!");
                intent = null;
                iZza = 0;
            } else {
                iZza = com.google.android.gms.internal.play_billing.zzc.zza(intent.getExtras(), TAG);
            }
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(iZza, intent != null ? intent.getExtras() : null);
            }
        } else {
            com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        if (isProxyBillingBroadcastReceiverRegistered()) {
            this.proxyBillingBroadcastReceiver.zzb();
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Throwable {
        int i;
        PendingIntent pendingIntent;
        Bundle bundle2;
        Bundle bundle3;
        super.onCreate(bundle);
        if (!isInAppMessageFlow(bundle)) {
            try {
                i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to get package info for current package.", e);
                i = -1;
            }
            if (this.billingLogger == null) {
                Context applicationContext = getApplicationContext();
                zzke zzkeVarZza = zzkg.zza();
                zzkeVarZza.zzq(getPackageName());
                zzkeVarZza.zzx(BuildConfig.VERSION_NAME);
                zzkeVarZza.zzb(i);
                zzkeVarZza.zza(Build.VERSION.SDK_INT);
                zzkeVarZza.zzp(926300087L);
                this.billingLogger = new zzdr(applicationContext, (zzkg) zzkeVarZza.zzi());
            }
            registerProxyBillingBroadcastReceiver();
        }
        if (bundle != null) {
            com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.activityCode = bundle.getInt(KEY_ACTIVITY_CODE, 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow");
        this.activityCode = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                this.activityCode = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            this.activityCode = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            if (Build.VERSION.SDK_INT < 36) {
                if (Build.VERSION.SDK_INT >= 34) {
                    bundle3 = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle();
                } else {
                    bundle2 = null;
                }
                startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0, bundle2);
            }
            bundle3 = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(3).toBundle();
            bundle2 = bundle3;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0, bundle2);
        } catch (IntentSender.SendIntentException e2) {
            com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Got exception while trying to start a purchase flow.", e2);
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentMakePurchaseUpdatedIntentWithResponseCodeAndReason = makePurchaseUpdatedIntentWithResponseCodeAndReason(zzjs.INTENT_SENDER_EXCEPTION, this.billingClientTransactionId, false);
                if (this.isFlowFromFirstPartyClient) {
                    intentMakePurchaseUpdatedIntentWithResponseCodeAndReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentMakePurchaseUpdatedIntentWithResponseCodeAndReason);
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        BillingResult billingResultZza;
        super.onDestroy();
        if (isProxyBillingBroadcastReceiverRegistered()) {
            billingResultZza = this.proxyBillingBroadcastReceiver.zza();
            try {
                unregisterReceiver(this.proxyBillingBroadcastReceiver);
            } catch (RuntimeException e) {
                com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Failed to unregister receiver.", e);
            }
        } else {
            billingResultZza = null;
        }
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            if (billingResultZza != null) {
                intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", billingResultZza.getResponseCode());
                intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", billingResultZza.getDebugMessage());
            } else {
                intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
                intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            }
            if (this.isFlowFromFirstPartyClient) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt(KEY_ACTIVITY_CODE, this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}
