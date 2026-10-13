package androidx.camera.camera2.pipe.framegraph;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameBuffer;
import androidx.camera.camera2.pipe.FrameReference;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: FrameBufferImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002?@B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001bH\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b01H\u0016J\u001e\u00102\u001a\u0004\u0018\u0001032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001805H\u0016J\u001e\u00106\u001a\u0004\u0018\u0001032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001805H\u0016J\"\u00107\u001a\b\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001805H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u00109\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b01H\u0016J\b\u0010;\u001a\u00020,H\u0016J,\u0010<\u001a\u0004\u0018\u0001032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160>2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001805H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006A"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl;", "Landroidx/camera/camera2/pipe/FrameBuffer;", "Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;", "frameGraphBuffers", "Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "parameters", "", "", "capacity", "", "<init>", "(Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;Ljava/util/Set;Ljava/util/Map;I)V", "getStreams", "()Ljava/util/Set;", "getParameters", "()Ljava/util/Map;", "lock", "frameQueue", "Lkotlin/collections/ArrayDeque;", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry;", "closed", "", "_frameFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/camera/camera2/pipe/FrameReference;", "frameFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getFrameFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_size", "Lkotlinx/coroutines/flow/MutableStateFlow;", ContentDisposition.Parameters.Size, "Lkotlinx/coroutines/flow/StateFlow;", "getSize", "()Lkotlinx/coroutines/flow/StateFlow;", "newCapacity", "getCapacity", "()I", "setCapacity", "(I)V", "onFrameStarted", "", "frameReference", "removeFirstReference", "removeLastReference", "removeAllReferences", "", "removeFirstFrameReferenceAndAcquire", "Landroidx/camera/camera2/pipe/Frame;", "predicate", "Lkotlin/Function1;", "removeLastFrameReferenceAndAcquire", "removeAllFrameReferencesAndAcquire", "peekFirstReference", "peekLastReference", "peekAllReferences", "close", "removeAndAcquire", "iterator", "", "BufferEntry", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameBufferImpl implements FrameBuffer, FrameDistributor.FrameStartedListener {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int FRAME_FLOW_EXTRA_BUFFER_CAPACITY = 4;
    private final MutableSharedFlow<FrameReference> _frameFlow;
    private final MutableStateFlow<Integer> _size;
    private int capacity;
    private boolean closed;
    private final SharedFlow<FrameReference> frameFlow;
    private final FrameGraphBuffers frameGraphBuffers;
    private ArrayDeque<BufferEntry> frameQueue;
    private final Object lock;
    private final Map<Object, Object> parameters;
    private final StateFlow<Integer> size;
    private final Set<StreamId> streams;

    public FrameBufferImpl(FrameGraphBuffers frameGraphBuffers, Set<StreamId> streams, Map<Object, ? extends Object> parameters, int i) {
        Intrinsics.checkNotNullParameter(frameGraphBuffers, "frameGraphBuffers");
        Intrinsics.checkNotNullParameter(streams, "streams");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.frameGraphBuffers = frameGraphBuffers;
        this.streams = streams;
        this.parameters = parameters;
        this.lock = new Object();
        this.frameQueue = new ArrayDeque<>(i);
        MutableSharedFlow<FrameReference> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 4, BufferOverflow.DROP_OLDEST);
        this._frameFlow = MutableSharedFlow;
        this.frameFlow = FlowKt.asSharedFlow(MutableSharedFlow);
        if (i < 0) {
            throw new IllegalArgumentException("FrameBuffer capacity must be greater than or equal to 0".toString());
        }
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        this._size = MutableStateFlow;
        this.size = FlowKt.asStateFlow(MutableStateFlow);
        this.capacity = i;
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public Set<StreamId> getStreams() {
        return this.streams;
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public Map<Object, Object> getParameters() {
        return this.parameters;
    }

    /* JADX INFO: compiled from: FrameBufferImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry;", "", "frameReference", "Landroidx/camera/camera2/pipe/FrameReference;", "<init>", "(Landroidx/camera/camera2/pipe/FrameReference;)V", "getFrameReference", "()Landroidx/camera/camera2/pipe/FrameReference;", "WithFrame", "WithoutFrame", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry$WithFrame;", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry$WithoutFrame;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static abstract class BufferEntry {
        private final FrameReference frameReference;

        public /* synthetic */ BufferEntry(FrameReference frameReference, DefaultConstructorMarker defaultConstructorMarker) {
            this(frameReference);
        }

        private BufferEntry(FrameReference frameReference) {
            this.frameReference = frameReference;
        }

        public final FrameReference getFrameReference() {
            return this.frameReference;
        }

        /* JADX INFO: compiled from: FrameBufferImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry$WithFrame;", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry;", TypedValues.Attributes.S_FRAME, "Landroidx/camera/camera2/pipe/Frame;", "<init>", "(Landroidx/camera/camera2/pipe/Frame;)V", "getFrame", "()Landroidx/camera/camera2/pipe/Frame;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WithFrame extends BufferEntry {
            private final Frame frame;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WithFrame(Frame frame) {
                super(frame, null);
                Intrinsics.checkNotNullParameter(frame, "frame");
                this.frame = frame;
            }

            public final Frame getFrame() {
                return this.frame;
            }
        }

        /* JADX INFO: compiled from: FrameBufferImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry$WithoutFrame;", "Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$BufferEntry;", "reference", "Landroidx/camera/camera2/pipe/FrameReference;", "<init>", "(Landroidx/camera/camera2/pipe/FrameReference;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WithoutFrame extends BufferEntry {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WithoutFrame(FrameReference reference) {
                super(reference, null);
                Intrinsics.checkNotNullParameter(reference, "reference");
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public SharedFlow<FrameReference> getFrameFlow() {
        return this.frameFlow;
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public StateFlow<Integer> getSize() {
        return this.size;
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public void setCapacity(int i) throws Exception {
        if (i < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative".toString());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            if (i == this.capacity) {
                return;
            }
            this.capacity = i;
            int size = this.frameQueue.size();
            if (i < size) {
                int i2 = size - i;
                for (int i3 = 0; i3 < i2; i3++) {
                    BufferEntry bufferEntryRemoveFirst = this.frameQueue.removeFirst();
                    BufferEntry.WithFrame withFrame = bufferEntryRemoveFirst instanceof BufferEntry.WithFrame ? (BufferEntry.WithFrame) bufferEntryRemoveFirst : null;
                    if (withFrame != null) {
                        arrayList.add(withFrame.getFrame());
                    }
                }
                this.frameQueue = new ArrayDeque<>(this.frameQueue);
            }
            this._size.setValue(Integer.valueOf(this.frameQueue.size()));
            Unit unit = Unit.INSTANCE;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                UByte$$ExternalSyntheticBackport0.m12761m(it.next());
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.internal.FrameDistributor.FrameStartedListener
    public void onFrameStarted(FrameReference frameReference) throws Exception {
        BufferEntry.WithoutFrame withoutFrame;
        Intrinsics.checkNotNullParameter(frameReference, "frameReference");
        if (getCapacity() == 0) {
            synchronized (this.lock) {
                if (!this.closed) {
                    this._frameFlow.tryEmit(frameReference);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        Frame frame = null;
        Frame frameTryAcquire$default = FrameReference.tryAcquire$default(frameReference, null, 1, null);
        if (frameTryAcquire$default != null) {
            withoutFrame = new BufferEntry.WithFrame(frameTryAcquire$default);
        } else {
            withoutFrame = new BufferEntry.WithoutFrame(frameReference);
        }
        synchronized (this.lock) {
            if (this.closed) {
                frame = withoutFrame instanceof BufferEntry.WithFrame ? ((BufferEntry.WithFrame) withoutFrame).getFrame() : null;
                Unit unit2 = Unit.INSTANCE;
            } else {
                if (this.frameQueue.size() == getCapacity()) {
                    BufferEntry bufferEntryRemoveFirst = this.frameQueue.removeFirst();
                    if (bufferEntryRemoveFirst instanceof BufferEntry.WithFrame) {
                        frame = ((BufferEntry.WithFrame) bufferEntryRemoveFirst).getFrame();
                    }
                }
                this.frameQueue.add(withoutFrame);
                this._size.setValue(Integer.valueOf(this.frameQueue.size()));
                Boolean.valueOf(this._frameFlow.tryEmit(withoutFrame.getFrameReference()));
            }
        }
        if (frame != null) {
            UByte$$ExternalSyntheticBackport0.m12761m((Object) frame);
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public FrameReference removeFirstReference() {
        synchronized (this.lock) {
            FrameReference frameReference = null;
            if (this.closed) {
                return null;
            }
            BufferEntry bufferEntryRemoveFirstOrNull = this.frameQueue.removeFirstOrNull();
            if (bufferEntryRemoveFirstOrNull != null) {
                this._size.setValue(Integer.valueOf(this.frameQueue.size()));
                frameReference = bufferEntryRemoveFirstOrNull.getFrameReference();
            }
            return frameReference;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public FrameReference removeLastReference() {
        synchronized (this.lock) {
            FrameReference frameReference = null;
            if (this.closed) {
                return null;
            }
            BufferEntry bufferEntryRemoveLastOrNull = this.frameQueue.removeLastOrNull();
            if (bufferEntryRemoveLastOrNull != null) {
                this._size.setValue(Integer.valueOf(this.frameQueue.size()));
                frameReference = bufferEntryRemoveLastOrNull.getFrameReference();
            }
            return frameReference;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public List<FrameReference> removeAllReferences() {
        synchronized (this.lock) {
            if (this.closed) {
                return CollectionsKt.emptyList();
            }
            ArrayDeque<BufferEntry> arrayDeque = this.frameQueue;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayDeque, 10));
            Iterator<BufferEntry> it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFrameReference());
            }
            ArrayList arrayList2 = arrayList;
            this.frameQueue.clear();
            this._size.setValue(0);
            return arrayList2;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public Frame removeFirstFrameReferenceAndAcquire(Function1<? super FrameReference, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return removeAndAcquire(this.frameQueue.iterator(), predicate);
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public Frame removeLastFrameReferenceAndAcquire(Function1<? super FrameReference, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return removeAndAcquire(CollectionsKt.asReversedMutable(this.frameQueue).iterator(), predicate);
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public List<Frame> removeAllFrameReferencesAndAcquire(Function1<? super FrameReference, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.lock) {
            if (this.closed) {
                return CollectionsKt.emptyList();
            }
            Iterator it = this.frameQueue.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                BufferEntry bufferEntry = (BufferEntry) it.next();
                if (predicate.invoke(bufferEntry.getFrameReference()).booleanValue()) {
                    it.remove();
                    BufferEntry.WithFrame withFrame = bufferEntry instanceof BufferEntry.WithFrame ? (BufferEntry.WithFrame) bufferEntry : null;
                    if (withFrame != null) {
                        arrayList.add(withFrame.getFrame());
                    }
                }
            }
            this._size.setValue(Integer.valueOf(this.frameQueue.size()));
            return arrayList;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public FrameReference peekFirstReference() {
        synchronized (this.lock) {
            if (this.closed) {
                return null;
            }
            BufferEntry bufferEntryFirstOrNull = this.frameQueue.firstOrNull();
            return bufferEntryFirstOrNull != null ? bufferEntryFirstOrNull.getFrameReference() : null;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public FrameReference peekLastReference() {
        synchronized (this.lock) {
            if (this.closed) {
                return null;
            }
            BufferEntry bufferEntryLastOrNull = this.frameQueue.lastOrNull();
            return bufferEntryLastOrNull != null ? bufferEntryLastOrNull.getFrameReference() : null;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameBuffer
    public List<FrameReference> peekAllReferences() {
        synchronized (this.lock) {
            if (this.closed) {
                return CollectionsKt.emptyList();
            }
            ArrayDeque<BufferEntry> arrayDeque = this.frameQueue;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayDeque, 10));
            Iterator<BufferEntry> it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFrameReference());
            }
            return arrayList;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.List] */
    @Override // androidx.camera.camera2.pipe.FrameBuffer, java.lang.AutoCloseable
    public void close() throws Exception {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ArrayDeque<BufferEntry> arrayDeque = this.frameQueue;
            ArrayList arrayList = new ArrayList();
            for (BufferEntry bufferEntry : arrayDeque) {
                BufferEntry.WithFrame withFrame = bufferEntry instanceof BufferEntry.WithFrame ? (BufferEntry.WithFrame) bufferEntry : null;
                Frame frame = withFrame != null ? withFrame.getFrame() : null;
                if (frame != null) {
                    arrayList.add(frame);
                }
            }
            objectRef.element = arrayList;
            this.frameQueue.clear();
            this._size.setValue(0);
            Unit unit = Unit.INSTANCE;
            Iterator it = ((List) objectRef.element).iterator();
            while (it.hasNext()) {
                UByte$$ExternalSyntheticBackport0.m12761m(it.next());
            }
            this.frameGraphBuffers.detach$camera_camera2_pipe(this);
        }
    }

    private final Frame removeAndAcquire(Iterator<? extends BufferEntry> iterator, Function1<? super FrameReference, Boolean> predicate) {
        while (iterator.hasNext()) {
            BufferEntry next = iterator.next();
            if (predicate.invoke(next.getFrameReference()).booleanValue()) {
                iterator.remove();
                this._size.setValue(Integer.valueOf(this.frameQueue.size()));
                BufferEntry.WithFrame withFrame = next instanceof BufferEntry.WithFrame ? (BufferEntry.WithFrame) next : null;
                if (withFrame == null) {
                    break;
                }
                return withFrame.getFrame();
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: FrameBufferImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameBufferImpl$Companion;", "", "<init>", "()V", "FRAME_FLOW_EXTRA_BUFFER_CAPACITY", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
