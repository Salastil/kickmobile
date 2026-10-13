package com.fingerprintjs.android.fpjs_pro_internal;

import android.R;
import android.content.Context;
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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.PlaybackException;
import androidx.media3.muxer.WebmConstants;
import com.datadog.reactnative.ProxyAuthenticator;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\b\u0002\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component10Y10845;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/List;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class component10Y10845 extends wX26196 {
    private static int D8871 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715;

    private component10Y10845(List<? extends Map<String, String>> list, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.F2572.INSTANCE.component5(), list, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component10Y10845$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n¨\u0006\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/MountsInfoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/MountsInfoSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/mounts_info/MountInfo;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/mounts_info/MountsInfoResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static final byte[] $$c = null;
        private static final int $$d = 0;
        private static int $10;
        private static int $11;
        private static int D8871;
        private static int component9;
        private static int setPivotYN16904;
        private static int[] vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, int r7, short r8) {
            /*
                int r8 = r8 * 2
                int r8 = 122 - r8
                int r7 = r7 * 2
                int r7 = r7 + 1
                int r6 = r6 * 2
                int r6 = 4 - r6
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.component10Y10845.Companion.$$c
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L17
                r8 = r6
                r3 = r7
                r4 = r2
                goto L27
            L17:
                r3 = r2
            L18:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r7) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                r3 = r0[r6]
            L27:
                int r3 = -r3
                int r6 = r6 + 1
                int r8 = r8 + r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component10Y10845.Companion.$$e(int, int, short):java.lang.String");
        }

        private static void b(int i, short s, int i2, Object[] objArr) {
            int i3 = 115 - i;
            byte[] bArr = $$a;
            int i4 = (s * 3) + 4;
            byte[] bArr2 = new byte[i2 + 1];
            int i5 = -1;
            if (bArr == null) {
                i3 = (i3 + (-i4)) - 5;
                i4++;
                i5 = -1;
            }
            while (true) {
                int i6 = i5 + 1;
                bArr2[i6] = (byte) i3;
                if (i6 == i2) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i7 = i4;
                i3 = (i3 + (-bArr[i4])) - 5;
                i4 = i7 + 1;
                i5 = i6;
            }
        }

        static void init$0() {
            $$a = new byte[]{Ascii.CR, 4, 114, -64, -17, -6, -14, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9};
            $$b = 33;
        }

        static void init$1() {
            $$c = new byte[]{1, -34, -12, 123};
            $$d = 4;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static component10Y10845 component5(D8871<? extends List<Object>, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = D8871;
            int i3 = (i2 & 35) + (i2 | 35);
            setPivotYN16904 = i3 % 128;
            Object obj = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i3 % 2 == 0) {
                boolean z = d8871 instanceof vD14832N6715;
                obj.hashCode();
                throw null;
            }
            if (!(d8871 instanceof vD14832N6715)) {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                component10Y10845 component10y10845 = new component10Y10845(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
                int i4 = setPivotYN16904;
                int i5 = (i4 ^ 41) + ((i4 & 41) << 1);
                D8871 = i5 % 128;
                if (i5 % 2 == 0) {
                    return component10y10845;
                }
                throw null;
            }
            List list = (List) ((vD14832N6715) d8871).setPivotYN16904;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj2 : list) {
                int i6 = setPivotYN16904 + 37;
                D8871 = i6 % 128;
                int i7 = i6 % 2;
                Pair[] pairArr = new Pair[3];
                String strComponent5 = I30900.setAutofillHintsI14457.INSTANCE.component5();
                try {
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1387947292);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 59, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), Color.alpha(0) + TypedValues.Position.TYPE_PATH_MOTION_ARC, 991615, false, "setPivotYN16904", new Class[0]);
                    }
                    pairArr[0] = TuplesKt.to(strComponent5, ((Method) objComponent5).invoke(obj2, null));
                    String strComponent6 = I30900.bk.INSTANCE.component5();
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1962960861);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(((byte) KeyEvent.getModifierMetaStateMask()) + Base64.padSymbol, (char) View.resolveSize(0, 0), 509 - KeyEvent.normalizeMetaState(0), -666182592, false, "component5", new Class[0]);
                    }
                    pairArr[1] = TuplesKt.to(strComponent6, ((Method) objComponent6).invoke(obj2, null));
                    String strComponent7 = I30900.cs.INSTANCE.component5();
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1774005688);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 60, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), Color.argb(0, 0, 0, 0) + TypedValues.Position.TYPE_PATH_MOTION_ARC, 990407131, false, "vD14832N6715", new Class[0]);
                    }
                    pairArr[2] = TuplesKt.to(strComponent7, ((Method) objComponent7).invoke(obj2, null));
                    arrayList.add(MapsKt.mapOf(pairArr));
                    int i8 = setPivotYN16904 + 71;
                    D8871 = i8 % 128;
                    int i9 = i8 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            component10Y10845 component10y10846 = new component10Y10845(arrayList, wX26196.setPivotYN16904.component13.INSTANCE, objArr3 == true ? 1 : 0);
            int i10 = setPivotYN16904;
            int i11 = ((i10 | 11) << 1) - (i10 ^ 11);
            D8871 = i11 % 128;
            int i12 = i11 % 2;
            return component10y10846;
        }

        private static void a(String str, int i, boolean z, int i2, int i3, Object[] objArr) throws Throwable {
            int i4;
            int i5;
            int i6 = 2 % 2;
            char[] charArray = str != null ? str.toCharArray() : str;
            cm cmVar = new cm();
            char[] cArr = new char[i2];
            int i7 = 0;
            cmVar.component9 = 0;
            while (cmVar.component9 < i2) {
                cmVar.setPivotYN16904 = charArray[cmVar.component9];
                cArr[cmVar.component9] = (char) (i3 + cmVar.setPivotYN16904);
                int i8 = cmVar.component9;
                char c = cArr[i8];
                try {
                    Object[] objArr2 = new Object[2];
                    objArr2[1] = Integer.valueOf(component9);
                    objArr2[i7] = Integer.valueOf(c);
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                    if (objComponent5 == null) {
                        int iMakeMeasureSpec = 49 - View.MeasureSpec.makeMeasureSpec(i7, i7);
                        char c2 = (char) ((TypedValue.complexToFraction(i7, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i7, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35725);
                        int i9 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2877;
                        i5 = -2009915307;
                        byte b = (byte) ($$d - 4);
                        i4 = i7;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMakeMeasureSpec, c2, i9, 463712212, false, $$e(b, b, $$c[i4]), new Class[]{Integer.TYPE, Integer.TYPE});
                    } else {
                        i4 = i7;
                        i5 = -2009915307;
                    }
                    cArr[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = new Object[2];
                    objArr3[1] = cmVar;
                    objArr3[i4] = cmVar;
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i5);
                    if (objComponent6 == null) {
                        int i10 = i4;
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(70 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TextUtils.lastIndexOf("", '0', i10, i10) + 19667), 1905 - ImageFormat.getBitsPerPixel(i10), -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                    i7 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (i > 0) {
                int i11 = $10 + 89;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                cmVar.vD14832N6715 = i;
                char[] cArr2 = new char[i2];
                System.arraycopy(cArr, 0, cArr2, 0, i2);
                System.arraycopy(cArr2, 0, cArr, i2 - cmVar.vD14832N6715, cmVar.vD14832N6715);
                System.arraycopy(cArr2, cmVar.vD14832N6715, cArr, 0, i2 - cmVar.vD14832N6715);
            }
            if (z) {
                int i13 = $10 + 91;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                char[] cArr3 = new char[i2];
                cmVar.component9 = 0;
                while (cmVar.component9 < i2) {
                    int i15 = $10 + 61;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    cArr3[cmVar.component9] = cArr[(i2 - cmVar.component9) - 1];
                    Object[] objArr4 = {cmVar, cmVar};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "") + 70, (char) (TextUtils.getOffsetBefore("", 0) + 19666), (ViewConfiguration.getTouchSlop() >> 8) + 1906, -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent7).invoke(null, objArr4);
                }
                cArr = cArr3;
            }
            objArr[0] = new String(cArr);
        }

        private static void c(int[] iArr, int i, Object[] objArr) throws Throwable {
            int i2;
            int length;
            int[] iArr2;
            int i3 = 2;
            int i4 = 2 % 2;
            ci ciVar = new ci();
            int i5 = 4;
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr3 = vD14832N6715;
            float f = 0.0f;
            boolean z = true;
            if (iArr3 != null) {
                int i6 = $10 + 1;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    length = iArr3.length;
                    iArr2 = new int[length];
                } else {
                    length = iArr3.length;
                    iArr2 = new int[length];
                }
                int i7 = 0;
                i2 = 40761;
                while (i7 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr3[i7])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                        if (objComponent5 == null) {
                            int i8 = 53 - (ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1));
                            char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 40761);
                            int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 6421;
                            byte b = (byte) ($$d - 4);
                            byte b2 = b;
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i8, cKeyCodeFromString, touchSlop, 534407883, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        iArr2[i7] = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                        i7++;
                        int i9 = $10 + 101;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                        z = z;
                        i3 = i3;
                        i5 = i5;
                        f = 0.0f;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr3 = iArr2;
            } else {
                i2 = 40761;
            }
            int i11 = i3;
            int i12 = i5;
            boolean z2 = z;
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = vD14832N6715;
            int i13 = 16;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i14 = 0;
                while (i14 < length3) {
                    Object[] objArr3 = {Integer.valueOf(iArr5[i14])};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                    if (objComponent6 == null) {
                        int doubleTapTimeout = 52 - (ViewConfiguration.getDoubleTapTimeout() >> i13);
                        char scrollDefaultDelay = (char) (i2 - (ViewConfiguration.getScrollDefaultDelay() >> i13));
                        int defaultSize = View.getDefaultSize(0, 0) + 6421;
                        byte b3 = (byte) ($$d - 4);
                        byte b4 = b3;
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout, scrollDefaultDelay, defaultSize, 534407883, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    iArr6[i14] = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                    i14++;
                    i13 = i13;
                    cArr = cArr;
                }
                iArr5 = iArr6;
            }
            char[] cArr3 = cArr;
            int i15 = i13;
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            ciVar.component5 = 0;
            while (ciVar.component5 < iArr.length) {
                int i16 = $10 + 87;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                cArr3[0] = (char) (iArr[ciVar.component5] >> 16);
                cArr3[z2 ? 1 : 0] = (char) iArr[ciVar.component5];
                cArr3[i11] = (char) (iArr[ciVar.component5 + 1] >> 16);
                cArr3[3] = (char) iArr[ciVar.component5 + 1];
                ciVar.vD14832N6715 = (cArr3[0] << 16) + cArr3[z2 ? 1 : 0];
                ciVar.setPivotYN16904 = (cArr3[i11] << 16) + cArr3[3];
                ci.setPivotYN16904(iArr4);
                int i18 = i15;
                int i19 = 0;
                while (i19 < i18) {
                    ciVar.vD14832N6715 ^= iArr4[i19];
                    int iD8871 = ci.D8871(ciVar.vD14832N6715);
                    Object[] objArr4 = new Object[i12];
                    objArr4[3] = ciVar;
                    objArr4[i11] = ciVar;
                    objArr4[z2 ? 1 : 0] = Integer.valueOf(iD8871);
                    objArr4[0] = ciVar;
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(63485357);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(85 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
                    ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                    ciVar.setPivotYN16904 = iIntValue;
                    i19++;
                    i18 = 16;
                    i12 = 4;
                }
                int i20 = ciVar.vD14832N6715;
                ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                ciVar.setPivotYN16904 = i20;
                i15 = 16;
                ciVar.setPivotYN16904 ^= iArr4[16];
                ciVar.vD14832N6715 ^= iArr4[17];
                int i21 = ciVar.vD14832N6715;
                int i22 = ciVar.setPivotYN16904;
                cArr3[0] = (char) (ciVar.vD14832N6715 >>> 16);
                cArr3[z2 ? 1 : 0] = (char) ciVar.vD14832N6715;
                cArr3[i11] = (char) (ciVar.setPivotYN16904 >>> 16);
                cArr3[3] = (char) ciVar.setPivotYN16904;
                ci.setPivotYN16904(iArr4);
                cArr2[ciVar.component5 * 2] = cArr3[0];
                cArr2[(ciVar.component5 * 2) + 1] = cArr3[z2 ? 1 : 0];
                cArr2[(ciVar.component5 * 2) + 2] = cArr3[i11];
                cArr2[(ciVar.component5 * 2) + 3] = cArr3[3];
                int i23 = i11;
                Object[] objArr5 = new Object[i23];
                objArr5[z2 ? 1 : 0] = ciVar;
                objArr5[0] = ciVar;
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(743063861);
                if (objComponent8 == null) {
                    int iMyPid = 52 - (Process.myPid() >> 22);
                    char c = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 3580;
                    i12 = 4;
                    byte b5 = (byte) ($$d - 4);
                    byte b6 = b5;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyPid, c, iLastIndexOf, 2130642262, false, $$e(b5, b6, (byte) (b6 | Ascii.ESC)), new Class[]{Object.class, Object.class});
                } else {
                    i12 = 4;
                }
                ((Method) objComponent8).invoke(null, objArr5);
                i11 = i23;
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        static {
            init$1();
            $10 = 0;
            $11 = 1;
            init$0();
            D8871 = 0;
            setPivotYN16904 = 1;
            component9 = 1125199090;
            vD14832N6715 = new int[]{463560057, 1883220043, 309559260, -14283806, 1222832955, 117478899, 1036725281, 806756461, -789166314, -1696148055, 2027656485, -929031200, 741448906, 184066447, 1954568850, 1122921278, 822467012, 958892789};
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0f62 A[Catch: all -> 0x1582, TryCatch #19 {all -> 0x1582, blocks: (B:99:0x0f55, B:101:0x0f62, B:102:0x0f8b), top: B:357:0x0f55 }] */
        /* JADX WARN: Code duplicated, block: B:149:0x12ae A[Catch: Exception -> 0x15a2, all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:152:0x1303 A[Catch: Exception -> 0x15a2, all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:156:0x1388 A[Catch: all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:158:0x13ab A[Catch: all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:160:0x13ee A[Catch: all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:162:0x1461 A[Catch: all -> 0x1625, IOException -> 0x1630, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:164:0x149f A[Catch: all -> 0x1625, IOException -> 0x1630, TRY_LEAVE, TryCatch #2 {, blocks: (B:90:0x0e5f, B:91:0x0e7c, B:93:0x0efc, B:98:0x0f51, B:103:0x0f91, B:108:0x103f, B:146:0x129d, B:147:0x12a0, B:149:0x12ae, B:150:0x12ed, B:152:0x1303, B:153:0x133f, B:154:0x1350, B:156:0x1388, B:158:0x13ab, B:160:0x13ee, B:162:0x1461, B:164:0x149f, B:166:0x14a7, B:214:0x15a2, B:215:0x1624, B:186:0x1562, B:187:0x1565, B:192:0x156b, B:194:0x1573, B:195:0x1574, B:197:0x1576, B:199:0x1580, B:200:0x1581, B:202:0x1583, B:204:0x158d, B:205:0x158e, B:207:0x1590, B:209:0x159a, B:210:0x159b), top: B:338:0x0e5f }] */
        /* JADX WARN: Code duplicated, block: B:225:0x1632  */
        /* JADX WARN: Code duplicated, block: B:261:0x1bb8 A[EDGE_INSN: B:261:0x1bb8->B:262:0x1c2a BREAK  A[LOOP:1: B:242:0x18df->B:260:0x1bac]] */
        /* JADX WARN: Code duplicated, block: B:386:0x0d34 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:387:0x0dde A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:388:0x1646 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:393:0x1630 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:394:0x1539 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:395:0x1539 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:396:0x1539 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:397:0x1539 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x0c21  */
        /* JADX WARN: Code duplicated, block: B:74:0x0c24  */
        /* JADX WARN: Code duplicated, block: B:77:0x0c45 A[Catch: all -> 0x25fd, TryCatch #17 {all -> 0x25fd, blocks: (B:5:0x015f, B:7:0x016c, B:8:0x01a9, B:17:0x0355, B:19:0x0362, B:20:0x0399, B:29:0x0568, B:31:0x0575, B:32:0x05b1, B:41:0x075d, B:43:0x076a, B:44:0x07a7, B:60:0x0a58, B:62:0x0a6e, B:64:0x0ab8, B:252:0x19ca, B:254:0x19e2, B:255:0x1a24, B:271:0x1cbe, B:273:0x1ccb, B:274:0x1d06, B:283:0x1f90, B:285:0x1f9d, B:286:0x1fd4, B:295:0x21ca, B:297:0x21d7, B:298:0x221a, B:307:0x23f2, B:309:0x23ff, B:310:0x2441, B:75:0x0c2b, B:77:0x0c45, B:78:0x0c89), top: B:355:0x00e6 }] */
        /* JADX WARN: Code duplicated, block: B:82:0x0dd7 A[LOOP:3: B:73:0x0c22->B:82:0x0dd7, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:83:0x0dde  */
        /* JADX WARN: Code duplicated, block: B:85:0x0e16  */
        /* JADX WARN: Code duplicated, block: B:87:0x0e3f  */
        /* JADX WARN: Code duplicated, block: B:89:0x0e5d  */
        /* JADX WARN: Code duplicated, block: B:96:0x0f21 A[Catch: all -> 0x158f, TryCatch #25 {all -> 0x158f, blocks: (B:94:0x0f14, B:96:0x0f21, B:97:0x0f4b), top: B:369:0x0f14 }] */
        public static Object[] vD14832N6715(Context context, int i, int i2, int i3) throws Throwable {
            Object[] objArr;
            char c;
            Object[] objArr2;
            int i4;
            Object[] objArr3;
            int i5;
            Object[] objArr4;
            char c2;
            Object[] objArr5;
            char c3;
            int length;
            String str;
            String str2;
            String str3;
            int i6;
            String[] strArrSplit;
            int length2;
            int i7;
            String str4;
            Object[] objArr6;
            String[] strArr;
            int i8;
            int i9;
            Process processExec;
            Object objComponent5;
            Object objComponent6;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2;
            Object objComponent7;
            Object objComponent8;
            String[] strArrSplit2;
            int length3;
            int i10;
            String str5;
            Object[] objArr7;
            Object[] objArr8;
            Object[] objArr9;
            String[] strArrSplit3;
            int i11;
            Object objComponent9;
            int i12;
            int i13;
            Object[] objArr10;
            Object[] objArr11;
            Object[] objArr12;
            int i14 = 0;
            int i15 = -View.resolveSize(0, 0);
            int i16 = 1;
            int i17 = (i15 ^ 15) + ((i15 & 15) << 1);
            int i18 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            int i19 = (i18 & 35) + (i18 | 35);
            int threadPriority = Process.getThreadPriority(0);
            int i20 = 7499 - (~(threadPriority * (-747)));
            int i21 = ~((-21) | threadPriority);
            int i22 = ~i;
            int i23 = ~(i22 | 20);
            int i24 = (i20 - (~(-(-(((i21 & i23) | (i21 ^ i23)) * (-374)))))) - 1;
            int i25 = ~threadPriority;
            int i26 = i24 + ((~((i25 & 20) | (i25 ^ 20))) * 748);
            int i27 = ~((~threadPriority) | (-21));
            int i28 = ~i;
            int i29 = ~(i28 | 20);
            int i30 = ((i27 & i29) | (i27 ^ i29)) * 374;
            Object[] objArr13 = new Object[1];
            a("\uffde\r\r\t\u0006\u0000\ufffe\u0011\u0006\f\u000b￦\u000b\u0003\f\ufffe\u000b\u0001\u000f\f\u0006\u0001ￋ\u0000\f\u000b\u0011\u0002\u000b\u0011ￋ\r\nￋ", i17, false, i19, 185 - ((((i26 | i30) << 1) - (i30 ^ i26)) >> 6), objArr13);
            String str6 = (String) objArr13[0];
            int i31 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int i32 = ((i31 | 2) << 1) - (i31 ^ 2);
            int i33 = -View.combineMeasuredStates(0, 0);
            int i34 = (i33 ^ 7) + ((i33 & 7) << 1);
            int i35 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
            int i36 = (i35 ^ 184) + ((i35 & 184) << 1);
            Object[] objArr14 = new Object[1];
            a("\ufffe\u0001\u000f\u0006￡\ufffe\u0011", i32, true, i34, i36, objArr14);
            String str7 = (String) objArr14[0];
            Object[] objArr15 = new Object[1];
            a("\ufff5\t\u0013\u0006\u0002\u0005\u000b\u0002\u0017\u0002ￏ\r\u0002\u000f\bￏ", 6 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), false, 15 - (~(-(-TextUtils.getOffsetAfter("", 0)))), 180 - (~(-View.combineMeasuredStates(0, 0))), objArr15);
            String str8 = (String) objArr15[0];
            int i37 = 16;
            try {
                if (context == null) {
                    int i38 = 4 - (~(-(Process.myPid() >> 22)));
                    int threadPriority2 = Process.getThreadPriority(0);
                    int i39 = ((threadPriority2 & 20) + (threadPriority2 | 20)) >> 6;
                    int pivotYN16904 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i40 = i39 * (-743);
                    int i41 = (i40 & (-8916)) + (i40 | (-8916));
                    int i42 = (~((i39 ^ 12) | (i39 & 12))) | (~(i39 | pivotYN16904));
                    int i43 = ~((pivotYN16904 ^ 12) | (pivotYN16904 & 12));
                    int i44 = (i41 - (~(((i42 & i43) | (i42 ^ i43)) * (-744)))) - 1;
                    int i45 = ~pivotYN16904;
                    int i46 = ~i39;
                    int i47 = ~((i46 & (-13)) | (i46 ^ (-13)));
                    int i48 = -(-(((i45 & i47) | (i45 ^ i47)) * 744));
                    int i49 = i39 | 12;
                    int i50 = (((i44 ^ i48) + ((i48 & i44) << 1)) - (~(((i49 & pivotYN16904) | (i49 ^ pivotYN16904)) * 744))) - 1;
                    int i51 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int i52 = ((i51 | 182) << 1) - (i51 ^ 182);
                    Object[] objArr16 = new Object[1];
                    a("\u0013\u0005\u0015\u0007ￏ\u000f\u0006\u000e￩\ufff3\uffef\u0014", i38, true, i50, i52, objArr16);
                    Object[] objArr17 = {(String) objArr16[0]};
                    Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent10 == null) {
                        int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 52;
                        char c4 = (char) (59726 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                        int i53 = 6318 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        Object[] objArr18 = new Object[1];
                        b((byte) ($$b >>> 1), (short) 0, 0, objArr18);
                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout, c4, i53, 66836110, false, (String) objArr18[0], new Class[]{String.class});
                    }
                    long jLongValue = ((Long) ((Method) objComponent10).invoke(null, objArr17)).longValue();
                    long j = i;
                    long j2 = (1958811734 | j) ^ (-1);
                    long j3 = jLongValue ^ (-1);
                    long j4 = j ^ (-1);
                    long j5 = (-276192454635L) + ((-139) * jLongValue) + ((-280) * (((1958811734 | jLongValue) ^ (-1)) | j2)) + ((j2 | ((j3 | j) ^ (-1))) * 140) + (140 * ((((1958811734 | j3) | j) ^ (-1)) | (((1958811734 | j4) | jLongValue) ^ (-1)) | (((j3 | j4) | (-1958811735)) ^ (-1)))) + 2114762101;
                    int i54 = ((int) (j5 >> 32)) & ((((-2107906066) + (((~(876061232 | i22)) | 1981679652) * (-933))) + (((~(1981679652 | i22)) | 2204176) * 933)) - 735152992);
                    int iNextInt = new Random().nextInt();
                    int i55 = ((int) j5) & (1771465493 + (((~((-586583693) | iNextInt)) | 39193224) * 576) + (((~((~iNextInt) | (-547390469))) | (-2063003327)) * 576) + 1100460544);
                    if (((i55 & i54) | (i54 ^ i55)) != 0) {
                        objArr10 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int i56 = (~(i & 50)) & (i | 50);
                        int iNextInt2 = new Random().nextInt();
                        int i57 = (-1158287659) + (((~iNextInt2) | 285414656) * 1324) + (((~(iNextInt2 | (-102810200))) | (~(318986007 | iNextInt2))) * (-1324)) + 1442580970;
                        int i58 = i3 + (i57 ^ 16) + ((i57 & 16) << 1);
                        int i59 = i58 << 13;
                        int i60 = ((~i58) & i59) | ((~i59) & i58);
                        int i61 = i60 >>> 17;
                        int i62 = (i60 | i61) & (~(i60 & i61));
                        int i63 = i62 << 5;
                        ((int[]) objArr10[4])[0] = (i62 | i63) & (~(i62 & i63));
                    } else {
                        objArr10 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{i ^ (i << 5)}};
                        int i64 = (-720628540) + (((~((-949147718) | i22)) | (-732971910)) * (-602)) + (((~((-949147718) | i)) | 268605504 | (~(i22 | (-52429697)))) * (-301)) + ((~(i22 | (-732971910))) * 301);
                        int i65 = i3 + ((i64 << 1) - i64);
                        int i66 = i65 ^ (i65 << 13);
                        int i67 = i66 >>> 17;
                        int i68 = ((~i66) & i67) | ((~i67) & i66);
                    }
                    if (((int[]) objArr10[0])[0] != i) {
                        return objArr10;
                    }
                    int i69 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i70 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    Object[] objArr19 = new Object[1];
                    a("\uffff\uffc9\r\u0013\r\u000e\uffff\u0007\uffc9\u0010\n\u0002\t\b\uffff\ufff9\r\n\ufffb�", i69, false, ((i70 | 21) << 1) - (i70 ^ 21), 188 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr19);
                    Object[] objArr20 = {(String) objArr19[0]};
                    Object objComponent11 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent11 == null) {
                        int iGreen = Color.green(0) + 52;
                        char packedPositionChild = (char) (59724 - ExpandableListView.getPackedPositionChild(0L));
                        int packedPositionType = 6317 - ExpandableListView.getPackedPositionType(0L);
                        Object[] objArr21 = new Object[1];
                        b((byte) ($$b >>> 1), (short) 0, 0, objArr21);
                        objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(iGreen, packedPositionChild, packedPositionType, 66836110, false, (String) objArr21[0], new Class[]{String.class});
                    }
                    long jLongValue2 = ((Long) ((Method) objComponent11).invoke(null, objArr20)).longValue();
                    long j6 = (-155078133295L) + (85 * jLongValue2);
                    long j7 = jLongValue2 ^ (-1);
                    long jFreeMemory = (int) Runtime.getRuntime().freeMemory();
                    long j8 = jFreeMemory ^ (-1);
                    long j9 = (-1824448627) | jLongValue2;
                    long j10 = (jLongValue2 | j8) ^ (-1);
                    long j11 = j6 + ((((1824448626 | j7) ^ (-1)) | ((1824448626 | j8) ^ (-1)) | ((j7 | j8) ^ (-1)) | ((j9 | jFreeMemory) ^ (-1))) * (-84)) + ((-84) * ((-1824448627) | ((j7 | jFreeMemory) ^ (-1)) | j10)) + (84 * (j10 | (j9 ^ (-1)))) + 1980398993;
                    int i71 = ((int) (j11 >> 32)) & ((-712905202) + (((~(878497507 | i)) | 1979243377) * (-318)) + (((~(1979243377 | i)) | (~(i22 | (-878234210)))) * TypedValues.Attributes.TYPE_PIVOT_TARGET) + (((~(i22 | (-263299))) | (~((-878234210) | i))) * TypedValues.Attributes.TYPE_PIVOT_TARGET));
                    int i72 = (int) j11;
                    int i73 = (int) Runtime.getRuntime().totalMemory();
                    int i74 = ~i73;
                    if ((i71 | (i72 & ((-2123832343) + (((~((-638880435) | i74)) | (-798345976)) * 220) + (((~(i74 | (-638962423))) | (-798263988)) * (-440)) + ((i73 | (-638880435)) * 220)))) != 0) {
                        objArr11 = new Object[]{new int[]{(i & (-61)) | (i22 & 60)}, new int[]{i}, null, null, new int[1]};
                        int iUptimeMillis = (int) SystemClock.uptimeMillis();
                        int i75 = ~iUptimeMillis;
                        int i76 = (-59370053) + ((iUptimeMillis | 174975790) * 140) + (((~(174975790 | i75)) | 1048721) * (-280)) + (((~(iUptimeMillis | (-1048722))) | (~(41200017 | i75)) | 134824494) * 140);
                        int i77 = -(-((i76 & 16) + (i76 | 16)));
                        int i78 = (i3 & i77) + (i3 | i77);
                        int i79 = i78 << 13;
                        int i80 = (i79 & (~i78)) | ((~i79) & i78);
                        int i81 = i80 >>> 17;
                        int i82 = ((~i80) & i81) | ((~i81) & i80);
                        int i83 = i82 << 5;
                        ((int[]) objArr11[4])[0] = ((~i82) & i83) | ((~i83) & i82);
                    } else {
                        objArr11 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                        int i84 = (~((-706142920) | iUptimeMillis2)) | 570597568;
                        int i85 = 367157935 + (i84 * 992) + ((i84 | (~((~iUptimeMillis2) | (-354421761)))) * (-496)) + ((iUptimeMillis2 | (-489967112)) * 496);
                        int i86 = ((i3 | i85) << 1) - (i3 ^ i85);
                        int i87 = i86 << 13;
                        int i88 = ((~i86) & i87) | ((~i87) & i86);
                        int i89 = i88 ^ (i88 >>> 17);
                        int i90 = i89 << 5;
                        ((int[]) objArr11[4])[0] = ((~i89) & i90) | ((~i90) & i89);
                    }
                    if (((int[]) objArr11[0])[0] != i) {
                        return objArr11;
                    }
                    int i91 = 24 - (~(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int i92 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i93 = ((i92 | 36) << 1) - (i92 ^ 36);
                    int i94 = -KeyEvent.keyCodeFromString("");
                    int i95 = (i94 & WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY) + (i94 | WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY);
                    Object[] objArr22 = new Object[1];
                    a("\u0004\u0010\u000eￏ\b\u0003\u0010\u0019ￏ\u0002\u000f\u0005\u0013\u0010\n\u0005\uffd0\u0017\u0007\u0014\u0000\u0005\u0002\u0015\u0002\uffd0\u0005\u0002\u0015\u0002\uffd0\u0005\u0002\u0015\u0002\uffd0", i91, false, i93, i95, objArr22);
                    Object[] objArr23 = {(String) objArr22[0]};
                    Object objComponent12 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent12 == null) {
                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 52;
                        char bitsPerPixel = (char) (59724 - ImageFormat.getBitsPerPixel(0));
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 6317;
                        Object[] objArr24 = new Object[1];
                        b((byte) (-$$a[4]), (short) 0, 0, objArr24);
                        objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(longPressTimeout, bitsPerPixel, windowTouchSlop, 369154319, false, (String) objArr24[0], new Class[]{String.class});
                    }
                    long jLongValue3 = ((Long) ((Method) objComponent12).invoke(null, objArr23)).longValue();
                    long j12 = jLongValue3 ^ (-1);
                    long j13 = ((((70500537204L + ((-67) * jLongValue3)) + (((((((-1021746917) | j12) | j4) ^ (-1)) | ((1021746916 | jLongValue3) ^ (-1))) | ((jLongValue3 | j) ^ (-1))) * (-68))) + ((-68) * ((jLongValue3 | ((-1021746917) | j4)) ^ (-1)))) + (68 * (((j12 | j4) ^ (-1)) | (-1021746917)))) - 1996248801;
                    int iMyTid = Process.myTid();
                    int i96 = ((int) (j13 >> 32)) & (((77143226 + ((2009945598 | (~iMyTid)) * (-490))) + (((~(iMyTid | 1992840542)) | R.dimen.car_large_avatar_size) * 490)) - 1400594724);
                    int iMyTid2 = Process.myTid();
                    int i97 = ~iMyTid2;
                    int i98 = (-1905160647) + (((~((-82058175) | i97)) | 73403030 | (~(1519284584 | i97)) | (~((-1510629441) | iMyTid2))) * (-84));
                    int i99 = (~(iMyTid2 | 1519284584)) | 82058174;
                    int i100 = ~(i97 | (-1519284585));
                    int i101 = ((int) j13) & (i98 + ((i99 | i100) * (-84)) + ((1510629440 | i100) * 84));
                    if (((i96 & i101) | (i96 ^ i101)) != 0) {
                        objArr12 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{(i | i) & (~(i & i))}};
                        int i102 = (~(i & 80)) & (i | 80);
                        int i103 = (-286061434) + (((~((-163127577) | i22)) | 143654936) * 98) + (((~((-53048232) | i22)) | (-163127577) | (~(53048231 | i))) * (-49)) + (((~((-163127577) | i)) | (-196703168)) * 49);
                        int i104 = -(-(((i103 | 16) << 1) - (i103 ^ 16)));
                        int i105 = (i3 ^ i104) + ((i3 & i104) << 1);
                        int i106 = (i105 << 13) ^ i105;
                        int i107 = i106 >>> 17;
                        int i108 = ((~i106) & i107) | ((~i107) & i106);
                        int i109 = i108 << 5;
                    } else {
                        objArr12 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i110 = ~iMaxMemory;
                        int i111 = (-1183304401) + (((~(89715309 | i110)) | 42008594) * (-1188));
                        int i112 = (~(iMaxMemory | (-89715310))) | 42008594;
                        int i113 = ~(126460498 | i110);
                        int i114 = i111 + ((i112 | i113) * 594) + (((~((-89715310) | i110)) | 5263405 | i113) * 594);
                        int i115 = ((i3 | i114) << 1) - (i3 ^ i114);
                        int i116 = i115 << 13;
                        int i117 = (i115 | i116) & (~(i115 & i116));
                        int i118 = i117 >>> 17;
                        int i119 = ((~i117) & i118) | ((~i118) & i117);
                        int i120 = i119 << 5;
                        ((int[]) objArr12[4])[0] = (i119 | i120) & (~(i119 & i120));
                    }
                    if (((int[]) objArr12[0])[0] != i) {
                        return objArr12;
                    }
                    int i121 = -KeyEvent.keyCodeFromString("");
                    int i122 = (i121 & 42) + (i121 | 42);
                    Object[] objArr25 = new Object[1];
                    c(new int[]{1325076212, -660282558, 571927301, 1452954783, 826723459, 1583063201, 38010057, 125069812, 2099264382, 1247204510, -971644279, -1525400028, -1186034847, -1500515637, -833029599, -2049775207, 639373222, 1101354632, -495741612, -1441056419, -1294538379, 1296829065}, i122, objArr25);
                    Object[] objArr26 = {(String) objArr25[0]};
                    Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent13 == null) {
                        int jumpTapTimeout = 52 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 59725);
                        int defaultSize = 6317 - View.getDefaultSize(0, 0);
                        Object[] objArr27 = new Object[1];
                        b((byte) (-$$a[4]), (short) 0, 0, objArr27);
                        objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(jumpTapTimeout, scrollDefaultDelay, defaultSize, 369154319, false, (String) objArr27[0], new Class[]{String.class});
                    }
                    long jLongValue4 = ((Long) ((Method) objComponent13).invoke(null, objArr26)).longValue();
                    long j14 = ((jLongValue4 ^ (-1)) | j) ^ (-1);
                    long j15 = (((((-433191628352L) + ((-574) * jLongValue4)) + (1150 * ((((-754689249) | j4) ^ (-1)) | j14))) + ((-575) * (((j4 | jLongValue4) ^ (-1)) | j14))) + (575 * ((((-754689249) | j) ^ (-1)) | ((j4 | 754689248) ^ (-1))))) - 1729191133;
                    int i123 = ((int) (j15 >> 32)) & ((-1186564458) + (((-367905769) | i) * (-859)) + (((~(i22 | (-367905769))) | (~((-1779441684) | i))) * 859) + (((~((-1805132180) | i22)) | 25690496) * 859));
                    int i124 = ((int) j15) & (1448781972 + ((~(1507570951 | i22)) * 979) + ((70344541 | i) * (-979)) + (((~(1507570951 | i)) | (~(i22 | 70344541))) * 979));
                    if (((i123 & i124) | (i123 ^ i124)) == 0) {
                        Object[] objArr28 = {new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iNextInt3 = new Random().nextInt(1172080356);
                        int i125 = i3 + 23675759 + (((~((-268747969) | (~iNextInt3))) | (~((-52572161) | iNextInt3))) * (-272)) + (((~((-944621054) | iNextInt3)) | 675873085) * (-272)) + (((~(iNextInt3 | 944621053)) | (-728445246)) * 272);
                        int i126 = i125 << 13;
                        int i127 = (i125 | i126) & (~(i125 & i126));
                        int i128 = i127 >>> 17;
                        int i129 = (i127 | i128) & (~(i127 & i128));
                        int i130 = i129 << 5;
                        ((int[]) objArr28[4])[0] = (i129 | i130) & (~(i129 & i130));
                        return objArr28;
                    }
                    Object[] objArr29 = {new int[]{i}, new int[]{i}, null, null, new int[1]};
                    int i131 = (~(i & 90)) & (i | 90);
                    int iMyTid3 = Process.myTid();
                    int i132 = 2044097890 + (((~((~iMyTid3) | (-388020310))) | (-171844502)) * (-235)) + (((~((-388020310) | iMyTid3)) | (-171844502)) * (-470)) + (((~(iMyTid3 | (-35659798))) | (-524205014)) * 235);
                    int i133 = (i132 & 16) + (i132 | 16);
                    int i134 = (i3 ^ i133) + ((i3 & i133) << 1);
                    int i135 = (i134 << 13) ^ i134;
                    int i136 = i135 ^ (i135 >>> 17);
                    int i137 = i136 << 5;
                    ((int[]) objArr29[4])[0] = (i136 | i137) & (~(i136 & i137));
                    return objArr29;
                }
                int i138 = 2;
                int i139 = 3;
                try {
                    Object[] objArr30 = new Object[1];
                    c(new int[]{805201070, -586831618, 436013775, -808229217, -503798660, 65409888, -414259493, -29293429, 1645488617, -532667640, -1384335855, -997942438}, View.getDefaultSize(0, 0) + 23, objArr30);
                    Class<?> cls = Class.forName((String) objArr30[0]);
                    int i140 = -(-(ViewConfiguration.getLongPressTimeout() >> 16));
                    int i141 = (i140 & 8) + (i140 | 8);
                    int i142 = -KeyEvent.normalizeMetaState(0);
                    int pivotYN16905 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i143 = i142 * 615;
                    int i144 = ((i143 | (-8582)) << 1) - (i143 ^ (-8582));
                    int i145 = ~i142;
                    int i146 = ~((i145 ^ 14) | (i145 & 14));
                    int i147 = (pivotYN16905 ^ i146) | (i146 & pivotYN16905);
                    int i148 = ~(((-15) ^ i142) | ((-15) & i142));
                    int i149 = -(-(((i147 ^ i148) | (i148 & i147)) * 614));
                    int i150 = ((i144 | i149) << 1) - (i149 ^ i144);
                    int i151 = ~i142;
                    int i152 = ~pivotYN16905;
                    int i153 = (~(i151 | 14)) | (~((i151 ^ i152) | (i151 & i152)));
                    int i154 = ~((i152 ^ 14) | (i152 & 14));
                    int i155 = ((i153 ^ i154) | (i153 & i154)) * (-1228);
                    int i156 = ((i150 | i155) << 1) - (i155 ^ i150);
                    int i157 = ~((i145 ^ (-15)) | (i145 & (-15)) | i152);
                    int i158 = (i142 & i152) | (i152 ^ i142);
                    int i159 = ~((i158 & 14) | (i158 ^ 14));
                    int i160 = (i156 - (~(((i157 & i159) | (i157 ^ i159)) * 614))) - 1;
                    char c5 = '0';
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                    int i161 = (iLastIndexOf & WebmConstants.MkvEbmlElement.PIXEL_HEIGHT) + (iLastIndexOf | WebmConstants.MkvEbmlElement.PIXEL_HEIGHT);
                    Object[] objArr31 = new Object[1];
                    a("\b\ufffe\u0004\u0002￫\ufffe\n\u0002\u0004\u0002\u0011￭\ufffe\u0000", i141, false, i160, i161, objArr31);
                    String str9 = (String) cls.getMethod((String) objArr31[0], null).invoke(context, null);
                    int i162 = -(-TextUtils.getTrimmedLength(""));
                    int i163 = (i162 & 23) + (i162 | 23);
                    Object[] objArr32 = new Object[1];
                    c(new int[]{805201070, -586831618, 436013775, -808229217, -503798660, 65409888, -414259493, -29293429, 1645488617, -532667640, -1384335855, -997942438}, i163, objArr32);
                    Class<?> cls2 = Class.forName((String) objArr32[0]);
                    int i164 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    int i165 = ((i164 | 18) << 1) - (i164 ^ 18);
                    Object[] objArr33 = new Object[1];
                    c(new int[]{-563964826, -852481193, 134531943, 1105798997, 2136418122, 2036526366, -1229573824, 2143695841, 284306082, 1710305066}, i165, objArr33);
                    Object objInvoke = cls2.getMethod((String) objArr33[0], null).invoke(context, null);
                    int iIndexOf = ((String) Class.forName(str6).getField(str7).get(objInvoke)).indexOf(str9);
                    if (iIndexOf > 0) {
                        String str10 = (String) Class.forName(str6).getField(str7).get(objInvoke);
                        int length4 = str10.length();
                        int i166 = (length4 ^ (-16)) + ((length4 & (-16)) << 1);
                        if (i166 >= 0) {
                            int i167 = 0;
                            while (true) {
                                if (i167 <= i166) {
                                    String strSubstring = str10.substring(i167, (i167 & 16) + (i167 | 16));
                                    int i168 = i16;
                                    Object[] objArr34 = new Object[i138];
                                    objArr34[i168] = 931995;
                                    objArr34[i14] = strSubstring;
                                    Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                    if (objComponent14 == null) {
                                        int iLastIndexOf2 = TextUtils.lastIndexOf("", c5, i14) + 53;
                                        char gidForName = (char) (Process.getGidForName("") + 1);
                                        int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 5421;
                                        Object[] objArr35 = new Object[i168];
                                        b((byte) ($$b >>> 1), (short) 0, i139, objArr35);
                                        objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf2, gidForName, packedPositionChild2, 1884899413, false, (String) objArr35[0], new Class[]{String.class, Integer.TYPE});
                                    }
                                    long jLongValue5 = ((Long) ((Method) objComponent14).invoke(null, objArr34)).longValue();
                                    long j16 = i;
                                    long j17 = j16 ^ (-1);
                                    long j18 = 209537645814L + (185 * jLongValue5) + ((((1145014457 | jLongValue5) ^ (-1)) | ((j17 | jLongValue5) ^ (-1))) * 184) + ((-184) * ((((jLongValue5 ^ (-1)) | (-1145014458)) ^ (-1)) | j16)) + (184 * ((1145014457 | j17) ^ (-1))) + 1652167571;
                                    int i169 = ((int) (j18 >> 32)) & ((-2055567968) + (((~((-887316994) | i22)) | 549909417) * 226) + (((~((-549909418) | i)) | 299432 | (~(i22 | (-337707009)))) * (-113)) + ((~((-887316994) | i)) * 113));
                                    int i170 = ~((-364390586) | i);
                                    int i171 = ((int) j18) & (266450586 + ((524297 | i170) * (-814)) + ((i170 | (~(1072835824 | i22)) | 708969536) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE) + (((~(364390585 | i)) | 708969536 | (~((-1072835825) | i))) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                                    if (((i169 & i171) | (i169 ^ i171)) == -725904754) {
                                        objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                        int i172 = (~(i & 20)) & (i | 20);
                                        String str11 = (String) Class.forName(str6).getField(str7).get(objInvoke);
                                        ((int[]) objArr[1])[0] = i;
                                        ((int[]) objArr[0])[0] = i172;
                                        int i173 = 1299932188 + ((~(1073708761 | i)) * 623) + ((i22 | 168952345) * (-623)) + (((~(513242649 | i)) | (-1073708762) | (~(729418457 | i))) * 623);
                                        int i174 = i3 + (i173 ^ 16) + ((i173 & 16) << 1);
                                        int i175 = i174 ^ (i174 << 13);
                                        int i176 = i175 >>> 17;
                                        int i177 = ((~i175) & i176) | ((~i176) & i175);
                                        int i178 = i177 << 5;
                                        ((int[]) objArr[4])[0] = (i177 | i178) & (~(i177 & i178));
                                    } else {
                                        i167++;
                                        str6 = str6;
                                        str8 = str8;
                                        c5 = '0';
                                        i14 = 0;
                                        i16 = 1;
                                        i138 = 2;
                                        i139 = 3;
                                    }
                                } else {
                                    str = str6;
                                    str2 = str8;
                                    str3 = (String) Class.forName(str).getField(str7).get(objInvoke);
                                    int length5 = str3.length();
                                    i6 = (length5 & (-6)) + (length5 | (-6));
                                    if (i6 >= 0) {
                                        i11 = 0;
                                        while (true) {
                                            if (i11 <= i6) {
                                                Object[] objArr36 = {str3.substring(i11, i11 + 6), 931995};
                                                objComponent9 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                                if (objComponent9 == null) {
                                                    int i179 = 53 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                    char c6 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                                    int iIndexOf2 = TextUtils.indexOf("", "") + 5420;
                                                    Object[] objArr37 = new Object[1];
                                                    b((byte) ($$b >>> 1), (short) 0, 3, objArr37);
                                                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(i179, c6, iIndexOf2, 1884899413, false, (String) objArr37[0], new Class[]{String.class, Integer.TYPE});
                                                }
                                                long jLongValue6 = ((Long) ((Method) objComponent9).invoke(null, objArr36)).longValue();
                                                long j19 = i;
                                                long j20 = j19 ^ (-1);
                                                long j21 = (-717117147036L) + ((-520) * jLongValue6) + ((-1042) * ((-1373787638) | ((j20 | jLongValue6) ^ (-1)))) + ((jLongValue6 | j19) * 521) + (521 * ((((j20 | (-1373787638)) | jLongValue6) ^ (-1)) | ((1373787637 | (jLongValue6 ^ (-1))) ^ (-1)) | ((1373787637 | j19) ^ (-1)))) + 1880940751;
                                                int iMyTid4 = Process.myTid();
                                                int i180 = ~iMyTid4;
                                                i12 = ((int) (j21 >> 32)) & ((-2055567968) + ((496048927 | (~((-941177484) | i180))) * 226) + (((~(i180 | (-537403521))) | 92274964 | (~((-496048928) | iMyTid4))) * (-113)) + ((~(iMyTid4 | (-941177484))) * 113));
                                                int iMyTid5 = Process.myTid();
                                                i13 = ((int) j21) & ((((~(107666753 | iMyTid5)) | (-1544893164)) * 56) + 586732173 + (((~((~iMyTid5) | (-1544893164))) | 107666753) * 56));
                                                if (((i12 & i13) | (i12 ^ i13)) == -2096167706) {
                                                    objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                                    String str12 = (String) Class.forName(str).getField(str7).get(objInvoke);
                                                    ((int[]) objArr[1])[0] = i;
                                                    ((int[]) objArr[0])[0] = (i & (-21)) | (i22 & 20);
                                                    int iMyTid6 = Process.myTid();
                                                    int i181 = ~iMyTid6;
                                                    int i182 = 1195074411 + (((~((-1032673571) | i181)) | 218437888 | (~(816497762 | i181)) | (~((-2262081) | iMyTid6))) * (-84));
                                                    int i183 = (~(iMyTid6 | 816497762)) | 1032673570;
                                                    int i184 = ~(i181 | (-816497763));
                                                    int i185 = i182 + ((i183 | i184) * (-84)) + ((2262080 | i184) * 84);
                                                    int i186 = (i3 - (~(-(-((i185 ^ 16) + ((i185 & 16) << 1)))))) - 1;
                                                    int i187 = i186 << 13;
                                                    int i188 = (i186 | i187) & (~(i186 & i187));
                                                    int i189 = i188 >>> 17;
                                                    int i190 = ((~i188) & i189) | ((~i189) & i188);
                                                    int i191 = i190 << 5;
                                                    ((int[]) objArr[4])[0] = ((~i190) & i191) | ((~i191) & i190);
                                                } else {
                                                    i11 = (i11 | 1) + (i11 & 1);
                                                }
                                            } else {
                                                String strSubstring2 = ((String) Class.forName(str).getField(str7).get(objInvoke)).substring(0, iIndexOf);
                                                Object[] objArr38 = new Object[1];
                                                c(new int[]{-647286776, 1066016995}, -TextUtils.indexOf((CharSequence) "", '0'), objArr38);
                                                strArrSplit = strSubstring2.split((String) objArr38[0]);
                                                length2 = strArrSplit.length;
                                                i7 = 0;
                                                while (true) {
                                                    if (i7 < length2) {
                                                        str4 = strArrSplit[i7];
                                                        objArr6 = new Object[1];
                                                        c(new int[]{1256247113, 743108622}, 3 - (~(-(-ExpandableListView.getPackedPositionChild(0L)))), objArr6);
                                                        if (str4.split((String) objArr6[0]).length > 1) {
                                                            synchronized (((Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getKeyRepeatDelay() >> 16) + 52, (char) Color.argb(0, 0, 0, 0), 5110 - (Process.myTid() >> 22)))) {
                                                                try {
                                                                    int i192 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                                    Object[] objArr39 = new Object[1];
                                                                    c(new int[]{1229183738, -869726461, 727891771, -1441667472, -1387748536, -462037949, 2022645205, -1192444893}, (i192 & 16) + (i192 | 16), objArr39);
                                                                    String str13 = (String) objArr39[0];
                                                                    try {
                                                                        Runtime runtime = Runtime.getRuntime();
                                                                        int i193 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                                        int i194 = (i193 & 1) + (i193 | 1);
                                                                        int i195 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                                                        int i196 = (i195 ^ 2) + ((i195 & 2) << 1);
                                                                        int packedPositionChild3 = ExpandableListView.getPackedPositionChild(0L);
                                                                        int i197 = packedPositionChild3 * (-661);
                                                                        int i198 = (i197 ^ (-129556)) + ((i197 & (-129556)) << 1);
                                                                        int i199 = ~packedPositionChild3;
                                                                        strArr = strArrSplit;
                                                                        int i200 = ~((i199 & (-197)) | (i199 ^ (-197)));
                                                                        int i201 = (i198 - (~(-(-(((i22 & i200) | (i22 ^ i200)) * 1324))))) - 1;
                                                                        int i202 = ~(packedPositionChild3 | i);
                                                                        int i203 = ~((i & 196) | (i ^ 196));
                                                                        int i204 = ((i202 & i203) | (i202 ^ i203)) * (-1324);
                                                                        int i205 = (i201 ^ i204) + ((i204 & i201) << 1);
                                                                        int i206 = -(-(((~((i199 ^ 196) | (i199 & 196))) | (~((packedPositionChild3 & (-197)) | ((-197) ^ packedPositionChild3)))) * 662));
                                                                        int i207 = ((i205 | i206) << 1) - (i206 ^ i205);
                                                                        try {
                                                                            Object[] objArr40 = new Object[1];
                                                                            a("\ufffb\u0006", i194, true, i196, i207, objArr40);
                                                                            processExec = runtime.exec((String) objArr40[0], (String[]) null, (File) null);
                                                                            try {
                                                                                Object[] objArr41 = {processExec.getInputStream()};
                                                                                objComponent5 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                                                if (objComponent5 == null) {
                                                                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 4955 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 2119435613, false, null, new Class[]{InputStream.class});
                                                                                }
                                                                                Object objNewInstance = ((Constructor) objComponent5).newInstance(objArr41);
                                                                                try {
                                                                                    Object[] objArr42 = {processExec.getErrorStream()};
                                                                                    objComponent6 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                                                    if (objComponent6 == null) {
                                                                                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                                                    }
                                                                                    Object objNewInstance2 = ((Constructor) objComponent6).newInstance(objArr42);
                                                                                    dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                                                                                    try {
                                                                                        Class<?> cls3 = Class.forName(str2);
                                                                                        int i208 = -(-TextUtils.getCapsMode("", 0, 0));
                                                                                        int i209 = (i208 ^ 3) + ((i208 & 3) << 1);
                                                                                        int i210 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                                                        int i211 = ((i210 | 5) << 1) - (i210 ^ 5);
                                                                                        int i212 = -KeyEvent.keyCodeFromString("");
                                                                                        int i213 = ((i212 | 197) << 1) - (i212 ^ 197);
                                                                                        Object[] objArr43 = new Object[1];
                                                                                        a("\ufff2\u0003\u0005\u0004\u0005", i209, false, i211, i213, objArr43);
                                                                                        cls3.getMethod((String) objArr43[0], null).invoke(objNewInstance, null);
                                                                                        try {
                                                                                            Class<?> cls4 = Class.forName(str2);
                                                                                            int i214 = -View.MeasureSpec.getSize(0);
                                                                                            i8 = length2;
                                                                                            int i215 = (i214 ^ 3) + ((i214 & 3) << 1);
                                                                                            try {
                                                                                                int i216 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                                                                Object[] objArr44 = new Object[1];
                                                                                                a("\ufff2\u0003\u0005\u0004\u0005", i215, false, ((i216 | 5) << 1) - (i216 ^ 5), 196 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr44);
                                                                                                cls4.getMethod((String) objArr44[0], null).invoke(objNewInstance2, null);
                                                                                                try {
                                                                                                    StringBuilder sb = new StringBuilder();
                                                                                                    sb.append(str13);
                                                                                                    Object[] objArr45 = new Object[1];
                                                                                                    a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), true, 0 - (~(-Drawable.resolveOpacity(0, 0))), 97 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr45);
                                                                                                    sb.append((String) objArr45[0]);
                                                                                                    String string = sb.toString();
                                                                                                    Object[] objArr46 = new Object[1];
                                                                                                    c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, 4 - (~(-TextUtils.indexOf("", "", 0))), objArr46);
                                                                                                    dataOutputStream.write(string.getBytes((String) objArr46[0]));
                                                                                                    dataOutputStream.flush();
                                                                                                    Object[] objArr47 = new Object[1];
                                                                                                    c(new int[]{1461719434, 108309334, 355309575, -982923999}, 4 - (~(-Color.red(0))), objArr47);
                                                                                                    String str14 = (String) objArr47[0];
                                                                                                    int maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
                                                                                                    Object[] objArr48 = new Object[1];
                                                                                                    c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, (maxKeyCode & 5) + (maxKeyCode | 5), objArr48);
                                                                                                    dataOutputStream.write(str14.getBytes((String) objArr48[0]));
                                                                                                    dataOutputStream.flush();
                                                                                                    try {
                                                                                                        long jNanoTime = System.nanoTime();
                                                                                                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                                                                                                        long j22 = 2000000000;
                                                                                                        while (true) {
                                                                                                            try {
                                                                                                                processExec.exitValue();
                                                                                                                i9 = i7;
                                                                                                                dataOutputStream2 = dataOutputStream;
                                                                                                                break;
                                                                                                            } catch (IllegalThreadStateException unused) {
                                                                                                                if (j22 > 0) {
                                                                                                                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                                                                                                                    int i217 = i7;
                                                                                                                    DataOutputStream dataOutputStream3 = dataOutputStream;
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            Object[] objArr49 = {Long.valueOf(Math.min((j22 / 1000000) + 1, 3L))};
                                                                                                                            Class<?> cls5 = Class.forName(str2);
                                                                                                                            i9 = i217;
                                                                                                                            try {
                                                                                                                                int i218 = -View.resolveSizeAndState(0, 0, 0);
                                                                                                                                int i219 = i218 * 465;
                                                                                                                                int i220 = ((i219 | (-2315)) << 1) - (i219 ^ (-2315));
                                                                                                                                int i221 = ~(((-6) ^ i28) | ((-6) & i28));
                                                                                                                                dataOutputStream2 = dataOutputStream3;
                                                                                                                                int i222 = ~(((-6) ^ i218) | ((-6) & i218));
                                                                                                                                int i223 = (i221 ^ i222) | (i221 & i222);
                                                                                                                                int i224 = ~((i22 ^ i218) | (i22 & i218));
                                                                                                                                int i225 = (i220 - (~(((i223 ^ i224) | (i224 & i223)) * 464))) - 1;
                                                                                                                                int i226 = ~i218;
                                                                                                                                int i227 = (i226 & i) | (i ^ i226);
                                                                                                                                int i228 = (i225 - (~(-(-(((i227 & (-6)) | (i227 ^ (-6))) * (-464)))))) - 1;
                                                                                                                                int i229 = ~((i218 ^ i) | (i218 & i));
                                                                                                                                int i230 = ((i222 & i229) | (i222 ^ i229)) * 464;
                                                                                                                                Object[] objArr50 = new Object[1];
                                                                                                                                c(new int[]{967636779, -1251482333, -116158072, 1159785327}, (i228 & i230) + (i230 | i228), objArr50);
                                                                                                                                cls5.getMethod((String) objArr50[0], Long.TYPE).invoke(null, objArr49);
                                                                                                                            } catch (Throwable th) {
                                                                                                                                th = th;
                                                                                                                                Throwable cause = th.getCause();
                                                                                                                                if (cause != null) {
                                                                                                                                    throw cause;
                                                                                                                                }
                                                                                                                                throw th;
                                                                                                                            }
                                                                                                                        } catch (Throwable th2) {
                                                                                                                            th = th2;
                                                                                                                        }
                                                                                                                    } catch (InterruptedException e) {
                                                                                                                        throw e;
                                                                                                                    } catch (Throwable th3) {
                                                                                                                        th = th3;
                                                                                                                        try {
                                                                                                                            processExec.destroy();
                                                                                                                        } catch (Exception unused2) {
                                                                                                                        }
                                                                                                                        throw th;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i9 = i7;
                                                                                                                    dataOutputStream2 = dataOutputStream;
                                                                                                                }
                                                                                                                TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
                                                                                                                long jNanoTime2 = 2000000000 - (System.nanoTime() - jNanoTime);
                                                                                                                if (jNanoTime2 <= 0) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                i7 = i9;
                                                                                                                j22 = jNanoTime2;
                                                                                                                dataOutputStream = dataOutputStream2;
                                                                                                            }
                                                                                                        }
                                                                                                        try {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    dataOutputStream2.close();
                                                                                                                } catch (Throwable th4) {
                                                                                                                    th = th4;
                                                                                                                    processExec.destroy();
                                                                                                                    throw th;
                                                                                                                }
                                                                                                            } catch (IOException unused3) {
                                                                                                            }
                                                                                                            try {
                                                                                                                Class<?> cls6 = Class.forName(str2);
                                                                                                                int iArgb = Color.argb(0, 0, 0, 0);
                                                                                                                Object[] objArr51 = new Object[1];
                                                                                                                a("\u0002\ufffe\u0003�", ((iArgb | 1) << 1) - (iArgb ^ 1), false, 3 - (~(-(-TextUtils.indexOf("", "")))), 194 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr51);
                                                                                                                cls6.getMethod((String) objArr51[0], Long.TYPE).invoke(objNewInstance, 100L);
                                                                                                                try {
                                                                                                                    Class<?> cls7 = Class.forName(str2);
                                                                                                                    int i231 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                                                                                                    int i232 = 2 - (~(-MotionEvent.axisFromString("")));
                                                                                                                    int iResolveSize = View.resolveSize(0, 0);
                                                                                                                    int i233 = (iResolveSize ^ 194) + ((iResolveSize & 194) << 1);
                                                                                                                    Object[] objArr52 = new Object[1];
                                                                                                                    a("\u0002\ufffe\u0003�", i231, false, i232, i233, objArr52);
                                                                                                                    cls7.getMethod((String) objArr52[0], Long.TYPE).invoke(objNewInstance2, 10L);
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            processExec.destroy();
                                                                                                                        } catch (IOException unused4) {
                                                                                                                        }
                                                                                                                    } catch (Exception unused5) {
                                                                                                                    }
                                                                                                                    try {
                                                                                                                        StringBuilder sb2 = new StringBuilder();
                                                                                                                        objComponent7 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                                                                                        if (objComponent7 == null) {
                                                                                                                            int iMyTid7 = (Process.myTid() >> 22) + 52;
                                                                                                                            char c7 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                                                                                            int i234 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4953;
                                                                                                                            Object[] objArr53 = new Object[1];
                                                                                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr53);
                                                                                                                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid7, c7, i234, -1351202600, false, (String) objArr53[0], null);
                                                                                                                        }
                                                                                                                        sb2.append(((Field) objComponent7).get(objNewInstance).toString());
                                                                                                                        objComponent8 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                                                                                        if (objComponent8 == null) {
                                                                                                                            int tapTimeout = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                                                                                                                            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                                                                            int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 4955;
                                                                                                                            Object[] objArr54 = new Object[1];
                                                                                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr54);
                                                                                                                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout, maximumFlingVelocity, iLastIndexOf3, -1351202600, false, (String) objArr54[0], null);
                                                                                                                        }
                                                                                                                        sb2.append(((Field) objComponent8).get(objNewInstance2).toString());
                                                                                                                        String string2 = sb2.toString();
                                                                                                                        Object[] objArr55 = new Object[1];
                                                                                                                        a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, KeyEvent.normalizeMetaState(0) + 1, true, 0 - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), 95 - (~(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))), objArr55);
                                                                                                                        strArrSplit2 = string2.split((String) objArr55[0]);
                                                                                                                        length3 = strArrSplit2.length;
                                                                                                                        i10 = 0;
                                                                                                                        while (true) {
                                                                                                                            if (i10 < length3) {
                                                                                                                                str5 = strArrSplit2[i10];
                                                                                                                                objArr7 = new Object[1];
                                                                                                                                c(new int[]{-1387748536, -462037949, 824870072, 1832807441, 1394377890, -1690343399, 1511661316, 320792996, -635533204, -1085246804}, 18 - (~(-View.MeasureSpec.getSize(0))), objArr7);
                                                                                                                                if (!str5.startsWith((String) objArr7[0])) {
                                                                                                                                    int i235 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                                                                                                    int i236 = ((i235 | 11) << 1) - (i235 ^ 11);
                                                                                                                                    int i237 = -(-TextUtils.indexOf("", "", 0));
                                                                                                                                    objArr8 = new Object[1];
                                                                                                                                    a("\r\u000f\u0003ￚ\u0005\u0007\u0001\u000b\u0003\u0001\u0010ￎ\u0004\t\u000f\u0012\u0004\u000e\u0001ￎ", i236, true, (i237 ^ 20) + ((i237 & 20) << 1), 182 - KeyEvent.getDeadChar(0, 0), objArr8);
                                                                                                                                    if (str5.startsWith((String) objArr8[0])) {
                                                                                                                                        continue;
                                                                                                                                    } else {
                                                                                                                                        int i238 = -ExpandableListView.getPackedPositionChild(0L);
                                                                                                                                        int i239 = (i238 * 714) - 4984;
                                                                                                                                        int i240 = ~i238;
                                                                                                                                        int i241 = ~((i240 & i22) | (i240 ^ i22));
                                                                                                                                        int i242 = ~i238;
                                                                                                                                        int i243 = ~((i242 ^ 7) | (i242 & 7));
                                                                                                                                        int i244 = (i241 ^ i243) | (i241 & i243);
                                                                                                                                        int i245 = ((-8) ^ i238) | ((-8) & i238);
                                                                                                                                        int i246 = ~((i245 ^ i) | (i245 & i));
                                                                                                                                        int i247 = -(-(((i244 ^ i246) | (i244 & i246)) * (-713)));
                                                                                                                                        int i248 = ((i239 | i247) << 1) - (i239 ^ i247);
                                                                                                                                        int i249 = (i238 & (-8)) | ((-8) ^ i238);
                                                                                                                                        int i250 = (~((i249 & i) | (i249 ^ i))) * 1426;
                                                                                                                                        int i251 = (((i248 | i250) << 1) - (i250 ^ i248)) + ((~((-8) | i22)) * 713);
                                                                                                                                        objArr9 = new Object[1];
                                                                                                                                        c(new int[]{-1387748536, -462037949, 824870072, 1832807441}, i251, objArr9);
                                                                                                                                        if (str5.startsWith((String) objArr9[0])) {
                                                                                                                                            int i252 = -(-View.resolveSize(0, 0));
                                                                                                                                            int i253 = (i252 ^ 1) + ((i252 & 1) << 1);
                                                                                                                                            int i254 = 0 - (~View.combineMeasuredStates(0, 0));
                                                                                                                                            int i255 = -(-Color.alpha(0));
                                                                                                                                            int i256 = ((i255 | 144) << 1) - (i255 ^ 144);
                                                                                                                                            Object[] objArr56 = new Object[1];
                                                                                                                                            a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i253, false, i254, i256, objArr56);
                                                                                                                                            strArrSplit3 = str5.split((String) objArr56[0]);
                                                                                                                                            if (strArrSplit3.length <= 1 || !strArrSplit3[1].equalsIgnoreCase(str4)) {
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            continue;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                i10++;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Exception unused6) {
                                                                                                                        int i257 = -Drawable.resolveOpacity(0, 0);
                                                                                                                        int pivotYN16906 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                                                                                                                        int i258 = (i257 * (-167)) - 1503;
                                                                                                                        int i259 = ~i257;
                                                                                                                        int i260 = ~((i259 & (-10)) | (i259 ^ (-10)));
                                                                                                                        int i261 = ~((-10) | pivotYN16906);
                                                                                                                        int i262 = -(-(((i260 & i261) | (i260 ^ i261)) * 336));
                                                                                                                        int i263 = (i258 ^ i262) + ((i258 & i262) << 1);
                                                                                                                        int i264 = ~((i257 ^ 9) | (i257 & 9));
                                                                                                                        int i265 = ~(i257 | pivotYN16906);
                                                                                                                        int i266 = ((i264 & i265) | (i264 ^ i265)) * (-168);
                                                                                                                        int i267 = (i263 & i266) + (i266 | i263);
                                                                                                                        int i268 = ~pivotYN16906;
                                                                                                                        int i269 = ~((i257 & i268) | (i268 ^ i257));
                                                                                                                        int i270 = ((i269 & (-10)) | ((-10) ^ i269)) * 168;
                                                                                                                        int i271 = ((i267 | i270) << 1) - (i270 ^ i267);
                                                                                                                        int i272 = 26 - (~(-(ViewConfiguration.getEdgeSlop() >> 16)));
                                                                                                                        int i273 = -TextUtils.getCapsMode("", 0, 0);
                                                                                                                        int i274 = ((i273 | 177) << 1) - (i273 ^ 177);
                                                                                                                        Object[] objArr57 = new Object[1];
                                                                                                                        a("ￅ\u0015\u0017\u0014\b\n\u0018\u0018ￓ￫\u0006\u000e\u0011\n\tￅ\u0019\u0014ￅ\b\u0017\n\u0006\u0019\nￅ\u0006", i271, false, i272, i274, objArr57);
                                                                                                                        throw new IOException((String) objArr57[0]);
                                                                                                                    }
                                                                                                                } catch (Throwable th5) {
                                                                                                                    Throwable cause2 = th5.getCause();
                                                                                                                    if (cause2 != null) {
                                                                                                                        throw cause2;
                                                                                                                    }
                                                                                                                    throw th5;
                                                                                                                }
                                                                                                            } catch (Throwable th6) {
                                                                                                                Throwable cause3 = th6.getCause();
                                                                                                                if (cause3 != null) {
                                                                                                                    throw cause3;
                                                                                                                }
                                                                                                                throw th6;
                                                                                                            }
                                                                                                        } catch (InterruptedException e2) {
                                                                                                            throw e2;
                                                                                                        }
                                                                                                    } catch (InterruptedException e3) {
                                                                                                        throw e3;
                                                                                                    } catch (Throwable th7) {
                                                                                                        th = th7;
                                                                                                    }
                                                                                                } catch (IOException unused7) {
                                                                                                    i9 = i7;
                                                                                                } catch (Exception unused8) {
                                                                                                    int i2510 = -Drawable.resolveOpacity(0, 0);
                                                                                                    int pivotYN16907 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                                                                                                    int i2511 = (i2510 * (-167)) - 1503;
                                                                                                    int i2512 = ~i2510;
                                                                                                    int i2610 = ~((i2512 & (-10)) | (i2512 ^ (-10)));
                                                                                                    int i2611 = ~((-10) | pivotYN16907);
                                                                                                    int i2612 = -(-(((i2610 & i2611) | (i2610 ^ i2611)) * 336));
                                                                                                    int i2613 = (i2511 ^ i2612) + ((i2511 & i2612) << 1);
                                                                                                    int i2614 = ~((i2510 ^ 9) | (i2510 & 9));
                                                                                                    int i2615 = ~(i2510 | pivotYN16907);
                                                                                                    int i2616 = ((i2614 & i2615) | (i2614 ^ i2615)) * (-168);
                                                                                                    int i2617 = (i2613 & i2616) + (i2616 | i2613);
                                                                                                    int i2618 = ~pivotYN16907;
                                                                                                    int i2619 = ~((i2510 & i2618) | (i2618 ^ i2510));
                                                                                                    int i275 = ((i2619 & (-10)) | ((-10) ^ i2619)) * 168;
                                                                                                    int i276 = ((i2617 | i275) << 1) - (i275 ^ i2617);
                                                                                                    int i277 = 26 - (~(-(ViewConfiguration.getEdgeSlop() >> 16)));
                                                                                                    int i278 = -TextUtils.getCapsMode("", 0, 0);
                                                                                                    int i279 = ((i278 | 177) << 1) - (i278 ^ 177);
                                                                                                    Object[] objArr58 = new Object[1];
                                                                                                    a("ￅ\u0015\u0017\u0014\b\n\u0018\u0018ￓ￫\u0006\u000e\u0011\n\tￅ\u0019\u0014ￅ\b\u0017\n\u0006\u0019\nￅ\u0006", i276, false, i277, i279, objArr58);
                                                                                                    throw new IOException((String) objArr58[0]);
                                                                                                }
                                                                                            } catch (Throwable th8) {
                                                                                                th = th8;
                                                                                                Throwable cause4 = th.getCause();
                                                                                                if (cause4 != null) {
                                                                                                    throw cause4;
                                                                                                }
                                                                                                throw th;
                                                                                            }
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                        }
                                                                                    } catch (Throwable th10) {
                                                                                        Throwable cause5 = th10.getCause();
                                                                                        if (cause5 != null) {
                                                                                            throw cause5;
                                                                                        }
                                                                                        throw th10;
                                                                                    }
                                                                                } catch (Throwable th11) {
                                                                                    Throwable cause6 = th11.getCause();
                                                                                    if (cause6 != null) {
                                                                                        throw cause6;
                                                                                    }
                                                                                    throw th11;
                                                                                }
                                                                            } catch (Throwable th12) {
                                                                                Throwable cause7 = th12.getCause();
                                                                                if (cause7 != null) {
                                                                                    throw cause7;
                                                                                }
                                                                                throw th12;
                                                                            }
                                                                        } catch (IOException unused9) {
                                                                            i8 = length2;
                                                                            i9 = i7;
                                                                            int i280 = i9 - 68;
                                                                            i7 = (i280 & 69) + (i280 | 69);
                                                                            strArrSplit = strArr;
                                                                            length2 = i8;
                                                                        } catch (Exception unused10) {
                                                                            int i2513 = -Drawable.resolveOpacity(0, 0);
                                                                            int pivotYN16908 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                                                                            int i2514 = (i2513 * (-167)) - 1503;
                                                                            int i2515 = ~i2513;
                                                                            int i26110 = ~((i2515 & (-10)) | (i2515 ^ (-10)));
                                                                            int i26111 = ~((-10) | pivotYN16908);
                                                                            int i26112 = -(-(((i26110 & i26111) | (i26110 ^ i26111)) * 336));
                                                                            int i26113 = (i2514 ^ i26112) + ((i2514 & i26112) << 1);
                                                                            int i26114 = ~((i2513 ^ 9) | (i2513 & 9));
                                                                            int i26115 = ~(i2513 | pivotYN16908);
                                                                            int i26116 = ((i26114 & i26115) | (i26114 ^ i26115)) * (-168);
                                                                            int i26117 = (i26113 & i26116) + (i26116 | i26113);
                                                                            int i26118 = ~pivotYN16908;
                                                                            int i26119 = ~((i2513 & i26118) | (i26118 ^ i2513));
                                                                            int i2710 = ((i26119 & (-10)) | ((-10) ^ i26119)) * 168;
                                                                            int i2711 = ((i26117 | i2710) << 1) - (i2710 ^ i26117);
                                                                            int i2712 = 26 - (~(-(ViewConfiguration.getEdgeSlop() >> 16)));
                                                                            int i2713 = -TextUtils.getCapsMode("", 0, 0);
                                                                            int i2714 = ((i2713 | 177) << 1) - (i2713 ^ 177);
                                                                            Object[] objArr59 = new Object[1];
                                                                            a("ￅ\u0015\u0017\u0014\b\n\u0018\u0018ￓ￫\u0006\u000e\u0011\n\tￅ\u0019\u0014ￅ\b\u0017\n\u0006\u0019\nￅ\u0006", i2711, false, i2712, i2714, objArr59);
                                                                            throw new IOException((String) objArr59[0]);
                                                                        }
                                                                    } catch (Exception unused11) {
                                                                    }
                                                                } catch (IOException unused12) {
                                                                    strArr = strArrSplit;
                                                                }
                                                            }
                                                            objArr = new Object[]{new int[1], new int[1], str, null, new int[1]};
                                                            String str15 = (String) Class.forName(str).getField(str7).get(objInvoke);
                                                            ((int[]) objArr[1])[0] = i;
                                                            ((int[]) objArr[0])[0] = i ^ 20;
                                                            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                                            int i281 = ~elapsedCpuTime;
                                                            int i282 = (~((-40234822) | i281)) | 84485 | (~(175940986 | i281));
                                                            int i283 = 1753917081 + (((~(elapsedCpuTime | (-135790651))) | i282) * 590) + (i282 * (-1180)) + (((~((-175940987) | i281)) | (~(i281 | 40234821))) * 590);
                                                            int i284 = i3 + (((i283 | 16) << 1) - (i283 ^ 16));
                                                            int i285 = i284 << 13;
                                                            int i286 = (i284 | i285) & (~(i284 & i285));
                                                            int i287 = i286 >>> 17;
                                                            int i288 = ((~i286) & i287) | ((~i287) & i286);
                                                            ((int[]) objArr[4])[0] = i288 ^ (i288 << 5);
                                                        } else {
                                                            strArr = strArrSplit;
                                                            i8 = length2;
                                                            i9 = i7;
                                                        }
                                                        int i289 = i9 - 68;
                                                        i7 = (i289 & 69) + (i289 | 69);
                                                        strArrSplit = strArr;
                                                        length2 = i8;
                                                    } else {
                                                        objArr = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i) & i) | ((~i) & i)}};
                                                        int i290 = 628044591 + (((~(128393993 | i22)) | (-397391818) | (~(i22 | 344569801))) * 464) + (((-268997825) | i) * (-464)) + (((~(i | 344569801)) | (-397391818)) * 464);
                                                        int i291 = (i3 - (~((i290 << 1) - i290))) - 1;
                                                        int i292 = i291 ^ (i291 << 13);
                                                        int i293 = i292 >>> 17;
                                                        int i294 = ((~i292) & i293) | ((~i293) & i292);
                                                        int i295 = i294 << 5;
                                                        c = 0;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        String strSubstring3 = ((String) Class.forName(str).getField(str7).get(objInvoke)).substring(0, iIndexOf);
                                        Object[] objArr310 = new Object[1];
                                        c(new int[]{-647286776, 1066016995}, -TextUtils.indexOf((CharSequence) "", '0'), objArr310);
                                        strArrSplit = strSubstring3.split((String) objArr310[0]);
                                        length2 = strArrSplit.length;
                                        i7 = 0;
                                        while (true) {
                                            if (i7 < length2) {
                                                str4 = strArrSplit[i7];
                                                objArr6 = new Object[1];
                                                c(new int[]{1256247113, 743108622}, 3 - (~(-(-ExpandableListView.getPackedPositionChild(0L)))), objArr6);
                                                if (str4.split((String) objArr6[0]).length > 1) {
                                                    synchronized (((Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getKeyRepeatDelay() >> 16) + 52, (char) Color.argb(0, 0, 0, 0), 5110 - (Process.myTid() >> 22)))) {
                                                        int i1910 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                        Object[] objArr311 = new Object[1];
                                                        c(new int[]{1229183738, -869726461, 727891771, -1441667472, -1387748536, -462037949, 2022645205, -1192444893}, (i1910 & 16) + (i1910 | 16), objArr311);
                                                        String str16 = (String) objArr311[0];
                                                        Runtime runtime2 = Runtime.getRuntime();
                                                        int i1911 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                        int i1912 = (i1911 & 1) + (i1911 | 1);
                                                        int i1913 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                                        int i1914 = (i1913 ^ 2) + ((i1913 & 2) << 1);
                                                        int packedPositionChild4 = ExpandableListView.getPackedPositionChild(0L);
                                                        int i1915 = packedPositionChild4 * (-661);
                                                        int i1916 = (i1915 ^ (-129556)) + ((i1915 & (-129556)) << 1);
                                                        int i1917 = ~packedPositionChild4;
                                                        strArr = strArrSplit;
                                                        int i2010 = ~((i1917 & (-197)) | (i1917 ^ (-197)));
                                                        int i2011 = (i1916 - (~(-(-(((i22 & i2010) | (i22 ^ i2010)) * 1324))))) - 1;
                                                        int i2012 = ~(packedPositionChild4 | i);
                                                        int i2013 = ~((i & 196) | (i ^ 196));
                                                        int i2014 = ((i2012 & i2013) | (i2012 ^ i2013)) * (-1324);
                                                        int i2015 = (i2011 ^ i2014) + ((i2014 & i2011) << 1);
                                                        int i2016 = -(-(((~((i1917 ^ 196) | (i1917 & 196))) | (~((packedPositionChild4 & (-197)) | ((-197) ^ packedPositionChild4)))) * 662));
                                                        int i2017 = ((i2015 | i2016) << 1) - (i2016 ^ i2015);
                                                        Object[] objArr410 = new Object[1];
                                                        a("\ufffb\u0006", i1912, true, i1914, i2017, objArr410);
                                                        processExec = runtime2.exec((String) objArr410[0], (String[]) null, (File) null);
                                                        Object[] objArr411 = {processExec.getInputStream()};
                                                        objComponent5 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                        if (objComponent5 == null) {
                                                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 4955 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 2119435613, false, null, new Class[]{InputStream.class});
                                                        }
                                                        Object objNewInstance3 = ((Constructor) objComponent5).newInstance(objArr411);
                                                        Object[] objArr412 = {processExec.getErrorStream()};
                                                        objComponent6 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                        if (objComponent6 == null) {
                                                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                        }
                                                        Object objNewInstance4 = ((Constructor) objComponent6).newInstance(objArr412);
                                                        dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                                                        Class<?> cls8 = Class.forName(str2);
                                                        int i2018 = -(-TextUtils.getCapsMode("", 0, 0));
                                                        int i2019 = (i2018 ^ 3) + ((i2018 & 3) << 1);
                                                        int i2110 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                        int i2111 = ((i2110 | 5) << 1) - (i2110 ^ 5);
                                                        int i2112 = -KeyEvent.keyCodeFromString("");
                                                        int i2113 = ((i2112 | 197) << 1) - (i2112 ^ 197);
                                                        Object[] objArr413 = new Object[1];
                                                        a("\ufff2\u0003\u0005\u0004\u0005", i2019, false, i2111, i2113, objArr413);
                                                        cls8.getMethod((String) objArr413[0], null).invoke(objNewInstance3, null);
                                                        Class<?> cls9 = Class.forName(str2);
                                                        int i2114 = -View.MeasureSpec.getSize(0);
                                                        i8 = length2;
                                                        int i2115 = (i2114 ^ 3) + ((i2114 & 3) << 1);
                                                        int i2116 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                        Object[] objArr414 = new Object[1];
                                                        a("\ufff2\u0003\u0005\u0004\u0005", i2115, false, ((i2116 | 5) << 1) - (i2116 ^ 5), 196 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr414);
                                                        cls9.getMethod((String) objArr414[0], null).invoke(objNewInstance4, null);
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append(str16);
                                                        Object[] objArr415 = new Object[1];
                                                        a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), true, 0 - (~(-Drawable.resolveOpacity(0, 0))), 97 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr415);
                                                        sb3.append((String) objArr415[0]);
                                                        String string3 = sb3.toString();
                                                        Object[] objArr416 = new Object[1];
                                                        c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, 4 - (~(-TextUtils.indexOf("", "", 0))), objArr416);
                                                        dataOutputStream.write(string3.getBytes((String) objArr416[0]));
                                                        dataOutputStream.flush();
                                                        Object[] objArr417 = new Object[1];
                                                        c(new int[]{1461719434, 108309334, 355309575, -982923999}, 4 - (~(-Color.red(0))), objArr417);
                                                        String str17 = (String) objArr417[0];
                                                        int maxKeyCode2 = KeyEvent.getMaxKeyCode() >> 16;
                                                        Object[] objArr418 = new Object[1];
                                                        c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, (maxKeyCode2 & 5) + (maxKeyCode2 | 5), objArr418);
                                                        dataOutputStream.write(str17.getBytes((String) objArr418[0]));
                                                        dataOutputStream.flush();
                                                        long jNanoTime3 = System.nanoTime();
                                                        TimeUnit timeUnit4 = TimeUnit.MILLISECONDS;
                                                        long j23 = 2000000000;
                                                        while (true) {
                                                            processExec.exitValue();
                                                            i9 = i7;
                                                            dataOutputStream2 = dataOutputStream;
                                                            break;
                                                        }
                                                        dataOutputStream2.close();
                                                        Class<?> cls10 = Class.forName(str2);
                                                        int iArgb2 = Color.argb(0, 0, 0, 0);
                                                        Object[] objArr510 = new Object[1];
                                                        a("\u0002\ufffe\u0003�", ((iArgb2 | 1) << 1) - (iArgb2 ^ 1), false, 3 - (~(-(-TextUtils.indexOf("", "")))), 194 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr510);
                                                        cls10.getMethod((String) objArr510[0], Long.TYPE).invoke(objNewInstance3, 100L);
                                                        Class<?> cls11 = Class.forName(str2);
                                                        int i2310 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                                        int i2311 = 2 - (~(-MotionEvent.axisFromString("")));
                                                        int iResolveSize2 = View.resolveSize(0, 0);
                                                        int i2312 = (iResolveSize2 ^ 194) + ((iResolveSize2 & 194) << 1);
                                                        Object[] objArr511 = new Object[1];
                                                        a("\u0002\ufffe\u0003�", i2310, false, i2311, i2312, objArr511);
                                                        cls11.getMethod((String) objArr511[0], Long.TYPE).invoke(objNewInstance4, 10L);
                                                        processExec.destroy();
                                                        StringBuilder sb4 = new StringBuilder();
                                                        objComponent7 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                        if (objComponent7 == null) {
                                                            int iMyTid8 = (Process.myTid() >> 22) + 52;
                                                            char c8 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                            int i2313 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4953;
                                                            Object[] objArr512 = new Object[1];
                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr512);
                                                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid8, c8, i2313, -1351202600, false, (String) objArr512[0], null);
                                                        }
                                                        sb4.append(((Field) objComponent7).get(objNewInstance3).toString());
                                                        objComponent8 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                        if (objComponent8 == null) {
                                                            int tapTimeout2 = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                                                            char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                            int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0) + 4955;
                                                            Object[] objArr513 = new Object[1];
                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr513);
                                                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout2, maximumFlingVelocity2, iLastIndexOf4, -1351202600, false, (String) objArr513[0], null);
                                                        }
                                                        sb4.append(((Field) objComponent8).get(objNewInstance4).toString());
                                                        String string4 = sb4.toString();
                                                        Object[] objArr514 = new Object[1];
                                                        a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, KeyEvent.normalizeMetaState(0) + 1, true, 0 - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), 95 - (~(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))), objArr514);
                                                        strArrSplit2 = string4.split((String) objArr514[0]);
                                                        length3 = strArrSplit2.length;
                                                        i10 = 0;
                                                        while (true) {
                                                            if (i10 < length3) {
                                                                str5 = strArrSplit2[i10];
                                                                objArr7 = new Object[1];
                                                                c(new int[]{-1387748536, -462037949, 824870072, 1832807441, 1394377890, -1690343399, 1511661316, 320792996, -635533204, -1085246804}, 18 - (~(-View.MeasureSpec.getSize(0))), objArr7);
                                                                if (!str5.startsWith((String) objArr7[0])) {
                                                                    int i2314 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                                    int i2315 = ((i2314 | 11) << 1) - (i2314 ^ 11);
                                                                    int i2316 = -(-TextUtils.indexOf("", "", 0));
                                                                    objArr8 = new Object[1];
                                                                    a("\r\u000f\u0003ￚ\u0005\u0007\u0001\u000b\u0003\u0001\u0010ￎ\u0004\t\u000f\u0012\u0004\u000e\u0001ￎ", i2315, true, (i2316 ^ 20) + ((i2316 & 20) << 1), 182 - KeyEvent.getDeadChar(0, 0), objArr8);
                                                                    if (str5.startsWith((String) objArr8[0])) {
                                                                        int i2317 = -ExpandableListView.getPackedPositionChild(0L);
                                                                        int i2318 = (i2317 * 714) - 4984;
                                                                        int i2410 = ~i2317;
                                                                        int i2411 = ~((i2410 & i22) | (i2410 ^ i22));
                                                                        int i2412 = ~i2317;
                                                                        int i2413 = ~((i2412 ^ 7) | (i2412 & 7));
                                                                        int i2414 = (i2411 ^ i2413) | (i2411 & i2413);
                                                                        int i2415 = ((-8) ^ i2317) | ((-8) & i2317);
                                                                        int i2416 = ~((i2415 ^ i) | (i2415 & i));
                                                                        int i2417 = -(-(((i2414 ^ i2416) | (i2414 & i2416)) * (-713)));
                                                                        int i2418 = ((i2318 | i2417) << 1) - (i2318 ^ i2417);
                                                                        int i2419 = (i2317 & (-8)) | ((-8) ^ i2317);
                                                                        int i2516 = (~((i2419 & i) | (i2419 ^ i))) * 1426;
                                                                        int i2517 = (((i2418 | i2516) << 1) - (i2516 ^ i2418)) + ((~((-8) | i22)) * 713);
                                                                        objArr9 = new Object[1];
                                                                        c(new int[]{-1387748536, -462037949, 824870072, 1832807441}, i2517, objArr9);
                                                                        if (str5.startsWith((String) objArr9[0])) {
                                                                            int i2518 = -(-View.resolveSize(0, 0));
                                                                            int i2519 = (i2518 ^ 1) + ((i2518 & 1) << 1);
                                                                            int i2520 = 0 - (~View.combineMeasuredStates(0, 0));
                                                                            int i2521 = -(-Color.alpha(0));
                                                                            int i2522 = ((i2521 | 144) << 1) - (i2521 ^ 144);
                                                                            Object[] objArr515 = new Object[1];
                                                                            a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i2519, false, i2520, i2522, objArr515);
                                                                            strArrSplit3 = str5.split((String) objArr515[0]);
                                                                            if (strArrSplit3.length <= 1) {
                                                                                continue;
                                                                            }
                                                                        } else {
                                                                            continue;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                                i10++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    strArr = strArrSplit;
                                                    i8 = length2;
                                                    i9 = i7;
                                                }
                                                int i2810 = i9 - 68;
                                                i7 = (i2810 & 69) + (i2810 | 69);
                                                strArrSplit = strArr;
                                                length2 = i8;
                                            } else {
                                                objArr = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i294) & i295) | ((~i295) & i294)}};
                                                int i296 = 628044591 + (((~(128393993 | i22)) | (-397391818) | (~(i22 | 344569801))) * 464) + (((-268997825) | i) * (-464)) + (((~(i | 344569801)) | (-397391818)) * 464);
                                                int i297 = (i3 - (~((i296 << 1) - i296))) - 1;
                                                int i298 = i297 ^ (i297 << 13);
                                                int i299 = i298 >>> 17;
                                                int i2910 = ((~i298) & i299) | ((~i299) & i298);
                                                int i2911 = i2910 << 5;
                                                c = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            str = str6;
                            str2 = str8;
                            str3 = (String) Class.forName(str).getField(str7).get(objInvoke);
                            int length6 = str3.length();
                            i6 = (length6 & (-6)) + (length6 | (-6));
                            if (i6 >= 0) {
                                i11 = 0;
                                while (true) {
                                    if (i11 <= i6) {
                                        Object[] objArr312 = {str3.substring(i11, i11 + 6), 931995};
                                        objComponent9 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent9 == null) {
                                            int i1710 = 53 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                            char c9 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                            int iIndexOf3 = TextUtils.indexOf("", "") + 5420;
                                            Object[] objArr313 = new Object[1];
                                            b((byte) ($$b >>> 1), (short) 0, 3, objArr313);
                                            objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(i1710, c9, iIndexOf3, 1884899413, false, (String) objArr313[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue7 = ((Long) ((Method) objComponent9).invoke(null, objArr312)).longValue();
                                        long j110 = i;
                                        long j24 = j110 ^ (-1);
                                        long j25 = (-717117147036L) + ((-520) * jLongValue7) + ((-1042) * ((-1373787638) | ((j24 | jLongValue7) ^ (-1)))) + ((jLongValue7 | j110) * 521) + (521 * ((((j24 | (-1373787638)) | jLongValue7) ^ (-1)) | ((1373787637 | (jLongValue7 ^ (-1))) ^ (-1)) | ((1373787637 | j110) ^ (-1)))) + 1880940751;
                                        int iMyTid9 = Process.myTid();
                                        int i1810 = ~iMyTid9;
                                        i12 = ((int) (j25 >> 32)) & ((-2055567968) + ((496048927 | (~((-941177484) | i1810))) * 226) + (((~(i1810 | (-537403521))) | 92274964 | (~((-496048928) | iMyTid9))) * (-113)) + ((~(iMyTid9 | (-941177484))) * 113));
                                        int iMyTid10 = Process.myTid();
                                        i13 = ((int) j25) & ((((~(107666753 | iMyTid10)) | (-1544893164)) * 56) + 586732173 + (((~((~iMyTid10) | (-1544893164))) | 107666753) * 56));
                                        if (((i12 & i13) | (i12 ^ i13)) == -2096167706) {
                                            objArr = new Object[]{new int[1], new int[1], str12, null, new int[1]};
                                            String str18 = (String) Class.forName(str).getField(str7).get(objInvoke);
                                            ((int[]) objArr[1])[0] = i;
                                            ((int[]) objArr[0])[0] = (i & (-21)) | (i22 & 20);
                                            int iMyTid11 = Process.myTid();
                                            int i1811 = ~iMyTid11;
                                            int i1812 = 1195074411 + (((~((-1032673571) | i1811)) | 218437888 | (~(816497762 | i1811)) | (~((-2262081) | iMyTid11))) * (-84));
                                            int i1813 = (~(iMyTid11 | 816497762)) | 1032673570;
                                            int i1814 = ~(i1811 | (-816497763));
                                            int i1815 = i1812 + ((i1813 | i1814) * (-84)) + ((2262080 | i1814) * 84);
                                            int i1816 = (i3 - (~(-(-((i1815 ^ 16) + ((i1815 & 16) << 1)))))) - 1;
                                            int i1817 = i1816 << 13;
                                            int i1818 = (i1816 | i1817) & (~(i1816 & i1817));
                                            int i1819 = i1818 >>> 17;
                                            int i1918 = ((~i1818) & i1819) | ((~i1819) & i1818);
                                            int i1919 = i1918 << 5;
                                            ((int[]) objArr[4])[0] = ((~i1918) & i1919) | ((~i1919) & i1918);
                                        } else {
                                            i11 = (i11 | 1) + (i11 & 1);
                                        }
                                    } else {
                                        String strSubstring4 = ((String) Class.forName(str).getField(str7).get(objInvoke)).substring(0, iIndexOf);
                                        Object[] objArr314 = new Object[1];
                                        c(new int[]{-647286776, 1066016995}, -TextUtils.indexOf((CharSequence) "", '0'), objArr314);
                                        strArrSplit = strSubstring4.split((String) objArr314[0]);
                                        length2 = strArrSplit.length;
                                        i7 = 0;
                                        while (true) {
                                            if (i7 < length2) {
                                                str4 = strArrSplit[i7];
                                                objArr6 = new Object[1];
                                                c(new int[]{1256247113, 743108622}, 3 - (~(-(-ExpandableListView.getPackedPositionChild(0L)))), objArr6);
                                                if (str4.split((String) objArr6[0]).length > 1) {
                                                    synchronized (((Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getKeyRepeatDelay() >> 16) + 52, (char) Color.argb(0, 0, 0, 0), 5110 - (Process.myTid() >> 22)))) {
                                                        int i19110 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                        Object[] objArr315 = new Object[1];
                                                        c(new int[]{1229183738, -869726461, 727891771, -1441667472, -1387748536, -462037949, 2022645205, -1192444893}, (i19110 & 16) + (i19110 | 16), objArr315);
                                                        String str19 = (String) objArr315[0];
                                                        Runtime runtime3 = Runtime.getRuntime();
                                                        int i19111 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                        int i19112 = (i19111 & 1) + (i19111 | 1);
                                                        int i19113 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                                        int i19114 = (i19113 ^ 2) + ((i19113 & 2) << 1);
                                                        int packedPositionChild5 = ExpandableListView.getPackedPositionChild(0L);
                                                        int i19115 = packedPositionChild5 * (-661);
                                                        int i19116 = (i19115 ^ (-129556)) + ((i19115 & (-129556)) << 1);
                                                        int i19117 = ~packedPositionChild5;
                                                        strArr = strArrSplit;
                                                        int i20110 = ~((i19117 & (-197)) | (i19117 ^ (-197)));
                                                        int i20111 = (i19116 - (~(-(-(((i22 & i20110) | (i22 ^ i20110)) * 1324))))) - 1;
                                                        int i20112 = ~(packedPositionChild5 | i);
                                                        int i20113 = ~((i & 196) | (i ^ 196));
                                                        int i20114 = ((i20112 & i20113) | (i20112 ^ i20113)) * (-1324);
                                                        int i20115 = (i20111 ^ i20114) + ((i20114 & i20111) << 1);
                                                        int i20116 = -(-(((~((i19117 ^ 196) | (i19117 & 196))) | (~((packedPositionChild5 & (-197)) | ((-197) ^ packedPositionChild5)))) * 662));
                                                        int i20117 = ((i20115 | i20116) << 1) - (i20116 ^ i20115);
                                                        Object[] objArr419 = new Object[1];
                                                        a("\ufffb\u0006", i19112, true, i19114, i20117, objArr419);
                                                        processExec = runtime3.exec((String) objArr419[0], (String[]) null, (File) null);
                                                        Object[] objArr4110 = {processExec.getInputStream()};
                                                        objComponent5 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                        if (objComponent5 == null) {
                                                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 4955 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 2119435613, false, null, new Class[]{InputStream.class});
                                                        }
                                                        Object objNewInstance5 = ((Constructor) objComponent5).newInstance(objArr4110);
                                                        Object[] objArr4111 = {processExec.getErrorStream()};
                                                        objComponent6 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                        if (objComponent6 == null) {
                                                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                        }
                                                        Object objNewInstance6 = ((Constructor) objComponent6).newInstance(objArr4111);
                                                        dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                                                        Class<?> cls12 = Class.forName(str2);
                                                        int i20118 = -(-TextUtils.getCapsMode("", 0, 0));
                                                        int i20119 = (i20118 ^ 3) + ((i20118 & 3) << 1);
                                                        int i2117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                        int i2118 = ((i2117 | 5) << 1) - (i2117 ^ 5);
                                                        int i2119 = -KeyEvent.keyCodeFromString("");
                                                        int i21110 = ((i2119 | 197) << 1) - (i2119 ^ 197);
                                                        Object[] objArr4112 = new Object[1];
                                                        a("\ufff2\u0003\u0005\u0004\u0005", i20119, false, i2118, i21110, objArr4112);
                                                        cls12.getMethod((String) objArr4112[0], null).invoke(objNewInstance5, null);
                                                        Class<?> cls13 = Class.forName(str2);
                                                        int i21111 = -View.MeasureSpec.getSize(0);
                                                        i8 = length2;
                                                        int i21112 = (i21111 ^ 3) + ((i21111 & 3) << 1);
                                                        int i21113 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                        Object[] objArr4113 = new Object[1];
                                                        a("\ufff2\u0003\u0005\u0004\u0005", i21112, false, ((i21113 | 5) << 1) - (i21113 ^ 5), 196 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr4113);
                                                        cls13.getMethod((String) objArr4113[0], null).invoke(objNewInstance6, null);
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append(str19);
                                                        Object[] objArr4114 = new Object[1];
                                                        a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), true, 0 - (~(-Drawable.resolveOpacity(0, 0))), 97 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr4114);
                                                        sb5.append((String) objArr4114[0]);
                                                        String string5 = sb5.toString();
                                                        Object[] objArr4115 = new Object[1];
                                                        c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, 4 - (~(-TextUtils.indexOf("", "", 0))), objArr4115);
                                                        dataOutputStream.write(string5.getBytes((String) objArr4115[0]));
                                                        dataOutputStream.flush();
                                                        Object[] objArr4116 = new Object[1];
                                                        c(new int[]{1461719434, 108309334, 355309575, -982923999}, 4 - (~(-Color.red(0))), objArr4116);
                                                        String str110 = (String) objArr4116[0];
                                                        int maxKeyCode3 = KeyEvent.getMaxKeyCode() >> 16;
                                                        Object[] objArr4117 = new Object[1];
                                                        c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, (maxKeyCode3 & 5) + (maxKeyCode3 | 5), objArr4117);
                                                        dataOutputStream.write(str110.getBytes((String) objArr4117[0]));
                                                        dataOutputStream.flush();
                                                        long jNanoTime4 = System.nanoTime();
                                                        TimeUnit timeUnit5 = TimeUnit.MILLISECONDS;
                                                        long j26 = 2000000000;
                                                        while (true) {
                                                            processExec.exitValue();
                                                            i9 = i7;
                                                            dataOutputStream2 = dataOutputStream;
                                                            break;
                                                        }
                                                        dataOutputStream2.close();
                                                        Class<?> cls14 = Class.forName(str2);
                                                        int iArgb3 = Color.argb(0, 0, 0, 0);
                                                        Object[] objArr516 = new Object[1];
                                                        a("\u0002\ufffe\u0003�", ((iArgb3 | 1) << 1) - (iArgb3 ^ 1), false, 3 - (~(-(-TextUtils.indexOf("", "")))), 194 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr516);
                                                        cls14.getMethod((String) objArr516[0], Long.TYPE).invoke(objNewInstance5, 100L);
                                                        Class<?> cls15 = Class.forName(str2);
                                                        int i2319 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                                        int i23110 = 2 - (~(-MotionEvent.axisFromString("")));
                                                        int iResolveSize3 = View.resolveSize(0, 0);
                                                        int i23111 = (iResolveSize3 ^ 194) + ((iResolveSize3 & 194) << 1);
                                                        Object[] objArr517 = new Object[1];
                                                        a("\u0002\ufffe\u0003�", i2319, false, i23110, i23111, objArr517);
                                                        cls15.getMethod((String) objArr517[0], Long.TYPE).invoke(objNewInstance6, 10L);
                                                        processExec.destroy();
                                                        StringBuilder sb6 = new StringBuilder();
                                                        objComponent7 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                        if (objComponent7 == null) {
                                                            int iMyTid12 = (Process.myTid() >> 22) + 52;
                                                            char c10 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                            int i23112 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4953;
                                                            Object[] objArr518 = new Object[1];
                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr518);
                                                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid12, c10, i23112, -1351202600, false, (String) objArr518[0], null);
                                                        }
                                                        sb6.append(((Field) objComponent7).get(objNewInstance5).toString());
                                                        objComponent8 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                        if (objComponent8 == null) {
                                                            int tapTimeout3 = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                                                            char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                            int iLastIndexOf5 = TextUtils.lastIndexOf("", '0', 0) + 4955;
                                                            Object[] objArr519 = new Object[1];
                                                            b(0, (short) 1, (byte) (-$$a[6]), objArr519);
                                                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout3, maximumFlingVelocity3, iLastIndexOf5, -1351202600, false, (String) objArr519[0], null);
                                                        }
                                                        sb6.append(((Field) objComponent8).get(objNewInstance6).toString());
                                                        String string6 = sb6.toString();
                                                        Object[] objArr5110 = new Object[1];
                                                        a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, KeyEvent.normalizeMetaState(0) + 1, true, 0 - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), 95 - (~(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))), objArr5110);
                                                        strArrSplit2 = string6.split((String) objArr5110[0]);
                                                        length3 = strArrSplit2.length;
                                                        i10 = 0;
                                                        while (true) {
                                                            if (i10 < length3) {
                                                                str5 = strArrSplit2[i10];
                                                                objArr7 = new Object[1];
                                                                c(new int[]{-1387748536, -462037949, 824870072, 1832807441, 1394377890, -1690343399, 1511661316, 320792996, -635533204, -1085246804}, 18 - (~(-View.MeasureSpec.getSize(0))), objArr7);
                                                                if (!str5.startsWith((String) objArr7[0])) {
                                                                    int i23113 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                                    int i23114 = ((i23113 | 11) << 1) - (i23113 ^ 11);
                                                                    int i23115 = -(-TextUtils.indexOf("", "", 0));
                                                                    objArr8 = new Object[1];
                                                                    a("\r\u000f\u0003ￚ\u0005\u0007\u0001\u000b\u0003\u0001\u0010ￎ\u0004\t\u000f\u0012\u0004\u000e\u0001ￎ", i23114, true, (i23115 ^ 20) + ((i23115 & 20) << 1), 182 - KeyEvent.getDeadChar(0, 0), objArr8);
                                                                    if (str5.startsWith((String) objArr8[0])) {
                                                                        int i23116 = -ExpandableListView.getPackedPositionChild(0L);
                                                                        int i23117 = (i23116 * 714) - 4984;
                                                                        int i24110 = ~i23116;
                                                                        int i24111 = ~((i24110 & i22) | (i24110 ^ i22));
                                                                        int i24112 = ~i23116;
                                                                        int i24113 = ~((i24112 ^ 7) | (i24112 & 7));
                                                                        int i24114 = (i24111 ^ i24113) | (i24111 & i24113);
                                                                        int i24115 = ((-8) ^ i23116) | ((-8) & i23116);
                                                                        int i24116 = ~((i24115 ^ i) | (i24115 & i));
                                                                        int i24117 = -(-(((i24114 ^ i24116) | (i24114 & i24116)) * (-713)));
                                                                        int i24118 = ((i23117 | i24117) << 1) - (i23117 ^ i24117);
                                                                        int i24119 = (i23116 & (-8)) | ((-8) ^ i23116);
                                                                        int i25110 = (~((i24119 & i) | (i24119 ^ i))) * 1426;
                                                                        int i25111 = (((i24118 | i25110) << 1) - (i25110 ^ i24118)) + ((~((-8) | i22)) * 713);
                                                                        objArr9 = new Object[1];
                                                                        c(new int[]{-1387748536, -462037949, 824870072, 1832807441}, i25111, objArr9);
                                                                        if (str5.startsWith((String) objArr9[0])) {
                                                                            int i25112 = -(-View.resolveSize(0, 0));
                                                                            int i25113 = (i25112 ^ 1) + ((i25112 & 1) << 1);
                                                                            int i2523 = 0 - (~View.combineMeasuredStates(0, 0));
                                                                            int i2524 = -(-Color.alpha(0));
                                                                            int i2525 = ((i2524 | 144) << 1) - (i2524 ^ 144);
                                                                            Object[] objArr5111 = new Object[1];
                                                                            a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i25113, false, i2523, i2525, objArr5111);
                                                                            strArrSplit3 = str5.split((String) objArr5111[0]);
                                                                            if (strArrSplit3.length <= 1) {
                                                                                continue;
                                                                            }
                                                                        } else {
                                                                            continue;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                                i10++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    strArr = strArrSplit;
                                                    i8 = length2;
                                                    i9 = i7;
                                                }
                                                int i2811 = i9 - 68;
                                                i7 = (i2811 & 69) + (i2811 | 69);
                                                strArrSplit = strArr;
                                                length2 = i8;
                                            } else {
                                                objArr = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i2910) & i2911) | ((~i2911) & i2910)}};
                                                int i2912 = 628044591 + (((~(128393993 | i22)) | (-397391818) | (~(i22 | 344569801))) * 464) + (((-268997825) | i) * (-464)) + (((~(i | 344569801)) | (-397391818)) * 464);
                                                int i2913 = (i3 - (~((i2912 << 1) - i2912))) - 1;
                                                int i2914 = i2913 ^ (i2913 << 13);
                                                int i2915 = i2914 >>> 17;
                                                int i2916 = ((~i2914) & i2915) | ((~i2915) & i2914);
                                                int i2917 = i2916 << 5;
                                                c = 0;
                                            }
                                        }
                                    }
                                }
                            } else {
                                String strSubstring5 = ((String) Class.forName(str).getField(str7).get(objInvoke)).substring(0, iIndexOf);
                                Object[] objArr316 = new Object[1];
                                c(new int[]{-647286776, 1066016995}, -TextUtils.indexOf((CharSequence) "", '0'), objArr316);
                                strArrSplit = strSubstring5.split((String) objArr316[0]);
                                length2 = strArrSplit.length;
                                i7 = 0;
                                while (true) {
                                    if (i7 < length2) {
                                        str4 = strArrSplit[i7];
                                        objArr6 = new Object[1];
                                        c(new int[]{1256247113, 743108622}, 3 - (~(-(-ExpandableListView.getPackedPositionChild(0L)))), objArr6);
                                        if (str4.split((String) objArr6[0]).length > 1) {
                                            synchronized (((Class) setSystemGestureExclusionRectsL30479.component5((ViewConfiguration.getKeyRepeatDelay() >> 16) + 52, (char) Color.argb(0, 0, 0, 0), 5110 - (Process.myTid() >> 22)))) {
                                                int i19118 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                Object[] objArr317 = new Object[1];
                                                c(new int[]{1229183738, -869726461, 727891771, -1441667472, -1387748536, -462037949, 2022645205, -1192444893}, (i19118 & 16) + (i19118 | 16), objArr317);
                                                String str111 = (String) objArr317[0];
                                                Runtime runtime4 = Runtime.getRuntime();
                                                int i19119 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                int i191110 = (i19119 & 1) + (i19119 | 1);
                                                int i191111 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                                int i191112 = (i191111 ^ 2) + ((i191111 & 2) << 1);
                                                int packedPositionChild6 = ExpandableListView.getPackedPositionChild(0L);
                                                int i191113 = packedPositionChild6 * (-661);
                                                int i191114 = (i191113 ^ (-129556)) + ((i191113 & (-129556)) << 1);
                                                int i191115 = ~packedPositionChild6;
                                                strArr = strArrSplit;
                                                int i201110 = ~((i191115 & (-197)) | (i191115 ^ (-197)));
                                                int i201111 = (i191114 - (~(-(-(((i22 & i201110) | (i22 ^ i201110)) * 1324))))) - 1;
                                                int i201112 = ~(packedPositionChild6 | i);
                                                int i201113 = ~((i & 196) | (i ^ 196));
                                                int i201114 = ((i201112 & i201113) | (i201112 ^ i201113)) * (-1324);
                                                int i201115 = (i201111 ^ i201114) + ((i201114 & i201111) << 1);
                                                int i201116 = -(-(((~((i191115 ^ 196) | (i191115 & 196))) | (~((packedPositionChild6 & (-197)) | ((-197) ^ packedPositionChild6)))) * 662));
                                                int i201117 = ((i201115 | i201116) << 1) - (i201116 ^ i201115);
                                                Object[] objArr4118 = new Object[1];
                                                a("\ufffb\u0006", i191110, true, i191112, i201117, objArr4118);
                                                processExec = runtime4.exec((String) objArr4118[0], (String[]) null, (File) null);
                                                Object[] objArr4119 = {processExec.getInputStream()};
                                                objComponent5 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                if (objComponent5 == null) {
                                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 4955 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 2119435613, false, null, new Class[]{InputStream.class});
                                                }
                                                Object objNewInstance7 = ((Constructor) objComponent5).newInstance(objArr4119);
                                                Object[] objArr41110 = {processExec.getErrorStream()};
                                                objComponent6 = setSystemGestureExclusionRectsL30479.component5(752959806);
                                                if (objComponent6 == null) {
                                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 4954, 2119435613, false, null, new Class[]{InputStream.class});
                                                }
                                                Object objNewInstance8 = ((Constructor) objComponent6).newInstance(objArr41110);
                                                dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                                                Class<?> cls16 = Class.forName(str2);
                                                int i201118 = -(-TextUtils.getCapsMode("", 0, 0));
                                                int i201119 = (i201118 ^ 3) + ((i201118 & 3) << 1);
                                                int i21114 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int i21115 = ((i21114 | 5) << 1) - (i21114 ^ 5);
                                                int i21116 = -KeyEvent.keyCodeFromString("");
                                                int i21117 = ((i21116 | 197) << 1) - (i21116 ^ 197);
                                                Object[] objArr41111 = new Object[1];
                                                a("\ufff2\u0003\u0005\u0004\u0005", i201119, false, i21115, i21117, objArr41111);
                                                cls16.getMethod((String) objArr41111[0], null).invoke(objNewInstance7, null);
                                                Class<?> cls17 = Class.forName(str2);
                                                int i21118 = -View.MeasureSpec.getSize(0);
                                                i8 = length2;
                                                int i21119 = (i21118 ^ 3) + ((i21118 & 3) << 1);
                                                int i211110 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                Object[] objArr41112 = new Object[1];
                                                a("\ufff2\u0003\u0005\u0004\u0005", i21119, false, ((i211110 | 5) << 1) - (i211110 ^ 5), 196 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr41112);
                                                cls17.getMethod((String) objArr41112[0], null).invoke(objNewInstance8, null);
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append(str111);
                                                Object[] objArr41113 = new Object[1];
                                                a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), true, 0 - (~(-Drawable.resolveOpacity(0, 0))), 97 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr41113);
                                                sb7.append((String) objArr41113[0]);
                                                String string7 = sb7.toString();
                                                Object[] objArr41114 = new Object[1];
                                                c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, 4 - (~(-TextUtils.indexOf("", "", 0))), objArr41114);
                                                dataOutputStream.write(string7.getBytes((String) objArr41114[0]));
                                                dataOutputStream.flush();
                                                Object[] objArr41115 = new Object[1];
                                                c(new int[]{1461719434, 108309334, 355309575, -982923999}, 4 - (~(-Color.red(0))), objArr41115);
                                                String str112 = (String) objArr41115[0];
                                                int maxKeyCode4 = KeyEvent.getMaxKeyCode() >> 16;
                                                Object[] objArr41116 = new Object[1];
                                                c(new int[]{622158161, 1296501480, -2085441825, -1249213484}, (maxKeyCode4 & 5) + (maxKeyCode4 | 5), objArr41116);
                                                dataOutputStream.write(str112.getBytes((String) objArr41116[0]));
                                                dataOutputStream.flush();
                                                long jNanoTime5 = System.nanoTime();
                                                TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
                                                long j27 = 2000000000;
                                                while (true) {
                                                    processExec.exitValue();
                                                    i9 = i7;
                                                    dataOutputStream2 = dataOutputStream;
                                                    break;
                                                }
                                                dataOutputStream2.close();
                                                Class<?> cls18 = Class.forName(str2);
                                                int iArgb4 = Color.argb(0, 0, 0, 0);
                                                Object[] objArr5112 = new Object[1];
                                                a("\u0002\ufffe\u0003�", ((iArgb4 | 1) << 1) - (iArgb4 ^ 1), false, 3 - (~(-(-TextUtils.indexOf("", "")))), 194 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr5112);
                                                cls18.getMethod((String) objArr5112[0], Long.TYPE).invoke(objNewInstance7, 100L);
                                                Class<?> cls19 = Class.forName(str2);
                                                int i23118 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                                int i23119 = 2 - (~(-MotionEvent.axisFromString("")));
                                                int iResolveSize4 = View.resolveSize(0, 0);
                                                int i231110 = (iResolveSize4 ^ 194) + ((iResolveSize4 & 194) << 1);
                                                Object[] objArr5113 = new Object[1];
                                                a("\u0002\ufffe\u0003�", i23118, false, i23119, i231110, objArr5113);
                                                cls19.getMethod((String) objArr5113[0], Long.TYPE).invoke(objNewInstance8, 10L);
                                                processExec.destroy();
                                                StringBuilder sb8 = new StringBuilder();
                                                objComponent7 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                if (objComponent7 == null) {
                                                    int iMyTid13 = (Process.myTid() >> 22) + 52;
                                                    char c11 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                    int i231111 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4953;
                                                    Object[] objArr5114 = new Object[1];
                                                    b(0, (short) 1, (byte) (-$$a[6]), objArr5114);
                                                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid13, c11, i231111, -1351202600, false, (String) objArr5114[0], null);
                                                }
                                                sb8.append(((Field) objComponent7).get(objNewInstance7).toString());
                                                objComponent8 = setSystemGestureExclusionRectsL30479.component5(-37548869);
                                                if (objComponent8 == null) {
                                                    int tapTimeout4 = 52 - (ViewConfiguration.getTapTimeout() >> 16);
                                                    char maximumFlingVelocity4 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                    int iLastIndexOf6 = TextUtils.lastIndexOf("", '0', 0) + 4955;
                                                    Object[] objArr5115 = new Object[1];
                                                    b(0, (short) 1, (byte) (-$$a[6]), objArr5115);
                                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout4, maximumFlingVelocity4, iLastIndexOf6, -1351202600, false, (String) objArr5115[0], null);
                                                }
                                                sb8.append(((Field) objComponent8).get(objNewInstance8).toString());
                                                String string8 = sb8.toString();
                                                Object[] objArr5116 = new Object[1];
                                                a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, KeyEvent.normalizeMetaState(0) + 1, true, 0 - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), 95 - (~(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))), objArr5116);
                                                strArrSplit2 = string8.split((String) objArr5116[0]);
                                                length3 = strArrSplit2.length;
                                                i10 = 0;
                                                while (true) {
                                                    if (i10 < length3) {
                                                        str5 = strArrSplit2[i10];
                                                        objArr7 = new Object[1];
                                                        c(new int[]{-1387748536, -462037949, 824870072, 1832807441, 1394377890, -1690343399, 1511661316, 320792996, -635533204, -1085246804}, 18 - (~(-View.MeasureSpec.getSize(0))), objArr7);
                                                        if (!str5.startsWith((String) objArr7[0])) {
                                                            int i231112 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                            int i231113 = ((i231112 | 11) << 1) - (i231112 ^ 11);
                                                            int i231114 = -(-TextUtils.indexOf("", "", 0));
                                                            objArr8 = new Object[1];
                                                            a("\r\u000f\u0003ￚ\u0005\u0007\u0001\u000b\u0003\u0001\u0010ￎ\u0004\t\u000f\u0012\u0004\u000e\u0001ￎ", i231113, true, (i231114 ^ 20) + ((i231114 & 20) << 1), 182 - KeyEvent.getDeadChar(0, 0), objArr8);
                                                            if (str5.startsWith((String) objArr8[0])) {
                                                                int i231115 = -ExpandableListView.getPackedPositionChild(0L);
                                                                int i231116 = (i231115 * 714) - 4984;
                                                                int i241110 = ~i231115;
                                                                int i241111 = ~((i241110 & i22) | (i241110 ^ i22));
                                                                int i241112 = ~i231115;
                                                                int i241113 = ~((i241112 ^ 7) | (i241112 & 7));
                                                                int i241114 = (i241111 ^ i241113) | (i241111 & i241113);
                                                                int i241115 = ((-8) ^ i231115) | ((-8) & i231115);
                                                                int i241116 = ~((i241115 ^ i) | (i241115 & i));
                                                                int i241117 = -(-(((i241114 ^ i241116) | (i241114 & i241116)) * (-713)));
                                                                int i241118 = ((i231116 | i241117) << 1) - (i231116 ^ i241117);
                                                                int i241119 = (i231115 & (-8)) | ((-8) ^ i231115);
                                                                int i25114 = (~((i241119 & i) | (i241119 ^ i))) * 1426;
                                                                int i25115 = (((i241118 | i25114) << 1) - (i25114 ^ i241118)) + ((~((-8) | i22)) * 713);
                                                                objArr9 = new Object[1];
                                                                c(new int[]{-1387748536, -462037949, 824870072, 1832807441}, i25115, objArr9);
                                                                if (str5.startsWith((String) objArr9[0])) {
                                                                    int i25116 = -(-View.resolveSize(0, 0));
                                                                    int i25117 = (i25116 ^ 1) + ((i25116 & 1) << 1);
                                                                    int i2526 = 0 - (~View.combineMeasuredStates(0, 0));
                                                                    int i2527 = -(-Color.alpha(0));
                                                                    int i2528 = ((i2527 | 144) << 1) - (i2527 ^ 144);
                                                                    Object[] objArr5117 = new Object[1];
                                                                    a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i25117, false, i2526, i2528, objArr5117);
                                                                    strArrSplit3 = str5.split((String) objArr5117[0]);
                                                                    if (strArrSplit3.length <= 1) {
                                                                        continue;
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        }
                                                        i10++;
                                                    }
                                                }
                                            }
                                        } else {
                                            strArr = strArrSplit;
                                            i8 = length2;
                                            i9 = i7;
                                        }
                                        int i2812 = i9 - 68;
                                        i7 = (i2812 & 69) + (i2812 | 69);
                                        strArrSplit = strArr;
                                        length2 = i8;
                                    } else {
                                        objArr = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i2916) & i2917) | ((~i2917) & i2916)}};
                                        int i2918 = 628044591 + (((~(128393993 | i22)) | (-397391818) | (~(i22 | 344569801))) * 464) + (((-268997825) | i) * (-464)) + (((~(i | 344569801)) | (-397391818)) * 464);
                                        int i2919 = (i3 - (~((i2918 << 1) - i2918))) - 1;
                                        int i29110 = i2919 ^ (i2919 << 13);
                                        int i29111 = i29110 >>> 17;
                                        int i29112 = ((~i29110) & i29111) | ((~i29111) & i29110);
                                        int i29113 = i29112 << 5;
                                        c = 0;
                                    }
                                }
                            }
                        }
                        c = 0;
                    } else {
                        objArr = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i29112) & i29113) | ((~i29113) & i29112)}};
                        int i29114 = 628044591 + (((~(128393993 | i22)) | (-397391818) | (~(i22 | 344569801))) * 464) + (((-268997825) | i) * (-464)) + (((~(i | 344569801)) | (-397391818)) * 464);
                        int i29115 = (i3 - (~((i29114 << 1) - i29114))) - 1;
                        int i29116 = i29115 ^ (i29115 << 13);
                        int i29117 = i29116 >>> 17;
                        int i29118 = ((~i29116) & i29117) | ((~i29117) & i29116);
                        int i29119 = i29118 << 5;
                        c = 0;
                    }
                    if (((int[]) objArr[c])[c] != i) {
                        return objArr;
                    }
                    Object[] objArr60 = new Object[5];
                    int[] iArr = new int[1];
                    objArr60[c] = iArr;
                    int[] iArr2 = new int[1];
                    objArr60[1] = iArr2;
                    objArr60[4] = new int[1];
                    iArr2[c] = i;
                    iArr[c] = i;
                    objArr60[3] = null;
                    objArr60[2] = null;
                    int i300 = ~((int) SystemClock.uptimeMillis());
                    int i301 = -(-(1319610418 + (((~(552595805 | i300)) | (-768771614)) * (-983)) + (((~(i300 | (-768771614))) | 549617693) * 983)));
                    int i302 = (i3 & i301) + (i3 | i301);
                    int i303 = (i302 << 13) ^ i302;
                    int i304 = i303 >>> 17;
                    int i305 = (i303 | i304) & (~(i303 & i304));
                    int i306 = i305 << 5;
                    ((int[]) objArr60[4])[0] = ((~i305) & i306) | ((~i306) & i305);
                    if (((int[]) objArr60[0])[0] != i) {
                        return objArr60;
                    }
                    if ((i2 & 1) == 0) {
                        int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int pivotYN16909 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                        int i307 = longPressTimeout2 * (-419);
                        int i308 = (i307 ^ 5473) + ((i307 & 5473) << 1) + ((~((pivotYN16909 ^ 13) | (pivotYN16909 & 13))) * 420);
                        int i309 = ~longPressTimeout2;
                        int i310 = -(-(((i309 ^ 13) | (i309 & 13)) * (-420)));
                        int i311 = (i308 & i310) + (i310 | i308);
                        int i312 = ~(i309 | (-14));
                        int i313 = ~pivotYN16909;
                        int i314 = ~((i313 & 13) | (i313 ^ 13));
                        int i315 = ((i312 & i314) | (i312 ^ i314)) * 420;
                        int i316 = ((i311 | i315) << 1) - (i315 ^ i311);
                        Object[] objArr61 = new Object[1];
                        c(new int[]{1117135990, -13680084, 331638273, 200728450, 214365820, 1299454621, -1221427706, 790724934}, i316, objArr61);
                        try {
                            Object[] objArr62 = {(String) objArr61[0]};
                            int i317 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            int i318 = (((i317 * 141) - 6696) - (~(((i ^ 24) | (i & 24)) * 140))) - 1;
                            int i319 = ~i317;
                            int i320 = (i319 & 24) | (i319 ^ 24);
                            int i321 = ~i320;
                            int i322 = ~((i28 ^ 24) | (i28 & 24));
                            int i323 = (i318 - (~(((i321 & i322) | (i321 ^ i322)) * (-280)))) - 1;
                            int i324 = ((~((i22 & i317) | (i22 ^ i317))) | (~((-25) | i317)) | (~((i320 & i) | (i320 ^ i)))) * 140;
                            int i325 = (i323 & i324) + (i324 | i323);
                            Object[] objArr63 = new Object[1];
                            c(new int[]{805201070, -586831618, 436013775, -808229217, -503798660, 65409888, -414259493, -29293429, 1645488617, -532667640, -1384335855, -997942438}, i325, objArr63);
                            Class<?> cls20 = Class.forName((String) objArr63[0]);
                            int i326 = -TextUtils.lastIndexOf("", '0', 0, 0);
                            int i327 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int i328 = (i327 ^ 16) + ((i327 & 16) << 1);
                            int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                            Object[] objArr64 = new Object[1];
                            a("￼\ufffe￼\u000b￪\u0010\n\u000b￼\u0004￪￼\t\r\u0000\ufffa", i326, false, i328, (edgeSlop ^ 191) + ((edgeSlop & 191) << 1), objArr64);
                            Object objInvoke2 = cls20.getMethod((String) objArr64[0], String.class).invoke(context, objArr62);
                            if (objInvoke2 == null) {
                                objArr5 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                int iMyPid = Process.myPid();
                                int i329 = (~(567105231 | iMyPid)) | 237152512;
                                int i330 = ~iMyPid;
                                int i331 = 859802227 + ((i329 | (~((-20976705) | i330))) * 886) + (((~(i330 | (-567105232))) | 783281039) * (-1772)) + ((~(i330 | 783281039)) * 886);
                                int i332 = ((i3 | i331) << 1) - (i3 ^ i331);
                                int i333 = i332 << 13;
                                int i334 = ((~i332) & i333) | ((~i333) & i332);
                                int i335 = i334 ^ (i334 >>> 17);
                                int i336 = i335 << 5;
                                c3 = 0;
                                ((int[]) objArr5[4])[0] = (i335 | i336) & (~(i335 & i336));
                                break;
                            }
                            int i337 = 9 - (~(-(-ImageFormat.getBitsPerPixel(0))));
                            int i338 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 36;
                            int i339 = -TextUtils.indexOf("", "", 0, 0);
                            Object[] objArr65 = new Object[1];
                            a("\u0001\u0017￫\uffff\f\uffff\u0005\u0003\u0010\uffff\f\u0002\u0010\r\u0007\u0002ￌ\uffff\u000e\u000eￌ\uffff\u0002\u000b\u0007\fￌ￢\u0003\u0014\u0007\u0001\u0003￮\r\n\u0007", i337, false, i338, (i339 ^ 184) + ((i339 & 184) << 1), objArr65);
                            Class<?> cls21 = Class.forName((String) objArr65[0]);
                            int iMyTid14 = 14 - (Process.myTid() >> 22);
                            int offsetBefore = TextUtils.getOffsetBefore("", 0);
                            int i340 = offsetBefore * 273;
                            int i341 = ((i340 | (-4065)) << 1) - (i340 ^ (-4065));
                            int i342 = ~offsetBefore;
                            int i343 = i342 | (-16);
                            int i344 = ~((i343 & i28) | (i343 ^ i28));
                            int i345 = offsetBefore | 15;
                            int i346 = ~((i345 & i) | (i345 ^ i));
                            int i347 = -(-(((i344 & i346) | (i344 ^ i346)) * (-272)));
                            int i348 = (i341 & i347) + (i341 | i347) + (((~(i342 | i)) | (~((i342 ^ 15) | (i342 & 15)))) * (-272));
                            int i349 = ~((offsetBefore & i) | (offsetBefore ^ i));
                            int i350 = -(-(((i349 & 15) | (i349 ^ 15)) * 272));
                            int i351 = (i348 ^ i350) + ((i350 & i348) << 1);
                            int i352 = -TextUtils.indexOf("", "", 0);
                            Object[] objArr66 = new Object[1];
                            a("\u0000\u000fￜ\ufffe\u000f\u0004\u0011\u0000ￜ\uffff\b\u0004\t\u000e\u0002", iMyTid14, false, i351, (i352 & WebmConstants.MkvEbmlElement.CUE_POINT) + (i352 | WebmConstants.MkvEbmlElement.CUE_POINT), objArr66);
                            List list = (List) cls21.getMethod((String) objArr66[0], null).invoke(objInvoke2, null);
                            if (list == null) {
                                objArr5 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                int iMyPid2 = Process.myPid();
                                int i3210 = (~(567105231 | iMyPid2)) | 237152512;
                                int i3310 = ~iMyPid2;
                                int i3311 = 859802227 + ((i3210 | (~((-20976705) | i3310))) * 886) + (((~(i3310 | (-567105232))) | 783281039) * (-1772)) + ((~(i3310 | 783281039)) * 886);
                                int i3312 = ((i3 | i3311) << 1) - (i3 ^ i3311);
                                int i3313 = i3312 << 13;
                                int i3314 = ((~i3312) & i3313) | ((~i3313) & i3312);
                                int i3315 = i3314 ^ (i3314 >>> 17);
                                int i3316 = i3315 << 5;
                                c3 = 0;
                                ((int[]) objArr5[4])[0] = (i3315 | i3316) & (~(i3315 & i3316));
                                break;
                            }
                            Iterator it = list.iterator();
                            loop1: while (true) {
                                if (!it.hasNext()) {
                                    objArr5 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                                    int iMyPid3 = Process.myPid();
                                    int i3211 = (~(567105231 | iMyPid3)) | 237152512;
                                    int i3317 = ~iMyPid3;
                                    int i3318 = 859802227 + ((i3211 | (~((-20976705) | i3317))) * 886) + (((~(i3317 | (-567105232))) | 783281039) * (-1772)) + ((~(i3317 | 783281039)) * 886);
                                    int i3319 = ((i3 | i3318) << 1) - (i3 ^ i3318);
                                    int i33110 = i3319 << 13;
                                    int i33111 = ((~i3319) & i33110) | ((~i33110) & i3319);
                                    int i33112 = i33111 ^ (i33111 >>> 17);
                                    int i33113 = i33112 << 5;
                                    c3 = 0;
                                    ((int[]) objArr5[4])[0] = (i33112 | i33113) & (~(i33112 & i33113));
                                    break;
                                }
                                Object next = it.next();
                                int[] iArr3 = new int[i37];
                                // fill-array-data instruction
                                iArr3[0] = 805201070;
                                iArr3[1] = -586831618;
                                iArr3[2] = 436013775;
                                iArr3[3] = -808229217;
                                iArr3[4] = -503798660;
                                iArr3[5] = 65409888;
                                iArr3[6] = -414259493;
                                iArr3[7] = -29293429;
                                iArr3[8] = -123600244;
                                iArr3[9] = -1110065215;
                                iArr3[10] = -1033928035;
                                iArr3[11] = 1270595044;
                                iArr3[12] = 673329159;
                                iArr3[13] = -1126815257;
                                iArr3[14] = 1360037563;
                                iArr3[15] = -103507113;
                                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                                int i353 = (iCombineMeasuredStates ^ 29) + ((iCombineMeasuredStates & 29) << 1);
                                Object[] objArr67 = new Object[1];
                                c(iArr3, i353, objArr67);
                                Class<?> cls22 = Class.forName((String) objArr67[0]);
                                int i354 = 7 - (~(-View.resolveSizeAndState(0, 0, 0)));
                                int i355 = 13 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                int i356 = -ImageFormat.getBitsPerPixel(0);
                                Object[] objArr68 = new Object[1];
                                a("\b\ufffe\u0004\u0002￫\ufffe\n\u0002\u0004\u0002\u0011￭\ufffe\u0000", i354, false, i355, (i356 & 184) + (i356 | 184), objArr68);
                                String str20 = (String) cls22.getMethod((String) objArr68[0], null).invoke(next, null);
                                int i357 = -ImageFormat.getBitsPerPixel(0);
                                int i358 = -(KeyEvent.getMaxKeyCode() >> 16);
                                Object[] objArr69 = new Object[1];
                                a("\u0001\u0017￫\uffff\f\uffff\u0005\u0003\u0010\uffff\f\u0002\u0010\r\u0007\u0002ￌ\uffff\u000e\u000eￌ\uffff\u0002\u000b\u0007\fￌ￢\u0003\u0014\u0007\u0001\u0003￮\r\n\u0007", (i357 | 8) + (i357 & 8), false, ((i358 | 37) << 1) - (i358 ^ 37), (ViewConfiguration.getLongPressTimeout() >> 16) + 184, objArr69);
                                Class<?> cls23 = Class.forName((String) objArr69[0]);
                                Object[] objArr70 = new Object[1];
                                c(new int[]{-464647543, 634594242, 2123225828, 753417715, 328957849, -562062606, -299644143, 764425190, -116158072, 1159785327}, 16 - (~Drawable.resolveOpacity(0, 0)), objArr70);
                                if (((Boolean) cls23.getMethod((String) objArr70[0], String.class).invoke(objInvoke2, str20)).booleanValue() && (length = str20.length() - 20) >= 0) {
                                    int i359 = 0;
                                    while (i359 <= length) {
                                        Object[] objArr71 = {str20.substring(i359, (i359 ^ 20) + ((i359 & 20) << 1)), 931995};
                                        Object objComponent15 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent15 == null) {
                                            int pressedStateDuration = 52 - (ViewConfiguration.getPressedStateDuration() >> 16);
                                            char c12 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                                            int gidForName2 = Process.getGidForName("") + 5421;
                                            Object[] objArr72 = new Object[1];
                                            b((byte) ($$b >>> 1), (short) 0, 3, objArr72);
                                            objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(pressedStateDuration, c12, gidForName2, 1884899413, false, (String) objArr72[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue8 = ((Long) ((Method) objComponent15).invoke(null, objArr71)).longValue();
                                        long j28 = jLongValue8 ^ (-1);
                                        Object obj = objInvoke2;
                                        Iterator it2 = it;
                                        long j29 = i;
                                        long j30 = ((j28 | j29) ^ (-1)) | ((992977576 | j28) ^ (-1));
                                        long j31 = j29 ^ (-1);
                                        long j32 = j31 | (-992977577);
                                        long j33 = (-1760549244021L) + ((-885) * jLongValue8) + ((j30 | ((j32 | jLongValue8) ^ (-1))) * 886) + ((-1772) * (((j31 | jLongValue8) ^ (-1)) | (-992977577))) + (886 * (j32 ^ (-1))) + 1500130690;
                                        int iNextInt4 = new Random().nextInt();
                                        int i360 = 2007022260 + (((~((~iNextInt4) | (-150035495))) | 4260898) * (-245));
                                        int i361 = ~(iNextInt4 | (-150035495));
                                        int i362 = ((int) (j33 >> 32)) & (i360 + (i361 * (-245)) + ((i361 | 1287190916) * 245));
                                        int i363 = (-1905160647) + (((~((-1750585321) | i22)) | 1079364200 | (~((-1107155566) | i22)) | (~(1778376685 | i))) * (-84));
                                        int i364 = (~((-1107155566) | i)) | 1750585320;
                                        int i365 = ~(i22 | 1107155565);
                                        if ((i362 | (((int) j33) & (i363 + ((i364 | i365) * (-84)) + (((-1778376686) | i365) * 84)))) == 1245577864) {
                                            objArr5 = new Object[]{new int[]{i ^ 70}, new int[]{i}, null, null, new int[1]};
                                            int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                            int i366 = (-1741621401) + (((~(374499590 | iUptimeMillis3)) | 556045504) * 336) + (((~(iUptimeMillis3 | 590675398)) | 339869696) * (-168)) + (((~((~iUptimeMillis3) | 590675398)) | 374499590) * 168);
                                            int pivotYN169010 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                                            int i367 = 879 - (~(-(-(i366 * PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED))));
                                            int i368 = ~(((-17) & i366) | ((-17) ^ i366));
                                            int i369 = ~pivotYN169010;
                                            int i370 = ~((i369 & i366) | (i369 ^ i366));
                                            int i371 = (i367 - (~(-(-(((i368 & i370) | (i368 ^ i370)) * PlaybackException.ERROR_CODE_SETUP_REQUIRED))))) - 1;
                                            int i372 = ~(((-17) & pivotYN169010) | ((-17) ^ pivotYN169010));
                                            int i373 = ~i366;
                                            int i374 = ~(i373 | 16);
                                            int i375 = (i372 & i374) | (i372 ^ i374);
                                            int i376 = ~pivotYN169010;
                                            int i377 = ~((i376 & 16) | (i376 ^ 16));
                                            int i378 = ((i371 - (~(((i375 & i377) | (i375 ^ i377)) * 54))) - 1) + ((pivotYN169010 | (~((i373 ^ 16) | (i373 & 16)))) * 54);
                                            int i379 = (i3 ^ i378) + ((i3 & i378) << 1);
                                            int i380 = i379 ^ (i379 << 13);
                                            int i381 = i380 ^ (i380 >>> 17);
                                            int i382 = i381 << 5;
                                            ((int[]) objArr5[4])[0] = (i381 | i382) & (~(i381 & i382));
                                            c3 = 0;
                                            break loop1;
                                        }
                                        i359 = (((i359 | (-116)) << 1) - (i359 ^ (-116))) + 117;
                                        objInvoke2 = obj;
                                        it = it2;
                                    }
                                }
                                objInvoke2 = objInvoke2;
                                it = it;
                                i37 = 16;
                            }
                            if (((int[]) objArr5[c3])[c3] != i) {
                                return objArr5;
                            }
                        } catch (Throwable th13) {
                            Throwable cause8 = th13.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th13;
                        }
                    }
                    int i383 = -((Process.getThreadPriority(0) + 20) >> 6);
                    int i384 = (i383 & 5) + (i383 | 5);
                    int i385 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    int pivotYN169011 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i386 = i385 * 989;
                    int i387 = (i386 ^ (-10857)) + ((i386 & (-10857)) << 1);
                    int i388 = ~pivotYN169011;
                    int i389 = (i388 & (-12)) | ((-12) ^ i388);
                    int i390 = (i387 - (~(((~((i389 & i385) | (i389 ^ i385))) | (~(((i385 ^ 11) | (i385 & 11)) | pivotYN169011))) * 988))) - 1;
                    int i391 = -(-((i385 | (-12)) * (-988)));
                    int i392 = (i390 ^ i391) + ((i391 & i390) << 1);
                    int i393 = ~i385;
                    int i394 = (~((i393 & (-12)) | (i393 ^ (-12)))) | (~(((-12) & pivotYN169011) | ((-12) ^ pivotYN169011)));
                    int i395 = i385 | (~pivotYN169011);
                    Object[] objArr73 = new Object[1];
                    a("\u0013\u0005\u0015\u0007ￏ\u000f\u0006\u000e￩\ufff3\uffef\u0014", i384, true, (i392 - (~(((~((i395 & 11) | (i395 ^ 11))) | i394) * 988))) - 1, 181 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr73);
                    Object[] objArr74 = {(String) objArr73[0]};
                    Object objComponent16 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent16 == null) {
                        int iMakeMeasureSpec = 52 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        char cMyTid = (char) ((Process.myTid() >> 22) + 59725);
                        int minimumFlingVelocity = 6317 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        Object[] objArr75 = new Object[1];
                        b((byte) ($$b >>> 1), (short) 0, 0, objArr75);
                        objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMakeMeasureSpec, cMyTid, minimumFlingVelocity, 66836110, false, (String) objArr75[0], new Class[]{String.class});
                    }
                    long jLongValue9 = ((Long) ((Method) objComponent16).invoke(null, objArr74)).longValue();
                    long j34 = jLongValue9 ^ (-1);
                    long jFreeMemory2 = ((long) ((int) Runtime.getRuntime().freeMemory())) ^ (-1);
                    long j35 = (-869230489486L) + ((-932) * jLongValue9) + ((-933) * (((930653628 | jFreeMemory2) ^ (-1)) | j34)) + ((((j34 | (-930653629)) ^ (-1)) | ((jFreeMemory2 | j34) ^ (-1))) * 933) + (933 * ((jLongValue9 | (-930653629)) ^ (-1))) + 1086603995;
                    int iMyUid = Process.myUid();
                    int i396 = ~iMyUid;
                    int i397 = ((int) (j35 >> 32)) & ((-577760386) + (((~(698728315 | i396)) | (~((-2135954727) | iMyUid))) * 210) + (((~(iMyUid | 2146811775)) | (~(i396 | (-687871267)))) * 210));
                    int i398 = (int) j35;
                    int iMyTid15 = Process.myTid();
                    int i399 = ~iMyTid15;
                    if ((i397 | (i398 & (1788176917 + ((537011201 | i399) * (-192)) + (((~((-1245299669) | i399)) | 1075430016) * (-384)) + (((~(iMyTid15 | 1782310869)) | (~(i399 | (-169869653))) | (~((-1075430017) | iMyTid15))) * 192)))) != 0) {
                        objArr2 = new Object[]{new int[]{i ^ 50}, new int[]{i}, null, null, new int[]{(i | i) & (~(i & i))}};
                        int i400 = (-1353530386) + ((~(373691002 | i22)) * 979) + ((i | 589866810) * (-979)) + (((~(373691002 | i)) | (~(i22 | 589866810))) * 979);
                        int i401 = (i3 - (~((i400 & 16) + (i400 | 16)))) - 1;
                        int i402 = i401 ^ (i401 << 13);
                        int i403 = i402 >>> 17;
                        int i404 = (i402 | i403) & (~(i402 & i403));
                        int i405 = i404 << 5;
                        i4 = 0;
                    } else {
                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                        int i406 = (-791271641) + (((~((-44226766) | iFreeMemory)) | 35821760) * 104) + ((~((~iFreeMemory) | 180354047)) * PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT) + ((iFreeMemory | 171949042) * 104);
                        int i407 = ~(~i406);
                        int i408 = ~((i28 ^ i406) | (i28 & i406));
                        int i409 = (i406 * 971) + (((i407 & i408) | (i407 ^ i408)) * (-970)) + ((~(((-1) ^ i406) | i406)) * 1940);
                        int i410 = -(-((~((i22 ^ i406) | (i22 & i406))) * 970));
                        int i411 = (i409 ^ i410) + ((i409 & i410) << 1);
                        int i412 = (i3 & i411) + (i3 | i411);
                        int i413 = i412 << 13;
                        int i414 = ((~i412) & i413) | ((~i413) & i412);
                        int i415 = i414 >>> 17;
                        int i416 = ((~i414) & i415) | ((~i415) & i414);
                        int i417 = i416 << 5;
                        i4 = 0;
                        ((int[]) objArr2[4])[0] = (i416 | i417) & (~(i416 & i417));
                    }
                    if (((int[]) objArr2[i4])[i4] != i) {
                        return objArr2;
                    }
                    int i418 = -View.getDefaultSize(i4, i4);
                    int i419 = ((i418 | 1) << 1) - (i418 ^ 1);
                    char mirror = AndroidCharacter.getMirror('0');
                    int i420 = ~mirror;
                    int i421 = (((mirror * 905) + 25284) - (~(-(-(((~((i420 ^ i) | (i420 & i))) | (~(i22 | (-28)))) * (-1808)))))) - 1;
                    int i422 = (i420 & 27) | (i420 ^ 27);
                    int i423 = ~((i422 & i) | (i422 ^ i));
                    int i424 = (i28 ^ mirror) | (i28 & mirror);
                    int i425 = ~(i424 | (-28));
                    int i426 = -(-(((i423 & i425) | (i423 ^ i425)) * 904));
                    int i427 = (i421 ^ i426) + ((i421 & i426) << 1);
                    int i428 = ~mirror;
                    int i429 = (~((i428 & (-28)) | (i428 ^ (-28)))) | (~((27 ^ i) | (27 & i)));
                    int i430 = ~i424;
                    int i431 = i427 + (((i429 & i430) | (i429 ^ i430)) * 904);
                    int i432 = -TextUtils.indexOf((CharSequence) "", '0');
                    int pivotYN169012 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i433 = (i432 * 868) + 162316;
                    int i434 = ~i432;
                    int i435 = ~pivotYN169012;
                    int i436 = ~((i435 & i434) | (i434 ^ i435));
                    int i437 = ~pivotYN169012;
                    int i438 = (i436 | (~(((-188) & i437) | ((-188) ^ i437)))) * (-867);
                    int i439 = (i433 & i438) + (i433 | i438);
                    int i440 = ~((i434 ^ (-188)) | (i434 & (-188)));
                    int i441 = ~i432;
                    int i442 = ~((i441 & pivotYN169012) | (i441 ^ pivotYN169012));
                    int i443 = (i440 & i442) | (i440 ^ i442);
                    int i444 = ~(((-188) ^ pivotYN169012) | ((-188) & pivotYN169012));
                    int i445 = i439 + (((i443 & i444) | (i443 ^ i444)) * (-1734));
                    int i446 = (i434 ^ (-188)) | (i434 & (-188));
                    int i447 = ~((i446 & i437) | (i446 ^ i437));
                    int i448 = i434 | WebmConstants.MkvEbmlElement.CUE_POINT;
                    int i449 = i432 | (-188);
                    Object[] objArr76 = new Object[1];
                    a("\uffff\uffc9\r\u0013\r\u000e\uffff\u0007\uffc9\u0010\n\u0002\t\b\uffff\ufff9\r\n\ufffb�", i419, false, i431, i445 + (((~((i449 & pivotYN169012) | (i449 ^ pivotYN169012))) | i447 | (~((i448 & pivotYN169012) | (i448 ^ pivotYN169012)))) * 867), objArr76);
                    Object[] objArr77 = {(String) objArr76[0]};
                    Object objComponent17 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                    if (objComponent17 == null) {
                        int windowTouchSlop2 = 52 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 59725);
                        int iResolveOpacity = 6317 - Drawable.resolveOpacity(0, 0);
                        Object[] objArr78 = new Object[1];
                        b((byte) ($$b >>> 1), (short) 0, 0, objArr78);
                        objComponent17 = setSystemGestureExclusionRectsL30479.vD14832N6715(windowTouchSlop2, cResolveOpacity, iResolveOpacity, 66836110, false, (String) objArr78[0], new Class[]{String.class});
                    }
                    long jLongValue10 = ((Long) ((Method) objComponent17).invoke(null, objArr77)).longValue();
                    long j36 = i;
                    long j37 = j36 ^ (-1);
                    long j38 = (-790325175888L) + ((-520) * jLongValue10) + ((-1042) * (((j37 | jLongValue10) ^ (-1)) | (-1514032904))) + ((jLongValue10 | j36) * 521) + (521 * (((jLongValue10 | ((-1514032904) | j37)) ^ (-1)) | ((1514032903 | (jLongValue10 ^ (-1))) ^ (-1)) | ((1514032903 | j36) ^ (-1)))) + 1669983270;
                    int i450 = ((int) (j38 >> 32)) & (1295902257 + (((~((-365168132) | i22)) | (~((-538968449) | i)) | (~((-167921701) | i))) * 765) + (((~((-904136580) | i22)) | 365168131) * 1530) + (((~((-904136580) | i)) | (~(i22 | (-167921701)))) * 765));
                    int i451 = (int) j38;
                    int i452 = ~(1433168502 | i22);
                    int i453 = i451 & (((1430257732 | i452 | (~((-1433168503) | i))) * (-338)) + 953549853 + ((i452 | (~((-2910771) | i))) * 338));
                    if (((i450 & i453) | (i450 ^ i453)) != 0) {
                        objArr3 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int i454 = (~(i & 60)) & (i | 60);
                        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                        int i455 = i3 + ((((~((-417378485) | iElapsedRealtime)) | 148902068) * (-566)) - 1404599625) + ((~(iElapsedRealtime | (-268476417))) * 566) + 16;
                        int i456 = i455 << 13;
                        int i457 = (i456 | i455) & (~(i455 & i456));
                        int i458 = i457 >>> 17;
                        int i459 = ((~i457) & i458) | ((~i458) & i457);
                        ((int[]) objArr3[4])[0] = i459 ^ (i459 << 5);
                        i5 = 0;
                    } else {
                        objArr3 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[]{((~i) & i) | ((~i) & i)}};
                        int i460 = (i3 - (~((((-1350033576) + (((~((-331354104) | i)) | 285213888) * 345)) + (((~((-331354104) | i22)) | (-400392184)) * 345)) + ((~((-285213889) | i)) * 345)))) - 1;
                        int i461 = i460 << 13;
                        int i462 = ((~i460) & i461) | ((~i461) & i460);
                        int i463 = i462 ^ (i462 >>> 17);
                        int i464 = i463 << 5;
                        i5 = 0;
                    }
                    if (((int[]) objArr3[i5])[i5] != i) {
                        return objArr3;
                    }
                    int i465 = 24 - (~TextUtils.getOffsetBefore("", i5));
                    int i466 = -(Process.myPid() >> 22);
                    int i467 = (i466 ^ 36) + ((i466 & 36) << 1);
                    int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                    int pivotYN169013 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i468 = (jumpTapTimeout2 * 960) - 346977;
                    int i469 = ~pivotYN169013;
                    int i470 = ((~((i469 & (-182)) | ((-182) ^ i469))) | (~((jumpTapTimeout2 ^ pivotYN169013) | (jumpTapTimeout2 & pivotYN169013)))) * 959;
                    int i471 = ((i468 | i470) << 1) - (i468 ^ i470);
                    int i472 = (i471 & 174538) + (174538 | i471);
                    int i473 = ~(((-182) & pivotYN169013) | ((-182) ^ pivotYN169013));
                    int i474 = ~pivotYN169013;
                    int i475 = ~((jumpTapTimeout2 & i474) | (i474 ^ jumpTapTimeout2));
                    int i476 = -(-(((i475 & i473) | (i473 ^ i475)) * 959));
                    int i477 = (i472 ^ i476) + ((i476 & i472) << 1);
                    Object[] objArr79 = new Object[1];
                    a("\u0004\u0010\u000eￏ\b\u0003\u0010\u0019ￏ\u0002\u000f\u0005\u0013\u0010\n\u0005\uffd0\u0017\u0007\u0014\u0000\u0005\u0002\u0015\u0002\uffd0\u0005\u0002\u0015\u0002\uffd0\u0005\u0002\u0015\u0002\uffd0", i465, false, i467, i477, objArr79);
                    Object[] objArr80 = {(String) objArr79[0]};
                    Object objComponent18 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent18 == null) {
                        int i478 = 53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(0) + 59726);
                        int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6317;
                        Object[] objArr81 = new Object[1];
                        b((byte) (-$$a[4]), (short) 0, 0, objArr81);
                        objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(i478, bitsPerPixel2, minimumFlingVelocity2, 369154319, false, (String) objArr81[0], new Class[]{String.class});
                    }
                    long jLongValue11 = ((Long) ((Method) objComponent18).invoke(null, objArr80)).longValue();
                    long j39 = 540871058 | jLongValue11;
                    long j40 = (((((-76262819319L) + ((-279) * jLongValue11)) + ((jLongValue11 | j36) * 140)) + ((-280) * ((j39 ^ (-1)) | ((j37 | jLongValue11) ^ (-1))))) + (140 * (((((jLongValue11 ^ (-1)) | (-540871059)) ^ (-1)) | ((j37 | (-540871059)) ^ (-1))) | ((j36 | j39) ^ (-1))))) - 433630826;
                    if (((((int) (j40 >> 32)) & (523330942 + (((~((-1647700286) | i)) | 1210040599) * (-465)) + (((-1647700286) | (~(1210040599 | i))) * 930) + (((-572532777) | i) * 465))) | (((int) j40) & (1655124919 + (((~((-433918051) | i)) | 1052704) * (-140)) + ((~((-432865347) | i)) * 70) + (((~((-1003308360) | i)) | 571495717) * 70)))) != 0) {
                        objArr4 = new Object[]{new int[]{(i & (-81)) | (i22 & 80)}, new int[]{i}, null, null, new int[1]};
                        int i479 = ~((~Process.myPid()) | 1008995291);
                        int i480 = (((738198299 | i479) * (-374)) - 1069394511) + ((i479 | 270796992) * 374);
                        int i481 = (i3 - (~(-(-(((i480 | 16) << 1) - (i480 ^ 16)))))) - 1;
                        int i482 = i481 << 13;
                        int i483 = ((~i481) & i482) | ((~i482) & i481);
                        int i484 = i483 ^ (i483 >>> 17);
                        int i485 = i484 << 5;
                        c2 = 0;
                        ((int[]) objArr4[4])[0] = ((~i484) & i485) | ((~i485) & i484);
                    } else {
                        objArr4 = new Object[]{new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int iMyTid16 = Process.myTid();
                        int i486 = 2064800789 + ((iMyTid16 | 470171537) * (-50));
                        int i487 = ~((-268702977) | iMyTid16);
                        int i488 = ~iMyTid16;
                        int i489 = (i3 - (~((i486 + ((i487 | (~(522698705 | i488))) * 50)) + (((~(i488 | 470171537)) | ((~(253995729 | i488)) | (-522698706))) * 50)))) - 1;
                        int i490 = i489 << 13;
                        int i491 = (i489 | i490) & (~(i489 & i490));
                        int i492 = i491 ^ (i491 >>> 17);
                        int i493 = i492 << 5;
                        c2 = 0;
                        ((int[]) objArr4[4])[0] = ((~i492) & i493) | ((~i493) & i492);
                    }
                    if (((int[]) objArr4[c2])[c2] != i) {
                        return objArr4;
                    }
                    int i494 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    int pivotYN169014 = mK14988T27556.AnonymousClass4.setPivotYN16904();
                    int i495 = ~pivotYN169014;
                    int i496 = ~(((-42) ^ i495) | ((-42) & i495));
                    int i497 = ~i494;
                    int i498 = (((i494 * 371) + 15211) - (~((i496 | (~((i497 & pivotYN169014) | (i497 ^ pivotYN169014)))) * (-370)))) - 1;
                    int i499 = ~i494;
                    int i500 = ~((i495 & i499) | (i499 ^ i495));
                    int i501 = ~((pivotYN169014 & (-42)) | ((-42) ^ pivotYN169014));
                    int i502 = (i501 & i500) | (i500 ^ i501);
                    int i503 = ~((i494 & 41) | (i494 ^ 41));
                    int i504 = (i498 - (~(-(-(((i502 & i503) | (i502 ^ i503)) * (-370)))))) - 1;
                    int i505 = i503 * 370;
                    int i506 = (i504 & i505) + (i505 | i504);
                    Object[] objArr82 = new Object[1];
                    c(new int[]{1325076212, -660282558, 571927301, 1452954783, 826723459, 1583063201, 38010057, 125069812, 2099264382, 1247204510, -971644279, -1525400028, -1186034847, -1500515637, -833029599, -2049775207, 639373222, 1101354632, -495741612, -1441056419, -1294538379, 1296829065}, i506, objArr82);
                    Object[] objArr83 = {(String) objArr82[0]};
                    Object objComponent19 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                    if (objComponent19 == null) {
                        int iMyTid17 = (Process.myTid() >> 22) + 52;
                        char c13 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 59725);
                        int iLastIndexOf7 = TextUtils.lastIndexOf("", '0', 0) + 6318;
                        Object[] objArr84 = new Object[1];
                        b((byte) (-$$a[4]), (short) 0, 0, objArr84);
                        objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid17, c13, iLastIndexOf7, 369154319, false, (String) objArr84[0], new Class[]{String.class});
                    }
                    long jLongValue12 = ((Long) ((Method) objComponent19).invoke(null, objArr83)).longValue();
                    long j41 = jLongValue12 ^ (-1);
                    long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    long j42 = jElapsedRealtime ^ (-1);
                    long j43 = j42 | (-802947552);
                    long j44 = (((((-1423626009696L) + ((-885) * jLongValue12)) + (((((j41 | jElapsedRealtime) ^ (-1)) | ((802947551 | j41) ^ (-1))) | ((j43 | jLongValue12) ^ (-1))) * 886)) + ((-1772) * (((jLongValue12 | j42) ^ (-1)) | (-802947552)))) + (886 * (j43 ^ (-1)))) - 171554333;
                    int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                    int i507 = ~elapsedCpuTime2;
                    int i508 = ((int) (j44 >> 32)) & ((((~((-1466512722) | i507)) | (~((-29286311) | elapsedCpuTime2))) * 959) + 1485032545 + (((~(elapsedCpuTime2 | (-1466512722))) | (~(i507 | (-29286311)))) * 959));
                    int i509 = (int) Runtime.getRuntime().totalMemory();
                    int i510 = ~i509;
                    int i511 = ((int) j44) & (((((~(799707504 | i510)) | (~((-637518906) | i509))) * 959) - 517181667) + (((~(i509 | 799707504)) | (~(i510 | (-637518906)))) * 959));
                    if (((i508 & i511) | (i508 ^ i511)) == 0) {
                        Object[] objArr85 = {new int[]{i}, new int[]{i}, null, null, new int[1]};
                        int i512 = (int) Runtime.getRuntime().totalMemory();
                        int i513 = 2080387832 + ((~((-411211073) | i512)) * (-301)) + (((~(445306177 | i512)) | (~((~i512) | 661481985))) * (-301)) + (((~(i512 | (-661481986))) | 445306177) * 301);
                        int i514 = i3 + ((i513 << 1) - i513);
                        int i515 = i514 << 13;
                        int i516 = ((~i514) & i515) | ((~i515) & i514);
                        int i517 = i516 >>> 17;
                        int i518 = (i516 | i517) & (~(i516 & i517));
                        ((int[]) objArr85[4])[0] = i518 ^ (i518 << 5);
                        return objArr85;
                    }
                    Object[] objArr86 = {new int[]{(i & (-91)) | (i22 & 90)}, new int[]{i}, null, null, new int[1]};
                    int iNextInt5 = new Random().nextInt(159631871);
                    int i519 = (-1179178759) + (((-354850625) | iNextInt5) * 614);
                    int i520 = ~iNextInt5;
                    int i521 = i519 + (((~((-970841624) | i520)) | 685328407 | (~((-754665816) | i520))) * (-1228)) + (((~(i520 | (-69337409))) | (~((-285513217) | i520))) * 614);
                    int i522 = i521 * (-1917);
                    int i523 = (15360 ^ i522) + ((i522 & 15360) << 1);
                    int i524 = ~i521;
                    int i525 = ~((i524 & i28) | (i524 ^ i28));
                    int i526 = ~((i ^ 16) | (i & 16));
                    int i527 = -(-(((i525 & i526) | (i525 ^ i526)) * 959));
                    int i528 = ((i523 | i527) << 1) - (i527 ^ i523);
                    int i529 = ~i521;
                    int i530 = i3 + i528 + (i529 * (-959)) + (((~(i529 | i)) | (~((i28 ^ 16) | (i28 & 16)))) * 959);
                    int i531 = i530 ^ (i530 << 13);
                    int i532 = i531 ^ (i531 >>> 17);
                    ((int[]) objArr86[4])[0] = i532 ^ (i532 << 5);
                    return objArr86;
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = D8871 + 1;
        vD14832N6715 = i % 128;
        if (i % 2 != 0) {
            int i2 = 51 / 0;
        }
    }

    public /* synthetic */ component10Y10845(List list, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, setpivotyn16904);
    }
}
