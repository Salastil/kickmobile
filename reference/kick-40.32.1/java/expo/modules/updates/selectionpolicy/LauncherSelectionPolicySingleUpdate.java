package expo.modules.updates.selectionpolicy;

import expo.modules.updates.db.entity.UpdateEntity;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: LauncherSelectionPolicySingleUpdate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicySingleUpdate;", "Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicy;", "updateID", "Ljava/util/UUID;", "<init>", "(Ljava/util/UUID;)V", "selectUpdateToLaunch", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updates", "", "filters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LauncherSelectionPolicySingleUpdate implements LauncherSelectionPolicy {
    private final UUID updateID;

    public LauncherSelectionPolicySingleUpdate(UUID updateID) {
        Intrinsics.checkNotNullParameter(updateID, "updateID");
        this.updateID = updateID;
    }

    @Override // expo.modules.updates.selectionpolicy.LauncherSelectionPolicy
    public UpdateEntity selectUpdateToLaunch(List<UpdateEntity> updates, JSONObject filters) {
        Object next;
        Intrinsics.checkNotNullParameter(updates, "updates");
        Iterator<T> it = updates.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((UpdateEntity) next).getId(), this.updateID)) {
                return (UpdateEntity) next;
            }
        }
        next = null;
        return (UpdateEntity) next;
    }
}
