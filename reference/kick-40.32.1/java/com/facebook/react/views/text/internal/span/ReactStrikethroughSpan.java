package com.facebook.react.views.text.internal.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.TextDecorationStyle;
import com.facebook.react.views.text.TextDecorationStyleKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactStrikethroughSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/views/text/internal/span/ReactStrikethroughSpan;", "Lcom/facebook/react/views/text/internal/span/CanvasEffectSpan;", "Lcom/facebook/react/views/text/internal/span/ReactSpan;", "color", "", "style", "Lcom/facebook/react/views/text/TextDecorationStyle;", "<init>", "(ILcom/facebook/react/views/text/TextDecorationStyle;)V", "onDraw", "", ViewProps.START, ViewProps.END, "canvas", "Landroid/graphics/Canvas;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactStrikethroughSpan extends CanvasEffectSpan implements ReactSpan {
    private final int color;
    private final TextDecorationStyle style;

    /* JADX WARN: Multi-variable type inference failed */
    public ReactStrikethroughSpan() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ReactStrikethroughSpan(int i, TextDecorationStyle textDecorationStyle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? TextDecorationStyle.SOLID : textDecorationStyle);
    }

    public ReactStrikethroughSpan(int i, TextDecorationStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.color = i;
        this.style = style;
    }

    @Override // com.facebook.react.views.text.internal.span.CanvasEffectSpan
    public void onDraw(int start, int end, Canvas canvas, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        TextDecorationStyleKt.drawSpannedDecoration(start, end, canvas, layout, this.color, this.style, new Function3() { // from class: com.facebook.react.views.text.internal.span.ReactStrikethroughSpan$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Float.valueOf(ReactStrikethroughSpan.onDraw$lambda$0((Paint) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
            }
        });
    }

    static final float onDraw$lambda$0(Paint paint, float f, float f2) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return f + ((fontMetrics.ascent + fontMetrics.descent) / 2.0f) + 1.0f;
    }
}
