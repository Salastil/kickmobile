package org.jctools.queues.atomic;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;

/* JADX INFO: loaded from: classes11.dex */
public class AtomicQueueFactory {
    public static <E> Queue<E> newQueue(ConcurrentQueueSpec concurrentQueueSpec) {
        if (concurrentQueueSpec.isBounded()) {
            if (concurrentQueueSpec.isSpsc()) {
                return new SpscAtomicArrayQueue(concurrentQueueSpec.capacity);
            }
            if (concurrentQueueSpec.isMpsc()) {
                return new MpscAtomicArrayQueue(concurrentQueueSpec.capacity);
            }
            if (concurrentQueueSpec.isSpmc()) {
                return new SpmcAtomicArrayQueue(concurrentQueueSpec.capacity);
            }
            return new MpmcAtomicArrayQueue(concurrentQueueSpec.capacity);
        }
        if (concurrentQueueSpec.isSpsc()) {
            return new SpscLinkedAtomicQueue();
        }
        if (concurrentQueueSpec.isMpsc()) {
            return new MpscLinkedAtomicQueue();
        }
        return new ConcurrentLinkedQueue();
    }
}
