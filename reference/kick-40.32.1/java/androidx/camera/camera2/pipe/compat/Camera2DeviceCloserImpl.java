package androidx.camera.camera2.pipe.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.window.core.layout.WindowSizeClass;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: Camera2DeviceCloser.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ<\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J>\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloserImpl;", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "camera2Quirks", "Landroidx/camera/camera2/pipe/compat/Camera2Quirks;", "retryingCameraStateOpener", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/compat/Camera2Quirks;Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;)V", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "closeCamera", "", "cameraDeviceWrapper", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "androidCameraState", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "shouldReopenCamera", "", "shouldCreateEmptyCaptureSession", "handleQuirksBeforeClosing", "Lkotlin/Pair;", "closeCameraDevice", "createCaptureSession", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2DeviceCloserImpl implements Camera2DeviceCloser {
    public static final long CAMERA_CLOSE_TIMEOUT_MS = 7000;
    private final Camera2Quirks camera2Quirks;
    private final RetryingCameraStateOpener retryingCameraStateOpener;
    private final Threads threads;

    @Inject
    public Camera2DeviceCloserImpl(Threads threads, Camera2Quirks camera2Quirks, RetryingCameraStateOpener retryingCameraStateOpener) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(camera2Quirks, "camera2Quirks");
        Intrinsics.checkNotNullParameter(retryingCameraStateOpener, "retryingCameraStateOpener");
        this.threads = threads;
        this.camera2Quirks = camera2Quirks;
        this.retryingCameraStateOpener = retryingCameraStateOpener;
    }

    public final Threads getThreads() {
        return this.threads;
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceCloser
    public void closeCamera(CameraDeviceWrapper cameraDeviceWrapper, CameraDevice cameraDevice, AndroidCameraState androidCameraState, AudioRestrictionController audioRestrictionController, boolean shouldReopenCamera, boolean shouldCreateEmptyCaptureSession) {
        Intrinsics.checkNotNullParameter(androidCameraState, "androidCameraState");
        Intrinsics.checkNotNullParameter(audioRestrictionController, "audioRestrictionController");
        CameraDevice cameraDevice2 = cameraDeviceWrapper != null ? (CameraDevice) cameraDeviceWrapper.unwrapAs(Reflection.getOrCreateKotlinClass(CameraDevice.class)) : null;
        if (cameraDevice2 == null) {
            if (cameraDevice != null) {
                closeCameraDevice(cameraDevice, androidCameraState);
                return;
            }
            return;
        }
        CameraId.Companion companion = CameraId.INSTANCE;
        String id = cameraDevice2.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String strM427constructorimpl = CameraId.m427constructorimpl(id);
        if (cameraDevice != null && !Intrinsics.areEqual(strM427constructorimpl, cameraDevice.getId())) {
            throw new IllegalStateException(("Unwrapped camera device has camera ID " + strM427constructorimpl + ", but the wrapped camera device has camera ID " + cameraDevice.getId() + '!').toString());
        }
        if (Build.VERSION.SDK_INT >= 30) {
            audioRestrictionController.removeListener(cameraDeviceWrapper);
        }
        CameraDevice cameraDevice3 = cameraDevice2;
        Pair<CameraDeviceWrapper, AndroidCameraState> pairHandleQuirksBeforeClosing = handleQuirksBeforeClosing(cameraDeviceWrapper, cameraDevice3, androidCameraState, shouldReopenCamera, shouldCreateEmptyCaptureSession);
        if (pairHandleQuirksBeforeClosing != null) {
            CameraDeviceWrapper cameraDeviceWrapperComponent1 = pairHandleQuirksBeforeClosing.component1();
            AndroidCameraState androidCameraStateComponent2 = pairHandleQuirksBeforeClosing.component2();
            Object objUnwrapAs = cameraDeviceWrapperComponent1.unwrapAs(Reflection.getOrCreateKotlinClass(CameraDevice.class));
            if (objUnwrapAs == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            cameraDeviceWrapper.onDeviceClosing();
            closeCameraDevice((CameraDevice) objUnwrapAs, androidCameraStateComponent2);
            cameraDeviceWrapper.onDeviceClosed();
            if (shouldReopenCamera) {
                androidCameraState.onFinalized$camera_camera2_pipe(cameraDevice3);
                return;
            }
            return;
        }
        if (Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Failed to handle quirks before closing the camera device!");
        }
        cameraDeviceWrapper.onDeviceClosing();
        cameraDeviceWrapper.onDeviceClosed();
        androidCameraState.onFinalized$camera_camera2_pipe(cameraDevice3);
    }

    private final Pair<CameraDeviceWrapper, AndroidCameraState> handleQuirksBeforeClosing(CameraDeviceWrapper cameraDeviceWrapper, CameraDevice cameraDevice, AndroidCameraState androidCameraState, boolean shouldReopenCamera, boolean shouldCreateEmptyCaptureSession) {
        AwaitOpenCameraResult awaitOpenCameraResult;
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "handleQuirksBeforeClosing(" + cameraDevice + ')');
        }
        String strMo802getCameraIdDz_R5H8 = cameraDeviceWrapper.mo802getCameraIdDz_R5H8();
        if (shouldReopenCamera) {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("Camera2DeviceCloserImpl#reopenCameraDevice");
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Reopening camera device");
                }
                closeCameraDevice(cameraDevice, androidCameraState);
                awaitOpenCameraResult = this.retryingCameraStateOpener.mo895openAndAwaitCameraWithRetry0r8Bogc(strMo802getCameraIdDz_R5H8, this);
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            awaitOpenCameraResult = new AwaitOpenCameraResult(cameraDeviceWrapper, androidCameraState);
        }
        if (awaitOpenCameraResult.getCameraDeviceWrapper() != null && awaitOpenCameraResult.getAndroidCameraState() != null) {
            if (shouldCreateEmptyCaptureSession) {
                Debug debug2 = Debug.INSTANCE;
                try {
                    Trace.beginSection("Camera2DeviceCloserImpl#createCaptureSession");
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Creating an empty capture session before closing " + ((Object) CameraId.m432toStringimpl(strMo802getCameraIdDz_R5H8)));
                    }
                    createCaptureSession(awaitOpenCameraResult.getCameraDeviceWrapper());
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Created an empty capture session.");
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
            return new Pair<>(awaitOpenCameraResult.getCameraDeviceWrapper(), awaitOpenCameraResult.getAndroidCameraState());
        }
        if (!Log.INSTANCE.getERROR_LOGGABLE()) {
            return null;
        }
        android.util.Log.e(Log.TAG, "Failed to retain an opened camera device!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeCameraDevice(CameraDevice cameraDevice, AndroidCameraState androidCameraState) {
        String id = cameraDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "closeCameraDevice(" + id + ')');
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (((Unit) this.threads.runBlockingCheckedOrNull(CAMERA_CLOSE_TIMEOUT_MS, new AnonymousClass2(cameraDevice, booleanRef, null))) == null && Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Failed to close CameraDevice(" + id + ") after 7000ms. The camera is likely in a bad state.");
        }
        CameraId.Companion companion = CameraId.INSTANCE;
        String id2 = cameraDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
        String strM427constructorimpl = CameraId.m427constructorimpl(id2);
        if (this.camera2Quirks.m852shouldWaitForCameraDeviceOnClosedEfqyGwQ$camera_camera2_pipe(strM427constructorimpl) && booleanRef.element) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Waiting for OnClosed from " + ((Object) CameraId.m432toStringimpl(strM427constructorimpl)));
            }
            if (androidCameraState.awaitCameraDeviceClosed$camera_camera2_pipe(2000L)) {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Received OnClosed for " + ((Object) CameraId.m432toStringimpl(strM427constructorimpl)));
                    return;
                }
                return;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to close " + ((Object) CameraId.m432toStringimpl(strM427constructorimpl)) + " after 2000ms!");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl$closeCameraDevice$2, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2DeviceCloser.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl$closeCameraDevice$2", f = "Camera2DeviceCloser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CameraDevice $cameraDevice;
        final /* synthetic */ Ref.BooleanRef $cameraDeviceClosed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CameraDevice cameraDevice, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$cameraDevice = cameraDevice;
            this.$cameraDeviceClosed = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$cameraDevice, this.$cameraDeviceClosed, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CameraDeviceWrapperKt.closeWithTrace(this.$cameraDevice);
            this.$cameraDeviceClosed.element = true;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createCaptureSession(CameraDeviceWrapper cameraDeviceWrapper) throws InterruptedException {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
        final Surface surface = new Surface(surfaceTexture);
        final AtomicBoolean atomicBooleanAtomic = AtomicFU.atomic(false);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (cameraDeviceWrapper.createCaptureSession(CollectionsKt.listOf(surface), new CameraCaptureSessionWrapper.StateCallback() { // from class: androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl$createCaptureSession$callback$1
            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onActive(CameraCaptureSessionWrapper session) {
                Intrinsics.checkNotNullParameter(session, "session");
            }

            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onCaptureQueueEmpty(CameraCaptureSessionWrapper session) {
                Intrinsics.checkNotNullParameter(session, "session");
            }

            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onReady(CameraCaptureSessionWrapper session) {
                Intrinsics.checkNotNullParameter(session, "session");
            }

            @Override // androidx.camera.camera2.pipe.compat.SessionStateCallback
            public void onSessionDisconnected() {
            }

            @Override // androidx.camera.camera2.pipe.compat.SessionStateCallback
            public void onSessionFinalized() {
            }

            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onConfigured(CameraCaptureSessionWrapper session) throws Exception {
                Intrinsics.checkNotNullParameter(session, "session");
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Empty capture session configured. Closing it");
                }
                UByte$$ExternalSyntheticBackport0.m12761m((Object) session);
                countDownLatch.countDown();
            }

            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onClosed(CameraCaptureSessionWrapper session) {
                Intrinsics.checkNotNullParameter(session, "session");
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Empty capture session closed");
                }
                if (atomicBooleanAtomic.compareAndSet(false, true)) {
                    surface.release();
                    surfaceTexture.release();
                }
            }

            @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
            public void onConfigureFailed(CameraCaptureSessionWrapper session) {
                Intrinsics.checkNotNullParameter(session, "session");
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Empty capture session configure failed");
                }
                if (atomicBooleanAtomic.compareAndSet(false, true)) {
                    surface.release();
                    surfaceTexture.release();
                }
                countDownLatch.countDown();
            }
        })) {
            countDownLatch.await();
            return;
        }
        if (Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Failed to create a blank capture session! Surfaces may not be disconnected properly.");
        }
        if (atomicBooleanAtomic.compareAndSet(false, true)) {
            surface.release();
            surfaceTexture.release();
        }
    }
}
