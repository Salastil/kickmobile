package io.datazoom.sdk.player;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzPlayerState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u0001¨\u0006\t"}, d2 = {"wrapperStateFrom", "Lio/datazoom/sdk/player/DzPlayerState;", "state", "", "isIdle", "", "isBuffering", "isReady", "isEnded", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DzPlayerStateKt {
    public static final DzPlayerState wrapperStateFrom(int i) {
        if (i == 2) {
            return DzPlayerState.Buffering.INSTANCE;
        }
        if (i == 3) {
            return DzPlayerState.Ready.INSTANCE;
        }
        if (i == 4) {
            return DzPlayerState.Ended.INSTANCE;
        }
        return DzPlayerState.Idle.INSTANCE;
    }

    public static final boolean isIdle(DzPlayerState dzPlayerState) {
        return Intrinsics.areEqual(dzPlayerState, DzPlayerState.Idle.INSTANCE);
    }

    public static final boolean isBuffering(DzPlayerState dzPlayerState) {
        return Intrinsics.areEqual(dzPlayerState, DzPlayerState.Buffering.INSTANCE);
    }

    public static final boolean isReady(DzPlayerState dzPlayerState) {
        return Intrinsics.areEqual(dzPlayerState, DzPlayerState.Ready.INSTANCE);
    }

    public static final boolean isEnded(DzPlayerState dzPlayerState) {
        return Intrinsics.areEqual(dzPlayerState, DzPlayerState.Ended.INSTANCE);
    }
}
