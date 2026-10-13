package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import android.util.Range;
import android.view.Surface;
import androidx.camera.video.internal.utils.MediaFormatExt;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.react.uimanager.ViewProps;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
class VideoDecoder extends Decoder implements VideoFilter<Pullable<MediaSample>, DecodedImageBuffer>, SyncObserver {
    private static final String TAG = "VideoDecoder";
    private long actualPlayheadUs;
    private VideoDecoderConfig config;
    private VideoFilter<DecodedImageBuffer, ?> outputFilter;
    private Surface outputSurface;
    private final long playheadToleranceUs;

    @Override // com.amazonaws.ivs.player.VideoFilter
    public Surface getInputSurface() {
        return null;
    }

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onSyncSourceConnected(SyncSource syncSource) {
    }

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onSyncSourceDisconnected(SyncSource syncSource) {
    }

    static class VideoDecoderConfig {
        private static final int HEIGHT_1080P = 1080;
        private static final int HEIGHT_2160P = 2160;
        private static final int WIDTH_1080P = 1920;
        private static final int WIDTH_2160P = 3840;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        final int maxHeight;
        final int maxWidth;
        final boolean supportsAdaptivePlayback;
        MediaCodecInfo.VideoCapabilities videoCapabilities;

        /* JADX WARN: Code duplicated, block: B:18:0x0052  */
        VideoDecoderConfig(MediaCodec mediaCodec, String str) {
            int i;
            int i2;
            try {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(str);
                this.codecCapabilities = capabilitiesForType;
                this.videoCapabilities = capabilitiesForType.getVideoCapabilities();
            } catch (IllegalArgumentException e) {
                this.codecCapabilities = null;
                Logging.e("Failed to get codec capabilities", e);
            }
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.codecCapabilities;
            int i3 = HEIGHT_1080P;
            int i4 = WIDTH_1080P;
            if (codecCapabilities != null) {
                this.supportsAdaptivePlayback = codecCapabilities.isFeatureSupported("adaptive-playback");
                try {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = this.videoCapabilities;
                    i2 = WIDTH_2160P;
                    Range<Integer> supportedHeightsFor = videoCapabilities.getSupportedHeightsFor(WIDTH_2160P);
                    i = HEIGHT_2160P;
                    if (!supportedHeightsFor.contains(Integer.valueOf(HEIGHT_2160P))) {
                    }
                } catch (IllegalArgumentException unused) {
                }
                if (!MediaCodecFactory.limitMaxDecodeSize(mediaCodec.getName())) {
                    i4 = i2;
                    i3 = i;
                }
                this.maxWidth = i4;
                this.maxHeight = i3;
            }
            this.supportsAdaptivePlayback = false;
            i = HEIGHT_1080P;
            i2 = WIDTH_1080P;
            if (!MediaCodecFactory.limitMaxDecodeSize(mediaCodec.getName())) {
                i4 = i2;
                i3 = i;
            }
            this.maxWidth = i4;
            this.maxHeight = i3;
        }

        private VideoDecoderConfig() {
            this.codecCapabilities = null;
            this.videoCapabilities = null;
            this.supportsAdaptivePlayback = false;
            this.maxWidth = WIDTH_1080P;
            this.maxHeight = HEIGHT_1080P;
        }
    }

