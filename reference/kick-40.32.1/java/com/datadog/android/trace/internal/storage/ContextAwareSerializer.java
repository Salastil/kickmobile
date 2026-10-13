package com.datadog.android.trace.internal.storage;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.context.DatadogContext;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextAwareSerializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/internal/storage/ContextAwareSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "serialize", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "model", "(Lcom/datadog/android/api/context/DatadogContext;Ljava/lang/Object;)Ljava/lang/String;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContextAwareSerializer<T> {
    String serialize(DatadogContext datadogContext, T model);
}
