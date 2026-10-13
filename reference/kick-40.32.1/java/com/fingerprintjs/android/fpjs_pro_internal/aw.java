package com.fingerprintjs.android.fpjs_pro_internal;

import android.location.Location;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class aw {
    private static final byte[] $$a = {88, -34, 78, -63, -35, -21, -26, -22, -22, -14, -32, -29, 36};
    private static final int $$b = 9;
    public static int component5;
    public static int setPivotYN16904;

    private static void a(byte b, byte b2, int i, Object[] objArr) {
        int i2 = 99 - (i * 2);
        byte[] bArr = $$a;
        int i3 = 3 - (b2 * 3);
        int i4 = b * 4;
        byte[] bArr2 = new byte[i4 + 10];
        int i5 = i4 + 9;
        int i6 = -1;
        if (bArr == null) {
            i2 = (i2 + (-i5)) - 23;
        }
        while (true) {
            i3++;
            i6++;
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (i2 + (-bArr[i3])) - 23;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.aw$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "component5$388e5a50", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function1<Object, Boolean> {
        public static int D8871;
        public static int setPivotYN16904;
        private /* synthetic */ Location $component9;

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: component5$388e5a50, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            boolean zIsMock;
            int i = Build.VERSION.SDK_INT;
            Location location = this.$component9;
            if (i < 31) {
                zIsMock = location.isFromMockProvider();
            } else {
                zIsMock = location.isMock();
            }
            return Boolean.valueOf(zIsMock);
        }

        public static int setPivotYN16904() {
            int i = D8871;
            int i2 = i % 6261048;
            D8871 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int iNextInt = new Random().nextInt();
            setPivotYN16904 = iNextInt;
            return iNextInt;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Location location) {
            super(1);
            this.$component9 = location;
        }
    }

    public static final boolean component9(Location location) throws Throwable {
        try {
            Object[] objArr = {0L, false, false, new AnonymousClass4(location), 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int i = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 50;
                char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                int i2 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1076;
                Object[] objArr2 = new Object[1];
                a((byte) 0, (byte) 0, 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i, mirror, i2, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            return ((Boolean) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), Boolean.FALSE)).booleanValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int D8871() {
        int i = setPivotYN16904;
        int i2 = i % 7611437;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyTid = Process.myTid();
        component5 = iMyTid;
        return iMyTid;
    }
}
