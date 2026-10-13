package io.mobileshield.sdk;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import io.mobileshield.sdk.logger.LoggerHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.h.s.c2;
import org.h.s.e1;
import org.h.s.f1;
import org.h.s.i4;
import org.h.s.r0;
import org.h.s.s3;
import org.h.s.s4;
import org.h.s.t4;
import org.h.s.w0;
import org.h.s.y;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0014J+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0015J=\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u001a\u0010\u001f\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007J$\u0010'\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001a2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0%H\u0007J+\u0010(\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0004\b(\u0010\u0015J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0007J\"\u0010+\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0007J\u0016\u00102\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200J.\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0%2\u0006\u00103\u001a\u00020\t2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0%J\u000e\u00106\u001a\u00020\"2\u0006\u00103\u001a\u00020\tJ\u0006\u00107\u001a\u00020\"J\u000e\u00108\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.J\u0010\u00108\u001a\u00020\u00102\u0006\u0010:\u001a\u000209H\u0007J\u001c\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0%2\u0006\u00103\u001a\u00020\tH\u0007J)\u0010>\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\"H\u0001¢\u0006\u0004\b<\u0010=J\b\u0010?\u001a\u00020\u0002H\u0007J\b\u0010A\u001a\u00020@H\u0007R$\u0010B\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010E¨\u0006O"}, d2 = {"Lio/mobileshield/sdk/MobileShield;", "", "Lorg/h/s/r0;", "getInternalShieldWhenNull", "Landroid/content/Context;", "ctx", "Lio/mobileshield/sdk/Priority;", "priority", "getInstance", "", "userAgent", "Lio/mobileshield/sdk/MobileShieldReadinessListener;", "mobileShieldReadinessListener", "", "Lio/mobileshield/sdk/config/Config;", "listConfigs", "", "init", "(Ljava/lang/String;Lio/mobileshield/sdk/MobileShieldReadinessListener;[Lio/mobileshield/sdk/config/Config;)V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "(Landroid/content/Context;Ljava/lang/String;Lio/mobileshield/sdk/MobileShieldReadinessListener;Lio/mobileshield/sdk/Priority;[Lio/mobileshield/sdk/config/Config;)V", "(Ljava/lang/String;[Lio/mobileshield/sdk/config/Config;)V", "(Landroid/content/Context;Ljava/lang/String;Lio/mobileshield/sdk/Priority;[Lio/mobileshield/sdk/config/Config;)V", "dispose", "Lokhttp3/Interceptor;", "obtainInterceptor", "", "timeMs", "Lio/mobileshield/sdk/logger/LoggerHandler;", "loggerHandler", "logType", "logger", "Lokhttp3/Request;", "originalRequest", "", "isValid", "statusCode", "", "headers", "checkResponse", "update", "Lio/mobileshield/sdk/HeadersCallback;", "headersCallback", "getHeaders", FirebaseAnalytics.Param.METHOD, ImagesContract.URL, "Ljava/net/HttpURLConnection;", "urlConnection", "Lio/mobileshield/sdk/ClientCallback;", "callback", "protect", "domainname", "userHeader", "mergeHeaders", "isReadyForDomain", "isReadyForAllDomains", "parseResponse", "Lokhttp3/Response;", "response", "getInstanceCall", "initShield$sdk_release", "(Landroid/content/Context;Lio/mobileshield/sdk/Priority;Z)V", "initShield", "getMobileShield", "Lorg/h/s/i4;", "getStore", "sdkMobileShield", "Lorg/h/s/r0;", "getSdkMobileShield$sdk_release", "()Lorg/h/s/r0;", "setSdkMobileShield$sdk_release", "(Lorg/h/s/r0;)V", "Ljava/util/concurrent/CountDownLatch;", "awaitInternalShield", "Ljava/util/concurrent/CountDownLatch;", "getInternalMobileShield", "internalMobileShield", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final class MobileShield {
    public static final MobileShield INSTANCE = new MobileShield();
    private static CountDownLatch awaitInternalShield = new CountDownLatch(1);
    private static r0 sdkMobileShield;

    private MobileShield() {
    }

    @JvmStatic
    public static final void checkResponse(int statusCode, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.u, null);
            INSTANCE.getInternalMobileShield().checkResponse(statusCode, headers);
        } catch (Exception e) {
            y.b(e, w0.i);
            throw null;
        }
    }

    @JvmStatic
    public static final void dispose() {
        try {
            r0 r0Var = sdkMobileShield;
            if (r0Var != null) {
                r0Var.dispose();
            }
            sdkMobileShield = null;
            awaitInternalShield = new CountDownLatch(1);
        } catch (Exception e) {
            y.b(e, w0.p);
            throw null;
        }
    }

    @JvmStatic
    public static final void getHeaders(String url, HeadersCallback headersCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        getHeaders$default(null, url, headersCallback, 1, null);
    }

    public static /* synthetic */ void getHeaders$default(String str, String str2, HeadersCallback headersCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "GET";
        }
        getHeaders(str, str2, headersCallback);
    }

    @Deprecated(message = "No longer required to access functions in MobileShield.", replaceWith = @ReplaceWith(expression = "MobileShield", imports = {}))
    @JvmStatic
    public static final MobileShield getInstance(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return getInstance$default(ctx, null, 2, null);
    }

    public static /* synthetic */ MobileShield getInstance$default(Context context, Priority priority, int i, Object obj) {
        if ((i & 2) != 0) {
            priority = Priority.LOW;
        }
        return getInstance(context, priority);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r0 getInternalMobileShield() {
        r0 r0Var = sdkMobileShield;
        return r0Var == null ? getInternalShieldWhenNull() : r0Var;
    }

    private final r0 getInternalShieldWhenNull() throws InitializeException, InterruptedException {
        if (!c2.b) {
            s3 s3Var = f1.f506a;
            f1.a(w0.B, null);
            throw new InitializeException("Mobile Shield Not Initialized.");
        }
        awaitInternalShield.await(1000L, t4.f575a);
        r0 r0Var = sdkMobileShield;
        if (r0Var != null) {
            return r0Var;
        }
        s3 s3Var2 = f1.f506a;
        f1.a(w0.B, null);
        throw new InitializeException("Mobile Shield Not Initialized.");
    }

    @JvmStatic
    public static final void init(Context context, String userAgent, MobileShieldReadinessListener mobileShieldReadinessListener, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        init$default(context, userAgent, mobileShieldReadinessListener, null, listConfigs, 8, null);
    }

    public static /* synthetic */ void init$default(Context context, String str, MobileShieldReadinessListener mobileShieldReadinessListener, Priority priority, Config[] configArr, int i, Object obj) {
        if ((i & 8) != 0) {
            priority = Priority.LOW;
        }
        init(context, str, mobileShieldReadinessListener, priority, configArr);
    }

    public static /* synthetic */ void initShield$sdk_release$default(MobileShield mobileShield, Context context, Priority priority, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        mobileShield.initShield$sdk_release(context, priority, z);
    }

    @Deprecated(message = "Do not use - this method is intended for internal use.")
    @JvmStatic
    public static final boolean isValid(Request originalRequest) {
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        return false;
    }

    @JvmStatic
    public static final void logger(LoggerHandler loggerHandler, int logType) {
        try {
            LocalLogger.init(loggerHandler, logType);
            s3 s3Var = f1.f506a;
            f1.a(w0.z, e1.a(logType));
        } catch (Exception e) {
            w0 exceptionLog = w0.n;
            Intrinsics.checkNotNullParameter(e, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var2 = f1.f506a;
            f1.a(exceptionLog, y.a(e));
        }
    }

    @JvmStatic
    public static final Interceptor obtainInterceptor() {
        try {
            return INSTANCE.getInternalMobileShield().obtainInterceptor(null);
        } catch (Exception e) {
            y.b(e, w0.o);
            throw null;
        }
    }

    @JvmStatic
    public static final void update(String userAgent, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.r, null);
            INSTANCE.getInternalMobileShield().update(userAgent, (Config[]) Arrays.copyOf(listConfigs, listConfigs.length));
        } catch (Exception e) {
            y.b(e, w0.g);
            throw null;
        }
    }

    public final r0 getMobileShield() {
        return getInternalMobileShield();
    }

    public final r0 getSdkMobileShield$sdk_release() {
        return sdkMobileShield;
    }

    public final i4 getStore() {
        i4 i4Var = getInternalMobileShield().f564a;
        Intrinsics.checkNotNull(i4Var, "null cannot be cast to non-null type io.mobileshield.sdk.store.StoreController");
        return i4Var;
    }

    public final void initShield$sdk_release(Context ctx, Priority priority, boolean getInstanceCall) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(priority, "priority");
        dispose();
        Context applicationContext = ctx.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        sdkMobileShield = new r0(applicationContext, priority, getInstanceCall);
        awaitInternalShield.countDown();
    }

    public final boolean isReadyForAllDomains() {
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.y, null);
            return getInternalMobileShield().isReadyForAllDomains();
        } catch (Exception e) {
            w0 exceptionLog = w0.m;
            Intrinsics.checkNotNullParameter(e, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var2 = f1.f506a;
            f1.a(exceptionLog, y.a(e));
            return false;
        }
    }

    public final boolean isReadyForDomain(String domainname) {
        Intrinsics.checkNotNullParameter(domainname, "domainname");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.x, "domain: " + domainname);
            return getInternalMobileShield().isReadyForDomain(domainname);
        } catch (Exception e) {
            y.a(e, w0.l);
            return false;
        }
    }

    public final Map<String, String> mergeHeaders(String domainname, Map<String, String> userHeader) {
        Intrinsics.checkNotNullParameter(domainname, "domainname");
        Intrinsics.checkNotNullParameter(userHeader, "userHeader");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.w, "domain: " + domainname);
            return getInternalMobileShield().mergeHeaders(domainname, userHeader);
        } catch (Exception e) {
            y.b(e, w0.k);
            throw null;
        }
    }

    @Deprecated(message = "Do not use - this method is intended for internal use.")
    public final void parseResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public final void protect(HttpURLConnection urlConnection, ClientCallback callback) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.s, null);
            getInternalMobileShield().protect(urlConnection, callback);
        } catch (Exception e) {
            w0 exceptionLog = w0.h;
            Intrinsics.checkNotNullParameter(e, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var2 = f1.f506a;
            f1.a(exceptionLog, y.a(e));
            callback.onError(y.a(e));
        }
    }

    public final void setSdkMobileShield$sdk_release(r0 r0Var) {
        sdkMobileShield = r0Var;
    }

    @Deprecated(message = "No longer required to access functions in MobileShield.", replaceWith = @ReplaceWith(expression = "MobileShield", imports = {}))
    @JvmStatic
    public static final MobileShield getInstance(Context ctx, Priority priority) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(priority, "priority");
        try {
            if (sdkMobileShield == null) {
                INSTANCE.initShield$sdk_release(ctx, priority, true);
            }
            return INSTANCE;
        } catch (Exception e) {
            y.b(e, w0.e);
            throw null;
        }
    }

    @JvmStatic
    public static final void init(Context context, String userAgent, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        init$default(context, userAgent, null, listConfigs, 4, null);
    }

    @Deprecated(message = "Use updated getHeaders function: getHeaders(headersCallback)", replaceWith = @ReplaceWith(expression = "MobileShield.getHeaders(headersCallback)", imports = {"io.mobileshield.sdk.MobileShield.getHeaders"}))
    public final Map<String, String> getHeaders(String domainname) {
        Intrinsics.checkNotNullParameter(domainname, "domainname");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.v, "(Deprecated) domain: " + domainname);
            return getInternalMobileShield().getHeaders(domainname);
        } catch (Exception e) {
            y.b(e, w0.j);
            throw null;
        }
    }

    public final void parseResponse(HttpURLConnection urlConnection) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.t, null);
            r0 internalMobileShield = getInternalMobileShield();
            internalMobileShield.getClass();
            Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
            internalMobileShield.f564a.a(s4.a(urlConnection, internalMobileShield.f564a));
        } catch (Exception e) {
            y.b(e, w0.h);
            throw null;
        }
    }

    @Deprecated(message = "Use updated init function: init(context, userAgent, mobileShieldReadinessListener, priority, listConfigs)", replaceWith = @ReplaceWith(expression = "MobileShield.init(context, userAgent, mobileShieldReadinessListener, priority, listConfigs)", imports = {"io.mobileshield.sdk.MobileShield.init"}))
    @JvmStatic
    public static final void init(final String userAgent, final MobileShieldReadinessListener mobileShieldReadinessListener, final Config... listConfigs) {
        String str;
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        if (mobileShieldReadinessListener == null) {
            str = "";
        } else {
            str = "and listener attached";
        }
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.q, "(Deprecated) Initializing; ".concat(str));
            CoroutineDispatcher coroutineDispatcher = c2.f493a;
            c2.a(new Function0<Unit>() { // from class: io.mobileshield.sdk.MobileShield.init.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    r0 internalMobileShield = MobileShield.INSTANCE.getInternalMobileShield();
                    String str2 = userAgent;
                    MobileShieldReadinessListener mobileShieldReadinessListener2 = mobileShieldReadinessListener;
                    Config[] configArr = listConfigs;
                    internalMobileShield.init(str2, mobileShieldReadinessListener2, (Config[]) Arrays.copyOf(configArr, configArr.length));
                }
            });
        } catch (Exception e) {
            y.b(e, w0.f);
            throw null;
        }
    }

    public static /* synthetic */ void init$default(Context context, String str, Priority priority, Config[] configArr, int i, Object obj) {
        if ((i & 4) != 0) {
            priority = Priority.LOW;
        }
        init(context, str, priority, configArr);
    }

    @JvmStatic
    public static final Interceptor obtainInterceptor(int timeMs) {
        try {
            return INSTANCE.getInternalMobileShield().obtainInterceptor(Integer.valueOf(timeMs));
        } catch (Exception e) {
            y.b(e, w0.o);
            throw null;
        }
    }

    @JvmStatic
    public static final void getHeaders(HeadersCallback headersCallback) throws InitializeException {
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.v, null);
            INSTANCE.getInternalMobileShield().getHeaders(headersCallback);
        } catch (InitializeException e) {
            w0 exceptionLog = w0.j;
            Intrinsics.checkNotNullParameter(e, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var2 = f1.f506a;
            f1.a(exceptionLog, y.a(e));
            throw e;
        } catch (Exception e2) {
            w0 exceptionLog2 = w0.j;
            Intrinsics.checkNotNullParameter(e2, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog2, "exceptionLog");
            s3 s3Var3 = f1.f506a;
            f1.a(exceptionLog2, y.a(e2));
            headersCallback.onFailure(new RequestHeaderReason(3));
        }
    }

    @JvmStatic
    public static final void init(final Context context, final String userAgent, final MobileShieldReadinessListener mobileShieldReadinessListener, final Priority priority, final Config... listConfigs) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        if (mobileShieldReadinessListener == null) {
            str = "";
        } else {
            str = "and listener attached";
        }
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.q, "Initializing; Priority " + priority + ServerSentEventKt.SPACE + str);
            CoroutineDispatcher coroutineDispatcher = c2.f493a;
            c2.a(new Function0<Unit>() { // from class: io.mobileshield.sdk.MobileShield.init.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MobileShield.initShield$sdk_release$default(MobileShield.INSTANCE, context, priority, false, 4, null);
                    String str2 = userAgent;
                    MobileShieldReadinessListener mobileShieldReadinessListener2 = mobileShieldReadinessListener;
                    Config[] configArr = listConfigs;
                    MobileShield.init(str2, mobileShieldReadinessListener2, (Config[]) Arrays.copyOf(configArr, configArr.length));
                }
            });
        } catch (Exception e) {
            y.b(e, w0.f);
            throw null;
        }
    }

    @Deprecated(message = "Use updated init function: init(context, userAgent, priority, listConfigs)", replaceWith = @ReplaceWith(expression = "MobileShield.init(context, userAgent, priority, listConfigs)", imports = {"io.mobileshield.sdk.MobileShield.init"}))
    @JvmStatic
    public static final void init(String userAgent, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.q, "(Deprecated) Initializing");
            init(userAgent, (MobileShieldReadinessListener) null, (Config[]) Arrays.copyOf(listConfigs, listConfigs.length));
        } catch (Exception e) {
            y.b(e, w0.f);
            throw null;
        }
    }

    @JvmStatic
    public static final void init(Context context, String userAgent, Priority priority, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.q, "Initializing; Priority " + priority);
            init(context, userAgent, null, priority, (Config[]) Arrays.copyOf(listConfigs, listConfigs.length));
        } catch (Exception e) {
            y.b(e, w0.f);
            throw null;
        }
    }

    @JvmStatic
    public static final void getHeaders(String method, String url, HeadersCallback headersCallback) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        try {
            s3 s3Var = f1.f506a;
            f1.a(w0.v, "method: " + method + ", url: " + url);
            INSTANCE.getInternalMobileShield().getHeaders(method, url, headersCallback);
        } catch (InitializeException e) {
            y.b(e, w0.j);
            throw null;
        } catch (Exception e2) {
            y.a(e2, w0.j);
            headersCallback.onFailure(new RequestHeaderReason(3));
        }
    }
}
