package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.config.Protocol;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeUnit f532a = TimeUnit.MILLISECONDS;
    public static final long b;

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        b = 79200000L;
    }

    public static long a(u uVar) {
        m mVar;
        Long l;
        if (uVar == null || (mVar = uVar.c) == null || (l = mVar.h) == null) {
            return b;
        }
        long jLongValue = l.longValue();
        return jLongValue >= 0 ? jLongValue : b;
    }

    public static long a(m clientToken) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        return clientToken.d - Calendar.getInstance().getTimeInMillis();
    }

    public static String a(String domain, Config[] localConfig) {
        String str;
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(localConfig, "localConfig");
        for (Config config : ArraysKt.toList(localConfig)) {
            if (StringsKt.equals(config.getDomain(), domain, true)) {
                String formattedProtocol = config.getFormattedProtocol();
                if (config.getPort() > 0) {
                    str = ServerSentEventKt.COLON + config.getPort();
                } else {
                    str = "";
                }
                return formattedProtocol + domain + str;
            }
        }
        return Protocol.HTTPS.formatted() + domain;
    }
}
