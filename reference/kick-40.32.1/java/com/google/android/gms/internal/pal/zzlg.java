package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlg extends zzlq {
    static final zzlg zza = new zzlg();

    private zzlg() {
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final Object zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final Object zzc(Object obj) {
        return obj;
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final zzlq zzd(zzlo zzloVar) {
        return zza;
    }
}
