package org.bouncycastle.crypto.signers;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ECCSIPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECCSIPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes10.dex */
public class ECCSISigner implements Signer {
    private final ECPoint G;
    private final int N;
    private ECPoint Y;
    private final Digest digest;
    private boolean forSigning;
    private final byte[] id;
    private BigInteger j;
    private final ECPoint kpak;
    private CipherParameters param;
    private final BigInteger q;
    private BigInteger r;
    private ByteArrayOutputStream stream;

    public ECCSISigner(ECPoint eCPoint, X9ECParameters x9ECParameters, Digest digest, byte[] bArr) {
        this.kpak = eCPoint;
        this.id = bArr;
        this.q = x9ECParameters.getCurve().getOrder();
        this.G = x9ECParameters.getG();
        this.digest = digest;
        digest.reset();
        this.N = (x9ECParameters.getCurve().getOrder().bitLength() + 7) >> 3;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws DataLengthException, CryptoException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) ((ParametersWithRandom) this.param).getParameters();
        BigInteger bigIntegerMod = new BigInteger(1, bArr).add(this.r.multiply(eCCSIPrivateKeyParameters.getSSK())).mod(this.q);
        if (bigIntegerMod.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Invalid j, retry");
        }
        return Arrays.concatenate(BigIntegers.asUnsignedByteArray(this.N, this.r), BigIntegers.asUnsignedByteArray(this.N, bigIntegerMod.modInverse(this.q).multiply(this.j).mod(this.q)), eCCSIPrivateKeyParameters.getPublicKeyParameters().getPVT().getEncoded(false));
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        this.param = cipherParameters;
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        SecureRandom random;
        ECPoint pvt;
        ECPoint eCPointMultiply;
        this.digest.reset();
        CipherParameters parameters = this.param;
        if (parameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) parameters;
            random = parametersWithRandom.getRandom();
            parameters = parametersWithRandom.getParameters();
        } else {
            random = null;
        }
        if (this.forSigning) {
            ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) parameters;
            pvt = eCCSIPrivateKeyParameters.getPublicKeyParameters().getPVT();
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(this.q.bitLength(), random);
            this.j = bigIntegerCreateRandomBigInteger;
            this.r = this.G.multiply(bigIntegerCreateRandomBigInteger).normalize().getAffineXCoord().toBigInteger().mod(this.q);
            eCPointMultiply = this.G.multiply(eCCSIPrivateKeyParameters.getSSK());
        } else {
            ECPoint pvt2 = ((ECCSIPublicKeyParameters) parameters).getPVT();
            this.stream = new ByteArrayOutputStream();
            pvt = pvt2;
            eCPointMultiply = null;
        }
        byte[] encoded = this.G.getEncoded(false);
        this.digest.update(encoded, 0, encoded.length);
        byte[] encoded2 = this.kpak.getEncoded(false);
        this.digest.update(encoded2, 0, encoded2.length);
        Digest digest = this.digest;
        byte[] bArr = this.id;
        digest.update(bArr, 0, bArr.length);
        byte[] encoded3 = pvt.getEncoded(false);
        this.digest.update(encoded3, 0, encoded3.length);
        int digestSize = this.digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.digest.doFinal(bArr2, 0);
        BigInteger bigIntegerMod = new BigInteger(1, bArr2).mod(this.q);
        this.digest.update(bArr2, 0, digestSize);
        if (!this.forSigning) {
            this.Y = pvt.multiply(bigIntegerMod).add(this.kpak).normalize();
        } else {
            if (!eCPointMultiply.subtract(pvt.multiply(bigIntegerMod)).normalize().equals(this.kpak)) {
                throw new IllegalArgumentException("Invalid KPAK");
            }
            byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.N, this.r);
            this.digest.update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b) {
        if (this.forSigning) {
            this.digest.update(b);
        } else {
            this.stream.write(b);
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        if (this.forSigning) {
            this.digest.update(bArr, i, i2);
        } else {
            this.stream.write(bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, this.N);
        int i = this.N;
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, i, i << 1));
        this.r = new BigInteger(1, bArrCopyOf).mod(this.q);
        this.digest.update(bArrCopyOf, 0, this.N);
        byte[] byteArray = this.stream.toByteArray();
        this.digest.update(byteArray, 0, byteArray.length);
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        return this.G.multiply(new BigInteger(1, bArr2).mod(this.q)).normalize().add(this.Y.multiply(this.r).normalize()).normalize().multiply(bigInteger).normalize().getAffineXCoord().toBigInteger().mod(this.q).equals(this.r.mod(this.q));
    }
}
