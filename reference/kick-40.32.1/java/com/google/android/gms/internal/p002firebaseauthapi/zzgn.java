package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgn {
    private static final zzpx<zzgl, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgm
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzgn.zza((zzgl) zzbtVar);
        }
    }, zzgl.class, zzbm.class);
    private static final zzbw<zzbm> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzbm.class, zzxg.zza.SYMMETRIC, zzyt.zze());
    private static final zzoz<zzgq> zzc = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgp
    };
    private static final zzob<zzgq> zzd = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzgn.zza((zzgq) zzcsVar, num);
        }
    };

    public static /* synthetic */ zzbm zza(zzgl zzglVar) {
        return zzis.zza() ? zzis.zza(zzglVar) : zzaar.zza(zzglVar);
    }

    static zzgl zza(zzgq zzgqVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzgl.zza(zzgqVar.zzb(), zzaav.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzir.zza();
        zzpg.zza().zza(zza);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzgq.zza(zzgq.zza.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzgq.zza(zzgq.zza.zzc));
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzoy.zza().zza(zzd, zzgq.class);
        zzpa.zza().zza(zzc, zzgq.class);
        zzoe.zza().zza((zzbw) zzb, true);
    }
}
