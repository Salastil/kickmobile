package com.google.firebase.auth;

import com.google.android.gms.internal.p002firebaseauthapi.zzbh;
import com.google.android.gms.internal.p002firebaseauthapi.zzbi;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzat {
    public abstract String zza();

    public abstract String zzb();

    public final String zzc() {
        zzbi zzbiVarZza = zzbh.zza().zza();
        zzbiVarZza.zza(zzb(), StandardCharsets.UTF_8);
        zzbiVarZza.zza(zza(), StandardCharsets.UTF_8);
        return zzbiVarZza.zza().toString();
    }
}
