package com.facebook.react.fabric.mounting;

import androidx.collection.SparseArrayCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurfaceMountingManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\u0002\u001a.\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u0002H\u0002H\u0082\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"contains", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/SparseArrayCompat;", "key", "", "set", "", "value", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SurfaceMountingManagerKt {
    private static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i, t);
    }
}
