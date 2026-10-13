package com.amazon.mediatailorsdk.threading;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: ThreadingScope.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/amazon/mediatailorsdk/threading/ThreadingScope;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "errorsState", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getErrorsState", "()Lkotlinx/coroutines/flow/SharedFlow;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ThreadingScope {
    CoroutineScope getCoroutineScope();

    SharedFlow<Throwable> getErrorsState();
}
