package com.datadog.android.core.internal.thread;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.thread.NamedExecutionUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NamedFutureTask.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/thread/NamedFutureTask;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/FutureTask;", "Lcom/datadog/android/internal/thread/NamedExecutionUnit;", "name", "", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/lang/String;Ljava/util/concurrent/Callable;)V", "runnable", "Ljava/lang/Runnable;", "value", "(Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NamedFutureTask<V> extends FutureTask<V> implements NamedExecutionUnit {
    private final String name;

    @Override // com.datadog.android.internal.thread.NamedExecutionUnit
    public String getName() {
        return this.name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NamedFutureTask(String name, Callable<V> callable) {
        super(callable);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.name = name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NamedFutureTask(String name, Runnable runnable, V v) {
        super(runnable, v);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.name = name;
    }
}
