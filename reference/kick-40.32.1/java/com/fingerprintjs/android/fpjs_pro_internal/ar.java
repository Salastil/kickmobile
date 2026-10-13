package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes6.dex */
public final class ar<T> implements aq<T> {
    public static int component5;
    public static int component9;
    private volatile T D8871;
    private final CountDownLatch setPivotYN16904 = new CountDownLatch(1);
    private final setKeepScreenOnI3248 vD14832N6715 = new setKeepScreenOnI3248();

    public final T component5(Long l) throws InterruptedException {
        this.setPivotYN16904.await();
        if (this.setPivotYN16904.getCount() != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return this.D8871;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.aq
    public final void vD14832N6715(T t) {
        if (this.setPivotYN16904.getCount() == 0) {
            return;
        }
        this.D8871 = t;
        this.setPivotYN16904.countDown();
    }

    public static int component9() {
        int i = component5;
        int i2 = i % 6549364;
        component5 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        component9 = iFreeMemory;
        return iFreeMemory;
    }
}
