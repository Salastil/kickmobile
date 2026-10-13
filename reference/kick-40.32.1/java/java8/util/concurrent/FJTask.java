package java8.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes9.dex */
abstract class FJTask<V> implements Future<V>, Serializable {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;
    private static final long STATUS;
    private static final Unsafe U;
    private static final ExceptionNode[] exceptionTable = new ExceptionNode[32];
    private static final ReentrantLock exceptionTableLock = new ReentrantLock();
    private static final ReferenceQueue<FJTask<?>> exceptionTableRefQueue = new ReferenceQueue<>();
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;

    protected abstract boolean exec();

    abstract V getRawResult();

    void internalPropagateException(Throwable th) {
    }

    protected abstract void setRawResult(V v);

    FJTask() {
    }

    private int setCompletion(int i) {
        while (true) {
            int i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
            FJTask<V> fJTask = this;
            if (U.compareAndSwapInt(fJTask, STATUS, i2, i2 | i)) {
                if ((i2 >>> 16) == 0) {
                    return i;
                }
                synchronized (fJTask) {
                    fJTask.notifyAll();
                }
                return i;
            }
            this = fJTask;
        }
    }

    final int doExec() {
        int i = this.status;
        if (i >= 0) {
            try {
                if (exec()) {
                    return setCompletion(-268435456);
                }
            } catch (Throwable th) {
                return setExceptionalCompletion(th);
            }
        }
        return i;
    }

    final void internalWait(long j) {
        int i = this.status;
        if (i < 0 || !U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
            return;
        }
        synchronized (this) {
            if (this.status >= 0) {
                try {
                    wait(j);
                } catch (InterruptedException unused) {
                }
            } else {
                notifyAll();
            }
        }
    }

