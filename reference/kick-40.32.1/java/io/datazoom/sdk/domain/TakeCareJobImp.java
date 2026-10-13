package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: TakeCareJob.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/domain/TakeCareJobImp;", "Lio/datazoom/sdk/domain/TakeCareJob;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "_timerTick", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/datazoom/sdk/domain/TimerState;", "timerTick", "Lkotlinx/coroutines/flow/SharedFlow;", "getTimerTick", "()Lkotlinx/coroutines/flow/SharedFlow;", "timerJob", "Lkotlinx/coroutines/Job;", ViewProps.START, "", "intervalMs", "", "stop", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TakeCareJobImp implements TakeCareJob {
    private final MutableSharedFlow<TimerState> _timerTick;
    private final CoroutineScope scope;
    private volatile Job timerJob;
    private final SharedFlow<TimerState> timerTick;

    public TakeCareJobImp(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        MutableSharedFlow<TimerState> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._timerTick = mutableSharedFlowMutableSharedFlow$default;
        this.timerTick = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Override // io.datazoom.sdk.domain.TakeCareJob
    public SharedFlow<TimerState> getTimerTick() {
        return this.timerTick;
    }

    @Override // io.datazoom.sdk.domain.TakeCareJob
    public void start(long intervalMs) {
        Job job = this.timerJob;
        if (job == null || !job.isActive()) {
            this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(intervalMs, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.TakeCareJobImp$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: TakeCareJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.TakeCareJobImp$start$1", f = "TakeCareJob.kt", i = {}, l = {44, 46, 47}, m = "invokeSuspend", n = {}, nl = {45, 47, -1}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $intervalMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$intervalMs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TakeCareJobImp.this.new AnonymousClass1(this.$intervalMs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0042  */
        /* JADX WARN: Code duplicated, block: B:18:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006a -> B:15:0x0042). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1e
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1a:
                kotlin.ResultKt.throwOnFailure(r12)
                goto L50
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                goto L42
            L22:
                kotlin.ResultKt.throwOnFailure(r12)
                io.datazoom.sdk.domain.TakeCareJobImp r12 = io.datazoom.sdk.domain.TakeCareJobImp.this
                kotlinx.coroutines.flow.MutableSharedFlow r12 = io.datazoom.sdk.domain.TakeCareJobImp.access$get_timerTick$p(r12)
                io.datazoom.sdk.domain.TimerState r5 = new io.datazoom.sdk.domain.TimerState
                io.datazoom.sdk.domain.TimerState$State r6 = io.datazoom.sdk.domain.TimerState.State.STARTED
                r9 = 2
                r10 = 0
                r7 = 0
                r5.<init>(r6, r7, r9, r10)
                r1 = r11
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r11.label = r4
                java.lang.Object r12 = r12.emit(r5, r1)
                if (r12 != r0) goto L42
                goto L6c
            L42:
                long r4 = r11.$intervalMs
                r12 = r11
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                r11.label = r3
                java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r4, r12)
                if (r12 != r0) goto L50
                goto L6c
            L50:
                io.datazoom.sdk.domain.TakeCareJobImp r12 = io.datazoom.sdk.domain.TakeCareJobImp.this
                kotlinx.coroutines.flow.MutableSharedFlow r12 = io.datazoom.sdk.domain.TakeCareJobImp.access$get_timerTick$p(r12)
                io.datazoom.sdk.domain.TimerState r4 = new io.datazoom.sdk.domain.TimerState
                io.datazoom.sdk.domain.TimerState$State r5 = io.datazoom.sdk.domain.TimerState.State.PULSE
                r8 = 2
                r9 = 0
                r6 = 0
                r4.<init>(r5, r6, r8, r9)
                r1 = r11
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r11.label = r2
                java.lang.Object r12 = r12.emit(r4, r1)
                if (r12 != r0) goto L42
            L6c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.datazoom.sdk.domain.TakeCareJobImp.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // io.datazoom.sdk.domain.TakeCareJob
    public void stop() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.timerJob = null;
        this._timerTick.tryEmit(new TimerState(TimerState.State.STOPPED, 0L, 2, null));
    }

    @Override // io.datazoom.sdk.domain.TakeCareJob
    public void clear() {
        stop();
    }
}
