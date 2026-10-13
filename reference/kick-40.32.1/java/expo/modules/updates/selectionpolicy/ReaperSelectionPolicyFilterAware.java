package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReaperSelectionPolicyFilterAware.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/updates/selectionpolicy/ReaperSelectionPolicyFilterAware;", "Lexpo/modules/updates/selectionpolicy/ReaperSelectionPolicy;", UpdatesConfiguration.UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY, "", "<init>", "(I)V", "selectUpdatesToDelete", "", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updates", "launchedUpdate", "filters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReaperSelectionPolicyFilterAware implements ReaperSelectionPolicy {
    private final int maxUpdatesToKeep;

    public ReaperSelectionPolicyFilterAware() {
        this(0, 1, null);
    }

    public ReaperSelectionPolicyFilterAware(int i) {
        this.maxUpdatesToKeep = i;
        if (i < 2) {
            throw new AssertionError("Cannot initialize ReaperSelectionPolicyFilterAware with maxUpdatesToKeep < 2");
        }
    }

    public /* synthetic */ ReaperSelectionPolicyFilterAware(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    @Override // expo.modules.updates.selectionpolicy.ReaperSelectionPolicy
    public List<UpdateEntity> selectUpdatesToDelete(List<UpdateEntity> updates, UpdateEntity launchedUpdate, JSONObject filters) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        if (launchedUpdate == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdateEntity updateEntity : updates) {
            if (Intrinsics.areEqual(updateEntity.getScopeKey(), launchedUpdate.getScopeKey()) && updateEntity.getCommitTime().before(launchedUpdate.getCommitTime())) {
                arrayList.add(updateEntity);
                arrayList2.add(updateEntity);
            }
        }
        int i = this.maxUpdatesToKeep - 1;
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (SelectionPolicies.INSTANCE.matchesFilters((UpdateEntity) obj, filters)) {
                arrayList4.add(obj);
            }
        }
        Set mutableSet = CollectionsKt.toMutableSet(CollectionsKt.take(CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: expo.modules.updates.selectionpolicy.ReaperSelectionPolicyFilterAware$selectUpdatesToDelete$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((UpdateEntity) t2).getCommitTime(), ((UpdateEntity) t).getCommitTime());
            }
        }), i));
        if (mutableSet.size() < i) {
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (!mutableSet.contains((UpdateEntity) obj2)) {
                    arrayList5.add(obj2);
                }
            }
            mutableSet.addAll(CollectionsKt.take(CollectionsKt.sortedWith(arrayList5, new Comparator() { // from class: expo.modules.updates.selectionpolicy.ReaperSelectionPolicyFilterAware$selectUpdatesToDelete$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((UpdateEntity) t2).getCommitTime(), ((UpdateEntity) t).getCommitTime());
                }
            }), i - mutableSet.size()));
        }
        arrayList.removeAll(mutableSet);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((UpdateEntity) obj3).getStatus() != UpdateStatus.EMBEDDED) {
                arrayList6.add(obj3);
            }
        }
        return arrayList6;
    }
}
