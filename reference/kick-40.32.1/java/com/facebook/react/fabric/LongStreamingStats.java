package com.facebook.react.fabric;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: compiled from: LongStreamingStats.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/fabric/LongStreamingStats;", "", "<init>", "()V", "minHeap", "Ljava/util/Queue;", "", "maxHeap", "value", "", "average", "getAverage", "()D", "len", "", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "getMax", "()J", "add", "", "n", "median", "getMedian", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LongStreamingStats {
    private double average;
    private int len;
    private long max;
    private final Queue<Long> minHeap = new PriorityQueue(11);
    private final Queue<Long> maxHeap = new PriorityQueue(11, ComparisonsKt.reverseOrder());

    public final double getAverage() {
        return this.average;
    }

    public final long getMax() {
        return this.max;
    }

    public final void add(long n) {
        double d;
        if (n != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(n));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(n));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i = this.len;
        int i2 = i + 1;
        this.len = i2;
        if (i2 == 1) {
            d = n;
        } else {
            d = (n / ((long) i2)) + (this.average / ((double) (i2 / i)));
        }
        this.average = d;
        long j = this.max;
        if (n <= j) {
            n = j;
        }
        this.max = n;
    }

    public final double getMedian() {
        Long lValueOf;
        if (this.minHeap.isEmpty() && this.maxHeap.isEmpty()) {
            return 0.0d;
        }
        int size = this.minHeap.size();
        int size2 = this.maxHeap.size();
        Queue<Long> queue = this.minHeap;
        if (size > size2) {
            lValueOf = queue.peek();
        } else {
            Long lPeek = queue.peek();
            long jLongValue = lPeek != null ? lPeek.longValue() : 0L;
            Long lPeek2 = this.maxHeap.peek();
            lValueOf = Long.valueOf((jLongValue + (lPeek2 != null ? lPeek2.longValue() : 0L)) / 2);
        }
        return lValueOf.longValue();
    }
}
