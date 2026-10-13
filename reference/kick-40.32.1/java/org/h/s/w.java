package org.h.s;

import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class w {
    public static final String a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Base64.encode$default(Base64.INSTANCE, bArr, 0, 0, 6, null);
    }
}
