package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqk {
    public static zzcw zza(zzxg.zza zzaVar) throws GeneralSecurityException {
        switch (zzqj.zza[zzaVar.ordinal()]) {
            case 1:
                return zzcw.zza;
            case 2:
                return zzcw.zzb;
            case 3:
                return zzcw.zzc;
            case 4:
                return zzcw.zzd;
            case 5:
                return zzcw.zze;
            case 6:
                throw new GeneralSecurityException("Unknown KeyMaterialType: " + String.valueOf(zzaVar));
            default:
                throw new GeneralSecurityException("Unknown KeyMaterialType: " + String.valueOf(zzaVar));
        }
    }

    public static zzcv zza(zzyi zzyiVar) throws GeneralSecurityException {
        switch (zzqj.zzb[zzyiVar.ordinal()]) {
            case 1:
                return zzcv.zza;
            case 2:
                return zzcv.zzb;
            case 3:
                return zzcv.zzc;
            case 4:
                return zzcv.zzd;
            case 5:
                return zzcv.zze;
            case 6:
                return zzcv.zzf;
            case 7:
                throw new GeneralSecurityException("Unknown OutputPrefixType: " + String.valueOf(zzyiVar));
            default:
                throw new GeneralSecurityException("Unknown OutputPrefixType: " + String.valueOf(zzyiVar));
        }
    }

    public static zzxg.zza zza(zzcw zzcwVar) throws GeneralSecurityException {
        if (zzcwVar.equals(zzcw.zza)) {
            return zzxg.zza.UNKNOWN_KEYMATERIAL;
        }
        if (zzcwVar.equals(zzcw.zzb)) {
            return zzxg.zza.SYMMETRIC;
        }
        if (zzcwVar.equals(zzcw.zzc)) {
            return zzxg.zza.ASYMMETRIC_PRIVATE;
        }
        if (zzcwVar.equals(zzcw.zzd)) {
            return zzxg.zza.ASYMMETRIC_PUBLIC;
        }
        if (zzcwVar.equals(zzcw.zze)) {
            return zzxg.zza.REMOTE;
        }
        throw new GeneralSecurityException("Unknown KeyMaterialType: " + String.valueOf(zzcwVar));
    }

    public static zzyi zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar.equals(zzcv.zza)) {
            return zzyi.UNKNOWN_PREFIX;
        }
        if (zzcvVar.equals(zzcv.zzb)) {
            return zzyi.TINK;
        }
        if (zzcvVar.equals(zzcv.zzc)) {
            return zzyi.LEGACY;
        }
        if (zzcvVar.equals(zzcv.zzd)) {
            return zzyi.RAW;
        }
        if (zzcvVar.equals(zzcv.zze)) {
            return zzyi.CRUNCHY;
        }
        if (zzcvVar.equals(zzcv.zzf)) {
            return zzyi.WITH_ID_REQUIREMENT;
        }
        throw new GeneralSecurityException("Unknown OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    public static zzaau zza(zzcv zzcvVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzd) {
            if (num != null) {
                throw new GeneralSecurityException("RAW output prefix type cannot have an id requirement");
            }
            return zzpj.zza;
        }
        if (num == null) {
            throw new GeneralSecurityException("idRequirement must be non-null for " + String.valueOf(zzcvVar) + " type");
        }
        if (zzcvVar == zzcv.zzb) {
            return zzpj.zzb(num.intValue());
        }
        if (zzcvVar == zzcv.zzc || zzcvVar == zzcv.zze) {
            return zzpj.zza(num.intValue());
        }
        throw new GeneralSecurityException("Unknown OutputPrefixType: " + String.valueOf(zzcvVar));
    }
}
