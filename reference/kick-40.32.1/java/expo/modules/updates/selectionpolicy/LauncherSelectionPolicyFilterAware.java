package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: LauncherSelectionPolicyFilterAware.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicyFilterAware;", "Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicy;", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "", "config", "Lexpo/modules/updates/UpdatesConfiguration;", "<init>", "(Ljava/lang/String;Lexpo/modules/updates/UpdatesConfiguration;)V", "selectUpdateToLaunch", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updates", "", "filters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LauncherSelectionPolicyFilterAware implements LauncherSelectionPolicy {
    private final UpdatesConfiguration config;
    private final String runtimeVersion;

    public LauncherSelectionPolicyFilterAware(String runtimeVersion, UpdatesConfiguration config) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        Intrinsics.checkNotNullParameter(config, "config");
        this.runtimeVersion = runtimeVersion;
        this.config = config;
    }

    @Override // expo.modules.updates.selectionpolicy.LauncherSelectionPolicy
    public UpdateEntity selectUpdateToLaunch(List<UpdateEntity> updates, JSONObject filters) {
        Object obj;
        Intrinsics.checkNotNullParameter(updates, "updates");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : updates) {
            UpdateEntity updateEntity = (UpdateEntity) obj2;
            if (Intrinsics.areEqual(this.runtimeVersion, updateEntity.getRuntimeVersion()) && SelectionPolicies.INSTANCE.matchesFilters(updateEntity, filters)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            UpdateEntity updateEntity2 = (UpdateEntity) obj3;
            if ((updateEntity2.getUrl() == null && updateEntity2.getRequestHeaders() == null) || (Intrinsics.areEqual(updateEntity2.getUrl(), this.config.getUpdateUrl()) && Intrinsics.areEqual(updateEntity2.getRequestHeaders(), this.config.getRequestHeaders()))) {
                arrayList2.add(obj3);
            }
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Date commitTime = ((UpdateEntity) next).getCommitTime();
                do {
                    Object next2 = it.next();
                    Date commitTime2 = ((UpdateEntity) next2).getCommitTime();
                    if (commitTime.compareTo(commitTime2) < 0) {
                        next = next2;
                        commitTime = commitTime2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (UpdateEntity) obj;
    }
}
