package io.datazoom.sdk.ivs;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.amazonaws.ivs.player.Player;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.datazoom.sdk.ad.DzAdPlayerListener;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.Media;
import io.datazoom.sdk.player.DzPlayer;
import io.datazoom.sdk.player.DzPlayerListener;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IvsPlayerImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0014\u00100\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001fR\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010+R\u0014\u00108\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0014R\u0014\u00109\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0014R\u0014\u0010;\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0010R\u0014\u0010=\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0010¨\u0006@"}, d2 = {"Lio/datazoom/sdk/ivs/IvsPlayerImpl;", "Lio/datazoom/sdk/player/DzPlayer;", "player", "Lcom/amazonaws/ivs/player/Player;", "<init>", "(Lcom/amazonaws/ivs/player/Player;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/datazoom/sdk/ivs/IvsPlayerListener;", "addListener", "", "Lio/datazoom/sdk/player/DzPlayerListener;", "setAdListener", "Lio/datazoom/sdk/ad/DzAdPlayerListener;", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "playWhenReady", "", "getPlayWhenReady", "()Z", "speed", "", "getSpeed", "()F", "isPlaying", "isLive", "()Ljava/lang/Boolean;", "duration", "", "getDuration", "()J", "currentPosition", "getCurrentPosition", "contentDuration", "getContentDuration", "currentWindowStart", "", "getCurrentWindowStart", "()D", "trackIndex", "", "getTrackIndex", "()I", "bitrate", "getBitrate", "audioBitrate", "getAudioBitrate", "bufferDuration", "getBufferDuration", "currentMediaItem", "Lio/datazoom/sdk/model/Media;", "getCurrentMediaItem", "()Lio/datazoom/sdk/model/Media;", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "getVolume", "isMuted", "defaultMuted", "getDefaultMuted", "name", "getName", "sdkVersion", "getSdkVersion", "onClear", "ivs_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IvsPlayerImpl implements DzPlayer {
    private IvsPlayerListener listener;
    private final Player player;

    @Override // io.datazoom.sdk.player.DzPlayer
    public int getAudioBitrate() {
        return 0;
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public boolean getDefaultMuted() {
        return false;
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public int getTrackIndex() {
        return 0;
    }

    public IvsPlayerImpl(Player player) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            Logger_androidKt.getLogger().v("IVS Player (" + getPlayerId() + ") attached with state: " + this.player.getState() + ", Current position: " + this.player.getPosition() + ", Playing: " + isPlaying());
            objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("Unable to access IVS player: " + thM12687exceptionOrNullimpl.getMessage());
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public void addListener(DzPlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IvsPlayerListener ivsPlayerListener = new IvsPlayerListener(listener);
        this.listener = ivsPlayerListener;
        Logger_androidKt.getLogger().v("Attaching IvsPlayerListener to IVS Player (" + getPlayerId() + ')');
        this.player.addListener(ivsPlayerListener);
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public void setAdListener(DzAdPlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IvsPlayerListener ivsPlayerListener = this.listener;
        if (ivsPlayerListener != null) {
            ivsPlayerListener.setAdListener(listener);
        }
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public String getPlayerId() {
        String hexString = Integer.toHexString(this.player.hashCode());
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public boolean getPlayWhenReady() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(this.player.getState() == Player.State.PLAYING));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("playWhenReady error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = false;
        }
        return ((Boolean) objM12684constructorimpl).booleanValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public float getSpeed() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Float.valueOf(this.player.getPlaybackRate()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("speed error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        Float fValueOf = Float.valueOf(1.0f);
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = fValueOf;
        }
        return ((Number) objM12684constructorimpl).floatValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public boolean isPlaying() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(this.player.getState() == Player.State.PLAYING));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("isPlaying error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = false;
        }
        return ((Boolean) objM12684constructorimpl).booleanValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public Boolean isLive() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(this.player.getDuration() <= 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("isLive error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (Boolean) objM12684constructorimpl;
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public long getDuration() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(this.player.getDuration()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("duration error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0L;
        }
        return ((Number) objM12684constructorimpl).longValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public long getCurrentPosition() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(this.player.getPosition()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("currentPosition error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0L;
        }
        return ((Number) objM12684constructorimpl).longValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public long getContentDuration() {
        return getDuration();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public double getCurrentWindowStart() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Double.valueOf(this.player.getPosition()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("currentWindowStart error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        Double dValueOf = Double.valueOf(-1.0d);
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = dValueOf;
        }
        return ((Number) objM12684constructorimpl).doubleValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public int getBitrate() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Integer.valueOf(PrimitiveExtensionsKt.dividedBy(Integer.valueOf(this.player.getQuality().getBitrate()), 1024)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("bitrate error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0;
        }
        return ((Number) objM12684constructorimpl).intValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public long getBufferDuration() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(RangesKt.coerceAtLeast(this.player.getBufferedPosition() - this.player.getPosition(), 0L)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("bufferDuration error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0L;
        }
        return ((Number) objM12684constructorimpl).longValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public Media getCurrentMediaItem() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            String path = this.player.getPath();
            objM12684constructorimpl = Result.m12684constructorimpl(path != null ? new Media(null, null, path, null, null, path) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("currentMediaItem error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        return (Media) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public int getVolume() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Integer.valueOf((int) (this.player.getVolume() * 100.0f)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("volume error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0;
        }
        return ((Number) objM12684constructorimpl).intValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public boolean isMuted() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(this.player.isMuted()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("isMuted error: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = false;
        }
        return ((Boolean) objM12684constructorimpl).booleanValue();
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public String getName() {
        return "Amazon IVS Player";
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public String getSdkVersion() {
        return "0.0.3";
    }

    @Override // io.datazoom.sdk.player.DzPlayer
    public void onClear() {
        Object objM12684constructorimpl;
        IvsPlayerListener ivsPlayerListener = this.listener;
        Unit unit = null;
        this.listener = null;
        if (ivsPlayerListener != null) {
            ivsPlayerListener.setAdListener(null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsPlayerImpl ivsPlayerImpl = this;
            if (ivsPlayerListener != null) {
                this.player.removeListener(ivsPlayerListener);
                unit = Unit.INSTANCE;
            }
            objM12684constructorimpl = Result.m12684constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("onClear error: " + thM12687exceptionOrNullimpl.getMessage());
        }
    }
}
