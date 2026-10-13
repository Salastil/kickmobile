package io.datazoom.sdk.ivs;

import com.amazonaws.ivs.player.Player;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: IvsPlayerListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toDzStateIndex", "", "Lcom/amazonaws/ivs/player/Player$State;", "ivs_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class IvsPlayerListenerKt {

    /* JADX INFO: compiled from: IvsPlayerListener.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Player.State.values().length];
            try {
                iArr[Player.State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Player.State.BUFFERING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Player.State.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Player.State.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Player.State.ENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toDzStateIndex(Player.State state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3 && i != 4) {
                    if (i == 5) {
                        return 4;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return i2;
    }
}
