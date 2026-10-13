package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/lN31375;", "", "", "p0", "", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "p2", "<init>", "(IJLcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;)V", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "", "setPivotYN16904", "()Ljava/util/Map;", "toString", "()Ljava/lang/String;", "vD14832N6715", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "component5", "D8871", "I", "J"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class lN31375 {
    private static int component13 = 1;
    private static int component9;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public int D8871;

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    public long setPivotYN16904;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public component1H27181 component5;

    public static /* synthetic */ Object D8871(Object[] objArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i;
        int i8 = ~(i7 | i6);
        int i9 = (~(i7 | i3)) | i8 | (~(i6 | i3));
        int i10 = (~(i7 | (~i3))) | i8;
        int i11 = (~(i3 | i)) | (~((~i6) | i));
        int i12 = i + i6 + i4 + (929125522 * i2) + (1849324972 * i5);
        int i13 = i12 * i12;
        int i14 = (1419820811 * i) + 1146290176 + ((-1462591364) * i6) + (i9 * 470851707) + (470851707 * i10) + ((-470851707) * i11) + ((-1933443072) * i4) + ((-291241984) * i2) + (1012400128 * i5) + ((-1810169856) * i13);
        int i15 = ((i * (-2058557531)) - 518432259) + (i6 * (-2058559676)) + (i9 * (-715)) + (i10 * (-715)) + (i11 * 715) + (i4 * (-2058558961)) + (i2 * 548722830) + (i5 * 1549712660) + (i13 * (-2087387136));
        if (i14 + (i15 * i15 * (-343605248)) != 1) {
            return D8871(objArr);
        }
        lN31375 ln31375 = (lN31375) objArr[0];
        int i16 = 2 % 2;
        int i17 = component13;
        int i18 = (i17 ^ 31) + ((i17 & 31) << 1);
        component9 = i18 % 128;
        int i19 = i18 % 2;
        int iHashCode = (Integer.hashCode(ln31375.D8871) * 31) + Long.hashCode(ln31375.setPivotYN16904);
        int i20 = iHashCode * 31;
        int iHashCode2 = ln31375.component5.hashCode();
        int iComponent5 = component10.component5();
        int i21 = iHashCode2 * 85;
        int i22 = -(-(iHashCode * 2635));
        int i23 = ((i21 | i22) << 1) - (i22 ^ i21);
        int i24 = ~iHashCode2;
        int i25 = ~i20;
        int i26 = ~(i24 | i25);
        int i27 = ~iComponent5;
        int i28 = ~(i24 | i27);
        int i29 = (i28 & i26) | (i26 ^ i28);
        int i30 = ~i20;
        int i31 = i29 | (~((i30 & i27) | (i30 ^ i27)));
        int i32 = (iHashCode2 ^ i20) | (iHashCode2 & i20);
        int i33 = ~((i32 ^ iComponent5) | (i32 & iComponent5));
        int i34 = -(-(((i31 & i33) | (i31 ^ i33)) * (-84)));
        int i35 = ((i23 | i34) << 1) - (i34 ^ i23);
        int i36 = ~((i25 ^ iComponent5) | (i25 & iComponent5));
        int i37 = (iHashCode2 & i36) | (iHashCode2 ^ i36);
        int i38 = ~iComponent5;
        int i39 = ~((i38 & i20) | (i38 ^ i20));
        int i40 = -(-(((i37 & i39) | (i37 ^ i39)) * (-84)));
        int i41 = (i35 ^ i40) + ((i40 & i35) << 1);
        int i42 = ~((i27 ^ i20) | (i20 & i27));
        int i43 = ~i32;
        int i44 = ((i42 & i43) | (i42 ^ i43)) * 84;
        int i45 = ((i41 | i44) << 1) - (i44 ^ i41);
        int i46 = component9 + 1;
        component13 = i46 % 128;
        int i47 = i46 % 2;
        return Integer.valueOf(i45);
    }

    public lN31375(int i, long j, component1H27181 component1h27181) {
        this.D8871 = i;
        this.setPivotYN16904 = j;
        this.component5 = component1h27181;
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = component13 + 11;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        int i5 = i3 + 5;
        component13 = i5 % 128;
        if (i5 % 2 != 0) {
            return "";
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final Map<String, Object> setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = (i2 & 49) + (i2 | 49);
        component13 = i3 % 128;
        int i4 = i3 % 2;
        Map<String, Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(I30900.bk.INSTANCE.component5(), Integer.valueOf(this.D8871)), TuplesKt.to(I30900.cs.INSTANCE.component5(), Long.valueOf(this.setPivotYN16904)), TuplesKt.to(I30900.setKeepScreenOnI3248.INSTANCE.component5(), Long.valueOf(this.component5.component5)), TuplesKt.to(I30900.getContextMenuInfoA21117E7283.INSTANCE.component5(), Long.valueOf(this.component5.vD14832N6715)));
        int i5 = component9 + 13;
        component13 = i5 % 128;
        if (i5 % 2 != 0) {
            return mapMapOf;
        }
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.lN31375$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/lN31375$setPivotYN16904;", "", "<init>", "()V", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038;", "p0", "", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "p2", "Lcom/fingerprintjs/android/fpjs_pro_internal/lN31375;", "component5", "(Ljava/util/List;JLcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;)Lcom/fingerprintjs/android/fpjs_pro_internal/lN31375;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component5 = 0;
        private static int setPivotYN16904 = 1;

        private Companion() {
        }

        public static lN31375 component5(List<? extends setOnContextClickListenerE32038> p0, long p1, component1H27181 p2) {
            int i = 2 % 2;
            lN31375 ln31375 = new lN31375(ENTRIES.component9(p0), p1, p2);
            int i2 = component5 + 51;
            setPivotYN16904 = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 51 / 0;
            }
            return ln31375;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if ((r13 instanceof com.fingerprintjs.android.fpjs_pro_internal.lN31375) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        r6 = r6 + 1;
        r13 = r6 % 128;
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r13;
        r6 = r6 % 2;
        r0 = (r13 & 123) + (r13 | 123);
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        if ((r0 % 2) != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        r13 = (com.fingerprintjs.android.fpjs_pro_internal.lN31375) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r2.D8871 == r13.D8871) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        r13 = r6 + 35;
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if ((r13 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        r1 = ((r6 | 121) << 1) - (r6 ^ 121);
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if ((r1 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        r1 = 54 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        return java.lang.Boolean.valueOf(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
    
        return java.lang.Boolean.valueOf(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        if (r2.setPivotYN16904 == r13.setPivotYN16904) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r13 = (r6 & 21) + (r6 | 21);
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
    
        if ((r13 % 2) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.component5, r13.component5) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a5, code lost:
    
        r13 = com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9 + 73;
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ae, code lost:
    
        if ((r13 % 2) == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b0, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        if (r2 == r13) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        if (r2 == r13) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        r13 = (r8 & 41) + (r8 | 41);
        com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9 = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object D8871(java.lang.Object[] r13) {
        /*
            r0 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            r2 = r13[r0]
            com.fingerprintjs.android.fpjs_pro_internal.lN31375 r2 = (com.fingerprintjs.android.fpjs_pro_internal.lN31375) r2
            r3 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r13 = r13[r3]
            r5 = r13
            java.lang.Object r5 = (java.lang.Object) r5
            r5 = 2
            int r6 = r5 % r5
            int r6 = com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9
            r7 = r6 & 113(0x71, float:1.58E-43)
            r8 = r6 | 113(0x71, float:1.58E-43)
            int r7 = r7 + r8
            int r8 = r7 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r8
            int r7 = r7 % r5
            if (r7 != 0) goto L2a
            r7 = 64
            int r7 = r7 / r0
            if (r2 != r13) goto L37
            goto L2c
        L2a:
            if (r2 != r13) goto L37
        L2c:
            r13 = r8 & 41
            r0 = r8 | 41
            int r13 = r13 + r0
            int r0 = r13 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9 = r0
            int r13 = r13 % r5
            return r4
        L37:
            boolean r7 = r13 instanceof com.fingerprintjs.android.fpjs_pro_internal.lN31375
            r8 = 0
            if (r7 != 0) goto L53
            int r6 = r6 + r3
            int r13 = r6 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r13
            int r6 = r6 % r5
            r0 = r13 & 123(0x7b, float:1.72E-43)
            r13 = r13 | 123(0x7b, float:1.72E-43)
            int r0 = r0 + r13
            int r13 = r0 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9 = r13
            int r0 = r0 % r5
            if (r0 != 0) goto L4f
            return r1
        L4f:
            r8.hashCode()
            throw r8
        L53:
            com.fingerprintjs.android.fpjs_pro_internal.lN31375 r13 = (com.fingerprintjs.android.fpjs_pro_internal.lN31375) r13
            int r7 = r2.D8871
            int r9 = r13.D8871
            if (r7 == r9) goto L81
            int r13 = r6 + 35
            int r1 = r13 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r1
            int r13 = r13 % r5
            if (r13 != 0) goto L66
            r13 = r3
            goto L67
        L66:
            r13 = r0
        L67:
            r1 = r6 | 121(0x79, float:1.7E-43)
            int r1 = r1 << r3
            r2 = r6 ^ 121(0x79, float:1.7E-43)
            int r1 = r1 - r2
            int r2 = r1 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r2
            int r1 = r1 % r5
            if (r1 != 0) goto L7c
            r1 = 54
            int r1 = r1 / r0
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            return r13
        L7c:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            return r13
        L81:
            long r9 = r2.setPivotYN16904
            long r11 = r13.setPivotYN16904
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 == 0) goto L9a
            r13 = r6 & 21
            r0 = r6 | 21
            int r13 = r13 + r0
            int r0 = r13 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r0
            int r13 = r13 % r5
            if (r13 == 0) goto L96
            return r1
        L96:
            r8.hashCode()
            throw r8
        L9a:
            com.fingerprintjs.android.fpjs_pro_internal.component1H27181 r0 = r2.component5
            com.fingerprintjs.android.fpjs_pro_internal.component1H27181 r13 = r13.component5
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r13)
            if (r13 != 0) goto La5
            return r1
        La5:
            int r13 = com.fingerprintjs.android.fpjs_pro_internal.lN31375.component9
            int r13 = r13 + 73
            int r0 = r13 % 128
            com.fingerprintjs.android.fpjs_pro_internal.lN31375.component13 = r0
            int r13 = r13 % r5
            if (r13 == 0) goto Lb1
            return r4
        Lb1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.lN31375.D8871(java.lang.Object[]):java.lang.Object");
    }

    static {
        int iComponent5 = component10.component5();
        int i = ~iComponent5;
        int i2 = ~((514337513 & i) | (514337513 ^ i));
        int i3 = (i2 & 553930768) | (553930768 ^ i2);
        int i4 = ~iComponent5;
        int i5 = ~((i4 & (-596398706)) | ((-596398706) ^ i4));
        int i6 = (i3 & i5) | (i3 ^ i5);
        int i7 = ~(((-471869577) & iComponent5) | ((-471869577) ^ iComponent5));
        int i8 = ((i6 & i7) | (i6 ^ i7)) * (-84);
        int i9 = (((-1614733357) | i8) << 1) - (i8 ^ (-1614733357));
        int i10 = ~(iComponent5 | (-596398706));
        int i11 = -(-(((i10 & (-514337514)) | ((-514337514) ^ i10) | (~(i | 596398705))) * (-84)));
        int i12 = ((((i9 | i11) << 1) - (i11 ^ i9)) - (~(((~((i ^ 596398705) | (i & 596398705))) | 471869576) * 84))) - 1;
        int iComponent6 = component10.component5();
        int i13 = ~iComponent6;
        int i14 = ~(((-1514809776) ^ i13) | ((-1514809776) & i13));
        int i15 = (-2076048901) - (~(-(-(((i14 & 1241124355) | (1241124355 ^ i14)) * (-90)))));
        int i16 = ((~((-1514809776) | iComponent6)) | (-1543122864)) * (-45);
        int i17 = (i15 & i16) + (i16 | i15);
        int i18 = ~((iComponent6 & (-1241124356)) | ((-1241124356) ^ iComponent6));
        if (i12 <= i17 + (((i18 & (-1514809776)) | ((-1514809776) ^ i18) | (~((i13 & 1241124355) | (i13 ^ 1241124355)))) * 45)) {
            int i19 = 83 / 0;
        }
    }

    public final boolean equals(Object p0) {
        return ((Boolean) D8871(new Object[]{this, p0}, -1358476466, component10.component5(), component10.component5(), component10.component5(), component10.component5(), 1358476466)).booleanValue();
    }

    public final int hashCode() {
        return ((Integer) D8871(new Object[]{this}, -1342235027, component10.component5(), component10.component5(), component10.component5(), component10.component5(), 1342235028)).intValue();
    }
}
