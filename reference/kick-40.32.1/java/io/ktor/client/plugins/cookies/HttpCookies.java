package io.ktor.client.plugins.cookies;

import androidx.core.view.PointerIconCompat;
import com.facebook.hermes.intl.Constants;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.GMTDate;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: HttpCookies.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002('B@\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012-\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0018\u0010\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R;\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u001a\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010 ¨\u0006)"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "storage", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "defaults", "<init>", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "captureHeaderCookies$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureHeaderCookies", "sendCookiesWith$ktor_client_core", "sendCookiesWith", "Lio/ktor/client/statement/HttpResponse;", "response", "saveCookiesFrom$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCookiesFrom", "close", "()V", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Ljava/util/List;", "Lkotlinx/coroutines/Job;", "initializer", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpCookies implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<HttpCookies> key;
    private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults;
    private final Job initializer;
    private final CookiesStorage storage;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.HttpCookies$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpCookies.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", i = {0, 1}, l = {43, 44}, m = "get", n = {"requestUrl", "requestUrl"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookies.this.get(null, this);
        }
    }

    private static /* synthetic */ void getInitializer$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCookies(CookiesStorage storage, List<? extends Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object>> defaults) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(defaults, "defaults");
        this.storage = storage;
        this.defaults = defaults;
        this.initializer = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), null, new HttpCookies$initializer$1(this, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object get(Url url, Continuation<? super List<Cookie>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.initializer;
            anonymousClass1.L$0 = url;
            anonymousClass1.label = 1;
            if (job.join(anonymousClass1) != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        url = (Url) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        CookiesStorage cookiesStorage = this.storage;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(url);
        anonymousClass1.label = 2;
        Object obj2 = cookiesStorage.get(url, anonymousClass1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object captureHeaderCookies$ktor_client_core(HttpRequestBuilder httpRequestBuilder, Continuation<? super Unit> continuation) {
        HttpCookies$captureHeaderCookies$1 httpCookies$captureHeaderCookies$1;
        Url url;
        Iterable iterable;
        List list;
        Iterator it;
        HttpRequestBuilder httpRequestBuilder2;
        int i;
        int i2;
        HttpRequestBuilder httpRequestBuilder3;
        if (continuation instanceof HttpCookies$captureHeaderCookies$1) {
            httpCookies$captureHeaderCookies$1 = (HttpCookies$captureHeaderCookies$1) continuation;
            if ((httpCookies$captureHeaderCookies$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$captureHeaderCookies$1.label -= Integer.MIN_VALUE;
            } else {
                httpCookies$captureHeaderCookies$1 = new HttpCookies$captureHeaderCookies$1(this, continuation);
            }
        } else {
            httpCookies$captureHeaderCookies$1 = new HttpCookies$captureHeaderCookies$1(this, continuation);
        }
        Object obj = httpCookies$captureHeaderCookies$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = httpCookies$captureHeaderCookies$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Url urlBuild = URLBuilderKt.clone(httpRequestBuilder.getUrl()).build();
            String str = httpRequestBuilder.getHeaders().get("Cookie");
            ArrayList arrayList = null;
            if (str != null) {
                HttpCookiesKt.LOGGER.trace("Saving cookie " + str + " for " + httpRequestBuilder.getUrl());
                Map clientCookiesHeader$default = CookieKt.parseClientCookiesHeader$default(str, false, 2, null);
                ArrayList arrayList2 = new ArrayList(clientCookiesHeader$default.size());
                for (Map.Entry entry : clientCookiesHeader$default.entrySet()) {
                    arrayList2.add(new Cookie((String) entry.getKey(), (String) entry.getValue(), CookieEncoding.RAW, (Integer) null, (GMTDate) null, (String) null, (String) null, false, false, (Map) null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (DefaultConstructorMarker) null));
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                ArrayList arrayList3 = arrayList;
                url = urlBuild;
                iterable = arrayList3;
                list = arrayList;
                it = arrayList3.iterator();
                httpRequestBuilder2 = httpRequestBuilder;
                i = 0;
                i2 = 0;
                httpRequestBuilder3 = httpRequestBuilder2;
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i4 = httpCookies$captureHeaderCookies$1.I$2;
        int i5 = httpCookies$captureHeaderCookies$1.I$1;
        int i6 = httpCookies$captureHeaderCookies$1.I$0;
        List list2 = (List) httpCookies$captureHeaderCookies$1.L$7;
        Object obj2 = httpCookies$captureHeaderCookies$1.L$5;
        Iterator it2 = (Iterator) httpCookies$captureHeaderCookies$1.L$4;
        Iterable iterable2 = (Iterable) httpCookies$captureHeaderCookies$1.L$3;
        Url url2 = (Url) httpCookies$captureHeaderCookies$1.L$2;
        HttpRequestBuilder httpRequestBuilder4 = (HttpRequestBuilder) httpCookies$captureHeaderCookies$1.L$1;
        HttpRequestBuilder httpRequestBuilder5 = (HttpRequestBuilder) httpCookies$captureHeaderCookies$1.L$0;
        ResultKt.throwOnFailure(obj);
        httpRequestBuilder3 = httpRequestBuilder4;
        url = url2;
        iterable = iterable2;
        it = it2;
        list = list2;
        i2 = i6;
        i = i5;
        httpRequestBuilder2 = httpRequestBuilder5;
        while (it.hasNext()) {
            Object next = it.next();
            Cookie cookie = (Cookie) next;
            CookiesStorage cookiesStorage = this.storage;
            httpCookies$captureHeaderCookies$1.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder2);
            httpCookies$captureHeaderCookies$1.L$1 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder3);
            httpCookies$captureHeaderCookies$1.L$2 = url;
            httpCookies$captureHeaderCookies$1.L$3 = SpillingKt.nullOutSpilledVariable(iterable);
            httpCookies$captureHeaderCookies$1.L$4 = it;
            httpCookies$captureHeaderCookies$1.L$5 = SpillingKt.nullOutSpilledVariable(next);
            httpCookies$captureHeaderCookies$1.L$6 = SpillingKt.nullOutSpilledVariable(cookie);
            httpCookies$captureHeaderCookies$1.L$7 = SpillingKt.nullOutSpilledVariable(list);
            httpCookies$captureHeaderCookies$1.I$0 = i2;
            httpCookies$captureHeaderCookies$1.I$1 = i;
            httpCookies$captureHeaderCookies$1.I$2 = 0;
            httpCookies$captureHeaderCookies$1.label = 1;
            if (cookiesStorage.addCookie(url, cookie, httpCookies$captureHeaderCookies$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sendCookiesWith$ktor_client_core(HttpRequestBuilder httpRequestBuilder, Continuation<? super Unit> continuation) {
        HttpCookies$sendCookiesWith$1 httpCookies$sendCookiesWith$1;
        if (continuation instanceof HttpCookies$sendCookiesWith$1) {
            httpCookies$sendCookiesWith$1 = (HttpCookies$sendCookiesWith$1) continuation;
            if ((httpCookies$sendCookiesWith$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$sendCookiesWith$1.label -= Integer.MIN_VALUE;
            } else {
                httpCookies$sendCookiesWith$1 = new HttpCookies$sendCookiesWith$1(this, continuation);
            }
        } else {
            httpCookies$sendCookiesWith$1 = new HttpCookies$sendCookiesWith$1(this, continuation);
        }
        Object obj = httpCookies$sendCookiesWith$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = httpCookies$sendCookiesWith$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Url urlBuild = URLBuilderKt.clone(httpRequestBuilder.getUrl()).build();
            httpCookies$sendCookiesWith$1.L$0 = httpRequestBuilder;
            httpCookies$sendCookiesWith$1.label = 1;
            obj = get(urlBuild, httpCookies$sendCookiesWith$1);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            httpRequestBuilder = (HttpRequestBuilder) httpCookies$sendCookiesWith$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            String strRenderClientCookies = HttpCookiesKt.renderClientCookies(list);
            httpRequestBuilder.getHeaders().set("Cookie", strRenderClientCookies);
            HttpCookiesKt.LOGGER.trace("Sending cookie " + strRenderClientCookies + " for " + httpRequestBuilder.getUrl());
        } else {
            httpRequestBuilder.getHeaders().remove("Cookie");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveCookiesFrom$ktor_client_core(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCookies$saveCookiesFrom$1 httpCookies$saveCookiesFrom$1;
        Iterable iterable;
        Iterator it;
        Url url;
        int i;
        if (continuation instanceof HttpCookies$saveCookiesFrom$1) {
            httpCookies$saveCookiesFrom$1 = (HttpCookies$saveCookiesFrom$1) continuation;
            if ((httpCookies$saveCookiesFrom$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$saveCookiesFrom$1.label -= Integer.MIN_VALUE;
            } else {
                httpCookies$saveCookiesFrom$1 = new HttpCookies$saveCookiesFrom$1(this, continuation);
            }
        } else {
            httpCookies$saveCookiesFrom$1 = new HttpCookies$saveCookiesFrom$1(this, continuation);
        }
        Object obj = httpCookies$saveCookiesFrom$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = httpCookies$saveCookiesFrom$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Url url2 = HttpResponseKt.getRequest(httpResponse).getUrl();
            List<String> all = httpResponse.getHeaders().getAll("Set-Cookie");
            if (all != null) {
                for (String str : all) {
                    HttpCookiesKt.LOGGER.trace("Received cookie " + str + " in response for " + httpResponse.getCall().getRequest().getUrl());
                }
            }
            List<Cookie> cookie = HttpMessagePropertiesKt.setCookie(httpResponse);
            iterable = cookie;
            it = cookie.iterator();
            url = url2;
            i = 0;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = httpCookies$saveCookiesFrom$1.I$1;
            int i4 = httpCookies$saveCookiesFrom$1.I$0;
            Object obj2 = httpCookies$saveCookiesFrom$1.L$4;
            it = (Iterator) httpCookies$saveCookiesFrom$1.L$3;
            iterable = (Iterable) httpCookies$saveCookiesFrom$1.L$2;
            url = (Url) httpCookies$saveCookiesFrom$1.L$1;
            HttpResponse httpResponse2 = (HttpResponse) httpCookies$saveCookiesFrom$1.L$0;
            ResultKt.throwOnFailure(obj);
            i = i4;
            httpResponse = httpResponse2;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Cookie cookie2 = (Cookie) next;
            CookiesStorage cookiesStorage = this.storage;
            httpCookies$saveCookiesFrom$1.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            httpCookies$saveCookiesFrom$1.L$1 = url;
            httpCookies$saveCookiesFrom$1.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
            httpCookies$saveCookiesFrom$1.L$3 = it;
            httpCookies$saveCookiesFrom$1.L$4 = SpillingKt.nullOutSpilledVariable(next);
            httpCookies$saveCookiesFrom$1.L$5 = SpillingKt.nullOutSpilledVariable(cookie2);
            httpCookies$saveCookiesFrom$1.I$0 = i;
            httpCookies$saveCookiesFrom$1.I$1 = 0;
            httpCookies$saveCookiesFrom$1.label = 1;
            if (cookiesStorage.addCookie(url, cookie2, httpCookies$saveCookiesFrom$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.storage.close();
    }

    /* JADX INFO: compiled from: HttpCookies.kt */
    @KtorDsl
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\b\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR;\u0010\u0011\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\b\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", Constants.COLLATION_DEFAULT, "(Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/plugins/cookies/HttpCookies;", "build$ktor_client_core", "()Lio/ktor/client/plugins/cookies/HttpCookies;", "build", "", "defaults", "Ljava/util/List;", "storage", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults = new ArrayList();
        private CookiesStorage storage = new AcceptAllCookiesStorage(null, 1, 0 == true ? 1 : 0);

        public final CookiesStorage getStorage() {
            return this.storage;
        }

        public final void setStorage(CookiesStorage cookiesStorage) {
            Intrinsics.checkNotNullParameter(cookiesStorage, "<set-?>");
            this.storage = cookiesStorage;
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final void m12498default(Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.defaults.add(block);
        }

        public final HttpCookies build$ktor_client_core() {
            return new HttpCookies(this.storage, this.defaults);
        }
    }

    /* JADX INFO: compiled from: HttpCookies.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cookies/HttpCookies;", "plugin", "Lio/ktor/client/HttpClient;", PermissionsResponse.SCOPE_KEY, "install", "(Lio/ktor/client/plugins/cookies/HttpCookies;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCookies prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return config.build$ktor_client_core();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCookies> getKey() {
            return HttpCookies.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCookies plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$1(plugin, null));
            scope.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$2(plugin, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getState(), new HttpCookies$Companion$install$3(plugin, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        KType kTypeTypeOf = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpCookies.class);
        try {
            kTypeTypeOf = Reflection.typeOf(HttpCookies.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("HttpCookies", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
    }
}
