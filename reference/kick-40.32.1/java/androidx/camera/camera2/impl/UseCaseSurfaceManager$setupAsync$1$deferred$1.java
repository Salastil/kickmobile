package androidx.camera.camera2.impl;

import android.view.Surface;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: UseCaseSurfaceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager$setupAsync$1$deferred$1", f = "UseCaseSurfaceManager.kt", i = {0}, l = {97}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"}, v = 1)
final class UseCaseSurfaceManager$setupAsync$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<DeferrableSurface> $deferrableSurfaces;
    final /* synthetic */ CameraGraph $graph;
    final /* synthetic */ SessionConfigAdapter $sessionConfigAdapter;
    final /* synthetic */ Map<DeferrableSurface, StreamId> $surfaceToStreamMap;
    final /* synthetic */ long $timeoutMillis;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UseCaseSurfaceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UseCaseSurfaceManager$setupAsync$1$deferred$1(SessionConfigAdapter sessionConfigAdapter, UseCaseSurfaceManager useCaseSurfaceManager, List<? extends DeferrableSurface> list, long j, Map<DeferrableSurface, StreamId> map, CameraGraph cameraGraph, Continuation<? super UseCaseSurfaceManager$setupAsync$1$deferred$1> continuation) {
        super(2, continuation);
        this.$sessionConfigAdapter = sessionConfigAdapter;
        this.this$0 = useCaseSurfaceManager;
        this.$deferrableSurfaces = list;
        this.$timeoutMillis = j;
        this.$surfaceToStreamMap = map;
        this.$graph = cameraGraph;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UseCaseSurfaceManager$setupAsync$1$deferred$1 useCaseSurfaceManager$setupAsync$1$deferred$1 = new UseCaseSurfaceManager$setupAsync$1$deferred$1(this.$sessionConfigAdapter, this.this$0, this.$deferrableSurfaces, this.$timeoutMillis, this.$surfaceToStreamMap, this.$graph, continuation);
        useCaseSurfaceManager$setupAsync$1$deferred$1.L$0 = obj;
        return useCaseSurfaceManager$setupAsync$1$deferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((UseCaseSurfaceManager$setupAsync$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                if (this.$sessionConfigAdapter.isSessionConfigValid()) {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    Object surfaces = this.this$0.getSurfaces(this.$deferrableSurfaces, this.$timeoutMillis, this);
                    if (surfaces == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                    obj = surfaces;
                } else {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            if (CoroutineScopeKt.isActive(coroutineScope) && !list.isEmpty()) {
                if (this.this$0.areValid(list)) {
                    Object obj2 = this.this$0.lock;
                    UseCaseSurfaceManager useCaseSurfaceManager = this.this$0;
                    List<DeferrableSurface> list2 = this.$deferrableSurfaces;
                    synchronized (obj2) {
                        List<DeferrableSurface> list3 = list2;
                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
                        for (Object obj3 : list3) {
                            Object obj4 = list.get(list2.indexOf((DeferrableSurface) obj3));
                            if (obj4 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            linkedHashMap.put((Surface) obj4, obj3);
                        }
                        useCaseSurfaceManager.configuredSurfaceMap = linkedHashMap;
                        useCaseSurfaceManager.setSurfaceListener();
                        Unit unit = Unit.INSTANCE;
                    }
                    Map<DeferrableSurface, StreamId> map = this.$surfaceToStreamMap;
                    List<DeferrableSurface> list4 = this.$deferrableSurfaces;
                    CameraGraph cameraGraph = this.$graph;
                    UseCaseSurfaceManager useCaseSurfaceManager2 = this.this$0;
                    for (Map.Entry<DeferrableSurface, StreamId> entry : map.entrySet()) {
                        int iM797unboximpl = entry.getValue().m797unboximpl();
                        Surface surface = (Surface) list.get(list4.indexOf(entry.getKey()));
                        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Configured " + surface + " for " + ((Object) StreamId.m796toStringimpl(iM797unboximpl)));
                        }
                        cameraGraph.mo424setSurfaceNYG5g8E(iM797unboximpl, surface);
                        useCaseSurfaceManager2.inactiveSurfaceCloser.mo76configurehB7JTeY(iM797unboximpl, entry.getKey(), cameraGraph);
                    }
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isInfoEnabled(Log.TAG)) {
                        android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "Surface setup complete");
                    }
                    return Boxing.boxBoolean(true);
                }
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Surface setup failed: Some Surfaces are invalid");
                }
                this.$sessionConfigAdapter.reportSurfaceInvalid(this.$deferrableSurfaces.get(list.indexOf(null)));
                return Boxing.boxBoolean(false);
            }
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            if (Logger.isInfoEnabled(Log.TAG)) {
                android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "Failed to get Surfaces: isActive=" + CoroutineScopeKt.isActive(coroutineScope) + ", surfaces=" + list);
            }
            return Boxing.boxBoolean(false);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            DeferrableSurface.SurfaceClosedException surfaceClosedException = e;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to get Surfaces: Surfaces closed", surfaceClosedException);
            }
            SessionConfigAdapter sessionConfigAdapter = this.$sessionConfigAdapter;
            DeferrableSurface deferrableSurface = e.getDeferrableSurface();
            Intrinsics.checkNotNullExpressionValue(deferrableSurface, "getDeferrableSurface(...)");
            sessionConfigAdapter.reportSurfaceInvalid(deferrableSurface);
            return Boxing.boxBoolean(false);
        } catch (TimeoutCancellationException unused) {
            Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
            long j = this.$timeoutMillis;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to get Surfaces within " + j + " ms");
            }
            return Boxing.boxBoolean(false);
        }
    }
}
