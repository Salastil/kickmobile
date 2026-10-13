package expo.modules.updates.statemachine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: UpdatesStateEventType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "StartStartup", "EndStartup", "Check", "CheckCompleteUnavailable", "CheckCompleteAvailable", "CheckError", "Download", "DownloadProgress", "DownloadCompleteUnavailable", "DownloadCompleteWithUpdate", "DownloadCompleteWithRollback", "DownloadError", "Restart", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum UpdatesStateEventType {
    StartStartup("startStartup"),
    EndStartup("endStartup"),
    Check("check"),
    CheckCompleteUnavailable("checkCompleteUnavailable"),
    CheckCompleteAvailable("checkCompleteAvailable"),
    CheckError("checkError"),
    Download("download"),
    DownloadProgress("downloadProgress"),
    DownloadCompleteUnavailable("downloadCompleteUnavailable"),
    DownloadCompleteWithUpdate("downloadCompleteWithUpdate"),
    DownloadCompleteWithRollback("downloadCompleteWithRollback"),
    DownloadError("downloadError"),
    Restart("restart");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String type;

    public static EnumEntries<UpdatesStateEventType> getEntries() {
        return $ENTRIES;
    }

    UpdatesStateEventType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
