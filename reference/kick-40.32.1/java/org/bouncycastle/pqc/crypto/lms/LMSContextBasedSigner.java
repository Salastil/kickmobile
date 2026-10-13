package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes11.dex */
public interface LMSContextBasedSigner {
    LMSContext generateLMSContext();

    byte[] generateSignature(LMSContext lMSContext);

    long getUsagesRemaining();
}
