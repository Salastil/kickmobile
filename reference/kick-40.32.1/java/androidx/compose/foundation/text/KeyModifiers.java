package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KeyModifiers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/KeyModifiers;", "", "flags", "", "constructor-impl", "(I)I", "isAltPressed", "", "isCtrlPressed", "isMetaPressed", "isShiftPressed", "(ZZZZ)I", "plus", "other", "plus-1uj4btU", "(II)I", "equals", "hashCode", "toString", "", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class KeyModifiers {
    private static final int ALT_FLAG = 1;
    private static final int Alt;
    private static final int AltMeta;
    private static final int AltShift;
    private static final int CTRL_FLAG = 2;
    private static final int Ctrl;
    private static final int CtrlAlt;
    private static final int CtrlMeta;
    private static final int CtrlShift;
    private static final int META_FLAG = 4;
    private static final int Meta;
    private static final int SHIFT_FLAG = 8;
    private static final int Shift;
    private static final int ShiftMeta;
    private final int flags;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m2843constructorimpl(0);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyModifiers m2842boximpl(int i) {
        return new KeyModifiers(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2843constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2846equalsimpl(int i, Object obj) {
        return (obj instanceof KeyModifiers) && i == ((KeyModifiers) obj).getFlags();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2847equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getAlt-AuQ4EfA, reason: not valid java name */
    public static final int m2848getAltAuQ4EfA() {
        return INSTANCE.m2874getAltAuQ4EfA();
    }

    /* JADX INFO: renamed from: getAltMeta-AuQ4EfA, reason: not valid java name */
    public static final int m2849getAltMetaAuQ4EfA() {
        return INSTANCE.m2875getAltMetaAuQ4EfA();
    }

    /* JADX INFO: renamed from: getAltShift-AuQ4EfA, reason: not valid java name */
    public static final int m2850getAltShiftAuQ4EfA() {
        return INSTANCE.m2876getAltShiftAuQ4EfA();
    }

    /* JADX INFO: renamed from: getCtrl-AuQ4EfA, reason: not valid java name */
    public static final int m2851getCtrlAuQ4EfA() {
        return INSTANCE.m2877getCtrlAuQ4EfA();
    }

    /* JADX INFO: renamed from: getCtrlAlt-AuQ4EfA, reason: not valid java name */
    public static final int m2852getCtrlAltAuQ4EfA() {
        return INSTANCE.m2878getCtrlAltAuQ4EfA();
    }

    /* JADX INFO: renamed from: getCtrlMeta-AuQ4EfA, reason: not valid java name */
    public static final int m2853getCtrlMetaAuQ4EfA() {
        return INSTANCE.m2879getCtrlMetaAuQ4EfA();
    }

    /* JADX INFO: renamed from: getCtrlShift-AuQ4EfA, reason: not valid java name */
    public static final int m2854getCtrlShiftAuQ4EfA() {
        return INSTANCE.m2880getCtrlShiftAuQ4EfA();
    }

    /* JADX INFO: renamed from: getMeta-AuQ4EfA, reason: not valid java name */
    public static final int m2855getMetaAuQ4EfA() {
        return INSTANCE.m2881getMetaAuQ4EfA();
    }

    /* JADX INFO: renamed from: getNone-AuQ4EfA, reason: not valid java name */
    public static final int m2856getNoneAuQ4EfA() {
        return INSTANCE.m2882getNoneAuQ4EfA();
    }

    /* JADX INFO: renamed from: getShift-AuQ4EfA, reason: not valid java name */
    public static final int m2857getShiftAuQ4EfA() {
        return INSTANCE.m2883getShiftAuQ4EfA();
    }

    /* JADX INFO: renamed from: getShiftMeta-AuQ4EfA, reason: not valid java name */
    public static final int m2858getShiftMetaAuQ4EfA() {
        return INSTANCE.m2884getShiftMetaAuQ4EfA();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2859hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2861toStringimpl(int i) {
        return "KeyModifiers(flags=" + i + ')';
    }

    public boolean equals(Object other) {
        return m2846equalsimpl(this.flags, other);
    }

    public int hashCode() {
        return m2859hashCodeimpl(this.flags);
    }

    public String toString() {
        return m2861toStringimpl(this.flags);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getFlags() {
        return this.flags;
    }

    private /* synthetic */ KeyModifiers(int i) {
        this.flags = i;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ int m2845constructorimpl$default(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        return m2844constructorimpl(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2844constructorimpl(boolean z, boolean z2, boolean z3, boolean z4) {
        return m2843constructorimpl((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0) | (z4 ? 8 : 0));
    }

    /* JADX INFO: renamed from: plus-1uj4btU, reason: not valid java name */
    public static final int m2860plus1uj4btU(int i, int i2) {
        return m2843constructorimpl(i | i2);
    }

    /* JADX INFO: compiled from: KeyModifiers.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\rR\u001e\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\rR\u001e\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\rR\u001e\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\rR\u001e\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\rR\u001e\u0010!\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\rR\u001e\u0010$\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\rR\u001e\u0010'\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\rR\u001e\u0010*\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\r¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/KeyModifiers$Companion;", "", "<init>", "()V", "ALT_FLAG", "", "CTRL_FLAG", "META_FLAG", "SHIFT_FLAG", "None", "Landroidx/compose/foundation/text/KeyModifiers;", "getNone-AuQ4EfA$annotations", "getNone-AuQ4EfA", "()I", "I", "Alt", "getAlt-AuQ4EfA$annotations", "getAlt-AuQ4EfA", "Ctrl", "getCtrl-AuQ4EfA$annotations", "getCtrl-AuQ4EfA", "Meta", "getMeta-AuQ4EfA$annotations", "getMeta-AuQ4EfA", "Shift", "getShift-AuQ4EfA$annotations", "getShift-AuQ4EfA", "AltShift", "getAltShift-AuQ4EfA$annotations", "getAltShift-AuQ4EfA", "CtrlShift", "getCtrlShift-AuQ4EfA$annotations", "getCtrlShift-AuQ4EfA", "ShiftMeta", "getShiftMeta-AuQ4EfA$annotations", "getShiftMeta-AuQ4EfA", "CtrlAlt", "getCtrlAlt-AuQ4EfA$annotations", "getCtrlAlt-AuQ4EfA", "CtrlMeta", "getCtrlMeta-AuQ4EfA$annotations", "getCtrlMeta-AuQ4EfA", "AltMeta", "getAltMeta-AuQ4EfA$annotations", "getAltMeta-AuQ4EfA", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: getAlt-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2863getAltAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getAltMeta-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2864getAltMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getAltShift-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2865getAltShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getCtrl-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2866getCtrlAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getCtrlAlt-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2867getCtrlAltAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getCtrlMeta-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2868getCtrlMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getCtrlShift-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2869getCtrlShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getMeta-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2870getMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getNone-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2871getNoneAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getShift-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2872getShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: getShiftMeta-AuQ4EfA$annotations, reason: not valid java name */
        public static /* synthetic */ void m2873getShiftMetaAuQ4EfA$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-AuQ4EfA, reason: not valid java name */
        public final int m2882getNoneAuQ4EfA() {
            return KeyModifiers.None;
        }

        /* JADX INFO: renamed from: getAlt-AuQ4EfA, reason: not valid java name */
        public final int m2874getAltAuQ4EfA() {
            return KeyModifiers.Alt;
        }

        /* JADX INFO: renamed from: getCtrl-AuQ4EfA, reason: not valid java name */
        public final int m2877getCtrlAuQ4EfA() {
            return KeyModifiers.Ctrl;
        }

        /* JADX INFO: renamed from: getMeta-AuQ4EfA, reason: not valid java name */
        public final int m2881getMetaAuQ4EfA() {
            return KeyModifiers.Meta;
        }

        /* JADX INFO: renamed from: getShift-AuQ4EfA, reason: not valid java name */
        public final int m2883getShiftAuQ4EfA() {
            return KeyModifiers.Shift;
        }

        /* JADX INFO: renamed from: getAltShift-AuQ4EfA, reason: not valid java name */
        public final int m2876getAltShiftAuQ4EfA() {
            return KeyModifiers.AltShift;
        }

        /* JADX INFO: renamed from: getCtrlShift-AuQ4EfA, reason: not valid java name */
        public final int m2880getCtrlShiftAuQ4EfA() {
            return KeyModifiers.CtrlShift;
        }

        /* JADX INFO: renamed from: getShiftMeta-AuQ4EfA, reason: not valid java name */
        public final int m2884getShiftMetaAuQ4EfA() {
            return KeyModifiers.ShiftMeta;
        }

        /* JADX INFO: renamed from: getCtrlAlt-AuQ4EfA, reason: not valid java name */
        public final int m2878getCtrlAltAuQ4EfA() {
            return KeyModifiers.CtrlAlt;
        }

        /* JADX INFO: renamed from: getCtrlMeta-AuQ4EfA, reason: not valid java name */
        public final int m2879getCtrlMetaAuQ4EfA() {
            return KeyModifiers.CtrlMeta;
        }

        /* JADX INFO: renamed from: getAltMeta-AuQ4EfA, reason: not valid java name */
        public final int m2875getAltMetaAuQ4EfA() {
            return KeyModifiers.AltMeta;
        }
    }

    static {
        int iM2843constructorimpl = m2843constructorimpl(1);
        Alt = iM2843constructorimpl;
        int iM2843constructorimpl2 = m2843constructorimpl(2);
        Ctrl = iM2843constructorimpl2;
        int iM2843constructorimpl3 = m2843constructorimpl(4);
        Meta = iM2843constructorimpl3;
        int iM2843constructorimpl4 = m2843constructorimpl(8);
        Shift = iM2843constructorimpl4;
        AltShift = m2860plus1uj4btU(iM2843constructorimpl, iM2843constructorimpl4);
        CtrlShift = m2860plus1uj4btU(iM2843constructorimpl2, iM2843constructorimpl4);
        ShiftMeta = m2860plus1uj4btU(iM2843constructorimpl3, iM2843constructorimpl4);
        CtrlAlt = m2860plus1uj4btU(iM2843constructorimpl2, iM2843constructorimpl);
        CtrlMeta = m2860plus1uj4btU(iM2843constructorimpl2, iM2843constructorimpl3);
        AltMeta = m2860plus1uj4btU(iM2843constructorimpl3, iM2843constructorimpl4);
    }
}
