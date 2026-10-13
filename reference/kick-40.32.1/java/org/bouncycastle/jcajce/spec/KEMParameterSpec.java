package org.bouncycastle.jcajce.spec;

/* JADX INFO: loaded from: classes11.dex */
public class KEMParameterSpec extends KTSParameterSpec {
    public KEMParameterSpec(String str) {
        this(str, 256);
    }

    public KEMParameterSpec(String str, int i) {
        super(str, i, null, null, null);
    }

    public int getKeySizeInBits() {
        return getKeySize();
    }
}
