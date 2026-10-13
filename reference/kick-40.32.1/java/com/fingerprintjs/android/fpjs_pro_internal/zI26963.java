package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class zI26963 implements unregisterForContextMenu {
    final rV4669 D8871;
    final vE15773 component5;
    final Object component9;
    final I30900 setPivotYN16904;
    final an vD14832N6715;

    public zI26963(Object obj, an anVar, vE15773 ve15773, rV4669 rv4669, I30900 i30900) {
        this.component9 = obj;
        this.vD14832N6715 = anVar;
        this.component5 = ve15773;
        this.D8871 = rv4669;
        this.setPivotYN16904 = i30900;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.unregisterForContextMenu
    public final rV4669 setPivotYN16904() throws Throwable {
        Object obj;
        vD14832N6715 vd14832n6715D8871 = this.vD14832N6715.D8871(this.setPivotYN16904.component5());
        if (vd14832n6715D8871 instanceof vD14832N6715) {
            vd14832n6715D8871 = this.component5.D8871((byte[]) ((vD14832N6715) vd14832n6715D8871).setPivotYN16904, this.D8871);
        } else if (!(vd14832n6715D8871 instanceof setPivotYN16904)) {
            throw new NoWhenBranchMatchedException();
        }
        if (vd14832n6715D8871 instanceof vD14832N6715) {
            vd14832n6715D8871 = new vD14832N6715(((vE15773.vD14832N6715) ((vD14832N6715) vd14832n6715D8871).setPivotYN16904).D8871());
        } else if (!(vd14832n6715D8871 instanceof setPivotYN16904)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(vd14832n6715D8871 instanceof vD14832N6715)) {
            if (!(vd14832n6715D8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            E e = ((setPivotYN16904) vd14832n6715D8871).setPivotYN16904;
            obj = this.D8871;
        } else {
            obj = ((vD14832N6715) vd14832n6715D8871).setPivotYN16904;
        }
        try {
            Object[] objArr = {new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.zI26963.5
                /* JADX WARN: Multi-variable type inference failed */
                public final void component5() throws Throwable {
                    zI26963 zi26963 = zI26963.this;
                    Object obj2 = zi26963.component9;
                    try {
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-2012558458);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(60 - TextUtils.getOffsetBefore("", 0), (char) (25547 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), -624979995, false, "component5", new Class[0]);
                        }
                        setPivotYN16904 setpivotyn16904Invoke = ((Method) objComponent5).invoke(obj2, null);
                        if (setpivotyn16904Invoke instanceof vD14832N6715) {
                            byte[] bArr = (byte[]) ((vD14832N6715) setpivotyn16904Invoke).setPivotYN16904;
                            D8871<vE15773.vD14832N6715, Throwable> D8871 = zi26963.component5.D8871(bArr, zi26963.D8871);
                            if (D8871 instanceof vD14832N6715) {
                                setpivotyn16904Invoke = new vD14832N6715(TuplesKt.to(((vD14832N6715) D8871).setPivotYN16904, bArr));
                            } else {
                                if (!(D8871 instanceof setPivotYN16904)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                setpivotyn16904Invoke = D8871;
                            }
                        } else if (!(setpivotyn16904Invoke instanceof setPivotYN16904)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (setpivotyn16904Invoke instanceof vD14832N6715) {
                            vD14832N6715 vd14832n6715 = (vD14832N6715) setpivotyn16904Invoke;
                            if (!(((vE15773.vD14832N6715) ((Pair) vd14832n6715.setPivotYN16904).getFirst()).component9() instanceof setSystemGestureExclusionRects.D8871)) {
                                setpivotyn16904Invoke = new setPivotYN16904(new Exception(fO27287.component5()));
                            }
                        } else if (!(setpivotyn16904Invoke instanceof setPivotYN16904)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (setpivotyn16904Invoke instanceof vD14832N6715) {
                            zi26963.vD14832N6715.vD14832N6715((byte[]) ((Pair) ((vD14832N6715) setpivotyn16904Invoke).setPivotYN16904).getSecond(), zi26963.setPivotYN16904.component5());
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() throws Throwable {
                    component5();
                    return Unit.INSTANCE;
                }

                {
                    super(0);
                }
            }};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-234092262);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getFadingEdgeLength() >> 16) + 51, (char) (Process.myTid() >> 22), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1487, -1598468743, false, "setPivotYN16904", new Class[]{Function0.class});
            }
            ((Method) objComponent5).invoke(null, objArr);
            return (rV4669) obj;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
