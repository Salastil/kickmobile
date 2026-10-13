package com.datadog.android.internal.heatmaps;

import expo.modules.notifications.service.NotificationsService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpHeatmapIdentifierRegistry.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/internal/heatmaps/NoOpHeatmapIdentifierRegistry;", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "()V", "getHeatmapIdentifier", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier;", "heatmapViewKey", "", "currentScreenName", "", "setHeatmapIdentifiers", "", NotificationsService.IDENTIFIERS_KEY, "", "screenName", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpHeatmapIdentifierRegistry implements HeatmapIdentifierRegistry {
    @Override // com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry
    public HeatmapIdentifier getHeatmapIdentifier(long heatmapViewKey, String currentScreenName) {
        Intrinsics.checkNotNullParameter(currentScreenName, "currentScreenName");
        return null;
    }

    @Override // com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry
    public void setHeatmapIdentifiers(Map<Long, HeatmapIdentifier> identifiers, String screenName) {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
    }
}
