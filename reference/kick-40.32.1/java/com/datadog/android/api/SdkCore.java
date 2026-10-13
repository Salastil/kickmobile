package com.datadog.android.api;

import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: SdkCore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH&J\u001e\u0010\u0010\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH'J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH'J\b\u0010\u0013\u001a\u00020\rH'J\b\u0010\u0014\u001a\u00020\u0015H'J4\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH'J@\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/api/SdkCore;", "", "name", "", "getName", "()Ljava/lang/String;", "service", "getService", "time", "Lcom/datadog/android/api/context/TimeInfo;", "getTime", "()Lcom/datadog/android/api/context/TimeInfo;", "addAccountExtraInfo", "", "extraInfo", "", "addUserProperties", "clearAccountInfo", "clearAllData", "clearUserInfo", "isCoreActive", "", "setAccountInfo", "id", "setTrackingConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Lcom/datadog/android/privacy/TrackingConsent;", "setUserInfo", "email", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SdkCore {
    void addAccountExtraInfo(Map<String, ? extends Object> extraInfo);

    void addUserProperties(Map<String, ? extends Object> extraInfo);

    void clearAccountInfo();

    void clearAllData();

    void clearUserInfo();

    String getName();

    String getService();

    TimeInfo getTime();

    boolean isCoreActive();

    void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo);

    void setTrackingConsent(TrackingConsent consent);

    void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo);

    /* JADX INFO: compiled from: SdkCore.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setUserInfo$default(SdkCore sdkCore, String str, String str2, String str3, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setUserInfo");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            sdkCore.setUserInfo(str, str2, str3, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setAccountInfo$default(SdkCore sdkCore, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAccountInfo");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            sdkCore.setAccountInfo(str, str2, map);
        }
    }
}
