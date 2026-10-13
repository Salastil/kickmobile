package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u00010BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u001c*\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001b\u0010%\u001a\u00020#*\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u001a\u0010+\u001a\u00020\u000b*\u00020\u00032\u0006\u0010&\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010,J\u0014\u0010+\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u00020-H\u0002R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic;", "Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "receivingPanEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onPan", "", "sumOrNull", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "trackVelocity", "dispatchTrackpadScroll", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "delta", "TrackpadScrollDelta", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackpadScrollingLogic extends NonTouchScrollingLogic {
    public static final int $stable = 8;
    private final Channel<TrackpadScrollDelta> channel;
    private Job receivingPanEventsJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic", f = "TrackpadScrollingLogic.kt", i = {}, l = {173, 190}, m = "dispatchTrackpadScroll", n = {}, s = {}, v = 1)
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
            return TrackpadScrollingLogic.this.dispatchTrackpadScroll(null, null, this);
        }
    }

    public TrackpadScrollingLogic(ScrollingLogic scrollingLogic, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        super(scrollingLogic, function2, density);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo1855onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            if (PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8624getPanStart7fucELk()) || PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8623getPanMove7fucELk()) || PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8622getPanEnd7fucELk())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (changes.get(i).isConsumed()) {
                        return;
                    }
                }
                if (pass == PointerEventPass.Initial && getIsScrolling()) {
                    onPan(pointerEvent);
                    consume$foundation(pointerEvent);
                }
                if (pass == PointerEventPass.Main && !getIsScrolling() && onPan(pointerEvent)) {
                    consume$foundation(pointerEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "isEnd", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "()Z", "plus", "other", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class TrackpadScrollDelta {
        private final boolean isEnd;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ TrackpadScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        private TrackpadScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.isEnd = z;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* JADX INFO: renamed from: getValue-F1C5BW0, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: isEnd, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        public final TrackpadScrollDelta plus(TrackpadScrollDelta other) {
            return new TrackpadScrollDelta(Offset.m7078plusMKHz9U(this.value, other.value), Math.max(this.timeMillis, other.timeMillis), this.isEnd || other.isEnd, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    public void startReceivingEvents(CoroutineScope coroutineScope) {
        if (this.receivingPanEventsJob == null) {
            this.receivingPanEventsJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03051(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$startReceivingEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$startReceivingEvents$1", f = "TrackpadScrollingLogic.kt", i = {0, 1}, l = {99, 99}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
    static final class C03051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C03051(Continuation<? super C03051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03051 c03051 = TrackpadScrollingLogic.this.new C03051(continuation);
            c03051.L$0 = obj;
            return c03051;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0045 A[Catch: all -> 0x0030, TRY_ENTER, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x0013, B:17:0x0039, B:20:0x0045, B:24:0x0064, B:12:0x002c), top: B:32:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0060  */
        /* JADX WARN: Code duplicated, block: B:23:0x0061  */
        /* JADX WARN: Code duplicated, block: B:27:0x0078  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:17:0x0039). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L32
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L30
                r10 = r1
                goto L39
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                java.lang.Object r1 = r9.L$2
                androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
                java.lang.Object r5 = r9.L$1
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r5 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic) r5
                java.lang.Object r6 = r9.L$0
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L30
                goto L64
            L30:
                r10 = move-exception
                goto L80
            L32:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            L39:
                kotlin.coroutines.CoroutineContext r1 = r10.getCoroutineContext()     // Catch: java.lang.Throwable -> L30
                boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)     // Catch: java.lang.Throwable -> L30
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r5 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                if (r1 == 0) goto L7a
                androidx.compose.foundation.gestures.ScrollingLogic r1 = r5.getScrollingLogic()     // Catch: java.lang.Throwable -> L30
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r6 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this     // Catch: java.lang.Throwable -> L30
                kotlinx.coroutines.channels.Channel r6 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$getChannel$p(r6)     // Catch: java.lang.Throwable -> L30
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> L30
                r9.L$0 = r10     // Catch: java.lang.Throwable -> L30
                r9.L$1 = r5     // Catch: java.lang.Throwable -> L30
                r9.L$2 = r1     // Catch: java.lang.Throwable -> L30
                r9.label = r3     // Catch: java.lang.Throwable -> L30
                java.lang.Object r6 = r6.receive(r7)     // Catch: java.lang.Throwable -> L30
                if (r6 != r0) goto L61
                goto L77
            L61:
                r8 = r6
                r6 = r10
                r10 = r8
            L64:
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r10 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r10     // Catch: java.lang.Throwable -> L30
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> L30
                r9.L$0 = r6     // Catch: java.lang.Throwable -> L30
                r9.L$1 = r4     // Catch: java.lang.Throwable -> L30
                r9.L$2 = r4     // Catch: java.lang.Throwable -> L30
                r9.label = r2     // Catch: java.lang.Throwable -> L30
                java.lang.Object r10 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$dispatchTrackpadScroll(r5, r1, r10, r7)     // Catch: java.lang.Throwable -> L30
                if (r10 != r0) goto L78
            L77:
                return r0
            L78:
                r10 = r6
                goto L39
            L7a:
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$setReceivingPanEventsJob$p(r5, r4)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            L80:
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r9 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$setReceivingPanEventsJob$p(r9, r4)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TrackpadScrollingLogic.C03051.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a1  */
    private final boolean onPan(PointerEvent pointerEvent) {
        boolean z;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            return false;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges());
        if (pointerInputChange != null) {
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size = historical.size();
            z = false;
            for (int i = 0; i < size; i++) {
                HistoricalChange historicalChange = historical.get(i);
                long jM7065constructorimpl = Offset.m7065constructorimpl((-9223372034707292160L) ^ historicalChange.getPanOffset());
                if (m1942canConsumeDeltaUv8p0NA(getScrollingLogic(), jM7065constructorimpl)) {
                    z = ChannelResult.m14245isSuccessimpl(this.channel.mo12563trySendJP2dKIU(new TrackpadScrollDelta(jM7065constructorimpl, historicalChange.getUptimeMillis(), false, null))) || z;
                }
            }
            long jM7065constructorimpl2 = Offset.m7065constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            boolean zM8615equalsimpl0 = PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8622getPanEnd7fucELk());
            if (m1942canConsumeDeltaUv8p0NA(getScrollingLogic(), jM7065constructorimpl2) || zM8615equalsimpl0) {
                if (ChannelResult.m14245isSuccessimpl(this.channel.mo12563trySendJP2dKIU(new TrackpadScrollDelta(jM7065constructorimpl2, pointerInputChange.getUptimeMillis(), zM8615equalsimpl0, null))) || z) {
                    z = true;
                } else {
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z || getIsScrolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrackpadScrollDelta sumOrNull(final Channel<TrackpadScrollDelta> channel) {
        TrackpadScrollDelta trackpadScrollDeltaPlus = null;
        for (TrackpadScrollDelta trackpadScrollDelta : NonTouchScrollingLogicKt.untilNull(new Function0() { // from class: androidx.compose.foundation.gestures.TrackpadScrollingLogic$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrackpadScrollingLogic.sumOrNull$lambda$0(channel);
            }
        })) {
            trackpadScrollDeltaPlus = trackpadScrollDeltaPlus == null ? trackpadScrollDelta : trackpadScrollDeltaPlus.plus(trackpadScrollDelta);
        }
        return trackpadScrollDeltaPlus;
    }

    static final TrackpadScrollDelta sumOrNull$lambda$0(Channel channel) {
        return (TrackpadScrollDelta) ChannelResult.m14240getOrNullimpl(channel.mo12664tryReceivePtdJZtk());
    }

    /* JADX INFO: renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m1942canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        return !(scrollingLogic.m1923toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m1919reverseIfNeededMKHz9U(j)) == 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(TrackpadScrollDelta scrollDelta) {
        getVelocityTracker().m1779addDeltaUv8p0NA(scrollDelta.getTimeMillis(), scrollDelta.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (r6.invoke(r5, r0) == r1) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object dispatchTrackpadScroll(androidx.compose.foundation.gestures.ScrollingLogic r6, androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TrackpadScrollingLogic.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$1 r0 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$1 r0 = new androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6c
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.element = r7
            r5.trackVelocity(r7)
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r7 = r5.channel
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r7 = r5.sumOrNull(r7)
            if (r7 == 0) goto L5b
            r5.trackVelocity(r7)
            T r2 = r8.element
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r2 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r2
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r7 = r2.plus(r7)
            r8.element = r7
        L5b:
            androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3 r7 = new androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3
            r2 = 0
            r7.<init>(r6, r8, r2)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.label = r4
            java.lang.Object r6 = r5.userScroll$foundation(r7, r0)
            if (r6 != r1) goto L6c
            goto L84
        L6c:
            kotlin.jvm.functions.Function2 r6 = r5.getOnScrollStopped()
            androidx.compose.foundation.gestures.DifferentialVelocityTracker r5 = r5.getVelocityTracker()
            long r7 = r5.m1780calculateVelocity9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m10397boximpl(r7)
            r0.label = r3
            java.lang.Object r5 = r6.invoke(r5, r0)
            if (r5 != r1) goto L85
        L84:
            return r1
        L85:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TrackpadScrollingLogic.dispatchTrackpadScroll(androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3, reason: invalid class name */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3", f = "TrackpadScrollingLogic.kt", i = {0}, l = {178}, m = "invokeSuspend", n = {"$this$userScroll"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<TrackpadScrollDelta> $targetScrollDelta;
        final /* synthetic */ ScrollingLogic $this_dispatchTrackpadScroll;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ScrollingLogic scrollingLogic, Ref.ObjectRef<TrackpadScrollDelta> objectRef, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_dispatchTrackpadScroll = scrollingLogic;
            this.$targetScrollDelta = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = TrackpadScrollingLogic.this.new AnonymousClass3(this.$this_dispatchTrackpadScroll, this.$targetScrollDelta, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x004c  */
        /* JADX WARN: Code duplicated, block: B:13:0x0063 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x007d  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v15, types: [T, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0061 -> B:14:0x0064). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x004c
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r6.L$0
                androidx.compose.foundation.gestures.NestedScrollScope r3 = (androidx.compose.foundation.gestures.NestedScrollScope) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L64
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                androidx.compose.foundation.gestures.NestedScrollScope r7 = (androidx.compose.foundation.gestures.NestedScrollScope) r7
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r1 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                androidx.compose.foundation.gestures.ScrollingLogic r3 = r6.$this_dispatchTrackpadScroll
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r4 = r6.$targetScrollDelta
                T r4 = r4.element
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r4 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r4
                long r4 = r4.getValue()
                long r4 = r3.m1919reverseIfNeededMKHz9U(r4)
                float r3 = r3.m1923toSingleAxisDeltaFromAnglek4lQ0M(r4)
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$dispatchTrackpadScroll(r1, r7, r3)
                r3 = r7
            L40:
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r7 = r6.$targetScrollDelta
                T r7 = r7.element
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r7 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r7
                boolean r7 = r7.getIsEnd()
                if (r7 != 0) goto La8
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r1 = r6.$targetScrollDelta
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                kotlinx.coroutines.channels.Channel r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$getChannel$p(r7)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                java.lang.Object r7 = androidx.compose.foundation.gestures.NonTouchScrollingLogicKt.busyReceive(r7, r4)
                if (r7 != r0) goto L64
                return r0
            L64:
                r1.element = r7
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r1 = r6.$targetScrollDelta
                T r1 = r1.element
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r1 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r1
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$trackVelocity(r7, r1)
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$getChannel$p(r7)
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$sumOrNull(r7, r1)
                if (r7 == 0) goto L8e
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r1 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r4 = r6.$targetScrollDelta
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$trackVelocity(r1, r7)
                T r1 = r4.element
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r1 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r1
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r7 = r1.plus(r7)
                r4.element = r7
            L8e:
                androidx.compose.foundation.gestures.TrackpadScrollingLogic r7 = androidx.compose.foundation.gestures.TrackpadScrollingLogic.this
                androidx.compose.foundation.gestures.ScrollingLogic r1 = r6.$this_dispatchTrackpadScroll
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta> r4 = r6.$targetScrollDelta
                T r4 = r4.element
                androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta r4 = (androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta) r4
                long r4 = r4.getValue()
                long r4 = r1.m1919reverseIfNeededMKHz9U(r4)
                float r1 = r1.m1923toSingleAxisDeltaFromAnglek4lQ0M(r4)
                androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$dispatchTrackpadScroll(r7, r3, r1)
                goto L40
            La8:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TrackpadScrollingLogic.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchTrackpadScroll(NestedScrollScope nestedScrollScope, float f) {
        ScrollingLogic scrollingLogic = getScrollingLogic();
        return scrollingLogic.m1921toFloatk4lQ0M(scrollingLogic.m1919reverseIfNeededMKHz9U(nestedScrollScope.mo1861scrollByWithOverscrollOzD1aCk(scrollingLogic.m1922toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f)), NestedScrollSource.INSTANCE.m8544getUserInputWNlRxjI())));
    }
}
