package io.ktor.http.cio.internals;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tokenizer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "text", "Lio/ktor/http/cio/internals/MutableRange;", "range", "nextToken", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/CharSequence;", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "", ViewProps.START, ViewProps.END, "skipSpacesAndHorizontalTabs", "(Lio/ktor/http/cio/internals/CharArrayBuilder;II)I", "", "skipSpaces", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)V", "findSpaceOrEnd", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)I", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TokenizerKt {
    public static final CharSequence nextToken(CharSequence text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int iFindSpaceOrEnd = findSpaceOrEnd(text, range);
        CharSequence charSequenceSubSequence = text.subSequence(range.getStart(), iFindSpaceOrEnd);
        range.setStart(iFindSpaceOrEnd);
        return charSequenceSubSequence;
    }

    public static final int skipSpacesAndHorizontalTabs(CharArrayBuilder text, int i, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        while (i < i2) {
            char cCharAt = text.charAt(i);
            if (!kotlin.text.CharsKt.isWhitespace(cCharAt) && cCharAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    public static final void skipSpaces(CharSequence text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int start = range.getStart();
        int end = range.getEnd();
        if (start >= end || !kotlin.text.CharsKt.isWhitespace(text.charAt(start))) {
            return;
        }
        do {
            start++;
            if (start >= end) {
                break;
            }
        } while (kotlin.text.CharsKt.isWhitespace(text.charAt(start)));
        range.setStart(start);
    }

    public static final int findSpaceOrEnd(CharSequence text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int start = range.getStart();
        int end = range.getEnd();
        if (start < end && !kotlin.text.CharsKt.isWhitespace(text.charAt(start))) {
            do {
                start++;
                if (start >= end) {
                    break;
                }
            } while (!kotlin.text.CharsKt.isWhitespace(text.charAt(start)));
        }
        return start;
    }
}
