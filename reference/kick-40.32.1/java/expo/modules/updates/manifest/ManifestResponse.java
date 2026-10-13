package expo.modules.updates.manifest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* JADX INFO: compiled from: ManifestResponse.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/updates/manifest/ManifestResponse;", "", "response", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Response;)V", "header", "", "name", "defaultValue", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ManifestResponse {
    private final Response response;

    public ManifestResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.response = response;
    }

    public final String header(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Response.header$default(this.response, name, null, 2, null);
    }

    public final String header(String name, String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return this.response.header(name, defaultValue);
    }
}
