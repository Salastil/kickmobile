package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrb extends zzrf {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzrb(String str, boolean z, int i, zzra zzraVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzrf) {
            zzrf zzrfVar = (zzrf) obj;
            if (this.zza.equals(zzrfVar.zzb()) && this.zzb == zzrfVar.zzc() && this.zzc == zzrfVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        return this.zzc ^ (((iHashCode * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrf
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrf
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrf
    public final boolean zzc() {
        return this.zzb;
    }
}
