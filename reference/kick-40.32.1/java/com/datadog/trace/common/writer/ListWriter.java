package com.datadog.trace.common.writer;

import com.datadog.trace.core.DDSpan;
import com.datadog.trace.core.MetadataConsumer;
import com.datadog.trace.core.tagprocessor.PeerServiceCalculator;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class ListWriter extends CopyOnWriteArrayList<List<DDSpan>> implements Writer {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ListWriter.class);
    public static final Filter ACCEPT_ALL = new Filter() { // from class: com.datadog.trace.common.writer.ListWriter.1
        @Override // com.datadog.trace.common.writer.ListWriter.Filter
        public boolean accept(List<DDSpan> list) {
            return true;
        }
    };
    private final List<CountDownLatch> latches = new ArrayList();
    private final AtomicInteger traceCount = new AtomicInteger();
    private final TraceStructureWriter structureWriter = new TraceStructureWriter(true);
    private final PeerServiceCalculator peerServiceCalculator = new PeerServiceCalculator();
    private Filter filter = ACCEPT_ALL;

    public interface Filter {
        boolean accept(List<DDSpan> list);
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void incrementDropCounts(int i) {
    }

    public List<DDSpan> firstTrace() {
        return get(0);
    }

    public List<DDSpan> secondTrace() {
        return get(1);
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void write(List<DDSpan> list) {
        if (this.filter.accept(list)) {
            Iterator<DDSpan> it = list.iterator();
            while (it.hasNext()) {
                it.next().processTagsAndBaggage(MetadataConsumer.NO_OP);
            }
            this.traceCount.incrementAndGet();
            synchronized (this.latches) {
                add(list);
                for (CountDownLatch countDownLatch : this.latches) {
                    if (size() >= countDownLatch.getCount()) {
                        while (countDownLatch.getCount() > 0) {
                            countDownLatch.countDown();
                        }
                    }
                }
            }
            this.structureWriter.write(list);
        }
    }

    public boolean waitForTracesMax(int i, int i2) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(i);
        synchronized (this.latches) {
            if (size() >= i) {
                return true;
            }
            this.latches.add(countDownLatch);
            return countDownLatch.await(i2, TimeUnit.SECONDS);
        }
    }

    public void waitForTraces(int i) throws InterruptedException, TimeoutException {
        if (waitForTracesMax(i, 20)) {
            return;
        }
        String str = "Timeout waiting for " + i + " trace(s). ListWriter.size() == " + size() + " : " + super.toString();
        log.warn(str);
        throw new TimeoutException(str);
    }

    public void waitUntilReported(DDSpan dDSpan) throws InterruptedException, TimeoutException {
        waitUntilReported(dDSpan, 20, TimeUnit.SECONDS);
    }

    public void waitUntilReported(DDSpan dDSpan, int i, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch;
        do {
            countDownLatch = new CountDownLatch(size() + 1);
            synchronized (this.latches) {
                this.latches.add(countDownLatch);
            }
            if (isReported(dDSpan)) {
                return;
            }
        } while (countDownLatch.await(i, timeUnit));
        String str = "Timeout waiting for span to be reported: " + dDSpan;
        log.warn(str);
        throw new TimeoutException(str);
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    private boolean isReported(DDSpan dDSpan) {
        Iterator<List<DDSpan>> it = iterator();
        while (it.hasNext()) {
            Iterator<DDSpan> it2 = it.next().iterator();
            while (it2.hasNext()) {
                if (it2.next() == dDSpan) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void start() {
        close();
    }

    @Override // com.datadog.trace.common.writer.Writer
    public boolean flush() {
        this.filter = ACCEPT_ALL;
        return true;
    }

    public AtomicInteger getTraceCount() {
        return this.traceCount;
    }

    @Override // com.datadog.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        clear();
        synchronized (this.latches) {
            for (CountDownLatch countDownLatch : this.latches) {
                while (countDownLatch.getCount() > 0) {
                    countDownLatch.countDown();
                }
            }
            this.latches.clear();
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList
    public String toString() {
        return "ListWriter { size=" + size() + " }";
    }
}
