package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2ImplConfigKt;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2Interop.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/interop/Camera2Interop;", "", "<init>", "()V", "Extender", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2Interop {
    private Camera2Interop() {
    }

    /* JADX INFO: compiled from: Camera2Interop.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u0002H\b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u0017H\u0007J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/interop/Camera2Interop$Extender;", ExifInterface.GPS_DIRECTION_TRUE, "", "baseBuilder", "Landroidx/camera/core/ExtendableBuilder;", "<init>", "(Landroidx/camera/core/ExtendableBuilder;)V", "setCaptureRequestOption", "ValueT", "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "value", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Landroidx/camera/camera2/interop/Camera2Interop$Extender;", "setCaptureRequestTemplate", "templateType", "", "setStreamUseCase", "streamUseCase", "", "setDeviceStateCallback", "stateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "setSessionStateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "setSessionCaptureCallback", "captureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "setPhysicalCameraId", "cameraId", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Extender<T> {
        private ExtendableBuilder<T> baseBuilder;

        public Extender(ExtendableBuilder<T> baseBuilder) {
            Intrinsics.checkNotNullParameter(baseBuilder, "baseBuilder");
            this.baseBuilder = baseBuilder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <ValueT> Extender<T> setCaptureRequestOption(CaptureRequest.Key<ValueT> key, ValueT value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfigKt.createCaptureRequestOption(key), Config.OptionPriority.ALWAYS_OVERRIDE, value);
            return this;
        }

        public final Extender<T> setCaptureRequestTemplate(int templateType) {
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.TEMPLATE_TYPE_OPTION, Integer.valueOf(templateType));
            return this;
        }

        public final Extender<T> setStreamUseCase(long streamUseCase) {
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION, Long.valueOf(streamUseCase));
            return this;
        }

        public final Extender<T> setDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
            Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.DEVICE_STATE_CALLBACK_OPTION, stateCallback);
            return this;
        }

        public final Extender<T> setSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
            Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_STATE_CALLBACK_OPTION, stateCallback);
            return this;
        }

        public final Extender<T> setSessionCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback) {
            Intrinsics.checkNotNullParameter(captureCallback, "captureCallback");
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION, captureCallback);
            return this;
        }

        public final Extender<T> setPhysicalCameraId(String cameraId) {
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            this.baseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION, cameraId);
            return this;
        }
    }
}
