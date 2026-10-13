package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzab extends zzv {
    private final zzad zza;

    zzab(zzad zzadVar, int i) {
        super(zzadVar.size(), i);
        this.zza = zzadVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzv
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
