package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegate;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements getContentDescriptionT29053 {
    private static int component5 = 1;
    private static int component9;
    public static int setPivotYN16904;
    public static int vD14832N6715;
    private final SensorManager D8871;

    public c(SensorManager sensorManager) {
        this.D8871 = sensorManager;
    }

    public static final /* synthetic */ SensorManager vD14832N6715(c cVar) {
        int i = 2 % 2;
        int i2 = component5 + 119;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        SensorManager sensorManager = cVar.D8871;
        if (i4 != 0) {
            throw null;
        }
        int i5 = ((i3 | 107) << 1) - (i3 ^ 107);
        component5 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 89 / 0;
        }
        return sensorManager;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.getContentDescriptionT29053
    public final List<setOnTouchListener> vD14832N6715() throws Throwable {
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr = {0L, false, false, new Function0<List<? extends setOnTouchListener>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.c.2
                private static int $D8871 = 0;
                private static int $component5 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ List<? extends setOnTouchListener> invoke() {
                    int i2 = 2 % 2;
                    int i3 = $D8871;
                    int i4 = ((i3 | 89) << 1) - (i3 ^ 89);
                    $component5 = i4 % 128;
                    if (i4 % 2 == 0) {
                        vD14832N6715();
                        throw null;
                    }
                    List<setOnTouchListener> listVD14832N6715 = vD14832N6715();
                    int i5 = $D8871 + 59;
                    $component5 = i5 % 128;
                    int i6 = i5 % 2;
                    return listVD14832N6715;
                }

                public final List<setOnTouchListener> vD14832N6715() {
                    int i2 = 2 % 2;
                    SensorManager sensorManagerVD14832N6715 = c.vD14832N6715(c.this);
                    Intrinsics.checkNotNull(sensorManagerVD14832N6715);
                    List<Sensor> sensorList = sensorManagerVD14832N6715.getSensorList(-1);
                    Intrinsics.checkNotNull(sensorList);
                    List<Sensor> list = sensorList;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    int i3 = $D8871 + 63;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    for (Sensor sensor : list) {
                        Intrinsics.checkNotNull(sensor);
                        String name = sensor.getName();
                        Intrinsics.checkNotNull(name);
                        String vendor = sensor.getVendor();
                        Intrinsics.checkNotNull(vendor);
                        arrayList.add(new setOnTouchListener(name, vendor));
                        int i5 = $D8871;
                        int i6 = ((i5 | 29) << 1) - (i5 ^ 29);
                        $component5 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                    ArrayList arrayList2 = arrayList;
                    int i8 = $D8871 + 95;
                    $component5 = i8 % 128;
                    int i9 = i8 % 2;
                    return arrayList2;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.green(0) + 52, (char) ((-1) - TextUtils.lastIndexOf("", '0')), TextUtils.lastIndexOf("", '0', 0, 0) + 1804, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = component5;
                int i3 = (i2 & 99) + (i2 | 99);
                component9 = i3 % 128;
                if (i3 % 2 != 0) {
                    obj.hashCode();
                    throw null;
                }
                objInvoke = listEmptyList;
            }
            List<setOnTouchListener> list = (List) objInvoke;
            int i4 = component5;
            int i5 = (i4 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i4 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
            component9 = i5 % 128;
            int i6 = i5 % 2;
            return list;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int component9() {
        int i = setPivotYN16904;
        int i2 = i % 5598342;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return vD14832N6715;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        vD14832N6715 = i3;
        return i3;
    }
}
