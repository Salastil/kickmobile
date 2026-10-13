package io.datazoom.sdk.di;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: DatazoomModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/datazoom/sdk/di/DiName;", "", "<init>", "(Ljava/lang/String;I)V", "GLOBAL_FLUX_STORE", "APP_SESSION_MANAGER", "PLAYER_SESSION_MANAGER", "PLAYER_AD_SESSION_MANAGER", "GLOBAL_PREF_MANAGER", "ADAPTER_PREF_MANAGER", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum DiName {
    GLOBAL_FLUX_STORE,
    APP_SESSION_MANAGER,
    PLAYER_SESSION_MANAGER,
    PLAYER_AD_SESSION_MANAGER,
    GLOBAL_PREF_MANAGER,
    ADAPTER_PREF_MANAGER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<DiName> getEntries() {
        return $ENTRIES;
    }
}
