package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import java.util.zip.DeflaterInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class br implements bt, bu {
    private static final byte[] $$a = {35, 2, -25, -2, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
    private static final int $$b = 123;
    public static int D8871;
    public static int setPivotYN16904;

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 2
            int r5 = r5 + 4
            int r6 = r6 * 2
            int r0 = 10 - r6
            int r7 = r7 * 3
            int r7 = r7 + 99
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.br.$$a
            byte[] r0 = new byte[r0]
            int r6 = 9 - r6
            r2 = 0
            if (r1 != 0) goto L19
            r7 = r5
            r4 = r6
            r3 = r2
            goto L2e
        L19:
            r3 = r7
            r7 = r5
            r5 = r3
            r3 = r2
        L1d:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L2a:
            int r3 = r3 + 1
            r4 = r1[r7]
        L2e:
            int r5 = r5 + r4
            int r5 = r5 + (-25)
            int r7 = r7 + 1
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.br.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.br$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "D8871", "()[B"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<byte[]> {
        public static int D8871;
        public static int component5;
        private /* synthetic */ byte[] $setPivotYN16904;

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
        public final byte[] invoke() {
            DeflaterInputStream deflaterInputStream = new DeflaterInputStream(new ByteArrayInputStream(this.$setPivotYN16904), new Deflater(-1, true));
            try {
                byte[] bytes = ByteStreamsKt.readBytes(deflaterInputStream);
                CloseableKt.closeFinally(deflaterInputStream, null);
                return bytes;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(deflaterInputStream, th);
                    throw th2;
                }
            }
        }

        public static int component9() {
            int i = D8871;
            int i2 = i % 5195122;
            D8871 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iMyPid = Process.myPid();
            component5 = iMyPid;
            return iMyPid;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(byte[] bArr) {
            super(0);
            this.$setPivotYN16904 = bArr;
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bu
    public final D8871<byte[], Throwable> vD14832N6715(byte[] bArr) throws Throwable {
        try {
            Object[] objArr = {0L, new AnonymousClass2(bArr), 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int pressedStateDuration = 51 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char cMyTid = (char) (Process.myTid() >> 22);
                int scrollDefaultDelay = 1077 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                Object[] objArr2 = new Object[1];
                a(0, (byte) 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(pressedStateDuration, cMyTid, scrollDefaultDelay, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            return (D8871) ((Method) objComponent5).invoke(null, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bt
    public final D8871<byte[], Throwable> component5(final byte[] bArr) throws Throwable {
        try {
            Object[] objArr = {0L, new Function0<byte[]>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.br.5
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $setTopP6481;
                private static long component9;
                private static char[] setPivotYN16904;
                private static long vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0024  */
                /* JADX WARN: Code duplicated, block: B:8:0x001e  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(int r6, byte r7, int r8) {
                    /*
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.br.AnonymousClass5.$$a
                        int r7 = r7 * 2
                        int r7 = 3 - r7
                        int r6 = 114 - r6
                        int r8 = r8 * 2
                        int r1 = 1 - r8
                        byte[] r1 = new byte[r1]
                        r2 = 0
                        int r8 = 0 - r8
                        r3 = r7
                        if (r0 != 0) goto L16
                        r4 = r2
                        goto L2f
                    L16:
                        r7 = r6
                        r6 = r3
                        r3 = r2
                    L19:
                        byte r4 = (byte) r7
                        r1[r3] = r4
                        if (r3 != r8) goto L24
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        return r6
                    L24:
                        int r3 = r3 + 1
                        int r6 = r6 + 1
                        r4 = r0[r6]
                        r5 = r7
                        r7 = r6
                        r6 = r4
                        r4 = r3
                        r3 = r5
                    L2f:
                        int r6 = -r6
                        int r6 = r6 + r3
                        r3 = r7
                        r7 = r6
                        r6 = r3
                        r3 = r4
                        goto L19
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.br.AnonymousClass5.$$c(int, byte, int):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{46, -53, -128, -96};
                    $$b = 60;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ byte[] invoke() {
                    int i = 2 % 2;
                    int i2 = $setTopP6481 + 59;
                    $D8871 = i2 % 128;
                    if (i2 % 2 == 0) {
                        return setPivotYN16904();
                    }
                    setPivotYN16904();
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                public final byte[] setPivotYN16904() {
                    int i = 2 % 2;
                    InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr), new Inflater(true));
                    try {
                        byte[] bytes = ByteStreamsKt.readBytes(inflaterInputStream);
                        CloseableKt.closeFinally(inflaterInputStream, null);
                        int i2 = $D8871 + 91;
                        $setTopP6481 = i2 % 128;
                        int i3 = i2 % 2;
                        return bytes;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inflaterInputStream, th);
                            throw th2;
                        }
                    }
                }

                private static void b(String str, int i, Object[] objArr2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $10 + 77;
                    $11 = i3 % 128;
                    if (i3 % 2 == 0) {
                        throw null;
                    }
                    char[] charArray = str != null ? str.toCharArray() : str;
                    cl clVar = new cl();
                    char[] pivotYN16904 = cl.setPivotYN16904(component9 ^ (-8731904840774042312L), charArray, i);
                    clVar.vD14832N6715 = 4;
                    int i4 = $11 + 13;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    while (clVar.vD14832N6715 < pivotYN16904.length) {
                        clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
                        int i6 = clVar.vD14832N6715;
                        try {
                            Object[] objArr3 = {Long.valueOf(pivotYN16904[clVar.vD14832N6715] ^ pivotYN16904[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(component9)};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(353813021);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 51, (char) (KeyEvent.getDeadChar(0, 0) + 43652), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 752, 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                            }
                            pivotYN16904[i6] = ((Character) ((Method) objComponent5).invoke(null, objArr3)).charValue();
                            Object[] objArr4 = {clVar, clVar};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (Process.myPid() >> 22), (char) (TextUtils.lastIndexOf("", '0', 0) + 1), ExpandableListView.getPackedPositionChild(0L) + 5421, 257882757, false, $$c(0, (byte) 0, 0), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent6).invoke(null, objArr4);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    objArr2[0] = new String(pivotYN16904, 4, pivotYN16904.length - 4);
                }

                private static void a(char c, int i, int i2, Object[] objArr2) throws Throwable {
                    int i3;
                    int i4 = 2 % 2;
                    ck ckVar = new ck();
                    long[] jArr = new long[i2];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i2) {
                        int i5 = $11 + 115;
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        int i7 = ckVar.setPivotYN16904;
                        try {
                            Object[] objArr3 = {Integer.valueOf(setPivotYN16904[i + i7])};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                            if (objComponent5 == null) {
                                i3 = -720328195;
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), 5905 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), -173582907, false, $$c(13, (byte) 0, 0), new Class[]{Integer.TYPE});
                            } else {
                                i3 = -720328195;
                            }
                            Long l = (Long) ((Method) objComponent5).invoke(null, objArr3);
                            l.longValue();
                            Object[] objArr4 = {l, Long.valueOf(i7), Long.valueOf(vD14832N6715), Integer.valueOf(c)};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 51, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), TextUtils.indexOf("", "", 0, 0) + 5058, 2120479290, false, $$c((byte) ($$b & 80), (byte) 0, 0), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i7] = ((Long) ((Method) objComponent6).invoke(null, objArr4)).longValue();
                            Object[] objArr5 = {ckVar, ckVar};
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i3);
                            if (objComponent7 == null) {
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getTapTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0), 2464 - (ViewConfiguration.getKeyRepeatDelay() >> 16), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent7).invoke(null, objArr5);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char[] cArr = new char[i2];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i2) {
                        cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                        Object[] objArr6 = {ckVar, ckVar};
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                        if (objComponent8 == null) {
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent8).invoke(null, objArr6);
                        int i8 = $10 + 49;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                    }
                    objArr2[0] = new String(cArr);
                }

                static {
                    init$0();
                    $10 = 0;
                    $11 = 1;
                    $D8871 = 0;
                    $setTopP6481 = 1;
                    setPivotYN16904 = new char[]{24209, 7333, 56051, 38951, 22143, 5614, 54258, 37159, 20320, 2745, 51455, 34343, 17531, 945, 49575, 48939, 32126, 14496, 63229, 46200, 29295, 12773, 61345, 44386, 27453, 9860, 58536, 41582, 24623, 57224, 40427, 23347, 6517, 54407, 37580, 20502, 3654, 52620, 26105, 10187, 57849, 41798, 27944, 12005, 59570, 43628, 29739, 12777, 62444, 48459, 32555, 14571, 64189, 33900, 18022, 986, 52713, 36694, 18744, 2805, 54434, 38524, 20539, 7673, 57328, 39260, 23395, 58572, 42635, 24248, 7417, 56016, 38933, 22059, 5519, 54204, 37123, 20333, 2728, 51455, 34337, 17510, 940, 49573, 48905, 32069, 14569, 63188, 46136, 29299, 12706, 61438, 44347, 27511, 9980, 58585, 41531, 24701, 57261, 40446, 46043, 61926, 14262, 30033, 47905, 63716, 16045, 31844, 41507, 59374, 9607, 27496, 43302, 61166, 11433, 21096, 36926, 24220, 7329, 56049, 38934, 22118, 5539, 54250, 37155, 20324, 2729, 51395, 34351, 17506, 941, 18640, 2784, 52395, 36478, 16418, 995, 50607, 34598, 22826, 7401, 57001, 36976, 21024, 5612, 55223, 43310, 27441, 12019, 57585, 41548, 25660, 10233, 63920, 47993, 32062, 12531, 62106, 46197, 30267, 51699, 35764, 19829, 3875, 19133, 2185, 52959, 35851, 16901, 415, 51144, 34061, 23386, 7826, 56520, 37398, 20570, 6090, 54726, 43779, 26965, 11404, 58007, 41017, 26206, 9614, 64457, 47383, 32601, 12953, 61650, 46611, 29767, 52113, 35315, 20247, 3412, 49340, 34534, 17464, 6770, 14896, 30733, 48733, 64675, 12997, 28959, 46937, 62863, 11201, 28163, 44100, 4936, 20844, 38656, 54776, 7092, 22626, 40455, 56567, 694, 18282, 34099, 31838, 15978, 63548, 47848, 29926, 14204, 61739, 46062, 28089, 10353, 59947, 42229, 26297, 8489, 58149, 40416, 24502, 6767, 54388, 38593, 20717, 4911, 52583, 36830, 18873, 1121, 50726, 33016, 17078, 64894, 48949, 31220, 15264, 63054};
                    vD14832N6715 = 2342845674313686212L;
                    component9 = 8246331205092014904L;
                }

                /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                    java.util.NoSuchElementException
                    	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
                    	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                    	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                    */
                public static java.lang.Object[] vD14832N6715(android.content.Context r32, int r33, int r34) {
                    /*
                        Method dump skipped, instruction units count: 2659
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.br.AnonymousClass5.vD14832N6715(android.content.Context, int, int):java.lang.Object[]");
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int scrollDefaultDelay = 51 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1077;
                Object[] objArr2 = new Object[1];
                a(0, (byte) 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollDefaultDelay, packedPositionGroup, i, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            return (D8871) ((Method) objComponent5).invoke(null, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int component5() {
        int i = D8871;
        int i2 = i % 8923001;
        D8871 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int iMyTid = Process.myTid();
        setPivotYN16904 = iMyTid;
        return iMyTid;
    }
}
