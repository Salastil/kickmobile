package com.fingerprintjs.android.fpjs_pro_internal;

import android.media.AudioTrack;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wB2645 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int D8871;
    private static int vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 4
            int r7 = 99 - r7
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.wB2645.$$a
            int r6 = r6 * 3
            int r6 = 3 - r6
            int r8 = r8 * 3
            int r1 = 10 - r8
            byte[] r1 = new byte[r1]
            int r8 = 9 - r8
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = r2
            r7 = r6
            goto L31
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            int r6 = r6 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L31:
            int r3 = r3 + r6
            int r6 = r3 + (-25)
            r3 = r7
            r7 = r6
            r6 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.wB2645.a(short, short, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{Ascii.DC2, 102, 73, -44, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
        $$b = 237;
    }

    public static final class component5 {
        public static int D8871 = 0;
        public static int component5 = 0;
        private static int component8 = 1;
        private static int component9;
        private final String setPivotYN16904;
        private final boolean vD14832N6715;

        public component5(String str, boolean z) {
            this.setPivotYN16904 = str;
            this.vD14832N6715 = z;
        }

        public final String component5() {
            int i = 2 % 2;
            int i2 = component8;
            int i3 = ((i2 | 9) << 1) - (i2 ^ 9);
            int i4 = i3 % 128;
            component9 = i4;
            int i5 = i3 % 2;
            String str = this.setPivotYN16904;
            int i6 = i4 + 89;
            component8 = i6 % 128;
            if (i6 % 2 != 0) {
                return str;
            }
            throw null;
        }

        public final boolean D8871() {
            int i = 2 % 2;
            int i2 = component9;
            int i3 = (i2 ^ 95) + ((i2 & 95) << 1);
            int i4 = i3 % 128;
            component8 = i4;
            int i5 = i3 % 2;
            boolean z = this.vD14832N6715;
            if (i5 == 0) {
                int i6 = 98 / 0;
            }
            int i7 = (i4 ^ 83) + ((i4 & 83) << 1);
            component9 = i7 % 128;
            if (i7 % 2 == 0) {
                return z;
            }
            throw null;
        }

        public static int setPivotYN16904() {
            int i = D8871;
            int i2 = i % 5533040;
            D8871 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            component5 = i3;
            return i3;
        }
    }

    public final D8871<List<component5>, Throwable> setPivotYN16904() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new Function0<List<? extends component5>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.wB2645.5
                private static int $component5 = 0;
                private static int $setPivotYN16904 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ List<? extends component5> invoke() throws SocketException {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904;
                    int i4 = (i3 ^ 23) + ((i3 & 23) << 1);
                    $component5 = i4 % 128;
                    int i5 = i4 % 2;
                    List<component5> listD8871 = D8871();
                    int i6 = $component5 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    $setPivotYN16904 = i6 % 128;
                    if (i6 % 2 == 0) {
                        int i7 = 68 / 0;
                    }
                    return listD8871;
                }

                public final List<component5> D8871() throws SocketException {
                    setPivotYN16904 setpivotyn16904;
                    int i2 = 2 % 2;
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    Intrinsics.checkNotNull(networkInterfaces);
                    List<NetworkInterface> listFilterNotNull = CollectionsKt.filterNotNull(Collections.list(networkInterfaces));
                    ArrayList arrayList = new ArrayList();
                    for (NetworkInterface networkInterface : listFilterNotNull) {
                        try {
                            String name = networkInterface.getName();
                            Intrinsics.checkNotNull(name);
                            setpivotyn16904 = new vD14832N6715(new component5(name, networkInterface.isUp()));
                            int i3 = $component5 + 79;
                            $setPivotYN16904 = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (Throwable th) {
                            setpivotyn16904 = new setPivotYN16904(th);
                        }
                        component5 component5Var = (component5) component9.component9(setpivotyn16904, null);
                        if (component5Var != null) {
                            int i5 = $setPivotYN16904 + 55;
                            $component5 = i5 % 128;
                            if (i5 % 2 != 0) {
                                arrayList.add(component5Var);
                                throw null;
                            }
                            arrayList.add(component5Var);
                        } else {
                            int i6 = $component5;
                            int i7 = (i6 ^ 79) + ((i6 & 79) << 1);
                            $setPivotYN16904 = i7 % 128;
                            int i8 = i7 % 2;
                        }
                    }
                    return arrayList;
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 51;
                char c = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, (short) 0, (short) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iCombineMeasuredStates, c, doubleTapTimeout, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<List<component5>, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i2 = D8871 + 107;
            vD14832N6715 = i2 % 128;
            int i3 = i2 % 2;
            return d8871;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static {
        init$0();
        vD14832N6715 = 0;
        D8871 = 1;
    }
}
