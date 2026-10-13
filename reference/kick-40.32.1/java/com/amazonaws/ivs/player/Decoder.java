package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Decoder extends MediaCodec.Callback {
    protected static final int BYTES_PER_SAMPLE = 2;
    protected static final int MICROSECONDS_PER_SECOND = 1000000;
    protected static final int RETRY_DELAY_MS = 100;
    protected boolean awaitingReconfigure;
    protected final ArrayDeque<Integer> bufferQueue;
    protected long currentPlayhead;
    protected MediaCodec decoder;
    protected MediaFormat decoderFormat;
    protected final ArrayDeque<Long> expectedTimestamps;
    protected String formatHash;
    protected Handler handler;
    protected final Listener listener;
    protected MediaCrypto mediaCrypto;
    protected MediaSample nextSample;
    protected final Fsm<InternalState> state;
    protected final Map<InternalState, Runnable> stateCallbacks;
    protected final MediaSample.TrackID trackId;
    protected Pullable<MediaSample> upstream;

    interface Listener {
        void onError(MediaSample.TrackID trackID, Decoder decoder, DecoderException decoderException);

        void onFrameDecoded(MediaSample.TrackID trackID, Decoder decoder, long j);

        void onFrameRendered(MediaSample.TrackID trackID, Decoder decoder, long j, boolean z, boolean z2);

        void onInputFormatChanged(MediaSample.TrackID trackID, Decoder decoder, MediaFormat mediaFormat);

        void onNeedMoreData(MediaSample.TrackID trackID, Decoder decoder);

        void onOutputFormatChanged(MediaSample.TrackID trackID, Decoder decoder, MediaFormat mediaFormat);
    }

    protected abstract void configure();

    protected abstract String tag();

    protected enum InternalState {
        ERROR,
        UNINITIALIZED,
        INITIALIZING,
        CONFIGURED,
        FLUSHING,
        FLUSHED,
        RUNNING,
        PAUSED,
        RELEASED;

        static Map<InternalState, List<InternalState>> transitions() {
            HashMap map = new HashMap();
            InternalState internalState = ERROR;
            InternalState internalState2 = UNINITIALIZED;
            InternalState internalState3 = RELEASED;
            map.put(internalState, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState2, internalState3}));
            InternalState internalState4 = INITIALIZING;
            map.put(internalState2, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState4, internalState3}));
            InternalState internalState5 = CONFIGURED;
            map.put(internalState4, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState5, internalState3, internalState}));
            InternalState internalState6 = FLUSHED;
            map.put(internalState5, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState6, internalState3}));
            InternalState internalState7 = FLUSHING;
            map.put(internalState7, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState6, internalState}));
            InternalState internalState8 = RUNNING;
            map.put(internalState6, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState8, internalState, internalState2, internalState3}));
            InternalState internalState9 = PAUSED;
            map.put(internalState8, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState9, internalState, internalState7, internalState2, internalState3}));
            map.put(internalState9, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState8, internalState, internalState7, internalState2, internalState3}));
            map.put(internalState3, Collections.EMPTY_LIST);
            return map;
        }
    }

    protected Decoder(Listener listener, MediaSample.TrackID trackID, String str, int i) {
        this.awaitingReconfigure = false;
        this.nextSample = null;
        this.formatHash = "";
        this.state = new Fsm<>(InternalState.transitions(), InternalState.UNINITIALIZED);
        this.stateCallbacks = new HashMap();
        this.listener = listener;
        this.trackId = trackID;
        HandlerThread handlerThread = new HandlerThread(str, i);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
        this.currentPlayhead = 0L;
        this.bufferQueue = new ArrayDeque<>();
        this.expectedTimestamps = new ArrayDeque<>();
    }

    protected Decoder() {
        this.awaitingReconfigure = false;
        this.nextSample = null;
        this.formatHash = "";
        this.state = new Fsm<>(InternalState.transitions(), InternalState.UNINITIALIZED);
        this.stateCallbacks = new HashMap();
        this.listener = null;
        this.trackId = null;
        this.bufferQueue = new ArrayDeque<>();
        this.expectedTimestamps = new ArrayDeque<>();
    }

    public MediaCodec getCodec() {
        return this.decoder;
    }

    protected InternalState getCurrentState() {
        InternalState currentState;
        synchronized (this.state) {
            currentState = this.state.getCurrentState();
        }
        return currentState;
    }

    protected void awaitState(InternalState internalState) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.stateCallbacks.put(internalState, new AudioDecoder$$ExternalSyntheticLambda2(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    protected boolean changeState(InternalState internalState) {
        Runnable runnableRemove;
        synchronized (this.state) {
            Log.d(tag(), String.format("changeState: %s -> %s", this.state.getCurrentState(), internalState));
            if (!this.state.changeState(internalState)) {
                Log.w(tag(), "Could not move to " + internalState);
                return false;
            }
            if (this.stateCallbacks.containsKey(internalState) && (runnableRemove = this.stateCallbacks.remove(internalState)) != null) {
                runnableRemove.run();
            }
            return true;
        }
    }

    protected void initialize(MediaFormat mediaFormat, boolean z) {
        if (changeState(InternalState.INITIALIZING)) {
            this.decoderFormat = mediaFormat;
            this.formatHash = hashMediaFormat(mediaFormat);
            DrmSession drmSession = DrmSession.get(mediaFormat);
            this.mediaCrypto = drmSession == null ? null : drmSession.getMediaCrypto(mediaFormat);
            MediaCodec mediaCodecCreateCodec = createCodec(mediaFormat, z);
            this.decoder = mediaCodecCreateCodec;
            if (!z && mediaCodecCreateCodec == null) {
                this.decoder = createCodec(mediaFormat, true);
            }
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec == null) {
                changeState(InternalState.ERROR);
                onError(new DecoderException(new IllegalStateException("Decoder could not be created"), false, -2));
            } else {
                mediaCodec.setCallback(this, this.handler);
                configure();
            }
        }
    }

    protected MediaCodec createCodec(MediaFormat mediaFormat, boolean z) {
        String string = mediaFormat.getString("mime");
        MediaCrypto mediaCrypto = this.mediaCrypto;
        boolean z2 = mediaCrypto != null && mediaCrypto.requiresSecureDecoderComponent(string);
        if (z && z2) {
            throw new IllegalStateException("Cannot use software decoder with secure content that requires hardware decoder");
        }
        if (z) {
            return MediaCodecFactory.createSoftwareCodec(string);
        }
        return MediaCodecFactory.createCodec(string, z2);
    }

    public void play() {
        if (this.state.compareAndSet(InternalState.FLUSHED, InternalState.RUNNING)) {
            try {
                this.decoder.start();
                return;
            } catch (MediaCodec.CodecException e) {
                onError(this.decoder, e);
                return;
            } catch (IllegalStateException e2) {
                Log.e(tag(), "MediaCodec state out of sync with decoder: " + e2);
                onError(new DecoderException(new IllegalStateException("MediaCodec state out of sync with decoder (start)", e2), true, -1));
                return;
            }
        }
        if (changeState(InternalState.RUNNING)) {
            maybeSubmitBuffers();
        }
    }

    public void pause() {
        changeState(InternalState.PAUSED);
    }

    public void stop() {
        Log.d(tag(), "stop()");
        if (changeState(InternalState.UNINITIALIZED)) {
            this.decoder.stop();
            clearBufferQueue();
        }
    }

    public void flush() {
        if (getCurrentState() == InternalState.FLUSHED) {
            clearBufferQueue();
            return;
        }
        if (changeState(InternalState.FLUSHING)) {
            try {
                this.formatHash = "";
                clearBufferQueue();
                this.decoder.flush();
                this.nextSample = null;
                changeState(InternalState.FLUSHED);
            } catch (MediaCodec.CodecException e) {
                onError(this.decoder, e);
            } catch (IllegalStateException e2) {
                Log.e(tag(), "MediaCodec state out of sync with decoder: " + e2);
                onError(new DecoderException(new IllegalStateException("MediaCodec state out of sync with decoder (flush)", e2), false, -1));
            }
        }
    }

    public void reset() {
        stop();
        clearBufferQueue();
        this.nextSample = null;
    }

    public void endOfStream() {
        this.handler.post(new Decoder$$ExternalSyntheticLambda0(this));
    }

    public void seekTo(long j) {
        flush();
        this.currentPlayhead = j;
    }

    protected void clearBufferQueue() {
        synchronized (this.bufferQueue) {
            this.bufferQueue.clear();
        }
        synchronized (this.expectedTimestamps) {
            this.expectedTimestamps.clear();
        }
    }

    protected boolean isExpected(long j) {
        boolean zContains;
        synchronized (this.expectedTimestamps) {
            zContains = this.expectedTimestamps.contains(Long.valueOf(j));
        }
        return zContains;
    }

    protected void setExpected(long j) {
        synchronized (this.expectedTimestamps) {
            this.expectedTimestamps.add(Long.valueOf(j));
        }
    }

    protected void removeExpected(long j) {
        synchronized (this.expectedTimestamps) {
            this.expectedTimestamps.remove(Long.valueOf(j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r9v0 */
    boolean enqueueInputSample(int i, MediaSample mediaSample) throws IllegalStateException {
        ?? r0;
        if (getCurrentState() != InternalState.RUNNING && !mediaSample.isEndOfStream) {
            return false;
        }
        if (this.awaitingReconfigure) {
            Log.d(tag(), "Awaiting reconfigure, rejecting");
            return false;
        }
        try {
            ByteBuffer inputBuffer = this.decoder.getInputBuffer(i);
            if (inputBuffer == null) {
                Log.e(tag(), "getInputBuffer == null");
                return false;
            }
            inputBuffer.put(mediaSample.buffer);
            mediaSample.buffer.rewind();
            boolean z = mediaSample.isSyncSample;
            if (mediaSample.isEndOfStream) {
                r0 = z;
                Log.d(tag(), "marking EOS");
                r0 = (z ? 1 : 0) | 4;
            }
            r0 = z;
            ?? r9 = r0;
            if (!hashMediaFormat(mediaSample.format).equals(this.formatHash)) {
                String string = this.decoderFormat.getString("mime");
                String string2 = mediaSample.format.getString("mime");
                MediaFormat mediaFormat = mediaSample.format;
                this.decoderFormat = mediaFormat;
                this.formatHash = hashMediaFormat(mediaFormat);
                Listener listener = this.listener;
                if (listener != null) {
                    listener.onInputFormatChanged(this.trackId, this, mediaSample.format);
                }
                if (shouldReconfigureForFormat(string, string2)) {
                    this.awaitingReconfigure = true;
                    Log.d(tag(), "Format change requires reconfiguration");
                    try {
                        this.decoder.queueInputBuffer(i, 0, 0, mediaSample.presentationTimeUs, 4);
                    } catch (MediaCodec.CodecException e) {
                        onError(this.decoder, e);
                    }
                    return false;
                }
            }
            long j = mediaSample.presentationTimeUs;
            this.decoder.queueInputBuffer(i, 0, mediaSample.size, j, r9 == true ? 1 : 0);
            this.expectedTimestamps.add(Long.valueOf(j));
            return true;
        } catch (MediaCodec.CodecException e2) {
            onError(this.decoder, e2);
            return false;
        }
    }

    protected boolean shouldReconfigureForFormat(String str, String str2) {
        return !str2.equals(str);
    }

    protected void handleReconfiguration() {
        if (this.awaitingReconfigure) {
            this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.Decoder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11043lambda$handleReconfiguration$0$comamazonawsivsplayerDecoder();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$handleReconfiguration$0$com-amazonaws-ivs-player-Decoder, reason: not valid java name */
    /* synthetic */ void m11043lambda$handleReconfiguration$0$comamazonawsivsplayerDecoder() {
        Log.d(tag(), "Reconfiguring decoder");
        this.awaitingReconfigure = false;
        stop();
        initialize(this.decoderFormat, false);
        play();
    }

    protected void maybeSubmitBuffers() {
        if (this.upstream == null) {
            return;
        }
        while (getCurrentState() == InternalState.RUNNING) {
            MediaSample mediaSampleTake = this.nextSample;
            if (mediaSampleTake == null) {
                mediaSampleTake = this.upstream.take();
            }
            this.nextSample = null;
            if (mediaSampleTake == null) {
                Listener listener = this.listener;
                if (listener != null) {
                    listener.onNeedMoreData(this.trackId, this);
                }
                this.handler.postDelayed(new Decoder$$ExternalSyntheticLambda0(this), 100L);
                return;
            }
            synchronized (this.bufferQueue) {
                if (this.bufferQueue.isEmpty()) {
                    this.nextSample = mediaSampleTake;
                    return;
                }
                Integer numRemove = this.bufferQueue.remove();
                int iIntValue = numRemove.intValue();
                try {
                    if (!enqueueInputSample(iIntValue, mediaSampleTake)) {
                        synchronized (this.bufferQueue) {
                            try {
                                this.bufferQueue.addFirst(numRemove);
                                this.nextSample = mediaSampleTake;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return;
                    }
                    continue;
                } catch (IllegalStateException unused) {
                    this.nextSample = mediaSampleTake;
                }
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.bufferQueue) {
            this.bufferQueue.add(Integer.valueOf(i));
        }
        this.handler.post(new Decoder$$ExternalSyntheticLambda0(this));
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        Log.e(tag(), "Got error: " + codecException);
        onError(new DecoderException(codecException, codecException.isRecoverable(), codecException.getErrorCode()));
    }

    void onError(DecoderException decoderException) {
        if (!decoderException.isRecoverable) {
            changeState(InternalState.ERROR);
        } else {
            stop();
            initialize(this.decoderFormat, false);
        }
        Listener listener = this.listener;
        if (listener != null) {
            listener.onError(this.trackId, this, decoderException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Log.d(tag(), "Output format changed: " + mediaFormat);
        Listener listener = this.listener;
        if (listener != null) {
            listener.onOutputFormatChanged(this.trackId, this, mediaFormat);
        }
    }

    protected String hashMediaFormat(MediaFormat mediaFormat) {
        return mediaFormat.toString();
    }

    static class DecoderException extends Exception {
        public final int errorCode;
        public final boolean isRecoverable;

        DecoderException(Exception exc, boolean z, int i) {
            super(exc);
            this.isRecoverable = z;
            this.errorCode = i;
        }
    }
}
