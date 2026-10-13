package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: BaseSpscLinkedAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> extends BaseSpscLinkedAtomicArrayQueueProducerFields<E> {
    protected AtomicReferenceArray<E> producerBuffer;
    protected long producerBufferLimit;
    protected long producerMask;

    BaseSpscLinkedAtomicArrayQueueProducerColdFields() {
    }
}
