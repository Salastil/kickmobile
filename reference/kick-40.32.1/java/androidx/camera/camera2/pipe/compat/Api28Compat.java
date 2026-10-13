package androidx.camera.camera2.pipe.compat;

import android.hardware.HardwareBuffer;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\n\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001c\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001cH\u0007J\u001a\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0007J(\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0007J \u00103\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00101\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0007J/\u00108\u001a\u0004\u0018\u0001H9\"\b\b\u0000\u00109*\u00020\u00012\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H90=H\u0007¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010:\u001a\u00020;H\u0007¨\u0006A"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api28Compat;", "", "<init>", "()V", "createCaptureSession", "", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "sessionConfig", "Landroid/hardware/camera2/params/SessionConfiguration;", "getAvailablePhysicalCameraRequestKeys", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getAvailableSessionKeys", "getPhysicalCameraIds", "", "", "getPhysicalCaptureResults", "", "Landroid/hardware/camera2/CaptureResult;", "totalCaptureResult", "Landroid/hardware/camera2/TotalCaptureResult;", "newSessionConfiguration", "sessionType", "", "outputs", "Landroid/hardware/camera2/params/OutputConfiguration;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "setInputConfiguration", "inputConfig", "Landroid/hardware/camera2/params/InputConfiguration;", "setSessionParameters", "params", "Landroid/hardware/camera2/CaptureRequest;", "getMaxSharedSurfaceCount", "outputConfig", "setPhysicalCameraId", "cameraId", "removeSurface", "surface", "Landroid/view/Surface;", "openCamera", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "callback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "registerAvailabilityCallback", "Landroid/hardware/camera2/CameraManager$AvailabilityCallback;", "discardFreeBuffers", "imageReader", "Landroid/media/ImageReader;", "unwrapAsHardwareBuffer", ExifInterface.GPS_DIRECTION_TRUE, "image", "Landroid/media/Image;", "type", "Lkotlin/reflect/KClass;", "(Landroid/media/Image;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getHardwareBuffer", "Landroid/hardware/HardwareBuffer;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api28Compat {
    public static final Api28Compat INSTANCE = new Api28Compat();

    private Api28Compat() {
    }

    @JvmStatic
    public static final void createCaptureSession(CameraDevice cameraDevice, SessionConfiguration sessionConfig) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        cameraDevice.createCaptureSession(sessionConfig);
    }

    @JvmStatic
    public static final List<CaptureRequest.Key<?>> getAvailablePhysicalCameraRequestKeys(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return cameraCharacteristics.getAvailablePhysicalCameraRequestKeys();
    }

    @JvmStatic
    public static final List<CaptureRequest.Key<?>> getAvailableSessionKeys(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return cameraCharacteristics.getAvailableSessionKeys();
    }

    @JvmStatic
    public static final Set<String> getPhysicalCameraIds(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        Set<String> physicalCameraIds = cameraCharacteristics.getPhysicalCameraIds();
        Intrinsics.checkNotNullExpressionValue(physicalCameraIds, "getPhysicalCameraIds(...)");
        return physicalCameraIds;
    }

    @JvmStatic
    public static final Map<String, CaptureResult> getPhysicalCaptureResults(TotalCaptureResult totalCaptureResult) {
        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        return totalCaptureResult.getPhysicalCameraResults();
    }

    @JvmStatic
    public static final SessionConfiguration newSessionConfiguration(int sessionType, List<OutputConfiguration> outputs, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(sessionType, outputs, executor, stateCallback);
    }

    @JvmStatic
    public static final void setInputConfiguration(SessionConfiguration sessionConfig, InputConfiguration inputConfig) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        Intrinsics.checkNotNullParameter(inputConfig, "inputConfig");
        sessionConfig.setInputConfiguration(inputConfig);
    }

    @JvmStatic
    public static final void setSessionParameters(SessionConfiguration sessionConfig, CaptureRequest params) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        Intrinsics.checkNotNullParameter(params, "params");
        sessionConfig.setSessionParameters(params);
    }

    @JvmStatic
    public static final int getMaxSharedSurfaceCount(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        return outputConfig.getMaxSharedSurfaceCount();
    }

    @JvmStatic
    public static final void setPhysicalCameraId(OutputConfiguration outputConfig, String cameraId) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.setPhysicalCameraId(cameraId);
    }

    @JvmStatic
    public static final void removeSurface(OutputConfiguration outputConfig, Surface surface) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        Intrinsics.checkNotNullParameter(surface, "surface");
        outputConfig.removeSurface(surface);
    }

    @JvmStatic
    public static final void openCamera(CameraManager cameraManager, String cameraId, Executor executor, CameraDevice.StateCallback callback) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        cameraManager.openCamera(cameraId, executor, callback);
    }

    @JvmStatic
    public static final void registerAvailabilityCallback(CameraManager cameraManager, Executor executor, CameraManager.AvailabilityCallback callback) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        cameraManager.registerAvailabilityCallback(executor, callback);
    }

    @JvmStatic
    public static final void discardFreeBuffers(ImageReader imageReader) {
        Intrinsics.checkNotNullParameter(imageReader, "imageReader");
        imageReader.discardFreeBuffers();
    }

    @JvmStatic
    public static final <T> T unwrapAsHardwareBuffer(Image image, KClass<T> type) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraColorSpace$$ExternalSyntheticApiModelOutline6.m261m()))) {
            return (T) image.getHardwareBuffer();
        }
        return null;
    }

    @JvmStatic
    public static final HardwareBuffer getHardwareBuffer(Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return image.getHardwareBuffer();
    }
}
