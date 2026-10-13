package androidx.camera.camera2.pipe;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.ColorSpaceProfiles;
import android.hardware.camera2.params.MultiResolutionStreamConfigurationMap;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.camera2.pipe.compat.Api33Compat;
import androidx.camera.camera2.pipe.compat.Api34Compat;
import androidx.camera.camera2.pipe.compat.Api35Compat;
import androidx.camera.camera2.pipe.compat.Camera2ColorSpaceProfiles;
import androidx.camera.camera2.pipe.compat.Camera2MultiResolutionStreamConfigurationMap;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import defpackage.Camera2StreamConfigurationMap;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CameraMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013J$\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\nJ\u0018\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\fH¦@¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\fH&¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%H¦@¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020/2\u0006\u00100\u001a\u00020%H&R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u001c\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u001c\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0015R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00064À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraMetadata;", "Landroidx/camera/camera2/pipe/Metadata;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "isRedacted", "", "()Z", UserMetadata.KEYDATA_FILENAME, "", "getKeys", "()Ljava/util/Set;", "requestKeys", "Landroid/hardware/camera2/CaptureRequest$Key;", "getRequestKeys", "resultKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "getResultKeys", "sessionKeys", "getSessionKeys", "sessionCharacteristicsKeys", "getSessionCharacteristicsKeys", "physicalCameraIds", "getPhysicalCameraIds", "physicalRequestKeys", "getPhysicalRequestKeys", "supportedExtensions", "", "getSupportedExtensions", "getPhysicalMetadata", "cameraId", "getPhysicalMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPhysicalMetadata", "awaitPhysicalMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "getExtensionMetadata", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "extension", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitExtensionMetadata", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraMetadata extends Metadata, UnsafeWrapper {
    public static final int CAPABILITIES_BURST_CAPTURE = 6;
    public static final int CAPABILITIES_COLOR_SPACE_PROFILES = 20;
    public static final int CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO = 9;
    public static final int CAPABILITIES_DEPTH_OUTPUT = 8;
    public static final int CAPABILITIES_DYNAMIC_RANGE_TEN_BIT = 18;
    public static final int CAPABILITIES_LOGICAL_MULTI_CAMERA = 11;
    public static final int CAPABILITIES_MANUAL_POST_PROCESSING = 2;
    public static final int CAPABILITIES_MANUAL_SENSOR = 1;
    public static final int CAPABILITIES_MONOCHROME = 12;
    public static final int CAPABILITIES_MOTION_TRACKING = 10;
    public static final int CAPABILITIES_OFFLINE_REPROCESSING = 15;
    public static final int CAPABILITIES_PRIVATE_REPROCESSING = 4;
    public static final int CAPABILITIES_RAW = 3;
    public static final int CAPABILITIES_READ_SENSOR_SETTINGS = 5;
    public static final int CAPABILITIES_REMOSAIC_REPROCESSING = 17;
    public static final int CAPABILITIES_SECURE_IMAGE_DATA = 13;
    public static final int CAPABILITIES_STREAM_USE_CASE = 19;
    public static final int CAPABILITIES_SYSTEM_CAMERA = 14;
    public static final int CAPABILITIES_ULTRA_HIGH_RESOLUTION_SENSOR = 16;
    public static final int CAPABILITIES_YUV_REPROCESSING = 7;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static int[] getAvailableCapabilities(CameraMetadata cameraMetadata) {
        return INSTANCE.getAvailableCapabilities(cameraMetadata);
    }

    @JvmStatic
    static CameraColorSpaceProfiles getAvailableColorSpaceProfiles(CameraMetadata cameraMetadata) {
        return INSTANCE.getAvailableColorSpaceProfiles(cameraMetadata);
    }

    @JvmStatic
    static int[] getAvailableVideoStabilizationModes(CameraMetadata cameraMetadata) {
        return INSTANCE.getAvailableVideoStabilizationModes(cameraMetadata);
    }

    static Metadata.Key<CameraColorSpaceProfiles> getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES() {
        return INSTANCE.getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES();
    }

    static Metadata.Key<CameraMultiResolutionStreamConfigurationMap> getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP() {
        return INSTANCE.getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP();
    }

    static Metadata.Key<CameraStreamConfigurationMap> getCAMERA_STREAM_CONFIGURATION_MAP() {
        return INSTANCE.getCAMERA_STREAM_CONFIGURATION_MAP();
    }

    @JvmStatic
    static int getDefaultTorchStrengthLevel(CameraMetadata cameraMetadata) {
        return INSTANCE.getDefaultTorchStrengthLevel(cameraMetadata);
    }

    @JvmStatic
    static int getMaxTorchStrengthLevel(CameraMetadata cameraMetadata) {
        return INSTANCE.getMaxTorchStrengthLevel(cameraMetadata);
    }

    @JvmStatic
    static CameraMultiResolutionStreamConfigurationMap getMultiResolutionStreamConfigurationMap(CameraMetadata cameraMetadata) {
        return INSTANCE.getMultiResolutionStreamConfigurationMap(cameraMetadata);
    }

    @JvmStatic
    static CameraStreamConfigurationMap getStreamConfigurationMap(CameraMetadata cameraMetadata) {
        return INSTANCE.getStreamConfigurationMap(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsAutoFocusTrigger(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsAutoFocusTrigger(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsBurstCapture(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsBurstCapture(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsColorSpaceProfiles(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsColorSpaceProfiles(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsDepthOutput(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsDepthOutput(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsDynamicRangeTenBit(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsDynamicRangeTenBit(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsHighSpeedVideo(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsHighSpeedVideo(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsLogicalMultiCamera(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsLogicalMultiCamera(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsLowLightBoost(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsLowLightBoost(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsManualPostProcessing(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsManualPostProcessing(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsManualSensor(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsManualSensor(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsMonochrome(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsMonochrome(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsMotionTracking(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsMotionTracking(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsOfflineReprocessing(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsOfflineReprocessing(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsPreviewStabilization(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsPreviewStabilization(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsPrivateReprocessing(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsPrivateReprocessing(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsRaw(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsRaw(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsRemosaicProcessing(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsRemosaicProcessing(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsSecureImageData(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsSecureImageData(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsSensorSettings(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsSensorSettings(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsStreamUseCase(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsStreamUseCase(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsSystemCamera(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsSystemCamera(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsTorchStrength(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsTorchStrength(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsUltraHighResolutionSensor(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsUltraHighResolutionSensor(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsYuvReprocessing(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsYuvReprocessing(cameraMetadata);
    }

    @JvmStatic
    static boolean getSupportsZoomOverride(CameraMetadata cameraMetadata) {
        return INSTANCE.getSupportsZoomOverride(cameraMetadata);
    }

    @JvmStatic
    static boolean isHardwareLevel3(CameraMetadata cameraMetadata) {
        return INSTANCE.isHardwareLevel3(cameraMetadata);
    }

    @JvmStatic
    static boolean isHardwareLevelExternal(CameraMetadata cameraMetadata) {
        return INSTANCE.isHardwareLevelExternal(cameraMetadata);
    }

    @JvmStatic
    static boolean isHardwareLevelFull(CameraMetadata cameraMetadata) {
        return INSTANCE.isHardwareLevelFull(cameraMetadata);
    }

    @JvmStatic
    static boolean isHardwareLevelLegacy(CameraMetadata cameraMetadata) {
        return INSTANCE.isHardwareLevelLegacy(cameraMetadata);
    }

    @JvmStatic
    static boolean isHardwareLevelLimited(CameraMetadata cameraMetadata) {
        return INSTANCE.isHardwareLevelLimited(cameraMetadata);
    }

    CameraExtensionMetadata awaitExtensionMetadata(int extension);

    /* JADX INFO: renamed from: awaitPhysicalMetadata-EfqyGwQ, reason: not valid java name */
    CameraMetadata mo444awaitPhysicalMetadataEfqyGwQ(String cameraId);

    <T> T get(CameraCharacteristics.Key<T> key);

    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name */
    String mo445getCameraDz_R5H8();

    Object getExtensionMetadata(int i, Continuation<? super CameraExtensionMetadata> continuation);

    Set<CameraCharacteristics.Key<?>> getKeys();

    <T> T getOrDefault(CameraCharacteristics.Key<T> key, T t);

    Set<CameraId> getPhysicalCameraIds();

    /* JADX INFO: renamed from: getPhysicalMetadata-0r8Bogc, reason: not valid java name */
    Object mo446getPhysicalMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation);

    Set<CaptureRequest.Key<?>> getPhysicalRequestKeys();

    Set<CaptureRequest.Key<?>> getRequestKeys();

    Set<CaptureResult.Key<?>> getResultKeys();

    Set<CameraCharacteristics.Key<?>> getSessionCharacteristicsKeys();

    Set<CaptureRequest.Key<?>> getSessionKeys();

    Set<Integer> getSupportedExtensions();

    boolean isRedacted();

    /* JADX INFO: compiled from: CameraMetadata.kt */
    @kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bF\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u0015\u0010-\u001a\u00020\u0013*\u00020.8G¢\u0006\u0006\u001a\u0004\b/\u00100R\u0015\u00101\u001a\u00020\u0013*\u00020.8G¢\u0006\u0006\u001a\u0004\b2\u00100R\u0015\u00103\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b3\u00105R\u0015\u00106\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b6\u00105R\u0015\u00107\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b7\u00105R\u0015\u00108\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b8\u00105R\u0015\u00109\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b9\u00105R\u0015\u0010:\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b;\u00105R\u0015\u0010<\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b=\u00105R\u0015\u0010>\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b?\u00105R\u0015\u0010@\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bA\u00105R\u0015\u0010B\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bC\u00105R\u0015\u0010D\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bE\u00105R\u0015\u0010F\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bG\u00105R\u0015\u0010H\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bI\u00105R\u0015\u0010J\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bK\u00105R\u0015\u0010L\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bM\u00105R\u0015\u0010N\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bO\u00105R\u0015\u0010P\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bQ\u00105R\u0015\u0010R\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bS\u00105R\u0015\u0010T\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bU\u00105R\u0015\u0010V\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bW\u00105R\u0015\u0010X\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bY\u00105R\u0015\u0010Z\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b[\u00105R\u0015\u0010\\\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b]\u00105R\u0015\u0010^\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\b_\u00105R\u0015\u0010`\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\ba\u00105R\u0017\u0010b\u001a\u0004\u0018\u00010\u000f*\u00020.8G¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0017\u0010e\u001a\u0004\u0018\u00010\u0006*\u00020.8G¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0017\u0010h\u001a\u0004\u0018\u00010\u000b*\u00020.8G¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0015\u0010k\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bl\u00105R\u0015\u0010m\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bn\u00105R\u0015\u0010o\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bp\u00105R\u0015\u0010q\u001a\u00020\u0019*\u00020.8G¢\u0006\u0006\u001a\u0004\br\u0010sR\u0015\u0010t\u001a\u00020\u0019*\u00020.8G¢\u0006\u0006\u001a\u0004\bu\u0010sR\u0015\u0010v\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\bw\u00105R\u0015\u0010x\u001a\u000204*\u00020.8G¢\u0006\u0006\u001a\u0004\by\u00105¨\u0006z"}, d2 = {"Landroidx/camera/camera2/pipe/CameraMetadata$Companion;", "", "<init>", "()V", "CAMERA_STREAM_CONFIGURATION_MAP", "Landroidx/camera/camera2/pipe/Metadata$Key;", "Landroidx/camera/camera2/pipe/CameraStreamConfigurationMap;", "getCAMERA_STREAM_CONFIGURATION_MAP$annotations", "getCAMERA_STREAM_CONFIGURATION_MAP", "()Landroidx/camera/camera2/pipe/Metadata$Key;", "CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP", "Landroidx/camera/camera2/pipe/CameraMultiResolutionStreamConfigurationMap;", "getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP$annotations", "getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP", "CAMERA_AVAILABLE_COLOR_SPACE_PROFILES", "Landroidx/camera/camera2/pipe/CameraColorSpaceProfiles;", "getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES$annotations", "getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES", "EMPTY_INT_ARRAY", "", "getEMPTY_INT_ARRAY", "()[I", "setEMPTY_INT_ARRAY", "([I)V", "CAPABILITIES_MANUAL_SENSOR", "", "CAPABILITIES_MANUAL_POST_PROCESSING", "CAPABILITIES_RAW", "CAPABILITIES_PRIVATE_REPROCESSING", "CAPABILITIES_READ_SENSOR_SETTINGS", "CAPABILITIES_BURST_CAPTURE", "CAPABILITIES_YUV_REPROCESSING", "CAPABILITIES_DEPTH_OUTPUT", "CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO", "CAPABILITIES_MOTION_TRACKING", "CAPABILITIES_LOGICAL_MULTI_CAMERA", "CAPABILITIES_MONOCHROME", "CAPABILITIES_SECURE_IMAGE_DATA", "CAPABILITIES_SYSTEM_CAMERA", "CAPABILITIES_OFFLINE_REPROCESSING", "CAPABILITIES_ULTRA_HIGH_RESOLUTION_SENSOR", "CAPABILITIES_REMOSAIC_REPROCESSING", "CAPABILITIES_DYNAMIC_RANGE_TEN_BIT", "CAPABILITIES_STREAM_USE_CASE", "CAPABILITIES_COLOR_SPACE_PROFILES", "availableCapabilities", "Landroidx/camera/camera2/pipe/CameraMetadata;", "getAvailableCapabilities", "(Landroidx/camera/camera2/pipe/CameraMetadata;)[I", "availableVideoStabilizationModes", "getAvailableVideoStabilizationModes", "isHardwareLevelExternal", "", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Z", "isHardwareLevelLegacy", "isHardwareLevelLimited", "isHardwareLevelFull", "isHardwareLevel3", "supportsManualSensor", "getSupportsManualSensor", "supportsManualPostProcessing", "getSupportsManualPostProcessing", "supportsRaw", "getSupportsRaw", "supportsPrivateReprocessing", "getSupportsPrivateReprocessing", "supportsSensorSettings", "getSupportsSensorSettings", "supportsBurstCapture", "getSupportsBurstCapture", "supportsYuvReprocessing", "getSupportsYuvReprocessing", "supportsDepthOutput", "getSupportsDepthOutput", "supportsHighSpeedVideo", "getSupportsHighSpeedVideo", "supportsMotionTracking", "getSupportsMotionTracking", "supportsLogicalMultiCamera", "getSupportsLogicalMultiCamera", "supportsMonochrome", "getSupportsMonochrome", "supportsSecureImageData", "getSupportsSecureImageData", "supportsSystemCamera", "getSupportsSystemCamera", "supportsOfflineReprocessing", "getSupportsOfflineReprocessing", "supportsUltraHighResolutionSensor", "getSupportsUltraHighResolutionSensor", "supportsRemosaicProcessing", "getSupportsRemosaicProcessing", "supportsDynamicRangeTenBit", "getSupportsDynamicRangeTenBit", "supportsStreamUseCase", "getSupportsStreamUseCase", "supportsColorSpaceProfiles", "getSupportsColorSpaceProfiles", "availableColorSpaceProfiles", "getAvailableColorSpaceProfiles", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Landroidx/camera/camera2/pipe/CameraColorSpaceProfiles;", "streamConfigurationMap", "getStreamConfigurationMap", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Landroidx/camera/camera2/pipe/CameraStreamConfigurationMap;", "multiResolutionStreamConfigurationMap", "getMultiResolutionStreamConfigurationMap", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Landroidx/camera/camera2/pipe/CameraMultiResolutionStreamConfigurationMap;", "supportsAutoFocusTrigger", "getSupportsAutoFocusTrigger", "supportsZoomOverride", "getSupportsZoomOverride", "supportsTorchStrength", "getSupportsTorchStrength", "maxTorchStrengthLevel", "getMaxTorchStrengthLevel", "(Landroidx/camera/camera2/pipe/CameraMetadata;)I", "defaultTorchStrengthLevel", "getDefaultTorchStrengthLevel", "supportsLowLightBoost", "getSupportsLowLightBoost", "supportsPreviewStabilization", "getSupportsPreviewStabilization", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static final int CAPABILITIES_BURST_CAPTURE = 6;
        public static final int CAPABILITIES_COLOR_SPACE_PROFILES = 20;
        public static final int CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO = 9;
        public static final int CAPABILITIES_DEPTH_OUTPUT = 8;
        public static final int CAPABILITIES_DYNAMIC_RANGE_TEN_BIT = 18;
        public static final int CAPABILITIES_LOGICAL_MULTI_CAMERA = 11;
        public static final int CAPABILITIES_MANUAL_POST_PROCESSING = 2;
        public static final int CAPABILITIES_MANUAL_SENSOR = 1;
        public static final int CAPABILITIES_MONOCHROME = 12;
        public static final int CAPABILITIES_MOTION_TRACKING = 10;
        public static final int CAPABILITIES_OFFLINE_REPROCESSING = 15;
        public static final int CAPABILITIES_PRIVATE_REPROCESSING = 4;
        public static final int CAPABILITIES_RAW = 3;
        public static final int CAPABILITIES_READ_SENSOR_SETTINGS = 5;
        public static final int CAPABILITIES_REMOSAIC_REPROCESSING = 17;
        public static final int CAPABILITIES_SECURE_IMAGE_DATA = 13;
        public static final int CAPABILITIES_STREAM_USE_CASE = 19;
        public static final int CAPABILITIES_SYSTEM_CAMERA = 14;
        public static final int CAPABILITIES_ULTRA_HIGH_RESOLUTION_SENSOR = 16;
        public static final int CAPABILITIES_YUV_REPROCESSING = 7;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Metadata.Key<CameraStreamConfigurationMap> CAMERA_STREAM_CONFIGURATION_MAP = Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.scalar.streamConfigurationMap", Reflection.getOrCreateKotlinClass(CameraStreamConfigurationMap.class));
        private static final Metadata.Key<CameraMultiResolutionStreamConfigurationMap> CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP = Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.scalar.multiResolutionStreamConfigurationMap", Reflection.getOrCreateKotlinClass(CameraMultiResolutionStreamConfigurationMap.class));
        private static final Metadata.Key<CameraColorSpaceProfiles> CAMERA_AVAILABLE_COLOR_SPACE_PROFILES = Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.request.availableColorSpaceProfilesMap", Reflection.getOrCreateKotlinClass(CameraColorSpaceProfiles.class));
        private static int[] EMPTY_INT_ARRAY = new int[0];

        @JvmStatic
        public static /* synthetic */ void getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCAMERA_STREAM_CONFIGURATION_MAP$annotations() {
        }

        private Companion() {
        }

        public final Metadata.Key<CameraStreamConfigurationMap> getCAMERA_STREAM_CONFIGURATION_MAP() {
            return CAMERA_STREAM_CONFIGURATION_MAP;
        }

        public final Metadata.Key<CameraMultiResolutionStreamConfigurationMap> getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP() {
            return CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP;
        }

        public final Metadata.Key<CameraColorSpaceProfiles> getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES() {
            return CAMERA_AVAILABLE_COLOR_SPACE_PROFILES;
        }

        public final int[] getEMPTY_INT_ARRAY() {
            return EMPTY_INT_ARRAY;
        }

        public final void setEMPTY_INT_ARRAY(int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            EMPTY_INT_ARRAY = iArr;
        }

        @JvmStatic
        public final int[] getAvailableCapabilities(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
            Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
            int[] iArr = (int[]) cameraMetadata.get(REQUEST_AVAILABLE_CAPABILITIES);
            return iArr == null ? EMPTY_INT_ARRAY : iArr;
        }

        @JvmStatic
        public final int[] getAvailableVideoStabilizationModes(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES = CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, "CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES");
            int[] iArr = (int[]) cameraMetadata.get(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
            return iArr == null ? EMPTY_INT_ARRAY : iArr;
        }

        @JvmStatic
        public final boolean isHardwareLevelExternal(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) cameraMetadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 4;
        }

        @JvmStatic
        public final boolean isHardwareLevelLegacy(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) cameraMetadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 2;
        }

        @JvmStatic
        public final boolean isHardwareLevelLimited(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) cameraMetadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 0;
        }

        @JvmStatic
        public final boolean isHardwareLevelFull(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) cameraMetadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 1;
        }

        @JvmStatic
        public final boolean isHardwareLevel3(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) cameraMetadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 3;
        }

        @JvmStatic
        public final boolean getSupportsManualSensor(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 1);
        }

        @JvmStatic
        public final boolean getSupportsManualPostProcessing(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 2);
        }

        @JvmStatic
        public final boolean getSupportsRaw(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 3);
        }

        @JvmStatic
        public final boolean getSupportsPrivateReprocessing(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 4);
        }

        @JvmStatic
        public final boolean getSupportsSensorSettings(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 5);
        }

        @JvmStatic
        public final boolean getSupportsBurstCapture(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 6);
        }

        @JvmStatic
        public final boolean getSupportsYuvReprocessing(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 7);
        }

        @JvmStatic
        public final boolean getSupportsDepthOutput(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 8);
        }

        @JvmStatic
        public final boolean getSupportsHighSpeedVideo(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 9);
        }

        @JvmStatic
        public final boolean getSupportsMotionTracking(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 10);
        }

        @JvmStatic
        public final boolean getSupportsLogicalMultiCamera(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 11);
        }

        @JvmStatic
        public final boolean getSupportsMonochrome(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 12);
        }

        @JvmStatic
        public final boolean getSupportsSecureImageData(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 13);
        }

        @JvmStatic
        public final boolean getSupportsSystemCamera(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 14);
        }

        @JvmStatic
        public final boolean getSupportsOfflineReprocessing(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 15);
        }

        @JvmStatic
        public final boolean getSupportsUltraHighResolutionSensor(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 16);
        }

        @JvmStatic
        public final boolean getSupportsRemosaicProcessing(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 17);
        }

        @JvmStatic
        public final boolean getSupportsDynamicRangeTenBit(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 18);
        }

        @JvmStatic
        public final boolean getSupportsStreamUseCase(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 19);
        }

        @JvmStatic
        public final boolean getSupportsColorSpaceProfiles(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return ArraysKt.contains(getAvailableCapabilities(cameraMetadata), 20);
        }

        @JvmStatic
        public final CameraColorSpaceProfiles getAvailableColorSpaceProfiles(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraColorSpaceProfiles cameraColorSpaceProfiles = (CameraColorSpaceProfiles) cameraMetadata.get(CAMERA_AVAILABLE_COLOR_SPACE_PROFILES);
            if (cameraColorSpaceProfiles != null) {
                return cameraColorSpaceProfiles;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                CameraCharacteristics.Key REQUEST_AVAILABLE_COLOR_SPACE_PROFILES = CameraCharacteristics.REQUEST_AVAILABLE_COLOR_SPACE_PROFILES;
                Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_COLOR_SPACE_PROFILES, "REQUEST_AVAILABLE_COLOR_SPACE_PROFILES");
                ColorSpaceProfiles colorSpaceProfilesM258m = CameraColorSpace$$ExternalSyntheticApiModelOutline6.m258m(cameraMetadata.get(REQUEST_AVAILABLE_COLOR_SPACE_PROFILES));
                return colorSpaceProfilesM258m != null ? new Camera2ColorSpaceProfiles(colorSpaceProfilesM258m) : null;
            }
            return UnsupportedCameraColorSpaceProfiles.INSTANCE;
        }

        @JvmStatic
        public final CameraStreamConfigurationMap getStreamConfigurationMap(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraStreamConfigurationMap cameraStreamConfigurationMap = (CameraStreamConfigurationMap) cameraMetadata.get(CAMERA_STREAM_CONFIGURATION_MAP);
            if (cameraStreamConfigurationMap != null) {
                return cameraStreamConfigurationMap;
            }
            CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
            Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraMetadata.get(SCALER_STREAM_CONFIGURATION_MAP);
            return streamConfigurationMap != null ? new Camera2StreamConfigurationMap(streamConfigurationMap) : null;
        }

        @JvmStatic
        public final CameraMultiResolutionStreamConfigurationMap getMultiResolutionStreamConfigurationMap(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraMultiResolutionStreamConfigurationMap cameraMultiResolutionStreamConfigurationMap = (CameraMultiResolutionStreamConfigurationMap) cameraMetadata.get(CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP);
            if (cameraMultiResolutionStreamConfigurationMap != null) {
                return cameraMultiResolutionStreamConfigurationMap;
            }
            if (Build.VERSION.SDK_INT < 31) {
                return null;
            }
            CameraCharacteristics.Key SCALER_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP;
            Intrinsics.checkNotNullExpressionValue(SCALER_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP, "SCALER_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP");
            MultiResolutionStreamConfigurationMap multiResolutionStreamConfigurationMapM259m = CameraColorSpace$$ExternalSyntheticApiModelOutline6.m259m(cameraMetadata.get(SCALER_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP));
            return multiResolutionStreamConfigurationMapM259m != null ? new Camera2MultiResolutionStreamConfigurationMap(multiResolutionStreamConfigurationMapM259m) : null;
        }

        @JvmStatic
        public final boolean getSupportsAutoFocusTrigger(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key LENS_INFO_MINIMUM_FOCUS_DISTANCE = CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE;
            Intrinsics.checkNotNullExpressionValue(LENS_INFO_MINIMUM_FOCUS_DISTANCE, "LENS_INFO_MINIMUM_FOCUS_DISTANCE");
            Float f = (Float) cameraMetadata.get(LENS_INFO_MINIMUM_FOCUS_DISTANCE);
            if (f != null) {
                return f.floatValue() > 0.0f;
            }
            CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
            int[] iArr = (int[]) cameraMetadata.get(CONTROL_AF_AVAILABLE_MODES);
            if (iArr == null) {
                return false;
            }
            return ArraysKt.contains(iArr, 1) || ArraysKt.contains(iArr, 2) || ArraysKt.contains(iArr, 4) || ArraysKt.contains(iArr, 3);
        }

        @JvmStatic
        public final boolean getSupportsZoomOverride(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return Build.VERSION.SDK_INT >= 34 && Api34Compat.isZoomOverrideSupported(cameraMetadata);
        }

        @JvmStatic
        public final boolean getSupportsTorchStrength(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            return Build.VERSION.SDK_INT >= 35 && Api35Compat.isTorchStrengthSupported(cameraMetadata);
        }

        @JvmStatic
        public final int getMaxTorchStrengthLevel(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            if (Build.VERSION.SDK_INT >= 35) {
                return Api35Compat.getMaxTorchStrengthLevel(cameraMetadata);
            }
            return 1;
        }

        @JvmStatic
        public final int getDefaultTorchStrengthLevel(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            if (Build.VERSION.SDK_INT >= 35) {
                return Api35Compat.getDefaultTorchStrengthLevel(cameraMetadata);
            }
            return 1;
        }

        @JvmStatic
        public final boolean getSupportsLowLightBoost(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
            int[] iArr = (int[]) cameraMetadata.get(CONTROL_AE_AVAILABLE_MODES);
            if (iArr == null) {
                return false;
            }
            return ArraysKt.contains(iArr, 6);
        }

        @JvmStatic
        public final boolean getSupportsPreviewStabilization(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Compat.INSTANCE.supportsPreviewStabilization(cameraMetadata);
            }
            return false;
        }
    }
}
