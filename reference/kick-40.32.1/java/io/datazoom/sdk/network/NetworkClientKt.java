package io.datazoom.sdk.network;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import io.datazoom.sdk.NetworkInfo_androidKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
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
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004j\u0002`\u0013H\u0086H¢\u0006\u0002\u0010\u0014\u001a8\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u0016H\u0086H¢\u0006\u0002\u0010\u0018\u001a \u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u0001*\u00020\u001aH\u0086H¢\u0006\u0002\u0010\u001b\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n*2\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0001¨\u0006\u001c"}, d2 = {"Params", "Lkotlin/collections/HashMap;", "", "", "Ljava/util/HashMap;", "delays", "", "", "userAgent", "getUserAgent", "()Ljava/lang/String;", "userAgent$delegate", "Lkotlin/Lazy;", "safeGet", "Lio/datazoom/sdk/network/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/HttpClient;", ImagesContract.URL, "params", "Lio/datazoom/sdk/network/Params;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safePost", "P", "data", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResponse", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NetworkClientKt {
    private static final List<Integer> delays = CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 4, 8, 8, 8, 8});
    private static final Lazy userAgent$delegate = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.network.NetworkClientKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkInfo_androidKt.getNetworkInfo().getUserAgent();
        }
    });

    public static final String getUserAgent() {
        return (String) userAgent$delegate.getValue();
    }

    public static /* synthetic */ Object safeGet$default(HttpClient httpClient, String str, HashMap map, Continuation continuation, int i, Object obj) {
        Resource resourceError$default;
        Resource resourceError;
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str);
            for (Map.Entry entry : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, getUserAgent());
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            Map<String, List<String>> mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
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
                resourceError = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), mapAsResponseHeaders);
            } else {
                resourceError = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
            }
            Resource resource = resourceError;
            return resourceError;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
            } else {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
            }
            return resourceError$default;
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
        Map<String, List<String>> mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
        if (!HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
            return Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
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
        return companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), mapAsResponseHeaders);
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
    public static final /* synthetic */ <T> Object safeGet(HttpClient httpClient, String str, HashMap<String, Object> map, Continuation<? super Resource<? extends T>> continuation) {
        Resource resourceError$default;
        Resource<T> resourceError;
        try {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, entry.getKey(), entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, getUserAgent());
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            Map<String, List<String>> mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
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
                resourceError = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), mapAsResponseHeaders);
            } else {
                resourceError = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
            }
            Resource<T> resource = resourceError;
            return resourceError;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
            } else {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
            }
            return resourceError$default;
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
    public static final /* synthetic */ <T, P> Object safePost(HttpClient httpClient, String str, P p, Continuation<? super Resource<? extends T>> continuation) {
        Resource resourceError$default;
        Resource<T> resourceError;
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
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, getUserAgent());
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpResponse httpResponse = (HttpResponse) new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
            Map<String, List<String>> mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
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
                resourceError = companion.success(objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), mapAsResponseHeaders);
            } else {
                resourceError = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
            }
            Resource<T> resource = resourceError;
            return resourceError;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null || !StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                Resource.Companion companion2 = Resource.INSTANCE;
                String message2 = e.getMessage();
                resourceError$default = Resource.Companion.error$default(companion2, new Throwable(message2 != null ? message2 : "Something went wrong"), null, 2, null);
            } else {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
            }
            return resourceError$default;
        } catch (Throwable th) {
            return Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
        }
    }
}
