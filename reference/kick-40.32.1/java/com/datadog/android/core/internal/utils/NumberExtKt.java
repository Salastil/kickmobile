package com.datadog.android.core.internal.utils;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NumberExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toByteArray", "", "", "", "", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NumberExtKt {
    public static final byte[] toByteArray(short s) {
        byte[] bArrArray = ByteBuffer.allocate(2).putShort(s).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(Short.SIZE_BYTES).putShort(this).array()");
        return bArrArray;
    }

    public static final byte[] toByteArray(int i) {
        byte[] bArrArray = ByteBuffer.allocate(4).putInt(i).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(Int.SIZE_BYTES).putInt(this).array()");
        return bArrArray;
    }

    public static final byte[] toByteArray(long j) {
        byte[] bArrArray = ByteBuffer.allocate(8).putLong(j).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(Long.SIZE_BYTES).putLong(this).array()");
        return bArrArray;
    }
}
