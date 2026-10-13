package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.internal.SystraceSection;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.internal.span.CanvasEffectSpan;
import com.facebook.react.views.text.internal.span.ReactFragmentIndexSpan;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.yoga.YogaMeasureMode;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes6.dex */
public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final int DEFAULT_GRAVITY = 8388659;
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mAdjustsFontSizeToFit;
    private TextUtils.TruncateAt mEllipsizeLocation;
    private float mFontSize;
    private float mLetterSpacing;
    private int mLinkifyMaskType;
    private float mMinimumFontSize;
    private int mNumberOfLines;
    private Overflow mOverflow;
    private PreparedLayout mPreparedLayout;
    private boolean mShouldAdjustSpannableFontSize;
    private Spannable mSpanned;
    private boolean mTextIsSelectable;

    @Override // android.widget.TextView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ReactTextView(Context context) {
        super(context);
        this.mOverflow = Overflow.VISIBLE;
        initView();
    }

    private void initView() {
        this.mNumberOfLines = Integer.MAX_VALUE;
        this.mAdjustsFontSizeToFit = false;
        this.mLinkifyMaskType = 0;
        this.mTextIsSelectable = false;
        this.mShouldAdjustSpannableFontSize = false;
        this.mEllipsizeLocation = TextUtils.TruncateAt.END;
        this.mFontSize = Float.NaN;
        this.mMinimumFontSize = Float.NaN;
        this.mLetterSpacing = 0.0f;
        this.mOverflow = Overflow.VISIBLE;
        this.mSpanned = null;
        this.mPreparedLayout = null;
    }

    void recycleView() {
        initView();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        BackgroundStyleApplicator.reset(this);
        setBreakStrategy(0);
        setMovementMethod(getDefaultMovementMethod());
        if (Build.VERSION.SDK_INT >= 26) {
            setJustificationMode(0);
        }
        setLayoutParams(EMPTY_LAYOUT_PARAMS);
        super.setText((CharSequence) null);
        applyTextAttributes();
        setGravity(8388659);
        setNumberOfLines(this.mNumberOfLines);
        setAdjustFontSizeToFit(this.mAdjustsFontSizeToFit);
        setLinkifyMask(this.mLinkifyMaskType);
        setTextIsSelectable(this.mTextIsSelectable);
        setIncludeFontPadding(true);
        setEnabled(true);
        setLinkifyMask(0);
        setEllipsizeLocation(this.mEllipsizeLocation);
        setEnabled(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(16);
        }
        setHyphenationFrequency(0);
        updateView();
    }

    private static WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i == 8) {
            writableMapCreateMap.putString("visibility", "gone");
            writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
            return writableMapCreateMap;
        }
        if (i == 0) {
            writableMapCreateMap.putString("visibility", ViewProps.VISIBLE);
            writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
            writableMapCreateMap.putDouble("left", PixelUtil.toDIPFromPixel(i3));
            writableMapCreateMap.putDouble(ViewProps.TOP, PixelUtil.toDIPFromPixel(i4));
            writableMapCreateMap.putDouble("right", PixelUtil.toDIPFromPixel(i5));
            writableMapCreateMap.putDouble(ViewProps.BOTTOM, PixelUtil.toDIPFromPixel(i6));
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("visibility", "unknown");
        writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
        return writableMapCreateMap;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        SystraceSection systraceSection = new SystraceSection("ReactTextView.onDraw");
        try {
            Spannable spanned = getSpanned();
            if (this.mAdjustsFontSizeToFit && spanned != null && this.mShouldAdjustSpannableFontSize) {
                this.mShouldAdjustSpannableFontSize = false;
                TextLayoutManager.adjustSpannableFontToFit(spanned, getWidth(), YogaMeasureMode.EXACTLY, getHeight(), YogaMeasureMode.EXACTLY, this.mMinimumFontSize, this.mNumberOfLines, getIncludeFontPadding(), getBreakStrategy(), getHyphenationFrequency(), Layout.Alignment.ALIGN_NORMAL, Build.VERSION.SDK_INT < 26 ? -1 : getJustificationMode(), getPaint());
                spanned = spanned;
                setText(spanned);
            }
            if (this.mOverflow != Overflow.VISIBLE) {
                BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
            }
            if (spanned != null && (layout = getLayout()) != null) {
                CanvasEffectSpan[] canvasEffectSpanArr = (CanvasEffectSpan[]) spanned.getSpans(0, spanned.length(), CanvasEffectSpan.class);
                if (shouldDrawLayoutWithoutTextViewClip()) {
                    drawLayoutWithoutTextViewClip(canvas, spanned, layout, canvasEffectSpanArr);
                } else if (canvasEffectSpanArr.length > 0) {
                    drawTextEffects(canvas, spanned, layout, canvasEffectSpanArr, true, false);
                    super.onDraw(canvas);
                    drawTextEffects(canvas, spanned, layout, canvasEffectSpanArr, false, false);
                } else {
                    super.onDraw(canvas);
                }
            } else {
                super.onDraw(canvas);
            }
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    private boolean shouldDrawLayoutWithoutTextViewClip() {
        return this.mOverflow == Overflow.VISIBLE && !this.mTextIsSelectable && getMovementMethod() == null;
    }

    private void drawLayoutWithoutTextViewClip(Canvas canvas, Spannable spannable, Layout layout, CanvasEffectSpan[] canvasEffectSpanArr) {
        getPaint().setColor(getCurrentTextColor());
        getPaint().drawableState = getDrawableState();
        drawTextEffects(canvas, spannable, layout, canvasEffectSpanArr, true, true);
        canvas.save();
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop() + getVerticalGravityOffset(layout));
        layout.draw(canvas);
        canvas.restore();
        drawTextEffects(canvas, spannable, layout, canvasEffectSpanArr, false, true);
    }

    private void drawTextEffects(Canvas canvas, Spannable spannable, Layout layout, CanvasEffectSpan[] canvasEffectSpanArr, boolean z, boolean z2) {
        if (canvasEffectSpanArr.length == 0) {
            return;
        }
        canvas.save();
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop() + (z2 ? getVerticalGravityOffset(layout) : 0));
        for (CanvasEffectSpan canvasEffectSpan : canvasEffectSpanArr) {
            int spanStart = spannable.getSpanStart(canvasEffectSpan);
            int spanEnd = spannable.getSpanEnd(canvasEffectSpan);
            if (z) {
                canvasEffectSpan.onPreDraw(spanStart, spanEnd, canvas, layout);
            } else {
                canvasEffectSpan.onDraw(spanStart, spanEnd, canvas, layout);
            }
        }
        canvas.restore();
    }

    private int getVerticalGravityOffset(Layout layout) {
        int availableVerticalSpace = getAvailableVerticalSpace();
        if (layout.getHeight() >= availableVerticalSpace) {
            return 0;
        }
        int gravity = getGravity() & 112;
        if (gravity == 80) {
            return availableVerticalSpace - layout.getHeight();
        }
        if (gravity == 16) {
            return (availableVerticalSpace - layout.getHeight()) / 2;
        }
        return 0;
    }

    private int getAvailableVerticalSpace() {
        return (getHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        SystraceSection systraceSection = new SystraceSection("ReactTextView.onMeasure");
        try {
            super.onMeasure(i, i2);
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mAdjustsFontSizeToFit) {
            if (i == i3 && i2 == i4) {
                return;
            }
            this.mShouldAdjustSpannableFontSize = true;
        }
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        SystraceSection systraceSection = new SystraceSection("ReactTextView.setText(ReactTextUpdate)");
        try {
            if (getLayoutParams() == null) {
                setLayoutParams(EMPTY_LAYOUT_PARAMS);
            }
            Spanned text = reactTextUpdate.getText();
            if (this.mLinkifyMaskType > 0) {
                if (!(text instanceof Spannable)) {
                    text = new SpannableString(text);
                }
                Linkify.addLinks((Spannable) text, this.mLinkifyMaskType);
                setMovementMethod(LinkMovementMethod.getInstance());
            }
            setText(text);
            int textAlign = reactTextUpdate.getTextAlign();
            if (textAlign != getGravityHorizontal()) {
                setGravityHorizontal(textAlign);
            }
            if (getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
                setJustificationMode(reactTextUpdate.getJustificationMode());
            }
            requestLayout();
            systraceSection.close();
        } catch (Throwable th) {
            try {
                systraceSection.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float f, float f2) {
        int i;
        int i2;
        CharSequence text = getText();
        int id = getId();
        int i3 = (int) f;
        int i4 = (int) f2;
        Layout layout = getLayout();
        if (layout != null) {
            int lineForVertical = layout.getLineForVertical(i4);
            int lineLeft = (int) layout.getLineLeft(lineForVertical);
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if ((text instanceof Spanned) && i3 >= lineLeft && i3 <= lineRight) {
                Spanned spanned = (Spanned) text;
                try {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i3);
                    int i5 = 0;
                    if (this.mPreparedLayout != null) {
                        ReactFragmentIndexSpan[] reactFragmentIndexSpanArr = (ReactFragmentIndexSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactFragmentIndexSpan.class);
                        if (reactFragmentIndexSpanArr != null) {
                            int length = text.length();
                            while (i5 < reactFragmentIndexSpanArr.length) {
                                int spanStart = spanned.getSpanStart(reactFragmentIndexSpanArr[i5]);
                                int spanEnd = spanned.getSpanEnd(reactFragmentIndexSpanArr[i5]);
                                if (spanEnd >= offsetForHorizontal && (i2 = spanEnd - spanStart) <= length) {
                                    id = this.mPreparedLayout.getReactTags()[reactFragmentIndexSpanArr[i5].getFragmentIndex()];
                                    length = i2;
                                }
                                i5++;
                            }
                            return id;
                        }
                    } else {
                        ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                        if (reactTagSpanArr != null) {
                            int length2 = text.length();
                            while (i5 < reactTagSpanArr.length) {
                                int spanStart2 = spanned.getSpanStart(reactTagSpanArr[i5]);
                                int spanEnd2 = spanned.getSpanEnd(reactTagSpanArr[i5]);
                                if (spanEnd2 >= offsetForHorizontal && (i = spanEnd2 - spanStart2) <= length2) {
                                    id = reactTagSpanArr[i5].getReactTag();
                                    length2 = i;
                                }
                                i5++;
                            }
                            return id;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    FLog.e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e.getMessage());
                }
            }
        }
        return id;
    }

    @Override // android.widget.TextView
    public void setTextIsSelectable(boolean z) {
        this.mTextIsSelectable = z;
        super.setTextIsSelectable(z);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mTextIsSelectable) {
            setTextIsSelectable(false);
            setTextIsSelectable(true);
        } else {
            setTextIsSelectable(false);
        }
    }

    int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = 8388611;
        }
        setGravity(i | (getGravity() & (-8388616)));
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = 48;
        }
        setGravity(i | (getGravity() & (-113)));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        setMaxLines(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setFontSize(float f) {
        double dCeil;
        if (this.mAdjustsFontSizeToFit) {
            dCeil = Math.ceil(PixelUtil.toPixelFromSP(f));
        } else {
            dCeil = Math.ceil(PixelUtil.toPixelFromDIP(f));
        }
        this.mFontSize = (float) dCeil;
        applyTextAttributes();
    }

    public void setMinimumFontSize(float f) {
        this.mMinimumFontSize = f;
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setIncludeFontPadding(boolean z) {
        super.setIncludeFontPadding(z);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setBreakStrategy(int i) {
        super.setBreakStrategy(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setHyphenationFrequency(int i) {
        super.setHyphenationFrequency(i);
        this.mShouldAdjustSpannableFontSize = true;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f) {
        if (Float.isNaN(f)) {
            return;
        }
        this.mLetterSpacing = PixelUtil.toPixelFromDIP(f) / this.mFontSize;
        applyTextAttributes();
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void updateView() {
        setEllipsize((this.mNumberOfLines == Integer.MAX_VALUE || this.mAdjustsFontSizeToFit) ? null : this.mEllipsizeLocation);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public void setBorderWidth(int i, float f) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.values()[i], Float.valueOf(PixelUtil.toDIPFromPixel(f)));
    }

    public void setBorderColor(int i, Integer num) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.values()[i], num);
    }

    public void setBorderRadius(float f) {
        setBorderRadius(f, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.values()[i], Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(f), LengthPercentageType.POINT));
    }

    public void setBorderStyle(String str) {
        BackgroundStyleApplicator.setBorderStyle(this, str == null ? null : BorderStyle.fromString(str));
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
        this.mShouldAdjustSpannableFontSize = true;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    @UnstableReactNativeAPI
    public PreparedLayout getPreparedLayout() {
        return this.mPreparedLayout;
    }

    void setPreparedLayout(PreparedLayout preparedLayout) {
        this.mPreparedLayout = preparedLayout;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.hasAccessibilityDelegate(this)) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
            if (accessibilityDelegate instanceof ExploreByTouchHelper) {
                return ((ExploreByTouchHelper) accessibilityDelegate).dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
        if (accessibilityDelegate != null && (accessibilityDelegate instanceof ReactTextViewAccessibilityDelegate) && getMovementMethod() == null) {
            ((ReactTextViewAccessibilityDelegate) accessibilityDelegate).onFocusChanged(z, i, rect);
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
        return (accessibilityDelegate != null && getMovementMethod() == null && (accessibilityDelegate instanceof ReactTextViewAccessibilityDelegate) && ((ReactTextViewAccessibilityDelegate) accessibilityDelegate).dispatchKeyEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    private void applyTextAttributes() {
        if (!Float.isNaN(this.mFontSize)) {
            setTextSize(0, this.mFontSize);
        }
        if (Float.isNaN(this.mLetterSpacing)) {
            return;
        }
        super.setLetterSpacing(this.mLetterSpacing);
    }

    public void setOverflow(String str) {
        this.mOverflow = Overflow.fromString(str);
        invalidate();
    }

    Overflow getOverflow() {
        return this.mOverflow;
    }
}
