package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB-\b\u0002\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/openContextMenu;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/List;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class openContextMenu extends wX26196 {

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int setPivotYN16904 = 1;
    private static int vD14832N6715;

    private openContextMenu(List<? extends Map<String, ? extends Object>> list, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.setContentDescriptionR23122.INSTANCE.component5(), list, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.openContextMenu$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n¨\u0006\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/NetworkInterfacesSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/NetworkInterfacesSignal;", "networkInterfacesInfo", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/network_interface/NetworkInterfacesInfoProvider$NetworkInterfaceInfo;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/network_interface/NetworkInterfacesInfo;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public static int D8871 = 0;
        private static int component5 = 0;
        public static int setPivotYN16904 = 0;
        private static int vD14832N6715 = 1;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static openContextMenu component9(D8871<? extends List<wB2645.component5>, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = component5;
            int i3 = (i2 & 9) + (i2 | 9);
            vD14832N6715 = i3 % 128;
            int i4 = i3 % 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (!(d8871 instanceof vD14832N6715)) {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new openContextMenu(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            }
            List<wB2645.component5> list = (List) ((vD14832N6715) d8871).setPivotYN16904;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i5 = component5;
            int i6 = (i5 ^ 33) + ((i5 & 33) << 1);
            vD14832N6715 = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = 2 / 2;
            }
            for (wB2645.component5 component5Var : list) {
                int i8 = vD14832N6715;
                int i9 = ((i8 | 39) << 1) - (i8 ^ 39);
                component5 = i9 % 128;
                int i10 = i9 % 2;
                arrayList.add(MapsKt.mapOf(TuplesKt.to(I30900.be.INSTANCE.component5(), component5Var.component5()), TuplesKt.to(I30900.cy.INSTANCE.component5(), Boolean.valueOf(component5Var.D8871()))));
                int i11 = vD14832N6715;
                int i12 = (i11 & 93) + (i11 | 93);
                component5 = i12 % 128;
                int i13 = i12 % 2;
            }
            openContextMenu opencontextmenu = new openContextMenu(arrayList, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            int i14 = vD14832N6715;
            int i15 = (i14 & 103) + (i14 | 103);
            component5 = i15 % 128;
            int i16 = i15 % 2;
            return opencontextmenu;
        }

        public static int setPivotYN16904() {
            int i = setPivotYN16904;
            int i2 = i % 5420573;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return D8871;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            D8871 = i3;
            return i3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = setPivotYN16904;
        int i2 = (i ^ 93) + ((i & 93) << 1);
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ openContextMenu(List list, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, setpivotyn16904);
    }
}
