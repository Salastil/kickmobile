package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/yY18494;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/Integer;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class yY18494 extends wX26196 {
    private static int component5 = 1;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715;

    private yY18494(Integer num, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component11.INSTANCE.component5(), num, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.yY18494$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¨\u0006\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/AutomaticTimezoneSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/AutomaticTimezoneSignal;", "result", "Lcom/cloned/github/michaelbull/result/Result;", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/AutomaticTimezoneResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static short[] D8871;
        private static int component13;
        private static int component5;
        private static int component8;
        private static byte[] component9;
        private static int setPivotYN16904;
        private static int vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r5, byte r6, short r7) {
            /*
                int r6 = r6 * 3
                int r6 = 4 - r6
                int r7 = 111 - r7
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.yY18494.Companion.$$a
                int r5 = r5 * 2
                int r1 = r5 + 1
                byte[] r1 = new byte[r1]
                r2 = -1
                if (r0 != 0) goto L14
                r3 = r7
                r7 = r6
                goto L27
            L14:
                r4 = r7
                r7 = r6
                r6 = r4
            L17:
                int r2 = r2 + 1
                byte r3 = (byte) r6
                r1[r2] = r3
                if (r2 != r5) goto L25
                java.lang.String r5 = new java.lang.String
                r6 = 0
                r5.<init>(r1, r6)
                return r5
            L25:
                r3 = r0[r7]
            L27:
                int r3 = -r3
                int r6 = r6 + r3
                int r7 = r7 + 1
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.yY18494.Companion.$$c(int, byte, short):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{58, -40, 114, 119};
            $$b = 138;
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static yY18494 component5(D8871<Integer, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = component8 + 7;
            component13 = i2 % 128;
            int i3 = i2 % 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (d8871 instanceof vD14832N6715) {
                return new yY18494(Integer.valueOf(((Number) ((vD14832N6715) d8871).setPivotYN16904).intValue()), wX26196.setPivotYN16904.component13.INSTANCE, defaultConstructorMarker);
            }
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            yY18494 yy18494 = new yY18494(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            int i4 = component13 + 115;
            component8 = i4 % 128;
            int i5 = i4 % 2;
            return yy18494;
        }

        /* JADX WARN: Failed to calculate best type for var: r17v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
         */
        /* JADX WARN: Failed to calculate best type for var: r17v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 ??, new type: long
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
        /* JADX WARN: Failed to calculate best type for var: r17v1 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v1 ??, new type: long
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
            jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 ??, new type: long
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
            Caused by: java.lang.NullPointerException
            */
        private static void a(byte r29, int r30, short r31, int r32, int r33, java.lang.Object[] r34) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 752
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.yY18494.Companion.a(byte, int, short, int, int, java.lang.Object[]):void");
        }

        public static void vD14832N6715(long j, long j2) throws Throwable {
            int i = 2 % 2;
            int i2 = component13 + 113;
            component8 = i2 % 128;
            int i3 = i2 % 2;
            long j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
            int i4 = component13 + 27;
            component8 = i4 % 128;
            int i5 = i4 % 2;
            try {
                Object[] objArr = {Long.valueOf(j3)};
                Object[] objArr2 = new Object[1];
                a((byte) ((-1) - ImageFormat.getBitsPerPixel(0)), (-311246073) + (ViewConfiguration.getWindowTouchSlop() >> 8), (short) ((-32) - (KeyEvent.getMaxKeyCode() >> 16)), 1010351477 + Color.alpha(0), (-91) - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr2);
                Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, objArr);
                Object obj = w.class.getField("INSTANCE").get(null);
                Method method2 = w.class.getMethod("D8871", null);
                method2.setAccessible(true);
                Object objInvoke2 = method2.invoke(obj, null);
                Object[] objArr3 = new Object[1];
                a((byte) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (-311246142) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (short) ((-73) - Process.getGidForName("")), 1010351484 + TextUtils.indexOf("", ""), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 92, objArr3);
                Object[] objArr4 = {(String) objArr3[0], objInvoke};
                Object[] objArr5 = new Object[1];
                a((byte) View.MeasureSpec.makeMeasureSpec(0, 0), (-311246079) - (ViewConfiguration.getPressedStateDuration() >> 16), (short) ((ViewConfiguration.getTouchSlop() >> 8) + 27), 1010351488 + Process.getGidForName(""), (-91) - KeyEvent.keyCodeFromString(""), objArr5);
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
            component13 = 1;
            vD14832N6715 = 1074880662;
            component5 = -2083118521;
            setPivotYN16904 = -1856299150;
            component9 = new byte[]{-80, 42, Ascii.ETB, Ascii.CR, 52, 54, Ascii.SYN, -76, 95, 83, -76, -7, -9};
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = vD14832N6715 + 7;
        component5 = i % 128;
        int i2 = i % 2;
    }

    public /* synthetic */ yY18494(Integer num, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, setpivotyn16904);
    }
}
