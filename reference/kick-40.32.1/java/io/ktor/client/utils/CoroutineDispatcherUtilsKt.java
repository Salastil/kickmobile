package io.ktor.client.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CoroutineDispatcherUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "threadCount", "", "dispatcherName", "Lkotlinx/coroutines/CoroutineDispatcher;", "clientDispatcher", "(Lkotlinx/coroutines/Dispatchers;ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CoroutineDispatcherUtilsKt {
    public static final CoroutineDispatcher clientDispatcher(Dispatchers dispatchers, int i, String dispatcherName) {
        Intrinsics.checkNotNullParameter(dispatchers, "<this>");
        Intrinsics.checkNotNullParameter(dispatcherName, "dispatcherName");
        return CoroutineDispatcher.limitedParallelism$default(Dispatchers.getIO(), i, null, 2, null);
    }

    public static /* synthetic */ CoroutineDispatcher clientDispatcher$default(Dispatchers dispatchers, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "ktor-client-dispatcher";
        }
        return clientDispatcher(dispatchers, i, str);
    }
}
