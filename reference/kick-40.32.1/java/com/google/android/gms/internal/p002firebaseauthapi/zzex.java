package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzex {
    private static final zzpx<zzeu, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzew
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzex.zza((zzeu) zzbtVar);
        }
    }, zzeu.class, zzbm.class);
    private static final zzob<zzey> zzb = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzez
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzex.zza((zzey) zzcsVar, num);
        }
    };
    private static final zzbw<zzbm> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzbm.class, zzxg.zza.SYMMETRIC, zzve.zze());

    public static /* synthetic */ zzbm zza(zzeu zzeuVar) {
        return zzhp.zzb() ? zzhp.zza(zzeuVar) : zzzh.zza(zzeuVar);
    }

    static zzeu zza(zzey zzeyVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzeu.zza(zzeyVar.zzb(), zzaav.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzhs.zza();
        zzpg.zza().zza(zza);
        zzoy.zza().zza(zzb, zzey.class);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzey.zza(zzey.zza.zza));
        map.put("CHACHA20_POLY1305_RAW", zzey.zza(zzey.zza.zzc));
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzoe.zza().zza((zzbw) zzc, true);
    }
}
