package expo.modules.updates.procedures;

import androidx.compose.foundation.style.ResolvedStyleKt;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.logging.IUpdatesLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: StateMachineSerialExecutorQueue.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineSerialExecutorQueue;", "", "updatesLogger", "Lexpo/modules/updates/logging/IUpdatesLogger;", "stateMachineProcedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lexpo/modules/updates/logging/IUpdatesLogger;Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;Lkotlinx/coroutines/CoroutineScope;)V", "procedureChannel", "Lkotlinx/coroutines/channels/Channel;", "Lexpo/modules/updates/procedures/StateMachineSerialExecutorQueue$ProcedureHolder;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "executorJob", "Lkotlinx/coroutines/Job;", "executeProcedure", "", "holder", "(Lexpo/modules/updates/procedures/StateMachineSerialExecutorQueue$ProcedureHolder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queueExecution", "stateMachineProcedure", "Lexpo/modules/updates/procedures/StateMachineProcedure;", "ProcedureHolder", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StateMachineSerialExecutorQueue {
    private final Job executorJob;
    private final Mutex mutex;
    private final Channel<ProcedureHolder> procedureChannel;
    private final CoroutineScope scope;
    private final StateMachineProcedure.StateMachineProcedureContext stateMachineProcedureContext;
    private final IUpdatesLogger updatesLogger;

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StateMachineSerialExecutorQueue.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.StateMachineSerialExecutorQueue", f = "StateMachineSerialExecutorQueue.kt", i = {0, 0, 1, 1}, l = {43, EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m = "executeProcedure", n = {"holder", "loggerTimer", "holder", "loggerTimer"}, nl = {EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY, 75}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C09421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09421(Continuation<? super C09421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StateMachineSerialExecutorQueue.this.executeProcedure(null, this);
        }
    }

    public StateMachineSerialExecutorQueue(IUpdatesLogger updatesLogger, StateMachineProcedure.StateMachineProcedureContext stateMachineProcedureContext, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(updatesLogger, "updatesLogger");
        Intrinsics.checkNotNullParameter(stateMachineProcedureContext, "stateMachineProcedureContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.updatesLogger = updatesLogger;
        this.stateMachineProcedureContext = stateMachineProcedureContext;
        this.scope = scope;
        this.procedureChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.executorJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ StateMachineSerialExecutorQueue(IUpdatesLogger iUpdatesLogger, StateMachineProcedure.StateMachineProcedureContext stateMachineProcedureContext, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iUpdatesLogger, stateMachineProcedureContext, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    /* JADX INFO: compiled from: StateMachineSerialExecutorQueue.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineSerialExecutorQueue$ProcedureHolder;", "", "procedure", "Lexpo/modules/updates/procedures/StateMachineProcedure;", "onComplete", "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(Lexpo/modules/updates/procedures/StateMachineProcedure;Lkotlinx/coroutines/CompletableDeferred;)V", "getProcedure", "()Lexpo/modules/updates/procedures/StateMachineProcedure;", "getOnComplete", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class ProcedureHolder {
        private final CompletableDeferred<Unit> onComplete;
        private final StateMachineProcedure procedure;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProcedureHolder copy$default(ProcedureHolder procedureHolder, StateMachineProcedure stateMachineProcedure, CompletableDeferred completableDeferred, int i, Object obj) {
            if ((i & 1) != 0) {
                stateMachineProcedure = procedureHolder.procedure;
            }
            if ((i & 2) != 0) {
                completableDeferred = procedureHolder.onComplete;
            }
            return procedureHolder.copy(stateMachineProcedure, completableDeferred);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StateMachineProcedure getProcedure() {
            return this.procedure;
        }

        public final CompletableDeferred<Unit> component2() {
            return this.onComplete;
        }

        public final ProcedureHolder copy(StateMachineProcedure procedure, CompletableDeferred<Unit> onComplete) {
            Intrinsics.checkNotNullParameter(procedure, "procedure");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            return new ProcedureHolder(procedure, onComplete);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcedureHolder)) {
                return false;
            }
            ProcedureHolder procedureHolder = (ProcedureHolder) other;
            return Intrinsics.areEqual(this.procedure, procedureHolder.procedure) && Intrinsics.areEqual(this.onComplete, procedureHolder.onComplete);
        }

        public int hashCode() {
            return (this.procedure.hashCode() * 31) + this.onComplete.hashCode();
        }

        public String toString() {
            return "ProcedureHolder(procedure=" + this.procedure + ", onComplete=" + this.onComplete + ")";
        }

        public ProcedureHolder(StateMachineProcedure procedure, CompletableDeferred<Unit> onComplete) {
            Intrinsics.checkNotNullParameter(procedure, "procedure");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.procedure = procedure;
            this.onComplete = onComplete;
        }

        public final StateMachineProcedure getProcedure() {
            return this.procedure;
        }

        public final CompletableDeferred<Unit> getOnComplete() {
            return this.onComplete;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: StateMachineSerialExecutorQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.StateMachineSerialExecutorQueue$1", f = "StateMachineSerialExecutorQueue.kt", i = {1}, l = {35, 36}, m = "invokeSuspend", n = {"holder"}, nl = {36, 38}, s = {"L$1"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StateMachineSerialExecutorQueue.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0049  */
        /* JADX WARN: Code duplicated, block: B:18:0x0054  */
        /* JADX WARN: Code duplicated, block: B:21:0x0070  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        
            if (r8.this$0.executeProcedure(r9, r8) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:7:0x0019). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r8.L$1
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r1 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r1
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r9)
            L19:
                r9 = r1
                goto L38
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L23:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4c
            L2b:
                kotlin.ResultKt.throwOnFailure(r9)
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue r9 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.this
                kotlinx.coroutines.channels.Channel r9 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.access$getProcedureChannel$p(r9)
                kotlinx.coroutines.channels.ChannelIterator r9 = r9.iterator()
            L38:
                r1 = r8
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r8.L$0 = r9
                r4 = 0
                r8.L$1 = r4
                r8.label = r3
                java.lang.Object r1 = r9.hasNext(r1)
                if (r1 != r0) goto L49
                goto L6f
            L49:
                r7 = r1
                r1 = r9
                r9 = r7
            L4c:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L70
                java.lang.Object r9 = r1.next()
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r9 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r9
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue r4 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.this
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r8.L$0 = r1
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$1 = r6
                r8.label = r2
                java.lang.Object r9 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.access$executeProcedure(r4, r9, r5)
                if (r9 != r0) goto L19
            L6f:
                return r0
            L70:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.procedures.StateMachineSerialExecutorQueue.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
    
        if (r8.await(r0) == r1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeProcedure(final expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof expo.modules.updates.procedures.StateMachineSerialExecutorQueue.C09421
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1 r0 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.C09421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1 r0 = new expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            expo.modules.core.logging.LoggerTimer r6 = (expo.modules.core.logging.LoggerTimer) r6
            java.lang.Object r6 = r0.L$0
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r6 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L90
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$1
            expo.modules.core.logging.LoggerTimer r6 = (expo.modules.core.logging.LoggerTimer) r6
            java.lang.Object r7 = r0.L$0
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r7 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L49:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.updates.logging.IUpdatesLogger r8 = r6.updatesLogger
            expo.modules.updates.procedures.StateMachineProcedure r2 = r7.getProcedure()
            java.lang.String r2 = r2.getLoggerTimerLabel()
            expo.modules.core.logging.LoggerTimer r8 = r8.startTimer(r2)
            expo.modules.updates.procedures.StateMachineProcedure r2 = r7.getProcedure()
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$2 r5 = new expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$2
            r5.<init>()
            expo.modules.updates.procedures.StateMachineProcedure$ProcedureContext r5 = (expo.modules.updates.procedures.StateMachineProcedure.ProcedureContext) r5
            r0.L$0 = r7
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r6 = r2.run(r5, r0)
            if (r6 != r1) goto L76
            goto L8f
        L76:
            r6 = r8
        L77:
            kotlinx.coroutines.CompletableDeferred r8 = r7.getOnComplete()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r8.await(r0)
            if (r6 != r1) goto L90
        L8f:
            return r1
        L90:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.procedures.StateMachineSerialExecutorQueue.executeProcedure(expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$queueExecution$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StateMachineSerialExecutorQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.StateMachineSerialExecutorQueue$queueExecution$1", f = "StateMachineSerialExecutorQueue.kt", i = {0, 0, 1, 1, 1, 1}, l = {95, 84}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "completableDeferred", "$i$f$withLock", "$i$a$-withLock$default-StateMachineSerialExecutorQueue$queueExecution$1$1"}, nl = {ResolvedStyleKt.InheritedFlags, JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C09431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StateMachineProcedure $stateMachineProcedure;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09431(StateMachineProcedure stateMachineProcedure, Continuation<? super C09431> continuation) {
            super(2, continuation);
            this.$stateMachineProcedure = stateMachineProcedure;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StateMachineSerialExecutorQueue.this.new C09431(this.$stateMachineProcedure, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            StateMachineSerialExecutorQueue stateMachineSerialExecutorQueue;
            StateMachineProcedure stateMachineProcedure;
            int i;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = StateMachineSerialExecutorQueue.this.mutex;
                    stateMachineSerialExecutorQueue = StateMachineSerialExecutorQueue.this;
                    stateMachineProcedure = this.$stateMachineProcedure;
                    this.L$0 = mutex;
                    this.L$1 = stateMachineSerialExecutorQueue;
                    this.L$2 = stateMachineProcedure;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                stateMachineProcedure = (StateMachineProcedure) this.L$2;
                stateMachineSerialExecutorQueue = (StateMachineSerialExecutorQueue) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                Channel channel = stateMachineSerialExecutorQueue.procedureChannel;
                ProcedureHolder procedureHolder = new ProcedureHolder(stateMachineProcedure, completableDeferredCompletableDeferred$default);
                this.L$0 = mutex;
                this.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (channel.send(procedureHolder, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public final void queueExecution(StateMachineProcedure stateMachineProcedure) {
        Intrinsics.checkNotNullParameter(stateMachineProcedure, "stateMachineProcedure");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09431(stateMachineProcedure, null), 3, null);
    }
}
