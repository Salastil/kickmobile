package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB'\b\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setOnReceiveContentListener;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/Map;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class setOnReceiveContentListener extends wX26196 {
    private static int component5 = 0;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715 = 1;

    private setOnReceiveContentListener(Map<String, String> map, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.getKeepScreenOn.INSTANCE.component5(), map, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n¨\u0006\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SystemPropertiesSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SystemPropertiesSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/system_properties/SystemProperty;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/system_properties/SystemPropertiesResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static final byte[] $$c = null;
        private static final int $$d = 0;
        private static int $10;
        private static int $11;
        private static int D8871;
        private static int N14263A23323;
        private static short[] component13;
        private static int component5;
        private static int component9;
        private static int sG29839;
        private static char[] setPivotYN16904;
        private static byte[] setTopP6481;
        private static long vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, byte r7, byte r8) {
            /*
                int r7 = r7 + 4
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener.Companion.$$c
                int r6 = r6 + 98
                int r8 = r8 * 4
                int r8 = r8 + 1
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r6
                r6 = r8
                r5 = r2
                goto L25
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r6
                int r5 = r3 + 1
                r1[r3] = r4
                int r7 = r7 + 1
                if (r5 != r8) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L23:
                r3 = r0[r7]
            L25:
                int r6 = r6 + r3
                r3 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener.Companion.$$e(short, byte, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r5, short r6, int r7, java.lang.Object[] r8) {
            /*
                int r5 = r5 + 4
                int r6 = r6 * 3
                int r6 = 4 - r6
                int r7 = r7 + 97
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener.Companion.$$a
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L12
                r4 = r6
                r3 = r2
                goto L26
            L12:
                r3 = r2
            L13:
                int r5 = r5 + 1
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r6) goto L24
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L24:
                r4 = r0[r5]
            L26:
                int r4 = -r4
                int r7 = r7 + r4
                int r7 = r7 + 6
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener.Companion.a(byte, short, int, java.lang.Object[]):void");
        }

        static void init$0() {
            $$a = new byte[]{Ascii.DC4, -36, -83, 73, -6, 5, -3};
            $$b = 243;
        }

        static void init$1() {
            $$c = new byte[]{70, 75, -118, 8};
            $$d = 237;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static setOnReceiveContentListener setPivotYN16904(D8871<? extends List<y>, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = sG29839 + 17;
            N14263A23323 = i2 % 128;
            Object obj = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i2 % 2 == 0) {
                boolean z = d8871 instanceof vD14832N6715;
                obj.hashCode();
                throw null;
            }
            if (!(d8871 instanceof vD14832N6715)) {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                setOnReceiveContentListener setonreceivecontentlistener = new setOnReceiveContentListener(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
                c.component9();
                c.component9();
                return setonreceivecontentlistener;
            }
            List list = (List) ((vD14832N6715) d8871).setPivotYN16904;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            Iterator it = list.iterator();
            int i3 = N14263A23323;
            int i4 = (i3 & 17) + (i3 | 17);
            sG29839 = i4 % 128;
            int i5 = i4 % 2;
            while (it.hasNext()) {
                int i6 = sG29839;
                int i7 = ((i6 | 93) << 1) - (i6 ^ 93);
                N14263A23323 = i7 % 128;
                if (i7 % 2 == 0) {
                    y yVar = (y) it.next();
                    Pair pair = TuplesKt.to(yVar.D8871(), (String) y.component5(new Object[]{yVar}, 1948914066, wX26196.component8(), wX26196.component8(), wX26196.component8(), wX26196.component8(), -1948914066));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    throw null;
                }
                y yVar2 = (y) it.next();
                Pair pair2 = TuplesKt.to(yVar2.D8871(), (String) y.component5(new Object[]{yVar2}, 1948914066, wX26196.component8(), wX26196.component8(), wX26196.component8(), wX26196.component8(), -1948914066));
                linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
            }
            return new setOnReceiveContentListener(linkedHashMap, wX26196.setPivotYN16904.component13.INSTANCE, objArr3 == true ? 1 : 0);
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
            char c2;
            int i3 = 2 % 2;
            ck ckVar = new ck();
            long[] jArr = new long[i2];
            ckVar.setPivotYN16904 = 0;
            int i4 = $10 + 51;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            while (ckVar.setPivotYN16904 < i2) {
                int i6 = $10 + 55;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    int i7 = ckVar.setPivotYN16904;
                    try {
                        Object[] objArr2 = {Integer.valueOf(setPivotYN16904[i - i7])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                        if (objComponent5 == null) {
                            c2 = 1;
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 51, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 5905, -173582907, false, $$e((short) 3, (byte) -1, (byte) 0), new Class[]{Integer.TYPE});
                        } else {
                            c2 = 1;
                        }
                        Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                        l.longValue();
                        long j = i7;
                        long j2 = vD14832N6715;
                        Object[] objArr3 = new Object[4];
                        objArr3[3] = Integer.valueOf(c);
                        objArr3[2] = Long.valueOf(j2);
                        objArr3[c2] = Long.valueOf(j);
                        objArr3[0] = l;
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16), KeyEvent.getDeadChar(0, 0) + 5058, 2120479290, false, $$e((short) 0, (byte) -1, (byte) 0), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i7] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = new Object[2];
                        objArr4[c2] = ckVar;
                        objArr4[0] = ckVar;
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(KeyEvent.getDeadChar(0, 0) + 51, (char) Color.blue(0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 2465, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent7).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    int i8 = ckVar.setPivotYN16904;
                    Object[] objArr5 = {Integer.valueOf(setPivotYN16904[i + i8])};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getEdgeSlop() >> 16) + 51, (char) Color.red(0), MotionEvent.axisFromString("") + 5905, -173582907, false, $$e((short) 3, (byte) -1, (byte) 0), new Class[]{Integer.TYPE});
                    }
                    Long l2 = (Long) ((Method) objComponent8).invoke(null, objArr5);
                    l2.longValue();
                    Object[] objArr6 = {l2, Long.valueOf(i8), Long.valueOf(vD14832N6715), Integer.valueOf(c)};
                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(752268889);
                    if (objComponent9 == null) {
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionChild(0L) + 53, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 5058, 2120479290, false, $$e((short) 0, (byte) -1, (byte) 0), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i8] = ((Long) ((Method) objComponent9).invoke(null, objArr6)).longValue();
                    Object[] objArr7 = {ckVar, ckVar};
                    Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                    if (objComponent10 == null) {
                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf((CharSequence) "", '0') + 52, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.getCapsMode("", 0, 0) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent10).invoke(null, objArr7);
                }
            }
            char[] cArr = new char[i2];
            ckVar.setPivotYN16904 = 0;
            while (ckVar.setPivotYN16904 < i2) {
                cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                Object[] objArr8 = {ckVar, ckVar};
                Object objComponent11 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                if (objComponent11 == null) {
                    objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getPressedStateDuration() >> 16) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent11).invoke(null, objArr8);
                int i9 = $10 + 103;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 2 / 4;
                }
            }
            objArr[0] = new String(cArr);
        }

        private static void c(byte b, int i, int i2, short s, int i3, Object[] objArr) throws Throwable {
            long j;
            boolean z;
            int i4 = 2 % 2;
            ch chVar = new ch();
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(component9)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(572769811);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) (View.MeasureSpec.getSize(0) + 58885), 6886 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 1888911984, false, $$e((byte) ($$d & 31), (byte) -1, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                int i5 = iIntValue == -1 ? 1 : 0;
                if (i5 != 0) {
                    byte[] bArr = setTopP6481;
                    float f = 0.0f;
                    if (bArr != null) {
                        int length = bArr.length;
                        byte[] bArr2 = new byte[length];
                        int i6 = 0;
                        while (i6 < length) {
                            Object[] objArr3 = {Integer.valueOf(bArr[i6])};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(((Process.getThreadPriority(0) + 20) >> 6) + 58, (char) (TypedValue.complexToFloat(0) > f ? 1 : (TypedValue.complexToFloat(0) == f ? 0 : -1)), 1539 - (ViewConfiguration.getPressedStateDuration() >> 16), -899819233, false, "l", new Class[]{Integer.TYPE});
                            }
                            bArr2[i6] = ((Byte) ((Method) objComponent6).invoke(null, objArr3)).byteValue();
                            i6++;
                            f = f;
                        }
                        bArr = bArr2;
                    }
                    float f2 = f;
                    j = -7710232700957351395L;
                    if (bArr != null) {
                        int i7 = $11 + 103;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
                        byte[] bArr3 = setTopP6481;
                        Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(D8871)};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(572769811);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((AudioTrack.getMaxVolume() > f2 ? 1 : (AudioTrack.getMaxVolume() == f2 ? 0 : -1)) + 58884), TextUtils.getCapsMode("", 0, 0) + 6886, 1888911984, false, $$e((byte) ($$d & 31), (byte) -1, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue()]) ^ (-7710232700957351395L))) + ((int) (((long) component9) ^ (-7710232700957351395L))));
                    } else {
                        iIntValue = (short) (((short) (((long) component13[i3 + ((int) (((long) D8871) ^ (-7710232700957351395L)))]) ^ (-7710232700957351395L))) + ((int) (((long) component9) ^ (-7710232700957351395L))));
                    }
                } else {
                    j = -7710232700957351395L;
                }
                if (iIntValue > 0) {
                    chVar.D8871 = ((i3 + iIntValue) - 2) + ((int) (((long) D8871) ^ j)) + i5;
                    Object[] objArr5 = {chVar, Integer.valueOf(i), Integer.valueOf(component5), sb};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(74627481);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) TextUtils.getCapsMode("", 0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 4725, 1455947258, false, $$e((byte) ($$d & 30), (byte) -1, (byte) 0), new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objComponent8).invoke(null, objArr5)).append(chVar.vD14832N6715);
                    chVar.component9 = chVar.vD14832N6715;
                    byte[] bArr4 = setTopP6481;
                    if (bArr4 != null) {
                        int length2 = bArr4.length;
                        byte[] bArr5 = new byte[length2];
                        int i9 = 0;
                        while (i9 < length2) {
                            int i10 = $10 + 31;
                            int i11 = i10 % 128;
                            $11 = i11;
                            int i12 = i10 % 2;
                            bArr5[i9] = (byte) (((long) bArr4[i9]) ^ j);
                            i9++;
                            int i13 = i11 + 83;
                            $10 = i13 % 128;
                            int i14 = i13 % 2;
                        }
                        bArr4 = bArr5;
                    }
                    if (bArr4 != null) {
                        int i15 = $11 + 21;
                        $10 = i15 % 128;
                        int i16 = i15 % 2;
                        z = true;
                    } else {
                        z = false;
                    }
                    chVar.setPivotYN16904 = 1;
                    while (chVar.setPivotYN16904 < iIntValue) {
                        if (z) {
                            byte[] bArr6 = setTopP6481;
                            int i17 = chVar.D8871;
                            chVar.D8871 = i17 - 1;
                            chVar.vD14832N6715 = (char) (chVar.component9 + (((byte) (((byte) (((long) bArr6[i17]) ^ j)) + s)) ^ b));
                        } else {
                            short[] sArr = component13;
                            int i18 = chVar.D8871;
                            chVar.D8871 = i18 - 1;
                            chVar.vD14832N6715 = (char) (chVar.component9 + (((short) (((short) (((long) sArr[i18]) ^ j)) + s)) ^ b));
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

        static {
            init$1();
            $10 = 0;
            $11 = 1;
            init$0();
            sG29839 = 0;
            N14263A23323 = 1;
            setPivotYN16904 = new char[]{24201, 59734, 12625, 31189, 33170, 51267, 4115, 22722, 57482, 11099, 29450, 44374, 6791, 49870, 35329, 29252, 15259, 24201, 59734, 12625, 31181, 33153, 51294, 4115, 22720, 57480, 11101, 29505, 48094, 50074, 2642, 21011, 39616, 8886, 27959, 46386, 65020, 1469, 19556, 37937, 56564, 25768, 44925, 63290, 16383, 18342, 36467, 24201, 59734, 12625, 31193, 33174, 51283, 4098, 22738, 57484, 11080, 29453, 48065, 50054, 24266, 8981, 38106, 19604, 1113, 64536, 46559, 24210, 59735, 12566, 31177, 33246, 51285, 4114, 22743, 57502, 11086, 29505, 48095, 50048, 10571, 40591, 18130, 3595, 63066, 10376, 40777, 18183, 4050, 63369, 48732, 26139, 11971, 38535, 23874, 1374, 52673, 46472, 31839, 9226, 60622, 55608, 28409, 46775, 65126, 1597, 20473, 38844, 57140, 26422, 44261, 24203, 59723, 12560, 31198, 33153, 51280, 4121, 22750, 24203, 59723, 12560, 31195, 33168, 51294, 4123, 22745, 57486, 11082, 29467, 48073, 24203, 59723, 12560, 31195, 33168, 51294, 4123, 22745, 57486, 11082, 29467, 48078, 50071, 2637, 32351, 51594, 4548, 22788, 41296, 59529, 12501, 48587, 2571, 53840, 39575, 25284, 11031, 62215, 34417, 12723, 24206, 59735, 12552, 31188, 33181, 51285, 4136, 22748, 57477, 11087, 29440, 45660, 1413, 56794, 38150, 27983, 9351, 64762, 46100, 3136, 51094, 40927, 22288, 12125, 59008, 8939, 38261, 19769, 1521, 64952, 46187, 27685, 9381, 40118, 22399, 3902, 51133, 24276, 59722, 12550, 31182, 33244, 51287, 4100, 22682, 57496, 11084, 29443, 48068, 50061, 2644, 21023, 39562, 8894, 28023, 46393, 65010, 1441, 19570, 37938, 24276, 59721, 12557, 31186, 33168, 51230, 4100, 22736, 57479, 11087, 29504, 48094, 50071, 2624, 21011, 39632, 8872, 24276, 59722, 12550, 31182, 33159, 51284, 4122, 58954, 20948, 35224, 49488, 14617, 28874, 43140, 57348, 22551, 37854, 52127, 17807, 61969, 10845, 25237, 39644, 54031, 2881, 17345, 64451, 12304, 26717, 41112, 28153, 55911, 555, 19171, 45738, 64377, 9015, 27575, 54206, 6246, 16427, 35054, 4207, 42993, 32678, 14191, 53030, 46286, 785, 56086, 37784, 27585, 8735, 64092, 45718, 2690, 49414, 39239, 20889, 10704, 24201, 59724, 12561, 31187, 33178, 51295, 4112, 3259, 47980, 25405, 11262, 54186, 39538, 16947, 2731, 45736, 31072, 8492, 59827, 37281, 22654, '8', 51425, 28852, 16200, 59148, 45006, 22406, 7762, 50708, 24276, 59741, 12574, 31177, 33170, 51230, 4123, 22746, 57480, 11080, 29443, 48002, 58680, 21169, 35570, 49701, 14974, 29682, 44023, 58166, 23396, 37028, 51439, 'n', 30829, 45476, 59877, 8550, 24276, 59741, 12574, 31177, 33170, 51230, 4123, 22746, 57480, 11080, 29443, 48002, 50075, 2627, 21006, 39627, 8948, 55858, 28059, 46528, 64790, 1340, 19592, 54357, 25564, 48027, 62282, 2909, 17098, 39567, 53843, 27139, 41435, 63877, 27991, 55966, 719, 18970, 45595, 64411, 9168, 27421, 54090, 6337, 16637, 34819, 61527, 14722, 25024, 43271, 19030, 64915, 9664, 27921, 38233};
            vD14832N6715 = -7554461233019033287L;
            D8871 = 586455723;
            component9 = -2083118470;
            component5 = 1597639198;
            setTopP6481 = new byte[]{PSSSigner.TRAILER_IMPLICIT, -100, 99, 106, 107, -111, -108, 97, -83, PSSSigner.TRAILER_IMPLICIT, 66, 76, -80, -96, -77, 74, SignedBytes.MAX_POWER_OF_TWO, -74, PSSSigner.TRAILER_IMPLICIT, 69, -114, Ascii.VT, -96, 95, -96, 68, 76, -77, -13, Ascii.SO, 76, -88, 81, -28, 105, 89, -86, -95, 90, -96, 82, -77, 93, -95, -105, 105, 89, 95, -96, -99, Ascii.ESC, -85, 91, -91, -102, 108, 79, -81, -106, PSSSigner.TRAILER_IMPLICIT, 58, -44, 58, -52, Base64.padSymbol, 62, -61, -126, -8, 4, -8, -1, Ascii.DLE, -67, -2, 1, -2, -14, 4, 5, -65, -49, 45, -58, -49, 48, -45, 60, 63, -126, 41, Ascii.DLE, -23, 17, -29, -122, 34, -67, 43, -48, -46, 44, 35, -47, -80, 52, 59, -52, 52, -60, 58, -58, 49, 63, -59, -58, 57, -64, 42, -39, 48, 35, -33, 51, -126, 114, 114, -97, -114, 113, -122, 2, -76, -121, 120, 106, -108, 120, 63, -62, 116, -110, 104, -116, 114, -126, 116, -105, -65, -83, 74, -88, 82, 91, 91, -74, -89, -66, -109, -87, 78, -84, 86, 95, 95, -78, -93, -71, 9, 41, 39, -34, 37, -43, -38, -38, 55, 38, -75, 73, -72, 69, 74, -72, 66, -77, 83, -69, -74, 69, -78, 73, -71, -128, 86, 70, 114, -71, -51, -49, -5, 117, -53, -61, 62, -63, 39, -113, -128, 63, -33, -26, -71, 63, -56, 53, -61, 52, 50, -53, -57, 34, -36, -74, 89, -92, -82, -94, 91, -93, 76, -92, -29, 109, 75, -91, -29, Ascii.FS, -83, 93, -93, -126, -65, 123, 121, -111, 58, -73, -128, -57, 40, Ascii.FF, -60, -6, 62, 60, 8, -7, 51, -54, 58, -63, Base64.padSymbol, 127, -77, -104, -83, 87, PSSSigner.TRAILER_IMPLICIT, 85, 81, 90, -87, 101, -109, 87, 85, 97, -112, 90, -93, 83, -88, 84, Ascii.SYN, -76, -66, 122, 120, -107, 54, -76, -114, 59, -67, 119, -114, 126, -123, 121, 59, -81, 114, -52, -55, 52, -116, 0, 54, -55, 62, -120, 1, 39, -127, 116, 54, 55, -113, Ascii.VT, -63, 56, -56, 51, -49, -115, -69, -60, 0, 2, -17, 76, -57, Ascii.CR, -12, 4, -1, 3, 65, -65, -72, 124, 126, 74, -60, -122, -121, 63, PSSSigner.TRAILER_IMPLICIT, 84, -112, -110, -90, 47, -105, -47, -73, 127, -122, 121, -122, -126, -66, 73, 122, -121, 114, -60, 76, 116, 125, -126, -63, -126, -100, -92, -83, 82, 17, -67, 82, -85, 84, -85, -81, -109, -78, -115, 97, 102, 102, 100, -38, 44, -104, -100, -98, 102, -100, 105, -33, 39, -106, -84, 39, 97, -99, -33};
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
            	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] component9$6ed60776(int r57, java.lang.Object r58) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 17001
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setOnReceiveContentListener.Companion.component9$6ed60776(int, java.lang.Object):java.lang.Object[]");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = vD14832N6715;
        int i2 = (i & 55) + (i | 55);
        component5 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ setOnReceiveContentListener(Map map, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, setpivotyn16904);
    }
}
