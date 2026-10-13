package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public interface an {
    D8871<byte[], component9> D8871(String str);

    D8871<Unit, Throwable> vD14832N6715(byte[] bArr, String str);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9;", "", "<init>", "()V", "component5", "component9", "Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9$component9;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class component9 {
        public static int component5;
        public static int vD14832N6715;

        private component9() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component5 extends component9 {
            public static final component5 INSTANCE = new component5();

            private component5() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.an$component9$component9, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class C0111component9 extends component9 {
            public static final C0111component9 INSTANCE = new C0111component9();

            private C0111component9() {
                super(null);
            }
        }

        public static int vD14832N6715() {
            int i = vD14832N6715;
            int i2 = i % 7920926;
            vD14832N6715 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            component5 = iFreeMemory;
            return iFreeMemory;
        }

        public /* synthetic */ component9(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
