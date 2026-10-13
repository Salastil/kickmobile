package io.datazoom.sdk.player;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayerListenerDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J9\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072'\b\u0002\u0010\b\u001a!\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\tj\u0002`\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0011H&J\b\u0010\u0016\u001a\u00020\u0003H&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\u001a\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u001b\u001a\u00020\u0019H&J\b\u0010'\u001a\u00020\u0019H&J\u000f\u0010(\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010)¨\u0006*À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/player/PlayerListenerDelegate;", "", "setStateInFluxData", "", "state", "Lio/datazoom/sdk/player/DzPlayerState;", "setState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "payload", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "setLiveState", "isLive", "", "isPlayingAd", "isSessionAlive", "playWhenReady", "isPlaying", "updateMetadataWithMedia", "onTrackChange", ViewProps.WIDTH, "", ViewProps.HEIGHT, "bitrate", "setPlayerDimensions", "onVolumeChanged", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "", "setFlux", "fluxData", "Lio/datazoom/sdk/model/FluxData;", "setMeta", "type", "Lio/datazoom/sdk/model/MetaData$Type;", "value", "trackIndex", "isLiveSupplier", "()Ljava/lang/Boolean;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PlayerListenerDelegate {
    int bitrate();

    Boolean isLiveSupplier();

    boolean isPlaying();

    boolean isPlayingAd();

    boolean isSessionAlive();

    void onTrackChange(int width, int height, int bitrate);

    void onVolumeChanged(long volume);

    boolean playWhenReady();

    void setFlux(FluxData fluxData);

    void setLiveState(boolean isLive);

    void setMeta(MetaData.Type type, Object value);

    void setPlayerDimensions(int height, int width);

    void setState(State state, HashMap<String, Object> payload);

    void setStateInFluxData(DzPlayerState state);

    int trackIndex();

    void updateMetadataWithMedia();

    /* JADX INFO: compiled from: PlayerListenerDelegate.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void setState$default(PlayerListenerDelegate playerListenerDelegate, State state, HashMap map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        playerListenerDelegate.setState(state, map);
    }
}
