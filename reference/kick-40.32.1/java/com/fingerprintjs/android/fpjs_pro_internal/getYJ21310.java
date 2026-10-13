package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.fingerprintjs.android.fpjs_pro.ApiKeyExpired;
import com.fingerprintjs.android.fpjs_pro.ApiKeyNotFound;
import com.fingerprintjs.android.fpjs_pro.ApiKeyRequired;
import com.fingerprintjs.android.fpjs_pro.ClientTimeout;
import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.Failed;
import com.fingerprintjs.android.fpjs_pro.FingerprintJSProResponse;
import com.fingerprintjs.android.fpjs_pro.HeaderRestricted;
import com.fingerprintjs.android.fpjs_pro.InstallationMethodRestricted;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationHeaders;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationSecret;
import com.fingerprintjs.android.fpjs_pro.NetworkError;
import com.fingerprintjs.android.fpjs_pro.NotAvailableForCrawlBots;
import com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA;
import com.fingerprintjs.android.fpjs_pro.OriginNotAvailable;
import com.fingerprintjs.android.fpjs_pro.PackageNotAuthorized;
import com.fingerprintjs.android.fpjs_pro.ProxyIntegrationSecretEnvironmentMismatch;
import com.fingerprintjs.android.fpjs_pro.RequestCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.RequestTimeout;
import com.fingerprintjs.android.fpjs_pro.ResponseCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.SubscriptionNotActive;
import com.fingerprintjs.android.fpjs_pro.TooManyRequest;
import com.fingerprintjs.android.fpjs_pro.UnknownError;
import com.fingerprintjs.android.fpjs_pro.UnsupportedVersion;
import com.fingerprintjs.android.fpjs_pro.WrongRegion;
import com.google.android.gms.cast.MediaError;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes6.dex */
public final class getYJ21310 implements getLeftK29400 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int component13;
    public static int component5;
    public static int component9;
    private static int setTopP6481;
    private final Object D8871;
    private final getRightG17489 component8;
    private final setAutofillHintsI14457 sG29839;
    private final component6.vD14832N6715 setPivotYN16904;
    private final unregisterForContextMenu vD14832N6715;

    private static void a(int i, byte b, byte b2, Object[] objArr) {
        int i2 = 3 - (b * 4);
        int i3 = (i * 2) + 115;
        byte[] bArr = $$a;
        int i4 = b2 * 4;
        byte[] bArr2 = new byte[i4 + 15];
        int i5 = i4 + 14;
        int i6 = -1;
        if (bArr == null) {
            i3 = (i5 + (-i3)) - 5;
            i2 = i2;
            i6 = -1;
        }
        while (true) {
            int i7 = i2 + 1;
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i7])) - 5;
            i2 = i7;
            i6 = i8;
        }
    }

    public static /* synthetic */ Object component5(int i, int i2, int i3, Object[] objArr, int i4, int i5, int i6) {
        int i7 = ~i;
        int i8 = ~i2;
        int i9 = i7 | i8;
        int i10 = ~(i9 | i6);
        int i11 = ~i6;
        int i12 = (~(i7 | i2)) | (~(i8 | i11)) | (~(i8 | i));
        int i13 = ~(i11 | i9);
        int i14 = i + i2 + i5 + (1938118820 * i3) + ((-1869228383) * i4);
        int i15 = i14 * i14;
        int i16 = (i * (-1046486968)) + 2037645312 + ((-1046486968) * i2) + (1604861810 * i10) + (i12 * (-1345052743)) + ((-1345052743) * i13) + (1903427584 * i5) + ((-1907359744) * i3) + (1374945280 * i4) + (1516044288 * i15);
        int i17 = ((i * 647972376) - 1941852458) + (i2 * 647972376) + (i10 * 1702) + (i12 * 851) + (i13 * 851) + (i5 * 647973227) + (i3 * (-1260466036)) + (i4 * 1557372491) + (i15 * 1239351296);
        int i18 = i16 + (i17 * i17 * 490405888);
        if (i18 == 1) {
            return component5(objArr);
        }
        if (i18 != 2) {
            if (i18 == 3) {
                return vD14832N6715(objArr);
            }
            if (i18 != 4) {
                return i18 != 5 ? setPivotYN16904(objArr) : component9(objArr);
            }
            return D8871(objArr);
        }
        getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        int i19 = 2 % 2;
        int i20 = setTopP6481;
        int i21 = i20 & 1;
        int i22 = -(-(i20 | 1));
        int i23 = (i21 & i22) + (i22 | i21);
        int i24 = i23 % 128;
        component13 = i24;
        int i25 = i23 % 2;
        component6.vD14832N6715 vd14832n6715 = getyj21310.setPivotYN16904;
        int i26 = ((i24 & 3) - (~(-(-(3 | i24))))) - 1;
        setTopP6481 = i26 % 128;
        int i27 = i26 % 2;
        return vd14832n6715;
    }

    static void init$0() {
        $$a = new byte[]{98, -108, 56, -31, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9};
        $$b = 151;
    }

    public getYJ21310(Object obj, component6.vD14832N6715 vd14832n6715, unregisterForContextMenu unregisterforcontextmenu, setAutofillHintsI14457 setautofillhintsi14457, getRightG17489 getrightg17489) {
        this.D8871 = obj;
        this.setPivotYN16904 = vd14832n6715;
        this.vD14832N6715 = unregisterforcontextmenu;
        this.sG29839 = setautofillhintsi14457;
        this.component8 = getrightg17489;
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        int i = 2 % 2;
        int i2 = component13;
        int i3 = i2 & 103;
        int i4 = ((i2 ^ 103) | i3) << 1;
        int i5 = -((~i3) & (i2 | 103));
        int i6 = (i4 ^ i5) + ((i4 & i5) << 1);
        setTopP6481 = i6 % 128;
        int i7 = i6 % 2;
        setAutofillHintsI14457 setautofillhintsi14457 = getyj21310.sG29839;
        int i8 = (i2 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i2 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        setTopP6481 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 78 / 0;
        }
        return setautofillhintsi14457;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = i2 + 123;
        component13 = i3 % 128;
        int i4 = i3 % 2;
        getRightG17489 getrightg17489 = getyj21310.component8;
        int i5 = (i2 & (-66)) | ((~i2) & 65);
        int i6 = (i2 & 65) << 1;
        int i7 = (i5 & i6) + (i6 | i5);
        component13 = i7 % 128;
        if (i7 % 2 == 0) {
            return getrightg17489;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = ((i2 ^ 51) | (i2 & 51)) << 1;
        int i4 = -(((~i2) & 51) | (i2 & (-52)));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        int i6 = i5 % 128;
        component13 = i6;
        int i7 = i5 % 2;
        Object obj = getyj21310.D8871;
        int i8 = ((i6 | 85) << 1) - (i6 ^ 85);
        setTopP6481 = i8 % 128;
        if (i8 % 2 != 0) {
            return obj;
        }
        Object obj2 = null;
        obj2.hashCode();
        throw null;
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        int i = 2 % 2;
        int i2 = component13;
        int i3 = (i2 & 95) + (i2 | 95);
        int i4 = i3 % 128;
        setTopP6481 = i4;
        int i5 = i3 % 2;
        unregisterForContextMenu unregisterforcontextmenu = getyj21310.vD14832N6715;
        int i6 = (((i4 | 6) << 1) - (i4 ^ 6)) - 1;
        component13 = i6 % 128;
        if (i6 % 2 == 0) {
            return unregisterforcontextmenu;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x007c  */
    /* JADX WARN: Code duplicated, block: B:12:0x007f  */
    /* JADX WARN: Code duplicated, block: B:9:0x0047  */
    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ Object D8871(Object[] objArr) throws Throwable {
        Long lValueOf;
        int i;
        long jLongValue;
        UnknownError unknownError;
        final getYJ21310 getyj21310 = (getYJ21310) objArr[0];
        Long l = (Long) objArr[1];
        Integer num = (Integer) objArr[2];
        final Map map = (Map) objArr[3];
        final String str = (String) objArr[4];
        int i2 = 2 % 2;
        int i3 = component13;
        int i4 = (i3 | 63) << 1;
        int i5 = -(((~i3) & 63) | (i3 & (-64)));
        int i6 = (i4 & i5) + (i5 | i4);
        setTopP6481 = i6 % 128;
        if (i6 % 2 == 0) {
            az.Companion component5Var = az.INSTANCE;
            int i7 = 1 / 0;
            if (num != null) {
                int i8 = component13;
                int i9 = i8 & 103;
                int i10 = ((((i8 ^ 103) | i9) << 1) - (~(-((i8 | 103) & (~i9))))) - 1;
                setTopP6481 = i10 % 128;
                int i11 = i10 % 2;
                lValueOf = Long.valueOf(num.intValue());
                int i12 = component13;
                int i13 = i12 & 25;
                int i14 = -(-((i12 ^ 25) | i13));
                i = (i13 ^ i14) + ((i14 & i13) << 1);
                setTopP6481 = i % 128;
                if (i % 2 == 0) {
                    int i15 = 5 % 5;
                }
            } else {
                int i16 = setTopP6481;
                int i17 = ((i16 & 62) + (i16 | 62)) - 1;
                component13 = i17 % 128;
                int i18 = i17 % 2;
                lValueOf = null;
            }
        } else {
            az.Companion component5Var2 = az.INSTANCE;
            if (num != null) {
                int i19 = component13;
                int i20 = i19 & 103;
                int i110 = ((((i19 ^ 103) | i20) << 1) - (~(-((i19 | 103) & (~i20))))) - 1;
                setTopP6481 = i110 % 128;
                int i111 = i110 % 2;
                lValueOf = Long.valueOf(num.intValue());
                int i112 = component13;
                int i113 = i112 & 25;
                int i114 = -(-((i112 ^ 25) | i113));
                i = (i113 ^ i114) + ((i114 & i113) << 1);
                setTopP6481 = i % 128;
                if (i % 2 == 0) {
                    int i115 = 5 % 5;
                }
            } else {
                int i116 = setTopP6481;
                int i117 = ((i116 & 62) + (i116 | 62)) - 1;
                component13 = i117 % 128;
                int i118 = i117 % 2;
                lValueOf = null;
            }
        }
        final az azVarD8871 = az.Companion.D8871(lValueOf, l);
        final K5264 k5264 = new K5264(null, null, num, 0, l, null, null, null, null, null, 1003, null);
        Long lComponent9 = azVarD8871.component9();
        if (lComponent9 != null) {
            int i21 = component13;
            int i22 = ((i21 | 93) << 1) - (((~i21) & 93) | (i21 & (-94)));
            setTopP6481 = i22 % 128;
            int i23 = i22 % 2;
            jLongValue = lComponent9.longValue();
            int i24 = setTopP6481;
            int i25 = ((i24 & (-94)) | ((~i24) & 93)) + ((i24 & 93) << 1);
            component13 = i25 % 128;
            int i26 = i25 % 2;
        } else {
            int i27 = setTopP6481;
            int i28 = i27 & 9;
            int i29 = ((i27 ^ 9) | i28) << 1;
            int i30 = -((i27 | 9) & (~i28));
            int i31 = ((i29 | i30) << 1) - (i30 ^ i29);
            component13 = i31 % 128;
            int i32 = i31 % 2;
            jLongValue = Long.MAX_VALUE;
        }
        try {
            Object[] objArr2 = {Long.valueOf(jLongValue), true, false, new Function1<Object, D8871<? extends FingerprintJSProResponse, ? extends Error>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.3
                private static int $N14263A23323 = 1;
                private static int $setTopP6481;

                public static /* synthetic */ Object D8871(int i33, Object[] objArr3, int i34, int i35, int i36, int i37, int i38) {
                    int i39 = ~i34;
                    int i40 = ~i33;
                    int i41 = ~(i39 | i40);
                    int i42 = (~(i39 | i37)) | i41;
                    int i43 = (~((~i37) | i39 | i33)) | (~(i40 | i34));
                    int i44 = i34 + i33 + i36 + (531708263 * i35) + ((-608630064) * i38);
                    int i45 = i44 * i44;
                    int i46 = (i34 * (-228234701)) + 730857472 + ((-228234701) * i33) + (i41 * (-1010133554)) + (i42 * (-1010133554)) + ((-1010133554) * i43) + ((-1238368256) * i36) + ((-45088768) * i35) + ((-419430400) * i38) + ((-1471938560) * i45);
                    int i47 = ((i34 * (-1679524527)) - 150938974) + (i33 * (-1679524527)) + (i41 * 282) + (i42 * 282) + (i43 * 282) + (i36 * (-1679524245)) + (i35 * (-166744051)) + (i38 * 2062148848) + (i45 * (-865337344));
                    return i46 + ((i47 * i47) * (-1617166336)) != 1 ? vD14832N6715(objArr3) : component5(objArr3);
                }

                private static /* synthetic */ Object vD14832N6715(Object[] objArr3) {
                    AnonymousClass3 anonymousClass3 = (AnonymousClass3) objArr3[0];
                    Object obj = objArr3[1];
                    int i33 = 2 % 2;
                    int i34 = $setTopP6481;
                    int i35 = (((i34 | 16) << 1) - (i34 ^ 16)) - 1;
                    $N14263A23323 = i35 % 128;
                    int i36 = i35 % 2;
                    D8871 d8871 = (D8871) D8871(-1684783905, new Object[]{anonymousClass3, obj}, 1684783906, H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904(), H16981.setPivotYN16904());
                    int i37 = $N14263A23323;
                    int i38 = i37 & 121;
                    int i39 = (i37 ^ 121) | i38;
                    int i40 = (i38 & i39) + (i39 | i38);
                    $setTopP6481 = i40 % 128;
                    if (i40 % 2 == 0) {
                        return d8871;
                    }
                    throw null;
                }

                /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310$3$2, reason: invalid class name */
                @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p0", "", "D8871", "(I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
                static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
                    private static int $D8871 = 1;
                    private static int $component9;
                    public static int component5;
                    public static int setPivotYN16904;
                    private /* synthetic */ K5264 $vD14832N6715;

                    public static /* synthetic */ Object component9(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
                        int i7 = ~i4;
                        int i8 = ~i5;
                        int i9 = ~i3;
                        int i10 = (~(i8 | i9)) | i7;
                        int i11 = (~(i3 | i5)) | (~(i7 | i9));
                        int i12 = ~(i9 | i4 | i5);
                        int i13 = i4 + i5 + i + ((-194346734) * i2) + (9035316 * i6);
                        int i14 = i13 * i13;
                        int i15 = (((-787818500) * i4) - 443744256) + ((-1492047866) * i5) + (352114683 * i10) + (i11 * (-352114683)) + ((-352114683) * i12) + ((-1139933184) * i) + (1190920192 * i2) + (1456996352 * i6) + ((-1774911488) * i14);
                        int i16 = (i4 * 1174986172) + 1294669563 + (i5 * 1174986598) + (i10 * (-213)) + (i11 * 213) + (i12 * 213) + (i * 1174986385) + (i2 * (-1060063438)) + (i6 * 107475828) + (i14 * 168099840);
                        return i15 + ((i16 * i16) * 40566784) != 1 ? vD14832N6715(objArr) : component9(objArr);
                    }

                    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
                        AnonymousClass2 anonymousClass2 = (AnonymousClass2) objArr[0];
                        Object obj = objArr[1];
                        int i = 2 % 2;
                        int i2 = $D8871;
                        int i3 = ((i2 & 55) - (~(i2 | 55))) - 1;
                        $component9 = i3 % 128;
                        int i4 = i3 % 2;
                        Object[] objArr2 = {anonymousClass2, Integer.valueOf(((Number) obj).intValue())};
                        component9(A22588.vD14832N6715(), A22588.vD14832N6715(), A22588.vD14832N6715(), 1498980325, objArr2, -1498980324, A22588.vD14832N6715());
                        Unit unit = Unit.INSTANCE;
                        int i5 = $D8871;
                        int i6 = i5 & 105;
                        int i7 = -(-(i5 | 105));
                        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
                        $component9 = i8 % 128;
                        if (i8 % 2 == 0) {
                            return unit;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    private static /* synthetic */ Object component9(Object[] objArr) {
                        AnonymousClass2 anonymousClass2 = (AnonymousClass2) objArr[0];
                        ((Number) objArr[1]).intValue();
                        int i = 2 % 2;
                        int i2 = $D8871 + 6;
                        int i3 = (i2 ^ (-1)) + (i2 << 1);
                        $component9 = i3 % 128;
                        int i4 = i3 % 2;
                        anonymousClass2.$vD14832N6715.setPivotYN16904 = ax.D8871();
                        int i5 = $component9;
                        int i6 = ((i5 & (-36)) | ((~i5) & 35)) + ((i5 & 35) << 1);
                        $D8871 = i6 % 128;
                        if (i6 % 2 != 0) {
                            return null;
                        }
                        throw null;
                    }

                    public static int component9() {
                        int i = setPivotYN16904;
                        int i2 = i % 6495347;
                        setPivotYN16904 = i + 1;
                        if (i2 != 0) {
                            return component5;
                        }
                        int iMyPid = Process.myPid();
                        component5 = iMyPid;
                        return iMyPid;
                    }

                    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        int iVD14832N6715 = A22588.vD14832N6715();
                        ?? Component9 = component9(A22588.vD14832N6715(), A22588.vD14832N6715(), iVD14832N6715, -768987008, new Object[]{this, num}, 768987008, A22588.vD14832N6715());
                        return Component9;
                    }

                    public final void D8871(int i) {
                        Object[] objArr = {this, Integer.valueOf(i)};
                        component9(A22588.vD14832N6715(), A22588.vD14832N6715(), A22588.vD14832N6715(), 1498980325, objArr, -1498980324, A22588.vD14832N6715());
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(K5264 k5264) {
                        super(1);
                        this.$vD14832N6715 = k5264;
                    }
                }

                /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310$3$1, reason: invalid class name */
                @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "component5", "()V"}, k = 3, mv = {1, 9, 0}, xi = 48)
                static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                    private static final byte[] $$a = null;
                    private static final int $$b = 0;
                    private static final byte[] $$c = null;
                    private static final int $$d = 0;
                    private static int $10;
                    private static int $11;
                    private static int $sG29839;
                    private static int $vD14832N6715;
                    private static char[] D8871;
                    private static char component5;
                    private static long setPivotYN16904;
                    private /* synthetic */ K5264 $component9;

                    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    private static java.lang.String $$e(int r7, int r8, byte r9) {
                        /*
                            int r9 = r9 * 3
                            int r9 = 1 - r9
                            int r8 = r8 * 4
                            int r8 = r8 + 4
                            int r7 = 121 - r7
                            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.AnonymousClass3.AnonymousClass1.$$c
                            byte[] r1 = new byte[r9]
                            r2 = 0
                            if (r0 != 0) goto L15
                            r3 = r8
                            r7 = r9
                            r4 = r2
                            goto L28
                        L15:
                            r3 = r2
                        L16:
                            int r4 = r3 + 1
                            byte r5 = (byte) r7
                            r1[r3] = r5
                            if (r4 != r9) goto L23
                            java.lang.String r7 = new java.lang.String
                            r7.<init>(r1, r2)
                            return r7
                        L23:
                            r3 = r0[r8]
                            r6 = r3
                            r3 = r8
                            r8 = r6
                        L28:
                            int r7 = r7 + r8
                            int r8 = r3 + 1
                            r3 = r4
                            goto L16
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.AnonymousClass3.AnonymousClass1.$$e(int, int, byte):java.lang.String");
                    }

                    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    private static void a(int r5, byte r6, byte r7, java.lang.Object[] r8) {
                        /*
                            int r7 = r7 * 3
                            int r0 = r7 + 1
                            int r5 = 100 - r5
                            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.AnonymousClass3.AnonymousClass1.$$a
                            int r6 = r6 * 3
                            int r6 = 6 - r6
                            byte[] r0 = new byte[r0]
                            r2 = 0
                            if (r1 != 0) goto L14
                            r4 = r7
                            r3 = r2
                            goto L28
                        L14:
                            r3 = r2
                        L15:
                            byte r4 = (byte) r5
                            r0[r3] = r4
                            int r6 = r6 + 1
                            if (r3 != r7) goto L24
                            java.lang.String r5 = new java.lang.String
                            r5.<init>(r0, r2)
                            r8[r2] = r5
                            return
                        L24:
                            int r3 = r3 + 1
                            r4 = r1[r6]
                        L28:
                            int r4 = -r4
                            int r5 = r5 + r4
                            int r5 = r5 + 6
                            goto L15
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.AnonymousClass3.AnonymousClass1.a(int, byte, byte, java.lang.Object[]):void");
                    }

                    static void init$0() {
                        $$a = new byte[]{Ascii.DC2, 101, -47, 119, -6, 5, -3};
                        $$b = 113;
                    }

                    static void init$1() {
                        $$c = new byte[]{60, -23, -65, -5};
                        $$d = WebmConstants.MkvEbmlElement.CUE_TRACK;
                    }

                    public static /* synthetic */ Object setPivotYN16904(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
                        int i7 = ~i5;
                        int i8 = (~(i7 | i4)) | i;
                        int i9 = ~i;
                        int i10 = ~(i7 | i9);
                        int i11 = ~i4;
                        int i12 = i10 | (~(i9 | i11));
                        int i13 = (~(i4 | i9)) | (~(i7 | i11));
                        int i14 = i5 + i + i2 + (417615942 * i6) + (566850886 * i3);
                        int i15 = i14 * i14;
                        int i16 = ((-370608051) * i5) + 147849216 + ((-2147356519) * i) + (i8 * 1776748468) + (i12 * 1776748468) + (1776748468 * i13) + (1406140416 * i2) + ((-354418688) * i6) + ((-85983232) * i3) + ((-608960512) * i15);
                        int i17 = (i5 * (-1357469509)) + 140661806 + (i * (-1357469617)) + (i8 * AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) + (i12 * AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) + (i13 * AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) + (i2 * (-1357469401)) + (i6 * 1137340586) + (i3 * 304092074) + (i15 * 1282146304);
                        if (i16 + (i17 * i17 * 1158414336) != 1) {
                            AnonymousClass1 anonymousClass1 = (AnonymousClass1) objArr[0];
                            int i18 = 2 % 2;
                            int i19 = (-2) - (($vD14832N6715 + 22) ^ (-1));
                            $sG29839 = i19 % 128;
                            int i20 = i19 % 2;
                            anonymousClass1.$component9.component13 = ax.D8871();
                            int i21 = $vD14832N6715;
                            int i22 = ((i21 | 27) << 1) - (i21 ^ 27);
                            $sG29839 = i22 % 128;
                            int i23 = i22 % 2;
                            return null;
                        }
                        AnonymousClass1 anonymousClass2 = (AnonymousClass1) objArr[0];
                        int i24 = 2 % 2;
                        int i25 = $vD14832N6715 + 61;
                        $sG29839 = i25 % 128;
                        int i26 = i25 % 2;
                        int iVD14832N6715 = qU20128.vD14832N6715();
                        int iVD14832N6716 = qU20128.vD14832N6715();
                        int iVD14832N6717 = qU20128.vD14832N6715();
                        setPivotYN16904(1266355863, iVD14832N6716, qU20128.vD14832N6715(), iVD14832N6715, new Object[]{anonymousClass2}, -1266355863, iVD14832N6717);
                        Unit unit = Unit.INSTANCE;
                        int i27 = $vD14832N6715;
                        int i28 = i27 ^ 115;
                        int i29 = (i27 & 115) << 1;
                        int i30 = ((i28 | i29) << 1) - (i29 ^ i28);
                        $sG29839 = i30 % 128;
                        int i31 = i30 % 2;
                        return unit;
                    }

                    private static void b(String str, int i, Object[] objArr) throws Throwable {
                        char[] charArray;
                        int i2;
                        int i3;
                        int i4 = 2 % 2;
                        if (str != null) {
                            int i5 = $10 + 23;
                            $11 = i5 % 128;
                            int i6 = i5 % 2;
                            charArray = str.toCharArray();
                        } else {
                            charArray = str;
                        }
                        char[] cArr = charArray;
                        cb cbVar = new cb();
                        cbVar.setPivotYN16904 = i;
                        int length = cArr.length;
                        long[] jArr = new long[length];
                        cbVar.D8871 = 0;
                        while (cbVar.D8871 < cArr.length) {
                            int i7 = cbVar.D8871;
                            try {
                                Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                                if (objComponent5 == null) {
                                    i2 = 55223;
                                    i3 = 2106881226;
                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getOffsetAfter("", 0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 60693), 5954 - TextUtils.lastIndexOf("", '0'), 148978589, false, $$e(15, 0, (byte) 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                                } else {
                                    i2 = 55223;
                                    i3 = 2106881226;
                                }
                                jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (setPivotYN16904 ^ (-1805496993403714128L));
                                Object[] objArr3 = {cbVar, cbVar};
                                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                                if (objComponent6 == null) {
                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (Color.alpha(0) + i2), 3268 - ExpandableListView.getPackedPositionChild(0L), 790704297, false, $$e((byte) ($$d & 25), 0, (byte) 0), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objComponent6).invoke(null, objArr3);
                                int i8 = $10 + 81;
                                $11 = i8 % 128;
                                int i9 = i8 % 2;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        char[] cArr2 = new char[length];
                        cbVar.D8871 = 0;
                        while (cbVar.D8871 < cArr.length) {
                            cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                            Object[] objArr4 = {cbVar, cbVar};
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                            if (objComponent7 == null) {
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.green(0) + 52, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 55223), Drawable.resolveOpacity(0, 0) + 3269, 790704297, false, $$e((byte) ($$d & 25), 0, (byte) 0), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent7).invoke(null, objArr4);
                        }
                        objArr[0] = new String(cArr2);
                    }

                    private static void c(byte b, int i, String str, Object[] objArr) throws Throwable {
                        int i2;
                        char c = 2;
                        int i3 = 2 % 2;
                        int i4 = $11 + 123;
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                        char[] charArray = str != null ? str.toCharArray() : str;
                        ce ceVar = new ce();
                        char[] cArr = D8871;
                        int i6 = 1083735746;
                        if (cArr != null) {
                            int length = cArr.length;
                            char[] cArr2 = new char[length];
                            int i7 = 0;
                            while (i7 < length) {
                                try {
                                    Object[] objArr2 = {Integer.valueOf(cArr[i7])};
                                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(i6);
                                    if (objComponent5 == null) {
                                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 52;
                                        char edgeSlop = (char) (8065 - (ViewConfiguration.getEdgeSlop() >> 16));
                                        int iAlpha = 3217 - Color.alpha(0);
                                        byte length2 = (byte) $$c.length;
                                        byte b2 = (byte) (length2 - 4);
                                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout, edgeSlop, iAlpha, 304954017, false, $$e(length2, b2, b2), new Class[]{Integer.TYPE});
                                    }
                                    cArr2[i7] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                                    i7++;
                                    i6 = i6;
                                    c = c;
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            }
                            cArr = cArr2;
                        }
                        char c2 = c;
                        int i8 = i6;
                        Object[] objArr3 = {Integer.valueOf(component5)};
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i8);
                        if (objComponent6 == null) {
                            int trimmedLength = TextUtils.getTrimmedLength("") + 52;
                            char c3 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 8064);
                            int longPressTimeout = 3217 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            byte length3 = (byte) $$c.length;
                            byte b3 = (byte) (length3 - 4);
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(trimmedLength, c3, longPressTimeout, 304954017, false, $$e(length3, b3, b3), new Class[]{Integer.TYPE});
                        }
                        char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                        char[] cArr3 = new char[i];
                        if (i % 2 != 0) {
                            i2 = i - 1;
                            cArr3[i2] = (char) (charArray[i2] - b);
                        } else {
                            i2 = i;
                        }
                        int i9 = 1;
                        if (i2 > 1) {
                            ceVar.component5 = 0;
                            while (ceVar.component5 < i2) {
                                ceVar.D8871 = charArray[ceVar.component5];
                                ceVar.setPivotYN16904 = charArray[ceVar.component5 + i9];
                                if (ceVar.D8871 == ceVar.setPivotYN16904) {
                                    cArr3[ceVar.component5] = (char) (ceVar.D8871 - b);
                                    cArr3[ceVar.component5 + i9] = (char) (ceVar.setPivotYN16904 - b);
                                    i9 = i9;
                                } else {
                                    Object[] objArr4 = new Object[13];
                                    objArr4[12] = ceVar;
                                    objArr4[11] = Integer.valueOf(cCharValue);
                                    objArr4[10] = ceVar;
                                    objArr4[9] = ceVar;
                                    objArr4[8] = Integer.valueOf(cCharValue);
                                    objArr4[7] = ceVar;
                                    objArr4[6] = ceVar;
                                    objArr4[5] = Integer.valueOf(cCharValue);
                                    objArr4[4] = ceVar;
                                    objArr4[3] = ceVar;
                                    objArr4[c2] = Integer.valueOf(cCharValue);
                                    objArr4[i9] = ceVar;
                                    objArr4[0] = ceVar;
                                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                                    if (objComponent7 == null) {
                                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 47644), 5214 - KeyEvent.getDeadChar(0, 0), 309857053, false, $$e(0, 0, (byte) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                    }
                                    if (((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue() == ceVar.component13) {
                                        Object[] objArr5 = new Object[11];
                                        objArr5[10] = ceVar;
                                        objArr5[9] = Integer.valueOf(cCharValue);
                                        objArr5[8] = ceVar;
                                        objArr5[7] = Integer.valueOf(cCharValue);
                                        objArr5[6] = Integer.valueOf(cCharValue);
                                        objArr5[5] = ceVar;
                                        objArr5[4] = ceVar;
                                        objArr5[3] = Integer.valueOf(cCharValue);
                                        objArr5[c2] = Integer.valueOf(cCharValue);
                                        objArr5[i9] = ceVar;
                                        objArr5[0] = ceVar;
                                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                                        if (objComponent8 == null) {
                                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.lastIndexOf("", '0', 0, 0) + 53, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 5576 - TextUtils.getOffsetBefore("", 0), 999494287, false, $$e((byte) ($$d & 62), 0, (byte) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                        }
                                        int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                                        int i10 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                        cArr3[ceVar.component5] = cArr[iIntValue];
                                        cArr3[ceVar.component5 + 1] = cArr[i10];
                                    } else if (ceVar.component9 == ceVar.vD14832N6715) {
                                        int i11 = $11 + 19;
                                        $10 = i11 % 128;
                                        int i12 = i11 % 2;
                                        ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                                        ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                                        int i13 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                                        int i14 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                        cArr3[ceVar.component5] = cArr[i13];
                                        cArr3[ceVar.component5 + 1] = cArr[i14];
                                    } else {
                                        int i15 = (ceVar.component9 * cCharValue) + ceVar.component13;
                                        int i16 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                                        cArr3[ceVar.component5] = cArr[i15];
                                        cArr3[ceVar.component5 + 1] = cArr[i16];
                                    }
                                }
                                ceVar.component5 += 2;
                                int i17 = $11 + 101;
                                $10 = i17 % 128;
                                int i18 = i17 % 2;
                                i9 = i9;
                            }
                        }
                        int i19 = 0;
                        while (i19 < i) {
                            int i20 = $10;
                            int i21 = i20 + 59;
                            $11 = i21 % 128;
                            if (i21 % 2 == 0) {
                                cArr3[i19] = (char) (cArr3[i19] ^ 15478);
                                i19 += 115;
                            } else {
                                cArr3[i19] = (char) (cArr3[i19] ^ 13722);
                                i19++;
                            }
                            int i22 = i20 + 73;
                            $11 = i22 % 128;
                            int i23 = i22 % 2;
                        }
                        objArr[0] = new String(cArr3);
                    }

                    static {
                        init$1();
                        $10 = 0;
                        $11 = 1;
                        init$0();
                        $vD14832N6715 = 0;
                        $sG29839 = 1;
                        setPivotYN16904 = -9020700906323183810L;
                        D8871 = new char[]{14984, 15098, 15049, 14986, 15041, 15061, 15047, 15052, 15044, 14995, 14987, 15046, 15053, 15004, 15063, 15056, 14983, 15040, 15096, 15062, 15068, 14990, 15048, 15043, 15058, 15059, 14996, 14997, 14982, 15042, 15050, 15102, 15069, 15057, 15051, 15054};
                        component5 = (char) 3897;
                    }

                    /* JADX WARN: Code duplicated, block: B:143:0x1506  */
                    /* JADX WARN: Code duplicated, block: B:146:0x150c  */
                    /* JADX WARN: Code duplicated, block: B:149:0x1542 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:150:0x1589  */
                    /* JADX WARN: Code duplicated, block: B:154:0x1629  */
                    /* JADX WARN: Code duplicated, block: B:155:0x162b  */
                    /* JADX WARN: Code duplicated, block: B:159:0x1648  */
                    /* JADX WARN: Code duplicated, block: B:161:0x16cc A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:162:0x16cd  */
                    /* JADX WARN: Code duplicated, block: B:240:0x2042 A[Catch: all -> 0x21f8, TryCatch #11 {all -> 0x21f8, blocks: (B:238:0x2038, B:240:0x2042, B:241:0x2082), top: B:489:0x2038, outer: #3 }] */
                    /* JADX WARN: Code duplicated, block: B:243:0x208b  */
                    /* JADX WARN: Code duplicated, block: B:245:0x212b A[Catch: Exception -> 0x220a, TRY_ENTER, TryCatch #3 {Exception -> 0x220a, blocks: (B:225:0x1f6e, B:231:0x1fe1, B:233:0x2003, B:236:0x200c, B:237:0x200f, B:245:0x212b, B:251:0x2164, B:257:0x21e6, B:259:0x21ec, B:261:0x21f0, B:263:0x21f6, B:264:0x21f7, B:248:0x2148, B:266:0x21f9, B:268:0x21ff, B:269:0x2200, B:271:0x2202, B:273:0x2208, B:274:0x2209, B:226:0x1f8a, B:228:0x1f94, B:229:0x1fd6, B:252:0x218d, B:254:0x2197, B:255:0x21db, B:238:0x2038, B:240:0x2042, B:241:0x2082), top: B:480:0x1f6e, inners: #0, #10, #11 }] */
                    /* JADX WARN: Code duplicated, block: B:247:0x2146  */
                    /* JADX WARN: Code duplicated, block: B:248:0x2148 A[Catch: Exception -> 0x220a, TryCatch #3 {Exception -> 0x220a, blocks: (B:225:0x1f6e, B:231:0x1fe1, B:233:0x2003, B:236:0x200c, B:237:0x200f, B:245:0x212b, B:251:0x2164, B:257:0x21e6, B:259:0x21ec, B:261:0x21f0, B:263:0x21f6, B:264:0x21f7, B:248:0x2148, B:266:0x21f9, B:268:0x21ff, B:269:0x2200, B:271:0x2202, B:273:0x2208, B:274:0x2209, B:226:0x1f8a, B:228:0x1f94, B:229:0x1fd6, B:252:0x218d, B:254:0x2197, B:255:0x21db, B:238:0x2038, B:240:0x2042, B:241:0x2082), top: B:480:0x1f6e, inners: #0, #10, #11 }] */
                    /* JADX WARN: Code duplicated, block: B:250:0x2162  */
                    /* JADX WARN: Code duplicated, block: B:251:0x2164 A[Catch: Exception -> 0x220a, TRY_LEAVE, TryCatch #3 {Exception -> 0x220a, blocks: (B:225:0x1f6e, B:231:0x1fe1, B:233:0x2003, B:236:0x200c, B:237:0x200f, B:245:0x212b, B:251:0x2164, B:257:0x21e6, B:259:0x21ec, B:261:0x21f0, B:263:0x21f6, B:264:0x21f7, B:248:0x2148, B:266:0x21f9, B:268:0x21ff, B:269:0x2200, B:271:0x2202, B:273:0x2208, B:274:0x2209, B:226:0x1f8a, B:228:0x1f94, B:229:0x1fd6, B:252:0x218d, B:254:0x2197, B:255:0x21db, B:238:0x2038, B:240:0x2042, B:241:0x2082), top: B:480:0x1f6e, inners: #0, #10, #11 }] */
                    /* JADX WARN: Code duplicated, block: B:254:0x2197 A[Catch: all -> 0x21ef, TryCatch #10 {all -> 0x21ef, blocks: (B:252:0x218d, B:254:0x2197, B:255:0x21db), top: B:487:0x218d, outer: #3 }] */
                    /* JADX WARN: Code duplicated, block: B:257:0x21e6 A[Catch: Exception -> 0x220a, TRY_ENTER, TryCatch #3 {Exception -> 0x220a, blocks: (B:225:0x1f6e, B:231:0x1fe1, B:233:0x2003, B:236:0x200c, B:237:0x200f, B:245:0x212b, B:251:0x2164, B:257:0x21e6, B:259:0x21ec, B:261:0x21f0, B:263:0x21f6, B:264:0x21f7, B:248:0x2148, B:266:0x21f9, B:268:0x21ff, B:269:0x2200, B:271:0x2202, B:273:0x2208, B:274:0x2209, B:226:0x1f8a, B:228:0x1f94, B:229:0x1fd6, B:252:0x218d, B:254:0x2197, B:255:0x21db, B:238:0x2038, B:240:0x2042, B:241:0x2082), top: B:480:0x1f6e, inners: #0, #10, #11 }] */
                    /* JADX WARN: Code duplicated, block: B:349:0x2a19  */
                    /* JADX WARN: Code duplicated, block: B:351:0x2a7f  */
                    /* JADX WARN: Code duplicated, block: B:354:0x2a89 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:358:0x2b7b  */
                    /* JADX WARN: Code duplicated, block: B:361:0x2c05  */
                    /* JADX WARN: Code duplicated, block: B:364:0x2c0f A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:368:0x2cec  */
                    /* JADX WARN: Code duplicated, block: B:369:0x2cf3  */
                    /* JADX WARN: Code duplicated, block: B:371:0x2cf6  */
                    /* JADX WARN: Code duplicated, block: B:372:0x2d65  */
                    /* JADX WARN: Code duplicated, block: B:375:0x2d6e A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:379:0x2e3c  */
                    /* JADX WARN: Code duplicated, block: B:380:0x2ea5  */
                    /* JADX WARN: Code duplicated, block: B:383:0x2eaf A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:387:0x2f85  */
                    /* JADX WARN: Code duplicated, block: B:388:0x3008  */
                    /* JADX WARN: Code duplicated, block: B:391:0x3012 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:395:0x3104  */
                    /* JADX WARN: Code duplicated, block: B:396:0x316b  */
                    /* JADX WARN: Code duplicated, block: B:399:0x31fb A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:400:0x31fc A[Catch: all -> 0x3c04, TRY_ENTER, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:402:0x320d A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:406:0x3300  */
                    /* JADX WARN: Code duplicated, block: B:408:0x3360  */
                    /* JADX WARN: Code duplicated, block: B:411:0x3369 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:415:0x3449  */
                    /* JADX WARN: Code duplicated, block: B:417:0x34bd  */
                    /* JADX WARN: Code duplicated, block: B:420:0x3518 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:424:0x3606  */
                    /* JADX WARN: Code duplicated, block: B:426:0x369c  */
                    /* JADX WARN: Code duplicated, block: B:429:0x36c4 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:433:0x379c  */
                    /* JADX WARN: Code duplicated, block: B:435:0x3807  */
                    /* JADX WARN: Code duplicated, block: B:438:0x3811 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:442:0x38e0  */
                    /* JADX WARN: Code duplicated, block: B:444:0x3951  */
                    /* JADX WARN: Code duplicated, block: B:447:0x395c A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:451:0x3a32  */
                    /* JADX WARN: Code duplicated, block: B:453:0x3ae5  */
                    /* JADX WARN: Code duplicated, block: B:456:0x3b0c A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:55:0x0698 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:56:0x069a  */
                    /* JADX WARN: Code duplicated, block: B:59:0x06b2 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:63:0x0799 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:64:0x079b  */
                    /* JADX WARN: Code duplicated, block: B:67:0x07b3 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:71:0x0880  */
                    /* JADX WARN: Code duplicated, block: B:73:0x0886  */
                    /* JADX WARN: Code duplicated, block: B:76:0x08c5 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:80:0x0999  */
                    /* JADX WARN: Code duplicated, block: B:81:0x099b  */
                    /* JADX WARN: Code duplicated, block: B:83:0x09a1  */
                    /* JADX WARN: Code duplicated, block: B:86:0x0a27 A[Catch: all -> 0x3c04, TryCatch #1 {all -> 0x3c04, blocks: (B:3:0x0008, B:5:0x0011, B:6:0x0040, B:12:0x019b, B:14:0x01ac, B:16:0x01fc, B:20:0x0250, B:22:0x025f, B:24:0x02a2, B:28:0x0387, B:30:0x0391, B:31:0x03d0, B:33:0x03f3, B:35:0x03fd, B:36:0x0441, B:38:0x044a, B:40:0x0462, B:42:0x04a7, B:74:0x08b8, B:76:0x08c5, B:77:0x0906, B:84:0x0a1d, B:86:0x0a27, B:87:0x0a65, B:49:0x056b, B:51:0x0582, B:52:0x05c4, B:57:0x069b, B:59:0x06b2, B:60:0x06f1, B:65:0x079c, B:67:0x07b3, B:68:0x07f6, B:94:0x103d, B:96:0x1047, B:98:0x108a, B:106:0x1116, B:108:0x1120, B:109:0x1163, B:111:0x1189, B:113:0x1193, B:115:0x11da, B:118:0x11f2, B:120:0x1209, B:122:0x124f, B:147:0x1535, B:149:0x1542, B:151:0x158b, B:130:0x1305, B:132:0x131c, B:133:0x1359, B:137:0x1418, B:139:0x1430, B:140:0x146d, B:166:0x1703, B:168:0x1710, B:169:0x1751, B:171:0x1826, B:173:0x1833, B:175:0x1878, B:185:0x19e3, B:187:0x19f0, B:189:0x1a39, B:191:0x1b07, B:193:0x1b14, B:195:0x1b56, B:212:0x1dff, B:214:0x1e0c, B:216:0x1e59, B:280:0x228f, B:282:0x2299, B:283:0x22da, B:295:0x2644, B:297:0x2651, B:299:0x26a0, B:309:0x2831, B:311:0x2854, B:312:0x289b, B:352:0x2a83, B:354:0x2a89, B:355:0x2ac9, B:400:0x31fc, B:402:0x320d, B:403:0x3252, B:409:0x3363, B:411:0x3369, B:412:0x33ab, B:418:0x34f3, B:420:0x3518, B:421:0x355c, B:427:0x36b7, B:429:0x36c4, B:430:0x3700, B:436:0x380b, B:438:0x3811, B:439:0x3851, B:445:0x3956, B:447:0x395c, B:448:0x399e, B:454:0x3ae6, B:456:0x3b0c, B:457:0x3b50, B:362:0x2c09, B:364:0x2c0f, B:365:0x2c4b, B:373:0x2d68, B:375:0x2d6e, B:376:0x2da3, B:381:0x2ea9, B:383:0x2eaf, B:384:0x2eea, B:389:0x300c, B:391:0x3012, B:392:0x304e), top: B:478:0x0008 }] */
                    /* JADX WARN: Code duplicated, block: B:90:0x0a97  */
                    public static Object[] component9$6ed60776(int i, Object obj) throws Throwable {
                        float f;
                        int i2;
                        int i3;
                        int i4;
                        BufferedInputStream bufferedInputStream;
                        BufferedInputStream bufferedInputStream2;
                        int i5;
                        Object objComponent5;
                        int i6;
                        int i7;
                        Object objComponent6;
                        int i8;
                        int i9;
                        int i10;
                        int i11;
                        int i12;
                        Object objComponent7;
                        int i13;
                        int i14;
                        Object objComponent8;
                        int i15;
                        int i16;
                        Object objComponent9;
                        int i17;
                        int i18;
                        Object[] objArr;
                        int i19;
                        int i20;
                        Object objComponent10;
                        int i21;
                        int i22;
                        Object objComponent11;
                        int i23;
                        int i24;
                        Object objComponent12;
                        int i25;
                        int i26;
                        Object objComponent13;
                        long j;
                        int i27;
                        int i28;
                        Object objComponent14;
                        int i29;
                        int i30;
                        Object objComponent15;
                        int i31;
                        int i32;
                        Object objComponent16;
                        Object objComponent17;
                        Object objInvoke;
                        int i33;
                        int i34;
                        int i35;
                        Object[] objArr2;
                        Object objComponent18;
                        String str;
                        int i36;
                        Object[] objArr3;
                        int i37;
                        int i38;
                        Object[] objArr4;
                        int i39;
                        Object objComponent19;
                        long j2;
                        int i40;
                        int i41;
                        Object objComponent20;
                        long j3;
                        int i42;
                        int i43;
                        Object objComponent21;
                        int i44;
                        int i45;
                        Object objComponent22;
                        int i46;
                        char c;
                        boolean zEquals;
                        Object objComponent23;
                        int i47;
                        int i48;
                        int i49 = 2 % 2;
                        try {
                            Object objComponent24 = setSystemGestureExclusionRectsL30479.component5(-1085873278);
                            if (objComponent24 == null) {
                                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 52;
                                char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                int iGreen = 2927 - Color.green(0);
                                byte b = (byte) ($$b & 7);
                                byte b2 = b;
                                Object[] objArr5 = new Object[1];
                                a(b, b2, b2, objArr5);
                                objComponent24 = setSystemGestureExclusionRectsL30479.vD14832N6715(edgeSlop, scrollDefaultDelay, iGreen, -302798879, false, (String) objArr5[0], new Class[0]);
                            }
                            long jLongValue = ((Long) ((Method) objComponent24).invoke(null, null)).longValue();
                            long j4 = (569735763 | jLongValue) ^ (-1);
                            long j5 = jLongValue ^ (-1);
                            long j6 = (j5 | (-569735764)) ^ (-1);
                            long j7 = i;
                            long j8 = (-227324569836L) + (399 * jLongValue) + ((j4 | j6 | ((j5 | j7) ^ (-1))) * 398) + (((-569735764) | jLongValue) * (-1194));
                            long j9 = j7 ^ (-1);
                            long j10 = j8 + ((((j5 | j9) ^ (-1)) | j4 | j6) * 398) + 775568105;
                            int i50 = ~i;
                            int i51 = 1439848624 | (~(2982725 | i50));
                            int i52 = ~((-2622214) | i);
                            int i53 = ((int) (j10 >> 32)) & ((-1608237366) + ((i51 | i52) * (-502)) + (((~(1442831349 | i50)) | i52) * 502));
                            int i54 = ((int) j10) & (((((~(491075350 | i)) | 538970241) * (-566)) - 1322748021) + ((~(1030045591 | i)) * 566));
                            if (((i53 & i54) | (i53 ^ i54)) != 0) {
                                Object[] objArr6 = {new int[1], null, new int[]{i}, new int[]{(i & (-272)) | (i50 & 271)}};
                                int iMyUid = Process.myUid();
                                int i55 = 556951302 + (((~((-403440137) | (~iMyUid))) | (~(426764254 | iMyUid))) * (-272)) + (((~((-422495053) | iMyUid)) | 19054916) * (-272)) + (((~(iMyUid | 422495052)) | 407709338) * 272);
                                int iVD14832N6715 = qU20128.vD14832N6715();
                                int i56 = -(-(i55 * (-115)));
                                int i57 = (((-1840) | i56) << 1) - (i56 ^ (-1840));
                                int i58 = ~iVD14832N6715;
                                int i59 = (~((i58 & 16) | (i58 ^ 16) | i55)) * (-116);
                                int i60 = (i57 ^ i59) + ((i59 & i57) << 1) + (((iVD14832N6715 ^ 16) | (iVD14832N6715 & 16)) * 116);
                                int i61 = ~i55;
                                int i62 = ~((-17) | i61);
                                int i63 = ~((iVD14832N6715 & i61) | (i61 ^ iVD14832N6715));
                                int i64 = -(-(((i63 & i62) | (i62 ^ i63)) * 116));
                                int i65 = (((i60 | i64) << 1) - (i64 ^ i60)) - 795555817;
                                int i66 = i65 << 13;
                                int i67 = (i66 & (~i65)) | ((~i66) & i65);
                                int i68 = i67 >>> 17;
                                int i69 = ((~i67) & i68) | ((~i68) & i67);
                                int i70 = i69 << 5;
                                ((int[]) objArr6[0])[0] = (i69 | i70) & (~(i69 & i70));
                                return objArr6;
                            }
                            Object[] objArr7 = new Object[1];
                            b("㋼\uda72\ue386譟那렣䆘滼癷ῗ❕", 59538 - (~Color.green(0)), objArr7);
                            Object[] objArr8 = {(String) objArr7[0]};
                            Object objComponent25 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                            if (objComponent25 == null) {
                                int longPressTimeout = 52 - (ViewConfiguration.getLongPressTimeout() >> 16);
                                char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 6474;
                                byte b3 = (byte) (-$$a[6]);
                                byte b4 = (byte) (b3 - 3);
                                Object[] objArr9 = new Object[1];
                                a(b3, b4, b4, objArr9);
                                objComponent25 = setSystemGestureExclusionRectsL30479.vD14832N6715(longPressTimeout, c2, bitsPerPixel, 1068791596, false, (String) objArr9[0], new Class[]{String.class});
                            }
                            Object objInvoke2 = ((Method) objComponent25).invoke(null, objArr8);
                            if (objInvoke2 != null) {
                                Object[] objArr10 = new Object[1];
                                f = 0.0f;
                                c((byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36), 4 - (~(-TextUtils.lastIndexOf("", '0'))), "\u0014\u000e#\n\r\u0010", objArr10);
                                String str2 = (String) objArr10[0];
                                int i71 = -TextUtils.lastIndexOf("", '0', 0);
                                int i72 = -(-View.MeasureSpec.makeMeasureSpec(0, 0));
                                int i73 = (i72 ^ 8) + ((i72 & 8) << 1);
                                Object[] objArr11 = new Object[1];
                                c((byte) (((i71 | 124) << 1) - (i71 ^ 124)), i73, "\u0018#\u0003\u0005\u0013\u000b\u0012\r", objArr11);
                                Object[] objArr12 = {objInvoke2, new String[]{str2, (String) objArr11[0]}};
                                Object objComponent26 = setSystemGestureExclusionRectsL30479.component5(-1259183077);
                                if (objComponent26 == null) {
                                    int i74 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 50;
                                    char c3 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 4307);
                                    int mirror = AndroidCharacter.getMirror('0') + 5701;
                                    byte b5 = (byte) ($$b & 7);
                                    byte b6 = b5;
                                    i41 = 0;
                                    Object[] objArr13 = new Object[1];
                                    a(b5, b6, b6, objArr13);
                                    objComponent26 = setSystemGestureExclusionRectsL30479.vD14832N6715(i74, c3, mirror, -431546248, false, (String) objArr13[0], new Class[]{String.class, String[].class});
                                } else {
                                    i41 = 0;
                                }
                                long jLongValue2 = ((Long) ((Method) objComponent26).invoke(null, objArr12)).longValue();
                                long j11 = (-1029542981440L) + ((-755) * jLongValue2);
                                long j12 = ((-1363633089) | (jLongValue2 ^ (-1))) ^ (-1);
                                long j13 = 1363633088 | jLongValue2;
                                long j14 = j11 + (1512 * j12) + ((-756) * (j12 | ((j13 | j7) ^ (-1)))) + (756 * (j13 | j9)) + 438362614;
                                int iNextInt = new Random().nextInt();
                                int i75 = ~iNextInt;
                                int i76 = (~(78698422 | i75)) | (-1593573368);
                                int i77 = ~(iNextInt | (-1049889));
                                int i78 = ((int) (j14 >> 32)) & ((-1657788974) + ((i76 | i77) * (-713)) + (i77 * 1426) + ((~((-1515924834) | i75)) * 713));
                                int i79 = (int) j14;
                                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                if ((i78 | (i79 & ((-1520785380) + (((~((~elapsedCpuTime) | (-11067448))) | 24626) * 529) + (((~(elapsedCpuTime | (-11067448))) | 1426158962) * 529)))) != 0) {
                                    int i80 = -ImageFormat.getBitsPerPixel(i41);
                                    int i81 = (i80 * 51) - 2928730;
                                    int i82 = ((i80 ^ i) | (i80 & i)) * (-50);
                                    int i83 = ((i81 | i82) << 1) - (i81 ^ i82);
                                    int i84 = ~i80;
                                    int i85 = (i84 & (-59771)) | (i84 ^ (-59771));
                                    int i86 = ~((i85 & i) | (i85 ^ i));
                                    int i87 = ~((-59771) | i50 | i80);
                                    int i88 = i83 + (((i86 & i87) | (i86 ^ i87)) * 50);
                                    int i89 = ~((-59771) | i50);
                                    int i90 = ~((-59771) | i80);
                                    int i91 = (i89 & i90) | (i89 ^ i90);
                                    int i92 = ~(i80 | i50);
                                    int i93 = -(-(((i92 & i91) | (i91 ^ i92)) * 50));
                                    int i94 = (i88 & i93) + (i93 | i88);
                                    Object[] objArr14 = new Object[1];
                                    b("㋼\udb9a\ue056躏霐붆䨈傦礵ީⱮ㪪쌫\ue9df\uf641鳝ꕟ돆塜曚འᗼ≮", i94, objArr14);
                                    Object[] objArr15 = {(String) objArr14[i41]};
                                    Object objComponent27 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                    if (objComponent27 == null) {
                                        int i95 = i41;
                                        int iMakeMeasureSpec = 52 - View.MeasureSpec.makeMeasureSpec(i95, i95);
                                        char cResolveOpacity = (char) Drawable.resolveOpacity(i95, i95);
                                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 6473;
                                        byte b7 = (byte) (-$$a[6]);
                                        byte b8 = (byte) (b7 - 3);
                                        Object[] objArr16 = new Object[1];
                                        a(b7, b8, b8, objArr16);
                                        objComponent27 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMakeMeasureSpec, cResolveOpacity, jumpTapTimeout, 1068791596, false, (String) objArr16[0], new Class[]{String.class});
                                    }
                                    Object objInvoke3 = ((Method) objComponent27).invoke(null, objArr15);
                                    Object[] objArr17 = new Object[1];
                                    c((byte) (44 - (~(-TextUtils.lastIndexOf("", '0', 0, 0)))), 30 - View.getDefaultSize(0, 0), "\f \u000b\u0004\f \u0003\u0010\t#\u0007\u0016\u0015\u0014#\u000f\u001c\u0010\u0014\n!\u0010\u0014\u000b\t#\u0010\u000f\f\u000f", objArr17);
                                    Object[] objArr18 = {(String) objArr17[0]};
                                    Object objComponent28 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                    if (objComponent28 == null) {
                                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 52;
                                        char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                                        int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 6473;
                                        byte b9 = (byte) (-$$a[6]);
                                        byte b10 = (byte) (b9 - 3);
                                        Object[] objArr19 = new Object[1];
                                        a(b9, b10, b10, objArr19);
                                        objComponent28 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout, cIndexOf, scrollDefaultDelay2, 1068791596, false, (String) objArr19[0], new Class[]{String.class});
                                    }
                                    Object objInvoke4 = ((Method) objComponent28).invoke(null, objArr18);
                                    if (objInvoke3 != null) {
                                        Object[] objArr20 = {objInvoke3, 42};
                                        Object objComponent29 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent29 == null) {
                                            int i96 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 51;
                                            char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                                            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 5420;
                                            byte b11 = (byte) ($$b & 7);
                                            byte b12 = b11;
                                            Object[] objArr21 = new Object[1];
                                            a(b11, b12, b12, objArr21);
                                            objComponent29 = setSystemGestureExclusionRectsL30479.vD14832N6715(i96, longPressTimeout2, windowTouchSlop, 1884899413, false, (String) objArr21[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue3 = ((Long) ((Method) objComponent29).invoke(null, objArr20)).longValue();
                                        long jNextInt = new Random().nextInt();
                                        long j15 = 446133652 | (jNextInt ^ (-1));
                                        long j16 = 231097232254L + ((-518) * jLongValue3) + ((jLongValue3 | (j15 ^ (-1))) * 519) + ((-519) * (((j15 | jLongValue3) ^ (-1)) | ((((-446133653) | jLongValue3) | jNextInt) ^ (-1)))) + (519 * ((-446133653) | ((jLongValue3 | jNextInt) ^ (-1)))) + 953286766;
                                        int i97 = ((int) (j16 >> 32)) & (1843251202 + ((~((-625193) | i50)) * 433) + (((~(203393598 | i)) | (-1640620010)) * (-433)) + (((~((-1640620010) | i)) | 202768406) * 433));
                                        int i98 = ((int) j16) & ((-1213810337) + (((-1532422831) | i) * (-50)) + (((~((-78124289) | i)) | (~((-17072133) | i50))) * 50) + (((~((-1532422831) | i50)) | (~((-95196421) | i50)) | 17072132) * 50));
                                        if (((i97 & i98) | (i97 ^ i98)) == 477111747) {
                                            if (Build.VERSION.SDK_INT > 33) {
                                                int i99 = $vD14832N6715 + 29;
                                                $sG29839 = i99 % 128;
                                                int i100 = i99 % 2;
                                                int i101 = -TextUtils.indexOf("", "");
                                                int i102 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                int i103 = (i102 & 28) + (i102 | 28);
                                                Object[] objArr22 = new Object[1];
                                                c((byte) ((i101 & 18) + (i101 | 18)), i103, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr22);
                                                Object[] objArr23 = {(String) objArr22[0]};
                                                objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                if (objComponent23 == null) {
                                                    int iBlue = 52 - Color.blue(0);
                                                    char c4 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                    byte b13 = (byte) ($$b & 7);
                                                    byte b14 = b13;
                                                    Object[] objArr24 = new Object[1];
                                                    a(b13, b14, b14, objArr24);
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue, c4, maximumFlingVelocity, 1385817144, false, (String) objArr24[0], new Class[]{String.class});
                                                }
                                                long jLongValue4 = ((Long) ((Method) objComponent23).invoke(null, objArr23)).longValue();
                                                long jMyTid = Process.myTid();
                                                long j17 = jMyTid ^ (-1);
                                                long j18 = (334 * jLongValue4) + 220267928845L + ((((663457615 | j17) ^ (-1)) | ((jLongValue4 | jMyTid) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid) ^ (-1)) | ((j17 | jLongValue4) ^ (-1)))) + 1068037522;
                                                int iMyPid = Process.myPid();
                                                int i104 = ~iMyPid;
                                                int i105 = (~((-228072375) | i104)) | 135272884;
                                                int i106 = ~(iMyPid | 1301953526);
                                                i47 = ((int) (j18 >> 32)) & (624737442 + ((i105 | i106) * (-502)) + ((i106 | (~(i104 | (-92799491)))) * 502));
                                                i48 = ((int) j18) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                    zEquals = true;
                                                } else {
                                                    zEquals = false;
                                                }
                                                i46 = 1;
                                                c = 0;
                                            } else {
                                                int i107 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int iVD14832N6716 = qU20128.vD14832N6715();
                                                int i108 = i107 * 615;
                                                int i109 = ((i108 | (-14099)) << 1) - (i108 ^ (-14099));
                                                int i110 = ~i107;
                                                int i111 = ~((i110 ^ 23) | (i110 & 23));
                                                int i112 = i109 + (((i111 & iVD14832N6716) | (iVD14832N6716 ^ i111) | (~((-24) | i107))) * 614);
                                                int i113 = ~iVD14832N6716;
                                                int i114 = (~((i110 ^ i113) | (i110 & i113))) | (~((i110 ^ 23) | (i110 & 23)));
                                                int i115 = ~iVD14832N6716;
                                                int i116 = ~((i115 & 23) | (i115 ^ 23));
                                                int i117 = (i112 - (~(((i116 & i114) | (i114 ^ i116)) * (-1228)))) - 1;
                                                int i118 = ~((i110 ^ (-24)) | (i110 & (-24)) | i113);
                                                int i119 = (i107 & i113) | (i113 ^ i107);
                                                int i120 = ~((i119 & 23) | (i119 ^ 23));
                                                Object[] objArr25 = new Object[1];
                                                c((byte) ((i117 - (~(((i120 & i118) | (i118 ^ i120)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr25);
                                                Object[] objArr26 = {(String) objArr25[0]};
                                                objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                if (objComponent22 == null) {
                                                    int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 52;
                                                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                                                    int fadingEdgeLength = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                    byte b15 = (byte) (-$$a[6]);
                                                    byte b16 = (byte) (b15 - 3);
                                                    Object[] objArr27 = new Object[1];
                                                    a(b15, b16, b16, objArr27);
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, packedPositionType, fadingEdgeLength, 1068791596, false, (String) objArr27[0], new Class[]{String.class});
                                                }
                                                Object objInvoke5 = ((Method) objComponent22).invoke(null, objArr26);
                                                int i121 = -TextUtils.lastIndexOf("", '0');
                                                i46 = 1;
                                                c = 0;
                                                Object[] objArr28 = new Object[1];
                                                c((byte) (((i121 | 57) << 1) - (i121 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr28);
                                                zEquals = objInvoke5.equals((String) objArr28[0]);
                                            }
                                            if (zEquals) {
                                                Object[] objArr29 = new Object[4];
                                                int[] iArr = new int[i46];
                                                objArr29[c] = iArr;
                                                int[] iArr2 = new int[i46];
                                                objArr29[2] = iArr2;
                                                int[] iArr3 = new int[i46];
                                                objArr29[3] = iArr3;
                                                int i122 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                iArr2[0] = i;
                                                iArr3[0] = i122;
                                                objArr29[1] = null;
                                                int i123 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                int i124 = i123 << 13;
                                                int i125 = (i124 & (~i123)) | ((~i124) & i123);
                                                int i126 = i125 >>> 17;
                                                int i127 = ((~i125) & i126) | ((~i126) & i125);
                                                iArr[0] = i127 ^ (i127 << 5);
                                                return objArr29;
                                            }
                                        }
                                    } else {
                                        objInvoke3 = objInvoke3;
                                    }
                                    if (objInvoke4 != null) {
                                        int i128 = $sG29839;
                                        int i129 = (i128 & 103) + (i128 | 103);
                                        $vD14832N6715 = i129 % 128;
                                        int i130 = i129 % 2;
                                        Object[] objArr30 = {objInvoke4, 42};
                                        Object objComponent30 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent30 == null) {
                                            int windowTouchSlop2 = 52 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                                            char c5 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                                            int maxKeyCode = 5420 - (KeyEvent.getMaxKeyCode() >> 16);
                                            byte b17 = (byte) ($$b & 7);
                                            byte b18 = b17;
                                            Object[] objArr31 = new Object[1];
                                            a(b17, b18, b18, objArr31);
                                            objComponent30 = setSystemGestureExclusionRectsL30479.vD14832N6715(windowTouchSlop2, c5, maxKeyCode, 1884899413, false, (String) objArr31[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue5 = ((Long) ((Method) objComponent30).invoke(null, objArr30)).longValue();
                                        long jMyUid = Process.myUid();
                                        long j19 = jMyUid ^ (-1);
                                        long j20 = (-275518452666L) + (565 * jLongValue5) + ((-564) * ((-489375583) | (((jLongValue5 ^ (-1)) | j19) ^ (-1)) | ((jLongValue5 | jMyUid) ^ (-1)))) + (1128 * ((jMyUid | ((-489375583) | jLongValue5)) ^ (-1))) + (564 * ((((-489375583) | j19) ^ (-1)) | ((489375582 | jLongValue5) ^ (-1)))) + 17777531;
                                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                                        int i131 = ~iMaxMemory;
                                        int i132 = ((int) (j20 >> 32)) & (1687905420 + ((1554333005 | (~(117106594 | i131))) * (-90)) + (((~(117106594 | iMaxMemory)) | 39502498) * (-45)) + (((~(iMaxMemory | (-1554333006))) | 117106594 | (~(i131 | 1554333005))) * 45));
                                        int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                                        int i133 = ~iMaxMemory2;
                                        int i134 = ((int) j20) & ((-1627274736) + (((~((-1085055342) | i133)) | (~(1772988909 | iMaxMemory2))) * (-831)) + ((~((-303366) | iMaxMemory2)) * (-1662)) + (((~(iMaxMemory2 | 1085055341)) | (~(i133 | (-1772685545))) | (~(1772685544 | iMaxMemory2))) * 831));
                                        if (((i132 & i134) | (i132 ^ i134)) == 477111747) {
                                            if (Build.VERSION.SDK_INT > 33) {
                                                int i910 = $vD14832N6715 + 29;
                                                $sG29839 = i910 % 128;
                                                int i1010 = i910 % 2;
                                                int i1011 = -TextUtils.indexOf("", "");
                                                int i1012 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                int i1013 = (i1012 & 28) + (i1012 | 28);
                                                Object[] objArr210 = new Object[1];
                                                c((byte) ((i1011 & 18) + (i1011 | 18)), i1013, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr210);
                                                Object[] objArr211 = {(String) objArr210[0]};
                                                objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                if (objComponent23 == null) {
                                                    int iBlue2 = 52 - Color.blue(0);
                                                    char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                    byte b19 = (byte) ($$b & 7);
                                                    byte b110 = b19;
                                                    Object[] objArr212 = new Object[1];
                                                    a(b19, b110, b110, objArr212);
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue2, c6, maximumFlingVelocity2, 1385817144, false, (String) objArr212[0], new Class[]{String.class});
                                                }
                                                long jLongValue6 = ((Long) ((Method) objComponent23).invoke(null, objArr211)).longValue();
                                                long jMyTid2 = Process.myTid();
                                                long j110 = jMyTid2 ^ (-1);
                                                long j111 = (334 * jLongValue6) + 220267928845L + ((((663457615 | j110) ^ (-1)) | ((jLongValue6 | jMyTid2) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid2) ^ (-1)) | ((j110 | jLongValue6) ^ (-1)))) + 1068037522;
                                                int iMyPid2 = Process.myPid();
                                                int i1014 = ~iMyPid2;
                                                int i1015 = (~((-228072375) | i1014)) | 135272884;
                                                int i1016 = ~(iMyPid2 | 1301953526);
                                                i47 = ((int) (j111 >> 32)) & (624737442 + ((i1015 | i1016) * (-502)) + ((i1016 | (~(i1014 | (-92799491)))) * 502));
                                                i48 = ((int) j111) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                    zEquals = true;
                                                } else {
                                                    zEquals = false;
                                                }
                                                i46 = 1;
                                                c = 0;
                                            } else {
                                                int i1017 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int iVD14832N6717 = qU20128.vD14832N6715();
                                                int i1018 = i1017 * 615;
                                                int i1019 = ((i1018 | (-14099)) << 1) - (i1018 ^ (-14099));
                                                int i1110 = ~i1017;
                                                int i1111 = ~((i1110 ^ 23) | (i1110 & 23));
                                                int i1112 = i1019 + (((i1111 & iVD14832N6717) | (iVD14832N6717 ^ i1111) | (~((-24) | i1017))) * 614);
                                                int i1113 = ~iVD14832N6717;
                                                int i1114 = (~((i1110 ^ i1113) | (i1110 & i1113))) | (~((i1110 ^ 23) | (i1110 & 23)));
                                                int i1115 = ~iVD14832N6717;
                                                int i1116 = ~((i1115 & 23) | (i1115 ^ 23));
                                                int i1117 = (i1112 - (~(((i1116 & i1114) | (i1114 ^ i1116)) * (-1228)))) - 1;
                                                int i1118 = ~((i1110 ^ (-24)) | (i1110 & (-24)) | i1113);
                                                int i1119 = (i1017 & i1113) | (i1113 ^ i1017);
                                                int i1210 = ~((i1119 & 23) | (i1119 ^ 23));
                                                Object[] objArr213 = new Object[1];
                                                c((byte) ((i1117 - (~(((i1210 & i1118) | (i1118 ^ i1210)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr213);
                                                Object[] objArr214 = {(String) objArr213[0]};
                                                objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                if (objComponent22 == null) {
                                                    int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                    char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                                                    int fadingEdgeLength2 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                    byte b111 = (byte) (-$$a[6]);
                                                    byte b112 = (byte) (b111 - 3);
                                                    Object[] objArr215 = new Object[1];
                                                    a(b111, b112, b112, objArr215);
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf2, packedPositionType2, fadingEdgeLength2, 1068791596, false, (String) objArr215[0], new Class[]{String.class});
                                                }
                                                Object objInvoke6 = ((Method) objComponent22).invoke(null, objArr214);
                                                int i1211 = -TextUtils.lastIndexOf("", '0');
                                                i46 = 1;
                                                c = 0;
                                                Object[] objArr216 = new Object[1];
                                                c((byte) (((i1211 | 57) << 1) - (i1211 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr216);
                                                zEquals = objInvoke6.equals((String) objArr216[0]);
                                            }
                                            if (zEquals) {
                                                Object[] objArr217 = new Object[4];
                                                int[] iArr4 = new int[i46];
                                                objArr217[c] = iArr4;
                                                int[] iArr5 = new int[i46];
                                                objArr217[2] = iArr5;
                                                int[] iArr6 = new int[i46];
                                                objArr217[3] = iArr6;
                                                int i1212 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                iArr5[0] = i;
                                                iArr6[0] = i1212;
                                                objArr217[1] = null;
                                                int i1213 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                int i1214 = i1213 << 13;
                                                int i1215 = (i1214 & (~i1213)) | ((~i1214) & i1213);
                                                int i1216 = i1215 >>> 17;
                                                int i1217 = ((~i1215) & i1216) | ((~i1216) & i1215);
                                                iArr4[0] = i1217 ^ (i1217 << 5);
                                                return objArr217;
                                            }
                                        } else if (objInvoke3 != null) {
                                            Object[] objArr32 = {objInvoke3, 42};
                                            objComponent21 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent21 == null) {
                                                int defaultSize = 52 - View.getDefaultSize(0, 0);
                                                char c7 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                                                int iRed = Color.red(0) + 5420;
                                                byte b20 = (byte) ($$b & 7);
                                                byte b21 = b20;
                                                Object[] objArr33 = new Object[1];
                                                a(b20, b21, b21, objArr33);
                                                objComponent21 = setSystemGestureExclusionRectsL30479.vD14832N6715(defaultSize, c7, iRed, 1884899413, false, (String) objArr33[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue7 = ((Long) ((Method) objComponent21).invoke(null, objArr32)).longValue();
                                            long elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                                            long j21 = 100554627200L + (382 * jLongValue7) + ((-381) * (jLongValue7 | elapsedCpuTime2 | 264617439)) + ((((264617439 | (jLongValue7 ^ (-1))) ^ (-1)) | (((elapsedCpuTime2 ^ (-1)) | jLongValue7) ^ (-1)) | (((-264617440) | jLongValue7) ^ (-1))) * 381) + (381 * ((264617439 | jLongValue7) ^ (-1))) + 771770553;
                                            int i135 = ~(2017606955 | i50);
                                            i44 = ((int) (j21 >> 32)) & (((537011456 | i135) * (-374)) + 724112600 + ((i135 | 1480595499) * 374));
                                            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                            int i136 = (-1276229131) + (((~(416062801 | iFreeMemory)) | (-1853289212)) * 672);
                                            int i137 = ~iFreeMemory;
                                            i45 = ((int) j21) & (i136 + (((~(iFreeMemory | (-1853289212))) | (~((-416062802) | i137))) * (-672)) + (((~(1853289211 | i137)) | (-2130640892)) * 672));
                                            if (((i44 & i45) | (i44 ^ i45)) != -1032769152) {
                                                if (Build.VERSION.SDK_INT > 33) {
                                                    int i911 = $vD14832N6715 + 29;
                                                    $sG29839 = i911 % 128;
                                                    int i10110 = i911 % 2;
                                                    int i10111 = -TextUtils.indexOf("", "");
                                                    int i10112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                    int i10113 = (i10112 & 28) + (i10112 | 28);
                                                    Object[] objArr218 = new Object[1];
                                                    c((byte) ((i10111 & 18) + (i10111 | 18)), i10113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr218);
                                                    Object[] objArr219 = {(String) objArr218[0]};
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                    if (objComponent23 == null) {
                                                        int iBlue3 = 52 - Color.blue(0);
                                                        char c8 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                        int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                        byte b113 = (byte) ($$b & 7);
                                                        byte b114 = b113;
                                                        Object[] objArr2110 = new Object[1];
                                                        a(b113, b114, b114, objArr2110);
                                                        objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue3, c8, maximumFlingVelocity3, 1385817144, false, (String) objArr2110[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue8 = ((Long) ((Method) objComponent23).invoke(null, objArr219)).longValue();
                                                    long jMyTid3 = Process.myTid();
                                                    long j112 = jMyTid3 ^ (-1);
                                                    long j113 = (334 * jLongValue8) + 220267928845L + ((((663457615 | j112) ^ (-1)) | ((jLongValue8 | jMyTid3) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid3) ^ (-1)) | ((j112 | jLongValue8) ^ (-1)))) + 1068037522;
                                                    int iMyPid3 = Process.myPid();
                                                    int i10114 = ~iMyPid3;
                                                    int i10115 = (~((-228072375) | i10114)) | 135272884;
                                                    int i10116 = ~(iMyPid3 | 1301953526);
                                                    i47 = ((int) (j113 >> 32)) & (624737442 + ((i10115 | i10116) * (-502)) + ((i10116 | (~(i10114 | (-92799491)))) * 502));
                                                    i48 = ((int) j113) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                    if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                        zEquals = true;
                                                    } else {
                                                        zEquals = false;
                                                    }
                                                    i46 = 1;
                                                    c = 0;
                                                } else {
                                                    int i10117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                    int iVD14832N6718 = qU20128.vD14832N6715();
                                                    int i10118 = i10117 * 615;
                                                    int i10119 = ((i10118 | (-14099)) << 1) - (i10118 ^ (-14099));
                                                    int i11110 = ~i10117;
                                                    int i11111 = ~((i11110 ^ 23) | (i11110 & 23));
                                                    int i11112 = i10119 + (((i11111 & iVD14832N6718) | (iVD14832N6718 ^ i11111) | (~((-24) | i10117))) * 614);
                                                    int i11113 = ~iVD14832N6718;
                                                    int i11114 = (~((i11110 ^ i11113) | (i11110 & i11113))) | (~((i11110 ^ 23) | (i11110 & 23)));
                                                    int i11115 = ~iVD14832N6718;
                                                    int i11116 = ~((i11115 & 23) | (i11115 ^ 23));
                                                    int i11117 = (i11112 - (~(((i11116 & i11114) | (i11114 ^ i11116)) * (-1228)))) - 1;
                                                    int i11118 = ~((i11110 ^ (-24)) | (i11110 & (-24)) | i11113);
                                                    int i11119 = (i10117 & i11113) | (i11113 ^ i10117);
                                                    int i1218 = ~((i11119 & 23) | (i11119 ^ 23));
                                                    Object[] objArr2111 = new Object[1];
                                                    c((byte) ((i11117 - (~(((i1218 & i11118) | (i11118 ^ i1218)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr2111);
                                                    Object[] objArr2112 = {(String) objArr2111[0]};
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                    if (objComponent22 == null) {
                                                        int iIndexOf3 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                        char packedPositionType3 = (char) ExpandableListView.getPackedPositionType(0L);
                                                        int fadingEdgeLength3 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                        byte b115 = (byte) (-$$a[6]);
                                                        byte b116 = (byte) (b115 - 3);
                                                        Object[] objArr2113 = new Object[1];
                                                        a(b115, b116, b116, objArr2113);
                                                        objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf3, packedPositionType3, fadingEdgeLength3, 1068791596, false, (String) objArr2113[0], new Class[]{String.class});
                                                    }
                                                    Object objInvoke7 = ((Method) objComponent22).invoke(null, objArr2112);
                                                    int i1219 = -TextUtils.lastIndexOf("", '0');
                                                    i46 = 1;
                                                    c = 0;
                                                    Object[] objArr2114 = new Object[1];
                                                    c((byte) (((i1219 | 57) << 1) - (i1219 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr2114);
                                                    zEquals = objInvoke7.equals((String) objArr2114[0]);
                                                }
                                                if (zEquals) {
                                                    Object[] objArr2115 = new Object[4];
                                                    int[] iArr7 = new int[i46];
                                                    objArr2115[c] = iArr7;
                                                    int[] iArr8 = new int[i46];
                                                    objArr2115[2] = iArr8;
                                                    int[] iArr9 = new int[i46];
                                                    objArr2115[3] = iArr9;
                                                    int i12110 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                    iArr8[0] = i;
                                                    iArr9[0] = i12110;
                                                    objArr2115[1] = null;
                                                    int i12111 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                    int i12112 = i12111 << 13;
                                                    int i12113 = (i12112 & (~i12111)) | ((~i12112) & i12111);
                                                    int i12114 = i12113 >>> 17;
                                                    int i12115 = ((~i12113) & i12114) | ((~i12114) & i12113);
                                                    iArr7[0] = i12115 ^ (i12115 << 5);
                                                    return objArr2115;
                                                }
                                            } else if (objInvoke4 != null) {
                                                Object[] objArr34 = {objInvoke4, 42};
                                                objComponent20 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                                if (objComponent20 == null) {
                                                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 53;
                                                    char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                                    int i138 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 5420;
                                                    byte b22 = (byte) ($$b & 7);
                                                    byte b23 = b22;
                                                    Object[] objArr35 = new Object[1];
                                                    a(b22, b23, b23, objArr35);
                                                    objComponent20 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf, edgeSlop2, i138, 1884899413, false, (String) objArr35[0], new Class[]{String.class, Integer.TYPE});
                                                }
                                                long jLongValue9 = ((Long) ((Method) objComponent20).invoke(null, objArr34)).longValue();
                                                j3 = 455607950256L + (434 * jLongValue9) + ((((1054648032 | j9) | jLongValue9) ^ (-1)) * 433) + ((-433) * (1054648032 | (((jLongValue9 ^ (-1)) | j7) ^ (-1)))) + (433 * ((((-1054648033) | jLongValue9) ^ (-1)) | ((1054648032 | j7) ^ (-1)))) + 1561801146;
                                                i42 = (int) (j3 >> 32);
                                                i43 = ~((~((int) Process.getElapsedCpuTime())) | 1922802100);
                                                if (((i42 & (((277938176 | i43) * (-374)) + 1308104882 + ((i43 | 1644863924) * 374))) | (((int) j3) & ((-2089544251) + (((~(1243981747 | i)) | (-193244663)) * (-366)) + (((~((-25167941) | i)) | 1075905025) * 366)))) == 542074309) {
                                                    if (Build.VERSION.SDK_INT > 33) {
                                                        int i912 = $vD14832N6715 + 29;
                                                        $sG29839 = i912 % 128;
                                                        int i101110 = i912 % 2;
                                                        int i101111 = -TextUtils.indexOf("", "");
                                                        int i101112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                        int i101113 = (i101112 & 28) + (i101112 | 28);
                                                        Object[] objArr2116 = new Object[1];
                                                        c((byte) ((i101111 & 18) + (i101111 | 18)), i101113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr2116);
                                                        Object[] objArr2117 = {(String) objArr2116[0]};
                                                        objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                        if (objComponent23 == null) {
                                                            int iBlue4 = 52 - Color.blue(0);
                                                            char c9 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                            int maximumFlingVelocity4 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                            byte b117 = (byte) ($$b & 7);
                                                            byte b118 = b117;
                                                            Object[] objArr2118 = new Object[1];
                                                            a(b117, b118, b118, objArr2118);
                                                            objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue4, c9, maximumFlingVelocity4, 1385817144, false, (String) objArr2118[0], new Class[]{String.class});
                                                        }
                                                        long jLongValue10 = ((Long) ((Method) objComponent23).invoke(null, objArr2117)).longValue();
                                                        long jMyTid4 = Process.myTid();
                                                        long j114 = jMyTid4 ^ (-1);
                                                        long j115 = (334 * jLongValue10) + 220267928845L + ((((663457615 | j114) ^ (-1)) | ((jLongValue10 | jMyTid4) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid4) ^ (-1)) | ((j114 | jLongValue10) ^ (-1)))) + 1068037522;
                                                        int iMyPid4 = Process.myPid();
                                                        int i101114 = ~iMyPid4;
                                                        int i101115 = (~((-228072375) | i101114)) | 135272884;
                                                        int i101116 = ~(iMyPid4 | 1301953526);
                                                        i47 = ((int) (j115 >> 32)) & (624737442 + ((i101115 | i101116) * (-502)) + ((i101116 | (~(i101114 | (-92799491)))) * 502));
                                                        i48 = ((int) j115) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                        if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                            zEquals = true;
                                                        } else {
                                                            zEquals = false;
                                                        }
                                                        i46 = 1;
                                                        c = 0;
                                                    } else {
                                                        int i101117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                        int iVD14832N6719 = qU20128.vD14832N6715();
                                                        int i101118 = i101117 * 615;
                                                        int i101119 = ((i101118 | (-14099)) << 1) - (i101118 ^ (-14099));
                                                        int i111110 = ~i101117;
                                                        int i111111 = ~((i111110 ^ 23) | (i111110 & 23));
                                                        int i111112 = i101119 + (((i111111 & iVD14832N6719) | (iVD14832N6719 ^ i111111) | (~((-24) | i101117))) * 614);
                                                        int i111113 = ~iVD14832N6719;
                                                        int i111114 = (~((i111110 ^ i111113) | (i111110 & i111113))) | (~((i111110 ^ 23) | (i111110 & 23)));
                                                        int i111115 = ~iVD14832N6719;
                                                        int i111116 = ~((i111115 & 23) | (i111115 ^ 23));
                                                        int i111117 = (i111112 - (~(((i111116 & i111114) | (i111114 ^ i111116)) * (-1228)))) - 1;
                                                        int i111118 = ~((i111110 ^ (-24)) | (i111110 & (-24)) | i111113);
                                                        int i111119 = (i101117 & i111113) | (i111113 ^ i101117);
                                                        int i12116 = ~((i111119 & 23) | (i111119 ^ 23));
                                                        Object[] objArr2119 = new Object[1];
                                                        c((byte) ((i111117 - (~(((i12116 & i111118) | (i111118 ^ i12116)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr2119);
                                                        Object[] objArr21110 = {(String) objArr2119[0]};
                                                        objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                        if (objComponent22 == null) {
                                                            int iIndexOf4 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                            char packedPositionType4 = (char) ExpandableListView.getPackedPositionType(0L);
                                                            int fadingEdgeLength4 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                            byte b119 = (byte) (-$$a[6]);
                                                            byte b1110 = (byte) (b119 - 3);
                                                            Object[] objArr21111 = new Object[1];
                                                            a(b119, b1110, b1110, objArr21111);
                                                            objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf4, packedPositionType4, fadingEdgeLength4, 1068791596, false, (String) objArr21111[0], new Class[]{String.class});
                                                        }
                                                        Object objInvoke8 = ((Method) objComponent22).invoke(null, objArr21110);
                                                        int i12117 = -TextUtils.lastIndexOf("", '0');
                                                        i46 = 1;
                                                        c = 0;
                                                        Object[] objArr21112 = new Object[1];
                                                        c((byte) (((i12117 | 57) << 1) - (i12117 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr21112);
                                                        zEquals = objInvoke8.equals((String) objArr21112[0]);
                                                    }
                                                    if (zEquals) {
                                                        Object[] objArr21113 = new Object[4];
                                                        int[] iArr10 = new int[i46];
                                                        objArr21113[c] = iArr10;
                                                        int[] iArr11 = new int[i46];
                                                        objArr21113[2] = iArr11;
                                                        int[] iArr12 = new int[i46];
                                                        objArr21113[3] = iArr12;
                                                        int i12118 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                        iArr11[0] = i;
                                                        iArr12[0] = i12118;
                                                        objArr21113[1] = null;
                                                        int i12119 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                        int i121110 = i12119 << 13;
                                                        int i121111 = (i121110 & (~i12119)) | ((~i121110) & i12119);
                                                        int i121112 = i121111 >>> 17;
                                                        int i121113 = ((~i121111) & i121112) | ((~i121112) & i121111);
                                                        iArr10[0] = i121113 ^ (i121113 << 5);
                                                        return objArr21113;
                                                    }
                                                }
                                            }
                                        } else if (objInvoke4 != null) {
                                            Object[] objArr36 = {objInvoke4, 42};
                                            objComponent20 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent20 == null) {
                                                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 53;
                                                char edgeSlop3 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                                int i139 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 5420;
                                                byte b24 = (byte) ($$b & 7);
                                                byte b25 = b24;
                                                Object[] objArr37 = new Object[1];
                                                a(b24, b25, b25, objArr37);
                                                objComponent20 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf2, edgeSlop3, i139, 1884899413, false, (String) objArr37[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue11 = ((Long) ((Method) objComponent20).invoke(null, objArr36)).longValue();
                                            j3 = 455607950256L + (434 * jLongValue11) + ((((1054648032 | j9) | jLongValue11) ^ (-1)) * 433) + ((-433) * (1054648032 | (((jLongValue11 ^ (-1)) | j7) ^ (-1)))) + (433 * ((((-1054648033) | jLongValue11) ^ (-1)) | ((1054648032 | j7) ^ (-1)))) + 1561801146;
                                            i42 = (int) (j3 >> 32);
                                            i43 = ~((~((int) Process.getElapsedCpuTime())) | 1922802100);
                                            if (((i42 & (((277938176 | i43) * (-374)) + 1308104882 + ((i43 | 1644863924) * 374))) | (((int) j3) & ((-2089544251) + (((~(1243981747 | i)) | (-193244663)) * (-366)) + (((~((-25167941) | i)) | 1075905025) * 366)))) == 542074309) {
                                                if (Build.VERSION.SDK_INT > 33) {
                                                    int i913 = $vD14832N6715 + 29;
                                                    $sG29839 = i913 % 128;
                                                    int i1011110 = i913 % 2;
                                                    int i1011111 = -TextUtils.indexOf("", "");
                                                    int i1011112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                    int i1011113 = (i1011112 & 28) + (i1011112 | 28);
                                                    Object[] objArr21114 = new Object[1];
                                                    c((byte) ((i1011111 & 18) + (i1011111 | 18)), i1011113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr21114);
                                                    Object[] objArr21115 = {(String) objArr21114[0]};
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                    if (objComponent23 == null) {
                                                        int iBlue5 = 52 - Color.blue(0);
                                                        char c10 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                        int maximumFlingVelocity5 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                        byte b1111 = (byte) ($$b & 7);
                                                        byte b1112 = b1111;
                                                        Object[] objArr21116 = new Object[1];
                                                        a(b1111, b1112, b1112, objArr21116);
                                                        objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue5, c10, maximumFlingVelocity5, 1385817144, false, (String) objArr21116[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue12 = ((Long) ((Method) objComponent23).invoke(null, objArr21115)).longValue();
                                                    long jMyTid5 = Process.myTid();
                                                    long j116 = jMyTid5 ^ (-1);
                                                    long j117 = (334 * jLongValue12) + 220267928845L + ((((663457615 | j116) ^ (-1)) | ((jLongValue12 | jMyTid5) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid5) ^ (-1)) | ((j116 | jLongValue12) ^ (-1)))) + 1068037522;
                                                    int iMyPid5 = Process.myPid();
                                                    int i1011114 = ~iMyPid5;
                                                    int i1011115 = (~((-228072375) | i1011114)) | 135272884;
                                                    int i1011116 = ~(iMyPid5 | 1301953526);
                                                    i47 = ((int) (j117 >> 32)) & (624737442 + ((i1011115 | i1011116) * (-502)) + ((i1011116 | (~(i1011114 | (-92799491)))) * 502));
                                                    i48 = ((int) j117) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                    if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                        zEquals = true;
                                                    } else {
                                                        zEquals = false;
                                                    }
                                                    i46 = 1;
                                                    c = 0;
                                                } else {
                                                    int i1011117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                    int iVD14832N67110 = qU20128.vD14832N6715();
                                                    int i1011118 = i1011117 * 615;
                                                    int i1011119 = ((i1011118 | (-14099)) << 1) - (i1011118 ^ (-14099));
                                                    int i1111110 = ~i1011117;
                                                    int i1111111 = ~((i1111110 ^ 23) | (i1111110 & 23));
                                                    int i1111112 = i1011119 + (((i1111111 & iVD14832N67110) | (iVD14832N67110 ^ i1111111) | (~((-24) | i1011117))) * 614);
                                                    int i1111113 = ~iVD14832N67110;
                                                    int i1111114 = (~((i1111110 ^ i1111113) | (i1111110 & i1111113))) | (~((i1111110 ^ 23) | (i1111110 & 23)));
                                                    int i1111115 = ~iVD14832N67110;
                                                    int i1111116 = ~((i1111115 & 23) | (i1111115 ^ 23));
                                                    int i1111117 = (i1111112 - (~(((i1111116 & i1111114) | (i1111114 ^ i1111116)) * (-1228)))) - 1;
                                                    int i1111118 = ~((i1111110 ^ (-24)) | (i1111110 & (-24)) | i1111113);
                                                    int i1111119 = (i1011117 & i1111113) | (i1111113 ^ i1011117);
                                                    int i121114 = ~((i1111119 & 23) | (i1111119 ^ 23));
                                                    Object[] objArr21117 = new Object[1];
                                                    c((byte) ((i1111117 - (~(((i121114 & i1111118) | (i1111118 ^ i121114)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr21117);
                                                    Object[] objArr21118 = {(String) objArr21117[0]};
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                    if (objComponent22 == null) {
                                                        int iIndexOf5 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                        char packedPositionType5 = (char) ExpandableListView.getPackedPositionType(0L);
                                                        int fadingEdgeLength5 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                        byte b1113 = (byte) (-$$a[6]);
                                                        byte b1114 = (byte) (b1113 - 3);
                                                        Object[] objArr21119 = new Object[1];
                                                        a(b1113, b1114, b1114, objArr21119);
                                                        objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf5, packedPositionType5, fadingEdgeLength5, 1068791596, false, (String) objArr21119[0], new Class[]{String.class});
                                                    }
                                                    Object objInvoke9 = ((Method) objComponent22).invoke(null, objArr21118);
                                                    int i121115 = -TextUtils.lastIndexOf("", '0');
                                                    i46 = 1;
                                                    c = 0;
                                                    Object[] objArr211110 = new Object[1];
                                                    c((byte) (((i121115 | 57) << 1) - (i121115 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr211110);
                                                    zEquals = objInvoke9.equals((String) objArr211110[0]);
                                                }
                                                if (zEquals) {
                                                    Object[] objArr211111 = new Object[4];
                                                    int[] iArr13 = new int[i46];
                                                    objArr211111[c] = iArr13;
                                                    int[] iArr14 = new int[i46];
                                                    objArr211111[2] = iArr14;
                                                    int[] iArr15 = new int[i46];
                                                    objArr211111[3] = iArr15;
                                                    int i121116 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                    iArr14[0] = i;
                                                    iArr15[0] = i121116;
                                                    objArr211111[1] = null;
                                                    int i121117 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                    int i121118 = i121117 << 13;
                                                    int i121119 = (i121118 & (~i121117)) | ((~i121118) & i121117);
                                                    int i1211110 = i121119 >>> 17;
                                                    int i1211111 = ((~i121119) & i1211110) | ((~i1211110) & i121119);
                                                    iArr13[0] = i1211111 ^ (i1211111 << 5);
                                                    return objArr211111;
                                                }
                                            }
                                        }
                                    } else if (objInvoke3 != null) {
                                        Object[] objArr38 = {objInvoke3, 42};
                                        objComponent21 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent21 == null) {
                                            int defaultSize2 = 52 - View.getDefaultSize(0, 0);
                                            char c11 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                                            int iRed2 = Color.red(0) + 5420;
                                            byte b26 = (byte) ($$b & 7);
                                            byte b27 = b26;
                                            Object[] objArr39 = new Object[1];
                                            a(b26, b27, b27, objArr39);
                                            objComponent21 = setSystemGestureExclusionRectsL30479.vD14832N6715(defaultSize2, c11, iRed2, 1884899413, false, (String) objArr39[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue13 = ((Long) ((Method) objComponent21).invoke(null, objArr38)).longValue();
                                        long elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                                        long j22 = 100554627200L + (382 * jLongValue13) + ((-381) * (jLongValue13 | elapsedCpuTime3 | 264617439)) + ((((264617439 | (jLongValue13 ^ (-1))) ^ (-1)) | (((elapsedCpuTime3 ^ (-1)) | jLongValue13) ^ (-1)) | (((-264617440) | jLongValue13) ^ (-1))) * 381) + (381 * ((264617439 | jLongValue13) ^ (-1))) + 771770553;
                                        int i1310 = ~(2017606955 | i50);
                                        i44 = ((int) (j22 >> 32)) & (((537011456 | i1310) * (-374)) + 724112600 + ((i1310 | 1480595499) * 374));
                                        int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                                        int i1311 = (-1276229131) + (((~(416062801 | iFreeMemory2)) | (-1853289212)) * 672);
                                        int i1312 = ~iFreeMemory2;
                                        i45 = ((int) j22) & (i1311 + (((~(iFreeMemory2 | (-1853289212))) | (~((-416062802) | i1312))) * (-672)) + (((~(1853289211 | i1312)) | (-2130640892)) * 672));
                                        if (((i44 & i45) | (i44 ^ i45)) != -1032769152) {
                                            if (Build.VERSION.SDK_INT > 33) {
                                                int i914 = $vD14832N6715 + 29;
                                                $sG29839 = i914 % 128;
                                                int i10111110 = i914 % 2;
                                                int i10111111 = -TextUtils.indexOf("", "");
                                                int i10111112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                int i10111113 = (i10111112 & 28) + (i10111112 | 28);
                                                Object[] objArr211112 = new Object[1];
                                                c((byte) ((i10111111 & 18) + (i10111111 | 18)), i10111113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr211112);
                                                Object[] objArr211113 = {(String) objArr211112[0]};
                                                objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                if (objComponent23 == null) {
                                                    int iBlue6 = 52 - Color.blue(0);
                                                    char c12 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                    int maximumFlingVelocity6 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                    byte b1115 = (byte) ($$b & 7);
                                                    byte b1116 = b1115;
                                                    Object[] objArr211114 = new Object[1];
                                                    a(b1115, b1116, b1116, objArr211114);
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue6, c12, maximumFlingVelocity6, 1385817144, false, (String) objArr211114[0], new Class[]{String.class});
                                                }
                                                long jLongValue14 = ((Long) ((Method) objComponent23).invoke(null, objArr211113)).longValue();
                                                long jMyTid6 = Process.myTid();
                                                long j118 = jMyTid6 ^ (-1);
                                                long j119 = (334 * jLongValue14) + 220267928845L + ((((663457615 | j118) ^ (-1)) | ((jLongValue14 | jMyTid6) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid6) ^ (-1)) | ((j118 | jLongValue14) ^ (-1)))) + 1068037522;
                                                int iMyPid6 = Process.myPid();
                                                int i10111114 = ~iMyPid6;
                                                int i10111115 = (~((-228072375) | i10111114)) | 135272884;
                                                int i10111116 = ~(iMyPid6 | 1301953526);
                                                i47 = ((int) (j119 >> 32)) & (624737442 + ((i10111115 | i10111116) * (-502)) + ((i10111116 | (~(i10111114 | (-92799491)))) * 502));
                                                i48 = ((int) j119) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                    zEquals = true;
                                                } else {
                                                    zEquals = false;
                                                }
                                                i46 = 1;
                                                c = 0;
                                            } else {
                                                int i10111117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int iVD14832N67111 = qU20128.vD14832N6715();
                                                int i10111118 = i10111117 * 615;
                                                int i10111119 = ((i10111118 | (-14099)) << 1) - (i10111118 ^ (-14099));
                                                int i11111110 = ~i10111117;
                                                int i11111111 = ~((i11111110 ^ 23) | (i11111110 & 23));
                                                int i11111112 = i10111119 + (((i11111111 & iVD14832N67111) | (iVD14832N67111 ^ i11111111) | (~((-24) | i10111117))) * 614);
                                                int i11111113 = ~iVD14832N67111;
                                                int i11111114 = (~((i11111110 ^ i11111113) | (i11111110 & i11111113))) | (~((i11111110 ^ 23) | (i11111110 & 23)));
                                                int i11111115 = ~iVD14832N67111;
                                                int i11111116 = ~((i11111115 & 23) | (i11111115 ^ 23));
                                                int i11111117 = (i11111112 - (~(((i11111116 & i11111114) | (i11111114 ^ i11111116)) * (-1228)))) - 1;
                                                int i11111118 = ~((i11111110 ^ (-24)) | (i11111110 & (-24)) | i11111113);
                                                int i11111119 = (i10111117 & i11111113) | (i11111113 ^ i10111117);
                                                int i1211112 = ~((i11111119 & 23) | (i11111119 ^ 23));
                                                Object[] objArr211115 = new Object[1];
                                                c((byte) ((i11111117 - (~(((i1211112 & i11111118) | (i11111118 ^ i1211112)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr211115);
                                                Object[] objArr211116 = {(String) objArr211115[0]};
                                                objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                if (objComponent22 == null) {
                                                    int iIndexOf6 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                    char packedPositionType6 = (char) ExpandableListView.getPackedPositionType(0L);
                                                    int fadingEdgeLength6 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                    byte b1117 = (byte) (-$$a[6]);
                                                    byte b1118 = (byte) (b1117 - 3);
                                                    Object[] objArr211117 = new Object[1];
                                                    a(b1117, b1118, b1118, objArr211117);
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf6, packedPositionType6, fadingEdgeLength6, 1068791596, false, (String) objArr211117[0], new Class[]{String.class});
                                                }
                                                Object objInvoke10 = ((Method) objComponent22).invoke(null, objArr211116);
                                                int i1211113 = -TextUtils.lastIndexOf("", '0');
                                                i46 = 1;
                                                c = 0;
                                                Object[] objArr211118 = new Object[1];
                                                c((byte) (((i1211113 | 57) << 1) - (i1211113 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr211118);
                                                zEquals = objInvoke10.equals((String) objArr211118[0]);
                                            }
                                            if (zEquals) {
                                                Object[] objArr211119 = new Object[4];
                                                int[] iArr16 = new int[i46];
                                                objArr211119[c] = iArr16;
                                                int[] iArr17 = new int[i46];
                                                objArr211119[2] = iArr17;
                                                int[] iArr18 = new int[i46];
                                                objArr211119[3] = iArr18;
                                                int i1211114 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                iArr17[0] = i;
                                                iArr18[0] = i1211114;
                                                objArr211119[1] = null;
                                                int i1211115 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                int i1211116 = i1211115 << 13;
                                                int i1211117 = (i1211116 & (~i1211115)) | ((~i1211116) & i1211115);
                                                int i1211118 = i1211117 >>> 17;
                                                int i1211119 = ((~i1211117) & i1211118) | ((~i1211118) & i1211117);
                                                iArr16[0] = i1211119 ^ (i1211119 << 5);
                                                return objArr211119;
                                            }
                                        } else if (objInvoke4 != null) {
                                            Object[] objArr310 = {objInvoke4, 42};
                                            objComponent20 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent20 == null) {
                                                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0, 0) + 53;
                                                char edgeSlop4 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                                int i1313 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 5420;
                                                byte b28 = (byte) ($$b & 7);
                                                byte b29 = b28;
                                                Object[] objArr311 = new Object[1];
                                                a(b28, b29, b29, objArr311);
                                                objComponent20 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf3, edgeSlop4, i1313, 1884899413, false, (String) objArr311[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue15 = ((Long) ((Method) objComponent20).invoke(null, objArr310)).longValue();
                                            j3 = 455607950256L + (434 * jLongValue15) + ((((1054648032 | j9) | jLongValue15) ^ (-1)) * 433) + ((-433) * (1054648032 | (((jLongValue15 ^ (-1)) | j7) ^ (-1)))) + (433 * ((((-1054648033) | jLongValue15) ^ (-1)) | ((1054648032 | j7) ^ (-1)))) + 1561801146;
                                            i42 = (int) (j3 >> 32);
                                            i43 = ~((~((int) Process.getElapsedCpuTime())) | 1922802100);
                                            if (((i42 & (((277938176 | i43) * (-374)) + 1308104882 + ((i43 | 1644863924) * 374))) | (((int) j3) & ((-2089544251) + (((~(1243981747 | i)) | (-193244663)) * (-366)) + (((~((-25167941) | i)) | 1075905025) * 366)))) == 542074309) {
                                                if (Build.VERSION.SDK_INT > 33) {
                                                    int i915 = $vD14832N6715 + 29;
                                                    $sG29839 = i915 % 128;
                                                    int i101111110 = i915 % 2;
                                                    int i101111111 = -TextUtils.indexOf("", "");
                                                    int i101111112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                    int i101111113 = (i101111112 & 28) + (i101111112 | 28);
                                                    Object[] objArr2111110 = new Object[1];
                                                    c((byte) ((i101111111 & 18) + (i101111111 | 18)), i101111113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr2111110);
                                                    Object[] objArr2111111 = {(String) objArr2111110[0]};
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                    if (objComponent23 == null) {
                                                        int iBlue7 = 52 - Color.blue(0);
                                                        char c13 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                        int maximumFlingVelocity7 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                        byte b1119 = (byte) ($$b & 7);
                                                        byte b11110 = b1119;
                                                        Object[] objArr2111112 = new Object[1];
                                                        a(b1119, b11110, b11110, objArr2111112);
                                                        objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue7, c13, maximumFlingVelocity7, 1385817144, false, (String) objArr2111112[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue16 = ((Long) ((Method) objComponent23).invoke(null, objArr2111111)).longValue();
                                                    long jMyTid7 = Process.myTid();
                                                    long j1110 = jMyTid7 ^ (-1);
                                                    long j1111 = (334 * jLongValue16) + 220267928845L + ((((663457615 | j1110) ^ (-1)) | ((jLongValue16 | jMyTid7) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid7) ^ (-1)) | ((j1110 | jLongValue16) ^ (-1)))) + 1068037522;
                                                    int iMyPid7 = Process.myPid();
                                                    int i101111114 = ~iMyPid7;
                                                    int i101111115 = (~((-228072375) | i101111114)) | 135272884;
                                                    int i101111116 = ~(iMyPid7 | 1301953526);
                                                    i47 = ((int) (j1111 >> 32)) & (624737442 + ((i101111115 | i101111116) * (-502)) + ((i101111116 | (~(i101111114 | (-92799491)))) * 502));
                                                    i48 = ((int) j1111) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                    if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                        zEquals = true;
                                                    } else {
                                                        zEquals = false;
                                                    }
                                                    i46 = 1;
                                                    c = 0;
                                                } else {
                                                    int i101111117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                    int iVD14832N67112 = qU20128.vD14832N6715();
                                                    int i101111118 = i101111117 * 615;
                                                    int i101111119 = ((i101111118 | (-14099)) << 1) - (i101111118 ^ (-14099));
                                                    int i111111110 = ~i101111117;
                                                    int i111111111 = ~((i111111110 ^ 23) | (i111111110 & 23));
                                                    int i111111112 = i101111119 + (((i111111111 & iVD14832N67112) | (iVD14832N67112 ^ i111111111) | (~((-24) | i101111117))) * 614);
                                                    int i111111113 = ~iVD14832N67112;
                                                    int i111111114 = (~((i111111110 ^ i111111113) | (i111111110 & i111111113))) | (~((i111111110 ^ 23) | (i111111110 & 23)));
                                                    int i111111115 = ~iVD14832N67112;
                                                    int i111111116 = ~((i111111115 & 23) | (i111111115 ^ 23));
                                                    int i111111117 = (i111111112 - (~(((i111111116 & i111111114) | (i111111114 ^ i111111116)) * (-1228)))) - 1;
                                                    int i111111118 = ~((i111111110 ^ (-24)) | (i111111110 & (-24)) | i111111113);
                                                    int i111111119 = (i101111117 & i111111113) | (i111111113 ^ i101111117);
                                                    int i12111110 = ~((i111111119 & 23) | (i111111119 ^ 23));
                                                    Object[] objArr2111113 = new Object[1];
                                                    c((byte) ((i111111117 - (~(((i12111110 & i111111118) | (i111111118 ^ i12111110)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr2111113);
                                                    Object[] objArr2111114 = {(String) objArr2111113[0]};
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                    if (objComponent22 == null) {
                                                        int iIndexOf7 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                        char packedPositionType7 = (char) ExpandableListView.getPackedPositionType(0L);
                                                        int fadingEdgeLength7 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                        byte b11111 = (byte) (-$$a[6]);
                                                        byte b11112 = (byte) (b11111 - 3);
                                                        Object[] objArr2111115 = new Object[1];
                                                        a(b11111, b11112, b11112, objArr2111115);
                                                        objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf7, packedPositionType7, fadingEdgeLength7, 1068791596, false, (String) objArr2111115[0], new Class[]{String.class});
                                                    }
                                                    Object objInvoke11 = ((Method) objComponent22).invoke(null, objArr2111114);
                                                    int i12111111 = -TextUtils.lastIndexOf("", '0');
                                                    i46 = 1;
                                                    c = 0;
                                                    Object[] objArr2111116 = new Object[1];
                                                    c((byte) (((i12111111 | 57) << 1) - (i12111111 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr2111116);
                                                    zEquals = objInvoke11.equals((String) objArr2111116[0]);
                                                }
                                                if (zEquals) {
                                                    Object[] objArr2111117 = new Object[4];
                                                    int[] iArr19 = new int[i46];
                                                    objArr2111117[c] = iArr19;
                                                    int[] iArr110 = new int[i46];
                                                    objArr2111117[2] = iArr110;
                                                    int[] iArr111 = new int[i46];
                                                    objArr2111117[3] = iArr111;
                                                    int i12111112 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                    iArr110[0] = i;
                                                    iArr111[0] = i12111112;
                                                    objArr2111117[1] = null;
                                                    int i12111113 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                    int i12111114 = i12111113 << 13;
                                                    int i12111115 = (i12111114 & (~i12111113)) | ((~i12111114) & i12111113);
                                                    int i12111116 = i12111115 >>> 17;
                                                    int i12111117 = ((~i12111115) & i12111116) | ((~i12111116) & i12111115);
                                                    iArr19[0] = i12111117 ^ (i12111117 << 5);
                                                    return objArr2111117;
                                                }
                                            }
                                        }
                                    } else if (objInvoke4 != null) {
                                        Object[] objArr312 = {objInvoke4, 42};
                                        objComponent20 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent20 == null) {
                                            int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 53;
                                            char edgeSlop5 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                            int i1314 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 5420;
                                            byte b210 = (byte) ($$b & 7);
                                            byte b211 = b210;
                                            Object[] objArr313 = new Object[1];
                                            a(b210, b211, b211, objArr313);
                                            objComponent20 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf4, edgeSlop5, i1314, 1884899413, false, (String) objArr313[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue17 = ((Long) ((Method) objComponent20).invoke(null, objArr312)).longValue();
                                        j3 = 455607950256L + (434 * jLongValue17) + ((((1054648032 | j9) | jLongValue17) ^ (-1)) * 433) + ((-433) * (1054648032 | (((jLongValue17 ^ (-1)) | j7) ^ (-1)))) + (433 * ((((-1054648033) | jLongValue17) ^ (-1)) | ((1054648032 | j7) ^ (-1)))) + 1561801146;
                                        i42 = (int) (j3 >> 32);
                                        i43 = ~((~((int) Process.getElapsedCpuTime())) | 1922802100);
                                        if (((i42 & (((277938176 | i43) * (-374)) + 1308104882 + ((i43 | 1644863924) * 374))) | (((int) j3) & ((-2089544251) + (((~(1243981747 | i)) | (-193244663)) * (-366)) + (((~((-25167941) | i)) | 1075905025) * 366)))) == 542074309) {
                                            if (Build.VERSION.SDK_INT > 33) {
                                                int i916 = $vD14832N6715 + 29;
                                                $sG29839 = i916 % 128;
                                                int i1011111110 = i916 % 2;
                                                int i1011111111 = -TextUtils.indexOf("", "");
                                                int i1011111112 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                int i1011111113 = (i1011111112 & 28) + (i1011111112 | 28);
                                                Object[] objArr2111118 = new Object[1];
                                                c((byte) ((i1011111111 & 18) + (i1011111111 | 18)), i1011111113, "\u0005\u000f#\t\u0001\t\u001f\n\u0003\t㘈㘈\"\u0005\u0001\u0005\f\u000b\u0011\u001b\u001a\u000b\b\u0000\u0010\u000b\u0011\b", objArr2111118);
                                                Object[] objArr2111119 = {(String) objArr2111118[0]};
                                                objComponent23 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                                if (objComponent23 == null) {
                                                    int iBlue8 = 52 - Color.blue(0);
                                                    char c14 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 59724);
                                                    int maximumFlingVelocity8 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6317;
                                                    byte b11113 = (byte) ($$b & 7);
                                                    byte b11114 = b11113;
                                                    Object[] objArr21111110 = new Object[1];
                                                    a(b11113, b11114, b11114, objArr21111110);
                                                    objComponent23 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue8, c14, maximumFlingVelocity8, 1385817144, false, (String) objArr21111110[0], new Class[]{String.class});
                                                }
                                                long jLongValue18 = ((Long) ((Method) objComponent23).invoke(null, objArr2111119)).longValue();
                                                long jMyTid8 = Process.myTid();
                                                long j1112 = jMyTid8 ^ (-1);
                                                long j1113 = (334 * jLongValue18) + 220267928845L + ((((663457615 | j1112) ^ (-1)) | ((jLongValue18 | jMyTid8) ^ (-1))) * 333) + (333 * (((663457615 | jMyTid8) ^ (-1)) | ((j1112 | jLongValue18) ^ (-1)))) + 1068037522;
                                                int iMyPid8 = Process.myPid();
                                                int i1011111114 = ~iMyPid8;
                                                int i1011111115 = (~((-228072375) | i1011111114)) | 135272884;
                                                int i1011111116 = ~(iMyPid8 | 1301953526);
                                                i47 = ((int) (j1113 >> 32)) & (624737442 + ((i1011111115 | i1011111116) * (-502)) + ((i1011111116 | (~(i1011111114 | (-92799491)))) * 502));
                                                i48 = ((int) j1113) & (54948171 + (((~(187517286 | i50)) | (~(1249709123 | i))) * 210) + (((~((-16793893) | i50)) | (~((-1078985730) | i))) * 210));
                                                if (((i47 & i48) | (i47 ^ i48)) == 1) {
                                                    zEquals = true;
                                                } else {
                                                    zEquals = false;
                                                }
                                                i46 = 1;
                                                c = 0;
                                            } else {
                                                int i1011111117 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int iVD14832N67113 = qU20128.vD14832N6715();
                                                int i1011111118 = i1011111117 * 615;
                                                int i1011111119 = ((i1011111118 | (-14099)) << 1) - (i1011111118 ^ (-14099));
                                                int i1111111110 = ~i1011111117;
                                                int i1111111111 = ~((i1111111110 ^ 23) | (i1111111110 & 23));
                                                int i1111111112 = i1011111119 + (((i1111111111 & iVD14832N67113) | (iVD14832N67113 ^ i1111111111) | (~((-24) | i1011111117))) * 614);
                                                int i1111111113 = ~iVD14832N67113;
                                                int i1111111114 = (~((i1111111110 ^ i1111111113) | (i1111111110 & i1111111113))) | (~((i1111111110 ^ 23) | (i1111111110 & 23)));
                                                int i1111111115 = ~iVD14832N67113;
                                                int i1111111116 = ~((i1111111115 & 23) | (i1111111115 ^ 23));
                                                int i1111111117 = (i1111111112 - (~(((i1111111116 & i1111111114) | (i1111111114 ^ i1111111116)) * (-1228)))) - 1;
                                                int i1111111118 = ~((i1111111110 ^ (-24)) | (i1111111110 & (-24)) | i1111111113);
                                                int i1111111119 = (i1011111117 & i1111111113) | (i1111111113 ^ i1011111117);
                                                int i12111118 = ~((i1111111119 & 23) | (i1111111119 ^ 23));
                                                Object[] objArr21111111 = new Object[1];
                                                c((byte) ((i1111111117 - (~(((i12111118 & i1111111118) | (i1111111118 ^ i12111118)) * 614))) - 1), 13 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), "\f \u0010\n\f\u000b\u0011\u001b\u001a\u000b\b\u0000㘖", objArr21111111);
                                                Object[] objArr21111112 = {(String) objArr21111111[0]};
                                                objComponent22 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                                if (objComponent22 == null) {
                                                    int iIndexOf8 = TextUtils.indexOf("", "", 0, 0) + 52;
                                                    char packedPositionType8 = (char) ExpandableListView.getPackedPositionType(0L);
                                                    int fadingEdgeLength8 = 6473 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                    byte b11115 = (byte) (-$$a[6]);
                                                    byte b11116 = (byte) (b11115 - 3);
                                                    Object[] objArr21111113 = new Object[1];
                                                    a(b11115, b11116, b11116, objArr21111113);
                                                    objComponent22 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf8, packedPositionType8, fadingEdgeLength8, 1068791596, false, (String) objArr21111113[0], new Class[]{String.class});
                                                }
                                                Object objInvoke12 = ((Method) objComponent22).invoke(null, objArr21111112);
                                                int i12111119 = -TextUtils.lastIndexOf("", '0');
                                                i46 = 1;
                                                c = 0;
                                                Object[] objArr21111114 = new Object[1];
                                                c((byte) (((i12111119 | 57) << 1) - (i12111119 ^ 57)), 0 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "㗥", objArr21111114);
                                                zEquals = objInvoke12.equals((String) objArr21111114[0]);
                                            }
                                            if (zEquals) {
                                                Object[] objArr21111115 = new Object[4];
                                                int[] iArr112 = new int[i46];
                                                objArr21111115[c] = iArr112;
                                                int[] iArr113 = new int[i46];
                                                objArr21111115[2] = iArr113;
                                                int[] iArr114 = new int[i46];
                                                objArr21111115[3] = iArr114;
                                                int i121111110 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED);
                                                iArr113[0] = i;
                                                iArr114[0] = i121111110;
                                                objArr21111115[1] = null;
                                                int i121111111 = ((((-2122468624) + (((~((-828128358) | i)) | 1846273) * 345)) + (((~((-828128358) | i50)) | 229760) * 345)) + ((~(i | (-1846274))) * 345)) - 795555801;
                                                int i121111112 = i121111111 << 13;
                                                int i121111113 = (i121111112 & (~i121111111)) | ((~i121111112) & i121111111);
                                                int i121111114 = i121111113 >>> 17;
                                                int i121111115 = ((~i121111113) & i121111114) | ((~i121111114) & i121111113);
                                                iArr112[0] = i121111115 ^ (i121111115 << 5);
                                                return objArr21111115;
                                            }
                                        }
                                    }
                                }
                            } else {
                                f = 0.0f;
                            }
                            int i140 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            int i141 = i140 * 371;
                            int i142 = (10865106 ^ i141) + ((i141 & 10865106) << 1);
                            int i143 = ~(((-29287) ^ i50) | ((-29287) & i50));
                            int i144 = ~i140;
                            int i145 = ~((i144 ^ i) | (i144 & i));
                            int i146 = ((i143 & i145) | (i143 ^ i145)) * (-370);
                            int i147 = ((i142 | i146) << 1) - (i146 ^ i142);
                            int i148 = ~(i144 | i50);
                            int i149 = ~(((-29287) ^ i) | ((-29287) & i));
                            int i150 = (i148 & i149) | (i148 ^ i149);
                            int i151 = (i140 & 29286) | (i140 ^ 29286);
                            int i152 = ~i151;
                            int i153 = (i147 - (~(((i150 & i152) | (i150 ^ i152)) * (-370)))) - 1;
                            int i154 = -(-((~i151) * 370));
                            int i155 = (i153 & i154) + (i154 | i153);
                            Object[] objArr40 = new Object[1];
                            b("㋯䂍혢旤ﭹ\u0ee8鲝ሬ", i155, objArr40);
                            String str3 = (String) objArr40[0];
                            int i156 = -(-ImageFormat.getBitsPerPixel(0));
                            int edgeSlop6 = ViewConfiguration.getEdgeSlop() >> 16;
                            int iVD14832N67114 = qU20128.vD14832N6715();
                            int i157 = edgeSlop6 * 624;
                            int i158 = (i157 ^ (-3732)) + ((i157 & (-3732)) << 1);
                            int i159 = ((-7) ^ edgeSlop6) | ((-7) & edgeSlop6);
                            int i160 = -(-((~((i159 ^ iVD14832N67114) | (i159 & iVD14832N67114))) * 623));
                            int i161 = ((i158 | i160) << 1) - (i158 ^ i160);
                            int i162 = ~iVD14832N67114;
                            int i163 = ~edgeSlop6;
                            int i164 = ~((i163 & 6) | (i163 ^ 6));
                            int i165 = i161 + (((i162 & i164) | (i162 ^ i164)) * (-623));
                            int i166 = ~i159;
                            int i167 = ~(((-7) ^ iVD14832N67114) | ((-7) & iVD14832N67114));
                            int i168 = (i166 & i167) | (i166 ^ i167);
                            int i169 = ~((edgeSlop6 & iVD14832N67114) | (edgeSlop6 ^ iVD14832N67114));
                            int i170 = -(-(((i169 & i168) | (i168 ^ i169)) * 623));
                            int i171 = (i165 & i170) + (i170 | i165);
                            Object[] objArr41 = new Object[1];
                            c((byte) ((i156 ^ 34) + ((i156 & 34) << 1)), i171, "\u000e\u0014\u0001\u000b#\u001c", objArr41);
                            String str4 = (String) objArr41[0];
                            int mode = View.MeasureSpec.getMode(0);
                            int i172 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            int i173 = ((i172 | 6) << 1) - (i172 ^ 6);
                            Object[] objArr42 = new Object[1];
                            c((byte) ((mode & 31) + (mode | 31)), i173, "\n\u001c\r\u0015\f\u000f㘝", objArr42);
                            String str5 = (String) objArr42[0];
                            int maxKeyCode2 = KeyEvent.getMaxKeyCode() >> 16;
                            int i174 = (maxKeyCode2 ^ 17783) + ((maxKeyCode2 & 17783) << 1);
                            Object[] objArr43 = new Object[1];
                            b("㋩瞝렂\ue298✷榯鈲풪᥄", i174, objArr43);
                            String str6 = (String) objArr43[0];
                            int i175 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                            int i176 = (i175 ^ 1811) + ((i175 & 1811) << 1);
                            Object[] objArr44 = new Object[1];
                            b("㋧㗹㳄⟔⺮ᆸ", i176, objArr44);
                            String str7 = (String) objArr44[0];
                            Object[] objArr45 = new Object[1];
                            b("㋧洯赹\u2d97䶟\uede1ఱ걅첃沮貶⼙余", 24527 - (~TextUtils.indexOf((CharSequence) "", '0', 0, 0)), objArr45);
                            String str8 = (String) objArr45[0];
                            int i177 = -View.resolveSizeAndState(0, 0, 0);
                            int i178 = -(ViewConfiguration.getTapTimeout() >> 16);
                            int i179 = (i178 ^ 5) + ((i178 & 5) << 1);
                            Object[] objArr46 = new Object[1];
                            c((byte) (((i177 | 32) << 1) - (i177 ^ 32)), i179, "\u0006\u001f\"\u001f㘊", objArr46);
                            String str9 = (String) objArr46[0];
                            Object[] objArr47 = new Object[1];
                            b("㋧๋䮁蓣쀼ᴴ", ((byte) KeyEvent.getModifierMetaStateMask()) + 15542, objArr47);
                            String str10 = (String) objArr47[0];
                            int absoluteGravity = Gravity.getAbsoluteGravity(0, 0);
                            int iLastIndexOf5 = TextUtils.lastIndexOf("", '0', 0);
                            int i180 = (iLastIndexOf5 & 3) + (iLastIndexOf5 | 3);
                            Object[] objArr48 = new Object[1];
                            c((byte) ((absoluteGravity & 116) + (absoluteGravity | 116)), i180, "\u0006\u0019", objArr48);
                            String str11 = (String) objArr48[0];
                            byte b30 = (byte) (14 - (~(-(Process.myPid() >> 22))));
                            int i181 = -KeyEvent.normalizeMetaState(0);
                            int i182 = i181 * (-947);
                            int i183 = ((i182 | 15184) << 1) - (i182 ^ 15184);
                            int i184 = ~i181;
                            int i185 = ((-17) ^ i) | ((-17) & i);
                            int i186 = (i183 - (~(-(-(((~i185) | i184) * (-948)))))) - 1;
                            int i187 = (i184 & (-17)) | (i184 ^ (-17));
                            int i188 = (~((i187 & i50) | (i187 ^ i50))) * (-948);
                            int i189 = ((i186 | i188) << 1) - (i188 ^ i186);
                            int i190 = ((i181 & (-17)) | (i181 ^ (-17))) * 948;
                            int i191 = (i189 & i190) + (i190 | i189);
                            Object[] objArr49 = new Object[1];
                            c(b30, i191, "\u0000 #\u000b\f\u000f\u0019\r\u0015\u001f\u0007\u0016 \t\u000f ", objArr49);
                            String str12 = (String) objArr49[0];
                            Object[] objArr50 = new Object[1];
                            b("㋢彲\ue9cf穃蒣ᄶꎘ춥幤\ue8c6", 28050 - (~(ViewConfiguration.getJumpTapTimeout() >> 16)), objArr50);
                            String str13 = (String) objArr50[0];
                            int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0);
                            int i192 = -TextUtils.lastIndexOf("", '0', 0, 0);
                            int i193 = (i192 & 7) + (i192 | 7);
                            Object[] objArr51 = new Object[1];
                            c((byte) ((bitsPerPixel2 & 74) + (bitsPerPixel2 | 74)), i193, "\u0002\u0011#\u0006\u0014\u000e#\u001e", objArr51);
                            String str14 = (String) objArr51[0];
                            byte b31 = (byte) (32 - (~(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))));
                            int i194 = -(Process.myTid() >> 22);
                            int i195 = (i194 ^ 12) + ((i194 & 12) << 1);
                            Object[] objArr52 = new Object[1];
                            c(b31, i195, "\u0002\u0011#\u0012\u0006#㘖㘖\u0017\u0011\"\u0003", objArr52);
                            String str15 = (String) objArr52[0];
                            int i196 = -Color.red(0);
                            int i197 = ((64063 | i196) << 1) - (i196 ^ 64063);
                            Object[] objArr53 = new Object[1];
                            b("㋾죃욟\udc55\uda11퇚\uef98\ue55b\ue313ﻚ\uf48c\uf258蠎蟑", i197, objArr53);
                            String str16 = (String) objArr53[0];
                            int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                            int i198 = ~((~maximumDrawingCacheSize) | 43);
                            int i199 = ~((i ^ 43) | (i & 43));
                            int i200 = ((((maximumDrawingCacheSize * 71) - 2967) - (~(((i198 & i199) | (i198 ^ i199)) * (-140)))) - 1) + ((~((maximumDrawingCacheSize ^ 43) | (maximumDrawingCacheSize & 43) | i)) * 70);
                            int i201 = ~maximumDrawingCacheSize;
                            int i202 = ~((i201 & 43) | (i201 ^ 43));
                            int i203 = ~(((-44) ^ maximumDrawingCacheSize) | ((-44) & maximumDrawingCacheSize));
                            int i204 = (i202 & i203) | (i202 ^ i203);
                            int i205 = ~((maximumDrawingCacheSize & i) | (maximumDrawingCacheSize ^ i));
                            int i206 = ((i205 & i204) | (i204 ^ i205)) * 70;
                            Object[] objArr54 = new Object[1];
                            c((byte) (((i200 | i206) << 1) - (i206 ^ i200)), 6 - (~(-(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24)))), "\u000f\f\u0012\"\u0010!㘙", objArr54);
                            String str17 = (String) objArr54[0];
                            int i207 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            Object[] objArr55 = new Object[1];
                            c((byte) ((i207 & 96) + (i207 | 96)), 6 - (~(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24))), "\u0012\r\u0000\u001e\u0014\n㙋", objArr55);
                            String str18 = (String) objArr55[0];
                            Object[] objArr56 = new Object[1];
                            b("㋽හ䲔轖츖໌䧟", TextUtils.indexOf((CharSequence) "", '0') + 16188, objArr56);
                            String str19 = (String) objArr56[0];
                            Object[] objArr57 = new Object[1];
                            b("㋽橰", 22668 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr57);
                            String str20 = (String) objArr57[0];
                            int i208 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                            int i209 = -(-TextUtils.getTrimmedLength(""));
                            int i210 = (i209 & 20) + (i209 | 20);
                            Object[] objArr58 = new Object[1];
                            c((byte) ((i208 & 99) + (i208 | 99)), i210, "\u0015\u001f\u000e\u0014\u001f\u0003\u0019\u0006\u001e\u000f\u0002\u0003#\u0006 \u000b#\u0017#\"", objArr58);
                            String str21 = (String) objArr58[0];
                            Object[] objArr59 = new Object[1];
                            c((byte) (49 - (~(-KeyEvent.getDeadChar(0, 0)))), 5 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16)), "\u0015\u001f\u0014\u000e\u0011\u0017", objArr59);
                            String str22 = (String) objArr59[0];
                            Object[] objArr60 = new Object[1];
                            c((byte) (33 - (~(-(AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1))))), 16777217 - (~Color.rgb(0, 0, 0)), "\u0015\r", objArr60);
                            String str23 = (String) objArr60[0];
                            int i211 = -ImageFormat.getBitsPerPixel(0);
                            int i212 = (i211 ^ 12712) + ((i211 & 12712) << 1);
                            Object[] objArr61 = new Object[1];
                            b("㋽͆冲ꘜ\uf45e쪪ᬂ楴뾴豒쉧Ⴙ愃띯藅\uda1a", i212, objArr61);
                            String str24 = (String) objArr61[0];
                            int i213 = -(-(Process.myPid() >> 22));
                            int i214 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            int i215 = i214 * 659;
                            int i216 = ((i215 | (-5913)) << 1) - (i215 ^ (-5913));
                            int i217 = ~i214;
                            int i218 = ~((i217 & 9) | (i217 ^ 9));
                            int i219 = ~(((-10) ^ i214) | ((-10) & i214));
                            int i220 = (i218 & i219) | (i218 ^ i219);
                            int i221 = (i214 ^ i) | (i214 & i);
                            int i222 = ~i221;
                            int i223 = i216 + (((i220 & i222) | (i220 ^ i222)) * (-658));
                            int i224 = (~(((-10) ^ i214) | ((-10) & i214))) * 658;
                            int i225 = (((i223 | i224) << 1) - (i224 ^ i223)) + (((~((i214 & (-10)) | ((-10) ^ i214))) | (~i221)) * 658);
                            Object[] objArr62 = new Object[1];
                            c((byte) (((i213 | 54) << 1) - (i213 ^ 54)), i225, " \u000f\t\u0006\u0017\u000b\t 㘨", objArr62);
                            String str25 = (String) objArr62[0];
                            int i226 = -(-Color.green(0));
                            int i227 = (i226 & 8147) + (i226 | 8147);
                            Object[] objArr63 = new Object[1];
                            b("㋺\u2d2f\u0d49涔䶧귡谝\uec3f챾ⳓ", i227, objArr63);
                            String str26 = (String) objArr63[0];
                            int i228 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                            Object[] objArr64 = new Object[1];
                            c((byte) ((i228 & 47) + (i228 | 47)), 11 - (ViewConfiguration.getDoubleTapTimeout() >> 16), " \u000f\t\u0006\f\u000f!\f#\u000f㗛", objArr64);
                            String str27 = (String) objArr64[0];
                            Object[] objArr65 = new Object[1];
                            b("㋻罵꧓\uda58Ҵ넃\ue3afⷴ幈裕㔳", ((Process.getThreadPriority(0) + 20) >> 6) + 19861, objArr65);
                            String str28 = (String) objArr65[0];
                            int i229 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            int iVD14832N67115 = qU20128.vD14832N6715();
                            int i230 = i229 * (-1529);
                            int i231 = ((-46604) & i230) + (i230 | (-46604));
                            int i232 = ~i229;
                            int i233 = (i232 ^ (-62)) | (i232 & (-62));
                            int i234 = ~iVD14832N67115;
                            int i235 = ~((i233 & i234) | (i233 ^ i234));
                            int i236 = (i232 ^ 61) | (i232 & 61);
                            int i237 = ~((i236 ^ iVD14832N67115) | (i236 & iVD14832N67115));
                            int i238 = (i235 ^ i237) | (i235 & i237);
                            int i239 = ((-62) ^ i229) | ((-62) & i229);
                            int i240 = ~((i239 ^ iVD14832N67115) | (i239 & iVD14832N67115));
                            int i241 = i231 + (((i238 ^ i240) | (i238 & i240)) * 765);
                            int i242 = ~((i232 ^ (-62)) | (i232 & (-62)));
                            int i243 = ~((i234 & i232) | (i232 ^ i234));
                            int i244 = (i241 - (~(-(-(((i242 & i243) | (i242 ^ i243)) * 1530))))) - 1;
                            int i245 = ~((i232 & iVD14832N67115) | (i232 ^ iVD14832N67115));
                            int i246 = ~iVD14832N67115;
                            int i247 = ~(i229 | (i246 & (-62)) | ((-62) ^ i246));
                            int i248 = -(-(((i247 & i245) | (i245 ^ i247)) * 765));
                            Object[] objArr66 = new Object[1];
                            c((byte) (((i244 | i248) << 1) - (i248 ^ i244)), 14 - (~(AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1))), "\u0010!\u0019\u0006\u0004\n\u0002\r\u0017#\u0007\r#\u0016㘳", objArr66);
                            String str29 = (String) objArr66[0];
                            Object[] objArr67 = new Object[1];
                            b("㋻ṧ毷띲胼\uec49㧻Ռ囏ꉜ辪\udb2cⒶ瀦", 11398 - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), objArr67);
                            String[] strArr = {str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, (String) objArr67[0]};
                            Object[] objArr68 = new Object[1];
                            b("㋼\uda72\ue386譟那렣䆘滼癷ῗ❕", 59539 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))), objArr68);
                            Object[] objArr69 = {(String) objArr68[0]};
                            Object objComponent31 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                            if (objComponent31 == null) {
                                int offsetBefore = TextUtils.getOffsetBefore("", 0) + 52;
                                char cArgb = (char) Color.argb(0, 0, 0, 0);
                                int i249 = (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)) + 6473;
                                byte b32 = (byte) (-$$a[6]);
                                byte b33 = (byte) (b32 - 3);
                                Object[] objArr70 = new Object[1];
                                a(b32, b33, b33, objArr70);
                                objComponent31 = setSystemGestureExclusionRectsL30479.vD14832N6715(offsetBefore, cArgb, i249, 1068791596, false, (String) objArr70[0], new Class[]{String.class});
                            }
                            String str30 = (String) ((Method) objComponent31).invoke(null, objArr69);
                            if (str30 != null) {
                                int iMyTid = Process.myTid() >> 22;
                                int i250 = -View.getDefaultSize(0, 0);
                                int i251 = ((i250 | 6) << 1) - (i250 ^ 6);
                                Object[] objArr71 = new Object[1];
                                c((byte) ((iMyTid ^ 35) + ((iMyTid & 35) << 1)), i251, "\u0014\u000e#\n\r\u0010", objArr71);
                                String str31 = (String) objArr71[0];
                                int i252 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                Object[] objArr72 = new Object[1];
                                c((byte) (((i252 | 124) << 1) - (i252 ^ 124)), 7 - (~(-Color.argb(0, 0, 0, 0))), "\u0018#\u0003\u0005\u0013\u000b\u0012\r", objArr72);
                                String[] strArr2 = {str31, (String) objArr72[0]};
                                for (int i253 = 0; i253 < 2; i253 = ((i253 & 1) << 1) + (i253 ^ 1)) {
                                    if (str30.contains(strArr2[i253])) {
                                        int i254 = $vD14832N6715;
                                        int i255 = (i254 & 77) + (i254 | 77);
                                        $sG29839 = i255 % 128;
                                        int i256 = i255 % 2;
                                        int i257 = -(-ImageFormat.getBitsPerPixel(0));
                                        int i258 = (i257 & 59772) + (i257 | 59772);
                                        Object[] objArr73 = new Object[1];
                                        b("㋼\udb9a\ue056躏霐붆䨈傦礵ީⱮ㪪쌫\ue9df\uf641鳝ꕟ돆塜曚འᗼ≮", i258, objArr73);
                                        Object[] objArr74 = {(String) objArr73[0]};
                                        Object objComponent32 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                        if (objComponent32 == null) {
                                            int iRgb = (-16777164) - Color.rgb(0, 0, 0);
                                            char cMyPid = (char) (Process.myPid() >> 22);
                                            int iLastIndexOf6 = TextUtils.lastIndexOf("", '0', 0) + 6474;
                                            byte b34 = (byte) (-$$a[6]);
                                            byte b35 = (byte) (b34 - 3);
                                            Object[] objArr75 = new Object[1];
                                            a(b34, b35, b35, objArr75);
                                            objComponent32 = setSystemGestureExclusionRectsL30479.vD14832N6715(iRgb, cMyPid, iLastIndexOf6, 1068791596, false, (String) objArr75[0], new Class[]{String.class});
                                        }
                                        Object objInvoke13 = ((Method) objComponent32).invoke(null, objArr74);
                                        int i259 = -(-Gravity.getAbsoluteGravity(0, 0));
                                        Object[] objArr76 = new Object[1];
                                        c((byte) ((i259 & 46) + (i259 | 46)), 30 - Drawable.resolveOpacity(0, 0), "\f \u000b\u0004\f \u0003\u0010\t#\u0007\u0016\u0015\u0014#\u000f\u001c\u0010\u0014\n!\u0010\u0014\u000b\t#\u0010\u000f\f\u000f", objArr76);
                                        Object[] objArr77 = {(String) objArr76[0]};
                                        Object objComponent33 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                        if (objComponent33 == null) {
                                            int fadingEdgeLength9 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 52;
                                            char cMyTid = (char) (Process.myTid() >> 22);
                                            int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6473;
                                            byte b36 = (byte) (-$$a[6]);
                                            byte b37 = (byte) (b36 - 3);
                                            Object[] objArr78 = new Object[1];
                                            a(b36, b37, b37, objArr78);
                                            objComponent33 = setSystemGestureExclusionRectsL30479.vD14832N6715(fadingEdgeLength9, cMyTid, maximumDrawingCacheSize2, 1068791596, false, (String) objArr78[0], new Class[]{String.class});
                                        }
                                        Object objInvoke14 = ((Method) objComponent33).invoke(null, objArr77);
                                        if (objInvoke13 != 0) {
                                            int i260 = $vD14832N6715;
                                            int i261 = (i260 ^ 67) + ((i260 & 67) << 1);
                                            $sG29839 = i261 % 128;
                                            int i262 = i261 % 2;
                                            Object[] objArr79 = {objInvoke13, 42};
                                            Object objComponent34 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent34 == null) {
                                                int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 52;
                                                char cMyTid2 = (char) (Process.myTid() >> 22);
                                                int defaultSize3 = View.getDefaultSize(0, 0) + 5420;
                                                byte b38 = (byte) ($$b & 7);
                                                byte b39 = b38;
                                                Object[] objArr80 = new Object[1];
                                                a(b38, b39, b39, objArr80);
                                                objComponent34 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority, cMyTid2, defaultSize3, 1884899413, false, (String) objArr80[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue19 = ((Long) ((Method) objComponent34).invoke(null, objArr79)).longValue();
                                            long j23 = jLongValue19 ^ (-1);
                                            long j24 = (int) Runtime.getRuntime().totalMemory();
                                            long j25 = j24 ^ (-1);
                                            long j26 = (-87073597765L) + ((-209) * jLongValue19) + ((((-416620086) | j23) ^ (-1)) * 210) + ((((j23 | j25) ^ (-1)) | (((-416620086) | j24) ^ (-1))) * 210) + (210 * (((((-416620086) | j25) | jLongValue19) ^ (-1)) | (((j23 | 416620085) | j24) ^ (-1)))) + 90533028;
                                            int iMaxMemory3 = (int) Runtime.getRuntime().maxMemory();
                                            int i263 = ((int) (j26 >> 32)) & ((((-818884594) + (((~iMaxMemory3) | 674259520) * 1324)) + (((~(iMaxMemory3 | 695820866)) | (~(741405544 | iMaxMemory3))) * (-1324))) - 1405263204);
                                            int i264 = ((int) j26) & (1340383681 + (((~((-135289361) | i)) | (-1301937050)) * (-756)) + (((-135289361) | i50) * 756));
                                            if (((i263 & i264) | (i263 ^ i264)) == 477111747) {
                                                i38 = 0;
                                                for (i37 = 0; i37 < 28; i37 = (i37 ^ 1) + ((i37 & 1) << 1)) {
                                                    String str32 = strArr[i37];
                                                    int i265 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                    int i266 = ((i265 | 12007) << 1) - (i265 ^ 12007);
                                                    Object[] objArr81 = new Object[1];
                                                    b("㊡ᰚ漹빈襦\ud868⮉竰䗔铸\ue7e6ㅌ", i266, objArr81);
                                                    Object[] objArr82 = {((String) objArr81[0]).concat(String.valueOf(str32))};
                                                    objComponent19 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                                                    if (objComponent19 == null) {
                                                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 52;
                                                        char cLastIndexOf = (char) (59724 - TextUtils.lastIndexOf("", '0', 0));
                                                        int iRed3 = 6317 - Color.red(0);
                                                        byte b40 = (byte) ($$b & 7);
                                                        byte b41 = (byte) (b40 - 1);
                                                        Object[] objArr83 = new Object[1];
                                                        a(b40, b41, b41, objArr83);
                                                        objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay, cLastIndexOf, iRed3, 66836110, false, (String) objArr83[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue20 = ((Long) ((Method) objComponent19).invoke(null, objArr82)).longValue();
                                                    long j27 = (-933404618510L) + ((-1187) * jLongValue20);
                                                    long j28 = (1568747257 | jLongValue20) ^ (-1);
                                                    long jUptimeMillis = (int) SystemClock.uptimeMillis();
                                                    long j29 = jUptimeMillis ^ (-1);
                                                    long j30 = jLongValue20 ^ (-1);
                                                    long j31 = (j29 | (-1568747258)) ^ (-1);
                                                    j2 = j27 + ((-1188) * (j28 | ((j29 | jLongValue20) ^ (-1)))) + ((((j30 | jUptimeMillis) ^ (-1)) | j28 | j31) * 594) + (594 * (((j30 | j29) ^ (-1)) | ((j30 | (-1568747258)) ^ (-1)) | j31)) + 1724697624;
                                                    if (((((int) (j2 >> 32)) & (((((~(1739631893 | i)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 1823379662) + (((~(1739631893 | i50)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED))) | (((int) j2) & ((-635053948) + ((i | (-257)) * (-627)) + (((~(373447442 | i)) | (-1063778968)) * (-627)) + (((~((-373447443) | i50)) | (~((-1063778968) | i))) * 627)))) == 0) {
                                                        i40 = 0;
                                                    } else {
                                                        i40 = 1;
                                                    }
                                                    i38 = ((i38 | i40) << 1) - (i40 ^ i38);
                                                }
                                                if (i38 < 25.2d) {
                                                    break;
                                                }
                                                int i267 = $sG29839;
                                                int i268 = i267 + 35;
                                                $vD14832N6715 = i268 % 128;
                                                int i269 = i268 % 2;
                                                objArr4 = new Object[]{new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i}};
                                                int i270 = i ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED;
                                                int i271 = (-839624900) + (((~(i | (-444219050))) | 302000681 | (~(528203709 | i50))) * 886) + (((~(444219049 | i50)) | 385985341) * (-1772)) + ((~(i50 | 385985341)) * 886);
                                                int i272 = ((i271 | 16) << 1) - (i271 ^ 16);
                                                int i273 = ((i272 | (-795555817)) << 1) - (i272 ^ (-795555817));
                                                int i274 = i273 << 13;
                                                int i275 = (i274 & (~i273)) | ((~i274) & i273);
                                                int i276 = i275 ^ (i275 >>> 17);
                                                i39 = ((i267 | 39) << 1) - (i267 ^ 39);
                                                $vD14832N6715 = i39 % 128;
                                                if (i39 % 2 == 0) {
                                                    return objArr4;
                                                }
                                                Object obj2 = null;
                                                obj2.hashCode();
                                                throw null;
                                            }
                                            break;
                                        }
                                        objInvoke14 = objInvoke14;
                                        if (objInvoke14 == null) {
                                            break;
                                        }
                                        int i277 = $vD14832N6715 + 25;
                                        $sG29839 = i277 % 128;
                                        if (i277 % 2 != 0) {
                                            Object[] objArr84 = {objInvoke14, 42};
                                            Object objComponent35 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                            if (objComponent35 == null) {
                                                int maximumDrawingCacheSize3 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52;
                                                char cAlpha = (char) Color.alpha(0);
                                                int iIndexOf9 = TextUtils.indexOf("", "") + 5420;
                                                byte b42 = (byte) ($$b & 7);
                                                byte b43 = b42;
                                                Object[] objArr85 = new Object[1];
                                                a(b42, b43, b43, objArr85);
                                                objComponent35 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumDrawingCacheSize3, cAlpha, iIndexOf9, 1884899413, false, (String) objArr85[0], new Class[]{String.class, Integer.TYPE});
                                            }
                                            long jLongValue21 = ((Long) ((Method) objComponent35).invoke(null, objArr84)).longValue();
                                            long j32 = (58301023 | jLongValue21) ^ (-1);
                                            long j33 = jLongValue21 ^ (-1);
                                            long j34 = 115144522400L + (989 * jLongValue21) + ((j7 | j32) * 988) + ((-1976) * (((j33 | (-58301024)) ^ (-1)) | ((j9 | (-58301024)) ^ (-1)))) + (988 * (((jLongValue21 | j9) ^ (-1)) | j32 | ((j33 | j7) ^ (-1)))) + 565454137;
                                            int i278 = ((int) (j34 >> 32)) & ((-1019427974) + (((~((-19136529) | i50)) | (~((-604050755) | i50))) * (-184)) + (((~(1721327555 | i50)) | (-1740464084) | (~(1136413329 | i50))) * 184) + 579498640);
                                            int i279 = (int) j34;
                                            int i280 = ~((-2015488045) | i);
                                            int i281 = i279 & (((((-1515616943) | i280) * (-658)) - 504146809) + ((i280 | 539066368) * 658));
                                            if (((i278 & i281) | (i278 ^ i281)) != 477111747) {
                                                break;
                                            }
                                            i38 = 0;
                                            while (i37 < 28) {
                                                String str33 = strArr[i37];
                                                int i2610 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                int i2611 = ((i2610 | 12007) << 1) - (i2610 ^ 12007);
                                                Object[] objArr86 = new Object[1];
                                                b("㊡ᰚ漹빈襦\ud868⮉竰䗔铸\ue7e6ㅌ", i2611, objArr86);
                                                Object[] objArr87 = {((String) objArr86[0]).concat(String.valueOf(str33))};
                                                objComponent19 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                                                if (objComponent19 == null) {
                                                    int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 52;
                                                    char cLastIndexOf2 = (char) (59724 - TextUtils.lastIndexOf("", '0', 0));
                                                    int iRed4 = 6317 - Color.red(0);
                                                    byte b44 = (byte) ($$b & 7);
                                                    byte b45 = (byte) (b44 - 1);
                                                    Object[] objArr88 = new Object[1];
                                                    a(b44, b45, b45, objArr88);
                                                    objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay2, cLastIndexOf2, iRed4, 66836110, false, (String) objArr88[0], new Class[]{String.class});
                                                }
                                                long jLongValue22 = ((Long) ((Method) objComponent19).invoke(null, objArr87)).longValue();
                                                long j210 = (-933404618510L) + ((-1187) * jLongValue22);
                                                long j211 = (1568747257 | jLongValue22) ^ (-1);
                                                long jUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                                long j212 = jUptimeMillis2 ^ (-1);
                                                long j35 = jLongValue22 ^ (-1);
                                                long j36 = (j212 | (-1568747258)) ^ (-1);
                                                j2 = j210 + ((-1188) * (j211 | ((j212 | jLongValue22) ^ (-1)))) + ((((j35 | jUptimeMillis2) ^ (-1)) | j211 | j36) * 594) + (594 * (((j35 | j212) ^ (-1)) | ((j35 | (-1568747258)) ^ (-1)) | j36)) + 1724697624;
                                                if (((((int) (j2 >> 32)) & (((((~(1739631893 | i)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 1823379662) + (((~(1739631893 | i50)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED))) | (((int) j2) & ((-635053948) + ((i | (-257)) * (-627)) + (((~(373447442 | i)) | (-1063778968)) * (-627)) + (((~((-373447443) | i50)) | (~((-1063778968) | i))) * 627)))) == 0) {
                                                    i40 = 0;
                                                } else {
                                                    i40 = 1;
                                                }
                                                i38 = ((i38 | i40) << 1) - (i40 ^ i38);
                                            }
                                            if (i38 < 25.2d) {
                                                break;
                                            }
                                            int i2612 = $sG29839;
                                            int i2613 = i2612 + 35;
                                            $vD14832N6715 = i2613 % 128;
                                            int i2614 = i2613 % 2;
                                            objArr4 = new Object[]{new int[]{i276 ^ (i276 << 5)}, null, new int[]{i}, new int[]{i270}};
                                            int i2710 = i ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED;
                                            int i2711 = (-839624900) + (((~(i | (-444219050))) | 302000681 | (~(528203709 | i50))) * 886) + (((~(444219049 | i50)) | 385985341) * (-1772)) + ((~(i50 | 385985341)) * 886);
                                            int i2712 = ((i2711 | 16) << 1) - (i2711 ^ 16);
                                            int i2713 = ((i2712 | (-795555817)) << 1) - (i2712 ^ (-795555817));
                                            int i2714 = i2713 << 13;
                                            int i2715 = (i2714 & (~i2713)) | ((~i2714) & i2713);
                                            int i2716 = i2715 ^ (i2715 >>> 17);
                                            i39 = ((i2612 | 39) << 1) - (i2612 ^ 39);
                                            $vD14832N6715 = i39 % 128;
                                            if (i39 % 2 == 0) {
                                                return objArr4;
                                            }
                                            Object obj3 = null;
                                            obj3.hashCode();
                                            throw null;
                                        }
                                        Object[] objArr89 = {objInvoke14, 84};
                                        Object objComponent36 = setSystemGestureExclusionRectsL30479.component5(585894966);
                                        if (objComponent36 == null) {
                                            int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 52;
                                            char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                                            int capsMode = TextUtils.getCapsMode("", 0, 0) + 5420;
                                            byte b46 = (byte) ($$b & 7);
                                            byte b47 = b46;
                                            Object[] objArr90 = new Object[1];
                                            a(b46, b47, b47, objArr90);
                                            objComponent36 = setSystemGestureExclusionRectsL30479.vD14832N6715(tapTimeout2, deadChar, capsMode, 1884899413, false, (String) objArr90[0], new Class[]{String.class, Integer.TYPE});
                                        }
                                        long jLongValue23 = ((Long) ((Method) objComponent36).invoke(null, objArr89)).longValue();
                                        long j37 = jLongValue23 ^ (-1);
                                        long j38 = 48269703 | j37;
                                        long j39 = (-41898103072L) + (868 * jLongValue23) + ((-867) * (((48269703 | j9) ^ (-1)) | ((j37 | j9) ^ (-1)))) + ((-1734) * ((j38 ^ (-1)) | ((48269703 | j7) ^ (-1)) | ((j37 | j7) ^ (-1)))) + (867 * (((j38 | j9) ^ (-1)) | (((48269703 | jLongValue23) | j7) ^ (-1)) | (((j37 | (-48269704)) | j7) ^ (-1)))) + 555422817;
                                        int iMyUid2 = Process.myUid();
                                        int i282 = ~iMyUid2;
                                        int i283 = ((int) (j39 >>> 84)) & ((-802173004) + ((866078074 | i282) * (-369)) + ((864750650 | (~((-572475761) | i282))) * (-369)) + (((~(iMyUid2 | 572475760)) | 293602314 | (~(i282 | (-1327425)))) * 369));
                                        int i284 = ((int) j39) & ((((~((-1408921123) | i50)) | 1381641250) * (-241)) + 1815680598 + (((~((-27279873) | i50)) | 67178513) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION));
                                        if (((i283 & i284) | (i283 ^ i284)) != 477111747) {
                                            break;
                                        }
                                        i38 = 0;
                                        while (i37 < 28) {
                                            String str34 = strArr[i37];
                                            int i2615 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                            int i2616 = ((i2615 | 12007) << 1) - (i2615 ^ 12007);
                                            Object[] objArr810 = new Object[1];
                                            b("㊡ᰚ漹빈襦\ud868⮉竰䗔铸\ue7e6ㅌ", i2616, objArr810);
                                            Object[] objArr811 = {((String) objArr810[0]).concat(String.valueOf(str34))};
                                            objComponent19 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                                            if (objComponent19 == null) {
                                                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 52;
                                                char cLastIndexOf3 = (char) (59724 - TextUtils.lastIndexOf("", '0', 0));
                                                int iRed5 = 6317 - Color.red(0);
                                                byte b48 = (byte) ($$b & 7);
                                                byte b49 = (byte) (b48 - 1);
                                                Object[] objArr812 = new Object[1];
                                                a(b48, b49, b49, objArr812);
                                                objComponent19 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay3, cLastIndexOf3, iRed5, 66836110, false, (String) objArr812[0], new Class[]{String.class});
                                            }
                                            long jLongValue24 = ((Long) ((Method) objComponent19).invoke(null, objArr811)).longValue();
                                            long j213 = (-933404618510L) + ((-1187) * jLongValue24);
                                            long j214 = (1568747257 | jLongValue24) ^ (-1);
                                            long jUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                            long j215 = jUptimeMillis3 ^ (-1);
                                            long j310 = jLongValue24 ^ (-1);
                                            long j311 = (j215 | (-1568747258)) ^ (-1);
                                            j2 = j213 + ((-1188) * (j214 | ((j215 | jLongValue24) ^ (-1)))) + ((((j310 | jUptimeMillis3) ^ (-1)) | j214 | j311) * 594) + (594 * (((j310 | j215) ^ (-1)) | ((j310 | (-1568747258)) ^ (-1)) | j311)) + 1724697624;
                                            if (((((int) (j2 >> 32)) & (((((~(1739631893 | i)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 1823379662) + (((~(1739631893 | i50)) | 622088234) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED))) | (((int) j2) & ((-635053948) + ((i | (-257)) * (-627)) + (((~(373447442 | i)) | (-1063778968)) * (-627)) + (((~((-373447443) | i50)) | (~((-1063778968) | i))) * 627)))) == 0) {
                                                i40 = 0;
                                            } else {
                                                i40 = 1;
                                            }
                                            i38 = ((i38 | i40) << 1) - (i40 ^ i38);
                                        }
                                        if (i38 < 25.2d) {
                                            break;
                                        }
                                        int i2617 = $sG29839;
                                        int i2618 = i2617 + 35;
                                        $vD14832N6715 = i2618 % 128;
                                        int i2619 = i2618 % 2;
                                        objArr4 = new Object[]{new int[]{i2716 ^ (i2716 << 5)}, null, new int[]{i}, new int[]{i2710}};
                                        int i2717 = i ^ GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED;
                                        int i2718 = (-839624900) + (((~(i | (-444219050))) | 302000681 | (~(528203709 | i50))) * 886) + (((~(444219049 | i50)) | 385985341) * (-1772)) + ((~(i50 | 385985341)) * 886);
                                        int i2719 = ((i2718 | 16) << 1) - (i2718 ^ 16);
                                        int i27110 = ((i2719 | (-795555817)) << 1) - (i2719 ^ (-795555817));
                                        int i27111 = i27110 << 13;
                                        int i27112 = (i27111 & (~i27110)) | ((~i27111) & i27110);
                                        int i27113 = i27112 ^ (i27112 >>> 17);
                                        i39 = ((i2617 | 39) << 1) - (i2617 ^ 39);
                                        $vD14832N6715 = i39 % 128;
                                        if (i39 % 2 == 0) {
                                            return objArr4;
                                        }
                                        Object obj4 = null;
                                        obj4.hashCode();
                                        throw null;
                                    }
                                }
                            }
                            int packedPositionType9 = ExpandableListView.getPackedPositionType(0L);
                            int i285 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                            int i286 = ((i285 | 23) << 1) - (i285 ^ 23);
                            Object[] objArr91 = new Object[1];
                            c((byte) ((packedPositionType9 ^ 36) + ((packedPositionType9 & 36) << 1)), i286, "\u0001\u0015\u0015\u0014\u0005\u0015\u0015\u0001\u0017\r\u0001\b!\u0010!\u0002\u0010#\u0012#\u0011\b㘣", objArr91);
                            Object[] objArr92 = {(String) objArr91[0]};
                            Object objComponent37 = setSystemGestureExclusionRectsL30479.component5(1723180976);
                            if (objComponent37 == null) {
                                int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 52;
                                char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 941);
                                int size = View.MeasureSpec.getSize(0) + 5472;
                                byte b50 = (byte) ($$b & 7);
                                byte b51 = b50;
                                Object[] objArr93 = new Object[1];
                                a(b50, b51, b51, objArr93);
                                objComponent37 = setSystemGestureExclusionRectsL30479.vD14832N6715(pressedStateDuration, minimumFlingVelocity, size, 872473555, false, (String) objArr93[0], new Class[]{String.class});
                            }
                            long jLongValue25 = ((Long) ((Method) objComponent37).invoke(null, objArr92)).longValue();
                            long j40 = 84640884512L + ((-657) * jLongValue25);
                            long j41 = ((-128438369) | jLongValue25) ^ (-1);
                            long j42 = ((jLongValue25 ^ (-1)) | 128438368) ^ (-1);
                            long j43 = (128438368 | j7) ^ (-1);
                            long j44 = j40 + ((-658) * (j41 | j42 | j43)) + (658 * j42) + (658 * (j42 | j43)) + 378365736;
                            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                            int i287 = ((int) (j44 >> 32)) & ((-2042635829) + (((~((-1974695675) | iElapsedRealtime)) | 883045210) * (-465)) + (((-1974695675) | (~(883045210 | iElapsedRealtime))) * 930) + ((iElapsedRealtime | (-1091650721)) * 465));
                            int i288 = (int) j44;
                            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                            int i289 = ~((-1282018411) | iElapsedRealtime2);
                            int i290 = ~iElapsedRealtime2;
                            int i291 = i288 & ((-2038855459) + ((i289 | (~((-268468482) | i290))) * 920) + ((1282018410 | (~((-1307253995) | i290))) * 920) + (((~(iElapsedRealtime2 | (-268468482))) | (~((-1282018411) | i290)) | (~((-25235585) | iElapsedRealtime2))) * 920));
                            long j45 = (i287 & i291) | (i287 ^ i291);
                            int i292 = -(-TextUtils.indexOf("", "", 0, 0));
                            int i293 = -(-(ViewConfiguration.getWindowTouchSlop() >> 8));
                            int i294 = (i293 & 17) + (i293 | 17);
                            Object[] objArr94 = new Object[1];
                            c((byte) ((i292 ^ 42) + ((i292 & 42) << 1)), i294, "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0001\u0015 \t\u0003\u0015㘓", objArr94);
                            Object[] objArr95 = {(String) objArr94[0]};
                            Object objComponent38 = setSystemGestureExclusionRectsL30479.component5(1723180976);
                            if (objComponent38 == null) {
                                int scrollDefaultDelay3 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 52;
                                char cResolveSize = (char) (View.resolveSize(0, 0) + 941);
                                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 5472;
                                byte b52 = (byte) ($$b & 7);
                                byte b53 = b52;
                                Object[] objArr96 = new Object[1];
                                a(b52, b53, b53, objArr96);
                                objComponent38 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollDefaultDelay3, cResolveSize, keyRepeatTimeout, 872473555, false, (String) objArr96[0], new Class[]{String.class});
                            }
                            long jLongValue26 = ((Long) ((Method) objComponent38).invoke(null, objArr95)).longValue();
                            long jNextInt2 = new Random().nextInt(942456932);
                            long j46 = 73659091392L + (434 * jLongValue26) + ((((170507155 | (jNextInt2 ^ (-1))) | jLongValue26) ^ (-1)) * 433) + ((170507155 | (((jLongValue26 ^ (-1)) | jNextInt2) ^ (-1))) * (-433)) + (((((-170507156) | jLongValue26) ^ (-1)) | ((170507155 | jNextInt2) ^ (-1))) * 433) + 677311260;
                            int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
                            int i295 = ~iFreeMemory3;
                            int i296 = ((int) (j46 >> 32)) & (1968892170 + ((1208551568 | (~(124831503 | i295))) * 184) + ((iFreeMemory3 | 20988164) * (-184)) + ((~((-1312394908) | i295)) * 184));
                            int iUptimeMillis = (int) SystemClock.uptimeMillis();
                            int i297 = ((int) j46) & ((-1519080815) + (((~((-1445749299) | iUptimeMillis)) | 8522888) * (-756)) + (((~iUptimeMillis) | (-1445749299)) * 756));
                            long j47 = (i296 & i297) | (i296 ^ i297);
                            if (j45 > 0 && j47 > 0) {
                                int i298 = $sG29839;
                                int i299 = (i298 & 43) + (i298 | 43);
                                $vD14832N6715 = i299 % 128;
                                int i300 = i299 % 2;
                                if (j47 - 3 < j45) {
                                    Object[] objArr97 = {new int[1], null, new int[]{i}, new int[]{i}};
                                    int i301 = (i & (-248)) | (i50 & WebmConstants.MkvEbmlElement.CUE_TRACK);
                                    int iNextInt2 = new Random().nextInt(1515796207);
                                    int i302 = (-1831486522) + (((~(667193077 | iNextInt2)) | 163011313) * 672);
                                    int i303 = ~iNextInt2;
                                    int i304 = -(-(i302 + (((~(iNextInt2 | 163011313)) | (~((-667193078) | i303))) * (-672)) + (((~((-163011314) | i303)) | 137580544) * 672) + 16));
                                    int i305 = (i304 & (-795555817)) + (i304 | (-795555817));
                                    int i306 = (i305 << 13) ^ i305;
                                    int i307 = i306 >>> 17;
                                    int i308 = (i306 | i307) & (~(i306 & i307));
                                    int i309 = i308 << 5;
                                    ((int[]) objArr97[0])[0] = ((~i308) & i309) | ((~i309) & i308);
                                    return objArr97;
                                }
                            }
                            int i310 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            int i311 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int i312 = (i311 ^ 23) + ((i311 & 23) << 1);
                            Object[] objArr98 = new Object[1];
                            c((byte) ((i310 ^ 37) + ((i310 & 37) << 1)), i312, "\u0001\u0015\u0015\u0014\u0005\u0015\u0015\u0001\u0017\r\u0001\b!\u0010!\u0002\u0010#\u0012#\u0011\b㘣", objArr98);
                            Object[] objArr99 = {(String) objArr98[0]};
                            Object objComponent39 = setSystemGestureExclusionRectsL30479.component5(1723180976);
                            if (objComponent39 == null) {
                                int i313 = 53 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                float f2 = f;
                                char c15 = (char) ((TypedValue.complexToFraction(0, f2, f2) > f2 ? 1 : (TypedValue.complexToFraction(0, f2, f2) == f2 ? 0 : -1)) + 941);
                                int maxKeyCode3 = (KeyEvent.getMaxKeyCode() >> 16) + 5472;
                                byte b54 = (byte) ($$b & 7);
                                byte b55 = b54;
                                Object[] objArr100 = new Object[1];
                                a(b54, b55, b55, objArr100);
                                objComponent39 = setSystemGestureExclusionRectsL30479.vD14832N6715(i313, c15, maxKeyCode3, 872473555, false, (String) objArr100[0], new Class[]{String.class});
                            }
                            long jLongValue27 = ((Long) ((Method) objComponent39).invoke(null, objArr99)).longValue();
                            long j48 = (-12092343945L) + ((-209) * jLongValue27);
                            long j49 = jLongValue27 ^ (-1);
                            long jUptimeMillis4 = (int) SystemClock.uptimeMillis();
                            long j50 = jUptimeMillis4 ^ (-1);
                            long j51 = j48 + ((((-57858106) | j49) ^ (-1)) * 210) + ((((j49 | j50) ^ (-1)) | (((-57858106) | jUptimeMillis4) ^ (-1))) * 210) + (210 * (((((-57858106) | j50) | jLongValue27) ^ (-1)) | ((jUptimeMillis4 | (j49 | 57858105)) ^ (-1)))) + 448945999;
                            int elapsedCpuTime4 = (int) Process.getElapsedCpuTime();
                            int i314 = ~elapsedCpuTime4;
                            int i315 = ((int) (j51 >> 32)) & ((-2055567968) + (((~(979634981 | i314)) | (-1878105904)) * 226) + (((~(i314 | (-1167168523))) | 268697600 | (~(1878105903 | elapsedCpuTime4))) * (-113)) + ((~(elapsedCpuTime4 | 979634981)) * 113));
                            int i316 = ((int) j51) & ((((-1754753727) + (((~((-548210115) | i50)) | (-889016296)) * (-828))) + (((-548210115) | i50) * (-828))) - 1348558984);
                            long j52 = (i315 & i316) | (i315 ^ i316);
                            Object[] objArr101 = new Object[1];
                            c((byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 13), 2 - (~(-(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))), "\u0004\u0005\r\u001d", objArr101);
                            Object[] objArr102 = {(String) objArr101[0]};
                            Object objComponent40 = setSystemGestureExclusionRectsL30479.component5(1723180976);
                            if (objComponent40 == null) {
                                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 53;
                                char size2 = (char) (View.MeasureSpec.getSize(0) + 941);
                                int iRed6 = Color.red(0) + 5472;
                                byte b56 = (byte) ($$b & 7);
                                byte b57 = b56;
                                Object[] objArr103 = new Object[1];
                                a(b56, b57, b57, objArr103);
                                objComponent40 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionChild, size2, iRed6, 872473555, false, (String) objArr103[0], new Class[]{String.class});
                            }
                            long jLongValue28 = ((Long) ((Method) objComponent40).invoke(null, objArr102)).longValue();
                            long elapsedCpuTime5 = (int) Process.getElapsedCpuTime();
                            long j53 = (-14429877000L) + ((-55) * jLongValue28) + ((jLongValue28 | ((262361400 | elapsedCpuTime5) ^ (-1))) * 56) + ((-56) * ((262361400 | jLongValue28) ^ (-1))) + (56 * (262361400 | ((jLongValue28 | (elapsedCpuTime5 ^ (-1))) ^ (-1)))) + 244442704;
                            int iNextInt3 = new Random().nextInt(1509167712);
                            int i317 = ~iNextInt3;
                            int i318 = ((int) (j53 >> 32)) & (279605546 + ((~((-523978646) | i317)) * 979) + ((913247765 | iNextInt3) * (-979)) + (((~((-523978646) | iNextInt3)) | (~(i317 | 913247765))) * 979));
                            int i319 = ~(1674721405 | i50);
                            int i320 = ((int) j53) & (((33693777 | i319 | (~((-1674721406) | i))) * (-338)) + 1361335623 + ((i319 | (~((-1641027629) | i))) * 338));
                            long j54 = (i318 & i320) | (i318 ^ i320);
                            if (j52 > 0) {
                                int iVD14832N67116 = qU20128.vD14832N6715();
                                int i321 = ~iVD14832N67116;
                                int i322 = ~(((-534170229) & i321) | ((-534170229) ^ i321));
                                int i323 = -(-(((i322 & (-8636655)) | ((-8636655) ^ i322)) * (-90)));
                                int i324 = ((-1595259418) ^ i323) + ((i323 & (-1595259418)) << 1);
                                int i325 = ~(((-534170229) ^ iVD14832N67116) | ((-534170229) & iVD14832N67116));
                                int i326 = ((i325 ^ 65674) | (i325 & 65674)) * (-45);
                                int i327 = ((i324 | i326) << 1) - (i326 ^ i324);
                                int i328 = ((~((iVD14832N67116 & 8636654) | (8636654 ^ iVD14832N67116))) | (-534170229) | (~((i321 & (-8636655)) | (i321 ^ (-8636655))))) * 45;
                                int i329 = (i327 & i328) + (i327 | i328);
                                int i330 = ~i;
                                int i331 = (i330 & 609615254) | (i330 ^ 609615254);
                                int i332 = -(-((~((i331 & 1134200951) | (i331 ^ 1134200951))) * (-116)));
                                int i333 = (1324599337 & i332) + (i332 | 1324599337);
                                int i334 = -(-(((609615254 ^ i) | (609615254 & i)) * 116));
                                int i335 = (i333 & i334) + (i334 | i333);
                                int i336 = -(-(((~(((-1134200952) & i) | ((-1134200952) ^ i))) | 1083414) * 116));
                                if (i329 <= (i335 & i336) + (i336 | i335) ? j54 > 0 : j54 > 1) {
                                    if (j54 + 100 < j52) {
                                        int i337 = $vD14832N6715;
                                        int i338 = ((i337 | 31) << 1) - (i337 ^ 31);
                                        $sG29839 = i338 % 128;
                                        int i339 = i338 % 2;
                                        Object[] objArr104 = {new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i}};
                                        int i340 = (~(i & 248)) & (i | 248);
                                        int i341 = (((749508091 + (((~((-34147534) | i50)) | 796056857) * (-235))) + (((~((-34147534) | i)) | 796056857) * (-470))) + (((~(i | (-590021))) | 762499344) * 235)) - 795555801;
                                        int i342 = i341 << 13;
                                        int i343 = (i342 & (~i341)) | ((~i342) & i341);
                                        int i344 = i343 >>> 17;
                                        int i345 = (i343 | i344) & (~(i343 & i344));
                                        int i346 = i345 << 5;
                                        return objArr104;
                                    }
                                }
                            }
                            Object[] objArr105 = new Object[1];
                            b("㊡蜨奝ᎂ\ue5ae뿂瀝", View.combineMeasuredStates(0, 0) + 46549, objArr105);
                            String str35 = (String) objArr105[0];
                            Object[] objArr106 = new Object[1];
                            b("㊡뗠㳍Ɦ⺎酺ᡍ荪\u0a04\uf2e2痂", 34589 - (ViewConfiguration.getEdgeSlop() >> 16), objArr106);
                            String str36 = (String) objArr106[0];
                            int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0', 0);
                            int i347 = (iIndexOf10 & 38904) + (iIndexOf10 | 38904);
                            Object[] objArr107 = new Object[1];
                            b("㊡ꔊᴙ\uf518洦씸봩ᕠ赅敃\udd41땽", i347, objArr107);
                            String str37 = (String) objArr107[0];
                            int i348 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int i349 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                            int i350 = ((i349 | 12) << 1) - (i349 ^ 12);
                            Object[] objArr108 = new Object[1];
                            c((byte) ((i348 & 23) + (i348 | 23)), i350, "\u0001\u0015\u0015\u0014#\u000f\u0015\u0004\u001e\b\n\u001f", objArr108);
                            String str38 = (String) objArr108[0];
                            int i351 = -Color.red(0);
                            int i352 = -View.combineMeasuredStates(0, 0);
                            int i353 = (i352 & 11) + (i352 | 11);
                            Object[] objArr109 = new Object[1];
                            c((byte) ((i351 & 69) + (i351 | 69)), i353, "\u0001\u001b\u0010#\u0000\"\u000f\u0002\u0007\b㘹", objArr109);
                            String str39 = (String) objArr109[0];
                            int i354 = -(-View.getDefaultSize(0, 0));
                            int i355 = (i354 ^ 42223) + ((i354 & 42223) << 1);
                            Object[] objArr110 = new Object[1];
                            b("㊡阒笲\udc2aꅜ", i355, objArr110);
                            String str40 = (String) objArr110[0];
                            byte bResolveOpacity = (byte) (40 - Drawable.resolveOpacity(0, 0));
                            int i356 = -KeyEvent.getDeadChar(0, 0);
                            int i357 = (i356 & 4) + (i356 | 4);
                            Object[] objArr111 = new Object[1];
                            c(bResolveOpacity, i357, "\u0005\u000f#\t", objArr111);
                            String[] strArr3 = {str35, str36, str37, str38, str39, str40, (String) objArr111[0]};
                            int i358 = 7;
                            int i359 = 0;
                            while (true) {
                                if (i359 >= i358) {
                                    i2 = 0;
                                    break;
                                }
                                int i360 = $sG29839;
                                int i361 = (i360 ^ 21) + ((i360 & 21) << 1);
                                $vD14832N6715 = i361 % 128;
                                int i362 = i361 % 2;
                                Object[] objArr112 = {strArr3[i359]};
                                Object objComponent41 = setSystemGestureExclusionRectsL30479.component5(-1135701847);
                                if (objComponent41 == null) {
                                    int i363 = 51 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                                    int i364 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 5903;
                                    byte b58 = (byte) ($$b & 7);
                                    byte b59 = b58;
                                    Object[] objArr113 = new Object[1];
                                    a(b58, b59, b59, objArr113);
                                    objComponent41 = setSystemGestureExclusionRectsL30479.vD14832N6715(i363, bitsPerPixel3, i364, -285485878, false, (String) objArr113[0], new Class[]{String.class});
                                }
                                long jLongValue29 = ((Long) ((Method) objComponent41).invoke(null, objArr112)).longValue();
                                long jElapsedRealtime = 1349197912 | (((long) ((int) SystemClock.elapsedRealtime())) ^ (-1));
                                long j55 = (-666503768528L) + ((-494) * jLongValue29) + ((-495) * ((1349197912 | jLongValue29) ^ (-1))) + (495 * jElapsedRealtime) + (495 * ((((-1349197913) | (jLongValue29 ^ (-1))) ^ (-1)) | (jElapsedRealtime ^ (-1)))) + 15113178;
                                int i365 = ((int) (j55 >> 32)) & (((384374654 + (((~((-634659044) | i50)) | 634659011) * 446)) + (((~((-33) | i)) | 167908356) * 446)) - 409922630);
                                int i366 = ((int) j55) & ((((~((-272640417) | i)) * 521) - 1951178396) + (((~((-272640417) | i50)) | 16875529) * 521));
                                if (((i365 & i366) | (i365 ^ i366)) != 0) {
                                    int i367 = $sG29839 + 21;
                                    $vD14832N6715 = i367 % 128;
                                    int i368 = i367 % 2;
                                    i2 = i359 + 90;
                                    break;
                                }
                                int i369 = i359 + 102;
                                i359 = (i369 | (-101)) + (i369 & (-101));
                                strArr3 = strArr3;
                                i358 = 7;
                            }
                            if (i2 != 0) {
                                Object[] objArr114 = {new int[1], null, new int[]{i}, new int[]{(i2 | i) & (~(i & i2))}};
                                int iMyTid2 = Process.myTid();
                                int i370 = (((~((-7421971) | iMyTid2)) | 755666948) * TypedValues.Position.TYPE_TRANSITION_EASING) + 774745816 + ((~((~iMyTid2) | (-7421971))) * TypedValues.Position.TYPE_TRANSITION_EASING);
                                int i371 = -(-(((i370 | 16) << 1) - (i370 ^ 16)));
                                int i372 = (i371 ^ (-795555817)) + ((i371 & (-795555817)) << 1);
                                int i373 = (i372 << 13) ^ i372;
                                int i374 = i373 >>> 17;
                                int i375 = (i373 | i374) & (~(i373 & i374));
                                int i376 = i375 << 5;
                                ((int[]) objArr114[0])[0] = ((~i375) & i376) | ((~i376) & i375);
                                return objArr114;
                            }
                            try {
                                int i377 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                int i378 = (i377 & 62597) + (i377 | 62597);
                                Object[] objArr115 = new Object[1];
                                b("㋼왤\udbaa\uef63\ue0ef\uf47e觼鵉隈ꩋ뿓덊䓆", i378, objArr115);
                                try {
                                    Object[] objArr116 = {(String) objArr115[0]};
                                    Object objComponent42 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                    if (objComponent42 == null) {
                                        int i379 = 52 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                        char cResolveSize2 = (char) View.resolveSize(0, 0);
                                        int i380 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 6472;
                                        byte b60 = (byte) (-$$a[6]);
                                        byte b61 = (byte) (b60 - 3);
                                        Object[] objArr117 = new Object[1];
                                        a(b60, b61, b61, objArr117);
                                        objComponent42 = setSystemGestureExclusionRectsL30479.vD14832N6715(i379, cResolveSize2, i380, 1068791596, false, (String) objArr117[0], new Class[]{String.class});
                                    }
                                    String str41 = (String) ((Method) objComponent42).invoke(null, objArr116);
                                    if (str41 != null) {
                                        int i381 = -Color.blue(0);
                                        int i382 = ((i381 | 14797) << 1) - (i381 ^ 14797);
                                        Object[] objArr118 = new Object[1];
                                        b("㋭\u0b3a䅵龇헕Ꮸ栥ꙻﲋ㫔烨", i382, objArr118);
                                        String[] strArr4 = {(String) objArr118[0]};
                                        int i383 = 0;
                                        while (true) {
                                            if (i383 <= 0) {
                                                if (str41.contains(strArr4[i383])) {
                                                    int iMyPid9 = Process.myPid() >> 22;
                                                    int i384 = -(-TextUtils.lastIndexOf("", '0', 0, 0));
                                                    Object[] objArr119 = new Object[1];
                                                    c((byte) ((iMyPid9 ^ 95) + ((iMyPid9 & 95) << 1)), ((i384 | 19) << 1) - (i384 ^ 19), "\n\u001f\t\u001f\u0007\u0016\u001d\u0007\u0007\u0016\r\u0003\u0002\n\u0010\u0017\u001f#", objArr119);
                                                    try {
                                                        Object[] objArr120 = {(String) objArr119[0]};
                                                        objComponent17 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                                        if (objComponent17 == null) {
                                                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 52;
                                                            char cMyTid3 = (char) (Process.myTid() >> 22);
                                                            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 6473;
                                                            byte b62 = (byte) (-$$a[6]);
                                                            byte b63 = (byte) (b62 - 3);
                                                            Object[] objArr121 = new Object[1];
                                                            a(b62, b63, b63, objArr121);
                                                            objComponent17 = setSystemGestureExclusionRectsL30479.vD14832N6715(iCombineMeasuredStates, cMyTid3, scrollBarSize, 1068791596, false, (String) objArr121[0], new Class[]{String.class});
                                                        }
                                                        objInvoke = ((Method) objComponent17).invoke(null, objArr120);
                                                        if (objInvoke != null) {
                                                            int iVD14832N67117 = qU20128.vD14832N6715();
                                                            int i385 = ~iVD14832N67117;
                                                            int i386 = (~(((-161546251) & i385) | ((-161546251) ^ i385))) | (~(((-67160962) & iVD14832N67117) | ((-67160962) ^ iVD14832N67117)));
                                                            int i387 = ~(((-1912737909) & iVD14832N67117) | ((-1912737909) ^ iVD14832N67117));
                                                            int i388 = -(-(((i386 & i387) | (i386 ^ i387)) * 765));
                                                            int i389 = ((-1711139131) & i388) + (i388 | (-1711139131));
                                                            int i390 = ~(((-228707212) & i385) | ((-228707212) ^ i385));
                                                            int i391 = -(-(((i390 & 161546250) | (161546250 ^ i390)) * 1530));
                                                            int i392 = ((i389 | i391) << 1) - (i391 ^ i389);
                                                            int i393 = ~((iVD14832N67117 & (-228707212)) | ((-228707212) ^ iVD14832N67117));
                                                            int i394 = (i385 & (-2074284159)) | ((-2074284159) ^ i385);
                                                            int i395 = ~((i394 & 228707211) | (i394 ^ 228707211));
                                                            int i396 = -(-(((i393 & i395) | (i393 ^ i395)) * 765));
                                                            i33 = ((i392 | i396) << 1) - (i396 ^ i392);
                                                            int iVD14832N67118 = qU20128.vD14832N6715();
                                                            int i397 = ~((296905501 & iVD14832N67118) | (296905501 ^ iVD14832N67118));
                                                            int i398 = (-598980038) + (((i397 & 1816199168) | (1816199168 ^ i397)) * (-283));
                                                            i34 = ((i398 | 1091258787) << 1) - (1091258787 ^ i398);
                                                            i35 = -(-((~((iVD14832N67118 & 2113104669) | (2113104669 ^ iVD14832N67118))) * 283));
                                                            if (i33 > (i34 ^ i35) + ((i35 & i34) << 1)) {
                                                                objArr3 = new Object[1];
                                                                b("㋼\u1cfc滮룵諻퓃⛃", 27353 >> Color.green(0), objArr3);
                                                                if (!objInvoke.equals((String) objArr3[0])) {
                                                                    int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
                                                                    int i399 = -(-ImageFormat.getBitsPerPixel(0));
                                                                    Object[] objArr122 = new Object[1];
                                                                    c((byte) ((touchSlop ^ 116) + ((touchSlop & 116) << 1)), (i399 & 24) + (i399 | 24), "\u000b\u0017\r\u0014\r\u0019\"\t\u0014\u0015\u0016\u0007\f \u001f\"\u0002\u0007㙭㙭\r\u0017㙝", objArr122);
                                                                    try {
                                                                        Object[] objArr123 = {(String) objArr122[0]};
                                                                        objComponent18 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                                                        if (objComponent18 == null) {
                                                                            int i400 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52;
                                                                            char jumpTapTimeout2 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                            int maximumFlingVelocity9 = 6473 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                            byte b64 = (byte) (-$$a[6]);
                                                                            byte b65 = (byte) (b64 - 3);
                                                                            Object[] objArr124 = new Object[1];
                                                                            a(b64, b65, b65, objArr124);
                                                                            objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(i400, jumpTapTimeout2, maximumFlingVelocity9, 1068791596, false, (String) objArr124[0], new Class[]{String.class});
                                                                        }
                                                                        str = (String) ((Method) objComponent18).invoke(null, objArr123);
                                                                        if (str == null && (i36 = Integer.parseInt(str)) != 0) {
                                                                            i3 = i36 + 170;
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        Throwable cause = th.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                objArr2 = new Object[1];
                                                                b("㋼\u1cfc滮룵諻퓃⛃", Color.green(0) + 11783, objArr2);
                                                                if (!objInvoke.equals((String) objArr2[0])) {
                                                                    int touchSlop2 = ViewConfiguration.getTouchSlop() >> 8;
                                                                    int i3910 = -(-ImageFormat.getBitsPerPixel(0));
                                                                    Object[] objArr125 = new Object[1];
                                                                    c((byte) ((touchSlop2 ^ 116) + ((touchSlop2 & 116) << 1)), (i3910 & 24) + (i3910 | 24), "\u000b\u0017\r\u0014\r\u0019\"\t\u0014\u0015\u0016\u0007\f \u001f\"\u0002\u0007㙭㙭\r\u0017㙝", objArr125);
                                                                    Object[] objArr126 = {(String) objArr125[0]};
                                                                    objComponent18 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                                                    if (objComponent18 == null) {
                                                                        int i401 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52;
                                                                        char jumpTapTimeout3 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                        int maximumFlingVelocity10 = 6473 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                        byte b66 = (byte) (-$$a[6]);
                                                                        byte b67 = (byte) (b66 - 3);
                                                                        Object[] objArr127 = new Object[1];
                                                                        a(b66, b67, b67, objArr127);
                                                                        objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(i401, jumpTapTimeout3, maximumFlingVelocity10, 1068791596, false, (String) objArr127[0], new Class[]{String.class});
                                                                    }
                                                                    str = (String) ((Method) objComponent18).invoke(null, objArr126);
                                                                    if (str == null) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } catch (Throwable th2) {
                                                        Throwable cause2 = th2.getCause();
                                                        if (cause2 != null) {
                                                            throw cause2;
                                                        }
                                                        throw th2;
                                                    }
                                                } else {
                                                    i383++;
                                                }
                                            }
                                            i3 = 0;
                                        }
                                    } else {
                                        int iMyPid10 = Process.myPid() >> 22;
                                        int i3810 = -(-TextUtils.lastIndexOf("", '0', 0, 0));
                                        Object[] objArr1110 = new Object[1];
                                        c((byte) ((iMyPid10 ^ 95) + ((iMyPid10 & 95) << 1)), ((i3810 | 19) << 1) - (i3810 ^ 19), "\n\u001f\t\u001f\u0007\u0016\u001d\u0007\u0007\u0016\r\u0003\u0002\n\u0010\u0017\u001f#", objArr1110);
                                        Object[] objArr128 = {(String) objArr1110[0]};
                                        objComponent17 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                        if (objComponent17 == null) {
                                            int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 52;
                                            char cMyTid4 = (char) (Process.myTid() >> 22);
                                            int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 6473;
                                            byte b68 = (byte) (-$$a[6]);
                                            byte b69 = (byte) (b68 - 3);
                                            Object[] objArr129 = new Object[1];
                                            a(b68, b69, b69, objArr129);
                                            objComponent17 = setSystemGestureExclusionRectsL30479.vD14832N6715(iCombineMeasuredStates2, cMyTid4, scrollBarSize2, 1068791596, false, (String) objArr129[0], new Class[]{String.class});
                                        }
                                        objInvoke = ((Method) objComponent17).invoke(null, objArr128);
                                        if (objInvoke != null) {
                                            int iVD14832N67119 = qU20128.vD14832N6715();
                                            int i3811 = ~iVD14832N67119;
                                            int i3812 = (~(((-161546251) & i3811) | ((-161546251) ^ i3811))) | (~(((-67160962) & iVD14832N67119) | ((-67160962) ^ iVD14832N67119)));
                                            int i3813 = ~(((-1912737909) & iVD14832N67119) | ((-1912737909) ^ iVD14832N67119));
                                            int i3814 = -(-(((i3812 & i3813) | (i3812 ^ i3813)) * 765));
                                            int i3815 = ((-1711139131) & i3814) + (i3814 | (-1711139131));
                                            int i3911 = ~(((-228707212) & i3811) | ((-228707212) ^ i3811));
                                            int i3912 = -(-(((i3911 & 161546250) | (161546250 ^ i3911)) * 1530));
                                            int i3913 = ((i3815 | i3912) << 1) - (i3912 ^ i3815);
                                            int i3914 = ~((iVD14832N67119 & (-228707212)) | ((-228707212) ^ iVD14832N67119));
                                            int i3915 = (i3811 & (-2074284159)) | ((-2074284159) ^ i3811);
                                            int i3916 = ~((i3915 & 228707211) | (i3915 ^ 228707211));
                                            int i3917 = -(-(((i3914 & i3916) | (i3914 ^ i3916)) * 765));
                                            i33 = ((i3913 | i3917) << 1) - (i3917 ^ i3913);
                                            int iVD14832N671110 = qU20128.vD14832N6715();
                                            int i3918 = ~((296905501 & iVD14832N671110) | (296905501 ^ iVD14832N671110));
                                            int i3919 = (-598980038) + (((i3918 & 1816199168) | (1816199168 ^ i3918)) * (-283));
                                            i34 = ((i3919 | 1091258787) << 1) - (1091258787 ^ i3919);
                                            i35 = -(-((~((iVD14832N671110 & 2113104669) | (2113104669 ^ iVD14832N671110))) * 283));
                                            if (i33 > (i34 ^ i35) + ((i35 & i34) << 1)) {
                                                objArr3 = new Object[1];
                                                b("㋼\u1cfc滮룵諻퓃⛃", 27353 >> Color.green(0), objArr3);
                                                if (!objInvoke.equals((String) objArr3[0])) {
                                                    int touchSlop3 = ViewConfiguration.getTouchSlop() >> 8;
                                                    int i39110 = -(-ImageFormat.getBitsPerPixel(0));
                                                    Object[] objArr1210 = new Object[1];
                                                    c((byte) ((touchSlop3 ^ 116) + ((touchSlop3 & 116) << 1)), (i39110 & 24) + (i39110 | 24), "\u000b\u0017\r\u0014\r\u0019\"\t\u0014\u0015\u0016\u0007\f \u001f\"\u0002\u0007㙭㙭\r\u0017㙝", objArr1210);
                                                    Object[] objArr1211 = {(String) objArr1210[0]};
                                                    objComponent18 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                                    if (objComponent18 == null) {
                                                        int i402 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52;
                                                        char jumpTapTimeout4 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                        int maximumFlingVelocity11 = 6473 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                        byte b610 = (byte) (-$$a[6]);
                                                        byte b611 = (byte) (b610 - 3);
                                                        Object[] objArr1212 = new Object[1];
                                                        a(b610, b611, b611, objArr1212);
                                                        objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(i402, jumpTapTimeout4, maximumFlingVelocity11, 1068791596, false, (String) objArr1212[0], new Class[]{String.class});
                                                    }
                                                    str = (String) ((Method) objComponent18).invoke(null, objArr1211);
                                                    if (str == null) {
                                                    }
                                                }
                                            } else {
                                                objArr2 = new Object[1];
                                                b("㋼\u1cfc滮룵諻퓃⛃", Color.green(0) + 11783, objArr2);
                                                if (!objInvoke.equals((String) objArr2[0])) {
                                                    int touchSlop4 = ViewConfiguration.getTouchSlop() >> 8;
                                                    int i39111 = -(-ImageFormat.getBitsPerPixel(0));
                                                    Object[] objArr1213 = new Object[1];
                                                    c((byte) ((touchSlop4 ^ 116) + ((touchSlop4 & 116) << 1)), (i39111 & 24) + (i39111 | 24), "\u000b\u0017\r\u0014\r\u0019\"\t\u0014\u0015\u0016\u0007\f \u001f\"\u0002\u0007㙭㙭\r\u0017㙝", objArr1213);
                                                    Object[] objArr1214 = {(String) objArr1213[0]};
                                                    objComponent18 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                                                    if (objComponent18 == null) {
                                                        int i403 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52;
                                                        char jumpTapTimeout5 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                        int maximumFlingVelocity12 = 6473 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                        byte b612 = (byte) (-$$a[6]);
                                                        byte b613 = (byte) (b612 - 3);
                                                        Object[] objArr1215 = new Object[1];
                                                        a(b612, b613, b613, objArr1215);
                                                        objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(i403, jumpTapTimeout5, maximumFlingVelocity12, 1068791596, false, (String) objArr1215[0], new Class[]{String.class});
                                                    }
                                                    str = (String) ((Method) objComponent18).invoke(null, objArr1214);
                                                    if (str == null) {
                                                    }
                                                }
                                            }
                                            i3 = 0;
                                        } else {
                                            i3 = 0;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    Throwable cause3 = th3.getCause();
                                    if (cause3 != null) {
                                        throw cause3;
                                    }
                                    throw th3;
                                }
                            } catch (Exception unused) {
                            }
                            if (i3 != 0) {
                                Object[] objArr130 = {new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{(i3 & i50) | ((~i3) & i)}};
                                int i404 = (-984224338) + ((~(795862390 | i50)) * (-116)) + ((107996532 | i) * 116) + (((~((-722207859) | i)) | 34342000) * 116);
                                int i405 = ((i404 ^ 16) + ((i404 & 16) << 1)) - 795555817;
                                int i406 = i405 << 13;
                                int i407 = (i405 | i406) & (~(i405 & i406));
                                int i408 = i407 >>> 17;
                                int i409 = (i407 | i408) & (~(i407 & i408));
                                int i410 = i409 << 5;
                                return objArr130;
                            }
                            int maximumFlingVelocity13 = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                            int i411 = ((maximumFlingVelocity13 | 62597) << 1) - (maximumFlingVelocity13 ^ 62597);
                            Object[] objArr131 = new Object[1];
                            b("㋼왤\udbaa\uef63\ue0ef\uf47e觼鵉隈ꩋ뿓덊䓆", i411, objArr131);
                            Object[] objArr132 = {(String) objArr131[0]};
                            Object objComponent43 = setSystemGestureExclusionRectsL30479.component5((int) r9);
                            if (objComponent43 == null) {
                                int iNormalizeMetaState = 52 - KeyEvent.normalizeMetaState(0);
                                char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                                int i412 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6473;
                                byte b70 = (byte) (-$$a[6]);
                                byte b71 = (byte) (b70 - 3);
                                Object[] objArr133 = new Object[1];
                                a(b70, b71, b71, objArr133);
                                objComponent43 = setSystemGestureExclusionRectsL30479.vD14832N6715(iNormalizeMetaState, cAxisFromString, i412, 1068791596, false, (String) objArr133[0], new Class[]{String.class});
                            }
                            String str42 = (String) ((Method) objComponent43).invoke(null, objArr132);
                            if (str42 == null) {
                                i4 = 0;
                                break;
                            }
                            int i413 = -(-View.resolveSizeAndState(0, 0, 0));
                            int i414 = ((i413 | 14797) << 1) - (i413 ^ 14797);
                            Object[] objArr134 = new Object[1];
                            b("㋭\u0b3a䅵龇헕Ꮸ栥ꙻﲋ㫔烨", i414, objArr134);
                            String[] strArr5 = {(String) objArr134[0]};
                            int i415 = 0;
                            while (true) {
                                if (i415 > 0) {
                                    int i416 = $sG29839;
                                    int i417 = ((i416 | 69) << 1) - (i416 ^ 69);
                                    $vD14832N6715 = i417 % 128;
                                    int i418 = i417 % 2;
                                    int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                                    int i419 = minimumFlingVelocity2 * (-711);
                                    int i420 = (i419 & 30561319) + (i419 | 30561319);
                                    int i421 = ~((-42864) | minimumFlingVelocity2);
                                    int i422 = ~i;
                                    int i423 = ~(i422 | minimumFlingVelocity2);
                                    int i424 = i420 + (((i421 & i423) | (i421 ^ i423)) * (-712));
                                    int i425 = (-42864) | i422;
                                    int i426 = ((~((i425 & minimumFlingVelocity2) | (i425 ^ minimumFlingVelocity2))) | (~((42863 & minimumFlingVelocity2) | (minimumFlingVelocity2 ^ 42863) | i))) * (-712);
                                    int i427 = (i424 & i426) + (i424 | i426) + (((~((minimumFlingVelocity2 & i422) | (i422 ^ minimumFlingVelocity2))) | (-42864)) * 712);
                                    Object[] objArr135 = new Object[1];
                                    b("㊡閅簱쒷꽓瞊\ude78ꛨক퀈뢴ͤ", i427, objArr135);
                                    String str43 = (String) objArr135[0];
                                    int i428 = -(Process.myPid() >> 22);
                                    int i429 = (i428 * 980) - 121272;
                                    int i430 = -(-((~(((-125) & i50) | ((-125) ^ i50))) * 979));
                                    int i431 = (i429 & i430) + (i429 | i430);
                                    int i432 = ((i428 ^ i) | (i428 & i)) * (-979);
                                    int i433 = (i431 ^ i432) + ((i432 & i431) << 1);
                                    int i434 = ~(((-125) & i) | ((-125) ^ i));
                                    int i435 = ~((i428 & i422) | (i422 ^ i428));
                                    int i436 = -(-(((i435 & i434) | (i434 ^ i435)) * 979));
                                    int i437 = -View.getDefaultSize(0, 0);
                                    int i438 = (i437 & 16) + (i437 | 16);
                                    Object[] objArr136 = new Object[1];
                                    c((byte) (((i433 | i436) << 1) - (i436 ^ i433)), i438, "\u0004\u0005\t \t\u0002\u0000 \u0006\t\u0003\u0004\u0007\b!\u0004", objArr136);
                                    String str44 = (String) objArr136[0];
                                    byte b72 = (byte) (85 - (~(-(KeyEvent.getMaxKeyCode() >> 16))));
                                    int i439 = -TextUtils.getTrimmedLength("");
                                    int i440 = (i439 ^ 17) + ((i439 & 17) << 1);
                                    Object[] objArr137 = new Object[1];
                                    c(b72, i440, "\u0004\u0005\t \t\u0002\u0000 \u0006\t\u0003\u0004\u001e\b\n\u001f㘋", objArr137);
                                    String str45 = (String) objArr137[0];
                                    int i441 = -(-View.resolveSizeAndState(0, 0, 0));
                                    int i442 = -KeyEvent.normalizeMetaState(0);
                                    int i443 = (i442 ^ 6) + ((i442 & 6) << 1);
                                    Object[] objArr138 = new Object[1];
                                    c((byte) ((i441 ^ 6) + ((i441 & 6) << 1)), i443, "\u0001\u0015\u0007\b!\u0004", objArr138);
                                    String str46 = (String) objArr138[0];
                                    Object[] objArr139 = new Object[1];
                                    b("㊡ᰚ漹빈襦\ud868⮉竰䗔铸\ue7e6ㅌ", 12006 - TextUtils.lastIndexOf("", '0'), objArr139);
                                    String str47 = (String) objArr139[0];
                                    int i444 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                    int i445 = (i444 ^ 38803) + ((i444 & 38803) << 1);
                                    Object[] objArr140 = new Object[1];
                                    b("㊡ꕮ᷑\uf444沶윴뾑ឤ蹴曌\ud95e뇰⡄肜磼퍧䮑", i445, objArr140);
                                    String str48 = (String) objArr140[0];
                                    int i446 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                    int iVD14832N67120 = qU20128.vD14832N6715();
                                    int i447 = (i446 * (-743)) - 35591929;
                                    int i448 = ~((i446 ^ 47903) | (i446 & 47903));
                                    int i449 = ~(i446 | iVD14832N67120);
                                    int i450 = (i448 ^ i449) | (i448 & i449);
                                    int i451 = ~((iVD14832N67120 ^ 47903) | (iVD14832N67120 & 47903));
                                    int i452 = ((i450 ^ i451) | (i450 & i451)) * (-744);
                                    int i453 = (i447 & i452) + (i447 | i452);
                                    int i454 = ~iVD14832N67120;
                                    int i455 = ~i446;
                                    int i456 = -(-((i454 | (~((i455 ^ (-47904)) | (i455 & (-47904))))) * 744));
                                    int i457 = (i453 & i456) + (i456 | i453);
                                    int i458 = i446 | 47903;
                                    int i459 = ((i458 & iVD14832N67120) | (i458 ^ iVD14832N67120)) * 744;
                                    int i460 = (i457 ^ i459) + ((i459 & i457) << 1);
                                    Object[] objArr141 = new Object[1];
                                    b("㊡觢䓉Π\ude86镰偙⽸\uea14꛰緖㣴\uf79c뉼ॕ쐳茍忠᫆톦곍", i460, objArr141);
                                    String str49 = (String) objArr141[0];
                                    int i461 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                    int iVD14832N67121 = qU20128.vD14832N6715();
                                    int i462 = i461 * 465;
                                    int i463 = (i462 ^ (-15115098)) + ((i462 & (-15115098)) << 1);
                                    int i464 = ~iVD14832N67121;
                                    int i465 = (~((-32647) | i461)) | (~(((-32647) ^ i464) | ((-32647) & i464)));
                                    int i466 = ~(i464 | i461);
                                    int i467 = ((i466 & i465) | (i465 ^ i466)) * 464;
                                    int i468 = (i463 & i467) + (i467 | i463);
                                    int i469 = ~i461;
                                    int i470 = (i469 & iVD14832N67121) | (iVD14832N67121 ^ i469);
                                    int i471 = ((i470 & (-32647)) | (i470 ^ (-32647))) * (-464);
                                    int i472 = (i468 & i471) + (i471 | i468);
                                    int i473 = -(-(((~(i461 | iVD14832N67121)) | (~(((-32647) ^ i461) | ((-32647) & i461)))) * 464));
                                    int i474 = (i472 & i473) + (i473 | i472);
                                    Object[] objArr142 = new Object[1];
                                    b("㊡䵺췹䱨쳦佈쿉丐컅䥕짧䠻좸䬼쮂䩈", i474, objArr142);
                                    String str50 = (String) objArr142[0];
                                    char mirror2 = AndroidCharacter.getMirror('0');
                                    int i475 = -(-Color.blue(0));
                                    int i476 = ((i475 | 25) << 1) - (i475 ^ 25);
                                    Object[] objArr143 = new Object[1];
                                    c((byte) ((mirror2 & (-22)) + (mirror2 | (-22))), i476, "\u0001\u0015\u0015\u0014#\u000f\u0015\u0004\r\u0015\u000f\u0002\u001d\f\u0004\u001e㘙㘙\u0005\u0001\f \u001f\"㗏", objArr143);
                                    String str51 = (String) objArr143[0];
                                    Object[] objArr144 = new Object[1];
                                    b("㊡\uf69c먵翞⍾\ue70eꢥ氆ᇾ햅餭䋋ح", 50273 - (~MotionEvent.axisFromString("")), objArr144);
                                    String str52 = (String) objArr144[0];
                                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L);
                                    int i477 = packedPositionGroup * JfifUtil.MARKER_EOI;
                                    int i478 = (((i477 | (-13015885)) << 1) - (i477 ^ (-13015885))) + ((~((packedPositionGroup ^ i) | (packedPositionGroup & i))) * JfifUtil.MARKER_SOI);
                                    int i479 = ((-60540) & packedPositionGroup) | (packedPositionGroup ^ (-60540));
                                    int i480 = (i478 - (~(((i479 & i50) | (i479 ^ i50)) * (-216)))) - 1;
                                    int i481 = ~((packedPositionGroup & i50) | (i50 ^ packedPositionGroup));
                                    int i482 = i480 + (((i481 & 60539) | (i481 ^ 60539)) * JfifUtil.MARKER_SOI);
                                    Object[] objArr145 = new Object[1];
                                    b("㊡\ude80\uea0b\uf78d荍겋렅䖽兹", i482, objArr145);
                                    String str53 = (String) objArr145[0];
                                    int i483 = -TextUtils.indexOf((CharSequence) "", '0');
                                    int i484 = (i483 * 141) - 8649;
                                    int i485 = -(-(((i ^ 31) | (i & 31)) * 140));
                                    int i486 = (i484 ^ i485) + ((i484 & i485) << 1);
                                    int i487 = ~i483;
                                    int i488 = ~((i487 ^ 31) | (i487 & 31));
                                    int i489 = ~((i422 & 31) | (i422 ^ 31));
                                    int i490 = -(-(((i489 & i488) | (i488 ^ i489)) * (-280)));
                                    int i491 = ((i486 | i490) << 1) - (i490 ^ i486);
                                    int i492 = ~((-32) | i483);
                                    int i493 = ~((i483 & i50) | (i50 ^ i483));
                                    int i494 = (i493 & i492) | (i492 ^ i493);
                                    int i495 = (i487 & 31) | (i487 ^ 31);
                                    int i496 = ~((i495 & i) | (i495 ^ i));
                                    byte b73 = (byte) (i491 + (((i494 & i496) | (i494 ^ i496)) * 140));
                                    int i497 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                    int i498 = (i497 ^ 8) + ((i497 & 8) << 1);
                                    Object[] objArr146 = new Object[1];
                                    c(b73, i498, "\u0001\u0015\u0015\t\u0007\b!\u0004", objArr146);
                                    int i499 = 0;
                                    String[] strArr6 = {str43, str44, str45, str46, str47, str48, str49, str50, str51, str52, str53, (String) objArr146[0]};
                                    int i500 = 0;
                                    while (true) {
                                        if (i500 < 12) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(strArr6[i500]);
                                            byte b74 = (byte) (33 - (~KeyEvent.normalizeMetaState(i499)));
                                            int iIndexOf11 = TextUtils.indexOf((CharSequence) "", '0', i499, i499);
                                            int i501 = (iIndexOf11 ^ 3) + ((iIndexOf11 & 3) << 1);
                                            Object[] objArr147 = new Object[1];
                                            c(b74, i501, "\u0015\r", objArr147);
                                            sb.append((String) objArr147[i499]);
                                            Object[] objArr148 = {sb.toString()};
                                            Object objComponent44 = setSystemGestureExclusionRectsL30479.component5(1364103917);
                                            if (objComponent44 == null) {
                                                int iRed7 = 52 - Color.red(i499);
                                                char cLastIndexOf4 = (char) (TextUtils.lastIndexOf("", '0', i499, i499) + 59726);
                                                int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6317;
                                                byte b75 = (byte) ($$b & 7);
                                                byte b76 = (byte) (b75 - 1);
                                                Object[] objArr149 = new Object[1];
                                                a(b75, b76, b76, objArr149);
                                                objComponent44 = setSystemGestureExclusionRectsL30479.vD14832N6715(iRed7, cLastIndexOf4, minimumFlingVelocity3, 66836110, false, (String) objArr149[0], new Class[]{String.class});
                                            }
                                            long jLongValue30 = ((Long) ((Method) objComponent44).invoke(null, objArr148)).longValue();
                                            long j56 = (-876121854720L) + ((-1917) * jLongValue30);
                                            long j57 = jLongValue30 ^ (-1);
                                            long j58 = j56 + ((((j57 | j9) ^ (-1)) | (((-912626932) | j7) ^ (-1))) * 959) + ((-959) * j57) + (959 * (((j57 | j7) ^ (-1)) | ((j9 | (-912626932)) ^ (-1)))) + 1068577298;
                                            int i502 = ((int) (j58 >> 32)) & (1785768938 + (((~((-66049) | i50)) | (~(895874021 | i))) * (-302)) + ((~((-66049) | i)) * (-604)) + (((~(895807973 | i)) | 354455584) * 302));
                                            int i503 = (int) j58;
                                            int iFreeMemory4 = (int) Runtime.getRuntime().freeMemory();
                                            int i504 = (-1350296355) + ((~(1359477292 | iFreeMemory4)) * JfifUtil.MARKER_SOI);
                                            int i505 = ~iFreeMemory4;
                                            int i506 = i503 & (i504 + (((-138936322) | i505) * (-216)) + (((~(i505 | 1359477292)) | 1498263593) * JfifUtil.MARKER_SOI));
                                            if (((i502 & i506) | (i502 ^ i506)) != 0) {
                                                int i507 = $vD14832N6715 + 39;
                                                $sG29839 = i507 % 128;
                                                int i508 = i507 % 2;
                                                i4 = (i500 & MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE) + (i500 | MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE);
                                                break;
                                            }
                                            i500++;
                                            strArr6 = strArr6;
                                            i499 = 0;
                                        }
                                    }
                                } else if (!str42.contains(strArr5[i415])) {
                                    i415++;
                                }
                                i4 = 0;
                                break;
                            }
                            if (i4 != 0) {
                                int i509 = $vD14832N6715 + 115;
                                $sG29839 = i509 % 128;
                                int i510 = i509 % 2;
                                Object[] objArr150 = {new int[1], null, new int[]{i}, new int[]{i4 ^ i}};
                                int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                int i511 = ~((-211214417) | (~iUptimeMillis2));
                                int i512 = ((((543230342 | i511) | (~(211214416 | iUptimeMillis2))) * (-338)) - 241533742) + (((~(iUptimeMillis2 | 754444758)) | i511) * 338);
                                int i513 = i512 * (-271);
                                int i514 = (4368 ^ i513) + ((i513 & 4368) << 1);
                                int i515 = ~i512;
                                int i516 = (i515 & (-17)) | ((-17) ^ i515);
                                int i517 = ~((i516 & i50) | (i516 ^ i50));
                                int i518 = i512 | 16;
                                int i519 = ~((i518 & i) | (i518 ^ i));
                                int i520 = ((i517 & i519) | (i517 ^ i519)) * (-272);
                                int i521 = (((i514 | i520) << 1) - (i520 ^ i514)) + (((~(((-17) ^ i512) | ((-17) & i512))) | (~i185)) * (-272));
                                int i522 = ((~(i | 16)) | i512) * 272;
                                int i523 = (i521 & i522) + (i522 | i521);
                                int i524 = (i523 ^ (-795555817)) + ((i523 & (-795555817)) << 1);
                                int i525 = i524 << 13;
                                int i526 = (i524 | i525) & (~(i524 & i525));
                                int i527 = i526 >>> 17;
                                int i528 = (i526 | i527) & (~(i526 & i527));
                                int i529 = i528 << 5;
                                ((int[]) objArr150[0])[0] = ((~i528) & i529) | ((~i529) & i528);
                                return objArr150;
                            }
                            long[] jArr = {472001035};
                            int iLastIndexOf7 = TextUtils.lastIndexOf("", '0', 0, 0);
                            Object[] objArr151 = new Object[1];
                            c((byte) ((iLastIndexOf7 ^ 30) + ((iLastIndexOf7 & 30) << 1)), 17 - KeyEvent.getDeadChar(0, 0), "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0004\u0015!\f#\"㘆", objArr151);
                            Object[] objArr152 = {(String) objArr151[0], 5, Long.valueOf(LockFreeTaskQueueCore.HEAD_MASK), jArr};
                            Object objComponent45 = setSystemGestureExclusionRectsL30479.component5(-1564039546);
                            if (objComponent45 == null) {
                                int i530 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 50;
                                char cLastIndexOf5 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                                int iLastIndexOf8 = 3423 - TextUtils.lastIndexOf("", '0');
                                byte b77 = (byte) ($$b & 7);
                                byte b78 = b77;
                                Object[] objArr153 = new Object[1];
                                a(b77, b78, b78, objArr153);
                                objComponent45 = setSystemGestureExclusionRectsL30479.vD14832N6715(i530, cLastIndexOf5, iLastIndexOf8, -260840731, false, (String) objArr153[0], new Class[]{String.class, Integer.TYPE, Long.TYPE, long[].class});
                            }
                            long jLongValue31 = ((Long) ((Method) objComponent45).invoke(null, objArr152)).longValue();
                            long jNextInt3 = new Random().nextInt();
                            long j59 = 10123818520L + ((-858) * jLongValue31) + ((-859) * (11771882 | jNextInt3));
                            long j60 = jNextInt3 ^ (-1);
                            long j61 = jLongValue31 ^ (-1);
                            long j62 = j59 + ((((j60 | 11771882) ^ (-1)) | ((((-11771883) | j61) | jNextInt3) ^ (-1))) * 859) + (859 * (((j61 | 11771882) ^ (-1)) | ((j61 | j60) ^ (-1)))) + 512629680;
                            int i531 = ((int) (j62 >> 32)) & (((((~((-1665927737) | i)) | (-1861074614)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) - 897956590) + (((~((-1665927737) | i50)) | (-1861074614)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED));
                            int i532 = ((int) j62) & (906624401 + ((~((-1711480875) | i50)) * 52) + (((~((-1856189819) | i50)) | (~((-418963409) | i50)) | 144708944) * (-52)) + (((~(1856189818 | i50)) | (-2130444283)) * 52));
                            int i533 = ((i531 & i532) | (i531 ^ i532)) != 0 ? 240 : 0;
                            if (i533 != 0) {
                                Object[] objArr154 = {new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{(i533 & i50) | ((~i533) & i)}};
                                int i534 = (~((-308418403) | i)) | 301994496;
                                int i535 = 1365687366 + (i534 * 992) + ((i534 | (~(528209894 | i50))) * (-496)) + ((521785988 | i) * 496);
                                int i536 = (-795555818) - (~(((i535 | 16) << 1) - (i535 ^ 16)));
                                int i537 = i536 << 13;
                                int i538 = (i537 | i536) & (~(i536 & i537));
                                int i539 = i538 >>> 17;
                                int i540 = (i538 | i539) & (~(i538 & i539));
                                int i541 = i540 << 5;
                                return objArr154;
                            }
                            long[] jArr2 = {472001035};
                            Object[] objArr155 = new Object[1];
                            b("㊡쉔펥\ue306\uf005膥鄋\ua63e략䜚呸斤甌੮ᯈ⭆㡮짘\ud900\uee6c\uffd9輪", 61607 - (~(-TextUtils.lastIndexOf("", '0', 0, 0))), objArr155);
                            try {
                                bufferedInputStream2 = new BufferedInputStream(new FileInputStream((String) objArr155[0]));
                                long j63 = 0;
                                while (true) {
                                    try {
                                        int i542 = bufferedInputStream2.read();
                                        if (i542 != -1) {
                                            j63 = ((j63 << 5) ^ ((long) i542)) & LockFreeTaskQueueCore.HEAD_MASK;
                                            int i543 = 0;
                                            while (true) {
                                                if (i543 < 1) {
                                                    if (j63 == jArr2[i543]) {
                                                        i5 = i543 + 1;
                                                        try {
                                                            bufferedInputStream2.close();
                                                        } catch (Exception unused2) {
                                                        }
                                                    } else {
                                                        i543 = (i543 & (-6)) + (i543 | (-6)) + 7;
                                                    }
                                                }
                                                try {
                                                    bufferedInputStream2.close();
                                                } catch (Exception unused3) {
                                                }
                                                i5 = 0;
                                            }
                                        } else {
                                            bufferedInputStream2.close();
                                            i5 = 0;
                                        }
                                    } catch (IOException unused4) {
                                        if (bufferedInputStream2 != null) {
                                        }
                                        i5 = 0;
                                        if (i5 != 0) {
                                            Object[] objArr156 = {new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i}};
                                            int i544 = (~(i & 242)) & (i | 242);
                                            int i545 = ((((~((-21717984) | i50)) | (~(i | 808486407))) * 959) - 573120131) + (((~(i | (-21717984))) | (~(i50 | 808486407))) * 959) + 16;
                                            int i546 = (i545 ^ (-795555817)) + ((i545 & (-795555817)) << 1);
                                            int i547 = i546 << 13;
                                            int i548 = ((~i546) & i547) | ((~i547) & i546);
                                            int i549 = i548 ^ (i548 >>> 17);
                                            int i550 = i549 << 5;
                                            return objArr156;
                                        }
                                        objComponent5 = setSystemGestureExclusionRectsL30479.component5(1719424323);
                                        if (objComponent5 == null) {
                                            int iArgb = 52 - Color.argb(0, 0, 0, 0);
                                            char pressedStateDuration2 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 34154);
                                            int mirror3 = AndroidCharacter.getMirror('0') + 6165;
                                            byte b79 = (byte) ($$b & 7);
                                            byte b80 = b79;
                                            Object[] objArr157 = new Object[1];
                                            a(b79, b80, b80, objArr157);
                                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iArgb, pressedStateDuration2, mirror3, 885592352, false, (String) objArr157[0], new Class[0]);
                                        }
                                        long jLongValue32 = ((Long) ((Method) objComponent5).invoke(null, null)).longValue();
                                        long j64 = (-674563057530L) + ((-463) * jLongValue32);
                                        long j65 = jLongValue32 ^ (-1);
                                        long j66 = (int) Runtime.getRuntime().totalMemory();
                                        long j67 = j66 ^ (-1);
                                        long j68 = (j65 | (-1450673242)) ^ (-1);
                                        long j69 = j64 + ((((j65 | j67) ^ (-1)) | j68 | ((j67 | (-1450673242)) ^ (-1))) * 464) + ((-464) * (j66 | 1450673241 | j65)) + (464 * (j68 | (((-1450673242) | j66) ^ (-1)))) + 1790423822;
                                        i6 = ((int) (j69 >> 32)) & ((-802173004) + (((-1491073) | i50) * (-369)) + (((~(574537924 | i50)) | 2011764335) * (-369)) + (((~((-574537925) | i)) | 573046852 | (~(2013255407 | i50))) * 369));
                                        i7 = ((int) j69) & ((-2144799044) + ((1973075296 | i50) * (-757)) + ((~((-2113686) | i)) * 1514) + (((~((-884665590) | i50)) | 882551904 | (~(1975188981 | i))) * 757));
                                        if (((i6 & i7) | (i6 ^ i7)) != 0) {
                                            objComponent6 = setSystemGestureExclusionRectsL30479.component5(-263869551);
                                            if (objComponent6 == null) {
                                                int iLastIndexOf9 = 51 - TextUtils.lastIndexOf("", '0', 0, 0);
                                                char cAlpha2 = (char) Color.alpha(0);
                                                int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 4902;
                                                byte b81 = (byte) ($$b & 7);
                                                byte b82 = b81;
                                                Object[] objArr158 = new Object[1];
                                                a(b81, b82, b82, objArr158);
                                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf9, cAlpha2, longPressTimeout3, -1561268238, false, (String) objArr158[0], new Class[0]);
                                            }
                                            long jLongValue33 = ((Long) ((Method) objComponent6).invoke(null, null)).longValue();
                                            long j70 = 286149488848L + ((-1343) * jLongValue33) + ((jLongValue33 | ((425184976 | j7) ^ (-1))) * 672) + ((-672) * ((((-425184977) | j9) ^ (-1)) | ((jLongValue33 | j7) ^ (-1))));
                                            long j71 = jLongValue33 ^ (-1);
                                            long j72 = j70 + (672 * (((j71 | j9) ^ (-1)) | ((j71 | 425184976) ^ (-1)))) + 844405833;
                                            i8 = ((int) (j72 >> 32)) & (1215928528 + (((~(40899514 | i50)) | (~((-1478125926) | i))) * 210) + (((~((-1048865) | i50)) | (~(1517976575 | i))) * 210));
                                            i9 = (int) j72;
                                            i10 = (~((-461084805) | i)) | (~((-1898311215) | i50));
                                            i11 = ~(461084804 | i50);
                                            if ((i8 | (i9 & (535374625 + ((i10 | i11) * (-516)) + (((~((-173674625) | i)) | (~(2071985838 | i50))) * 516) + (((-2071985839) | i11) * 516)))) != 0) {
                                                i12 = (~(i & 281)) & (i | 281);
                                            } else {
                                                i12 = i;
                                            }
                                            if (i12 != i) {
                                                Object[] objArr159 = {new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i12}};
                                                int i551 = 1297773118 + (((~((-680794966) | i)) | (-687333334)) * (-502)) + ((~((-537923909) | i50)) * (-502)) + (((-680794966) | (~((-149409426) | i))) * 502);
                                                int i552 = -(-((i551 ^ 16) + ((i551 & 16) << 1)));
                                                int i553 = (i552 & (-795555817)) + (i552 | (-795555817));
                                                int i554 = i553 << 13;
                                                int i555 = (i554 | i553) & (~(i553 & i554));
                                                int i556 = i555 >>> 17;
                                                int i557 = (i555 | i556) & (~(i555 & i556));
                                                int i558 = i557 << 5;
                                                objArr = objArr159;
                                                i19 = 0;
                                            } else {
                                                objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1690268346);
                                                if (objComponent7 == null) {
                                                    int scrollBarSize3 = 52 - (ViewConfiguration.getScrollBarSize() >> 8);
                                                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                                                    int touchSlop5 = 5058 - (ViewConfiguration.getTouchSlop() >> 8);
                                                    Object[] objArr160 = new Object[1];
                                                    a(0, (byte) 0, (byte) 0, objArr160);
                                                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollBarSize3, modifierMetaStateMask, touchSlop5, -906639067, false, (String) objArr160[0], new Class[0]);
                                                }
                                                long jLongValue34 = ((Long) ((Method) objComponent7).invoke(null, null)).longValue();
                                                long j73 = ((-1433526153) | jLongValue34) ^ (-1);
                                                long j74 = jLongValue34 ^ (-1);
                                                long j75 = (j74 | 1433526152) ^ (-1);
                                                long jMyPid = Process.myPid();
                                                long j76 = 571976934648L + (399 * jLongValue34) + ((j73 | j75 | ((j74 | jMyPid) ^ (-1))) * 398) + ((-1194) * (1433526152 | jLongValue34)) + (398 * (((j74 | (jMyPid ^ (-1))) ^ (-1)) | j73 | j75)) + 240368949;
                                                int iMyUid3 = Process.myUid();
                                                i13 = ((int) (j76 >> 32)) & (((((~((-4262145) | iMyUid3)) | 295050) * TypedValues.Position.TYPE_TRANSITION_EASING) - 845927784) + ((~((~iMyUid3) | (-4262145))) * TypedValues.Position.TYPE_TRANSITION_EASING));
                                                int i559 = (~(1305414001 | i50)) | 34620424;
                                                int i560 = ~((-1208222018) | i);
                                                i14 = ((int) j76) & ((-696539500) + ((i559 | i560) * (-713)) + (i560 * 1426) + ((~(131812408 | i50)) * 713));
                                                if (((i13 & i14) | (i13 ^ i14)) != 0) {
                                                    int i561 = $vD14832N6715 + 93;
                                                    $sG29839 = i561 % 128;
                                                    int i562 = i561 % 2;
                                                    objArr = new Object[]{new int[]{i}, null, new int[]{i}, new int[]{i}};
                                                    int i563 = (~(i & 268)) & (i | 268);
                                                    int i564 = (-302877570) + (((~((-663685171) | i)) | (-166519221)) * (-948)) + ((~((-25952305) | i50)) * (-948)) + 1019630836;
                                                    int i565 = ((i564 | (-795555817)) << 1) - (i564 ^ (-795555817));
                                                    int i566 = i565 ^ (i565 << 13);
                                                    int i567 = i566 >>> 17;
                                                    int i568 = ((~i566) & i567) | ((~i567) & i566);
                                                    int i569 = i568 ^ (i568 << 5);
                                                    i20 = 0;
                                                } else {
                                                    objComponent8 = setSystemGestureExclusionRectsL30479.component5(-597190889);
                                                    if (objComponent8 == null) {
                                                        int iAxisFromString = 51 - MotionEvent.axisFromString("");
                                                        char c16 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                        int trimmedLength = 5058 - TextUtils.getTrimmedLength("");
                                                        byte b83 = (byte) ($$b & 7);
                                                        byte b84 = b83;
                                                        Object[] objArr161 = new Object[1];
                                                        a(b83, b84, b84, objArr161);
                                                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iAxisFromString, c16, trimmedLength, -1898785932, false, (String) objArr161[0], new Class[0]);
                                                    }
                                                    long jLongValue35 = ((Long) ((Method) objComponent8).invoke(null, null)).longValue();
                                                    long j77 = (-355891266152L) + (530 * jLongValue35) + ((((j9 | (-671492957)) ^ (-1)) | (((-671492957) | jLongValue35) ^ (-1))) * 529) + (529 * ((jLongValue35 ^ (-1)) | (((-671492957) | j7) ^ (-1)))) + 1438166783;
                                                    i15 = ((int) (j77 >> 32)) & (1587634074 + (((~(2035224068 | i)) | 44085337 | (~((-597997658) | i))) * (-744)) + ((1481311748 | i50) * 744) + (((-44085338) | i) * 744));
                                                    int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                                    int i570 = ~((-638384566) | iUptimeMillis3);
                                                    int i571 = ~iUptimeMillis3;
                                                    int i572 = i570 | (~((-2075610976) | i571));
                                                    int i573 = ~(638384565 | i571);
                                                    i16 = ((int) j77) & ((-1174865751) + ((i572 | i573) * (-516)) + (((~(iUptimeMillis3 | (-67678369))) | (~(2143289343 | i571))) * 516) + (((-2143289344) | i573) * 516));
                                                    if (((i15 & i16) | (i15 ^ i16)) != 0) {
                                                        int i574 = $vD14832N6715;
                                                        int i575 = (i574 & 93) + (i574 | 93);
                                                        $sG29839 = i575 % 128;
                                                        int i576 = i575 % 2;
                                                        objArr = new Object[]{new int[1], null, new int[]{i}, new int[]{i}};
                                                        int i577 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED);
                                                        int iFreeMemory5 = (int) Runtime.getRuntime().freeMemory();
                                                        int i578 = ~iFreeMemory5;
                                                        int i579 = (-795555818) - (~(-(-((((-1020405640) + ((((~(i578 | (-106285294))) | 280617) | (~((-830485009) | iFreeMemory5))) * 717)) + (((~(iFreeMemory5 | (-106285294))) | ((~(i578 | (-830485009))) | 280617)) * 717)) + 16))));
                                                        int i580 = i579 << 13;
                                                        int i581 = (i580 | i579) & (~(i579 & i580));
                                                        int i582 = i581 ^ (i581 >>> 17);
                                                        int i583 = i582 << 5;
                                                        i20 = 0;
                                                        ((int[]) objArr[0])[0] = (i582 | i583) & (~(i582 & i583));
                                                    } else {
                                                        objComponent9 = setSystemGestureExclusionRectsL30479.component5(-977249762);
                                                        if (objComponent9 == null) {
                                                            int iBlue9 = 52 - Color.blue(0);
                                                            char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8601);
                                                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 4244;
                                                            byte b85 = (byte) ($$b & 7);
                                                            byte b86 = b85;
                                                            Object[] objArr162 = new Object[1];
                                                            a(b85, b86, b86, objArr162);
                                                            objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue9, doubleTapTimeout, iMakeMeasureSpec2, -1753932163, false, (String) objArr162[0], new Class[0]);
                                                        }
                                                        long jLongValue36 = ((Long) ((Method) objComponent9).invoke(null, null)).longValue();
                                                        long jNextInt4 = new Random().nextInt();
                                                        long j78 = jNextInt4 ^ (-1);
                                                        long j79 = (((((-77242034412L) + ((-520) * jLongValue36)) + ((-1042) * ((-147973246) | ((j78 | jLongValue36) ^ (-1))))) + ((jLongValue36 | jNextInt4) * 521)) + (521 * ((((j78 | (-147973246)) | jLongValue36) ^ (-1)) | (((147973245 | (jLongValue36 ^ (-1))) ^ (-1)) | ((147973245 | jNextInt4) ^ (-1)))))) - 1966967319;
                                                        int iMaxMemory4 = (int) Runtime.getRuntime().maxMemory();
                                                        int i584 = ~iMaxMemory4;
                                                        i17 = ((int) (j79 >> 32)) & (1473358611 + (((~((-848415205) | iMaxMemory4)) | (~(2009325680 | i584))) * 333) + (((~(iMaxMemory4 | 2009325680)) | (~(i584 | (-848415205)))) * 333));
                                                        int iNextInt4 = new Random().nextInt();
                                                        i18 = ((int) j79) & (131025114 + ((~((~iNextInt4) | (-5510401))) * 433) + (((~(637449546 | iNextInt4)) | 799776863) * (-433)) + (((~(iNextInt4 | 799776863)) | 631939146) * 433));
                                                        if (((i17 & i18) | (i17 ^ i18)) != 0) {
                                                            objArr = new Object[]{new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{(i & (-281)) | (i50 & 280)}};
                                                            int i585 = (-795555818) - (~((((((~((-673300485) | i50)) | (~(753915894 | i))) * 988) + 810229114) + ((((~((-749588981) | i)) | 76288496) | (~(753915894 | i50))) * 988)) + 16));
                                                            int i586 = (i585 << 13) ^ i585;
                                                            int i587 = i586 >>> 17;
                                                            int i588 = ((~i586) & i587) | ((~i587) & i586);
                                                            int i589 = i588 << 5;
                                                            i19 = 0;
                                                        } else {
                                                            objArr = new Object[]{new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i}};
                                                            int i590 = ~(361107621 | i);
                                                            int i591 = (((67240100 | i590) * (-196)) - 639097166) + ((i590 | 293867521) * 196);
                                                            int i592 = i591 * (-496);
                                                            int i593 = ~i591;
                                                            int i594 = -(-((~(((-1) ^ i593) | i593)) * 497));
                                                            int i595 = (i592 & i594) + (i592 | i594);
                                                            int i596 = ((-1) ^ i593) | i593;
                                                            int i597 = ~((i596 & i) | (i596 ^ i));
                                                            int i598 = ~i591;
                                                            int i599 = ~((i598 & i50) | (i598 ^ i50));
                                                            int i600 = i595 + (((i597 & i599) | (i597 ^ i599)) * 497);
                                                            int i601 = ((~(((-1) ^ i591) | i591)) | (~((i593 ^ i) | (i593 & i)))) * 497;
                                                            int i602 = (((i600 | i601) << 1) - (i601 ^ i600)) - 795555817;
                                                            int i603 = (i602 << 13) ^ i602;
                                                            int i604 = i603 >>> 17;
                                                            int i605 = ((~i603) & i604) | ((~i604) & i603);
                                                            i19 = 0;
                                                        }
                                                    }
                                                }
                                            }
                                            if (((int[]) objArr[2])[i19] != ((int[]) objArr[r14])[i19]) {
                                                return objArr;
                                            }
                                            Object[] objArr163 = {2};
                                            objComponent10 = setSystemGestureExclusionRectsL30479.component5(-902658636);
                                            if (objComponent10 == null) {
                                                int i606 = 50 - (ExpandableListView.getPackedPositionForGroup(i19) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i19) == 0L ? 0 : -1));
                                                char c17 = (char) (34703 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                                int touchSlop6 = (ViewConfiguration.getTouchSlop() >> 8) + 5370;
                                                byte b87 = (byte) ($$b & 7);
                                                byte b88 = b87;
                                                Object[] objArr164 = new Object[1];
                                                a(b87, b88, b88, objArr164);
                                                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i606, c17, touchSlop6, -1735933481, false, (String) objArr164[0], new Class[]{Integer.TYPE});
                                            }
                                            long jLongValue37 = ((Long) ((Method) objComponent10).invoke(null, objArr163)).longValue();
                                            long j80 = jLongValue37 ^ (-1);
                                            long jElapsedRealtime2 = (jLongValue37 | ((long) ((int) SystemClock.elapsedRealtime()))) ^ (-1);
                                            long j81 = (-215634760050L) + ((-195) * jLongValue37) + ((-196) * (((j80 | 551495550) ^ (-1)) | jElapsedRealtime2)) + (392 * (551495550 | jLongValue37)) + (196 * (jElapsedRealtime2 | (((-551495551) | j80) ^ (-1)))) + 1044088161;
                                            int i607 = (~((-1054699079) | i50)) | 672204802 | (~(382527332 | i50));
                                            i21 = ((int) (j81 >> 32)) & ((-1413401978) + (((~((-33057) | i)) | i607) * 590) + (i607 * (-1180)) + (((~((-382527333) | i50)) | (~(1054699078 | i50))) * 590));
                                            int iMyTid3 = Process.myTid();
                                            int i608 = ~((-1294086235) | iMyTid3);
                                            int i609 = ~iMyTid3;
                                            i22 = ((int) j81) & ((-1184507382) + ((i608 | (~((-1051041) | i609))) * 497) + (((~(iMyTid3 | (-1051041))) | (~((-1562603612) | i609)) | 268517377) * 497));
                                            if (((i21 & i22) | (i21 ^ i22)) == 2) {
                                                Object[] objArr165 = {new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i}};
                                                int i610 = i ^ RotationOptions.ROTATE_270;
                                                int i611 = (((627456806 + ((409294611 | i50) * (-757))) + ((~((-17989825) | i)) * 1514)) + (((~(i | 427284435)) | ((~((-420909780) | i50)) | 402919955)) * 757)) - 795555801;
                                                int i612 = i611 << 13;
                                                int i613 = (i612 | i611) & (~(i611 & i612));
                                                int i614 = i613 ^ (i613 >>> 17);
                                                int i615 = i614 << 5;
                                                return objArr165;
                                            }
                                            objComponent11 = setSystemGestureExclusionRectsL30479.component5(1483925104);
                                            if (objComponent11 == null) {
                                                int i616 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50;
                                                char maxKeyCode4 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 43215);
                                                int packedPositionType10 = ExpandableListView.getPackedPositionType(0L) + 6938;
                                                byte b89 = (byte) ($$b & 7);
                                                byte b90 = b89;
                                                Object[] objArr166 = new Object[1];
                                                a(b89, b90, b90, objArr166);
                                                objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(i616, maxKeyCode4, packedPositionType10, 180855315, false, (String) objArr166[0], new Class[0]);
                                            }
                                            long jLongValue38 = ((Long) ((Method) objComponent11).invoke(null, null)).longValue();
                                            long j82 = (-27141803565L) + ((-667) * jLongValue38);
                                            long j83 = jLongValue38 ^ (-1);
                                            long jNextInt5 = new Random().nextInt(1072028167);
                                            long j84 = 20330939 | jNextInt5;
                                            long j85 = (((j82 + ((-668) * (j83 | (j84 ^ (-1))))) + (1336 * (20330939 | ((jNextInt5 | j83) ^ (-1))))) + (668 * (j84 | j83))) - 1570748318;
                                            int iFreeMemory6 = (int) Runtime.getRuntime().freeMemory();
                                            int i617 = ~iFreeMemory6;
                                            i23 = ((int) (j85 >> 32)) & ((-1051372822) + (((~(1843948065 | i617)) | (-2113830520)) * 184) + ((iFreeMemory6 | 136839200) * (-184)) + ((~(406721654 | i617)) * 184));
                                            int i618 = (int) j85;
                                            int i619 = ~(1536711891 | i50);
                                            i24 = i618 & (((((25691137 | i619) | (~((-1536711892) | i))) * (-338)) - 1343556697) + ((i619 | (~((-1511020755) | i))) * 338));
                                            if (((i23 & i24) | (i23 ^ i24)) != 0) {
                                                Object[] objArr167 = {new int[1], null, new int[]{i}, new int[]{i}};
                                                int i620 = (~(i & 272)) & (i | 272);
                                                int iMyUid4 = Process.myUid();
                                                int i621 = ~iMyUid4;
                                                int i622 = 918747726 + (((~(494657502 | i621)) | 335546888) * 220) + (((~(i621 | 473468696)) | 356735694) * (-440)) + ((iMyUid4 | 494657502) * 220);
                                                int i623 = (i622 & 16) + (i622 | 16);
                                                int i624 = (i623 & (-795555817)) + (i623 | (-795555817));
                                                int i625 = i624 << 13;
                                                int i626 = (i625 & (~i624)) | ((~i625) & i624);
                                                int i627 = i626 ^ (i626 >>> 17);
                                                int i628 = i627 << 5;
                                                ((int[]) objArr167[0])[0] = (i627 | i628) & (~(i627 & i628));
                                                return objArr167;
                                            }
                                            long[] jArr3 = {624887784092251L};
                                            int i629 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                            int i630 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                            int i631 = (i630 & 17) + (i630 | 17);
                                            Object[] objArr168 = new Object[1];
                                            c((byte) ((i629 ^ 29) + ((i629 & 29) << 1)), i631, "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0004\u0015!\f#\"㘆", objArr168);
                                            Object[] objArr169 = {(String) objArr168[0], Integer.valueOf((int) r14), 2251799813685247L, jArr3};
                                            objComponent12 = setSystemGestureExclusionRectsL30479.component5(-1564039546);
                                            if (objComponent12 == null) {
                                                int iIndexOf12 = 51 - TextUtils.indexOf("", "");
                                                char scrollBarSize4 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 3424;
                                                byte b91 = (byte) ($$b & 7);
                                                byte b92 = b91;
                                                Object[] objArr170 = new Object[1];
                                                a(b91, b92, b92, objArr170);
                                                objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf12, scrollBarSize4, offsetBefore2, -260840731, false, (String) objArr170[0], new Class[]{String.class, Integer.TYPE, Long.TYPE, long[].class});
                                            }
                                            long jLongValue39 = ((Long) ((Method) objComponent12).invoke(null, objArr169)).longValue();
                                            long j86 = jLongValue39 ^ (-1);
                                            long jMyPid2 = Process.myPid();
                                            long j87 = (-262979659610L) + (367 * jLongValue39) + (((-716565830) | jLongValue39) * (-366)) + ((-366) * ((-716565830) | ((j86 | jMyPid2) ^ (-1)))) + (366 * (((716565829 | jLongValue39) ^ (-1)) | (((j86 | (-716565830)) | jMyPid2) ^ (-1)))) + 1240967392;
                                            int i632 = (-818885110) + (((~(985833301 | i)) | (-2144575488) | (~(1871907583 | i))) * (-880));
                                            int i633 = (~(985833301 | i50)) | (-1871907584);
                                            int i634 = ~((-985833302) | i);
                                            i25 = ((int) (j87 >> 32)) & (i632 + ((i633 | i634) * (-880)) + (i634 * 880));
                                            int i635 = (int) Runtime.getRuntime().totalMemory();
                                            int i636 = (~(438242792 | i635)) | (-1000296426);
                                            i26 = ((int) j87) & ((-1537497691) + (i636 * 992) + ((i636 | (~((~i635) | (-436929985)))) * (-496)) + ((i635 | (-998983618)) * 496));
                                            if (((i25 & i26) | (i25 ^ i26)) != 0) {
                                                int i637 = $vD14832N6715;
                                                int i638 = i637 + 87;
                                                $sG29839 = i638 % 128;
                                                int i639 = i638 % 2;
                                                int i640 = (i637 ^ 59) + ((i637 & 59) << 1);
                                                $sG29839 = i640 % 128;
                                                int i641 = i640 % 2;
                                                Object[] objArr171 = {new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i}};
                                                int i642 = (~(i & 275)) & (i | 275);
                                                int i643 = 407164134 + (((~((-301994500) | i50)) | (~(439474083 | i))) * 520);
                                                int i644 = ~((-439474084) | i50);
                                                int i645 = ~(i | 390730307);
                                                int i646 = i643 + ((i644 | i645) * (-1040)) + ((i645 | (~((-390730308) | i50)) | 137479584) * 520);
                                                int i647 = -(-(((i646 | 16) << 1) - (i646 ^ 16)));
                                                int i648 = (i647 ^ (-795555817)) + ((i647 & (-795555817)) << 1);
                                                int i649 = i648 << 13;
                                                int i650 = (i649 | i648) & (~(i648 & i649));
                                                int i651 = i650 >>> 17;
                                                int i652 = (i650 | i651) & (~(i650 & i651));
                                                int i653 = i652 << 5;
                                                return objArr171;
                                            }
                                            int i654 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                            int i655 = (i654 ^ 1601) + ((i654 & 1601) << 1);
                                            Object[] objArr172 = new Object[1];
                                            b("㊡㒫㹩※⮥ⶱ\u1771\u192eï\u0ab4౯", i655, objArr172);
                                            Object[] objArr173 = {(String) objArr172[0]};
                                            objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                                            if (objComponent13 == null) {
                                                int maxKeyCode5 = 52 - (KeyEvent.getMaxKeyCode() >> 16);
                                                char offsetBefore3 = (char) (59725 - TextUtils.getOffsetBefore("", 0));
                                                int i656 = 6317 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                Object[] objArr174 = new Object[1];
                                                a(2, (byte) 0, (byte) 0, objArr174);
                                                objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode5, offsetBefore3, i656, 369154319, false, (String) objArr174[0], new Class[]{String.class});
                                            }
                                            long jLongValue40 = ((Long) ((Method) objComponent13).invoke(null, objArr173)).longValue();
                                            j = (((((-440154812592L) + (434 * jLongValue40)) + (((((-1018876882) | j9) | jLongValue40) ^ (-1)) * 433)) + ((-433) * ((-1018876882) | (((jLongValue40 ^ (-1)) | j7) ^ (-1))))) + (433 * ((((-1018876882) | j7) ^ (-1)) | ((1018876881 | jLongValue40) ^ (-1))))) - 1993378766;
                                            i27 = ((int) (j >> 32)) & (501358106 + (((~((-1399562750) | i50)) | 36348333) * 168) + ((~((-36348334) | i)) * 168) + (((~((-37663662) | i50)) | 1315328 | (~((-1363214417) | i))) * 168));
                                            i28 = (int) Runtime.getRuntime().totalMemory();
                                            if ((i27 | (((int) j) & (818885255 + (((~i28) | 815267938) * 1324) + (((~(i28 | 1907884514)) | (~(949856371 | i28))) * (-1324)) + 660897014))) != 0) {
                                                Object[] objArr175 = {new int[1], null, new int[]{i}, new int[]{i ^ 276}};
                                                int iMyTid4 = Process.myTid();
                                                int i657 = (((~((-682603084) | iMyTid4)) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + 642436324 + (((~((~iMyTid4) | (-682603084))) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                                                int i658 = (-795555818) - (~(-(-(((i657 | 16) << 1) - (i657 ^ 16)))));
                                                int i659 = i658 << 13;
                                                int i660 = (i659 & (~i658)) | ((~i659) & i658);
                                                int i661 = i660 >>> 17;
                                                int i662 = ((~i660) & i661) | ((~i661) & i660);
                                                int i663 = i662 << 5;
                                                ((int[]) objArr175[0])[0] = ((~i662) & i663) | ((~i663) & i662);
                                                return objArr175;
                                            }
                                            objComponent14 = setSystemGestureExclusionRectsL30479.component5(1040376484);
                                            if (objComponent14 == null) {
                                                int iResolveSizeAndState = 51 - View.resolveSizeAndState(0, 0, 0);
                                                char keyRepeatDelay4 = (char) (35819 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                int maximumDrawingCacheSize4 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6989;
                                                byte b93 = (byte) ($$b & 7);
                                                byte b94 = b93;
                                                Object[] objArr176 = new Object[1];
                                                a(b93, b94, b94, objArr176);
                                                objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState, keyRepeatDelay4, maximumDrawingCacheSize4, 1823975111, false, (String) objArr176[0], new Class[0]);
                                            }
                                            long jLongValue41 = ((Long) ((Method) objComponent14).invoke(null, null)).longValue();
                                            long j88 = (-350426689872L) + ((-344) * jLongValue41);
                                            long j89 = jLongValue41 ^ (-1);
                                            long j90 = (-1018682239) | j89;
                                            long j91 = j88 + (((j90 ^ (-1)) | (((-1018682239) | j7) ^ (-1))) * 345) + ((((j89 | 1018682238) ^ (-1)) | (((-1018682239) | j9) ^ (-1))) * 345) + (345 * ((j90 | j7) ^ (-1))) + 974347477;
                                            int i664 = ~((-704710921) | i);
                                            i29 = ((int) (j91 >> 32)) & (2129201866 + ((2367488 | i664) * (-476)) + (i664 * 952) + ((~((-704710921) | i50)) * 476));
                                            i30 = ((int) j91) & (45498674 + (((~(i50 | 206649862)) | 1638565296 | (~((-201338887) | i))) * 717) + (((~(206649862 | i)) | (~((-201338887) | i50)) | 1638565296) * 717));
                                            if (((i29 & i30) | (i29 ^ i30)) != 0) {
                                                Object[] objArr177 = {new int[1], null, new int[]{i}, new int[]{i}};
                                                int i665 = (~(i & 273)) & (i | 273);
                                                int iNextInt5 = new Random().nextInt(364098100);
                                                int i666 = -(-(((((~((-1015966882) | iNextInt5)) | 134348960) * (-566)) - 437695578) + ((~(iNextInt5 | (-881617922))) * 566) + 16));
                                                int i667 = (i666 ^ (-795555817)) + ((i666 & (-795555817)) << 1);
                                                int i668 = (i667 << 13) ^ i667;
                                                int i669 = i668 >>> 17;
                                                int i670 = (i668 | i669) & (~(i668 & i669));
                                                int i671 = i670 << 5;
                                                ((int[]) objArr177[0])[0] = ((~i670) & i671) | ((~i671) & i670);
                                                return objArr177;
                                            }
                                            objComponent15 = setSystemGestureExclusionRectsL30479.component5(868741314);
                                            if (objComponent15 == null) {
                                                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 49;
                                                char touchSlop7 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                                int i672 = 3631 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                byte b95 = (byte) ($$b & 7);
                                                byte b96 = b95;
                                                Object[] objArr178 = new Object[1];
                                                a(b95, b96, b96, objArr178);
                                                objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority2, touchSlop7, i672, 1634907297, false, (String) objArr178[0], new Class[0]);
                                            }
                                            long jLongValue42 = ((Long) ((Method) objComponent15).invoke(null, null)).longValue();
                                            long jMyPid3 = (-325446666) | (((long) Process.myPid()) ^ (-1));
                                            long j92 = ((((160770653004L + ((-494) * jLongValue42)) + ((-495) * (((-325446666) | jLongValue42) ^ (-1)))) + (495 * jMyPid3)) + (495 * (((325446665 | (jLongValue42 ^ (-1))) ^ (-1)) | (jMyPid3 ^ (-1))))) - 1062423017;
                                            i31 = ((int) (j92 >> 32)) & (1090348114 + (((~(1465883494 | i50)) | 1391857390) * (-933)) + (((~(1391857390 | i50)) | 84513024) * 933) + 328459710);
                                            int i673 = (int) j92;
                                            int iNextInt6 = new Random().nextInt();
                                            int i674 = ~iNextInt6;
                                            int i675 = (~((-1526664760) | i674)) | 1247153174;
                                            int i676 = ~(iNextInt6 | 1610587711);
                                            i32 = i673 & ((((i675 | i676) * (-252)) - 687239171) + ((i676 | (~(i674 | (-279511586)))) * 252));
                                            if (((i31 & i32) | (i31 ^ i32)) == 0) {
                                                int i677 = $vD14832N6715;
                                                int i678 = ((i677 | 41) << 1) - (i677 ^ 41);
                                                $sG29839 = i678 % 128;
                                                int i679 = i678 % 2;
                                                Object[] objArr179 = {new int[1], null, new int[]{i}, new int[]{i}};
                                                int i680 = (~(i & 279)) & (i | 279);
                                                int i681 = (-1456249293) + (((~((-244574758) | i50)) | 585629633) * (-235)) + (((~((-244574758) | i)) | 585629633) * (-470)) + (((~(i | (-202375205))) | 543430080) * 235);
                                                int iVD14832N67122 = qU20128.vD14832N6715();
                                                int i682 = (-2928) + (i681 * 185);
                                                int i683 = ~((-17) | i681);
                                                int i684 = ~iVD14832N67122;
                                                int i685 = ~((i684 & i681) | (i684 ^ i681));
                                                int i686 = ((i683 & i685) | (i683 ^ i685)) * 184;
                                                int i687 = (i682 & i686) + (i686 | i682);
                                                int i688 = ~i681;
                                                int i689 = (i687 - (~(((~((i688 & 16) | (i688 ^ 16))) | iVD14832N67122) * (-184)))) - 1;
                                                int i690 = ~iVD14832N67122;
                                                int i691 = -(-((~((i690 & (-17)) | ((-17) ^ i690))) * 184));
                                                int i692 = ((i689 ^ i691) + ((i691 & i689) << 1)) - 795555817;
                                                int i693 = (i692 << 13) ^ i692;
                                                int i694 = i693 >>> 17;
                                                int i695 = ((~i693) & i694) | ((~i694) & i693);
                                                int i696 = i695 << 5;
                                                ((int[]) objArr179[0])[0] = ((~i695) & i696) | ((~i696) & i695);
                                                return objArr179;
                                            }
                                            Object[] objArr180 = {Integer.valueOf(i), obj, -795555817, 16777216};
                                            objComponent16 = setSystemGestureExclusionRectsL30479.component5(-948477103);
                                            if (objComponent16 == null) {
                                                objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "") + 52, (char) Color.red(0), 5266 - ExpandableListView.getPackedPositionGroup(0L), -1782438094, false, null, new Class[]{Integer.TYPE, (Class) setSystemGestureExclusionRectsL30479.component5(53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), 5318 - View.resolveSize(0, 0)), Integer.TYPE, Integer.TYPE});
                                            }
                                            Object objNewInstance = ((Constructor) objComponent16).newInstance(objArr180);
                                            try {
                                                Object[] objArr181 = new Object[1];
                                                b("㋤氶轊\u2e64䧄\ue8df௹ꔏ쐡朁蚠↵䃐\ue3eeᴱ뱝", 24281 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr181);
                                                Class<?> cls = Class.forName((String) objArr181[0]);
                                                int iIndexOf13 = TextUtils.indexOf("", "", 0, 0);
                                                Object[] objArr182 = new Object[1];
                                                c((byte) (((iIndexOf13 | 104) << 1) - (iIndexOf13 ^ 104)), 5 - (KeyEvent.getMaxKeyCode() >> 16), "\u0015\u001f\u000e\u0014㙖", objArr182);
                                                cls.getMethod((String) objArr182[0], null).invoke(objNewInstance, null);
                                                Object[] objArr183 = {new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i}};
                                                int i697 = (((-1231816622) + (((~((-767889679) | i50)) | (~((-62314713) | i))) * (-370))) + ((((~(i | (-767889679))) | (~((-62314713) | i50))) | (-804772319)) * (-370))) - 1413014606;
                                                int i698 = ((i697 | (-795555817)) << 1) - (i697 ^ (-795555817));
                                                int i699 = i698 ^ (i698 << 13);
                                                int i700 = i699 >>> 17;
                                                int i701 = (i699 | i700) & (~(i699 & i700));
                                                int i702 = i701 << 5;
                                                return objArr183;
                                            } catch (Throwable th4) {
                                                Throwable cause4 = th4.getCause();
                                                if (cause4 != null) {
                                                    throw cause4;
                                                }
                                                throw th4;
                                            }
                                        }
                                        int i703 = $vD14832N6715;
                                        int i704 = ((i703 | 13) << 1) - (i703 ^ 13);
                                        $sG29839 = i704 % 128;
                                        int i705 = i704 % 2;
                                        objArr = new Object[]{new int[1], null, new int[]{i}, new int[]{i}};
                                        int i706 = (i & (-265)) | (i50 & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED);
                                        int iMaxMemory5 = (int) Runtime.getRuntime().maxMemory();
                                        int i707 = ~iMaxMemory5;
                                        int i708 = ~(176911264 | i707);
                                        int i709 = -(-(711673750 + ((611320902 | i708) * (-712)) + (((~(iMaxMemory5 | 788232166)) | (~(i707 | (-611320903)))) * (-712)) + (((-653293127) | i708) * 712) + 16));
                                        int i710 = ((i709 | (-795555817)) << 1) - (i709 ^ (-795555817));
                                        int i711 = i710 << 13;
                                        int i712 = (i711 & (~i710)) | ((~i711) & i710);
                                        int i713 = i712 ^ (i712 >>> 17);
                                        int i714 = i713 << 5;
                                        i20 = 0;
                                        ((int[]) objArr[0])[0] = (i713 | i714) & (~(i713 & i714));
                                        i19 = i20;
                                        if (((int[]) objArr[2])[i19] != ((int[]) objArr[r14])[i19]) {
                                            return objArr;
                                        }
                                        Object[] objArr1610 = {2};
                                        objComponent10 = setSystemGestureExclusionRectsL30479.component5(-902658636);
                                        if (objComponent10 == null) {
                                            int i6010 = 50 - (ExpandableListView.getPackedPositionForGroup(i19) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i19) == 0L ? 0 : -1));
                                            char c18 = (char) (34703 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                            int touchSlop8 = (ViewConfiguration.getTouchSlop() >> 8) + 5370;
                                            byte b810 = (byte) ($$b & 7);
                                            byte b811 = b810;
                                            Object[] objArr1611 = new Object[1];
                                            a(b810, b811, b811, objArr1611);
                                            objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i6010, c18, touchSlop8, -1735933481, false, (String) objArr1611[0], new Class[]{Integer.TYPE});
                                        }
                                        long jLongValue310 = ((Long) ((Method) objComponent10).invoke(null, objArr1610)).longValue();
                                        long j810 = jLongValue310 ^ (-1);
                                        long jElapsedRealtime3 = (jLongValue310 | ((long) ((int) SystemClock.elapsedRealtime()))) ^ (-1);
                                        long j811 = (-215634760050L) + ((-195) * jLongValue310) + ((-196) * (((j810 | 551495550) ^ (-1)) | jElapsedRealtime3)) + (392 * (551495550 | jLongValue310)) + (196 * (jElapsedRealtime3 | (((-551495551) | j810) ^ (-1)))) + 1044088161;
                                        int i6011 = (~((-1054699079) | i50)) | 672204802 | (~(382527332 | i50));
                                        i21 = ((int) (j811 >> 32)) & ((-1413401978) + (((~((-33057) | i)) | i6011) * 590) + (i6011 * (-1180)) + (((~((-382527333) | i50)) | (~(1054699078 | i50))) * 590));
                                        int iMyTid5 = Process.myTid();
                                        int i6012 = ~((-1294086235) | iMyTid5);
                                        int i6013 = ~iMyTid5;
                                        i22 = ((int) j811) & ((-1184507382) + ((i6012 | (~((-1051041) | i6013))) * 497) + (((~(iMyTid5 | (-1051041))) | (~((-1562603612) | i6013)) | 268517377) * 497));
                                        if (((i21 & i22) | (i21 ^ i22)) == 2) {
                                            Object[] objArr1612 = {new int[]{(i614 | i615) & (~(i614 & i615))}, null, new int[]{i}, new int[]{i610}};
                                            int i6110 = i ^ RotationOptions.ROTATE_270;
                                            int i6111 = (((627456806 + ((409294611 | i50) * (-757))) + ((~((-17989825) | i)) * 1514)) + (((~(i | 427284435)) | ((~((-420909780) | i50)) | 402919955)) * 757)) - 795555801;
                                            int i6112 = i6111 << 13;
                                            int i6113 = (i6112 | i6111) & (~(i6111 & i6112));
                                            int i6114 = i6113 ^ (i6113 >>> 17);
                                            int i6115 = i6114 << 5;
                                            return objArr1612;
                                        }
                                        objComponent11 = setSystemGestureExclusionRectsL30479.component5(1483925104);
                                        if (objComponent11 == null) {
                                            int i6116 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50;
                                            char maxKeyCode6 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 43215);
                                            int packedPositionType11 = ExpandableListView.getPackedPositionType(0L) + 6938;
                                            byte b812 = (byte) ($$b & 7);
                                            byte b97 = b812;
                                            Object[] objArr1613 = new Object[1];
                                            a(b812, b97, b97, objArr1613);
                                            objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(i6116, maxKeyCode6, packedPositionType11, 180855315, false, (String) objArr1613[0], new Class[0]);
                                        }
                                        long jLongValue311 = ((Long) ((Method) objComponent11).invoke(null, null)).longValue();
                                        long j812 = (-27141803565L) + ((-667) * jLongValue311);
                                        long j813 = jLongValue311 ^ (-1);
                                        long jNextInt6 = new Random().nextInt(1072028167);
                                        long j814 = 20330939 | jNextInt6;
                                        long j815 = (((j812 + ((-668) * (j813 | (j814 ^ (-1))))) + (1336 * (20330939 | ((jNextInt6 | j813) ^ (-1))))) + (668 * (j814 | j813))) - 1570748318;
                                        int iFreeMemory7 = (int) Runtime.getRuntime().freeMemory();
                                        int i6117 = ~iFreeMemory7;
                                        i23 = ((int) (j815 >> 32)) & ((-1051372822) + (((~(1843948065 | i6117)) | (-2113830520)) * 184) + ((iFreeMemory7 | 136839200) * (-184)) + ((~(406721654 | i6117)) * 184));
                                        int i6118 = (int) j815;
                                        int i6119 = ~(1536711891 | i50);
                                        i24 = i6118 & (((((25691137 | i6119) | (~((-1536711892) | i))) * (-338)) - 1343556697) + ((i6119 | (~((-1511020755) | i))) * 338));
                                        if (((i23 & i24) | (i23 ^ i24)) != 0) {
                                            Object[] objArr1614 = {new int[1], null, new int[]{i}, new int[]{i620}};
                                            int i6210 = (~(i & 272)) & (i | 272);
                                            int iMyUid5 = Process.myUid();
                                            int i6211 = ~iMyUid5;
                                            int i6212 = 918747726 + (((~(494657502 | i6211)) | 335546888) * 220) + (((~(i6211 | 473468696)) | 356735694) * (-440)) + ((iMyUid5 | 494657502) * 220);
                                            int i6213 = (i6212 & 16) + (i6212 | 16);
                                            int i6214 = (i6213 & (-795555817)) + (i6213 | (-795555817));
                                            int i6215 = i6214 << 13;
                                            int i6216 = (i6215 & (~i6214)) | ((~i6215) & i6214);
                                            int i6217 = i6216 ^ (i6216 >>> 17);
                                            int i6218 = i6217 << 5;
                                            ((int[]) objArr1614[0])[0] = (i6217 | i6218) & (~(i6217 & i6218));
                                            return objArr1614;
                                        }
                                        long[] jArr4 = {624887784092251L};
                                        int i6219 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                        int i6310 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                        int i6311 = (i6310 & 17) + (i6310 | 17);
                                        Object[] objArr1615 = new Object[1];
                                        c((byte) ((i6219 ^ 29) + ((i6219 & 29) << 1)), i6311, "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0004\u0015!\f#\"㘆", objArr1615);
                                        Object[] objArr1616 = {(String) objArr1615[0], Integer.valueOf((int) r14), 2251799813685247L, jArr4};
                                        objComponent12 = setSystemGestureExclusionRectsL30479.component5(-1564039546);
                                        if (objComponent12 == null) {
                                            int iIndexOf14 = 51 - TextUtils.indexOf("", "");
                                            char scrollBarSize5 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                            int offsetBefore4 = TextUtils.getOffsetBefore("", 0) + 3424;
                                            byte b98 = (byte) ($$b & 7);
                                            byte b99 = b98;
                                            Object[] objArr1710 = new Object[1];
                                            a(b98, b99, b99, objArr1710);
                                            objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf14, scrollBarSize5, offsetBefore4, -260840731, false, (String) objArr1710[0], new Class[]{String.class, Integer.TYPE, Long.TYPE, long[].class});
                                        }
                                        long jLongValue312 = ((Long) ((Method) objComponent12).invoke(null, objArr1616)).longValue();
                                        long j816 = jLongValue312 ^ (-1);
                                        long jMyPid4 = Process.myPid();
                                        long j817 = (-262979659610L) + (367 * jLongValue312) + (((-716565830) | jLongValue312) * (-366)) + ((-366) * ((-716565830) | ((j816 | jMyPid4) ^ (-1)))) + (366 * (((716565829 | jLongValue312) ^ (-1)) | (((j816 | (-716565830)) | jMyPid4) ^ (-1)))) + 1240967392;
                                        int i6312 = (-818885110) + (((~(985833301 | i)) | (-2144575488) | (~(1871907583 | i))) * (-880));
                                        int i6313 = (~(985833301 | i50)) | (-1871907584);
                                        int i6314 = ~((-985833302) | i);
                                        i25 = ((int) (j817 >> 32)) & (i6312 + ((i6313 | i6314) * (-880)) + (i6314 * 880));
                                        int i6315 = (int) Runtime.getRuntime().totalMemory();
                                        int i6316 = (~(438242792 | i6315)) | (-1000296426);
                                        i26 = ((int) j817) & ((-1537497691) + (i6316 * 992) + ((i6316 | (~((~i6315) | (-436929985)))) * (-496)) + ((i6315 | (-998983618)) * 496));
                                        if (((i25 & i26) | (i25 ^ i26)) != 0) {
                                            int i6317 = $vD14832N6715;
                                            int i6318 = i6317 + 87;
                                            $sG29839 = i6318 % 128;
                                            int i6319 = i6318 % 2;
                                            int i6410 = (i6317 ^ 59) + ((i6317 & 59) << 1);
                                            $sG29839 = i6410 % 128;
                                            int i6411 = i6410 % 2;
                                            Object[] objArr1711 = {new int[]{(i652 | i653) & (~(i652 & i653))}, null, new int[]{i}, new int[]{i642}};
                                            int i6412 = (~(i & 275)) & (i | 275);
                                            int i6413 = 407164134 + (((~((-301994500) | i50)) | (~(439474083 | i))) * 520);
                                            int i6414 = ~((-439474084) | i50);
                                            int i6415 = ~(i | 390730307);
                                            int i6416 = i6413 + ((i6414 | i6415) * (-1040)) + ((i6415 | (~((-390730308) | i50)) | 137479584) * 520);
                                            int i6417 = -(-(((i6416 | 16) << 1) - (i6416 ^ 16)));
                                            int i6418 = (i6417 ^ (-795555817)) + ((i6417 & (-795555817)) << 1);
                                            int i6419 = i6418 << 13;
                                            int i6510 = (i6419 | i6418) & (~(i6418 & i6419));
                                            int i6511 = i6510 >>> 17;
                                            int i6512 = (i6510 | i6511) & (~(i6510 & i6511));
                                            int i6513 = i6512 << 5;
                                            return objArr1711;
                                        }
                                        int i6514 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                        int i6515 = (i6514 ^ 1601) + ((i6514 & 1601) << 1);
                                        Object[] objArr1712 = new Object[1];
                                        b("㊡㒫㹩※⮥ⶱ\u1771\u192eï\u0ab4౯", i6515, objArr1712);
                                        Object[] objArr1713 = {(String) objArr1712[0]};
                                        objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                                        if (objComponent13 == null) {
                                            int maxKeyCode7 = 52 - (KeyEvent.getMaxKeyCode() >> 16);
                                            char offsetBefore5 = (char) (59725 - TextUtils.getOffsetBefore("", 0));
                                            int i6516 = 6317 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                            Object[] objArr1714 = new Object[1];
                                            a(2, (byte) 0, (byte) 0, objArr1714);
                                            objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode7, offsetBefore5, i6516, 369154319, false, (String) objArr1714[0], new Class[]{String.class});
                                        }
                                        long jLongValue43 = ((Long) ((Method) objComponent13).invoke(null, objArr1713)).longValue();
                                        j = (((((-440154812592L) + (434 * jLongValue43)) + (((((-1018876882) | j9) | jLongValue43) ^ (-1)) * 433)) + ((-433) * ((-1018876882) | (((jLongValue43 ^ (-1)) | j7) ^ (-1))))) + (433 * ((((-1018876882) | j7) ^ (-1)) | ((1018876881 | jLongValue43) ^ (-1))))) - 1993378766;
                                        i27 = ((int) (j >> 32)) & (501358106 + (((~((-1399562750) | i50)) | 36348333) * 168) + ((~((-36348334) | i)) * 168) + (((~((-37663662) | i50)) | 1315328 | (~((-1363214417) | i))) * 168));
                                        i28 = (int) Runtime.getRuntime().totalMemory();
                                        if ((i27 | (((int) j) & (818885255 + (((~i28) | 815267938) * 1324) + (((~(i28 | 1907884514)) | (~(949856371 | i28))) * (-1324)) + 660897014))) != 0) {
                                            Object[] objArr1715 = {new int[1], null, new int[]{i}, new int[]{i ^ 276}};
                                            int iMyTid6 = Process.myTid();
                                            int i6517 = (((~((-682603084) | iMyTid6)) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + 642436324 + (((~((~iMyTid6) | (-682603084))) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                                            int i6518 = (-795555818) - (~(-(-(((i6517 | 16) << 1) - (i6517 ^ 16)))));
                                            int i6519 = i6518 << 13;
                                            int i6610 = (i6519 & (~i6518)) | ((~i6519) & i6518);
                                            int i6611 = i6610 >>> 17;
                                            int i6612 = ((~i6610) & i6611) | ((~i6611) & i6610);
                                            int i6613 = i6612 << 5;
                                            ((int[]) objArr1715[0])[0] = ((~i6612) & i6613) | ((~i6613) & i6612);
                                            return objArr1715;
                                        }
                                        objComponent14 = setSystemGestureExclusionRectsL30479.component5(1040376484);
                                        if (objComponent14 == null) {
                                            int iResolveSizeAndState2 = 51 - View.resolveSizeAndState(0, 0, 0);
                                            char keyRepeatDelay5 = (char) (35819 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                                            int maximumDrawingCacheSize5 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6989;
                                            byte b910 = (byte) ($$b & 7);
                                            byte b911 = b910;
                                            Object[] objArr1716 = new Object[1];
                                            a(b910, b911, b911, objArr1716);
                                            objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState2, keyRepeatDelay5, maximumDrawingCacheSize5, 1823975111, false, (String) objArr1716[0], new Class[0]);
                                        }
                                        long jLongValue44 = ((Long) ((Method) objComponent14).invoke(null, null)).longValue();
                                        long j818 = (-350426689872L) + ((-344) * jLongValue44);
                                        long j819 = jLongValue44 ^ (-1);
                                        long j93 = (-1018682239) | j819;
                                        long j94 = j818 + (((j93 ^ (-1)) | (((-1018682239) | j7) ^ (-1))) * 345) + ((((j819 | 1018682238) ^ (-1)) | (((-1018682239) | j9) ^ (-1))) * 345) + (345 * ((j93 | j7) ^ (-1))) + 974347477;
                                        int i6614 = ~((-704710921) | i);
                                        i29 = ((int) (j94 >> 32)) & (2129201866 + ((2367488 | i6614) * (-476)) + (i6614 * 952) + ((~((-704710921) | i50)) * 476));
                                        i30 = ((int) j94) & (45498674 + (((~(i50 | 206649862)) | 1638565296 | (~((-201338887) | i))) * 717) + (((~(206649862 | i)) | (~((-201338887) | i50)) | 1638565296) * 717));
                                        if (((i29 & i30) | (i29 ^ i30)) != 0) {
                                            Object[] objArr1717 = {new int[1], null, new int[]{i}, new int[]{i665}};
                                            int i6615 = (~(i & 273)) & (i | 273);
                                            int iNextInt7 = new Random().nextInt(364098100);
                                            int i6616 = -(-(((((~((-1015966882) | iNextInt7)) | 134348960) * (-566)) - 437695578) + ((~(iNextInt7 | (-881617922))) * 566) + 16));
                                            int i6617 = (i6616 ^ (-795555817)) + ((i6616 & (-795555817)) << 1);
                                            int i6618 = (i6617 << 13) ^ i6617;
                                            int i6619 = i6618 >>> 17;
                                            int i6710 = (i6618 | i6619) & (~(i6618 & i6619));
                                            int i6711 = i6710 << 5;
                                            ((int[]) objArr1717[0])[0] = ((~i6710) & i6711) | ((~i6711) & i6710);
                                            return objArr1717;
                                        }
                                        objComponent15 = setSystemGestureExclusionRectsL30479.component5(868741314);
                                        if (objComponent15 == null) {
                                            int threadPriority3 = ((Process.getThreadPriority(0) + 20) >> 6) + 49;
                                            char touchSlop9 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                            int i6712 = 3631 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                            byte b912 = (byte) ($$b & 7);
                                            byte b913 = b912;
                                            Object[] objArr1718 = new Object[1];
                                            a(b912, b913, b913, objArr1718);
                                            objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority3, touchSlop9, i6712, 1634907297, false, (String) objArr1718[0], new Class[0]);
                                        }
                                        long jLongValue45 = ((Long) ((Method) objComponent15).invoke(null, null)).longValue();
                                        long jMyPid5 = (-325446666) | (((long) Process.myPid()) ^ (-1));
                                        long j95 = ((((160770653004L + ((-494) * jLongValue45)) + ((-495) * (((-325446666) | jLongValue45) ^ (-1)))) + (495 * jMyPid5)) + (495 * (((325446665 | (jLongValue45 ^ (-1))) ^ (-1)) | (jMyPid5 ^ (-1))))) - 1062423017;
                                        i31 = ((int) (j95 >> 32)) & (1090348114 + (((~(1465883494 | i50)) | 1391857390) * (-933)) + (((~(1391857390 | i50)) | 84513024) * 933) + 328459710);
                                        int i6713 = (int) j95;
                                        int iNextInt8 = new Random().nextInt();
                                        int i6714 = ~iNextInt8;
                                        int i6715 = (~((-1526664760) | i6714)) | 1247153174;
                                        int i6716 = ~(iNextInt8 | 1610587711);
                                        i32 = i6713 & ((((i6715 | i6716) * (-252)) - 687239171) + ((i6716 | (~(i6714 | (-279511586)))) * 252));
                                        if (((i31 & i32) | (i31 ^ i32)) == 0) {
                                            Object[] objArr184 = {Integer.valueOf(i), obj, -795555817, 16777216};
                                            objComponent16 = setSystemGestureExclusionRectsL30479.component5(-948477103);
                                            if (objComponent16 == null) {
                                                objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "") + 52, (char) Color.red(0), 5266 - ExpandableListView.getPackedPositionGroup(0L), -1782438094, false, null, new Class[]{Integer.TYPE, (Class) setSystemGestureExclusionRectsL30479.component5(53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), 5318 - View.resolveSize(0, 0)), Integer.TYPE, Integer.TYPE});
                                            }
                                            Object objNewInstance2 = ((Constructor) objComponent16).newInstance(objArr184);
                                            Object[] objArr185 = new Object[1];
                                            b("㋤氶轊\u2e64䧄\ue8df௹ꔏ쐡朁蚠↵䃐\ue3eeᴱ뱝", 24281 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr185);
                                            Class<?> cls2 = Class.forName((String) objArr185[0]);
                                            int iIndexOf15 = TextUtils.indexOf("", "", 0, 0);
                                            Object[] objArr186 = new Object[1];
                                            c((byte) (((iIndexOf15 | 104) << 1) - (iIndexOf15 ^ 104)), 5 - (KeyEvent.getMaxKeyCode() >> 16), "\u0015\u001f\u000e\u0014㙖", objArr186);
                                            cls2.getMethod((String) objArr186[0], null).invoke(objNewInstance2, null);
                                            Object[] objArr187 = {new int[]{((~i701) & i702) | ((~i702) & i701)}, null, new int[]{i}, new int[]{i}};
                                            int i6910 = (((-1231816622) + (((~((-767889679) | i50)) | (~((-62314713) | i))) * (-370))) + ((((~(i | (-767889679))) | (~((-62314713) | i50))) | (-804772319)) * (-370))) - 1413014606;
                                            int i6911 = ((i6910 | (-795555817)) << 1) - (i6910 ^ (-795555817));
                                            int i6912 = i6911 ^ (i6911 << 13);
                                            int i7010 = i6912 >>> 17;
                                            int i7011 = (i6912 | i7010) & (~(i6912 & i7010));
                                            int i7012 = i7011 << 5;
                                            return objArr187;
                                        }
                                        int i6717 = $vD14832N6715;
                                        int i6718 = ((i6717 | 41) << 1) - (i6717 ^ 41);
                                        $sG29839 = i6718 % 128;
                                        int i6719 = i6718 % 2;
                                        Object[] objArr1719 = {new int[1], null, new int[]{i}, new int[]{i680}};
                                        int i6810 = (~(i & 279)) & (i | 279);
                                        int i6811 = (-1456249293) + (((~((-244574758) | i50)) | 585629633) * (-235)) + (((~((-244574758) | i)) | 585629633) * (-470)) + (((~(i | (-202375205))) | 543430080) * 235);
                                        int iVD14832N67123 = qU20128.vD14832N6715();
                                        int i6812 = (-2928) + (i6811 * 185);
                                        int i6813 = ~((-17) | i6811);
                                        int i6814 = ~iVD14832N67123;
                                        int i6815 = ~((i6814 & i6811) | (i6814 ^ i6811));
                                        int i6816 = ((i6813 & i6815) | (i6813 ^ i6815)) * 184;
                                        int i6817 = (i6812 & i6816) + (i6816 | i6812);
                                        int i6818 = ~i6811;
                                        int i6819 = (i6817 - (~(((~((i6818 & 16) | (i6818 ^ 16))) | iVD14832N67123) * (-184)))) - 1;
                                        int i6913 = ~iVD14832N67123;
                                        int i6914 = -(-((~((i6913 & (-17)) | ((-17) ^ i6913))) * 184));
                                        int i6915 = ((i6819 ^ i6914) + ((i6914 & i6819) << 1)) - 795555817;
                                        int i6916 = (i6915 << 13) ^ i6915;
                                        int i6917 = i6916 >>> 17;
                                        int i6918 = ((~i6916) & i6917) | ((~i6917) & i6916);
                                        int i6919 = i6918 << 5;
                                        ((int[]) objArr1719[0])[0] = ((~i6918) & i6919) | ((~i6919) & i6918);
                                        return objArr1719;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bufferedInputStream = bufferedInputStream2;
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Exception unused5) {
                                            }
                                        }
                                        throw th;
                                    }
                                    if (i5 != 0) {
                                        Object[] objArr1510 = {new int[]{(i549 | i550) & (~(i549 & i550))}, null, new int[]{i}, new int[]{i544}};
                                        int i5410 = (~(i & 242)) & (i | 242);
                                        int i5411 = ((((~((-21717984) | i50)) | (~(i | 808486407))) * 959) - 573120131) + (((~(i | (-21717984))) | (~(i50 | 808486407))) * 959) + 16;
                                        int i5412 = (i5411 ^ (-795555817)) + ((i5411 & (-795555817)) << 1);
                                        int i5413 = i5412 << 13;
                                        int i5414 = ((~i5412) & i5413) | ((~i5413) & i5412);
                                        int i5415 = i5414 ^ (i5414 >>> 17);
                                        int i5510 = i5415 << 5;
                                        return objArr1510;
                                    }
                                    objComponent5 = setSystemGestureExclusionRectsL30479.component5(1719424323);
                                    if (objComponent5 == null) {
                                        int iArgb2 = 52 - Color.argb(0, 0, 0, 0);
                                        char pressedStateDuration3 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 34154);
                                        int mirror4 = AndroidCharacter.getMirror('0') + 6165;
                                        byte b710 = (byte) ($$b & 7);
                                        byte b813 = b710;
                                        Object[] objArr1511 = new Object[1];
                                        a(b710, b813, b813, objArr1511);
                                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iArgb2, pressedStateDuration3, mirror4, 885592352, false, (String) objArr1511[0], new Class[0]);
                                    }
                                    long jLongValue313 = ((Long) ((Method) objComponent5).invoke(null, null)).longValue();
                                    long j610 = (-674563057530L) + ((-463) * jLongValue313);
                                    long j611 = jLongValue313 ^ (-1);
                                    long j612 = (int) Runtime.getRuntime().totalMemory();
                                    long j613 = j612 ^ (-1);
                                    long j614 = (j611 | (-1450673242)) ^ (-1);
                                    long j615 = j610 + ((((j611 | j613) ^ (-1)) | j614 | ((j613 | (-1450673242)) ^ (-1))) * 464) + ((-464) * (j612 | 1450673241 | j611)) + (464 * (j614 | (((-1450673242) | j612) ^ (-1)))) + 1790423822;
                                    i6 = ((int) (j615 >> 32)) & ((-802173004) + (((-1491073) | i50) * (-369)) + (((~(574537924 | i50)) | 2011764335) * (-369)) + (((~((-574537925) | i)) | 573046852 | (~(2013255407 | i50))) * 369));
                                    i7 = ((int) j615) & ((-2144799044) + ((1973075296 | i50) * (-757)) + ((~((-2113686) | i)) * 1514) + (((~((-884665590) | i50)) | 882551904 | (~(1975188981 | i))) * 757));
                                    if (((i6 & i7) | (i6 ^ i7)) != 0) {
                                        objComponent6 = setSystemGestureExclusionRectsL30479.component5(-263869551);
                                        if (objComponent6 == null) {
                                            int iLastIndexOf10 = 51 - TextUtils.lastIndexOf("", '0', 0, 0);
                                            char cAlpha3 = (char) Color.alpha(0);
                                            int longPressTimeout4 = (ViewConfiguration.getLongPressTimeout() >> 16) + 4902;
                                            byte b814 = (byte) ($$b & 7);
                                            byte b815 = b814;
                                            Object[] objArr1512 = new Object[1];
                                            a(b814, b815, b815, objArr1512);
                                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf10, cAlpha3, longPressTimeout4, -1561268238, false, (String) objArr1512[0], new Class[0]);
                                        }
                                        long jLongValue314 = ((Long) ((Method) objComponent6).invoke(null, null)).longValue();
                                        long j710 = 286149488848L + ((-1343) * jLongValue314) + ((jLongValue314 | ((425184976 | j7) ^ (-1))) * 672) + ((-672) * ((((-425184977) | j9) ^ (-1)) | ((jLongValue314 | j7) ^ (-1))));
                                        long j711 = jLongValue314 ^ (-1);
                                        long j712 = j710 + (672 * (((j711 | j9) ^ (-1)) | ((j711 | 425184976) ^ (-1)))) + 844405833;
                                        i8 = ((int) (j712 >> 32)) & (1215928528 + (((~(40899514 | i50)) | (~((-1478125926) | i))) * 210) + (((~((-1048865) | i50)) | (~(1517976575 | i))) * 210));
                                        i9 = (int) j712;
                                        i10 = (~((-461084805) | i)) | (~((-1898311215) | i50));
                                        i11 = ~(461084804 | i50);
                                        if ((i8 | (i9 & (535374625 + ((i10 | i11) * (-516)) + (((~((-173674625) | i)) | (~(2071985838 | i50))) * 516) + (((-2071985839) | i11) * 516)))) != 0) {
                                            i12 = (~(i & 281)) & (i | 281);
                                        } else {
                                            i12 = i;
                                        }
                                        if (i12 != i) {
                                            Object[] objArr1513 = {new int[]{((~i557) & i558) | ((~i558) & i557)}, null, new int[]{i}, new int[]{i12}};
                                            int i5511 = 1297773118 + (((~((-680794966) | i)) | (-687333334)) * (-502)) + ((~((-537923909) | i50)) * (-502)) + (((-680794966) | (~((-149409426) | i))) * 502);
                                            int i5512 = -(-((i5511 ^ 16) + ((i5511 & 16) << 1)));
                                            int i5513 = (i5512 & (-795555817)) + (i5512 | (-795555817));
                                            int i5514 = i5513 << 13;
                                            int i5515 = (i5514 | i5513) & (~(i5513 & i5514));
                                            int i5516 = i5515 >>> 17;
                                            int i5517 = (i5515 | i5516) & (~(i5515 & i5516));
                                            int i5518 = i5517 << 5;
                                            objArr = objArr1513;
                                            i19 = 0;
                                        } else {
                                            objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1690268346);
                                            if (objComponent7 == null) {
                                                int scrollBarSize6 = 52 - (ViewConfiguration.getScrollBarSize() >> 8);
                                                char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                                                int touchSlop10 = 5058 - (ViewConfiguration.getTouchSlop() >> 8);
                                                Object[] objArr1617 = new Object[1];
                                                a(0, (byte) 0, (byte) 0, objArr1617);
                                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollBarSize6, modifierMetaStateMask2, touchSlop10, -906639067, false, (String) objArr1617[0], new Class[0]);
                                            }
                                            long jLongValue315 = ((Long) ((Method) objComponent7).invoke(null, null)).longValue();
                                            long j713 = ((-1433526153) | jLongValue315) ^ (-1);
                                            long j714 = jLongValue315 ^ (-1);
                                            long j715 = (j714 | 1433526152) ^ (-1);
                                            long jMyPid6 = Process.myPid();
                                            long j716 = 571976934648L + (399 * jLongValue315) + ((j713 | j715 | ((j714 | jMyPid6) ^ (-1))) * 398) + ((-1194) * (1433526152 | jLongValue315)) + (398 * (((j714 | (jMyPid6 ^ (-1))) ^ (-1)) | j713 | j715)) + 240368949;
                                            int iMyUid6 = Process.myUid();
                                            i13 = ((int) (j716 >> 32)) & (((((~((-4262145) | iMyUid6)) | 295050) * TypedValues.Position.TYPE_TRANSITION_EASING) - 845927784) + ((~((~iMyUid6) | (-4262145))) * TypedValues.Position.TYPE_TRANSITION_EASING));
                                            int i5519 = (~(1305414001 | i50)) | 34620424;
                                            int i5610 = ~((-1208222018) | i);
                                            i14 = ((int) j716) & ((-696539500) + ((i5519 | i5610) * (-713)) + (i5610 * 1426) + ((~(131812408 | i50)) * 713));
                                            if (((i13 & i14) | (i13 ^ i14)) != 0) {
                                                int i5611 = $vD14832N6715 + 93;
                                                $sG29839 = i5611 % 128;
                                                int i5612 = i5611 % 2;
                                                objArr = new Object[]{new int[]{i569}, null, new int[]{i}, new int[]{i563}};
                                                int i5613 = (~(i & 268)) & (i | 268);
                                                int i5614 = (-302877570) + (((~((-663685171) | i)) | (-166519221)) * (-948)) + ((~((-25952305) | i50)) * (-948)) + 1019630836;
                                                int i5615 = ((i5614 | (-795555817)) << 1) - (i5614 ^ (-795555817));
                                                int i5616 = i5615 ^ (i5615 << 13);
                                                int i5617 = i5616 >>> 17;
                                                int i5618 = ((~i5616) & i5617) | ((~i5617) & i5616);
                                                int i5619 = i5618 ^ (i5618 << 5);
                                                i20 = 0;
                                            } else {
                                                objComponent8 = setSystemGestureExclusionRectsL30479.component5(-597190889);
                                                if (objComponent8 == null) {
                                                    int iAxisFromString2 = 51 - MotionEvent.axisFromString("");
                                                    char c19 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int trimmedLength2 = 5058 - TextUtils.getTrimmedLength("");
                                                    byte b816 = (byte) ($$b & 7);
                                                    byte b817 = b816;
                                                    Object[] objArr1618 = new Object[1];
                                                    a(b816, b817, b817, objArr1618);
                                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iAxisFromString2, c19, trimmedLength2, -1898785932, false, (String) objArr1618[0], new Class[0]);
                                                }
                                                long jLongValue316 = ((Long) ((Method) objComponent8).invoke(null, null)).longValue();
                                                long j717 = (-355891266152L) + (530 * jLongValue316) + ((((j9 | (-671492957)) ^ (-1)) | (((-671492957) | jLongValue316) ^ (-1))) * 529) + (529 * ((jLongValue316 ^ (-1)) | (((-671492957) | j7) ^ (-1)))) + 1438166783;
                                                i15 = ((int) (j717 >> 32)) & (1587634074 + (((~(2035224068 | i)) | 44085337 | (~((-597997658) | i))) * (-744)) + ((1481311748 | i50) * 744) + (((-44085338) | i) * 744));
                                                int iUptimeMillis4 = (int) SystemClock.uptimeMillis();
                                                int i5710 = ~((-638384566) | iUptimeMillis4);
                                                int i5711 = ~iUptimeMillis4;
                                                int i5712 = i5710 | (~((-2075610976) | i5711));
                                                int i5713 = ~(638384565 | i5711);
                                                i16 = ((int) j717) & ((-1174865751) + ((i5712 | i5713) * (-516)) + (((~(iUptimeMillis4 | (-67678369))) | (~(2143289343 | i5711))) * 516) + (((-2143289344) | i5713) * 516));
                                                if (((i15 & i16) | (i15 ^ i16)) != 0) {
                                                    int i5714 = $vD14832N6715;
                                                    int i5715 = (i5714 & 93) + (i5714 | 93);
                                                    $sG29839 = i5715 % 128;
                                                    int i5716 = i5715 % 2;
                                                    objArr = new Object[]{new int[1], null, new int[]{i}, new int[]{i577}};
                                                    int i5717 = (~(i & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED)) & (i | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED);
                                                    int iFreeMemory8 = (int) Runtime.getRuntime().freeMemory();
                                                    int i5718 = ~iFreeMemory8;
                                                    int i5719 = (-795555818) - (~(-(-((((-1020405640) + ((((~(i5718 | (-106285294))) | 280617) | (~((-830485009) | iFreeMemory8))) * 717)) + (((~(iFreeMemory8 | (-106285294))) | ((~(i5718 | (-830485009))) | 280617)) * 717)) + 16))));
                                                    int i5810 = i5719 << 13;
                                                    int i5811 = (i5810 | i5719) & (~(i5719 & i5810));
                                                    int i5812 = i5811 ^ (i5811 >>> 17);
                                                    int i5813 = i5812 << 5;
                                                    i20 = 0;
                                                    ((int[]) objArr[0])[0] = (i5812 | i5813) & (~(i5812 & i5813));
                                                } else {
                                                    objComponent9 = setSystemGestureExclusionRectsL30479.component5(-977249762);
                                                    if (objComponent9 == null) {
                                                        int iBlue10 = 52 - Color.blue(0);
                                                        char doubleTapTimeout2 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8601);
                                                        int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0) + 4244;
                                                        byte b818 = (byte) ($$b & 7);
                                                        byte b819 = b818;
                                                        Object[] objArr1619 = new Object[1];
                                                        a(b818, b819, b819, objArr1619);
                                                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(iBlue10, doubleTapTimeout2, iMakeMeasureSpec3, -1753932163, false, (String) objArr1619[0], new Class[0]);
                                                    }
                                                    long jLongValue317 = ((Long) ((Method) objComponent9).invoke(null, null)).longValue();
                                                    long jNextInt7 = new Random().nextInt();
                                                    long j718 = jNextInt7 ^ (-1);
                                                    long j719 = (((((-77242034412L) + ((-520) * jLongValue317)) + ((-1042) * ((-147973246) | ((j718 | jLongValue317) ^ (-1))))) + ((jLongValue317 | jNextInt7) * 521)) + (521 * ((((j718 | (-147973246)) | jLongValue317) ^ (-1)) | (((147973245 | (jLongValue317 ^ (-1))) ^ (-1)) | ((147973245 | jNextInt7) ^ (-1)))))) - 1966967319;
                                                    int iMaxMemory6 = (int) Runtime.getRuntime().maxMemory();
                                                    int i5814 = ~iMaxMemory6;
                                                    i17 = ((int) (j719 >> 32)) & (1473358611 + (((~((-848415205) | iMaxMemory6)) | (~(2009325680 | i5814))) * 333) + (((~(iMaxMemory6 | 2009325680)) | (~(i5814 | (-848415205)))) * 333));
                                                    int iNextInt9 = new Random().nextInt();
                                                    i18 = ((int) j719) & (131025114 + ((~((~iNextInt9) | (-5510401))) * 433) + (((~(637449546 | iNextInt9)) | 799776863) * (-433)) + (((~(iNextInt9 | 799776863)) | 631939146) * 433));
                                                    if (((i17 & i18) | (i17 ^ i18)) != 0) {
                                                        objArr = new Object[]{new int[]{((~i588) & i589) | ((~i589) & i588)}, null, new int[]{i}, new int[]{(i & (-281)) | (i50 & 280)}};
                                                        int i5815 = (-795555818) - (~((((((~((-673300485) | i50)) | (~(753915894 | i))) * 988) + 810229114) + ((((~((-749588981) | i)) | 76288496) | (~(753915894 | i50))) * 988)) + 16));
                                                        int i5816 = (i5815 << 13) ^ i5815;
                                                        int i5817 = i5816 >>> 17;
                                                        int i5818 = ((~i5816) & i5817) | ((~i5817) & i5816);
                                                        int i5819 = i5818 << 5;
                                                        i19 = 0;
                                                    } else {
                                                        objArr = new Object[]{new int[]{i605 ^ (i605 << 5)}, null, new int[]{i}, new int[]{i}};
                                                        int i5910 = ~(361107621 | i);
                                                        int i5911 = (((67240100 | i5910) * (-196)) - 639097166) + ((i5910 | 293867521) * 196);
                                                        int i5912 = i5911 * (-496);
                                                        int i5913 = ~i5911;
                                                        int i5914 = -(-((~(((-1) ^ i5913) | i5913)) * 497));
                                                        int i5915 = (i5912 & i5914) + (i5912 | i5914);
                                                        int i5916 = ((-1) ^ i5913) | i5913;
                                                        int i5917 = ~((i5916 & i) | (i5916 ^ i));
                                                        int i5918 = ~i5911;
                                                        int i5919 = ~((i5918 & i50) | (i5918 ^ i50));
                                                        int i6014 = i5915 + (((i5917 & i5919) | (i5917 ^ i5919)) * 497);
                                                        int i6015 = ((~(((-1) ^ i5911) | i5911)) | (~((i5913 ^ i) | (i5913 & i)))) * 497;
                                                        int i6016 = (((i6014 | i6015) << 1) - (i6015 ^ i6014)) - 795555817;
                                                        int i6017 = (i6016 << 13) ^ i6016;
                                                        int i6018 = i6017 >>> 17;
                                                        int i6019 = ((~i6017) & i6018) | ((~i6018) & i6017);
                                                        i19 = 0;
                                                    }
                                                }
                                            }
                                        }
                                        if (((int[]) objArr[2])[i19] != ((int[]) objArr[r14])[i19]) {
                                            return objArr;
                                        }
                                        Object[] objArr16110 = {2};
                                        objComponent10 = setSystemGestureExclusionRectsL30479.component5(-902658636);
                                        if (objComponent10 == null) {
                                            int i60110 = 50 - (ExpandableListView.getPackedPositionForGroup(i19) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i19) == 0L ? 0 : -1));
                                            char c110 = (char) (34703 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                            int touchSlop11 = (ViewConfiguration.getTouchSlop() >> 8) + 5370;
                                            byte b8110 = (byte) ($$b & 7);
                                            byte b8111 = b8110;
                                            Object[] objArr16111 = new Object[1];
                                            a(b8110, b8111, b8111, objArr16111);
                                            objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i60110, c110, touchSlop11, -1735933481, false, (String) objArr16111[0], new Class[]{Integer.TYPE});
                                        }
                                        long jLongValue318 = ((Long) ((Method) objComponent10).invoke(null, objArr16110)).longValue();
                                        long j8110 = jLongValue318 ^ (-1);
                                        long jElapsedRealtime4 = (jLongValue318 | ((long) ((int) SystemClock.elapsedRealtime()))) ^ (-1);
                                        long j8111 = (-215634760050L) + ((-195) * jLongValue318) + ((-196) * (((j8110 | 551495550) ^ (-1)) | jElapsedRealtime4)) + (392 * (551495550 | jLongValue318)) + (196 * (jElapsedRealtime4 | (((-551495551) | j8110) ^ (-1)))) + 1044088161;
                                        int i60111 = (~((-1054699079) | i50)) | 672204802 | (~(382527332 | i50));
                                        i21 = ((int) (j8111 >> 32)) & ((-1413401978) + (((~((-33057) | i)) | i60111) * 590) + (i60111 * (-1180)) + (((~((-382527333) | i50)) | (~(1054699078 | i50))) * 590));
                                        int iMyTid7 = Process.myTid();
                                        int i60112 = ~((-1294086235) | iMyTid7);
                                        int i60113 = ~iMyTid7;
                                        i22 = ((int) j8111) & ((-1184507382) + ((i60112 | (~((-1051041) | i60113))) * 497) + (((~(iMyTid7 | (-1051041))) | (~((-1562603612) | i60113)) | 268517377) * 497));
                                        if (((i21 & i22) | (i21 ^ i22)) == 2) {
                                            Object[] objArr16112 = {new int[]{(i6114 | i6115) & (~(i6114 & i6115))}, null, new int[]{i}, new int[]{i6110}};
                                            int i61110 = i ^ RotationOptions.ROTATE_270;
                                            int i61111 = (((627456806 + ((409294611 | i50) * (-757))) + ((~((-17989825) | i)) * 1514)) + (((~(i | 427284435)) | ((~((-420909780) | i50)) | 402919955)) * 757)) - 795555801;
                                            int i61112 = i61111 << 13;
                                            int i61113 = (i61112 | i61111) & (~(i61111 & i61112));
                                            int i61114 = i61113 ^ (i61113 >>> 17);
                                            int i61115 = i61114 << 5;
                                            return objArr16112;
                                        }
                                        objComponent11 = setSystemGestureExclusionRectsL30479.component5(1483925104);
                                        if (objComponent11 == null) {
                                            int i61116 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50;
                                            char maxKeyCode8 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 43215);
                                            int packedPositionType12 = ExpandableListView.getPackedPositionType(0L) + 6938;
                                            byte b8112 = (byte) ($$b & 7);
                                            byte b914 = b8112;
                                            Object[] objArr16113 = new Object[1];
                                            a(b8112, b914, b914, objArr16113);
                                            objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(i61116, maxKeyCode8, packedPositionType12, 180855315, false, (String) objArr16113[0], new Class[0]);
                                        }
                                        long jLongValue319 = ((Long) ((Method) objComponent11).invoke(null, null)).longValue();
                                        long j8112 = (-27141803565L) + ((-667) * jLongValue319);
                                        long j8113 = jLongValue319 ^ (-1);
                                        long jNextInt8 = new Random().nextInt(1072028167);
                                        long j8114 = 20330939 | jNextInt8;
                                        long j8115 = (((j8112 + ((-668) * (j8113 | (j8114 ^ (-1))))) + (1336 * (20330939 | ((jNextInt8 | j8113) ^ (-1))))) + (668 * (j8114 | j8113))) - 1570748318;
                                        int iFreeMemory9 = (int) Runtime.getRuntime().freeMemory();
                                        int i61117 = ~iFreeMemory9;
                                        i23 = ((int) (j8115 >> 32)) & ((-1051372822) + (((~(1843948065 | i61117)) | (-2113830520)) * 184) + ((iFreeMemory9 | 136839200) * (-184)) + ((~(406721654 | i61117)) * 184));
                                        int i61118 = (int) j8115;
                                        int i61119 = ~(1536711891 | i50);
                                        i24 = i61118 & (((((25691137 | i61119) | (~((-1536711892) | i))) * (-338)) - 1343556697) + ((i61119 | (~((-1511020755) | i))) * 338));
                                        if (((i23 & i24) | (i23 ^ i24)) != 0) {
                                            Object[] objArr16114 = {new int[1], null, new int[]{i}, new int[]{i6210}};
                                            int i62110 = (~(i & 272)) & (i | 272);
                                            int iMyUid7 = Process.myUid();
                                            int i62111 = ~iMyUid7;
                                            int i62112 = 918747726 + (((~(494657502 | i62111)) | 335546888) * 220) + (((~(i62111 | 473468696)) | 356735694) * (-440)) + ((iMyUid7 | 494657502) * 220);
                                            int i62113 = (i62112 & 16) + (i62112 | 16);
                                            int i62114 = (i62113 & (-795555817)) + (i62113 | (-795555817));
                                            int i62115 = i62114 << 13;
                                            int i62116 = (i62115 & (~i62114)) | ((~i62115) & i62114);
                                            int i62117 = i62116 ^ (i62116 >>> 17);
                                            int i62118 = i62117 << 5;
                                            ((int[]) objArr16114[0])[0] = (i62117 | i62118) & (~(i62117 & i62118));
                                            return objArr16114;
                                        }
                                        long[] jArr5 = {624887784092251L};
                                        int i62119 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                        int i63110 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                        int i63111 = (i63110 & 17) + (i63110 | 17);
                                        Object[] objArr16115 = new Object[1];
                                        c((byte) ((i62119 ^ 29) + ((i62119 & 29) << 1)), i63111, "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0004\u0015!\f#\"㘆", objArr16115);
                                        Object[] objArr16116 = {(String) objArr16115[0], Integer.valueOf((int) r14), 2251799813685247L, jArr5};
                                        objComponent12 = setSystemGestureExclusionRectsL30479.component5(-1564039546);
                                        if (objComponent12 == null) {
                                            int iIndexOf16 = 51 - TextUtils.indexOf("", "");
                                            char scrollBarSize7 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                            int offsetBefore6 = TextUtils.getOffsetBefore("", 0) + 3424;
                                            byte b915 = (byte) ($$b & 7);
                                            byte b916 = b915;
                                            Object[] objArr17110 = new Object[1];
                                            a(b915, b916, b916, objArr17110);
                                            objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf16, scrollBarSize7, offsetBefore6, -260840731, false, (String) objArr17110[0], new Class[]{String.class, Integer.TYPE, Long.TYPE, long[].class});
                                        }
                                        long jLongValue3110 = ((Long) ((Method) objComponent12).invoke(null, objArr16116)).longValue();
                                        long j8116 = jLongValue3110 ^ (-1);
                                        long jMyPid7 = Process.myPid();
                                        long j8117 = (-262979659610L) + (367 * jLongValue3110) + (((-716565830) | jLongValue3110) * (-366)) + ((-366) * ((-716565830) | ((j8116 | jMyPid7) ^ (-1)))) + (366 * (((716565829 | jLongValue3110) ^ (-1)) | (((j8116 | (-716565830)) | jMyPid7) ^ (-1)))) + 1240967392;
                                        int i63112 = (-818885110) + (((~(985833301 | i)) | (-2144575488) | (~(1871907583 | i))) * (-880));
                                        int i63113 = (~(985833301 | i50)) | (-1871907584);
                                        int i63114 = ~((-985833302) | i);
                                        i25 = ((int) (j8117 >> 32)) & (i63112 + ((i63113 | i63114) * (-880)) + (i63114 * 880));
                                        int i63115 = (int) Runtime.getRuntime().totalMemory();
                                        int i63116 = (~(438242792 | i63115)) | (-1000296426);
                                        i26 = ((int) j8117) & ((-1537497691) + (i63116 * 992) + ((i63116 | (~((~i63115) | (-436929985)))) * (-496)) + ((i63115 | (-998983618)) * 496));
                                        if (((i25 & i26) | (i25 ^ i26)) != 0) {
                                            int i63117 = $vD14832N6715;
                                            int i63118 = i63117 + 87;
                                            $sG29839 = i63118 % 128;
                                            int i63119 = i63118 % 2;
                                            int i64110 = (i63117 ^ 59) + ((i63117 & 59) << 1);
                                            $sG29839 = i64110 % 128;
                                            int i64111 = i64110 % 2;
                                            Object[] objArr17111 = {new int[]{(i6512 | i6513) & (~(i6512 & i6513))}, null, new int[]{i}, new int[]{i6412}};
                                            int i64112 = (~(i & 275)) & (i | 275);
                                            int i64113 = 407164134 + (((~((-301994500) | i50)) | (~(439474083 | i))) * 520);
                                            int i64114 = ~((-439474084) | i50);
                                            int i64115 = ~(i | 390730307);
                                            int i64116 = i64113 + ((i64114 | i64115) * (-1040)) + ((i64115 | (~((-390730308) | i50)) | 137479584) * 520);
                                            int i64117 = -(-(((i64116 | 16) << 1) - (i64116 ^ 16)));
                                            int i64118 = (i64117 ^ (-795555817)) + ((i64117 & (-795555817)) << 1);
                                            int i64119 = i64118 << 13;
                                            int i65110 = (i64119 | i64118) & (~(i64118 & i64119));
                                            int i65111 = i65110 >>> 17;
                                            int i65112 = (i65110 | i65111) & (~(i65110 & i65111));
                                            int i65113 = i65112 << 5;
                                            return objArr17111;
                                        }
                                        int i65114 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                        int i65115 = (i65114 ^ 1601) + ((i65114 & 1601) << 1);
                                        Object[] objArr17112 = new Object[1];
                                        b("㊡㒫㹩※⮥ⶱ\u1771\u192eï\u0ab4౯", i65115, objArr17112);
                                        Object[] objArr17113 = {(String) objArr17112[0]};
                                        objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                                        if (objComponent13 == null) {
                                            int maxKeyCode9 = 52 - (KeyEvent.getMaxKeyCode() >> 16);
                                            char offsetBefore7 = (char) (59725 - TextUtils.getOffsetBefore("", 0));
                                            int i65116 = 6317 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                            Object[] objArr17114 = new Object[1];
                                            a(2, (byte) 0, (byte) 0, objArr17114);
                                            objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode9, offsetBefore7, i65116, 369154319, false, (String) objArr17114[0], new Class[]{String.class});
                                        }
                                        long jLongValue46 = ((Long) ((Method) objComponent13).invoke(null, objArr17113)).longValue();
                                        j = (((((-440154812592L) + (434 * jLongValue46)) + (((((-1018876882) | j9) | jLongValue46) ^ (-1)) * 433)) + ((-433) * ((-1018876882) | (((jLongValue46 ^ (-1)) | j7) ^ (-1))))) + (433 * ((((-1018876882) | j7) ^ (-1)) | ((1018876881 | jLongValue46) ^ (-1))))) - 1993378766;
                                        i27 = ((int) (j >> 32)) & (501358106 + (((~((-1399562750) | i50)) | 36348333) * 168) + ((~((-36348334) | i)) * 168) + (((~((-37663662) | i50)) | 1315328 | (~((-1363214417) | i))) * 168));
                                        i28 = (int) Runtime.getRuntime().totalMemory();
                                        if ((i27 | (((int) j) & (818885255 + (((~i28) | 815267938) * 1324) + (((~(i28 | 1907884514)) | (~(949856371 | i28))) * (-1324)) + 660897014))) != 0) {
                                            Object[] objArr17115 = {new int[1], null, new int[]{i}, new int[]{i ^ 276}};
                                            int iMyTid8 = Process.myTid();
                                            int i65117 = (((~((-682603084) | iMyTid8)) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + 642436324 + (((~((~iMyTid8) | (-682603084))) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                                            int i65118 = (-795555818) - (~(-(-(((i65117 | 16) << 1) - (i65117 ^ 16)))));
                                            int i65119 = i65118 << 13;
                                            int i66110 = (i65119 & (~i65118)) | ((~i65119) & i65118);
                                            int i66111 = i66110 >>> 17;
                                            int i66112 = ((~i66110) & i66111) | ((~i66111) & i66110);
                                            int i66113 = i66112 << 5;
                                            ((int[]) objArr17115[0])[0] = ((~i66112) & i66113) | ((~i66113) & i66112);
                                            return objArr17115;
                                        }
                                        objComponent14 = setSystemGestureExclusionRectsL30479.component5(1040376484);
                                        if (objComponent14 == null) {
                                            int iResolveSizeAndState3 = 51 - View.resolveSizeAndState(0, 0, 0);
                                            char keyRepeatDelay6 = (char) (35819 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                                            int maximumDrawingCacheSize6 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6989;
                                            byte b917 = (byte) ($$b & 7);
                                            byte b918 = b917;
                                            Object[] objArr17116 = new Object[1];
                                            a(b917, b918, b918, objArr17116);
                                            objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState3, keyRepeatDelay6, maximumDrawingCacheSize6, 1823975111, false, (String) objArr17116[0], new Class[0]);
                                        }
                                        long jLongValue47 = ((Long) ((Method) objComponent14).invoke(null, null)).longValue();
                                        long j8118 = (-350426689872L) + ((-344) * jLongValue47);
                                        long j8119 = jLongValue47 ^ (-1);
                                        long j96 = (-1018682239) | j8119;
                                        long j97 = j8118 + (((j96 ^ (-1)) | (((-1018682239) | j7) ^ (-1))) * 345) + ((((j8119 | 1018682238) ^ (-1)) | (((-1018682239) | j9) ^ (-1))) * 345) + (345 * ((j96 | j7) ^ (-1))) + 974347477;
                                        int i66114 = ~((-704710921) | i);
                                        i29 = ((int) (j97 >> 32)) & (2129201866 + ((2367488 | i66114) * (-476)) + (i66114 * 952) + ((~((-704710921) | i50)) * 476));
                                        i30 = ((int) j97) & (45498674 + (((~(i50 | 206649862)) | 1638565296 | (~((-201338887) | i))) * 717) + (((~(206649862 | i)) | (~((-201338887) | i50)) | 1638565296) * 717));
                                        if (((i29 & i30) | (i29 ^ i30)) != 0) {
                                            Object[] objArr17117 = {new int[1], null, new int[]{i}, new int[]{i6615}};
                                            int i66115 = (~(i & 273)) & (i | 273);
                                            int iNextInt10 = new Random().nextInt(364098100);
                                            int i66116 = -(-(((((~((-1015966882) | iNextInt10)) | 134348960) * (-566)) - 437695578) + ((~(iNextInt10 | (-881617922))) * 566) + 16));
                                            int i66117 = (i66116 ^ (-795555817)) + ((i66116 & (-795555817)) << 1);
                                            int i66118 = (i66117 << 13) ^ i66117;
                                            int i66119 = i66118 >>> 17;
                                            int i67110 = (i66118 | i66119) & (~(i66118 & i66119));
                                            int i67111 = i67110 << 5;
                                            ((int[]) objArr17117[0])[0] = ((~i67110) & i67111) | ((~i67111) & i67110);
                                            return objArr17117;
                                        }
                                        objComponent15 = setSystemGestureExclusionRectsL30479.component5(868741314);
                                        if (objComponent15 == null) {
                                            int threadPriority4 = ((Process.getThreadPriority(0) + 20) >> 6) + 49;
                                            char touchSlop12 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                            int i67112 = 3631 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                            byte b919 = (byte) ($$b & 7);
                                            byte b9110 = b919;
                                            Object[] objArr17118 = new Object[1];
                                            a(b919, b9110, b9110, objArr17118);
                                            objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority4, touchSlop12, i67112, 1634907297, false, (String) objArr17118[0], new Class[0]);
                                        }
                                        long jLongValue48 = ((Long) ((Method) objComponent15).invoke(null, null)).longValue();
                                        long jMyPid8 = (-325446666) | (((long) Process.myPid()) ^ (-1));
                                        long j98 = ((((160770653004L + ((-494) * jLongValue48)) + ((-495) * (((-325446666) | jLongValue48) ^ (-1)))) + (495 * jMyPid8)) + (495 * (((325446665 | (jLongValue48 ^ (-1))) ^ (-1)) | (jMyPid8 ^ (-1))))) - 1062423017;
                                        i31 = ((int) (j98 >> 32)) & (1090348114 + (((~(1465883494 | i50)) | 1391857390) * (-933)) + (((~(1391857390 | i50)) | 84513024) * 933) + 328459710);
                                        int i67113 = (int) j98;
                                        int iNextInt11 = new Random().nextInt();
                                        int i67114 = ~iNextInt11;
                                        int i67115 = (~((-1526664760) | i67114)) | 1247153174;
                                        int i67116 = ~(iNextInt11 | 1610587711);
                                        i32 = i67113 & ((((i67115 | i67116) * (-252)) - 687239171) + ((i67116 | (~(i67114 | (-279511586)))) * 252));
                                        if (((i31 & i32) | (i31 ^ i32)) == 0) {
                                            Object[] objArr188 = {Integer.valueOf(i), obj, -795555817, 16777216};
                                            objComponent16 = setSystemGestureExclusionRectsL30479.component5(-948477103);
                                            if (objComponent16 == null) {
                                                objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "") + 52, (char) Color.red(0), 5266 - ExpandableListView.getPackedPositionGroup(0L), -1782438094, false, null, new Class[]{Integer.TYPE, (Class) setSystemGestureExclusionRectsL30479.component5(53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), 5318 - View.resolveSize(0, 0)), Integer.TYPE, Integer.TYPE});
                                            }
                                            Object objNewInstance3 = ((Constructor) objComponent16).newInstance(objArr188);
                                            Object[] objArr189 = new Object[1];
                                            b("㋤氶轊\u2e64䧄\ue8df௹ꔏ쐡朁蚠↵䃐\ue3eeᴱ뱝", 24281 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr189);
                                            Class<?> cls3 = Class.forName((String) objArr189[0]);
                                            int iIndexOf17 = TextUtils.indexOf("", "", 0, 0);
                                            Object[] objArr1810 = new Object[1];
                                            c((byte) (((iIndexOf17 | 104) << 1) - (iIndexOf17 ^ 104)), 5 - (KeyEvent.getMaxKeyCode() >> 16), "\u0015\u001f\u000e\u0014㙖", objArr1810);
                                            cls3.getMethod((String) objArr1810[0], null).invoke(objNewInstance3, null);
                                            Object[] objArr1811 = {new int[]{((~i7011) & i7012) | ((~i7012) & i7011)}, null, new int[]{i}, new int[]{i}};
                                            int i69110 = (((-1231816622) + (((~((-767889679) | i50)) | (~((-62314713) | i))) * (-370))) + ((((~(i | (-767889679))) | (~((-62314713) | i50))) | (-804772319)) * (-370))) - 1413014606;
                                            int i69111 = ((i69110 | (-795555817)) << 1) - (i69110 ^ (-795555817));
                                            int i69112 = i69111 ^ (i69111 << 13);
                                            int i7013 = i69112 >>> 17;
                                            int i7014 = (i69112 | i7013) & (~(i69112 & i7013));
                                            int i7015 = i7014 << 5;
                                            return objArr1811;
                                        }
                                        int i67117 = $vD14832N6715;
                                        int i67118 = ((i67117 | 41) << 1) - (i67117 ^ 41);
                                        $sG29839 = i67118 % 128;
                                        int i67119 = i67118 % 2;
                                        Object[] objArr17119 = {new int[1], null, new int[]{i}, new int[]{i6810}};
                                        int i68110 = (~(i & 279)) & (i | 279);
                                        int i68111 = (-1456249293) + (((~((-244574758) | i50)) | 585629633) * (-235)) + (((~((-244574758) | i)) | 585629633) * (-470)) + (((~(i | (-202375205))) | 543430080) * 235);
                                        int iVD14832N67124 = qU20128.vD14832N6715();
                                        int i68112 = (-2928) + (i68111 * 185);
                                        int i68113 = ~((-17) | i68111);
                                        int i68114 = ~iVD14832N67124;
                                        int i68115 = ~((i68114 & i68111) | (i68114 ^ i68111));
                                        int i68116 = ((i68113 & i68115) | (i68113 ^ i68115)) * 184;
                                        int i68117 = (i68112 & i68116) + (i68116 | i68112);
                                        int i68118 = ~i68111;
                                        int i68119 = (i68117 - (~(((~((i68118 & 16) | (i68118 ^ 16))) | iVD14832N67124) * (-184)))) - 1;
                                        int i69113 = ~iVD14832N67124;
                                        int i69114 = -(-((~((i69113 & (-17)) | ((-17) ^ i69113))) * 184));
                                        int i69115 = ((i68119 ^ i69114) + ((i69114 & i68119) << 1)) - 795555817;
                                        int i69116 = (i69115 << 13) ^ i69115;
                                        int i69117 = i69116 >>> 17;
                                        int i69118 = ((~i69116) & i69117) | ((~i69117) & i69116);
                                        int i69119 = i69118 << 5;
                                        ((int[]) objArr17119[0])[0] = ((~i69118) & i69119) | ((~i69119) & i69118);
                                        return objArr17119;
                                    }
                                    int i7016 = $vD14832N6715;
                                    int i7017 = ((i7016 | 13) << 1) - (i7016 ^ 13);
                                    $sG29839 = i7017 % 128;
                                    int i7018 = i7017 % 2;
                                    objArr = new Object[]{new int[1], null, new int[]{i}, new int[]{i706}};
                                    int i7019 = (i & (-265)) | (i50 & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED);
                                    int iMaxMemory7 = (int) Runtime.getRuntime().maxMemory();
                                    int i7020 = ~iMaxMemory7;
                                    int i7021 = ~(176911264 | i7020);
                                    int i7022 = -(-(711673750 + ((611320902 | i7021) * (-712)) + (((~(iMaxMemory7 | 788232166)) | (~(i7020 | (-611320903)))) * (-712)) + (((-653293127) | i7021) * 712) + 16));
                                    int i715 = ((i7022 | (-795555817)) << 1) - (i7022 ^ (-795555817));
                                    int i716 = i715 << 13;
                                    int i717 = (i716 & (~i715)) | ((~i716) & i715);
                                    int i718 = i717 ^ (i717 >>> 17);
                                    int i719 = i718 << 5;
                                    i20 = 0;
                                    ((int[]) objArr[0])[0] = (i718 | i719) & (~(i718 & i719));
                                    i19 = i20;
                                    if (((int[]) objArr[2])[i19] != ((int[]) objArr[r14])[i19]) {
                                        return objArr;
                                    }
                                    Object[] objArr16117 = {2};
                                    objComponent10 = setSystemGestureExclusionRectsL30479.component5(-902658636);
                                    if (objComponent10 == null) {
                                        int i60114 = 50 - (ExpandableListView.getPackedPositionForGroup(i19) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i19) == 0L ? 0 : -1));
                                        char c111 = (char) (34703 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                        int touchSlop13 = (ViewConfiguration.getTouchSlop() >> 8) + 5370;
                                        byte b8113 = (byte) ($$b & 7);
                                        byte b8114 = b8113;
                                        Object[] objArr16118 = new Object[1];
                                        a(b8113, b8114, b8114, objArr16118);
                                        objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i60114, c111, touchSlop13, -1735933481, false, (String) objArr16118[0], new Class[]{Integer.TYPE});
                                    }
                                    long jLongValue3111 = ((Long) ((Method) objComponent10).invoke(null, objArr16117)).longValue();
                                    long j81110 = jLongValue3111 ^ (-1);
                                    long jElapsedRealtime5 = (jLongValue3111 | ((long) ((int) SystemClock.elapsedRealtime()))) ^ (-1);
                                    long j81111 = (-215634760050L) + ((-195) * jLongValue3111) + ((-196) * (((j81110 | 551495550) ^ (-1)) | jElapsedRealtime5)) + (392 * (551495550 | jLongValue3111)) + (196 * (jElapsedRealtime5 | (((-551495551) | j81110) ^ (-1)))) + 1044088161;
                                    int i60115 = (~((-1054699079) | i50)) | 672204802 | (~(382527332 | i50));
                                    i21 = ((int) (j81111 >> 32)) & ((-1413401978) + (((~((-33057) | i)) | i60115) * 590) + (i60115 * (-1180)) + (((~((-382527333) | i50)) | (~(1054699078 | i50))) * 590));
                                    int iMyTid9 = Process.myTid();
                                    int i60116 = ~((-1294086235) | iMyTid9);
                                    int i60117 = ~iMyTid9;
                                    i22 = ((int) j81111) & ((-1184507382) + ((i60116 | (~((-1051041) | i60117))) * 497) + (((~(iMyTid9 | (-1051041))) | (~((-1562603612) | i60117)) | 268517377) * 497));
                                    if (((i21 & i22) | (i21 ^ i22)) == 2) {
                                        Object[] objArr16119 = {new int[]{(i61114 | i61115) & (~(i61114 & i61115))}, null, new int[]{i}, new int[]{i61110}};
                                        int i611110 = i ^ RotationOptions.ROTATE_270;
                                        int i611111 = (((627456806 + ((409294611 | i50) * (-757))) + ((~((-17989825) | i)) * 1514)) + (((~(i | 427284435)) | ((~((-420909780) | i50)) | 402919955)) * 757)) - 795555801;
                                        int i611112 = i611111 << 13;
                                        int i611113 = (i611112 | i611111) & (~(i611111 & i611112));
                                        int i611114 = i611113 ^ (i611113 >>> 17);
                                        int i611115 = i611114 << 5;
                                        return objArr16119;
                                    }
                                    objComponent11 = setSystemGestureExclusionRectsL30479.component5(1483925104);
                                    if (objComponent11 == null) {
                                        int i611116 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50;
                                        char maxKeyCode10 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 43215);
                                        int packedPositionType13 = ExpandableListView.getPackedPositionType(0L) + 6938;
                                        byte b8115 = (byte) ($$b & 7);
                                        byte b9111 = b8115;
                                        Object[] objArr161110 = new Object[1];
                                        a(b8115, b9111, b9111, objArr161110);
                                        objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(i611116, maxKeyCode10, packedPositionType13, 180855315, false, (String) objArr161110[0], new Class[0]);
                                    }
                                    long jLongValue3112 = ((Long) ((Method) objComponent11).invoke(null, null)).longValue();
                                    long j81112 = (-27141803565L) + ((-667) * jLongValue3112);
                                    long j81113 = jLongValue3112 ^ (-1);
                                    long jNextInt9 = new Random().nextInt(1072028167);
                                    long j81114 = 20330939 | jNextInt9;
                                    long j81115 = (((j81112 + ((-668) * (j81113 | (j81114 ^ (-1))))) + (1336 * (20330939 | ((jNextInt9 | j81113) ^ (-1))))) + (668 * (j81114 | j81113))) - 1570748318;
                                    int iFreeMemory10 = (int) Runtime.getRuntime().freeMemory();
                                    int i611117 = ~iFreeMemory10;
                                    i23 = ((int) (j81115 >> 32)) & ((-1051372822) + (((~(1843948065 | i611117)) | (-2113830520)) * 184) + ((iFreeMemory10 | 136839200) * (-184)) + ((~(406721654 | i611117)) * 184));
                                    int i611118 = (int) j81115;
                                    int i611119 = ~(1536711891 | i50);
                                    i24 = i611118 & (((((25691137 | i611119) | (~((-1536711892) | i))) * (-338)) - 1343556697) + ((i611119 | (~((-1511020755) | i))) * 338));
                                    if (((i23 & i24) | (i23 ^ i24)) != 0) {
                                        Object[] objArr161111 = {new int[1], null, new int[]{i}, new int[]{i62110}};
                                        int i621110 = (~(i & 272)) & (i | 272);
                                        int iMyUid8 = Process.myUid();
                                        int i621111 = ~iMyUid8;
                                        int i621112 = 918747726 + (((~(494657502 | i621111)) | 335546888) * 220) + (((~(i621111 | 473468696)) | 356735694) * (-440)) + ((iMyUid8 | 494657502) * 220);
                                        int i621113 = (i621112 & 16) + (i621112 | 16);
                                        int i621114 = (i621113 & (-795555817)) + (i621113 | (-795555817));
                                        int i621115 = i621114 << 13;
                                        int i621116 = (i621115 & (~i621114)) | ((~i621115) & i621114);
                                        int i621117 = i621116 ^ (i621116 >>> 17);
                                        int i621118 = i621117 << 5;
                                        ((int[]) objArr161111[0])[0] = (i621117 | i621118) & (~(i621117 & i621118));
                                        return objArr161111;
                                    }
                                    long[] jArr6 = {624887784092251L};
                                    int i621119 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                    int i631110 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                    int i631111 = (i631110 & 17) + (i631110 | 17);
                                    Object[] objArr161112 = new Object[1];
                                    c((byte) ((i621119 ^ 29) + ((i621119 & 29) << 1)), i631111, "\u0004\u0000\f \t\u0005\u0017\r\u0005\u0014\u0004\u0015!\f#\"㘆", objArr161112);
                                    Object[] objArr161113 = {(String) objArr161112[0], Integer.valueOf((int) r14), 2251799813685247L, jArr6};
                                    objComponent12 = setSystemGestureExclusionRectsL30479.component5(-1564039546);
                                    if (objComponent12 == null) {
                                        int iIndexOf18 = 51 - TextUtils.indexOf("", "");
                                        char scrollBarSize8 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                        int offsetBefore8 = TextUtils.getOffsetBefore("", 0) + 3424;
                                        byte b9112 = (byte) ($$b & 7);
                                        byte b9113 = b9112;
                                        Object[] objArr171110 = new Object[1];
                                        a(b9112, b9113, b9113, objArr171110);
                                        objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf18, scrollBarSize8, offsetBefore8, -260840731, false, (String) objArr171110[0], new Class[]{String.class, Integer.TYPE, Long.TYPE, long[].class});
                                    }
                                    long jLongValue3113 = ((Long) ((Method) objComponent12).invoke(null, objArr161113)).longValue();
                                    long j81116 = jLongValue3113 ^ (-1);
                                    long jMyPid9 = Process.myPid();
                                    long j81117 = (-262979659610L) + (367 * jLongValue3113) + (((-716565830) | jLongValue3113) * (-366)) + ((-366) * ((-716565830) | ((j81116 | jMyPid9) ^ (-1)))) + (366 * (((716565829 | jLongValue3113) ^ (-1)) | (((j81116 | (-716565830)) | jMyPid9) ^ (-1)))) + 1240967392;
                                    int i631112 = (-818885110) + (((~(985833301 | i)) | (-2144575488) | (~(1871907583 | i))) * (-880));
                                    int i631113 = (~(985833301 | i50)) | (-1871907584);
                                    int i631114 = ~((-985833302) | i);
                                    i25 = ((int) (j81117 >> 32)) & (i631112 + ((i631113 | i631114) * (-880)) + (i631114 * 880));
                                    int i631115 = (int) Runtime.getRuntime().totalMemory();
                                    int i631116 = (~(438242792 | i631115)) | (-1000296426);
                                    i26 = ((int) j81117) & ((-1537497691) + (i631116 * 992) + ((i631116 | (~((~i631115) | (-436929985)))) * (-496)) + ((i631115 | (-998983618)) * 496));
                                    if (((i25 & i26) | (i25 ^ i26)) != 0) {
                                        int i631117 = $vD14832N6715;
                                        int i631118 = i631117 + 87;
                                        $sG29839 = i631118 % 128;
                                        int i631119 = i631118 % 2;
                                        int i641110 = (i631117 ^ 59) + ((i631117 & 59) << 1);
                                        $sG29839 = i641110 % 128;
                                        int i641111 = i641110 % 2;
                                        Object[] objArr171111 = {new int[]{(i65112 | i65113) & (~(i65112 & i65113))}, null, new int[]{i}, new int[]{i64112}};
                                        int i641112 = (~(i & 275)) & (i | 275);
                                        int i641113 = 407164134 + (((~((-301994500) | i50)) | (~(439474083 | i))) * 520);
                                        int i641114 = ~((-439474084) | i50);
                                        int i641115 = ~(i | 390730307);
                                        int i641116 = i641113 + ((i641114 | i641115) * (-1040)) + ((i641115 | (~((-390730308) | i50)) | 137479584) * 520);
                                        int i641117 = -(-(((i641116 | 16) << 1) - (i641116 ^ 16)));
                                        int i641118 = (i641117 ^ (-795555817)) + ((i641117 & (-795555817)) << 1);
                                        int i641119 = i641118 << 13;
                                        int i651110 = (i641119 | i641118) & (~(i641118 & i641119));
                                        int i651111 = i651110 >>> 17;
                                        int i651112 = (i651110 | i651111) & (~(i651110 & i651111));
                                        int i651113 = i651112 << 5;
                                        return objArr171111;
                                    }
                                    int i651114 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    int i651115 = (i651114 ^ 1601) + ((i651114 & 1601) << 1);
                                    Object[] objArr171112 = new Object[1];
                                    b("㊡㒫㹩※⮥ⶱ\u1771\u192eï\u0ab4౯", i651115, objArr171112);
                                    Object[] objArr171113 = {(String) objArr171112[0]};
                                    objComponent13 = setSystemGestureExclusionRectsL30479.component5(1152753004);
                                    if (objComponent13 == null) {
                                        int maxKeyCode11 = 52 - (KeyEvent.getMaxKeyCode() >> 16);
                                        char offsetBefore9 = (char) (59725 - TextUtils.getOffsetBefore("", 0));
                                        int i651116 = 6317 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                        Object[] objArr171114 = new Object[1];
                                        a(2, (byte) 0, (byte) 0, objArr171114);
                                        objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode11, offsetBefore9, i651116, 369154319, false, (String) objArr171114[0], new Class[]{String.class});
                                    }
                                    long jLongValue49 = ((Long) ((Method) objComponent13).invoke(null, objArr171113)).longValue();
                                    j = (((((-440154812592L) + (434 * jLongValue49)) + (((((-1018876882) | j9) | jLongValue49) ^ (-1)) * 433)) + ((-433) * ((-1018876882) | (((jLongValue49 ^ (-1)) | j7) ^ (-1))))) + (433 * ((((-1018876882) | j7) ^ (-1)) | ((1018876881 | jLongValue49) ^ (-1))))) - 1993378766;
                                    i27 = ((int) (j >> 32)) & (501358106 + (((~((-1399562750) | i50)) | 36348333) * 168) + ((~((-36348334) | i)) * 168) + (((~((-37663662) | i50)) | 1315328 | (~((-1363214417) | i))) * 168));
                                    i28 = (int) Runtime.getRuntime().totalMemory();
                                    if ((i27 | (((int) j) & (818885255 + (((~i28) | 815267938) * 1324) + (((~(i28 | 1907884514)) | (~(949856371 | i28))) * (-1324)) + 660897014))) != 0) {
                                        Object[] objArr171115 = {new int[1], null, new int[]{i}, new int[]{i ^ 276}};
                                        int iMyTid10 = Process.myTid();
                                        int i651117 = (((~((-682603084) | iMyTid10)) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED) + 642436324 + (((~((~iMyTid10) | (-682603084))) | 543393232) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                                        int i651118 = (-795555818) - (~(-(-(((i651117 | 16) << 1) - (i651117 ^ 16)))));
                                        int i651119 = i651118 << 13;
                                        int i661110 = (i651119 & (~i651118)) | ((~i651119) & i651118);
                                        int i661111 = i661110 >>> 17;
                                        int i661112 = ((~i661110) & i661111) | ((~i661111) & i661110);
                                        int i661113 = i661112 << 5;
                                        ((int[]) objArr171115[0])[0] = ((~i661112) & i661113) | ((~i661113) & i661112);
                                        return objArr171115;
                                    }
                                    objComponent14 = setSystemGestureExclusionRectsL30479.component5(1040376484);
                                    if (objComponent14 == null) {
                                        int iResolveSizeAndState4 = 51 - View.resolveSizeAndState(0, 0, 0);
                                        char keyRepeatDelay7 = (char) (35819 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                                        int maximumDrawingCacheSize7 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6989;
                                        byte b9114 = (byte) ($$b & 7);
                                        byte b9115 = b9114;
                                        Object[] objArr171116 = new Object[1];
                                        a(b9114, b9115, b9115, objArr171116);
                                        objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState4, keyRepeatDelay7, maximumDrawingCacheSize7, 1823975111, false, (String) objArr171116[0], new Class[0]);
                                    }
                                    long jLongValue410 = ((Long) ((Method) objComponent14).invoke(null, null)).longValue();
                                    long j81118 = (-350426689872L) + ((-344) * jLongValue410);
                                    long j81119 = jLongValue410 ^ (-1);
                                    long j99 = (-1018682239) | j81119;
                                    long j910 = j81118 + (((j99 ^ (-1)) | (((-1018682239) | j7) ^ (-1))) * 345) + ((((j81119 | 1018682238) ^ (-1)) | (((-1018682239) | j9) ^ (-1))) * 345) + (345 * ((j99 | j7) ^ (-1))) + 974347477;
                                    int i661114 = ~((-704710921) | i);
                                    i29 = ((int) (j910 >> 32)) & (2129201866 + ((2367488 | i661114) * (-476)) + (i661114 * 952) + ((~((-704710921) | i50)) * 476));
                                    i30 = ((int) j910) & (45498674 + (((~(i50 | 206649862)) | 1638565296 | (~((-201338887) | i))) * 717) + (((~(206649862 | i)) | (~((-201338887) | i50)) | 1638565296) * 717));
                                    if (((i29 & i30) | (i29 ^ i30)) != 0) {
                                        Object[] objArr171117 = {new int[1], null, new int[]{i}, new int[]{i66115}};
                                        int i661115 = (~(i & 273)) & (i | 273);
                                        int iNextInt12 = new Random().nextInt(364098100);
                                        int i661116 = -(-(((((~((-1015966882) | iNextInt12)) | 134348960) * (-566)) - 437695578) + ((~(iNextInt12 | (-881617922))) * 566) + 16));
                                        int i661117 = (i661116 ^ (-795555817)) + ((i661116 & (-795555817)) << 1);
                                        int i661118 = (i661117 << 13) ^ i661117;
                                        int i661119 = i661118 >>> 17;
                                        int i671110 = (i661118 | i661119) & (~(i661118 & i661119));
                                        int i671111 = i671110 << 5;
                                        ((int[]) objArr171117[0])[0] = ((~i671110) & i671111) | ((~i671111) & i671110);
                                        return objArr171117;
                                    }
                                    objComponent15 = setSystemGestureExclusionRectsL30479.component5(868741314);
                                    if (objComponent15 == null) {
                                        int threadPriority5 = ((Process.getThreadPriority(0) + 20) >> 6) + 49;
                                        char touchSlop14 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                        int i671112 = 3631 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                        byte b9116 = (byte) ($$b & 7);
                                        byte b9117 = b9116;
                                        Object[] objArr171118 = new Object[1];
                                        a(b9116, b9117, b9117, objArr171118);
                                        objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority5, touchSlop14, i671112, 1634907297, false, (String) objArr171118[0], new Class[0]);
                                    }
                                    long jLongValue411 = ((Long) ((Method) objComponent15).invoke(null, null)).longValue();
                                    long jMyPid10 = (-325446666) | (((long) Process.myPid()) ^ (-1));
                                    long j911 = ((((160770653004L + ((-494) * jLongValue411)) + ((-495) * (((-325446666) | jLongValue411) ^ (-1)))) + (495 * jMyPid10)) + (495 * (((325446665 | (jLongValue411 ^ (-1))) ^ (-1)) | (jMyPid10 ^ (-1))))) - 1062423017;
                                    i31 = ((int) (j911 >> 32)) & (1090348114 + (((~(1465883494 | i50)) | 1391857390) * (-933)) + (((~(1391857390 | i50)) | 84513024) * 933) + 328459710);
                                    int i671113 = (int) j911;
                                    int iNextInt13 = new Random().nextInt();
                                    int i671114 = ~iNextInt13;
                                    int i671115 = (~((-1526664760) | i671114)) | 1247153174;
                                    int i671116 = ~(iNextInt13 | 1610587711);
                                    i32 = i671113 & ((((i671115 | i671116) * (-252)) - 687239171) + ((i671116 | (~(i671114 | (-279511586)))) * 252));
                                    if (((i31 & i32) | (i31 ^ i32)) == 0) {
                                        Object[] objArr1812 = {Integer.valueOf(i), obj, -795555817, 16777216};
                                        objComponent16 = setSystemGestureExclusionRectsL30479.component5(-948477103);
                                        if (objComponent16 == null) {
                                            objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", "") + 52, (char) Color.red(0), 5266 - ExpandableListView.getPackedPositionGroup(0L), -1782438094, false, null, new Class[]{Integer.TYPE, (Class) setSystemGestureExclusionRectsL30479.component5(53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), 5318 - View.resolveSize(0, 0)), Integer.TYPE, Integer.TYPE});
                                        }
                                        Object objNewInstance4 = ((Constructor) objComponent16).newInstance(objArr1812);
                                        Object[] objArr1813 = new Object[1];
                                        b("㋤氶轊\u2e64䧄\ue8df௹ꔏ쐡朁蚠↵䃐\ue3eeᴱ뱝", 24281 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr1813);
                                        Class<?> cls4 = Class.forName((String) objArr1813[0]);
                                        int iIndexOf19 = TextUtils.indexOf("", "", 0, 0);
                                        Object[] objArr1814 = new Object[1];
                                        c((byte) (((iIndexOf19 | 104) << 1) - (iIndexOf19 ^ 104)), 5 - (KeyEvent.getMaxKeyCode() >> 16), "\u0015\u001f\u000e\u0014㙖", objArr1814);
                                        cls4.getMethod((String) objArr1814[0], null).invoke(objNewInstance4, null);
                                        Object[] objArr1815 = {new int[]{((~i7014) & i7015) | ((~i7015) & i7014)}, null, new int[]{i}, new int[]{i}};
                                        int i691110 = (((-1231816622) + (((~((-767889679) | i50)) | (~((-62314713) | i))) * (-370))) + ((((~(i | (-767889679))) | (~((-62314713) | i50))) | (-804772319)) * (-370))) - 1413014606;
                                        int i691111 = ((i691110 | (-795555817)) << 1) - (i691110 ^ (-795555817));
                                        int i691112 = i691111 ^ (i691111 << 13);
                                        int i70110 = i691112 >>> 17;
                                        int i70111 = (i691112 | i70110) & (~(i691112 & i70110));
                                        int i70112 = i70111 << 5;
                                        return objArr1815;
                                    }
                                    int i671117 = $vD14832N6715;
                                    int i671118 = ((i671117 | 41) << 1) - (i671117 ^ 41);
                                    $sG29839 = i671118 % 128;
                                    int i671119 = i671118 % 2;
                                    Object[] objArr171119 = {new int[1], null, new int[]{i}, new int[]{i68110}};
                                    int i681110 = (~(i & 279)) & (i | 279);
                                    int i681111 = (-1456249293) + (((~((-244574758) | i50)) | 585629633) * (-235)) + (((~((-244574758) | i)) | 585629633) * (-470)) + (((~(i | (-202375205))) | 543430080) * 235);
                                    int iVD14832N67125 = qU20128.vD14832N6715();
                                    int i681112 = (-2928) + (i681111 * 185);
                                    int i681113 = ~((-17) | i681111);
                                    int i681114 = ~iVD14832N67125;
                                    int i681115 = ~((i681114 & i681111) | (i681114 ^ i681111));
                                    int i681116 = ((i681113 & i681115) | (i681113 ^ i681115)) * 184;
                                    int i681117 = (i681112 & i681116) + (i681116 | i681112);
                                    int i681118 = ~i681111;
                                    int i681119 = (i681117 - (~(((~((i681118 & 16) | (i681118 ^ 16))) | iVD14832N67125) * (-184)))) - 1;
                                    int i691113 = ~iVD14832N67125;
                                    int i691114 = -(-((~((i691113 & (-17)) | ((-17) ^ i691113))) * 184));
                                    int i691115 = ((i681119 ^ i691114) + ((i691114 & i681119) << 1)) - 795555817;
                                    int i691116 = (i691115 << 13) ^ i691115;
                                    int i691117 = i691116 >>> 17;
                                    int i691118 = ((~i691116) & i691117) | ((~i691117) & i691116);
                                    int i691119 = i691118 << 5;
                                    ((int[]) objArr171119[0])[0] = ((~i691118) & i691119) | ((~i691119) & i691118);
                                    return objArr171119;
                                }
                            } catch (IOException unused6) {
                                bufferedInputStream2 = null;
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedInputStream = null;
                            }
                        } catch (Throwable th7) {
                            Throwable cause5 = th7.getCause();
                            if (cause5 != null) {
                                throw cause5;
                            }
                            throw th7;
                        }
                    }

                    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ Unit invoke() {
                        int iVD14832N6715 = qU20128.vD14832N6715();
                        int iVD14832N6716 = qU20128.vD14832N6715();
                        int iVD14832N6717 = qU20128.vD14832N6715();
                        ?? pivotYN16904 = setPivotYN16904(716786992, iVD14832N6716, qU20128.vD14832N6715(), iVD14832N6715, new Object[]{this}, -716786991, iVD14832N6717);
                        return pivotYN16904;
                    }

                    public final void component5() {
                        int iVD14832N6715 = qU20128.vD14832N6715();
                        int iVD14832N6716 = qU20128.vD14832N6715();
                        int iVD14832N6717 = qU20128.vD14832N6715();
                        setPivotYN16904(1266355863, iVD14832N6716, qU20128.vD14832N6715(), iVD14832N6715, new Object[]{this}, -1266355863, iVD14832N6717);
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(K5264 k5264) {
                        super(0);
                        this.$component9 = k5264;
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                private static /* synthetic */ Object component5(Object[] objArr3) throws Throwable {
                    AnonymousClass3 anonymousClass3 = (AnonymousClass3) objArr3[0];
                    Object obj = objArr3[1];
                    int i33 = 2 % 2;
                    int i34 = $setTopP6481;
                    int i35 = ((i34 | 95) << 1) - (i34 ^ 95);
                    $N14263A23323 = i35 % 128;
                    int i36 = i35 % 2;
                    rV4669 pivotYN16904 = ((unregisterForContextMenu) getYJ21310.component5(-657378901, 657378904, ak.AnonymousClass5.vD14832N6715(), new Object[]{getYJ21310.this}, ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715())).setPivotYN16904();
                    Object objD8871$7add70c7 = getYJ21310.D8871$7add70c7(getYJ21310.this);
                    C26423K21196 c26423k21196Component5 = ((component6.vD14832N6715) getYJ21310.component5(491797171, -491797169, ak.AnonymousClass5.vD14832N6715(), new Object[]{getYJ21310.this}, ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715())).setPivotYN16904(pivotYN16904).component5();
                    Map<String, Object> map2 = map;
                    String str2 = str;
                    Long lComponent10 = azVarD8871.component9();
                    Integer pivotYN16905 = null;
                    if (lComponent10 != null) {
                        int i37 = $N14263A23323;
                        int i38 = i37 & 83;
                        int i39 = (i37 ^ 83) | i38;
                        int i40 = (i38 ^ i39) + ((i39 & i38) << 1);
                        $setTopP6481 = i40 % 128;
                        if (i40 % 2 != 0) {
                            at.setPivotYN16904(lComponent10.longValue());
                            throw null;
                        }
                        pivotYN16905 = at.setPivotYN16904(lComponent10.longValue());
                        int i41 = $setTopP6481;
                        int i42 = (i41 & 44) + (i41 | 44);
                        int i43 = (i42 ^ (-1)) + (i42 << 1);
                        $N14263A23323 = i43 % 128;
                        int i44 = i43 % 2;
                    } else {
                        int i45 = $setTopP6481;
                        int i46 = ((i45 & (-14)) | ((~i45) & 13)) + ((i45 & 13) << 1);
                        $N14263A23323 = i46 % 128;
                        int i47 = i46 % 2;
                    }
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(k5264);
                    final K5264 k5265 = k5264;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.3.3
                        private static int $D8871 = 0;
                        private static int $setPivotYN16904 = 1;

                        public static /* synthetic */ Object D8871(int i48, int i49, int i50, Object[] objArr4, int i51, int i52, int i53) {
                            int i54 = (~(i53 | i49)) | i52;
                            int i55 = (~((~i49) | i53)) | i52;
                            int i56 = (~i52) | i53;
                            int i57 = i52 + i53 + i50 + (440753341 * i51) + ((-634449194) * i48);
                            int i58 = i57 * i57;
                            int i59 = ((-907101825) * i52) + 1075183616 + ((-1421434046) * i53) + (i54 * (-1603099839)) + ((-1603099839) * i55) + (1603099839 * i56) + (181665792 * i50) + (780402688 * i51) + ((-180879360) * i48) + (353763328 * i58);
                            int i60 = (i52 * 892202253) + 1676176333 + (i53 * 892200102) + (i54 * (-717)) + (i55 * (-717)) + (i56 * 717) + (i50 * 892200819) + (i51 * (-770690073)) + (i48 * 448958498) + (i58 * 1390542848);
                            if (i59 + (i60 * i60 * (-1042677760)) == 1) {
                                return component9(objArr4);
                            }
                            C01123 c01123 = (C01123) objArr4[0];
                            int i61 = 2 % 2;
                            int i62 = $setPivotYN16904;
                            int i63 = (i62 & 24) + (i62 | 24);
                            int i64 = (i63 ^ (-1)) + (i63 << 1);
                            $D8871 = i64 % 128;
                            int i65 = i64 % 2;
                            k5265.sG29839 = ax.D8871();
                            int i66 = $setPivotYN16904;
                            int i67 = i66 & 1;
                            int i68 = (i67 - (~((i66 ^ 1) | i67))) - 1;
                            $D8871 = i68 % 128;
                            int i69 = i68 % 2;
                            return null;
                        }

                        private static /* synthetic */ Object component9(Object[] objArr4) {
                            Unit unit;
                            C01123 c01123 = (C01123) objArr4[0];
                            int i48 = 2 % 2;
                            int i49 = $D8871;
                            int i50 = i49 ^ 5;
                            int i51 = ((i49 & 5) | i50) << 1;
                            int i52 = -i50;
                            int i53 = (i51 ^ i52) + ((i51 & i52) << 1);
                            $setPivotYN16904 = i53 % 128;
                            if (i53 % 2 == 0) {
                                int iComponent5 = pC2922Q7530.component5();
                                int iComponent6 = pC2922Q7530.component5();
                                int iComponent7 = pC2922Q7530.component5();
                                D8871(pC2922Q7530.component5(), iComponent5, iComponent6, new Object[]{c01123}, iComponent7, -660811592, 660811592);
                                unit = Unit.INSTANCE;
                                int i54 = 32 / 0;
                            } else {
                                int iComponent8 = pC2922Q7530.component5();
                                int iComponent9 = pC2922Q7530.component5();
                                int iComponent10 = pC2922Q7530.component5();
                                D8871(pC2922Q7530.component5(), iComponent8, iComponent9, new Object[]{c01123}, iComponent10, -660811592, 660811592);
                                unit = Unit.INSTANCE;
                            }
                            int i55 = $setPivotYN16904;
                            int i56 = (i55 & (-36)) | ((~i55) & 35);
                            int i57 = (i55 & 35) << 1;
                            int i58 = ((i56 | i57) << 1) - (i57 ^ i56);
                            $D8871 = i58 % 128;
                            int i59 = i58 % 2;
                            return unit;
                        }

                        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
                        @Override // kotlin.jvm.functions.Function0
                        public final /* synthetic */ Unit invoke() {
                            int iComponent5 = pC2922Q7530.component5();
                            int iComponent6 = pC2922Q7530.component5();
                            int iComponent7 = pC2922Q7530.component5();
                            ?? D8871 = D8871(pC2922Q7530.component5(), iComponent5, iComponent6, new Object[]{this}, iComponent7, 1580524975, -1580524974);
                            return D8871;
                        }

                        public final void vD14832N6715() {
                            int iComponent5 = pC2922Q7530.component5();
                            int iComponent6 = pC2922Q7530.component5();
                            int iComponent7 = pC2922Q7530.component5();
                            D8871(pC2922Q7530.component5(), iComponent5, iComponent6, new Object[]{this}, iComponent7, -660811592, 660811592);
                        }

                        {
                            super(0);
                        }
                    };
                    final K5264 k5266 = k5264;
                    try {
                        Object[] objArr4 = {c26423k21196Component5, map2, str2, pivotYN16905, anonymousClass1, function0, new Function1<Integer, Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.3.4
                            private static int $component9 = 0;
                            private static int $setPivotYN16904 = 1;

                            public static /* synthetic */ Object setPivotYN16904(int i48, int i49, int i50, int i51, int i52, int i53, Object[] objArr5) {
                                int i54 = ~i51;
                                int i55 = ~i50;
                                int i56 = (~(i54 | i55)) | i53;
                                int i57 = i55 | i53;
                                int i58 = (~((~i53) | i51)) | (~i57);
                                int i59 = (~(i50 | i54 | i53)) | (~(i57 | i51));
                                int i60 = i53 + i51 + i52 + (528639218 * i49) + ((-532493036) * i48);
                                int i61 = i60 * i60;
                                int i62 = ((i53 * 873666089) - 1460666368) + (873666089 * i51) + ((-875965520) * i56) + (437982760 * i58) + ((-437982760) * i59) + (435683328 * i52) + (1819279360 * i49) + ((-1621098496) * i48) + (586088448 * i61);
                                int i63 = (i53 * (-1573143961)) + 2078511484 + (i51 * (-1573143961)) + (i56 * 1872) + (i58 * (-936)) + (i59 * 936) + (i52 * (-1573143025)) + (i49 * 123045422) + (i48 * (-1548035028)) + (i61 * 1845559296);
                                if (i62 + (i63 * i63 * 1848705024) != 1) {
                                    return vD14832N6715(objArr5);
                                }
                                AnonymousClass4 anonymousClass4 = (AnonymousClass4) objArr5[0];
                                Object obj2 = objArr5[1];
                                int i64 = 2 % 2;
                                int i65 = $setPivotYN16904 + GapComposerKt.nodeKey;
                                $component9 = i65 % 128;
                                int i66 = i65 % 2;
                                Object[] objArr6 = {anonymousClass4, Integer.valueOf(((Number) obj2).intValue())};
                                setPivotYN16904(al.AnonymousClass1.D8871(), al.AnonymousClass1.D8871(), al.AnonymousClass1.D8871(), 961308021, al.AnonymousClass1.D8871(), -961308021, objArr6);
                                Unit unit = Unit.INSTANCE;
                                int i67 = $component9;
                                int i68 = (i67 & (-100)) | ((~i67) & 99);
                                int i69 = -(-((i67 & 99) << 1));
                                int i70 = (i68 & i69) + (i69 | i68);
                                $setPivotYN16904 = i70 % 128;
                                int i71 = i70 % 2;
                                return unit;
                            }

                            private static /* synthetic */ Object vD14832N6715(Object[] objArr5) {
                                AnonymousClass4 anonymousClass4 = (AnonymousClass4) objArr5[0];
                                int iIntValue = ((Number) objArr5[1]).intValue();
                                int i48 = 2 % 2;
                                int i49 = $component9 + 87;
                                $setPivotYN16904 = i49 % 128;
                                if (i49 % 2 != 0) {
                                    k5266.D8871 = iIntValue;
                                    k5266.component5 = ax.D8871();
                                    int i50 = $component9;
                                    int i51 = ((i50 ^ 87) | (i50 & 87)) << 1;
                                    int i52 = -(((~i50) & 87) | (i50 & (-88)));
                                    int i53 = (i51 ^ i52) + ((i52 & i51) << 1);
                                    $setPivotYN16904 = i53 % 128;
                                    if (i53 % 2 == 0) {
                                        int i54 = 70 / 0;
                                    }
                                    return null;
                                }
                                k5266.D8871 = iIntValue;
                                k5266.component5 = ax.D8871();
                                throw null;
                            }

                            /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
                            @Override // kotlin.jvm.functions.Function1
                            public final /* synthetic */ Unit invoke(Integer num2) {
                                int iD8871 = al.AnonymousClass1.D8871();
                                int iD8872 = al.AnonymousClass1.D8871();
                                int iD8873 = al.AnonymousClass1.D8871();
                                ?? pivotYN16906 = setPivotYN16904(al.AnonymousClass1.D8871(), iD8873, iD8871, 1703745530, iD8872, -1703745529, new Object[]{this, num2});
                                return pivotYN16906;
                            }

                            public final void vD14832N6715(int i48) {
                                Object[] objArr5 = {this, Integer.valueOf(i48)};
                                int iD8871 = al.AnonymousClass1.D8871();
                                int iD8872 = al.AnonymousClass1.D8871();
                                setPivotYN16904(al.AnonymousClass1.D8871(), al.AnonymousClass1.D8871(), iD8871, 961308021, iD8872, -961308021, objArr5);
                            }

                            {
                                super(1);
                            }
                        }, new AnonymousClass2(k5264)};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(755090286);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(57 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 114 - ExpandableListView.getPackedPositionChild(0L), 2142537485, false, "component5", new Class[]{C26423K21196.class, Map.class, String.class, Integer.class, Function0.class, Function0.class, Function1.class, Function1.class});
                        }
                        Object objInvoke = ((Method) objComponent5).invoke(objD8871$7add70c7, objArr4);
                        getYJ21310 getyj21311 = getYJ21310.this;
                        if (objInvoke instanceof setPivotYN16904) {
                            int i48 = $N14263A23323 + 39;
                            $setTopP6481 = i48 % 128;
                            int i49 = i48 % 2;
                            Error error = (Error) ((setPivotYN16904) objInvoke).setPivotYN16904;
                            ((setAutofillHintsI14457) getYJ21310.component5(1655693613, -1655693612, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21311}, ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715())).component9(obj, "Error: " + error.getDescription() + " Request ID: " + error.getRequestId());
                            int i50 = $N14263A23323 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            $setTopP6481 = i50 % 128;
                            int i51 = i50 % 2;
                        }
                        int i52 = $setTopP6481;
                        int i53 = i52 & 13;
                        int i54 = (((i52 ^ 13) | i53) << 1) - ((i52 | 13) & (~i53));
                        $N14263A23323 = i54 % 128;
                        int i55 = i54 % 2;
                        return objInvoke;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }

                /* JADX WARN: Type inference failed for: r7v1, types: [com.fingerprintjs.android.fpjs_pro_internal.D8871<? extends com.fingerprintjs.android.fpjs_pro.FingerprintJSProResponse, ? extends com.fingerprintjs.android.fpjs_pro.Error>, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ D8871<? extends FingerprintJSProResponse, ? extends Error> invoke(Object obj) {
                    int pivotYN16904 = H16981.setPivotYN16904();
                    ?? D8871 = D8871(1538378559, new Object[]{this, obj}, -1538378559, H16981.setPivotYN16904(), H16981.setPivotYN16904(), pivotYN16904, H16981.setPivotYN16904());
                    return D8871;
                }

                public final D8871<FingerprintJSProResponse, Error> component5$401f8b96(Object obj) {
                    int pivotYN16904 = H16981.setPivotYN16904();
                    return (D8871) D8871(-1684783905, new Object[]{this, obj}, 1684783906, H16981.setPivotYN16904(), H16981.setPivotYN16904(), pivotYN16904, H16981.setPivotYN16904());
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            }};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(50363158);
            if (objComponent5 == null) {
                int i33 = 51 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char cRed = (char) Color.red(0);
                int pressedStateDuration = 1077 - (ViewConfiguration.getPressedStateDuration() >> 16);
                Object[] objArr3 = new Object[1];
                a(0, (byte) 0, (byte) 0, objArr3);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i33, cRed, pressedStateDuration, 1370832757, false, (String) objArr3[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class});
            }
            Object obj = null;
            setPivotYN16904 setpivotyn16904 = (D8871) ((Method) objComponent5).invoke(null, objArr2);
            if (setpivotyn16904 instanceof vD14832N6715) {
                int i34 = component13 + 2;
                int i35 = (i34 ^ (-1)) + (i34 << 1);
                setTopP6481 = i35 % 128;
                if (i35 % 2 == 0) {
                    obj.hashCode();
                    throw null;
                }
            } else {
                if (!(setpivotyn16904 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                int i36 = setTopP6481;
                int i37 = i36 & 97;
                int i38 = (i36 ^ 97) | i37;
                int i39 = (i37 ^ i38) + ((i38 & i37) << 1);
                component13 = i39 % 128;
                int i40 = i39 % 2;
                Object obj2 = ((setPivotYN16904) setpivotyn16904).setPivotYN16904;
                if (((Class) setSystemGestureExclusionRectsL30479.component5(71 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (KeyEvent.normalizeMetaState(0) + 14757), 1297 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).isInstance(obj2)) {
                    unknownError = new ClientTimeout();
                    int i41 = setTopP6481;
                    int i42 = (((i41 | 86) << 1) - (i41 ^ 86)) - 1;
                    component13 = i42 % 128;
                    int i43 = i42 % 2;
                } else {
                    if (!((Class) setSystemGestureExclusionRectsL30479.component5(TextUtils.indexOf("", "", 0) + 68, (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 24093), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1368)).isInstance(obj2)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-563309519);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 1245 - TextUtils.getTrimmedLength(""), -1931882414, false, "component9", new Class[0]);
                    }
                    unknownError = new UnknownError(null == true ? 1 : 0, ((Method) objComponent6).invoke(obj2, null).toString(), 1, null == true ? 1 : 0);
                    int i44 = setTopP6481;
                    int i45 = (i44 ^ 101) + ((i44 & 101) << 1);
                    component13 = i45 % 128;
                    int i46 = i45 % 2;
                }
                setpivotyn16904 = new setPivotYN16904(unknownError);
                int i47 = setTopP6481;
                int i48 = ((i47 | 85) << 1) - (i47 ^ 85);
                component13 = i48 % 128;
                int i49 = i48 % 2;
            }
            final D8871 d8871Component9 = bb.component9(setpivotyn16904);
            k5264.N14263A23323 = ax.D8871();
            Object[] objArr4 = {new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getYJ21310.1
                private static int $component9 = 1;
                private static int $vD14832N6715;

                public static /* synthetic */ Object component5(int i50, int i51, int i52, int i53, Object[] objArr5, int i54, int i55) {
                    int i56 = ~i54;
                    int i57 = ~i55;
                    int i58 = ~(i56 | i57);
                    int i59 = ~(i54 | i55);
                    int i60 = i58 | i59 | (~(i54 | i52));
                    int i61 = i57 | i54;
                    int i62 = (~((~i52) | i54)) | i59;
                    int i63 = i54 + i55 + i53 + (111814883 * i51) + (1975835455 * i50);
                    int i64 = i63 * i63;
                    int i65 = (((-1960851331) * i54) - 1583611904) + (47848387 * i55) + (i60 * (-2101222338)) + ((-92522620) * i61) + ((-2101222338) * i62) + ((-2053373952) * i53) + ((-648806400) * i51) + (1432616960 * i50) + (442957824 * i64);
                    int i66 = ((i54 * 961080817) - 60187382) + (i55 * 961079119) + (i60 * 566) + (i61 * (-1132)) + (i62 * 566) + (i53 * 961079685) + (i51 * 1618335983) + (i50 * 193609403) + (i64 * 1988296704);
                    if (i65 + (i66 * i66 * 176226304) == 1) {
                        return component5(objArr5);
                    }
                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) objArr5[0];
                    int i67 = 2 % 2;
                    int i68 = $vD14832N6715;
                    int i69 = i68 & 33;
                    int i70 = (i68 | 33) & (~i69);
                    int i71 = i69 << 1;
                    int i72 = ((i70 | i71) << 1) - (i70 ^ i71);
                    $component9 = i72 % 128;
                    int i73 = i72 % 2;
                    int iVD14832N6715 = s.vD14832N6715();
                    int iVD14832N6716 = s.vD14832N6715();
                    component5(s.vD14832N6715(), s.vD14832N6715(), iVD14832N6715, iVD14832N6716, new Object[]{anonymousClass1}, -794136902, 794136903);
                    Unit unit = Unit.INSTANCE;
                    int i74 = $vD14832N6715;
                    int i75 = i74 & 69;
                    int i76 = (((i74 | 69) & (~i75)) - (~(-(-(i75 << 1))))) - 1;
                    $component9 = i76 % 128;
                    int i77 = i76 % 2;
                    return unit;
                }

                /* JADX WARN: Multi-variable type inference failed */
                private static /* synthetic */ Object component5(Object[] objArr5) {
                    String requestId;
                    String str2;
                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) objArr5[0];
                    int i50 = 2 % 2;
                    int i51 = $vD14832N6715;
                    int i52 = ((i51 ^ 80) + ((i51 & 80) << 1)) - 1;
                    int i53 = i52 % 128;
                    $component9 = i53;
                    int i54 = i52 % 2;
                    D8871<FingerprintJSProResponse, Error> d8871 = d8871Component9;
                    K5264 k5265 = k5264;
                    Object obj3 = null;
                    if (d8871 instanceof setPivotYN16904) {
                        int i55 = i53 & 5;
                        int i56 = (((i53 | 5) & (~i55)) - (~(i55 << 1))) - 1;
                        $vD14832N6715 = i56 % 128;
                        int i57 = i56 % 2;
                        Error error = (Error) ((setPivotYN16904) d8871).setPivotYN16904;
                        if (error instanceof ApiKeyExpired) {
                            int i58 = $vD14832N6715;
                            int i59 = (i58 ^ 45) + ((i58 & 45) << 1);
                            $component9 = i59 % 128;
                            if (i59 % 2 == 0) {
                                obj3.hashCode();
                                throw null;
                            }
                            str2 = "ApiKeyExpired";
                        } else if (error instanceof ApiKeyNotFound) {
                            int i60 = $vD14832N6715;
                            int i61 = ((i60 | 91) << 1) - (i60 ^ 91);
                            int i62 = i61 % 128;
                            $component9 = i62;
                            if (i61 % 2 == 0) {
                                throw null;
                            }
                            int i63 = i62 & 27;
                            int i64 = ((i62 ^ 27) | i63) << 1;
                            int i65 = -((i62 | 27) & (~i63));
                            int i66 = ((i64 | i65) << 1) - (i65 ^ i64);
                            $vD14832N6715 = i66 % 128;
                            int i67 = i66 % 2;
                            str2 = "ApiKeyNotFound";
                        } else if (error instanceof ApiKeyRequired) {
                            int i68 = $component9 + 79;
                            $vD14832N6715 = i68 % 128;
                            int i69 = i68 % 2;
                            str2 = "ApiKeyRequired";
                        } else if (error instanceof ClientTimeout) {
                            int i70 = $component9;
                            int i71 = ((i70 ^ 55) | (i70 & 55)) << 1;
                            int i72 = -(((~i70) & 55) | (i70 & (-56)));
                            int i73 = (i71 ^ i72) + ((i72 & i71) << 1);
                            $vD14832N6715 = i73 % 128;
                            if (i73 % 2 != 0) {
                                obj3.hashCode();
                                throw null;
                            }
                            str2 = "ClientTimeout";
                        } else if (error instanceof Failed) {
                            int i74 = $vD14832N6715;
                            int i75 = (((i74 | 80) << 1) - (i74 ^ 80)) - 1;
                            $component9 = i75 % 128;
                            if (i75 % 2 == 0) {
                                int i76 = 56 / 0;
                            }
                            str2 = "Failed";
                        } else if (error instanceof HeaderRestricted) {
                            int i77 = $component9 + 63;
                            int i78 = i77 % 128;
                            $vD14832N6715 = i78;
                            int i79 = i77 % 2;
                            int i80 = ((i78 | 41) << 1) - (i78 ^ 41);
                            $component9 = i80 % 128;
                            int i81 = i80 % 2;
                            str2 = "HeaderRestricted";
                        } else if (error instanceof InstallationMethodRestricted) {
                            int i82 = $vD14832N6715;
                            int i83 = i82 & 107;
                            int i84 = ((i82 | 107) & (~i83)) + (i83 << 1);
                            int i85 = i84 % 128;
                            $component9 = i85;
                            if (i84 % 2 == 0) {
                                throw null;
                            }
                            int i86 = (i85 & (-100)) | ((~i85) & 99);
                            int i87 = (i85 & 99) << 1;
                            int i88 = (i86 ^ i87) + ((i86 & i87) << 1);
                            $vD14832N6715 = i88 % 128;
                            int i89 = i88 % 2;
                            str2 = "InstallationMethodRestricted";
                        } else if (error instanceof NetworkError) {
                            int i90 = $component9;
                            int i91 = (((i90 | 74) << 1) - (i90 ^ 74)) - 1;
                            $vD14832N6715 = i91 % 128;
                            int i92 = i91 % 2;
                            int i93 = (i90 & 117) + (i90 | 117);
                            $vD14832N6715 = i93 % 128;
                            int i94 = i93 % 2;
                            str2 = "NetworkError";
                        } else if (error instanceof NotAvailableForCrawlBots) {
                            int i95 = $vD14832N6715;
                            int i96 = i95 + 19;
                            $component9 = i96 % 128;
                            int i97 = i96 % 2;
                            int i98 = (((i95 | 40) << 1) - (i95 ^ 40)) - 1;
                            $component9 = i98 % 128;
                            int i99 = i98 % 2;
                            str2 = "NotAvailableForCrawlBots";
                        } else if (error instanceof NotAvailableWithoutUA) {
                            int i100 = $vD14832N6715;
                            int i101 = (i100 & 75) + (i100 | 75);
                            int i102 = i101 % 128;
                            $component9 = i102;
                            int i103 = i101 % 2;
                            int i104 = i102 | 117;
                            int i105 = (i104 << 1) - ((~(i102 & 117)) & i104);
                            $vD14832N6715 = i105 % 128;
                            int i106 = i105 % 2;
                            str2 = "NotAvailableWithoutUA";
                        } else if (error instanceof OriginNotAvailable) {
                            int i107 = $vD14832N6715;
                            int i108 = (i107 ^ 99) + ((i107 & 99) << 1);
                            int i109 = i108 % 128;
                            $component9 = i109;
                            if (i108 % 2 == 0) {
                                obj3.hashCode();
                                throw null;
                            }
                            int i119 = i109 & 35;
                            int i120 = i119 + ((i109 ^ 35) | i119);
                            $vD14832N6715 = i120 % 128;
                            int i121 = i120 % 2;
                            str2 = "OriginNotAvailable";
                        } else if (error instanceof PackageNotAuthorized) {
                            int i122 = $vD14832N6715;
                            int i123 = i122 + 25;
                            $component9 = i123 % 128;
                            int i124 = i123 % 2;
                            int i125 = (i122 & 29) + (i122 | 29);
                            $component9 = i125 % 128;
                            if (i125 % 2 == 0) {
                                int i126 = 5 / 3;
                            }
                            str2 = "PackageNotAuthorized";
                        } else if (error instanceof RequestCannotBeParsed) {
                            int i127 = $component9;
                            int i128 = i127 & 49;
                            int i129 = -(-((i127 ^ 49) | i128));
                            int i130 = (i128 ^ i129) + ((i129 & i128) << 1);
                            $vD14832N6715 = i130 % 128;
                            int i131 = i130 % 2;
                            str2 = "RequestCannotBeParsed";
                        } else if (error instanceof RequestTimeout) {
                            int i132 = $vD14832N6715;
                            int i133 = ((i132 & 2) + (i132 | 2)) - 1;
                            $component9 = i133 % 128;
                            int i134 = i133 % 2;
                            str2 = "RequestTimeout";
                        } else if (error instanceof ResponseCannotBeParsed) {
                            int i135 = $component9;
                            int i136 = (i135 ^ 5) + ((i135 & 5) << 1);
                            $vD14832N6715 = i136 % 128;
                            int i137 = i136 % 2;
                            int i138 = i135 & 71;
                            int i139 = i138 + ((i135 ^ 71) | i138);
                            $vD14832N6715 = i139 % 128;
                            int i140 = i139 % 2;
                            str2 = "ResponseCannotBeParsed";
                        } else if (error instanceof SubscriptionNotActive) {
                            int i141 = $component9;
                            int i142 = ((i141 | 19) << 1) - (i141 ^ 19);
                            int i143 = i142 % 128;
                            $vD14832N6715 = i143;
                            int i144 = i142 % 2;
                            int i145 = i143 & 37;
                            int i146 = i145 + ((i143 ^ 37) | i145);
                            $component9 = i146 % 128;
                            int i147 = i146 % 2;
                            str2 = "SubscriptionNotActive";
                        } else if (error instanceof TooManyRequest) {
                            int i148 = $component9;
                            int i149 = i148 & 113;
                            int i150 = (((i148 | 113) & (~i149)) - (~(-(-(i149 << 1))))) - 1;
                            $vD14832N6715 = i150 % 128;
                            if (i150 % 2 != 0) {
                                int i151 = 71 / 0;
                            }
                            str2 = "TooManyRequest";
                        } else if (error instanceof UnknownError) {
                            int i152 = $component9;
                            int i153 = i152 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            int i154 = -(-(i152 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY));
                            int i155 = (i153 & i154) + (i154 | i153);
                            int i156 = i155 % 128;
                            $vD14832N6715 = i156;
                            int i157 = i155 % 2;
                            int i158 = (-2) - ((((i156 | 92) << 1) - (i156 ^ 92)) ^ (-1));
                            $component9 = i158 % 128;
                            int i159 = i158 % 2;
                            str2 = "UnknownError";
                        } else if (error instanceof UnsupportedVersion) {
                            int i160 = $component9;
                            int i161 = i160 & 17;
                            int i162 = (i160 ^ 17) | i161;
                            int i163 = (i161 & i162) + (i162 | i161);
                            $vD14832N6715 = i163 % 128;
                            if (i163 % 2 != 0) {
                                int i164 = 32 / 0;
                            }
                            str2 = "UnsupportedVersion";
                        } else if (error instanceof WrongRegion) {
                            int i165 = $component9;
                            int i166 = i165 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            int i167 = (i165 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) | i166;
                            int i168 = (i166 ^ i167) + ((i166 & i167) << 1);
                            $vD14832N6715 = i168 % 128;
                            int i169 = i168 % 2;
                            int i170 = ((i165 & 7) - (~(i165 | 7))) - 1;
                            $vD14832N6715 = i170 % 128;
                            int i171 = i170 % 2;
                            str2 = "WrongRegion";
                        } else if (error instanceof InvalidProxyIntegrationHeaders) {
                            int i172 = $component9;
                            int i173 = (i172 ^ 26) + ((i172 & 26) << 1);
                            int i174 = (i173 ^ (-1)) + (i173 << 1);
                            $vD14832N6715 = i174 % 128;
                            if (i174 % 2 != 0) {
                                obj3.hashCode();
                                throw null;
                            }
                            str2 = "InvalidProxyIntegrationHeaders";
                        } else if (error instanceof InvalidProxyIntegrationSecret) {
                            int i175 = $vD14832N6715;
                            int i176 = (-2) - (((i175 ^ 72) + ((i175 & 72) << 1)) ^ (-1));
                            $component9 = i176 % 128;
                            if (i176 % 2 == 0) {
                                obj3.hashCode();
                                throw null;
                            }
                            str2 = "InvalidProxyIntegrationSecret";
                        } else {
                            if (!(error instanceof ProxyIntegrationSecretEnvironmentMismatch)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            int i177 = $vD14832N6715;
                            int i178 = i177 + 23;
                            $component9 = i178 % 128;
                            int i179 = i178 % 2;
                            int i180 = (i177 & 75) + (i177 | 75);
                            $component9 = i180 % 128;
                            int i181 = i180 % 2;
                            str2 = "ProxyIntegrationSecretEnvironmentMismatch";
                        }
                        k5265.component9 = str2;
                        int i182 = $vD14832N6715;
                        int i183 = i182 & 13;
                        int i184 = ((i182 ^ 13) | i183) << 1;
                        int i185 = -((i182 | 13) & (~i183));
                        int i186 = ((i184 | i185) << 1) - (i185 ^ i184);
                        $component9 = i186 % 128;
                        if (i186 % 2 == 0) {
                            int i187 = 4 / 3;
                        }
                    }
                    K5264 k5266 = k5264;
                    D8871<FingerprintJSProResponse, Error> d8872 = d8871Component9;
                    if (d8872 instanceof vD14832N6715) {
                        int i188 = $vD14832N6715;
                        int i189 = (((i188 & (-58)) | ((~i188) & 57)) - (~((i188 & 57) << 1))) - 1;
                        $component9 = i189 % 128;
                        if (i189 % 2 == 0) {
                            requestId = ((FingerprintJSProResponse) ((vD14832N6715) d8872).setPivotYN16904).getRequestId();
                            int i190 = 12 / 0;
                        } else {
                            requestId = ((FingerprintJSProResponse) ((vD14832N6715) d8872).setPivotYN16904).getRequestId();
                        }
                        int i191 = $vD14832N6715;
                        int i192 = (i191 & 85) + (i191 | 85);
                        $component9 = i192 % 128;
                        int i193 = i192 % 2;
                    } else {
                        if (!(d8872 instanceof setPivotYN16904)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        int i194 = $vD14832N6715;
                        int i195 = i194 & 13;
                        int i196 = (i194 ^ 13) | i195;
                        int i197 = ((i195 | i196) << 1) - (i196 ^ i195);
                        $component9 = i197 % 128;
                        if (i197 % 2 == 0) {
                            ((Error) ((setPivotYN16904) d8872).setPivotYN16904).getRequestId();
                            obj3.hashCode();
                            throw null;
                        }
                        requestId = ((Error) ((setPivotYN16904) d8872).setPivotYN16904).getRequestId();
                    }
                    k5266.vD14832N6715 = requestId;
                    if (d8871Component9 instanceof vD14832N6715) {
                        int i198 = $component9;
                        int i199 = ((i198 & 21) - (~(i198 | 21))) - 1;
                        $vD14832N6715 = i199 % 128;
                        int i200 = i199 % 2;
                        ((getRightG17489) getYJ21310.component5(-1419473239, 1419473244, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715())).vD14832N6715();
                    }
                    ((getRightG17489) getYJ21310.component5(-1419473239, 1419473244, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715(), ak.AnonymousClass5.vD14832N6715())).component5(k5264);
                    return null;
                }

                /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() {
                    int iVD14832N6715 = s.vD14832N6715();
                    int iVD14832N6716 = s.vD14832N6715();
                    int iVD14832N6717 = s.vD14832N6715();
                    ?? Component5 = component5(s.vD14832N6715(), iVD14832N6717, iVD14832N6715, iVD14832N6716, new Object[]{this}, 1536471539, -1536471539);
                    return Component5;
                }

                public final void setPivotYN16904() {
                    int iVD14832N6715 = s.vD14832N6715();
                    int iVD14832N6716 = s.vD14832N6715();
                    int iVD14832N6717 = s.vD14832N6715();
                    component5(s.vD14832N6715(), iVD14832N6717, iVD14832N6715, iVD14832N6716, new Object[]{this}, -794136902, 794136903);
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }
            }};
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-234092262);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.getSize(0) + 51, (char) View.resolveSize(0, 0), 1488 - (ViewConfiguration.getFadingEdgeLength() >> 16), -1598468743, false, "setPivotYN16904", new Class[]{Function0.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
            int i50 = component13;
            int i51 = (i50 & (-68)) | ((~i50) & 67);
            int i52 = -(-((i50 & 67) << 1));
            int i53 = (i51 & i52) + (i52 | i51);
            setTopP6481 = i53 % 128;
            int i54 = i53 % 2;
            return d8871Component9;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int component9() {
        int i = component9;
        int i2 = i % 9843646;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyUid = Process.myUid();
        component5 = iMyUid;
        return iMyUid;
    }

    static {
        init$0();
        component13 = 0;
        setTopP6481 = 1;
    }

    public static final /* synthetic */ getRightG17489 component9(getYJ21310 getyj21310) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return (getRightG17489) component5(-1419473239, 1419473244, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }

    public static final /* synthetic */ setAutofillHintsI14457 component5(getYJ21310 getyj21310) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return (setAutofillHintsI14457) component5(1655693613, -1655693612, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }

    public static final /* synthetic */ component6.vD14832N6715 vD14832N6715(getYJ21310 getyj21310) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return (component6.vD14832N6715) component5(491797171, -491797169, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }

    public static final /* synthetic */ Object D8871$7add70c7(getYJ21310 getyj21310) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return component5(-2036963656, 2036963656, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }

    public static final /* synthetic */ unregisterForContextMenu setPivotYN16904(getYJ21310 getyj21310) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return (unregisterForContextMenu) component5(-657378901, 657378904, ak.AnonymousClass5.vD14832N6715(), new Object[]{getyj21310}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.getLeftK29400
    public final D8871<FingerprintJSProResponse, Error> component5(Long l, Integer num, Map<String, ? extends Object> map, String str) {
        int iVD14832N6715 = ak.AnonymousClass5.vD14832N6715();
        int iVD14832N6716 = ak.AnonymousClass5.vD14832N6715();
        return (D8871) component5(135526717, -135526713, ak.AnonymousClass5.vD14832N6715(), new Object[]{this, l, num, map, str}, ak.AnonymousClass5.vD14832N6715(), iVD14832N6716, iVD14832N6715);
    }
}
