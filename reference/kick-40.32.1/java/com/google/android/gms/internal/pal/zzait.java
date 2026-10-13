package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzait {
    private final Map zza = new HashMap();

    public final zzait zza(zzarq zzarqVar, Object obj) throws GeneralSecurityException {
        List list;
        if (zzarqVar.zzc() != 0 && zzarqVar.zzc() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        Map map = this.zza;
        if (map.containsKey(zzarqVar)) {
            list = (List) map.get(zzarqVar);
        } else {
            ArrayList arrayList = new ArrayList();
            map.put(zzarqVar, arrayList);
            list = arrayList;
        }
        list.add(obj);
        return this;
    }

    public final zzaiu zzb() {
        return new zzaiu(this.zza, null);
    }
}
