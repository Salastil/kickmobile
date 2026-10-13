package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes11.dex */
public interface EncapsulatedSecretExtractor {
    byte[] extractSecret(byte[] bArr);

    int getEncapsulationLength();
}
