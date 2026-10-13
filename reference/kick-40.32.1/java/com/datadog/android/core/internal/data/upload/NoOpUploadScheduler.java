package com.datadog.android.core.internal.data.upload;

import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpUploadScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/NoOpUploadScheduler;", "Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "()V", "startScheduling", "", "stopScheduling", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpUploadScheduler implements UploadScheduler {
    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void startScheduling() {
    }

    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void stopScheduling() {
    }
}
