package org.bouncycastle.crypto.threshold;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface SplitSecret {
    byte[] getSecret() throws IOException;

    SecretShare[] getSecretShares();
}
