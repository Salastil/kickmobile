package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzcz implements zzbq {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(zzch zzchVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzpg.zza().zza(zzchVar, cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(Class<P> cls) {
        if (cls.equals(zzcy.class)) {
            return cls.cast(zzda.zza);
        }
        if (!cls.equals(zzqp.class) || zziz.zza.zza()) {
            return null;
        }
        return cls.cast(new zzdc(this));
    }

    zzcz() {
    }
}
