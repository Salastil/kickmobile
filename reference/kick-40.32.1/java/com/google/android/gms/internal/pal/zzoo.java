package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzoo extends zznt {
    static final zzoo zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzoo(objArr, 0, objArr, 0, 0);
    }

    zzoo(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzne.zza(obj.hashCode());
                while (true) {
                    int i = iZza & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zznt, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzh().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh
    /* JADX INFO: renamed from: zza */
    public final zzou iterator() {
        return zzh().listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zze(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.pal.zznt
    final boolean zzg() {
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zznt
    final zznm zzi() {
        return zznm.zzk(this.zzb, this.zzg);
    }
}
