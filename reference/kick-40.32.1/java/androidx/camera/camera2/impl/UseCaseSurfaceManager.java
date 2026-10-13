package androidx.camera.camera2.impl;

import android.view.Surface;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: UseCaseSurfaceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001e0\u00162\b\b\u0002\u0010\u001f\u001a\u00020 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fJ\u000e\u0010\"\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0019H\u0003J\b\u0010(\u001a\u00020\u0019H\u0003J,\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020\u0010*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "Landroidx/camera/camera2/pipe/CameraSurfaceManager$SurfaceListener;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "cameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "inactiveSurfaceCloser", "Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloser;", "sessionConfigAdapter", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "<init>", "(Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/pipe/CameraPipe;Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloser;Landroidx/camera/camera2/adapter/SessionConfigAdapter;)V", "lock", "", "setupDeferred", "Lkotlinx/coroutines/Deferred;", "", "activeSurfaceMap", "", "Landroid/view/Surface;", "Landroidx/camera/core/impl/DeferrableSurface;", "configuredSurfaceMap", "", "stopDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "setupAsync", "graph", "Landroidx/camera/camera2/pipe/CameraGraph;", "surfaceToStreamMap", "Landroidx/camera/camera2/pipe/StreamId;", "timeoutMillis", "", "stopAsync", "awaitSetupCompletion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSurfaceActive", "surface", "onSurfaceInactive", "setSurfaceListener", "tryClearSurfaceListener", "getSurfaces", "", "deferrableSurfaces", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "areValid", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public class UseCaseSurfaceManager implements CameraSurfaceManager.SurfaceListener {
    private final Map<Surface, DeferrableSurface> activeSurfaceMap;
    private final CameraPipe cameraPipe;
    private Map<Surface, ? extends DeferrableSurface> configuredSurfaceMap;
    private final InactiveSurfaceCloser inactiveSurfaceCloser;
    private final Object lock;
    private final SessionConfigAdapter sessionConfigAdapter;
    private Deferred<Boolean> setupDeferred;
    private CompletableDeferred<Unit> stopDeferred;
    private final UseCaseThreads threads;

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseSurfaceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager", f = "UseCaseSurfaceManager.kt", i = {}, l = {193}, m = "awaitSetupCompletion$suspendImpl", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseCaseSurfaceManager.awaitSetupCompletion$suspendImpl(UseCaseSurfaceManager.this, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseSurfaceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager", f = "UseCaseSurfaceManager.kt", i = {}, l = {254}, m = "getSurfaces", n = {}, s = {}, v = 1)
    static final class C01951 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01951(Continuation<? super C01951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseCaseSurfaceManager.this.getSurfaces(null, 0L, this);
        }
    }

    public Object awaitSetupCompletion(Continuation<? super Boolean> continuation) {
        return awaitSetupCompletion$suspendImpl(this, continuation);
    }

    @Inject
    public UseCaseSurfaceManager(UseCaseThreads threads, CameraPipe cameraPipe, InactiveSurfaceCloser inactiveSurfaceCloser, SessionConfigAdapter sessionConfigAdapter) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraPipe, "cameraPipe");
        Intrinsics.checkNotNullParameter(inactiveSurfaceCloser, "inactiveSurfaceCloser");
        Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
        this.threads = threads;
        this.cameraPipe = cameraPipe;
        this.inactiveSurfaceCloser = inactiveSurfaceCloser;
        this.sessionConfigAdapter = sessionConfigAdapter;
        this.lock = new Object();
        this.activeSurfaceMap = new LinkedHashMap();
    }

    public static /* synthetic */ Deferred setupAsync$default(UseCaseSurfaceManager useCaseSurfaceManager, CameraGraph cameraGraph, SessionConfigAdapter sessionConfigAdapter, Map map, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupAsync");
        }
        if ((i & 8) != 0) {
            j = 5000;
        }
        return useCaseSurfaceManager.setupAsync(cameraGraph, sessionConfigAdapter, map, j);
    }

    public final Deferred<Boolean> setupAsync(CameraGraph graph, SessionConfigAdapter sessionConfigAdapter, Map<DeferrableSurface, StreamId> surfaceToStreamMap, long timeoutMillis) {
        CompletableDeferred CompletableDeferred;
        Intrinsics.checkNotNullParameter(graph, "graph");
        Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
        Intrinsics.checkNotNullParameter(surfaceToStreamMap, "surfaceToStreamMap");
        synchronized (this.lock) {
            if (this.setupDeferred != null) {
                throw new IllegalStateException("Surfaces should only be set up once!".toString());
            }
            if (this.stopDeferred != null) {
                throw new IllegalStateException("Surfaces being setup after stopped!".toString());
            }
            if (this.configuredSurfaceMap != null) {
                throw new IllegalStateException("Check failed.");
            }
            final List<DeferrableSurface> deferrableSurfaces = sessionConfigAdapter.getDeferrableSurfaces();
            try {
                DeferrableSurfaces.incrementAll(deferrableSurfaces);
                CompletableDeferred = BuildersKt__Builders_commonKt.async$default(this.threads.getScope(), null, null, new UseCaseSurfaceManager$setupAsync$1$deferred$1(sessionConfigAdapter, this, deferrableSurfaces, timeoutMillis, surfaceToStreamMap, graph, null), 3, null);
                CompletableDeferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.UseCaseSurfaceManager$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UseCaseSurfaceManager.setupAsync$lambda$0$3$0(deferrableSurfaces, (Throwable) obj);
                    }
                });
                this.setupDeferred = CompletableDeferred;
            } catch (DeferrableSurface.SurfaceClosedException e) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to increment DeferrableSurfaces: Surfaces closed");
                }
                BuildersKt__Builders_commonKt.launch$default(this.threads.getScope(), null, null, new UseCaseSurfaceManager$setupAsync$1$4(sessionConfigAdapter, e, null), 3, null);
                CompletableDeferred = CompletableDeferredKt.CompletableDeferred(false);
            }
        }
        return CompletableDeferred;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAsync$lambda$0$3$0(List list, Throwable th) {
        DeferrableSurfaces.decrementAll(list);
        return Unit.INSTANCE;
    }

    public final Deferred<Unit> stopAsync() {
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default;
        synchronized (this.lock) {
            completableDeferredCompletableDeferred$default = this.stopDeferred;
            if (completableDeferredCompletableDeferred$default != null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "UseCaseSurfaceManager is already stopping!");
                }
            } else {
                Deferred<Boolean> deferred = this.setupDeferred;
                if (deferred != null) {
                    Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                }
                this.inactiveSurfaceCloser.closeAll();
                this.configuredSurfaceMap = null;
                completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                this.stopDeferred = completableDeferredCompletableDeferred$default;
                tryClearSurfaceListener();
            }
        }
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object awaitSetupCompletion$suspendImpl(UseCaseSurfaceManager useCaseSurfaceManager, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = useCaseSurfaceManager.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = useCaseSurfaceManager.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            synchronized (useCaseSurfaceManager.lock) {
                Deferred<Boolean> deferred = useCaseSurfaceManager.setupDeferred;
                if (deferred == null || useCaseSurfaceManager.stopDeferred != null) {
                    return Boxing.boxBoolean(false);
                }
                anonymousClass1.label = 1;
                Object objAwait = deferred.await(anonymousClass1);
                return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
            }
        } catch (CancellationException unused) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Surface setup was cancelled");
            }
            return Boxing.boxBoolean(false);
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraSurfaceManager.SurfaceListener
    public void onSurfaceActive(Surface surface) {
        DeferrableSurface deferrableSurface;
        Intrinsics.checkNotNullParameter(surface, "surface");
        synchronized (this.lock) {
            Map<Surface, ? extends DeferrableSurface> map = this.configuredSurfaceMap;
            if (map != null && (deferrableSurface = map.get(surface)) != null) {
                if (!this.activeSurfaceMap.containsKey(surface)) {
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "SurfaceActive " + deferrableSurface + " in " + this);
                    }
                    this.activeSurfaceMap.put(surface, deferrableSurface);
                    try {
                        deferrableSurface.incrementUseCount();
                    } catch (DeferrableSurface.SurfaceClosedException e) {
                        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                        DeferrableSurface.SurfaceClosedException surfaceClosedException = e;
                        if (Logger.isWarnEnabled(Log.TAG)) {
                            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Error when " + surface + " going to increase the use count.", surfaceClosedException);
                        }
                        SessionConfigAdapter sessionConfigAdapter = this.sessionConfigAdapter;
                        DeferrableSurface deferrableSurface2 = e.getDeferrableSurface();
                        Intrinsics.checkNotNullExpressionValue(deferrableSurface2, "getDeferrableSurface(...)");
                        sessionConfigAdapter.reportSurfaceInvalid(deferrableSurface2);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraSurfaceManager.SurfaceListener
    public void onSurfaceInactive(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        synchronized (this.lock) {
            DeferrableSurface deferrableSurfaceRemove = this.activeSurfaceMap.remove(surface);
            if (deferrableSurfaceRemove != null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "SurfaceInactive " + deferrableSurfaceRemove + " in " + this);
                }
                this.inactiveSurfaceCloser.onSurfaceInactive(deferrableSurfaceRemove);
                try {
                    deferrableSurfaceRemove.decrementUseCount();
                } catch (IllegalStateException e) {
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    IllegalStateException illegalStateException = e;
                    if (Logger.isWarnEnabled(Log.TAG)) {
                        android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Error when " + surface + " going to decrease the use count.", illegalStateException);
                    }
                }
                tryClearSurfaceListener();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSurfaceListener() {
        this.cameraPipe.cameraSurfaceManager().addListener(this);
    }

    private final void tryClearSurfaceListener() {
        synchronized (this.lock) {
            if (this.activeSurfaceMap.isEmpty() && this.configuredSurfaceMap == null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, this + " remove surface listener");
                }
                this.cameraPipe.cameraSurfaceManager().removeListener(this);
                CompletableDeferred<Unit> completableDeferred = this.stopDeferred;
                if (completableDeferred != null) {
                    completableDeferred.complete(Unit.INSTANCE);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getSurfaces(List<? extends DeferrableSurface> list, long j, Continuation<? super List<? extends Surface>> continuation) {
        C01951 c01951;
        if (continuation instanceof C01951) {
            c01951 = (C01951) continuation;
            if ((c01951.label & Integer.MIN_VALUE) != 0) {
                c01951.label -= Integer.MIN_VALUE;
            } else {
                c01951 = new C01951(continuation);
            }
        } else {
            c01951 = new C01951(continuation);
        }
        Object objWithTimeoutOrNull = c01951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01951.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(list, null);
            c01951.label = 1;
            objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, anonymousClass2, c01951);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
        }
        List list2 = (List) objWithTimeoutOrNull;
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$2, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseSurfaceManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroid/view/Surface;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$2", f = "UseCaseSurfaceManager.kt", i = {}, l = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_REMOVED}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Surface>>, Object> {
        final /* synthetic */ List<DeferrableSurface> $deferrableSurfaces;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(List<? extends DeferrableSurface> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$deferrableSurfaces = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$deferrableSurfaces, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Surface>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            List<DeferrableSurface> list = this.$deferrableSurfaces;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Futures.nonCancellationPropagating(((DeferrableSurface) it.next()).getSurface()));
            }
            ListenableFuture listenableFutureSuccessfulAsList = Futures.successfulAsList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listenableFutureSuccessfulAsList, "successfulAsList(...)");
            this.label = 1;
            Object objAwait = ListenableFutureKt.await(listenableFutureSuccessfulAsList, this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean areValid(List<? extends Surface> list) {
        return (list.isEmpty() || list.contains(null)) ? false : true;
    }
}
