package org.jctools.queues;

/* JADX INFO: compiled from: BaseSpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class BaseSpscLinkedArrayQueueConsumerColdFields<E> extends BaseSpscLinkedArrayQueuePrePad<E> {
    protected E[] consumerBuffer;
    protected long consumerMask;

    BaseSpscLinkedArrayQueueConsumerColdFields() {
    }
}
