package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqn {
    private final Map<Class<?>, zzoh<?>> zza;
    private final Map<String, zzod> zzb;
    private final Map<Class<?>, zzpq<?>> zzc;
    private final Map<String, zzpm> zzd;

    public final zzqn zza(zzod zzodVar) throws GeneralSecurityException {
        String strZza = zzodVar.zza();
        boolean zContainsKey = this.zzb.containsKey(strZza);
        Map<String, zzod> map = this.zzb;
        if (!zContainsKey) {
            map.put(strZza, zzodVar);
            return this;
        }
        zzod zzodVar2 = map.get(strZza);
        if (zzodVar2.equals(zzodVar) && zzodVar.equals(zzodVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + strZza);
    }

    public final <KeyT extends zzbt> zzqn zza(zzoh<KeyT> zzohVar) throws GeneralSecurityException {
        boolean zContainsKey = this.zza.containsKey(zzohVar.zza());
        Map<Class<?>, zzoh<?>> map = this.zza;
        if (zContainsKey) {
            zzoh<?> zzohVar2 = map.get(zzohVar.zza());
            if (zzohVar2.equals(zzohVar) && zzohVar.equals(zzohVar2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzohVar.zza()));
        }
        map.put(zzohVar.zza(), zzohVar);
        return this;
    }

    public final zzqn zza(zzpm zzpmVar) throws GeneralSecurityException {
        String strZza = zzpmVar.zza();
        boolean zContainsKey = this.zzd.containsKey(strZza);
        Map<String, zzpm> map = this.zzd;
        if (zContainsKey) {
            zzpm zzpmVar2 = map.get(strZza);
            if (zzpmVar2.equals(zzpmVar) && zzpmVar.equals(zzpmVar2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + strZza);
        }
        map.put(strZza, zzpmVar);
        return this;
    }

    public final <ParametersT extends zzcs> zzqn zza(zzpq<ParametersT> zzpqVar) throws GeneralSecurityException {
        boolean zContainsKey = this.zzc.containsKey(zzpqVar.zza());
        Map<Class<?>, zzpq<?>> map = this.zzc;
        if (zContainsKey) {
            zzpq<?> zzpqVar2 = map.get(zzpqVar.zza());
            if (zzpqVar2.equals(zzpqVar) && zzpqVar.equals(zzpqVar2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzpqVar.zza()));
        }
        map.put(zzpqVar.zza(), zzpqVar);
        return this;
    }

    public final zzqo zza() {
        return new zzqo(this);
    }

    public zzqn() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public zzqn(zzqo zzqoVar) {
        this.zza = new HashMap(zzqoVar.zza);
        this.zzb = new HashMap(zzqoVar.zzb);
        this.zzc = new HashMap(zzqoVar.zzc);
        this.zzd = new HashMap(zzqoVar.zzd);
    }
}
