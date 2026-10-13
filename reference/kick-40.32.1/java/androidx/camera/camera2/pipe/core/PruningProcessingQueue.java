package androidx.camera.camera2.pipe.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: PruningProcessingQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000 '*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001'Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\b0\u0006\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "capacity", "", "prune", "Lkotlin/Function1;", "", "", "onUnprocessedElements", "", "process", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getCapacity", "()I", "Lkotlin/jvm/functions/Function2;", "started", "Lkotlinx/atomicfu/AtomicBoolean;", "channel", "Lkotlinx/coroutines/channels/Channel;", "queue", "Lkotlin/collections/ArrayDeque;", "emit", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitChecked", "(Ljava/lang/Object;)V", "tryEmit", "", "(Ljava/lang/Object;)Z", "processingLoop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeAndReleaseUnprocessedElements", "cause", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PruningProcessingQueue<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int capacity;
    private final Channel<T> channel;
    private final Function1<List<? extends T>, Unit> onUnprocessedElements;
    private final Function2<T, Continuation<? super Unit>, Object> process;
    private final Function1<List<T>, Unit> prune;
    private final ArrayDeque<T> queue;
    private final AtomicBoolean started;

    /* JADX WARN: Multi-variable type inference failed */
    public PruningProcessingQueue(int i, Function1<? super List<T>, Unit> prune, Function1<? super List<? extends T>, Unit> onUnprocessedElements, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> process) {
        Intrinsics.checkNotNullParameter(prune, "prune");
        Intrinsics.checkNotNullParameter(onUnprocessedElements, "onUnprocessedElements");
        Intrinsics.checkNotNullParameter(process, "process");
        this.capacity = i;
        this.prune = prune;
        this.onUnprocessedElements = onUnprocessedElements;
        this.process = process;
        this.started = AtomicFU.atomic(false);
        this.channel = ChannelKt.Channel$default(i, null, new Function1() { // from class: androidx.camera.camera2.pipe.core.PruningProcessingQueue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PruningProcessingQueue.channel$lambda$0(this.f$0, obj);
            }
        }, 2, null);
        this.queue = new ArrayDeque<>();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public /* synthetic */ PruningProcessingQueue(int i, Function1 function1, Function1 function2, Function2 function3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? new Function1() { // from class: androidx.camera.camera2.pipe.core.PruningProcessingQueue$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PruningProcessingQueue._init_$lambda$0((List) obj);
            }
        } : function1, (i2 & 4) != 0 ? new Function1() { // from class: androidx.camera.camera2.pipe.core.PruningProcessingQueue$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PruningProcessingQueue._init_$lambda$1((List) obj);
            }
        } : function2, function3);
    }

    static final Unit _init_$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit channel$lambda$0(PruningProcessingQueue pruningProcessingQueue, Object obj) {
        pruningProcessingQueue.queue.add(obj);
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

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2, reason: invalid class name */
    /* JADX INFO: compiled from: PruningProcessingQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2", f = "PruningProcessingQueue.kt", i = {0, 0}, l = {JfifUtil.MARKER_SOS}, m = "invokeSuspend", n = {"$this$supervisorScope", "processDeferred"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PruningProcessingQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PruningProcessingQueue<T> pruningProcessingQueue, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = pruningProcessingQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0064 A[Catch: all -> 0x001b, CancellationException -> 0x00ec, TryCatch #1 {CancellationException -> 0x00ec, blocks: (B:16:0x003e, B:18:0x0064, B:19:0x0072), top: B:46:0x003e }] */
        /* JADX WARN: Code duplicated, block: B:21:0x007e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x008b  */
        /* JADX WARN: Code duplicated, block: B:46:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r6v14, types: [T, kotlinx.coroutines.Deferred] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007c -> B:22:0x007f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.core.PruningProcessingQueue.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processingLoop(Continuation continuation) {
        return SupervisorKt.supervisorScope(new AnonymousClass2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeAndReleaseUnprocessedElements(Throwable cause) {
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

    /* JADX INFO: compiled from: PruningProcessingQueue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/core/PruningProcessingQueue$Companion;", "", "<init>", "()V", "processIn", "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> PruningProcessingQueue<T> processIn(PruningProcessingQueue<T> pruningProcessingQueue, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(pruningProcessingQueue, "<this>");
            Intrinsics.checkNotNullParameter(scope, "scope");
            if (!((PruningProcessingQueue) pruningProcessingQueue).started.compareAndSet(false, true)) {
                throw new IllegalStateException("PruningProcessingQueue cannot be re-started!".toString());
            }
            if (BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PruningProcessingQueue$Companion$processIn$job$1(pruningProcessingQueue, null), 3, null).isCancelled()) {
                pruningProcessingQueue.closeAndReleaseUnprocessedElements(null);
            }
            return pruningProcessingQueue;
        }
    }
}
