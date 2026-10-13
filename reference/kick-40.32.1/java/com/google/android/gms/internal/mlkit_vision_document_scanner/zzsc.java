package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzsc extends zzb implements zzsd {
    public zzsc() {
        super("com.google.mlkit.vision.docscan.ui.aidls.IDocumentScannerCallbacks");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzry zzryVar = (zzry) zzc.zza(parcel, zzry.CREATOR);
            zzc.zzb(parcel);
            zzb(zzryVar);
        } else {
            if (i != 2) {
                return false;
            }
            zzc.zzb(parcel);
            parcel2.writeNoException();
            parcel2.writeInt(0);
        }
        return true;
    }
}
