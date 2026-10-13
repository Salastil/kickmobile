package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdk implements zzbq {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(zzch zzchVar, Class<P> cls) throws GeneralSecurityException {
        if (cls != zzbm.class) {
            throw new GeneralSecurityException("AeadConfigurationV1 can only create AEADs");
        }
        zzdn unused = zzdh.zza;
        return cls.cast(zzdn.zza(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdj
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
            public final Object zza(zzck zzckVar) {
                return zzdh.zza(zzckVar);
            }
        }));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final /* synthetic */ Object zza(Class cls) {
        return null;
    }

    zzdk() {
    }
}
