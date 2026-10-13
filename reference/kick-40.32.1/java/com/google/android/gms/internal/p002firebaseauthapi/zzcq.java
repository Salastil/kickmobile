package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcq {
    public static zzbx zza(zzcm zzcmVar, zzdd zzddVar) throws GeneralSecurityException, IOException {
        if (zzddVar != null) {
            return zzbx.zza(zzcmVar.zzb(), zzda.zza());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbx zzbxVar, zzcl zzclVar, zzdd zzddVar) throws IOException {
        if (zzddVar == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        zzclVar.zza(zzbxVar.zzd());
    }
}
