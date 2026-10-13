package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.CameraExtensionsControl;
import androidx.camera.extensions.CameraExtensionsInfo;
import androidx.camera.extensions.internal.Camera2ExtensionsUtil;
import androidx.camera.extensions.internal.ExtensionsUtils;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2ExtensionsSessionProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\"\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00050)2\u0006\u0010+\u001a\u00020*H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0016J \u0010-\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030/\u0012\u0006\b\u0000\u0012\u00020\u001d0.0\u0005H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0.H\u0016J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000106H\u0016J\b\u00107\u001a\u000204H\u0016J\u0010\u00108\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000106H\u0016J\u0016\u00109\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:\u0018\u00010.H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\bH\u0016J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Landroidx/camera/extensions/internal/sessionprocessor/Camera2ExtensionsSessionProcessor;", "Landroidx/camera/core/impl/SessionProcessor;", "Landroidx/camera/extensions/CameraExtensionsInfo;", "Landroidx/camera/extensions/CameraExtensionsControl;", "availableCaptureRequestKeys", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "mode", "", "vendorExtender", "Landroidx/camera/extensions/internal/VendorExtender;", "<init>", "(Ljava/util/List;ILandroidx/camera/extensions/internal/VendorExtender;)V", "camera2ExtensionMode", "extensionStrengthLiveData", "Landroidx/lifecycle/MutableLiveData;", "currentExtensionTypeLiveData", "extensionStrength", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentExtensionType", "supportedCameraOperations", "", "getSupportedCameraOperations$annotations", "()V", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "cameraCaptureCallback", "Landroidx/camera/core/impl/CameraCaptureCallback;", "lock", "", "captureSessionRequestProcessor", "Landroidx/camera/core/impl/SessionProcessor$CaptureSessionRequestProcessor;", "initSession", "Landroidx/camera/core/impl/SessionConfig;", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "outputSurfaceConfig", "Landroidx/camera/core/impl/OutputSurfaceConfiguration;", "deInitSession", "", "getSupportedPostviewSize", "", "Landroid/util/Size;", "captureSize", "getSupportedCameraOperations", "getAvailableCharacteristicsKeyValues", "Landroid/util/Pair;", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "getExtensionAvailableStabilizationModes", "", "getImplementationType", "isExtensionStrengthAvailable", "", "getExtensionStrength", "Landroidx/lifecycle/LiveData;", "isCurrentExtensionModeAvailable", "getCurrentExtensionMode", "getRealtimeCaptureLatency", "", "setExtensionStrength", "strength", "setCaptureSessionRequestProcessor", "processor", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2ExtensionsSessionProcessor implements SessionProcessor, CameraExtensionsInfo, CameraExtensionsControl {
    private final List<CaptureRequest.Key<?>> availableCaptureRequestKeys;
    private final int camera2ExtensionMode;
    private CameraCaptureCallback cameraCaptureCallback;
    private CameraInfoInternal cameraInfoInternal;
    private SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor;
    private final AtomicInteger currentExtensionType;
    private MutableLiveData<Integer> currentExtensionTypeLiveData;
    private final AtomicInteger extensionStrength;
    private MutableLiveData<Integer> extensionStrengthLiveData;
    private final Object lock;
    private final int mode;
    private final Set<Integer> supportedCameraOperations;
    private final VendorExtender vendorExtender;

    private static /* synthetic */ void getSupportedCameraOperations$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Camera2ExtensionsSessionProcessor(List<? extends CaptureRequest.Key<?>> availableCaptureRequestKeys, int i, VendorExtender vendorExtender) {
        Intrinsics.checkNotNullParameter(availableCaptureRequestKeys, "availableCaptureRequestKeys");
        Intrinsics.checkNotNullParameter(vendorExtender, "vendorExtender");
        this.availableCaptureRequestKeys = availableCaptureRequestKeys;
        this.mode = i;
        this.vendorExtender = vendorExtender;
        this.camera2ExtensionMode = Camera2ExtensionsUtil.INSTANCE.convertCameraXModeToCamera2Mode(i);
        this.extensionStrength = new AtomicInteger(100);
        this.currentExtensionType = new AtomicInteger(i);
        Set<Integer> supportedCameraOperations = ExtensionsUtils.getSupportedCameraOperations(availableCaptureRequestKeys);
        Intrinsics.checkNotNullExpressionValue(supportedCameraOperations, "getSupportedCameraOperations(...)");
        this.supportedCameraOperations = supportedCameraOperations;
        this.lock = new Object();
        if (isCurrentExtensionModeAvailable()) {
            this.currentExtensionTypeLiveData = new MutableLiveData<>(Integer.valueOf(i));
        }
        if (isExtensionStrengthAvailable()) {
            this.extensionStrengthLiveData = new MutableLiveData<>(100);
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public SessionConfig initSession(CameraInfo cameraInfo, OutputSurfaceConfiguration outputSurfaceConfig) {
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        this.cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        this.cameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.extensions.internal.sessionprocessor.Camera2ExtensionsSessionProcessor.initSession.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(int captureConfigId, CameraCaptureResult cameraCaptureResult) {
                CaptureResult captureResult;
                Integer num;
                MutableLiveData mutableLiveData;
                CaptureResult captureResult2;
                Integer num2;
                MutableLiveData mutableLiveData2;
                Intrinsics.checkNotNullParameter(cameraCaptureResult, "cameraCaptureResult");
                if (Build.VERSION.SDK_INT >= 34 && Camera2ExtensionsSessionProcessor.this.isCurrentExtensionModeAvailable() && (captureResult2 = cameraCaptureResult.getCaptureResult()) != null && (num2 = (Integer) captureResult2.get(CaptureResult.EXTENSION_CURRENT_TYPE)) != null) {
                    Camera2ExtensionsSessionProcessor camera2ExtensionsSessionProcessor = Camera2ExtensionsSessionProcessor.this;
                    Integer numConvertCamera2ModeToCameraXMode = Camera2ExtensionsUtil.INSTANCE.convertCamera2ModeToCameraXMode(num2.intValue());
                    if (numConvertCamera2ModeToCameraXMode != null) {
                        int iIntValue = numConvertCamera2ModeToCameraXMode.intValue();
                        if (camera2ExtensionsSessionProcessor.currentExtensionType.getAndSet(iIntValue) != iIntValue && (mutableLiveData2 = camera2ExtensionsSessionProcessor.currentExtensionTypeLiveData) != null) {
                            mutableLiveData2.postValue(Integer.valueOf(iIntValue));
                        }
                    }
                }
                if (Build.VERSION.SDK_INT < 34 || !Camera2ExtensionsSessionProcessor.this.isExtensionStrengthAvailable() || (captureResult = cameraCaptureResult.getCaptureResult()) == null || (num = (Integer) captureResult.get(CaptureResult.EXTENSION_STRENGTH)) == null) {
                    return;
                }
                Camera2ExtensionsSessionProcessor camera2ExtensionsSessionProcessor2 = Camera2ExtensionsSessionProcessor.this;
                int iIntValue2 = num.intValue();
                if (camera2ExtensionsSessionProcessor2.extensionStrength.getAndSet(iIntValue2) == iIntValue2 || (mutableLiveData = camera2ExtensionsSessionProcessor2.extensionStrengthLiveData) == null) {
                    return;
                }
                mutableLiveData.postValue(Integer.valueOf(iIntValue2));
            }
        };
        CameraInfoInternal cameraInfoInternal = this.cameraInfoInternal;
        Intrinsics.checkNotNull(cameraInfoInternal);
        Executor executorDirectExecutor = CameraXExecutors.directExecutor();
        CameraCaptureCallback cameraCaptureCallback = this.cameraCaptureCallback;
        Intrinsics.checkNotNull(cameraCaptureCallback);
        cameraInfoInternal.addSessionCaptureCallback(executorDirectExecutor, cameraCaptureCallback);
        return null;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void deInitSession() {
        CameraCaptureCallback cameraCaptureCallback;
        CameraInfoInternal cameraInfoInternal = this.cameraInfoInternal;
        if (cameraInfoInternal == null || (cameraCaptureCallback = this.cameraCaptureCallback) == null) {
            return;
        }
        cameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Map<Integer, List<Size>> getSupportedPostviewSize(Size captureSize) {
        Intrinsics.checkNotNullParameter(captureSize, "captureSize");
        Map<Integer, List<Size>> supportedPostviewResolutions = this.vendorExtender.getSupportedPostviewResolutions(captureSize);
        Intrinsics.checkNotNullExpressionValue(supportedPostviewResolutions, "getSupportedPostviewResolutions(...)");
        return supportedPostviewResolutions;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Set<Integer> getSupportedCameraOperations() {
        return this.supportedCameraOperations;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public List<Pair<CameraCharacteristics.Key<?>, ? super Object>> getAvailableCharacteristicsKeyValues() {
        List<Pair<CameraCharacteristics.Key<?>, ? super Object>> availableCharacteristicsKeyValues = this.vendorExtender.getAvailableCharacteristicsKeyValues();
        Intrinsics.checkNotNullExpressionValue(availableCharacteristicsKeyValues, "getAvailableCharacteristicsKeyValues(...)");
        return availableCharacteristicsKeyValues;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int[] getExtensionAvailableStabilizationModes() {
        return super.getExtensionAvailableStabilizationModes();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Pair<Integer, Integer> getImplementationType() {
        Pair<Integer, Integer> pairCreate = Pair.create(1, Integer.valueOf(this.camera2ExtensionMode));
        Intrinsics.checkNotNullExpressionValue(pairCreate, "create(...)");
        return pairCreate;
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public boolean isExtensionStrengthAvailable() {
        return this.vendorExtender.isExtensionStrengthAvailable();
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getExtensionStrength() {
        return this.extensionStrengthLiveData;
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public boolean isCurrentExtensionModeAvailable() {
        return this.vendorExtender.isCurrentExtensionModeAvailable();
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getCurrentExtensionMode() {
        return this.currentExtensionTypeLiveData;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Pair<Long, Long> getRealtimeCaptureLatency() {
        Pair<Long, Long> realtimeStillCaptureLatency;
        synchronized (this.lock) {
            SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor = this.captureSessionRequestProcessor;
            realtimeStillCaptureLatency = captureSessionRequestProcessor != null ? captureSessionRequestProcessor.getRealtimeStillCaptureLatency() : null;
        }
        return realtimeStillCaptureLatency;
    }

    @Override // androidx.camera.extensions.CameraExtensionsControl
    public void setExtensionStrength(int strength) {
        synchronized (this.lock) {
            SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor = this.captureSessionRequestProcessor;
            if (captureSessionRequestProcessor != null) {
                captureSessionRequestProcessor.setExtensionStrength(strength);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void setCaptureSessionRequestProcessor(SessionProcessor.CaptureSessionRequestProcessor processor) {
        synchronized (this.lock) {
            this.captureSessionRequestProcessor = processor;
            Unit unit = Unit.INSTANCE;
        }
    }
}
