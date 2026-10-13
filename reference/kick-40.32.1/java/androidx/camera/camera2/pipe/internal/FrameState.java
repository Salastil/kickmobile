package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameId;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.media.OutputImage;
import androidx.camera.camera2.pipe.media.SharedOutputImage;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: FrameState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 82\u00020\u0001:\u000545678B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020(J\u0015\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020(H\u0002J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u0014¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u0016\u001a\u00060\u0017R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\u00000\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState;", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "imageStreams", "", "Landroidx/camera/camera2/pipe/CameraStream;", "<init>", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJLjava/util/Set;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "getFrameNumber-Ugla2oM", "()J", "J", "getFrameTimestamp-LS1Wq50", "frameId", "Landroidx/camera/camera2/pipe/FrameId;", "getFrameId-OMxQvVY", "frameInfoOutput", "Landroidx/camera/camera2/pipe/internal/FrameState$FrameInfoOutput;", "getFrameInfoOutput", "()Landroidx/camera/camera2/pipe/internal/FrameState$FrameInfoOutput;", "imageOutputs", "", "Landroidx/camera/camera2/pipe/internal/FrameState$ImageOutput;", "getImageOutputs", "()Ljava/util/List;", "state", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/internal/FrameState$State;", "remainingStreamCount", "Lkotlinx/atomicfu/AtomicInt;", "listenerStates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/camera/camera2/pipe/internal/ListenerState;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", "onFrameInfoComplete", "onStreamResultComplete", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "onStreamResultComplete-aKI5c8E", "(I)V", "invokeOnFrameComplete", "toString", "", "State", "FrameOutput", "FrameInfoOutput", "ImageOutput", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicLong frameIds = AtomicFU.atomic(0L);
    private final long frameId;
    private final FrameInfoOutput frameInfoOutput;
    private final long frameNumber;
    private final long frameTimestamp;
    private final List<ImageOutput> imageOutputs;
    private final CopyOnWriteArrayList<ListenerState> listenerStates;
    private final AtomicInt remainingStreamCount;
    private final RequestMetadata requestMetadata;
    private final AtomicRef<State> state;

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "FRAME_INFO_COMPLETE", "STREAM_RESULTS_COMPLETE", "COMPLETE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private enum State {
        STARTED,
        FRAME_INFO_COMPLETE,
        STREAM_RESULTS_COMPLETE,
        COMPLETE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.FRAME_INFO_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.STREAM_RESULTS_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[State.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ FrameState(RequestMetadata requestMetadata, long j, long j2, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestMetadata, j, j2, set);
    }

    private FrameState(RequestMetadata requestMetadata, long j, long j2, Set<CameraStream> imageStreams) {
        Object next;
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(imageStreams, "imageStreams");
        this.requestMetadata = requestMetadata;
        this.frameNumber = j;
        this.frameTimestamp = j2;
        this.frameId = INSTANCE.m1015nextFrameIdOMxQvVY();
        this.frameInfoOutput = new FrameInfoOutput();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<StreamId> it = requestMetadata.getStreams().keySet().iterator();
        while (it.hasNext()) {
            int iM797unboximpl = it.next().m797unboximpl();
            Iterator<T> it2 = imageStreams.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!StreamId.m794equalsimpl0(((CameraStream) next).getId(), iM797unboximpl));
            CameraStream cameraStream = (CameraStream) next;
            if (cameraStream != null) {
                List<OutputStream> outputs = cameraStream.getOutputs();
                AtomicInt atomicIntAtomic = AtomicFU.atomic(outputs.size());
                int size = outputs.size();
                for (int i = 0; i < size; i++) {
                    listCreateListBuilder.add(new ImageOutput(this, iM797unboximpl, outputs.get(i).getId(), atomicIntAtomic, null));
                }
            }
        }
        List<ImageOutput> listBuild = CollectionsKt.build(listCreateListBuilder);
        this.imageOutputs = listBuild;
        this.state = AtomicFU.atomic(State.STARTED);
        List<ImageOutput> list = listBuild;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList.add(StreamId.m791boximpl(((ImageOutput) it3.next()).getStreamId()));
        }
        this.remainingStreamCount = AtomicFU.atomic(CollectionsKt.distinct(arrayList).size());
        this.listenerStates = new CopyOnWriteArrayList<>();
    }

    public final RequestMetadata getRequestMetadata() {
        return this.requestMetadata;
    }

    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM, reason: not valid java name and from getter */
    public final long getFrameNumber() {
        return this.frameNumber;
    }

    /* JADX INFO: renamed from: getFrameTimestamp-LS1Wq50, reason: not valid java name and from getter */
    public final long getFrameTimestamp() {
        return this.frameTimestamp;
    }

    /* JADX INFO: renamed from: getFrameId-OMxQvVY, reason: not valid java name and from getter */
    public final long getFrameId() {
        return this.frameId;
    }

    public final FrameInfoOutput getFrameInfoOutput() {
        return this.frameInfoOutput;
    }

    public final List<ImageOutput> getImageOutputs() {
        return this.imageOutputs;
    }

    public final void addListener(Frame.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ListenerState listenerState = new ListenerState(listener);
        this.listenerStates.add(listenerState);
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.getValue().ordinal()];
        if (i == 1) {
            listenerState.m1024invokeOnStartedcfZT5Y(this.frameNumber, this.frameTimestamp);
            return;
        }
        if (i == 2) {
            listenerState.m1021invokeOnFrameInfoAvailablecfZT5Y(this.frameNumber, this.frameTimestamp);
        } else if (i == 3) {
            listenerState.m1023invokeOnImagesAvailablecfZT5Y(this.frameNumber, this.frameTimestamp);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            listenerState.m1020invokeOnFrameCompletecfZT5Y(this.frameNumber, this.frameTimestamp);
        }
    }

    public final void onFrameInfoComplete() {
        State value;
        State state;
        AtomicRef<State> atomicRef = this.state;
        do {
            value = atomicRef.getValue();
            State state2 = value;
            int i = WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
            if (i == 1) {
                state = State.FRAME_INFO_COMPLETE;
            } else if (i == 3) {
                state = State.COMPLETE;
            } else {
                throw new IllegalStateException("Unexpected frame state for " + this + "! State is " + state2 + ' ');
            }
        } while (!atomicRef.compareAndSet(value, state));
        Iterator<ListenerState> it = this.listenerStates.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().m1021invokeOnFrameInfoAvailablecfZT5Y(this.frameNumber, this.frameTimestamp);
        }
        if (state == State.COMPLETE) {
            invokeOnFrameComplete();
        }
    }

    /* JADX INFO: renamed from: onStreamResultComplete-aKI5c8E, reason: not valid java name */
    public final void m1013onStreamResultCompleteaKI5c8E(int streamId) {
        State value;
        State state;
        if (this.remainingStreamCount.decrementAndGet() != 0) {
            return;
        }
        AtomicRef<State> atomicRef = this.state;
        do {
            value = atomicRef.getValue();
            State state2 = value;
            int i = WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
            if (i == 1) {
                state = State.STREAM_RESULTS_COMPLETE;
            } else if (i == 2) {
                state = State.COMPLETE;
            } else {
                throw new IllegalStateException("Unexpected frame state for " + this + "! State is " + state2 + ' ');
            }
        } while (!atomicRef.compareAndSet(value, state));
        Iterator<ListenerState> it = this.listenerStates.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().m1023invokeOnImagesAvailablecfZT5Y(this.frameNumber, this.frameTimestamp);
        }
        if (state == State.COMPLETE) {
            invokeOnFrameComplete();
        }
    }

    private final void invokeOnFrameComplete() {
        Iterator<ListenerState> it = this.listenerStates.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().m1020invokeOnFrameCompletecfZT5Y(this.frameNumber, this.frameTimestamp);
        }
    }

    public String toString() {
        return "Frame-" + ((Object) FrameId.m527toStringimpl(this.frameId)) + '(' + this.frameNumber + '@' + this.frameTimestamp + ')';
    }

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0013H$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$FrameOutput;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "count", "Lkotlinx/atomicfu/AtomicInt;", "internalResult", "Lkotlinx/coroutines/CompletableDeferred;", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "getInternalResult", "()Lkotlinx/coroutines/CompletableDeferred;", "result", "Lkotlinx/coroutines/Deferred;", "getResult", "()Lkotlinx/coroutines/Deferred;", "increment", "", "decrement", "", "status", "Landroidx/camera/camera2/pipe/OutputStatus;", "getStatus-U7r42EA", "()I", "outputOrNull", "()Ljava/lang/Object;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class FrameOutput<T> {
        private final AtomicInt count = AtomicFU.atomic(1);
        private final CompletableDeferred<OutputResult<T>> internalResult = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

        public abstract Object await(Continuation<? super T> continuation);

        public abstract T outputOrNull();

        protected abstract void release();

        protected final CompletableDeferred<OutputResult<T>> getInternalResult() {
            return this.internalResult;
        }

        public final Deferred<OutputResult<T>> getResult() {
            return this.internalResult;
        }

        public final boolean increment() {
            int value;
            int i;
            AtomicInt atomicInt = this.count;
            do {
                value = atomicInt.getValue();
                i = value <= 0 ? 0 : value + 1;
            } while (!atomicInt.compareAndSet(value, i));
            return i != 0;
        }

        public final void decrement() {
            if (this.count.decrementAndGet() == 0) {
                OutputResult.Companion companion = OutputResult.INSTANCE;
                this.internalResult.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA()))));
                release();
            }
        }

        /* JADX INFO: renamed from: getStatus-U7r42EA, reason: not valid java name */
        public final int m1017getStatusU7r42EA() {
            if (this.count.getValue() == 0) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            OutputResult.Companion companion = OutputResult.INSTANCE;
            CompletableDeferred<OutputResult<T>> completableDeferred = this.internalResult;
            if (!completableDeferred.isCompleted()) {
                return OutputStatus.INSTANCE.m590getPENDINGU7r42EA();
            }
            if (completableDeferred.isCancelled()) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            Object result = completableDeferred.getCompleted().getResult();
            if (OutputResult.m1041getAvailableimpl(result)) {
                return OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA();
            }
            if (result == null) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            return ((OutputStatus) result).m584unboximpl();
        }
    }

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J=\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0014¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$FrameInfoOutput;", "Landroidx/camera/camera2/pipe/internal/FrameState$FrameOutput;", "Landroidx/camera/camera2/pipe/FrameInfo;", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;)V", "onOutputComplete", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputComplete-3ejhThk", "(JJJJLjava/lang/Object;)V", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outputOrNull", "release", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FrameInfoOutput extends FrameOutput<FrameInfo> implements OutputDistributor.OutputListener<FrameInfo> {
        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        protected void release() {
        }

        public FrameInfoOutput() {
        }

        @Override // androidx.camera.camera2.pipe.internal.OutputDistributor.OutputListener
        /* JADX INFO: renamed from: onOutputComplete-3ejhThk, reason: not valid java name */
        public void mo1016onOutputComplete3ejhThk(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult) {
            getInternalResult().complete(OutputResult.m1037boximpl(outputResult));
            FrameState.this.onFrameInfoComplete();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        public Object await(Continuation<? super FrameInfo> continuation) {
            FrameState$FrameInfoOutput$await$1 frameState$FrameInfoOutput$await$1;
            if (continuation instanceof FrameState$FrameInfoOutput$await$1) {
                frameState$FrameInfoOutput$await$1 = (FrameState$FrameInfoOutput$await$1) continuation;
                if ((frameState$FrameInfoOutput$await$1.label & Integer.MIN_VALUE) != 0) {
                    frameState$FrameInfoOutput$await$1.label -= Integer.MIN_VALUE;
                } else {
                    frameState$FrameInfoOutput$await$1 = new FrameState$FrameInfoOutput$await$1(this, continuation);
                }
            } else {
                frameState$FrameInfoOutput$await$1 = new FrameState$FrameInfoOutput$await$1(this, continuation);
            }
            Object objAwait = frameState$FrameInfoOutput$await$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameState$FrameInfoOutput$await$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objAwait);
                Deferred<OutputResult<FrameInfo>> result = getResult();
                frameState$FrameInfoOutput$await$1.label = 1;
                objAwait = result.await(frameState$FrameInfoOutput$await$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            Object result2 = ((OutputResult) objAwait).getResult();
            if (OutputResult.m1041getAvailableimpl(result2)) {
                return result2;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        public FrameInfo outputOrNull() {
            OutputResult.Companion companion = OutputResult.INSTANCE;
            Deferred<OutputResult<FrameInfo>> result = getResult();
            Object obj = null;
            if (result.isCompleted() && !result.isCancelled()) {
                Object result2 = result.getCompleted().getResult();
                if (OutputResult.m1041getAvailableimpl(result2)) {
                    obj = result2;
                }
            }
            return (FrameInfo) obj;
        }
    }

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0012H\u0014R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$ImageOutput;", "Landroidx/camera/camera2/pipe/internal/FrameState$FrameOutput;", "Landroidx/camera/camera2/pipe/media/SharedOutputImage;", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "remainingOutputResults", "Lkotlinx/atomicfu/AtomicInt;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;IILkotlinx/atomicfu/AtomicInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreamId-ptHMqGs", "()I", "I", "getOutputId-4LaLFng", "onOutputComplete", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputComplete-3ejhThk", "(JJJJLjava/lang/Object;)V", "outputOrNull", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ImageOutput extends FrameOutput<SharedOutputImage> implements OutputDistributor.OutputListener<OutputImage> {
        private final int outputId;
        private final AtomicInt remainingOutputResults;
        private final int streamId;
        final /* synthetic */ FrameState this$0;

        public /* synthetic */ ImageOutput(FrameState frameState, int i, int i2, AtomicInt atomicInt, DefaultConstructorMarker defaultConstructorMarker) {
            this(frameState, i, i2, atomicInt);
        }

        private ImageOutput(FrameState frameState, int i, int i2, AtomicInt remainingOutputResults) {
            Intrinsics.checkNotNullParameter(remainingOutputResults, "remainingOutputResults");
            this.this$0 = frameState;
            this.streamId = i;
            this.outputId = i2;
            this.remainingOutputResults = remainingOutputResults;
        }

        /* JADX INFO: renamed from: getStreamId-ptHMqGs, reason: not valid java name and from getter */
        public final int getStreamId() {
            return this.streamId;
        }

        /* JADX INFO: renamed from: getOutputId-4LaLFng, reason: not valid java name and from getter */
        public final int getOutputId() {
            return this.outputId;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:9:0x0024  */
        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        public SharedOutputImage outputOrNull() {
            Object result;
            OutputResult.Companion companion = OutputResult.INSTANCE;
            Deferred<OutputResult<SharedOutputImage>> result2 = getResult();
            if (!result2.isCompleted() || result2.isCancelled()) {
                result = null;
            } else {
                result = result2.getCompleted().getResult();
                if (!OutputResult.m1041getAvailableimpl(result)) {
                    result = null;
                }
            }
            SharedOutputImage sharedOutputImage = (SharedOutputImage) result;
            if (sharedOutputImage != null) {
                return sharedOutputImage.acquireOrNull();
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        public Object await(Continuation<? super SharedOutputImage> continuation) {
            FrameState$ImageOutput$await$1 frameState$ImageOutput$await$1;
            if (continuation instanceof FrameState$ImageOutput$await$1) {
                frameState$ImageOutput$await$1 = (FrameState$ImageOutput$await$1) continuation;
                if ((frameState$ImageOutput$await$1.label & Integer.MIN_VALUE) != 0) {
                    frameState$ImageOutput$await$1.label -= Integer.MIN_VALUE;
                } else {
                    frameState$ImageOutput$await$1 = new FrameState$ImageOutput$await$1(this, continuation);
                }
            } else {
                frameState$ImageOutput$await$1 = new FrameState$ImageOutput$await$1(this, continuation);
            }
            Object objAwait = frameState$ImageOutput$await$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameState$ImageOutput$await$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objAwait);
                Deferred<OutputResult<SharedOutputImage>> result = getResult();
                frameState$ImageOutput$await$1.label = 1;
                objAwait = result.await(frameState$ImageOutput$await$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            Object result2 = ((OutputResult) objAwait).getResult();
            if (!OutputResult.m1041getAvailableimpl(result2)) {
                result2 = null;
            }
            SharedOutputImage sharedOutputImage = (SharedOutputImage) result2;
            if (sharedOutputImage != null) {
                return sharedOutputImage.acquireOrNull();
            }
            return null;
        }

        @Override // androidx.camera.camera2.pipe.internal.FrameState.FrameOutput
        protected void release() throws Exception {
            OutputResult.Companion companion = OutputResult.INSTANCE;
            CompletableDeferred<OutputResult<SharedOutputImage>> internalResult = getInternalResult();
            Object obj = null;
            if (internalResult.isCompleted() && !internalResult.isCancelled()) {
                Object result = internalResult.getCompleted().getResult();
                if (OutputResult.m1041getAvailableimpl(result)) {
                    obj = result;
                }
            }
            SharedOutputImage sharedOutputImage = (SharedOutputImage) obj;
            if (sharedOutputImage != null) {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) sharedOutputImage);
            }
        }

        @Override // androidx.camera.camera2.pipe.internal.OutputDistributor.OutputListener
        /* JADX INFO: renamed from: onOutputComplete-3ejhThk */
        public void mo1016onOutputComplete3ejhThk(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult) throws Exception {
            int iM584unboximpl;
            OutputImage outputImage = (OutputImage) (OutputResult.m1041getAvailableimpl(outputResult) ? outputResult : null);
            if (outputImage != null) {
                SharedOutputImage sharedOutputImageFrom = SharedOutputImage.INSTANCE.from(outputImage);
                OutputResult.Companion companion = OutputResult.INSTANCE;
                if (!getInternalResult().complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(sharedOutputImageFrom)))) {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) sharedOutputImageFrom);
                }
            } else {
                OutputResult.Companion companion2 = OutputResult.INSTANCE;
                CompletableDeferred<OutputResult<SharedOutputImage>> internalResult = getInternalResult();
                if (OutputResult.m1041getAvailableimpl(outputResult)) {
                    iM584unboximpl = OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA();
                } else if (outputResult == null) {
                    iM584unboximpl = OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
                } else {
                    iM584unboximpl = ((OutputStatus) outputResult).m584unboximpl();
                }
                internalResult.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(iM584unboximpl))));
            }
            if (this.remainingOutputResults.decrementAndGet() == 0) {
                Iterator it = this.this$0.listenerStates.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    ((ListenerState) it.next()).m1022invokeOnImageAvailableaKI5c8E(this.streamId);
                }
                this.this$0.m1013onStreamResultCompleteaKI5c8E(this.streamId);
            }
        }
    }

    /* JADX INFO: compiled from: FrameState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$Companion;", "", "<init>", "()V", "frameIds", "Lkotlinx/atomicfu/AtomicLong;", "nextFrameId", "Landroidx/camera/camera2/pipe/FrameId;", "nextFrameId-OMxQvVY", "()J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: nextFrameId-OMxQvVY, reason: not valid java name */
        public final long m1015nextFrameIdOMxQvVY() {
            return FrameId.m523constructorimpl(FrameState.frameIds.incrementAndGet());
        }
    }
}
