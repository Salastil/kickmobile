package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LightweightDebugOverlayDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\rH\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "textPaint", "barColor", "", "debugText", "", "onBoundsChangedCallback", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "", "getOnBoundsChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnBoundsChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "setOriginColor", "color", "setDebugText", "text", "reset", "onBoundsChange", "bounds", "draw", "canvas", "Landroid/graphics/Canvas;", "truncateText", ViewProps.MAX_WIDTH, "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "Companion", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LightweightDebugOverlayDrawable extends Drawable {
    private static final int BAR_ALPHA = 180;
    private static final int BAR_HEIGHT_PX = 36;
    private static final int TEXT_PADDING_PX = 10;
    private static final int TEXT_SIZE_PX = 24;
    private int barColor;
    private String debugText;
    private Function1<? super Rect, Unit> onBoundsChangedCallback;
    private final Paint paint = new Paint(1);
    private final Paint textPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public LightweightDebugOverlayDrawable() {
        Paint paint = new Paint(1);
        this.textPaint = paint;
        this.barColor = -7829368;
        this.debugText = "";
        paint.setColor(-1);
        paint.setTextSize(24.0f);
        paint.setFakeBoldText(true);
        paint.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
    }

    public final Function1<Rect, Unit> getOnBoundsChangedCallback() {
        return this.onBoundsChangedCallback;
    }

    public final void setOnBoundsChangedCallback(Function1<? super Rect, Unit> function1) {
        this.onBoundsChangedCallback = function1;
    }

    public final void setOriginColor(int color) {
        this.barColor = color;
        invalidateSelf();
    }

    public final void setDebugText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.debugText = text;
        invalidateSelf();
    }

    public final void reset() {
        this.barColor = -7829368;
        this.debugText = "";
        this.onBoundsChangedCallback = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        Function1<? super Rect, Unit> function1 = this.onBoundsChangedCallback;
        if (function1 != null) {
            function1.invoke(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.isEmpty()) {
            return;
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(36, bounds.height() / 4);
        int i = bounds.bottom - iCoerceAtMost;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.barColor);
        this.paint.setAlpha(180);
        float f = i;
        canvas.drawRect(bounds.left, f, bounds.right, bounds.bottom, this.paint);
        if (this.debugText.length() > 0) {
            float f2 = (f + ((iCoerceAtMost + 24) / 2.0f)) - 4.0f;
            float f3 = bounds.left + 10.0f;
            int iWidth = bounds.width() - 20;
            float fMeasureText = this.textPaint.measureText(this.debugText);
            float f4 = iWidth;
            String strTruncateText = this.debugText;
            if (fMeasureText > f4) {
                strTruncateText = truncateText(strTruncateText, iWidth);
            }
            canvas.drawText(strTruncateText, f3, f2, this.textPaint);
        }
    }

    private final String truncateText(String text, int maxWidth) {
        while (text.length() > 3) {
            if (this.textPaint.measureText(text + "...") <= maxWidth) {
                break;
            }
            text = StringsKt.dropLast(text, 1);
        }
        return text + "...";
    }
}
