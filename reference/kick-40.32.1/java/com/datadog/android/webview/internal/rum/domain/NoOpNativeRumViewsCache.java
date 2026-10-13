package com.datadog.android.webview.internal.rum.domain;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpNativeRumViewsCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/NoOpNativeRumViewsCache;", "Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "()V", "addToCache", "", "event", "", "", "", "resolveLastParentIdForBrowserEvent", "browserEventTimestampInMs", "", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpNativeRumViewsCache implements NativeRumViewsCache {
    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public void addToCache(Map<String, ? extends Object> event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public String resolveLastParentIdForBrowserEvent(long browserEventTimestampInMs) {
        return null;
    }
}
