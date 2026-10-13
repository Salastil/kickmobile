package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznc extends zznd {
    private static final zznc zzb = new zznc();

    private zznc() {
        super("");
    }

    @Override // com.google.android.gms.internal.pal.zznd, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return zzc((zznd) obj);
    }

    @Override // com.google.android.gms.internal.pal.zznd
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }

    @Override // com.google.android.gms.internal.pal.zznd
    final void zza(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.gms.internal.pal.zznd
    final void zzb(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.pal.zznd
    public final int zzc(zznd zzndVar) {
        return zzndVar == this ? 0 : -1;
    }
}
