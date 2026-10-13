package com.kick.mobile.kickivsplayerv2;

import com.amazonaws.ivs.player.Source;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickIvsPlayerV2View.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$preload$1$1", "Lcom/amazonaws/ivs/player/Source$Listener;", "onLoad", "", "source", "Lcom/amazonaws/ivs/player/Source;", "onError", "error", "Lcom/amazonaws/ivs/player/Source$LoadError;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIvsPlayerV2View$preload$1$1 implements Source.Listener {
    final /* synthetic */ int $id;
    final /* synthetic */ KickIvsPlayerV2View this$0;

    KickIvsPlayerV2View$preload$1$1(KickIvsPlayerV2View kickIvsPlayerV2View, int i) {
        this.this$0 = kickIvsPlayerV2View;
        this.$id = i;
    }

    @Override // com.amazonaws.ivs.player.Source.Listener
    public void onLoad(final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        final KickIvsPlayerV2View kickIvsPlayerV2View = this.this$0;
        final int i = this.$id;
        if (kickIvsPlayerV2View.executeOnPlayerExecutor("storePreloadedSource", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$preload$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View$preload$1$1.onLoad$lambda$0(kickIvsPlayerV2View, source, i);
            }
        })) {
            return;
        }
        source.release();
    }

    static final Unit onLoad$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Source source, int i) {
        if (!kickIvsPlayerV2View.isDetached && !kickIvsPlayerV2View.isReleasing && kickIvsPlayerV2View.player != null) {
            Source source2 = (Source) kickIvsPlayerV2View.preloadSourceMap.remove(Integer.valueOf(i));
            if (source2 != null) {
                source2.release();
            }
            kickIvsPlayerV2View.preloadSourceMap.put(Integer.valueOf(i), source);
            return Unit.INSTANCE;
        }
        source.release();
        return Unit.INSTANCE;
    }

    @Override // com.amazonaws.ivs.player.Source.Listener
    public void onError(Source.LoadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onError", MapsKt.mapOf(TuplesKt.to("message", error.getMessage()), TuplesKt.to("flow", "SOURCE_PRELOAD")));
        }
    }
}
