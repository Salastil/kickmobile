package com.facebook.react.views.text.internal.span;

import android.graphics.Canvas;
import android.text.Layout;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimatedEffectSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/text/internal/span/AnimatedEffectSpan;", "Lcom/facebook/react/views/text/internal/span/StatefulSpan;", "onDraw", "", ViewProps.START, "", ViewProps.END, "canvas", "Landroid/graphics/Canvas;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "deltaNanos", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@UnstableReactNativeAPI
public interface AnimatedEffectSpan extends StatefulSpan {
    boolean onDraw(int start, int end, Canvas canvas, Layout layout, long deltaNanos);
}
