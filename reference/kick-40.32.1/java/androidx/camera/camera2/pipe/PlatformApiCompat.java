package androidx.camera.camera2.pipe;

import android.hardware.camera2.MultiResolutionImageReader;
import android.hardware.camera2.params.MultiResolutionStreamConfigurationMap;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Collection;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J?\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/PlatformApiCompat;", "", "isMultiResolutionConcurrentReadersEnabled", "", "isConcurrentReadersSupported", "multiResolutionStreamConfigurationMap", "Landroid/hardware/camera2/params/MultiResolutionStreamConfigurationMap;", "format", "", "buildMultiResolutionImageReader", "Landroid/hardware/camera2/MultiResolutionImageReader;", "streams", "", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "maxImages", "usage", "", "concurrentOutputsEnabled", "(Ljava/util/Collection;IILjava/lang/Long;Ljava/lang/Boolean;)Landroid/hardware/camera2/MultiResolutionImageReader;", "setOnActiveOutputSurfacesListener", "", "multiResolutionImageReader", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/CameraOnActiveOutputSurfacesListener;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PlatformApiCompat {
    default boolean isMultiResolutionConcurrentReadersEnabled() {
        return false;
    }

    default boolean isConcurrentReadersSupported(MultiResolutionStreamConfigurationMap multiResolutionStreamConfigurationMap, int format) {
        Intrinsics.checkNotNullParameter(multiResolutionStreamConfigurationMap, "multiResolutionStreamConfigurationMap");
        throw new UnsupportedOperationException("API not supported on current platform");
    }

    default MultiResolutionImageReader buildMultiResolutionImageReader(Collection<? extends MultiResolutionStreamInfo> streams, int format, int maxImages, Long usage, Boolean concurrentOutputsEnabled) {
        Intrinsics.checkNotNullParameter(streams, "streams");
        throw new UnsupportedOperationException("API not supported on current platform");
    }

    default void setOnActiveOutputSurfacesListener(MultiResolutionImageReader multiResolutionImageReader, Executor executor, CameraOnActiveOutputSurfacesListener listener) {
        Intrinsics.checkNotNullParameter(multiResolutionImageReader, "multiResolutionImageReader");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw new UnsupportedOperationException("API not supported on current platform");
    }
}
