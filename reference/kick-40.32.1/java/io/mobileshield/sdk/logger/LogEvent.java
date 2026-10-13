package io.mobileshield.sdk.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.h.s.e1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0006\u0010!\u001a\u00020\bJ\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lio/mobileshield/sdk/logger/LogEvent;", "", "logMillis", "", "logLevel", "", "logCode", "extraMessage", "", "(JIJLjava/lang/String;)V", "getExtraMessage", "()Ljava/lang/String;", "setExtraMessage", "(Ljava/lang/String;)V", "getLogCode", "()J", "setLogCode", "(J)V", "getLogLevel", "()I", "setLogLevel", "(I)V", "getLogMillis", "setLogMillis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toLogString", "toString", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class LogEvent {
    private String extraMessage;
    private long logCode;
    private int logLevel;
    private long logMillis;

    public LogEvent(long j, int i, long j2, String str) {
        this.logMillis = j;
        this.logLevel = i;
        this.logCode = j2;
        this.extraMessage = str;
    }

    public static /* synthetic */ LogEvent copy$default(LogEvent logEvent, long j, int i, long j2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = logEvent.logMillis;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = logEvent.logLevel;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = logEvent.logCode;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            str = logEvent.extraMessage;
        }
        return logEvent.copy(j3, i3, j4, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getLogMillis() {
        return this.logMillis;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLogLevel() {
        return this.logLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLogCode() {
        return this.logCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExtraMessage() {
        return this.extraMessage;
    }

    public final LogEvent copy(long logMillis, int logLevel, long logCode, String extraMessage) {
        return new LogEvent(logMillis, logLevel, logCode, extraMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) other;
        return this.logMillis == logEvent.logMillis && this.logLevel == logEvent.logLevel && this.logCode == logEvent.logCode && Intrinsics.areEqual(this.extraMessage, logEvent.extraMessage);
    }

    public final String getExtraMessage() {
        return this.extraMessage;
    }

    public final long getLogCode() {
        return this.logCode;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final long getLogMillis() {
        return this.logMillis;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.logCode) + ((Integer.hashCode(this.logLevel) + (Long.hashCode(this.logMillis) * 31)) * 31)) * 31;
        String str = this.extraMessage;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setExtraMessage(String str) {
        this.extraMessage = str;
    }

    public final void setLogCode(long j) {
        this.logCode = j;
    }

    public final void setLogLevel(int i) {
        this.logLevel = i;
    }

    public final void setLogMillis(long j) {
        this.logMillis = j;
    }

    public final String toLogString() {
        String str;
        StringBuilder sb = new StringBuilder("LEVEL: ");
        sb.append(e1.a(this.logLevel));
        sb.append(" TIME : ");
        sb.append(e1.a(this.logMillis));
        sb.append(" CODE : ");
        sb.append(this.logCode);
        String str2 = this.extraMessage;
        if (str2 != null) {
            str = " EXTRA : " + str2;
        } else {
            str = "";
        }
        sb.append(str);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public String toString() {
        return "LogEvent(logMillis=" + this.logMillis + ", logLevel=" + this.logLevel + ", logCode=" + this.logCode + ", extraMessage=" + this.extraMessage + ")";
    }
}
