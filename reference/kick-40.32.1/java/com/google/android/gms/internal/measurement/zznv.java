package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznv extends zzqo {
    private final zznd zza;
    private final zzqr zzb;

    zznv(zznd zzndVar, zzqr zzqrVar) {
        this.zza = zzndVar;
        this.zzb = zzqrVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqo) {
            zzqo zzqoVar = (zzqo) obj;
            zznd zzndVar = this.zza;
            if (zzndVar != null ? zzndVar.equals(zzqoVar.zza()) : zzqoVar.zza() == null) {
                if (this.zzb.equals(zzqoVar.zzb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        zzqr zzqrVar = this.zzb;
        String strValueOf = String.valueOf(this.zza);
        String string = zzqrVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 52 + string.length() + 1);
        sb.append("SnapshotBlobAndResult{snapshotBlob=");
        sb.append(strValueOf);
        sb.append(", snapshotResult=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    final zznd zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    final zzqr zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        zznd zzndVar = this.zza;
        return this.zzb.hashCode() ^ (((zzndVar == null ? 0 : zzndVar.hashCode()) ^ 1000003) * 1000003);
    }
}
