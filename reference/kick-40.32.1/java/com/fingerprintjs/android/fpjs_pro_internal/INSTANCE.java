package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class INSTANCE extends wX26196 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static char D8871;
    private static int component5;
    private static int component8;
    private static char component9;
    private static char setPivotYN16904;
    private static char vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, byte r6, byte r7) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 109
            int r5 = r5 * 2
            int r0 = 1 - r5
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.INSTANCE.$$c
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            int r5 = 0 - r5
            if (r1 != 0) goto L19
            r4 = r7
            r3 = r2
            r7 = r6
            goto L29
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            r4 = r1[r6]
            int r3 = r3 + 1
        L29:
            int r6 = r6 + 1
            int r4 = -r4
            int r7 = r7 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.INSTANCE.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 68
            int r0 = r7 + 1
            int r6 = 24 - r6
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.INSTANCE.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L10
            r3 = r7
            r4 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L22:
            r3 = r1[r6]
            r5 = r3
            r3 = r8
            r8 = r5
        L27:
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-5)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.INSTANCE.b(byte, byte, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{Ascii.ESC, 95, 40, 70, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9, 7, -5, -4, 1, -17, -6, -14};
        $$b = WebmConstants.MkvEbmlElement.BLOCK_GROUP;
    }

    static void init$1() {
        $$c = new byte[]{123, 65, 32, 68};
        $$d = 62;
    }

    public INSTANCE(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.C20232.INSTANCE.component5(), str, setpivotyn16904);
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2;
        int i3 = 2 % 2;
        if (str != null) {
            int i4 = $10 + 43;
            $11 = i4 % 128;
            if (i4 % 2 == 0) {
                str.toCharArray();
                throw null;
            }
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cj cjVar = new cj();
        char[] cArr2 = new char[cArr.length];
        cjVar.D8871 = 0;
        char[] cArr3 = new char[2];
        while (cjVar.D8871 < cArr.length) {
            cArr3[0] = cArr[cjVar.D8871];
            char c = 1;
            cArr3[1] = cArr[cjVar.D8871 + 1];
            int i5 = 58224;
            int i6 = 0;
            while (i6 < 16) {
                int i7 = $11 + 29;
                $10 = i7 % 128;
                int i8 = i7 % i2;
                char c2 = cArr3[c];
                char c3 = cArr3[0];
                char c4 = c;
                int i9 = (c3 + i5) ^ ((c3 << 4) + ((char) (((long) vD14832N6715) ^ 2653044645608467852L)));
                int i10 = c3 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(D8871);
                    objArr2[i2] = Integer.valueOf(i10);
                    objArr2[c4] = Integer.valueOf(i9);
                    objArr2[0] = Integer.valueOf(c2);
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionChild(0L) + 53, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), KeyEvent.normalizeMetaState(0) + 5420, -1101845982, false, $$e((short) 0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    cArr3[c4] = cCharValue;
                    char c5 = cArr3[0];
                    int i11 = (cCharValue + i5) ^ ((cCharValue << 4) + ((char) (((long) setPivotYN16904) ^ 2653044645608467852L)));
                    int i12 = cCharValue >>> 5;
                    Object[] objArr3 = new Object[4];
                    objArr3[3] = Integer.valueOf(component9);
                    objArr3[i2] = Integer.valueOf(i12);
                    objArr3[c4] = Integer.valueOf(i11);
                    objArr3[0] = Integer.valueOf(c5);
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(Drawable.resolveOpacity(0, 0) + 52, (char) (Color.rgb(0, 0, 0) + 16777216), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 5420, -1101845982, false, $$e((short) 0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                    i5 -= 40503;
                    i6++;
                    c = c4;
                    i2 = i2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char c6 = c;
            cArr2[cjVar.D8871] = cArr3[0];
            cArr2[cjVar.D8871 + 1] = cArr3[c6];
            i2 = i2;
            Object[] objArr4 = new Object[i2];
            objArr4[c6] = cjVar;
            objArr4[0] = cjVar;
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-417400915);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(58 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8), ExpandableListView.getPackedPositionChild(0L) + 1188, -1247038514, false, "k", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component5 = 0;
        component8 = 1;
        setPivotYN16904 = (char) 28952;
        component9 = (char) 38044;
        vD14832N6715 = (char) 64148;
        D8871 = (char) 38581;
    }

    /* JADX WARN: Failed to calculate best type for var: r3v175 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v175 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v175 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v175 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r8v74 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v74 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v175 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public static java.lang.Object[] component9(android.content.Context r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 2246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.INSTANCE.component9(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
