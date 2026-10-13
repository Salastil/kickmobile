package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.ImageReader;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraMetadata;
import com.facebook.react.uimanager.ViewProps;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0007J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0007J$\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010 0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0007J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0014JY\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010,¨\u0006-"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api33Compat;", "", "<init>", "()V", "setDynamicRangeProfile", "", "outputConfig", "Landroid/hardware/camera2/params/OutputConfiguration;", "dynamicRangeProfile", "", "getDynamicRangeProfile", "setMirrorMode", "mirrorMode", "", "getMirrorMode", "setStreamUseCase", "streamUseCase", "getAvailableStreamUseCases", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "getStreamUseCase", "setTimestampBase", "timestampBase", "getTimestampBase", "getAvailableCaptureRequestKeys", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "extensionCharacteristics", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extension", "getAvailableCaptureResultKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "supportsPreviewStabilization", "", "newImageReaderFromImageReaderBuilder", "Landroid/media/ImageReader;", ViewProps.WIDTH, ViewProps.HEIGHT, "imageFormat", "maxImages", "usage", "defaultDataSpace", "defaultHardwareBufferFormat", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/media/ImageReader;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api33Compat {
    public static final Api33Compat INSTANCE = new Api33Compat();

    private Api33Compat() {
    }

    @JvmStatic
    public static final void setDynamicRangeProfile(OutputConfiguration outputConfig, long dynamicRangeProfile) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.setDynamicRangeProfile(dynamicRangeProfile);
    }

    @JvmStatic
    public static final long getDynamicRangeProfile(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        return outputConfig.getDynamicRangeProfile();
    }

    @JvmStatic
    public static final void setMirrorMode(OutputConfiguration outputConfig, int mirrorMode) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.setMirrorMode(mirrorMode);
    }

    @JvmStatic
    public static final int getMirrorMode(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        return outputConfig.getMirrorMode();
    }

    @JvmStatic
    public static final void setStreamUseCase(OutputConfiguration outputConfig, long streamUseCase) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.setStreamUseCase(streamUseCase);
    }

    @JvmStatic
    public static final long[] getAvailableStreamUseCases(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        return (long[]) cameraMetadata.get(SCALER_AVAILABLE_STREAM_USE_CASES);
    }

    @JvmStatic
    public static final long getStreamUseCase(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        return outputConfig.getStreamUseCase();
    }

    @JvmStatic
    public static final void setTimestampBase(OutputConfiguration outputConfig, int timestampBase) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.setTimestampBase(timestampBase);
    }

    @JvmStatic
    public static final int getTimestampBase(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        return outputConfig.getTimestampBase();
    }

    @JvmStatic
    public static final Set<CaptureRequest.Key<Object>> getAvailableCaptureRequestKeys(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        Set<CaptureRequest.Key<Object>> availableCaptureRequestKeys = extensionCharacteristics.getAvailableCaptureRequestKeys(extension);
        Intrinsics.checkNotNullExpressionValue(availableCaptureRequestKeys, "getAvailableCaptureRequestKeys(...)");
        return availableCaptureRequestKeys;
    }

    @JvmStatic
    public static final Set<CaptureResult.Key<Object>> getAvailableCaptureResultKeys(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        Set<CaptureResult.Key<Object>> availableCaptureResultKeys = extensionCharacteristics.getAvailableCaptureResultKeys(extension);
        Intrinsics.checkNotNullExpressionValue(availableCaptureResultKeys, "getAvailableCaptureResultKeys(...)");
        return availableCaptureResultKeys;
    }

    public final boolean supportsPreviewStabilization(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        return ArraysKt.contains(CameraMetadata.INSTANCE.getAvailableVideoStabilizationModes(cameraMetadata), 2);
    }

    public static /* synthetic */ ImageReader newImageReaderFromImageReaderBuilder$default(int i, int i2, Integer num, Integer num2, Long l, Integer num3, Integer num4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            num2 = null;
        }
        if ((i3 & 16) != 0) {
            l = null;
        }
        if ((i3 & 32) != 0) {
            num3 = null;
        }
        if ((i3 & 64) != 0) {
            num4 = null;
        }
        return newImageReaderFromImageReaderBuilder(i, i2, num, num2, l, num3, num4);
    }

    @JvmStatic
    public static final ImageReader newImageReaderFromImageReaderBuilder(int width, int height, Integer imageFormat, Integer maxImages, Long usage, Integer defaultDataSpace, Integer defaultHardwareBufferFormat) {
        ImageReader.Builder builderM = CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(width, height);
        if (imageFormat != null) {
            builderM.setImageFormat(imageFormat.intValue());
        }
        if (maxImages != null) {
            builderM.setMaxImages(maxImages.intValue());
        }
        if (usage != null) {
            builderM.setUsage(usage.longValue());
        }
        if (defaultDataSpace != null) {
            builderM.setDefaultDataSpace(defaultDataSpace.intValue());
        }
        if (defaultHardwareBufferFormat != null) {
            builderM.setDefaultHardwareBufferFormat(defaultHardwareBufferFormat.intValue());
        }
        ImageReader imageReaderBuild = builderM.build();
        Intrinsics.checkNotNullExpressionValue(imageReaderBuild, "build(...)");
        return imageReaderBuild;
    }
}
