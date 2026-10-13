package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameCapture;
import androidx.camera.camera2.pipe.FrameReference;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: FrameCaptureQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\f\u001a\b\u0018\u00010\tR\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00060\tR\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tR\u00020\u00000\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "lock", "", "queue", "Lkotlin/collections/ArrayDeque;", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue$FrameCaptureImpl;", "closed", "", "remove", "request", "Landroidx/camera/camera2/pipe/Request;", "enqueue", "", "Landroidx/camera/camera2/pipe/FrameCapture;", "requests", "close", "", "FrameCaptureImpl", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameCaptureQueue implements AutoCloseable {
    private boolean closed;
    private final Object lock = new Object();
    private final ArrayDeque<FrameCaptureImpl> queue = new ArrayDeque<>();

    @Inject
    public FrameCaptureQueue() {
    }

    public final FrameCaptureImpl remove(Request request) {
        FrameCaptureImpl next;
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (this.lock) {
            FrameCaptureImpl frameCaptureImpl = null;
            if (this.closed) {
                return null;
            }
            Iterator<FrameCaptureImpl> it = this.queue.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getRequest(), request));
            FrameCaptureImpl frameCaptureImpl2 = next;
            if (frameCaptureImpl2 != null) {
                this.queue.remove(frameCaptureImpl2);
                frameCaptureImpl = frameCaptureImpl2;
            }
            return frameCaptureImpl;
        }
    }

    public final FrameCaptureImpl enqueue(Request request) {
        FrameCaptureImpl frameCaptureImpl;
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (this.lock) {
            frameCaptureImpl = new FrameCaptureImpl(this, request);
            if (!this.closed) {
                this.queue.add(frameCaptureImpl);
            } else {
                frameCaptureImpl.close();
            }
        }
        return frameCaptureImpl;
    }

    public final List<FrameCapture> enqueue(List<Request> requests) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(requests, "requests");
        synchronized (this.lock) {
            List<Request> list = requests;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new FrameCaptureImpl(this, (Request) it.next()));
            }
            arrayList = arrayList2;
            if (!this.closed) {
                this.queue.addAll(arrayList);
            } else {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((FrameCaptureImpl) it2.next()).close();
                }
            }
        }
        return arrayList;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Unit unit = Unit.INSTANCE;
            Iterator it = this.queue.iterator();
            while (it.hasNext()) {
                ((FrameCaptureImpl) it.next()).m1004completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m586getERROR_OUTPUT_ABORTEDU7r42EA());
            }
            this.queue.clear();
        }
    }

    /* JADX INFO: compiled from: FrameCaptureQueue.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u0015\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue$FrameCaptureImpl;", "Landroidx/camera/camera2/pipe/FrameCapture;", "request", "Landroidx/camera/camera2/pipe/Request;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;Landroidx/camera/camera2/pipe/Request;)V", "getRequest", "()Landroidx/camera/camera2/pipe/Request;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "result", "Lkotlinx/coroutines/CompletableDeferred;", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "Landroidx/camera/camera2/pipe/Frame;", "frameListeners", "", "Landroidx/camera/camera2/pipe/Frame$Listener;", "completeWith", "", TypedValues.Attributes.S_FRAME, "completeWithFailure", "failureStatus", "Landroidx/camera/camera2/pipe/OutputStatus;", "completeWithFailure-tXNfJfc", "(I)V", "getFrame", "status", "getStatus-U7r42EA", "()I", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "close", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FrameCaptureImpl implements FrameCapture {
        private final AtomicBoolean closed;
        private List<Frame.Listener> frameListeners;
        private final Request request;
        private final CompletableDeferred<OutputResult<Frame>> result;
        final /* synthetic */ FrameCaptureQueue this$0;

        public FrameCaptureImpl(FrameCaptureQueue frameCaptureQueue, Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.this$0 = frameCaptureQueue;
            this.request = request;
            this.closed = AtomicFU.atomic(false);
            this.result = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.frameListeners = new ArrayList();
        }

        @Override // androidx.camera.camera2.pipe.FrameCapture
        public Request getRequest() {
            return this.request;
        }

        public final void completeWith(Frame frame) throws Exception {
            List<Frame.Listener> list;
            Intrinsics.checkNotNullParameter(frame, "frame");
            OutputResult.Companion companion = OutputResult.INSTANCE;
            if (!this.result.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(frame)))) {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) frame);
                return;
            }
            synchronized (this) {
                list = this.frameListeners;
                this.frameListeners = null;
                Unit unit = Unit.INSTANCE;
            }
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    frame.addListener(list.get(i));
                }
            }
        }

        /* JADX INFO: renamed from: completeWithFailure-tXNfJfc, reason: not valid java name */
        public final void m1004completeWithFailuretXNfJfc(int failureStatus) {
            List<Frame.Listener> list;
            OutputResult.Companion companion = OutputResult.INSTANCE;
            if (this.result.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(failureStatus))))) {
                synchronized (this) {
                    list = this.frameListeners;
                    this.frameListeners = null;
                    Unit unit = Unit.INSTANCE;
                }
                if (list != null) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).onFrameComplete();
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x002d  */
        @Override // androidx.camera.camera2.pipe.FrameCapture
        public Frame getFrame() {
            Object result;
            if (this.closed.getValue()) {
                return null;
            }
            OutputResult.Companion companion = OutputResult.INSTANCE;
            CompletableDeferred<OutputResult<Frame>> completableDeferred = this.result;
            if (!completableDeferred.isCompleted() || completableDeferred.isCancelled()) {
                result = null;
            } else {
                result = completableDeferred.getCompleted().getResult();
                if (!OutputResult.m1041getAvailableimpl(result)) {
                    result = null;
                }
            }
            Frame frame = (Frame) result;
            if (frame != null) {
                return FrameReference.tryAcquire$default(frame, null, 1, null);
            }
            return null;
        }

        @Override // androidx.camera.camera2.pipe.FrameCapture
        /* JADX INFO: renamed from: getStatus-U7r42EA */
        public int mo518getStatusU7r42EA() {
            if (this.closed.getValue()) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            OutputResult.Companion companion = OutputResult.INSTANCE;
            CompletableDeferred<OutputResult<Frame>> completableDeferred = this.result;
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

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.camera.camera2.pipe.FrameCapture
        public Object awaitFrame(Continuation<? super Frame> continuation) {
            FrameCaptureQueue$FrameCaptureImpl$awaitFrame$1 frameCaptureQueue$FrameCaptureImpl$awaitFrame$1;
            if (continuation instanceof FrameCaptureQueue$FrameCaptureImpl$awaitFrame$1) {
                frameCaptureQueue$FrameCaptureImpl$awaitFrame$1 = (FrameCaptureQueue$FrameCaptureImpl$awaitFrame$1) continuation;
                if ((frameCaptureQueue$FrameCaptureImpl$awaitFrame$1.label & Integer.MIN_VALUE) != 0) {
                    frameCaptureQueue$FrameCaptureImpl$awaitFrame$1.label -= Integer.MIN_VALUE;
                } else {
                    frameCaptureQueue$FrameCaptureImpl$awaitFrame$1 = new FrameCaptureQueue$FrameCaptureImpl$awaitFrame$1(this, continuation);
                }
            } else {
                frameCaptureQueue$FrameCaptureImpl$awaitFrame$1 = new FrameCaptureQueue$FrameCaptureImpl$awaitFrame$1(this, continuation);
            }
            Object objAwait = frameCaptureQueue$FrameCaptureImpl$awaitFrame$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameCaptureQueue$FrameCaptureImpl$awaitFrame$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objAwait);
                if (this.closed.getValue()) {
                    return null;
                }
                CompletableDeferred<OutputResult<Frame>> completableDeferred = this.result;
                frameCaptureQueue$FrameCaptureImpl$awaitFrame$1.label = 1;
                objAwait = completableDeferred.await(frameCaptureQueue$FrameCaptureImpl$awaitFrame$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            Object result = ((OutputResult) objAwait).getResult();
            if (!OutputResult.m1041getAvailableimpl(result)) {
                result = null;
            }
            Frame frame = (Frame) result;
            if (frame != null) {
                return FrameReference.tryAcquire$default(frame, null, 1, null);
            }
            return null;
        }

        @Override // androidx.camera.camera2.pipe.FrameCapture
        public void addListener(Frame.Listener listener) {
            boolean z;
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (this) {
                List<Frame.Listener> list = this.frameListeners;
                z = false;
                if (list != null && list.add(listener)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            OutputResult.Companion companion = OutputResult.INSTANCE;
            CompletableDeferred<OutputResult<Frame>> completableDeferred = this.result;
            Object obj = null;
            if (completableDeferred.isCompleted() && !completableDeferred.isCancelled()) {
                Object result = completableDeferred.getCompleted().getResult();
                if (OutputResult.m1041getAvailableimpl(result)) {
                    obj = result;
                }
            }
            Frame frame = (Frame) obj;
            if (frame != null) {
                frame.addListener(listener);
            } else {
                listener.onFrameComplete();
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() throws Exception {
            if (this.closed.compareAndSet(false, true)) {
                m1004completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA());
                OutputResult.Companion companion = OutputResult.INSTANCE;
                CompletableDeferred<OutputResult<Frame>> completableDeferred = this.result;
                Object obj = null;
                if (completableDeferred.isCompleted() && !completableDeferred.isCancelled()) {
                    Object result = completableDeferred.getCompleted().getResult();
                    if (OutputResult.m1041getAvailableimpl(result)) {
                        obj = result;
                    }
                }
                Frame frame = (Frame) obj;
                if (frame != null) {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) frame);
                }
                Object obj2 = this.this$0.lock;
                FrameCaptureQueue frameCaptureQueue = this.this$0;
                synchronized (obj2) {
                    frameCaptureQueue.queue.remove(this);
                }
            }
        }
    }
}
