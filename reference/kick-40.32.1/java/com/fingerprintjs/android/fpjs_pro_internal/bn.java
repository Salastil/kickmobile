package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public interface bn {
    bo component5(bp bpVar, Integer num, Integer num2, Function0<Unit> function0, Function0<Unit> function1);

    public static final class component9 {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static short[] D8871;
        private static int component5;
        private static int component8;
        private static int component9;
        private static int sG29839;
        private static int setPivotYN16904;
        private static byte[] vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r6, int r7, int r8) {
            /*
                int r6 = 111 - r6
                int r7 = r7 * 3
                int r0 = r7 + 1
                int r8 = r8 * 2
                int r8 = 4 - r8
                byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.bn.component9.$$a
                byte[] r0 = new byte[r0]
                r2 = 0
                if (r1 != 0) goto L15
                r3 = r8
                r4 = r2
                r8 = r7
                goto L29
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L23:
                r3 = r1[r8]
                r5 = r8
                r8 = r6
                r6 = r3
                r3 = r5
            L29:
                int r6 = -r6
                int r6 = r6 + r8
                int r8 = r3 + 1
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.bn.component9.$$c(byte, int, int):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{Ascii.SO, -58, 119, -50};
            $$b = JfifUtil.MARKER_EOI;
        }

        public static /* synthetic */ bo component9(bn bnVar, bp bpVar) {
            int i = 2 % 2;
            int i2 = sG29839 + 45;
            component8 = i2 % 128;
            int i3 = i2 % 2;
            bo boVarComponent5 = bnVar.component5(bpVar, null, null, new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.bn.component9.2
                public final void component9() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() {
                    component9();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.bn.component9.5
                public final void component9() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() {
                    component9();
                    return Unit.INSTANCE;
                }
            });
            int i4 = component8 + GapComposerKt.nodeKey;
            sG29839 = i4 % 128;
            int i5 = i4 % 2;
            return boVarComponent5;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0077  */
        /* JADX WARN: Code duplicated, block: B:66:0x0246  */
        /* JADX WARN: Code duplicated, block: B:67:0x0261  */
        private static void a(byte b, int i, short s, int i2, int i3, Object[] objArr) throws Throwable {
            int i4;
            long j;
            boolean z;
            int length;
            byte[] bArr;
            int i5 = 2 % 2;
            ch chVar = new ch();
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr2 = {Integer.valueOf(i3), Integer.valueOf(component5)};
                int i6 = 572769811;
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(572769811);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Drawable.resolveOpacity(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 58886), 6887 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 1888911984, false, $$c((byte) 0, 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                if (iIntValue == -1) {
                    int i7 = $11 + 53;
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
                    int i8 = $11 + 5;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    byte[] bArr2 = vD14832N6715;
                    if (bArr2 != null) {
                        int length2 = bArr2.length;
                        byte[] bArr3 = new byte[length2];
                        int i10 = 0;
                        while (i10 < length2) {
                            int i11 = i6;
                            Object[] objArr3 = {Integer.valueOf(bArr2[i10])};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(58 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'), 1539 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -899819233, false, "l", new Class[]{Integer.TYPE});
                            }
                            bArr3[i10] = ((Byte) ((Method) objComponent6).invoke(null, objArr3)).byteValue();
                            i10++;
                            i6 = i11;
                        }
                        bArr2 = bArr3;
                    }
                    int i12 = i6;
                    j = -7710232700957351395L;
                    if (bArr2 != null) {
                        byte[] bArr4 = vD14832N6715;
                        Object[] objArr4 = {Integer.valueOf(i2), Integer.valueOf(component9)};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i12);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(((Process.getThreadPriority(0) + 20) >> 6) + 52, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 58885), 6885 - TextUtils.indexOf((CharSequence) "", '0'), 1888911984, false, $$c((byte) 0, 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr4[((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue()]) ^ (-7710232700957351395L))) + ((int) (((long) component5) ^ (-7710232700957351395L))));
                    } else {
                        iIntValue = (short) (((short) (((long) D8871[i2 + ((int) (((long) component9) ^ (-7710232700957351395L)))]) ^ (-7710232700957351395L))) + ((int) (((long) component5) ^ (-7710232700957351395L))));
                    }
                } else {
                    j = -7710232700957351395L;
                }
                if (iIntValue > 0) {
                    chVar.D8871 = ((i2 + iIntValue) - 2) + ((int) (((long) component9) ^ j)) + i4;
                    Object[] objArr5 = {chVar, Integer.valueOf(i), Integer.valueOf(setPivotYN16904), sb};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(74627481);
                    if (objComponent8 == null) {
                        int keyRepeatTimeout = 52 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
                        int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 4726;
                        byte b2 = (byte) ($$b & 7);
                        byte b3 = (byte) (b2 - 1);
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatTimeout, cIndexOf, pressedStateDuration, 1455947258, false, $$c(b2, b3, b3), new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objComponent8).invoke(null, objArr5)).append(chVar.vD14832N6715);
                    chVar.component9 = chVar.vD14832N6715;
                    byte[] bArr5 = vD14832N6715;
                    if (bArr5 != null) {
                        int i13 = $11 + GapComposerKt.nodeKey;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            length = bArr5.length;
                            bArr = new byte[length];
                        } else {
                            length = bArr5.length;
                            bArr = new byte[length];
                        }
                        for (int i14 = 0; i14 < length; i14++) {
                            bArr[i14] = (byte) (((long) bArr5[i14]) ^ j);
                        }
                        bArr5 = bArr;
                    }
                    if (bArr5 != null) {
                        int i15 = $10 + 25;
                        $11 = i15 % 128;
                        int i16 = i15 % 2;
                        z = true;
                    } else {
                        z = false;
                    }
                    chVar.setPivotYN16904 = 1;
                    int i17 = $11 + 27;
                    $10 = i17 % 128;
                    int i18 = i17 % 2;
                    while (chVar.setPivotYN16904 < iIntValue) {
                        int i19 = $10 + 105;
                        $11 = i19 % 128;
                        if (i19 % 2 == 0) {
                            int i20 = 85 / 0;
                            if (z) {
                                byte[] bArr6 = vD14832N6715;
                                int i21 = chVar.D8871;
                                chVar.D8871 = i21 - 1;
                                chVar.vD14832N6715 = (char) (chVar.component9 + (((byte) (((byte) (((long) bArr6[i21]) ^ j)) + s)) ^ b));
                            } else {
                                short[] sArr = D8871;
                                int i22 = chVar.D8871;
                                chVar.D8871 = i22 - 1;
                                chVar.vD14832N6715 = (char) (chVar.component9 + (((short) (((short) (((long) sArr[i22]) ^ j)) + s)) ^ b));
                            }
                        } else if (z) {
                            byte[] bArr7 = vD14832N6715;
                            int i23 = chVar.D8871;
                            chVar.D8871 = i23 - 1;
                            chVar.vD14832N6715 = (char) (chVar.component9 + (((byte) (((byte) (((long) bArr7[i23]) ^ j)) + s)) ^ b));
                        } else {
                            short[] sArr2 = D8871;
                            int i24 = chVar.D8871;
                            chVar.D8871 = i24 - 1;
                            chVar.vD14832N6715 = (char) (chVar.component9 + (((short) (((short) (((long) sArr2[i24]) ^ j)) + s)) ^ b));
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

        public static void vD14832N6715(long j, long j2) throws Throwable {
            int i = 2 % 2;
            int i2 = component8 + 121;
            sG29839 = i2 % 128;
            int i3 = i2 % 2;
            long j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
            int i4 = sG29839 + 121;
            component8 = i4 % 128;
            int i5 = i4 % 2;
            try {
                Object[] objArr = {Long.valueOf(j3)};
                Object[] objArr2 = new Object[1];
                a((byte) View.combineMeasuredStates(0, 0), 2019388552 - TextUtils.indexOf("", "", 0, 0), (short) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (-552314477) + (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (-122) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr2);
                Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, objArr);
                Object obj = w.class.getField("INSTANCE").get(null);
                Method method2 = w.class.getMethod("D8871", null);
                method2.setAccessible(true);
                Object objInvoke2 = method2.invoke(obj, null);
                Object[] objArr3 = new Object[1];
                a((byte) ((Process.getThreadPriority(0) + 20) >> 6), 2019388483 + (KeyEvent.getMaxKeyCode() >> 16), (short) ExpandableListView.getPackedPositionType(0L), View.combineMeasuredStates(0, 0) - 552314469, (-122) - (Process.myPid() >> 22), objArr3);
                Object[] objArr4 = {(String) objArr3[0], objInvoke};
                Object[] objArr5 = new Object[1];
                a((byte) TextUtils.getOffsetAfter("", 0), 2019388546 - ExpandableListView.getPackedPositionGroup(0L), (short) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 552314466, (-122) - (Process.myPid() >> 22), objArr5);
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
            component8 = 0;
            sG29839 = 1;
            component9 = -1556249487;
            component5 = -2083118492;
            setPivotYN16904 = 74756595;
            vD14832N6715 = new byte[]{-109, 10, -9, -19, Ascii.DC4, Ascii.SYN, -10, -105, Ascii.CAN, Ascii.RS, -105, -30, Ascii.CAN};
        }
    }
}
