package androidx.camera.camera2.pipe.framegraph;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameBuffer;
import androidx.camera.camera2.pipe.FrameReference;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestsKt;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.config.FrameGraphCoroutineScope;
import androidx.camera.camera2.pipe.config.FrameGraphScope;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FrameGraphBuffers.kt */
/* JADX INFO: loaded from: classes.dex */
@FrameGraphScope
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001b\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0012\u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0003J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;", "Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "frameGraphCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph;Lkotlinx/coroutines/CoroutineScope;)V", "lock", "", "buffers", "", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl;", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "parameters", "", "attach", "Landroidx/camera/camera2/pipe/FrameBuffer;", "", "", "capacity", "", "attach$camera_camera2_pipe", "detach", "", "frameBuffer", "detach$camera_camera2_pipe", "updateStreamsAndParameters", "", "invalidate", "onFrameStarted", "frameReference", "Landroidx/camera/camera2/pipe/FrameReference;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameGraphBuffers implements FrameDistributor.FrameStartedListener {
    private final List<FrameBufferImpl> buffers;
    private final CameraGraph cameraGraph;
    private final CoroutineScope frameGraphCoroutineScope;
    private final Object lock;
    private Map<Object, Object> parameters;
    private Set<StreamId> streams;

    @Inject
    public FrameGraphBuffers(CameraGraph cameraGraph, @FrameGraphCoroutineScope CoroutineScope frameGraphCoroutineScope) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        Intrinsics.checkNotNullParameter(frameGraphCoroutineScope, "frameGraphCoroutineScope");
        this.cameraGraph = cameraGraph;
        this.frameGraphCoroutineScope = frameGraphCoroutineScope;
        this.lock = new Object();
        this.buffers = new ArrayList();
        this.streams = new LinkedHashSet();
        this.parameters = new LinkedHashMap();
    }

    public final FrameBuffer attach$camera_camera2_pipe(Set<StreamId> streams, Map<Object, ? extends Object> parameters, int capacity) {
        boolean zUpdateStreamsAndParameters;
        Intrinsics.checkNotNullParameter(streams, "streams");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        FrameBufferImpl frameBufferImpl = new FrameBufferImpl(this, streams, parameters, capacity);
        synchronized (this.lock) {
            this.buffers.add(frameBufferImpl);
            zUpdateStreamsAndParameters = updateStreamsAndParameters();
        }
        if (zUpdateStreamsAndParameters) {
            invalidate();
        }
        return frameBufferImpl;
    }

    public final void detach$camera_camera2_pipe(FrameBufferImpl frameBuffer) {
        boolean zUpdateStreamsAndParameters;
        Intrinsics.checkNotNullParameter(frameBuffer, "frameBuffer");
        synchronized (this.lock) {
            this.buffers.remove(frameBuffer);
            zUpdateStreamsAndParameters = updateStreamsAndParameters();
        }
        if (zUpdateStreamsAndParameters) {
            invalidate();
        }
    }

    private final boolean updateStreamsAndParameters() {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            for (FrameBufferImpl frameBufferImpl : this.buffers) {
                linkedHashSet.addAll(frameBufferImpl.getStreams());
                for (Map.Entry<Object, Object> entry : frameBufferImpl.getParameters().entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (!(key instanceof CaptureRequest.Key) && !(key instanceof androidx.camera.camera2.pipe.Metadata.Key)) {
                        throw new IllegalStateException(("Invalid type for " + entry.getKey()).toString());
                    }
                    if (linkedHashMap.containsKey(key) && !Intrinsics.areEqual(linkedHashMap.get(key), value)) {
                        throw new IllegalStateException("Conflicting parameter values, " + key + " and " + this.parameters.get(key) + " have different values.");
                    }
                    if (value != null) {
                        linkedHashMap.put(key, value);
                    }
                }
            }
            z = (Intrinsics.areEqual(linkedHashSet, this.streams) && Intrinsics.areEqual(linkedHashMap, this.parameters)) ? false : true;
            this.streams = linkedHashSet;
            this.parameters = linkedHashMap;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    public final void invalidate() {
        if (!this.buffers.isEmpty()) {
            this.cameraGraph.useSessionIn(this.frameGraphCoroutineScope, new AnonymousClass3(null));
            return;
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "No available buffer, invoke stop repeating.");
        }
        this.cameraGraph.useSessionIn(this.frameGraphCoroutineScope, new AnonymousClass2(null));
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.FrameGraphBuffers$invalidate$2, reason: invalid class name */
    /* JADX INFO: compiled from: FrameGraphBuffers.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "session", "Landroidx/camera/camera2/pipe/CameraGraph$Session;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.FrameGraphBuffers$invalidate$2", f = "FrameGraphBuffers.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, CameraGraph.Session, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, CameraGraph.Session session, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = session;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((CameraGraph.Session) this.L$0).stopRepeating();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.FrameGraphBuffers$invalidate$3, reason: invalid class name */
    /* JADX INFO: compiled from: FrameGraphBuffers.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "session", "Landroidx/camera/camera2/pipe/CameraGraph$Session;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.FrameGraphBuffers$invalidate$3", f = "FrameGraphBuffers.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function3<CoroutineScope, CameraGraph.Session, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, CameraGraph.Session session, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = FrameGraphBuffers.this.new AnonymousClass3(continuation);
            anonymousClass3.L$0 = session;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((CameraGraph.Session) this.L$0).startRepeating(new Request(CollectionsKt.toList(FrameGraphBuffers.this.streams), RequestsKt.filterToCaptureRequestParameters(FrameGraphBuffers.this.parameters), RequestsKt.filterToMetadataParameters(FrameGraphBuffers.this.parameters), null, null, null, 56, null));
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.internal.FrameDistributor.FrameStartedListener
    public void onFrameStarted(FrameReference frameReference) {
        Intrinsics.checkNotNullParameter(frameReference, "frameReference");
        synchronized (this.lock) {
            Iterator<FrameBufferImpl> it = this.buffers.iterator();
            while (it.hasNext()) {
                it.next().onFrameStarted(frameReference);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
