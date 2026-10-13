package com.google.mlkit.vision.documentscanner;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzc extends GmsDocumentScanningResult.Pdf {
    private final Uri zza;
    private final int zzb;

    zzc(Uri uri, int i) {
        if (uri == null) {
            throw new NullPointerException("Null uri");
        }
        this.zza = uri;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GmsDocumentScanningResult.Pdf) {
            GmsDocumentScanningResult.Pdf pdf = (GmsDocumentScanningResult.Pdf) obj;
            if (this.zza.equals(pdf.getUri()) && this.zzb == pdf.getPageCount()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult.Pdf
    public final int getPageCount() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult.Pdf
    public final Uri getUri() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zzb ^ ((this.zza.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "Pdf{uri=" + this.zza.toString() + ", pageCount=" + this.zzb + "}";
    }
}
