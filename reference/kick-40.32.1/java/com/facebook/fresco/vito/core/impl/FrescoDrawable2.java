package com.facebook.fresco.vito.core.impl;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FrescoDrawable2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001@B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u0019J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010;\u001a\u00020\u0019H&J\b\u0010<\u001a\u00020\u0019H&J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020?H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010'\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0012\u00105\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00104R\u0014\u00107\u001a\u0004\u0018\u000108X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006A"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "Lcom/facebook/drawee/drawable/FadeDrawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Lcom/facebook/drawee/drawable/TransformCallback;", "Lcom/facebook/drawee/drawable/TransformAwareDrawable;", "Ljava/io/Closeable;", "Lcom/facebook/drawee/components/DeferredReleaser$Releasable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "<init>", "()V", "viewportDimensions", "Landroid/graphics/Rect;", "getViewportDimensions", "()Landroid/graphics/Rect;", "setViewportDimensions", "(Landroid/graphics/Rect;)V", "visibilityCallback", "Lcom/facebook/drawee/drawable/VisibilityCallback;", "hasImage", "", "setOverlayDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "setProgressDrawable", "setProgress", "", "progress", "", "setPlaceholderDrawable", "fadeInImage", "durationMs", "", "showImageImmediately", "showProgressImmediately", "close", "setVisible", "p0", "p1", "setVisibilityCallback", "overlayDrawable", "getOverlayDrawable", "()Landroid/graphics/drawable/Drawable;", "actualImageScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "getActualImageScaleType", "()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "actualImageFocusPoint", "Landroid/graphics/PointF;", "getActualImageFocusPoint", "()Landroid/graphics/PointF;", "actualImageWidthPx", "getActualImageWidthPx", "()I", "actualImageHeightPx", "getActualImageHeightPx", "actualImageWrapper", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "getActualImageWrapper", "()Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "cancelReleaseDelayed", "cancelReleaseNextFrame", "getActualImageBounds", "outBounds", "Landroid/graphics/RectF;", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FrescoDrawable2 extends FadeDrawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, Closeable, DeferredReleaser.Releasable, FrescoDrawableInterface {
    public static final int IMAGE_DRAWABLE_INDEX = 1;
    private static final int LAYER_COUNT = 4;
    private static final int OVERLAY_DRAWABLE_INDEX = 3;
    private static final int PLACEHOLDER_DRAWABLE_INDEX = 0;
    private static final int PROGRESS_DRAWABLE_INDEX = 2;
    private Rect viewportDimensions;
    private VisibilityCallback visibilityCallback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IntRange LAYER_RANGE = RangesKt.until(0, 4);

    public abstract void cancelReleaseDelayed();

    public abstract void cancelReleaseNextFrame();

    public abstract int getActualImageHeightPx();

    public abstract int getActualImageWidthPx();

    public abstract ScaleTypeDrawable getActualImageWrapper();

    public FrescoDrawable2() {
        super(new Drawable[4], false, 1);
    }

    public final Rect getViewportDimensions() {
        return this.viewportDimensions;
    }

    public final void setViewportDimensions(Rect rect) {
        this.viewportDimensions = rect;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean hasImage() {
        return getDrawable(1) != null;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Drawable setOverlayDrawable(Drawable drawable) {
        Drawable drawable2 = setDrawable(3, drawable);
        showLayerImmediately(3);
        return drawable2;
    }

    public final Drawable setProgressDrawable(Drawable drawable) {
        return setDrawable(2, drawable);
    }

    public final void setProgress(float progress) {
        Drawable drawable = getDrawable(2);
        if (drawable == null) {
            return;
        }
        if (progress >= 0.999f) {
            INSTANCE.maybeStopAnimation(drawable);
        } else {
            INSTANCE.maybeStartAnimation(drawable);
        }
        drawable.setLevel(Math.round(progress * 10000.0f));
    }

    public final Drawable setPlaceholderDrawable(Drawable drawable) {
        return setDrawable(0, drawable);
    }

    public final void fadeInImage(int durationMs) {
        setTransitionDuration(durationMs);
        beginBatchMode();
        fadeOutLayer(0);
        fadeOutLayer(2);
        fadeInLayer(1);
        endBatchMode();
    }

    public final void showImageImmediately() {
        beginBatchMode();
        hideLayerImmediately(0);
        hideLayerImmediately(2);
        showLayerImmediately(1);
        endBatchMode();
    }

    public final void showProgressImmediately() {
        showLayerImmediately(2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        INSTANCE.maybeStopAnimation(getDrawable(0));
        IntRange intRange = LAYER_RANGE;
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            setDrawable(first, null);
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean p0, boolean p1) {
        VisibilityCallback visibilityCallback = this.visibilityCallback;
        if (visibilityCallback != null) {
            visibilityCallback.onVisibilityChange(p0);
        }
        return super.setVisible(p0, p1);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this.visibilityCallback = visibilityCallback;
    }

    public final Drawable getOverlayDrawable() {
        return getDrawable(3);
    }

    public final ScalingUtils.ScaleType getActualImageScaleType() {
        Drawable drawable = getDrawable(1);
        if (drawable instanceof ScaleTypeDrawable) {
            return ((ScaleTypeDrawable) drawable).getScaleType();
        }
        return null;
    }

    public final PointF getActualImageFocusPoint() {
        Drawable drawable = getDrawable(1);
        if (drawable instanceof ScaleTypeDrawable) {
            return ((ScaleTypeDrawable) drawable).getMFocusPoint();
        }
        return null;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void getActualImageBounds(RectF outBounds) {
        Drawable drawable;
        Rect bounds;
        Intrinsics.checkNotNullParameter(outBounds, "outBounds");
        Matrix matrix = new Matrix();
        ScaleTypeDrawable actualImageWrapper = getActualImageWrapper();
        if (actualImageWrapper != null) {
            actualImageWrapper.getTransform(matrix);
        }
        ScaleTypeDrawable actualImageWrapper2 = getActualImageWrapper();
        if (actualImageWrapper2 == null || (drawable = actualImageWrapper2.getDrawable()) == null || (bounds = drawable.getBounds()) == null) {
            return;
        }
        outBounds.set(bounds);
        matrix.mapRect(outBounds);
    }

    /* JADX INFO: compiled from: FrescoDrawable2.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2$Companion;", "", "<init>", "()V", "IMAGE_DRAWABLE_INDEX", "", "LAYER_COUNT", "PLACEHOLDER_DRAWABLE_INDEX", "PROGRESS_DRAWABLE_INDEX", "OVERLAY_DRAWABLE_INDEX", "LAYER_RANGE", "Lkotlin/ranges/IntRange;", "maybeStopAnimation", "", "drawable", "Landroid/graphics/drawable/Drawable;", "maybeStartAnimation", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void maybeStopAnimation(Drawable drawable) {
            Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
            if (animatable != null) {
                animatable.stop();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void maybeStartAnimation(Drawable drawable) {
            Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
            if (animatable != null) {
                animatable.start();
            }
        }
    }
}
