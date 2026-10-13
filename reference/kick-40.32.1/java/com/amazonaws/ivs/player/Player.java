package com.amazonaws.ivs.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface Player extends Releasable {

    public static abstract class Listener {
        public void onAdBreakEnded(AdBreak adBreak) {
        }

        public void onAdBreakStarted(AdBreak adBreak) {
        }

        public void onAdCreativeEnded(AdCreative adCreative) {
        }

        public void onAdCreativeStarted(AdCreative adCreative) {
        }

        public void onAdTimeUpdate(AdTimeUpdate adTimeUpdate) {
        }

        public void onAnalyticsEvent(String str, String str2) {
        }

        public abstract void onCue(Cue cue);

        public abstract void onDurationChanged(long j);

        public abstract void onError(PlayerException playerException);

        public void onMetadata(String str, ByteBuffer byteBuffer) {
        }

        public void onNetworkUnavailable() {
        }

        public abstract void onQualityChanged(Quality quality);

        public abstract void onRebuffering();

        public abstract void onSeekCompleted(long j);

        public void onSeiMessage(SeiMessage seiMessage) {
        }

        public void onSourceGroupChanged(SourceGroup sourceGroup) {
        }

        public abstract void onStateChanged(State state);

        public void onSyncTimeChanged(long j) {
        }

        public void onTextTrackChanged(TextTrack textTrack) {
        }

        public void onTextTracksChanged(List<TextTrack> list) {
        }

        public void onVideoFirstFrame(long j) {
        }

        public abstract void onVideoSizeChanged(int i, int i2);
    }

    public enum NetworkRecoveryMode {
        NONE,
        RESUME
    }

    public enum State {
        BUFFERING,
        PLAYING,
        READY,
        IDLE,
        ENDED
    }

    void addListener(Listener listener);

    int getAudioSessionId();

    long getAverageBitrate();

    long getBandwidthEstimate();

    long getBufferedPosition();

    String[] getChannelMetadata();

    long getDuration();

    long getLiveLatency();

    String getPath();

    float getPlaybackRate();

    long getPosition();

    Set<Quality> getQualities();

    Quality getQuality();

    String getSessionId();

    State getState();

    Statistics getStatistics();

    long getSyncTime();

    Set<UnavailableQuality> getUnavailableQualities();

    String getVersion();

    float getVolume();

    boolean isAutoQualityMode();

    boolean isLiveLowLatency();

    boolean isLooping();

    boolean isMuted();

    void load(Uri uri);

    void load(Uri uri, String str);

    void pause();

    void play();

    @Override // com.amazonaws.ivs.player.Releasable
    void release();

    void removeListener(Listener listener);

    void seekTo(long j);

    void setAutoInitialBitrate(int i);

    void setAutoMaxBitrate(int i);

    void setAutoMaxQuality(Quality quality);

    void setAutoMaxVideoSize(int i, int i2);

    void setAutoQualityMode(boolean z);

    void setInitialBufferDuration(long j);

    void setLiveLowLatencyEnabled(boolean z);

    void setLogLevel(LogLevel logLevel);

    void setLooping(boolean z);

    void setMuted(boolean z);

    void setNetworkRecoveryMode(NetworkRecoveryMode networkRecoveryMode);

    void setOrigin(String str);

    void setPlaybackRate(float f);

    void setQuality(Quality quality);

    void setQuality(Quality quality, boolean z);

    void setRebufferToLive(boolean z);

    void setSurface(Surface surface);

    void setUserAgent(String str);

    void setVolume(float f);

    public static class Factory {
        private Factory() {
        }

        public static Player create(Context context) {
            return new MediaPlayer.Builder(context.getApplicationContext()).build();
        }
    }

    public enum LogLevel {
        DEBUG(3),
        INFO(4),
        WARNING(5),
        ERROR(6);

        private final int systemLogLevel;

        LogLevel(int i) {
            this.systemLogLevel = i;
        }

        int systemLogLevel() {
            return this.systemLogLevel;
        }
    }
}
