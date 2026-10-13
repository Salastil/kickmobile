package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzamr implements zzams {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zza(int i, Object obj, Object obj2) {
        zzamp zzampVar = (zzamp) obj;
        if (zzampVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzampVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final zzamq<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final Object zza(Object obj, Object obj2) {
        zzamp zzampVarZzb = (zzamp) obj;
        zzamp zzampVar = (zzamp) obj2;
        if (!zzampVar.isEmpty()) {
            if (!zzampVarZzb.zzd()) {
                zzampVarZzb = zzampVarZzb.zzb();
            }
            zzampVarZzb.zza(zzampVar);
        }
        return zzampVarZzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final Object zzb(Object obj) {
        return zzamp.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final Object zzc(Object obj) {
        ((zzamp) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final Map<?, ?> zzd(Object obj) {
        return (zzamp) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final Map<?, ?> zze(Object obj) {
        return (zzamp) obj;
    }

    zzamr() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final boolean zzf(Object obj) {
        return !((zzamp) obj).zzd();
    }
}
