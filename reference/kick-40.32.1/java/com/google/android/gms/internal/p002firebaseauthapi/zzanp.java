package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzanp<K, V> implements Comparable<zzanp>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    private final zzalo zza;
    private V zzb;
    private final /* synthetic */ zzann zzc;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzanp zzanpVar) {
        return ((zzalo) getKey()).compareTo((zzalo) zzanpVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        zzalo zzaloVar = this.zza;
        int iHashCode = zzaloVar == null ? 0 : zzaloVar.hashCode();
        V v = this.zzb;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzc.zzf();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    public final String toString() {
        return String.valueOf(this.zza) + "=" + String.valueOf(this.zzb);
    }

    zzanp(zzann zzannVar, Map.Entry<K, V> entry) {
        this(zzannVar, (zzalo) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzanp(zzann zzannVar, K k, V v) {
        Objects.requireNonNull(zzannVar);
        this.zzc = zzannVar;
        this.zza = k;
        this.zzb = v;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
