package org.bouncycastle.crypto.parsers;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes10.dex */
public class ECIESPublicKeyParser implements KeyParser {
    private ECDomainParameters ecParams;

    public ECIESPublicKeyParser(ECDomainParameters eCDomainParameters) {
        this.ecParams = eCDomainParameters;
    }

    @Override // org.bouncycastle.crypto.KeyParser
    public AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException {
        boolean z;
        int i = inputStream.read();
        if (i < 0) {
            throw new EOFException();
        }
        if (i == 0) {
            throw new IOException("Sender's public key invalid.");
        }
        if (i == 2 || i == 3) {
            z = true;
        } else {
            if (i != 4 && i != 6 && i != 7) {
                throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(i, 16));
            }
            z = false;
        }
        ECCurve curve = this.ecParams.getCurve();
        int affinePointEncodingLength = curve.getAffinePointEncodingLength(z);
        byte[] bArr = new byte[affinePointEncodingLength];
        bArr[0] = (byte) i;
        int i2 = affinePointEncodingLength - 1;
        if (Streams.readFully(inputStream, bArr, 1, i2) == i2) {
            return new ECPublicKeyParameters(curve.decodePoint(bArr), this.ecParams);
        }
        throw new EOFException();
    }
}
