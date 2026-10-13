package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/FlexJustifyContent;", "", "bits", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class FlexJustifyContent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int bits;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FlexJustifyContent m2170boximpl(int i) {
        return new FlexJustifyContent(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2171constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2172equalsimpl(int i, Object obj) {
        return (obj instanceof FlexJustifyContent) && i == ((FlexJustifyContent) obj).getBits();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2173equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2174hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m2172equalsimpl(this.bits, other);
    }

    public int hashCode() {
        return m2174hashCodeimpl(this.bits);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getBits() {
        return this.bits;
    }

    private /* synthetic */ FlexJustifyContent(int i) {
        this.bits = i;
    }

    public String toString() {
        return m2175toStringimpl(this.bits);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2175toStringimpl(int i) {
        if (i == 0) {
            return "Start";
        }
        if (i == 1) {
            return "End";
        }
        if (i == 2) {
            return "Center";
        }
        if (i == 3) {
            return "SpaceBetween";
        }
        if (i == 4) {
            return "SpaceAround";
        }
        if (i == 5) {
            return "SpaceEvenly";
        }
        return "INVALID";
    }

    /* JADX INFO: compiled from: FlexBox.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/FlexJustifyContent$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/FlexJustifyContent;", "getStart-GomtQF4", "()I", "End", "getEnd-GomtQF4", "Center", "getCenter-GomtQF4", "SpaceBetween", "getSpaceBetween-GomtQF4", "SpaceAround", "getSpaceAround-GomtQF4", "SpaceEvenly", "getSpaceEvenly-GomtQF4", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getStart-GomtQF4, reason: not valid java name */
        public final int m2182getStartGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(0);
        }

        /* JADX INFO: renamed from: getEnd-GomtQF4, reason: not valid java name */
        public final int m2178getEndGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(1);
        }

        /* JADX INFO: renamed from: getCenter-GomtQF4, reason: not valid java name */
        public final int m2177getCenterGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(2);
        }

        /* JADX INFO: renamed from: getSpaceBetween-GomtQF4, reason: not valid java name */
        public final int m2180getSpaceBetweenGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(3);
        }

        /* JADX INFO: renamed from: getSpaceAround-GomtQF4, reason: not valid java name */
        public final int m2179getSpaceAroundGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(4);
        }

        /* JADX INFO: renamed from: getSpaceEvenly-GomtQF4, reason: not valid java name */
        public final int m2181getSpaceEvenlyGomtQF4() {
            return FlexJustifyContent.m2171constructorimpl(5);
        }
    }
}
