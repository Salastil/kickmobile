package org.jctools.queues;

import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public class MpmcUnboundedXaddArrayQueue<E> extends MpUnboundedXaddArrayQueue<MpmcUnboundedXaddChunk<E>, E> {
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
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return super.fill(supplier);
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

    public MpmcUnboundedXaddArrayQueue(int i, int i2) {
        super(i, i2);
    }

    public MpmcUnboundedXaddArrayQueue(int i) {
        this(i, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue
    public final MpmcUnboundedXaddChunk<E> newChunk(long j, MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk, int i, boolean z) {
        return new MpmcUnboundedXaddChunk<>(j, mpmcUnboundedXaddChunk, i, z);
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
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkProducerChunkForIndex = (MpmcUnboundedXaddChunk) lvProducerChunk();
        if (mpmcUnboundedXaddChunkProducerChunkForIndex.lvIndex() != j) {
            mpmcUnboundedXaddChunkProducerChunkForIndex = producerChunkForIndex(mpmcUnboundedXaddChunkProducerChunkForIndex, j);
        }
        boolean zIsPooled = mpmcUnboundedXaddChunkProducerChunkForIndex.isPooled();
        if (zIsPooled) {
            mpmcUnboundedXaddChunkProducerChunkForIndex.spinForElement(i3, true);
        }
        mpmcUnboundedXaddChunkProducerChunkForIndex.soElement(i3, e);
        if (zIsPooled) {
            mpmcUnboundedXaddChunkProducerChunkForIndex.soSequence(i3, j);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk;
        int i;
        long j;
        boolean z;
        int i2 = this.chunkMask;
        int i3 = this.chunkShift;
        E e = null;
        long jLvProducerIndex = -1;
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkLvNext = null;
        E eLvElement = null;
        boolean zIsPooled = false;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            mpmcUnboundedXaddChunk = (MpmcUnboundedXaddChunk) lvConsumerChunk();
            i = (int) (((long) i2) & jLvConsumerIndex);
            j = jLvConsumerIndex >> i3;
            long jLvIndex = mpmcUnboundedXaddChunk.lvIndex();
            if (i != 0 || jLvConsumerIndex == 0) {
                if (jLvIndex <= j) {
                    zIsPooled = mpmcUnboundedXaddChunk.isPooled();
                    if (jLvIndex == j) {
                        if (zIsPooled) {
                            long jLvSequence = mpmcUnboundedXaddChunk.lvSequence(i);
                            if (jLvSequence == j) {
                                if (casConsumerIndex(jLvConsumerIndex, jLvConsumerIndex + 1)) {
                                    z = false;
                                    break;
                                }
                            } else if (jLvSequence > j) {
                            }
                        } else {
                            eLvElement = mpmcUnboundedXaddChunk.lvElement(i);
                            if (eLvElement != null) {
                                if (casConsumerIndex(jLvConsumerIndex, jLvConsumerIndex + 1)) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (jLvConsumerIndex >= jLvProducerIndex) {
                        long jLvProducerIndex2 = lvProducerIndex();
                        if (jLvConsumerIndex == jLvProducerIndex2) {
                            return null;
                        }
                        jLvProducerIndex = jLvProducerIndex2;
                    }
                    e = null;
                }
                e = null;
            } else {
                if (j - jLvIndex == 1) {
                    mpmcUnboundedXaddChunkLvNext = mpmcUnboundedXaddChunk.lvNext();
                    if (mpmcUnboundedXaddChunkLvNext == null && jLvConsumerIndex >= jLvProducerIndex) {
                        jLvProducerIndex = lvProducerIndex();
                        if (jLvConsumerIndex == jLvProducerIndex) {
                            return e;
                        }
                    }
                    if (casConsumerIndex(jLvConsumerIndex, jLvConsumerIndex + 1)) {
                        z = true;
                        break;
                    }
                }
                e = null;
            }
        }
        if (z) {
            return switchToNextConsumerChunkAndPoll(mpmcUnboundedXaddChunk, mpmcUnboundedXaddChunkLvNext, j);
        }
        if (zIsPooled) {
            eLvElement = mpmcUnboundedXaddChunk.lvElement(i);
        }
        mpmcUnboundedXaddChunk.soElement(i, null);
        return eLvElement;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    private E switchToNextConsumerChunkAndPoll(MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk, MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk2, long j) {
        MpmcUnboundedXaddArrayQueue<E> mpmcUnboundedXaddArrayQueue;
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk3;
        if (mpmcUnboundedXaddChunk2 == null) {
            long j2 = j - 1;
            if (lvProducerChunkIndex() == j2) {
                mpmcUnboundedXaddArrayQueue = this;
                mpmcUnboundedXaddChunk3 = mpmcUnboundedXaddChunk;
                mpmcUnboundedXaddChunk2 = mpmcUnboundedXaddArrayQueue.appendNextChunks(mpmcUnboundedXaddChunk3, j2, 1L);
            } else {
                mpmcUnboundedXaddArrayQueue = this;
                mpmcUnboundedXaddChunk3 = mpmcUnboundedXaddChunk;
            }
        } else {
            mpmcUnboundedXaddArrayQueue = this;
            mpmcUnboundedXaddChunk3 = mpmcUnboundedXaddChunk;
        }
        while (mpmcUnboundedXaddChunk2 == null) {
            mpmcUnboundedXaddChunk2 = mpmcUnboundedXaddChunk3.lvNext();
        }
        E eSpinForElement = mpmcUnboundedXaddChunk2.spinForElement(0, false);
        if (mpmcUnboundedXaddChunk2.isPooled()) {
            mpmcUnboundedXaddChunk2.spinForSequence(0, j);
        }
        mpmcUnboundedXaddChunk2.soElement(0, null);
        mpmcUnboundedXaddArrayQueue.moveToNextConsumerChunk(mpmcUnboundedXaddChunk3, mpmcUnboundedXaddChunk2);
        return eSpinForElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E eLvElement;
        int i = this.chunkMask;
        int i2 = this.chunkShift;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkLvNext = (MpmcUnboundedXaddChunk) lvConsumerChunk();
            int i3 = (int) (((long) i) & jLvConsumerIndex);
            long j = jLvConsumerIndex >> i2;
            eLvElement = ((i3 != 0 || jLvConsumerIndex == 0 || (j - 1 == mpmcUnboundedXaddChunkLvNext.lvIndex() && (mpmcUnboundedXaddChunkLvNext = mpmcUnboundedXaddChunkLvNext.lvNext()) != null)) && (!mpmcUnboundedXaddChunkLvNext.isPooled() ? mpmcUnboundedXaddChunkLvNext.lvIndex() != j : mpmcUnboundedXaddChunkLvNext.lvSequence(i3) != j)) ? mpmcUnboundedXaddChunkLvNext.lvElement(i3) : null;
            if (eLvElement != null || jLvConsumerIndex == lvProducerIndex()) {
                if (eLvElement == null || jLvConsumerIndex == lvConsumerIndex()) {
                    break;
                }
            }
        }
        return eLvElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E eLvElement;
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkLvNext;
        E eLvElement2;
        int i = this.chunkMask;
        int i2 = this.chunkShift;
        long jLvConsumerIndex = lvConsumerIndex();
        MpmcUnboundedXaddChunk mpmcUnboundedXaddChunk = (MpmcUnboundedXaddChunk) lvConsumerChunk();
        int i3 = (int) (((long) i) & jLvConsumerIndex);
        long j = jLvConsumerIndex >> i2;
        if (i3 != 0 || jLvConsumerIndex == 0) {
            boolean zIsPooled = mpmcUnboundedXaddChunk.isPooled();
            if (zIsPooled) {
                if (mpmcUnboundedXaddChunk.lvSequence(i3) != j) {
                    return null;
                }
                eLvElement = null;
            } else if (mpmcUnboundedXaddChunk.lvIndex() != j || (eLvElement = mpmcUnboundedXaddChunk.lvElement(i3)) == null) {
                return null;
            }
            if (!casConsumerIndex(jLvConsumerIndex, 1 + jLvConsumerIndex)) {
                return null;
            }
            if (zIsPooled) {
                eLvElement = mpmcUnboundedXaddChunk.lvElement(i3);
            }
            mpmcUnboundedXaddChunk.soElement(i3, null);
            return eLvElement;
        }
        if (j - 1 != mpmcUnboundedXaddChunk.lvIndex() || (mpmcUnboundedXaddChunkLvNext = mpmcUnboundedXaddChunk.lvNext()) == null) {
            return null;
        }
        boolean zIsPooled2 = mpmcUnboundedXaddChunkLvNext.isPooled();
        if (!zIsPooled2) {
            eLvElement2 = mpmcUnboundedXaddChunkLvNext.lvElement(0);
            if (eLvElement2 == null) {
                return null;
            }
        } else {
            if (mpmcUnboundedXaddChunkLvNext.lvSequence(0) != j) {
                return null;
            }
            eLvElement2 = null;
        }
        if (!casConsumerIndex(jLvConsumerIndex, 1 + jLvConsumerIndex)) {
            return null;
        }
        if (zIsPooled2) {
            eLvElement2 = mpmcUnboundedXaddChunkLvNext.lvElement(0);
        }
        mpmcUnboundedXaddChunkLvNext.soElement(0, null);
        moveToNextConsumerChunk(mpmcUnboundedXaddChunk, mpmcUnboundedXaddChunkLvNext);
        return eLvElement2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        int i = this.chunkMask;
        int i2 = this.chunkShift;
        long jLvConsumerIndex = lvConsumerIndex();
        int i3 = (int) (((long) i) & jLvConsumerIndex);
        long j = jLvConsumerIndex >> i2;
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkLvNext = (MpmcUnboundedXaddChunk) lvConsumerChunk();
        int i4 = i + 1;
        if (i3 == 0 && jLvConsumerIndex >= i4 && (j - 1 != mpmcUnboundedXaddChunkLvNext.lvIndex() || (mpmcUnboundedXaddChunkLvNext = mpmcUnboundedXaddChunkLvNext.lvNext()) == null)) {
            return null;
        }
        if (mpmcUnboundedXaddChunkLvNext.isPooled()) {
            if (mpmcUnboundedXaddChunkLvNext.lvSequence(i3) != j) {
                return null;
            }
        } else if (mpmcUnboundedXaddChunkLvNext.lvIndex() != j) {
            return null;
        }
        E eLvElement = mpmcUnboundedXaddChunkLvNext.lvElement(i3);
        if (jLvConsumerIndex != lvConsumerIndex()) {
            return null;
        }
        return eLvElement;
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
        MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunkProducerChunkForIndex = null;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = (int) (((long) i3) & andAddProducerIndex);
            long jLvIndex = andAddProducerIndex >> i2;
            if (mpmcUnboundedXaddChunkProducerChunkForIndex == null || mpmcUnboundedXaddChunkProducerChunkForIndex.lvIndex() != jLvIndex) {
                mpmcUnboundedXaddChunkProducerChunkForIndex = producerChunkForIndex(mpmcUnboundedXaddChunkProducerChunkForIndex, jLvIndex);
                if (mpmcUnboundedXaddChunkProducerChunkForIndex.isPooled()) {
                    jLvIndex = mpmcUnboundedXaddChunkProducerChunkForIndex.lvIndex();
                }
            }
            if (mpmcUnboundedXaddChunkProducerChunkForIndex.isPooled()) {
                while (mpmcUnboundedXaddChunkProducerChunkForIndex.lvElement(i5) != null) {
                }
            }
            mpmcUnboundedXaddChunkProducerChunkForIndex.soElement(i5, supplier.get());
            if (mpmcUnboundedXaddChunkProducerChunkForIndex.isPooled()) {
                mpmcUnboundedXaddChunkProducerChunkForIndex.soSequence(i5, jLvIndex);
            }
            andAddProducerIndex++;
        }
        return i;
    }
}
