package androidx.camera.camera2.pipe;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraControls.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/AeMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isOn", "", "isOn-impl", "(I)Z", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class AeMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int OFF;
    private static final int ON;
    private static final int ON_ALWAYS_FLASH;
    private static final int ON_AUTO_FLASH;
    private static final int ON_AUTO_FLASH_REDEYE;
    private static final int ON_EXTERNAL_FLASH;
    private static final int ON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY;
    private static final List<AeMode> values;
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AeMode m151boximpl(int i) {
        return new AeMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m152constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m153equalsimpl(int i, Object obj) {
        return (obj instanceof AeMode) && i == ((AeMode) obj).m160unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m154equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromInt-IwILmM0, reason: not valid java name */
    public static final int m155fromIntIwILmM0(int i) {
        return INSTANCE.m161fromIntIwILmM0(i);
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromIntOrNull-kQd0u18, reason: not valid java name */
    public static final AeMode m156fromIntOrNullkQd0u18(int i) {
        return INSTANCE.m162fromIntOrNullkQd0u18(i);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m157hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isOn-impl, reason: not valid java name */
    public static final boolean m158isOnimpl(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m159toStringimpl(int i) {
        return "AeMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m153equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m157hashCodeimpl(this.value);
    }

    public String toString() {
        return m159toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m160unboximpl() {
        return this.value;
    }

    private /* synthetic */ AeMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\b\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/AeMode$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/pipe/AeMode;", "getOFF-bOjpiJc", "()I", "I", "ON", "getON-bOjpiJc", "ON_ALWAYS_FLASH", "getON_ALWAYS_FLASH-bOjpiJc", "ON_AUTO_FLASH", "getON_AUTO_FLASH-bOjpiJc", "ON_AUTO_FLASH_REDEYE", "getON_AUTO_FLASH_REDEYE-bOjpiJc", "ON_EXTERNAL_FLASH", "getON_EXTERNAL_FLASH-bOjpiJc", "ON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY", "getON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY-bOjpiJc", "values", "", "getValues", "()Ljava/util/List;", "fromIntOrNull", "value", "", "fromIntOrNull-kQd0u18", "fromInt", "fromInt-IwILmM0", "(I)I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getOFF-bOjpiJc, reason: not valid java name */
        public final int m163getOFFbOjpiJc() {
            return AeMode.OFF;
        }

        /* JADX INFO: renamed from: getON-bOjpiJc, reason: not valid java name */
        public final int m164getONbOjpiJc() {
            return AeMode.ON;
        }

        /* JADX INFO: renamed from: getON_ALWAYS_FLASH-bOjpiJc, reason: not valid java name */
        public final int m165getON_ALWAYS_FLASHbOjpiJc() {
            return AeMode.ON_ALWAYS_FLASH;
        }

        /* JADX INFO: renamed from: getON_AUTO_FLASH-bOjpiJc, reason: not valid java name */
        public final int m166getON_AUTO_FLASHbOjpiJc() {
            return AeMode.ON_AUTO_FLASH;
        }

        /* JADX INFO: renamed from: getON_AUTO_FLASH_REDEYE-bOjpiJc, reason: not valid java name */
        public final int m167getON_AUTO_FLASH_REDEYEbOjpiJc() {
            return AeMode.ON_AUTO_FLASH_REDEYE;
        }

        /* JADX INFO: renamed from: getON_EXTERNAL_FLASH-bOjpiJc, reason: not valid java name */
        public final int m168getON_EXTERNAL_FLASHbOjpiJc() {
            return AeMode.ON_EXTERNAL_FLASH;
        }

        /* JADX INFO: renamed from: getON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY-bOjpiJc, reason: not valid java name */
        public final int m169getON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITYbOjpiJc() {
            return AeMode.ON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY;
        }

        public final List<AeMode> getValues() {
            return AeMode.values;
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromIntOrNull-kQd0u18, reason: not valid java name */
        public final AeMode m162fromIntOrNullkQd0u18(int value) {
            Object next;
            Iterator<T> it = getValues().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (((AeMode) next).m160unboximpl() == value) {
                    return (AeMode) next;
                }
            }
            next = null;
            return (AeMode) next;
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromInt-IwILmM0, reason: not valid java name */
        public final int m161fromIntIwILmM0(int value) {
            if (value == m163getOFFbOjpiJc()) {
                return m163getOFFbOjpiJc();
            }
            if (value == m164getONbOjpiJc()) {
                return m164getONbOjpiJc();
            }
            if (value == m166getON_AUTO_FLASHbOjpiJc()) {
                return m166getON_AUTO_FLASHbOjpiJc();
            }
            if (value == m165getON_ALWAYS_FLASHbOjpiJc()) {
                return m165getON_ALWAYS_FLASHbOjpiJc();
            }
            if (value == m167getON_AUTO_FLASH_REDEYEbOjpiJc()) {
                return m167getON_AUTO_FLASH_REDEYEbOjpiJc();
            }
            if (value == m168getON_EXTERNAL_FLASHbOjpiJc()) {
                return m168getON_EXTERNAL_FLASHbOjpiJc();
            }
            if (value == m169getON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITYbOjpiJc()) {
                return m169getON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITYbOjpiJc();
            }
            return m164getONbOjpiJc();
        }
    }

    static {
        int iM152constructorimpl = m152constructorimpl(0);
        OFF = iM152constructorimpl;
        int iM152constructorimpl2 = m152constructorimpl(1);
        ON = iM152constructorimpl2;
        int iM152constructorimpl3 = m152constructorimpl(3);
        ON_ALWAYS_FLASH = iM152constructorimpl3;
        int iM152constructorimpl4 = m152constructorimpl(2);
        ON_AUTO_FLASH = iM152constructorimpl4;
        int iM152constructorimpl5 = m152constructorimpl(4);
        ON_AUTO_FLASH_REDEYE = iM152constructorimpl5;
        int iM152constructorimpl6 = m152constructorimpl(5);
        ON_EXTERNAL_FLASH = iM152constructorimpl6;
        int iM152constructorimpl7 = m152constructorimpl(6);
        ON_LOW_LIGHT_BOOST_BRIGHTNESS_PRIORITY = iM152constructorimpl7;
        values = CollectionsKt.listOf((Object[]) new AeMode[]{m151boximpl(iM152constructorimpl), m151boximpl(iM152constructorimpl2), m151boximpl(iM152constructorimpl4), m151boximpl(iM152constructorimpl3), m151boximpl(iM152constructorimpl5), m151boximpl(iM152constructorimpl6), m151boximpl(iM152constructorimpl7)});
    }
}
