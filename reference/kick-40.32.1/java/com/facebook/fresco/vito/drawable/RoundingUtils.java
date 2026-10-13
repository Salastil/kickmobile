package com.facebook.fresco.vito.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundingUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J+\u0010\u0011\u001a\u0002H\u0012\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0014J5\u0010\u0015\u001a\u00020\u0005\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u0002H\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0016J+\u0010\u0017\u001a\u00020\u0005\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u0002H\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0018J-\u0010\u0011\u001a\u0002H\u0012\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\u0005\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u0002H\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0018J7\u0010\u001b\u001a\u00020\u0005\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u0002H\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0016J+\u0010\u001c\u001a\u00020\u001d\"\f\b\u0000\u0010\u0012*\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u0002H\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/vito/drawable/RoundingUtils;", "", "<init>", "()V", "roundedDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "drawable", "roundedDrawableWithoutBorder", "roundedDrawableWithBorder", "getRoundedDrawable", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/drawee/drawable/Rounded;", "(Landroid/content/res/Resources;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "applyRounding", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/fresco/vito/options/BorderOptions;Lcom/facebook/fresco/vito/options/RoundingOptions;)Landroid/graphics/drawable/Drawable;", "squareDrawableWithBorder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/fresco/vito/options/BorderOptions;)Landroid/graphics/drawable/Drawable;", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;", "circularDrawable", "roundedCornerDrawable", "applyBorders", "", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/fresco/vito/options/BorderOptions;)V", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoundingUtils {
    public static final RoundingUtils INSTANCE = new RoundingUtils();

    private RoundingUtils() {
    }

    public final Drawable roundedDrawable(Resources resources, Bitmap bitmap, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (borderOptions != null && borderOptions.width > 0.0f) {
            return roundedDrawableWithBorder(resources, bitmap, borderOptions, roundingOptions);
        }
        return roundedDrawableWithoutBorder(resources, bitmap, roundingOptions);
    }

    public final Drawable roundedDrawable(Resources resources, Drawable drawable, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (borderOptions != null && borderOptions.width > 0.0f) {
            return roundedDrawableWithBorder(resources, drawable, borderOptions, roundingOptions);
        }
        return roundedDrawableWithoutBorder(resources, drawable, roundingOptions);
    }

    private final Drawable roundedDrawableWithoutBorder(Resources resources, Bitmap bitmap, RoundingOptions roundingOptions) {
        if (roundingOptions == null) {
            return new BitmapDrawable(resources, bitmap);
        }
        return applyRounding(getRoundedDrawable(resources, bitmap), null, roundingOptions);
    }

    private final Drawable roundedDrawableWithBorder(Resources resources, Bitmap bitmap, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        if (roundingOptions == null) {
            return squareDrawableWithBorder(getRoundedDrawable(resources, bitmap), borderOptions);
        }
        return applyRounding(getRoundedDrawable(resources, bitmap), borderOptions, roundingOptions);
    }

    private final Drawable roundedDrawableWithoutBorder(Resources resources, Drawable drawable, RoundingOptions roundingOptions) {
        return roundingOptions != null ? applyRounding(getRoundedDrawable(resources, drawable), null, roundingOptions) : drawable;
    }

    private final Drawable roundedDrawableWithBorder(Resources resources, Drawable drawable, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        if (roundingOptions == null) {
            return squareDrawableWithBorder(getRoundedDrawable(resources, drawable), borderOptions);
        }
        return applyRounding(getRoundedDrawable(resources, drawable), borderOptions, roundingOptions);
    }

    private final <T extends Drawable & Rounded> T getRoundedDrawable(Resources resources, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return (T) getRoundedDrawable(resources, ((BitmapDrawable) drawable).getBitmap());
        }
        if (drawable instanceof NinePatchDrawable) {
            return new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
        }
        if (!(drawable instanceof ColorDrawable)) {
            return new RoundedCornersDrawable(drawable);
        }
        RoundedColorDrawable roundedColorDrawableFromColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
        Intrinsics.checkNotNull(roundedColorDrawableFromColorDrawable, "null cannot be cast to non-null type T of com.facebook.fresco.vito.drawable.RoundingUtils.getRoundedDrawable");
        return roundedColorDrawableFromColorDrawable;
    }

    private final <T extends Drawable & Rounded> Drawable applyRounding(T drawable, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        if (!roundingOptions.isCircular()) {
            return roundedCornerDrawable(drawable, borderOptions, roundingOptions);
        }
        return circularDrawable(drawable, borderOptions);
    }

    private final <T extends Drawable & Rounded> Drawable squareDrawableWithBorder(T drawable, BorderOptions borderOptions) {
        return roundedCornerDrawable(drawable, borderOptions, null);
    }

    private final <T extends Drawable & Rounded> T getRoundedDrawable(Resources resources, Bitmap bitmap) {
        return new RoundedBitmapDrawable(resources, bitmap);
    }

    private final <T extends Drawable & Rounded> Drawable circularDrawable(T drawable, BorderOptions borderOptions) {
        drawable.setCircle(true);
        if (borderOptions != null) {
            applyBorders(drawable, borderOptions);
        }
        return drawable;
    }

    private final <T extends Drawable & Rounded> Drawable roundedCornerDrawable(T drawable, BorderOptions borderOptions, RoundingOptions roundingOptions) {
        if (borderOptions != null) {
            applyBorders(drawable, borderOptions);
        }
        if (roundingOptions != null) {
            float[] cornerRadii = roundingOptions.getCornerRadii();
            if (cornerRadii != null) {
                drawable.setRadii(cornerRadii);
                return drawable;
            }
            drawable.setRadius(roundingOptions.getCornerRadius());
        }
        return drawable;
    }

    private final <T extends Drawable & Rounded> void applyBorders(T drawable, BorderOptions borderOptions) {
        T t = drawable;
        t.setBorder(borderOptions.color, borderOptions.width);
        t.setPadding(borderOptions.padding);
    }
}
