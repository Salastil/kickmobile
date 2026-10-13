package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaai extends zzaaj {
    zzaai(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final void zza(Object obj, long j, byte b) {
        if (zzaak.zzb) {
            zzaak.zzD(obj, j, b);
        } else {
            zzaak.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final boolean zzb(Object obj, long j) {
        return zzaak.zzb ? zzaak.zzu(obj, j) : zzaak.zzv(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.cast.zzaak.zzw(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.cast.zzaak.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.cast.zzaak.zzw(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.cast.zzaak.zzx(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.cast.zzaaj
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaak.zzb) {
            zzaak.zzw(obj, j, z);
        } else {
            zzaak.zzx(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.cast.zzaaj
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
