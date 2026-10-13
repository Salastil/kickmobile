package com.fingerprintjs.android.fpjs_pro_internal;

import android.hardware.Camera;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class getAutofillType implements W6392 {
    private static int component5 = 0;
    private static int setPivotYN16904 = 1;

    public static /* synthetic */ Object component9(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = ~i5;
        int i8 = ~i2;
        int i9 = ~i;
        int i10 = (~(i8 | i9)) | i7;
        int i11 = ~(i8 | i5 | i);
        int i12 = (~(i | i5)) | (~(i7 | i9)) | i8;
        int i13 = i5 + i2 + i3 + ((-1422066268) * i4) + ((-2108786386) * i6);
        int i14 = i13 * i13;
        int i15 = ((-1583913924) * i5) + 967573504 + (322476998 * i2) + (i10 * 1194288187) + (1194288187 * i11) + ((-1194288187) * i12) + (1516765184 * i3) + ((-1298137088) * i4) + (1722810368 * i6) + (518782976 * i14);
        int i16 = (i5 * 793895740) + 1353643607 + (i2 * 793896262) + (i10 * (-261)) + (i11 * (-261)) + (i12 * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED) + (i3 * 793896001) + (i4 * 692483748) + (i6 * (-1016611666)) + (i14 * 166461440);
        return i15 + ((i16 * i16) * 1997799424) != 1 ? component5(objArr) : D8871(objArr);
    }

    public static final /* synthetic */ List setPivotYN16904(getAutofillType getautofilltype) {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = (i2 & 57) + (i2 | 57);
        component5 = i3 % 128;
        int i4 = i3 % 2;
        List list = (List) component9(setOnLongClickListenerR17701.setPivotYN16904(), -1392547259, setOnLongClickListenerR17701.setPivotYN16904(), setOnLongClickListenerR17701.setPivotYN16904(), new Object[0], 1392547259, setOnLongClickListenerR17701.setPivotYN16904());
        int i5 = component5;
        int i6 = ((i5 | 23) << 1) - (i5 ^ 23);
        setPivotYN16904 = i6 % 128;
        int i7 = i6 % 2;
        return list;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.W6392
    public final List<pV7834> setPivotYN16904() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function0<List<? extends pV7834>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getAutofillType.3
                private static int $component9 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ List<? extends pV7834> invoke() {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 93;
                    $component9 = i3 % 128;
                    if (i3 % 2 == 0) {
                        return setPivotYN16904();
                    }
                    setPivotYN16904();
                    throw null;
                }

                public final List<pV7834> setPivotYN16904() {
                    int i2 = 2 % 2;
                    int i3 = $component9 + 113;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    List<pV7834> pivotYN16904 = getAutofillType.setPivotYN16904(getAutofillType.this);
                    int i5 = $component9 + 13;
                    $vD14832N6715 = i5 % 128;
                    int i6 = i5 % 2;
                    return pivotYN16904;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 52, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 1802 - TextUtils.indexOf((CharSequence) "", '0'), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m12690isFailureimpl(objInvoke)) {
                setOnLongClickListenerR17701.setPivotYN16904();
                System.identityHashCode(this);
                objInvoke = listEmptyList;
            } else {
                int i2 = setPivotYN16904 + 51;
                component5 = i2 % 128;
                int i3 = i2 % 2;
            }
            List<pV7834> list = (List) objInvoke;
            int i4 = component5 + 53;
            setPivotYN16904 = i4 % 128;
            if (i4 % 2 != 0) {
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
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        int i = 2 % 2;
        int numberOfCameras = Camera.getNumberOfCameras();
        LinkedList linkedList = new LinkedList();
        int i2 = component5 + 49;
        setPivotYN16904 = i2 % 128;
        int i3 = i2 % 2;
        int i4 = 0;
        while (i4 < numberOfCameras) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            linkedList.add(new pV7834(String.valueOf(i4), (String) component9(setOnLongClickListenerR17701.setPivotYN16904(), 1085055341, setOnLongClickListenerR17701.setPivotYN16904(), setOnLongClickListenerR17701.setPivotYN16904(), new Object[]{Integer.valueOf(cameraInfo.facing)}, -1085055340, setOnLongClickListenerR17701.setPivotYN16904()), String.valueOf(cameraInfo.orientation)));
            int i5 = (i4 & (-121)) + (i4 | (-121));
            i4 = (i5 & 122) + (i5 | 122);
        }
        LinkedList linkedList2 = linkedList;
        int i6 = setPivotYN16904;
        int i7 = (i6 ^ 91) + ((i6 & 91) << 1);
        component5 = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 37 / 0;
        }
        return linkedList2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    private static /* synthetic */ Object D8871(Object[] objArr) {
        int i;
        int iIntValue = ((Number) objArr[0]).intValue();
        int i2 = 2 % 2;
        int i3 = component5 + 113;
        int i4 = i3 % 128;
        setPivotYN16904 = i4;
        if (i3 % 2 == 0) {
            int i5 = 92 / 0;
            if (iIntValue != 0) {
                if (iIntValue == 1) {
                    return "front";
                }
                i = i4 + 75;
                component5 = i % 128;
                if (i % 2 == 0) {
                    throw null;
                }
                return "";
            }
            int i6 = ((i4 | 119) << 1) - (i4 ^ 119);
            component5 = i6 % 128;
            int i7 = i6 % 2;
            return WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME;
        }
        if (iIntValue != 0) {
            if (iIntValue == 1) {
                return "front";
            }
            i = i4 + 75;
            component5 = i % 128;
            if (i % 2 == 0) {
                throw null;
            }
            return "";
        }
        int i8 = ((i4 | 119) << 1) - (i4 ^ 119);
        component5 = i8 % 128;
        int i9 = i8 % 2;
        return WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME;
    }

    private static String D8871(int i) {
        return (String) component9(setOnLongClickListenerR17701.setPivotYN16904(), 1085055341, setOnLongClickListenerR17701.setPivotYN16904(), setOnLongClickListenerR17701.setPivotYN16904(), new Object[]{Integer.valueOf(i)}, -1085055340, setOnLongClickListenerR17701.setPivotYN16904());
    }

    private static List<pV7834> D8871() {
        return (List) component9(setOnLongClickListenerR17701.setPivotYN16904(), -1392547259, setOnLongClickListenerR17701.setPivotYN16904(), setOnLongClickListenerR17701.setPivotYN16904(), new Object[0], 1392547259, setOnLongClickListenerR17701.setPivotYN16904());
    }
}
