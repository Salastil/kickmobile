package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzhy implements Map, Serializable {
    private transient zzhz zza;
    private transient zzhz zzb;
    private transient zzhr zzc;

    zzhy() {
    }

    public static zzhy zza() {
        return zzih.zza;
    }

    public static zzhy zzb(Iterable iterable) {
        zzhx zzhxVar = new zzhx(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        zzhxVar.zza(iterable);
        zzhw zzhwVar = zzhxVar.zzc;
        if (zzhwVar != null) {
            throw zzhwVar.zza();
        }
        zzih zzihVarZzh = zzih.zzh(zzhxVar.zzb, zzhxVar.zza, zzhxVar);
        zzhw zzhwVar2 = zzhxVar.zzc;
        if (zzhwVar2 == null) {
            return zzihVarZzh;
        }
        throw zzhwVar2.zza();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzij.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzhz zzhzVar = this.zzb;
        if (zzhzVar != null) {
            return zzhzVar;
        }
        zzhz zzhzVarZze = zze();
        this.zzb = zzhzVarZze;
        return zzhzVarZze;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 33);
            sb.append("size cannot be negative but was: ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z = false;
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzhz entrySet() {
        zzhz zzhzVar = this.zza;
        if (zzhzVar != null) {
            return zzhzVar;
        }
        zzhz zzhzVarZzd = zzd();
        this.zza = zzhzVarZzd;
        return zzhzVarZzd;
    }

    abstract zzhz zzd();

    abstract zzhz zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzhr values() {
        zzhr zzhrVar = this.zzc;
        if (zzhrVar != null) {
            return zzhrVar;
        }
        zzhr zzhrVarZzg = zzg();
        this.zzc = zzhrVarZzg;
        return zzhrVarZzg;
    }

    abstract zzhr zzg();
}
