package com.swmansion.rnscreens.gamma.stack.header.config;

import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: StackHeaderInvalidationFlags.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ\u001b\u0010\u001a\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\u0005J\u0011\u0010\u001f\u001a\u00020 HÖ\u0081\u0004¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\u0088\u0001\u0002¨\u0006$"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderInvalidationFlags;", "", "raw", "", "constructor-impl", "(I)I", "getRaw", "()I", "or", "other", "or-7cgdpso", "(II)I", "containsAny", "", "flags", "containsAny-gLpVZxs", "(II)Z", "clearing", "clearing-7cgdpso", "isNotEmpty", "isNotEmpty-impl", "(I)Z", "isEmpty", "isEmpty-impl", "needsRebuild", "getNeedsRebuild-impl", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@JvmInline
public final class StackHeaderInvalidationFlags {
    private static final int ALL;
    private static final int APPEARANCE;
    private static final int BACK_BUTTON;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NONE = m11791constructorimpl(0);
    private static final int SCROLL_FLAGS;
    private static final int STRUCTURE;
    private static final int SUBVIEWS;
    private static final int TITLE;
    private static final int TOOLBAR_MENU;
    private final int raw;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StackHeaderInvalidationFlags m11789boximpl(int i) {
        return new StackHeaderInvalidationFlags(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m11791constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: containsAny-gLpVZxs, reason: not valid java name */
    public static final boolean m11792containsAnygLpVZxs(int i, int i2) {
        return (i2 == 0 || (i & i2) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m11793equalsimpl(int i, Object obj) {
        return (obj instanceof StackHeaderInvalidationFlags) && i == ((StackHeaderInvalidationFlags) obj).m11801unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m11794equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m11796hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m11797isEmptyimpl(int i) {
        return i == 0;
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m11798isNotEmptyimpl(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m11800toStringimpl(int i) {
        return "StackHeaderInvalidationFlags(raw=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m11793equalsimpl(this.raw, obj);
    }

    public int hashCode() {
        return m11796hashCodeimpl(this.raw);
    }

    public String toString() {
        return m11800toStringimpl(this.raw);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m11801unboximpl() {
        return this.raw;
    }

    private /* synthetic */ StackHeaderInvalidationFlags(int i) {
        this.raw = i;
    }

    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: compiled from: StackHeaderInvalidationFlags.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderInvalidationFlags$Companion;", "", "<init>", "()V", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderInvalidationFlags;", "getNONE-2a6ZA60", "()I", "I", "STRUCTURE", "getSTRUCTURE-2a6ZA60", "SUBVIEWS", "getSUBVIEWS-2a6ZA60", "TITLE", "getTITLE-2a6ZA60", "BACK_BUTTON", "getBACK_BUTTON-2a6ZA60", "SCROLL_FLAGS", "getSCROLL_FLAGS-2a6ZA60", "TOOLBAR_MENU", "getTOOLBAR_MENU-2a6ZA60", "APPEARANCE", "getAPPEARANCE-2a6ZA60", Rule.ALL, "getALL-2a6ZA60", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNONE-2a6ZA60, reason: not valid java name */
        public final int m11805getNONE2a6ZA60() {
            return StackHeaderInvalidationFlags.NONE;
        }

        /* JADX INFO: renamed from: getSTRUCTURE-2a6ZA60, reason: not valid java name */
        public final int m11807getSTRUCTURE2a6ZA60() {
            return StackHeaderInvalidationFlags.STRUCTURE;
        }

        /* JADX INFO: renamed from: getSUBVIEWS-2a6ZA60, reason: not valid java name */
        public final int m11808getSUBVIEWS2a6ZA60() {
            return StackHeaderInvalidationFlags.SUBVIEWS;
        }

        /* JADX INFO: renamed from: getTITLE-2a6ZA60, reason: not valid java name */
        public final int m11809getTITLE2a6ZA60() {
            return StackHeaderInvalidationFlags.TITLE;
        }

        /* JADX INFO: renamed from: getBACK_BUTTON-2a6ZA60, reason: not valid java name */
        public final int m11804getBACK_BUTTON2a6ZA60() {
            return StackHeaderInvalidationFlags.BACK_BUTTON;
        }

        /* JADX INFO: renamed from: getSCROLL_FLAGS-2a6ZA60, reason: not valid java name */
        public final int m11806getSCROLL_FLAGS2a6ZA60() {
            return StackHeaderInvalidationFlags.SCROLL_FLAGS;
        }

        /* JADX INFO: renamed from: getTOOLBAR_MENU-2a6ZA60, reason: not valid java name */
        public final int m11810getTOOLBAR_MENU2a6ZA60() {
            return StackHeaderInvalidationFlags.TOOLBAR_MENU;
        }

        /* JADX INFO: renamed from: getAPPEARANCE-2a6ZA60, reason: not valid java name */
        public final int m11803getAPPEARANCE2a6ZA60() {
            return StackHeaderInvalidationFlags.APPEARANCE;
        }

        /* JADX INFO: renamed from: getALL-2a6ZA60, reason: not valid java name */
        public final int m11802getALL2a6ZA60() {
            return StackHeaderInvalidationFlags.ALL;
        }
    }

    static {
        int iM11791constructorimpl = m11791constructorimpl(1);
        STRUCTURE = iM11791constructorimpl;
        int iM11791constructorimpl2 = m11791constructorimpl(2);
        SUBVIEWS = iM11791constructorimpl2;
        int iM11791constructorimpl3 = m11791constructorimpl(4);
        TITLE = iM11791constructorimpl3;
        int iM11791constructorimpl4 = m11791constructorimpl(8);
        BACK_BUTTON = iM11791constructorimpl4;
        int iM11791constructorimpl5 = m11791constructorimpl(16);
        SCROLL_FLAGS = iM11791constructorimpl5;
        int iM11791constructorimpl6 = m11791constructorimpl(32);
        TOOLBAR_MENU = iM11791constructorimpl6;
        int iM11799or7cgdpso = m11799or7cgdpso(iM11791constructorimpl3, iM11791constructorimpl4);
        APPEARANCE = iM11799or7cgdpso;
        ALL = m11799or7cgdpso(m11799or7cgdpso(m11799or7cgdpso(m11799or7cgdpso(iM11791constructorimpl, iM11791constructorimpl2), iM11799or7cgdpso), iM11791constructorimpl5), iM11791constructorimpl6);
    }

    /* JADX INFO: renamed from: or-7cgdpso, reason: not valid java name */
    public static final int m11799or7cgdpso(int i, int i2) {
        return m11791constructorimpl(i | i2);
    }

    /* JADX INFO: renamed from: clearing-7cgdpso, reason: not valid java name */
    public static final int m11790clearing7cgdpso(int i, int i2) {
        return m11791constructorimpl(i & (~i2));
    }

    /* JADX INFO: renamed from: getNeedsRebuild-impl, reason: not valid java name */
    public static final boolean m11795getNeedsRebuildimpl(int i) {
        return m11792containsAnygLpVZxs(i, m11799or7cgdpso(STRUCTURE, SUBVIEWS));
    }
}
