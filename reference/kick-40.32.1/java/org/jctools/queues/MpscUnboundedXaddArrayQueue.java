package org.jctools.queues;

import java.util.Iterator;
import org.jctools.util.PortableJvmInfo;

/* JADX INFO: loaded from: classes11.dex */
public class MpscUnboundedXaddArrayQueue<E> extends MpUnboundedXaddArrayQueue<MpscUnboundedXaddChunk<E>, E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.fill(supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MpscUnboundedXaddArrayQueue(int i, int i2) {
        super(i, i2);
    }

    public MpscUnboundedXaddArrayQueue(int i) {
        this(i, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue
    public final MpscUnboundedXaddChunk<E> newChunk(long j, MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk, int i, boolean z) {
        return new MpscUnboundedXaddChunk<>(j, mpscUnboundedXaddChunk, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.chunkMask;
        int i2 = this.chunkShift;
        long andIncrementProducerIndex = getAndIncrementProducerIndex();
        int i3 = (int) (((long) i) & andIncrementProducerIndex);
        long j = andIncrementProducerIndex >> i2;
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkProducerChunkForIndex = (MpscUnboundedXaddChunk) lvProducerChunk();
        if (mpscUnboundedXaddChunkProducerChunkForIndex.lvIndex() != j) {
            mpscUnboundedXaddChunkProducerChunkForIndex = producerChunkForIndex(mpscUnboundedXaddChunkProducerChunkForIndex, j);
        }
        mpscUnboundedXaddChunkProducerChunkForIndex.soElement(i3, e);
        return true;
    }

    private MpscUnboundedXaddChunk<E> pollNextBuffer(MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk, long j) {
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkSpinForNextIfNotEmpty = spinForNextIfNotEmpty(mpscUnboundedXaddChunk, j);
        if (mpscUnboundedXaddChunkSpinForNextIfNotEmpty == null) {
            return null;
        }
        moveToNextConsumerChunk(mpscUnboundedXaddChunk, mpscUnboundedXaddChunkSpinForNextIfNotEmpty);
        return mpscUnboundedXaddChunkSpinForNextIfNotEmpty;
    }

    private MpscUnboundedXaddChunk<E> spinForNextIfNotEmpty(MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk, long j) {
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk2;
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkLvNext = mpscUnboundedXaddChunk.lvNext();
        if (mpscUnboundedXaddChunkLvNext == null) {
            if (lvProducerIndex() == j) {
                return null;
            }
            long jLvIndex = mpscUnboundedXaddChunk.lvIndex();
            if (lvProducerChunkIndex() == jLvIndex) {
                mpscUnboundedXaddChunk2 = mpscUnboundedXaddChunk;
                mpscUnboundedXaddChunkLvNext = appendNextChunks(mpscUnboundedXaddChunk2, jLvIndex, 1L);
            } else {
                mpscUnboundedXaddChunk2 = mpscUnboundedXaddChunk;
            }
            while (mpscUnboundedXaddChunkLvNext == null) {
                mpscUnboundedXaddChunkLvNext = mpscUnboundedXaddChunk2.lvNext();
            }
        }
        return mpscUnboundedXaddChunkLvNext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        int i = this.chunkMask;
        long jLpConsumerIndex = lpConsumerIndex();
        int i2 = (int) (((long) i) & jLpConsumerIndex);
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkPollNextBuffer = (MpscUnboundedXaddChunk) lvConsumerChunk();
        if (i2 == 0 && jLpConsumerIndex != 0 && (mpscUnboundedXaddChunkPollNextBuffer = pollNextBuffer(mpscUnboundedXaddChunkPollNextBuffer, jLpConsumerIndex)) == null) {
            return null;
        }
        E eLvElement = mpscUnboundedXaddChunkPollNextBuffer.lvElement(i2);
        if (eLvElement == null) {
            if (lvProducerIndex() == jLpConsumerIndex) {
                return null;
            }
            eLvElement = mpscUnboundedXaddChunkPollNextBuffer.spinForElement(i2, false);
        }
        mpscUnboundedXaddChunkPollNextBuffer.soElement(i2, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return eLvElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        int i = this.chunkMask;
        long jLpConsumerIndex = lpConsumerIndex();
        int i2 = (int) (((long) i) & jLpConsumerIndex);
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkSpinForNextIfNotEmpty = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (i2 == 0 && jLpConsumerIndex != 0 && (mpscUnboundedXaddChunkSpinForNextIfNotEmpty = spinForNextIfNotEmpty(mpscUnboundedXaddChunkSpinForNextIfNotEmpty, jLpConsumerIndex)) == null) {
            return null;
        }
        E eLvElement = mpscUnboundedXaddChunkSpinForNextIfNotEmpty.lvElement(i2);
        if (eLvElement != null) {
            return eLvElement;
        }
        if (lvProducerIndex() == jLpConsumerIndex) {
            return null;
        }
        return mpscUnboundedXaddChunkSpinForNextIfNotEmpty.spinForElement(i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E eLvElement;
        int i = this.chunkMask;
        long jLpConsumerIndex = lpConsumerIndex();
        int i2 = (int) (((long) i) & jLpConsumerIndex);
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (i2 == 0 && jLpConsumerIndex != 0) {
            MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkLvNext = mpscUnboundedXaddChunk.lvNext();
            if (mpscUnboundedXaddChunkLvNext == null || (eLvElement = mpscUnboundedXaddChunkLvNext.lvElement(0)) == null) {
                return null;
            }
            moveToNextConsumerChunk(mpscUnboundedXaddChunk, mpscUnboundedXaddChunkLvNext);
            mpscUnboundedXaddChunk = mpscUnboundedXaddChunkLvNext;
        } else {
            eLvElement = mpscUnboundedXaddChunk.lvElement(i2);
            if (eLvElement == null) {
                return null;
            }
        }
        mpscUnboundedXaddChunk.soElement(i2, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return eLvElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        int i = this.chunkMask;
        long jLpConsumerIndex = lpConsumerIndex();
        int i2 = (int) (((long) i) & jLpConsumerIndex);
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkLvNext = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (i2 == 0 && jLpConsumerIndex != 0 && (mpscUnboundedXaddChunkLvNext = mpscUnboundedXaddChunkLvNext.lvNext()) == null) {
            return null;
        }
        return mpscUnboundedXaddChunkLvNext.lvElement(i2);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int i = this.chunkMask + 1;
        int iMin = Math.min(PortableJvmInfo.RECOMENDED_OFFER_BATCH, i);
        long j = 0;
        do {
            int iFill = fill(supplier, iMin);
            if (iFill == 0) {
                return (int) j;
            }
            j += (long) iFill;
        } while (j <= i);
        return (int) j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        E eLvElement;
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
        if (i == 0) {
            return 0;
        }
        int i2 = this.chunkMask;
        long jLpConsumerIndex = lpConsumerIndex();
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunk = (MpscUnboundedXaddChunk) lpConsumerChunk();
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = (int) (((long) i2) & jLpConsumerIndex);
            if (i4 == 0 && jLpConsumerIndex != 0) {
                MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkLvNext = mpscUnboundedXaddChunk.lvNext();
                if (mpscUnboundedXaddChunkLvNext == null || (eLvElement = mpscUnboundedXaddChunkLvNext.lvElement(0)) == null) {
                    return i3;
                }
                moveToNextConsumerChunk(mpscUnboundedXaddChunk, mpscUnboundedXaddChunkLvNext);
                mpscUnboundedXaddChunk = mpscUnboundedXaddChunkLvNext;
                mpscUnboundedXaddChunk.soElement(i4, null);
                jLpConsumerIndex++;
                soConsumerIndex(jLpConsumerIndex);
                consumer.accept(eLvElement);
            } else {
                eLvElement = mpscUnboundedXaddChunk.lvElement(i4);
                if (eLvElement == null) {
                    return i3;
                }
                mpscUnboundedXaddChunk.soElement(i4, null);
                jLpConsumerIndex++;
                soConsumerIndex(jLpConsumerIndex);
                consumer.accept(eLvElement);
            }
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
        if (i == 0) {
            return 0;
        }
        int i2 = this.chunkShift;
        int i3 = this.chunkMask;
        long andAddProducerIndex = getAndAddProducerIndex(i);
        MpscUnboundedXaddChunk<E> mpscUnboundedXaddChunkProducerChunkForIndex = null;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = (int) (((long) i3) & andAddProducerIndex);
            long j = andAddProducerIndex >> i2;
            if (mpscUnboundedXaddChunkProducerChunkForIndex == null || mpscUnboundedXaddChunkProducerChunkForIndex.lvIndex() != j) {
                mpscUnboundedXaddChunkProducerChunkForIndex = producerChunkForIndex(mpscUnboundedXaddChunkProducerChunkForIndex, j);
            }
            mpscUnboundedXaddChunkProducerChunkForIndex.soElement(i5, supplier.get());
            andAddProducerIndex++;
        }
        return i;
    }
}
