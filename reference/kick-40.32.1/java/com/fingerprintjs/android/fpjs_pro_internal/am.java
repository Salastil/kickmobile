package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.PlaybackException;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import androidx.work.WorkInfo;
import com.datadog.reactnative.ProxyAuthenticator;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public final class am {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final byte[] $$d = null;
    private static final int $$e = 0;
    private static final int $$f = 0;
    private static int $10;
    private static int $11;
    private static boolean D8871;
    private static int[] component8;
    private static boolean component9;
    private static int sG29839;
    private static char[] setPivotYN16904;
    private static int setTopP6481;
    private static int vD14832N6715;
    private final ContentResolver component5;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, byte r7, byte r8) {
        /*
            int r8 = 122 - r8
            int r6 = r6 * 3
            int r0 = r6 + 1
            int r7 = r7 * 4
            int r7 = 3 - r7
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.am.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L25:
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r3
            r3 = r8
            r8 = r7
            r7 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.am.$$g(byte, byte, byte):java.lang.String");
    }

    private static void a(short s, int i, byte b, Object[] objArr) {
        byte[] bArr = $$d;
        int i2 = 99 - (b * 4);
        int i3 = 4 - (i * 2);
        int i4 = s * 2;
        byte[] bArr2 = new byte[10 - i4];
        int i5 = 9 - i4;
        int i6 = -1;
        if (bArr == null) {
            i2 = (i3 + i5) - 25;
            i3++;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i2;
            i2 = (i7 + bArr[i3]) - 25;
            i3++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 98
            int r0 = 15 - r6
            int r7 = r7 * 3
            int r7 = r7 + 4
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.am.$$a
            byte[] r0 = new byte[r0]
            int r6 = 14 - r6
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r3
            int r8 = r8 + 1
            int r7 = r7 + (-5)
            r3 = r8
            r8 = r7
            r7 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.am.d(byte, int, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{90, 113, 55, 5, 17, 6, Ascii.SO, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9};
        $$b = 148;
    }

    static void init$1() {
        $$d = new byte[]{73, -5, -69, 92, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
        $$e = 70;
    }

    static void init$2() {
        $$c = new byte[]{48, -53, -22, 107};
        $$f = 94;
    }

    public am(ContentResolver contentResolver) {
        this.component5 = contentResolver;
    }

    public static final /* synthetic */ ContentResolver setPivotYN16904(am amVar) {
        int i = 2 % 2;
        int i2 = sG29839;
        int i3 = ((i2 | 25) << 1) - (i2 ^ 25);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        Object obj = null;
        ContentResolver contentResolver = amVar.component5;
        if (i4 != 0) {
            obj.hashCode();
            throw null;
        }
        int i5 = ((i2 | 49) << 1) - (i2 ^ 49);
        setTopP6481 = i5 % 128;
        if (i5 % 2 == 0) {
            return contentResolver;
        }
        obj.hashCode();
        throw null;
    }

    public final D8871<String, Throwable> D8871() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.am.2
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $vD14832N6715;
                private static long setPivotYN16904;

                /* JADX WARN: Code duplicated, block: B:10:0x0026  */
                /* JADX WARN: Code duplicated, block: B:8:0x0020  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002d). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(short r6, int r7, byte r8) {
                    /*
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.am.AnonymousClass2.$$a
                        int r7 = r7 * 4
                        int r1 = r7 + 1
                        int r6 = r6 * 3
                        int r6 = 4 - r6
                        int r8 = r8 * 2
                        int r8 = r8 + 104
                        byte[] r1 = new byte[r1]
                        r2 = 0
                        if (r0 != 0) goto L17
                        r8 = r6
                        r4 = r7
                        r3 = r2
                        goto L2d
                    L17:
                        r3 = r8
                        r8 = r6
                        r6 = r3
                        r3 = r2
                    L1b:
                        byte r4 = (byte) r6
                        r1[r3] = r4
                        if (r3 != r7) goto L26
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        return r6
                    L26:
                        r4 = r0[r8]
                        int r3 = r3 + 1
                        r5 = r8
                        r8 = r6
                        r6 = r5
                    L2d:
                        int r4 = -r4
                        int r6 = r6 + 1
                        int r8 = r8 + r4
                        r5 = r8
                        r8 = r6
                        r6 = r5
                        goto L1b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.am.AnonymousClass2.$$c(short, int, byte):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{Ascii.SYN, Ascii.EM, 71, 62};
                    $$b = 52;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 95;
                    $D8871 = i3 % 128;
                    if (i3 % 2 == 0) {
                        return D8871();
                    }
                    D8871();
                    throw null;
                }

                public final String D8871() {
                    int i2 = 2 % 2;
                    int i3 = $D8871 + 107;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    ContentResolver pivotYN16904 = am.setPivotYN16904(am.this);
                    Intrinsics.checkNotNull(pivotYN16904);
                    String string = Settings.Global.getString(pivotYN16904, I30900.db.INSTANCE.component5());
                    Intrinsics.checkNotNull(string);
                    int i5 = $vD14832N6715 + 119;
                    $D8871 = i5 % 128;
                    if (i5 % 2 == 0) {
                        return string;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                private static void a(String str, int i2, Object[] objArr2) throws Throwable {
                    char[] charArray;
                    int i3;
                    int i4 = 2 % 2;
                    int i5 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    int i6 = i5 % 128;
                    $11 = i6;
                    Object obj = null;
                    if (i5 % 2 == 0) {
                        obj.hashCode();
                        throw null;
                    }
                    if (str != null) {
                        int i7 = i6 + 73;
                        $10 = i7 % 128;
                        if (i7 % 2 != 0) {
                            str.toCharArray();
                            obj.hashCode();
                            throw null;
                        }
                        charArray = str.toCharArray();
                    } else {
                        charArray = str;
                    }
                    char[] cArr = charArray;
                    cb cbVar = new cb();
                    cbVar.setPivotYN16904 = i2;
                    int length = cArr.length;
                    long[] jArr = new long[length];
                    cbVar.D8871 = 0;
                    while (cbVar.D8871 < cArr.length) {
                        int i8 = $11 + 113;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        int i10 = cbVar.D8871;
                        try {
                            Object[] objArr3 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                            if (objComponent5 == null) {
                                i3 = 2106881226;
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (60692 - MotionEvent.axisFromString("")), 5955 - View.resolveSize(0, 0), 148978589, false, $$c((short) 0, 0, (byte) 1), new Class[]{Integer.TYPE, Object.class, Object.class});
                            } else {
                                i3 = 2106881226;
                            }
                            jArr[i10] = ((Long) ((Method) objComponent5).invoke(null, objArr3)).longValue() ^ (setPivotYN16904 ^ (-1805496993403714128L));
                            Object[] objArr4 = {cbVar, cbVar};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (Color.alpha(0) + 55223), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 3268, 790704297, false, $$c((short) 0, 0, (byte) 0), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent6).invoke(null, objArr4);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char[] cArr2 = new char[length];
                    cbVar.D8871 = 0;
                    while (cbVar.D8871 < cArr.length) {
                        int i11 = $10 + 3;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                        Object[] objArr5 = {cbVar, cbVar};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 55224), (Process.myTid() >> 22) + 3269, 790704297, false, $$c((short) 0, 0, (byte) 0), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent7).invoke(null, objArr5);
                    }
                    objArr2[0] = new String(cArr2);
                }

                public static void component5(long j, long j2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 123;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    long j3 = j ^ (j2 << 32);
                    u.class.getField("vD14832N6715").get(null);
                    int i5 = $vD14832N6715 + 35;
                    $D8871 = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a("\udc50쒺\uedb0隤뾷ꂘ䦮", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6397, objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj, null);
                        Object[] objArr4 = new Object[1];
                        a("\udc17齅媼", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17238, objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a("\udc56ꊢ↰", 32496 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr6);
                        Method method3 = Map.class.getMethod((String) objArr6[0], Object.class, Object.class);
                        method3.setAccessible(true);
                        method3.invoke(objInvoke2, objArr5);
                        int i7 = $D8871 + 107;
                        $vD14832N6715 = i7 % 128;
                        int i8 = i7 % 2;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }

                static {
                    init$0();
                    $10 = 0;
                    $11 = 1;
                    $D8871 = 0;
                    $vD14832N6715 = 1;
                    setPivotYN16904 = -7095471957473027690L;
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int i2 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 51;
                char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                int iCombineMeasuredStates = 1077 - View.combineMeasuredStates(0, 0);
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i2, threadPriority, iCombineMeasuredStates, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<String, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i3 = setTopP6481 + 43;
            sG29839 = i3 % 128;
            int i4 = i3 % 2;
            return d8871;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void b(int[] iArr, int i, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        ci ciVar = new ci();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = component8;
        int i5 = 16;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i6 = 0;
            i2 = 1299132072;
            while (i6 < length) {
                int i7 = $10 + 115;
                $11 = i7 % 128;
                if (i7 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr2[i6])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionChild(0L) + 53, (char) (View.resolveSize(0, 0) + 40761), 6422 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 534407883, false, $$g((byte) 0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE});
                        }
                        iArr3[i6] = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                        i6 >>= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    i3 = i3;
                    Object[] objArr3 = {Integer.valueOf(iArr2[i6])};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 51, (char) (AndroidCharacter.getMirror('0') + 40713), 6421 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 534407883, false, $$g((byte) 0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE});
                    }
                    iArr3[i6] = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                    i6++;
                }
                i3 = i3;
            }
            iArr2 = iArr3;
        } else {
            i2 = 1299132072;
        }
        int i8 = i3;
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = component8;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i9 = 0;
            while (i9 < length3) {
                Object[] objArr4 = {Integer.valueOf(iArr5[i9])};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i2);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.blue(0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 40760), Color.red(0) + 6421, 534407883, false, $$g((byte) 0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE});
                }
                iArr6[i9] = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
                i9++;
                int i10 = $10 + 21;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                i5 = i5;
            }
            iArr5 = iArr6;
        }
        int i12 = i5;
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        ciVar.component5 = 0;
        int i13 = $11 + 31;
        $10 = i13 % 128;
        int i14 = i13 % 2;
        while (ciVar.component5 < iArr.length) {
            cArr[0] = (char) (iArr[ciVar.component5] >> 16);
            char c = 1;
            cArr[1] = (char) iArr[ciVar.component5];
            cArr[i8] = (char) (iArr[ciVar.component5 + 1] >> 16);
            char c2 = 3;
            cArr[3] = (char) iArr[ciVar.component5 + 1];
            ciVar.vD14832N6715 = (cArr[0] << 16) + cArr[1];
            ciVar.setPivotYN16904 = (cArr[i8] << 16) + cArr[3];
            ci.setPivotYN16904(iArr4);
            int i15 = 0;
            for (int i16 = i12; i15 < i16; i16 = 16) {
                int i17 = $10 + 27;
                $11 = i17 % 128;
                if (i17 % 2 == 0) {
                    ciVar.vD14832N6715 ^= iArr4[i15];
                    int iD8871 = ci.D8871(ciVar.vD14832N6715);
                    Object[] objArr5 = new Object[4];
                    objArr5[c2] = ciVar;
                    objArr5[i8] = ciVar;
                    objArr5[c] = Integer.valueOf(iD8871);
                    objArr5[0] = ciVar;
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(63485357);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((Process.myPid() >> 22) + 86, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 251 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                    ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                    ciVar.setPivotYN16904 = iIntValue;
                    i15 += 15;
                } else {
                    c = c;
                    c2 = c2;
                    ciVar.vD14832N6715 ^= iArr4[i15];
                    int iD8872 = ci.D8871(ciVar.vD14832N6715);
                    Object[] objArr6 = new Object[4];
                    objArr6[c2] = ciVar;
                    objArr6[i8] = ciVar;
                    objArr6[c] = Integer.valueOf(iD8872);
                    objArr6[0] = ciVar;
                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(63485357);
                    if (objComponent9 == null) {
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.makeMeasureSpec(0, 0) + 86, (char) (ExpandableListView.getPackedPositionChild(0L) + 1), 251 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objComponent9).invoke(null, objArr6)).intValue();
                    ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                    ciVar.setPivotYN16904 = iIntValue2;
                    i15++;
                }
                c = c;
                c2 = c2;
            }
            char c3 = c;
            char c4 = c2;
            int i18 = ciVar.vD14832N6715;
            ciVar.vD14832N6715 = ciVar.setPivotYN16904;
            ciVar.setPivotYN16904 = i18;
            i12 = 16;
            ciVar.setPivotYN16904 ^= iArr4[16];
            ciVar.vD14832N6715 ^= iArr4[17];
            int i19 = ciVar.vD14832N6715;
            int i20 = ciVar.setPivotYN16904;
            cArr[0] = (char) (ciVar.vD14832N6715 >>> 16);
            cArr[c3] = (char) ciVar.vD14832N6715;
            cArr[i8] = (char) (ciVar.setPivotYN16904 >>> 16);
            cArr[c4] = (char) ciVar.setPivotYN16904;
            ci.setPivotYN16904(iArr4);
            cArr2[ciVar.component5 * 2] = cArr[0];
            cArr2[(ciVar.component5 * 2) + 1] = cArr[c3];
            cArr2[(ciVar.component5 * 2) + 2] = cArr[i8];
            cArr2[(ciVar.component5 * 2) + 3] = cArr[c4];
            Object[] objArr7 = new Object[i8];
            objArr7[c3] = ciVar;
            objArr7[0] = ciVar;
            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(743063861);
            if (objComponent10 == null) {
                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""), 3579 - TextUtils.getOffsetBefore("", 0), 2130642262, false, $$g((byte) 0, (byte) 0, (byte) 54), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent10).invoke(null, objArr7);
            i8 = 2;
        }
        String str = new String(cArr2, 0, i);
        int i21 = $11 + 81;
        $10 = i21 % 128;
        if (i21 % 2 != 0) {
            throw null;
        }
        objArr[0] = str;
    }

    private static void c(String str, int[] iArr, int i, String str2, Object[] objArr) throws Throwable {
        char[] charArray;
        String str3 = str2;
        int i2 = 2;
        int i3 = 2 % 2;
        int i4 = $10 + 89;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        Object bytes = str3;
        if (str3 != null) {
            bytes = str3.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        if (str != null) {
            charArray = str.toCharArray();
            int i6 = $11 + 67;
            $10 = i6 % 128;
            int i7 = i6 % 2;
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cg cgVar = new cg();
        char[] cArr2 = setPivotYN16904;
        char c = '0';
        float f = 0.0f;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                int i9 = $10 + 17;
                int i10 = i2;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i8])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (TypedValue.complexToFraction(0, f, f) > f ? 1 : (TypedValue.complexToFraction(0, f, f) == f ? 0 : -1)), (char) (Gravity.getAbsoluteGravity(0, 0) + 34442), (ViewConfiguration.getLongPressTimeout() >> 16) + 5524, -1476966259, false, $$g((byte) 0, (byte) 0, (byte) 56), new Class[]{Integer.TYPE});
                        }
                        cArr3[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        i8 <<= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    f = f;
                    Object[] objArr3 = {Integer.valueOf(cArr2[i8])};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((TypedValue.complexToFloat(0) > f ? 1 : (TypedValue.complexToFloat(0) == f ? 0 : -1)) + 34442), 5524 - (ViewConfiguration.getScrollDefaultDelay() >> 16), -1476966259, false, $$g((byte) 0, (byte) 0, (byte) 56), new Class[]{Integer.TYPE});
                    }
                    cArr3[i8] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                    i8++;
                }
                f = f;
                i2 = i10;
            }
            cArr2 = cArr3;
        }
        int i11 = i2;
        float f2 = f;
        byte b = 52;
        Object[] objArr4 = {Integer.valueOf(vD14832N6715)};
        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1693797315);
        if (objComponent7 == null) {
            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (ViewConfiguration.getScrollFriction() > f2 ? 1 : (ViewConfiguration.getScrollFriction() == f2 ? 0 : -1)), (char) Color.green(0), 4192 - Color.blue(0), -910167970, false, $$g((byte) 0, (byte) 0, (byte) 51), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
        if (component9) {
            cgVar.vD14832N6715 = bArr.length;
            char[] cArr4 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                cArr4[cgVar.setPivotYN16904] = (char) (cArr2[bArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] + i] - iIntValue);
                Object[] objArr5 = new Object[i11];
                objArr5[1] = cgVar;
                objArr5[0] = cgVar;
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getTapTimeout() >> 16), (char) (60741 - AndroidCharacter.getMirror('0')), 5955 - (ViewConfiguration.getWindowTouchSlop() >> 8), 992810496, false, $$g((byte) 0, (byte) 0, b), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
                b = 52;
                i11 = 2;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (D8871) {
            cgVar.vD14832N6715 = cArr.length;
            char[] cArr5 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            int i12 = $11 + 49;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                int i14 = $10 + 77;
                $11 = i14 % 128;
                if (i14 % 2 == 0) {
                    cArr5[cgVar.setPivotYN16904] = (char) (cArr2[cArr[cgVar.vD14832N6715 >> cgVar.setPivotYN16904] % i] >>> iIntValue);
                    Object[] objArr6 = {cgVar, cgVar};
                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                    if (objComponent9 == null) {
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (60693 - View.MeasureSpec.makeMeasureSpec(0, 0)), 5955 - View.MeasureSpec.getMode(0), 992810496, false, $$g((byte) 0, (byte) 0, (byte) 52), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent9).invoke(null, objArr6);
                } else {
                    cArr5[cgVar.setPivotYN16904] = (char) (cArr2[cArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
                    Object[] objArr7 = {cgVar, cgVar};
                    Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                    if (objComponent10 == null) {
                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 51, (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 60693), 5954 - TextUtils.indexOf("", c), 992810496, false, $$g((byte) 0, (byte) 0, (byte) 52), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent10).invoke(null, objArr7);
                    c = '0';
                }
            }
            String str4 = new String(cArr5);
            int i15 = $11 + 79;
            $10 = i15 % 128;
            int i16 = i15 % 2;
            objArr[0] = str4;
            return;
        }
        cgVar.vD14832N6715 = iArr.length;
        char[] cArr6 = new char[cgVar.vD14832N6715];
        while (true) {
            cgVar.setPivotYN16904 = 0;
            while (true) {
                if (cgVar.setPivotYN16904 >= cgVar.vD14832N6715) {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i17 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $10 = i17 % 128;
                if (i17 % 2 != 0) {
                    break;
                }
                cArr6[cgVar.setPivotYN16904] = (char) (cArr2[iArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
                cgVar.setPivotYN16904++;
            }
            cArr6[cgVar.setPivotYN16904] = (char) (cArr2[iArr[(cgVar.vD14832N6715 - 1) << cgVar.setPivotYN16904] >> i] >> iIntValue);
            int i18 = cgVar.setPivotYN16904;
        }
    }

    static {
        init$2();
        $10 = 0;
        $11 = 1;
        init$1();
        init$0();
        setTopP6481 = 0;
        sG29839 = 1;
        setPivotYN16904 = new char[]{29812, 29740, 29758, 29742, 29744, 29745, 29716, 29712, 29706, 29751, 29743, 29748, 29729, 29730, 29728, 29750, 29815, 29731, 29757, 29747, 29738, 29759, 29732, 29697, 29720, 29734, 29741, 29771, 29737, 29749, 29711, 29797, 29736, 29819, 29717, 29754, 29718, 29698, 29696, 29719};
        vD14832N6715 = 1313764421;
        D8871 = true;
        component9 = true;
        component8 = new int[]{-354076806, -1972410523, 1690094532, -814053759, -582123989, 1471339765, 1000356904, -620259572, 1383229805, -654252712, -37921793, 160163903, 1721963524, -1808938843, 699715578, 225799283, 720672680, 985528086};
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0e86 A[Catch: all -> 0x14cf, TryCatch #24 {all -> 0x14cf, blocks: (B:98:0x0e79, B:100:0x0e86, B:102:0x0eba), top: B:374:0x0e79 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x0eb8  */
    /* JADX WARN: Code duplicated, block: B:106:0x0ed1 A[Catch: all -> 0x14bf, TryCatch #12 {all -> 0x14bf, blocks: (B:104:0x0ec4, B:106:0x0ed1, B:107:0x0efd), top: B:359:0x0ec4 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x11aa A[Catch: Exception -> 0x14ea, all -> 0x1509, IOException -> 0x151c, TryCatch #1 {Exception -> 0x14ea, blocks: (B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:345:0x119c }] */
    /* JADX WARN: Code duplicated, block: B:148:0x11f8 A[Catch: Exception -> 0x14ea, all -> 0x1509, IOException -> 0x151c, TryCatch #1 {Exception -> 0x14ea, blocks: (B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:345:0x119c }] */
    /* JADX WARN: Code duplicated, block: B:153:0x125f A[Catch: all -> 0x1509, IOException -> 0x151c, TryCatch #18 {all -> 0x1509, blocks: (B:142:0x1199, B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:151:0x1244, B:153:0x125f, B:155:0x1282, B:157:0x12a5, B:159:0x1318, B:161:0x133a, B:163:0x1342, B:213:0x14ea, B:214:0x1508, B:184:0x149f, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:354:0x1199 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x1282 A[Catch: all -> 0x1509, IOException -> 0x151c, TryCatch #18 {all -> 0x1509, blocks: (B:142:0x1199, B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:151:0x1244, B:153:0x125f, B:155:0x1282, B:157:0x12a5, B:159:0x1318, B:161:0x133a, B:163:0x1342, B:213:0x14ea, B:214:0x1508, B:184:0x149f, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:354:0x1199 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x12a5 A[Catch: all -> 0x1509, IOException -> 0x151c, TryCatch #18 {all -> 0x1509, blocks: (B:142:0x1199, B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:151:0x1244, B:153:0x125f, B:155:0x1282, B:157:0x12a5, B:159:0x1318, B:161:0x133a, B:163:0x1342, B:213:0x14ea, B:214:0x1508, B:184:0x149f, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:354:0x1199 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x1318 A[Catch: all -> 0x1509, IOException -> 0x151c, TryCatch #18 {all -> 0x1509, blocks: (B:142:0x1199, B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:151:0x1244, B:153:0x125f, B:155:0x1282, B:157:0x12a5, B:159:0x1318, B:161:0x133a, B:163:0x1342, B:213:0x14ea, B:214:0x1508, B:184:0x149f, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:354:0x1199 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x133a A[Catch: all -> 0x1509, IOException -> 0x151c, TRY_LEAVE, TryCatch #18 {all -> 0x1509, blocks: (B:142:0x1199, B:143:0x119c, B:145:0x11aa, B:146:0x11e2, B:148:0x11f8, B:149:0x1231, B:151:0x1244, B:153:0x125f, B:155:0x1282, B:157:0x12a5, B:159:0x1318, B:161:0x133a, B:163:0x1342, B:213:0x14ea, B:214:0x1508, B:184:0x149f, B:185:0x14a2, B:187:0x14a4, B:189:0x14ab, B:190:0x14ac, B:195:0x14b6, B:197:0x14bd, B:198:0x14be, B:200:0x14c0, B:202:0x14cd, B:203:0x14ce, B:205:0x14d0, B:207:0x14dd, B:208:0x14de), top: B:354:0x1199 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x146e  */
    /* JADX WARN: Code duplicated, block: B:227:0x151e  */
    /* JADX WARN: Code duplicated, block: B:234:0x15ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:235:0x15ac  */
    /* JADX WARN: Code duplicated, block: B:237:0x161f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:238:0x1620  */
    /* JADX WARN: Code duplicated, block: B:240:0x1626  */
    /* JADX WARN: Code duplicated, block: B:243:0x169e A[Catch: all -> 0x1b4b, TRY_LEAVE, TryCatch #22 {all -> 0x1b4b, blocks: (B:241:0x1647, B:243:0x169e, B:249:0x16ee), top: B:372:0x1647 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x16e0  */
    /* JADX WARN: Code duplicated, block: B:248:0x16ea  */
    /* JADX WARN: Code duplicated, block: B:266:0x1a7f A[EDGE_INSN: B:266:0x1a7f->B:267:0x1b42 BREAK  A[LOOP:1: B:246:0x16e4->B:265:0x1a7b]] */
    /* JADX WARN: Code duplicated, block: B:269:0x1b4a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:278:0x1b79 A[Catch: all -> 0x22fd, TryCatch #10 {all -> 0x22fd, blocks: (B:5:0x00b0, B:7:0x00bd, B:9:0x00fd, B:18:0x0304, B:20:0x0311, B:21:0x034b, B:30:0x056a, B:32:0x0577, B:33:0x05b3, B:42:0x0733, B:44:0x0740, B:45:0x077c, B:61:0x0a27, B:63:0x0a40, B:65:0x0a88, B:256:0x185e, B:258:0x1876, B:260:0x18bc, B:276:0x1b6c, B:278:0x1b79, B:279:0x1bb4, B:288:0x1d51, B:290:0x1d5e, B:291:0x1d93, B:300:0x1f1e, B:302:0x1f2b, B:303:0x1f63, B:312:0x2160, B:314:0x216d, B:315:0x21a3, B:76:0x0c2a, B:78:0x0c43, B:80:0x0c87), top: B:356:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:282:0x1c54  */
    /* JADX WARN: Code duplicated, block: B:283:0x1cc7  */
    /* JADX WARN: Code duplicated, block: B:286:0x1d34 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:287:0x1d35  */
    /* JADX WARN: Code duplicated, block: B:290:0x1d5e A[Catch: all -> 0x22fd, TryCatch #10 {all -> 0x22fd, blocks: (B:5:0x00b0, B:7:0x00bd, B:9:0x00fd, B:18:0x0304, B:20:0x0311, B:21:0x034b, B:30:0x056a, B:32:0x0577, B:33:0x05b3, B:42:0x0733, B:44:0x0740, B:45:0x077c, B:61:0x0a27, B:63:0x0a40, B:65:0x0a88, B:256:0x185e, B:258:0x1876, B:260:0x18bc, B:276:0x1b6c, B:278:0x1b79, B:279:0x1bb4, B:288:0x1d51, B:290:0x1d5e, B:291:0x1d93, B:300:0x1f1e, B:302:0x1f2b, B:303:0x1f63, B:312:0x2160, B:314:0x216d, B:315:0x21a3, B:76:0x0c2a, B:78:0x0c43, B:80:0x0c87), top: B:356:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:294:0x1e2f  */
    /* JADX WARN: Code duplicated, block: B:295:0x1e8f  */
    /* JADX WARN: Code duplicated, block: B:298:0x1f01 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:299:0x1f02  */
    /* JADX WARN: Code duplicated, block: B:302:0x1f2b A[Catch: all -> 0x22fd, TryCatch #10 {all -> 0x22fd, blocks: (B:5:0x00b0, B:7:0x00bd, B:9:0x00fd, B:18:0x0304, B:20:0x0311, B:21:0x034b, B:30:0x056a, B:32:0x0577, B:33:0x05b3, B:42:0x0733, B:44:0x0740, B:45:0x077c, B:61:0x0a27, B:63:0x0a40, B:65:0x0a88, B:256:0x185e, B:258:0x1876, B:260:0x18bc, B:276:0x1b6c, B:278:0x1b79, B:279:0x1bb4, B:288:0x1d51, B:290:0x1d5e, B:291:0x1d93, B:300:0x1f1e, B:302:0x1f2b, B:303:0x1f63, B:312:0x2160, B:314:0x216d, B:315:0x21a3, B:76:0x0c2a, B:78:0x0c43, B:80:0x0c87), top: B:356:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x2000  */
    /* JADX WARN: Code duplicated, block: B:307:0x205a  */
    /* JADX WARN: Code duplicated, block: B:310:0x20f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:311:0x20f8  */
    /* JADX WARN: Code duplicated, block: B:314:0x216d A[Catch: all -> 0x22fd, TryCatch #10 {all -> 0x22fd, blocks: (B:5:0x00b0, B:7:0x00bd, B:9:0x00fd, B:18:0x0304, B:20:0x0311, B:21:0x034b, B:30:0x056a, B:32:0x0577, B:33:0x05b3, B:42:0x0733, B:44:0x0740, B:45:0x077c, B:61:0x0a27, B:63:0x0a40, B:65:0x0a88, B:256:0x185e, B:258:0x1876, B:260:0x18bc, B:276:0x1b6c, B:278:0x1b79, B:279:0x1bb4, B:288:0x1d51, B:290:0x1d5e, B:291:0x1d93, B:300:0x1f1e, B:302:0x1f2b, B:303:0x1f63, B:312:0x2160, B:314:0x216d, B:315:0x21a3, B:76:0x0c2a, B:78:0x0c43, B:80:0x0c87), top: B:356:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:318:0x223d  */
    /* JADX WARN: Code duplicated, block: B:320:0x22a1  */
    /* JADX WARN: Code duplicated, block: B:385:0x1a7f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:389:0x0d2f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:390:0x0dbf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:391:0x153d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x151c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:398:0x1470 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x1470 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0c20  */
    /* JADX WARN: Code duplicated, block: B:75:0x0c23  */
    /* JADX WARN: Code duplicated, block: B:78:0x0c43 A[Catch: all -> 0x22fd, TryCatch #10 {all -> 0x22fd, blocks: (B:5:0x00b0, B:7:0x00bd, B:9:0x00fd, B:18:0x0304, B:20:0x0311, B:21:0x034b, B:30:0x056a, B:32:0x0577, B:33:0x05b3, B:42:0x0733, B:44:0x0740, B:45:0x077c, B:61:0x0a27, B:63:0x0a40, B:65:0x0a88, B:256:0x185e, B:258:0x1876, B:260:0x18bc, B:276:0x1b6c, B:278:0x1b79, B:279:0x1bb4, B:288:0x1d51, B:290:0x1d5e, B:291:0x1d93, B:300:0x1f1e, B:302:0x1f2b, B:303:0x1f63, B:312:0x2160, B:314:0x216d, B:315:0x21a3, B:76:0x0c2a, B:78:0x0c43, B:80:0x0c87), top: B:356:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0c83  */
    /* JADX WARN: Code duplicated, block: B:84:0x0db1 A[LOOP:3: B:74:0x0c21->B:84:0x0db1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0dbf  */
    /* JADX WARN: Code duplicated, block: B:87:0x0df4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0e19  */
    /* JADX WARN: Code duplicated, block: B:91:0x0e33  */
    public static Object[] vD14832N6715(Context context, int i, int i2, int i3) throws Throwable {
        char c;
        int i4;
        Object[] objArr;
        char c2;
        Object[] objArr2;
        Object objComponent5;
        int i5;
        int i6;
        Object[] objArr3;
        int i7;
        Object objComponent6;
        int i8;
        int i9;
        Object[] objArr4;
        char c3;
        Object objComponent7;
        long j;
        int i10;
        int i11;
        Object[] objArr5;
        char c4;
        Object objComponent8;
        int i12;
        int i13;
        int i14;
        Object objInvoke;
        Object[] objArr6;
        char c5;
        List list;
        Iterator it;
        String str;
        Class<?> cls;
        Object[] objArr7;
        int length;
        String str2;
        String str3;
        int i15;
        int i16;
        String[] strArrSplit;
        int length2;
        int i17;
        String str4;
        Object[] objArr8;
        String[] strArr;
        int i18;
        int i19;
        int i20;
        String str5;
        Class cls2;
        Process processExec;
        Object objComponent9;
        Object objComponent10;
        Object objComponent11;
        Object objComponent12;
        String[] strArrSplit2;
        int length3;
        int i21;
        String str6;
        Object[] objArr9;
        String[] strArr2;
        Object[] objArr10;
        Object[] objArr11;
        String[] strArrSplit3;
        int i22;
        Object objComponent13;
        int i23;
        int i24;
        int elapsedCpuTime;
        int i25;
        Object[] objArr12;
        Object[] objArr13;
        Object[] objArr14;
        int i26 = -(-ImageFormat.getBitsPerPixel(0));
        Object[] objArr15 = new Object[1];
        b(new int[]{-2112265770, 771277936, 2089875094, -1648292083, -1827737935, -569170719, 599844468, 1962699201, -1451418458, 1867774908, -1129802397, -1550060435, 847592713, 1787776172, -672896567, 408718521, -973674146, 1833651794}, (i26 & 35) + (i26 | 35), objArr15);
        String str7 = (String) objArr15[0];
        Object[] objArr16 = new Object[1];
        c(null, null, 127 - View.MeasureSpec.getSize(0), "\u0094\u0095\u0098\u008e\u0086\u008e\u008d", objArr16);
        String str8 = (String) objArr16[0];
        int i27 = -(-Color.blue(0));
        int i28 = (i27 & 16) + (i27 | 16);
        Object[] objArr17 = new Object[1];
        b(new int[]{-103478541, 472383319, -1779326458, -83111425, -891466787, -188451510, -1157400470, -1226582016}, i28, objArr17);
        String str9 = (String) objArr17[0];
        try {
            if (context == null) {
                int i29 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i30 = 1057 - (~(i29 * 530));
                int i31 = (i30 ^ 67840) + ((i30 & 67840) << 1);
                int i32 = ~i;
                int i33 = ~((i32 ^ i29) | (i32 & i29));
                int i34 = ~(i29 | 128);
                int i35 = -(-(((i33 ^ i34) | (i33 & i34)) * 529));
                int i36 = ((i31 | i35) << 1) - (i35 ^ i31);
                int i37 = ~((i29 & i) | (i29 ^ i));
                int i38 = -(-(((i37 & (-129)) | ((-129) ^ i37)) * 529));
                Object[] objArr18 = new Object[1];
                c(null, null, (i36 & i38) + (i38 | i36), "\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr18);
                Object[] objArr19 = {(String) objArr18[0]};
                Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                if (objComponent14 == null) {
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 52;
                    char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 59725);
                    int i39 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 6317;
                    Object[] objArr20 = new Object[1];
                    d($$a[6], 0, (short) 1, objArr20);
                    objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(longPressTimeout, maximumFlingVelocity, i39, 66836110, false, (String) objArr20[0], new Class[]{String.class});
                }
                long jLongValue = ((Long) ((Method) objComponent14).invoke(null, objArr19)).longValue();
                long j2 = jLongValue ^ (-1);
                long jUptimeMillis = (int) SystemClock.uptimeMillis();
                long j3 = jUptimeMillis ^ (-1);
                long j4 = 27205122241L + ((-209) * jLongValue) + (((130168048 | j2) ^ (-1)) * 210) + ((((j2 | j3) ^ (-1)) | ((130168048 | jUptimeMillis) ^ (-1))) * 210) + (210 * ((((130168048 | j3) | jLongValue) ^ (-1)) | (((j2 | (-130168049)) | jUptimeMillis) ^ (-1)))) + 286118415;
                int i40 = ((int) (j4 >> 32)) & ((-2072279902) + ((~(1064940927 | i32)) * (-116)) + ((909747503 | i) * 116) + (((~((-527478908) | i)) | 372285483) * 116));
                int i41 = ((int) j4) & ((-301552147) + ((~((-1640595345) | i)) * JfifUtil.MARKER_SOI) + (((-600449) | i32) * (-216)) + (((~((-1640595345) | i32)) | 203368934) * JfifUtil.MARKER_SOI));
                if (((i40 & i41) | (i40 ^ i41)) != 0) {
                    objArr12 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int i42 = (~(i & 50)) & (i | 50);
                    int i43 = (-1006520199) + (((~(500152642 | i)) | 573588992 | (~((-357413185) | i32))) * 886) + (((~((-500152643) | i32)) | 716328450) * (-1772)) + ((~(i32 | 716328450)) * 886);
                    int i44 = (i43 ^ 16) + ((i43 & 16) << 1);
                    int iD8871 = W29288.D8871();
                    int i45 = i44 * (-380);
                    int i46 = -(-(i3 * 382));
                    int i47 = ((i45 | i46) << 1) - (i45 ^ i46);
                    int i48 = (i3 ^ iD8871) | (i3 & iD8871);
                    int i49 = ~i44;
                    int i50 = (i47 - (~(-(-(((i48 & i49) | (i48 ^ i49)) * (-381)))))) - 1;
                    int i51 = ~i3;
                    int i52 = ~((i51 & i49) | (i49 ^ i51));
                    int i53 = ~iD8871;
                    int i54 = ~((i53 & i3) | (i53 ^ i3));
                    int i55 = (i54 & i52) | (i52 ^ i54);
                    int i56 = ~((i44 & i3) | (i44 ^ i3));
                    int i57 = -(-(((i56 & i55) | (i55 ^ i56)) * 381));
                    int i58 = (((i50 | i57) << 1) - (i57 ^ i50)) + ((~((i49 ^ i3) | (i49 & i3))) * 381);
                    int i59 = i58 << 13;
                    int i60 = (i59 | i58) & (~(i58 & i59));
                    int i61 = i60 ^ (i60 >>> 17);
                    int i62 = i61 << 5;
                    ((int[]) objArr12[4])[0] = (i61 | i62) & (~(i61 & i62));
                } else {
                    objArr12 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                    int i63 = ~iFreeMemory;
                    int i64 = 1359303031 + (((~((-775809888) | i63)) | 706773023) * 184) + ((iFreeMemory | (-1061022560)) * (-184)) + ((~((-991985696) | i63)) * 184);
                    int iD8872 = W29288.D8871();
                    int i65 = (i64 * 530) + 1058;
                    int i66 = i3 * 530;
                    int i67 = ((i65 | i66) << 1) - (i65 ^ i66);
                    int i68 = ~iD8872;
                    int i69 = -(-(((~((i68 & i64) | (i68 ^ i64))) | (~((i64 ^ i3) | (i64 & i3)))) * 529));
                    int i70 = ((i67 | i69) << 1) - (i69 ^ i67);
                    int i71 = ~i3;
                    int i72 = ~((iD8872 & i64) | (i64 ^ iD8872));
                    int i73 = -(-(((i72 & i71) | (i71 ^ i72)) * 529));
                    int i74 = (i70 ^ i73) + ((i73 & i70) << 1);
                    int i75 = i74 << 13;
                    int i76 = (i75 & (~i74)) | ((~i75) & i74);
                    int i77 = i76 ^ (i76 >>> 17);
                    int i78 = i77 << 5;
                    ((int[]) objArr12[4])[0] = ((~i77) & i78) | ((~i78) & i77);
                }
                if (((int[]) objArr12[0])[0] != i) {
                    return objArr12;
                }
                Object[] objArr21 = new Object[1];
                b(new int[]{184761459, -1107296432, 453667500, 1162672310, 1365997356, 1114931828, -556401676, -187739045, -785460784, 1073619282}, TextUtils.indexOf("", "", 0) + 20, objArr21);
                Object[] objArr22 = {(String) objArr21[0]};
                Object objComponent15 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                if (objComponent15 == null) {
                    int i79 = 52 - (TypedValue.complexToFloat(0) > r13 ? 1 : (TypedValue.complexToFloat(0) == r13 ? 0 : -1));
                    char deadChar = (char) (KeyEvent.getDeadChar(0, 0) + 59725);
                    int i80 = 6318 - (ViewConfiguration.getScrollFriction() > 0 ? 1 : (ViewConfiguration.getScrollFriction() == 0 ? 0 : -1));
                    Object[] objArr23 = new Object[1];
                    d($$a[6], 0, (short) 1, objArr23);
                    objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(i79, deadChar, i80, 66836110, false, (String) objArr23[0], new Class[]{String.class});
                }
                long jLongValue2 = ((Long) ((Method) objComponent15).invoke(null, objArr22)).longValue();
                long j5 = i;
                long j6 = j5 ^ (-1);
                long j7 = (-243705229274L) + ((-219) * jLongValue2) + ((((1102738593 | (jLongValue2 ^ (-1))) ^ (-1)) | (((j6 | (-1102738594)) | jLongValue2) ^ (-1))) * 220) + ((-440) * ((-1102738594) | ((j6 | jLongValue2) ^ (-1)))) + (220 * ((-1102738594) | jLongValue2 | j5)) + 1258688960;
                int i81 = ((int) (j7 >> 32)) & ((-2135002149) + (((~(981179381 | i)) | (-456047030)) * (-465)) + ((981179381 | (~((-456047030) | i))) * 930) + (((-17047553) | i) * 465));
                int i82 = ~Process.myUid();
                int i83 = ((int) j7) & (((((~(1905979527 | i82)) | 174066264) * (-241)) - 442017288) + (((~(i82 | 2080045791)) | 294686853) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION));
                if (((i81 & i83) | (i81 ^ i83)) != 0) {
                    objArr13 = new Object[]{new int[]{(i & (-61)) | (i32 & 60)}, new int[]{i}, null, null, new int[1]};
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i84 = ~iElapsedRealtime;
                    int i85 = 1289163910 + (((~(i84 | (-845089096))) | 1061264903) * (-1042)) + (((-845089096) | iElapsedRealtime) * 521) + (((~(iElapsedRealtime | (-1061264904))) | 218142208 | (~(i84 | (-1966401)))) * 521) + 16;
                    int i86 = i85 * (-494);
                    int i87 = i3 * (-494);
                    int i88 = ((i86 | i87) << 1) - (i86 ^ i87);
                    int i89 = -(-((~((i85 ^ i3) | (i85 & i3))) * (-495)));
                    int i90 = (i88 ^ i89) + ((i89 & i88) << 1);
                    int i91 = ((i85 ^ i32) | (i85 & i32)) * 495;
                    int i92 = ((i90 | i91) << 1) - (i91 ^ i90);
                    int i93 = ~i85;
                    int i94 = ~i3;
                    int i95 = ~((i93 & i94) | (i93 ^ i94));
                    int i96 = ~i;
                    int i97 = ~((i96 & i85) | (i96 ^ i85));
                    int i98 = i92 + (((i95 & i97) | (i95 ^ i97)) * 495);
                    int i99 = i98 << 13;
                    int i100 = (i99 & (~i98)) | ((~i99) & i98);
                    int i101 = i100 >>> 17;
                    int i102 = (i100 | i101) & (~(i100 & i101));
                    int i103 = i102 << 5;
                    ((int[]) objArr13[4])[0] = ((~i102) & i103) | ((~i103) & i102);
                } else {
                    objArr13 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                    int i104 = ~iFreeMemory2;
                    int i105 = (-1619330034) + (((-340689985) | i104) * (-369)) + (((~((-733026748) | i104)) | (-516850940)) * (-369)) + (((~(iFreeMemory2 | 733026747)) | (-1073716732) | (~(i104 | (-176160956)))) * 369);
                    int iD8873 = W29288.D8871();
                    int i106 = ((i105 * (-515)) - (~(-(-(i3 * 517))))) - 1;
                    int i107 = ~i3;
                    int i108 = ~((i107 ^ iD8873) | (i107 & iD8873));
                    int i109 = ~iD8873;
                    int i110 = ~((i109 ^ i105) | (i109 & i105));
                    int i111 = (i108 ^ i110) | (i110 & i108);
                    int i112 = ~((i109 ^ i3) | (i109 & i3));
                    int i113 = ((i111 & i112) | (i111 ^ i112)) * (-516);
                    int i114 = (i106 & i113) + (i106 | i113);
                    int i115 = ~i105;
                    int i116 = ~((i107 & i115) | (i115 ^ i107) | iD8873);
                    int i117 = ~iD8873;
                    int i118 = ~(i115 | i117 | i3);
                    int i119 = ~((i115 & i3) | (i115 ^ i3));
                    int i120 = ~((i117 & i3) | (i117 ^ i3));
                    int i121 = i114 + (((i116 & i118) | (i116 ^ i118)) * 516) + (((i120 & i119) | (i119 ^ i120)) * 516);
                    int i122 = i121 << 13;
                    int i123 = (i122 | i121) & (~(i121 & i122));
                    int i124 = i123 >>> 17;
                    int i125 = ((~i123) & i124) | ((~i124) & i123);
                    int i126 = i125 << 5;
                    ((int[]) objArr13[4])[0] = ((~i125) & i126) | ((~i126) & i125);
                }
                if (((int[]) objArr13[0])[0] != i) {
                    return objArr13;
                }
                int iRgb = Color.rgb(0, 0, 0);
                Object[] objArr24 = new Object[1];
                c(null, null, ((iRgb | 16777343) << 1) - (iRgb ^ 16777343), "\u008e\u0086\u008e\u008d\u0097\u0085\u008b\u0096\u0081\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0093\u008c\u0092\u0082\u0091\u0090\u008c\u008f\u0081\u008e\u0086\u008e\u008d\u0081\u008e\u0086\u008e\u008d\u0081", objArr24);
                Object[] objArr25 = {(String) objArr24[0]};
                Object objComponent16 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent16 == null) {
                    int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 52;
                    char windowTouchSlop = (char) (59725 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int i127 = 6318 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr26 = new Object[1];
                    d($$a[6], 0, (short) 0, objArr26);
                    objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatTimeout, windowTouchSlop, i127, 369154319, false, (String) objArr26[0], new Class[]{String.class});
                }
                long jLongValue3 = ((Long) ((Method) objComponent16).invoke(null, objArr25)).longValue();
                long j8 = jLongValue3 ^ (-1);
                long jMyUid = ((long) Process.myUid()) ^ (-1);
                long j9 = ((((405914408712L + ((-932) * jLongValue3)) + ((-933) * (j8 | (((-434597869) | jMyUid) ^ (-1))))) + ((((jMyUid | j8) ^ (-1)) | ((j8 | 434597868) ^ (-1))) * 933)) + (933 * ((434597868 | jLongValue3) ^ (-1)))) - 1409099753;
                int i128 = ~((int) SystemClock.uptimeMillis());
                int i129 = ((int) (j9 >> 32)) & ((((-1019427974) + (((~(i128 | (-1342448129))) | (~((-2195459) | i128))) * (-184))) + ((((-2101192236) | (~(2098996777 | i128))) | (~(758744107 | i128))) * 184)) - 1765998128);
                int i130 = ((int) j9) & (((((~((-542515848) | i)) | (-1448499895)) * 398) - 1725968635) + (((~((-542515848) | i32)) | (-1448499895)) * 398));
                if (((i129 & i130) | (i129 ^ i130)) != 0) {
                    objArr14 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int i131 = (~(i & 80)) & (i | 80);
                    int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                    int i132 = (i3 - (~((((((~((-781256531) | iElapsedRealtime2)) | 545260050) * (-283)) - 94052699) + ((~(iElapsedRealtime2 | (-235996481))) * 283)) + 16))) - 1;
                    int i133 = i132 << 13;
                    int i134 = ((~i132) & i133) | ((~i133) & i132);
                    int i135 = i134 >>> 17;
                    int i136 = ((~i134) & i135) | ((~i135) & i134);
                    int i137 = i136 << 5;
                    ((int[]) objArr14[4])[0] = ((~i136) & i137) | ((~i137) & i136);
                } else {
                    objArr14 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i) & i) | ((~i) & i)}};
                    int i138 = (-1375231681) + (((~((-589851947) | i32)) | 537395498) * (-1188));
                    int i139 = 537395498 | (~(589851946 | i));
                    int i140 = ~(806027754 | i32);
                    int i141 = i3 + i138 + ((i139 | i140) * 594) + (((~(589851946 | i32)) | (-858484203) | i140) * 594);
                    int i142 = i141 << 13;
                    int i143 = (i141 | i142) & (~(i141 & i142));
                    int i144 = i143 ^ (i143 >>> 17);
                    int i145 = i144 << 5;
                }
                if (((int[]) objArr14[0])[0] != i) {
                    return objArr14;
                }
                int i146 = -(Process.myTid() >> 22);
                Object[] objArr27 = new Object[1];
                b(new int[]{1757567909, 1584018018, 1022638462, 2097043189, 334002754, -1795771782, -676401432, 875025587, -535021603, -1269512321, 237936703, 578098833, 1920243019, 271617748, -2122896543, -1000035526, -687279908, -622015357, -1678118114, -1787322487, 166748025, -82529432}, (i146 & 42) + (i146 | 42), objArr27);
                Object[] objArr28 = {(String) objArr27[0]};
                Object objComponent17 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent17 == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 52;
                    char mode = (char) (59725 - View.MeasureSpec.getMode(0));
                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                    Object[] objArr29 = new Object[1];
                    d($$a[6], 0, (short) 0, objArr29);
                    objComponent17 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveOpacity, mode, maximumFlingVelocity2, 369154319, false, (String) objArr29[0], new Class[]{String.class});
                }
                long jLongValue4 = ((Long) ((Method) objComponent17).invoke(null, objArr28)).longValue();
                long j10 = (-349154021637L) + ((-475) * jLongValue4);
                long j11 = (731979080 | jLongValue4) ^ (-1);
                long j12 = jLongValue4 ^ (-1);
                long j13 = ((j12 | (-731979081)) | j5) ^ (-1);
                long j14 = (((j10 + ((-476) * (j11 | j13))) + (952 * j13)) + (476 * (((j12 | j6) | (-731979081)) ^ (-1)))) - 242522804;
                int i147 = ~((int) Runtime.getRuntime().totalMemory());
                int i148 = ((int) (j14 >> 32)) & ((((-1019427974) + (((~(i147 | (-538968099))) | (~((-67211529) | i147))) * (-184))) + ((((-1731960256) | (~(1664748727 | i147))) | (~(1192992157 | i147))) * 184)) - 985205712);
                int iMyTid = Process.myTid();
                int i149 = ((int) j14) & ((-351252464) + (((~(622079968 | iMyTid)) | 2059306378) * (-465)) + ((622079968 | (~(2059306378 | iMyTid))) * 930) + ((iMyTid | 2143203306) * 465));
                if (((i148 & i149) | (i148 ^ i149)) == 0) {
                    Object[] objArr30 = {new int[]{i}, new int[]{i}, null, null, new int[]{((~i) & i) | ((~i) & i)}};
                    int i150 = (~(550399948 | i)) | (~(766575756 | i32));
                    int i151 = ~((-550399949) | i32);
                    int i152 = i3 + (-738455205) + ((i150 | i151) * (-516)) + (((~(i32 | (-545260685))) | (~(i | (-221315073)))) * 516) + ((545260684 | i151) * 516);
                    int i153 = i152 << 13;
                    int i154 = ((~i152) & i153) | ((~i153) & i152);
                    int i155 = i154 >>> 17;
                    int i156 = ((~i154) & i155) | ((~i155) & i154);
                    int i157 = i156 << 5;
                    return objArr30;
                }
                Object[] objArr31 = {new int[]{(i & (-91)) | (i32 & 90)}, new int[]{i}, null, null, new int[1]};
                int iMyUid = Process.myUid();
                int i158 = (-1704834649) + (((~(696597376 | iMyUid)) | 337806400 | (~((-480421569) | iMyUid))) * (-744)) + (((~iMyUid) | 553982208) * 744) + ((iMyUid | (-337806401)) * 744);
                int i159 = i158 * (-317);
                int i160 = ((5104 | i159) << 1) - (i159 ^ 5104);
                int i161 = ~i158;
                int i162 = ~(((-17) & i) | ((-17) ^ i));
                int i163 = (i160 - (~(-(-(((i162 & i161) | (i161 ^ i162)) * (-318)))))) - 1;
                int i164 = ~(i161 | i);
                int i165 = ~i;
                int i166 = (i165 & 16) | (i165 ^ 16);
                int i167 = -(-((i164 | (~((i166 & i158) | (i166 ^ i158)))) * TypedValues.Attributes.TYPE_PIVOT_TARGET));
                int i168 = ((i163 | i167) << 1) - (i167 ^ i163);
                int i169 = i32 | (~i158);
                int i170 = ~((i169 & 16) | (i169 ^ 16));
                int i171 = i158 | 16;
                int i172 = ~((i & i171) | (i171 ^ i));
                int i173 = ((i170 & i172) | (i170 ^ i172)) * TypedValues.Attributes.TYPE_PIVOT_TARGET;
                int i174 = (i168 ^ i173) + ((i173 & i168) << 1);
                int i175 = ((i3 | i174) << 1) - (i174 ^ i3);
                int i176 = i175 << 13;
                int i177 = ((~i175) & i176) | ((~i176) & i175);
                int i178 = i177 >>> 17;
                int i179 = (i177 | i178) & (~(i177 & i178));
                int i180 = i179 << 5;
                ((int[]) objArr31[4])[0] = (i179 | i180) & (~(i179 & i180));
                return objArr31;
            }
            int i181 = 2;
            try {
                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                Object[] objArr32 = new Object[1];
                b(new int[]{-2112265770, 771277936, 2089875094, -1648292083, -1827737935, -569170719, 599844468, 1962699201, -2078797210, 1205550199, 1249491285, 1358720150}, (offsetAfter & 23) + (offsetAfter | 23), objArr32);
                Class<?> cls3 = Class.forName((String) objArr32[0]);
                int iIndexOf = TextUtils.indexOf("", "");
                Object[] objArr33 = new Object[1];
                b(new int[]{-291897813, 449239847, -1848161257, -1868223166, -1847001535, 575082025, 902950748, 1280601789}, (iIndexOf & 14) + (iIndexOf | 14), objArr33);
                String str10 = (String) cls3.getMethod((String) objArr33[0], null).invoke(context, null);
                Object[] objArr34 = new Object[1];
                b(new int[]{-2112265770, 771277936, 2089875094, -1648292083, -1827737935, -569170719, 599844468, 1962699201, -2078797210, 1205550199, 1249491285, 1358720150}, (ViewConfiguration.getScrollBarSize() >> 8) + 23, objArr34);
                Class<?> cls4 = Class.forName((String) objArr34[0]);
                int i182 = -TextUtils.indexOf("", "", 0);
                int i183 = ((i182 | 18) << 1) - (i182 ^ 18);
                Object[] objArr35 = new Object[1];
                b(new int[]{-1157110281, -627697637, -1129802397, -1550060435, 847592713, 1787776172, -672896567, 408718521, -973674146, 1833651794}, i183, objArr35);
                Object objInvoke2 = cls4.getMethod((String) objArr35[0], null).invoke(context, null);
                int iIndexOf2 = ((String) Class.forName(str7).getField(str8).get(objInvoke2)).indexOf(str10);
                if (iIndexOf2 > 0) {
                    String str11 = (String) Class.forName(str7).getField(str8).get(objInvoke2);
                    int length4 = str11.length();
                    int i184 = (length4 & (-16)) + (length4 | (-16));
                    if (i184 >= 0) {
                        int i185 = 0;
                        while (true) {
                            if (i185 <= i184) {
                                String strSubstring = str11.substring(i185, i185 + 16);
                                c = '\r';
                                Object[] objArr36 = new Object[i181];
                                objArr36[1] = 931995;
                                objArr36[0] = strSubstring;
                                Object objComponent18 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                if (objComponent18 == null) {
                                    int absoluteGravity = 52 - Gravity.getAbsoluteGravity(0, 0);
                                    char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                    int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 5421;
                                    Object[] objArr37 = new Object[1];
                                    d((byte) ($$a[13] + 1), 0, (short) 1, objArr37);
                                    objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(absoluteGravity, scrollBarSize, modifierMetaStateMask, 1884899413, false, (String) objArr37[0], new Class[]{String.class, Integer.TYPE});
                                }
                                long jLongValue5 = ((Long) ((Method) objComponent18).invoke(null, objArr36)).longValue();
                                long jFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                long j15 = (-368560754056L) + ((-282) * jLongValue5) + ((-283) * (((1297749133 | jLongValue5) ^ (-1)) | ((1297749133 | jFreeMemory) ^ (-1))));
                                long j16 = jLongValue5 ^ (-1);
                                long j17 = j15 + (((j16 | (-1297749134)) ^ (-1)) * 283) + (283 * (((1297749133 | j16) | jFreeMemory) ^ (-1))) + 1804902247;
                                int i186 = ~i;
                                int i187 = ((int) (j17 >> 32)) & ((-189364062) + (((~(2035720079 | i186)) | 822020805 | (~((-2035720080) | i))) * (-564)) + ((~((-1224774923) | i)) * 1128) + (((~(822020805 | i186)) | 810945157) * 564));
                                int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
                                int i188 = ((int) j17) & (484646344 + (((~((-1083727254) | iFreeMemory3)) | 1083722880) * 345) + (((~((-1083727254) | (~iFreeMemory3))) | 690290752) * 345) + ((~(iFreeMemory3 | (-1083722881))) * 345));
                                if (((i188 & i187) | (i187 ^ i188)) == -725904754) {
                                    objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                    int i189 = ~i;
                                    String str12 = (String) Class.forName(str7).getField(str8).get(objInvoke2);
                                    ((int[]) objArr[1])[0] = i;
                                    ((int[]) objArr[0])[0] = (i & (-21)) | (i189 & 20);
                                    int i190 = i3 + (-1704834649) + (((~(468610255 | i)) | 67211264 | (~((-252434448) | i))) * (-744)) + ((283387072 | i189) * 744) + (((-67211265) | i) * 744) + 16;
                                    int i191 = i190 ^ (i190 << 13);
                                    int i192 = i191 >>> 17;
                                    int i193 = ((~i191) & i192) | ((~i192) & i191);
                                    int i194 = i193 << 5;
                                    ((int[]) objArr[4])[0] = (i193 | i194) & (~(i193 & i194));
                                } else {
                                    i185 = (i185 ^ 1) + ((i185 & 1) << 1);
                                    str7 = str7;
                                    str11 = str11;
                                    i181 = 2;
                                }
                            } else {
                                str2 = str7;
                                c = '\r';
                                str3 = (String) Class.forName(str2).getField(str8).get(objInvoke2);
                                int length5 = str3.length();
                                int i195 = (length5 ^ i) | (length5 & i);
                                int i196 = (-3768) + (length5 * 628) + (((i195 & 5) | (i195 ^ 5)) * (-627));
                                int i197 = ~length5;
                                int i198 = ~((i197 & i) | (i197 ^ i));
                                int i199 = i196 + (((i198 & (-6)) | ((-6) ^ i198)) * (-627));
                                i15 = ~i;
                                int i200 = ~((length5 & i15) | (i15 ^ length5));
                                int i201 = ~(((-6) & i) | ((-6) ^ i));
                                i16 = i199 + (((i200 & i201) | (i200 ^ i201)) * 627);
                                if (i16 >= 0) {
                                    i22 = 0;
                                    while (true) {
                                        if (i22 <= i16) {
                                            Object[] objArr38 = {str3.substring(i22, i22 + 6), 931995};
                                            objComponent13 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent13 == null) {
                                                int size = View.MeasureSpec.getSize(0) + 52;
                                                char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                                                int minimumFlingVelocity = 5420 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                Object[] objArr39 = new Object[1];
                                                d((byte) ($$a[13] + 1), 0, (short) 1, objArr39);
                                                objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(size, cMakeMeasureSpec, minimumFlingVelocity, 1884899413, false, (String) objArr39[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue6 = ((Long) ((Method) objComponent13).invoke(null, objArr38)).longValue();
                                            long j18 = (-261433052720L) + ((-755) * jLongValue6);
                                            long j19 = ((-346268945) | (jLongValue6 ^ (-1))) ^ (-1);
                                            long j20 = 346268944 | jLongValue6;
                                            long j21 = i;
                                            long j22 = j18 + (1512 * j19) + ((-756) * (j19 | ((j20 | j21) ^ (-1)))) + (756 * (j20 | (j21 ^ (-1)))) + 160884169;
                                            i23 = ((int) (j22 >> 32)) & ((-1161076794) + ((i | 8391040) * 988) + ((285745156 | (~((-1567547501) | i15))) * (-1976)) + ((8391040 | (~(1290193384 | i)) | (~((-1290193385) | i15))) * 988));
                                            i24 = (int) j22;
                                            elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                            i25 = ~elapsedCpuTime;
                                            if ((i23 | (i24 & (1269207234 + (((-23488532) | (~(1413737878 | i25))) * (-602)) + (((~(elapsedCpuTime | 1413737878)) | (-1432874392) | (~((-4352019) | i25))) * (-301)) + ((~(i25 | (-23488532))) * 301)))) == -2096167706) {
                                                objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                                String str13 = (String) Class.forName(str2).getField(str8).get(objInvoke2);
                                                ((int[]) objArr[1])[0] = i;
                                                ((int[]) objArr[0])[0] = (i & (-21)) | (i15 & 20);
                                                int i202 = (i3 - (~(((((-556828460) + (((~((-187085563) | i15)) | (-29090246)) * (-865))) + ((~(i | 187085562)) * 865)) + (((~(187085562 | i15)) | (~((-29090246) | i15))) * 865)) + 16))) - 1;
                                                int i203 = i202 << 13;
                                                int i204 = ((~i202) & i203) | ((~i203) & i202);
                                                int i205 = i204 >>> 17;
                                                int i206 = ((~i204) & i205) | ((~i205) & i204);
                                                int i207 = i206 << 5;
                                                ((int[]) objArr[4])[0] = (i206 | i207) & (~(i206 & i207));
                                            } else {
                                                i22 = ((i22 | 1) << 1) - (i22 ^ 1);
                                                str3 = str3;
                                            }
                                        } else {
                                            String strSubstring2 = ((String) Class.forName(str2).getField(str8).get(objInvoke2)).substring(0, iIndexOf2);
                                            Object[] objArr40 = new Object[1];
                                            b(new int[]{-370238129, 1224012160}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr40);
                                            strArrSplit = strSubstring2.split((String) objArr40[0]);
                                            length2 = strArrSplit.length;
                                            i17 = 0;
                                            while (true) {
                                                if (i17 < length2) {
                                                    str4 = strArrSplit[i17];
                                                    int i208 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                                                    objArr8 = new Object[1];
                                                    c(null, null, (i208 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i208 & WebSocketProtocol.PAYLOAD_SHORT) << 1), "\u009a\u0091\u0099", objArr8);
                                                    if (str4.split((String) objArr8[0]).length > 1) {
                                                        cls2 = (Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) View.MeasureSpec.getSize(0), View.getDefaultSize(0, 0) + 5110);
                                                        synchronized (cls2) {
                                                            try {
                                                                try {
                                                                    Object[] objArr41 = new Object[1];
                                                                    b(new int[]{-346996579, 219547197, -186167191, -72341611, 884902256, -445488909, 562084749, -757193151}, 15 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr41);
                                                                    String str14 = (String) objArr41[0];
                                                                    try {
                                                                        Runtime runtime = Runtime.getRuntime();
                                                                        int i209 = -Gravity.getAbsoluteGravity(0, 0);
                                                                        strArr = strArrSplit;
                                                                        i18 = length2;
                                                                        try {
                                                                            Object[] objArr42 = new Object[1];
                                                                            c(null, null, (i209 ^ 127) + ((i209 & 127) << 1), "\u009b\u0085", objArr42);
                                                                            processExec = runtime.exec((String) objArr42[0], (String[]) null, (File) null);
                                                                            try {
                                                                                Object[] objArr43 = {processExec.getInputStream()};
                                                                                objComponent9 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                                                if (objComponent9 == null) {
                                                                                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.combineMeasuredStates(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0, 0) + 4955, 2119435613, false, null, new Class[]{InputStream.class});
                                                                                }
                                                                                Object objNewInstance = ((Constructor) objComponent9).newInstance(objArr43);
                                                                                try {
                                                                                    Object[] objArr44 = {processExec.getErrorStream()};
                                                                                    objComponent10 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                                                    if (objComponent10 == null) {
                                                                                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                                                    }
                                                                                    Object objNewInstance2 = ((Constructor) objComponent10).newInstance(objArr44);
                                                                                    DataOutputStream dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                                                                                    try {
                                                                                        Class<?> cls5 = Class.forName(str9);
                                                                                        i19 = i15;
                                                                                        i20 = i17;
                                                                                        str5 = str9;
                                                                                        try {
                                                                                            int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                                                                                            int i210 = ((pressedStateDuration | 5) << 1) - (pressedStateDuration ^ 5);
                                                                                            Object[] objArr45 = new Object[1];
                                                                                            b(new int[]{860083988, 631234207, -805559575, 1233196272}, i210, objArr45);
                                                                                            cls5.getMethod((String) objArr45[0], null).invoke(objNewInstance, null);
                                                                                            try {
                                                                                                Class<?> cls6 = Class.forName(str5);
                                                                                                int i211 = -(-Color.blue(0));
                                                                                                int i212 = (i211 & 5) + (i211 | 5);
                                                                                                Object[] objArr46 = new Object[1];
                                                                                                b(new int[]{860083988, 631234207, -805559575, 1233196272}, i212, objArr46);
                                                                                                cls6.getMethod((String) objArr46[0], null).invoke(objNewInstance2, null);
                                                                                                try {
                                                                                                    StringBuilder sb = new StringBuilder();
                                                                                                    sb.append(str14);
                                                                                                    int i213 = -(-Color.blue(0));
                                                                                                    Object[] objArr47 = new Object[1];
                                                                                                    c(null, null, (i213 & 127) + (i213 | 127), "\u009c", objArr47);
                                                                                                    sb.append((String) objArr47[0]);
                                                                                                    String string = sb.toString();
                                                                                                    Object[] objArr48 = new Object[1];
                                                                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, Color.argb(0, 0, 0, 0) + 5, objArr48);
                                                                                                    dataOutputStream.write(string.getBytes((String) objArr48[0]));
                                                                                                    dataOutputStream.flush();
                                                                                                    Object[] objArr49 = new Object[1];
                                                                                                    c(null, null, 127 - (~(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), "\u009c\u0086\u0095\u0093\u0084", objArr49);
                                                                                                    String str15 = (String) objArr49[0];
                                                                                                    int i214 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                                                                    int i215 = (i214 & 6) + (i214 | 6);
                                                                                                    Object[] objArr50 = new Object[1];
                                                                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, i215, objArr50);
                                                                                                    dataOutputStream.write(str15.getBytes((String) objArr50[0]));
                                                                                                    dataOutputStream.flush();
                                                                                                    try {
                                                                                                        long jNanoTime = System.nanoTime();
                                                                                                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                                                                                                        long jNanoTime2 = 2000000000;
                                                                                                        while (true) {
                                                                                                            try {
                                                                                                                processExec.exitValue();
                                                                                                                cls2 = cls2;
                                                                                                                break;
                                                                                                            } catch (IllegalThreadStateException unused) {
                                                                                                                if (jNanoTime2 > 0) {
                                                                                                                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                                                                                                                    try {
                                                                                                                        Object[] objArr51 = {Long.valueOf(Math.min((jNanoTime2 / 1000000) + 1, 3L))};
                                                                                                                        Class<?> cls7 = Class.forName(str5);
                                                                                                                        Object[] objArr52 = new Object[1];
                                                                                                                        c(null, null, 126 - (~(-(-TextUtils.getOffsetAfter("", 0)))), "\u009e\u0084\u0084\u009d\u0085", objArr52);
                                                                                                                        cls7.getMethod((String) objArr52[0], Long.TYPE).invoke(null, objArr51);
                                                                                                                    } catch (Throwable th) {
                                                                                                                        Throwable cause = th.getCause();
                                                                                                                        if (cause != null) {
                                                                                                                            throw cause;
                                                                                                                        }
                                                                                                                        throw th;
                                                                                                                    }
                                                                                                                }
                                                                                                                TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
                                                                                                                jNanoTime2 = 2000000000 - (System.nanoTime() - jNanoTime);
                                                                                                                if (jNanoTime2 <= 0) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                cls2 = cls2;
                                                                                                                jNanoTime = jNanoTime;
                                                                                                            }
                                                                                                        }
                                                                                                        try {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    dataOutputStream.close();
                                                                                                                } catch (InterruptedException e) {
                                                                                                                    throw e;
                                                                                                                }
                                                                                                            } catch (IOException unused2) {
                                                                                                            }
                                                                                                            try {
                                                                                                                Class<?> cls8 = Class.forName(str5);
                                                                                                                int i216 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                                                                int i217 = i216 * (-375);
                                                                                                                int i218 = ((i217 | (-1500)) << 1) - (i217 ^ (-1500));
                                                                                                                int i219 = ~i216;
                                                                                                                int i220 = ~((i219 ^ (-5)) | (i219 & (-5)));
                                                                                                                int i221 = ~((i216 ^ 4) | (i216 & 4));
                                                                                                                int i222 = -(-(((i ^ i220) | (i220 & i) | i221) * 376));
                                                                                                                int i223 = (i218 & i222) + (i218 | i222);
                                                                                                                int i224 = -(-((i221 | (~(i19 | i216))) * (-376)));
                                                                                                                int i225 = (i223 ^ i224) + ((i223 & i224) << 1);
                                                                                                                int i226 = ~((i219 ^ i) | (i219 & i));
                                                                                                                int i227 = i225 + (((i226 & 4) | (i226 ^ 4)) * 376);
                                                                                                                Object[] objArr53 = new Object[1];
                                                                                                                b(new int[]{145536241, 1034981249}, i227, objArr53);
                                                                                                                cls8.getMethod((String) objArr53[0], Long.TYPE).invoke(objNewInstance, 100L);
                                                                                                                try {
                                                                                                                    Class<?> cls9 = Class.forName(str5);
                                                                                                                    int iRgb2 = Color.rgb(0, 0, 0);
                                                                                                                    int i228 = iRgb2 * (-419);
                                                                                                                    int i229 = ((i228 | (-1526724972)) << 1) - (i228 ^ (-1526724972));
                                                                                                                    int i230 = (~(i | 16777220)) * 420;
                                                                                                                    int i231 = ((i229 | i230) << 1) - (i230 ^ i229);
                                                                                                                    int i232 = ~iRgb2;
                                                                                                                    int i233 = ((i232 ^ 16777220) | (i232 & 16777220)) * (-420);
                                                                                                                    int i234 = (i231 ^ i233) + ((i231 & i233) << 1);
                                                                                                                    int i235 = ((~((i232 ^ (-16777221)) | (i232 & (-16777221)))) | (~(i19 | 16777220))) * 420;
                                                                                                                    int i236 = (i234 & i235) + (i235 | i234);
                                                                                                                    Object[] objArr54 = new Object[1];
                                                                                                                    b(new int[]{145536241, 1034981249}, i236, objArr54);
                                                                                                                    cls9.getMethod((String) objArr54[0], Long.TYPE).invoke(objNewInstance2, 10L);
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    processExec.destroy();
                                                                                                                                    while (true) {
                                                                                                                                        if (i21 < length3) {
                                                                                                                                            str6 = strArrSplit2[i21];
                                                                                                                                            int i237 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                                                                                                            objArr9 = new Object[1];
                                                                                                                                            c(null, null, (i237 & 127) + (i237 | 127), "\u0091\u0084\u009d\u0082\u008c\u008c\u0082\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr9);
                                                                                                                                            if (str6.startsWith((String) objArr9[0])) {
                                                                                                                                                strArr2 = strArrSplit2;
                                                                                                                                            } else {
                                                                                                                                                int i238 = -(-TextUtils.getTrimmedLength(""));
                                                                                                                                                objArr10 = new Object[1];
                                                                                                                                                c(null, null, (i238 ^ 127) + ((i238 & 127) << 1), "\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr10);
                                                                                                                                                if (str6.startsWith((String) objArr10[0])) {
                                                                                                                                                    strArr2 = strArrSplit2;
                                                                                                                                                } else {
                                                                                                                                                    int i239 = -TextUtils.lastIndexOf("", '0', 0);
                                                                                                                                                    int i240 = i239 * 567;
                                                                                                                                                    int i241 = (i240 ^ (-3955)) + ((i240 & (-3955)) << 1);
                                                                                                                                                    int i242 = ~i239;
                                                                                                                                                    int i243 = ~(i242 | 7);
                                                                                                                                                    strArr2 = strArrSplit2;
                                                                                                                                                    int i244 = ~((i242 ^ i) | (i242 & i));
                                                                                                                                                    int i245 = -(-(((i243 ^ i244) | (i244 & i243)) * (-566)));
                                                                                                                                                    int i246 = (i241 ^ i245) + ((i245 & i241) << 1);
                                                                                                                                                    int i247 = -(-((~(((-8) & i239) | ((-8) ^ i239))) * 566));
                                                                                                                                                    int i248 = (i246 & i247) + (i247 | i246);
                                                                                                                                                    int i249 = (i242 ^ (-8)) | (i242 & (-8));
                                                                                                                                                    int i250 = (~((i249 & i) | (i249 ^ i))) * 566;
                                                                                                                                                    int i251 = (i248 & i250) + (i250 | i248);
                                                                                                                                                    objArr11 = new Object[1];
                                                                                                                                                    b(new int[]{884902256, -445488909, 237261781, 1198892294}, i251, objArr11);
                                                                                                                                                    if (str6.startsWith((String) objArr11[0])) {
                                                                                                                                                        int i252 = -((byte) KeyEvent.getModifierMetaStateMask());
                                                                                                                                                        Object[] objArr55 = new Object[1];
                                                                                                                                                        c(null, null, (i252 & WebSocketProtocol.PAYLOAD_SHORT) + (i252 | WebSocketProtocol.PAYLOAD_SHORT), "¢", objArr55);
                                                                                                                                                        strArrSplit3 = str6.split((String) objArr55[0]);
                                                                                                                                                        if (strArrSplit3.length > 1 && strArrSplit3[1].equalsIgnoreCase(str4)) {
                                                                                                                                                            objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                                                                                                                                            int i253 = (~(i & 20)) & (i | 20);
                                                                                                                                                            String str16 = (String) Class.forName(str2).getField(str8).get(objInvoke2);
                                                                                                                                                            ((int[]) objArr[1])[0] = i;
                                                                                                                                                            ((int[]) objArr[0])[0] = i253;
                                                                                                                                                            int i254 = (int) Runtime.getRuntime().totalMemory();
                                                                                                                                                            int i255 = ~((-33835201) | i254);
                                                                                                                                                            int i256 = ~i254;
                                                                                                                                                            int i257 = (-212792656) + ((i255 | (~((-140116259) | i256))) * 497) + (((~(i254 | (-140116259))) | (~((-42224350) | i256)) | 8389149) * 497);
                                                                                                                                                            int i258 = (-6257) - (~(-(-(i257 * (-195)))));
                                                                                                                                                            int i259 = ~i257;
                                                                                                                                                            int i260 = ~((i259 ^ 16) | (i259 & 16));
                                                                                                                                                            int i261 = ~((i257 ^ i) | (i257 & i));
                                                                                                                                                            int i262 = (i258 - (~(-(-((i260 | i261) * (-196)))))) - 1;
                                                                                                                                                            int i263 = ((i257 ^ 16) | (i257 & 16)) * 392;
                                                                                                                                                            int i264 = (i262 ^ i263) + ((i262 & i263) << 1);
                                                                                                                                                            int i265 = ~(((-17) & i259) | ((-17) ^ i259));
                                                                                                                                                            int i266 = ((i265 & i261) | (i265 ^ i261)) * 196;
                                                                                                                                                            int i267 = ((i264 | i266) << 1) - (i266 ^ i264);
                                                                                                                                                            int iD8874 = W29288.D8871();
                                                                                                                                                            int i268 = i267 * (-813);
                                                                                                                                                            int i269 = i3 * 408;
                                                                                                                                                            int i270 = (i268 & i269) + (i268 | i269);
                                                                                                                                                            int i271 = -(-(((~((~i3) | i267)) | (~(i267 | iD8874))) * (-814)));
                                                                                                                                                            int i272 = ((i270 | i271) << 1) - (i271 ^ i270);
                                                                                                                                                            int i273 = ~i3;
                                                                                                                                                            int i274 = ~iD8874;
                                                                                                                                                            int i275 = ~((i273 & i274) | (i273 ^ i274));
                                                                                                                                                            int i276 = ~i267;
                                                                                                                                                            int i277 = i275 | (~((i276 ^ i3) | (i276 & i3)));
                                                                                                                                                            int i278 = ~((i267 ^ iD8874) | (i267 & iD8874));
                                                                                                                                                            int i279 = (i272 - (~(((i277 & i278) | (i277 ^ i278)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE))) - 1;
                                                                                                                                                            int i280 = ~(i276 | i3);
                                                                                                                                                            int i281 = ~i267;
                                                                                                                                                            int i282 = ~((i281 & iD8874) | (i281 ^ iD8874));
                                                                                                                                                            int i283 = (i282 & i280) | (i280 ^ i282);
                                                                                                                                                            int i284 = ~((iD8874 & i3) | (i3 ^ iD8874));
                                                                                                                                                            int i285 = -(-(((i284 & i283) | (i283 ^ i284)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                                                                                                                                                            int i286 = (i279 ^ i285) + ((i285 & i279) << 1);
                                                                                                                                                            int i287 = i286 << 13;
                                                                                                                                                            int i288 = (i287 | i286) & (~(i286 & i287));
                                                                                                                                                            int i289 = i288 >>> 17;
                                                                                                                                                            int i290 = ((~i288) & i289) | ((~i289) & i288);
                                                                                                                                                            int i291 = i290 << 5;
                                                                                                                                                            ((int[]) objArr[4])[0] = ((~i290) & i291) | ((~i291) & i290);
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        continue;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            i21 = ((i21 ^ 3) + ((i21 & 3) << 1)) - 2;
                                                                                                                                            strArrSplit2 = strArr2;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Exception unused3) {
                                                                                                                                }
                                                                                                                                StringBuilder sb2 = new StringBuilder();
                                                                                                                                objComponent11 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                                                                                                if (objComponent11 == null) {
                                                                                                                                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 53;
                                                                                                                                    char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                                                                                                    int mode2 = View.MeasureSpec.getMode(0) + 4954;
                                                                                                                                    Object[] objArr56 = new Object[1];
                                                                                                                                    d((byte) 0, 1, $$a[4], objArr56);
                                                                                                                                    objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf, scrollBarFadeDuration, mode2, -1351202600, false, (String) objArr56[0], null);
                                                                                                                                }
                                                                                                                                sb2.append(((Field) objComponent11).get(objNewInstance).toString());
                                                                                                                                objComponent12 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                                                                                                if (objComponent12 == null) {
                                                                                                                                    int iMyTid2 = (Process.myTid() >> 22) + 52;
                                                                                                                                    char cArgb = (char) Color.argb(0, 0, 0, 0);
                                                                                                                                    int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 4954;
                                                                                                                                    Object[] objArr57 = new Object[1];
                                                                                                                                    d((byte) 0, 1, $$a[4], objArr57);
                                                                                                                                    objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid2, cArgb, windowTouchSlop2, -1351202600, false, (String) objArr57[0], null);
                                                                                                                                }
                                                                                                                                sb2.append(((Field) objComponent12).get(objNewInstance2).toString());
                                                                                                                                String string2 = sb2.toString();
                                                                                                                                Object[] objArr58 = new Object[1];
                                                                                                                                c(null, null, View.MeasureSpec.getMode(0) + 127, "\u009c", objArr58);
                                                                                                                                strArrSplit2 = string2.split((String) objArr58[0]);
                                                                                                                                length3 = strArrSplit2.length;
                                                                                                                                i21 = 0;
                                                                                                                            } catch (Exception unused4) {
                                                                                                                                Object[] objArr59 = new Object[1];
                                                                                                                                c(null, null, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 127, "\u0091\u0085\u0085\u0084\u008f\u008c\u0094\u009e \u008e \u0084\u0086\u008e\u0084\u0094\u008f \u008c\u0086 \u008d\u0084\u009d\u0095\u008e\u009f", objArr59);
                                                                                                                                throw new IOException((String) objArr59[0]);
                                                                                                                            }
                                                                                                                        } catch (Throwable th2) {
                                                                                                                            th = th2;
                                                                                                                            throw th;
                                                                                                                        }
                                                                                                                    } catch (IOException unused5) {
                                                                                                                    }
                                                                                                                } catch (Throwable th3) {
                                                                                                                    Throwable cause2 = th3.getCause();
                                                                                                                    if (cause2 != null) {
                                                                                                                        throw cause2;
                                                                                                                    }
                                                                                                                    throw th3;
                                                                                                                }
                                                                                                            } catch (Throwable th4) {
                                                                                                                Throwable cause3 = th4.getCause();
                                                                                                                if (cause3 != null) {
                                                                                                                    throw cause3;
                                                                                                                }
                                                                                                                throw th4;
                                                                                                            }
                                                                                                        } catch (Throwable th5) {
                                                                                                            th = th5;
                                                                                                            try {
                                                                                                                processExec.destroy();
                                                                                                            } catch (Exception unused6) {
                                                                                                            }
                                                                                                            throw th;
                                                                                                        }
                                                                                                    } catch (InterruptedException e2) {
                                                                                                        throw e2;
                                                                                                    } catch (Throwable th6) {
                                                                                                        th = th6;
                                                                                                    }
                                                                                                } catch (IOException unused7) {
                                                                                                    cls2 = cls2;
                                                                                                } catch (Exception unused8) {
                                                                                                    Object[] objArr510 = new Object[1];
                                                                                                    c(null, null, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 127, "\u0091\u0085\u0085\u0084\u008f\u008c\u0094\u009e \u008e \u0084\u0086\u008e\u0084\u0094\u008f \u008c\u0086 \u008d\u0084\u009d\u0095\u008e\u009f", objArr510);
                                                                                                    throw new IOException((String) objArr510[0]);
                                                                                                }
                                                                                            } catch (Throwable th7) {
                                                                                                Throwable cause4 = th7.getCause();
                                                                                                if (cause4 != null) {
                                                                                                    throw cause4;
                                                                                                }
                                                                                                throw th7;
                                                                                            }
                                                                                        } catch (Throwable th8) {
                                                                                            th = th8;
                                                                                            Throwable cause5 = th.getCause();
                                                                                            if (cause5 != null) {
                                                                                                throw cause5;
                                                                                            }
                                                                                            throw th;
                                                                                        }
                                                                                    } catch (Throwable th9) {
                                                                                        th = th9;
                                                                                    }
                                                                                } catch (Throwable th10) {
                                                                                    Throwable cause6 = th10.getCause();
                                                                                    if (cause6 != null) {
                                                                                        throw cause6;
                                                                                    }
                                                                                    throw th10;
                                                                                }
                                                                            } catch (Throwable th11) {
                                                                                Throwable cause7 = th11.getCause();
                                                                                if (cause7 != null) {
                                                                                    throw cause7;
                                                                                }
                                                                                throw th11;
                                                                            }
                                                                        } catch (IOException unused9) {
                                                                            i19 = i15;
                                                                            i20 = i17;
                                                                            str5 = str9;
                                                                            cls2 = cls2;
                                                                            int i292 = (i20 & 83) + (i20 | 83);
                                                                            i17 = (i292 & (-82)) + (i292 | (-82));
                                                                            strArrSplit = strArr;
                                                                            length2 = i18;
                                                                            i15 = i19;
                                                                            str9 = str5;
                                                                        } catch (Exception unused10) {
                                                                            Object[] objArr511 = new Object[1];
                                                                            c(null, null, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 127, "\u0091\u0085\u0085\u0084\u008f\u008c\u0094\u009e \u008e \u0084\u0086\u008e\u0084\u0094\u008f \u008c\u0086 \u008d\u0084\u009d\u0095\u008e\u009f", objArr511);
                                                                            throw new IOException((String) objArr511[0]);
                                                                        }
                                                                    } catch (Exception unused11) {
                                                                    }
                                                                } catch (Throwable th12) {
                                                                    th = th12;
                                                                    cls2 = cls2;
                                                                }
                                                            } catch (IOException unused12) {
                                                                strArr = strArrSplit;
                                                                i18 = length2;
                                                            }
                                                        }
                                                    } else {
                                                        strArr = strArrSplit;
                                                        i18 = length2;
                                                        i19 = i15;
                                                        i20 = i17;
                                                        str5 = str9;
                                                    }
                                                    int i293 = (i20 & 83) + (i20 | 83);
                                                    i17 = (i293 & (-82)) + (i293 | (-82));
                                                    strArrSplit = strArr;
                                                    length2 = i18;
                                                    i15 = i19;
                                                    str9 = str5;
                                                } else {
                                                    i4 = 5;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    String strSubstring3 = ((String) Class.forName(str2).getField(str8).get(objInvoke2)).substring(0, iIndexOf2);
                                    Object[] objArr410 = new Object[1];
                                    b(new int[]{-370238129, 1224012160}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr410);
                                    strArrSplit = strSubstring3.split((String) objArr410[0]);
                                    length2 = strArrSplit.length;
                                    i17 = 0;
                                    while (true) {
                                        if (i17 < length2) {
                                            str4 = strArrSplit[i17];
                                            int i2010 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                                            objArr8 = new Object[1];
                                            c(null, null, (i2010 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i2010 & WebSocketProtocol.PAYLOAD_SHORT) << 1), "\u009a\u0091\u0099", objArr8);
                                            if (str4.split((String) objArr8[0]).length > 1) {
                                                cls2 = (Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) View.MeasureSpec.getSize(0), View.getDefaultSize(0, 0) + 5110);
                                                synchronized (cls2) {
                                                    Object[] objArr411 = new Object[1];
                                                    b(new int[]{-346996579, 219547197, -186167191, -72341611, 884902256, -445488909, 562084749, -757193151}, 15 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr411);
                                                    String str17 = (String) objArr411[0];
                                                    Runtime runtime2 = Runtime.getRuntime();
                                                    int i2011 = -Gravity.getAbsoluteGravity(0, 0);
                                                    strArr = strArrSplit;
                                                    i18 = length2;
                                                    Object[] objArr412 = new Object[1];
                                                    c(null, null, (i2011 ^ 127) + ((i2011 & 127) << 1), "\u009b\u0085", objArr412);
                                                    processExec = runtime2.exec((String) objArr412[0], (String[]) null, (File) null);
                                                    Object[] objArr413 = {processExec.getInputStream()};
                                                    objComponent9 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                    if (objComponent9 == null) {
                                                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.combineMeasuredStates(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0, 0) + 4955, 2119435613, false, null, new Class[]{InputStream.class});
                                                    }
                                                    Object objNewInstance3 = ((Constructor) objComponent9).newInstance(objArr413);
                                                    Object[] objArr414 = {processExec.getErrorStream()};
                                                    objComponent10 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                    if (objComponent10 == null) {
                                                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                    }
                                                    Object objNewInstance4 = ((Constructor) objComponent10).newInstance(objArr414);
                                                    DataOutputStream dataOutputStream2 = new DataOutputStream(processExec.getOutputStream());
                                                    Class<?> cls10 = Class.forName(str9);
                                                    i19 = i15;
                                                    i20 = i17;
                                                    str5 = str9;
                                                    int pressedStateDuration2 = ViewConfiguration.getPressedStateDuration() >> 16;
                                                    int i2110 = ((pressedStateDuration2 | 5) << 1) - (pressedStateDuration2 ^ 5);
                                                    Object[] objArr415 = new Object[1];
                                                    b(new int[]{860083988, 631234207, -805559575, 1233196272}, i2110, objArr415);
                                                    cls10.getMethod((String) objArr415[0], null).invoke(objNewInstance3, null);
                                                    Class<?> cls11 = Class.forName(str5);
                                                    int i2111 = -(-Color.blue(0));
                                                    int i2112 = (i2111 & 5) + (i2111 | 5);
                                                    Object[] objArr416 = new Object[1];
                                                    b(new int[]{860083988, 631234207, -805559575, 1233196272}, i2112, objArr416);
                                                    cls11.getMethod((String) objArr416[0], null).invoke(objNewInstance4, null);
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(str17);
                                                    int i2113 = -(-Color.blue(0));
                                                    Object[] objArr417 = new Object[1];
                                                    c(null, null, (i2113 & 127) + (i2113 | 127), "\u009c", objArr417);
                                                    sb3.append((String) objArr417[0]);
                                                    String string3 = sb3.toString();
                                                    Object[] objArr418 = new Object[1];
                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, Color.argb(0, 0, 0, 0) + 5, objArr418);
                                                    dataOutputStream2.write(string3.getBytes((String) objArr418[0]));
                                                    dataOutputStream2.flush();
                                                    Object[] objArr419 = new Object[1];
                                                    c(null, null, 127 - (~(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), "\u009c\u0086\u0095\u0093\u0084", objArr419);
                                                    String str18 = (String) objArr419[0];
                                                    int i2114 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                    int i2115 = (i2114 & 6) + (i2114 | 6);
                                                    Object[] objArr512 = new Object[1];
                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, i2115, objArr512);
                                                    dataOutputStream2.write(str18.getBytes((String) objArr512[0]));
                                                    dataOutputStream2.flush();
                                                    long jNanoTime3 = System.nanoTime();
                                                    TimeUnit timeUnit4 = TimeUnit.MILLISECONDS;
                                                    long jNanoTime4 = 2000000000;
                                                    while (true) {
                                                        processExec.exitValue();
                                                        cls2 = cls2;
                                                        break;
                                                    }
                                                    dataOutputStream2.close();
                                                    Class<?> cls12 = Class.forName(str5);
                                                    int i2116 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                    int i2117 = i2116 * (-375);
                                                    int i2118 = ((i2117 | (-1500)) << 1) - (i2117 ^ (-1500));
                                                    int i2119 = ~i2116;
                                                    int i2210 = ~((i2119 ^ (-5)) | (i2119 & (-5)));
                                                    int i2211 = ~((i2116 ^ 4) | (i2116 & 4));
                                                    int i2212 = -(-(((i ^ i2210) | (i2210 & i) | i2211) * 376));
                                                    int i2213 = (i2118 & i2212) + (i2118 | i2212);
                                                    int i2214 = -(-((i2211 | (~(i19 | i2116))) * (-376)));
                                                    int i2215 = (i2213 ^ i2214) + ((i2213 & i2214) << 1);
                                                    int i2216 = ~((i2119 ^ i) | (i2119 & i));
                                                    int i2217 = i2215 + (((i2216 & 4) | (i2216 ^ 4)) * 376);
                                                    Object[] objArr513 = new Object[1];
                                                    b(new int[]{145536241, 1034981249}, i2217, objArr513);
                                                    cls12.getMethod((String) objArr513[0], Long.TYPE).invoke(objNewInstance3, 100L);
                                                    Class<?> cls13 = Class.forName(str5);
                                                    int iRgb3 = Color.rgb(0, 0, 0);
                                                    int i2218 = iRgb3 * (-419);
                                                    int i2219 = ((i2218 | (-1526724972)) << 1) - (i2218 ^ (-1526724972));
                                                    int i2310 = (~(i | 16777220)) * 420;
                                                    int i2311 = ((i2219 | i2310) << 1) - (i2310 ^ i2219);
                                                    int i2312 = ~iRgb3;
                                                    int i2313 = ((i2312 ^ 16777220) | (i2312 & 16777220)) * (-420);
                                                    int i2314 = (i2311 ^ i2313) + ((i2311 & i2313) << 1);
                                                    int i2315 = ((~((i2312 ^ (-16777221)) | (i2312 & (-16777221)))) | (~(i19 | 16777220))) * 420;
                                                    int i2316 = (i2314 & i2315) + (i2315 | i2314);
                                                    Object[] objArr514 = new Object[1];
                                                    b(new int[]{145536241, 1034981249}, i2316, objArr514);
                                                    cls13.getMethod((String) objArr514[0], Long.TYPE).invoke(objNewInstance4, 10L);
                                                    processExec.destroy();
                                                    StringBuilder sb4 = new StringBuilder();
                                                    objComponent11 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                    if (objComponent11 == null) {
                                                        int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 53;
                                                        char scrollBarFadeDuration2 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                        int mode3 = View.MeasureSpec.getMode(0) + 4954;
                                                        Object[] objArr515 = new Object[1];
                                                        d((byte) 0, 1, $$a[4], objArr515);
                                                        objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf2, scrollBarFadeDuration2, mode3, -1351202600, false, (String) objArr515[0], null);
                                                    }
                                                    sb4.append(((Field) objComponent11).get(objNewInstance3).toString());
                                                    objComponent12 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                    if (objComponent12 == null) {
                                                        int iMyTid3 = (Process.myTid() >> 22) + 52;
                                                        char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                                                        int windowTouchSlop3 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 4954;
                                                        Object[] objArr516 = new Object[1];
                                                        d((byte) 0, 1, $$a[4], objArr516);
                                                        objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid3, cArgb2, windowTouchSlop3, -1351202600, false, (String) objArr516[0], null);
                                                    }
                                                    sb4.append(((Field) objComponent12).get(objNewInstance4).toString());
                                                    String string4 = sb4.toString();
                                                    Object[] objArr517 = new Object[1];
                                                    c(null, null, View.MeasureSpec.getMode(0) + 127, "\u009c", objArr517);
                                                    strArrSplit2 = string4.split((String) objArr517[0]);
                                                    length3 = strArrSplit2.length;
                                                    i21 = 0;
                                                    while (true) {
                                                        if (i21 < length3) {
                                                            str6 = strArrSplit2[i21];
                                                            int i2317 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                            objArr9 = new Object[1];
                                                            c(null, null, (i2317 & 127) + (i2317 | 127), "\u0091\u0084\u009d\u0082\u008c\u008c\u0082\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr9);
                                                            if (str6.startsWith((String) objArr9[0])) {
                                                                int i2318 = -(-TextUtils.getTrimmedLength(""));
                                                                objArr10 = new Object[1];
                                                                c(null, null, (i2318 ^ 127) + ((i2318 & 127) << 1), "\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr10);
                                                                if (str6.startsWith((String) objArr10[0])) {
                                                                    int i2319 = -TextUtils.lastIndexOf("", '0', 0);
                                                                    int i2410 = i2319 * 567;
                                                                    int i2411 = (i2410 ^ (-3955)) + ((i2410 & (-3955)) << 1);
                                                                    int i2412 = ~i2319;
                                                                    int i2413 = ~(i2412 | 7);
                                                                    strArr2 = strArrSplit2;
                                                                    int i2414 = ~((i2412 ^ i) | (i2412 & i));
                                                                    int i2415 = -(-(((i2413 ^ i2414) | (i2414 & i2413)) * (-566)));
                                                                    int i2416 = (i2411 ^ i2415) + ((i2415 & i2411) << 1);
                                                                    int i2417 = -(-((~(((-8) & i2319) | ((-8) ^ i2319))) * 566));
                                                                    int i2418 = (i2416 & i2417) + (i2417 | i2416);
                                                                    int i2419 = (i2412 ^ (-8)) | (i2412 & (-8));
                                                                    int i2510 = (~((i2419 & i) | (i2419 ^ i))) * 566;
                                                                    int i2511 = (i2418 & i2510) + (i2510 | i2418);
                                                                    objArr11 = new Object[1];
                                                                    b(new int[]{884902256, -445488909, 237261781, 1198892294}, i2511, objArr11);
                                                                    if (str6.startsWith((String) objArr11[0])) {
                                                                        int i2512 = -((byte) KeyEvent.getModifierMetaStateMask());
                                                                        Object[] objArr518 = new Object[1];
                                                                        c(null, null, (i2512 & WebSocketProtocol.PAYLOAD_SHORT) + (i2512 | WebSocketProtocol.PAYLOAD_SHORT), "¢", objArr518);
                                                                        strArrSplit3 = str6.split((String) objArr518[0]);
                                                                        if (strArrSplit3.length > 1) {
                                                                            continue;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                } else {
                                                                    strArr2 = strArrSplit2;
                                                                }
                                                            } else {
                                                                strArr2 = strArrSplit2;
                                                            }
                                                            i21 = ((i21 ^ 3) + ((i21 & 3) << 1)) - 2;
                                                            strArrSplit2 = strArr2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                strArr = strArrSplit;
                                                i18 = length2;
                                                i19 = i15;
                                                i20 = i17;
                                                str5 = str9;
                                            }
                                            int i294 = (i20 & 83) + (i20 | 83);
                                            i17 = (i294 & (-82)) + (i294 | (-82));
                                            strArrSplit = strArr;
                                            length2 = i18;
                                            i15 = i19;
                                            str9 = str5;
                                        } else {
                                            i4 = 5;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        str2 = str7;
                        c = '\r';
                        str3 = (String) Class.forName(str2).getField(str8).get(objInvoke2);
                        int length6 = str3.length();
                        int i1910 = (length6 ^ i) | (length6 & i);
                        int i1911 = (-3768) + (length6 * 628) + (((i1910 & 5) | (i1910 ^ 5)) * (-627));
                        int i1912 = ~length6;
                        int i1913 = ~((i1912 & i) | (i1912 ^ i));
                        int i1914 = i1911 + (((i1913 & (-6)) | ((-6) ^ i1913)) * (-627));
                        i15 = ~i;
                        int i2012 = ~((length6 & i15) | (i15 ^ length6));
                        int i2013 = ~(((-6) & i) | ((-6) ^ i));
                        i16 = i1914 + (((i2012 & i2013) | (i2012 ^ i2013)) * 627);
                        if (i16 >= 0) {
                            i22 = 0;
                            while (true) {
                                if (i22 <= i16) {
                                    Object[] objArr310 = {str3.substring(i22, i22 + 6), 931995};
                                    objComponent13 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                    if (objComponent13 == null) {
                                        int size2 = View.MeasureSpec.getSize(0) + 52;
                                        char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                                        int minimumFlingVelocity2 = 5420 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                        Object[] objArr311 = new Object[1];
                                        d((byte) ($$a[13] + 1), 0, (short) 1, objArr311);
                                        objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(size2, cMakeMeasureSpec2, minimumFlingVelocity2, 1884899413, false, (String) objArr311[0], new Class[]{String.class, Integer.TYPE});
                                    }
                                    long jLongValue7 = ((Long) ((Method) objComponent13).invoke(null, objArr310)).longValue();
                                    long j110 = (-261433052720L) + ((-755) * jLongValue7);
                                    long j111 = ((-346268945) | (jLongValue7 ^ (-1))) ^ (-1);
                                    long j23 = 346268944 | jLongValue7;
                                    long j24 = i;
                                    long j25 = j110 + (1512 * j111) + ((-756) * (j111 | ((j23 | j24) ^ (-1)))) + (756 * (j23 | (j24 ^ (-1)))) + 160884169;
                                    i23 = ((int) (j25 >> 32)) & ((-1161076794) + ((i | 8391040) * 988) + ((285745156 | (~((-1567547501) | i15))) * (-1976)) + ((8391040 | (~(1290193384 | i)) | (~((-1290193385) | i15))) * 988));
                                    i24 = (int) j25;
                                    elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                    i25 = ~elapsedCpuTime;
                                    if ((i23 | (i24 & (1269207234 + (((-23488532) | (~(1413737878 | i25))) * (-602)) + (((~(elapsedCpuTime | 1413737878)) | (-1432874392) | (~((-4352019) | i25))) * (-301)) + ((~(i25 | (-23488532))) * 301)))) == -2096167706) {
                                        objArr = new Object[]{new int[1], new int[1], str13, null, new int[1]};
                                        String str19 = (String) Class.forName(str2).getField(str8).get(objInvoke2);
                                        ((int[]) objArr[1])[0] = i;
                                        ((int[]) objArr[0])[0] = (i & (-21)) | (i15 & 20);
                                        int i2014 = (i3 - (~(((((-556828460) + (((~((-187085563) | i15)) | (-29090246)) * (-865))) + ((~(i | 187085562)) * 865)) + (((~(187085562 | i15)) | (~((-29090246) | i15))) * 865)) + 16))) - 1;
                                        int i2015 = i2014 << 13;
                                        int i2016 = ((~i2014) & i2015) | ((~i2015) & i2014);
                                        int i2017 = i2016 >>> 17;
                                        int i2018 = ((~i2016) & i2017) | ((~i2017) & i2016);
                                        int i2019 = i2018 << 5;
                                        ((int[]) objArr[4])[0] = (i2018 | i2019) & (~(i2018 & i2019));
                                    } else {
                                        i22 = ((i22 | 1) << 1) - (i22 ^ 1);
                                        str3 = str3;
                                    }
                                } else {
                                    String strSubstring4 = ((String) Class.forName(str2).getField(str8).get(objInvoke2)).substring(0, iIndexOf2);
                                    Object[] objArr4110 = new Object[1];
                                    b(new int[]{-370238129, 1224012160}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr4110);
                                    strArrSplit = strSubstring4.split((String) objArr4110[0]);
                                    length2 = strArrSplit.length;
                                    i17 = 0;
                                    while (true) {
                                        if (i17 < length2) {
                                            str4 = strArrSplit[i17];
                                            int i20110 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                                            objArr8 = new Object[1];
                                            c(null, null, (i20110 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i20110 & WebSocketProtocol.PAYLOAD_SHORT) << 1), "\u009a\u0091\u0099", objArr8);
                                            if (str4.split((String) objArr8[0]).length > 1) {
                                                cls2 = (Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) View.MeasureSpec.getSize(0), View.getDefaultSize(0, 0) + 5110);
                                                synchronized (cls2) {
                                                    Object[] objArr4111 = new Object[1];
                                                    b(new int[]{-346996579, 219547197, -186167191, -72341611, 884902256, -445488909, 562084749, -757193151}, 15 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr4111);
                                                    String str110 = (String) objArr4111[0];
                                                    Runtime runtime3 = Runtime.getRuntime();
                                                    int i20111 = -Gravity.getAbsoluteGravity(0, 0);
                                                    strArr = strArrSplit;
                                                    i18 = length2;
                                                    Object[] objArr4112 = new Object[1];
                                                    c(null, null, (i20111 ^ 127) + ((i20111 & 127) << 1), "\u009b\u0085", objArr4112);
                                                    processExec = runtime3.exec((String) objArr4112[0], (String[]) null, (File) null);
                                                    Object[] objArr4113 = {processExec.getInputStream()};
                                                    objComponent9 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                    if (objComponent9 == null) {
                                                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.combineMeasuredStates(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0, 0) + 4955, 2119435613, false, null, new Class[]{InputStream.class});
                                                    }
                                                    Object objNewInstance5 = ((Constructor) objComponent9).newInstance(objArr4113);
                                                    Object[] objArr4114 = {processExec.getErrorStream()};
                                                    objComponent10 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                    if (objComponent10 == null) {
                                                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                    }
                                                    Object objNewInstance6 = ((Constructor) objComponent10).newInstance(objArr4114);
                                                    DataOutputStream dataOutputStream3 = new DataOutputStream(processExec.getOutputStream());
                                                    Class<?> cls14 = Class.forName(str9);
                                                    i19 = i15;
                                                    i20 = i17;
                                                    str5 = str9;
                                                    int pressedStateDuration3 = ViewConfiguration.getPressedStateDuration() >> 16;
                                                    int i21110 = ((pressedStateDuration3 | 5) << 1) - (pressedStateDuration3 ^ 5);
                                                    Object[] objArr4115 = new Object[1];
                                                    b(new int[]{860083988, 631234207, -805559575, 1233196272}, i21110, objArr4115);
                                                    cls14.getMethod((String) objArr4115[0], null).invoke(objNewInstance5, null);
                                                    Class<?> cls15 = Class.forName(str5);
                                                    int i21111 = -(-Color.blue(0));
                                                    int i21112 = (i21111 & 5) + (i21111 | 5);
                                                    Object[] objArr4116 = new Object[1];
                                                    b(new int[]{860083988, 631234207, -805559575, 1233196272}, i21112, objArr4116);
                                                    cls15.getMethod((String) objArr4116[0], null).invoke(objNewInstance6, null);
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append(str110);
                                                    int i21113 = -(-Color.blue(0));
                                                    Object[] objArr4117 = new Object[1];
                                                    c(null, null, (i21113 & 127) + (i21113 | 127), "\u009c", objArr4117);
                                                    sb5.append((String) objArr4117[0]);
                                                    String string5 = sb5.toString();
                                                    Object[] objArr4118 = new Object[1];
                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, Color.argb(0, 0, 0, 0) + 5, objArr4118);
                                                    dataOutputStream3.write(string5.getBytes((String) objArr4118[0]));
                                                    dataOutputStream3.flush();
                                                    Object[] objArr4119 = new Object[1];
                                                    c(null, null, 127 - (~(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), "\u009c\u0086\u0095\u0093\u0084", objArr4119);
                                                    String str111 = (String) objArr4119[0];
                                                    int i21114 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                    int i21115 = (i21114 & 6) + (i21114 | 6);
                                                    Object[] objArr519 = new Object[1];
                                                    b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, i21115, objArr519);
                                                    dataOutputStream3.write(str111.getBytes((String) objArr519[0]));
                                                    dataOutputStream3.flush();
                                                    long jNanoTime5 = System.nanoTime();
                                                    TimeUnit timeUnit5 = TimeUnit.MILLISECONDS;
                                                    long jNanoTime6 = 2000000000;
                                                    while (true) {
                                                        processExec.exitValue();
                                                        cls2 = cls2;
                                                        break;
                                                    }
                                                    dataOutputStream3.close();
                                                    Class<?> cls16 = Class.forName(str5);
                                                    int i21116 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                    int i21117 = i21116 * (-375);
                                                    int i21118 = ((i21117 | (-1500)) << 1) - (i21117 ^ (-1500));
                                                    int i21119 = ~i21116;
                                                    int i22110 = ~((i21119 ^ (-5)) | (i21119 & (-5)));
                                                    int i22111 = ~((i21116 ^ 4) | (i21116 & 4));
                                                    int i22112 = -(-(((i ^ i22110) | (i22110 & i) | i22111) * 376));
                                                    int i22113 = (i21118 & i22112) + (i21118 | i22112);
                                                    int i22114 = -(-((i22111 | (~(i19 | i21116))) * (-376)));
                                                    int i22115 = (i22113 ^ i22114) + ((i22113 & i22114) << 1);
                                                    int i22116 = ~((i21119 ^ i) | (i21119 & i));
                                                    int i22117 = i22115 + (((i22116 & 4) | (i22116 ^ 4)) * 376);
                                                    Object[] objArr5110 = new Object[1];
                                                    b(new int[]{145536241, 1034981249}, i22117, objArr5110);
                                                    cls16.getMethod((String) objArr5110[0], Long.TYPE).invoke(objNewInstance5, 100L);
                                                    Class<?> cls17 = Class.forName(str5);
                                                    int iRgb4 = Color.rgb(0, 0, 0);
                                                    int i22118 = iRgb4 * (-419);
                                                    int i22119 = ((i22118 | (-1526724972)) << 1) - (i22118 ^ (-1526724972));
                                                    int i23110 = (~(i | 16777220)) * 420;
                                                    int i23111 = ((i22119 | i23110) << 1) - (i23110 ^ i22119);
                                                    int i23112 = ~iRgb4;
                                                    int i23113 = ((i23112 ^ 16777220) | (i23112 & 16777220)) * (-420);
                                                    int i23114 = (i23111 ^ i23113) + ((i23111 & i23113) << 1);
                                                    int i23115 = ((~((i23112 ^ (-16777221)) | (i23112 & (-16777221)))) | (~(i19 | 16777220))) * 420;
                                                    int i23116 = (i23114 & i23115) + (i23115 | i23114);
                                                    Object[] objArr5111 = new Object[1];
                                                    b(new int[]{145536241, 1034981249}, i23116, objArr5111);
                                                    cls17.getMethod((String) objArr5111[0], Long.TYPE).invoke(objNewInstance6, 10L);
                                                    processExec.destroy();
                                                    StringBuilder sb6 = new StringBuilder();
                                                    objComponent11 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                    if (objComponent11 == null) {
                                                        int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 53;
                                                        char scrollBarFadeDuration3 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                        int mode4 = View.MeasureSpec.getMode(0) + 4954;
                                                        Object[] objArr5112 = new Object[1];
                                                        d((byte) 0, 1, $$a[4], objArr5112);
                                                        objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf3, scrollBarFadeDuration3, mode4, -1351202600, false, (String) objArr5112[0], null);
                                                    }
                                                    sb6.append(((Field) objComponent11).get(objNewInstance5).toString());
                                                    objComponent12 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                    if (objComponent12 == null) {
                                                        int iMyTid4 = (Process.myTid() >> 22) + 52;
                                                        char cArgb3 = (char) Color.argb(0, 0, 0, 0);
                                                        int windowTouchSlop4 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 4954;
                                                        Object[] objArr5113 = new Object[1];
                                                        d((byte) 0, 1, $$a[4], objArr5113);
                                                        objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid4, cArgb3, windowTouchSlop4, -1351202600, false, (String) objArr5113[0], null);
                                                    }
                                                    sb6.append(((Field) objComponent12).get(objNewInstance6).toString());
                                                    String string6 = sb6.toString();
                                                    Object[] objArr5114 = new Object[1];
                                                    c(null, null, View.MeasureSpec.getMode(0) + 127, "\u009c", objArr5114);
                                                    strArrSplit2 = string6.split((String) objArr5114[0]);
                                                    length3 = strArrSplit2.length;
                                                    i21 = 0;
                                                    while (true) {
                                                        if (i21 < length3) {
                                                            str6 = strArrSplit2[i21];
                                                            int i23117 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                            objArr9 = new Object[1];
                                                            c(null, null, (i23117 & 127) + (i23117 | 127), "\u0091\u0084\u009d\u0082\u008c\u008c\u0082\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr9);
                                                            if (str6.startsWith((String) objArr9[0])) {
                                                                int i23118 = -(-TextUtils.getTrimmedLength(""));
                                                                objArr10 = new Object[1];
                                                                c(null, null, (i23118 ^ 127) + ((i23118 & 127) << 1), "\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr10);
                                                                if (str6.startsWith((String) objArr10[0])) {
                                                                    int i23119 = -TextUtils.lastIndexOf("", '0', 0);
                                                                    int i24110 = i23119 * 567;
                                                                    int i24111 = (i24110 ^ (-3955)) + ((i24110 & (-3955)) << 1);
                                                                    int i24112 = ~i23119;
                                                                    int i24113 = ~(i24112 | 7);
                                                                    strArr2 = strArrSplit2;
                                                                    int i24114 = ~((i24112 ^ i) | (i24112 & i));
                                                                    int i24115 = -(-(((i24113 ^ i24114) | (i24114 & i24113)) * (-566)));
                                                                    int i24116 = (i24111 ^ i24115) + ((i24115 & i24111) << 1);
                                                                    int i24117 = -(-((~(((-8) & i23119) | ((-8) ^ i23119))) * 566));
                                                                    int i24118 = (i24116 & i24117) + (i24117 | i24116);
                                                                    int i24119 = (i24112 ^ (-8)) | (i24112 & (-8));
                                                                    int i2513 = (~((i24119 & i) | (i24119 ^ i))) * 566;
                                                                    int i2514 = (i24118 & i2513) + (i2513 | i24118);
                                                                    objArr11 = new Object[1];
                                                                    b(new int[]{884902256, -445488909, 237261781, 1198892294}, i2514, objArr11);
                                                                    if (str6.startsWith((String) objArr11[0])) {
                                                                        int i2515 = -((byte) KeyEvent.getModifierMetaStateMask());
                                                                        Object[] objArr5115 = new Object[1];
                                                                        c(null, null, (i2515 & WebSocketProtocol.PAYLOAD_SHORT) + (i2515 | WebSocketProtocol.PAYLOAD_SHORT), "¢", objArr5115);
                                                                        strArrSplit3 = str6.split((String) objArr5115[0]);
                                                                        if (strArrSplit3.length > 1) {
                                                                            continue;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                } else {
                                                                    strArr2 = strArrSplit2;
                                                                }
                                                            } else {
                                                                strArr2 = strArrSplit2;
                                                            }
                                                            i21 = ((i21 ^ 3) + ((i21 & 3) << 1)) - 2;
                                                            strArrSplit2 = strArr2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                strArr = strArrSplit;
                                                i18 = length2;
                                                i19 = i15;
                                                i20 = i17;
                                                str5 = str9;
                                            }
                                            int i295 = (i20 & 83) + (i20 | 83);
                                            i17 = (i295 & (-82)) + (i295 | (-82));
                                            strArrSplit = strArr;
                                            length2 = i18;
                                            i15 = i19;
                                            str9 = str5;
                                        } else {
                                            i4 = 5;
                                        }
                                    }
                                }
                            }
                        } else {
                            String strSubstring5 = ((String) Class.forName(str2).getField(str8).get(objInvoke2)).substring(0, iIndexOf2);
                            Object[] objArr41110 = new Object[1];
                            b(new int[]{-370238129, 1224012160}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr41110);
                            strArrSplit = strSubstring5.split((String) objArr41110[0]);
                            length2 = strArrSplit.length;
                            i17 = 0;
                            while (true) {
                                if (i17 < length2) {
                                    str4 = strArrSplit[i17];
                                    int i20112 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                                    objArr8 = new Object[1];
                                    c(null, null, (i20112 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i20112 & WebSocketProtocol.PAYLOAD_SHORT) << 1), "\u009a\u0091\u0099", objArr8);
                                    if (str4.split((String) objArr8[0]).length > 1) {
                                        cls2 = (Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) View.MeasureSpec.getSize(0), View.getDefaultSize(0, 0) + 5110);
                                        synchronized (cls2) {
                                            Object[] objArr41111 = new Object[1];
                                            b(new int[]{-346996579, 219547197, -186167191, -72341611, 884902256, -445488909, 562084749, -757193151}, 15 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr41111);
                                            String str112 = (String) objArr41111[0];
                                            Runtime runtime4 = Runtime.getRuntime();
                                            int i20113 = -Gravity.getAbsoluteGravity(0, 0);
                                            strArr = strArrSplit;
                                            i18 = length2;
                                            Object[] objArr41112 = new Object[1];
                                            c(null, null, (i20113 ^ 127) + ((i20113 & 127) << 1), "\u009b\u0085", objArr41112);
                                            processExec = runtime4.exec((String) objArr41112[0], (String[]) null, (File) null);
                                            Object[] objArr41113 = {processExec.getInputStream()};
                                            objComponent9 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                            if (objComponent9 == null) {
                                                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.combineMeasuredStates(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0, 0) + 4955, 2119435613, false, null, new Class[]{InputStream.class});
                                            }
                                            Object objNewInstance7 = ((Constructor) objComponent9).newInstance(objArr41113);
                                            Object[] objArr41114 = {processExec.getErrorStream()};
                                            objComponent10 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                            if (objComponent10 == null) {
                                                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                            }
                                            Object objNewInstance8 = ((Constructor) objComponent10).newInstance(objArr41114);
                                            DataOutputStream dataOutputStream4 = new DataOutputStream(processExec.getOutputStream());
                                            Class<?> cls18 = Class.forName(str9);
                                            i19 = i15;
                                            i20 = i17;
                                            str5 = str9;
                                            int pressedStateDuration4 = ViewConfiguration.getPressedStateDuration() >> 16;
                                            int i211110 = ((pressedStateDuration4 | 5) << 1) - (pressedStateDuration4 ^ 5);
                                            Object[] objArr41115 = new Object[1];
                                            b(new int[]{860083988, 631234207, -805559575, 1233196272}, i211110, objArr41115);
                                            cls18.getMethod((String) objArr41115[0], null).invoke(objNewInstance7, null);
                                            Class<?> cls19 = Class.forName(str5);
                                            int i211111 = -(-Color.blue(0));
                                            int i211112 = (i211111 & 5) + (i211111 | 5);
                                            Object[] objArr41116 = new Object[1];
                                            b(new int[]{860083988, 631234207, -805559575, 1233196272}, i211112, objArr41116);
                                            cls19.getMethod((String) objArr41116[0], null).invoke(objNewInstance8, null);
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append(str112);
                                            int i211113 = -(-Color.blue(0));
                                            Object[] objArr41117 = new Object[1];
                                            c(null, null, (i211113 & 127) + (i211113 | 127), "\u009c", objArr41117);
                                            sb7.append((String) objArr41117[0]);
                                            String string7 = sb7.toString();
                                            Object[] objArr41118 = new Object[1];
                                            b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, Color.argb(0, 0, 0, 0) + 5, objArr41118);
                                            dataOutputStream4.write(string7.getBytes((String) objArr41118[0]));
                                            dataOutputStream4.flush();
                                            Object[] objArr41119 = new Object[1];
                                            c(null, null, 127 - (~(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), "\u009c\u0086\u0095\u0093\u0084", objArr41119);
                                            String str113 = (String) objArr41119[0];
                                            int i211114 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                            int i211115 = (i211114 & 6) + (i211114 | 6);
                                            Object[] objArr5116 = new Object[1];
                                            b(new int[]{-1470376570, 276966239, -1140142976, 1025506205}, i211115, objArr5116);
                                            dataOutputStream4.write(str113.getBytes((String) objArr5116[0]));
                                            dataOutputStream4.flush();
                                            long jNanoTime7 = System.nanoTime();
                                            TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
                                            long jNanoTime8 = 2000000000;
                                            while (true) {
                                                processExec.exitValue();
                                                cls2 = cls2;
                                                break;
                                            }
                                            dataOutputStream4.close();
                                            Class<?> cls110 = Class.forName(str5);
                                            int i211116 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                            int i211117 = i211116 * (-375);
                                            int i211118 = ((i211117 | (-1500)) << 1) - (i211117 ^ (-1500));
                                            int i211119 = ~i211116;
                                            int i221110 = ~((i211119 ^ (-5)) | (i211119 & (-5)));
                                            int i221111 = ~((i211116 ^ 4) | (i211116 & 4));
                                            int i221112 = -(-(((i ^ i221110) | (i221110 & i) | i221111) * 376));
                                            int i221113 = (i211118 & i221112) + (i211118 | i221112);
                                            int i221114 = -(-((i221111 | (~(i19 | i211116))) * (-376)));
                                            int i221115 = (i221113 ^ i221114) + ((i221113 & i221114) << 1);
                                            int i221116 = ~((i211119 ^ i) | (i211119 & i));
                                            int i221117 = i221115 + (((i221116 & 4) | (i221116 ^ 4)) * 376);
                                            Object[] objArr5117 = new Object[1];
                                            b(new int[]{145536241, 1034981249}, i221117, objArr5117);
                                            cls110.getMethod((String) objArr5117[0], Long.TYPE).invoke(objNewInstance7, 100L);
                                            Class<?> cls111 = Class.forName(str5);
                                            int iRgb5 = Color.rgb(0, 0, 0);
                                            int i221118 = iRgb5 * (-419);
                                            int i221119 = ((i221118 | (-1526724972)) << 1) - (i221118 ^ (-1526724972));
                                            int i231110 = (~(i | 16777220)) * 420;
                                            int i231111 = ((i221119 | i231110) << 1) - (i231110 ^ i221119);
                                            int i231112 = ~iRgb5;
                                            int i231113 = ((i231112 ^ 16777220) | (i231112 & 16777220)) * (-420);
                                            int i231114 = (i231111 ^ i231113) + ((i231111 & i231113) << 1);
                                            int i231115 = ((~((i231112 ^ (-16777221)) | (i231112 & (-16777221)))) | (~(i19 | 16777220))) * 420;
                                            int i231116 = (i231114 & i231115) + (i231115 | i231114);
                                            Object[] objArr5118 = new Object[1];
                                            b(new int[]{145536241, 1034981249}, i231116, objArr5118);
                                            cls111.getMethod((String) objArr5118[0], Long.TYPE).invoke(objNewInstance8, 10L);
                                            processExec.destroy();
                                            StringBuilder sb8 = new StringBuilder();
                                            objComponent11 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                            if (objComponent11 == null) {
                                                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0) + 53;
                                                char scrollBarFadeDuration4 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                int mode5 = View.MeasureSpec.getMode(0) + 4954;
                                                Object[] objArr5119 = new Object[1];
                                                d((byte) 0, 1, $$a[4], objArr5119);
                                                objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf4, scrollBarFadeDuration4, mode5, -1351202600, false, (String) objArr5119[0], null);
                                            }
                                            sb8.append(((Field) objComponent11).get(objNewInstance7).toString());
                                            objComponent12 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                            if (objComponent12 == null) {
                                                int iMyTid5 = (Process.myTid() >> 22) + 52;
                                                char cArgb4 = (char) Color.argb(0, 0, 0, 0);
                                                int windowTouchSlop5 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 4954;
                                                Object[] objArr51110 = new Object[1];
                                                d((byte) 0, 1, $$a[4], objArr51110);
                                                objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid5, cArgb4, windowTouchSlop5, -1351202600, false, (String) objArr51110[0], null);
                                            }
                                            sb8.append(((Field) objComponent12).get(objNewInstance8).toString());
                                            String string8 = sb8.toString();
                                            Object[] objArr51111 = new Object[1];
                                            c(null, null, View.MeasureSpec.getMode(0) + 127, "\u009c", objArr51111);
                                            strArrSplit2 = string8.split((String) objArr51111[0]);
                                            length3 = strArrSplit2.length;
                                            i21 = 0;
                                            while (true) {
                                                if (i21 < length3) {
                                                    str6 = strArrSplit2[i21];
                                                    int i231117 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                    objArr9 = new Object[1];
                                                    c(null, null, (i231117 & 127) + (i231117 | 127), "\u0091\u0084\u009d\u0082\u008c\u008c\u0082\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr9);
                                                    if (str6.startsWith((String) objArr9[0])) {
                                                        int i231118 = -(-TextUtils.getTrimmedLength(""));
                                                        objArr10 = new Object[1];
                                                        c(null, null, (i231118 ^ 127) + ((i231118 & 127) << 1), "\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0090\u008c\u008f¢\u0084\u0082\u008e¡\u008f\u008e\u009e", objArr10);
                                                        if (str6.startsWith((String) objArr10[0])) {
                                                            int i231119 = -TextUtils.lastIndexOf("", '0', 0);
                                                            int i241110 = i231119 * 567;
                                                            int i241111 = (i241110 ^ (-3955)) + ((i241110 & (-3955)) << 1);
                                                            int i241112 = ~i231119;
                                                            int i241113 = ~(i241112 | 7);
                                                            strArr2 = strArrSplit2;
                                                            int i241114 = ~((i241112 ^ i) | (i241112 & i));
                                                            int i241115 = -(-(((i241113 ^ i241114) | (i241114 & i241113)) * (-566)));
                                                            int i241116 = (i241111 ^ i241115) + ((i241115 & i241111) << 1);
                                                            int i241117 = -(-((~(((-8) & i231119) | ((-8) ^ i231119))) * 566));
                                                            int i241118 = (i241116 & i241117) + (i241117 | i241116);
                                                            int i241119 = (i241112 ^ (-8)) | (i241112 & (-8));
                                                            int i2516 = (~((i241119 & i) | (i241119 ^ i))) * 566;
                                                            int i2517 = (i241118 & i2516) + (i2516 | i241118);
                                                            objArr11 = new Object[1];
                                                            b(new int[]{884902256, -445488909, 237261781, 1198892294}, i2517, objArr11);
                                                            if (str6.startsWith((String) objArr11[0])) {
                                                                int i2518 = -((byte) KeyEvent.getModifierMetaStateMask());
                                                                Object[] objArr51112 = new Object[1];
                                                                c(null, null, (i2518 & WebSocketProtocol.PAYLOAD_SHORT) + (i2518 | WebSocketProtocol.PAYLOAD_SHORT), "¢", objArr51112);
                                                                strArrSplit3 = str6.split((String) objArr51112[0]);
                                                                if (strArrSplit3.length > 1) {
                                                                    continue;
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        } else {
                                                            strArr2 = strArrSplit2;
                                                        }
                                                    } else {
                                                        strArr2 = strArrSplit2;
                                                    }
                                                    i21 = ((i21 ^ 3) + ((i21 & 3) << 1)) - 2;
                                                    strArrSplit2 = strArr2;
                                                }
                                            }
                                        }
                                    } else {
                                        strArr = strArrSplit;
                                        i18 = length2;
                                        i19 = i15;
                                        i20 = i17;
                                        str5 = str9;
                                    }
                                    int i296 = (i20 & 83) + (i20 | 83);
                                    i17 = (i296 & (-82)) + (i296 | (-82));
                                    strArrSplit = strArr;
                                    length2 = i18;
                                    i15 = i19;
                                    str9 = str5;
                                } else {
                                    i4 = 5;
                                }
                            }
                        }
                    }
                    c2 = 0;
                    if (((int[]) objArr[c2])[c2] != i) {
                        return objArr;
                    }
                    objArr2 = new Object[5];
                    int[] iArr = new int[1];
                    objArr2[c2] = iArr;
                    int[] iArr2 = new int[1];
                    objArr2[1] = iArr2;
                    objArr2[4] = new int[1];
                    iArr2[c2] = i;
                    iArr[c2] = i;
                    objArr2[3] = null;
                    objArr2[2] = null;
                    int iMyUid2 = Process.myUid();
                    int i297 = ~iMyUid2;
                    int i298 = i3 + (-1619330034) + (((-320762945) | i297) * (-369)) + (((~((-675384216) | i297)) | (-459208408)) * (-369)) + (((~(iMyUid2 | 675384215)) | (-996147160) | (~(i297 | (-138445464)))) * 369);
                    int i299 = i298 << 13;
                    int i300 = (i298 | i299) & (~(i298 & i299));
                    int i301 = i300 >>> 17;
                    int i302 = (i300 | i301) & (~(i300 & i301));
                    int i303 = i302 << 5;
                    ((int[]) objArr2[4])[0] = (i302 | i303) & (~(i302 & i303));
                    if (((int[]) objArr2[0])[0] != i) {
                        return objArr2;
                    }
                    if ((i2 & 1) == 0) {
                        int i304 = -TextUtils.lastIndexOf("", '0');
                        int i305 = (i304 & 12) + (i304 | 12);
                        Object[] objArr60 = new Object[1];
                        b(new int[]{1863435219, 327492474, 1528792028, -1524973867, 146958916, 129349860, 2013262073, 1023984745}, i305, objArr60);
                        try {
                            Object[] objArr61 = {(String) objArr60[0]};
                            int i306 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                            int i307 = (i306 ^ 23) + ((i306 & 23) << 1);
                            Object[] objArr62 = new Object[1];
                            b(new int[]{-2112265770, 771277936, 2089875094, -1648292083, -1827737935, -569170719, 599844468, 1962699201, -2078797210, 1205550199, 1249491285, 1358720150}, i307, objArr62);
                            Class<?> cls20 = Class.forName((String) objArr62[0]);
                            int i308 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i309 = (i308 & 15) + (i308 | 15);
                            Object[] objArr63 = new Object[1];
                            b(new int[]{210537933, -337344139, -1944543822, 2142110415, 1970210040, 1902529663, -1719681460, -1168431694}, i309, objArr63);
                            objInvoke = cls20.getMethod((String) objArr63[0], String.class).invoke(context, objArr61);
                            if (objInvoke != null) {
                                objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                                int i310 = (-1350033576) + (((~((-843508330) | iElapsedRealtime3)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime3))) | (-929497066)) * 345) + ((~(iElapsedRealtime3 | (-302164545))) * 345);
                                int iD8875 = W29288.D8871();
                                int i311 = i310 * 193;
                                int i312 = -(-(i3 * 193));
                                int i313 = (i311 ^ i312) + ((i311 & i312) << 1);
                                int i314 = ~iD8875;
                                int i315 = ~i310;
                                int i316 = ~((i315 ^ i3) | (i315 & i3));
                                int i317 = ((i316 & i314) | (i314 ^ i316)) * (-192);
                                int i318 = ((i313 | i317) << 1) - (i313 ^ i317);
                                int i319 = ~i310;
                                int i320 = ~i3;
                                int i321 = ~((i319 & i320) | (i319 ^ i320));
                                int i322 = ~iD8875;
                                int i323 = ~((i322 & i320) | (i320 ^ i322));
                                int i324 = (i318 - (~(((i321 & i323) | (i321 ^ i323)) * (-384)))) - 1;
                                int i325 = ~i3;
                                int i326 = ~((i315 & i325) | (i315 ^ i325) | iD8875);
                                int i327 = (i314 & i320) | (i320 ^ i314);
                                int i328 = ~((i327 & i310) | (i327 ^ i310));
                                int i329 = (i328 & i326) | (i326 ^ i328);
                                int i330 = (i310 ^ i3) | (i310 & i3);
                                int i331 = i324 + (((~((iD8875 & i330) | (i330 ^ iD8875))) | i329) * 192);
                                int i332 = i331 << 13;
                                int i333 = (i332 & (~i331)) | ((~i332) & i331);
                                int i334 = i333 ^ (i333 >>> 17);
                                int i335 = i334 << 5;
                                c5 = 0;
                                ((int[]) objArr6[4])[0] = (i334 | i335) & (~(i334 & i335));
                                break;
                            }
                            Object[] objArr64 = new Object[1];
                            c(null, null, TextUtils.getOffsetAfter("", 0) + 127, "\u0094\u0084\u0082\u008e\u008a\u008e¥¤\u008f\u0095\u009d\u008c£\u0084\u008f\u0095\u0096\u0084\u0098\u0091\u008a\u0095\u0090\u008d\u008e\u0091\u009e\u009e\u008e\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr64);
                            Class<?> cls21 = Class.forName((String) objArr64[0]);
                            int i336 = -(ViewConfiguration.getEdgeSlop() >> 16);
                            Object[] objArr65 = new Object[1];
                            c(null, null, (i336 ^ 127) + ((i336 & 127) << 1), "\u0085\u008a\u0095\u0090\u008d¦\u0084\u0096\u0095\u0086\u008f¦\u0086\u0084\u0082", objArr65);
                            list = (List) cls21.getMethod((String) objArr65[0], null).invoke(objInvoke, null);
                            if (list != null) {
                                objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                int iElapsedRealtime4 = (int) SystemClock.elapsedRealtime();
                                int i3110 = (-1350033576) + (((~((-843508330) | iElapsedRealtime4)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime4))) | (-929497066)) * 345) + ((~(iElapsedRealtime4 | (-302164545))) * 345);
                                int iD8876 = W29288.D8871();
                                int i3111 = i3110 * 193;
                                int i3112 = -(-(i3 * 193));
                                int i3113 = (i3111 ^ i3112) + ((i3111 & i3112) << 1);
                                int i3114 = ~iD8876;
                                int i3115 = ~i3110;
                                int i3116 = ~((i3115 ^ i3) | (i3115 & i3));
                                int i3117 = ((i3116 & i3114) | (i3114 ^ i3116)) * (-192);
                                int i3118 = ((i3113 | i3117) << 1) - (i3113 ^ i3117);
                                int i3119 = ~i3110;
                                int i3210 = ~i3;
                                int i3211 = ~((i3119 & i3210) | (i3119 ^ i3210));
                                int i3212 = ~iD8876;
                                int i3213 = ~((i3212 & i3210) | (i3210 ^ i3212));
                                int i3214 = (i3118 - (~(((i3211 & i3213) | (i3211 ^ i3213)) * (-384)))) - 1;
                                int i3215 = ~i3;
                                int i3216 = ~((i3115 & i3215) | (i3115 ^ i3215) | iD8876);
                                int i3217 = (i3114 & i3210) | (i3210 ^ i3114);
                                int i3218 = ~((i3217 & i3110) | (i3217 ^ i3110));
                                int i3219 = (i3218 & i3216) | (i3216 ^ i3218);
                                int i337 = (i3110 ^ i3) | (i3110 & i3);
                                int i338 = i3214 + (((~((iD8876 & i337) | (i337 ^ iD8876))) | i3219) * 192);
                                int i339 = i338 << 13;
                                int i3310 = (i339 & (~i338)) | ((~i339) & i338);
                                int i3311 = i3310 ^ (i3310 >>> 17);
                                int i3312 = i3311 << 5;
                                c5 = 0;
                                ((int[]) objArr6[4])[0] = (i3311 | i3312) & (~(i3311 & i3312));
                                break;
                            }
                            it = list.iterator();
                            loop1: while (true) {
                                if (it.hasNext()) {
                                    objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                    int iElapsedRealtime5 = (int) SystemClock.elapsedRealtime();
                                    int i31110 = (-1350033576) + (((~((-843508330) | iElapsedRealtime5)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime5))) | (-929497066)) * 345) + ((~(iElapsedRealtime5 | (-302164545))) * 345);
                                    int iD8877 = W29288.D8871();
                                    int i31111 = i31110 * 193;
                                    int i31112 = -(-(i3 * 193));
                                    int i31113 = (i31111 ^ i31112) + ((i31111 & i31112) << 1);
                                    int i31114 = ~iD8877;
                                    int i31115 = ~i31110;
                                    int i31116 = ~((i31115 ^ i3) | (i31115 & i3));
                                    int i31117 = ((i31116 & i31114) | (i31114 ^ i31116)) * (-192);
                                    int i31118 = ((i31113 | i31117) << 1) - (i31113 ^ i31117);
                                    int i31119 = ~i31110;
                                    int i32110 = ~i3;
                                    int i32111 = ~((i31119 & i32110) | (i31119 ^ i32110));
                                    int i32112 = ~iD8877;
                                    int i32113 = ~((i32112 & i32110) | (i32110 ^ i32112));
                                    int i32114 = (i31118 - (~(((i32111 & i32113) | (i32111 ^ i32113)) * (-384)))) - 1;
                                    int i32115 = ~i3;
                                    int i32116 = ~((i31115 & i32115) | (i31115 ^ i32115) | iD8877);
                                    int i32117 = (i31114 & i32110) | (i32110 ^ i31114);
                                    int i32118 = ~((i32117 & i31110) | (i32117 ^ i31110));
                                    int i32119 = (i32118 & i32116) | (i32116 ^ i32118);
                                    int i3313 = (i31110 ^ i3) | (i31110 & i3);
                                    int i3314 = i32114 + (((~((iD8877 & i3313) | (i3313 ^ iD8877))) | i32119) * 192);
                                    int i3315 = i3314 << 13;
                                    int i3316 = (i3315 & (~i3314)) | ((~i3315) & i3314);
                                    int i3317 = i3316 ^ (i3316 >>> 17);
                                    int i3318 = i3317 << 5;
                                    c5 = 0;
                                    ((int[]) objArr6[4])[0] = (i3317 | i3318) & (~(i3317 & i3318));
                                    break;
                                }
                                Object next = it.next();
                                int i340 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                int iD8878 = W29288.D8871();
                                int i341 = i340 * (-711);
                                int i342 = ((i341 | 90551) << 1) - (i341 ^ 90551);
                                int i343 = ~(((-128) ^ i340) | ((-128) & i340));
                                int i344 = ~iD8878;
                                int i345 = (i344 & i340) | (i344 ^ i340);
                                int i346 = ~i345;
                                int i347 = -(-(((i343 & i346) | (i343 ^ i346)) * (-712)));
                                int i348 = ((i342 | i347) << 1) - (i347 ^ i342);
                                int i349 = ~iD8878;
                                int i350 = ((-128) & i349) | ((-128) ^ i349);
                                int i351 = ~((i350 & i340) | (i350 ^ i340));
                                int i352 = i340 | 127;
                                int i353 = -(-(((~((i352 & iD8878) | (i352 ^ iD8878))) | i351) * (-712)));
                                int i354 = (i348 ^ i353) + ((i353 & i348) << 1);
                                int i355 = ~i345;
                                int i356 = -(-(((i355 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) | ((-128) ^ i355)) * 712));
                                int i357 = (i354 ^ i356) + ((i356 & i354) << 1);
                                Object[] objArr66 = new Object[1];
                                c(null, null, i357, "\u0084\u0090\u008e¨\u0086\u008a\u0084\u008a\u008c\u009e\u0090\u008c§\u0091\u0086\u008a\u0084\u0086\u008a\u008c\u008f\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr66);
                                Class<?> cls22 = Class.forName((String) objArr66[0]);
                                int defaultSize = View.getDefaultSize(0, 0);
                                int iD8879 = W29288.D8871();
                                int i358 = ~defaultSize;
                                int i359 = ~((i358 ^ (-15)) | (i358 & (-15)));
                                int i360 = ~iD8879;
                                int i361 = ~((i358 & i360) | (i358 ^ i360));
                                int i362 = (i361 & i359) | (i359 ^ i361) | (~(((-15) ^ i360) | ((-15) & i360)));
                                int i363 = (defaultSize ^ 14) | (defaultSize & 14);
                                int i364 = ~((i363 ^ iD8879) | (i363 & iD8879));
                                int i365 = (((defaultSize * 85) + 1190) - (~(-(-(((i362 ^ i364) | (i362 & i364)) * (-84)))))) - 1;
                                int i366 = ~((iD8879 & (-15)) | ((-15) ^ iD8879));
                                int i367 = (defaultSize & i366) | (defaultSize ^ i366);
                                int i368 = ~(i360 | 14);
                                int i369 = -(-(((i367 & i368) | (i367 ^ i368)) * (-84)));
                                int i370 = (i365 ^ i369) + ((i369 & i365) << 1);
                                int i371 = ~((i360 ^ 14) | (i360 & 14));
                                int i372 = ~i363;
                                int i373 = -(-(((i371 & i372) | (i371 ^ i372)) * 84));
                                int i374 = ((i370 | i373) << 1) - (i373 ^ i370);
                                Object[] objArr67 = new Object[1];
                                b(new int[]{-291897813, 449239847, -1848161257, -1868223166, -1847001535, 575082025, 902950748, 1280601789}, i374, objArr67);
                                str = (String) cls22.getMethod((String) objArr67[0], null).invoke(next, null);
                                Object[] objArr68 = new Object[1];
                                c(null, null, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, "\u0094\u0084\u0082\u008e\u008a\u008e¥¤\u008f\u0095\u009d\u008c£\u0084\u008f\u0095\u0096\u0084\u0098\u0091\u008a\u0095\u0090\u008d\u008e\u0091\u009e\u009e\u008e\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr68);
                                cls = Class.forName((String) objArr68[0]);
                                objArr7 = new Object[1];
                                b(new int[]{863605188, 455288148, -787525060, 699780433, 1245564663, -1958494018, 2038443443, -189188659, -1746919764, -854228786}, 16 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr7);
                                if (!((Boolean) cls.getMethod((String) objArr7[0], String.class).invoke(objInvoke, str)).booleanValue() && (length = str.length() - 20) >= 0) {
                                    for (int i375 = 0; i375 <= length; i375++) {
                                        Object[] objArr69 = {str.substring(i375, ((i375 | 20) << 1) - (i375 ^ 20)), 931995};
                                        Object objComponent19 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent19 == null) {
                                            int windowTouchSlop6 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 52;
                                            char c6 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                                            int iAlpha = Color.alpha(0) + 5420;
                                            Object[] objArr70 = new Object[1];
                                            d((byte) ($$a[c] + 1), 0, (short) 1, objArr70);
                                            objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(windowTouchSlop6, c6, iAlpha, 1884899413, false, (String) objArr70[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue8 = ((Long) ((Method) objComponent19).invoke(null, objArr69)).longValue();
                                        long j26 = (-265536414378L) + ((-475) * jLongValue8);
                                        long j27 = (556680113 | jLongValue8) ^ (-1);
                                        long j28 = jLongValue8 ^ (-1);
                                        long j29 = i;
                                        long j30 = ((j28 | (-556680114)) | j29) ^ (-1);
                                        long j31 = j26 + ((-476) * (j27 | j30)) + (952 * j30) + (476 * (((j28 | (j29 ^ (-1))) | (-556680114)) ^ (-1))) + 1063833227;
                                        int i376 = ~i;
                                        int i377 = ((int) (j31 >> 32)) & ((-802173004) + ((863892222 | i376) * (-369)) + (((~((-577565421) | i376)) | 859660990) * (-369)) + (((~(577565420 | i)) | 286326802 | (~((-4231233) | i376))) * 369));
                                        int i378 = 818884229 + (((~((-727878485) | i)) | 711068416 | (~((-2129862402) | i))) * (-880));
                                        int i379 = (~(i376 | (-727878485))) | 2129862401;
                                        int i380 = ~(727878484 | i);
                                        int i381 = ((int) j31) & (i378 + ((i379 | i380) * (-880)) + (i380 * 880));
                                        if (((i377 & i381) | (i377 ^ i381)) == 1245577864) {
                                            objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{(i | i) & (~(i & i))}};
                                            int i382 = (~(i & 70)) & (i | 70);
                                            int i383 = (((~(207830948 | i)) | (-354872257)) * 398) + 1552203099;
                                            int i384 = ~i;
                                            int i385 = i383 + (((~(207830948 | i384)) | (-354872257)) * 398);
                                            int i386 = -(-(i385 * 565));
                                            int i387 = ((-9008) & i386) + (i386 | (-9008));
                                            int i388 = ~i385;
                                            int i389 = ~i;
                                            int i390 = ~((i388 & i389) | (i388 ^ i389));
                                            int i391 = (i390 & (-17)) | ((-17) ^ i390);
                                            int i392 = ~((i385 ^ i) | (i385 & i));
                                            int i393 = i387 + (((i391 & i392) | (i391 ^ i392)) * (-564));
                                            int i394 = ((-17) ^ i385) | ((-17) & i385);
                                            int i395 = (~((i394 & i) | (i394 ^ i))) * 1128;
                                            int i396 = ((i393 | i395) << 1) - (i395 ^ i393);
                                            int i397 = ((~(((-17) & i389) | ((-17) ^ i389))) | (~((i385 & 16) | (i385 ^ 16)))) * 564;
                                            int i398 = (i396 ^ i397) + ((i397 & i396) << 1);
                                            int i399 = ((i398 * (-589)) - (~(i3 * 591))) - 1;
                                            int i400 = ~i3;
                                            int i401 = ~((i400 & i389) | (i400 ^ i389));
                                            int i402 = ~i3;
                                            int i403 = i401 | (~((i402 ^ i398) | (i402 & i398)));
                                            int i404 = ~((i384 ^ i398) | (i384 & i398));
                                            int i405 = (i403 & i404) | (i403 ^ i404);
                                            int i406 = ~i398;
                                            int i407 = ~((i406 ^ i3) | (i406 & i3) | i);
                                            int i408 = -(-(((i405 & i407) | (i405 ^ i407)) * 590));
                                            int i409 = (i399 ^ i408) + ((i399 & i408) << 1);
                                            int i410 = ~((i402 ^ i389) | (i389 & i402));
                                            int i411 = ~(i398 | i402);
                                            int i412 = (i410 & i411) | (i410 ^ i411);
                                            int i413 = (i409 - (~(((i412 & i404) | (i412 ^ i404)) * (-1180)))) - 1;
                                            int i414 = ((~((i406 ^ i384) | (i406 & i384))) | (~(i384 | i3))) * 590;
                                            int i415 = (i413 ^ i414) + ((i414 & i413) << 1);
                                            int i416 = i415 << 13;
                                            int i417 = (i416 | i415) & (~(i415 & i416));
                                            int i418 = i417 >>> 17;
                                            int i419 = ((~i417) & i418) | ((~i418) & i417);
                                            int i420 = i419 << 5;
                                            c5 = 0;
                                            break loop1;
                                        }
                                    }
                                }
                            }
                            if (((int[]) objArr6[c5])[c5] != i) {
                                return objArr6;
                            }
                        } catch (Throwable th13) {
                            Throwable cause8 = th13.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th13;
                        }
                    }
                    Object[] objArr71 = new Object[1];
                    c(null, null, TextUtils.lastIndexOf("", '0', 0, 0) + 128, "\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr71);
                    Object[] objArr72 = {(String) objArr71[0]};
                    objComponent5 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent5 == null) {
                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 52;
                        char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 59725);
                        int i421 = 6318 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        Object[] objArr73 = new Object[1];
                        d($$a[6], 0, (short) 1, objArr73);
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iKeyCodeFromString, cIndexOf, i421, 66836110, false, (String) objArr73[0], new Class[]{String.class});
                    }
                    long jLongValue9 = ((Long) ((Method) objComponent5).invoke(null, objArr72)).longValue();
                    long j32 = i;
                    long j33 = ((-1516936032) | jLongValue9) ^ (-1);
                    long j34 = 568851012000L + ((-375) * jLongValue9) + (((((jLongValue9 ^ (-1)) | 1516936031) ^ (-1)) | j32 | j33) * 376) + ((-376) * ((((j32 ^ (-1)) | (-1516936032)) ^ (-1)) | j33)) + (376 * (jLongValue9 | ((j32 | 1516936031) ^ (-1)))) + 1672886398;
                    int iMyUid3 = Process.myUid();
                    i5 = ((int) (j34 >> 32)) & ((-1771464918) + (((~(1996185632 | iMyUid3)) | (-2012965429)) * 576) + (((~((~iMyUid3) | (-16779797))) | 1151410176) * 576) + 173082816);
                    int i422 = (int) j34;
                    int iElapsedRealtime6 = (int) SystemClock.elapsedRealtime();
                    int i423 = ~iElapsedRealtime6;
                    i6 = i422 & ((-1655161755) + (((~((-133072321) | i423)) | 38010880) * PlaybackException.ERROR_CODE_SETUP_REQUIRED) + (((~(i423 | (-1304154090))) | (~(1304154089 | iElapsedRealtime6)) | 1209092649) * 54) + ((iElapsedRealtime6 | 1209092649) * 54));
                    if (((i5 & i6) | (i5 ^ i6)) != 0) {
                        objArr3 = new Object[]{new int[]{(i & (-51)) | (i & 50)}, new int[]{i}, null, null, new int[]{i ^ (i << 5)}};
                        int i424 = ~i;
                        int i425 = (i3 - (~(-(-(((((((~(219998669 | i424)) | (~((-436174478) | i))) | (~(i424 | 436174477))) * 959) - 902615426) + ((((~(219998669 | i)) | (~((-436174478) | i424))) | (~(i | 436174477))) * 959)) + 16))))) - 1;
                        int i426 = i425 << 13;
                        int i427 = (i425 | i426) & (~(i425 & i426));
                        int i428 = i427 >>> 17;
                        int i429 = (i427 | i428) & (~(i427 & i428));
                        i7 = 0;
                    } else {
                        objArr3 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iMyTid6 = Process.myTid();
                        int i430 = ((((~(500058941 | iMyTid6)) | (-931042497)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 1505569973) + (((~((~iMyTid6) | 500058941)) | (-931042497)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                        int i431 = (i430 << 1) - i430;
                        int i432 = ((i3 | i431) << 1) - (i431 ^ i3);
                        int i433 = i432 << 13;
                        int i434 = (i433 | i432) & (~(i432 & i433));
                        int i435 = i434 >>> 17;
                        int i436 = (i434 | i435) & (~(i434 & i435));
                        int i437 = i436 << 5;
                        i7 = 0;
                        ((int[]) objArr3[4])[0] = ((~i436) & i437) | ((~i437) & i436);
                    }
                    if (((int[]) objArr3[i7])[i7] != i) {
                        return objArr3;
                    }
                    int i438 = -View.resolveSizeAndState(i7, i7, i7);
                    int i439 = ((i438 | 20) << 1) - (i438 ^ 20);
                    Object[] objArr74 = new Object[1];
                    b(new int[]{184761459, -1107296432, 453667500, 1162672310, 1365997356, 1114931828, -556401676, -187739045, -785460784, 1073619282}, i439, objArr74);
                    Object[] objArr75 = {(String) objArr74[i7]};
                    objComponent6 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent6 == null) {
                        int packedPositionType = 52 - ExpandableListView.getPackedPositionType(0L);
                        char cMakeMeasureSpec3 = (char) (59725 - View.MeasureSpec.makeMeasureSpec(0, 0));
                        int iMyTid7 = 6317 - (Process.myTid() >> 22);
                        Object[] objArr76 = new Object[1];
                        d($$a[6], 0, (short) 1, objArr76);
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionType, cMakeMeasureSpec3, iMyTid7, 66836110, false, (String) objArr76[0], new Class[]{String.class});
                    }
                    long jLongValue10 = ((Long) ((Method) objComponent6).invoke(null, objArr75)).longValue();
                    long j35 = (-667574636148L) + ((-712) * jLongValue10);
                    long jNextInt = new Random().nextInt(2027287273);
                    long j36 = jNextInt ^ (-1);
                    long j37 = ((934978481 | jLongValue10) ^ (-1)) | ((934978481 | j36) ^ (-1));
                    long j38 = jLongValue10 ^ (-1);
                    long j39 = (jNextInt | ((-934978482) | j38)) ^ (-1);
                    long j40 = j35 + ((-713) * (j37 | j39)) + (1426 * j39) + (713 * ((j38 | j36) ^ (-1))) + 1090928848;
                    int i440 = ~new Random().nextInt(1789439282);
                    i8 = ((int) (j40 >> 32)) & ((-541377569) + ((~((-86052939) | i440)) * (-783)) + (((~(i440 | (-1467440336))) | 1390300549) * 783));
                    int i441 = ~(Process.myPid() | (-1005694834));
                    i9 = ((int) j40) & ((((-170675241) + ((431531576 | i441) * (-220))) + ((i441 | 431007280) * 220)) - 1151206050);
                    if (((i8 & i9) | (i8 ^ i9)) != 0) {
                        objArr4 = new Object[]{new int[]{i ^ 60}, new int[]{i}, null, null, new int[]{(i | i) & (~(i & i))}};
                        int i442 = -(-((((-995988949) + (((~((-84795796) | i)) | (-131380013)) * (-948))) + ((~((-84189441) | (~i))) * (-948))) - 574825472));
                        int i443 = (i3 & i442) + (i442 | i3);
                        int i444 = i443 << 13;
                        int i445 = (i444 & (~i443)) | ((~i444) & i443);
                        int i446 = i445 >>> 17;
                        int i447 = ((~i445) & i446) | ((~i446) & i445);
                        int i448 = i447 << 5;
                        c3 = 0;
                    } else {
                        objArr4 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{(i | i) & (~(i & i))}};
                        int i449 = (~((-54222117) | i)) | 19076352;
                        int i450 = ~i;
                        int i451 = (i3 - (~((((-1360847093) + ((i449 | (~(197099455 | i450))) * 886)) + (((~(54222116 | i450)) | 161953691) * (-1772))) + ((~(i450 | 161953691)) * 886)))) - 1;
                        int i452 = i451 << 13;
                        int i453 = (i451 | i452) & (~(i451 & i452));
                        int i454 = i453 >>> 17;
                        int i455 = ((~i453) & i454) | ((~i454) & i453);
                        int i456 = i455 << 5;
                        c3 = 0;
                    }
                    if (((int[]) objArr4[c3])[c3] != i) {
                        return objArr4;
                    }
                    int i457 = -(KeyEvent.getMaxKeyCode() >> 16);
                    Object[] objArr77 = new Object[1];
                    c(null, null, (i457 ^ 127) + ((i457 & 127) << 1), "\u008e\u0086\u008e\u008d\u0097\u0085\u008b\u0096\u0081\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0093\u008c\u0092\u0082\u0091\u0090\u008c\u008f\u0081\u008e\u0086\u008e\u008d\u0081\u008e\u0086\u008e\u008d\u0081", objArr77);
                    Object[] objArr78 = {(String) objArr77[0]};
                    objComponent7 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent7 == null) {
                        int keyRepeatDelay = 52 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char cRed = (char) (59725 - Color.red(0));
                        int gidForName = 6316 - Process.getGidForName("");
                        Object[] objArr79 = new Object[1];
                        d($$a[6], 0, (short) 0, objArr79);
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay, cRed, gidForName, 369154319, false, (String) objArr79[0], new Class[]{String.class});
                    }
                    long jLongValue11 = ((Long) ((Method) objComponent7).invoke(null, objArr78)).longValue();
                    long j41 = jLongValue11 ^ (-1);
                    long jNextInt2 = new Random().nextInt();
                    long j42 = ((-116502563) | jNextInt2) ^ (-1);
                    j = (((((-102638758003L) + (881 * jLongValue11)) + ((((j41 | jNextInt2) ^ (-1)) | (((116502562 | j41) ^ (-1)) | ((116502562 | jNextInt2) ^ (-1)))) * (-880))) + ((-880) * ((jLongValue11 | (((jNextInt2 ^ (-1)) | 116502562) ^ (-1))) | j42))) + (880 * j42)) - 857999322;
                    int iMyPid = Process.myPid();
                    i10 = ((int) (j >> 32)) & ((-484646000) + (((~(57926735 | iMyPid)) | 1477188016) * 345) + (((~(57926735 | (~iMyPid))) | 17965130) * 345) + ((~(iMyPid | (-1477188017))) * 345));
                    i11 = ~Process.myUid();
                    if ((i10 | (((int) j) & (((((~(548064968 | i11)) | (-889179882)) * (-241)) - 985657213) + (((~(i11 | (-341114914))) | 18440) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION)))) != 0) {
                        objArr5 = new Object[]{new int[]{(i & (-81)) | (i & 80)}, new int[]{i}, null, null, new int[]{i ^ (i << 5)}};
                        int i458 = ~i;
                        int i459 = (~(140841178 | i458)) | 352494848;
                        int i460 = ~((-136319041) | i);
                        int i461 = (((i459 | i460) * (-252)) - 1149435713) + ((i460 | (~(493336026 | i458))) * 252) + 16 + i3;
                        int i462 = i461 ^ (i461 << 13);
                        int i463 = i462 ^ (i462 >>> 17);
                        c4 = 0;
                    } else {
                        objArr5 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int i464 = 176133911 + ((~(i | 98053160)) * JfifUtil.MARKER_SOI);
                        int i465 = ~i;
                        int i466 = i464 + (((-33702040) | i465) * (-216)) + (((~(98053160 | i465)) | 118122647) * JfifUtil.MARKER_SOI);
                        int iD88710 = W29288.D8871();
                        int i467 = ((i466 * 784) - (~(-(-(i3 * (-782)))))) - 1;
                        int i468 = -(-((~i3) * (-783)));
                        int i469 = (i467 ^ i468) + ((i467 & i468) << 1);
                        int i470 = ~i466;
                        int i471 = ~iD88710;
                        int i472 = (i470 ^ i471) | (i470 & i471);
                        int i473 = -(-((~((i472 & i3) | (i472 ^ i3))) * (-783)));
                        int i474 = ~((i471 & i3) | (i471 ^ i3));
                        int i475 = (i469 ^ i473) + ((i473 & i469) << 1) + (((i474 & i470) | (i470 ^ i474)) * 783);
                        int i476 = (i475 << 13) ^ i475;
                        int i477 = i476 >>> 17;
                        int i478 = (i476 | i477) & (~(i476 & i477));
                        int i479 = i478 << 5;
                        c4 = 0;
                        ((int[]) objArr5[4])[0] = (i478 | i479) & (~(i478 & i479));
                    }
                    if (((int[]) objArr5[c4])[c4] != i) {
                        return objArr5;
                    }
                    int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                    int iD88711 = W29288.D8871();
                    int i480 = (edgeSlop * (-300)) + 12684;
                    int i481 = (edgeSlop ^ 42) | (edgeSlop & 42);
                    int i482 = -(-((~((i481 & iD88711) | (i481 ^ iD88711))) * (-301)));
                    int i483 = (i480 ^ i482) + ((i480 & i482) << 1);
                    int i484 = ~(((-43) & iD88711) | ((-43) ^ iD88711));
                    int i485 = ~iD88711;
                    int i486 = ~((i485 & edgeSlop) | (i485 ^ edgeSlop));
                    int i487 = -(-(((i484 & i486) | (i484 ^ i486)) * (-301)));
                    int i488 = (i483 ^ i487) + ((i487 & i483) << 1);
                    int i489 = ~edgeSlop;
                    int i490 = ~((i489 & iD88711) | (i489 ^ iD88711));
                    int i491 = -(-(((i490 & (-43)) | ((-43) ^ i490)) * 301));
                    int i492 = (i488 & i491) + (i491 | i488);
                    Object[] objArr80 = new Object[1];
                    b(new int[]{1757567909, 1584018018, 1022638462, 2097043189, 334002754, -1795771782, -676401432, 875025587, -535021603, -1269512321, 237936703, 578098833, 1920243019, 271617748, -2122896543, -1000035526, -687279908, -622015357, -1678118114, -1787322487, 166748025, -82529432}, i492, objArr80);
                    Object[] objArr81 = {(String) objArr80[0]};
                    objComponent8 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent8 == null) {
                        int i493 = 52 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char doubleTapTimeout = (char) (59725 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        int iAlpha2 = 6317 - Color.alpha(0);
                        Object[] objArr82 = new Object[1];
                        d($$a[6], 0, (short) 0, objArr82);
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i493, doubleTapTimeout, iAlpha2, 369154319, false, (String) objArr82[0], new Class[]{String.class});
                    }
                    long jLongValue12 = ((Long) ((Method) objComponent8).invoke(null, objArr81)).longValue();
                    long j43 = 315091885623L + ((-657) * jLongValue12);
                    long j44 = ((-478136398) | jLongValue12) ^ (-1);
                    long j45 = ((jLongValue12 ^ (-1)) | 478136397) ^ (-1);
                    long jNextInt3 = (478136397 | ((long) new Random().nextInt(1327696636))) ^ (-1);
                    long j46 = (((j43 + ((-658) * ((j44 | j45) | jNextInt3))) + (658 * j45)) + (658 * (j45 | jNextInt3))) - 1452638282;
                    i12 = ~i;
                    i13 = ((int) (j46 >> 32)) & ((((-325434850) + (((~((-768305928) | i12)) | (-668920484)) * (-933))) + (((~((-668920484) | i12)) | 34898080) * 933)) - 2065029960);
                    int i494 = (int) j46;
                    int i495 = 818884229 + (((~(1007923308 | i)) | (-1033352574) | (~(429303101 | i))) * (-880));
                    int i496 = (~(1007923308 | i12)) | (-429303102);
                    int i497 = ~((-1007923309) | i);
                    i14 = i494 & (i495 + ((i496 | i497) * (-880)) + (i497 * 880));
                    if (((i13 & i14) | (i13 ^ i14)) != 0) {
                        Object[] objArr83 = {new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int i498 = ~((~((int) Runtime.getRuntime().totalMemory())) | 383867411);
                        int i499 = i3 + ((14696467 | i498) * (-374)) + 786707585 + ((i498 | 369170944) * 374);
                        int i500 = i499 ^ (i499 << 13);
                        int i501 = i500 >>> 17;
                        int i502 = ((~i500) & i501) | ((~i501) & i500);
                        int i503 = i502 << 5;
                        ((int[]) objArr83[4])[0] = ((~i502) & i503) | ((~i503) & i502);
                        return objArr83;
                    }
                    Object[] objArr84 = {new int[]{i}, new int[]{i}, null, null, new int[]{i ^ (i << 5)}};
                    int i504 = (~(i & 90)) & (i | 90);
                    int i505 = ~(i12 | (-881596803));
                    int i506 = (((((-934124995) | i505) | (~(881596802 | i))) * (-338)) - 1985459895) + ((i505 | (~(i | (-52528193)))) * 338);
                    int i507 = (i506 & 16) + (i506 | 16) + i3;
                    int i508 = i507 << 13;
                    int i509 = (i507 | i508) & (~(i507 & i508));
                    int i510 = i509 >>> 17;
                    int i511 = ((~i509) & i510) | ((~i510) & i509);
                    return objArr84;
                }
                c = '\r';
                i4 = 5;
                objArr = new Object[i4];
                objArr[0] = new int[]{i};
                objArr[1] = new int[]{i};
                objArr[4] = new int[1];
                objArr[3] = null;
                objArr[2] = null;
                int iMyTid8 = Process.myTid();
                int i512 = -(-((((~(iMyTid8 | (-437339495))) * 420) - 993521305) + (((~((~iMyTid8) | (-437339495))) | 618830336) * 420)));
                int i513 = ((i3 | i512) << 1) - (i512 ^ i3);
                int i514 = i513 << 13;
                int i515 = (i514 | i513) & (~(i513 & i514));
                int i516 = i515 >>> 17;
                int i517 = (i515 | i516) & (~(i515 & i516));
                int i518 = i517 << 5;
                c2 = 0;
                ((int[]) objArr[4])[0] = (i517 | i518) & (~(i517 & i518));
                if (((int[]) objArr[c2])[c2] != i) {
                    return objArr;
                }
                objArr2 = new Object[5];
                int[] iArr3 = new int[1];
                objArr2[c2] = iArr3;
                int[] iArr4 = new int[1];
                objArr2[1] = iArr4;
                objArr2[4] = new int[1];
                iArr4[c2] = i;
                iArr3[c2] = i;
                objArr2[3] = null;
                objArr2[2] = null;
                int iMyUid4 = Process.myUid();
                int i2910 = ~iMyUid4;
                int i2911 = i3 + (-1619330034) + (((-320762945) | i2910) * (-369)) + (((~((-675384216) | i2910)) | (-459208408)) * (-369)) + (((~(iMyUid4 | 675384215)) | (-996147160) | (~(i2910 | (-138445464)))) * 369);
                int i2912 = i2911 << 13;
                int i3010 = (i2911 | i2912) & (~(i2911 & i2912));
                int i3011 = i3010 >>> 17;
                int i3012 = (i3010 | i3011) & (~(i3010 & i3011));
                int i3013 = i3012 << 5;
                ((int[]) objArr2[4])[0] = (i3012 | i3013) & (~(i3012 & i3013));
                if (((int[]) objArr2[0])[0] != i) {
                    return objArr2;
                }
                if ((i2 & 1) == 0) {
                    int i3014 = -TextUtils.lastIndexOf("", '0');
                    int i3015 = (i3014 & 12) + (i3014 | 12);
                    Object[] objArr610 = new Object[1];
                    b(new int[]{1863435219, 327492474, 1528792028, -1524973867, 146958916, 129349860, 2013262073, 1023984745}, i3015, objArr610);
                    Object[] objArr611 = {(String) objArr610[0]};
                    int i3016 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int i3017 = (i3016 ^ 23) + ((i3016 & 23) << 1);
                    Object[] objArr612 = new Object[1];
                    b(new int[]{-2112265770, 771277936, 2089875094, -1648292083, -1827737935, -569170719, 599844468, 1962699201, -2078797210, 1205550199, 1249491285, 1358720150}, i3017, objArr612);
                    Class<?> cls23 = Class.forName((String) objArr612[0]);
                    int i3018 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    int i3019 = (i3018 & 15) + (i3018 | 15);
                    Object[] objArr613 = new Object[1];
                    b(new int[]{210537933, -337344139, -1944543822, 2142110415, 1970210040, 1902529663, -1719681460, -1168431694}, i3019, objArr613);
                    objInvoke = cls23.getMethod((String) objArr613[0], String.class).invoke(context, objArr611);
                    if (objInvoke != null) {
                        objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iElapsedRealtime7 = (int) SystemClock.elapsedRealtime();
                        int i311110 = (-1350033576) + (((~((-843508330) | iElapsedRealtime7)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime7))) | (-929497066)) * 345) + ((~(iElapsedRealtime7 | (-302164545))) * 345);
                        int iD88712 = W29288.D8871();
                        int i311111 = i311110 * 193;
                        int i311112 = -(-(i3 * 193));
                        int i311113 = (i311111 ^ i311112) + ((i311111 & i311112) << 1);
                        int i311114 = ~iD88712;
                        int i311115 = ~i311110;
                        int i311116 = ~((i311115 ^ i3) | (i311115 & i3));
                        int i311117 = ((i311116 & i311114) | (i311114 ^ i311116)) * (-192);
                        int i311118 = ((i311113 | i311117) << 1) - (i311113 ^ i311117);
                        int i311119 = ~i311110;
                        int i321110 = ~i3;
                        int i321111 = ~((i311119 & i321110) | (i311119 ^ i321110));
                        int i321112 = ~iD88712;
                        int i321113 = ~((i321112 & i321110) | (i321110 ^ i321112));
                        int i321114 = (i311118 - (~(((i321111 & i321113) | (i321111 ^ i321113)) * (-384)))) - 1;
                        int i321115 = ~i3;
                        int i321116 = ~((i311115 & i321115) | (i311115 ^ i321115) | iD88712);
                        int i321117 = (i311114 & i321110) | (i321110 ^ i311114);
                        int i321118 = ~((i321117 & i311110) | (i321117 ^ i311110));
                        int i321119 = (i321118 & i321116) | (i321116 ^ i321118);
                        int i3319 = (i311110 ^ i3) | (i311110 & i3);
                        int i33110 = i321114 + (((~((iD88712 & i3319) | (i3319 ^ iD88712))) | i321119) * 192);
                        int i33111 = i33110 << 13;
                        int i33112 = (i33111 & (~i33110)) | ((~i33111) & i33110);
                        int i33113 = i33112 ^ (i33112 >>> 17);
                        int i33114 = i33113 << 5;
                        c5 = 0;
                        ((int[]) objArr6[4])[0] = (i33113 | i33114) & (~(i33113 & i33114));
                        break;
                    }
                    Object[] objArr614 = new Object[1];
                    c(null, null, TextUtils.getOffsetAfter("", 0) + 127, "\u0094\u0084\u0082\u008e\u008a\u008e¥¤\u008f\u0095\u009d\u008c£\u0084\u008f\u0095\u0096\u0084\u0098\u0091\u008a\u0095\u0090\u008d\u008e\u0091\u009e\u009e\u008e\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr614);
                    Class<?> cls24 = Class.forName((String) objArr614[0]);
                    int i3320 = -(ViewConfiguration.getEdgeSlop() >> 16);
                    Object[] objArr615 = new Object[1];
                    c(null, null, (i3320 ^ 127) + ((i3320 & 127) << 1), "\u0085\u008a\u0095\u0090\u008d¦\u0084\u0096\u0095\u0086\u008f¦\u0086\u0084\u0082", objArr615);
                    list = (List) cls24.getMethod((String) objArr615[0], null).invoke(objInvoke, null);
                    if (list != null) {
                        objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iElapsedRealtime8 = (int) SystemClock.elapsedRealtime();
                        int i3111110 = (-1350033576) + (((~((-843508330) | iElapsedRealtime8)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime8))) | (-929497066)) * 345) + ((~(iElapsedRealtime8 | (-302164545))) * 345);
                        int iD88713 = W29288.D8871();
                        int i3111111 = i3111110 * 193;
                        int i3111112 = -(-(i3 * 193));
                        int i3111113 = (i3111111 ^ i3111112) + ((i3111111 & i3111112) << 1);
                        int i3111114 = ~iD88713;
                        int i3111115 = ~i3111110;
                        int i3111116 = ~((i3111115 ^ i3) | (i3111115 & i3));
                        int i3111117 = ((i3111116 & i3111114) | (i3111114 ^ i3111116)) * (-192);
                        int i3111118 = ((i3111113 | i3111117) << 1) - (i3111113 ^ i3111117);
                        int i3111119 = ~i3111110;
                        int i3211110 = ~i3;
                        int i3211111 = ~((i3111119 & i3211110) | (i3111119 ^ i3211110));
                        int i3211112 = ~iD88713;
                        int i3211113 = ~((i3211112 & i3211110) | (i3211110 ^ i3211112));
                        int i3211114 = (i3111118 - (~(((i3211111 & i3211113) | (i3211111 ^ i3211113)) * (-384)))) - 1;
                        int i3211115 = ~i3;
                        int i3211116 = ~((i3111115 & i3211115) | (i3111115 ^ i3211115) | iD88713);
                        int i3211117 = (i3111114 & i3211110) | (i3211110 ^ i3111114);
                        int i3211118 = ~((i3211117 & i3111110) | (i3211117 ^ i3111110));
                        int i3211119 = (i3211118 & i3211116) | (i3211116 ^ i3211118);
                        int i33115 = (i3111110 ^ i3) | (i3111110 & i3);
                        int i33116 = i3211114 + (((~((iD88713 & i33115) | (i33115 ^ iD88713))) | i3211119) * 192);
                        int i33117 = i33116 << 13;
                        int i33118 = (i33117 & (~i33116)) | ((~i33117) & i33116);
                        int i33119 = i33118 ^ (i33118 >>> 17);
                        int i331110 = i33119 << 5;
                        c5 = 0;
                        ((int[]) objArr6[4])[0] = (i33119 | i331110) & (~(i33119 & i331110));
                        break;
                    }
                    it = list.iterator();
                    loop1: while (true) {
                        if (it.hasNext()) {
                            objArr6 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                            int iElapsedRealtime9 = (int) SystemClock.elapsedRealtime();
                            int i31111110 = (-1350033576) + (((~((-843508330) | iElapsedRealtime9)) | 302164544) * 345) + (((~((-843508330) | (~iElapsedRealtime9))) | (-929497066)) * 345) + ((~(iElapsedRealtime9 | (-302164545))) * 345);
                            int iD88714 = W29288.D8871();
                            int i31111111 = i31111110 * 193;
                            int i31111112 = -(-(i3 * 193));
                            int i31111113 = (i31111111 ^ i31111112) + ((i31111111 & i31111112) << 1);
                            int i31111114 = ~iD88714;
                            int i31111115 = ~i31111110;
                            int i31111116 = ~((i31111115 ^ i3) | (i31111115 & i3));
                            int i31111117 = ((i31111116 & i31111114) | (i31111114 ^ i31111116)) * (-192);
                            int i31111118 = ((i31111113 | i31111117) << 1) - (i31111113 ^ i31111117);
                            int i31111119 = ~i31111110;
                            int i32111110 = ~i3;
                            int i32111111 = ~((i31111119 & i32111110) | (i31111119 ^ i32111110));
                            int i32111112 = ~iD88714;
                            int i32111113 = ~((i32111112 & i32111110) | (i32111110 ^ i32111112));
                            int i32111114 = (i31111118 - (~(((i32111111 & i32111113) | (i32111111 ^ i32111113)) * (-384)))) - 1;
                            int i32111115 = ~i3;
                            int i32111116 = ~((i31111115 & i32111115) | (i31111115 ^ i32111115) | iD88714);
                            int i32111117 = (i31111114 & i32111110) | (i32111110 ^ i31111114);
                            int i32111118 = ~((i32111117 & i31111110) | (i32111117 ^ i31111110));
                            int i32111119 = (i32111118 & i32111116) | (i32111116 ^ i32111118);
                            int i331111 = (i31111110 ^ i3) | (i31111110 & i3);
                            int i331112 = i32111114 + (((~((iD88714 & i331111) | (i331111 ^ iD88714))) | i32111119) * 192);
                            int i331113 = i331112 << 13;
                            int i331114 = (i331113 & (~i331112)) | ((~i331113) & i331112);
                            int i331115 = i331114 ^ (i331114 >>> 17);
                            int i331116 = i331115 << 5;
                            c5 = 0;
                            ((int[]) objArr6[4])[0] = (i331115 | i331116) & (~(i331115 & i331116));
                            break;
                        }
                        Object next2 = it.next();
                        int i3410 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int iD88715 = W29288.D8871();
                        int i3411 = i3410 * (-711);
                        int i3412 = ((i3411 | 90551) << 1) - (i3411 ^ 90551);
                        int i3413 = ~(((-128) ^ i3410) | ((-128) & i3410));
                        int i3414 = ~iD88715;
                        int i3415 = (i3414 & i3410) | (i3414 ^ i3410);
                        int i3416 = ~i3415;
                        int i3417 = -(-(((i3413 & i3416) | (i3413 ^ i3416)) * (-712)));
                        int i3418 = ((i3412 | i3417) << 1) - (i3417 ^ i3412);
                        int i3419 = ~iD88715;
                        int i3510 = ((-128) & i3419) | ((-128) ^ i3419);
                        int i3511 = ~((i3510 & i3410) | (i3510 ^ i3410));
                        int i3512 = i3410 | 127;
                        int i3513 = -(-(((~((i3512 & iD88715) | (i3512 ^ iD88715))) | i3511) * (-712)));
                        int i3514 = (i3418 ^ i3513) + ((i3513 & i3418) << 1);
                        int i3515 = ~i3415;
                        int i3516 = -(-(((i3515 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) | ((-128) ^ i3515)) * 712));
                        int i3517 = (i3514 ^ i3516) + ((i3516 & i3514) << 1);
                        Object[] objArr616 = new Object[1];
                        c(null, null, i3517, "\u0084\u0090\u008e¨\u0086\u008a\u0084\u008a\u008c\u009e\u0090\u008c§\u0091\u0086\u008a\u0084\u0086\u008a\u008c\u008f\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr616);
                        Class<?> cls25 = Class.forName((String) objArr616[0]);
                        int defaultSize2 = View.getDefaultSize(0, 0);
                        int iD88716 = W29288.D8871();
                        int i3518 = ~defaultSize2;
                        int i3519 = ~((i3518 ^ (-15)) | (i3518 & (-15)));
                        int i3610 = ~iD88716;
                        int i3611 = ~((i3518 & i3610) | (i3518 ^ i3610));
                        int i3612 = (i3611 & i3519) | (i3519 ^ i3611) | (~(((-15) ^ i3610) | ((-15) & i3610)));
                        int i3613 = (defaultSize2 ^ 14) | (defaultSize2 & 14);
                        int i3614 = ~((i3613 ^ iD88716) | (i3613 & iD88716));
                        int i3615 = (((defaultSize2 * 85) + 1190) - (~(-(-(((i3612 ^ i3614) | (i3612 & i3614)) * (-84)))))) - 1;
                        int i3616 = ~((iD88716 & (-15)) | ((-15) ^ iD88716));
                        int i3617 = (defaultSize2 & i3616) | (defaultSize2 ^ i3616);
                        int i3618 = ~(i3610 | 14);
                        int i3619 = -(-(((i3617 & i3618) | (i3617 ^ i3618)) * (-84)));
                        int i3710 = (i3615 ^ i3619) + ((i3619 & i3615) << 1);
                        int i3711 = ~((i3610 ^ 14) | (i3610 & 14));
                        int i3712 = ~i3613;
                        int i3713 = -(-(((i3711 & i3712) | (i3711 ^ i3712)) * 84));
                        int i3714 = ((i3710 | i3713) << 1) - (i3713 ^ i3710);
                        Object[] objArr617 = new Object[1];
                        b(new int[]{-291897813, 449239847, -1848161257, -1868223166, -1847001535, 575082025, 902950748, 1280601789}, i3714, objArr617);
                        str = (String) cls25.getMethod((String) objArr617[0], null).invoke(next2, null);
                        Object[] objArr618 = new Object[1];
                        c(null, null, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, "\u0094\u0084\u0082\u008e\u008a\u008e¥¤\u008f\u0095\u009d\u008c£\u0084\u008f\u0095\u0096\u0084\u0098\u0091\u008a\u0095\u0090\u008d\u008e\u0091\u009e\u009e\u008e\u0091\u008d\u0095\u008c\u0094\u008d\u008a\u008e", objArr618);
                        cls = Class.forName((String) objArr618[0]);
                        objArr7 = new Object[1];
                        b(new int[]{863605188, 455288148, -787525060, 699780433, 1245564663, -1958494018, 2038443443, -189188659, -1746919764, -854228786}, 16 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr7);
                        if (!((Boolean) cls.getMethod((String) objArr7[0], String.class).invoke(objInvoke, str)).booleanValue()) {
                        }
                    }
                    if (((int[]) objArr6[c5])[c5] != i) {
                        return objArr6;
                    }
                }
                Object[] objArr710 = new Object[1];
                c(null, null, TextUtils.lastIndexOf("", '0', 0, 0) + 128, "\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr710);
                Object[] objArr711 = {(String) objArr710[0]};
                objComponent5 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                if (objComponent5 == null) {
                    int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 52;
                    char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 59725);
                    int i4210 = 6318 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    Object[] objArr712 = new Object[1];
                    d($$a[6], 0, (short) 1, objArr712);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iKeyCodeFromString2, cIndexOf2, i4210, 66836110, false, (String) objArr712[0], new Class[]{String.class});
                }
                long jLongValue13 = ((Long) ((Method) objComponent5).invoke(null, objArr711)).longValue();
                long j310 = i;
                long j311 = ((-1516936032) | jLongValue13) ^ (-1);
                long j312 = 568851012000L + ((-375) * jLongValue13) + (((((jLongValue13 ^ (-1)) | 1516936031) ^ (-1)) | j310 | j311) * 376) + ((-376) * ((((j310 ^ (-1)) | (-1516936032)) ^ (-1)) | j311)) + (376 * (jLongValue13 | ((j310 | 1516936031) ^ (-1)))) + 1672886398;
                int iMyUid5 = Process.myUid();
                i5 = ((int) (j312 >> 32)) & ((-1771464918) + (((~(1996185632 | iMyUid5)) | (-2012965429)) * 576) + (((~((~iMyUid5) | (-16779797))) | 1151410176) * 576) + 173082816);
                int i4211 = (int) j312;
                int iElapsedRealtime10 = (int) SystemClock.elapsedRealtime();
                int i4212 = ~iElapsedRealtime10;
                i6 = i4211 & ((-1655161755) + (((~((-133072321) | i4212)) | 38010880) * PlaybackException.ERROR_CODE_SETUP_REQUIRED) + (((~(i4212 | (-1304154090))) | (~(1304154089 | iElapsedRealtime10)) | 1209092649) * 54) + ((iElapsedRealtime10 | 1209092649) * 54));
                if (((i5 & i6) | (i5 ^ i6)) != 0) {
                    objArr3 = new Object[]{new int[]{(i & (-51)) | (i424 & 50)}, new int[]{i}, null, null, new int[]{i429 ^ (i429 << 5)}};
                    int i4213 = ~i;
                    int i4214 = (i3 - (~(-(-(((((((~(219998669 | i4213)) | (~((-436174478) | i))) | (~(i4213 | 436174477))) * 959) - 902615426) + ((((~(219998669 | i)) | (~((-436174478) | i4213))) | (~(i | 436174477))) * 959)) + 16))))) - 1;
                    int i4215 = i4214 << 13;
                    int i4216 = (i4214 | i4215) & (~(i4214 & i4215));
                    int i4217 = i4216 >>> 17;
                    int i4218 = (i4216 | i4217) & (~(i4216 & i4217));
                    i7 = 0;
                } else {
                    objArr3 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int iMyTid9 = Process.myTid();
                    int i4310 = ((((~(500058941 | iMyTid9)) | (-931042497)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 1505569973) + (((~((~iMyTid9) | 500058941)) | (-931042497)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                    int i4311 = (i4310 << 1) - i4310;
                    int i4312 = ((i3 | i4311) << 1) - (i4311 ^ i3);
                    int i4313 = i4312 << 13;
                    int i4314 = (i4313 | i4312) & (~(i4312 & i4313));
                    int i4315 = i4314 >>> 17;
                    int i4316 = (i4314 | i4315) & (~(i4314 & i4315));
                    int i4317 = i4316 << 5;
                    i7 = 0;
                    ((int[]) objArr3[4])[0] = ((~i4316) & i4317) | ((~i4317) & i4316);
                }
                if (((int[]) objArr3[i7])[i7] != i) {
                    return objArr3;
                }
                int i4318 = -View.resolveSizeAndState(i7, i7, i7);
                int i4319 = ((i4318 | 20) << 1) - (i4318 ^ 20);
                Object[] objArr713 = new Object[1];
                b(new int[]{184761459, -1107296432, 453667500, 1162672310, 1365997356, 1114931828, -556401676, -187739045, -785460784, 1073619282}, i4319, objArr713);
                Object[] objArr714 = {(String) objArr713[i7]};
                objComponent6 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                if (objComponent6 == null) {
                    int packedPositionType2 = 52 - ExpandableListView.getPackedPositionType(0L);
                    char cMakeMeasureSpec4 = (char) (59725 - View.MeasureSpec.makeMeasureSpec(0, 0));
                    int iMyTid10 = 6317 - (Process.myTid() >> 22);
                    Object[] objArr715 = new Object[1];
                    d($$a[6], 0, (short) 1, objArr715);
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionType2, cMakeMeasureSpec4, iMyTid10, 66836110, false, (String) objArr715[0], new Class[]{String.class});
                }
                long jLongValue14 = ((Long) ((Method) objComponent6).invoke(null, objArr714)).longValue();
                long j313 = (-667574636148L) + ((-712) * jLongValue14);
                long jNextInt4 = new Random().nextInt(2027287273);
                long j314 = jNextInt4 ^ (-1);
                long j315 = ((934978481 | jLongValue14) ^ (-1)) | ((934978481 | j314) ^ (-1));
                long j316 = jLongValue14 ^ (-1);
                long j317 = (jNextInt4 | ((-934978482) | j316)) ^ (-1);
                long j47 = j313 + ((-713) * (j315 | j317)) + (1426 * j317) + (713 * ((j316 | j314) ^ (-1))) + 1090928848;
                int i4410 = ~new Random().nextInt(1789439282);
                i8 = ((int) (j47 >> 32)) & ((-541377569) + ((~((-86052939) | i4410)) * (-783)) + (((~(i4410 | (-1467440336))) | 1390300549) * 783));
                int i4411 = ~(Process.myPid() | (-1005694834));
                i9 = ((int) j47) & ((((-170675241) + ((431531576 | i4411) * (-220))) + ((i4411 | 431007280) * 220)) - 1151206050);
                if (((i8 & i9) | (i8 ^ i9)) != 0) {
                    objArr4 = new Object[]{new int[]{i ^ 60}, new int[]{i}, null, null, new int[]{(i447 | i448) & (~(i447 & i448))}};
                    int i4412 = -(-((((-995988949) + (((~((-84795796) | i)) | (-131380013)) * (-948))) + ((~((-84189441) | (~i))) * (-948))) - 574825472));
                    int i4413 = (i3 & i4412) + (i4412 | i3);
                    int i4414 = i4413 << 13;
                    int i4415 = (i4414 & (~i4413)) | ((~i4414) & i4413);
                    int i4416 = i4415 >>> 17;
                    int i4417 = ((~i4415) & i4416) | ((~i4416) & i4415);
                    int i4418 = i4417 << 5;
                    c3 = 0;
                } else {
                    objArr4 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{(i455 | i456) & (~(i455 & i456))}};
                    int i4419 = (~((-54222117) | i)) | 19076352;
                    int i4510 = ~i;
                    int i4511 = (i3 - (~((((-1360847093) + ((i4419 | (~(197099455 | i4510))) * 886)) + (((~(54222116 | i4510)) | 161953691) * (-1772))) + ((~(i4510 | 161953691)) * 886)))) - 1;
                    int i4512 = i4511 << 13;
                    int i4513 = (i4511 | i4512) & (~(i4511 & i4512));
                    int i4514 = i4513 >>> 17;
                    int i4515 = ((~i4513) & i4514) | ((~i4514) & i4513);
                    int i4516 = i4515 << 5;
                    c3 = 0;
                }
                if (((int[]) objArr4[c3])[c3] != i) {
                    return objArr4;
                }
                int i4517 = -(KeyEvent.getMaxKeyCode() >> 16);
                Object[] objArr716 = new Object[1];
                c(null, null, (i4517 ^ 127) + ((i4517 & 127) << 1), "\u008e\u0086\u008e\u008d\u0097\u0085\u008b\u0096\u0081\u008d\u0095\u008c\u0094\u008d\u008a\u008e\u0091\u0093\u008c\u0092\u0082\u0091\u0090\u008c\u008f\u0081\u008e\u0086\u008e\u008d\u0081\u008e\u0086\u008e\u008d\u0081", objArr716);
                Object[] objArr717 = {(String) objArr716[0]};
                objComponent7 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent7 == null) {
                    int keyRepeatDelay2 = 52 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char cRed2 = (char) (59725 - Color.red(0));
                    int gidForName2 = 6316 - Process.getGidForName("");
                    Object[] objArr718 = new Object[1];
                    d($$a[6], 0, (short) 0, objArr718);
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay2, cRed2, gidForName2, 369154319, false, (String) objArr718[0], new Class[]{String.class});
                }
                long jLongValue15 = ((Long) ((Method) objComponent7).invoke(null, objArr717)).longValue();
                long j48 = jLongValue15 ^ (-1);
                long jNextInt5 = new Random().nextInt();
                long j49 = ((-116502563) | jNextInt5) ^ (-1);
                j = (((((-102638758003L) + (881 * jLongValue15)) + ((((j48 | jNextInt5) ^ (-1)) | (((116502562 | j48) ^ (-1)) | ((116502562 | jNextInt5) ^ (-1)))) * (-880))) + ((-880) * ((jLongValue15 | (((jNextInt5 ^ (-1)) | 116502562) ^ (-1))) | j49))) + (880 * j49)) - 857999322;
                int iMyPid2 = Process.myPid();
                i10 = ((int) (j >> 32)) & ((-484646000) + (((~(57926735 | iMyPid2)) | 1477188016) * 345) + (((~(57926735 | (~iMyPid2))) | 17965130) * 345) + ((~(iMyPid2 | (-1477188017))) * 345));
                i11 = ~Process.myUid();
                if ((i10 | (((int) j) & (((((~(548064968 | i11)) | (-889179882)) * (-241)) - 985657213) + (((~(i11 | (-341114914))) | 18440) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION)))) != 0) {
                    objArr5 = new Object[]{new int[]{(i & (-81)) | (i458 & 80)}, new int[]{i}, null, null, new int[]{i463 ^ (i463 << 5)}};
                    int i4518 = ~i;
                    int i4519 = (~(140841178 | i4518)) | 352494848;
                    int i4610 = ~((-136319041) | i);
                    int i4611 = (((i4519 | i4610) * (-252)) - 1149435713) + ((i4610 | (~(493336026 | i4518))) * 252) + 16 + i3;
                    int i4612 = i4611 ^ (i4611 << 13);
                    int i4613 = i4612 ^ (i4612 >>> 17);
                    c4 = 0;
                } else {
                    objArr5 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int i4614 = 176133911 + ((~(i | 98053160)) * JfifUtil.MARKER_SOI);
                    int i4615 = ~i;
                    int i4616 = i4614 + (((-33702040) | i4615) * (-216)) + (((~(98053160 | i4615)) | 118122647) * JfifUtil.MARKER_SOI);
                    int iD88717 = W29288.D8871();
                    int i4617 = ((i4616 * 784) - (~(-(-(i3 * (-782)))))) - 1;
                    int i4618 = -(-((~i3) * (-783)));
                    int i4619 = (i4617 ^ i4618) + ((i4617 & i4618) << 1);
                    int i4710 = ~i4616;
                    int i4711 = ~iD88717;
                    int i4712 = (i4710 ^ i4711) | (i4710 & i4711);
                    int i4713 = -(-((~((i4712 & i3) | (i4712 ^ i3))) * (-783)));
                    int i4714 = ~((i4711 & i3) | (i4711 ^ i3));
                    int i4715 = (i4619 ^ i4713) + ((i4713 & i4619) << 1) + (((i4714 & i4710) | (i4710 ^ i4714)) * 783);
                    int i4716 = (i4715 << 13) ^ i4715;
                    int i4717 = i4716 >>> 17;
                    int i4718 = (i4716 | i4717) & (~(i4716 & i4717));
                    int i4719 = i4718 << 5;
                    c4 = 0;
                    ((int[]) objArr5[4])[0] = (i4718 | i4719) & (~(i4718 & i4719));
                }
                if (((int[]) objArr5[c4])[c4] != i) {
                    return objArr5;
                }
                int edgeSlop2 = ViewConfiguration.getEdgeSlop() >> 16;
                int iD88718 = W29288.D8871();
                int i4810 = (edgeSlop2 * (-300)) + 12684;
                int i4811 = (edgeSlop2 ^ 42) | (edgeSlop2 & 42);
                int i4812 = -(-((~((i4811 & iD88718) | (i4811 ^ iD88718))) * (-301)));
                int i4813 = (i4810 ^ i4812) + ((i4810 & i4812) << 1);
                int i4814 = ~(((-43) & iD88718) | ((-43) ^ iD88718));
                int i4815 = ~iD88718;
                int i4816 = ~((i4815 & edgeSlop2) | (i4815 ^ edgeSlop2));
                int i4817 = -(-(((i4814 & i4816) | (i4814 ^ i4816)) * (-301)));
                int i4818 = (i4813 ^ i4817) + ((i4817 & i4813) << 1);
                int i4819 = ~edgeSlop2;
                int i4910 = ~((i4819 & iD88718) | (i4819 ^ iD88718));
                int i4911 = -(-(((i4910 & (-43)) | ((-43) ^ i4910)) * 301));
                int i4912 = (i4818 & i4911) + (i4911 | i4818);
                Object[] objArr85 = new Object[1];
                b(new int[]{1757567909, 1584018018, 1022638462, 2097043189, 334002754, -1795771782, -676401432, 875025587, -535021603, -1269512321, 237936703, 578098833, 1920243019, 271617748, -2122896543, -1000035526, -687279908, -622015357, -1678118114, -1787322487, 166748025, -82529432}, i4912, objArr85);
                Object[] objArr86 = {(String) objArr85[0]};
                objComponent8 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent8 == null) {
                    int i4913 = 52 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char doubleTapTimeout2 = (char) (59725 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int iAlpha3 = 6317 - Color.alpha(0);
                    Object[] objArr87 = new Object[1];
                    d($$a[6], 0, (short) 0, objArr87);
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i4913, doubleTapTimeout2, iAlpha3, 369154319, false, (String) objArr87[0], new Class[]{String.class});
                }
                long jLongValue16 = ((Long) ((Method) objComponent8).invoke(null, objArr86)).longValue();
                long j410 = 315091885623L + ((-657) * jLongValue16);
                long j411 = ((-478136398) | jLongValue16) ^ (-1);
                long j412 = ((jLongValue16 ^ (-1)) | 478136397) ^ (-1);
                long jNextInt6 = (478136397 | ((long) new Random().nextInt(1327696636))) ^ (-1);
                long j413 = (((j410 + ((-658) * ((j411 | j412) | jNextInt6))) + (658 * j412)) + (658 * (j412 | jNextInt6))) - 1452638282;
                i12 = ~i;
                i13 = ((int) (j413 >> 32)) & ((((-325434850) + (((~((-768305928) | i12)) | (-668920484)) * (-933))) + (((~((-668920484) | i12)) | 34898080) * 933)) - 2065029960);
                int i4914 = (int) j413;
                int i4915 = 818884229 + (((~(1007923308 | i)) | (-1033352574) | (~(429303101 | i))) * (-880));
                int i4916 = (~(1007923308 | i12)) | (-429303102);
                int i4917 = ~((-1007923309) | i);
                i14 = i4914 & (i4915 + ((i4916 | i4917) * (-880)) + (i4917 * 880));
                if (((i13 & i14) | (i13 ^ i14)) != 0) {
                    Object[] objArr88 = {new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int i4918 = ~((~((int) Runtime.getRuntime().totalMemory())) | 383867411);
                    int i4919 = i3 + ((14696467 | i4918) * (-374)) + 786707585 + ((i4918 | 369170944) * 374);
                    int i5010 = i4919 ^ (i4919 << 13);
                    int i5011 = i5010 >>> 17;
                    int i5012 = ((~i5010) & i5011) | ((~i5011) & i5010);
                    int i5013 = i5012 << 5;
                    ((int[]) objArr88[4])[0] = ((~i5012) & i5013) | ((~i5013) & i5012);
                    return objArr88;
                }
                Object[] objArr89 = {new int[]{i504}, new int[]{i}, null, null, new int[]{i511 ^ (i511 << 5)}};
                int i5014 = (~(i & 90)) & (i | 90);
                int i5015 = ~(i12 | (-881596803));
                int i5016 = (((((-934124995) | i5015) | (~(881596802 | i))) * (-338)) - 1985459895) + ((i5015 | (~(i | (-52528193)))) * 338);
                int i5017 = (i5016 & 16) + (i5016 | 16) + i3;
                int i5018 = i5017 << 13;
                int i5019 = (i5017 | i5018) & (~(i5017 & i5018));
                int i519 = i5019 >>> 17;
                int i5110 = ((~i5019) & i519) | ((~i519) & i5019);
                return objArr89;
            } catch (Throwable th14) {
                Throwable cause9 = th14.getCause();
                if (cause9 != null) {
                    throw cause9;
                }
                throw th14;
            }
        } catch (Throwable th15) {
            Throwable cause10 = th15.getCause();
            if (cause10 != null) {
                throw cause10;
            }
            throw th15;
        }
    }
}
