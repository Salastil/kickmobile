package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzn {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zznv.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    private static BigInteger zza(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigIntegerAdd;
        BigInteger bigInteger2;
        BigInteger bigIntegerZza = zznv.zza(ellipticCurve);
        BigInteger bigIntegerMod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(bigIntegerZza);
        if (bigIntegerZza.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger bigIntegerMod2 = bigIntegerMod.mod(bigIntegerZza);
        if (bigIntegerMod2.equals(BigInteger.ZERO)) {
            bigInteger2 = BigInteger.ZERO;
        } else {
            if (bigIntegerZza.testBit(0) && bigIntegerZza.testBit(1)) {
                bigIntegerAdd = bigIntegerMod2.modPow(bigIntegerZza.add(BigInteger.ONE).shiftRight(2), bigIntegerZza);
            } else if (!bigIntegerZza.testBit(0) || bigIntegerZza.testBit(1)) {
                bigIntegerAdd = null;
            } else {
                bigIntegerAdd = BigInteger.ONE;
                BigInteger bigIntegerShiftRight = bigIntegerZza.subtract(BigInteger.ONE).shiftRight(1);
                int i = 0;
                while (true) {
                    BigInteger bigIntegerMod3 = bigIntegerAdd.multiply(bigIntegerAdd).subtract(bigIntegerMod2).mod(bigIntegerZza);
                    if (!bigIntegerMod3.equals(BigInteger.ZERO)) {
                        BigInteger bigIntegerModPow = bigIntegerMod3.modPow(bigIntegerShiftRight, bigIntegerZza);
                        if (!bigIntegerModPow.add(BigInteger.ONE).equals(bigIntegerZza)) {
                            if (!bigIntegerModPow.equals(BigInteger.ONE)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                            bigIntegerAdd = bigIntegerAdd.add(BigInteger.ONE);
                            i++;
                            if (i == 128 && !bigIntegerZza.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        } else {
                            BigInteger bigIntegerShiftRight2 = bigIntegerZza.add(BigInteger.ONE).shiftRight(1);
                            BigInteger bigIntegerMod4 = BigInteger.ONE;
                            BigInteger bigIntegerMod5 = bigIntegerAdd;
                            for (int iBitLength = bigIntegerShiftRight2.bitLength() - 2; iBitLength >= 0; iBitLength--) {
                                BigInteger bigIntegerMultiply = bigIntegerMod5.multiply(bigIntegerMod4);
                                bigIntegerMod5 = bigIntegerMod5.multiply(bigIntegerMod5).add(bigIntegerMod4.multiply(bigIntegerMod4).mod(bigIntegerZza).multiply(bigIntegerMod3)).mod(bigIntegerZza);
                                bigIntegerMod4 = bigIntegerMultiply.add(bigIntegerMultiply).mod(bigIntegerZza);
                                if (bigIntegerShiftRight2.testBit(iBitLength)) {
                                    BigInteger bigIntegerMod6 = bigIntegerMod5.multiply(bigIntegerAdd).add(bigIntegerMod4.multiply(bigIntegerMod3)).mod(bigIntegerZza);
                                    bigIntegerMod4 = bigIntegerAdd.multiply(bigIntegerMod4).add(bigIntegerMod5).mod(bigIntegerZza);
                                    bigIntegerMod5 = bigIntegerMod6;
                                }
                            }
                            bigIntegerAdd = bigIntegerMod5;
                        }
                    }
                    bigInteger2 = bigIntegerAdd;
                }
            }
            if (bigIntegerAdd != null && bigIntegerAdd.multiply(bigIntegerAdd).mod(bigIntegerZza).compareTo(bigIntegerMod2) != 0) {
                throw new GeneralSecurityException("Could not find a modular square root");
            }
            bigInteger2 = bigIntegerAdd;
        }
        return z != bigInteger2.testBit(0) ? bigIntegerZza.subtract(bigInteger2).mod(bigIntegerZza) : bigInteger2;
    }

    public static KeyPair zza(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGeneratorZza = zzzr.zzd.zza("EC");
        keyPairGeneratorZza.initialize(eCParameterSpec);
        return keyPairGeneratorZza.generateKeyPair();
    }

    public static ECPrivateKey zza(zzzq zzzqVar, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) zzzr.zze.zza("EC").generatePrivate(new ECPrivateKeySpec(zznu.zza(bArr), zza(zzzqVar)));
    }

    public static ECPublicKey zza(zzzq zzzqVar, zzzp zzzpVar, byte[] bArr) throws GeneralSecurityException {
        return zza(zza(zzzqVar), zzzpVar, bArr);
    }

    public static ECPublicKey zza(ECParameterSpec eCParameterSpec, zzzp zzzpVar, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) zzzr.zze.zza("EC").generatePublic(new ECPublicKeySpec(zza(eCParameterSpec.getCurve(), zzzpVar, bArr), eCParameterSpec));
    }

    public static ECParameterSpec zza(zzzq zzzqVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzzqVar.ordinal();
        if (iOrdinal == 0) {
            return zznv.zza;
        }
        if (iOrdinal == 1) {
            return zznv.zzb;
        }
        if (iOrdinal == 2) {
            return zznv.zzc;
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + String.valueOf(zzzqVar));
    }

    public static ECPoint zza(EllipticCurve ellipticCurve, zzzp zzzpVar, byte[] bArr) throws GeneralSecurityException {
        int iZza = zza(ellipticCurve);
        int iOrdinal = zzzpVar.ordinal();
        boolean z = false;
        if (iOrdinal == 0) {
            if (bArr.length != (iZza * 2) + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i = iZza + 1;
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, bArr.length)));
            zznv.zza(eCPoint, ellipticCurve);
            return eCPoint;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                if (bArr.length != iZza * 2) {
                    throw new GeneralSecurityException("invalid point size");
                }
                ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOf(bArr, iZza)), new BigInteger(1, Arrays.copyOfRange(bArr, iZza, bArr.length)));
                zznv.zza(eCPoint2, ellipticCurve);
                return eCPoint2;
            }
            throw new GeneralSecurityException("invalid format:" + String.valueOf(zzzpVar));
        }
        BigInteger bigIntegerZza = zznv.zza(ellipticCurve);
        if (bArr.length != iZza + 1) {
            throw new GeneralSecurityException("compressed point has wrong length");
        }
        byte b = bArr[0];
        if (b != 2) {
            if (b != 3) {
                throw new GeneralSecurityException("invalid format");
            }
            z = true;
        }
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
        if (bigInteger.signum() == -1 || bigInteger.compareTo(bigIntegerZza) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        return new ECPoint(bigInteger, zza(bigInteger, z, ellipticCurve));
    }

    public static byte[] zza(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        try {
            if (!zznv.zza(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            return zza(eCPrivateKey, eCPublicKey.getW());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private static byte[] zza(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        zznv.zza(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey publicKeyGeneratePublic = zzzr.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement keyAgreementZza = zzzr.zzc.zza("ECDH");
        keyAgreementZza.init(eCPrivateKey);
        try {
            keyAgreementZza.doPhase(publicKeyGeneratePublic, true);
            byte[] bArrGenerateSecret = keyAgreementZza.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, bArrGenerateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zznv.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zza(bigInteger, true, curve);
            return bArrGenerateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] zza(zzzq zzzqVar, zzzp zzzpVar, ECPoint eCPoint) throws GeneralSecurityException {
        return zza(zza(zzzqVar).getCurve(), zzzpVar, eCPoint);
    }

    public static byte[] zza(EllipticCurve ellipticCurve, zzzp zzzpVar, ECPoint eCPoint) throws GeneralSecurityException {
        zznv.zza(eCPoint, ellipticCurve);
        int iZza = zza(ellipticCurve);
        int iOrdinal = zzzpVar.ordinal();
        if (iOrdinal == 0) {
            int i = (iZza * 2) + 1;
            byte[] bArr = new byte[i];
            byte[] bArrZza = zznu.zza(eCPoint.getAffineX());
            byte[] bArrZza2 = zznu.zza(eCPoint.getAffineY());
            System.arraycopy(bArrZza2, 0, bArr, i - bArrZza2.length, bArrZza2.length);
            System.arraycopy(bArrZza, 0, bArr, (iZza + 1) - bArrZza.length, bArrZza.length);
            bArr[0] = 4;
            return bArr;
        }
        if (iOrdinal == 1) {
            int i2 = iZza + 1;
            byte[] bArr2 = new byte[i2];
            byte[] bArrZza3 = zznu.zza(eCPoint.getAffineX());
            System.arraycopy(bArrZza3, 0, bArr2, i2 - bArrZza3.length, bArrZza3.length);
            bArr2[0] = (byte) (eCPoint.getAffineY().testBit(0) ? 3 : 2);
            return bArr2;
        }
        if (iOrdinal == 2) {
            int i3 = iZza * 2;
            byte[] bArr3 = new byte[i3];
            byte[] bArrZza4 = zznu.zza(eCPoint.getAffineX());
            if (bArrZza4.length > iZza) {
                bArrZza4 = Arrays.copyOfRange(bArrZza4, bArrZza4.length - iZza, bArrZza4.length);
            }
            byte[] bArrZza5 = zznu.zza(eCPoint.getAffineY());
            if (bArrZza5.length > iZza) {
                bArrZza5 = Arrays.copyOfRange(bArrZza5, bArrZza5.length - iZza, bArrZza5.length);
            }
            System.arraycopy(bArrZza5, 0, bArr3, i3 - bArrZza5.length, bArrZza5.length);
            System.arraycopy(bArrZza4, 0, bArr3, iZza - bArrZza4.length, bArrZza4.length);
            return bArr3;
        }
        throw new GeneralSecurityException("invalid format:" + String.valueOf(zzzpVar));
    }
}
