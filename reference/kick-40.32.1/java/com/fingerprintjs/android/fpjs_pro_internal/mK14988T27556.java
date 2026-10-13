package com.fingerprintjs.android.fpjs_pro_internal;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
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
import androidx.compose.runtime.GapComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import androidx.window.core.layout.WindowSizeClass;
import com.datadog.reactnative.ProxyAuthenticator;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class mK14988T27556 implements setScrollYX30569T8767 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static char[] component5;
    private static int component8;
    private static long component9;
    private static int setTopP6481;
    private final ActivityManager D8871;
    private final StatFs setPivotYN16904;
    private final StatFs vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, short r8) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = 101 - r8
            int r7 = r7 * 2
            int r0 = r7 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L14
            r3 = r7
            r4 = r2
            goto L29
        L14:
            r3 = r2
        L15:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            r3 = r1[r6]
            r5 = r3
            r3 = r8
            r8 = r5
        L29:
            int r8 = -r8
            int r8 = r8 + r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556.$$e(byte, short, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 97
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r0 = 4 - r6
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556.$$a
            byte[] r0 = new byte[r0]
            int r6 = 3 - r6
            r2 = 0
            if (r1 != 0) goto L15
            r4 = r8
            r3 = r2
            r8 = r7
            goto L2c
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 6
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556.b(int, int, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{Ascii.RS, -87, -60, -80, -6, 5, -3};
        $$b = WebmConstants.MkvEbmlElement.FLAG_LACING;
    }

    static void init$1() {
        $$c = new byte[]{44, -69, -1, 85};
        $$d = 80;
    }

    public static /* synthetic */ Object vD14832N6715(int i, int i2, Object[] objArr, int i3, int i4, int i5, int i6) {
        int i7 = ~i3;
        int i8 = ~((~i6) | i7);
        int i9 = ~i4;
        int i10 = i8 | (~(i9 | i6)) | (~(i3 | i6));
        int i11 = i7 | i6;
        int i12 = i9 | i11;
        int i13 = i3 + i6 + i + ((-1542968645) * i2) + (1789173782 * i5);
        int i14 = i13 * i13;
        int i15 = (1553370224 * i3) + 752877568 + ((-368479342) * i6) + (i10 * 1186558865) + (1921849566 * i11) + (1186558865 * i12) + ((-1555038208) * i) + (1802502144 * i2) + (148897792 * i5) + (289275904 * i14);
        int i16 = (i3 * (-930071408)) + 1959937684 + (i6 * (-930070194)) + (i10 * TypedValues.Motion.TYPE_PATHMOTION_ARC) + (i11 * (-1214)) + (i12 * TypedValues.Motion.TYPE_PATHMOTION_ARC) + (i * (-930070801)) + (i2 * 1059663509) + (i5 * (-1428764534)) + (i14 * 484573184);
        return i15 + ((i16 * i16) * 411172864) != 1 ? setPivotYN16904(objArr) : D8871(objArr);
    }

    public mK14988T27556(ActivityManager activityManager, StatFs statFs, StatFs statFs2) {
        this.D8871 = activityManager;
        this.vD14832N6715 = statFs;
        this.setPivotYN16904 = statFs2;
    }

    public static final /* synthetic */ ActivityManager D8871(mK14988T27556 mk14988t27556) {
        int i = 2 % 2;
        int i2 = component8;
        int i3 = (i2 ^ 117) + ((i2 & 117) << 1);
        int i4 = i3 % 128;
        setTopP6481 = i4;
        int i5 = i3 % 2;
        ActivityManager activityManager = mk14988t27556.D8871;
        int i6 = (i4 ^ 99) + ((i4 & 99) << 1);
        component8 = i6 % 128;
        int i7 = i6 % 2;
        return activityManager;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        mK14988T27556 mk14988t27556 = (mK14988T27556) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481 + 73;
        component8 = i2 % 128;
        int i3 = i2 % 2;
        StatFs statFs = mk14988t27556.vD14832N6715;
        if (i3 == 0) {
            return statFs;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "vD14832N6715", "()Ljava/lang/Long;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static final byte[] $$c = null;
        private static final int $$d = 0;
        private static int $10;
        private static int $11;
        private static int $component13;
        private static int $sG29839;
        private static char component5;
        private static char[] component9;
        private static char setPivotYN16904;
        private static char setTopP6481;
        private static char vD14832N6715;

        private static String $$e(short s, byte b, int i) {
            int i2 = 119 - s;
            byte[] bArr = $$c;
            int i3 = 4 - (b * 2);
            int i4 = i * 3;
            byte[] bArr2 = new byte[1 - i4];
            int i5 = 0 - i4;
            int i6 = -1;
            if (bArr == null) {
                i2 = (-i2) + i5;
                i3++;
                i6 = -1;
            }
            while (true) {
                int i7 = i6 + 1;
                bArr2[i7] = (byte) i2;
                if (i7 == i5) {
                    return new String(bArr2, 0);
                }
                i2 = (-bArr[i3]) + i2;
                i3++;
                i6 = i7;
            }
        }

        private static void a(short s, int i, byte b, Object[] objArr) {
            byte[] bArr = $$a;
            int i2 = i + 4;
            int i3 = 100 - s;
            int i4 = b * 3;
            byte[] bArr2 = new byte[4 - i4];
            int i5 = 3 - i4;
            int i6 = -1;
            if (bArr == null) {
                i3 = i5 + (-i3) + 6;
                i2 = i2;
                i6 = -1;
            }
            while (true) {
                int i7 = i6 + 1;
                bArr2[i7] = (byte) i3;
                int i8 = i2 + 1;
                if (i7 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i3 = i3 + (-bArr[i8]) + 6;
                i2 = i8;
                i6 = i7;
            }
        }

        static void init$0() {
            $$a = new byte[]{89, 101, -69, -28, -6, 5, -3};
            $$b = 242;
        }

        static void init$1() {
            $$c = new byte[]{101, -78, -82, -26};
            $$d = 40;
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ Long invoke() {
            int i = 2 % 2;
            int i2 = $sG29839 + 45;
            $component13 = i2 % 128;
            int i3 = i2 % 2;
            Long lVD14832N6715 = vD14832N6715();
            int i4 = $sG29839 + 65;
            $component13 = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = 71 / 0;
            }
            return lVD14832N6715;
        }

        public final Long vD14832N6715() {
            int i = 2 % 2;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManagerD8871 = mK14988T27556.D8871(mK14988T27556.this);
            Intrinsics.checkNotNull(activityManagerD8871);
            activityManagerD8871.getMemoryInfo(memoryInfo);
            Long lValueOf = Long.valueOf(memoryInfo.totalMem);
            int i2 = $sG29839;
            int i3 = (i2 & 95) + (i2 | 95);
            $component13 = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 18 / 0;
            }
            return lValueOf;
        }

        private static void c(String str, int i, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            char[] charArray = str != null ? str.toCharArray() : str;
            cj cjVar = new cj();
            char[] cArr = new char[charArray.length];
            cjVar.D8871 = 0;
            char[] cArr2 = new char[2];
            while (cjVar.D8871 < charArray.length) {
                int i3 = $10 + 75;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                cArr2[0] = charArray[cjVar.D8871];
                char c = 1;
                cArr2[1] = charArray[cjVar.D8871 + 1];
                int i5 = $11 + 83;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                int i7 = 58224;
                int i8 = 0;
                while (i8 < 16) {
                    char c2 = cArr2[c];
                    char c3 = cArr2[0];
                    char c4 = c;
                    int i9 = i8;
                    int i10 = (c3 + i7) ^ ((c3 << 4) + ((char) (((long) component5) ^ 2653044645608467852L)));
                    int i11 = c3 >>> 5;
                    try {
                        Object[] objArr2 = new Object[4];
                        objArr2[3] = Integer.valueOf(setTopP6481);
                        objArr2[2] = Integer.valueOf(i11);
                        objArr2[c4] = Integer.valueOf(i10);
                        objArr2[0] = Integer.valueOf(c2);
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 5420 - View.resolveSizeAndState(0, 0, 0), -1101845982, false, $$e((byte) ($$d >>> 2), (byte) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        char cCharValue = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        cArr2[c4] = cCharValue;
                        char c5 = cArr2[0];
                        int i12 = (cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) setPivotYN16904) ^ 2653044645608467852L)));
                        int i13 = cCharValue >>> 5;
                        Object[] objArr3 = new Object[4];
                        objArr3[3] = Integer.valueOf(vD14832N6715);
                        objArr3[2] = Integer.valueOf(i13);
                        objArr3[c4] = Integer.valueOf(i12);
                        objArr3[0] = Integer.valueOf(c5);
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (Process.myTid() >> 22), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 5420 - View.getDefaultSize(0, 0), -1101845982, false, $$e((byte) ($$d >>> 2), (byte) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[0] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                        i7 -= 40503;
                        i8 = i9 + 1;
                        int i14 = $11 + 63;
                        $10 = i14 % 128;
                        int i15 = i14 % 2;
                        c = c4;
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
                Object[] objArr4 = new Object[2];
                objArr4[c6] = cjVar;
                objArr4[0] = cjVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-417400915);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(58 - ((Process.getThreadPriority(0) + 20) >> 6), (char) View.combineMeasuredStates(0, 0), 1187 - (KeyEvent.getMaxKeyCode() >> 16), -1247038514, false, "k", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            }
            String str2 = new String(cArr, 0, i);
            int i16 = $10 + 57;
            $11 = i16 % 128;
            if (i16 % 2 != 0) {
                objArr[0] = str2;
            } else {
                int i17 = 53 / 0;
                objArr[0] = str2;
            }
        }

        private static void b(String str, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            int i;
            char c;
            String str2 = str;
            int i2 = 2;
            int i3 = 2 % 2;
            Object bytes = str2;
            if (str2 != null) {
                bytes = str2.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            co coVar = new co();
            int i4 = iArr[0];
            int i5 = iArr[1];
            int i6 = iArr[2];
            int i7 = iArr[3];
            char[] cArr = component9;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i8 = 0;
                while (i8 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr[i8])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1270499692);
                        if (objComponent5 == null) {
                            int iMyPid = (Process.myPid() >> 22) + 59;
                            char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                            int mirror = AndroidCharacter.getMirror('0') + 4409;
                            byte length2 = (byte) $$c.length;
                            byte b = (byte) (length2 - 4);
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyPid, jumpTapTimeout, mirror, 420416783, false, $$e(length2, b, b), new Class[]{Integer.TYPE});
                        }
                        cArr2[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        i8++;
                        i2 = i2;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr = cArr2;
            }
            int i9 = i2;
            char c2 = '0';
            char[] cArr3 = new char[i5];
            System.arraycopy(cArr, i4, cArr3, 0, i5);
            if (bArr != null) {
                char[] cArr4 = new char[i5];
                coVar.component5 = 0;
                char c3 = 0;
                while (coVar.component5 < i5) {
                    if (bArr[coVar.component5] == 1) {
                        int i10 = $11 + 49;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        int i12 = coVar.component5;
                        char c4 = cArr3[coVar.component5];
                        Object[] objArr3 = new Object[i9];
                        objArr3[1] = Integer.valueOf(c3);
                        objArr3[0] = Integer.valueOf(c4);
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1589966753);
                        if (objComponent6 == null) {
                            c = c2;
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (Color.rgb(0, 0, 0) + 16792595), TextUtils.lastIndexOf("", c) + 2257, -208778180, false, "q", new Class[]{Integer.TYPE, Integer.TYPE});
                        } else {
                            c = c2;
                        }
                        cArr4[i12] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                        int i13 = $10 + 73;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                    } else {
                        c = c2;
                        int i15 = coVar.component5;
                        Object[] objArr4 = {Integer.valueOf(cArr3[coVar.component5]), Integer.valueOf(c3)};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1656784792);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (KeyEvent.keyCodeFromString("") + 27302), 2979 - Color.red(0), -813024245, false, $$e((short) 7, (byte) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i15] = ((Character) ((Method) objComponent7).invoke(null, objArr4)).charValue();
                    }
                    c3 = cArr4[coVar.component5];
                    Object[] objArr5 = {coVar, coVar};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(787585964);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 51, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 7091 - Process.getGidForName(""), 2084888527, false, $$e((short) 0, (byte) 0, 0), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent8).invoke(null, objArr5);
                    c2 = c;
                    i9 = 2;
                }
                cArr3 = cArr4;
            }
            if (i7 > 0) {
                char[] cArr5 = new char[i5];
                System.arraycopy(cArr3, 0, cArr5, 0, i5);
                int i16 = i5 - i7;
                System.arraycopy(cArr5, 0, cArr3, i16, i7);
                System.arraycopy(cArr5, i7, cArr3, 0, i16);
            }
            if (z) {
                int i17 = $10 + 113;
                $11 = i17 % 128;
                int i18 = i17 % 2;
                char[] cArr6 = new char[i5];
                coVar.component5 = 0;
                while (coVar.component5 < i5) {
                    int i19 = $10 + 77;
                    $11 = i19 % 128;
                    if (i19 % 2 == 0) {
                        cArr6[coVar.component5] = cArr3[(i5 - coVar.component5) << 1];
                        i = coVar.component5;
                    } else {
                        cArr6[coVar.component5] = cArr3[(i5 - coVar.component5) - 1];
                        i = coVar.component5 + 1;
                    }
                    coVar.component5 = i;
                }
                cArr3 = cArr6;
            }
            if (i6 > 0) {
                coVar.component5 = 0;
                while (coVar.component5 < i5) {
                    cArr3[coVar.component5] = (char) (cArr3[coVar.component5] - iArr[2]);
                    coVar.component5++;
                }
            }
            objArr[0] = new String(cArr3);
        }

        static {
            init$1();
            $10 = 0;
            $11 = 1;
            init$0();
            $component13 = 0;
            $sG29839 = 1;
            component9 = new char[]{46693, 46766, 46664, 46661, 46754, 46759, 46757, 46763, 46762, 46759, 46757, 46701, 46775, 46769, 46774, 46771, 46776, 46677, 46801, 46807, 46802, 46799, 46797, 46804, 46807, 46680, 46833, 46838, 46804, 46807, 46796, 46803, 46803, 46802, 46836, 46832, 46798, 46798, 46804, 46800, 46794, 46789, 46802, 46811, 46810, 46802, 46802, 46805, 46619, 46665, 46665, 46673, 46678, 46665, 46656, 46657, 46671, 46675, 46661, 46661, 46703, 46703, 46667, 46670, 46673, 46676, 46676, 46706, 46707, 46665, 46670, 46670, 46667, 46674, 46675, 46701, 46700, 46674, 46608, 46699, 46700, 46674, 46665, 46666, 46661, 46659, 46662, 46661, 46668, 46665, 46657, 46717, 46816, 46817, 46822, 46827, 46819, 46794, 46786, 46837, 46837, 46791, 46842, 46788, 46614, 46665, 46665, 46668, 46706, 46698, 46662, 46657, 46665, 46668, 46696, 46706, 46664, 46618, 46670, 46670, 46675, 46675, 46666, 46740, 46742, 46838, 46833, 46832, 46772, 46855, 46668, 46790, 46824, 46817, 46845, 46844, 46790, 46789, 46791, 46789, 46661, 46829, 46828, 46821, 46826, 46821, 46823, 46824, 46616, 46675, 46675, 46673, 46665, 46667, 46668, 46623, 46678, 46679, 46684, 46680, 46682, 46754, 46619, 46673, 46697, 46772, 46701, 46783, 46777, 46720, 46734, 46725, 46725, 46721, 46723, 46668, 46788, 46792, 46825, 46835, 46797, 46791, 46844, 46786, 46788, 46686, 46805, 46811, 46809, 46801, 46838, 46846, 46808, 46802, 46795, 46793, 46739, 46797, 46789, 46804, 46807, 46809, 46807, 46619, 46673, 46670, 46667, 46700, 46698, 46663, 46665, 46700, 46707, 46676, 46621, 46686, 46676, 46681, 46656, 46717, 46680, 46687, 46758, 46757, 46757, 46656, 46613, 46665, 46663, 46698, 46706, 46674, 46667, 46667, 46667, 46671, 46704, 46622, 46681, 46676, 46669, 46754, 46611, 46665, 46670, 46696, 46764, 46910, 46910, 46907, 46805, 46803, 46902, 46906, 46897, 46899, 46800, 46806, 46902, 46645, 46703, 46660, 46656, 46667, 46671, 46703, 46698, 46664, 46664, 46656, 46699, 46611, 46698, 46703, 46660, 46656, 46667, 46671, 46703, 46698, 46664, 46664, 46656, 46699, 46605, 46700, 46665, 46645, 46696, 46657, 46663, 46664, 46669, 46664, 46657, 46663, 46696, 46605, 46707, 46676, 46676, 46673, 46670, 46667, 46700, 46698, 46663, 46665, 46761, 46756, 46685, 46775, 46702, 46760, 46752, 46771, 46770, 46772, 46770, 46702, 46702, 46754, 46796, 46836, 46835, 46794, 46788, 46602, 46664, 46760, 46771, 46768, 46674, 46715, 46736, 46768, 46775, 46741, 46743, 46743, 46678, 46888, 46861, 46861, 46888, 46881, 46855, 46888, 46888, 46855, 46851, 46849, 46854, 46856, 46861, 46894, 46890, 46858, 46852, 46849, 46909, 46853, 46616, 46673, 46667, 46664, 46673};
            setPivotYN16904 = (char) 35040;
            vD14832N6715 = (char) 23647;
            component5 = (char) 40476;
            setTopP6481 = (char) 54727;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0a5f  */
        /* JADX WARN: Code duplicated, block: B:134:0x11c9 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:135:0x11cb  */
        /* JADX WARN: Code duplicated, block: B:138:0x11ed A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:142:0x1300  */
        /* JADX WARN: Code duplicated, block: B:145:0x1306  */
        /* JADX WARN: Code duplicated, block: B:148:0x1341 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:149:0x138d  */
        /* JADX WARN: Code duplicated, block: B:153:0x143c  */
        /* JADX WARN: Code duplicated, block: B:154:0x143e  */
        /* JADX WARN: Code duplicated, block: B:158:0x145c  */
        /* JADX WARN: Code duplicated, block: B:235:0x1d89 A[Catch: all -> 0x1e82, TryCatch #0 {all -> 0x1e82, blocks: (B:233:0x1d7c, B:235:0x1d89, B:236:0x1dd1), top: B:509:0x1d7c, outer: #14 }] */
        /* JADX WARN: Code duplicated, block: B:238:0x1dda A[Catch: Exception -> 0x1e94, TRY_ENTER, TryCatch #14 {Exception -> 0x1e94, blocks: (B:218:0x1c59, B:224:0x1cd2, B:228:0x1cfd, B:232:0x1d28, B:238:0x1dda, B:241:0x1dfd, B:247:0x1e70, B:249:0x1e76, B:251:0x1e7a, B:253:0x1e80, B:254:0x1e81, B:256:0x1e83, B:258:0x1e89, B:259:0x1e8a, B:261:0x1e8c, B:263:0x1e92, B:264:0x1e93, B:233:0x1d7c, B:235:0x1d89, B:236:0x1dd1, B:219:0x1c70, B:221:0x1c7d, B:222:0x1cc7, B:242:0x1e16, B:244:0x1e23, B:245:0x1e65), top: B:521:0x1c59, inners: #0, #11, #19 }] */
        /* JADX WARN: Code duplicated, block: B:240:0x1dfb  */
        /* JADX WARN: Code duplicated, block: B:241:0x1dfd A[Catch: Exception -> 0x1e94, TRY_LEAVE, TryCatch #14 {Exception -> 0x1e94, blocks: (B:218:0x1c59, B:224:0x1cd2, B:228:0x1cfd, B:232:0x1d28, B:238:0x1dda, B:241:0x1dfd, B:247:0x1e70, B:249:0x1e76, B:251:0x1e7a, B:253:0x1e80, B:254:0x1e81, B:256:0x1e83, B:258:0x1e89, B:259:0x1e8a, B:261:0x1e8c, B:263:0x1e92, B:264:0x1e93, B:233:0x1d7c, B:235:0x1d89, B:236:0x1dd1, B:219:0x1c70, B:221:0x1c7d, B:222:0x1cc7, B:242:0x1e16, B:244:0x1e23, B:245:0x1e65), top: B:521:0x1c59, inners: #0, #11, #19 }] */
        /* JADX WARN: Code duplicated, block: B:244:0x1e23 A[Catch: all -> 0x1e79, TryCatch #19 {all -> 0x1e79, blocks: (B:242:0x1e16, B:244:0x1e23, B:245:0x1e65), top: B:530:0x1e16, outer: #14 }] */
        /* JADX WARN: Code duplicated, block: B:332:0x243b  */
        /* JADX WARN: Code duplicated, block: B:333:0x243e  */
        /* JADX WARN: Code duplicated, block: B:335:0x2441  */
        /* JADX WARN: Code duplicated, block: B:337:0x24ec  */
        /* JADX WARN: Code duplicated, block: B:343:0x251d  */
        /* JADX WARN: Code duplicated, block: B:345:0x2530  */
        /* JADX WARN: Code duplicated, block: B:347:0x253a  */
        /* JADX WARN: Code duplicated, block: B:349:0x2548 A[Catch: all -> 0x25a7, IOException -> 0x25b3, TRY_ENTER, TRY_LEAVE, TryCatch #19 {IOException -> 0x25b3, all -> 0x25a7, blocks: (B:340:0x2516, B:349:0x2548), top: B:534:0x2516 }] */
        /* JADX WARN: Code duplicated, block: B:355:0x259d A[LOOP:9: B:346:0x2538->B:355:0x259d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:370:0x25b9  */
        /* JADX WARN: Code duplicated, block: B:372:0x26fa  */
        /* JADX WARN: Code duplicated, block: B:375:0x2704 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:379:0x27d2  */
        /* JADX WARN: Code duplicated, block: B:381:0x2855  */
        /* JADX WARN: Code duplicated, block: B:384:0x285e A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:388:0x2939  */
        /* JADX WARN: Code duplicated, block: B:389:0x2940  */
        /* JADX WARN: Code duplicated, block: B:391:0x2943  */
        /* JADX WARN: Code duplicated, block: B:392:0x29fa  */
        /* JADX WARN: Code duplicated, block: B:395:0x2a03 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:399:0x2ad3  */
        /* JADX WARN: Code duplicated, block: B:400:0x2b54  */
        /* JADX WARN: Code duplicated, block: B:403:0x2b5d A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:407:0x2c43  */
        /* JADX WARN: Code duplicated, block: B:408:0x2cef  */
        /* JADX WARN: Code duplicated, block: B:411:0x2cf8 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:415:0x2dca  */
        /* JADX WARN: Code duplicated, block: B:416:0x2e44  */
        /* JADX WARN: Code duplicated, block: B:420:0x2efb  */
        /* JADX WARN: Code duplicated, block: B:422:0x2f0a  */
        /* JADX WARN: Code duplicated, block: B:424:0x2f11  */
        /* JADX WARN: Code duplicated, block: B:427:0x2f23 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:431:0x3005  */
        /* JADX WARN: Code duplicated, block: B:433:0x307b  */
        /* JADX WARN: Code duplicated, block: B:436:0x3084 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:440:0x315b  */
        /* JADX WARN: Code duplicated, block: B:442:0x31d9  */
        /* JADX WARN: Code duplicated, block: B:445:0x3221 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:449:0x32e6  */
        /* JADX WARN: Code duplicated, block: B:451:0x3378  */
        /* JADX WARN: Code duplicated, block: B:454:0x33f9 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:458:0x34da  */
        /* JADX WARN: Code duplicated, block: B:460:0x358f  */
        /* JADX WARN: Code duplicated, block: B:463:0x359a A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:467:0x3675  */
        /* JADX WARN: Code duplicated, block: B:469:0x36e7  */
        /* JADX WARN: Code duplicated, block: B:472:0x36f1 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:476:0x37d3  */
        /* JADX WARN: Code duplicated, block: B:478:0x3854 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:479:0x3855  */
        /* JADX WARN: Code duplicated, block: B:481:0x3858  */
        /* JADX WARN: Code duplicated, block: B:484:0x3880 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:515:0x25a3 A[EXC_TOP_SPLITTER, PHI: r3
          0x25a3: PHI (r3v69 java.io.BufferedInputStream) = (r3v68 java.io.BufferedInputStream), (r3v556 java.io.BufferedInputStream) binds: [B:366:0x25b3, B:342:0x251b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:53:0x04b3 A[Catch: all -> 0x3975, PHI: r0 r3 r35
          0x04b3: PHI (r0v801 java.lang.Object) = (r0v800 java.lang.Object), (r0v855 java.lang.Object) binds: [B:52:0x04b1, B:40:0x03cf] A[DONT_GENERATE, DONT_INLINE]
          0x04b3: PHI (r3v859 java.lang.Object) = (r3v850 java.lang.Object), (r3v966 java.lang.Object) binds: [B:52:0x04b1, B:40:0x03cf] A[DONT_GENERATE, DONT_INLINE]
          0x04b3: PHI (r35v14 int) = (r35v13 int), (r12v9 int) binds: [B:52:0x04b1, B:40:0x03cf] A[DONT_GENERATE, DONT_INLINE], TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:559:0x254e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:55:0x04ca A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:560:? A[LOOP:8: B:534:0x2516->B:560:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x07b8 A[DONT_INVERT, EDGE_INSN: B:75:0x07b8->B:104:0x0b13 BREAK  A[LOOP:0: B:24:0x0299->B:102:0x0b07]] */
        /* JADX WARN: Code duplicated, block: B:76:0x07ba A[Catch: all -> 0x3975, TRY_ENTER, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x07d2 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:82:0x08bc A[PHI: r35
          0x08bc: PHI (r35v15 int) = (r35v14 int), (r35v16 int), (r35v16 int), (r35v16 int) binds: [B:58:0x05c7, B:81:0x08ba, B:74:0x07b6, B:65:0x06d5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:84:0x08c2  */
        /* JADX WARN: Code duplicated, block: B:87:0x08f3 A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:91:0x09cd  */
        /* JADX WARN: Code duplicated, block: B:92:0x09d3  */
        /* JADX WARN: Code duplicated, block: B:93:0x09d8  */
        /* JADX WARN: Code duplicated, block: B:96:0x09fb A[Catch: all -> 0x3975, TryCatch #17 {all -> 0x3975, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x003d, B:12:0x01c1, B:15:0x01db, B:17:0x0220, B:30:0x0310, B:32:0x031d, B:33:0x035c, B:35:0x0376, B:37:0x0383, B:39:0x03c9, B:60:0x05cb, B:62:0x05e2, B:63:0x0619, B:85:0x08e6, B:87:0x08f3, B:88:0x092b, B:105:0x0e57, B:107:0x0e64, B:108:0x0eaa, B:111:0x0ee2, B:113:0x0ef1, B:114:0x0f2b, B:118:0x0ff3, B:120:0x1000, B:121:0x1044, B:123:0x1060, B:125:0x106d, B:126:0x10b1, B:128:0x10ba, B:130:0x10d3, B:131:0x1108, B:146:0x1334, B:148:0x1341, B:150:0x138f, B:136:0x11d5, B:138:0x11ed, B:139:0x1223, B:161:0x14e4, B:163:0x14f1, B:164:0x1527, B:166:0x15e1, B:168:0x15ee, B:169:0x1628, B:179:0x17b1, B:181:0x17be, B:182:0x17fa, B:184:0x18b6, B:186:0x18c3, B:187:0x18f6, B:205:0x1adf, B:207:0x1aec, B:208:0x1b24, B:270:0x1f14, B:272:0x1f21, B:273:0x1f69, B:285:0x2211, B:287:0x221e, B:288:0x225e, B:373:0x26fe, B:375:0x2704, B:376:0x273c, B:425:0x2f12, B:427:0x2f23, B:428:0x2f63, B:434:0x307e, B:436:0x3084, B:437:0x30bd, B:443:0x31fa, B:445:0x3221, B:446:0x325b, B:452:0x33ec, B:454:0x33f9, B:455:0x3436, B:461:0x3594, B:463:0x359a, B:464:0x35d4, B:470:0x36eb, B:472:0x36f1, B:473:0x3727, B:482:0x3859, B:484:0x3880, B:485:0x38cb, B:382:0x2858, B:384:0x285e, B:385:0x2896, B:393:0x29fd, B:395:0x2a03, B:396:0x2a3e, B:401:0x2b57, B:403:0x2b5d, B:404:0x2b95, B:409:0x2cf2, B:411:0x2cf8, B:412:0x2d2e, B:94:0x09ee, B:96:0x09fb, B:97:0x0a3e, B:69:0x06dc, B:71:0x06f2, B:72:0x0726, B:76:0x07ba, B:78:0x07d2, B:79:0x080a, B:53:0x04b3, B:55:0x04ca, B:56:0x0501, B:43:0x03ed, B:45:0x03fa, B:46:0x0443, B:48:0x045d, B:50:0x046a, B:51:0x04ab), top: B:526:0x0008 }] */
        /* JADX WARN: Incorrect type for immutable var: ssa=int, code=??, for r7v137, types: [int, short] */
        /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5542 (expected less than 5000) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v137, types: [int, short] */
        /* JADX WARN: Type inference failed for: r7v154 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object[] component5$6ed60776(int r72, java.lang.Object r73) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 14718
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556.AnonymousClass1.component5$6ed60776(int, java.lang.Object):java.lang.Object[]");
        }

        AnonymousClass1() {
            super(0);
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.setScrollYX30569T8767
    public final long setPivotYN16904() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new AnonymousClass1(), 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.indexOf("", "", 0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), MotionEvent.axisFromString("") + 1804, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = setTopP6481 + 115;
                int i3 = i2 % 128;
                component8 = i3;
                int i4 = i2 % 2;
                int i5 = ((i3 | 75) << 1) - (i3 ^ 75);
                setTopP6481 = i5 % 128;
                int i6 = i5 % 2;
                objInvoke = 0L;
            }
            long jLongValue = ((Number) objInvoke).longValue();
            int i7 = component8;
            int i8 = ((i7 | 119) << 1) - (i7 ^ 119);
            setTopP6481 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 39 / 0;
            }
            return jLongValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.mK14988T27556$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "component5", "()Ljava/lang/Long;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function0<Long> {
        private static int $D8871 = 0;
        private static int $component9 = 1;
        public static int component5;
        public static int setPivotYN16904;

        public final Long component5() {
            int i = 2 % 2;
            int i2 = $component9;
            int i3 = (i2 ^ 107) + ((i2 & 107) << 1);
            $D8871 = i3 % 128;
            int i4 = i3 % 2;
            StatFs statFs = (StatFs) mK14988T27556.vD14832N6715(br.AnonymousClass2.component9(), br.AnonymousClass2.component9(), new Object[]{mK14988T27556.this}, 1880456421, br.AnonymousClass2.component9(), br.AnonymousClass2.component9(), -1880456420);
            Intrinsics.checkNotNull(statFs);
            Long lValueOf = Long.valueOf(statFs.getTotalBytes());
            int i5 = $component9 + 1;
            $D8871 = i5 % 128;
            if (i5 % 2 == 0) {
                return lValueOf;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ Long invoke() {
            int i = 2 % 2;
            int i2 = $component9;
            int i3 = (i2 & 123) + (i2 | 123);
            $D8871 = i3 % 128;
            int i4 = i3 % 2;
            Long lComponent5 = component5();
            int i5 = $D8871 + 51;
            $component9 = i5 % 128;
            if (i5 % 2 != 0) {
                return lComponent5;
            }
            throw null;
        }

        public static int setPivotYN16904() {
            int i = setPivotYN16904;
            int i2 = i % 6759648;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            component5 = iUptimeMillis;
            return iUptimeMillis;
        }

        AnonymousClass4() {
            super(0);
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.setScrollYX30569T8767
    public final long component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new AnonymousClass4(), 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 51, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 1803 - Color.blue(0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = component8;
                int i3 = (i2 ^ 19) + ((i2 & 19) << 1);
                int i4 = i3 % 128;
                setTopP6481 = i4;
                int i5 = i3 % 2;
                int i6 = i4 + GapComposerKt.nodeKey;
                component8 = i6 % 128;
                int i7 = i6 % 2;
                objInvoke = 0L;
            } else {
                int i8 = component8 + 83;
                setTopP6481 = i8 % 128;
                int i9 = i8 % 2;
            }
            long jLongValue = ((Number) objInvoke).longValue();
            int i10 = component8;
            int i11 = (i10 & 87) + (i10 | 87);
            setTopP6481 = i11 % 128;
            int i12 = i11 % 2;
            return jLongValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f4  */
    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        Object obj;
        Throwable cause;
        long j;
        int i3;
        int i4 = 2 % 2;
        ck ckVar = new ck();
        long[] jArr = new long[i2];
        int i5 = 0;
        ckVar.setPivotYN16904 = 0;
        while (true) {
            obj = null;
            if (ckVar.setPivotYN16904 >= i2) {
                break;
            }
            int i6 = ckVar.setPivotYN16904;
            try {
                Object[] objArr2 = {Integer.valueOf(component5[i + i6])};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                if (objComponent5 == null) {
                    int iGreen = 51 - Color.green(i5);
                    char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', i5, i5) + 1);
                    j = 0;
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 5904;
                    byte b = $$c[2];
                    i3 = -720328195;
                    byte b2 = (byte) (b + 1);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iGreen, cIndexOf, longPressTimeout, -173582907, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                } else {
                    j = 0;
                    i3 = -720328195;
                }
                Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                l.longValue();
                long j2 = i6;
                long j3 = component9;
                Object[] objArr3 = new Object[4];
                objArr3[3] = Integer.valueOf(c);
                objArr3[2] = Long.valueOf(j3);
                objArr3[r11] = Long.valueOf(j2);
                objArr3[i5] = l;
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                if (objComponent6 == null) {
                    int iLastIndexOf = 51 - TextUtils.lastIndexOf("", '0');
                    char offsetAfter = (char) TextUtils.getOffsetAfter("", i5);
                    int i7 = 5059 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte b3 = $$c[2];
                    byte b4 = b3;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf, offsetAfter, i7, 2120479290, false, $$e(b4, (byte) (b4 + 1), (byte) (-b3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i6] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                Object[] objArr4 = new Object[2];
                objArr4[1] = ckVar;
                objArr4[i5] = ckVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent7 == null) {
                    int i8 = i5;
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(50 - TextUtils.lastIndexOf("", '0', i8, i8), (char) Color.alpha(i8), 2464 - ExpandableListView.getPackedPositionType(j), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                i5 = 0;
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        char[] cArr = new char[i2];
        ckVar.setPivotYN16904 = 0;
        int i9 = $11 + 81;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        while (ckVar.setPivotYN16904 < i2) {
            int i11 = $10 + 63;
            $11 = i11 % 128;
            if (i11 % 2 == 0) {
                cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                Object[] objArr5 = {ckVar, ckVar};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf("", ""), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), 2464 - Gravity.getAbsoluteGravity(0, 0), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
                obj.hashCode();
                throw null;
            }
            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
            Object[] objArr6 = {ckVar, ckVar};
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(-720328195);
            if (objComponent9 == null) {
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(50 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), 2465 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), -2019168866, false, "a", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent9).invoke(null, objArr6);
            int i12 = $10 + 21;
            $11 = i12 % 128;
            if (i12 % 2 == 0) {
                int i13 = 4 / 4;
            }
        }
        objArr[0] = new String(cArr);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0d31  */
    /* JADX WARN: Code duplicated, block: B:191:0x1463 A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:195:0x154c  */
    /* JADX WARN: Code duplicated, block: B:196:0x155e  */
    /* JADX WARN: Code duplicated, block: B:268:0x27bd  */
    /* JADX WARN: Code duplicated, block: B:281:0x29aa A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:284:0x29e1  */
    /* JADX WARN: Code duplicated, block: B:285:0x29e4 A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:287:0x29fd A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:298:0x2f1d  */
    /* JADX WARN: Code duplicated, block: B:301:0x2f2c A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:306:0x300f  */
    /* JADX WARN: Code duplicated, block: B:308:0x3098 A[Catch: all -> 0x3ad4, TRY_ENTER, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:310:0x30a5 A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:317:0x31a1  */
    /* JADX WARN: Code duplicated, block: B:329:0x34c7  */
    /* JADX WARN: Code duplicated, block: B:331:0x34e5  */
    /* JADX WARN: Code duplicated, block: B:334:0x3509 A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:335:0x3548  */
    /* JADX WARN: Code duplicated, block: B:340:0x3602 A[LOOP:6: B:330:0x34e3->B:340:0x3602, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:345:0x3634  */
    /* JADX WARN: Code duplicated, block: B:347:0x36ad  */
    /* JADX WARN: Code duplicated, block: B:352:0x3765 A[Catch: all -> 0x383f, TryCatch #6 {all -> 0x383f, blocks: (B:350:0x3756, B:352:0x3765, B:353:0x379c), top: B:398:0x3756, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:357:0x382c  */
    /* JADX WARN: Code duplicated, block: B:358:0x3831  */
    /* JADX WARN: Code duplicated, block: B:367:0x384f  */
    /* JADX WARN: Code duplicated, block: B:369:0x38c6  */
    /* JADX WARN: Code duplicated, block: B:372:0x38f9 A[Catch: all -> 0x3ad4, TryCatch #3 {all -> 0x3ad4, blocks: (B:6:0x010b, B:8:0x0118, B:10:0x0152, B:23:0x0344, B:25:0x0351, B:26:0x0389, B:39:0x0506, B:41:0x0513, B:42:0x054f, B:69:0x0785, B:71:0x078b, B:72:0x07c4, B:106:0x0ace, B:108:0x0adb, B:109:0x0b12, B:119:0x0cb2, B:121:0x0cbf, B:122:0x0cf5, B:132:0x0e35, B:134:0x0e44, B:135:0x0e7f, B:147:0x1002, B:149:0x100f, B:150:0x1041, B:161:0x11f4, B:163:0x1201, B:164:0x1231, B:201:0x15d6, B:203:0x15dc, B:204:0x160d, B:209:0x1727, B:211:0x1738, B:212:0x1771, B:221:0x18be, B:223:0x18cb, B:224:0x18ff, B:226:0x1908, B:228:0x191e, B:230:0x1953, B:279:0x299d, B:281:0x29aa, B:282:0x29d8, B:299:0x2f1f, B:301:0x2f2c, B:302:0x2f6a, B:308:0x3098, B:310:0x30a5, B:311:0x30e2, B:332:0x34f7, B:334:0x3509, B:336:0x354c, B:370:0x38ec, B:372:0x38f9, B:373:0x3930, B:285:0x29e4, B:287:0x29fd, B:288:0x2a2f, B:239:0x2508, B:241:0x2515, B:243:0x2554, B:253:0x25cf, B:255:0x25de, B:257:0x261d, B:262:0x26ce, B:264:0x26dd, B:265:0x271d, B:189:0x1454, B:191:0x1463, B:192:0x14a0, B:47:0x0642, B:49:0x064f, B:50:0x0681, B:56:0x06c1, B:58:0x06ce, B:59:0x0704), top: B:393:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:376:0x39e9  */
    /* JADX WARN: Code duplicated, block: B:378:0x3a5a  */
    /* JADX WARN: Code duplicated, block: B:410:0x31b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:411:0x31b3 A[EDGE_INSN: B:411:0x31b3->B:321:0x31b3 BREAK  A[LOOP:4: B:296:0x2f19->B:319:0x31a6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:412:0x318b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x31a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x31a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:415:0x3630 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:0x35f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x09b8  */
    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) throws Throwable {
        int i;
        Object obj;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Object objComponent5;
        int i13;
        int i14;
        int i15;
        int i16;
        Object obj2;
        int i17;
        int i18;
        Object[] objArr2;
        int i19;
        Object objComponent6;
        Object objInvoke;
        Object objComponent7;
        int i20;
        String[][] strArr;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object objComponent8;
        int i27;
        Object objComponent9;
        int i28;
        int i29;
        String str2;
        int i30;
        String[] strArr2;
        int length;
        int i31;
        Object objComponent10;
        int i32;
        int i33;
        String[] strArr3;
        int i34;
        int i35;
        String str3;
        Object objComponent11;
        int i36;
        int i37;
        Object[] objArr3;
        Object objComponent12;
        int i38;
        int i39;
        int i40;
        String next;
        byte b = 0;
        int i41 = 1;
        int iIntValue = ((Number) objArr[1]).intValue();
        ((Number) objArr[2]).intValue();
        int i42 = 3;
        int iIntValue2 = ((Number) objArr[3]).intValue();
        int i43 = 2 % 2;
        int i44 = setTopP6481;
        int i45 = (i44 & 61) + (i44 | 61);
        component8 = i45 % 128;
        int i46 = i45 % 2;
        Object[] objArr4 = new Object[1];
        a((char) Color.red(0), 717 - (~(-(-TextUtils.indexOf((CharSequence) "", '0', 0)))), 8 - View.resolveSize(0, 0), objArr4);
        String str4 = (String) objArr4[0];
        Object[] objArr5 = new Object[1];
        a((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), ViewConfiguration.getScrollBarFadeDuration() >> 16, 26 - (~(ViewConfiguration.getScrollBarFadeDuration() >> 16)), objArr5);
        String str5 = (String) objArr5[0];
        char mirror = AndroidCharacter.getMirror('0');
        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 27;
        int i47 = -ImageFormat.getBitsPerPixel(0);
        int i48 = (i47 & 24) + (i47 | 24);
        Object[] objArr6 = new Object[1];
        a((char) ((mirror & (-48)) + (mirror | (-48))), iKeyCodeFromString, i48, objArr6);
        String str6 = (String) objArr6[0];
        int i49 = -TextUtils.lastIndexOf("", '0', 0);
        int i50 = -(-(ViewConfiguration.getLongPressTimeout() >> 16));
        int i51 = (i50 ^ 52) + ((i50 & 52) << 1);
        int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("");
        int i52 = ((iKeyCodeFromString2 | 18) << 1) - (iKeyCodeFromString2 ^ 18);
        Object[] objArr7 = new Object[1];
        a((char) ((i49 & 20751) + (i49 | 20751)), i51, i52, objArr7);
        String str7 = (String) objArr7[0];
        int i53 = -1;
        Object[] objArr8 = new Object[1];
        a((char) ((-2) - ((-TextUtils.lastIndexOf("", '0', 0, 0)) ^ (-1))), 68 - (~(-TextUtils.indexOf((CharSequence) "", '0', 0))), ((Process.getThreadPriority(0) + 20) >> 6) + 28, objArr8);
        String[] strArr4 = {str5, str6, str7, (String) objArr8[0]};
        int i54 = 0;
        while (true) {
            i = 4;
            if (i54 >= 4) {
                obj = null;
                i = 4;
                i2 = iIntValue;
                break;
            }
            int i55 = component8;
            int i56 = (i55 ^ 17) + ((i55 & 17) << 1);
            setTopP6481 = i56 % 128;
            int i57 = i56 % 2;
            try {
                Object[] objArr9 = {strArr4[i54]};
                Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent13 == null) {
                    int defaultSize = View.getDefaultSize(0, 0) + 52;
                    char c = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 59725);
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 6317;
                    Object[] objArr10 = new Object[1];
                    b(1, i53, (byte) 1, objArr10);
                    objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(defaultSize, c, iIndexOf, 369154319, false, (String) objArr10[0], new Class[]{String.class});
                }
                long jLongValue = ((Long) ((Method) objComponent13).invoke(null, objArr9)).longValue();
                long j = jLongValue ^ (-1);
                long j2 = (887217140 | j) ^ (-1);
                long jMyPid = Process.myPid();
                long j3 = ((((394811627745L + ((-445) * jLongValue)) + ((j2 | ((j | (jMyPid ^ (-1))) ^ (-1))) * 446)) + (((((j | (-887217141)) | jMyPid) ^ (-1)) | ((887217140 | jLongValue) ^ (-1))) * 446)) + (446 * j2)) - 87284744;
                int iNextInt = new Random().nextInt();
                obj = null;
                int i58 = ((int) (j3 >> 32)) & ((-1773510606) + (((~((~iNextInt) | (-805881097))) | (~(2051859788 | iNextInt))) * (-318)) + ((1245978688 | (~((-2051859785) | iNextInt))) * (-318)) + (((~(iNextInt | 2051859784)) | 805881100) * TypedValues.Attributes.TYPE_PIVOT_TARGET));
                int iNextInt2 = new Random().nextInt();
                int i59 = ((int) j3) & (2088992125 + (((-1100301382) | iNextInt2) * 376) + (((~((~iNextInt2) | (-1251657975))) | 168462514) * (-376)) + (((~(iNextInt2 | 1251657974)) | (-185568436)) * 376));
                if (((i59 & i58) | (i58 ^ i59)) != 0) {
                    int i60 = i54 + 190;
                    i2 = ((~i60) & iIntValue) | (i60 & (~iIntValue));
                    break;
                }
                i54 = ((i54 & 1) << 1) + (i54 ^ 1);
                i53 = -1;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        if (i2 != iIntValue) {
            int i61 = setTopP6481 + 41;
            component8 = i61 % 128;
            int i62 = i61 % 2;
            Object[] objArr11 = new Object[5];
            objArr11[0] = new int[]{iIntValue};
            objArr11[1] = new int[]{i2};
            objArr11[i] = new int[1];
            objArr11[2] = obj;
            objArr11[3] = obj;
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i63 = ~((-39994437) | (~iFreeMemory));
            int i64 = ((((873999154 | i63) | (~(39994436 | iFreeMemory))) * (-338)) - 24806534) + (((~(iFreeMemory | 913993590)) | i63) * 338);
            int i65 = -(-((i64 ^ 16) + ((i64 & 16) << 1)));
            int i66 = (iIntValue2 & i65) + (i65 | iIntValue2);
            int i67 = i66 << 13;
            int i68 = (i67 & (~i66)) | ((~i67) & i66);
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr11[i])[0] = i69 ^ (i69 << 5);
            return objArr11;
        }
        char edgeSlop = (char) (13049 - (ViewConfiguration.getEdgeSlop() >> 16));
        int i70 = 97 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0)));
        int i71 = -TextUtils.getTrimmedLength("");
        int iComponent9 = br.AnonymousClass2.component9();
        int i72 = (i71 * (-419)) + 5052 + ((~((iComponent9 ^ 12) | (iComponent9 & 12))) * 420);
        int i73 = ~i71;
        int i74 = i72 + ((i73 | 12) * (-420));
        int i75 = ~(i73 | (-13));
        int i76 = ~iComponent9;
        int i77 = ~((i76 & 12) | (i76 ^ 12));
        int i78 = ((i75 & i77) | (i75 ^ i77)) * 420;
        int i79 = (i74 & i78) + (i78 | i74);
        Object[] objArr12 = new Object[1];
        a(edgeSlop, i70, i79, objArr12);
        String str8 = (String) objArr12[0];
        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0);
        int i80 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
        int i81 = ((i80 | 111) << 1) - (i80 ^ 111);
        int i82 = -(-TextUtils.lastIndexOf("", '0', 0, 0));
        int i83 = (i82 ^ 14) + ((i82 & 14) << 1);
        Object[] objArr13 = new Object[1];
        a((char) (((iLastIndexOf | 1) << 1) - (iLastIndexOf ^ 1)), i81, i83, objArr13);
        String str9 = (String) objArr13[0];
        char c2 = (char) (14094 - (~(-View.combineMeasuredStates(0, 0))));
        int iResolveOpacity = Drawable.resolveOpacity(0, 0);
        int i84 = (iResolveOpacity & 123) + (iResolveOpacity | 123);
        int i85 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
        int i86 = (i85 ^ 18) + ((i85 & 18) << 1);
        Object[] objArr14 = new Object[1];
        a(c2, i84, i86, objArr14);
        String[] strArr5 = {str8, str9, (String) objArr14[0]};
        int i87 = 0;
        while (true) {
            if (i87 >= i42) {
                i3 = i42;
                str = str4;
                i4 = iIntValue;
                break;
            }
            Object[] objArr15 = {strArr5[i87]};
            Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(1152753004);
            if (objComponent14 == null) {
                int maximumFlingVelocity = 52 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char minimumFlingVelocity = (char) (59725 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 6317;
                Object[] objArr16 = new Object[1];
                b(1, -1, (byte) 1, objArr16);
                objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumFlingVelocity, minimumFlingVelocity, iCombineMeasuredStates, 369154319, false, (String) objArr16[0], new Class[]{String.class});
            }
            long jLongValue2 = ((Long) ((Method) objComponent14).invoke(obj, objArr15)).longValue();
            long j4 = jLongValue2 ^ (-1);
            long j5 = (int) Runtime.getRuntime().totalMemory();
            long j6 = j5 ^ (-1);
            long j7 = ((((286344777370L + ((-958) * jLongValue2)) + (((((j4 | j6) ^ (-1)) | ((298898514 | j5) ^ (-1))) | ((j6 | (-298898515)) ^ (-1))) * 959)) + ((-959) * (((-298898515) | jLongValue2) ^ (-1)))) + (959 * ((((298898514 | j6) ^ (-1)) | ((j4 | j5) ^ (-1))) | (((-298898515) | j5) ^ (-1))))) - 675603370;
            str = str4;
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i88 = ~iUptimeMillis;
            i3 = i42;
            int i89 = ((int) (j7 >> 32)) & (573590416 + ((~(1121332619 | i88)) * 979) + (((-1736408266) | iUptimeMillis) * (-979)) + (((~(1121332619 | iUptimeMillis)) | (~(i88 | (-1736408266)))) * 979));
            int iMyPid = Process.myPid();
            int i90 = ~iMyPid;
            int i91 = ~(927431000 | i90);
            int i92 = ((int) j7) & ((-352031427) + ((1074266277 | i91) * (-712)) + (((~(iMyPid | 2001697277)) | (~(i90 | (-1074266278)))) * (-712)) + (((-1930309886) | i91) * 712));
            if (((i89 & i92) | (i89 ^ i92)) != 0) {
                int i93 = setTopP6481;
                int i94 = (i93 ^ 81) + ((i93 & 81) << 1);
                component8 = i94 % 128;
                if (i94 % 2 == 0) {
                    i4 = ((i87 ^ RotationOptions.ROTATE_270) + ((i87 & RotationOptions.ROTATE_270) << 1)) ^ iIntValue;
                    break;
                }
                i4 = iIntValue ^ (i87 - 719);
                break;
            }
            i87++;
            str4 = str;
            i42 = i3;
            obj = null;
        }
        if (i4 != iIntValue) {
            Object[] objArr17 = new Object[5];
            objArr17[0] = new int[]{iIntValue};
            objArr17[1] = new int[]{i4};
            objArr17[i] = new int[1];
            objArr17[2] = null;
            objArr17[i3] = null;
            int iNextInt3 = new Random().nextInt(729962769);
            int i95 = ((~((~iNextInt3) | (-675496513))) * 130) + 1113320174 + (((~(iNextInt3 | (-675496513))) | 16789764) * 130);
            int i96 = iIntValue2 + (((i95 | 16) << 1) - (i95 ^ 16));
            int i97 = (i96 << 13) ^ i96;
            int i98 = i97 >>> 17;
            int i99 = ((~i97) & i98) | ((~i98) & i97);
            int i100 = i99 << 5;
            ((int[]) objArr17[i])[0] = (i99 | i100) & (~(i99 & i100));
            return objArr17;
        }
        Object[] objArr18 = new Object[1];
        a((char) ((-2) - ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) ^ (-1))), 140 - (~(-(-TextUtils.indexOf("", "")))), 13 - (~(-(-KeyEvent.normalizeMetaState(0)))), objArr18);
        Object[] objArr19 = {(String) objArr18[0]};
        Object objComponent15 = setSystemGestureExclusionRectsL30479.component5(1364103917);
        if (objComponent15 == null) {
            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52;
            char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 59725);
            int i101 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 6316;
            Object[] objArr20 = new Object[1];
            b(1, -1, (byte) 2, objArr20);
            objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumDrawingCacheSize, scrollDefaultDelay, i101, 66836110, false, (String) objArr20[0], new Class[]{String.class});
        }
        long jLongValue3 = ((Long) ((Method) objComponent15).invoke(null, objArr19)).longValue();
        long j8 = jLongValue3 ^ (-1);
        long jNextInt = new Random().nextInt();
        long j9 = ((-228530704) | jNextInt) ^ (-1);
        long j10 = (228530703 | jLongValue3) ^ (-1);
        long j11 = 185795462352L + (408 * jLongValue3) + ((-814) * (((j8 | (-228530704)) ^ (-1)) | j9)) + ((((j8 | (jNextInt ^ (-1))) ^ (-1)) | j10 | j9) * 407) + (407 * (((jLongValue3 | jNextInt) ^ (-1)) | j10 | ((228530703 | jNextInt) ^ (-1)))) + 384481070;
        int iNextInt4 = new Random().nextInt();
        int i102 = ~(2010447444 | iNextInt4);
        int i103 = ~iNextInt4;
        int i104 = ((int) (j11 >> 32)) & (2038856378 + (((~(i103 | (-22298689))) | i102) * 920) + (((-2010447445) | (~(869592128 | i103))) * 920) + (((~(2010447444 | i103)) | (~((-1140855317) | iNextInt4)) | (~(iNextInt4 | (-22298689)))) * 920));
        int i105 = (int) j11;
        int iMyTid = Process.myTid();
        int i106 = i105 & ((-1704616964) + (((~(1645153139 | iMyTid)) | (-1783603188)) * 305) + (((~((~iMyTid) | 1645153139)) | (-1212587747)) * 305));
        if (((i104 & i106) | (i104 ^ i106)) != 0) {
            i5 = iIntValue ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED;
        } else {
            int i107 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int deadChar = KeyEvent.getDeadChar(0, 0) + WebmConstants.MkvEbmlElement.BLOCK_DURATION;
            int i108 = -MotionEvent.axisFromString("");
            int i109 = ((i108 | 23) << 1) - (i108 ^ 23);
            Object[] objArr21 = new Object[1];
            a((char) ((i107 & 27772) + (i107 | 27772)), deadChar, i109, objArr21);
            Object[] objArr22 = {(String) objArr21[0]};
            Object objComponent16 = setSystemGestureExclusionRectsL30479.component5(1828795215);
            if (objComponent16 == null) {
                int absoluteGravity = 52 - Gravity.getAbsoluteGravity(0, 0);
                char cRed = (char) Color.red(0);
                int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6473;
                Object[] objArr23 = new Object[1];
                b(1, -1, (byte) 0, objArr23);
                objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(absoluteGravity, cRed, maximumDrawingCacheSize2, 1068791596, false, (String) objArr23[0], new Class[]{String.class});
            }
            String str10 = (String) ((Method) objComponent16).invoke(null, objArr22);
            if (str10 == null || str10.length() == 0) {
                char cBlue = (char) Color.blue(0);
                int i110 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                int i111 = ((i110 | WebmConstants.MkvEbmlElement.CUE_TIME) << 1) - (i110 ^ WebmConstants.MkvEbmlElement.CUE_TIME);
                int i112 = -TextUtils.indexOf((CharSequence) "", '0');
                int i113 = (i112 ^ 23) + ((i112 & 23) << 1);
                Object[] objArr24 = new Object[1];
                a(cBlue, i111, i113, objArr24);
                Object[] objArr25 = {(String) objArr24[0]};
                Object objComponent17 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                if (objComponent17 == null) {
                    int offsetAfter = 52 - TextUtils.getOffsetAfter("", 0);
                    char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int i114 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6473;
                    Object[] objArr26 = new Object[1];
                    b(1, -1, (byte) 0, objArr26);
                    objComponent17 = setSystemGestureExclusionRectsL30479.vD14832N6715(offsetAfter, tapTimeout, i114, 1068791596, false, (String) objArr26[0], new Class[]{String.class});
                }
                String str11 = (String) ((Method) objComponent17).invoke(null, objArr25);
                i5 = (str11 == null || str11.length() == 0) ? iIntValue : (iIntValue & (-268)) | ((~iIntValue) & 267);
            } else {
                i5 = (~(iIntValue & 267)) & (iIntValue | 267);
            }
        }
        if (i5 != iIntValue) {
            Object[] objArr27 = new Object[5];
            objArr27[0] = new int[]{iIntValue};
            objArr27[1] = new int[]{i5};
            objArr27[i] = new int[1];
            objArr27[2] = null;
            objArr27[i3] = null;
            int iNextInt5 = new Random().nextInt();
            int i115 = ((((~((-472621037) | iNextInt5)) | 106646630) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 2107304578) + (((~((~iNextInt5) | (-472621037))) | 106646630) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + 16;
            int i116 = (iIntValue2 & i115) + (iIntValue2 | i115);
            int i117 = i116 << 13;
            int i118 = (i116 | i117) & (~(i116 & i117));
            int i119 = i118 >>> 17;
            int i120 = ((~i118) & i119) | ((~i119) & i118);
            int i121 = i120 << 5;
            ((int[]) objArr27[i])[0] = ((~i120) & i121) | ((~i121) & i120);
            return objArr27;
        }
        Object objComponent18 = setSystemGestureExclusionRectsL30479.component5(-1565281236);
        if (objComponent18 == null) {
            int touchSlop = 52 - (ViewConfiguration.getTouchSlop() >> 8);
            char scrollBarSize = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 52019);
            int iMyPid2 = (Process.myPid() >> 22) + 6783;
            Object[] objArr28 = new Object[1];
            b(0, -1, (byte) 2, objArr28);
            objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(touchSlop, scrollBarSize, iMyPid2, -267980721, false, (String) objArr28[0], new Class[0]);
        }
        long jLongValue4 = ((Long) ((Method) objComponent18).invoke(null, null)).longValue();
        long j12 = jLongValue4 ^ (-1);
        long jFreeMemory = (int) Runtime.getRuntime().freeMemory();
        long j13 = jFreeMemory ^ (-1);
        long j14 = (j13 | jLongValue4) ^ (-1);
        long j15 = (((((-275394822935L) + (517 * jLongValue4)) + ((-516) * ((((j12 | jFreeMemory) ^ (-1)) | ((j13 | 534747229) ^ (-1))) | j14))) + ((((((-534747230) | j12) | jFreeMemory) ^ (-1)) | ((((-534747230) | j13) | jLongValue4) ^ (-1))) * 516)) + (516 * ((((-534747230) | jLongValue4) ^ (-1)) | j14))) - 943293408;
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        int i122 = ((int) (j15 >> 32)) & ((-1320242614) + (((~((-380371928) | elapsedCpuTime)) | 380371411) * 1504) + ((~(elapsedCpuTime | (-517))) * (-1504)) + 1909517248);
        int iMyTid2 = Process.myTid();
        int i123 = ((int) j15) & (((((~((-1419084687) | iMyTid2)) | 1409288) * (-566)) - 639569403) + ((~(iMyTid2 | (-1417675399))) * 566));
        int i124 = (i122 & i123) | (i122 ^ i123);
        if (i124 != 0) {
            int i125 = -(-(i124 - 1));
            int i126 = (i125 & 200) + (i125 | 200);
            i6 = (~(iIntValue & i126)) & (i126 | iIntValue);
        } else {
            i6 = iIntValue;
        }
        if (i6 != iIntValue) {
            Object[] objArr29 = new Object[5];
            objArr29[0] = new int[]{iIntValue};
            objArr29[1] = new int[]{i6};
            objArr29[i] = new int[1];
            objArr29[2] = null;
            objArr29[i3] = null;
            int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
            int i127 = ((2027772904 + (((-67242823) | elapsedCpuTime2) * (-381))) + (((~((~elapsedCpuTime2) | (-109710296))) | 1001157785) * 381)) - 150288578;
            int i128 = (iIntValue2 & i127) + (iIntValue2 | i127);
            int i129 = i128 << 13;
            int i130 = (i128 | i129) & (~(i128 & i129));
            int i131 = i130 >>> 17;
            int i132 = (i130 | i131) & (~(i130 & i131));
            int i133 = i132 << 5;
            ((int[]) objArr29[i])[0] = ((~i132) & i133) | ((~i133) & i132);
            return objArr29;
        }
        int i134 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
        Object[] objArr30 = new Object[1];
        a((char) ((i134 ^ 1) + ((i134 & 1) << 1)), 202 - (~View.resolveSize(0, 0)), 19 - (~(-(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))), objArr30);
        String str12 = (String) objArr30[0];
        char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
        int i135 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        Object[] objArr31 = new Object[1];
        a(offsetBefore, ((i135 | 223) << 1) - (i135 ^ 223), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 6, objArr31);
        String str13 = (String) objArr31[0];
        File file = new File(str12);
        if (file.exists()) {
            int i136 = setTopP6481 + 73;
            component8 = i136 % 128;
            int i137 = i136 % 2;
            if (file.isFile()) {
                try {
                    Scanner scanner = new Scanner(new FileInputStream(file));
                    char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 229;
                    int i138 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i139 = (i138 ^ 2) + ((i138 & 2) << 1);
                    Object[] objArr32 = new Object[1];
                    a(maxKeyCode, keyRepeatDelay, i139, objArr32);
                    Scanner scannerUseDelimiter = scanner.useDelimiter((String) objArr32[0]);
                    if (scannerUseDelimiter.hasNext()) {
                        int i140 = setTopP6481 + 123;
                        component8 = i140 % 128;
                        if (i140 % 2 != 0) {
                            scannerUseDelimiter.next();
                            Object obj3 = null;
                            obj3.hashCode();
                            throw null;
                        }
                        next = scannerUseDelimiter.next();
                    } else {
                        next = "";
                    }
                    scannerUseDelimiter.close();
                    if (next.contains(str13)) {
                        int i141 = setTopP6481 + 89;
                        component8 = i141 % 128;
                        int i142 = i141 % 2;
                        i7 = (iIntValue & (-263)) | ((~iIntValue) & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                    } else {
                        i7 = iIntValue;
                    }
                } catch (IOException unused) {
                }
            } else {
                i7 = iIntValue;
            }
        } else {
            i7 = iIntValue;
        }
        if (i7 != iIntValue) {
            int i143 = setTopP6481 + 11;
            component8 = i143 % 128;
            int i144 = i143 % 2;
            Object[] objArr33 = new Object[5];
            objArr33[0] = new int[]{iIntValue};
            objArr33[1] = new int[]{i7};
            objArr33[i] = new int[1];
            objArr33[2] = null;
            objArr33[i3] = null;
            int i145 = ~((int) Process.getElapsedCpuTime());
            int i146 = 157909462 + (((~(i145 | 146196466)) | (-771223543)) * (-160)) + (((~(i145 | (-770026373))) | 146196466) * WebmConstants.MkvEbmlElement.BLOCK_GROUP);
            int i147 = -(-((i146 & 16) + (i146 | 16)));
            int i148 = (iIntValue2 & i147) + (i147 | iIntValue2);
            int i149 = i148 << 13;
            int i150 = (i149 | i148) & (~(i148 & i149));
            int i151 = i150 ^ (i150 >>> 17);
            int i152 = i151 << 5;
            ((int[]) objArr33[i])[0] = ((~i151) & i152) | ((~i152) & i151);
            return objArr33;
        }
        int i153 = -Color.red(0);
        int i154 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 230;
        int i155 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
        int i156 = (i155 & 31) + (i155 | 31);
        Object[] objArr34 = new Object[1];
        a((char) (((i153 | 37644) << 1) - (i153 ^ 37644)), i154, i156, objArr34);
        String str14 = (String) objArr34[0];
        char cRed2 = (char) Color.red(0);
        int i157 = -TextUtils.getCapsMode("", 0, 0);
        int i158 = (i157 ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + ((i157 & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) << 1);
        int i159 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
        int i160 = (i159 ^ 23) + ((i159 & 23) << 1);
        Object[] objArr35 = new Object[1];
        a(cRed2, i158, i160, objArr35);
        String str15 = (String) objArr35[0];
        char touchSlop2 = (char) (ViewConfiguration.getTouchSlop() >> 8);
        int i161 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
        int i162 = (i161 ^ 285) + ((i161 & 285) << 1);
        int i163 = -(-AndroidCharacter.getMirror('0'));
        int i164 = ((i163 | (-20)) << 1) - (i163 ^ (-20));
        Object[] objArr36 = new Object[1];
        a(touchSlop2, i162, i164, objArr36);
        String str16 = (String) objArr36[0];
        char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
        int iArgb = Color.argb(0, 0, 0, 0) + 313;
        int i165 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
        int i166 = (i165 & 14) + (i165 | 14);
        Object[] objArr37 = new Object[1];
        a(cKeyCodeFromString, iArgb, i166, objArr37);
        String[] strArr6 = {str14, str15, str16, (String) objArr37[0]};
        int i167 = 0;
        int i168 = i;
        while (true) {
            if (i167 >= i168) {
                i8 = iIntValue;
                break;
            }
            Object[] objArr38 = {strArr6[i167]};
            Object objComponent19 = setSystemGestureExclusionRectsL30479.component5(1364103917);
            if (objComponent19 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 53;
                char cIndexOf = (char) (TextUtils.indexOf("", "", 0, 0) + 59725);
                int i169 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 6316;
                Object[] objArr39 = new Object[1];
                b(1, -1, (byte) 2, objArr39);
                objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf2, cIndexOf, i169, 66836110, false, (String) objArr39[0], new Class[]{String.class});
            }
            long jLongValue5 = ((Long) ((Method) objComponent19).invoke(null, objArr38)).longValue();
            long elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
            long j16 = elapsedCpuTime3 ^ (-1);
            long j17 = jLongValue5 ^ (-1);
            long j18 = 1896079287 | j17;
            long j19 = (-1645796821984L) + (868 * jLongValue5) + ((-867) * (((1896079287 | j16) ^ (-1)) | ((j17 | j16) ^ (-1)))) + ((-1734) * ((j18 ^ (-1)) | ((1896079287 | elapsedCpuTime3) ^ (-1)) | ((j17 | elapsedCpuTime3) ^ (-1)))) + (867 * (((j18 | j16) ^ (-1)) | (((1896079287 | jLongValue5) | elapsedCpuTime3) ^ (-1)) | (((j17 | (-1896079288)) | elapsedCpuTime3) ^ (-1)))) + 2052029654;
            int iNextInt6 = new Random().nextInt();
            int i170 = ~iNextInt6;
            int i171 = ((int) (j19 >> 32)) & ((-802173004) + ((1302199645 | i170) * (-369)) + ((1275975757 | (~((-161250654) | i170))) * (-369)) + (((~(iNextInt6 | 161250653)) | 1140948992 | (~((-26223889) | i170))) * 369));
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i172 = ((int) j19) & ((((-396794082) + (((~(1023360383 | iMaxMemory)) | (~((-413866027) | iMaxMemory))) * 69)) + (((~(iMaxMemory | (-414923056))) | ((~(1022303354 | iMaxMemory)) | 1057029)) * (-69))) - 967497328);
            if (((i172 & i171) | (i171 ^ i172)) != 0) {
                int i173 = i167 + 252;
                i8 = ((~i173) & iIntValue) | (i173 & (~iIntValue));
                break;
            }
            i167 = ((i167 | 1) << 1) - (i167 ^ 1);
            i168 = 4;
        }
        if (i8 != iIntValue) {
            int i174 = setTopP6481 + 43;
            component8 = i174 % 128;
            int i175 = i174 % 2;
            Object[] objArr40 = new Object[5];
            objArr40[0] = new int[]{iIntValue};
            objArr40[1] = new int[]{i8};
            objArr40[4] = new int[1];
            objArr40[2] = null;
            objArr40[i3] = null;
            int iMyPid3 = Process.myPid();
            int i176 = (-206868142) + ((iMyPid3 | 661628874) * (-50));
            int i177 = ~((-120357769) | iMyPid3);
            int i178 = ~iMyPid3;
            int i179 = i176 + ((i177 | (~((-134236197) | i178))) * 50) + (((~(i178 | 661628874)) | (~((-254593965) | i178)) | 134236196) * 50);
            int i180 = -(-((i179 & 16) + (i179 | 16)));
            int i181 = (iIntValue2 & i180) + (i180 | iIntValue2);
            int i182 = i181 << 13;
            int i183 = (i182 | i181) & (~(i181 & i182));
            int i184 = i183 >>> 17;
            int i185 = (i183 | i184) & (~(i183 & i184));
            int i186 = i185 << 5;
            ((int[]) objArr40[4])[0] = ((~i185) & i186) | ((~i186) & i185);
            return objArr40;
        }
        char cAlpha = (char) (13691 - Color.alpha(0));
        int i187 = -(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
        int i188 = (i187 ^ 327) + ((i187 & 327) << 1);
        int i189 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
        int i190 = ((i189 | 14) << 1) - (i189 ^ 14);
        Object[] objArr41 = new Object[1];
        a(cAlpha, i188, i190, objArr41);
        Object[] objArr42 = {(String) objArr41[0]};
        Object objComponent20 = setSystemGestureExclusionRectsL30479.component5(1828795215);
        if (objComponent20 == null) {
            int iLastIndexOf2 = 51 - TextUtils.lastIndexOf("", '0', 0, 0);
            char c3 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
            int i191 = 6474 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            Object[] objArr43 = new Object[1];
            b(1, -1, (byte) 0, objArr43);
            objComponent20 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf2, c3, i191, 1068791596, false, (String) objArr43[0], new Class[]{String.class});
        }
        String str17 = (String) ((Method) objComponent20).invoke(null, objArr42);
        if (str17 != null) {
            char longPressTimeout = (char) (53003 - (ViewConfiguration.getLongPressTimeout() >> 16));
            int i192 = -Color.green(0);
            Object[] objArr44 = new Object[1];
            a(longPressTimeout, (i192 & 340) + (i192 | 340), 9 - Gravity.getAbsoluteGravity(0, 0), objArr44);
            if (str17.contains((String) objArr44[0])) {
                i9 = (iIntValue & (-251)) | ((~iIntValue) & 250);
            } else {
                i9 = iIntValue;
            }
        } else {
            i9 = iIntValue;
        }
        if (i9 != iIntValue) {
            Object[] objArr45 = new Object[5];
            objArr45[0] = new int[]{iIntValue};
            objArr45[1] = new int[]{i9};
            objArr45[4] = new int[1];
            objArr45[2] = null;
            objArr45[i3] = null;
            int i193 = (int) Runtime.getRuntime().totalMemory();
            int i194 = 1452845558 + (((~((-497333082) | i193)) | 413433881) * 576) + (((~((~i193) | (-83899201))) | 5455876) * 576) + 1914714176;
            int i195 = (i194 & 16) + (i194 | 16);
            int i196 = ((i195 * (-559)) - (~(-(-(iIntValue2 * 561))))) - 1;
            int i197 = ~iIntValue;
            int i198 = -(-((~((i197 & i195) | (i197 ^ i195))) * (-560)));
            int i199 = (i196 ^ i198) + ((i196 & i198) << 1);
            int i200 = ~iIntValue2;
            int i201 = (i200 & i195) | (i200 ^ i195);
            int i202 = -(-((~((i201 & iIntValue) | (i201 ^ iIntValue))) * (-560)));
            int i203 = (i199 ^ i202) + ((i202 & i199) << 1);
            int i204 = ~i195;
            int i205 = ~((i204 & iIntValue2) | (i204 ^ iIntValue2));
            int i206 = ~iIntValue;
            int i207 = ~((i206 & iIntValue2) | (i206 ^ iIntValue2));
            int i208 = ((i205 & i207) | (i205 ^ i207)) * 560;
            int i209 = (i203 ^ i208) + ((i208 & i203) << 1);
            int i210 = i209 << 13;
            int i211 = (i210 | i209) & (~(i209 & i210));
            int i212 = i211 >>> 17;
            int i213 = ((~i211) & i212) | ((~i212) & i211);
            int i214 = i213 << 5;
            ((int[]) objArr45[4])[0] = ((~i213) & i214) | ((~i214) & i213);
            return objArr45;
        }
        int i215 = -ImageFormat.getBitsPerPixel(0);
        int i216 = -(-Color.green(0));
        int i217 = (i216 & 349) + (i216 | 349);
        int i218 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
        int i219 = ((i218 | 17) << 1) - (i218 ^ 17);
        Object[] objArr46 = new Object[1];
        a((char) (((i215 | 65053) << 1) - (i215 ^ 65053)), i217, i219, objArr46);
        String str18 = (String) objArr46[0];
        char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
        int i220 = 364 - (~(-((byte) KeyEvent.getModifierMetaStateMask())));
        int touchSlop3 = ViewConfiguration.getTouchSlop() >> 8;
        int i221 = (touchSlop3 ^ 6) + ((touchSlop3 & 6) << 1);
        Object[] objArr47 = new Object[1];
        a(cLastIndexOf, i220, i221, objArr47);
        Object[] objArr48 = {str18, (String) objArr47[0]};
        Object objComponent21 = setSystemGestureExclusionRectsL30479.component5(1297851439);
        if (objComponent21 == null) {
            int iIndexOf3 = 51 - TextUtils.indexOf((CharSequence) "", '0');
            char c4 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 41179);
            int iMyPid4 = 3527 - (Process.myPid() >> 22);
            Object[] objArr49 = new Object[1];
            b(0, -1, (byte) 2, objArr49);
            objComponent21 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf3, c4, iMyPid4, 535748684, false, (String) objArr49[0], new Class[]{String.class, String.class});
        }
        long jLongValue6 = ((Long) ((Method) objComponent21).invoke(null, objArr48)).longValue();
        long jNextInt2 = new Random().nextInt(959123296);
        long j20 = 191590549344L + (434 * jLongValue6) + ((((443496641 | (jNextInt2 ^ (-1))) | jLongValue6) ^ (-1)) * 433) + ((-433) * (443496641 | (((jLongValue6 ^ (-1)) | jNextInt2) ^ (-1)))) + (433 * ((((-443496642) | jLongValue6) ^ (-1)) | ((443496641 | jNextInt2) ^ (-1)))) + 809301572;
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        int i222 = ~iElapsedRealtime;
        int i223 = ((int) (j20 >> 32)) & (576146292 + ((~((-521633647) | i222)) * 979) + ((915592764 | iElapsedRealtime) * (-979)) + (((~((-521633647) | iElapsedRealtime)) | (~(i222 | 915592764))) * 979));
        int i224 = (int) j20;
        int elapsedCpuTime4 = (int) Process.getElapsedCpuTime();
        int i225 = ~elapsedCpuTime4;
        if ((i223 | (i224 & (265882305 + (((~(1829604825 | i225)) | 1028136060) * (-328)) + ((1028136060 | elapsedCpuTime4) * 164) + (((~(elapsedCpuTime4 | (-1829604826))) | 755502168 | (~(i225 | 2102238717))) * 164)))) != 0) {
            int i226 = setTopP6481 + 93;
            component8 = i226 % 128;
            i10 = i226 % 2 != 0 ? iIntValue ^ 22303 : (iIntValue & (-252)) | ((~iIntValue) & WebmConstants.MkvEbmlElement.REFERENCE_BLOCK);
        } else {
            i10 = iIntValue;
        }
        if (i10 != iIntValue) {
            Object[] objArr50 = new Object[5];
            objArr50[0] = new int[]{iIntValue};
            objArr50[1] = new int[]{i10};
            objArr50[4] = new int[1];
            objArr50[2] = null;
            objArr50[i3] = null;
            int i227 = (int) Runtime.getRuntime().totalMemory();
            int i228 = ~i227;
            int i229 = 712473624 + (((~((-41454845) | i228)) | (~((-874767995) | i228))) * (-867)) + (((~((-41454845) | i227)) | 2131064 | (~((-874767995) | i227))) * (-1734)) + (((~(i227 | (-872636931))) | (~(i228 | (-2131065))) | (~((-39323781) | i227))) * 867) + 16;
            int i230 = (iIntValue2 ^ i229) + ((iIntValue2 & i229) << 1);
            int i231 = i230 << 13;
            int i232 = (i230 | i231) & (~(i230 & i231));
            int i233 = i232 ^ (i232 >>> 17);
            int i234 = i233 << 5;
            ((int[]) objArr50[4])[0] = ((~i233) & i234) | ((~i234) & i233);
            return objArr50;
        }
        int i235 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
        int i236 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
        Object[] objArr51 = new Object[1];
        a((char) (((i235 | 20747) << 1) - (i235 ^ 20747)), ((i236 | 372) << 1) - (i236 ^ 372), 21 - (~(-(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))), objArr51);
        Object[] objArr52 = {(String) objArr51[0]};
        Object objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
        if (objComponent22 == null) {
            int fadingEdgeLength = 52 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            char offsetBefore2 = (char) TextUtils.getOffsetBefore("", 0);
            int absoluteGravity2 = 6473 - Gravity.getAbsoluteGravity(0, 0);
            Object[] objArr53 = new Object[1];
            b(1, -1, (byte) 0, objArr53);
            objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(fadingEdgeLength, offsetBefore2, absoluteGravity2, 1068791596, false, (String) objArr53[0], new Class[]{String.class});
        }
        String lowerCase = ((String) ((Method) objComponent22).invoke(null, objArr52)).toLowerCase();
        Object[] objArr54 = new Object[1];
        a((char) KeyEvent.getDeadChar(0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 394, KeyEvent.keyCodeFromString("") + 4, objArr54);
        int i237 = lowerCase.contains((String) objArr54[0]) ? (~(iIntValue & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED)) & (iIntValue | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED) : iIntValue;
        if (i237 != iIntValue) {
            Object[] objArr55 = new Object[5];
            objArr55[0] = new int[]{iIntValue};
            objArr55[1] = new int[]{i237};
            objArr55[4] = new int[1];
            objArr55[2] = null;
            objArr55[i3] = null;
            int iNextInt7 = new Random().nextInt(509244970);
            int i238 = ~((-119567368) | iNextInt7);
            int i239 = ~iNextInt7;
            int i240 = (-195198106) + ((i238 | (~((-135266601) | i239))) * 920) + (((~((-661388872) | i239)) | 119567367) * 920) + (((~(iNextInt7 | (-135266601))) | (~((-119567368) | i239)) | (~((-541821505) | iNextInt7))) * 920);
            int i241 = iIntValue2 + (((i240 | 16) << 1) - (i240 ^ 16));
            int i242 = i241 << 13;
            int i243 = (i242 | i241) & (~(i241 & i242));
            int i244 = i243 >>> 17;
            int i245 = (i243 | i244) & (~(i243 & i244));
            int i246 = i245 << 5;
            ((int[]) objArr55[4])[0] = (i245 | i246) & (~(i245 & i246));
            return objArr55;
        }
        char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
        int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
        Object[] objArr56 = new Object[1];
        a(cNormalizeMetaState, ((longPressTimeout2 | 399) << 1) - (longPressTimeout2 ^ 399), 40 - (~(-TextUtils.indexOf((CharSequence) "", '0', 0, 0))), objArr56);
        String str19 = (String) objArr56[0];
        Object[] objArr57 = new Object[1];
        a((char) (1300 - (~MotionEvent.axisFromString(""))), (ViewConfiguration.getScrollBarSize() >> 8) + 441, 40 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr57);
        String str20 = (String) objArr57[0];
        int i247 = -TextUtils.getOffsetBefore("", 0);
        int i248 = -Process.getGidForName("");
        Object[] objArr58 = new Object[1];
        a((char) (((i247 | 59090) << 1) - (i247 ^ 59090)), (i248 & WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND) + (i248 | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND), 28 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr58);
        String str21 = (String) objArr58[0];
        char c5 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
        int i249 = 507 - (~View.combineMeasuredStates(0, 0));
        int i250 = -(ViewConfiguration.getScrollBarSize() >> 8);
        int i251 = (i250 ^ 27) + ((i250 & 27) << 1);
        Object[] objArr59 = new Object[1];
        a(c5, i249, i251, objArr59);
        String str22 = (String) objArr59[0];
        int i252 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
        int iAxisFromString = MotionEvent.axisFromString("") + 536;
        int i253 = -(-View.MeasureSpec.getMode(0));
        int i254 = (i253 & 27) + (i253 | 27);
        Object[] objArr60 = new Object[1];
        a((char) ((i252 & 33367) + (i252 | 33367)), iAxisFromString, i254, objArr60);
        String str23 = (String) objArr60[0];
        char c6 = (char) (47 - (~(-AndroidCharacter.getMirror('0'))));
        int i255 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
        Object[] objArr61 = new Object[1];
        a(c6, ((i255 | 561) << 1) - (i255 ^ 561), 26 - (~TextUtils.getOffsetAfter("", 0)), objArr61);
        String[] strArr7 = {str19, str20, str21, str22, str23, (String) objArr61[0]};
        int i256 = 0;
        int i257 = 6;
        while (true) {
            if (i256 >= i257) {
                i11 = iIntValue;
                break;
            }
            Object[] objArr62 = {strArr7[i256]};
            Object objComponent23 = setSystemGestureExclusionRectsL30479.component5(1828795215);
            if (objComponent23 == null) {
                int mirror2 = 'd' - AndroidCharacter.getMirror('0');
                char mode = (char) View.MeasureSpec.getMode(0);
                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0) + 6474;
                Object[] objArr63 = new Object[1];
                b(1, -1, (byte) 0, objArr63);
                objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(mirror2, mode, iIndexOf4, 1068791596, false, (String) objArr63[0], new Class[]{String.class});
            }
            String str24 = (String) ((Method) objComponent23).invoke(null, objArr62);
            if (str24 != null && str24.length() != 0) {
                int i258 = component8;
                int i259 = (i258 & 83) + (i258 | 83);
                setTopP6481 = i259 % 128;
                int i260 = i259 % 2;
                i11 = iIntValue ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_CONNECTED;
                int i261 = i258 + 25;
                setTopP6481 = i261 % 128;
                int i262 = i261 % 2;
                break;
            }
            i256++;
            i257 = 6;
        }
        if (i11 != iIntValue) {
            Object[] objArr64 = new Object[5];
            objArr64[0] = new int[]{iIntValue};
            objArr64[1] = new int[]{i11};
            objArr64[4] = new int[1];
            objArr64[2] = null;
            objArr64[i3] = null;
            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
            int i263 = ~iElapsedRealtime2;
            int i264 = -(-(1179614590 + ((iElapsedRealtime2 | 528264199) * (-859)) + (((~(iElapsedRealtime2 | (-387744776))) | (~(528264199 | i263))) * 859) + (((~((-387958640) | i263)) | 213864) * 859) + 16));
            int i265 = (iIntValue2 & i264) + (i264 | iIntValue2);
            int i266 = i265 << 13;
            int i267 = (i266 & (~i265)) | ((~i266) & i265);
            int i268 = i267 >>> 17;
            int i269 = (i267 | i268) & (~(i267 & i268));
            int i270 = i269 << 5;
            ((int[]) objArr64[4])[0] = (i269 | i270) & (~(i269 & i270));
            return objArr64;
        }
        char c7 = (char) (65053 - (~(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))));
        int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 349;
        int i271 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
        int i272 = (i271 ^ 16) + ((i271 & 16) << 1);
        Object[] objArr65 = new Object[1];
        a(c7, scrollBarSize2, i272, objArr65);
        String str25 = (String) objArr65[0];
        char cArgb = (char) Color.argb(0, 0, 0, 0);
        int i273 = -Color.red(0);
        int i274 = i273 * (-337);
        int i275 = (i274 & 199671) + (i274 | 199671);
        int i276 = ~i273;
        int i277 = ~iIntValue;
        int i278 = ~((i276 ^ i277) | (i276 & i277));
        int i279 = ~(((-590) ^ i273) | ((-590) & i273));
        int i280 = i275 + (((i278 ^ i279) | (i278 & i279) | (~((i273 ^ iIntValue) | (i273 & iIntValue)))) * (-338));
        int i281 = ~i273;
        int i282 = (~((i281 & 589) | (i281 ^ 589))) * 338;
        int i283 = ((i280 | i282) << 1) - (i282 ^ i280);
        int i284 = ~iIntValue;
        int i285 = ~((i276 & i284) | (i276 ^ i284));
        int i286 = i273 | 589;
        int i287 = ~((i286 & iIntValue) | (i286 ^ iIntValue));
        int i288 = -(-(((i287 & i285) | (i285 ^ i287)) * 338));
        int i289 = (i283 ^ i288) + ((i288 & i283) << 1);
        int i290 = -(ViewConfiguration.getTouchSlop() >> 8);
        int i291 = (i290 & 6) + (i290 | 6);
        Object[] objArr66 = new Object[1];
        a(cArgb, i289, i291, objArr66);
        String str26 = (String) objArr66[0];
        File file2 = new File(str25);
        if (file2.exists() && file2.isFile()) {
            try {
                Scanner scanner2 = new Scanner(new FileInputStream(file2));
                char c8 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i292 = 228 - (~(-Color.alpha(0)));
                int i293 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i294 = ~((~i293) | i284);
                i12 = 5;
                int i295 = ~i293;
                int i296 = (~((i295 ^ 2) | (i295 & 2))) | i294;
                int i297 = ((-3) ^ i293) | ((-3) & i293);
                int i298 = (i297 & iIntValue) | (i297 ^ iIntValue);
                int i299 = ((((i293 * 714) - 1424) + ((i296 | (~i298)) * (-713))) - (~(-(-((~i298) * 1426))))) - 1;
                int i300 = -(-((~(((-3) & i284) | ((-3) ^ i284))) * 713));
                int i301 = ((i299 | i300) << 1) - (i300 ^ i299);
                try {
                    Object[] objArr67 = new Object[1];
                    a(c8, i292, i301, objArr67);
                    Scanner scannerUseDelimiter2 = scanner2.useDelimiter((String) objArr67[0]);
                    String next2 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : "";
                    scannerUseDelimiter2.close();
                    if (next2.contains(str26)) {
                        i16 = iIntValue ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED;
                        i13 = i277;
                    } else {
                        Object[] objArr68 = new Object[1];
                        a((char) (ViewConfiguration.getFadingEdgeLength() >> 16), 596 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 13 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))), objArr68);
                        String str27 = (String) objArr68[0];
                        char scrollDefaultDelay2 = (char) (25724 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        int i302 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        int i303 = (i302 ^ TypedValues.Motion.TYPE_PATHMOTION_ARC) + ((i302 & TypedValues.Motion.TYPE_PATHMOTION_ARC) << 1);
                        int i304 = -ExpandableListView.getPackedPositionGroup(0L);
                        int i305 = (i304 ^ 9) + ((i304 & 9) << 1);
                        Object[] objArr69 = new Object[1];
                        a(scrollDefaultDelay2, i303, i305, objArr69);
                        Object[] objArr70 = {str27, (String) objArr69[0]};
                        objComponent5 = setSystemGestureExclusionRectsL30479.component5(1297851439);
                        if (objComponent5 == null) {
                            int jumpTapTimeout = 52 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char c9 = (char) (41181 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3527;
                            Object[] objArr71 = new Object[1];
                            b(0, -1, (byte) 2, objArr71);
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(jumpTapTimeout, c9, doubleTapTimeout, 535748684, false, (String) objArr71[0], new Class[]{String.class, String.class});
                        }
                        long jLongValue7 = ((Long) ((Method) objComponent5).invoke(null, objArr70)).longValue();
                        i13 = i277;
                        long jMyPid2 = Process.myPid();
                        long j21 = ((-1563172252) | jLongValue7) ^ (-1);
                        long j22 = 586189594500L + ((-375) * jLongValue7) + ((jMyPid2 | ((1563172251 | (jLongValue7 ^ (-1))) ^ (-1)) | j21) * 376) + ((-376) * ((((jMyPid2 ^ (-1)) | (-1563172252)) ^ (-1)) | j21)) + (376 * (jLongValue7 | ((1563172251 | jMyPid2) ^ (-1)))) + 1928977182;
                        int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                        int i306 = ~iUptimeMillis2;
                        i14 = ((int) (j22 >> 32)) & ((-2004723633) + (((~(810178609 | iUptimeMillis2)) | (~((-627047802) | i306))) * 333) + (((~(iUptimeMillis2 | (-627047802))) | (~(i306 | 810178609))) * 333));
                        int i307 = (int) j22;
                        int iNextInt8 = new Random().nextInt(603480648);
                        int i308 = ~iNextInt8;
                        int i309 = (~(1338776056 | i308)) | (-1339964410);
                        int i310 = ~(iNextInt8 | (-97262001));
                        i15 = i307 & (210505241 + ((i309 | i310) * (-502)) + ((i310 | (~(i308 | (-1188354)))) * 502));
                        if (((i14 & i15) | (i14 ^ i15)) != 0) {
                            int i311 = component8;
                            int i312 = (i311 & 5) + (i311 | 5);
                            setTopP6481 = i312 % 128;
                            int i313 = i312 % 2;
                            i16 = iIntValue ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED;
                        } else {
                            int i314 = component8 + 89;
                            setTopP6481 = i314 % 128;
                            int i315 = i314 % 2;
                            i16 = iIntValue;
                        }
                    }
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                i12 = 5;
            }
        } else {
            i12 = 5;
            Object[] objArr610 = new Object[1];
            a((char) (ViewConfiguration.getFadingEdgeLength() >> 16), 596 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 13 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))), objArr610);
            String str28 = (String) objArr610[0];
            char scrollDefaultDelay3 = (char) (25724 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
            int i3010 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            int i3011 = (i3010 ^ TypedValues.Motion.TYPE_PATHMOTION_ARC) + ((i3010 & TypedValues.Motion.TYPE_PATHMOTION_ARC) << 1);
            int i3012 = -ExpandableListView.getPackedPositionGroup(0L);
            int i3013 = (i3012 ^ 9) + ((i3012 & 9) << 1);
            Object[] objArr611 = new Object[1];
            a(scrollDefaultDelay3, i3011, i3013, objArr611);
            Object[] objArr72 = {str28, (String) objArr611[0]};
            objComponent5 = setSystemGestureExclusionRectsL30479.component5(1297851439);
            if (objComponent5 == null) {
                int jumpTapTimeout2 = 52 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char c10 = (char) (41181 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3527;
                Object[] objArr73 = new Object[1];
                b(0, -1, (byte) 2, objArr73);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(jumpTapTimeout2, c10, doubleTapTimeout2, 535748684, false, (String) objArr73[0], new Class[]{String.class, String.class});
            }
            long jLongValue8 = ((Long) ((Method) objComponent5).invoke(null, objArr72)).longValue();
            i13 = i277;
            long jMyPid3 = Process.myPid();
            long j23 = ((-1563172252) | jLongValue8) ^ (-1);
            long j24 = 586189594500L + ((-375) * jLongValue8) + ((jMyPid3 | ((1563172251 | (jLongValue8 ^ (-1))) ^ (-1)) | j23) * 376) + ((-376) * ((((jMyPid3 ^ (-1)) | (-1563172252)) ^ (-1)) | j23)) + (376 * (jLongValue8 | ((1563172251 | jMyPid3) ^ (-1)))) + 1928977182;
            int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
            int i3014 = ~iUptimeMillis3;
            i14 = ((int) (j24 >> 32)) & ((-2004723633) + (((~(810178609 | iUptimeMillis3)) | (~((-627047802) | i3014))) * 333) + (((~(iUptimeMillis3 | (-627047802))) | (~(i3014 | 810178609))) * 333));
            int i3015 = (int) j24;
            int iNextInt9 = new Random().nextInt(603480648);
            int i3016 = ~iNextInt9;
            int i3017 = (~(1338776056 | i3016)) | (-1339964410);
            int i316 = ~(iNextInt9 | (-97262001));
            i15 = i3015 & (210505241 + ((i3017 | i316) * (-502)) + ((i316 | (~(i3016 | (-1188354)))) * 502));
            if (((i14 & i15) | (i14 ^ i15)) != 0) {
                int i317 = component8;
                int i318 = (i317 & 5) + (i317 | 5);
                setTopP6481 = i318 % 128;
                int i319 = i318 % 2;
                i16 = iIntValue ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED;
            } else {
                int i3110 = component8 + 89;
                setTopP6481 = i3110 % 128;
                int i3111 = i3110 % 2;
                i16 = iIntValue;
            }
        }
        if (i16 != iIntValue) {
            Object[] objArr74 = new Object[i12];
            objArr74[0] = new int[]{iIntValue};
            objArr74[1] = new int[]{i16};
            objArr74[4] = new int[1];
            objArr74[2] = null;
            objArr74[i3] = null;
            int i320 = (int) Runtime.getRuntime().totalMemory();
            int i321 = (-1866793722) + ((~(i320 | 53987094)) * JfifUtil.MARKER_SOI);
            int i322 = ~i320;
            int i323 = (iIntValue2 - (~(((i321 + (((-809511009) | i322) * (-216))) + (((~(i322 | 53987094)) | 862235744) * JfifUtil.MARKER_SOI)) + 16))) - 1;
            int i324 = i323 << 13;
            int i325 = (i324 | i323) & (~(i323 & i324));
            int i326 = i325 ^ (i325 >>> 17);
            int i327 = i326 << 5;
            ((int[]) objArr74[4])[0] = (i326 | i327) & (~(i326 & i327));
            return objArr74;
        }
        Object objComponent24 = setSystemGestureExclusionRectsL30479.component5(-1933455274);
        if (objComponent24 == null) {
            int iIndexOf5 = 52 - TextUtils.indexOf("", "");
            char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
            int i328 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 7039;
            Object[] objArr75 = new Object[1];
            b(0, -1, (byte) 2, objArr75);
            objComponent24 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf5, cResolveOpacity, i328, -562785227, false, (String) objArr75[0], new Class[0]);
        }
        long jLongValue9 = ((Long) ((Method) objComponent24).invoke(null, null)).longValue();
        long j25 = jLongValue9 ^ (-1);
        long jMaxMemory = (int) Runtime.getRuntime().maxMemory();
        long j26 = jMaxMemory ^ (-1);
        long j27 = ((((62002546250L + ((-97) * jLongValue9)) + (98 * (((j25 | j26) ^ (-1)) | ((j25 | 1240050925) ^ (-1))))) + ((-49) * ((j25 | (((-1240050926) | j26) ^ (-1))) | ((1240050925 | jMaxMemory) ^ (-1))))) + (49 * (((1240050925 | jLongValue9) ^ (-1)) | ((j25 | jMaxMemory) ^ (-1))))) - 2135399664;
        int i329 = ~(new Random().nextInt(2012856692) | (-550976916));
        int i330 = ((int) (j27 >> 32)) & (((((-1993850816) | i329) * (-196)) - 2145919750) + ((i329 | 1442873900) * 196));
        int iMyTid3 = Process.myTid();
        int i331 = ~iMyTid3;
        int i332 = ((int) j27) & ((-1025618500) + (((~((-444531736) | i331)) | (~((-1610635713) | iMyTid3))) * (-831)) + ((~((-271122434) | iMyTid3)) * (-1662)) + (((~(iMyTid3 | 444531735)) | (~(i331 | 1881758145)) | (~((-1881758146) | iMyTid3))) * 831));
        if (((i330 & i332) | (i330 ^ i332)) == 1) {
            Object[] objArr76 = new Object[5];
            objArr76[0] = new int[]{iIntValue};
            objArr76[1] = new int[]{iIntValue};
            objArr76[4] = new int[1];
            objArr76[2] = null;
            objArr76[i3] = null;
            int i333 = ~Process.myUid();
            int i334 = iIntValue2 + (((~((-933436899) | i333)) | 916526464) * (-241)) + 153968162 + (((~(i333 | (-16910435))) | (-933740524)) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION);
            int i335 = i334 << 13;
            int i336 = (i335 & (~i334)) | ((~i335) & i334);
            int i337 = i336 ^ (i336 >>> 17);
            int i338 = i337 << 5;
            ((int[]) objArr76[4])[0] = (i337 | i338) & (~(i337 & i338));
            return objArr76;
        }
        Object[] objArr77 = {1};
        Object objComponent25 = setSystemGestureExclusionRectsL30479.component5(-902658636);
        if (objComponent25 == null) {
            int longPressTimeout3 = 50 - (ViewConfiguration.getLongPressTimeout() >> 16);
            char cAlpha2 = (char) (Color.alpha(0) + 34702);
            int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 5370;
            Object[] objArr78 = new Object[1];
            b(0, -1, (byte) 2, objArr78);
            objComponent25 = setSystemGestureExclusionRectsL30479.vD14832N6715(longPressTimeout3, cAlpha2, fadingEdgeLength2, -1735933481, false, (String) objArr78[0], new Class[]{Integer.TYPE});
        }
        long jLongValue10 = ((Long) ((Method) objComponent25).invoke(null, objArr77)).longValue();
        long j28 = 129109229420L + ((-864) * jLongValue10);
        long j29 = jLongValue10 ^ (-1);
        long elapsedCpuTime5 = (int) Process.getElapsedCpuTime();
        long j30 = elapsedCpuTime5 ^ (-1);
        long j31 = j28 + ((-865) * (j29 | (((-149086871) | j30) ^ (-1)))) + (((149086870 | elapsedCpuTime5) ^ (-1)) * 865) + (865 * (((j29 | j30) ^ (-1)) | ((j30 | 149086870) ^ (-1)))) + 1446496841;
        int iMyTid4 = Process.myTid();
        int i339 = ~iMyTid4;
        int i340 = ((int) (j31 >> 32)) & ((-1945278588) + (((~(1751732781 | i339)) | (-1106008104)) * (-602)) + (((~(iMyTid4 | 1751732781)) | (-1777162800) | (~((-1080578086) | i339))) * (-301)) + ((~(i339 | (-1106008104))) * 301));
        int iUptimeMillis4 = (int) SystemClock.uptimeMillis();
        int i341 = ~iUptimeMillis4;
        int i342 = ((int) j31) & ((-833924879) + (((-698353730) | iUptimeMillis4) * (-676)) + (((~(1079874066 | i341)) | 698353729) * 676) + (((~(iUptimeMillis4 | 1778227795)) | (~(i341 | (-1777866820))) | 1079513090) * 676));
        int i343 = ((i340 & i342) | (i340 ^ i342)) != 0 ? (~(iIntValue & 220)) & (iIntValue | 220) : iIntValue;
        if (i343 != iIntValue) {
            Object[] objArr79 = new Object[5];
            objArr79[0] = new int[]{iIntValue};
            objArr79[1] = new int[]{i343};
            objArr79[4] = new int[1];
            objArr79[2] = null;
            objArr79[i3] = null;
            int iMyTid5 = Process.myTid();
            int i344 = ~iMyTid5;
            int i345 = ((((~(i344 | 619478133)) | ((~((-296744706) | i344)) | 285442816)) * (-397)) - 11577454) + ((iMyTid5 | 893619060) * 397);
            int i346 = ((i345 | 16) << 1) - (i345 ^ 16);
            int i347 = ((iIntValue2 | i346) << 1) - (i346 ^ iIntValue2);
            int i348 = (i347 << 13) ^ i347;
            int i349 = i348 ^ (i348 >>> 17);
            int i350 = i349 << 5;
            ((int[]) objArr79[4])[0] = ((~i349) & i350) | ((~i350) & i349);
            return objArr79;
        }
        char cBlue2 = (char) (20747 - Color.blue(0));
        int i351 = -View.resolveSizeAndState(0, 0, 0);
        int i352 = (i351 ^ 372) + ((i351 & 372) << 1);
        int i353 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        int i354 = (i353 & 22) + (i353 | 22);
        Object[] objArr80 = new Object[1];
        a(cBlue2, i352, i354, objArr80);
        Object[] objArr81 = {(String) objArr80[0]};
        Object objComponent26 = setSystemGestureExclusionRectsL30479.component5(1828795215);
        if (objComponent26 == null) {
            int iGreen = 52 - Color.green(0);
            char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
            int i355 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 6473;
            Object[] objArr82 = new Object[1];
            b(1, -1, (byte) 0, objArr82);
            objComponent26 = setSystemGestureExclusionRectsL30479.vD14832N6715(iGreen, packedPositionGroup, i355, 1068791596, false, (String) objArr82[0], new Class[]{String.class});
        }
        Object objInvoke2 = ((Method) objComponent26).invoke(null, objArr81);
        if (objInvoke2 != null) {
            Object[] objArr83 = {objInvoke2, 42};
            Object objComponent27 = setSystemGestureExclusionRectsL30479.component5(585894966);
            if (objComponent27 == null) {
                int mode2 = View.MeasureSpec.getMode(0) + 52;
                char mode3 = (char) View.MeasureSpec.getMode(0);
                int gidForName = 5419 - Process.getGidForName("");
                Object[] objArr84 = new Object[1];
                b(0, -1, (byte) 2, objArr84);
                objComponent27 = setSystemGestureExclusionRectsL30479.vD14832N6715(mode2, mode3, gidForName, 1884899413, false, (String) objArr84[0], new Class[]{String.class, Integer.TYPE});
            }
            obj2 = null;
            long jLongValue11 = ((Long) ((Method) objComponent27).invoke(null, objArr83)).longValue();
            long j32 = jLongValue11 ^ (-1);
            long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
            long j33 = (-86217418500L) + ((-500) * jLongValue11) + ((((j32 | 172434837) ^ (-1)) | ((((-172434838) | jLongValue11) | jElapsedRealtime) ^ (-1))) * 501) + (1002 * (((-172434838) | j32) ^ (-1))) + (501 * ((jLongValue11 | ((-172434838) | (jElapsedRealtime ^ (-1)))) ^ (-1))) + 334718276;
            int iUptimeMillis5 = (int) SystemClock.uptimeMillis();
            int i356 = ~iUptimeMillis5;
            int i357 = (~((-803738609) | i356)) | 170398272 | (~(633487802 | i356));
            int i358 = ((int) (j33 >> 32)) & ((-1194013154) + (((~(iUptimeMillis5 | (-147467))) | i357) * 590) + (i357 * (-1180)) + (((~((-633487803) | i356)) | (~(i356 | 803738608))) * 590));
            int i359 = (int) j33;
            int i360 = ~((int) SystemClock.elapsedRealtime());
            if ((i358 | (i359 & ((-639040748) + (((~((-1226334136) | i360)) | (-1631406751)) * (-983)) + (((~(i360 | (-1631406751))) | 539295752) * 983)))) == 1986687685) {
                i19 = 0;
                i17 = i13;
                i18 = i284;
            }
            char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(i19);
            int i361 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            int i362 = ((i361 | 699) << 1) - (i361 ^ 699);
            int threadPriority = Process.getThreadPriority(i19);
            int i363 = -((((threadPriority | 20) << 1) - (threadPriority ^ 20)) >> 6);
            int i364 = ((i363 | 16) << 1) - (i363 ^ 16);
            Object[] objArr85 = new Object[1];
            a(cNormalizeMetaState2, i362, i364, objArr85);
            Object[] objArr86 = {(String) objArr85[0]};
            objComponent6 = setSystemGestureExclusionRectsL30479.component5(1828795215);
            if (objComponent6 == null) {
                int i365 = 53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cAlpha3 = (char) Color.alpha(0);
                int iBlue = Color.blue(0) + 6473;
                Object[] objArr87 = new Object[1];
                b(1, -1, (byte) 0, objArr87);
                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(i365, cAlpha3, iBlue, 1068791596, false, (String) objArr87[0], new Class[]{String.class});
            }
            objInvoke = ((Method) objComponent6).invoke(null, objArr86);
            if (objInvoke == null) {
                i20 = 0;
            } else {
                Object[] objArr88 = {objInvoke, 42};
                objComponent7 = setSystemGestureExclusionRectsL30479.component5(585894966);
                if (objComponent7 == null) {
                    int tapTimeout2 = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                    char offsetBefore3 = (char) TextUtils.getOffsetBefore("", 0);
                    int maximumDrawingCacheSize3 = 5420 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    Object[] objArr89 = new Object[1];
                    b(0, -1, (byte) 2, objArr89);
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout2, offsetBefore3, maximumDrawingCacheSize3, 1884899413, false, (String) objArr89[0], new Class[]{String.class, Integer.TYPE});
                }
                long jLongValue12 = ((Long) ((Method) objComponent7).invoke(null, objArr88)).longValue();
                long j34 = 171021946 | jLongValue12;
                long jElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                long j35 = (-129121569985L) + ((-753) * jLongValue12) + (((j34 ^ (-1)) | ((171021946 | jElapsedRealtime2) ^ (-1)) | ((jLongValue12 | jElapsedRealtime2) ^ (-1))) * (-754));
                long j36 = (j34 | jElapsedRealtime2) ^ (-1);
                long j37 = jElapsedRealtime2 ^ (-1);
                long j38 = j35 + ((-754) * (((jLongValue12 | ((-171021947) | j37)) ^ (-1)) | j36)) + (754 * (171021946 | j37)) + 678175060;
                int iNextInt10 = new Random().nextInt(1411030631);
                int i366 = ~iNextInt10;
                int i367 = 1905160562 + (((~(761006423 | i366)) | (-2113776128) | (~(2096734461 | i366)) | (~((-743964758) | iNextInt10))) * (-84));
                int i368 = (~(iNextInt10 | 2096734461)) | (-761006424);
                int i369 = ~(i366 | (-2096734462));
                int i370 = ((int) (j38 >> 32)) & (i367 + ((i368 | i369) * (-84)) + ((743964757 | i369) * 84));
                int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                int i371 = ((int) j38) & (((((~(880309427 | iElapsedRealtime3)) | 16875588) * (-283)) - 956402303) + ((~(iElapsedRealtime3 | 897185015)) * 283));
                i20 = (i370 & i371) | (i370 ^ i371);
            }
            if (i20 != 1986687685 && i20 != -1514516938) {
                int i372 = component8 + 35;
                setTopP6481 = i372 % 128;
                int i373 = i372 % 2;
                char cIndexOf2 = (char) (61203 - TextUtils.indexOf((CharSequence) "", '0'));
                int i374 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1413;
                int i375 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i376 = (i375 ^ 14) + ((i375 & 14) << 1);
                Object[] objArr90 = new Object[1];
                a(cIndexOf2, i374, i376, objArr90);
                String str29 = (String) objArr90[0];
                char jumpTapTimeout3 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int capsMode = 1427 - TextUtils.getCapsMode("", 0, 0);
                int i377 = -View.combineMeasuredStates(0, 0);
                int i378 = (i377 & 26) + (i377 | 26);
                Object[] objArr91 = new Object[1];
                a(jumpTapTimeout3, capsMode, i378, objArr91);
                String str30 = (String) objArr91[0];
                char c11 = (char) ((-16777217) - (~(-Color.rgb(0, 0, 0))));
                int i379 = -TextUtils.indexOf((CharSequence) "", '0');
                Object[] objArr92 = new Object[1];
                a(c11, ((i379 | 1452) << 1) - (i379 ^ 1452), 17 - TextUtils.indexOf("", "", 0), objArr92);
                String str31 = (String) objArr92[0];
                int i380 = -(ViewConfiguration.getEdgeSlop() >> 16);
                int i381 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                Object[] objArr93 = new Object[1];
                a((char) (((i380 | 33403) << 1) - (i380 ^ 33403)), ((i381 | 1470) << 1) - (i381 ^ 1470), 17 - ((Process.getThreadPriority(0) + 20) >> 6), objArr93);
                String str32 = (String) objArr93[0];
                int i382 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
                int i383 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                int i384 = (i383 ^ 1488) + ((i383 & 1488) << 1);
                int i385 = -(Process.myPid() >> 22);
                int i386 = ((i385 | 15) << 1) - (i385 ^ 15);
                Object[] objArr94 = new Object[1];
                a((char) ((i382 ^ 23386) + ((i382 & 23386) << 1)), i384, i386, objArr94);
                String str33 = (String) objArr94[0];
                int i387 = -Process.getGidForName("");
                int i388 = -(-Color.rgb(0, 0, 0));
                int i389 = ((i388 | 16778718) << 1) - (i388 ^ 16778718);
                int i390 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                int i391 = i390 * (-419);
                int i392 = (((i391 & 15156) + (i391 | 15156)) - (~((~((iIntValue ^ 36) | (iIntValue & 36))) * 420))) - 1;
                int i393 = ((~i390) | 36) * (-420);
                int i394 = (i392 & i393) + (i393 | i392);
                int i395 = ~((~i390) | (-37));
                int i396 = ~((i18 ^ 36) | (i18 & 36));
                int i397 = (i394 - (~(((i395 & i396) | (i395 ^ i396)) * 420))) - 1;
                Object[] objArr95 = new Object[1];
                a((char) ((i387 ^ 20880) + ((i387 & 20880) << 1)), i389, i397, objArr95);
                String str34 = (String) objArr95[0];
                char c12 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                int i398 = -KeyEvent.normalizeMetaState(0);
                int i399 = ((i398 | 1539) << 1) - (i398 ^ 1539);
                int i400 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i401 = ((i400 | 13) << 1) - (i400 ^ 13);
                Object[] objArr96 = new Object[1];
                a(c12, i399, i401, objArr96);
                String str35 = (String) objArr96[0];
                char cMyTid = (char) (14021 - (Process.myTid() >> 22));
                int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                int i402 = (minimumFlingVelocity2 & 1551) + (minimumFlingVelocity2 | 1551);
                int i403 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int i404 = (i403 & 12) + (i403 | 12);
                Object[] objArr97 = new Object[1];
                a(cMyTid, i402, i404, objArr97);
                String str36 = (String) objArr97[0];
                char longPressTimeout4 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 28772);
                int i405 = -(ViewConfiguration.getEdgeSlop() >> 16);
                int iComponent10 = br.AnonymousClass2.component9();
                int i406 = (i405 * (-518)) - 810152;
                int i407 = ~i405;
                int i408 = ~((~iComponent10) | i407);
                int i409 = -(-(((i408 & 1564) | (i408 ^ 1564)) * 519));
                int i410 = (i406 ^ i409) + ((i406 & i409) << 1);
                int i411 = (~iComponent10) | i407;
                int i412 = (i405 ^ 1564) | (i405 & 1564);
                int i413 = -(-(((~((i411 & 1564) | (i411 ^ 1564))) | (~((i412 & iComponent10) | (i412 ^ iComponent10)))) * (-519)));
                int i414 = ~((iComponent10 & 1564) | (iComponent10 ^ 1564));
                int i415 = (((i410 ^ i413) + ((i413 & i410) << 1)) - (~(-(-(((i405 & i414) | (i405 ^ i414)) * 519))))) - 1;
                int i416 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int i417 = (i416 & 21) + (i416 | 21);
                Object[] objArr98 = new Object[1];
                a(longPressTimeout4, i415, i417, objArr98);
                String str37 = (String) objArr98[0];
                Object[] objArr99 = new Object[1];
                a((char) ((-TextUtils.lastIndexOf("", '0')) - 1), 1586 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 31, objArr99);
                String str38 = (String) objArr99[0];
                int i418 = -(ViewConfiguration.getScrollBarSize() >> 8);
                int i419 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i420 = (i419 ^ 1617) + ((i419 & 1617) << 1);
                int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                int i421 = (keyRepeatTimeout & 12) + (keyRepeatTimeout | 12);
                Object[] objArr100 = new Object[1];
                a((char) ((i418 ^ 45406) + ((i418 & 45406) << 1)), i420, i421, objArr100);
                String str39 = (String) objArr100[0];
                int i422 = -AndroidCharacter.getMirror('0');
                int i423 = -(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int i424 = (i423 ^ 1628) + ((i423 & 1628) << 1);
                int i425 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                int i426 = (i425 & 12) + (i425 | 12);
                Object[] objArr101 = new Object[1];
                a((char) ((i422 ^ 60306) + ((i422 & 60306) << 1)), i424, i426, objArr101);
                String str40 = (String) objArr101[0];
                char c13 = (char) (12257 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
                int iKeyCodeFromString3 = KeyEvent.keyCodeFromString("");
                int i427 = ((iKeyCodeFromString3 | 1641) << 1) - (iKeyCodeFromString3 ^ 1641);
                int i428 = -View.resolveSizeAndState(0, 0, 0);
                int i429 = (i428 ^ 12) + ((i428 & 12) << 1);
                Object[] objArr102 = new Object[1];
                a(c13, i427, i429, objArr102);
                String str41 = (String) objArr102[0];
                int i430 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int i431 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                Object[] objArr103 = new Object[1];
                a((char) (((i430 | 5227) << 1) - (i430 ^ 5227)), (i431 ^ 1653) + ((i431 & 1653) << 1), 11 - (~(-(-(ViewConfiguration.getPressedStateDuration() >> 16)))), objArr103);
                String str42 = (String) objArr103[0];
                char cNormalizeMetaState3 = (char) KeyEvent.normalizeMetaState(0);
                int i432 = -TextUtils.indexOf((CharSequence) "", '0');
                Object[] objArr104 = new Object[1];
                a(cNormalizeMetaState3, ((i432 | 1664) << 1) - (i432 ^ 1664), Color.red(0) + 12, objArr104);
                String str43 = (String) objArr104[0];
                char cBlue3 = (char) Color.blue(0);
                int i433 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
                int i434 = (i433 & 1678) + (i433 | 1678);
                int i435 = -(Process.myPid() >> 22);
                int i436 = (i435 ^ 14) + ((i435 & 14) << 1);
                Object[] objArr105 = new Object[1];
                a(cBlue3, i434, i436, objArr105);
                String str44 = (String) objArr105[0];
                char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 64674);
                int i437 = 1690 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16)));
                int i438 = -TextUtils.lastIndexOf("", '0');
                int i439 = (i438 ^ 11) + ((i438 & 11) << 1);
                Object[] objArr106 = new Object[1];
                a(pressedStateDuration, i437, i439, objArr106);
                String str45 = (String) objArr106[0];
                Object[] objArr107 = new Object[1];
                a((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1702 - (~(ViewConfiguration.getScrollBarSize() >> 8)), 23 - (~(ViewConfiguration.getJumpTapTimeout() >> 16)), objArr107);
                String str46 = (String) objArr107[0];
                char capsMode2 = (char) (TextUtils.getCapsMode("", 0, 0) + 27190);
                int i440 = -(-ExpandableListView.getPackedPositionType(0L));
                int i441 = (i440 ^ 1727) + ((i440 & 1727) << 1);
                int i442 = -TextUtils.lastIndexOf("", '0');
                int iComponent11 = br.AnonymousClass2.component9();
                int i443 = (i442 * (-1335)) - 18009;
                int i444 = (i442 ^ iComponent11) | (i442 & iComponent11);
                int i445 = ~i444;
                int i446 = -(-(((i445 & (-28)) | ((-28) ^ i445)) * (-668)));
                int i447 = ~(iComponent11 | (-28));
                int i448 = ((((i443 & i446) + (i443 | i446)) + (((i442 & i447) | (i442 ^ i447)) * 1336)) - (~(-(-(((i444 ^ (-28)) | (i444 & (-28))) * 668))))) - 1;
                Object[] objArr108 = new Object[1];
                a(capsMode2, i441, i448, objArr108);
                strArr3 = new String[]{str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, (String) objArr108[0]};
                i34 = 0;
                while (true) {
                    if (i34 < 19) {
                        i34 = -1;
                        break;
                    }
                    str3 = strArr3[i34];
                    Object[] objArr109 = {str3};
                    objComponent11 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent11 == null) {
                        int doubleTapTimeout3 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 52;
                        char c14 = (char) (59725 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 6318;
                        Object[] objArr110 = new Object[1];
                        b(1, -1, (byte) 1, objArr110);
                        objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout3, c14, iLastIndexOf3, 369154319, false, (String) objArr110[0], new Class[]{String.class});
                    }
                    long jLongValue13 = ((Long) ((Method) objComponent11).invoke(null, objArr109)).longValue();
                    long jUptimeMillis = (int) SystemClock.uptimeMillis();
                    long j39 = (((445840554818L + (530 * jLongValue13)) + (((((jUptimeMillis ^ (-1)) | 841208592) ^ (-1)) | ((841208592 | jLongValue13) ^ (-1))) * 529)) + (529 * ((jLongValue13 ^ (-1)) | ((841208592 | jUptimeMillis) ^ (-1))))) - 1815710477;
                    int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                    i36 = ((int) (j39 >> 32)) & ((((-1544080518) + (((~((-1362645048) | iFreeMemory2)) | (-74581364)) * (-948))) + ((~((~iFreeMemory2) | (-3145780))) * (-948))) - 315118212);
                    int i449 = ~((int) Runtime.getRuntime().maxMemory());
                    i37 = ((int) j39) & (1104509201 + ((~(1472194901 | i449)) * 52) + (((~(1404430677 | i449)) | (~((-1453310209) | i449)) | 67764224) * (-52)) + (((~(i449 | (-1404430678))) | 18884693) * 52));
                    if (((i36 & i37) | (i36 ^ i37)) != 0) {
                        break;
                    }
                    char c15 = (char) ((-2) - (~(-(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))));
                    int i450 = -MotionEvent.axisFromString("");
                    int i451 = (i450 & 1676) + (i450 | 1676);
                    int i452 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int iComponent12 = br.AnonymousClass2.component9();
                    int i453 = i452 * 503;
                    int i454 = (i453 ^ 7042) + ((i453 & 7042) << 1);
                    int i455 = (i452 ^ 14) | (i452 & 14);
                    int i456 = -(-(i455 * (-502)));
                    int i457 = (i454 & i456) + (i454 | i456);
                    int i458 = ~i452;
                    int i459 = ~((i458 & (-15)) | (i458 ^ (-15)));
                    int i460 = ~i452;
                    int i461 = ~iComponent12;
                    int i462 = ~((i461 & i460) | (i460 ^ i461));
                    int i463 = (i459 & i462) | (i459 ^ i462);
                    int i464 = ~((i455 ^ iComponent12) | (i455 & iComponent12));
                    int i465 = -(-(((i463 & i464) | (i463 ^ i464)) * (-502)));
                    int i466 = i460 | (~iComponent12);
                    int i467 = ~((i466 & 14) | (i466 ^ 14));
                    int i468 = ~(iComponent12 | i455);
                    int i469 = (((i457 ^ i465) + ((i465 & i457) << 1)) - (~(-(-(((i467 & i468) | (i467 ^ i468)) * 502))))) - 1;
                    objArr3 = new Object[1];
                    a(c15, i451, i469, objArr3);
                    if (str3.equals((String) objArr3[0])) {
                        Object[] objArr111 = {str3};
                        objComponent12 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                        if (objComponent12 == null) {
                            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 53;
                            char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0) + 59726);
                            int i470 = 6318 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                            Object[] objArr112 = new Object[1];
                            b(1, -1, (byte) 1, objArr112);
                            objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(modifierMetaStateMask, cLastIndexOf2, i470, 369154319, false, (String) objArr112[0], new Class[]{String.class});
                        }
                        long jLongValue14 = ((Long) ((Method) objComponent12).invoke(null, objArr111)).longValue();
                        long j40 = (-77297480) | jLongValue14;
                        long j41 = (-38880632440L) + (503 * jLongValue14) + ((-502) * j40);
                        long jNextInt3 = new Random().nextInt(142948238);
                        long j42 = 77297479 | (jNextInt3 ^ (-1));
                        long j43 = (j40 | jNextInt3) ^ (-1);
                        long j44 = ((j41 + (((((77297479 | (jLongValue14 ^ (-1))) ^ (-1)) | (j42 ^ (-1))) | j43) * (-502))) + (502 * (((j42 | jLongValue14) ^ (-1)) | j43))) - 897204405;
                        int iElapsedRealtime4 = (int) SystemClock.elapsedRealtime();
                        i38 = ((int) (j44 >> 32)) & (1743401832 + ((~((~iElapsedRealtime4) | (-173016323))) * 433) + (((~(441567131 | iElapsedRealtime4)) | (-1878793543)) * (-433)) + (((~(iElapsedRealtime4 | (-1878793543))) | 268550809) * 433));
                        int iUptimeMillis6 = (int) SystemClock.uptimeMillis();
                        i39 = ((int) j44) & (((818885255 + (((~iUptimeMillis6) | (-1029696766)) * 1324)) + (((~(iUptimeMillis6 | (-1029696765))) | (~((-407529646) | iUptimeMillis6))) * (-1324))) - 442226314);
                        if (((i38 & i39) | (i38 ^ i39)) != 0) {
                            int i471 = component8;
                            i40 = (i471 ^ GapComposerKt.nodeKey) + ((i471 & GapComposerKt.nodeKey) << 1);
                            setTopP6481 = i40 % 128;
                            if (i40 % 2 == 0) {
                                break;
                            }
                            Object obj4 = null;
                            obj4.hashCode();
                            throw null;
                        }
                    }
                    i34 = (i34 ^ 1) + ((i34 & 1) << 1);
                }
                if (i34 >= 0 && (i35 = ((i34 ^ 130) + ((i34 & 130) << 1)) ^ iIntValue) != iIntValue) {
                    Object[] objArr113 = new Object[5];
                    objArr113[0] = new int[]{iIntValue};
                    objArr113[1] = new int[]{i35};
                    objArr113[4] = new int[1];
                    objArr113[2] = null;
                    objArr113[i3] = null;
                    int elapsedCpuTime6 = (int) Process.getElapsedCpuTime();
                    int i472 = ~elapsedCpuTime6;
                    int i473 = (iIntValue2 - (~((((190790502 + (((~(911313300 | i472)) | 680034) * 184)) + ((elapsedCpuTime6 | 907083796) * (-184))) + ((~((-4909539) | i472)) * 184)) + 16))) - 1;
                    int i474 = i473 << 13;
                    int i475 = (i474 | i473) & (~(i473 & i474));
                    int i476 = i475 ^ (i475 >>> 17);
                    int i477 = i476 << 5;
                    ((int[]) objArr113[4])[0] = ((~i476) & i477) | ((~i477) & i476);
                    return objArr113;
                }
            }
            int i478 = -KeyEvent.getDeadChar(0, 0);
            int i479 = i478 * (-519);
            int i480 = ((i479 | 17898955) << 1) - (i479 ^ 17898955);
            int i481 = ~i478;
            int i482 = ~(((-34356) & i481) | (i481 ^ (-34356)) | i18);
            int i483 = ~((34355 & iIntValue) | (iIntValue ^ 34355));
            int i484 = ((i482 & i483) | (i482 ^ i483)) * 520;
            int i485 = ((i480 | i484) << 1) - (i484 ^ i480);
            int i486 = ~(((-34356) ^ i18) | ((-34356) & i18));
            int i487 = ~((i478 ^ iIntValue) | (i478 & iIntValue));
            int i488 = ~(i481 | i17);
            int i489 = ~((i478 & (-34356)) | ((-34356) ^ i478));
            int i490 = (i489 & i488) | (i488 ^ i489);
            char c16 = (char) (((i485 + (((i486 & i487) | (i486 ^ i487)) * (-1040))) - (~(-(-(((i490 & i487) | (i490 ^ i487)) * 520))))) - 1);
            int i491 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            Object[] objArr114 = new Object[1];
            a(c16, ((i491 | 1754) << 1) - (i491 ^ 1754), 12 - (~(-Color.argb(0, 0, 0, 0))), objArr114);
            String str47 = (String) objArr114[0];
            int i492 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i493 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            Object[] objArr115 = new Object[1];
            a((char) ((i492 & 44093) + (i492 | 44093)), (i493 ^ 1768) + ((i493 & 1768) << 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 5, objArr115);
            String[] strArr8 = {str47, (String) objArr115[0]};
            Object[] objArr116 = new Object[1];
            a((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 1772 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), 14 - (~(ViewConfiguration.getJumpTapTimeout() >> 16)), objArr116);
            String str48 = (String) objArr116[0];
            char c17 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            int i494 = 1787 - (~Drawable.resolveOpacity(0, 0));
            int i495 = -View.getDefaultSize(0, 0);
            int i496 = (i495 & 19) + (i495 | 19);
            Object[] objArr117 = new Object[1];
            a(c17, i494, i496, objArr117);
            String str49 = (String) objArr117[0];
            char cLastIndexOf3 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
            int i497 = 1807 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
            int i498 = -View.MeasureSpec.getMode(0);
            int i499 = (i498 * 624) - 8708;
            int i500 = ((-15) & i498) | ((-15) ^ i498);
            int i501 = -(-((~((i500 & iIntValue) | (i500 ^ iIntValue))) * 623));
            int i502 = (i499 ^ i501) + ((i499 & i501) << 1);
            int i503 = ~i498;
            int i504 = ~((i503 & 14) | (i503 ^ 14));
            int i505 = -(-(((i504 & i17) | (i17 ^ i504)) * (-623)));
            int i506 = (i502 & i505) + (i505 | i502);
            int i507 = ~(((-15) ^ i498) | ((-15) & i498));
            int i508 = ~(((-15) & iIntValue) | ((-15) ^ iIntValue));
            int i509 = (i508 & i507) | (i507 ^ i508);
            int i510 = ~((i498 & iIntValue) | (i498 ^ iIntValue));
            int i511 = (i506 - (~(((i510 & i509) | (i509 ^ i510)) * 623))) - 1;
            Object[] objArr118 = new Object[1];
            a(cLastIndexOf3, i497, i511, objArr118);
            String[] strArr9 = {str48, str49, (String) objArr118[0]};
            char jumpTapTimeout4 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int i512 = 1820 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
            int i513 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
            int i514 = (i513 ^ 21) + ((i513 & 21) << 1);
            Object[] objArr119 = new Object[1];
            a(jumpTapTimeout4, i512, i514, objArr119);
            String str50 = (String) objArr119[0];
            int i515 = -(-(ViewConfiguration.getTouchSlop() >> 8));
            int i516 = 1840 - (~(-TextUtils.indexOf((CharSequence) "", '0')));
            int i517 = -TextUtils.getOffsetAfter("", 0);
            int i518 = ((i517 | 10) << 1) - (i517 ^ 10);
            Object[] objArr120 = new Object[1];
            a((char) ((i515 & 55679) + (i515 | 55679)), i516, i518, objArr120);
            String[] strArr10 = {str50, (String) objArr120[0]};
            int i519 = -(-TextUtils.getOffsetAfter("", 0));
            int i520 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1851;
            int i521 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
            int i522 = (i521 & 11) + (i521 | 11);
            Object[] objArr121 = new Object[1];
            a((char) (((i519 | 11298) << 1) - (i519 ^ 11298)), i520, i522, objArr121);
            String str51 = (String) objArr121[0];
            Object[] objArr122 = new Object[1];
            a((char) ((-2) - ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) ^ (-1))), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 588, 5 - (~(-View.MeasureSpec.getSize(0))), objArr122);
            String[] strArr11 = {str51, (String) objArr122[0]};
            int threadPriority2 = Process.getThreadPriority(0);
            int i523 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            int i524 = ((i523 | 1864) << 1) - (i523 ^ 1864);
            int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration() >> 16;
            int i525 = (scrollBarFadeDuration & 28) + (scrollBarFadeDuration | 28);
            Object[] objArr123 = new Object[1];
            a((char) ((((threadPriority2 | 20) << 1) - (threadPriority2 ^ 20)) >> 6), i524, i525, objArr123);
            String str52 = (String) objArr123[0];
            int i526 = -(-ExpandableListView.getPackedPositionType(0L));
            int i527 = 1840 - (~(-Process.getGidForName("")));
            int i528 = -TextUtils.getTrimmedLength("");
            int i529 = ((i528 | 10) << 1) - (i528 ^ 10);
            Object[] objArr124 = new Object[1];
            a((char) (((i526 | 55679) << 1) - (i526 ^ 55679)), i527, i529, objArr124);
            strArr = new String[][]{strArr8, strArr9, strArr10, strArr11, new String[]{str52, (String) objArr124[0]}};
            i21 = 0;
            i22 = -1;
            loop5: while (true) {
                if (i21 < 5) {
                    i23 = iIntValue;
                    break;
                }
                int i530 = setTopP6481 + 113;
                component8 = i530 % 128;
                int i531 = i530 % 2;
                String[] strArr12 = strArr[i21];
                str2 = strArr12[0];
                i30 = 1;
                strArr2 = (String[]) Arrays.copyOfRange(strArr12, 1, strArr12.length);
                length = strArr2.length;
                i31 = 0;
                while (i31 < length) {
                    int i532 = component8;
                    int i533 = ((i532 | 111) << i30) - (i532 ^ 111);
                    setTopP6481 = i533 % 128;
                    int i534 = i533 % 2;
                    i22++;
                    Object[] objArr125 = {str2, strArr2[i31]};
                    objComponent10 = setSystemGestureExclusionRectsL30479.component5(1297851439);
                    if (objComponent10 == null) {
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 52;
                        char size = (char) (41180 - View.MeasureSpec.getSize(0));
                        int mirror3 = 3575 - AndroidCharacter.getMirror('0');
                        Object[] objArr126 = new Object[1];
                        b(0, -1, (byte) 2, objArr126);
                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionType, size, mirror3, 535748684, false, (String) objArr126[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue15 = ((Long) ((Method) objComponent10).invoke(null, objArr125)).longValue();
                    long elapsedCpuTime7 = (int) Process.getElapsedCpuTime();
                    long j45 = elapsedCpuTime7 ^ (-1);
                    long j46 = jLongValue15 ^ (-1);
                    long j47 = (-140139122310L) + ((-163) * jLongValue15) + ((-328) * ((-849328014) | ((j45 | jLongValue15) ^ (-1)))) + (((-849328014) | elapsedCpuTime7) * 164) + (164 * ((((j45 | (-849328014)) | jLongValue15) ^ (-1)) | ((849328013 | j46) ^ (-1)) | ((j46 | elapsedCpuTime7) ^ (-1)))) + 1215132944;
                    int iUptimeMillis7 = (int) SystemClock.uptimeMillis();
                    i32 = ((int) (j47 >> 32)) & ((-1153123274) + (((~iUptimeMillis7) | 1790290645) * 1444) + (((~(iUptimeMillis7 | 1970274626)) | (~((-533048216) | iUptimeMillis7)) | 176532117) * (-1444)) + 195309684);
                    int iMyTid6 = Process.myTid();
                    int i535 = (~(247141823 | iMyTid6)) | (-1325350912);
                    int i536 = ~((~iMyTid6) | (-111875499));
                    i33 = ((int) j47) & ((-1581897131) + ((i535 | i536) * (-470)) + (((~(iMyTid6 | (-1078209089))) | i536) * 470));
                    if (((i32 & i33) | (i32 ^ i33)) != 0) {
                        int i537 = (i22 ^ 170) + ((i22 & 170) << 1);
                        i23 = (i537 & i17) | ((~i537) & iIntValue);
                        break loop5;
                    }
                    int i538 = (i31 & (-117)) + (i31 | (-117));
                    i31 = ((i538 | 118) << 1) - (i538 ^ 118);
                    br.AnonymousClass2.component9();
                    strArr = strArr;
                    i21 = i21;
                    i30 = 1;
                }
                String[][] strArr13 = strArr;
                int i539 = i21;
                int i540 = ((i539 | (-24)) << 1) - (i539 ^ (-24));
                i21 = (i540 ^ 25) + ((i540 & 25) << 1);
                strArr = strArr13;
            }
            if (i23 != iIntValue) {
                Object[] objArr127 = new Object[5];
                objArr127[0] = new int[]{iIntValue};
                objArr127[1] = new int[]{i23};
                objArr127[4] = new int[1];
                objArr127[2] = null;
                objArr127[i3] = null;
                int i541 = ~new Random().nextInt(254515546);
                int i542 = ~(440419759 | i541);
                int i543 = 1211837938 + ((i542 | 475803079) * 764) + (((~(i541 | 475803079)) | 33570856) * (-1528)) + ((102525032 | i542) * 764);
                int i544 = (iIntValue2 - (~(-(-((i543 ^ 16) + ((i543 & 16) << 1)))))) - 1;
                int i545 = i544 << 13;
                int i546 = (i545 & (~i544)) | ((~i545) & i544);
                int i547 = i546 >>> 17;
                int i548 = ((~i546) & i547) | ((~i547) & i546);
                int i549 = i548 << 5;
                ((int[]) objArr127[4])[0] = ((~i548) & i549) | ((~i549) & i548);
                return objArr127;
            }
            try {
                char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1892;
                int iRgb = Color.rgb(0, 0, 0);
                int iComponent13 = br.AnonymousClass2.component9();
                int i550 = iRgb * (-813);
                int i551 = ((i550 | (-1744825160)) << 1) - (i550 ^ (-1744825160));
                int i552 = (iRgb ^ iComponent13) | (iRgb & iComponent13);
                int i553 = ((~(((-16777230) & iRgb) | ((-16777230) ^ iRgb))) | (~i552)) * (-814);
                int i554 = (i551 ^ i553) + ((i553 & i551) << 1);
                int i555 = ~iComponent13;
                int i556 = ~((i555 & (-16777230)) | ((-16777230) ^ i555));
                int i557 = ~iRgb;
                int i558 = ~((i557 ^ 16777229) | (i557 & 16777229));
                int i559 = -(-(((i556 & i558) | (i556 ^ i558) | (~i552)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                int i560 = ~((i557 & iComponent13) | (i557 ^ iComponent13));
                int i561 = (i560 & i558) | (i558 ^ i560);
                int i562 = ~((iComponent13 & 16777229) | (iComponent13 ^ 16777229));
                int i563 = (((i554 | i559) << 1) - (i559 ^ i554)) + (((i561 & i562) | (i561 ^ i562)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE);
                Object[] objArr128 = new Object[1];
                a(deadChar2, iIndexOf6, i563, objArr128);
                String str53 = (String) objArr128[0];
                char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i564 = -TextUtils.lastIndexOf("", '0', 0, 0);
                int i565 = (i564 & 1903) + (i564 | 1903);
                int i566 = -Color.red(0);
                int i567 = (i566 & 8) + (i566 | 8);
                Object[] objArr129 = new Object[1];
                a(maximumFlingVelocity2, i565, i567, objArr129);
                try {
                    Object[] objArr130 = {str53, (String) objArr129[0]};
                    objComponent9 = setSystemGestureExclusionRectsL30479.component5(1297851439);
                    if (objComponent9 == null) {
                        int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 52;
                        char fadingEdgeLength3 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 41180);
                        int iResolveSize = 3527 - View.resolveSize(0, 0);
                        Object[] objArr131 = new Object[1];
                        b(0, -1, (byte) 2, objArr131);
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(minimumFlingVelocity3, fadingEdgeLength3, iResolveSize, 535748684, false, (String) objArr131[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue16 = ((Long) ((Method) objComponent9).invoke(null, objArr130)).longValue();
                    long jUptimeMillis2 = (int) SystemClock.uptimeMillis();
                    long j48 = 94048245300L + (302 * jLongValue16) + (((((-313494151) | jLongValue16) | jUptimeMillis2) ^ (-1)) * (-301));
                    long j49 = jLongValue16 ^ (-1);
                    long j50 = j48 + ((-301) * ((((jUptimeMillis2 ^ (-1)) | (-313494151)) ^ (-1)) | ((j49 | jUptimeMillis2) ^ (-1)))) + (301 * (j49 | ((313494150 | jUptimeMillis2) ^ (-1)))) + 679299081;
                    int iNextInt11 = new Random().nextInt(788321808);
                    i28 = ((int) (j50 >> 32)) & (1153515458 + (((~(1056830678 | iNextInt11)) | 380395732) * (-756)) + (((~iNextInt11) | 1056830678) * 756));
                    int i568 = (int) j50;
                    int i569 = ~(Process.myTid() | 1267785014);
                    i29 = i568 & (((357830697 | i569) * (-658)) + 1704926357 + ((i569 | 340000777) * 658));
                    if (((i28 & i29) | (i28 ^ i29)) != 0) {
                        i24 = iIntValue & (-151);
                        i25 = i17 & 150;
                        i26 = i24 | i25;
                    } else {
                        int i570 = setTopP6481 + 89;
                        component8 = i570 % 128;
                        int i571 = i570 % 2;
                        i26 = iIntValue;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            } catch (Exception unused4) {
                i24 = iIntValue & (-152);
                i25 = i17 & 151;
            }
            if (i26 != iIntValue) {
                Object[] objArr132 = new Object[5];
                objArr132[0] = new int[]{iIntValue};
                objArr132[1] = new int[]{i26};
                objArr132[4] = new int[1];
                objArr132[2] = null;
                objArr132[i3] = null;
                int iMyTid7 = Process.myTid();
                int i572 = ~((-872784584) | iMyTid7);
                int i573 = ~iMyTid7;
                int i574 = i572 | (~(43438255 | i573));
                int i575 = ~(872784583 | i573);
                int i576 = (iIntValue2 - (~(((((-637801514) + ((i574 | i575) * (-516))) + (((~(iMyTid7 | (-295048))) | (~((-43143209) | i573))) * 516)) + ((43143208 | i575) * 516)) + 16))) - 1;
                int i577 = i576 << 13;
                int i578 = (i577 & (~i576)) | ((~i577) & i576);
                int i579 = i578 >>> 17;
                int i580 = ((~i578) & i579) | ((~i579) & i578);
                int i581 = i580 << 5;
                ((int[]) objArr132[4])[0] = (i580 | i581) & (~(i580 & i581));
                return objArr132;
            }
            int i582 = -Color.blue(0);
            Object[] objArr133 = new Object[1];
            a((char) ((i582 & 23298) + (i582 | 23298)), TextUtils.indexOf((CharSequence) "", '0', 0) + 1913, 47 - (Process.myPid() >> 22), objArr133);
            Object[] objArr134 = {(String) objArr133[0]};
            objComponent8 = setSystemGestureExclusionRectsL30479.component5(1152753004);
            if (objComponent8 == null) {
                int i583 = 53 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char c18 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 59725);
                int iLastIndexOf4 = 6316 - TextUtils.lastIndexOf("", '0', 0);
                Object[] objArr135 = new Object[1];
                b(1, -1, (byte) 1, objArr135);
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i583, c18, iLastIndexOf4, 369154319, false, (String) objArr135[0], new Class[]{String.class});
            }
            long jLongValue17 = ((Long) ((Method) objComponent8).invoke(null, objArr134)).longValue();
            long j51 = jLongValue17 ^ (-1);
            long j52 = 229686793 | j51;
            long jNextInt4 = new Random().nextInt();
            long j53 = jNextInt4 ^ (-1);
            long j54 = ((((38357694598L + ((-167) * jLongValue17)) + (((j52 ^ (-1)) | ((j51 | j53) ^ (-1))) * 168)) + (((j52 | jNextInt4) ^ (-1)) * 168)) + (168 * ((((229686793 | jLongValue17) ^ (-1)) | ((229686793 | j53) ^ (-1))) | (((j51 | (-229686794)) | jNextInt4) ^ (-1))))) - 744815091;
            int iNextInt12 = new Random().nextInt();
            int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
            int i584 = ((((int) (j54 >> 32)) & (538936514 + (((-1073809673) | iNextInt12) * (-381)) + (((~((~iNextInt12) | (-1931692463))) | (-1141975305)) * 381) + 1099591912)) | (((int) j54) & ((-1587633331) + (((~(1381892508 | iFreeMemory3)) | (-1476372926) | (~(1475848377 | iFreeMemory3))) * (-744)) + (((~iFreeMemory3) | 1381367960) * 744) + ((iFreeMemory3 | 1476372925) * 744)))) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED;
            i27 = (i584 | iIntValue) & (~(iIntValue & i584));
            if (i27 != iIntValue) {
                Object[] objArr136 = new Object[5];
                objArr136[0] = new int[]{iIntValue};
                objArr136[1] = new int[]{i27};
                objArr136[4] = new int[1];
                objArr136[2] = null;
                objArr136[i3] = null;
                int iElapsedRealtime5 = (int) SystemClock.elapsedRealtime();
                int i585 = ~iElapsedRealtime5;
                int i586 = 2137939772 + (((~((-336097464) | i585)) | 580125375) * 519) + (((~(i585 | (-336097281))) | (~(916222655 | iElapsedRealtime5))) * (-519)) + (((~(iElapsedRealtime5 | 580125375)) | 336097463) * 519) + 16;
                int i587 = (iIntValue2 & i586) + (iIntValue2 | i586);
                int i588 = i587 << 13;
                int i589 = ((~i587) & i588) | ((~i588) & i587);
                int i590 = i589 >>> 17;
                int i591 = ((~i589) & i590) | ((~i590) & i589);
                int i592 = i591 << 5;
                ((int[]) objArr136[4])[0] = (i591 | i592) & (~(i591 & i592));
                return objArr136;
            }
            Object[] objArr137 = new Object[5];
            objArr137[0] = new int[]{iIntValue};
            objArr137[1] = new int[]{iIntValue};
            objArr137[4] = new int[1];
            objArr137[2] = null;
            objArr137[i3] = null;
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i593 = (~((-462495408) | iMaxMemory2)) | 453055623;
            int i594 = ~iMaxMemory2;
            int i595 = 13308736 + ((i593 | (~(463167215 | i594))) * 886) + (((~(i594 | 462495407)) | 453727431) * (-1772)) + ((~(i594 | 453727431)) * 886);
            int i596 = (i595 << 1) - i595;
            int i597 = ((iIntValue2 | i596) << 1) - (i596 ^ iIntValue2);
            int i598 = i597 << 13;
            int i599 = (i598 & (~i597)) | ((~i598) & i597);
            int i600 = i599 >>> 17;
            int i601 = ((~i599) & i600) | ((~i600) & i599);
            int i602 = i601 << 5;
            ((int[]) objArr137[4])[0] = (i601 | i602) & (~(i601 & i602));
            return objArr137;
        }
        obj2 = null;
        int i603 = -Drawable.resolveOpacity(0, 0);
        Object[] objArr138 = new Object[1];
        a((char) ((i603 & 20747) + (i603 | 20747)), ExpandableListView.getPackedPositionGroup(0L) + 372, 22 - ImageFormat.getBitsPerPixel(0), objArr138);
        String str54 = (String) objArr138[0];
        int i604 = -(-((Process.getThreadPriority(0) + 20) >> 6));
        Object[] objArr139 = new Object[1];
        a((char) (((47330 | i604) << 1) - (i604 ^ 47330)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 617, 10 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr139);
        String str55 = (String) objArr139[0];
        char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
        int i605 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
        int i606 = ((i605 | 627) << 1) - (i605 ^ 627);
        int doubleTapTimeout4 = ViewConfiguration.getDoubleTapTimeout() >> 16;
        int i607 = (((doubleTapTimeout4 * 495) - 3451) - (~(-(-(((doubleTapTimeout4 ^ (-8)) | (doubleTapTimeout4 & (-8))) * (-988)))))) - 1;
        int i608 = ((~doubleTapTimeout4) | 7 | i284) * 494;
        int i609 = (i607 ^ i608) + ((i607 & i608) << 1);
        int i610 = ~doubleTapTimeout4;
        int i611 = ~((i610 & (-8)) | (i610 ^ (-8)));
        int i612 = ~((i284 ^ 7) | (i284 & 7));
        int i613 = ((~((doubleTapTimeout4 & 7) | (doubleTapTimeout4 ^ 7))) | (i611 ^ i612) | (i611 & i612)) * 494;
        int i614 = ((i609 | i613) << 1) - (i613 ^ i609);
        Object[] objArr140 = new Object[1];
        a(cCombineMeasuredStates, i606, i614, objArr140);
        String str56 = (String) objArr140[0];
        char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMyTid8 = Process.myTid() >> 22;
        Object[] objArr141 = new Object[1];
        a(cMakeMeasureSpec, (iMyTid8 & 634) + (iMyTid8 | 634), 8 - Gravity.getAbsoluteGravity(0, 0), objArr141);
        String[] strArr14 = {str54, str55, str56, (String) objArr141[0]};
        int i615 = -((Process.getThreadPriority(0) + 20) >> 6);
        int i616 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
        int i617 = (i616 ^ 642) + ((i616 & 642) << 1);
        int i618 = -KeyEvent.keyCodeFromString("");
        int i619 = i618 * (-661);
        int i620 = (i619 & (-11237)) + (i619 | (-11237));
        int i621 = ~i618;
        int i622 = ~((i621 & (-18)) | (i621 ^ (-18)));
        int i623 = (i620 - (~(-(-(((i622 & i284) | (i284 ^ i622)) * 1324))))) - 1;
        int i624 = ~(i618 | iIntValue);
        int i625 = ~((iIntValue ^ 17) | (iIntValue & 17));
        int i626 = -(-(((i624 & i625) | (i624 ^ i625)) * (-1324)));
        int i627 = (i623 & i626) + (i626 | i623);
        int i628 = ~i618;
        int i629 = ~((i628 & 17) | (i628 ^ 17));
        int i630 = ~(i618 | (-18));
        int i631 = i627 + (((i630 & i629) | (i629 ^ i630)) * 662);
        Object[] objArr142 = new Object[1];
        a((char) (((57872 | i615) << 1) - (i615 ^ 57872)), i617, i631, objArr142);
        String str57 = (String) objArr142[0];
        char c19 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
        int tapTimeout3 = (ViewConfiguration.getTapTimeout() >> 16) + 659;
        int iNormalizeMetaState = KeyEvent.normalizeMetaState(0);
        int i632 = (iNormalizeMetaState & 7) + (iNormalizeMetaState | 7);
        Object[] objArr143 = new Object[1];
        a(c19, tapTimeout3, i632, objArr143);
        String str58 = (String) objArr143[0];
        char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
        int i633 = -(-Color.alpha(0));
        Object[] objArr144 = new Object[1];
        a(packedPositionType2, ((i633 | 666) << 1) - (i633 ^ 666), 6 - (~(-(-Color.blue(0)))), objArr144);
        String str59 = (String) objArr144[0];
        char c20 = (char) (29847 - (~(-Process.getGidForName(""))));
        int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 673;
        int i634 = -Process.getGidForName("");
        int i635 = ((i634 | 10) << 1) - (i634 ^ 10);
        Object[] objArr145 = new Object[1];
        a(c20, pressedStateDuration2, i635, objArr145);
        String str60 = (String) objArr145[0];
        char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 56916);
        int i636 = 683 - (~(ViewConfiguration.getMaximumFlingVelocity() >> 16));
        int i637 = -Color.rgb(0, 0, 0);
        Object[] objArr146 = new Object[1];
        a(packedPositionChild, i636, ((i637 | (-16777202)) << 1) - (i637 ^ (-16777202)), objArr146);
        String[] strArr15 = {str57, str58, str59, str60, (String) objArr146[0]};
        char cResolveOpacity2 = (char) Drawable.resolveOpacity(0, 0);
        int i638 = -ExpandableListView.getPackedPositionGroup(0L);
        int iComponent14 = br.AnonymousClass2.component9();
        int i639 = i638 * (-167);
        int i640 = ((-116566) & i639) + (i639 | (-116566));
        int i641 = ~i638;
        int i642 = ~((i641 ^ (-699)) | (i641 & (-699)));
        int i643 = ~iComponent14;
        int i644 = -(-((i642 | (~(((-699) ^ i643) | ((-699) & i643)))) * 168));
        int i645 = ((i640 | i644) << 1) - (i640 ^ i644);
        int i646 = ~i638;
        int i647 = i646 | (-699);
        int i648 = -(-((~((i647 ^ iComponent14) | (i647 & iComponent14))) * 168));
        int i649 = ((i645 | i648) << 1) - (i648 ^ i645);
        int i650 = ~(i646 | i643);
        int i651 = ~((i641 & 698) | (i641 ^ 698));
        int i652 = (i651 & i650) | (i650 ^ i651);
        int i653 = ~((i638 & (-699)) | ((-699) ^ i638) | iComponent14);
        int i654 = ((i653 & i652) | (i652 ^ i653)) * 168;
        int i655 = (i649 & i654) + (i649 | i654);
        int i656 = -((byte) KeyEvent.getModifierMetaStateMask());
        int i657 = ((i656 | 15) << 1) - (i656 ^ 15);
        Object[] objArr147 = new Object[1];
        a(cResolveOpacity2, i655, i657, objArr147);
        String str61 = (String) objArr147[0];
        int i658 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
        int i659 = -(ViewConfiguration.getPressedStateDuration() >> 16);
        Object[] objArr148 = new Object[1];
        a((char) (((i658 | 17995) << 1) - (i658 ^ 17995)), ((i659 | 714) << 1) - (i659 ^ 714), 2 - TextUtils.lastIndexOf("", '0', 0), objArr148);
        String str62 = (String) objArr148[0];
        char cMyPid = (char) (Process.myPid() >> 22);
        int i660 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
        int i661 = (i660 & 724) + (i660 | 724);
        int i662 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
        int i663 = (i662 & 22) + (i662 | 22);
        Object[] objArr149 = new Object[1];
        a(cMyPid, i661, i663, objArr149);
        String str63 = (String) objArr149[0];
        char c21 = (char) (52249 - (~View.combineMeasuredStates(0, 0)));
        int i664 = -(-(ViewConfiguration.getWindowTouchSlop() >> 8));
        Object[] objArr150 = new Object[1];
        a(c21, (i664 & 747) + (i664 | 747), Drawable.resolveOpacity(0, 0) + 25, objArr150);
        String str64 = (String) objArr150[0];
        char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
        int offsetBefore4 = 772 - TextUtils.getOffsetBefore("", 0);
        int i665 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int i666 = (i665 & 28) + (i665 | 28);
        Object[] objArr151 = new Object[1];
        a(cIndexOf3, offsetBefore4, i666, objArr151);
        int i667 = i284;
        String[] strArr16 = {str61, str62, str, str63, str64, (String) objArr151[0]};
        int i668 = -(-TextUtils.indexOf((CharSequence) "", '0', 0));
        int i669 = 799 - (~(ViewConfiguration.getScrollBarFadeDuration() >> 16));
        int i670 = -Color.red(0);
        int i671 = (i670 ^ 11) + ((i670 & 11) << 1);
        Object[] objArr152 = new Object[1];
        a((char) (((i668 | 1) << 1) - (i668 ^ 1)), i669, i671, objArr152);
        String str65 = (String) objArr152[0];
        char c22 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int iMyTid9 = (Process.myTid() >> 22) + 811;
        int i672 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
        int i673 = (i672 & 8) + (i672 | 8);
        Object[] objArr153 = new Object[1];
        a(c22, iMyTid9, i673, objArr153);
        String str66 = (String) objArr153[0];
        Object[] objArr154 = new Object[1];
        a((char) ((-2) - (~(-TextUtils.lastIndexOf("", '0', 0)))), TextUtils.indexOf("", "") + 819, 6 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr154);
        String str67 = (String) objArr154[0];
        char doubleTapTimeout5 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
        int i674 = -(ViewConfiguration.getTouchSlop() >> 8);
        Object[] objArr155 = new Object[1];
        a(doubleTapTimeout5, (i674 & 825) + (i674 | 825), TextUtils.indexOf("", "", 0) + 6, objArr155);
        String[] strArr17 = {str65, str66, str67, (String) objArr155[0]};
        char c23 = (char) (60088 - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))));
        int i675 = 830 - (~(-(-(Process.myPid() >> 22))));
        int capsMode3 = TextUtils.getCapsMode("", 0, 0);
        int i676 = (capsMode3 ^ 16) + ((capsMode3 & 16) << 1);
        Object[] objArr156 = new Object[1];
        a(c23, i675, i676, objArr156);
        String str68 = (String) objArr156[0];
        char c24 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int i677 = -TextUtils.getOffsetBefore("", 0);
        Object[] objArr157 = new Object[1];
        a(c24, (i677 & 666) + (i677 | 666), 6 - (~(-(ViewConfiguration.getMinimumFlingVelocity() >> 16))), objArr157);
        String str69 = (String) objArr157[0];
        char cMyTid2 = (char) (Process.myTid() >> 22);
        int i678 = 632 - (~(-ExpandableListView.getPackedPositionChild(0L)));
        int i679 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
        int i680 = (i679 ^ 7) + ((i679 & 7) << 1);
        Object[] objArr158 = new Object[1];
        a(cMyTid2, i678, i680, objArr158);
        String[] strArr18 = {str68, str69, (String) objArr158[0]};
        char deadChar3 = (char) KeyEvent.getDeadChar(0, 0);
        int i681 = 846 - (~(-(Process.myPid() >> 22)));
        int i682 = -TextUtils.getTrimmedLength("");
        int i683 = (i682 ^ 14) + ((i682 & 14) << 1);
        Object[] objArr159 = new Object[1];
        a(deadChar3, i681, i683, objArr159);
        String str70 = (String) objArr159[0];
        char cNormalizeMetaState4 = (char) KeyEvent.normalizeMetaState(0);
        int i684 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
        Object[] objArr160 = new Object[1];
        a(cNormalizeMetaState4, ((i684 | 861) << 1) - (i684 ^ 861), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr160);
        String[] strArr19 = {str70, (String) objArr160[0]};
        char mode4 = (char) View.MeasureSpec.getMode(0);
        char mirror4 = AndroidCharacter.getMirror('0');
        int iComponent15 = br.AnonymousClass2.component9();
        int i685 = mirror4 * 65035;
        int i686 = ((409442 | i685) << 1) - (i685 ^ 409442);
        int i687 = ~((-815) | iComponent15);
        int i688 = ~((mirror4 ^ 814) | (mirror4 & 814));
        int i689 = i686 + (((i687 & i688) | (i687 ^ i688)) * (-502));
        int i690 = ~iComponent15;
        int i691 = (i690 & (-815)) | ((-815) ^ i690);
        int i692 = i689 + ((~((i691 & mirror4) | (i691 ^ mirror4))) * (-502));
        int i693 = ~mirror4;
        int i694 = ~((i693 & iComponent15) | (i693 ^ iComponent15));
        int i695 = (i692 - (~(((i694 & (-815)) | ((-815) ^ i694)) * 502))) - 1;
        int packedPositionType3 = ExpandableListView.getPackedPositionType(0L);
        int i696 = (packedPositionType3 ^ 9) + ((packedPositionType3 & 9) << 1);
        Object[] objArr161 = new Object[1];
        a(mode4, i695, i696, objArr161);
        String str71 = (String) objArr161[0];
        Object[] objArr162 = new Object[1];
        a((char) ExpandableListView.getPackedPositionType(0L), 870 - (~(-(ViewConfiguration.getScrollBarSize() >> 8))), KeyEvent.normalizeMetaState(0) + 1, objArr162);
        String[] strArr20 = {str71, (String) objArr162[0]};
        Object[] objArr163 = new Object[1];
        a((char) (ViewConfiguration.getLongPressTimeout() >> 16), Color.green(0) + 872, TextUtils.indexOf("", "", 0) + 16, objArr163);
        String str72 = (String) objArr163[0];
        Object[] objArr164 = new Object[1];
        a((char) (17996 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 714 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 2 - (~(-TextUtils.getOffsetBefore("", 0))), objArr164);
        String str73 = (String) objArr164[0];
        char threadPriority3 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
        int i697 = 658 - (~(-View.resolveSize(0, 0)));
        int i698 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
        int i699 = (i698 & 8) + (i698 | 8);
        Object[] objArr165 = new Object[1];
        a(threadPriority3, i697, i699, objArr165);
        String str74 = (String) objArr165[0];
        int iLastIndexOf5 = TextUtils.lastIndexOf("", '0');
        char c25 = (char) (((58737 | iLastIndexOf5) << 1) - (iLastIndexOf5 ^ 58737));
        int i700 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
        int i701 = (i700 & 889) + (i700 | 889);
        int i702 = -TextUtils.getOffsetAfter("", 0);
        int i703 = ((i702 | 8) << 1) - (i702 ^ 8);
        Object[] objArr166 = new Object[1];
        a(c25, i701, i703, objArr166);
        String str75 = (String) objArr166[0];
        char c26 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 29848);
        int i704 = -(-TextUtils.getOffsetBefore("", 0));
        int i705 = (i704 ^ 673) + ((i704 & 673) << 1);
        int i706 = -(-TextUtils.getOffsetBefore("", 0));
        Object[] objArr167 = new Object[1];
        a(c26, i705, (i706 & 11) + (i706 | 11), objArr167);
        String str76 = (String) objArr167[0];
        int iResolveOpacity2 = Drawable.resolveOpacity(0, 0);
        int iBlue2 = Color.blue(0);
        Object[] objArr168 = new Object[1];
        a((char) (((56915 | iResolveOpacity2) << 1) - (iResolveOpacity2 ^ 56915)), (iBlue2 ^ 684) + ((iBlue2 & 684) << 1), 13 - (~Color.blue(0)), objArr168);
        String[] strArr21 = {str72, str73, str74, str75, str76, (String) objArr168[0]};
        int i707 = -(ViewConfiguration.getLongPressTimeout() >> 16);
        int i708 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
        int i709 = ((i708 | 896) << 1) - (i708 ^ 896);
        int i710 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int i711 = ((i710 | 20) << 1) - (i710 ^ 20);
        Object[] objArr169 = new Object[1];
        a((char) ((38864 & i707) + (i707 | 38864)), i709, i711, objArr169);
        String str77 = (String) objArr169[0];
        int i712 = -(-Color.rgb(0, 0, 0));
        Object[] objArr170 = new Object[1];
        a((char) (((16814805 | i712) << 1) - (i712 ^ 16814805)), (-16776300) - Color.rgb(0, 0, 0), 19 - (~(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), objArr170);
        String str78 = (String) objArr170[0];
        char cGreen = (char) Color.green(0);
        int i713 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
        int i714 = i713 * (-317);
        int i715 = i667 | i713;
        int i716 = (298265 & i714) + (i714 | 298265) + (((~((~i713) | (-936) | iIntValue)) | (~((i715 & 935) | (i715 ^ 935)))) * (-318));
        int i717 = ~(((-936) ^ i713) | ((-936) & i713));
        int i718 = ~((i713 ^ iIntValue) | (i713 & iIntValue));
        int i719 = (i716 - (~(-(-(((i717 & i718) | (i717 ^ i718)) * (-318)))))) - 1;
        int i720 = ~((~i713) | iIntValue);
        int i721 = ((i720 & (-936)) | ((-936) ^ i720)) * TypedValues.Attributes.TYPE_PIVOT_TARGET;
        int i722 = (i719 & i721) + (i721 | i719);
        int iMyTid10 = Process.myTid() >> 22;
        int i723 = ((iMyTid10 | 31) << 1) - (iMyTid10 ^ 31);
        Object[] objArr171 = new Object[1];
        a(cGreen, i722, i723, objArr171);
        String str79 = (String) objArr171[0];
        int i724 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
        int i725 = -TextUtils.lastIndexOf("", '0', 0, 0);
        int i726 = ((i725 | 965) << 1) - (i725 ^ 965);
        int iLastIndexOf6 = TextUtils.lastIndexOf("", '0', 0);
        int i727 = (iLastIndexOf6 ^ 27) + ((iLastIndexOf6 & 27) << 1);
        Object[] objArr172 = new Object[1];
        a((char) ((i724 & 17060) + (i724 | 17060)), i726, i727, objArr172);
        String str80 = (String) objArr172[0];
        char cResolveSize = (char) View.resolveSize(0, 0);
        int i728 = 992 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
        int i729 = -(-Color.blue(0));
        int i730 = ((i729 | 23) << 1) - (i729 ^ 23);
        Object[] objArr173 = new Object[1];
        a(cResolveSize, i728, i730, objArr173);
        String str81 = (String) objArr173[0];
        int i731 = -KeyEvent.getDeadChar(0, 0);
        int i732 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
        int i733 = ((i732 | 1014) << 1) - (i732 ^ 1014);
        int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0');
        int i734 = (iIndexOf7 & 34) + (iIndexOf7 | 34);
        Object[] objArr174 = new Object[1];
        a((char) ((i731 ^ 29807) + ((i731 & 29807) << 1)), i733, i734, objArr174);
        i17 = i13;
        String[] strArr22 = {str77, str78, str79, str80, str81, (String) objArr174[0], str};
        int i735 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
        int i736 = -(Process.myTid() >> 22);
        Object[] objArr175 = new Object[1];
        a((char) ((42175 & i735) + (i735 | 42175)), ((i736 | 1048) << 1) - (i736 ^ 1048), 12 - (~(-(-(ViewConfiguration.getTouchSlop() >> 8)))), objArr175);
        String str82 = (String) objArr175[0];
        int threadPriority4 = Process.getThreadPriority(0);
        int i737 = (-16600) + (threadPriority4 * 832);
        int i738 = ~threadPriority4;
        int i739 = ~((i738 ^ i667) | (i738 & i667));
        int i740 = ~((threadPriority4 ^ 20) | (threadPriority4 & 20) | iIntValue);
        int i741 = ((i739 & i740) | (i739 ^ i740)) * (-831);
        int i742 = (i738 & 20) | (i738 ^ 20);
        int i743 = (((i737 ^ i741) + ((i737 & i741) << 1)) - (~((~((i742 & iIntValue) | (i742 ^ iIntValue))) * (-1662)))) - 1;
        int i744 = (~(((-21) ^ i17) | ((-21) & i17))) | (~((iIntValue ^ 20) | (iIntValue & 20)));
        int i745 = ~((threadPriority4 & iIntValue) | (threadPriority4 ^ iIntValue));
        int i746 = ((i745 & i744) | (i744 ^ i745)) * 831;
        Object[] objArr176 = new Object[1];
        a((char) (((i743 ^ i746) + ((i746 & i743) << 1)) >> 6), (ViewConfiguration.getTouchSlop() >> 8) + 627, 7 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr176);
        String[] strArr23 = {str82, (String) objArr176[0]};
        char packedPositionChild2 = (char) (61558 - ExpandableListView.getPackedPositionChild(0L));
        int i747 = -TextUtils.indexOf("", "");
        Object[] objArr177 = new Object[1];
        a(packedPositionChild2, ((i747 | 1061) << 1) - (i747 ^ 1061), 29 - TextUtils.indexOf((CharSequence) "", '0', 0), objArr177);
        String str83 = (String) objArr177[0];
        char mode5 = (char) View.MeasureSpec.getMode(0);
        int i748 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
        Object[] objArr178 = new Object[1];
        a(mode5, ((i748 | 1091) << 1) - (i748 ^ 1091), 10 - ImageFormat.getBitsPerPixel(0), objArr178);
        String[] strArr24 = {str83, (String) objArr178[0]};
        char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
        int i749 = -(ViewConfiguration.getTouchSlop() >> 8);
        int i750 = (i749 & 1102) + (i749 | 1102);
        int i751 = -TextUtils.getOffsetAfter("", 0);
        int i752 = (i751 & 19) + (i751 | 19);
        Object[] objArr179 = new Object[1];
        a(cKeyCodeFromString2, i750, i752, objArr179);
        String str84 = (String) objArr179[0];
        char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
        int i753 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
        Object[] objArr180 = new Object[1];
        a(cMakeMeasureSpec2, ((i753 | 1121) << 1) - (i753 ^ 1121), Color.argb(0, 0, 0, 0) + 5, objArr180);
        String[] strArr25 = {str84, (String) objArr180[0]};
        char minimumFlingVelocity4 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
        int i754 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
        Object[] objArr181 = new Object[1];
        a(minimumFlingVelocity4, (i754 & 1126) + (i754 | 1126), 18 - (~(-(-(ViewConfiguration.getLongPressTimeout() >> 16)))), objArr181);
        String[] strArr26 = {(String) objArr181[0]};
        char c27 = (char) ((-2) - (~(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
        int i755 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
        Object[] objArr182 = new Object[1];
        a(c27, (i755 ^ 1145) + ((i755 & 1145) << 1), 16 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr182);
        String[] strArr27 = {(String) objArr182[0]};
        Object[] objArr183 = new Object[1];
        a((char) (ViewConfiguration.getScrollBarSize() >> 8), 1161 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 19 - Gravity.getAbsoluteGravity(0, 0), objArr183);
        String[] strArr28 = {(String) objArr183[0]};
        int keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
        int i756 = 1179 - (~(ViewConfiguration.getMaximumFlingVelocity() >> 16));
        int i757 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
        int iComponent16 = br.AnonymousClass2.component9();
        int i758 = i757 * (-244);
        int i759 = ((i758 | 4920) << 1) - (i758 ^ 4920);
        int i760 = ~iComponent16;
        int i761 = ~((i760 & (-21)) | ((-21) ^ i760));
        int i762 = ~(((-21) ^ i757) | ((-21) & i757));
        int i763 = ((i761 & i762) | (i761 ^ i762)) * (-245);
        int i764 = (i759 ^ i763) + ((i763 & i759) << 1) + ((~(((-21) ^ iComponent16) | ((-21) & iComponent16))) * (-245));
        int i765 = (i757 | (~((iComponent16 & (-21)) | ((-21) ^ iComponent16)))) * 245;
        int i766 = ((i764 | i765) << 1) - (i765 ^ i764);
        Object[] objArr184 = new Object[1];
        a((char) ((keyRepeatTimeout2 ^ 31149) + ((keyRepeatTimeout2 & 31149) << 1)), i756, i766, objArr184);
        String[] strArr29 = {(String) objArr184[0]};
        char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
        int i767 = 1199 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
        int trimmedLength = TextUtils.getTrimmedLength("");
        int i768 = ((trimmedLength | 23) << 1) - (trimmedLength ^ 23);
        Object[] objArr185 = new Object[1];
        a(cResolveSizeAndState, i767, i768, objArr185);
        String[] strArr30 = {(String) objArr185[0]};
        char c28 = (char) ((-2) - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
        int i769 = -View.resolveSizeAndState(0, 0, 0);
        Object[] objArr186 = new Object[1];
        a(c28, ((i769 | 1222) << 1) - (i769 ^ 1222), 20 - (~(KeyEvent.getMaxKeyCode() >> 16)), objArr186);
        String[] strArr31 = {(String) objArr186[0]};
        int iResolveSize2 = View.resolveSize(0, 0);
        int i770 = -ExpandableListView.getPackedPositionType(0L);
        int iComponent17 = br.AnonymousClass2.component9();
        int i771 = i770 * 491;
        int i772 = (((-607827) | i771) << 1) - (i771 ^ (-607827));
        int i773 = ~i770;
        int i774 = (i773 ^ (-1244)) | (i773 & (-1244));
        int i775 = ~iComponent17;
        int i776 = (i772 - (~(((i774 & i775) | (i774 ^ i775)) * (-490)))) - 1;
        int i777 = ~(i770 | (-1244));
        int i778 = ~((iComponent17 & (-1244)) | ((-1244) ^ iComponent17));
        int i779 = i776 + (((i777 & i778) | (i777 ^ i778)) * 490);
        int i780 = i773 * 490;
        int i781 = (i779 & i780) + (i779 | i780);
        int i782 = -Gravity.getAbsoluteGravity(0, 0);
        int i783 = (i782 ^ 24) + ((i782 & 24) << 1);
        Object[] objArr187 = new Object[1];
        a((char) ((55316 & iResolveSize2) + (iResolveSize2 | 55316)), i781, i783, objArr187);
        String[] strArr32 = {(String) objArr187[0], str};
        int i784 = -(-TextUtils.lastIndexOf("", '0', 0));
        int i785 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        Object[] objArr188 = new Object[1];
        a((char) ((i784 & 1) + (i784 | 1)), ((i785 | 1268) << 1) - (i785 ^ 1268), TextUtils.lastIndexOf("", '0', 0, 0) + 29, objArr188);
        String[] strArr33 = {(String) objArr188[0], str};
        int i786 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
        int i787 = 1294 - (~(-Color.red(0)));
        int iIndexOf8 = TextUtils.indexOf("", "");
        int i788 = (iIndexOf8 ^ 27) + ((iIndexOf8 & 27) << 1);
        Object[] objArr189 = new Object[1];
        a((char) ((i786 ^ 30124) + ((i786 & 30124) << 1)), i787, i788, objArr189);
        String[] strArr34 = {(String) objArr189[0], str};
        char cNormalizeMetaState5 = (char) KeyEvent.normalizeMetaState(0);
        int i789 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
        Object[] objArr190 = new Object[1];
        a(cNormalizeMetaState5, ((i789 | 1323) << 1) - (i789 ^ 1323), 30 - (~(-(-(ViewConfiguration.getJumpTapTimeout() >> 16)))), objArr190);
        String[] strArr35 = {(String) objArr190[0], str};
        char cMyPid2 = (char) (Process.myPid() >> 22);
        int i790 = -Gravity.getAbsoluteGravity(0, 0);
        Object[] objArr191 = new Object[1];
        a(cMyPid2, (i790 ^ 1353) + ((i790 & 1353) << 1), 26 - TextUtils.indexOf((CharSequence) "", '0'), objArr191);
        String[] strArr36 = {(String) objArr191[0], str};
        Object[] objArr192 = new Object[1];
        a((char) (ViewConfiguration.getPressedStateDuration() >> 16), Color.rgb(0, 0, 0) + 16778596, 31 - TextUtils.lastIndexOf("", '0', 0, 0), objArr192);
        String[][] strArr37 = {strArr14, strArr15, strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, strArr30, strArr31, strArr32, strArr33, strArr34, strArr35, strArr36, new String[]{(String) objArr192[0], str}};
        ArrayList arrayList = new ArrayList();
        int i791 = 0;
        int i792 = 0;
        int i793 = iIntValue;
        while (i791 < 24) {
            int i794 = component8;
            int i795 = (i794 ^ 87) + ((i794 & 87) << i41);
            setTopP6481 = i795 % 128;
            int i796 = i795 % 2;
            String[] strArr38 = strArr37[i791];
            Object[] objArr193 = {strArr38[b]};
            Object objComponent28 = setSystemGestureExclusionRectsL30479.component5(1828795215);
            if (objComponent28 == null) {
                int jumpTapTimeout5 = 52 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char c29 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int iKeyCodeFromString4 = 6473 - KeyEvent.keyCodeFromString("");
                Object[] objArr194 = new Object[i41];
                b(i41, -1, b, objArr194);
                objComponent28 = setSystemGestureExclusionRectsL30479.vD14832N6715(jumpTapTimeout5, c29, iKeyCodeFromString4, 1068791596, false, (String) objArr194[b], new Class[]{String.class});
            }
            String str85 = (String) ((Method) objComponent28).invoke(null, objArr193);
            String[] strArr39 = (String[]) Arrays.copyOfRange(strArr38, i41, strArr38.length);
            if (str85 != null && str85.length() != 0) {
                if (strArr38.length != i41) {
                    int iComponent18 = br.AnonymousClass2.component9();
                    int i797 = ~(((-1064039205) ^ iComponent18) | ((-1064039205) & iComponent18));
                    int i798 = -(-((((-628106475) ^ i797) | (i797 & (-628106475))) * 191));
                    int i799 = (944049001 & i798) + (i798 | 944049001);
                    int i800 = ~iComponent18;
                    int i801 = ~((i800 & (-1064039205)) | (i800 ^ (-1064039205)));
                    int i802 = ((i801 & 436982532) | (436982532 ^ i801)) * 191;
                    int i803 = (i799 & i802) + (i799 | i802);
                    int i804 = ((~((-1152387073) | i17)) | 302289981) * (-591);
                    int i805 = (1570776804 ^ i804) + ((i804 & 1570776804) << i41);
                    int i806 = 978188285 | iIntValue;
                    int i807 = -(-(((i806 ^ (-1828285377)) | (i806 & (-1828285377))) * 591));
                    if (i803 > (i805 ^ i807) + ((i807 & i805) << i41)) {
                        Object[] objArr195 = new Object[2];
                        objArr195[i41] = strArr39;
                        objArr195[b] = str85;
                        Object objComponent29 = setSystemGestureExclusionRectsL30479.component5(-1259183077);
                        if (objComponent29 == null) {
                            int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 52;
                            char cLastIndexOf4 = (char) (TextUtils.lastIndexOf("", '0') + 4309);
                            int minimumFlingVelocity5 = 5749 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            Object[] objArr196 = new Object[i41];
                            b(b, -1, (byte) 2, objArr196);
                            objComponent29 = setSystemGestureExclusionRectsL30479.vD14832N6715(modifierMetaStateMask2, cLastIndexOf4, minimumFlingVelocity5, -431546248, false, (String) objArr196[b], new Class[]{String.class, String[].class});
                        }
                        long jLongValue18 = ((Long) ((Method) objComponent29).invoke(null, objArr195)).longValue();
                        long j55 = (-109813083176L) + ((-344) * jLongValue18);
                        long j56 = jLongValue18 ^ (-1);
                        long j57 = (-319224080) | j56;
                        long jMyUid = Process.myUid();
                        long j58 = j55 + (((j57 ^ (-1)) | (((-319224080) | jMyUid) ^ (-1))) * 345) + (((((-319224080) | (jMyUid ^ (-1))) ^ (-1)) | ((j56 | 319224079) ^ (-1))) * 345) + (345 * ((j57 | jMyUid) ^ (-1))) + 1482771623;
                        int elapsedCpuTime8 = (int) Process.getElapsedCpuTime();
                        int i808 = (~(675725924 | elapsedCpuTime8)) | 1437669387;
                        int i809 = ~elapsedCpuTime8;
                        int i810 = ((int) (j58 << 117)) & (2069997324 + ((i808 | (~(i809 | (-442977)))) * 886) + ((2112952335 | (~(i809 | (-675725925)))) * (-1772)) + ((~(i809 | 2112952335)) * 886));
                        int i811 = ~((~Process.myUid()) | 810953521);
                        int i812 = ((int) j58) & ((((17 | i811) * (-970)) - 2083093633) + ((i811 | 810953504) * 970));
                        if (((i810 & i812) | (i810 ^ i812)) != 0) {
                            i792++;
                            int i813 = i791 + 10;
                            i793 = (~(iIntValue & i813)) & (i813 | iIntValue);
                            StringBuilder sb = new StringBuilder();
                            sb.append(str85);
                            char c30 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i814 = -TextUtils.indexOf("", "");
                            Object[] objArr197 = new Object[1];
                            a(c30, (i814 & 1412) + (i814 | 1412), -ExpandableListView.getPackedPositionChild(0L), objArr197);
                            sb.append((String) objArr197[0]);
                            sb.append(str85);
                            arrayList.add(sb.toString());
                        }
                    } else {
                        byte b2 = b;
                        int i815 = i41;
                        Object[] objArr198 = new Object[2];
                        objArr198[i815] = strArr39;
                        objArr198[b2] = str85;
                        Object objComponent30 = setSystemGestureExclusionRectsL30479.component5(-1259183077);
                        if (objComponent30 == null) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(b2, b2) + 51;
                            char cIndexOf4 = (char) (TextUtils.indexOf((CharSequence) "", '0', (int) b2) + 4309);
                            int i816 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 5749;
                            Object[] objArr199 = new Object[i815];
                            b(0, -1, (byte) 2, objArr199);
                            objComponent30 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMakeMeasureSpec, cIndexOf4, i816, -431546248, false, (String) objArr199[0], new Class[]{String.class, String[].class});
                        }
                        long jLongValue19 = ((Long) ((Method) objComponent30).invoke(null, objArr198)).longValue();
                        long jMyUid2 = Process.myUid();
                        long j59 = (-290725791) | jLongValue19;
                        long j60 = jMyUid2 ^ (-1);
                        long j61 = 40992336390L + ((-279) * jLongValue19) + ((jLongValue19 | jMyUid2) * 140) + ((-280) * ((j59 ^ (-1)) | ((j60 | jLongValue19) ^ (-1)))) + (140 * ((((jLongValue19 ^ (-1)) | 290725790) ^ (-1)) | ((j60 | 290725790) ^ (-1)) | ((j59 | jMyUid2) ^ (-1)))) + 1511269912;
                        int iMaxMemory3 = (int) Runtime.getRuntime().maxMemory();
                        int i817 = ((int) (j61 >> 32)) & (((~((-1141901315) | iMaxMemory3)) * 521) + 1253358328 + (((~((~iMaxMemory3) | (-1141901315))) | 4325792) * 521));
                        int iMyUid = Process.myUid();
                        int i818 = ((int) j61) & (((286216179 + ((996655103 | (~iMyUid)) * (-490))) + (((~(iMyUid | 457414638)) | 539240465) * 490)) - 928569362);
                        if (((i817 & i818) | (i817 ^ i818)) != 0) {
                            i792++;
                            int i819 = i791 + 10;
                            i793 = (~(iIntValue & i819)) & (i819 | iIntValue);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str85);
                            char c31 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i8110 = -TextUtils.indexOf("", "");
                            Object[] objArr1910 = new Object[1];
                            a(c31, (i8110 & 1412) + (i8110 | 1412), -ExpandableListView.getPackedPositionChild(0L), objArr1910);
                            sb2.append((String) objArr1910[0]);
                            sb2.append(str85);
                            arrayList.add(sb2.toString());
                        }
                    }
                } else {
                    i792++;
                    int i8111 = i791 + 10;
                    i793 = (~(iIntValue & i8111)) & (i8111 | iIntValue);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str85);
                    char c32 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i8112 = -TextUtils.indexOf("", "");
                    Object[] objArr1911 = new Object[1];
                    a(c32, (i8112 & 1412) + (i8112 | 1412), -ExpandableListView.getPackedPositionChild(0L), objArr1911);
                    sb3.append((String) objArr1911[0]);
                    sb3.append(str85);
                    arrayList.add(sb3.toString());
                }
            }
            i791++;
            i667 = i667;
            strArr37 = strArr37;
            b = 0;
            i41 = 1;
        }
        i18 = i667;
        if (i792 > 2) {
            int i820 = component8;
            int i821 = (i820 ^ 117) + ((i820 & 117) << 1);
            setTopP6481 = i821 % 128;
            int i822 = i821 % 2;
            objArr2 = new Object[5];
            objArr2[0] = new int[]{iIntValue};
            objArr2[1] = new int[]{i793};
            objArr2[4] = new int[1];
            objArr2[2] = arrayList;
            objArr2[i3] = null;
            int iMyUid2 = Process.myUid();
            int i823 = ~iMyUid2;
            int i824 = (-107569450) + (((~((-10519682) | i823)) | (~(283676401 | iMyUid2))) * 520);
            int i825 = ~((-283676402) | i823);
            int i826 = ~(iMyUid2 | 632546437);
            int i827 = i824 + ((i825 | i826) * (-1040)) + ((i826 | (~(i823 | (-632546438))) | 273156720) * 520);
            int i828 = -(-((i827 << 1) - i827));
            int i829 = i828 ^ (i828 << 13);
            int i830 = i829 >>> 17;
            int i831 = ((~i829) & i830) | ((~i830) & i829);
            int i832 = i831 << 5;
            i19 = 0;
            ((int[]) objArr2[4])[0] = (i831 | i832) & (~(i831 & i832));
        } else {
            objArr2 = new Object[5];
            objArr2[0] = new int[]{iIntValue};
            objArr2[1] = new int[]{iIntValue};
            objArr2[4] = new int[1];
            objArr2[2] = null;
            objArr2[i3] = null;
            int iElapsedRealtime6 = (int) SystemClock.elapsedRealtime();
            int i833 = 1191314798 + (((~(iElapsedRealtime6 | 674232014)) | (-779091695)) * 305) + (((~((~iElapsedRealtime6) | 674232014)) | (-241990825)) * 305);
            int i834 = (i833 << 1) - i833;
            int i835 = i834 << 13;
            int i836 = (i834 | i835) & (~(i834 & i835));
            int i837 = i836 >>> 17;
            int i838 = ((~i836) & i837) | ((~i837) & i836);
            i19 = 0;
            ((int[]) objArr2[4])[0] = i838 ^ (i838 << 5);
        }
        int i839 = ((int[]) objArr2[1])[i19];
        if (i839 != iIntValue) {
            Object[] objArr200 = new Object[5];
            int[] iArr = new int[1];
            objArr200[i19] = iArr;
            int[] iArr2 = new int[1];
            objArr200[1] = iArr2;
            objArr200[4] = new int[1];
            List list = (List) objArr2[2];
            iArr[i19] = iIntValue;
            iArr2[i19] = i839;
            objArr200[2] = list;
            objArr200[i3] = null;
            int iMyUid3 = Process.myUid();
            int i840 = (iIntValue2 - (~(-(-(((((-674236874) + (((~((-139233282) | (~iMyUid3))) | (~(776989557 | iMyUid3))) * (-272))) + (((~((-676252274) | iMyUid3)) | 537018992) * (-272))) + (((~(iMyUid3 | 676252273)) | 239970565) * 272)) + 16))))) - 1;
            int i841 = i840 << 13;
            int i842 = (i841 | i840) & (~(i840 & i841));
            int i843 = i842 >>> 17;
            int i844 = ((~i842) & i843) | ((~i843) & i842);
            int i845 = i844 << 5;
            ((int[]) objArr200[4])[0] = ((~i844) & i845) | ((~i845) & i844);
            return objArr200;
        }
        char cNormalizeMetaState6 = (char) KeyEvent.normalizeMetaState(i19);
        int i3610 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        int i3611 = ((i3610 | 699) << 1) - (i3610 ^ 699);
        int threadPriority5 = Process.getThreadPriority(i19);
        int i3612 = -((((threadPriority5 | 20) << 1) - (threadPriority5 ^ 20)) >> 6);
        int i3613 = ((i3612 | 16) << 1) - (i3612 ^ 16);
        Object[] objArr810 = new Object[1];
        a(cNormalizeMetaState6, i3611, i3613, objArr810);
        Object[] objArr811 = {(String) objArr810[0]};
        objComponent6 = setSystemGestureExclusionRectsL30479.component5(1828795215);
        if (objComponent6 == null) {
            int i3614 = 53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            char cAlpha4 = (char) Color.alpha(0);
            int iBlue3 = Color.blue(0) + 6473;
            Object[] objArr812 = new Object[1];
            b(1, -1, (byte) 0, objArr812);
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(i3614, cAlpha4, iBlue3, 1068791596, false, (String) objArr812[0], new Class[]{String.class});
        }
        objInvoke = ((Method) objComponent6).invoke(null, objArr811);
        if (objInvoke == null) {
            i20 = 0;
        } else {
            Object[] objArr813 = {objInvoke, 42};
            objComponent7 = setSystemGestureExclusionRectsL30479.component5(585894966);
            if (objComponent7 == null) {
                int tapTimeout4 = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                char offsetBefore5 = (char) TextUtils.getOffsetBefore("", 0);
                int maximumDrawingCacheSize4 = 5420 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                Object[] objArr814 = new Object[1];
                b(0, -1, (byte) 2, objArr814);
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout4, offsetBefore5, maximumDrawingCacheSize4, 1884899413, false, (String) objArr814[0], new Class[]{String.class, Integer.TYPE});
            }
            long jLongValue110 = ((Long) ((Method) objComponent7).invoke(null, objArr813)).longValue();
            long j310 = 171021946 | jLongValue110;
            long jElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
            long j311 = (-129121569985L) + ((-753) * jLongValue110) + (((j310 ^ (-1)) | ((171021946 | jElapsedRealtime3) ^ (-1)) | ((jLongValue110 | jElapsedRealtime3) ^ (-1))) * (-754));
            long j312 = (j310 | jElapsedRealtime3) ^ (-1);
            long j313 = jElapsedRealtime3 ^ (-1);
            long j314 = j311 + ((-754) * (((jLongValue110 | ((-171021947) | j313)) ^ (-1)) | j312)) + (754 * (171021946 | j313)) + 678175060;
            int iNextInt13 = new Random().nextInt(1411030631);
            int i3615 = ~iNextInt13;
            int i3616 = 1905160562 + (((~(761006423 | i3615)) | (-2113776128) | (~(2096734461 | i3615)) | (~((-743964758) | iNextInt13))) * (-84));
            int i3617 = (~(iNextInt13 | 2096734461)) | (-761006424);
            int i3618 = ~(i3615 | (-2096734462));
            int i3710 = ((int) (j314 >> 32)) & (i3616 + ((i3617 | i3618) * (-84)) + ((743964757 | i3618) * 84));
            int iElapsedRealtime7 = (int) SystemClock.elapsedRealtime();
            int i3711 = ((int) j314) & (((((~(880309427 | iElapsedRealtime7)) | 16875588) * (-283)) - 956402303) + ((~(iElapsedRealtime7 | 897185015)) * 283));
            i20 = (i3710 & i3711) | (i3710 ^ i3711);
        }
        if (i20 != 1986687685) {
            int i3712 = component8 + 35;
            setTopP6481 = i3712 % 128;
            int i3713 = i3712 % 2;
            char cIndexOf5 = (char) (61203 - TextUtils.indexOf((CharSequence) "", '0'));
            int i3714 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1413;
            int i3715 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            int i3716 = (i3715 ^ 14) + ((i3715 & 14) << 1);
            Object[] objArr910 = new Object[1];
            a(cIndexOf5, i3714, i3716, objArr910);
            String str210 = (String) objArr910[0];
            char jumpTapTimeout6 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int capsMode4 = 1427 - TextUtils.getCapsMode("", 0, 0);
            int i3717 = -View.combineMeasuredStates(0, 0);
            int i3718 = (i3717 & 26) + (i3717 | 26);
            Object[] objArr911 = new Object[1];
            a(jumpTapTimeout6, capsMode4, i3718, objArr911);
            String str310 = (String) objArr911[0];
            char c110 = (char) ((-16777217) - (~(-Color.rgb(0, 0, 0))));
            int i3719 = -TextUtils.indexOf((CharSequence) "", '0');
            Object[] objArr912 = new Object[1];
            a(c110, ((i3719 | 1452) << 1) - (i3719 ^ 1452), 17 - TextUtils.indexOf("", "", 0), objArr912);
            String str311 = (String) objArr912[0];
            int i3810 = -(ViewConfiguration.getEdgeSlop() >> 16);
            int i3811 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
            Object[] objArr913 = new Object[1];
            a((char) (((i3810 | 33403) << 1) - (i3810 ^ 33403)), ((i3811 | 1470) << 1) - (i3811 ^ 1470), 17 - ((Process.getThreadPriority(0) + 20) >> 6), objArr913);
            String str312 = (String) objArr913[0];
            int i3812 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
            int i3813 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            int i3814 = (i3813 ^ 1488) + ((i3813 & 1488) << 1);
            int i3815 = -(Process.myPid() >> 22);
            int i3816 = ((i3815 | 15) << 1) - (i3815 ^ 15);
            Object[] objArr914 = new Object[1];
            a((char) ((i3812 ^ 23386) + ((i3812 & 23386) << 1)), i3814, i3816, objArr914);
            String str313 = (String) objArr914[0];
            int i3817 = -Process.getGidForName("");
            int i3818 = -(-Color.rgb(0, 0, 0));
            int i3819 = ((i3818 | 16778718) << 1) - (i3818 ^ 16778718);
            int i3910 = -TextUtils.indexOf((CharSequence) "", '0', 0);
            int i3911 = i3910 * (-419);
            int i3912 = (((i3911 & 15156) + (i3911 | 15156)) - (~((~((iIntValue ^ 36) | (iIntValue & 36))) * 420))) - 1;
            int i3913 = ((~i3910) | 36) * (-420);
            int i3914 = (i3912 & i3913) + (i3913 | i3912);
            int i3915 = ~((~i3910) | (-37));
            int i3916 = ~((i18 ^ 36) | (i18 & 36));
            int i3917 = (i3914 - (~(((i3915 & i3916) | (i3915 ^ i3916)) * 420))) - 1;
            Object[] objArr915 = new Object[1];
            a((char) ((i3817 ^ 20880) + ((i3817 & 20880) << 1)), i3819, i3917, objArr915);
            String str314 = (String) objArr915[0];
            char c111 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
            int i3918 = -KeyEvent.normalizeMetaState(0);
            int i3919 = ((i3918 | 1539) << 1) - (i3918 ^ 1539);
            int i4010 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            int i4011 = ((i4010 | 13) << 1) - (i4010 ^ 13);
            Object[] objArr916 = new Object[1];
            a(c111, i3919, i4011, objArr916);
            String str315 = (String) objArr916[0];
            char cMyTid3 = (char) (14021 - (Process.myTid() >> 22));
            int minimumFlingVelocity6 = ViewConfiguration.getMinimumFlingVelocity() >> 16;
            int i4012 = (minimumFlingVelocity6 & 1551) + (minimumFlingVelocity6 | 1551);
            int i4013 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int i4014 = (i4013 & 12) + (i4013 | 12);
            Object[] objArr917 = new Object[1];
            a(cMyTid3, i4012, i4014, objArr917);
            String str316 = (String) objArr917[0];
            char longPressTimeout5 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 28772);
            int i4015 = -(ViewConfiguration.getEdgeSlop() >> 16);
            int iComponent19 = br.AnonymousClass2.component9();
            int i4016 = (i4015 * (-518)) - 810152;
            int i4017 = ~i4015;
            int i4018 = ~((~iComponent19) | i4017);
            int i4019 = -(-(((i4018 & 1564) | (i4018 ^ 1564)) * 519));
            int i4110 = (i4016 ^ i4019) + ((i4016 & i4019) << 1);
            int i4111 = (~iComponent19) | i4017;
            int i4112 = (i4015 ^ 1564) | (i4015 & 1564);
            int i4113 = -(-(((~((i4111 & 1564) | (i4111 ^ 1564))) | (~((i4112 & iComponent19) | (i4112 ^ iComponent19)))) * (-519)));
            int i4114 = ~((iComponent19 & 1564) | (iComponent19 ^ 1564));
            int i4115 = (((i4110 ^ i4113) + ((i4113 & i4110) << 1)) - (~(-(-(((i4015 & i4114) | (i4015 ^ i4114)) * 519))))) - 1;
            int i4116 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int i4117 = (i4116 & 21) + (i4116 | 21);
            Object[] objArr918 = new Object[1];
            a(longPressTimeout5, i4115, i4117, objArr918);
            String str317 = (String) objArr918[0];
            Object[] objArr919 = new Object[1];
            a((char) ((-TextUtils.lastIndexOf("", '0')) - 1), 1586 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 31, objArr919);
            String str318 = (String) objArr919[0];
            int i4118 = -(ViewConfiguration.getScrollBarSize() >> 8);
            int i4119 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int i4210 = (i4119 ^ 1617) + ((i4119 & 1617) << 1);
            int keyRepeatTimeout3 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
            int i4211 = (keyRepeatTimeout3 & 12) + (keyRepeatTimeout3 | 12);
            Object[] objArr1010 = new Object[1];
            a((char) ((i4118 ^ 45406) + ((i4118 & 45406) << 1)), i4210, i4211, objArr1010);
            String str319 = (String) objArr1010[0];
            int i4212 = -AndroidCharacter.getMirror('0');
            int i4213 = -(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int i4214 = (i4213 ^ 1628) + ((i4213 & 1628) << 1);
            int i4215 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
            int i4216 = (i4215 & 12) + (i4215 | 12);
            Object[] objArr1011 = new Object[1];
            a((char) ((i4212 ^ 60306) + ((i4212 & 60306) << 1)), i4214, i4216, objArr1011);
            String str410 = (String) objArr1011[0];
            char c112 = (char) (12257 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
            int iKeyCodeFromString5 = KeyEvent.keyCodeFromString("");
            int i4217 = ((iKeyCodeFromString5 | 1641) << 1) - (iKeyCodeFromString5 ^ 1641);
            int i4218 = -View.resolveSizeAndState(0, 0, 0);
            int i4219 = (i4218 ^ 12) + ((i4218 & 12) << 1);
            Object[] objArr1012 = new Object[1];
            a(c112, i4217, i4219, objArr1012);
            String str411 = (String) objArr1012[0];
            int i4310 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int i4311 = -(-(ViewConfiguration.getTapTimeout() >> 16));
            Object[] objArr1013 = new Object[1];
            a((char) (((i4310 | 5227) << 1) - (i4310 ^ 5227)), (i4311 ^ 1653) + ((i4311 & 1653) << 1), 11 - (~(-(-(ViewConfiguration.getPressedStateDuration() >> 16)))), objArr1013);
            String str412 = (String) objArr1013[0];
            char cNormalizeMetaState7 = (char) KeyEvent.normalizeMetaState(0);
            int i4312 = -TextUtils.indexOf((CharSequence) "", '0');
            Object[] objArr1014 = new Object[1];
            a(cNormalizeMetaState7, ((i4312 | 1664) << 1) - (i4312 ^ 1664), Color.red(0) + 12, objArr1014);
            String str413 = (String) objArr1014[0];
            char cBlue4 = (char) Color.blue(0);
            int i4313 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
            int i4314 = (i4313 & 1678) + (i4313 | 1678);
            int i4315 = -(Process.myPid() >> 22);
            int i4316 = (i4315 ^ 14) + ((i4315 & 14) << 1);
            Object[] objArr1015 = new Object[1];
            a(cBlue4, i4314, i4316, objArr1015);
            String str414 = (String) objArr1015[0];
            char pressedStateDuration3 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 64674);
            int i4317 = 1690 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16)));
            int i4318 = -TextUtils.lastIndexOf("", '0');
            int i4319 = (i4318 ^ 11) + ((i4318 & 11) << 1);
            Object[] objArr1016 = new Object[1];
            a(pressedStateDuration3, i4317, i4319, objArr1016);
            String str415 = (String) objArr1016[0];
            Object[] objArr1017 = new Object[1];
            a((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1702 - (~(ViewConfiguration.getScrollBarSize() >> 8)), 23 - (~(ViewConfiguration.getJumpTapTimeout() >> 16)), objArr1017);
            String str416 = (String) objArr1017[0];
            char capsMode5 = (char) (TextUtils.getCapsMode("", 0, 0) + 27190);
            int i4410 = -(-ExpandableListView.getPackedPositionType(0L));
            int i4411 = (i4410 ^ 1727) + ((i4410 & 1727) << 1);
            int i4412 = -TextUtils.lastIndexOf("", '0');
            int iComponent110 = br.AnonymousClass2.component9();
            int i4413 = (i4412 * (-1335)) - 18009;
            int i4414 = (i4412 ^ iComponent110) | (i4412 & iComponent110);
            int i4415 = ~i4414;
            int i4416 = -(-(((i4415 & (-28)) | ((-28) ^ i4415)) * (-668)));
            int i4417 = ~(iComponent110 | (-28));
            int i4418 = ((((i4413 & i4416) + (i4413 | i4416)) + (((i4412 & i4417) | (i4412 ^ i4417)) * 1336)) - (~(-(-(((i4414 ^ (-28)) | (i4414 & (-28))) * 668))))) - 1;
            Object[] objArr1018 = new Object[1];
            a(capsMode5, i4411, i4418, objArr1018);
            strArr3 = new String[]{str210, str310, str311, str312, str313, str314, str315, str316, str317, str318, str319, str410, str411, str412, str413, str414, str415, str416, (String) objArr1018[0]};
            i34 = 0;
            while (true) {
                if (i34 < 19) {
                    i34 = -1;
                    break;
                }
                str3 = strArr3[i34];
                Object[] objArr1019 = {str3};
                objComponent11 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                if (objComponent11 == null) {
                    int doubleTapTimeout6 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 52;
                    char c113 = (char) (59725 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int iLastIndexOf7 = TextUtils.lastIndexOf("", '0', 0) + 6318;
                    Object[] objArr1110 = new Object[1];
                    b(1, -1, (byte) 1, objArr1110);
                    objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout6, c113, iLastIndexOf7, 369154319, false, (String) objArr1110[0], new Class[]{String.class});
                }
                long jLongValue111 = ((Long) ((Method) objComponent11).invoke(null, objArr1019)).longValue();
                long jUptimeMillis3 = (int) SystemClock.uptimeMillis();
                long j315 = (((445840554818L + (530 * jLongValue111)) + (((((jUptimeMillis3 ^ (-1)) | 841208592) ^ (-1)) | ((841208592 | jLongValue111) ^ (-1))) * 529)) + (529 * ((jLongValue111 ^ (-1)) | ((841208592 | jUptimeMillis3) ^ (-1))))) - 1815710477;
                int iFreeMemory4 = (int) Runtime.getRuntime().freeMemory();
                i36 = ((int) (j315 >> 32)) & ((((-1544080518) + (((~((-1362645048) | iFreeMemory4)) | (-74581364)) * (-948))) + ((~((~iFreeMemory4) | (-3145780))) * (-948))) - 315118212);
                int i4419 = ~((int) Runtime.getRuntime().maxMemory());
                i37 = ((int) j315) & (1104509201 + ((~(1472194901 | i4419)) * 52) + (((~(1404430677 | i4419)) | (~((-1453310209) | i4419)) | 67764224) * (-52)) + (((~(i4419 | (-1404430678))) | 18884693) * 52));
                if (((i36 & i37) | (i36 ^ i37)) != 0) {
                    break;
                    break;
                }
                char c114 = (char) ((-2) - (~(-(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))));
                int i4510 = -MotionEvent.axisFromString("");
                int i4511 = (i4510 & 1676) + (i4510 | 1676);
                int i4512 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iComponent111 = br.AnonymousClass2.component9();
                int i4513 = i4512 * 503;
                int i4514 = (i4513 ^ 7042) + ((i4513 & 7042) << 1);
                int i4515 = (i4512 ^ 14) | (i4512 & 14);
                int i4516 = -(-(i4515 * (-502)));
                int i4517 = (i4514 & i4516) + (i4514 | i4516);
                int i4518 = ~i4512;
                int i4519 = ~((i4518 & (-15)) | (i4518 ^ (-15)));
                int i4610 = ~i4512;
                int i4611 = ~iComponent111;
                int i4612 = ~((i4611 & i4610) | (i4610 ^ i4611));
                int i4613 = (i4519 & i4612) | (i4519 ^ i4612);
                int i4614 = ~((i4515 ^ iComponent111) | (i4515 & iComponent111));
                int i4615 = -(-(((i4613 & i4614) | (i4613 ^ i4614)) * (-502)));
                int i4616 = i4610 | (~iComponent111);
                int i4617 = ~((i4616 & 14) | (i4616 ^ 14));
                int i4618 = ~(iComponent111 | i4515);
                int i4619 = (((i4517 ^ i4615) + ((i4615 & i4517) << 1)) - (~(-(-(((i4617 & i4618) | (i4617 ^ i4618)) * 502))))) - 1;
                objArr3 = new Object[1];
                a(c114, i4511, i4619, objArr3);
                if (str3.equals((String) objArr3[0])) {
                    Object[] objArr1111 = {str3};
                    objComponent12 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent12 == null) {
                        int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + 53;
                        char cLastIndexOf5 = (char) (TextUtils.lastIndexOf("", '0', 0) + 59726);
                        int i4710 = 6318 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        Object[] objArr1112 = new Object[1];
                        b(1, -1, (byte) 1, objArr1112);
                        objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(modifierMetaStateMask3, cLastIndexOf5, i4710, 369154319, false, (String) objArr1112[0], new Class[]{String.class});
                    }
                    long jLongValue112 = ((Long) ((Method) objComponent12).invoke(null, objArr1111)).longValue();
                    long j410 = (-77297480) | jLongValue112;
                    long j411 = (-38880632440L) + (503 * jLongValue112) + ((-502) * j410);
                    long jNextInt5 = new Random().nextInt(142948238);
                    long j412 = 77297479 | (jNextInt5 ^ (-1));
                    long j413 = (j410 | jNextInt5) ^ (-1);
                    long j414 = ((j411 + (((((77297479 | (jLongValue112 ^ (-1))) ^ (-1)) | (j412 ^ (-1))) | j413) * (-502))) + (502 * (((j412 | jLongValue112) ^ (-1)) | j413))) - 897204405;
                    int iElapsedRealtime8 = (int) SystemClock.elapsedRealtime();
                    i38 = ((int) (j414 >> 32)) & (1743401832 + ((~((~iElapsedRealtime8) | (-173016323))) * 433) + (((~(441567131 | iElapsedRealtime8)) | (-1878793543)) * (-433)) + (((~(iElapsedRealtime8 | (-1878793543))) | 268550809) * 433));
                    int iUptimeMillis8 = (int) SystemClock.uptimeMillis();
                    i39 = ((int) j414) & (((818885255 + (((~iUptimeMillis8) | (-1029696766)) * 1324)) + (((~(iUptimeMillis8 | (-1029696765))) | (~((-407529646) | iUptimeMillis8))) * (-1324))) - 442226314);
                    if (((i38 & i39) | (i38 ^ i39)) != 0) {
                        int i4711 = component8;
                        i40 = (i4711 ^ GapComposerKt.nodeKey) + ((i4711 & GapComposerKt.nodeKey) << 1);
                        setTopP6481 = i40 % 128;
                        if (i40 % 2 == 0) {
                            break;
                        }
                        Object obj5 = null;
                        obj5.hashCode();
                        throw null;
                    }
                }
                i34 = (i34 ^ 1) + ((i34 & 1) << 1);
            }
            if (i34 >= 0) {
                Object[] objArr1113 = new Object[5];
                objArr1113[0] = new int[]{iIntValue};
                objArr1113[1] = new int[]{i35};
                objArr1113[4] = new int[1];
                objArr1113[2] = null;
                objArr1113[i3] = null;
                int elapsedCpuTime9 = (int) Process.getElapsedCpuTime();
                int i4712 = ~elapsedCpuTime9;
                int i4713 = (iIntValue2 - (~((((190790502 + (((~(911313300 | i4712)) | 680034) * 184)) + ((elapsedCpuTime9 | 907083796) * (-184))) + ((~((-4909539) | i4712)) * 184)) + 16))) - 1;
                int i4714 = i4713 << 13;
                int i4715 = (i4714 | i4713) & (~(i4713 & i4714));
                int i4716 = i4715 ^ (i4715 >>> 17);
                int i4717 = i4716 << 5;
                ((int[]) objArr1113[4])[0] = ((~i4716) & i4717) | ((~i4717) & i4716);
                return objArr1113;
            }
        }
        int i4718 = -KeyEvent.getDeadChar(0, 0);
        int i4719 = i4718 * (-519);
        int i4810 = ((i4719 | 17898955) << 1) - (i4719 ^ 17898955);
        int i4811 = ~i4718;
        int i4812 = ~(((-34356) & i4811) | (i4811 ^ (-34356)) | i18);
        int i4813 = ~((34355 & iIntValue) | (iIntValue ^ 34355));
        int i4814 = ((i4812 & i4813) | (i4812 ^ i4813)) * 520;
        int i4815 = ((i4810 | i4814) << 1) - (i4814 ^ i4810);
        int i4816 = ~(((-34356) ^ i18) | ((-34356) & i18));
        int i4817 = ~((i4718 ^ iIntValue) | (i4718 & iIntValue));
        int i4818 = ~(i4811 | i17);
        int i4819 = ~((i4718 & (-34356)) | ((-34356) ^ i4718));
        int i4910 = (i4819 & i4818) | (i4818 ^ i4819);
        char c115 = (char) (((i4815 + (((i4816 & i4817) | (i4816 ^ i4817)) * (-1040))) - (~(-(-(((i4910 & i4817) | (i4910 ^ i4817)) * 520))))) - 1);
        int i4911 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
        Object[] objArr1114 = new Object[1];
        a(c115, ((i4911 | 1754) << 1) - (i4911 ^ 1754), 12 - (~(-Color.argb(0, 0, 0, 0))), objArr1114);
        String str417 = (String) objArr1114[0];
        int i4912 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
        int i4913 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
        Object[] objArr1115 = new Object[1];
        a((char) ((i4912 & 44093) + (i4912 | 44093)), (i4913 ^ 1768) + ((i4913 & 1768) << 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 5, objArr1115);
        String[] strArr40 = {str417, (String) objArr1115[0]};
        Object[] objArr1116 = new Object[1];
        a((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 1772 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), 14 - (~(ViewConfiguration.getJumpTapTimeout() >> 16)), objArr1116);
        String str418 = (String) objArr1116[0];
        char c116 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
        int i4914 = 1787 - (~Drawable.resolveOpacity(0, 0));
        int i4915 = -View.getDefaultSize(0, 0);
        int i4916 = (i4915 & 19) + (i4915 | 19);
        Object[] objArr1117 = new Object[1];
        a(c116, i4914, i4916, objArr1117);
        String str419 = (String) objArr1117[0];
        char cLastIndexOf6 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
        int i4917 = 1807 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
        int i4918 = -View.MeasureSpec.getMode(0);
        int i4919 = (i4918 * 624) - 8708;
        int i5010 = ((-15) & i4918) | ((-15) ^ i4918);
        int i5011 = -(-((~((i5010 & iIntValue) | (i5010 ^ iIntValue))) * 623));
        int i5012 = (i4919 ^ i5011) + ((i4919 & i5011) << 1);
        int i5013 = ~i4918;
        int i5014 = ~((i5013 & 14) | (i5013 ^ 14));
        int i5015 = -(-(((i5014 & i17) | (i17 ^ i5014)) * (-623)));
        int i5016 = (i5012 & i5015) + (i5015 | i5012);
        int i5017 = ~(((-15) ^ i4918) | ((-15) & i4918));
        int i5018 = ~(((-15) & iIntValue) | ((-15) ^ iIntValue));
        int i5019 = (i5018 & i5017) | (i5017 ^ i5018);
        int i5110 = ~((i4918 & iIntValue) | (i4918 ^ iIntValue));
        int i5111 = (i5016 - (~(((i5110 & i5019) | (i5019 ^ i5110)) * 623))) - 1;
        Object[] objArr1118 = new Object[1];
        a(cLastIndexOf6, i4917, i5111, objArr1118);
        String[] strArr41 = {str418, str419, (String) objArr1118[0]};
        char jumpTapTimeout7 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
        int i5112 = 1820 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
        int i5113 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
        int i5114 = (i5113 ^ 21) + ((i5113 & 21) << 1);
        Object[] objArr1119 = new Object[1];
        a(jumpTapTimeout7, i5112, i5114, objArr1119);
        String str510 = (String) objArr1119[0];
        int i5115 = -(-(ViewConfiguration.getTouchSlop() >> 8));
        int i5116 = 1840 - (~(-TextUtils.indexOf((CharSequence) "", '0')));
        int i5117 = -TextUtils.getOffsetAfter("", 0);
        int i5118 = ((i5117 | 10) << 1) - (i5117 ^ 10);
        Object[] objArr1210 = new Object[1];
        a((char) ((i5115 & 55679) + (i5115 | 55679)), i5116, i5118, objArr1210);
        String[] strArr110 = {str510, (String) objArr1210[0]};
        int i5119 = -(-TextUtils.getOffsetAfter("", 0));
        int i5210 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1851;
        int i5211 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
        int i5212 = (i5211 & 11) + (i5211 | 11);
        Object[] objArr1211 = new Object[1];
        a((char) (((i5119 | 11298) << 1) - (i5119 ^ 11298)), i5210, i5212, objArr1211);
        String str511 = (String) objArr1211[0];
        Object[] objArr1212 = new Object[1];
        a((char) ((-2) - ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) ^ (-1))), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 588, 5 - (~(-View.MeasureSpec.getSize(0))), objArr1212);
        String[] strArr111 = {str511, (String) objArr1212[0]};
        int threadPriority6 = Process.getThreadPriority(0);
        int i5213 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        int i5214 = ((i5213 | 1864) << 1) - (i5213 ^ 1864);
        int scrollBarFadeDuration2 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
        int i5215 = (scrollBarFadeDuration2 & 28) + (scrollBarFadeDuration2 | 28);
        Object[] objArr1213 = new Object[1];
        a((char) ((((threadPriority6 | 20) << 1) - (threadPriority6 ^ 20)) >> 6), i5214, i5215, objArr1213);
        String str512 = (String) objArr1213[0];
        int i5216 = -(-ExpandableListView.getPackedPositionType(0L));
        int i5217 = 1840 - (~(-Process.getGidForName("")));
        int i5218 = -TextUtils.getTrimmedLength("");
        int i5219 = ((i5218 | 10) << 1) - (i5218 ^ 10);
        Object[] objArr1214 = new Object[1];
        a((char) (((i5216 | 55679) << 1) - (i5216 ^ 55679)), i5217, i5219, objArr1214);
        strArr = new String[][]{strArr40, strArr41, strArr110, strArr111, new String[]{str512, (String) objArr1214[0]}};
        i21 = 0;
        i22 = -1;
        loop5: while (true) {
            if (i21 < 5) {
                i23 = iIntValue;
                break;
            }
            int i5310 = setTopP6481 + 113;
            component8 = i5310 % 128;
            int i5311 = i5310 % 2;
            String[] strArr112 = strArr[i21];
            str2 = strArr112[0];
            i30 = 1;
            strArr2 = (String[]) Arrays.copyOfRange(strArr112, 1, strArr112.length);
            length = strArr2.length;
            i31 = 0;
            while (i31 < length) {
                int i5312 = component8;
                int i5313 = ((i5312 | 111) << i30) - (i5312 ^ 111);
                setTopP6481 = i5313 % 128;
                int i5314 = i5313 % 2;
                i22++;
                Object[] objArr1215 = {str2, strArr2[i31]};
                objComponent10 = setSystemGestureExclusionRectsL30479.component5(1297851439);
                if (objComponent10 == null) {
                    int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 52;
                    char size2 = (char) (41180 - View.MeasureSpec.getSize(0));
                    int mirror5 = 3575 - AndroidCharacter.getMirror('0');
                    Object[] objArr1216 = new Object[1];
                    b(0, -1, (byte) 2, objArr1216);
                    objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionType4, size2, mirror5, 535748684, false, (String) objArr1216[0], new Class[]{String.class, String.class});
                }
                long jLongValue113 = ((Long) ((Method) objComponent10).invoke(null, objArr1215)).longValue();
                long elapsedCpuTime10 = (int) Process.getElapsedCpuTime();
                long j415 = elapsedCpuTime10 ^ (-1);
                long j416 = jLongValue113 ^ (-1);
                long j417 = (-140139122310L) + ((-163) * jLongValue113) + ((-328) * ((-849328014) | ((j415 | jLongValue113) ^ (-1)))) + (((-849328014) | elapsedCpuTime10) * 164) + (164 * ((((j415 | (-849328014)) | jLongValue113) ^ (-1)) | ((849328013 | j416) ^ (-1)) | ((j416 | elapsedCpuTime10) ^ (-1)))) + 1215132944;
                int iUptimeMillis9 = (int) SystemClock.uptimeMillis();
                i32 = ((int) (j417 >> 32)) & ((-1153123274) + (((~iUptimeMillis9) | 1790290645) * 1444) + (((~(iUptimeMillis9 | 1970274626)) | (~((-533048216) | iUptimeMillis9)) | 176532117) * (-1444)) + 195309684);
                int iMyTid11 = Process.myTid();
                int i5315 = (~(247141823 | iMyTid11)) | (-1325350912);
                int i5316 = ~((~iMyTid11) | (-111875499));
                i33 = ((int) j417) & ((-1581897131) + ((i5315 | i5316) * (-470)) + (((~(iMyTid11 | (-1078209089))) | i5316) * 470));
                if (((i32 & i33) | (i32 ^ i33)) != 0) {
                    int i5317 = (i22 ^ 170) + ((i22 & 170) << 1);
                    i23 = (i5317 & i17) | ((~i5317) & iIntValue);
                    break loop5;
                }
                int i5318 = (i31 & (-117)) + (i31 | (-117));
                i31 = ((i5318 | 118) << 1) - (i5318 ^ 118);
                br.AnonymousClass2.component9();
                strArr = strArr;
                i21 = i21;
                i30 = 1;
            }
            String[][] strArr113 = strArr;
            int i5319 = i21;
            int i5410 = ((i5319 | (-24)) << 1) - (i5319 ^ (-24));
            i21 = (i5410 ^ 25) + ((i5410 & 25) << 1);
            strArr = strArr113;
        }
        if (i23 != iIntValue) {
            Object[] objArr1217 = new Object[5];
            objArr1217[0] = new int[]{iIntValue};
            objArr1217[1] = new int[]{i23};
            objArr1217[4] = new int[1];
            objArr1217[2] = null;
            objArr1217[i3] = null;
            int i5411 = ~new Random().nextInt(254515546);
            int i5412 = ~(440419759 | i5411);
            int i5413 = 1211837938 + ((i5412 | 475803079) * 764) + (((~(i5411 | 475803079)) | 33570856) * (-1528)) + ((102525032 | i5412) * 764);
            int i5414 = (iIntValue2 - (~(-(-((i5413 ^ 16) + ((i5413 & 16) << 1)))))) - 1;
            int i5415 = i5414 << 13;
            int i5416 = (i5415 & (~i5414)) | ((~i5415) & i5414);
            int i5417 = i5416 >>> 17;
            int i5418 = ((~i5416) & i5417) | ((~i5417) & i5416);
            int i5419 = i5418 << 5;
            ((int[]) objArr1217[4])[0] = ((~i5418) & i5419) | ((~i5419) & i5418);
            return objArr1217;
        }
        char deadChar4 = (char) KeyEvent.getDeadChar(0, 0);
        int iIndexOf9 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1892;
        int iRgb2 = Color.rgb(0, 0, 0);
        int iComponent112 = br.AnonymousClass2.component9();
        int i5510 = iRgb2 * (-813);
        int i5511 = ((i5510 | (-1744825160)) << 1) - (i5510 ^ (-1744825160));
        int i5512 = (iRgb2 ^ iComponent112) | (iRgb2 & iComponent112);
        int i5513 = ((~(((-16777230) & iRgb2) | ((-16777230) ^ iRgb2))) | (~i5512)) * (-814);
        int i5514 = (i5511 ^ i5513) + ((i5513 & i5511) << 1);
        int i5515 = ~iComponent112;
        int i5516 = ~((i5515 & (-16777230)) | ((-16777230) ^ i5515));
        int i5517 = ~iRgb2;
        int i5518 = ~((i5517 ^ 16777229) | (i5517 & 16777229));
        int i5519 = -(-(((i5516 & i5518) | (i5516 ^ i5518) | (~i5512)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
        int i5610 = ~((i5517 & iComponent112) | (i5517 ^ iComponent112));
        int i5611 = (i5610 & i5518) | (i5518 ^ i5610);
        int i5612 = ~((iComponent112 & 16777229) | (iComponent112 ^ 16777229));
        int i5613 = (((i5514 | i5519) << 1) - (i5519 ^ i5514)) + (((i5611 & i5612) | (i5611 ^ i5612)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE);
        Object[] objArr1218 = new Object[1];
        a(deadChar4, iIndexOf9, i5613, objArr1218);
        String str513 = (String) objArr1218[0];
        char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
        int i5614 = -TextUtils.lastIndexOf("", '0', 0, 0);
        int i5615 = (i5614 & 1903) + (i5614 | 1903);
        int i5616 = -Color.red(0);
        int i5617 = (i5616 & 8) + (i5616 | 8);
        Object[] objArr1219 = new Object[1];
        a(maximumFlingVelocity3, i5615, i5617, objArr1219);
        Object[] objArr1310 = {str513, (String) objArr1219[0]};
        objComponent9 = setSystemGestureExclusionRectsL30479.component5(1297851439);
        if (objComponent9 == null) {
            int minimumFlingVelocity7 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 52;
            char fadingEdgeLength4 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 41180);
            int iResolveSize3 = 3527 - View.resolveSize(0, 0);
            Object[] objArr1311 = new Object[1];
            b(0, -1, (byte) 2, objArr1311);
            objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(minimumFlingVelocity7, fadingEdgeLength4, iResolveSize3, 535748684, false, (String) objArr1311[0], new Class[]{String.class, String.class});
        }
        long jLongValue114 = ((Long) ((Method) objComponent9).invoke(null, objArr1310)).longValue();
        long jUptimeMillis4 = (int) SystemClock.uptimeMillis();
        long j418 = 94048245300L + (302 * jLongValue114) + (((((-313494151) | jLongValue114) | jUptimeMillis4) ^ (-1)) * (-301));
        long j419 = jLongValue114 ^ (-1);
        long j510 = j418 + ((-301) * ((((jUptimeMillis4 ^ (-1)) | (-313494151)) ^ (-1)) | ((j419 | jUptimeMillis4) ^ (-1)))) + (301 * (j419 | ((313494150 | jUptimeMillis4) ^ (-1)))) + 679299081;
        int iNextInt14 = new Random().nextInt(788321808);
        i28 = ((int) (j510 >> 32)) & (1153515458 + (((~(1056830678 | iNextInt14)) | 380395732) * (-756)) + (((~iNextInt14) | 1056830678) * 756));
        int i5618 = (int) j510;
        int i5619 = ~(Process.myTid() | 1267785014);
        i29 = i5618 & (((357830697 | i5619) * (-658)) + 1704926357 + ((i5619 | 340000777) * 658));
        if (((i28 & i29) | (i28 ^ i29)) != 0) {
            i24 = iIntValue & (-151);
            i25 = i17 & 150;
            i26 = i24 | i25;
        } else {
            int i5710 = setTopP6481 + 89;
            component8 = i5710 % 128;
            int i5711 = i5710 % 2;
            i26 = iIntValue;
        }
        if (i26 != iIntValue) {
            Object[] objArr1312 = new Object[5];
            objArr1312[0] = new int[]{iIntValue};
            objArr1312[1] = new int[]{i26};
            objArr1312[4] = new int[1];
            objArr1312[2] = null;
            objArr1312[i3] = null;
            int iMyTid12 = Process.myTid();
            int i5712 = ~((-872784584) | iMyTid12);
            int i5713 = ~iMyTid12;
            int i5714 = i5712 | (~(43438255 | i5713));
            int i5715 = ~(872784583 | i5713);
            int i5716 = (iIntValue2 - (~(((((-637801514) + ((i5714 | i5715) * (-516))) + (((~(iMyTid12 | (-295048))) | (~((-43143209) | i5713))) * 516)) + ((43143208 | i5715) * 516)) + 16))) - 1;
            int i5717 = i5716 << 13;
            int i5718 = (i5717 & (~i5716)) | ((~i5717) & i5716);
            int i5719 = i5718 >>> 17;
            int i5810 = ((~i5718) & i5719) | ((~i5719) & i5718);
            int i5811 = i5810 << 5;
            ((int[]) objArr1312[4])[0] = (i5810 | i5811) & (~(i5810 & i5811));
            return objArr1312;
        }
        int i5812 = -Color.blue(0);
        Object[] objArr1313 = new Object[1];
        a((char) ((i5812 & 23298) + (i5812 | 23298)), TextUtils.indexOf((CharSequence) "", '0', 0) + 1913, 47 - (Process.myPid() >> 22), objArr1313);
        Object[] objArr1314 = {(String) objArr1313[0]};
        objComponent8 = setSystemGestureExclusionRectsL30479.component5(1152753004);
        if (objComponent8 == null) {
            int i5813 = 53 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            char c117 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 59725);
            int iLastIndexOf8 = 6316 - TextUtils.lastIndexOf("", '0', 0);
            Object[] objArr1315 = new Object[1];
            b(1, -1, (byte) 1, objArr1315);
            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i5813, c117, iLastIndexOf8, 369154319, false, (String) objArr1315[0], new Class[]{String.class});
        }
        long jLongValue115 = ((Long) ((Method) objComponent8).invoke(null, objArr1314)).longValue();
        long j511 = jLongValue115 ^ (-1);
        long j512 = 229686793 | j511;
        long jNextInt6 = new Random().nextInt();
        long j513 = jNextInt6 ^ (-1);
        long j514 = ((((38357694598L + ((-167) * jLongValue115)) + (((j512 ^ (-1)) | ((j511 | j513) ^ (-1))) * 168)) + (((j512 | jNextInt6) ^ (-1)) * 168)) + (168 * ((((229686793 | jLongValue115) ^ (-1)) | ((229686793 | j513) ^ (-1))) | (((j511 | (-229686794)) | jNextInt6) ^ (-1))))) - 744815091;
        int iNextInt15 = new Random().nextInt();
        int iFreeMemory5 = (int) Runtime.getRuntime().freeMemory();
        int i5814 = ((((int) (j514 >> 32)) & (538936514 + (((-1073809673) | iNextInt15) * (-381)) + (((~((~iNextInt15) | (-1931692463))) | (-1141975305)) * 381) + 1099591912)) | (((int) j514) & ((-1587633331) + (((~(1381892508 | iFreeMemory5)) | (-1476372926) | (~(1475848377 | iFreeMemory5))) * (-744)) + (((~iFreeMemory5) | 1381367960) * 744) + ((iFreeMemory5 | 1476372925) * 744)))) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED;
        i27 = (i5814 | iIntValue) & (~(iIntValue & i5814));
        if (i27 != iIntValue) {
            Object[] objArr1316 = new Object[5];
            objArr1316[0] = new int[]{iIntValue};
            objArr1316[1] = new int[]{i27};
            objArr1316[4] = new int[1];
            objArr1316[2] = null;
            objArr1316[i3] = null;
            int iElapsedRealtime9 = (int) SystemClock.elapsedRealtime();
            int i5815 = ~iElapsedRealtime9;
            int i5816 = 2137939772 + (((~((-336097464) | i5815)) | 580125375) * 519) + (((~(i5815 | (-336097281))) | (~(916222655 | iElapsedRealtime9))) * (-519)) + (((~(iElapsedRealtime9 | 580125375)) | 336097463) * 519) + 16;
            int i5817 = (iIntValue2 & i5816) + (iIntValue2 | i5816);
            int i5818 = i5817 << 13;
            int i5819 = ((~i5817) & i5818) | ((~i5818) & i5817);
            int i5910 = i5819 >>> 17;
            int i5911 = ((~i5819) & i5910) | ((~i5910) & i5819);
            int i5912 = i5911 << 5;
            ((int[]) objArr1316[4])[0] = (i5911 | i5912) & (~(i5911 & i5912));
            return objArr1316;
        }
        Object[] objArr1317 = new Object[5];
        objArr1317[0] = new int[]{iIntValue};
        objArr1317[1] = new int[]{iIntValue};
        objArr1317[4] = new int[1];
        objArr1317[2] = null;
        objArr1317[i3] = null;
        int iMaxMemory4 = (int) Runtime.getRuntime().maxMemory();
        int i5913 = (~((-462495408) | iMaxMemory4)) | 453055623;
        int i5914 = ~iMaxMemory4;
        int i5915 = 13308736 + ((i5913 | (~(463167215 | i5914))) * 886) + (((~(i5914 | 462495407)) | 453727431) * (-1772)) + ((~(i5914 | 453727431)) * 886);
        int i5916 = (i5915 << 1) - i5915;
        int i5917 = ((iIntValue2 | i5916) << 1) - (i5916 ^ iIntValue2);
        int i5918 = i5917 << 13;
        int i5919 = (i5918 & (~i5917)) | ((~i5918) & i5917);
        int i6010 = i5919 >>> 17;
        int i6011 = ((~i5919) & i6010) | ((~i6010) & i5919);
        int i6012 = i6011 << 5;
        ((int[]) objArr1317[4])[0] = (i6011 | i6012) & (~(i6011 & i6012));
        return objArr1317;
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component8 = 0;
        setTopP6481 = 1;
        char[] cArr = new char[1959];
        ByteBuffer.wrap("^Ôu©\bòß/ò\f\u0086\u0092]Ðpí\u0007/Ú{î\u008e\u0085ÚX\u001bo\u001a\u0002nÖµíÿ\u0080\u001fWRk\u008a>°ÕÊè,¿QS\u008afÞ=â^Ôu©\bòß/ò\f\u0086\u0092]Ðpí\u0007/Ú{î\u008e\u0085ÚX\u001bo\u001a\u0002\u007fÖ¸íë\u0080\bWhk\u009d>³Õçè<¿US\u008f\u000fÄ$¹Yâ\u008e?£\u001c×\u0082\fÀ!ýV?\u008bk¿\u009eÔÊ\t\u000b>\nSl\u0087¸¼åÑ\u001e^Ôu¾\bîß*ò\f\u0086\u0098]Ðpå\u0007>Úqî\u0082\u0085\u0086X\u0014o*\u0002cÖµíý\u0080\u0004WDk\u0091>\u009cÕ÷è>¿US\u009ffØ=õÐ0l-GQ:\u001aíÃÀõ´ho!BV5Âè\u0096Üq· ^Ôu¨\bãß:ò\f\u0086\u0086]Öpì\u0007eÚmî\u0095\u0085ÆX\u0003iÛB±?üè5ÅM±\u0088jÔG¡0\u0016íTÙ¥²Éo\nX/5Dá¿Úà·\u0003^Ôu©\böß-òB\u0086Ú]\u0091pâ\u0007;Úhî\u008e\u0085ÇX\u0015o*2õ\u0019ÞdÅ³G\u009e0êæ1·\u001cÓkE¶\u0004\u0082ÿé§4`\u0003Pn\u0017ºò\u0081\u0089ìt;?\u0007ÚRÛ¹\u0087\u0084PÓl^\u0089u¢\b¹ß;òL\u0086\u009a]Ëp¯\u00079Úxî\u0083\u0085ÛX\u001co,\u0002kÖ\u008eíõ\u0080\bWCk¦>§Õûè,¿\u0013^Ôu¾\bîß*òW\u0086\u0090]Òp®\u0007'Útî\u0085\u0085\u0086X\u001fo,\u0002mÖ¿íù\u0080CWDk\u0096^\u0099u¤\bðß7òL\u0086\u008d^§u\u008cÍØæ²\u009bâL&a[\u0015\u009cÎÞã¢\u0094%Ix}\u0085\u0016\u008aË\u0011ü,\u0091nE¨~Á\u0013,Ä\u0016ø\u009b\u00adªFô{&,\u0000À\u0084õÞ®åC1tm(\u0086ÝÏ^Ôu¾\bîß*òW\u0086\u0090]Òp®\u0007)Útî\u0089\u0085\u0086X\u001do \u0002bÖ¤íÍ\u0080 W\u001ak\u0089>±Õúè/^Ôu¾\bîß*òW\u0086\u0090]Òp®\u0007'Útî\u0085\u0085\u0086X\u001fo,\u0002mÖ¿íþ\u0080\u0000WBk¯>\u008eÕåè-¿NS\u009bf\u0093=ôÐ&^Ôu©\bòß/ò\f\u0086\u009b]Úpì\u0007>Úzî\u0092\u0085ÌX\u0000o1kò@Ù=Âê@Ç-³çh¨E\u009e2\u001eï\u000eÛó°¡m|\u0091\u009eº£Çý\u0010!=MIÐ\u0092Ú¿ïÈ4 Ê\u008b£öû!(\f^xÄ£Ç\u008eöù9$f\u0010\u008a{Î¦\u001e\u0091/üt(¢\u0013ö^\u0095u¨\búß,òP\u0086\u0093\u000f\u0082$©Y²\u008e\"£Z×\u0091\fÐ!ÿV#\u008bb¿ÂÔÏ\t\u0019> Sq\u0087¼¼ñÑ\u0005\u0006H:\u0087oº\u0084û¹&^\u009cu¨\bùß ^\u008bu¨\båß*òJ\u0086\u0086]Ëp¯\u00078Údî\u0094\u0085\u0087X\u0011o!\u0002!Öµíþ\u0080\u000fWBk\u009e>íÕòè/¿TSÅfÛ=æÐ\"çv»ºNÈe\u00018NÏRã¥¶üM\r`Q4\u009aË³\u009eîµ/[\u009fp¼\rñÚ>÷^\u0083\u0092Xßu»\u0002,ßpë\u0080\u0080\u0093]\u0005j5\u00075Ó¡èê\u0085\u001bRVn\u008a;ùÐæí;º@VÑcÏ8òÕ6âb¾®KÜ`\u0015=ZÊFæµ³èH\u0019eE1\u0084Î§¸Y\u0093zî79ø\u0014\u0098`T»\u0019\u0096}áê<¶\bFcU¾Ã\u0089óäó0g\u000b,fÝ±\u0090\u008dLØ?35\u000eâYÝµZ\u0080\u001eÛ<^\u008bu¨\båß*òJ\u0086\u0086]Ëp¯\u00078Údî\u0094\u0085\u0087X\u0011o!\u0002!Öµíþ\u0080\u000fWBk\u009e>íÕçè0¿\u000fS\u0087fÜ=äÜÜ÷ÿ\u008a²]}p\u001d\u0004Ñß\u009còø\u0085oX3lÃ\u0007ÐÚFív\u0080vTâo©\u0002XÕ\u0015éÉ¼ºW°jg=XÑÑä\u0089¿³^\u008bu¨\båß*òJ\u0086\u0086]Ëp¯\u00078Údî\u0094\u0085\u0087X\u0011o!\u0002!Öµíþ\u0080\u000fWBk\u009e>íÕçè0¿\u000fS\u0086fÓ=ä^\u008du¯\bøß!òP\u0086\u0093^Ôu½\båß6ò@\u0086Ú]Òpî\u0007/Úhî\u008b\u0085ÌX\u0000:ñ\u0011Ól\u0084»]\u00968âü9¦\u0014\u008ecCæ^ÍJ°\u001bgÂJ¬>xå)È\n¿Æb\u0091^\u008eu£\büß7òL\u0086\u0082]Ñ^\u0098u¥\båß6òN\u0086\u009c]Êpì¼\u0099\u0097²ê©=9\u0010Ad\u008a¿Ë\u0092äå88y\fÙgÝº\u0006\u008d#àv4¢\u000fî^\u008du¯\bøß!ò\u001b\u0086Ã]Ï^\u009cu¨\bùß<òQ\u0086\u009c]Ü*\u0005\u00011|`«¥\u0086Èò\u0005)E\u0004Gsª®¼\u009aH\u0080Ï«ûÖª\u0001o,\u0002XÏ\u0083\u008f®\u008dÙ`\u0004v0\u0082[¥\u0086\u0016±\"^\u0089u¢\b¹ß)òQ\u0086\u009a]Ûpô\u0007(ÚiîÉ\u0085ÄX\u001co!\u0002jÖ½\u0018Ä3åN°^\u009eu \bâß5òB\u0086\u0081]Ðpó^ºu½\bçßyòq\u0086\u0080]Ñpõ\u0007\"Úpî\u0082\u0085\u0089X\u0015o*\u0002}ÖñíØ\u0080\u0005WEk\u0096>®Õð\u0092 ¹¹Äé\u00131>VJ\u0086\u0091Á¼»Ë\u0002\u0016C\"¶I\u0093\u0094\u000b£*Î|\u001a§!õLW\u009bK§\u008cò«\u0019¯$=s\u0003\u009fÇ^ºu£\bóß+òL\u0086\u009c]Ûp¡\u0007\u0018ÚYî¬\u0085\u0089X\u0011o0\u0002fÖ½íï\u0080MWQk\u0096>±Õµè'¿\u0019SÝfâ=±Ð}^\u0089u¢\b¹ß1òB\u0086\u0087]Ûpö\u0007*Úoî\u0082^\u009cu¢\bûß=òE\u0086\u009c]Ìpé^\u008du¯\bøß!ò\u001b\u0086Ã^\u0089u¬\bùß:òK\u0086\u0080´3\u009f\u0018â\u00035\u0093\u0018ël ·a\u009aNí\u00920Ó\u0004soq²»\u0085\u009eèÛ<\u000f^\u0089u¢\b¹ß2òF\u0086\u0087]Ñpä\u0007'Ú3î\u0096\u0085ÌX\u001eo0^Ê^\u0089u¢\b¹ß*òF\u0086\u0096]Êpó\u0007.^Ë^\u0089u¢\b¹ß;òV\u0086\u009c]Ópå\u0007eÚmî\u0095\u0085ÆX\u0017o0\u0002lÖ¥»í\u0090Èí\u008b:E\u0017\fcý¸÷\u0095ÇÉYâr\u009fiHëe\u0086\u0011LÊ\u0003ç5\u0090µM«y^\u0012\u0017ÏÄøð\u0095\u00adAqz9\u0017ÔÀ\u0089ü]ÌIç}\u009a,Mé`\u0084\u0014IÏ\tâ{\u0095íH¬|Y\u0017SÊÁýõ\u0090´Da\u007f<\u0012ÑÅ\u0081^\u009cu¨\bùß<òQ\u0086\u009c]ÜpÞ\u00073Ú%îÑ\u0085\u0086X\u0000o!\u0002dÖ\u008eíã\u0080UW\u0001kÖ>¤Õðè1¿DS\u0099fÔ=äÐ\u0016çk»ÝN\u0099\u001c87\fJ]\u009d\u0098°õÄ8\u001fx2\nE\u0088\u0098Ö¬,Çj\u001a»-\u0084@ô\u0094\u0006¯[Â¢\u0015¼):|\u0002\u0097_ª\u009eý÷\u0011&$z^\u009cu¨\bùß<òQ\u0086\u009c]Üp®\u0007=Ú\u007fî\u0088\u0085ÑXKos\u0002\u007fÖþíí\u0080\u000fWXk\u0081>ûÕ£è/*ó\u0001Í|\u0097«Q\u0086 òÿ)ÿ\u0004\u009ds@®\u0019\u009a×ñ¡,l\u001bBv\u000f¢Ð\u0099\u0091ô]# \u001f®J\u009a¡Õ\u009cWË+'ê\u0012·I\u009a¤O\u0093\u001fÏÕ:¸\u0011&LbúIÑb¬y{ûV\u008c\"Zù\u000bÔ-£ä~¼JC!\füÁ®þ\u0085ÕøÎ/L\u0002;ví\u00ad¼\u0080\u009f÷Q*\u000b\u001e÷u»¨*\u009fPò\r&Ï\u001d\u0080p~§n\u009bèÎÝ%\u008c\u0018OO3£î\u0096ºÍ\u0082 W\u0017\nKæ^ºu£\bóß+òL\u0086\u009c]Ûp¬\u00073Ú%îÑ^\u0089u¢\b¹ß;òV\u0086\u009c]Ópå\u0007eÚyî\u008e\u0085ÚX\u0003o)\u0002nÖ¨íµ\u0080\u0004WS^\u008fu¨\bäß-ò\u000e^\u0092u£\bþß-ò\r\u0086\u0086]Épâ\u0007eÚlî\u0082\u0085ÄX\u0006oh\u0002\u007fÖ£íô\u0080\u001dWD^\u008au¨\búß,ò\r\u0086\u009d]Èp¯\u0007&Ú|î\u008e\u0085ÇX\u0018o \u0002vÖ¢^\u008au¨\búß,ò\r\u0086\u0086]Ùp¯\u0007-Ú|î\u008c\u0085ÌX,o&\u0002nÖ¼íþ\u0080\u001fWV''\f\u0005qW¦\u0081\u008b ÿ+$t\t\u0002~\u008a£Ó\u0097.ü[!º\u0016\u008d{Ì¯\u000f\u0094_ù´.ã^\u0089u¢\b¹ß2òF\u0086\u0087]Ñpä\u0007'Ú3î\u0086\u0085ÇX\u0017o7\u0002`Ö¸íÿ\u0080CWFk\u009c>®Õàè;^\u0089u¢\b¹ß;òL\u0086\u009a]Ëp¯\u0007:Úxî\u008a\u0085ÜX]o$\u0002yÖµíÄ\u0080\u0003WVk\u0094>¦\u0086\u009d\u00ad¶Ð\u00ad\u0007\"*S^\u008c\u0085\u0085¨÷ß*\u0002`6\u009f]Ù\u0080I·7Úr\u000e«5èX\u001c\u008fQ³\u009dæ¥\rè0%gA^\u0089u¢\b¹ß)òQ\u0086\u009a]Ûpô\u0007(ÚiîÉ\u0085ËX\u0006o,\u0002cÖµíµ\u0080\u000bW^k\u0097>¤Õðè-¿QS\u0099fÔ=éÐ=+$\u0000\u000f}\u0014ª\u0087\u0087÷ó+(f\u0005Ir\u008b¯\u009e\u009b(ðq-·\u001a\u0084wÆ£R\u0098Põ©\"ô\u001e3K\u000b J\u009d\u0082Êþ&/\u0013~H^^\u0089u¢\b¹ß*òZ\u0086\u0086]Ëpä\u0007&ÚBî\u0082\u0085ÑX\u0007ok\u0002mÖ¤íò\u0080\u0001WSk×>¥Õüè1¿FS\u008efÏ=÷Ð;çz»\u008bNÛ^\u0089u¢\b¹ß/òF\u0086\u009b]Ûpî\u00079Ú3î\u0085\u0085ÜX\u001ao)\u0002kÖÿíý\u0080\u0004WYk\u009e>¦Õçè/¿SS\u0082fÓ=ó^\u0089u¢\b¹ß/òF\u0086\u009b]Ûpî\u00079ÚBî\u0083\u0085ÅX\u0018o(\u0002!Ö³íî\u0080\u0004W[k\u009d>íÕóè6¿OS\u008cfØ=õÐ9ça»\u008cNÁe\u0005^Á±À\u009a½çæ0;\u001d\u0018i\u0090²Î\u009føè*5V\u0001\u0083jÔ·\u0017\u00804^Ôu©\bòß/ò\f\u0086\u0086]Ðpâ\u0007 Úxî\u0093\u0085\u0086X\u0011o$\u0002|Ö´íù\u0080\fWYk\u009d>\u009cÕòè:¿OS\u0092fÙ^Ôu©\bòß/ò\f\u0086\u0086]Ðpâ\u0007 Úxî\u0093\u0085\u0086X\u0014o \u0002aÖ¨íÿÜ¯÷Ò\u008a\u0089]Tpw\u0004ýß«ò\u0099\u0085[X\u0003lè\u0007ýÚyí[\u0080\u0019Tßo\u0084\u0005\u008d.çS·\u0084s©UÝÝ\u0006\u0083+µ\\g\u0081\u001bµÊÞ\u0082\u0003K4\u007fY3\u000fE$/Y\u007f\u008e»£Æ×\u0001\fC!?V¶\u008bå¿\u0014Ô\u0017\t\u008e>½Sü\u0087#¼UÑ\u0091\u0006Ç:\u0004o>\u0084k¹\u00adîï\u0002\u001e7Ilt\u0081\u00ad¶åê+\u001fO4\u0085iÇ\u009eé²hç{\u001c\u009d^Ôu©\bòß/ò\f\u0086\u0097]Ìpõ\u0007\u0014Úzî\u0097\u0085Úh\u0011Cl>7éêÄÉ°Rk\tF01Ñì¬ØK³\u0001nÓ.°\u0005Íx\u0096¯K\u0082höâ-´\u0000\u0086wDª\u001c\u009e÷õâ(u\u001fRr\u001f¦Ó\u009d\u0090ðe'7\u001bøNÕ¥\u0095^Ôu¾\bîß*òW\u0086\u0090]Òp®\u0007'Útî\u0085\u0085\u0086X\u001fo,\u0002mÖ³íè\u0080\u0019WQk\u0096>¯Õñè:¿SS´f×=éÐ ç=»\u0096NÀï\u008aÄ÷¹¬nqCR7Éì\u0092Á«¶tk _Ú4\u0092µ¶\u009eËã\u00904M\u0019nmõ¶®\u009b\u0097ìN1\u0006\u0005÷n¤q5ZH'\u0013ðÎÝí©vr-_\u0014(Çõ\u0099Áaª&J¿aÂ\u001c\u0099ËDæg\u0092üI§d\u009e\u0013OÎ\u0004úå\u0091§^Ôu©\bòß/ò\f\u0086\u0097]Ìpõ\u0007=Úpî\u0094\u0085Î^Ôu©\bòß/ò\f\u0086\u0097]Ìpõ\u0007;Úzî\u0086\u0085ÀX\u0003o&¢v\u0089\u000bôP#\u008d\u000e®z5¡n\u008cWû¶&Ö\u0012(yn^Ôu©\böß-òB\u0086Ú]Ûpî\u0007<Úsî\u008b\u0085ÆX\u0012o!\u0002|Öþíµ\u0080\u0015WUkÖ>¡Õæè+¿J4â\u001f\u0096bÏµ\u001b\u0098:ì´7à\u001aÙm\u0019°D\u0084¦ïì2j\u00051hJ¼\u0093\u0087þê3=`\u0001½T\u0090¿Ç\u0082/Õx9±\fïWÔº\rØçó\u008e\u008eÖY\u0005ts\u0000éÛåöÝ\u0081\b\\Ah¦\u0003îÞ3òöÙ\u0096¤ÌsD^$^Ôu½\båß6ò@\u0086Ú]Ìpä\u0007'Ú{îÈ\u0085ÄX\u0012o5\u0002|^\u009cu¿\böß5òO\u0086\u009a]Üp¯\u0007,Úrî\u008b\u0085ÍX\u0015o,\u0002|Ö¹íµ\u0080\u001eWX^\u0097u¤\bõß\u001eòo\u0086°]ìpÞ\u0007)Únî\u0093\u0085\u0087X\u0000o*^Ôu¨\bãß:ò\f\u0086\u0098]Úpå\u0007\"Ú|î¸\u0085ÊX\u001co!\u0002jÖ²íè\u0080CWOk\u0094>¯\u0087æ¬ÞÑ\u009d\u0006C+/_þ\u0084¡©\u009dÞ_\u0003\u0011röY\u008a$Áó\u0018Þ.ªºqò\\Ö+\u0007öKÂ¶^Ôu©\böß-òB\u0086Ú]Ûpî\u0007<Úsî\u008b\u0085ÆX\u0012o!\u0002|Öþíµ\u0080\tWGkÖ>¢Õåè/¿RSÅfÅ=êÐ%^Ôu½\båß6ò@\u0086Ú]Üpñ\u0007>Útî\u0089\u0085ÏX\u001c^¼u¢\bûß=òE\u0086\u009c]Ìpé\u0005Ö.«Sô\u0084/©@ÝØ\u0006Ð+ê\\:\u0081|µÊÞÛ\u0003\u00034(Yk\u008dº¶õÛ\n\fF0Ôe¢\u008eâ³/ä\f\bÙ=\u0090fæ\u008b$¼|àÉ\u0015À>\u001acZ\u0094}¸ºíí\u0016\b;Eo\u0089\u0090íÅäî:\u0013HG\u009ehØ\u009dêÆ(".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 1959);
        component5 = cArr;
        component9 = -2804309938189470259L;
    }

    public static Object[] D8871(Context context, int i, int i2, int i3) {
        return (Object[]) vD14832N6715(br.AnonymousClass2.component9(), br.AnonymousClass2.component9(), new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 1766338943, br.AnonymousClass2.component9(), br.AnonymousClass2.component9(), -1766338943);
    }

    public static final /* synthetic */ StatFs vD14832N6715(mK14988T27556 mk14988t27556) {
        int iComponent9 = br.AnonymousClass2.component9();
        return (StatFs) vD14832N6715(br.AnonymousClass2.component9(), br.AnonymousClass2.component9(), new Object[]{mk14988t27556}, 1880456421, iComponent9, br.AnonymousClass2.component9(), -1880456420);
    }
}
