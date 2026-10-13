package org.h.s;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes11.dex */
public abstract class j {
    public abstract String a();

    public final int b() {
        if (((q4) this).f == 0) {
            return 0;
        }
        byte[] bytes = a().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes.length;
    }
}
