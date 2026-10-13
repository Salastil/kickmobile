package androidx.camera.camera2.pipe.compat;

import android.graphics.ColorSpace;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.AudioRestrictionMode;
import androidx.camera.camera2.pipe.CameraColorSpace;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraInterop;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.RequestsKt;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: CameraDeviceWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0017J&\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010%\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J&\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020,H\u0017J\u0019\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u000205H\u0016J\u000f\u00106\u001a\u000207H\u0017¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000207H\u0017¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020;H\u0016J'\u0010A\u001a\u0004\u0018\u0001HB\"\b\b\u0000\u0010B*\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HB0EH\u0016¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020HH\u0016J.\u0010I\u001a\u0004\u0018\u0001HB\"\u0004\b\u0000\u0010B2\u0006\u0010J\u001a\u00020H2\u000e\b\u0004\u0010K\u001a\b\u0012\u0004\u0012\u0002HB0LH\u0082\b¢\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170O2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\f\u0010P\u001a\u00020;*\u00020\u0017H\u0002J\f\u0010Q\u001a\u00020;*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraDevice;", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "interopCaptureSessionListener", "Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroid/hardware/camera2/CameraDevice;Ljava/lang/String;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;Landroidx/camera/camera2/pipe/core/Threads;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "_lastStateCallback", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/compat/SessionStateCallback;", "createCaptureSession", "", "outputs", "", "Landroid/view/Surface;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "createExtensionSession", "config", "Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "createReprocessableCaptureSession", "input", "Landroid/hardware/camera2/params/InputConfiguration;", "createConstrainedHighSpeedCaptureSession", "createCaptureSessionByOutputConfigurations", "outputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "createReprocessableCaptureSessionByConfigurations", "inputConfig", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "createCaptureRequest-2PPcXtw", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "createReprocessCaptureRequest", "inputResult", "Landroid/hardware/camera2/TotalCaptureResult;", "getCameraAudioRestriction", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getCameraAudioRestriction-_b5Q8KE", "()I", "onCameraAudioRestrictionUpdated", "", "mode", "onCameraAudioRestrictionUpdated-LwUUkyU", "(I)V", "onDeviceClosing", "onDeviceClosed", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "instrumentAndCatch", "fnName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "checkAndSetStateCallback", "Lkotlin/Pair;", "onSessionDisconnectedWithTrace", "onSessionFinalizedWithTrace", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidCameraDevice implements CameraDeviceWrapper {
    private final AtomicRef<SessionStateCallback> _lastStateCallback;
    private final CameraDevice cameraDevice;
    private final CameraErrorListener cameraErrorListener;
    private final String cameraId;
    private final CameraMetadata cameraMetadata;
    private final AtomicBoolean closed;
    private final CameraInterop.CaptureSessionListener interopCaptureSessionListener;
    private final Threads threads;

    public /* synthetic */ AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String str, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraMetadata, cameraDevice, str, cameraErrorListener, captureSessionListener, threads);
    }

    private AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String cameraId, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraMetadata = cameraMetadata;
        this.cameraDevice = cameraDevice;
        this.cameraId = cameraId;
        this.cameraErrorListener = cameraErrorListener;
        this.interopCaptureSessionListener = captureSessionListener;
        this.threads = threads;
        this.closed = AtomicFU.atomic(false);
        this._lastStateCallback = AtomicFU.atomic((Object) null);
    }

    public /* synthetic */ AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String str, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraMetadata, cameraDevice, str, cameraErrorListener, (i & 16) != 0 ? null : captureSessionListener, threads, null);
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name and from getter */
    public String getCameraId() {
        return this.cameraId;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0113 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x011b A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x013c A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0140 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0168 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x019f  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:76:0x0200  */
    /* JADX WARN: Code duplicated, block: B:77:0x0202  */
    /* JADX WARN: Code duplicated, block: B:85:0x0226  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x011b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x0168, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x01dd, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.camera.camera2.pipe.compat.AndroidCameraDevice] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r24v12 */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        ?? r1;
        ?? r11;
        long jM917constructorimpl;
        String str;
        boolean z;
        String str2;
        ?? r24;
        boolean z2;
        boolean z3;
        Unit unit;
        ?? r25;
        ?? r12;
        long jM917constructorimpl2;
        ?? r2 = this;
        String str3 = "format(...)";
        String str4 = "%.3f ms";
        ?? r13 = " - ";
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = r2.checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            r2.onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str5 = "CXCP#createCaptureSession-" + r2.getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str5);
                String cameraId = r2.getCameraId();
                CameraErrorListener cameraErrorListener = r2.cameraErrorListener;
                try {
                    CameraDevice cameraDevice = r2.cameraDevice;
                    try {
                        try {
                            try {
                                CameraDeviceWrapper cameraDeviceWrapper = (CameraDeviceWrapper) r2;
                                CameraErrorListener cameraErrorListener2 = r2.cameraErrorListener;
                                try {
                                    CameraInterop.CaptureSessionListener captureSessionListener = r2.interopCaptureSessionListener;
                                    Handler camera2Handler = r2.threads.getCamera2Handler();
                                    str = str5;
                                    str3 = "format(...)";
                                    str2 = cameraId;
                                    r24 = " - ";
                                    z2 = true;
                                    str4 = "%.3f ms";
                                    try {
                                        cameraDevice.createCaptureSession(outputs, new AndroidCaptureSessionStateCallback(cameraDeviceWrapper, stateCallback, sessionStateCallbackComponent2, cameraErrorListener2, captureSessionListener, camera2Handler), this.threads.getCamera2Handler());
                                        unit = Unit.INSTANCE;
                                        z3 = false;
                                        r12 = z2;
                                        r25 = r24;
                                    } catch (Exception e) {
                                        e = e;
                                        if (e instanceof CameraAccessException) {
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                            }
                                            cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                        } else {
                                            if (e instanceof IllegalArgumentException) {
                                            }
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                            }
                                            z3 = false;
                                            cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                            unit = null;
                                            r12 = z2;
                                            r25 = r24;
                                        }
                                        z3 = false;
                                        unit = null;
                                        r12 = z2;
                                        r25 = r24;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str = str5;
                                    str3 = "format(...)";
                                    str2 = cameraId;
                                    r24 = " - ";
                                    z2 = true;
                                    str4 = "%.3f ms";
                                    if (e instanceof CameraAccessException) {
                                        if (e instanceof IllegalArgumentException) {
                                        }
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z3 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                        unit = null;
                                        r12 = z2;
                                        r25 = r24;
                                        Trace.endSection();
                                        jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            ?? sb = new StringBuilder();
                                            sb.append(str);
                                            sb.append(r25);
                                            Timestamps timestamps = Timestamps.INSTANCE;
                                            String str6 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                            Intrinsics.checkNotNullExpressionValue(str6, str3);
                                            sb.append(str6);
                                            android.util.Log.d(Log.TAG, sb.toString());
                                        }
                                        if (unit == null) {
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                            }
                                            if (sessionStateCallbackComponent2 != null) {
                                                onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                            }
                                        }
                                        return unit != null ? r12 : z3;
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                    z3 = false;
                                    unit = null;
                                    r12 = z2;
                                    r25 = r24;
                                    Trace.endSection();
                                    jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb2 = new StringBuilder();
                                        sb2.append(str);
                                        sb2.append(r25);
                                        Timestamps timestamps2 = Timestamps.INSTANCE;
                                        String str7 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                        Intrinsics.checkNotNullExpressionValue(str7, str3);
                                        sb2.append(str7);
                                        android.util.Log.d(Log.TAG, sb2.toString());
                                    }
                                    if (unit == null) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                        }
                                        if (sessionStateCallbackComponent2 != null) {
                                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                        }
                                    }
                                    if (unit != null) {
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = str5;
                                z = true;
                                str2 = cameraId;
                                z2 = z;
                                r24 = r13;
                                if (e instanceof CameraAccessException) {
                                    if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z3 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    } else {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    unit = null;
                                    r12 = z2;
                                    r25 = r24;
                                    Trace.endSection();
                                    jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb3 = new StringBuilder();
                                        sb3.append(str);
                                        sb3.append(r25);
                                        Timestamps timestamps3 = Timestamps.INSTANCE;
                                        String str8 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                        Intrinsics.checkNotNullExpressionValue(str8, str3);
                                        sb3.append(str8);
                                        android.util.Log.d(Log.TAG, sb3.toString());
                                    }
                                    if (unit == null) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                        }
                                        if (sessionStateCallbackComponent2 != null) {
                                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                        }
                                    }
                                    if (unit != null) {
                                    }
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                }
                                cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                z3 = false;
                                unit = null;
                                r12 = z2;
                                r25 = r24;
                                Trace.endSection();
                                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    ?? sb4 = new StringBuilder();
                                    sb4.append(str);
                                    sb4.append(r25);
                                    Timestamps timestamps4 = Timestamps.INSTANCE;
                                    String str9 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                    Intrinsics.checkNotNullExpressionValue(str9, str3);
                                    sb4.append(str9);
                                    android.util.Log.d(Log.TAG, sb4.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallbackComponent2 != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                    }
                                }
                                if (unit != null) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            r2 = str5;
                            r13 = 1;
                            r1 = r2;
                            r11 = r13;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                ?? sb5 = new StringBuilder();
                                sb5.append(r1);
                                sb5.append(" - ");
                                Timestamps timestamps5 = Timestamps.INSTANCE;
                                String str10 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r11));
                                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                                sb5.append(str10);
                                android.util.Log.d(Log.TAG, sb5.toString());
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str4 = "%.3f ms";
                        r24 = " - ";
                        str = str5;
                        z2 = true;
                        str3 = "format(...)";
                        str2 = cameraId;
                    } catch (Throwable th2) {
                        th = th2;
                        r2 = str5;
                        r13 = 1;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = str5;
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = str5;
                    r13 = 1;
                }
                Trace.endSection();
                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    ?? sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(r25);
                    Timestamps timestamps6 = Timestamps.INSTANCE;
                    String str11 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                    Intrinsics.checkNotNullExpressionValue(str11, str3);
                    sb6.append(str11);
                    android.util.Log.d(Log.TAG, sb6.toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                if (unit != null) {
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = str5;
            r11 = 1;
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                ?? sb7 = new StringBuilder();
                sb7.append(r1);
                sb7.append(" - ");
                Timestamps timestamps7 = Timestamps.INSTANCE;
                String str12 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r11));
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                sb7.append(str12);
                android.util.Log.d(Log.TAG, sb7.toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0285  */
    /* JADX WARN: Code duplicated, block: B:103:0x028c  */
    /* JADX WARN: Code duplicated, block: B:104:0x028e  */
    /* JADX WARN: Code duplicated, block: B:112:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x0197 A[Catch: all -> 0x0290, TryCatch #5 {all -> 0x0290, blocks: (B:30:0x00d6, B:32:0x00e7, B:34:0x00ed, B:36:0x00ff, B:37:0x0103, B:38:0x010e, B:39:0x010f, B:65:0x0193, B:67:0x0197, B:69:0x019f, B:70:0x01b7, B:73:0x01c5, B:75:0x01c9, B:77:0x01cd, B:79:0x01d1, B:82:0x01d6, B:84:0x01da, B:86:0x01e2, B:87:0x01e8, B:88:0x01e9, B:90:0x01f1, B:91:0x0209), top: B:120:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:69:0x019f A[Catch: all -> 0x0290, TryCatch #5 {all -> 0x0290, blocks: (B:30:0x00d6, B:32:0x00e7, B:34:0x00ed, B:36:0x00ff, B:37:0x0103, B:38:0x010e, B:39:0x010f, B:65:0x0193, B:67:0x0197, B:69:0x019f, B:70:0x01b7, B:73:0x01c5, B:75:0x01c9, B:77:0x01cd, B:79:0x01d1, B:82:0x01d6, B:84:0x01da, B:86:0x01e2, B:87:0x01e8, B:88:0x01e9, B:90:0x01f1, B:91:0x0209), top: B:120:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01c5 A[Catch: all -> 0x0290, TryCatch #5 {all -> 0x0290, blocks: (B:30:0x00d6, B:32:0x00e7, B:34:0x00ed, B:36:0x00ff, B:37:0x0103, B:38:0x010e, B:39:0x010f, B:65:0x0193, B:67:0x0197, B:69:0x019f, B:70:0x01b7, B:73:0x01c5, B:75:0x01c9, B:77:0x01cd, B:79:0x01d1, B:82:0x01d6, B:84:0x01da, B:86:0x01e2, B:87:0x01e8, B:88:0x01e9, B:90:0x01f1, B:91:0x0209), top: B:120:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01f1 A[Catch: all -> 0x0290, TryCatch #5 {all -> 0x0290, blocks: (B:30:0x00d6, B:32:0x00e7, B:34:0x00ed, B:36:0x00ff, B:37:0x0103, B:38:0x010e, B:39:0x010f, B:65:0x0193, B:67:0x0197, B:69:0x019f, B:70:0x01b7, B:73:0x01c5, B:75:0x01c9, B:77:0x01cd, B:79:0x01d1, B:82:0x01d6, B:84:0x01da, B:86:0x01e2, B:87:0x01e8, B:88:0x01e9, B:90:0x01f1, B:91:0x0209), top: B:120:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:95:0x022d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0261  */
    /* JADX WARN: Code duplicated, block: B:99:0x0269  */
    /* JADX WARN: Instruction removed from duplicated block: B:69:0x019f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:90:0x01f1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:99:0x0269, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createExtensionSession(ExtensionSessionConfigData config) throws Throwable {
        ?? r25;
        ?? r3;
        ?? r15;
        long jM917constructorimpl;
        String str;
        String str2;
        CameraErrorListener cameraErrorListener;
        boolean z;
        String str3;
        boolean z2;
        Unit unit;
        ?? r26;
        ?? r4;
        long jM917constructorimpl2;
        String str4 = "format(...)";
        ?? r5 = "%.3f ms";
        Intrinsics.checkNotNullParameter(config, "config");
        CameraExtensionSessionWrapper.StateCallback extensionStateCallback = config.getExtensionStateCallback();
        if (extensionStateCallback == null) {
            throw new IllegalStateException("extensionStateCallback must be set to create Extension session".toString());
        }
        if (config.getExtensionMode() == null) {
            throw new IllegalStateException("extensionMode must be set to create Extension session".toString());
        }
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(extensionStateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        ?? r16 = Debug.INSTANCE;
        String str5 = "CXCP#createExtensionSession-" + getCameraId();
        long jMo927nowvQl9yQU = r16.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str5);
                String cameraId = getCameraId();
                CameraErrorListener cameraErrorListener2 = this.cameraErrorListener;
                try {
                    try {
                        int iIntValue = config.getExtensionMode().intValue();
                        List<OutputConfigurationWrapper> outputConfigurations = config.getOutputConfigurations();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputConfigurations, 10));
                        Iterator it = outputConfigurations.iterator();
                        while (it.hasNext()) {
                            arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                        }
                        try {
                            try {
                                str3 = str5;
                                try {
                                    try {
                                        try {
                                            try {
                                                str4 = "format(...)";
                                                r16 = r16;
                                                str3 = str3;
                                                str2 = cameraId;
                                                cameraErrorListener = cameraErrorListener2;
                                                str = "%.3f ms";
                                                z = true;
                                                r4 = 1;
                                                try {
                                                    ExtensionSessionConfiguration extensionSessionConfigurationNewExtensionSessionConfiguration = Api31Compat.newExtensionSessionConfiguration(iIntValue, arrayList, config.getExecutor(), CameraColorSpace$$ExternalSyntheticApiModelOutline6.m257m((Object) new AndroidExtensionSessionStateCallback(this, extensionStateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, config.getExecutor())));
                                                    if (config.getPostviewOutputConfiguration() != null && Build.VERSION.SDK_INT >= 34) {
                                                        OutputConfiguration outputConfiguration = (OutputConfiguration) config.getPostviewOutputConfiguration().unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class));
                                                        if (outputConfiguration == null) {
                                                            throw new IllegalStateException("Failed to unwrap Postview OutputConfiguration".toString());
                                                        }
                                                        Api34Compat.setPostviewOutputConfiguration(extensionSessionConfigurationNewExtensionSessionConfiguration, outputConfiguration);
                                                    }
                                                    Api31Compat.createExtensionCaptureSession(this.cameraDevice, extensionSessionConfigurationNewExtensionSessionConfiguration);
                                                    unit = Unit.INSTANCE;
                                                    z2 = false;
                                                    r26 = r16;
                                                } catch (Exception e) {
                                                    e = e;
                                                    if (!(e instanceof CameraAccessException)) {
                                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                                        }
                                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                                    } else {
                                                        if (e instanceof IllegalArgumentException) {
                                                        }
                                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                                        }
                                                        z2 = false;
                                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                                        unit = null;
                                                        r4 = z;
                                                        r26 = r16;
                                                    }
                                                    z2 = false;
                                                    unit = null;
                                                    r4 = z;
                                                    r26 = r16;
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                str2 = cameraId;
                                                cameraErrorListener = cameraErrorListener2;
                                                str = "%.3f ms";
                                                z = true;
                                                if (!(e instanceof CameraAccessException)) {
                                                    if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                                        }
                                                        z2 = false;
                                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                                    } else {
                                                        if (!(e instanceof IllegalStateException)) {
                                                            throw e;
                                                        }
                                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                                        }
                                                    }
                                                    unit = null;
                                                    r4 = z;
                                                    r26 = r16;
                                                    Trace.endSection();
                                                    jM917constructorimpl2 = DurationNs.m917constructorimpl(r26.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(str3);
                                                        sb.append(" - ");
                                                        Timestamps timestamps = Timestamps.INSTANCE;
                                                        String str6 = String.format(null, str, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                                        Intrinsics.checkNotNullExpressionValue(str6, str4);
                                                        sb.append(str6);
                                                        android.util.Log.d(Log.TAG, sb.toString());
                                                    }
                                                    if (unit == null) {
                                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                            android.util.Log.w(Log.TAG, "Failed to create extension session from " + this.cameraDevice + ". Finalizing previous session");
                                                        }
                                                        if (sessionStateCallbackComponent2 != null) {
                                                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                                        }
                                                    }
                                                    return unit != null ? r4 : z2;
                                                }
                                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                                }
                                                cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                                z2 = false;
                                                unit = null;
                                                r4 = z;
                                                r26 = r16;
                                                Trace.endSection();
                                                jM917constructorimpl2 = DurationNs.m917constructorimpl(r26.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(str3);
                                                    sb2.append(" - ");
                                                    Timestamps timestamps2 = Timestamps.INSTANCE;
                                                    String str7 = String.format(null, str, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                                    Intrinsics.checkNotNullExpressionValue(str7, str4);
                                                    sb2.append(str7);
                                                    android.util.Log.d(Log.TAG, sb2.toString());
                                                }
                                                if (unit == null) {
                                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                        android.util.Log.w(Log.TAG, "Failed to create extension session from " + this.cameraDevice + ". Finalizing previous session");
                                                    }
                                                    if (sessionStateCallbackComponent2 != null) {
                                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                                    }
                                                }
                                                if (unit != null) {
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            cameraErrorListener = cameraErrorListener2;
                                            str2 = cameraId;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        str2 = cameraId;
                                        cameraErrorListener = cameraErrorListener2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r16 = str3;
                                    r5 = 1;
                                    r3 = r5;
                                    r15 = r16;
                                    r25 = r16;
                                    Trace.endSection();
                                    jM917constructorimpl = DurationNs.m917constructorimpl(r25.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb3 = new StringBuilder();
                                        sb3.append(r15);
                                        sb3.append(" - ");
                                        Timestamps timestamps3 = Timestamps.INSTANCE;
                                        String str8 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r3));
                                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                        sb3.append(str8);
                                        android.util.Log.d(Log.TAG, sb3.toString());
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str4 = "format(...)";
                                str = "%.3f ms";
                                str2 = cameraId;
                                cameraErrorListener = cameraErrorListener2;
                                r16 = r16;
                                z = true;
                                str3 = str5;
                            } catch (Throwable th2) {
                                th = th2;
                                r5 = 1;
                                r16 = str5;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str4 = "format(...)";
                            str = "%.3f ms";
                            str2 = cameraId;
                            cameraErrorListener = cameraErrorListener2;
                            r16 = r16;
                            z = true;
                            str3 = str5;
                        } catch (Throwable th3) {
                            th = th3;
                            r5 = 1;
                            r16 = str5;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str4 = "format(...)";
                        str = "%.3f ms";
                        str2 = cameraId;
                        cameraErrorListener = cameraErrorListener2;
                        r16 = r16;
                        z = true;
                        str3 = str5;
                    }
                    Trace.endSection();
                    jM917constructorimpl2 = DurationNs.m917constructorimpl(r26.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str3);
                        sb4.append(" - ");
                        Timestamps timestamps4 = Timestamps.INSTANCE;
                        String str9 = String.format(null, str, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                        Intrinsics.checkNotNullExpressionValue(str9, str4);
                        sb4.append(str9);
                        android.util.Log.d(Log.TAG, sb4.toString());
                    }
                    if (unit == null) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to create extension session from " + this.cameraDevice + ". Finalizing previous session");
                        }
                        if (sessionStateCallbackComponent2 != null) {
                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                        }
                    }
                    if (unit != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r5 = 1;
                    r16 = str5;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            r25 = r16;
            r3 = 1;
            r15 = str5;
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(r25.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                ?? sb5 = new StringBuilder();
                sb5.append(r15);
                sb5.append(" - ");
                Timestamps timestamps5 = Timestamps.INSTANCE;
                String str10 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r3));
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                sb5.append(str10);
                android.util.Log.d(Log.TAG, sb5.toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x021e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r3v12, types: [boolean] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createReprocessableCaptureSession(InputConfiguration input, List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        String str2;
        String str3;
        ?? r12;
        Locale locale;
        long jM917constructorimpl;
        ?? r13;
        String str4;
        String str5;
        String str6;
        boolean z;
        boolean z2;
        Unit unit;
        ?? r14;
        ?? r15 = " - ";
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str7 = "CXCP#createReprocessableCaptureSession-" + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str7);
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            str = "format(...)";
            try {
                try {
                    try {
                        try {
                            str5 = "%.3f ms";
                            str4 = str7;
                            str6 = " - ";
                            z = true;
                            try {
                                this.cameraDevice.createReprocessableCaptureSession(input, outputs, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                                unit = Unit.INSTANCE;
                                z2 = false;
                                r14 = z;
                            } catch (Exception e) {
                                e = e;
                                if (e instanceof CameraAccessException) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                } else {
                                    if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z2 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    } else {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    unit = null;
                                    r14 = z;
                                }
                                z2 = false;
                                unit = null;
                                r14 = z;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str5 = "%.3f ms";
                            str4 = str7;
                            str6 = " - ";
                            z = true;
                        } catch (Throwable th) {
                            th = th;
                            r15 = 1;
                            str3 = " - ";
                            str2 = "%.3f ms";
                            str7 = str7;
                            r13 = r15;
                            locale = null;
                            r12 = r13;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str7);
                                sb.append(str3);
                                Timestamps timestamps = Timestamps.INSTANCE;
                                String str8 = String.format(locale, str2, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r12));
                                Intrinsics.checkNotNullExpressionValue(str8, str);
                                sb.append(str8);
                                android.util.Log.d(Log.TAG, sb.toString());
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str5 = "%.3f ms";
                        str4 = str7;
                        str6 = " - ";
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        r15 = 1;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
                str4 = str7;
                str5 = "%.3f ms";
                str6 = " - ";
                z = true;
            } catch (Throwable th4) {
                th = th4;
                r13 = 1;
                str3 = " - ";
                str2 = "%.3f ms";
                locale = null;
                r12 = r13;
                Trace.endSection();
                jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str7);
                    sb2.append(str3);
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str9 = String.format(locale, str2, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r12));
                    Intrinsics.checkNotNullExpressionValue(str9, str);
                    sb2.append(str9);
                    android.util.Log.d(Log.TAG, sb2.toString());
                }
                throw th;
            }
            Trace.endSection();
            long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(str6);
                Timestamps timestamps3 = Timestamps.INSTANCE;
                String str10 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r14));
                Intrinsics.checkNotNullExpressionValue(str10, str);
                sb3.append(str10);
                android.util.Log.d(Log.TAG, sb3.toString());
            }
            if (unit == null) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                }
                if (sessionStateCallbackComponent2 != null) {
                    onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                }
            }
            return unit != null ? r14 : z2;
        } catch (Throwable th5) {
            th = th5;
            str = "format(...)";
            str2 = "%.3f ms";
            str3 = " - ";
            r12 = 1;
            locale = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0113 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x011b A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x013c A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0140 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0168 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:17:0x009c, B:38:0x010f, B:40:0x0113, B:42:0x011b, B:43:0x012e, B:46:0x013c, B:48:0x0140, B:50:0x0144, B:52:0x0148, B:55:0x014d, B:57:0x0151, B:59:0x0159, B:60:0x015f, B:61:0x0160, B:63:0x0168, B:64:0x017b), top: B:90:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x019f  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:76:0x0200  */
    /* JADX WARN: Code duplicated, block: B:77:0x0202  */
    /* JADX WARN: Code duplicated, block: B:85:0x0226  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x011b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x0168, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x01dd, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.camera.camera2.pipe.compat.AndroidCameraDevice] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r24v12 */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createConstrainedHighSpeedCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        ?? r1;
        ?? r11;
        long jM917constructorimpl;
        String str;
        boolean z;
        String str2;
        ?? r24;
        boolean z2;
        boolean z3;
        Unit unit;
        ?? r25;
        ?? r12;
        long jM917constructorimpl2;
        ?? r2 = this;
        String str3 = "format(...)";
        String str4 = "%.3f ms";
        ?? r13 = " - ";
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = r2.checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            r2.onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str5 = "CXCP#createConstrainedHighSpeedCaptureSession-" + r2.getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str5);
                String cameraId = r2.getCameraId();
                CameraErrorListener cameraErrorListener = r2.cameraErrorListener;
                try {
                    CameraDevice cameraDevice = r2.cameraDevice;
                    try {
                        try {
                            try {
                                CameraDeviceWrapper cameraDeviceWrapper = (CameraDeviceWrapper) r2;
                                CameraErrorListener cameraErrorListener2 = r2.cameraErrorListener;
                                try {
                                    CameraInterop.CaptureSessionListener captureSessionListener = r2.interopCaptureSessionListener;
                                    Handler camera2Handler = r2.threads.getCamera2Handler();
                                    str = str5;
                                    str3 = "format(...)";
                                    str2 = cameraId;
                                    r24 = " - ";
                                    z2 = true;
                                    str4 = "%.3f ms";
                                    try {
                                        cameraDevice.createConstrainedHighSpeedCaptureSession(outputs, new AndroidCaptureSessionStateCallback(cameraDeviceWrapper, stateCallback, sessionStateCallbackComponent2, cameraErrorListener2, captureSessionListener, camera2Handler), this.threads.getCamera2Handler());
                                        unit = Unit.INSTANCE;
                                        z3 = false;
                                        r12 = z2;
                                        r25 = r24;
                                    } catch (Exception e) {
                                        e = e;
                                        if (e instanceof CameraAccessException) {
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                            }
                                            cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                        } else {
                                            if (e instanceof IllegalArgumentException) {
                                            }
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                            }
                                            z3 = false;
                                            cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                            unit = null;
                                            r12 = z2;
                                            r25 = r24;
                                        }
                                        z3 = false;
                                        unit = null;
                                        r12 = z2;
                                        r25 = r24;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str = str5;
                                    str3 = "format(...)";
                                    str2 = cameraId;
                                    r24 = " - ";
                                    z2 = true;
                                    str4 = "%.3f ms";
                                    if (e instanceof CameraAccessException) {
                                        if (e instanceof IllegalArgumentException) {
                                        }
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z3 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                        unit = null;
                                        r12 = z2;
                                        r25 = r24;
                                        Trace.endSection();
                                        jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            ?? sb = new StringBuilder();
                                            sb.append(str);
                                            sb.append(r25);
                                            Timestamps timestamps = Timestamps.INSTANCE;
                                            String str6 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                            Intrinsics.checkNotNullExpressionValue(str6, str3);
                                            sb.append(str6);
                                            android.util.Log.d(Log.TAG, sb.toString());
                                        }
                                        if (unit == null) {
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                            }
                                            if (sessionStateCallbackComponent2 != null) {
                                                onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                            }
                                        }
                                        return unit != null ? r12 : z3;
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                    z3 = false;
                                    unit = null;
                                    r12 = z2;
                                    r25 = r24;
                                    Trace.endSection();
                                    jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb2 = new StringBuilder();
                                        sb2.append(str);
                                        sb2.append(r25);
                                        Timestamps timestamps2 = Timestamps.INSTANCE;
                                        String str7 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                        Intrinsics.checkNotNullExpressionValue(str7, str3);
                                        sb2.append(str7);
                                        android.util.Log.d(Log.TAG, sb2.toString());
                                    }
                                    if (unit == null) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                        }
                                        if (sessionStateCallbackComponent2 != null) {
                                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                        }
                                    }
                                    if (unit != null) {
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = str5;
                                z = true;
                                str2 = cameraId;
                                z2 = z;
                                r24 = r13;
                                if (e instanceof CameraAccessException) {
                                    if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z3 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    } else {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    unit = null;
                                    r12 = z2;
                                    r25 = r24;
                                    Trace.endSection();
                                    jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb3 = new StringBuilder();
                                        sb3.append(str);
                                        sb3.append(r25);
                                        Timestamps timestamps3 = Timestamps.INSTANCE;
                                        String str8 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                        Intrinsics.checkNotNullExpressionValue(str8, str3);
                                        sb3.append(str8);
                                        android.util.Log.d(Log.TAG, sb3.toString());
                                    }
                                    if (unit == null) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                        }
                                        if (sessionStateCallbackComponent2 != null) {
                                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                        }
                                    }
                                    if (unit != null) {
                                    }
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                }
                                cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                z3 = false;
                                unit = null;
                                r12 = z2;
                                r25 = r24;
                                Trace.endSection();
                                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    ?? sb4 = new StringBuilder();
                                    sb4.append(str);
                                    sb4.append(r25);
                                    Timestamps timestamps4 = Timestamps.INSTANCE;
                                    String str9 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                                    Intrinsics.checkNotNullExpressionValue(str9, str3);
                                    sb4.append(str9);
                                    android.util.Log.d(Log.TAG, sb4.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallbackComponent2 != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                    }
                                }
                                if (unit != null) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            r2 = str5;
                            r13 = 1;
                            r1 = r2;
                            r11 = r13;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                ?? sb5 = new StringBuilder();
                                sb5.append(r1);
                                sb5.append(" - ");
                                Timestamps timestamps5 = Timestamps.INSTANCE;
                                String str10 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r11));
                                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                                sb5.append(str10);
                                android.util.Log.d(Log.TAG, sb5.toString());
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str4 = "%.3f ms";
                        r24 = " - ";
                        str = str5;
                        z2 = true;
                        str3 = "format(...)";
                        str2 = cameraId;
                    } catch (Throwable th2) {
                        th = th2;
                        r2 = str5;
                        r13 = 1;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = str5;
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = str5;
                    r13 = 1;
                }
                Trace.endSection();
                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    ?? sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(r25);
                    Timestamps timestamps6 = Timestamps.INSTANCE;
                    String str11 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r12));
                    Intrinsics.checkNotNullExpressionValue(str11, str3);
                    sb6.append(str11);
                    android.util.Log.d(Log.TAG, sb6.toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                if (unit != null) {
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = str5;
            r11 = 1;
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                ?? sb7 = new StringBuilder();
                sb7.append(r1);
                sb7.append(" - ");
                Timestamps timestamps7 = Timestamps.INSTANCE;
                String str12 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r11));
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                sb7.append(str12);
                android.util.Log.d(Log.TAG, sb7.toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00f7 A[Catch: all -> 0x01ee, TryCatch #6 {all -> 0x01ee, blocks: (B:20:0x00bf, B:34:0x00f3, B:36:0x00f7, B:38:0x00ff, B:39:0x0117, B:42:0x0125, B:44:0x0129, B:46:0x012d, B:48:0x0131, B:51:0x0136, B:53:0x013a, B:55:0x0142, B:56:0x0148, B:57:0x0149, B:59:0x0151, B:60:0x0169), top: B:91:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ff A[Catch: all -> 0x01ee, TryCatch #6 {all -> 0x01ee, blocks: (B:20:0x00bf, B:34:0x00f3, B:36:0x00f7, B:38:0x00ff, B:39:0x0117, B:42:0x0125, B:44:0x0129, B:46:0x012d, B:48:0x0131, B:51:0x0136, B:53:0x013a, B:55:0x0142, B:56:0x0148, B:57:0x0149, B:59:0x0151, B:60:0x0169), top: B:91:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0125 A[Catch: all -> 0x01ee, TryCatch #6 {all -> 0x01ee, blocks: (B:20:0x00bf, B:34:0x00f3, B:36:0x00f7, B:38:0x00ff, B:39:0x0117, B:42:0x0125, B:44:0x0129, B:46:0x012d, B:48:0x0131, B:51:0x0136, B:53:0x013a, B:55:0x0142, B:56:0x0148, B:57:0x0149, B:59:0x0151, B:60:0x0169), top: B:91:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0151 A[Catch: all -> 0x01ee, TryCatch #6 {all -> 0x01ee, blocks: (B:20:0x00bf, B:34:0x00f3, B:36:0x00f7, B:38:0x00ff, B:39:0x0117, B:42:0x0125, B:44:0x0129, B:46:0x012d, B:48:0x0131, B:51:0x0136, B:53:0x013a, B:55:0x0142, B:56:0x0148, B:57:0x0149, B:59:0x0151, B:60:0x0169), top: B:91:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:64:0x018d  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ec  */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x00ff, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:59:0x0151, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x01c7, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSessionByOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigurations, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        Debug debug;
        int i;
        String str2;
        String str3;
        boolean z;
        CameraErrorListener cameraErrorListener;
        boolean z2;
        Unit unit;
        ?? r9;
        long jM917constructorimpl;
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug2 = Debug.INSTANCE;
        String str4 = "CXCP#createCaptureSessionByOutputConfigurations-" + getCameraId();
        long jMo927nowvQl9yQU = debug2.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str4);
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener2 = this.cameraErrorListener;
            try {
                try {
                    CameraDevice cameraDevice = this.cameraDevice;
                    List<? extends OutputConfigurationWrapper> list = outputConfigurations;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                    }
                    str2 = cameraId;
                    try {
                        try {
                            debug = debug2;
                            cameraErrorListener = cameraErrorListener2;
                            str3 = "format(...)";
                            i = 1;
                            r9 = 1;
                            z = true;
                            try {
                                try {
                                    Api24Compat.createCaptureSessionByOutputConfigurations(cameraDevice, arrayList, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                                    unit = Unit.INSTANCE;
                                    z2 = false;
                                } catch (Exception e) {
                                    e = e;
                                    if (!(e instanceof CameraAccessException)) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                        }
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                    } else {
                                        if (e instanceof IllegalArgumentException) {
                                        }
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z2 = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                        unit = null;
                                        r9 = z;
                                    }
                                    z2 = false;
                                    unit = null;
                                    r9 = z;
                                }
                                Trace.endSection();
                                jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str4);
                                    sb.append(" - ");
                                    Timestamps timestamps = Timestamps.INSTANCE;
                                    String str5 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r9));
                                    Intrinsics.checkNotNullExpressionValue(str5, str3);
                                    sb.append(str5);
                                    android.util.Log.d(Log.TAG, sb.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallbackComponent2 != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                    }
                                }
                                return unit != null ? r9 : z2;
                            } catch (Throwable th) {
                                th = th;
                                str = str3;
                                Trace.endSection();
                                long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str4);
                                    sb2.append(" - ");
                                    Timestamps timestamps2 = Timestamps.INSTANCE;
                                    String str6 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, i));
                                    Intrinsics.checkNotNullExpressionValue(str6, str);
                                    sb2.append(str6);
                                    android.util.Log.d(Log.TAG, sb2.toString());
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            debug = debug2;
                            cameraErrorListener = cameraErrorListener2;
                            str3 = "format(...)";
                            z = true;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str3 = "format(...)";
                        debug = debug2;
                        z = true;
                        cameraErrorListener = cameraErrorListener2;
                        if (!(e instanceof CameraAccessException)) {
                            if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                }
                                z2 = false;
                                cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                            } else {
                                if (!(e instanceof IllegalStateException)) {
                                    throw e;
                                }
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                }
                            }
                            unit = null;
                            r9 = z;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str4);
                                sb3.append(" - ");
                                Timestamps timestamps3 = Timestamps.INSTANCE;
                                String str7 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r9));
                                Intrinsics.checkNotNullExpressionValue(str7, str3);
                                sb3.append(str7);
                                android.util.Log.d(Log.TAG, sb3.toString());
                            }
                            if (unit == null) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                }
                                if (sessionStateCallbackComponent2 != null) {
                                    onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                }
                            }
                            if (unit != null) {
                            }
                        }
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(str2, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                        z2 = false;
                        unit = null;
                        r9 = z;
                        Trace.endSection();
                        jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str4);
                            sb4.append(" - ");
                            Timestamps timestamps4 = Timestamps.INSTANCE;
                            String str8 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r9));
                            Intrinsics.checkNotNullExpressionValue(str8, str3);
                            sb4.append(str8);
                            android.util.Log.d(Log.TAG, sb4.toString());
                        }
                        if (unit == null) {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                            }
                            if (sessionStateCallbackComponent2 != null) {
                                onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                            }
                        }
                        if (unit != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str3 = "format(...)";
                    debug = debug2;
                    i = 1;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = cameraId;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "format(...)";
            debug = debug2;
            i = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0131 A[Catch: all -> 0x022a, TryCatch #4 {all -> 0x022a, blocks: (B:37:0x012d, B:39:0x0131, B:41:0x0139, B:42:0x0151, B:45:0x015f, B:47:0x0163, B:49:0x0167, B:51:0x016b, B:54:0x0170, B:56:0x0174, B:58:0x017c, B:59:0x0182, B:60:0x0183, B:62:0x018b, B:63:0x01a3, B:23:0x00e4), top: B:89:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0139 A[Catch: all -> 0x022a, TryCatch #4 {all -> 0x022a, blocks: (B:37:0x012d, B:39:0x0131, B:41:0x0139, B:42:0x0151, B:45:0x015f, B:47:0x0163, B:49:0x0167, B:51:0x016b, B:54:0x0170, B:56:0x0174, B:58:0x017c, B:59:0x0182, B:60:0x0183, B:62:0x018b, B:63:0x01a3, B:23:0x00e4), top: B:89:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x015f A[Catch: all -> 0x022a, TryCatch #4 {all -> 0x022a, blocks: (B:37:0x012d, B:39:0x0131, B:41:0x0139, B:42:0x0151, B:45:0x015f, B:47:0x0163, B:49:0x0167, B:51:0x016b, B:54:0x0170, B:56:0x0174, B:58:0x017c, B:59:0x0182, B:60:0x0183, B:62:0x018b, B:63:0x01a3, B:23:0x00e4), top: B:89:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0163 A[Catch: all -> 0x022a, TryCatch #4 {all -> 0x022a, blocks: (B:37:0x012d, B:39:0x0131, B:41:0x0139, B:42:0x0151, B:45:0x015f, B:47:0x0163, B:49:0x0167, B:51:0x016b, B:54:0x0170, B:56:0x0174, B:58:0x017c, B:59:0x0182, B:60:0x0183, B:62:0x018b, B:63:0x01a3, B:23:0x00e4), top: B:89:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x018b A[Catch: all -> 0x022a, TryCatch #4 {all -> 0x022a, blocks: (B:37:0x012d, B:39:0x0131, B:41:0x0139, B:42:0x0151, B:45:0x015f, B:47:0x0163, B:49:0x0167, B:51:0x016b, B:54:0x0170, B:56:0x0174, B:58:0x017c, B:59:0x0182, B:60:0x0183, B:62:0x018b, B:63:0x01a3, B:23:0x00e4), top: B:89:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:71:0x0203  */
    /* JADX WARN: Code duplicated, block: B:73:0x021f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0226  */
    /* JADX WARN: Code duplicated, block: B:76:0x0228  */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x0139, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x018b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x0203, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createReprocessableCaptureSessionByConfigurations(InputConfigData inputConfig, List<? extends OutputConfigurationWrapper> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        String str2;
        int i;
        SessionStateCallback sessionStateCallback;
        ?? r10;
        Unit unit;
        boolean z;
        long jM917constructorimpl;
        String str3;
        boolean z2;
        SessionStateCallback sessionStateCallback2;
        String str4 = "format(...)";
        String str5 = "%.3f ms";
        Intrinsics.checkNotNullParameter(inputConfig, "inputConfig");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str6 = "CXCP#createReprocessableCaptureSessionByConfigurations-" + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str6);
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                try {
                    CameraDevice cameraDevice = this.cameraDevice;
                    InputConfiguration inputConfiguration = new InputConfiguration(inputConfig.getWidth(), inputConfig.getHeight(), inputConfig.getFormat());
                    List<? extends OutputConfigurationWrapper> list = outputs;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            sessionStateCallback2 = sessionStateCallbackComponent2;
                            try {
                                arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                                sessionStateCallbackComponent2 = sessionStateCallback2;
                            } catch (Exception e) {
                                e = e;
                                sessionStateCallback = sessionStateCallback2;
                                z2 = true;
                                str3 = cameraId;
                                if (e instanceof CameraAccessException) {
                                    if (e instanceof IllegalArgumentException) {
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                    }
                                    z = false;
                                    cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    unit = null;
                                    r10 = z2;
                                    Trace.endSection();
                                    jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(str6);
                                        sb.append(" - ");
                                        Timestamps timestamps = Timestamps.INSTANCE;
                                        String str7 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r10));
                                        Intrinsics.checkNotNullExpressionValue(str7, str4);
                                        sb.append(str7);
                                        android.util.Log.d(Log.TAG, sb.toString());
                                    }
                                    if (unit == null) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                                        }
                                        if (sessionStateCallback != null) {
                                            onSessionFinalizedWithTrace(sessionStateCallback);
                                        }
                                    }
                                    return unit != null ? r10 : z;
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                }
                                cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                z = false;
                                unit = null;
                                r10 = z2;
                                Trace.endSection();
                                jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str6);
                                    sb2.append(" - ");
                                    Timestamps timestamps2 = Timestamps.INSTANCE;
                                    String str8 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r10));
                                    Intrinsics.checkNotNullExpressionValue(str8, str4);
                                    sb2.append(str8);
                                    android.util.Log.d(Log.TAG, sb2.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallback != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallback);
                                    }
                                }
                                if (unit != null) {
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            sessionStateCallback2 = sessionStateCallbackComponent2;
                            sessionStateCallback = sessionStateCallback2;
                            z2 = true;
                            str3 = cameraId;
                            if (e instanceof CameraAccessException) {
                                if (e instanceof IllegalArgumentException) {
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                }
                                z = false;
                                cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                unit = null;
                                r10 = z2;
                                Trace.endSection();
                                jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str6);
                                    sb3.append(" - ");
                                    Timestamps timestamps3 = Timestamps.INSTANCE;
                                    String str9 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r10));
                                    Intrinsics.checkNotNullExpressionValue(str9, str4);
                                    sb3.append(str9);
                                    android.util.Log.d(Log.TAG, sb3.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallback != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallback);
                                    }
                                }
                                if (unit != null) {
                                }
                            }
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                            }
                            cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                            z = false;
                            unit = null;
                            r10 = z2;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str6);
                                sb4.append(" - ");
                                Timestamps timestamps4 = Timestamps.INSTANCE;
                                String str10 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r10));
                                Intrinsics.checkNotNullExpressionValue(str10, str4);
                                sb4.append(str10);
                                android.util.Log.d(Log.TAG, sb4.toString());
                            }
                            if (unit == null) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                                }
                                if (sessionStateCallback != null) {
                                    onSessionFinalizedWithTrace(sessionStateCallback);
                                }
                            }
                            if (unit != null) {
                            }
                        }
                    }
                    sessionStateCallback2 = sessionStateCallbackComponent2;
                    ArrayList arrayList2 = arrayList;
                    try {
                        cameraErrorListener = cameraErrorListener;
                        str4 = "format(...)";
                        debug = debug;
                        str3 = cameraId;
                        str5 = "%.3f ms";
                        sessionStateCallback = sessionStateCallback2;
                        i = 1;
                        r10 = 1;
                        z2 = true;
                        try {
                            try {
                                Api24Compat.createReprocessableCaptureSessionByConfigurations(cameraDevice, inputConfiguration, arrayList2, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallback, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                                unit = Unit.INSTANCE;
                                z = false;
                            } catch (Exception e3) {
                                e = e3;
                                if (e instanceof CameraAccessException) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                } else {
                                    if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                        }
                                        z = false;
                                        cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    } else {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    unit = null;
                                    r10 = z2;
                                }
                                z = false;
                                unit = null;
                                r10 = z2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str = str4;
                            str2 = str5;
                            Trace.endSection();
                            long jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(str6);
                                sb5.append(" - ");
                                Timestamps timestamps5 = Timestamps.INSTANCE;
                                String str11 = String.format(null, str2, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, i));
                                Intrinsics.checkNotNullExpressionValue(str11, str);
                                sb5.append(str11);
                                android.util.Log.d(Log.TAG, sb5.toString());
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cameraErrorListener = cameraErrorListener;
                        str4 = "format(...)";
                        debug = debug;
                        str3 = cameraId;
                        sessionStateCallback = sessionStateCallback2;
                        str5 = "%.3f ms";
                        z2 = true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str4 = "format(...)";
                    str5 = "%.3f ms";
                    debug = debug;
                    i = 1;
                }
            } catch (Exception e5) {
                e = e5;
                sessionStateCallback = sessionStateCallbackComponent2;
            }
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str6);
                sb6.append(" - ");
                Timestamps timestamps6 = Timestamps.INSTANCE;
                String str12 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r10));
                Intrinsics.checkNotNullExpressionValue(str12, str4);
                sb6.append(str12);
                android.util.Log.d(Log.TAG, sb6.toString());
            }
            if (unit == null) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                }
                if (sessionStateCallback != null) {
                    onSessionFinalizedWithTrace(sessionStateCallback);
                }
            }
            if (unit != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            str = "format(...)";
            str2 = "%.3f ms";
            debug = debug;
            i = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x02f2 A[Catch: all -> 0x0393, TryCatch #7 {all -> 0x0393, blocks: (B:24:0x00d4, B:26:0x00e3, B:28:0x00e9, B:29:0x00f9, B:30:0x012b, B:33:0x0137, B:35:0x013d, B:43:0x0186, B:45:0x0199, B:46:0x01bd, B:48:0x01c3, B:49:0x01d1, B:50:0x01df, B:52:0x01e5, B:54:0x01f7, B:56:0x0204, B:57:0x0208, B:59:0x0224, B:61:0x022d, B:62:0x0230, B:64:0x0232, B:65:0x0235, B:36:0x0141, B:38:0x0149, B:40:0x0165, B:42:0x016d, B:89:0x0294, B:91:0x0298, B:93:0x02a0, B:94:0x02b8, B:97:0x02c6, B:99:0x02ca, B:101:0x02ce, B:103:0x02d2, B:106:0x02d7, B:108:0x02db, B:110:0x02e3, B:111:0x02e9, B:112:0x02ea, B:114:0x02f2, B:115:0x030a), top: B:147:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x032e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0362  */
    /* JADX WARN: Code duplicated, block: B:123:0x036a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0386  */
    /* JADX WARN: Code duplicated, block: B:127:0x038f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0391  */
    /* JADX WARN: Code duplicated, block: B:136:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:91:0x0298 A[Catch: all -> 0x0393, TryCatch #7 {all -> 0x0393, blocks: (B:24:0x00d4, B:26:0x00e3, B:28:0x00e9, B:29:0x00f9, B:30:0x012b, B:33:0x0137, B:35:0x013d, B:43:0x0186, B:45:0x0199, B:46:0x01bd, B:48:0x01c3, B:49:0x01d1, B:50:0x01df, B:52:0x01e5, B:54:0x01f7, B:56:0x0204, B:57:0x0208, B:59:0x0224, B:61:0x022d, B:62:0x0230, B:64:0x0232, B:65:0x0235, B:36:0x0141, B:38:0x0149, B:40:0x0165, B:42:0x016d, B:89:0x0294, B:91:0x0298, B:93:0x02a0, B:94:0x02b8, B:97:0x02c6, B:99:0x02ca, B:101:0x02ce, B:103:0x02d2, B:106:0x02d7, B:108:0x02db, B:110:0x02e3, B:111:0x02e9, B:112:0x02ea, B:114:0x02f2, B:115:0x030a), top: B:147:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02a0 A[Catch: all -> 0x0393, TryCatch #7 {all -> 0x0393, blocks: (B:24:0x00d4, B:26:0x00e3, B:28:0x00e9, B:29:0x00f9, B:30:0x012b, B:33:0x0137, B:35:0x013d, B:43:0x0186, B:45:0x0199, B:46:0x01bd, B:48:0x01c3, B:49:0x01d1, B:50:0x01df, B:52:0x01e5, B:54:0x01f7, B:56:0x0204, B:57:0x0208, B:59:0x0224, B:61:0x022d, B:62:0x0230, B:64:0x0232, B:65:0x0235, B:36:0x0141, B:38:0x0149, B:40:0x0165, B:42:0x016d, B:89:0x0294, B:91:0x0298, B:93:0x02a0, B:94:0x02b8, B:97:0x02c6, B:99:0x02ca, B:101:0x02ce, B:103:0x02d2, B:106:0x02d7, B:108:0x02db, B:110:0x02e3, B:111:0x02e9, B:112:0x02ea, B:114:0x02f2, B:115:0x030a), top: B:147:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x02c6 A[Catch: all -> 0x0393, TryCatch #7 {all -> 0x0393, blocks: (B:24:0x00d4, B:26:0x00e3, B:28:0x00e9, B:29:0x00f9, B:30:0x012b, B:33:0x0137, B:35:0x013d, B:43:0x0186, B:45:0x0199, B:46:0x01bd, B:48:0x01c3, B:49:0x01d1, B:50:0x01df, B:52:0x01e5, B:54:0x01f7, B:56:0x0204, B:57:0x0208, B:59:0x0224, B:61:0x022d, B:62:0x0230, B:64:0x0232, B:65:0x0235, B:36:0x0141, B:38:0x0149, B:40:0x0165, B:42:0x016d, B:89:0x0294, B:91:0x0298, B:93:0x02a0, B:94:0x02b8, B:97:0x02c6, B:99:0x02ca, B:101:0x02ce, B:103:0x02d2, B:106:0x02d7, B:108:0x02db, B:110:0x02e3, B:111:0x02e9, B:112:0x02ea, B:114:0x02f2, B:115:0x030a), top: B:147:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x02ca A[Catch: all -> 0x0393, TryCatch #7 {all -> 0x0393, blocks: (B:24:0x00d4, B:26:0x00e3, B:28:0x00e9, B:29:0x00f9, B:30:0x012b, B:33:0x0137, B:35:0x013d, B:43:0x0186, B:45:0x0199, B:46:0x01bd, B:48:0x01c3, B:49:0x01d1, B:50:0x01df, B:52:0x01e5, B:54:0x01f7, B:56:0x0204, B:57:0x0208, B:59:0x0224, B:61:0x022d, B:62:0x0230, B:64:0x0232, B:65:0x0235, B:36:0x0141, B:38:0x0149, B:40:0x0165, B:42:0x016d, B:89:0x0294, B:91:0x0298, B:93:0x02a0, B:94:0x02b8, B:97:0x02c6, B:99:0x02ca, B:101:0x02ce, B:103:0x02d2, B:106:0x02d7, B:108:0x02db, B:110:0x02e3, B:111:0x02e9, B:112:0x02ea, B:114:0x02f2, B:115:0x030a), top: B:147:0x0058 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:114:0x02f2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:123:0x036a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x02a0, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.camera.camera2.pipe.compat.SessionConfigData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createCaptureSession(SessionConfigData config) throws Throwable {
        ?? r1;
        ?? r6;
        ?? r3;
        String str;
        long jM917constructorimpl;
        ?? r22;
        String str2;
        String str3;
        CameraErrorListener cameraErrorListener;
        ?? r23;
        boolean z;
        boolean z2;
        Unit unit;
        ?? r24;
        ?? r4;
        long jM917constructorimpl2;
        CameraErrorListener cameraErrorListener2;
        String str4 = "format(...)";
        ?? r5 = "%.3f ms";
        ?? config2 = config;
        Intrinsics.checkNotNullParameter(config2, "config");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(config2.getStateCallback());
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
            Unit unit2 = Unit.INSTANCE;
        }
        Debug debug = Debug.INSTANCE;
        String str5 = "CXCP#createCaptureSession-" + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str5);
                String cameraId = getCameraId();
                CameraErrorListener cameraErrorListener3 = this.cameraErrorListener;
                try {
                    try {
                        int sessionType = config2.getSessionType();
                        List<OutputConfigurationWrapper> outputConfigurations = config2.getOutputConfigurations();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputConfigurations, 10));
                        Iterator it = outputConfigurations.iterator();
                        while (it.hasNext()) {
                            arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                        }
                        ArrayList arrayList2 = arrayList;
                        Executor executor = config2.getExecutor();
                        try {
                            AndroidCameraDevice androidCameraDevice = this;
                            str2 = str5;
                            try {
                                try {
                                    CameraCaptureSessionWrapper.StateCallback stateCallback = config2.getStateCallback();
                                    str3 = cameraId;
                                    try {
                                        try {
                                            debug = debug;
                                            str2 = str2;
                                            str3 = str3;
                                            cameraErrorListener = cameraErrorListener3;
                                            str4 = "format(...)";
                                            r23 = "%.3f ms";
                                            z = true;
                                            r4 = 1;
                                            try {
                                                SessionConfiguration sessionConfigurationNewSessionConfiguration = Api28Compat.newSessionConfiguration(sessionType, arrayList2, executor, new AndroidCaptureSessionStateCallback(androidCameraDevice, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()));
                                                if (config.getInputConfiguration() != null) {
                                                    if (Build.VERSION.SDK_INT >= 31) {
                                                        Api28Compat.setInputConfiguration(sessionConfigurationNewSessionConfiguration, Api31Compat.newInputConfiguration(config.getInputConfiguration(), getCameraId()));
                                                    } else {
                                                        Api28Compat.setInputConfiguration(sessionConfigurationNewSessionConfiguration, new InputConfiguration(((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getWidth(), ((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getHeight(), ((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getFormat()));
                                                    }
                                                }
                                                String strM907getSessionColorSpacedxVZaPA = config.m907getSessionColorSpacedxVZaPA();
                                                if (Build.VERSION.SDK_INT >= 34 && strM907getSessionColorSpacedxVZaPA != null) {
                                                    ColorSpace.Named namedM249toColorSpaceNamedimpl = CameraColorSpace.m249toColorSpaceNamedimpl(strM907getSessionColorSpacedxVZaPA);
                                                    if (namedM249toColorSpaceNamedimpl != null) {
                                                        Api34Compat.setColorSpace(sessionConfigurationNewSessionConfiguration, namedM249toColorSpaceNamedimpl);
                                                    } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                        android.util.Log.w(Log.TAG, "Provided session color space " + strM907getSessionColorSpacedxVZaPA + " is not supported");
                                                    }
                                                } else if (strM907getSessionColorSpacedxVZaPA != null && Log.INSTANCE.getWARN_LOGGABLE()) {
                                                    android.util.Log.w(Log.TAG, "Failed to set session color space to " + strM907getSessionColorSpacedxVZaPA + ", at least API level 34 is required");
                                                }
                                                Debug debug2 = Debug.INSTANCE;
                                                try {
                                                    Trace.beginSection("createCaptureRequest");
                                                    CaptureRequest.Builder builderCreateCaptureRequest = this.cameraDevice.createCaptureRequest(config.getSessionTemplateId());
                                                    Trace.endSection();
                                                    Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "trace(...)");
                                                    Set<CaptureRequest.Key<?>> sessionKeys = this.cameraMetadata.getSessionKeys();
                                                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionKeys, 10));
                                                    Iterator it2 = sessionKeys.iterator();
                                                    while (it2.hasNext()) {
                                                        arrayList3.add(((CaptureRequest.Key) it2.next()).getName());
                                                    }
                                                    ArrayList arrayList4 = arrayList3;
                                                    for (Map.Entry<?, Object> entry : config.getSessionParameters().entrySet()) {
                                                        Object key = entry.getKey();
                                                        Object value = entry.getValue();
                                                        if ((key instanceof CaptureRequest.Key) && arrayList4.contains(((CaptureRequest.Key) key).getName())) {
                                                            RequestsKt.writeParameter(builderCreateCaptureRequest, key, value);
                                                        }
                                                    }
                                                    CaptureRequest captureRequestBuild = builderCreateCaptureRequest.build();
                                                    Intrinsics.checkNotNullExpressionValue(captureRequestBuild, "build(...)");
                                                    Api28Compat.setSessionParameters(sessionConfigurationNewSessionConfiguration, captureRequestBuild);
                                                    Debug debug3 = Debug.INSTANCE;
                                                    try {
                                                        Trace.beginSection("Api28Compat.createCaptureSession");
                                                        Api28Compat.createCaptureSession(this.cameraDevice, sessionConfigurationNewSessionConfiguration);
                                                        Unit unit3 = Unit.INSTANCE;
                                                        Trace.endSection();
                                                        unit = Unit.INSTANCE;
                                                        z2 = false;
                                                        r24 = r23;
                                                    } catch (Throwable th) {
                                                        Trace.endSection();
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    Trace.endSection();
                                                    throw th2;
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                if (e instanceof CameraAccessException) {
                                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                                    }
                                                    cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                                } else {
                                                    if (!(e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                                                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                                        }
                                                        z2 = false;
                                                        cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                                    } else {
                                                        if (!(e instanceof IllegalStateException)) {
                                                            throw e;
                                                        }
                                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                                        }
                                                    }
                                                    unit = null;
                                                    r4 = z;
                                                    r24 = r23;
                                                }
                                                z2 = false;
                                                unit = null;
                                                r4 = z;
                                                r24 = r23;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            cameraErrorListener2 = cameraErrorListener3;
                                            str4 = "format(...)";
                                            r23 = "%.3f ms";
                                            cameraErrorListener = cameraErrorListener2;
                                            z = true;
                                            if (e instanceof CameraAccessException) {
                                                if (e instanceof IllegalArgumentException) {
                                                }
                                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                                }
                                                z2 = false;
                                                cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                                unit = null;
                                                r4 = z;
                                                r24 = r23;
                                                Trace.endSection();
                                                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(str2);
                                                    sb.append(" - ");
                                                    Timestamps timestamps = Timestamps.INSTANCE;
                                                    String str6 = String.format(null, r24, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                                    Intrinsics.checkNotNullExpressionValue(str6, str4);
                                                    sb.append(str6);
                                                    android.util.Log.d(Log.TAG, sb.toString());
                                                }
                                                if (unit == null) {
                                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                                    }
                                                    if (sessionStateCallbackComponent2 != null) {
                                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                                        Unit unit4 = Unit.INSTANCE;
                                                    }
                                                }
                                                return unit != null ? r4 : z2;
                                            }
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                            }
                                            cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                            z2 = false;
                                            unit = null;
                                            r4 = z;
                                            r24 = r23;
                                            Trace.endSection();
                                            jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str2);
                                                sb2.append(" - ");
                                                Timestamps timestamps2 = Timestamps.INSTANCE;
                                                String str7 = String.format(null, r24, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                                Intrinsics.checkNotNullExpressionValue(str7, str4);
                                                sb2.append(str7);
                                                android.util.Log.d(Log.TAG, sb2.toString());
                                            }
                                            if (unit == null) {
                                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                    android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                                }
                                                if (sessionStateCallbackComponent2 != null) {
                                                    onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                                    Unit unit5 = Unit.INSTANCE;
                                                }
                                            }
                                            if (unit != null) {
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        cameraErrorListener2 = cameraErrorListener3;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r22 = "%.3f ms";
                                    debug = debug;
                                    config2 = str2;
                                    r5 = 1;
                                    str4 = "format(...)";
                                    str = str4;
                                    r1 = r22;
                                    r3 = r5;
                                    r6 = config2;
                                    Trace.endSection();
                                    jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        ?? sb3 = new StringBuilder();
                                        sb3.append(r6);
                                        sb3.append(" - ");
                                        Timestamps timestamps3 = Timestamps.INSTANCE;
                                        String str8 = String.format(null, r1, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r3));
                                        Intrinsics.checkNotNullExpressionValue(str8, str);
                                        sb3.append(str8);
                                        android.util.Log.d(Log.TAG, sb3.toString());
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                r23 = "%.3f ms";
                                debug = debug;
                                str3 = cameraId;
                                cameraErrorListener = cameraErrorListener3;
                                str2 = str2;
                                z = true;
                                str4 = "format(...)";
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str2 = str5;
                            str3 = cameraId;
                            cameraErrorListener = cameraErrorListener3;
                            r23 = r5;
                            z = true;
                            if (e instanceof CameraAccessException) {
                                if (e instanceof IllegalArgumentException) {
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                }
                                z2 = false;
                                cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                unit = null;
                                r4 = z;
                                r24 = r23;
                                Trace.endSection();
                                jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str2);
                                    sb4.append(" - ");
                                    Timestamps timestamps4 = Timestamps.INSTANCE;
                                    String str9 = String.format(null, r24, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                    Intrinsics.checkNotNullExpressionValue(str9, str4);
                                    sb4.append(str9);
                                    android.util.Log.d(Log.TAG, sb4.toString());
                                }
                                if (unit == null) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                    }
                                    if (sessionStateCallbackComponent2 != null) {
                                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                        Unit unit6 = Unit.INSTANCE;
                                    }
                                }
                                if (unit != null) {
                                }
                            }
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                            }
                            cameraErrorListener.mo837onCameraError3M5Xam4(str3, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                            z2 = false;
                            unit = null;
                            r4 = z;
                            r24 = r23;
                            Trace.endSection();
                            jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(str2);
                                sb5.append(" - ");
                                Timestamps timestamps5 = Timestamps.INSTANCE;
                                String str10 = String.format(null, r24, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                                Intrinsics.checkNotNullExpressionValue(str10, str4);
                                sb5.append(str10);
                                android.util.Log.d(Log.TAG, sb5.toString());
                            }
                            if (unit == null) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                                }
                                if (sessionStateCallbackComponent2 != null) {
                                    onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                                    Unit unit7 = Unit.INSTANCE;
                                }
                            }
                            if (unit != null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            config2 = str5;
                            r5 = 1;
                            r22 = r5;
                            str = str4;
                            r1 = r22;
                            r3 = r5;
                            r6 = config2;
                            Trace.endSection();
                            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                ?? sb6 = new StringBuilder();
                                sb6.append(r6);
                                sb6.append(" - ");
                                Timestamps timestamps6 = Timestamps.INSTANCE;
                                String str11 = String.format(null, r1, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r3));
                                Intrinsics.checkNotNullExpressionValue(str11, str);
                                sb6.append(str11);
                                android.util.Log.d(Log.TAG, sb6.toString());
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str2 = str5;
                    }
                    Trace.endSection();
                    jM917constructorimpl2 = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str2);
                        sb7.append(" - ");
                        Timestamps timestamps7 = Timestamps.INSTANCE;
                        String str12 = String.format(null, r24, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, (int) r4));
                        Intrinsics.checkNotNullExpressionValue(str12, str4);
                        sb7.append(str12);
                        android.util.Log.d(Log.TAG, sb7.toString());
                    }
                    if (unit == null) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                        }
                        if (sessionStateCallbackComponent2 != null) {
                            onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                            Unit unit8 = Unit.INSTANCE;
                        }
                    }
                    if (unit != null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    config2 = str5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            r1 = "%.3f ms";
            debug = debug;
            r6 = str5;
            r3 = 1;
            str = "format(...)";
            Trace.endSection();
            jM917constructorimpl = DurationNs.m917constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                ?? sb8 = new StringBuilder();
                sb8.append(r6);
                sb8.append(" - ");
                Timestamps timestamps8 = Timestamps.INSTANCE;
                String str13 = String.format(null, r1, Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, (int) r3));
                Intrinsics.checkNotNullExpressionValue(str13, str);
                sb8.append(str13);
                android.util.Log.d(Log.TAG, sb8.toString());
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: createCaptureRequest-2PPcXtw, reason: not valid java name */
    public CaptureRequest.Builder mo800createCaptureRequest2PPcXtw(int template) throws Throwable {
        double d;
        CaptureRequest.Builder builderCreateCaptureRequest;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#createCaptureRequest-" + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String cameraId = getCameraId();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    builderCreateCaptureRequest = this.cameraDevice.createCaptureRequest(template);
                } catch (Exception e) {
                    if (e instanceof CameraAccessException) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                    } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                    } else {
                        if (!(e instanceof IllegalStateException)) {
                            throw e;
                        }
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                        }
                    }
                    builderCreateCaptureRequest = null;
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
                return builderCreateCaptureRequest;
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

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraAudioRestriction-_b5Q8KE, reason: not valid java name */
    public int mo801getCameraAudioRestriction_b5Q8KE() {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("getCameraAudioRestriction");
            return AudioRestrictionMode.m188constructorimpl(Api30Compat.getCameraAudioRestriction(this.cameraDevice));
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController.Listener
    /* JADX INFO: renamed from: onCameraAudioRestrictionUpdated-LwUUkyU, reason: not valid java name */
    public void mo803onCameraAudioRestrictionUpdatedLwUUkyU(int mode) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("setCameraAudioRestriction");
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                Api30Compat.setCameraAudioRestriction(this.cameraDevice, mode);
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                if (e instanceof CameraAccessException) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                    }
                    cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                    }
                    cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                } else {
                    if (!(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                    }
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosing() {
        SessionStateCallback value;
        if (!this.closed.compareAndSet(false, true) || (value = this._lastStateCallback.getValue()) == null) {
            return;
        }
        onSessionDisconnectedWithTrace(value);
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosed() {
        if (!this.closed.getValue()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionStateCallback andSet = this._lastStateCallback.getAndSet(null);
        if (andSet != null) {
            onSessionFinalizedWithTrace(andSet);
        }
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraDevice.class))) {
            return null;
        }
        Object obj = this.cameraDevice;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidCameraDevice.unwrapAs");
        return (T) obj;
    }

    public String toString() {
        return "AndroidCameraDevice(camera=" + ((Object) CameraId.m432toStringimpl(getCameraId())) + ')';
    }

    private final <T> T instrumentAndCatch(String fnName, Function0<? extends T> block) throws Throwable {
        double d;
        T tInvoke;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#" + fnName + '-' + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String cameraId = getCameraId();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    tInvoke = block.invoke();
                } catch (Exception e) {
                    if (e instanceof CameraAccessException) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                    } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
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

    private final Pair<Boolean, SessionStateCallback> checkAndSetStateCallback(SessionStateCallback stateCallback) {
        if (this.closed.getValue()) {
            onSessionFinalizedWithTrace(stateCallback);
            return new Pair<>(false, null);
        }
        return new Pair<>(true, this._lastStateCallback.getAndSet(stateCallback));
    }

    private final void onSessionDisconnectedWithTrace(SessionStateCallback sessionStateCallback) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#onSessionDisconnected");
            sessionStateCallback.onSessionDisconnected();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void onSessionFinalizedWithTrace(SessionStateCallback sessionStateCallback) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#onSessionFinalized");
            sessionStateCallback.onSessionFinalized();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public CaptureRequest.Builder createReprocessCaptureRequest(TotalCaptureResult inputResult) throws Throwable {
        double d;
        CaptureRequest.Builder builderCreateReprocessCaptureRequest;
        Intrinsics.checkNotNullParameter(inputResult, "inputResult");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#createReprocessCaptureRequest-" + getCameraId();
        long jMo927nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String cameraId = getCameraId();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    builderCreateReprocessCaptureRequest = this.cameraDevice.createReprocessCaptureRequest(inputResult);
                } catch (Exception e) {
                    if (e instanceof CameraAccessException) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m360fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                    } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                        }
                        cameraErrorListener.mo837onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false);
                    } else {
                        if (!(e instanceof IllegalStateException)) {
                            throw e;
                        }
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                        }
                    }
                    builderCreateReprocessCaptureRequest = null;
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
                return builderCreateReprocessCaptureRequest;
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
