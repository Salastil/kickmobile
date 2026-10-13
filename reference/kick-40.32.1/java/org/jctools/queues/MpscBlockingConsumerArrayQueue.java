package org.jctools.queues;

import androidx.collection.SieveCacheKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
public class MpscBlockingConsumerArrayQueue<E> extends MpscBlockingConsumerArrayQueueConsumerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators, BlockingQueue<E> {
    byte b000;
    byte b001;
    byte b002;
    byte b003;
    byte b004;
    byte b005;
    byte b006;
    byte b007;
    byte b010;
    byte b011;
    byte b012;
    byte b013;
    byte b014;
    byte b015;
    byte b016;
    byte b017;
    byte b020;
    byte b021;
    byte b022;
    byte b023;
    byte b024;
    byte b025;
    byte b026;
    byte b027;
    byte b030;
    byte b031;
    byte b032;
    byte b033;
    byte b034;
    byte b035;
    byte b036;
    byte b037;
    byte b040;
    byte b041;
    byte b042;
    byte b043;
    byte b044;
    byte b045;
    byte b046;
    byte b047;
    byte b050;
    byte b051;
    byte b052;
    byte b053;
    byte b054;
    byte b055;
    byte b056;
    byte b057;
    byte b060;
    byte b061;
    byte b062;
    byte b063;
    byte b064;
    byte b065;
    byte b066;
    byte b067;
    byte b070;
    byte b071;
    byte b072;
    byte b073;
    byte b074;
    byte b075;
    byte b076;
    byte b077;
    byte b100;
    byte b101;
    byte b102;
    byte b103;
    byte b104;
    byte b105;
    byte b106;
    byte b107;
    byte b110;
    byte b111;
    byte b112;
    byte b113;
    byte b114;
    byte b115;
    byte b116;
    byte b117;
    byte b120;
    byte b121;
    byte b122;
    byte b123;
    byte b124;
    byte b125;
    byte b126;
    byte b127;
    byte b130;
    byte b131;
    byte b132;
    byte b133;
    byte b134;
    byte b135;
    byte b136;
    byte b137;
    byte b140;
    byte b141;
    byte b142;
    byte b143;
    byte b144;
    byte b145;
    byte b146;
    byte b147;
    byte b150;
    byte b151;
    byte b152;
    byte b153;
    byte b154;
    byte b155;
    byte b156;
    byte b157;
    byte b160;
    byte b161;
    byte b162;
    byte b163;
    byte b164;
    byte b165;
    byte b166;
    byte b167;
    byte b170;
    byte b171;
    byte b172;
    byte b173;
    byte b174;
    byte b175;
    byte b176;
    byte b177;

