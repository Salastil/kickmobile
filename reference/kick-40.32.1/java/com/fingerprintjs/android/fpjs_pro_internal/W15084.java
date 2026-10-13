package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB)\b\u0002\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/W15084;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/Map;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class W15084 extends wX26196 {
    private static int D8871 = 1;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int setPivotYN16904;

    private W15084(Map<String, ? extends Object> map, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.getPivotYV11332.INSTANCE.component5(), map, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.W15084$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/CurrentLocationSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/CurrentLocationSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/CurrentLocation;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/CurrentLocationResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static final byte[] $$c = null;
        private static final int $$d = 0;
        private static int $10;
        private static int $11;
        private static int component5;
        private static char[] component9;
        private static int setPivotYN16904;
        private static long vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, byte r7, int r8) {
            /*
                int r8 = r8 + 112
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.W15084.Companion.$$c
                int r7 = r7 * 3
                int r1 = r7 + 1
                int r6 = r6 * 3
                int r6 = r6 + 4
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r8 = r6
                r3 = r7
                r4 = r2
                goto L29
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L23:
                r3 = r0[r6]
                r5 = r8
                r8 = r6
                r6 = r3
                r3 = r5
            L29:
                int r6 = r6 + r3
                int r8 = r8 + 1
                r3 = r8
                r8 = r6
                r6 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.W15084.Companion.$$e(int, byte, int):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void c(int r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.W15084.Companion.$$a
                int r8 = r8 * 3
                int r8 = 6 - r8
                int r6 = 115 - r6
                int r1 = r7 + 1
                byte[] r1 = new byte[r1]
                r2 = 0
                r3 = r8
                if (r0 != 0) goto L12
                r4 = r2
                goto L2d
            L12:
                r8 = r6
                r6 = r3
                r3 = r2
            L15:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r6 = r6 + 1
                if (r3 != r7) goto L24
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L24:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2d:
                int r6 = -r6
                int r3 = r3 + r6
                int r6 = r3 + (-5)
                r3 = r8
                r8 = r6
                r6 = r3
                r3 = r4
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.W15084.Companion.c(int, int, int, java.lang.Object[]):void");
        }

        static void init$0() {
            $$a = new byte[]{110, 65, 124, -53, -17, -6, -14, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9};
            $$b = WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL;
        }

        static void init$1() {
            $$c = new byte[]{67, -86, 47, 32};
            $$d = 221;
        }

        private Companion() {
        }

        private static void a(String str, int i, Object[] objArr) throws Throwable {
            char[] charArray;
            int i2 = 2 % 2;
            int i3 = $10 + 1;
            int i4 = i3 % 128;
            $11 = i4;
            int i5 = i3 % 2;
            if (str != null) {
                int i6 = i4 + 35;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    charArray = str.toCharArray();
                    int i7 = 69 / 0;
                } else {
                    charArray = str.toCharArray();
                }
            } else {
                charArray = str;
            }
            cl clVar = new cl();
            char[] pivotYN16904 = cl.setPivotYN16904(vD14832N6715 ^ (-8731904840774042312L), charArray, i);
            clVar.vD14832N6715 = 4;
            while (clVar.vD14832N6715 < pivotYN16904.length) {
                int i8 = $11 + 21;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
                int i10 = clVar.vD14832N6715;
                try {
                    Object[] objArr2 = {Long.valueOf(pivotYN16904[clVar.vD14832N6715] ^ pivotYN16904[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(vD14832N6715)};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(353813021);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - Drawable.resolveOpacity(0, 0), (char) (43652 - Drawable.resolveOpacity(0, 0)), 752 - Color.red(0), 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    pivotYN16904[i10] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {clVar, clVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.getCapsMode("", 0, 0) + 5420, 257882757, false, $$e(0, (byte) 0, 2), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            objArr[0] = new String(pivotYN16904, 4, pivotYN16904.length - 4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static W15084 D8871(D8871<N14078, ? extends Throwable> d8871) {
            int i = 2 % 2;
            Object obj = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            Object[] objArr13 = 0;
            if (!(d8871 instanceof vD14832N6715)) {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new W15084(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            }
            int i2 = component5;
            int i3 = (i2 & 119) + (i2 | 119);
            setPivotYN16904 = i3 % 128;
            int i4 = i3 % 2;
            N14078 n14078 = (N14078) ((vD14832N6715) d8871).setPivotYN16904;
            Location location = (Location) N14078.vD14832N6715(new Object[]{n14078}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1342293912, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1342293914);
            boolean zD8871 = n14078.D8871();
            List list = (List) N14078.vD14832N6715(new Object[]{n14078}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1787409004, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1787409005);
            long pivotYN16904 = n14078.setPivotYN16904();
            component1H27181 component1h27181Component8 = n14078.component8();
            boolean z = false;
            if (n14078.component9().isEmpty()) {
                int i5 = component5;
                int i6 = (i5 ^ 45) + ((i5 & 45) << 1);
                setPivotYN16904 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                int i8 = setPivotYN16904 + 47;
                component5 = i8 % 128;
                if (i8 % 2 == 0) {
                    z = true;
                }
            }
            if (zD8871 && z) {
                A22588.vD14832N6715();
                A22588.vD14832N6715();
                if (location != null) {
                    N11182.Companion companion = N11182.INSTANCE;
                    Object[] objArr14 = {N11182.Companion.component5(location, list, pivotYN16904, component1h27181Component8)};
                    W15084 w15084 = new W15084((Map) N11182.component9(setOnLongClickListenerR17701.setPivotYN16904(), 1202698205, setOnLongClickListenerR17701.setPivotYN16904(), -1202698205, setOnLongClickListenerR17701.setPivotYN16904(), setOnLongClickListenerR17701.setPivotYN16904(), objArr14), wX26196.setPivotYN16904.component13.INSTANCE, objArr10 == true ? 1 : 0);
                    int i9 = setPivotYN16904 + 39;
                    component5 = i9 % 128;
                    if (i9 % 2 == 0) {
                        return w15084;
                    }
                    (objArr11 == true ? 1 : 0).hashCode();
                    throw null;
                }
            }
            if (zD8871) {
                int i10 = component5;
                int i11 = (i10 ^ 91) + ((i10 & 91) << 1);
                setPivotYN16904 = i11 % 128;
                if (i11 % 2 == 0) {
                    (objArr12 == true ? 1 : 0).hashCode();
                    throw null;
                }
                if (z && location == null) {
                    lN31375.Companion companion2 = lN31375.INSTANCE;
                    return new W15084(lN31375.Companion.component5(list, pivotYN16904, component1h27181Component8).setPivotYN16904(), wX26196.setPivotYN16904.component9.INSTANCE, objArr9 == true ? 1 : 0);
                }
            }
            if (!zD8871) {
                int i12 = setPivotYN16904 + 93;
                component5 = i12 % 128;
                if (i12 % 2 != 0) {
                    (objArr13 == true ? 1 : 0).hashCode();
                    throw null;
                }
                if (z) {
                    W15084 w15085 = new W15084(objArr8 == true ? 1 : 0, wX26196.setPivotYN16904.component5.INSTANCE, objArr7 == true ? 1 : 0);
                    int i13 = component5 + 15;
                    setPivotYN16904 = i13 % 128;
                    int i14 = i13 % 2;
                    return w15085;
                }
            }
            if (zD8871) {
                int i15 = component5 + GapComposerKt.nodeKey;
                setPivotYN16904 = i15 % 128;
                if (i15 % 2 == 0) {
                    obj.hashCode();
                    throw null;
                }
                if (!z) {
                    W15084 w15086 = new W15084(objArr6 == true ? 1 : 0, wX26196.setPivotYN16904.D8871.INSTANCE, objArr5 == true ? 1 : 0);
                    int i16 = component5;
                    int i17 = (i16 ^ 27) + ((i16 & 27) << 1);
                    setPivotYN16904 = i17 % 128;
                    int i18 = i17 % 2;
                    return w15086;
                }
            }
            return new W15084(objArr4 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr3 == true ? 1 : 0);
        }

        private static void b(boolean z, String str, int[] iArr, Object[] objArr) throws Throwable {
            long j;
            char c;
            String str2 = str;
            int i = 2;
            int i2 = 2 % 2;
            Object bytes = str2;
            if (str2 != null) {
                int i3 = $11 + 71;
                $10 = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 5 / 0;
                    bytes = str2.getBytes("ISO-8859-1");
                } else {
                    bytes = str2.getBytes("ISO-8859-1");
                }
            }
            byte[] bArr = (byte[]) bytes;
            co coVar = new co();
            int i5 = iArr[0];
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            char[] cArr = component9;
            if (cArr != null) {
                int length = cArr.length;
                j = 0;
                char[] cArr2 = new char[length];
                int i9 = 0;
                while (i9 < length) {
                    int i10 = i;
                    int i11 = $11 + 119;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr[i9])};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1270499692);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(59 - Color.alpha(0), (char) (ViewConfiguration.getEdgeSlop() >> 16), 4457 - TextUtils.indexOf("", "", 0, 0), 420416783, false, $$e(0, (byte) 0, 3), new Class[]{Integer.TYPE});
                            }
                            cArr2[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                            i9 /= 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr3 = {Integer.valueOf(cArr[i9])};
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1270499692);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getTapTimeout() >> 16) + 59, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), ExpandableListView.getPackedPositionChild(0L) + 4458, 420416783, false, $$e(0, (byte) 0, 3), new Class[]{Integer.TYPE});
                        }
                        cArr2[i9] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                        i9++;
                    }
                    i = i10;
                }
                cArr = cArr2;
            } else {
                j = 0;
            }
            int i12 = i;
            char[] cArr3 = new char[i6];
            System.arraycopy(cArr, i5, cArr3, 0, i6);
            if (bArr != null) {
                char[] cArr4 = new char[i6];
                coVar.component5 = 0;
                char c2 = 0;
                while (coVar.component5 < i6) {
                    if (bArr[coVar.component5] == 1) {
                        int i13 = coVar.component5;
                        char c3 = cArr3[coVar.component5];
                        Object[] objArr4 = new Object[i12];
                        objArr4[1] = Integer.valueOf(c2);
                        objArr4[0] = Integer.valueOf(c3);
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1589966753);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 52, (char) (15379 - Color.argb(0, 0, 0, 0)), KeyEvent.getDeadChar(0, 0) + 2256, -208778180, false, "q", new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i13] = ((Character) ((Method) objComponent7).invoke(null, objArr4)).charValue();
                    } else {
                        int i14 = coVar.component5;
                        Object[] objArr5 = {Integer.valueOf(cArr3[coVar.component5]), Integer.valueOf(c2)};
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-1656784792);
                        if (objComponent8 == null) {
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(50 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (Color.red(0) + 27302), 2980 - (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)), -813024245, false, $$e(0, (byte) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i14] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                    }
                    c2 = cArr4[coVar.component5];
                    Object[] objArr6 = {coVar, coVar};
                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(787585964);
                    if (objComponent9 == null) {
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 51, (char) Color.blue(0), 7092 - Gravity.getAbsoluteGravity(0, 0), 2084888527, false, $$e(0, (byte) 0, 7), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent9).invoke(null, objArr6);
                    i12 = 2;
                }
                cArr3 = cArr4;
            }
            if (i8 > 0) {
                char[] cArr5 = new char[i6];
                System.arraycopy(cArr3, 0, cArr5, 0, i6);
                int i15 = i6 - i8;
                System.arraycopy(cArr5, 0, cArr3, i15, i8);
                System.arraycopy(cArr5, i8, cArr3, 0, i15);
            }
            if (z) {
                char[] cArr6 = new char[i6];
                coVar.component5 = 0;
                while (coVar.component5 < i6) {
                    cArr6[coVar.component5] = cArr3[(i6 - coVar.component5) - 1];
                    coVar.component5++;
                }
                int i16 = $10 + 87;
                $11 = i16 % 128;
                c = 2;
                int i17 = i16 % 2;
                cArr3 = cArr6;
            } else {
                c = 2;
            }
            if (i7 > 0) {
                coVar.component5 = 0;
                while (coVar.component5 < i6) {
                    cArr3[coVar.component5] = (char) (cArr3[coVar.component5] - iArr[c]);
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
            component5 = 0;
            setPivotYN16904 = 1;
            vD14832N6715 = -5350282336266506411L;
            component9 = new char[]{46653, 46715, 46672, 46680, 46680, 46714, 46715, 46672, 46680, 46680, 46714, 46715, 46683, 46684, 46719, 46712, 46678, 46682, 46753, 46657, 46709, 46677, 46683, 46681, 46754, 46686, 46676, 46715, 46656, 46684, 46686, 46683, 46675, 46672, 46680, 46680, 46597, 46709, 46661, 46667, 46660, 46660, 46670, 46656, 46714, 46656, 46661, 46660, 46662, 46660, 46610, 46662, 46660, 46670, 46675, 46668, 46692, 46692, 46664, 46668, 46673, 46696, 46698, 46666, 46656, 46661, 46608, 46656, 46657, 46665, 46671, 46716, 46691, 46696, 46664, 46661, 46660, 46703, 46693, 46665, 46665, 46663, 46693, 46764, 46757, 46673, 46670, 46613, 46665, 46670, 46670, 46645, 46706, 46673, 46670, 46662, 46667, 46674, 46675, 46698, 46690, 46690, 46688, 46670, 46664, 46657, 46665, 46664, 46691, 46693, 46675, 46696, 46688, 46662, 46666, 46664, 46663, 46705, 46618, 46666, 46656, 46661, 46660, 46662, 46660, 46701, 46700, 46667, 46668, 46703, 46696, 46665, 46669, 46665, 46667, 46666, 46699, 46614, 46660, 46699, 46701, 46666, 46656, 46661, 46660, 46662, 46660, 46701, 46700, 46667, 46668, 46703, 46693, 46661, 46667, 46665, 46674, 46688, 46674, 46789, 46802, 46793, 46784, 46786, 46784, 46784, 46794, 46845, 46784, 46800, 46797, 46794, 46791, 46846, 46674, 46795, 46798, 46799, 46793, 46835, 46834, 46788, 46795, 46795, 46796, 46793, 46790, 46792, 46842, 46832, 46839, 46737, 46836, 46830, 46833, 46833, 46726, 46839, 46826, 46835, 46840, 46736, 46826, 46829, 46830, 46827};
        }

        /* JADX WARN: Code duplicated, block: B:103:0x0ed3 A[Catch: all -> 0x1359, TRY_LEAVE, TryCatch #19 {all -> 0x1359, blocks: (B:101:0x0ec6, B:103:0x0ed3), top: B:360:0x0ec6 }] */
        /* JADX WARN: Code duplicated, block: B:106:0x0f07  */
        /* JADX WARN: Code duplicated, block: B:140:0x1101 A[Catch: Exception -> 0x1379, all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:143:0x1151 A[Catch: Exception -> 0x1379, all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:147:0x11c2 A[Catch: all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:149:0x11df A[Catch: all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:151:0x11fb A[Catch: all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:153:0x1216 A[Catch: all -> 0x1394, IOException -> 0x139f, TryCatch #16 {, blocks: (B:92:0x0e4c, B:93:0x0e5a, B:95:0x0e66, B:100:0x0ec2, B:108:0x0f11, B:113:0x0fa8, B:137:0x10f0, B:138:0x10f3, B:140:0x1101, B:141:0x113b, B:143:0x1151, B:144:0x118d, B:145:0x119e, B:147:0x11c2, B:149:0x11df, B:151:0x11fb, B:153:0x1216, B:155:0x1231, B:157:0x1239, B:175:0x133d, B:176:0x1340, B:206:0x1379, B:207:0x1393, B:178:0x1342, B:180:0x1348, B:181:0x1349, B:186:0x134f, B:188:0x1355, B:189:0x1356, B:194:0x135c, B:196:0x1364, B:197:0x1365, B:199:0x1367, B:201:0x1371, B:202:0x1372), top: B:346:0x0e4c }] */
        /* JADX WARN: Code duplicated, block: B:217:0x13a1  */
        /* JADX WARN: Code duplicated, block: B:224:0x1436 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:225:0x1437  */
        /* JADX WARN: Code duplicated, block: B:227:0x14a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:228:0x14aa  */
        /* JADX WARN: Code duplicated, block: B:230:0x14af  */
        /* JADX WARN: Code duplicated, block: B:233:0x150d A[Catch: all -> 0x189c, TRY_LEAVE, TryCatch #24 {all -> 0x189c, blocks: (B:231:0x14c7, B:233:0x150d, B:239:0x155f), top: B:363:0x14c7 }] */
        /* JADX WARN: Code duplicated, block: B:235:0x1551  */
        /* JADX WARN: Code duplicated, block: B:238:0x155b  */
        /* JADX WARN: Code duplicated, block: B:245:0x15f0  */
        /* JADX WARN: Code duplicated, block: B:248:0x1657 A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:253:0x181c A[LOOP:2: B:244:0x15ee->B:253:0x181c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:255:0x1830 A[EDGE_INSN: B:255:0x1830->B:256:0x1893 BREAK  A[LOOP:1: B:236:0x1555->B:378:0x1555]] */
        /* JADX WARN: Code duplicated, block: B:258:0x189b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:267:0x18c5 A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:271:0x19a0  */
        /* JADX WARN: Code duplicated, block: B:272:0x1a53  */
        /* JADX WARN: Code duplicated, block: B:275:0x1aff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:276:0x1b00  */
        /* JADX WARN: Code duplicated, block: B:279:0x1b71 A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:283:0x1c39  */
        /* JADX WARN: Code duplicated, block: B:284:0x1cad  */
        /* JADX WARN: Code duplicated, block: B:287:0x1d12 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:288:0x1d13  */
        /* JADX WARN: Code duplicated, block: B:291:0x1d34 A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:295:0x1e24  */
        /* JADX WARN: Code duplicated, block: B:296:0x1e9b  */
        /* JADX WARN: Code duplicated, block: B:299:0x1f56 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:300:0x1f57  */
        /* JADX WARN: Code duplicated, block: B:303:0x1fc4 A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:307:0x209b  */
        /* JADX WARN: Code duplicated, block: B:309:0x2161  */
        /* JADX WARN: Code duplicated, block: B:375:0x1830 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:376:0x1755 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:382:0x0c8e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:383:0x0d6a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:384:0x13bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:389:0x1317 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:390:0x1317 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:391:0x1317 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x0b58  */
        /* JADX WARN: Code duplicated, block: B:74:0x0b5c  */
        /* JADX WARN: Code duplicated, block: B:77:0x0b7e A[Catch: all -> 0x2219, TryCatch #20 {all -> 0x2219, blocks: (B:5:0x006d, B:7:0x007a, B:8:0x00b2, B:17:0x0279, B:19:0x0286, B:20:0x02bf, B:29:0x0490, B:31:0x049d, B:32:0x04e2, B:41:0x068d, B:43:0x069a, B:44:0x06d5, B:60:0x0950, B:62:0x0966, B:64:0x09bc, B:246:0x163e, B:248:0x1657, B:249:0x16a3, B:265:0x18b8, B:267:0x18c5, B:268:0x18fb, B:277:0x1b64, B:279:0x1b71, B:280:0x1bb0, B:289:0x1d27, B:291:0x1d34, B:292:0x1d78, B:301:0x1fb7, B:303:0x1fc4, B:304:0x1ffc, B:75:0x0b66, B:77:0x0b7e, B:79:0x0bca), top: B:362:0x0059 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x0bc8  */
        /* JADX WARN: Code duplicated, block: B:83:0x0d61 A[LOOP:3: B:73:0x0b5a->B:83:0x0d61, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:86:0x0d9a  */
        /* JADX WARN: Code duplicated, block: B:88:0x0e22  */
        /* JADX WARN: Code duplicated, block: B:90:0x0e42  */
        /* JADX WARN: Code duplicated, block: B:98:0x0e8d A[Catch: all -> 0x1366, TryCatch #2 {all -> 0x1366, blocks: (B:96:0x0e80, B:98:0x0e8d, B:99:0x0ebc), top: B:335:0x0e80 }] */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x123a, code lost:
        
            r0 = new java.lang.Object[]{new int[1], new int[1], r5, null, new int[1]};
            r5 = (java.lang.String) java.lang.Class.forName(r32).getField(r7).get(r9);
            ((int[]) r0[1])[0] = r51;
            ((int[]) r0[0])[0] = r51 ^ 20;
            r4 = (int) android.os.Process.getElapsedCpuTime();
            r5 = ~((-26503562) | r4);
            r6 = ~r4;
            r5 = r5 | (~(189672246 | r6));
            r7 = ~(26503561 | r6);
            r8 = ((1920480267 + ((r5 | r7) * (-516))) + (((~(r4 | (-17049857))) | (~((-172622391) | r6))) * 516)) + ((172622390 | r7) * 516);
            r4 = ((r8 | 16) << 1) - (r8 ^ 16);
            r5 = r4 * 860;
            r6 = -(-(r53 * (-858)));
            r7 = ((r5 | r6) << 1) - (r5 ^ r6);
            r5 = ((r4 ^ r51) | (r4 & r51)) * (-859);
            r6 = (r7 ^ r5) + ((r5 & r7) << 1);
            r5 = ~((r40 ^ r4) | (r40 & r4));
            r7 = ~r4;
            r8 = ~r53;
            r7 = (r7 & r8) | (r7 ^ r8);
            r7 = ~((r7 & r51) | (r7 ^ r51));
            r6 = r6 + (((r5 & r7) | (r5 ^ r7)) * 859);
            r5 = ~((r8 ^ r13) | (r8 & r13));
            r4 = ~((r4 & r8) | (r8 ^ r4));
            r4 = ((r4 & r5) | (r5 ^ r4)) * 859;
            r5 = ((r6 | r4) << 1) - (r4 ^ r6);
            r4 = r5 << 13;
            r4 = (r4 & (~r5)) | ((~r4) & r5);
            r4 = r4 ^ (r4 >>> 17);
            ((int[]) r0[4])[0] = r4 ^ (r4 << 5);
            r41 = 0;
         */
        /* JADX WARN: Type inference failed for: r15v18 */
        /* JADX WARN: Type inference failed for: r15v9 */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object[] D8871(android.content.Context r50, int r51, int r52, int r53) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 8747
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.W15084.Companion.D8871(android.content.Context, int, int, int):java.lang.Object[]");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = D8871;
        int i2 = ((i | 77) << 1) - (i ^ 77);
        setPivotYN16904 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ W15084(Map map, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, setpivotyn16904);
    }
}
