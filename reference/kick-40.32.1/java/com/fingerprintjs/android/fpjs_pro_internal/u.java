package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/u;", "", "<init>", "()V", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class u {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static int N14263A23323;
    private static short[] component13;
    private static int component5;
    private static int component8;
    private static byte[] component9;
    private static int sG29839;
    private static int setPivotYN16904;
    private static int setTopP6481;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r7, short r8, byte r9) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.u.$$a
            int r9 = r9 * 4
            int r9 = 1 - r9
            int r7 = 111 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L27
        L12:
            r3 = r2
        L13:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r8]
            r6 = r3
            r3 = r8
            r8 = r6
        L27:
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.u.$$c(byte, short, byte):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{116, 98, -49, -93};
        $$b = 23;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.u$vD14832N6715, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/u$vD14832N6715;", "", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public static int D8871;
        public static int component9;

        private Companion() {
        }

        public static int component9() {
            int i = D8871;
            int i2 = i % 6172625;
            D8871 = i + 1;
            if (i2 != 0) {
                return component9;
            }
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            component9 = elapsedCpuTime;
            return elapsedCpuTime;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0076  */
    /* JADX WARN: Code duplicated, block: B:21:0x0092 A[PHI: r4
      0x0092: PHI (r4v9 byte[] A[IMMUTABLE_TYPE]) = (r4v8 byte[]), (r4v38 byte[]) binds: [B:20:0x0090, B:17:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x009e  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b1 A[Catch: all -> 0x0294, TryCatch #0 {all -> 0x0294, blocks: (B:3:0x000f, B:5:0x002e, B:6:0x0059, B:34:0x0115, B:36:0x0129, B:37:0x015b, B:43:0x01b3, B:45:0x01cf, B:46:0x020b, B:24:0x00a0, B:26:0x00b1, B:28:0x00ea), top: B:70:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:31:0x0104 A[PHI: r4
      0x0104: PHI (r4v37 byte[]) = (r4v8 byte[]), (r4v38 byte[]) binds: [B:20:0x0090, B:17:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(byte b, int i, short s, int i2, int i3, Object[] objArr) throws Throwable {
        int i4;
        long j;
        long j2;
        byte[] bArr;
        int length;
        byte[] bArr2;
        int i5;
        Object objComponent5;
        int i6 = 2 % 2;
        ch chVar = new ch();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i3), Integer.valueOf(D8871)};
            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(572769811);
            if (objComponent6 == null) {
                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.getDefaultSize(0, 0) + 52, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 58885), 6887 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 1888911984, false, $$c((byte) 0, (short) -1, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objComponent6).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + 103;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
            } else {
                i4 = 0;
            }
            if (i4 != 0) {
                int i8 = $10 + 105;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    bArr = component9;
                    int i9 = 58 / 0;
                    if (bArr != null) {
                        length = bArr.length;
                        bArr2 = new byte[length];
                        j = 0;
                        for (i5 = 0; i5 < length; i5++) {
                            Object[] objArr3 = {Integer.valueOf(bArr[i5])};
                            objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(59 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 1539 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -899819233, false, "l", new Class[]{Integer.TYPE});
                            }
                            bArr2[i5] = ((Byte) ((Method) objComponent5).invoke(null, objArr3)).byteValue();
                        }
                        j2 = -7710232700957351395L;
                        bArr = bArr2;
                    } else {
                        j = 0;
                        j2 = -7710232700957351395L;
                    }
                } else {
                    bArr = component9;
                    if (bArr != null) {
                        length = bArr.length;
                        bArr2 = new byte[length];
                        j = 0;
                        while (i5 < length) {
                            Object[] objArr4 = {Integer.valueOf(bArr[i5])};
                            objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(59 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 1539 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -899819233, false, "l", new Class[]{Integer.TYPE});
                            }
                            bArr2[i5] = ((Byte) ((Method) objComponent5).invoke(null, objArr4)).byteValue();
                        }
                        j2 = -7710232700957351395L;
                        bArr = bArr2;
                    } else {
                        j = 0;
                        j2 = -7710232700957351395L;
                    }
                }
                if (bArr != null) {
                    byte[] bArr3 = component9;
                    Object[] objArr5 = {Integer.valueOf(i2), Integer.valueOf(setPivotYN16904)};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(572769811);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 58885), 6887 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)), 1888911984, false, $$c((byte) 0, (short) -1, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objComponent7).invoke(null, objArr5)).intValue()]) ^ j2)) + ((int) (((long) D8871) ^ j2)));
                    int i10 = $10 + 43;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                } else {
                    iIntValue = (short) (((short) (((long) component13[i2 + ((int) (((long) setPivotYN16904) ^ j2))]) ^ j2)) + ((int) (((long) D8871) ^ j2)));
                }
            } else {
                j = 0;
                j2 = -7710232700957351395L;
            }
            if (iIntValue > 0) {
                chVar.D8871 = ((i2 + iIntValue) - 2) + ((int) (((long) setPivotYN16904) ^ j2)) + i4;
                Object[] objArr6 = {chVar, Integer.valueOf(i), Integer.valueOf(component5), sb};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(74627481);
                if (objComponent8 == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 52;
                    char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                    int packedPositionType = 4726 - ExpandableListView.getPackedPositionType(j);
                    byte b2 = (byte) ($$b & 1);
                    byte b3 = (byte) (-b2);
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveOpacity, cIndexOf, packedPositionType, 1455947258, false, $$c(b2, b3, (byte) (b3 + 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objComponent8).invoke(null, objArr6)).append(chVar.vD14832N6715);
                chVar.component9 = chVar.vD14832N6715;
                byte[] bArr4 = component9;
                if (bArr4 != null) {
                    int i12 = $11 + 57;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i14 = 0; i14 < length2; i14++) {
                        bArr5[i14] = (byte) (((long) bArr4[i14]) ^ j2);
                    }
                    bArr4 = bArr5;
                }
                boolean z = bArr4 != null;
                chVar.setPivotYN16904 = 1;
                while (chVar.setPivotYN16904 < iIntValue) {
                    if (z) {
                        byte[] bArr6 = component9;
                        int i15 = chVar.D8871;
                        chVar.D8871 = i15 - 1;
                        chVar.vD14832N6715 = (char) (chVar.component9 + (((byte) (((byte) (((long) bArr6[i15]) ^ j2)) + s)) ^ b));
                    } else {
                        short[] sArr = component13;
                        int i16 = chVar.D8871;
                        chVar.D8871 = i16 - 1;
                        chVar.vD14832N6715 = (char) (chVar.component9 + (((short) (((short) (((long) sArr[i16]) ^ j2)) + s)) ^ b));
                    }
                    sb.append(chVar.vD14832N6715);
                    chVar.component9 = chVar.vD14832N6715;
                    chVar.setPivotYN16904++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void D8871(long j, long j2) throws Throwable {
        int i = 2 % 2;
        long j3 = j ^ (j2 << 32);
        int i2 = sG29839 + 117;
        component8 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) (48 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 1128062573 - TextUtils.indexOf((CharSequence) "", '0', 0), (short) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), Color.blue(0) + 1480885784, (ViewConfiguration.getTouchSlop() >> 8) - 59, objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) ((-107) - (ViewConfiguration.getLongPressTimeout() >> 16)), 1128062505 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (short) (ViewConfiguration.getWindowTouchSlop() >> 8), 1480885790 - Drawable.resolveOpacity(0, 0), View.getDefaultSize(0, 0) - 63, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) (98 - (KeyEvent.getMaxKeyCode() >> 16)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1128062568, (short) (ViewConfiguration.getMinimumFlingVelocity() >> 16), Color.rgb(0, 0, 0) + 1497663008, (-63) - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i4 = sG29839 + 91;
            component8 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void component9(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = sG29839;
        int i3 = i2 + 45;
        component8 = i3 % 128;
        int i4 = i3 % 2;
        long j3 = j ^ (j2 << 32);
        int i5 = i2 + 11;
        component8 = i5 % 128;
        int i6 = i5 % 2;
        int i7 = i2 + 115;
        component8 = i7 % 128;
        int i8 = i7 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) (Color.rgb(0, 0, 0) + 16777264), 1128062573 + (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (short) (ViewConfiguration.getJumpTapTimeout() >> 16), 1480885783 + (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (-59) - TextUtils.getOffsetBefore("", 0), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) (TextUtils.lastIndexOf("", '0', 0, 0) + 124), 1128062506 + (ViewConfiguration.getEdgeSlop() >> 16), (short) (ViewConfiguration.getTouchSlop() >> 8), 1480885794 - (Process.myTid() >> 22), (-62) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) (98 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 1128062568 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (short) (KeyEvent.getMaxKeyCode() >> 16), 1480885791 - ((byte) KeyEvent.getModifierMetaStateMask()), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 63, objArr5);
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

    private static void vD14832N6715(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = sG29839 + 103;
        component8 = i2 % 128;
        try {
            Object[] objArr = {Long.valueOf(i2 % 2 != 0 ? (j2 >>> 19) * j : j ^ (j2 << 32))};
            Object[] objArr2 = new Object[1];
            a((byte) ((Process.myTid() >> 22) + 48), View.resolveSize(0, 0) + 1128062574, (short) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), 1480885784 + ((Process.getThreadPriority(0) + 20) >> 6), ((byte) KeyEvent.getModifierMetaStateMask()) - 58, objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 60), 1128062504 + (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (short) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 1480885795 + (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) - 63, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) (98 - TextUtils.getOffsetAfter("", 0)), (ViewConfiguration.getPressedStateDuration() >> 16) + 1128062568, (short) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Color.alpha(0) + 1480885792, (-63) - KeyEvent.getDeadChar(0, 0), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i3 = component8 + 85;
            sG29839 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 89 / 0;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void component5(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = sG29839 + 57;
        int i3 = i2 % 128;
        component8 = i3;
        int i4 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        int i5 = i3 + 95;
        int i6 = i5 % 128;
        sG29839 = i6;
        int i7 = i5 % 2;
        int i8 = i6 + 75;
        component8 = i8 % 128;
        int i9 = i8 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) (((Process.getThreadPriority(0) + 20) >> 6) + 48), 1128062574 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (ViewConfiguration.getLongPressTimeout() >> 16), 1480885784 + Color.green(0), (-58) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) ((-25) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (Process.myTid() >> 22) + 1128062506, (short) (ViewConfiguration.getScrollDefaultDelay() >> 16), View.MeasureSpec.getSize(0) + 1480885798, (-63) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) (98 - ExpandableListView.getPackedPositionType(0L)), TextUtils.indexOf("", "", 0, 0) + 1128062568, (short) TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1480885791, (-63) - KeyEvent.getDeadChar(0, 0), objArr5);
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

    private static void setPivotYN16904(long j, long j2) throws Throwable {
        int i = 2 % 2;
        long j3 = j ^ (j2 << 32);
        int i2 = component8 + 59;
        sG29839 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 47), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1128062574, (short) (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf("", "") + 1480885784, (-59) - (ViewConfiguration.getTouchSlop() >> 8), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) ((-47) - (ViewConfiguration.getWindowTouchSlop() >> 8)), TextUtils.lastIndexOf("", '0', 0, 0) + 1128062506, (short) ((-1) - Process.getGidForName("")), TextUtils.lastIndexOf("", '0', 0, 0) + 1480885801, (-63) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 98), ((byte) KeyEvent.getModifierMetaStateMask()) + 1128062569, (short) Gravity.getAbsoluteGravity(0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1480885791, (-63) - (ViewConfiguration.getScrollBarSize() >> 8), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i4 = component8 + 3;
            sG29839 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 11 / 0;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void setTopP6481(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = sG29839 + 5;
        component8 = i2 % 128;
        try {
            Object[] objArr = {Long.valueOf(i2 % 2 != 0 ? j + (j2 >> 106) : j ^ (j2 << 32))};
            Object[] objArr2 = new Object[1];
            a((byte) (48 - (ViewConfiguration.getWindowTouchSlop() >> 8)), 1128062573 + (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (short) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 1480885784 - Drawable.resolveOpacity(0, 0), (-59) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) (ImageFormat.getBitsPerPixel(0) - 98), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1128062504, (short) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 1480885801 - Process.getGidForName(""), (Process.myTid() >> 22) - 63, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 98), 1128062568 - Gravity.getAbsoluteGravity(0, 0), (short) (Process.myTid() >> 22), 1480885792 - (ViewConfiguration.getScrollBarSize() >> 8), AndroidCharacter.getMirror('0') - 'o', objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i3 = sG29839 + 71;
            component8 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void component8(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = component8 + 89;
        int i3 = i2 % 128;
        sG29839 = i3;
        long j3 = i2 % 2 == 0 ? j / (j2 << 77) : j ^ (j2 << 32);
        int i4 = i3 + 95;
        component8 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) (48 - (ViewConfiguration.getEdgeSlop() >> 16)), 1128062573 - Process.getGidForName(""), (short) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1480885784 - View.MeasureSpec.makeMeasureSpec(0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 60, objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) (Color.blue(0) + 97), AndroidCharacter.getMirror('0') + 56825, (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1480885805 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) - 63, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) ((Process.myTid() >> 22) + 98), 1128062567 - ((byte) KeyEvent.getModifierMetaStateMask()), (short) ('0' - AndroidCharacter.getMirror('0')), 1480885792 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) - 63, objArr5);
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

    static void component5() {
        setPivotYN16904 = 611146741;
        D8871 = -2083118497;
        component5 = 1058340885;
        component9 = new byte[]{58, -57, -35, 36, 38, -58, -120, -117, -128, 122, 98, 103, 36, 34, -2, -7, -55, -52, -126, -122, -122, 122, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS};
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        component8 = 0;
        sG29839 = 1;
        N14263A23323 = 0;
        setTopP6481 = 1;
        component5();
        INSTANCE = new Companion(null);
        int i = N14263A23323 + 45;
        setTopP6481 = i % 128;
        int i2 = i % 2;
    }
}
