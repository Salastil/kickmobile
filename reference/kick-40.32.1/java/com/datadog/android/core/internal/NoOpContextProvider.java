package com.datadog.android.core.internal;

import com.datadog.android.DatadogSite;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.LocaleInfo;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.ProcessInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpContextProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/datadog/android/core/internal/NoOpContextProvider;", "Lcom/datadog/android/core/internal/ContextProvider;", "()V", "getContext", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpContextProvider implements ContextProvider {
    @Override // com.datadog.android.core.internal.ContextProvider
    public DatadogContext getContext(Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        return new DatadogContext(DatadogSite.US1, "", "", "", "", 0, "", "", "", TimeInfo.INSTANCE.getEMPTY$dd_sdk_android_core_release(), new ProcessInfo(true), new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null), new DeviceInfo("", "", "", DeviceType.OTHER, "", "", "", "", "", null, new LocaleInfo(CollectionsKt.emptyList(), "", ""), 0, null, null), new UserInfo(null, null, null, null, MapsKt.emptyMap()), null, TrackingConsent.NOT_GRANTED, null, MapsKt.emptyMap());
    }
}
