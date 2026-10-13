package com.google.android.gms.internal.mlkit_vision_document_scanner;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzak extends zzag {
    private final transient zzaf zza;
    private final transient zzad zzb;

    zzak(zzaf zzafVar, zzad zzadVar) {
        this.zza = zzafVar;
        this.zzb = zzadVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzz, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzag, com.google.android.gms.internal.mlkit_vision_document_scanner.zzz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzz
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzag, com.google.android.gms.internal.mlkit_vision_document_scanner.zzz
    /* JADX INFO: renamed from: zzd */
    public final zzao iterator() {
        return this.zzb.listIterator(0);
    }
}
