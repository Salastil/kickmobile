package java8.util.concurrent;

import com.google.android.gms.internal.cast.zzwb$zzd$$ExternalSyntheticBackportWithForwarding0;
import io.ktor.http.LinkHeader;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java8.util.function.BiConsumer;
import java8.util.function.BiFunction;
import java8.util.function.Consumer;
import java8.util.function.Function;
import java8.util.function.Supplier;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes9.dex */
public class CompletableFuture<T> implements Future<T>, CompletionStage<T> {
    static final int ASYNC = 1;
    private static final Executor ASYNC_POOL;
    static final int NESTED = -1;
    private static final long NEXT;
    static final AltResult NIL = new AltResult(null);
    private static final long RESULT;
    private static final long STACK;
    static final int SYNC = 0;
    private static final Unsafe U;
    private static final boolean USE_COMMON_POOL;
    volatile Object result;
    volatile Completion stack;

    interface AsynchronousCompletionTask {
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> toCompletableFuture() {
        return this;
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBoth(CompletionStage completionStage, Runnable runnable) {
        return runAfterBoth((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable) {
        return runAfterBothAsync((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
        return runAfterBothAsync((CompletionStage<?>) completionStage, runnable, executor);
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEither(CompletionStage completionStage, Runnable runnable) {
        return runAfterEither((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable) {
        return runAfterEitherAsync((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
        return runAfterEitherAsync((CompletionStage<?>) completionStage, runnable, executor);
    }

    final boolean internalComplete(Object obj) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, RESULT, null, obj);
    }

    final boolean casStack(Completion completion, Completion completion2) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, STACK, completion, completion2);
    }

    final boolean tryPushStack(Completion completion) {
        Completion completion2 = this.stack;
        lazySetNext(completion, completion2);
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, STACK, completion2, completion);
    }

    final void pushStack(Completion completion) {
        while (!tryPushStack(completion)) {
        }
    }

    static final class AltResult {
        final Throwable ex;

        AltResult(Throwable th) {
            this.ex = th;
        }
    }

    static {
        boolean z = FJPool.getCommonPoolParallelism() > 1;
        USE_COMMON_POOL = z;
        ASYNC_POOL = z ? FJPool.commonPool() : new ThreadPerTaskExecutor();
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            RESULT = unsafe.objectFieldOffset(CompletableFuture.class.getDeclaredField("result"));
            STACK = unsafe.objectFieldOffset(CompletableFuture.class.getDeclaredField("stack"));
            NEXT = unsafe.objectFieldOffset(Completion.class.getDeclaredField(LinkHeader.Rel.Next));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    final boolean completeNull() {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, RESULT, null, NIL);
    }

    final Object encodeValue(T t) {
        return t == null ? NIL : t;
    }

    final boolean completeValue(T t) {
        Unsafe unsafe = U;
        long j = RESULT;
        if (t == null) {
            t = (T) NIL;
        }
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, this, j, null, t);
    }

    static AltResult encodeThrowable(Throwable th) {
        if (!(th instanceof CompletionException)) {
            th = new CompletionException(th);
        }
        return new AltResult(th);
    }

    final boolean completeThrowable(Throwable th) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, RESULT, null, encodeThrowable(th));
    }

    static Object encodeThrowable(Throwable th, Object obj) {
        if (!(th instanceof CompletionException)) {
            th = new CompletionException(th);
        } else if ((obj instanceof AltResult) && th == ((AltResult) obj).ex) {
            return obj;
        }
        return new AltResult(th);
    }

    final boolean completeThrowable(Throwable th, Object obj) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, RESULT, null, encodeThrowable(th, obj));
    }

    Object encodeOutcome(T t, Throwable th) {
        if (th == null) {
            return t == null ? NIL : t;
        }
        return encodeThrowable(th);
    }

    static Object encodeRelay(Object obj) {
        Throwable th;
        return (!(obj instanceof AltResult) || (th = ((AltResult) obj).ex) == null || (th instanceof CompletionException)) ? obj : new AltResult(new CompletionException(th));
    }

