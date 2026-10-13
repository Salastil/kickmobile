package com.google.mlkit.vision.codescanner;

import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.common.Barcode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-code-scanner@@16.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface GmsBarcodeScanner extends OptionalModuleApi {
    Task<Barcode> startScan();
}
