package io.datazoom.sdk;

import android.content.Context;
import android.webkit.WebSettings;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.NetworkInfo;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkInfo.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getNetworkInfo", "Lio/datazoom/sdk/model/NetworkInfo;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NetworkInfo_androidKt {
    public static final NetworkInfo getNetworkInfo() throws Exception {
        Context context = AppContext.INSTANCE.get();
        boolean zOrFalse = PrimitiveExtensionsKt.orFalse(Boolean.valueOf(ContextExtensionsKt.isMobileNetwork(context)));
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "getDefaultUserAgent(...)");
        return new NetworkInfo(zOrFalse, defaultUserAgent);
    }
}
