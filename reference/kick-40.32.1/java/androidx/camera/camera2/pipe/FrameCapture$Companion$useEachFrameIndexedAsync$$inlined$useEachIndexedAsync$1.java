package androidx.camera.camera2.pipe;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.cast.MediaError;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: AutoCloseables.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/pipe/core/AutoCloseables$useEachIndexedAsync$deferred$1"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
@DebugMetadata(c = "androidx.camera.camera2.pipe.FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1", f = "Frame.kt", i = {0}, l = {103, 107}, m = "invokeSuspend", n = {"it"}, s = {"L$1"}, v = 1)
public final class FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function4 $action$inlined;
    final /* synthetic */ AutoCloseable $closeable;
    final /* synthetic */ int $i;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1(AutoCloseable autoCloseable, int i, Continuation continuation, Function4 function4) {
        super(2, continuation);
        this.$closeable = autoCloseable;
        this.$i = i;
        this.$action$inlined = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1(this.$closeable, this.$i, continuation, this.$action$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        AutoCloseable autoCloseable = this.$closeable;
        int i = this.$i;
        try {
            YieldKt.yield(this);
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(i, autoCloseable, null, this.$action$inlined), this);
            AutoCloseableKt.closeFinally(autoCloseable, null);
            return objCoroutineScope;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoCloseables.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/pipe/core/AutoCloseables$useEachIndexedAsync$deferred$1$1$1"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1$1", f = "Frame.kt", i = {0, 0, 0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE}, m = "invokeSuspend", n = {"capture", "$this$useEachFrameIndexedAsync_u24lambda_u240", "idx"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function4 $action$inlined;
        final /* synthetic */ int $i;
        final /* synthetic */ AutoCloseable $it;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, AutoCloseable autoCloseable, Continuation continuation, Function4 function4) {
            super(2, continuation);
            this.$i = i;
            this.$it = autoCloseable;
            this.$action$inlined = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$i, this.$it, continuation, this.$action$inlined);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.$i;
            FrameCapture frameCapture = (FrameCapture) this.$it;
            AutoCloseable autoCloseable = (AutoCloseable) frameCapture.awaitFrame(this);
            try {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) frameCapture);
                Object objInvoke = this.$action$inlined.invoke(coroutineScope, Integer.valueOf(i), (Frame) autoCloseable, this);
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return objInvoke;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th2;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            FrameCapture frameCapture;
            CoroutineScope coroutineScope;
            AutoCloseable autoCloseable;
            Throwable th;
            AutoCloseable autoCloseable2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    i = this.$i;
                    frameCapture = (FrameCapture) this.$it;
                    this.L$0 = frameCapture;
                    this.L$1 = coroutineScope2;
                    this.I$0 = i;
                    this.label = 1;
                    Object objAwaitFrame = frameCapture.awaitFrame(this);
                    if (objAwaitFrame != coroutine_suspended) {
                        coroutineScope = coroutineScope2;
                        obj = objAwaitFrame;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    autoCloseable2 = (AutoCloseable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            AutoCloseableKt.closeFinally(autoCloseable2, th);
                            throw th3;
                        }
                    }
                }
                i = this.I$0;
                coroutineScope = (CoroutineScope) this.L$1;
                frameCapture = (FrameCapture) this.L$0;
                ResultKt.throwOnFailure(obj);
                UByte$$ExternalSyntheticBackport0.m12761m((Object) frameCapture);
                Function4 function4 = this.$action$inlined;
                Integer numBoxInt = Boxing.boxInt(i);
                this.L$0 = autoCloseable;
                this.L$1 = null;
                this.label = 2;
                Object objInvoke = function4.invoke(coroutineScope, numBoxInt, (Frame) autoCloseable, this);
                if (objInvoke != coroutine_suspended) {
                    obj = objInvoke;
                    autoCloseable2 = autoCloseable;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                autoCloseable2 = autoCloseable;
                throw th;
            }
            autoCloseable = (AutoCloseable) obj;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AutoCloseable autoCloseable;
        int i;
        AutoCloseable autoCloseable2;
        Throwable th;
        AutoCloseable autoCloseable3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.I$0;
                autoCloseable2 = (AutoCloseable) this.L$1;
                AutoCloseable autoCloseable4 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    autoCloseable = autoCloseable4;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable3 = autoCloseable4;
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable3 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    AutoCloseableKt.closeFinally(autoCloseable3, null);
                    return obj;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(autoCloseable3, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj);
        autoCloseable = this.$closeable;
        i = this.$i;
        try {
            this.L$0 = autoCloseable;
            this.L$1 = autoCloseable;
            this.I$0 = i;
            this.label = 1;
            if (YieldKt.yield(this) != coroutine_suspended) {
                autoCloseable2 = autoCloseable;
            }
            return coroutine_suspended;
        } catch (Throwable th5) {
            AutoCloseable autoCloseable5 = autoCloseable;
            th = th5;
            autoCloseable3 = autoCloseable5;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i, autoCloseable2, null, this.$action$inlined);
        this.L$0 = autoCloseable;
        this.L$1 = null;
        this.label = 2;
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(anonymousClass1, this);
        if (objCoroutineScope != coroutine_suspended) {
            AutoCloseable autoCloseable6 = autoCloseable;
            obj = objCoroutineScope;
            autoCloseable3 = autoCloseable6;
            AutoCloseableKt.closeFinally(autoCloseable3, null);
            return obj;
        }
        return coroutine_suspended;
    }
}
