package com.useinsider.insider;

import java.math.BigDecimal;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class r1 extends v0 {
    private final e5 d;

    r1(String str, Object obj) {
        super(str, obj);
        this.d = new f4();
    }

    protected Long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis() / 1000);
    }

    protected Long b(Object obj) {
        BigDecimal bigDecimal = (BigDecimal) this.d.b(obj);
        if (bigDecimal == null) {
            return null;
        }
        return Long.valueOf(bigDecimal.longValue());
    }

    protected Long b() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, 1);
        return Long.valueOf(calendar.getTimeInMillis() / 1000);
    }
}
