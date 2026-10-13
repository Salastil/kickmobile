package androidx.camera.camera2.pipe.core;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: Mutexes.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000b\u001a@\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0080H¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0011*\u00020\u0012H\u0080H¢\u0006\u0002\u0010\u0013\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0011*\u00020\u0012H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u000e*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001a&\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0082H¢\u0006\u0002\u0010\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u000e*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013¨\u0006\u001c"}, d2 = {"withLockAsync", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/core/CoroutineMutex;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/camera/camera2/pipe/core/CoroutineMutex;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "withLockLaunch", "Lkotlinx/coroutines/Job;", "", "(Landroidx/camera/camera2/pipe/core/CoroutineMutex;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "acquireToken", "Landroidx/camera/camera2/pipe/core/Token;", "Lkotlinx/coroutines/sync/Mutex;", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireTokenAndSuspend", "tryAcquireToken", "lockWithoutOwner", "withLockSuspend", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockAndSuspend", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MutexesKt {

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.MutexesKt$acquireToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: Mutexes.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.MutexesKt", f = "Mutexes.kt", i = {0}, l = {98}, m = "acquireToken", n = {"$this$acquireToken"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MutexesKt.acquireToken(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.MutexesKt$acquireTokenAndSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Mutexes.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.MutexesKt", f = "Mutexes.kt", i = {0}, l = {107}, m = "acquireTokenAndSuspend", n = {"$this$acquireTokenAndSuspend"}, s = {"L$0"}, v = 1)
    static final class C02091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02091(Continuation<? super C02091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MutexesKt.acquireTokenAndSuspend(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.MutexesKt$withLockAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Mutexes.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.MutexesKt$withLockAsync$1", f = "Mutexes.kt", i = {0, 1}, l = {177, EACTags.DISPLAY_IMAGE}, m = "invokeSuspend", n = {"$this$withLockSuspend$iv", "$this$withLockSuspend$iv"}, s = {"L$0", "L$0"}, v = 1)
    static final class C02101<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> $block;
        final /* synthetic */ CoroutineMutex $this_withLockAsync;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02101(CoroutineMutex coroutineMutex, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C02101> continuation) {
            super(2, continuation);
            this.$this_withLockAsync = coroutineMutex;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02101 c02101 = new C02101(this.$this_withLockAsync, this.$block, continuation);
            c02101.L$0 = obj;
            return c02101;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C02101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super T>, Object> function2;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScopeKt.ensureActive((CoroutineScope) this.L$0);
                    mutex = this.$this_withLockAsync.getMutex();
                    function2 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = function2;
                    this.label = 1;
                    if (MutexesKt.lockAndSuspend(mutex, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                        throw th;
                    }
                }
                function2 = (Function2) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(function2, this);
                if (objCoroutineScope != coroutine_suspended) {
                    Mutex mutex4 = mutex;
                    obj = objCoroutineScope;
                    mutex2 = mutex4;
                    Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex5 = mutex;
                th = th3;
                mutex2 = mutex5;
                Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                throw th;
            }
        }
    }

    public static final <T> Deferred<T> withLockAsync(CoroutineMutex coroutineMutex, CoroutineScope scope, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineMutex, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.async$default(scope, null, CoroutineStart.UNDISPATCHED, new C02101(coroutineMutex, block, null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.MutexesKt$withLockLaunch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Mutexes.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.MutexesKt$withLockLaunch$1", f = "Mutexes.kt", i = {0, 1}, l = {177, RotationOptions.ROTATE_90}, m = "invokeSuspend", n = {"$this$withLockSuspend$iv", "$this$withLockSuspend$iv"}, s = {"L$0", "L$0"}, v = 1)
    static final class C02111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineMutex $this_withLockLaunch;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02111(CoroutineMutex coroutineMutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C02111> continuation) {
            super(2, continuation);
            this.$this_withLockLaunch = coroutineMutex;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02111 c02111 = new C02111(this.$this_withLockLaunch, this.$block, continuation);
            c02111.L$0 = obj;
            return c02111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScopeKt.ensureActive((CoroutineScope) this.L$0);
                    mutex = this.$this_withLockLaunch.getMutex();
                    function2 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = function2;
                    this.label = 1;
                    if (MutexesKt.lockAndSuspend(mutex, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                        throw th;
                    }
                }
                function2 = (Function2) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(function2, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                throw th;
            }
        }
    }

    public static final Job withLockLaunch(CoroutineMutex coroutineMutex, CoroutineScope scope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineMutex, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.launch$default(scope, null, CoroutineStart.UNDISPATCHED, new C02111(coroutineMutex, block, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object acquireToken(Mutex mutex, Continuation<? super Token> continuation) {
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
            anonymousClass1.L$0 = mutex;
            anonymousClass1.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, anonymousClass1, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new MutexToken(mutex);
    }

    private static final Object acquireToken$$forInline(Mutex mutex, Continuation<? super Token> continuation) {
        Mutex.DefaultImpls.lock$default(mutex, null, continuation, 1, null);
        return new MutexToken(mutex);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object acquireTokenAndSuspend(Mutex mutex, Continuation<? super Token> continuation) {
        C02091 c02091;
        if (continuation instanceof C02091) {
            c02091 = (C02091) continuation;
            if ((c02091.label & Integer.MIN_VALUE) != 0) {
                c02091.label -= Integer.MIN_VALUE;
            } else {
                c02091 = new C02091(continuation);
            }
        } else {
            c02091 = new C02091(continuation);
        }
        Object obj = c02091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c02091.L$0 = mutex;
            c02091.label = 1;
            if (lockAndSuspend(mutex, c02091) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c02091.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new MutexToken(mutex);
    }

    private static final Object acquireTokenAndSuspend$$forInline(Mutex mutex, Continuation<? super Token> continuation) {
        lockAndSuspend(mutex, continuation);
        return new MutexToken(mutex);
    }

    public static final Token tryAcquireToken(Mutex mutex) {
        Intrinsics.checkNotNullParameter(mutex, "<this>");
        if (Mutex.DefaultImpls.tryLock$default(mutex, null, 1, null)) {
            return new MutexToken(mutex);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object lockWithoutOwner(Mutex mutex, Continuation<? super Unit> continuation) {
        Object objLock = mutex.lock(null, continuation);
        return objLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLock : Unit.INSTANCE;
    }

    private static final <T> Object withLockSuspend(Mutex mutex, Function0<? extends T> function0, Continuation<? super T> continuation) {
        lockAndSuspend(mutex, continuation);
        try {
            return function0.invoke();
        } finally {
            Mutex.DefaultImpls.unlock$default(mutex, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object lockAndSuspend(Mutex mutex, Continuation<? super Unit> continuation) {
        MutexesKt$lockAndSuspend$lockFn$1 mutexesKt$lockAndSuspend$lockFn$1 = MutexesKt$lockAndSuspend$lockFn$1.INSTANCE;
        if ((!(mutexesKt$lockAndSuspend$lockFn$1 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(mutexesKt$lockAndSuspend$lockFn$1, mutex, continuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(mutexesKt$lockAndSuspend$lockFn$1, 2)).invoke(mutex, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(continuation);
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.INSTANCE;
            continuationIntercepted.resumeWith(Result.m12684constructorimpl(unit));
        }
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
