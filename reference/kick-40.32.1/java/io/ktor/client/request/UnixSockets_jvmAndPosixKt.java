package io.ktor.client.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnixSockets.jvmAndPosix.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "path", "", "unixSocket", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UnixSockets_jvmAndPosixKt {
    public static final void unixSocket(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        httpRequestBuilder.setCapability(UnixSocketCapability.INSTANCE, new UnixSocketSettings(path));
    }
}
