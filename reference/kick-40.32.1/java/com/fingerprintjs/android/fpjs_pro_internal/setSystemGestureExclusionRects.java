package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0004\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects;", "", "<init>", "()V", "component5", "D8871", "component9", "Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects$component9;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class setSystemGestureExclusionRects {

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class D8871 extends setSystemGestureExclusionRects {
        public static final D8871 INSTANCE = new D8871();

        private D8871() {
            super(null);
        }
    }

    private setSystemGestureExclusionRects() {
    }

    public static final class component9 extends setSystemGestureExclusionRects {
        private final String D8871;

        public component9(String str) {
            super(null);
            this.D8871 = str;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRects$component5, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects$component5;", "", "<init>", "()V", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects;", "D8871", "(Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro_internal/setSystemGestureExclusionRects;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public static setSystemGestureExclusionRects D8871(String p0) {
            return Intrinsics.areEqual(p0 != null ? p0.toLowerCase(Locale.ROOT) : null, I30900.eT28692.INSTANCE.component5()) ? D8871.INSTANCE : new component9(p0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ setSystemGestureExclusionRects(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
