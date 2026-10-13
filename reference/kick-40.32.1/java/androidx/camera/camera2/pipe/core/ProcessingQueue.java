package androidx.camera.camera2.pipe.core;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: ProcessingQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001%BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\bH\u0082@¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "capacity", "", "onUnprocessedElements", "Lkotlin/Function1;", "", "", "process", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getCapacity", "()I", "Lkotlin/jvm/functions/Function2;", "started", "Lkotlinx/atomicfu/AtomicBoolean;", "channel", "Lkotlinx/coroutines/channels/Channel;", "queue", "Lkotlin/collections/ArrayDeque;", "emit", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitChecked", "(Ljava/lang/Object;)V", "tryEmit", "", "(Ljava/lang/Object;)Z", "processingLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseUnprocessedElements", "cause", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessingQueue<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int capacity;
    private final Channel<T> channel;
    private final Function1<List<? extends T>, Unit> onUnprocessedElements;
    private final Function2<List<T>, Continuation<? super Unit>, Object> process;
    private final ArrayDeque<T> queue;
    private final AtomicBoolean started;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProcessingQueue.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.ProcessingQueue", f = "ProcessingQueue.kt", i = {1}, l = {102, 117}, m = "processingLoop", n = {ContentDisposition.Parameters.Size}, s = {"I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProcessingQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProcessingQueue<T> processingQueue, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = processingQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.processingLoop(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProcessingQueue(int i, Function1<? super List<? extends T>, Unit> onUnprocessedElements, Function2<? super List<T>, ? super Continuation<? super Unit>, ? extends Object> process) {
        Intrinsics.checkNotNullParameter(onUnprocessedElements, "onUnprocessedElements");
        Intrinsics.checkNotNullParameter(process, "process");
        this.capacity = i;
        this.onUnprocessedElements = onUnprocessedElements;
        this.process = process;
        this.started = AtomicFU.atomic(false);
        this.channel = ChannelKt.Channel$default(i, null, new Function1() { // from class: androidx.camera.camera2.pipe.core.ProcessingQueue$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProcessingQueue.channel$lambda$0(this.f$0, obj);
            }
        }, 2, null);
        this.queue = new ArrayDeque<>();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public /* synthetic */ ProcessingQueue(int i, Function1 function1, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? new Function1() { // from class: androidx.camera.camera2.pipe.core.ProcessingQueue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProcessingQueue._init_$lambda$0((List) obj);
            }
        } : function1, function2);
    }

    static final Unit _init_$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit channel$lambda$0(ProcessingQueue processingQueue, Object obj) {
        processingQueue.queue.add(obj);
        return Unit.INSTANCE;
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Object objSend = this.channel.send(t, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }

    public final void emitChecked(T element) {
        Object obj = this.channel.mo12563trySendJP2dKIU(element);
        if (ChannelResult.m14245isSuccessimpl(obj)) {
            return;
        }
        throw new IllegalStateException(("Failed to emit item to ProcessingQueue!: " + ((Object) ChannelResult.m14246toStringimpl(obj))).toString());
    }

    public final boolean tryEmit(T element) {
        return ChannelResult.m14245isSuccessimpl(this.channel.mo12563trySendJP2dKIU(element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0068 A[Catch: all -> 0x003b, LOOP:0: B:29:0x0060->B:32:0x0068, LOOP_END, TRY_ENTER, TryCatch #0 {all -> 0x003b, blocks: (B:13:0x002b, B:36:0x0089, B:26:0x0050, B:28:0x005a, B:29:0x0060, B:32:0x0068, B:33:0x0076, B:22:0x0040, B:25:0x004b, B:17:0x0037), top: B:41:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0076 A[EDGE_INSN: B:44:0x0076->B:33:0x0076 BREAK  A[LOOP:0: B:29:0x0060->B:32:0x0068], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:36:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:29:0x0060
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object processingLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.core.ProcessingQueue.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1 r0 = (androidx.camera.camera2.pipe.core.ProcessingQueue.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1 r0 = new androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            int r2 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3b
            goto L89
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3b
            goto L4b
        L3b:
            r7 = move-exception
            goto L92
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
        L40:
            kotlinx.coroutines.channels.Channel<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L3b
            r0.label = r4     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r7 = r7.receive(r0)     // Catch: java.lang.Throwable -> L3b
            if (r7 != r1) goto L4b
            goto L88
        L4b:
            kotlin.collections.ArrayDeque<T> r2 = r6.queue     // Catch: java.lang.Throwable -> L3b
            r2.add(r7)     // Catch: java.lang.Throwable -> L3b
        L50:
            kotlin.collections.ArrayDeque<T> r7 = r6.queue     // Catch: java.lang.Throwable -> L3b
            java.util.Collection r7 = (java.util.Collection) r7     // Catch: java.lang.Throwable -> L3b
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r7 != 0) goto L40
            kotlinx.coroutines.channels.Channel<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r7 = r7.mo12664tryReceivePtdJZtk()     // Catch: java.lang.Throwable -> L3b
        L60:
            boolean r2 = kotlinx.coroutines.channels.ChannelResult.m14245isSuccessimpl(r7)     // Catch: java.lang.Throwable -> L3b
            kotlin.collections.ArrayDeque<T> r5 = r6.queue
            if (r2 == 0) goto L76
            java.lang.Object r7 = kotlinx.coroutines.channels.ChannelResult.m14241getOrThrowimpl(r7)     // Catch: java.lang.Throwable -> L3b
            r5.add(r7)     // Catch: java.lang.Throwable -> L3b
            kotlinx.coroutines.channels.Channel<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r7 = r7.mo12664tryReceivePtdJZtk()     // Catch: java.lang.Throwable -> L3b
            goto L60
        L76:
            int r2 = r5.size()     // Catch: java.lang.Throwable -> L3b
            kotlin.jvm.functions.Function2<java.util.List<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r6.process     // Catch: java.lang.Throwable -> L3b
            kotlin.collections.ArrayDeque<T> r5 = r6.queue     // Catch: java.lang.Throwable -> L3b
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L3b
            r0.label = r3     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L3b
            if (r7 != r1) goto L89
        L88:
            return r1
        L89:
            kotlin.collections.ArrayDeque<T> r7 = r6.queue     // Catch: java.lang.Throwable -> L3b
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L3b
            if (r2 != r7) goto L50
            goto L40
        L92:
            r6.releaseUnprocessedElements(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.core.ProcessingQueue.processingLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseUnprocessedElements(Throwable cause) {
        ArrayDeque<T> arrayDeque;
        if (this.channel.close(cause)) {
            Object obj = this.channel.mo12664tryReceivePtdJZtk();
            while (true) {
                boolean zM14245isSuccessimpl = ChannelResult.m14245isSuccessimpl(obj);
                arrayDeque = this.queue;
                if (!zM14245isSuccessimpl) {
                    break;
                }
                arrayDeque.add((T) ChannelResult.m14241getOrThrowimpl(obj));
                obj = this.channel.mo12664tryReceivePtdJZtk();
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            this.onUnprocessedElements.invoke(CollectionsKt.toMutableList((Collection) this.queue));
            this.queue.clear();
        }
    }

    /* JADX INFO: compiled from: ProcessingQueue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue$Companion;", "", "<init>", "()V", "processIn", "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> ProcessingQueue<T> processIn(ProcessingQueue<T> processingQueue, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(processingQueue, "<this>");
            Intrinsics.checkNotNullParameter(scope, "scope");
            if (!((ProcessingQueue) processingQueue).started.compareAndSet(false, true)) {
                throw new IllegalStateException("ProcessingQueue cannot be re-started!".toString());
            }
            if (BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ProcessingQueue$Companion$processIn$job$1(processingQueue, null), 3, null).isCancelled()) {
                processingQueue.releaseUnprocessedElements(null);
            }
            return processingQueue;
        }
    }
}
