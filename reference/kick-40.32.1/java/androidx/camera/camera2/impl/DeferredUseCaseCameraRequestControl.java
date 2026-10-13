package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: DeferredUseCaseCameraRequestControl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\u0004H\u0002J6\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u001f\b\u0004\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0011¢\u0006\u0002\b\u0012H\u0082\bJJ\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0014\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162%\b\u0004\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u000e0\u00140\u0011¢\u0006\u0002\b\u0012H\u0082\bJ?\u0010\u0017\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2)\b\u0004\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018¢\u0006\u0002\b\u0012H\u0082H¢\u0006\u0002\u0010\u001bJ6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J6\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0010\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u00142\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J*\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001a0\u001fH\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002040\u000eH\u0016J\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002040\u000e2\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109Js\u0010:\u001a\b\u0012\u0004\u0012\u0002040\u000e2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00142\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00142\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00142\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u0001072\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0002\bFJ\u000e\u0010G\u001a\b\u0012\u0004\u0012\u0002040\u000eH\u0016J>\u0010H\u001a\b\u0012\u0004\u0012\u0002040\u000e2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00142\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00142\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u0014H\u0016J<\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010J0\u000e0\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00142\u0006\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u0016H\u0016J\u000e\u0010P\u001a\u00020*H\u0096@¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020\u001dH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Landroidx/camera/camera2/impl/DeferredUseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "implProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "<init>", "(Ljavax/inject/Provider;Landroidx/camera/camera2/impl/UseCaseThreads;)V", "impl", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getOrCreateImpl", "runOnSequential", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "runOnSequentialList", "", ContentDisposition.Parameters.Size, "", "runOnSequentialSuspend", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setParametersAsync", "", "values", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "type", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "optionPriority", "Landroidx/camera/core/impl/Config$OptionPriority;", "submitParameters", "removeParametersAsync", UserMetadata.KEYDATA_FILENAME, "updateRepeatingRequestAsync", "isPrimary", "", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "updateCamera2ConfigAsync", "config", "Landroidx/camera/core/impl/Config;", "tags", "", "setTorchOnAsync", "Landroidx/camera/camera2/pipe/Result3A;", "setTorchOffAsync", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "setTorchOffAsync-MtizInI", "(I)Lkotlinx/coroutines/Deferred;", "startFocusAndMeteringAsync", "aeRegions", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "timeLimitNs", "", "startFocusAndMeteringAsync-NxRnBj4", "cancelFocusAndMeteringAsync", "update3aRegions", "issueSingleCaptureAsync", "Ljava/lang/Void;", "captureSequence", "Landroidx/camera/core/impl/CaptureConfig;", "captureMode", "flashType", "flashMode", "awaitSurfaceSetup", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class DeferredUseCaseCameraRequestControl implements UseCaseCameraRequestControl {
    private volatile UseCaseCameraRequestControlImpl impl;
    private final Provider<UseCaseCameraRequestControlImpl> implProvider;
    private final AtomicBoolean isClosed;
    private final UseCaseThreads threads;

    @Inject
    public DeferredUseCaseCameraRequestControl(Provider<UseCaseCameraRequestControlImpl> implProvider, UseCaseThreads threads) {
        Intrinsics.checkNotNullParameter(implProvider, "implProvider");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.implProvider = implProvider;
        this.threads = threads;
        this.isClosed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UseCaseCameraRequestControlImpl getOrCreateImpl() {
        if (this.isClosed.get()) {
            throw new CancellationException("UseCaseCameraRequestControl is closed");
        }
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl != null) {
            return useCaseCameraRequestControlImpl;
        }
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl2 = this.implProvider.get();
        if (this.isClosed.get()) {
            useCaseCameraRequestControlImpl2.close();
            throw new CancellationException("UseCaseCameraRequestControl closed during initialization");
        }
        this.impl = useCaseCameraRequestControlImpl2;
        Intrinsics.checkNotNull(useCaseCameraRequestControlImpl2);
        return useCaseCameraRequestControlImpl2;
    }

    private final <T> Deferred<T> runOnSequential(Function1<? super UseCaseCameraRequestControl, ? extends Deferred<? extends T>> action) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new AnonymousClass2(action, this, null), 3, null);
        }
        return action.invoke(useCaseCameraRequestControlImpl);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$runOnSequential$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeferredUseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$runOnSequential$2", f = "DeferredUseCaseCameraRequestControl.kt", i = {}, l = {RotationOptions.ROTATE_90}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<UseCaseCameraRequestControl, Deferred<T>> $action;
        int label;
        final /* synthetic */ DeferredUseCaseCameraRequestControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super UseCaseCameraRequestControl, ? extends Deferred<? extends T>> function1, DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.this$0 = deferredUseCaseCameraRequestControl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$action, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$action.invoke(this.this$0.getOrCreateImpl()).await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$action.invoke(this.this$0.getOrCreateImpl()).await(this);
        }
    }

    private final <T> List<Deferred<T>> runOnSequentialList(int size, Function1<? super UseCaseCameraRequestControl, ? extends List<? extends Deferred<? extends T>>> action) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$runOnSequentialList$submissionJob$1(action, this, null), 3, null);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$runOnSequentialList$2$1(deferredAsync$default, i, null), 3, null));
            }
            return arrayList;
        }
        return action.invoke(useCaseCameraRequestControlImpl);
    }

    private final <T> Object runOnSequentialSuspend(Function2<? super UseCaseCameraRequestControl, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl != null) {
            return function2.invoke(useCaseCameraRequestControlImpl, null);
        }
        return BuildersKt.withContext(ExecutorsKt.from(this.threads.getSequentialExecutor()), new AnonymousClass3(function2, this, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$runOnSequentialSuspend$3, reason: invalid class name */
    /* JADX INFO: compiled from: DeferredUseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$runOnSequentialSuspend$3", f = "DeferredUseCaseCameraRequestControl.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class AnonymousClass3<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<UseCaseCameraRequestControl, Continuation<? super T>, Object> $action;
        int label;
        final /* synthetic */ DeferredUseCaseCameraRequestControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super UseCaseCameraRequestControl, ? super Continuation<? super T>, ? extends Object> function2, DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$action = function2;
            this.this$0 = deferredUseCaseCameraRequestControl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$action, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<UseCaseCameraRequestControl, Continuation<? super T>, Object> function2 = this.$action;
            UseCaseCameraRequestControlImpl orCreateImpl = this.this$0.getOrCreateImpl();
            this.label = 1;
            Object objInvoke = function2.invoke(orCreateImpl, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$action.invoke(this.this$0.getOrCreateImpl(), this);
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public List<Deferred<Void>> issueSingleCaptureAsync(List<CaptureConfig> captureSequence, int captureMode, int flashType, int flashMode) {
        Intrinsics.checkNotNullParameter(captureSequence, "captureSequence");
        int size = captureSequence.size();
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1(this, null, captureSequence, captureMode, flashType, flashMode), 3, null);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$runOnSequentialList$2$1(deferredAsync$default, i, null), 3, null));
            }
            return arrayList;
        }
        return useCaseCameraRequestControlImpl.issueSingleCaptureAsync(captureSequence, captureMode, flashType, flashMode);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public void close() {
        if (this.isClosed.getAndSet(true)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$close$$inlined$confineLaunch$1(null, this), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> setParametersAsync(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(optionPriority, "optionPriority");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setParametersAsync$$inlined$runOnSequential$1(this, null, values, type, optionPriority), 3, null);
        }
        return useCaseCameraRequestControlImpl.setParametersAsync(values, type, optionPriority);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> submitParameters(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(optionPriority, "optionPriority");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1(this, null, values, type, optionPriority), 3, null);
        }
        return useCaseCameraRequestControlImpl.submitParameters(values, type, optionPriority);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> removeParametersAsync(List<? extends CaptureRequest.Key<?>> keys, UseCaseCameraRequestControl.Type type) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(type, "type");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1(this, null, keys, type), 3, null);
        }
        return useCaseCameraRequestControlImpl.removeParametersAsync(keys, type);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> updateRepeatingRequestAsync(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        Intrinsics.checkNotNullParameter(runningUseCases, "runningUseCases");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$updateRepeatingRequestAsync$$inlined$runOnSequential$1(this, null, isPrimary, runningUseCases), 3, null);
        }
        return useCaseCameraRequestControlImpl.updateRepeatingRequestAsync(isPrimary, runningUseCases);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> updateCamera2ConfigAsync(Config config, Map<String, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tags, "tags");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$updateCamera2ConfigAsync$$inlined$runOnSequential$1(this, null, config, tags), 3, null);
        }
        return useCaseCameraRequestControlImpl.updateCamera2ConfigAsync(config, tags);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> setTorchOnAsync() {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setTorchOnAsync$$inlined$runOnSequential$1(this, null), 3, null);
        }
        return useCaseCameraRequestControlImpl.setTorchOnAsync();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    /* JADX INFO: renamed from: setTorchOffAsync-MtizInI, reason: not valid java name */
    public Deferred<Result3A> mo111setTorchOffAsyncMtizInI(int aeMode) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1(this, null, aeMode), 3, null);
        }
        return useCaseCameraRequestControlImpl.mo111setTorchOffAsyncMtizInI(aeMode);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    /* JADX INFO: renamed from: startFocusAndMeteringAsync-NxRnBj4, reason: not valid java name */
    public Deferred<Result3A> mo112startFocusAndMeteringAsyncNxRnBj4(List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, long timeLimitNs) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$startFocusAndMeteringAsyncNxRnBj4$$inlined$runOnSequential$1(this, null, aeRegions, afRegions, awbRegions, aeLockBehavior, afLockBehavior, awbLockBehavior, afTriggerStartAeMode, timeLimitNs), 3, null);
        }
        return useCaseCameraRequestControlImpl.mo112startFocusAndMeteringAsyncNxRnBj4(aeRegions, afRegions, awbRegions, aeLockBehavior, afLockBehavior, awbLockBehavior, afTriggerStartAeMode, timeLimitNs);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> cancelFocusAndMeteringAsync() {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$cancelFocusAndMeteringAsync$$inlined$runOnSequential$1(this, null), 3, null);
        }
        return useCaseCameraRequestControlImpl.cancelFocusAndMeteringAsync();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> update3aRegions(List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl == null) {
            return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$update3aRegions$$inlined$runOnSequential$1(this, null, aeRegions, afRegions, awbRegions), 3, null);
        }
        return useCaseCameraRequestControlImpl.update3aRegions(aeRegions, afRegions, awbRegions);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Object awaitSurfaceSetup(Continuation<? super Boolean> continuation) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl != null) {
            return useCaseCameraRequestControlImpl.awaitSurfaceSetup(continuation);
        }
        return BuildersKt.withContext(ExecutorsKt.from(this.threads.getSequentialExecutor()), new DeferredUseCaseCameraRequestControl$awaitSurfaceSetup$$inlined$runOnSequentialSuspend$1(this, null), continuation);
    }
}
