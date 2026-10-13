package androidx.camera.camera2.interop;

import androidx.camera.camera2.adapter.CameraControlAdapter;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.compat.Camera2CameraControlCompat;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.UseCaseCameraControl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2CameraControl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0017J\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r8W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/camera/camera2/interop/Camera2CameraControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "compat", "Landroidx/camera/camera2/compat/Camera2CameraControlCompat;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "<init>", "(Landroidx/camera/camera2/compat/Camera2CameraControlCompat;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/ComboRequestListener;)V", "getRequestListener$camera_camera2", "()Landroidx/camera/camera2/impl/ComboRequestListener;", "_useCaseCameraRequestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "reset", "", "setCaptureRequestOptions", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "bundle", "Landroidx/camera/camera2/interop/CaptureRequestOptions;", "addCaptureRequestOptions", "getCaptureRequestOptions", "clearCaptureRequestOptions", "updateAsync", "tag", "", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CameraControl implements UseCaseCameraControl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UseCaseCameraRequestControl _useCaseCameraRequestControl;
    private final Camera2CameraControlCompat compat;
    private final ComboRequestListener requestListener;
    private final UseCaseThreads threads;

    public /* synthetic */ Camera2CameraControl(Camera2CameraControlCompat camera2CameraControlCompat, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(camera2CameraControlCompat, useCaseThreads, comboRequestListener);
    }

    @JvmStatic
    public static final Camera2CameraControl create(Camera2CameraControlCompat camera2CameraControlCompat, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener) {
        return INSTANCE.create(camera2CameraControlCompat, useCaseThreads, comboRequestListener);
    }

    @JvmStatic
    public static final Camera2CameraControl from(CameraControl cameraControl) {
        return INSTANCE.from(cameraControl);
    }

    private Camera2CameraControl(Camera2CameraControlCompat camera2CameraControlCompat, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener) {
        this.compat = camera2CameraControlCompat;
        this.threads = useCaseThreads;
        this.requestListener = comboRequestListener;
    }

    /* JADX INFO: renamed from: getRequestListener$camera_camera2, reason: from getter */
    public final ComboRequestListener getRequestListener() {
        return this.requestListener;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._useCaseCameraRequestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._useCaseCameraRequestControl = useCaseCameraRequestControl;
        if (useCaseCameraRequestControl != null) {
            this.requestListener.removeListener(this.compat);
            this.requestListener.addListener(this.compat, this.threads.getSequentialExecutor());
            this.compat.applyAsync(useCaseCameraRequestControl, false);
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        this.compat.cancelCurrentTask();
        this.requestListener.removeListener(this.compat);
    }

    public final ListenableFuture<Void> setCaptureRequestOptions(CaptureRequestOptions bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.compat.clearRequestOption();
        this.compat.addRequestOption(bundle);
        return updateAsync("setCaptureRequestOptions");
    }

    public final ListenableFuture<Void> addCaptureRequestOptions(CaptureRequestOptions bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.compat.addRequestOption(bundle);
        return updateAsync("addCaptureRequestOptions");
    }

    public final CaptureRequestOptions getCaptureRequestOptions() {
        return this.compat.getRequestOption();
    }

    public final ListenableFuture<Void> clearCaptureRequestOptions() {
        this.compat.clearRequestOption();
        return updateAsync("clearCaptureRequestOptions");
    }

    private final ListenableFuture<Void> updateAsync(String tag) {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asListenableFuture(Camera2CameraControlCompat.applyAsync$default(this.compat, get_requestControl(), false, 2, null), (Object) tag));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    /* JADX INFO: compiled from: Camera2CameraControl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/interop/Camera2CameraControl$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/interop/Camera2CameraControl;", "cameraControl", "Landroidx/camera/core/CameraControl;", "create", "compat", "Landroidx/camera/camera2/compat/Camera2CameraControlCompat;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Camera2CameraControl from(CameraControl cameraControl) {
            Intrinsics.checkNotNullParameter(cameraControl, "cameraControl");
            CameraControlInternal implementation = ((CameraControlInternal) cameraControl).getImplementation();
            Intrinsics.checkNotNullExpressionValue(implementation, "getImplementation(...)");
            Preconditions.checkArgument(implementation instanceof CameraControlAdapter, "CameraControl doesn't contain Camera2 implementation.");
            return ((CameraControlAdapter) implementation).getCamera2cameraControl();
        }

        @JvmStatic
        public final Camera2CameraControl create(Camera2CameraControlCompat compat, UseCaseThreads threads, ComboRequestListener requestListener) {
            Intrinsics.checkNotNullParameter(compat, "compat");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            return new Camera2CameraControl(compat, threads, requestListener, null);
        }
    }
}
