package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Process;
import android.os.Trace;
import android.util.Range;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes5.dex */
class MediaCodecDecoder implements MediaDecoder, VideoRenderer.SurfaceChangeListener {
    private static final long DEQUE_TIMEOUT_US;
    private static final Size SIZE_1080P = new Size(1920, 1080);
    private static final Size SIZE_1088P = new Size(1920, 1088);
    private static final Size SIZE_2160P = new Size(3840, 2160);
    private MediaCodec codec;
    private String codecName;
    private boolean configured;
    private MediaCodec.BufferInfo decodeInfo;
    private final Set<Long> decodeOnlyBuffers;
    private MediaFormat format;
    private boolean hasSurface;
    private long initialSampleTime;
    private int inputBufferIndex;
    private boolean isVideo;
    private Size maxDecodeSize;
    private MediaCrypto mediaCrypto;
    private ByteBuffer outputBuffer;
    private boolean outputBufferEnabled;
    private int outputBufferIndex;
    private int queuedBufferCount;
    private boolean reconfigureRetry;
    private long reconfigureRetryTimeMillis;
    private final MediaRenderer renderer;
    private boolean rendererConfigured;
    private boolean runOnEmulator;
    private boolean supportsAdaptivePlayback;
    private boolean useSoftwareDecoder;

    static {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        DEQUE_TIMEOUT_US = 5000L;
    }

    MediaCodecDecoder(MediaFormat mediaFormat, MediaRenderer mediaRenderer) {
        this.renderer = mediaRenderer;
        this.format = mediaFormat;
        this.decodeOnlyBuffers = new LinkedHashSet();
        resetDecodeInfo();
        if (mediaRenderer == null) {
            this.outputBufferEnabled = true;
        }
    }

    MediaCodecDecoder(MediaFormat mediaFormat, SurfaceRenderer surfaceRenderer) {
        this(mediaFormat, (MediaRenderer) surfaceRenderer);
        boolean z = true;
        this.isVideo = true;
        this.maxDecodeSize = SIZE_1080P;
        if (!Build.MODEL.startsWith("sdk") && !"google_sdk".equals(Build.MODEL) && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK")) {
            z = false;
        }
        this.runOnEmulator = z;
        surfaceRenderer.setSurfaceChangeListener(this);
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public void configure(MediaFormat mediaFormat) throws Exception {
        Trace.beginSection("MediaCodecDecoder configure");
        this.format = mediaFormat;
        DrmSession drmSession = DrmSession.get(mediaFormat);
        MediaCrypto mediaCrypto = drmSession == null ? null : drmSession.getMediaCrypto(mediaFormat);
        if (this.mediaCrypto != mediaCrypto) {
            this.mediaCrypto = mediaCrypto;
            releaseCodec();
        }
        if (this.codec == null) {
            createCodec();
        }
        if (!this.configured || this.runOnEmulator) {
            reconfigure();
        }
        Trace.endSection();
    }

    private void createCodec() {
        String string = this.format.getString("mime");
        MediaCrypto mediaCrypto = this.mediaCrypto;
        boolean z = mediaCrypto != null && mediaCrypto.requiresSecureDecoderComponent(string);
        if (this.isVideo && this.useSoftwareDecoder && !z) {
            this.codec = MediaCodecFactory.createSoftwareCodec(string);
        } else {
            this.codec = MediaCodecFactory.createCodec(string, z);
        }
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null) {
            throw new IllegalStateException("Failed to create codec instance " + string);
        }
        this.codecName = mediaCodec.getName();
        Logging.i("decode " + string + " using " + this.codecName);
        checkCodecCapabilities(string);
    }

