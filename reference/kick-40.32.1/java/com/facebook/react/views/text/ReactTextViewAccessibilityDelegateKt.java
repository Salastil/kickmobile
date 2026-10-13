package com.facebook.react.views.text;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactTextViewAccessibilityDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"isWholeTextSingleLink", "", "text", "Landroid/text/Spanned;", SpanEventSerializer.TAG_SPANS, "", "Landroid/text/style/ClickableSpan;", "(Landroid/text/Spanned;[Landroid/text/style/ClickableSpan;)Z", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReactTextViewAccessibilityDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isWholeTextSingleLink(Spanned spanned, ClickableSpan[] clickableSpanArr) {
        if (clickableSpanArr.length != 1) {
            return false;
        }
        ClickableSpan clickableSpan = clickableSpanArr[0];
        return spanned.getSpanStart(clickableSpan) == 0 && spanned.getSpanEnd(clickableSpan) == spanned.length();
    }
}
