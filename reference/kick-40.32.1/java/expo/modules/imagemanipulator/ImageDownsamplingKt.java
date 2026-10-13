package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ImageDownsampling.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"boundedSize", "Lkotlin/Pair;", "", ViewProps.WIDTH, ViewProps.HEIGHT, ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "(IILjava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "downscaleIfExceedsBounds", "Landroid/graphics/Bitmap;", "bitmap", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/graphics/Bitmap;", "expo-image-manipulator_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageDownsamplingKt {
    public static final Pair<Integer, Integer> boundedSize(int i, int i2, Integer num, Integer num2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        double dMin = (num == null || num.intValue() <= 0) ? 1.0d : Math.min(1.0d, ((double) num.intValue()) / ((double) i));
        if (num2 != null && num2.intValue() > 0) {
            dMin = Math.min(dMin, ((double) num2.intValue()) / ((double) i2));
        }
        if (dMin >= 1.0d) {
            return null;
        }
        return new Pair<>(Integer.valueOf(Math.max(1, MathKt.roundToInt(((double) i) * dMin))), Integer.valueOf(Math.max(1, MathKt.roundToInt(((double) i2) * dMin))));
    }

    public static final Bitmap downscaleIfExceedsBounds(Bitmap bitmap, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Pair<Integer, Integer> pairBoundedSize = boundedSize(bitmap.getWidth(), bitmap.getHeight(), num, num2);
        if (pairBoundedSize == null) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, pairBoundedSize.component1().intValue(), pairBoundedSize.component2().intValue(), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }
}
