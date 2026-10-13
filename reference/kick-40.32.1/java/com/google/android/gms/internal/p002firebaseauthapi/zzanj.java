package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzanj<E> extends zzajv<E> implements RandomAccess {
    private static final Object[] zza;
    private static final zzanj<Object> zzb;
    private E[] zzc;
    private int zzd;

    private static int zzb(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + this.zzc[i].hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalx
    public final /* synthetic */ zzalx zza(int i) {
        if (i < this.zzd) {
            throw new IllegalArgumentException();
        }
        return new zzanj(i == 0 ? zza : Arrays.copyOf(this.zzc, i), this.zzd, true);
    }

    public static <E> zzanj<E> zzd() {
        return (zzanj<E>) zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzd(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zza();
        zzd(i);
        E[] eArr = this.zzc;
        E e = eArr[i];
        int i2 = this.zzd;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzd--;
        this.modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zza();
        zzd(i);
        E[] eArr = this.zzc;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    private final String zzc(int i) {
        return "Index:" + i + ", Size:" + this.zzd;
    }

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzanj<>(objArr, 0, false);
    }

    zzanj() {
        this(zza, 0, true);
    }

    private zzanj(E[] eArr, int i, boolean z) {
        super(z);
        this.zzc = eArr;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        E[] eArr = this.zzc;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[zzb(eArr.length)];
            System.arraycopy(this.zzc, 0, eArr2, 0, i);
            System.arraycopy(this.zzc, i, eArr2, i + 1, this.zzd - i);
            this.zzc = eArr2;
        }
        this.zzc[i] = e;
        this.zzd++;
        this.modCount++;
    }

    private final void zzd(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        zza();
        int i = this.zzd;
        E[] eArr = this.zzc;
        if (i == eArr.length) {
            this.zzc = (E[]) Arrays.copyOf(this.zzc, zzb(eArr.length));
        }
        E[] eArr2 = this.zzc;
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (!(obj instanceof zzanj)) {
            for (int i = 0; i < size; i++) {
                if (!this.zzc[i].equals(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        zzanj zzanjVar = (zzanj) obj;
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.zzc[i2].equals(zzanjVar.zzc[i2])) {
                return false;
            }
        }
        return true;
    }
}
