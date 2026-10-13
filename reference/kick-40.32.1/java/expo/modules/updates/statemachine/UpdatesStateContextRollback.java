package expo.modules.updates.statemachine;

import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesStateContextRollback.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateContextRollback;", "", "commitTime", "Ljava/util/Date;", "<init>", "(Ljava/util/Date;)V", "getCommitTime", "()Ljava/util/Date;", "commitTimeString", "", "getCommitTimeString", "()Ljava/lang/String;", "json", "", "getJson", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdatesStateContextRollback {
    private final Date commitTime;

    public static /* synthetic */ UpdatesStateContextRollback copy$default(UpdatesStateContextRollback updatesStateContextRollback, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            date = updatesStateContextRollback.commitTime;
        }
        return updatesStateContextRollback.copy(date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getCommitTime() {
        return this.commitTime;
    }

    public final UpdatesStateContextRollback copy(Date commitTime) {
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        return new UpdatesStateContextRollback(commitTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UpdatesStateContextRollback) && Intrinsics.areEqual(this.commitTime, ((UpdatesStateContextRollback) other).commitTime);
    }

    public int hashCode() {
        return this.commitTime.hashCode();
    }

    public String toString() {
        return "UpdatesStateContextRollback(commitTime=" + this.commitTime + ")";
    }

    public UpdatesStateContextRollback(Date commitTime) {
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        this.commitTime = commitTime;
    }

    public final Date getCommitTime() {
        return this.commitTime;
    }

    public final String getCommitTimeString() {
        String str = UpdatesStateContext.INSTANCE.getDATE_FORMATTER().format(this.commitTime);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final Map<String, Object> getJson() {
        return MapsKt.mapOf(TuplesKt.to("commitTime", getCommitTimeString()));
    }
}
