package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getContentSensitivity;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class getContentSensitivity extends wX26196 {
    private static int D8871 = 0;
    private static int component9 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private getContentSensitivity(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.setContentSensitivity.INSTANCE.component5(), str, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.getContentSensitivity$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/NetworkCountryIsoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/NetworkCountryIsoSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/telephony/NetworkCountryIsoResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public static int D8871 = 0;
        public static int component5 = 0;
        private static int component9 = 1;
        private static int setPivotYN16904;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static getContentSensitivity component9(D8871<String, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = component9;
            int i3 = (i2 ^ 37) + ((i2 & 37) << 1);
            setPivotYN16904 = i3 % 128;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (i3 % 2 != 0) {
                boolean z = d8871 instanceof vD14832N6715;
                throw null;
            }
            if (!(d8871 instanceof vD14832N6715)) {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new getContentSensitivity(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            }
            getContentSensitivity getcontentsensitivity = new getContentSensitivity((String) ((vD14832N6715) d8871).setPivotYN16904, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            int i4 = setPivotYN16904;
            int i5 = (i4 & 123) + (i4 | 123);
            component9 = i5 % 128;
            int i6 = i5 % 2;
            return getcontentsensitivity;
        }

        public static int component9() {
            int i = D8871;
            int i2 = i % 8788579;
            D8871 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            component5 = iFreeMemory;
            return iFreeMemory;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = D8871;
        int i2 = (i & 119) + (i | 119);
        component9 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ getContentSensitivity(String str, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, setpivotyn16904);
    }
}
