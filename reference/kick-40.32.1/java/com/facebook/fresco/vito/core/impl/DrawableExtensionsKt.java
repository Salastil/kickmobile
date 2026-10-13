package com.facebook.fresco.vito.core.impl;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawableExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"toggleAnimation", "", "Landroid/graphics/drawable/Drawable;", "animationEnabled", "", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DrawableExtensionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void toggleAnimation(Drawable drawable, boolean z) {
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (z) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }
}
