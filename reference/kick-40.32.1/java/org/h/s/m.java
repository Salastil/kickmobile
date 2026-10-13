package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537a;
    public final String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public transient Long h;

    public m() {
        this.f = -1L;
        this.f537a = "";
        this.b = "";
        a("");
    }

    public final void a() {
        long j = this.f;
        if (j == -1) {
            return;
        }
        this.e = this.g - j;
    }

    public final String toString() {
        return "ClientToken{header='" + this.f537a + "', status='" + this.b + "', ctoken='" + this.c + "', expiryTimestampInMilliseconds=" + this.d + ", delta=" + this.e + ", serverTimeInMillis=" + this.f + "}";
    }

    public final void a(String str) {
        String strReplace = "";
        if (str != null) {
            try {
                if (str.length() != 0) {
                    strReplace = new Regex("\\+").replace(str, "%2b");
                }
            } catch (UnsupportedEncodingException e) {
                LocalLogger.log(2, 22900L, e.getMessage());
                return;
            }
        }
        this.c = URLDecoder.decode(strReplace, "UTF-8");
    }

    public m(String kpsdkMessage) {
        Intrinsics.checkNotNullParameter(kpsdkMessage, "kpsdkMessage");
        this.f = -1L;
        this.g = System.currentTimeMillis();
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) kpsdkMessage, new String[]{ServerSentEventKt.COLON}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (strArr.length > 2) {
            this.f537a = strArr[0];
            this.b = strArr[1];
            a(strArr[2]);
        }
        if (strArr.length >= 4) {
            this.f = Long.parseLong(strArr[6]);
            a();
        }
        this.h = o0.a((String) ArraysKt.getOrNull(strArr, 7), this.c);
    }
}
