package org.bouncycastle.crypto.threshold;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface SecretSplitter {
    SplitSecret resplit(byte[] bArr, int i, int i2);

    SplitSecret split(int i, int i2);

    SplitSecret splitAround(SecretShare secretShare, int i, int i2) throws IOException;
}
