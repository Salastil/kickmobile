package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdp extends zzdm {
    private final zzdw zza;
    private final zzaav zzb;
    private final zzaav zzc;
    private final zzaau zzd;

    @Nullable
    private final Integer zze;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzdw) zza();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static class zza {

        @Nullable
        private zzdw zza;

        @Nullable
        private zzaav zzb;

        @Nullable
        private zzaav zzc;

        @Nullable
        private Integer zzd;

        public final zza zza(zzaav zzaavVar) {
            this.zzb = zzaavVar;
            return this;
        }

        public final zza zzb(zzaav zzaavVar) {
            this.zzc = zzaavVar;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzd = num;
            return this;
        }

        public final zza zza(zzdw zzdwVar) {
            this.zza = zzdwVar;
            return this;
        }

        public final zzdp zza() throws GeneralSecurityException {
            zzaau zzaauVarZzb;
            zzdw zzdwVar = this.zza;
            if (zzdwVar == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (this.zzb == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            }
            if (zzdwVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            }
            if (this.zza.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            }
            if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzd != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzh() == zzdw.zzb.zzc) {
                zzaauVarZzb = zzpj.zza;
            } else if (this.zza.zzh() == zzdw.zzb.zzb) {
                zzaauVarZzb = zzpj.zza(this.zzd.intValue());
            } else if (this.zza.zzh() == zzdw.zzb.zza) {
                zzaauVarZzb = zzpj.zzb(this.zzd.intValue());
            } else {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + String.valueOf(this.zza.zzh()));
            }
            return new zzdp(this.zza, this.zzb, this.zzc, zzaauVarZzb, this.zzd);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzdo zza() {
        return this.zza;
    }

    public static zza zze() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    public final zzaau zzd() {
        return this.zzd;
    }

    public final zzaav zzf() {
        return this.zzb;
    }

    public final zzaav zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    private zzdp(zzdw zzdwVar, zzaav zzaavVar, zzaav zzaavVar2, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzdwVar;
        this.zzb = zzaavVar;
        this.zzc = zzaavVar2;
        this.zzd = zzaauVar;
        this.zze = num;
    }
}
