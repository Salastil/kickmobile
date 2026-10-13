package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.view.Surface;

/* JADX INFO: loaded from: classes5.dex */
interface VideoRenderer extends MediaRenderer {

    public interface SurfaceChangeListener {
        void onSurfaceChange(Surface surface);
    }

    public interface VideoSizeListener {
        void onSizeChange(int i, int i2);
    }

    int getDroppedFrames();

    int getFrameRate();

    int getRenderedFrames();

    Surface getSurface();

    Size getVideoSize();

    void render(MediaCodec mediaCodec, int i, long j);

    void setMediaTime(long j);

    void setSurface(Surface surface);

    void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener);
}
