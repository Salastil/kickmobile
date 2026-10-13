package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjx {
    private static final zzpq<zzjp> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzka
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzjp zzjpVar = (zzjp) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.AesSivKey", zzjx.zza(zzjpVar.zzd()), ((zzvb) ((zzalt) zzvb.zzc().zza(zzjpVar.zzb()).zze())).a_());
        }
    }, zzjp.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzjx.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesSivKey");
    private static final zzoh<zzji> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkc
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzji zzjiVar = (zzji) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.AesSivKey", ((zzuy) ((zzalt) zzuy.zzb().zza(zzakb.zza(zzjiVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzjx.zza(((zzjp) ((zzju) zzjiVar.zza())).zzd()), zzjiVar.zzb());
        }
    }, zzji.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzjx.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesSivKey");
    private static final Map<zzjp.zzb, zzcv> zze;

    private static zzcv zza(zzjp.zzb zzbVar) throws GeneralSecurityException {
        Map<zzjp.zzb, zzcv> map = zze;
        if (map.containsKey(zzbVar)) {
            return map.get(zzbVar);
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzji zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
        try {
            zzuy zzuyVarZza = zzuy.zza(zzctVar.zzc(), zzalf.zza());
            if (zzuyVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzji.zzc().zza(zzjp.zzc().zza(zzuyVarZza.zzd().zza()).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zzuyVarZza.zzd().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing AesSivKey failed");
        }
    }

    private static zzjp.zzb zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzd) {
            return zzjp.zzb.zzc;
        }
        if (zzcvVar == zzcv.zzb) {
            return zzjp.zzb.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzjp.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzjp.zzb.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjp zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzvb zzvbVarZza = zzvb.zza(zzcxVar.zzb(), zzalf.zza());
            if (zzvbVarZza.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzjp.zzc().zza(zzvbVarZza.zza()).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(zzjp.zzb.zzc, zzcv.zzd);
        map.put(zzjp.zzb.zza, zzcv.zzb);
        map.put(zzjp.zzb.zzb, zzcv.zze);
        zze = Collections.unmodifiableMap(map);
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
