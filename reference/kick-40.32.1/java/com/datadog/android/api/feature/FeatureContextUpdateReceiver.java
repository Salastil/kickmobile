package com.datadog.android.api.feature;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: FeatureContextUpdateReceiver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H'¨\u0006\b"}, d2 = {"Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "", "onContextUpdate", "", "featureName", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FeatureContextUpdateReceiver {
    void onContextUpdate(String featureName, Map<String, ? extends Object> context);
}
