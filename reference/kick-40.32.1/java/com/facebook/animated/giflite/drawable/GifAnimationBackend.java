package com.facebook.animated.giflite.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.animated.giflite.decoder.GifMetadataDecoder;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GifAnimationBackend.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u00012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/facebook/animated/giflite/drawable/GifAnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "gifDecoder", "Lcom/facebook/animated/giflite/decoder/GifMetadataDecoder;", "movie", "Landroid/graphics/Movie;", "<init>", "(Lcom/facebook/animated/giflite/decoder/GifMetadataDecoder;Landroid/graphics/Movie;)V", "frameStartTimes", "", "midX", "", "midY", "drawFrame", "", "parent", "Landroid/graphics/drawable/Drawable;", "canvas", "Landroid/graphics/Canvas;", "frameNumber", "", "setAlpha", "", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setBounds", "bounds", "Landroid/graphics/Rect;", "getIntrinsicWidth", "getIntrinsicHeight", "getSizeInBytes", "clear", "preloadAnimation", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", ViewProps.WIDTH, ViewProps.HEIGHT, "getLoopDurationMs", "getFrameCount", "getFrameDurationMs", "getLoopCount", "getFrameStartTime", "scale", "viewPortWidth", "viewPortHeight", "sourceWidth", "sourceHeight", "Companion", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GifAnimationBackend implements AnimationBackend {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int[] frameStartTimes;
    private final GifMetadataDecoder gifDecoder;
    private float midX;
    private float midY;
    private final Movie movie;

    public /* synthetic */ GifAnimationBackend(GifMetadataDecoder gifMetadataDecoder, Movie movie, DefaultConstructorMarker defaultConstructorMarker) {
        this(gifMetadataDecoder, movie);
    }

    @JvmStatic
    public static final GifAnimationBackend create(String str) throws IOException {
        return INSTANCE.create(str);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int alpha) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(AnimationBackend.Listener listener) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private GifAnimationBackend(GifMetadataDecoder gifMetadataDecoder, Movie movie) {
        this.gifDecoder = gifMetadataDecoder;
        this.movie = movie;
        this.frameStartTimes = new int[gifMetadataDecoder.getFrameCount()];
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable parent, Canvas canvas, int frameNumber) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.movie.setTime(getFrameStartTime(frameNumber));
        this.movie.draw(canvas, this.midX, this.midY);
        return true;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        scale(bounds.right - bounds.left, bounds.bottom - bounds.top, this.movie.width(), this.movie.height());
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.movie.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.movie.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.movie.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.movie.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        int frameCount = getFrameCount();
        int frameDurationMs = 0;
        for (int i = 0; i < frameCount; i++) {
            frameDurationMs += getFrameDurationMs(i);
        }
        return frameDurationMs;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int frameNumber) {
        return this.gifDecoder.getFrameDurationMs(frameNumber);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.gifDecoder.getLoopCount();
    }

    private final int getFrameStartTime(int frameNumber) {
        int i = 0;
        if (frameNumber != 0) {
            int[] iArr = this.frameStartTimes;
            if (frameNumber < iArr.length) {
                int i2 = iArr[frameNumber];
                if (i2 != 0) {
                    return i2;
                }
                while (true) {
                    int[] iArr2 = this.frameStartTimes;
                    if (i < frameNumber) {
                        iArr2[frameNumber] = iArr2[frameNumber] + this.gifDecoder.getFrameDurationMs(i);
                        i++;
                    } else {
                        return iArr2[frameNumber];
                    }
                }
            }
        }
        return 0;
    }

    private final void scale(int viewPortWidth, int viewPortHeight, int sourceWidth, int sourceHeight) {
        int i;
        int i2;
        float f = sourceWidth;
        float f2 = f / sourceHeight;
        float f3 = viewPortWidth;
        float f4 = viewPortHeight;
        float f5 = f3 / f4;
        if (f5 <= f2) {
            if (f5 < f2) {
                i2 = (int) (f3 / f2);
                i = viewPortWidth;
            } else {
                i = viewPortWidth;
            }
            float f6 = i / f;
            this.midX = ((viewPortWidth - i) / 2.0f) / f6;
            this.midY = ((viewPortHeight - i2) / 2.0f) / f6;
        }
        i = (int) (f4 * f2);
        i2 = viewPortHeight;
        float f7 = i / f;
        this.midX = ((viewPortWidth - i) / 2.0f) / f7;
        this.midY = ((viewPortHeight - i2) / 2.0f) / f7;
    }

    /* JADX INFO: compiled from: GifAnimationBackend.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/facebook/animated/giflite/drawable/GifAnimationBackend$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/animated/giflite/drawable/GifAnimationBackend;", "filePath", "", "closeSilently", "", "closeable", "Ljava/io/Closeable;", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final GifAnimationBackend create(String filePath) throws Throwable {
            BufferedInputStream bufferedInputStream = null;
            Object[] objArr = 0;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(filePath));
                try {
                    bufferedInputStream2.mark(Integer.MAX_VALUE);
                    GifMetadataDecoder gifMetadataDecoderCreate = GifMetadataDecoder.create(bufferedInputStream2, null);
                    Intrinsics.checkNotNullExpressionValue(gifMetadataDecoderCreate, "create(...)");
                    bufferedInputStream2.reset();
                    Movie movieDecodeStream = Movie.decodeStream(bufferedInputStream2);
                    Intrinsics.checkNotNull(movieDecodeStream);
                    GifAnimationBackend gifAnimationBackend = new GifAnimationBackend(gifMetadataDecoderCreate, movieDecodeStream, objArr == true ? 1 : 0);
                    closeSilently(bufferedInputStream2);
                    return gifAnimationBackend;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    closeSilently(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private final void closeSilently(Closeable closeable) {
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
