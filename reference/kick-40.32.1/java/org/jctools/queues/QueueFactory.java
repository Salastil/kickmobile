package org.jctools.queues;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public class QueueFactory {
    public static <E> Queue<E> newQueue(ConcurrentQueueSpec concurrentQueueSpec) {
        if (concurrentQueueSpec.isBounded()) {
            if (concurrentQueueSpec.isSpsc()) {
                return new SpscArrayQueue(concurrentQueueSpec.capacity);
            }
            if (concurrentQueueSpec.isMpsc()) {
                if (concurrentQueueSpec.ordering != Ordering.NONE) {
                    return new MpscArrayQueue(concurrentQueueSpec.capacity);
                }
                return new MpscCompoundQueue(concurrentQueueSpec.capacity);
            }
            if (concurrentQueueSpec.isSpmc()) {
                return new SpmcArrayQueue(concurrentQueueSpec.capacity);
            }
            return new MpmcArrayQueue(concurrentQueueSpec.capacity);
        }
        if (concurrentQueueSpec.isSpsc()) {
            return new SpscLinkedQueue();
        }
        if (concurrentQueueSpec.isMpsc()) {
            return new MpscLinkedQueue();
        }
        return new ConcurrentLinkedQueue();
    }
}
