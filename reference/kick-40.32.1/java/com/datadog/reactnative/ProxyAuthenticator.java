package com.datadog.reactnative;

import android.util.Log;
import androidx.autofill.HintConstants;
import io.ktor.http.auth.AuthScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: ProxyAuthenticator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/datadog/reactnative/ProxyAuthenticator;", "Lokhttp3/Authenticator;", HintConstants.AUTOFILL_HINT_USERNAME, "", "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUsername$datadog_mobile_react_native_release", "()Ljava/lang/String;", "getPassword$datadog_mobile_react_native_release", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProxyAuthenticator implements Authenticator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE = 407;
    private final String password;
    private final String username;

    public ProxyAuthenticator(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
    }

    /* JADX INFO: renamed from: getUsername$datadog_mobile_react_native_release, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: getPassword$datadog_mobile_react_native_release, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getCode() != 407) {
            Log.w(ProxyAuthenticator.class.getCanonicalName(), "Unexpected response code=" + response.getCode() + " received during proxy authentication request.");
            return null;
        }
        for (Challenge challenge : response.challenges()) {
            String scheme = challenge.getScheme();
            if (StringsKt.equals(AuthScheme.Basic, scheme, true) || StringsKt.equals("OkHttp-Preemptive", scheme, true)) {
                return response.getRequest().newBuilder().header("Proxy-Authorization", Credentials.basic(this.username, this.password, challenge.m14372deprecated_charset())).build();
            }
        }
        Log.w(ProxyAuthenticator.class.getCanonicalName(), "No known challenges are satisfied during proxy authentication request.");
        return null;
    }

    /* JADX INFO: compiled from: ProxyAuthenticator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/datadog/reactnative/ProxyAuthenticator$Companion;", "", "<init>", "()V", "PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE", "", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
