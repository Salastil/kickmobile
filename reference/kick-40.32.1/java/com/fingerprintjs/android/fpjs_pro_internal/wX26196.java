package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class wX26196 {
    private static int D8871 = 0;
    public static int N14263A23323 = 0;
    private static int component9 = 1;
    public static int setTopP6481;
    private final String component5;
    private final setPivotYN16904 setPivotYN16904;
    private final Object vD14832N6715;

    public wX26196(String str, Object obj, setPivotYN16904 setpivotyn16904) {
        this.component5 = str;
        this.setPivotYN16904 = setpivotyn16904;
        Object objWrap = JSONObject.wrap(obj);
        this.vD14832N6715 = objWrap == null ? JSONObject.NULL : objWrap;
    }

    public final String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component9 + 89;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        String str = this.component5;
        if (i3 != 0) {
            int i4 = 62 / 0;
        }
        return str;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \n2\u00020\u0001:\u0006\n\u0006\u000b\f\b\rB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "", "", "p0", "<init>", "(I)V", "vD14832N6715", "I", "component9", "()I", "setPivotYN16904", "component5", "D8871", "component13", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component13;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class setPivotYN16904 {
        private static int D8871 = 1;
        private static int component13 = 1;
        private static int component5;
        private static int component9;

        /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
        public static final Companion INSTANCE;

        /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
        private final int component9;

        private setPivotYN16904(int i) {
            this.component9 = i;
        }

        public final int component9() {
            int i = 2 % 2;
            int i2 = D8871;
            int i3 = i2 + 81;
            component9 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = this.component9;
            if (i4 != 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            int i6 = i2 + 51;
            component9 = i6 % 128;
            int i7 = i6 % 2;
            return i5;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component13;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component13 extends setPivotYN16904 {
            public static final component13 INSTANCE = new component13();
            private static int component5 = 1;
            private static int vD14832N6715;

            private component13() {
                super(0, null);
            }

            static {
                int i = component5;
                int i2 = (i & 65) + (i | 65);
                vD14832N6715 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i3 = 31 / 0;
                }
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class vD14832N6715 extends setPivotYN16904 {
            private static int D8871 = 0;
            public static final vD14832N6715 INSTANCE = new vD14832N6715();
            private static int component9 = 1;

            private vD14832N6715() {
                super(-1, null);
            }

            static {
                int i = component9 + 51;
                D8871 = i % 128;
                int i2 = i % 2;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component5 extends setPivotYN16904 {
            private static int D8871 = 0;
            public static final component5 INSTANCE = new component5();
            private static int vD14832N6715 = 1;

            private component5() {
                super(-2, null);
            }

            static {
                int i = vD14832N6715;
                int i2 = ((i | 27) << 1) - (i ^ 27);
                D8871 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class D8871 extends setPivotYN16904 {
            public static final D8871 INSTANCE = new D8871();
            private static int component5 = 0;
            private static int component9 = 1;

            private D8871() {
                super(-3, null);
            }

            static {
                int i = component9;
                int i2 = (i ^ 7) + ((i & 7) << 1);
                component5 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component9 extends setPivotYN16904 {
            private static int D8871 = 1;
            public static final component9 INSTANCE = new component9();
            private static int component9;

            private component9() {
                super(-4, null);
            }

            static {
                int i = component9;
                int i2 = (i ^ 67) + ((i & 67) << 1);
                D8871 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.wX26196$setPivotYN16904$setPivotYN16904, reason: collision with other inner class name and from kotlin metadata */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904$setPivotYN16904;", "", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            DefaultConstructorMarker defaultConstructorMarker = null;
            INSTANCE = new Companion(defaultConstructorMarker);
            int i = component5 + 47;
            component13 = i % 128;
            if (i % 2 != 0) {
                return;
            }
            defaultConstructorMarker.hashCode();
            throw null;
        }

        public /* synthetic */ setPivotYN16904(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    public final JSONObject component9() {
        int i = 2 % 2;
        JSONObject jSONObject = new JSONObject(MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) new Pair[]{TuplesKt.to(I30900.bs.INSTANCE.component5(), Integer.valueOf(this.setPivotYN16904.component9())), TuplesKt.to(I30900.cz.INSTANCE.component5(), this.vD14832N6715)})));
        int i2 = component9;
        int i3 = ((i2 | 43) << 1) - (i2 ^ 43);
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        return jSONObject;
    }

    public static int component8() {
        int i = N14263A23323;
        int i2 = i % 7298771;
        N14263A23323 = i + 1;
        if (i2 != 0) {
            return setTopP6481;
        }
        int iMyUid = Process.myUid();
        setTopP6481 = iMyUid;
        return iMyUid;
    }
}
