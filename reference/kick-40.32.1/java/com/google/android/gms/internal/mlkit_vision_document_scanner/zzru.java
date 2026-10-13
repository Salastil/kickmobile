package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzru extends LazyInstanceMap {
    private zzru() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzrf zzrfVar = (zzrf) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzrk(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzrg(MlKitContext.getInstance().getApplicationContext(), zzrfVar), zzrfVar.zzb());
    }

    /* synthetic */ zzru(zzrt zzrtVar) {
    }
}
