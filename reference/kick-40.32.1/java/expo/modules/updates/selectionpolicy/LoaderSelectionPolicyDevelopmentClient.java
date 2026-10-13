package expo.modules.updates.selectionpolicy;

import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.UpdateDirective;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: LoaderSelectionPolicyDevelopmentClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/selectionpolicy/LoaderSelectionPolicyDevelopmentClient;", "Lexpo/modules/updates/selectionpolicy/LoaderSelectionPolicy;", "config", "Lexpo/modules/updates/UpdatesConfiguration;", "<init>", "(Lexpo/modules/updates/UpdatesConfiguration;)V", "shouldLoadNewUpdate", "", "newUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "launchedUpdate", "filters", "Lorg/json/JSONObject;", "shouldLoadRollBackToEmbeddedDirective", "directive", "Lexpo/modules/updates/loader/UpdateDirective$RollBackToEmbeddedUpdateDirective;", "embeddedUpdate", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LoaderSelectionPolicyDevelopmentClient implements LoaderSelectionPolicy {
    private final UpdatesConfiguration config;

    public LoaderSelectionPolicyDevelopmentClient(UpdatesConfiguration updatesConfiguration) {
        this.config = updatesConfiguration;
    }

    @Override // expo.modules.updates.selectionpolicy.LoaderSelectionPolicy
    public boolean shouldLoadNewUpdate(UpdateEntity newUpdate, UpdateEntity launchedUpdate, JSONObject filters) {
        if (newUpdate == null || !SelectionPolicies.INSTANCE.matchesFilters(newUpdate, filters)) {
            return false;
        }
        if (launchedUpdate == null || !SelectionPolicies.INSTANCE.matchesFilters(launchedUpdate, filters)) {
            return true;
        }
        if (newUpdate.getUrl() != null) {
            Uri url = newUpdate.getUrl();
            UpdatesConfiguration updatesConfiguration = this.config;
            if (!Intrinsics.areEqual(url, updatesConfiguration != null ? updatesConfiguration.getUpdateUrl() : null)) {
                return false;
            }
        }
        if (newUpdate.getRequestHeaders() != null) {
            Map<String, String> requestHeaders = newUpdate.getRequestHeaders();
            UpdatesConfiguration updatesConfiguration2 = this.config;
            if (!Intrinsics.areEqual(requestHeaders, updatesConfiguration2 != null ? updatesConfiguration2.getRequestHeaders() : null)) {
                return false;
            }
        }
        if (launchedUpdate.getUrl() != null) {
            Uri url2 = launchedUpdate.getUrl();
            UpdatesConfiguration updatesConfiguration3 = this.config;
            if (!Intrinsics.areEqual(url2, updatesConfiguration3 != null ? updatesConfiguration3.getUpdateUrl() : null)) {
                return true;
            }
        }
        if (launchedUpdate.getRequestHeaders() != null) {
            Map<String, String> requestHeaders2 = launchedUpdate.getRequestHeaders();
            UpdatesConfiguration updatesConfiguration4 = this.config;
            if (!Intrinsics.areEqual(requestHeaders2, updatesConfiguration4 != null ? updatesConfiguration4.getRequestHeaders() : null)) {
                return true;
            }
        }
        return newUpdate.getCommitTime().after(launchedUpdate.getCommitTime());
    }

    @Override // expo.modules.updates.selectionpolicy.LoaderSelectionPolicy
    public boolean shouldLoadRollBackToEmbeddedDirective(UpdateDirective.RollBackToEmbeddedUpdateDirective directive, UpdateEntity embeddedUpdate, UpdateEntity launchedUpdate, JSONObject filters) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        Intrinsics.checkNotNullParameter(embeddedUpdate, "embeddedUpdate");
        if (!SelectionPolicies.INSTANCE.matchesFilters(embeddedUpdate, filters)) {
            return false;
        }
        if (launchedUpdate != null && SelectionPolicies.INSTANCE.matchesFilters(launchedUpdate, filters)) {
            return directive.getCommitTime().after(launchedUpdate.getCommitTime());
        }
        return true;
    }
}
