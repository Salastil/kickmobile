package androidx.core.backported.fixes;

import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KnownIssue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B?\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Landroidx/core/backported/fixes/KnownIssue;", "", "id", "", "alias", "", "manuallyTestedFingerprints", "", "", SessionEndedMetric.PRECONDITION_KEY, "Lkotlin/Function0;", "", "<init>", "(JLjava/lang/Integer;Ljava/util/Set;Lkotlin/jvm/functions/Function0;)V", "getId", "()J", "getAlias$core_backported_fixes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getManuallyTestedFingerprints$core_backported_fixes", "()Ljava/util/Set;", "getPrecondition$core_backported_fixes", "()Lkotlin/jvm/functions/Function0;", ImagesContract.URL, "getUrl", "()Ljava/lang/String;", "equals", "other", "hashCode", "toString", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KnownIssue {
    private final Integer alias;
    private final long id;
    private final Set<String> manuallyTestedFingerprints;
    private final Function0<Boolean> precondition;
    private final String url;

    static final boolean _init_$lambda$0() {
        return true;
    }

    public KnownIssue(long j, Integer num, Set<String> manuallyTestedFingerprints, Function0<Boolean> precondition) {
        Intrinsics.checkNotNullParameter(manuallyTestedFingerprints, "manuallyTestedFingerprints");
        Intrinsics.checkNotNullParameter(precondition, "precondition");
        this.id = j;
        this.alias = num;
        this.manuallyTestedFingerprints = manuallyTestedFingerprints;
        this.precondition = precondition;
        this.url = "https://issuetracker.google.com/issues/" + j;
    }

    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: getAlias$core_backported_fixes, reason: from getter */
    public final Integer getAlias() {
        return this.alias;
    }

    public /* synthetic */ KnownIssue(long j, Integer num, Set set, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, num, (i & 4) != 0 ? SetsKt.emptySet() : set, (i & 8) != 0 ? new Function0() { // from class: androidx.core.backported.fixes.KnownIssue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(KnownIssue._init_$lambda$0());
            }
        } : function0);
    }

    public final Set<String> getManuallyTestedFingerprints$core_backported_fixes() {
        return this.manuallyTestedFingerprints;
    }

    public final Function0<Boolean> getPrecondition$core_backported_fixes() {
        return this.precondition;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        return (other instanceof KnownIssue) && this.id == ((KnownIssue) other).id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public String toString() {
        Integer num = this.alias;
        long j = this.id;
        if (num == null) {
            return j + " without alias";
        }
        return j + " with alias " + this.alias.intValue();
    }
}
