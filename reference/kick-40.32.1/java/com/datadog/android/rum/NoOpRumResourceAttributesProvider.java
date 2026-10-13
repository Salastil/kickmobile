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

/* JADX INFO: compiled from: NoOpRumResourceAttributesProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J2\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/NoOpRumResourceAttributesProvider;", "Lcom/datadog/android/rum/RumResourceAttributesProvider;", "()V", "onProvideAttributes", "", "", "", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "response", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "Lokhttp3/Request;", "Lokhttp3/Response;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpRumResourceAttributesProvider implements RumResourceAttributesProvider {
    @Override // com.datadog.android.rum.RumResourceAttributesProvider
    @Deprecated(message = "Use the variant with HttpRequestInfo/HttpResponseInfo instead")
    public Map<String, Object> onProvideAttributes(Request request, Response response, Throwable throwable) {
        Intrinsics.checkNotNullParameter(request, "request");
        return MapsKt.emptyMap();
    }

    @Override // com.datadog.android.rum.RumResourceAttributesProvider
    public Map<String, Object> onProvideAttributes(HttpRequestInfo request, HttpResponseInfo response, Throwable throwable) {
        Intrinsics.checkNotNullParameter(request, "request");
        return MapsKt.emptyMap();
    }
}
