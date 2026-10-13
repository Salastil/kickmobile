package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraExtensionSession$StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0007J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\t\u001a\u00020\nH\u0007J0\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u000e2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010,\u001a\u00020!H\u0007J&\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00072\u0006\u0010,\u001a\u00020!2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0007J*\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00072\u0006\u0010,\u001a\u00020!2\u0006\u0010/\u001a\u00020\u000e2\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0007¨\u00063"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api31Compat;", "", "<init>", "()V", "newInputConfiguration", "Landroid/hardware/camera2/params/InputConfiguration;", "inputConfigData", "", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "cameraId", "", "newMultiResolutionStreamInfo", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "streamWidth", "", "streamHeight", "physicalCameraId", "getPhysicalCameraTotalResults", "", "Landroid/hardware/camera2/CaptureResult;", "totalCaptureResult", "Landroid/hardware/camera2/TotalCaptureResult;", "addSensorPixelModeUsed", "", "outputConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "sensorPixelMode", "createExtensionCaptureSession", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "extensionConfiguration", "Landroid/hardware/camera2/params/ExtensionSessionConfiguration;", "getCameraExtensionCharacteristics", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "newExtensionSessionConfiguration", "extensionMode", "outputs", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Landroid/hardware/camera2/CameraExtensionSession$StateCallback;", "getSupportedExtensions", "extensionCharacteristics", "getExtensionSupportedSizes", "Landroid/util/Size;", "extension", "imageFormat", "klass", "Ljava/lang/Class;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api31Compat {
    public static final Api31Compat INSTANCE = new Api31Compat();

    private Api31Compat() {
    }

    @JvmStatic
    public static final InputConfiguration newInputConfiguration(List<InputConfigData> inputConfigData, String cameraId) {
        Intrinsics.checkNotNullParameter(inputConfigData, "inputConfigData");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (inputConfigData.isEmpty()) {
            throw new IllegalStateException("Call to create InputConfiguration but list of InputConfigData is empty.".toString());
        }
        if (inputConfigData.size() == 1) {
            InputConfigData inputConfigData2 = (InputConfigData) CollectionsKt.first((List) inputConfigData);
            return new InputConfiguration(inputConfigData2.getWidth(), inputConfigData2.getHeight(), inputConfigData2.getFormat());
        }
        List<InputConfigData> list = inputConfigData;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InputConfigData inputConfigData3 : list) {
            CameraColorSpace$$ExternalSyntheticApiModelOutline6.m274m$1();
            arrayList.add(CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(inputConfigData3.getWidth(), inputConfigData3.getHeight(), cameraId));
        }
        CameraColorSpace$$ExternalSyntheticApiModelOutline6.m265m();
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(arrayList, ((InputConfigData) CollectionsKt.first((List) inputConfigData)).getFormat());
    }

    @JvmStatic
    public static final MultiResolutionStreamInfo newMultiResolutionStreamInfo(int streamWidth, int streamHeight, String physicalCameraId) {
        Intrinsics.checkNotNullParameter(physicalCameraId, "physicalCameraId");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(streamWidth, streamHeight, physicalCameraId);
    }

    @JvmStatic
    public static final Map<String, CaptureResult> getPhysicalCameraTotalResults(TotalCaptureResult totalCaptureResult) {
        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        return totalCaptureResult.getPhysicalCameraTotalResults();
    }

    @JvmStatic
    public static final void addSensorPixelModeUsed(OutputConfiguration outputConfiguration, int sensorPixelMode) {
        Intrinsics.checkNotNullParameter(outputConfiguration, "outputConfiguration");
        outputConfiguration.addSensorPixelModeUsed(sensorPixelMode);
    }

    @JvmStatic
    public static final void createExtensionCaptureSession(CameraDevice cameraDevice, ExtensionSessionConfiguration extensionConfiguration) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(extensionConfiguration, "extensionConfiguration");
        cameraDevice.createExtensionSession(extensionConfiguration);
    }

    @JvmStatic
    public static final CameraExtensionCharacteristics getCameraExtensionCharacteristics(CameraManager cameraManager, String cameraId) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        CameraExtensionCharacteristics cameraExtensionCharacteristics = cameraManager.getCameraExtensionCharacteristics(cameraId);
        Intrinsics.checkNotNullExpressionValue(cameraExtensionCharacteristics, "getCameraExtensionCharacteristics(...)");
        return cameraExtensionCharacteristics;
    }

    @JvmStatic
    public static final ExtensionSessionConfiguration newExtensionSessionConfiguration(int extensionMode, List<OutputConfiguration> outputs, Executor executor, CameraExtensionSession$StateCallback stateCallback) {
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(extensionMode, outputs, executor, stateCallback);
    }

    @JvmStatic
    public static final List<Integer> getSupportedExtensions(CameraExtensionCharacteristics extensionCharacteristics) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        List<Integer> supportedExtensions = extensionCharacteristics.getSupportedExtensions();
        Intrinsics.checkNotNullExpressionValue(supportedExtensions, "getSupportedExtensions(...)");
        return supportedExtensions;
    }

    @JvmStatic
    public static final List<Size> getExtensionSupportedSizes(CameraExtensionCharacteristics extensionCharacteristics, int extension, int imageFormat) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        List<Size> extensionSupportedSizes = extensionCharacteristics.getExtensionSupportedSizes(extension, imageFormat);
        Intrinsics.checkNotNullExpressionValue(extensionSupportedSizes, "getExtensionSupportedSizes(...)");
        return extensionSupportedSizes;
    }

    @JvmStatic
    public static final List<Size> getExtensionSupportedSizes(CameraExtensionCharacteristics extensionCharacteristics, int extension, Class<?> klass) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        Intrinsics.checkNotNullParameter(klass, "klass");
        List<Size> extensionSupportedSizes = extensionCharacteristics.getExtensionSupportedSizes(extension, klass);
        Intrinsics.checkNotNullExpressionValue(extensionSupportedSizes, "getExtensionSupportedSizes(...)");
        return extensionSupportedSizes;
    }
}
