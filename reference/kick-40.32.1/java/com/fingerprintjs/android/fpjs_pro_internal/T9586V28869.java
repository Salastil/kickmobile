package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class T9586V28869 implements fQ24217 {
    private static int D8871 = 1;
    private static int setPivotYN16904;
    private final Context component5;

    public static /* synthetic */ Object setPivotYN16904(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) throws Throwable {
        int i7 = ~i;
        int i8 = ~(i7 | i5);
        int i9 = ~(i4 | i5);
        int i10 = ~i4;
        int i11 = ~i5;
        int i12 = i8 | i9 | (~(i10 | i11 | i));
        int i13 = i8 | (~(i7 | i4)) | i9;
        int i14 = (~(i5 | i)) | (~(i10 | i5)) | (~(i7 | i11 | i4));
        int i15 = i + i4 + i3 + (1880080305 * i2) + (458392769 * i6);
        int i16 = i15 * i15;
        int i17 = ((766573918 * i) - Integer.MIN_VALUE) + (1582236324 * i4) + (i12 * (-407831203)) + (815662406 * i13) + ((-407831203) * i14) + (1174405120 * i3) + (1711276032 * i2) + ((-973078528) * i6) + (68288512 * i16);
        int i18 = ((i * 319678698) - 2002258816) + (i4 * 319678284) + (i12 * 207) + (i13 * (-414)) + (i14 * 207) + (319678491 * i3) + ((-161570901) * i2) + ((-1160779685) * i6) + (i16 * (-1109000192));
        if (i17 + (i18 * i18 * (-1432485888)) != 1) {
            return component9(objArr);
        }
        int i19 = 2 % 2;
        try {
            Object[] objArr2 = {0L, false, false, ((T9586V28869) objArr[0]).new AnonymousClass1(), 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            Object obj = "";
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0'), (char) ((Process.getThreadPriority(0) + 20) >> 6), Gravity.getAbsoluteGravity(0, 0) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr2);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i20 = setPivotYN16904;
                int i21 = (i20 ^ 51) + ((i20 & 51) << 1);
                D8871 = i21 % 128;
                int i22 = i21 % 2;
            } else {
                obj = objInvoke;
            }
            String str = (String) obj;
            int i23 = D8871 + 93;
            setPivotYN16904 = i23 % 128;
            int i24 = i23 % 2;
            return str;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public T9586V28869(Context context) {
        this.component5 = context;
    }

    public static final /* synthetic */ Context D8871(T9586V28869 t9586v28869) {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = ((i2 | 9) << 1) - (i2 ^ 9);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        Context context = t9586v28869.component5;
        if (i4 != 0) {
            int i5 = 69 / 0;
        }
        return context;
    }

    public static final /* synthetic */ String vD14832N6715(int i) {
        int i2 = 2 % 2;
        int i3 = setPivotYN16904 + 45;
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        Object[] objArr = {Integer.valueOf(i)};
        int iD8871 = az.Companion.D8871();
        int iD8872 = az.Companion.D8871();
        if (i4 != 0) {
            return (String) setPivotYN16904(-599619672, az.Companion.D8871(), iD8872, 599619672, objArr, iD8871, az.Companion.D8871());
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.fQ24217
    public final String vD14832N6715() throws Throwable {
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.T9586V28869.4
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $component5;
                private static int $setPivotYN16904;
                private static char[] D8871;
                private static long vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0026  */
                /* JADX WARN: Code duplicated, block: B:8:0x0020  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(byte r6, int r7, byte r8) {
                    /*
                        int r6 = r6 * 3
                        int r6 = 3 - r6
                        int r8 = r8 * 3
                        int r8 = 101 - r8
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.T9586V28869.AnonymousClass4.$$a
                        int r7 = r7 * 4
                        int r7 = r7 + 1
                        byte[] r1 = new byte[r7]
                        r2 = 0
                        if (r0 != 0) goto L16
                        r3 = r7
                        r4 = r2
                        goto L28
                    L16:
                        r3 = r2
                    L17:
                        int r4 = r3 + 1
                        byte r5 = (byte) r8
                        r1[r3] = r5
                        int r6 = r6 + 1
                        if (r4 != r7) goto L26
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        return r6
                    L26:
                        r3 = r0[r6]
                    L28:
                        int r3 = -r3
                        int r8 = r8 + r3
                        r3 = r4
                        goto L17
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.T9586V28869.AnonymousClass4.$$c(byte, int, byte):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{123, 65, 32, 68};
                    $$b = 86;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904 + 117;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    String strComponent5 = component5();
                    int i5 = $component5 + 89;
                    $setPivotYN16904 = i5 % 128;
                    int i6 = i5 % 2;
                    return strComponent5;
                }

                public final String component5() {
                    int i2 = 2 % 2;
                    Intent intentRegisterReceiver = T9586V28869.D8871(T9586V28869.this).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    Intrinsics.checkNotNull(intentRegisterReceiver);
                    int intExtra = intentRegisterReceiver.getIntExtra("health", -1);
                    if (intExtra != -1) {
                        int i3 = $component5 + 95;
                        $setPivotYN16904 = i3 % 128;
                        if (i3 % 2 != 0) {
                            return T9586V28869.vD14832N6715(intExtra);
                        }
                        int i4 = 47 / 0;
                        return T9586V28869.vD14832N6715(intExtra);
                    }
                    int i5 = $component5 + 43;
                    $setPivotYN16904 = i5 % 128;
                    int i6 = i5 % 2;
                    return "";
                }

                /* JADX WARN: Code duplicated, block: B:43:0x01cc  */
                /* JADX WARN: Code duplicated, block: B:44:0x01cd  */
                private static void a(int i2, char c, int i3, Object[] objArr2) throws Throwable {
                    Object obj2;
                    Throwable cause;
                    int i4 = 2;
                    int i5 = 2 % 2;
                    ck ckVar = new ck();
                    long[] jArr = new long[i2];
                    ckVar.setPivotYN16904 = 0;
                    while (true) {
                        obj2 = null;
                        if (ckVar.setPivotYN16904 >= i2) {
                            break;
                        }
                        int i6 = $10 + 27;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        int i8 = ckVar.setPivotYN16904;
                        try {
                            Object[] objArr3 = {Integer.valueOf(D8871[i3 + i8])};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16), 5952 - AndroidCharacter.getMirror('0'), -173582907, false, $$c((byte) 0, 0, (byte) 0), new Class[]{Integer.TYPE});
                            }
                            Long l = (Long) ((Method) objComponent5).invoke(null, objArr3);
                            l.longValue();
                            Object[] objArr4 = {l, Long.valueOf(i8), Long.valueOf(vD14832N6715), Integer.valueOf(c)};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.green(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 5057, 2120479290, false, $$c((byte) 0, 0, (byte) 1), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i8] = ((Long) ((Method) objComponent6).invoke(null, objArr4)).longValue();
                            Object[] objArr5 = {ckVar, ckVar};
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                            if (objComponent7 == null) {
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), ImageFormat.getBitsPerPixel(0) + 2465, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent7).invoke(null, objArr5);
                            int i9 = $11 + 123;
                            $10 = i9 % 128;
                            int i10 = i9 % 2;
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
                    char[] cArr = new char[i2];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i2) {
                        int i11 = $10 + 3;
                        $11 = i11 % 128;
                        if (i11 % i4 == 0) {
                            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                            Object[] objArr6 = new Object[i4];
                            objArr6[1] = ckVar;
                            objArr6[0] = ckVar;
                            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                            if (objComponent8 == null) {
                                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.getOffsetBefore("", 0), (char) KeyEvent.normalizeMetaState(0), TextUtils.getOffsetBefore("", 0) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent8).invoke(null, objArr6);
                            obj2.hashCode();
                            throw null;
                        }
                        cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                        Object[] objArr7 = new Object[i4];
                        objArr7[1] = ckVar;
                        objArr7[0] = ckVar;
                        Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                        if (objComponent9 == null) {
                            objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(KeyEvent.getDeadChar(0, 0) + 51, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.lastIndexOf("", '0') + 2465, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent9).invoke(null, objArr7);
                        int i12 = $10 + 3;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                        i4 = i4;
                    }
                    objArr2[0] = new String(cArr);
                }

                public static void component9(long j, long j2) throws Throwable {
                    long j3;
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904 + 1;
                    $component5 = i3 % 128;
                    if (i3 % 2 != 0) {
                        j3 = j | (j2 << 125);
                        u.class.getField("vD14832N6715").get(null);
                    } else {
                        j3 = j ^ (j2 << 32);
                        u.class.getField("vD14832N6715").get(null);
                    }
                    int i4 = $setPivotYN16904 + 79;
                    $component5 = i4 % 128;
                    int i5 = i4 % 2;
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a(7 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22018 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), Color.alpha(0), objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj2 = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj2, null);
                        Object[] objArr4 = new Object[1];
                        a((ViewConfiguration.getJumpTapTimeout() >> 16) + 3, (char) ExpandableListView.getPackedPositionGroup(0L), TextUtils.lastIndexOf("", '0', 0) + 8, objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a(ExpandableListView.getPackedPositionChild(0L) + 4, (char) TextUtils.getTrimmedLength(""), 11 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr6);
                        Method method3 = Map.class.getMethod((String) objArr6[0], Object.class, Object.class);
                        method3.setAccessible(true);
                        method3.invoke(objInvoke2, objArr5);
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
                    $component5 = 0;
                    $setPivotYN16904 = 1;
                    D8871 = new char[]{2188, 58785, 53986, 53025, 48247, 43671, 34752, 24266, 46070, 33974, 24203, 46004, 34043};
                    vD14832N6715 = -100128142252461119L;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ImageFormat.getBitsPerPixel(0) + 1), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = D8871;
                int i3 = (i2 ^ 61) + ((i2 & 61) << 1);
                setPivotYN16904 = i3 % 128;
                if (i3 % 2 != 0) {
                    obj.hashCode();
                    throw null;
                }
                objInvoke = "";
            } else {
                int i4 = setPivotYN16904;
                int i5 = ((i4 | 121) << 1) - (i4 ^ 121);
                D8871 = i5 % 128;
                int i6 = i5 % 2;
            }
            return (String) objInvoke;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.T9586V28869$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "D8871", "()Ljava/lang/String;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<String> {
        private static int $D8871 = 0;
        private static int $setPivotYN16904 = 1;
        public static int component5;
        public static int vD14832N6715;

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ String invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            int i = 2 % 2;
            int i2 = $D8871;
            int i3 = ((i2 | 107) << 1) - (i2 ^ 107);
            $setPivotYN16904 = i3 % 128;
            int i4 = i3 % 2;
            String strD8871 = D8871();
            if (i4 == 0) {
                int i5 = 87 / 0;
            }
            int i6 = $D8871;
            int i7 = (i6 & 47) + (i6 | 47);
            $setPivotYN16904 = i7 % 128;
            int i8 = i7 % 2;
            return strD8871;
        }

        public final String D8871() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            int i = 2 % 2;
            int i2 = $setPivotYN16904;
            int i3 = (i2 & 21) + (i2 | 21);
            $D8871 = i3 % 128;
            int i4 = i3 % 2;
            String strValueOf = String.valueOf(((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(T9586V28869.D8871(T9586V28869.this)), null)).doubleValue());
            int i5 = $setPivotYN16904;
            int i6 = ((i5 | 31) << 1) - (i5 ^ 31);
            $D8871 = i6 % 128;
            int i7 = i6 % 2;
            return strValueOf;
        }

        public static int component9() {
            int i = vD14832N6715;
            int i2 = i % 5312797;
            vD14832N6715 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iMyUid = Process.myUid();
            component5 = iMyUid;
            return iMyUid;
        }

        AnonymousClass1() {
            super(0);
        }
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        int iIntValue = ((Number) objArr[0]).intValue();
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = ((i2 | 91) << 1) - (i2 ^ 91);
        int i4 = i3 % 128;
        D8871 = i4;
        Object obj = null;
        if (i3 % 2 == 0) {
            obj.hashCode();
            throw null;
        }
        switch (iIntValue) {
            case 2:
                int i5 = ((i4 | 85) << 1) - (i4 ^ 85);
                setPivotYN16904 = i5 % 128;
                int i6 = i5 % 2;
                return "good";
            case 3:
                return "overheat";
            case 4:
                int i7 = i2 + 111;
                D8871 = i7 % 128;
                if (i7 % 2 != 0) {
                    return "dead";
                }
                throw null;
            case 5:
                int i8 = i2 + 73;
                D8871 = i8 % 128;
                int i9 = i8 % 2;
                return "over voltage";
            case 6:
                return "unspecified failure";
            case 7:
                int i10 = i4 + 41;
                setPivotYN16904 = i10 % 128;
                int i11 = i10 % 2;
                return "cold";
            default:
                int i12 = (i4 ^ 79) + ((i4 & 79) << 1);
                setPivotYN16904 = i12 % 128;
                if (i12 % 2 == 0) {
                    return "unknown";
                }
                int i13 = 3 / 0;
                return "unknown";
        }
    }

    private static String component9(int i) {
        Object[] objArr = {Integer.valueOf(i)};
        int iD8871 = az.Companion.D8871();
        return (String) setPivotYN16904(-599619672, az.Companion.D8871(), az.Companion.D8871(), 599619672, objArr, iD8871, az.Companion.D8871());
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.fQ24217
    public final String component5() {
        int iD8871 = az.Companion.D8871();
        int iD8872 = az.Companion.D8871();
        return (String) setPivotYN16904(792410135, az.Companion.D8871(), iD8872, -792410134, new Object[]{this}, iD8871, az.Companion.D8871());
    }
}
