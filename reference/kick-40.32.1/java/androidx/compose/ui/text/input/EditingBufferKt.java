package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.Attributes.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m9780updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM9594getLengthimpl;
        int iM9596getMinimpl = TextRange.m9596getMinimpl(j);
        int iM9595getMaximpl = TextRange.m9595getMaximpl(j);
        if (TextRange.m9600intersects5zctL8(j2, j)) {
            if (TextRange.m9588contains5zctL8(j2, j)) {
                iM9596getMinimpl = TextRange.m9596getMinimpl(j2);
                iM9595getMaximpl = iM9596getMinimpl;
            } else {
                if (TextRange.m9588contains5zctL8(j, j2)) {
                    iM9594getLengthimpl = TextRange.m9594getLengthimpl(j2);
                } else if (TextRange.m9589containsimpl(j2, iM9596getMinimpl)) {
                    iM9596getMinimpl = TextRange.m9596getMinimpl(j2);
                    iM9594getLengthimpl = TextRange.m9594getLengthimpl(j2);
                } else {
                    iM9595getMaximpl = TextRange.m9596getMinimpl(j2);
                }
                iM9595getMaximpl -= iM9594getLengthimpl;
            }
        } else if (iM9595getMaximpl > TextRange.m9596getMinimpl(j2)) {
            iM9596getMinimpl -= TextRange.m9594getLengthimpl(j2);
            iM9594getLengthimpl = TextRange.m9594getLengthimpl(j2);
            iM9595getMaximpl -= iM9594getLengthimpl;
        }
        return TextRangeKt.TextRange(iM9596getMinimpl, iM9595getMaximpl);
    }
}
