package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MovieAnimatedImage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/animated/giflite/draw/MovieAnimatedImage;", "Lcom/facebook/imagepipeline/animated/base/AnimatedImage;", "frames", "", "Lcom/facebook/animated/giflite/draw/MovieFrame;", "_sizeInBytes", "", "_duration", "_loopCount", "animatedBitmapConfig", "Landroid/graphics/Bitmap$Config;", "<init>", "([Lcom/facebook/animated/giflite/draw/MovieFrame;IIILandroid/graphics/Bitmap$Config;)V", "[Lcom/facebook/animated/giflite/draw/MovieFrame;", "_frameDurations", "", "_animatedBitmapConfig", "dispose", "", "getWidth", "getHeight", "getFrameCount", "getDuration", "getFrameDurations", "getLoopCount", "getFrame", "Lcom/facebook/imagepipeline/animated/base/AnimatedImageFrame;", "frameNumber", "doesRenderSupportScaling", "", "getSizeInBytes", "getFrameInfo", "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo;", "getAnimatedBitmapConfig", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MovieAnimatedImage implements AnimatedImage {
    private final Bitmap.Config _animatedBitmapConfig;
    private final int _duration;
    private final int[] _frameDurations;
    private final int _loopCount;
    private final int _sizeInBytes;
    private final MovieFrame[] frames;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieAnimatedImage(MovieFrame[] frames, int i, int i2, int i3) {
        this(frames, i, i2, i3, null, 16, null);
        Intrinsics.checkNotNullParameter(frames, "frames");
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return true;
    }

    public MovieAnimatedImage(MovieFrame[] frames, int i, int i2, int i3, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(frames, "frames");
        this.frames = frames;
        this._sizeInBytes = i;
        this._duration = i2;
        this._loopCount = i3;
        this._frameDurations = new int[frames.length];
        int length = frames.length;
        for (int i4 = 0; i4 < length; i4++) {
            this._frameDurations[i4] = this.frames[i4].getFrameDuration();
        }
        this._animatedBitmapConfig = config;
    }

    public /* synthetic */ MovieAnimatedImage(MovieFrame[] movieFrameArr, int i, int i2, int i3, Bitmap.Config config, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(movieFrameArr, i, i2, i3, (i4 & 16) != 0 ? null : config);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return this.frames[0].getFrameWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        return this.frames[0].getFrameHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        return this.frames.length;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    /* JADX INFO: renamed from: getDuration, reason: from getter */
    public int get_duration() {
        return this._duration;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    /* JADX INFO: renamed from: getFrameDurations, reason: from getter */
    public int[] get_frameDurations() {
        return this._frameDurations;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    /* JADX INFO: renamed from: getLoopCount, reason: from getter */
    public int get_loopCount() {
        return this._loopCount;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedImageFrame getFrame(int frameNumber) {
        return this.frames[frameNumber];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    /* JADX INFO: renamed from: getSizeInBytes, reason: from getter */
    public int get_sizeInBytes() {
        return this._sizeInBytes;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int frameNumber) {
        MovieFrame movieFrame = this.frames[frameNumber];
        return new AnimatedDrawableFrameInfo(frameNumber, movieFrame.getXOffset(), movieFrame.getYOffset(), movieFrame.getFrameWidth(), movieFrame.getFrameHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, this.frames[frameNumber].getDisposalMode());
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    /* JADX INFO: renamed from: getAnimatedBitmapConfig, reason: from getter */
    public Bitmap.Config get_animatedBitmapConfig() {
        return this._animatedBitmapConfig;
    }
}
