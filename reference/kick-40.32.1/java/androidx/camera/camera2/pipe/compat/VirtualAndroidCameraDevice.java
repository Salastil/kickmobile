package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.view.Surface;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CameraDeviceWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J&\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020#H\u0017J\u0019\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010%2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J'\u00100\u001a\u0004\u0018\u0001H1\"\b\b\u0000\u00101*\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016¢\u0006\u0002\u00104J\r\u00105\u001a\u00020.H\u0000¢\u0006\u0002\b6J\u000f\u00107\u001a\u000208H\u0017¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u000208H\u0017¢\u0006\u0004\b=\u0010>R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006?"}, d2 = {"Landroidx/camera/camera2/pipe/compat/VirtualAndroidCameraDevice;", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "androidCameraDevice", "Landroidx/camera/camera2/pipe/compat/AndroidCameraDevice;", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraDevice;)V", "getAndroidCameraDevice$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/compat/AndroidCameraDevice;", "lock", "", "disconnected", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "createCaptureSession", "outputs", "", "Landroid/view/Surface;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "createReprocessableCaptureSession", "input", "Landroid/hardware/camera2/params/InputConfiguration;", "createConstrainedHighSpeedCaptureSession", "createCaptureSessionByOutputConfigurations", "outputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "createReprocessableCaptureSessionByConfigurations", "inputConfig", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "createExtensionSession", "config", "Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "createCaptureRequest-2PPcXtw", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "createReprocessCaptureRequest", "inputResult", "Landroid/hardware/camera2/TotalCaptureResult;", "onDeviceClosing", "", "onDeviceClosed", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "disconnect", "disconnect$camera_camera2_pipe", "getCameraAudioRestriction", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getCameraAudioRestriction-_b5Q8KE", "()I", "onCameraAudioRestrictionUpdated", "mode", "onCameraAudioRestrictionUpdated-LwUUkyU", "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VirtualAndroidCameraDevice implements CameraDeviceWrapper {
    private final AndroidCameraDevice androidCameraDevice;
    private boolean disconnected;
    private final Object lock;

    public VirtualAndroidCameraDevice(AndroidCameraDevice androidCameraDevice) {
        Intrinsics.checkNotNullParameter(androidCameraDevice, "androidCameraDevice");
        this.androidCameraDevice = androidCameraDevice;
        this.lock = new Object();
    }

    /* JADX INFO: renamed from: getAndroidCameraDevice$camera_camera2_pipe, reason: from getter */
    public final AndroidCameraDevice getAndroidCameraDevice() {
        return this.androidCameraDevice;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraId-Dz_R5H8 */
    public String getCameraId() {
        return this.androidCameraDevice.getCameraId();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) {
        boolean zCreateCaptureSession;
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateCaptureSession = this.androidCameraDevice.createCaptureSession(outputs, stateCallback);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createCaptureSession failed: Virtual device disconnected");
                }
                stateCallback.onSessionFinalized();
                zCreateCaptureSession = false;
            }
        }
        return zCreateCaptureSession;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createReprocessableCaptureSession(InputConfiguration input, List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) {
        boolean zCreateReprocessableCaptureSession;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateReprocessableCaptureSession = this.androidCameraDevice.createReprocessableCaptureSession(input, outputs, stateCallback);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createReprocessableCaptureSession failed: Virtual device disconnected");
                }
                stateCallback.onSessionFinalized();
                zCreateReprocessableCaptureSession = false;
            }
        }
        return zCreateReprocessableCaptureSession;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createConstrainedHighSpeedCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) {
        boolean zCreateConstrainedHighSpeedCaptureSession;
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateConstrainedHighSpeedCaptureSession = this.androidCameraDevice.createConstrainedHighSpeedCaptureSession(outputs, stateCallback);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createConstrainedHighSpeedCaptureSession failed: Virtual device disconnected");
                }
                stateCallback.onSessionFinalized();
                zCreateConstrainedHighSpeedCaptureSession = false;
            }
        }
        return zCreateConstrainedHighSpeedCaptureSession;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSessionByOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigurations, CameraCaptureSessionWrapper.StateCallback stateCallback) {
        boolean zCreateCaptureSessionByOutputConfigurations;
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateCaptureSessionByOutputConfigurations = this.androidCameraDevice.createCaptureSessionByOutputConfigurations(outputConfigurations, stateCallback);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createCaptureSessionByOutputConfigurations failed: Virtual device disconnected");
                }
                stateCallback.onSessionFinalized();
                zCreateCaptureSessionByOutputConfigurations = false;
            }
        }
        return zCreateCaptureSessionByOutputConfigurations;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createReprocessableCaptureSessionByConfigurations(InputConfigData inputConfig, List<? extends OutputConfigurationWrapper> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) {
        boolean zCreateReprocessableCaptureSessionByConfigurations;
        Intrinsics.checkNotNullParameter(inputConfig, "inputConfig");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateReprocessableCaptureSessionByConfigurations = this.androidCameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfig, outputs, stateCallback);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createReprocessableCaptureSessionByConfigurations failed: Virtual device disconnected");
                }
                stateCallback.onSessionFinalized();
                zCreateReprocessableCaptureSessionByConfigurations = false;
            }
        }
        return zCreateReprocessableCaptureSessionByConfigurations;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createExtensionSession(ExtensionSessionConfigData config) {
        boolean zCreateExtensionSession;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateExtensionSession = this.androidCameraDevice.createExtensionSession(config);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createExtensionSession failed: Virtual device disconnected");
                }
                CameraExtensionSessionWrapper.StateCallback extensionStateCallback = config.getExtensionStateCallback();
                Intrinsics.checkNotNull(extensionStateCallback);
                extensionStateCallback.onSessionFinalized();
                zCreateExtensionSession = false;
            }
        }
        return zCreateExtensionSession;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSession(SessionConfigData config) {
        boolean zCreateCaptureSession;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            if (!this.disconnected) {
                zCreateCaptureSession = this.androidCameraDevice.createCaptureSession(config);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createCaptureSession failed: Virtual device disconnected");
                }
                config.getStateCallback().onSessionFinalized();
                zCreateCaptureSession = false;
            }
        }
        return zCreateCaptureSession;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: createCaptureRequest-2PPcXtw */
    public CaptureRequest.Builder mo800createCaptureRequest2PPcXtw(int template) {
        CaptureRequest.Builder builderMo800createCaptureRequest2PPcXtw;
        synchronized (this.lock) {
            if (!this.disconnected) {
                builderMo800createCaptureRequest2PPcXtw = this.androidCameraDevice.mo800createCaptureRequest2PPcXtw(template);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createCaptureRequest failed: Virtual device disconnected");
                }
                builderMo800createCaptureRequest2PPcXtw = null;
            }
        }
        return builderMo800createCaptureRequest2PPcXtw;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public CaptureRequest.Builder createReprocessCaptureRequest(TotalCaptureResult inputResult) {
        CaptureRequest.Builder builderCreateReprocessCaptureRequest;
        Intrinsics.checkNotNullParameter(inputResult, "inputResult");
        synchronized (this.lock) {
            if (!this.disconnected) {
                builderCreateReprocessCaptureRequest = this.androidCameraDevice.createReprocessCaptureRequest(inputResult);
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "createReprocessCaptureRequest failed: Virtual device disconnected");
                }
                builderCreateReprocessCaptureRequest = null;
            }
        }
        return builderCreateReprocessCaptureRequest;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosing() {
        this.androidCameraDevice.onDeviceClosing();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosed() {
        this.androidCameraDevice.onDeviceClosed();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.androidCameraDevice.unwrapAs(type);
    }

    public final void disconnect$camera_camera2_pipe() {
        synchronized (this.lock) {
            this.disconnected = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraAudioRestriction-_b5Q8KE */
    public int mo801getCameraAudioRestriction_b5Q8KE() {
        return this.androidCameraDevice.mo801getCameraAudioRestriction_b5Q8KE();
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController.Listener
    /* JADX INFO: renamed from: onCameraAudioRestrictionUpdated-LwUUkyU */
    public void mo803onCameraAudioRestrictionUpdatedLwUUkyU(int mode) {
        this.androidCameraDevice.mo803onCameraAudioRestrictionUpdatedLwUUkyU(mode);
    }
}
