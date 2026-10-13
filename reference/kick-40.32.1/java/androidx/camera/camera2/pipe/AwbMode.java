package androidx.camera.camera2.pipe;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraControls.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/AwbMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isOn", "", "isOn-impl", "(I)Z", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class AwbMode {
    private static final int AUTO;
    private static final int CLOUDY_DAYLIGHT;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DAYLIGHT;
    private static final int FLUORESCENT;
    private static final int INCANDESCENT;
    private static final int OFF;
    private static final int SHADE;
    private static final int TWILIGHT;
    private static final List<AwbMode> values;
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AwbMode m197boximpl(int i) {
        return new AwbMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m198constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m199equalsimpl(int i, Object obj) {
        return (obj instanceof AwbMode) && i == ((AwbMode) obj).m205unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m200equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromIntOrNull--SaEiwI, reason: not valid java name */
    public static final AwbMode m201fromIntOrNullSaEiwI(int i) {
        return INSTANCE.m206fromIntOrNullSaEiwI(i);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m202hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isOn-impl, reason: not valid java name */
    public static final boolean m203isOnimpl(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m204toStringimpl(int i) {
        return "AwbMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m199equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m202hashCodeimpl(this.value);
    }

    public String toString() {
        return m204toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m205unboximpl() {
        return this.value;
    }

    private /* synthetic */ AwbMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\b\u001eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/pipe/AwbMode$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/pipe/AwbMode;", "getOFF-3hxnlF8", "()I", "I", "AUTO", "getAUTO-3hxnlF8", "CLOUDY_DAYLIGHT", "getCLOUDY_DAYLIGHT-3hxnlF8", "DAYLIGHT", "getDAYLIGHT-3hxnlF8", "INCANDESCENT", "getINCANDESCENT-3hxnlF8", "FLUORESCENT", "getFLUORESCENT-3hxnlF8", "SHADE", "getSHADE-3hxnlF8", "TWILIGHT", "getTWILIGHT-3hxnlF8", "values", "", "getValues", "()Ljava/util/List;", "fromIntOrNull", "value", "", "fromIntOrNull--SaEiwI", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getOFF-3hxnlF8, reason: not valid java name */
        public final int m212getOFF3hxnlF8() {
            return AwbMode.OFF;
        }

        /* JADX INFO: renamed from: getAUTO-3hxnlF8, reason: not valid java name */
        public final int m207getAUTO3hxnlF8() {
            return AwbMode.AUTO;
        }

        /* JADX INFO: renamed from: getCLOUDY_DAYLIGHT-3hxnlF8, reason: not valid java name */
        public final int m208getCLOUDY_DAYLIGHT3hxnlF8() {
            return AwbMode.CLOUDY_DAYLIGHT;
        }

        /* JADX INFO: renamed from: getDAYLIGHT-3hxnlF8, reason: not valid java name */
        public final int m209getDAYLIGHT3hxnlF8() {
            return AwbMode.DAYLIGHT;
        }

        /* JADX INFO: renamed from: getINCANDESCENT-3hxnlF8, reason: not valid java name */
        public final int m211getINCANDESCENT3hxnlF8() {
            return AwbMode.INCANDESCENT;
        }

        /* JADX INFO: renamed from: getFLUORESCENT-3hxnlF8, reason: not valid java name */
        public final int m210getFLUORESCENT3hxnlF8() {
            return AwbMode.FLUORESCENT;
        }

        /* JADX INFO: renamed from: getSHADE-3hxnlF8, reason: not valid java name */
        public final int m213getSHADE3hxnlF8() {
            return AwbMode.SHADE;
        }

        /* JADX INFO: renamed from: getTWILIGHT-3hxnlF8, reason: not valid java name */
        public final int m214getTWILIGHT3hxnlF8() {
            return AwbMode.TWILIGHT;
        }

        public final List<AwbMode> getValues() {
            return AwbMode.values;
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromIntOrNull--SaEiwI, reason: not valid java name */
        public final AwbMode m206fromIntOrNullSaEiwI(int value) {
            Object next;
            Iterator<T> it = getValues().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (((AwbMode) next).m205unboximpl() == value) {
                    return (AwbMode) next;
                }
            }
            next = null;
            return (AwbMode) next;
        }
    }

    static {
        int iM198constructorimpl = m198constructorimpl(0);
        OFF = iM198constructorimpl;
        int iM198constructorimpl2 = m198constructorimpl(1);
        AUTO = iM198constructorimpl2;
        int iM198constructorimpl3 = m198constructorimpl(6);
        CLOUDY_DAYLIGHT = iM198constructorimpl3;
        int iM198constructorimpl4 = m198constructorimpl(5);
        DAYLIGHT = iM198constructorimpl4;
        int iM198constructorimpl5 = m198constructorimpl(2);
        INCANDESCENT = iM198constructorimpl5;
        int iM198constructorimpl6 = m198constructorimpl(3);
        FLUORESCENT = iM198constructorimpl6;
        int iM198constructorimpl7 = m198constructorimpl(8);
        SHADE = iM198constructorimpl7;
        int iM198constructorimpl8 = m198constructorimpl(7);
        TWILIGHT = iM198constructorimpl8;
        values = CollectionsKt.listOf((Object[]) new AwbMode[]{m197boximpl(iM198constructorimpl), m197boximpl(iM198constructorimpl2), m197boximpl(iM198constructorimpl3), m197boximpl(iM198constructorimpl4), m197boximpl(iM198constructorimpl5), m197boximpl(iM198constructorimpl6), m197boximpl(iM198constructorimpl7), m197boximpl(iM198constructorimpl8)});
    }
}
