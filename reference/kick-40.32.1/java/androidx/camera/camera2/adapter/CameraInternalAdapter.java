package androidx.camera.camera2.adapter;

import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.UseCaseManager;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionProcessor;
import androidx.compose.foundation.style.ResolvedStyleKt;
import androidx.media3.muxer.WebmConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: CameraInternalAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001eH\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\b\u00104\u001a\u00020\tH\u0016J\u0016\u00105\u001a\u00020\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0016\u00109\u001a\u00020\u001c2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u000208H\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010<\u001a\u000208H\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010<\u001a\u000208H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010<\u001a\u000208H\u0016J\b\u0010@\u001a\u00020\u0014H\u0016J\u0012\u0010A\u001a\u00020\u001c2\b\u0010B\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010C\u001a\u00020\u001cH\u0016J\b\u0010\u0019\u001a\u00020\u001eH\u0016J\b\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/camera/camera2/adapter/CameraInternalAdapter;", "Landroidx/camera/core/impl/CameraInternal;", "config", "Landroidx/camera/camera2/config/CameraConfig;", "useCaseManager", "Landroidx/camera/camera2/impl/UseCaseManager;", "cameraInfo", "Landroidx/camera/core/impl/CameraInfoInternal;", "cameraController", "Landroidx/camera/core/impl/CameraControlInternal;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "cameraStateAdapter", "Landroidx/camera/camera2/adapter/CameraStateAdapter;", "<init>", "(Landroidx/camera/camera2/config/CameraConfig;Landroidx/camera/camera2/impl/UseCaseManager;Landroidx/camera/core/impl/CameraInfoInternal;Landroidx/camera/core/impl/CameraControlInternal;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/adapter/CameraStateAdapter;)V", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "Ljava/lang/String;", "coreCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "debugId", "", "sessionProcessor", "Landroidx/camera/core/impl/SessionProcessor;", "isRemoved", "Lkotlinx/atomicfu/AtomicBoolean;", "setCameraGraphCreationMode", "", "createImmediately", "", "setCameraGraphCreationMode$camera_camera2", "getDeferredCameraGraphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "getDeferredCameraGraphConfig$camera_camera2", "resumeDeferredCameraGraphCreation", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "resumeDeferredCameraGraphCreation$camera_camera2", "open", "close", "setPrimary", "isPrimary", "setActiveResumingMode", "enabled", "release", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "getCameraInfoInternal", "getCameraState", "Landroidx/camera/core/impl/Observable;", "Landroidx/camera/core/impl/CameraInternal$State;", "getCameraControlInternal", "attachUseCases", "useCasesToAdd", "", "Landroidx/camera/core/UseCase;", "detachUseCases", "useCasesToRemove", "onUseCaseActive", "useCase", "onUseCaseUpdated", "onUseCaseReset", "onUseCaseInactive", "getExtendedConfig", "setExtendedConfig", "cameraConfig", "onRemoved", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraInternalAdapter implements CameraInternal {
    private final CameraControlInternal cameraController;
    private final String cameraId;
    private final CameraInfoInternal cameraInfo;
    private final CameraStateAdapter cameraStateAdapter;
    private CameraConfig coreCameraConfig;
    private final int debugId;
    private final AtomicBoolean isRemoved;
    private SessionProcessor sessionProcessor;
    private final UseCaseThreads threads;
    private final UseCaseManager useCaseManager;

    @Inject
    public CameraInternalAdapter(androidx.camera.camera2.config.CameraConfig config, UseCaseManager useCaseManager, CameraInfoInternal cameraInfo, CameraControlInternal cameraController, UseCaseThreads threads, CameraStateAdapter cameraStateAdapter) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(useCaseManager, "useCaseManager");
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(cameraController, "cameraController");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraStateAdapter, "cameraStateAdapter");
        this.useCaseManager = useCaseManager;
        this.cameraInfo = cameraInfo;
        this.cameraController = cameraController;
        this.threads = threads;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraId = config.getCameraId();
        CameraConfig cameraConfigDefaultConfig = CameraConfigs.defaultConfig();
        Intrinsics.checkNotNullExpressionValue(cameraConfigDefaultConfig, "defaultConfig(...)");
        this.coreCameraConfig = cameraConfigDefaultConfig;
        this.debugId = CameraInternalAdapterKt.getCameraAdapterIds().incrementAndGet();
        this.isRemoved = AtomicFU.atomic(false);
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Created " + this + " for " + ((Object) CameraId.m432toStringimpl(this.cameraId)));
        }
    }

    public final void setCameraGraphCreationMode$camera_camera2(boolean createImmediately) {
        this.useCaseManager.setCameraGraphCreationMode$camera_camera2(createImmediately);
    }

    public final CameraGraph.Config getDeferredCameraGraphConfig$camera_camera2() {
        return this.useCaseManager.getDeferredCameraGraphConfig$camera_camera2();
    }

    public final void resumeDeferredCameraGraphCreation$camera_camera2(CameraGraph cameraGraph) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        this.useCaseManager.resumeDeferredComponentCreation$camera_camera2(cameraGraph);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, this + "#open");
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, this + "#close");
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setPrimary(boolean isPrimary) {
        this.useCaseManager.setPrimary(isPrimary);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setActiveResumingMode(boolean enabled) {
        this.useCaseManager.setActiveResumeMode(enabled);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CameraInternalAdapter$release$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraInternalAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.adapter.CameraInternalAdapter$release$1", f = "CameraInternalAdapter.kt", i = {}, l = {ResolvedStyleKt.InheritedFlags}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraInternalAdapter.this.new AnonymousClass1(continuation);
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
                this.label = 1;
                if (CameraInternalAdapter.this.useCaseManager.close(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CoroutineScopeKt.cancel$default(CameraInternalAdapter.this.threads.getScope(), null, 1, null);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public ListenableFuture<Void> release() {
        return CoroutineAdaptersKt.asListenableFuture$default(BuildersKt__Builders_commonKt.launch$default(this.threads.getScope(), null, null, new AnonymousClass1(null), 3, null), (Object) null, 1, (Object) null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    /* JADX INFO: renamed from: getCameraInfoInternal, reason: from getter */
    public CameraInfoInternal getCameraInfo() {
        return this.cameraInfo;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public Observable<CameraInternal.State> getCameraState() {
        return this.cameraStateAdapter.getCameraInternalState$camera_camera2();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    /* JADX INFO: renamed from: getCameraControlInternal, reason: from getter */
    public CameraControlInternal getCameraController() {
        return this.cameraController;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(Collection<UseCase> useCasesToAdd) {
        Intrinsics.checkNotNullParameter(useCasesToAdd, "useCasesToAdd");
        this.useCaseManager.attach(CollectionsKt.toList(useCasesToAdd));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(Collection<UseCase> useCasesToRemove) {
        Intrinsics.checkNotNullParameter(useCasesToRemove, "useCasesToRemove");
        this.useCaseManager.detach(CollectionsKt.toList(useCasesToRemove));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        this.useCaseManager.activate(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        this.useCaseManager.update(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        this.useCaseManager.reset(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        this.useCaseManager.deactivate(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    /* JADX INFO: renamed from: getExtendedConfig, reason: from getter */
    public CameraConfig getCoreCameraConfig() {
        return this.coreCameraConfig;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setExtendedConfig(CameraConfig cameraConfig) {
        CameraConfig cameraConfigDefaultConfig;
        if (cameraConfig == null) {
            cameraConfigDefaultConfig = CameraConfigs.defaultConfig();
            Intrinsics.checkNotNullExpressionValue(cameraConfigDefaultConfig, "defaultConfig(...)");
        } else {
            cameraConfigDefaultConfig = cameraConfig;
        }
        this.coreCameraConfig = cameraConfigDefaultConfig;
        SessionProcessor sessionProcessor = cameraConfig != null ? cameraConfig.getSessionProcessor(null) : null;
        this.sessionProcessor = sessionProcessor;
        this.useCaseManager.setSessionProcessor$camera_camera2(sessionProcessor);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void onRemoved() {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, this + " received removed signal. Cleaning up.");
        }
        if (this.isRemoved.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.threads.getScope(), null, null, new AnonymousClass2(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CameraInternalAdapter$onRemoved$2, reason: invalid class name */
    /* JADX INFO: compiled from: CameraInternalAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.adapter.CameraInternalAdapter$onRemoved$2", f = "CameraInternalAdapter.kt", i = {}, l = {WebmConstants.MkvEbmlElement.BLOCK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraInternalAdapter.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraInternalAdapter.this.cameraStateAdapter.onRemoved();
                this.label = 1;
                if (CameraInternalAdapter.this.useCaseManager.close(this) == coroutine_suspended) {
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

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean isRemoved() {
        return this.isRemoved.getValue();
    }

    public String toString() {
        return "CameraInternalAdapter<" + ((Object) CameraId.m432toStringimpl(this.cameraId)) + '(' + this.debugId + ")>";
    }
}
