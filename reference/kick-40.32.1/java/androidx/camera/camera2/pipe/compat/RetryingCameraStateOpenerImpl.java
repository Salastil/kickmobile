package androidx.camera.camera2.pipe.compat;

import android.os.Build;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl;", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "cameraStateOpener", "Landroidx/camera/camera2/pipe/compat/CameraStateOpener;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "cameraAvailabilityMonitor", "Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "devicePolicyManager", "Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "cameraInteropConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraStateOpener;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor;Landroidx/camera/camera2/pipe/core/TimeSource;Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;Landroidx/camera/camera2/pipe/core/Threads;)V", "openCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/OpenCameraResult;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "isForegroundObserver", "Lkotlin/Function1;", "", "", "openCameraWithRetry-aeCOTgg", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAndAwaitCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "openAndAwaitCameraWithRetry-0r8Bogc", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;)Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "cancelOpen", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RetryingCameraStateOpenerImpl implements RetryingCameraStateOpener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AudioRestrictionController audioRestrictionController;
    private final CameraAvailabilityMonitor cameraAvailabilityMonitor;
    private final CameraErrorListener cameraErrorListener;
    private final CameraPipe.CameraInteropConfig cameraInteropConfig;
    private final CameraStateOpener cameraStateOpener;
    private final DevicePolicyManagerWrapper devicePolicyManager;
    private final Threads threads;
    private final TimeSource timeSource;

    @Inject
    public RetryingCameraStateOpenerImpl(CameraStateOpener cameraStateOpener, CameraErrorListener cameraErrorListener, CameraAvailabilityMonitor cameraAvailabilityMonitor, TimeSource timeSource, DevicePolicyManagerWrapper devicePolicyManager, AudioRestrictionController audioRestrictionController, CameraPipe.CameraInteropConfig cameraInteropConfig, Threads threads) {
        Intrinsics.checkNotNullParameter(cameraStateOpener, "cameraStateOpener");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(cameraAvailabilityMonitor, "cameraAvailabilityMonitor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(devicePolicyManager, "devicePolicyManager");
        Intrinsics.checkNotNullParameter(audioRestrictionController, "audioRestrictionController");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraStateOpener = cameraStateOpener;
        this.cameraErrorListener = cameraErrorListener;
        this.cameraAvailabilityMonitor = cameraAvailabilityMonitor;
        this.timeSource = timeSource;
        this.devicePolicyManager = devicePolicyManager;
        this.audioRestrictionController = audioRestrictionController;
        this.cameraInteropConfig = cameraInteropConfig;
        this.threads = threads;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x010f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0136 A[Catch: all -> 0x0089, TRY_ENTER, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:41:0x013c A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0144 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:46:0x014d A[Catch: all -> 0x0089, TRY_ENTER, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:48:0x016f A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0176  */
    /* JADX WARN: Code duplicated, block: B:52:0x018a A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0193  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a5 A[DONT_INVERT, PHI: r18 r19
      0x01a5: PHI (r18v1 java.lang.Object) = (r18v3 java.lang.Object), (r18v4 java.lang.Object) binds: [B:56:0x0198, B:53:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x01a5: PHI (r19v2 androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor$Session) = 
      (r19v3 androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor$Session)
      (r19v4 androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor$Session)
     binds: [B:56:0x0198, B:53:0x0191] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x01a7 A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01af A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x023d  */
    /* JADX WARN: Code duplicated, block: B:67:0x026d  */
    /* JADX WARN: Code duplicated, block: B:70:0x027a A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x0272, B:70:0x027a, B:72:0x0282, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x023f, B:20:0x007e), top: B:82:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x026d -> B:16:0x0058). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    /* JADX INFO: renamed from: openCameraWithRetry-aeCOTgg */
    public java.lang.Object mo896openCameraWithRetryaeCOTgg(java.lang.String r31, androidx.camera.camera2.pipe.compat.Camera2DeviceCloser r32, kotlin.jvm.functions.Function1<? super kotlin.Unit, java.lang.Boolean> r33, kotlin.coroutines.Continuation<? super androidx.camera.camera2.pipe.compat.OpenCameraResult> r34) {
        /*
            Method dump skipped, instruction units count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl.mo896openCameraWithRetryaeCOTgg(java.lang.String, androidx.camera.camera2.pipe.compat.Camera2DeviceCloser, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    /* JADX INFO: renamed from: openAndAwaitCameraWithRetry-0r8Bogc */
    public AwaitOpenCameraResult mo895openAndAwaitCameraWithRetry0r8Bogc(String cameraId, Camera2DeviceCloser camera2DeviceCloser) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(camera2DeviceCloser, "camera2DeviceCloser");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + "#openAndAwaitCameraWithRetry(" + ((Object) CameraId.m432toStringimpl(cameraId)) + ')');
        }
        return (AwaitOpenCameraResult) BuildersKt.runBlocking(this.threads.getBlockingDispatcher(), new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(this, cameraId, camera2DeviceCloser, null));
    }

    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    public void cancelOpen() {
        this.cameraStateOpener.cancelOpen$camera_camera2_pipe();
    }

    /* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl$Companion;", "", "<init>", "()V", "shouldRetry", "", "errorCode", "Landroidx/camera/camera2/pipe/CameraError;", "attempts", "", "elapsedNs", "Landroidx/camera/camera2/pipe/core/DurationNs;", "camerasDisabledByDevicePolicy", "isForeground", "cameraOpenRetryMaxTimeoutNs", "shouldRetry-rbpwgO0$camera_camera2_pipe", "(IIJZZLandroidx/camera/camera2/pipe/core/DurationNs;)Z", "shouldActivateActiveResume", "shouldActivateActiveResume-8PWMtlg$camera_camera2_pipe", "(ZI)Z", "getRetryTimeoutNs", "activeResumeActivated", "getRetryTimeoutNs-om-7c1s$camera_camera2_pipe", "(ZLandroidx/camera/camera2/pipe/core/DurationNs;)J", "getRetryDelayMs", "", "getRetryDelayMs-t8DbYm4$camera_camera2_pipe", "(JZ)J", BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, "d1", "d2", "min-L1EDjxI", "(JLandroidx/camera/camera2/pipe/core/DurationNs;)J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: shouldRetry-rbpwgO0$camera_camera2_pipe$default, reason: not valid java name */
        public static /* synthetic */ boolean m899shouldRetryrbpwgO0$camera_camera2_pipe$default(Companion companion, int i, int i2, long j, boolean z, boolean z2, DurationNs durationNs, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                z2 = true;
            }
            return companion.m903shouldRetryrbpwgO0$camera_camera2_pipe(i, i2, j, z, z2, (i3 & 32) != 0 ? null : durationNs);
        }

        /* JADX INFO: renamed from: shouldRetry-rbpwgO0$camera_camera2_pipe, reason: not valid java name */
        public final boolean m903shouldRetryrbpwgO0$camera_camera2_pipe(int errorCode, int attempts, long elapsedNs, boolean camerasDisabledByDevicePolicy, boolean isForeground, DurationNs cameraOpenRetryMaxTimeoutNs) {
            boolean zM902shouldActivateActiveResume8PWMtlg$camera_camera2_pipe = m902shouldActivateActiveResume8PWMtlg$camera_camera2_pipe(isForeground, errorCode);
            if (zM902shouldActivateActiveResume8PWMtlg$camera_camera2_pipe && Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "shouldRetry: Active resume mode is activated");
            }
            if (DurationNs.m916compareTozYRVrok(elapsedNs, m901getRetryTimeoutNsom7c1s$camera_camera2_pipe(zM902shouldActivateActiveResume8PWMtlg$camera_camera2_pipe, cameraOpenRetryMaxTimeoutNs)) > 0) {
                return false;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m374getERROR_UNDETERMINEDv7Vf74A())) {
                return attempts <= 1;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m365getERROR_CAMERA_IN_USEv7Vf74A())) {
                return Build.VERSION.SDK_INT >= 29 || attempts <= 1;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m366getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A())) {
                return true;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m363getERROR_CAMERA_DISABLEDv7Vf74A())) {
                return !camerasDisabledByDevicePolicy || attempts <= 1;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m362getERROR_CAMERA_DEVICEv7Vf74A()) || CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m369getERROR_CAMERA_SERVICEv7Vf74A()) || CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m364getERROR_CAMERA_DISCONNECTEDv7Vf74A()) || CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m372getERROR_ILLEGAL_ARGUMENT_EXCEPTIONv7Vf74A())) {
                return true;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m373getERROR_SECURITY_EXCEPTIONv7Vf74A())) {
                return attempts <= 1;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m370getERROR_DO_NOT_DISTURB_ENABLEDv7Vf74A())) {
                return false;
            }
            if (CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m375getERROR_UNKNOWN_EXCEPTIONv7Vf74A())) {
                return attempts <= 1;
            }
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Unexpected CameraError: " + RetryingCameraStateOpenerImpl.INSTANCE);
            }
            return false;
        }

        /* JADX INFO: renamed from: shouldActivateActiveResume-8PWMtlg$camera_camera2_pipe, reason: not valid java name */
        public final boolean m902shouldActivateActiveResume8PWMtlg$camera_camera2_pipe(boolean isForeground, int errorCode) {
            int i;
            if (!isForeground || 29 > (i = Build.VERSION.SDK_INT) || i >= 33) {
                return false;
            }
            return CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m365getERROR_CAMERA_IN_USEv7Vf74A()) || CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m366getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A()) || CameraError.m354equalsimpl0(errorCode, CameraError.INSTANCE.m364getERROR_CAMERA_DISCONNECTEDv7Vf74A());
        }

        /* JADX INFO: renamed from: getRetryTimeoutNs-om-7c1s$camera_camera2_pipe$default, reason: not valid java name */
        public static /* synthetic */ long m897getRetryTimeoutNsom7c1s$camera_camera2_pipe$default(Companion companion, boolean z, DurationNs durationNs, int i, Object obj) {
            if ((i & 2) != 0) {
                durationNs = null;
            }
            return companion.m901getRetryTimeoutNsom7c1s$camera_camera2_pipe(z, durationNs);
        }

        /* JADX INFO: renamed from: getRetryTimeoutNs-om-7c1s$camera_camera2_pipe, reason: not valid java name */
        public final long m901getRetryTimeoutNsom7c1s$camera_camera2_pipe(boolean activeResumeActivated, DurationNs cameraOpenRetryMaxTimeoutNs) {
            return !activeResumeActivated ? m898minL1EDjxI(RetryingCameraStateOpenerKt.defaultCameraRetryTimeoutNs, cameraOpenRetryMaxTimeoutNs) : m898minL1EDjxI(RetryingCameraStateOpenerKt.activeResumeCameraRetryTimeoutNs, cameraOpenRetryMaxTimeoutNs);
        }

        /* JADX INFO: renamed from: getRetryDelayMs-t8DbYm4$camera_camera2_pipe, reason: not valid java name */
        public final long m900getRetryDelayMst8DbYm4$camera_camera2_pipe(long elapsedNs, boolean activeResumeActivated) {
            if (activeResumeActivated && DurationNs.m916compareTozYRVrok(elapsedNs, RetryingCameraStateOpenerKt.activeResumeCameraRetryThresholds[0].m925unboximpl()) >= 0) {
                return DurationNs.m916compareTozYRVrok(elapsedNs, RetryingCameraStateOpenerKt.activeResumeCameraRetryThresholds[1].m925unboximpl()) < 0 ? 2000L : 4000L;
            }
            return 500L;
        }

        /* JADX INFO: renamed from: min-L1EDjxI, reason: not valid java name */
        private final long m898minL1EDjxI(long d1, DurationNs d2) {
            return (d2 == null || DurationNs.m916compareTozYRVrok(d1, d2.m925unboximpl()) == -1) ? d1 : d2.m925unboximpl();
        }
    }
}
