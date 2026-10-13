package java8.util.concurrent;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.cast.zzwb$zzd$$ExternalSyntheticBackportWithForwarding0;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.UByte$$ExternalSyntheticBackport0;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes9.dex */
final class FJPool extends AbstractExecutorService implements AutoCloseable {
    private static final int ABASE;
    private static final long ADD_WORKER = 140737488355328L;
    private static final int ASHIFT;
    private static final int COMMON_MAX_SPARES;
    static final int COMMON_PARALLELISM;
    private static final long CTL;
    private static final int DEFAULT_COMMON_MAX_SPARES = 256;
    private static final long DEFAULT_KEEPALIVE = 60000;
    static final int DORMANT = -1073741824;
    static final int FIFO = 65536;
    static final int MAX_CAP = 32767;
    private static final long MODE;
    static final int OWNED = 1;
    static final int POLL_LIMIT = 1024;
    static final int QLOCK = 1;
    static final int QUIET = 1073741824;
    private static final long RC_MASK = -281474976710656L;
    private static final int RC_SHIFT = 48;
    private static final long RC_UNIT = 281474976710656L;
    private static final int SEED_INCREMENT = -1640531527;
    static final int SHUTDOWN = 262144;
    static final int SMASK = 65535;
    private static final long SP_MASK = 4294967295L;
    static final int SQMASK = 126;
    static final int SS_SEQ = 65536;
    static final int STOP = Integer.MIN_VALUE;
    static final int SWIDTH = 16;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    static final int TERMINATED = 524288;
    private static final long TIMEOUT_SLOP = 20;
    private static final Unsafe U;
    private static final long UC_MASK = -4294967296L;
    static final int UNSIGNALLED = Integer.MIN_VALUE;
    static final FJPool common;
    static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
    static final RuntimePermission modifyThreadPermission;
    final int bounds;
    volatile long ctl;
    final ForkJoinWorkerThreadFactory factory;
    int indexSeed;
    final long keepAlive;
    volatile int mode;
    volatile long pad00;
    volatile long pad01;
    volatile long pad02;
    volatile long pad03;
    volatile long pad04;
    volatile long pad05;
    volatile long pad06;
    volatile long pad07;
    volatile long pad08;
    volatile long pad09;
    volatile long pad0a;
    volatile long pad0b;
    volatile long pad0c;
    volatile long pad0d;
    volatile long pad0e;
    volatile long pad0f;
    volatile long pad10;
    volatile long pad11;
    volatile long pad12;
    volatile long pad13;
    volatile long pad14;
    volatile long pad15;
    volatile long pad16;
    volatile long pad17;
    volatile long pad18;
    volatile long pad19;
    volatile long pad1a;
    volatile long pad1b;
    volatile long pad1c;
    volatile long pad1d;
    volatile long pad1e;
    final Predicate<? super FJPool> saturate;
    volatile long stealCount;
    final Thread.UncaughtExceptionHandler ueh;
    WorkQueue[] workQueues;
    final String workerNamePrefix;

    interface ForkJoinWorkerThreadFactory {
        FJWorkerThread newThread(FJPool fJPool);
    }

    interface ManagedBlocker {
        boolean block() throws InterruptedException;

        boolean isReleasable();
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    private static void checkPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
    }

