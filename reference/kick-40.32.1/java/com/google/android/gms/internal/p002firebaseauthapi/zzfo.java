package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfo extends zzdo {
    private final zzc zza;
    private final String zzb;
    private final zza zzc;
    private final zzdo zzd;

    public final int hashCode() {
        return Objects.hash(zzfo.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static class zzb {

        @Nullable
        private zzc zza;

        @Nullable
        private String zzb;

        @Nullable
        private zza zzc;

        @Nullable
        private zzdo zzd;

        public final zzb zza(zzdo zzdoVar) {
            this.zzd = zzdoVar;
            return this;
        }

        public final zzb zza(zza zzaVar) {
            this.zzc = zzaVar;
            return this;
        }

        public final zzb zza(String str) {
            this.zzb = str;
            return this;
        }

        public final zzb zza(zzc zzcVar) {
            this.zza = zzcVar;
            return this;
        }

        public final zzfo zza() throws GeneralSecurityException {
            if (this.zza == null) {
                this.zza = zzc.zzb;
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("kekUri must be set");
            }
            if (this.zzc == null) {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
            zzdo zzdoVar = this.zzd;
            if (zzdoVar == null) {
                throw new GeneralSecurityException("dekParametersForNewKeys must be set");
            }
            if (zzdoVar.zza()) {
                throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
            }
            zza zzaVar = this.zzc;
            zzdo zzdoVar2 = this.zzd;
            if ((!zzaVar.equals(zza.zza) || !(zzdoVar2 instanceof zzel)) && ((!zzaVar.equals(zza.zzc) || !(zzdoVar2 instanceof zzey)) && ((!zzaVar.equals(zza.zzb) || !(zzdoVar2 instanceof zzgq)) && ((!zzaVar.equals(zza.zzd) || !(zzdoVar2 instanceof zzdw)) && ((!zzaVar.equals(zza.zze) || !(zzdoVar2 instanceof zzec)) && (!zzaVar.equals(zza.zzf) || !(zzdoVar2 instanceof zzes))))))) {
                throw new GeneralSecurityException("Cannot use parsing strategy " + this.zzc.toString() + " when new keys are picked according to " + String.valueOf(this.zzd) + ".");
            }
            return new zzfo(this.zza, this.zzb, this.zzc, this.zzd);
        }

        private zzb() {
        }
    }

    public final zzdo zzb() {
        return this.zzd;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zzc(String str) {
            this.zzc = str;
        }
    }

    public final zzc zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String toString() {
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + String.valueOf(this.zzc) + ", dekParametersForNewKeys: " + String.valueOf(this.zzd) + ", variant: " + String.valueOf(this.zza) + ")";
    }

    private zzfo(zzc zzcVar, String str, zza zzaVar, zzdo zzdoVar) {
        this.zza = zzcVar;
        this.zzb = str;
        this.zzc = zzaVar;
        this.zzd = zzdoVar;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza {
        public static final zza zza = new zza("ASSUME_AES_GCM");
        public static final zza zzb = new zza("ASSUME_XCHACHA20POLY1305");
        public static final zza zzc = new zza("ASSUME_CHACHA20POLY1305");
        public static final zza zzd = new zza("ASSUME_AES_CTR_HMAC");
        public static final zza zze = new zza("ASSUME_AES_EAX");
        public static final zza zzf = new zza("ASSUME_AES_GCM_SIV");
        private final String zzg;

        public final String toString() {
            return this.zzg;
        }

        private zza(String str) {
            this.zzg = str;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfoVar = (zzfo) obj;
        return zzfoVar.zzc.equals(this.zzc) && zzfoVar.zzd.equals(this.zzd) && zzfoVar.zzb.equals(this.zzb) && zzfoVar.zza.equals(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcs
    public final boolean zza() {
        return this.zza != zzc.zzb;
    }
}
