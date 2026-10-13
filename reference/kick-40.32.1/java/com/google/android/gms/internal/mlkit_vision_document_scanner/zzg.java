package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzg extends zzq {
    zzg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzq
    protected final int zza(Context context, zzp zzpVar, boolean z) {
        return (zzpVar.zza.getAuthority().lastIndexOf(64) < 0 || PermissionChecker.checkSelfPermission(context, "android.permission.INTERACT_ACROSS_USERS") != 0) ? 3 : 2;
    }
}
