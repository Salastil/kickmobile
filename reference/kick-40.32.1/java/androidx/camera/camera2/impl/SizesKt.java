package androidx.camera.camera2.impl;

import android.graphics.Point;
import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Sizes.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\t¨\u0006\u000b"}, d2 = {"area", "", "Landroid/util/Size;", "asLandscape", "asPortrait", "minByArea", "left", "right", "maxByArea", "Landroid/graphics/Point;", "toSize", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SizesKt {
    public static final int area(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth() * size.getHeight();
    }

    public static final Size asLandscape(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth() >= size.getHeight() ? size : new Size(size.getHeight(), size.getWidth());
    }

    public static final Size asPortrait(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth() <= size.getHeight() ? size : new Size(size.getHeight(), size.getWidth());
    }

    public static final Size minByArea(Size left, Size right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        return area(left) < area(right) ? left : right;
    }

    public static final Size maxByArea(Size left, Size right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        return area(left) > area(right) ? left : right;
    }

    public static final int area(Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return point.x * point.y;
    }

    public static final Size toSize(Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return new Size(point.x, point.y);
    }
}
