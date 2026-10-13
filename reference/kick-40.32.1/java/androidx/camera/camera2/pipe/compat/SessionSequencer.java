package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: ConcurrentSessionSequencers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/compat/SessionSequencer;", "", "concurrentSequencer", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;)V", "state", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/compat/SessionSequencer$State;", "awaitSessionLock", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "State", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionSequencer {
    private final ConcurrentSessionSequencer concurrentSequencer;
    private final AtomicRef<State> state;

    /* JADX INFO: compiled from: ConcurrentSessionSequencers.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/compat/SessionSequencer$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "CREATING", DebugCoroutineInfoImplKt.CREATED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum State {
        PENDING,
        CREATING,
        CREATED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConcurrentSessionSequencers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.SessionSequencer", f = "ConcurrentSessionSequencers.kt", i = {}, l = {98}, m = "awaitSessionLock", n = {}, s = {}, v = 1)
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
            return SessionSequencer.this.awaitSessionLock(this);
        }
    }

    public SessionSequencer(ConcurrentSessionSequencer concurrentSequencer) {
        Intrinsics.checkNotNullParameter(concurrentSequencer, "concurrentSequencer");
        this.concurrentSequencer = concurrentSequencer;
        this.state = AtomicFU.atomic(State.PENDING);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitSessionLock(Continuation<? super Unit> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex sharedMutex = this.concurrentSequencer.getSharedMutex();
            anonymousClass1.label = 1;
            if (Mutex.DefaultImpls.lock$default(sharedMutex, null, anonymousClass1, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!this.state.compareAndSet(State.PENDING, State.CREATING)) {
            Mutex.DefaultImpls.unlock$default(this.concurrentSequencer.getSharedMutex(), null, 1, null);
        }
        return Unit.INSTANCE;
    }

    public final void release() {
        if (this.state.getAndSet(State.CREATED) == State.CREATING) {
            Mutex.DefaultImpls.unlock$default(this.concurrentSequencer.getSharedMutex(), null, 1, null);
        }
    }
}
