package org.jctools.counters;

import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
class FixedSizeStripedLongCounterV6 extends FixedSizeStripedLongCounter {
    public FixedSizeStripedLongCounterV6(int i) {
        super(i);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected void inc(long[] jArr, long j, long j2) {
        while (true) {
            long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(jArr, j);
            long[] jArr2 = jArr;
            long j3 = j;
            if (UnsafeAccess.UNSAFE.compareAndSwapLong(jArr2, j3, longVolatile, longVolatile + j2)) {
                return;
            }
            jArr = jArr2;
            j = j3;
        }
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected long getAndReset(long[] jArr, long j) {
        while (true) {
            long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(jArr, j);
            long[] jArr2 = jArr;
            long j2 = j;
            if (UnsafeAccess.UNSAFE.compareAndSwapLong(jArr2, j2, longVolatile, 0L)) {
                return longVolatile;
            }
            jArr = jArr2;
            j = j2;
        }
    }
}
