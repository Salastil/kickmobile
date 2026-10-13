package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* JADX INFO: compiled from: MpscCompoundQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class MpscCompoundQueueColdFields<E> extends MpscCompoundQueueL0Pad<E> {
    protected final int parallelQueues;
    protected final int parallelQueuesMask;
    protected final MpscArrayQueue<E>[] queues;

    MpscCompoundQueueColdFields(int i, int i2) {
        i2 = Pow2.isPowerOfTwo(i2) ? i2 : Pow2.roundToPowerOfTwo(i2) / 2;
        this.parallelQueues = i2;
        this.parallelQueuesMask = i2 - 1;
        this.queues = new MpscArrayQueue[i2];
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        RangeUtil.checkGreaterThanOrEqual(iRoundToPowerOfTwo, i2, "fullCapacity");
        for (int i3 = 0; i3 < this.parallelQueues; i3++) {
            this.queues[i3] = new MpscArrayQueue<>(iRoundToPowerOfTwo / this.parallelQueues);
        }
    }
}
