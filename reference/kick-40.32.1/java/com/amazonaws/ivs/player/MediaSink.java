package com.amazonaws.ivs.player;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
class MediaSink implements Decoder.Listener, Consumer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    static String TAG = "MediaSink";
    private final Context context;
    private long droppedFrameCount;
    private long frameDecodedCount;
    private long frameRenderedCount;
    private final long handle;
    private long lastStatsTime;
    private long minBufferDurationMs;
    private Surface outputSurface;
    private final Platform platform;
    private long startPlaybackTime;
    private WallTimeSource wallTimeSource;
    private boolean wantsToPlay;
    private boolean hasUpdatedSize = false;
    private long currentPlayheadUs = 0;
    private float playbackRate = 1.0f;
    private float volume = 1.0f;
    private final Fsm<InternalState> internalState = new Fsm<>(InternalState.transitions(), InternalState.IDLE);
    private boolean hasFirstVideoFrame = false;
    private Map<Integer, Track> tracks = new HashMap();
    private final SyncSource syncSource = new SyncSource();

    private void setMaxBufferDuration(long j) {
    }

    private void setSourceDuration(long j) {
    }

    @Override // com.amazonaws.ivs.player.Consumer
    public void accept(Object obj) {
    }

    native void onSinkDurationChanged(long j, long j2);

    native void onSinkError(long j, PlayerException playerException);

    native void onSinkFormatChanged(long j, long j2, MediaDecoderInfo mediaDecoderInfo);

    native void onSinkModeChanged(long j, long j2);

    native void onSinkRecoverableError(long j, PlayerException playerException);

    native void onSinkStateChanged(long j, long j2);

    native void onSinkTimeUpdate(long j, long j2);

    native void onSinkVideoFirstFrame(long j, long j2);

    native void onSinkVideoStatistics(long j, Statistics statistics);

    native void releaseSample(long j, long j2);

    private MediaSink(long j, Context context, Platform platform) {
        this.handle = j;
        this.context = context.getApplicationContext();
        this.platform = platform;
    }

    private void release() {
        reset();
        changeState(InternalState.ENDED);
        Log.d(TAG, "MediaSink Released");
    }

    private void configure(int i, MediaFormat mediaFormat) {
        this.lastStatsTime = System.currentTimeMillis();
        if (this.tracks.containsKey(Integer.valueOf(i))) {
            Track track = this.tracks.get(Integer.valueOf(i));
            if (track != null) {
                try {
                    track.configure(mediaFormat, this.platform, this.syncSource, this.outputSurface, this.context, this);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to configure track " + i + ": " + e.getMessage(), e);
                    ErrorType errorType = ErrorType.ERROR;
                    StringBuilder sb = new StringBuilder("Track configuration failed: ");
                    sb.append(e.getMessage());
                    onSinkError(this.handle, new PlayerException("Track.configure", errorType, -1, sb.toString()));
                    return;
                }
            }
        } else if (i == MediaSample.TrackID.AUDIO.value || i == MediaSample.TrackID.VIDEO.value) {
            Track track2 = new Track(i, new Track.Listener() { // from class: com.amazonaws.ivs.player.MediaSink$$ExternalSyntheticLambda1
                @Override // com.amazonaws.ivs.player.MediaSink.Track.Listener
                public final void onFrameReceived(int i2, FrameInfo frameInfo) {
                    this.f$0.onFrameReceived(i2, frameInfo);
                }
            });
            try {
                track2.configure(mediaFormat, this.platform, this.syncSource, this.outputSurface, this.context, this);
                track2.seekTo(this.currentPlayheadUs);
                track2.setVolume(this.volume);
                this.tracks.put(Integer.valueOf(i), track2);
            } catch (Exception e2) {
                Log.e(TAG, "Failed to configure new track " + i + ": " + e2.getMessage(), e2);
                ErrorType errorType2 = ErrorType.ERROR;
                StringBuilder sb2 = new StringBuilder("Track configuration failed: ");
                sb2.append(e2.getMessage());
                onSinkError(this.handle, new PlayerException("Track.configure", errorType2, -1, sb2.toString()));
                return;
            }
        }
        checkPlaybackReadyState();
    }

    private void endOfStream() {
        Log.d(TAG, "endOfStream");
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().endOfStream();
        }
    }

    private void enqueueBuffer(int i, MediaSample mediaSample, final long j) {
        if (!this.tracks.containsKey(Integer.valueOf(i)) || this.tracks.get(Integer.valueOf(i)) == null) {
            Log.e(TAG, "Attempted to enqueue buffer for unknown track " + i + ". This is likely a MediaPlayer bug.");
            return;
        }
        if (this.internalState.getCurrentState() == InternalState.IDLE) {
            setBuffering();
        }
        mediaSample.setReleaseCallback(new Releasable() { // from class: com.amazonaws.ivs.player.MediaSink$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Releasable
            public final void release() {
                this.f$0.m11064lambda$enqueueBuffer$0$comamazonawsivsplayerMediaSink(j);
            }
        });
        Track track = this.tracks.get(Integer.valueOf(i));
        if (track != null) {
            track.enqueue(mediaSample);
        } else {
            Log.w(TAG, "track " + i + " is null!");
        }
        if (this.internalState.getCurrentState() == InternalState.BUFFERING) {
            checkPlaybackReadyState();
        }
    }

    /* JADX INFO: renamed from: lambda$enqueueBuffer$0$com-amazonaws-ivs-player-MediaSink, reason: not valid java name */
    /* synthetic */ void m11064lambda$enqueueBuffer$0$comamazonawsivsplayerMediaSink(long j) {
        releaseSample(this.handle, j);
    }

    private void flush() {
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().flush();
        }
    }

    private void play() {
        Log.d(TAG, "Play");
        this.wantsToPlay = true;
        checkPlaybackReadyState();
    }

    private void pause() {
        Log.d(TAG, "Pause");
        this.wantsToPlay = false;
        if (this.internalState.isValidNextState(InternalState.PAUSING)) {
            changeState(InternalState.PAUSING);
            Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().pause();
            }
            WallTimeSource wallTimeSource = this.wallTimeSource;
            if (wallTimeSource != null) {
                wallTimeSource.release();
                this.wallTimeSource = null;
            }
            changeState(InternalState.PAUSED);
        }
    }

    private void reset() {
        Log.d(TAG, "reset()");
        HandlerThread handlerThread = new HandlerThread("MediaSink.release");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        pause();
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().release(handler);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.MediaSink$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaSink.lambda$reset$1(countDownLatch, handler);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        this.tracks.clear();
        Log.d(TAG, "reset() tracks cleared");
        this.currentPlayheadUs = 0L;
        this.hasUpdatedSize = false;
        this.hasFirstVideoFrame = false;
        this.wantsToPlay = false;
        this.syncSource.clearObservers();
    }

    static /* synthetic */ void lambda$reset$1(CountDownLatch countDownLatch, Handler handler) {
        countDownLatch.countDown();
        handler.getLooper().quitSafely();
    }

    private void remove(long j, long j2) {
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(j, j2);
        }
        if (this.internalState.getCurrentState() == InternalState.ENDED) {
            this.currentPlayheadUs = 0L;
        }
    }

    private void setBuffering() {
        if (this.internalState.isValidNextState(InternalState.BUFFERING)) {
            changeState(InternalState.BUFFERING);
            Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().pause();
            }
            WallTimeSource wallTimeSource = this.wallTimeSource;
            if (wallTimeSource != null) {
                wallTimeSource.release();
                this.wallTimeSource = null;
            }
        }
    }

    private void setPlaybackRate(float f) {
        this.playbackRate = f;
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setPlaybackRate(f);
        }
        WallTimeSource wallTimeSource = this.wallTimeSource;
        if (wallTimeSource != null) {
            wallTimeSource.setPlaybackRate(f);
        }
    }

    private void seekTo(long j) {
        Log.d(TAG, "seekTo " + j);
        long jMax = Math.max(0L, j);
        flush();
        this.currentPlayheadUs = jMax;
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().seekTo(jMax);
        }
        onSinkTimeUpdate(this.handle, jMax);
        if (this.internalState.getCurrentState() == InternalState.ENDED) {
            changeState(InternalState.BUFFERING);
        }
    }

    private void setVolume(float f) {
        this.volume = f;
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setVolume(f);
        }
    }

    private void setMinBufferDuration(long j) {
        this.minBufferDurationMs = j / 1250;
    }

    private void setSurface(Surface surface) {
        this.outputSurface = surface;
        Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setSurface(surface);
        }
    }

    private void checkPlaybackReadyState() {
        boolean zCheckNeedsMoreMedia = checkNeedsMoreMedia();
        if (hasEOS() && zCheckNeedsMoreMedia) {
            pause();
            changeState(InternalState.ENDED);
            return;
        }
        if (zCheckNeedsMoreMedia) {
            setBuffering();
            return;
        }
        if (this.wantsToPlay && this.internalState.isValidNextState(InternalState.PLAYING)) {
            if (!this.tracks.containsKey(Integer.valueOf(MediaSample.TrackID.AUDIO.value)) && this.wallTimeSource == null) {
                this.wallTimeSource = new WallTimeSource(this.syncSource, this.currentPlayheadUs);
            }
            Iterator<Map.Entry<Integer, Track>> it = this.tracks.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().play();
            }
            setPlaybackRate(this.playbackRate);
            changeState(InternalState.PLAYING);
            resetStats();
        }
    }

    private boolean checkNeedsMoreMedia() {
        long j = (hasEOS() || this.internalState.getCurrentState() == InternalState.PLAYING) ? 1L : this.minBufferDurationMs;
        Iterator<Track> it = this.tracks.values().iterator();
        long jMax = 0;
        while (it.hasNext()) {
            jMax = Math.max(it.next().bufferDurationMs(), jMax);
        }
        return jMax < j;
    }

    private boolean hasEOS() {
        Iterator<Track> it = this.tracks.values().iterator();
        boolean zHasEOS = false;
        while (it.hasNext()) {
            zHasEOS |= it.next().hasEOS();
        }
        return zHasEOS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFrameReceived(int i, FrameInfo frameInfo) {
        this.currentPlayheadUs = Math.max(this.currentPlayheadUs, frameInfo.presentationTimeUs);
        if (i == MediaSample.TrackID.AUDIO.value || !this.tracks.containsKey(Integer.valueOf(MediaSample.TrackID.AUDIO.value))) {
            onSinkTimeUpdate(this.handle, this.currentPlayheadUs);
        }
    }

    enum PlayerState {
        UNUSED_DONT_SIGNAL_TRANSITION(-1),
        PLAYING(0),
        IDLE(1),
        ENDED(2),
        RESET(3),
        BUFFERING(4);

        public final long value;

        PlayerState(long j) {
            this.value = j;
        }
    }

    enum InternalState {
        IDLE(0),
        BUFFERING(1),
        PLAYING(2),
        PAUSING(3),
        PAUSED(4),
        ENDED(5);

        public final long value;

        InternalState(long j) {
            this.value = j;
        }

        PlayerState mappedState() {
            int iOrdinal = ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return PlayerState.PLAYING;
                }
                if (iOrdinal == 3 || iOrdinal == 4) {
                    return PlayerState.IDLE;
                }
                if (iOrdinal != 5) {
                    return PlayerState.UNUSED_DONT_SIGNAL_TRANSITION;
                }
            }
            return PlayerState.BUFFERING;
        }

        static Map<InternalState, List<InternalState>> transitions() {
            HashMap map = new HashMap();
            InternalState internalState = IDLE;
            InternalState internalState2 = BUFFERING;
            map.put(internalState, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState2}));
            InternalState internalState3 = PLAYING;
            InternalState internalState4 = PAUSING;
            InternalState internalState5 = ENDED;
            map.put(internalState2, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState3, internalState4, internalState5}));
            InternalState internalState6 = PAUSED;
            map.put(internalState4, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState6, internalState5}));
            map.put(internalState3, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState4, internalState2, internalState5}));
            map.put(internalState6, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState5, internalState2, internalState3}));
            map.put(internalState5, UByte$$ExternalSyntheticBackport0.m(new Object[]{internalState2}));
            return map;
        }
    }

    void changeState(InternalState internalState) {
        InternalState currentState = this.internalState.getCurrentState();
        Log.d(TAG, String.format("changeState %s -> %s", currentState, internalState));
        if (!this.internalState.changeState(internalState) || currentState.mappedState().value < 0 || currentState.mappedState() == this.internalState.getCurrentState().mappedState()) {
            return;
        }
        Log.d(TAG, String.format("Calling onSinkStateChanged(%s)", this.internalState.getCurrentState().mappedState()));
        onSinkStateChanged(this.handle, this.internalState.getCurrentState().mappedState().value);
    }

    void resetStats() {
        this.frameDecodedCount = 0L;
        this.frameRenderedCount = 0L;
        this.startPlaybackTime = System.currentTimeMillis();
        this.lastStatsTime = System.currentTimeMillis();
        this.droppedFrameCount = 0L;
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onFrameDecoded(MediaSample.TrackID trackID, Decoder decoder, long j) {
        this.frameDecodedCount++;
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onFrameRendered(MediaSample.TrackID trackID, Decoder decoder, long j, boolean z, boolean z2) {
        if (z) {
            this.droppedFrameCount++;
        } else {
            this.frameRenderedCount++;
        }
        if (!this.hasFirstVideoFrame) {
            this.hasFirstVideoFrame = true;
            onSinkVideoFirstFrame(this.handle, j);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.lastStatsTime >= jCurrentTimeMillis - 100 || this.internalState.getCurrentState() != InternalState.PLAYING) {
            return;
        }
        this.lastStatsTime = jCurrentTimeMillis;
        Statistics statistics = new Statistics();
        statistics.setDecodedFrames((int) this.frameDecodedCount);
        statistics.setRenderedFrames((int) this.frameRenderedCount);
        statistics.setFrameRate((int) Math.round((this.frameRenderedCount * 1000) / (jCurrentTimeMillis - this.startPlaybackTime)));
        statistics.setDroppedFrames((int) this.droppedFrameCount);
        statistics.setBitRate(0);
        onSinkVideoStatistics(this.handle, statistics);
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onOutputFormatChanged(MediaSample.TrackID trackID, Decoder decoder, MediaFormat mediaFormat) {
        VideoRenderer.VideoSizeListener videoSizeListener;
        if (trackID == MediaSample.TrackID.VIDEO && (videoSizeListener = this.platform.getVideoSizeListener()) != null) {
            int integer = mediaFormat.getInteger(ViewProps.WIDTH);
            int integer2 = mediaFormat.getInteger(ViewProps.HEIGHT);
            if (mediaFormat.containsKey(FORMAT_KEY_CROP_LEFT) && mediaFormat.containsKey(FORMAT_KEY_CROP_RIGHT) && mediaFormat.containsKey(FORMAT_KEY_CROP_TOP) && mediaFormat.containsKey(FORMAT_KEY_CROP_BOTTOM)) {
                int integer3 = mediaFormat.getInteger(FORMAT_KEY_CROP_LEFT);
                integer = (mediaFormat.getInteger(FORMAT_KEY_CROP_RIGHT) - integer3) + 1;
                integer2 = (mediaFormat.getInteger(FORMAT_KEY_CROP_BOTTOM) - mediaFormat.getInteger(FORMAT_KEY_CROP_TOP)) + 1;
            }
            Log.i(TAG, String.format("onOutputFormatChanged(%d, %d)", Integer.valueOf(integer), Integer.valueOf(integer2)));
            videoSizeListener.onSizeChange(integer, integer2);
        }
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onInputFormatChanged(MediaSample.TrackID trackID, Decoder decoder, MediaFormat mediaFormat) {
        Log.d(TAG, "onInputFormatChanged");
        onSinkFormatChanged(this.handle, trackID.value, new MediaDecoderInfo(decoder.getCodec()));
        if (trackID == MediaSample.TrackID.VIDEO) {
            this.platform.setVideoMediaType(mediaFormat.getString("mime"));
            if (this.hasUpdatedSize) {
                return;
            }
            this.hasUpdatedSize = true;
            int integer = mediaFormat.getInteger(ViewProps.WIDTH);
            int integer2 = mediaFormat.getInteger(ViewProps.HEIGHT);
            VideoRenderer.VideoSizeListener videoSizeListener = this.platform.getVideoSizeListener();
            if (videoSizeListener != null) {
                videoSizeListener.onSizeChange(integer, integer2);
            }
        }
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onNeedMoreData(MediaSample.TrackID trackID, Decoder decoder) {
        checkPlaybackReadyState();
    }

    @Override // com.amazonaws.ivs.player.Decoder.Listener
    public void onError(MediaSample.TrackID trackID, Decoder decoder, Decoder.DecoderException decoderException) {
        PlayerException playerException = new PlayerException(decoder.tag(), ErrorType.ERROR, decoderException.errorCode, decoderException.getMessage());
        boolean z = decoderException.isRecoverable;
        long j = this.handle;
        if (z) {
            onSinkRecoverableError(j, playerException);
        } else {
            onSinkError(j, playerException);
        }
    }

    static class Track {
        private MediaFormat format;
        private final Listener listener;
        private final int trackId;
        private boolean needsReconfigure = false;
        public ArrayList<Filter> components = new ArrayList<>();

        interface Listener {
            void onFrameReceived(int i, FrameInfo frameInfo);
        }

        Track(int i, Listener listener) {
            this.trackId = i;
            this.listener = listener;
        }

        long bufferDurationMs() {
            long jBufferDurationMs = 0;
            if (this.components.isEmpty()) {
                return 0L;
            }
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                jBufferDurationMs += it.next().bufferDurationMs();
            }
            return jBufferDurationMs;
        }

        boolean hasEOS() {
            if (this.components.isEmpty()) {
                return false;
            }
            return ((BufferFilter) this.components.get(0)).hasEOS();
        }

        void enqueue(MediaSample mediaSample) {
            if (this.components.isEmpty()) {
                return;
            }
            mediaSample.format = this.format;
            this.components.get(0).receive(mediaSample);
        }

        void play() {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().play();
            }
        }

        void remove(long j, long j2) {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().remove(j, j2);
            }
        }

        void release(Handler handler) {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().release(handler);
            }
            this.components.clear();
        }

        void pause() {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }

        void seekTo(long j) {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().seekTo(j);
            }
        }

        void flush() {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().flush();
            }
        }

        void reset() {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().reset();
            }
            this.needsReconfigure = true;
            this.format = null;
        }

        void endOfStream() {
            Log.d(MediaSink.TAG, "endOfStream");
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().endOfStream();
            }
        }

        void setPlaybackRate(float f) {
            Iterator<Filter> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().setPlaybackRate(f);
            }
        }

        void setVolume(float f) {
            for (Filter filter : this.components) {
                if (filter.kind() == Filter.Kind.AUDIO) {
                    ((AudioFilter) filter).setVolume(f);
                }
            }
        }

        void setSurface(Surface surface) {
            for (int size = this.components.size() - 1; size > 0; size--) {
                if (VideoFilter.class.isAssignableFrom(this.components.get(size).getClass())) {
                    ((VideoFilter) this.components.get(size)).setOutputSurface(surface);
                    return;
                }
            }
        }

        void configure(MediaFormat mediaFormat, Platform platform, SyncSource syncSource, Surface surface, Context context, MediaSink mediaSink) {
            if (this.trackId == MediaSample.TrackID.VIDEO.value) {
                configureVideo(mediaFormat, syncSource, surface, context, mediaSink);
            } else if (this.trackId == MediaSample.TrackID.AUDIO.value) {
                configureAudio(mediaFormat, platform, syncSource, mediaSink);
            }
        }

        void configureVideo(MediaFormat mediaFormat, SyncSource syncSource, Surface surface, Context context, MediaSink mediaSink) {
            VideoDecoder videoDecoder;
            if (this.trackId != MediaSample.TrackID.VIDEO.value) {
                Log.w(MediaSink.TAG, "Cannot configure a non-video track for video");
                return;
            }
            mediaFormat.getInteger(ViewProps.WIDTH);
            mediaFormat.getInteger(ViewProps.HEIGHT);
            mediaFormat.getString("mime");
            this.format = mediaFormat;
            boolean z = this.components.isEmpty() || this.needsReconfigure;
            this.needsReconfigure = false;
            if (this.components.isEmpty()) {
                videoDecoder = new VideoDecoder(mediaSink);
                VideoFrameTransformerFilter videoFrameTransformerFilter = new VideoFrameTransformerFilter(mediaSink, mediaSink, context);
                InlineSink inlineSink = new InlineSink(new InlineSink.Op() { // from class: com.amazonaws.ivs.player.MediaSink$Track$$ExternalSyntheticLambda0
                    @Override // com.amazonaws.ivs.player.InlineSink.Op
                    public final void run(Object obj) {
                        this.f$0.m11066lambda$configureVideo$0$comamazonawsivsplayerMediaSink$Track((FrameInfo) obj);
                    }
                });
                BufferFilter bufferFilter = new BufferFilter();
                bufferFilter.setOutput(videoDecoder);
                videoDecoder.setOutput(videoFrameTransformerFilter);
                syncSource.addObserver(videoFrameTransformerFilter);
                syncSource.addObserver(videoDecoder);
                videoFrameTransformerFilter.setOutputSurface(surface);
                videoFrameTransformerFilter.setOutput(inlineSink);
                this.components.add(bufferFilter);
                this.components.add(videoDecoder);
                this.components.add(videoFrameTransformerFilter);
                this.components.add(inlineSink);
            } else {
                videoDecoder = (VideoDecoder) this.components.get(1);
            }
            if (z) {
                videoDecoder.initialize(mediaFormat);
            }
        }

        /* JADX INFO: renamed from: lambda$configureVideo$0$com-amazonaws-ivs-player-MediaSink$Track, reason: not valid java name */
        /* synthetic */ void m11066lambda$configureVideo$0$comamazonawsivsplayerMediaSink$Track(FrameInfo frameInfo) {
            this.listener.onFrameReceived(this.trackId, frameInfo);
        }

        void configureAudio(MediaFormat mediaFormat, Platform platform, SyncSource syncSource, MediaSink mediaSink) {
            AudioDecoder audioDecoder;
            if (this.trackId != MediaSample.TrackID.AUDIO.value) {
                Log.w(MediaSink.TAG, "Cannot configure a non-audio track for audio");
                return;
            }
            boolean z = this.components.isEmpty() || this.needsReconfigure;
            this.needsReconfigure = false;
            this.format = mediaFormat;
            if (this.components.isEmpty()) {
                audioDecoder = new AudioDecoder(mediaSink);
                AudioRendererFilter audioRendererFilter = new AudioRendererFilter();
                audioRendererFilter.setSyncSource(syncSource);
                audioRendererFilter.configure(mediaFormat);
                audioDecoder.setOutput(audioRendererFilter);
                InlineSink inlineSink = new InlineSink(new InlineSink.Op() { // from class: com.amazonaws.ivs.player.MediaSink$Track$$ExternalSyntheticLambda1
                    @Override // com.amazonaws.ivs.player.InlineSink.Op
                    public final void run(Object obj) {
                        this.f$0.m11065lambda$configureAudio$1$comamazonawsivsplayerMediaSink$Track((FrameInfo) obj);
                    }
                });
                BufferFilter bufferFilter = new BufferFilter();
                audioRendererFilter.setOutput(inlineSink);
                platform.setAudioSessionId(audioRendererFilter.getAudioSessionId());
                bufferFilter.setOutput(audioDecoder);
                this.components.add(bufferFilter);
                this.components.add(audioDecoder);
                this.components.add(audioRendererFilter);
                this.components.add(inlineSink);
            } else {
                audioDecoder = (AudioDecoder) this.components.get(1);
            }
            if (z) {
                audioDecoder.initialize(mediaFormat, false);
                Log.i(MediaSink.TAG, "Track.reconfigure done: audio");
            }
        }

        /* JADX INFO: renamed from: lambda$configureAudio$1$com-amazonaws-ivs-player-MediaSink$Track, reason: not valid java name */
        /* synthetic */ void m11065lambda$configureAudio$1$comamazonawsivsplayerMediaSink$Track(FrameInfo frameInfo) {
            this.listener.onFrameReceived(this.trackId, frameInfo);
        }
    }
}
