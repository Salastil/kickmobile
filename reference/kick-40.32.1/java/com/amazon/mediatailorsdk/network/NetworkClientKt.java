package com.amazon.mediatailorsdk.network;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestRetryConfig;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.plugins.HttpRetryShouldRetryContext;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001ab\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004j\u0002`\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0086H¢\u0006\u0004\b\u0011\u0010\u0012\u001ap\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001\"\u0006\b\u0001\u0010\u0014\u0018\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u0002H\u00142\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0086H¢\u0006\u0004\b\u0018\u0010\u0019\u001a \u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u001bH\u0086H¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020 \u001a\u0012\u0010\f\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\f\u001a\u00020\r*2\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0001¨\u0006!"}, d2 = {"Params", "Lkotlin/collections/HashMap;", "", "", "Ljava/util/HashMap;", "safeGet", "Lcom/amazon/mediatailorsdk/network/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/HttpClient;", ImagesContract.URL, "params", "Lcom/amazon/mediatailorsdk/network/Params;", InstrumentationTags.TIMEOUT, "", "maxRetry", "Lkotlin/UInt;", "userAgent", "safeGet-MLW3aMY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/HashMap;JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safePost", "P", "data", "extraHeaders", "", "safePost-QEa2snw", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResponse", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "", "Lio/ktor/client/request/HttpRequestBuilder;", "", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NetworkClientKt {
    /* JADX INFO: renamed from: safeGet-MLW3aMY$default, reason: not valid java name */
    public static /* synthetic */ Object m10984safeGetMLW3aMY$default(HttpClient httpClient, String str, HashMap map, long j, int i, String str2, Continuation continuation, int i2, Object obj) {
        Resource resourceError;
        Resource resourceError2;
        if ((i2 & 2) != 0) {
            map = new HashMap();
        }
        if ((i2 & 4) != 0) {
            j = 30000;
        }
        if ((i2 & 8) != 0) {
            i = 7;
        }
        if ((i2 & 16) != 0) {
            str2 = NetworkClient.INSTANCE.getUserAgent();
        }
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str);
            for (Map.Entry entry : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            timeout(httpRequestBuilder, j);
            retry(httpRequestBuilder, i);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, str2);
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                Resource.Companion companion = Resource.INSTANCE;
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T?");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T?");
                } catch (Throwable unused) {
                }
                Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, null), continuation);
                Intrinsics.reifiedOperationMarker(1, "T?");
                Object obj2 = objBodyNullable;
                resourceError2 = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            } else {
                resourceError2 = Resource.INSTANCE.error(new Throwable("Something went wrong"));
            }
            Resource resource = resourceError2;
            return resourceError2;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                resourceError = Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            } else {
                resourceError = Resource.INSTANCE.error(th);
            }
            return resourceError;
        }
    }

    /* JADX INFO: renamed from: safePost-QEa2snw$default, reason: not valid java name */
    public static /* synthetic */ Object m10986safePostQEa2snw$default(HttpClient httpClient, String str, Object obj, Map map, long j, int i, String str2, Continuation continuation, int i2, Object obj2) {
        Resource resourceError;
        Resource resourceError2;
        Map map2 = (i2 & 4) != 0 ? null : map;
        long j2 = (i2 & 8) != 0 ? 30000L : j;
        int i3 = (i2 & 16) != 0 ? 7 : i;
        String userAgent = (i2 & 32) != 0 ? NetworkClient.INSTANCE.getUserAgent() : str2;
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, str);
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
            if (obj == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                Intrinsics.reifiedOperationMarker(4, "P");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "P");
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, null));
            } else if (obj instanceof OutgoingContent) {
                httpRequestBuilder.setBody(obj);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(obj);
                Intrinsics.reifiedOperationMarker(4, "P");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "P");
                } catch (Throwable unused2) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, null));
            }
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    httpRequestBuilder.getHeaders().append((String) entry.getKey(), (String) entry.getValue());
                    Unit unit = Unit.INSTANCE;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            timeout(httpRequestBuilder, j2);
            retry(httpRequestBuilder, i3);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, userAgent);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                Resource.Companion companion = Resource.INSTANCE;
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T?");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T?");
                } catch (Throwable unused3) {
                }
                Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass3, null), continuation);
                Intrinsics.reifiedOperationMarker(1, "T?");
                Object obj3 = objBodyNullable;
                resourceError2 = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            } else {
                resourceError2 = Resource.INSTANCE.error(new Throwable("Something went wrong"));
            }
            Resource resource = resourceError2;
            return resourceError2;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null || !StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                Resource.Companion companion2 = Resource.INSTANCE;
                String message2 = e.getMessage();
                resourceError = companion2.error(new Throwable(message2 != null ? message2 : "Something went wrong"));
            } else {
                resourceError = Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            }
            return resourceError;
        } catch (Throwable th) {
            return Resource.INSTANCE.error(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final /* synthetic */ <T> Object toResponse(HttpResponse httpResponse, Continuation<? super Resource<? extends T>> continuation) {
        if (!HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
            return Resource.INSTANCE.error(new Throwable("Something went wrong"));
        }
        Resource.Companion companion = Resource.INSTANCE;
        HttpClientCall call = httpResponse.getCall();
        Intrinsics.reifiedOperationMarker(4, "T?");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T?");
        } catch (Throwable unused) {
        }
        Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, null), continuation);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
    }

    public static final void retry(HttpRequestBuilder httpRequestBuilder, final int i) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpRequestRetryKt.retry(httpRequestBuilder, new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClientKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClientKt.retry$lambda$0(i, (HttpRequestRetryConfig) obj);
            }
        });
    }

    static final Unit retry$lambda$0(int i, HttpRequestRetryConfig retry) {
        Intrinsics.checkNotNullParameter(retry, "$this$retry");
        retry.setMaxRetries(i);
        HttpRequestRetryConfig.retryIf$default(retry, 0, new Function3() { // from class: com.amazon.mediatailorsdk.network.NetworkClientKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(NetworkClientKt.retry$lambda$0$0((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retry$lambda$0$0(HttpRetryShouldRetryContext retryIf, HttpRequest httpRequest, HttpResponse response) {
        Intrinsics.checkNotNullParameter(retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getStatus().getValue() == 429) {
            return true;
        }
        int value = response.getStatus().getValue();
        return 500 <= value && value < 600;
    }

    public static final void timeout(HttpRequestBuilder httpRequestBuilder, final long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClientKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClientKt.timeout$lambda$0(j, (HttpTimeoutConfig) obj);
            }
        });
    }

    static final Unit timeout$lambda$0(long j, HttpTimeoutConfig timeout) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setRequestTimeoutMillis(Long.valueOf(j));
        timeout.setConnectTimeoutMillis(Long.valueOf(j));
        timeout.setSocketTimeoutMillis(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: safeGet-MLW3aMY, reason: not valid java name */
    public static final /* synthetic */ <T> Object m10983safeGetMLW3aMY(HttpClient httpClient, String str, HashMap<String, Object> map, long j, int i, String str2, Continuation<? super Resource<? extends T>> continuation) {
        Resource<T> resourceError;
        Resource<T> resourceError2;
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, entry.getKey(), entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            timeout(httpRequestBuilder, j);
            retry(httpRequestBuilder, i);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, str2);
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                Resource.Companion companion = Resource.INSTANCE;
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T?");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T?");
                } catch (Throwable unused) {
                }
                Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, null), continuation);
                Intrinsics.reifiedOperationMarker(1, "T?");
                Object obj = objBodyNullable;
                resourceError2 = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            } else {
                resourceError2 = Resource.INSTANCE.error(new Throwable("Something went wrong"));
            }
            Resource<T> resource = resourceError2;
            return resourceError2;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                resourceError = Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            } else {
                resourceError = Resource.INSTANCE.error(th);
            }
            return resourceError;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: safePost-QEa2snw, reason: not valid java name */
    public static final /* synthetic */ <T, P> Object m10985safePostQEa2snw(HttpClient httpClient, String str, P p, Map<String, String> map, long j, int i, String str2, Continuation<? super Resource<? extends T>> continuation) {
        Resource<T> resourceError;
        Resource<T> resourceError2;
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, str);
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
            if (p == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                Intrinsics.reifiedOperationMarker(4, "P");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "P");
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, null));
            } else if (p instanceof OutgoingContent) {
                httpRequestBuilder.setBody(p);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(p);
                Intrinsics.reifiedOperationMarker(4, "P");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "P");
                } catch (Throwable unused2) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, null));
            }
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpRequestBuilder.getHeaders().append(entry.getKey(), entry.getValue());
                    Unit unit = Unit.INSTANCE;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            timeout(httpRequestBuilder, j);
            retry(httpRequestBuilder, i);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, str2);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                Resource.Companion companion = Resource.INSTANCE;
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T?");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T?");
                } catch (Throwable unused3) {
                }
                Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass3, null), continuation);
                Intrinsics.reifiedOperationMarker(1, "T?");
                Object obj = objBodyNullable;
                resourceError2 = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            } else {
                resourceError2 = Resource.INSTANCE.error(new Throwable("Something went wrong"));
            }
            Resource<T> resource = resourceError2;
            return resourceError2;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null || !StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                Resource.Companion companion2 = Resource.INSTANCE;
                String message2 = e.getMessage();
                resourceError = companion2.error(new Throwable(message2 != null ? message2 : "Something went wrong"));
            } else {
                resourceError = Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            }
            return resourceError;
        } catch (Throwable th) {
            return Resource.INSTANCE.error(th);
        }
    }
}
