package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MovieDrawer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/animated/giflite/draw/MovieDrawer;", "", "movie", "Landroid/graphics/Movie;", "<init>", "(Landroid/graphics/Movie;)V", "scaleHolder", "Lcom/facebook/animated/giflite/draw/MovieScaleHolder;", "canvas", "Landroid/graphics/Canvas;", "previousBitmap", "Landroid/graphics/Bitmap;", "drawFrame", "", "movieTime", "", "w", "h", "bitmap", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MovieDrawer {
    private final Canvas canvas;
    private final Movie movie;
    private Bitmap previousBitmap;
    private final MovieScaleHolder scaleHolder;

    public MovieDrawer(Movie movie) {
        Intrinsics.checkNotNullParameter(movie, "movie");
        this.movie = movie;
        this.scaleHolder = new MovieScaleHolder(movie.width(), movie.height());
        this.canvas = new Canvas();
    }

    public final synchronized void drawFrame(int movieTime, int w, int h, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.movie.setTime(movieTime);
        Bitmap bitmap2 = this.previousBitmap;
        if (bitmap2 != null && bitmap2.isRecycled()) {
            this.previousBitmap = null;
        }
        if (!Intrinsics.areEqual(this.previousBitmap, bitmap)) {
            this.previousBitmap = bitmap;
            this.canvas.setBitmap(bitmap);
        }
        this.scaleHolder.updateViewPort(w, h);
        this.canvas.save();
        this.canvas.scale(this.scaleHolder.getScale(), this.scaleHolder.getScale());
        this.movie.draw(this.canvas, this.scaleHolder.getLeft(), this.scaleHolder.getTop());
        this.canvas.restore();
    }
}
