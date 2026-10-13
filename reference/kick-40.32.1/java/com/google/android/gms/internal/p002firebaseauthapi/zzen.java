package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzen extends zzdm {
    private final zzes zza;
    private final zzaav zzb;
    private final zzaau zzc;

    @Nullable
    private final Integer zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzes) zza();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static class zza {

        @Nullable
        private zzes zza;

        @Nullable
        private zzaav zzb;

        @Nullable
        private Integer zzc;

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzaav zzaavVar) {
            this.zzb = zzaavVar;
            return this;
        }

        public final zza zza(zzes zzesVar) {
            this.zza = zzesVar;
            return this;
        }

        public final zzen zza() throws GeneralSecurityException {
            zzaau zzaauVarZzb;
            zzes zzesVar = this.zza;
            if (zzesVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzesVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzd() == zzes.zza.zzc) {
                zzaauVarZzb = zzpj.zza;
            } else if (this.zza.zzd() == zzes.zza.zzb) {
                zzaauVarZzb = zzpj.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzes.zza.zza) {
                zzaauVarZzb = zzpj.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
            }
            return new zzen(this.zza, this.zzb, zzaauVarZzb, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
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
        return this.zzc;
    }

    public final zzaav zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzen(zzes zzesVar, zzaav zzaavVar, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzesVar;
        this.zzb = zzaavVar;
        this.zzc = zzaauVar;
        this.zzd = num;
    }
}
