package com.facebook.fresco.animation.drawable;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseAnimationListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/animation/drawable/BaseAnimationListener;", "Lcom/facebook/fresco/animation/drawable/AnimationListener;", "<init>", "()V", "onAnimationStart", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationStop", "onAnimationRepeat", "onAnimationFrame", "frameNumber", "", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BaseAnimationListener implements AnimationListener {
    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationFrame(Drawable drawable, int frameNumber) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationRepeat(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStart(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStop(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationLoaded() {
        super.onAnimationLoaded();
    }
}
