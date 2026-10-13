package com.amazonaws.ivs.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class CorePlayerImpl implements MediaPlayer, VideoRenderer.VideoSizeListener, IVSFeature.EventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String TWITCH_CLIP_MIME_TYPE = "application/x-twitch-clip";
    private static Platform preloadPlatform;
    private final AtomicBoolean closed;
    private final Configuration config;
    private final Context context;
    private EGLManager eglManager;
    private final ArrayList<IVSFeature<?>> features;
    private final Handler handler;
    private HardwareInfo hardwareInfo;
    private final Set<Player.Listener> listeners;
    private final Platform platform;
    private final Set<PlayerInternal.PlaybackListener> playbackListeners;
    private long player;
    private final Statistics statistics;
    private SuperResolution superRes;
    private VideoFrameTransformer videoFrameTransformer;

    private native long getAverageBitrate(long j);

    private native long getBandwidthEstimate(long j);

    private native long getBufferedPosition(long j);

    private native String[] getChannelMetadata(long j);

    private native long getDuration(long j);

    private native long getLiveLatency(long j);

    private native String getPath(long j);

    private native float getPlaybackRate(long j);

    private native long getPosition(long j);

    private native String getProtocol(long j);

    private native HashSet<Quality> getQualities(long j);

    private native Quality getQuality(long j);

    private native String getSessionId(long j);

    private native SourceGroup getSourceGroup(long j);

    private native HashSet<SourceGroup> getSourceGroups(long j);

    private native int getState(long j);

    private native void getStatistics(long j, Statistics statistics);

    private native long getSyncTime(long j);

    private native TextTrack getTextTrack(long j);

    private native List<TextTrack> getTextTracks(long j);

    private native HashSet<UnavailableQuality> getUnavailableQualities(long j);

    private native String getVersion(long j);

    private native float getVolume(long j);

    private native long init(Context context, Platform platform, String str);

    private static native void initialize();

    private native boolean isAutoQualityMode(long j);

    private native boolean isLiveLowLatency(long j);

    private native boolean isLooping(long j);

    private native boolean isMuted(long j);

    private native void linkSuperRes(long j, long j2);

    private native void load(long j, String str, String str2, String str3);

    private native void loadSource(long j, long j2, String str);

    private native void onGpuErrorEvent(long j, GPUAnalyticsEvent.GPUErrorAnalyticsEvent gPUErrorAnalyticsEvent);

    private native void onGpuInitEvent(long j, GPUAnalyticsEvent.GPUInitAnalyticsEvent gPUInitAnalyticsEvent);

    private native void onGpuStatusEvent(long j, GPUAnalyticsEvent.GPUStatusAnalyticsEvent gPUStatusAnalyticsEvent);

    private native void pause(long j);

    private native void play(long j);

    private native Source preload(long j, String str, Handler handler, Source.Listener listener);

    private native void release(long j);

    private native void seekTo(long j, long j2);

    private native void setAuthToken(long j, String str);

    private native void setAutoInitialBitrate(long j, int i);

    private native void setAutoMaxBitrate(long j, int i);

    private native void setAutoMaxQuality(long j, Quality quality);

    private native void setAutoMaxVideoSize(long j, int i, int i2);

    private native void setAutoQualityMode(long j, boolean z, boolean z2);

    private native void setClientId(long j, String str);

    private native void setConfiguration(long j, String str);

    private native void setDeviceId(long j, String str);

    private native void setDisplaySize(long j, int i, int i2);

    private native void setDrmEnabled(long j, boolean z);

    private native void setInitialBufferDuration(long j, long j2);

    private native void setLiveLowLatencyEnabled(long j, boolean z);

    private native void setLogLevel(long j, String str);

    private native void setLooping(long j, boolean z);

    private native void setMuted(long j, boolean z);

    private native void setOrigin(long j, String str);

    private native void setPlaybackRate(long j, float f);

    private native void setQuality(long j, String str, boolean z);

    private native void setRebufferToLive(long j, boolean z);

    private native void setResumeAfterReconnect(long j, boolean z);

    private native void setSourceGroup(long j, String str, boolean z);

    private native void setSurface(long j, Surface surface);

    private native void setSurfaceSize(long j, int i, int i2);

    private native void setTextTrack(long j, TextTrack textTrack);

    private native void setUserAgent(long j, String str);

    private native void setVolume(long j, float f);

    private native void skipAd(long j);

    public CorePlayerImpl(Context context) {
        this(context, new Configuration());
    }

    public CorePlayerImpl(Context context, Configuration configuration) {
        Platform platform = new Platform(context, this);
        this.platform = platform;
        this.player = init(context, platform, configuration.toString());
        this.handler = new Handler(Looper.getMainLooper());
        this.closed = new AtomicBoolean();
        this.listeners = new CopyOnWriteArraySet();
        this.playbackListeners = new CopyOnWriteArraySet();
        this.statistics = new Statistics();
        this.config = configuration;
        Size displaySize = platform.getDisplaySize();
        setDisplaySize(displaySize.width, displaySize.height);
        if (Logging.isVerbose()) {
            setLogLevel(Player.LogLevel.DEBUG);
        }
        this.context = context;
        ArrayList<IVSFeature<?>> arrayListAddSupportedFeatures = addSupportedFeatures();
        this.features = arrayListAddSupportedFeatures;
        Iterator<IVSFeature<?>> it = arrayListAddSupportedFeatures.iterator();
        while (it.hasNext()) {
            this.config.registerFeature(it.next());
        }
        SuperResolution superResolution = this.superRes;
        if (superResolution != null) {
            superResolution.init(context, this.platform);
            this.videoFrameTransformer = this.superRes.getTransformer();
        }
    }

    static {
        try {
            System.loadLibrary("playercore");
        } catch (UnsatisfiedLinkError e) {
            Logging.e("Failed to load playercore", e);
        }
        initialize();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.player != 0) {
                Logging.e("Player not released, releasing from finalizer");
            }
            release();
        } finally {
            super.finalize();
        }
    }

    void handleCue(final Cue cue) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11019lambda$handleCue$0$comamazonawsivsplayerCorePlayerImpl(cue);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleCue$0$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11019lambda$handleCue$0$comamazonawsivsplayerCorePlayerImpl(Cue cue) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCue(cue);
        }
    }

    void handleSeiMessage(final SeiMessage seiMessage) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11027x650cbc3(seiMessage);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleSeiMessage$1$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11027x650cbc3(SeiMessage seiMessage) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeiMessage(seiMessage);
        }
    }

    void handleDurationChanged(final long j) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11020x55423e2a(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleDurationChanged$2$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11020x55423e2a(long j) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDurationChanged(j);
        }
    }

    void handleError(String str, int i, int i2, String str2) {
        final PlayerException playerExceptionCreateException = this.platform.createException(str, i, i2, str2);
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11021lambda$handleError$3$comamazonawsivsplayerCorePlayerImpl(playerExceptionCreateException);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleError$3$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11021lambda$handleError$3$comamazonawsivsplayerCorePlayerImpl(PlayerException playerException) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(playerException);
        }
    }

    void handleQualityChange(final Quality quality) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11024xf3bdd33b(quality);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleQualityChange$4$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11024xf3bdd33b(Quality quality) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onQualityChanged(quality);
        }
    }

    void handleTextTracksChanged(List<TextTrack> list) {
        final List listUnmodifiableList = Collections.unmodifiableList(list);
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11032x98e8640c(listUnmodifiableList);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleTextTracksChanged$5$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11032x98e8640c(List list) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTextTracksChanged(list);
        }
    }

    void handleTextTrackChanged(final TextTrack textTrack) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11031x4f0de48e(textTrack);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleTextTrackChanged$6$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11031x4f0de48e(TextTrack textTrack) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTextTrackChanged(textTrack);
        }
    }

    void handleSourceGroupChange(final SourceGroup sourceGroup) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11028x12fe86e3(sourceGroup);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleSourceGroupChange$7$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11028x12fe86e3(SourceGroup sourceGroup) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSourceGroupChanged(sourceGroup);
        }
    }

    void handleRebuffering() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11025x9c786b3f();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleRebuffering$8$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11025x9c786b3f() {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRebuffering();
        }
    }

    void handleSeekCompleted(final long j) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11026xca874664(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleSeekCompleted$9$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11026xca874664(long j) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekCompleted(j);
        }
    }

    void handleStateChange(final int i) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11029xfeffbb48(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleStateChange$10$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11029xfeffbb48(int i) {
        Player.State stateMapState = mapState(i);
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(stateMapState);
        }
    }

    void handleAnalyticsEvent(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11018x49d7272c(str, str2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAnalyticsEvent$11$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11018x49d7272c(String str, String str2) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAnalyticsEvent(str, str2);
        }
    }

    void handleMetadata(final String str, ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            final ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
            byteBufferAllocate.put(byteBuffer);
            byteBufferAllocate.flip();
            this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11022lambda$handleMetadata$12$comamazonawsivsplayerCorePlayerImpl(str, byteBufferAllocate);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$handleMetadata$12$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11022lambda$handleMetadata$12$comamazonawsivsplayerCorePlayerImpl(String str, ByteBuffer byteBuffer) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(str, byteBuffer);
        }
    }

    void handleNetworkUnavailable() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11023x3aa3d860();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleNetworkUnavailable$13$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11023x3aa3d860() {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkUnavailable();
        }
    }

    void handleVideoFirstFrame(final long j) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11033x1bd4e895(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleVideoFirstFrame$14$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11033x1bd4e895(long j) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoFirstFrame(j);
        }
    }

    void handleSyncTimeChanged(final long j) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11030xa4e5b102(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleSyncTimeChanged$15$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11030xa4e5b102(long j) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSyncTimeChanged(j);
        }
    }

    void handleAdBreakStarted(final AdBreak adBreak) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11014x50788200(adBreak);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAdBreakStarted$16$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11014x50788200(AdBreak adBreak) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAdBreakStarted(adBreak);
        }
    }

    void handleAdCreativeStarted(final AdCreative adCreative) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11016xe9024041(adCreative);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAdCreativeStarted$17$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11016xe9024041(AdCreative adCreative) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAdCreativeStarted(adCreative);
        }
    }

    void handleAdTimeUpdate(final AdTimeUpdate adTimeUpdate) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11017xacab2e0e(adTimeUpdate);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAdTimeUpdate$18$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11017xacab2e0e(AdTimeUpdate adTimeUpdate) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAdTimeUpdate(adTimeUpdate);
        }
    }

    void handleAdCreativeEnded(final AdCreative adCreative) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11015x5a1c8c2a(adCreative);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAdCreativeEnded$19$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11015x5a1c8c2a(AdCreative adCreative) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAdCreativeEnded(adCreative);
        }
    }

    void handleAdBreakEnded(final AdBreak adBreak) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11013x4c2adb00(adBreak);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAdBreakEnded$20$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11013x4c2adb00(AdBreak adBreak) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAdBreakEnded(adBreak);
        }
    }

    private Player.State mapState(int i) {
        if (i == 1) {
            return Player.State.READY;
        }
        if (i == 2) {
            return Player.State.BUFFERING;
        }
        if (i == 3) {
            return Player.State.PLAYING;
        }
        if (i != 4) {
            return Player.State.IDLE;
        }
        return Player.State.ENDED;
    }

    @Override // com.amazonaws.ivs.player.Player, com.amazonaws.ivs.player.Releasable
    public void release() {
        if (this.closed.compareAndSet(false, true)) {
            this.handler.removeCallbacksAndMessages(null);
            Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
            while (it.hasNext()) {
                it.next().onRelease();
            }
            release(this.player);
            this.player = 0L;
            SuperResolution superResolution = this.superRes;
            if (superResolution != null) {
                superResolution.release();
            }
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void addPlaybackListener(PlayerInternal.PlaybackListener playbackListener) {
        this.playbackListeners.add(playbackListener);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void removePlaybackListener(PlayerInternal.PlaybackListener playbackListener) {
        this.playbackListeners.remove(playbackListener);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // com.amazonaws.ivs.player.Player
    public int getAudioSessionId() {
        return this.platform.getAudioSessionId();
    }

    @Override // com.amazonaws.ivs.player.Player
    public Player.State getState() {
        return mapState(getState(this.player));
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getPosition() {
        return getPosition(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getSyncTime() {
        return getSyncTime(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getDuration() {
        return getDuration(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getAverageBitrate() {
        return getAverageBitrate(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getBandwidthEstimate() {
        return getBandwidthEstimate(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getBufferedPosition() {
        return getBufferedPosition(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public long getLiveLatency() {
        return getLiveLatency(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public String getVersion() {
        return getVersion(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public boolean isMuted() {
        return isMuted(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setLooping(boolean z) {
        setLooping(this.player, z);
    }

    @Override // com.amazonaws.ivs.player.Player
    public boolean isLooping() {
        return isLooping(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setLogLevel(Player.LogLevel logLevel) {
        Logging.setLogLevel(logLevel.systemLogLevel());
        setLogLevel(this.player, logLevel.toString().toLowerCase());
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setMuted(boolean z) {
        setMuted(this.player, z);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setSurface(Surface surface) {
        Surface inputSurface;
        if (this.videoFrameTransformer != null && surface != null && surface.isValid() && (inputSurface = this.videoFrameTransformer.getInputSurface()) != null && this.videoFrameTransformer.setOutputSurface(surface)) {
            Logging.d("Post process frame transformer surface creation");
            setSurface(this.player, inputSurface);
            this.videoFrameTransformer.play();
            return;
        }
        setSurface(this.player, surface);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setSurfaceSize(int i, int i2) {
        setSurfaceSize(this.player, i, i2);
    }

    public void setSEIMessagesEnabled(boolean z) {
        this.config.setSEIMessagesEnabled(z);
        setConfiguration(this.player, this.config.toString());
    }

    @Override // com.amazonaws.ivs.player.Player
    public float getPlaybackRate() {
        return getPlaybackRate(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setPlaybackRate(float f) {
        setPlaybackRate(this.player, f);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setVolume(float f) {
        setVolume(this.player, f);
    }

    @Override // com.amazonaws.ivs.player.Player
    public float getVolume() {
        return getVolume(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void load(Uri uri) {
        load(new MediaPlayer.LoadOptions(uri));
    }

    @Override // com.amazonaws.ivs.player.Player
    public void load(Uri uri, String str) {
        load(new MediaPlayer.LoadOptions(uri).setMediaType(str));
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void load(final MediaPlayer.LoadOptions loadOptions) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11034lambda$load$21$comamazonawsivsplayerCorePlayerImpl(loadOptions);
            }
        });
        Resource<DeviceConfigPropertyHolder> resourceCreateDeviceConfigPropertyHolder = this.platform.createDeviceConfigPropertyHolder();
        try {
            this.config.overrideWith(loadOptions.getSessionConfig());
            Configuration configuration = this.config;
            Objects.requireNonNull(configuration);
            resourceCreateDeviceConfigPropertyHolder.let(new CorePlayerImpl$$ExternalSyntheticLambda11(configuration));
            updateMediaSinkConfiguration();
            SuperResolution superResolution = this.superRes;
            if (superResolution != null && superResolution.isEnabled) {
                this.superRes.init(this.context, this.platform);
            }
            load(this.player, loadOptions.getUri().toString(), loadOptions.getMediaType(), this.config.toString());
            if (resourceCreateDeviceConfigPropertyHolder != null) {
                resourceCreateDeviceConfigPropertyHolder.close();
            }
        } catch (Throwable th) {
            if (resourceCreateDeviceConfigPropertyHolder == null) {
                throw th;
            }
            try {
                resourceCreateDeviceConfigPropertyHolder.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$load$21$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11034lambda$load$21$comamazonawsivsplayerCorePlayerImpl(MediaPlayer.LoadOptions loadOptions) {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onLoad(loadOptions.getUri());
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void loadSource(Source source) {
        Resource<DeviceConfigPropertyHolder> resourceCreateDeviceConfigPropertyHolder = this.platform.createDeviceConfigPropertyHolder();
        try {
            Configuration configuration = this.config;
            Objects.requireNonNull(configuration);
            resourceCreateDeviceConfigPropertyHolder.let(new CorePlayerImpl$$ExternalSyntheticLambda11(configuration));
            updateMediaSinkConfiguration();
            synchronized (source) {
                long jHandle = ((HlsSource) source).handle();
                if (jHandle == 0) {
                    handleError("Source", ErrorType.ERROR_INVALID_STATE.getErrorCode(), 0, "Source object not valid.");
                    if (resourceCreateDeviceConfigPropertyHolder != null) {
                        resourceCreateDeviceConfigPropertyHolder.close();
                        return;
                    }
                    return;
                }
                loadSource(this.player, jHandle, this.config.toString());
                if (resourceCreateDeviceConfigPropertyHolder != null) {
                    resourceCreateDeviceConfigPropertyHolder.close();
                }
            }
        } catch (Throwable th) {
            if (resourceCreateDeviceConfigPropertyHolder == null) {
                throw th;
            }
            try {
                resourceCreateDeviceConfigPropertyHolder.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void loadSource(Source source, SessionConfig sessionConfig) {
        Resource<DeviceConfigPropertyHolder> resourceCreateDeviceConfigPropertyHolder = this.platform.createDeviceConfigPropertyHolder();
        try {
            this.config.overrideWith(sessionConfig);
            Configuration configuration = this.config;
            Objects.requireNonNull(configuration);
            resourceCreateDeviceConfigPropertyHolder.let(new CorePlayerImpl$$ExternalSyntheticLambda11(configuration));
            updateMediaSinkConfiguration();
            synchronized (source) {
                long jHandle = ((HlsSource) source).handle();
                if (jHandle == 0) {
                    handleError("Source", ErrorType.ERROR_INVALID_STATE.getErrorCode(), 0, "Source object not valid.");
                    if (resourceCreateDeviceConfigPropertyHolder != null) {
                        resourceCreateDeviceConfigPropertyHolder.close();
                        return;
                    }
                    return;
                }
                loadSource(this.player, jHandle, this.config.toString());
                if (resourceCreateDeviceConfigPropertyHolder != null) {
                    resourceCreateDeviceConfigPropertyHolder.close();
                }
            }
        } catch (Throwable th) {
            if (resourceCreateDeviceConfigPropertyHolder == null) {
                throw th;
            }
            try {
                resourceCreateDeviceConfigPropertyHolder.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void loadClipManifest(String str) {
        Resource<DeviceConfigPropertyHolder> resourceCreateDeviceConfigPropertyHolder = this.platform.createDeviceConfigPropertyHolder();
        try {
            Configuration configuration = this.config;
            Objects.requireNonNull(configuration);
            resourceCreateDeviceConfigPropertyHolder.let(new CorePlayerImpl$$ExternalSyntheticLambda11(configuration));
            load(this.player, str, TWITCH_CLIP_MIME_TYPE, this.config.toString());
            if (resourceCreateDeviceConfigPropertyHolder != null) {
                resourceCreateDeviceConfigPropertyHolder.close();
            }
        } catch (Throwable th) {
            if (resourceCreateDeviceConfigPropertyHolder == null) {
                throw th;
            }
            try {
                resourceCreateDeviceConfigPropertyHolder.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void preload(Uri uri, Source.Listener listener) {
        preload(this.player, uri.toString(), this.handler, listener);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public HashSet<SourceGroup> getSourceGroups() {
        return getSourceGroups(this.player);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public SourceGroup getSourceGroup() {
        return getSourceGroup(this.player);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setSourceGroup(String str) {
        setSourceGroup(this.player, str, false);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setSourceGroup(String str, boolean z) {
        setSourceGroup(this.player, str, z);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void seekTo(long j) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11038lambda$seekTo$22$comamazonawsivsplayerCorePlayerImpl();
            }
        });
        seekTo(this.player, j);
    }

    /* JADX INFO: renamed from: lambda$seekTo$22$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11038lambda$seekTo$22$comamazonawsivsplayerCorePlayerImpl() {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSeek();
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public void play() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11037lambda$play$23$comamazonawsivsplayerCorePlayerImpl();
            }
        });
        play(this.player);
    }

    /* JADX INFO: renamed from: lambda$play$23$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11037lambda$play$23$comamazonawsivsplayerCorePlayerImpl() {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlay();
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public void pause() {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11036lambda$pause$24$comamazonawsivsplayerCorePlayerImpl();
            }
        });
        pause(this.player);
    }

    /* JADX INFO: renamed from: lambda$pause$24$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11036lambda$pause$24$comamazonawsivsplayerCorePlayerImpl() {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void skipAd() {
        skipAd(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public Set<Quality> getQualities() {
        HashSet<Quality> qualities = getQualities(this.player);
        if (qualities != null) {
            return qualities;
        }
        handleError("Unspecified", ErrorType.ERROR.getErrorCode(), 0, "Failed to retrieve qualities");
        return new HashSet();
    }

    @Override // com.amazonaws.ivs.player.Player
    public Quality getQuality() {
        Quality quality = getQuality(this.player);
        if (quality != null) {
            return quality;
        }
        handleError("Unspecified", ErrorType.ERROR.getErrorCode(), 0, "Failed to retrieve quality");
        return new Quality("", "", "", "", new String[0], 0, 0, 0, 0.0f, false);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setQuality(final Quality quality) {
        final Quality quality2 = getQuality();
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11041lambda$setQuality$25$comamazonawsivsplayerCorePlayerImpl(quality2, quality);
            }
        });
        setQuality(this.player, quality.getName(), false);
    }

    /* JADX INFO: renamed from: lambda$setQuality$25$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11041lambda$setQuality$25$comamazonawsivsplayerCorePlayerImpl(Quality quality, Quality quality2) {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSetQuality(quality, quality2, false);
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setQuality(final Quality quality, final boolean z) {
        final Quality quality2 = getQuality();
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11042lambda$setQuality$26$comamazonawsivsplayerCorePlayerImpl(quality2, quality, z);
            }
        });
        setQuality(this.player, quality.getName(), z);
    }

    /* JADX INFO: renamed from: lambda$setQuality$26$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11042lambda$setQuality$26$comamazonawsivsplayerCorePlayerImpl(Quality quality, Quality quality2, boolean z) {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSetQuality(quality, quality2, z);
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public Set<UnavailableQuality> getUnavailableQualities() {
        return getUnavailableQualities(this.player);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setTextTrack(TextTrack textTrack) {
        setTextTrack(this.player, textTrack);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public List<TextTrack> getTextTracks() {
        List<TextTrack> textTracks = getTextTracks(this.player);
        return textTracks != null ? textTracks : Collections.EMPTY_LIST;
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public TextTrack getTextTrack() {
        return getTextTrack(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public boolean isAutoQualityMode() {
        return isAutoQualityMode(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setAutoQualityMode(final boolean z) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11039x731b0d9c(z);
            }
        });
        setAutoQualityMode(this.player, z, false);
    }

    /* JADX INFO: renamed from: lambda$setAutoQualityMode$27$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11039x731b0d9c(boolean z) {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSetAutoQualityMode(z, false);
        }
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setAutoQualityMode(final boolean z, final boolean z2) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11040xffbb389d(z, z2);
            }
        });
        setAutoQualityMode(this.player, z, z2);
    }

    /* JADX INFO: renamed from: lambda$setAutoQualityMode$28$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11040xffbb389d(boolean z, boolean z2) {
        Iterator<PlayerInternal.PlaybackListener> it = this.playbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSetAutoQualityMode(z, z2);
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setAutoInitialBitrate(int i) {
        setAutoInitialBitrate(this.player, i);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setAutoMaxBitrate(int i) {
        setAutoMaxBitrate(this.player, i);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setAutoMaxVideoSize(int i, int i2) {
        setAutoMaxVideoSize(this.player, i, i2);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setAutoMaxQuality(Quality quality) {
        setAutoMaxQuality(this.player, quality);
    }

    @Override // com.amazonaws.ivs.player.Player
    public boolean isLiveLowLatency() {
        return isLiveLowLatency(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setLiveLowLatencyEnabled(boolean z) {
        setLiveLowLatencyEnabled(this.player, z);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setRebufferToLive(boolean z) {
        setRebufferToLive(this.player, z);
    }

    @Override // com.amazonaws.ivs.player.Player
    public Statistics getStatistics() {
        getStatistics(this.player, this.statistics);
        return this.statistics;
    }

    @Override // com.amazonaws.ivs.player.Player
    public String getSessionId() {
        return getSessionId(this.player);
    }

    @Override // com.amazonaws.ivs.player.Player
    public String[] getChannelMetadata() {
        return getChannelMetadata(this.player);
    }

    @Override // com.amazonaws.ivs.player.VideoRenderer.VideoSizeListener
    public void onSizeChange(final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.CorePlayerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11035lambda$onSizeChange$29$comamazonawsivsplayerCorePlayerImpl(i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onSizeChange$29$com-amazonaws-ivs-player-CorePlayerImpl, reason: not valid java name */
    /* synthetic */ void m11035lambda$onSizeChange$29$comamazonawsivsplayerCorePlayerImpl(int i, int i2) {
        Iterator<Player.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(i, i2);
        }
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setInitialBufferDuration(long j) {
        setInitialBufferDuration(this.player, j);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setOrigin(String str) {
        setOrigin(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setNetworkRecoveryMode(Player.NetworkRecoveryMode networkRecoveryMode) {
        setResumeAfterReconnect(this.player, Player.NetworkRecoveryMode.RESUME.equals(networkRecoveryMode));
    }

    @Override // com.amazonaws.ivs.player.Player
    public String getPath() {
        return getPath(this.player);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public String getProtocol() {
        return getProtocol(this.player);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setAuthToken(String str) {
        setAuthToken(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setClientId(String str) {
        setClientId(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setDeviceId(String str) {
        setDeviceId(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public Configuration getConfiguration() {
        return this.config;
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setConfiguration(String str) {
        setConfiguration(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.Player
    public void setUserAgent(String str) {
        setUserAgent(this.player, str);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public void setDrmEnabled(boolean z) {
        Logging.d("setDrmEnabled " + z);
        if (z) {
            Platform.getSupportedProtectionSystemUUIDs();
        }
        setDrmEnabled(this.player, z);
    }

    @Override // com.amazonaws.ivs.player.PlayerInternal
    public float getMaxPlaybackRateForQuality(Quality quality) {
        return this.platform.getMaxPlaybackRateForQuality(quality);
    }

    private void setDisplaySize(int i, int i2) {
        setDisplaySize(this.player, i, i2);
    }

    SuperResolution getSuperResolutionFeature() {
        return this.superRes;
    }

    ArrayList<IVSFeature<?>> getFeatures() {
        return this.features;
    }

    @Override // com.amazonaws.ivs.player.IVSFeature.EventListener
    public void onEvent(Object obj) {
        if (obj instanceof GPUAnalyticsEvent.GPUInitAnalyticsEvent) {
            onGpuInitEvent(this.player, (GPUAnalyticsEvent.GPUInitAnalyticsEvent) obj);
        } else if (obj instanceof GPUAnalyticsEvent.GPUStatusAnalyticsEvent) {
            onGpuStatusEvent(this.player, (GPUAnalyticsEvent.GPUStatusAnalyticsEvent) obj);
        } else if (obj instanceof GPUAnalyticsEvent.GPUErrorAnalyticsEvent) {
            onGpuErrorEvent(this.player, (GPUAnalyticsEvent.GPUErrorAnalyticsEvent) obj);
        }
    }

    private ArrayList<IVSFeature<?>> addSupportedFeatures() {
        ArrayList<IVSFeature<?>> arrayList = new ArrayList<>();
        SuperResolution superResolution = new SuperResolution();
        this.superRes = superResolution;
        superResolution.registerEventListener(this);
        arrayList.add(this.superRes);
        arrayList.add(new AdaptiveBitrateFeature());
        arrayList.add(new AnalyticsFeature());
        arrayList.add(new ProbeV2Feature());
        arrayList.add(new MediaSinkFeature());
        arrayList.add(new HlsSubtitlePlaylistsFeature());
        Iterator<IVSFeature<?>> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().init(this.platform);
        }
        return arrayList;
    }

    private void updateMediaSinkConfiguration() {
        MediaSinkFeature mediaSinkFeature = null;
        HlsSubtitlePlaylistsFeature hlsSubtitlePlaylistsFeature = null;
        for (IVSFeature<?> iVSFeature : this.features) {
            if (iVSFeature instanceof MediaSinkFeature) {
                mediaSinkFeature = (MediaSinkFeature) iVSFeature;
            } else if (iVSFeature instanceof HlsSubtitlePlaylistsFeature) {
                hlsSubtitlePlaylistsFeature = (HlsSubtitlePlaylistsFeature) iVSFeature;
            }
            if (mediaSinkFeature != null && hlsSubtitlePlaylistsFeature != null) {
                break;
            }
        }
        if (mediaSinkFeature != null) {
            MediaSinkFeature.Config config = mediaSinkFeature.getConfig();
            this.platform.updateMediaSinkConfiguration(config.enableMediaSinkJNI, config.enableMediaSinkJNIForDrmContent);
        }
        this.platform.setSeparateVttTrackSinkEnabled(hlsSubtitlePlaylistsFeature != null && hlsSubtitlePlaylistsFeature.isEnabled);
    }
}