    VideoDecoder(Decoder.Listener listener) {
        super(listener, MediaSample.TrackID.VIDEO, "MediaSink.video", -10);
        this.actualPlayheadUs = 0L;
        this.playheadToleranceUs = 100000L;
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected String tag() {
        return TAG;
    }

    void initialize(MediaFormat mediaFormat) {
        super.initialize(mediaFormat, false);
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected void configure() {
        VideoDecoderConfig videoDecoderConfig = new VideoDecoderConfig(this.decoder, this.decoderFormat.getString("mime"));
        this.config = videoDecoderConfig;
        if (videoDecoderConfig.supportsAdaptivePlayback) {
            this.decoderFormat.setInteger("max-width", this.config.maxWidth);
            this.decoderFormat.setInteger("max-height", this.config.maxHeight);
        }
        try {
            this.decoder.configure(this.decoderFormat, this.outputSurface, this.mediaCrypto, 0);
            changeState(Decoder.InternalState.CONFIGURED);
            if (this.listener != null) {
                this.listener.onInputFormatChanged(this.trackId, this, this.decoderFormat);
            }
            changeState(Decoder.InternalState.FLUSHED);
        } catch (MediaCodec.CodecException e) {
            onError(this.decoder, e);
        } catch (IllegalStateException e2) {
            onError(new Decoder.DecoderException(new IllegalStateException("MediaCodec state out of sync with decoder (start)", e2), false, -1));
        }
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected boolean shouldReconfigureForFormat(String str, String str2) {
        return (this.config.supportsAdaptivePlayback && str2.equals(str)) ? false : true;
    }

    @Override // com.amazonaws.ivs.player.VideoFilter
    public void setOutputSurface(Surface surface) {
        this.outputSurface = surface;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<DecodedImageBuffer, ?> filter) {
        VideoFilter<DecodedImageBuffer, ?> videoFilter = (VideoFilter) filter;
        this.outputFilter = videoFilter;
        setOutputSurface(videoFilter.getInputSurface());
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(Pullable<MediaSample> pullable) {
        this.upstream = pullable;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
        endOfStream();
        if (changeState(Decoder.InternalState.RELEASED)) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.VideoDecoder$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.releaseInternal();
                    }
                });
            } else {
                releaseInternal();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        if (getCurrentState() == Decoder.InternalState.RELEASED) {
            try {
                this.decoder.stop();
            } catch (Exception e) {
                Log.e(TAG, "Caught error stopping decoder: " + e);
            }
            try {
                this.decoder.release();
            } catch (Exception e2) {
                Log.e(TAG, "Caught error releasing decoder: " + e2);
            }
            this.handler.getLooper().quitSafely();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(final MediaCodec mediaCodec, final int i, final MediaCodec.BufferInfo bufferInfo) {
        final boolean z = (bufferInfo.flags & 4) > 0;
        final boolean zShouldRenderFrame = shouldRenderFrame(bufferInfo);
        if (z && this.awaitingReconfigure) {
            handleReconfiguration();
            return;
        }
        final DecodedImageBuffer decodedImageBuffer = new DecodedImageBuffer(new FrameInfo(bufferInfo.presentationTimeUs, 0L, z), i);
        decodedImageBuffer.releaseCallback = new Releasable() { // from class: com.amazonaws.ivs.player.VideoDecoder$$ExternalSyntheticLambda0
            @Override // com.amazonaws.ivs.player.Releasable
            public final void release() {
                this.f$0.m11090x4f1b6962(decodedImageBuffer, bufferInfo, mediaCodec, i, z);
            }
        };
        decodedImageBuffer.render = new Callable() { // from class: com.amazonaws.ivs.player.VideoDecoder$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m11091x181c60a3(decodedImageBuffer, zShouldRenderFrame, bufferInfo, z, mediaCodec, i);
            }
        };
        if (this.outputFilter != null && (zShouldRenderFrame || z)) {
            this.currentPlayhead = Math.max(this.currentPlayhead, bufferInfo.presentationTimeUs);
            this.outputFilter.receive(decodedImageBuffer);
        } else {
            decodedImageBuffer.release();
        }
        if (this.listener != null) {
            this.listener.onFrameDecoded(this.trackId, this, bufferInfo.presentationTimeUs);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    /* JADX INFO: renamed from: lambda$onOutputBufferAvailable$0$com-amazonaws-ivs-player-VideoDecoder, reason: not valid java name */
    /* synthetic */ void m11090x4f1b6962(DecodedImageBuffer decodedImageBuffer, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i, boolean z) {
        VideoDecoder videoDecoder;
        if (decodedImageBuffer.rendered || !isExpected(bufferInfo.presentationTimeUs)) {
            videoDecoder = this;
        } else {
            try {
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (MediaCodec.CodecException e) {
                onError(mediaCodec, e);
            } catch (IllegalStateException unused) {
            }
            if (this.listener != null) {
                videoDecoder = this;
                this.listener.onFrameRendered(this.trackId, videoDecoder, bufferInfo.presentationTimeUs, false, z);
            } else {
                videoDecoder = this;
            }
        }
        videoDecoder.removeExpected(bufferInfo.presentationTimeUs);
    }

    /* JADX INFO: renamed from: lambda$onOutputBufferAvailable$1$com-amazonaws-ivs-player-VideoDecoder, reason: not valid java name */
    /* synthetic */ Boolean m11091x181c60a3(DecodedImageBuffer decodedImageBuffer, boolean z, MediaCodec.BufferInfo bufferInfo, boolean z2, MediaCodec mediaCodec, int i) throws Exception {
        VideoDecoder videoDecoder;
        decodedImageBuffer.rendered = z;
        if (!z || !isExpected(bufferInfo.presentationTimeUs)) {
            return false;
        }
        try {
            try {
                if (this.listener != null) {
                    videoDecoder = this;
                    try {
                        this.listener.onFrameRendered(this.trackId, videoDecoder, bufferInfo.presentationTimeUs, false, z2);
                    } catch (MediaCodec.CodecException e) {
                        e = e;
                        videoDecoder.onError(mediaCodec, e);
                    }
                } else {
                    videoDecoder = this;
                }
                mediaCodec.releaseOutputBuffer(i, bufferInfo.presentationTimeUs * 1000);
            } catch (MediaCodec.CodecException e2) {
                e = e2;
                videoDecoder = this;
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "IllegalStateException " + bufferInfo.presentationTimeUs);
        }
        return true;
    }

    private boolean shouldRenderFrame(MediaCodec.BufferInfo bufferInfo) {
        Decoder.InternalState currentState = getCurrentState();
        return (currentState == Decoder.InternalState.RUNNING || currentState == Decoder.InternalState.PAUSED) && bufferInfo.presentationTimeUs >= this.currentPlayhead && this.actualPlayheadUs - bufferInfo.presentationTimeUs < 100000 && isExpected(bufferInfo.presentationTimeUs);
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected String hashMediaFormat(MediaFormat mediaFormat) {
        String str;
        int integer = mediaFormat.getInteger(ViewProps.WIDTH);
        int integer2 = mediaFormat.getInteger(ViewProps.HEIGHT);
        String string = mediaFormat.getString("mime");
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(MediaFormatExt.KEY_CSD_0);
        ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer(MediaFormatExt.KEY_CSD_1);
        String str2 = "";
        if (byteBuffer != null) {
            str = WebViewLogEventConsumer.DDTAGS_SEPARATOR + byteBuffer.hashCode();
        } else {
            str = "";
        }
        if (byteBuffer2 != null) {
            str2 = WebViewLogEventConsumer.DDTAGS_SEPARATOR + byteBuffer2.hashCode();
        }
        return WebViewLogEventConsumer.DDTAGS_SEPARATOR + integer + WebViewLogEventConsumer.DDTAGS_SEPARATOR + integer2 + WebViewLogEventConsumer.DDTAGS_SEPARATOR + string + str + str2;
    }

    @Override // com.amazonaws.ivs.player.Decoder, com.amazonaws.ivs.player.Filter
    public void seekTo(long j) {
        super.seekTo(j);
        this.actualPlayheadUs = j;
    }

    @Override // com.amazonaws.ivs.player.SyncObserver
    public void onTargetTimeChanged(SyncSource syncSource, long j) {
        this.actualPlayheadUs = j;
    }
}
