package com.datadog.android.flags;

import kotlin.Metadata;

/* JADX INFO: compiled from: EvaluationContextCallback.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/flags/EvaluationContextCallback;", "", "onFailure", "", "error", "", "onSuccess", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EvaluationContextCallback {
    void onFailure(Throwable error);

    void onSuccess();
}
