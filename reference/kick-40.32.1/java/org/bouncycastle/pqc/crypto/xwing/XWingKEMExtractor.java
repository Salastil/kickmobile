package org.bouncycastle.pqc.crypto.xwing;

import org.bouncycastle.crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMExtractor;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class XWingKEMExtractor implements EncapsulatedSecretExtractor {
    private static final int MLKEM_CIPHERTEXT_SIZE = 1088;
    private final XWingPrivateKeyParameters key;
    private final MLKEMExtractor mlkemExtractor;

    public XWingKEMExtractor(XWingPrivateKeyParameters xWingPrivateKeyParameters) {
        this.key = xWingPrivateKeyParameters;
        this.mlkemExtractor = new MLKEMExtractor(xWingPrivateKeyParameters.getKyberPrivateKey());
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, MLKEM_CIPHERTEXT_SIZE);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, MLKEM_CIPHERTEXT_SIZE, bArr.length);
        byte[] bArrComputeSSX = XWingKEMGenerator.computeSSX(new X25519PublicKeyParameters(bArrCopyOfRange2, 0), this.key.getXDHPrivateKey());
        byte[] bArrComputeSharedSecret = XWingKEMGenerator.computeSharedSecret(this.key.getXDHPublicKey().getEncoded(), this.mlkemExtractor.extractSecret(bArrCopyOfRange), bArrCopyOfRange2, bArrComputeSSX);
        Arrays.clear(bArrComputeSSX);
        return bArrComputeSharedSecret;
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.mlkemExtractor.getEncapsulationLength() + 32;
    }
}
