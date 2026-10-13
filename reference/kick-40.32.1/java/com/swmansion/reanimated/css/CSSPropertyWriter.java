package com.swmansion.reanimated.css;

import android.util.FloatProperty;
import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSPropertyWriter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¨\u0006\u0012"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "Landroid/util/FloatProperty;", "Landroid/view/View;", "name", "", "<init>", "(Ljava/lang/String;)V", "animatorEndpoints", "Lkotlin/Pair;", "", "fromBits", "toBits", "matches", "", "view", "value", "", "resumeFrom", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CSSPropertyWriter extends FloatProperty<View> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSSPropertyWriter(String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public Pair<Double, Double> animatorEndpoints(double fromBits, double toBits) {
        return TuplesKt.to(Double.valueOf(fromBits), Double.valueOf(toBits));
    }

    public boolean matches(View view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Intrinsics.areEqual((Float) get(view), value);
    }

    public float resumeFrom(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = get(view);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return ((Number) obj).floatValue();
    }
}
