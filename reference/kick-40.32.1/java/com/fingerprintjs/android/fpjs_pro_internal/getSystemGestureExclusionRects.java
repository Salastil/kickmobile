package com.fingerprintjs.android.fpjs_pro_internal;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.input.InputManager;
import android.media.AudioTrack;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0010\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0015\u001a\u00020 H\u0002¢\u0006\u0004\b\u0015\u0010!J\u0017\u0010\r\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010#J\u000f\u0010\u001b\u001a\u00020$H\u0002¢\u0006\u0004\b\u001b\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010("}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getSystemGestureExclusionRects;", "", "<init>", "()V", "Landroid/content/Context;", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/pC2922;", "D8871", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/pC2922;", "Lcom/fingerprintjs/android/fpjs_pro_internal/T9586V28869;", "sG29839", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/T9586V28869;", "Lcom/fingerprintjs/android/fpjs_pro_internal/W6392;", "setPivotYN16904", "()Lcom/fingerprintjs/android/fpjs_pro_internal/W6392;", "Lcom/fingerprintjs/android/fpjs_pro_internal/component7;", "component5", "()Lcom/fingerprintjs/android/fpjs_pro_internal/component7;", "Lcom/fingerprintjs/android/fpjs_pro_internal/a;", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/a;", "Lcom/fingerprintjs/android/fpjs_pro_internal/B22527;", "vD14832N6715", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/B22527;", "Lcom/fingerprintjs/android/fpjs_pro_internal/B9336;", "component8", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/B9336;", "Lcom/fingerprintjs/android/fpjs_pro_internal/H16981;", "component9", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/H16981;", "Lcom/fingerprintjs/android/fpjs_pro_internal/component3;", "setTopP6481", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/component3;", "Lcom/fingerprintjs/android/fpjs_pro_internal/X26477;", "()Lcom/fingerprintjs/android/fpjs_pro_internal/X26477;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setScrollYX30569T8767;", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/setScrollYX30569T8767;", "Lcom/fingerprintjs/android/fpjs_pro_internal/W29288;", "()Lcom/fingerprintjs/android/fpjs_pro_internal/W29288;", "Lcom/fingerprintjs/android/fpjs_pro_internal/c;", "N14263A23323", "(Landroid/content/Context;)Lcom/fingerprintjs/android/fpjs_pro_internal/c;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class getSystemGestureExclusionRects {
    public static final getSystemGestureExclusionRects INSTANCE = new getSystemGestureExclusionRects();
    private static int component5 = 1;
    private static int component9 = 1;
    private static int setPivotYN16904;
    private static int vD14832N6715;

    public static /* synthetic */ Object vD14832N6715(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) throws Throwable {
        int i7 = ~i4;
        int i8 = ~i3;
        int i9 = i8 | i2;
        int i10 = (~(i7 | i8)) | (~(i7 | i2)) | (~i9);
        int i11 = ~i2;
        int i12 = (~(i3 | i11 | i4)) | (~(i7 | i11 | i8)) | (~(i9 | i4));
        int i13 = ~(i8 | i11 | i4);
        int i14 = i2 + i4 + i6 + ((-973178360) * i) + (1542423572 * i5);
        int i15 = i14 * i14;
        int i16 = (i2 * (-490823948)) + 944362368 + (i4 * (-490821954)) + (i10 * (-997)) + (i12 * 997) + (i13 * 997) + ((-490822951) * i6) + (2145288392 * i) + (779328756 * i5) + (i15 * (-1138819072));
        int i17 = (((-1657973228) * i2) - 1073741824) + ((-187520530) * i4) + ((-735226349) * i10) + (i12 * 735226349) + (735226349 * i13) + ((-922746880) * i6) + (1207959552 * i) + ((-1275068416) * i5) + (196542464 * i15) + (i16 * i16 * 1440284672);
        if (i17 == 1) {
            return setPivotYN16904(objArr);
        }
        if (i17 == 2) {
            Context context = (Context) objArr[0];
            int i18 = 2 % 2;
            a aVar = new a(component9(context), D8871(context), vD14832N6715());
            int i19 = vD14832N6715 + 43;
            component5 = i19 % 128;
            int i20 = i19 % 2;
            return aVar;
        }
        try {
            if (i17 == 3) {
                final Context context2 = (Context) objArr[0];
                Object[] objArr2 = {0L, false, false, new Function0<SensorManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.6
                    private static int $component5 = 1;
                    private static int $setPivotYN16904;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ SensorManager invoke() {
                        int i21 = 2 % 2;
                        int i22 = $setPivotYN16904;
                        int i23 = ((i22 | 19) << 1) - (i22 ^ 19);
                        $component5 = i23 % 128;
                        int i24 = i23 % 2;
                        SensorManager pivotYN16904 = setPivotYN16904();
                        int i25 = $setPivotYN16904;
                        int i26 = (i25 & 9) + (i25 | 9);
                        $component5 = i26 % 128;
                        int i27 = i26 % 2;
                        return pivotYN16904;
                    }

                    public final SensorManager setPivotYN16904() {
                        int i21 = 2 % 2;
                        int i22 = $setPivotYN16904;
                        int i23 = (i22 ^ 83) + ((i22 & 83) << 1);
                        $component5 = i23 % 128;
                        int i24 = i23 % 2;
                        SensorManager sensorManager = (SensorManager) context2.getSystemService("sensor");
                        if (i24 == 0) {
                            throw null;
                        }
                        int i25 = $component5 + 25;
                        $setPivotYN16904 = i25 % 128;
                        int i26 = i25 % 2;
                        return sensorManager;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }
                }, 7, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 52, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), 1803 - KeyEvent.getDeadChar(0, 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                Object objInvoke = ((Method) objComponent5).invoke(null, objArr2);
                return new c((SensorManager) (Result.m12690isFailureimpl(objInvoke) ? null : objInvoke));
            }
            if (i17 == 4) {
                final Context context3 = (Context) objArr[0];
                Object[] objArr3 = {0L, false, false, new Function0<InputManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.2
                    private static int $D8871 = 0;
                    private static int $component5 = 1;

                    public final InputManager component9() {
                        int i21 = 2 % 2;
                        int i22 = $D8871 + 47;
                        $component5 = i22 % 128;
                        int i23 = i22 % 2;
                        InputManager inputManager = (InputManager) context3.getSystemService("input");
                        if (i23 == 0) {
                            throw null;
                        }
                        int i24 = $component5;
                        int i25 = (i24 & 59) + (i24 | 59);
                        $D8871 = i25 % 128;
                        int i26 = i25 % 2;
                        return inputManager;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ InputManager invoke() {
                        int i21 = 2 % 2;
                        int i22 = $D8871 + 17;
                        $component5 = i22 % 128;
                        Object obj = null;
                        if (i22 % 2 == 0) {
                            component9();
                            throw null;
                        }
                        InputManager inputManagerComponent9 = component9();
                        int i23 = $D8871 + 67;
                        $component5 = i23 % 128;
                        if (i23 % 2 != 0) {
                            return inputManagerComponent9;
                        }
                        obj.hashCode();
                        throw null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }
                }, 7, null};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getEdgeSlop() >> 16) + 52, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getTapTimeout() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                Object objInvoke2 = ((Method) objComponent6).invoke(null, objArr3);
                return new component3((InputManager) (Result.m12690isFailureimpl(objInvoke2) ? null : objInvoke2));
            }
            if (i17 != 5) {
                final Context context4 = (Context) objArr[0];
                Object[] objArr4 = {0L, false, false, new Function0<ContentResolver>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.4
                    private static int $component5 = 1;
                    private static int $setPivotYN16904;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ ContentResolver invoke() {
                        int i21 = 2 % 2;
                        int i22 = $setPivotYN16904 + 105;
                        $component5 = i22 % 128;
                        int i23 = i22 % 2;
                        ContentResolver contentResolverVD14832N6715 = vD14832N6715();
                        int i24 = $component5 + 13;
                        $setPivotYN16904 = i24 % 128;
                        int i25 = i24 % 2;
                        return contentResolverVD14832N6715;
                    }

                    public final ContentResolver vD14832N6715() {
                        int i21 = 2 % 2;
                        int i22 = $setPivotYN16904;
                        int i23 = (i22 ^ 123) + ((i22 & 123) << 1);
                        $component5 = i23 % 128;
                        int i24 = i23 % 2;
                        ContentResolver contentResolver = context4.getContentResolver();
                        Intrinsics.checkNotNull(contentResolver);
                        int i25 = $component5 + 15;
                        $setPivotYN16904 = i25 % 128;
                        if (i25 % 2 == 0) {
                            return contentResolver;
                        }
                        Object obj = null;
                        obj.hashCode();
                        throw null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }
                }, 7, null};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0), 1803 - (ViewConfiguration.getJumpTapTimeout() >> 16), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                Object objInvoke3 = ((Method) objComponent7).invoke(null, objArr4);
                return new pC2922((ContentResolver) (Result.m12690isFailureimpl(objInvoke3) ? null : objInvoke3));
            }
            final Context context5 = (Context) objArr[0];
            Object[] objArr5 = {0L, false, false, new Function0<ActivityManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.3
                private static int $D8871 = 1;
                private static int $component9;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ ActivityManager invoke() {
                    int i21 = 2 % 2;
                    int i22 = $D8871;
                    int i23 = (i22 & 5) + (i22 | 5);
                    $component9 = i23 % 128;
                    int i24 = i23 % 2;
                    ActivityManager pivotYN16904 = setPivotYN16904();
                    int i25 = $component9;
                    int i26 = ((i25 | 69) << 1) - (i25 ^ 69);
                    $D8871 = i26 % 128;
                    if (i26 % 2 != 0) {
                        return pivotYN16904;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                public final ActivityManager setPivotYN16904() {
                    int i21 = 2 % 2;
                    int i22 = $D8871;
                    int i23 = (i22 & 51) + (i22 | 51);
                    $component9 = i23 % 128;
                    int i24 = i23 % 2;
                    ActivityManager activityManager = (ActivityManager) context5.getSystemService("activity");
                    int i25 = $component9 + 23;
                    $D8871 = i25 % 128;
                    if (i25 % 2 != 0) {
                        return activityManager;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 7, null};
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.MeasureSpec.getSize(0), (char) View.getDefaultSize(0, 0), 1802 - TextUtils.lastIndexOf("", '0', 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke4 = ((Method) objComponent8).invoke(null, objArr5);
            if (Result.m12690isFailureimpl(objInvoke4)) {
                objInvoke4 = null;
            }
            ActivityManager activityManager = (ActivityManager) objInvoke4;
            Object[] objArr6 = {0L, false, false, new Function0<StatFs>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.8
                private static int $D8871 = 0;
                private static int $component5 = 1;
                private static int $setPivotYN16904 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ StatFs invoke() {
                    int i21 = 2 % 2;
                    int i22 = $setPivotYN16904 + 35;
                    $vD14832N6715 = i22 % 128;
                    if (i22 % 2 != 0) {
                        return setPivotYN16904();
                    }
                    setPivotYN16904();
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                public final StatFs setPivotYN16904() {
                    int i21 = 2 % 2;
                    File rootDirectory = Environment.getRootDirectory();
                    Intrinsics.checkNotNull(rootDirectory);
                    String absolutePath = rootDirectory.getAbsolutePath();
                    Intrinsics.checkNotNull(absolutePath);
                    StatFs statFs = new StatFs(absolutePath);
                    int i22 = $setPivotYN16904;
                    int i23 = (i22 ^ 11) + ((i22 & 11) << 1);
                    $vD14832N6715 = i23 % 128;
                    if (i23 % 2 != 0) {
                        return statFs;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                static {
                    int i21 = $component5 + 17;
                    $D8871 = i21 % 128;
                    int i22 = i21 % 2;
                }
            }, 7, null};
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5((int) r5);
            if (objComponent9 == null) {
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1), 1803 - TextUtils.indexOf("", "", 0, 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke5 = ((Method) objComponent9).invoke(null, objArr6);
            if (Result.m12690isFailureimpl(objInvoke5)) {
                objInvoke5 = null;
            }
            StatFs statFs = (StatFs) objInvoke5;
            Object[] objArr7 = {0L, false, false, new Function0<StatFs>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.10
                private static int $component5 = 0;
                private static int $component9 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ StatFs invoke() {
                    int i21 = 2 % 2;
                    int i22 = $component5 + 59;
                    $component9 = i22 % 128;
                    int i23 = i22 % 2;
                    StatFs pivotYN16904 = setPivotYN16904();
                    int i24 = $component5 + 13;
                    $component9 = i24 % 128;
                    int i25 = i24 % 2;
                    return pivotYN16904;
                }

                public final StatFs setPivotYN16904() {
                    int i21 = 2 % 2;
                    int i22 = $component5;
                    int i23 = ((i22 | 117) << 1) - (i22 ^ 117);
                    $component9 = i23 % 128;
                    int i24 = i23 % 2;
                    StatFs statFs2 = null;
                    File externalFilesDir = context5.getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        int i25 = $component5 + 3;
                        $component9 = i25 % 128;
                        int i26 = i25 % 2;
                        if (externalFilesDir.canRead()) {
                            int i27 = $component5;
                            int i28 = (i27 & 119) + (i27 | 119);
                            int i29 = i28 % 128;
                            $component9 = i29;
                            if (i28 % 2 == 0) {
                                statFs2.hashCode();
                                throw null;
                            }
                            int i30 = i29 + 3;
                            $component5 = i30 % 128;
                            int i31 = i30 % 2;
                        } else {
                            int i32 = $component5;
                            int i33 = ((i32 | 47) << 1) - (i32 ^ 47);
                            $component9 = i33 % 128;
                            int i34 = i33 % 2;
                            externalFilesDir = null;
                        }
                        if (externalFilesDir != null) {
                            String absolutePath = externalFilesDir.getAbsolutePath();
                            Intrinsics.checkNotNull(absolutePath);
                            statFs2 = new StatFs(absolutePath);
                        }
                    }
                    Intrinsics.checkNotNull(statFs2);
                    int i35 = $component5 + 39;
                    $component9 = i35 % 128;
                    int i36 = i35 % 2;
                    return statFs2;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 7, null};
            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent10 == null) {
                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getWindowTouchSlop() >> 8) + 52, (char) (ViewConfiguration.getEdgeSlop() >> 16), 1803 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke6 = ((Method) objComponent10).invoke(null, objArr7);
            return new mK14988T27556(activityManager, statFs, (StatFs) (Result.m12690isFailureimpl(objInvoke6) ? null : objInvoke6));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private getSystemGestureExclusionRects() {
    }

    private static component7 component5() {
        int i = 2 % 2;
        component7 component7Var = new component7();
        int i2 = component5 + 75;
        vD14832N6715 = i2 % 128;
        if (i2 % 2 == 0) {
            return component7Var;
        }
        throw null;
    }

    private static W29288 component9() {
        int i = 2 % 2;
        W29288 w29288 = new W29288();
        int i2 = vD14832N6715 + 47;
        component5 = i2 % 128;
        int i3 = i2 % 2;
        return w29288;
    }

    private static H16981 component9(final Context p0) throws Throwable {
        try {
            Object[] objArr = {0L, false, false, new Function0<ContentResolver>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.5
                private static int $component5 = 0;
                private static int $setPivotYN16904 = 1;

                public final ContentResolver component5() {
                    int i = 2 % 2;
                    P28427.AnonymousClass4.component9();
                    P28427.AnonymousClass4.component9();
                    ContentResolver contentResolver = p0.getContentResolver();
                    Intrinsics.checkNotNull(contentResolver);
                    int i2 = $setPivotYN16904;
                    int i3 = (i2 & 43) + (i2 | 43);
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    return contentResolver;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ ContentResolver invoke() {
                    int i = 2 % 2;
                    int i2 = $setPivotYN16904;
                    int i3 = (i2 ^ 7) + ((i2 & 7) << 1);
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    ContentResolver contentResolverComponent5 = component5();
                    int i5 = $component5;
                    int i6 = (i5 & 23) + (i5 | 23);
                    $setPivotYN16904 = i6 % 128;
                    if (i6 % 2 == 0) {
                        int i7 = 56 / 0;
                    }
                    return contentResolverComponent5;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Gravity.getAbsoluteGravity(0, 0) + 52, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 1803 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            return new H16981((ContentResolver) (Result.m12690isFailureimpl(objInvoke) ? null : objInvoke));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static X26477 vD14832N6715() {
        int i = 2 % 2;
        X26477 x26477 = new X26477();
        int i2 = vD14832N6715 + 1;
        component5 = i2 % 128;
        int i3 = i2 % 2;
        return x26477;
    }

    private static T9586V28869 sG29839(Context p0) {
        int i = 2 % 2;
        T9586V28869 t9586v28869 = new T9586V28869(p0);
        int i2 = component5 + GapComposerKt.nodeKey;
        vD14832N6715 = i2 % 128;
        if (i2 % 2 == 0) {
            return t9586v28869;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        int i = 2 % 2;
        getAutofillType getautofilltype = new getAutofillType();
        int i2 = component5 + 15;
        vD14832N6715 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 90 / 0;
        }
        return getautofilltype;
    }

    private static B9336 component8(final Context p0) throws Throwable {
        try {
            Object[] objArr = {0L, false, false, new Function0<ActivityManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getSystemGestureExclusionRects.1
                private static int $D8871 = 0;
                private static int $component9 = 1;

                public final ActivityManager component5() {
                    int i = 2 % 2;
                    int i2 = $D8871 + 7;
                    $component9 = i2 % 128;
                    int i3 = i2 % 2;
                    ActivityManager activityManager = (ActivityManager) p0.getSystemService("activity");
                    int i4 = $D8871;
                    int i5 = (i4 ^ 29) + ((i4 & 29) << 1);
                    $component9 = i5 % 128;
                    if (i5 % 2 != 0) {
                        return activityManager;
                    }
                    throw null;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ ActivityManager invoke() {
                    int i = 2 % 2;
                    int i2 = $component9 + 113;
                    $D8871 = i2 % 128;
                    int i3 = i2 % 2;
                    ActivityManager activityManagerComponent5 = component5();
                    int i4 = $component9 + 53;
                    $D8871 = i4 % 128;
                    if (i4 % 2 == 0) {
                        return activityManagerComponent5;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0), 1803 - (ViewConfiguration.getJumpTapTimeout() >> 16), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            return new B9336((ActivityManager) (Result.m12690isFailureimpl(objInvoke) ? null : objInvoke));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static B22527 vD14832N6715(Context p0) {
        int i = 2 % 2;
        B22527 b22527 = new B22527(component5(), setPivotYN16904(p0), N14263A23323(p0), setTopP6481(p0), sG29839(p0), setPivotYN16904(), component8(p0), component9());
        component8T18414.AnonymousClass2.setPivotYN16904();
        component8T18414.AnonymousClass2.setPivotYN16904();
        return b22527;
    }

    static {
        int i = component9;
        int i2 = ((i | 101) << 1) - (i ^ 101);
        setPivotYN16904 = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static a component5(Context p0) {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (a) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), 1200693360, pivotYN16904, -1200693358, new Object[]{p0}, component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }

    private static W6392 setPivotYN16904() {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (W6392) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), 1749151288, pivotYN16904, -1749151287, new Object[0], component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }

    private static component3 setTopP6481(Context p0) {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (component3) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), 642230159, pivotYN16904, -642230155, new Object[]{p0}, component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }

    private static c N14263A23323(Context p0) {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (c) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), 777302853, pivotYN16904, -777302850, new Object[]{p0}, component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }

    private static pC2922 D8871(Context p0) {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (pC2922) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), -295677792, pivotYN16904, 295677792, new Object[]{p0}, component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }

    private static setScrollYX30569T8767 setPivotYN16904(Context p0) {
        int pivotYN16904 = component8T18414.AnonymousClass2.setPivotYN16904();
        int pivotYN16905 = component8T18414.AnonymousClass2.setPivotYN16904();
        return (setScrollYX30569T8767) vD14832N6715(component8T18414.AnonymousClass2.setPivotYN16904(), -292671796, pivotYN16904, 292671801, new Object[]{p0}, component8T18414.AnonymousClass2.setPivotYN16904(), pivotYN16905);
    }
}
