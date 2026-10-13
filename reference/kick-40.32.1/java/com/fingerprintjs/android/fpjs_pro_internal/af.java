package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/af;", "", "<init>", "()V", "D8871", "setPivotYN16904", "component9", "component5", "Lcom/fingerprintjs/android/fpjs_pro_internal/af$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af$setPivotYN16904;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af$component5;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class af {
    private af() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/af$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component9 extends af {
        public static final component9 INSTANCE = new component9();
        private static int component5 = 1;
        private static int setPivotYN16904;

        private component9() {
            super(null);
        }

        static {
            int i = setPivotYN16904;
            int i2 = (i ^ 97) + ((i & 97) << 1);
            component5 = i2 % 128;
            if (i2 % 2 != 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/af$setPivotYN16904;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class setPivotYN16904 extends af {
        private static int D8871 = 1;
        public static final setPivotYN16904 INSTANCE = new setPivotYN16904();
        private static int component9;

        private setPivotYN16904() {
            super(null);
        }

        static {
            int i = D8871;
            int i2 = (i & 45) + (i | 45);
            component9 = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 81 / 0;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/af$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class D8871 extends af {
        public static final D8871 INSTANCE = new D8871();
        private static int component9 = 0;
        private static int setPivotYN16904 = 1;

        private D8871() {
            super(null);
        }

        static {
            int i = setPivotYN16904;
            int i2 = ((i | 13) << 1) - (i ^ 13);
            component9 = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/af$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/af;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component5 extends af {
        private static int D8871 = 0;
        public static final component5 INSTANCE = new component5();
        private static int component9 = 1;

        private component5() {
            super(null);
        }

        static {
            int i = D8871;
            int i2 = (i ^ 25) + ((i & 25) << 1);
            component9 = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    public /* synthetic */ af(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
