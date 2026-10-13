package com.facebook.fresco.vito.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.fresco.vito.options.BorderOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircularBorderBitmapDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/facebook/fresco/vito/drawable/CircularBorderBitmapDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", UriUtil.LOCAL_RESOURCE_SCHEME, "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/facebook/fresco/vito/options/BorderOptions;)V", "borderPaint", "Landroid/graphics/Paint;", "radius", "", "_alpha", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "border", "getBorder", "()Lcom/facebook/fresco/vito/options/BorderOptions;", "setBorder", "(Lcom/facebook/fresco/vito/options/BorderOptions;)V", "setAlpha", "alpha", "ensureBorderPaint", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CircularBorderBitmapDrawable extends BitmapDrawable {
    private int _alpha;
    private BorderOptions borderOptions;
    private final Paint borderPaint;
    private int radius;

    public /* synthetic */ CircularBorderBitmapDrawable(Resources resources, Bitmap bitmap, BorderOptions borderOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources, bitmap, (i & 4) != 0 ? null : borderOptions);
    }

    public CircularBorderBitmapDrawable(Resources resources, Bitmap bitmap, BorderOptions borderOptions) {
        super(resources, bitmap);
        this.borderOptions = borderOptions;
        Paint paint = new Paint(1);
        this.borderPaint = paint;
        this._alpha = 255;
        paint.setStyle(Paint.Style.STROKE);
        ensureBorderPaint();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.radius == 0) {
            return;
        }
        BorderOptions borderOptions = this.borderOptions;
        if (borderOptions == null || borderOptions.padding < 0.0f || borderOptions.width < 0.0f) {
            super.draw(canvas);
            return;
        }
        float f = borderOptions.scaleDownInsideBorders ? borderOptions.width + borderOptions.padding : borderOptions.padding;
        if (f > this.radius) {
            return;
        }
        float fExactCenterX = getBounds().exactCenterX();
        float fExactCenterY = getBounds().exactCenterY();
        if (f > 0.0f) {
            int i = this.radius;
            float f2 = (i - f) / i;
            canvas.save();
            canvas.scale(f2, f2, fExactCenterX, fExactCenterY);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
        if (borderOptions.width > 0.0f) {
            canvas.drawCircle(fExactCenterX, fExactCenterY, this.radius - (borderOptions.width / 2.0f), this.borderPaint);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.radius = Math.min(bounds.width(), bounds.height()) / 2;
    }

    /* JADX INFO: renamed from: getBorder, reason: from getter */
    public final BorderOptions getBorderOptions() {
        return this.borderOptions;
    }

    public final void setBorder(BorderOptions borderOptions) {
        BorderOptions borderOptions2 = this.borderOptions;
        if (borderOptions2 == null || !Intrinsics.areEqual(borderOptions2, borderOptions)) {
            this.borderOptions = borderOptions;
            ensureBorderPaint();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        this._alpha = alpha;
        ensureBorderPaint();
    }

    private final void ensureBorderPaint() {
        BorderOptions borderOptions = this.borderOptions;
        if (borderOptions != null) {
            this.borderPaint.setStrokeWidth(borderOptions.width);
            this.borderPaint.setColor(DrawableUtils.multiplyColorAlpha(borderOptions.color, this._alpha));
        }
    }
}
