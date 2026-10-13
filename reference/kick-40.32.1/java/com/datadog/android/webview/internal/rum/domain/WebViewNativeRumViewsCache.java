package com.datadog.android.webview.internal.rum.domain;

import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewNativeRumViewsCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/WebViewNativeRumViewsCache;", "Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "entriesTtlLimitInMs", "", "(Lcom/datadog/android/internal/time/TimeProvider;J)V", "parentViewsHistoryQueue", "Ljava/util/LinkedList;", "Lcom/datadog/android/webview/internal/rum/domain/WebViewNativeRumViewsCache$ViewEntry;", "getParentViewsHistoryQueue$dd_sdk_android_webview_release", "()Ljava/util/LinkedList;", "addToCache", "", "entry", "event", "", "", "", "purgeHistory", "resolveLastParentIdForBrowserEvent", "browserEventTimestampInMs", "Companion", "ViewEntry", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewNativeRumViewsCache implements NativeRumViewsCache {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DATA_CACHE_ENTRIES_LIMIT = 30;
    private static final long DATA_PURGE_TTL_LIMIT_IN_MS;
    public static final String VIEW_HAS_REPLAY_KEY = "view_has_replay";
    public static final String VIEW_ID_KEY = "view_id";
    public static final String VIEW_TIMESTAMP_KEY = "view_timestamp";
    private final long entriesTtlLimitInMs;
    private final LinkedList<ViewEntry> parentViewsHistoryQueue;
    private final TimeProvider timeProvider;

    public WebViewNativeRumViewsCache(TimeProvider timeProvider, long j) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.timeProvider = timeProvider;
        this.entriesTtlLimitInMs = j;
        this.parentViewsHistoryQueue = new LinkedList<>();
    }

    public /* synthetic */ WebViewNativeRumViewsCache(TimeProvider timeProvider, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeProvider, (i & 2) != 0 ? DATA_PURGE_TTL_LIMIT_IN_MS : j);
    }

    public final LinkedList<ViewEntry> getParentViewsHistoryQueue$dd_sdk_android_webview_release() {
        return this.parentViewsHistoryQueue;
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public synchronized String resolveLastParentIdForBrowserEvent(long browserEventTimestampInMs) {
        Iterator<ViewEntry> it = this.parentViewsHistoryQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "parentViewsHistoryQueue.iterator()");
        String viewId = null;
        while (it.hasNext()) {
            ViewEntry next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            ViewEntry viewEntry = next;
            if (viewEntry.getTimestamp() <= browserEventTimestampInMs) {
                if (viewId == null) {
                    viewId = viewEntry.getViewId();
                }
                if (viewEntry.getHasReplay()) {
                    return viewEntry.getViewId();
                }
            }
        }
        return viewId;
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public synchronized void addToCache(Map<String, ? extends Object> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Object obj = event.get("view_id");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = event.get("view_timestamp");
        Long l = obj2 instanceof Long ? (Long) obj2 : null;
        Object obj3 = event.get("view_has_replay");
        Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        if (str != null && !Intrinsics.areEqual(str, RumContext.INSTANCE.getNULL_UUID()) && l != null) {
            addToCache(new ViewEntry(str, l.longValue(), zBooleanValue));
        }
        purgeHistory();
    }

    private final void addToCache(ViewEntry entry) {
        if (this.parentViewsHistoryQueue.isEmpty() || (!Intrinsics.areEqual(this.parentViewsHistoryQueue.getFirst().getViewId(), entry.getViewId()) && this.parentViewsHistoryQueue.getFirst().getTimestamp() <= entry.getTimestamp())) {
            this.parentViewsHistoryQueue.add(0, entry);
        } else if (Intrinsics.areEqual(this.parentViewsHistoryQueue.getFirst().getViewId(), entry.getViewId())) {
            if (!this.parentViewsHistoryQueue.isEmpty()) {
                this.parentViewsHistoryQueue.remove(0);
            }
            this.parentViewsHistoryQueue.add(0, entry);
        }
    }

    private final void purgeHistory() {
        ViewEntry viewEntryPeekLast = this.parentViewsHistoryQueue.peekLast();
        while (viewEntryPeekLast != null && this.timeProvider.getDeviceTimestampMillis() - viewEntryPeekLast.getTimestamp() > this.entriesTtlLimitInMs) {
            this.parentViewsHistoryQueue.remove(viewEntryPeekLast);
            viewEntryPeekLast = this.parentViewsHistoryQueue.peekLast();
        }
        while (this.parentViewsHistoryQueue.size() > 30) {
            LinkedList<ViewEntry> linkedList = this.parentViewsHistoryQueue;
            linkedList.remove(linkedList.size() - 1);
        }
    }

    /* JADX INFO: compiled from: WebViewNativeRumViewsCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/WebViewNativeRumViewsCache$ViewEntry;", "", RumEventMeta.VIEW_ID_KEY, "", "timestamp", "", "hasReplay", "", "(Ljava/lang/String;JZ)V", "getHasReplay", "()Z", "getTimestamp", "()J", "getViewId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ViewEntry {
        private final boolean hasReplay;
        private final long timestamp;
        private final String viewId;

        public static /* synthetic */ ViewEntry copy$default(ViewEntry viewEntry, String str, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewEntry.viewId;
            }
            if ((i & 2) != 0) {
                j = viewEntry.timestamp;
            }
            if ((i & 4) != 0) {
                z = viewEntry.hasReplay;
            }
            return viewEntry.copy(str, j, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasReplay() {
            return this.hasReplay;
        }

        public final ViewEntry copy(String viewId, long timestamp, boolean hasReplay) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            return new ViewEntry(viewId, timestamp, hasReplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewEntry)) {
                return false;
            }
            ViewEntry viewEntry = (ViewEntry) other;
            return Intrinsics.areEqual(this.viewId, viewEntry.viewId) && this.timestamp == viewEntry.timestamp && this.hasReplay == viewEntry.hasReplay;
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.hasReplay);
        }

        public String toString() {
            return "ViewEntry(viewId=" + this.viewId + ", timestamp=" + this.timestamp + ", hasReplay=" + this.hasReplay + ")";
        }

        public ViewEntry(String viewId, long j, boolean z) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            this.viewId = viewId;
            this.timestamp = j;
            this.hasReplay = z;
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final boolean getHasReplay() {
            return this.hasReplay;
        }
    }

    /* JADX INFO: compiled from: WebViewNativeRumViewsCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/WebViewNativeRumViewsCache$Companion;", "", "()V", "DATA_CACHE_ENTRIES_LIMIT", "", "DATA_PURGE_TTL_LIMIT_IN_MS", "", "getDATA_PURGE_TTL_LIMIT_IN_MS$dd_sdk_android_webview_release", "()J", "VIEW_HAS_REPLAY_KEY", "", "VIEW_ID_KEY", "VIEW_TIMESTAMP_KEY", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getDATA_PURGE_TTL_LIMIT_IN_MS$dd_sdk_android_webview_release() {
            return WebViewNativeRumViewsCache.DATA_PURGE_TTL_LIMIT_IN_MS;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        DATA_PURGE_TTL_LIMIT_IN_MS = 7200000L;
    }
}
