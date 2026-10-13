package com.swmansion.rnscreens.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DimensionUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"pxToDp", "", "px", "density", "Landroid/view/View;", "dpToPx", "dp", "resolveDimensionAttr", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "attrId", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DimensionUtilsKt {
    public static final float pxToDp(float f, float f2) {
        return f2 > 0.0f ? f / f2 : PixelUtil.toDIPFromPixel(f);
    }

    public static final float pxToDp(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return pxToDp(f, view.getResources().getDisplayMetrics().density);
    }

    public static final float dpToPx(float f, float f2) {
        return f2 > 0.0f ? f * f2 : PixelUtil.toPixelFromDIP(f);
    }

    public static final float dpToPx(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return dpToPx(f, view.getResources().getDisplayMetrics().density);
    }

    public static final int resolveDimensionAttr(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            throw new IllegalArgumentException("[RNScreens] Unable to resolve Material theme dimension.".toString());
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }
}
