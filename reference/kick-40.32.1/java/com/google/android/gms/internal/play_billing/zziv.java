package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zziv extends zziw {
    zziv(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zzc(Object obj, long j, boolean z) {
        if (zzix.zza) {
            zzix.zzi(obj, j, z);
        } else {
            zzix.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zzd(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final boolean zzf(Object obj, long j) {
        return zzix.zza ? zzix.zzq(obj, j) : zzix.zzr(obj, j);
    }
}
