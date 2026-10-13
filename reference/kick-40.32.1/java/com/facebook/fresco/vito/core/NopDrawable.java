package com.facebook.fresco.vito.core;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NopDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/vito/core/NopDrawable;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "draw", "", "p0", "Landroid/graphics/Canvas;", "setAlpha", "", "setColorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NopDrawable extends Drawable {
    public static final NopDrawable INSTANCE = new NopDrawable();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int p0) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter p0) {
    }

    private NopDrawable() {
    }
}
