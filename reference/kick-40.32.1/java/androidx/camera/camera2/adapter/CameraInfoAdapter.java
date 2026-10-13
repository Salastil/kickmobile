package androidx.camera.camera2.adapter;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.compat.DynamicRangeProfilesCompat;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.ZslDisablerQuirk;
import androidx.camera.camera2.compat.workaround.FlashAvailabilityCheckerKt;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraCallbackMap;
import androidx.camera.camera2.impl.CameraPipeCameraProperties;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.DeviceInfoLogger;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.internal.IntrinsicZoomCalculator;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.internal.StreamSpecsCalculator;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.canhub.cropper.CropImageOptionsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CameraInfoAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u0002:\u0002\u0088\u0001Ba\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010-\u001a\u00020#H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0/H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020#H\u0017J\b\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u000201H\u0016J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u000203H\u0003J\b\u0010<\u001a\u000203H\u0016J\b\u0010=\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u0002032\u0006\u0010>\u001a\u000203H\u0016J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u0002030@H\u0016J\b\u0010C\u001a\u00020#H\u0016J\b\u0010D\u001a\u000203H\u0016J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u0002030@H\u0016J\b\u0010F\u001a\u00020#H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u0002030@H\u0016J\b\u0010H\u001a\u00020IH\u0017J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020K0@H\u0016J\u001e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020K0QH\u0017J\u0016\u0010R\u001a\u00020M2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020K0QH\u0017J\u0018\u0010S\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020M2\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010W\u001a\u000201H\u0016J\b\u0010X\u001a\u00020\u0012H\u0016J\b\u0010Y\u001a\u00020ZH\u0016J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u0002030/H\u0016J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]2\u0006\u0010_\u001a\u000203H\u0016J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020^0]2\u0006\u0010_\u001a\u000203H\u0016J'\u0010a\u001a\u0004\u0018\u0001Hb\"\b\b\u0000\u0010b*\u0002082\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hb0dH\u0017¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u000201H\u0016J\b\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020#2\u0006\u0010j\u001a\u00020kH\u0016J\u0014\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030m0/H\u0016J\b\u0010n\u001a\u00020#H\u0017J\b\u0010o\u001a\u00020#H\u0016J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020q0/H\u0016J\b\u0010r\u001a\u00020#H\u0016J\u0014\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030m0/H\u0016J\u001c\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030m0/2\u0006\u0010u\u001a\u00020^H\u0016J\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020^0]2\f\u0010x\u001a\b\u0012\u0004\u0012\u0002030mH\u0016J\b\u0010y\u001a\u00020zH\u0016J\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020q0/2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020q0/H\u0016J\b\u0010}\u001a\u00020#H\u0016J\b\u0010~\u001a\u00020#H\u0016J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J4\u0010\u0081\u0001\u001a\u00020#2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010]2\u0007\u0010\u0084\u0001\u001a\u0002032\u0007\u0010\u0085\u0001\u001a\u00020#2\u0007\u0010\u0005\u001a\u00030\u0086\u0001H\u0016J\u000f\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u0002030/H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b\"\u0010$R!\u0010&\u001a\u00020'8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b,\u0010!\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006\u0089\u0001"}, d2 = {"Landroidx/camera/camera2/adapter/CameraInfoAdapter;", "Landroidx/camera/core/impl/CameraInfoInternal;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "cameraConfig", "Landroidx/camera/camera2/config/CameraConfig;", "cameraStateAdapter", "Landroidx/camera/camera2/adapter/CameraStateAdapter;", "cameraControlStateAdapter", "Landroidx/camera/camera2/adapter/CameraControlStateAdapter;", "cameraCallbackMap", "Landroidx/camera/camera2/impl/CameraCallbackMap;", "focusMeteringControl", "Landroidx/camera/camera2/impl/FocusMeteringControl;", "cameraQuirks", "Landroidx/camera/camera2/compat/quirk/CameraQuirks;", "encoderProfilesProvider", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "streamConfigurationMapCompat", "Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;", "intrinsicZoomCalculator", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "streamSpecsCalculator", "Landroidx/camera/core/internal/StreamSpecsCalculator;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/config/CameraConfig;Landroidx/camera/camera2/adapter/CameraStateAdapter;Landroidx/camera/camera2/adapter/CameraControlStateAdapter;Landroidx/camera/camera2/impl/CameraCallbackMap;Landroidx/camera/camera2/impl/FocusMeteringControl;Landroidx/camera/camera2/compat/quirk/CameraQuirks;Landroidx/camera/core/impl/EncoderProfilesProvider;Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;Landroidx/camera/core/internal/StreamSpecsCalculator;)V", "_physicalCameraInfos", "", "Landroidx/camera/core/CameraInfo;", "get_physicalCameraInfos", "()Ljava/util/Set;", "_physicalCameraInfos$delegate", "Lkotlin/Lazy;", "isLegacyDevice", "", "()Z", "isLegacyDevice$delegate", "camera2CameraInfo", "Landroidx/camera/camera2/interop/Camera2CameraInfo;", "getCamera2CameraInfo$camera_camera2$annotations", "()V", "getCamera2CameraInfo$camera_camera2", "()Landroidx/camera/camera2/interop/Camera2CameraInfo;", "camera2CameraInfo$delegate", "isLogicalMultiCameraSupported", "getPhysicalCameraInfos", "", "getCameraId", "", "getLensFacing", "", "isExternalCamera", "getCameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getPhysicalCameraCharacteristics", "", "physicalCameraId", "getCameraSelectorLensFacing", "lensFacingInt", "getSensorRotationDegrees", "hasFlashUnit", "relativeRotation", "getZoomState", "Landroidx/lifecycle/LiveData;", "Landroidx/camera/core/ZoomState;", "getTorchState", "isTorchStrengthSupported", "getMaxTorchStrengthLevel", "getTorchStrengthLevel", "isLowLightBoostSupported", "getLowLightBoostState", "getExposureState", "Landroidx/camera/core/ExposureState;", "getCameraState", "Landroidx/camera/core/CameraState;", "addCameraStateListener", "", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "removeCameraStateListener", "addSessionCaptureCallback", "callback", "Landroidx/camera/core/impl/CameraCaptureCallback;", "removeSessionCaptureCallback", "getImplementationType", "getEncoderProfilesProvider", "getTimebase", "Landroidx/camera/core/impl/Timebase;", "getSupportedOutputFormats", "getSupportedResolutions", "", "Landroid/util/Size;", "format", "getSupportedHighResolutions", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "getCameraQuirks", "Landroidx/camera/core/impl/Quirks;", "isFocusMeteringSupported", "action", "Landroidx/camera/core/FocusMeteringAction;", "getSupportedFrameRateRanges", "Landroid/util/Range;", "isZslSupported", "isPrivateReprocessingSupported", "getSupportedDynamicRanges", "Landroidx/camera/core/DynamicRange;", "isHighSpeedSupported", "getSupportedHighSpeedFrameRateRanges", "getSupportedHighSpeedFrameRateRangesFor", ContentDisposition.Parameters.Size, "getSupportedHighSpeedResolutions", "getSupportedHighSpeedResolutionsFor", "fpsRange", "getSensorRect", "Landroid/graphics/Rect;", "querySupportedDynamicRanges", "candidateDynamicRanges", "isPreviewStabilizationSupported", "isVideoStabilizationSupported", "getIntrinsicZoomRatio", "", "isUseCaseCombinationSupported", "useCases", "Landroidx/camera/core/UseCase;", "cameraMode", "isFeatureComboInvocation", "Landroidx/camera/core/impl/CameraConfig;", "getAvailableCapabilities", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraInfoAdapter implements CameraInfoInternal, UnsafeWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: _physicalCameraInfos$delegate, reason: from kotlin metadata */
    private final Lazy _physicalCameraInfos;

    /* JADX INFO: renamed from: camera2CameraInfo$delegate, reason: from kotlin metadata */
    private final Lazy camera2CameraInfo;
    private final CameraCallbackMap cameraCallbackMap;
    private final CameraConfig cameraConfig;
    private final CameraControlStateAdapter cameraControlStateAdapter;
    private final CameraProperties cameraProperties;
    private final CameraQuirks cameraQuirks;
    private final CameraStateAdapter cameraStateAdapter;
    private final EncoderProfilesProvider encoderProfilesProvider;
    private final FocusMeteringControl focusMeteringControl;
    private final IntrinsicZoomCalculator intrinsicZoomCalculator;

    /* JADX INFO: renamed from: isLegacyDevice$delegate, reason: from kotlin metadata */
    private final Lazy isLegacyDevice;
    private final StreamConfigurationMapCompat streamConfigurationMapCompat;
    private final StreamSpecsCalculator streamSpecsCalculator;

    public static /* synthetic */ void getCamera2CameraInfo$camera_camera2$annotations() {
    }

    @Inject
    public CameraInfoAdapter(CameraProperties cameraProperties, CameraConfig cameraConfig, CameraStateAdapter cameraStateAdapter, CameraControlStateAdapter cameraControlStateAdapter, CameraCallbackMap cameraCallbackMap, FocusMeteringControl focusMeteringControl, CameraQuirks cameraQuirks, EncoderProfilesProvider encoderProfilesProvider, StreamConfigurationMapCompat streamConfigurationMapCompat, IntrinsicZoomCalculator intrinsicZoomCalculator, StreamSpecsCalculator streamSpecsCalculator) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        Intrinsics.checkNotNullParameter(cameraStateAdapter, "cameraStateAdapter");
        Intrinsics.checkNotNullParameter(cameraControlStateAdapter, "cameraControlStateAdapter");
        Intrinsics.checkNotNullParameter(cameraCallbackMap, "cameraCallbackMap");
        Intrinsics.checkNotNullParameter(focusMeteringControl, "focusMeteringControl");
        Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
        Intrinsics.checkNotNullParameter(encoderProfilesProvider, "encoderProfilesProvider");
        Intrinsics.checkNotNullParameter(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        Intrinsics.checkNotNullParameter(intrinsicZoomCalculator, "intrinsicZoomCalculator");
        Intrinsics.checkNotNullParameter(streamSpecsCalculator, "streamSpecsCalculator");
        this.cameraProperties = cameraProperties;
        this.cameraConfig = cameraConfig;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraControlStateAdapter = cameraControlStateAdapter;
        this.cameraCallbackMap = cameraCallbackMap;
        this.focusMeteringControl = focusMeteringControl;
        this.cameraQuirks = cameraQuirks;
        this.encoderProfilesProvider = encoderProfilesProvider;
        this.streamConfigurationMapCompat = streamConfigurationMapCompat;
        this.intrinsicZoomCalculator = intrinsicZoomCalculator;
        this.streamSpecsCalculator = streamSpecsCalculator;
        DeviceInfoLogger.INSTANCE.logDeviceInfo(cameraProperties);
        this._physicalCameraInfos = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.CameraInfoAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CameraInfoAdapter._physicalCameraInfos_delegate$lambda$0(this.f$0);
            }
        });
        this.isLegacyDevice = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.CameraInfoAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CameraMetadata.INSTANCE.isHardwareLevelLegacy(this.f$0.cameraProperties.getMetadata()));
            }
        });
        this.camera2CameraInfo = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.CameraInfoAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraInfo.INSTANCE.create(this.f$0.cameraProperties);
            }
        });
    }

    private final Set<CameraInfo> get_physicalCameraInfos() {
        return (Set) this._physicalCameraInfos.getValue();
    }

    static final Set _physicalCameraInfos_delegate$lambda$0(CameraInfoAdapter cameraInfoAdapter) {
        Set<CameraId> physicalCameraIds = cameraInfoAdapter.cameraProperties.getMetadata().getPhysicalCameraIds();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = physicalCameraIds.iterator();
        while (it.hasNext()) {
            String strM433unboximpl = ((CameraId) it.next()).m433unboximpl();
            linkedHashSet.add(new PhysicalCameraInfoAdapter(new CameraPipeCameraProperties(new CameraConfig(strM433unboximpl, null), cameraInfoAdapter.cameraProperties.getMetadata().mo444awaitPhysicalMetadataEfqyGwQ(strM433unboximpl))));
        }
        return linkedHashSet;
    }

    private final boolean isLegacyDevice() {
        return ((Boolean) this.isLegacyDevice.getValue()).booleanValue();
    }

    public final Camera2CameraInfo getCamera2CameraInfo$camera_camera2() {
        return (Camera2CameraInfo) this.camera2CameraInfo.getValue();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLogicalMultiCameraSupported() {
        return CameraMetadata.INSTANCE.getSupportsLogicalMultiCamera(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<CameraInfo> getPhysicalCameraInfos() {
        return get_physicalCameraInfos();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.cameraConfig.getCameraId();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getLensFacing() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) LENS_FACING);
        Intrinsics.checkNotNull(obj);
        return getCameraSelectorLensFacing(((Number) obj).intValue());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isExternalCamera() {
        if (getLensFacing() == 2) {
            return true;
        }
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num = (Integer) metadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 4;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public CameraCharacteristics getCameraCharacteristics() {
        Object objUnwrapAs = this.cameraProperties.getMetadata().unwrapAs(Reflection.getOrCreateKotlinClass(CameraCharacteristics.class));
        Intrinsics.checkNotNull(objUnwrapAs);
        return (CameraCharacteristics) objUnwrapAs;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Object getPhysicalCameraCharacteristics(String physicalCameraId) {
        Intrinsics.checkNotNullParameter(physicalCameraId, "physicalCameraId");
        CameraId.Companion companion = CameraId.INSTANCE;
        String strM427constructorimpl = CameraId.m427constructorimpl(physicalCameraId);
        if (this.cameraProperties.getMetadata().getPhysicalCameraIds().contains(CameraId.m426boximpl(strM427constructorimpl))) {
            return this.cameraProperties.getMetadata().mo444awaitPhysicalMetadataEfqyGwQ(strM427constructorimpl).unwrapAs(Reflection.getOrCreateKotlinClass(CameraCharacteristics.class));
        }
        return null;
    }

    private final int getCameraSelectorLensFacing(int lensFacingInt) {
        if (lensFacingInt == 0) {
            return 0;
        }
        if (lensFacingInt == 1) {
            return 1;
        }
        if (lensFacingInt == 2) {
            return 2;
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isWarnEnabled(Log.TAG)) {
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Unrecognized lens facing: " + lensFacingInt + '!');
        }
        return -1;
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        return FlashAvailabilityCheckerKt.isFlashAvailable$default(this.cameraProperties, false, 1, null);
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int relativeRotation) {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        Intrinsics.checkNotNullExpressionValue(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) SENSOR_ORIENTATION);
        Intrinsics.checkNotNull(obj);
        return CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(relativeRotation), ((Number) obj).intValue(), 1 == getLensFacing());
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        return this.cameraControlStateAdapter.getZoomStateLiveData();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        return this.cameraControlStateAdapter.getTorchStateLiveData();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isTorchStrengthSupported() {
        return CameraMetadata.INSTANCE.getSupportsTorchStrength(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.CameraInfo
    public int getMaxTorchStrengthLevel() {
        if (isTorchStrengthSupported()) {
            return CameraMetadata.INSTANCE.getMaxTorchStrengthLevel(this.cameraProperties.getMetadata());
        }
        return 0;
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchStrengthLevel() {
        return isTorchStrengthSupported() ? this.cameraControlStateAdapter.getTorchStrengthLiveData() : new MutableLiveData(0);
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLowLightBoostSupported() {
        return CameraMetadata.INSTANCE.getSupportsLowLightBoost(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getLowLightBoostState() {
        return this.cameraControlStateAdapter.getLowLightBoostState();
    }

    @Override // androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        return this.cameraControlStateAdapter.getExposureState();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<CameraState> getCameraState() {
        return this.cameraStateAdapter.getCameraState$camera_camera2();
    }

    @Override // androidx.camera.core.CameraInfo
    public void addCameraStateListener(Executor executor, Consumer<CameraState> listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cameraStateAdapter.addCameraStateListener$camera_camera2(executor, listener);
    }

    @Override // androidx.camera.core.CameraInfo
    public void removeCameraStateListener(Consumer<CameraState> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cameraStateAdapter.removeCameraStateListener$camera_camera2(listener);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void addSessionCaptureCallback(Executor executor, CameraCaptureCallback callback) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cameraCallbackMap.addCaptureCallback(callback, executor);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void removeSessionCaptureCallback(CameraCaptureCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cameraCallbackMap.removeCaptureCallback(callback);
    }

    @Override // androidx.camera.core.CameraInfo
    public String getImplementationType() {
        return isLegacyDevice() ? CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY : CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.encoderProfilesProvider;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Timebase getTimebase() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_TIMESTAMP_SOURCE = CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_TIMESTAMP_SOURCE, "SENSOR_INFO_TIMESTAMP_SOURCE");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) SENSOR_INFO_TIMESTAMP_SOURCE);
        Intrinsics.checkNotNull(obj);
        int iIntValue = ((Number) obj).intValue();
        if (iIntValue == 0) {
            return Timebase.UPTIME;
        }
        if (iIntValue == 1) {
            return Timebase.REALTIME;
        }
        return Timebase.UPTIME;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Integer> getSupportedOutputFormats() {
        Set<Integer> set;
        Integer[] outputFormats = this.streamConfigurationMapCompat.getOutputFormats();
        return (outputFormats == null || (set = ArraysKt.toSet(outputFormats)) == null) ? SetsKt.emptySet() : set;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedResolutions(int format) {
        List<Size> list;
        Size[] outputSizes = this.streamConfigurationMapCompat.getOutputSizes(format);
        return (outputSizes == null || (list = ArraysKt.toList(outputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighResolutions(int format) {
        List<Size> list;
        Size[] highResolutionOutputSizes = this.streamConfigurationMapCompat.getHighResolutionOutputSizes(format);
        return (highResolutionOutputSizes == null || (list = ArraysKt.toList(highResolutionOutputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Camera2CameraInfo.class))) {
            Object camera2CameraInfo$camera_camera2 = getCamera2CameraInfo$camera_camera2();
            Intrinsics.checkNotNull(camera2CameraInfo$camera_camera2, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
            return (T) camera2CameraInfo$camera_camera2;
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraProperties.class))) {
            CameraProperties cameraProperties = this.cameraProperties;
            Intrinsics.checkNotNull(cameraProperties, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
            return (T) cameraProperties;
        }
        boolean zAreEqual = Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraMetadata.class));
        CameraProperties cameraProperties2 = this.cameraProperties;
        if (zAreEqual) {
            CameraMetadata metadata = cameraProperties2.getMetadata();
            Intrinsics.checkNotNull(metadata, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
            return (T) metadata;
        }
        return (T) cameraProperties2.getMetadata().unwrapAs(type);
    }

    public String toString() {
        return "CameraInfoAdapter<" + this.cameraConfig + ".cameraId>";
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Quirks getCameraQuirks() {
        return this.cameraQuirks.getQuirks();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return this.focusMeteringControl.isFocusMeteringSupported(action);
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        Set<Range<Integer>> set;
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES = CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, "CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES");
        Range[] rangeArr = (Range[]) metadata.get(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        return (rangeArr == null || (set = ArraysKt.toSet(rangeArr)) == null) ? SetsKt.emptySet() : set;
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isZslSupported() {
        return isPrivateReprocessingSupported() && DeviceQuirks.INSTANCE.get(ZslDisablerQuirk.class) == null;
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isPrivateReprocessingSupported() {
        return CameraMetadata.INSTANCE.getSupportsPrivateReprocessing(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return DynamicRangeProfilesCompat.INSTANCE.fromCameraMetaData(this.cameraProperties.getMetadata()).getSupportedDynamicRanges();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isHighSpeedSupported() {
        return CameraMetadata.INSTANCE.getSupportsHighSpeedVideo(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Range<Integer>> getSupportedHighSpeedFrameRateRanges() {
        Set<Range<Integer>> set;
        Range<Integer>[] highSpeedVideoFpsRanges = this.streamConfigurationMapCompat.getHighSpeedVideoFpsRanges();
        return (highSpeedVideoFpsRanges == null || (set = ArraysKt.toSet(highSpeedVideoFpsRanges)) == null) ? SetsKt.emptySet() : set;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Range<Integer>> getSupportedHighSpeedFrameRateRangesFor(Size size) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(size, "size");
        try {
            Result.Companion companion = Result.INSTANCE;
            CameraInfoAdapter cameraInfoAdapter = this;
            Range<Integer>[] highSpeedVideoFpsRangesFor = this.streamConfigurationMapCompat.getHighSpeedVideoFpsRangesFor(size);
            objM12684constructorimpl = Result.m12684constructorimpl(highSpeedVideoFpsRangesFor != null ? ArraysKt.toSet(highSpeedVideoFpsRangesFor) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Set<Range<Integer>> set = (Set) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        return set == null ? SetsKt.emptySet() : set;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighSpeedResolutions() {
        List<Size> list;
        Size[] highSpeedVideoSizes = this.streamConfigurationMapCompat.getHighSpeedVideoSizes();
        return (highSpeedVideoSizes == null || (list = ArraysKt.toList(highSpeedVideoSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighSpeedResolutionsFor(Range<Integer> fpsRange) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(fpsRange, "fpsRange");
        try {
            Result.Companion companion = Result.INSTANCE;
            CameraInfoAdapter cameraInfoAdapter = this;
            Size[] highSpeedVideoSizesFor = this.streamConfigurationMapCompat.getHighSpeedVideoSizesFor(fpsRange);
            objM12684constructorimpl = Result.m12684constructorimpl(highSpeedVideoSizesFor != null ? ArraysKt.toList(highSpeedVideoSizesFor) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        List<Size> list = (List) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Rect getSensorRect() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Rect rect = (Rect) metadata.get(SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (Intrinsics.areEqual("robolectric", Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        Intrinsics.checkNotNull(rect);
        return rect;
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> candidateDynamicRanges) {
        Intrinsics.checkNotNullParameter(candidateDynamicRanges, "candidateDynamicRanges");
        return DynamicRanges.findAllPossibleMatches(candidateDynamicRanges, getSupportedDynamicRanges());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isPreviewStabilizationSupported() {
        return CameraMetadata.INSTANCE.getSupportsPreviewStabilization(this.cameraProperties.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isVideoStabilizationSupported() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES = CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, "CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES");
        int[] iArr = (int[]) metadata.get(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        return iArr != null && ArraysKt.contains(iArr, 1);
    }

    @Override // androidx.camera.core.CameraInfo
    public float getIntrinsicZoomRatio() {
        Float fCalculateIntrinsicZoomRatio = this.intrinsicZoomCalculator.calculateIntrinsicZoomRatio(this.cameraProperties.getMetadata());
        if (fCalculateIntrinsicZoomRatio != null) {
            return fCalculateIntrinsicZoomRatio.floatValue();
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (!Logger.isWarnEnabled(Log.TAG)) {
            return 1.0f;
        }
        android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to calculate intrinsic zoom ratio for " + ((Object) CameraId.m432toStringimpl(this.cameraProperties.mo100getCameraIdDz_R5H8())));
        return 1.0f;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isUseCaseCombinationSupported(List<? extends UseCase> useCases, int cameraMode, boolean isFeatureComboInvocation, androidx.camera.core.impl.CameraConfig cameraConfig) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        try {
            StreamSpecsCalculator.calculateSuggestedStreamSpecs$default(this.streamSpecsCalculator, cameraMode, this, useCases, null, cameraConfig, 0, null, isFeatureComboInvocation, false, CropImageOptionsKt.DEGREES_360, null);
            return true;
        } catch (IllegalArgumentException e) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            IllegalArgumentException illegalArgumentException = e;
            if (!Logger.isDebugEnabled(Log.TAG)) {
                return false;
            }
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CameraInfoAdapter#isUseCaseCombinationSupported: calculateSuggestedStreamSpecs failed", illegalArgumentException);
            return false;
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Integer> getAvailableCapabilities() {
        Set<Integer> set;
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) metadata.get(REQUEST_AVAILABLE_CAPABILITIES);
        return (iArr == null || (set = ArraysKt.toSet(iArr)) == null) ? SetsKt.emptySet() : set;
    }

    /* JADX INFO: compiled from: CameraInfoAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b¢\u0006\u0002\u0010\tR\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/adapter/CameraInfoAdapter$Companion;", "", "<init>", "()V", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/core/CameraInfo;", "type", "Lkotlin/reflect/KClass;", "(Landroidx/camera/core/CameraInfo;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-zjxgSG8", "(Landroidx/camera/core/CameraInfo;)Ljava/lang/String;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> T unwrapAs(CameraInfo cameraInfo, KClass<T> type) {
            Intrinsics.checkNotNullParameter(cameraInfo, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            if (cameraInfo instanceof UnsafeWrapper) {
                return (T) ((UnsafeWrapper) cameraInfo).unwrapAs(type);
            }
            if (cameraInfo instanceof CameraInfoInternal) {
                CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
                if (cameraInfoInternal.getImplementation() != cameraInfo) {
                    CameraInfoInternal implementation = cameraInfoInternal.getImplementation();
                    Intrinsics.checkNotNullExpressionValue(implementation, "getImplementation(...)");
                    return (T) unwrapAs(implementation, type);
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: getCameraId-zjxgSG8, reason: not valid java name */
        public final String m43getCameraIdzjxgSG8(CameraInfo cameraId) {
            Intrinsics.checkNotNullParameter(cameraId, "$this$cameraId");
            CameraMetadata cameraMetadata = (CameraMetadata) unwrapAs(cameraId, Reflection.getOrCreateKotlinClass(CameraMetadata.class));
            if (cameraMetadata != null) {
                return cameraMetadata.getCamera();
            }
            return null;
        }
    }
}
