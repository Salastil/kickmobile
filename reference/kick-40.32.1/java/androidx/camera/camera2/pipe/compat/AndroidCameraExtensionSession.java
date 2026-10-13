package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraExtensionSession;
import android.hardware.camera2.CameraExtensionSession$ExtensionCaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraInterop;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;

/* JADX INFO: compiled from: ExtensionSessionWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001:\u0002;<B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010(\u001a\u00020!H\u0016J%\u0010)\u001a\u0004\u0018\u00010\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010,J%\u0010-\u001a\u0004\u0018\u00010\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010,J\u0016\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000+H\u0016J'\u00101\u001a\u0004\u0018\u0001H2\"\b\b\u0000\u00102*\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H205H\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u000208H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraExtensionSession;", "Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper;", "device", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "cameraExtensionSession", "Landroid/hardware/camera2/CameraExtensionSession;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;Landroid/hardware/camera2/CameraExtensionSession;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Ljava/util/concurrent/Executor;)V", "getDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "id", "Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "getId-159jkk4", "()I", "I", "frameNumbers", "Lkotlinx/atomicfu/AtomicLong;", "extensionSessionMap", "", "", "capture", "", "request", "Landroid/hardware/camera2/CaptureRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "setRepeatingRequest", "stopRepeating", "", "isReprocessable", "()Z", "inputSurface", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "abortCaptures", "captureBurst", "requests", "", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "setRepeatingBurst", "finalizeOutputConfigurations", "outputConfigs", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "close", "", "getRealTimeCaptureLatency", "Landroid/hardware/camera2/CameraExtensionSession$StillCaptureLatency;", "Camera2CaptureSessionCallbackToExtensionCaptureCallback", "Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AndroidCameraExtensionSession implements CameraExtensionSessionWrapper {
    private final Executor callbackExecutor;
    private final CameraErrorListener cameraErrorListener;
    private final CameraExtensionSession cameraExtensionSession;
    private final CameraDeviceWrapper device;
    private final Map<CameraExtensionSession, Long> extensionSessionMap;
    private final AtomicLong frameNumbers;
    private final int id;

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean abortCaptures() {
        return false;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Surface getInputSurface() {
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean isReprocessable() {
        return false;
    }

    public AndroidCameraExtensionSession(CameraDeviceWrapper device, CameraExtensionSession cameraExtensionSession, CameraErrorListener cameraErrorListener, Executor callbackExecutor) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(cameraExtensionSession, "cameraExtensionSession");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        this.device = device;
        this.cameraExtensionSession = cameraExtensionSession;
        this.cameraErrorListener = cameraErrorListener;
        this.callbackExecutor = callbackExecutor;
        this.id = CameraInterop.CameraCaptureSessionId.m438constructorimpl(CameraInterop.captureSessionIds.incrementAndGet());
        this.frameNumbers = AtomicFU.atomic(0L);
        this.extensionSessionMap = new HashMap();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraExtensionSessionWrapper, androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public CameraDeviceWrapper getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    /* JADX INFO: renamed from: getId-159jkk4, reason: from getter */
    public int getId() {
        return this.id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer capture(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Exception {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
        CameraErrorListener cameraErrorListener = this.cameraErrorListener;
        try {
            return Integer.valueOf(Build.VERSION.SDK_INT >= 33 ? this.cameraExtensionSession.capture(request, this.callbackExecutor, CameraColorSpace$$ExternalSyntheticApiModelOutline6.m256m((Object) new Camera2CaptureSessionCallbackToExtensionCaptureCallback(this, (Camera2CaptureCallback) listener))) : this.cameraExtensionSession.capture(request, this.callbackExecutor, CameraColorSpace$$ExternalSyntheticApiModelOutline6.m256m((Object) new Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS(this, (Camera2CaptureCallback) listener, new LinkedHashMap()))));
        } catch (Exception e) {
            if (e instanceof CameraAccessException) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                return null;
            }
            if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                return null;
            }
            if (!(e instanceof IllegalStateException)) {
                throw e;
            }
            if (!Log.INSTANCE.getDEBUG_LOGGABLE()) {
                return null;
            }
            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer setRepeatingRequest(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Exception {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
        CameraErrorListener cameraErrorListener = this.cameraErrorListener;
        try {
            return Integer.valueOf(Build.VERSION.SDK_INT >= 33 ? this.cameraExtensionSession.setRepeatingRequest(request, this.callbackExecutor, CameraColorSpace$$ExternalSyntheticApiModelOutline6.m256m((Object) new Camera2CaptureSessionCallbackToExtensionCaptureCallback(this, (Camera2CaptureCallback) listener))) : this.cameraExtensionSession.setRepeatingRequest(request, this.callbackExecutor, CameraColorSpace$$ExternalSyntheticApiModelOutline6.m256m((Object) new Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS(this, (Camera2CaptureCallback) listener, new LinkedHashMap()))));
        } catch (Exception e) {
            if (e instanceof CameraAccessException) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                return null;
            }
            if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                return null;
            }
            if (!(e instanceof IllegalStateException)) {
                throw e;
            }
            if (!Log.INSTANCE.getDEBUG_LOGGABLE()) {
                return null;
            }
            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
            return null;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraExtensionSessionWrapper, androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean stopRepeating() throws Exception {
        Unit unit;
        String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
        CameraErrorListener cameraErrorListener = this.cameraErrorListener;
        try {
            this.cameraExtensionSession.stopRepeating();
            unit = Unit.INSTANCE;
        } catch (Exception e) {
            if (e instanceof CameraAccessException) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
            } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
            } else {
                if (!(e instanceof IllegalStateException)) {
                    throw e;
                }
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                }
            }
            unit = null;
        }
        return unit != null;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer captureBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Exception {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<T> it = requests.iterator();
        while (it.hasNext()) {
            capture((CaptureRequest) it.next(), listener);
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer setRepeatingBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (requests.size() != 1) {
            throw new IllegalStateException("CameraExtensionSession does not support setRepeatingBurst for more than oneCaptureRequest".toString());
        }
        return setRepeatingRequest((CaptureRequest) CollectionsKt.single((List) requests), listener);
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean finalizeOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigs) {
        Intrinsics.checkNotNullParameter(outputConfigs, "outputConfigs");
        if (!Log.INSTANCE.getWARN_LOGGABLE()) {
            return false;
        }
        android.util.Log.w(Log.TAG, "CameraExtensionSession does not support finalizeOutputConfigurations()");
        return false;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ComponentDialog$$ExternalSyntheticApiModelOutline0.m20m()))) {
            return (T) this.cameraExtensionSession;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws CameraAccessException {
        this.cameraExtensionSession.close();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraExtensionSessionWrapper
    public CameraExtensionSession.StillCaptureLatency getRealTimeCaptureLatency() {
        if (Build.VERSION.SDK_INT >= 34) {
            return this.cameraExtensionSession.getRealtimeStillCaptureLatency();
        }
        return null;
    }

    /* JADX INFO: compiled from: ExtensionSessionWrapper.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraExtensionSession$Camera2CaptureSessionCallbackToExtensionCaptureCallback;", "Landroid/hardware/camera2/CameraExtensionSession$ExtensionCaptureCallback;", "captureCallback", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraExtensionSession;Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;)V", "frameQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "onCaptureStarted", "", "session", "Landroid/hardware/camera2/CameraExtensionSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "timestamp", "onCaptureProcessStarted", "onCaptureProcessProgressed", "progress", "", "onCaptureFailed", "onCaptureSequenceCompleted", "sequenceId", "onCaptureSequenceAborted", "onCaptureResultAvailable", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "incrementAndGetNextFrameNumber", "dequeueFrameNumber", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Camera2CaptureSessionCallbackToExtensionCaptureCallback extends CameraExtensionSession$ExtensionCaptureCallback {
        private final Camera2CaptureCallback captureCallback;
        private final ConcurrentLinkedQueue<Long> frameQueue;
        final /* synthetic */ AndroidCameraExtensionSession this$0;

        public void onCaptureProcessStarted(CameraExtensionSession session, CaptureRequest request) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
        }

        public Camera2CaptureSessionCallbackToExtensionCaptureCallback(AndroidCameraExtensionSession androidCameraExtensionSession, Camera2CaptureCallback captureCallback) {
            Intrinsics.checkNotNullParameter(captureCallback, "captureCallback");
            this.this$0 = androidCameraExtensionSession;
            this.captureCallback = captureCallback;
            this.frameQueue = new ConcurrentLinkedQueue<>();
        }

        public void onCaptureStarted(CameraExtensionSession session, CaptureRequest request, long timestamp) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            this.captureCallback.onCaptureStarted(request, incrementAndGetNextFrameNumber(session), timestamp);
        }

        public void onCaptureProcessProgressed(CameraExtensionSession session, CaptureRequest request, int progress) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            this.captureCallback.onCaptureProcessProgressed(request, progress);
        }

        public void onCaptureFailed(CameraExtensionSession session, CaptureRequest request) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            this.captureCallback.mo828onCaptureFailedRuT0dZU(request, FrameNumber.m532constructorimpl(dequeueFrameNumber(session)));
        }

        public void onCaptureSequenceCompleted(CameraExtensionSession session, int sequenceId) {
            Intrinsics.checkNotNullParameter(session, "session");
            Long l = (Long) this.this$0.extensionSessionMap.get(session);
            Camera2CaptureCallback camera2CaptureCallback = this.captureCallback;
            Intrinsics.checkNotNull(l);
            camera2CaptureCallback.onCaptureSequenceCompleted(sequenceId, l.longValue());
        }

        public void onCaptureSequenceAborted(CameraExtensionSession session, int sequenceId) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.captureCallback.onCaptureSequenceAborted(sequenceId);
        }

        public void onCaptureResultAvailable(CameraExtensionSession session, CaptureRequest request, TotalCaptureResult result) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(result, "result");
            this.captureCallback.mo827onCaptureCompletedrmrZIYk(request, result, FrameNumber.m532constructorimpl(dequeueFrameNumber(session)));
        }

        private final long incrementAndGetNextFrameNumber(CameraExtensionSession session) {
            long jIncrementAndGet = this.this$0.frameNumbers.incrementAndGet();
            this.this$0.extensionSessionMap.put(session, Long.valueOf(jIncrementAndGet));
            this.frameQueue.add(Long.valueOf(jIncrementAndGet));
            return jIncrementAndGet;
        }

        private final long dequeueFrameNumber(CameraExtensionSession session) {
            if (this.frameQueue.isEmpty()) {
                incrementAndGetNextFrameNumber(session);
            }
            Long lRemove = this.frameQueue.remove();
            Intrinsics.checkNotNullExpressionValue(lRemove, "remove(...)");
            return lRemove.longValue();
        }
    }

    /* JADX INFO: compiled from: ExtensionSessionWrapper.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraExtensionSession$Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS;", "Landroid/hardware/camera2/CameraExtensionSession$ExtensionCaptureCallback;", "captureCallback", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;", "captureRequestMap", "", "Landroid/hardware/camera2/CaptureRequest;", "", "", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraExtensionSession;Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;Ljava/util/Map;)V", "onCaptureStarted", "", "session", "Landroid/hardware/camera2/CameraExtensionSession;", "request", "timestamp", "onCaptureProcessStarted", "onCaptureFailed", "onCaptureProcessProgressed", "progress", "", "onCaptureSequenceCompleted", "sequenceId", "onCaptureSequenceAborted", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS extends CameraExtensionSession$ExtensionCaptureCallback {
        private final Camera2CaptureCallback captureCallback;
        private final Map<CaptureRequest, List<Long>> captureRequestMap;
        final /* synthetic */ AndroidCameraExtensionSession this$0;

        public void onCaptureProcessStarted(CameraExtensionSession session, CaptureRequest request) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
        }

        public Camera2CaptureSessionCallbackToExtensionCaptureCallbackAndroidS(AndroidCameraExtensionSession androidCameraExtensionSession, Camera2CaptureCallback captureCallback, Map<CaptureRequest, List<Long>> captureRequestMap) {
            Intrinsics.checkNotNullParameter(captureCallback, "captureCallback");
            Intrinsics.checkNotNullParameter(captureRequestMap, "captureRequestMap");
            this.this$0 = androidCameraExtensionSession;
            this.captureCallback = captureCallback;
            this.captureRequestMap = captureRequestMap;
        }

        public void onCaptureStarted(CameraExtensionSession session, CaptureRequest request, long timestamp) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            long jIncrementAndGet = this.this$0.frameNumbers.incrementAndGet();
            this.this$0.extensionSessionMap.put(session, Long.valueOf(jIncrementAndGet));
            Map<CaptureRequest, List<Long>> map = this.captureRequestMap;
            ArrayList arrayList = map.get(request);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(request, arrayList);
            }
            arrayList.add(Long.valueOf(jIncrementAndGet));
            this.captureCallback.onCaptureStarted(request, jIncrementAndGet, timestamp);
        }

        public void onCaptureFailed(CameraExtensionSession session, CaptureRequest request) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            List<Long> list = this.captureRequestMap.get(request);
            Intrinsics.checkNotNull(list);
            if (list.size() == 1) {
                List<Long> list2 = this.captureRequestMap.get(request);
                Intrinsics.checkNotNull(list2);
                this.captureCallback.mo828onCaptureFailedRuT0dZU(request, FrameNumber.m532constructorimpl(list2.get(0).longValue()));
                return;
            }
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                StringBuilder sb = new StringBuilder("onCaptureFailed is not triggered for repeating requests. Request frame numbers: ");
                Object obj = this.captureRequestMap.get(request);
                Intrinsics.checkNotNull(obj);
                sb.append(((List) obj).stream());
                android.util.Log.i(Log.TAG, sb.toString());
            }
        }

        public void onCaptureProcessProgressed(CameraExtensionSession session, CaptureRequest request, int progress) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            this.captureCallback.onCaptureProcessProgressed(request, progress);
        }

        public void onCaptureSequenceCompleted(CameraExtensionSession session, int sequenceId) {
            Intrinsics.checkNotNullParameter(session, "session");
            Long l = (Long) this.this$0.extensionSessionMap.get(session);
            Camera2CaptureCallback camera2CaptureCallback = this.captureCallback;
            Intrinsics.checkNotNull(l);
            camera2CaptureCallback.onCaptureSequenceCompleted(sequenceId, l.longValue());
        }

        public void onCaptureSequenceAborted(CameraExtensionSession session, int sequenceId) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.captureCallback.onCaptureSequenceAborted(sequenceId);
        }
    }
}
