package expo.modules.updates.selectionpolicy;

import android.util.Log;
import expo.modules.manifests.core.Manifest;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SelectionPolicies.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/selectionpolicy/SelectionPolicies;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "matchesFilters", "", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "manifestFilters", "Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SelectionPolicies {
    public static final SelectionPolicies INSTANCE = new SelectionPolicies();
    private static final String TAG;

    private SelectionPolicies() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SelectionPolicies", "getSimpleName(...)");
        TAG = "SelectionPolicies";
    }

    public final String getTAG() {
        return TAG;
    }

    public final boolean matchesFilters(UpdateEntity update, JSONObject manifestFilters) {
        JSONObject metadata;
        Intrinsics.checkNotNullParameter(update, "update");
        if (manifestFilters == null || (metadata = Manifest.INSTANCE.fromManifestJson(update.getManifest()).getMetadata()) == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> itKeys = metadata.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                String lowerCase = next.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                jSONObject.put(lowerCase, metadata.get(next));
            }
            Iterator<String> itKeys2 = manifestFilters.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                if (jSONObject.has(next2) && !Intrinsics.areEqual(manifestFilters.get(next2), jSONObject.get(next2))) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error filtering manifest using server data", e);
            return true;
        }
    }
}
