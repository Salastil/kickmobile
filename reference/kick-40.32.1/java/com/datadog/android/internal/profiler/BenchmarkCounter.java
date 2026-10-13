package com.datadog.android.internal.profiler;

import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: BenchmarkCounter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/datadog/android/internal/profiler/BenchmarkCounter;", "", "add", "", "value", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BenchmarkCounter {
    void add(long value, Map<String, String> attributes);
}
