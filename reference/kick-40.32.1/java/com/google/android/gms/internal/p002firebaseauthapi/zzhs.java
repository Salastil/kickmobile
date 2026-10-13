package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhs {
    private static final zzpq<zzey> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            return zzcx.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzhs.zza(((zzey) zzcsVar).zzb()), zzvh.zzb().a_());
        }
    }, zzey.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzhs.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
    private static final zzoh<zzeu> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzht
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzeu zzeuVar = (zzeu) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzve) ((zzalt) zzve.zzb().zza(zzakb.zza(zzeuVar.zze().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzhs.zza(((zzey) ((zzdo) zzeuVar.zza())).zzb()), zzeuVar.zzb());
        }
    }, zzeu.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzhs.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");

    private static zzcv zza(zzey.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzey.zza.zza)) {
            return zzcv.zzb;
        }
        if (zzaVar.equals(zzey.zza.zzb)) {
            return zzcv.zze;
        }
        if (zzaVar.equals(zzey.zza.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzeu zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzve zzveVarZza = zzve.zza(zzctVar.zzc(), zzalf.zza());
            if (zzveVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzeu.zza(zza(zzctVar.zzb()), zzaav.zza(zzveVarZza.zzd().zzc(), zzdd.zza(zzddVar)), zzctVar.zzd());
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    private static zzey.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzey.zza.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzey.zza.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzey.zza.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzey.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzey zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzvh.zza(zzcxVar.zzb(), zzalf.zza());
            return zzey.zza(zza(zzcxVar.zza()));
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
