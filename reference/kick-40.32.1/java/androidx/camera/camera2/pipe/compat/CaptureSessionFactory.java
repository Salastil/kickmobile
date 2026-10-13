package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.StreamId;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\fJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "", "create", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "surfaces", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "Result", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CaptureSessionFactory {
    Result create(CameraDeviceWrapper cameraDevice, Map<StreamId, ? extends Surface> surfaces, CaptureSessionState captureSessionState);

    /* JADX INFO: compiled from: CaptureSessionFactory.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "", "Success", "Failed", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result$Failed;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result$Success;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Result {

        /* JADX INFO: compiled from: CaptureSessionFactory.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result$Success;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "deferred", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "outputSurfaceMap", "Landroidx/camera/camera2/pipe/OutputId;", "Landroid/view/Surface;", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getDeferred", "()Ljava/util/Map;", "getOutputSurfaceMap", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success implements Result {
            private final Map<StreamId, OutputConfigurationWrapper> deferred;
            private final Map<OutputId, Surface> outputSurfaceMap;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, Map map, Map map2, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = success.deferred;
                }
                if ((i & 2) != 0) {
                    map2 = success.outputSurfaceMap;
                }
                return success.copy(map, map2);
            }

            public final Map<StreamId, OutputConfigurationWrapper> component1() {
                return this.deferred;
            }

            public final Map<OutputId, Surface> component2() {
                return this.outputSurfaceMap;
            }

            public final Success copy(Map<StreamId, ? extends OutputConfigurationWrapper> deferred, Map<OutputId, ? extends Surface> outputSurfaceMap) {
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                Intrinsics.checkNotNullParameter(outputSurfaceMap, "outputSurfaceMap");
                return new Success(deferred, outputSurfaceMap);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.deferred, success.deferred) && Intrinsics.areEqual(this.outputSurfaceMap, success.outputSurfaceMap);
            }

            public int hashCode() {
                return (this.deferred.hashCode() * 31) + this.outputSurfaceMap.hashCode();
            }

            public String toString() {
                return "Success(deferred=" + this.deferred + ", outputSurfaceMap=" + this.outputSurfaceMap + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Success(Map<StreamId, ? extends OutputConfigurationWrapper> deferred, Map<OutputId, ? extends Surface> outputSurfaceMap) {
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                Intrinsics.checkNotNullParameter(outputSurfaceMap, "outputSurfaceMap");
                this.deferred = deferred;
                this.outputSurfaceMap = outputSurfaceMap;
            }

            public final Map<StreamId, OutputConfigurationWrapper> getDeferred() {
                return this.deferred;
            }

            public final Map<OutputId, Surface> getOutputSurfaceMap() {
                return this.outputSurfaceMap;
            }
        }

        /* JADX INFO: compiled from: CaptureSessionFactory.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result$Failed;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Failed implements Result {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
            }
        }
    }
}
