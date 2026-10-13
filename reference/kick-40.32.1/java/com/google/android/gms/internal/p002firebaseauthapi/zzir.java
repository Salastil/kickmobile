package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzir {
    private static final zzpq<zzgq> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zziu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            return zzcx.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzir.zza(((zzgq) zzcsVar).zzb()), zzyw.zzc().a_());
        }
    }, zzgq.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzit
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzir.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
    private static final zzoh<zzgl> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zziw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzgl zzglVar = (zzgl) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzyt) ((zzalt) zzyt.zzb().zza(zzakb.zza(zzglVar.zze().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzir.zza(((zzgq) ((zzdo) zzglVar.zza())).zzb()), zzglVar.zzb());
        }
    }, zzgl.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zziv
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzir.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");

    private static zzcv zza(zzgq.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzgq.zza.zza)) {
            return zzcv.zzb;
        }
        if (zzaVar.equals(zzgq.zza.zzb)) {
            return zzcv.zze;
        }
        if (zzaVar.equals(zzgq.zza.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgl zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzyt zzytVarZza = zzyt.zza(zzctVar.zzc(), zzalf.zza());
            if (zzytVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzgl.zza(zza(zzctVar.zzb()), zzaav.zza(zzytVarZza.zzd().zzc(), zzdd.zza(zzddVar)), zzctVar.zzd());
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzgq.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzgq.zza.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzgq.zza.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzgq.zza.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzgq.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgq zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            if (zzyw.zza(zzcxVar.zzb(), zzalf.zza()).zza() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzgq.zza(zza(zzcxVar.zza()));
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
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
