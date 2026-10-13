package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpw<P> {
    private final Map<zzaau, List<P>> zza = new HashMap();

    public final zzpw<P> zza(zzaau zzaauVar, P p) throws GeneralSecurityException {
        List<P> list;
        if (zzaauVar.zza() != 0 && zzaauVar.zza() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        if (this.zza.containsKey(zzaauVar)) {
            list = this.zza.get(zzaauVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.zza.put(zzaauVar, arrayList);
            list = arrayList;
        }
        list.add(p);
        return this;
    }

    public final zzpu<P> zza() {
        return new zzpu<>(this.zza);
    }
}
