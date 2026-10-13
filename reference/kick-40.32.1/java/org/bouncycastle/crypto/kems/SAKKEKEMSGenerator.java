package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.SAKKEPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes10.dex */
public class SAKKEKEMSGenerator implements EncapsulatedSecretGenerator {
    private final SecureRandom random;

    public SAKKEKEMSGenerator(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    static BigInteger hashToIntegerRange(byte[] bArr, BigInteger bigInteger, Digest digest) {
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        byte[] bArrClone = Arrays.clone(bArr2);
        int digestSize = digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int iBitLength = bigInteger.bitLength() >> 8;
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i = 0; i <= iBitLength; i++) {
            digest.update(bArr3, 0, digestSize);
            digest.doFinal(bArr3, 0);
            digest.update(bArr3, 0, digestSize);
            digest.update(bArrClone, 0, bArrClone.length);
            int digestSize2 = digest.getDigestSize();
            byte[] bArr4 = new byte[digestSize2];
            digest.doFinal(bArr4, 0);
            bigIntegerAdd = bigIntegerAdd.shiftLeft(digestSize2 * 8).add(new BigInteger(1, bArr4));
        }
        return bigIntegerAdd.mod(bigInteger);
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        SAKKEPublicKeyParameters sAKKEPublicKeyParameters = (SAKKEPublicKeyParameters) asymmetricKeyParameter;
        ECPoint z = sAKKEPublicKeyParameters.getZ();
        BigInteger identifier = sAKKEPublicKeyParameters.getIdentifier();
        BigInteger prime = sAKKEPublicKeyParameters.getPrime();
        BigInteger q = sAKKEPublicKeyParameters.getQ();
        BigInteger g = sAKKEPublicKeyParameters.getG();
        int n = sAKKEPublicKeyParameters.getN();
        ECCurve curve = sAKKEPublicKeyParameters.getCurve();
        ECPoint point = sAKKEPublicKeyParameters.getPoint();
        Digest digest = sAKKEPublicKeyParameters.getDigest();
        BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(n, this.random);
        BigInteger bigIntegerHashToIntegerRange = hashToIntegerRange(Arrays.concatenate(bigIntegerCreateRandomBigInteger.toByteArray(), identifier.toByteArray()), q, digest);
        ECPoint eCPointNormalize = point.multiply(identifier).normalize().add(z).multiply(bigIntegerHashToIntegerRange).normalize();
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigInteger2 = BigInteger.ONE;
        ECPoint eCPointCreatePoint = curve.createPoint(bigInteger2, g);
        BigInteger bigInteger3 = g;
        for (int iBitLength = bigIntegerHashToIntegerRange.bitLength() - 2; iBitLength >= 0; iBitLength--) {
            BigInteger[] bigIntegerArrFp2PointSquare = SAKKEKEMExtractor.fp2PointSquare(bigInteger2, bigInteger3, prime);
            eCPointCreatePoint = eCPointCreatePoint.timesPow2(2);
            BigInteger bigInteger4 = bigIntegerArrFp2PointSquare[0];
            BigInteger bigInteger5 = bigIntegerArrFp2PointSquare[1];
            if (bigIntegerHashToIntegerRange.testBit(iBitLength)) {
                BigInteger[] bigIntegerArrFp2Multiply = SAKKEKEMExtractor.fp2Multiply(bigInteger4, bigInteger5, bigInteger, g, prime);
                bigInteger4 = bigIntegerArrFp2Multiply[0];
                bigInteger5 = bigIntegerArrFp2Multiply[1];
            }
            BigInteger bigInteger6 = bigInteger4;
            bigInteger3 = bigInteger5;
            bigInteger2 = bigInteger6;
        }
        BigInteger[] bigIntegerArr = {bigInteger2, bigInteger3};
        return new SecretWithEncapsulationImpl(BigIntegers.asUnsignedByteArray(n / 8, bigIntegerCreateRandomBigInteger), Arrays.concatenate(eCPointNormalize.getEncoded(false), BigIntegers.asUnsignedByteArray(16, bigIntegerCreateRandomBigInteger.xor(hashToIntegerRange(bigIntegerArr[1].multiply(bigIntegerArr[0].modInverse(prime)).mod(prime).toByteArray(), BigInteger.ONE.shiftLeft(n), digest)))));
    }
}
