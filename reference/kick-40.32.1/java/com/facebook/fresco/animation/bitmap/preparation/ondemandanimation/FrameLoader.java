package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FrameLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH'J&\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH'J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "getAnimationInformation", "()Lcom/facebook/fresco/animation/backend/AnimationInformation;", "getFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "frameNumber", "", ViewProps.WIDTH, ViewProps.HEIGHT, "prepareFrames", "", "onAnimationLoaded", "Lkotlin/Function0;", "compressToFps", "fps", "onStop", "clear", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrameLoader {
    void clear();

    default void compressToFps(int fps) {
    }

    AnimationInformation getAnimationInformation();

    FrameResult getFrame(int frameNumber, int width, int height);

    default void onStop() {
    }

    void prepareFrames(int width, int height, Function0<Unit> onAnimationLoaded);

    /* JADX INFO: compiled from: FrameLoader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void compressToFps(FrameLoader frameLoader, int i) {
            FrameLoader.super.compressToFps(i);
        }

        @Deprecated
        public static void onStop(FrameLoader frameLoader) {
            FrameLoader.super.onStop();
        }
    }
}
