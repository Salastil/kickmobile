package expo.modules.updates.logging;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: UpdatesErrorCode.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lexpo/modules/updates/logging/UpdatesErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "None", "NoUpdatesAvailable", "UpdateAssetsNotAvailable", "UpdateServerUnreachable", "UpdateHasInvalidSignature", "UpdateCodeSigningError", "UpdateFailedToLoad", "AssetsFailedToLoad", "JSRuntimeError", "InitializationError", ViewUtilsKt.UNKNOWN_DESTINATION_URL, "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum UpdatesErrorCode {
    None("None"),
    NoUpdatesAvailable("NoUpdatesAvailable"),
    UpdateAssetsNotAvailable("UpdateAssetsNotAvailable"),
    UpdateServerUnreachable("UpdateServerUnreachable"),
    UpdateHasInvalidSignature("UpdateHasInvalidSignature"),
    UpdateCodeSigningError("UpdateCodeSigningError"),
    UpdateFailedToLoad("UpdateFailedToLoad"),
    AssetsFailedToLoad("AssetsFailedToLoad"),
    JSRuntimeError("JSRuntimeError"),
    InitializationError("InitializationError"),
    Unknown(ViewUtilsKt.UNKNOWN_DESTINATION_URL);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String code;

    public static EnumEntries<UpdatesErrorCode> getEntries() {
        return $ENTRIES;
    }

    UpdatesErrorCode(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }
}
