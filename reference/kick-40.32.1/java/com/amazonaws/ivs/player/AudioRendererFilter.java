package com.amazonaws.ivs.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
class AudioRendererFilter extends SyncSource implements AudioFilter<DecodedAudioBuffer, FrameInfo>, AudioTrack.OnPlaybackPositionUpdateListener {
    Handler handler;
    AudioTrackRenderer renderer;
    final String TAG = "AudioRenderFilter";
    final int MIN_AUDIO_FRAMES_UPDATE_DURATION = 960;
    SyncSource syncSource = null;
    boolean ended = false;
    private Filter<FrameInfo, ?> output = null;
    private FrameInfo eosInfo = null;
    private MediaFormat format = null;
    private final Fsm<InternalState> state = new Fsm<>(InternalState.transitions(), InternalState.STOPPED);

    AudioRendererFilter() {
        HandlerThread handlerThread = new HandlerThread("MediaSink.audio", -19);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.handler = handler;
        handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11008lambda$new$0$comamazonawsivsplayerAudioRendererFilter();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11008lambda$new$0$comamazonawsivsplayerAudioRendererFilter() {
        this.renderer = new AudioTrackRenderer();
    }

    public void configure(final MediaFormat mediaFormat) {
        this.format = mediaFormat;
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11006lambda$configure$1$comamazonawsivsplayerAudioRendererFilter(mediaFormat);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$configure$1$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11006lambda$configure$1$comamazonawsivsplayerAudioRendererFilter(MediaFormat mediaFormat) {
        Log.d("AudioRenderFilter", "configure()");
        this.renderer.configure(mediaFormat);
    }

    @Override // com.amazonaws.ivs.player.AudioFilter
    public void setVolume(float f) {
        this.renderer.setVolume(f);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setPlaybackRate(float f) {
        this.renderer.setPlaybackRate(f);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void play() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11010lambda$play$2$comamazonawsivsplayerAudioRendererFilter();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$play$2$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11010lambda$play$2$comamazonawsivsplayerAudioRendererFilter() {
        if (this.state.changeState(InternalState.RUNNING)) {
            Log.d("AudioRenderFilter", "play()");
            this.eosInfo = null;
            this.renderer.configure(this.format);
            this.renderer.start();
            this.renderer.setPlaybackPositionUpdateListener(this, 960);
            return;
        }
        Log.w("AudioRenderFilter", "Failed to transition to RUNNING state from " + this.state.getCurrentState());
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void pause() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11009lambda$pause$3$comamazonawsivsplayerAudioRendererFilter();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$pause$3$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11009lambda$pause$3$comamazonawsivsplayerAudioRendererFilter() {
        if (this.state.changeState(InternalState.PAUSED)) {
            Log.d("AudioRenderFilter", "pause()");
            this.renderer.stop();
        } else {
            Log.w("AudioRenderFilter", "Failed to transition to PAUSED state from " + this.state.getCurrentState());
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void stop() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11012lambda$stop$4$comamazonawsivsplayerAudioRendererFilter();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$stop$4$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11012lambda$stop$4$comamazonawsivsplayerAudioRendererFilter() {
        if (this.state.changeState(InternalState.STOPPED)) {
            Log.d("AudioRenderFilter", "stop()");
            this.renderer.stop();
            this.renderer.flush();
        } else {
            Log.w("AudioRenderFilter", "Failed to transition to STOPPED state from " + this.state.getCurrentState());
        }
        this.ended = false;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void flush() {
        pause();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void seekTo(long j) {
        Log.d("AudioRenderFilter", "seekTo " + j);
        flush();
        this.syncSource.notifyTargetTimeChanged(j);
        this.ended = false;
        play();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<FrameInfo, ?> filter) {
        this.output = filter;
    }

    public int getAudioSessionId() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        Log.d("AudioRenderFilter", "getAudioSessionId, renderer=" + this.renderer);
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11007xdc6cfeab(atomicInteger, countDownLatch);
            }
        });
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    /* JADX INFO: renamed from: lambda$getAudioSessionId$5$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11007xdc6cfeab(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
        AudioTrackRenderer audioTrackRenderer = this.renderer;
        if (audioTrackRenderer != null) {
            atomicInteger.set(audioTrackRenderer.getAudioSessionId());
            Log.d("AudioRenderFilter", "getAudioSessionId=" + this.renderer.getAudioSessionId());
        }
        countDownLatch.countDown();
    }

    public void setSyncSource(SyncSource syncSource) {
        SyncSource syncSource2 = this.syncSource;
        if (syncSource2 == syncSource) {
            return;
        }
        if (syncSource2 != null) {
            syncSource2.setConnected(false);
        }
        if (syncSource != null) {
            syncSource.setConnected(true);
        }
        this.syncSource = syncSource;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(DecodedAudioBuffer decodedAudioBuffer) {
        if (decodedAudioBuffer.info.isEndOfStream && this.syncSource != null) {
            long j = decodedAudioBuffer.info.presentationTimeUs + decodedAudioBuffer.info.durationUs;
            Log.d("AudioRenderFilter", "EOS. Setting marker for " + j + " pts=" + decodedAudioBuffer.info.presentationTimeUs + " dur=" + decodedAudioBuffer.info.durationUs);
            this.renderer.setMarkerPosition(j);
            this.eosInfo = decodedAudioBuffer.info;
        }
        if (this.state.getCurrentState() == InternalState.RUNNING) {
            if (decodedAudioBuffer.bytesSize > 0) {
                this.renderer.render(decodedAudioBuffer.buffer, decodedAudioBuffer.bytesSize, decodedAudioBuffer.info.presentationTimeUs);
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
                for (int i = 0; i < 1024; i++) {
                    byteBufferAllocate.put((byte) 0);
                }
                byteBufferAllocate.rewind();
                this.renderer.render(byteBufferAllocate, 1024, decodedAudioBuffer.info.presentationTimeUs);
            }
        }
        SyncSource syncSource = this.syncSource;
        if (syncSource != null && !this.ended) {
            syncSource.notifyTargetTimeChanged(decodedAudioBuffer.info.presentationTimeUs);
        }
        decodedAudioBuffer.release();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.AudioRendererFilter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11011lambda$release$6$comamazonawsivsplayerAudioRendererFilter();
                }
            });
        } else {
            this.renderer.release();
            this.handler.getLooper().quitSafely();
        }
    }

    /* JADX INFO: renamed from: lambda$release$6$com-amazonaws-ivs-player-AudioRendererFilter, reason: not valid java name */
    /* synthetic */ void m11011lambda$release$6$comamazonawsivsplayerAudioRendererFilter() {
        this.renderer.release();
        this.handler.getLooper().quitSafely();
        Log.d("AudioRenderFilter", "Releasing track");
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
        if (this.output != null && this.eosInfo != null) {
            Log.d("AudioRenderFilter", "Marker reached, setting EOS ts=" + this.renderer.getRenderedPresentationTime());
            this.ended = true;
            this.output.receive(this.eosInfo);
        }
        SyncSource syncSource = this.syncSource;
        if (syncSource != null && this.eosInfo != null) {
            syncSource.notifyTargetTimeChanged(Long.MAX_VALUE);
        }
        this.eosInfo = null;
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
        long renderedPresentationTime = this.renderer.getRenderedPresentationTime();
        FrameInfo frameInfo = this.eosInfo;
        boolean z = frameInfo != null && frameInfo.presentationTimeUs >= renderedPresentationTime;
        SyncSource syncSource = this.syncSource;
        if (syncSource != null && !this.ended) {
            syncSource.notifyTargetTimeChanged(renderedPresentationTime);
        }
        if (this.output == null || z) {
            return;
        }
        this.output.receive(new FrameInfo(renderedPresentationTime, 960L, false));
    }

    protected enum InternalState {
        STOPPED,
        RUNNING,
        PAUSED,
        RELEASED;

        static Map<InternalState, List<InternalState>> transitions() {
            HashMap map = new HashMap();
            InternalState internalState = STOPPED;
            InternalState internalState2 = RUNNING;
            map.put(internalState, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState2}));
            InternalState internalState3 = PAUSED;
            InternalState internalState4 = RELEASED;
            map.put(internalState2, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState3, internalState, internalState4}));
            map.put(internalState3, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState2, internalState, internalState4}));
            map.put(internalState4, Collections.EMPTY_LIST);
            return map;
        }
    }
}
