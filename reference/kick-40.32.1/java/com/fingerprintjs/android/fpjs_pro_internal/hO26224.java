package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.fingerprintjs.android.fpjs_pro.ApiKeyNotFound;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
public final class hO26224 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int D8871;
    private static int setTopP6481;
    private final setOnLongClickListenerR17701 component5;
    private final long component9;
    private final K17305 setPivotYN16904;
    private final boolean vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = r6 + 99
            int r8 = r8 * 3
            int r8 = 4 - r8
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.hO26224.$$a
            int r7 = r7 * 2
            int r1 = 10 - r7
            byte[] r1 = new byte[r1]
            int r7 = 9 - r7
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2f
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r3 + 1
            int r8 = r8 + (-23)
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.hO26224.a(byte, int, int, java.lang.Object[]):void");
    }

    public static /* synthetic */ Object component9(int i, Object[] objArr, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i6;
        int i8 = ~i5;
        int i9 = ~(i7 | i8);
        int i10 = ~(i6 | i5);
        int i11 = i9 | i10 | (~(i6 | i3));
        int i12 = i8 | i6;
        int i13 = (~((~i3) | i6)) | i10;
        int i14 = i6 + i5 + i + (111814883 * i2) + (1975835455 * i4);
        int i15 = i14 * i14;
        int i16 = (((-1960851331) * i6) - 1583611904) + (47848387 * i5) + (i11 * (-2101222338)) + ((-92522620) * i12) + ((-2101222338) * i13) + ((-2053373952) * i) + ((-648806400) * i2) + (1432616960 * i4) + (442957824 * i15);
        int i17 = ((i6 * 961080817) - 60187382) + (i5 * 961079119) + (i11 * 566) + (i12 * (-1132)) + (i13 * 566) + (i * 961079685) + (i2 * 1618335983) + (i4 * 193609403) + (i15 * 1988296704);
        return i16 + ((i17 * i17) * 176226304) != 1 ? component5(objArr) : component9(objArr);
    }

    static void init$0() {
        $$a = new byte[]{Ascii.SO, -58, 119, -50, -35, -21, -26, -22, -22, -14, -32, -29, 36};
        $$b = 102;
    }

    public hO26224(K17305 k17305, setOnLongClickListenerR17701 setonlongclicklistenerr17701, boolean z, long j) {
        this.setPivotYN16904 = k17305;
        this.component5 = setonlongclicklistenerr17701;
        this.vD14832N6715 = z;
        this.component9 = j;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        hO26224 ho26224 = (hO26224) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = i2 + 119;
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        K17305 k17305 = ho26224.setPivotYN16904;
        int i5 = i2 + 91;
        D8871 = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 31 / 0;
        }
        return k17305;
    }

    public final D8871<N14078, Throwable> setPivotYN16904() {
        Object objM12684constructorimpl;
        N14078 n14078;
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 ^ 55) + ((i2 & 55) << 1);
        D8871 = i3 % 128;
        Location location = null;
        try {
            if (i3 % 2 != 0) {
                Result.Companion companion = Result.INSTANCE;
                this.component5.vD14832N6715().isEmpty();
                throw null;
            }
            Result.Companion companion2 = Result.INSTANCE;
            List<setOnContextClickListenerE32038> listVD14832N6715 = this.component5.vD14832N6715();
            if (listVD14832N6715.isEmpty() || !this.vD14832N6715) {
                boolean z = this.vD14832N6715;
                long j = this.component9;
                component1H27181.Companion companion3 = component1H27181.INSTANCE;
                n14078 = new N14078(null, z, listVD14832N6715, j, component1H27181.Companion.setPivotYN16904());
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Location locationVD14832N6715 = vD14832N6715(this.component9);
                if (locationVD14832N6715 != null) {
                    n14078 = new N14078(locationVD14832N6715, this.vD14832N6715, listVD14832N6715, this.component9, new component1H27181(jCurrentTimeMillis, System.currentTimeMillis()));
                    int i4 = D8871;
                    int i5 = (i4 ^ 95) + ((i4 & 95) << 1);
                    setTopP6481 = i5 % 128;
                    int i6 = i5 % 2;
                } else {
                    long jCurrentTimeMillis2 = (this.component9 + jCurrentTimeMillis) - System.currentTimeMillis();
                    if (jCurrentTimeMillis2 > 0) {
                        int i7 = D8871 + 33;
                        setTopP6481 = i7 % 128;
                        int i8 = i7 % 2;
                        location = (Location) component9(ApiKeyNotFound.D8871(), new Object[]{this, Long.valueOf(jCurrentTimeMillis2)}, ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), 439435221, -439435221);
                    }
                    n14078 = new N14078(location, this.vD14832N6715, listVD14832N6715, this.component9, new component1H27181(jCurrentTimeMillis, System.currentTimeMillis()));
                    int i9 = setTopP6481 + 27;
                    D8871 = i9 % 128;
                    int i10 = i9 % 2;
                }
            }
            objM12684constructorimpl = Result.m12684constructorimpl(new vD14832N6715(n14078));
            int i11 = D8871;
            int i12 = (i11 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i11 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
            setTopP6481 = i12 % 128;
            int i13 = i12 % 2;
            return bb.component9(bb.setPivotYN16904(objM12684constructorimpl));
        } catch (Throwable th) {
            Result.Companion companion4 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final Location vD14832N6715(final long j) throws Throwable {
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr = {Long.valueOf(j), false, false, new Function1<Object, Location>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.hO26224.3
                private static int $D8871 = 1;
                private static int $component5;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Location invoke(Object obj2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $D8871 + 71;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    Location locationComponent5$32a6898b = component5$32a6898b(obj2);
                    int i5 = $component5 + 1;
                    $D8871 = i5 % 128;
                    int i6 = i5 % 2;
                    return locationComponent5$32a6898b;
                }

                public final Location component5$32a6898b(Object obj2) throws Throwable {
                    Location locationComponent9;
                    int i2 = 2 % 2;
                    int i3 = $component5 + 27;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    hO26224 ho26224 = hO26224.this;
                    Object obj3 = null;
                    try {
                        if (i4 == 0) {
                            int iD8871 = ApiKeyNotFound.D8871();
                            locationComponent9 = ((K17305) hO26224.component9(ApiKeyNotFound.D8871(), new Object[]{ho26224}, ApiKeyNotFound.D8871(), iD8871, ApiKeyNotFound.D8871(), 1004734163, -1004734162)).component9(j);
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(870673214);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((Process.myTid() >> 22) + 52, (char) (34628 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 1437 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1632644957, false, "component5", new Class[0]);
                            }
                            ((Method) objComponent5).invoke(obj2, null);
                            int i5 = 62 / 0;
                        } else {
                            int iD8872 = ApiKeyNotFound.D8871();
                            locationComponent9 = ((K17305) hO26224.component9(ApiKeyNotFound.D8871(), new Object[]{ho26224}, ApiKeyNotFound.D8871(), iD8872, ApiKeyNotFound.D8871(), 1004734163, -1004734162)).component9(j);
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(870673214);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(Process.getGidForName("") + 53, (char) (34629 - ((Process.getThreadPriority(0) + 20) >> 6)), MotionEvent.axisFromString("") + 1437, 1632644957, false, "component5", new Class[0]);
                            }
                            ((Method) objComponent6).invoke(obj2, null);
                        }
                        int i6 = $D8871 + 75;
                        $component5 = i6 % 128;
                        if (i6 % 2 == 0) {
                            return locationComponent9;
                        }
                        obj3.hashCode();
                        throw null;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            }, 6, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int i2 = 52 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char bitsPerPixel = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                int iArgb = 1077 - Color.argb(0, 0, 0, 0);
                Object[] objArr2 = new Object[1];
                a((byte) 0, 0, 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i2, bitsPerPixel, iArgb, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            Location location = (Location) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), null);
            int i3 = setTopP6481;
            int i4 = ((i3 | 79) << 1) - (i3 ^ 79);
            D8871 = i4 % 128;
            if (i4 % 2 == 0) {
                return location;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static /* synthetic */ Object component5(Object[] objArr) throws Throwable {
        hO26224 ho26224 = (hO26224) objArr[0];
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr2 = {Long.valueOf(((Number) objArr[1]).longValue()), false, false, new Function1<Object, Location>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.hO26224.2
                private static int $D8871 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Location invoke(Object obj2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 5;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    Location locationVD14832N6715$32a6898b = vD14832N6715$32a6898b(obj2);
                    int i5 = $D8871;
                    int i6 = (i5 & 49) + (i5 | 49);
                    $vD14832N6715 = i6 % 128;
                    if (i6 % 2 == 0) {
                        int i7 = 12 / 0;
                    }
                    return locationVD14832N6715$32a6898b;
                }

                public final Location vD14832N6715$32a6898b(Object obj2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $D8871;
                    int i4 = (i3 & 49) + (i3 | 49);
                    $vD14832N6715 = i4 % 128;
                    int i5 = i4 % 2;
                    Location locationVD14832N6715 = ((K17305) hO26224.component9(ApiKeyNotFound.D8871(), new Object[]{hO26224.this}, ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), 1004734163, -1004734162)).vD14832N6715();
                    try {
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(870673214);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (View.resolveSize(0, 0) + 34629), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1436, 1632644957, false, "component5", new Class[0]);
                        }
                        ((Method) objComponent5).invoke(obj2, null);
                        int i6 = $vD14832N6715 + 13;
                        $D8871 = i6 % 128;
                        if (i6 % 2 == 0) {
                            return locationVD14832N6715;
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

                {
                    super(1);
                }
            }, 6, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int iRgb = (-16777165) - Color.rgb(0, 0, 0);
                char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int i2 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1076;
                Object[] objArr3 = new Object[1];
                a((byte) 0, 0, 0, objArr3);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iRgb, cMakeMeasureSpec, i2, 1722308833, false, (String) objArr3[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            Location location = (Location) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr2), null);
            int i3 = D8871 + 107;
            setTopP6481 = i3 % 128;
            if (i3 % 2 != 0) {
                return location;
            }
            obj.hashCode();
            throw null;
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
        D8871 = 0;
        setTopP6481 = 1;
    }

    public static final /* synthetic */ K17305 component5(hO26224 ho26224) {
        int iD8871 = ApiKeyNotFound.D8871();
        return (K17305) component9(ApiKeyNotFound.D8871(), new Object[]{ho26224}, ApiKeyNotFound.D8871(), iD8871, ApiKeyNotFound.D8871(), 1004734163, -1004734162);
    }

    private final Location D8871(long j) {
        return (Location) component9(ApiKeyNotFound.D8871(), new Object[]{this, Long.valueOf(j)}, ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), ApiKeyNotFound.D8871(), 439435221, -439435221);
    }
}
