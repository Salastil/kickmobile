package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB'\b\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/K15285;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/Map;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class K15285 extends wX26196 {
    private static int D8871 = 1;
    private static int component5;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private K15285(Map<String, ? extends Object> map, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component1.INSTANCE.component5(), map, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.K15285$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n¨\u0006\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/PerformanceMetricsSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/PerformanceMetricsSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/performance_metrics/PerformanceMetrics;", "Lcom/fingerprintjs/android/fpjs_pro/performance_metrics/PerformanceMetricsRepository$GetterError;", "Lcom/fingerprintjs/android/fpjs_pro/performance_metrics/PerformanceMetricsResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int D8871 = 0;
        private static int component9 = 1;
        public static int setPivotYN16904;
        public static int vD14832N6715;

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        
            if (r15.isEmpty() == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r1 = new com.fingerprintjs.android.fpjs_pro_internal.K15285(r5 == true ? 1 : 0, com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.component5.INSTANCE, r5 == true ? 1 : 0);
            r15 = com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.component9 + androidx.compose.runtime.GapComposerKt.nodeKey;
            com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.D8871 = r15 % 128;
            r15 = r15 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            r1 = com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.component13.INSTANCE;
            r6 = new kotlin.Pair[3];
            r6[0] = kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.w.INSTANCE.component5(), java.lang.Long.valueOf(((java.lang.Long) com.fingerprintjs.android.fpjs_pro_internal.kP9958.setPivotYN16904(com.fingerprintjs.android.fpjs_pro_internal.av.component5(), com.fingerprintjs.android.fpjs_pro_internal.av.component5(), -1583343660, com.fingerprintjs.android.fpjs_pro_internal.av.component5(), 1583343660, new java.lang.Object[]{r15}, com.fingerprintjs.android.fpjs_pro_internal.av.component5())).longValue()));
            r6[1] = kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.ab.INSTANCE.component5(), java.lang.Integer.valueOf(((java.lang.Integer) com.fingerprintjs.android.fpjs_pro_internal.kP9958.setPivotYN16904(com.fingerprintjs.android.fpjs_pro_internal.av.component5(), com.fingerprintjs.android.fpjs_pro_internal.av.component5(), -1719091942, com.fingerprintjs.android.fpjs_pro_internal.av.component5(), 1719091943, new java.lang.Object[]{r15}, com.fingerprintjs.android.fpjs_pro_internal.av.component5())).intValue()));
            r15 = r15;
            r7 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, 10));
            r15 = r15.iterator();
            r9 = com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.D8871;
            r10 = (r9 ^ 105) + ((r9 & 105) << 1);
            com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.component9 = r10 % 128;
            r10 = r10 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x00cd, code lost:
        
            if (r15.hasNext() == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00cf, code lost:
        
            r9 = com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.component9;
            r10 = ((r9 | 31) << 1) - (r9 ^ 31);
            com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.D8871 = r10 % 128;
            r10 = r10 % 2;
            r9 = (com.fingerprintjs.android.fpjs_pro_internal.K5264) r15.next();
            r7.add(kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.bu.INSTANCE.component5(), r9.vD14832N6715), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.t.INSTANCE.component5(), r9.component9), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.br.INSTANCE.component5(), java.lang.Integer.valueOf(r9.D8871)), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.cr.INSTANCE.component5(), r9.component8), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.ck.INSTANCE.component5(), r9.setTopP6481), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.bx.INSTANCE.component5(), r9.component13), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.bz.INSTANCE.component5(), r9.sG29839), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.bc.INSTANCE.component5(), r9.component5), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.bd.INSTANCE.component5(), r9.setPivotYN16904), kotlin.TuplesKt.to(com.fingerprintjs.android.fpjs_pro_internal.I30900.x.INSTANCE.component5(), r9.N14263A23323)));
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0185, code lost:
        
            r6[2] = kotlin.TuplesKt.to("el", r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x019a, code lost:
        
            return new com.fingerprintjs.android.fpjs_pro_internal.K15285(kotlin.collections.MapsKt.mapOf(r6), r1, r5 == true ? 1 : 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x019d, code lost:
        
            if ((r15 instanceof com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904) == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x019f, code lost:
        
            r15 = (com.fingerprintjs.android.fpjs_pro_internal.getRightG17489.component9) ((com.fingerprintjs.android.fpjs_pro_internal.setPivotYN16904) r15).setPivotYN16904;
            r1 = new com.fingerprintjs.android.fpjs_pro_internal.K15285(r5, com.fingerprintjs.android.fpjs_pro_internal.wX26196.setPivotYN16904.vD14832N6715.INSTANCE, r5 == true ? 1 : 0);
            r15 = com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.D8871;
            r3 = (r15 ^ 3) + ((r15 & 3) << 1);
            com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.component9 = r3 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x01ba, code lost:
        
            if ((r3 % 2) == 0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x01bc, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x01bd, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x01c3, code lost:
        
            throw new kotlin.NoWhenBranchMatchedException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        
            if ((r15 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        
            if ((r15 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        
            r15 = (java.util.List) ((com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) r15).setPivotYN16904;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.fingerprintjs.android.fpjs_pro_internal.K15285 D8871(com.fingerprintjs.android.fpjs_pro_internal.D8871<? extends java.util.List<com.fingerprintjs.android.fpjs_pro_internal.K5264>, ? extends com.fingerprintjs.android.fpjs_pro_internal.getRightG17489.component9> r15) {
            /*
                Method dump skipped, instruction units count: 452
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.K15285.Companion.D8871(com.fingerprintjs.android.fpjs_pro_internal.D8871):com.fingerprintjs.android.fpjs_pro_internal.K15285");
        }

        public static int component5() {
            int i = vD14832N6715;
            int i2 = i % 8467871;
            vD14832N6715 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int iMyPid = Process.myPid();
            setPivotYN16904 = iMyPid;
            return iMyPid;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component5 + 123;
        D8871 = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    public /* synthetic */ K15285(Map map, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, setpivotyn16904);
    }
}
