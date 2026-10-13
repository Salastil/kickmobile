package expo.modules.updates.selectionpolicy;

import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: LauncherSelectionPolicyDevelopmentClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicyDevelopmentClient;", "Lexpo/modules/updates/selectionpolicy/LauncherSelectionPolicy;", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "", "config", "Lexpo/modules/updates/UpdatesConfiguration;", "<init>", "(Ljava/lang/String;Lexpo/modules/updates/UpdatesConfiguration;)V", "selectUpdateToLaunch", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updates", "", "filters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LauncherSelectionPolicyDevelopmentClient implements LauncherSelectionPolicy {
    private final UpdatesConfiguration config;
    private final String runtimeVersion;

    public LauncherSelectionPolicyDevelopmentClient(String runtimeVersion, UpdatesConfiguration updatesConfiguration) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        this.runtimeVersion = runtimeVersion;
        this.config = updatesConfiguration;
    }

    @Override // expo.modules.updates.selectionpolicy.LauncherSelectionPolicy
    public UpdateEntity selectUpdateToLaunch(List<UpdateEntity> updates, JSONObject filters) {
        Object next;
        Intrinsics.checkNotNullParameter(updates, "updates");
        ArrayList arrayList = new ArrayList();
        for (Object obj : updates) {
            UpdateEntity updateEntity = (UpdateEntity) obj;
            if (Intrinsics.areEqual(this.runtimeVersion, updateEntity.getRuntimeVersion()) && SelectionPolicies.INSTANCE.matchesFilters(updateEntity, filters)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            UpdateEntity updateEntity2 = (UpdateEntity) next2;
            if (updateEntity2.getUrl() != null || updateEntity2.getRequestHeaders() != null) {
                Uri url = updateEntity2.getUrl();
                UpdatesConfiguration updatesConfiguration = this.config;
                if (Intrinsics.areEqual(url, updatesConfiguration != null ? updatesConfiguration.getUpdateUrl() : null)) {
                    Map<String, String> requestHeaders = updateEntity2.getRequestHeaders();
                    UpdatesConfiguration updatesConfiguration2 = this.config;
                    if (Intrinsics.areEqual(requestHeaders, updatesConfiguration2 != null ? updatesConfiguration2.getRequestHeaders() : null)) {
                    }
                }
            }
            arrayList2.add(next2);
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                Date commitTime = ((UpdateEntity) next).getCommitTime();
                do {
                    Object next3 = it2.next();
                    Date commitTime2 = ((UpdateEntity) next3).getCommitTime();
                    if (commitTime.compareTo(commitTime2) < 0) {
                        next = next3;
                        commitTime = commitTime2;
                    }
                } while (it2.hasNext());
            }
        }
        return (UpdateEntity) next;
    }
}
