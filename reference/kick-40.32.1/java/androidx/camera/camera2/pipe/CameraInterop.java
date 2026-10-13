package androidx.camera.camera2.pipe;

import android.view.Surface;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* JADX INFO: compiled from: CameraInterop.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/CameraInterop;", "", "<init>", "()V", "captureSessionIds", "Lkotlinx/atomicfu/AtomicInt;", "getCaptureSessionIds$annotations", "nextCameraCaptureSessionId", "Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "nextCameraCaptureSessionId-159jkk4$camera_camera2_pipe", "()I", "CaptureSessionListener", "CameraCaptureSessionId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraInterop {
    public static final CameraInterop INSTANCE = new CameraInterop();
    private static final AtomicInt captureSessionIds = AtomicFU.atomic(0);

    /* JADX INFO: compiled from: CameraInterop.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\tJ'\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "", "onConfigured", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "captureSessionId", "Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "onConfigured-rphkYDA", "(Ljava/lang/String;I)V", "onConfigureFailed", "onConfigureFailed-rphkYDA", "onReady", "onReady-rphkYDA", "onActive", "onActive-rphkYDA", "onCaptureQueueEmpty", "onCaptureQueueEmpty-rphkYDA", "onClosed", "onClosed-rphkYDA", "onSurfacePrepared", "surface", "Landroid/view/Surface;", "onSurfacePrepared-GyX_H3Q", "(Ljava/lang/String;ILandroid/view/Surface;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CaptureSessionListener {
        /* JADX INFO: renamed from: onActive-rphkYDA */
        void mo93onActiverphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onCaptureQueueEmpty-rphkYDA */
        void mo94onCaptureQueueEmptyrphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onClosed-rphkYDA */
        void mo95onClosedrphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onConfigureFailed-rphkYDA */
        void mo96onConfigureFailedrphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onConfigured-rphkYDA */
        void mo97onConfiguredrphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onReady-rphkYDA */
        void mo98onReadyrphkYDA(String cameraId, int captureSessionId);

        /* JADX INFO: renamed from: onSurfacePrepared-GyX_H3Q */
        void mo99onSurfacePreparedGyX_H3Q(String cameraId, int captureSessionId, Surface surface);
    }

    @JvmStatic
    private static /* synthetic */ void getCaptureSessionIds$annotations() {
    }

    private CameraInterop() {
    }

    /* JADX INFO: compiled from: CameraInterop.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class CameraCaptureSessionId {
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ CameraCaptureSessionId m437boximpl(int i) {
            return new CameraCaptureSessionId(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m438constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m439equalsimpl(int i, Object obj) {
            return (obj instanceof CameraCaptureSessionId) && i == ((CameraCaptureSessionId) obj).m443unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m440equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m441hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m442toStringimpl(int i) {
            return "CameraCaptureSessionId(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m439equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m441hashCodeimpl(this.value);
        }

        public String toString() {
            return m442toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m443unboximpl() {
            return this.value;
        }

        private /* synthetic */ CameraCaptureSessionId(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
