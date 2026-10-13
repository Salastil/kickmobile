package com.kick.mobile.kickivsplayerv2;

import android.view.SurfaceView;
import com.amazonaws.ivs.player.Cue;
import com.amazonaws.ivs.player.Player;
import com.amazonaws.ivs.player.PlayerException;
import com.amazonaws.ivs.player.Quality;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: KickIvsPlayerV2View.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u0019"}, d2 = {"com/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$playerListener$1", "Lcom/amazonaws/ivs/player/Player$Listener;", "onStateChanged", "", "state", "Lcom/amazonaws/ivs/player/Player$State;", "onDurationChanged", "duration", "", "onRebuffering", "onSeekCompleted", ViewProps.POSITION, "onQualityChanged", "quality", "Lcom/amazonaws/ivs/player/Quality;", "onVideoSizeChanged", ViewProps.WIDTH, "", ViewProps.HEIGHT, "onCue", "cue", "Lcom/amazonaws/ivs/player/Cue;", "onError", "e", "Lcom/amazonaws/ivs/player/PlayerException;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIvsPlayerV2View$playerListener$1 extends Player.Listener {
    final /* synthetic */ KickIvsPlayerV2View this$0;

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onCue(Cue cue) {
        Intrinsics.checkNotNullParameter(cue, "cue");
    }

    KickIvsPlayerV2View$playerListener$1(KickIvsPlayerV2View kickIvsPlayerV2View) {
        this.this$0 = kickIvsPlayerV2View;
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onStateChanged(final Player.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        final long j = this.this$0.activeStreamRequestId;
        final KickIvsPlayerV2View kickIvsPlayerV2View = this.this$0;
        kickIvsPlayerV2View.executePlayerOperation("onStateChanged", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$playerListener$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View$playerListener$1.onStateChanged$lambda$0(kickIvsPlayerV2View, state, j, (Player) obj);
            }
        });
    }

    static final Unit onStateChanged$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Player.State state, long j, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        kickIvsPlayerV2View.onPlayerStateChange(currentPlayer, state, j);
        return Unit.INSTANCE;
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onDurationChanged(long duration) {
        this.this$0.onDurationChange(duration);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onRebuffering() {
        this.this$0.onPlayerRebuffering();
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onSeekCompleted(final long position) {
        final KickIvsPlayerV2View kickIvsPlayerV2View = this.this$0;
        kickIvsPlayerV2View.executePlayerOperation("onSeekCompleted", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$playerListener$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View$playerListener$1.onSeekCompleted$lambda$1(kickIvsPlayerV2View, position, (Player) obj);
            }
        });
    }

    static final Unit onSeekCompleted$lambda$1(KickIvsPlayerV2View kickIvsPlayerV2View, long j, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Player.State state = currentPlayer.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        kickIvsPlayerV2View.onSeek(j, state);
        return Unit.INSTANCE;
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onQualityChanged(Quality quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        this.this$0.onQualityChange(quality);
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onVideoSizeChanged(int width, int height) {
        this.this$0.videoWidth = width;
        this.this$0.videoHeight = height;
        MuxAnalyticsListener muxAnalyticsListener = this.this$0.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updateSourceSize(width, height);
        }
        SurfaceView surfaceView = this.this$0.surfaceView;
        final KickIvsPlayerV2View kickIvsPlayerV2View = this.this$0;
        surfaceView.post(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$playerListener$1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                KickIvsPlayerV2View$playerListener$1.onVideoSizeChanged$lambda$2(kickIvsPlayerV2View);
            }
        });
    }

    static final void onVideoSizeChanged$lambda$2(KickIvsPlayerV2View kickIvsPlayerV2View) {
        kickIvsPlayerV2View.updateSurfaceViewBufferSize();
        kickIvsPlayerV2View.updateSurfaceViewTransform();
    }

    @Override // com.amazonaws.ivs.player.Player.Listener
    public void onError(PlayerException e) throws JSONException {
        Intrinsics.checkNotNullParameter(e, "e");
        MuxAnalyticsListener muxAnalyticsListener = this.this$0.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.dispatchError(e);
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onError", MapsKt.mapOf(TuplesKt.to("message", e.getErrorMessage()), TuplesKt.to("flow", "PLAYER_LISTENER")));
        }
    }
}
