package com.amazonaws.ivs.player;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.view.Choreographer;
import android.view.Surface;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class SurfaceRenderer implements MediaRenderer, VideoRenderer, Choreographer.FrameCallback {
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private Choreographer choreographer;
    private int droppedFrames;
    private long frameTimeNanos;
    private Handler handler;
    private boolean hasFutureFrame;
    private boolean invalidateMediaTime;
    private int lastFps;
    private int lastRenderedFrames;
    private long mediaTime;
    private boolean mediaTimeChanged;
    private int renderedFrames;
    private Size size;
    private boolean sizeChanged;
    private WeakReference<VideoRenderer.VideoSizeListener> sizeListener;
    private long startTime;
    private Surface surface;
    private VideoRenderer.SurfaceChangeListener surfaceChangeListener;
    private boolean surfaceChanged;
    private final Object surfaceLock;
    private long syncInterval;
    private long lastMediaTime = -1;
    private long renderPresentationTime = -1;
    private float playbackRate = 1.0f;

    SurfaceRenderer(Context context, VideoRenderer.VideoSizeListener videoSizeListener) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        this.surfaceLock = new Object();
        this.size = new Size(0, 0);
        this.sizeListener = new WeakReference<>(videoSizeListener);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.syncInterval = 33000L;
        this.hasFutureFrame = false;
        this.invalidateMediaTime = true;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            float refreshRate = 1.0f / windowManager.getDefaultDisplay().getRefreshRate();
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            this.syncInterval = (long) (refreshRate * 1000000.0f);
        }
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public Surface getSurface() {
        Surface surface;
        synchronized (this.surfaceLock) {
            surface = this.surface;
        }
        return surface;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public void setSurface(Surface surface) {
        synchronized (this.surfaceLock) {
            if (this.surface != surface) {
                this.surface = surface;
                VideoRenderer.SurfaceChangeListener surfaceChangeListener = this.surfaceChangeListener;
                if (surfaceChangeListener != null) {
                    surfaceChangeListener.onSurfaceChange(surface);
                }
                this.surfaceChanged = true;
                this.sizeChanged = true;
            }
        }
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public void setSurfaceChangeListener(VideoRenderer.SurfaceChangeListener surfaceChangeListener) {
        this.surfaceChangeListener = surfaceChangeListener;
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void configure(MediaFormat mediaFormat) {
        Trace.beginSection("SurfaceRenderer configure");
        int integer = mediaFormat.getInteger(ViewProps.WIDTH);
        int integer2 = mediaFormat.getInteger(ViewProps.HEIGHT);
        if (mediaFormat.containsKey(FORMAT_KEY_CROP_LEFT) && mediaFormat.containsKey(FORMAT_KEY_CROP_RIGHT) && mediaFormat.containsKey(FORMAT_KEY_CROP_TOP) && mediaFormat.containsKey(FORMAT_KEY_CROP_BOTTOM)) {
            int integer3 = mediaFormat.getInteger(FORMAT_KEY_CROP_LEFT);
            integer = (mediaFormat.getInteger(FORMAT_KEY_CROP_RIGHT) - integer3) + 1;
            integer2 = (mediaFormat.getInteger(FORMAT_KEY_CROP_BOTTOM) - mediaFormat.getInteger(FORMAT_KEY_CROP_TOP)) + 1;
        }
        Size size = new Size(integer, integer2);
        Size size2 = this.size;
        if (size2 == null || !size2.equals(size)) {
            boolean z = this.size == null;
            this.size = size;
            this.sizeChanged = true;
            if (z) {
                updateVideoSize();
            }
        }
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void flush() {
        Trace.beginSection("SurfaceRenderer flush");
        this.droppedFrames = 0;
        this.renderedFrames = 0;
        this.lastFps = 0;
        this.lastRenderedFrames = 0;
        this.renderPresentationTime = -1L;
        this.lastMediaTime = -1L;
        this.mediaTime = 0L;
        this.startTime = 0L;
        this.invalidateMediaTime = true;
        this.hasFutureFrame = false;
        Trace.endSection();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd A[Catch: all -> 0x010f, TryCatch #0 {, blocks: (B:31:0x00c6, B:35:0x00cd, B:37:0x00e2, B:36:0x00df), top: B:55:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00df A[Catch: all -> 0x010f, TryCatch #0 {, blocks: (B:31:0x00c6, B:35:0x00cd, B:37:0x00e2, B:36:0x00df), top: B:55:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.amazonaws.ivs.player.VideoRenderer
    public void render(MediaCodec mediaCodec, int i, long j) {
        boolean z;
        Trace.beginSection("SurfaceRenderer render " + j);
        if (this.mediaTime == 0) {
            this.mediaTime = j;
            this.startTime = System.nanoTime();
        }
        long jNanoTime = System.nanoTime();
        long currentMediaTimeUs = getCurrentMediaTimeUs();
        long j2 = (long) ((currentMediaTimeUs > 0 ? j - currentMediaTimeUs : 0L) / this.playbackRate);
        long nanos = jNanoTime + TimeUnit.MICROSECONDS.toNanos(j2);
        boolean z2 = true;
        if (j2 > 0 && j2 <= this.syncInterval * 3) {
            this.hasFutureFrame = false;
            z2 = true;
        } else {
            if (j2 >= (-this.syncInterval) && this.startTime > 0) {
                this.hasFutureFrame = true;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                long j3 = (j2 - 10000) - (this.syncInterval * 2);
                if (j3 > 1000000) {
                    Logging.w("SurfaceRender waiting " + j3 + " us media " + currentMediaTimeUs + " presentation " + j);
                }
                if (j3 >= 10000) {
                    TimeUnit timeUnit3 = TimeUnit.MICROSECONDS;
                    Clock.sleep(Math.min(j3, 1000000L) / 1000);
                }
            } else {
                this.hasFutureFrame = false;
                z = false;
            }
            synchronized (this.surfaceLock) {
                if (this.surface == null) {
                    z = false;
                }
                if (z) {
                    long nanos2 = TimeUnit.MICROSECONDS.toNanos(this.syncInterval);
                    long j4 = this.frameTimeNanos;
                    mediaCodec.releaseOutputBuffer(i, j4 + (nanos2 * ((nanos - j4) / nanos2)));
                } else {
                    mediaCodec.releaseOutputBuffer(i, z);
                }
            }
            if (z) {
                this.renderedFrames++;
                updateVideoSize();
                if (this.surfaceChanged) {
                    this.surfaceChanged = false;
                }
                if (this.mediaTimeChanged) {
                    this.mediaTimeChanged = false;
                }
            } else if (!this.surfaceChanged && !this.mediaTimeChanged) {
                this.droppedFrames++;
            }
            this.renderPresentationTime = j;
            Trace.endSection();
        }
        z = z2;
        synchronized (this.surfaceLock) {
            if (this.surface == null) {
                z = false;
            }
            if (z) {
                long nanos3 = TimeUnit.MICROSECONDS.toNanos(this.syncInterval);
                long j5 = this.frameTimeNanos;
                mediaCodec.releaseOutputBuffer(i, j5 + (nanos3 * ((nanos - j5) / nanos3)));
            } else {
                mediaCodec.releaseOutputBuffer(i, z);
            }
            if (z) {
                this.renderedFrames++;
                updateVideoSize();
                if (this.surfaceChanged) {
                    this.surfaceChanged = false;
                }
                if (this.mediaTimeChanged) {
                    this.mediaTimeChanged = false;
                }
            } else if (!this.surfaceChanged) {
                this.droppedFrames++;
            }
            this.renderPresentationTime = j;
            Trace.endSection();
        }
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void render(ByteBuffer byteBuffer, int i, long j) {
        this.renderPresentationTime = j;
        this.renderedFrames++;
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void start() {
        Trace.beginSection("SurfaceRenderer start");
        this.startTime = System.nanoTime();
        addFrameCallback();
        this.invalidateMediaTime = true;
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void stop() {
        Trace.beginSection("SurfaceRenderer stop");
        this.startTime = 0L;
        this.mediaTime = 0L;
        removeFrameCallback();
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer, com.amazonaws.ivs.player.Releasable
    public void release() {
        Trace.beginSection("SurfaceRenderer release");
        removeFrameCallback();
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public long getRenderedPresentationTime() {
        return Math.min(getCurrentMediaTimeUs(), this.renderPresentationTime);
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public boolean shouldProcessMore() {
        return !this.hasFutureFrame;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public void setMediaTime(long j) {
        if (j <= 0) {
            this.mediaTime = 0L;
            Logging.d("SurfaceRenderer reset time");
        } else if (this.invalidateMediaTime) {
            this.mediaTime = j;
            this.startTime = System.nanoTime();
            this.invalidateMediaTime = false;
            this.mediaTimeChanged = true;
            Logging.d("SurfaceRenderer set media time " + this.mediaTime);
        } else {
            long currentMediaTimeUs = getCurrentMediaTimeUs();
            long jMin = Math.min(Math.abs(currentMediaTimeUs - j), this.syncInterval);
            if (jMin > 1000) {
                long j2 = this.mediaTime;
                if (currentMediaTimeUs > j) {
                    if (j2 <= jMin) {
                        this.mediaTime = currentMediaTimeUs;
                        this.startTime = System.nanoTime();
                    }
                    this.mediaTime -= jMin;
                } else {
                    this.mediaTime = j2 + jMin;
                }
            }
        }
        this.lastMediaTime = j;
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void setPlaybackRate(float f) {
        if (this.playbackRate != f) {
            this.playbackRate = f;
            this.mediaTime = 0L;
            this.startTime = 0L;
        }
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public int getDroppedFrames() {
        return this.droppedFrames;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public int getRenderedFrames() {
        return this.renderedFrames;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public int getFrameRate() {
        return this.lastFps;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer
    public Size getVideoSize() {
        return this.size;
    }

    private void updateVideoSize() {
        if (this.sizeChanged) {
            this.sizeChanged = false;
            VideoRenderer.VideoSizeListener videoSizeListener = this.sizeListener.get();
            if (videoSizeListener != null) {
                videoSizeListener.onSizeChange(this.size.width, this.size.height);
            }
        }
    }

    private long getCurrentMediaTimeUs() {
        if (this.mediaTime <= 0) {
            return -1L;
        }
        long jNanoTime = (long) ((System.nanoTime() - this.startTime) * this.playbackRate);
        long j = this.mediaTime;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return j + (jNanoTime / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Choreographer getChoreographer() {
        if (this.choreographer == null) {
            this.choreographer = Choreographer.getInstance();
        }
        return this.choreographer;
    }

    private void addFrameCallback() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.SurfaceRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                SurfaceRenderer.this.getChoreographer().postFrameCallback(SurfaceRenderer.this);
            }
        });
    }

    private void removeFrameCallback() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.SurfaceRenderer.2
            @Override // java.lang.Runnable
            public void run() {
                SurfaceRenderer.this.getChoreographer().removeFrameCallback(SurfaceRenderer.this);
            }
        });
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.frameTimeNanos = j;
        int i = this.renderedFrames;
        this.lastFps = i - this.lastRenderedFrames;
        this.lastRenderedFrames = i;
        getChoreographer().postFrameCallbackDelayed(this, 1000L);
    }
}