    public MpscBlockingConsumerArrayQueue(int i) {
        super((Pow2.roundToPowerOfTwo(i) - 1) << 1, UnsafeRefArrayAccess.allocateRefArray(Pow2.roundToPowerOfTwo(i)));
        RangeUtil.checkGreaterThanOrEqual(i, 1, "capacity");
        soProducerLimit((Pow2.roundToPowerOfTwo(i) - 1) << 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final int size() {
        long jLvProducerIndex;
        long jLvConsumerIndex;
        long jLvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            jLvProducerIndex = lvProducerIndex();
            jLvConsumerIndex = lvConsumerIndex();
            if (jLvConsumerIndex2 == jLvConsumerIndex) {
                break;
            }
            jLvConsumerIndex2 = jLvConsumerIndex;
        }
        long j = (jLvProducerIndex - jLvConsumerIndex) >> 1;
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return lvConsumerIndex() / 2 == lvProducerIndex() / 2;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        long j;
        MpscBlockingConsumerArrayQueue<E> mpscBlockingConsumerArrayQueue = this;
        if (e == null) {
            throw null;
        }
        long j2 = mpscBlockingConsumerArrayQueue.producerMask;
        long j3 = 2;
        long j4 = j2 + 2;
        boolean z = true;
        int i2 = i << 1;
        E[] eArr = mpscBlockingConsumerArrayQueue.producerBuffer;
        while (true) {
            long jLvProducerIndex = mpscBlockingConsumerArrayQueue.lvProducerIndex();
            if ((jLvProducerIndex & 1) == 1) {
                if (mpscBlockingConsumerArrayQueue.offerAndWakeup(eArr, j2, jLvProducerIndex, e)) {
                    return z;
                }
                mpscBlockingConsumerArrayQueue = this;
            } else {
                long jLvProducerLimit = lvProducerLimit();
                long j5 = j4 - (jLvProducerLimit - jLvProducerIndex);
                E[] eArr2 = eArr;
                long j6 = j2;
                long j7 = i2;
                if (j5 >= j7 || jLvProducerLimit <= jLvProducerIndex) {
                    j = j6;
                    mpscBlockingConsumerArrayQueue = this;
                    if (!mpscBlockingConsumerArrayQueue.recalculateProducerLimit(jLvProducerIndex, jLvProducerLimit, lvConsumerIndex(), j4, j7)) {
                        return false;
                    }
                } else {
                    j = j6;
                    mpscBlockingConsumerArrayQueue = this;
                }
                if (mpscBlockingConsumerArrayQueue.casProducerIndex(jLvProducerIndex, jLvProducerIndex + j3)) {
                    UnsafeRefArrayAccess.soRefElement(eArr2, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLvProducerIndex, j), e);
                    return z;
                }
                j2 = j;
                eArr = eArr2;
                z = z;
                j3 = j3;
            }
        }
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        MpscBlockingConsumerArrayQueue<E> mpscBlockingConsumerArrayQueue;
        E[] eArr;
        if (e == null) {
            throw null;
        }
        long j = this.producerMask;
        E[] eArr2 = this.producerBuffer;
        while (true) {
            long jLvProducerIndex = this.lvProducerIndex();
            if ((jLvProducerIndex & 1) == 1) {
                mpscBlockingConsumerArrayQueue = this;
                eArr = eArr2;
                if (mpscBlockingConsumerArrayQueue.offerAndWakeup(eArr2, j, jLvProducerIndex, e)) {
                    return true;
                }
            } else {
                mpscBlockingConsumerArrayQueue = this;
                eArr = eArr2;
                long jLvProducerLimit = mpscBlockingConsumerArrayQueue.lvProducerLimit();
                if (jLvProducerLimit <= jLvProducerIndex) {
                    long j2 = j;
                    j = j2;
                    if (!mpscBlockingConsumerArrayQueue.recalculateProducerLimit(j2, jLvProducerIndex, jLvProducerLimit)) {
                        jLvProducerIndex = jLvProducerIndex;
                        return false;
                    }
                }
                jLvProducerIndex = jLvProducerIndex;
                if (mpscBlockingConsumerArrayQueue.casProducerIndex(jLvProducerIndex, 2 + jLvProducerIndex)) {
                    UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLvProducerIndex, j), e);
                    return true;
                }
            }
            this = mpscBlockingConsumerArrayQueue;
            eArr2 = eArr;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (!offer(e)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (offer(e)) {
            return true;
        }
        throw new UnsupportedOperationException();
    }

