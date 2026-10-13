package io.mobileshield.sdk.config;

import com.datadog.android.internal.network.HttpSpec;
import com.facebook.infer.annotation.ThreadConfined;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/mobileshield/sdk/config/Method;", "", "(Ljava/lang/String;I)V", "POST", "GET", HttpSpec.Method.PATCH, HttpSpec.Method.HEAD, HttpSpec.Method.PUT, HttpSpec.Method.DELETE, HttpSpec.Method.CONNECT, HttpSpec.Method.OPTIONS, HttpSpec.Method.TRACE, ThreadConfined.ANY, "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum Method {
    POST,
    GET,
    PATCH,
    HEAD,
    PUT,
    DELETE,
    CONNECT,
    OPTIONS,
    TRACE,
    ANY;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<Method> getEntries() {
        return $ENTRIES;
    }
}
