package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component8;", "", "<init>", "()V", "", "p0", "D8871", "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "setPivotYN16904", "Lkotlin/ranges/IntRange;", "()Lkotlin/ranges/IntRange;", "component5"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class component8 {
    private static int D8871 = 0;
    private static int component13 = 1;
    private static int component5 = 1;
    private static int vD14832N6715;
    public static final component8 INSTANCE = new component8();

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    private static final IntRange component5 = new IntRange(0, 15);

    private component8() {
    }

    public static String D8871(String p0) {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = ((i2 | 65) << 1) - (i2 ^ 65);
        component5 = i3 % 128;
        int i4 = i3 % 2;
        String str = I30900.setSystemGestureExclusionRectsL30479.INSTANCE.component5() + DomExceptionUtils.SEPARATOR + p0;
        int i5 = component5 + 23;
        vD14832N6715 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    static {
        int i = component13;
        int i2 = (i ^ 53) + ((i & 53) << 1);
        D8871 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static IntRange setPivotYN16904() {
        IntRange intRange;
        int i = 2 % 2;
        int i2 = component5 + 105;
        int i3 = i2 % 128;
        vD14832N6715 = i3;
        if (i2 % 2 != 0) {
            intRange = component5;
            int i4 = 58 / 0;
        } else {
            intRange = component5;
        }
        int i5 = ((i3 | 81) << 1) - (i3 ^ 81);
        component5 = i5 % 128;
        int i6 = i5 % 2;
        return intRange;
    }
}
