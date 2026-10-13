package com.datadog.android.trace.internal.domain.event;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.context.DatadogContext;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextAwareMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/internal/domain/event/ContextAwareMapper;", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "map", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "model", "(Lcom/datadog/android/api/context/DatadogContext;Ljava/lang/Object;)Ljava/lang/Object;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContextAwareMapper<R, T> {
    T map(DatadogContext datadogContext, R model);
}
