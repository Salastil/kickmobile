package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
class AudioDecoder extends Decoder implements Filter<Pullable<MediaSample>, DecodedAudioBuffer> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "AudioDecoder";
    private final ArrayDeque<ByteBuffer> audioBuffers;
    private Filter<DecodedAudioBuffer, ?> outputFilter;

    AudioDecoder(Decoder.Listener listener) {
        super(listener, MediaSample.TrackID.AUDIO, "MediaSink.audio", -16);
        this.audioBuffers = new ArrayDeque<>();
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected String tag() {
        return TAG;
    }

    @Override // com.amazonaws.ivs.player.Decoder
    protected void configure() {
        try {
            this.decoder.configure(this.decoderFormat, (Surface) null, this.mediaCrypto, 0);
            changeState(Decoder.InternalState.CONFIGURED);
            if (this.listener != null) {
                this.listener.onInputFormatChanged(this.trackId, this, this.decoderFormat);
            }
            changeState(Decoder.InternalState.FLUSHED);
        } catch (MediaCodec.CodecException e) {
            onError(this.decoder, e);
        } catch (IllegalStateException e2) {
            onError(new Decoder.DecoderException(new IllegalStateException("MediaCodec state out of sync with decoder (configure)", e2), false, -1));
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void processException(Exception exc) {
        Filter<DecodedAudioBuffer, ?> filter = this.outputFilter;
        if (filter != null) {
            filter.processException(exc);
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<DecodedAudioBuffer, ?> filter) {
        this.outputFilter = filter;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(Pullable<MediaSample> pullable) {
        this.upstream = pullable;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
        if (!changeState(Decoder.InternalState.RELEASED)) {
            Log.d(TAG, "Release failed - decoder already in RELEASED state");
        } else if (handler != null) {
            handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioDecoder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.releaseInternal();
                }
            });
        } else {
            releaseInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        if (getCurrentState() == Decoder.InternalState.RELEASED) {
            Log.i(TAG, "Releasing Audio Codec");
            clearBufferQueue();
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
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.handler.post(new AudioDecoder$$ExternalSyntheticLambda2(countDownLatch));
            try {
                countDownLatch.await();
            } catch (Exception unused) {
            }
            this.handler.getLooper().quit();
            Log.i(TAG, "Done releasing Audio Codec");
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(final MediaCodec mediaCodec, final int i, final MediaCodec.BufferInfo bufferInfo) {
        ByteBuffer byteBufferAllocateDirect;
        Decoder.InternalState currentState = getCurrentState();
        if (currentState != Decoder.InternalState.RUNNING && currentState != Decoder.InternalState.PAUSED) {
            Log.e(TAG, "Not running, releasing buffer");
            try {
                if (isExpected(bufferInfo.presentationTimeUs)) {
                    removeExpected(bufferInfo.presentationTimeUs);
                    mediaCodec.releaseOutputBuffer(i, false);
                    return;
                }
                return;
            } catch (MediaCodec.CodecException e) {
                onError(this.decoder, e);
                return;
            } catch (IllegalStateException unused) {
                return;
            }
        }
        boolean z = true;
        boolean z2 = (bufferInfo.flags & 4) > 0;
        if (z2) {
            Log.d(TAG, "onOutputBufferAvailable EOS");
            if (this.awaitingReconfigure && isExpected(bufferInfo.presentationTimeUs)) {
                try {
                    removeExpected(bufferInfo.presentationTimeUs);
                    mediaCodec.releaseOutputBuffer(i, false);
                } catch (MediaCodec.CodecException e2) {
                    onError(this.decoder, e2);
                    return;
                } catch (IllegalStateException unused2) {
                    Log.w(TAG, "Attempted to release a discarded index after flush");
                }
                handleReconfiguration();
                return;
            }
        }
        if ((bufferInfo.presentationTimeUs < this.currentPlayhead || !isExpected(bufferInfo.presentationTimeUs)) && !z2) {
            z = false;
        }
        try {
            ByteBuffer outputBuffer = this.decoder.getOutputBuffer(i);
            if (outputBuffer == null || !z) {
                try {
                    removeExpected(bufferInfo.presentationTimeUs);
                    mediaCodec.releaseOutputBuffer(i, false);
                    return;
                } catch (MediaCodec.CodecException e3) {
                    onError(this.decoder, e3);
                    return;
                } catch (IllegalStateException unused3) {
                    Log.w(TAG, "Attempted to release a discarded index after flush");
                    return;
                }
            }
            if (this.audioBuffers.isEmpty()) {
                byteBufferAllocateDirect = null;
            } else {
                byteBufferAllocateDirect = this.audioBuffers.remove();
                byteBufferAllocateDirect.rewind();
            }
            if (byteBufferAllocateDirect == null || byteBufferAllocateDirect.capacity() < bufferInfo.size) {
                byteBufferAllocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
            }
            outputBuffer.rewind();
            byteBufferAllocateDirect.put(outputBuffer);
            byteBufferAllocateDirect.rewind();
            DecodedAudioBuffer decodedAudioBuffer = getDecodedAudioBuffer(i, bufferInfo, byteBufferAllocateDirect);
            decodedAudioBuffer.releaseCallback = new Releasable() { // from class: com.amazonaws.ivs.player.AudioDecoder$$ExternalSyntheticLambda3
                @Override // com.amazonaws.ivs.player.Releasable
                public final void release() {
                    this.f$0.m11005xf952f5a7(bufferInfo, mediaCodec, i);
                }
            };
            this.currentPlayhead = Math.max(bufferInfo.presentationTimeUs, this.currentPlayhead);
            Filter<DecodedAudioBuffer, ?> filter = this.outputFilter;
            if (filter != null) {
                filter.receive(decodedAudioBuffer);
            } else {
                decodedAudioBuffer.release();
            }
        } catch (MediaCodec.CodecException e4) {
            onError(this.decoder, e4);
        } catch (IllegalStateException unused4) {
            Log.w(TAG, "Attempted to get a buffer for a stale index");
        }
    }

    /* JADX INFO: renamed from: lambda$onOutputBufferAvailable$0$com-amazonaws-ivs-player-AudioDecoder, reason: not valid java name */
    /* synthetic */ void m11005xf952f5a7(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
        if (isExpected(bufferInfo.presentationTimeUs)) {
            try {
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (MediaCodec.CodecException e) {
                onError(this.decoder, e);
            } catch (IllegalStateException unused) {
                Log.w(TAG, "Attempted to release a discarded index after flush");
            }
            removeExpected(bufferInfo.presentationTimeUs);
        }
    }

    private DecodedAudioBuffer getDecodedAudioBuffer(int i, MediaCodec.BufferInfo bufferInfo, final ByteBuffer byteBuffer) {
        long integer = this.decoderFormat.getInteger("sample-rate");
        if (integer <= 0) {
            Log.e(TAG, "Invalid sample rate: " + integer + ", using default of 44100");
            integer = 44100;
        }
        long integer2 = ((((long) bufferInfo.size) / (((long) this.decoderFormat.getInteger("channel-count")) * 2)) * 1000000) / integer;
        if (integer2 == 0) {
            Log.w(TAG, "buffer duration is 0?");
        }
        return new DecodedAudioBuffer(byteBuffer, bufferInfo.size, new FrameInfo(bufferInfo.presentationTimeUs, integer2, (bufferInfo.flags & 4) > 0), i, new Releasable() { // from class: com.amazonaws.ivs.player.AudioDecoder$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Releasable
            public final void release() {
                this.f$0.m11004x72b074f6(byteBuffer);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getDecodedAudioBuffer$2$com-amazonaws-ivs-player-AudioDecoder, reason: not valid java name */
    /* synthetic */ void m11004x72b074f6(final ByteBuffer byteBuffer) {
        if (getCurrentState() != Decoder.InternalState.RELEASED) {
            this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioDecoder$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11003xa9af7db5(byteBuffer);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$getDecodedAudioBuffer$1$com-amazonaws-ivs-player-AudioDecoder, reason: not valid java name */
    /* synthetic */ void m11003xa9af7db5(ByteBuffer byteBuffer) {
        this.audioBuffers.add(byteBuffer);
    }
}
