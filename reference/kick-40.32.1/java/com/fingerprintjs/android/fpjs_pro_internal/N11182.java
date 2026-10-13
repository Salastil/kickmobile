package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.PlaybackException;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.google.android.gms.cast.MediaError;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0080\b\u0018\u0000  2\u00020\u0001:\u0001 B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u001a\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010#\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u0014\u0010%\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010-\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010)\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u0016\u0010.\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010$"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/N11182;", "", "", "p0", "p1", "", "p2", "p3", "p4", "", "p5", "", "p6", "", "p7", "p8", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "p9", "<init>", "(DDLjava/lang/Float;Ljava/lang/Double;Ljava/lang/Float;ZJIJLcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;)V", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "", "setPivotYN16904", "()Ljava/util/Map;", "toString", "()Ljava/lang/String;", "component5", "Ljava/lang/Double;", "component9", "cW27173", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "vD14832N6715", "Ljava/lang/Float;", "component13", "Z", "D", "D8871", "sG29839", "J", "N14263A23323", "I", "component8", "setTopP6481"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class N11182 {
    private static int Y16199 = 1;
    private static int component10 = 0;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int kC4266 = 0;
    private static int rP23717 = 1;

    /* JADX INFO: renamed from: D8871, reason: from kotlin metadata */
    public double N14263A23323;

    /* JADX INFO: renamed from: N14263A23323, reason: from kotlin metadata */
    public int component8;

    /* JADX INFO: renamed from: cW27173, reason: from kotlin metadata */
    public component1H27181 setPivotYN16904;

    /* JADX INFO: renamed from: component13, reason: from kotlin metadata */
    public boolean vD14832N6715;

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    public Double component9;

    /* JADX INFO: renamed from: component8, reason: from kotlin metadata */
    public long sG29839;

    /* JADX INFO: renamed from: sG29839, reason: from kotlin metadata */
    public long component13;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public double D8871;
    public Float setTopP6481;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public Float component5;

    public static /* synthetic */ Object component9(int i, int i2, int i3, int i4, int i5, int i6, Object[] objArr) {
        int iHashCode;
        int iHashCode2;
        int i7 = i4 | i2 | (~i6);
        int i8 = (~((~i4) | i2)) | (~(i4 | i6));
        int i9 = (~(i6 | (~i2))) | i4;
        int i10 = i4 + i2 + i5 + ((-1069702238) * i) + (1645725337 * i3);
        int i11 = i10 * i10;
        int i12 = ((i4 * 2084108943) - 1824784384) + (2084108943 * i2) + (i7 * (-929364622)) + (929364622 * i8) + ((-929364622) * i9) + (1154744320 * i5) + ((-1977090048) * i) + (448004096 * i3) + (1807155200 * i11);
        int i13 = (i4 * (-999696423)) + 1136243370 + (i2 * (-999696423)) + (i7 * 830) + (i8 * (-830)) + (i9 * 830) + (i5 * (-999695593)) + (i * 636963214) + (i3 * (-1077364033)) + (i11 * 980484096);
        if (i12 + (i13 * i13 * 1287192576) != 1) {
            return component9(objArr);
        }
        int iHashCode3 = 0;
        N11182 n11182 = (N11182) objArr[0];
        int i14 = 2 % 2;
        int iHashCode4 = Double.hashCode(n11182.D8871);
        int i15 = iHashCode4 * 31;
        int iHashCode5 = Double.hashCode(n11182.N14263A23323);
        int iIdentityHashCode = System.identityHashCode(n11182);
        int i16 = ((iHashCode5 * PlaybackException.ERROR_CODE_END_OF_PLAYLIST) - (~(iHashCode4 * 3441))) - 1;
        int i17 = ~iHashCode5;
        int i18 = ~((iIdentityHashCode & i15) | (i15 ^ iIdentityHashCode));
        int i19 = (i16 - (~(-(-(((i17 ^ i18) | (i17 & i18)) * (-220)))))) - 1;
        int i20 = ~(iHashCode5 | i15);
        int i21 = ((i18 & i20) | (i20 ^ i18)) * 220;
        int i22 = ~((i17 & i15) | (i17 ^ i15));
        int i23 = ~((~i15) | iHashCode5);
        int i24 = ((((i19 | i21) << 1) - (i21 ^ i19)) - (~(-(-(((i22 & i23) | (i22 ^ i23)) * MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE))))) - 1;
        int i25 = i24 * 31;
        Float f = n11182.component5;
        if (f == null) {
            int i26 = component10 + 49;
            int i27 = i26 % 128;
            rP23717 = i27;
            iHashCode = i26 % 2 == 0 ? 1 : 0;
            int i28 = i27 + 31;
            component10 = i28 % 128;
            int i29 = i28 % 2;
        } else {
            iHashCode = f.hashCode();
        }
        int pivotYN16904 = setOnLongClickListenerR17701.setPivotYN16904();
        int i30 = iHashCode * 141;
        int i31 = i24 * (-8649);
        int i32 = (i30 ^ i31) + ((i30 & i31) << 1) + (((i25 ^ pivotYN16904) | (i25 & pivotYN16904)) * 140);
        int i33 = ~iHashCode;
        int i34 = ~((i33 & i25) | (i33 ^ i25));
        int i35 = ~pivotYN16904;
        int i36 = (i34 | (~((i35 & i25) | (i35 ^ i25)))) * (-280);
        int i37 = (i32 & i36) + (i36 | i32);
        int i38 = ~i25;
        int i39 = ~((i38 & iHashCode) | (i38 ^ iHashCode));
        int i40 = ~pivotYN16904;
        int i41 = i39 | (~((i40 & iHashCode) | (i40 ^ iHashCode)));
        int i42 = ~iHashCode;
        int i43 = (i25 & i42) | (i42 ^ i25);
        int i44 = ~((i43 & pivotYN16904) | (i43 ^ pivotYN16904));
        int i45 = ((i44 & i41) | (i41 ^ i44)) * 140;
        int i46 = ((i37 & i45) + (i45 | i37)) * 31;
        Double d = n11182.component9;
        if (d == null) {
            int i47 = rP23717;
            int i48 = i47 + 51;
            component10 = i48 % 128;
            int i49 = i48 % 2;
            int i50 = i47 + 13;
            component10 = i50 % 128;
            int i51 = i50 % 2;
            iHashCode2 = 0;
        } else {
            iHashCode2 = d.hashCode();
            int i52 = component10;
            int i53 = ((i52 | 39) << 1) - (i52 ^ 39);
            rP23717 = i53 % 128;
            int i54 = i53 % 2;
        }
        int i55 = (i46 + iHashCode2) * 31;
        Float f2 = n11182.setTopP6481;
        if (f2 == null) {
            int i56 = component10 + 53;
            rP23717 = i56 % 128;
            if (i56 % 2 == 0) {
                iHashCode3 = 1;
            }
        } else {
            iHashCode3 = f2.hashCode();
            System.identityHashCode(n11182);
            System.identityHashCode(n11182);
        }
        int i57 = ((i55 - (~iHashCode3)) - 1) * 31;
        int i58 = -(-Boolean.hashCode(n11182.vD14832N6715));
        int i59 = ((i57 ^ i58) + ((i58 & i57) << 1)) * 31;
        int iHashCode6 = Long.hashCode(n11182.component13);
        int i60 = (i59 & iHashCode6) + (iHashCode6 | i59);
        int i61 = i60 * 31;
        int iHashCode7 = Integer.hashCode(n11182.component8);
        int iIdentityHashCode2 = System.identityHashCode(n11182);
        int i62 = -(-(iHashCode7 * 306));
        int i63 = (i62 ^ TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS) + ((i62 & TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS) << 1);
        int i64 = -(-(i60 * 9486));
        int i65 = (i63 ^ i64) + ((i64 & i63) << 1);
        int i66 = ~((iHashCode7 ^ i61) | (iHashCode7 & i61));
        int i67 = ~(iHashCode7 | iIdentityHashCode2);
        int i68 = (i65 - (~(((i66 & i67) | (i66 ^ i67)) * 305))) - 1;
        int i69 = ~i61;
        int i70 = ~iIdentityHashCode2;
        int i71 = ~((iHashCode7 & i70) | (i70 ^ iHashCode7));
        int i72 = -(-(((i69 & i71) | (i69 ^ i71)) * 305));
        int i73 = (i68 & i72) + (i72 | i68);
        int i74 = i73 * 31;
        int iHashCode8 = Long.hashCode(n11182.sG29839);
        int iIdentityHashCode3 = System.identityHashCode(n11182);
        int i75 = iHashCode8 * (-500);
        int i76 = -(-(i73 * (-15500)));
        int i77 = (i75 ^ i76) + ((i76 & i75) << 1);
        int i78 = ~i74;
        int i79 = ~((i78 ^ iHashCode8) | (i78 & iHashCode8));
        int i80 = ~iHashCode8;
        int i81 = (i80 ^ i74) | (i80 & i74);
        int i82 = ~((i81 & iIdentityHashCode3) | (i81 ^ iIdentityHashCode3));
        int i83 = ((i79 & i82) | (i79 ^ i82)) * TypedValues.Position.TYPE_TRANSITION_EASING;
        int i84 = (((i77 & i83) + (i83 | i77)) - (~((~(i78 | i80)) * 1002))) - 1;
        int i85 = (~iIdentityHashCode3) | i80;
        int i86 = (~((i74 & i85) | (i85 ^ i74))) * TypedValues.Position.TYPE_TRANSITION_EASING;
        int i87 = (((i84 | i86) << 1) - (i86 ^ i84)) * 31;
        int i88 = -(-n11182.setPivotYN16904.hashCode());
        return Integer.valueOf((i87 ^ i88) + ((i88 & i87) << 1));
    }

    public N11182(double d, double d2, Float f, Double d3, Float f2, boolean z, long j, int i, long j2, component1H27181 component1h27181) {
        this.D8871 = d;
        this.N14263A23323 = d2;
        this.component5 = f;
        this.component9 = d3;
        this.setTopP6481 = f2;
        this.vD14832N6715 = z;
        this.component13 = j;
        this.component8 = i;
        this.sG29839 = j2;
        this.setPivotYN16904 = component1h27181;
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = component10;
        int i3 = i2 + 15;
        rP23717 = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i2 + 79;
        rP23717 = i5 % 128;
        if (i5 % 2 != 0) {
            return "";
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        N11182 n11182 = (N11182) objArr[0];
        int i = 2 % 2;
        int i2 = rP23717;
        int i3 = (i2 ^ 21) + ((i2 & 21) << 1);
        component10 = i3 % 128;
        int i4 = i3 % 2;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(I30900.R24140.INSTANCE.component5(), n11182.D8871 + WebViewLogEventConsumer.DDTAGS_SEPARATOR + n11182.N14263A23323), TuplesKt.to(I30900.setPivotYN16904.INSTANCE.component5(), n11182.component9), TuplesKt.to(I30900.am.INSTANCE.component5(), n11182.component5), TuplesKt.to(I30900.da.INSTANCE.component5(), n11182.setTopP6481), TuplesKt.to(I30900.ao.INSTANCE.component5(), Boolean.valueOf(n11182.vD14832N6715)), TuplesKt.to(I30900.az.INSTANCE.component5(), Long.valueOf(n11182.component13)), TuplesKt.to(I30900.bk.INSTANCE.component5(), Integer.valueOf(n11182.component8)), TuplesKt.to(I30900.cs.INSTANCE.component5(), Long.valueOf(n11182.sG29839)), TuplesKt.to(I30900.setKeepScreenOnI3248.INSTANCE.component5(), Long.valueOf(n11182.setPivotYN16904.component5)), TuplesKt.to(I30900.getContextMenuInfoA21117E7283.INSTANCE.component5(), Long.valueOf(n11182.setPivotYN16904.vD14832N6715)));
        int i5 = rP23717 + 7;
        component10 = i5 % 128;
        if (i5 % 2 == 0) {
            return mapMapOf;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.N11182$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/N11182$component9;", "", "<init>", "()V", "Landroid/location/Location;", "p0", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnContextClickListenerE32038;", "p1", "", "p2", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "p3", "Lcom/fingerprintjs/android/fpjs_pro_internal/N11182;", "component5", "(Landroid/location/Location;Ljava/util/List;JLcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;)Lcom/fingerprintjs/android/fpjs_pro_internal/N11182;", "", "component9", "(Landroid/location/Location;)Ljava/lang/Float;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static int D8871;
        private static int component9;
        private static int vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x002a  */
        /* JADX WARN: Code duplicated, block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, short r7, byte r8) {
            /*
                int r6 = r6 * 3
                int r6 = r6 + 1
                int r8 = r8 * 4
                int r8 = 3 - r8
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.N11182.Companion.$$a
                int r7 = r7 * 3
                int r7 = r7 + 120
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r6
                r7 = r8
                r4 = r2
                goto L2c
            L17:
                r3 = r8
                r8 = r7
                r7 = r3
                r3 = r2
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                int r7 = r7 + 1
                if (r4 != r6) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L2a:
                r3 = r0[r7]
            L2c:
                int r3 = -r3
                int r8 = r8 + r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.N11182.Companion.$$c(int, short, byte):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{120, -76, 109, Ascii.FS};
            $$b = 150;
        }

        private Companion() {
        }

        public static N11182 component5(Location p0, List<? extends setOnContextClickListenerE32038> p1, long p2, component1H27181 p3) {
            return new N11182(p0.getLatitude(), p0.getLongitude(), p0.hasAccuracy() ? Float.valueOf(p0.getAccuracy()) : null, p0.hasAltitude() ? Double.valueOf(p0.getAltitude()) : null, component9(p0), aw.component9(p0), p0.getTime(), ENTRIES.component9(p1), p2, p3);
        }

        private static void a(int i, boolean z, int i2, String str, int i3, Object[] objArr) throws Throwable {
            char[] charArray;
            long j;
            int i4 = 2 % 2;
            int i5 = $10 + 27;
            $11 = i5 % 128;
            Object obj = null;
            if (i5 % 2 == 0) {
                obj.hashCode();
                throw null;
            }
            if (str != null) {
                charArray = str.toCharArray();
                int i6 = $10 + 43;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                charArray = str;
            }
            char[] cArr = charArray;
            cm cmVar = new cm();
            char[] cArr2 = new char[i2];
            cmVar.component9 = 0;
            int i8 = $11 + 19;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            while (cmVar.component9 < i2) {
                cmVar.setPivotYN16904 = cArr[cmVar.component9];
                cArr2[cmVar.component9] = (char) (i3 + cmVar.setPivotYN16904);
                int i10 = cmVar.component9;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i10]), Integer.valueOf(component9)};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                    if (objComponent5 == null) {
                        j = 0;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(49 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 35725), 2878 - KeyEvent.keyCodeFromString(""), 463712212, false, $$c(0, (short) 0, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                    } else {
                        j = 0;
                    }
                    cArr2[i10] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {cmVar, cmVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1)) + 71, (char) (19666 - Color.alpha(0)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1905, -628726730, false, "v", new Class[]{Object.class, Object.class});
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
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(69 - ExpandableListView.getPackedPositionChild(0L), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 19666), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1906, -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent7).invoke(null, objArr4);
                }
                cArr2 = cArr4;
            }
            String str2 = new String(cArr2);
            int i11 = $10 + 87;
            $11 = i11 % 128;
            if (i11 % 2 != 0) {
                objArr[0] = str2;
            } else {
                obj.hashCode();
                throw null;
            }
        }

        private static Float component9(Location p0) {
            int i = 2 % 2;
            int i2 = vD14832N6715 + 83;
            D8871 = i2 % 128;
            int i3 = i2 % 2;
            if (Build.VERSION.SDK_INT < 26 || !p0.hasVerticalAccuracy()) {
                return null;
            }
            int i4 = vD14832N6715 + 45;
            D8871 = i4 % 128;
            int i5 = i4 % 2;
            Float fValueOf = Float.valueOf(p0.getVerticalAccuracyMeters());
            int i6 = vD14832N6715 + 69;
            D8871 = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = 49 / 0;
            }
            return fValueOf;
        }

        public static void D8871(long j, long j2) throws Throwable {
            int i = 2 % 2;
            int i2 = vD14832N6715 + GapComposerKt.nodeKey;
            D8871 = i2 % 128;
            int i3 = i2 % 2;
            long j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
            int i4 = vD14832N6715 + 27;
            D8871 = i4 % 128;
            int i5 = i4 % 2;
            try {
                Object[] objArr = {Long.valueOf(j3)};
                Object[] objArr2 = new Object[1];
                a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2, false, (Process.myPid() >> 22) + 7, "￨\uffff\u000f\ufffa\u0005\u000e\ufffe", 257 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr2);
                Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, objArr);
                Object obj = w.class.getField("INSTANCE").get(null);
                Method method2 = w.class.getMethod("D8871", null);
                method2.setAccessible(true);
                Object objInvoke2 = method2.invoke(obj, null);
                Object[] objArr3 = new Object[1];
                a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 3, false, 3 - View.MeasureSpec.getMode(0), "\uffff\u0004\uffff", TextUtils.getOffsetBefore("", 0) + 204, objArr3);
                Object[] objArr4 = {(String) objArr3[0], objInvoke};
                Object[] objArr5 = new Object[1];
                a(3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), true, ExpandableListView.getPackedPositionChild(0L) + 4, "\u0001\u0002�", 270 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr5);
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
            vD14832N6715 = 0;
            D8871 = 1;
            component9 = 1125198910;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = Y16199;
        int i2 = (i ^ 49) + ((i & 49) << 1);
        kC4266 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 49 / 0;
        }
    }

    public final boolean equals(Object p0) {
        boolean z;
        int i = 2 % 2;
        if (this == p0) {
            int i2 = rP23717;
            int i3 = ((i2 | 123) << 1) - (i2 ^ 123);
            component10 = i3 % 128;
            int i4 = i3 % 2;
            return true;
        }
        if (!(p0 instanceof N11182)) {
            setOnLongClickListenerR17701.setPivotYN16904();
            setOnLongClickListenerR17701.setPivotYN16904();
            return false;
        }
        N11182 n11182 = (N11182) p0;
        if (Double.compare(this.D8871, n11182.D8871) != 0) {
            int i5 = rP23717 + GapComposerKt.nodeKey;
            component10 = i5 % 128;
            int i6 = i5 % 2;
            return false;
        }
        if (Double.compare(this.N14263A23323, n11182.N14263A23323) != 0) {
            int i7 = component10 + 119;
            rP23717 = i7 % 128;
            int i8 = i7 % 2;
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.component5, (Object) n11182.component5)) {
            int i9 = rP23717;
            int i10 = (i9 ^ 53) + ((i9 & 53) << 1);
            component10 = i10 % 128;
            int i11 = i10 % 2;
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.component9, (Object) n11182.component9)) {
            int i12 = rP23717 + 117;
            component10 = i12 % 128;
            return i12 % 2 != 0;
        }
        if (!Intrinsics.areEqual((Object) this.setTopP6481, (Object) n11182.setTopP6481)) {
            int i13 = rP23717;
            int i14 = ((i13 | 37) << 1) - (i13 ^ 37);
            component10 = i14 % 128;
            int i15 = i14 % 2;
            return false;
        }
        if (this.vD14832N6715 != n11182.vD14832N6715) {
            int i16 = component10;
            int i17 = (i16 & 77) + (i16 | 77);
            rP23717 = i17 % 128;
            int i18 = i17 % 2;
            return false;
        }
        if (this.component13 != n11182.component13) {
            int i19 = component10 + 73;
            int i20 = i19 % 128;
            rP23717 = i20;
            boolean z2 = i19 % 2 == 0;
            int i21 = (i20 & 75) + (i20 | 75);
            component10 = i21 % 128;
            int i22 = i21 % 2;
            return z2;
        }
        if (this.component8 != n11182.component8) {
            int i23 = component10;
            int i24 = (i23 & 59) + (i23 | 59);
            int i25 = i24 % 128;
            rP23717 = i25;
            z = i24 % 2 == 0;
            int i26 = ((i25 | 37) << 1) - (i25 ^ 37);
            component10 = i26 % 128;
            if (i26 % 2 == 0) {
                return z;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (this.sG29839 != n11182.sG29839) {
            return false;
        }
        if (Intrinsics.areEqual(this.setPivotYN16904, n11182.setPivotYN16904)) {
            return true;
        }
        int i27 = component10;
        int i28 = ((i27 | 87) << 1) - (i27 ^ 87);
        int i29 = i28 % 128;
        rP23717 = i29;
        z = i28 % 2 == 0;
        int i30 = (i29 ^ 115) + ((i29 & 115) << 1);
        component10 = i30 % 128;
        int i31 = i30 % 2;
        return z;
    }

    public final int hashCode() {
        int pivotYN16904 = setOnLongClickListenerR17701.setPivotYN16904();
        int pivotYN16905 = setOnLongClickListenerR17701.setPivotYN16904();
        return ((Integer) component9(setOnLongClickListenerR17701.setPivotYN16904(), -96446175, setOnLongClickListenerR17701.setPivotYN16904(), 96446176, pivotYN16905, pivotYN16904, new Object[]{this})).intValue();
    }

    public final Map<String, Object> setPivotYN16904() {
        int pivotYN16904 = setOnLongClickListenerR17701.setPivotYN16904();
        int pivotYN16905 = setOnLongClickListenerR17701.setPivotYN16904();
        return (Map) component9(setOnLongClickListenerR17701.setPivotYN16904(), 1202698205, setOnLongClickListenerR17701.setPivotYN16904(), -1202698205, pivotYN16905, pivotYN16904, new Object[]{this});
    }
}
