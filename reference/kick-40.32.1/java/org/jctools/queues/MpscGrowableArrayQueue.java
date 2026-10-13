package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* JADX INFO: loaded from: classes11.dex */
public class MpscGrowableArrayQueue<E> extends MpscChunkedArrayQueue<E> {
    public MpscGrowableArrayQueue(int i) {
        super(Math.max(2, Pow2.roundToPowerOfTwo(i / 8)), i);
    }

    public MpscGrowableArrayQueue(int i, int i2) {
        super(i, i2);
    }

    @Override // org.jctools.queues.MpscChunkedArrayQueue, org.jctools.queues.BaseMpscLinkedArrayQueue
    protected int getNextBufferSize(E[] eArr) {
        RangeUtil.checkLessThanOrEqual(LinkedArrayQueueUtil.length(eArr), this.maxQueueCapacity / 2, "buffer.length");
        return ((LinkedArrayQueueUtil.length(eArr) - 1) * 2) + 1;
    }

    @Override // org.jctools.queues.MpscChunkedArrayQueue, org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long getCurrentBufferCapacity(long j) {
        return 2 + j == this.maxQueueCapacity ? this.maxQueueCapacity : j;
    }
}
