package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqz extends zzre {
    private String zza;
    private boolean zzb;
    private int zzc;
    private byte zzd;

    zzqz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzre
    public final zzre zza(boolean z) {
        this.zzb = true;
        this.zzd = (byte) (1 | this.zzd);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzre
    public final zzre zzb(int i) {
        this.zzc = 1;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzre zzc(String str) {
        this.zza = "play-services-mlkit-document-scanner";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzre
    public final zzrf zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzrb(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" libraryName");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
