package com.google.android.gms.internal.pal;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaxf extends zzaxg {
    zzaxf(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final void zza(Object obj, long j, byte b) {
        if (zzaxh.zzb) {
            zzaxh.zzF(obj, j, b);
        } else {
            zzaxh.zzG(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final boolean zzb(Object obj, long j) {
        return zzaxh.zzb ? zzaxh.zzw(obj, j) : zzaxh.zzx(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.pal.zzaxh.zzy(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.pal.zzaxh.zzz(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.pal.zzaxh.zzy(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.pal.zzaxh.zzz(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.pal.zzaxg
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaxh.zzb) {
            zzaxh.zzy(obj, j, z);
        } else {
            zzaxh.zzz(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.pal.zzaxg
    public final byte zzh(long j) {
        return Memory.peekByte(j);
    }
}
