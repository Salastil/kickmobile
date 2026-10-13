package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzse extends zza implements zzsg {
    zzse(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.docscan.ui.aidls.IDocumentScannerService");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzsg
    public final void zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzb(1, parcelZza);
    }
}
