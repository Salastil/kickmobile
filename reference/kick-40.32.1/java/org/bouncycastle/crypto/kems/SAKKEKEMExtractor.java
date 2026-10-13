package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.crypto.params.SAKKEPrivateKeyParameters;
import org.bouncycastle.crypto.params.SAKKEPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes10.dex */
public class SAKKEKEMExtractor implements EncapsulatedSecretExtractor {
    private final ECPoint K_bs;
    private final ECPoint P;
    private final ECPoint Z_S;
    private final ECCurve curve;
    private final Digest digest;
    private final BigInteger identifier;
    private final int n;
    private final BigInteger p;
    private final BigInteger q;

    public SAKKEKEMExtractor(SAKKEPrivateKeyParameters sAKKEPrivateKeyParameters) {
        SAKKEPublicKeyParameters publicParams = sAKKEPrivateKeyParameters.getPublicParams();
        this.curve = publicParams.getCurve();
        BigInteger q = publicParams.getQ();
        this.q = q;
        ECPoint point = publicParams.getPoint();
        this.P = point;
        this.p = publicParams.getPrime();
        this.Z_S = publicParams.getZ();
        BigInteger identifier = publicParams.getIdentifier();
        this.identifier = identifier;
        this.K_bs = point.multiply(identifier.add(sAKKEPrivateKeyParameters.getMasterSecret()).modInverse(q)).normalize();
        this.n = publicParams.getN();
        this.digest = publicParams.getDigest();
    }

    static BigInteger computePairing(ECPoint eCPoint, ECPoint eCPoint2, BigInteger bigInteger, BigInteger bigInteger2) {
        char c = 0;
        BigInteger[] bigIntegerArrFp2Multiply = {BigInteger.ONE, BigInteger.ZERO};
        BigInteger bigIntegerSubtract = bigInteger2.subtract(BigInteger.ONE);
        int iBitLength = bigIntegerSubtract.bitLength();
        BigInteger bigInteger3 = eCPoint2.getAffineXCoord().toBigInteger();
        BigInteger bigInteger4 = eCPoint2.getAffineYCoord().toBigInteger();
        BigInteger bigInteger5 = eCPoint.getAffineXCoord().toBigInteger();
        BigInteger bigInteger6 = eCPoint.getAffineYCoord().toBigInteger();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(3L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2L);
        int i = iBitLength - 2;
        ECPoint eCPointNormalize = eCPoint;
        while (i >= 0) {
            BigInteger bigInteger7 = eCPointNormalize.getAffineXCoord().toBigInteger();
            BigInteger bigInteger8 = eCPointNormalize.getAffineYCoord().toBigInteger();
            char c2 = c;
            BigInteger bigIntegerMod = bigIntegerValueOf.multiply(bigInteger7.multiply(bigInteger7).subtract(BigInteger.ONE)).multiply(bigInteger8.multiply(bigIntegerValueOf2).modInverse(bigInteger)).mod(bigInteger);
            BigInteger[] bigIntegerArrFp2PointSquare = fp2PointSquare(bigIntegerArrFp2Multiply[c2], bigIntegerArrFp2Multiply[1], bigInteger);
            bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2PointSquare[c2], bigIntegerArrFp2PointSquare[1], bigIntegerMod.multiply(bigInteger3.add(bigInteger7)).subtract(bigInteger8), bigInteger4, bigInteger);
            eCPointNormalize = eCPointNormalize.twice().normalize();
            if (bigIntegerSubtract.testBit(i)) {
                BigInteger bigInteger9 = eCPointNormalize.getAffineXCoord().toBigInteger();
                BigInteger bigInteger10 = eCPointNormalize.getAffineYCoord().toBigInteger();
                bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2Multiply[c2], bigIntegerArrFp2Multiply[1], bigInteger10.subtract(bigInteger6).multiply(bigInteger9.subtract(bigInteger5).modInverse(bigInteger)).mod(bigInteger).multiply(bigInteger3.add(bigInteger9)).subtract(bigInteger10), bigInteger4, bigInteger);
                eCPointNormalize = eCPointNormalize.add(eCPoint).normalize();
            }
            i--;
            c = c2;
        }
        char c3 = c;
        BigInteger[] bigIntegerArrFp2PointSquare2 = fp2PointSquare(bigIntegerArrFp2Multiply[c3], bigIntegerArrFp2Multiply[1], bigInteger);
        BigInteger[] bigIntegerArrFp2PointSquare3 = fp2PointSquare(bigIntegerArrFp2PointSquare2[c3], bigIntegerArrFp2PointSquare2[1], bigInteger);
        return bigIntegerArrFp2PointSquare3[1].multiply(bigIntegerArrFp2PointSquare3[c3].modInverse(bigInteger)).mod(bigInteger);
    }

    static BigInteger[] fp2Multiply(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        return new BigInteger[]{bigInteger.multiply(bigInteger3).subtract(bigInteger2.multiply(bigInteger4)).mod(bigInteger5), bigInteger.multiply(bigInteger4).add(bigInteger2.multiply(bigInteger3)).mod(bigInteger5)};
    }

    static BigInteger[] fp2PointSquare(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return new BigInteger[]{bigInteger.add(bigInteger2).mod(bigInteger3).multiply(bigInteger.subtract(bigInteger2).mod(bigInteger3)).mod(bigInteger3), bigInteger.multiply(bigInteger2).multiply(BigInteger.valueOf(2L)).mod(bigInteger3)};
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        ECPoint eCPointDecodePoint = this.curve.decodePoint(Arrays.copyOfRange(bArr, 0, 257));
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 257, 16);
        BigInteger bigIntegerComputePairing = computePairing(eCPointDecodePoint, this.K_bs, this.p, this.q);
        BigInteger bigIntegerMod = bigIntegerFromUnsignedByteArray.xor(SAKKEKEMSGenerator.hashToIntegerRange(bigIntegerComputePairing.toByteArray(), BigInteger.ONE.shiftLeft(this.n), this.digest)).mod(this.p);
        BigInteger bigInteger = this.identifier;
        if (eCPointDecodePoint.equals(this.P.multiply(bigInteger).normalize().add(this.Z_S).multiply(SAKKEKEMSGenerator.hashToIntegerRange(Arrays.concatenate(bigIntegerMod.toByteArray(), bigInteger.toByteArray()), this.q, this.digest)).normalize())) {
            return BigIntegers.asUnsignedByteArray(this.n / 8, bigIntegerMod);
        }
        throw new IllegalStateException("Validation of R_bS failed");
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return 273;
    }
}
