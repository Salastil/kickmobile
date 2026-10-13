package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzim;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzkk;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzll;
import com.google.android.gms.internal.play_billing.zzln;
import io.ktor.sse.ServerSentEventKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private PendingPurchasesParams zzG;
    private boolean zzH;
    private boolean zzI;
    private com.google.android.gms.internal.play_billing.zzcf zzJ;
    private volatile BillingClientStateListener zzK;
    private ExecutorService zzL;
    private final Long zzM;
    private final com.google.android.gms.internal.play_billing.zzbq zzN;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzz zzf;
    private Context zzg;
    private zzdd zzh;
    private volatile com.google.android.gms.internal.play_billing.zzar zzi;
    private volatile zzbz zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    BillingClientImpl(String str, Context context, zzdd zzddVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = com.google.android.gms.internal.play_billing.zzcf.zzk();
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzM = lValueOf;
        this.zzN = com.google.android.gms.internal.play_billing.zzbf.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String strZzaO = zzaO();
        this.zzd = strZzaO;
        this.zzg = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(BuildConfig.VERSION_NAME);
        if (strZzaO != null) {
            zzkeVarZza.zzy(strZzaO);
        }
        zzkeVarZza.zzq(this.zzg.getPackageName());
        zzkeVarZza.zzd(lValueOf.longValue());
        zzkeVarZza.zzw(builder.zza);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        zzbA(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdr(this.zzg, (zzkg) zzkeVarZza.zzi());
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbq zzbqVar = builder.zzb;
        this.zzH = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, String str, zzdd zzddVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzkeVarZza.zzy(str2);
        }
        zzkeVarZza.zzq(this.zzg.getPackageName());
        zzkeVarZza.zzd(this.zzM.longValue());
        zzkeVarZza.zzw(builder.zza);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        zzbA(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzddVar != null) {
            this.zzh = zzddVar;
        } else {
            this.zzh = new zzdr(this.zzg, (zzkg) zzkeVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzz(this.zzg, purchasesUpdatedListener, null, userChoiceBillingListener, developerProvidedBillingListener, this.zzh);
        this.zzG = pendingPurchasesParams;
        this.zzI = userChoiceBillingListener != null;
        com.google.android.gms.internal.play_billing.zzbq zzbqVar = builder.zzb;
        this.zzH = builder.zza;
    }

    public static /* synthetic */ Object zzA(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        billingClientImpl.zzaL(billingConfigResponseListener);
        return null;
    }

    public static /* synthetic */ Void zzE(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaU(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzF(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        billingClientImpl.zzaT(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void zzG(BillingClientImpl billingClientImpl, BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i) throws Exception {
        billingClientImpl.zzaS(billingProgramAvailabilityListener, i);
        return null;
    }

    public static /* synthetic */ Void zzH(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener, LaunchExternalLinkParams launchExternalLinkParams, Activity activity) throws RemoteException {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!billingClientImpl.zzbx(zzdq.zzb())) {
                billingClientImpl.zzbk(launchExternalLinkResponseListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (billingClientImpl.zzD) {
                synchronized (billingClientImpl.zza) {
                    zzarVar = billingClientImpl.zzi;
                }
                if (zzarVar == null) {
                    billingClientImpl.zzbk(launchExternalLinkResponseListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = billingClientImpl.zzg.getPackageName();
                    String str = billingClientImpl.zzd;
                    long jLongValue = billingClientImpl.zzM.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, str, jLongValue);
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(launchExternalLinkParams.getLinkUri().toString());
                    zzijVarZza.zza("externalOfferUri", (zzjf) zzjdVarZza.zzi());
                    zzjd zzjdVarZza2 = zzjf.zza();
                    zzjdVarZza2.zza(String.valueOf(launchExternalLinkParams.getLaunchMode()));
                    zzijVarZza.zza("externalOfferLaunchMode", (zzjf) zzjdVarZza2.zzi());
                    zzjd zzjdVarZza3 = zzjf.zza();
                    zzjdVarZza3.zza(String.valueOf(launchExternalLinkParams.getLinkType()));
                    zzijVarZza.zza("externalOfferLinkType", (zzjf) zzjdVarZza3.zzi());
                    zzjd zzjdVarZza4 = zzjf.zza();
                    zzjdVarZza4.zza(String.valueOf(launchExternalLinkParams.getBillingProgram()));
                    zzijVarZza.zza("externalOfferBillingProgram", (zzjf) zzjdVarZza4.zzi());
                    if (!TextUtils.isEmpty(launchExternalLinkParams.getExternalTransactionToken())) {
                        zzjd zzjdVarZza5 = zzjf.zza();
                        zzjdVarZza5.zza(launchExternalLinkParams.getExternalTransactionToken());
                        zzijVarZza.zza("externalTransactionToken", (zzjf) zzjdVarZza5.zzi());
                    }
                    bundle.putByteArray("REQUEST_PARAMS", ((zzim) zzijVarZza.zzi()).zzQ());
                    zzarVar.zzp(27, packageName, bundle, new zzcf(billingClientImpl, new WeakReference(activity), launchExternalLinkResponseListener, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support launch external link.");
                billingClientImpl.zzbk(launchExternalLinkResponseListener, zzdh.zzH, zzjs.LAUNCH_EXTERNAL_LINK_NOT_SUPPORTED, null);
            }
        } catch (RuntimeException e) {
            billingClientImpl.zzbk(launchExternalLinkResponseListener, zzdh.zzh, zzjs.SERVICE_CALL_EXCEPTION, e);
        }
        return null;
    }

    public static /* synthetic */ Void zzI(BillingClientImpl billingClientImpl, BillingProgramInformationDialogListener billingProgramInformationDialogListener, BillingProgramInformationDialogParams billingProgramInformationDialogParams, Activity activity) throws Exception {
        billingClientImpl.zzaV(billingProgramInformationDialogListener, billingProgramInformationDialogParams, activity);
        return null;
    }

    public static /* synthetic */ Void zzJ(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        billingClientImpl.zzaR(externalOfferReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzK(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaW(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzL(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        billingClientImpl.zzaP(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzM(BillingClientImpl billingClientImpl, BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams) throws Exception {
        billingClientImpl.zzaQ(billingProgramReportingDetailsListener, billingProgramReportingDetailsParams);
        return null;
    }

    public static /* synthetic */ Void zzN(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!billingClientImpl.zzbx(zzdq.zzb())) {
                billingClientImpl.zzba(alternativeBillingOnlyAvailabilityListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (billingClientImpl.zzy) {
                synchronized (billingClientImpl.zza) {
                    zzarVar = billingClientImpl.zzi;
                }
                if (zzarVar == null) {
                    billingClientImpl.zzba(alternativeBillingOnlyAvailabilityListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzarVar.zzr(21, billingClientImpl.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(billingClientImpl.zzc, billingClientImpl.zzd, billingClientImpl.zzM.longValue()), new zzch(alternativeBillingOnlyAvailabilityListener, billingClientImpl.zzh, billingClientImpl.zzm, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                billingClientImpl.zzba(alternativeBillingOnlyAvailabilityListener, zzdh.zzD, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (Exception e) {
            billingClientImpl.zzba(alternativeBillingOnlyAvailabilityListener, e instanceof DeadObjectException ? zzdh.zzj : zzdh.zzh, zzjs.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        }
        return null;
    }

    static Future zzP(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzbb
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzR(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbE(zzjsVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzS(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbE(zzjsVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzca.zzk());
    }

    public static /* synthetic */ void zzT(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbE(zzjsVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzX(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbE(zzjsVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzaC(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            synchronized (this.zza) {
                zzarVar = this.zzi;
            }
            return zzarVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL) : zzarVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdh.zzj, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, zzdc.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdh.zzh, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, zzdc.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzaD(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            synchronized (this.zza) {
                zzarVar = this.zzi;
            }
            return zzarVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL) : zzarVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdh.zzj, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, zzdc.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdh.zzh, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, zzdc.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzaE() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzcl zzaF(BillingResult billingResult, zzjs zzjsVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        zzbG(zzjsVar, 7, billingResult, zzdc.zza(exc));
        return new zzcl(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzaG(int i) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzjn zzjnVarZza = zzjp.zza();
        zzjnVarZza.zze(6);
        zzll zzllVarZza = zzln.zza();
        zzllVarZza.zze(true);
        zzllVarZza.zza(i > 0);
        zzllVarZza.zzb(i);
        zzjnVarZza.zzd(zzllVarZza);
        zzbq((zzjp) zzjnVarZza.zzi());
        return zzdh.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaH() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzdh.zzj;
                }
            }
            return zzdh.zzh;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzdk zzaI(final int i) {
        if (this.zzH && !zzby()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzab
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return BillingClientImpl.zzu(this.zza, i, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzdf.zza(zzdh.zzi);
    }

    private final /* synthetic */ Object zzaJ(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdh.zzj;
                zzbE(zzjsVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzjs zzjsVar2 = zzjs.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzdh.zzg;
                zzbE(zzjsVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar != null) {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzd;
                    long jLongValue = this.zzM.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, str, jLongValue);
                    Bundle bundleZzd = zzarVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzdh.zza(com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzd, "BillingClient")));
                    return null;
                }
                zzaZ(acknowledgePurchaseResponseListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzjs zzjsVar3 = zzjs.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzdh.zza;
                zzbE(zzjsVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaZ(acknowledgePurchaseResponseListener, zzdh.zzj, zzjs.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaZ(acknowledgePurchaseResponseListener, zzdh.zzh, zzjs.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzaK(BillingChoiceInfoResponseListener billingChoiceInfoResponseListener, GetBillingChoiceInfoParams getBillingChoiceInfoParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzbb(billingChoiceInfoResponseListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzm < 24) {
                zzbb(billingChoiceInfoResponseListener, zzdh.zzK, zzjs.FEATURE_NOT_SUPPORTED, null);
            } else {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbb(billingChoiceInfoResponseListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    String str = this.zzc;
                    com.google.android.gms.internal.play_billing.zzes zzesVarZzb = zzdl.zzb(str, 24, this.zzg, zzdk.GET_BILLING_CHOICE_INFO_ASYNC.zza());
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(str);
                    zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
                    zzjd zzjdVarZza2 = zzjf.zza();
                    zzjdVarZza2.zza(this.zzg.getPackageName());
                    zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
                    zzjd zzjdVarZza3 = zzjf.zza();
                    zzjdVarZza3.zza(String.valueOf(getBillingChoiceInfoParams.getBillingProgram()));
                    zzijVarZza.zza("BILLING_PROGRAM", (zzjf) zzjdVarZza3.zzi());
                    if (getBillingChoiceInfoParams.getUserLocale() != null) {
                        zzjd zzjdVarZza4 = zzjf.zza();
                        zzjdVarZza4.zza(getBillingChoiceInfoParams.getUserLocale().toLanguageTag());
                        zzijVarZza.zza("LANGUAGE", (zzjf) zzjdVarZza4.zzi());
                    }
                    if (getBillingChoiceInfoParams.getPlayBillingChoiceImageLayout() != null) {
                        zzjd zzjdVarZza5 = zzjf.zza();
                        zzjdVarZza5.zza(getBillingChoiceInfoParams.getPlayBillingChoiceImageLayout());
                        zzijVarZza.zza("PLAY_BILLING_CHOICE_IMAGE_LAYOUT", (zzjf) zzjdVarZza5.zzi());
                    }
                    zzarVar.zzm(zzdl.zza(zzesVarZzb, (zzim) zzijVarZza.zzi()), new zzdv(billingChoiceInfoResponseListener, this.zzh, this.zzm));
                }
            }
        } catch (DeadObjectException e) {
            zzbb(billingChoiceInfoResponseListener, zzdh.zzj, zzjs.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbb(billingChoiceInfoResponseListener, zzdh.zzh, zzjs.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzaL(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!zzbx(zzdq.zzb())) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
                zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdh.zzj;
                zzbE(zzjsVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbj(billingConfigResponseListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else if (zzdq.zzj() && this.zzB) {
                    String str = this.zzc;
                    com.google.android.gms.internal.play_billing.zzes zzesVarZzb = zzdl.zzb(str, 24, this.zzg, zzdk.GET_BILLING_CONFIG.zza());
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(str);
                    zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
                    zzjd zzjdVarZza2 = zzjf.zza();
                    zzjdVarZza2.zza(this.zzg.getPackageName());
                    zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
                    Bundle bundleZza = zzdl.zza(zzesVarZzb, (zzim) zzijVarZza.zzi());
                    if (!TextUtils.isEmpty(null)) {
                        bundleZza.putString("accountName", null);
                    }
                    zzarVar.zzm(bundleZza, new zzdx(billingConfigResponseListener, this.zzh, this.zzm));
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str2 = this.zzd;
                    long jLongValue = this.zzM.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, str2, jLongValue);
                    if (!TextUtils.isEmpty(null)) {
                        bundle.putString("accountName", null);
                    }
                    zzarVar.zzo(18, packageName, bundle, new zzcd(billingConfigResponseListener, this.zzh, this.zzm, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                zzjs zzjsVar2 = zzjs.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzdh.zzz;
                zzbE(zzjsVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzbj(billingConfigResponseListener, zzdh.zzj, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbj(billingConfigResponseListener, zzdh.zzh, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzaM(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            synchronized (this.zza) {
                zzarVar = this.zzi;
            }
            if (zzarVar == null) {
                zzbn(-1, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzarVar.zzt(12, this.zzg.getPackageName(), bundle, new zzcj(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbn(-1, zzjs.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbn(6, zzjs.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzaN(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaO() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final /* synthetic */ Void zzaP(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzarVar.zzk(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzM.longValue()), new zzca(alternativeBillingOnlyReportingDetailsListener, this.zzh, this.zzm, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzD, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzj, zzjs.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzh, zzjs.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x012e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final /* synthetic */ java.lang.Void zzaQ(com.android.billingclient.api.BillingProgramReportingDetailsListener r11, com.android.billingclient.api.BillingProgramReportingDetailsParams r12) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzaQ(com.android.billingclient.api.BillingProgramReportingDetailsListener, com.android.billingclient.api.BillingProgramReportingDetailsParams):java.lang.Void");
    }

    private final /* synthetic */ Void zzaR(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzbg(externalOfferReportingDetailsListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzz) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbg(externalOfferReportingDetailsListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    long j = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime;
                    String str = this.zzd;
                    long jLongValue = this.zzM.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, str, jLongValue);
                    bundle.putLong("appInstallTimeMillis", j);
                    zzarVar.zzl(22, packageName, bundle, new zzcb(externalOfferReportingDetailsListener, this.zzh, this.zzm, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzbg(externalOfferReportingDetailsListener, zzdh.zzu, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzbg(externalOfferReportingDetailsListener, zzdh.zzj, zzjs.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbg(externalOfferReportingDetailsListener, zzdh.zzh, zzjs.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaS(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i) throws Exception {
        BillingClientImpl billingClientImpl;
        BillingProgramAvailabilityListener billingProgramAvailabilityListener2;
        int i2;
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            if (zzbx(zzdq.zzb())) {
                billingClientImpl = this;
                billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                i2 = i;
                try {
                    if (!billingClientImpl.zzD) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support the provided billing program.");
                        billingClientImpl.zzbc(billingProgramAvailabilityListener2, i2, zzdh.zzG, zzjs.BILLING_PROGRAM_NOT_SUPPORTED, null);
                        return null;
                    }
                    synchronized (billingClientImpl.zza) {
                        zzarVar = billingClientImpl.zzi;
                    }
                    if (zzarVar == null) {
                        billingClientImpl.zzbc(billingProgramAvailabilityListener2, i2, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                        return null;
                    }
                    String str = billingClientImpl.zzc;
                    com.google.android.gms.internal.play_billing.zzes zzesVarZzb = zzdl.zzb(str, 24, billingClientImpl.zzg, zzdk.IS_BILLING_PROGRAM_AVAILABLE_ASYNC.zza());
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(str);
                    zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
                    zzjd zzjdVarZza2 = zzjf.zza();
                    zzjdVarZza2.zza(billingClientImpl.zzg.getPackageName());
                    zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
                    zzjd zzjdVarZza3 = zzjf.zza();
                    zzjdVarZza3.zza(String.valueOf(i2));
                    zzijVarZza.zza("BILLING_PROGRAM", (zzjf) zzjdVarZza3.zzi());
                    try {
                        zzarVar.zzm(zzdl.zza(zzesVarZzb, (zzim) zzijVarZza.zzi()), new IsBillingProgramAvailableDelegateToBackendCallback(billingProgramAvailabilityListener2, i2, billingClientImpl.zzh, billingClientImpl.zzm, billingClientImpl.zzaE(), billingClientImpl.zzO()));
                        return null;
                    } catch (DeadObjectException e) {
                        e = e;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                        i2 = i2;
                    } catch (Exception e2) {
                        e = e2;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                        i2 = i2;
                        billingClientImpl.zzbc(billingProgramAvailabilityListener2, i2, zzdh.zzh, zzjs.SERVICE_CALL_EXCEPTION, e);
                        return null;
                    }
                } catch (DeadObjectException e3) {
                    e = e3;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                try {
                    zzbc(billingProgramAvailabilityListener, i, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                    return null;
                } catch (DeadObjectException e5) {
                    e = e5;
                    billingClientImpl = this;
                    billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                    i2 = i;
                } catch (Exception e6) {
                    e = e6;
                    billingClientImpl = this;
                    billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                    i2 = i;
                    billingClientImpl.zzbc(billingProgramAvailabilityListener2, i2, zzdh.zzh, zzjs.SERVICE_CALL_EXCEPTION, e);
                    return null;
                }
            }
        } catch (DeadObjectException e7) {
            e = e7;
            billingClientImpl = this;
            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
            i2 = i;
        } catch (Exception e8) {
            e = e8;
            billingClientImpl = this;
            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
            i2 = i;
        }
        billingClientImpl.zzbc(billingProgramAvailabilityListener2, i2, zzdh.zzj, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        return null;
    }

    private final /* synthetic */ Void zzaT(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        zzcm zzcmVar = null;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzbh(externalOfferAvailabilityListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzB) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbh(externalOfferAvailabilityListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzarVar.zzs(24, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzM.longValue()), new zzci(externalOfferAvailabilityListener, this.zzh, this.zzm, zzcmVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzbh(externalOfferAvailabilityListener, zzdh.zzu, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzbh(externalOfferAvailabilityListener, zzdh.zzj, zzjs.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbh(externalOfferAvailabilityListener, zzdh.zzh, zzjs.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaU(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            synchronized (this.zza) {
                zzarVar = this.zzi;
            }
            if (zzarVar == null) {
                zzbl(alternativeBillingOnlyInformationDialogListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzarVar.zzn(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzM.longValue()), new zzcc(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbl(alternativeBillingOnlyInformationDialogListener, zzdh.zzj, zzjs.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbl(alternativeBillingOnlyInformationDialogListener, zzdh.zzh, zzjs.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaV(BillingProgramInformationDialogListener billingProgramInformationDialogListener, BillingProgramInformationDialogParams billingProgramInformationDialogParams, Activity activity) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            if (!zzbx(zzdq.zzb())) {
                zzbm(billingProgramInformationDialogListener, zzdh.zzj, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzF) {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    zzbm(billingProgramInformationDialogListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzd;
                    long jLongValue = this.zzM.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, str, jLongValue);
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(String.valueOf(billingProgramInformationDialogParams.getBillingProgram()));
                    zzijVarZza.zza("developerBillingProgram", (zzjf) zzjdVarZza.zzi());
                    if (billingProgramInformationDialogParams.getExternalTransactionToken() != null) {
                        zzjd zzjdVarZza2 = zzjf.zza();
                        zzjdVarZza2.zza(billingProgramInformationDialogParams.getExternalTransactionToken());
                        zzijVarZza.zza("externalTransactionToken", (zzjf) zzjdVarZza2.zzi());
                    }
                    bundle.putByteArray("REQUEST_PARAMS", ((zzim) zzijVarZza.zzi()).zzQ());
                    zzarVar.zzn(28, packageName, bundle, new zzck(new WeakReference(activity), new zzbn(this, this.zze, billingProgramInformationDialogListener), null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support showBillingProgramInformationDialog.");
                zzbm(billingProgramInformationDialogListener, zzdh.zzJ, zzjs.FEATURE_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzbm(billingProgramInformationDialogListener, zzdh.zzj, zzjs.SERVICE_CALL_EXCEPTION, e);
        } catch (RuntimeException e2) {
            zzbm(billingProgramInformationDialogListener, zzdh.zzh, zzjs.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaW(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        try {
            synchronized (this.zza) {
                zzarVar = this.zzi;
            }
            if (zzarVar == null) {
                zzbi(externalOfferInformationDialogListener, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzarVar.zzp(22, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzM.longValue()), new zzce(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbi(externalOfferInformationDialogListener, zzdh.zzj, zzjs.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbi(externalOfferInformationDialogListener, zzdh.zzh, zzjs.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final Future zzaX(Callable callable, long j, final Runnable runnable, Handler handler) throws Exception {
        try {
            final Future futureSubmit = zzO().submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzbm
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    runnable2.run();
                }
            }, 28500L);
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task throws exception!", e);
            throw e;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0094 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzaY(com.android.billingclient.api.ConsumeParams r9, com.android.billingclient.api.ConsumeResponseListener r10) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "Consuming purchase with token: "
            java.lang.String r3 = r9.getPurchaseToken()
            java.lang.String r9 = "BillingClient"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            r1.<init>(r0)     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            r1.append(r3)     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            com.google.android.gms.internal.play_billing.zzc.zzm(r9, r0)     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            java.lang.Object r9 = r8.zza     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            monitor-enter(r9)     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            com.google.android.gms.internal.play_billing.zzar r0 = r8.zzi     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L8e
            if (r0 != 0) goto L2c
            com.android.billingclient.api.BillingResult r4 = com.android.billingclient.api.zzdh.zzj     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            com.google.android.gms.internal.play_billing.zzjs r5 = com.google.android.gms.internal.play_billing.zzjs.SERVICE_RESET_TO_NULL     // Catch: java.lang.Exception -> L96 android.os.DeadObjectException -> La5
            java.lang.String r6 = "Service has been reset to null."
            r7 = 0
            r1 = r8
            r2 = r10
            r1.zzbd(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            return
        L2c:
            r1 = r8
            r2 = r10
            boolean r8 = r1.zzp     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            android.content.Context r9 = r1.zzg
            if (r8 == 0) goto L61
            java.lang.String r8 = r9.getPackageName()     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            boolean r9 = r1.zzp     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r10 = r1.zzd     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.Long r4 = r1.zzM     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r6 = "9.1.0"
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            r7.<init>()     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            if (r9 == 0) goto L4e
            com.google.android.gms.internal.play_billing.zzc.zzc(r7, r6, r10, r4)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
        L4e:
            r9 = 9
            android.os.Bundle r8 = r0.zze(r9, r8, r3, r7)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r9 = "RESPONSE_CODE"
            int r9 = r8.getInt(r9)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r10 = "BillingClient"
            java.lang.String r8 = com.google.android.gms.internal.play_billing.zzc.zzj(r8, r10)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            goto L6c
        L61:
            java.lang.String r8 = r9.getPackageName()     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            r9 = 3
            int r9 = r0.zza(r9, r8, r3)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r8 = ""
        L6c:
            com.android.billingclient.api.BillingResult r4 = com.android.billingclient.api.zzdh.zza(r9, r8)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            if (r9 != 0) goto L7d
            java.lang.String r8 = "BillingClient"
            java.lang.String r9 = "Successfully consumed purchase."
            com.google.android.gms.internal.play_billing.zzc.zzm(r8, r9)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            r2.onConsumeResponse(r4, r3)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            return
        L7d:
            com.google.android.gms.internal.play_billing.zzjs r5 = com.google.android.gms.internal.play_billing.zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            java.lang.String r8 = "Error consuming purchase with token. Response code: "
            java.lang.String r6 = com.android.billingclient.api.zza.zza(r9, r8)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            r7 = 0
            r1.zzbd(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
            return
        L8a:
            r0 = move-exception
            goto L99
        L8c:
            r0 = move-exception
            goto La8
        L8e:
            r0 = move-exception
            r1 = r8
            r2 = r10
        L91:
            r8 = r0
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L94
            throw r8     // Catch: java.lang.Exception -> L8a android.os.DeadObjectException -> L8c
        L94:
            r0 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r1 = r8
            r2 = r10
        L99:
            r8 = r0
            r7 = r8
            com.android.billingclient.api.BillingResult r4 = com.android.billingclient.api.zzdh.zzh
            com.google.android.gms.internal.play_billing.zzjs r5 = com.google.android.gms.internal.play_billing.zzjs.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION
            java.lang.String r6 = "Error consuming purchase!"
            r1.zzbd(r2, r3, r4, r5, r6, r7)
            return
        La5:
            r0 = move-exception
            r1 = r8
            r2 = r10
        La8:
            r8 = r0
            r7 = r8
            com.android.billingclient.api.BillingResult r4 = com.android.billingclient.api.zzdh.zzj
            com.google.android.gms.internal.play_billing.zzjs r5 = com.google.android.gms.internal.play_billing.zzjs.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION
            java.lang.String r6 = "Error consuming purchase!"
            r1.zzbd(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzaY(com.android.billingclient.api.ConsumeParams, com.android.billingclient.api.ConsumeResponseListener):void");
    }

    private final void zzaZ(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbG(zzjsVar, 3, billingResult, zzdc.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzaa(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbE(zzjsVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzca.zzk(), com.google.android.gms.internal.play_billing.zzca.zzk()));
    }

    public static /* synthetic */ void zzac(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zze() != null) {
            billingClientImpl.zzf.zze().onPurchasesUpdated(billingResult, null);
        } else {
            zzz zzzVar = billingClientImpl.zzf;
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    static /* bridge */ /* synthetic */ void zzat(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzF = i >= 29;
        billingClientImpl.zzE = i >= 28;
        billingClientImpl.zzD = i >= 27;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    static /* bridge */ /* synthetic */ void zzav(BillingClientImpl billingClientImpl, int i) {
        if (i != 0) {
            billingClientImpl.zzbs(0);
            return;
        }
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzbs(2);
            zzz zzzVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
            if (zzzVar != null) {
                zzzVar.zzi(billingClientImpl.zzy);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzaz(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    private static final void zzbA(zzke zzkeVar, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                zzkeVar.zzv((int) (memoryInfo.totalMem / 1048576));
                zzkeVar.zzr(Build.BRAND);
                zzkeVar.zzu(Build.MODEL);
                zzkeVar.zzt(Build.MANUFACTURER);
                zzkeVar.zzs(Build.FINGERPRINT);
            }
        } catch (RuntimeException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Runtime error while populating device info.", e);
        }
    }

    private final zzek zzbB(int i, BillingResult billingResult, zzjs zzjsVar, String str, Exception exc) {
        zzbG(zzjsVar, 9, billingResult, zzdc.zza(exc));
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        return new zzek(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0184  */
    /* JADX WARN: Code duplicated, block: B:70:0x019f  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f4  */
    public final zzek zzbC(String str, boolean z, int i) {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        int i2;
        int i3;
        Bundle bundleZzi;
        BillingResult billingResultBuild;
        zzjs zzjsVar;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        int i4;
        boolean z2;
        Purchase purchase;
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = this.zzp;
        boolean z4 = this.zzw;
        boolean zIsEnabledForOneTimeProducts = this.zzG.isEnabledForOneTimeProducts();
        boolean zIsEnabledForPrepaidPlans = this.zzG.isEnabledForPrepaidPlans();
        long jLongValue = this.zzM.longValue();
        Bundle bundle = new Bundle();
        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, BuildConfig.VERSION_NAME, this.zzd, jLongValue);
        if (z3 && zIsEnabledForOneTimeProducts) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z4 && zIsEnabledForPrepaidPlans) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z) {
            bundle.putBoolean("includeSuspendedSubscriptions", true);
        }
        String string = null;
        do {
            try {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    return zzbB(9, zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (z && !this.zzC) {
                    return zzbB(9, zzdh.zzx, zzjs.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, "Include suspended subscriptions is not supported", null);
                }
                if (this.zzp) {
                    if (this.zzC) {
                        i3 = 26;
                    } else if (this.zzB) {
                        i3 = 24;
                    } else {
                        if (this.zzw) {
                            i3 = 19;
                        } else {
                            i2 = 9;
                        }
                        bundleZzi = zzarVar.zzi(i2, this.zzg.getPackageName(), str, string, bundle);
                    }
                    i2 = i3;
                    bundleZzi = zzarVar.zzi(i2, this.zzg.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzarVar.zzh(3, this.zzg.getPackageName(), str, string);
                }
                BillingResult billingResult = zzdh.zzh;
                if (bundleZzi == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s got null owned items list", "getPurchase()"));
                    zzjsVar = zzjs.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzi, "BillingClient");
                    String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzi, "BillingClient");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(iZzb);
                    builderNewBuilder.setDebugMessage(strZzj);
                    billingResultBuild = builderNewBuilder.build();
                    if (iZzb != 0) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iZzb)));
                        zzjsVar = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList4 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                            zzjsVar = zzjs.NULL_SKUS_LIST;
                        } else if (stringArrayList5 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            zzjsVar = zzjs.NULL_PURCHASES_LIST;
                        } else if (stringArrayList6 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            zzjsVar = zzjs.NULL_SIGNATURES_LIST;
                        } else {
                            billingResultBuild = zzdh.zzi;
                            zzjsVar = zzjs.REASON_UNSPECIFIED;
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                        zzjsVar = zzjs.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (billingResultBuild != zzdh.zzi) {
                        return zzbB(9, billingResultBuild, zzjsVar, "Purchase bundle invalid", null);
                    }
                    stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    z2 = false;
                    for (i4 = 0; i4 < stringArrayList2.size(); i4++) {
                        String str2 = stringArrayList2.get(i4);
                        String str3 = stringArrayList3.get(i4);
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                        try {
                            purchase = new Purchase(str2, str3);
                            this.zzJ.isEmpty();
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "BUG: empty/null token!");
                                z2 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return zzbB(9, zzdh.zzh, zzjs.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    if (z2) {
                        zzbE(zzjs.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                }
                billingResultBuild = billingResult;
                if (billingResultBuild != zzdh.zzi) {
                    return zzbB(9, billingResultBuild, zzjsVar, "Purchase bundle invalid", null);
                }
                stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z2 = false;
                while (i4 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i4);
                    String str5 = stringArrayList3.get(i4);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                    purchase = new Purchase(str4, str5);
                    this.zzJ.isEmpty();
                    if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "BUG: empty/null token!");
                        z2 = true;
                    }
                    arrayList.add(purchase);
                }
                if (z2) {
                    zzbE(zzjs.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e2) {
                return zzbB(9, zzdh.zzj, zzjs.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return zzbB(9, zzdh.zzh, zzjs.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzek(zzdh.zzi, arrayList);
    }

    private final void zzbD(BillingResult billingResult, zzjs zzjsVar, int i) {
        zzjp zzjpVar = null;
        zzjl zzjlVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i2 = zzdc.zza;
            try {
                zzjn zzjnVarZza = zzjp.zza();
                zzjnVarZza.zze(5);
                zzkk zzkkVarZza = zzkn.zza();
                zzkkVarZza.zza(i);
                zzjnVarZza.zzb((zzkn) zzkkVarZza.zzi());
                zzjpVar = (zzjp) zzjnVarZza.zzi();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            }
            zzbq(zzjpVar);
            return;
        }
        int i3 = zzdc.zza;
        try {
            zzjj zzjjVarZza = zzjl.zza();
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(billingResult.getResponseCode());
            zzjqVarZza.zzb(billingResult.getDebugMessage());
            zzjqVarZza.zze(zzjsVar);
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(5);
            zzkk zzkkVarZza2 = zzkn.zza();
            zzkkVarZza2.zza(i);
            zzjjVarZza.zzc((zzkn) zzkkVarZza2.zzi());
            zzjlVar = (zzjl) zzjjVarZza.zzi();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e2);
        }
        zzbo(zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbE(zzjs zzjsVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzdc.zza;
            zzbo(zzdc.zzb(zzjsVar, i, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbF(zzjs zzjsVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzdc.zza;
            try {
                this.zzh.zzc(zzdc.zzb(zzjsVar, 2, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    private final void zzbG(zzjs zzjsVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzdc.zza;
            zzbo(zzdc.zzb(zzjsVar, i, billingResult, str, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbH(zzjs zzjsVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzdc.zza;
            zzbp(zzdc.zzb(zzjsVar, 2, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbI(zzjs zzjsVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzdc.zza;
            zzbp(zzdc.zzb(zzjsVar, 2, billingResult, str, zzjz.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbJ(int i) {
        try {
            int i2 = zzdc.zza;
            zzbq(zzdc.zzc(i, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 14, billingResult, zzdc.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbb(BillingChoiceInfoResponseListener billingChoiceInfoResponseListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingChoiceInfo got an exception.", exc);
        zzbG(zzjsVar, 40, billingResult, zzdc.zza(exc));
        billingChoiceInfoResponseListener.onBillingChoiceInfoResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 33, billingResult, zzdc.zza(exc));
        billingProgramAvailabilityListener.onBillingProgramAvailabilityResponse(billingResult, new BillingProgramAvailabilityDetails(i));
    }

    private final void zzbd(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzjs zzjsVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str2, exc);
        zzbG(zzjsVar, 4, billingResult, zzdc.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbe(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 15, billingResult, zzdc.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 35, billingResult, zzdc.zza(exc));
        billingProgramReportingDetailsListener.onCreateBillingProgramReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbg(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 24, billingResult, zzdc.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbh(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 23, billingResult, zzdc.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbi(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 25, billingResult, zzdc.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzbj(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        zzbG(zzjsVar, 13, billingResult, zzdc.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbk(LaunchExternalLinkResponseListener launchExternalLinkResponseListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 37, billingResult, zzdc.zza(exc));
        launchExternalLinkResponseListener.onLaunchExternalLinkResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbl(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 16, billingResult, zzdc.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbm(BillingProgramInformationDialogListener billingProgramInformationDialogListener, BillingResult billingResult, zzjs zzjsVar, Exception exc) {
        zzbG(zzjsVar, 39, billingResult, zzdc.zza(exc));
        billingProgramInformationDialogListener.onBillingProgramInformationDialogResponse(billingResult);
    }

    private final void zzbn(int i, zzjs zzjsVar, Exception exc) {
        zzjl zzjlVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        zzdd zzddVar = this.zzh;
        String strZza = zzdc.zza(exc);
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(i);
            if (zzjsVar != null) {
                zzjqVarZza.zze(zzjsVar);
            }
            if (strZza != null) {
                zzjqVarZza.zza(strZza);
            }
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(30);
            zzjlVar = (zzjl) zzjjVarZza.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzjlVar = null;
        }
        zzddVar.zza(zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbo(zzjl zzjlVar) {
        try {
            this.zzh.zzb(zzjlVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbp(zzjl zzjlVar, long j, boolean z) {
        try {
            this.zzh.zze(zzjlVar, this.zzm, j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbq(zzjp zzjpVar) {
        try {
            this.zzh.zzg(zzjpVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbr(zzjs zzjsVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzdc.zza;
            zzjj zzjjVar = (zzjj) zzdc.zzb(zzjsVar, 6, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzq();
            zzll zzllVarZza = zzln.zza();
            zzllVarZza.zza(i > 0);
            zzllVarZza.zzb(i);
            zzjjVar.zze(zzllVarZza);
            zzbo((zzjl) zzjjVar.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbs(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Setting clientState from " + zzbz(this.zzb) + " to " + zzbz(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzbt() {
        ExecutorService executorService = this.zzL;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzL = null;
        }
    }

    private final void zzbu(BillingClientStateListener billingClientStateListener, int i) {
        zzjs zzjsVar;
        BillingResult billingResultZzaG;
        BillingResult billingResult;
        synchronized (this.zza) {
            if (zzby()) {
                billingResultZzaG = zzaG(i);
            } else {
                if (this.zzb == 1) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                    zzjs zzjsVar2 = zzjs.BILLING_CLIENT_CONNECTING;
                    billingResult = zzdh.zzd;
                    zzbr(zzjsVar2, billingResult, i);
                } else if (this.zzb == 3) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    zzjs zzjsVar3 = zzjs.BILLING_CLIENT_CLOSED;
                    billingResult = zzdh.zzj;
                    zzbr(zzjsVar3, billingResult, i);
                } else {
                    zzbs(1);
                    if (i == 0) {
                        this.zzK = billingClientStateListener;
                        i = 0;
                    }
                    zzbv();
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbz(this, billingClientStateListener, i, null);
                    this.zzj.zzf();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> listQueryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        zzjsVar = zzjs.INTENT_SERVICE_NOT_FOUND;
                    } else {
                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                        if (resolveInfo.serviceInfo != null) {
                            String str = resolveInfo.serviceInfo.packageName;
                            String str2 = resolveInfo.serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zzjsVar = zzjs.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    if (this.zzb == 2) {
                                        billingResultZzaG = zzaG(i);
                                    } else if (this.zzb != 1) {
                                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                        zzjs zzjsVar4 = zzjs.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                        billingResult = zzdh.zzj;
                                        zzbr(zzjsVar4, billingResult, i);
                                    } else {
                                        zzbz zzbzVar = this.zzj;
                                        if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.zzg.bindService(intent2, zzbzVar, 1) : this.zzg.bindService(intent2, 1, zzO(), zzbzVar)) {
                                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service was bonded successfully.");
                                            billingResultZzaG = null;
                                        } else {
                                            zzjsVar = zzjs.BILLING_SERVICE_BLOCKED;
                                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                        }
                                    }
                                }
                            }
                        } else {
                            zzjsVar = zzjs.INVALID_PHONESKY_PACKAGE;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzbs(0);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service unavailable on device.");
                    BillingResult billingResult2 = zzdh.zzb;
                    zzbr(zzjsVar, billingResult2, i);
                    billingResultZzaG = billingResult2;
                }
                billingResultZzaG = billingResult;
            }
        }
        if (billingResultZzaG != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzaG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbv() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                try {
                    this.zzg.unbindService(this.zzj);
                    this.zzi = null;
                    this.zzj = null;
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzi = null;
                        this.zzj = null;
                    } catch (Throwable th2) {
                        this.zzi = null;
                        this.zzj = null;
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzbw(long j) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                j = 0;
            }
            BillingResult billingResult = (BillingResult) zzaI(1).get(j, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzby();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzbx(long j) {
        com.google.android.gms.internal.play_billing.zzbn zzbnVarZzb = com.google.android.gms.internal.play_billing.zzbn.zzb(this.zzN);
        int iZza = zzdq.zza();
        long jZza = j;
        for (int i = 1; i <= iZza; i++) {
            try {
                long jMax = Math.max(0L, jZza);
                if (jMax <= 0) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                    return zzby();
                }
                BillingResult billingResult = (BillingResult) zzaI(i).get(jMax, TimeUnit.MILLISECONDS);
                if (billingResult.getResponseCode() == 0) {
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                    return zzby();
                }
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
                jZza = j - zzbnVarZzb.zza(TimeUnit.MILLISECONDS);
                long jPow = ((long) Math.pow(2.0d, i - 1)) * 1000;
                if (jZza < jPow) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return zzby();
                }
                if (i < iZza && jPow > 0) {
                    try {
                        Thread.sleep(jPow);
                        jZza = j - zzbnVarZzb.zza(TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e);
                    }
                }
            } catch (Exception e2) {
                if (e2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e2);
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Max retries reached.");
        return zzby();
    }

    private final boolean zzby() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                z = true;
            }
        }
        return z;
    }

    private static final String zzbz(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i != 1) {
            return i != 2 ? "CLOSED" : "CONNECTED";
        }
        return "CONNECTING";
    }

    static /* bridge */ /* synthetic */ ResultReceiver zzg(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        return new zzbw(billingClientImpl, billingClientImpl.zze, launchExternalLinkResponseListener);
    }

    static /* bridge */ /* synthetic */ BillingResult zzn(Exception exc) {
        return exc instanceof DeadObjectException ? zzdh.zzj : zzdh.zzh;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, int i, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.zzbu(new zzbv(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, BillingChoiceInfoResponseListener billingChoiceInfoResponseListener, GetBillingChoiceInfoParams getBillingChoiceInfoParams) throws Exception {
        billingClientImpl.zzaK(billingChoiceInfoResponseListener, getBillingChoiceInfoParams);
        return null;
    }

    public static /* synthetic */ Object zzw(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) throws Throwable {
        if (billingClientImpl.zzbx(zzdq.zzb())) {
            billingClientImpl.zzaY(consumeParams, consumeResponseListener);
            return null;
        }
        zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzdh.zzj;
        billingClientImpl.zzbE(zzjsVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        return null;
    }

    public static /* synthetic */ Object zzx(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        if (!billingClientImpl.zzbx(zzdq.zzb())) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdh.zzj;
            billingClientImpl.zzbE(zzjsVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzca.zzk(), com.google.android.gms.internal.play_billing.zzca.zzk()));
            return null;
        }
        if (billingClientImpl.zzu) {
            zzcl zzclVarZzi = billingClientImpl.zzi(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzdh.zza(zzclVarZzi.zza(), zzclVarZzi.zzb()), new QueryProductDetailsResult(zzclVarZzi.zzc(), zzclVarZzi.zzd()));
            return null;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Querying product details is not supported.");
        zzjs zzjsVar2 = zzjs.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzdh.zzs;
        billingClientImpl.zzbE(zzjsVar2, 7, billingResult2);
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzca.zzk(), com.google.android.gms.internal.play_billing.zzca.zzk()));
        return null;
    }

    public static /* synthetic */ Object zzy(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        billingClientImpl.zzaJ(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzz(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaM(bundle, activity, resultReceiver);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzy(this.zza, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzX(this.zza, acknowledgePurchaseResponseListener);
            }
        }, zzaE(), zzO()) == null) {
            BillingResult billingResultZzaH = zzaH();
            zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, billingResultZzaH);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzaH);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzbc
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                BillingClientImpl.zzw(this.zza, consumeResponseListener, consumeParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbd
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzR(this.zza, consumeResponseListener, consumeParams);
            }
        }, zzaE(), zzO()) == null) {
            BillingResult billingResultZzaH = zzaH();
            zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, billingResultZzaH);
            consumeResponseListener.onConsumeResponse(billingResultZzaH, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzax
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzL(this.zza, alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzay
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbe(alternativeBillingOnlyReportingDetailsListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzbe(alternativeBillingOnlyReportingDetailsListener, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createBillingProgramReportingDetailsAsync(final BillingProgramReportingDetailsParams billingProgramReportingDetailsParams, final BillingProgramReportingDetailsListener billingProgramReportingDetailsListener) {
        BillingClientImpl billingClientImpl;
        try {
            billingClientImpl = this;
            try {
                billingClientImpl.zzaX(new Callable() { // from class: com.android.billingclient.api.zzaq
                    @Override // java.util.concurrent.Callable
                    public final Object call() throws Exception {
                        BillingClientImpl.zzM(this.zza, billingProgramReportingDetailsListener, billingProgramReportingDetailsParams);
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzbf(billingProgramReportingDetailsListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                    }
                }, zzaE());
            } catch (Exception e) {
                e = e;
                billingClientImpl.zzbf(billingProgramReportingDetailsListener, billingClientImpl.zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, e);
            }
        } catch (Exception e2) {
            e = e2;
            billingClientImpl = this;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzav
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzJ(this.zza, externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbe
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbg(externalOfferReportingDetailsListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzbg(externalOfferReportingDetailsListener, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbJ(12);
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    this.zzf.zzh();
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                        zzbv();
                    } catch (Throwable th) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                    }
                    try {
                        zzbt();
                    } catch (Throwable th2) {
                        try {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th2);
                        } catch (Throwable th3) {
                            zzbs(3);
                            this.zzK = null;
                            throw th3;
                        }
                    }
                    zzbs(3);
                    this.zzK = null;
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                    zzbv();
                    zzbt();
                    zzbs(3);
                    this.zzK = null;
                }
            } catch (Throwable th4) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while shutting down broadcast manager while ending connection!", th4);
            }
            throw th;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzas
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzA(this.zza, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzat
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzT(this.zza, billingConfigResponseListener);
            }
        }, zzaE(), zzO()) == null) {
            BillingResult billingResultZzaH = zzaH();
            zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, billingResultZzaH);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzaH, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzaz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzN(this.zza, alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzba
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzba(alternativeBillingOnlyAvailabilityListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzba(alternativeBillingOnlyAvailabilityListener, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isBillingProgramAvailableAsync(final int i, final BillingProgramAvailabilityListener billingProgramAvailabilityListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzao
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzG(this.zza, billingProgramAvailabilityListener, i);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzap
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbc(billingProgramAvailabilityListener, i, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzbc(billingProgramAvailabilityListener, i, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzF(this.zza, externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbh(externalOfferAvailabilityListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzbh(externalOfferAvailabilityListener, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!zzbw(zzdq.zzc())) {
            BillingResult billingResult = zzdh.zzj;
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbE(zzjsVar, 5, billingResult);
                return billingResult;
            }
            zzbJ(5);
            return billingResult;
        }
        int i = zzdh.zzL;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    BillingResult billingResult2 = this.zzl ? zzdh.zzi : zzdh.zzm;
                    zzbD(billingResult2, zzjs.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return billingResult2;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult3 = this.zzs ? zzdh.zzi : zzdh.zzo;
                    zzbD(billingResult3, zzjs.CROSS_APP_NOT_SUPPORTED, 6);
                    return billingResult3;
                }
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    BillingResult billingResult4 = this.zzq ? zzdh.zzi : zzdh.zzt;
                    zzbD(billingResult4, zzjs.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return billingResult4;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult5 = this.zzt ? zzdh.zzi : zzdh.zzp;
                    zzbD(billingResult5, zzjs.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return billingResult5;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult6 = this.zzr ? zzdh.zzi : zzdh.zzq;
                    zzbD(billingResult6, zzjs.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return billingResult6;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult7 = this.zzt ? zzdh.zzi : zzdh.zzp;
                    zzbD(billingResult7, zzjs.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return billingResult7;
                }
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    BillingResult billingResult8 = this.zzu ? zzdh.zzi : zzdh.zzs;
                    zzbD(billingResult8, zzjs.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return billingResult8;
                }
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    BillingResult billingResult9 = this.zzv ? zzdh.zzi : zzdh.zzz;
                    zzbD(billingResult9, zzjs.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return billingResult9;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult10 = this.zzv ? zzdh.zzi : zzdh.zzA;
                    zzbD(billingResult10, zzjs.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return billingResult10;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult11 = this.zzx ? zzdh.zzi : zzdh.zzC;
                    zzbD(billingResult11, zzjs.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return billingResult11;
                }
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    BillingResult billingResult12 = this.zzy ? zzdh.zzi : zzdh.zzD;
                    zzbD(billingResult12, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return billingResult12;
                }
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    BillingResult billingResult13 = this.zzB ? zzdh.zzi : zzdh.zzu;
                    zzbD(billingResult13, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED, 18);
                    return billingResult13;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult14 = this.zzA ? zzdh.zzi : zzdh.zzv;
                    zzbD(billingResult14, zzjs.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return billingResult14;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    BillingResult billingResult15 = this.zzB ? zzdh.zzi : zzdh.zzw;
                    zzbD(billingResult15, zzjs.AUTO_PAY_NOT_SUPPORTED, 20);
                    return billingResult15;
                }
                break;
            case 109230:
                if (str.equals(BillingClient.FeatureType.INCLUDE_SUSPENDED_SUBSCRIPTIONS)) {
                    BillingResult billingResult16 = this.zzC ? zzdh.zzi : zzdh.zzx;
                    zzbD(billingResult16, zzjs.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return billingResult16;
                }
                break;
            case 110223:
                if (str.equals("ooo")) {
                    BillingResult billingResult17 = this.zzE ? zzdh.zzi : zzdh.zzr;
                    zzbD(billingResult17, zzjs.GIFT_CODE_PURCHASE_NOT_SUPPORTED, 22);
                    return billingResult17;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    BillingResult billingResult18 = this.zzo ? zzdh.zzi : zzdh.zzn;
                    zzbD(billingResult18, zzjs.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return billingResult18;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    BillingResult billingResult19 = this.zzk ? zzdh.zzi : zzdh.zzl;
                    zzbD(billingResult19, zzjs.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return billingResult19;
                }
                break;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
        BillingResult billingResult20 = zzdh.zzy;
        zzbD(billingResult20, zzjs.UNKNOWN_FEATURE, 1);
        return billingResult20;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzH) {
            return true;
        }
        return zzby();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean zZzg;
        long j;
        Future futureZzP;
        ?? r5;
        zzjs zzjsVarZzb;
        String string;
        Object obj;
        boolean z;
        int i;
        long jNextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zze() == null) {
            zzjs zzjsVar = zzjs.MISSING_LISTENER;
            BillingResult billingResult = zzdh.zzE;
            zzbF(zzjsVar, 2, billingResult, jNextLong);
            return billingResult;
        }
        if (billingFlowParams.getDeveloperBillingOptionParams() != null && this.zzf.zzc() == null) {
            zzjs zzjsVar2 = zzjs.MISSING_DEVELOPER_PROVIDED_BILLING_LISTENER;
            BillingResult billingResult2 = zzdh.zzI;
            zzbF(zzjsVar2, 2, billingResult2, jNextLong);
            return billingResult2;
        }
        if (!zzbw(zzdq.zzc())) {
            zzjs zzjsVar3 = zzjs.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult3 = zzdh.zzj;
            zzbF(zzjsVar3, 2, billingResult3, jNextLong);
            zzo(billingResult3);
            return billingResult3;
        }
        synchronized (this.zza) {
            zZzg = this.zzj != null ? this.zzj.zzg() : false;
        }
        ArrayList arrayListZzj = billingFlowParams.zzj();
        List listZzk = billingFlowParams.zzk();
        zzeu zzeuVar = (zzeu) com.google.android.gms.internal.play_billing.zzcg.zza(arrayListZzj, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzcg.zza(listZzk, null);
        if (zzeuVar != null) {
            throw null;
        }
        final String productId = productDetailsParams.zza().getProductId();
        final String productType = productDetailsParams.zza().getProductType();
        if (productType.equals(BillingClient.ProductType.SUBS) && !this.zzk) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzjs zzjsVar4 = zzjs.SUBSCRIPTIONS_NOT_SUPPORTED;
            BillingResult billingResult4 = zzdh.zzl;
            zzbH(zzjsVar4, 2, billingResult4, jNextLong, zZzg);
            zzo(billingResult4);
            return billingResult4;
        }
        if (billingFlowParams.zzu() && !this.zzn) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzjs zzjsVar5 = zzjs.EXTRA_PARAMS_NOT_SUPPORTED;
            BillingResult billingResult5 = zzdh.zzf;
            zzbH(zzjsVar5, 2, billingResult5, jNextLong, zZzg);
            zzo(billingResult5);
            return billingResult5;
        }
        if (arrayListZzj.size() > 1 && !this.zzt) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzjs zzjsVar6 = zzjs.MULTI_ITEM_NOT_SUPPORTED;
            BillingResult billingResult6 = zzdh.zzp;
            zzbH(zzjsVar6, 2, billingResult6, jNextLong, zZzg);
            zzo(billingResult6);
            return billingResult6;
        }
        if (!listZzk.isEmpty() && !this.zzu) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzjs zzjsVar7 = zzjs.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult7 = zzdh.zzs;
            zzbH(zzjsVar7, 2, billingResult7, jNextLong, zZzg);
            zzo(billingResult7);
            return billingResult7;
        }
        Iterator it = listZzk.iterator();
        while (it.hasNext()) {
            String strZzb = ((BillingFlowParams.ProductDetailsParams) it.next()).zzb();
            if (strZzb != null && strZzb.contains(ServerSentEventKt.COLON) && !this.zzE) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support gift code purchase.");
                zzjs zzjsVar8 = zzjs.GIFT_CODE_PURCHASE_NOT_SUPPORTED;
                BillingResult billingResult8 = zzdh.zzr;
                zzbH(zzjsVar8, 2, billingResult8, jNextLong, zZzg);
                zzo(billingResult8);
                return billingResult8;
            }
        }
        BillingResult billingResultZzd = billingFlowParams.zzd();
        if (billingResultZzd != zzdh.zzi) {
            zzbH(zzjs.INVALID_BILLING_FLOW_PARAMS, 2, billingResultZzd, jNextLong, zZzg);
            zzo(billingResultZzd);
            return billingResultZzd;
        }
        boolean z2 = zZzg;
        if (this.zzn) {
            long j2 = jNextLong;
            final Bundle bundleZzf = com.google.android.gms.internal.play_billing.zzc.zzf(billingFlowParams, this.zzp, this.zzw, this.zzG.isEnabledForOneTimeProducts(), this.zzG.isEnabledForPrepaidPlans(), this.zzI, this.zzc, this.zzd, this.zzM.longValue(), this.zzg.getPackageName(), j2);
            if (arrayListZzj.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                for (int i2 = 0; i2 < listZzk.size(); i2++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) listZzk.get(i2);
                    ProductDetails productDetailsZza = productDetailsParams2.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    String strZzb2 = productDetailsParams2.zzb();
                    arrayList4.add(strZzb2);
                    String strZzc = productDetailsZza.zzc(strZzb2);
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList5.add(strZzc);
                    }
                    if (i2 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i2)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i2)).zza().getProductType());
                    }
                }
                bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList6.isEmpty()) {
                    bundleZzf.putIntegerArrayList("autoPayBalanceThresholdList", arrayList6);
                }
                if (!arrayList3.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundleZzf.putStringArrayList("additionalSkus", arrayList);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it2 = arrayListZzj.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
                if (!arrayList7.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (arrayListZzj.size() > 1) {
                    ArrayList<String> arrayList8 = new ArrayList<>(arrayListZzj.size() - 1);
                    ArrayList<String> arrayList9 = new ArrayList<>(arrayListZzj.size() - 1);
                    if (arrayListZzj.size() > 1) {
                        throw null;
                    }
                    bundleZzf.putStringArrayList("additionalSkus", arrayList8);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList9);
                }
            }
            if (bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                zzjs zzjsVar9 = zzjs.OFFER_ID_TOKEN_NOT_SUPPORTED;
                BillingResult billingResult9 = zzdh.zzq;
                zzbH(zzjsVar9, 2, billingResult9, j2, z2);
                zzo(billingResult9);
                return billingResult9;
            }
            if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                z = false;
            } else {
                bundleZzf.putString("skuPackageName", productDetailsParams.zza().zza());
                z = true;
            }
            if (!TextUtils.isEmpty(null)) {
                bundleZzf.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                bundleZzf.putString("proxyPackage", stringExtra);
                try {
                    bundleZzf.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused) {
                    bundleZzf.putString("proxyPackageVersion", "package not found");
                }
            }
            if (this.zzE) {
                i = 28;
            } else if (this.zzu && !listZzk.isEmpty()) {
                i = 17;
            } else if (this.zzs && z) {
                i = 15;
            } else {
                i = this.zzp ? 9 : 6;
            }
            final int i3 = i;
            final BillingFlowParams billingFlowParams2 = billingFlowParams;
            futureZzP = zzP(new Callable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzaC(i3, productId, productType, billingFlowParams2, bundleZzf);
                }
            }, 5000L, null, this.zze, zzO());
            r5 = billingFlowParams2;
            j = j2;
        } else {
            j = jNextLong;
            futureZzP = zzP(new Callable() { // from class: com.android.billingclient.api.zzag
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzaD(productId, productType);
                }
            }, 5000L, null, this.zze, zzO());
            r5 = jNextLong;
        }
        try {
            if (futureZzP == null) {
                try {
                    zzjs zzjsVar10 = zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                    BillingResult billingResult10 = zzdh.zzc;
                    zzbH(zzjsVar10, 2, billingResult10, j, z2);
                    zzo(billingResult10);
                    return billingResult10;
                } catch (CancellationException e) {
                    e = e;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjs zzjsVar11 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult11 = zzdh.zzk;
                    zzbI(zzjsVar11, 2, billingResult11, zzdc.zza(e), r5, z2);
                    zzo(billingResult11);
                    return billingResult11;
                } catch (TimeoutException e2) {
                    e = e2;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjs zzjsVar12 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult12 = zzdh.zzk;
                    zzbI(zzjsVar12, 2, billingResult12, zzdc.zza(e), r5, z2);
                    zzo(billingResult12);
                    return billingResult12;
                } catch (Exception e3) {
                    e = e3;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzjs zzjsVar13 = zzjs.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult13 = zzdh.zzj;
                    zzbI(zzjsVar13, 2, billingResult13, zzdc.zza(e), r5, z2);
                    zzo(billingResult13);
                    return billingResult13;
                }
            }
            long j3 = j;
            Bundle bundle = (Bundle) futureZzP.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
            String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient");
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                intent2.putExtra("billingClientTransactionId", j3);
                intent2.putExtra("wasServiceAutoReconnected", z2);
                activity.startActivity(intent2);
                return zzdh.zzi;
            }
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", zza.zza(iZzb, "Unable to buy item, Error response code: "));
            BillingResult billingResultZza = zzdh.zza(iZzb, strZzj);
            try {
                if (bundle == null || (obj = bundle.get("LOG_REASON")) == null) {
                    zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
                } else if (obj instanceof Integer) {
                    zzjsVarZzb = zzjs.zzb(((Integer) obj).intValue());
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                    zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
                }
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
            }
            if (zzjsVarZzb == zzjs.REASON_UNSPECIFIED) {
                zzjsVarZzb = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            }
            zzjs zzjsVar14 = zzjsVarZzb;
            if (bundle == null) {
                string = null;
            } else {
                try {
                    string = bundle.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    string = null;
                }
            }
            try {
                zzbI(zzjsVar14, 2, billingResultZza, string, j3, z2);
                zzo(billingResultZza);
                return billingResultZza;
            } catch (CancellationException e4) {
                e = e4;
                r5 = j3;
                z2 = z2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjs zzjsVar15 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult14 = zzdh.zzk;
                zzbI(zzjsVar15, 2, billingResult14, zzdc.zza(e), r5, z2);
                zzo(billingResult14);
                return billingResult14;
            } catch (TimeoutException e5) {
                e = e5;
                r5 = j3;
                z2 = z2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjs zzjsVar16 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult15 = zzdh.zzk;
                zzbI(zzjsVar16, 2, billingResult15, zzdc.zza(e), r5, z2);
                zzo(billingResult15);
                return billingResult15;
            } catch (Exception e6) {
                e = e6;
                r5 = j3;
                z2 = z2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                zzjs zzjsVar17 = zzjs.LAUNCH_BILLING_FLOW_EXCEPTION;
                BillingResult billingResult16 = zzdh.zzj;
                zzbI(zzjsVar17, 2, billingResult16, zzdc.zza(e), r5, z2);
                zzo(billingResult16);
                return billingResult16;
            }
        } catch (CancellationException e7) {
            e = e7;
        } catch (TimeoutException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void launchExternalLink(final Activity activity, final LaunchExternalLinkParams launchExternalLinkParams, final LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        BillingClientImpl billingClientImpl;
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        try {
            billingClientImpl = this;
            try {
                billingClientImpl.zzaX(new Callable() { // from class: com.android.billingclient.api.zzau
                    @Override // java.util.concurrent.Callable
                    public final Object call() throws RemoteException {
                        BillingClientImpl.zzH(this.zza, launchExternalLinkResponseListener, launchExternalLinkParams, activity);
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzbk(launchExternalLinkResponseListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                    }
                }, zzaE());
            } catch (Exception e) {
                e = e;
                billingClientImpl.zzbk(launchExternalLinkResponseListener, billingClientImpl.zzaH(), zzjs.SERVICE_CALL_EXCEPTION, e);
            }
        } catch (Exception e2) {
            e = e2;
            billingClientImpl = this;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzbh
            @Override // java.util.concurrent.Callable
            public final Object call() throws JSONException {
                BillingClientImpl.zzx(this.zza, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbi
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzaa(this.zza, productDetailsResponseListener);
            }
        }, zzaE(), zzO()) == null) {
            BillingResult billingResultZzaH = zzaH();
            zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, billingResultZzaH);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzaH, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzca.zzk(), com.google.android.gms.internal.play_billing.zzca.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzP(new zzbp(this, purchasesResponseListener, queryPurchasesParams.zza(), queryPurchasesParams.getIncludeSuspendedSubscriptions()), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzS(this.zza, purchasesResponseListener);
            }
        }, zzaE(), zzO()) == null) {
            BillingResult billingResultZzaH = zzaH();
            zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, billingResultZzaH);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzaH, com.google.android.gms.internal.play_billing.zzca.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void showBillingProgramInformationDialog(final Activity activity, final BillingProgramInformationDialogParams billingProgramInformationDialogParams, final BillingProgramInformationDialogListener billingProgramInformationDialogListener) {
        BillingClientImpl billingClientImpl;
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        try {
            billingClientImpl = this;
            try {
                billingClientImpl.zzaX(new Callable() { // from class: com.android.billingclient.api.zzam
                    @Override // java.util.concurrent.Callable
                    public final Object call() throws Exception {
                        BillingClientImpl.zzI(this.zza, billingProgramInformationDialogListener, billingProgramInformationDialogParams, activity);
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzan
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzbm(billingProgramInformationDialogListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                    }
                }, zzaE());
            } catch (Exception e) {
                e = e;
                billingClientImpl.zzbm(billingProgramInformationDialogListener, billingClientImpl.zzaH(), zzjs.SERVICE_CALL_EXCEPTION, e);
            }
        } catch (Exception e2) {
            e = e2;
            billingClientImpl = this;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzbw(zzdq.zzc())) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
            return zzdh.zzj;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzdh.zzt;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        if (windowToken == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Could not retrieve the window token from the activity instance.");
        }
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        Handler handler = this.zze;
        final zzbq zzbqVar = new zzbq(this, handler, inAppMessageResponseListener);
        zzP(new Callable() { // from class: com.android.billingclient.api.zzbl
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzz(this.zza, bundle, activity, zzbqVar);
                return null;
            }
        }, 5000L, null, handler, zzO());
        return zzdh.zzi;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzbu(billingClientStateListener, 0);
    }

    final synchronized ExecutorService zzO() {
        if (this.zzL == null) {
            this.zzL = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzbo(this));
        }
        return this.zzL;
    }

    public final void zzax(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzcl zzi(QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzca zzcaVarZza = queryProductDetailsParams.zza();
        int size = zzcaVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zzcaVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzarVar = this.zzi;
                }
                if (zzarVar == null) {
                    return zzaF(zzdh.zzj, zzjs.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.zzw && this.zzG.isEnabledForPrepaidPlans();
                zzaN(queryProductDetailsParams);
                zzaN(queryProductDetailsParams);
                zzaN(queryProductDetailsParams);
                zzaN(queryProductDetailsParams);
                com.google.android.gms.internal.play_billing.zza zzaVarZza = com.google.android.gms.internal.play_billing.zza.zza(z, true, true, true, false, true);
                Bundle bundleZzj = zzarVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), strZzb, bundle, com.google.android.gms.internal.play_billing.zzc.zzg(str, this.zzd, arrayList3, null, null, zzaVarZza, this.zzM.longValue()));
                if (bundleZzj == null) {
                    return zzaF(zzdh.zzB, zzjs.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzj, "BillingClient");
                    String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzj, "BillingClient");
                    return iZzb != 0 ? zzaF(zzdh.zza(iZzb, strZzj), zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, zza.zza(iZzb, "getSkuDetails() failed for queryProductDetailsAsync. Response code: "), null) : zzaF(zzdh.zza(6, strZzj), zzjs.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaF(zzdh.zzB, zzjs.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e) {
                        return zzaF(zzdh.zza(6, "Error trying to decode SkuDetails."), zzjs.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (QueryProductDetailsParams.Product product : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.zza()).put("type", product.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                ProductDetails productDetails2 = (ProductDetails) it.next();
                                if (product.zza().equals(productDetails2.getProductId()) && product.zzb().equals(productDetails2.getProductType())) {
                                    break;
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(it2.next());
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return zzaF(zzdh.zza(6, "Error trying to decode SkuDetails."), zzjs.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return zzaF(zzdh.zzj, zzjs.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzaF(zzdh.zzh, zzjs.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzcl(0, "", arrayList, arrayList2);
    }

    final zzdd zzl() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzo(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzac(this.zza, billingResult);
            }
        });
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingChoiceInfoAsync(final GetBillingChoiceInfoParams getBillingChoiceInfoParams, final BillingChoiceInfoResponseListener billingChoiceInfoResponseListener) {
        if (billingChoiceInfoResponseListener == null) {
            throw new IllegalArgumentException("Please provide a valid listener.");
        }
        if (getBillingChoiceInfoParams == null) {
            throw new IllegalArgumentException("Please provide valid GetBillingChoiceInfoParams.");
        }
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzbj
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzv(this.zza, billingChoiceInfoResponseListener, getBillingChoiceInfoParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbb(billingChoiceInfoResponseListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzaE(), zzO()) == null) {
            zzbb(billingChoiceInfoResponseListener, zzaH(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzbw(zzdq.zzc())) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdh.zzj;
            zzbE(zzjsVar, 16, billingResult);
            return billingResult;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzjs zzjsVar2 = zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            BillingResult billingResult2 = zzdh.zzD;
            zzbE(zzjsVar2, 16, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzbr zzbrVar = new zzbr(this, handler, alternativeBillingOnlyInformationDialogListener);
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzE(this.zza, alternativeBillingOnlyInformationDialogListener, activity, zzbrVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbl(alternativeBillingOnlyInformationDialogListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzO()) != null) {
            return zzdh.zzi;
        }
        BillingResult billingResultZzaH = zzaH();
        zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 16, billingResultZzaH);
        return billingResultZzaH;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzbw(zzdq.zzc())) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdh.zzj;
            zzbE(zzjsVar, 25, billingResult);
            return billingResult;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support external offer.");
            zzjs zzjsVar2 = zzjs.EXTERNAL_OFFER_NOT_SUPPORTED;
            BillingResult billingResult2 = zzdh.zzu;
            zzbE(zzjsVar2, 25, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzbs zzbsVar = new zzbs(this, handler, externalOfferInformationDialogListener);
        if (zzP(new Callable() { // from class: com.android.billingclient.api.zzbf
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzK(this.zza, externalOfferInformationDialogListener, activity, zzbsVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzbi(externalOfferInformationDialogListener, zzdh.zzk, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzO()) != null) {
            return zzdh.zzi;
        }
        BillingResult billingResultZzaH = zzaH();
        zzbE(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, 25, billingResultZzaH);
        return billingResultZzaH;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, String str, zzdd zzddVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzkeVarZza.zzy(str2);
        }
        zzkeVarZza.zzq(this.zzg.getPackageName());
        zzkeVarZza.zzd(this.zzM.longValue());
        zzkeVarZza.zzw(builder.zza);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        zzbA(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzddVar != null) {
            this.zzh = zzddVar;
        } else {
            this.zzh = new zzdr(this.zzg, (zzkg) zzkeVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzz(this.zzg, purchasesUpdatedListener, null, null, null, this.zzh);
        this.zzG = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbq zzbqVar = builder.zzb;
        this.zzH = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzdu zzduVar, zzdd zzddVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = com.google.android.gms.internal.play_billing.zzcf.zzk();
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzM = lValueOf;
        this.zzN = com.google.android.gms.internal.play_billing.zzbf.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String strZzaO = zzaO();
        this.zzd = strZzaO;
        this.zzg = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(BuildConfig.VERSION_NAME);
        if (strZzaO != null) {
            zzkeVarZza.zzy(strZzaO);
        }
        zzkeVarZza.zzq(this.zzg.getPackageName());
        zzkeVarZza.zzd(lValueOf.longValue());
        zzkeVarZza.zzw(builder.zza);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        zzbA(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdr(this.zzg, (zzkg) zzkeVarZza.zzi());
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzz(this.zzg, null, null, null, null, this.zzh);
        this.zzG = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbq zzbqVar = builder.zzb;
        this.zzH = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzdd zzddVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = com.google.android.gms.internal.play_billing.zzcf.zzk();
        this.zzM = Long.valueOf(new Random().nextLong());
        this.zzN = com.google.android.gms.internal.play_billing.zzbf.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        this.zzd = zzaO();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, BuildConfig.VERSION_NAME, null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzdd zzddVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = com.google.android.gms.internal.play_billing.zzcf.zzk();
        this.zzM = Long.valueOf(new Random().nextLong());
        this.zzN = com.google.android.gms.internal.play_billing.zzbf.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        this.zzd = zzaO();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, developerProvidedBillingListener, BuildConfig.VERSION_NAME, null, builder);
    }
}
