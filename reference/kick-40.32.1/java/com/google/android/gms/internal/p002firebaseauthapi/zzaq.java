package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaq<E> extends zzag<E> implements Set<E> {
    private transient zzah<E> zza;

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzay.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    public zzah<E> zzc() {
        zzah<E> zzahVar = this.zza;
        if (zzahVar != null) {
            return zzahVar;
        }
        zzah<E> zzahVarZzf = zzf();
        this.zza = zzahVarZzf;
        return zzahVarZzf;
    }

    zzah<E> zzf() {
        return zzah.zza(toArray());
    }

    public static <E> zzaq<E> zza(E e) {
        return new zzax(e);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzaq() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzay.zza(this, obj);
    }
}
