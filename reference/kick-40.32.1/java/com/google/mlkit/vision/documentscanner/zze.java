package com.google.mlkit.vision.documentscanner;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
final class zze extends zza {
    public static final Parcelable.Creator<zze> CREATOR = new zzd();

    zze(List list, GmsDocumentScanningResult.Pdf pdf) {
        super(list, pdf);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getPages());
        parcel.writeParcelable(getPdf(), i);
    }
}
