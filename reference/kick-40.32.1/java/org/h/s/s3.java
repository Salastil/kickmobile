package org.h.s;

import expo.modules.crypto.aes.AesConfig;
import io.mobileshield.sdk.config.Config;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes11.dex */
public final class s3 {
    public static boolean f;
    public static boolean g;
    public static Config h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f570a;
    public final CoroutineDispatcher b;
    public final l1 c;
    public final y0 d;
    public final Mutex e;

    public s3(CoroutineDispatcher dispatcherIO, CoroutineDispatcher dispatcherDefault, l1 loggerStorage, y0 analyser) {
        Intrinsics.checkNotNullParameter(dispatcherIO, "dispatcherIO");
        Intrinsics.checkNotNullParameter(dispatcherDefault, "dispatcherDefault");
        Intrinsics.checkNotNullParameter(loggerStorage, "loggerStorage");
        Intrinsics.checkNotNullParameter(analyser, "analyser");
        this.f570a = dispatcherIO;
        this.b = dispatcherDefault;
        this.c = loggerStorage;
        this.d = analyser;
        this.e = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        if (r10.ordinal() != 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(org.h.s.s3 r9, org.h.s.x0 r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.h.s.s3.a(org.h.s.s3, org.h.s.x0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final synchronized void a() {
        TimeUnit timeUnit = t4.f575a;
        l1 l1Var = this.c;
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AesConfig.CRYPTO_KEY_ALGORITHM);
        keyGenerator.init(256);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        String strA = l1Var.a(secretKeyGenerateKey);
        Job jobLaunch$default = null;
        if (strA != null) {
            try {
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f570a), null, null, new o3(this, a5.a(strA), null), 3, null);
            } catch (IOException unused) {
                s3 s3Var = f1.f506a;
                f1.a(w0.c, "gzip error");
                return;
            }
        }
        if (jobLaunch$default == null) {
            f = false;
            Unit unit = Unit.INSTANCE;
        }
    }
}
