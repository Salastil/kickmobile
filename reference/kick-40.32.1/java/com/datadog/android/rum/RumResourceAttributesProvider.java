package com.datadog.android.rum;

import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpResponseInfo;
import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RumResourceAttributesProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J2\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH'¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/RumResourceAttributesProvider;", "", "onProvideAttributes", "", "", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "response", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "Lokhttp3/Request;", "Lokhttp3/Response;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumResourceAttributesProvider {
    Map<String, Object> onProvideAttributes(HttpRequestInfo request, HttpResponseInfo response, Throwable throwable);

    @Deprecated(message = "Use the variant with HttpRequestInfo/HttpResponseInfo instead")
    Map<String, Object> onProvideAttributes(Request request, Response response, Throwable throwable);

    /* JADX INFO: compiled from: RumResourceAttributesProvider.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Map<String, Object> onProvideAttributes(RumResourceAttributesProvider rumResourceAttributesProvider, HttpRequestInfo request, HttpResponseInfo httpResponseInfo, Throwable th) {
            Intrinsics.checkNotNullParameter(request, "request");
            return MapsKt.emptyMap();
        }
    }
}
