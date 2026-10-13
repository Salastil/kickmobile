package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/w;", "", "<init>", "()V", "", "", "", "component9", "Ljava/util/Map;", "D8871", "()Ljava/util/Map;", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class w {
    private static int D8871 = 0;
    private static int component5 = 0;
    private static int sG29839 = 1;
    private static int vD14832N6715 = 1;
    public static final w INSTANCE = new w();

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    private static final Map<String, Long> vD14832N6715 = new ConcurrentHashMap();

    private w() {
    }

    static {
        int i = sG29839;
        int i2 = (i ^ 123) + ((i & 123) << 1);
        component5 = i2 % 128;
        int i3 = i2 % 2;
    }

    public final Map<String, Long> D8871() {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = ((i2 | 51) << 1) - (i2 ^ 51);
        D8871 = i3 % 128;
        if (i3 % 2 == 0) {
            return vD14832N6715;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
