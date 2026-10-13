package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewRumEventContextProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "rumFeatureDisabled", "", "getRumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewRumEventContextProvider {
    public static final String RUM_NOT_INITIALIZED_WARNING_MESSAGE = "You are trying to use the WebView tracking API but the RUM feature was not properly initialized.";
    private final InternalLogger internalLogger;
    private boolean rumFeatureDisabled;

    public WebViewRumEventContextProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final RumContext getRumContext(DatadogContext datadogContext) {
        String str;
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        if (this.rumFeatureDisabled) {
            return null;
        }
        Map<String, Object> map = datadogContext.getFeaturesContext().get("rum");
        Object obj = map != null ? map.get("application_id") : null;
        String str2 = obj instanceof String ? (String) obj : null;
        Object obj2 = map != null ? map.get("session_id") : null;
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map != null ? map.get(com.datadog.android.rum.internal.domain.RumContext.SESSION_STATE) : null;
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        if (str2 == null || Intrinsics.areEqual(str2, RumContext.INSTANCE.getNULL_UUID()) || str3 == null || Intrinsics.areEqual(str3, RumContext.INSTANCE.getNULL_UUID()) || (str = str4) == null || StringsKt.isBlank(str)) {
            this.rumFeatureDisabled = true;
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider.getRumContext.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewRumEventContextProvider.RUM_NOT_INITIALIZED_WARNING_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        return new RumContext(str2, str3, str4);
    }
}
