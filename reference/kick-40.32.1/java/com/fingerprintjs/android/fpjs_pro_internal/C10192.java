package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB'\b\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/C10192;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/Map;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class C10192 extends wX26196 {
    private static int component5 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715;

    private C10192(Map<String, Integer> map, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.A29214.INSTANCE.component5(), map, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.C10192$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042&\u0010\u0005\u001a\"\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f¨\u0006\r"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/RequestedPermissionsSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/RequestedPermissionsSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/requested_permisssions/RequestedPermissions;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/requested_permisssions/RequestedPermissionsResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component9 = 0;
        private static int setPivotYN16904 = 1;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static C10192 vD14832N6715(D8871<? extends Map<String, Integer>, Unit> d8871) {
            int i = 2 % 2;
            int i2 = component9;
            int i3 = (i2 ^ 53) + ((i2 & 53) << 1);
            setPivotYN16904 = i3 % 128;
            int i4 = i3 % 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (d8871 instanceof vD14832N6715) {
                return new C10192((Map) ((vD14832N6715) d8871).setPivotYN16904, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            }
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            C10192 c10192 = new C10192(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            int i5 = setPivotYN16904 + 97;
            component9 = i5 % 128;
            int i6 = i5 % 2;
            return c10192;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component5 + 81;
        vD14832N6715 = i % 128;
        int i2 = i % 2;
    }

    public /* synthetic */ C10192(Map map, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, setpivotyn16904);
    }
}
