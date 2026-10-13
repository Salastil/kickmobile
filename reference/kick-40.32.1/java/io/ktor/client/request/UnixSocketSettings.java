package io.ktor.client.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnixSockets.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/request/UnixSocketSettings;", "", "", "path", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnixSocketSettings {
    private final String path;

    public UnixSocketSettings(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }
}
