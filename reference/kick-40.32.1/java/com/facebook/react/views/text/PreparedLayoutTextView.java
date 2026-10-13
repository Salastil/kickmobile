package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.reflection.WindowExtensionsConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.internal.span.AnimatedEffectSpan;
import com.facebook.react.views.text.internal.span.CanvasEffectSpan;
import com.facebook.react.views.text.internal.span.ReactFragmentIndexSpan;
import com.facebook.react.views.text.internal.span.ReactLinkSpan;
import com.facebook.react.views.text.internal.span.TouchableSpan;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PreparedLayoutTextView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0001\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0003UVWB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001cH\u0014J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0014J0\u0010/\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001cH\u0014J\u0016\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cJ\u0006\u00109\u001a\u00020'J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J3\u0010?\u001a\u0004\u0018\u0001H@\"\u0004\b\u0000\u0010@2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001c2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H@0DH\u0002¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001cH\u0002J\b\u0010G\u001a\u000201H\u0016J\u0010\u0010H\u001a\u0002012\u0006\u0010;\u001a\u00020<H\u0016J\"\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020\u001c2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u0002012\u0006\u0010;\u001a\u00020OH\u0016J\b\u0010P\u001a\u000201H\u0016J\u0018\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010#8G¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006X"}, d2 = {"Lcom/facebook/react/views/text/PreparedLayoutTextView;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/uimanager/ReactCompoundView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "clickableSpans", "", "Landroid/text/style/ClickableSpan;", "selection", "Lcom/facebook/react/views/text/PreparedLayoutTextView$TextSelection;", "lastFrameTimeNanos", "", "value", "Lcom/facebook/react/views/text/PreparedLayout;", "preparedLayout", "getPreparedLayout", "()Lcom/facebook/react/views/text/PreparedLayout;", "setPreparedLayout", "(Lcom/facebook/react/views/text/PreparedLayout;)V", "Lcom/facebook/react/uimanager/style/Overflow;", ViewProps.OVERFLOW, "getOverflow", "()Lcom/facebook/react/uimanager/style/Overflow;", "setOverflow", "(Lcom/facebook/react/uimanager/style/Overflow;)V", "selectionColor", "", "getSelectionColor", "()Ljava/lang/Integer;", "setSelectionColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "text", "", "getText", "()Ljava/lang/CharSequence;", "recycleView", "", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "setSelection", ViewProps.START, ViewProps.END, "clearSelection", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "findRootView", "Lcom/facebook/react/uimanager/RootView;", "getSpanInCoords", ExifInterface.GPS_DIRECTION_TRUE, ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "clazz", "Ljava/lang/Class;", "(IILjava/lang/Class;)Ljava/lang/Object;", "getTextOffsetAt", "shouldDelayChildPressedState", "dispatchHoverEvent", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "hasOverlappingRendering", "reactTagForTouch", "touchX", "", "touchY", "Api34Utils", "TextSelection", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreparedLayoutTextView extends ViewGroup implements ReactCompoundView {
    private static final Companion Companion = new Companion(null);
    private static final Paint selectionPaint = new Paint();
    private List<? extends ClickableSpan> clickableSpans;
    private long lastFrameTimeNanos;
    private Overflow overflow;
    private PreparedLayout preparedLayout;
    private TextSelection selection;
    private Integer selectionColor;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreparedLayoutTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.clickableSpans = CollectionsKt.emptyList();
        this.overflow = Overflow.VISIBLE;
        setWillNotDraw(false);
    }

    public final PreparedLayout getPreparedLayout() {
        return this.preparedLayout;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    public final void setPreparedLayout(PreparedLayout preparedLayout) {
        List<? extends ClickableSpan> listEmptyList;
        Layout layout;
        CharSequence text;
        Layout layout2;
        if (Intrinsics.areEqual(this.preparedLayout, preparedLayout)) {
            return;
        }
        CharSequence text2 = null;
        PreparedLayout preparedLayoutMaybeProxyStatefulSpans = preparedLayout != null ? Companion.maybeProxyStatefulSpans(preparedLayout) : null;
        TextSelection textSelection = this.selection;
        if (textSelection != null) {
            if (preparedLayoutMaybeProxyStatefulSpans != null) {
                PreparedLayout preparedLayout2 = this.preparedLayout;
                if (preparedLayout2 != null && (layout2 = preparedLayout2.getLayout()) != null) {
                    text2 = layout2.getText();
                }
                if (Intrinsics.areEqual(String.valueOf(text2), preparedLayoutMaybeProxyStatefulSpans.getLayout().getText().toString())) {
                    preparedLayoutMaybeProxyStatefulSpans.getLayout().getSelectionPath(textSelection.getStart(), textSelection.getEnd(), textSelection.getPath());
                } else {
                    clearSelection();
                }
            } else {
                clearSelection();
            }
        }
        if (preparedLayoutMaybeProxyStatefulSpans == null || (layout = preparedLayoutMaybeProxyStatefulSpans.getLayout()) == null || (text = layout.getText()) == null || (listEmptyList = Companion.filterClickableSpans(text)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.clickableSpans = listEmptyList;
        this.preparedLayout = preparedLayoutMaybeProxyStatefulSpans;
        invalidate();
    }

    public final Overflow getOverflow() {
        return this.overflow;
    }

    public final void setOverflow(Overflow value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.overflow != value) {
            this.overflow = value;
            invalidate();
        }
    }

    public final Integer getSelectionColor() {
        return this.selectionColor;
    }

    public final void setSelectionColor(Integer num) {
        this.selectionColor = num;
    }

    public final CharSequence getText() {
        Layout layout;
        PreparedLayout preparedLayout = this.preparedLayout;
        if (preparedLayout == null || (layout = preparedLayout.getLayout()) == null) {
            return null;
        }
        return layout.getText();
    }

    public final void recycleView() {
        BackgroundStyleApplicator.reset(this);
        setOverflow(Overflow.VISIBLE);
        this.clickableSpans = CollectionsKt.emptyList();
        this.selection = null;
        this.selectionColor = null;
        this.lastFrameTimeNanos = 0L;
        setPreparedLayout(null);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            this.lastFrameTimeNanos = 0L;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        CanvasEffectSpan[] canvasEffectSpanArr;
        int defaultTextColorHighlight;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.onDraw(canvas);
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        PreparedLayout preparedLayout = this.preparedLayout;
        canvas.translate(paddingLeft, paddingTop + (preparedLayout != null ? preparedLayout.getVerticalOffset() : 0.0f));
        PreparedLayout preparedLayout2 = this.preparedLayout;
        Layout layout = preparedLayout2 != null ? preparedLayout2.getLayout() : null;
        if (layout != null) {
            if (this.selection != null) {
                Paint paint = selectionPaint;
                Integer num = this.selectionColor;
                if (num != null) {
                    defaultTextColorHighlight = num.intValue();
                } else {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    defaultTextColorHighlight = DefaultStyleValuesUtil.getDefaultTextColorHighlight(context);
                }
                paint.setColor(defaultTextColorHighlight);
            }
            CharSequence text = getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned == null || (canvasEffectSpanArr = (CanvasEffectSpan[]) spanned.getSpans(0, spanned.length(), CanvasEffectSpan.class)) == null) {
                canvasEffectSpanArr = new CanvasEffectSpan[0];
            }
            if (spanned != null) {
                for (CanvasEffectSpan canvasEffectSpan : canvasEffectSpanArr) {
                    canvasEffectSpan.onPreDraw(spanned.getSpanStart(canvasEffectSpan), spanned.getSpanEnd(canvasEffectSpan), canvas, layout);
                }
            }
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Utils api34Utils = Api34Utils.INSTANCE;
                TextSelection textSelection = this.selection;
                api34Utils.draw(layout, canvas, textSelection != null ? textSelection.getPath() : null, selectionPaint);
            } else {
                TextSelection textSelection2 = this.selection;
                layout.draw(canvas, textSelection2 != null ? textSelection2.getPath() : null, selectionPaint, 0);
            }
            if (spanned != null) {
                for (CanvasEffectSpan canvasEffectSpan2 : canvasEffectSpanArr) {
                    canvasEffectSpan2.onDraw(spanned.getSpanStart(canvasEffectSpan2), spanned.getSpanEnd(canvasEffectSpan2), canvas, layout);
                }
            }
            if (spanned != null) {
                AnimatedEffectSpan[] animatedEffectSpanArr = (AnimatedEffectSpan[]) spanned.getSpans(0, spanned.length(), AnimatedEffectSpan.class);
                Intrinsics.checkNotNull(animatedEffectSpanArr);
                if (animatedEffectSpanArr.length == 0) {
                    return;
                }
                long jNanoTime = System.nanoTime();
                long j = this.lastFrameTimeNanos;
                long j2 = j == 0 ? 0L : jNanoTime - j;
                this.lastFrameTimeNanos = jNanoTime;
                Iterator it = ArrayIteratorKt.iterator(animatedEffectSpanArr);
                boolean z = false;
                while (it.hasNext()) {
                    AnimatedEffectSpan animatedEffectSpan = (AnimatedEffectSpan) it.next();
                    canvas = canvas;
                    if (animatedEffectSpan.onDraw(spanned.getSpanStart(animatedEffectSpan), spanned.getSpanEnd(animatedEffectSpan), canvas, layout, j2)) {
                        z = true;
                    }
                }
                if (z) {
                    postInvalidateOnAnimation();
                } else {
                    this.lastFrameTimeNanos = 0L;
                }
            }
        }
    }

    public final void setSelection(int start, int end) {
        PreparedLayout preparedLayout = this.preparedLayout;
        if (preparedLayout == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Layout layout = preparedLayout.getLayout();
        if (start < 0 || end > layout.getText().length() || start >= end) {
            throw new IllegalArgumentException("setSelection start and end are not in valid range. start: " + start + ", end: " + end + ", text length: " + layout.getText().length());
        }
        TextSelection textSelection = this.selection;
        if (textSelection == null) {
            Path path = new Path();
            layout.getSelectionPath(start, end, path);
            this.selection = new TextSelection(start, end, path);
        } else {
            textSelection.setStart(start);
            textSelection.setEnd(end);
            layout.getSelectionPath(start, end, textSelection.getPath());
        }
        invalidate();
    }

    public final void clearSelection() {
        this.selection = null;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        RootView rootViewFindRootView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return super.onTouchEvent(event);
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 3) {
            CharSequence text = getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            TouchableSpan[] touchableSpanArr = spanned != null ? (TouchableSpan[]) spanned.getSpans(0, spanned.length(), TouchableSpan.class) : null;
            if (touchableSpanArr == null) {
                touchableSpanArr = new TouchableSpan[0];
            }
            for (TouchableSpan touchableSpan : touchableSpanArr) {
                touchableSpan.onTouchEvent(actionMasked, 0.0f, 0.0f);
            }
            clearSelection();
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        TouchableSpan touchableSpan2 = (TouchableSpan) getSpanInCoords(x, y, TouchableSpan.class);
        if (touchableSpan2 != null) {
            float x2 = event.getX() - getPaddingLeft();
            float y2 = event.getY() - getPaddingTop();
            PreparedLayout preparedLayout = this.preparedLayout;
            if (touchableSpan2.onTouchEvent(actionMasked, x2, y2 - (preparedLayout != null ? preparedLayout.getVerticalOffset() : 0.0f))) {
                if (actionMasked == 0 && (rootViewFindRootView = findRootView()) != null) {
                    rootViewFindRootView.onChildStartedNativeGesture(this, event);
                }
                invalidate();
                return true;
            }
        }
        if (this.clickableSpans.isEmpty()) {
            return super.onTouchEvent(event);
        }
        ClickableSpan clickableSpan = (ClickableSpan) getSpanInCoords(x, y, ClickableSpan.class);
        if (clickableSpan == null) {
            clearSelection();
            return super.onTouchEvent(event);
        }
        if (actionMasked == 1) {
            clearSelection();
            if (!(clickableSpan instanceof ReactLinkSpan)) {
                clickableSpan.onClick(this);
            }
        }
        return true;
    }

    private final RootView findRootView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RootView) {
                return (RootView) parent;
            }
        }
        return null;
    }

    private final <T> T getSpanInCoords(int x, int y, Class<T> clazz) {
        int spanStart;
        int spanEnd;
        int textOffsetAt = getTextOffsetAt(x, y);
        if (textOffsetAt < 0) {
            return null;
        }
        CharSequence text = getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return null;
        }
        Object[] spans = spanned.getSpans(textOffsetAt, textOffsetAt, clazz);
        Intrinsics.checkNotNull(spans);
        if (spans.length == 0) {
            return null;
        }
        if (spans.length > 2) {
            throw new IllegalStateException("Check failed.");
        }
        Iterator it = ArrayIteratorKt.iterator(spans);
        while (it.hasNext()) {
            T t = (T) it.next();
            int spanFlags = spanned.getSpanFlags(t);
            int i = spanFlags & 18;
            if (i != 0 || (spanFlags & 17) != 0) {
                spanStart = spanned.getSpanStart(t);
            } else {
                spanStart = spanned.getSpanStart(t) + 1;
            }
            if (i != 0 || (spanFlags & 34) != 0) {
                spanEnd = spanned.getSpanEnd(t);
            } else {
                spanEnd = spanned.getSpanEnd(t) - 1;
            }
            if (textOffsetAt >= spanStart && textOffsetAt <= spanEnd) {
                return t;
            }
        }
        return null;
    }

    private final int getTextOffsetAt(int x, int y) {
        Layout layout;
        float paragraphLeft;
        float paragraphRight;
        int paddingLeft = x - getPaddingLeft();
        int paddingTop = getPaddingTop();
        PreparedLayout preparedLayout = this.preparedLayout;
        int iRoundToInt = y - (paddingTop + (preparedLayout != null ? MathKt.roundToInt(preparedLayout.getVerticalOffset()) : 0));
        PreparedLayout preparedLayout2 = this.preparedLayout;
        if (preparedLayout2 != null && (layout = preparedLayout2.getLayout()) != null) {
            int lineForVertical = layout.getLineForVertical(iRoundToInt);
            if (layout.getAlignment() == Layout.Alignment.ALIGN_CENTER) {
                paragraphLeft = layout.getLineLeft(lineForVertical);
                paragraphRight = layout.getLineRight(lineForVertical);
            } else {
                boolean z = layout.getParagraphDirection(lineForVertical) == -1;
                if (z) {
                    paragraphLeft = layout.getWidth() - layout.getLineMax(lineForVertical);
                } else {
                    paragraphLeft = layout.getParagraphLeft(lineForVertical);
                }
                paragraphRight = z ? layout.getParagraphRight(lineForVertical) : layout.getLineMax(lineForVertical);
            }
            float f = paddingLeft;
            if (f >= paragraphLeft && f <= paragraphRight) {
                try {
                    return layout.getOffsetForHorizontal(lineForVertical, f);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        if (!this.clickableSpans.isEmpty() && !gainFocus) {
            clearSelection();
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
        if (accessibilityDelegate == null || !(accessibilityDelegate instanceof ReactTextViewAccessibilityDelegate)) {
            return;
        }
        ((ReactTextViewAccessibilityDelegate) accessibilityDelegate).onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
        return ((accessibilityDelegate instanceof ReactTextViewAccessibilityDelegate) && ((ReactTextViewAccessibilityDelegate) accessibilityDelegate).dispatchKeyEvent(event)) || super.dispatchKeyEvent(event);
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float touchX, float touchY) {
        ReactFragmentIndexSpan reactFragmentIndexSpan = (ReactFragmentIndexSpan) getSpanInCoords(MathKt.roundToInt(touchX), MathKt.roundToInt(touchY), ReactFragmentIndexSpan.class);
        if (reactFragmentIndexSpan != null) {
            int fragmentIndex = reactFragmentIndexSpan.getFragmentIndex();
            PreparedLayout preparedLayout = this.preparedLayout;
            Integer numValueOf = preparedLayout != null ? Integer.valueOf(preparedLayout.getReactTags()[fragmentIndex]) : null;
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        return getId();
    }

    /* JADX INFO: compiled from: PreparedLayoutTextView.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/views/text/PreparedLayoutTextView$Api34Utils;", "", "<init>", "()V", "highlightPaths", "", "Landroid/graphics/Path;", "highlightPaints", "Landroid/graphics/Paint;", "draw", "", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "canvas", "Landroid/graphics/Canvas;", "selectionPath", "selectionPaint", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Api34Utils {
        public static final Api34Utils INSTANCE = new Api34Utils();
        private static List<? extends Paint> highlightPaints;
        private static List<? extends Path> highlightPaths;

        private Api34Utils() {
        }

        public final void draw(Layout layout, Canvas canvas, Path selectionPath, Paint selectionPaint) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (selectionPath != null) {
                if (highlightPaths == null) {
                    highlightPaths = new ArrayList();
                }
                if (highlightPaints == null) {
                    highlightPaints = new ArrayList();
                }
            }
            layout.draw(canvas, highlightPaths, highlightPaints, selectionPath, selectionPaint, 0);
        }
    }

    /* JADX INFO: compiled from: PreparedLayoutTextView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/views/text/PreparedLayoutTextView$TextSelection;", "", ViewProps.START, "", ViewProps.END, "path", "Landroid/graphics/Path;", "<init>", "(IILandroid/graphics/Path;)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class TextSelection {
        private int end;
        private Path path;
        private int start;

        public TextSelection(int i, int i2, Path path) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.start = i;
            this.end = i2;
            this.path = path;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setStart(int i) {
            this.start = i;
        }

        public final int getEnd() {
            return this.end;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final Path getPath() {
            return this.path;
        }

        public final void setPath(Path path) {
            Intrinsics.checkNotNullParameter(path, "<set-?>");
            this.path = path;
        }
    }

    /* JADX INFO: compiled from: PreparedLayoutTextView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u000b\u001a\u00020\f*\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/views/text/PreparedLayoutTextView$Companion;", "", "<init>", "()V", "selectionPaint", "Landroid/graphics/Paint;", "filterClickableSpans", "", "Landroid/text/style/ClickableSpan;", "text", "", "maybeProxyStatefulSpans", "Lcom/facebook/react/views/text/PreparedLayout;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<ClickableSpan> filterClickableSpans(CharSequence text) {
            if (!(text instanceof Spanned)) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < text.length()) {
                Spanned spanned = (Spanned) text;
                int iNextSpanTransition = spanned.nextSpanTransition(i, text.length(), ClickableSpan.class);
                Object[] spans = spanned.getSpans(i, iNextSpanTransition, ClickableSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
                CollectionsKt.addAll(arrayList, spans);
                i = iNextSpanTransition;
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PreparedLayout maybeProxyStatefulSpans(PreparedLayout preparedLayout) {
            MutableSpannableLayout mutableSpannableLayoutCreateIfNeeded = MutableSpannableLayout.INSTANCE.createIfNeeded(preparedLayout.getLayout());
            return mutableSpannableLayoutCreateIfNeeded == null ? preparedLayout : new PreparedLayout(mutableSpannableLayoutCreateIfNeeded, preparedLayout.getMaximumNumberOfLines(), preparedLayout.getVerticalOffset(), preparedLayout.getReactTags(), preparedLayout.getTextBreakStrategy(), preparedLayout.getJustificationMode());
        }
    }
}
