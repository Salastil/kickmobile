package com.datadog.android.rum.internal.domain;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.Metadata;

/* JADX INFO: compiled from: InfoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\r\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/InfoProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/datadog/android/rum/internal/domain/InfoData;", "", "cleanup", "", "getState", "()Lcom/datadog/android/rum/internal/domain/InfoData;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InfoProvider<T extends InfoData> {
    void cleanup();

    T getState();
}
