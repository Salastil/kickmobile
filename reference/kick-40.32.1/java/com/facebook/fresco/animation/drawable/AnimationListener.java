package com.facebook.fresco.animation.drawable;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimationListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimationListener;", "", "onAnimationStart", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationStop", "onAnimationRepeat", "onAnimationFrame", "frameNumber", "", "onAnimationLoaded", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnimationListener {
    void onAnimationFrame(Drawable drawable, int frameNumber);

    default void onAnimationLoaded() {
    }

    void onAnimationRepeat(Drawable drawable);

    void onAnimationStart(Drawable drawable);

    void onAnimationStop(Drawable drawable);

    /* JADX INFO: compiled from: AnimationListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAnimationLoaded(AnimationListener animationListener) {
            AnimationListener.super.onAnimationLoaded();
        }
    }
}
