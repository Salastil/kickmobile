package org.jctools.counters;

import org.jctools.util.PortableJvmInfo;
import org.jctools.util.Pow2;
import org.jctools.util.UnsafeAccess;

/* JADX INFO: compiled from: FixedSizeStripedLongCounter.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class FixedSizeStripedLongCounterFields extends FixedSizeStripedLongCounterPrePad {
    protected static final int CACHE_LINE_IN_LONGS = PortableJvmInfo.CACHE_LINE_SIZE / 8;
    protected static final long COUNTER_ARRAY_BASE = Math.max(UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class), PortableJvmInfo.CACHE_LINE_SIZE - 8);
    protected static final long ELEMENT_SHIFT = Integer.numberOfTrailingZeros(PortableJvmInfo.CACHE_LINE_SIZE);
    protected final long[] cells;
    protected final int mask;

    protected FixedSizeStripedLongCounterFields(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Expecting a stripesCount that is larger than 0");
        }
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.cells = new long[CACHE_LINE_IN_LONGS * iRoundToPowerOfTwo];
        this.mask = iRoundToPowerOfTwo - 1;
    }
}
