package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.datadog.android.log.LogAttributes;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PackagerConnectionSettings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J2\u0010\u0013\u001a\u00020\u00122*\u0010\u0014\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00160\u0015J&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00168F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "packageName", "", "getPackageName", "()Ljava/lang/String;", LogAttributes.HOST, "debugServerHost", "getDebugServerHost", "setDebugServerHost", "(Ljava/lang/String;)V", "resetDebugServerHost", "", "setPackagerOptionsUpdater", "queryMapper", "Lkotlin/Function1;", "", "updatePackagerOptions", "options", "setAdditionalOptionForPackager", "key", "value", "additionalOptionsForPackager", "getAdditionalOptionsForPackager", "()Ljava/util/Map;", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class PackagerConnectionSettings {
    private static final String PREFS_DEBUG_SERVER_HOST_KEY = "debug_http_host";
    private static String _cachedOrOverrideHost;
    private final Context appContext;
    private final String packageName;
    private final SharedPreferences preferences;
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "PackagerConnectionSettings";
    private static final Map<String, String> _additionalOptionsForPackager = new LinkedHashMap();
    private static Function1<? super Map<String, String>, ? extends Map<String, String>> _packagerOptionsUpdater = new Function1() { // from class: com.facebook.react.packagerconnection.PackagerConnectionSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PackagerConnectionSettings._packagerOptionsUpdater$lambda$1((Map) obj);
        }
    };

    static final Map _packagerOptionsUpdater$lambda$1(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public PackagerConnectionSettings(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.preferences = defaultSharedPreferences;
        String packageName = appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.packageName = packageName;
        _cachedOrOverrideHost = null;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public String getDebugServerHost() {
        String str = _cachedOrOverrideHost;
        if (str != null) {
            return str;
        }
        String string = this.preferences.getString(PREFS_DEBUG_SERVER_HOST_KEY, null);
        String str2 = string;
        if (str2 != null && str2.length() != 0) {
            return string;
        }
        String serverHost = AndroidInfoHelpers.getServerHost(this.appContext);
        if (Intrinsics.areEqual(serverHost, "localhost")) {
            FLog.w(TAG, "You seem to be running on device. Run '" + AndroidInfoHelpers.getAdbReverseTcpCommand(this.appContext) + "' to forward the debug server's port to the device.");
        }
        _cachedOrOverrideHost = serverHost;
        return serverHost;
    }

    public void setDebugServerHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        int length = host.length();
        SharedPreferences sharedPreferences = this.preferences;
        if (length == 0) {
            sharedPreferences.edit().remove(PREFS_DEBUG_SERVER_HOST_KEY).apply();
            _cachedOrOverrideHost = null;
        } else {
            sharedPreferences.edit().putString(PREFS_DEBUG_SERVER_HOST_KEY, host).apply();
            _cachedOrOverrideHost = host;
        }
    }

    public void resetDebugServerHost() {
        this.preferences.edit().remove(PREFS_DEBUG_SERVER_HOST_KEY).apply();
        _cachedOrOverrideHost = null;
    }

    public final void setPackagerOptionsUpdater(Function1<? super Map<String, String>, ? extends Map<String, String>> queryMapper) {
        Intrinsics.checkNotNullParameter(queryMapper, "queryMapper");
        _packagerOptionsUpdater = queryMapper;
    }

    public final Map<String, String> updatePackagerOptions(Map<String, String> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return _packagerOptionsUpdater.invoke(options);
    }

    public final void setAdditionalOptionForPackager(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        _additionalOptionsForPackager.put(key, value);
    }

    public final Map<String, String> getAdditionalOptionsForPackager() {
        return _additionalOptionsForPackager;
    }

    /* JADX INFO: compiled from: PackagerConnectionSettings.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/packagerconnection/PackagerConnectionSettings$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "PREFS_DEBUG_SERVER_HOST_KEY", "_cachedOrOverrideHost", "_additionalOptionsForPackager", "", "_packagerOptionsUpdater", "Lkotlin/Function1;", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
