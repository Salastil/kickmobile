package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.ContentResolver;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.datadog.reactnative.ProxyAuthenticator;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class copy implements setOnClickListenerO2383 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int component5;
    public static int component9;
    public static int setPivotYN16904;
    private static int vD14832N6715;
    private final ContentResolver D8871;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r0 = r7 + 10
            int r6 = r6 * 3
            int r6 = 99 - r6
            int r8 = r8 + 4
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.copy.$$a
            byte[] r0 = new byte[r0]
            int r7 = r7 + 9
            r2 = 0
            if (r1 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2e
        L16:
            r3 = r2
        L17:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2e:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-25)
            r8 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.copy.a(short, int, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{50, -51, -76, 65, -37, -23, -28, -24, -24, -16, -34, -31, 34, -37, -23, -28, -24, -24, -16, -34, -31, 38};
        $$b = 20;
    }

    public copy(ContentResolver contentResolver) {
        this.D8871 = contentResolver;
    }

    public static final /* synthetic */ ContentResolver component9(copy copyVar) {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = ((i2 | 1) << 1) - (i2 ^ 1);
        component5 = i3 % 128;
        int i4 = i3 % 2;
        ContentResolver contentResolver = copyVar.D8871;
        if (i4 != 0) {
            int i5 = 14 / 0;
        }
        return contentResolver;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.setOnClickListenerO2383
    public final String setPivotYN16904() throws Throwable {
        Object objInvoke;
        int i = 2 % 2;
        int i2 = vD14832N6715 + 19;
        component5 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                Object[] objArr = {0L, false, false, new Function1<Object, String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.copy.1
                    private static int $D8871 = 1;
                    private static int $component5 = 1;
                    private static int $component9;
                    private static int $vD14832N6715;

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ String invoke(Object obj) {
                        int i3 = 2 % 2;
                        int i4 = $component5;
                        int i5 = ((i4 | 21) << 1) - (i4 ^ 21);
                        $vD14832N6715 = i5 % 128;
                        int i6 = i5 % 2;
                        String strVD14832N6715$444b71f3 = vD14832N6715$444b71f3(obj);
                        int i7 = $component5;
                        int i8 = ((i7 | 103) << 1) - (i7 ^ 103);
                        $vD14832N6715 = i8 % 128;
                        if (i8 % 2 == 0) {
                            return strVD14832N6715$444b71f3;
                        }
                        throw null;
                    }

                    public final String vD14832N6715$444b71f3(Object obj) {
                        int i3 = 2 % 2;
                        int i4 = $vD14832N6715;
                        int i5 = (i4 ^ 69) + ((i4 & 69) << 1);
                        $component5 = i5 % 128;
                        int i6 = i5 % 2;
                        TimeZone timeZone = TimeZone.getDefault();
                        Intrinsics.checkNotNull(timeZone);
                        String id = timeZone.getID();
                        Intrinsics.checkNotNull(id);
                        int pivotYN16904 = setOnLongClickListenerR17701.setPivotYN16904();
                        int i7 = ~(388166295 | pivotYN16904);
                        int i8 = ~((388166295 & pivotYN16904) | (388166295 ^ pivotYN16904));
                        int i9 = ~pivotYN16904;
                        int i10 = ((((-299632652) + (((i7 & 1082983752) | (1082983752 ^ i7)) * 992)) + ((((i8 & 1082983752) | (1082983752 ^ i8)) | (~(((i9 & (-388166296)) | (i9 ^ (-388166296))) | 1152321356))) * (-496))) - (~(((pivotYN16904 & 1152321356) | (1152321356 ^ pivotYN16904)) * 496))) - 1;
                        int pivotYN16905 = setOnLongClickListenerR17701.setPivotYN16904();
                        int i11 = ~((696282421 ^ pivotYN16905) | (696282421 & pivotYN16905));
                        int i12 = ((i11 & (-1875308406)) | ((-1875308406) ^ i11)) * (-814);
                        int i13 = ((-826860129) & i12) + (i12 | (-826860129));
                        int i14 = ~pivotYN16905;
                        int i15 = ~((i14 & 1204194133) | (1204194133 ^ i14));
                        int i16 = (i15 & 25168149) | (i15 ^ 25168149);
                        int i17 = ~(696282421 | pivotYN16905);
                        int i18 = i13 + (((i17 & i16) | (i16 ^ i17)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE);
                        int i19 = ~(((-696282422) & pivotYN16905) | ((-696282422) ^ pivotYN16905));
                        int i20 = -(-(((~((pivotYN16905 & (-1204194134)) | ((-1204194134) ^ pivotYN16905))) | (i19 & 25168149) | (25168149 ^ i19)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                        if (i10 <= (i18 ^ i20) + ((i20 & i18) << 1)) {
                            int i21 = 67 / 0;
                        }
                        return id;
                    }

                    static {
                        int i3 = $D8871;
                        int i4 = (i3 ^ 95) + ((i3 & 95) << 1);
                        $component9 = i4 % 128;
                        int i5 = i4 % 2;
                    }
                }, 84, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
                if (objComponent5 == null) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 52;
                    char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                    int i3 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1076;
                    Object[] objArr2 = new Object[1];
                    a((short) 0, 0, (short) -1, objArr2);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(bitsPerPixel, threadPriority, i3, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent5).invoke(null, objArr);
            } else {
                Object[] objArr3 = {0L, false, false, new Function1<Object, String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.copy.1
                    private static int $D8871 = 1;
                    private static int $component5 = 1;
                    private static int $component9;
                    private static int $vD14832N6715;

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ String invoke(Object obj) {
                        int i4 = 2 % 2;
                        int i5 = $component5;
                        int i6 = ((i5 | 21) << 1) - (i5 ^ 21);
                        $vD14832N6715 = i6 % 128;
                        int i7 = i6 % 2;
                        String strVD14832N6715$444b71f3 = vD14832N6715$444b71f3(obj);
                        int i8 = $component5;
                        int i9 = ((i8 | 103) << 1) - (i8 ^ 103);
                        $vD14832N6715 = i9 % 128;
                        if (i9 % 2 == 0) {
                            return strVD14832N6715$444b71f3;
                        }
                        throw null;
                    }

                    public final String vD14832N6715$444b71f3(Object obj) {
                        int i4 = 2 % 2;
                        int i5 = $vD14832N6715;
                        int i6 = (i5 ^ 69) + ((i5 & 69) << 1);
                        $component5 = i6 % 128;
                        int i7 = i6 % 2;
                        TimeZone timeZone = TimeZone.getDefault();
                        Intrinsics.checkNotNull(timeZone);
                        String id = timeZone.getID();
                        Intrinsics.checkNotNull(id);
                        int pivotYN16904 = setOnLongClickListenerR17701.setPivotYN16904();
                        int i8 = ~(388166295 | pivotYN16904);
                        int i9 = ~((388166295 & pivotYN16904) | (388166295 ^ pivotYN16904));
                        int i10 = ~pivotYN16904;
                        int i11 = ((((-299632652) + (((i8 & 1082983752) | (1082983752 ^ i8)) * 992)) + ((((i9 & 1082983752) | (1082983752 ^ i9)) | (~(((i10 & (-388166296)) | (i10 ^ (-388166296))) | 1152321356))) * (-496))) - (~(((pivotYN16904 & 1152321356) | (1152321356 ^ pivotYN16904)) * 496))) - 1;
                        int pivotYN16905 = setOnLongClickListenerR17701.setPivotYN16904();
                        int i12 = ~((696282421 ^ pivotYN16905) | (696282421 & pivotYN16905));
                        int i13 = ((i12 & (-1875308406)) | ((-1875308406) ^ i12)) * (-814);
                        int i14 = ((-826860129) & i13) + (i13 | (-826860129));
                        int i15 = ~pivotYN16905;
                        int i16 = ~((i15 & 1204194133) | (1204194133 ^ i15));
                        int i17 = (i16 & 25168149) | (i16 ^ 25168149);
                        int i18 = ~(696282421 | pivotYN16905);
                        int i19 = i14 + (((i18 & i17) | (i17 ^ i18)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE);
                        int i110 = ~(((-696282422) & pivotYN16905) | ((-696282422) ^ pivotYN16905));
                        int i20 = -(-(((~((pivotYN16905 & (-1204194134)) | ((-1204194134) ^ pivotYN16905))) | (i110 & 25168149) | (25168149 ^ i110)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                        if (i11 <= (i19 ^ i20) + ((i20 & i19) << 1)) {
                            int i21 = 67 / 0;
                        }
                        return id;
                    }

                    static {
                        int i4 = $D8871;
                        int i5 = (i4 ^ 95) + ((i4 & 95) << 1);
                        $component9 = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }, 7, null};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(874323074);
                if (objComponent6 == null) {
                    int iIndexOf = 51 - TextUtils.indexOf("", "", 0);
                    char trimmedLength = (char) TextUtils.getTrimmedLength("");
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 1077;
                    Object[] objArr4 = new Object[1];
                    a((short) 0, 0, (short) -1, objArr4);
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, trimmedLength, scrollBarSize, 1722308833, false, (String) objArr4[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent6).invoke(null, objArr3);
            }
            return (String) component9.component9((D8871) objInvoke, "");
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.setOnClickListenerO2383
    public final D8871<Integer, Throwable> vD14832N6715() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new Function0<Integer>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.copy.2
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $N14263A23323;
                private static int $component13;
                private static int D8871;
                private static boolean component5;
                private static boolean component9;
                private static char[] vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0020  */
                /* JADX WARN: Code duplicated, block: B:8:0x001a  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0028). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(byte r6, short r7, byte r8) {
                    /*
                        int r8 = r8 * 2
                        int r8 = r8 + 4
                        int r7 = r7 * 2
                        int r0 = r7 + 1
                        int r6 = r6 + 66
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.copy.AnonymousClass2.$$a
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        if (r1 != 0) goto L14
                        r3 = r8
                        r4 = r2
                        goto L28
                    L14:
                        r3 = r2
                    L15:
                        byte r4 = (byte) r6
                        r0[r3] = r4
                        if (r3 != r7) goto L20
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        return r6
                    L20:
                        r4 = r1[r8]
                        int r3 = r3 + 1
                        r5 = r3
                        r3 = r8
                        r8 = r4
                        r4 = r5
                    L28:
                        int r6 = r6 + r8
                        int r8 = r3 + 1
                        r3 = r4
                        goto L15
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.copy.AnonymousClass2.$$c(byte, short, byte):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{120, -76, 109, Ascii.FS};
                    $$b = 223;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Integer invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component13 + 61;
                    $N14263A23323 = i3 % 128;
                    int i4 = i3 % 2;
                    Integer numVD14832N6715 = vD14832N6715();
                    int i5 = $N14263A23323 + 71;
                    $component13 = i5 % 128;
                    int i6 = i5 % 2;
                    return numVD14832N6715;
                }

                public final Integer vD14832N6715() {
                    int i2 = 2 % 2;
                    int i3 = $N14263A23323 + 105;
                    $component13 = i3 % 128;
                    int i4 = i3 % 2;
                    ContentResolver contentResolverComponent9 = copy.component9(copy.this);
                    Intrinsics.checkNotNull(contentResolverComponent9);
                    Integer numValueOf = Integer.valueOf(Settings.Global.getInt(contentResolverComponent9, "auto_time_zone"));
                    int i5 = $component13 + 7;
                    $N14263A23323 = i5 % 128;
                    if (i5 % 2 != 0) {
                        return numValueOf;
                    }
                    throw null;
                }

                private static void a(int i2, int[] iArr, String str, String str2, Object[] objArr2) throws Throwable {
                    char[] charArray;
                    int length;
                    char[] cArr;
                    String str3 = str2;
                    int i3 = 2;
                    int i4 = 2 % 2;
                    Object bytes = str3;
                    if (str3 != null) {
                        bytes = str3.getBytes("ISO-8859-1");
                    }
                    byte[] bArr = (byte[]) bytes;
                    if (str != null) {
                        int i5 = $10 + 51;
                        $11 = i5 % 128;
                        if (i5 % 2 == 0) {
                            str.toCharArray();
                            throw null;
                        }
                        charArray = str.toCharArray();
                    } else {
                        charArray = str;
                    }
                    char[] cArr2 = charArray;
                    cg cgVar = new cg();
                    char[] cArr3 = vD14832N6715;
                    if (cArr3 != null) {
                        int i6 = $11 + 39;
                        $10 = i6 % 128;
                        if (i6 % 2 != 0) {
                            length = cArr3.length;
                            cArr = new char[length];
                        } else {
                            length = cArr3.length;
                            cArr = new char[length];
                        }
                        for (int i7 = 0; i7 < length; i7++) {
                            try {
                                Object[] objArr3 = {Integer.valueOf(cArr3[i7])};
                                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                                if (objComponent5 == null) {
                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.argb(0, 0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 34443), 5524 - View.resolveSizeAndState(0, 0, 0), -1476966259, false, $$c((byte) 0, (short) 0, (byte) 0), new Class[]{Integer.TYPE});
                                }
                                cArr[i7] = ((Character) ((Method) objComponent5).invoke(null, objArr3)).charValue();
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        cArr3 = cArr;
                    }
                    Object[] objArr4 = {Integer.valueOf(D8871)};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1693797315);
                    if (objComponent6 == null) {
                        int i8 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 52;
                        char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                        int i9 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4193;
                        byte b = (byte) ($$b & 5);
                        byte b2 = (byte) (b - 5);
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(i8, cIndexOf, i9, -910167970, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    int iIntValue = ((Integer) ((Method) objComponent6).invoke(null, objArr4)).intValue();
                    int i10 = 60693;
                    int i11 = 1771590243;
                    if (component5) {
                        cgVar.vD14832N6715 = bArr.length;
                        char[] cArr4 = new char[cgVar.vD14832N6715];
                        cgVar.setPivotYN16904 = 0;
                        while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                            cArr4[cgVar.setPivotYN16904] = (char) (cArr3[bArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] + i2] - iIntValue);
                            Object[] objArr5 = {cgVar, cgVar};
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i11);
                            if (objComponent7 == null) {
                                int mode = 52 - View.MeasureSpec.getMode(0);
                                char defaultSize = (char) (View.getDefaultSize(0, 0) + i10);
                                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 5955;
                                byte length2 = (byte) $$a.length;
                                byte b3 = (byte) (length2 - 4);
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(mode, defaultSize, windowTouchSlop, 992810496, false, $$c(length2, b3, b3), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent7).invoke(null, objArr5);
                            i10 = i10;
                            i11 = i11;
                        }
                        objArr2[0] = new String(cArr4);
                        return;
                    }
                    if (!component9) {
                        cgVar.vD14832N6715 = iArr.length;
                        char[] cArr5 = new char[cgVar.vD14832N6715];
                        cgVar.setPivotYN16904 = 0;
                        int i12 = $10 + 103;
                        $11 = i12 % 128;
                        if (i12 % 2 == 0) {
                            int i13 = 4 % 5;
                        }
                        while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                            int i14 = $11 + 33;
                            $10 = i14 % 128;
                            if (i14 % 2 != 0) {
                                cArr5[cgVar.setPivotYN16904] = (char) (cArr3[iArr[(cgVar.vD14832N6715 % 0) * cgVar.setPivotYN16904] - i2] << iIntValue);
                                int i15 = cgVar.setPivotYN16904;
                                cgVar.setPivotYN16904 = 0;
                            } else {
                                cArr5[cgVar.setPivotYN16904] = (char) (cArr3[iArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i2] - iIntValue);
                                cgVar.setPivotYN16904++;
                            }
                        }
                        objArr2[0] = new String(cArr5);
                        return;
                    }
                    cgVar.vD14832N6715 = cArr2.length;
                    char[] cArr6 = new char[cgVar.vD14832N6715];
                    cgVar.setPivotYN16904 = 0;
                    while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                        cArr6[cgVar.setPivotYN16904] = (char) (cArr3[cArr2[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i2] - iIntValue);
                        Object[] objArr6 = new Object[i3];
                        objArr6[1] = cgVar;
                        objArr6[0] = cgVar;
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                        if (objComponent8 == null) {
                            int iResolveSizeAndState = 52 - View.resolveSizeAndState(0, 0, 0);
                            char cMyTid = (char) (60693 - (Process.myTid() >> 22));
                            int i16 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 5955;
                            byte length3 = (byte) $$a.length;
                            byte b4 = (byte) (length3 - 4);
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState, cMyTid, i16, 992810496, false, $$c(length3, b4, b4), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent8).invoke(null, objArr6);
                        i3 = i3;
                    }
                    objArr2[0] = new String(cArr6);
                }

                public static void vD14832N6715(long j, long j2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $component13 + 41;
                    $N14263A23323 = i3 % 128;
                    int i4 = i3 % 2;
                    long j3 = j ^ (j2 << 32);
                    u.class.getField("vD14832N6715").get(null);
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a(127 - Color.alpha(0), null, null, "\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj, null);
                        Object[] objArr4 = new Object[1];
                        a((-16777089) - Color.rgb(0, 0, 0), null, null, "\u0089\u0089\u0088", objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a(127 - TextUtils.getOffsetAfter("", 0), null, null, "\u008b\u0084\u008a", objArr6);
                        Method method3 = Map.class.getMethod((String) objArr6[0], Object.class, Object.class);
                        method3.setAccessible(true);
                        method3.invoke(objInvoke2, objArr5);
                        int i5 = $N14263A23323 + 17;
                        $component13 = i5 % 128;
                        if (i5 % 2 != 0) {
                            int i6 = 35 / 0;
                        }
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
                    $component13 = 0;
                    $N14263A23323 = 1;
                    vD14832N6715 = new char[]{30128, 30119, 30122, 30131, 30115, 30089, 30112, 30199, 30194, 30134, 30130};
                    D8871 = 1313764806;
                    component9 = true;
                    component5 = true;
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 52;
                char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                int defaultSize = View.getDefaultSize(0, 0) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (short) 8, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, deadChar, defaultSize, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<Integer, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i2 = component5;
            int i3 = ((i2 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i2 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
            vD14832N6715 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 42 / 0;
            }
            return d8871;
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
        component5 = 0;
        vD14832N6715 = 1;
    }

    public static int component5() {
        int i = component9;
        int i2 = i % 7965207;
        component9 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        setPivotYN16904 = i3;
        return i3;
    }
}
