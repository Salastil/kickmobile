package com.datadog.android.api.instrumentation.network;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequestInfoBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004H&¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u00020\u0000\"\u0004\b\u0000\u0010\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\tH&¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004H&¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "", "addHeader", "key", "", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "addTag", ExifInterface.GPS_DIRECTION_TRUE, "type", "Ljava/lang/Class;", "tag", "(Ljava/lang/Class;Ljava/lang/Object;)Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "build", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "removeHeader", "replaceHeader", "value", "setMethod", FirebaseAnalytics.Param.METHOD, ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lcom/datadog/android/api/instrumentation/network/HttpRequestBody;", "setUrl", ImagesContract.URL, "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HttpRequestInfoBuilder {
    HttpRequestInfoBuilder addHeader(String key, String... values);

    <T> HttpRequestInfoBuilder addTag(Class<? super T> type, T tag);

    HttpRequestInfo build();

    HttpRequestInfoBuilder removeHeader(String key);

    HttpRequestInfoBuilder replaceHeader(String key, String value);

    HttpRequestInfoBuilder setMethod(String method, HttpRequestBody body);

    HttpRequestInfoBuilder setUrl(String url);

    /* JADX INFO: compiled from: HttpRequestInfoBuilder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static HttpRequestInfoBuilder replaceHeader(HttpRequestInfoBuilder httpRequestInfoBuilder, String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            httpRequestInfoBuilder.removeHeader(key);
            httpRequestInfoBuilder.addHeader(key, value);
            return httpRequestInfoBuilder;
        }

        public static /* synthetic */ HttpRequestInfoBuilder setMethod$default(HttpRequestInfoBuilder httpRequestInfoBuilder, String str, HttpRequestBody httpRequestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMethod");
            }
            if ((i & 2) != 0) {
                httpRequestBody = null;
            }
            return httpRequestInfoBuilder.setMethod(str, httpRequestBody);
        }
    }
}
