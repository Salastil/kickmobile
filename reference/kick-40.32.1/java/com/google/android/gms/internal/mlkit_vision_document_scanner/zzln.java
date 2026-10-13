package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzln implements zzat {
    MODE_UNKNOWN(0),
    MODE_AUTO(1),
    MODE_MANUAL(2);

    private final int zze;

    zzln(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzat
    public final int zza() {
        return this.zze;
    }
}
