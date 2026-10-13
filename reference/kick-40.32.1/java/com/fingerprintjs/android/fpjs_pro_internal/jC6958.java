package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/jC6958;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/Boolean;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class jC6958 extends wX26196 {
    private static int D8871 = 0;
    private static int component9 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    private jC6958(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.hY16199.INSTANCE.component5(), bool, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.jC6958$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/IsActiveNetworkVpnSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/IsActiveNetworkVpnSignal;", "isActiveNetworkVpn", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/vpn/VpnInfoProvider$IsActiveNetworkVpnError;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/vpn/IsActiveNetworkVpn;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static char[] D8871;
        private static int component5;
        private static char component9;
        private static int vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r7, short r8, int r9) {
            /*
                int r9 = r9 * 4
                int r9 = 3 - r9
                int r7 = r7 * 2
                int r7 = r7 + 1
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.jC6958.Companion.$$a
                int r8 = r8 * 2
                int r8 = r8 + 67
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r9
                r5 = r2
                r9 = r7
                goto L2d
            L17:
                r3 = r2
            L18:
                int r9 = r9 + 1
                byte r4 = (byte) r8
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L27
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L27:
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r6
            L2d:
                int r8 = -r8
                int r8 = r8 + r9
                r9 = r3
                r3 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.jC6958.Companion.$$c(int, short, int):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{10, -109, 37, Ascii.GS};
            $$b = 58;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static jC6958 vD14832N6715(D8871<Boolean, ? extends ak.vD14832N6715> d8871) {
            wX26196.setPivotYN16904.vD14832N6715 vd14832n6715;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (d8871 instanceof vD14832N6715) {
                Boolean bool = (Boolean) ((vD14832N6715) d8871).setPivotYN16904;
                bool.booleanValue();
                return new jC6958(bool, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            }
            if (d8871 instanceof setPivotYN16904) {
                ak.vD14832N6715 vd14832n6716 = (ak.vD14832N6715) ((setPivotYN16904) d8871).setPivotYN16904;
                if (Intrinsics.areEqual(vd14832n6716, ak.vD14832N6715.component9.INSTANCE)) {
                    vd14832n6715 = wX26196.setPivotYN16904.component5.INSTANCE;
                } else {
                    if (!Intrinsics.areEqual(vd14832n6716, ak.vD14832N6715.D8871.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    vd14832n6715 = wX26196.setPivotYN16904.vD14832N6715.INSTANCE;
                }
                return new jC6958(objArr2 == true ? 1 : 0, vd14832n6715, objArr == true ? 1 : 0);
            }
            throw new NoWhenBranchMatchedException();
        }

        private static void a(byte b, int i, String str, Object[] objArr) throws Throwable {
            char[] charArray;
            int i2;
            char c = 2;
            int i3 = 2 % 2;
            if (str != null) {
                int i4 = $10 + 57;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                charArray = str.toCharArray();
            } else {
                charArray = str;
            }
            char[] cArr = charArray;
            ce ceVar = new ce();
            char[] cArr2 = D8871;
            if (cArr2 != null) {
                int i6 = $10 + 69;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i8 = 0;
                while (i8 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i8])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (Color.red(0) + 8065), 3216 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 304954017, false, $$c(0, (short) 25, 0), new Class[]{Integer.TYPE});
                        }
                        cArr3[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        i8++;
                        c = c;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            char c2 = c;
            Object[] objArr3 = {Integer.valueOf(component9)};
            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1083735746);
            if (objComponent6 == null) {
                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 52, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 8065), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 3216, 304954017, false, $$c(0, (short) 25, 0), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i9 = $10;
                int i10 = i9 + 113;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
                int i12 = i9 + 113;
                $11 = i12 % 128;
                int i13 = i12 % 2;
            } else {
                i2 = i;
            }
            int i14 = 1;
            if (i2 > 1) {
                ceVar.component5 = 0;
                while (ceVar.component5 < i2) {
                    int i15 = $10 + 89;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    ceVar.D8871 = cArr[ceVar.component5];
                    ceVar.setPivotYN16904 = cArr[ceVar.component5 + i14];
                    if (ceVar.D8871 == ceVar.setPivotYN16904) {
                        int i17 = $10 + 73;
                        $11 = i17 % 128;
                        if (i17 % 2 == 0) {
                            cArr4[ceVar.component5] = (char) (ceVar.D8871 * b);
                            cArr4[ceVar.component5 << i14] = (char) (ceVar.setPivotYN16904 + b);
                        } else {
                            cArr4[ceVar.component5] = (char) (ceVar.D8871 - b);
                            cArr4[ceVar.component5 + i14] = (char) (ceVar.setPivotYN16904 - b);
                        }
                        i14 = i14;
                    } else {
                        Object[] objArr4 = new Object[13];
                        objArr4[12] = ceVar;
                        objArr4[11] = Integer.valueOf(cCharValue);
                        objArr4[10] = ceVar;
                        objArr4[9] = ceVar;
                        objArr4[8] = Integer.valueOf(cCharValue);
                        objArr4[7] = ceVar;
                        objArr4[6] = ceVar;
                        objArr4[5] = Integer.valueOf(cCharValue);
                        objArr4[4] = ceVar;
                        objArr4[3] = ceVar;
                        objArr4[c2] = Integer.valueOf(cCharValue);
                        objArr4[i14] = ceVar;
                        objArr4[0] = ceVar;
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.makeMeasureSpec(0, 0) + 52, (char) (47645 - (Process.myTid() >> 22)), ((Process.getThreadPriority(0) + 20) >> 6) + 5214, 309857053, false, $$c(0, (short) 27, 0), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue() == ceVar.component13) {
                            int i18 = $10 + 69;
                            $11 = i18 % 128;
                            int i19 = i18 % 2;
                            Object[] objArr5 = new Object[11];
                            objArr5[10] = ceVar;
                            objArr5[9] = Integer.valueOf(cCharValue);
                            objArr5[8] = ceVar;
                            objArr5[7] = Integer.valueOf(cCharValue);
                            objArr5[6] = Integer.valueOf(cCharValue);
                            objArr5[5] = ceVar;
                            objArr5[4] = ceVar;
                            objArr5[3] = Integer.valueOf(cCharValue);
                            objArr5[c2] = Integer.valueOf(cCharValue);
                            objArr5[i14] = ceVar;
                            objArr5[0] = ceVar;
                            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                            if (objComponent8 == null) {
                                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf((CharSequence) "", '0', 0) + 53, (char) ((-1) - MotionEvent.axisFromString("")), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 5575, 999494287, false, $$c(0, (short) 0, 0), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                            int i20 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                            cArr4[ceVar.component5] = cArr2[iIntValue];
                            cArr4[ceVar.component5 + 1] = cArr2[i20];
                        } else if (ceVar.component9 == ceVar.vD14832N6715) {
                            int i21 = $10 + 21;
                            $11 = i21 % 128;
                            int i22 = i21 % 2;
                            ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                            ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                            int i23 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                            int i24 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                            cArr4[ceVar.component5] = cArr2[i23];
                            cArr4[ceVar.component5 + 1] = cArr2[i24];
                        } else {
                            int i25 = (ceVar.component9 * cCharValue) + ceVar.component13;
                            int i26 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                            cArr4[ceVar.component5] = cArr2[i25];
                            cArr4[ceVar.component5 + 1] = cArr2[i26];
                        }
                    }
                    ceVar.component5 += 2;
                    i14 = i14;
                }
            }
            for (int i27 = 0; i27 < i; i27++) {
                cArr4[i27] = (char) (cArr4[i27] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        public static void component9(long j, long j2) throws Throwable {
            long j3;
            int i = 2 % 2;
            int i2 = component5 + 41;
            vD14832N6715 = i2 % 128;
            if (i2 % 2 == 0) {
                j3 = j | (j2 >> 11);
                u.class.getField("vD14832N6715").get(null);
            } else {
                j3 = j ^ (j2 << 32);
                u.class.getField("vD14832N6715").get(null);
            }
            try {
                Object[] objArr = {Long.valueOf(j3)};
                Object[] objArr2 = new Object[1];
                a((byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 7, "\u0006\u0004\u0005\u0007\t\u0003㘮", objArr2);
                Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, objArr);
                Object obj = w.class.getField("INSTANCE").get(null);
                Method method2 = w.class.getMethod("D8871", null);
                method2.setAccessible(true);
                Object objInvoke2 = method2.invoke(obj, null);
                Object[] objArr3 = new Object[1];
                a((byte) (Process.getGidForName("") + 67), 3 - View.getDefaultSize(0, 0), "㗭㗭㗮", objArr3);
                Object[] objArr4 = {(String) objArr3[0], objInvoke};
                Object[] objArr5 = new Object[1];
                a((byte) (11 - Drawable.resolveOpacity(0, 0)), 3 - ExpandableListView.getPackedPositionGroup(0L), "\u000e\u0005㗹", objArr5);
                Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
                method3.setAccessible(true);
                method3.invoke(objInvoke2, objArr4);
                int i3 = vD14832N6715 + 95;
                component5 = i3 % 128;
                int i4 = i3 % 2;
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
            vD14832N6715 = 1;
            D8871 = new char[]{3900, 15082, 15057, 3902, 15049, 15059, 15056, 15044, 3899, 3901, 14995, 15040, 14996, 15061, 15043, 3898};
            component9 = (char) 3899;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = component9;
        int i2 = (i ^ 89) + ((i & 89) << 1);
        D8871 = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        defaultConstructorMarker.hashCode();
        throw null;
    }

    public /* synthetic */ jC6958(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, setpivotyn16904);
    }
}
