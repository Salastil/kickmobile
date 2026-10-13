package com.google.android.gms.internal.pal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzcs implements Runnable {
    private zzcs() {
        throw null;
    }

    /* synthetic */ zzcs(byte[] bArr) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzct.zzd = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            countDownLatch = zzct.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzct.zzb;
        } catch (Throwable th) {
            zzct.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
