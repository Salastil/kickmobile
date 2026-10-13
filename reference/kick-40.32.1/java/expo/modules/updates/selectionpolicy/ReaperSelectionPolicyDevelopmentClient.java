package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReaperSelectionPolicyDevelopmentClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/updates/selectionpolicy/ReaperSelectionPolicyDevelopmentClient;", "Lexpo/modules/updates/selectionpolicy/ReaperSelectionPolicy;", UpdatesConfiguration.UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY, "", "<init>", "(I)V", "selectUpdatesToDelete", "", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updates", "launchedUpdate", "filters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReaperSelectionPolicyDevelopmentClient implements ReaperSelectionPolicy {
    private final int maxUpdatesToKeep;

    public ReaperSelectionPolicyDevelopmentClient() {
        this(0, 1, null);
    }

    public ReaperSelectionPolicyDevelopmentClient(int i) {
        this.maxUpdatesToKeep = i;
        if (i <= 0) {
            throw new AssertionError("Cannot initialize ReaperSelectionPolicyDevelopmentClient with maxUpdatesToKeep <= 0");
        }
    }

    public /* synthetic */ ReaperSelectionPolicyDevelopmentClient(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    @Override // expo.modules.updates.selectionpolicy.ReaperSelectionPolicy
    public List<UpdateEntity> selectUpdatesToDelete(List<UpdateEntity> updates, UpdateEntity launchedUpdate, JSONObject filters) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        if (launchedUpdate == null || updates.size() <= this.maxUpdatesToKeep) {
            return new ArrayList();
        }
        List mutableList = CollectionsKt.toMutableList((Collection) updates);
        final Function2 function2 = new Function2() { // from class: expo.modules.updates.selectionpolicy.ReaperSelectionPolicyDevelopmentClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(ReaperSelectionPolicyDevelopmentClient.selectUpdatesToDelete$lambda$0((UpdateEntity) obj, (UpdateEntity) obj2));
            }
        };
        CollectionsKt.sortWith(mutableList, new Comparator() { // from class: expo.modules.updates.selectionpolicy.ReaperSelectionPolicyDevelopmentClient$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Number) function2.invoke(obj, obj2)).intValue();
            }
        });
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (mutableList.size() > this.maxUpdatesToKeep) {
            UpdateEntity updateEntity = (UpdateEntity) mutableList.remove(0);
            if (!Intrinsics.areEqual(updateEntity.getId(), launchedUpdate.getId())) {
                arrayList.add(updateEntity);
            } else {
                if (z) {
                    throw new AssertionError("Multiple updates with the same ID were passed into ReaperSelectionPolicyDevelopmentClient");
                }
                mutableList.add(updateEntity);
                z = true;
            }
        }
        return arrayList;
    }

    static final int selectUpdatesToDelete$lambda$0(UpdateEntity u1, UpdateEntity u2) {
        Intrinsics.checkNotNullParameter(u1, "u1");
        Intrinsics.checkNotNullParameter(u2, "u2");
        int iCompareTo = u1.getLastAccessed().compareTo(u2.getLastAccessed());
        return iCompareTo == 0 ? u1.getCommitTime().compareTo(u2.getCommitTime()) : iCompareTo;
    }
}
