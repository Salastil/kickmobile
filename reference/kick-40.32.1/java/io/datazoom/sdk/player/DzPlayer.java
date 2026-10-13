package io.datazoom.sdk.player;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.datazoom.sdk.ad.DzAdPlayerListener;
import io.datazoom.sdk.model.Media;
import kotlin.Metadata;

/* JADX INFO: compiled from: DzPlayer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0012\u0010&\u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0012\u0010(\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u0014\u0010*\u001a\u0004\u0018\u00010+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#R\u0012\u00100\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u0012\u00101\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0010R\u0012\u00103\u001a\u000204X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0012\u00107\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\fR\u0012\u00109\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\f¨\u0006;À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/player/DzPlayer;", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/datazoom/sdk/player/DzPlayerListener;", "setAdListener", "Lio/datazoom/sdk/ad/DzAdPlayerListener;", "onClear", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "playWhenReady", "", "getPlayWhenReady", "()Z", "isPlaying", "isLive", "()Ljava/lang/Boolean;", "duration", "", "getDuration", "()J", "currentPosition", "getCurrentPosition", "contentDuration", "getContentDuration", "currentWindowStart", "", "getCurrentWindowStart", "()D", "trackIndex", "", "getTrackIndex", "()I", "bitrate", "getBitrate", "audioBitrate", "getAudioBitrate", "bufferDuration", "getBufferDuration", "currentMediaItem", "Lio/datazoom/sdk/model/Media;", "getCurrentMediaItem", "()Lio/datazoom/sdk/model/Media;", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "getVolume", "isMuted", "defaultMuted", "getDefaultMuted", "speed", "", "getSpeed", "()F", "name", "getName", "sdkVersion", "getSdkVersion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DzPlayer {
    void addListener(DzPlayerListener listener);

    int getAudioBitrate();

    int getBitrate();

    long getBufferDuration();

    long getContentDuration();

    Media getCurrentMediaItem();

    long getCurrentPosition();

    double getCurrentWindowStart();

    boolean getDefaultMuted();

    long getDuration();

    String getName();

    boolean getPlayWhenReady();

    String getPlayerId();

    String getSdkVersion();

    float getSpeed();

    int getTrackIndex();

    int getVolume();

    Boolean isLive();

    boolean isMuted();

    boolean isPlaying();

    void onClear();

    void setAdListener(DzAdPlayerListener listener);
}
