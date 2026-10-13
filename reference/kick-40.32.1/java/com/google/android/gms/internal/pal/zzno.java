package com.google.android.gms.internal.pal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzno {
    Object[] zza;
    int zzb;
    zznn zzc;

    public zzno() {
        this(4);
    }

    private final void zze(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzng.zzc(length, i2));
        }
    }

    public final zzno zza(Object obj, Object obj2) {
        zze(this.zzb + 1);
        zzmw.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzno zzb(Map map) {
        zzc(map.entrySet());
        return this;
    }

    public final zzno zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            zze(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zznp zzd() {
        zznn zznnVar = this.zzc;
        if (zznnVar != null) {
            throw zznnVar.zza();
        }
        zzon zzonVarZzl = zzon.zzl(this.zzb, this.zza, this);
        zznn zznnVar2 = this.zzc;
        if (zznnVar2 == null) {
            return zzonVarZzl;
        }
        throw zznnVar2.zza();
    }

    zzno(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
