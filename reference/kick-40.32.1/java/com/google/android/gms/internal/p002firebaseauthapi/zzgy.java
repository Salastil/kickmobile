package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgy {
    private static final zzpq<zzec> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzec zzecVar = (zzec) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgy.zza(zzecVar.zzf()), ((zzug) ((zzalt) zzug.zzb().zza(zzgy.zzb(zzecVar)).zza(zzecVar.zzc()).zze())).a_());
        }
    }, zzec.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzha
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzgy.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesEaxKey");
    private static final zzoh<zzdx> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzdx zzdxVar = (zzdx) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzud) ((zzalt) zzud.zzb().zza(zzgy.zzb((zzec) ((zzdo) zzdxVar.zza()))).zza(zzakb.zza(zzdxVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzgy.zza(((zzec) ((zzdo) zzdxVar.zza())).zzf()), zzdxVar.zzb());
        }
    }, zzdx.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhc
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzgy.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesEaxKey");

    private static zzcv zza(zzec.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzec.zza.zza)) {
            return zzcv.zzb;
        }
        if (zzaVar.equals(zzec.zza.zzb)) {
            return zzcv.zze;
        }
        if (zzaVar.equals(zzec.zza.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdx zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzud zzudVarZza = zzud.zza(zzctVar.zzc(), zzalf.zza());
            if (zzudVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzdx.zze().zza(zzec.zze().zzb(zzudVarZza.zze().zza()).zza(zzudVarZza.zzd().zza()).zzc(16).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zzudVarZza.zze().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing AesEaxKey failed");
        }
    }

    private static zzec.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzec.zza.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzec.zza.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzec.zza.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzec.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzec zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzug zzugVarZza = zzug.zza(zzcxVar.zzb(), zzalf.zza());
            return zzec.zze().zzb(zzugVarZza.zza()).zza(zzugVarZza.zzd().zza()).zzc(16).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    private static zzuj zzb(zzec zzecVar) throws GeneralSecurityException {
        if (zzecVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(zzecVar.zzd())));
        }
        return (zzuj) ((zzalt) zzuj.zzb().zza(zzecVar.zzb()).zze());
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
