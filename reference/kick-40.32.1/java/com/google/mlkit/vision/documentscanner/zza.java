package com.google.mlkit.vision.documentscanner;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zza extends GmsDocumentScanningResult {
    private final List zza;
    private final GmsDocumentScanningResult.Pdf zzb;

    zza(List list, GmsDocumentScanningResult.Pdf pdf) {
        this.zza = list;
        this.zzb = pdf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GmsDocumentScanningResult) {
            GmsDocumentScanningResult gmsDocumentScanningResult = (GmsDocumentScanningResult) obj;
            List list = this.zza;
            if (list != null ? list.equals(gmsDocumentScanningResult.getPages()) : gmsDocumentScanningResult.getPages() == null) {
                GmsDocumentScanningResult.Pdf pdf = this.zzb;
                if (pdf != null ? pdf.equals(gmsDocumentScanningResult.getPdf()) : gmsDocumentScanningResult.getPdf() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
    public final List<GmsDocumentScanningResult.Page> getPages() {
        return this.zza;
    }

    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
    public final GmsDocumentScanningResult.Pdf getPdf() {
        return this.zzb;
    }

    public final String toString() {
        GmsDocumentScanningResult.Pdf pdf = this.zzb;
        return "GmsDocumentScanningResult{pages=" + String.valueOf(this.zza) + ", pdf=" + String.valueOf(pdf) + "}";
    }

    public final int hashCode() {
        List list = this.zza;
        int iHashCode = list == null ? 0 : list.hashCode();
        GmsDocumentScanningResult.Pdf pdf = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (pdf != null ? pdf.hashCode() : 0);
    }
}
