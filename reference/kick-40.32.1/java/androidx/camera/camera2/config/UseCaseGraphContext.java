package androidx.camera.camera2.config;

import androidx.camera.camera2.adapter.CameraStateAdapter;
import androidx.camera.camera2.adapter.GraphStateToCameraStateAdapter;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseCaseCameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0003\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#J\u0006\u0010$\u001a\u00020\u001fJ(\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(H\u0086H¢\u0006\u0002\u0010*R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00040\u00040\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018*\u0004\b\u0015\u0010\u0016R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Landroidx/camera/camera2/config/UseCaseGraphContext;", "", "cameraGraphProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraStateAdapter", "Landroidx/camera/camera2/adapter/CameraStateAdapter;", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;", "streamConfigMapProvider", "", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "Landroidx/camera/core/impl/DeferrableSurface;", "defaultSurfaceToStreamMap", "Landroidx/camera/camera2/pipe/StreamId;", "<init>", "(Ljavax/inject/Provider;Landroidx/camera/camera2/adapter/CameraStateAdapter;Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;Ljavax/inject/Provider;Ljava/util/Map;)V", "_graph", "Lkotlin/Lazy;", "kotlin.jvm.PlatformType", "graph", "getGraph$delegate", "(Landroidx/camera/camera2/config/UseCaseGraphContext;)Ljava/lang/Object;", "getGraph", "()Landroidx/camera/camera2/pipe/CameraGraph;", "surfaceToStreamMap", "getSurfaceToStreamMap", "()Ljava/util/Map;", "surfaceToStreamMap$delegate", "Lkotlin/Lazy;", "closeGraph", "", "getStreamIdsFromSurfaces", "", "deferrableSurfaces", "", "configureCameraStateListener", "useGraphSession", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UseCaseGraphContext {
    private final Lazy<CameraGraph> _graph;
    private final Provider<CameraGraph> cameraGraphProvider;
    private final CameraStateAdapter cameraStateAdapter;
    private final GraphStateToCameraStateAdapter graphStateToCameraStateAdapter;
    private final Provider<Map<CameraStream.Config, DeferrableSurface>> streamConfigMapProvider;

    /* JADX INFO: renamed from: surfaceToStreamMap$delegate, reason: from kotlin metadata */
    private final Lazy surfaceToStreamMap;

    /* JADX INFO: renamed from: androidx.camera.camera2.config.UseCaseGraphContext$useGraphSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseCameraConfig.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.config.UseCaseGraphContext", f = "UseCaseCameraConfig.kt", i = {0}, l = {242}, m = "useGraphSession", n = {"block"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseCaseGraphContext.this.useGraphSession(null, this);
        }
    }

    public UseCaseGraphContext(Provider<CameraGraph> cameraGraphProvider, CameraStateAdapter cameraStateAdapter, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, Provider<Map<CameraStream.Config, DeferrableSurface>> streamConfigMapProvider, final Map<DeferrableSurface, StreamId> map) {
        Intrinsics.checkNotNullParameter(cameraGraphProvider, "cameraGraphProvider");
        Intrinsics.checkNotNullParameter(cameraStateAdapter, "cameraStateAdapter");
        Intrinsics.checkNotNullParameter(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        Intrinsics.checkNotNullParameter(streamConfigMapProvider, "streamConfigMapProvider");
        this.cameraGraphProvider = cameraGraphProvider;
        this.cameraStateAdapter = cameraStateAdapter;
        this.graphStateToCameraStateAdapter = graphStateToCameraStateAdapter;
        this.streamConfigMapProvider = streamConfigMapProvider;
        this._graph = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.config.UseCaseGraphContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.cameraGraphProvider.get();
            }
        });
        this.surfaceToStreamMap = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.config.UseCaseGraphContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UseCaseGraphContext.surfaceToStreamMap_delegate$lambda$0(map, this);
            }
        });
    }

    public /* synthetic */ UseCaseGraphContext(Provider provider, CameraStateAdapter cameraStateAdapter, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, Provider provider2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(provider, cameraStateAdapter, graphStateToCameraStateAdapter, provider2, (i & 16) != 0 ? null : map);
    }

    public final CameraGraph getGraph() {
        CameraGraph value = this._graph.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return value;
    }

    public final Map<DeferrableSurface, StreamId> getSurfaceToStreamMap() {
        return (Map) this.surfaceToStreamMap.getValue();
    }

    static final Map surfaceToStreamMap_delegate$lambda$0(Map map, UseCaseGraphContext useCaseGraphContext) {
        if (map != null) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<CameraStream.Config, DeferrableSurface> map2 = useCaseGraphContext.streamConfigMapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map2, "get(...)");
        for (Map.Entry<CameraStream.Config, DeferrableSurface> entry : map2.entrySet()) {
            CameraStream.Config key = entry.getKey();
            DeferrableSurface value = entry.getValue();
            CameraStream cameraStream = useCaseGraphContext.getGraph().getStreams().get(key);
            if (cameraStream != null) {
                linkedHashMap.put(value, StreamId.m791boximpl(cameraStream.getId()));
            }
        }
        return MapsKt.toMap(linkedHashMap);
    }

    public final void closeGraph() {
        if (this._graph.isInitialized()) {
            getGraph().close();
        }
    }

    public final Set<StreamId> getStreamIdsFromSurfaces(Collection<? extends DeferrableSurface> deferrableSurfaces) {
        Intrinsics.checkNotNullParameter(deferrableSurfaces, "deferrableSurfaces");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = deferrableSurfaces.iterator();
        while (it.hasNext()) {
            StreamId streamId = getSurfaceToStreamMap().get((DeferrableSurface) it.next());
            if (streamId != null) {
                linkedHashSet.add(StreamId.m791boximpl(streamId.m797unboximpl()));
            }
        }
        return linkedHashSet;
    }

    public final void configureCameraStateListener() {
        this.graphStateToCameraStateAdapter.setCameraGraph(getGraph());
        this.cameraStateAdapter.onGraphUpdated(getGraph());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object useGraphSession(Function1<? super CameraGraph.Session, ? extends T> function1, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAcquireSession = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAcquireSession);
            CameraGraph graph = getGraph();
            anonymousClass1.L$0 = function1;
            anonymousClass1.label = 1;
            objAcquireSession = graph.acquireSession(anonymousClass1);
            if (objAcquireSession == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAcquireSession);
        }
        AutoCloseable autoCloseable = (AutoCloseable) objAcquireSession;
        try {
            T tInvoke = function1.invoke((CameraGraph.Session) autoCloseable);
            AutoCloseableKt.closeFinally(autoCloseable, null);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th2;
            }
        }
    }

    private final <T> Object useGraphSession$$forInline(Function1<? super CameraGraph.Session, ? extends T> function1, Continuation<? super T> continuation) {
        AutoCloseable autoCloseable = (AutoCloseable) getGraph().acquireSession(continuation);
        try {
            T tInvoke = function1.invoke((CameraGraph.Session) autoCloseable);
            AutoCloseableKt.closeFinally(autoCloseable, null);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th2;
            }
        }
    }
}
