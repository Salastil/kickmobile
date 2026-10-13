package io.datazoom.sdk.player;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import io.datazoom.sdk.BaseContext;
import io.datazoom.sdk.DzAdapter;
import io.datazoom.sdk.ad.DzAdPlayerListener;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.data.memory.FluxDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.Media;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.threading.SdkDispatcher;
import io.datazoom.sdk.utils.MainThreadRunner;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: PlayerAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\n*\u0002\t\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u001a\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0014\u00102\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001dR\u0014\u00103\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u001dR\u0014\u00105\u001a\u00020-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b6\u0010/R\u0016\u00107\u001a\u0004\u0018\u0001088TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020<8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0014\u0010D\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010A¨\u0006F"}, d2 = {"Lio/datazoom/sdk/player/PlayerAdapter;", "Lio/datazoom/sdk/DzAdapter;", "player", "Lio/datazoom/sdk/player/DzPlayer;", "baseContext", "Lio/datazoom/sdk/BaseContext;", "<init>", "(Lio/datazoom/sdk/player/DzPlayer;Lio/datazoom/sdk/BaseContext;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "io/datazoom/sdk/player/PlayerAdapter$listener$1", "Lio/datazoom/sdk/player/PlayerAdapter$listener$1;", "dzPlayerListener", "io/datazoom/sdk/player/PlayerAdapter$dzPlayerListener$1", "Lio/datazoom/sdk/player/PlayerAdapter$dzPlayerListener$1;", "setStateInFluxData", "", "state", "Lio/datazoom/sdk/player/DzPlayerState;", "updateMetadataWithMedia", "streamingProtocol", "", ImagesContract.URL, "mimeType", "convertMimeTypeToProtocol", "convertURLExtensionToProtocol", "onDestroy", "playWhenReady", "", "getPlayWhenReady", "()Z", "speed", "", "getSpeed", "()F", "isPlaying", "isPause", "playHeadDuration", "", "getPlayHeadDuration", "()J", "contentDurationMs", "getContentDurationMs", "bufferDuration", "getBufferDuration", "bitrate", "", "getBitrate", "()I", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "getVolume", "isMuted", "defaultMuted", "getDefaultMuted", "audioBitrate", "getAudioBitrate", "currentMedia", "Lio/datazoom/sdk/model/Media;", "getCurrentMedia", "()Lio/datazoom/sdk/model/Media;", "currentWindowStart", "", "getCurrentWindowStart", "()D", "playerName", "getPlayerName", "()Ljava/lang/String;", "sdkVersion", "getSdkVersion", "playerId", "getPlayerId", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayerAdapter extends DzAdapter {
    private final PlayerAdapter$dzPlayerListener$1 dzPlayerListener;
    private final PlayerAdapter$listener$1 listener;
    private final DzPlayer player;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [io.datazoom.sdk.player.PlayerAdapter$dzPlayerListener$1] */
    /* JADX WARN: Type inference failed for: r12v1, types: [io.datazoom.sdk.player.PlayerAdapter$listener$1] */
    public PlayerAdapter(DzPlayer player, BaseContext baseContext) {
        super(baseContext);
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        this.player = player;
        ?? r12 = new DzPlayerListener() { // from class: io.datazoom.sdk.player.PlayerAdapter$listener$1
            private DzPlayerState playerState = DzPlayerState.Idle.INSTANCE;

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
                this.this$0.onVolumeChanged(volume);
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onPlaybackStateChange(DzPlayerState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                this.this$0.setStateInFluxData(state);
                if (this.this$0.isPlayingAd()) {
                    return;
                }
                Object objRunBlocking = false;
                PlayerAdapter playerAdapter = this.this$0;
                MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
                try {
                    objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$listener$1$onPlaybackStateChange$$inlined$safeOnMain$1(null, playerAdapter));
                } catch (Exception e) {
                    Logger_androidKt.getLogger().e("playWhenReady.onPlaybackStateChange error: " + e.getMessage());
                }
                boolean zBooleanValue = ((Boolean) objRunBlocking).booleanValue();
                if (Intrinsics.areEqual(state, DzPlayerState.Idle.INSTANCE)) {
                    DzAdapter.setState$default(this.this$0, State.Content.IDLE.INSTANCE, null, 2, null);
                } else if (Intrinsics.areEqual(state, DzPlayerState.Ready.INSTANCE)) {
                    PlayerAdapter playerAdapter2 = this.this$0;
                    if (zBooleanValue) {
                        if (!playerAdapter2.isSessionAlive()) {
                            DzAdapter.setState$default(this.this$0, State.Content.REQUESTED.INSTANCE, null, 2, null);
                            DzAdapter.setState$default(this.this$0, State.Content.BUFFERING.INSTANCE, null, 2, null);
                        }
                        DzAdapter.setState$default(this.this$0, State.Content.PLAYING.INSTANCE, null, 2, null);
                        this.this$0.updateMetadataWithMedia();
                    } else {
                        DzAdapter.setState$default(playerAdapter2, State.Content.IDLE.INSTANCE, null, 2, null);
                    }
                } else if (Intrinsics.areEqual(state, DzPlayerState.Ended.INSTANCE)) {
                    DzAdapter.setState$default(this.this$0, State.Content.COMPLETED.INSTANCE, null, 2, null);
                } else {
                    if (!Intrinsics.areEqual(state, DzPlayerState.Buffering.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DzAdapter.setState$default(this.this$0, State.Content.BUFFERING.INSTANCE, null, 2, null);
                }
                this.playerState = state;
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
                PlayerAdapter playerAdapter = this.this$0;
                if (playWhenReady) {
                    if (!playerAdapter.isSessionAlive()) {
                        DzAdapter.setState$default(this.this$0, State.Content.REQUESTED.INSTANCE, null, 2, null);
                        DzAdapter.setState$default(this.this$0, State.Content.BUFFERING.INSTANCE, null, 2, null);
                    }
                    PlayerAdapter playerAdapter2 = this.this$0;
                    DzAdapter.setState$default(playerAdapter2, playerAdapter2.isPlayingAd() ? State.Ad.PLAYING.INSTANCE : State.Content.PLAYING.INSTANCE, null, 2, null);
                    this.this$0.updateMetadataWithMedia();
                } else {
                    DzAdapter.setState$default(playerAdapter, playerAdapter.isPlayingAd() ? State.Ad.PAUSED.INSTANCE : State.Content.PAUSED.INSTANCE, null, 2, null);
                }
                this.this$0.setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYER_STATE, playWhenReady ? PlayingEvent.TYPE : "paused"));
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onPlaybackError(int errorCode, String errorMessage) {
                PlayerAdapter playerAdapter = this.this$0;
                State stateError = State.INSTANCE.error(true);
                HashMap map = new HashMap();
                map.put(MetaData.Type.ERROR_CODE.getValue(), Integer.valueOf(errorCode));
                if (errorMessage != null) {
                    map.put(MetaData.Type.ERROR_MSG.getValue(), errorMessage);
                }
                Unit unit = Unit.INSTANCE;
                playerAdapter.setState(stateError, map);
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onRepeatModeChanged(boolean isLoop) {
                this.this$0.setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.LOOP, Boolean.valueOf(isLoop)));
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void videoSizeChanged(int height, int width) {
                PlayerAdapter playerAdapter = this.this$0;
                playerAdapter.onTrackChange$base(width, height, playerAdapter.getBitrate());
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onPlayerSizeChange(int height, int width) {
                super.onPlayerSizeChange(height, width);
                this.this$0.setPlayerDimensions(width, height);
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onPlaybackParametersChanged(float speed) {
                this.this$0.setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_RATE, Float.valueOf(speed)));
                this.this$0.setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYBACK_RATE_DEFAULT, Float.valueOf(speed)));
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onMediaRequested() {
                super.onMediaRequested();
                this.this$0.updateMetadataWithMedia();
                if (this.this$0.getPlayWhenReady()) {
                    DzAdapter.setState$default(this.this$0, State.Content.REQUESTED.INSTANCE, null, 2, null);
                    if (this.this$0.isPlaying()) {
                        DzAdapter.setState$default(this.this$0, State.Content.BUFFERING.INSTANCE, null, 2, null);
                        DzAdapter.setState$default(this.this$0, State.Content.PLAYING.INSTANCE, null, 2, null);
                    }
                }
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onTimelineChange(boolean mediaChanged) {
                if (mediaChanged) {
                    PlayerAdapter playerAdapter = this.this$0;
                    MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
                    Object objRunBlocking = null;
                    try {
                        objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$listener$1$onTimelineChange$$inlined$safeOnMainOrNull$1(null, playerAdapter));
                    } catch (Exception e) {
                        Logger_androidKt.getLogger().e("isLive.onTimelineChange error: " + e.getMessage());
                    }
                    Boolean bool = (Boolean) objRunBlocking;
                    if (bool != null) {
                        this.this$0.setIsLive(bool.booleanValue());
                    }
                }
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public void onSeek(long oldPosition, long newPosition) {
                boolean zIsPlayingAd = this.this$0.isPlayingAd();
                PlayerAdapter playerAdapter = this.this$0;
                if (zIsPlayingAd) {
                    playerAdapter.setState(State.Ad.SEEKING.INSTANCE, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.SEEK_START_POINT.getValue(), Long.valueOf(oldPosition)), TuplesKt.to(MetaData.Type.SEEK_END_POINT.getValue(), Long.valueOf(newPosition))));
                } else {
                    playerAdapter.setState(State.Content.SEEKING.INSTANCE, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.SEEK_START_POINT.getValue(), Long.valueOf(oldPosition)), TuplesKt.to(MetaData.Type.SEEK_END_POINT.getValue(), Long.valueOf(newPosition))));
                }
            }

            @Override // io.datazoom.sdk.player.DzPlayerListener
            public int getTrackIndex() {
                Object objRunBlocking = 0;
                PlayerAdapter playerAdapter = this.this$0;
                MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
                try {
                    objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$listener$1$getTrackIndex$$inlined$safeOnMain$1(null, playerAdapter));
                } catch (Exception e) {
                    Logger_androidKt.getLogger().e("getTrackIndex error: " + e.getMessage());
                }
                return ((Number) objRunBlocking).intValue();
            }
        };
        this.listener = r12;
        ?? r0 = new DzAdPlayerListener() { // from class: io.datazoom.sdk.player.PlayerAdapter$dzPlayerListener$1
            @Override // io.datazoom.sdk.ad.DzAdPlayerListener
            public void onAdStarted(DzAdSessionMetadata adSessionMetadata) {
                Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
                this.this$0.notifyAdInitialise(adSessionMetadata);
            }
        };
        this.dzPlayerListener = r0;
        player.addListener((DzPlayerListener) r12);
        player.setAdListener((DzAdPlayerListener) r0);
        sendEvent(EventKt.toEvent$default(Event.Type.PlayerReady, 0L, null, null, null, null, 31, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStateInFluxData(DzPlayerState state) {
        String str;
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$setStateInFluxData$$inlined$safeOnMain$1(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("playWhenReady.setStateInFluxData error: " + e.getMessage());
        }
        boolean zBooleanValue = ((Boolean) objRunBlocking).booleanValue();
        FluxData.Type type = FluxData.Type.PLAYER_STATE;
        if (Intrinsics.areEqual(state, DzPlayerState.Idle.INSTANCE)) {
            str = "idle";
        } else if (Intrinsics.areEqual(state, DzPlayerState.Ready.INSTANCE)) {
            str = zBooleanValue ? PlayingEvent.TYPE : "paused";
        } else if (Intrinsics.areEqual(state, DzPlayerState.Ended.INSTANCE)) {
            str = EndedEvent.TYPE;
        } else {
            if (!Intrinsics.areEqual(state, DzPlayerState.Buffering.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "buffering";
        }
        setFluxData(FluxDataStoreExtensionsKt.to(type, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMetadataWithMedia() {
        String strConvertMimeTypeToProtocol;
        Media currentMedia = getCurrentMedia();
        if (currentMedia == null) {
            return;
        }
        String strStreamingProtocol = streamingProtocol(currentMedia.getUrl(), currentMedia.getMimeType());
        if (strStreamingProtocol != null && (strConvertMimeTypeToProtocol = convertMimeTypeToProtocol(strStreamingProtocol)) != null) {
            setMetaData(MetaData.Type.STREAMING_PROTOCOL, strConvertMimeTypeToProtocol);
        }
        String title = currentMedia.getTitle();
        if (title != null) {
            setMetaData(MetaData.Type.TITLE, title);
        }
        String url = currentMedia.getUrl();
        if (url != null) {
            setMetaData(MetaData.Type.SOURCE, url);
        }
        String assetId = currentMedia.getAssetId();
        if (assetId != null) {
            setMetaData(MetaData.Type.ASSET_ID, assetId);
        }
        String closeCaptionLang = currentMedia.getCloseCaptionLang();
        if (closeCaptionLang != null) {
            setMetaData(MetaData.Type.SUBTITLES, Boolean.valueOf(!StringsKt.isBlank(closeCaptionLang)));
        }
        String secondaryTitle = currentMedia.getSecondaryTitle();
        if (secondaryTitle != null) {
            setMetaData(MetaData.Type.DESCRIPTION, secondaryTitle);
        }
        String closeCaptionLang2 = currentMedia.getCloseCaptionLang();
        if (closeCaptionLang2 != null) {
            setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.CURRENT_SUBTITLES, closeCaptionLang2));
        }
    }

    private final String streamingProtocol(String url, String mimeType) {
        String strConvertMimeTypeToProtocol = convertMimeTypeToProtocol(mimeType);
        return strConvertMimeTypeToProtocol == null ? convertURLExtensionToProtocol(url) : strConvertMimeTypeToProtocol;
    }

    private final String convertMimeTypeToProtocol(String mimeType) {
        if (mimeType == null) {
            return null;
        }
        String str = mimeType;
        if (StringsKt.contains((CharSequence) str, (CharSequence) "application/x-mpegURL", true)) {
            return "HLS";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) MimeTypes.APPLICATION_MPD, true)) {
            return "DASH";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "application/octet-stream", true)) {
            return "Smooth";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) MimeTypes.VIDEO_FLV, true)) {
            return ExifInterface.TAG_FLASH;
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "video/mp4", true)) {
            return "MP4";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "video/MP2T", true)) {
            return "MPEG2-TS";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) MimeTypes.VIDEO_H263, true)) {
            return "3GPP";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) MimeTypes.VIDEO_QUICK_TIME, true)) {
            return "Quicktime";
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) MimeTypes.VIDEO_AVI, true)) {
            return "AVI";
        }
        return StringsKt.contains((CharSequence) str, (CharSequence) "video/x-ms-wmv", true) ? "Windows Media" : mimeType;
    }

    private final String convertURLExtensionToProtocol(String url) {
        if (url == null) {
            return null;
        }
        switch (StringsKt.substringAfterLast(url, FilenameUtils.EXTENSION_SEPARATOR, "")) {
            case "ts":
                return "MPEG2-TS";
            case "3gp":
                return "3GPP";
            case "avi":
                return "AVI";
            case "flv":
                return ExifInterface.TAG_FLASH;
            case "m3u":
                return "HLS";
            case "m4a":
                return "MP4";
            case "m4b":
                return "MP4";
            case "m4p":
                return "MP4";
            case "m4r":
                return "MP4";
            case "m4v":
                return "MP4";
            case "mp4":
                return "MP4";
            case "mov":
                return "Quicktime";
            case "wmv":
                return "Windows Media";
            case "m3u8":
                return "HLS";
            default:
                return null;
        }
    }

    @Override // io.datazoom.sdk.DzAdapter
    @Deprecated(message = "API warning - Please don't use it directly", replaceWith = @ReplaceWith(expression = "Datazoom.removeContext()", imports = {}))
    public void onDestroy() {
        this.player.onClear();
        super.onDestroy();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected boolean getPlayWhenReady() {
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$1(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("playWhenReady error: " + e.getMessage());
        }
        return ((Boolean) objRunBlocking).booleanValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected float getSpeed() {
        Object objValueOf = Float.valueOf(1.0f);
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objValueOf = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$2(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("speed error: " + e.getMessage());
        }
        return ((Number) objValueOf).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.datazoom.sdk.DzAdapter
    public boolean isPlaying() {
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$3(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("isPlaying error: " + e.getMessage());
        }
        return ((Boolean) objRunBlocking).booleanValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected boolean isPause() {
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$4(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("isPause error: " + e.getMessage());
        }
        return ((Boolean) objRunBlocking).booleanValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected long getPlayHeadDuration() {
        Object objRunBlocking = 0L;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$5(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("playHeadDuration error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).longValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected long getContentDurationMs() {
        Object objRunBlocking = 0L;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$6(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("contentDurationMs error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).longValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected long getBufferDuration() {
        Object objRunBlocking = 0L;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$7(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("bufferDuration error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).longValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected int getBitrate() {
        Object objRunBlocking = 0;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$8(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("bitrate error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).intValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected int getVolume() {
        Object objRunBlocking = 0;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$9(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("volume error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).intValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected boolean isMuted() {
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$10(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("isMuted error: " + e.getMessage());
        }
        return ((Boolean) objRunBlocking).booleanValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected boolean getDefaultMuted() {
        Object objRunBlocking = false;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$11(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("defaultMuted error: " + e.getMessage());
        }
        return ((Boolean) objRunBlocking).booleanValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected int getAudioBitrate() {
        Object objRunBlocking = 0;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$12(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("audioBitrate error: " + e.getMessage());
        }
        return ((Number) objRunBlocking).intValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected double getCurrentWindowStart() {
        Object objValueOf = Double.valueOf(-1.0d);
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objValueOf = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$13(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("currentWindowStart error: " + e.getMessage());
        }
        return ((Number) objValueOf).doubleValue();
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected Media getCurrentMedia() {
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        Object objRunBlocking = null;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMainOrNull$1(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("currentMedia error: " + e.getMessage());
        }
        return (Media) objRunBlocking;
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected String getPlayerName() {
        Object objRunBlocking;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$14(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("playerName error: " + e.getMessage());
            objRunBlocking = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        return (String) objRunBlocking;
    }

    @Override // io.datazoom.sdk.DzAdapter
    protected String getSdkVersion() {
        Object objRunBlocking;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$15(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("sdkVersion error: " + e.getMessage());
            objRunBlocking = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        return (String) objRunBlocking;
    }

    @Override // io.datazoom.sdk.DzAdapter
    public String getPlayerId() {
        Object objRunBlocking;
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            objRunBlocking = BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new PlayerAdapter$special$$inlined$safeOnMain$16(null, this));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e("playerId error: " + e.getMessage());
            objRunBlocking = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        return (String) objRunBlocking;
    }
}
