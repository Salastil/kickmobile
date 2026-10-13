package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements p {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int component9;
    private static int setPivotYN16904;
    private final PackageManager vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.r.$$a
            int r9 = r9 * 3
            int r9 = 4 - r9
            int r7 = r7 * 4
            int r7 = r7 + 99
            int r8 = r8 * 3
            int r8 = 10 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r8
            r3 = r9
            r5 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L2c:
            int r7 = r7 + r9
            int r7 = r7 + (-23)
            int r9 = r3 + 1
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.r.a(short, short, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{65, -118, 1, 100, 35, Ascii.NAK, Ascii.SUB, Ascii.SYN, Ascii.SYN, Ascii.SO, 32, Ascii.GS, -36};
        $$b = 206;
    }

    public r(PackageManager packageManager) {
        this.vD14832N6715 = packageManager;
    }

    public static final /* synthetic */ PackageManager vD14832N6715(r rVar) {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = (i2 ^ 15) + ((i2 & 15) << 1);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        PackageManager packageManager = rVar.vD14832N6715;
        int i5 = ((i2 | 33) << 1) - (i2 ^ 33);
        setPivotYN16904 = i5 % 128;
        int i6 = i5 % 2;
        return packageManager;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.p
    public final q component5(final String str) throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function1<Object, q>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.r.5
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static final byte[] $$c = null;
                private static final int $$d = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $setPivotYN16904;
                private static long component9;

                /* JADX WARN: Code duplicated, block: B:10:0x0028  */
                /* JADX WARN: Code duplicated, block: B:8:0x0022  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(byte r6, byte r7, byte r8) {
                    /*
                        int r6 = r6 * 4
                        int r6 = r6 + 114
                        int r7 = r7 * 3
                        int r7 = 3 - r7
                        int r8 = r8 * 3
                        int r0 = 1 - r8
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.r.AnonymousClass5.$$c
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        int r8 = 0 - r8
                        if (r1 != 0) goto L18
                        r3 = r7
                        r4 = r2
                        goto L2d
                    L18:
                        r3 = r2
                    L19:
                        byte r4 = (byte) r6
                        r0[r3] = r4
                        int r7 = r7 + 1
                        int r4 = r3 + 1
                        if (r3 != r8) goto L28
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        return r6
                    L28:
                        r3 = r1[r7]
                        r5 = r3
                        r3 = r7
                        r7 = r5
                    L2d:
                        int r6 = r6 + r7
                        r7 = r3
                        r3 = r4
                        goto L19
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.r.AnonymousClass5.$$e(byte, byte, byte):java.lang.String");
                }

                private static void b(short s, short s2, byte b, Object[] objArr2) {
                    int i2 = 115 - b;
                    int i3 = 24 - s;
                    byte[] bArr = $$a;
                    byte[] bArr2 = new byte[15 - s2];
                    int i4 = 14 - s2;
                    int i5 = -1;
                    if (bArr == null) {
                        i2 = (i3 + (-i2)) - 5;
                        i3 = i3;
                    }
                    while (true) {
                        i5++;
                        bArr2[i5] = (byte) i2;
                        if (i5 == i4) {
                            objArr2[0] = new String(bArr2, 0);
                            return;
                        }
                        int i6 = i3 + 1;
                        i2 = (i2 + (-bArr[i6])) - 5;
                        i3 = i6;
                    }
                }

                static void init$0() {
                    $$a = new byte[]{4, 94, 35, 33, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9, 7, -5, -4, 1, -17, -6, -14};
                    $$b = 199;
                }

                static void init$1() {
                    $$c = new byte[]{49, 0, -7, -45};
                    $$d = 52;
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ q invoke(Object obj) {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904;
                    int i4 = (i3 ^ 77) + ((i3 & 77) << 1);
                    $D8871 = i4 % 128;
                    int i5 = i4 % 2;
                    q pivotYN16904$36322709 = setPivotYN16904$36322709(obj);
                    int i6 = $setPivotYN16904;
                    int i7 = ((i6 | 95) << 1) - (i6 ^ 95);
                    $D8871 = i7 % 128;
                    int i8 = i7 % 2;
                    return pivotYN16904$36322709;
                }

                public final q setPivotYN16904$36322709(Object obj) {
                    int i2 = 2 % 2;
                    PackageManager packageManagerVD14832N6715 = r.vD14832N6715(r.this);
                    Intrinsics.checkNotNull(packageManagerVD14832N6715);
                    q qVar = new q(str, packageManagerVD14832N6715.getApplicationInfo(str, 128).dataDir);
                    int i3 = $setPivotYN16904 + 15;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    return qVar;
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:11:0x0026  */
                /* JADX WARN: Code duplicated, block: B:13:0x002a  */
                /* JADX WARN: Code duplicated, block: B:8:0x0018  */
                private static void a(String str2, int i2, Object[] objArr2) throws Throwable {
                    int i3;
                    Object charArray;
                    int i4 = 2 % 2;
                    int i5 = $10 + 63;
                    int i6 = i5 % 128;
                    $11 = i6;
                    if (i5 % 2 == 0) {
                        int i7 = 43 / 0;
                        if (str2 != null) {
                            i3 = i6 + 45;
                            $10 = i3 % 128;
                            if (i3 % 2 == 0) {
                                str2.toCharArray();
                                throw null;
                            }
                            charArray = str2.toCharArray();
                        } else {
                            charArray = str2;
                        }
                    } else if (str2 != null) {
                        i3 = i6 + 45;
                        $10 = i3 % 128;
                        if (i3 % 2 == 0) {
                            str2.toCharArray();
                            throw null;
                        }
                        charArray = str2.toCharArray();
                    } else {
                        charArray = str2;
                    }
                    cl clVar = new cl();
                    char[] pivotYN16904 = cl.setPivotYN16904(component9 ^ (-8731904840774042312L), (char[]) charArray, i2);
                    clVar.vD14832N6715 = 4;
                    int i8 = $10 + 55;
                    while (true) {
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                        if (clVar.vD14832N6715 >= pivotYN16904.length) {
                            objArr2[0] = new String(pivotYN16904, 4, pivotYN16904.length - 4);
                            return;
                        }
                        clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
                        int i10 = clVar.vD14832N6715;
                        try {
                            Object[] objArr3 = {Long.valueOf(pivotYN16904[clVar.vD14832N6715] ^ pivotYN16904[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(component9)};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(353813021);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 50, (char) (43651 - ImageFormat.getBitsPerPixel(0)), 752 - KeyEvent.getDeadChar(0, 0), 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                            }
                            pivotYN16904[i10] = ((Character) ((Method) objComponent5).invoke(null, objArr3)).charValue();
                            Object[] objArr4 = {clVar, clVar};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                            if (objComponent6 == null) {
                                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52;
                                char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                                int i11 = 5421 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                byte b = $$c[1];
                                byte b2 = b;
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumDrawingCacheSize, cMakeMeasureSpec, i11, 257882757, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent6).invoke(null, objArr4);
                            i8 = $10 + 65;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                }

                static {
                    init$1();
                    $10 = 0;
                    $11 = 1;
                    init$0();
                    $D8871 = 0;
                    $setPivotYN16904 = 1;
                    component9 = -4789059016826469189L;
                }

                /* JADX WARN: Failed to calculate best type for var: r4v156 ??
                jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v156 ??, new type: int
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                Caused by: java.lang.NullPointerException
                 */
                /* JADX WARN: Failed to calculate best type for var: r4v156 ??
                jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v156 ??, new type: int
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                Caused by: java.lang.NullPointerException
                 */
                /* JADX WARN: Failed to calculate best type for var: r4v157 ??
                jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v157 ??, new type: int
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                Caused by: java.lang.NullPointerException
                 */
                /* JADX WARN: Failed to calculate best type for var: r4v158 ??
                jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v158 ??, new type: int
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                Caused by: java.lang.NullPointerException
                 */
                /*  JADX ERROR: Types fix failed
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v156 ??, new type: int
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                    Caused by: java.lang.NullPointerException
                    */
                public static java.lang.Object[] setPivotYN16904(android.content.Context r32, int r33, int r34, int r35) {
                    /*
                        Method dump skipped, instruction units count: 2146
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.r.AnonymousClass5.setPivotYN16904(android.content.Context, int, int, int):java.lang.Object[]");
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int i2 = 52 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char cMyPid = (char) (Process.myPid() >> 22);
                int iCombineMeasuredStates = 1077 - View.combineMeasuredStates(0, 0);
                byte b = (byte) ($$a[2] - 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i2, cMyPid, iCombineMeasuredStates, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            q qVar = (q) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), new q(null, null));
            int i3 = setPivotYN16904 + 119;
            component9 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 34 / 0;
            }
            return qVar;
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
        setPivotYN16904 = 0;
        component9 = 1;
    }
}