    final boolean completeRelay(Object obj) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, this, RESULT, null, encodeRelay(obj));
    }

    private static Object reportGet(Object obj) throws ExecutionException, InterruptedException {
        Throwable cause;
        if (obj == null) {
            throw new InterruptedException();
        }
        if (!(obj instanceof AltResult)) {
            return obj;
        }
        Throwable th = ((AltResult) obj).ex;
        if (th == null) {
            return null;
        }
        if (th instanceof CancellationException) {
            throw ((CancellationException) th);
        }
        if ((th instanceof CompletionException) && (cause = th.getCause()) != null) {
            th = cause;
        }
        throw new ExecutionException(th);
    }

    private static Object reportJoin(Object obj) {
        if (!(obj instanceof AltResult)) {
            return obj;
        }
        Throwable th = ((AltResult) obj).ex;
        if (th == null) {
            return null;
        }
        if (th instanceof CancellationException) {
            throw ((CancellationException) th);
        }
        if (th instanceof CompletionException) {
            throw ((CompletionException) th);
        }
        throw new CompletionException(th);
    }

    static final class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Util.requireNonNull(runnable);
            new Thread(runnable).start();
        }
    }

    static Executor screenExecutor(Executor executor) {
        if (!USE_COMMON_POOL && executor == FJPool.commonPool()) {
            return ASYNC_POOL;
        }
        return (Executor) Util.requireNonNull(executor);
    }

    static abstract class Completion extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        volatile Completion next;

        @Override // java8.util.concurrent.FJTask
        public final Void getRawResult() {
            return null;
        }

        abstract boolean isLive();

        @Override // java8.util.concurrent.FJTask
        public final void setRawResult(Void r1) {
        }

        abstract CompletableFuture<?> tryFire(int i);

        Completion() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            tryFire(1);
        }

        @Override // java8.util.concurrent.FJTask
        public final boolean exec() {
            tryFire(1);
            return false;
        }
    }

    static void lazySetNext(Completion completion, Completion completion2) {
        U.putOrderedObject(completion, NEXT, completion2);
    }

    static boolean casNext(Completion completion, Completion completion2, Completion completion3) {
        return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, completion, NEXT, completion2, completion3);
    }

    final void postComplete() {
        while (true) {
            CompletableFuture completableFutureTryFire = this;
            while (true) {
                Completion completion = completableFutureTryFire.stack;
                if (completion == null) {
                    if (completableFutureTryFire == this || (completion = this.stack) == null) {
                        return;
                    } else {
                        completableFutureTryFire = this;
                    }
                }
                Completion completion2 = completion.next;
                if (completableFutureTryFire.casStack(completion, completion2)) {
                    if (completion2 != null) {
                        if (completableFutureTryFire != this) {
                            pushStack(completion);
                        } else {
                            casNext(completion, completion2, null);
                        }
                    }
                    completableFutureTryFire = completion.tryFire(-1);
                    if (completableFutureTryFire == null) {
                        break;
                    }
                }
            }
        }
    }

    final void cleanStack() {
        Completion completion;
        boolean zCasStack = false;
        while (true) {
            completion = this.stack;
            if (completion == null || completion.isLive()) {
                break;
            } else {
                zCasStack = casStack(completion, completion.next);
            }
        }
        if (completion == null || zCasStack) {
            return;
        }
        Completion completion2 = completion.next;
        Completion completion3 = completion;
        while (completion2 != null) {
            Completion completion4 = completion2.next;
            if (!completion2.isLive()) {
                casNext(completion3, completion2, completion4);
                return;
            } else {
                completion3 = completion2;
                completion2 = completion4;
            }
        }
    }

    static abstract class UniCompletion<T, V> extends Completion {
        CompletableFuture<V> dep;
        Executor executor;
        CompletableFuture<T> src;

        UniCompletion(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2) {
            this.executor = executor;
            this.dep = completableFuture;
            this.src = completableFuture2;
        }

        final boolean claim() {
            Executor executor = this.executor;
            if (compareAndSetForkJoinTaskTag((short) 0, (short) 1)) {
                if (executor == null) {
                    return true;
                }
                this.executor = null;
                executor.execute(this);
            }
            return false;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            return this.dep != null;
        }
    }

    final void unipush(Completion completion) {
        if (completion != null) {
            while (!tryPushStack(completion)) {
                if (this.result != null) {
                    lazySetNext(completion, null);
                    break;
                }
            }
            if (this.result != null) {
                completion.tryFire(0);
            }
        }
    }

    final CompletableFuture<T> postFire(CompletableFuture<?> completableFuture, int i) {
        if (completableFuture != null && completableFuture.stack != null) {
            Object obj = completableFuture.result;
            if (obj == null) {
                completableFuture.cleanStack();
            }
            if (i >= 0 && (obj != null || completableFuture.result != null)) {
                completableFuture.postComplete();
            }
        }
        if (this.result == null || this.stack == null) {
            return null;
        }
        if (i < 0) {
            return this;
        }
        postComplete();
        return null;
    }

    static final class UniApply<T, V> extends UniCompletion<T, V> {
        Function<? super T, ? extends V> fn;

        UniApply(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, Function<? super T, ? extends V> function) {
            super(executor, completableFuture, completableFuture2);
            this.fn = function;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x002e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i) {
            Object obj;
            CompletableFuture<V> completableFuture;
            Function<? super T, ? extends V> function;
            CompletableFuture<T> completableFuture2 = this.src;
            if (completableFuture2 == null || (obj = completableFuture2.result) == null || (completableFuture = this.dep) == null || (function = this.fn) == null) {
                return null;
            }
            if (completableFuture.result == null) {
                if (obj instanceof AltResult) {
                    Throwable th = ((AltResult) obj).ex;
                    if (th != null) {
                        completableFuture.completeThrowable(th, obj);
                    } else {
                        obj = null;
                        if (i <= 0) {
                            if (!claim()) {
                                return null;
                            }
                        }
                        completableFuture.completeValue(function.apply(obj));
                    }
                } else {
                    if (i <= 0) {
                        try {
                            if (!claim()) {
                                return null;
                            }
                        } catch (Throwable th2) {
                            completableFuture.completeThrowable(th2);
                        }
                    }
                    completableFuture.completeValue(function.apply(obj));
                }
            }
            this.src = null;
            this.dep = null;
            this.fn = null;
            return completableFuture.postFire((CompletableFuture<?>) completableFuture2, i);
        }
    }

    private <V> CompletableFuture<V> uniApplyStage(Executor executor, Function<? super T, ? extends V> function) {
        Util.requireNonNull(function);
        Object obj = this.result;
        if (obj != null) {
            return uniApplyNow(obj, executor, function);
        }
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        unipush(new UniApply(executor, completableFuture, this, function));
        return completableFuture;
    }

    private <V> CompletableFuture<V> uniApplyNow(Object obj, Executor executor, Function<? super T, ? extends V> function) {
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        if (obj instanceof AltResult) {
            Throwable th = ((AltResult) obj).ex;
            if (th != null) {
                completableFuture.result = encodeThrowable(th, obj);
                return completableFuture;
            }
            obj = null;
        }
        try {
            if (executor != null) {
                executor.execute(new UniApply(null, completableFuture, this, function));
                return completableFuture;
            }
            completableFuture.result = completableFuture.encodeValue(function.apply(obj));
            return completableFuture;
        } catch (Throwable th2) {
            completableFuture.result = encodeThrowable(th2);
            return completableFuture;
        }
    }

    static final class UniAccept<T> extends UniCompletion<T, Void> {
        Consumer<? super T> fn;

        UniAccept(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, Consumer<? super T> consumer) {
            super(executor, completableFuture, completableFuture2);
            this.fn = consumer;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r7) {
            /*
                r6 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r6.src
                r1 = 0
                if (r0 == 0) goto L45
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L45
                java8.util.concurrent.CompletableFuture<V> r3 = r6.dep
                if (r3 == 0) goto L45
                java8.util.function.Consumer<? super T> r4 = r6.fn
                if (r4 != 0) goto L12
                goto L45
            L12:
                java.lang.Object r5 = r3.result
                if (r5 != 0) goto L3a
                boolean r5 = r2 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r5 == 0) goto L26
                r5 = r2
                java8.util.concurrent.CompletableFuture$AltResult r5 = (java8.util.concurrent.CompletableFuture.AltResult) r5
                java.lang.Throwable r5 = r5.ex
                if (r5 == 0) goto L25
                r3.completeThrowable(r5, r2)
                goto L3a
            L25:
                r2 = r1
            L26:
                if (r7 > 0) goto L2f
                boolean r5 = r6.claim()     // Catch: java.lang.Throwable -> L36
                if (r5 != 0) goto L2f
                return r1
            L2f:
                r4.accept(r2)     // Catch: java.lang.Throwable -> L36
                r3.completeNull()     // Catch: java.lang.Throwable -> L36
                goto L3a
            L36:
                r2 = move-exception
                r3.completeThrowable(r2)
            L3a:
                r6.src = r1
                r6.dep = r1
                r6.fn = r1
                java8.util.concurrent.CompletableFuture r6 = r3.postFire(r0, r7)
                return r6
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniAccept.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private CompletableFuture<Void> uniAcceptStage(Executor executor, Consumer<? super T> consumer) {
        Util.requireNonNull(consumer);
        Object obj = this.result;
        if (obj != null) {
            return uniAcceptNow(obj, executor, consumer);
        }
        CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
        unipush(new UniAccept(executor, completableFutureNewIncompleteFuture, this, consumer));
        return completableFutureNewIncompleteFuture;
    }

    private CompletableFuture<Void> uniAcceptNow(Object obj, Executor executor, Consumer<? super T> consumer) {
        CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
        if (obj instanceof AltResult) {
            Throwable th = ((AltResult) obj).ex;
            if (th != null) {
                completableFutureNewIncompleteFuture.result = encodeThrowable(th, obj);
                return completableFutureNewIncompleteFuture;
            }
            obj = null;
        }
        try {
            if (executor != null) {
                executor.execute(new UniAccept(null, completableFutureNewIncompleteFuture, this, consumer));
                return completableFutureNewIncompleteFuture;
            }
            consumer.accept(obj);
            completableFutureNewIncompleteFuture.result = NIL;
            return completableFutureNewIncompleteFuture;
        } catch (Throwable th2) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th2);
            return completableFutureNewIncompleteFuture;
        }
    }

    static final class UniRun<T> extends UniCompletion<T, Void> {
        Runnable fn;

        UniRun(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, Runnable runnable) {
            super(executor, completableFuture, completableFuture2);
            this.fn = runnable;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r7) {
            /*
                r6 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r6.src
                r1 = 0
                if (r0 == 0) goto L44
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L44
                java8.util.concurrent.CompletableFuture<V> r3 = r6.dep
                if (r3 == 0) goto L44
                java.lang.Runnable r4 = r6.fn
                if (r4 != 0) goto L12
                goto L44
            L12:
                java.lang.Object r5 = r3.result
                if (r5 != 0) goto L39
                boolean r5 = r2 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r5 == 0) goto L25
                r5 = r2
                java8.util.concurrent.CompletableFuture$AltResult r5 = (java8.util.concurrent.CompletableFuture.AltResult) r5
                java.lang.Throwable r5 = r5.ex
                if (r5 == 0) goto L25
                r3.completeThrowable(r5, r2)
                goto L39
            L25:
                if (r7 > 0) goto L2e
                boolean r2 = r6.claim()     // Catch: java.lang.Throwable -> L35
                if (r2 != 0) goto L2e
                return r1
            L2e:
                r4.run()     // Catch: java.lang.Throwable -> L35
                r3.completeNull()     // Catch: java.lang.Throwable -> L35
                goto L39
            L35:
                r2 = move-exception
                r3.completeThrowable(r2)
            L39:
                r6.src = r1
                r6.dep = r1
                r6.fn = r1
                java8.util.concurrent.CompletableFuture r6 = r3.postFire(r0, r7)
                return r6
            L44:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniRun.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private CompletableFuture<Void> uniRunStage(Executor executor, Runnable runnable) {
        Util.requireNonNull(runnable);
        Object obj = this.result;
        if (obj != null) {
            return uniRunNow(obj, executor, runnable);
        }
        CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
        unipush(new UniRun(executor, completableFutureNewIncompleteFuture, this, runnable));
        return completableFutureNewIncompleteFuture;
    }

    private CompletableFuture<Void> uniRunNow(Object obj, Executor executor, Runnable runnable) {
        Throwable th;
        CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
        if ((obj instanceof AltResult) && (th = ((AltResult) obj).ex) != null) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th, obj);
            return completableFutureNewIncompleteFuture;
        }
        try {
            if (executor != null) {
                executor.execute(new UniRun(null, completableFutureNewIncompleteFuture, this, runnable));
                return completableFutureNewIncompleteFuture;
            }
            runnable.run();
            completableFutureNewIncompleteFuture.result = NIL;
            return completableFutureNewIncompleteFuture;
        } catch (Throwable th2) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th2);
            return completableFutureNewIncompleteFuture;
        }
    }

    static final class UniWhenComplete<T> extends UniCompletion<T, T> {
        BiConsumer<? super T, ? super Throwable> fn;

        UniWhenComplete(Executor executor, CompletableFuture<T> completableFuture, CompletableFuture<T> completableFuture2, BiConsumer<? super T, ? super Throwable> biConsumer) {
            super(executor, completableFuture, completableFuture2);
            this.fn = biConsumer;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<T> tryFire(int r7) {
            /*
                r6 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r6.src
                r1 = 0
                if (r0 == 0) goto L28
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L28
                java8.util.concurrent.CompletableFuture<V> r3 = r6.dep
                if (r3 == 0) goto L28
                java8.util.function.BiConsumer<? super T, ? super java.lang.Throwable> r4 = r6.fn
                if (r4 == 0) goto L28
                if (r7 <= 0) goto L15
                r5 = r1
                goto L16
            L15:
                r5 = r6
            L16:
                boolean r2 = r3.uniWhenComplete(r2, r4, r5)
                if (r2 != 0) goto L1d
                goto L28
            L1d:
                r6.src = r1
                r6.dep = r1
                r6.fn = r1
                java8.util.concurrent.CompletableFuture r6 = r3.postFire(r0, r7)
                return r6
            L28:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniWhenComplete.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x002b  */
    /* JADX WARN: Code duplicated, block: B:24:0x002d  */
    final boolean uniWhenComplete(Object obj, BiConsumer<? super T, ? super Throwable> biConsumer, UniWhenComplete<T> uniWhenComplete) {
        Throwable th;
        if (this.result == null) {
            Throwable th2 = null;
            if (uniWhenComplete != null) {
                try {
                    if (!uniWhenComplete.claim()) {
                        return false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (th2 == null) {
                        th = th;
                    } else {
                        th = th2;
                    }
                    completeThrowable(th, obj);
                    return true;
                }
            }
            if (obj instanceof AltResult) {
                th = ((AltResult) obj).ex;
            } else {
                th = null;
                th2 = (Object) obj;
            }
            try {
                biConsumer.accept(th2, th);
                if (th == null) {
                    internalComplete(obj);
                    return true;
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                if (th2 == null) {
                    th = th;
                } else {
                    th = th2;
                }
            }
            completeThrowable(th, obj);
        }
        return true;
    }

    private CompletableFuture<T> uniWhenCompleteStage(Executor executor, BiConsumer<? super T, ? super Throwable> biConsumer) {
        Util.requireNonNull(biConsumer);
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniWhenComplete(executor, completableFuture, this, biConsumer));
            return completableFuture;
        }
        if (executor == null) {
            completableFuture.uniWhenComplete(obj, biConsumer, null);
            return completableFuture;
        }
        try {
            executor.execute(new UniWhenComplete(null, completableFuture, this, biConsumer));
            return completableFuture;
        } catch (Throwable th) {
            completableFuture.result = encodeThrowable(th);
            return completableFuture;
        }
    }

    static final class UniHandle<T, V> extends UniCompletion<T, V> {
        BiFunction<? super T, Throwable, ? extends V> fn;

        UniHandle(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, BiFunction<? super T, Throwable, ? extends V> biFunction) {
            super(executor, completableFuture, completableFuture2);
            this.fn = biFunction;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i) {
            Object obj;
            CompletableFuture<V> completableFuture;
            BiFunction<? super T, Throwable, ? extends V> biFunction;
            CompletableFuture<T> completableFuture2 = this.src;
            if (completableFuture2 != null && (obj = completableFuture2.result) != null && (completableFuture = this.dep) != null && (biFunction = this.fn) != 0) {
                if (completableFuture.uniHandle(obj, biFunction, i > 0 ? null : this)) {
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(completableFuture2, i);
                }
            }
            return null;
        }
    }

    final <S> boolean uniHandle(Object obj, BiFunction<? super S, Throwable, ? extends T> biFunction, UniHandle<S, T> uniHandle) {
        if (this.result != null) {
            return true;
        }
        if (uniHandle != null) {
            try {
                if (!uniHandle.claim()) {
                    return false;
                }
            } catch (Throwable th) {
                completeThrowable(th);
                return true;
            }
        }
        Throwable th2 = null;
        if (obj instanceof AltResult) {
            th2 = ((AltResult) obj).ex;
            obj = null;
        }
        completeValue(biFunction.apply(obj, th2));
        return true;
    }

    private <V> CompletableFuture<V> uniHandleStage(Executor executor, BiFunction<? super T, Throwable, ? extends V> biFunction) {
        Util.requireNonNull(biFunction);
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniHandle(executor, completableFuture, this, biFunction));
            return completableFuture;
        }
        if (executor == null) {
            completableFuture.uniHandle(obj, biFunction, null);
            return completableFuture;
        }
        try {
            executor.execute(new UniHandle(null, completableFuture, this, biFunction));
            return completableFuture;
        } catch (Throwable th) {
            completableFuture.result = encodeThrowable(th);
            return completableFuture;
        }
    }

    static final class UniExceptionally<T> extends UniCompletion<T, T> {
        Function<? super Throwable, ? extends T> fn;

        UniExceptionally(Executor executor, CompletableFuture<T> completableFuture, CompletableFuture<T> completableFuture2, Function<? super Throwable, ? extends T> function) {
            super(executor, completableFuture, completableFuture2);
            this.fn = function;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<T> tryFire(int r7) {
            /*
                r6 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r6.src
                r1 = 0
                if (r0 == 0) goto L28
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L28
                java8.util.concurrent.CompletableFuture<V> r3 = r6.dep
                if (r3 == 0) goto L28
                java8.util.function.Function<? super java.lang.Throwable, ? extends T> r4 = r6.fn
                if (r4 == 0) goto L28
                if (r7 <= 0) goto L15
                r5 = r1
                goto L16
            L15:
                r5 = r6
            L16:
                boolean r2 = r3.uniExceptionally(r2, r4, r5)
                if (r2 != 0) goto L1d
                goto L28
            L1d:
                r6.src = r1
                r6.dep = r1
                r6.fn = r1
                java8.util.concurrent.CompletableFuture r6 = r3.postFire(r0, r7)
                return r6
            L28:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniExceptionally.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    final boolean uniExceptionally(Object obj, Function<? super Throwable, ? extends T> function, UniExceptionally<T> uniExceptionally) {
        Throwable th;
        if (this.result != null) {
            return true;
        }
        if (uniExceptionally != null) {
            try {
                if (!uniExceptionally.claim()) {
                    return false;
                }
            } catch (Throwable th2) {
                completeThrowable(th2);
                return true;
            }
        }
        if ((obj instanceof AltResult) && (th = ((AltResult) obj).ex) != null) {
            completeValue(function.apply(th));
            return true;
        }
        internalComplete(obj);
        return true;
    }

    private CompletableFuture<T> uniExceptionallyStage(Executor executor, Function<Throwable, ? extends T> function) {
        Util.requireNonNull(function);
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniExceptionally(executor, completableFuture, this, function));
            return completableFuture;
        }
        if (executor == null) {
            completableFuture.uniExceptionally(obj, function, null);
            return completableFuture;
        }
        try {
            executor.execute(new UniExceptionally(null, completableFuture, this, function));
            return completableFuture;
        } catch (Throwable th) {
            completableFuture.result = encodeThrowable(th);
            return completableFuture;
        }
    }

    static final class UniComposeExceptionally<T> extends UniCompletion<T, T> {
        Function<Throwable, ? extends CompletionStage<T>> fn;

        UniComposeExceptionally(Executor executor, CompletableFuture<T> completableFuture, CompletableFuture<T> completableFuture2, Function<Throwable, ? extends CompletionStage<T>> function) {
            super(executor, completableFuture, completableFuture2);
            this.fn = function;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<T> tryFire(int r7) {
            /*
                r6 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r6.src
                r1 = 0
                if (r0 == 0) goto L5c
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L5c
                java8.util.concurrent.CompletableFuture<V> r3 = r6.dep
                if (r3 == 0) goto L5c
                java8.util.function.Function<java.lang.Throwable, ? extends java8.util.concurrent.CompletionStage<T>> r4 = r6.fn
                if (r4 != 0) goto L12
                goto L5c
            L12:
                java.lang.Object r5 = r3.result
                if (r5 != 0) goto L51
                boolean r5 = r2 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r5 == 0) goto L4e
                r5 = r2
                java8.util.concurrent.CompletableFuture$AltResult r5 = (java8.util.concurrent.CompletableFuture.AltResult) r5
                java.lang.Throwable r5 = r5.ex
                if (r5 == 0) goto L4e
                if (r7 > 0) goto L2a
                boolean r2 = r6.claim()     // Catch: java.lang.Throwable -> L49
                if (r2 != 0) goto L2a
                return r1
            L2a:
                java.lang.Object r2 = r4.apply(r5)     // Catch: java.lang.Throwable -> L49
                java8.util.concurrent.CompletionStage r2 = (java8.util.concurrent.CompletionStage) r2     // Catch: java.lang.Throwable -> L49
                java8.util.concurrent.CompletableFuture r2 = r2.toCompletableFuture()     // Catch: java.lang.Throwable -> L49
                java.lang.Object r4 = r2.result     // Catch: java.lang.Throwable -> L49
                if (r4 == 0) goto L3c
                r3.completeRelay(r4)     // Catch: java.lang.Throwable -> L49
                goto L51
            L3c:
                java8.util.concurrent.CompletableFuture$UniRelay r4 = new java8.util.concurrent.CompletableFuture$UniRelay     // Catch: java.lang.Throwable -> L49
                r4.<init>(r3, r2)     // Catch: java.lang.Throwable -> L49
                r2.unipush(r4)     // Catch: java.lang.Throwable -> L49
                java.lang.Object r2 = r3.result     // Catch: java.lang.Throwable -> L49
                if (r2 != 0) goto L51
                return r1
            L49:
                r2 = move-exception
                r3.completeThrowable(r2)
                goto L51
            L4e:
                r3.internalComplete(r2)
            L51:
                r6.src = r1
                r6.dep = r1
                r6.fn = r1
                java8.util.concurrent.CompletableFuture r6 = r3.postFire(r0, r7)
                return r6
            L5c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniComposeExceptionally.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private CompletableFuture<T> uniComposeExceptionallyStage(Executor executor, Function<Throwable, ? extends CompletionStage<T>> function) {
        Throwable th;
        Util.requireNonNull(function);
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniComposeExceptionally(executor, completableFuture, this, function));
            return completableFuture;
        }
        if (!(obj instanceof AltResult) || (th = ((AltResult) obj).ex) == null) {
            completableFuture.internalComplete(obj);
            return completableFuture;
        }
        try {
            if (executor != null) {
                executor.execute(new UniComposeExceptionally(null, completableFuture, this, function));
                return completableFuture;
            }
            CompletableFuture<T> completableFuture2 = function.apply(th).toCompletableFuture();
            Object obj2 = completableFuture2.result;
            if (obj2 != null) {
                completableFuture.result = encodeRelay(obj2);
                return completableFuture;
            }
            completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
            return completableFuture;
        } catch (Throwable th2) {
            completableFuture.result = encodeThrowable(th2);
            return completableFuture;
        }
    }

    static final class UniRelay<U, T extends U> extends UniCompletion<T, U> {
        UniRelay(CompletableFuture<U> completableFuture, CompletableFuture<T> completableFuture2) {
            super(null, completableFuture, completableFuture2);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<U> tryFire(int r6) {
            /*
                r5 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r5.src
                r1 = 0
                if (r0 == 0) goto L1e
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L1e
                java8.util.concurrent.CompletableFuture<V> r3 = r5.dep
                if (r3 != 0) goto Le
                goto L1e
            Le:
                java.lang.Object r4 = r3.result
                if (r4 != 0) goto L15
                r3.completeRelay(r2)
            L15:
                r5.src = r1
                r5.dep = r1
                java8.util.concurrent.CompletableFuture r5 = r3.postFire(r0, r6)
                return r5
            L1e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.UniRelay.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private static <U, T extends U> CompletableFuture<U> uniCopyStage(CompletableFuture<T> completableFuture) {
        CompletableFuture<U> completableFutureNewIncompleteFuture = completableFuture.newIncompleteFuture();
        Object obj = completableFuture.result;
        if (obj != null) {
            completableFutureNewIncompleteFuture.result = encodeRelay(obj);
            return completableFutureNewIncompleteFuture;
        }
        completableFuture.unipush(new UniRelay(completableFutureNewIncompleteFuture, completableFuture));
        return completableFutureNewIncompleteFuture;
    }

    private MinimalStage<T> uniAsMinimalStage() {
        Object obj = this.result;
        if (obj != null) {
            return new MinimalStage<>(encodeRelay(obj));
        }
        MinimalStage<T> minimalStage = new MinimalStage<>();
        unipush(new UniRelay(minimalStage, this));
        return minimalStage;
    }

    static final class UniCompose<T, V> extends UniCompletion<T, V> {
        Function<? super T, ? extends CompletionStage<V>> fn;

        UniCompose(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, Function<? super T, ? extends CompletionStage<V>> function) {
            super(executor, completableFuture, completableFuture2);
            this.fn = function;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x002e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x002f A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:20:0x0028, B:23:0x002f, B:25:0x003d, B:26:0x0041), top: B:34:0x0028 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x003d A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:20:0x0028, B:23:0x002f, B:25:0x003d, B:26:0x0041), top: B:34:0x0028 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0041 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #0 {all -> 0x004e, blocks: (B:20:0x0028, B:23:0x002f, B:25:0x003d, B:26:0x0041), top: B:34:0x0028 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x004d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i) {
            Object obj;
            CompletableFuture<V> completableFuture;
            Function<? super T, ? extends CompletionStage<V>> function;
            CompletableFuture<V> completableFuture2;
            Object obj2;
            CompletableFuture<T> completableFuture3 = this.src;
            if (completableFuture3 == null || (obj = completableFuture3.result) == null || (completableFuture = this.dep) == null || (function = this.fn) == null) {
                return null;
            }
            if (completableFuture.result == null) {
                if (obj instanceof AltResult) {
                    Throwable th = ((AltResult) obj).ex;
                    if (th != null) {
                        completableFuture.completeThrowable(th, obj);
                    } else {
                        obj = null;
                        if (i <= 0) {
                            if (!claim()) {
                                return null;
                            }
                            completableFuture2 = function.apply(obj).toCompletableFuture();
                            obj2 = completableFuture2.result;
                            if (obj2 != null) {
                                completableFuture.completeRelay(obj2);
                            } else {
                                completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                                if (completableFuture.result == null) {
                                    return null;
                                }
                            }
                        } else {
                            completableFuture2 = function.apply(obj).toCompletableFuture();
                            obj2 = completableFuture2.result;
                            if (obj2 != null) {
                                completableFuture.completeRelay(obj2);
                            } else {
                                completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                                if (completableFuture.result == null) {
                                    return null;
                                }
                            }
                        }
                    }
                } else if (i <= 0) {
                    try {
                        if (!claim()) {
                            return null;
                        }
                        completableFuture2 = function.apply(obj).toCompletableFuture();
                        obj2 = completableFuture2.result;
                        if (obj2 != null) {
                            completableFuture.completeRelay(obj2);
                        } else {
                            completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                            if (completableFuture.result == null) {
                                return null;
                            }
                        }
                    } catch (Throwable th2) {
                        completableFuture.completeThrowable(th2);
                    }
                } else {
                    completableFuture2 = function.apply(obj).toCompletableFuture();
                    obj2 = completableFuture2.result;
                    if (obj2 != null) {
                        completableFuture.completeRelay(obj2);
                    } else {
                        completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                        if (completableFuture.result == null) {
                            return null;
                        }
                    }
                }
            }
            this.src = null;
            this.dep = null;
            this.fn = null;
            return completableFuture.postFire(completableFuture3, i);
        }
    }

    private <V> CompletableFuture<V> uniComposeStage(Executor executor, Function<? super T, ? extends CompletionStage<V>> function) {
        Util.requireNonNull(function);
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        AltResult altResult = (Object) this.result;
        if (altResult == null) {
            unipush(new UniCompose(executor, completableFuture, this, function));
            return completableFuture;
        }
        if (altResult instanceof AltResult) {
            Throwable th = altResult.ex;
            if (th != null) {
                completableFuture.result = encodeThrowable(th, altResult);
                return completableFuture;
            }
            altResult = null;
        }
        try {
            if (executor != null) {
                executor.execute(new UniCompose(null, completableFuture, this, function));
                return completableFuture;
            }
            CompletableFuture<V> completableFuture2 = function.apply(altResult).toCompletableFuture();
            Object obj = completableFuture2.result;
            if (obj != null) {
                completableFuture.result = encodeRelay(obj);
                return completableFuture;
            }
            completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
            return completableFuture;
        } catch (Throwable th2) {
            completableFuture.result = encodeThrowable(th2);
            return completableFuture;
        }
    }

    static abstract class BiCompletion<T, U, V> extends UniCompletion<T, V> {
        CompletableFuture<U> snd;

        BiCompletion(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3) {
            super(executor, completableFuture, completableFuture2);
            this.snd = completableFuture3;
        }
    }

    static final class CoCompletion extends Completion {
        BiCompletion<?, ?, ?> base;

        CoCompletion(BiCompletion<?, ?, ?> biCompletion) {
            this.base = biCompletion;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<?> tryFire(int i) {
            CompletableFuture<?> completableFutureTryFire;
            BiCompletion<?, ?, ?> biCompletion = this.base;
            if (biCompletion == null || (completableFutureTryFire = biCompletion.tryFire(i)) == null) {
                return null;
            }
            this.base = null;
            return completableFutureTryFire;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            BiCompletion<?, ?, ?> biCompletion = this.base;
            return (biCompletion == null || biCompletion.dep == null) ? false : true;
        }
    }

    final void bipush(CompletableFuture<?> completableFuture, BiCompletion<?, ?, ?> biCompletion) {
        if (biCompletion != null) {
            while (this.result == null) {
                if (tryPushStack(biCompletion)) {
                    if (completableFuture.result == null) {
                        completableFuture.unipush(new CoCompletion(biCompletion));
                        return;
                    } else {
                        if (this.result != null) {
                            biCompletion.tryFire(0);
                            return;
                        }
                        return;
                    }
                }
            }
            completableFuture.unipush(biCompletion);
        }
    }

    final CompletableFuture<T> postFire(CompletableFuture<?> completableFuture, CompletableFuture<?> completableFuture2, int i) {
        if (completableFuture2 != null && completableFuture2.stack != null) {
            Object obj = completableFuture2.result;
            if (obj == null) {
                completableFuture2.cleanStack();
            }
            if (i >= 0 && (obj != null || completableFuture2.result != null)) {
                completableFuture2.postComplete();
            }
        }
        return postFire(completableFuture, i);
    }

    static final class BiApply<T, U, V> extends BiCompletion<T, U, V> {
        BiFunction<? super T, ? super U, ? extends V> fn;

        BiApply(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = biFunction;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i) {
            Object obj;
            CompletableFuture<U> completableFuture;
            Object obj2;
            CompletableFuture<V> completableFuture2;
            BiFunction<? super T, ? super U, ? extends V> biFunction;
            CompletableFuture<T> completableFuture3 = this.src;
            if (completableFuture3 != null && (obj = completableFuture3.result) != null && (completableFuture = this.snd) != null && (obj2 = completableFuture.result) != null && (completableFuture2 = this.dep) != null && (biFunction = this.fn) != 0) {
                if (completableFuture2.biApply(obj, obj2, biFunction, i > 0 ? null : this)) {
                    this.src = null;
                    this.snd = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture2.postFire(completableFuture3, completableFuture, i);
                }
            }
            return null;
        }
    }

    final <R, S> boolean biApply(Object obj, Object obj2, BiFunction<? super R, ? super S, ? extends T> biFunction, BiApply<R, S, T> biApply) {
        if (this.result != null) {
            return true;
        }
        if (obj instanceof AltResult) {
            Throwable th = ((AltResult) obj).ex;
            if (th != null) {
                completeThrowable(th, obj);
                return true;
            }
            obj = null;
        }
        if (obj2 instanceof AltResult) {
            Throwable th2 = ((AltResult) obj2).ex;
            if (th2 != null) {
                completeThrowable(th2, obj2);
                return true;
            }
            obj2 = null;
        }
        if (biApply != null) {
            try {
                if (!biApply.claim()) {
                    return false;
                }
            } catch (Throwable th3) {
                completeThrowable(th3);
                return true;
            }
        }
        completeValue(biFunction.apply(obj, obj2));
        return true;
    }

    private <U, V> CompletableFuture<V> biApplyStage(Executor executor, CompletionStage<U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        CompletableFuture<U> completableFuture;
        Object obj;
        if (biFunction == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        CompletableFuture<U> completableFutureNewIncompleteFuture = newIncompleteFuture();
        Object obj2 = this.result;
        if (obj2 == null || (obj = completableFuture.result) == null) {
            bipush(completableFuture, new BiApply(executor, completableFutureNewIncompleteFuture, this, completableFuture, biFunction));
            return completableFutureNewIncompleteFuture;
        }
        if (executor == null) {
            completableFutureNewIncompleteFuture.biApply(obj2, obj, biFunction, null);
            return completableFutureNewIncompleteFuture;
        }
        try {
            executor.execute(new BiApply(null, completableFutureNewIncompleteFuture, this, completableFuture, biFunction));
            return completableFutureNewIncompleteFuture;
        } catch (Throwable th) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th);
            return completableFutureNewIncompleteFuture;
        }
    }

    static final class BiAccept<T, U> extends BiCompletion<T, U, Void> {
        BiConsumer<? super T, ? super U> fn;

        BiAccept(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, BiConsumer<? super T, ? super U> biConsumer) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = biConsumer;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r9) {
            /*
                r8 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = 0
                if (r0 == 0) goto L32
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L32
                java8.util.concurrent.CompletableFuture<U> r3 = r8.snd
                if (r3 == 0) goto L32
                java.lang.Object r4 = r3.result
                if (r4 == 0) goto L32
                java8.util.concurrent.CompletableFuture<V> r5 = r8.dep
                if (r5 == 0) goto L32
                java8.util.function.BiConsumer<? super T, ? super U> r6 = r8.fn
                if (r6 == 0) goto L32
                if (r9 <= 0) goto L1d
                r7 = r1
                goto L1e
            L1d:
                r7 = r8
            L1e:
                boolean r2 = r5.biAccept(r2, r4, r6, r7)
                if (r2 != 0) goto L25
                goto L32
            L25:
                r8.src = r1
                r8.snd = r1
                r8.dep = r1
                r8.fn = r1
                java8.util.concurrent.CompletableFuture r8 = r5.postFire(r0, r3, r9)
                return r8
            L32:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.BiAccept.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    final <R, S> boolean biAccept(Object obj, Object obj2, BiConsumer<? super R, ? super S> biConsumer, BiAccept<R, S> biAccept) {
        if (this.result != null) {
            return true;
        }
        if (obj instanceof AltResult) {
            Throwable th = ((AltResult) obj).ex;
            if (th != null) {
                completeThrowable(th, obj);
                return true;
            }
            obj = null;
        }
        if (obj2 instanceof AltResult) {
            Throwable th2 = ((AltResult) obj2).ex;
            if (th2 != null) {
                completeThrowable(th2, obj2);
                return true;
            }
            obj2 = null;
        }
        if (biAccept != null) {
            try {
                if (!biAccept.claim()) {
                    return false;
                }
            } catch (Throwable th3) {
                completeThrowable(th3);
                return true;
            }
        }
        biConsumer.accept(obj, obj2);
        completeNull();
        return true;
    }

    private <U> CompletableFuture<Void> biAcceptStage(Executor executor, CompletionStage<U> completionStage, BiConsumer<? super T, ? super U> biConsumer) {
        CompletableFuture<U> completableFuture;
        Object obj;
        if (biConsumer == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        CompletableFuture<U> completableFutureNewIncompleteFuture = newIncompleteFuture();
        Object obj2 = this.result;
        if (obj2 == null || (obj = completableFuture.result) == null) {
            bipush(completableFuture, new BiAccept(executor, completableFutureNewIncompleteFuture, this, completableFuture, biConsumer));
            return completableFutureNewIncompleteFuture;
        }
        if (executor == null) {
            completableFutureNewIncompleteFuture.biAccept(obj2, obj, biConsumer, null);
            return completableFutureNewIncompleteFuture;
        }
        try {
            executor.execute(new BiAccept(null, completableFutureNewIncompleteFuture, this, completableFuture, biConsumer));
            return completableFutureNewIncompleteFuture;
        } catch (Throwable th) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th);
            return completableFutureNewIncompleteFuture;
        }
    }

    static final class BiRun<T, U> extends BiCompletion<T, U, Void> {
        Runnable fn;

        BiRun(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, Runnable runnable) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = runnable;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v3 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r9) {
            /*
                r8 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = 0
                if (r0 == 0) goto L32
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L32
                java8.util.concurrent.CompletableFuture<U> r3 = r8.snd
                if (r3 == 0) goto L32
                java.lang.Object r4 = r3.result
                if (r4 == 0) goto L32
                java8.util.concurrent.CompletableFuture<V> r5 = r8.dep
                if (r5 == 0) goto L32
                java.lang.Runnable r6 = r8.fn
                if (r6 == 0) goto L32
                if (r9 <= 0) goto L1d
                r7 = r1
                goto L1e
            L1d:
                r7 = r8
            L1e:
                boolean r2 = r5.biRun(r2, r4, r6, r7)
                if (r2 != 0) goto L25
                goto L32
            L25:
                r8.src = r1
                r8.snd = r1
                r8.dep = r1
                r8.fn = r1
                java8.util.concurrent.CompletableFuture r8 = r5.postFire(r0, r3, r9)
                return r8
            L32:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.BiRun.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    final boolean biRun(Object obj, Object obj2, Runnable runnable, BiRun<?, ?> biRun) {
        Throwable th;
        if (this.result != null) {
            return true;
        }
        if (!(obj instanceof AltResult) || (th = ((AltResult) obj).ex) == null) {
            if (!(obj2 instanceof AltResult) || (th = ((AltResult) obj2).ex) == null) {
                if (biRun != null) {
                    try {
                        if (!biRun.claim()) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        completeThrowable(th2);
                        return true;
                    }
                }
                runnable.run();
                completeNull();
                return true;
            }
            obj = obj2;
        }
        completeThrowable(th, obj);
        return true;
    }

    private CompletableFuture<Void> biRunStage(Executor executor, CompletionStage<?> completionStage, Runnable runnable) {
        CompletableFuture<?> completableFuture;
        Object obj;
        if (runnable == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
        Object obj2 = this.result;
        if (obj2 == null || (obj = completableFuture.result) == null) {
            bipush(completableFuture, new BiRun(executor, completableFutureNewIncompleteFuture, this, completableFuture, runnable));
            return completableFutureNewIncompleteFuture;
        }
        if (executor == null) {
            completableFutureNewIncompleteFuture.biRun(obj2, obj, runnable, null);
            return completableFutureNewIncompleteFuture;
        }
        try {
            executor.execute(new BiRun(null, completableFutureNewIncompleteFuture, this, completableFuture, runnable));
            return completableFutureNewIncompleteFuture;
        } catch (Throwable th) {
            completableFutureNewIncompleteFuture.result = encodeThrowable(th);
            return completableFutureNewIncompleteFuture;
        }
    }

    static final class BiRelay<T, U> extends BiCompletion<T, U, Void> {
        BiRelay(CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3) {
            super(null, completableFuture, completableFuture2, completableFuture3);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r9) {
            /*
                r8 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = 0
                if (r0 == 0) goto L49
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L49
                java8.util.concurrent.CompletableFuture<U> r3 = r8.snd
                if (r3 == 0) goto L49
                java.lang.Object r4 = r3.result
                if (r4 == 0) goto L49
                java8.util.concurrent.CompletableFuture<V> r5 = r8.dep
                if (r5 != 0) goto L16
                goto L49
            L16:
                java.lang.Object r6 = r5.result
                if (r6 != 0) goto L3e
                boolean r6 = r2 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r6 == 0) goto L28
                r6 = r2
                java8.util.concurrent.CompletableFuture$AltResult r6 = (java8.util.concurrent.CompletableFuture.AltResult) r6
                r7 = r6
                java8.util.concurrent.CompletableFuture$AltResult r7 = (java8.util.concurrent.CompletableFuture.AltResult) r7
                java.lang.Throwable r6 = r6.ex
                if (r6 != 0) goto L37
            L28:
                boolean r2 = r4 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r2 == 0) goto L3b
                r2 = r4
                java8.util.concurrent.CompletableFuture$AltResult r2 = (java8.util.concurrent.CompletableFuture.AltResult) r2
                r6 = r2
                java8.util.concurrent.CompletableFuture$AltResult r6 = (java8.util.concurrent.CompletableFuture.AltResult) r6
                java.lang.Throwable r6 = r2.ex
                if (r6 == 0) goto L3b
                r2 = r4
            L37:
                r5.completeThrowable(r6, r2)
                goto L3e
            L3b:
                r5.completeNull()
            L3e:
                r8.src = r1
                r8.snd = r1
                r8.dep = r1
                java8.util.concurrent.CompletableFuture r8 = r5.postFire(r0, r3, r9)
                return r8
            L49:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.BiRelay.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    static CompletableFuture<Void> andTree(CompletableFuture<?>[] completableFutureArr, int i, int i2) {
        CompletableFuture<?> completableFutureAndTree;
        CompletableFuture<?> completableFutureAndTree2;
        Object obj;
        Throwable th;
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        if (i > i2) {
            completableFuture.result = NIL;
            return completableFuture;
        }
        int i3 = (i + i2) >>> 1;
        if (i == i3) {
            completableFutureAndTree = completableFutureArr[i];
        } else {
            completableFutureAndTree = andTree(completableFutureArr, i, i3);
        }
        if (completableFutureAndTree != null) {
            if (i == i2) {
                completableFutureAndTree2 = completableFutureAndTree;
            } else {
                int i4 = i3 + 1;
                completableFutureAndTree2 = i2 == i4 ? completableFutureArr[i2] : andTree(completableFutureArr, i4, i2);
            }
            if (completableFutureAndTree2 != null) {
                Object obj2 = completableFutureAndTree.result;
                if (obj2 == null || (obj = completableFutureAndTree2.result) == null) {
                    completableFutureAndTree.bipush(completableFutureAndTree2, new BiRelay(completableFuture, completableFutureAndTree, completableFutureAndTree2));
                    return completableFuture;
                }
                if (!(obj2 instanceof AltResult) || (th = ((AltResult) obj2).ex) == null) {
                    if (!(obj instanceof AltResult) || (th = ((AltResult) obj).ex) == null) {
                        completableFuture.result = NIL;
                        return completableFuture;
                    }
                    obj2 = obj;
                }
                completableFuture.result = encodeThrowable(th, obj2);
                return completableFuture;
            }
        }
        throw null;
    }

    final void orpush(CompletableFuture<?> completableFuture, BiCompletion<?, ?, ?> biCompletion) {
        if (biCompletion != null) {
            while (!tryPushStack(biCompletion)) {
                if (this.result != null) {
                    lazySetNext(biCompletion, null);
                    break;
                }
            }
            if (this.result != null) {
                biCompletion.tryFire(0);
            } else {
                completableFuture.unipush(new CoCompletion(biCompletion));
            }
        }
    }

    static final class OrApply<T, U extends T, V> extends BiCompletion<T, U, V> {
        Function<? super T, ? extends V> fn;

        OrApply(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, Function<? super T, ? extends V> function) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = function;
        }

        /* JADX WARN: Code duplicated, block: B:23:0x002b A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:18:0x0020, B:21:0x0027, B:23:0x002b, B:25:0x0032, B:27:0x0037), top: B:34:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0032 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:18:0x0020, B:21:0x0027, B:23:0x002b, B:25:0x0032, B:27:0x0037), top: B:34:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0036  */
        /* JADX WARN: Code duplicated, block: B:27:0x0037 A[Catch: all -> 0x003f, PHI: r3
          0x0037: PHI (r3v3 java.lang.Object) = (r3v1 java.lang.Object), (r3v5 java.lang.Object) binds: [B:22:0x0029, B:26:0x0036] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x003f, blocks: (B:18:0x0020, B:21:0x0027, B:23:0x002b, B:25:0x0032, B:27:0x0037), top: B:34:0x0020 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i) {
            CompletableFuture<U> completableFuture;
            Object obj;
            CompletableFuture<V> completableFuture2;
            Function<? super T, ? extends V> function;
            Throwable th;
            CompletableFuture<T> completableFuture3 = this.src;
            if (completableFuture3 == null || (completableFuture = this.snd) == null || (((obj = completableFuture3.result) == null && (obj = completableFuture.result) == null) || (completableFuture2 = this.dep) == null || (function = this.fn) == null)) {
                return null;
            }
            if (completableFuture2.result == null) {
                if (i <= 0) {
                    try {
                        if (!claim()) {
                            return null;
                        }
                        if (!(obj instanceof AltResult)) {
                            th = ((AltResult) obj).ex;
                            if (th != null) {
                                completableFuture2.completeThrowable(th, obj);
                            } else {
                                obj = null;
                                completableFuture2.completeValue(function.apply(obj));
                            }
                        } else {
                            completableFuture2.completeValue(function.apply(obj));
                        }
                    } catch (Throwable th2) {
                        completableFuture2.completeThrowable(th2);
                    }
                } else if (!(obj instanceof AltResult)) {
                    th = ((AltResult) obj).ex;
                    if (th != null) {
                        completableFuture2.completeThrowable(th, obj);
                    } else {
                        obj = null;
                        completableFuture2.completeValue(function.apply(obj));
                    }
                } else {
                    completableFuture2.completeValue(function.apply(obj));
                }
            }
            this.src = null;
            this.snd = null;
            this.dep = null;
            this.fn = null;
            return completableFuture2.postFire((CompletableFuture<?>) completableFuture3, (CompletableFuture<?>) completableFuture, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java8.util.concurrent.CompletableFuture] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    private <U extends T, V> CompletableFuture<V> orApplyStage(Executor executor, CompletionStage<U> completionStage, Function<? super T, ? extends V> function) {
        CompletableFuture<U> completableFuture;
        ?? r6;
        if (function == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        Object obj = this.result;
        if (obj == null) {
            obj = completableFuture.result;
            if (obj == null) {
                CompletableFuture<V> completableFuture2 = (CompletableFuture<V>) newIncompleteFuture();
                orpush(completableFuture, new OrApply(executor, completableFuture2, this, completableFuture, function));
                return completableFuture2;
            }
            r6 = completableFuture;
        } else {
            this = this;
        }
        return r6.uniApplyNow(obj, executor, function);
    }

    static final class OrAccept<T, U extends T> extends BiCompletion<T, U, Void> {
        Consumer<? super T> fn;

        OrAccept(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, Consumer<? super T> consumer) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = consumer;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r8) {
            /*
                r7 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r7.src
                r1 = 0
                if (r0 == 0) goto L4f
                java8.util.concurrent.CompletableFuture<U> r2 = r7.snd
                if (r2 == 0) goto L4f
                java.lang.Object r3 = r0.result
                if (r3 != 0) goto L11
                java.lang.Object r3 = r2.result
                if (r3 == 0) goto L4f
            L11:
                java8.util.concurrent.CompletableFuture<V> r4 = r7.dep
                if (r4 == 0) goto L4f
                java8.util.function.Consumer<? super T> r5 = r7.fn
                if (r5 != 0) goto L1a
                goto L4f
            L1a:
                java.lang.Object r6 = r4.result
                if (r6 != 0) goto L42
                if (r8 > 0) goto L27
                boolean r6 = r7.claim()     // Catch: java.lang.Throwable -> L3e
                if (r6 != 0) goto L27
                return r1
            L27:
                boolean r6 = r3 instanceof java8.util.concurrent.CompletableFuture.AltResult     // Catch: java.lang.Throwable -> L3e
                if (r6 == 0) goto L37
                r6 = r3
                java8.util.concurrent.CompletableFuture$AltResult r6 = (java8.util.concurrent.CompletableFuture.AltResult) r6     // Catch: java.lang.Throwable -> L3e
                java.lang.Throwable r6 = r6.ex     // Catch: java.lang.Throwable -> L3e
                if (r6 == 0) goto L36
                r4.completeThrowable(r6, r3)     // Catch: java.lang.Throwable -> L3e
                goto L42
            L36:
                r3 = r1
            L37:
                r5.accept(r3)     // Catch: java.lang.Throwable -> L3e
                r4.completeNull()     // Catch: java.lang.Throwable -> L3e
                goto L42
            L3e:
                r3 = move-exception
                r4.completeThrowable(r3)
            L42:
                r7.src = r1
                r7.snd = r1
                r7.dep = r1
                r7.fn = r1
                java8.util.concurrent.CompletableFuture r7 = r4.postFire(r0, r2, r8)
                return r7
            L4f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.OrAccept.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private <U extends T> CompletableFuture<Void> orAcceptStage(Executor executor, CompletionStage<U> completionStage, Consumer<? super T> consumer) {
        CompletableFuture<T> completableFuture;
        if (consumer == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        Object obj = this.result;
        if (obj == null) {
            obj = completableFuture.result;
            if (obj == null) {
                CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
                orpush(completableFuture, new OrAccept(executor, completableFutureNewIncompleteFuture, this, completableFuture, consumer));
                return completableFutureNewIncompleteFuture;
            }
            this = completableFuture;
        }
        return this.uniAcceptNow(obj, executor, consumer);
    }

    static final class OrRun<T, U> extends BiCompletion<T, U, Void> {
        Runnable fn;

        OrRun(Executor executor, CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3, Runnable runnable) {
            super(executor, completableFuture, completableFuture2, completableFuture3);
            this.fn = runnable;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // java8.util.concurrent.CompletableFuture.Completion
        final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r8) {
            /*
                r7 = this;
                java8.util.concurrent.CompletableFuture<V> r0 = r7.dep
                r1 = 0
                if (r0 == 0) goto L4e
                java.lang.Runnable r2 = r7.fn
                if (r2 == 0) goto L4e
                java8.util.concurrent.CompletableFuture<T> r3 = r7.src
                if (r3 == 0) goto L4e
                java8.util.concurrent.CompletableFuture<U> r4 = r7.snd
                if (r4 == 0) goto L4e
                java.lang.Object r5 = r3.result
                if (r5 != 0) goto L1a
                java.lang.Object r5 = r4.result
                if (r5 != 0) goto L1a
                goto L4e
            L1a:
                java.lang.Object r6 = r0.result
                if (r6 != 0) goto L41
                if (r8 > 0) goto L27
                boolean r6 = r7.claim()     // Catch: java.lang.Throwable -> L3d
                if (r6 != 0) goto L27
                return r1
            L27:
                boolean r6 = r5 instanceof java8.util.concurrent.CompletableFuture.AltResult     // Catch: java.lang.Throwable -> L3d
                if (r6 == 0) goto L36
                r6 = r5
                java8.util.concurrent.CompletableFuture$AltResult r6 = (java8.util.concurrent.CompletableFuture.AltResult) r6     // Catch: java.lang.Throwable -> L3d
                java.lang.Throwable r6 = r6.ex     // Catch: java.lang.Throwable -> L3d
                if (r6 == 0) goto L36
                r0.completeThrowable(r6, r5)     // Catch: java.lang.Throwable -> L3d
                goto L41
            L36:
                r2.run()     // Catch: java.lang.Throwable -> L3d
                r0.completeNull()     // Catch: java.lang.Throwable -> L3d
                goto L41
            L3d:
                r2 = move-exception
                r0.completeThrowable(r2)
            L41:
                r7.src = r1
                r7.snd = r1
                r7.dep = r1
                r7.fn = r1
                java8.util.concurrent.CompletableFuture r7 = r0.postFire(r3, r4, r8)
                return r7
            L4e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.OrRun.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    private CompletableFuture<Void> orRunStage(Executor executor, CompletionStage<?> completionStage, Runnable runnable) {
        CompletableFuture<T> completableFuture;
        if (runnable == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw null;
        }
        Object obj = this.result;
        if (obj == null) {
            obj = completableFuture.result;
            if (obj == null) {
                CompletableFuture completableFutureNewIncompleteFuture = newIncompleteFuture();
                orpush(completableFuture, new OrRun(executor, completableFutureNewIncompleteFuture, this, completableFuture, runnable));
                return completableFutureNewIncompleteFuture;
            }
            this = completableFuture;
        }
        return this.uniRunNow(obj, executor, runnable);
    }

    static class AnyOf extends Completion {
        CompletableFuture<Object> dep;
        CompletableFuture<?> src;
        CompletableFuture<?>[] srcs;

        AnyOf(CompletableFuture<Object> completableFuture, CompletableFuture<?> completableFuture2, CompletableFuture<?>[] completableFutureArr) {
            this.dep = completableFuture;
            this.src = completableFuture2;
            this.srcs = completableFutureArr;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Object> tryFire(int i) {
            Object obj;
            CompletableFuture<Object> completableFuture;
            CompletableFuture<?>[] completableFutureArr;
            CompletableFuture<?> completableFuture2 = this.src;
            if (completableFuture2 != null && (obj = completableFuture2.result) != null && (completableFuture = this.dep) != null && (completableFutureArr = this.srcs) != null) {
                this.src = null;
                this.dep = null;
                this.srcs = null;
                if (completableFuture.completeRelay(obj)) {
                    for (CompletableFuture<?> completableFuture3 : completableFutureArr) {
                        if (completableFuture3 != completableFuture2) {
                            completableFuture3.cleanStack();
                        }
                    }
                    if (i < 0) {
                        return completableFuture;
                    }
                    completableFuture.postComplete();
                }
            }
            return null;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            CompletableFuture<Object> completableFuture = this.dep;
            return completableFuture != null && completableFuture.result == null;
        }
    }

    static final class AsyncSupply<T> extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        CompletableFuture<T> dep;
        Supplier<? extends T> fn;

        @Override // java8.util.concurrent.FJTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java8.util.concurrent.FJTask
        public final void setRawResult(Void r1) {
        }

        AsyncSupply(CompletableFuture<T> completableFuture, Supplier<? extends T> supplier) {
            this.dep = completableFuture;
            this.fn = supplier;
        }

        @Override // java8.util.concurrent.FJTask
        public final boolean exec() {
            run();
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Supplier<? extends T> supplier;
            CompletableFuture<T> completableFuture = this.dep;
            if (completableFuture == null || (supplier = this.fn) == null) {
                return;
            }
            this.dep = null;
            this.fn = null;
            if (completableFuture.result == null) {
                try {
                    completableFuture.completeValue(supplier.get());
                } catch (Throwable th) {
                    completableFuture.completeThrowable(th);
                }
            }
            completableFuture.postComplete();
        }
    }

    static <U> CompletableFuture<U> asyncSupplyStage(Executor executor, Supplier<U> supplier) {
        Util.requireNonNull(supplier);
        CompletableFuture<U> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncSupply(completableFuture, supplier));
        return completableFuture;
    }

    static final class AsyncRun extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        CompletableFuture<Void> dep;
        Runnable fn;

        @Override // java8.util.concurrent.FJTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java8.util.concurrent.FJTask
        public final void setRawResult(Void r1) {
        }

        AsyncRun(CompletableFuture<Void> completableFuture, Runnable runnable) {
            this.dep = completableFuture;
            this.fn = runnable;
        }

        @Override // java8.util.concurrent.FJTask
        public final boolean exec() {
            run();
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            CompletableFuture<Void> completableFuture = this.dep;
            if (completableFuture == null || (runnable = this.fn) == null) {
                return;
            }
            this.dep = null;
            this.fn = null;
            if (completableFuture.result == null) {
                try {
                    runnable.run();
                    completableFuture.completeNull();
                } catch (Throwable th) {
                    completableFuture.completeThrowable(th);
                }
            }
            completableFuture.postComplete();
        }
    }

    static CompletableFuture<Void> asyncRunStage(Executor executor, Runnable runnable) {
        Util.requireNonNull(runnable);
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncRun(completableFuture, runnable));
        return completableFuture;
    }

    static final class Signaller extends Completion implements FJPool.ManagedBlocker {
        final long deadline;
        boolean interrupted;
        final boolean interruptible;
        long nanos;
        volatile Thread thread = Thread.currentThread();

        Signaller(boolean z, long j, long j2) {
            this.interruptible = z;
            this.nanos = j;
            this.deadline = j2;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<?> tryFire(int i) {
            Thread thread = this.thread;
            if (thread != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002a  */
        /* JADX WARN: Code duplicated, block: B:18:0x002f A[RETURN] */
        @Override // java8.util.concurrent.FJPool.ManagedBlocker
        public boolean isReleasable() {
            if (Thread.interrupted()) {
                this.interrupted = true;
            }
            if (!this.interrupted || !this.interruptible) {
                long j = this.deadline;
                if (j == 0) {
                    if (this.thread == null) {
                        return false;
                    }
                } else if (this.nanos > 0) {
                    long jNanoTime = j - System.nanoTime();
                    this.nanos = jNanoTime;
                    if (jNanoTime > 0) {
                        if (this.thread == null) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        @Override // java8.util.concurrent.FJPool.ManagedBlocker
        public boolean block() {
            while (!isReleasable()) {
                if (this.deadline == 0) {
                    LockSupport.park(this);
                } else {
                    LockSupport.parkNanos(this, this.nanos);
                }
            }
            return true;
        }

        @Override // java8.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            return this.thread != null;
        }
    }

    private Object waitingGet(boolean z) {
        boolean z2;
        if (z && Thread.interrupted()) {
            return null;
        }
        boolean zTryPushStack = false;
        Signaller signaller = null;
        while (true) {
            Object obj = this.result;
            if (obj != null) {
                if (signaller != null) {
                    signaller.thread = null;
                    if (signaller.interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
                postComplete();
                return obj;
            }
            if (signaller == null) {
                z2 = z;
                Signaller signaller2 = new Signaller(z2, 0L, 0L);
                if (Thread.currentThread() instanceof FJWorkerThread) {
                    FJPool.helpAsyncBlocker(defaultExecutor(), signaller2);
                }
                signaller = signaller2;
            } else {
                z2 = z;
                if (!zTryPushStack) {
                    zTryPushStack = tryPushStack(signaller);
                } else {
                    if (z2 && signaller.interrupted) {
                        signaller.thread = null;
                        cleanStack();
                        return null;
                    }
                    try {
                        FJPool.managedBlock(signaller);
                    } catch (InterruptedException unused) {
                        signaller.interrupted = true;
                    }
                }
            }
            z = z2;
        }
    }

    private Object timedGet(long j) throws TimeoutException {
        long jNanoTime = System.nanoTime() + j;
        if (jNanoTime == 0) {
            jNanoTime = 1;
        }
        long j2 = jNanoTime;
        boolean zInterrupted = false;
        long j3 = j;
        boolean zTryPushStack = false;
        Signaller signaller = null;
        Object obj = null;
        while (!zInterrupted) {
            zInterrupted = Thread.interrupted();
            if (!zInterrupted) {
                Object obj2 = this.result;
                if (obj2 != null || j3 <= 0) {
                    obj = obj2;
                    break;
                }
                if (signaller == null) {
                    Signaller signaller2 = new Signaller(true, j3, j2);
                    if (Thread.currentThread() instanceof FJWorkerThread) {
                        FJPool.helpAsyncBlocker(defaultExecutor(), signaller2);
                    }
                    signaller = signaller2;
                } else if (!zTryPushStack) {
                    zTryPushStack = tryPushStack(signaller);
                } else {
                    try {
                        FJPool.managedBlock(signaller);
                        zInterrupted = signaller.interrupted;
                        j3 = signaller.nanos;
                    } catch (InterruptedException unused) {
                        zInterrupted = true;
                    }
                }
                obj = obj2;
            } else {
                break;
            }
        }
        if (signaller != null) {
            signaller.thread = null;
            if (obj == null) {
                cleanStack();
            }
        }
        if (obj == null) {
            if (zInterrupted) {
                return null;
            }
            throw new TimeoutException();
        }
        if (zInterrupted) {
            Thread.currentThread().interrupt();
        }
        postComplete();
        return obj;
    }

    public CompletableFuture() {
    }

    CompletableFuture(Object obj) {
        this.result = obj;
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return asyncSupplyStage(ASYNC_POOL, supplier);
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor) {
        return asyncSupplyStage(screenExecutor(executor), supplier);
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return asyncRunStage(ASYNC_POOL, runnable);
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor) {
        return asyncRunStage(screenExecutor(executor), runnable);
    }

    public static <U> CompletableFuture<U> completedFuture(U u) {
        if (u == null) {
            u = (U) NIL;
        }
        return new CompletableFuture<>(u);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.result != null;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        Object objWaitingGet = this.result;
        if (objWaitingGet == null) {
            objWaitingGet = waitingGet(true);
        }
        return (T) reportGet(objWaitingGet);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        Object objTimedGet = this.result;
        if (objTimedGet == null) {
            objTimedGet = timedGet(nanos);
        }
        return (T) reportGet(objTimedGet);
    }

    public T join() {
        Object objWaitingGet = this.result;
        if (objWaitingGet == null) {
            objWaitingGet = waitingGet(false);
        }
        return (T) reportJoin(objWaitingGet);
    }

    public T getNow(T t) {
        Object obj = this.result;
        return obj == null ? t : (T) reportJoin(obj);
    }

    public boolean complete(T t) {
        boolean zCompleteValue = completeValue(t);
        postComplete();
        return zCompleteValue;
    }

    public boolean completeExceptionally(Throwable th) {
        boolean zInternalComplete = internalComplete(new AltResult((Throwable) Util.requireNonNull(th)));
        postComplete();
        return zInternalComplete;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenApply(Function<? super T, ? extends U> function) {
        return (CompletableFuture<U>) uniApplyStage(null, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> function) {
        return (CompletableFuture<U>) uniApplyStage(defaultExecutor(), function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> function, Executor executor) {
        return (CompletableFuture<U>) uniApplyStage(screenExecutor(executor), function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAccept(Consumer<? super T> consumer) {
        return uniAcceptStage(null, consumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> consumer) {
        return uniAcceptStage(defaultExecutor(), consumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> consumer, Executor executor) {
        return uniAcceptStage(screenExecutor(executor), consumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRun(Runnable runnable) {
        return uniRunStage(null, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRunAsync(Runnable runnable) {
        return uniRunStage(defaultExecutor(), runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRunAsync(Runnable runnable, Executor executor) {
        return uniRunStage(screenExecutor(executor), runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U, V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        return biApplyStage(null, completionStage, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        return biApplyStage(defaultExecutor(), completionStage, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction, Executor executor) {
        return biApplyStage(screenExecutor(executor), completionStage, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer) {
        return biAcceptStage(null, completionStage, biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer) {
        return biAcceptStage(defaultExecutor(), completionStage, biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer, Executor executor) {
        return biAcceptStage(screenExecutor(executor), completionStage, biConsumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBoth(CompletionStage<?> completionStage, Runnable runnable) {
        return biRunStage(null, completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> completionStage, Runnable runnable) {
        return biRunStage(defaultExecutor(), completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> completionStage, Runnable runnable, Executor executor) {
        return biRunStage(screenExecutor(executor), completionStage, runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEither(CompletionStage<? extends T> completionStage, Function<? super T, U> function) {
        return (CompletableFuture<U>) orApplyStage(null, completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function) {
        return (CompletableFuture<U>) orApplyStage(defaultExecutor(), completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function, Executor executor) {
        return (CompletableFuture<U>) orApplyStage(screenExecutor(executor), completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEither(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer) {
        return orAcceptStage(null, completionStage, consumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer) {
        return orAcceptStage(defaultExecutor(), completionStage, consumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer, Executor executor) {
        return orAcceptStage(screenExecutor(executor), completionStage, consumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEither(CompletionStage<?> completionStage, Runnable runnable) {
        return orRunStage(null, completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> completionStage, Runnable runnable) {
        return orRunStage(defaultExecutor(), completionStage, runnable);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> completionStage, Runnable runnable, Executor executor) {
        return orRunStage(screenExecutor(executor), completionStage, runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> function) {
        return (CompletableFuture<U>) uniComposeStage(null, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function) {
        return (CompletableFuture<U>) uniComposeStage(defaultExecutor(), function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function, Executor executor) {
        return (CompletableFuture<U>) uniComposeStage(screenExecutor(executor), function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> biConsumer) {
        return uniWhenCompleteStage(null, biConsumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> biConsumer) {
        return uniWhenCompleteStage(defaultExecutor(), biConsumer);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> biConsumer, Executor executor) {
        return uniWhenCompleteStage(screenExecutor(executor), biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> biFunction) {
        return (CompletableFuture<U>) uniHandleStage(null, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction) {
        return (CompletableFuture<U>) uniHandleStage(defaultExecutor(), biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction, Executor executor) {
        return (CompletableFuture<U>) uniHandleStage(screenExecutor(executor), biFunction);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> function) {
        return uniExceptionallyStage(null, function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyAsync(Function<Throwable, ? extends T> function) {
        return uniExceptionallyStage(defaultExecutor(), function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyAsync(Function<Throwable, ? extends T> function, Executor executor) {
        return uniExceptionallyStage(screenExecutor(executor), function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyCompose(Function<Throwable, ? extends CompletionStage<T>> function) {
        return uniComposeExceptionallyStage(null, function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyComposeAsync(Function<Throwable, ? extends CompletionStage<T>> function) {
        return uniComposeExceptionallyStage(defaultExecutor(), function);
    }

    @Override // java8.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyComposeAsync(Function<Throwable, ? extends CompletionStage<T>> function, Executor executor) {
        return uniComposeExceptionallyStage(screenExecutor(executor), function);
    }

    public static CompletableFuture<Void> allOf(CompletableFuture<?>... completableFutureArr) {
        return andTree(completableFutureArr, 0, completableFutureArr.length - 1);
    }

    public static CompletableFuture<Object> anyOf(CompletableFuture<?>... completableFutureArr) {
        int length = completableFutureArr.length;
        int i = 0;
        if (length <= 1) {
            if (length == 0) {
                return new CompletableFuture<>();
            }
            return uniCopyStage(completableFutureArr[0]);
        }
        for (CompletableFuture<?> completableFuture : completableFutureArr) {
            Object obj = completableFuture.result;
            if (obj != null) {
                return new CompletableFuture<>(encodeRelay(obj));
            }
        }
        CompletableFuture[] completableFutureArr2 = (CompletableFuture[]) completableFutureArr.clone();
        CompletableFuture<Object> completableFuture2 = new CompletableFuture<>();
        for (CompletableFuture completableFuture3 : completableFutureArr2) {
            completableFuture3.unipush(new AnyOf(completableFuture2, completableFuture3, completableFutureArr2));
        }
        if (completableFuture2.result != null) {
            int length2 = completableFutureArr2.length;
            while (i < length2) {
                if (completableFutureArr2[i].result != null) {
                    while (true) {
                        i++;
                        if (i < length2) {
                            if (completableFutureArr2[i].result == null) {
                                completableFutureArr2[i].cleanStack();
                            }
                        }
                    }
                }
                i++;
            }
        }
        return completableFuture2;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = this.result == null && internalComplete(new AltResult(new CancellationException()));
        postComplete();
        return z2 || isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Object obj = this.result;
        return (obj instanceof AltResult) && (((AltResult) obj).ex instanceof CancellationException);
    }

    public boolean isCompletedExceptionally() {
        Object obj = this.result;
        return (obj instanceof AltResult) && obj != NIL;
    }

    public void obtrudeValue(T t) {
        if (t == null) {
            t = (T) NIL;
        }
        this.result = t;
        postComplete();
    }

    public void obtrudeException(Throwable th) {
        this.result = new AltResult((Throwable) Util.requireNonNull(th));
        postComplete();
    }

    public int getNumberOfDependents() {
        int i = 0;
        for (Completion completion = this.stack; completion != null; completion = completion.next) {
            i++;
        }
        return i;
    }

    public String toString() {
        String string;
        StringBuilder sb;
        String str;
        Object obj = this.result;
        int i = 0;
        for (Completion completion = this.stack; completion != null; completion = completion.next) {
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        if (obj != null) {
            if (obj instanceof AltResult) {
                AltResult altResult = (AltResult) obj;
                if (altResult.ex != null) {
                    sb = new StringBuilder("[Completed exceptionally: ");
                    sb.append(altResult.ex);
                    str = "]";
                    sb.append(str);
                    string = sb.toString();
                }
            }
            string = "[Completed normally]";
        } else if (i == 0) {
            string = "[Not completed]";
        } else {
            sb = new StringBuilder("[Not completed, ");
            sb.append(i);
            str = " dependents]";
            sb.append(str);
            string = sb.toString();
        }
        sb2.append(string);
        return sb2.toString();
    }

    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new CompletableFuture<>();
    }

    public Executor defaultExecutor() {
        return ASYNC_POOL;
    }

    public CompletableFuture<T> copy() {
        return uniCopyStage(this);
    }

    public CompletionStage<T> minimalCompletionStage() {
        return uniAsMinimalStage();
    }

    public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
        if (supplier == null || executor == null) {
            throw null;
        }
        executor.execute(new AsyncSupply(this, supplier));
        return this;
    }

    public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier) {
        return completeAsync(supplier, defaultExecutor());
    }

    public CompletableFuture<T> orTimeout(long j, TimeUnit timeUnit) {
        Util.requireNonNull(timeUnit);
        if (this.result == null) {
            whenComplete((BiConsumer) new Canceller(Delayer.delay(new Timeout(this), j, timeUnit)));
        }
        return this;
    }

    public CompletableFuture<T> completeOnTimeout(T t, long j, TimeUnit timeUnit) {
        Util.requireNonNull(timeUnit);
        if (this.result == null) {
            whenComplete((BiConsumer) new Canceller(Delayer.delay(new DelayedCompleter(this, t), j, timeUnit)));
        }
        return this;
    }

    public static Executor delayedExecutor(long j, TimeUnit timeUnit, Executor executor) {
        if (timeUnit == null || executor == null) {
            throw null;
        }
        return new DelayedExecutor(j, timeUnit, executor);
    }

    public static Executor delayedExecutor(long j, TimeUnit timeUnit) {
        return new DelayedExecutor(j, (TimeUnit) Util.requireNonNull(timeUnit), ASYNC_POOL);
    }

    public static <U> CompletionStage<U> completedStage(U u) {
        if (u == null) {
            u = (U) NIL;
        }
        return new MinimalStage(u);
    }

    public static <U> CompletableFuture<U> failedFuture(Throwable th) {
        return new CompletableFuture<>(new AltResult((Throwable) Util.requireNonNull(th)));
    }

    public static <U> CompletionStage<U> failedStage(Throwable th) {
        return new MinimalStage(new AltResult((Throwable) Util.requireNonNull(th)));
    }

    static final class Delayer {
        static final ScheduledThreadPoolExecutor delayer = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory());

        Delayer() {
        }

        static ScheduledFuture<?> delay(Runnable runnable, long j, TimeUnit timeUnit) {
            return delayer.schedule(runnable, j, timeUnit);
        }

        static final class DaemonThreadFactory implements ThreadFactory {
            DaemonThreadFactory() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                thread.setName("CompletableFutureDelayScheduler");
                return thread;
            }
        }
    }

    static final class DelayedExecutor implements Executor {
        final long delay;
        final Executor executor;
        final TimeUnit unit;

        DelayedExecutor(long j, TimeUnit timeUnit, Executor executor) {
            this.delay = j;
            this.unit = timeUnit;
            this.executor = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Delayer.delay(new TaskSubmitter(this.executor, runnable), this.delay, this.unit);
        }
    }

    static final class TaskSubmitter implements Runnable {
        final Runnable action;
        final Executor executor;

        TaskSubmitter(Executor executor, Runnable runnable) {
            this.executor = executor;
            this.action = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.executor.execute(this.action);
        }
    }

    static final class Timeout implements Runnable {
        final CompletableFuture<?> f;

        Timeout(CompletableFuture<?> completableFuture) {
            this.f = completableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompletableFuture<?> completableFuture = this.f;
            if (completableFuture == null || completableFuture.isDone()) {
                return;
            }
            this.f.completeExceptionally(new TimeoutException());
        }
    }

    static final class DelayedCompleter<U> implements Runnable {
        final CompletableFuture<U> f;
        final U u;

        DelayedCompleter(CompletableFuture<U> completableFuture, U u) {
            this.f = completableFuture;
            this.u = u;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompletableFuture<U> completableFuture = this.f;
            if (completableFuture != null) {
                completableFuture.complete(this.u);
            }
        }
    }

    static final class Canceller implements BiConsumer<Object, Throwable> {
        final Future<?> f;

        Canceller(Future<?> future) {
            this.f = future;
        }

        @Override // java8.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Future<?> future;
            if (th != null || (future = this.f) == null || future.isDone()) {
                return;
            }
            this.f.cancel(false);
        }
    }

    static final class MinimalStage<T> extends CompletableFuture<T> {
        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage acceptEither(CompletionStage completionStage, Consumer consumer) {
            return super.acceptEither(completionStage, consumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage acceptEitherAsync(CompletionStage completionStage, Consumer consumer) {
            return super.acceptEitherAsync(completionStage, consumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage acceptEitherAsync(CompletionStage completionStage, Consumer consumer, Executor executor) {
            return super.acceptEitherAsync(completionStage, consumer, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage applyToEither(CompletionStage completionStage, Function function) {
            return super.applyToEither(completionStage, function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage applyToEitherAsync(CompletionStage completionStage, Function function) {
            return super.applyToEitherAsync(completionStage, function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage applyToEitherAsync(CompletionStage completionStage, Function function, Executor executor) {
            return super.applyToEitherAsync(completionStage, function, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionally(Function function) {
            return super.exceptionally(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionallyAsync(Function function) {
            return super.exceptionallyAsync(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionallyAsync(Function function, Executor executor) {
            return super.exceptionallyAsync(function, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionallyCompose(Function function) {
            return super.exceptionallyCompose(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionallyComposeAsync(Function function) {
            return super.exceptionallyComposeAsync(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage exceptionallyComposeAsync(Function function, Executor executor) {
            return super.exceptionallyComposeAsync(function, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage handle(BiFunction biFunction) {
            return super.handle(biFunction);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage handleAsync(BiFunction biFunction) {
            return super.handleAsync(biFunction);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage handleAsync(BiFunction biFunction, Executor executor) {
            return super.handleAsync(biFunction, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterBoth(CompletionStage completionStage, Runnable runnable) {
            return super.runAfterBoth((CompletionStage<?>) completionStage, runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable) {
            return super.runAfterBothAsync((CompletionStage<?>) completionStage, runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
            return super.runAfterBothAsync((CompletionStage<?>) completionStage, runnable, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterEither(CompletionStage completionStage, Runnable runnable) {
            return super.runAfterEither((CompletionStage<?>) completionStage, runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable) {
            return super.runAfterEitherAsync((CompletionStage<?>) completionStage, runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
            return super.runAfterEitherAsync((CompletionStage<?>) completionStage, runnable, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAccept(Consumer consumer) {
            return super.thenAccept(consumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAcceptAsync(Consumer consumer) {
            return super.thenAcceptAsync(consumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAcceptAsync(Consumer consumer, Executor executor) {
            return super.thenAcceptAsync(consumer, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAcceptBoth(CompletionStage completionStage, BiConsumer biConsumer) {
            return super.thenAcceptBoth(completionStage, biConsumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAcceptBothAsync(CompletionStage completionStage, BiConsumer biConsumer) {
            return super.thenAcceptBothAsync(completionStage, biConsumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenAcceptBothAsync(CompletionStage completionStage, BiConsumer biConsumer, Executor executor) {
            return super.thenAcceptBothAsync(completionStage, biConsumer, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenApply(Function function) {
            return super.thenApply(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenApplyAsync(Function function) {
            return super.thenApplyAsync(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenApplyAsync(Function function, Executor executor) {
            return super.thenApplyAsync(function, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenCombine(CompletionStage completionStage, BiFunction biFunction) {
            return super.thenCombine(completionStage, biFunction);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenCombineAsync(CompletionStage completionStage, BiFunction biFunction) {
            return super.thenCombineAsync(completionStage, biFunction);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenCombineAsync(CompletionStage completionStage, BiFunction biFunction, Executor executor) {
            return super.thenCombineAsync(completionStage, biFunction, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenCompose(Function function) {
            return super.thenCompose(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenComposeAsync(Function function) {
            return super.thenComposeAsync(function);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenComposeAsync(Function function, Executor executor) {
            return super.thenComposeAsync(function, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenRun(Runnable runnable) {
            return super.thenRun(runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenRunAsync(Runnable runnable) {
            return super.thenRunAsync(runnable);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage thenRunAsync(Runnable runnable, Executor executor) {
            return super.thenRunAsync(runnable, executor);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage whenComplete(BiConsumer biConsumer) {
            return super.whenComplete(biConsumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage whenCompleteAsync(BiConsumer biConsumer) {
            return super.whenCompleteAsync(biConsumer);
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public /* bridge */ /* synthetic */ CompletionStage whenCompleteAsync(BiConsumer biConsumer, Executor executor) {
            return super.whenCompleteAsync(biConsumer, executor);
        }

        MinimalStage() {
        }

        MinimalStage(Object obj) {
            super(obj);
        }

        @Override // java8.util.concurrent.CompletableFuture
        public <U> CompletableFuture<U> newIncompleteFuture() {
            return new MinimalStage();
        }

        @Override // java8.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public T get() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public T getNow(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public T join() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public boolean complete(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public boolean completeExceptionally(Throwable th) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public void obtrudeValue(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public void obtrudeException(Throwable th) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean isDone() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public boolean isCompletedExceptionally() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public int getNumberOfDependents() {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public CompletableFuture<T> orTimeout(long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeOnTimeout(T t, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        @Override // java8.util.concurrent.CompletableFuture, java8.util.concurrent.CompletionStage
        public CompletableFuture<T> toCompletableFuture() {
            Object obj = this.result;
            if (obj != null) {
                return new CompletableFuture<>(encodeRelay(obj));
            }
            CompletableFuture<T> completableFuture = new CompletableFuture<>();
            unipush(new UniRelay(completableFuture, this));
            return completableFuture;
        }
    }
}
