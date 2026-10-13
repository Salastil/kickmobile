package org.jctools.queues;

import java.util.Iterator;
import org.jctools.util.PortableJvmInfo;

/* JADX INFO: loaded from: classes11.dex */
public class MpscCompoundQueue<E> extends MpscCompoundQueueConsumerQueueIndex<E> {
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

    public MpscCompoundQueue(int i) {
        this(i, PortableJvmInfo.CPUs);
    }

    public MpscCompoundQueue(int i, int i2) {
        super(i, i2);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.parallelQueuesMask;
        int id = (int) (Thread.currentThread().getId() & ((long) i));
        MpscArrayQueue<E>[] mpscArrayQueueArr = this.queues;
        if (mpscArrayQueueArr[id].offer(e)) {
            return true;
        }
        return slowOffer(mpscArrayQueueArr, i, id + 1, e);
    }

    private boolean slowOffer(MpscArrayQueue<E>[] mpscArrayQueueArr, int i, int i2, E e) {
        int i3;
        int i4 = i + 1;
        int i5 = i2 + i4;
        do {
            i3 = 0;
            for (int i6 = i2; i6 < i5; i6++) {
                int iFailFastOffer = mpscArrayQueueArr[i6 & i].failFastOffer(e);
                if (iFailFastOffer == 0) {
                    return true;
                }
                i3 += iFailFastOffer;
            }
        } while (i3 != i4);
        return false;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        int i = this.consumerQueueIndex & this.parallelQueuesMask;
        int i2 = this.parallelQueues + i;
        E ePoll = null;
        while (i < i2) {
            ePoll = this.queues[this.parallelQueuesMask & i].poll();
            if (ePoll != null) {
                break;
            }
            i++;
        }
        this.consumerQueueIndex = i;
        return ePoll;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        int i = this.consumerQueueIndex & this.parallelQueuesMask;
        int i2 = this.parallelQueues + i;
        E ePeek = null;
        while (i < i2) {
            ePeek = this.queues[this.parallelQueuesMask & i].peek();
            if (ePeek != null) {
                break;
            }
            i++;
        }
        this.consumerQueueIndex = i;
        return ePeek;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public int size() {
        int size = 0;
        for (MpscArrayQueue<E> mpscArrayQueue : this.queues) {
            size += mpscArrayQueue.size();
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.parallelQueuesMask;
        int id = (int) (Thread.currentThread().getId() & ((long) i));
        MpscArrayQueue<E>[] mpscArrayQueueArr = this.queues;
        if (mpscArrayQueueArr[id].failFastOffer(e) == 0) {
            return true;
        }
        for (int i2 = id + 1; i2 < id + i + 1; i2++) {
            if (mpscArrayQueueArr[i2 & i].failFastOffer(e) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        int i = this.consumerQueueIndex & this.parallelQueuesMask;
        int i2 = this.parallelQueues + i;
        E eRelaxedPoll = null;
        while (i < i2) {
            eRelaxedPoll = this.queues[this.parallelQueuesMask & i].relaxedPoll();
            if (eRelaxedPoll != null) {
                break;
            }
            i++;
        }
        this.consumerQueueIndex = i;
        return eRelaxedPoll;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        int i = this.consumerQueueIndex & this.parallelQueuesMask;
        int i2 = this.parallelQueues + i;
        E eRelaxedPeek = null;
        while (i < i2) {
            eRelaxedPeek = this.queues[this.parallelQueuesMask & i].relaxedPeek();
            if (eRelaxedPeek != null) {
                break;
            }
            i++;
        }
        this.consumerQueueIndex = i;
        return eRelaxedPeek;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.queues.length * this.queues[0].capacity();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        return MessagePassingQueueUtil.drain(this, consumer, i);
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
        int i2 = this.parallelQueuesMask;
        int id = (int) (Thread.currentThread().getId() & ((long) i2));
        MpscArrayQueue<E>[] mpscArrayQueueArr = this.queues;
        int iFill = mpscArrayQueueArr[id].fill(supplier, i);
        if (iFill != i) {
            for (int i3 = id + 1; i3 < id + i2 + 1; i3++) {
                iFill += mpscArrayQueueArr[i3 & i2].fill(supplier, i - iFill);
                if (iFill != i) {
                }
            }
            return iFill;
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