    private boolean offerAndWakeup(E[] eArr, long j, long j2, E e) {
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j2, j);
        Thread threadLvBlocked = lvBlocked();
        if (threadLvBlocked == null || !casProducerIndex(j2, 1 + j2)) {
            return false;
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, e);
        LockSupport.unpark(threadLvBlocked);
        return true;
    }

    private boolean recalculateProducerLimit(long j, long j2, long j3) {
        long j4 = j + 2;
        return recalculateProducerLimit(j2, j3, lvConsumerIndex(), j4, j4);
    }

    private boolean recalculateProducerLimit(long j, long j2, long j3, long j4, long j5) {
        long j6 = j3 + j4;
        if (j6 > j) {
            casProducerLimit(j2, j6);
        }
        long j7 = j - j3;
        return j7 < j5 && j7 < j4;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E[] eArr = this.consumerBuffer;
        long j = this.consumerMask;
        long jLpConsumerIndex = lpConsumerIndex();
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e == null) {
            return parkUntilNext(eArr, jLpConsumerIndex, jModifiedCalcCircularRefElementOffset, Long.MAX_VALUE);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E[] eArr = this.consumerBuffer;
        long j2 = this.consumerMask;
        long jLpConsumerIndex = lpConsumerIndex();
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j2);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e == null) {
            long nanos = timeUnit.toNanos(j);
            if (nanos <= 0) {
                return null;
            }
            return parkUntilNext(eArr, jLpConsumerIndex, jModifiedCalcCircularRefElementOffset, nanos);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e;
    }

    private E parkUntilNext(E[] eArr, long j, long j2, long j3) throws InterruptedException {
        long jLvProducerIndex = lvProducerIndex();
        if (j == jLvProducerIndex) {
            long j4 = jLvProducerIndex + 1;
            if (casProducerIndex(jLvProducerIndex, j4)) {
                soBlocked(Thread.currentThread());
                long jNanoTime = j3 == Long.MAX_VALUE ? 0L : System.nanoTime() + j3;
                long jNanoTime2 = j3;
                while (true) {
                    try {
                        LockSupport.parkNanos(this, jNanoTime2);
                        if (!Thread.interrupted()) {
                            if ((lvProducerIndex() & 1) == 0) {
                                break;
                            }
                            jNanoTime2 = jNanoTime2 == Long.MAX_VALUE ? Long.MAX_VALUE : jNanoTime - System.nanoTime();
                            if (jNanoTime2 <= 0) {
                                if (!casProducerIndex(j4, jLvProducerIndex)) {
                                    break;
                                }
                                soBlocked(null);
                                return null;
                            }
                        } else {
                            casProducerIndex(j4, jLvProducerIndex);
                            throw new InterruptedException();
                        }
                    } catch (Throwable th) {
                        soBlocked(null);
                        throw th;
                    }
                }
                soBlocked(null);
            }
        }
        E e = (E) spinWaitForElement(eArr, j2);
        UnsafeRefArrayAccess.soRefElement(eArr, j2, null);
        soConsumerIndex(j + 2);
        return e;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return capacity() - size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        E[] eArr = this.consumerBuffer;
        long j = this.consumerMask;
        long jLpConsumerIndex = lpConsumerIndex();
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e == null) {
            if (jLpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            e = (E) spinWaitForElement(eArr, jModifiedCalcCircularRefElementOffset);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e;
    }

    private static <E> E spinWaitForElement(E[] eArr, long j) {
        E e;
        do {
            e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, j);
        } while (e == null);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.consumerBuffer;
        long j = this.consumerMask;
        long jLpConsumerIndex = lpConsumerIndex();
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        return (e != null || jLpConsumerIndex == lvProducerIndex()) ? e : (E) spinWaitForElement(eArr, jModifiedCalcCircularRefElementOffset);
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) ((this.consumerMask + 2) >> 1);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, this.consumerMask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e == null) {
            return null;
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.consumerBuffer, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex(), this.consumerMask));
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        Thread threadLvBlocked;
        long jLvProducerIndex;
        long jMin;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
        if (i == 0) {
            return 0;
        }
        long j = this.producerMask;
        long j2 = ((long) i) * 2;
        loop0: while (true) {
            threadLvBlocked = null;
            while (true) {
                jLvProducerIndex = lvProducerIndex();
                long jLvProducerLimit = lvProducerLimit();
                if ((jLvProducerIndex & 1) == 1) {
                    threadLvBlocked = lvBlocked();
                    if (threadLvBlocked == null) {
                    }
                } else {
                    long j3 = jLvProducerIndex + j2;
                    long jMin2 = Math.min(jLvProducerLimit, j3);
                    if (jLvProducerIndex < jLvProducerLimit) {
                        jMin = jMin2;
                    } else {
                        if (!recalculateProducerLimit(j, jLvProducerIndex, jLvProducerLimit)) {
                            return 0;
                        }
                        jMin = Math.min(lvProducerLimit(), j3);
                    }
                    if (casProducerIndex(jLvProducerIndex, jMin)) {
                        break loop0;
                    }
                }
            }
            jMin = jLvProducerIndex + 1;
            if (casProducerIndex(jLvProducerIndex, jMin)) {
                jLvProducerIndex--;
                break;
            }
        }
        int i2 = (int) ((jMin - jLvProducerIndex) / 2);
        E[] eArr = this.producerBuffer;
        for (int i3 = 0; i3 < i2; i3++) {
            UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset((((long) i3) * 2) + jLvProducerIndex, j), supplier.get());
        }
        if (threadLvBlocked != null && lvBlocked() == threadLvBlocked) {
            LockSupport.unpark(threadLvBlocked);
        }
        return i2;
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer, int i, long j, TimeUnit timeUnit) throws InterruptedException {
        if (i == 0) {
            return 0;
        }
        int iDrain = drain(consumer, i);
        if (iDrain != 0) {
            return iDrain;
        }
        E ePoll = poll(j, timeUnit);
        if (ePoll == null) {
            return 0;
        }
        consumer.accept(ePoll);
        return drain(consumer, i - 1) + 1;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        return MessagePassingQueueUtil.drain(this, consumer, i);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }
}
