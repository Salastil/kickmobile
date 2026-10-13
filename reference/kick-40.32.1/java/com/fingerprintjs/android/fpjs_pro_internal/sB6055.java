package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055;", "", "<init>", "()V", "component5", "component9", "vD14832N6715", "D8871", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$D8871;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class sB6055 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static int component5;
    private static long setPivotYN16904;
    private static char[] vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r5, int r6, int r7) {
        /*
            int r5 = r5 * 2
            int r5 = 4 - r5
            int r6 = r6 * 3
            int r6 = 101 - r6
            int r7 = r7 * 3
            int r0 = r7 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.sB6055.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r5
            r6 = r7
            r4 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            r3 = r1[r5]
        L27:
            int r5 = r5 + 1
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.sB6055.$$c(short, int, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{1, -34, -12, 123};
        $$b = 199;
    }

    private sB6055() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$vD14832N6715;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class vD14832N6715 extends sB6055 {
        public static final vD14832N6715 INSTANCE = new vD14832N6715();
        private static int component5 = 0;
        private static int setPivotYN16904 = 1;

        private vD14832N6715() {
            super(null);
        }

        static {
            int i = setPivotYN16904 + 55;
            component5 = i % 128;
            if (i % 2 == 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component9 extends sB6055 {
        private static int D8871 = 1;
        public static final component9 INSTANCE = new component9();
        private static int component5;

        private component9() {
            super(null);
        }

        static {
            int i = D8871;
            int i2 = ((i | 103) << 1) - (i ^ 103);
            component5 = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component5 extends sB6055 {
        public static final component5 INSTANCE = new component5();
        private static int component9 = 1;
        private static int setPivotYN16904;

        private component5() {
            super(null);
        }

        static {
            int i = component9 + 61;
            setPivotYN16904 = i % 128;
            int i2 = i % 2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/sB6055;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class D8871 extends sB6055 {
        public static final D8871 INSTANCE = new D8871();
        private static int component5 = 0;
        private static int component9 = 1;

        private D8871() {
            super(null);
        }

        static {
            int i = component9 + 35;
            component5 = i % 128;
            int i2 = i % 2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x01e1  */
    private static void a(int i, char c, int i2, Object[] objArr) throws Throwable {
        Object obj;
        Throwable cause;
        long j;
        int i3;
        int i4 = 2 % 2;
        ck ckVar = new ck();
        long[] jArr = new long[i];
        ckVar.setPivotYN16904 = 0;
        while (true) {
            obj = null;
            if (ckVar.setPivotYN16904 >= i) {
                break;
            }
            int i5 = $11 + 35;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = ckVar.setPivotYN16904;
            try {
                Object[] objArr2 = {Integer.valueOf(vD14832N6715[i2 + i7])};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                if (objComponent5 == null) {
                    int iKeyCodeFromString = 51 - KeyEvent.keyCodeFromString("");
                    char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                    int scrollBarSize = 5904 - (ViewConfiguration.getScrollBarSize() >> 8);
                    j = 0;
                    byte b = (byte) ($$a[0] - 1);
                    byte b2 = b;
                    i3 = -720328195;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iKeyCodeFromString, cCombineMeasuredStates, scrollBarSize, -173582907, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                } else {
                    j = 0;
                    i3 = -720328195;
                }
                Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                l.longValue();
                Object[] objArr3 = {l, Long.valueOf(i7), Long.valueOf(setPivotYN16904), Integer.valueOf(c)};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                if (objComponent6 == null) {
                    int iLastIndexOf = 51 - TextUtils.lastIndexOf("", '0', 0);
                    char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5058;
                    byte b3 = $$a[0];
                    byte b4 = (byte) (b3 - 1);
                    byte b5 = b3;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf, jumpTapTimeout, scrollBarFadeDuration, 2120479290, false, $$c(b4, b5, (byte) (b5 - 1)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i7] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {ckVar, ckVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ExpandableListView.getPackedPositionChild(j) + 1), 2464 - View.getDefaultSize(0, 0), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
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
        char[] cArr = new char[i];
        ckVar.setPivotYN16904 = 0;
        int i8 = $11 + 9;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        while (ckVar.setPivotYN16904 < i) {
            int i10 = $10 + 37;
            $11 = i10 % 128;
            if (i10 % 2 == 0) {
                cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                Object[] objArr5 = {ckVar, ckVar};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2463, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
                obj.hashCode();
                throw null;
            }
            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
            Object[] objArr6 = {ckVar, ckVar};
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(-720328195);
            if (objComponent9 == null) {
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.getSize(0) + 51, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), Color.alpha(0) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent9).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr);
    }

    public static void setPivotYN16904(long j, long j2) throws Throwable {
        long j3;
        int i = 2 % 2;
        int i2 = D8871 + 117;
        component5 = i2 % 128;
        if (i2 % 2 != 0) {
            j3 = j | (j2 >>> 44);
            u.class.getField("vD14832N6715").get(null);
        } else {
            j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
        }
        int i3 = component5;
        int i4 = i3 + GapComposerKt.nodeKey;
        D8871 = i4 % 128;
        int i5 = i4 % 2;
        int i6 = i3 + 51;
        D8871 = i6 % 128;
        int i7 = i6 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 6, (char) (48124 - (ViewConfiguration.getEdgeSlop() >> 16)), 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a(4 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 40349), 8 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 10 - TextUtils.getOffsetBefore("", 0), objArr5);
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

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        component5 = 0;
        D8871 = 1;
        vD14832N6715 = new char[]{58737, 58380, 59327, 57676, 57546, 57946, 60701, 50004, 49727, 49541, 24203, 24548, 23643};
        setPivotYN16904 = 9109018732016000913L;
    }

    public /* synthetic */ sB6055(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
