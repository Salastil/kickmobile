package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdj {
    static void zza(zzjs zzjsVar, BillingResult billingResult, zzdd zzddVar, int i, int i2) {
        int i3 = zzdc.zza;
        zzddVar.zzb(zzdc.zzb(zzjsVar, i, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i2);
    }

    static void zzb(zzjs zzjsVar, BillingResult billingResult, zzdd zzddVar, int i, int i2, String str) {
        int i3 = zzdc.zza;
        zzddVar.zzb(zzdc.zzb(zzjsVar, i, billingResult, str, zzjz.BROADCAST_ACTION_UNSPECIFIED), i2);
    }
}
