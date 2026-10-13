package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SessionConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionReportingMode;", "", "modeString", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getModeString$MediaTailor_release", "()Ljava/lang/String;", "SERVER", "CLIENT", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SessionReportingMode {
    SERVER("server"),
    CLIENT("client");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String modeString;

    public static EnumEntries<SessionReportingMode> getEntries() {
        return $ENTRIES;
    }

    SessionReportingMode(String str) {
        this.modeString = str;
    }

    /* JADX INFO: renamed from: getModeString$MediaTailor_release, reason: from getter */
    public final String getModeString() {
        return this.modeString;
    }
}
