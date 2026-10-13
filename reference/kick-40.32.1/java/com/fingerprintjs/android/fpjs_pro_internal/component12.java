package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component12;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/Integer;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class component12 extends wX26196 {
    private static int component9 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715;

    private component12(Integer num, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component3H22396.INSTANCE.component5(), num, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component12$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/DataStateSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/DataStateSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/telephony/DataState;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/telephony/DataStateResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int D8871 = 0;
        private static int vD14832N6715 = 1;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static component12 vD14832N6715(D8871<? extends ac, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = D8871;
            int i3 = (i2 ^ 13) + ((i2 & 13) << 1);
            vD14832N6715 = i3 % 128;
            Object obj = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i3 % 2 == 0) {
                boolean z = d8871 instanceof vD14832N6715;
                obj.hashCode();
                throw null;
            }
            if (d8871 instanceof vD14832N6715) {
                component12 component12Var = new component12(Integer.valueOf(oD4563.component5((ac) ((vD14832N6715) d8871).setPivotYN16904)), wX26196.setPivotYN16904.component13.INSTANCE, objArr3 == true ? 1 : 0);
                int i4 = D8871;
                int i5 = (i4 & 23) + (i4 | 23);
                vD14832N6715 = i5 % 128;
                int i6 = i5 % 2;
                return component12Var;
            }
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            component12 component12Var2 = new component12(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            int i7 = vD14832N6715 + 79;
            D8871 = i7 % 128;
            if (i7 % 2 != 0) {
                int i8 = 16 / 0;
            }
            return component12Var2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component9;
        int i2 = (i ^ 19) + ((i & 19) << 1);
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ component12(Integer num, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, setpivotyn16904);
    }
}
