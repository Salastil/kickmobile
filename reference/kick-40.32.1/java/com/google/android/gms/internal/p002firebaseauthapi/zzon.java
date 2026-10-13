package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzon extends zzbt {
    private final zzct zza;

    public final zzbt zzc() throws GeneralSecurityException {
        String strZze = this.zza.zze();
        zzbw<?> zzbwVarZza = zzoe.zza().zza(strZze);
        if (zzbwVarZza instanceof zzcu) {
            zzxg zzxgVarZzc = ((zzcu) zzbwVarZza).zzc(this.zza.zzc());
            return new zzon(zzct.zza(zzxgVarZzc.zzf(), zzxgVarZzc.zze(), zzqk.zza(zzxgVarZzc.zzb()), this.zza.zzb(), this.zza.zzd()), null);
        }
        throw new GeneralSecurityException("manager for key type " + strZze + " is not a PrivateKeyManager");
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    private static class zza extends zzcs {
        private final String zza;
        private final zzcv zzb;

        public final String toString() {
            return String.format("(typeUrl=%s, outputPrefixType=%s)", this.zza, this.zzb.toString());
        }

        private zza(String str, zzcv zzcvVar) {
            this.zza = str;
            this.zzb = zzcvVar;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcs
        public final boolean zza() {
            return this.zzb != zzcv.zzd;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final zzcs zza() {
        return new zza(this.zza.zze(), this.zza.zzb());
    }

    public final zzct zza(@Nullable zzdd zzddVar) throws GeneralSecurityException {
        zza(this.zza, zzddVar);
        return this.zza;
    }

    public final zzaau zzd() throws GeneralSecurityException {
        zzct zzctVar = this.zza;
        if (zzctVar.zzb().equals(zzcv.zzd)) {
            return zzaau.zza(new byte[0]);
        }
        if (zzctVar.zzb().equals(zzcv.zzb)) {
            return zzpj.zzb(zzctVar.zzd().intValue());
        }
        if (zzctVar.zzb().equals(zzcv.zzc) || zzctVar.zzb().equals(zzcv.zze)) {
            return zzpj.zza(zzctVar.zzd().intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zza.zzd();
    }

    public zzon(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        zza(zzctVar, zzddVar);
        this.zza = zzctVar;
    }

    private static void zza(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (zzctVar.zza().equals(zzcw.zzb) || zzctVar.zza().equals(zzcw.zzc)) {
            zzdd.zza(zzddVar);
        }
    }
}
