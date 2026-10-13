package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.MobileShieldInterface;
import io.mobileshield.sdk.NotReadyException;
import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.config.Method;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
public final class g2 implements Interceptor {
    public static boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MobileShieldInterface f512a;
    public final Priority b;
    public final int c;
    public final Context d;
    public static final f2 e = new f2();
    public static CountDownLatch f = new CountDownLatch(1);
    public static final AtomicInteger h = new AtomicInteger(0);

    public g2(MobileShieldInterface localMobileShield, Priority priority, int i, Context context) {
        Intrinsics.checkNotNullParameter(localMobileShield, "localMobileShield");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.f512a = localMobileShield;
        this.b = priority;
        this.c = i;
        this.d = context;
    }

    public final boolean a() {
        s3 s3Var = f1.f506a;
        f1.a(w0.a0, null);
        MobileShieldInterface mobileShieldInterface = this.f512a;
        Intrinsics.checkNotNull(mobileShieldInterface, "null cannot be cast to non-null type io.mobileshield.sdk.internal.InternalMobileShield");
        r0 r0Var = (r0) mobileShieldInterface;
        if (this.b == Priority.LAZY) {
            r0Var.f564a.b();
        } else if (a0.k.c) {
            r0Var.b();
        }
        for (int i = this.c; i > 0; i -= 100) {
            try {
                Thread.sleep(100L);
                if (r0Var.c()) {
                    break;
                }
            } catch (Exception e2) {
                s3 s3Var2 = f1.f506a;
                f1.a(w0.Z, "check: " + y.a(e2));
                return false;
            }
        }
        return r0Var.c();
    }

    public final boolean b() {
        AtomicInteger atomicInteger = h;
        atomicInteger.incrementAndGet();
        s3 s3Var = f1.f506a;
        f1.a(w0.a0, null);
        int i = this.c;
        MobileShieldInterface mobileShieldInterface = this.f512a;
        Intrinsics.checkNotNull(mobileShieldInterface, "null cannot be cast to non-null type io.mobileshield.sdk.internal.InternalMobileShield");
        r0 r0Var = (r0) mobileShieldInterface;
        try {
            try {
                if (this.b == Priority.LAZY) {
                    r0Var.f564a.b();
                } else if (a0.k.c) {
                    r0Var.b();
                }
                f2.a(r0Var);
                boolean zC = (i <= 0 || r0Var.c()) ? r0Var.c() : f.await(i, TimeUnit.MILLISECONDS);
                atomicInteger.decrementAndGet();
                return zC;
            } catch (Exception e2) {
                s3 s3Var2 = f1.f506a;
                f1.a(w0.Z, "wait: " + y.a(e2));
                h.decrementAndGet();
                return false;
            }
        } catch (Throwable th) {
            h.decrementAndGet();
            throw th;
        }
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            Request request = chain.request();
            String strHost = request.url().host();
            Request.Builder builderNewBuilder = chain.request().newBuilder();
            MobileShieldInterface mobileShieldInterface = this.f512a;
            Intrinsics.checkNotNull(mobileShieldInterface, "null cannot be cast to non-null type io.mobileshield.sdk.internal.InternalMobileShield");
            r0 r0Var = (r0) mobileShieldInterface;
            boolean z = a0.g.c;
            if (!r0Var.isValid(request)) {
                s3 s3Var = f1.f506a;
                f1.a(w0.W, null);
                return chain.proceed(request);
            }
            if (r0Var.f564a.a()) {
                return a(chain, strHost, builderNewBuilder, false);
            }
            if (this.b == Priority.LAZY) {
                if (t0.f572a.contains(new s0(Method.valueOf(request.method()), request.url().encodedPath()))) {
                    return a(chain, strHost, builderNewBuilder, true);
                }
            }
            if (z && b()) {
                return a(chain, strHost, builderNewBuilder, false);
            }
            if (!z && a()) {
                return a(chain, strHost, builderNewBuilder, false);
            }
            s3 s3Var2 = f1.f506a;
            f1.a(w0.X, null);
            throw new NotReadyException();
        } catch (Exception e2) {
            w0 exceptionLog = w0.Z;
            Intrinsics.checkNotNullParameter(e2, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var3 = f1.f506a;
            f1.a(exceptionLog, y.a(e2));
            throw e2;
        }
    }

    public final Response a(Interceptor.Chain chain, String str, Request.Builder builder, boolean z) throws IOException {
        Map headers;
        if (z) {
            Context context = this.d;
            HashMap map = new HashMap();
            map.put("x-kpsdk-v", t4.a());
            map.put("x-kpsdk-h", g0.f510a);
            map.put("x-kpsdk-dv", o0.a(context));
            headers = map;
        } else {
            headers = this.f512a.getHeaders(str);
        }
        s3 s3Var = f1.f506a;
        f1.a(w0.V, headers.toString());
        builder.header("x-kpsdk-v", t4.a());
        for (Map.Entry entry : headers.entrySet()) {
            builder.header((String) entry.getKey(), (String) entry.getValue());
        }
        Response responseProceed = chain.proceed(builder.build());
        LocalLogger.log(8, 22101L, responseProceed.toString());
        this.f512a.parseResponse(responseProceed);
        return responseProceed;
    }
}
