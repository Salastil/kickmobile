package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class ak {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final byte[] $$d = null;
    private static final int $$e = 0;
    private static final int $$f = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static int component13;
    private static int component5;
    private static long vD14832N6715;
    private final ConnectivityManager component9;
    private final Context setPivotYN16904;

    private static String $$g(int i, short s, int i2) {
        int i3 = i * 2;
        int i4 = (i2 * 2) + 4;
        int i5 = 120 - (s * 2);
        byte[] bArr = $$c;
        byte[] bArr2 = new byte[i3 + 1];
        int i6 = -1;
        if (bArr == null) {
            i4++;
            i5 += i4;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i5;
            if (i6 == i3) {
                return new String(bArr2, 0);
            }
            byte b = bArr[i4];
            i4++;
            i5 += b;
        }
    }

    private static void a(byte b, short s, short s2, Object[] objArr) {
        byte[] bArr = $$d;
        int i = (b * 3) + 99;
        int i2 = 4 - (s * 2);
        int i3 = s2 * 4;
        byte[] bArr2 = new byte[10 - i3];
        int i4 = 9 - i3;
        int i5 = -1;
        if (bArr == null) {
            i = (i2 + i) - 25;
            i2++;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i2;
            i = (i + bArr[i2]) - 25;
            i2 = i7 + 1;
            i5 = i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(byte r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.ak.$$a
            int r5 = 115 - r5
            int r7 = 15 - r7
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L13
            r5 = r6
            r4 = r7
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r4 = r0[r6]
        L25:
            int r4 = -r4
            int r6 = r6 + 1
            int r5 = r5 + r4
            int r5 = r5 + (-5)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ak.d(byte, int, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{63, 19, -108, 103, -17, -6, -14, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9};
        $$b = 204;
    }

    static void init$1() {
        $$d = new byte[]{10, -109, 37, Ascii.GS, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
        $$e = 172;
    }

    static void init$2() {
        $$c = new byte[]{100, -61, 88, 56};
        $$f = WebmConstants.MkvEbmlElement.BLOCK_MORE;
    }

    public static /* synthetic */ Object vD14832N6715(int i, Object[] objArr, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i3;
        int i8 = ~i5;
        int i9 = (~(i7 | i)) | (~(i7 | i8));
        int i10 = ~i;
        int i11 = (~(i5 | i10 | i3)) | i9;
        int i12 = ~(i8 | i10);
        int i13 = i + i3 + i6 + ((-1228711472) * i4) + ((-141981132) * i2);
        int i14 = i13 * i13;
        int i15 = (((-639131287) * i) - 2072313856) + (1118068377 * i3) + (i11 * (-1268883816)) + ((-1757199664) * i9) + ((-1268883816) * i12) + ((-1908015104) * i6) + ((-287309824) * i4) + ((-1573388288) * i2) + ((-2138374144) * i14);
        int i16 = ((i * (-646461497)) - 273503129) + (i3 * (-646460521)) + (i11 * 488) + (i9 * (-976)) + (i12 * 488) + (i6 * (-646461009)) + (i4 * 1623110960) + (i2 * (-2035004020)) + (i14 * 33882112);
        if (i15 + (i16 * i16 * (-1051394048)) == 1) {
            return vD14832N6715(objArr);
        }
        ak akVar = (ak) objArr[0];
        int i17 = 2 % 2;
        int i18 = component5;
        int i19 = (i18 ^ 67) + ((i18 & 67) << 1);
        component13 = i19 % 128;
        int i20 = i19 % 2;
        Context context = akVar.setPivotYN16904;
        int i21 = ((i18 | 91) << 1) - (i18 ^ 91);
        component13 = i21 % 128;
        int i22 = i21 % 2;
        return context;
    }

    public ak(Context context, ConnectivityManager connectivityManager) {
        this.setPivotYN16904 = context;
        this.component9 = connectivityManager;
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        ak akVar = (ak) objArr[0];
        int i = 2 % 2;
        int i2 = component5;
        int i3 = (i2 ^ 15) + ((i2 & 15) << 1);
        component13 = i3 % 128;
        int i4 = i3 % 2;
        ConnectivityManager connectivityManager = akVar.component9;
        if (i4 != 0) {
            return connectivityManager;
        }
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.ak$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715$component9;", "component9", "()Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function0<D8871<? extends Boolean, ? extends vD14832N6715.component9>> {
        private static int $D8871 = 0;
        private static int $vD14832N6715 = 1;
        public static int component5;
        public static int component9;

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ D8871<? extends Boolean, ? extends vD14832N6715.component9> invoke() {
            int i = 2 % 2;
            int i2 = $vD14832N6715;
            int i3 = ((i2 | 79) << 1) - (i2 ^ 79);
            $D8871 = i3 % 128;
            if (i3 % 2 == 0) {
                return component9();
            }
            component9();
            throw null;
        }

        public final D8871<Boolean, vD14832N6715.component9> component9() {
            int i = 2 % 2;
            int i2 = $D8871 + 67;
            $vD14832N6715 = i2 % 128;
            int i3 = i2 % 2;
            ak akVar = ak.this;
            if (i3 == 0) {
                int iComponent5 = component3H22396.component5();
                int iComponent6 = component3H22396.component5();
                ContextCompat.checkSelfPermission((Context) ak.vD14832N6715(1077698727, new Object[]{akVar}, component3H22396.component5(), -1077698727, component3H22396.component5(), iComponent5, iComponent6), "android.permission.ACCESS_NETWORK_STATE");
                throw null;
            }
            int iComponent7 = component3H22396.component5();
            int iComponent8 = component3H22396.component5();
            if (ContextCompat.checkSelfPermission((Context) ak.vD14832N6715(1077698727, new Object[]{akVar}, component3H22396.component5(), -1077698727, component3H22396.component5(), iComponent7, iComponent8), "android.permission.ACCESS_NETWORK_STATE") != 0) {
                int i4 = $D8871;
                int i5 = (i4 & 75) + (i4 | 75);
                $vD14832N6715 = i5 % 128;
                int i6 = i5 % 2;
                setPivotYN16904 setpivotyn16904 = new setPivotYN16904(vD14832N6715.component9.INSTANCE);
                int i7 = $vD14832N6715 + 29;
                $D8871 = i7 % 128;
                if (i7 % 2 != 0) {
                    int i8 = 9 / 0;
                }
                return setpivotyn16904;
            }
            int i9 = $vD14832N6715;
            int i10 = ((i9 | 5) << 1) - (i9 ^ 5);
            $D8871 = i10 % 128;
            int i11 = i10 % 2;
            Object[] objArr = {ak.this};
            int iComponent9 = component3H22396.component5();
            int iComponent10 = component3H22396.component5();
            ConnectivityManager connectivityManager = (ConnectivityManager) ak.vD14832N6715(473409256, objArr, component3H22396.component5(), -473409255, component3H22396.component5(), iComponent9, iComponent10);
            Intrinsics.checkNotNull(connectivityManager);
            Network activeNetwork = connectivityManager.getActiveNetwork();
            Intrinsics.checkNotNull(activeNetwork);
            Object[] objArr2 = {ak.this};
            int iComponent11 = component3H22396.component5();
            int iComponent12 = component3H22396.component5();
            NetworkCapabilities networkCapabilities = ((ConnectivityManager) ak.vD14832N6715(473409256, objArr2, component3H22396.component5(), -473409255, component3H22396.component5(), iComponent11, iComponent12)).getNetworkCapabilities(activeNetwork);
            Intrinsics.checkNotNull(networkCapabilities);
            com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715 vd14832n6715 = new com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715(Boolean.valueOf(networkCapabilities.hasTransport(4)));
            int i12 = $D8871 + 81;
            $vD14832N6715 = i12 % 128;
            int i13 = i12 % 2;
            return vd14832n6715;
        }

        public static int vD14832N6715() {
            int i = component9;
            int i2 = i % 5245953;
            component9 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            component5 = elapsedCpuTime;
            return elapsedCpuTime;
        }

        AnonymousClass5() {
            super(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final D8871<Boolean, vD14832N6715> component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new AnonymousClass5(), 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int iIndexOf = TextUtils.indexOf("", "", 0) + 51;
                char c = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int defaultSize = View.getDefaultSize(0, 0) + 1077;
                Object[] objArr2 = new Object[1];
                a((byte) 0, (short) 0, (short) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, c, defaultSize, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            setPivotYN16904 setpivotyn16904 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            if (setpivotyn16904 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) {
                int i2 = component5;
                int i3 = (i2 & 43) + (i2 | 43);
                component13 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 87 / 0;
                }
            } else {
                if (!(setpivotyn16904 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                setpivotyn16904 = new setPivotYN16904(vD14832N6715.D8871.INSTANCE);
            }
            D8871<Boolean, vD14832N6715> d8871Component9 = bb.component9(setpivotyn16904);
            int i5 = component5;
            int i6 = (i5 & 81) + (i5 | 81);
            component13 = i6 % 128;
            int i7 = i6 % 2;
            return d8871Component9;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.ak$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9$component5;", "vD14832N6715", "()Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<D8871<? extends Boolean, ? extends component9.component5>> {
        private static int $component9 = 0;
        private static int $setPivotYN16904 = 1;
        public static int D8871;
        public static int component5;

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ D8871<? extends Boolean, ? extends component9.component5> invoke() {
            int i = 2 % 2;
            int i2 = $setPivotYN16904 + GapComposerKt.nodeKey;
            $component9 = i2 % 128;
            int i3 = i2 % 2;
            D8871<Boolean, component9.component5> d8871VD14832N6715 = vD14832N6715();
            int i4 = $setPivotYN16904 + 23;
            $component9 = i4 % 128;
            int i5 = i4 % 2;
            return d8871VD14832N6715;
        }

        public final D8871<Boolean, component9.component5> vD14832N6715() {
            NetworkCapabilities networkCapabilities;
            int i = 2 % 2;
            int i2 = $setPivotYN16904 + 103;
            $component9 = i2 % 128;
            int i3 = i2 % 2;
            ak akVar = ak.this;
            Object obj = null;
            if (i3 != 0) {
                ContextCompat.checkSelfPermission((Context) ak.vD14832N6715(1077698727, new Object[]{akVar}, component3H22396.component5(), -1077698727, component3H22396.component5(), component3H22396.component5(), component3H22396.component5()), "android.permission.ACCESS_NETWORK_STATE");
                throw null;
            }
            int iCheckSelfPermission = ContextCompat.checkSelfPermission((Context) ak.vD14832N6715(1077698727, new Object[]{akVar}, component3H22396.component5(), -1077698727, component3H22396.component5(), component3H22396.component5(), component3H22396.component5()), "android.permission.ACCESS_NETWORK_STATE");
            boolean z = true;
            if (iCheckSelfPermission != 0) {
                int i4 = $setPivotYN16904 + 103;
                $component9 = i4 % 128;
                if (i4 % 2 == 0) {
                    return new setPivotYN16904(component9.component5.INSTANCE);
                }
            } else {
                int i5 = $setPivotYN16904;
                int i6 = (i5 ^ 73) + ((i5 & 73) << 1);
                $component9 = i6 % 128;
                int i7 = i6 % 2;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) ak.vD14832N6715(473409256, new Object[]{ak.this}, component3H22396.component5(), -473409255, component3H22396.component5(), component3H22396.component5(), component3H22396.component5());
            Intrinsics.checkNotNull(connectivityManager);
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNull(allNetworks);
            List listFilterNotNull = ArraysKt.filterNotNull(allNetworks);
            ak akVar2 = ak.this;
            ArrayList arrayList = new ArrayList();
            Iterator it = listFilterNotNull.iterator();
            int i8 = $setPivotYN16904;
            int i9 = (i8 & 3) + (i8 | 3);
            $component9 = i9 % 128;
            int i10 = i9 % 2;
            while (it.hasNext()) {
                int i11 = $setPivotYN16904 + 23;
                $component9 = i11 % 128;
                if (i11 % 2 != 0) {
                    networkCapabilities = ((ConnectivityManager) ak.vD14832N6715(473409256, new Object[]{akVar2}, component3H22396.component5(), -473409255, component3H22396.component5(), component3H22396.component5(), component3H22396.component5())).getNetworkCapabilities((Network) it.next());
                    int i12 = 72 / 0;
                    if (networkCapabilities != null) {
                        int i13 = $setPivotYN16904;
                        int i14 = (i13 & 55) + (i13 | 55);
                        $component9 = i14 % 128;
                        int i15 = i14 % 2;
                        arrayList.add(networkCapabilities);
                        int i16 = $component9;
                        int i17 = (i16 ^ 77) + ((i16 & 77) << 1);
                        $setPivotYN16904 = i17 % 128;
                        int i18 = i17 % 2;
                    }
                } else {
                    networkCapabilities = ((ConnectivityManager) ak.vD14832N6715(473409256, new Object[]{akVar2}, component3H22396.component5(), -473409255, component3H22396.component5(), component3H22396.component5(), component3H22396.component5())).getNetworkCapabilities((Network) it.next());
                    if (networkCapabilities != null) {
                        int i19 = $setPivotYN16904;
                        int i110 = (i19 & 55) + (i19 | 55);
                        $component9 = i110 % 128;
                        int i111 = i110 % 2;
                        arrayList.add(networkCapabilities);
                        int i112 = $component9;
                        int i113 = (i112 ^ 77) + ((i112 & 77) << 1);
                        $setPivotYN16904 = i113 % 128;
                        int i114 = i113 % 2;
                    }
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.isEmpty()) {
                z = false;
            } else {
                int i20 = $component9 + 45;
                $setPivotYN16904 = i20 % 128;
                if (i20 % 2 == 0) {
                    arrayList2.iterator();
                    obj.hashCode();
                    throw null;
                }
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        int i21 = $component9 + 79;
                        $setPivotYN16904 = i21 % 128;
                        if (i21 % 2 == 0) {
                            if (((NetworkCapabilities) it2.next()).hasTransport(5)) {
                                int i22 = $component9 + 115;
                                $setPivotYN16904 = i22 % 128;
                                int i23 = i22 % 2;
                            }
                        } else if (((NetworkCapabilities) it2.next()).hasTransport(4)) {
                            int i24 = $component9 + 115;
                            $setPivotYN16904 = i24 % 128;
                            int i25 = i24 % 2;
                        }
                    } else {
                        z = false;
                    }
                }
            }
            return new com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715(Boolean.valueOf(z));
        }

        public static int component9() {
            int i = component5;
            int i2 = i % 7097896;
            component5 = i + 1;
            if (i2 != 0) {
                return D8871;
            }
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            D8871 = iUptimeMillis;
            return iUptimeMillis;
        }

        AnonymousClass1() {
            super(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final D8871<Boolean, component9> setPivotYN16904() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new AnonymousClass1(), 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int maxKeyCode = 51 - (KeyEvent.getMaxKeyCode() >> 16);
                char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                int touchSlop = 1077 - (ViewConfiguration.getTouchSlop() >> 8);
                Object[] objArr2 = new Object[1];
                a((byte) 0, (short) 0, (short) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode, scrollBarSize, touchSlop, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            setPivotYN16904 setpivotyn16904 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            if (setpivotyn16904 instanceof com.fingerprintjs.android.fpjs_pro_internal.vD14832N6715) {
                int i2 = component5 + 13;
                component13 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            } else {
                if (!(setpivotyn16904 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                setpivotyn16904 = new setPivotYN16904(component9.D8871.INSTANCE);
                int i3 = component5 + 93;
                component13 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 3 % 2;
                }
            }
            D8871<Boolean, component9> d8871Component9 = bb.component9(setpivotyn16904);
            int i5 = component13;
            int i6 = (i5 & 1) + (i5 | 1);
            component5 = i6 % 128;
            if (i6 % 2 == 0) {
                return d8871Component9;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715;", "", "<init>", "()V", "component9", "D8871", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715$D8871;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class vD14832N6715 {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class D8871 extends vD14832N6715 {
            public static final D8871 INSTANCE = new D8871();
            private static int component9 = 1;
            private static int setPivotYN16904;

            private D8871() {
                super(null);
            }

            static {
                int i = component9;
                int i2 = ((i | 123) << 1) - (i ^ 123);
                setPivotYN16904 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        private vD14832N6715() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715$component9;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$vD14832N6715;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component9 extends vD14832N6715 {
            public static final component9 INSTANCE = new component9();
            private static int component5 = 1;
            private static int component9;

            private component9() {
                super(null);
            }

            static {
                int i = component5;
                int i2 = ((i | 75) << 1) - (i ^ 75);
                component9 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i3 = 45 / 0;
                }
            }
        }

        public /* synthetic */ vD14832N6715(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9;", "", "<init>", "()V", "component5", "D8871", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9$D8871;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class component9 {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9$D8871;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class D8871 extends component9 {
            private static int D8871 = 0;
            public static final D8871 INSTANCE = new D8871();
            private static int component9 = 1;

            private D8871() {
                super(null);
            }

            static {
                int i = component9;
                int i2 = ((i | 29) << 1) - (i ^ 29);
                D8871 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        private component9() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak$component9;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component5 extends component9 {
            public static final component5 INSTANCE = new component5();
            private static int component5 = 1;
            private static int component9;

            private component5() {
                super(null);
            }

            static {
                int i = component5;
                int i2 = (i ^ 15) + ((i & 15) << 1);
                component9 = i2 % 128;
                int i3 = i2 % 2;
            }
        }

        public /* synthetic */ component9(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static void c(String str, int i, Object[] objArr) throws Throwable {
        int i2;
        int i3;
        int i4 = 2 % 2;
        int i5 = $10 + 25;
        $11 = i5 % 128;
        Object obj = null;
        if (i5 % 2 == 0) {
            obj.hashCode();
            throw null;
        }
        char[] charArray = str != null ? str.toCharArray() : str;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = charArray.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < charArray.length) {
            int i6 = $11 + 37;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = cbVar.D8871;
            try {
                Object[] objArr2 = {Integer.valueOf(charArray[cbVar.D8871]), cbVar, cbVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent5 == null) {
                    i2 = 55223;
                    i3 = 2106881226;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 60693), 5955 - TextUtils.getCapsMode("", 0, 0), 148978589, false, $$g(0, (short) 7, 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                } else {
                    i2 = 55223;
                    i3 = 2106881226;
                }
                jArr[i8] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (vD14832N6715 ^ (-1805496993403714128L));
                Object[] objArr3 = {cbVar, cbVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.argb(0, 0, 0, 0) + 52, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + i2), 3269 - (ViewConfiguration.getEdgeSlop() >> 16), 790704297, false, $$g(0, (short) 8, 0), new Class[]{Object.class, Object.class});
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
        char[] cArr = new char[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < charArray.length) {
            int i9 = $11 + 105;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            cArr[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr4 = {cbVar, cbVar};
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionType(0L) + 52, (char) (View.resolveSize(0, 0) + 55223), (ViewConfiguration.getScrollBarSize() >> 8) + 3269, 790704297, false, $$g(0, (short) 8, 0), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    private static void b(String str, int i, boolean z, int i2, int i3, Object[] objArr) throws Throwable {
        Object charArray;
        int i4;
        int i5 = 2 % 2;
        int i6 = $11 + 49;
        $10 = i6 % 128;
        if (i6 % 2 != 0) {
            int i7 = 50 / 0;
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
        cm cmVar = new cm();
        char[] cArr2 = new char[i2];
        cmVar.component9 = 0;
        int i8 = $10 + 75;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        while (cmVar.component9 < i2) {
            int i10 = $11 + 81;
            $10 = i10 % 128;
            int i11 = i10 % 2;
            cmVar.setPivotYN16904 = cArr[cmVar.component9];
            cArr2[cmVar.component9] = (char) (i3 + cmVar.setPivotYN16904);
            int i12 = cmVar.component9;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i12]), Integer.valueOf(D8871)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                if (objComponent5 == null) {
                    i4 = -2009915307;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getTouchSlop() >> 8) + 49, (char) (35725 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 2878 - Gravity.getAbsoluteGravity(0, 0), 463712212, false, $$g(0, (short) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    i4 = -2009915307;
                }
                cArr2[i12] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {cmVar, cmVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i4);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "", 0, 0) + 70, (char) (KeyEvent.keyCodeFromString("") + 19666), 1905 - TextUtils.lastIndexOf("", '0'), -628726730, false, "v", new Class[]{Object.class, Object.class});
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
        if (i > 0) {
            cmVar.vD14832N6715 = i;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - cmVar.vD14832N6715, cmVar.vD14832N6715);
            System.arraycopy(cArr3, cmVar.vD14832N6715, cArr2, 0, i2 - cmVar.vD14832N6715);
        }
        if (z) {
            char[] cArr4 = new char[i2];
            cmVar.component9 = 0;
            while (cmVar.component9 < i2) {
                cArr4[cmVar.component9] = cArr2[(i2 - cmVar.component9) - 1];
                Object[] objArr4 = {cmVar, cmVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(70 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (Color.rgb(0, 0, 0) + 16796882), 1906 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), -628726730, false, "v", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    static {
        init$2();
        $10 = 0;
        $11 = 1;
        init$1();
        init$0();
        component5 = 0;
        component13 = 1;
        D8871 = 1125198999;
        vD14832N6715 = 1835515619225127104L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component5(android.content.Context r51, int r52, int r53, int r54) {
        /*
            Method dump skipped, instruction units count: 9520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ak.component5(android.content.Context, int, int, int):java.lang.Object[]");
    }

    public static final /* synthetic */ ConnectivityManager vD14832N6715(ak akVar) {
        int iComponent5 = component3H22396.component5();
        int iComponent6 = component3H22396.component5();
        return (ConnectivityManager) vD14832N6715(473409256, new Object[]{akVar}, component3H22396.component5(), -473409255, component3H22396.component5(), iComponent5, iComponent6);
    }

    public static final /* synthetic */ Context setPivotYN16904(ak akVar) {
        int iComponent5 = component3H22396.component5();
        int iComponent6 = component3H22396.component5();
        return (Context) vD14832N6715(1077698727, new Object[]{akVar}, component3H22396.component5(), -1077698727, component3H22396.component5(), iComponent5, iComponent6);
    }
}
