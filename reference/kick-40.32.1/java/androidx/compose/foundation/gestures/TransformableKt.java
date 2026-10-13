package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.google.android.gms.cast.MediaError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001b\u001a<\u0010\u001c\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001e\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectNonTouchGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePointerEventAsCtrlScrollOrNull", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointer", "Landroidx/compose/ui/input/pointer/PointerEvent;", "consumePointerEventAsPanOrNull", "consumePointerEventAsScaleOrNull", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEvent;)Ljava/lang/Float;", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {461, 463, 521}, m = "detectZoom", n = {"$this$detectZoom", "channel", "canPan", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "event", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformableKt.transformable$lambda$0((Offset) obj));
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2", f = "Transformable.kt", i = {0, 1, 2, 3}, l = {288, 315, MediaError.DetailedErrorCode.SMOOTH_NETWORK, 349}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0", "L$0"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ ScrollConfig $scrollConfig;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$scrollConfig = scrollConfig;
            this.$channel = channel;
        }

        static final boolean invokeSuspend$lambda$0(PointerInputChange pointerInputChange) {
            return true;
        }

        static final boolean invokeSuspend$lambda$1(PointerInputChange pointerInputChange) {
            return true;
        }

        static final boolean invokeSuspend$lambda$3(PointerInputChange pointerInputChange) {
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x006a  */
        /* JADX WARN: Code duplicated, block: B:30:0x006c A[Catch: all -> 0x004b, PHI: r2 r9
          0x006c: PHI (r2v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r2v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v16 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:28:0x0068, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE]
          0x006c: PHI (r9v14 java.lang.Object) = (r9v18 java.lang.Object), (r9v30 java.lang.Object) binds: [B:28:0x0068, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:32:0x007e A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:35:0x0084 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:39:0x00d2 A[Catch: all -> 0x004b, PHI: r2 r9
          0x00d2: PHI (r2v6 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r2v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v18 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:37:0x00ce, B:18:0x003d] A[DONT_GENERATE, DONT_INLINE]
          0x00d2: PHI (r9v7 java.lang.Object) = (r9v13 java.lang.Object), (r9v31 java.lang.Object) binds: [B:37:0x00ce, B:18:0x003d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00dc A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:43:0x00e3 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:50:0x0126 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:51:0x0128 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:59:0x0173 A[PHI: r2
          0x0173: PHI (r2v12 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r2v4 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v6 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v14 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:48:0x011f, B:40:0x00da, B:56:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:60:0x017c A[Catch: all -> 0x004b, TRY_ENTER, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:64:0x0190  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:27:0x005d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00da -> B:59:0x0173). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00dc -> B:36:0x008f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x011f -> B:59:0x0173). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0121 -> B:44:0x00ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0163 -> B:55:0x0166). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 403
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsCtrlScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent, ScrollConfig scrollConfig) {
        long jM7089getZeroF1C5BW0;
        PointerInputChange pointerInputChange;
        if (!PointerEvent_androidKt.m8639isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers()) || (!PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8630getScroll7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8624getPanStart7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8623getPanMove7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8622getPanEnd7fucELk()))) {
            return null;
        }
        long jMo1755calculateMouseWheelScroll8xgXZGE = scrollConfig.mo1755calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo8560getSizeYbymL2g());
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges())) == null) {
            jM7089getZeroF1C5BW0 = Offset.INSTANCE.m7089getZeroF1C5BW0();
        } else {
            long jM7065constructorimpl = Offset.m7065constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM7062boximpl = Offset.m7062boximpl(Offset.INSTANCE.m7089getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM7062boximpl = Offset.m7062boximpl(Offset.m7077minusMKHz9U(offsetM7062boximpl.m7083unboximpl(), historical.get(i).getPanOffset()));
            }
            jM7089getZeroF1C5BW0 = Offset.m7078plusMKHz9U(jM7065constructorimpl, offsetM7062boximpl.m7083unboximpl());
        }
        long jM7078plusMKHz9U = Offset.m7078plusMKHz9U(jMo1755calculateMouseWheelScroll8xgXZGE, jM7089getZeroF1C5BW0);
        if (Offset.m7070equalsimpl0(jM7078plusMKHz9U, Offset.INSTANCE.m7089getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m7062boximpl(jM7078plusMKHz9U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsPanOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        long jM7089getZeroF1C5BW0;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8624getPanStart7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8623getPanMove7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8622getPanEnd7fucELk()))) {
            return null;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges());
        if (pointerInputChange == null) {
            jM7089getZeroF1C5BW0 = Offset.INSTANCE.m7089getZeroF1C5BW0();
        } else {
            long jM7065constructorimpl = Offset.m7065constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM7062boximpl = Offset.m7062boximpl(Offset.INSTANCE.m7089getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM7062boximpl = Offset.m7062boximpl(Offset.m7077minusMKHz9U(offsetM7062boximpl.m7083unboximpl(), historical.get(i).getPanOffset()));
            }
            jM7089getZeroF1C5BW0 = Offset.m7078plusMKHz9U(jM7065constructorimpl, offsetM7062boximpl.m7083unboximpl());
        }
        if (Offset.m7070equalsimpl0(jM7089getZeroF1C5BW0, Offset.INSTANCE.m7089getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m7062boximpl(jM7089getZeroF1C5BW0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float consumePointerEventAsScaleOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8629getScaleStart7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8627getScaleChange7fucELk()) && !PointerEventType.m8615equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m8628getScaleEnd7fucELk()))) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        float scaleFactor = 1.0f;
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            scaleFactor *= pointerInputChange.getScaleFactor();
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size2 = historical.size();
            for (int i2 = 0; i2 < size2; i2++) {
                scaleFactor *= historical.get(i2).getScaleFactor();
            }
        }
        if (scaleFactor == 1.0f) {
            return null;
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size3 = changes2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            changes2.get(i3).consume();
        }
        return Float.valueOf(scaleFactor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:120:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0141  */
    /* JADX WARN: Code duplicated, block: B:31:0x014e A[LOOP:2: B:27:0x013f->B:31:0x014e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0155  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x02ef -> B:98:0x02ff). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r29, boolean r30, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r31, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Boolean> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instruction units count: 855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectNonTouchGestures(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass2(continuation.get$context(), scrollConfig, channel, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }
}
