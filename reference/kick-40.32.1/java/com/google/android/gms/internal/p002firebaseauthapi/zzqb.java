package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqb {
    private final Map<zzqg, zzpx<?, ?>> zza;
    private final Map<Class<?>, zzqi<?, ?>> zzb;

    public static zzqd zza(zzqb zzqbVar) {
        return new zzqd(zzqbVar);
    }

    public static /* synthetic */ Object zza(zzqb zzqbVar, zzqi zzqiVar, zzck zzckVar) throws GeneralSecurityException {
        zzbt zzbtVarZzb = zzckVar.zzb();
        zzqg zzqgVar = new zzqg(zzbtVarZzb.getClass(), zzqiVar.zza());
        if (!zzqbVar.zza.containsKey(zzqgVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + String.valueOf(zzqgVar) + " available, see https://developers.google.com/tink/faq/registration_errors");
        }
        return zzqbVar.zza.get(zzqgVar).zza(zzbtVarZzb);
    }

    public final <KeyT extends zzbt, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        zzqg zzqgVar = new zzqg(keyt.getClass(), cls);
        if (!this.zza.containsKey(zzqgVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + String.valueOf(zzqgVar) + " available, see https://developers.google.com/tink/faq/registration_errors");
        }
        return (PrimitiveT) this.zza.get(zzqgVar).zza(keyt);
    }

    public final <WrappedPrimitiveT> WrappedPrimitiveT zza(zzch zzchVar, Class<WrappedPrimitiveT> cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for " + String.valueOf(cls));
        }
        final zzqi<?, ?> zzqiVar = this.zzb.get(cls);
        return (WrappedPrimitiveT) zzqiVar.zzb(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqe
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
            public final Object zza(zzck zzckVar) {
                return zzqb.zza(this.zza, zzqiVar, zzckVar);
            }
        });
    }

    private zzqb(zzqd zzqdVar) {
        this.zza = new HashMap(zzqdVar.zza);
        this.zzb = new HashMap(zzqdVar.zzb);
    }
}
