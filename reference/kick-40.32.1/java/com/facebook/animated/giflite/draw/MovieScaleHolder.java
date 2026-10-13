package com.facebook.animated.giflite.draw;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: MovieScaleHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/facebook/animated/giflite/draw/MovieScaleHolder;", "", "movieWidth", "", "movieHeight", "<init>", "(II)V", "viewPortWidth", "viewPortHeight", "value", "", "scale", "getScale", "()F", "left", "getLeft", ViewProps.TOP, "getTop", "updateViewPort", "", "determineScaleAndPosition", "animated-gif-lite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MovieScaleHolder {
    private float left;
    private final int movieHeight;
    private final int movieWidth;
    private float scale = 1.0f;
    private float top;
    private int viewPortHeight;
    private int viewPortWidth;

    public MovieScaleHolder(int i, int i2) {
        this.movieWidth = i;
        this.movieHeight = i2;
    }

    public final synchronized float getScale() {
        return this.scale;
    }

    public final synchronized float getLeft() {
        return this.left;
    }

    public final synchronized float getTop() {
        return this.top;
    }

    public final synchronized void updateViewPort(int viewPortWidth, int viewPortHeight) {
        if (this.viewPortWidth == viewPortWidth && this.viewPortHeight == viewPortHeight) {
            return;
        }
        this.viewPortWidth = viewPortWidth;
        this.viewPortHeight = viewPortHeight;
        determineScaleAndPosition();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:12:0x0025, B:16:0x0037, B:14:0x002d, B:15:0x0033, B:8:0x001b), top: B:22:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x002b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x002d A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:12:0x0025, B:16:0x0037, B:14:0x002d, B:15:0x0033, B:8:0x001b), top: B:22:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:12:0x0025, B:16:0x0037, B:14:0x002d, B:15:0x0033, B:8:0x001b), top: B:22:0x0001 }] */
    private final synchronized void determineScaleAndPosition() {
        int i;
        int i2;
        int i3 = this.movieWidth;
        float f = i3 / this.movieHeight;
        int i4 = this.viewPortWidth;
        int i5 = this.viewPortHeight;
        float f2 = i4 / i5;
        if (f2 > f) {
            i = (int) (i5 * f);
        } else {
            if (f2 < f) {
                i2 = (int) (i4 / f);
                i = i4;
            } else {
                i = i4;
            }
            if (i4 > i3) {
                this.scale = i3 / i4;
            } else if (i3 > i4) {
                this.scale = i4 / i3;
            } else {
                this.scale = 1.0f;
            }
            float f3 = (i4 - i) / 2.0f;
            float f4 = this.scale;
            this.left = f3 / f4;
            this.top = ((i5 - i2) / 2.0f) / f4;
        }
        i2 = i5;
        if (i4 > i3) {
            this.scale = i3 / i4;
        } else if (i3 > i4) {
            this.scale = i4 / i3;
        } else {
            this.scale = 1.0f;
        }
        float f5 = (i4 - i) / 2.0f;
        float f6 = this.scale;
        this.left = f5 / f6;
        this.top = ((i5 - i2) / 2.0f) / f6;
    }
}
