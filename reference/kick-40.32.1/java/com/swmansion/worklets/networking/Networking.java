package com.swmansion.worklets.networking;

import androidx.core.app.NotificationCompat;
import com.datadog.android.internal.network.HttpSpec;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSink;
import okio.Okio;

/* JADX INFO: compiled from: Networking.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u000223B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jc\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J[\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\fH\u0002J \u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020\f2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/swmansion/worklets/networking/Networking;", "", "<init>", "()V", "mClient", "Lokhttp3/OkHttpClient;", "getMClient", "()Lokhttp3/OkHttpClient;", "mClient$delegate", "Lkotlin/Lazy;", "mCalls", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lokhttp3/Call;", "mAbortedIds", "", "sendRequest", "", "requestIdAsDouble", "", FirebaseAnalytics.Param.METHOD, "", ImagesContract.URL, "headerNames", "", "headerValues", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "timeoutMs", "withCredentials", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/swmansion/worklets/networking/NetworkRequestListener;", "(DLjava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[BDZLcom/swmansion/worklets/networking/NetworkRequestListener;)V", "decodeText", "bytes", "label", "abortRequest", "buildCall", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[BDZLcom/swmansion/worklets/networking/NetworkRequestListener;)Lokhttp3/Call;", "handleResponse", "response", "Lokhttp3/Response;", "cleanup", "requestId", "errorCode", "", NotificationCompat.CATEGORY_CALL, "e", "Ljava/io/IOException;", "Companion", "ProgressRequestBody", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Networking {
    public static final int ERROR_ABORTED = 2;
    public static final int ERROR_NETWORK = 0;
    public static final int ERROR_TIMEOUT = 1;
    private static final long PROGRESS_INTERVAL_MS = 50;
    private static final long READ_BUFFER_SIZE = 65536;
    private final Set<Long> mAbortedIds;
    private static final Set<String> METHODS_REQUIRING_BODY = SetsKt.setOf((Object[]) new String[]{"POST", HttpSpec.Method.PUT, HttpSpec.Method.PATCH});

    /* JADX INFO: renamed from: mClient$delegate, reason: from kotlin metadata */
    private final Lazy mClient = LazyKt.lazy(new Function0() { // from class: com.swmansion.worklets.networking.Networking$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Networking.mClient_delegate$lambda$0();
        }
    });
    private final ConcurrentHashMap<Long, Call> mCalls = new ConcurrentHashMap<>();

    public Networking() {
        Set<Long> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(...)");
        this.mAbortedIds = setNewSetFromMap;
    }

    private final OkHttpClient getMClient() {
        return (OkHttpClient) this.mClient.getValue();
    }

    static final OkHttpClient mClient_delegate$lambda$0() {
        OkHttpClient okHttpClientCreateClient = OkHttpClientProvider.createClient();
        CookieJar cookieJar = okHttpClientCreateClient.cookieJar();
        CookieJarContainer cookieJarContainer = cookieJar instanceof CookieJarContainer ? (CookieJarContainer) cookieJar : null;
        if (cookieJarContainer != null) {
            cookieJarContainer.setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler()));
        }
        return okHttpClientCreateClient;
    }

    public final void sendRequest(double requestIdAsDouble, String method, String url, String[] headerNames, String[] headerValues, byte[] body, double timeoutMs, boolean withCredentials, final NetworkRequestListener listener) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headerNames, "headerNames");
        Intrinsics.checkNotNullParameter(headerValues, "headerValues");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long j = (long) requestIdAsDouble;
        try {
            Call callBuildCall = buildCall(method, url, headerNames, headerValues, body, timeoutMs, withCredentials, listener);
            this.mCalls.put(Long.valueOf(j), callBuildCall);
            if (this.mAbortedIds.contains(Long.valueOf(j))) {
                callBuildCall.cancel();
            }
            callBuildCall.enqueue(new Callback() { // from class: com.swmansion.worklets.networking.Networking.sendRequest.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException e) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    int iErrorCode = Networking.this.errorCode(j, call, e);
                    Networking.this.cleanup(j);
                    NetworkRequestListener networkRequestListener = listener;
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    Intrinsics.checkNotNull(message);
                    networkRequestListener.onError(iErrorCode, message);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        Response response2 = response;
                        try {
                            Networking.this.handleResponse(response2, listener);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(response2, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(response2, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            NetworkRequestListener networkRequestListener = listener;
                            int iErrorCode = th3 instanceof IOException ? Networking.this.errorCode(j, call, th3) : 0;
                            String message = th3.getMessage();
                            if (message == null) {
                                message = th3.getClass().getSimpleName();
                            }
                            Intrinsics.checkNotNull(message);
                            networkRequestListener.onError(iErrorCode, message);
                        } finally {
                            Networking.this.cleanup(j);
                        }
                    }
                }
            });
        } catch (Exception e) {
            cleanup(j);
            String message = e.getMessage();
            if (message == null) {
                message = e.getClass().getSimpleName();
            }
            Intrinsics.checkNotNull(message);
            listener.onError(0, message);
        }
    }

    public final String decodeText(byte[] bytes, String label) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(label, "label");
        try {
            Charset charsetForName = Charset.forName(label);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            return new String(bytes, charsetForName);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final void abortRequest(double requestIdAsDouble) {
        long j = (long) requestIdAsDouble;
        this.mAbortedIds.add(Long.valueOf(j));
        Call call = this.mCalls.get(Long.valueOf(j));
        if (call != null) {
            call.cancel();
        }
    }

    private final Call buildCall(String method, String url, String[] headerNames, String[] headerValues, byte[] body, double timeoutMs, boolean withCredentials, NetworkRequestListener listener) {
        Request.Builder builderUrl = new Request.Builder().url(url);
        int length = headerNames.length;
        ProgressRequestBody progressRequestBody = null;
        MediaType mediaType = null;
        for (int i = 0; i < length; i++) {
            builderUrl.addHeader(headerNames[i], headerValues[i]);
            if (StringsKt.equals(headerNames[i], "content-type", true)) {
                mediaType = MediaType.INSTANCE.parse(headerValues[i]);
            }
        }
        if (body != null) {
            progressRequestBody = new ProgressRequestBody(body, mediaType, listener);
        } else {
            Set<String> set = METHODS_REQUIRING_BODY;
            String upperCase = method.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (set.contains(upperCase)) {
                progressRequestBody = new ProgressRequestBody(new byte[0], mediaType, listener);
            }
        }
        builderUrl.method(method, progressRequestBody);
        OkHttpClient.Builder builderCallTimeout = getMClient().newBuilder().callTimeout(timeoutMs > 0.0d ? (long) timeoutMs : 0L, TimeUnit.MILLISECONDS);
        if (!withCredentials) {
            builderCallTimeout.cookieJar(CookieJar.NO_COOKIES);
        }
        return builderCallTimeout.build().newCall(builderUrl.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResponse(Response response, NetworkRequestListener listener) {
        Headers headers = response.headers();
        int size = headers.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = headers.name(i);
        }
        int size2 = headers.size();
        String[] strArr2 = new String[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            strArr2[i2] = headers.value(i2);
        }
        listener.onResponse(response.code(), response.message(), strArr, strArr2, response.request().url().getUrl());
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            listener.onComplete(new byte[0]);
            return;
        }
        long contentLength = responseBodyBody.getContentLength();
        BufferedSource source = responseBodyBody.getBodySource();
        Buffer buffer = new Buffer();
        long j = 0;
        while (source.read(buffer, 65536L) != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - j >= 50) {
                listener.onDownloadProgress(buffer.size(), contentLength);
                j = jCurrentTimeMillis;
            }
        }
        listener.onComplete(buffer.readByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanup(long requestId) {
        this.mCalls.remove(Long.valueOf(requestId));
        this.mAbortedIds.remove(Long.valueOf(requestId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int errorCode(long requestId, Call call, IOException e) {
        if (this.mAbortedIds.contains(Long.valueOf(requestId))) {
            return 2;
        }
        if (e instanceof InterruptedIOException) {
            return 1;
        }
        return call.getCanceled() ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Networking.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/swmansion/worklets/networking/Networking$ProgressRequestBody;", "Lokhttp3/RequestBody;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "contentType", "Lokhttp3/MediaType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/swmansion/worklets/networking/NetworkRequestListener;", "<init>", "([BLokhttp3/MediaType;Lcom/swmansion/worklets/networking/NetworkRequestListener;)V", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final class ProgressRequestBody extends RequestBody {
        private final byte[] body;
        private final MediaType contentType;
        private final NetworkRequestListener listener;

        public ProgressRequestBody(byte[] body, MediaType mediaType, NetworkRequestListener listener) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.body = body;
            this.contentType = mediaType;
            this.listener = listener;
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType, reason: from getter */
        public MediaType get$mediaType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.body.length;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(final BufferedSink sink) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.LongRef longRef2 = new Ref.LongRef();
            final long length = this.body.length;
            BufferedSink bufferedSinkBuffer = Okio.buffer(new ForwardingSink(sink, longRef, length, longRef2, this) { // from class: com.swmansion.worklets.networking.Networking$ProgressRequestBody$writeTo$countingSink$1
                final /* synthetic */ Ref.LongRef $lastProgressAt;
                final /* synthetic */ Ref.LongRef $sent;
                final /* synthetic */ long $total;
                final /* synthetic */ Networking.ProgressRequestBody this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(sink);
                    this.$sent = longRef;
                    this.$total = length;
                    this.$lastProgressAt = longRef2;
                    this.this$0 = this;
                }

                @Override // okio.ForwardingSink, okio.Sink
                public void write(Buffer source, long byteCount) throws IOException {
                    Intrinsics.checkNotNullParameter(source, "source");
                    super.write(source, byteCount);
                    this.$sent.element += byteCount;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (this.$sent.element == this.$total || jCurrentTimeMillis - this.$lastProgressAt.element >= 50) {
                        this.$lastProgressAt.element = jCurrentTimeMillis;
                        this.this$0.listener.onUploadProgress(this.$sent.element, this.$total);
                    }
                }
            });
            bufferedSinkBuffer.write(this.body);
            bufferedSinkBuffer.flush();
            if (longRef.element == 0) {
                this.listener.onUploadProgress(0L, 0L);
            }
        }
    }
}
