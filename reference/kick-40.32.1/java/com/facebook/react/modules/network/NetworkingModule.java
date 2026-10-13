package com.facebook.react.modules.network;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.internal.network.HttpSpec;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.DeprecatedUpgrade;
import okio.GzipSource;

/* JADX INFO: compiled from: NetworkingModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "Networking")
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\b\u0007\u0018\u0000 u2\u00020\u0001:\u0005qrstuB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB#\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\u0011J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0015\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001dH\u0000¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001bH\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001fH\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001dH\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001bH\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001fH\u0000¢\u0006\u0002\b1J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0002JT\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020!H\u0016JV\u0010@\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010?\u001a\u00020!H\u0007J^\u0010C\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010?\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0005H\u0002J\u001c\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010A\u001a\u00020\u0018H\u0002J \u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0010\u0010L\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010M\u001a\u00020#H\u0002J\u0010\u0010N\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010O\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020RH\u0017J\u0012\u0010S\u001a\u00020#2\b\u0010T\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u000209H\u0016J*\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0005H\u0002J\u001e\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010;2\b\u0010^\u001a\u0004\u0018\u000104H\u0002J\u000f\u0010_\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\b`J\u0012\u0010a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020bH\u0002J7\u0010c\u001a\u0004\u0018\u00010\u00052\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010\u00052\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010jH\u0001¢\u0006\u0002\bkJ\u0012\u0010l\u001a\u00020\u00052\b\u0010m\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010n\u001a\u00020!2\u0006\u0010o\u001a\u00020pH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule;", "Lcom/facebook/fbreact/specs/NativeNetworkingAndroidSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "defaultUserAgent", "", "client", "Lokhttp3/OkHttpClient;", "networkInterceptorCreators", "", "Lcom/facebook/react/modules/network/NetworkInterceptorCreator;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;Lokhttp3/OkHttpClient;Ljava/util/List;)V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;Lokhttp3/OkHttpClient;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "cookieHandler", "Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "cookieJarContainer", "Lcom/facebook/react/modules/network/CookieJarContainer;", "requestIds", "", "", "requestBodyHandlers", "", "Lcom/facebook/react/modules/network/NetworkingModule$RequestBodyHandler;", "uriHandlers", "Lcom/facebook/react/modules/network/NetworkingModule$UriHandler;", "responseHandlers", "Lcom/facebook/react/modules/network/NetworkingModule$ResponseHandler;", "shuttingDown", "", "initialize", "", "invalidate", "addUriHandler", "handler", "addUriHandler$ReactAndroid", "addRequestBodyHandler", "addRequestBodyHandler$ReactAndroid", "addResponseHandler", "addResponseHandler$ReactAndroid", "removeUriHandler", "removeUriHandler$ReactAndroid", "removeRequestBodyHandler", "removeRequestBodyHandler$ReactAndroid", "removeResponseHandler", "removeResponseHandler$ReactAndroid", "extractOrGenerateDevToolsRequestId", "data", "Lcom/facebook/react/bridge/ReadableMap;", "sendRequest", FirebaseAnalytics.Param.METHOD, ImagesContract.URL, "requestIdAsDouble", "", "headers", "Lcom/facebook/react/bridge/ReadableArray;", "responseType", "useIncrementalUpdates", "timeoutAsDouble", "withCredentials", "sendRequestInternal", "requestId", InstrumentationTags.TIMEOUT, "sendRequestInternalReal", NetworkingModule.REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID, "wrapRequestBodyWithProgressEmitter", "Lokhttp3/RequestBody;", "requestBody", "readWithProgress", "responseBody", "Lokhttp3/ResponseBody;", "addRequest", "removeRequest", "cancelAllRequests", "abortRequest", "cancelRequest", "clearCookies", "callback", "Lcom/facebook/react/bridge/Callback;", "addListener", "eventName", "removeListeners", "count", "constructMultipartBody", "Lokhttp3/MultipartBody$Builder;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "contentType", "extractHeaders", "Lokhttp3/Headers;", "headersArray", "requestData", "getDefaultUserAgentForTest", "getDefaultUserAgentForTest$ReactAndroid", "createDefaultUserAgent", "Landroid/content/Context;", "createDefaultUserAgentInternal", "pm", "Landroid/content/pm/PackageManager;", "packageName", "packageInfo", "Landroid/content/pm/PackageInfo;", "appInfo", "Landroid/content/pm/ApplicationInfo;", "createDefaultUserAgentInternal$ReactAndroid", "sanitizeToUserAgentToken", "value", "isUserAgentTokenChar", "c", "", "UriHandler", "RequestBodyHandler", "ResponseHandler", "CustomClientBuilder", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID = "devToolsRequestId";
    private static final String TAG = "Networking";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    private static com.facebook.react.modules.network.CustomClientBuilder customClientBuilder;
    private final OkHttpClient client;
    private final ForwardingCookieHandler cookieHandler;
    private CookieJarContainer cookieJarContainer;
    private final String defaultUserAgent;
    private final List<RequestBodyHandler> requestBodyHandlers;
    private final Set<Integer> requestIds;
    private final List<ResponseHandler> responseHandlers;
    private boolean shuttingDown;
    private final List<UriHandler> uriHandlers;

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Deprecated(message = "To be removed in a future release. See\n        https://github.com/facebook/react-native/pull/37798#pullrequestreview-1518338914")
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$CustomClientBuilder;", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface CustomClientBuilder extends com.facebook.react.modules.network.CustomClientBuilder {
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$RequestBodyHandler;", "", "supports", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface RequestBodyHandler {
        boolean supports(ReadableMap map);

        RequestBody toRequestBody(ReadableMap map, String contentType);
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$ResponseHandler;", "", "supports", "", "responseType", "", "toResponseData", "Lcom/facebook/react/bridge/WritableMap;", "data", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ResponseHandler {
        boolean supports(String responseType);

        WritableMap toResponseData(byte[] data) throws IOException;
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$UriHandler;", "", "supports", "", NetworkingModule.REQUEST_BODY_KEY_URI, "Landroid/net/Uri;", "responseType", "", "fetch", "Lkotlin/Pair;", "Lcom/facebook/react/bridge/WritableMap;", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface UriHandler {
        Pair<WritableMap, byte[]> fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String responseType);
    }

    private final boolean isUserAgentTokenChar(char c) {
        if ('a' <= c && c < '{') {
            return true;
        }
        if ('A' > c || c >= '[') {
            return ('0' <= c && c < ':') || c == '!' || c == '#' || c == '$' || c == '%' || c == '&' || c == '\'' || c == '*' || c == '+' || c == '-' || c == '.' || c == '^' || c == '_' || c == '`' || c == '|' || c == '~';
        }
        return true;
    }

    @JvmStatic
    public static final void setCustomClientBuilder(com.facebook.react.modules.network.CustomClientBuilder customClientBuilder2) {
        INSTANCE.setCustomClientBuilder(customClientBuilder2);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void addListener(String eventName) {
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkingModule(ReactApplicationContext reactContext, String str, OkHttpClient client, List<? extends NetworkInterceptorCreator> list) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(client, "client");
        this.cookieHandler = new ForwardingCookieHandler();
        this.requestIds = new HashSet();
        this.requestBodyHandlers = new ArrayList();
        this.uriHandlers = new ArrayList();
        this.responseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder builderNewBuilder = client.newBuilder();
            Iterator<? extends NetworkInterceptorCreator> it = list.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addNetworkInterceptor(it.next().create());
            }
            client = builderNewBuilder.build();
        }
        this.client = client;
        CookieJar cookieJar = client.getCookieJar();
        this.cookieJarContainer = cookieJar instanceof CookieJarContainer ? (CookieJarContainer) cookieJar : null;
        if (str == null) {
            ReactApplicationContext applicationContext = reactContext.getApplicationContext();
            str = createDefaultUserAgent(applicationContext == null ? reactContext : applicationContext);
        }
        this.defaultUserAgent = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetworkingModule(ReactApplicationContext context, String str, OkHttpClient client) {
        this(context, str, client, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(client, "client");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, null, OkHttpClientProvider.createClient(applicationContext), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context, List<? extends NetworkInterceptorCreator> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, null, OkHttpClientProvider.createClient(applicationContext), list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, str, OkHttpClientProvider.createClient(applicationContext), null);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        CookieJarContainer cookieJarContainer = this.cookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.setCookieJar(new JavaNetCookieJar(this.cookieHandler));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.shuttingDown = true;
        cancelAllRequests();
        this.cookieHandler.destroy();
        CookieJarContainer cookieJarContainer = this.cookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.removeCookieJar();
        }
        this.requestBodyHandlers.clear();
        this.responseHandlers.clear();
        this.uriHandlers.clear();
    }

    public final void addUriHandler$ReactAndroid(UriHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.uriHandlers.add(handler);
    }

    public final void addRequestBodyHandler$ReactAndroid(RequestBodyHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.requestBodyHandlers.add(handler);
    }

    public final void addResponseHandler$ReactAndroid(ResponseHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.responseHandlers.add(handler);
    }

    public final void removeUriHandler$ReactAndroid(UriHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.uriHandlers.remove(handler);
    }

    public final void removeRequestBodyHandler$ReactAndroid(RequestBodyHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.requestBodyHandlers.remove(handler);
    }

    public final void removeResponseHandler$ReactAndroid(ResponseHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.responseHandlers.remove(handler);
    }

    private final String extractOrGenerateDevToolsRequestId(ReadableMap data) {
        String string = (data != null && data.hasKey(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) && data.getType(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) == ReadableType.String) ? data.getString(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) : null;
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void sendRequest(String method, String url, double requestIdAsDouble, ReadableArray headers, ReadableMap data, String responseType, boolean useIncrementalUpdates, double timeoutAsDouble, boolean withCredentials) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        int i = (int) requestIdAsDouble;
        int i2 = (int) timeoutAsDouble;
        String strExtractOrGenerateDevToolsRequestId = extractOrGenerateDevToolsRequestId(data);
        try {
            sendRequestInternalReal(method, url, i, headers, data, responseType, useIncrementalUpdates, i2, withCredentials, strExtractOrGenerateDevToolsRequestId);
        } catch (Throwable th) {
            FLog.e("Networking", "Failed to send url request: " + url, th);
            NetworkEventUtil.onRequestError(getReactApplicationContextIfActiveOrWarn(), i, strExtractOrGenerateDevToolsRequestId, th.getMessage(), th);
        }
    }

    @Deprecated(message = "sendRequestInternal is internal and will be made private in a future release.")
    public final void sendRequestInternal(String method, String url, int requestId, ReadableArray headers, ReadableMap data, String responseType, boolean useIncrementalUpdates, int timeout, boolean withCredentials) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        sendRequestInternalReal(method, url, requestId, headers, data, responseType, useIncrementalUpdates, timeout, withCredentials, extractOrGenerateDevToolsRequestId(data));
    }

    private final void sendRequestInternalReal(String method, String url, final int requestId, ReadableArray headers, ReadableMap data, final String responseType, final boolean useIncrementalUpdates, int timeout, boolean withCredentials, final String devToolsRequestId) {
        int i;
        String str;
        ReactApplicationContext reactApplicationContext;
        RequestBodyHandler next;
        MultipartBody emptyBody;
        Charset charset;
        String str2;
        int i2;
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        try {
            Uri uri = Uri.parse(url);
            for (UriHandler uriHandler : this.uriHandlers) {
                try {
                    Intrinsics.checkNotNull(uri);
                    if (uriHandler.supports(uri, responseType)) {
                        Pair<WritableMap, byte[]> pairFetch = uriHandler.fetch(uri);
                        WritableMap writableMapComponent1 = pairFetch.component1();
                        byte[] bArrComponent2 = pairFetch.component2();
                        byte[] bytes = writableMapComponent1.toString().getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        long length = bytes.length;
                        i = requestId;
                        ReactApplicationContext reactApplicationContext2 = reactApplicationContextIfActiveOrWarn;
                        try {
                            NetworkEventUtil.onResponseReceived(reactApplicationContext2, i, devToolsRequestId, url, 200, MapsKt.emptyMap(), length);
                            reactApplicationContext = reactApplicationContext2;
                            i2 = i;
                            str2 = devToolsRequestId;
                            try {
                                NetworkEventUtil.onDataReceived(reactApplicationContext, i2, str2, writableMapComponent1, bArrComponent2);
                                NetworkEventUtil.onRequestSuccess(reactApplicationContext, i2, str2, length);
                                return;
                            } catch (IOException e) {
                                e = e;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            reactApplicationContext = reactApplicationContext2;
                            str2 = devToolsRequestId;
                        }
                    } else {
                        reactApplicationContextIfActiveOrWarn = reactApplicationContextIfActiveOrWarn;
                    }
                } catch (IOException e3) {
                    e = e3;
                    str2 = devToolsRequestId;
                    reactApplicationContext = reactApplicationContextIfActiveOrWarn;
                    i2 = requestId;
                }
                i = i2;
                str = str2;
                NetworkEventUtil.onRequestError(reactApplicationContext, i, str, e.getMessage(), e);
                return;
            }
            final ReactApplicationContext reactApplicationContext3 = reactApplicationContextIfActiveOrWarn;
            try {
                Request.Builder builderUrl = new Request.Builder().url(url == null ? "" : url);
                if (requestId != 0) {
                    builderUrl.tag(Integer.valueOf(requestId));
                }
                OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
                INSTANCE.applyCustomBuilder(builderNewBuilder);
                if (!withCredentials) {
                    builderNewBuilder.cookieJar(CookieJar.NO_COOKIES);
                }
                if (useIncrementalUpdates) {
                    builderNewBuilder.addNetworkInterceptor(new Interceptor() { // from class: com.facebook.react.modules.network.NetworkingModule$sendRequestInternalReal$$inlined$-addNetworkInterceptor$1
                        @Override // okhttp3.Interceptor
                        public final Response intercept(Interceptor.Chain chain) throws IOException {
                            Intrinsics.checkNotNullParameter(chain, "chain");
                            Response responseProceed = chain.proceed(chain.request());
                            ResponseBody body = responseProceed.getBody();
                            if (body == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            final String str3 = responseType;
                            final ReactApplicationContext reactApplicationContext4 = reactApplicationContext3;
                            final int i3 = requestId;
                            return responseProceed.newBuilder().body(new ProgressResponseBody(body, new ProgressListener() { // from class: com.facebook.react.modules.network.NetworkingModule$sendRequestInternalReal$1$responseBody$1
                                private long last = System.nanoTime();

                                public final long getLast() {
                                    return this.last;
                                }

                                public final void setLast(long j) {
                                    this.last = j;
                                }

                                @Override // com.facebook.react.modules.network.ProgressListener
                                public void onProgress(long bytesWritten, long contentLength, boolean done) {
                                    long jNanoTime = System.nanoTime();
                                    if ((done || NetworkingModule.INSTANCE.shouldDispatch(jNanoTime, this.last)) && !Intrinsics.areEqual(str3, "text")) {
                                        NetworkEventUtil.onDataReceivedProgress(reactApplicationContext4, i3, bytesWritten, contentLength);
                                        this.last = jNanoTime;
                                    }
                                }
                            })).build();
                        }
                    });
                }
                if (timeout != this.client.getCallTimeoutMillis()) {
                    builderNewBuilder.callTimeout(timeout, TimeUnit.MILLISECONDS);
                }
                OkHttpClient okHttpClientBuild = builderNewBuilder.build();
                Headers headersExtractHeaders = extractHeaders(headers, data);
                String requestBodyPreview = null;
                if (headersExtractHeaders == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Unrecognized headers format", null);
                    return;
                }
                String str3 = headersExtractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                String str4 = headersExtractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                builderUrl.headers(headersExtractHeaders);
                if (data == null) {
                    next = null;
                    break;
                }
                Iterator<RequestBodyHandler> it = this.requestBodyHandlers.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!next.supports(data));
                if (data != null) {
                    String lowerCase = method.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(lowerCase, "get")) {
                        String lowerCase2 = method.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (!Intrinsics.areEqual(lowerCase2, "head")) {
                            if (next != null) {
                                emptyBody = next.toRequestBody(data, str3);
                            } else if (data.hasKey("string")) {
                                if (str3 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                    return;
                                }
                                String string = data.getString("string");
                                MediaType mediaTypeM14426deprecated_parse = MediaType.INSTANCE.m14426deprecated_parse(str3);
                                if (RequestBodyUtil.isGzipEncoding(str4)) {
                                    emptyBody = (mediaTypeM14426deprecated_parse == null || string == null) ? null : RequestBodyUtil.createGzip(mediaTypeM14426deprecated_parse, string);
                                    if (emptyBody == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Failed to gzip request body", null);
                                        return;
                                    }
                                } else {
                                    if (mediaTypeM14426deprecated_parse == null) {
                                        charset = StandardCharsets.UTF_8;
                                    } else {
                                        charset = mediaTypeM14426deprecated_parse.charset(StandardCharsets.UTF_8);
                                        if (charset == null) {
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                    }
                                    if (string == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Received request but body was empty", null);
                                        return;
                                    }
                                    RequestBody.Companion companion = RequestBody.INSTANCE;
                                    Intrinsics.checkNotNull(charset);
                                    byte[] bytes2 = string.getBytes(charset);
                                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                                    emptyBody = RequestBody.Companion.create$default(companion, mediaTypeM14426deprecated_parse, bytes2, 0, 0, 12, (Object) null);
                                }
                            } else if (data.hasKey(REQUEST_BODY_KEY_BASE64)) {
                                if (str3 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                    return;
                                }
                                String string2 = data.getString(REQUEST_BODY_KEY_BASE64);
                                if (string2 == null) {
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                MediaType mediaTypeM14426deprecated_parse2 = MediaType.INSTANCE.m14426deprecated_parse(str3);
                                if (mediaTypeM14426deprecated_parse2 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Invalid content type specified: " + str3, null);
                                    return;
                                }
                                ByteString byteStringM14488deprecated_decodeBase64 = ByteString.INSTANCE.m14488deprecated_decodeBase64(string2);
                                if (byteStringM14488deprecated_decodeBase64 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Request body base64 string was invalid", null);
                                    return;
                                }
                                emptyBody = RequestBody.INSTANCE.create(mediaTypeM14426deprecated_parse2, byteStringM14488deprecated_decodeBase64);
                            } else if (data.hasKey(REQUEST_BODY_KEY_URI)) {
                                if (str3 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                    return;
                                }
                                String string3 = data.getString(REQUEST_BODY_KEY_URI);
                                if (string3 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Request body URI field was set but null", null);
                                    return;
                                }
                                ReactApplicationContext reactApplicationContext4 = getReactApplicationContext();
                                Intrinsics.checkNotNullExpressionValue(reactApplicationContext4, "getReactApplicationContext(...)");
                                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(reactApplicationContext4, string3);
                                if (fileInputStream == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Could not retrieve file for uri " + string3, null);
                                    return;
                                }
                                emptyBody = RequestBodyUtil.create(MediaType.INSTANCE.m14426deprecated_parse(str3), fileInputStream);
                            } else if (data.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                                if (str3 == null) {
                                    str3 = ShareTarget.ENCODING_TYPE_MULTIPART;
                                }
                                ReadableArray array = data.getArray(REQUEST_BODY_KEY_FORMDATA);
                                if (array == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Received request but form data was empty", null);
                                    return;
                                }
                                requestBodyPreview = null;
                                MultipartBody.Builder builderConstructMultipartBody = constructMultipartBody(array, str3, requestId, devToolsRequestId);
                                if (builderConstructMultipartBody == null) {
                                    return;
                                } else {
                                    emptyBody = builderConstructMultipartBody.build();
                                }
                            } else {
                                requestBodyPreview = null;
                                emptyBody = RequestBodyUtil.getEmptyBody(method);
                            }
                            requestBodyPreview = null;
                        }
                    }
                    requestBodyPreview = null;
                    emptyBody = RequestBodyUtil.getEmptyBody(method);
                } else {
                    emptyBody = RequestBodyUtil.getEmptyBody(method);
                }
                builderUrl.method(method, wrapRequestBodyWithProgressEmitter(emptyBody, requestId));
                addRequest(requestId);
                Request requestBuild = builderUrl.build();
                String url2 = requestBuild.getUrl().getUrl();
                String method2 = requestBuild.getMethod();
                Map<String, String> mapOkHttpHeadersToMap = NetworkEventUtil.okHttpHeadersToMap(requestBuild.getHeaders());
                if (ReactBuildConfig.DEBUG) {
                    requestBodyPreview = NetworkEventUtil.getRequestBodyPreview(requestBuild.getBody());
                }
                RequestBody body = requestBuild.getBody();
                NetworkEventUtil.onCreateRequest(devToolsRequestId, url2, method2, mapOkHttpHeadersToMap, requestBodyPreview, body != null ? body.contentLength() : 0L);
                okHttpClientBuild.newCall(requestBuild).enqueue(new Callback() { // from class: com.facebook.react.modules.network.NetworkingModule.sendRequestInternalReal.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException e4) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(e4, "e");
                        if (NetworkingModule.this.shuttingDown) {
                            return;
                        }
                        NetworkingModule.this.removeRequest(requestId);
                        String message = e4.getMessage();
                        if (message == null) {
                            message = "Error while executing request: " + e4.getClass().getSimpleName();
                        }
                        NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, message, e4);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (NetworkingModule.this.shuttingDown) {
                            return;
                        }
                        NetworkingModule.this.removeRequest(requestId);
                        ReactApplicationContext reactApplicationContext5 = reactApplicationContext3;
                        int i3 = requestId;
                        String str5 = devToolsRequestId;
                        String url3 = response.getRequest().getUrl().getUrl();
                        int code = response.getCode();
                        Map<String, String> mapOkHttpHeadersToMap2 = NetworkEventUtil.okHttpHeadersToMap(response.getHeaders());
                        ResponseBody body2 = response.getBody();
                        NetworkEventUtil.onResponseReceived(reactApplicationContext5, i3, str5, url3, code, mapOkHttpHeadersToMap2, body2 != null ? body2.getContentLength() : 0L);
                        try {
                            try {
                                ResponseBody body3 = response.getBody();
                                if (body3 == null) {
                                    NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Response body is null", null);
                                    return;
                                }
                                if (StringsKt.equals("gzip", Response.header$default(response, "Content-Encoding", null, 2, null), true)) {
                                    GzipSource gzipSource = new GzipSource(body3.getBodySource());
                                    String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
                                    body3 = ResponseBody.INSTANCE.create(strHeader$default != null ? MediaType.INSTANCE.m14426deprecated_parse(strHeader$default) : null, -1L, DeprecatedUpgrade.getOkio().buffer(gzipSource));
                                }
                                ResponseBody responseBody = body3;
                                if (responseBody != null) {
                                    for (ResponseHandler responseHandler : NetworkingModule.this.responseHandlers) {
                                        if (responseHandler.supports(responseType)) {
                                            byte[] bArrBytes = responseBody.bytes();
                                            NetworkEventUtil.onDataReceived(reactApplicationContext3, requestId, devToolsRequestId, responseHandler.toResponseData(bArrBytes), bArrBytes);
                                            NetworkEventUtil.onRequestSuccess(reactApplicationContext3, requestId, devToolsRequestId, responseBody.getContentLength());
                                            return;
                                        }
                                    }
                                    if (useIncrementalUpdates && Intrinsics.areEqual(responseType, "text")) {
                                        NetworkingModule.this.readWithProgress(requestId, devToolsRequestId, responseBody);
                                        NetworkEventUtil.onRequestSuccess(reactApplicationContext3, requestId, devToolsRequestId, responseBody.getContentLength());
                                        return;
                                    }
                                    String strString = "";
                                    if (Intrinsics.areEqual(responseType, "text")) {
                                        try {
                                            strString = responseBody.string();
                                        } catch (IOException e4) {
                                            if (!StringsKt.equals(response.getRequest().getMethod(), HttpSpec.Method.HEAD, true)) {
                                                NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, e4.getMessage(), e4);
                                            }
                                        }
                                    } else if (Intrinsics.areEqual(responseType, NetworkingModule.REQUEST_BODY_KEY_BASE64)) {
                                        strString = Base64.encodeToString(responseBody.bytes(), 2);
                                    }
                                    NetworkEventUtil.onDataReceived(reactApplicationContext3, requestId, devToolsRequestId, strString, responseType);
                                    NetworkEventUtil.onRequestSuccess(reactApplicationContext3, requestId, devToolsRequestId, responseBody.getContentLength());
                                    return;
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            } catch (OutOfMemoryError unused) {
                                NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, "Out of memory while processing network response", null);
                            }
                        } catch (IOException e5) {
                            NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, e5.getMessage(), e5);
                        }
                    }
                });
            } catch (Exception e4) {
                NetworkEventUtil.onRequestError(reactApplicationContext3, requestId, devToolsRequestId, e4.getMessage(), e4);
            }
        } catch (IOException e5) {
            e = e5;
            i = requestId;
            str = devToolsRequestId;
            reactApplicationContext = reactApplicationContextIfActiveOrWarn;
        }
    }

    private final RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final int requestId) {
        if (requestBody == null) {
            return null;
        }
        final ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() { // from class: com.facebook.react.modules.network.NetworkingModule.wrapRequestBodyWithProgressEmitter.1
            private long last = System.nanoTime();

            public final long getLast() {
                return this.last;
            }

            public final void setLast(long j) {
                this.last = j;
            }

            @Override // com.facebook.react.modules.network.ProgressListener
            public void onProgress(long bytesWritten, long contentLength, boolean done) {
                long jNanoTime = System.nanoTime();
                if (done || NetworkingModule.INSTANCE.shouldDispatch(jNanoTime, this.last)) {
                    NetworkEventUtil.onDataSend(reactApplicationContextIfActiveOrWarn, requestId, bytesWritten, contentLength);
                    this.last = jNanoTime;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readWithProgress(int requestId, String devToolsRequestId, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long contentLength = -1;
        try {
            Intrinsics.checkNotNull(responseBody, "null cannot be cast to non-null type com.facebook.react.modules.network.ProgressResponseBody");
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.getTotalBytesRead();
            try {
                contentLength = progressResponseBody.getContentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        long j2 = contentLength;
        long j3 = j;
        if (responseBody.get$contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            MediaType mediaType = responseBody.get$contentType();
            charset = mediaType != null ? mediaType.charset(StandardCharsets.UTF_8) : null;
            if (charset == null) {
                throw new IllegalStateException(("Null character set for Content-Type: " + responseBody.get$contentType()).toString());
            }
        }
        Intrinsics.checkNotNull(charset);
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream inputStreamByteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            while (true) {
                int i = inputStreamByteStream.read(bArr);
                if (i != -1) {
                    NetworkEventUtil.onIncrementalDataReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, progressiveStringDecoder.decodeNext(bArr, i), j3, j2);
                } else {
                    inputStreamByteStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStreamByteStream.close();
            throw th;
        }
    }

    private final synchronized void addRequest(int requestId) {
        this.requestIds.add(Integer.valueOf(requestId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void removeRequest(int requestId) {
        this.requestIds.remove(Integer.valueOf(requestId));
    }

    private final synchronized void cancelAllRequests() {
        Iterator<Integer> it = this.requestIds.iterator();
        while (it.hasNext()) {
            cancelRequest(it.next().intValue());
        }
        this.requestIds.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void abortRequest(double requestIdAsDouble) {
        int i = (int) requestIdAsDouble;
        cancelRequest(i);
        removeRequest(i);
    }

    private final void cancelRequest(int requestId) {
        OkHttpCallUtil.cancelTag(this.client, Integer.valueOf(requestId));
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    @ReactMethod
    public void clearCookies(com.facebook.react.bridge.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cookieHandler.clearCookies(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MultipartBody.Builder constructMultipartBody(ReadableArray body, String contentType, int requestId, String devToolsRequestId) {
        MediaType mediaTypeM14426deprecated_parse;
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        MultipartBody.Builder builder = new MultipartBody.Builder(null, 1, 0 == true ? 1 : 0);
        MediaType mediaTypeM14426deprecated_parse2 = MediaType.INSTANCE.m14426deprecated_parse(contentType);
        if (mediaTypeM14426deprecated_parse2 == null) {
            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Invalid media type.", null);
            return null;
        }
        builder.setType(mediaTypeM14426deprecated_parse2);
        int size = body.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = body.getMap(i);
            if (map == null) {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Unrecognized FormData part.", null);
                return null;
            }
            Headers headersExtractHeaders = extractHeaders(map.getArray("headers"), null);
            if (headersExtractHeaders == null) {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str = headersExtractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str != null) {
                mediaTypeM14426deprecated_parse = MediaType.INSTANCE.m14426deprecated_parse(str);
                headersExtractHeaders = headersExtractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaTypeM14426deprecated_parse = null;
            }
            if (map.hasKey("string") && map.getString("string") != null) {
                String string = map.getString("string");
                if (string == null) {
                    string = "";
                }
                builder.addPart(headersExtractHeaders, RequestBody.INSTANCE.create(mediaTypeM14426deprecated_parse, string));
            } else if (map.hasKey(REQUEST_BODY_KEY_URI) && map.getString(REQUEST_BODY_KEY_URI) != null) {
                if (mediaTypeM14426deprecated_parse == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Binary FormData part needs a content-type header.", null);
                    return null;
                }
                String string2 = map.getString(REQUEST_BODY_KEY_URI);
                if (string2 == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Body must have a valid file uri", null);
                    return null;
                }
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(reactApplicationContext, string2);
                if (fileInputStream == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Could not retrieve file for uri " + string2, null);
                    return null;
                }
                builder.addPart(headersExtractHeaders, RequestBodyUtil.create(mediaTypeM14426deprecated_parse, fileInputStream));
            } else {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Unrecognized FormData part.", null);
                Unit unit = Unit.INSTANCE;
            }
        }
        return builder;
    }

    private final Headers extractHeaders(ReadableArray headersArray, ReadableMap requestData) {
        String str;
        if (headersArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headersArray.size();
        for (int i = 0; i < size; i++) {
            ReadableArray array = headersArray.getArray(i);
            if (array != null && array.size() == 2) {
                String string = array.getString(0);
                if (string != null) {
                    string = HeaderUtil.INSTANCE.stripHeaderName(string);
                }
                String string2 = array.getString(1);
                if (string != null && string2 != null) {
                    builder.addUnsafeNonAscii(string, string2);
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.defaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (requestData == null || !requestData.hasKey("string")) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    /* JADX INFO: renamed from: getDefaultUserAgentForTest$ReactAndroid, reason: from getter */
    public final String getDefaultUserAgent() {
        return this.defaultUserAgent;
    }

    private final String createDefaultUserAgent(Context context) {
        String packageName;
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        if (packageManager == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return createDefaultUserAgentInternal$ReactAndroid(packageManager, packageName, packageInfo, applicationInfo);
    }

    public final String createDefaultUserAgentInternal$ReactAndroid(PackageManager pm, String packageName, PackageInfo packageInfo, ApplicationInfo appInfo) {
        String str;
        String strSanitizeToUserAgentToken;
        CharSequence applicationLabel;
        String str2 = null;
        if (pm == null || packageName == null) {
            return null;
        }
        String strSanitizeToUserAgentToken2 = sanitizeToUserAgentToken((appInfo == null || (applicationLabel = pm.getApplicationLabel(appInfo)) == null) ? null : applicationLabel.toString());
        if (strSanitizeToUserAgentToken2.length() == 0) {
            strSanitizeToUserAgentToken2 = sanitizeToUserAgentToken(packageName);
        }
        String str3 = strSanitizeToUserAgentToken2;
        if (str3.length() == 0) {
            return null;
        }
        if (packageInfo != null && (str = packageInfo.versionName) != null && (strSanitizeToUserAgentToken = sanitizeToUserAgentToken(str)) != null && strSanitizeToUserAgentToken.length() > 0) {
            str2 = strSanitizeToUserAgentToken;
        }
        if (str2 == null) {
            return str3;
        }
        return str3 + DomExceptionUtils.SEPARATOR + str2;
    }

    private final String sanitizeToUserAgentToken(String value) {
        String str = value;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(value.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isUserAgentTokenChar(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "CONTENT_ENCODING_HEADER_NAME", "CONTENT_TYPE_HEADER_NAME", "REQUEST_BODY_KEY_STRING", "REQUEST_BODY_KEY_URI", "REQUEST_BODY_KEY_FORMDATA", "REQUEST_BODY_KEY_BASE64", "REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID", "USER_AGENT_HEADER_NAME", "CHUNK_TIMEOUT_NS", "", "MAX_CHUNK_SIZE_BETWEEN_FLUSHES", "customClientBuilder", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "setCustomClientBuilder", "", "ccb", "applyCustomBuilder", "builder", "Lokhttp3/OkHttpClient$Builder;", "shouldDispatch", "", "now", "", "last", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldDispatch(long now, long last) {
            return last + 100000000 < now;
        }

        private Companion() {
        }

        @JvmStatic
        public final void setCustomClientBuilder(com.facebook.react.modules.network.CustomClientBuilder ccb) {
            NetworkingModule.customClientBuilder = ccb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyCustomBuilder(OkHttpClient.Builder builder) {
            com.facebook.react.modules.network.CustomClientBuilder customClientBuilder = NetworkingModule.customClientBuilder;
            if (customClientBuilder != null) {
                customClientBuilder.apply(builder);
            }
        }
    }
}
