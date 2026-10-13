package io.mobileshield.sdk;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.mobileshield.sdk.config.Config;
import java.net.HttpURLConnection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\bH'J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J5\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H&¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH&J0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0017\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020,H&J)\u0010-\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H&¢\u0006\u0002\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Lio/mobileshield/sdk/MobileShieldInterface;", "", "checkResponse", "", "status", "", "headers", "", "", "deleteData", "dispose", "getHeaders", "headersCallback", "Lio/mobileshield/sdk/HeadersCallback;", "domainname", FirebaseAnalytics.Param.METHOD, ImagesContract.URL, "init", "userAgent", "mobileShieldReadinessListener", "Lio/mobileshield/sdk/MobileShieldReadinessListener;", "listConfigs", "", "Lio/mobileshield/sdk/config/Config;", "(Ljava/lang/String;Lio/mobileshield/sdk/MobileShieldReadinessListener;[Lio/mobileshield/sdk/config/Config;)V", "isReadyForAllDomains", "", "isReadyForDomain", "isValid", "originalRequest", "Lokhttp3/Request;", "mergeHeaders", "userHeader", "obtainInterceptor", "Lokhttp3/Interceptor;", "timeMs", "(Ljava/lang/Integer;)Lokhttp3/Interceptor;", "parseResponse", "urlConnection", "Ljava/net/HttpURLConnection;", "response", "Lokhttp3/Response;", "protect", "callback", "Lio/mobileshield/sdk/ClientCallback;", "update", "(Ljava/lang/String;[Lio/mobileshield/sdk/config/Config;)V", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MobileShieldInterface {
    static /* synthetic */ void init$default(MobileShieldInterface mobileShieldInterface, String str, MobileShieldReadinessListener mobileShieldReadinessListener, Config[] configArr, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i & 2) != 0) {
            mobileShieldReadinessListener = null;
        }
        mobileShieldInterface.init(str, mobileShieldReadinessListener, configArr);
    }

    void checkResponse(int status, Map<String, String> headers);

    void deleteData();

    void dispose();

    @Deprecated(message = "This method will be removed in future")
    Map<String, String> getHeaders(String domainname);

    void getHeaders(HeadersCallback headersCallback);

    void getHeaders(String method, String url, HeadersCallback headersCallback);

    void init(String userAgent, MobileShieldReadinessListener mobileShieldReadinessListener, Config... listConfigs);

    boolean isReadyForAllDomains();

    boolean isReadyForDomain(String domainname);

    boolean isValid(Request originalRequest);

    Map<String, String> mergeHeaders(String domainname, Map<String, String> userHeader);

    Interceptor obtainInterceptor(Integer timeMs);

    void parseResponse(HttpURLConnection urlConnection);

    void parseResponse(Response response);

    void protect(HttpURLConnection urlConnection, ClientCallback callback);

    void update(String userAgent, Config... listConfigs);
}