    private int externalAwaitDone() {
        boolean z = false;
        int iDoExec = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
        if (iDoExec < 0 || (iDoExec = this.status) < 0) {
            return iDoExec;
        }
        int i = iDoExec;
        while (true) {
            FJTask<V> fJTask = this;
            if (U.compareAndSwapInt(fJTask, STATUS, i, i | 65536)) {
                synchronized (fJTask) {
                    if (fJTask.status >= 0) {
                        try {
                            fJTask.wait(0L);
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    } else {
                        fJTask.notifyAll();
                    }
                }
            }
            i = fJTask.status;
            if (i < 0) {
                break;
            }
            this = fJTask;
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i;
    }

    private int externalInterruptibleAwaitDone() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int iDoExec = this.status;
        if (iDoExec >= 0) {
            iDoExec = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
            if (iDoExec >= 0) {
                while (true) {
                    int i = this.status;
                    if (i < 0) {
                        return i;
                    }
                    FJTask<V> fJTask = this;
                    if (U.compareAndSwapInt(fJTask, STATUS, i, i | 65536)) {
                        synchronized (fJTask) {
                            if (fJTask.status >= 0) {
                                fJTask.wait(0L);
                            } else {
                                fJTask.notifyAll();
                            }
                        }
                    }
                    this = fJTask;
                }
            }
        }
        return iDoExec;
    }

    private int doJoin() {
        int iDoExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof FJWorkerThread)) {
            return externalAwaitDone();
        }
        FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
        FJPool.WorkQueue workQueue = fJWorkerThread.workQueue;
        return (!workQueue.tryUnpush(this) || (iDoExec = doExec()) >= 0) ? fJWorkerThread.pool.awaitJoin(workQueue, this, 0L) : iDoExec;
    }

    private int doInvoke() {
        int iDoExec = doExec();
        if (iDoExec < 0) {
            return iDoExec;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
            return fJWorkerThread.pool.awaitJoin(fJWorkerThread.workQueue, this, 0L);
        }
        return externalAwaitDone();
    }

    static {
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            STATUS = unsafe.objectFieldOffset(FJTask.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    static final class ExceptionNode extends WeakReference<FJTask<?>> {
        final Throwable ex;
        final int hashCode;
        ExceptionNode next;
        final long thrower;

        ExceptionNode(FJTask<?> fJTask, Throwable th, ExceptionNode exceptionNode, ReferenceQueue<FJTask<?>> referenceQueue) {
            super(fJTask, referenceQueue);
            this.ex = th;
            this.next = exceptionNode;
            this.thrower = Thread.currentThread().getId();
            this.hashCode = System.identityHashCode(fJTask);
        }
    }

    final int recordExceptionalCompletion(Throwable th) {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        int iIdentityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            int length = iIdentityHashCode & (exceptionNodeArr.length - 1);
            for (ExceptionNode exceptionNode = exceptionNodeArr[length]; exceptionNode != null; exceptionNode = exceptionNode.next) {
                if (exceptionNode.get() == this) {
                    return setCompletion(Integer.MIN_VALUE);
                }
            }
            exceptionNodeArr[length] = new ExceptionNode(this, th, exceptionNodeArr[length], exceptionTableRefQueue);
            return setCompletion(Integer.MIN_VALUE);
        } finally {
            reentrantLock.unlock();
        }
    }

    private int setExceptionalCompletion(Throwable th) {
        int iRecordExceptionalCompletion = recordExceptionalCompletion(th);
        if (((-268435456) & iRecordExceptionalCompletion) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return iRecordExceptionalCompletion;
    }

    static final void cancelIgnoringExceptions(FJTask<?> fJTask) {
        if (fJTask == null || fJTask.status < 0) {
            return;
        }
        try {
            fJTask.cancel(false);
        } catch (Throwable unused) {
        }
    }

    private Throwable getThrowableException() {
        Throwable th;
        int iIdentityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            ExceptionNode exceptionNode = exceptionNodeArr[iIdentityHashCode & (exceptionNodeArr.length - 1)];
            while (exceptionNode != null && exceptionNode.get() != this) {
                exceptionNode = exceptionNode.next;
            }
            reentrantLock.unlock();
            if (exceptionNode == null || (th = exceptionNode.ex) == null) {
                return null;
            }
            if (exceptionNode.thrower != Thread.currentThread().getId()) {
                try {
                    Constructor<?> constructor = null;
                    for (Constructor<?> constructor2 : th.getClass().getConstructors()) {
                        Class<?>[] parameterTypes = constructor2.getParameterTypes();
                        if (parameterTypes.length == 0) {
                            constructor = constructor2;
                        } else if (parameterTypes.length == 1 && parameterTypes[0] == Throwable.class) {
                            return (Throwable) constructor2.newInstance(th);
                        }
                    }
                    if (constructor != null) {
                        Throwable th2 = (Throwable) constructor.newInstance(null);
                        th2.initCause(th);
                        return th2;
                    }
                } catch (Exception unused) {
                }
            }
            return th;
        } catch (Throwable th3) {
            reentrantLock.unlock();
            throw th3;
        }
    }

    private static void expungeStaleExceptions() {
        while (true) {
            Reference<? extends FJTask<?>> referencePoll = exceptionTableRefQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof ExceptionNode) {
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int length = ((ExceptionNode) referencePoll).hashCode & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[length];
                ExceptionNode exceptionNode2 = null;
                while (exceptionNode != null) {
                    ExceptionNode exceptionNode3 = exceptionNode.next;
                    if (exceptionNode == referencePoll) {
                        if (exceptionNode2 == null) {
                            exceptionNodeArr[length] = exceptionNode3;
                            break;
                        } else {
                            exceptionNode2.next = exceptionNode3;
                            break;
                        }
                    }
                    exceptionNode2 = exceptionNode;
                    exceptionNode = exceptionNode3;
                }
            }
        }
    }

    static final void helpExpungeStaleExceptions() {
        ReentrantLock reentrantLock = exceptionTableLock;
        if (reentrantLock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    static void rethrow(Throwable th) {
        FJPool.rethrow(th);
    }

    private void reportException(int i) {
        if (i == CANCELLED) {
            throw new CancellationException();
        }
        if (i == Integer.MIN_VALUE) {
            rethrow(getThrowableException());
        }
    }

    final V invoke() {
        int iDoInvoke = doInvoke() & (-268435456);
        if (iDoInvoke != -268435456) {
            reportException(iDoInvoke);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (setCompletion(CANCELLED) & (-268435456)) == CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & (-268435456)) == CANCELLED;
    }

    final Throwable getException() {
        int i = this.status & (-268435456);
        if (i >= -268435456) {
            return null;
        }
        if (i == CANCELLED) {
            return new CancellationException();
        }
        return getThrowableException();
    }

    void completeExceptionally(Throwable th) {
        if (!(th instanceof RuntimeException) && !(th instanceof Error)) {
            th = new RuntimeException(th);
        }
        setExceptionalCompletion(th);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        int iDoJoin = (Thread.currentThread() instanceof FJWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & (-268435456);
        if (iDoJoin == CANCELLED) {
            throw new CancellationException();
        }
        if (iDoJoin == Integer.MIN_VALUE) {
            throw new ExecutionException(getThrowableException());
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        FJTask<V> fJTask;
        int i;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int iDoExec = this.status;
        if (iDoExec < 0 || nanos <= 0) {
            fJTask = this;
        } else {
            long jNanoTime = System.nanoTime() + nanos;
            if (jNanoTime == 0) {
                jNanoTime = 1;
            }
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread instanceof FJWorkerThread) {
                FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
                iDoExec = fJWorkerThread.pool.awaitJoin(fJWorkerThread.workQueue, this, jNanoTime);
            } else {
                iDoExec = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
                if (iDoExec >= 0) {
                    while (true) {
                        i = this.status;
                        if (i < 0) {
                            break;
                        }
                        long jNanoTime2 = jNanoTime - System.nanoTime();
                        if (jNanoTime2 <= 0) {
                            break;
                        }
                        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                        long j2 = jNanoTime2 / 1000000;
                        if (j2 > 0) {
                            FJTask<V> fJTask2 = this;
                            if (U.compareAndSwapInt(fJTask2, STATUS, i, i | 65536)) {
                                synchronized (fJTask2) {
                                    if (fJTask2.status >= 0) {
                                        fJTask2.wait(j2);
                                    } else {
                                        fJTask2.notifyAll();
                                    }
                                }
                            }
                            this = fJTask2;
                        }
                    }
                    fJTask = this;
                    iDoExec = i;
                }
            }
            fJTask = this;
        }
        if (iDoExec >= 0) {
            iDoExec = fJTask.status;
        }
        int i2 = iDoExec & (-268435456);
        if (i2 == -268435456) {
            return fJTask.getRawResult();
        }
        if (i2 == CANCELLED) {
            throw new CancellationException();
        }
        if (i2 != Integer.MIN_VALUE) {
            throw new TimeoutException();
        }
        throw new ExecutionException(fJTask.getThrowableException());
    }

    final void quietlyJoin() {
        doJoin();
    }

    final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        while (true) {
            int i = this.status;
            if (((short) i) != s) {
                return false;
            }
            FJTask<V> fJTask = this;
            if (U.compareAndSwapInt(fJTask, STATUS, i, (65535 & s2) | ((-65536) & i))) {
                return true;
            }
            this = fJTask;
        }
    }

    static final class AdaptedRunnable<T> extends FJTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        AdaptedRunnable(Runnable runnable, T t) {
            this.runnable = (Runnable) Util.requireNonNull(runnable);
            this.result = t;
        }

        @Override // java8.util.concurrent.FJTask
        final T getRawResult() {
            return this.result;
        }

        @Override // java8.util.concurrent.FJTask
        protected final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java8.util.concurrent.FJTask
        protected final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    static final class AdaptedRunnableAction extends FJTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java8.util.concurrent.FJTask
        public final Void getRawResult() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.concurrent.FJTask
        public final void setRawResult(Void r1) {
        }

        AdaptedRunnableAction(Runnable runnable) {
            this.runnable = (Runnable) Util.requireNonNull(runnable);
        }

        @Override // java8.util.concurrent.FJTask
        protected final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    static final class RunnableExecuteAction extends FJTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java8.util.concurrent.FJTask
        public final Void getRawResult() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.concurrent.FJTask
        public final void setRawResult(Void r1) {
        }

        RunnableExecuteAction(Runnable runnable) {
            this.runnable = (Runnable) Util.requireNonNull(runnable);
        }

        @Override // java8.util.concurrent.FJTask
        protected final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java8.util.concurrent.FJTask
        void internalPropagateException(Throwable th) {
            rethrow(th);
        }
    }

    static final class AdaptedCallable<T> extends FJTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        AdaptedCallable(Callable<? extends T> callable) {
            this.callable = (Callable) Util.requireNonNull(callable);
        }

        @Override // java8.util.concurrent.FJTask
        final T getRawResult() {
            return this.result;
        }

        @Override // java8.util.concurrent.FJTask
        protected final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java8.util.concurrent.FJTask
        protected final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.callable + "]";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        if (object != null) {
            setExceptionalCompletion((Throwable) object);
        }
    }
}
