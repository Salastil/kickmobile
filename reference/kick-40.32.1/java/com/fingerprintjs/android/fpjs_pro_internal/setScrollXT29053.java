package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setScrollXT29053;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/Boolean;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class setScrollXT29053 extends wX26196 {
    private static int component5 = 0;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715 = 1;

    private setScrollXT29053(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.getExplicitStyle.INSTANCE.component5(), bool, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setScrollXT29053$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/IsVpnNetworkPresentSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/IsVpnNetworkPresentSignal;", "isNetworkWithVpnPresent", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/vpn/VpnInfoProvider$IsNetworkWithVpnPresentError;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/vpn/IsNetworkWithVpnPresent;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static setScrollXT29053 component5(D8871<Boolean, ? extends ak.component9> d8871) {
            wX26196.setPivotYN16904.vD14832N6715 vd14832n6715;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (d8871 instanceof vD14832N6715) {
                Boolean bool = (Boolean) ((vD14832N6715) d8871).setPivotYN16904;
                bool.booleanValue();
                return new setScrollXT29053(bool, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            }
            if (d8871 instanceof setPivotYN16904) {
                ak.component9 component9Var = (ak.component9) ((setPivotYN16904) d8871).setPivotYN16904;
                if (Intrinsics.areEqual(component9Var, ak.component9.component5.INSTANCE)) {
                    vd14832n6715 = wX26196.setPivotYN16904.component5.INSTANCE;
                } else {
                    if (!Intrinsics.areEqual(component9Var, ak.component9.D8871.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    vd14832n6715 = wX26196.setPivotYN16904.vD14832N6715.INSTANCE;
                }
                return new setScrollXT29053(objArr2 == true ? 1 : 0, vd14832n6715, objArr == true ? 1 : 0);
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = vD14832N6715;
        int i2 = (i ^ 107) + ((i & 107) << 1);
        component5 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ setScrollXT29053(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, setpivotyn16904);
    }
}
