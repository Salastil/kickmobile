package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeStampsStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/domain/EventEntry;", "", "type", "", "time", "", "<init>", "(Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EventEntry {
    private final long time;
    private final String type;

    public static /* synthetic */ EventEntry copy$default(EventEntry eventEntry, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventEntry.type;
        }
        if ((i & 2) != 0) {
            j = eventEntry.time;
        }
        return eventEntry.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final EventEntry copy(String type, long time) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new EventEntry(type, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventEntry)) {
            return false;
        }
        EventEntry eventEntry = (EventEntry) other;
        return Intrinsics.areEqual(this.type, eventEntry.type) && this.time == eventEntry.time;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "EventEntry(type=" + this.type + ", time=" + this.time + ")";
    }

    public EventEntry(String type, long j) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.time = j;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }
}
