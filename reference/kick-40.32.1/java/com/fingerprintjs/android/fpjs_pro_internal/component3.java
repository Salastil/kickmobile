package com.fingerprintjs.android.fpjs_pro_internal;

import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class component3 implements G8931 {
    private static int D8871 = 1;
    private static int component9;
    private final InputManager component5;

    public component3(InputManager inputManager) {
        this.component5 = inputManager;
    }

    public static final /* synthetic */ InputManager component5(component3 component3Var) {
        int i = 2 % 2;
        int i2 = D8871 + 101;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        InputManager inputManager = component3Var.component5;
        if (i4 != 0) {
            int i5 = 51 / 0;
        }
        int i6 = (i3 ^ 49) + ((i3 & 49) << 1);
        D8871 = i6 % 128;
        int i7 = i6 % 2;
        return inputManager;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.G8931
    public final List<tM9319B53> component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function0<List<? extends tM9319B53>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component3.2
                private static int $component9 = 1;
                private static int $vD14832N6715;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ List<? extends tM9319B53> invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component9;
                    int i4 = (i3 & 53) + (i3 | 53);
                    $vD14832N6715 = i4 % 128;
                    int i5 = i4 % 2;
                    List<tM9319B53> listD8871 = D8871();
                    int i6 = $vD14832N6715 + 55;
                    $component9 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return listD8871;
                    }
                    throw null;
                }

                public final List<tM9319B53> D8871() {
                    int i2 = 2 % 2;
                    InputManager inputManagerComponent5 = component3.component5(component3.this);
                    Intrinsics.checkNotNull(inputManagerComponent5);
                    int[] inputDeviceIds = inputManagerComponent5.getInputDeviceIds();
                    Intrinsics.checkNotNull(inputDeviceIds);
                    component3 component3Var = component3.this;
                    ArrayList arrayList = new ArrayList(inputDeviceIds.length);
                    int length = inputDeviceIds.length;
                    int i3 = $component9 + GapComposerKt.nodeKey;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    int i5 = 0;
                    while (i5 < length) {
                        InputDevice inputDevice = component3.component5(component3Var).getInputDevice(inputDeviceIds[i5]);
                        Intrinsics.checkNotNull(inputDevice);
                        String strValueOf = String.valueOf(inputDevice.getVendorId());
                        String name = inputDevice.getName();
                        Intrinsics.checkNotNull(name);
                        arrayList.add(new tM9319B53(name, strValueOf));
                        i5 = (i5 | 1) + (i5 & 1);
                        int i6 = $component9;
                        int i7 = (i6 ^ 69) + ((i6 & 69) << 1);
                        $vD14832N6715 = i7 % 128;
                        int i8 = i7 % 2;
                    }
                    ArrayList arrayList2 = arrayList;
                    int i9 = $vD14832N6715;
                    int i10 = (i9 & 39) + (i9 | 39);
                    $component9 = i10 % 128;
                    int i11 = i10 % 2;
                    return arrayList2;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 51, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), 1804 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = component9 + 91;
                D8871 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i3 = 32 / 0;
                }
                objInvoke = listEmptyList;
            } else {
                int i4 = D8871 + 57;
                component9 = i4 % 128;
                int i5 = i4 % 2;
            }
            List<tM9319B53> list = (List) objInvoke;
            int i6 = D8871 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            component9 = i6 % 128;
            if (i6 % 2 == 0) {
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
}
