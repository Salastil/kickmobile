package androidx.camera.camera2.pipe.core;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WakeLock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0007J\r\u0010\u0016\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\nH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/core/WakeLock;", "", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", InstrumentationTags.TIMEOUT, "", "startTimeoutOnCreation", "", "callback", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;JZLkotlin/jvm/functions/Function0;)V", "lock", "count", "", "timeoutJob", "Lkotlinx/coroutines/Job;", "closed", "acquire", "Landroidx/camera/camera2/pipe/core/Token;", "release", "releaseToken", "releaseToken$camera_camera2_pipe", "startTimeout", "WakeLockToken", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeLock {
    private final Function0<Unit> callback;
    private boolean closed;
    private int count;
    private final Object lock;
    private final CoroutineScope scope;
    private final boolean startTimeoutOnCreation;
    private final long timeout;
    private Job timeoutJob;

    public WakeLock(CoroutineScope scope, long j, boolean z, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.scope = scope;
        this.timeout = j;
        this.startTimeoutOnCreation = z;
        this.callback = callback;
        Object obj = new Object();
        this.lock = obj;
        if (z) {
            synchronized (obj) {
                startTimeout();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public /* synthetic */ WakeLock(CoroutineScope coroutineScope, long j, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z, function0);
    }

    /* JADX INFO: compiled from: WakeLock.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/core/WakeLock$WakeLockToken;", "Landroidx/camera/camera2/pipe/core/Token;", "<init>", "(Landroidx/camera/camera2/pipe/core/WakeLock;)V", "_released", "Lkotlinx/atomicfu/AtomicBoolean;", "released", "", "getReleased", "()Z", "release", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class WakeLockToken implements Token {
        private final AtomicBoolean _released = AtomicFU.atomic(false);

        public WakeLockToken() {
        }

        @Override // androidx.camera.camera2.pipe.core.Token
        public boolean getReleased() {
            return this._released.getValue();
        }

        @Override // androidx.camera.camera2.pipe.core.Token
        public boolean release() {
            if (!this._released.compareAndSet(false, true)) {
                return false;
            }
            WakeLock.this.releaseToken$camera_camera2_pipe();
            return true;
        }
    }

    public final Token acquire() {
        synchronized (this.lock) {
            if (this.closed) {
                return null;
            }
            int i = this.count + 1;
            this.count = i;
            if (i == 1) {
                Job job = this.timeoutJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.timeoutJob = null;
            }
            Unit unit = Unit.INSTANCE;
            return new WakeLockToken();
        }
    }

    public final boolean release() {
        synchronized (this.lock) {
            if (this.closed) {
                return false;
            }
            this.closed = true;
            Job job = this.timeoutJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.timeoutJob = null;
            Unit unit = Unit.INSTANCE;
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.WakeLock$release$2, reason: invalid class name */
    /* JADX INFO: compiled from: WakeLock.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.WakeLock$release$2", f = "WakeLock.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WakeLock.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WakeLock.this.callback.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void releaseToken$camera_camera2_pipe() {
        synchronized (this.lock) {
            int i = this.count - 1;
            this.count = i;
            if (i == 0 && !this.closed) {
                startTimeout();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.WakeLock$startTimeout$1, reason: invalid class name */
    /* JADX INFO: compiled from: WakeLock.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.WakeLock$startTimeout$1", f = "WakeLock.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WakeLock.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(WakeLock.this.timeout, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object obj2 = WakeLock.this.lock;
            WakeLock wakeLock = WakeLock.this;
            synchronized (obj2) {
                if (!wakeLock.closed && wakeLock.count == 0) {
                    wakeLock.timeoutJob = null;
                    wakeLock.closed = true;
                    Unit unit = Unit.INSTANCE;
                    WakeLock.this.callback.invoke();
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void startTimeout() {
        this.timeoutJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }
}
