package org.jctools.queues;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import org.jctools.util.UnsafeAccess;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
class MpUnboundedXaddChunk<R, E> {
    static final int NOT_USED = -1;
    private final E[] buffer;
    private volatile long index;
    private volatile R next;
    private final boolean pooled;
    private volatile R prev;
    private static final long PREV_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, "prev");
    private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, LinkHeader.Rel.Next);
    private static final long INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, FirebaseAnalytics.Param.INDEX);

    MpUnboundedXaddChunk(long j, R r, int i, boolean z) {
        this.buffer = (E[]) UnsafeRefArrayAccess.allocateRefArray(i);
        soPrev(r);
        spIndex(j);
        this.pooled = z;
    }

    final boolean isPooled() {
        return this.pooled;
    }

    final long lvIndex() {
        return this.index;
    }

    final void soIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, INDEX_OFFSET, j);
    }

    final void spIndex(long j) {
        UnsafeAccess.UNSAFE.putLong(this, INDEX_OFFSET, j);
    }

    final R lvNext() {
        return this.next;
    }

    final void soNext(R r) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, r);
    }

    final R lvPrev() {
        return this.prev;
    }

    final void soPrev(R r) {
        UnsafeAccess.UNSAFE.putObject(this, PREV_OFFSET, r);
    }

    final void soElement(int i, E e) {
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcRefElementOffset(i), e);
    }

    final E lvElement(int i) {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcRefElementOffset(i));
    }

    final E spinForElement(int i, boolean z) {
        E e;
        E[] eArr = this.buffer;
        long jCalcRefElementOffset = UnsafeRefArrayAccess.calcRefElementOffset(i);
        do {
            e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jCalcRefElementOffset);
        } while (z != (e == null));
        return e;
    }
}
