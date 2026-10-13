package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjz;
import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzdc {
    public static final /* synthetic */ int zza = 0;

    static {
        int i = zzdd.zza;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + ServerSentEventKt.COLON + com.google.android.gms.internal.play_billing.zzbo.zzc(exc.getMessage());
            int i = com.google.android.gms.internal.play_billing.zzc.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zzjl zzb(zzjs zzjsVar, int i, BillingResult billingResult, String str, zzjz zzjzVar) {
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(billingResult.getResponseCode());
            zzjqVarZza.zzb(billingResult.getDebugMessage());
            if (billingResult.getOnPurchasesUpdatedSubResponseCode() != 0) {
                zzjqVarZza.zzd(billingResult.getOnPurchasesUpdatedSubResponseCode());
            }
            if (zzjsVar != null) {
                zzjqVarZza.zze(zzjsVar);
            }
            if (str != null) {
                zzjqVarZza.zza(str);
            }
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(i);
            if (!zzjzVar.equals(zzjz.BROADCAST_ACTION_UNSPECIFIED)) {
                zzjjVarZza.zza(zzjzVar);
            }
            return (zzjl) zzjjVarZza.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzjp zzc(int i, zzjz zzjzVar) {
        try {
            zzjn zzjnVarZza = zzjp.zza();
            zzjnVarZza.zze(i);
            if (!zzjzVar.equals(zzjz.BROADCAST_ACTION_UNSPECIFIED)) {
                zzjnVarZza.zza(zzjzVar);
            }
            return (zzjp) zzjnVarZza.zzi();
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
