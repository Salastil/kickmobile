package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class C1722 {
    private final an D8871;
    private final String component5;
    private final jC6584 setPivotYN16904;

    public C1722(an anVar, String str, jC6584 jc6584) {
        this.D8871 = anVar;
        this.component5 = str;
        this.setPivotYN16904 = jc6584;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/C1722$vD14832N6715;", "", "<init>", "()V", "component5", "Lcom/fingerprintjs/android/fpjs_pro_internal/C1722$vD14832N6715$component5;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class vD14832N6715 {
        private vD14832N6715() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/C1722$vD14832N6715$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/C1722$vD14832N6715;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component5 extends vD14832N6715 {
            public static final component5 INSTANCE = new component5();

            private component5() {
                super(null);
            }
        }

        public /* synthetic */ vD14832N6715(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized D8871<Unit, Throwable> D8871(List<K5264> list) {
        D8871 d8871VD14832N6715 = this.setPivotYN16904.vD14832N6715(list);
        if (d8871VD14832N6715 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) {
            return this.D8871.vD14832N6715((byte[]) ((com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) d8871VD14832N6715).setPivotYN16904, this.component5);
        }
        if (d8871VD14832N6715 instanceof setPivotYN16904) {
            return d8871VD14832N6715;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized D8871<List<K5264>, vD14832N6715> setPivotYN16904() {
        D8871<byte[], an.component9> D8871 = this.D8871.D8871(this.component5);
        if (D8871 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) {
            D8871 d8871VD14832N6715 = this.setPivotYN16904.vD14832N6715((byte[]) ((com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) D8871).setPivotYN16904);
            if (d8871VD14832N6715 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) {
                return d8871VD14832N6715;
            }
            if (!(d8871VD14832N6715 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            return new setPivotYN16904(vD14832N6715.component5.INSTANCE);
        }
        if (D8871 instanceof setPivotYN16904) {
            an.component9 component9Var = (an.component9) ((setPivotYN16904) D8871).setPivotYN16904;
            if (Intrinsics.areEqual(component9Var, an.component9.component5.INSTANCE)) {
                return new com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715(CollectionsKt.emptyList());
            }
            if (!Intrinsics.areEqual(component9Var, an.component9.C0111component9.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return new setPivotYN16904(vD14832N6715.component5.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
