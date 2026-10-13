package com.google.mlkit.vision.documentscanner;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzb extends GmsDocumentScanningResult.Page {
    private final Uri zza;

    zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("Null imageUri");
        }
        this.zza = uri;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GmsDocumentScanningResult.Page) {
            return this.zza.equals(((GmsDocumentScanningResult.Page) obj).getImageUri());
        }
        return false;
    }

    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult.Page
    public final Uri getImageUri() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "Page{imageUri=" + this.zza.toString() + "}";
    }
}
