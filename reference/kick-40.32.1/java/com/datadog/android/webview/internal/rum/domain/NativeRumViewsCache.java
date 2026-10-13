package com.datadog.android.webview.internal.rum.domain;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeRumViewsCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "", "addToCache", "", "event", "", "", "resolveLastParentIdForBrowserEvent", "browserEventTimestampInMs", "", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NativeRumViewsCache {
    void addToCache(Map<String, ? extends Object> event);

    String resolveLastParentIdForBrowserEvent(long browserEventTimestampInMs);
}
