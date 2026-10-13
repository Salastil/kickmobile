package com.datadog.android.internal.profiler;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpExecutionTimer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpExecutionTimer;", "Lcom/datadog/android/internal/profiler/ExecutionTimer;", "()V", "measure", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpExecutionTimer implements ExecutionTimer {
    @Override // com.datadog.android.internal.profiler.ExecutionTimer
    public <T> T measure(Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke();
    }
}
