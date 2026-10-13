package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MovieFrame.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/facebook/animated/giflite/draw/MovieFrame;", "Lcom/facebook/imagepipeline/animated/base/AnimatedImageFrame;", "movieDrawer", "Lcom/facebook/animated/giflite/draw/MovieDrawer;", "frameStart", "", "frameDuration", "frameWidth", "frameHeight", "disposalMode", "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;", "<init>", "(Lcom/facebook/animated/giflite/draw/MovieDrawer;IIIILcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;)V", "getDisposalMode", "()Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;", "dispose", "", "renderFrame", "w", "h", "bitmap", "Landroid/graphics/Bitmap;", "getDurationMs", "getWidth", "getHeight", "getXOffset", "getYOffset", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MovieFrame implements AnimatedImageFrame {
    private final AnimatedDrawableFrameInfo.DisposalMethod disposalMode;
    private final int frameDuration;
    private final int frameHeight;
    private final int frameStart;
    private final int frameWidth;
    private final MovieDrawer movieDrawer;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getXOffset() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getYOffset() {
        return 0;
    }

    public MovieFrame(MovieDrawer movieDrawer, int i, int i2, int i3, int i4, AnimatedDrawableFrameInfo.DisposalMethod disposalMode) {
        Intrinsics.checkNotNullParameter(movieDrawer, "movieDrawer");
        Intrinsics.checkNotNullParameter(disposalMode, "disposalMode");
        this.movieDrawer = movieDrawer;
        this.frameStart = i;
        this.frameDuration = i2;
        this.frameWidth = i3;
        this.frameHeight = i4;
        this.disposalMode = disposalMode;
    }

    public final AnimatedDrawableFrameInfo.DisposalMethod getDisposalMode() {
        return this.disposalMode;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void renderFrame(int w, int h, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.movieDrawer.drawFrame(this.frameStart, w, h, bitmap);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    /* JADX INFO: renamed from: getDurationMs, reason: from getter */
    public int getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    /* JADX INFO: renamed from: getWidth, reason: from getter */
    public int getFrameWidth() {
        return this.frameWidth;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public int getFrameHeight() {
        return this.frameHeight;
    }
}
