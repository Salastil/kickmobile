package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bm;", "", "<init>", "()V", "vD14832N6715", "component5", "Lcom/fingerprintjs/android/fpjs_pro_internal/bm$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bm$component5;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class bm {
    public static int D8871;
    public static int setPivotYN16904;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bm$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bm;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class vD14832N6715 extends bm {
        public static final vD14832N6715 INSTANCE = new vD14832N6715();

        private vD14832N6715() {
            super(null);
        }
    }

    private bm() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bm$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bm;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component5 extends bm {
        public static final component5 INSTANCE = new component5();

        private component5() {
            super(null);
        }
    }

    public static int D8871() {
        int i = setPivotYN16904;
        int i2 = i % 5019211;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        D8871 = elapsedCpuTime;
        return elapsedCpuTime;
    }

    public /* synthetic */ bm(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
