package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraInterop;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CaptureSessionWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u0004\u0018\u00010\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u0004\u0018\u00010\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0016\u0010)\u001a\u00020\u000f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0019H\u0017J'\u0010,\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-00H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H\u0016J3\u00104\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u00105\u001a\u0002062\u000e\b\u0004\u00107\u001a\b\u0012\u0004\u0012\u0002H-08H\u0080\bø\u0001\u0000¢\u0006\u0004\b9\u0010:R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraCaptureSession;", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "device", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "callbackHandler", "Landroid/os/Handler;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;Landroid/hardware/camera2/CameraCaptureSession;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroid/os/Handler;)V", "getDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "abortCaptures", "", "capture", "", "request", "Landroid/hardware/camera2/CaptureRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "captureBurst", "requests", "", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "setRepeatingBurst", "setRepeatingRequest", "stopRepeating", "id", "Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "getId-159jkk4", "()I", "I", "isReprocessable", "()Z", "inputSurface", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "finalizeOutputConfigurations", "outputConfigs", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "close", "", "instrumentAndCatch", "fnName", "", "block", "Lkotlin/Function0;", "instrumentAndCatch$camera_camera2_pipe", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AndroidCameraCaptureSession implements CameraCaptureSessionWrapper {
    private final Handler callbackHandler;
    private final CameraCaptureSession cameraCaptureSession;
    private final CameraErrorListener cameraErrorListener;
    private final CameraDeviceWrapper device;
    private final int id;

    public AndroidCameraCaptureSession(CameraDeviceWrapper device, CameraCaptureSession cameraCaptureSession, CameraErrorListener cameraErrorListener, Handler callbackHandler) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(cameraCaptureSession, "cameraCaptureSession");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(callbackHandler, "callbackHandler");
        this.device = device;
        this.cameraCaptureSession = cameraCaptureSession;
        this.cameraErrorListener = cameraErrorListener;
        this.callbackHandler = callbackHandler;
        this.id = CameraInterop.CameraCaptureSessionId.m438constructorimpl(CameraInterop.captureSessionIds.incrementAndGet());
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public CameraDeviceWrapper getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean abortCaptures() throws Throwable {
        double d;
        Unit unit;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#abortCaptures-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    this.cameraCaptureSession.abortCaptures();
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
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return unit != null;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean stopRepeating() throws Throwable {
        double d;
        Unit unit;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#stopRepeating-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    this.cameraCaptureSession.stopRepeating();
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
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return unit != null;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    /* JADX INFO: renamed from: getId-159jkk4, reason: not valid java name and from getter */
    public int getId() {
        return this.id;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean isReprocessable() {
        return this.cameraCaptureSession.isReprocessable();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Surface getInputSurface() {
        return this.cameraCaptureSession.getInputSurface();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0122  */
    /* JADX WARN: Code duplicated, block: B:49:0x0153  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public boolean finalizeOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigs) throws Throwable {
        double d;
        boolean z;
        Unit unit;
        long jM917constructorimpl;
        Intrinsics.checkNotNullParameter(outputConfigs, "outputConfigs");
        if (Build.VERSION.SDK_INT < 26) {
            throw new IllegalStateException("Attempting to call finalizeOutputConfigurations before O is not supported and may lead to to unexpected behavior if an application is expects this call to succeed.".toString());
        }
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#finalizeOutputConfigurations-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            d = 1000000.0d;
            try {
                try {
                    CameraCaptureSession cameraCaptureSession = this.cameraCaptureSession;
                    List<? extends OutputConfigurationWrapper> list = outputConfigs;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                    }
                    Api26Compat.finalizeOutputConfigurations(cameraCaptureSession, arrayList);
                    unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Trace.endSection();
                    long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" - ");
                        Timestamps timestamps = Timestamps.INSTANCE;
                        String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        sb.append(str2);
                        android.util.Log.d(Log.TAG, sb.toString());
                    }
                    throw th;
                }
            } catch (Exception e) {
                if (!(e instanceof CameraAccessException)) {
                    if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                        }
                        z = false;
                        cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                        unit = null;
                    } else {
                        if (!(e instanceof IllegalStateException)) {
                            throw e;
                        }
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                        }
                    }
                    Trace.endSection();
                    jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" - ");
                        Timestamps timestamps2 = Timestamps.INSTANCE;
                        String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb2.append(str3);
                        android.util.Log.d(Log.TAG, sb2.toString());
                    }
                    if (unit != null) {
                        return true;
                    }
                    return z;
                }
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                }
                cameraErrorListener.mo837onCameraError3M5Xam4(strMo802getCameraIdDz_R5H8, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                unit = null;
            }
            z = false;
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                Timestamps timestamps3 = Timestamps.INSTANCE;
                String str4 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb3.append(str4);
                android.util.Log.d(Log.TAG, sb3.toString());
            }
            if (unit != null) {
                return true;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraCaptureSession.class))) {
            return (T) this.cameraCaptureSession;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.cameraCaptureSession.close();
    }

    public final <T> T instrumentAndCatch$camera_camera2_pipe(String fnName, Function0<? extends T> block) throws Throwable {
        double d;
        T tInvoke;
        Intrinsics.checkNotNullParameter(fnName, "fnName");
        Intrinsics.checkNotNullParameter(block, "block");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#" + fnName + '-' + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            d = 1000000.0d;
            try {
                String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    tInvoke = block.invoke();
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
                    tInvoke = null;
                }
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return tInvoke;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer capture(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#capture-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            d = 1000000.0d;
            try {
                String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    numValueOf = Integer.valueOf(this.cameraCaptureSession.capture(request, listener, this.callbackHandler));
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
                    numValueOf = null;
                }
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer captureBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#captureBurst-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            d = 1000000.0d;
            try {
                String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    numValueOf = Integer.valueOf(this.cameraCaptureSession.captureBurst(requests, listener, this.callbackHandler));
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
                    numValueOf = null;
                }
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer setRepeatingBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#setRepeatingBurst-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            d = 1000000.0d;
            try {
                String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    numValueOf = Integer.valueOf(this.cameraCaptureSession.setRepeatingBurst(requests, listener, this.callbackHandler));
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
                    numValueOf = null;
                }
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    public Integer setRepeatingRequest(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#setRepeatingRequest-" + getDevice().mo802getCameraIdDz_R5H8();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            d = 1000000.0d;
            try {
                String strMo802getCameraIdDz_R5H8 = getDevice().mo802getCameraIdDz_R5H8();
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    numValueOf = Integer.valueOf(this.cameraCaptureSession.setRepeatingRequest(request, listener, this.callbackHandler));
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
                    numValueOf = null;
                }
                Trace.endSection();
                long jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }
}
