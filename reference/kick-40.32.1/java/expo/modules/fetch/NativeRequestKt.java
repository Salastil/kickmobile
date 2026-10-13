package expo.modules.fetch;

import com.datadog.android.internal.network.HttpSpec;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: NativeRequest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"METHODS_REQUIRING_BODY", "", "", "getMETHODS_REQUIRING_BODY", "()[Ljava/lang/String;", "[Ljava/lang/String;", "buildRequestBody", "Lokhttp3/RequestBody;", FirebaseAnalytics.Param.METHOD, "requestBody", "", "mediaType", "Lokhttp3/MediaType;", "expo_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NativeRequestKt {
    private static final String[] METHODS_REQUIRING_BODY = {"POST", HttpSpec.Method.PUT, HttpSpec.Method.PATCH};

    public static final String[] getMETHODS_REQUIRING_BODY() {
        return METHODS_REQUIRING_BODY;
    }

    public static final RequestBody buildRequestBody(String method, byte[] bArr, MediaType mediaType) {
        MediaType mediaType2;
        Intrinsics.checkNotNullParameter(method, "method");
        if (bArr != null) {
            RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, bArr, mediaType, 0, 0, 6, (Object) null);
            mediaType2 = mediaType;
            if (requestBodyCreate$default != null) {
                return requestBodyCreate$default;
            }
        } else {
            mediaType2 = mediaType;
        }
        if (ArraysKt.contains(METHODS_REQUIRING_BODY, method)) {
            return RequestBody.Companion.create$default(RequestBody.INSTANCE, new byte[0], mediaType2, 0, 0, 6, (Object) null);
        }
        return null;
    }
}
