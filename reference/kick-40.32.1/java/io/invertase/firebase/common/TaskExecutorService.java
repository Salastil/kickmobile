package io.invertase.firebase.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class TaskExecutorService {
    private static final String KEEP_ALIVE_SECONDS_KEY = "android_task_executor_keep_alive_seconds";
    private static final String MAXIMUM_POOL_SIZE_KEY = "android_task_executor_maximum_pool_size";
    private final RejectedExecutionHandler executeInFallback = new RejectedExecutionHandler() { // from class: io.invertase.firebase.common.TaskExecutorService$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            this.f$0.lambda$new$1(runnable, threadPoolExecutor);
        }
    };
    private final int keepAliveSeconds;
    private final int maximumPoolSize;
    private final String name;
    private static final Map<String, ExecutorService> executors = new HashMap();
    private static final RejectedExecutionHandler discardAfterShutdown = new RejectedExecutionHandler() { // from class: io.invertase.firebase.common.TaskExecutorService$$ExternalSyntheticLambda1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            TaskExecutorService.lambda$static$0(runnable, threadPoolExecutor);
        }
    };

    public TaskExecutorService(String str) {
        this.name = str;
        ReactNativeFirebaseJSON sharedInstance = ReactNativeFirebaseJSON.getSharedInstance();
        this.maximumPoolSize = sharedInstance.getIntValue(MAXIMUM_POOL_SIZE_KEY, 1);
        this.keepAliveSeconds = sharedInstance.getIntValue(KEEP_ALIVE_SECONDS_KEY, 3);
    }

    public ExecutorService getExecutor() {
        return getExecutor(this.maximumPoolSize <= 1, "");
    }

    public ExecutorService getTransactionalExecutor() {
        return getExecutor(true, "");
    }

    public ExecutorService getTransactionalExecutor(String str) {
        if (this.maximumPoolSize == 0) {
            str = "";
        }
        return getExecutor(true, str);
    }

    public ExecutorService getExecutor(boolean z, String str) {
        String executorName = getExecutorName(z, str);
        Map<String, ExecutorService> map = executors;
        synchronized (map) {
            ExecutorService executorService = map.get(executorName);
            if (executorService != null) {
                return executorService;
            }
            ExecutorService newExecutor = getNewExecutor(z);
            map.put(executorName, newExecutor);
            return newExecutor;
        }
    }

    private ExecutorService getNewExecutor(boolean z) {
        if (z) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.setRejectedExecutionHandler(discardAfterShutdown);
            return threadPoolExecutor;
        }
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, this.maximumPoolSize, this.keepAliveSeconds, TimeUnit.SECONDS, new SynchronousQueue());
        threadPoolExecutor2.setRejectedExecutionHandler(this.executeInFallback);
        return threadPoolExecutor2;
    }

    static /* synthetic */ void lambda$static$0(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor.isShutdown()) {
            return;
        }
        throw new RejectedExecutionException("Task " + runnable + " rejected from " + threadPoolExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor.isShutdown()) {
            return;
        }
        getTransactionalExecutor().execute(runnable);
    }

    public String getExecutorName(boolean z, String str) {
        String str2 = this.name;
        if (z) {
            return str2 + "TransactionalExecutor" + str;
        }
        return str2 + "Executor" + str;
    }

    public void shutdown() {
        Map<String, ExecutorService> map = executors;
        synchronized (map) {
            for (String str : new ArrayList(map.keySet())) {
                if (!str.startsWith(this.name)) {
                    executors.remove(str);
                } else {
                    removeExecutor(str);
                }
            }
        }
    }

    public void removeExecutor(String str) {
        Map<String, ExecutorService> map = executors;
        synchronized (map) {
            ExecutorService executorService = map.get(str);
            if (executorService != null) {
                executorService.shutdownNow();
                map.remove(str);
            }
        }
    }
}
