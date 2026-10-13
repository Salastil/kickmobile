package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0080\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"catchAndReportCameraExceptions", ExifInterface.GPS_DIRECTION_TRUE, "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "block", "Lkotlin/Function0;", "catchAndReportCameraExceptions-RzXb1QE", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExceptionsKt {
    /* JADX INFO: renamed from: catchAndReportCameraExceptions-RzXb1QE, reason: not valid java name */
    public static final <T> T m872catchAndReportCameraExceptionsRzXb1QE(String cameraId, CameraErrorListener cameraErrorListener, Function0<? extends T> block) throws Exception {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (Exception e) {
            if (!(e instanceof CameraAccessException)) {
                if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                    if (!(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                    }
                    return null;
                }
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                return null;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
            }
            cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
            return null;
        }
    }
}
