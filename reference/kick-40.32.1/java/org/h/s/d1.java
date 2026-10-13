package org.h.s;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class d1 extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.ENGLISH);
    }
}
