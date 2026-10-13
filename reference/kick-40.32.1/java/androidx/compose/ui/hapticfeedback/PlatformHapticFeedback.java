package androidx.compose.ui.hapticfeedback;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlatformHapticFeedback.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo8107performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        int i;
        if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8115getConfirm5zf0vsI())) {
            i = 16;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8116getContextClick5zf0vsI())) {
            i = 6;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8117getGestureEnd5zf0vsI())) {
            i = 13;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8118getGestureThresholdActivate5zf0vsI())) {
            i = 23;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8119getKeyboardTap5zf0vsI())) {
            i = 3;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8120getLongPress5zf0vsI())) {
            i = 0;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8121getReject5zf0vsI())) {
            i = 17;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8122getSegmentFrequentTick5zf0vsI())) {
            i = 27;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8123getSegmentTick5zf0vsI())) {
            i = 26;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8124getTextHandleMove5zf0vsI())) {
            i = 9;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8125getToggleOff5zf0vsI())) {
            i = 22;
        } else if (HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8126getToggleOn5zf0vsI())) {
            i = 21;
        } else {
            i = HapticFeedbackType.m8111equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m8127getVirtualKey5zf0vsI()) ? 1 : -1;
        }
        ViewCompat.performHapticFeedback(this.view, i);
    }
}
