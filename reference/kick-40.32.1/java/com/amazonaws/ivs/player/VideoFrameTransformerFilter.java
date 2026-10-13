package com.amazonaws.ivs.player;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
class VideoFrameTransformerFilter implements VideoFilter<DecodedImageBuffer, FrameInfo>, SyncObserver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Filter<FrameInfo, ?> output = null;
    private final VideoFrameTransformer transformer;

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onSyncSourceConnected(SyncSource syncSource) {
    }

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onSyncSourceDisconnected(SyncSource syncSource) {
    }

    VideoFrameTransformerFilter(Consumer<RuntimeException> consumer, Consumer<Object> consumer2, Context context) {
        VideoFrameTransformer videoFrameTransformer = new VideoFrameTransformer(consumer, consumer2);
        this.transformer = videoFrameTransformer;
        Result<EGLException, EGLManager> resultCreate = EGLManager.create();
        if (!resultCreate.isOk()) {
            throw resultCreate.getError();
        }
        Result<EGLException, HardwareInfo> resultCreate2 = HardwareInfo.create(context, resultCreate.getValue());
        if (!resultCreate2.isOk()) {
            throw resultCreate2.getError();
        }
        videoFrameTransformer.init(resultCreate.getValue(), resultCreate2.getValue());
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void play() {
        this.transformer.play();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void pause() {
        this.transformer.pause();
        this.transformer.flush();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void stop() {
        this.transformer.pause();
        this.transformer.flush();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void flush() {
        this.transformer.flush();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void seekTo(long j) {
        this.transformer.setPresentationTimestampPlug(j);
        flush();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<FrameInfo, ?> filter) {
        this.output = filter;
    }

    @Override // com.amazonaws.ivs.player.VideoFilter
    public void setOutputSurface(Surface surface) {
        this.transformer.setOutputSurface(surface);
    }

    @Override // com.amazonaws.ivs.player.VideoFilter
    public Surface getInputSurface() {
        return this.transformer.getInputSurface();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(final DecodedImageBuffer decodedImageBuffer) {
        final Releasable releasable = decodedImageBuffer.releaseCallback;
        decodedImageBuffer.releaseCallback = new Releasable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformerFilter$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Releasable
            public final void release() {
                this.f$0.m11110xafa8a78c(decodedImageBuffer, releasable);
            }
        };
        if (decodedImageBuffer.info.isEndOfStream) {
            Log.d("VideoFrameTransformer", "Have an EOS sample, passing to transformer.");
        }
        this.transformer.submitVideoSample(decodedImageBuffer);
    }

    /* JADX INFO: renamed from: lambda$receive$0$com-amazonaws-ivs-player-VideoFrameTransformerFilter, reason: not valid java name */
    /* synthetic */ void m11110xafa8a78c(DecodedImageBuffer decodedImageBuffer, Releasable releasable) {
        if (decodedImageBuffer.info.isEndOfStream) {
            Log.d("VideoFrameTransformer", "reached EOS");
        }
        Filter<FrameInfo, ?> filter = this.output;
        if (filter != null) {
            filter.receive(decodedImageBuffer.info);
        }
        if (releasable != null) {
            releasable.release();
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
        final VideoFrameTransformer videoFrameTransformer = this.transformer;
        if (handler != null) {
            Objects.requireNonNull(videoFrameTransformer);
            handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformerFilter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    videoFrameTransformer.release();
                }
            });
        } else {
            videoFrameTransformer.release();
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public long bufferDurationMs() {
        return this.transformer.bufferDurationUs() / 1000;
    }

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onTargetTimeChanged(SyncSource syncSource, long j) {
        if (j > 0) {
            this.transformer.setPresentationTimestampPlug(j);
            this.transformer.submitVideoSample(null);
        }
    }
}
