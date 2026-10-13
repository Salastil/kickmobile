package com.datadog.trace.util;

import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class AgentTaskScheduler implements Executor {
    private static final long SHUTDOWN_TIMEOUT = 5;
    private final AgentThreadFactory.AgentThread agentThread;
    private volatile boolean shutdown;
    private final DelayQueue<PeriodicTask<?>> workQueue = new DelayQueue<>();
    private volatile Thread worker;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AgentTaskScheduler.class);
    public static final AgentTaskScheduler INSTANCE = new AgentTaskScheduler(AgentThreadFactory.AgentThread.TASK_SCHEDULER);
    private static final AtomicInteger TASK_SEQUENCE_GENERATOR = new AtomicInteger();

    public interface Target<T> {
        T get();
    }

    public interface Task<T> {
        void run(T t);
    }

    private void placeholder() {
    }

    public static final class RunnableTask implements Task<Runnable> {
        public static final RunnableTask INSTANCE = new RunnableTask();

        @Override // com.datadog.trace.util.AgentTaskScheduler.Task
        public void run(Runnable runnable) {
            runnable.run();
        }
    }

    public static class Scheduled<T> implements Target<T> {
        private volatile T referent;

        private Scheduled(T t) {
            this.referent = t;
        }

        @Override // com.datadog.trace.util.AgentTaskScheduler.Target
        public T get() {
            return this.referent;
        }

        public void cancel() {
            this.referent = null;
        }
    }

    private static final class WeakTarget<T> extends WeakReference<T> implements Target<T> {
        private WeakTarget(T t) {
            super(t);
        }
    }

    public AgentTaskScheduler(AgentThreadFactory.AgentThread agentThread) {
        this.agentThread = agentThread;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        schedule(RunnableTask.INSTANCE, runnable, 0L, TimeUnit.MILLISECONDS);
    }

    public <T> Scheduled<T> schedule(Task<T> task, T t, long j, TimeUnit timeUnit) {
        Scheduled<T> scheduled = new Scheduled<>(t);
        scheduleTarget(task, scheduled, j, 0L, timeUnit);
        return scheduled;
    }

    public Scheduled<Runnable> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(RunnableTask.INSTANCE, runnable, j, timeUnit);
    }

    public <T> Scheduled<T> scheduleWithJitter(Task<T> task, T t, long j, TimeUnit timeUnit) {
        return schedule(task, t, timeUnit.toMillis(j) + Math.min((long) ((Math.log(ThreadLocalRandom.current().nextDouble()) * 1000.0d) / Math.log(0.75d)), 10000L), TimeUnit.MILLISECONDS);
    }

    public Scheduled<Runnable> scheduleWithJitter(Runnable runnable, long j, TimeUnit timeUnit) {
        return scheduleWithJitter(RunnableTask.INSTANCE, runnable, j, timeUnit);
    }

    public <T> Scheduled<T> scheduleAtFixedRate(Task<T> task, T t, long j, long j2, TimeUnit timeUnit) {
        Scheduled<T> scheduled = new Scheduled<>(t);
        scheduleTarget(task, scheduled, j, j2, timeUnit);
        return scheduled;
    }

    public Scheduled<Runnable> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return scheduleAtFixedRate(RunnableTask.INSTANCE, runnable, j, j2, timeUnit);
    }

    public <T> void weakScheduleAtFixedRate(Task<T> task, T t, long j, long j2, TimeUnit timeUnit) {
        scheduleTarget(task, new WeakTarget(t), j, j2, timeUnit);
    }

    public void weakScheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        weakScheduleAtFixedRate(RunnableTask.INSTANCE, runnable, j, j2, timeUnit);
    }

    private <T> void scheduleTarget(Task<T> task, Target<T> target, long j, long j2, TimeUnit timeUnit) {
        if (target == null || target.get() == null) {
            return;
        }
        if (!this.shutdown && this.worker == null) {
            synchronized (this.workQueue) {
                if (!this.shutdown && this.worker == null) {
                    prepareWorkQueue();
                    try {
                        this.worker = AgentThreadFactory.newAgentThread(this.agentThread, new Worker());
                        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
                        this.worker.start();
                    } catch (IllegalStateException unused) {
                        this.shutdown = true;
                    }
                }
            }
        }
        if (!this.shutdown) {
            this.workQueue.offer(new PeriodicTask(task, target, j, j2, timeUnit));
        } else {
            log.debug("Agent task scheduler is shutdown. Will not run {}", describeTask(task, target));
        }
    }

    private void prepareWorkQueue() {
        try {
            this.workQueue.poll(1L, TimeUnit.NANOSECONDS);
        } catch (InterruptedException unused) {
        }
    }

    int taskCount() {
        return this.workQueue.size();
    }

    public boolean isShutdown() {
        return this.shutdown;
    }

    public static void initialize() {
        INSTANCE.placeholder();
    }

    public void shutdown(long j, TimeUnit timeUnit) {
        this.shutdown = true;
        Thread thread = this.worker;
        if (thread != null) {
            thread.interrupt();
            if (j > 0) {
                try {
                    thread.join(timeUnit.toMillis(j));
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> String describeTask(Task<T> task, Target<T> target) {
        return "periodic task " + task.getClass().getSimpleName() + " with target " + target.get();
    }

    private final class ShutdownHook extends Thread {
        ShutdownHook() {
            super(AgentThreadFactory.AGENT_THREAD_GROUP, AgentTaskScheduler.this.agentThread.threadName + "-shutdown-hook");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AgentTaskScheduler.this.shutdown(5L, TimeUnit.SECONDS);
        }
    }

    private final class Worker implements Runnable {
        private Worker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                boolean z = AgentTaskScheduler.this.shutdown;
                AgentTaskScheduler agentTaskScheduler = AgentTaskScheduler.this;
                PeriodicTask periodicTask = null;
                if (!z) {
                    try {
                        PeriodicTask periodicTask2 = (PeriodicTask) agentTaskScheduler.workQueue.take();
                        try {
                            periodicTask2.run();
                            if (periodicTask2 != null && periodicTask2.reschedule()) {
                                AgentTaskScheduler.this.workQueue.offer(periodicTask2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            periodicTask = periodicTask2;
                            if (periodicTask != null) {
                                try {
                                    AgentTaskScheduler.log.debug("Uncaught exception from {}", periodicTask, th);
                                } catch (Throwable th2) {
                                    if (periodicTask != null && periodicTask.reschedule()) {
                                        AgentTaskScheduler.this.workQueue.offer(periodicTask);
                                    }
                                    throw th2;
                                }
                            }
                            if (periodicTask != null && periodicTask.reschedule()) {
                                AgentTaskScheduler.this.workQueue.offer(periodicTask);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    agentTaskScheduler.workQueue.clear();
                    AgentTaskScheduler.this.worker = null;
                    return;
                }
            }
        }
    }

    private static final class PeriodicTask<T> implements Delayed {
        private long nextFireTime;
        private final long period;
        private final Target<T> target;
        private final Task<T> task;
        private final int taskSequence = AgentTaskScheduler.TASK_SEQUENCE_GENERATOR.getAndIncrement();

        public PeriodicTask(Task<T> task, Target<T> target, long j, long j2, TimeUnit timeUnit) {
            this.task = task;
            this.target = target;
            this.period = timeUnit.toNanos(j2);
            this.nextFireTime = System.nanoTime() + timeUnit.toNanos(j);
        }

        public void run() {
            T t = this.target.get();
            if (t != null) {
                this.task.run(t);
            }
        }

        public boolean reschedule() {
            if (this.period <= 0 || this.target.get() == null) {
                return false;
            }
            this.nextFireTime += this.period;
            return true;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.nextFireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            long delay;
            if (this == delayed) {
                return 0;
            }
            if (delayed instanceof PeriodicTask) {
                PeriodicTask periodicTask = (PeriodicTask) delayed;
                delay = this.nextFireTime - periodicTask.nextFireTime;
                if (delay == 0) {
                    delay = this.taskSequence - periodicTask.taskSequence;
                }
            } else {
                delay = getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
            }
            if (delay < 0) {
                return -1;
            }
            return delay > 0 ? 1 : 0;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return compareTo((Delayed) obj) == 0;
            } catch (ClassCastException unused) {
                return false;
            }
        }

        public String toString() {
            return AgentTaskScheduler.describeTask(this.task, this.target);
        }
    }
}
