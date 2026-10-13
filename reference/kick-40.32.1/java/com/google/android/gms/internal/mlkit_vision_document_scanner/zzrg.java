package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrg implements zzrd {
    final List zza;

    public zzrg(Context context, zzrf zzrfVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzrfVar.zzc()) {
            arrayList.add(new zzrs(context, zzrfVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrd
    public final void zza(zzrc zzrcVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrd) it.next()).zza(zzrcVar);
        }
    }
}
