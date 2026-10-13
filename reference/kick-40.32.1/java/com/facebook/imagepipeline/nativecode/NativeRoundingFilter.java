package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeRoundingFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J0\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J\u0019\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J)\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J1\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 ¨\u0006\u0018"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/NativeRoundingFilter;", "", "<init>", "()V", "toCircle", "", "bitmap", "Landroid/graphics/Bitmap;", "toCircleFast", "addRoundedCorners", "radiusTopLeft", "", "radiusTopRight", "radiusBottomRight", "radiusBottomLeft", "antiAliased", "", "toCircleWithBorder", "colorARGB", "borderWidthPx", "nativeToCircleFilter", "nativeToCircleFastFilter", "nativeToCircleWithBorderFilter", "nativeAddRoundedCornersFilter", "native-filters_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NativeRoundingFilter {
    public static final NativeRoundingFilter INSTANCE = new NativeRoundingFilter();

    @JvmStatic
    private static final native void nativeAddRoundedCornersFilter(Bitmap bitmap, int radiusTopLeft, int radiusTopRight, int radiusBottomRight, int radiusBottomLeft);

    @JvmStatic
    private static final native void nativeToCircleFastFilter(Bitmap bitmap, boolean antiAliased);

    @JvmStatic
    private static final native void nativeToCircleFilter(Bitmap bitmap, boolean antiAliased);

    @JvmStatic
    private static final native void nativeToCircleWithBorderFilter(Bitmap bitmap, int colorARGB, int borderWidthPx, boolean antiAliased);

    private NativeRoundingFilter() {
    }

    static {
        NativeFiltersLoader.load();
    }

    @JvmStatic
    public static final void toCircle(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        toCircle(bitmap, false);
    }

    @JvmStatic
    public static final void toCircleFast(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        toCircleFast(bitmap, false);
    }

    @JvmStatic
    public static final void addRoundedCorners(Bitmap bitmap, int radiusTopLeft, int radiusTopRight, int radiusBottomRight, int radiusBottomLeft) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        nativeAddRoundedCornersFilter(bitmap, radiusTopLeft, radiusTopRight, radiusBottomRight, radiusBottomLeft);
    }

    @JvmStatic
    public static final void toCircle(Bitmap bitmap, boolean antiAliased) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, antiAliased);
    }

    @JvmStatic
    public static final void toCircleFast(Bitmap bitmap, boolean antiAliased) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, antiAliased);
    }

    @JvmStatic
    public static final void toCircleWithBorder(Bitmap bitmap, int colorARGB, int borderWidthPx, boolean antiAliased) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleWithBorderFilter(bitmap, colorARGB, borderWidthPx, antiAliased);
    }
}
