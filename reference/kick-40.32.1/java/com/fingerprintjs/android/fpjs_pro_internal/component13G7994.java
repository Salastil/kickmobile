package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component13G7994;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class component13G7994 extends wX26196 {
    private static int D8871 = 0;
    private static int component9 = 1;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    private component13G7994(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.A22588.INSTANCE.component5(), str, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component13G7994$vD14832N6715, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SimCountryIsoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SimCountryIsoSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/telephony/SimCountryIsoResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component9 = 0;
        private static int vD14832N6715 = 1;

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
        
            if ((r3 % 2) != 0) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        
            r1.hashCode();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            if ((r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        
            r4 = (java.lang.Throwable) ((com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904) r4).setPivotYN16904;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            return new com.fingerprintjs.android.fpjs_pro_internal.component13G7994(r1 == true ? 1 : 0, com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.vD14832N6715.INSTANCE, r1 == true ? 1 : 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        
            throw new kotlin.NoWhenBranchMatchedException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        
            if ((r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        
            if ((r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            r2 = new com.fingerprintjs.android.fpjs_pro_internal.component13G7994((java.lang.String) ((com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) r4).setPivotYN16904, com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.component13.INSTANCE, r1 == true ? 1 : 0);
            r4 = com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.vD14832N6715;
            r3 = ((r4 | 55) << 1) - (r4 ^ 55);
            com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.component9 = r3 % 128;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.fingerprintjs.android.fpjs_pro_internal.component13G7994 D8871(com.fingerprintjs.android.fpjs_pro_internal.D8871<java.lang.String, ? extends java.lang.Throwable> r4) {
            /*
                r0 = 2
                int r1 = r0 % r0
                int r1 = com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.vD14832N6715
                r2 = r1 & 37
                r1 = r1 | 37
                int r2 = r2 + r1
                int r1 = r2 % 128
                com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.component9 = r1
                int r2 = r2 % r0
                r1 = 0
                if (r2 == 0) goto L1b
                boolean r2 = r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715
                r3 = 76
                int r3 = r3 / 0
                if (r2 == 0) goto L43
                goto L1f
            L1b:
                boolean r2 = r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715
                if (r2 == 0) goto L43
            L1f:
                com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715 r4 = (com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) r4
                V r4 = r4.setPivotYN16904
                java.lang.String r4 = (java.lang.String) r4
                com.fingerprintjs.android.fpjs_pro_internal.component13G7994 r2 = new com.fingerprintjs.android.fpjs_pro_internal.component13G7994
                com.fingerprintjs.android.fpjs_pro_internal.wX26196$setPivotYN16904$component13 r3 = com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.component13.INSTANCE
                com.fingerprintjs.android.fpjs_pro_internal.wX26196$setPivotYN16904 r3 = (com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904) r3
                r2.<init>(r4, r3, r1)
                int r4 = com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.vD14832N6715
                r3 = r4 | 55
                int r3 = r3 << 1
                r4 = r4 ^ 55
                int r3 = r3 - r4
                int r4 = r3 % 128
                com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.component9 = r4
                int r3 = r3 % r0
                if (r3 != 0) goto L3f
                return r2
            L3f:
                r1.hashCode()
                throw r1
            L43:
                boolean r0 = r4 instanceof com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904
                if (r0 == 0) goto L57
                com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904 r4 = (com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904) r4
                E r4 = r4.setPivotYN16904
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                com.fingerprintjs.android.fpjs_pro_internal.component13G7994 r4 = new com.fingerprintjs.android.fpjs_pro_internal.component13G7994
                com.fingerprintjs.android.fpjs_pro_internal.wX26196$setPivotYN16904$vD14832N6715 r0 = com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.vD14832N6715.INSTANCE
                com.fingerprintjs.android.fpjs_pro_internal.wX26196$setPivotYN16904 r0 = (com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904) r0
                r4.<init>(r1, r0, r1)
                return r4
            L57:
                kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                r4.<init>()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component13G7994.Companion.D8871(com.fingerprintjs.android.fpjs_pro_internal.D8871):com.fingerprintjs.android.fpjs_pro_internal.component13G7994");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = component9;
        int i2 = (i ^ 89) + ((i & 89) << 1);
        D8871 = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        defaultConstructorMarker.hashCode();
        throw null;
    }

    public /* synthetic */ component13G7994(String str, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, setpivotyn16904);
    }
}
