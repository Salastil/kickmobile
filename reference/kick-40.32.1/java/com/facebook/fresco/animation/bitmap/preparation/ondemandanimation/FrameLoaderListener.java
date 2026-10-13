package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrameLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;", "", "onZeroFrameDimensions", "", "origin", "", "frameNumber", "", ViewProps.WIDTH, ViewProps.HEIGHT, "onSingleFrameRender", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrameLoaderListener {
    void onSingleFrameRender(String origin, int width, int height);

    void onZeroFrameDimensions(String origin, int frameNumber, int width, int height);
}