    private void reconfigure() throws Exception {
        resetCodec();
        if (this.supportsAdaptivePlayback && this.isVideo && !this.runOnEmulator) {
            this.format.setInteger("max-width", this.maxDecodeSize.width);
            this.format.setInteger("max-height", this.maxDecodeSize.height);
        }
        try {
            Surface surface = this.isVideo ? ((VideoRenderer) this.renderer).getSurface() : null;
            this.codec.configure(this.format, surface, this.mediaCrypto, 0);
            this.hasSurface = surface != null;
            Logging.i("configured " + this.codecName + " format " + this.format);
            this.codec.start();
            this.configured = true;
        } catch (Exception e) {
            Logging.w(this.codecName + " configure failed", e);
            if (this.isVideo) {
                releaseCodec();
                if (!this.useSoftwareDecoder && (e instanceof MediaCodec.CodecException)) {
                    this.useSoftwareDecoder = ((MediaCodec.CodecException) e).getErrorCode() == 1100;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.reconfigureRetryTimeMillis > DurationKt.MILLIS_IN_MINUTE) {
                    this.reconfigureRetry = false;
                    this.reconfigureRetryTimeMillis = jCurrentTimeMillis;
                }
                if (!this.reconfigureRetry) {
                    this.reconfigureRetry = true;
                    createCodec();
                    reconfigure();
                    return;
                }
                throw new IllegalArgumentException("codecName:" + this.codecName + " surface: " + this.hasSurface + " maxDecodeSize:" + this.maxDecodeSize.toString() + " sap:" + this.supportsAdaptivePlayback + " format:" + this.format.toString() + " e:" + e);
            }
            throw e;
        }
    }

