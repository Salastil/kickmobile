package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.media.OutputImage;
import androidx.camera.camera2.pipe.media.SharedOutputImage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: FrameImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0012H\u0004J\u0010\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\fH\u0096@¢\u0006\u0004\b5\u00100J\u0019\u00101\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b6\u00103J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020-082\u0006\u0010.\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b9\u00100J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020-082\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010=\u001a\u00020$2\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b@\u0010?J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006F"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameImpl;", "Landroidx/camera/camera2/pipe/Frame;", "frameState", "Landroidx/camera/camera2/pipe/internal/FrameState;", "imageStreams", "", "Landroidx/camera/camera2/pipe/StreamId;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;Ljava/util/Set;)V", "getImageStreams", "()Ljava/util/Set;", "outputStreams", "Landroidx/camera/camera2/pipe/OutputId;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "tryAcquire", "streamFilter", "close", "", "release", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "frameId", "Landroidx/camera/camera2/pipe/FrameId;", "getFrameId-OMxQvVY", "()J", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "getFrameTimestamp-LS1Wq50", "frameInfoStatus", "Landroidx/camera/camera2/pipe/OutputStatus;", "getFrameInfoStatus-U7r42EA", "()I", "finalize", "awaitFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrameInfo", "awaitImage", "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "awaitImage-NYG5g8E", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImage", "getImage-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/media/OutputImage;", "outputId", "awaitImage-A9nWXxg", "getImage-iYJqvbA", "awaitImages", "", "awaitImages-NYG5g8E", "getImages", "getImages-aKI5c8E", "(I)Ljava/util/List;", "imageStatus", "imageStatus-Oo2lJfM", "(I)I", "imageStatus-BWjvHWQ", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameImpl implements Frame {
    private final AtomicBoolean closed;
    private final FrameState frameState;
    private final Set<StreamId> imageStreams;
    private final Set<OutputId> outputStreams;

    public FrameImpl(FrameState frameState, Set<StreamId> imageStreams) {
        Intrinsics.checkNotNullParameter(frameState, "frameState");
        Intrinsics.checkNotNullParameter(imageStreams, "imageStreams");
        this.frameState = frameState;
        this.imageStreams = imageStreams;
        List<FrameState.ImageOutput> imageOutputs = frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageOutputs, 10));
        Iterator<T> it = imageOutputs.iterator();
        while (it.hasNext()) {
            arrayList.add(OutputId.m571boximpl(((FrameState.ImageOutput) it.next()).getOutputId()));
        }
        this.outputStreams = CollectionsKt.toSet(arrayList);
        this.closed = AtomicFU.atomic(false);
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public /* bridge */ /* synthetic */ Frame tryAcquire(Set set) {
        return tryAcquire((Set<StreamId>) set);
    }

    public /* synthetic */ FrameImpl(FrameState frameState, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            List<FrameState.ImageOutput> imageOutputs = frameState.getImageOutputs();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageOutputs, 10));
            Iterator<T> it = imageOutputs.iterator();
            while (it.hasNext()) {
                arrayList.add(StreamId.m791boximpl(((FrameState.ImageOutput) it.next()).getStreamId()));
            }
            set = CollectionsKt.toSet(arrayList);
        }
        this(frameState, set);
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public Set<StreamId> getImageStreams() {
        return this.imageStreams;
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public FrameImpl tryAcquire(Set<StreamId> streamFilter) {
        boolean z;
        if (this.closed.getValue() || !this.frameState.getFrameInfoOutput().increment()) {
            return null;
        }
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        Iterator<FrameState.ImageOutput> it = this.frameState.getImageOutputs().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            FrameState.ImageOutput next = it.next();
            int streamId = next.getStreamId();
            if (getImageStreams().contains(StreamId.m791boximpl(streamId)) && (streamFilter == null || streamFilter.contains(StreamId.m791boximpl(streamId)))) {
                if (!next.increment()) {
                    z = false;
                    break;
                }
                setCreateSetBuilder.add(StreamId.m791boximpl(streamId));
            }
        }
        Set setBuild = SetsKt.build(setCreateSetBuilder);
        if (!z) {
            this.frameState.getFrameInfoOutput().decrement();
            for (FrameState.ImageOutput imageOutput : this.frameState.getImageOutputs()) {
                if (setBuild.contains(StreamId.m791boximpl(imageOutput.getStreamId()))) {
                    imageOutput.decrement();
                }
            }
            return null;
        }
        return new FrameImpl(this.frameState, setBuild);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        release();
    }

    private final boolean release() {
        if (!this.closed.compareAndSet(false, true)) {
            return false;
        }
        this.frameState.getFrameInfoOutput().decrement();
        int size = this.frameState.getImageOutputs().size();
        for (int i = 0; i < size; i++) {
            FrameState.ImageOutput imageOutput = this.frameState.getImageOutputs().get(i);
            if (getImageStreams().contains(StreamId.m791boximpl(imageOutput.getStreamId()))) {
                imageOutput.decrement();
            }
        }
        return true;
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public RequestMetadata getRequestMetadata() {
        return this.frameState.getRequestMetadata();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameId-OMxQvVY */
    public long mo539getFrameIdOMxQvVY() {
        return this.frameState.getFrameId();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo541getFrameNumberUgla2oM() {
        return this.frameState.getFrameNumber();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameTimestamp-LS1Wq50 */
    public long mo542getFrameTimestampLS1Wq50() {
        return this.frameState.getFrameTimestamp();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameInfoStatus-U7r42EA */
    public int mo540getFrameInfoStatusU7r42EA() {
        return this.closed.getValue() ? OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA() : this.frameState.getFrameInfoOutput().m1017getStatusU7r42EA();
    }

    protected final void finalize() {
        if (release() && Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Failed to close " + this + "! This indicates a memory leak and could cause the camera to stall, or images to be lost.");
        }
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public Object awaitFrameInfo(Continuation<? super FrameInfo> continuation) {
        if (this.closed.getValue()) {
            return null;
        }
        return this.frameState.getFrameInfoOutput().await(continuation);
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public FrameInfo getFrameInfo() {
        if (this.closed.getValue()) {
            return null;
        }
        return this.frameState.getFrameInfoOutput().outputOrNull();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008c  */
    /* JADX WARN: Code duplicated, block: B:31:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009a -> B:32:0x009d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImage-NYG5g8E */
    public java.lang.Object mo502awaitImageNYG5g8E(int r7, kotlin.coroutines.Continuation<? super androidx.camera.camera2.pipe.media.OutputImage> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.camera.camera2.pipe.internal.FrameImpl$awaitImage$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.camera.camera2.pipe.internal.FrameImpl$awaitImage$1 r0 = (androidx.camera.camera2.pipe.internal.FrameImpl$awaitImage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.camera.camera2.pipe.internal.FrameImpl$awaitImage$1 r0 = new androidx.camera.camera2.pipe.internal.FrameImpl$awaitImage$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$0
            java.util.Iterator r6 = (java.util.Iterator) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L9d
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.atomicfu.AtomicBoolean r8 = r6.closed
            boolean r8 = r8.getValue()
            if (r8 == 0) goto L43
            return r4
        L43:
            java.util.Set r8 = r6.getImageStreams()
            androidx.camera.camera2.pipe.StreamId r2 = androidx.camera.camera2.pipe.StreamId.m791boximpl(r7)
            boolean r8 = r8.contains(r2)
            if (r8 != 0) goto L52
            return r4
        L52:
            androidx.camera.camera2.pipe.internal.FrameState r6 = r6.frameState
            java.util.List r6 = r6.getImageOutputs()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L80
            java.lang.Object r2 = r6.next()
            r5 = r2
            androidx.camera.camera2.pipe.internal.FrameState$ImageOutput r5 = (androidx.camera.camera2.pipe.internal.FrameState.ImageOutput) r5
            int r5 = r5.getStreamId()
            boolean r5 = androidx.camera.camera2.pipe.StreamId.m794equalsimpl0(r5, r7)
            if (r5 == 0) goto L65
            r8.add(r2)
            goto L65
        L80:
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r6 = r8.iterator()
        L86:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto La2
            java.lang.Object r7 = r6.next()
            androidx.camera.camera2.pipe.internal.FrameState$ImageOutput r7 = (androidx.camera.camera2.pipe.internal.FrameState.ImageOutput) r7
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r7.await(r0)
            if (r8 != r1) goto L9d
            return r1
        L9d:
            androidx.camera.camera2.pipe.media.SharedOutputImage r8 = (androidx.camera.camera2.pipe.media.SharedOutputImage) r8
            if (r8 == 0) goto L86
            return r8
        La2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.FrameImpl.mo502awaitImageNYG5g8E(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImage-aKI5c8E */
    public OutputImage mo504getImageaKI5c8E(int streamId) {
        if (this.closed.getValue() || !getImageStreams().contains(StreamId.m791boximpl(streamId))) {
            return null;
        }
        List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageOutputs) {
            if (StreamId.m794equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SharedOutputImage sharedOutputImageOutputOrNull = ((FrameState.ImageOutput) it.next()).outputOrNull();
            if (sharedOutputImageOutputOrNull != null) {
                return sharedOutputImageOutputOrNull;
            }
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImage-A9nWXxg */
    public Object mo501awaitImageA9nWXxg(int i, Continuation<? super OutputImage> continuation) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m571boximpl(i))) {
            return null;
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!OutputId.m574equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), i));
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        if (imageOutput == null) {
            return null;
        }
        Object objAwait = imageOutput.await(continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : (SharedOutputImage) objAwait;
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImage-iYJqvbA */
    public OutputImage mo505getImageiYJqvbA(int outputId) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m571boximpl(outputId))) {
            return null;
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!OutputId.m574equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), outputId));
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        return imageOutput != null ? imageOutput.outputOrNull() : null;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b4 -> B:34:0x00b7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImages-NYG5g8E */
    public java.lang.Object mo503awaitImagesNYG5g8E(int r7, kotlin.coroutines.Continuation<? super java.util.List<? extends androidx.camera.camera2.pipe.media.OutputImage>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.camera.camera2.pipe.internal.FrameImpl$awaitImages$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.camera.camera2.pipe.internal.FrameImpl$awaitImages$1 r0 = (androidx.camera.camera2.pipe.internal.FrameImpl$awaitImages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.camera.camera2.pipe.internal.FrameImpl$awaitImages$1 r0 = new androidx.camera.camera2.pipe.internal.FrameImpl$awaitImages$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$0
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb7
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.atomicfu.AtomicBoolean r8 = r6.closed
            boolean r8 = r8.getValue()
            if (r8 == 0) goto L4b
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            return r6
        L4b:
            java.util.Set r8 = r6.getImageStreams()
            androidx.camera.camera2.pipe.StreamId r2 = androidx.camera.camera2.pipe.StreamId.m791boximpl(r7)
            boolean r8 = r8.contains(r2)
            if (r8 != 0) goto L5e
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            return r6
        L5e:
            androidx.camera.camera2.pipe.internal.FrameState r6 = r6.frameState
            java.util.List r6 = r6.getImageOutputs()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L71:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L8c
            java.lang.Object r2 = r6.next()
            r4 = r2
            androidx.camera.camera2.pipe.internal.FrameState$ImageOutput r4 = (androidx.camera.camera2.pipe.internal.FrameState.ImageOutput) r4
            int r4 = r4.getStreamId()
            boolean r4 = androidx.camera.camera2.pipe.StreamId.m794equalsimpl0(r4, r7)
            if (r4 == 0) goto L71
            r8.add(r2)
            goto L71
        L8c:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r7 = r8.iterator()
            r5 = r7
            r7 = r6
            r6 = r5
        L9e:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto Lbf
            java.lang.Object r8 = r6.next()
            androidx.camera.camera2.pipe.internal.FrameState$ImageOutput r8 = (androidx.camera.camera2.pipe.internal.FrameState.ImageOutput) r8
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r8.await(r0)
            if (r8 != r1) goto Lb7
            return r1
        Lb7:
            androidx.camera.camera2.pipe.media.SharedOutputImage r8 = (androidx.camera.camera2.pipe.media.SharedOutputImage) r8
            if (r8 == 0) goto L9e
            r7.add(r8)
            goto L9e
        Lbf:
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.FrameImpl.mo503awaitImagesNYG5g8E(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImages-aKI5c8E */
    public List<OutputImage> mo506getImagesaKI5c8E(int streamId) {
        if (!this.closed.getValue() && getImageStreams().contains(StreamId.m791boximpl(streamId))) {
            List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
            ArrayList arrayList = new ArrayList();
            for (Object obj : imageOutputs) {
                if (StreamId.m794equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SharedOutputImage sharedOutputImageOutputOrNull = ((FrameState.ImageOutput) it.next()).outputOrNull();
                if (sharedOutputImageOutputOrNull != null) {
                    arrayList2.add(sharedOutputImageOutputOrNull);
                }
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: imageStatus-Oo2lJfM */
    public int mo544imageStatusOo2lJfM(int streamId) {
        if (this.closed.getValue() || !getImageStreams().contains(StreamId.m791boximpl(streamId))) {
            return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
        }
        List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageOutputs) {
            if (StreamId.m794equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(OutputStatus.m578boximpl(((FrameState.ImageOutput) it.next()).m1017getStatusU7r42EA()));
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            throw new IllegalStateException(("No matching outputs found with " + ((Object) StreamId.m796toStringimpl(streamId)) + ". This is unexpected.").toString());
        }
        if (arrayList4.size() == 1) {
            return ((OutputStatus) arrayList4.get(0)).m584unboximpl();
        }
        ArrayList arrayList5 = arrayList4;
        boolean z = arrayList5 instanceof Collection;
        if (!z || !arrayList5.isEmpty()) {
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                if (OutputStatus.m581equalsimpl0(((OutputStatus) it2.next()).m584unboximpl(), OutputStatus.INSTANCE.m590getPENDINGU7r42EA())) {
                    return OutputStatus.INSTANCE.m590getPENDINGU7r42EA();
                }
            }
        }
        if (!z || !arrayList5.isEmpty()) {
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                if (OutputStatus.m581equalsimpl0(((OutputStatus) it3.next()).m584unboximpl(), OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA())) {
                    return OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA();
                }
            }
        }
        if (!z || !arrayList5.isEmpty()) {
            Iterator it4 = arrayList5.iterator();
            while (it4.hasNext()) {
                if (!OutputStatus.m581equalsimpl0(((OutputStatus) it4.next()).m584unboximpl(), ((OutputStatus) CollectionsKt.first((List) arrayList4)).m584unboximpl())) {
                    return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
                }
            }
        }
        return ((OutputStatus) CollectionsKt.first((List) arrayList4)).m584unboximpl();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: imageStatus-BWjvHWQ */
    public int mo543imageStatusBWjvHWQ(int outputId) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m571boximpl(outputId))) {
            return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!OutputId.m574equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), outputId));
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        return imageOutput != null ? imageOutput.m1017getStatusU7r42EA() : OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public void addListener(Frame.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.closed.getValue()) {
            throw new IllegalStateException(("Cannot add Frame.Listener, " + this + " is closed!").toString());
        }
        this.frameState.addListener(listener);
    }

    public String toString() {
        return this.frameState.toString();
    }
}
