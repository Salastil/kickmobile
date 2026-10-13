package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class rV4669 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int C20232;
    private static char[] rP23717;
    private static long setTopP6481U32634;
    private static int yY18494;
    private final boolean D8871;
    private final long N14263A23323;
    private final boolean Y16199;
    private final boolean cW27173;
    private final long component10;
    private final int component13;
    private final int component5;
    private final boolean component8;
    private final int component9;
    private final int kC4266;
    private final boolean sG29839;
    private final boolean setPivotYN16904;
    private final int setTopP6481;
    private final long vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, int r7, byte r8) {
        /*
            int r6 = r6 * 3
            int r0 = 1 - r6
            int r8 = r8 * 2
            int r8 = 3 - r8
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.rV4669.$$a
            int r7 = r7 * 3
            int r7 = 101 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L19
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2e
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r8 = r8 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L29:
            r3 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2e:
            int r8 = -r8
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.rV4669.$$c(short, int, byte):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{112, -55, -3, -77};
        $$b = 80;
    }

    public rV4669(boolean z, long j, int i, int i2, boolean z2, long j2, int i3, int i4, boolean z3, boolean z4, long j3, int i5, boolean z5, boolean z6) {
        this.setPivotYN16904 = z;
        this.vD14832N6715 = j;
        this.component5 = i;
        this.component9 = i2;
        this.D8871 = z2;
        this.N14263A23323 = j2;
        this.component13 = i3;
        this.setTopP6481 = i4;
        this.component8 = z3;
        this.sG29839 = z4;
        this.component10 = j3;
        this.kC4266 = i5;
        this.Y16199 = z5;
        this.cW27173 = z6;
    }

    public final boolean setPivotYN16904() {
        int i = 2 % 2;
        int i2 = C20232 + 117;
        yY18494 = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.setPivotYN16904;
        if (i3 == 0) {
            return z;
        }
        throw null;
    }

    public final long component9() {
        int i = 2 % 2;
        int i2 = yY18494;
        int i3 = i2 + 3;
        C20232 = i3 % 128;
        int i4 = i3 % 2;
        long j = this.vD14832N6715;
        int i5 = i2 + 93;
        C20232 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 73 / 0;
        }
        return j;
    }

    public final int component5() {
        int i = 2 % 2;
        int i2 = yY18494 + 29;
        int i3 = i2 % 128;
        C20232 = i3;
        int i4 = i2 % 2;
        int i5 = this.component5;
        int i6 = i3 + 105;
        yY18494 = i6 % 128;
        if (i6 % 2 != 0) {
            int i7 = 27 / 0;
        }
        return i5;
    }

    public final int D8871() {
        int i = 2 % 2;
        int i2 = C20232 + 59;
        int i3 = i2 % 128;
        yY18494 = i3;
        int i4 = i2 % 2;
        int i5 = this.component9;
        if (i4 != 0) {
            int i6 = 28 / 0;
        }
        int i7 = i3 + 97;
        C20232 = i7 % 128;
        int i8 = i7 % 2;
        return i5;
    }

    public final boolean vD14832N6715() {
        int i = 2 % 2;
        int i2 = yY18494 + 5;
        C20232 = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.D8871;
        if (i3 != 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final long component8() {
        int i = 2 % 2;
        int i2 = yY18494 + 41;
        int i3 = i2 % 128;
        C20232 = i3;
        int i4 = i2 % 2;
        long j = this.N14263A23323;
        if (i4 == 0) {
            int i5 = 80 / 0;
        }
        int i6 = i3 + 49;
        yY18494 = i6 % 128;
        if (i6 % 2 == 0) {
            return j;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final int N14263A23323() {
        int i = 2 % 2;
        int i2 = C20232;
        int i3 = i2 + 77;
        yY18494 = i3 % 128;
        int i4 = i3 % 2;
        int i5 = this.component13;
        int i6 = i2 + 31;
        yY18494 = i6 % 128;
        int i7 = i6 % 2;
        return i5;
    }

    public final int component13() {
        int i = 2 % 2;
        int i2 = C20232;
        int i3 = i2 + 55;
        yY18494 = i3 % 128;
        int i4 = i3 % 2;
        int i5 = this.setTopP6481;
        int i6 = i2 + 15;
        yY18494 = i6 % 128;
        int i7 = i6 % 2;
        return i5;
    }

    public final boolean sG29839() {
        int i = 2 % 2;
        int i2 = yY18494 + 29;
        int i3 = i2 % 128;
        C20232 = i3;
        int i4 = i2 % 2;
        boolean z = this.component8;
        int i5 = i3 + 69;
        yY18494 = i5 % 128;
        if (i5 % 2 == 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final boolean setTopP6481() {
        int i = 2 % 2;
        int i2 = C20232 + 93;
        yY18494 = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.sG29839;
        if (i3 == 0) {
            return z;
        }
        throw null;
    }

    public final long rP23717() {
        int i = 2 % 2;
        int i2 = yY18494 + 95;
        int i3 = i2 % 128;
        C20232 = i3;
        int i4 = i2 % 2;
        long j = this.component10;
        int i5 = i3 + 89;
        yY18494 = i5 % 128;
        int i6 = i5 % 2;
        return j;
    }

    public final boolean Y16199() {
        int i = 2 % 2;
        int i2 = yY18494;
        int i3 = i2 + 29;
        C20232 = i3 % 128;
        int i4 = i3 % 2;
        boolean z = this.Y16199;
        int i5 = i2 + 59;
        C20232 = i5 % 128;
        if (i5 % 2 != 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final boolean cW27173() {
        int i = 2 % 2;
        int i2 = yY18494 + 65;
        int i3 = i2 % 128;
        C20232 = i3;
        int i4 = i2 % 2;
        boolean z = this.cW27173;
        int i5 = i3 + 101;
        yY18494 = i5 % 128;
        int i6 = i5 % 2;
        return z;
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = C20232 + 53;
        yY18494 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 11 / 0;
        }
        return "";
    }

    private static void a(int i, char c, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        ck ckVar = new ck();
        long[] jArr = new long[i];
        ckVar.setPivotYN16904 = 0;
        while (ckVar.setPivotYN16904 < i) {
            int i4 = ckVar.setPivotYN16904;
            try {
                Object[] objArr2 = {Integer.valueOf(rP23717[i2 + i4])};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 51, (char) View.MeasureSpec.getMode(0), 5904 - ((Process.getThreadPriority(0) + 20) >> 6), -173582907, false, $$c((short) 0, 0, (byte) 0), new Class[]{Integer.TYPE});
                }
                Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                l.longValue();
                Object[] objArr3 = {l, Long.valueOf(i4), Long.valueOf(setTopP6481U32634), Integer.valueOf(c)};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) ((-1) - Process.getGidForName("")), (ViewConfiguration.getScrollBarSize() >> 8) + 5058, 2120479290, false, $$c((short) 0, 1, (byte) 0), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {ckVar, ckVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollFriction() > 0 ? 1 : (ViewConfiguration.getScrollFriction() == 0 ? 0 : -1)) + 50, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 2463 - TextUtils.indexOf((CharSequence) "", '0', 0), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr = new char[i];
        ckVar.setPivotYN16904 = 0;
        while (ckVar.setPivotYN16904 < i) {
            int i5 = $11 + 81;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                Object[] objArr5 = {ckVar, ckVar};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
                throw null;
            }
            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
            Object[] objArr6 = {ckVar, ckVar};
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(-720328195);
            if (objComponent9 == null) {
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16), 2464 - (Process.myPid() >> 22), -2019168866, false, "a", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent9).invoke(null, objArr6);
            int i6 = $10 + 21;
            $11 = i6 % 128;
            int i7 = i6 % 2;
        }
        objArr[0] = new String(cArr);
    }

    public static void component5(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = yY18494 + 23;
        C20232 = i2 % 128;
        int i3 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        u.class.getField("vD14832N6715").get(null);
        int i4 = yY18494 + GapComposerKt.nodeKey;
        C20232 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 7, (char) (54392 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), TextUtils.indexOf("", ""), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a(3 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getEdgeSlop() >> 16) + 7, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((Process.myPid() >> 22) + 3, (char) (Color.alpha(0) + 41340), 10 - ((Process.getThreadPriority(0) + 20) >> 6), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static /* synthetic */ Object vD14832N6715(int i, int i2, Object[] objArr, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = ~i;
        int i9 = ~(i8 | i4);
        int i10 = ~i4;
        int i11 = i9 | (~(i10 | i6));
        int i12 = (~(i4 | i6)) | (~((~i6) | i8 | i10));
        int i13 = i8 | i6 | i10;
        int i14 = i6 + i + i5 + (1362283521 * i2) + ((-853422242) * i3);
        int i15 = i14 * i14;
        int i16 = ((1713903284 * i6) - 1228931072) + ((-782767794) * i) + (i11 * 1248335539) + (1248335539 * i12) + ((-1248335539) * i13) + (i5 * 465567744) + (465567744 * i2) + (1887436800 * i3) + ((-1154482176) * i15);
        int i17 = ((i6 * 722868660) - 41817558) + (i * 722869710) + (i11 * (-525)) + (i12 * (-525)) + (i13 * 525) + (i5 * 722869185) + (i2 * 1172694977) + (i3 * (-747618338)) + (i15 * 791674880);
        int i18 = i16 + (i17 * i17 * 751828992);
        if (i18 != 1) {
            if (i18 == 2) {
                return D8871(objArr);
            }
            rV4669 rv4669 = (rV4669) objArr[0];
            int i19 = 2 % 2;
            int i20 = yY18494;
            int i21 = i20 + 83;
            C20232 = i21 % 128;
            int i22 = i21 % 2;
            int i23 = rv4669.kC4266;
            int i24 = i20 + 81;
            C20232 = i24 % 128;
            int i25 = i24 % 2;
            return Integer.valueOf(i23);
        }
        rV4669 rv46610 = (rV4669) objArr[0];
        Object obj = objArr[1];
        int i26 = 2 % 2;
        if (rv46610 == obj) {
            return true;
        }
        if (!(obj instanceof rV4669)) {
            return false;
        }
        rV4669 rv46611 = (rV4669) obj;
        if (rv46610.setPivotYN16904 != rv46611.setPivotYN16904 || rv46610.vD14832N6715 != rv46611.vD14832N6715 || rv46610.component5 != rv46611.component5) {
            return false;
        }
        if (rv46610.component9 != rv46611.component9) {
            i7 = C20232 + 85;
        } else if (rv46610.D8871 != rv46611.D8871) {
            i7 = C20232 + 21;
        } else {
            if (rv46610.N14263A23323 != rv46611.N14263A23323 || rv46610.component13 != rv46611.component13 || rv46610.setTopP6481 != rv46611.setTopP6481 || rv46610.component8 != rv46611.component8 || rv46610.sG29839 != rv46611.sG29839 || rv46610.component10 != rv46611.component10) {
                return false;
            }
            if (rv46610.kC4266 == rv46611.kC4266) {
                if (rv46610.Y16199 != rv46611.Y16199) {
                    return false;
                }
                if (rv46610.cW27173 == rv46611.cW27173) {
                    return true;
                }
            }
            i7 = C20232 + 25;
        }
        yY18494 = i7 % 128;
        int i27 = i7 % 2;
        return false;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        rV4669 rv4669 = (rV4669) objArr[0];
        int i = 2 % 2;
        int i2 = C20232 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        yY18494 = i2 % 128;
        int i3 = i2 % 2;
        int iHashCode = (((((((((((((((((((((((((Boolean.hashCode(rv4669.setPivotYN16904) * 31) + Long.hashCode(rv4669.vD14832N6715)) * 31) + Integer.hashCode(rv4669.component5)) * 31) + Integer.hashCode(rv4669.component9)) * 31) + Boolean.hashCode(rv4669.D8871)) * 31) + Long.hashCode(rv4669.N14263A23323)) * 31) + Integer.hashCode(rv4669.component13)) * 31) + Integer.hashCode(rv4669.setTopP6481)) * 31) + Boolean.hashCode(rv4669.component8)) * 31) + Boolean.hashCode(rv4669.sG29839)) * 31) + Long.hashCode(rv4669.component10)) * 31) + Integer.hashCode(rv4669.kC4266)) * 31) + Boolean.hashCode(rv4669.Y16199)) * 31) + Boolean.hashCode(rv4669.cW27173);
        int i4 = yY18494 + 63;
        C20232 = i4 % 128;
        if (i4 % 2 != 0) {
            return Integer.valueOf(iHashCode);
        }
        int i5 = 39 / 0;
        return Integer.valueOf(iHashCode);
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        yY18494 = 0;
        C20232 = 1;
        rP23717 = new char[]{35573, 33107, 40333, 43493, 42018, 45241, 52419, 24266, 21885, 18856, 65527, 62531, 59537};
        setTopP6481U32634 = -8982129097490213558L;
    }

    public final boolean equals(Object obj) {
        int iComponent9 = P28427.AnonymousClass4.component9();
        int iComponent10 = P28427.AnonymousClass4.component9();
        return ((Boolean) vD14832N6715(-1734762038, P28427.AnonymousClass4.component9(), new Object[]{this, obj}, P28427.AnonymousClass4.component9(), iComponent9, iComponent10, 1734762039)).booleanValue();
    }

    public final int hashCode() {
        int iComponent9 = P28427.AnonymousClass4.component9();
        int iComponent10 = P28427.AnonymousClass4.component9();
        return ((Integer) vD14832N6715(-82181663, P28427.AnonymousClass4.component9(), new Object[]{this}, P28427.AnonymousClass4.component9(), iComponent9, iComponent10, 82181665)).intValue();
    }

    public final int component10() {
        int iComponent9 = P28427.AnonymousClass4.component9();
        int iComponent10 = P28427.AnonymousClass4.component9();
        return ((Integer) vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{this}, P28427.AnonymousClass4.component9(), iComponent9, iComponent10, 2017825196)).intValue();
    }
}
