package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.PruningProcessingQueue;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.network.HttpSpec;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0003_`aB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJK\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020'0.2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b/\u00100J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020'0.2\u0006\u00102\u001a\u00020$H\u0016J\u001b\u00103\u001a\u00020'2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0001¢\u0006\u0002\b5J\f\u00106\u001a\u00020'*\u00020\u0014H\u0002J\u0016\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020'2\u0006\u00108\u001a\u00020;H\u0082@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020'2\u0006\u00108\u001a\u00020>H\u0082@¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u00020'2\u0006\u00108\u001a\u00020AH\u0082@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020EH\u0082@¢\u0006\u0002\u0010FJ \u0010G\u001a\u00020H2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020;H\u0082@¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020M2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0004\bN\u0010OJ\u001c\u0010P\u001a\u00020'2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001e0RH\u0082@¢\u0006\u0002\u0010SJ\u001c\u0010T\u001a\u00020'2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001a0 H\u0082@¢\u0006\u0002\u0010VJ<\u0010W\u001a\u0004\u0018\u00010X\"\u0004\b\u0000\u0010Y*\b\u0012\u0004\u0012\u0002HY0 2\u0006\u0010Z\u001a\u00020X2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020$0&H\u0082\b¢\u0006\u0002\u0010\\J,\u0010]\u001a\b\u0012\u0004\u0012\u0002HY0 \"\u0004\b\u0000\u0010Y*\b\u0012\u0004\u0012\u0002HY0\u00192\f\u0010^\u001a\b\u0012\u0004\u0012\u00020X0RH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager;", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", "permissions", "Landroidx/camera/camera2/pipe/core/Permissions;", "retryingCameraStateOpener", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "camera2ErrorProcessor", "Landroidx/camera/camera2/pipe/compat/Camera2ErrorProcessor;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/core/Permissions;Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;Landroidx/camera/camera2/pipe/compat/Camera2ErrorProcessor;Landroidx/camera/camera2/pipe/core/Threads;)V", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "queue", "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", "Landroidx/camera/camera2/pipe/compat/CameraRequest;", "activeCameras", "", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "pendingRequestOpens", "", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$PendingRequestOpen;", "open", "Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "sharedCameraIds", "", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "isPrewarm", "", "isForegroundObserver", "Lkotlin/Function1;", "", "open-zDSwpeU", "(Ljava/lang/String;Ljava/util/List;Landroidx/camera/camera2/pipe/graph/GraphListener;ZLkotlin/jvm/functions/Function1;)Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "prewarm", "prewarm-EfqyGwQ", "(Ljava/lang/String;)V", "close", "Lkotlinx/coroutines/Deferred;", "close-EfqyGwQ", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "closeAll", "forceCancelOpen", "prune", "requests", "prune$camera_camera2_pipe", "onRemoved", "process", "request", "(Landroidx/camera/camera2/pipe/compat/CameraRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestOpen", "Landroidx/camera/camera2/pipe/compat/RequestOpen;", "(Landroidx/camera/camera2/pipe/compat/RequestOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestClose", "Landroidx/camera/camera2/pipe/compat/RequestClose;", "(Landroidx/camera/camera2/pipe/compat/RequestClose;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestCloseById", "Landroidx/camera/camera2/pipe/compat/RequestCloseById;", "(Landroidx/camera/camera2/pipe/compat/RequestCloseById;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestCloseAll", "requestCloseAll", "Landroidx/camera/camera2/pipe/compat/RequestCloseAll;", "(Landroidx/camera/camera2/pipe/compat/RequestCloseAll;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveActiveCamera", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "requestOpen", "retrieveActiveCamera-RzXb1QE", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/RequestOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "openCameraWithRetry-zDSwpeU", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectPendingRequestOpens", "cameraIds", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectPendingRequestOpens", "pendingRequestOpensToDisconnect", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstFromIndexOrNull", "", ExifInterface.GPS_DIRECTION_TRUE, FirebaseAnalytics.Param.INDEX, "predicate", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "removeIndices", "indices", "PendingRequestOpen", "RetrieveActiveCameraResult", "OpenVirtualCameraResult", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PruningCamera2DeviceManager implements Camera2DeviceManager {
    private final Set<ActiveCamera> activeCameras;
    private final Camera2DeviceCloser camera2DeviceCloser;
    private final Camera2ErrorProcessor camera2ErrorProcessor;
    private final List<PendingRequestOpen> pendingRequestOpens;
    private final Permissions permissions;
    private final PruningProcessingQueue<CameraRequest> queue;
    private final RetryingCameraStateOpener retryingCameraStateOpener;
    private final CoroutineScope scope;
    private final Threads threads;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$connectPendingRequestOpens$1, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0}, l = {TypedValues.Motion.TYPE_ANIMATE_CIRCLEANGLE_TO}, m = "connectPendingRequestOpens", n = {"pendingRequestOpen"}, s = {"L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.connectPendingRequestOpens(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0}, l = {465, 469}, m = "processRequestClose", n = {"request"}, s = {"L$0"}, v = 1)
    static final class C02031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02031(Continuation<? super C02031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestClose(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 1}, l = {493, 498}, m = "processRequestCloseAll", n = {"requestCloseAll", "requestCloseAll"}, s = {"L$0", "L$0"}, v = 1)
    static final class C02041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02041(Continuation<? super C02041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestCloseAll(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 0, 1}, l = {478, 485}, m = "processRequestCloseById", n = {"request", "cameraId", "request"}, s = {"L$0", "L$1", "L$0"}, v = 1)
    static final class C02051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02051(Continuation<? super C02051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestCloseById(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestOpen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 0, 0, 1, 1, 2, 2, 3}, l = {391, 398, HttpSpec.StatusCode.NOT_FOUND, 436, 437, 445}, m = "processRequestOpen", n = {"request", "cameraIdToOpen", "camerasToClose", "request", "cameraIdToOpen", "request", "cameraIdToOpen", "request"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0"}, v = 1)
    static final class C02061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02061(Continuation<? super C02061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestOpen(null, this);
        }
    }

    static final boolean prewarm_EfqyGwQ$lambda$0(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        return false;
    }

    @Inject
    public PruningCamera2DeviceManager(Permissions permissions, RetryingCameraStateOpener retryingCameraStateOpener, Camera2DeviceCloser camera2DeviceCloser, Camera2ErrorProcessor camera2ErrorProcessor, Threads threads) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(retryingCameraStateOpener, "retryingCameraStateOpener");
        Intrinsics.checkNotNullParameter(camera2DeviceCloser, "camera2DeviceCloser");
        Intrinsics.checkNotNullParameter(camera2ErrorProcessor, "camera2ErrorProcessor");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.permissions = permissions;
        this.retryingCameraStateOpener = retryingCameraStateOpener;
        this.camera2DeviceCloser = camera2DeviceCloser;
        this.camera2ErrorProcessor = camera2ErrorProcessor;
        this.threads = threads;
        CoroutineScope cameraPipeScope = threads.getCameraPipeScope();
        this.scope = cameraPipeScope;
        this.queue = PruningProcessingQueue.INSTANCE.processIn(new PruningProcessingQueue(0, new PruningCamera2DeviceManager$queue$1(this), null, new PruningCamera2DeviceManager$queue$2(this, null), 5, null), cameraPipeScope);
        this.activeCameras = new LinkedHashSet();
        this.pendingRequestOpens = new ArrayList();
    }

    public final Threads getThreads() {
        return this.threads;
    }

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$PendingRequestOpen;", "", "request", "Landroidx/camera/camera2/pipe/compat/RequestOpen;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "<init>", "(Landroidx/camera/camera2/pipe/compat/RequestOpen;Landroidx/camera/camera2/pipe/compat/ActiveCamera;Landroidx/camera/camera2/pipe/core/Token;)V", "getRequest", "()Landroidx/camera/camera2/pipe/compat/RequestOpen;", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "getToken", "()Landroidx/camera/camera2/pipe/core/Token;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class PendingRequestOpen {
        private final ActiveCamera activeCamera;
        private final RequestOpen request;
        private final Token token;

        public PendingRequestOpen(RequestOpen request, ActiveCamera activeCamera, Token token) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
            Intrinsics.checkNotNullParameter(token, "token");
            this.request = request;
            this.activeCamera = activeCamera;
            this.token = token;
        }

        public final RequestOpen getRequest() {
            return this.request;
        }

        public final ActiveCamera getActiveCamera() {
            return this.activeCamera;
        }

        public final Token getToken() {
            return this.token;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: open-zDSwpeU */
    public VirtualCamera mo835openzDSwpeU(String cameraId, List<CameraId> sharedCameraIds, GraphListener graphListener, boolean isPrewarm, Function1<? super Unit, Boolean> isForegroundObserver) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(sharedCameraIds, "sharedCameraIds");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(isForegroundObserver, "isForegroundObserver");
        VirtualCameraState virtualCameraState = new VirtualCameraState(cameraId, graphListener, this.scope, null);
        if (this.queue.tryEmit(new RequestOpen(virtualCameraState, sharedCameraIds, graphListener, isPrewarm, isForegroundObserver))) {
            return virtualCameraState;
        }
        if (Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Camera open request failed for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!');
        }
        graphListener.onGraphError(new GraphState.GraphStateError(CameraError.INSTANCE.m367getERROR_CAMERA_OPENERv7Vf74A(), false, null));
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: prewarm-EfqyGwQ */
    public void mo836prewarmEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        mo835openzDSwpeU(cameraId, CollectionsKt.emptyList(), NoOpGraphListener.INSTANCE, true, new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PruningCamera2DeviceManager.prewarm_EfqyGwQ$lambda$0((Unit) obj));
            }
        });
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: close-EfqyGwQ */
    public Deferred<Unit> mo834closeEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        RequestCloseById requestCloseById = new RequestCloseById(cameraId, null);
        if (!this.queue.tryEmit(requestCloseById)) {
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Camera close by ID request failed for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!');
            }
            requestCloseById.getDeferred().complete(Unit.INSTANCE);
        }
        return requestCloseById.getDeferred();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    public Deferred<Unit> closeAll(boolean forceCancelOpen) {
        if (forceCancelOpen) {
            this.retryingCameraStateOpener.cancelOpen();
        }
        RequestCloseAll requestCloseAll = new RequestCloseAll();
        if (!this.queue.tryEmit(requestCloseAll)) {
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Camera close all request failed!");
            }
            requestCloseAll.getDeferred().complete(Unit.INSTANCE);
        }
        return requestCloseAll.getDeferred();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0156  */
    public final void prune$camera_camera2_pipe(List<CameraRequest> requests) {
        boolean z;
        int iNextIndex;
        Integer numValueOf;
        boolean zContains;
        final CompletableDeferred<Unit> deferred;
        Intrinsics.checkNotNullParameter(requests, "requests");
        List<CameraRequest> list = requests;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CameraRequest) obj) instanceof RequestClose) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        requests.removeAll(arrayList2);
        Iterator it = CollectionsKt.reversed(arrayList2).iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else {
                requests.add(0, (CameraRequest) it.next());
            }
        }
        ListIterator<CameraRequest> listIterator = requests.listIterator(requests.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous() instanceof RequestCloseAll) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex = -1;
                break;
            }
        }
        if (iNextIndex > 0) {
            CameraRequest cameraRequest = requests.get(iNextIndex);
            Intrinsics.checkNotNull(cameraRequest, "null cannot be cast to non-null type androidx.camera.camera2.pipe.compat.RequestCloseAll");
            RequestCloseAll requestCloseAll = (RequestCloseAll) cameraRequest;
            for (int i = 0; i < iNextIndex; i++) {
                CameraRequest cameraRequestRemove = requests.remove(0);
                if (cameraRequestRemove instanceof RequestCloseById) {
                    deferred = ((RequestCloseById) cameraRequestRemove).getDeferred();
                } else {
                    deferred = cameraRequestRemove instanceof RequestCloseAll ? ((RequestCloseAll) cameraRequestRemove).getDeferred() : null;
                }
                if (deferred != null) {
                    requestCloseAll.getDeferred().invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PruningCamera2DeviceManager.prune$lambda$2$0(deferred, (Throwable) obj2);
                        }
                    });
                }
                onRemoved(cameraRequestRemove);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        for (final CameraRequest cameraRequest2 : list) {
            int i3 = i2 + 1;
            if (cameraRequest2 instanceof RequestOpen) {
                RequestOpen requestOpen = (RequestOpen) cameraRequest2;
                String cameraId = requestOpen.getVirtualCamera().getCameraId();
                Set set = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) requestOpen.getSharedCameraIds(), CameraId.m426boximpl(cameraId)));
                int size = requests.size();
                int i4 = i3;
                while (true) {
                    if (i4 >= size) {
                        numValueOf = null;
                        break;
                    }
                    CameraRequest cameraRequest3 = requests.get(i4);
                    if (cameraRequest3 instanceof RequestCloseById) {
                        zContains = set.contains(CameraId.m426boximpl(((RequestCloseById) cameraRequest3).getActiveCameraId()));
                    } else if (cameraRequest3 instanceof RequestOpen) {
                        boolean z2 = (requestOpen.isPrewarm() || !((RequestOpen) cameraRequest3).isPrewarm()) ? true : z;
                        RequestOpen requestOpen2 = (RequestOpen) cameraRequest3;
                        String cameraId2 = requestOpen2.getVirtualCamera().getCameraId();
                        Set set2 = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) requestOpen2.getSharedCameraIds(), CameraId.m426boximpl(cameraId2)));
                        if (!z2 || (!CameraId.m429equalsimpl0(cameraId, cameraId2) && Intrinsics.areEqual(set, set2))) {
                            zContains = false;
                        } else {
                            zContains = true;
                        }
                    } else {
                        zContains = false;
                    }
                    if (zContains) {
                        numValueOf = Integer.valueOf(i4);
                        break;
                    } else {
                        i4++;
                        z = false;
                    }
                }
            } else {
                if (!(cameraRequest2 instanceof RequestCloseById)) {
                    numValueOf = null;
                    break;
                }
                int size2 = requests.size();
                int i5 = i3;
                while (true) {
                    if (i5 >= size2) {
                        numValueOf = null;
                        break;
                    }
                    CameraRequest cameraRequest4 = requests.get(i5);
                    if ((cameraRequest4 instanceof RequestCloseById) && CameraId.m429equalsimpl0(((RequestCloseById) cameraRequest4).getActiveCameraId(), ((RequestCloseById) cameraRequest2).getActiveCameraId())) {
                        numValueOf = Integer.valueOf(i5);
                        break;
                    }
                    i5++;
                }
            }
            if (numValueOf != null) {
                CameraRequest cameraRequest5 = requests.get(numValueOf.intValue());
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, cameraRequest2 + " is pruned by " + cameraRequest5);
                }
                linkedHashSet.add(Integer.valueOf(i2));
                if ((cameraRequest2 instanceof RequestCloseById) && (cameraRequest5 instanceof RequestCloseById)) {
                    ((RequestCloseById) cameraRequest5).getDeferred().invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PruningCamera2DeviceManager.prune$lambda$6(cameraRequest2, (Throwable) obj2);
                        }
                    });
                }
            }
            i2 = i3;
            z = false;
        }
        Iterator it2 = removeIndices(requests, linkedHashSet).iterator();
        while (it2.hasNext()) {
            onRemoved((CameraRequest) it2.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prune$lambda$2$0(CompletableDeferred completableDeferred, Throwable th) {
        completableDeferred.complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit prune$lambda$6(CameraRequest cameraRequest, Throwable th) {
        ((RequestCloseById) cameraRequest).getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    private final void onRemoved(CameraRequest cameraRequest) {
        if (cameraRequest instanceof RequestOpen) {
            VirtualCamera.m908disconnectTPqeGZw$default(((RequestOpen) cameraRequest).getVirtualCamera(), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object process(CameraRequest cameraRequest, Continuation<? super Unit> continuation) {
        if (cameraRequest instanceof RequestOpen) {
            Object objProcessRequestOpen = processRequestOpen((RequestOpen) cameraRequest, continuation);
            return objProcessRequestOpen == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestOpen : Unit.INSTANCE;
        }
        if (cameraRequest instanceof RequestClose) {
            Object objProcessRequestClose = processRequestClose((RequestClose) cameraRequest, continuation);
            return objProcessRequestClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestClose : Unit.INSTANCE;
        }
        if (cameraRequest instanceof RequestCloseById) {
            Object objProcessRequestCloseById = processRequestCloseById((RequestCloseById) cameraRequest, continuation);
            return objProcessRequestCloseById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestCloseById : Unit.INSTANCE;
        }
        if (!(cameraRequest instanceof RequestCloseAll)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objProcessRequestCloseAll = processRequestCloseAll((RequestCloseAll) cameraRequest, continuation);
        return objProcessRequestCloseAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestCloseAll : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:103:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:106:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:112:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:116:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:121:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:124:0x0304  */
    /* JADX WARN: Code duplicated, block: B:126:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:? A[LOOP:0: B:87:0x025f->B:129:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:? A[LOOP:1: B:95:0x0285->B:130:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x02fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:? A[LOOP:2: B:54:0x0189->B:134:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x017b A[LOOP:3: B:50:0x0175->B:52:0x017b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x018f  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:71:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:72:0x0208  */
    /* JADX WARN: Code duplicated, block: B:74:0x0210  */
    /* JADX WARN: Code duplicated, block: B:77:0x022b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0231  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:81:0x0247  */
    /* JADX WARN: Code duplicated, block: B:83:0x0251  */
    /* JADX WARN: Code duplicated, block: B:86:0x025b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0265  */
    /* JADX WARN: Code duplicated, block: B:91:0x0277  */
    /* JADX WARN: Code duplicated, block: B:94:0x0281  */
    /* JADX WARN: Code duplicated, block: B:97:0x028b  */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02d7, code lost:
    
        if (connectPendingRequestOpens(r11, r0) == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02f8, code lost:
    
        if (r12.connectTo(r10, r0, r0) == r1) goto L118;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x01e0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x0210, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processRequestOpen(androidx.camera.camera2.pipe.compat.RequestOpen r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.processRequestOpen(androidx.camera.camera2.pipe.compat.RequestOpen, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d3, code lost:
    
        if (r8.awaitClosed(r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processRequestClose(androidx.camera.camera2.pipe.compat.RequestClose r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.processRequestClose(androidx.camera.camera2.pipe.compat.RequestClose, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processRequestCloseById(RequestCloseById requestCloseById, Continuation<? super Unit> continuation) {
        C02051 c02051;
        RequestCloseById requestCloseById2;
        String str;
        Object next;
        RequestCloseById requestCloseById3;
        if (continuation instanceof C02051) {
            c02051 = (C02051) continuation;
            if ((c02051.label & Integer.MIN_VALUE) != 0) {
                c02051.label -= Integer.MIN_VALUE;
            } else {
                c02051 = new C02051(continuation);
            }
        } else {
            c02051 = new C02051(continuation);
        }
        Object obj = c02051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String activeCameraId = requestCloseById.getActiveCameraId();
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCamera2DeviceManager#processRequestCloseById(" + ((Object) CameraId.m432toStringimpl(requestCloseById.getActiveCameraId())) + ')');
            }
            List<PendingRequestOpen> list = this.pendingRequestOpens;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (CameraId.m429equalsimpl0(((PendingRequestOpen) obj2).getRequest().getVirtualCamera().getCameraId(), activeCameraId)) {
                    arrayList.add(obj2);
                }
            }
            c02051.L$0 = requestCloseById;
            c02051.L$1 = activeCameraId;
            c02051.label = 1;
            if (disconnectPendingRequestOpens(arrayList, c02051) != coroutine_suspended) {
                requestCloseById2 = requestCloseById;
                str = activeCameraId;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c02051.L$1;
            requestCloseById2 = (RequestCloseById) c02051.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            requestCloseById3 = (RequestCloseById) c02051.L$0;
            ResultKt.throwOnFailure(obj);
        }
        requestCloseById2 = requestCloseById3;
        requestCloseById2.getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
        Iterator<T> it = this.activeCameras.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!CameraId.m429equalsimpl0(((ActiveCamera) next).m798getCameraIdDz_R5H8(), str));
        ActiveCamera activeCamera = (ActiveCamera) next;
        if (activeCamera != null) {
            this.activeCameras.remove(activeCamera);
            activeCamera.close();
            c02051.L$0 = requestCloseById2;
            c02051.L$1 = null;
            c02051.label = 2;
            if (activeCamera.awaitClosed(c02051) != coroutine_suspended) {
                requestCloseById3 = requestCloseById2;
                requestCloseById2 = requestCloseById3;
            }
            return coroutine_suspended;
        }
        requestCloseById2.getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:? A[LOOP:0: B:27:0x0082->B:37:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (disconnectPendingRequestOpens(r7, r0) == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processRequestCloseAll(androidx.camera.camera2.pipe.compat.RequestCloseAll r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.C02041
            if (r0 == 0) goto L14
            r0 = r7
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1 r0 = (androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.C02041) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1 r0 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$0
            androidx.camera.camera2.pipe.compat.RequestCloseAll r2 = (androidx.camera.camera2.pipe.compat.RequestCloseAll) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L82
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            java.lang.Object r6 = r0.L$0
            androidx.camera.camera2.pipe.compat.RequestCloseAll r6 = (androidx.camera.camera2.pipe.compat.RequestCloseAll) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L64
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.camera.camera2.pipe.core.Log r7 = androidx.camera.camera2.pipe.core.Log.INSTANCE
            boolean r7 = r7.getINFO_LOGGABLE()
            if (r7 == 0) goto L57
            java.lang.String r7 = "CXCP"
            java.lang.String r2 = "PruningCamera2DeviceManager#processRequestCloseAll()"
            android.util.Log.i(r7, r2)
        L57:
            java.util.List<androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$PendingRequestOpen> r7 = r5.pendingRequestOpens
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.disconnectPendingRequestOpens(r7, r0)
            if (r7 != r1) goto L64
            goto L9a
        L64:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r7 = r5.activeCameras
            java.util.Iterator r7 = r7.iterator()
        L6a:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L7a
            java.lang.Object r2 = r7.next()
            androidx.camera.camera2.pipe.compat.ActiveCamera r2 = (androidx.camera.camera2.pipe.compat.ActiveCamera) r2
            r2.close()
            goto L6a
        L7a:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r7 = r5.activeCameras
            java.util.Iterator r7 = r7.iterator()
            r2 = r6
            r6 = r7
        L82:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L9b
            java.lang.Object r7 = r6.next()
            androidx.camera.camera2.pipe.compat.ActiveCamera r7 = (androidx.camera.camera2.pipe.compat.ActiveCamera) r7
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r7.awaitClosed(r0)
            if (r7 != r1) goto L82
        L9a:
            return r1
        L9b:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r5 = r5.activeCameras
            r5.clear()
            kotlinx.coroutines.CompletableDeferred r5 = r2.getDeferred()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.complete(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.processRequestCloseAll(androidx.camera.camera2.pipe.compat.RequestCloseAll, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0084  */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x009b  */
    /* JADX WARN: Code duplicated, block: B:63:0x007e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[LOOP:0: B:17:0x0068->B:65:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009b -> B:28:0x009e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: retrieveActiveCamera-RzXb1QE, reason: not valid java name */
    public final java.lang.Object m884retrieveActiveCameraRzXb1QE(java.lang.String r15, androidx.camera.camera2.pipe.compat.RequestOpen r16, kotlin.coroutines.Continuation<? super androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.RetrieveActiveCameraResult> r17) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.m884retrieveActiveCameraRzXb1QE(java.lang.String, androidx.camera.camera2.pipe.compat.RequestOpen, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: openCameraWithRetry-zDSwpeU, reason: not valid java name */
    public final Object m883openCameraWithRetryzDSwpeU(String str, List<CameraId> list, Function1<? super Unit, Boolean> function1, CoroutineScope coroutineScope, Continuation<? super OpenVirtualCameraResult> continuation) {
        PruningCamera2DeviceManager$openCameraWithRetry$1 pruningCamera2DeviceManager$openCameraWithRetry$1;
        if (continuation instanceof PruningCamera2DeviceManager$openCameraWithRetry$1) {
            pruningCamera2DeviceManager$openCameraWithRetry$1 = (PruningCamera2DeviceManager$openCameraWithRetry$1) continuation;
            if ((pruningCamera2DeviceManager$openCameraWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                pruningCamera2DeviceManager$openCameraWithRetry$1.label -= Integer.MIN_VALUE;
            } else {
                pruningCamera2DeviceManager$openCameraWithRetry$1 = new PruningCamera2DeviceManager$openCameraWithRetry$1(this, continuation);
            }
        } else {
            pruningCamera2DeviceManager$openCameraWithRetry$1 = new PruningCamera2DeviceManager$openCameraWithRetry$1(this, continuation);
        }
        Object objMo896openCameraWithRetryaeCOTgg = pruningCamera2DeviceManager$openCameraWithRetry$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = pruningCamera2DeviceManager$openCameraWithRetry$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo896openCameraWithRetryaeCOTgg);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Opening " + ((Object) CameraId.m432toStringimpl(str)) + " with retries...");
            }
            RetryingCameraStateOpener retryingCameraStateOpener = this.retryingCameraStateOpener;
            Camera2DeviceCloser camera2DeviceCloser = this.camera2DeviceCloser;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$0 = str;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$1 = list;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$2 = coroutineScope;
            pruningCamera2DeviceManager$openCameraWithRetry$1.label = 1;
            objMo896openCameraWithRetryaeCOTgg = retryingCameraStateOpener.mo896openCameraWithRetryaeCOTgg(str, camera2DeviceCloser, function1, pruningCamera2DeviceManager$openCameraWithRetry$1);
            if (objMo896openCameraWithRetryaeCOTgg == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) pruningCamera2DeviceManager$openCameraWithRetry$1.L$2;
            list = (List) pruningCamera2DeviceManager$openCameraWithRetry$1.L$1;
            str = (String) pruningCamera2DeviceManager$openCameraWithRetry$1.L$0;
            ResultKt.throwOnFailure(objMo896openCameraWithRetryaeCOTgg);
        }
        OpenCameraResult openCameraResult = (OpenCameraResult) objMo896openCameraWithRetryaeCOTgg;
        if (openCameraResult.getCameraState() == null) {
            return new OpenVirtualCameraResult.Error(openCameraResult.m879getErrorCodemVEW8x0(), null);
        }
        return new OpenVirtualCameraResult.Success(new ActiveCamera(openCameraResult.getCameraState(), CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) list, CameraId.m426boximpl(str))), coroutineScope, new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PruningCamera2DeviceManager.openCameraWithRetry_zDSwpeU$lambda$1(this.f$0, (ActiveCamera) obj);
            }
        }));
    }

    static final Unit openCameraWithRetry_zDSwpeU$lambda$1(PruningCamera2DeviceManager pruningCamera2DeviceManager, ActiveCamera activeCamera) {
        Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
        pruningCamera2DeviceManager.queue.tryEmit(new RequestClose(activeCamera));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0081  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:45:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0115 -> B:46:0x0118). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x00c1
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object connectPendingRequestOpens(java.util.Set<androidx.camera.camera2.pipe.CameraId> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.connectPendingRequestOpens(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object disconnectPendingRequestOpens(List<PendingRequestOpen> list, Continuation<? super Unit> continuation) {
        for (PendingRequestOpen pendingRequestOpen : list) {
            pendingRequestOpen.getToken().release();
            this.pendingRequestOpens.remove(pendingRequestOpen);
        }
        return Unit.INSTANCE;
    }

    private final <T> Integer firstFromIndexOrNull(List<? extends T> list, int i, Function1<? super T, Boolean> function1) {
        int size = list.size();
        while (i < size) {
            if (function1.invoke(list.get(i)).booleanValue()) {
                return Integer.valueOf(i);
            }
            i++;
        }
        return null;
    }

    private final <T> List<T> removeIndices(List<T> list, Set<Integer> set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.sorted(set).iterator();
        while (it.hasNext()) {
            arrayList.add(list.remove(((Number) it.next()).intValue() - arrayList.size()));
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "", "Success", "Error", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Success;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface RetrieveActiveCameraResult {

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Success;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;Landroidx/camera/camera2/pipe/core/Token;)V", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "getToken", "()Landroidx/camera/camera2/pipe/core/Token;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success implements RetrieveActiveCameraResult {
            private final ActiveCamera activeCamera;
            private final Token token;

            public static /* synthetic */ Success copy$default(Success success, ActiveCamera activeCamera, Token token, int i, Object obj) {
                if ((i & 1) != 0) {
                    activeCamera = success.activeCamera;
                }
                if ((i & 2) != 0) {
                    token = success.token;
                }
                return success.copy(activeCamera, token);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Token getToken() {
                return this.token;
            }

            public final Success copy(ActiveCamera activeCamera, Token token) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                Intrinsics.checkNotNullParameter(token, "token");
                return new Success(activeCamera, token);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.activeCamera, success.activeCamera) && Intrinsics.areEqual(this.token, success.token);
            }

            public int hashCode() {
                return (this.activeCamera.hashCode() * 31) + this.token.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ", token=" + this.token + ')';
            }

            public Success(ActiveCamera activeCamera, Token token) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                Intrinsics.checkNotNullParameter(token, "token");
                this.activeCamera = activeCamera;
                this.token = token;
            }

            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public final Token getToken() {
                return this.token;
            }
        }

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\tJ\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLastCameraError-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-mVEW8x0", "copy", "copy-TPqeGZw", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error implements RetrieveActiveCameraResult {
            private final CameraError lastCameraError;

            public /* synthetic */ Error(CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
                this(cameraError);
            }

            /* JADX INFO: renamed from: copy-TPqeGZw$default, reason: not valid java name */
            public static /* synthetic */ Error m889copyTPqeGZw$default(Error error, CameraError cameraError, int i, Object obj) {
                if ((i & 1) != 0) {
                    cameraError = error.lastCameraError;
                }
                return error.m891copyTPqeGZw(cameraError);
            }

            /* JADX INFO: renamed from: component1-mVEW8x0, reason: not valid java name and from getter */
            public final CameraError getLastCameraError() {
                return this.lastCameraError;
            }

            /* JADX INFO: renamed from: copy-TPqeGZw, reason: not valid java name */
            public final Error m891copyTPqeGZw(CameraError lastCameraError) {
                return new Error(lastCameraError, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.lastCameraError, ((Error) other).lastCameraError);
            }

            public int hashCode() {
                CameraError cameraError = this.lastCameraError;
                if (cameraError == null) {
                    return 0;
                }
                return CameraError.m355hashCodeimpl(cameraError.m358unboximpl());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }

            private Error(CameraError cameraError) {
                this.lastCameraError = cameraError;
            }

            /* JADX INFO: renamed from: getLastCameraError-mVEW8x0, reason: not valid java name */
            public final CameraError m892getLastCameraErrormVEW8x0() {
                return this.lastCameraError;
            }
        }
    }

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "", "Success", "Error", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Success;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface OpenVirtualCameraResult {

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Success;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;)V", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success implements OpenVirtualCameraResult {
            private final ActiveCamera activeCamera;

            public static /* synthetic */ Success copy$default(Success success, ActiveCamera activeCamera, int i, Object obj) {
                if ((i & 1) != 0) {
                    activeCamera = success.activeCamera;
                }
                return success.copy(activeCamera);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public final Success copy(ActiveCamera activeCamera) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                return new Success(activeCamera);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.activeCamera, ((Success) other).activeCamera);
            }

            public int hashCode() {
                return this.activeCamera.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ')';
            }

            public Success(ActiveCamera activeCamera) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                this.activeCamera = activeCamera;
            }

            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }
        }

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\tJ\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLastCameraError-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-mVEW8x0", "copy", "copy-TPqeGZw", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error implements OpenVirtualCameraResult {
            private final CameraError lastCameraError;

            public /* synthetic */ Error(CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
                this(cameraError);
            }

            /* JADX INFO: renamed from: copy-TPqeGZw$default, reason: not valid java name */
            public static /* synthetic */ Error m885copyTPqeGZw$default(Error error, CameraError cameraError, int i, Object obj) {
                if ((i & 1) != 0) {
                    cameraError = error.lastCameraError;
                }
                return error.m887copyTPqeGZw(cameraError);
            }

            /* JADX INFO: renamed from: component1-mVEW8x0, reason: not valid java name and from getter */
            public final CameraError getLastCameraError() {
                return this.lastCameraError;
            }

            /* JADX INFO: renamed from: copy-TPqeGZw, reason: not valid java name */
            public final Error m887copyTPqeGZw(CameraError lastCameraError) {
                return new Error(lastCameraError, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.lastCameraError, ((Error) other).lastCameraError);
            }

            public int hashCode() {
                CameraError cameraError = this.lastCameraError;
                if (cameraError == null) {
                    return 0;
                }
                return CameraError.m355hashCodeimpl(cameraError.m358unboximpl());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }

            private Error(CameraError cameraError) {
                this.lastCameraError = cameraError;
            }

            /* JADX INFO: renamed from: getLastCameraError-mVEW8x0, reason: not valid java name */
            public final CameraError m888getLastCameraErrormVEW8x0() {
                return this.lastCameraError;
            }
        }
    }
}
