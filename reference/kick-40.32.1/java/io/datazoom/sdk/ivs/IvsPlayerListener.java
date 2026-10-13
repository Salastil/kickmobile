package io.datazoom.sdk.ivs;

import com.amazonaws.ivs.player.AdBreak;
import com.amazonaws.ivs.player.Cue;
import com.amazonaws.ivs.player.Player;
import com.amazonaws.ivs.player.PlayerException;
import com.amazonaws.ivs.player.Quality;
import com.facebook.react.uimanager.ViewProps;
import io.datazoom.sdk.ad.DzAdPlayerListener;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.player.DzPlayerListener;
import io.datazoom.sdk.player.DzPlayerStateKt;
import io.datazoom.sdk.player.TrackInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IvsPlayerListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006+"}, d2 = {"Lio/datazoom/sdk/ivs/IvsPlayerListener;", "Lcom/amazonaws/ivs/player/Player$Listener;", "playerListener", "Lio/datazoom/sdk/player/DzPlayerListener;", "<init>", "(Lio/datazoom/sdk/player/DzPlayerListener;)V", "adListener", "Lio/datazoom/sdk/ad/DzAdPlayerListener;", "getAdListener", "()Lio/datazoom/sdk/ad/DzAdPlayerListener;", "setAdListener", "(Lio/datazoom/sdk/ad/DzAdPlayerListener;)V", "onCue", "", "cue", "Lcom/amazonaws/ivs/player/Cue;", "onDurationChanged", "duration", "", "onAnalyticsEvent", "name", "", "properties", "onStateChanged", "state", "Lcom/amazonaws/ivs/player/Player$State;", "onError", "error", "Lcom/amazonaws/ivs/player/PlayerException;", "onRebuffering", "onSeekCompleted", ViewProps.POSITION, "onVideoSizeChanged", ViewProps.WIDTH, "", ViewProps.HEIGHT, "onQualityChanged", "quality", "Lcom/amazonaws/ivs/player/Quality;", "onAdBreakStarted", "adBreak", "Lcom/amazonaws/ivs/player/AdBreak;", "onAdBreakEnded", "ivs_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IvsPlayerListener extends Player.Listener {
    private DzAdPlayerListener adListener;
    private final DzPlayerListener playerListener;

    public IvsPlayerListener(DzPlayerListener playerListener) {
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        this.playerListener = playerListener;
    }

    public final DzAdPlayerListener getAdListener() {
        return this.adListener;
    }

    public final void setAdListener(DzAdPlayerListener dzAdPlayerListener) {
        this.adListener = dzAdPlayerListener;
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onCue(Cue cue) {
        Intrinsics.checkNotNullParameter(cue, "cue");
        Logger_androidKt.getLogger().v("IvsPlayerListener.onCue start=" + cue.startTime + ", end=" + cue.endTime);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onDurationChanged(long duration) {
        Logger_androidKt.getLogger().v("IvsPlayerListener.onDurationChanged duration=" + duration);
        this.playerListener.onTimelineChange(true);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onAnalyticsEvent(String name, String properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        super.onAnalyticsEvent(name, properties);
        Logger_androidKt.getLogger().v("IvsPlayerListener.onAnalyticsEvent name=" + name + ", properties=" + properties);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onStateChanged(Player.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Logger_androidKt.getLogger().v("IvsPlayerListener.onStateChanged state=" + state);
        this.playerListener.onIsLoadingChanged(state == Player.State.BUFFERING);
        Player.State state2 = Player.State.IDLE;
        DzPlayerListener dzPlayerListener = this.playerListener;
        if (state != state2) {
            dzPlayerListener.onPlaybackStateChange(DzPlayerStateKt.wrapperStateFrom(IvsPlayerListenerKt.toDzStateIndex(state)));
        } else {
            dzPlayerListener.onPlayWhenReadyChanged(false, 0);
        }
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onError(PlayerException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Logger_androidKt.getLogger().e("IvsPlayerListener.onError code=" + error.getCode() + ", message=" + error.getMessage());
        this.playerListener.onPlaybackError(error.getCode(), error.getMessage());
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onRebuffering() {
        Logger_androidKt.getLogger().v("IvsPlayerListener.onRebuffering");
        this.playerListener.onPlaybackStateChange(DzPlayerStateKt.wrapperStateFrom(IvsPlayerListenerKt.toDzStateIndex(Player.State.BUFFERING)));
        this.playerListener.onIsLoadingChanged(true);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onSeekCompleted(long position) {
        Logger_androidKt.getLogger().v("IvsPlayerListener.onSeekCompleted position=" + position);
        this.playerListener.onSeek(position, position);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onVideoSizeChanged(int width, int height) {
        Logger_androidKt.getLogger().v("IvsPlayerListener.onVideoSizeChanged width=" + width + ", height=" + height);
        if (width <= 0 || height <= 0) {
            return;
        }
        this.playerListener.videoSizeChanged(height, width);
        this.playerListener.onPlayerSizeChange(height, width);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onQualityChanged(Quality quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Logger_androidKt.getLogger().v("IvsPlayerListener.onQualityChanged bitrate=" + quality.getBitrate() + ", width=" + quality.getWidth() + ", height=" + quality.getHeight());
        if (quality.getBitrate() > 0) {
            this.playerListener.onTracksChanged(CollectionsKt.listOf(new TrackInfo(quality.getBitrate() / 1024, quality.getHeight(), quality.getWidth())));
        }
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onAdBreakStarted(AdBreak adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        super.onAdBreakStarted(adBreak);
        String sessionId = adBreak.getMetadata().getSessionId();
        if (sessionId == null) {
            sessionId = "unknown_session";
        }
        String trackingData = adBreak.getMetadata().getTrackingData();
        if (trackingData == null) {
            trackingData = "no_tracking_info";
        }
        Logger_androidKt.getLogger().v("IvsPlayerListener.onAdBreakStarted sessionId=" + sessionId + ", trackingInfo=" + trackingData);
        DzAdPlayerListener dzAdPlayerListener = this.adListener;
        if (dzAdPlayerListener != null) {
            String adBreakId = adBreak.getAdBreakId();
            Intrinsics.checkNotNullExpressionValue(adBreakId, "getAdBreakId(...)");
            dzAdPlayerListener.onAdStarted(new DzAdSessionMetadata(adBreakId, sessionId, trackingData, null));
        }
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onAdBreakEnded(AdBreak adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        super.onAdBreakEnded(adBreak);
        Logger_androidKt.getLogger().v("IvsPlayerListener.onAdBreakEnded id=" + adBreak.getAdBreakId());
    }
}
