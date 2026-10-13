package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/m;", "Lcom/fingerprintjs/android/fpjs_pro_internal/f;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "p0", "<init>", "(Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;)V", "setPivotYN16904", "Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "component9", "()Lcom/fingerprintjs/android/fpjs_pro_internal/setBottomR12227;", "D8871"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class m extends f<setBottomR12227> {
    private static int N14263A23323 = 1;
    private static int component5 = 0;
    private static int component8 = 0;
    private static int setTopP6481 = 1;
    private final setBottomR12227 setPivotYN16904;

    /* JADX INFO: renamed from: D8871, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> component9 = SetsKt.setOf("processor");
    private static final Set<String> vD14832N6715 = SetsKt.setOf((Object[]) new String[]{"bogomips", "cpu mhz"});

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ setBottomR12227 setPivotYN16904() {
        int i = 2 % 2;
        int i2 = N14263A23323 + 93;
        component5 = i2 % 128;
        int i3 = i2 % 2;
        setBottomR12227 setbottomr12227Component9 = component9();
        int i4 = N14263A23323 + 107;
        component5 = i4 % 128;
        if (i4 % 2 == 0) {
            return setbottomr12227Component9;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public m(setBottomR12227 setbottomr12227) {
        super(null);
        int iComponent9 = P28427.AnonymousClass4.component9();
        List list = (List) setBottomR12227.vD14832N6715(new Object[]{setbottomr12227}, -1330214618, 1330214620, P28427.AnonymousClass4.component9(), iComponent9, P28427.AnonymousClass4.component9(), P28427.AnonymousClass4.component9());
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!component9.contains(((String) ((Pair) obj).getFirst()).toLowerCase(Locale.ROOT))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<List<Pair<String, String>>> listD8871 = setbottomr12227.D8871();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD8871, 10));
        Iterator<T> it = listD8871.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list2) {
                if (!vD14832N6715.contains(((String) ((Pair) obj2).getFirst()).toLowerCase(Locale.ROOT))) {
                    arrayList4.add(obj2);
                }
            }
            arrayList3.add(arrayList4);
        }
        this.setPivotYN16904 = setBottomR12227.vD14832N6715(arrayList2, arrayList3);
    }

    private setBottomR12227 component9() {
        int i = 2 % 2;
        int i2 = component5;
        int i3 = ((i2 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i2 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        setBottomR12227 setbottomr12227 = this.setPivotYN16904;
        if (i4 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        int i5 = i2 + 87;
        N14263A23323 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 15 / 0;
        }
        return setbottomr12227;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.m$D8871, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/m$D8871;", "", "<init>", "()V", "", "", "component9", "Ljava/util/Set;", "D8871", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = setTopP6481 + GapComposerKt.nodeKey;
        component8 = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }
}
