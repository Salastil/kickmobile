package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaek extends zzafi {
    private final zzaes zza;
    private final zzars zzb;

    private zzaek(zzaes zzaesVar, zzars zzarsVar) {
        this.zza = zzaesVar;
        this.zzb = zzarsVar;
    }

    public static zzaek zzc(zzaes zzaesVar, zzars zzarsVar) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        zzaeh zzaehVarZzc = zzaesVar.zze().zzc();
        int iZzc = zzarsVar.zzc();
        String string = zzaehVarZzc.toString();
        StringBuilder sb = new StringBuilder(string.length() + 53 + String.valueOf(iZzc).length());
        sb.append("Encoded private key byte length for ");
        sb.append(string);
        sb.append(" must be %d, not ");
        sb.append(iZzc);
        String string2 = sb.toString();
        zzaeh zzaehVar = zzaeh.zza;
        if (zzaehVarZzc == zzaehVar) {
            if (iZzc != 32) {
                throw new GeneralSecurityException(String.format(string2, 32));
            }
        } else if (zzaehVarZzc == zzaeh.zzb) {
            if (iZzc != 48) {
                throw new GeneralSecurityException(String.format(string2, 48));
            }
        } else if (zzaehVarZzc == zzaeh.zzc) {
            if (iZzc != 66) {
                throw new GeneralSecurityException(String.format(string2, 66));
            }
        } else {
            if (zzaehVarZzc != zzaeh.zzf) {
                throw new GeneralSecurityException("Unable to validate private key length for ".concat(zzaehVarZzc.toString()));
            }
            if (iZzc != 32) {
                throw new GeneralSecurityException(String.format(string2, 32));
            }
        }
        zzaeh zzaehVarZzc2 = zzaesVar.zze().zzc();
        byte[] bArrZzb = zzaesVar.zzd().zzb();
        byte[] bArrZzb2 = zzarsVar.zzb(zzvx.zza());
        if (zzaehVarZzc2 == zzaehVar || zzaehVarZzc2 == zzaeh.zzb || zzaehVarZzc2 == zzaeh.zzc) {
            if (zzaehVarZzc2 == zzaehVar) {
                eCParameterSpec = zzagz.zza;
            } else if (zzaehVarZzc2 == zzaeh.zzb) {
                eCParameterSpec = zzagz.zzb;
            } else {
                if (zzaehVarZzc2 != zzaeh.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve params for ".concat(zzaehVarZzc2.toString()));
                }
                eCParameterSpec = zzagz.zzc;
            }
            BigInteger order = eCParameterSpec.getOrder();
            BigInteger bigInteger = new BigInteger(1, bArrZzb2);
            if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private key.");
            }
            if (!zzagz.zzd(bigInteger, eCParameterSpec).equals(zzaqr.zzb(eCParameterSpec.getCurve(), zzaqq.UNCOMPRESSED, bArrZzb))) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            if (zzaehVarZzc2 != zzaeh.zzf) {
                throw new IllegalArgumentException("Unable to validate key pair for ".concat(zzaehVarZzc2.toString()));
            }
            if (!Arrays.equals(zzaro.zzb(bArrZzb2), bArrZzb)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        }
        return new zzaek(zzaesVar, zzarsVar);
    }

    @Override // com.google.android.gms.internal.pal.zzafi, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza.zze();
    }

    public final zzars zzd() {
        return this.zzb;
    }

    public final zzaej zze() {
        return this.zza.zze();
    }

    public final zzaes zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ zzafj zzi() {
        return this.zza;
    }
}