    private void checkCodecCapabilities(String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (this.isVideo) {
            this.maxDecodeSize = SIZE_1080P;
        }
        try {
            capabilitiesForType = this.codec.getCodecInfo().getCapabilitiesForType(str);
        } catch (IllegalArgumentException e) {
            Logging.e("Failed to get codec capabilities", e);
            capabilitiesForType = null;
        }
        if (capabilitiesForType != null && this.isVideo) {
            this.supportsAdaptivePlayback = capabilitiesForType.isFeatureSupported("adaptive-playback");
            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Size size = SIZE_2160P;
            if (supportedWidths.contains(Integer.valueOf(size.width)) && videoCapabilities.getSupportedHeightsFor(size.width).contains(Integer.valueOf(size.height))) {
                this.maxDecodeSize = size;
            }
        }
        if (this.isVideo && MediaCodecFactory.limitMaxDecodeSize(this.codec.getName())) {
            this.maxDecodeSize = SIZE_1088P;
        }
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public boolean hasInput() {
        if (this.isVideo && !this.configured) {
            return true;
        }
        if (this.configured) {
            try {
                if (this.codec != null) {
                    try {
                        Trace.beginSection("MediaCodecDecoder hasInput");
                        this.inputBufferIndex = this.codec.dequeueInputBuffer(this.queuedBufferCount > 0 ? DEQUE_TIMEOUT_US : 0L);
                    } catch (IllegalStateException e) {
                        Logging.w(this.codecName + " MediaCodecDecoder dequeueInputBuffer failed", e);
                        resetCodec();
                    }
                    Trace.endSection();
                    return this.inputBufferIndex >= 0;
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        return false;
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public void decode(MediaSample mediaSample) throws Exception {
        Trace.beginSection("MediaCodecDecoder decode " + mediaSample.presentationTimeUs);
        if (this.initialSampleTime <= 0) {
            this.initialSampleTime = mediaSample.decodeTimeUs;
        }
        if (this.isVideo) {
            VideoRenderer videoRenderer = (VideoRenderer) this.renderer;
            if (!this.configured) {
                if (!mediaSample.isSyncSample || videoRenderer.getSurface() == null) {
                    this.configured = false;
                    return;
                }
                Logging.w("MediaCodecDecoder switching surface");
                releaseCodec();
                createCodec();
                reconfigure();
                videoRenderer.configure(this.format);
                try {
                    this.inputBufferIndex = this.codec.dequeueInputBuffer(-1L);
                } catch (Exception e) {
                    Logging.w(this.codecName + " MediaCodecDecoder dequeueInputBuffer failed", e);
                    resetCodec();
                }
            }
        }
        int i = this.inputBufferIndex;
        if (i < 0) {
            throw new PlayerException(ErrorType.ERROR_INVALID_PARAMETER, "invalid buffer index");
        }
        try {
            try {
                queueInput(i, mediaSample);
            } catch (Exception e2) {
                Logging.w(this.codecName + " MediaCodecDecoder queueInput failed", e2);
                resetCodec();
            }
            Trace.endSection();
            this.inputBufferIndex = -1;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private void queueInput(int i, MediaSample mediaSample) {
        this.codec.getInputBuffer(i).put(mediaSample.buffer);
        long j = mediaSample.presentationTimeUs - this.initialSampleTime;
        boolean z = mediaSample.isSyncSample;
        MediaCodec.CryptoInfo cryptoInfo = mediaSample.cryptoInfo;
        MediaCodec mediaCodec = this.codec;
        if (cryptoInfo == null) {
            mediaCodec.queueInputBuffer(i, 0, mediaSample.size, j, z ? 1 : 0);
        } else {
            mediaCodec.queueSecureInputBuffer(i, 0, mediaSample.cryptoInfo, j, z ? 1 : 0);
        }
        this.queuedBufferCount++;
        if (mediaSample.isDecodeOnly) {
            this.decodeOnlyBuffers.add(Long.valueOf(mediaSample.presentationTimeUs));
        }
    }

    private boolean dequeOutput(long j) {
        MediaRenderer mediaRenderer;
        int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.decodeInfo, j);
        this.outputBufferIndex = iDequeueOutputBuffer;
        if (iDequeueOutputBuffer >= 0) {
            this.queuedBufferCount--;
            if ((this.decodeInfo.flags & 4) != 0) {
                Logging.d(this.codecName + " BUFFER_FLAG_END_OF_STREAM");
                resetCodec();
                return false;
            }
            long j2 = this.initialSampleTime + this.decodeInfo.presentationTimeUs;
            boolean zContains = this.decodeOnlyBuffers.contains(Long.valueOf(j2));
            if (this.isVideo) {
                if (!zContains && this.renderer != null) {
                    if (!this.rendererConfigured) {
                        try {
                            configureRenderer(this.codec.getOutputFormat(this.outputBufferIndex));
                        } catch (IllegalStateException e) {
                            Logging.d("Failed to get output format", e);
                            this.rendererConfigured = true;
                            configureRenderer(this.format);
                        }
                    }
                    ((VideoRenderer) this.renderer).render(this.codec, this.outputBufferIndex, j2);
                    return this.inputBufferIndex < 0;
                }
                this.codec.releaseOutputBuffer(this.outputBufferIndex, false);
            } else {
                if (this.outputBufferEnabled) {
                    return true;
                }
                ByteBuffer outputBuffer = this.codec.getOutputBuffer(this.outputBufferIndex);
                if (!zContains && (mediaRenderer = this.renderer) != null && this.rendererConfigured) {
                    mediaRenderer.render(outputBuffer, this.decodeInfo.size, j2);
                }
                this.codec.releaseOutputBuffer(this.outputBufferIndex, false);
            }
        } else {
            if (iDequeueOutputBuffer == -2) {
                Logging.d(this.codecName + " INFO_OUTPUT_FORMAT_CHANGED");
                configureRenderer(this.codec.getOutputFormat());
                return true;
            }
            if (iDequeueOutputBuffer == -3) {
                Logging.d(this.codecName + " INFO_OUTPUT_BUFFERS_CHANGED");
                return true;
            }
        }
        return false;
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public void flush() {
        if (this.codec == null || !this.configured) {
            return;
        }
        Trace.beginSection("MediaCodecDecoder flush adaptive=" + this.supportsAdaptivePlayback);
        if (!this.supportsAdaptivePlayback) {
            if (this.queuedBufferCount == 0) {
                Logging.w(this.codecName + " no buffers queued on flush");
                resetCodec();
                return;
            }
            int i = -1;
            while (i < 0) {
                int iDequeueInputBuffer = this.codec.dequeueInputBuffer(DEQUE_TIMEOUT_US);
                String str = this.codecName;
                if (iDequeueInputBuffer < 0) {
                    Logging.w(str + " wait to queue EOS");
                    dequeOutput(0L);
                } else {
                    Logging.i(str + " queue BUFFER_FLAG_END_OF_STREAM");
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                }
                i = iDequeueInputBuffer;
            }
            while (this.configured) {
                dequeOutput(0L);
            }
        }
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder, com.amazonaws.ivs.player.Releasable
    public void release() {
        Trace.beginSection("MediaCodecDecoder release");
        releaseCodec();
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public void reset() {
        Trace.beginSection("MediaCodecDecoder reset");
        this.initialSampleTime = 0L;
        resetDecodeInfo();
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null && this.configured) {
            if (!this.supportsAdaptivePlayback) {
                resetCodec();
            } else {
                try {
                    mediaCodec.flush();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    resetCodec();
                }
            }
        }
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public boolean hasOutput() {
        boolean z = false;
        try {
            try {
                Trace.beginSection("MediaCodecDecoder hasOutput");
                if (this.configured && dequeOutput(0L) && this.renderer.shouldProcessMore()) {
                    z = true;
                }
                return z;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                Logging.w(this.codecName + " MediaCodecDecoder dequeOutput failed", e);
                return false;
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public ByteBuffer getOutput() {
        if (!this.outputBufferEnabled || this.outputBufferIndex < 0) {
            return null;
        }
        Trace.beginSection("MediaCodecDecoder getOutput");
        ByteBuffer outputBuffer = this.codec.getOutputBuffer(this.outputBufferIndex);
        ByteBuffer byteBuffer = this.outputBuffer;
        if (byteBuffer == null || byteBuffer.capacity() < outputBuffer.capacity()) {
            this.outputBuffer = ByteBuffer.allocateDirect(outputBuffer.capacity());
        }
        this.outputBuffer.clear();
        this.outputBuffer.put(outputBuffer).flip().limit(this.decodeInfo.size);
        this.codec.releaseOutputBuffer(this.outputBufferIndex, false);
        this.outputBufferIndex = -1;
        Trace.endSection();
        return this.outputBuffer;
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public long getOutputTime() {
        return this.initialSampleTime + this.decodeInfo.presentationTimeUs;
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer.SurfaceChangeListener
    public void onSurfaceChange(Surface surface) {
        MediaCodec mediaCodec;
        if (!this.configured || (mediaCodec = this.codec) == null) {
            return;
        }
        if (this.hasSurface && surface != null) {
            mediaCodec.setOutputSurface(surface);
        } else {
            releaseCodec();
        }
    }

    private void configureRenderer(MediaFormat mediaFormat) {
        MediaRenderer mediaRenderer = this.renderer;
        if (mediaRenderer != null) {
            mediaRenderer.configure(mediaFormat);
            this.rendererConfigured = true;
        }
    }

    private void resetCodec() {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            mediaCodec.reset();
        }
        this.configured = false;
        this.hasSurface = false;
    }

    private void releaseCodec() {
        Logging.d("releaseCodec " + this.codec);
        resetDecodeInfo();
        if (this.codec != null) {
            new CodecReleaseThread(this.codec).start();
            this.codec = null;
        }
        this.configured = false;
        this.hasSurface = false;
    }

    private void resetDecodeInfo() {
        this.decodeOnlyBuffers.clear();
        this.decodeInfo = new MediaCodec.BufferInfo();
        this.queuedBufferCount = 0;
        this.inputBufferIndex = -1;
        this.outputBufferIndex = -1;
    }

    @Override // com.amazonaws.ivs.player.MediaDecoder
    public MediaDecoderInfo getInfo() {
        if (this.codec == null) {
            return null;
        }
        return new MediaDecoderInfo(this.codec);
    }

    class CodecReleaseThread extends Thread {
        private final MediaCodec codecToRelease;

        public CodecReleaseThread(MediaCodec mediaCodec) {
            this.codecToRelease = mediaCodec;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MediaCodec mediaCodec;
            if (this.codecToRelease != null) {
                Logging.d("CodecReleaseThread start " + this.codecToRelease + " (" + MediaCodecDecoder.this.codecName + ")");
                try {
                    Process.setThreadPriority(-2);
                } catch (Exception e) {
                    Logging.i("Error while setting thread priority", e);
                }
                try {
                    try {
                        try {
                            this.codecToRelease.stop();
                            mediaCodec = this.codecToRelease;
                        } catch (Exception e2) {
                            Logging.w("Codec stop() failed", e2);
                            mediaCodec = this.codecToRelease;
                        }
                        mediaCodec.release();
                    } catch (Throwable th) {
                        try {
                            this.codecToRelease.release();
                        } catch (Exception e3) {
                            Logging.w("Codec release() failed", e3);
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    Logging.w("Codec release() failed", e4);
                }
                Logging.d("CodecReleaseThread end  (" + MediaCodecDecoder.this.codecName + ")");
            }
        }
    }
}
