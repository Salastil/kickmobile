package expo.modules.updates;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: UpdatesConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/UpdatesConfigurationValidationResult;", "", "<init>", "(Ljava/lang/String;I)V", "VALID", "INVALID_NOT_ENABLED", "INVALID_MISSING_URL", "INVALID_MISSING_RUNTIME_VERSION", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum UpdatesConfigurationValidationResult {
    VALID,
    INVALID_NOT_ENABLED,
    INVALID_MISSING_URL,
    INVALID_MISSING_RUNTIME_VERSION;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<UpdatesConfigurationValidationResult> getEntries() {
        return $ENTRIES;
    }
}
