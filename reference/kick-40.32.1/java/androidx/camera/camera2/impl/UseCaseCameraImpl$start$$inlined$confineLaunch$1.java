package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UseCaseThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/impl/UseCaseThreads$confineLaunch$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseCameraImpl$start$$inlined$confineLaunch$1", f = "UseCaseCamera.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UseCaseCameraImpl$start$$inlined$confineLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UseCaseCameraImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraImpl$start$$inlined$confineLaunch$1(Continuation continuation, UseCaseCameraImpl useCaseCameraImpl) {
        super(2, continuation);
        this.this$0 = useCaseCameraImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UseCaseCameraImpl$start$$inlined$confineLaunch$1(continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UseCaseCameraImpl$start$$inlined$confineLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.closed.getValue()) {
                CameraGraph graph = this.this$0.useCaseGraphContext.getGraph();
                this.this$0.useCaseGraphContext.configureCameraStateListener();
                graph.start();
                Map<DeferrableSurface, StreamId> surfaceToStreamMap = this.this$0.useCaseGraphContext.getSurfaceToStreamMap();
                StreamId streamIdM137findStillCaptureStreamId4TVKcYk = this.this$0.m137findStillCaptureStreamId4TVKcYk();
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Setting up Surfaces with UseCaseSurfaceManager");
                }
                if (this.this$0.getSessionConfigAdapter().isSessionConfigValid()) {
                    UseCaseSurfaceManager useCaseSurfaceManager = this.this$0.getUseCaseSurfaceManager();
                    Intrinsics.checkNotNullExpressionValue(useCaseSurfaceManager, "access$getUseCaseSurfaceManager(...)");
                    SessionConfigAdapter sessionConfigAdapter = this.this$0.getSessionConfigAdapter();
                    Intrinsics.checkNotNullExpressionValue(sessionConfigAdapter, "access$getSessionConfigAdapter(...)");
                    UseCaseSurfaceManager.setupAsync$default(useCaseSurfaceManager, graph, sessionConfigAdapter, surfaceToStreamMap, 0L, 8, null).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.camera.camera2.impl.UseCaseCameraImpl$start$1$3
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            if (th == null || (th instanceof CancellationException)) {
                                return;
                            }
                            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                            if (Logger.isErrorEnabled(Log.TAG)) {
                                android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Surface setup error!", th);
                            }
                        }
                    });
                } else {
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isErrorEnabled(Log.TAG)) {
                        android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Unable to create capture session due to conflicting configurations");
                    }
                }
                this.this$0.m138setCaptureSessionRequestProcessor9O56998(streamIdM137findStillCaptureStreamId4TVKcYk, graph);
            } else {
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCamera is closed before starting the CameraGraph, skipping setup.");
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
