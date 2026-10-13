package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001d\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/az;", "", "", "p0", "p1", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "component9", "()Ljava/lang/Long;", "vD14832N6715", "Ljava/lang/Long;", "component5", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class az {

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    private final Long setPivotYN16904;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    private final Long component5;

    private az(Long l, Long l2) {
        this.setPivotYN16904 = l;
        this.component5 = l2;
    }

    public final Long component9() {
        Long l = this.component5;
        if (l != null) {
            long jLongValue = l.longValue();
            Long lD8871 = ax.D8871();
            if (lD8871 != null) {
                return Long.valueOf(jLongValue - lD8871.longValue());
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.az$component5, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/az$component5;", "", "<init>", "()V", "", "p0", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/az;", "D8871", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/fingerprintjs/android/fpjs_pro_internal/az;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public static int setPivotYN16904;
        public static int vD14832N6715;

        private Companion() {
        }

        public static az D8871(Long p0, Long p1) {
            return new az(p1, (p1 == null || p0 == null) ? null : Long.valueOf(p1.longValue() + p0.longValue()), null);
        }

        public static int D8871() {
            int i = setPivotYN16904;
            int i2 = i % 9718350;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return vD14832N6715;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            vD14832N6715 = i3;
            return i3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ az(Long l, Long l2, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2);
    }
}
