package io.datazoom.sdk.ivs;

import com.amazonaws.ivs.player.Player;
import io.datazoom.sdk.BaseContext;
import io.datazoom.sdk.BaseContextFactory;
import io.datazoom.sdk.Datazoom;
import io.datazoom.sdk.DzAdapter;
import io.datazoom.sdk.player.PlayerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: extensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"createContext", "Lio/datazoom/sdk/DzAdapter;", "Lio/datazoom/sdk/Datazoom;", "player", "Lcom/amazonaws/ivs/player/Player;", "eventSpace", "Lio/datazoom/sdk/BaseContext;", "ivs_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ExtensionsKt {
    public static /* synthetic */ DzAdapter createContext$default(Datazoom datazoom, Player player, BaseContext baseContext, int i, Object obj) {
        if ((i & 2) != 0) {
            baseContext = BaseContextFactory.INSTANCE.create();
        }
        return createContext(datazoom, player, baseContext);
    }

    public static final DzAdapter createContext(Datazoom datazoom, Player player, BaseContext eventSpace) {
        Intrinsics.checkNotNullParameter(datazoom, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(eventSpace, "eventSpace");
        return datazoom.createContext(new PlayerAdapter(new IvsPlayerImpl(player), eventSpace));
    }
}
