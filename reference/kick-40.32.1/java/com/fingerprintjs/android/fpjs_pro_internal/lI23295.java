package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes6.dex */
public final class lI23295 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    public static int D8871;
    public static int component5;
    private static int component9;
    private static int setTopP6481;
    private final setOnLongClickListenerR17701 setPivotYN16904;
    private final K17305 vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 3 - r7
            int r6 = r6 * 3
            int r6 = r6 + 10
            int r8 = r8 * 3
            int r8 = r8 + 99
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.lI23295.$$a
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r6
            r4 = r2
            goto L2a
        L16:
            r3 = r2
        L17:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r7]
        L2a:
            int r8 = r8 + r3
            int r8 = r8 + (-23)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.lI23295.a(short, int, byte, java.lang.Object[]):void");
    }

    public static /* synthetic */ Object component9(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = ~i4;
        int i8 = ~(i7 | i5);
        int i9 = ~(i6 | i5);
        int i10 = ~i6;
        int i11 = ~i5;
        int i12 = i8 | i9 | (~(i10 | i11 | i4));
        int i13 = i8 | (~(i7 | i6)) | i9;
        int i14 = (~(i5 | i4)) | (~(i10 | i5)) | (~(i7 | i11 | i6));
        int i15 = i4 + i6 + i2 + (1880080305 * i) + (458392769 * i3);
        int i16 = i15 * i15;
        int i17 = ((766573918 * i4) - Integer.MIN_VALUE) + (1582236324 * i6) + (i12 * (-407831203)) + (815662406 * i13) + ((-407831203) * i14) + (1174405120 * i2) + (1711276032 * i) + ((-973078528) * i3) + (68288512 * i16);
        int i18 = ((i4 * 319678698) - 2002258816) + (i6 * 319678284) + (i12 * 207) + (i13 * (-414)) + (i14 * 207) + (i2 * 319678491) + (i * (-161570901)) + (i3 * (-1160779685)) + (i16 * (-1109000192));
        int i19 = i17 + (i18 * i18 * (-1432485888));
        if (i19 == 1) {
            return setPivotYN16904(objArr);
        }
        if (i19 != 2) {
            return i19 != 3 ? D8871(objArr) : component9(objArr);
        }
        return component5(objArr);
    }

    static void init$0() {
        $$a = new byte[]{51, -107, 109, -75, 35, Ascii.NAK, Ascii.SUB, Ascii.SYN, Ascii.SYN, Ascii.SO, 32, Ascii.GS, -36};
        $$b = 214;
    }

    public lI23295(K17305 k17305, setOnLongClickListenerR17701 setonlongclicklistenerr17701) {
        this.vD14832N6715 = k17305;
        this.setPivotYN16904 = setonlongclicklistenerr17701;
    }

    public static final /* synthetic */ qU20128 component5(lI23295 li23295, Location location, String str, int i) {
        int i2 = 2 % 2;
        int i3 = setTopP6481 + 59;
        component9 = i3 % 128;
        int i4 = i3 % 2;
        Object[] objArr = {li23295, location, str, Integer.valueOf(i)};
        int pivotYN16904 = H16981.setPivotYN16904();
        qU20128 qu20128 = (qU20128) component9(H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904(), 1507867841, objArr, pivotYN16904, -1507867840);
        int i5 = setTopP6481 + 81;
        component9 = i5 % 128;
        int i6 = i5 % 2;
        return qu20128;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        lI23295 li23295 = (lI23295) objArr[0];
        int i = 2 % 2;
        int pivotYN16904 = H16981.setPivotYN16904();
        int i2 = ~((pivotYN16904 & 2089375772) | (2089375772 ^ pivotYN16904));
        int i3 = ((784397450 | i2) * (-658)) + 815839554;
        int i4 = ((i2 & 37790850) | (37790850 ^ i2)) * 658;
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        int pivotYN16905 = H16981.setPivotYN16904();
        int i6 = ~pivotYN16905;
        int i7 = ~(((-1243985565) & i6) | ((-1243985565) ^ i6));
        int i8 = 1010908535 - (~(-(-((((i7 & 167875208) | (i7 ^ 167875208)) | (~(1868953279 | pivotYN16905))) * (-713)))));
        int i9 = (~((pivotYN16905 & 1868953279) | (1868953279 ^ pivotYN16905))) * 1426;
        int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
        int i11 = -(-((~((792842923 & i6) | (792842923 ^ i6))) * 713));
        int i12 = (i10 ^ i11) + ((i11 & i10) << 1);
        K17305 k17305 = li23295.vD14832N6715;
        if (i5 > i12) {
            int i13 = 77 / 0;
        }
        int i14 = component9 + 123;
        setTopP6481 = i14 % 128;
        if (i14 % 2 != 0) {
            return k17305;
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003c A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:12:0x0060 A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0079 A[Catch: all -> 0x0170, TRY_ENTER, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:16:0x007f A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:17:0x008a A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:22:0x00d9 A[Catch: all -> 0x0170, TRY_ENTER, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00fc A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0122 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:4:0x0011, B:9:0x0031, B:30:0x0162, B:10:0x003c, B:12:0x0060, B:14:0x0079, B:16:0x007f, B:17:0x008a, B:22:0x00d9, B:26:0x0126, B:23:0x00fc, B:24:0x0121, B:25:0x0122, B:7:0x0023), top: B:44:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:29:0x015f  */
    /* JADX WARN: Multi-variable type inference failed */
    public final D8871<List<qU20128>, sB6055> D8871(rV4669 rv4669) {
        Object objM12684constructorimpl;
        int iComponent9;
        long jRP23717;
        List<qU20128> listEmptyList;
        vD14832N6715 vd14832n6715;
        int i;
        int i2;
        int i3 = 2 % 2;
        int i4 = component9 + 121;
        setTopP6481 = i4 % 128;
        try {
            if (i4 % 2 == 0) {
                Result.Companion companion = Result.INSTANCE;
                int i5 = 11 / 0;
                if (this.setPivotYN16904.vD14832N6715().isEmpty()) {
                    vd14832n6715 = new setPivotYN16904(sB6055.vD14832N6715.INSTANCE);
                } else {
                    iComponent9 = u.Companion.component9();
                    if (!((Boolean) K17305.setPivotYN16904(u.Companion.component9(), new Object[0], 1033814136, -1033814136, u.Companion.component9(), iComponent9, u.Companion.component9())).booleanValue()) {
                        vd14832n6715 = new setPivotYN16904(sB6055.component9.INSTANCE);
                        int i6 = component9;
                        int i7 = (i6 ^ 67) + ((i6 & 67) << 1);
                        setTopP6481 = i7 % 128;
                        int i8 = i7 % 2;
                    } else if (rv4669.setTopP6481()) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jRP23718 = rv4669.rP23717();
                        int iComponent10 = P28427.AnonymousClass4.component9();
                        int iComponent11 = P28427.AnonymousClass4.component9();
                        qU20128 qu20128D8871 = D8871(jRP23718, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent10, iComponent11, 2017825196)).intValue());
                        jRP23717 = (jCurrentTimeMillis + rv4669.rP23717()) - System.currentTimeMillis();
                        if (jRP23717 > 0) {
                            i2 = component9 + 11;
                            setTopP6481 = i2 % 128;
                            if (i2 % 2 != 0) {
                                int iComponent12 = P28427.AnonymousClass4.component9();
                                int iComponent13 = P28427.AnonymousClass4.component9();
                                setPivotYN16904(jRP23717, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent12, iComponent13, 2017825196)).intValue());
                                Object obj = null;
                                obj.hashCode();
                                throw null;
                            }
                            int iComponent14 = P28427.AnonymousClass4.component9();
                            int iComponent15 = P28427.AnonymousClass4.component9();
                            listEmptyList = setPivotYN16904(jRP23717, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent14, iComponent15, 2017825196)).intValue());
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.add(qu20128D8871);
                        spreadBuilder.addSpread(listEmptyList.toArray(new qU20128[0]));
                        vd14832n6715 = new vD14832N6715(CollectionsKt.listOfNotNull(spreadBuilder.toArray(new qU20128[spreadBuilder.size()])));
                        int i9 = component9;
                        i = ((i9 | 57) << 1) - (i9 ^ 57);
                        setTopP6481 = i % 128;
                        if (i % 2 == 0) {
                            int i10 = 3 / 4;
                        }
                    } else {
                        vd14832n6715 = new setPivotYN16904(sB6055.component5.INSTANCE);
                    }
                }
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                if (this.setPivotYN16904.vD14832N6715().isEmpty()) {
                    vd14832n6715 = new setPivotYN16904(sB6055.vD14832N6715.INSTANCE);
                } else {
                    iComponent9 = u.Companion.component9();
                    if (!((Boolean) K17305.setPivotYN16904(u.Companion.component9(), new Object[0], 1033814136, -1033814136, u.Companion.component9(), iComponent9, u.Companion.component9())).booleanValue()) {
                        vd14832n6715 = new setPivotYN16904(sB6055.component9.INSTANCE);
                        int i11 = component9;
                        int i12 = (i11 ^ 67) + ((i11 & 67) << 1);
                        setTopP6481 = i12 % 128;
                        int i13 = i12 % 2;
                    } else if (rv4669.setTopP6481()) {
                        vd14832n6715 = new setPivotYN16904(sB6055.component5.INSTANCE);
                    } else {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        long jRP23719 = rv4669.rP23717();
                        int iComponent16 = P28427.AnonymousClass4.component9();
                        int iComponent17 = P28427.AnonymousClass4.component9();
                        qU20128 qu20128D8872 = D8871(jRP23719, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent16, iComponent17, 2017825196)).intValue());
                        jRP23717 = (jCurrentTimeMillis2 + rv4669.rP23717()) - System.currentTimeMillis();
                        if (jRP23717 > 0) {
                            i2 = component9 + 11;
                            setTopP6481 = i2 % 128;
                            if (i2 % 2 != 0) {
                                int iComponent18 = P28427.AnonymousClass4.component9();
                                int iComponent19 = P28427.AnonymousClass4.component9();
                                setPivotYN16904(jRP23717, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent18, iComponent19, 2017825196)).intValue());
                                Object obj2 = null;
                                obj2.hashCode();
                                throw null;
                            }
                            int iComponent110 = P28427.AnonymousClass4.component9();
                            int iComponent111 = P28427.AnonymousClass4.component9();
                            listEmptyList = setPivotYN16904(jRP23717, ((Integer) rV4669.vD14832N6715(-2017825196, P28427.AnonymousClass4.component9(), new Object[]{rv4669}, P28427.AnonymousClass4.component9(), iComponent110, iComponent111, 2017825196)).intValue());
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        SpreadBuilder spreadBuilder2 = new SpreadBuilder(2);
                        spreadBuilder2.add(qu20128D8872);
                        spreadBuilder2.addSpread(listEmptyList.toArray(new qU20128[0]));
                        vd14832n6715 = new vD14832N6715(CollectionsKt.listOfNotNull(spreadBuilder2.toArray(new qU20128[spreadBuilder2.size()])));
                        int i14 = component9;
                        i = ((i14 | 57) << 1) - (i14 ^ 57);
                        setTopP6481 = i % 128;
                        if (i % 2 == 0) {
                            int i15 = 3 / 4;
                        }
                    }
                }
            }
            objM12684constructorimpl = Result.m12684constructorimpl(vd14832n6715);
            int i16 = setTopP6481 + 105;
            component9 = i16 % 128;
            int i17 = i16 % 2;
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        setPivotYN16904 pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl);
        if (pivotYN16904 instanceof vD14832N6715) {
            int i18 = setTopP6481;
            int i19 = (i18 ^ 123) + ((i18 & 123) << 1);
            component9 = i19 % 128;
            int i20 = i19 % 2;
        } else {
            if (!(pivotYN16904 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            pivotYN16904 = new setPivotYN16904(sB6055.D8871.INSTANCE);
        }
        return bb.component9(pivotYN16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.lI23295$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/fingerprintjs/android/fpjs_pro_internal/qU20128;", "setPivotYN16904$7f9ec873", "(Ljava/lang/Object;)Lcom/fingerprintjs/android/fpjs_pro_internal/qU20128;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<Object, qU20128> {
        private static int $setTopP6481 = 1;
        private static int $vD14832N6715;
        public static int D8871;
        public static int setPivotYN16904;
        private /* synthetic */ int $component9;

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ qU20128 invoke(Object obj) throws Throwable {
            int i = 2 % 2;
            int i2 = $vD14832N6715;
            int i3 = ((i2 | 99) << 1) - (i2 ^ 99);
            $setTopP6481 = i3 % 128;
            int i4 = i3 % 2;
            qU20128 pivotYN16904$7f9ec873 = setPivotYN16904$7f9ec873(obj);
            if (i4 == 0) {
                int i5 = 45 / 0;
            }
            return pivotYN16904$7f9ec873;
        }

        public final qU20128 setPivotYN16904$7f9ec873(Object obj) throws Throwable {
            int i = 2 % 2;
            int i2 = $vD14832N6715 + 91;
            $setTopP6481 = i2 % 128;
            int i3 = i2 % 2;
            lI23295 li23295 = lI23295.this;
            Object obj2 = null;
            try {
                if (i3 == 0) {
                    int pivotYN16904 = H16981.setPivotYN16904();
                    int pivotYN16905 = H16981.setPivotYN16904();
                    Location locationComponent5 = ((K17305) lI23295.component9(H16981.setPivotYN16904(), pivotYN16905, H16981.setPivotYN16904(), -355154228, new Object[]{li23295}, pivotYN16904, 355154231)).component5();
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(870673214);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 51, (char) (TextUtils.getCapsMode("", 0, 0) + 34629), 1437 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 1632644957, false, "component5", new Class[0]);
                    }
                    ((Method) objComponent5).invoke(obj, null);
                    lI23295.component5(lI23295.this, locationComponent5, I30900.ah.INSTANCE.component5(), this.$component9);
                    obj2.hashCode();
                    throw null;
                }
                int pivotYN16906 = H16981.setPivotYN16904();
                int pivotYN16907 = H16981.setPivotYN16904();
                Location locationComponent6 = ((K17305) lI23295.component9(H16981.setPivotYN16904(), pivotYN16907, H16981.setPivotYN16904(), -355154228, new Object[]{li23295}, pivotYN16906, 355154231)).component5();
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(870673214);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 52, (char) (TextUtils.indexOf((CharSequence) "", '0') + 34630), 1436 - Color.red(0), 1632644957, false, "component5", new Class[0]);
                }
                ((Method) objComponent6).invoke(obj, null);
                qU20128 qu20128Component5 = lI23295.component5(lI23295.this, locationComponent6, I30900.ah.INSTANCE.component5(), this.$component9);
                int i4 = $vD14832N6715;
                int i5 = (i4 ^ 51) + ((i4 & 51) << 1);
                $setTopP6481 = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 22 / 0;
                }
                return qu20128Component5;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        public static int vD14832N6715() {
            int i = D8871;
            int i2 = i % 6212281;
            D8871 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int iNextInt = new Random().nextInt(1981005330);
            setPivotYN16904 = iNextInt;
            return iNextInt;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i) {
            super(1);
            this.$component9 = i;
        }
    }

    private final qU20128 D8871(long j, int i) throws Throwable {
        int i2 = 2 % 2;
        try {
            Object[] objArr = {Long.valueOf(j), false, false, new AnonymousClass2(i), 6, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int tapTimeout = 51 - (ViewConfiguration.getTapTimeout() >> 16);
                char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                int i3 = 1077 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout, absoluteGravity, i3, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            qU20128 qu20128 = (qU20128) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), null);
            int i4 = setTopP6481;
            int i5 = (i4 ^ 23) + ((i4 & 23) << 1);
            component9 = i5 % 128;
            if (i5 % 2 != 0) {
                int i6 = 74 / 0;
            }
            return qu20128;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private final List<qU20128> setPivotYN16904(long j, final int i) throws Throwable {
        int i2 = 2 % 2;
        final ArrayList arrayList = new ArrayList();
        try {
            Object[] objArr = {Long.valueOf(j), false, false, new Function1<Object, Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.lI23295.5
                private static int $D8871 = 0;
                private static int $setPivotYN16904 = 1;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Object obj) throws Throwable {
                    int i3 = 2 % 2;
                    int i4 = $D8871;
                    int i5 = (i4 & 5) + (i4 | 5);
                    $setPivotYN16904 = i5 % 128;
                    int i6 = i5 % 2;
                    component5$1d23b50d(obj);
                    Unit unit = Unit.INSTANCE;
                    int i7 = $setPivotYN16904;
                    int i8 = (i7 ^ 81) + ((i7 & 81) << 1);
                    $D8871 = i8 % 128;
                    int i9 = i8 % 2;
                    return unit;
                }

                /* JADX WARN: Code duplicated, block: B:37:0x0144 A[Catch: all -> 0x01e2, TryCatch #2 {all -> 0x01e2, blocks: (B:6:0x008a, B:9:0x0098, B:10:0x00c2, B:35:0x0137, B:37:0x0144, B:38:0x016c, B:40:0x017f, B:42:0x0185, B:43:0x01b2), top: B:60:0x008a }] */
                /* JADX WARN: Code duplicated, block: B:42:0x0185 A[Catch: all -> 0x01e2, TryCatch #2 {all -> 0x01e2, blocks: (B:6:0x008a, B:9:0x0098, B:10:0x00c2, B:35:0x0137, B:37:0x0144, B:38:0x016c, B:40:0x017f, B:42:0x0185, B:43:0x01b2), top: B:60:0x008a }] */
                /* JADX WARN: Code duplicated, block: B:45:0x01ba  */
                /* JADX WARN: Code duplicated, block: B:47:0x01c6  */
                /* JADX WARN: Code duplicated, block: B:48:0x01cd  */
                /* JADX WARN: Code duplicated, block: B:70:0x01d0 A[SYNTHETIC] */
                public final void component5$1d23b50d(Object obj) throws Throwable {
                    char c;
                    CharSequence charSequence;
                    int i3;
                    Object objM12684constructorimpl;
                    Object objComponent5;
                    qU20128 qu20128Component5;
                    Object objComponent6;
                    int i4;
                    int i5 = 2;
                    int i6 = 2 % 2;
                    int i7 = $setPivotYN16904;
                    int i8 = (i7 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i7 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                    $D8871 = i8 % 128;
                    int i9 = i8 % 2;
                    int i10 = -355154228;
                    List<String> list = (List) K17305.setPivotYN16904(u.Companion.component9(), new Object[]{(K17305) lI23295.component9(H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904(), -355154228, new Object[]{lI23295.this}, H16981.setPivotYN16904(), 355154231)}, -92254710, 92254715, u.Companion.component9(), u.Companion.component9(), u.Companion.component9());
                    lI23295 li23295 = lI23295.this;
                    int i11 = i;
                    List<qU20128> list2 = arrayList;
                    int i12 = $setPivotYN16904 + 93;
                    $D8871 = i12 % 128;
                    int i13 = i12 % 2;
                    for (String str : list) {
                        int i14 = $D8871;
                        int i15 = (i14 ^ 41) + ((i14 & 41) << 1);
                        $setPivotYN16904 = i15 % 128;
                        int i16 = i15 % i5;
                        int i17 = 870673214;
                        try {
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(870673214);
                            if (objComponent7 == null) {
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0'), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 34629), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1436, 1632644957, false, "component5", new Class[0]);
                            }
                            ((Method) objComponent7).invoke(obj, null);
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                charSequence = "";
                                try {
                                    try {
                                        try {
                                            i10 = i10;
                                            i17 = 870673214;
                                            charSequence = charSequence;
                                            c = '0';
                                            i5 = i5;
                                            i3 = 0;
                                            try {
                                                objM12684constructorimpl = Result.m12684constructorimpl(((K17305) lI23295.component9(H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904(), i10, new Object[]{li23295}, H16981.setPivotYN16904(), 355154231)).component9(str));
                                            } catch (Throwable th) {
                                                th = th;
                                                Result.Companion companion2 = Result.INSTANCE;
                                                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i10 = i10;
                                            i17 = 870673214;
                                            charSequence = charSequence;
                                            c = '0';
                                            i5 = i5;
                                            i3 = 0;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        c = '0';
                                        i3 = 0;
                                        Result.Companion companion3 = Result.INSTANCE;
                                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                                        Object[] objArr2 = {bb.setPivotYN16904(objM12684constructorimpl)};
                                        objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
                                        if (objComponent5 == null) {
                                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf(charSequence, charSequence, i3), (char) ((-1) - TextUtils.indexOf(charSequence, c)), 1488 - View.getDefaultSize(i3, i3), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
                                        }
                                        qu20128Component5 = lI23295.component5(li23295, (Location) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr2), null), str, i11);
                                        objComponent6 = setSystemGestureExclusionRectsL30479.component5(i17);
                                        if (objComponent6 == null) {
                                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 52, (char) (34629 - (ViewConfiguration.getLongPressTimeout() >> 16)), 1436 - (ViewConfiguration.getLongPressTimeout() >> 16), 1632644957, false, "component5", new Class[i3]);
                                        }
                                        ((Method) objComponent6).invoke(obj, null);
                                        if (qu20128Component5 != null) {
                                            i4 = $D8871 + 43;
                                            $setPivotYN16904 = i4 % 128;
                                            if (i4 % 2 == 0) {
                                                list2.add(qu20128Component5);
                                                int i18 = 87 / i3;
                                            } else {
                                                list2.add(qu20128Component5);
                                            }
                                        }
                                        int i19 = $setPivotYN16904;
                                        int i20 = (i19 & 55) + (i19 | 55);
                                        $D8871 = i20 % 128;
                                        int i21 = i20 % 2;
                                        i10 = i10;
                                        i5 = i5;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    c = '0';
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                i10 = i10;
                                i17 = 870673214;
                                c = '0';
                                charSequence = "";
                            }
                            Object[] objArr3 = {bb.setPivotYN16904(objM12684constructorimpl)};
                            objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf(charSequence, charSequence, i3), (char) ((-1) - TextUtils.indexOf(charSequence, c)), 1488 - View.getDefaultSize(i3, i3), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
                            }
                            qu20128Component5 = lI23295.component5(li23295, (Location) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr3), null), str, i11);
                            objComponent6 = setSystemGestureExclusionRectsL30479.component5(i17);
                            if (objComponent6 == null) {
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 52, (char) (34629 - (ViewConfiguration.getLongPressTimeout() >> 16)), 1436 - (ViewConfiguration.getLongPressTimeout() >> 16), 1632644957, false, "component5", new Class[i3]);
                            }
                            ((Method) objComponent6).invoke(obj, null);
                            if (qu20128Component5 != null) {
                                i4 = $D8871 + 43;
                                $setPivotYN16904 = i4 % 128;
                                if (i4 % 2 == 0) {
                                    list2.add(qu20128Component5);
                                    int i110 = 87 / i3;
                                } else {
                                    list2.add(qu20128Component5);
                                }
                            }
                            int i111 = $setPivotYN16904;
                            int i22 = (i111 & 55) + (i111 | 55);
                            $D8871 = i22 % 128;
                            int i23 = i22 % 2;
                            i10 = i10;
                            i5 = i5;
                        } catch (Throwable th6) {
                            Throwable cause = th6.getCause();
                            if (cause == null) {
                                throw th6;
                            }
                            throw cause;
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            }, 6, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 51;
                char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int tapTimeout = 1077 - (ViewConfiguration.getTapTimeout() >> 16);
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(absoluteGravity, c, tapTimeout, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            ((Method) objComponent5).invoke(null, objArr);
            int i3 = component9;
            int i4 = (i3 & 105) + (i3 | 105);
            setTopP6481 = i4 % 128;
            int i5 = i4 % 2;
            return arrayList;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) throws Throwable {
        lI23295 li23295 = (lI23295) objArr[0];
        Location location = (Location) objArr[1];
        String str = (String) objArr[2];
        int iIntValue = ((Number) objArr[3]).intValue();
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 & 15) + (i2 | 15);
        component9 = i3 % 128;
        Object obj = null;
        if (i3 % 2 != 0) {
            obj.hashCode();
            throw null;
        }
        if (location == null) {
            int i4 = (i2 ^ 115) + ((i2 & 115) << 1);
            component9 = i4 % 128;
            int i5 = i4 % 2;
            return null;
        }
        List<String> listVD14832N6715 = li23295.vD14832N6715(location, iIntValue);
        int pivotYN16904 = H16981.setPivotYN16904();
        int pivotYN16905 = H16981.setPivotYN16904();
        boolean zBooleanValue = ((Boolean) component9(H16981.setPivotYN16904(), pivotYN16905, H16981.setPivotYN16904(), -1332695383, new Object[]{location}, pivotYN16904, 1332695383)).booleanValue();
        int pivotYN16906 = H16981.setPivotYN16904();
        int pivotYN16907 = H16981.setPivotYN16904();
        return new qU20128(listVD14832N6715, zBooleanValue, str, ((Long) component9(H16981.setPivotYN16904(), pivotYN16907, H16981.setPivotYN16904(), 1027790422, new Object[]{location}, pivotYN16906, -1027790420)).longValue());
    }

    private final List<String> vD14832N6715(Location location, int i) throws Throwable {
        Object objM12684constructorimpl;
        int i2 = 2 % 2;
        int i3 = component9 + 91;
        setTopP6481 = i3 % 128;
        Object obj = null;
        try {
            if (i3 % 2 == 0) {
                Result.Companion companion = Result.INSTANCE;
                Result.m12684constructorimpl(this.vD14832N6715.component5(location.getLatitude(), location.getLongitude(), i));
                obj.hashCode();
                throw null;
            }
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(this.vD14832N6715.component5(location.getLatitude(), location.getLongitude(), i));
            int i4 = setTopP6481;
            int i5 = (i4 ^ 9) + ((i4 & 9) << 1);
            component9 = i5 % 128;
            int i6 = i5 % 2;
            try {
                Object[] objArr = {bb.setPivotYN16904(objM12684constructorimpl)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.getOffsetAfter("", 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0), 1488 - Color.argb(0, 0, 0, 0), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
                }
                List<String> list = (List) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), CollectionsKt.emptyList());
                int i7 = component9;
                int i8 = ((i7 | 9) << 1) - (i7 ^ 9);
                setTopP6481 = i8 % 128;
                if (i8 % 2 != 0) {
                    return list;
                }
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0064 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:17:0x0057, B:19:0x0064, B:20:0x008f), top: B:30:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00ae  */
    private static /* synthetic */ Object D8871(Object[] objArr) throws Throwable {
        Object objM12684constructorimpl;
        Object objComponent5;
        int i;
        boolean zIsFromMockProvider;
        int i2;
        Location location = (Location) objArr[0];
        int i3 = 2 % 2;
        int i4 = setTopP6481 + 13;
        component9 = i4 % 128;
        try {
            try {
                if (i4 % 2 == 0) {
                    Result.Companion companion = Result.INSTANCE;
                    if (Build.VERSION.SDK_INT < 31) {
                        zIsFromMockProvider = location.isFromMockProvider();
                        i2 = component9 + 5;
                    }
                    setTopP6481 = i2 % 128;
                    int i5 = i2 % 2;
                    objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(zIsFromMockProvider));
                    int i6 = setTopP6481 + 97;
                    component9 = i6 % 128;
                    int i7 = i6 % 2;
                    Object[] objArr2 = {bb.setPivotYN16904(objM12684constructorimpl)};
                    objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 1487 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
                    }
                    Boolean bool = (Boolean) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr2), Boolean.FALSE);
                    bool.booleanValue();
                    i = setTopP6481 + 43;
                    component9 = i % 128;
                    if (i % 2 != 0) {
                        int i8 = 82 / 0;
                    }
                    return bool;
                }
                Result.Companion companion2 = Result.INSTANCE;
                zIsFromMockProvider = location.isMock();
                i2 = component9 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                setTopP6481 = i2 % 128;
                int i9 = i2 % 2;
                objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(zIsFromMockProvider));
                int i10 = setTopP6481 + 97;
                component9 = i10 % 128;
                int i11 = i10 % 2;
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            Object[] objArr3 = {bb.setPivotYN16904(objM12684constructorimpl)};
            objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 1487 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
            }
            Boolean bool2 = (Boolean) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr3), Boolean.FALSE);
            bool2.booleanValue();
            i = setTopP6481 + 43;
            component9 = i % 128;
            if (i % 2 != 0) {
                int i12 = 82 / 0;
            }
            return bool2;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    private static /* synthetic */ Object component5(Object[] objArr) throws Throwable {
        Object objM12684constructorimpl;
        Location location = (Location) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481 + 103;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf((SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000));
            int i4 = setTopP6481;
            int i5 = ((i4 | 29) << 1) - (i4 ^ 29);
            component9 = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Object[] objArr2 = {bb.setPivotYN16904(objM12684constructorimpl)};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-962826758);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Drawable.resolveOpacity(0, 0) + 51, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1488 - TextUtils.getOffsetBefore("", 0), -1809241703, false, "vD14832N6715", new Class[]{D8871.class});
            }
            Object obj = null;
            long jLongValue = ((Number) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr2), 0L)).longValue();
            int i7 = setTopP6481 + 5;
            component9 = i7 % 128;
            if (i7 % 2 == 0) {
                return Long.valueOf(jLongValue);
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    static {
        init$0();
        component9 = 0;
        setTopP6481 = 1;
    }

    public static int component9() {
        int i = component5;
        int i2 = i % 6294633;
        component5 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iNextInt = new Random().nextInt();
        D8871 = iNextInt;
        return iNextInt;
    }

    public static final /* synthetic */ K17305 component5(lI23295 li23295) {
        int pivotYN16904 = H16981.setPivotYN16904();
        int pivotYN16905 = H16981.setPivotYN16904();
        return (K17305) component9(H16981.setPivotYN16904(), pivotYN16905, H16981.setPivotYN16904(), -355154228, new Object[]{li23295}, pivotYN16904, 355154231);
    }

    private static long D8871(Location location) {
        int pivotYN16904 = H16981.setPivotYN16904();
        int pivotYN16905 = H16981.setPivotYN16904();
        return ((Long) component9(H16981.setPivotYN16904(), pivotYN16905, H16981.setPivotYN16904(), 1027790422, new Object[]{location}, pivotYN16904, -1027790420)).longValue();
    }

    private static boolean component5(Location location) {
        int pivotYN16904 = H16981.setPivotYN16904();
        int pivotYN16905 = H16981.setPivotYN16904();
        return ((Boolean) component9(H16981.setPivotYN16904(), pivotYN16905, H16981.setPivotYN16904(), -1332695383, new Object[]{location}, pivotYN16904, 1332695383)).booleanValue();
    }

    private final qU20128 setPivotYN16904(Location location, String str, int i) {
        Object[] objArr = {this, location, str, Integer.valueOf(i)};
        int pivotYN16904 = H16981.setPivotYN16904();
        return (qU20128) component9(H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904(), 1507867841, objArr, pivotYN16904, -1507867840);
    }
}
