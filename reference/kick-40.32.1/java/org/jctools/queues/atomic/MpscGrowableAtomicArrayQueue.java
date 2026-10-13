package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* JADX INFO: loaded from: classes11.dex */
public class MpscGrowableAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueue<E> {
    public MpscGrowableAtomicArrayQueue(int i) {
        super(Math.max(2, Pow2.roundToPowerOfTwo(i / 8)), i);
    }

    public MpscGrowableAtomicArrayQueue(int i, int i2) {
        super(i, i2);
    }

    @Override // org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray) {
        RangeUtil.checkLessThanOrEqual(AtomicQueueUtil.length(atomicReferenceArray), this.maxQueueCapacity / 2, "buffer.length");
        return ((AtomicQueueUtil.length(atomicReferenceArray) - 1) * 2) + 1;
    }

    @Override // org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long getCurrentBufferCapacity(long j) {
        return 2 + j == this.maxQueueCapacity ? this.maxQueueCapacity : j;
    }
}
