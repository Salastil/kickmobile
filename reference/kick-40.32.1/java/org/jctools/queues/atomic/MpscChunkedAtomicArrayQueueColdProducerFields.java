package org.jctools.queues.atomic;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* JADX INFO: compiled from: MpscChunkedAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueue<E> {
    protected final long maxQueueCapacity;

    MpscChunkedAtomicArrayQueueColdProducerFields(int i, int i2) {
        super(i);
        RangeUtil.checkGreaterThanOrEqual(i2, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(i), Pow2.roundToPowerOfTwo(i2), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(i2)) << 1;
    }
}
