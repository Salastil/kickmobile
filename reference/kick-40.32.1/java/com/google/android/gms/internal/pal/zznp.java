package com.google.android.gms.internal.pal;

import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zznp implements Map, Serializable {
    private transient zznt zza;
    private transient zznt zzb;
    private transient zznh zzc;

    zznp() {
    }

    public static zznp zza() {
        return zzon.zza;
    }

    public static zznp zzb(Object obj, Object obj2) {
        zzmw.zza(obj, obj2);
        return zzon.zzl(1, new Object[]{obj, obj2}, null);
    }

    public static zznp zzc(Object obj, Object obj2, Object obj3, Object obj4) {
        zzmw.zza(obj, obj2);
        zzmw.zza(obj3, obj4);
        return zzon.zzl(2, new Object[]{obj, obj2, obj3, obj4}, null);
    }

    public static zznp zzd(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        zzmw.zza(obj, obj2);
        zzmw.zza(obj3, obj4);
        zzmw.zza(obj5, obj6);
        return zzon.zzl(3, new Object[]{obj, obj2, obj3, obj4, obj5, obj6}, null);
    }

    public static zznp zze(Map map) {
        Set setEntrySet = map.entrySet();
        zzno zznoVar = new zzno(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zznoVar.zzc(setEntrySet);
        return zznoVar.zzd();
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
        return zzoq.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
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
        zzmw.zzb(size, ContentDisposition.Parameters.Size);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zznt entrySet() {
        zznt zzntVar = this.zza;
        if (zzntVar != null) {
            return zzntVar;
        }
        zznt zzntVarZzg = zzg();
        this.zza = zzntVarZzg;
        return zzntVarZzg;
    }

    abstract zznt zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zznt keySet() {
        zznt zzntVar = this.zzb;
        if (zzntVar != null) {
            return zzntVar;
        }
        zznt zzntVarZzi = zzi();
        this.zzb = zzntVarZzi;
        return zzntVarZzi;
    }

    abstract zznt zzi();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final zznh values() {
        zznh zznhVar = this.zzc;
        if (zznhVar != null) {
            return zznhVar;
        }
        zznh zznhVarZzk = zzk();
        this.zzc = zznhVarZzk;
        return zznhVarZzk;
    }

    abstract zznh zzk();
}
