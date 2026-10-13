package expo.modules.kasada;

import expo.modules.kotlin.Promise;
import io.mobileshield.sdk.HeadersCallback;
import io.mobileshield.sdk.RequestHeaderReason;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KasadaModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"expo/modules/kasada/KasadaModule$definition$1$2$1", "Lio/mobileshield/sdk/HeadersCallback;", "onSuccess", "", "headers", "", "", "onFailure", "reason", "Lio/mobileshield/sdk/RequestHeaderReason;", "kasada_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KasadaModule$definition$1$2$1 implements HeadersCallback {
    final /* synthetic */ Promise $promise;

    KasadaModule$definition$1$2$1(Promise promise) {
        this.$promise = promise;
    }

    @Override // io.mobileshield.sdk.HeadersCallback
    public void onSuccess(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.$promise.resolve((Map<String, ? extends Object>) headers);
    }

    @Override // io.mobileshield.sdk.HeadersCallback
    public void onFailure(RequestHeaderReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        String string = reason.toString();
        this.$promise.reject("Error", string, new Throwable(string));
    }
}
