package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaec extends zzafj {
    private final zzaea zza;

    @Nullable
    private final ECPoint zzb;

    @Nullable
    private final zzarq zzc;
    private final zzarq zzd;

    @Nullable
    private final Integer zze;

    private zzaec(zzaea zzaeaVar, @Nullable ECPoint eCPoint, @Nullable zzarq zzarqVar, zzarq zzarqVar2, @Nullable Integer num) {
        this.zza = zzaeaVar;
        this.zzb = eCPoint;
        this.zzc = zzarqVar;
        this.zzd = zzarqVar2;
        this.zze = num;
    }

    public static zzaec zzc(zzaea zzaeaVar, zzarq zzarqVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzaeaVar.zzc().equals(zzadv.zzd)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        zzi(zzaeaVar.zzg(), num);
        if (zzarqVar.zzc() == 32) {
            return new zzaec(zzaeaVar, null, zzarqVar, zzj(zzaeaVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    }

    public static zzaec zzd(zzaea zzaeaVar, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        if (zzaeaVar.zzc().equals(zzadv.zzd)) {
            throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
        }
        zzi(zzaeaVar.zzg(), num);
        zzadv zzadvVarZzc = zzaeaVar.zzc();
        if (zzadvVarZzc == zzadv.zza) {
            curve = zzagz.zza.getCurve();
        } else if (zzadvVarZzc == zzadv.zzb) {
            curve = zzagz.zzb.getCurve();
        } else {
            if (zzadvVarZzc != zzadv.zzc) {
                String strValueOf = String.valueOf(zzadvVarZzc);
                String.valueOf(strValueOf);
                throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(String.valueOf(strValueOf)));
            }
            curve = zzagz.zzc.getCurve();
        }
        zzagz.zza(eCPoint, curve);
        return new zzaec(zzaeaVar, eCPoint, null, zzj(zzaeaVar.zzg(), num), num);
    }

    private static void zzi(zzadz zzadzVar, @Nullable Integer num) throws GeneralSecurityException {
        zzadz zzadzVar2 = zzadz.zzc;
        if (zzadzVar.equals(zzadzVar2) || num != null) {
            if (zzadzVar.equals(zzadzVar2) && num != null) {
                throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
            }
        } else {
            String strValueOf = String.valueOf(zzadzVar);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 46);
            sb.append("'idRequirement' must be non-null for ");
            sb.append(strValueOf);
            sb.append(" variant.");
            throw new GeneralSecurityException(sb.toString());
        }
    }

    private static zzarq zzj(zzadz zzadzVar, @Nullable Integer num) {
        if (zzadzVar == zzadz.zzc) {
            return zzaim.zza;
        }
        if (num == null) {
            String strValueOf = String.valueOf(zzadzVar);
            String.valueOf(strValueOf);
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: ".concat(String.valueOf(strValueOf)));
        }
        if (zzadzVar == zzadz.zzb) {
            return zzaim.zza(num.intValue());
        }
        if (zzadzVar == zzadz.zza) {
            return zzaim.zzb(num.intValue());
        }
        String strValueOf2 = String.valueOf(zzadzVar);
        String.valueOf(strValueOf2);
        throw new IllegalStateException("Unknown EciesParameters.Variant: ".concat(String.valueOf(strValueOf2)));
    }

    @Override // com.google.android.gms.internal.pal.zzafj, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Nullable
    public final ECPoint zze() {
        return this.zzb;
    }

    @Nullable
    public final zzarq zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzafj
    public final zzarq zzg() {
        return this.zzd;
    }

    public final zzaea zzh() {
        return this.zza;
    }
}
