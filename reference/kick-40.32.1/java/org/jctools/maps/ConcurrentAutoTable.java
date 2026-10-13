package org.jctools.maps;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jctools.util.UnsafeAccess;

/* JADX INFO: loaded from: classes11.dex */
public class ConcurrentAutoTable implements Serializable {
    private static AtomicReferenceFieldUpdater<ConcurrentAutoTable, CAT> _catUpdater = AtomicReferenceFieldUpdater.newUpdater(ConcurrentAutoTable.class, CAT.class, "_cat");
    private volatile CAT _cat = new CAT(null, 16, 0);

    public void add(long j) {
        add_if(j);
    }

    public void decrement() {
        add_if(-1L);
    }

    public void increment() {
        add_if(1L);
    }

    public void set(long j) {
        while (!CAS_cat(this._cat, new CAT(null, 4, j))) {
        }
    }

    public long get() {
        return this._cat.sum();
    }

    public int intValue() {
        return (int) this._cat.sum();
    }

    public long longValue() {
        return this._cat.sum();
    }

    public long estimate_get() {
        return this._cat.estimate_sum();
    }

    public String toString() {
        return this._cat.toString();
    }

    public void print() {
        this._cat.print();
    }

    public int internal_size() {
        return this._cat._t.length;
    }

    private long add_if(long j) {
        return this._cat.add_if(j, hash(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean CAS_cat(CAT cat, CAT cat2) {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_catUpdater, this, cat, cat2);
    }

    private static int hash() {
        return System.identityHashCode(Thread.currentThread()) << 3;
    }

    private static class CAT implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MAX_SPIN = 1;
        private static final int _Lbase = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class);
        private static final int _Lscale = UnsafeAccess.UNSAFE.arrayIndexScale(long[].class);
        private volatile long _fuzzy_sum_cache;
        private volatile long _fuzzy_time;
        private final CAT _next;
        private final long[] _t;

        private static long rawIndex(long[] jArr, int i) {
            return ((long) _Lbase) + (((long) i) * ((long) _Lscale));
        }

        private static boolean CAS(long[] jArr, int i, long j, long j2) {
            return UnsafeAccess.UNSAFE.compareAndSwapLong(jArr, rawIndex(jArr, i), j, j2);
        }

        CAT(CAT cat, int i, long j) {
            this._next = cat;
            long[] jArr = new long[i];
            this._t = jArr;
            jArr[0] = j;
        }

        public long add_if(long j, int i, ConcurrentAutoTable concurrentAutoTable) {
            long j2;
            long[] jArr = this._t;
            int length = (jArr.length - 1) & i;
            long j3 = jArr[length];
            if (CAS(jArr, length, j3, j3 + j)) {
                return j3;
            }
            int i2 = 0;
            while (true) {
                j2 = jArr[length];
                if (CAS(jArr, length, j2, j2 + j)) {
                    break;
                }
                i2++;
            }
            if (i2 >= 1 && jArr.length < 1048576 && concurrentAutoTable._cat == this) {
                CAT cat = new CAT(this, jArr.length * 2, 0L);
                while (concurrentAutoTable._cat == this && !concurrentAutoTable.CAS_cat(this, cat)) {
                }
            }
            return j2;
        }

        public long sum() {
            CAT cat = this._next;
            long jSum = cat == null ? 0L : cat.sum();
            for (long j : this._t) {
                jSum += j;
            }
            return jSum;
        }

        public long estimate_sum() {
            if (this._t.length <= 64) {
                return sum();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this._fuzzy_time != jCurrentTimeMillis) {
                this._fuzzy_sum_cache = sum();
                this._fuzzy_time = jCurrentTimeMillis;
            }
            return this._fuzzy_sum_cache;
        }

        public String toString() {
            return Long.toString(sum());
        }

        public void print() {
            long[] jArr = this._t;
            System.out.print("[" + jArr[0]);
            for (int i = 1; i < jArr.length; i++) {
                System.out.print(WebViewLogEventConsumer.DDTAGS_SEPARATOR + jArr[i]);
            }
            System.out.print("]");
            CAT cat = this._next;
            if (cat != null) {
                cat.print();
            }
        }
    }
}
