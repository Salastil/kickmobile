package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends BroadcastReceiver {
    final /* synthetic */ zzz zza;
    private boolean zzb;
    private final boolean zzc;

    zzy(zzz zzzVar, boolean z) {
        Objects.requireNonNull(zzzVar);
        this.zza = zzzVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i, zzjz zzjzVar, long j, boolean z) {
        try {
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            zzz zzzVar = this.zza;
            if (byteArray != null) {
                zzzVar.zze.zzd(zzjl.zzc(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD")), j, z);
            } else {
                zzzVar.zze.zzd(zzdc.zzb(zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, billingResult, null, zzjzVar), j, z);
            }
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzjz zzjzVar;
        int i;
        int i2;
        BillingResult billingResultZzi;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                if (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                    zzjzVar = zzjz.ALTERNATIVE_BILLING_ACTION;
                } else {
                    zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
                }
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                zzjzVar = zzjz.LOCAL_PURCHASES_UPDATED_ACTION;
            } else {
                zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            zzjzVar = zzjz.PURCHASES_UPDATED_ACTION;
        } else {
            zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
        }
        zzjz zzjzVar2 = zzjzVar;
        zzjz zzjzVar3 = zzjz.LOCAL_PURCHASES_UPDATED_ACTION;
        if (zzjzVar2.equals(zzjzVar3) || zzjzVar2.equals(zzjz.ALTERNATIVE_BILLING_ACTION)) {
            i = 2;
            i2 = 2;
        } else {
            i2 = zzjzVar2.equals(zzjz.PURCHASES_UPDATED_ACTION) ? 32 : 1;
            i = 2;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            zzz zzzVar = this.zza;
            zzdd zzddVar = zzzVar.zze;
            zzjs zzjsVar = zzjs.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            BillingResult billingResult = zzdh.zzh;
            zzddVar.zza(zzdc.zzb(zzjsVar, i2, billingResult, null, zzjzVar2));
            if (zzzVar.zzb != null) {
                zzzVar.zzb.onPurchasesUpdated(billingResult, null);
                return;
            }
            return;
        }
        if (i2 == i) {
            int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
            if (intent == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingHelper", "Got null intent!");
                BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                builderNewBuilder.setResponseCode(6);
                builderNewBuilder.setOnPurchasesUpdatedSubResponseCode(0);
                builderNewBuilder.setDebugMessage("An internal error occurred.");
                billingResultZzi = builderNewBuilder.build();
            } else {
                BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
                builderNewBuilder2.setResponseCode(com.google.android.gms.internal.play_billing.zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
                Bundle extras2 = intent.getExtras();
                if (extras2 == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
                } else {
                    Object obj = extras2.get("SUB_RESPONSE_CODE");
                    if (obj == null) {
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingBroadcastManager", "getOnPurchasesUpdatedSubResponseCodeFromBundle() got null response code, assuming OK");
                    } else {
                        if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                        } else {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(String.valueOf(obj.getClass().getName())));
                        }
                        builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                        builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                        billingResultZzi = builderNewBuilder2.build();
                    }
                }
                iIntValue = 0;
                builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                billingResultZzi = builderNewBuilder2.build();
            }
        } else {
            billingResultZzi = com.google.android.gms.internal.play_billing.zzc.zzi(intent, "BillingBroadcastManager");
        }
        long j = extras.getLong("billingClientTransactionId", 0L);
        boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
        if (zzjzVar2.equals(zzjz.PURCHASES_UPDATED_ACTION) || zzjzVar2.equals(zzjzVar3)) {
            BillingResult billingResult2 = billingResultZzi;
            zzz zzzVar2 = this.zza;
            List<Purchase> listZzl = com.google.android.gms.internal.play_billing.zzc.zzl(extras, zzzVar2.zzi);
            if (billingResult2.getResponseCode() == 0) {
                zzzVar2.zze.zzh(zzdc.zzc(i2, zzjzVar2), j, z);
            } else {
                zzd(extras, billingResult2, i2, zzjzVar2, j, z);
            }
            zzzVar2.zzb.onPurchasesUpdated(billingResult2, listZzl);
            return;
        }
        if (zzjzVar2.equals(zzjz.ALTERNATIVE_BILLING_ACTION)) {
            if (billingResultZzi.getResponseCode() != 0) {
                BillingResult billingResult3 = billingResultZzi;
                zzd(extras, billingResult3, i2, zzjzVar2, j, z);
                this.zza.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzca.zzk());
                return;
            }
            zzz zzzVar3 = this.zza;
            if (zzzVar3.zzc == null && zzzVar3.zzd == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "No valid alternative billing listener is registered.");
                zzdd zzddVar2 = zzzVar3.zze;
                zzjs zzjsVar2 = zzjs.NULL_DEVELOPER_MANAGED_BILLING_LISTENER;
                BillingResult billingResult4 = zzdh.zzh;
                zzddVar2.zzd(zzdc.zzb(zzjsVar2, i2, billingResult4, null, zzjzVar2), j, z);
                zzzVar3.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzca.zzk());
                return;
            }
            String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                zzdd zzddVar3 = zzzVar3.zze;
                zzjs zzjsVar3 = zzjs.MISSING_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                BillingResult billingResult5 = zzdh.zzh;
                zzddVar3.zzd(zzdc.zzb(zzjsVar3, i2, billingResult5, null, zzjzVar2), j, z);
                zzzVar3.zzb.onPurchasesUpdated(billingResult5, com.google.android.gms.internal.play_billing.zzca.zzk());
                return;
            }
            try {
                if (zzzVar3.zzc != null) {
                    zzzVar3.zzc.userSelectedAlternativeBilling(new UserChoiceDetails(string));
                } else {
                    zzzVar3.zzd.onUserSelectedDeveloperBilling(new DeveloperProvidedBillingDetails(string));
                }
                this.zza.zze.zzh(zzdc.zzc(i2, zzjzVar2), j, z);
            } catch (JSONException unused) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                zzz zzzVar4 = this.zza;
                zzdd zzddVar4 = zzzVar4.zze;
                zzjs zzjsVar4 = zzjs.INVALID_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                BillingResult billingResult6 = zzdh.zzh;
                zzddVar4.zzd(zzdc.zzb(zzjsVar4, i2, billingResult6, null, zzjzVar2), j, z);
                zzzVar4.zzb.onPurchasesUpdated(billingResult6, com.google.android.gms.internal.play_billing.zzca.zzk());
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzy zzyVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzyVar = this;
                    context.registerReceiver(zzyVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzyVar = this;
                    context.registerReceiver(zzyVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzyVar.zzb = true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
