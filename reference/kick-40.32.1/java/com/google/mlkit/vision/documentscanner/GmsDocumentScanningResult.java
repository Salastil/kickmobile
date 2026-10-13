package com.google.mlkit.vision.documentscanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class GmsDocumentScanningResult implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    public static abstract class Page implements Parcelable {
        public abstract Uri getImageUri();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    public static abstract class Pdf implements Parcelable {
        public abstract int getPageCount();

        public abstract Uri getUri();
    }

    public static GmsDocumentScanningResult fromActivityResultIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (GmsDocumentScanningResult) intent.getParcelableExtra("extra_scanning_result");
    }

    public static GmsDocumentScanningResult zza(List list, Uri uri, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new zzg((Uri) it.next()));
        }
        return new zze(arrayList, uri != null ? new zzi(uri, i) : null);
    }

    public abstract List<Page> getPages();

    public abstract Pdf getPdf();
}
