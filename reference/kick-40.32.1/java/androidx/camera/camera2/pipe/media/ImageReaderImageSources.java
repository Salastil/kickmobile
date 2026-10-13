package androidx.camera.camera2.pipe.media;

import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ImageSourceConfig;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.PlatformApiCompat;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageReaderImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JA\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderImageSources;", "Landroidx/camera/camera2/pipe/media/ImageSources;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeConfig", "Landroidx/camera/camera2/pipe/CameraPipe$Config;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraPipe$Config;)V", "platformApiCompat", "Landroidx/camera/camera2/pipe/PlatformApiCompat;", "createImageSource", "Landroidx/camera/camera2/pipe/media/ImageSource;", "cameraStream", "Landroidx/camera/camera2/pipe/CameraStream;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/ImageSourceConfig;", "create", "capacity", "", "usageFlags", "", "defaultDataSpace", "defaultHardwareBufferFormat", "enableConcurrentOutputs", "", "(Landroidx/camera/camera2/pipe/CameraStream;ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Z)Landroidx/camera/camera2/pipe/media/ImageSource;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageReaderImageSources implements ImageSources {
    private final PlatformApiCompat platformApiCompat;
    private final Threads threads;

    @Inject
    public ImageReaderImageSources(Threads threads, CameraPipe.Config cameraPipeConfig) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraPipeConfig, "cameraPipeConfig");
        this.threads = threads;
        this.platformApiCompat = cameraPipeConfig.getPlatformApiCompat();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSources
    public ImageSource createImageSource(CameraStream cameraStream, ImageSourceConfig imageSourceConfig) {
        Intrinsics.checkNotNullParameter(cameraStream, "cameraStream");
        Intrinsics.checkNotNullParameter(imageSourceConfig, "imageSourceConfig");
        return create(cameraStream, imageSourceConfig.getCapacity(), imageSourceConfig.getUsageFlags(), imageSourceConfig.getDefaultDataSpace(), imageSourceConfig.getDefaultHardwareBufferFormat(), imageSourceConfig.getEnableConcurrentOutputs());
    }

    public final ImageSource create(CameraStream cameraStream, int capacity, Long usageFlags, Integer defaultDataSpace, Integer defaultHardwareBufferFormat, boolean enableConcurrentOutputs) {
        Long l;
        Intrinsics.checkNotNullParameter(cameraStream, "cameraStream");
        if (cameraStream.getOutputs().isEmpty()) {
            throw new IllegalArgumentException((cameraStream + " must have outputs.").toString());
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException(("Capacity (" + capacity + ") must be > 0").toString());
        }
        if (capacity > 52) {
            throw new IllegalArgumentException("Capacity for creating new ImageReaderImageSources is restricted to 52. Android has undocumented internal limits that can vary per device.".toString());
        }
        if (enableConcurrentOutputs && cameraStream.getOutputs().size() <= 1) {
            throw new IllegalStateException("Cannot enable concurrent outputs for a single output camera stream.".toString());
        }
        Function0 function0 = new Function0() { // from class: androidx.camera.camera2.pipe.media.ImageReaderImageSources$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.threads.getCamera2Handler();
            }
        };
        Function0 function1 = new Function0() { // from class: androidx.camera.camera2.pipe.media.ImageReaderImageSources$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.threads.getLightweightExecutor();
            }
        };
        int i = capacity + 2;
        if (cameraStream.getOutputs().size() == 1) {
            OutputStream outputStream = (OutputStream) CollectionsKt.single((List) cameraStream.getOutputs());
            return ImageReaderImageSource.INSTANCE.create(AndroidImageReader.INSTANCE.m1052createfE0t4g(outputStream.getSize().getWidth(), outputStream.getSize().getHeight(), outputStream.getFormat(), i, usageFlags, defaultDataSpace, defaultHardwareBufferFormat, cameraStream.getId(), outputStream.getId(), (Handler) function0.invoke()));
        }
        if (Build.VERSION.SDK_INT < 31) {
            throw new IllegalStateException("Failed to create an ImageSource for " + cameraStream + '!');
        }
        if (usageFlags == null || Build.VERSION.SDK_INT < 36) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring usageFlags (" + usageFlags + ") for " + cameraStream + ". MultiResolutionImageReader does not support setting usage flags.");
            }
            l = null;
        } else {
            l = usageFlags;
        }
        if (defaultDataSpace != null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Ignoring DataSpace (" + defaultDataSpace.intValue() + ") for " + cameraStream + ". MultiResolutionImageReader does not support setting the default DataSpace.");
        }
        if (defaultHardwareBufferFormat != null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Ignoring HardwareBufferFormat (" + defaultHardwareBufferFormat.intValue() + ") for " + cameraStream + ". MultiResolutionImageReader does not support setting the default HardwareBufferFormat.");
        }
        return ImageReaderImageSource.INSTANCE.create(AndroidMultiResolutionImageReader.INSTANCE.create(cameraStream, capacity, (Executor) function1.invoke(), l, enableConcurrentOutputs, this.platformApiCompat));
    }
}
