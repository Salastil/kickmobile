package org.jctools.util;

/* JADX INFO: compiled from: PaddedAtomicLong.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class PaddedAtomicLongL1Field extends PaddedAtomicLongL1Pad {
    private static final long VALUE_OFFSET = UnsafeAccess.fieldOffset(PaddedAtomicLongL1Field.class, "value");
    private volatile long value;

    PaddedAtomicLongL1Field() {
    }

    public void spVal(long j) {
        UnsafeAccess.UNSAFE.putLong(this, VALUE_OFFSET, j);
    }

    public void soVal(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, VALUE_OFFSET, j);
    }

    public void svVal(long j) {
        this.value = j;
    }

    public long lvVal() {
        return this.value;
    }

    public long lpVal() {
        return UnsafeAccess.UNSAFE.getLong(this, VALUE_OFFSET);
    }

    public boolean casVal(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, VALUE_OFFSET, j, j2);
    }

    public long getAndSetVal(long j) {
        long jLvVal;
        if (UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            return UnsafeAccess.UNSAFE.getAndSetLong(this, VALUE_OFFSET, j);
        }
        do {
            jLvVal = lvVal();
        } while (!casVal(jLvVal, j));
        return jLvVal;
    }

    public long getAndAddVal(long j) {
        long jLvVal;
        if (UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            return UnsafeAccess.UNSAFE.getAndAddLong(this, VALUE_OFFSET, j);
        }
        do {
            jLvVal = lvVal();
        } while (!casVal(jLvVal, jLvVal + j));
        return jLvVal;
    }
}
