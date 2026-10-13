package org.jctools.counters;

import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
class FixedSizeStripedLongCounterV8 extends FixedSizeStripedLongCounter {
    public FixedSizeStripedLongCounterV8(int i) {
        super(i);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected void inc(long[] jArr, long j, long j2) {
        UnsafeAccess.UNSAFE.getAndAddLong(jArr, j, j2);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected long getAndReset(long[] jArr, long j) {
        return UnsafeAccess.UNSAFE.getAndSetLong(jArr, j, 0L);
    }
}
