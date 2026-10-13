package com.datadog.android.rum.internal.domain.display;

import com.datadog.android.rum.internal.domain.InfoProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpDisplayInfoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/display/NoOpDisplayInfoProvider;", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "()V", "cleanup", "", "getState", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDisplayInfoProvider implements InfoProvider<DisplayInfo> {
    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public DisplayInfo getState() {
        return new DisplayInfo(null, 1, null);
    }
}
