package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncEventWriteScope.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0096\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/persistence/AsyncEventWriteScope;", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "executor", "Ljava/util/concurrent/Executor;", "writer", "featureWriteLock", "", "featureName", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/util/concurrent/Executor;Lcom/datadog/android/api/storage/EventBatchWriter;Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)V", "invoke", "block", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncEventWriteScope implements Function1<Function1<? super EventBatchWriter, ? extends Unit>, Unit> {
    private final Executor executor;
    private final String featureName;
    private final Object featureWriteLock;
    private final InternalLogger internalLogger;
    private final EventBatchWriter writer;

    public AsyncEventWriteScope(Executor executor, EventBatchWriter writer, Object featureWriteLock, String featureName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(featureWriteLock, "featureWriteLock");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.executor = executor;
        this.writer = writer;
        this.featureWriteLock = featureWriteLock;
        this.featureName = featureName;
        this.internalLogger = internalLogger;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super EventBatchWriter, ? extends Unit> function1) {
        invoke2((Function1<? super EventBatchWriter, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(final Function1<? super EventBatchWriter, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrencyExtKt.executeSafe(this.executor, "eventWriteScopeInvoke-" + this.featureName, this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AsyncEventWriteScope$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AsyncEventWriteScope.invoke$lambda$1(this.f$0, block);
            }
        });
    }

    static final void invoke$lambda$1(AsyncEventWriteScope asyncEventWriteScope, Function1 function1) {
        synchronized (asyncEventWriteScope.featureWriteLock) {
            function1.invoke(asyncEventWriteScope.writer);
            Unit unit = Unit.INSTANCE;
        }
    }
}
