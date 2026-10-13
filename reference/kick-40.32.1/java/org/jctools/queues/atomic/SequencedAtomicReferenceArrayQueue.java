package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes11.dex */
abstract class SequencedAtomicReferenceArrayQueue<E> extends AtomicReferenceArrayQueue<E> {
    protected final AtomicLongArray sequenceBuffer;

    protected static int calcSequenceOffset(long j, int i) {
        return ((int) j) & i;
    }

    public SequencedAtomicReferenceArrayQueue(int i) {
        super(i);
        int i2 = this.mask + 1;
        this.sequenceBuffer = new AtomicLongArray(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            soSequence(this.sequenceBuffer, i3, i3);
        }
    }

    protected final long calcSequenceOffset(long j) {
        return calcSequenceOffset(j, this.mask);
    }

    protected final void soSequence(AtomicLongArray atomicLongArray, int i, long j) {
        atomicLongArray.lazySet(i, j);
    }

    protected final long lvSequence(AtomicLongArray atomicLongArray, int i) {
        return atomicLongArray.get(i);
    }
}
