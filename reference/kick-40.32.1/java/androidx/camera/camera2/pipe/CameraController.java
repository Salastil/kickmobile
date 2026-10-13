package androidx.camera.camera2.pipe;

import android.view.Surface;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaError;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: compiled from: CameraController.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u001eJ\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0010H&J\u000e\u0010\u0013\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H&J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\b\u001dR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController;", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "getCameraGraphId", "()Landroidx/camera/camera2/pipe/CameraGraphId;", "isForeground", "", "()Z", "setForeground", "(Z)V", ViewProps.START, "", "stop", "close", "awaitClosed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSurfaceMap", "surfaceMap", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "getOutputLatency", "Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "streamId", "getOutputLatency-n5Pu2dI", "ControllerState", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraController {
    default Object awaitClosed(Continuation<? super Boolean> continuation) {
        return awaitClosed$suspendImpl(this, continuation);
    }

    void close();

    CameraGraphId getCameraGraphId();

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name */
    String mo303getCameraIdDz_R5H8();

    /* JADX INFO: renamed from: getOutputLatency-n5Pu2dI, reason: not valid java name */
    StreamGraph.OutputLatency mo304getOutputLatencyn5Pu2dI(StreamId streamId);

    boolean isForeground();

    void setForeground(boolean z);

    void start();

    void stop();

    void updateSurfaceMap(Map<StreamId, ? extends Surface> surfaceMap);

    static /* synthetic */ Object awaitClosed$suspendImpl(CameraController cameraController, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: compiled from: CameraController.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "", "<init>", "()V", "STARTED", "STOPPING", "STOPPED", "DISCONNECTED", MediaError.ERROR_TYPE_ERROR, "CLOSING", "CLOSED", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ControllerState {

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$STARTED;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class STARTED extends ControllerState {
            public static final STARTED INSTANCE = new STARTED();

            private STARTED() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$STOPPING;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class STOPPING extends ControllerState {
            public static final STOPPING INSTANCE = new STOPPING();

            private STOPPING() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$STOPPED;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class STOPPED extends ControllerState {
            public static final STOPPED INSTANCE = new STOPPED();

            private STOPPED() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$DISCONNECTED;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DISCONNECTED extends ControllerState {
            public static final DISCONNECTED INSTANCE = new DISCONNECTED();

            private DISCONNECTED() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$ERROR;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ERROR extends ControllerState {
            public static final ERROR INSTANCE = new ERROR();

            private ERROR() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$CLOSING;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CLOSING extends ControllerState {
            public static final CLOSING INSTANCE = new CLOSING();

            private CLOSING() {
            }
        }

        /* JADX INFO: compiled from: CameraController.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/CameraController$ControllerState$CLOSED;", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CLOSED extends ControllerState {
            public static final CLOSED INSTANCE = new CLOSED();

            private CLOSED() {
            }
        }
    }
}
