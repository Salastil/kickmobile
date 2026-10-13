package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzld;
import com.google.android.gms.internal.play_billing.zzlg;
import com.google.android.gms.internal.play_billing.zzlk;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
interface zzdd {
    public static final /* synthetic */ int zza = 0;

    static {
        com.google.android.gms.internal.play_billing.zzcd.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzjz.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzjz.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", zzjz.ALTERNATIVE_BILLING_ACTION);
    }

    void zza(zzjl zzjlVar);

    void zzb(zzjl zzjlVar, int i);

    void zzc(zzjl zzjlVar, int i, long j);

    void zzd(zzjl zzjlVar, long j, boolean z);

    void zze(zzjl zzjlVar, int i, long j, boolean z);

    void zzf(zzjp zzjpVar);

    void zzg(zzjp zzjpVar, int i);

    void zzh(zzjp zzjpVar, long j, boolean z);

    void zzi(zzjx zzjxVar);

    void zzj(BillingResult billingResult, long j);

    void zzk(long j);

    void zzl(zzld zzldVar);

    void zzm(zzlg zzlgVar);

    void zzn(zzlk zzlkVar);
}
