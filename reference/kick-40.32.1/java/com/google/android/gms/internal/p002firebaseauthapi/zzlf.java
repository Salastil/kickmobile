package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlf implements zzbq {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(zzch zzchVar, Class<P> cls) throws GeneralSecurityException {
        if (cls.equals(zzbr.class)) {
            zzli unused = zzlc.zza;
            return cls.cast(zzli.zza(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzle
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
                public final Object zza(zzck zzckVar) {
                    return zzlc.zzb(zzckVar);
                }
            }));
        }
        if (!cls.equals(zzbs.class)) {
            throw new GeneralSecurityException("HybridConfigurationV1 can only create HybridEncrypt and HybridDecrypt primitives");
        }
        zzlg unused2 = zzlc.zzb;
        return cls.cast(zzlg.zza(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlh
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
            public final Object zza(zzck zzckVar) {
                return zzlc.zza(zzckVar);
            }
        }));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final /* synthetic */ Object zza(Class cls) {
        return null;
    }

    zzlf() {
    }
}
