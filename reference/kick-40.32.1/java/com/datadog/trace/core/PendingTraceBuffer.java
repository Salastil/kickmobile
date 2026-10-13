package com.datadog.trace.core;

import com.datadog.android.api.InternalLogger;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.time.TimeSource;
import com.datadog.trace.core.monitor.HealthMetrics;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.AgentThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MpscBlockingConsumerArrayQueue;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PendingTraceBuffer implements AutoCloseable {
    private static final int BUFFER_SIZE = 4096;

    public interface Element {
        DDSpan getRootSpan();

        boolean lastReferencedNanosAgo(long j);

        long oldestFinishedTime();

        boolean setEnqueued(boolean z);

        void write();

        boolean writeOnBufferFull();
    }

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract void enqueue(Element element);

    public abstract void flush();

    public boolean longRunningSpansEnabled() {
        return false;
    }

    public abstract void start();

    private static class DelayingPendingTraceBuffer extends PendingTraceBuffer {
        private static final long FORCE_SEND_DELAY_MS;
        private static final long SEND_DELAY_NS;
        private static final long SLEEP_TIME_MS = 100;
        private final MpscBlockingConsumerArrayQueue<Element> queue;
        private final LongRunningTracesTracker runningTracesTracker;
        private final TimeSource timeSource;
        private volatile boolean closed = false;
        private final AtomicInteger flushCounter = new AtomicInteger(0);
        private final Thread worker = AgentThreadFactory.newAgentThread(AgentThreadFactory.AgentThread.TRACE_MONITOR, new Worker());

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            FORCE_SEND_DELAY_MS = 5000L;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            SEND_DELAY_NS = 500000000L;
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public boolean longRunningSpansEnabled() {
            return this.runningTracesTracker != null;
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void enqueue(Element element) {
            if (!element.setEnqueued(true) || this.queue.offer(element)) {
                return;
            }
            element.setEnqueued(false);
            if (element.writeOnBufferFull()) {
                element.write();
            }
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void start() {
            this.worker.start();
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer, java.lang.AutoCloseable
        public void close() {
            flush();
            this.closed = true;
            this.worker.interrupt();
            try {
                this.worker.join(800L);
            } catch (InterruptedException unused) {
            }
        }

        private void yieldOrSleep(int i) {
            if (i <= 3) {
                Thread.yield();
            } else {
                try {
                    Thread.sleep(10L);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void flush() {
            if (this.worker.isAlive()) {
                int i = this.flushCounter.get();
                boolean zOffer = this.queue.offer(FlushElement.FLUSH_ELEMENT);
                int i2 = 1;
                while (!this.closed && !zOffer) {
                    int i3 = i2 + 1;
                    yieldOrSleep(i2);
                    i2 = i3;
                    zOffer = this.queue.offer(FlushElement.FLUSH_ELEMENT);
                }
                int i4 = this.flushCounter.get();
                while (!this.closed && i >= i4) {
                    int i5 = i2 + 1;
                    yieldOrSleep(i2);
                    i2 = i5;
                    i4 = this.flushCounter.get();
                }
            }
        }

        private static final class WriteDrain implements MessagePassingQueue.Consumer<Element> {
            private static final WriteDrain WRITE_DRAIN = new WriteDrain();

            private WriteDrain() {
            }

            @Override // org.jctools.queues.MessagePassingQueue.Consumer
            public void accept(Element element) {
                element.write();
            }
        }

        private static final class FlushElement implements Element {
            static FlushElement FLUSH_ELEMENT = new FlushElement();

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public DDSpan getRootSpan() {
                return null;
            }

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public boolean lastReferencedNanosAgo(long j) {
                return false;
            }

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public long oldestFinishedTime() {
                return 0L;
            }

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public boolean setEnqueued(boolean z) {
                return true;
            }

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public void write() {
            }

            @Override // com.datadog.trace.core.PendingTraceBuffer.Element
            public boolean writeOnBufferFull() {
                return true;
            }

            private FlushElement() {
            }
        }

        private final class Worker implements Runnable {
            private Worker() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Element element;
                while (!DelayingPendingTraceBuffer.this.closed && !Thread.currentThread().isInterrupted()) {
                    try {
                        boolean zLongRunningSpansEnabled = DelayingPendingTraceBuffer.this.longRunningSpansEnabled();
                        DelayingPendingTraceBuffer delayingPendingTraceBuffer = DelayingPendingTraceBuffer.this;
                        if (zLongRunningSpansEnabled) {
                            element = (Element) delayingPendingTraceBuffer.queue.poll(1L, TimeUnit.SECONDS);
                            DelayingPendingTraceBuffer.this.runningTracesTracker.flushAndCompact(DelayingPendingTraceBuffer.this.timeSource.getCurrentTimeMillis());
                            if (element == null) {
                            }
                        } else {
                            element = (Element) delayingPendingTraceBuffer.queue.take();
                        }
                        if (element instanceof FlushElement) {
                            DelayingPendingTraceBuffer.this.queue.drain(WriteDrain.WRITE_DRAIN);
                            DelayingPendingTraceBuffer.this.flushCounter.incrementAndGet();
                        } else {
                            element.setEnqueued(false);
                            if (!DelayingPendingTraceBuffer.this.longRunningSpansEnabled() || !DelayingPendingTraceBuffer.this.runningTracesTracker.add(element)) {
                                long jOldestFinishedTime = element.oldestFinishedTime();
                                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                if (jOldestFinishedTime / 1000000 <= DelayingPendingTraceBuffer.this.timeSource.getCurrentTimeMillis() - DelayingPendingTraceBuffer.FORCE_SEND_DELAY_MS) {
                                    element.write();
                                } else if (element.lastReferencedNanosAgo(DelayingPendingTraceBuffer.SEND_DELAY_NS)) {
                                    element.write();
                                } else {
                                    DelayingPendingTraceBuffer.this.enqueue(element);
                                    Thread.sleep(100L);
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DelayingPendingTraceBuffer(int i, TimeSource timeSource, Config config, HealthMetrics healthMetrics) {
            this.queue = new MpscBlockingConsumerArrayQueue<>(i);
            this.timeSource = timeSource;
            this.runningTracesTracker = config.isLongRunningTraceEnabled() ? new LongRunningTracesTracker(config, i, healthMetrics) : null;
        }
    }

    static class DiscardingPendingTraceBuffer extends PendingTraceBuffer {
        private final Logger log;

        @Override // com.datadog.trace.core.PendingTraceBuffer, java.lang.AutoCloseable
        public void close() {
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void flush() {
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void start() {
        }

        public DiscardingPendingTraceBuffer(InternalLogger internalLogger) {
            this.log = LoggerFactory.getLogger(DiscardingPendingTraceBuffer.class.getSimpleName(), internalLogger);
        }

        @Override // com.datadog.trace.core.PendingTraceBuffer
        public void enqueue(Element element) {
            this.log.debug("PendingTrace enqueued but won't be reported. Root span: {}", element.getRootSpan());
        }
    }

    public static PendingTraceBuffer delaying(TimeSource timeSource, Config config, HealthMetrics healthMetrics) {
        return new DelayingPendingTraceBuffer(4096, timeSource, config, healthMetrics);
    }

    public static PendingTraceBuffer discarding(InternalLogger internalLogger) {
        return new DiscardingPendingTraceBuffer(internalLogger);
    }
}
