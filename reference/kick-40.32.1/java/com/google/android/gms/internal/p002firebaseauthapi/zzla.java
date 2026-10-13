package com.google.android.gms.internal.p002firebaseauthapi;

import io.ktor.http.MimesKt;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzla extends zzlp {
    private final zzkq zza;
    private final zzaau zzb;
    private final zzaau zzc;

    @Nullable
    private final Integer zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzkq) zza();
    }

    public static zzla zza(zzkq zzkqVar, zzaau zzaauVar, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        zzaau zzaauVarZzb;
        zzkq.zze zzeVarZzf = zzkqVar.zzf();
        if (!zzeVarZzf.equals(zzkq.zze.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzeVarZzf) + " variant.");
        }
        if (zzeVarZzf.equals(zzkq.zze.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzkq.zzf zzfVarZze = zzkqVar.zze();
        int iZza = zzaauVar.zza();
        String str = "Encoded public key byte length for " + String.valueOf(zzfVarZze) + " must be %d, not " + iZza;
        if (zzfVarZze == zzkq.zzf.zza) {
            if (iZza != 65) {
                throw new GeneralSecurityException(String.format(str, 65));
            }
        } else if (zzfVarZze == zzkq.zzf.zzb) {
            if (iZza != 97) {
                throw new GeneralSecurityException(String.format(str, 97));
            }
        } else if (zzfVarZze == zzkq.zzf.zzc) {
            if (iZza != 133) {
                throw new GeneralSecurityException(String.format(str, 133));
            }
        } else if (zzfVarZze == zzkq.zzf.zzd) {
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        } else {
            if (zzfVarZze != zzkq.zzf.zze) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zzfVarZze));
            }
            if (iZza != 1216) {
                throw new GeneralSecurityException(String.format(str, Integer.valueOf(MimesKt.INITIAL_MIMES_LIST_SIZE)));
            }
        }
        if (zzfVarZze == zzkq.zzf.zza || zzfVarZze == zzkq.zzf.zzb || zzfVarZze == zzkq.zzf.zzc) {
            if (zzfVarZze == zzkq.zzf.zza) {
                curve = zznv.zza.getCurve();
            } else if (zzfVarZze == zzkq.zzf.zzb) {
                curve = zznv.zzb.getCurve();
            } else {
                if (zzfVarZze != zzkq.zzf.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzfVarZze));
                }
                curve = zznv.zzc.getCurve();
            }
            zznv.zza(zzzn.zza(curve, zzzp.UNCOMPRESSED, zzaauVar.zzb()), curve);
        }
        zzkq.zze zzeVarZzf2 = zzkqVar.zzf();
        if (zzeVarZzf2 == zzkq.zze.zzc) {
            zzaauVarZzb = zzpj.zza;
        } else {
            if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzeVarZzf2));
            }
            if (zzeVarZzf2 == zzkq.zze.zzb) {
                zzaauVarZzb = zzpj.zza(num.intValue());
            } else {
                if (zzeVarZzf2 != zzkq.zze.zza) {
                    throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzeVarZzf2));
                }
                zzaauVarZzb = zzpj.zzb(num.intValue());
            }
        }
        return new zzla(zzkqVar, zzaauVar, zzaauVarZzb, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzln zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    public final zzaau zzd() {
        return this.zzc;
    }

    public final zzaau zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzla(zzkq zzkqVar, zzaau zzaauVar, zzaau zzaauVar2, @Nullable Integer num) {
        this.zza = zzkqVar;
        this.zzb = zzaauVar;
        this.zzc = zzaauVar2;
        this.zzd = num;
    }
}
