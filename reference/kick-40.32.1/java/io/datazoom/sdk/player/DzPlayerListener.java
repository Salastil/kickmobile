package io.datazoom.sdk.player;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzPlayerListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H&J\b\u0010(\u001a\u00020\u0005H&¨\u0006)À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/player/DzPlayerListener;", "", "onVolumeChange", "", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "", "muted", "", "onPlaybackStateChange", "state", "Lio/datazoom/sdk/player/DzPlayerState;", "onPlayWhenReadyChanged", "playWhenReady", "reason", "onPlaybackError", "errorCode", "errorMessage", "", "onRepeatModeChanged", "isLoop", "videoSizeChanged", ViewProps.HEIGHT, ViewProps.WIDTH, "onTracksChanged", "tracks", "", "Lio/datazoom/sdk/player/TrackInfo;", "onIsLoadingChanged", "isLoading", "onPlaybackParametersChanged", "speed", "", "onMediaRequested", "onTimelineChange", "mediaChanged", "onPlayerSizeChange", "onSeek", "oldPosition", "", "newPosition", "getTrackIndex", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DzPlayerListener {
    int getTrackIndex();

    default void onIsLoadingChanged(boolean isLoading) {
    }

    default void onMediaRequested() {
    }

    void onPlayWhenReadyChanged(boolean playWhenReady, int reason);

    void onPlaybackError(int errorCode, String errorMessage);

    void onPlaybackParametersChanged(float speed);

    void onPlaybackStateChange(DzPlayerState state);

    default void onPlayerSizeChange(int height, int width) {
    }

    void onRepeatModeChanged(boolean isLoop);

    void onSeek(long oldPosition, long newPosition);

    void onTimelineChange(boolean mediaChanged);

    default void onTracksChanged(List<TrackInfo> tracks) {
        Intrinsics.checkNotNullParameter(tracks, "tracks");
    }

    void onVolumeChange(int volume, boolean muted);

    void videoSizeChanged(int height, int width);

    /* JADX INFO: compiled from: DzPlayerListener.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onTracksChanged(DzPlayerListener dzPlayerListener, List<TrackInfo> tracks) {
            Intrinsics.checkNotNullParameter(tracks, "tracks");
            DzPlayerListener.super.onTracksChanged(tracks);
        }

        @Deprecated
        public static void onIsLoadingChanged(DzPlayerListener dzPlayerListener, boolean z) {
            DzPlayerListener.super.onIsLoadingChanged(z);
        }

        @Deprecated
        public static void onMediaRequested(DzPlayerListener dzPlayerListener) {
            DzPlayerListener.super.onMediaRequested();
        }

        @Deprecated
        public static void onPlayerSizeChange(DzPlayerListener dzPlayerListener, int i, int i2) {
            DzPlayerListener.super.onPlayerSizeChange(i, i2);
        }
    }
}
