package com.datadog.android.core.internal.data.upload;

import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: compiled from: CurlInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/CurlInterceptor;", "Lokhttp3/Interceptor;", "printBody", "", "output", "Lkotlin/Function1;", "", "", "(ZLkotlin/jvm/functions/Function1;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "CurlBuilder", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurlInterceptor implements Interceptor {
    private static final String CONTENT_TYPE = "Content-Type";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FORMAT_BODY = "-d '%1$s'";
    private static final String FORMAT_HEADER = "-H \"%1$s:%2$s\"";
    private static final String FORMAT_METHOD = "-X %1$s";
    private static final String FORMAT_URL = "\"%1$s\"";
    private final Function1<String, Unit> output;
    private final boolean printBody;

    /* JADX WARN: Multi-variable type inference failed */
    public CurlInterceptor() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CurlInterceptor(boolean z, Function1<? super String, Unit> output) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.printBody = z;
        this.output = output;
    }

    public /* synthetic */ CurlInterceptor(boolean z, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new Function1<String, Unit>() { // from class: com.datadog.android.core.internal.data.upload.CurlInterceptor.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Log.i("Curl", it);
            }
        } : anonymousClass1);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        this.output.invoke(new CurlBuilder(request.newBuilder().build(), this.printBody).toCommand());
        return chain.proceed(request);
    }

    /* JADX INFO: compiled from: CurlInterceptor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BQ\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001b\u001a\u00020\bJ\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u000f*\u00020\fH\u0002R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/CurlInterceptor$CurlBuilder;", "", "request", "Lokhttp3/Request;", "printBody", "", "(Lokhttp3/Request;Z)V", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "contentType", "requestBody", "Lokhttp3/RequestBody;", "headers", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Ljava/util/Map;Z)V", "getContentType", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getMethod", "getPrintBody", "()Z", "getRequestBody", "()Lokhttp3/RequestBody;", "getUrl", "toCommand", "toParts", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CurlBuilder {
        private final String contentType;
        private final Map<String, List<String>> headers;
        private final String method;
        private final boolean printBody;
        private final RequestBody requestBody;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public CurlBuilder(String url, String method, String str, RequestBody requestBody, Map<String, ? extends List<String>> headers, boolean z) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.url = url;
            this.method = method;
            this.contentType = str;
            this.requestBody = requestBody;
            this.headers = headers;
            this.printBody = z;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final RequestBody getRequestBody() {
            return this.requestBody;
        }

        public /* synthetic */ CurlBuilder(String str, String str2, String str3, RequestBody requestBody, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : requestBody, (i & 16) != 0 ? MapsKt.emptyMap() : map, z);
        }

        public final Map<String, List<String>> getHeaders() {
            return this.headers;
        }

        public final boolean getPrintBody() {
            return this.printBody;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public CurlBuilder(Request request, boolean z) {
            MediaType mediaType;
            Intrinsics.checkNotNullParameter(request, "request");
            String url = request.url().getUrl();
            String strMethod = request.method();
            RequestBody requestBodyBody = request.body();
            this(url, strMethod, (requestBodyBody == null || (mediaType = requestBodyBody.get$mediaType()) == null) ? null : mediaType.getMediaType(), request.body(), request.headers().toMultimap(), z);
        }

        public final String toCommand() {
            List<String> parts;
            StringBuilder sb = new StringBuilder("curl ");
            Locale locale = Locale.US;
            String str = this.method;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String str2 = String.format(locale, CurlInterceptor.FORMAT_METHOD, Arrays.copyOf(new Object[]{upperCase}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            sb.append(str2);
            sb.append(' ');
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                String key = entry.getKey();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    String str3 = String.format(Locale.US, CurlInterceptor.FORMAT_HEADER, Arrays.copyOf(new Object[]{key, (String) it.next()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    sb.append(' ');
                }
            }
            if (this.contentType != null && !this.headers.containsKey("Content-Type")) {
                String str4 = String.format(Locale.US, CurlInterceptor.FORMAT_HEADER, Arrays.copyOf(new Object[]{"Content-Type", this.contentType}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                sb.append(' ');
            }
            RequestBody requestBody = this.requestBody;
            if (requestBody != null && (parts = toParts(requestBody)) != null) {
                Iterator<T> it2 = parts.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(' ');
                }
            }
            String str5 = String.format(Locale.US, CurlInterceptor.FORMAT_URL, Arrays.copyOf(new Object[]{this.url}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            sb.append(str5);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private final List<String> toParts(RequestBody requestBody) {
            Map<String, List<String>> multimap;
            if (requestBody instanceof MultipartBody) {
                ArrayList arrayList = new ArrayList();
                for (MultipartBody.Part part : ((MultipartBody) requestBody).parts()) {
                    Headers headers = part.headers();
                    if (headers != null && (multimap = headers.toMultimap()) != null) {
                        for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
                            String str = String.format(Locale.US, CurlInterceptor.FORMAT_HEADER, Arrays.copyOf(new Object[]{entry.getKey(), entry.getValue()}, 2));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            arrayList.add(str);
                        }
                    }
                    if (this.printBody) {
                        String str2 = String.format(Locale.US, CurlInterceptor.FORMAT_BODY, Arrays.copyOf(new Object[]{CurlInterceptor.INSTANCE.peekBody(part.body())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        arrayList.add(str2);
                    }
                }
                return arrayList;
            }
            if (!this.printBody) {
                return CollectionsKt.emptyList();
            }
            String str3 = String.format(Locale.US, CurlInterceptor.FORMAT_BODY, Arrays.copyOf(new Object[]{CurlInterceptor.INSTANCE.peekBody(requestBody)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return CollectionsKt.listOf(str3);
        }
    }

    /* JADX INFO: compiled from: CurlInterceptor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/CurlInterceptor$Companion;", "", "()V", "CONTENT_TYPE", "", "FORMAT_BODY", "FORMAT_HEADER", "FORMAT_METHOD", "FORMAT_URL", "peekBody", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lokhttp3/RequestBody;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String peekBody(RequestBody body) {
            if (body == null) {
                return null;
            }
            try {
                Buffer buffer = new Buffer();
                Charset charsetDefaultCharset = Charset.defaultCharset();
                Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset()");
                body.writeTo(buffer);
                return buffer.readString(charsetDefaultCharset);
            } catch (IOException e) {
                return "Error while reading body: " + e;
            } catch (IllegalArgumentException e2) {
                return "Error while reading body: " + e2;
            }
        }
    }
}
