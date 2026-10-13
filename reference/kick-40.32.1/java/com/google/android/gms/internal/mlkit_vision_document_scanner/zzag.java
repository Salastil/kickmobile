package com.google.android.gms.internal.mlkit_vision_document_scanner;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzag extends zzz implements Set {

    @CheckForNull
    private transient zzad zza;

    zzag() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzan.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: zzd */
    public abstract zzao iterator();

    public final zzad zzf() {
        zzad zzadVar = this.zza;
        if (zzadVar != null) {
            return zzadVar;
        }
        zzad zzadVarZzg = zzg();
        this.zza = zzadVarZzg;
        return zzadVarZzg;
    }

    zzad zzg() {
        Object[] array = toArray();
        int i = zzad.zzd;
        return zzad.zzg(array, array.length);
    }
}
