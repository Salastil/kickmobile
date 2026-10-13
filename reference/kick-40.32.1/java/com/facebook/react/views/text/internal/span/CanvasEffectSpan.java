package com.facebook.react.views.text.internal.span;

import android.graphics.Canvas;
import android.text.Layout;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CanvasEffectSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/text/internal/span/CanvasEffectSpan;", "Lcom/facebook/react/views/text/internal/span/TextEffectSpan;", "<init>", "()V", "onPreDraw", "", ViewProps.START, "", ViewProps.END, "canvas", "Landroid/graphics/Canvas;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "onDraw", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CanvasEffectSpan implements TextEffectSpan {
    public void onDraw(int start, int end, Canvas canvas, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
    }

    public void onPreDraw(int start, int end, Canvas canvas, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
    }
}
