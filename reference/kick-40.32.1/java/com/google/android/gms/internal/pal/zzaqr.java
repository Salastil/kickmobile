package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqr {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzagz.zzc(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static ECPoint zzb(EllipticCurve ellipticCurve, zzaqq zzaqqVar, byte[] bArr) throws GeneralSecurityException {
        int iZza = zza(ellipticCurve);
        int iOrdinal = zzaqqVar.ordinal();
        boolean z = false;
        if (iOrdinal == 0) {
            int length = bArr.length;
            if (length != iZza + iZza + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i = iZza + 1;
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, length)));
            zzagz.zza(eCPoint, ellipticCurve);
            return eCPoint;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                String strValueOf = String.valueOf(zzaqqVar);
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("invalid format:".concat(String.valueOf(strValueOf)));
            }
            int i2 = iZza + iZza;
            int length2 = bArr.length;
            if (length2 != i2) {
                throw new GeneralSecurityException("invalid point size");
            }
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOf(bArr, iZza)), new BigInteger(1, Arrays.copyOfRange(bArr, iZza, length2)));
            zzagz.zza(eCPoint2, ellipticCurve);
            return eCPoint2;
        }
        int i3 = iZza + 1;
        BigInteger bigIntegerZzc = zzagz.zzc(ellipticCurve);
        int length3 = bArr.length;
        if (length3 != i3) {
            throw new GeneralSecurityException("compressed point has wrong length");
        }
        byte b = bArr[0];
        if (b != 2) {
            if (b != 3) {
                throw new GeneralSecurityException("invalid format");
            }
            z = true;
        }
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length3));
        if (bigInteger.signum() == -1 || bigInteger.compareTo(bigIntegerZzc) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        return new ECPoint(bigInteger, zzg(bigInteger, z, ellipticCurve));
    }

    public static byte[] zzc(EllipticCurve ellipticCurve, zzaqq zzaqqVar, ECPoint eCPoint) throws GeneralSecurityException {
        zzagz.zza(eCPoint, ellipticCurve);
        int iZza = zza(ellipticCurve);
        int iOrdinal = zzaqqVar.ordinal();
        if (iOrdinal == 0) {
            int i = iZza + 1;
            int i2 = iZza + iZza + 1;
            byte[] bArr = new byte[i2];
            byte[] bArrZza = zzagv.zza(eCPoint.getAffineX());
            byte[] bArrZza2 = zzagv.zza(eCPoint.getAffineY());
            int length = bArrZza2.length;
            System.arraycopy(bArrZza2, 0, bArr, i2 - length, length);
            int length2 = bArrZza.length;
            System.arraycopy(bArrZza, 0, bArr, i - length2, length2);
            bArr[0] = 4;
            return bArr;
        }
        if (iOrdinal == 1) {
            int i3 = iZza + 1;
            byte[] bArr2 = new byte[i3];
            byte[] bArrZza3 = zzagv.zza(eCPoint.getAffineX());
            int length3 = bArrZza3.length;
            System.arraycopy(bArrZza3, 0, bArr2, i3 - length3, length3);
            bArr2[0] = true == eCPoint.getAffineY().testBit(0) ? (byte) 3 : (byte) 2;
            return bArr2;
        }
        if (iOrdinal != 2) {
            String strValueOf = String.valueOf(zzaqqVar);
            String.valueOf(strValueOf);
            throw new GeneralSecurityException("invalid format:".concat(String.valueOf(strValueOf)));
        }
        int i4 = iZza + iZza;
        byte[] bArr3 = new byte[i4];
        byte[] bArrZza4 = zzagv.zza(eCPoint.getAffineX());
        int length4 = bArrZza4.length;
        if (length4 > iZza) {
            bArrZza4 = Arrays.copyOfRange(bArrZza4, length4 - iZza, length4);
        }
        byte[] bArrZza5 = zzagv.zza(eCPoint.getAffineY());
        int length5 = bArrZza5.length;
        if (length5 > iZza) {
            bArrZza5 = Arrays.copyOfRange(bArrZza5, length5 - iZza, length5);
        }
        int length6 = bArrZza5.length;
        System.arraycopy(bArrZza5, 0, bArr3, i4 - length6, length6);
        int length7 = bArrZza4.length;
        System.arraycopy(bArrZza4, 0, bArr3, iZza - length7, length7);
        return bArr3;
    }

    public static ECParameterSpec zzd(zzaqp zzaqpVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzaqpVar.ordinal();
        if (iOrdinal == 0) {
            return zzagz.zza;
        }
        if (iOrdinal == 1) {
            return zzagz.zzb;
        }
        if (iOrdinal == 2) {
            return zzagz.zzc;
        }
        String strValueOf = String.valueOf(zzaqpVar);
        String.valueOf(strValueOf);
        throw new NoSuchAlgorithmException("curve not implemented:".concat(String.valueOf(strValueOf)));
    }

    public static KeyPair zze(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzaqx.zzd.zzb("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] zzf(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        try {
            if (!zzagz.zzb(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            ECPoint w = eCPublicKey.getW();
            zzagz.zza(w, eCPrivateKey.getParams().getCurve());
            PublicKey publicKeyGeneratePublic = ((KeyFactory) zzaqx.zze.zzb("EC")).generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
            KeyAgreement keyAgreement = (KeyAgreement) zzaqx.zzc.zzb("ECDH");
            keyAgreement.init(eCPrivateKey);
            try {
                keyAgreement.doPhase(publicKeyGeneratePublic, true);
                byte[] bArrGenerateSecret = keyAgreement.generateSecret();
                EllipticCurve curve = eCPrivateKey.getParams().getCurve();
                BigInteger bigInteger = new BigInteger(1, bArrGenerateSecret);
                if (bigInteger.signum() == -1 || bigInteger.compareTo(zzagz.zzc(curve)) >= 0) {
                    throw new GeneralSecurityException("shared secret is out of range");
                }
                zzg(bigInteger, true, curve);
                return bArrGenerateSecret;
            } catch (IllegalStateException e) {
                throw new GeneralSecurityException(e);
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    private static BigInteger zzg(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigIntegerModPow;
        BigInteger bigInteger2;
        BigInteger bigIntegerZzc = zzagz.zzc(ellipticCurve);
        BigInteger bigIntegerMod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(bigIntegerZzc);
        if (bigIntegerZzc.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger bigIntegerMod2 = bigIntegerMod.mod(bigIntegerZzc);
        if (bigIntegerMod2.equals(BigInteger.ZERO)) {
            bigInteger2 = BigInteger.ZERO;
        } else {
            if (bigIntegerZzc.testBit(0) && bigIntegerZzc.testBit(1)) {
                bigIntegerModPow = bigIntegerMod2.modPow(bigIntegerZzc.add(BigInteger.ONE).shiftRight(2), bigIntegerZzc);
            } else {
                bigIntegerModPow = null;
                if (bigIntegerZzc.testBit(0) && !bigIntegerZzc.testBit(1)) {
                    BigInteger bigIntegerAdd = BigInteger.ONE;
                    BigInteger bigIntegerShiftRight = bigIntegerZzc.subtract(BigInteger.ONE).shiftRight(1);
                    int i = 0;
                    while (true) {
                        BigInteger bigIntegerMod3 = bigIntegerAdd.multiply(bigIntegerAdd).subtract(bigIntegerMod2).mod(bigIntegerZzc);
                        if (bigIntegerMod3.equals(BigInteger.ZERO)) {
                            bigInteger2 = bigIntegerAdd;
                        } else {
                            BigInteger bigIntegerModPow2 = bigIntegerMod3.modPow(bigIntegerShiftRight, bigIntegerZzc);
                            if (bigIntegerModPow2.add(BigInteger.ONE).equals(bigIntegerZzc)) {
                                BigInteger bigIntegerShiftRight2 = bigIntegerZzc.add(BigInteger.ONE).shiftRight(1);
                                BigInteger bigIntegerMod4 = BigInteger.ONE;
                                BigInteger bigInteger3 = bigIntegerAdd;
                                for (int iBitLength = bigIntegerShiftRight2.bitLength() - 2; iBitLength >= 0; iBitLength--) {
                                    BigInteger bigIntegerMultiply = bigInteger3.multiply(bigIntegerMod4);
                                    BigInteger bigIntegerMod5 = bigInteger3.multiply(bigInteger3).add(bigIntegerMod4.multiply(bigIntegerMod4).mod(bigIntegerZzc).multiply(bigIntegerMod3)).mod(bigIntegerZzc);
                                    BigInteger bigIntegerMod6 = bigIntegerMultiply.add(bigIntegerMultiply).mod(bigIntegerZzc);
                                    if (bigIntegerShiftRight2.testBit(iBitLength)) {
                                        BigInteger bigIntegerMod7 = bigIntegerMod5.multiply(bigIntegerAdd).add(bigIntegerMod6.multiply(bigIntegerMod3)).mod(bigIntegerZzc);
                                        bigIntegerMod4 = bigIntegerAdd.multiply(bigIntegerMod6).add(bigIntegerMod5).mod(bigIntegerZzc);
                                        bigInteger3 = bigIntegerMod7;
                                    } else {
                                        bigInteger3 = bigIntegerMod5;
                                        bigIntegerMod4 = bigIntegerMod6;
                                    }
                                }
                                bigIntegerModPow = bigInteger3;
                            } else {
                                if (!bigIntegerModPow2.equals(BigInteger.ONE)) {
                                    throw new InvalidAlgorithmParameterException("p is not prime");
                                }
                                bigIntegerAdd = bigIntegerAdd.add(BigInteger.ONE);
                                i++;
                                if (i == 128 && !bigIntegerZzc.isProbablePrime(80)) {
                                    throw new InvalidAlgorithmParameterException("p is not prime");
                                }
                            }
                        }
                    }
                }
            }
            if (bigIntegerModPow != null && bigIntegerModPow.multiply(bigIntegerModPow).mod(bigIntegerZzc).compareTo(bigIntegerMod2) != 0) {
                throw new GeneralSecurityException("Could not find a modular square root");
            }
            bigInteger2 = bigIntegerModPow;
        }
        return z != bigInteger2.testBit(0) ? bigIntegerZzc.subtract(bigInteger2).mod(bigIntegerZzc) : bigInteger2;
    }
}
