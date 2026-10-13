package com.google.mlkit.vision.documentscanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class GmsDocumentScanning {
    private GmsDocumentScanning() {
    }

    public static GmsDocumentScanner getClient(GmsDocumentScannerOptions gmsDocumentScannerOptions) {
        return new com.google.mlkit.vision.documentscanner.internal.zzb(gmsDocumentScannerOptions);
    }
}
