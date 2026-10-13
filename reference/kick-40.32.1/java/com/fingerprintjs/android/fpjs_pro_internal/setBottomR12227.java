package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015BA\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\t\u001a\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0002HÇ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0011\u0010\u0012R,\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R2\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "", "", "Lkotlin/Pair;", "", "p0", "p1", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "vD14832N6715", "(Ljava/util/List;Ljava/util/List;)Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "component9", "Ljava/util/List;", "setPivotYN16904", "()Ljava/util/List;", "D8871", "component5"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class setBottomR12227 {
    private static final setBottomR12227 D8871 = new setBottomR12227(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    private static int component13 = 0;
    private static int sG29839 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int setTopP6481 = 1;
    private static int vD14832N6715;

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    private final List<List<Pair<String, String>>> vD14832N6715;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    private final List<Pair<String, String>> D8871;

    /* JADX WARN: Multi-variable type inference failed */
    public setBottomR12227(List<Pair<String, String>> list, List<? extends List<Pair<String, String>>> list2) {
        this.D8871 = list;
        this.vD14832N6715 = list2;
    }

    public final List<List<Pair<String, String>>> D8871() {
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 & 19) + (i2 | 19);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        List<List<Pair<String, String>>> list = this.vD14832N6715;
        int i5 = i2 + 111;
        vD14832N6715 = i5 % 128;
        int i6 = i5 % 2;
        return list;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setBottomR12227$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227$setPivotYN16904;", "", "<init>", "()V", "Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "D8871", "Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "setPivotYN16904", "()Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component5 = 0;
        private static int component9 = 1;

        private Companion() {
        }

        public static setBottomR12227 setPivotYN16904() {
            int i = 2 % 2;
            int i2 = component5 + 73;
            component9 = i2 % 128;
            int i3 = i2 % 2;
            int iComponent9 = P28427.AnonymousClass4.component9();
            setBottomR12227 setbottomr12227 = (setBottomR12227) setBottomR12227.vD14832N6715(new Object[0], -1243981748, 1243981749, P28427.AnonymousClass4.component9(), iComponent9, P28427.AnonymousClass4.component9(), P28427.AnonymousClass4.component9());
            int i4 = component5 + 89;
            component9 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 42 / 0;
            }
            return setbottomr12227;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = component13;
        int i2 = (i & 85) + (i | 85);
        sG29839 = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        defaultConstructorMarker.hashCode();
        throw null;
    }

    public static /* synthetic */ Object vD14832N6715(Object[] objArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int iHashCode;
        int i8 = ~i2;
        int i9 = ~i;
        int i10 = ~(i8 | i9 | i4);
        int i11 = ~i4;
        int i12 = i10 | (~(i8 | i11 | i));
        int i13 = (~(i4 | i9)) | i8 | (~(i11 | i));
        int i14 = i2 + i + i3 + (1112421973 * i6) + ((-1897213938) * i5);
        int i15 = i14 * i14;
        int i16 = ((1216318437 * i2) - 781189120) + ((-1395624931) * i) + (i12 * (-1305971684)) + ((-1305971684) * i9) + (1305971684 * i13) + ((-89653248) * i3) + ((-1446510592) * i6) + (892338176 * i5) + ((-1657864192) * i15);
        int i17 = (i2 * 2010092721) + 1217064380 + (i * 2010090761) + (i12 * (-980)) + (i9 * (-980)) + (i13 * 980) + (i3 * 2010091741) + (i6 * (-1378896031)) + (i5 * 856652822) + (i15 * 563281920);
        int i18 = i16 + (i17 * i17 * (-1077346304));
        if (i18 == 1) {
            int i19 = 2 % 2;
            int i20 = setTopP6481;
            int i21 = (i20 & 39) + (i20 | 39);
            int i22 = i21 % 128;
            vD14832N6715 = i22;
            int i23 = i21 % 2;
            setBottomR12227 setbottomr12227 = D8871;
            int i24 = ((i22 | 103) << 1) - (i22 ^ 103);
            setTopP6481 = i24 % 128;
            int i25 = i24 % 2;
            return setbottomr12227;
        }
        if (i18 == 2) {
            setBottomR12227 setbottomr12228 = (setBottomR12227) objArr[0];
            int i26 = 2 % 2;
            int i27 = setTopP6481;
            int i28 = i27 + 3;
            vD14832N6715 = i28 % 128;
            int i29 = i28 % 2;
            List<Pair<String, String>> list = setbottomr12228.D8871;
            int i30 = i27 + 37;
            vD14832N6715 = i30 % 128;
            int i31 = i30 % 2;
            return list;
        }
        setBottomR12227 setbottomr12229 = (setBottomR12227) objArr[0];
        int i32 = 2 % 2;
        int i33 = vD14832N6715;
        int i34 = (i33 & 77) + (i33 | 77);
        setTopP6481 = i34 % 128;
        int i35 = i34 % 2;
        int iHashCode2 = setbottomr12229.D8871.hashCode();
        if (i35 == 0) {
            i7 = iHashCode2 % AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            iHashCode = setbottomr12229.vD14832N6715.hashCode();
        } else {
            i7 = iHashCode2 * 31;
            iHashCode = -setbottomr12229.vD14832N6715.hashCode();
        }
        int i36 = -iHashCode;
        int i37 = (i7 ^ i36) + ((i36 & i7) << 1);
        int i38 = setTopP6481 + 15;
        vD14832N6715 = i38 % 128;
        int i39 = i38 % 2;
        return Integer.valueOf(i37);
    }

    public static final /* synthetic */ setBottomR12227 component9() {
        int iComponent9 = P28427.AnonymousClass4.component9();
        return (setBottomR12227) vD14832N6715(new Object[0], -1243981748, 1243981749, P28427.AnonymousClass4.component9(), iComponent9, P28427.AnonymousClass4.component9(), P28427.AnonymousClass4.component9());
    }

    public final boolean equals(Object p0) {
        int i;
        int i2 = 2 % 2;
        int i3 = vD14832N6715 + 97;
        int i4 = i3 % 128;
        setTopP6481 = i4;
        int i5 = i3 % 2;
        if (this == p0) {
            int i6 = i4 + 119;
            vD14832N6715 = i6 % 128;
            return i6 % 2 == 0;
        }
        if (p0 instanceof setBottomR12227) {
            setBottomR12227 setbottomr12227 = (setBottomR12227) p0;
            if (!Intrinsics.areEqual(this.D8871, setbottomr12227.D8871)) {
                int i7 = setTopP6481;
                int i8 = (i7 ^ 101) + ((i7 & 101) << 1);
                vD14832N6715 = i8 % 128;
                return i8 % 2 != 0;
            }
            if (Intrinsics.areEqual(this.vD14832N6715, setbottomr12227.vD14832N6715)) {
                return true;
            }
            int i9 = vD14832N6715;
            int i10 = (i9 & 107) + (i9 | 107);
            setTopP6481 = i10 % 128;
            int i11 = i10 % 2;
            i = i9 + 115;
            setTopP6481 = i % 128;
        } else {
            i = ((i4 | 57) << 1) - (i4 ^ 57);
            vD14832N6715 = i % 128;
        }
        int i12 = i % 2;
        return false;
    }

    public final int hashCode() {
        int iComponent9 = P28427.AnonymousClass4.component9();
        return ((Integer) vD14832N6715(new Object[]{this}, -329518723, 329518723, P28427.AnonymousClass4.component9(), iComponent9, P28427.AnonymousClass4.component9(), P28427.AnonymousClass4.component9())).intValue();
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = (i2 ^ 23) + ((i2 & 23) << 1);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        String str = "CpuInfo(commonInfo=" + this.D8871 + ", perProcessorInfo=" + this.vD14832N6715 + ")";
        int i5 = vD14832N6715;
        int i6 = ((i5 | 117) << 1) - (i5 ^ 117);
        setTopP6481 = i6 % 128;
        int i7 = i6 % 2;
        return str;
    }

    public static setBottomR12227 vD14832N6715(List<Pair<String, String>> p0, List<? extends List<Pair<String, String>>> p1) {
        int i = 2 % 2;
        setBottomR12227 setbottomr12227 = new setBottomR12227(p0, p1);
        int i2 = setTopP6481 + 7;
        vD14832N6715 = i2 % 128;
        if (i2 % 2 == 0) {
            return setbottomr12227;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final List<Pair<String, String>> setPivotYN16904() {
        int iComponent9 = P28427.AnonymousClass4.component9();
        return (List) vD14832N6715(new Object[]{this}, -1330214618, 1330214620, P28427.AnonymousClass4.component9(), iComponent9, P28427.AnonymousClass4.component9(), P28427.AnonymousClass4.component9());
    }
}
