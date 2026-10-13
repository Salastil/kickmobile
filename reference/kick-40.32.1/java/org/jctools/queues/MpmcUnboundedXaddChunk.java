package org.jctools.queues;

import java.util.Arrays;
import org.jctools.util.UnsafeLongArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
final class MpmcUnboundedXaddChunk<E> extends MpUnboundedXaddChunk<MpmcUnboundedXaddChunk<E>, E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] sequence;

    MpmcUnboundedXaddChunk(long j, MpmcUnboundedXaddChunk<E> mpmcUnboundedXaddChunk, int i, boolean z) {
        super(j, mpmcUnboundedXaddChunk, i, z);
        if (z) {
            long[] jArrAllocateLongArray = UnsafeLongArrayAccess.allocateLongArray(i);
            this.sequence = jArrAllocateLongArray;
            Arrays.fill(jArrAllocateLongArray, -1L);
            return;
        }
        this.sequence = null;
    }

    void soSequence(int i, long j) {
        UnsafeLongArrayAccess.soLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset(i), j);
    }

    long lvSequence(int i) {
        return UnsafeLongArrayAccess.lvLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset(i));
    }

    void spinForSequence(int i, long j) {
        while (UnsafeLongArrayAccess.lvLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset(i)) != j) {
        }
    }
}
