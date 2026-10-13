package com.facebook.fresco.urimod;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Dimensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"asDimensions", "Lcom/facebook/fresco/urimod/Dimensions;", "Landroid/graphics/Rect;", "urimod_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DimensionsKt {
    public static final Dimensions asDimensions(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new Dimensions(rect.width(), rect.height());
    }
}
