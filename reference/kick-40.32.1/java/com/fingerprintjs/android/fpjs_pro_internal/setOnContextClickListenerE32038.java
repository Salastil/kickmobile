package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038;", "", "<init>", "()V", "D8871", "setPivotYN16904", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038$setPivotYN16904;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class setOnContextClickListenerE32038 {
    public static int D8871;
    public static int vD14832N6715;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038$setPivotYN16904;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class setPivotYN16904 extends setOnContextClickListenerE32038 {
        public static final setPivotYN16904 INSTANCE = new setPivotYN16904();

        private setPivotYN16904() {
            super(null);
        }

        static {
            getContextMenuInfo.AnonymousClass5.D8871();
            getContextMenuInfo.AnonymousClass5.D8871();
        }
    }

    private setOnContextClickListenerE32038() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class D8871 extends setOnContextClickListenerE32038 {
        public static final D8871 INSTANCE = new D8871();
        private static int component9 = 1;
        private static int setPivotYN16904;

        private D8871() {
            super(null);
        }

        static {
            int i = setPivotYN16904;
            int i2 = ((i | 57) << 1) - (i ^ 57);
            component9 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }
    }

    public static int component9() {
        int i = vD14832N6715;
        int i2 = i % 9701622;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        D8871 = iMaxMemory;
        return iMaxMemory;
    }

    public /* synthetic */ setOnContextClickListenerE32038(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
