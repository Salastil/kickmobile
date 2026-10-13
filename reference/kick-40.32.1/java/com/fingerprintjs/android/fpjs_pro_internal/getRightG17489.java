package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.media3.muxer.WebmConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public final class getRightG17489 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static long component5;
    private static int vD14832N6715;
    private final C1722 component9;

    private static String $$e(byte b, short s, short s2) {
        int i = b * 2;
        byte[] bArr = $$c;
        int i2 = 4 - (s2 * 3);
        int i3 = (s * 4) + 114;
        byte[] bArr2 = new byte[1 - i];
        int i4 = 0 - i;
        int i5 = -1;
        if (bArr == null) {
            i2++;
            i3 = i2 + i4;
        }
        while (true) {
            int i6 = i2;
            int i7 = i3;
            i5++;
            bArr2[i5] = (byte) i7;
            if (i5 == i4) {
                return new String(bArr2, 0);
            }
            i2 = i6 + 1;
            i3 = i7 + bArr[i6];
        }
    }

    private static void b(short s, short s2, int i, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = 25 - s2;
        int i3 = i + 68;
        byte[] bArr2 = new byte[s + 1];
        int i4 = -1;
        if (bArr == null) {
            i3 = (i3 + i2) - 5;
            i2++;
            i4 = -1;
        }
        while (true) {
            int i5 = i4 + 1;
            bArr2[i5] = (byte) i3;
            if (i5 == s) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i3;
            i3 = (i6 + bArr[i2]) - 5;
            i2++;
            i4 = i5;
        }
    }

    static void init$0() {
        $$a = new byte[]{44, -69, -1, 85, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9, -7, 5, 4, -1, 17, 6, Ascii.SO};
        $$b = WebmConstants.MkvEbmlElement.FLAG_DEFAULT;
    }

    static void init$1() {
        $$c = new byte[]{74, -125, 38, 125};
        $$d = 121;
    }

    public getRightG17489(C1722 c1722) {
        this.component9 = c1722;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489$component9;", "", "<init>", "()V", "component5", "Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489$component9$component5;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class component9 {
        private component9() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489$component9$component5;", "Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489$component9;", "<init>", "()V"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class component5 extends component9 {
            public static final component5 INSTANCE = new component5();

            private component5() {
                super(null);
            }
        }

        public /* synthetic */ component9(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final synchronized void component5(K5264 k5264) {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 17;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        vD14832N6715 vd14832n6715D8871 = D8871();
        if (vd14832n6715D8871 instanceof vD14832N6715) {
            vd14832n6715D8871 = new vD14832N6715(CollectionsKt.plus((Collection) ((vD14832N6715) vd14832n6715D8871).setPivotYN16904, (Iterable) CollectionsKt.listOf(k5264)));
        } else {
            if (!(vd14832n6715D8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            int i4 = vD14832N6715 + 59;
            D8871 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 87 / 0;
            }
            int i6 = 2 % 2;
        }
        if (!(vd14832n6715D8871 instanceof vD14832N6715)) {
            if (!(vd14832n6715D8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        int i7 = vD14832N6715 + 25;
        D8871 = i7 % 128;
        int i8 = i7 % 2;
        this.component9.D8871((List) ((vD14832N6715) vd14832n6715D8871).setPivotYN16904);
    }

    public final synchronized void vD14832N6715() {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 103;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        this.component9.D8871(CollectionsKt.emptyList());
        int i4 = D8871 + 93;
        vD14832N6715 = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized D8871<List<K5264>, component9> D8871() {
        int i = 2 % 2;
        int i2 = D8871 + 121;
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
        D8871 pivotYN16904 = this.component9.setPivotYN16904();
        if (!(pivotYN16904 instanceof vD14832N6715)) {
            if (!(pivotYN16904 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            return new setPivotYN16904(component9.component5.INSTANCE);
        }
        int i4 = vD14832N6715 + 3;
        int i5 = i4 % 128;
        D8871 = i5;
        int i6 = i4 % 2;
        int i7 = i5 + 41;
        vD14832N6715 = i7 % 128;
        if (i7 % 2 == 0) {
            return pivotYN16904;
        }
        throw null;
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2 % 2;
        int i3 = $10 + 113;
        int i4 = i3 % 128;
        $11 = i4;
        int i5 = i3 % 2;
        if (str != null) {
            int i6 = i4 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        cl clVar = new cl();
        char[] pivotYN16904 = cl.setPivotYN16904(component5 ^ (-8731904840774042312L), charArray, i);
        clVar.vD14832N6715 = 4;
        while (clVar.vD14832N6715 < pivotYN16904.length) {
            clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
            int i8 = clVar.vD14832N6715;
            try {
                Object[] objArr2 = {Long.valueOf(pivotYN16904[clVar.vD14832N6715] ^ pivotYN16904[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(component5)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(353813021);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715('c' - AndroidCharacter.getMirror('0'), (char) (ImageFormat.getBitsPerPixel(0) + 43653), 752 - Color.alpha(0), 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                pivotYN16904[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {clVar, clVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) (AndroidCharacter.getMirror('0') - '0'), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 5420, 257882757, false, $$e((byte) 0, (short) 0, (short) 0), new Class[]{Object.class, Object.class});
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
        String str2 = new String(pivotYN16904, 4, pivotYN16904.length - 4);
        int i9 = $11 + 51;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        objArr[0] = str2;
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        vD14832N6715 = 0;
        D8871 = 1;
        component5 = 8854519723456323709L;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:36:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:38:0x0486 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0487  */
    public static Object[] D8871(Context context, int i, int i2, int i3) throws Throwable {
        char c;
        Object[] objArr;
        Object[] objArr2;
        int i4;
        boolean zEquals;
        int i5 = 2 % 2;
        int i6 = vD14832N6715;
        int i7 = (i6 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i6 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        D8871 = i7 % 128;
        int i8 = i7 % 2;
        Object obj = null;
        if (context == null) {
            Object[] objArr3 = {new int[]{i}, null, new int[]{i}, new int[]{((~i) & i) | ((~i) & i)}};
            int i9 = ~((-120204967) | (~i));
            int i10 = ((((1757511745 | i9) | (~(120204966 | i))) * (-338)) - 1050078401) + (((~(i | 1877716711)) | i9) * 338);
            int i11 = (i3 ^ i10) + ((i3 & i10) << 1);
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 >>> 17;
            int i14 = ((~i12) & i13) | ((~i13) & i12);
            int i15 = i14 << 5;
            return objArr3;
        }
        int i16 = i6 + 51;
        int i17 = i16 % 128;
        D8871 = i17;
        if (i16 % 2 == 0) {
            int i18 = 4 % 4;
        }
        int i19 = (i17 & 15) + (i17 | 15);
        vD14832N6715 = i19 % 128;
        int i20 = i19 % 2;
        try {
            Object[] objArr4 = new Object[1];
            a("퉎툯䩛靰榗朥퍹ꜵ\uf098ᡫﲃﱕ㠅赙瞥焛贗皴쫋\u07bdٝﮡ巍鳳魏沊탣", 0 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            int i21 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
            int i22 = ((i21 | 1) << 1) - (i21 ^ 1);
            Object[] objArr5 = new Object[1];
            a("뺉뻮쪒ឲ뭚쩁Ƥ쯭巏颻⹖充哂ඞꕢ\udc51\ue1da\uf67dᠫꪪ檿筨", i22, objArr5);
            Object objInvoke = cls.getMethod((String) objArr5[0], null).invoke(context, null);
            Object[] objArr6 = new Object[1];
            a("Ṝḽ侟銴㳲⋤蘜欧땙ᶯꧦ릔\uf417袝⋀㓚䄅獰龮䉼쩼\ufe67ࣨ\ud907坈楆薞吃ꁇ푃ｪ\ue377\u2dbf张桃繬뚚쨕", -Process.getGidForName(""), objArr6);
            Class<?> cls2 = Class.forName((String) objArr6[0]);
            int iBlue = Color.blue(0);
            int iComponent9 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
            int i23 = iBlue * 860;
            int i24 = (i23 & (-858)) + (i23 | (-858));
            int i25 = ((iBlue ^ iComponent9) | (iBlue & iComponent9)) * (-859);
            int i26 = (i24 ^ i25) + ((i25 & i24) << 1);
            int i27 = ~iComponent9;
            int i28 = ~((i27 & iBlue) | (i27 ^ iBlue));
            int i29 = (~iBlue) | (-2);
            int i30 = ~((i29 ^ iComponent9) | (i29 & iComponent9));
            int i31 = ((i28 ^ i30) | (i28 & i30)) * 859;
            int i32 = ~((-2) | (~iComponent9));
            int i33 = ~(((-2) & iBlue) | ((-2) ^ iBlue));
            int i34 = (i26 & i31) + (i31 | i26) + (((i33 & i32) | (i32 ^ i33)) * 859);
            Object[] objArr7 = new Object[1];
            a("좴죒⯮\uf6c7㶲娓蝙뷓춻", i34, objArr7);
            if ((cls2.getField((String) objArr7[0]).getInt(objInvoke) & 2) != 0) {
                int i35 = D8871;
                int i36 = (i35 ^ 89) + ((i35 & 89) << 1);
                vD14832N6715 = i36 % 128;
                int i37 = i36 % 2;
                int i38 = ~i;
                int i39 = ~i;
                getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                objArr = new Object[]{new int[]{i}, null, new int[]{i ^ 1}, new int[]{(i | i) & (~(i & i))}};
                c = 2;
                int i40 = 1086953326 + (((~((-1424122948) | i)) | (~((-487282987) | i39))) * JfifUtil.MARKER_EOI) + (((~((-487282987) | i)) | 335691778) * JfifUtil.MARKER_EOI) + (((~((-1424122948) | i39)) | 487282986) * JfifUtil.MARKER_EOI) + 16;
                int i41 = ((i40 * 960) - (~(-(-(i3 * (-1917)))))) - 1;
                int i42 = ~i3;
                int i43 = ~((i42 ^ i38) | (i42 & i38));
                int i44 = ~((i40 ^ i) | (i40 & i));
                int i45 = -(-(((i43 ^ i44) | (i43 & i44)) * 959));
                int i46 = (i41 ^ i45) + ((i41 & i45) << 1);
                int i47 = (~i3) * (-959);
                int i48 = (i46 & i47) + (i47 | i46);
                int i49 = ~(i42 | i);
                int i50 = ~((i38 & i40) | (i38 ^ i40));
                int i51 = (i48 - (~(-(-(((i50 & i49) | (i49 ^ i50)) * 959))))) - 1;
                int i52 = i51 << 13;
                int i53 = (i52 & (~i51)) | ((~i52) & i51);
                int i54 = i53 >>> 17;
                int i55 = ((~i53) & i54) | ((~i54) & i53);
                int i56 = i55 << 5;
            } else {
                c = 2;
                objArr = new Object[]{new int[]{i}, null, new int[]{i}, new int[1]};
                int i57 = ~i;
                int i58 = ((1698426248 + (((-8980618) | i) * (-381))) + (((~(1062515826 | i57)) | (-231586954)) * 381)) - 873352219;
                int iComponent10 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                int i59 = -(-(i58 * (-864)));
                int i60 = ~i58;
                int i61 = ~iComponent10;
                int i62 = i60 * (-865);
                int i63 = ((((i59 | i62) << 1) - (i59 ^ i62)) - (~(-(-((~iComponent10) * 865))))) - 1;
                int i64 = ~i58;
                int i65 = ~iComponent10;
                int i66 = ~((i64 & i65) | (i64 ^ i65));
                int i67 = ~i61;
                int i68 = i63 + (((i66 & i67) | (i66 ^ i67)) * 865);
                int i69 = ((i68 * 829) - (~(-(-(i3 * 829))))) - 1;
                int i70 = ~((~i68) | (~i3));
                int i71 = (~i) | i68;
                int i72 = ~((i71 & i3) | (i71 ^ i3));
                int i73 = ((i70 & i72) | (i70 ^ i72)) * (-828);
                int i74 = ((i69 | i73) << 1) - (i69 ^ i73);
                int i75 = (i68 ^ i3) | (i68 & i3);
                int i76 = ((i57 & i75) | (i75 ^ i57)) * (-828);
                int i77 = (((i74 & i76) + (i76 | i74)) - (~((~i75) * 828))) - 1;
                int i78 = i77 << 13;
                int i79 = (i78 & (~i77)) | ((~i78) & i77);
                int i80 = i79 ^ (i79 >>> 17);
                ((int[]) objArr[3])[0] = i80 ^ (i80 << 5);
                int i81 = D8871 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                vD14832N6715 = i81 % 128;
                int i82 = i81 % 2;
            }
            if (((int[]) objArr[c])[0] != i) {
                return objArr;
            }
            try {
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1185383580);
                if (objComponent5 == null) {
                    int iIndexOf = 51 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char bitsPerPixel = (char) (34441 - ImageFormat.getBitsPerPixel(0));
                    int modifierMetaStateMask = 5523 - ((byte) KeyEvent.getModifierMetaStateMask());
                    byte[] bArr = $$a;
                    Object[] objArr8 = new Object[1];
                    b(bArr[24], (byte) (bArr[5] + 1), 47, objArr8);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, bitsPerPixel, modifierMetaStateMask, -336773369, false, (String) objArr8[0], new Class[0]);
                }
                Set set = (Set) ((Method) objComponent5).invoke(null, null);
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1204470180);
                if (objComponent6 == null) {
                    int modifierMetaStateMask2 = 51 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char cIndexOf = (char) (TextUtils.indexOf("", "") + 34442);
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 5524;
                    byte[] bArr2 = $$a;
                    Object[] objArr9 = new Object[1];
                    b(bArr2[20], (byte) (-bArr2[18]), (byte) (bArr2[c] + 1), objArr9);
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(modifierMetaStateMask2, cIndexOf, packedPositionGroup, 360678855, false, (String) objArr9[0], null);
                }
                if (!set.contains(((Field) objComponent6).get(null))) {
                    int i83 = vD14832N6715;
                    int i84 = (i83 ^ 123) + ((i83 & 123) << 1);
                    D8871 = i84 % 128;
                    int i85 = i84 % 2;
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-986694391);
                    if (objComponent7 == null) {
                        int threadPriority = 52 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char c2 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34441);
                        int i86 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 5523;
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        b(bArr3[24], (byte) (bArr3[5] + 1), 47, objArr10);
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority, c2, i86, -1752860310, false, (String) objArr10[0], null);
                    }
                    if (set.contains(((Field) objComponent7).get(null))) {
                        if (Build.VERSION.SDK_INT == 30) {
                            int i87 = D8871;
                            int i88 = ((i87 | 95) << 1) - (i87 ^ 95);
                            vD14832N6715 = i88 % 128;
                            int i89 = i88 % 2;
                            objArr2 = new Object[4];
                            objArr2[0] = new int[]{i};
                            objArr2[c] = new int[]{i};
                            objArr2[r6] = new int[1];
                            objArr2[1] = null;
                            int i90 = ~((int) SystemClock.uptimeMillis());
                            int i91 = 1478769682 + (((~((-601009720) | i90)) | (-1310396215)) * (-933)) + (((~(i90 | (-1310396215))) | 1275658496) * 933) + 1415211240;
                            int iComponent11 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                            int i92 = ((i91 * 984) - (~(-(-((~i91) * 983))))) - 1;
                            int i93 = ~iComponent11;
                            int i94 = (i92 & 983) + (i92 | 983);
                            int i95 = (~(i93 | ((-1) ^ i93))) * 983;
                            int i96 = (i94 & i95) + (i95 | i94);
                            int iComponent12 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                            int i97 = i96 * (-433);
                            int i98 = i3 * (-216);
                            int i99 = (i97 & i98) + (i97 | i98);
                            int i100 = ~i96;
                            int i101 = ~iComponent12;
                            int i102 = ~((i101 & i100) | (i100 ^ i101));
                            int i103 = ~i3;
                            int i104 = ~((i103 ^ iComponent12) | (i103 & iComponent12));
                            int i105 = i99 + (((i102 & i104) | (i102 ^ i104)) * JfifUtil.MARKER_EOI);
                            int i106 = ~i96;
                            int i107 = ~i3;
                            int i108 = ~((i107 & i106) | (i106 ^ i107));
                            int i109 = ~((i100 & iComponent12) | (i100 ^ iComponent12));
                            int i110 = i105 + (((i108 & i109) | (i108 ^ i109)) * JfifUtil.MARKER_EOI);
                            int i111 = ~((~iComponent12) | i103);
                            int i112 = ((i111 & i96) | (i96 ^ i111)) * JfifUtil.MARKER_EOI;
                            int i113 = (i110 & i112) + (i112 | i110);
                            int i114 = i113 << 13;
                            int i115 = (i114 & (~i113)) | ((~i114) & i113);
                            int i116 = i115 >>> 17;
                            int i117 = ((~i115) & i116) | ((~i116) & i115);
                            ((int[]) objArr2[r6])[0] = i117 ^ (i117 << 5);
                            i4 = vD14832N6715 + 35;
                            D8871 = i4 % 128;
                            if (i4 % 2 != 0) {
                                return objArr2;
                            }
                            throw null;
                        }
                    }
                } else if (Build.VERSION.SDK_INT == 30) {
                    int i810 = D8871;
                    int i811 = ((i810 | 95) << 1) - (i810 ^ 95);
                    vD14832N6715 = i811 % 128;
                    int i812 = i811 % 2;
                    objArr2 = new Object[4];
                    objArr2[0] = new int[]{i};
                    objArr2[c] = new int[]{i};
                    objArr2[r6] = new int[1];
                    objArr2[1] = null;
                    int i910 = ~((int) SystemClock.uptimeMillis());
                    int i911 = 1478769682 + (((~((-601009720) | i910)) | (-1310396215)) * (-933)) + (((~(i910 | (-1310396215))) | 1275658496) * 933) + 1415211240;
                    int iComponent13 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                    int i912 = ((i911 * 984) - (~(-(-((~i911) * 983))))) - 1;
                    int i913 = ~iComponent13;
                    int i914 = (i912 & 983) + (i912 | 983);
                    int i915 = (~(i913 | ((-1) ^ i913))) * 983;
                    int i916 = (i914 & i915) + (i915 | i914);
                    int iComponent14 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                    int i917 = i916 * (-433);
                    int i918 = i3 * (-216);
                    int i919 = (i917 & i918) + (i917 | i918);
                    int i1010 = ~i916;
                    int i1011 = ~iComponent14;
                    int i1012 = ~((i1011 & i1010) | (i1010 ^ i1011));
                    int i1013 = ~i3;
                    int i1014 = ~((i1013 ^ iComponent14) | (i1013 & iComponent14));
                    int i1015 = i919 + (((i1012 & i1014) | (i1012 ^ i1014)) * JfifUtil.MARKER_EOI);
                    int i1016 = ~i916;
                    int i1017 = ~i3;
                    int i1018 = ~((i1017 & i1016) | (i1016 ^ i1017));
                    int i1019 = ~((i1010 & iComponent14) | (i1010 ^ iComponent14));
                    int i118 = i1015 + (((i1018 & i1019) | (i1018 ^ i1019)) * JfifUtil.MARKER_EOI);
                    int i119 = ~((~iComponent14) | i1013);
                    int i1110 = ((i119 & i916) | (i916 ^ i119)) * JfifUtil.MARKER_EOI;
                    int i1111 = (i118 & i1110) + (i1110 | i118);
                    int i1112 = i1111 << 13;
                    int i1113 = (i1112 & (~i1111)) | ((~i1112) & i1111);
                    int i1114 = i1113 >>> 17;
                    int i1115 = ((~i1113) & i1114) | ((~i1114) & i1113);
                    ((int[]) objArr2[r6])[0] = i1115 ^ (i1115 << 5);
                    i4 = vD14832N6715 + 35;
                    D8871 = i4 % 128;
                    if (i4 % 2 != 0) {
                        return objArr2;
                    }
                    throw null;
                }
                if ((i2 & 32) == 0) {
                    try {
                        if (Build.VERSION.SDK_INT > 33) {
                            int i120 = -TextUtils.getCapsMode("", 0, 0);
                            int i121 = ((i120 | 1) << 1) - (i120 ^ 1);
                            Object[] objArr11 = new Object[1];
                            a("༇༨溭뎍⯋㶤鄵稼ꨈ㲝뻅Ꚃ\ue55bꧯ㗫⮓偐剈裞嵧\udcb5aᾚ왰䘄䡥銹䭗넚\uf53e\ue845ﰬ", i121, objArr11);
                            try {
                                Object[] objArr12 = {(String) objArr11[0]};
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                if (objComponent8 == null) {
                                    int i122 = 53 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                    char c3 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 59724);
                                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 6317;
                                    byte[] bArr4 = $$a;
                                    byte b = (byte) (bArr4[20] - 1);
                                    Object[] objArr13 = new Object[1];
                                    b(b, b, (byte) (-bArr4[6]), objArr13);
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i122, c3, windowTouchSlop, 1385817144, false, (String) objArr13[0], new Class[]{String.class});
                                }
                                long jLongValue = ((Long) ((Method) objComponent8).invoke(null, objArr12)).longValue();
                                long j = i;
                                long j2 = j ^ (-1);
                                long j3 = jLongValue ^ (-1);
                                long j4 = (-132424729965L) + ((-163) * jLongValue) + ((-328) * ((-802574121) | ((j2 | jLongValue) ^ (-1)))) + (((-802574121) | j) * 164) + (164 * ((((j2 | (-802574121)) | jLongValue) ^ (-1)) | ((802574120 | j3) ^ (-1)) | ((j3 | j) ^ (-1)))) + 1207154027;
                                int i123 = ((int) (j4 >> 32)) & (642511362 + (((~((-2128795677) | i)) | 1417676804) * (-140)) + ((~((-711118873) | i)) * 70) + (((~((-728945209) | i)) | 1435503140) * 70));
                                int i124 = (int) j4;
                                int iMyTid = Process.myTid();
                                int i125 = ~iMyTid;
                                int i126 = i124 & (2055568080 + (((~((-1766071842) | i125)) | 1091669044) * 226) + (((~(i125 | (-675549698))) | (~((-1091669045) | iMyTid)) | 1146900) * (-113)) + ((~(iMyTid | (-1766071842))) * 113));
                                if (((i123 & i126) | (i123 ^ i126)) == 1) {
                                    int i127 = vD14832N6715;
                                    int i128 = (i127 & 33) + (i127 | 33);
                                    D8871 = i128 % 128;
                                    int i129 = i128 % 2;
                                    zEquals = true;
                                } else {
                                    zEquals = false;
                                }
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause != null) {
                                    throw cause;
                                }
                                throw th;
                            }
                        } else {
                            int i130 = -ExpandableListView.getPackedPositionType(0L);
                            int i131 = (i130 ^ 1) + ((i130 & 1) << 1);
                            Object[] objArr14 = new Object[1];
                            a("줠쥒\uf6d0⯺鸾锨⒚뱑ʃꓫୱง⍯㇜聊茘陹", i131, objArr14);
                            try {
                                Object[] objArr15 = {(String) objArr14[0]};
                                Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                if (objComponent9 == null) {
                                    int iIndexOf2 = 52 - TextUtils.indexOf("", "");
                                    char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                                    int i132 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 6472;
                                    byte b2 = (byte) ($$a[c] + 1);
                                    byte b3 = b2;
                                    Object[] objArr16 = new Object[1];
                                    b(b2, b3, (byte) (b3 | Ascii.GS), objArr16);
                                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf2, cIndexOf2, i132, 1068791596, false, (String) objArr16[0], new Class[]{String.class});
                                }
                                Object objInvoke2 = ((Method) objComponent9).invoke(null, objArr15);
                                int i133 = -KeyEvent.getDeadChar(0, 0);
                                int i134 = ((i133 | 1) << 1) - (i133 ^ 1);
                                Object[] objArr17 = new Object[1];
                                a("ﬔﬥ᪭\ue2db酞", i134, objArr17);
                                zEquals = objInvoke2.equals((String) objArr17[0]);
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 != null) {
                                    throw cause2;
                                }
                                throw th2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (zEquals) {
                        int i135 = (~(i & 10)) & (i | 10);
                        Object[] objArr18 = new Object[4];
                        objArr18[0] = new int[]{i};
                        objArr18[c] = new int[]{i135};
                        objArr18[r6] = new int[1];
                        objArr18[1] = null;
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i136 = (((-946778819) + (((~((-605048526) | iMaxMemory)) | 68177536) * 1504)) + ((~(iMaxMemory | (-536870990))) * (-1504))) - 896581584;
                        int iComponent15 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                        int i137 = i136 * (-721);
                        int i138 = ((-11536) & i137) + (i137 | (-11536));
                        int i139 = ~iComponent15;
                        int i140 = ~((-17) | (~i136));
                        int i141 = (i139 & i140) | (i139 ^ i140);
                        int i142 = ~((i136 ^ 16) | (i136 & 16));
                        int i143 = -(-((i141 | i142) * 1444));
                        int i144 = (i138 ^ i143) + ((i143 & i138) << 1);
                        int i145 = ~(iComponent15 | 16);
                        int i146 = (i145 & i142) | (i142 ^ i145);
                        int i147 = ~(iComponent15 | i136);
                        int i148 = ((i147 & i146) | (i146 ^ i147)) * (-1444);
                        int i149 = (i144 ^ i148) + ((i148 & i144) << 1);
                        int i150 = ((~(((-17) & i136) | ((-17) ^ i136))) | (~((~i136) | 16))) * 722;
                        int i151 = ((i149 | i150) << 1) - (i150 ^ i149);
                        int iComponent16 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                        int i152 = (i151 * (-665)) + (i3 * 334);
                        int i153 = ~i151;
                        int i154 = i152 + (i153 * (-333));
                        int i155 = ~iComponent16;
                        int i156 = ((~((i155 & i153) | (i153 ^ i155))) | (~((i3 ^ iComponent16) | (i3 & iComponent16)))) * 333;
                        int i157 = ((i154 | i156) << 1) - (i154 ^ i156);
                        int i158 = ~((i153 ^ iComponent16) | (i153 & iComponent16));
                        int i159 = ~iComponent16;
                        int i160 = ~((i159 & i3) | (i159 ^ i3));
                        int i161 = (i157 - (~(-(-(((i160 & i158) | (i158 ^ i160)) * 333))))) - 1;
                        int i162 = (i161 << 13) ^ i161;
                        int i163 = i162 >>> 17;
                        int i164 = (i162 | i163) & (~(i162 & i163));
                        ((int[]) objArr18[r6])[0] = i164 ^ (i164 << 5);
                        int i165 = vD14832N6715;
                        int i166 = (i165 ^ 7) + ((i165 & 7) << 1);
                        D8871 = i166 % 128;
                        if (i166 % 2 != 0) {
                            return objArr18;
                        }
                        obj.hashCode();
                        throw null;
                    }
                }
                Object[] objArr19 = new Object[4];
                objArr19[0] = new int[]{i};
                objArr19[c] = new int[]{i};
                objArr19[r6] = new int[1];
                objArr19[1] = null;
                int i167 = ~i;
                int i168 = (-960880092) + (((~((-1845529340) | i167)) | (~(1877850875 | i))) * (-831)) + ((~((-1811974282) | i)) * (-1662)) + (((~(i | 1845529339)) | (~(i167 | (-65876595))) | (~(65876594 | i))) * 831);
                int i169 = (i168 << 1) - i168;
                int iComponent17 = getYJ21310.AnonymousClass3.AnonymousClass2.component9();
                int i170 = i169 * 284;
                int i171 = -(-(i3 * (-282)));
                int i172 = (i170 ^ i171) + ((i170 & i171) << 1);
                int i173 = ~i169;
                int i174 = ~((i173 ^ i3) | (i173 & i3));
                int i175 = ~((~i169) | iComponent17);
                int i176 = (i172 - (~(((i174 & i175) | (i174 ^ i175)) * (-283)))) - 1;
                int i177 = ~i3;
                int i178 = -(-((~((i169 & i177) | (i177 ^ i169))) * 283));
                int i179 = (i176 ^ i178) + ((i178 & i176) << 1);
                int i180 = i173 | i177;
                int i181 = (~((i180 & iComponent17) | (i180 ^ iComponent17))) * 283;
                int i182 = (i179 & i181) + (i181 | i179);
                int i183 = i182 << 13;
                int i184 = (i183 | i182) & (~(i182 & i183));
                int i185 = i184 >>> 17;
                int i186 = (i184 | i185) & (~(i184 & i185));
                ((int[]) objArr19[3])[0] = i186 ^ (i186 << 5);
                return objArr19;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 != null) {
                throw cause4;
            }
            throw th4;
        }
    }
}
