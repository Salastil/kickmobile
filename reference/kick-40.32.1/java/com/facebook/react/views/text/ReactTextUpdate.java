package com.facebook.react.views.text;

import android.text.Spanned;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactTextUpdate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/views/text/ReactTextUpdate;", "", "text", "Landroid/text/Spanned;", "jsEventCounter", "", ViewProps.TEXT_ALIGN, ViewProps.TEXT_BREAK_STRATEGY, "justificationMode", "<init>", "(Landroid/text/Spanned;IIII)V", "getText", "()Landroid/text/Spanned;", "getJsEventCounter", "()I", "getTextAlign", "getTextBreakStrategy", "getJustificationMode", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactTextUpdate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int jsEventCounter;
    private final int justificationMode;
    private final Spanned text;
    private final int textAlign;
    private final int textBreakStrategy;

    @JvmStatic
    public static final ReactTextUpdate buildReactTextUpdateFromState(Spanned spanned, int i, int i2, int i3, int i4) {
        return INSTANCE.buildReactTextUpdateFromState(spanned, i, i2, i3, i4);
    }

    public ReactTextUpdate(Spanned text, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.jsEventCounter = i;
        this.textAlign = i2;
        this.textBreakStrategy = i3;
        this.justificationMode = i4;
    }

    public final Spanned getText() {
        return this.text;
    }

    public final int getJsEventCounter() {
        return this.jsEventCounter;
    }

    public final int getTextAlign() {
        return this.textAlign;
    }

    public final int getTextBreakStrategy() {
        return this.textBreakStrategy;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    /* JADX INFO: compiled from: ReactTextUpdate.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lcom/facebook/react/views/text/ReactTextUpdate$Companion;", "", "<init>", "()V", "buildReactTextUpdateFromState", "Lcom/facebook/react/views/text/ReactTextUpdate;", "text", "Landroid/text/Spanned;", "jsEventCounter", "", ViewProps.TEXT_ALIGN, ViewProps.TEXT_BREAK_STRATEGY, "justificationMode", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReactTextUpdate buildReactTextUpdateFromState(Spanned text, int jsEventCounter, int textAlign, int textBreakStrategy, int justificationMode) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ReactTextUpdate(text, jsEventCounter, textAlign, textBreakStrategy, justificationMode);
        }
    }
}
