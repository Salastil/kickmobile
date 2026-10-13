package com.datadog.reactnative;

import com.facebook.react.bridge.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiThreadExecutor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/datadog/reactnative/ReactUiThreadExecutor;", "Lcom/datadog/reactnative/UiThreadExecutor;", "<init>", "()V", "runOnUiThread", "", "runnable", "Ljava/lang/Runnable;", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReactUiThreadExecutor implements UiThreadExecutor {
    @Override // com.datadog.reactnative.UiThreadExecutor
    public void runOnUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        UiThreadUtil.runOnUiThread(runnable);
    }
}
