package io.datazoom.sdk.player;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import io.datazoom.sdk.data.memory.FluxDataStoreExtensionsKt;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelegatingPlayerListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\r\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0002\b-J\u0006\u0010.\u001a\u00020\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006/"}, d2 = {"Lio/datazoom/sdk/player/DelegatingPlayerListener;", "Lio/datazoom/sdk/player/DzPlayerListener;", "delegate", "Lio/datazoom/sdk/player/PlayerListenerDelegate;", "<init>", "(Lio/datazoom/sdk/player/PlayerListenerDelegate;)V", "playerState", "Lio/datazoom/sdk/player/DzPlayerState;", "getPlayerState", "()Lio/datazoom/sdk/player/DzPlayerState;", "setPlayerState", "(Lio/datazoom/sdk/player/DzPlayerState;)V", "onVolumeChange", "", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "", "muted", "", "onPlaybackStateChange", "state", "onPlayWhenReadyChanged", "playWhenReady", "reason", "onPlaybackError", "errorCode", "errorMessage", "", "onRepeatModeChanged", "isLoop", "videoSizeChanged", ViewProps.HEIGHT, ViewProps.WIDTH, "onPlayerSizeChange", "onPlaybackParametersChanged", "speed", "", "onMediaRequested", "onTimelineChange", "mediaChanged", "onSeek", "oldPosition", "", "newPosition", "getTrackIndex", "hasDelegate", "hasDelegate$base", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DelegatingPlayerListener implements DzPlayerListener {
    private volatile PlayerListenerDelegate delegate;
    private volatile DzPlayerState playerState;

    public DelegatingPlayerListener(PlayerListenerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.playerState = DzPlayerState.Idle.INSTANCE;
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public /* bridge */ void onIsLoadingChanged(boolean z) {
        super.onIsLoadingChanged(z);
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public /* bridge */ void onTracksChanged(List<TrackInfo> list) {
        super.onTracksChanged(list);
    }

    public final DzPlayerState getPlayerState() {
        return this.playerState;
    }

    public final void setPlayerState(DzPlayerState dzPlayerState) {
        Intrinsics.checkNotNullParameter(dzPlayerState, "<set-?>");
        this.playerState = dzPlayerState;
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onVolumeChange(int volume, boolean muted) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate != null) {
            playerListenerDelegate.onVolumeChanged(volume);
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onPlaybackStateChange(DzPlayerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        playerListenerDelegate.setStateInFluxData(state);
        if (playerListenerDelegate.isPlayingAd()) {
            return;
        }
        if (Intrinsics.areEqual(state, DzPlayerState.Idle.INSTANCE)) {
            playerListenerDelegate.setState(State.Content.IDLE.INSTANCE, new HashMap<>());
        } else if (Intrinsics.areEqual(state, DzPlayerState.Ready.INSTANCE)) {
            if (playerListenerDelegate.playWhenReady()) {
                if (!playerListenerDelegate.isSessionAlive()) {
                    playerListenerDelegate.setState(State.Content.REQUESTED.INSTANCE, new HashMap<>());
                    playerListenerDelegate.setState(State.Content.BUFFERING.INSTANCE, new HashMap<>());
                }
                playerListenerDelegate.setState(State.Content.PLAYING.INSTANCE, new HashMap<>());
                playerListenerDelegate.updateMetadataWithMedia();
            } else {
                playerListenerDelegate.setState(State.Content.IDLE.INSTANCE, new HashMap<>());
            }
        } else if (Intrinsics.areEqual(state, DzPlayerState.Ended.INSTANCE)) {
            playerListenerDelegate.setState(State.Content.COMPLETED.INSTANCE, new HashMap<>());
        } else {
            if (!Intrinsics.areEqual(state, DzPlayerState.Buffering.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            playerListenerDelegate.setState(State.Content.BUFFERING.INSTANCE, new HashMap<>());
        }
        this.playerState = state;
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        if (playWhenReady) {
            if (!playerListenerDelegate.isSessionAlive()) {
                playerListenerDelegate.setState(State.Content.REQUESTED.INSTANCE, new HashMap<>());
                playerListenerDelegate.setState(State.Content.BUFFERING.INSTANCE, new HashMap<>());
            }
            playerListenerDelegate.setState(playerListenerDelegate.isPlayingAd() ? State.Ad.PLAYING.INSTANCE : State.Content.PLAYING.INSTANCE, new HashMap<>());
            playerListenerDelegate.updateMetadataWithMedia();
        } else {
            playerListenerDelegate.setState(playerListenerDelegate.isPlayingAd() ? State.Ad.PAUSED.INSTANCE : State.Content.PAUSED.INSTANCE, new HashMap<>());
        }
        playerListenerDelegate.setFlux(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYER_STATE, playWhenReady ? PlayingEvent.TYPE : "paused"));
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onPlaybackError(int errorCode, String errorMessage) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate != null) {
            State stateError = State.INSTANCE.error(true);
            HashMap<String, Object> map = new HashMap<>();
            map.put(MetaData.Type.ERROR_CODE.getValue(), Integer.valueOf(errorCode));
            if (errorMessage != null) {
                map.put(MetaData.Type.ERROR_MSG.getValue(), errorMessage);
            }
            Unit unit = Unit.INSTANCE;
            playerListenerDelegate.setState(stateError, map);
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onRepeatModeChanged(boolean isLoop) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate != null) {
            playerListenerDelegate.setMeta(MetaData.Type.LOOP, Boolean.valueOf(isLoop));
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void videoSizeChanged(int height, int width) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        playerListenerDelegate.onTrackChange(width, height, playerListenerDelegate.bitrate());
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onPlayerSizeChange(int height, int width) {
        super.onPlayerSizeChange(height, width);
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate != null) {
            playerListenerDelegate.setPlayerDimensions(height, width);
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onPlaybackParametersChanged(float speed) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        playerListenerDelegate.setFlux(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_RATE, Float.valueOf(speed)));
        playerListenerDelegate.setMeta(MetaData.Type.PLAYBACK_RATE_DEFAULT, Float.valueOf(speed));
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onMediaRequested() {
        super.onMediaRequested();
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        playerListenerDelegate.updateMetadataWithMedia();
        if (playerListenerDelegate.playWhenReady()) {
            playerListenerDelegate.setState(State.Content.REQUESTED.INSTANCE, new HashMap<>());
            if (playerListenerDelegate.isPlaying()) {
                playerListenerDelegate.setState(State.Content.BUFFERING.INSTANCE, new HashMap<>());
                playerListenerDelegate.setState(State.Content.PLAYING.INSTANCE, new HashMap<>());
            }
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onTimelineChange(boolean mediaChanged) {
        PlayerListenerDelegate playerListenerDelegate;
        Boolean boolIsLiveSupplier;
        if (!mediaChanged || (playerListenerDelegate = this.delegate) == null || (boolIsLiveSupplier = playerListenerDelegate.isLiveSupplier()) == null) {
            return;
        }
        boolean zBooleanValue = boolIsLiveSupplier.booleanValue();
        PlayerListenerDelegate playerListenerDelegate2 = this.delegate;
        if (playerListenerDelegate2 != null) {
            playerListenerDelegate2.setLiveState(zBooleanValue);
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public void onSeek(long oldPosition, long newPosition) {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate == null) {
            return;
        }
        playerListenerDelegate.setState(playerListenerDelegate.isPlayingAd() ? State.Ad.SEEKING.INSTANCE : State.Content.SEEKING.INSTANCE, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.SEEK_START_POINT.getValue(), Long.valueOf(oldPosition)), TuplesKt.to(MetaData.Type.SEEK_END_POINT.getValue(), Long.valueOf(newPosition))));
    }

    @Override // io.datazoom.sdk.player.DzPlayerListener
    public int getTrackIndex() {
        PlayerListenerDelegate playerListenerDelegate = this.delegate;
        if (playerListenerDelegate != null) {
            return playerListenerDelegate.trackIndex();
        }
        return 0;
    }

    public final boolean hasDelegate$base() {
        return this.delegate != null;
    }

    public final void clear() {
        this.delegate = null;
    }
}
