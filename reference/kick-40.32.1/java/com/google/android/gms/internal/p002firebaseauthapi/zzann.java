package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalo;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
class zzann<K extends zzalo<K>, V> extends AbstractMap<K, V> {
    private Object[] zza;
    private int zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzanr zze;

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    /* JADX WARN: Code duplicated, block: B:21:0x003b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0038 A[SYNTHETIC] */
    private final int zza(K k) {
        int i;
        int i2;
        int i3;
        int iCompareTo;
        int i4 = this.zzb;
        int i5 = i4 - 1;
        if (i5 < 0) {
            i = 0;
            while (i <= i5) {
                i3 = (i + i5) / 2;
                iCompareTo = k.compareTo((zzalo) ((zzanp) this.zza[i3]).getKey());
                if (iCompareTo < 0) {
                    i5 = i3 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i3;
                    }
                    i = i3 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = k.compareTo((zzalo) ((zzanp) this.zza[i5]).getKey());
            if (iCompareTo2 > 0) {
                i2 = i4 + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i5;
                }
                i = 0;
                while (i <= i5) {
                    i3 = (i + i5) / 2;
                    iCompareTo = k.compareTo((zzalo) ((zzanp) this.zza[i3]).getKey());
                    if (iCompareTo < 0) {
                        i5 = i3 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i3;
                        }
                        i = i3 + 1;
                    }
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }

    public final int zza() {
        return this.zzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = this.zzb;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.zza[i2].hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb + this.zzc.size();
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        zzalo zzaloVar = (zzalo) obj;
        int iZza = zza(zzaloVar);
        if (iZza >= 0) {
            return (V) ((zzanp) this.zza[iZza]).getValue();
        }
        return this.zzc.get(zzaloVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzf();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) ((zzanp) this.zza[iZza]).setValue(v);
        }
        zzf();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i = -(iZza + 1);
        if (i >= 16) {
            return zze().put(k, v);
        }
        int i2 = this.zzb;
        if (i2 == 16) {
            zzanp zzanpVar = (zzanp) this.zza[15];
            this.zzb = i2 - 1;
            zze().put((zzalo) zzanpVar.getKey(), zzanpVar.getValue());
        }
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i, objArr, i + 1, (objArr.length - i) - 1);
        this.zza[i] = new zzanp(this, k, v);
        this.zzb++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzf();
        zzalo zzaloVar = (zzalo) obj;
        int iZza = zza(zzaloVar);
        if (iZza >= 0) {
            return zzb(iZza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(zzaloVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzb(int i) {
        zzf();
        V v = (V) ((zzanp) this.zza[i]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i + 1, objArr, i, (this.zzb - i) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zze().entrySet().iterator();
            this.zza[this.zzb] = new zzanp(this, it.next());
            this.zzb++;
            it.remove();
        }
        return v;
    }

    public final Map.Entry<K, V> zza(int i) {
        if (i >= this.zzb) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return (zzanp) this.zza[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzanr(this);
        }
        return this.zze;
    }

    private final SortedMap<K, V> zze() {
        zzf();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            this.zzc = new TreeMap();
        }
        return (SortedMap) this.zzc;
    }

    private zzann() {
        this.zzc = Collections.EMPTY_MAP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzf();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    public void zzc() {
        Map<K, V> mapUnmodifiableMap;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = mapUnmodifiableMap;
        this.zzd = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        zzalo zzaloVar = (zzalo) obj;
        return zza(zzaloVar) >= 0 || this.zzc.containsKey(zzaloVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzann)) {
            return super.equals(obj);
        }
        zzann zzannVar = (zzann) obj;
        int size = size();
        if (size != zzannVar.size()) {
            return false;
        }
        int i = this.zzb;
        if (i != zzannVar.zzb) {
            return entrySet().equals(zzannVar.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!zza(i2).equals(zzannVar.zza(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.zzc.equals(zzannVar.zzc);
        }
        return true;
    }

    public final boolean zzd() {
        return this.zzd;
    }
}
