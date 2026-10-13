package androidx.camera.camera2.pipe;

import com.google.mlkit.vision.common.InputImage;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: StreamFormat.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/StreamFormat;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "bitsPerPixel", "getBitsPerPixel-impl", "name", "getName-impl", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class StreamFormat {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int UNKNOWN = m746constructorimpl(0);
    private static final int PRIVATE = m746constructorimpl(34);
    private static final int DEPTH16 = m746constructorimpl(1144402265);
    private static final int DEPTH_JPEG = m746constructorimpl(1768253795);
    private static final int DEPTH_POINT_CLOUD = m746constructorimpl(257);
    private static final int FLEX_RGB_888 = m746constructorimpl(41);
    private static final int FLEX_RGBA_8888 = m746constructorimpl(42);
    private static final int HEIC = m746constructorimpl(1212500294);
    private static final int JPEG = m746constructorimpl(256);
    private static final int JPEG_R = m746constructorimpl(4101);
    private static final int NV16 = m746constructorimpl(16);
    private static final int NV21 = m746constructorimpl(17);
    private static final int RAW10 = m746constructorimpl(37);
    private static final int RAW12 = m746constructorimpl(38);
    private static final int RAW_DEPTH = m746constructorimpl(4098);
    private static final int RAW_PRIVATE = m746constructorimpl(36);
    private static final int RAW_SENSOR = m746constructorimpl(32);
    private static final int RGB_565 = m746constructorimpl(4);
    private static final int Y12 = m746constructorimpl(InputImage.IMAGE_FORMAT_YV12);
    private static final int Y16 = m746constructorimpl(540422489);
    private static final int Y8 = m746constructorimpl(538982489);
    private static final int YCBCR_P010 = m746constructorimpl(54);
    private static final int YUV_420_888 = m746constructorimpl(35);
    private static final int YUV_422_888 = m746constructorimpl(39);
    private static final int YUV_444_888 = m746constructorimpl(40);
    private static final int YUY2 = m746constructorimpl(20);
    private static final int YV12 = m746constructorimpl(InputImage.IMAGE_FORMAT_YV12);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StreamFormat m745boximpl(int i) {
        return new StreamFormat(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m746constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m747equalsimpl(int i, Object obj) {
        return (obj instanceof StreamFormat) && i == ((StreamFormat) obj).m753unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m748equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m751hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m747equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m751hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m753unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: StreamFormat.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b8\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b.\u0010\u0007R\u0013\u0010/\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b0\u0010\u0007R\u0013\u00101\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b2\u0010\u0007R\u0013\u00103\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b4\u0010\u0007R\u0013\u00105\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b6\u0010\u0007R\u0013\u00107\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b8\u0010\u0007R\u0013\u00109\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b:\u0010\u0007R\u0013\u0010;\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b<\u0010\u0007¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/StreamFormat$Companion;", "", "<init>", "()V", "UNKNOWN", "Landroidx/camera/camera2/pipe/StreamFormat;", "getUNKNOWN-8FPWQzE", "()I", "I", "PRIVATE", "getPRIVATE-8FPWQzE", "DEPTH16", "getDEPTH16-8FPWQzE", "DEPTH_JPEG", "getDEPTH_JPEG-8FPWQzE", "DEPTH_POINT_CLOUD", "getDEPTH_POINT_CLOUD-8FPWQzE", "FLEX_RGB_888", "getFLEX_RGB_888-8FPWQzE", "FLEX_RGBA_8888", "getFLEX_RGBA_8888-8FPWQzE", "HEIC", "getHEIC-8FPWQzE", "JPEG", "getJPEG-8FPWQzE", "JPEG_R", "getJPEG_R-8FPWQzE", "NV16", "getNV16-8FPWQzE", "NV21", "getNV21-8FPWQzE", "RAW10", "getRAW10-8FPWQzE", "RAW12", "getRAW12-8FPWQzE", "RAW_DEPTH", "getRAW_DEPTH-8FPWQzE", "RAW_PRIVATE", "getRAW_PRIVATE-8FPWQzE", "RAW_SENSOR", "getRAW_SENSOR-8FPWQzE", "RGB_565", "getRGB_565-8FPWQzE", "Y12", "getY12-8FPWQzE", "Y16", "getY16-8FPWQzE", "Y8", "getY8-8FPWQzE", "YCBCR_P010", "getYCBCR_P010-8FPWQzE", "YUV_420_888", "getYUV_420_888-8FPWQzE", "YUV_422_888", "getYUV_422_888-8FPWQzE", "YUV_444_888", "getYUV_444_888-8FPWQzE", "YUY2", "getYUY2-8FPWQzE", "YV12", "getYV12-8FPWQzE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUNKNOWN-8FPWQzE, reason: not valid java name */
        public final int m771getUNKNOWN8FPWQzE() {
            return StreamFormat.UNKNOWN;
        }

        /* JADX INFO: renamed from: getPRIVATE-8FPWQzE, reason: not valid java name */
        public final int m764getPRIVATE8FPWQzE() {
            return StreamFormat.PRIVATE;
        }

        /* JADX INFO: renamed from: getDEPTH16-8FPWQzE, reason: not valid java name */
        public final int m754getDEPTH168FPWQzE() {
            return StreamFormat.DEPTH16;
        }

        /* JADX INFO: renamed from: getDEPTH_JPEG-8FPWQzE, reason: not valid java name */
        public final int m755getDEPTH_JPEG8FPWQzE() {
            return StreamFormat.DEPTH_JPEG;
        }

        /* JADX INFO: renamed from: getDEPTH_POINT_CLOUD-8FPWQzE, reason: not valid java name */
        public final int m756getDEPTH_POINT_CLOUD8FPWQzE() {
            return StreamFormat.DEPTH_POINT_CLOUD;
        }

        /* JADX INFO: renamed from: getFLEX_RGB_888-8FPWQzE, reason: not valid java name */
        public final int m758getFLEX_RGB_8888FPWQzE() {
            return StreamFormat.FLEX_RGB_888;
        }

        /* JADX INFO: renamed from: getFLEX_RGBA_8888-8FPWQzE, reason: not valid java name */
        public final int m757getFLEX_RGBA_88888FPWQzE() {
            return StreamFormat.FLEX_RGBA_8888;
        }

        /* JADX INFO: renamed from: getHEIC-8FPWQzE, reason: not valid java name */
        public final int m759getHEIC8FPWQzE() {
            return StreamFormat.HEIC;
        }

        /* JADX INFO: renamed from: getJPEG-8FPWQzE, reason: not valid java name */
        public final int m760getJPEG8FPWQzE() {
            return StreamFormat.JPEG;
        }

        /* JADX INFO: renamed from: getJPEG_R-8FPWQzE, reason: not valid java name */
        public final int m761getJPEG_R8FPWQzE() {
            return StreamFormat.JPEG_R;
        }

        /* JADX INFO: renamed from: getNV16-8FPWQzE, reason: not valid java name */
        public final int m762getNV168FPWQzE() {
            return StreamFormat.NV16;
        }

        /* JADX INFO: renamed from: getNV21-8FPWQzE, reason: not valid java name */
        public final int m763getNV218FPWQzE() {
            return StreamFormat.NV21;
        }

        /* JADX INFO: renamed from: getRAW10-8FPWQzE, reason: not valid java name */
        public final int m765getRAW108FPWQzE() {
            return StreamFormat.RAW10;
        }

        /* JADX INFO: renamed from: getRAW12-8FPWQzE, reason: not valid java name */
        public final int m766getRAW128FPWQzE() {
            return StreamFormat.RAW12;
        }

        /* JADX INFO: renamed from: getRAW_DEPTH-8FPWQzE, reason: not valid java name */
        public final int m767getRAW_DEPTH8FPWQzE() {
            return StreamFormat.RAW_DEPTH;
        }

        /* JADX INFO: renamed from: getRAW_PRIVATE-8FPWQzE, reason: not valid java name */
        public final int m768getRAW_PRIVATE8FPWQzE() {
            return StreamFormat.RAW_PRIVATE;
        }

        /* JADX INFO: renamed from: getRAW_SENSOR-8FPWQzE, reason: not valid java name */
        public final int m769getRAW_SENSOR8FPWQzE() {
            return StreamFormat.RAW_SENSOR;
        }

        /* JADX INFO: renamed from: getRGB_565-8FPWQzE, reason: not valid java name */
        public final int m770getRGB_5658FPWQzE() {
            return StreamFormat.RGB_565;
        }

        /* JADX INFO: renamed from: getY12-8FPWQzE, reason: not valid java name */
        public final int m772getY128FPWQzE() {
            return StreamFormat.Y12;
        }

        /* JADX INFO: renamed from: getY16-8FPWQzE, reason: not valid java name */
        public final int m773getY168FPWQzE() {
            return StreamFormat.Y16;
        }

        /* JADX INFO: renamed from: getY8-8FPWQzE, reason: not valid java name */
        public final int m774getY88FPWQzE() {
            return StreamFormat.Y8;
        }

        /* JADX INFO: renamed from: getYCBCR_P010-8FPWQzE, reason: not valid java name */
        public final int m775getYCBCR_P0108FPWQzE() {
            return StreamFormat.YCBCR_P010;
        }

        /* JADX INFO: renamed from: getYUV_420_888-8FPWQzE, reason: not valid java name */
        public final int m776getYUV_420_8888FPWQzE() {
            return StreamFormat.YUV_420_888;
        }

        /* JADX INFO: renamed from: getYUV_422_888-8FPWQzE, reason: not valid java name */
        public final int m777getYUV_422_8888FPWQzE() {
            return StreamFormat.YUV_422_888;
        }

        /* JADX INFO: renamed from: getYUV_444_888-8FPWQzE, reason: not valid java name */
        public final int m778getYUV_444_8888FPWQzE() {
            return StreamFormat.YUV_444_888;
        }

        /* JADX INFO: renamed from: getYUY2-8FPWQzE, reason: not valid java name */
        public final int m779getYUY28FPWQzE() {
            return StreamFormat.YUY2;
        }

        /* JADX INFO: renamed from: getYV12-8FPWQzE, reason: not valid java name */
        public final int m780getYV128FPWQzE() {
            return StreamFormat.YV12;
        }
    }

    private /* synthetic */ StreamFormat(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m752toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m752toStringimpl(int i) {
        return "StreamFormat(" + m750getNameimpl(i) + ')';
    }

    /* JADX INFO: renamed from: getBitsPerPixel-impl, reason: not valid java name */
    public static final int m749getBitsPerPixelimpl(int i) {
        if (m748equalsimpl0(i, DEPTH16)) {
            return 16;
        }
        if (m748equalsimpl0(i, FLEX_RGB_888)) {
            return 24;
        }
        if (m748equalsimpl0(i, FLEX_RGBA_8888)) {
            return 32;
        }
        if (m748equalsimpl0(i, NV16)) {
            return 16;
        }
        if (m748equalsimpl0(i, NV21)) {
            return 12;
        }
        if (m748equalsimpl0(i, RAW10)) {
            return 10;
        }
        if (m748equalsimpl0(i, RAW12)) {
            return 12;
        }
        if (m748equalsimpl0(i, RAW_DEPTH) || m748equalsimpl0(i, RAW_SENSOR) || m748equalsimpl0(i, RGB_565)) {
            return 16;
        }
        if (m748equalsimpl0(i, Y12)) {
            return 12;
        }
        if (m748equalsimpl0(i, Y16)) {
            return 16;
        }
        if (m748equalsimpl0(i, Y8)) {
            return 8;
        }
        if (m748equalsimpl0(i, YCBCR_P010)) {
            return 16;
        }
        if (m748equalsimpl0(i, YUV_420_888)) {
            return 12;
        }
        if (m748equalsimpl0(i, YUV_422_888)) {
            return 16;
        }
        if (m748equalsimpl0(i, YUV_444_888)) {
            return 24;
        }
        if (m748equalsimpl0(i, YUY2)) {
            return 16;
        }
        return m748equalsimpl0(i, YV12) ? 12 : -1;
    }

    /* JADX INFO: renamed from: getName-impl, reason: not valid java name */
    public static final String m750getNameimpl(int i) {
        if (m748equalsimpl0(i, UNKNOWN)) {
            return "UNKNOWN";
        }
        if (m748equalsimpl0(i, PRIVATE)) {
            return "PRIVATE";
        }
        if (m748equalsimpl0(i, DEPTH16)) {
            return "DEPTH16";
        }
        if (m748equalsimpl0(i, DEPTH_JPEG)) {
            return "DEPTH_JPEG";
        }
        if (m748equalsimpl0(i, DEPTH_POINT_CLOUD)) {
            return "DEPTH_POINT_CLOUD";
        }
        if (m748equalsimpl0(i, FLEX_RGB_888)) {
            return "FLEX_RGB_888";
        }
        if (m748equalsimpl0(i, FLEX_RGBA_8888)) {
            return "FLEX_RGBA_8888";
        }
        if (m748equalsimpl0(i, HEIC)) {
            return "HEIC";
        }
        if (m748equalsimpl0(i, JPEG)) {
            return "JPEG";
        }
        if (m748equalsimpl0(i, JPEG_R)) {
            return "JPEG_R";
        }
        if (m748equalsimpl0(i, NV16)) {
            return "NV16";
        }
        if (m748equalsimpl0(i, NV21)) {
            return "NV21";
        }
        if (m748equalsimpl0(i, RAW10)) {
            return "RAW10";
        }
        if (m748equalsimpl0(i, RAW12)) {
            return "RAW12";
        }
        if (m748equalsimpl0(i, RAW_DEPTH)) {
            return "RAW_DEPTH";
        }
        if (m748equalsimpl0(i, RAW_PRIVATE)) {
            return "RAW_PRIVATE";
        }
        if (m748equalsimpl0(i, RAW_SENSOR)) {
            return "RAW_SENSOR";
        }
        if (m748equalsimpl0(i, RGB_565)) {
            return "RGB_565";
        }
        if (m748equalsimpl0(i, Y12)) {
            return "Y12";
        }
        if (m748equalsimpl0(i, Y16)) {
            return "Y16";
        }
        if (m748equalsimpl0(i, Y8)) {
            return "Y8";
        }
        if (m748equalsimpl0(i, YCBCR_P010)) {
            return "YCBCR_P010";
        }
        if (m748equalsimpl0(i, YUV_420_888)) {
            return "YUV_420_888";
        }
        if (m748equalsimpl0(i, YUV_422_888)) {
            return "YUV_422_888";
        }
        if (m748equalsimpl0(i, YUV_444_888)) {
            return "YUV_444_888";
        }
        if (m748equalsimpl0(i, YUY2)) {
            return "YUY2";
        }
        if (m748equalsimpl0(i, YV12)) {
            return "YV12";
        }
        StringBuilder sb = new StringBuilder("UNKNOWN(");
        String string = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append(')');
        return sb.toString();
    }
}
