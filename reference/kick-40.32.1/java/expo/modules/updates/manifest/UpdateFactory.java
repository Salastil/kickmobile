package expo.modules.updates.manifest;

import expo.modules.manifests.core.EmbeddedManifest;
import expo.modules.manifests.core.ExpoUpdatesManifest;
import expo.modules.updates.UpdatesConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdateFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lexpo/modules/updates/manifest/UpdateFactory;", "", "<init>", "()V", "getUpdate", "Lexpo/modules/updates/manifest/Update;", "manifestJson", "Lorg/json/JSONObject;", "responseHeaderData", "Lexpo/modules/updates/manifest/ResponseHeaderData;", "extensions", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "getEmbeddedUpdate", "Lexpo/modules/updates/manifest/EmbeddedUpdate;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateFactory {
    public static final UpdateFactory INSTANCE = new UpdateFactory();

    private UpdateFactory() {
    }

    public final Update getUpdate(JSONObject manifestJson, ResponseHeaderData responseHeaderData, JSONObject extensions, UpdatesConfiguration configuration) throws Exception {
        Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Integer protocolVersion = responseHeaderData.getProtocolVersion();
        if (protocolVersion == null) {
            throw new Exception("Legacy manifests are no longer supported");
        }
        if (protocolVersion.intValue() == 0 || protocolVersion.intValue() == 1) {
            return ExpoUpdatesUpdate.INSTANCE.fromExpoUpdatesManifest(new ExpoUpdatesManifest(manifestJson), extensions, configuration);
        }
        throw new Exception("Unsupported expo-protocol-version: " + protocolVersion);
    }

    public final EmbeddedUpdate getEmbeddedUpdate(JSONObject manifestJson, UpdatesConfiguration configuration) throws JSONException {
        Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return EmbeddedUpdate.INSTANCE.fromEmbeddedManifest(new EmbeddedManifest(manifestJson), configuration);
    }
}