    static AccessControlContext contextWithPermissions(Permission... permissionArr) {
        Permissions permissions = new Permissions();
        for (Permission permission : permissionArr) {
            permissions.add(permission);
        }
        return new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, permissions)});
    }

    private static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        private static final AccessControlContext ACC = FJPool.contextWithPermissions(new RuntimePermission("getClassLoader"));

        @Override // java8.util.concurrent.FJPool.ForkJoinWorkerThreadFactory
        public final FJWorkerThread newThread(final FJPool fJPool) {
            return (FJWorkerThread) AccessController.doPrivileged(new PrivilegedAction<FJWorkerThread>() { // from class: java8.util.concurrent.FJPool.DefaultForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public FJWorkerThread run() {
                    return new FJWorkerThread(fJPool, ClassLoader.getSystemClassLoader());
                }
            }, ACC);
        }

        DefaultForkJoinWorkerThreadFactory() {
        }
    }

    static final class WorkQueue {
        private static final int ABASE;
        private static final int ASHIFT;
        static final int INITIAL_QUEUE_CAPACITY = 8192;
        static final int MAXIMUM_QUEUE_CAPACITY = 67108864;
        private static final long PHASE;
        private static final Unsafe U;
        FJTask<?>[] array;
        int id;
        int nsteals;
        final FJWorkerThread owner;
        volatile long pad00;
        volatile long pad01;
        volatile long pad02;
        volatile long pad03;
        volatile long pad04;
        volatile long pad05;
        volatile long pad06;
        volatile long pad07;
        volatile long pad08;
        volatile long pad09;
        volatile long pad0a;
        volatile long pad0b;
        volatile long pad0c;
        volatile long pad0d;
        volatile long pad0e;
        volatile long pad0f;
        volatile Object pad10;
        volatile Object pad11;
        volatile Object pad12;
        volatile Object pad13;
        volatile Object pad14;
        volatile Object pad15;
        volatile Object pad16;
        volatile Object pad17;
        volatile Object pad18;
        volatile Object pad19;
        volatile Object pad1a;
        volatile Object pad1b;
        volatile Object pad1c;
        volatile Object pad1d;
        volatile Object pad1e;
        volatile Object pad1f;
        volatile int phase;
        final FJPool pool;
        volatile int source;
        int stackPred;
        int top = 4096;
        volatile int base = 4096;

        WorkQueue(FJPool fJPool, FJWorkerThread fJWorkerThread) {
            this.pool = fJPool;
            this.owner = fJWorkerThread;
        }

        final int queueSize() {
            int i = this.base - this.top;
            if (i >= 0) {
                return 0;
            }
            return -i;
        }

        final void push(FJTask<?> fJTask) {
            int length;
            int i = this.top;
            FJTask<?>[] fJTaskArr = this.array;
            if (fJTaskArr == null || (length = fJTaskArr.length) <= 0) {
                return;
            }
            long j = (((long) ((length - 1) & i)) << ASHIFT) + ((long) ABASE);
            FJPool fJPool = this.pool;
            this.top = i + 1;
            U.putOrderedObject(fJTaskArr, j, fJTask);
            int i2 = this.base - i;
            if (i2 == 0 && fJPool != null) {
                MemBar.fullFence();
                fJPool.signalWork();
            } else if (i2 + length == 1) {
                growArray();
            }
        }

        final FJTask<?>[] growArray() {
            int i;
            FJTask<?>[] fJTaskArr = this.array;
            int length = fJTaskArr != null ? fJTaskArr.length : 0;
            int i2 = length > 0 ? length << 1 : 8192;
            if (i2 < 8192 || i2 > 67108864) {
                throw new RejectedExecutionException("Queue capacity exceeded");
            }
            FJTask<?>[] fJTaskArr2 = new FJTask[i2];
            this.array = fJTaskArr2;
            if (fJTaskArr != null && (i = length - 1) > 0) {
                int i3 = this.top;
                int i4 = this.base;
                if (i3 - i4 > 0) {
                    int i5 = i2 - 1;
                    do {
                        long j = (((long) (i4 & i)) << ASHIFT) + ((long) ABASE);
                        Unsafe unsafe = U;
                        FJTask<?> fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j);
                        if (fJTask != null && zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask, null)) {
                            fJTaskArr2[i4 & i5] = fJTask;
                        }
                        i4++;
                    } while (i4 != i3);
                    MemBar.storeFence();
                }
            }
            return fJTaskArr2;
        }

        final FJTask<?> poll() {
            int i;
            int length;
            while (true) {
                int i2 = this.base;
                int i3 = this.top;
                FJTask<?>[] fJTaskArr = this.array;
                if (fJTaskArr == null || (i = i2 - i3) >= 0 || (length = fJTaskArr.length) <= 0) {
                    return null;
                }
                long j = (((long) ((length - 1) & i2)) << ASHIFT) + ((long) ABASE);
                Unsafe unsafe = U;
                FJTask<?> fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j);
                int i4 = i2 + 1;
                if (i2 == this.base) {
                    if (fJTask != null) {
                        if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask, null)) {
                            this.base = i4;
                            return fJTask;
                        }
                    } else if (i == -1) {
                        return null;
                    }
                }
            }
        }

        final boolean tryUnpush(FJTask<?> fJTask) {
            int length;
            int i = this.base;
            int i2 = this.top;
            FJTask<?>[] fJTaskArr = this.array;
            if (fJTaskArr == null || i == i2 || (length = fJTaskArr.length) <= 0) {
                return false;
            }
            int i3 = i2 - 1;
            if (!zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(U, fJTaskArr, (((long) ((length - 1) & i3)) << ASHIFT) + ((long) ABASE), fJTask, null)) {
                return false;
            }
            this.top = i3;
            MemBar.storeFence();
            return true;
        }

        final void cancelAll() {
            while (true) {
                FJTask<?> fJTaskPoll = poll();
                if (fJTaskPoll == null) {
                    return;
                } else {
                    FJTask.cancelIgnoringExceptions(fJTaskPoll);
                }
            }
        }

        final void localPopAndExec(int i) {
            int length;
            while (true) {
                int i2 = this.base;
                int i3 = this.top;
                FJTask<?>[] fJTaskArr = this.array;
                if (fJTaskArr == null || i2 == i3 || (length = fJTaskArr.length) <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                FJTask fJTask = (FJTask) FJPool.getAndSetObject(fJTaskArr, (((long) ((length - 1) & i4)) << ASHIFT) + ((long) ABASE), null);
                if (fJTask == null) {
                    return;
                }
                this.top = i4;
                MemBar.storeFence();
                fJTask.doExec();
                if (i != 0 && (i = i - 1) == 0) {
                    return;
                }
            }
        }

        final void localPollAndExec(int i) {
            int i2;
            int length;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.base;
                    int i5 = this.top;
                    FJTask<?>[] fJTaskArr = this.array;
                    if (fJTaskArr == null || (i2 = i4 - i5) >= 0 || (length = fJTaskArr.length) <= 0) {
                        return;
                    }
                    int i6 = i4 + 1;
                    FJTask fJTask = (FJTask) FJPool.getAndSetObject(fJTaskArr, (((long) (i4 & (length - 1))) << ASHIFT) + ((long) ABASE), null);
                    if (fJTask != null) {
                        this.base = i6;
                        fJTask.doExec();
                        if (i != 0 && (i3 = i3 + 1) == i) {
                            return;
                        }
                    }
                }
            } while (i2 != -1);
        }

        final void tryRemoveAndExec(FJTask<?> fJTask) {
            FJTask<?>[] fJTaskArr;
            int length;
            int i = this.base;
            int i2 = this.top;
            if (i - i2 >= 0 || (fJTaskArr = this.array) == null || (length = fJTaskArr.length) <= 0) {
                return;
            }
            int i3 = length - 1;
            int i4 = i2 - 1;
            int i5 = i4;
            while (true) {
                long j = ((i5 & i3) << ASHIFT) + ABASE;
                Unsafe unsafe = U;
                FJTask<?> fJTask2 = (FJTask) unsafe.getObject(fJTaskArr, j);
                if (fJTask2 == null) {
                    return;
                }
                if (fJTask2 == fJTask) {
                    if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask2, null)) {
                        this.top = i4;
                        while (i5 != i4) {
                            int i6 = i5 + 1;
                            int i7 = ASHIFT;
                            int i8 = ABASE;
                            long j2 = ((i6 & i3) << i7) + i8;
                            Unsafe unsafe2 = U;
                            FJTask fJTask3 = (FJTask) unsafe2.getObject(fJTaskArr, j2);
                            unsafe2.putObjectVolatile(fJTaskArr, j2, (Object) null);
                            unsafe2.putOrderedObject(fJTaskArr, ((i5 & i3) << i7) + i8, fJTask3);
                            i5 = i6;
                        }
                        MemBar.storeFence();
                        fJTask2.doExec();
                        return;
                    }
                    return;
                }
                i5--;
            }
        }

        final boolean tryLockSharedQueue() {
            return U.compareAndSwapInt(this, PHASE, 0, 1);
        }

        final boolean trySharedUnpush(FJTask<?> fJTask) {
            int length;
            long j;
            int i = this.top;
            int i2 = i - 1;
            FJTask<?>[] fJTaskArr = this.array;
            if (fJTaskArr != null && (length = fJTaskArr.length) > 0) {
                boolean z = true;
                long j2 = (((long) ((length - 1) & i2)) << ASHIFT) + ((long) ABASE);
                Unsafe unsafe = U;
                if (((FJTask) unsafe.getObject(fJTaskArr, j2)) == fJTask) {
                    long j3 = PHASE;
                    if (unsafe.compareAndSwapInt(this, j3, 0, 1)) {
                        if (this.top == i && this.array == fJTaskArr) {
                            j = j3;
                            if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j2, fJTask, null)) {
                                this.top = i2;
                            }
                            unsafe.putOrderedInt(this, j, 0);
                            return z;
                        }
                        j = j3;
                        z = false;
                        unsafe.putOrderedInt(this, j, 0);
                        return z;
                    }
                }
            }
            return false;
        }

        final boolean isApparentlyUnblocked() {
            Thread.State state;
            FJWorkerThread fJWorkerThread = this.owner;
            return (fJWorkerThread == null || (state = fJWorkerThread.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) ? false : true;
        }

        static {
            Unsafe unsafe = UnsafeAcc.unsafe;
            U = unsafe;
            try {
                PHASE = unsafe.objectFieldOffset(WorkQueue.class.getDeclaredField(TypedValues.Cycle.S_WAVE_PHASE));
                ABASE = unsafe.arrayBaseOffset(FJTask[].class);
                int iArrayIndexScale = unsafe.arrayIndexScale(FJTask[].class);
                if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                    throw new ExceptionInInitializerError("array index scale not a power of two");
                }
                ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    static long getAndAddLong(Object obj, long j, long j2) {
        while (true) {
            Unsafe unsafe = U;
            long longVolatile = unsafe.getLongVolatile(obj, j);
            Object obj2 = obj;
            long j3 = j;
            if (unsafe.compareAndSwapLong(obj2, j3, longVolatile, longVolatile + j2)) {
                return longVolatile;
            }
            obj = obj2;
            j = j3;
        }
    }

    static Object getAndSetObject(Object obj, long j, Object obj2) {
        while (true) {
            Unsafe unsafe = U;
            Object objectVolatile = unsafe.getObjectVolatile(obj, j);
            Object obj3 = obj;
            long j2 = j;
            Object obj4 = obj2;
            if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, obj3, j2, objectVolatile, obj4)) {
                return objectVolatile;
            }
            obj = obj3;
            j = j2;
            obj2 = obj4;
        }
    }

    private boolean createWorker() {
        FJWorkerThread fJWorkerThreadNewThread;
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
        Throwable th = null;
        if (forkJoinWorkerThreadFactory != null) {
            try {
                fJWorkerThreadNewThread = forkJoinWorkerThreadFactory.newThread(this);
                if (fJWorkerThreadNewThread != null) {
                    try {
                        fJWorkerThreadNewThread.start();
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fJWorkerThreadNewThread = null;
            }
        } else {
            fJWorkerThreadNewThread = null;
        }
        deregisterWorker(fJWorkerThreadNewThread, th);
        return false;
    }

    private void tryAddWorker(long j) {
        FJPool fJPool;
        long j2 = j;
        while (true) {
            long j3 = ((RC_UNIT + j2) & RC_MASK) | ((TC_UNIT + j2) & TC_MASK);
            if (this.ctl == j2) {
                fJPool = this;
                if (U.compareAndSwapLong(fJPool, CTL, j2, j3)) {
                    fJPool.createWorker();
                    return;
                }
            } else {
                fJPool = this;
            }
            j2 = fJPool.ctl;
            if ((ADD_WORKER & j2) == 0 || ((int) j2) != 0) {
                return;
            } else {
                this = fJPool;
            }
        }
    }

    final WorkQueue registerWorker(FJWorkerThread fJWorkerThread) {
        int i;
        int length;
        fJWorkerThread.setDaemon(true);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.ueh;
        if (uncaughtExceptionHandler != null) {
            fJWorkerThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        WorkQueue workQueue = new WorkQueue(this, fJWorkerThread);
        int i2 = this.mode & 65536;
        String str = this.workerNamePrefix;
        if (str == null) {
            return workQueue;
        }
        synchronized (str) {
            WorkQueue[] workQueueArr = this.workQueues;
            int i3 = this.indexSeed + SEED_INCREMENT;
            this.indexSeed = i3;
            i = 0;
            if (workQueueArr != null && (length = workQueueArr.length) > 1) {
                int i4 = length - 1;
                int i5 = i3 & i4;
                int i6 = ((i3 << 1) | 1) & i4;
                int i7 = length >>> 1;
                while (true) {
                    WorkQueue workQueue2 = workQueueArr[i6];
                    if (workQueue2 == null || workQueue2.phase == 1073741824) {
                        break;
                        break;
                    }
                    i7--;
                    if (i7 == 0) {
                        i6 = length | 1;
                        break;
                    }
                    i6 = (i6 + 2) & i4;
                }
                int i8 = i2 | i6 | (i3 & 1073610752);
                workQueue.id = i8;
                workQueue.phase = i8;
                if (i6 < length) {
                    workQueueArr[i6] = workQueue;
                } else {
                    int i9 = length << 1;
                    WorkQueue[] workQueueArr2 = new WorkQueue[i9];
                    workQueueArr2[i6] = workQueue;
                    int i10 = i9 - 1;
                    while (i < length) {
                        WorkQueue workQueue3 = workQueueArr[i];
                        if (workQueue3 != null) {
                            workQueueArr2[workQueue3.id & i10 & 126] = workQueue3;
                        }
                        int i11 = i + 1;
                        if (i11 >= length) {
                            break;
                        }
                        workQueueArr2[i11] = workQueueArr[i11];
                        i += 2;
                    }
                    this.workQueues = workQueueArr2;
                }
                i = i5;
            }
        }
        fJWorkerThread.setName(str.concat(Integer.toString(i)));
        return workQueue;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0043 A[LOOP:0: B:28:0x0043->B:46:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    final void deregisterWorker(FJWorkerThread fJWorkerThread, Throwable th) {
        WorkQueue workQueue;
        int i;
        Unsafe unsafe;
        long j;
        long j2;
        if (fJWorkerThread != null) {
            WorkQueue workQueue2 = fJWorkerThread.workQueue;
            if (workQueue2 != null) {
                String str = this.workerNamePrefix;
                long j3 = ((long) workQueue2.nsteals) & 4294967295L;
                int i2 = workQueue2.id & 65535;
                if (str != null) {
                    synchronized (str) {
                        WorkQueue[] workQueueArr = this.workQueues;
                        if (workQueueArr != null && workQueueArr.length > i2 && workQueueArr[i2] == workQueue2) {
                            workQueueArr[i2] = null;
                        }
                        this.stealCount += j3;
                    }
                }
                i = workQueue2.phase;
                workQueue = workQueue2;
            } else {
                workQueue = workQueue2;
            }
            if (i != 1073741824) {
                do {
                    unsafe = U;
                    j = CTL;
                    j2 = this.ctl;
                } while (!unsafe.compareAndSwapLong(this, j, j2, ((j2 - RC_UNIT) & RC_MASK) | ((j2 - TC_UNIT) & TC_MASK) | (j2 & 4294967295L)));
            }
            if (workQueue != null) {
                workQueue.cancelAll();
            }
            if (!tryTerminate(false, false) && workQueue != null && workQueue.array != null) {
                signalWork();
            }
            if (th == null) {
                FJTask.helpExpungeStaleExceptions();
            } else {
                FJTask.rethrow(th);
            }
        }
        workQueue = null;
        i = 0;
        if (i != 1073741824) {
            do {
                unsafe = U;
                j = CTL;
                j2 = this.ctl;
            } while (!unsafe.compareAndSwapLong(this, j, j2, ((j2 - RC_UNIT) & RC_MASK) | ((j2 - TC_UNIT) & TC_MASK) | (j2 & 4294967295L)));
        }
        if (workQueue != null) {
            workQueue.cancelAll();
        }
        if (!tryTerminate(false, false)) {
            signalWork();
        }
        if (th == null) {
            FJTask.helpExpungeStaleExceptions();
        } else {
            FJTask.rethrow(th);
        }
    }

    final void signalWork() {
        int i;
        WorkQueue workQueue;
        FJPool fJPool;
        while (true) {
            long j = this.ctl;
            if (j >= 0) {
                return;
            }
            int i2 = (int) j;
            if (i2 == 0) {
                if ((ADD_WORKER & j) != 0) {
                    this.tryAddWorker(j);
                    return;
                }
                return;
            }
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr == null || workQueueArr.length <= (i = 65535 & i2) || (workQueue = workQueueArr[i]) == null) {
                return;
            }
            int i3 = i2 & Integer.MAX_VALUE;
            int i4 = workQueue.phase;
            long j2 = (((long) workQueue.stackPred) & 4294967295L) | ((RC_UNIT + j) & UC_MASK);
            FJWorkerThread fJWorkerThread = workQueue.owner;
            if (i2 == i4) {
                fJPool = this;
                if (U.compareAndSwapLong(fJPool, CTL, j, j2)) {
                    workQueue.phase = i3;
                    if (workQueue.source < 0) {
                        LockSupport.unpark(fJWorkerThread);
                        return;
                    }
                    return;
                }
            } else {
                fJPool = this;
            }
            this = fJPool;
        }
    }

    private int tryCompensate(WorkQueue workQueue) {
        int i;
        int i2;
        int length;
        Thread.State state;
        long j = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        short s = (short) (j >>> 32);
        if (s >= 0) {
            if (workQueueArr == null || (length = workQueueArr.length) <= 0 || workQueue == null) {
                return 0;
            }
            int i3 = (int) j;
            if (i3 != 0) {
                WorkQueue workQueue2 = workQueueArr[i3 & (length - 1)];
                int i4 = workQueue.phase;
                long j2 = UC_MASK & (i4 < 0 ? RC_UNIT + j : j);
                int i5 = i3 & Integer.MAX_VALUE;
                if (workQueue2 == null) {
                    return 0;
                }
                int i6 = workQueue2.phase;
                FJWorkerThread fJWorkerThread = workQueue2.owner;
                long j3 = j2 | (((long) workQueue2.stackPred) & 4294967295L);
                if (i6 != i3 || !U.compareAndSwapLong(this, CTL, j, j3)) {
                    return 0;
                }
                workQueue2.phase = i5;
                if (workQueue2.source < 0) {
                    LockSupport.unpark(fJWorkerThread);
                }
                return i4 < 0 ? -1 : 1;
            }
            i = 1;
            i2 = 0;
            if (((int) (j >> 48)) - ((short) (this.bounds & 65535)) > 0) {
                return U.compareAndSwapLong(this, CTL, j, (281474976710655L & j) | (RC_MASK & (j - RC_UNIT))) ? 1 : 0;
            }
            int i7 = this.mode & 65535;
            int i8 = i7 + s;
            int i9 = i8;
            int i10 = 0;
            for (int i11 = 1; i11 < length; i11 += 2) {
                WorkQueue workQueue3 = workQueueArr[i11];
                if (workQueue3 != null) {
                    if (workQueue3.source == 0) {
                        return 0;
                    }
                    i9--;
                    FJWorkerThread fJWorkerThread2 = workQueue3.owner;
                    if (fJWorkerThread2 != null && ((state = fJWorkerThread2.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING)) {
                        i10++;
                    }
                }
            }
            if (i9 == 0 && this.ctl == j) {
                if (i8 >= 32767 || s >= (this.bounds >>> 16)) {
                    Predicate<? super FJPool> predicate = this.saturate;
                    if (predicate != null && predicate.test(this)) {
                        return -1;
                    }
                    if (i10 < i7) {
                        Thread.yield();
                        return 0;
                    }
                    throw new RejectedExecutionException("Thread limit exceeded replacing blocked worker");
                }
            }
            return 0;
        }
        i = 1;
        i2 = 0;
        return (U.compareAndSwapLong(this, CTL, j, ((-281470681743361L) & j) | ((TC_UNIT + j) & TC_MASK)) && createWorker()) ? i : i2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:98:0x00b0 A[EDGE_INSN: B:98:0x00b0->B:47:0x00b0 BREAK  A[LOOP:2: B:9:0x001c->B:45:0x00a8], SYNTHETIC] */
    final void runWorker(WorkQueue workQueue) {
        int i;
        int i2;
        long j;
        WorkQueue workQueue2;
        FJTask<?>[] fJTaskArr;
        int length;
        FJPool fJPool = this;
        WorkQueue workQueue3 = workQueue;
        workQueue3.growArray();
        int iNextSecondarySeed = workQueue3.id ^ TLR.nextSecondarySeed();
        if (iNextSecondarySeed == 0) {
            iNextSecondarySeed = 1;
        }
        while (true) {
            int i3 = 0;
            while (true) {
                WorkQueue[] workQueueArr = fJPool.workQueues;
                if (workQueueArr == null) {
                    return;
                }
                int length2 = workQueueArr.length;
                int i4 = length2 - 1;
                i = iNextSecondarySeed;
                int i5 = length2;
                boolean z = false;
                while (true) {
                    if (i5 <= 0) {
                        i2 = 65536;
                        break;
                    }
                    int i6 = i & i4;
                    if (i6 < 0 || i6 >= length2 || (workQueue2 = workQueueArr[i6]) == null) {
                        i2 = 65536;
                        if (z) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        int i7 = workQueue2.base;
                        if (i7 - workQueue2.top >= 0 || (fJTaskArr = workQueue2.array) == null || (length = fJTaskArr.length) <= 0) {
                            i2 = 65536;
                            if (z) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i8 = workQueue2.id;
                            long j2 = (((long) ((length - 1) & i7)) << ASHIFT) + ((long) ABASE);
                            Unsafe unsafe = U;
                            FJTask fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j2);
                            if (fJTask != null) {
                                int i9 = i7 + 1;
                                if (i7 == workQueue2.base && zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j2, fJTask, null)) {
                                    workQueue2.base = i9;
                                    if (i9 - workQueue2.top < 0 && i8 != i3) {
                                        fJPool.signalWork();
                                    }
                                    workQueue3 = workQueue;
                                    workQueue3.source = i8;
                                    fJTask.doExec();
                                    if ((workQueue3.id & 65536) != 0) {
                                        workQueue3.localPollAndExec(1024);
                                    } else {
                                        workQueue3.localPopAndExec(1024);
                                    }
                                    FJWorkerThread fJWorkerThread = workQueue3.owner;
                                    workQueue3.nsteals++;
                                    workQueue3.source = 0;
                                    if (fJWorkerThread != null) {
                                        fJWorkerThread.afterTopLevelExec();
                                    }
                                    i3 = i8;
                                } else {
                                    workQueue3 = workQueue;
                                }
                            } else {
                                workQueue3 = workQueue;
                            }
                            z = true;
                        }
                    }
                    i5--;
                }
                if (z) {
                    int i10 = (i << 13) ^ i;
                    int i11 = i10 ^ (i10 >>> 17);
                    iNextSecondarySeed = i11 ^ (i11 << 5);
                }
            }
            int i12 = workQueue3.phase;
            long j3 = 4294967295L;
            if (i12 >= 0) {
                int i13 = (i12 + i2) | Integer.MIN_VALUE;
                workQueue3.phase = i13;
                do {
                    j = fJPool.ctl;
                    workQueue3.stackPred = (int) j;
                } while (!U.compareAndSwapLong(fJPool, CTL, j, (((long) i13) & 4294967295L) | ((j - RC_UNIT) & UC_MASK)));
            } else {
                int i14 = workQueue3.stackPred;
                workQueue3.source = DORMANT;
                int i15 = 0;
                while (workQueue3.phase < 0) {
                    int i16 = fJPool.mode;
                    if (i16 < 0) {
                        return;
                    }
                    long j4 = fJPool.ctl;
                    long j5 = j3;
                    int i17 = (65535 & i16) + ((int) (j4 >> 48));
                    if (i17 <= 0 && (i16 & 262144) != 0) {
                        if (fJPool.tryTerminate(false, false)) {
                            return;
                        }
                    }
                    int i18 = i15 + 1;
                    if ((i18 & 1) == 0) {
                        Thread.interrupted();
                    } else if (i17 <= 0 && i14 != 0 && i12 == ((int) j4)) {
                        long jCurrentTimeMillis = fJPool.keepAlive + System.currentTimeMillis();
                        LockSupport.parkUntil(fJPool, jCurrentTimeMillis);
                        if (fJPool.ctl == j4 && jCurrentTimeMillis - System.currentTimeMillis() <= 20) {
                            if (U.compareAndSwapLong(fJPool, CTL, j4, (((long) i14) & j5) | ((j4 - TC_UNIT) & UC_MASK))) {
                                workQueue3.phase = 1073741824;
                                return;
                            }
                        }
                    } else {
                        LockSupport.park(this);
                    }
                    fJPool = this;
                    i15 = i18;
                    j3 = j5;
                }
                workQueue3.source = 0;
            }
            iNextSecondarySeed = i;
        }
    }

    final int awaitJoin(WorkQueue workQueue, FJTask<?> fJTask, long j) {
        long j2;
        WorkQueue workQueue2;
        FJTask<?>[] fJTaskArr;
        int length;
        if (workQueue == null || fJTask == null) {
            return 0;
        }
        workQueue.tryRemoveAndExec(fJTask);
        int i = workQueue.source;
        int i2 = workQueue.id;
        int i3 = fJTask.status;
        while (i3 >= 0) {
            boolean z = true;
            int iNextSecondarySeed = TLR.nextSecondarySeed() | 1;
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr == null) {
                z = false;
                break;
            }
            int length2 = workQueueArr.length;
            int i4 = length2 - 1;
            int i5 = -length2;
            while (true) {
                if (i5 >= length2) {
                    z = false;
                    break;
                }
                int i6 = (iNextSecondarySeed + i5) & i4;
                if (i6 >= 0 && i6 < length2 && (workQueue2 = workQueueArr[i6]) != null && workQueue2.source == i2) {
                    int i7 = workQueue2.base;
                    if (i7 - workQueue2.top < 0 && (fJTaskArr = workQueue2.array) != null && (length = fJTaskArr.length) > 0) {
                        int i8 = workQueue2.id;
                        long j3 = (((long) ((length - 1) & i7)) << ASHIFT) + ((long) ABASE);
                        Unsafe unsafe = U;
                        FJTask fJTask2 = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j3);
                        if (fJTask2 == null) {
                            break;
                        }
                        int i9 = i7 + 1;
                        if (i7 != workQueue2.base || i2 != workQueue2.source || !zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j3, fJTask2, null)) {
                            break;
                            break;
                            break;
                        }
                        workQueue2.base = i9;
                        workQueue.source = i8;
                        fJTask2.doExec();
                        workQueue.source = i;
                        break;
                    }
                }
                i5 += 2;
            }
            i3 = fJTask.status;
            if (i3 >= 0) {
                if (!z) {
                    if (j == 0) {
                        j2 = 0;
                    } else {
                        long jNanoTime = j - System.nanoTime();
                        if (jNanoTime > 0) {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            j2 = jNanoTime / 1000000;
                            if (j2 <= 0) {
                                j2 = 1;
                            }
                        }
                    }
                    int iTryCompensate = tryCompensate(workQueue);
                    if (iTryCompensate != 0) {
                        fJTask.internalWait(j2);
                        getAndAddLong(this, CTL, iTryCompensate > 0 ? RC_UNIT : 0L);
                    }
                    i3 = fJTask.status;
                }
            }
            return i3;
        }
        return i3;
    }

    final void helpQuiescePool(WorkQueue workQueue) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        WorkQueue workQueue2;
        FJTask<?>[] fJTaskArr;
        int i3 = workQueue.source;
        int i4 = workQueue.id & 65536;
        byte b = -1;
        int i5 = i3;
        byte b2 = -1;
        while (true) {
            if (i4 != 0) {
                workQueue.localPollAndExec(0);
            } else {
                workQueue.localPopAndExec(0);
            }
            if (b2 == b && workQueue.phase >= 0) {
                b2 = 1;
            }
            int iNextSecondarySeed = TLR.nextSecondarySeed();
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                int length = workQueueArr.length;
                int i6 = length - 1;
                int i7 = length;
                z2 = true;
                while (true) {
                    if (i7 <= 0) {
                        i = 1073741824;
                        z = true;
                        break;
                    }
                    int i8 = (iNextSecondarySeed - i7) & i6;
                    if (i8 >= 0 && i8 < length && (workQueue2 = workQueueArr[i8]) != null) {
                        int i9 = workQueue2.base;
                        if (i9 - workQueue2.top < 0 && (fJTaskArr = workQueue2.array) != null) {
                            i = 1073741824;
                            int length2 = fJTaskArr.length;
                            if (length2 > 0) {
                                if (b2 == 0) {
                                    getAndAddLong(this, CTL, RC_UNIT);
                                    b2 = 1;
                                }
                                long j = (((long) ((length2 - 1) & i9)) << ASHIFT) + ((long) ABASE);
                                Unsafe unsafe = U;
                                FJTask fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j);
                                if (fJTask != null) {
                                    int i10 = i9 + 1;
                                    if (i9 == workQueue2.base && zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask, null)) {
                                        workQueue2.base = i10;
                                        workQueue.source = workQueue2.id;
                                        fJTask.doExec();
                                        workQueue.source = i3;
                                        i5 = i3;
                                    }
                                }
                                z = false;
                                z2 = false;
                                break;
                            }
                        } else {
                            i = 1073741824;
                        }
                        if ((workQueue2.source & i) == 0) {
                            z2 = false;
                        }
                    }
                    i7--;
                }
            } else {
                i = 1073741824;
                z = true;
                z2 = true;
            }
            if (z2) {
                break;
            }
            if (z) {
                int i11 = i;
                if (i5 != i11) {
                    workQueue.source = i11;
                    i2 = i11;
                } else {
                    i2 = i5;
                }
                if (b2 == 1) {
                    getAndAddLong(this, CTL, RC_MASK);
                    i5 = i2;
                    b2 = 0;
                } else {
                    i5 = i2;
                }
            }
            b = -1;
        }
        if (b2 == 0) {
            getAndAddLong(this, CTL, RC_UNIT);
        }
        workQueue.source = i3;
    }

    private FJTask<?> pollScan(boolean z) {
        WorkQueue[] workQueueArr;
        int length;
        int i;
        int i2;
        WorkQueue workQueue;
        int i3;
        FJTask<?>[] fJTaskArr;
        int length2;
        while ((this.mode & Integer.MIN_VALUE) == 0 && (workQueueArr = this.workQueues) != null && (length = workQueueArr.length) > 0) {
            int i4 = length - 1;
            int iNextSecondarySeed = TLR.nextSecondarySeed();
            int i5 = iNextSecondarySeed >>> 16;
            if (z) {
                i = iNextSecondarySeed & (-2) & i4;
                i2 = (i5 & (-2)) | 2;
            } else {
                i = iNextSecondarySeed & i4;
                i2 = i5 | 1;
            }
            int i6 = i;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                workQueue = workQueueArr[i6];
                if (workQueue != null) {
                    i3 = workQueue.base;
                    i7 += i3;
                    if (i3 - workQueue.top < 0 && (fJTaskArr = workQueue.array) != null && (length2 = fJTaskArr.length) > 0) {
                        break;
                    }
                }
                i6 = (i6 + i2) & i4;
                if (i6 == i) {
                    if (i8 == i7) {
                        return null;
                    }
                    i8 = i7;
                    i7 = 0;
                }
            }
            long j = (((long) ((length2 - 1) & i3)) << ASHIFT) + ((long) ABASE);
            Unsafe unsafe = U;
            FJTask<?> fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j);
            if (fJTask != null) {
                int i9 = i3 + 1;
                if (i3 == workQueue.base && zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask, null)) {
                    workQueue.base = i9;
                    return fJTask;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    final void externalPush(FJTask<?> fJTask) {
        int length;
        boolean z;
        boolean z2;
        int length2;
        int length3;
        int length4;
        int probe = TLR.getProbe();
        if (probe == 0) {
            TLR.localInit();
            probe = TLR.getProbe();
        }
        while (true) {
            int i = this.mode;
            WorkQueue[] workQueueArr = this.workQueues;
            if ((i & 262144) != 0 || workQueueArr == null || (length = workQueueArr.length) <= 0) {
                break;
            }
            WorkQueue workQueue = workQueueArr[(length - 1) & probe & 126];
            if (workQueue == null) {
                String str = this.workerNamePrefix;
                int i2 = (probe | 1073741824) & (-65538);
                WorkQueue workQueue2 = new WorkQueue(this, null);
                workQueue2.id = i2;
                workQueue2.source = 1073741824;
                workQueue2.phase = 1;
                if (str != null) {
                    synchronized (str) {
                        WorkQueue[] workQueueArr2 = this.workQueues;
                        if (workQueueArr2 == null || (length4 = workQueueArr2.length) <= 0) {
                            z = false;
                        } else {
                            int i3 = i2 & (length4 - 1) & 126;
                            if (workQueueArr2[i3] == null) {
                                workQueueArr2[i3] = workQueue2;
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        z2 = z;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                workQueue = workQueue2;
            } else if (workQueue.tryLockSharedQueue()) {
                int i4 = workQueue.base;
                int i5 = workQueue.top;
                FJTask<?>[] fJTaskArr = workQueue.array;
                if (fJTaskArr == null || (length2 = fJTaskArr.length) <= 0) {
                    z2 = true;
                } else {
                    int i6 = length2 - 1;
                    int i7 = i4 - i5;
                    if (i6 + i7 > 0) {
                        fJTaskArr[i6 & i5] = fJTask;
                        workQueue.top = i5 + 1;
                        workQueue.phase = 0;
                        if (i7 < 0 && workQueue.base - i5 < -1) {
                            return;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = true;
                    }
                }
                z = true;
            } else {
                z = false;
                z2 = false;
            }
            if (z) {
                if (z2) {
                    try {
                        workQueue.growArray();
                        int i8 = workQueue.top;
                        FJTask<?>[] fJTaskArr2 = workQueue.array;
                        if (fJTaskArr2 != null && (length3 = fJTaskArr2.length) > 0) {
                            fJTaskArr2[(length3 - 1) & i8] = fJTask;
                            workQueue.top = i8 + 1;
                        }
                        workQueue.phase = 0;
                    } catch (Throwable th) {
                        workQueue.phase = 0;
                        throw th;
                    }
                }
                signalWork();
                return;
            }
            probe = TLR.advanceProbe(probe);
        }
        throw new RejectedExecutionException();
    }

    private <T> FJTask<T> externalSubmit(FJTask<T> fJTask) {
        WorkQueue workQueue;
        Util.requireNonNull(fJTask);
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
            if (fJWorkerThread.pool == this && (workQueue = fJWorkerThread.workQueue) != null) {
                workQueue.push(fJTask);
                return fJTask;
            }
        }
        externalPush(fJTask);
        return fJTask;
    }

    final boolean tryExternalUnpush(FJTask<?> fJTask) {
        int length;
        WorkQueue workQueue;
        int probe = TLR.getProbe();
        WorkQueue[] workQueueArr = this.workQueues;
        return workQueueArr != null && (length = workQueueArr.length) > 0 && (workQueue = workQueueArr[(probe & (length - 1)) & 126]) != null && workQueue.trySharedUnpush(fJTask);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x00ab A[EDGE_INSN: B:108:0x00ab->B:44:0x00ab BREAK  A[LOOP:2: B:14:0x0030->B:47:0x00b1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00ab A[EDGE_INSN: B:109:0x00ab->B:44:0x00ab BREAK  A[LOOP:2: B:14:0x0030->B:47:0x00b1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:46:0x00af  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    private boolean tryTerminate(boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        long j;
        boolean z4;
        int i7;
        FJPool fJPool = this;
        while (true) {
            int i8 = fJPool.mode;
            boolean z5 = false;
            if ((i8 & 262144) != 0) {
                while (true) {
                    int i9 = fJPool.mode;
                    int i10 = Integer.MIN_VALUE;
                    int i11 = 65535;
                    long j2 = 0;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        boolean z6 = z5;
                        while (true) {
                            int i12 = 524288;
                            if ((fJPool.mode & 524288) != 0) {
                                break;
                            }
                            long j3 = 0;
                            while (true) {
                                long j4 = fJPool.ctl;
                                WorkQueue[] workQueueArr = fJPool.workQueues;
                                if (workQueueArr != null) {
                                    for (?? r7 = z6; r7 < workQueueArr.length; r7++) {
                                        WorkQueue workQueue = workQueueArr[r7];
                                        if (workQueue != null) {
                                            FJWorkerThread fJWorkerThread = workQueue.owner;
                                            workQueue.cancelAll();
                                            if (fJWorkerThread != null) {
                                                try {
                                                    fJWorkerThread.interrupt();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            j4 += (((long) workQueue.phase) << 32) + ((long) workQueue.base);
                                        }
                                        i12 = i12;
                                        j3 = j3;
                                    }
                                }
                                i = i12;
                                long j5 = j3;
                                i2 = fJPool.mode;
                                i3 = i2 & i;
                                if (i3 != 0) {
                                    break;
                                }
                                if (fJPool.workQueues != workQueueArr) {
                                    j3 = j5;
                                } else {
                                    if (j5 == j4) {
                                        break;
                                    }
                                    j3 = j4;
                                }
                                i12 = i;
                            }
                            if (i3 != 0 || (i2 & 65535) + ((short) (fJPool.ctl >>> 32)) > 0) {
                                break;
                            }
                            if (U.compareAndSwapInt(fJPool, MODE, i2, i2 | i)) {
                                synchronized (this) {
                                    notifyAll();
                                }
                                break;
                            }
                            fJPool = this;
                        }
                        return true;
                    }
                    if (z) {
                        i4 = Integer.MIN_VALUE;
                        z3 = z5;
                        i5 = i9;
                    } else {
                        while (true) {
                            long j6 = fJPool.ctl;
                            WorkQueue[] workQueueArr2 = fJPool.workQueues;
                            if ((i9 & i11) + ((int) (j6 >> 48)) <= 0) {
                                if (workQueueArr2 != null) {
                                    ?? r0 = z5;
                                    while (true) {
                                        if (r0 < workQueueArr2.length) {
                                            WorkQueue workQueue2 = workQueueArr2[r0];
                                            if (workQueue2 != null) {
                                                int i13 = workQueue2.source;
                                                int i14 = workQueue2.phase;
                                                i4 = i10;
                                                int i15 = workQueue2.id;
                                                z3 = z5;
                                                int i16 = workQueue2.base;
                                                if (i16 == workQueue2.top && ((i15 & 1) != 1 || (i13 < 0 && i14 < 0))) {
                                                    j6 += (((long) i13) << 48) + (((long) i14) << 32) + (((long) i16) << 16) + ((long) i15);
                                                }
                                            } else {
                                                i4 = i10;
                                                z3 = z5;
                                            }
                                            i10 = i4;
                                            z5 = z3;
                                            i11 = i11;
                                            j2 = j2;
                                            r0++;
                                        }
                                    }
                                }
                                i4 = i10;
                                z3 = z5;
                                i6 = i11;
                                j = j2;
                                z4 = z3;
                                i7 = fJPool.mode;
                                if ((i7 & i4) == 0) {
                                    break;
                                }
                                if (z4) {
                                    return z3;
                                }
                                if (fJPool.workQueues == workQueueArr2) {
                                    j2 = j;
                                } else {
                                    if (j == j6) {
                                        break;
                                    }
                                    j2 = j6;
                                }
                                i9 = i7;
                                z5 = z3;
                                i11 = i6;
                                i10 = i4;
                            } else {
                                i4 = i10;
                                z3 = z5;
                            }
                            i6 = i11;
                            j = j2;
                            z4 = true;
                            i7 = fJPool.mode;
                            if ((i7 & i4) == 0) {
                                break;
                                break;
                            }
                            if (z4) {
                                return z3;
                            }
                            if (fJPool.workQueues == workQueueArr2) {
                                j2 = j;
                            } else {
                                if (j == j6) {
                                    break;
                                    break;
                                }
                                j2 = j6;
                            }
                            i9 = i7;
                            z5 = z3;
                            i11 = i6;
                            i10 = i4;
                        }
                        i5 = i7;
                    }
                    if ((i5 & i4) == 0) {
                        U.compareAndSwapInt(fJPool, MODE, i5, i5 | i4);
                    }
                    z5 = z3;
                }
            } else {
                if (!z2 || fJPool == common) {
                    return false;
                }
                U.compareAndSwapInt(fJPool, MODE, i8, 262144 | i8);
            }
        }
    }

    private static Object newInstanceFromSystemProperty(String str) throws Exception {
        String property = System.getProperty(str);
        if (property == null) {
            return null;
        }
        return ClassLoader.getSystemClassLoader().loadClass(property).getConstructor(null).newInstance(null);
    }

    FJPool(byte b) {
        ForkJoinWorkerThreadFactory innocuousForkJoinWorkerThreadFactory;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        int iAvailableProcessors = -1;
        try {
            String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            iAvailableProcessors = property != null ? Integer.parseInt(property) : -1;
            innocuousForkJoinWorkerThreadFactory = (ForkJoinWorkerThreadFactory) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            try {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            } catch (Exception unused) {
                uncaughtExceptionHandler = null;
            }
        } catch (Exception unused2) {
            innocuousForkJoinWorkerThreadFactory = null;
        }
        if (innocuousForkJoinWorkerThreadFactory == null) {
            if (System.getSecurityManager() == null) {
                innocuousForkJoinWorkerThreadFactory = defaultForkJoinWorkerThreadFactory;
            } else {
                innocuousForkJoinWorkerThreadFactory = new InnocuousForkJoinWorkerThreadFactory();
            }
        }
        if (iAvailableProcessors < 0 && (iAvailableProcessors = Runtime.getRuntime().availableProcessors() - 1) <= 0) {
            iAvailableProcessors = 1;
        }
        iAvailableProcessors = iAvailableProcessors > 32767 ? 32767 : iAvailableProcessors;
        long j = -iAvailableProcessors;
        long j2 = ((j << 48) & RC_MASK) | ((j << 32) & TC_MASK);
        int i = ((1 - iAvailableProcessors) & 65535) | (COMMON_MAX_SPARES << 16);
        int i2 = iAvailableProcessors > 1 ? iAvailableProcessors - 1 : 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        this.workerNamePrefix = "FJPool.commonPool-worker-";
        this.workQueues = new WorkQueue[((i6 | (i6 >>> 16)) + 1) << 1];
        this.factory = innocuousForkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.saturate = null;
        this.keepAlive = 60000L;
        this.bounds = i;
        this.mode = iAvailableProcessors;
        this.ctl = j2;
    }

    static FJPool commonPool() {
        return common;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        FJTask runnableExecuteAction;
        Util.requireNonNull(runnable);
        if (runnable instanceof FJTask) {
            runnableExecuteAction = (FJTask) runnable;
        } else {
            runnableExecuteAction = new FJTask.RunnableExecuteAction(runnable);
        }
        externalSubmit(runnableExecuteAction);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> FJTask<T> submit(Callable<T> callable) {
        return externalSubmit(new FJTask.AdaptedCallable(callable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> FJTask<T> submit(Runnable runnable, T t) {
        return externalSubmit(new FJTask.AdaptedRunnable(runnable, t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public FJTask<?> submit(Runnable runnable) {
        Util.requireNonNull(runnable);
        return externalSubmit(runnable instanceof FJTask ? (FJTask) runnable : new FJTask.AdaptedRunnableAction(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            Iterator<? extends Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                FJTask.AdaptedCallable adaptedCallable = new FJTask.AdaptedCallable(it.next());
                arrayList.add(adaptedCallable);
                externalSubmit(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((FJTask) arrayList.get(i)).quietlyJoin();
            }
            return arrayList;
        } catch (Throwable th) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Future) arrayList.get(i2)).cancel(false);
            }
            return (List) rethrow(th);
        }
    }

    static <R> R rethrow(Throwable th) {
        return (R) erase(th);
    }

    private static <R, T extends Throwable> R erase(Throwable th) throws Throwable {
        throw th;
    }

    static int getCommonPoolParallelism() {
        return COMMON_PARALLELISM;
    }

    public boolean isQuiescent() {
        while (true) {
            long j = this.ctl;
            int i = this.mode;
            int i2 = 65535 & i;
            int i3 = ((short) (j >>> 32)) + i2;
            int i4 = i2 + ((int) (j >> 48));
            if ((i & (-2146959360)) != 0) {
                return true;
            }
            if (i4 > 0) {
                return false;
            }
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                for (int i5 = 1; i5 < workQueueArr.length; i5 += 2) {
                    WorkQueue workQueue = workQueueArr[i5];
                    if (workQueue != null) {
                        if ((workQueue.source & 1073741824) == 0) {
                            return false;
                        }
                        i3--;
                    }
                }
            }
            if (i3 == 0 && this.ctl == j) {
                return true;
            }
        }
    }

    public String toString() {
        int i;
        String str;
        long j = this.stealCount;
        WorkQueue[] workQueueArr = this.workQueues;
        long j2 = 0;
        long j3 = 0;
        if (workQueueArr != null) {
            i = 0;
            for (int i2 = 0; i2 < workQueueArr.length; i2++) {
                WorkQueue workQueue = workQueueArr[i2];
                if (workQueue != null) {
                    int iQueueSize = workQueue.queueSize();
                    if ((i2 & 1) == 0) {
                        j3 += (long) iQueueSize;
                    } else {
                        j2 += (long) iQueueSize;
                        j += ((long) workQueue.nsteals) & 4294967295L;
                        if (workQueue.isApparentlyUnblocked()) {
                            i++;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        int i3 = this.mode;
        int i4 = 65535 & i3;
        long j4 = this.ctl;
        int i5 = ((short) (j4 >>> 32)) + i4;
        int i6 = ((int) (j4 >> 48)) + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        if ((524288 & i3) != 0) {
            str = "Terminated";
        } else if ((Integer.MIN_VALUE & i3) != 0) {
            str = "Terminating";
        } else {
            str = (i3 & 262144) != 0 ? "Shutting down" : "Running";
        }
        return super.toString() + "[" + str + ", parallelism = " + i4 + ", size = " + i5 + ", active = " + i7 + ", running = " + i + ", steals = " + j + ", tasks = " + j2 + ", submissions = " + j3 + "]";
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return Collections.EMPTY_LIST;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return (this.mode & 524288) != 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return (this.mode & 262144) != 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this == common) {
            awaitQuiescence(j, timeUnit);
            return false;
        }
        long nanos = timeUnit.toNanos(j);
        if (isTerminated()) {
            return true;
        }
        if (nanos <= 0) {
            return false;
        }
        long jNanoTime = System.nanoTime() + nanos;
        synchronized (this) {
            while (!isTerminated()) {
                if (nanos <= 0) {
                    return false;
                }
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                long j2 = nanos / 1000000;
                if (j2 <= 0) {
                    j2 = 1;
                }
                wait(j2);
                nanos = jNanoTime - System.nanoTime();
            }
            return true;
        }
    }

    boolean awaitQuiescence(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
            if (fJWorkerThread.pool == this) {
                helpQuiescePool(fJWorkerThread.workQueue);
                return true;
            }
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            FJTask<?> fJTaskPollScan = pollScan(false);
            if (fJTaskPollScan != null) {
                fJTaskPollScan.doExec();
            } else {
                if (isQuiescent()) {
                    return true;
                }
                if (System.nanoTime() - jNanoTime > nanos) {
                    return false;
                }
                Thread.yield();
            }
        }
    }

    static void managedBlock(ManagedBlocker managedBlocker) throws InterruptedException {
        FJWorkerThread fJWorkerThread;
        FJPool fJPool;
        WorkQueue workQueue;
        Thread threadCurrentThread = Thread.currentThread();
        if ((threadCurrentThread instanceof FJWorkerThread) && (fJPool = (fJWorkerThread = (FJWorkerThread) threadCurrentThread).pool) != null && (workQueue = fJWorkerThread.workQueue) != null) {
            while (!managedBlocker.isReleasable()) {
                int iTryCompensate = fJPool.tryCompensate(workQueue);
                if (iTryCompensate != 0) {
                    do {
                        long j = RC_UNIT;
                        try {
                            if (managedBlocker.isReleasable()) {
                                break;
                            }
                        } finally {
                            long j2 = CTL;
                            if (iTryCompensate <= 0) {
                                j = 0;
                            }
                            getAndAddLong(fJPool, j2, j);
                        }
                    } while (!managedBlocker.block());
                    return;
                }
            }
            return;
        }
        while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    static void helpAsyncBlocker(Executor executor, ManagedBlocker managedBlocker) {
        int probe;
        WorkQueue workQueue;
        WorkQueue[] workQueueArr;
        int length;
        int i;
        int length2;
        if (managedBlocker == null || !(executor instanceof FJPool)) {
            return;
        }
        FJPool fJPool = (FJPool) executor;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) threadCurrentThread;
            if (fJWorkerThread.pool == fJPool) {
                workQueue = fJWorkerThread.workQueue;
            } else {
                probe = TLR.getProbe();
                if (probe != 0 || (workQueueArr = fJPool.workQueues) == null || (length = workQueueArr.length) <= 0) {
                    workQueue = null;
                } else {
                    workQueue = workQueueArr[probe & (length - 1) & 126];
                }
            }
        } else {
            probe = TLR.getProbe();
            if (probe != 0) {
                workQueue = null;
            } else {
                workQueue = null;
            }
        }
        if (workQueue == null) {
            return;
        }
        while (true) {
            int i2 = workQueue.base;
            int i3 = workQueue.top;
            FJTask<?>[] fJTaskArr = workQueue.array;
            if (fJTaskArr == null || (i = i2 - i3) >= 0 || (length2 = fJTaskArr.length) <= 0) {
                return;
            }
            long j = (((long) ((length2 - 1) & i2)) << ASHIFT) + ((long) ABASE);
            Unsafe unsafe = U;
            FJTask fJTask = (FJTask) unsafe.getObjectVolatile(fJTaskArr, j);
            if (managedBlocker.isReleasable()) {
                return;
            }
            int i4 = i2 + 1;
            if (i2 == workQueue.base) {
                if (fJTask == null) {
                    if (i == -1) {
                        return;
                    }
                } else {
                    if (!(fJTask instanceof CompletableFuture.AsynchronousCompletionTask)) {
                        return;
                    }
                    if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(unsafe, fJTaskArr, j, fJTask, null)) {
                        workQueue.base = i4;
                        fJTask.doExec();
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new FJTask.AdaptedRunnable(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FJTask.AdaptedCallable(callable);
    }

    static {
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            CTL = unsafe.objectFieldOffset(FJPool.class.getDeclaredField("ctl"));
            MODE = unsafe.objectFieldOffset(FJPool.class.getDeclaredField("mode"));
            ABASE = unsafe.arrayBaseOffset(FJTask[].class);
            int iArrayIndexScale = unsafe.arrayIndexScale(FJTask[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new ExceptionInInitializerError("array index scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
            int i = 256;
            try {
                String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
                if (property != null) {
                    i = Integer.parseInt(property);
                }
            } catch (Exception unused) {
            }
            COMMON_MAX_SPARES = i;
            defaultForkJoinWorkerThreadFactory = new DefaultForkJoinWorkerThreadFactory();
            modifyThreadPermission = new RuntimePermission("modifyThread");
            FJPool fJPool = (FJPool) AccessController.doPrivileged(new PrivilegedAction<FJPool>() { // from class: java8.util.concurrent.FJPool.1
                @Override // java.security.PrivilegedAction
                public FJPool run() {
                    return new FJPool((byte) 0);
                }
            });
            common = fJPool;
            COMMON_PARALLELISM = Math.max(fJPool.mode & 65535, 1);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static final class InnocuousForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        private static final AccessControlContext ACC = FJPool.contextWithPermissions(FJPool.modifyThreadPermission, new RuntimePermission("enableContextClassLoaderOverride"), new RuntimePermission("modifyThreadGroup"), new RuntimePermission("getClassLoader"), new RuntimePermission("setContextClassLoader"));

        @Override // java8.util.concurrent.FJPool.ForkJoinWorkerThreadFactory
        public final FJWorkerThread newThread(final FJPool fJPool) {
            return (FJWorkerThread) AccessController.doPrivileged(new PrivilegedAction<FJWorkerThread>() { // from class: java8.util.concurrent.FJPool.InnocuousForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public FJWorkerThread run() {
                    return new FJWorkerThread.InnocuousForkJoinWorkerThread(fJPool);
                }
            }, ACC);
        }

        InnocuousForkJoinWorkerThreadFactory() {
        }
    }

    static final class MemBar {
        private static final long OFF;
        private static final Unsafe U;
        private static final Blank x = new Blank();

        static {
            Unsafe unsafe = UnsafeAcc.unsafe;
            U = unsafe;
            try {
                OFF = unsafe.objectFieldOffset(Blank.class.getDeclaredField("v"));
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        static void loadFence() {
            U.getIntVolatile(x, OFF);
        }

        static void storeFence() {
            U.putOrderedInt(x, OFF, 0);
        }

        static void fullFence() {
            U.putIntVolatile(x, OFF, 0);
        }

        private MemBar() {
        }
    }
}
