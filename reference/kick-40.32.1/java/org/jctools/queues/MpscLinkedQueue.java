package org.jctools.queues;

import com.google.android.gms.internal.cast.zzwb$zzd$$ExternalSyntheticBackportWithForwarding0;
import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
public class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode();
        spConsumerNode(linkedQueueNodeNewNode);
        xchgProducerNode(linkedQueueNodeNewNode);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode(e);
        xchgProducerNode(linkedQueueNodeNewNode).soNext(linkedQueueNodeNewNode);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        LinkedQueueNode<E> linkedQueueNodeLpConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> nextConsumerNode = getNextConsumerNode(linkedQueueNodeLpConsumerNode);
        while (true) {
            LinkedQueueNode<E> linkedQueueNode = nextConsumerNode;
            LinkedQueueNode<E> linkedQueueNode2 = linkedQueueNodeLpConsumerNode;
            linkedQueueNodeLpConsumerNode = linkedQueueNode;
            if (linkedQueueNodeLpConsumerNode == null) {
                return false;
            }
            if (obj.equals(linkedQueueNodeLpConsumerNode.lpValue())) {
                LinkedQueueNode<E> nextConsumerNode2 = getNextConsumerNode(linkedQueueNodeLpConsumerNode);
                if (nextConsumerNode2 != null) {
                    linkedQueueNode2.soNext(nextConsumerNode2);
                } else {
                    linkedQueueNode2.soNext(null);
                    if (!casProducerNode(linkedQueueNodeLpConsumerNode, linkedQueueNode2)) {
                        linkedQueueNode2.soNext(spinWaitForNextNode(linkedQueueNodeLpConsumerNode));
                    }
                }
                linkedQueueNodeLpConsumerNode.soNext(null);
                linkedQueueNodeLpConsumerNode.spValue(null);
                return true;
            }
            nextConsumerNode = getNextConsumerNode(linkedQueueNodeLpConsumerNode);
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillUnbounded(this, supplier);
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
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode(supplier.get());
        int i2 = 1;
        LinkedQueueNode<E> linkedQueueNode = linkedQueueNodeNewNode;
        while (i2 < i) {
            LinkedQueueNode<E> linkedQueueNodeNewNode2 = newNode(supplier.get());
            linkedQueueNode.spNext(linkedQueueNodeNewNode2);
            i2++;
            linkedQueueNode = linkedQueueNodeNewNode2;
        }
        xchgProducerNode(linkedQueueNode).soNext(linkedQueueNodeNewNode);
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }

    private LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        if (UnsafeAccess.SUPPORTS_GET_AND_SET_REF) {
            return (LinkedQueueNode) UnsafeAccess.UNSAFE.getAndSetObject(this, P_NODE_OFFSET, linkedQueueNode);
        }
        while (true) {
            LinkedQueueNode<E> linkedQueueNodeLvProducerNode = this.lvProducerNode();
            MpscLinkedQueue<E> mpscLinkedQueue = this;
            LinkedQueueNode<E> linkedQueueNode2 = linkedQueueNode;
            if (zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(UnsafeAccess.UNSAFE, mpscLinkedQueue, P_NODE_OFFSET, linkedQueueNodeLvProducerNode, linkedQueueNode2)) {
                return linkedQueueNodeLvProducerNode;
            }
            this = mpscLinkedQueue;
            linkedQueueNode = linkedQueueNode2;
        }
    }

    private LinkedQueueNode<E> getNextConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNodeLvNext = linkedQueueNode.lvNext();
        return (linkedQueueNodeLvNext != null || linkedQueueNode == lvProducerNode()) ? linkedQueueNodeLvNext : spinWaitForNextNode(linkedQueueNode);
    }
}
