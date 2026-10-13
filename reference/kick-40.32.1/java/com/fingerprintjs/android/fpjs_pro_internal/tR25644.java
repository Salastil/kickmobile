package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class tR25644 extends wX26196 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static long component9;
    private static int setPivotYN16904;
    private static int vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, byte r8) {
        /*
            int r8 = r8 * 4
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r0 = 1 - r7
            int r6 = r6 * 2
            int r6 = 106 - r6
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.tR25644.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            r3 = -1
            if (r1 != 0) goto L19
            r4 = r7
            r6 = r8
            goto L2b
        L19:
            r5 = r8
            r8 = r6
            r6 = r5
        L1c:
            int r3 = r3 + 1
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L29:
            r4 = r1[r6]
        L2b:
            int r4 = -r4
            int r8 = r8 + r4
            int r6 = r6 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.tR25644.$$e(byte, short, byte):java.lang.String");
    }

    private static void b(short s, byte b, byte b2, Object[] objArr) {
        byte[] bArr = $$a;
        int i = 4 - (s * 2);
        int i2 = (b2 * 4) + 99;
        int i3 = b * 3;
        byte[] bArr2 = new byte[i3 + 4];
        int i4 = i3 + 3;
        int i5 = -1;
        if (bArr == null) {
            i2 = i4 + (-i) + 6;
            i++;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i2;
            if (i6 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i2;
            i2 = i7 + (-bArr[i]) + 6;
            i++;
            i5 = i6;
        }
    }

    static void init$0() {
        $$a = new byte[]{90, 113, 55, 5, -6, 5, -3};
        $$b = WebmConstants.MkvEbmlElement.BLOCK_DURATION;
    }

    static void init$1() {
        $$c = new byte[]{88, 37, -69, 48};
        $$d = 249;
    }

    public tR25644(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.jC6958.INSTANCE.component5(), str, setpivotyn16904);
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2;
        int i3 = 2 % 2;
        if (str != null) {
            charArray = str.toCharArray();
            int i4 = $11 + 85;
            $10 = i4 % 128;
            int i5 = i4 % 2;
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            int i6 = $11 + 47;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                int i7 = cbVar.D8871;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                    if (objComponent5 == null) {
                        i2 = 2106881226;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 60693), 5956 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 148978589, false, $$e((byte) 0, (short) 0, (byte) 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                    } else {
                        i2 = 2106881226;
                    }
                    jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() + (component9 ^ (-1805496993403714128L));
                    Object[] objArr3 = {cbVar, cbVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i2);
                    if (objComponent6 == null) {
                        int scrollDefaultDelay = 52 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        char c = (char) (55224 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 3269;
                        byte b = (byte) ($$d & 7);
                        byte b2 = (byte) (b - 1);
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollDefaultDelay, c, packedPositionType, 790704297, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i8 = cbVar.D8871;
                Object[] objArr4 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getFadingEdgeLength() >> 16) + 52, (char) (60693 - View.MeasureSpec.getMode(0)), 5955 - TextUtils.getTrimmedLength(""), 148978589, false, $$e((byte) 0, (short) 0, (byte) 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i8] = ((Long) ((Method) objComponent7).invoke(null, objArr4)).longValue() ^ (component9 ^ (-1805496993403714128L));
                Object[] objArr5 = {cbVar, cbVar};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent8 == null) {
                    int defaultSize = 52 - View.getDefaultSize(0, 0);
                    char keyRepeatDelay = (char) (55223 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                    int trimmedLength = TextUtils.getTrimmedLength("") + 3269;
                    byte b3 = (byte) ($$d & 7);
                    byte b4 = (byte) (b3 - 1);
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(defaultSize, keyRepeatDelay, trimmedLength, 790704297, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr6 = {cbVar, cbVar};
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent9 == null) {
                int iAxisFromString = MotionEvent.axisFromString("") + 53;
                char cRgb = (char) ((-16721993) - Color.rgb(0, 0, 0));
                int defaultSize2 = View.getDefaultSize(0, 0) + 3269;
                byte b5 = (byte) ($$d & 7);
                byte b6 = (byte) (b5 - 1);
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(iAxisFromString, cRgb, defaultSize2, 790704297, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent9).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr2);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        setPivotYN16904 = 0;
        vD14832N6715 = 1;
        component9 = -488343156302671377L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component5(int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 2264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.tR25644.component5(int, int):java.lang.Object[]");
    }
}
