package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Log;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2CameraAvailabilityMonitor$startMonitoring$2", "Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor$Session;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlinx/coroutines/CompletableDeferred;", "", "awaitAvailableCamera", "", "timeoutMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CameraAvailabilityMonitor$startMonitoring$2 implements CameraAvailabilityMonitor.Session {
    private final CopyOnWriteArrayList<CompletableDeferred<Unit>> listeners;
    private final CoroutineScope scope;

    Camera2CameraAvailabilityMonitor$startMonitoring$2(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor, String str) {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(camera2CameraAvailabilityMonitor.threads.getBackgroundDispatcher().plus(SupervisorKt.SupervisorJob(camera2CameraAvailabilityMonitor.cameraPipeJob)));
        this.scope = CoroutineScope;
        this.listeners = new CopyOnWriteArrayList<>();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(camera2CameraAvailabilityMonitor, str, this, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$1", f = "RetryingCameraStateOpener.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cameraId;
        int label;
        final /* synthetic */ Camera2CameraAvailabilityMonitor this$0;
        final /* synthetic */ Camera2CameraAvailabilityMonitor$startMonitoring$2 this$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor, String str, Camera2CameraAvailabilityMonitor$startMonitoring$2 camera2CameraAvailabilityMonitor$startMonitoring$2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = camera2CameraAvailabilityMonitor;
            this.$cameraId = str;
            this.this$1 = camera2CameraAvailabilityMonitor$startMonitoring$2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$cameraId, this.this$1, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = this.this$0.availableCameraFlow;
                final String str = this.$cameraId;
                final Camera2CameraAvailabilityMonitor$startMonitoring$2 camera2CameraAvailabilityMonitor$startMonitoring$2 = this.this$1;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor.startMonitoring.2.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return m824emit0r8Bogc(((CameraId) obj2).m433unboximpl(), continuation);
                    }

                    /* JADX INFO: renamed from: emit-0r8Bogc, reason: not valid java name */
                    public final Object m824emit0r8Bogc(String str2, Continuation<? super Unit> continuation) {
                        if (CameraId.m429equalsimpl0(str2, str)) {
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                android.util.Log.d(Log.TAG, ((Object) CameraId.m432toStringimpl(str2)) + " has become available! Notifying listeners...");
                            }
                            Iterator it = camera2CameraAvailabilityMonitor$startMonitoring$2.listeners.iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                ((CompletableDeferred) it.next()).complete(Unit.INSTANCE);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor.Session
    public Object awaitAvailableCamera(long j, Continuation<? super Boolean> continuation) {
        Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1;
        CompletableDeferred<Unit> completableDeferred;
        if (continuation instanceof Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1) {
            camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 = (Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1) continuation;
            if ((camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.label & Integer.MIN_VALUE) != 0) {
                camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.label -= Integer.MIN_VALUE;
            } else {
                camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 = new Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1(this, continuation);
            }
        } else {
            camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 = new Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1(this, continuation);
        }
        Object objWithTimeoutOrNull = camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.listeners.add(completableDeferredCompletableDeferred$default);
            Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1 camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1 = new Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1(completableDeferredCompletableDeferred$default, null);
            camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.L$0 = completableDeferredCompletableDeferred$default;
            camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.label = 1;
            objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1, camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            completableDeferred = completableDeferredCompletableDeferred$default;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableDeferred = (CompletableDeferred) camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1.L$0;
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
        }
        boolean z = objWithTimeoutOrNull != null;
        this.listeners.remove(completableDeferred);
        return Boxing.boxBoolean(z);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }
}
