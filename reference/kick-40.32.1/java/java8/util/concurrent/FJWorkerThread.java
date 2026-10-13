package java8.util.concurrent;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/* JADX INFO: loaded from: classes9.dex */
class FJWorkerThread extends Thread {
    private static final String NAME_PLACEHOLDER = "aFJWorkerThread";
    final FJPool pool;
    final FJPool.WorkQueue workQueue;

    void afterTopLevelExec() {
    }

    protected void onStart() {
    }

    protected void onTermination(Throwable th) {
    }

    FJWorkerThread(FJPool fJPool, ClassLoader classLoader) {
        super(NAME_PLACEHOLDER);
        TLR.setContextClassLoader(this, classLoader);
        this.pool = fJPool;
        this.workQueue = fJPool.registerWorker(this);
    }

    FJWorkerThread(FJPool fJPool, ClassLoader classLoader, ThreadGroup threadGroup, AccessControlContext accessControlContext) {
        super(threadGroup, NAME_PLACEHOLDER);
        super.setContextClassLoader(classLoader);
        TLR.setInheritedAccessControlContext(this, accessControlContext);
        TLR.eraseThreadLocals(this);
        this.pool = fJPool;
        this.workQueue = fJPool.registerWorker(this);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.workQueue.array == null) {
            try {
                onStart();
                this.pool.runWorker(this.workQueue);
                th = null;
                try {
                    onTermination(null);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    onTermination(th);
                } catch (Throwable unused) {
                }
            }
            this.pool.deregisterWorker(this, th);
        }
    }

    static final class InnocuousForkJoinWorkerThread extends FJWorkerThread {
        private static final ThreadGroup innocuousThreadGroup = (ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() { // from class: java8.util.concurrent.FJWorkerThread.InnocuousForkJoinWorkerThread.1
            @Override // java.security.PrivilegedAction
            public ThreadGroup run() {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                while (true) {
                    ThreadGroup parent = threadGroup.getParent();
                    if (parent == null) {
                        return new ThreadGroup(threadGroup, "InnocuousFJWorkerThreadGroup");
                    }
                    threadGroup = parent;
                }
            }
        });
        private static final AccessControlContext INNOCUOUS_ACC = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, null)});

        @Override // java.lang.Thread
        public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        }

        InnocuousForkJoinWorkerThread(FJPool fJPool) {
            super(fJPool, ClassLoader.getSystemClassLoader(), innocuousThreadGroup, INNOCUOUS_ACC);
        }

        @Override // java8.util.concurrent.FJWorkerThread
        void afterTopLevelExec() {
            TLR.eraseThreadLocals(this);
        }

        @Override // java.lang.Thread
        public void setContextClassLoader(ClassLoader classLoader) {
            if (classLoader != null && ClassLoader.getSystemClassLoader() != classLoader) {
                throw new SecurityException("setContextClassLoader");
            }
        }
    }
}
