package org.h.s;

import android.content.Context;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import io.mobileshield.sdk.ClientCallback;
import io.mobileshield.sdk.HeadersCallback;
import io.mobileshield.sdk.InitializeException;
import io.mobileshield.sdk.MobileShield;
import io.mobileshield.sdk.MobileShieldInterface;
import io.mobileshield.sdk.MobileShieldReadinessListener;
import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.RequestHeaderReason;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.config.Method;
import io.mobileshield.sdk.logger.LocalLogger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
public final class r0 implements MobileShieldInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f564a;
    public final n0 b;
    public final CoroutineDispatcher c;
    public final Priority d;
    public final v0 e;
    public final r2 f;

    public r0(Context ctx, Priority priority, boolean z) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.c = Dispatchers.getDefault();
        this.d = Priority.LOW;
        this.f = new r2();
        s3 s3Var = f1.f506a;
        f1.a(w0.A, "Initializing internal SDK");
        g0.a(ctx);
        a0 a0Var = a0.e;
        if (a0Var.b()) {
            y1.a(y1.h.a(), r4.INITIALISATION);
        }
        a0 a0Var2 = a0.f;
        if (a0Var2.b()) {
            f1.a(ctx);
        }
        this.f564a = new i4(ctx, priority);
        this.d = priority;
        this.b = new n0(new p0(this));
        if (a0Var.b()) {
            y1.h.a().b();
        }
        if (a0Var.b() || a0Var2.b()) {
            this.e = new v0();
        }
        if (z) {
            y1.h.a().c();
        }
        y1.h.a().a(r4.INITIALISATION, "ims_construction");
    }

    public final Priority a() {
        return this.d;
    }

    public final void b() {
        i4 i4Var = this.f564a;
        i4Var.getClass();
        if (ArraysKt.contains(new a4[]{a4.PAUSE, a4.SLEEP, a4.SLEEP_NETWORKDOWN}, i4Var.l.f579a)) {
            LocalLogger.log(16, 22324L, "awake");
            l2 l2Var = i4Var.f;
            if (!l2Var.e && a0.h.c) {
                l2Var.a(i4Var.f523a);
                return;
            }
            LocalLogger.log(16, 22323L, "resume");
            i4Var.a(new u3(a4.RESUME, 0));
            i4Var.i.a();
            Config[] configArr = null;
            i4Var.a((u) null);
            Config[] configArr2 = i4Var.c;
            if (configArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localConfig");
            } else {
                configArr = configArr2;
            }
            i4Var.a(configArr, i4Var.h.a(i4Var.f523a, configArr, i4Var.h()));
        }
    }

    public final boolean c() {
        return this.f564a.a();
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void checkResponse(int i, Map headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f564a.a(new r((String) headers.get("x-kpsdk-ct"), (String) headers.get("x-kpsdk-r"), (String) headers.get("x-kpsdk-c"), i));
        this.f564a.a((String) headers.get("x-kpsdk-h"), (String) headers.get("x-kpsdk-fc"));
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void deleteData() {
        this.f564a.e();
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void dispose() {
        LocalLogger.log(8, 22016L, "Dispose internal SDK");
        i4 i4Var = this.f564a;
        i4Var.getClass();
        LocalLogger.log(8, 22328L, "Dispose store");
        i4Var.f.c(i4Var.f523a);
        i4Var.c();
        v0 v0Var = this.e;
        if (v0Var != null) {
            v0Var.b();
        }
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final Map getHeaders(String domainName) {
        Intrinsics.checkNotNullParameter(domainName, "domainname");
        b();
        n0 n0Var = this.b;
        u uVarH = this.f564a.h();
        n0Var.getClass();
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        LocalLogger.log(8, 22002L, domainName);
        return o0.a((Context) null, uVarH);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void init(String userAgent, MobileShieldReadinessListener mobileShieldReadinessListener, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1 y1Var = y1.i;
        Intrinsics.checkNotNull(y1Var);
        y1Var.a(r4.INITIALISATION, "ms_init");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.c), null, null, new q0(this, null), 3, null);
        LocalLogger.log(8, 22009L, ArraysKt.contentDeepToString(listConfigs));
        if (mobileShieldReadinessListener != null) {
            a(new h2(mobileShieldReadinessListener));
        }
        Config[] configArr = (Config[]) Arrays.copyOf(listConfigs, listConfigs.length);
        this.f.a(configArr);
        this.f564a.a(userAgent, configArr);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final boolean isReadyForAllDomains() {
        LocalLogger.log(8, 22005L, null);
        b();
        return this.f564a.a();
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final boolean isReadyForDomain(String domainname) {
        Intrinsics.checkNotNullParameter(domainname, "domainname");
        LocalLogger.log(8, 22004L, domainname);
        b();
        return this.f564a.a();
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final boolean isValid(Request originalRequest) {
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        return this.f.a(originalRequest.method(), originalRequest.url().host(), originalRequest.url().encodedPath());
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final Map mergeHeaders(String domainName, Map userHeader) {
        Intrinsics.checkNotNullParameter(domainName, "domainname");
        Intrinsics.checkNotNullParameter(userHeader, "userHeader");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(userHeader, "userHeader");
        LocalLogger.log(8, 22003L, domainName);
        ((HashMap) userHeader).putAll(MobileShield.INSTANCE.getHeaders(domainName));
        return userHeader;
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final Interceptor obtainInterceptor(Integer num) {
        LocalLogger.log(8, 22007L, null);
        if (!a0.k.c) {
            b();
        }
        if (num == null) {
            num = null;
        } else if (num.intValue() < 0) {
            num = 0;
        } else if (num.intValue() > 120000) {
            num = 120000;
        }
        return num == null ? new g2(this, this.d, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, this.f564a.f523a) : new g2(this, this.d, num.intValue(), this.f564a.f523a);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void parseResponse(HttpURLConnection urlConnection) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        this.f564a.a(s4.a(urlConnection, this.f564a));
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void protect(HttpURLConnection urlConnection, ClientCallback callback) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b();
        s4.a(urlConnection, callback, this.f564a.h(), this.f);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void update(String userAgent, Config... listConfigs) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs, "listConfigs");
        Config[] listConfigs2 = (Config[]) Arrays.copyOf(listConfigs, listConfigs.length);
        r2 r2Var = this.f;
        r2Var.getClass();
        Intrinsics.checkNotNullParameter(listConfigs2, "config");
        String string = Arrays.toString(listConfigs2);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LocalLogger.log(8, 22015L, string);
        if (r2Var.f565a == null && !r2Var.b.await(1000L, t4.f575a)) {
            throw new InitializeException("Mobile Shield Not Initialized. Local Config not created.");
        }
        r2Var.a(listConfigs2);
        i4 i4Var = this.f564a;
        i4Var.getClass();
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(listConfigs2, "listConfigs");
        i4Var.a(new u3(a4.NETWORKCHECK, 0));
        i4Var.a(userAgent, listConfigs2);
    }

    public final void a(j4 storeControllerStateListener) {
        Intrinsics.checkNotNullParameter(storeControllerStateListener, "stateListener");
        i4 i4Var = this.f564a;
        i4Var.getClass();
        Intrinsics.checkNotNullParameter(storeControllerStateListener, "storeControllerStateListener");
        b4 b4Var = i4Var.e;
        b4Var.getClass();
        Intrinsics.checkNotNullParameter(storeControllerStateListener, "storeControllerStateListener");
        b4Var.f491a.add(storeControllerStateListener);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void parseResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        i4 store = this.f564a;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(store, "store");
        s3 s3Var = f1.f506a;
        f1.a(w0.Y, null);
        LocalLogger.log(8, 22010L, response.request().url().host());
        store.a(response.header("x-kpsdk-h", null), response.header("x-kpsdk-fc", null));
        this.f564a.a(new r(response.header("x-kpsdk-ct", null), response.header("x-kpsdk-r", null), response.header("x-kpsdk-c", null), response.code()));
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void getHeaders(HeadersCallback headersCallback) {
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        b();
        n0 n0Var = this.b;
        i4 store = this.f564a;
        n0Var.getClass();
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        Intrinsics.checkNotNullParameter(store, "store");
        g gVar = n0Var.f543a;
        gVar.getClass();
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        LocalLogger.log(16, 27002L, "");
        gVar.a(headersCallback, store);
    }

    @Override // io.mobileshield.sdk.MobileShieldInterface
    public final void getHeaders(String method, String url, HeadersCallback headersCallback) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        b();
        n0 n0Var = this.b;
        r2 protectedConfig = this.f;
        i4 store = this.f564a;
        n0Var.getClass();
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
        Intrinsics.checkNotNullParameter(protectedConfig, "protectedConfig");
        Intrinsics.checkNotNullParameter(store, "store");
        protectedConfig.getClass();
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Method.valueOf(method);
            URL url2 = new URL(url);
            String host = url2.getHost();
            String path = url2.getPath();
            Intrinsics.checkNotNull(host);
            Intrinsics.checkNotNull(path);
            boolValueOf = Boolean.valueOf(protectedConfig.a(method, host, path));
        } catch (IllegalArgumentException e) {
            LocalLogger.log(2, 22017L, e.getMessage());
            boolValueOf = null;
        } catch (MalformedURLException e2) {
            LocalLogger.log(2, 22017L, e2.getMessage());
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            headersCallback.onFailure(new RequestHeaderReason(3));
            return;
        }
        if (boolValueOf.booleanValue()) {
            g gVar = n0Var.f543a;
            gVar.getClass();
            Intrinsics.checkNotNullParameter(store, "store");
            Intrinsics.checkNotNullParameter(headersCallback, "headersCallback");
            LocalLogger.log(16, 27002L, "");
            gVar.a(headersCallback, store);
            return;
        }
        Map<String, String> map = Collections.EMPTY_MAP;
        Intrinsics.checkNotNull(map);
        headersCallback.onSuccess(map);
    }
}
