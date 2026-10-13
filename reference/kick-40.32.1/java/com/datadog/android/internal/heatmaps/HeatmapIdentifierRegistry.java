package com.datadog.android.internal.heatmaps;

import expo.modules.notifications.service.NotificationsService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: HeatmapIdentifierRegistry.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "", "getHeatmapIdentifier", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier;", "heatmapViewKey", "", "currentScreenName", "", "setHeatmapIdentifiers", "", NotificationsService.IDENTIFIERS_KEY, "", "screenName", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HeatmapIdentifierRegistry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    HeatmapIdentifier getHeatmapIdentifier(long heatmapViewKey, String currentScreenName);

    void setHeatmapIdentifiers(Map<Long, HeatmapIdentifier> identifiers, String screenName);

    /* JADX INFO: compiled from: HeatmapIdentifierRegistry.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry$Companion;", "", "()V", "create", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final HeatmapIdentifierRegistry create() {
            return new HeatmapIdentifierStore();
        }
    }
}
