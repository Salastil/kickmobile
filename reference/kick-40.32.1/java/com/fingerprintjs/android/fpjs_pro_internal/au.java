package com.fingerprintjs.android.fpjs_pro_internal;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
public final class au {
    public static final D8871<String, Throwable> setPivotYN16904(List<String> list) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Intrinsics.checkNotNull(runtime);
            Process processExec = runtime.exec((String[]) list.toArray(new String[0]));
            Intrinsics.checkNotNull(processExec);
            if (!component5(processExec, 1000L, TimeUnit.MILLISECONDS)) {
                processExec.destroy();
                throw new TimeoutException();
            }
            if (processExec.exitValue() != 0) {
                throw new Exception();
            }
            InputStream inputStream = processExec.getInputStream();
            Intrinsics.checkNotNull(inputStream);
            InputStream inputStream2 = inputStream;
            try {
                String str = new String(ByteStreamsKt.readBytes(inputStream2), Charsets.UTF_8);
                CloseableKt.closeFinally(inputStream2, null);
                return new vD14832N6715(str);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            return new setPivotYN16904(th3);
        }
    }

    private static boolean component5(Process process, long j, TimeUnit timeUnit) throws InterruptedException {
        long jNanoTime = System.nanoTime();
        long nanos = timeUnit.toNanos(1000L);
        do {
            try {
                process.exitValue();
                return true;
            } catch (IllegalThreadStateException unused) {
                if (nanos > 0) {
                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                    Thread.sleep(Math.min((nanos / 1000000) + 1, 100L));
                }
                nanos = timeUnit.toNanos(1000L) - (System.nanoTime() - jNanoTime);
            }
        } while (nanos > 0);
        return false;
    }
}
