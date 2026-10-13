package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
public class SpscChunkedArrayQueue<E> extends BaseSpscLinkedArrayQueue<E> {
    private final int maxQueueCapacity;
    private long producerQueueLimit;

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return super.fill(supplier);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return super.fill(supplier, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.fill(supplier, waitStrategy, exitCondition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return super.offer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpscChunkedArrayQueue(int i) {
        this(Math.max(8, Pow2.roundToPowerOfTwo(i / 8)), i);
    }

    public SpscChunkedArrayQueue(int i, int i2) {
        RangeUtil.checkGreaterThanOrEqual(i2, 16, "capacity");
        RangeUtil.checkGreaterThanOrEqual(i, 8, "chunkSize");
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.maxQueueCapacity = iRoundToPowerOfTwo;
        int iRoundToPowerOfTwo2 = Pow2.roundToPowerOfTwo(i);
        RangeUtil.checkLessThan(iRoundToPowerOfTwo2, iRoundToPowerOfTwo, "chunkCapacity");
        long j = iRoundToPowerOfTwo2 - 1;
        E[] eArr = (E[]) UnsafeRefArrayAccess.allocateRefArray(iRoundToPowerOfTwo2 + 1);
        this.producerBuffer = eArr;
        this.producerMask = j;
        this.consumerBuffer = eArr;
        this.consumerMask = j;
        this.producerBufferLimit = j - 1;
        this.producerQueueLimit = iRoundToPowerOfTwo;
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue
    final boolean offerColdPath(E[] eArr, long j, long j2, long j3, E e, MessagePassingQueue.Supplier<? extends E> supplier) {
        long j4 = j2 + ((j + 1) / 4);
        long jLvConsumerIndex = this.producerQueueLimit;
        if (j2 >= jLvConsumerIndex) {
            jLvConsumerIndex = lvConsumerIndex() + ((long) this.maxQueueCapacity);
            this.producerQueueLimit = jLvConsumerIndex;
            if (j2 >= jLvConsumerIndex) {
                return false;
            }
        }
        if (j4 - jLvConsumerIndex > 0) {
            j4 = jLvConsumerIndex;
        }
        long j5 = j2 + 1;
        if (j4 > j5 && UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j4, j)) == null) {
            this.producerBufferLimit = j4 - 1;
            writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
            return true;
        }
        if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j5, j)) == null) {
            writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
            return true;
        }
        E[] eArr2 = (E[]) UnsafeRefArrayAccess.allocateRefArray((int) (2 + j));
        this.producerBuffer = eArr2;
        linkOldToNew(j2, eArr, j3, eArr2, j3, e == null ? supplier.get() : e);
        return true;
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.maxQueueCapacity;
    }
}
