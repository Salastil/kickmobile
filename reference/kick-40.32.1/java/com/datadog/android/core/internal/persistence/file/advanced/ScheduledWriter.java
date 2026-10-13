package com.datadog.android.core.internal.persistence.file.advanced;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScheduledWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0017R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ScheduledWriter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "delegateWriter", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/internal/persistence/DataWriter;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;)V", "getDelegateWriter$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/DataWriter;", "getExecutorService$dd_sdk_android_core_release", "()Ljava/util/concurrent/ExecutorService;", "write", "", "element", "(Ljava/lang/Object;)V", "data", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScheduledWriter<T> implements DataWriter<T> {
    private final DataWriter<T> delegateWriter;
    private final ExecutorService executorService;
    private final InternalLogger internalLogger;

    public ScheduledWriter(DataWriter<T> delegateWriter, ExecutorService executorService, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(delegateWriter, "delegateWriter");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.delegateWriter = delegateWriter;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
    }

    public final DataWriter<T> getDelegateWriter$dd_sdk_android_core_release() {
        return this.delegateWriter;
    }

    /* JADX INFO: renamed from: getExecutorService$dd_sdk_android_core_release, reason: from getter */
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(final T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data writing", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.delegateWriter.write(element);
            }
        });
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(final List<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data writing", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.delegateWriter.write(data);
            }
        });
    }
}
