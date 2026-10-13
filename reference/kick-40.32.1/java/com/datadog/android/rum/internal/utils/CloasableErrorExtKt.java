package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloasableErrorExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"CLOSABLE_ERROR_MESSAGE", "", "handleClosableError", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CloasableErrorExtKt {
    public static final String CLOSABLE_ERROR_MESSAGE = "Error while using the closeable";

    public static final void handleClosableError(Throwable throwable, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        RumMonitor.DefaultImpls.addError$default(GlobalRumMonitor.get(sdkCore), CLOSABLE_ERROR_MESSAGE, RumErrorSource.SOURCE, throwable, null, 8, null);
    }
}
