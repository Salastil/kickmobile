package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import com.datadog.reactnative.ProxyAuthenticator;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB-\b\u0002\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/mG25782;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/List;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class mG25782 extends wX26196 {
    private static int D8871 = 0;
    private static int setPivotYN16904 = 1;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private mG25782(List<? extends Map<String, ? extends Object>> list, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component10Y10845.INSTANCE.component5(), list, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.mG25782$vD14832N6715, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n¨\u0006\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LastKnownLocationsInfoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LastKnownLocationsInfoSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LastKnownLocationInfo;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LastKnownLocationsInfoError;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LastKnownLocationsInfoResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static char D8871;
        private static char component5;
        private static long component9;
        private static char setPivotYN16904;
        private static char vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r6, byte r7, short r8) {
            /*
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.mG25782.Companion.$$a
                int r7 = r7 * 2
                int r1 = r7 + 1
                int r6 = 109 - r6
                int r8 = r8 * 2
                int r8 = 4 - r8
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r6 = r7
                r3 = r8
                r4 = r2
                goto L29
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L21:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r4
                r4 = r5
            L29:
                int r8 = -r8
                int r3 = r3 + 1
                int r6 = r6 + r8
                r8 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.mG25782.Companion.$$c(byte, byte, short):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{98, -108, 56, -31};
            $$b = 255;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static mG25782 component9(D8871<? extends List<qU20128>, ? extends sB6055> d8871) {
            wX26196.setPivotYN16904.vD14832N6715 vd14832n6715;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (d8871 instanceof vD14832N6715) {
                List<qU20128> list = (List) ((vD14832N6715) d8871).setPivotYN16904;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (qU20128 qu20128 : list) {
                    String strComponent5 = I30900.R24140.INSTANCE.component5();
                    int iComponent5 = pC2922Q7530.component5();
                    int iComponent6 = pC2922Q7530.component5();
                    int iComponent7 = pC2922Q7530.component5();
                    int iComponent8 = pC2922Q7530.component5();
                    String strComponent6 = I30900.bk.INSTANCE.component5();
                    int iComponent9 = pC2922Q7530.component5();
                    arrayList.add(MapsKt.mapOf(TuplesKt.to(strComponent5, (List) qU20128.vD14832N6715(iComponent6, iComponent8, iComponent5, new Object[]{qu20128}, -433918051, iComponent7, 433918051)), TuplesKt.to(I30900.an.INSTANCE.component5(), Boolean.valueOf(qu20128.setPivotYN16904())), TuplesKt.to(strComponent6, (String) qU20128.vD14832N6715(pC2922Q7530.component5(), pC2922Q7530.component5(), iComponent9, new Object[]{qu20128}, -736406098, pC2922Q7530.component5(), 736406099)), TuplesKt.to(I30900.cs.INSTANCE.component5(), Long.valueOf(qu20128.component5()))));
                }
                return new mG25782(arrayList, wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            }
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            E e = ((setPivotYN16904) d8871).setPivotYN16904;
            if (Intrinsics.areEqual(e, sB6055.vD14832N6715.INSTANCE)) {
                vd14832n6715 = wX26196.setPivotYN16904.component5.INSTANCE;
            } else if (Intrinsics.areEqual(e, sB6055.component9.INSTANCE)) {
                vd14832n6715 = wX26196.setPivotYN16904.D8871.INSTANCE;
            } else if (Intrinsics.areEqual(e, sB6055.component5.INSTANCE)) {
                vd14832n6715 = wX26196.setPivotYN16904.component9.INSTANCE;
            } else {
                if (!Intrinsics.areEqual(e, sB6055.D8871.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                vd14832n6715 = wX26196.setPivotYN16904.vD14832N6715.INSTANCE;
            }
            return new mG25782(objArr2 == true ? 1 : 0, vd14832n6715, objArr == true ? 1 : 0);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Code duplicated, block: B:9:0x001e  */
        private static void b(String str, int i, Object[] objArr) throws Throwable {
            Object charArray;
            int i2;
            int i3;
            int i4 = 2 % 2;
            int i5 = $10 + 7;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = 34 / 0;
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
            while (cbVar.D8871 < cArr.length) {
                int i7 = cbVar.D8871;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                    if (objComponent5 == null) {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 52;
                        char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 60693);
                        i2 = 55223;
                        int mode = 5955 - View.MeasureSpec.getMode(0);
                        byte b = (byte) ($$b & 3);
                        i3 = 2106881226;
                        byte b2 = (byte) (b - 3);
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionGroup, jumpTapTimeout, mode, 148978589, false, $$c(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    } else {
                        i2 = 55223;
                        i3 = 2106881226;
                    }
                    jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (component9 ^ (-1805496993403714128L));
                    Object[] objArr3 = {cbVar, cbVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                    if (objComponent6 == null) {
                        int iMyPid = 52 - (Process.myPid() >> 22);
                        char cAlpha = (char) (i2 - Color.alpha(0));
                        int iIndexOf = 3269 - TextUtils.indexOf("", "");
                        byte b3 = (byte) ($$b & 5);
                        byte b4 = (byte) (b3 - 5);
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyPid, cAlpha, iIndexOf, 790704297, false, $$c(b3, b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                    int i8 = $11 + 27;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
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
                cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                Object[] objArr4 = {cbVar, cbVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent7 == null) {
                    int iBlue = Color.blue(0) + 52;
                    char cArgb = (char) (Color.argb(0, 0, 0, 0) + 55223);
                    int pressedStateDuration = 3269 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    byte b5 = (byte) ($$b & 5);
                    byte b6 = (byte) (b5 - 5);
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue, cArgb, pressedStateDuration, 790704297, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            }
            String str2 = new String(cArr2);
            int i10 = $10 + 35;
            $11 = i10 % 128;
            if (i10 % 2 == 0) {
                throw null;
            }
            objArr[0] = str2;
        }

        private static void a(String str, int i, Object[] objArr) throws Throwable {
            char[] charArray;
            int i2;
            int i3 = 2;
            int i4 = 2 % 2;
            int i5 = $11 + 119;
            int i6 = i5 % 128;
            $10 = i6;
            int i7 = i5 % 2;
            if (str != null) {
                int i8 = i6 + 113;
                $11 = i8 % 128;
                int i9 = i8 % 2;
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
                int i10 = $10 + 57;
                $11 = i10 % 128;
                int i11 = 58224;
                char c = 1;
                if (i10 % i3 == 0) {
                    cArr3[1] = cArr[cjVar.D8871];
                    cArr3[0] = cArr[cjVar.D8871];
                    i2 = 1;
                } else {
                    cArr3[0] = cArr[cjVar.D8871];
                    cArr3[1] = cArr[cjVar.D8871 + 1];
                    i2 = 0;
                }
                while (i2 < 16) {
                    int i12 = $11 + 67;
                    $10 = i12 % 128;
                    int i13 = i12 % i3;
                    char c2 = cArr3[c];
                    char c3 = cArr3[0];
                    char c4 = c;
                    int i14 = (c3 + i11) ^ ((c3 << 4) + ((char) (((long) vD14832N6715) ^ 2653044645608467852L)));
                    int i15 = c3 >>> 5;
                    try {
                        Object[] objArr2 = new Object[4];
                        objArr2[3] = Integer.valueOf(D8871);
                        objArr2[i3] = Integer.valueOf(i15);
                        objArr2[c4] = Integer.valueOf(i14);
                        objArr2[0] = Integer.valueOf(c2);
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.lastIndexOf("", '0', 0, 0) + 53, (char) Color.alpha(0), 5421 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -1101845982, false, $$c((byte) 0, (byte) 0, (short) 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        char cCharValue = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        cArr3[c4] = cCharValue;
                        char c5 = cArr3[0];
                        int i16 = (cCharValue + i11) ^ ((cCharValue << 4) + ((char) (((long) component5) ^ 2653044645608467852L)));
                        int i17 = cCharValue >>> 5;
                        Object[] objArr3 = new Object[4];
                        objArr3[3] = Integer.valueOf(setPivotYN16904);
                        objArr3[i3] = Integer.valueOf(i17);
                        objArr3[c4] = Integer.valueOf(i16);
                        objArr3[0] = Integer.valueOf(c5);
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.getMode(0) + 52, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5421, -1101845982, false, $$c((byte) 0, (byte) 0, (short) 0), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        cArr3[0] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                        i11 -= 40503;
                        i2++;
                        c = c4;
                        i3 = i3;
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
                i3 = i3;
                Object[] objArr4 = new Object[i3];
                objArr4[c6] = cjVar;
                objArr4[0] = cjVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-417400915);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(59 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0), ExpandableListView.getPackedPositionChild(0L) + 1188, -1247038514, false, "k", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        static {
            init$0();
            $10 = 0;
            $11 = 1;
            component5 = (char) 45074;
            setPivotYN16904 = (char) 34656;
            vD14832N6715 = (char) 53351;
            D8871 = (char) 60928;
            component9 = 5860561914423009339L;
        }

        public static Object[] component5(Context context, int i, int i2) {
            char c;
            int i3 = 1;
            if (context == null) {
                Object[] objArr = {new int[]{i}, null, new int[]{i}, new int[1]};
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i4 = ~iFreeMemory;
                int i5 = i2 + (((~((-1909101678) | i4)) | (~((-2304257) | iFreeMemory)) | (~(i4 | 2304256))) * 959) + 1785708844 + (((~(iFreeMemory | 2304256)) | (~(i4 | (-2304257))) | (~((-1909101678) | iFreeMemory))) * 959);
                int i6 = i5 << 13;
                int i7 = (i5 | i6) & (~(i5 & i6));
                int i8 = i7 ^ (i7 >>> 17);
                int i9 = i8 << 5;
                ((int[]) objArr[3])[0] = (i8 | i9) & (~(i8 & i9));
                return objArr;
            }
            try {
                int i10 = -TextUtils.indexOf("", "");
                int iComponent9 = pC2922.component9();
                int i11 = ~i10;
                int i12 = (i11 ^ 38) | (i11 & 38);
                c = 3;
                int i13 = (~i12) | iComponent9;
                int i14 = ~(((-39) ^ i10) | ((-39) & i10));
                int i15 = (((i10 * 615) - 23294) - (~(-(-(((i13 ^ i14) | (i14 & i13)) * 614))))) - 1;
                int i16 = ~i10;
                int i17 = ~iComponent9;
                int i18 = (~((i16 ^ i17) | (i16 & i17))) | (~i12);
                int i19 = ~iComponent9;
                int i20 = ~((i19 ^ 38) | (i19 & 38));
                int i21 = ((i18 ^ i20) | (i18 & i20)) * (-1228);
                int i22 = (i15 ^ i21) + ((i21 & i15) << 1);
                int i23 = (i11 ^ (-39)) | (i11 & (-39));
                int i24 = ~((i23 & i17) | (i23 ^ i17));
                int i25 = (i19 ^ i10) | (i10 & i19);
                int i26 = ~((i25 & 38) | (i25 ^ 38));
                int i27 = -(-(((i24 & i26) | (i24 ^ i26)) * 614));
                int i28 = (i22 ^ i27) + ((i27 & i22) << 1);
                try {
                    Object[] objArr2 = new Object[1];
                    a("ᓾ챶\ueae0滄।뇄훸다✗\ue154በꛨ㫞ꛈ倕汻䨃瘚惡齟鳯먿൷뽶˥\ueca7寁홫㊎㼼በꛨ坌㷎⋗\ue9d4佡빞", i28, objArr2);
                    Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                    int i29 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    int i30 = ~i29;
                    int i31 = ~i;
                    int i32 = ~(i30 | i31 | 33826);
                    int i33 = (i29 ^ 33826) | (i29 & 33826);
                    int i34 = ~((i33 ^ i) | (i33 & i));
                    int i35 = (((i29 * 303) - 10181626) - (~(((i32 ^ i34) | (i34 & i32)) * (-302)))) - 1;
                    int i36 = (i30 ^ 33826) | (i30 & 33826);
                    int i37 = (~((i36 & i) | (i36 ^ i))) * (-604);
                    int i38 = (i35 ^ i37) + ((i37 & i35) << 1);
                    int i39 = ~(((-33827) & i29) | ((-33827) ^ i29));
                    int i40 = ~((i ^ 33826) | (i & 33826));
                    int i41 = -(-(((i39 & i40) | (i39 ^ i40)) * 302));
                    int i42 = ((i38 | i41) << 1) - (i41 ^ i38);
                    Object[] objArr4 = new Object[1];
                    b("◈ꇦⷰꦣ㕩녀㴫뤑Ӻ胔\u0cf5衎ᑊ逮ᰔ鯡林\ue397激\ueb53睙\uf330绻贈䚪슄丩쩹噢툩姂", i42, objArr4);
                    try {
                        Object[] objArr5 = {(String) objArr4[0]};
                        int i43 = -(ViewConfiguration.getTouchSlop() >> 8);
                        int iComponent10 = pC2922.component9();
                        int i44 = i43 * (-167);
                        int i45 = (i44 & (-6346)) + (i44 | (-6346));
                        int i46 = ~i43;
                        int i47 = ~((i46 ^ (-39)) | (i46 & (-39)));
                        int i48 = ~iComponent10;
                        int i49 = ~(((-39) ^ i48) | ((-39) & i48));
                        int i50 = i45 + (((i47 ^ i49) | (i49 & i47)) * 168);
                        int i51 = ~i43;
                        int i52 = (i51 ^ (-39)) | (i51 & (-39));
                        int i53 = -(-((~((i52 ^ iComponent10) | (i52 & iComponent10))) * 168));
                        int i54 = ~(i48 | i46);
                        int i55 = ~(i51 | 38);
                        int i56 = (i54 & i55) | (i54 ^ i55);
                        int i57 = (-39) | i43;
                        int i58 = ~((i57 & iComponent10) | (i57 ^ iComponent10));
                        int i59 = (((i50 | i53) << 1) - (i50 ^ i53)) + (((i58 & i56) | (i56 ^ i58)) * 168);
                        Object[] objArr6 = new Object[1];
                        a("ᓾ챶\ueae0滄।뇄훸다✗\ue154በꛨ㫞ꛈ倕汻䨃瘚惡齟鳯먿൷뽶˥\ueca7寁홫㊎㼼በꛨ坌㷎⋗\ue9d4佡빞", i59, objArr6);
                        objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                        int i60 = -ExpandableListView.getPackedPositionChild(0L);
                        int iComponent11 = pC2922.component9();
                        int i61 = ~i60;
                        int i62 = ~((i61 ^ 1578) | (i61 & 1578));
                        int i63 = ~iComponent11;
                        int i64 = ~((i63 ^ i60) | (i63 & i60));
                        int i65 = ((((i60 * 375) - 1178766) + (((i62 & i64) | (i62 ^ i64)) * (-374))) - (~((~(((-1579) ^ i60) | ((-1579) & i60))) * 748))) - 1;
                        int i66 = ~((i61 & (-1579)) | (i61 ^ (-1579)));
                        int i67 = ~((i60 & i63) | (i63 ^ i60));
                        int i68 = -(-(((i67 & i66) | (i66 ^ i67)) * 374));
                        int i69 = ((i65 | i68) << 1) - (i68 ^ i65);
                        Object[] objArr7 = new Object[1];
                        b("◈⎝⦈㝙㴋㬓´\u0ee7ᒽቬᡗ昽濦痀珽祍䝵䵭䫌僔庳ꑾꉖ\ua83f뇧뾘薑荧襝霡鳦", i69, objArr7);
                        try {
                            Object[] objArr8 = {(String) objArr7[0]};
                            int i70 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            int i71 = (i70 ^ 37) + ((i70 & 37) << 1);
                            Object[] objArr9 = new Object[1];
                            a("ᓾ챶\ueae0滄।뇄훸다✗\ue154በꛨ㫞ꛈ倕汻䨃瘚惡齟鳯먿൷뽶˥\ueca7寁홫㊎㼼በꛨ坌㷎⋗\ue9d4佡빞", i71, objArr9);
                            objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                            try {
                                Object[] objArr10 = new Object[1];
                                b("◪\uda22\uda61\udaac\udaf8\udb01\udb45\udbd4\udbd0\ud81b\ud823\ud872\ud8ba\ud8fe\ud91d\ud90c\ud9b8\u84e1b\ude3a\ude62\udea0\udee5", 65478 - (~Color.argb(0, 0, 0, 0)), objArr10);
                                Class<?> cls = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                b("◬䴏\uf43dὸ虮⦍傦\ufbcd拤訇㴌ꑁ콩皇馢Áꯩ", 26847 - (~(-(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))), objArr11);
                                Object objInvoke = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                                try {
                                    int i72 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                    int i73 = (i72 ^ 65480) + ((i72 & 65480) << 1);
                                    Object[] objArr12 = new Object[1];
                                    b("◪\uda22\uda61\udaac\udaf8\udb01\udb45\udbd4\udbd0\ud81b\ud823\ud872\ud8ba\ud8fe\ud91d\ud90c\ud9b8\u84e1b\ude3a\ude62\udea0\udee5", i73, objArr12);
                                    Class<?> cls2 = Class.forName((String) objArr12[0]);
                                    int i74 = -((Process.getThreadPriority(0) + 20) >> 6);
                                    int i75 = (i74 ^ 25073) + ((i74 & 25073) << 1);
                                    Object[] objArr13 = new Object[1];
                                    b("◬䐟\ue61d\bꈮ챝湆衽⩤咗\uf6afႱ늪\udcd3", i75, objArr13);
                                    try {
                                        Object[] objArr14 = {cls2.getMethod((String) objArr13[0], null).invoke(context, null), 64};
                                        int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
                                        int i76 = touchSlop * (-432);
                                        int i77 = (i76 ^ 14322) + ((i76 & 14322) << 1);
                                        int i78 = ~touchSlop;
                                        int i79 = (i78 ^ i31) | (i78 & i31);
                                        int i80 = (~((i79 & 33) | (i79 ^ 33))) * 433;
                                        int i81 = (i77 ^ i80) + ((i77 & i80) << 1);
                                        int i82 = ~(((-34) & i) | ((-34) ^ i));
                                        int i83 = i81 + (((i78 & i82) | (i78 ^ i82)) * (-433));
                                        int i84 = ((~(touchSlop | 33)) | (~((~touchSlop) | i))) * 433;
                                        int i85 = (i83 & i84) + (i84 | i83);
                                        Object[] objArr15 = new Object[1];
                                        a("\u0eed넮罧㑔ڝ璸牥僎ﻌ說趕黥뮸\ud87c\uf446ᨑ㤵\udbc9篱잷骊⇎巭藹\uf038\uf74b솗뛣\u0efb鋵\uf038\uf74b뎆࢘", i85, objArr15);
                                        Class<?> cls3 = Class.forName((String) objArr15[0]);
                                        int iAxisFromString = MotionEvent.axisFromString("");
                                        int i86 = ((iAxisFromString | 52610) << 1) - (iAxisFromString ^ 52610);
                                        Object[] objArr16 = new Object[1];
                                        b("◬\ue86f뻽䵘Ꮾ♭\uf4e6뭭䧤ᱧ⋈\uf16e蟡䩩", i86, objArr16);
                                        Object objInvoke2 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                        int i87 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                        int iComponent12 = pC2922.component9();
                                        int i88 = (i87 * (-519)) + 25717602;
                                        int i89 = ~i87;
                                        int i90 = i89 | (-49363);
                                        int i91 = ~iComponent12;
                                        int i92 = ~((i90 & i91) | (i90 ^ i91));
                                        int i93 = ~((iComponent12 ^ 49362) | (49362 & iComponent12));
                                        int i94 = -(-(((i92 ^ i93) | (i92 & i93)) * 520));
                                        int i95 = ((i88 | i94) << 1) - (i88 ^ i94);
                                        int i96 = ~iComponent12;
                                        int i97 = ~(((-49363) ^ i96) | (i96 & (-49363)));
                                        int i98 = (iComponent12 & i87) | (i87 ^ iComponent12);
                                        int i99 = ~i98;
                                        int i100 = ((i97 ^ i99) | (i97 & i99)) * (-1040);
                                        int i101 = (i95 & i100) + (i100 | i95) + (((~((i87 & (-49363)) | ((-49363) ^ i87))) | (~((i89 ^ i91) | (i89 & i91))) | (~i98)) * 520);
                                        Object[] objArr17 = new Object[1];
                                        b("◪\ue536ꑉ枀⚨\ue1fdꄝ恠⍰\ue28f귛泮Ⰺ\uef52깵槸⣋\uebe5ꭳ橲㖖\uf4a7럂真㘤\uf175났玤㋹\uf203", i101, objArr17);
                                        Class<?> cls4 = Class.forName((String) objArr17[0]);
                                        Object[] objArr18 = new Object[1];
                                        a("躗콑ߵ\u17ec뜪\ueb27\uf71a튝⋼俻", 9 - (~(-(-(ViewConfiguration.getTapTimeout() >> 16)))), objArr18);
                                        Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke2);
                                        int length = objArr19.length;
                                        int i102 = 0;
                                        while (i102 < length) {
                                            Object obj = objArr19[i102];
                                            int i103 = -View.resolveSizeAndState(0, 0, 0);
                                            int iComponent13 = pC2922.component9();
                                            int i104 = ~iComponent13;
                                            int i105 = ((-37952) ^ i104) | ((-37952) & i104);
                                            int i106 = ~((i105 ^ i103) | (i105 & i103));
                                            int i107 = i103 | 37951;
                                            int i108 = i3;
                                            int i109 = ~((i107 ^ iComponent13) | (i107 & iComponent13));
                                            int i110 = ((((i103 * 989) - 37457637) + (((i106 ^ i109) | (i109 & i106)) * 988)) - (~(((i103 ^ (-37952)) | (i103 & (-37952))) * (-988)))) - 1;
                                            int i111 = ~i103;
                                            int i112 = (i103 & i104) | (i104 ^ i103);
                                            Object[] objArr20 = new Object[i108];
                                            b("◓놚ව餆畎", i110 + (((~((i112 & 37951) | (i112 ^ 37951))) | (~((i111 ^ (-37952)) | ((-37952) & i111))) | (~((-37952) | iComponent13))) * 988), objArr20);
                                            try {
                                                Object[] objArr21 = {(String) objArr20[0]};
                                                int i113 = -ExpandableListView.getPackedPositionChild(0L);
                                                int iComponent14 = pC2922.component9();
                                                int i114 = ~i113;
                                                int i115 = (i114 & 30630) | (i114 ^ 30630);
                                                int i116 = ((-30631) ^ i113) | ((-30631) & i113);
                                                Object[] objArr22 = objArr19;
                                                int i117 = ((((i113 * 450) - 13722240) - (~(-(-(((~((i116 ^ iComponent14) | (i116 & iComponent14))) | (~i115)) * 449))))) - 1) + ((~i115) * (-1347));
                                                int i118 = ~i113;
                                                int i119 = ~((i118 & 30630) | (i118 ^ 30630));
                                                int i120 = (-30631) | (~iComponent14);
                                                int i121 = (i117 - (~((i119 | (~((i113 & i120) | (i120 ^ i113)))) * 449))) - 1;
                                                Object[] objArr23 = new Object[1];
                                                b("◡前쪳䌟יּ玻\ue804恹飆ᄦ襤ǒ븦㛞껊✧徉ퟨ䰛쒭糢\uf54a涥\ue5e3ቅ読̞뭷㎻ꠅ\u205f壓턈䥸쇊縬\uf68e", i121, objArr23);
                                                Class<?> cls5 = Class.forName((String) objArr23[0]);
                                                int i122 = -AndroidCharacter.getMirror('0');
                                                int iComponent15 = pC2922.component9();
                                                int i123 = i122 * (-419);
                                                int i124 = (i123 & 21814957) + (i123 | 21814957) + ((~((iComponent15 ^ 51817) | (iComponent15 & 51817))) * 420);
                                                int i125 = ~i122;
                                                int i126 = i124 + (((i125 ^ 51817) | (i125 & 51817)) * (-420));
                                                int i127 = ~((i125 ^ (-51818)) | (i125 & (-51818)));
                                                int i128 = ~iComponent15;
                                                int i129 = ~((i128 & 51817) | (i128 ^ 51817));
                                                int i130 = -(-(((i127 & i129) | (i127 ^ i129)) * 420));
                                                int i131 = ((i126 | i130) << 1) - (i130 ^ i126);
                                                Object[] objArr24 = new Object[1];
                                                b("◬\uefd7농筩ഁ훥颩ꉥ琭㧩쏔", i131, objArr24);
                                                Object objInvoke3 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr21);
                                                try {
                                                    int i132 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                    int iComponent16 = pC2922.component9();
                                                    int i133 = (i132 * (-183)) + 4995;
                                                    int i134 = ~i132;
                                                    int i135 = ~(i134 | 27);
                                                    int i136 = length;
                                                    int i137 = ~iComponent16;
                                                    int i138 = ((~((i137 ^ 27) | (i137 & 27))) | i135) * 184;
                                                    int i139 = ((i133 | i138) << 1) - (i138 ^ i133);
                                                    int i140 = ~(((-28) & i132) | ((-28) ^ i132));
                                                    int i141 = -(-(((i140 & iComponent16) | (iComponent16 ^ i140)) * (-184)));
                                                    int i142 = ((i139 | i141) << 1) - (i141 ^ i139);
                                                    int i143 = (~(i134 | i137)) * 184;
                                                    int i144 = ((i142 | i143) << 1) - (i143 ^ i142);
                                                    Object[] objArr25 = new Object[1];
                                                    a("\u0eed넮罧㑔ڝ璸牥僎ﻌ說趕黥뮸\ud87c\uf446ᨑ㤵\udbc9㘦鳩插䔗\u0efb鋵ጘ뤄듀舞", i144, objArr25);
                                                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                                                    Object[] objArr26 = new Object[1];
                                                    a("摠ꨮ蔃諒찋㻵鯻\ue822萠꣩飒ﻰ", 10 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16)))), objArr26);
                                                    try {
                                                        Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj, null))};
                                                        int iAlpha = Color.alpha(0);
                                                        int i145 = (iAlpha ^ 30631) + ((iAlpha & 30631) << 1);
                                                        Object[] objArr28 = new Object[1];
                                                        b("◡前쪳䌟יּ玻\ue804恹飆ᄦ襤ǒ븦㛞껊✧徉ퟨ䰛쒭糢\uf54a涥\ue5e3ቅ読̞뭷㎻ꠅ\u205f壓턈䥸쇊縬\uf68e", i145, objArr28);
                                                        Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                        int i146 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                        int iComponent17 = pC2922.component9();
                                                        int i147 = i146 * (-495);
                                                        int i148 = (i147 ^ (-15764760)) + ((i147 & (-15764760)) << 1);
                                                        int i149 = ~i146;
                                                        int i150 = ~((i149 & (-31849)) | (i149 ^ (-31849)));
                                                        int i151 = ~i146;
                                                        int i152 = ~((i151 ^ iComponent17) | (i151 & iComponent17));
                                                        int i153 = (i148 - (~(-(-((i150 | i152) * 992))))) - 1;
                                                        int i154 = ~((i151 ^ (-31849)) | (i151 & (-31849)));
                                                        int i155 = ~iComponent17;
                                                        int i156 = (i146 & i155) | (i155 ^ i146);
                                                        int i157 = i153 + (((~((i156 & 31848) | (i156 ^ 31848))) | (i154 & i152) | (i154 ^ i152)) * (-496));
                                                        int i158 = -(-(((iComponent17 ^ 31848) | (iComponent17 & 31848)) * 496));
                                                        int i159 = ((i157 | i158) << 1) - (i158 ^ i157);
                                                        Object[] objArr29 = new Object[1];
                                                        b("◬妉\udd2b僛푥䯩쾕䌿웰穱刺綒\uf136瓖\ue840濡\ue39a木髐", i159, objArr29);
                                                        Object objInvoke4 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                        int length2 = objArr3.length;
                                                        for (int i160 = 0; i160 < 2; i160 = (i160 | 1) + (i160 & 1)) {
                                                            Object obj2 = objArr3[i160];
                                                            try {
                                                                int i161 = -(Process.myPid() >> 22);
                                                                int i162 = i161 * WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL;
                                                                int i163 = (i162 ^ (-144581)) + ((i162 & (-144581)) << 1);
                                                                int i164 = ((~(i31 | 887)) | i161) * (-328);
                                                                int i165 = (i163 ^ i164) + ((i164 & i163) << 1);
                                                                int i166 = (i161 | i) * 164;
                                                                int i167 = (i165 & i166) + (i166 | i165);
                                                                int i168 = ~i161;
                                                                int i169 = ~((i168 & (-888)) | (i168 ^ (-888)));
                                                                int i170 = ~(((-888) & i) | ((-888) ^ i));
                                                                int i171 = (i169 & i170) | (i169 ^ i170);
                                                                int i172 = ~(i161 | (~i) | 887);
                                                                int i173 = -(-(((i172 & i171) | (i171 ^ i172)) * 164));
                                                                int i174 = (i167 ^ i173) + ((i173 & i167) << 1);
                                                                Object[] objArr30 = new Object[1];
                                                                b("◡⚝⌓⾏⡹㒫ㄤ㶩㹆㫖݄Ϣ౦ࢮᕪᘗ\u1289Ἐ\u1bfb搆惲浸榈橹盆獦翩硯䓩䆙䈚亃䬟垹", i174, objArr30);
                                                                Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                                Object[] objArr31 = new Object[1];
                                                                b("◬뵯ᓽ\uec5b䟺\udf6c뛧\u0e69\ue1e0祶탙꠵η鬶狕쩶귲մ鳺瑱쿯ꝿ㻱", TextUtils.getCapsMode("", 0, 0) + 39041, objArr31);
                                                                if (obj2.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke4, null))) {
                                                                    Object[] objArr32 = {new int[]{i}, null, new int[]{i ^ 1}, new int[1]};
                                                                    int iMyTid = Process.myTid();
                                                                    int i175 = (((~((-1806954169) | iMyTid)) | 1837768717) * 398) + 1862451041 + (((~((~iMyTid) | (-1806954169))) | 1837768717) * 398);
                                                                    int i176 = (i175 & 16) + (i175 | 16);
                                                                    int i177 = i176 * (-755);
                                                                    int i178 = i2 * (-755);
                                                                    int i179 = (i177 ^ i178) + ((i177 & i178) << 1);
                                                                    int i180 = ~i176;
                                                                    int i181 = ~i2;
                                                                    int i182 = i179 + ((~((i180 & i181) | (i180 ^ i181))) * 1512);
                                                                    int i183 = ~i176;
                                                                    int i184 = ~i2;
                                                                    int i185 = ~((i183 & i184) | (i183 ^ i184));
                                                                    int i186 = (i176 & i2) | (i176 ^ i2);
                                                                    int i187 = ~((i186 ^ i) | (i186 & i));
                                                                    int i188 = ((i185 & i187) | (i185 ^ i187)) * (-756);
                                                                    int i189 = ((((i182 | i188) << 1) - (i188 ^ i182)) - (~((i186 | i31) * 756))) - 1;
                                                                    int i190 = i189 << 13;
                                                                    int i191 = (i190 | i189) & (~(i189 & i190));
                                                                    int i192 = i191 >>> 17;
                                                                    int i193 = (i191 | i192) & (~(i191 & i192));
                                                                    int i194 = i193 << 5;
                                                                    ((int[]) objArr32[3])[0] = ((~i193) & i194) | ((~i194) & i193);
                                                                    return objArr32;
                                                                }
                                                            } catch (Throwable th) {
                                                                Throwable cause = th.getCause();
                                                                if (cause != null) {
                                                                    throw cause;
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        i102 = (i102 & 1) + (i102 | 1);
                                                        objArr19 = objArr22;
                                                        length = i136;
                                                        i3 = 1;
                                                    } catch (Throwable th2) {
                                                        Throwable cause2 = th2.getCause();
                                                        if (cause2 != null) {
                                                            throw cause2;
                                                        }
                                                        throw th2;
                                                    }
                                                } catch (Throwable th3) {
                                                    Throwable cause3 = th3.getCause();
                                                    if (cause3 != null) {
                                                        throw cause3;
                                                    }
                                                    throw th3;
                                                }
                                            } catch (Throwable th4) {
                                                Throwable cause4 = th4.getCause();
                                                if (cause4 != null) {
                                                    throw cause4;
                                                }
                                                throw th4;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        Throwable cause5 = th5.getCause();
                                        if (cause5 != null) {
                                            throw cause5;
                                        }
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    Throwable cause6 = th6.getCause();
                                    if (cause6 != null) {
                                        throw cause6;
                                    }
                                    throw th6;
                                }
                            } catch (Throwable th7) {
                                Throwable cause7 = th7.getCause();
                                if (cause7 != null) {
                                    throw cause7;
                                }
                                throw th7;
                            }
                        } catch (Throwable th8) {
                            Throwable cause8 = th8.getCause();
                            if (cause8 != null) {
                                throw cause8;
                            }
                            throw th8;
                        }
                    } catch (Throwable th9) {
                        Throwable cause9 = th9.getCause();
                        if (cause9 != null) {
                            throw cause9;
                        }
                        throw th9;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                c = 3;
            }
            Object[] objArr33 = new Object[4];
            objArr33[0] = new int[]{i};
            objArr33[2] = new int[]{i};
            objArr33[c] = new int[1];
            objArr33[1] = null;
            int i195 = ~i;
            int i196 = (~((-859935845) | i195)) | 21075044 | (~(1051470089 | i195));
            int i197 = 575351079 + (((~(i | (-212609290))) | i196) * 590) + (i196 * (-1180)) + (((~((-1051470090) | i195)) | (~(i195 | 859935844))) * 590);
            int iComponent18 = pC2922.component9();
            int i198 = ((i197 * (-813)) - (~(i2 * 408))) - 1;
            int i199 = ~i2;
            int i200 = ~((i199 & i197) | (i199 ^ i197));
            int i201 = ~((i197 ^ iComponent18) | (i197 & iComponent18));
            int i202 = ((i200 & i201) | (i200 ^ i201)) * (-814);
            int i203 = ((i198 | i202) << 1) - (i198 ^ i202);
            int i204 = ~i2;
            int i205 = ~iComponent18;
            int i206 = ~((i204 & i205) | (i204 ^ i205));
            int i207 = ~i197;
            int i208 = ~((i207 & i2) | (i207 ^ i2));
            int i209 = (i206 & i208) | (i206 ^ i208);
            int i210 = ~(i197 | iComponent18);
            int i211 = i203 + (((i209 & i210) | (i209 ^ i210)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE);
            int i212 = ~i197;
            int i213 = ~((i212 ^ i2) | (i212 & i2));
            int i214 = ~((i212 & iComponent18) | (i212 ^ iComponent18));
            int i215 = ((~((iComponent18 & i2) | (i2 ^ iComponent18))) | (i214 & i213) | (i213 ^ i214)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE;
            int i216 = (i211 ^ i215) + ((i215 & i211) << 1);
            int i217 = (i216 << 13) ^ i216;
            int i218 = i217 >>> 17;
            int i219 = ((~i217) & i218) | ((~i218) & i217);
            int i220 = i219 << 5;
            ((int[]) objArr33[c])[0] = ((~i219) & i220) | ((~i220) & i219);
            return objArr33;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = D8871 + 83;
        setPivotYN16904 = i % 128;
        int i2 = i % 2;
    }

    public /* synthetic */ mG25782(List list, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, setpivotyn16904);
    }
}
