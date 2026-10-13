package com.facebook.react.views.text;

import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.views.text.internal.span.StatefulSpan;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutableSpannableLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0017R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/views/text/MutableSpannableLayout;", "Landroid/text/Layout;", "delegate", "clonedText", "Landroid/text/SpannableString;", "<init>", "(Landroid/text/Layout;Landroid/text/SpannableString;)V", "getLineCount", "", "getLineTop", "line", "getLineDescent", "getLineStart", "getLineContainsTab", "", "getLineDirections", "Landroid/text/Layout$Directions;", "getTopPadding", "getBottomPadding", "getEllipsisStart", "getEllipsisCount", "getParagraphDirection", "getEllipsizedWidth", "getLineMax", "", "getLineWidth", "getLineLeft", "getLineRight", "isFallbackLineSpacingEnabled", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MutableSpannableLayout extends Layout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Layout delegate;

    public /* synthetic */ MutableSpannableLayout(Layout layout, SpannableString spannableString, DefaultConstructorMarker defaultConstructorMarker) {
        this(layout, spannableString);
    }

    private MutableSpannableLayout(Layout layout, SpannableString spannableString) {
        super(spannableString, layout.getPaint(), layout.getWidth(), layout.getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd());
        this.delegate = layout;
    }

    /* JADX INFO: compiled from: MutableSpannableLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/views/text/MutableSpannableLayout$Companion;", "", "<init>", "()V", "createIfNeeded", "Lcom/facebook/react/views/text/MutableSpannableLayout;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MutableSpannableLayout createIfNeeded(Layout layout) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            CharSequence text = layout.getText();
            DefaultConstructorMarker defaultConstructorMarker = null;
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned == null) {
                return null;
            }
            StatefulSpan[] statefulSpanArr = (StatefulSpan[]) spanned.getSpans(0, spanned.length(), StatefulSpan.class);
            Intrinsics.checkNotNull(statefulSpanArr);
            if (statefulSpanArr.length == 0) {
                return null;
            }
            SpannableString spannableString = new SpannableString(spanned);
            Iterator it = ArrayIteratorKt.iterator(statefulSpanArr);
            while (it.hasNext()) {
                StatefulSpan statefulSpan = (StatefulSpan) it.next();
                int spanStart = spannableString.getSpanStart(statefulSpan);
                int spanEnd = spannableString.getSpanEnd(statefulSpan);
                int spanFlags = spannableString.getSpanFlags(statefulSpan);
                spannableString.removeSpan(statefulSpan);
                spannableString.setSpan(statefulSpan.clone(), spanStart, spanEnd, spanFlags);
            }
            return new MutableSpannableLayout(layout, spannableString, defaultConstructorMarker);
        }
    }

    @Override // android.text.Layout
    public int getLineCount() {
        return this.delegate.getLineCount();
    }

    @Override // android.text.Layout
    public int getLineTop(int line) {
        return this.delegate.getLineTop(line);
    }

    @Override // android.text.Layout
    public int getLineDescent(int line) {
        return this.delegate.getLineDescent(line);
    }

    @Override // android.text.Layout
    public int getLineStart(int line) {
        return this.delegate.getLineStart(line);
    }

    @Override // android.text.Layout
    public boolean getLineContainsTab(int line) {
        return this.delegate.getLineContainsTab(line);
    }

    @Override // android.text.Layout
    public Layout.Directions getLineDirections(int line) {
        Layout.Directions lineDirections = this.delegate.getLineDirections(line);
        Intrinsics.checkNotNullExpressionValue(lineDirections, "getLineDirections(...)");
        return lineDirections;
    }

    @Override // android.text.Layout
    public int getTopPadding() {
        return this.delegate.getTopPadding();
    }

    @Override // android.text.Layout
    public int getBottomPadding() {
        return this.delegate.getBottomPadding();
    }

    @Override // android.text.Layout
    public int getEllipsisStart(int line) {
        return this.delegate.getEllipsisStart(line);
    }

    @Override // android.text.Layout
    public int getEllipsisCount(int line) {
        return this.delegate.getEllipsisCount(line);
    }

    @Override // android.text.Layout
    public int getParagraphDirection(int line) {
        return this.delegate.getParagraphDirection(line);
    }

    @Override // android.text.Layout
    public int getEllipsizedWidth() {
        return this.delegate.getEllipsizedWidth();
    }

    @Override // android.text.Layout
    public float getLineMax(int line) {
        return this.delegate.getLineMax(line);
    }

    @Override // android.text.Layout
    public float getLineWidth(int line) {
        return this.delegate.getLineWidth(line);
    }

    @Override // android.text.Layout
    public float getLineLeft(int line) {
        return this.delegate.getLineLeft(line);
    }

    @Override // android.text.Layout
    public float getLineRight(int line) {
        return this.delegate.getLineRight(line);
    }

    @Override // android.text.Layout
    public boolean isFallbackLineSpacingEnabled() {
        return this.delegate.isFallbackLineSpacingEnabled();
    }
}
