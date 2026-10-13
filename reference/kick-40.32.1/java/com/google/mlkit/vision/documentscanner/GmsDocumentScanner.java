package com.google.mlkit.vision.documentscanner;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public interface GmsDocumentScanner extends OptionalModuleApi {
    Task<IntentSender> getStartScanIntent(Activity activity);
}
