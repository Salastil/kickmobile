package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HapticFeedbackType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class HapticFeedbackType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m8108boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m8109constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8110equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8111equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8112hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m8110equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m8112hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    public String toString() {
        return m8113toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8113toStringimpl(int i) {
        Companion companion = INSTANCE;
        if (m8111equalsimpl0(i, companion.m8115getConfirm5zf0vsI())) {
            return "Confirm";
        }
        if (m8111equalsimpl0(i, companion.m8116getContextClick5zf0vsI())) {
            return "ContextClick";
        }
        if (m8111equalsimpl0(i, companion.m8117getGestureEnd5zf0vsI())) {
            return "GestureEnd";
        }
        if (m8111equalsimpl0(i, companion.m8118getGestureThresholdActivate5zf0vsI())) {
            return "GestureThresholdActivate";
        }
        if (m8111equalsimpl0(i, companion.m8119getKeyboardTap5zf0vsI())) {
            return "KeyboardTap";
        }
        if (m8111equalsimpl0(i, companion.m8120getLongPress5zf0vsI())) {
            return "LongPress";
        }
        if (m8111equalsimpl0(i, companion.m8121getReject5zf0vsI())) {
            return "Reject";
        }
        if (m8111equalsimpl0(i, companion.m8122getSegmentFrequentTick5zf0vsI())) {
            return "SegmentFrequentTick";
        }
        if (m8111equalsimpl0(i, companion.m8123getSegmentTick5zf0vsI())) {
            return "SegmentTick";
        }
        if (m8111equalsimpl0(i, companion.m8124getTextHandleMove5zf0vsI())) {
            return "TextHandleMove";
        }
        if (m8111equalsimpl0(i, companion.m8125getToggleOff5zf0vsI())) {
            return "ToggleOff";
        }
        if (m8111equalsimpl0(i, companion.m8126getToggleOn5zf0vsI())) {
            return "ToggleOn";
        }
        return m8111equalsimpl0(i, companion.m8127getVirtualKey5zf0vsI()) ? "VirtualKey" : "Invalid";
    }

    /* JADX INFO: compiled from: HapticFeedbackType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getConfirm-5zf0vsI, reason: not valid java name */
        public final int m8115getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8128getConfirm5zf0vsI();
        }

        /* JADX INFO: renamed from: getContextClick-5zf0vsI, reason: not valid java name */
        public final int m8116getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8129getContextClick5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
        public final int m8117getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8130getGestureEnd5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
        public final int m8118getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8131getGestureThresholdActivate5zf0vsI();
        }

        /* JADX INFO: renamed from: getKeyboardTap-5zf0vsI, reason: not valid java name */
        public final int m8119getKeyboardTap5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8132getKeyboardTap5zf0vsI();
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m8120getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8133getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getReject-5zf0vsI, reason: not valid java name */
        public final int m8121getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8134getReject5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
        public final int m8122getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8135getSegmentFrequentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
        public final int m8123getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8136getSegmentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m8124getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8137getTextHandleMove5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
        public final int m8125getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8138getToggleOff5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
        public final int m8126getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8139getToggleOn5zf0vsI();
        }

        /* JADX INFO: renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
        public final int m8127getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m8140getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf((Object[]) new HapticFeedbackType[]{HapticFeedbackType.m8108boximpl(m8115getConfirm5zf0vsI()), HapticFeedbackType.m8108boximpl(m8116getContextClick5zf0vsI()), HapticFeedbackType.m8108boximpl(m8117getGestureEnd5zf0vsI()), HapticFeedbackType.m8108boximpl(m8118getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m8108boximpl(m8119getKeyboardTap5zf0vsI()), HapticFeedbackType.m8108boximpl(m8120getLongPress5zf0vsI()), HapticFeedbackType.m8108boximpl(m8121getReject5zf0vsI()), HapticFeedbackType.m8108boximpl(m8122getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m8108boximpl(m8123getSegmentTick5zf0vsI()), HapticFeedbackType.m8108boximpl(m8124getTextHandleMove5zf0vsI()), HapticFeedbackType.m8108boximpl(m8125getToggleOff5zf0vsI()), HapticFeedbackType.m8108boximpl(m8126getToggleOn5zf0vsI()), HapticFeedbackType.m8108boximpl(m8127getVirtualKey5zf0vsI())});
        }
    }
}
