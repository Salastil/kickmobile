package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MpUnboundedXaddChunk;
import org.jctools.util.PortableJvmInfo;
import org.jctools.util.Pow2;
import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
abstract class MpUnboundedXaddArrayQueue<R extends MpUnboundedXaddChunk<R, E>, E> extends MpUnboundedXaddArrayQueuePad5<R, E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ROTATION = -2;
    final int chunkMask;
    final int chunkShift;
    final SpscArrayQueue<R> freeChunksPool;
    final int maxPooledChunks;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    abstract R newChunk(long j, R r, int i, boolean z);

    MpUnboundedXaddArrayQueue(int i, int i2) {
        if (!UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            throw new IllegalStateException("Unsafe::getAndAddLong support (JDK 8+) is required for this queue to work");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Expecting a positive maxPooledChunks, but got:" + i2);
        }
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.chunkMask = iRoundToPowerOfTwo - 1;
        this.chunkShift = Integer.numberOfTrailingZeros(iRoundToPowerOfTwo);
        this.freeChunksPool = new SpscArrayQueue<>(i2);
        MpUnboundedXaddChunk mpUnboundedXaddChunkNewChunk = newChunk(0L, null, iRoundToPowerOfTwo, i2 > 0);
        soProducerChunk(mpUnboundedXaddChunkNewChunk);
        soProducerChunkIndex(0L);
        soConsumerChunk(mpUnboundedXaddChunkNewChunk);
        for (int i3 = 1; i3 < i2; i3++) {
            this.freeChunksPool.offer((R) newChunk(-1L, null, iRoundToPowerOfTwo, true));
        }
        this.maxPooledChunks = i2;
    }

    public final int chunkSize() {
        return this.chunkMask + 1;
    }

    public final int maxPooledChunks() {
        return this.maxPooledChunks;
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    final R producerChunkForIndex(R r, long j) {
        R r2;
        long j2;
        long j3;
        MpUnboundedXaddArrayQueue<R, E> mpUnboundedXaddArrayQueue;
        MpUnboundedXaddChunk mpUnboundedXaddChunkAppendNextChunks;
        while (true) {
            if (r == null) {
                r = this.lvProducerChunk();
            }
            r2 = r;
            long jLvIndex = r2.lvIndex();
            j2 = jLvIndex - j;
            if (j2 >= 0) {
                break;
            }
            if (this.lvProducerChunkIndex() == jLvIndex) {
                mpUnboundedXaddArrayQueue = this;
                mpUnboundedXaddChunkAppendNextChunks = mpUnboundedXaddArrayQueue.appendNextChunks(r2, jLvIndex, -j2);
            } else {
                mpUnboundedXaddArrayQueue = this;
                mpUnboundedXaddChunkAppendNextChunks = null;
            }
            r = (R) mpUnboundedXaddChunkAppendNextChunks;
            this = mpUnboundedXaddArrayQueue;
        }
        for (j3 = 0; j3 < j2; j3++) {
            r2 = (R) r2.lvPrev();
        }
        return r2;
    }

    protected final R appendNextChunks(R r, long j, long j2) {
        if (!casProducerChunkIndex(j, -2L)) {
            return null;
        }
        long j3 = 1;
        while (j3 <= j2) {
            MpUnboundedXaddChunk mpUnboundedXaddChunkNewOrPooledChunk = newOrPooledChunk(r, j + j3);
            soProducerChunk(mpUnboundedXaddChunkNewOrPooledChunk);
            r.soNext(mpUnboundedXaddChunkNewOrPooledChunk);
            j3++;
            r = (R) mpUnboundedXaddChunkNewOrPooledChunk;
        }
        soProducerChunkIndex(j + j2);
        return r;
    }

    private R newOrPooledChunk(R r, long j) {
        R rPoll = this.freeChunksPool.poll();
        if (rPoll != null) {
            rPoll.soPrev(r);
            rPoll.soIndex(j);
            return rPoll;
        }
        return (R) newChunk(j, r, this.chunkMask + 1, false);
    }

    final void moveToNextConsumerChunk(R r, R r2) {
        r.soNext(null);
        r2.soPrev(null);
        if (r.isPooled()) {
            this.freeChunksPool.offer(r);
        }
        soConsumerChunk(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int i = this.chunkMask + 1;
        return MessagePassingQueueUtil.fillInBatchesToLimit(this, supplier, Math.min(PortableJvmInfo.RECOMENDED_OFFER_BATCH, i), i);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        return MessagePassingQueueUtil.drain(this, consumer, i);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }
}
