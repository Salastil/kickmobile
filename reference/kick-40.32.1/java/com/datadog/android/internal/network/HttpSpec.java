package com.datadog.android.internal.network;

import com.google.android.gms.stats.CodePackage;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/network/HttpSpec;", "", "()V", "ContentType", "Header", "Method", "StatusCode", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpSpec {
    public static final HttpSpec INSTANCE = new HttpSpec();

    private HttpSpec() {
    }

    /* JADX INFO: compiled from: HttpSpec.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/internal/network/HttpSpec$Method;", "", "()V", Method.CONNECT, "", Method.DELETE, "GET", Method.HEAD, Method.OPTIONS, Method.PATCH, "POST", Method.PUT, Method.TRACE, "isMethodWithBody", "", FirebaseAnalytics.Param.METHOD, "values", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Method {
        public static final String CONNECT = "CONNECT";
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final Method INSTANCE = new Method();
        public static final String OPTIONS = "OPTIONS";
        public static final String PATCH = "PATCH";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";

        private Method() {
        }

        public final List<String> values() {
            return CollectionsKt.listOf((Object[]) new String[]{"GET", "POST", PATCH, PUT, HEAD, DELETE, TRACE, OPTIONS, CONNECT});
        }

        public final boolean isMethodWithBody(String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            return Intrinsics.areEqual("POST", method) || Intrinsics.areEqual(PUT, method) || Intrinsics.areEqual(PATCH, method);
        }
    }

    /* JADX INFO: compiled from: HttpSpec.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/internal/network/HttpSpec$Header;", "", "()V", "CONTENT_LENGTH", "", "CONTENT_TYPE", CodePackage.LOCATION, "RETRY_AFTER", "WEBSOCKET_ACCEPT_HEADER", "values", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Header {
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final Header INSTANCE = new Header();
        public static final String LOCATION = "Location";
        public static final String RETRY_AFTER = "Retry-After";
        public static final String WEBSOCKET_ACCEPT_HEADER = "Sec-WebSocket-Accept";

        private Header() {
        }

        public final List<String> values() {
            return CollectionsKt.listOf((Object[]) new String[]{"Content-Type", "Content-Length", "Location", "Retry-After", "Sec-WebSocket-Accept"});
        }
    }

    /* JADX INFO: compiled from: HttpSpec.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\n\u0010\u001b\u001a\u00020\u001c\"\u00020\u0004J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/internal/network/HttpSpec$StatusCode;", "", "()V", "BAD_GATEWAY", "", "BAD_REQUEST", "FORBIDDEN", "FOUND", "GATEWAY_TIMEOUT", "INTERNAL_ERROR", "METHOD_NOT_ALLOWED", "MOVED_PERMANENTLY", "NETWORK_AUTHENTICATION_REQUIRED", "NOT_FOUND", "OK", "PERMANENT_REDIRECT", "REQUEST_TIMEOUT", "SEE_OTHER", "SERVICE_UNAVAILABLE", "STATUS_CODE_TYPE", "STATUS_CODE_TYPE_CLIENT", "STATUS_CODE_TYPE_SERVER", "TEMPORARY_REDIRECT", "TOO_MANY_REQUESTS", "UNAUTHORIZED", "clientErrors", "", "exclude", "", "serverErrors", "values", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StatusCode {
        public static final int BAD_GATEWAY = 502;
        public static final int BAD_REQUEST = 400;
        public static final int FORBIDDEN = 403;
        public static final int FOUND = 302;
        public static final int GATEWAY_TIMEOUT = 504;
        public static final StatusCode INSTANCE = new StatusCode();
        public static final int INTERNAL_ERROR = 500;
        public static final int METHOD_NOT_ALLOWED = 405;
        public static final int MOVED_PERMANENTLY = 301;
        public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;
        public static final int NOT_FOUND = 404;
        public static final int OK = 200;
        public static final int PERMANENT_REDIRECT = 308;
        public static final int REQUEST_TIMEOUT = 408;
        public static final int SEE_OTHER = 303;
        public static final int SERVICE_UNAVAILABLE = 503;
        private static final int STATUS_CODE_TYPE = 100;
        private static final int STATUS_CODE_TYPE_CLIENT = 4;
        private static final int STATUS_CODE_TYPE_SERVER = 5;
        public static final int TEMPORARY_REDIRECT = 307;
        public static final int TOO_MANY_REQUESTS = 429;
        public static final int UNAUTHORIZED = 401;

        private StatusCode() {
        }

        public final List<Integer> values() {
            return CollectionsKt.listOf((Object[]) new Integer[]{200, 301, 302, 303, 307, 308, 400, 401, 403, Integer.valueOf(NOT_FOUND), Integer.valueOf(METHOD_NOT_ALLOWED), 408, 429, 500, 502, 503, 504, 511});
        }

        public final List<Integer> clientErrors(int... exclude) {
            Intrinsics.checkNotNullParameter(exclude, "exclude");
            Set<Integer> set = ArraysKt.toSet(exclude);
            List<Integer> listValues = values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listValues) {
                if (!set.contains(Integer.valueOf(((Number) obj).intValue()))) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((Number) obj2).intValue() / 100 == 4) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }

        public final List<Integer> serverErrors() {
            List<Integer> listValues = values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listValues) {
                if (((Number) obj).intValue() / 100 == 5) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: HttpSpec.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/internal/network/HttpSpec$ContentType;", "", "()V", "APPLICATION_GRPC", "", "APPLICATION_GRPC_JSON", "APPLICATION_GRPC_PROTO", "APPLICATION_JSON", "STREAM_CONTENT_TYPES", "", "TEXT_EVENT_STREAM", "TEXT_PLAIN", "isStream", "", "contentType", "values", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ContentType {
        public static final String APPLICATION_JSON = "application/json";
        public static final String TEXT_PLAIN = "text/plain";
        public static final ContentType INSTANCE = new ContentType();
        public static final String TEXT_EVENT_STREAM = "text/event-stream";
        public static final String APPLICATION_GRPC = "application/grpc";
        public static final String APPLICATION_GRPC_PROTO = "application/grpc+proto";
        public static final String APPLICATION_GRPC_JSON = "application/grpc+json";
        private static final Set<String> STREAM_CONTENT_TYPES = SetsKt.setOf((Object[]) new String[]{TEXT_EVENT_STREAM, APPLICATION_GRPC, APPLICATION_GRPC_PROTO, APPLICATION_GRPC_JSON});

        private ContentType() {
        }

        public final List<String> values() {
            return CollectionsKt.listOf((Object[]) new String[]{"application/json", "text/plain", TEXT_EVENT_STREAM, APPLICATION_GRPC, APPLICATION_GRPC_PROTO, APPLICATION_GRPC_JSON});
        }

        public final boolean isStream(String contentType) {
            return contentType != null && STREAM_CONTENT_TYPES.contains(contentType);
        }
    }
}
