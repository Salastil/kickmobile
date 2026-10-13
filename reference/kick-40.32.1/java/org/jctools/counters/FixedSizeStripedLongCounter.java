package org.jctools.counters;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.ThreadLocalRandom;
import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
public abstract class FixedSizeStripedLongCounter extends FixedSizeStripedLongCounterFields implements Counter {
    private static final long PROBE = getProbeOffset();
    byte b000;
    byte b001;
    byte b002;
    byte b003;
    byte b004;
    byte b005;
    byte b006;
    byte b007;
    byte b010;
    byte b011;
    byte b012;
    byte b013;
    byte b014;
    byte b015;
    byte b016;
    byte b017;
    byte b020;
    byte b021;
    byte b022;
    byte b023;
    byte b024;
    byte b025;
    byte b026;
    byte b027;
    byte b030;
    byte b031;
    byte b032;
    byte b033;
    byte b034;
    byte b035;
    byte b036;
    byte b037;
    byte b040;
    byte b041;
    byte b042;
    byte b043;
    byte b044;
    byte b045;
    byte b046;
    byte b047;
    byte b050;
    byte b051;
    byte b052;
    byte b053;
    byte b054;
    byte b055;
    byte b056;
    byte b057;
    byte b060;
    byte b061;
    byte b062;
    byte b063;
    byte b064;
    byte b065;
    byte b066;
    byte b067;
    byte b070;
    byte b071;
    byte b072;
    byte b073;
    byte b074;
    byte b075;
    byte b076;
    byte b077;
    byte b100;
    byte b101;
    byte b102;
    byte b103;
    byte b104;
    byte b105;
    byte b106;
    byte b107;
    byte b110;
    byte b111;
    byte b112;
    byte b113;
    byte b114;
    byte b115;
    byte b116;
    byte b117;
    byte b120;
    byte b121;
    byte b122;
    byte b123;
    byte b124;
    byte b125;
    byte b126;
    byte b127;
    byte b130;
    byte b131;
    byte b132;
    byte b133;
    byte b134;
    byte b135;
    byte b136;
    byte b137;
    byte b140;
    byte b141;
    byte b142;
    byte b143;
    byte b144;
    byte b145;
    byte b146;
    byte b147;
    byte b150;
    byte b151;
    byte b152;
    byte b153;
    byte b154;
    byte b155;
    byte b156;
    byte b157;
    byte b160;
    byte b161;
    byte b162;
    byte b163;
    byte b164;
    byte b165;
    byte b166;
    byte b167;

    protected abstract long getAndReset(long[] jArr, long j);

    protected abstract void inc(long[] jArr, long j, long j2);

    private static long getProbeOffset() {
        try {
            return UnsafeAccess.UNSAFE.objectFieldOffset(Thread.class.getDeclaredField("threadLocalRandomProbe"));
        } catch (NoSuchFieldException unused) {
            return -1L;
        }
    }

    public FixedSizeStripedLongCounter(int i) {
        super(i);
    }

    @Override // org.jctools.counters.Counter
    public void inc() {
        inc(1L);
    }

    @Override // org.jctools.counters.Counter
    public void inc(long j) {
        inc(this.cells, counterOffset(index()), j);
    }

    @Override // org.jctools.counters.Counter
    public long get() {
        long[] jArr = this.cells;
        int i = this.mask + 1;
        long longVolatile = 0;
        for (int i2 = 0; i2 < i; i2++) {
            longVolatile += UnsafeAccess.UNSAFE.getLongVolatile(jArr, counterOffset(i2));
        }
        return longVolatile;
    }

    private long counterOffset(long j) {
        return COUNTER_ARRAY_BASE + (j << ((int) ELEMENT_SHIFT));
    }

    @Override // org.jctools.counters.Counter
    public long getAndReset() {
        long[] jArr = this.cells;
        int i = this.mask + 1;
        long andReset = 0;
        for (int i2 = 0; i2 < i; i2++) {
            andReset += getAndReset(jArr, counterOffset(i2));
        }
        return andReset;
    }

    private int index() {
        return this.mask & probe();
    }

    private int probe() {
        long j = PROBE;
        if (j != -1) {
            int i = UnsafeAccess.UNSAFE.getInt(Thread.currentThread(), j);
            if (i != 0) {
                return i;
            }
            ThreadLocalRandom.current();
            return UnsafeAccess.UNSAFE.getInt(Thread.currentThread(), j);
        }
        int id = (int) ((Thread.currentThread().getId() * (-1640531527)) & SieveCacheKt.NodeLinkMask);
        int i2 = id ^ (id << 13);
        int i3 = i2 ^ (i2 >>> 17);
        return i3 ^ (i3 << 5);
    }
}
