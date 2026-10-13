package com.swmansion.rnscreens.gamma.stack.header;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.graphics.drawable.DrawableKt;
import com.google.android.material.appbar.MaterialToolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderDrawableUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"getResizedDrawable", "Landroid/graphics/drawable/Drawable;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "drawable", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderDrawableUtilsKt {
    public static final Drawable getResizedDrawable(MaterialToolbar toolbar, Drawable drawable) {
        int i;
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f, toolbar.getResources().getDisplayMetrics());
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            i = iApplyDimension;
        } else {
            i = (int) (iApplyDimension * (intrinsicWidth / intrinsicHeight));
        }
        Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, i, iApplyDimension, null, 4, null);
        bitmap$default.setDensity(toolbar.getResources().getDisplayMetrics().densityDpi);
        Resources resources = toolbar.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return new BitmapDrawable(resources, bitmap$default);
    }
}
