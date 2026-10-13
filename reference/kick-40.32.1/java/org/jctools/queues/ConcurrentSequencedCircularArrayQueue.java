package org.jctools.queues;

import org.jctools.util.UnsafeLongArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    protected final long[] sequenceBuffer;

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        int i2 = (int) (this.mask + 1);
        this.sequenceBuffer = UnsafeLongArrayAccess.allocateLongArray(i2);
        for (long j = 0; j < i2; j++) {
            UnsafeLongArrayAccess.soLongElement(this.sequenceBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(j, this.mask), j);
        }
    }
}
