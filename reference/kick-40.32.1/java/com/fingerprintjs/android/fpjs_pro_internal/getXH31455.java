package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getXH31455;", "", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "D8871", "Landroid/content/Context;", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class getXH31455 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int N14263A23323;
    private static long component5;
    private static int component8;
    private static char component9;
    private static char sG29839;
    private static char setPivotYN16904;
    private static char vD14832N6715;

    /* JADX INFO: renamed from: D8871, reason: from kotlin metadata */
    private final Context vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x001f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, short r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getXH31455.$$c
            int r8 = r8 * 3
            int r1 = r8 + 1
            int r6 = 109 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r6 = r8
            r4 = r2
            goto L29
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L1f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L1f:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L29:
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.$$e(byte, short, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getXH31455.$$a
            int r1 = 15 - r6
            int r5 = r5 * 3
            int r5 = 6 - r5
            int r7 = 115 - r7
            byte[] r1 = new byte[r1]
            int r6 = 14 - r6
            r2 = 0
            if (r0 != 0) goto L14
            r4 = r6
            r3 = r2
            goto L28
        L14:
            r3 = r2
        L15:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r5]
        L28:
            int r7 = r7 + r4
            int r7 = r7 + (-5)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.c(int, short, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{3, -60, 87, 80, 17, 6, Ascii.SO, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9};
        $$b = 215;
    }

    static void init$1() {
        $$c = new byte[]{33, 84, 42, -62};
        $$d = 82;
    }

    public getXH31455(Context context) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            objM12684constructorimpl = Result.m12684constructorimpl(applicationContext);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        this.vD14832N6715 = (Context) component9.component9(bb.setPivotYN16904(objM12684constructorimpl), context);
    }

    public static final /* synthetic */ Context setPivotYN16904(getXH31455 getxh31455) {
        int i = 2 % 2;
        int i2 = component8 + 11;
        int i3 = i2 % 128;
        N14263A23323 = i3;
        int i4 = i2 % 2;
        Object obj = null;
        Context context = getxh31455.vD14832N6715;
        if (i4 != 0) {
            obj.hashCode();
            throw null;
        }
        int i5 = i3 + 93;
        component8 = i5 % 128;
        if (i5 % 2 != 0) {
            return context;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0279  */
    /* JADX WARN: Code duplicated, block: B:61:0x027a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static void b(String str, int i, Object[] objArr) throws Throwable {
        Object charArray;
        Object obj;
        Throwable cause;
        int i2;
        int i3 = 2 % 2;
        int i4 = $10 + 25;
        $11 = i4 % 128;
        short s = 0;
        if (i4 % 2 == 0) {
            int i5 = 31 / 0;
            if (str != null) {
                charArray = str.toCharArray();
            } else {
                charArray = str;
            }
        } else if (str != null) {
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = (char[]) charArray;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        while (true) {
            obj = null;
            if (cbVar.D8871 >= cArr.length) {
                break;
            }
            int i6 = $11 + 117;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                int i7 = cbVar.D8871;
                char c = cArr[cbVar.D8871];
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[2] = cbVar;
                    objArr2[1] = cbVar;
                    objArr2[s] = Integer.valueOf(c);
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                    if (objComponent5 == null) {
                        i2 = 2106881226;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ImageFormat.getBitsPerPixel(s) + 53, (char) (60694 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), TextUtils.getOffsetAfter("", s) + 5955, 148978589, false, $$e((byte) 3, (short) -1, s), new Class[]{Integer.TYPE, Object.class, Object.class});
                    } else {
                        i2 = 2106881226;
                    }
                    jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (component5 | (-1805496993403714128L));
                    Object[] objArr3 = new Object[2];
                    objArr3[1] = cbVar;
                    objArr3[s] = cbVar;
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i2);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (55223 - ExpandableListView.getPackedPositionGroup(0L)), Color.rgb((int) s, (int) s, (int) s) + 16780485, 790704297, false, $$e((byte) 5, (short) -1, s), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                } catch (Throwable th) {
                    cause = th.getCause();
                    if (cause != null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i8 = cbVar.D8871;
                char c2 = cArr[cbVar.D8871];
                Object[] objArr4 = new Object[3];
                objArr4[2] = cbVar;
                objArr4[1] = cbVar;
                objArr4[s] = Integer.valueOf(c2);
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52, (char) (60694 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 5955, 148978589, false, $$e((byte) 3, (short) -1, s), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i8] = ((Long) ((Method) objComponent7).invoke(null, objArr4)).longValue() ^ (component5 ^ (-1805496993403714128L));
                Object[] objArr5 = new Object[2];
                objArr5[1] = cbVar;
                objArr5[s] = cbVar;
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (55223 - ((Process.getThreadPriority(s) + 20) >> 6)), 3269 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 790704297, false, $$e((byte) 5, (short) -1, s), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
            }
            s = 0;
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        char[] cArr2 = new char[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            int i9 = $10 + 99;
            $11 = i9 % 128;
            if (i9 % 2 == 0) {
                cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                Object[] objArr6 = {cbVar, cbVar};
                Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent9 == null) {
                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55223), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 3270, 790704297, false, $$e((byte) 5, (short) -1, (short) 0), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent9).invoke(null, objArr6);
                obj.hashCode();
                throw null;
            }
            cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr7 = {cbVar, cbVar};
            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent10 == null) {
                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getPressedStateDuration() >> 16) + 52, (char) (ImageFormat.getBitsPerPixel(0) + 55224), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3269, 790704297, false, $$e((byte) 5, (short) -1, (short) 0), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent10).invoke(null, objArr7);
        }
        objArr[0] = new String(cArr2);
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        int i4 = $11 + 89;
        $10 = i4 % 128;
        Object obj = null;
        if (i4 % 2 != 0) {
            obj.hashCode();
            throw null;
        }
        char[] charArray = str != null ? str.toCharArray() : str;
        cj cjVar = new cj();
        char[] cArr = new char[charArray.length];
        byte b = 0;
        cjVar.D8871 = 0;
        char[] cArr2 = new char[2];
        while (cjVar.D8871 < charArray.length) {
            int i5 = $11 + 73;
            $10 = i5 % 128;
            int i6 = i5 % i2;
            cArr2[b] = charArray[cjVar.D8871];
            char c = 1;
            cArr2[1] = charArray[cjVar.D8871 + 1];
            int i7 = $10 + 31;
            $11 = i7 % 128;
            int i8 = i7 % i2;
            int i9 = 58224;
            int i10 = b;
            while (i10 < 16) {
                int i11 = $11 + 47;
                $10 = i11 % 128;
                int i12 = i11 % i2;
                char c2 = cArr2[c];
                char c3 = cArr2[b];
                char c4 = c;
                int i13 = (c3 + i9) ^ ((c3 << 4) + ((char) (((long) setPivotYN16904) ^ 2653044645608467852L)));
                int i14 = c3 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(sG29839);
                    objArr2[i2] = Integer.valueOf(i14);
                    objArr2[c4] = Integer.valueOf(i13);
                    objArr2[b] = Integer.valueOf(c2);
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.lastIndexOf("", '0', b, b) + 53, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 5420, -1101845982, false, $$e(b, (short) -1, b), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    cArr2[c4] = cCharValue;
                    char c5 = cArr2[b];
                    int i15 = (cCharValue + i9) ^ ((cCharValue << 4) + ((char) (((long) component9) ^ 2653044645608467852L)));
                    int i16 = cCharValue >>> 5;
                    Object[] objArr3 = new Object[4];
                    objArr3[3] = Integer.valueOf(vD14832N6715);
                    objArr3[i2] = Integer.valueOf(i16);
                    objArr3[c4] = Integer.valueOf(i15);
                    objArr3[b] = Integer.valueOf(c5);
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent6 == null) {
                        byte b2 = b;
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 52, (char) ((-1) - Process.getGidForName("")), (ViewConfiguration.getLongPressTimeout() >> 16) + 5420, -1101845982, false, $$e(b2, (short) -1, b2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[0] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                    i9 -= 40503;
                    i10++;
                    c = c4;
                    i2 = i2;
                    b = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char c6 = c;
            cArr[cjVar.D8871] = cArr2[0];
            cArr[cjVar.D8871 + 1] = cArr2[c6];
            i2 = i2;
            Object[] objArr4 = new Object[i2];
            objArr4[c6] = cjVar;
            objArr4[0] = cjVar;
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-417400915);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(Drawable.resolveOpacity(0, 0) + 58, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), 1186 - ExpandableListView.getPackedPositionChild(0L), -1247038514, false, "k", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
            b = 0;
        }
        objArr[0] = new String(cArr, 0, i);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        N14263A23323 = 0;
        component8 = 1;
        component5 = 7475234245419809183L;
        component9 = (char) 25243;
        vD14832N6715 = (char) 19251;
        setPivotYN16904 = (char) 15173;
        sG29839 = (char) 57285;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] D8871(android.content.Context r49, int r50, int r51, int r52) {
        /*
            Method dump skipped, instruction units count: 8868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.D8871(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
