package com.datadog.android.api.instrumentation.network;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtendedRequestInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"tag", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "type", "Ljava/lang/Class;", "(Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;Ljava/lang/Class;)Ljava/lang/Object;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExtendedRequestInfoKt {
    public static final <T> T tag(HttpRequestInfo httpRequestInfo, Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(httpRequestInfo, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (httpRequestInfo instanceof ExtendedRequestInfo) {
            return (T) ((ExtendedRequestInfo) httpRequestInfo).tag(type);
        }
        return null;
    }
}
