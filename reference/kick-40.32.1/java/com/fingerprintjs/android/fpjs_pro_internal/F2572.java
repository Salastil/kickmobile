package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.compose.runtime.GapComposerKt;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/F2572;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "p0", "<init>", "(Ljava/util/List;)V", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class F2572 extends wX26196 {
    private static int D8871 = 0;
    private static int component5 = 1;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private F2572(List<Integer> list) {
        super(I30900.tR25644.INSTANCE.component5(), list, wX26196.setPivotYN16904.component13.INSTANCE);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.F2572$vD14832N6715, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¨\u0006\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LocationPermissionsSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LocationPermissionsSignal;", "locationPermissionsCheckResult", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LocationPermission;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LocationPermissionsCheckResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component9 = 1;
        private static int setPivotYN16904;

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0052  */
        /* JADX WARN: Code duplicated, block: B:15:0x005f A[PHI: r2
          0x005f: PHI (r2v23 com.fingerprintjs.android.fpjs_pro_internal.setOnContextClickListenerE32038) = 
          (r2v14 com.fingerprintjs.android.fpjs_pro_internal.setOnContextClickListenerE32038)
          (r2v29 com.fingerprintjs.android.fpjs_pro_internal.setOnContextClickListenerE32038)
         binds: [B:11:0x0050, B:8:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:17:0x0067  */
        /* JADX WARN: Code duplicated, block: B:24:0x008a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x0075 A[SYNTHETIC] */
        public static F2572 vD14832N6715(List<? extends setOnContextClickListenerE32038> list) {
            setOnContextClickListenerE32038 setoncontextclicklistenere32038;
            int i;
            int i2 = 2 % 2;
            List<? extends setOnContextClickListenerE32038> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            int i3 = setPivotYN16904 + 13;
            component9 = i3 % 128;
            int i4 = i3 % 2;
            while (it.hasNext()) {
                int i5 = setPivotYN16904 + 121;
                component9 = i5 % 128;
                int i6 = 0;
                if (i5 % 2 == 0) {
                    setoncontextclicklistenere32038 = (setOnContextClickListenerE32038) it.next();
                    int i7 = 57 / 0;
                    if (Intrinsics.areEqual(setoncontextclicklistenere32038, setOnContextClickListenerE32038.D8871.INSTANCE)) {
                        i = component9 + 77;
                        setPivotYN16904 = i % 128;
                        if (i % 2 != 0) {
                        }
                    } else {
                        if (Intrinsics.areEqual(setoncontextclicklistenere32038, setOnContextClickListenerE32038.setPivotYN16904.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        int i8 = component9;
                        int i9 = ((i8 | 49) << 1) - (i8 ^ 49);
                        setPivotYN16904 = i9 % 128;
                        int i10 = i9 % 2;
                    }
                    i6 = 1;
                } else {
                    setoncontextclicklistenere32038 = (setOnContextClickListenerE32038) it.next();
                    if (Intrinsics.areEqual(setoncontextclicklistenere32038, setOnContextClickListenerE32038.D8871.INSTANCE)) {
                        i = component9 + 77;
                        setPivotYN16904 = i % 128;
                        if (i % 2 != 0) {
                        }
                    } else {
                        if (Intrinsics.areEqual(setoncontextclicklistenere32038, setOnContextClickListenerE32038.setPivotYN16904.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        int i11 = component9;
                        int i12 = ((i11 | 49) << 1) - (i11 ^ 49);
                        setPivotYN16904 = i12 % 128;
                        int i13 = i12 % 2;
                    }
                    i6 = 1;
                }
                arrayList.add(Integer.valueOf(i6));
                int i14 = component9;
                int i15 = (i14 ^ 67) + ((i14 & 67) << 1);
                setPivotYN16904 = i15 % 128;
                int i16 = i15 % 2;
            }
            F2572 f2572 = new F2572(arrayList, null);
            int i17 = setPivotYN16904;
            int i18 = (i17 & 123) + (i17 | 123);
            component9 = i18 % 128;
            int i19 = i18 % 2;
            return f2572;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = D8871 + GapComposerKt.nodeKey;
        component5 = i % 128;
        int i2 = i % 2;
    }

    public /* synthetic */ F2572(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
