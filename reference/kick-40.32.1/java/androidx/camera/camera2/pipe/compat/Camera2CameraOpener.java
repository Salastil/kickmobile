package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Threads;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0097@¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraOpener;", "Landroidx/camera/camera2/pipe/compat/CameraOpener;", "cameraManager", "Ljavax/inject/Provider;", "Landroid/hardware/camera2/CameraManager;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Ljavax/inject/Provider;Landroidx/camera/camera2/pipe/core/Threads;)V", "openCamera", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "stateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "openCamera-RzXb1QE", "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CameraOpener implements CameraOpener {
    private final Provider<CameraManager> cameraManager;
    private final Threads threads;

    @Inject
    public Camera2CameraOpener(Provider<CameraManager> cameraManager, Threads threads) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraManager = cameraManager;
        this.threads = threads;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraOpener
    /* JADX INFO: renamed from: openCamera-RzXb1QE, reason: not valid java name */
    public Object mo826openCameraRzXb1QE(String str, CameraDevice.StateCallback stateCallback, Continuation<? super Unit> continuation) {
        CameraManager cameraManager = this.cameraManager.get();
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(((Object) CameraId.m432toStringimpl(str)) + "#openCamera");
            if (Build.VERSION.SDK_INT < 28) {
                cameraManager.openCamera(str, stateCallback, this.threads.getCamera2Handler());
            } else {
                Intrinsics.checkNotNull(cameraManager);
                Api28Compat.openCamera(cameraManager, str, this.threads.getCamera2Executor(), stateCallback);
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
