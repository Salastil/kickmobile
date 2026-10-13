package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.facebook.imageutils.TiffUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaError;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0093\u0001\u0010\u0011\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2-\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001d\u001a[\u0010\u001e\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"H\u0087@¢\u0006\u0002\u0010#\u001a&\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&\u001a&\u0010'\u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010&\u001a\u001e\u0010(\u001a\u00020\"*\u00020)2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\"H\u0000\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010,\u001a\u001c\u0010-\u001a\u00020.*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010,\u001aL\u0010/\u001a\u000200*\u00020\u00142\u0006\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002032'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000605¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u00106\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u00067"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTapGesture", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "pressScope", "Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/PressGestureScopeImpl;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "resetJob", ViewProps.START, "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {TypedValues.Attributes.TYPE_EASING}, m = "awaitFirstDown", n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {330}, m = "awaitPrimaryFirstDown", n = {"$this$awaitPrimaryFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.VOID}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"}, v = 1)
    static final class C02961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02961(Continuation<? super C02961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7}, l = {WebmConstants.MkvEbmlElement.TRACK_TYPE, 142, 145, 148, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 194, 196, 207}, m = "processTapGesture", n = {"$this$processTapGesture", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "$this$processTapGesture", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "resetJob", "$this$processTapGesture", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", GesturesListener.SCROLL_DIRECTION_DOWN, "resetJob", PermissionsResponse.SCOPE_KEY, "pressScope", "resetJob", "$this$processTapGesture", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "upOrCancel", "cancelOrReleaseJob", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onTap", "resetJob", "upOrCancel", "$this$processTapGesture", PermissionsResponse.SCOPE_KEY, "pressScope", "onDoubleTap", "onLongPress", "onTap", "resetJob", "upOrCancel", "secondDown", PermissionsResponse.SCOPE_KEY, "pressScope", "resetJob"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2"}, v = 1)
    static final class C03001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C03001(Continuation<? super C03001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.processTapGesture(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {410}, m = "waitForLongPress", n = {"result"}, s = {"L$0"}, v = 1)
    static final class C03021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03021(Continuation<? super C03021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 1, 1}, l = {378, 392}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C03042 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03042(Continuation<? super C03042> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function2, Function3 function3, Function1 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 8) != 0) {
            function4 = null;
        }
        return detectTapGestures(pointerInputScope, function1, function2, function3, function4, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02982(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super C02982> continuation) {
            super(2, continuation);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onDoubleTap = function1;
            this.$onLongPress = function2;
            this.$onPress = function3;
            this.$onTap = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02982 c02982 = new C02982(this.$this_detectTapGestures, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, continuation);
            c02982.L$0 = obj;
            return c02982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new AnonymousClass1(coroutineScope, pressGestureScopeImpl, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$pressScope = pressGestureScopeImpl;
                this.$onDoubleTap = function1;
                this.$onLongPress = function2;
                this.$onPress = function3;
                this.$onTap = function4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (TapGestureDetectorKt.processTapGesture((AwaitPointerEventScope) this.L$0, this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C02982(pointerInputScope, function1, function2, function3, function4, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x043b  */
    /* JADX WARN: Code duplicated, block: B:101:0x0447  */
    /* JADX WARN: Code duplicated, block: B:105:0x0450  */
    /* JADX WARN: Code duplicated, block: B:26:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:27:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:29:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:32:0x01db  */
    /* JADX WARN: Code duplicated, block: B:34:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:37:0x0204  */
    /* JADX WARN: Code duplicated, block: B:40:0x0215  */
    /* JADX WARN: Code duplicated, block: B:43:0x023d  */
    /* JADX WARN: Code duplicated, block: B:46:0x025c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0260  */
    /* JADX WARN: Code duplicated, block: B:49:0x0267  */
    /* JADX WARN: Code duplicated, block: B:51:0x026b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0276  */
    /* JADX WARN: Code duplicated, block: B:55:0x0292  */
    /* JADX WARN: Code duplicated, block: B:57:0x02b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x02b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:60:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:63:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:66:0x02f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:68:0x0301  */
    /* JADX WARN: Code duplicated, block: B:70:0x0323  */
    /* JADX WARN: Code duplicated, block: B:72:0x033f  */
    /* JADX WARN: Code duplicated, block: B:75:0x035c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0364  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:80:0x0380  */
    /* JADX WARN: Code duplicated, block: B:83:0x0395  */
    /* JADX WARN: Code duplicated, block: B:86:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:89:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:91:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:93:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:95:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:97:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:98:0x041f  */
    public static final Object processTapGesture(AwaitPointerEventScope awaitPointerEventScope, CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super Unit> continuation) {
        C03001 c03001;
        Function1<? super Offset, Unit> function5;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function6;
        Function1<? super Offset, Unit> function7;
        PressGestureScopeImpl pressGestureScopeImpl2;
        Function1<? super Offset, Unit> function8;
        AwaitPointerEventScope awaitPointerEventScope2;
        CoroutineScope coroutineScope2;
        PointerInputChange pointerInputChange;
        Job jobLaunch$default;
        Job job;
        Function1<? super Offset, Unit> function9;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function10;
        AwaitPointerEventScope awaitPointerEventScope3;
        PressGestureScopeImpl pressGestureScopeImpl3;
        Function1<? super Offset, Unit> function11;
        Function1<? super Offset, Unit> function12;
        Function1<? super Offset, Unit> function13;
        Function1<? super Offset, Unit> function14;
        AwaitPointerEventScope awaitPointerEventScope4;
        CoroutineScope coroutineScope3;
        PressGestureScopeImpl pressGestureScopeImpl4;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function15;
        Function1<? super Offset, Unit> function16;
        PointerInputChange finalUpChange;
        Job jobLaunchAwaitingReset$default;
        Object objAwaitSecondDown;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope5;
        CoroutineScope coroutineScope4;
        Function1<? super Offset, Unit> function17;
        Function1<? super Offset, Unit> function18;
        Function1<? super Offset, Unit> function19;
        PressGestureScopeImpl pressGestureScopeImpl5;
        LongPressResult longPressResult;
        Job job2;
        CoroutineScope coroutineScope5;
        PressGestureScopeImpl pressGestureScopeImpl6;
        PointerInputChange pointerInputChange3;
        Job jobLaunch$default2;
        Object objWaitForLongPress$default;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        PressGestureScopeImpl pressGestureScopeImpl7;
        Function1<? super Offset, Unit> function20;
        Function1<? super Offset, Unit> function21;
        Function1<? super Offset, Unit> function22;
        CoroutineScope coroutineScope6;
        AwaitPointerEventScope awaitPointerEventScope6;
        CoroutineScope coroutineScope7;
        PointerInputChange finalUpChange2;
        LongPressResult longPressResult2;
        Job job3;
        PressGestureScopeImpl pressGestureScopeImpl8;
        CoroutineScope coroutineScope8;
        if (continuation instanceof C03001) {
            c03001 = (C03001) continuation;
            if ((c03001.label & Integer.MIN_VALUE) != 0) {
                c03001.label -= Integer.MIN_VALUE;
            } else {
                c03001 = new C03001(continuation);
            }
        } else {
            c03001 = new C03001(continuation);
        }
        C03001 c03002 = c03001;
        Object objWaitForLongPress$default2 = c03002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03002.label) {
            case 0:
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                c03002.L$0 = awaitPointerEventScope;
                c03002.L$1 = coroutineScope;
                c03002.L$2 = pressGestureScopeImpl;
                c03002.L$3 = function1;
                function5 = function2;
                c03002.L$4 = function5;
                function6 = function3;
                c03002.L$5 = function6;
                function7 = function4;
                c03002.L$6 = function7;
                c03002.label = 1;
                Object objAwaitFirstDown$default = awaitFirstDown$default(awaitPointerEventScope, false, null, c03002, 3, null);
                if (objAwaitFirstDown$default != coroutine_suspended) {
                    pressGestureScopeImpl2 = pressGestureScopeImpl;
                    function8 = function1;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    coroutineScope2 = coroutineScope;
                    objWaitForLongPress$default2 = objAwaitFirstDown$default;
                    pointerInputChange = (PointerInputChange) objWaitForLongPress$default2;
                    pointerInputChange.consume();
                    jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                    if (function6 != NoPressGesture) {
                        launchAwaitingReset$default(coroutineScope2, jobLaunch$default, null, new C03012(function6, pressGestureScopeImpl2, pointerInputChange, null), 2, null);
                        job = jobLaunch$default;
                    } else {
                        job = jobLaunch$default;
                    }
                    if (function5 == null) {
                        c03002.L$0 = awaitPointerEventScope2;
                        c03002.L$1 = coroutineScope2;
                        c03002.L$2 = pressGestureScopeImpl2;
                        c03002.L$3 = function8;
                        c03002.L$4 = function5;
                        c03002.L$5 = function6;
                        c03002.L$6 = function7;
                        c03002.L$7 = job;
                        c03002.label = 2;
                        objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope2, null, c03002, 1, null);
                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                            PressGestureScopeImpl pressGestureScopeImpl9 = pressGestureScopeImpl2;
                            function13 = function8;
                            function14 = function5;
                            awaitPointerEventScope4 = awaitPointerEventScope2;
                            coroutineScope3 = coroutineScope2;
                            pressGestureScopeImpl4 = pressGestureScopeImpl9;
                            function15 = function6;
                            function16 = function7;
                            finalUpChange = (PointerInputChange) objWaitForLongPress$default2;
                            if (finalUpChange == null) {
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                            } else {
                                finalUpChange.consume();
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                            }
                            if (finalUpChange != null) {
                                if (function13 == null) {
                                    c03002.L$0 = awaitPointerEventScope4;
                                    c03002.L$1 = coroutineScope3;
                                    c03002.L$2 = pressGestureScopeImpl4;
                                    c03002.L$3 = function13;
                                    c03002.L$4 = function14;
                                    c03002.L$5 = function15;
                                    c03002.L$6 = function16;
                                    c03002.L$7 = finalUpChange;
                                    c03002.L$8 = jobLaunchAwaitingReset$default;
                                    c03002.label = 5;
                                    objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                                    if (objAwaitSecondDown != coroutine_suspended) {
                                        Function1<? super Offset, Unit> function23 = function16;
                                        pointerInputChange2 = finalUpChange;
                                        objWaitForLongPress$default2 = objAwaitSecondDown;
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        coroutineScope4 = coroutineScope3;
                                        function17 = function13;
                                        function18 = function23;
                                        PressGestureScopeImpl pressGestureScopeImpl10 = pressGestureScopeImpl4;
                                        function19 = function14;
                                        pressGestureScopeImpl5 = pressGestureScopeImpl10;
                                        pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                                        if (pointerInputChange3 != null) {
                                            jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                            if (function15 != NoPressGesture) {
                                                launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                            }
                                            if (function19 == null) {
                                                c03002.L$0 = coroutineScope4;
                                                c03002.L$1 = pressGestureScopeImpl5;
                                                c03002.L$2 = function17;
                                                c03002.L$3 = function18;
                                                c03002.L$4 = jobLaunch$default2;
                                                c03002.L$5 = pointerInputChange2;
                                                c03002.L$6 = null;
                                                c03002.L$7 = null;
                                                c03002.L$8 = null;
                                                c03002.label = 6;
                                                objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                    pointerInputChange5 = pointerInputChange2;
                                                    function20 = function18;
                                                    function22 = function17;
                                                    coroutineScope7 = coroutineScope4;
                                                    finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                        function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                        if (function20 != null) {
                                                            function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                        }
                                                    }
                                                }
                                            } else {
                                                c03002.L$0 = awaitPointerEventScope5;
                                                c03002.L$1 = coroutineScope4;
                                                c03002.L$2 = pressGestureScopeImpl5;
                                                c03002.L$3 = function17;
                                                c03002.L$4 = function19;
                                                c03002.L$5 = function18;
                                                c03002.L$6 = jobLaunch$default2;
                                                c03002.L$7 = pointerInputChange2;
                                                c03002.L$8 = pointerInputChange3;
                                                c03002.label = 7;
                                                objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                if (objWaitForLongPress$default != coroutine_suspended) {
                                                    PointerInputChange pointerInputChange6 = pointerInputChange2;
                                                    pointerInputChange4 = pointerInputChange3;
                                                    objWaitForLongPress$default2 = objWaitForLongPress$default;
                                                    pointerInputChange5 = pointerInputChange6;
                                                    Function1<? super Offset, Unit> function24 = function19;
                                                    pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                    function20 = function18;
                                                    function21 = function24;
                                                    function22 = function17;
                                                    coroutineScope6 = coroutineScope4;
                                                    awaitPointerEventScope6 = awaitPointerEventScope5;
                                                    longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                    if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                        function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                                        c03002.L$0 = coroutineScope6;
                                                        c03002.L$1 = pressGestureScopeImpl7;
                                                        c03002.L$2 = jobLaunch$default2;
                                                        c03002.L$3 = null;
                                                        c03002.L$4 = null;
                                                        c03002.L$5 = null;
                                                        c03002.L$6 = null;
                                                        c03002.L$7 = null;
                                                        c03002.L$8 = null;
                                                        c03002.label = 8;
                                                        if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                            job3 = jobLaunch$default2;
                                                            pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                            coroutineScope8 = coroutineScope6;
                                                            launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            finalUpChange2 = null;
                                                        }
                                                        pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                        coroutineScope7 = coroutineScope6;
                                                        if (finalUpChange2 != null) {
                                                            finalUpChange2.consume();
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                            function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                            if (function20 != null) {
                                                                function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function18 != null) {
                                            function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                                        }
                                    }
                                } else if (function16 != null) {
                                    function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        c03002.L$0 = awaitPointerEventScope2;
                        c03002.L$1 = coroutineScope2;
                        c03002.L$2 = pressGestureScopeImpl2;
                        c03002.L$3 = function8;
                        c03002.L$4 = function5;
                        c03002.L$5 = function6;
                        c03002.L$6 = function7;
                        c03002.L$7 = pointerInputChange;
                        c03002.L$8 = job;
                        c03002.label = 3;
                        objWaitForLongPress$default2 = waitForLongPress$default(awaitPointerEventScope2, null, c03002, 1, null);
                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                            Function1<? super Offset, Unit> function25 = function5;
                            function9 = function8;
                            function10 = function6;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            pressGestureScopeImpl3 = pressGestureScopeImpl2;
                            function11 = function25;
                            function12 = function7;
                            longPressResult = (LongPressResult) objWaitForLongPress$default2;
                            if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                                if (longPressResult instanceof LongPressResult.Released) {
                                    finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                                } else {
                                    if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    finalUpChange = null;
                                }
                                PressGestureScopeImpl pressGestureScopeImpl11 = pressGestureScopeImpl3;
                                coroutineScope3 = coroutineScope2;
                                pressGestureScopeImpl4 = pressGestureScopeImpl11;
                                function16 = function12;
                                function15 = function10;
                                function14 = function11;
                                function13 = function9;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                if (finalUpChange == null) {
                                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                                } else {
                                    finalUpChange.consume();
                                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                                }
                                if (finalUpChange != null) {
                                    if (function13 == null) {
                                        c03002.L$0 = awaitPointerEventScope4;
                                        c03002.L$1 = coroutineScope3;
                                        c03002.L$2 = pressGestureScopeImpl4;
                                        c03002.L$3 = function13;
                                        c03002.L$4 = function14;
                                        c03002.L$5 = function15;
                                        c03002.L$6 = function16;
                                        c03002.L$7 = finalUpChange;
                                        c03002.L$8 = jobLaunchAwaitingReset$default;
                                        c03002.label = 5;
                                        objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                                        if (objAwaitSecondDown != coroutine_suspended) {
                                            Function1<? super Offset, Unit> function26 = function16;
                                            pointerInputChange2 = finalUpChange;
                                            objWaitForLongPress$default2 = objAwaitSecondDown;
                                            awaitPointerEventScope5 = awaitPointerEventScope4;
                                            coroutineScope4 = coroutineScope3;
                                            function17 = function13;
                                            function18 = function26;
                                            PressGestureScopeImpl pressGestureScopeImpl12 = pressGestureScopeImpl4;
                                            function19 = function14;
                                            pressGestureScopeImpl5 = pressGestureScopeImpl12;
                                            pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                                            if (pointerInputChange3 != null) {
                                                jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                                if (function15 != NoPressGesture) {
                                                    launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                                }
                                                if (function19 == null) {
                                                    c03002.L$0 = coroutineScope4;
                                                    c03002.L$1 = pressGestureScopeImpl5;
                                                    c03002.L$2 = function17;
                                                    c03002.L$3 = function18;
                                                    c03002.L$4 = jobLaunch$default2;
                                                    c03002.L$5 = pointerInputChange2;
                                                    c03002.L$6 = null;
                                                    c03002.L$7 = null;
                                                    c03002.L$8 = null;
                                                    c03002.label = 6;
                                                    objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                    if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                        pointerInputChange5 = pointerInputChange2;
                                                        function20 = function18;
                                                        function22 = function17;
                                                        coroutineScope7 = coroutineScope4;
                                                        finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                                        if (finalUpChange2 != null) {
                                                            finalUpChange2.consume();
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                            function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                            if (function20 != null) {
                                                                function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    c03002.L$0 = awaitPointerEventScope5;
                                                    c03002.L$1 = coroutineScope4;
                                                    c03002.L$2 = pressGestureScopeImpl5;
                                                    c03002.L$3 = function17;
                                                    c03002.L$4 = function19;
                                                    c03002.L$5 = function18;
                                                    c03002.L$6 = jobLaunch$default2;
                                                    c03002.L$7 = pointerInputChange2;
                                                    c03002.L$8 = pointerInputChange3;
                                                    c03002.label = 7;
                                                    objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                    if (objWaitForLongPress$default != coroutine_suspended) {
                                                        PointerInputChange pointerInputChange7 = pointerInputChange2;
                                                        pointerInputChange4 = pointerInputChange3;
                                                        objWaitForLongPress$default2 = objWaitForLongPress$default;
                                                        pointerInputChange5 = pointerInputChange7;
                                                        Function1<? super Offset, Unit> function27 = function19;
                                                        pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                        function20 = function18;
                                                        function21 = function27;
                                                        function22 = function17;
                                                        coroutineScope6 = coroutineScope4;
                                                        awaitPointerEventScope6 = awaitPointerEventScope5;
                                                        longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                        if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                            function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                                            c03002.L$0 = coroutineScope6;
                                                            c03002.L$1 = pressGestureScopeImpl7;
                                                            c03002.L$2 = jobLaunch$default2;
                                                            c03002.L$3 = null;
                                                            c03002.L$4 = null;
                                                            c03002.L$5 = null;
                                                            c03002.L$6 = null;
                                                            c03002.L$7 = null;
                                                            c03002.L$8 = null;
                                                            c03002.label = 8;
                                                            if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                                job3 = jobLaunch$default2;
                                                                pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                                coroutineScope8 = coroutineScope6;
                                                                launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                                finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                    throw new NoWhenBranchMatchedException();
                                                                }
                                                                finalUpChange2 = null;
                                                            }
                                                            pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                            coroutineScope7 = coroutineScope6;
                                                            if (finalUpChange2 != null) {
                                                                finalUpChange2.consume();
                                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                                function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                            } else {
                                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                                if (function20 != null) {
                                                                    function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (function18 != null) {
                                                function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                                            }
                                        }
                                    } else if (function16 != null) {
                                        function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            function11.invoke(Offset.m7062boximpl(pointerInputChange.getPosition()));
                            c03002.L$0 = coroutineScope2;
                            c03002.L$1 = pressGestureScopeImpl3;
                            c03002.L$2 = job;
                            c03002.L$3 = null;
                            c03002.L$4 = null;
                            c03002.L$5 = null;
                            c03002.L$6 = null;
                            c03002.L$7 = null;
                            c03002.L$8 = null;
                            c03002.label = 4;
                            if (consumeUntilUp(awaitPointerEventScope3, c03002) != coroutine_suspended) {
                                job2 = job;
                                coroutineScope5 = coroutineScope2;
                                pressGestureScopeImpl6 = pressGestureScopeImpl3;
                                launchAwaitingReset$default(coroutineScope5, job2, null, new AnonymousClass3(pressGestureScopeImpl6, null), 2, null);
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                Function1<? super Offset, Unit> function28 = (Function1) c03002.L$6;
                Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function29 = (Function3) c03002.L$5;
                Function1<? super Offset, Unit> function30 = (Function1) c03002.L$4;
                function8 = (Function1) c03002.L$3;
                pressGestureScopeImpl2 = (PressGestureScopeImpl) c03002.L$2;
                coroutineScope2 = (CoroutineScope) c03002.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                function7 = function28;
                function6 = function29;
                function5 = function30;
                pointerInputChange = (PointerInputChange) objWaitForLongPress$default2;
                pointerInputChange.consume();
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                if (function6 != NoPressGesture) {
                    launchAwaitingReset$default(coroutineScope2, jobLaunch$default, null, new C03012(function6, pressGestureScopeImpl2, pointerInputChange, null), 2, null);
                    job = jobLaunch$default;
                } else {
                    job = jobLaunch$default;
                }
                if (function5 == null) {
                    c03002.L$0 = awaitPointerEventScope2;
                    c03002.L$1 = coroutineScope2;
                    c03002.L$2 = pressGestureScopeImpl2;
                    c03002.L$3 = function8;
                    c03002.L$4 = function5;
                    c03002.L$5 = function6;
                    c03002.L$6 = function7;
                    c03002.L$7 = job;
                    c03002.label = 2;
                    objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope2, null, c03002, 1, null);
                    if (objWaitForLongPress$default2 != coroutine_suspended) {
                        PressGestureScopeImpl pressGestureScopeImpl13 = pressGestureScopeImpl2;
                        function13 = function8;
                        function14 = function5;
                        awaitPointerEventScope4 = awaitPointerEventScope2;
                        coroutineScope3 = coroutineScope2;
                        pressGestureScopeImpl4 = pressGestureScopeImpl13;
                        function15 = function6;
                        function16 = function7;
                        finalUpChange = (PointerInputChange) objWaitForLongPress$default2;
                        if (finalUpChange == null) {
                            jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                        } else {
                            finalUpChange.consume();
                            jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                        }
                        if (finalUpChange != null) {
                            if (function13 == null) {
                                c03002.L$0 = awaitPointerEventScope4;
                                c03002.L$1 = coroutineScope3;
                                c03002.L$2 = pressGestureScopeImpl4;
                                c03002.L$3 = function13;
                                c03002.L$4 = function14;
                                c03002.L$5 = function15;
                                c03002.L$6 = function16;
                                c03002.L$7 = finalUpChange;
                                c03002.L$8 = jobLaunchAwaitingReset$default;
                                c03002.label = 5;
                                objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                                if (objAwaitSecondDown != coroutine_suspended) {
                                    Function1<? super Offset, Unit> function210 = function16;
                                    pointerInputChange2 = finalUpChange;
                                    objWaitForLongPress$default2 = objAwaitSecondDown;
                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                    coroutineScope4 = coroutineScope3;
                                    function17 = function13;
                                    function18 = function210;
                                    PressGestureScopeImpl pressGestureScopeImpl14 = pressGestureScopeImpl4;
                                    function19 = function14;
                                    pressGestureScopeImpl5 = pressGestureScopeImpl14;
                                    pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                                    if (pointerInputChange3 != null) {
                                        jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                        if (function15 != NoPressGesture) {
                                            launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                        }
                                        if (function19 == null) {
                                            c03002.L$0 = coroutineScope4;
                                            c03002.L$1 = pressGestureScopeImpl5;
                                            c03002.L$2 = function17;
                                            c03002.L$3 = function18;
                                            c03002.L$4 = jobLaunch$default2;
                                            c03002.L$5 = pointerInputChange2;
                                            c03002.L$6 = null;
                                            c03002.L$7 = null;
                                            c03002.L$8 = null;
                                            c03002.label = 6;
                                            objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                            if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                pointerInputChange5 = pointerInputChange2;
                                                function20 = function18;
                                                function22 = function17;
                                                coroutineScope7 = coroutineScope4;
                                                finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                                if (finalUpChange2 != null) {
                                                    finalUpChange2.consume();
                                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                    function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                } else {
                                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                    if (function20 != null) {
                                                        function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                    }
                                                }
                                            }
                                        } else {
                                            c03002.L$0 = awaitPointerEventScope5;
                                            c03002.L$1 = coroutineScope4;
                                            c03002.L$2 = pressGestureScopeImpl5;
                                            c03002.L$3 = function17;
                                            c03002.L$4 = function19;
                                            c03002.L$5 = function18;
                                            c03002.L$6 = jobLaunch$default2;
                                            c03002.L$7 = pointerInputChange2;
                                            c03002.L$8 = pointerInputChange3;
                                            c03002.label = 7;
                                            objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                            if (objWaitForLongPress$default != coroutine_suspended) {
                                                PointerInputChange pointerInputChange8 = pointerInputChange2;
                                                pointerInputChange4 = pointerInputChange3;
                                                objWaitForLongPress$default2 = objWaitForLongPress$default;
                                                pointerInputChange5 = pointerInputChange8;
                                                Function1<? super Offset, Unit> function211 = function19;
                                                pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                function20 = function18;
                                                function21 = function211;
                                                function22 = function17;
                                                coroutineScope6 = coroutineScope4;
                                                awaitPointerEventScope6 = awaitPointerEventScope5;
                                                longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                    function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                                    c03002.L$0 = coroutineScope6;
                                                    c03002.L$1 = pressGestureScopeImpl7;
                                                    c03002.L$2 = jobLaunch$default2;
                                                    c03002.L$3 = null;
                                                    c03002.L$4 = null;
                                                    c03002.L$5 = null;
                                                    c03002.L$6 = null;
                                                    c03002.L$7 = null;
                                                    c03002.L$8 = null;
                                                    c03002.label = 8;
                                                    if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                        job3 = jobLaunch$default2;
                                                        pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                        coroutineScope8 = coroutineScope6;
                                                        launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                                        finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        finalUpChange2 = null;
                                                    }
                                                    pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                    coroutineScope7 = coroutineScope6;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                        function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                        if (function20 != null) {
                                                            function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (function18 != null) {
                                        function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                                    }
                                }
                            } else if (function16 != null) {
                                function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    c03002.L$0 = awaitPointerEventScope2;
                    c03002.L$1 = coroutineScope2;
                    c03002.L$2 = pressGestureScopeImpl2;
                    c03002.L$3 = function8;
                    c03002.L$4 = function5;
                    c03002.L$5 = function6;
                    c03002.L$6 = function7;
                    c03002.L$7 = pointerInputChange;
                    c03002.L$8 = job;
                    c03002.label = 3;
                    objWaitForLongPress$default2 = waitForLongPress$default(awaitPointerEventScope2, null, c03002, 1, null);
                    if (objWaitForLongPress$default2 != coroutine_suspended) {
                        Function1<? super Offset, Unit> function212 = function5;
                        function9 = function8;
                        function10 = function6;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        pressGestureScopeImpl3 = pressGestureScopeImpl2;
                        function11 = function212;
                        function12 = function7;
                        longPressResult = (LongPressResult) objWaitForLongPress$default2;
                        if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                            if (longPressResult instanceof LongPressResult.Released) {
                                finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                            } else {
                                if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                finalUpChange = null;
                            }
                            PressGestureScopeImpl pressGestureScopeImpl15 = pressGestureScopeImpl3;
                            coroutineScope3 = coroutineScope2;
                            pressGestureScopeImpl4 = pressGestureScopeImpl15;
                            function16 = function12;
                            function15 = function10;
                            function14 = function11;
                            function13 = function9;
                            awaitPointerEventScope4 = awaitPointerEventScope3;
                            if (finalUpChange == null) {
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                            } else {
                                finalUpChange.consume();
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                            }
                            if (finalUpChange != null) {
                                if (function13 == null) {
                                    c03002.L$0 = awaitPointerEventScope4;
                                    c03002.L$1 = coroutineScope3;
                                    c03002.L$2 = pressGestureScopeImpl4;
                                    c03002.L$3 = function13;
                                    c03002.L$4 = function14;
                                    c03002.L$5 = function15;
                                    c03002.L$6 = function16;
                                    c03002.L$7 = finalUpChange;
                                    c03002.L$8 = jobLaunchAwaitingReset$default;
                                    c03002.label = 5;
                                    objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                                    if (objAwaitSecondDown != coroutine_suspended) {
                                        Function1<? super Offset, Unit> function213 = function16;
                                        pointerInputChange2 = finalUpChange;
                                        objWaitForLongPress$default2 = objAwaitSecondDown;
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        coroutineScope4 = coroutineScope3;
                                        function17 = function13;
                                        function18 = function213;
                                        PressGestureScopeImpl pressGestureScopeImpl16 = pressGestureScopeImpl4;
                                        function19 = function14;
                                        pressGestureScopeImpl5 = pressGestureScopeImpl16;
                                        pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                                        if (pointerInputChange3 != null) {
                                            jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                            if (function15 != NoPressGesture) {
                                                launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                            }
                                            if (function19 == null) {
                                                c03002.L$0 = coroutineScope4;
                                                c03002.L$1 = pressGestureScopeImpl5;
                                                c03002.L$2 = function17;
                                                c03002.L$3 = function18;
                                                c03002.L$4 = jobLaunch$default2;
                                                c03002.L$5 = pointerInputChange2;
                                                c03002.L$6 = null;
                                                c03002.L$7 = null;
                                                c03002.L$8 = null;
                                                c03002.label = 6;
                                                objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                    pointerInputChange5 = pointerInputChange2;
                                                    function20 = function18;
                                                    function22 = function17;
                                                    coroutineScope7 = coroutineScope4;
                                                    finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                        function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                        if (function20 != null) {
                                                            function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                        }
                                                    }
                                                }
                                            } else {
                                                c03002.L$0 = awaitPointerEventScope5;
                                                c03002.L$1 = coroutineScope4;
                                                c03002.L$2 = pressGestureScopeImpl5;
                                                c03002.L$3 = function17;
                                                c03002.L$4 = function19;
                                                c03002.L$5 = function18;
                                                c03002.L$6 = jobLaunch$default2;
                                                c03002.L$7 = pointerInputChange2;
                                                c03002.L$8 = pointerInputChange3;
                                                c03002.label = 7;
                                                objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                                if (objWaitForLongPress$default != coroutine_suspended) {
                                                    PointerInputChange pointerInputChange9 = pointerInputChange2;
                                                    pointerInputChange4 = pointerInputChange3;
                                                    objWaitForLongPress$default2 = objWaitForLongPress$default;
                                                    pointerInputChange5 = pointerInputChange9;
                                                    Function1<? super Offset, Unit> function214 = function19;
                                                    pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                    function20 = function18;
                                                    function21 = function214;
                                                    function22 = function17;
                                                    coroutineScope6 = coroutineScope4;
                                                    awaitPointerEventScope6 = awaitPointerEventScope5;
                                                    longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                    if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                        function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                                        c03002.L$0 = coroutineScope6;
                                                        c03002.L$1 = pressGestureScopeImpl7;
                                                        c03002.L$2 = jobLaunch$default2;
                                                        c03002.L$3 = null;
                                                        c03002.L$4 = null;
                                                        c03002.L$5 = null;
                                                        c03002.L$6 = null;
                                                        c03002.L$7 = null;
                                                        c03002.L$8 = null;
                                                        c03002.label = 8;
                                                        if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                            job3 = jobLaunch$default2;
                                                            pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                            coroutineScope8 = coroutineScope6;
                                                            launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            finalUpChange2 = null;
                                                        }
                                                        pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                        coroutineScope7 = coroutineScope6;
                                                        if (finalUpChange2 != null) {
                                                            finalUpChange2.consume();
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                            function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                            if (function20 != null) {
                                                                function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function18 != null) {
                                            function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                                        }
                                    }
                                } else if (function16 != null) {
                                    function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        function11.invoke(Offset.m7062boximpl(pointerInputChange.getPosition()));
                        c03002.L$0 = coroutineScope2;
                        c03002.L$1 = pressGestureScopeImpl3;
                        c03002.L$2 = job;
                        c03002.L$3 = null;
                        c03002.L$4 = null;
                        c03002.L$5 = null;
                        c03002.L$6 = null;
                        c03002.L$7 = null;
                        c03002.L$8 = null;
                        c03002.label = 4;
                        if (consumeUntilUp(awaitPointerEventScope3, c03002) != coroutine_suspended) {
                            job2 = job;
                            coroutineScope5 = coroutineScope2;
                            pressGestureScopeImpl6 = pressGestureScopeImpl3;
                            launchAwaitingReset$default(coroutineScope5, job2, null, new AnonymousClass3(pressGestureScopeImpl6, null), 2, null);
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                job = (Job) c03002.L$7;
                function16 = (Function1) c03002.L$6;
                function15 = (Function3) c03002.L$5;
                function14 = (Function1) c03002.L$4;
                function13 = (Function1) c03002.L$3;
                pressGestureScopeImpl4 = (PressGestureScopeImpl) c03002.L$2;
                coroutineScope3 = (CoroutineScope) c03002.L$1;
                awaitPointerEventScope4 = (AwaitPointerEventScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                finalUpChange = (PointerInputChange) objWaitForLongPress$default2;
                if (finalUpChange == null) {
                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                } else {
                    finalUpChange.consume();
                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                }
                if (finalUpChange != null) {
                    if (function13 == null) {
                        c03002.L$0 = awaitPointerEventScope4;
                        c03002.L$1 = coroutineScope3;
                        c03002.L$2 = pressGestureScopeImpl4;
                        c03002.L$3 = function13;
                        c03002.L$4 = function14;
                        c03002.L$5 = function15;
                        c03002.L$6 = function16;
                        c03002.L$7 = finalUpChange;
                        c03002.L$8 = jobLaunchAwaitingReset$default;
                        c03002.label = 5;
                        objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                        if (objAwaitSecondDown != coroutine_suspended) {
                            Function1<? super Offset, Unit> function215 = function16;
                            pointerInputChange2 = finalUpChange;
                            objWaitForLongPress$default2 = objAwaitSecondDown;
                            awaitPointerEventScope5 = awaitPointerEventScope4;
                            coroutineScope4 = coroutineScope3;
                            function17 = function13;
                            function18 = function215;
                            PressGestureScopeImpl pressGestureScopeImpl17 = pressGestureScopeImpl4;
                            function19 = function14;
                            pressGestureScopeImpl5 = pressGestureScopeImpl17;
                            pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                            if (pointerInputChange3 != null) {
                                jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                if (function15 != NoPressGesture) {
                                    launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                }
                                if (function19 == null) {
                                    c03002.L$0 = coroutineScope4;
                                    c03002.L$1 = pressGestureScopeImpl5;
                                    c03002.L$2 = function17;
                                    c03002.L$3 = function18;
                                    c03002.L$4 = jobLaunch$default2;
                                    c03002.L$5 = pointerInputChange2;
                                    c03002.L$6 = null;
                                    c03002.L$7 = null;
                                    c03002.L$8 = null;
                                    c03002.label = 6;
                                    objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                    if (objWaitForLongPress$default2 != coroutine_suspended) {
                                        pointerInputChange5 = pointerInputChange2;
                                        function20 = function18;
                                        function22 = function17;
                                        coroutineScope7 = coroutineScope4;
                                        finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                        if (finalUpChange2 != null) {
                                            finalUpChange2.consume();
                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                            function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                        } else {
                                            launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                            if (function20 != null) {
                                                function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                            }
                                        }
                                    }
                                } else {
                                    c03002.L$0 = awaitPointerEventScope5;
                                    c03002.L$1 = coroutineScope4;
                                    c03002.L$2 = pressGestureScopeImpl5;
                                    c03002.L$3 = function17;
                                    c03002.L$4 = function19;
                                    c03002.L$5 = function18;
                                    c03002.L$6 = jobLaunch$default2;
                                    c03002.L$7 = pointerInputChange2;
                                    c03002.L$8 = pointerInputChange3;
                                    c03002.label = 7;
                                    objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                    if (objWaitForLongPress$default != coroutine_suspended) {
                                        PointerInputChange pointerInputChange10 = pointerInputChange2;
                                        pointerInputChange4 = pointerInputChange3;
                                        objWaitForLongPress$default2 = objWaitForLongPress$default;
                                        pointerInputChange5 = pointerInputChange10;
                                        Function1<? super Offset, Unit> function216 = function19;
                                        pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                        function20 = function18;
                                        function21 = function216;
                                        function22 = function17;
                                        coroutineScope6 = coroutineScope4;
                                        awaitPointerEventScope6 = awaitPointerEventScope5;
                                        longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                        if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                            function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                            c03002.L$0 = coroutineScope6;
                                            c03002.L$1 = pressGestureScopeImpl7;
                                            c03002.L$2 = jobLaunch$default2;
                                            c03002.L$3 = null;
                                            c03002.L$4 = null;
                                            c03002.L$5 = null;
                                            c03002.L$6 = null;
                                            c03002.L$7 = null;
                                            c03002.L$8 = null;
                                            c03002.label = 8;
                                            if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                job3 = jobLaunch$default2;
                                                pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                coroutineScope8 = coroutineScope6;
                                                launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                finalUpChange2 = null;
                                            }
                                            pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                            coroutineScope7 = coroutineScope6;
                                            if (finalUpChange2 != null) {
                                                finalUpChange2.consume();
                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                            } else {
                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                if (function20 != null) {
                                                    function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (function18 != null) {
                                function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                            }
                        }
                        return coroutine_suspended;
                    }
                    if (function16 != null) {
                        function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                    }
                }
                return Unit.INSTANCE;
            case 3:
                job = (Job) c03002.L$8;
                pointerInputChange = (PointerInputChange) c03002.L$7;
                function12 = (Function1) c03002.L$6;
                function10 = (Function3) c03002.L$5;
                function11 = (Function1) c03002.L$4;
                Function1<? super Offset, Unit> function31 = (Function1) c03002.L$3;
                pressGestureScopeImpl3 = (PressGestureScopeImpl) c03002.L$2;
                CoroutineScope coroutineScope9 = (CoroutineScope) c03002.L$1;
                awaitPointerEventScope3 = (AwaitPointerEventScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                function9 = function31;
                coroutineScope2 = coroutineScope9;
                longPressResult = (LongPressResult) objWaitForLongPress$default2;
                if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                    if (longPressResult instanceof LongPressResult.Released) {
                        finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                    } else {
                        if (!(longPressResult instanceof LongPressResult.Canceled)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        finalUpChange = null;
                    }
                    PressGestureScopeImpl pressGestureScopeImpl18 = pressGestureScopeImpl3;
                    coroutineScope3 = coroutineScope2;
                    pressGestureScopeImpl4 = pressGestureScopeImpl18;
                    function16 = function12;
                    function15 = function10;
                    function14 = function11;
                    function13 = function9;
                    awaitPointerEventScope4 = awaitPointerEventScope3;
                    if (finalUpChange == null) {
                        jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass4(pressGestureScopeImpl4, null), 2, null);
                    } else {
                        finalUpChange.consume();
                        jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new AnonymousClass5(pressGestureScopeImpl4, null), 2, null);
                    }
                    if (finalUpChange != null) {
                        if (function13 == null) {
                            c03002.L$0 = awaitPointerEventScope4;
                            c03002.L$1 = coroutineScope3;
                            c03002.L$2 = pressGestureScopeImpl4;
                            c03002.L$3 = function13;
                            c03002.L$4 = function14;
                            c03002.L$5 = function15;
                            c03002.L$6 = function16;
                            c03002.L$7 = finalUpChange;
                            c03002.L$8 = jobLaunchAwaitingReset$default;
                            c03002.label = 5;
                            objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c03002);
                            if (objAwaitSecondDown != coroutine_suspended) {
                                Function1<? super Offset, Unit> function217 = function16;
                                pointerInputChange2 = finalUpChange;
                                objWaitForLongPress$default2 = objAwaitSecondDown;
                                awaitPointerEventScope5 = awaitPointerEventScope4;
                                coroutineScope4 = coroutineScope3;
                                function17 = function13;
                                function18 = function217;
                                PressGestureScopeImpl pressGestureScopeImpl19 = pressGestureScopeImpl4;
                                function19 = function14;
                                pressGestureScopeImpl5 = pressGestureScopeImpl19;
                                pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                                if (pointerInputChange3 != null) {
                                    jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                    if (function15 != NoPressGesture) {
                                        launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                    }
                                    if (function19 == null) {
                                        c03002.L$0 = coroutineScope4;
                                        c03002.L$1 = pressGestureScopeImpl5;
                                        c03002.L$2 = function17;
                                        c03002.L$3 = function18;
                                        c03002.L$4 = jobLaunch$default2;
                                        c03002.L$5 = pointerInputChange2;
                                        c03002.L$6 = null;
                                        c03002.L$7 = null;
                                        c03002.L$8 = null;
                                        c03002.label = 6;
                                        objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                                            pointerInputChange5 = pointerInputChange2;
                                            function20 = function18;
                                            function22 = function17;
                                            coroutineScope7 = coroutineScope4;
                                            finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                                            if (finalUpChange2 != null) {
                                                finalUpChange2.consume();
                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                            } else {
                                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                if (function20 != null) {
                                                    function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                }
                                            }
                                        }
                                    } else {
                                        c03002.L$0 = awaitPointerEventScope5;
                                        c03002.L$1 = coroutineScope4;
                                        c03002.L$2 = pressGestureScopeImpl5;
                                        c03002.L$3 = function17;
                                        c03002.L$4 = function19;
                                        c03002.L$5 = function18;
                                        c03002.L$6 = jobLaunch$default2;
                                        c03002.L$7 = pointerInputChange2;
                                        c03002.L$8 = pointerInputChange3;
                                        c03002.label = 7;
                                        objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                                        if (objWaitForLongPress$default != coroutine_suspended) {
                                            PointerInputChange pointerInputChange11 = pointerInputChange2;
                                            pointerInputChange4 = pointerInputChange3;
                                            objWaitForLongPress$default2 = objWaitForLongPress$default;
                                            pointerInputChange5 = pointerInputChange11;
                                            Function1<? super Offset, Unit> function218 = function19;
                                            pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                            function20 = function18;
                                            function21 = function218;
                                            function22 = function17;
                                            coroutineScope6 = coroutineScope4;
                                            awaitPointerEventScope6 = awaitPointerEventScope5;
                                            longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                            if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                                c03002.L$0 = coroutineScope6;
                                                c03002.L$1 = pressGestureScopeImpl7;
                                                c03002.L$2 = jobLaunch$default2;
                                                c03002.L$3 = null;
                                                c03002.L$4 = null;
                                                c03002.L$5 = null;
                                                c03002.L$6 = null;
                                                c03002.L$7 = null;
                                                c03002.L$8 = null;
                                                c03002.label = 8;
                                                if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                                    job3 = jobLaunch$default2;
                                                    pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                    coroutineScope8 = coroutineScope6;
                                                    launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                    finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    finalUpChange2 = null;
                                                }
                                                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                coroutineScope7 = coroutineScope6;
                                                if (finalUpChange2 != null) {
                                                    finalUpChange2.consume();
                                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                                    function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                                } else {
                                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                                    if (function20 != null) {
                                                        function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (function18 != null) {
                                    function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                                }
                            }
                        } else if (function16 != null) {
                            function16.invoke(Offset.m7062boximpl(finalUpChange.getPosition()));
                        }
                    }
                    return Unit.INSTANCE;
                }
                function11.invoke(Offset.m7062boximpl(pointerInputChange.getPosition()));
                c03002.L$0 = coroutineScope2;
                c03002.L$1 = pressGestureScopeImpl3;
                c03002.L$2 = job;
                c03002.L$3 = null;
                c03002.L$4 = null;
                c03002.L$5 = null;
                c03002.L$6 = null;
                c03002.L$7 = null;
                c03002.L$8 = null;
                c03002.label = 4;
                if (consumeUntilUp(awaitPointerEventScope3, c03002) != coroutine_suspended) {
                    job2 = job;
                    coroutineScope5 = coroutineScope2;
                    pressGestureScopeImpl6 = pressGestureScopeImpl3;
                    launchAwaitingReset$default(coroutineScope5, job2, null, new AnonymousClass3(pressGestureScopeImpl6, null), 2, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 4:
                job2 = (Job) c03002.L$2;
                pressGestureScopeImpl6 = (PressGestureScopeImpl) c03002.L$1;
                coroutineScope5 = (CoroutineScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                launchAwaitingReset$default(coroutineScope5, job2, null, new AnonymousClass3(pressGestureScopeImpl6, null), 2, null);
                return Unit.INSTANCE;
            case 5:
                jobLaunchAwaitingReset$default = (Job) c03002.L$8;
                pointerInputChange2 = (PointerInputChange) c03002.L$7;
                Function1<? super Offset, Unit> function32 = (Function1) c03002.L$6;
                Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function33 = (Function3) c03002.L$5;
                Function1<? super Offset, Unit> function34 = (Function1) c03002.L$4;
                Function1<? super Offset, Unit> function35 = (Function1) c03002.L$3;
                PressGestureScopeImpl pressGestureScopeImpl20 = (PressGestureScopeImpl) c03002.L$2;
                coroutineScope4 = (CoroutineScope) c03002.L$1;
                awaitPointerEventScope5 = (AwaitPointerEventScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                function18 = function32;
                function15 = function33;
                pressGestureScopeImpl5 = pressGestureScopeImpl20;
                function17 = function35;
                function19 = function34;
                pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default2;
                if (pointerInputChange3 != null) {
                    jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new AnonymousClass6(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                    if (function15 != NoPressGesture) {
                        launchAwaitingReset$default(coroutineScope4, jobLaunch$default2, null, new AnonymousClass7(function15, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                    }
                    if (function19 == null) {
                        c03002.L$0 = coroutineScope4;
                        c03002.L$1 = pressGestureScopeImpl5;
                        c03002.L$2 = function17;
                        c03002.L$3 = function18;
                        c03002.L$4 = jobLaunch$default2;
                        c03002.L$5 = pointerInputChange2;
                        c03002.L$6 = null;
                        c03002.L$7 = null;
                        c03002.L$8 = null;
                        c03002.label = 6;
                        objWaitForLongPress$default2 = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c03002, 1, null);
                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                            pointerInputChange5 = pointerInputChange2;
                            function20 = function18;
                            function22 = function17;
                            coroutineScope7 = coroutineScope4;
                            finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                            if (finalUpChange2 != null) {
                                finalUpChange2.consume();
                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                            } else {
                                launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                if (function20 != null) {
                                    function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                }
                            }
                        }
                    } else {
                        c03002.L$0 = awaitPointerEventScope5;
                        c03002.L$1 = coroutineScope4;
                        c03002.L$2 = pressGestureScopeImpl5;
                        c03002.L$3 = function17;
                        c03002.L$4 = function19;
                        c03002.L$5 = function18;
                        c03002.L$6 = jobLaunch$default2;
                        c03002.L$7 = pointerInputChange2;
                        c03002.L$8 = pointerInputChange3;
                        c03002.label = 7;
                        objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, c03002, 1, null);
                        if (objWaitForLongPress$default != coroutine_suspended) {
                            PointerInputChange pointerInputChange12 = pointerInputChange2;
                            pointerInputChange4 = pointerInputChange3;
                            objWaitForLongPress$default2 = objWaitForLongPress$default;
                            pointerInputChange5 = pointerInputChange12;
                            Function1<? super Offset, Unit> function219 = function19;
                            pressGestureScopeImpl7 = pressGestureScopeImpl5;
                            function20 = function18;
                            function21 = function219;
                            function22 = function17;
                            coroutineScope6 = coroutineScope4;
                            awaitPointerEventScope6 = awaitPointerEventScope5;
                            longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                            if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                                c03002.L$0 = coroutineScope6;
                                c03002.L$1 = pressGestureScopeImpl7;
                                c03002.L$2 = jobLaunch$default2;
                                c03002.L$3 = null;
                                c03002.L$4 = null;
                                c03002.L$5 = null;
                                c03002.L$6 = null;
                                c03002.L$7 = null;
                                c03002.L$8 = null;
                                c03002.label = 8;
                                if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                                    job3 = jobLaunch$default2;
                                    pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                    coroutineScope8 = coroutineScope6;
                                    launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                if (longPressResult2 instanceof LongPressResult.Released) {
                                    finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                } else {
                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    finalUpChange2 = null;
                                }
                                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                coroutineScope7 = coroutineScope6;
                                if (finalUpChange2 != null) {
                                    finalUpChange2.consume();
                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                                    function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                                } else {
                                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                                    if (function20 != null) {
                                        function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (function18 != null) {
                    function18.invoke(Offset.m7062boximpl(pointerInputChange2.getPosition()));
                }
                return Unit.INSTANCE;
            case 6:
                pointerInputChange5 = (PointerInputChange) c03002.L$5;
                jobLaunch$default2 = (Job) c03002.L$4;
                function20 = (Function1) c03002.L$3;
                function22 = (Function1) c03002.L$2;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c03002.L$1;
                coroutineScope7 = (CoroutineScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                finalUpChange2 = (PointerInputChange) objWaitForLongPress$default2;
                if (finalUpChange2 != null) {
                    finalUpChange2.consume();
                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                    function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                } else {
                    launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                    if (function20 != null) {
                        function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                    }
                }
                return Unit.INSTANCE;
            case 7:
                PointerInputChange pointerInputChange13 = (PointerInputChange) c03002.L$8;
                PointerInputChange pointerInputChange14 = (PointerInputChange) c03002.L$7;
                Job job4 = (Job) c03002.L$6;
                function20 = (Function1) c03002.L$5;
                function21 = (Function1) c03002.L$4;
                function22 = (Function1) c03002.L$3;
                pressGestureScopeImpl7 = (PressGestureScopeImpl) c03002.L$2;
                coroutineScope6 = (CoroutineScope) c03002.L$1;
                awaitPointerEventScope6 = (AwaitPointerEventScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                pointerInputChange4 = pointerInputChange13;
                jobLaunch$default2 = job4;
                pointerInputChange5 = pointerInputChange14;
                longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                    if (longPressResult2 instanceof LongPressResult.Released) {
                        finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                    } else {
                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                            throw new NoWhenBranchMatchedException();
                        }
                        finalUpChange2 = null;
                    }
                    pressGestureScopeImpl5 = pressGestureScopeImpl7;
                    coroutineScope7 = coroutineScope6;
                    if (finalUpChange2 != null) {
                        finalUpChange2.consume();
                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass8(pressGestureScopeImpl5, null), 2, null);
                        function22.invoke(Offset.m7062boximpl(finalUpChange2.getPosition()));
                    } else {
                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default2, null, new AnonymousClass9(pressGestureScopeImpl5, null), 2, null);
                        if (function20 != null) {
                            function20.invoke(Offset.m7062boximpl(pointerInputChange5.getPosition()));
                        }
                    }
                    return Unit.INSTANCE;
                }
                function21.invoke(Offset.m7062boximpl(pointerInputChange4.getPosition()));
                c03002.L$0 = coroutineScope6;
                c03002.L$1 = pressGestureScopeImpl7;
                c03002.L$2 = jobLaunch$default2;
                c03002.L$3 = null;
                c03002.L$4 = null;
                c03002.L$5 = null;
                c03002.L$6 = null;
                c03002.L$7 = null;
                c03002.L$8 = null;
                c03002.label = 8;
                if (consumeUntilUp(awaitPointerEventScope6, c03002) != coroutine_suspended) {
                    job3 = jobLaunch$default2;
                    pressGestureScopeImpl8 = pressGestureScopeImpl7;
                    coroutineScope8 = coroutineScope6;
                    launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 8:
                job3 = (Job) c03002.L$2;
                pressGestureScopeImpl8 = (PressGestureScopeImpl) c03002.L$1;
                coroutineScope8 = (CoroutineScope) c03002.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default2);
                launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2", f = "TapGestureDetector.kt", i = {}, l = {WebmConstants.MkvEbmlElement.FLAG_DEFAULT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputChange $down;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03012(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C03012> continuation) {
            super(2, continuation);
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$down = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03012(this.$onPress, this.$pressScope, this.$down, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                Offset offsetM7062boximpl = Offset.m7062boximpl(this.$down.getPosition());
                this.label = 1;
                if (function3.invoke(pressGestureScopeImpl, offsetM7062boximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$4, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$5, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$5", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$6, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$6", f = "TapGestureDetector.kt", i = {}, l = {184, 185}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $cancelOrReleaseJob;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$cancelOrReleaseJob = job;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$cancelOrReleaseJob, this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        
            if (r4.$pressScope.reset(r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3d
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L2f
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                kotlinx.coroutines.Job r5 = r4.$cancelOrReleaseJob
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.join(r1)
                if (r5 != r0) goto L2f
                goto L3c
            L2f:
                androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r4.$pressScope
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r4 = r5.reset(r1)
                if (r4 != r0) goto L3d
            L3c:
                return r0
            L3d:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$7, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$7", f = "TapGestureDetector.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputChange $secondDown;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass7(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$secondDown = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$onPress, this.$pressScope, this.$secondDown, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                Offset offsetM7062boximpl = Offset.m7062boximpl(this.$secondDown.getPosition());
                this.label = 1;
                if (function3.invoke(pressGestureScopeImpl, offsetM7062boximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$8, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$8", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$9, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$9", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass9(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056 A[LOOP:0: B:19:0x0054->B:20:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c A[LOOP:1: B:22:0x006d->B:26:0x007c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x006f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C02961
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C02961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
        L39:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L45
            return r1
        L45:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L54:
            if (r6 >= r4) goto L62
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L54
        L62:
            java.util.List r9 = r9.getChanges()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        L6d:
            if (r5 >= r2) goto L7f
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.getPressed()
            if (r4 == 0) goto L7c
            goto L39
        L7c:
            int r5 = r5 + 1
            goto L6d
        L7f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {254}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"}, v = 1)
    static final class C02952 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02952(PointerInputChange pointerInputChange, Continuation<? super C02952> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02952 c02952 = new C02952(this.$firstUp, continuation);
            c02952.L$0 = obj;
            return c02952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C02952) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0048 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0053 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0046 -> B:12:0x0049). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
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
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                long r3 = r11.J$0
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r5 = r1
                goto L49
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                androidx.compose.ui.input.pointer.PointerInputChange r1 = r11.$firstUp
                long r3 = r1.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r1 = r12.getViewConfiguration()
                long r5 = r1.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r5 = r12
            L35:
                r8 = r11
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r11.L$0 = r5
                r11.J$0 = r3
                r11.label = r2
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L49
                return r0
            L49:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                long r6 = r12.getUptimeMillis()
                int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r1 < 0) goto L35
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C02952.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new C02952(pointerInputChange, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {TiffUtil.TIFF_TAG_ORIENTATION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02972(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C02972> continuation) {
            super(2, continuation);
            this.$this_detectTapAndPress = pointerInputScope;
            this.$onPress = function3;
            this.$onTap = function1;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02972 c02972 = new C02972(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, continuation);
            c02972.L$0 = obj;
            return c02972;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {0, 0, 1}, l = {277, 283}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "resetJob", "resetJob"}, s = {"L$0", "L$1", "L$0"}, v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onTap = function1;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x008d, code lost:
            
                if (r13 == r0) goto L18;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 206
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C02972.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00261(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C00261> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00261(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM7062boximpl = Offset.m7062boximpl(this.$down.getPosition());
                        this.label = 1;
                        if (function3.invoke(pressGestureScopeImpl, offsetM7062boximpl, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00272(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00272> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00272(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndPress, new AnonymousClass1(coroutineScope, this.$onPress, this.$onTap, this.$pressScope, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C02972(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation) {
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, boolean r8, androidx.compose.ui.input.pointer.PointerEventPass r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r8 = (androidx.compose.ui.input.pointer.PointerEventPass) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L52
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.throwOnFailure(r10)
        L43:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r10 = r7.awaitPointerEvent(r9, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = isChangedToDown$default(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L43
            java.util.List r7 = r10.getChanges()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r5 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r6 = (androidx.compose.ui.input.pointer.PointerEventPass) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L52
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
        L43:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            boolean r2 = isChangedToDown(r8, r6, r3)
            if (r2 == 0) goto L43
            java.util.List r5 = r8.getChanges()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitPrimaryFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent pointerEvent, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
        }
        return isChangedToDown(pointerEvent, z, z2);
    }

    public static final boolean isChangedToDown(PointerEvent pointerEvent, boolean z, boolean z2) {
        if (z2) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!PointerType.m8748equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m8753getMouseT8wyACA())) {
                        break;
                    }
                    i++;
                } else {
                    if (PointerEvent_androidKt.m8645isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                        break;
                    }
                    return false;
                }
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = changes2.get(i2);
            if (!(z ? PointerEventKt.changedToDown(pointerInputChange) : PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:28:0x009c  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ed A[LOOP:1: B:23:0x0080->B:45:0x00ed, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ba A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c7 -> B:13:0x0038). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, androidx.compose.ui.input.pointer.PointerEventPass r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r19) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    public static final Object waitForLongPress(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super LongPressResult> continuation) {
        C03021 c03021;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C03021) {
            c03021 = (C03021) continuation;
            if ((c03021.label & Integer.MIN_VALUE) != 0) {
                c03021.label -= Integer.MIN_VALUE;
            } else {
                c03021 = new C03021(continuation);
            }
        } else {
            c03021 = new C03021(continuation);
        }
        Object obj = c03021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03021.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = LongPressResult.Canceled.INSTANCE;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                C03032 c03032 = new C03032(pointerEventPass, objectRef2, null);
                c03021.L$0 = objectRef2;
                c03021.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, c03032, c03021) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) c03021.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return objectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForLongPress(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {MediaError.DetailedErrorCode.HLS_MANIFEST_PLAYLIST, 435}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"}, v = 1)
    static final class C03032 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03032(PointerEventPass pointerEventPass, Ref.ObjectRef<LongPressResult> objectRef, Continuation<? super C03032> continuation) {
            super(2, continuation);
            this.$pass = pointerEventPass;
            this.$result = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03032 c03032 = new C03032(this.$pass, this.$result, continuation);
            c03032.L$0 = obj;
            return c03032;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03032) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0053  */
        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
        /* JADX WARN: Code duplicated, block: B:22:0x006d  */
        /* JADX WARN: Code duplicated, block: B:26:0x0087  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d9 A[LOOP:1: B:16:0x0051->B:41:0x00d9, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:47:0x00dd A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:50:0x0099 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Released] */
        /* JADX WARN: Type inference failed for: r14v11, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r14v12, types: [T, androidx.compose.foundation.gestures.LongPressResult$Success] */
        /* JADX WARN: Type inference failed for: r14v19, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ad -> B:34:0x00b0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 243
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C03032.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return launchAwaitingReset(coroutineScope, job, coroutineStart, function2);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1", f = "TapGestureDetector.kt", i = {0}, l = {474, 475}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Job $resetJob;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02991(Job job, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C02991> continuation) {
            super(2, continuation);
            this.$resetJob = job;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02991 c02991 = new C02991(this.$resetJob, this.$block, continuation);
            c02991.L$0 = obj;
            return c02991;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        
            if (r6.invoke(r1, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3a
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlinx.coroutines.Job r6 = r5.$resetJob
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.join(r4)
                if (r6 != r0) goto L3a
                goto L47
            L3a:
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r5.$block
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = r6.invoke(r1, r5)
                if (r5 != r0) goto L48
            L47:
                return r0
            L48:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C02991.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final Job launchAwaitingReset(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new C02991(job, function2, null), 1, null);
    }
}
