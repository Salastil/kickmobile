package org.h.s;

import io.mobileshield.sdk.logger.LocalLogger;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f583a;

    public v4(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        LocalLogger.log(8, 22600L, url.getHost());
        this.f583a = url;
    }

    public final URL a() {
        return this.f583a;
    }

    public abstract void a(String str);
}
