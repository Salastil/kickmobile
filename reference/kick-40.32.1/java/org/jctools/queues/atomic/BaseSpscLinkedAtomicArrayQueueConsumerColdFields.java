package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: BaseSpscLinkedAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class BaseSpscLinkedAtomicArrayQueueConsumerColdFields<E> extends BaseSpscLinkedAtomicArrayQueuePrePad<E> {
    protected AtomicReferenceArray<E> consumerBuffer;
    protected long consumerMask;

    BaseSpscLinkedAtomicArrayQueueConsumerColdFields() {
    }
}
