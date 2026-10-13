package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcx {
    private final zzakb zza;
    private final String zzb;
    private final zzcv zzc;

    public final zzcv zza() {
        return this.zzc;
    }

    public static zzcx zza(String str, zzcv zzcvVar, zzakb zzakbVar) throws GeneralSecurityException {
        zzqu.zza(str);
        return new zzcx(zzakbVar, str, zzcvVar);
    }

    public final zzakb zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    private zzcx(zzakb zzakbVar, String str, zzcv zzcvVar) {
        this.zza = zzakbVar;
        this.zzb = str;
        this.zzc = zzcvVar;
    }
}
