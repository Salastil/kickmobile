package androidx.camera.camera2.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: UseCaseThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\"J.\u0010#\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%2\u0014\b\u0004\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0'H\u0086\bø\u0001\u0000JB\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0)\"\u0004\b\u0000\u0010%2\u0006\u0010*\u001a\u00020+2\u001a\b\u0004\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0)0'H\u0086\bø\u0001\u0000JM\u0010,\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%2$\b\u0004\u0010&\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-2\b\b\u0002\u0010/\u001a\u000200H\u0086\bø\u0001\u0000¢\u0006\u0002\u00101Ja\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0)\"\u0004\b\u0000\u0010%2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010/\u001a\u0002002*\b\u0004\u0010&\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0)0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\u0086\bø\u0001\u0000¢\u0006\u0002\u00103J1\u00104\u001a\u0002052\u001e\b\u0004\u0010&\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\u0086\bø\u0001\u0000¢\u0006\u0002\u00106R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00070\u0005¢\u0006\u0002\b\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseThreads;", "", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "backgroundExecutor", "Ljava/util/concurrent/Executor;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/Executor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getBackgroundExecutor", "()Ljava/util/concurrent/Executor;", "getBackgroundDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "sequentialExecutorDelegate", "Lorg/jspecify/annotations/NonNull;", "isSequentialThread", "Ljava/lang/ThreadLocal;", "", "isOnSequentialThread", "sequentialExecutor", "getSequentialExecutor", "sequentialDispatcher", "sequentialScope", "getSequentialScope", "setSequentialScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "checkOnSequentialThread", "", "confineDeferred", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "confineDeferredList", "", ContentDisposition.Parameters.Size, "", "confineDeferredSuspend", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", ViewProps.START, "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/Deferred;", "confineDeferredListSuspend", "(ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "confineLaunch", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UseCaseThreads {
    private final CoroutineDispatcher backgroundDispatcher;
    private final Executor backgroundExecutor;
    private final ThreadLocal<Boolean> isSequentialThread;
    private final Handler mainHandler;
    private final CoroutineScope scope;
    private final CoroutineDispatcher sequentialDispatcher;
    private final Executor sequentialExecutor;
    private final Executor sequentialExecutorDelegate;
    private CoroutineScope sequentialScope;

    public UseCaseThreads(CoroutineScope scope, Executor backgroundExecutor, CoroutineDispatcher backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.scope = scope;
        this.backgroundExecutor = backgroundExecutor;
        this.backgroundDispatcher = backgroundDispatcher;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(backgroundExecutor);
        Intrinsics.checkNotNullExpressionValue(executorNewSequentialExecutor, "newSequentialExecutor(...)");
        this.sequentialExecutorDelegate = executorNewSequentialExecutor;
        this.isSequentialThread = new ThreadLocal<>();
        Executor executor = new Executor() { // from class: androidx.camera.camera2.impl.UseCaseThreads$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                UseCaseThreads useCaseThreads = this.f$0;
                useCaseThreads.sequentialExecutorDelegate.execute(new Runnable() { // from class: androidx.camera.camera2.impl.UseCaseThreads$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UseCaseThreads.sequentialExecutor$lambda$0$0(useCaseThreads, runnable);
                    }
                });
            }
        };
        this.sequentialExecutor = executor;
        CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(executor);
        this.sequentialDispatcher = coroutineDispatcherFrom;
        this.sequentialScope = CoroutineScopeKt.CoroutineScope(scope.getCoroutineContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(coroutineDispatcherFrom));
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final Executor getBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    public final CoroutineDispatcher getBackgroundDispatcher() {
        return this.backgroundDispatcher;
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public final boolean isOnSequentialThread() {
        return Intrinsics.areEqual((Object) this.isSequentialThread.get(), (Object) true);
    }

    public final Executor getSequentialExecutor() {
        return this.sequentialExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sequentialExecutor$lambda$0$0(UseCaseThreads useCaseThreads, Runnable runnable) {
        useCaseThreads.isSequentialThread.set(true);
        try {
            runnable.run();
        } finally {
            useCaseThreads.isSequentialThread.remove();
        }
    }

    public final CoroutineScope getSequentialScope() {
        return this.sequentialScope;
    }

    public final void setSequentialScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.sequentialScope = coroutineScope;
    }

    public final void checkOnSequentialThread() {
        if (isOnSequentialThread()) {
            return;
        }
        throw new IllegalStateException(("Thread check failed: This method must be called from the UseCaseThreads sequential scope. Current thread: " + Thread.currentThread().getName()).toString());
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseThreads$confineDeferred$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseThreads.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseThreads$confineDeferred$1", f = "UseCaseThreads.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Deferred<T>> $block;
        final /* synthetic */ CompletableDeferred<T> $signal;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends Deferred<? extends T>> function0, CompletableDeferred<T> completableDeferred, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
            this.$signal = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, this.$signal, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineAdaptersKt.propagateTo((Deferred) this.$block.invoke(), this.$signal);
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            CoroutineAdaptersKt.propagateTo((Deferred) this.$block.invoke(), this.$signal);
            return Unit.INSTANCE;
        }
    }

    public final <T> Deferred<T> confineDeferred(Function0<? extends Deferred<? extends T>> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(getSequentialScope(), null, null, new AnonymousClass1(block, completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseThreads$confineDeferredList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseThreads.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseThreads$confineDeferredList$1", f = "UseCaseThreads.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class C01961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<List<Deferred<T>>> $block;
        final /* synthetic */ List<CompletableDeferred<T>> $deferredList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01961(Function0<? extends List<? extends Deferred<? extends T>>> function0, List<? extends CompletableDeferred<T>> list, Continuation<? super C01961> continuation) {
            super(2, continuation);
            this.$block = function0;
            this.$deferredList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01961(this.$block, this.$deferredList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Iterable iterable = (Iterable) this.$block.invoke();
            List<CompletableDeferred<T>> list = this.$deferredList;
            int i = 0;
            for (Object obj2 : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CoroutineAdaptersKt.propagateTo((Deferred) obj2, (CompletableDeferred) list.get(i));
                i = i2;
            }
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Iterable iterable = (Iterable) this.$block.invoke();
            List<CompletableDeferred<T>> list = this.$deferredList;
            int i = 0;
            for (Object obj2 : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CoroutineAdaptersKt.propagateTo((Deferred) obj2, (CompletableDeferred) list.get(Integer.valueOf(i).intValue()));
                Unit unit = Unit.INSTANCE;
                i = i2;
            }
            return Unit.INSTANCE;
        }
    }

    public final <T> List<Deferred<T>> confineDeferredList(int size, Function0<? extends List<? extends Deferred<? extends T>>> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        }
        ArrayList arrayList2 = arrayList;
        BuildersKt__Builders_commonKt.launch$default(getSequentialScope(), null, null, new C01961(block, arrayList2, null), 3, null);
        return arrayList2;
    }

    public static /* synthetic */ Deferred confineDeferredSuspend$default(UseCaseThreads useCaseThreads, Function1 block, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart start = coroutineStart;
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(start, "start");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(useCaseThreads.getSequentialScope(), null, start, new C01981(block, completableDeferredCompletableDeferred$default, null), 1, null);
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseThreads$confineDeferredSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseThreads.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseThreads$confineDeferredSuspend$1", f = "UseCaseThreads.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class C01981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Deferred<? extends T>>, Object> $block;
        final /* synthetic */ CompletableDeferred<T> $signal;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01981(Function1<? super Continuation<? super Deferred<? extends T>>, ? extends Object> function1, CompletableDeferred<T> completableDeferred, Continuation<? super C01981> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.$signal = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01981(this.$block, this.$signal, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.camera.camera2.impl.UseCaseThreads$confineDeferredSuspend$1 for r3v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L25
            Lf:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlinx.coroutines.Deferred<? extends T>>, java.lang.Object> r4 = r3.$block
                r3.label = r2
                java.lang.Object r4 = r4.invoke(r3)
                if (r4 != r0) goto L25
                return r0
            L25:
                kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
                kotlinx.coroutines.CompletableDeferred<T> r3 = r3.$signal
                androidx.camera.camera2.adapter.CoroutineAdaptersKt.propagateTo(r4, r3)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseThreads.C01981.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.camera.camera2.impl.UseCaseThreads$confineDeferredSuspend$1 for r0v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r1) {
            /*
                r0 = this;
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlinx.coroutines.Deferred<? extends T>>, java.lang.Object> r1 = r0.$block
                java.lang.Object r1 = r1.invoke(r0)
                kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
                kotlinx.coroutines.CompletableDeferred<T> r0 = r0.$signal
                androidx.camera.camera2.adapter.CoroutineAdaptersKt.propagateTo(r1, r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseThreads.C01981.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final <T> Deferred<T> confineDeferredSuspend(Function1<? super Continuation<? super Deferred<? extends T>>, ? extends Object> block, CoroutineStart start) {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(start, "start");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(getSequentialScope(), null, start, new C01981(block, completableDeferredCompletableDeferred$default, null), 1, null);
        return completableDeferredCompletableDeferred$default;
    }

    public static /* synthetic */ List confineDeferredListSuspend$default(UseCaseThreads useCaseThreads, int i, CoroutineStart coroutineStart, Function1 block, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart start = coroutineStart;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        }
        ArrayList arrayList2 = arrayList;
        BuildersKt__Builders_commonKt.launch$default(useCaseThreads.getSequentialScope(), null, start, new C01971(block, arrayList2, null), 1, null);
        return arrayList2;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseThreads$confineDeferredListSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseThreads.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseThreads$confineDeferredListSuspend$1", f = "UseCaseThreads.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_TIME}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class C01971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super List<? extends Deferred<? extends T>>>, Object> $block;
        final /* synthetic */ List<CompletableDeferred<T>> $deferredList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01971(Function1<? super Continuation<? super List<? extends Deferred<? extends T>>>, ? extends Object> function1, List<? extends CompletableDeferred<T>> list, Continuation<? super C01971> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.$deferredList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01971(this.$block, this.$deferredList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.camera.camera2.impl.UseCaseThreads$confineDeferredListSuspend$1 for r3v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L25
            Lf:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.List<? extends kotlinx.coroutines.Deferred<? extends T>>>, java.lang.Object> r4 = r3.$block
                r3.label = r2
                java.lang.Object r4 = r4.invoke(r3)
                if (r4 != r0) goto L25
                return r0
            L25:
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.List<kotlinx.coroutines.CompletableDeferred<T>> r3 = r3.$deferredList
                java.util.Iterator r4 = r4.iterator()
                r0 = 0
            L2e:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L4c
                java.lang.Object r1 = r4.next()
                int r2 = r0 + 1
                if (r0 >= 0) goto L3f
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L3f:
                kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
                java.lang.Object r0 = r3.get(r0)
                kotlinx.coroutines.CompletableDeferred r0 = (kotlinx.coroutines.CompletableDeferred) r0
                androidx.camera.camera2.adapter.CoroutineAdaptersKt.propagateTo(r1, r0)
                r0 = r2
                goto L2e
            L4c:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseThreads.C01971.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.camera.camera2.impl.UseCaseThreads$confineDeferredListSuspend$1 for r3v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.List<? extends kotlinx.coroutines.Deferred<? extends T>>>, java.lang.Object> r4 = r3.$block
                java.lang.Object r4 = r4.invoke(r3)
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.List<kotlinx.coroutines.CompletableDeferred<T>> r3 = r3.$deferredList
                java.util.Iterator r4 = r4.iterator()
                r0 = 0
            Lf:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L39
                java.lang.Object r1 = r4.next()
                int r2 = r0 + 1
                if (r0 >= 0) goto L20
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L20:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                java.lang.Object r0 = r3.get(r0)
                kotlinx.coroutines.CompletableDeferred r0 = (kotlinx.coroutines.CompletableDeferred) r0
                androidx.camera.camera2.adapter.CoroutineAdaptersKt.propagateTo(r1, r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r0 = r2
                goto Lf
            L39:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseThreads.C01971.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final <T> List<Deferred<T>> confineDeferredListSuspend(int size, CoroutineStart start, Function1<? super Continuation<? super List<? extends Deferred<? extends T>>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        }
        ArrayList arrayList2 = arrayList;
        BuildersKt__Builders_commonKt.launch$default(getSequentialScope(), null, start, new C01971(block, arrayList2, null), 1, null);
        return arrayList2;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseThreads$confineLaunch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseThreads.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseThreads$confineLaunch$1", f = "UseCaseThreads.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    public static final class C01991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01991(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C01991> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01991(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
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

        public final Object invokeSuspend$$forInline(Object obj) {
            this.$block.invoke(this);
            return Unit.INSTANCE;
        }
    }

    public final Job confineLaunch(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.launch$default(getSequentialScope(), null, null, new C01991(block, null), 3, null);
    }
}
