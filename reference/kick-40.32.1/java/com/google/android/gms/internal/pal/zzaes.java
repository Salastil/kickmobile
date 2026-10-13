package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaes extends zzafj {
    private final zzaej zza;
    private final zzarq zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    private zzaes(zzaej zzaejVar, zzarq zzarqVar, zzarq zzarqVar2, @Nullable Integer num) {
        this.zza = zzaejVar;
        this.zzb = zzarqVar;
        this.zzc = zzarqVar2;
        this.zzd = num;
    }

    public static zzaes zzc(zzaej zzaejVar, zzarq zzarqVar, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        zzarq zzarqVarZzb;
        zzaei zzaeiVarZzf = zzaejVar.zzf();
        zzaei zzaeiVar = zzaei.zzc;
        if (!zzaeiVarZzf.equals(zzaeiVar) && num == null) {
            String string = zzaeiVarZzf.toString();
            StringBuilder sb = new StringBuilder(string.length() + 46);
            sb.append("'idRequirement' must be non-null for ");
            sb.append(string);
            sb.append(" variant.");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzaeiVarZzf.equals(zzaeiVar) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzaeh zzaehVarZzc = zzaejVar.zzc();
        int iZzc = zzarqVar.zzc();
        String string2 = zzaehVarZzc.toString();
        StringBuilder sb2 = new StringBuilder(string2.length() + 52 + String.valueOf(iZzc).length());
        sb2.append("Encoded public key byte length for ");
        sb2.append(string2);
        sb2.append(" must be %d, not ");
        sb2.append(iZzc);
        String string3 = sb2.toString();
        zzaeh zzaehVar = zzaeh.zza;
        if (zzaehVarZzc == zzaehVar) {
            if (iZzc != 65) {
                throw new GeneralSecurityException(String.format(string3, 65));
            }
        } else if (zzaehVarZzc == zzaeh.zzb) {
            if (iZzc != 97) {
                throw new GeneralSecurityException(String.format(string3, 97));
            }
        } else if (zzaehVarZzc == zzaeh.zzc) {
            if (iZzc != 133) {
                throw new GeneralSecurityException(String.format(string3, 133));
            }
        } else {
            if (zzaehVarZzc != zzaeh.zzf) {
                throw new GeneralSecurityException("Unable to validate public key length for ".concat(zzaehVarZzc.toString()));
            }
            if (iZzc != 32) {
                throw new GeneralSecurityException(String.format(string3, 32));
            }
        }
        if (zzaehVarZzc == zzaehVar || zzaehVarZzc == zzaeh.zzb || zzaehVarZzc == zzaeh.zzc) {
            if (zzaehVarZzc == zzaehVar) {
                curve = zzagz.zza.getCurve();
            } else if (zzaehVarZzc == zzaeh.zzb) {
                curve = zzagz.zzb.getCurve();
            } else {
                if (zzaehVarZzc != zzaeh.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(zzaehVarZzc.toString()));
                }
                curve = zzagz.zzc.getCurve();
            }
            zzagz.zza(zzaqr.zzb(curve, zzaqq.UNCOMPRESSED, zzarqVar.zzb()), curve);
        }
        zzaei zzaeiVarZzf2 = zzaejVar.zzf();
        if (zzaeiVarZzf2 == zzaeiVar) {
            zzarqVarZzb = zzaim.zza;
        } else {
            if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant ".concat(zzaeiVarZzf2.toString()));
            }
            if (zzaeiVarZzf2 == zzaei.zzb) {
                zzarqVarZzb = zzaim.zza(num.intValue());
            } else {
                if (zzaeiVarZzf2 != zzaei.zza) {
                    throw new IllegalStateException("Unknown HpkeParameters.Variant: ".concat(zzaeiVarZzf2.toString()));
                }
                zzarqVarZzb = zzaim.zzb(num.intValue());
            }
        }
        return new zzaes(zzaejVar, zzarqVar, zzarqVarZzb, num);
    }

    @Override // com.google.android.gms.internal.pal.zzafj, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final zzarq zzd() {
        return this.zzb;
    }

    public final zzaej zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzafj
    public final zzarq zzg() {
        return this.zzc;
    }
}
