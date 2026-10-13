package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Pair;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import com.facebook.react.uimanager.ViewProps;
import dagger.Binds;
import dagger.Module;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UseCaseCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001CBU\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010'\u001a\u00020(H\u0016J\u000f\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\b+J\u001f\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010.\u001a\u00020/H\u0002¢\u0006\u0002\b0J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u000205H\u0016J\u001e\u00106\u001a\u0002022\u0006\u00107\u001a\u0002052\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0016J\b\u0010;\u001a\u00020<H\u0016J&\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010BR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!R#\u0010#\u001a\n \u001a*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b$\u0010%¨\u0006D"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraImpl;", "Landroidx/camera/camera2/impl/UseCaseCamera;", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "sessionProcessor", "Landroidx/camera/core/impl/SessionProcessor;", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "useCaseSurfaceManagerProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "sessionConfigAdapterProvider", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "capturePipelineProvider", "Landroidx/camera/camera2/impl/CapturePipeline;", "<init>", "(Landroidx/camera/camera2/config/UseCaseGraphContext;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/core/impl/SessionProcessor;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "debugId", "", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "useCaseSurfaceManager", "kotlin.jvm.PlatformType", "getUseCaseSurfaceManager", "()Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManager$delegate", "Lkotlin/Lazy;", "sessionConfigAdapter", "getSessionConfigAdapter", "()Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter$delegate", "capturePipeline", "getCapturePipeline", "()Landroidx/camera/camera2/impl/CapturePipeline;", "capturePipeline$delegate", ViewProps.START, "", "findStillCaptureStreamId", "Landroidx/camera/camera2/pipe/StreamId;", "findStillCaptureStreamId-4TVKcYk", "setCaptureSessionRequestProcessor", "stillCaptureStreamId", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "setCaptureSessionRequestProcessor-9O56998", "close", "Lkotlinx/coroutines/Job;", "setActiveResumeMode", "enabled", "", "updateRepeatingRequestAsync", "isPrimary", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "toString", "", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "captureMode", "flashMode", "flashType", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class UseCaseCameraImpl implements UseCaseCamera {

    /* JADX INFO: renamed from: capturePipeline$delegate, reason: from kotlin metadata */
    private final Lazy capturePipeline;
    private final Provider<CapturePipeline> capturePipelineProvider;
    private final AtomicBoolean closed;
    private final int debugId;
    private final UseCaseCameraRequestControl requestControl;

    /* JADX INFO: renamed from: sessionConfigAdapter$delegate, reason: from kotlin metadata */
    private final Lazy sessionConfigAdapter;
    private final Provider<SessionConfigAdapter> sessionConfigAdapterProvider;
    private final SessionProcessor sessionProcessor;
    private final UseCaseThreads threads;
    private final UseCaseGraphContext useCaseGraphContext;

    /* JADX INFO: renamed from: useCaseSurfaceManager$delegate, reason: from kotlin metadata */
    private final Lazy useCaseSurfaceManager;
    private final Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    /* JADX INFO: compiled from: UseCaseCamera.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraImpl$Bindings;", "", "<init>", "()V", "provideUseCaseCamera", "Landroidx/camera/camera2/impl/UseCaseCamera;", "useCaseCamera", "Landroidx/camera/camera2/impl/UseCaseCameraImpl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @UseCaseCameraScope
        public abstract UseCaseCamera provideUseCaseCamera(UseCaseCameraImpl useCaseCamera);
    }

    @Inject
    public UseCaseCameraImpl(UseCaseGraphContext useCaseGraphContext, UseCaseThreads threads, SessionProcessor sessionProcessor, UseCaseCameraRequestControl requestControl, Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider, Provider<SessionConfigAdapter> sessionConfigAdapterProvider, Provider<CapturePipeline> capturePipelineProvider) {
        Intrinsics.checkNotNullParameter(useCaseGraphContext, "useCaseGraphContext");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        Intrinsics.checkNotNullParameter(useCaseSurfaceManagerProvider, "useCaseSurfaceManagerProvider");
        Intrinsics.checkNotNullParameter(sessionConfigAdapterProvider, "sessionConfigAdapterProvider");
        Intrinsics.checkNotNullParameter(capturePipelineProvider, "capturePipelineProvider");
        this.useCaseGraphContext = useCaseGraphContext;
        this.threads = threads;
        this.sessionProcessor = sessionProcessor;
        this.requestControl = requestControl;
        this.useCaseSurfaceManagerProvider = useCaseSurfaceManagerProvider;
        this.sessionConfigAdapterProvider = sessionConfigAdapterProvider;
        this.capturePipelineProvider = capturePipelineProvider;
        this.debugId = UseCaseCameraKt.getUseCaseCameraIds().incrementAndGet();
        this.closed = AtomicFU.atomic(false);
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Configured " + this);
        }
        this.useCaseSurfaceManager = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.useCaseSurfaceManagerProvider.get();
            }
        });
        this.sessionConfigAdapter = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.sessionConfigAdapterProvider.get();
            }
        });
        this.capturePipeline = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.capturePipelineProvider.get();
            }
        });
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public UseCaseCameraRequestControl getRequestControl() {
        return this.requestControl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UseCaseSurfaceManager getUseCaseSurfaceManager() {
        return (UseCaseSurfaceManager) this.useCaseSurfaceManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionConfigAdapter getSessionConfigAdapter() {
        return (SessionConfigAdapter) this.sessionConfigAdapter.getValue();
    }

    private final CapturePipeline getCapturePipeline() {
        return (CapturePipeline) this.capturePipeline.getValue();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public void start() {
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$start$$inlined$confineLaunch$1(null, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: findStillCaptureStreamId-4TVKcYk, reason: not valid java name */
    public final StreamId m137findStillCaptureStreamId4TVKcYk() {
        Object next;
        SessionConfig validSessionConfigOrNull = getSessionConfigAdapter().getValidSessionConfigOrNull();
        if (validSessionConfigOrNull == null) {
            return null;
        }
        List<DeferrableSurface> surfaces = validSessionConfigOrNull.getRepeatingCaptureConfig().getSurfaces();
        Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
        List<DeferrableSurface> surfaces2 = validSessionConfigOrNull.getSurfaces();
        Intrinsics.checkNotNullExpressionValue(surfaces2, "getSurfaces(...)");
        Iterator<T> it = surfaces2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (surfaces.contains((DeferrableSurface) next));
        DeferrableSurface deferrableSurface = (DeferrableSurface) next;
        if (deferrableSurface == null) {
            return null;
        }
        return (StreamId) CollectionsKt.firstOrNull(this.useCaseGraphContext.getStreamIdsFromSurfaces(CollectionsKt.listOf(deferrableSurface)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCaptureSessionRequestProcessor-9O56998, reason: not valid java name */
    public final void m138setCaptureSessionRequestProcessor9O56998(final StreamId stillCaptureStreamId, final CameraGraph cameraGraph) {
        SessionProcessor sessionProcessor = this.sessionProcessor;
        if (sessionProcessor != null) {
            sessionProcessor.setCaptureSessionRequestProcessor(new SessionProcessor.CaptureSessionRequestProcessor() { // from class: androidx.camera.camera2.impl.UseCaseCameraImpl$setCaptureSessionRequestProcessor$1
                @Override // androidx.camera.core.impl.SessionProcessor.CaptureSessionRequestProcessor
                public Pair<Long, Long> getRealtimeStillCaptureLatency() {
                    StreamGraph.OutputLatency outputLatencyM783getOutputLatencyIL232MI$default;
                    if (stillCaptureStreamId == null || (outputLatencyM783getOutputLatencyIL232MI$default = StreamGraph.m783getOutputLatencyIL232MI$default(cameraGraph.getStreams(), stillCaptureStreamId.m797unboximpl(), null, 2, null)) == null) {
                        return null;
                    }
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long estimatedCaptureLatencyNs = outputLatencyM783getOutputLatencyIL232MI$default.getEstimatedCaptureLatencyNs() / 1000000;
                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                    return Pair.create(Long.valueOf(estimatedCaptureLatencyNs), Long.valueOf(outputLatencyM783getOutputLatencyIL232MI$default.getEstimatedProcessingLatencyNs() / 1000000));
                }

                @Override // androidx.camera.core.impl.SessionProcessor.CaptureSessionRequestProcessor
                public void setExtensionStrength(int strength) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        UseCaseCameraRequestControl.setParametersAsync$default(this.getRequestControl(), MapsKt.mutableMapOf(TuplesKt.to(CaptureRequest.EXTENSION_STRENGTH, Integer.valueOf(strength))), null, null, 6, null);
                    }
                }
            });
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public Job close() {
        if (this.closed.compareAndSet(false, true)) {
            getRequestControl().close();
            return BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$close$$inlined$confineLaunch$1(null, this), 3, null);
        }
        return CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public void setActiveResumeMode(boolean enabled) {
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$setActiveResumeMode$$inlined$confineLaunch$1(null, this, enabled), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public Job updateRepeatingRequestAsync(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        Intrinsics.checkNotNullParameter(runningUseCases, "runningUseCases");
        return getRequestControl().updateRepeatingRequestAsync(isPrimary, runningUseCases);
    }

    public String toString() {
        return "UseCaseCamera-" + this.debugId;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCamera
    public Object getCameraCapturePipeline(int i, int i2, int i3, Continuation<? super CameraCapturePipeline> continuation) {
        return getCapturePipeline().getCameraCapturePipeline(i, i2, i3, continuation);
    }
}
