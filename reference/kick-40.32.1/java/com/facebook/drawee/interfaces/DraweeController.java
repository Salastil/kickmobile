package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface DraweeController {
    @Nullable
    Animatable getAnimatable();

    @Nullable
    String getContentDescription();

    @Nullable
    DraweeHierarchy getHierarchy();

    boolean isSameImageRequest(@Nullable DraweeController draweeController);

    void onAttach();

    void onDetach();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onViewportVisibilityHint(boolean z);

    void setContentDescription(String str);

    void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy);
}
