package com.datadog.reactnative;

import kotlin.Metadata;

/* JADX INFO: compiled from: DdSdkSynthetics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/datadog/reactnative/DdSdkSynthetics;", "", "<init>", "()V", "testId", "", "getTestId", "()Ljava/lang/String;", "setTestId", "(Ljava/lang/String;)V", "resultId", "getResultId", "setResultId", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdkSynthetics {
    public static final DdSdkSynthetics INSTANCE = new DdSdkSynthetics();
    private static String resultId;
    private static String testId;

    private DdSdkSynthetics() {
    }

    public final String getTestId() {
        return testId;
    }

    public final void setTestId(String str) {
        testId = str;
    }

    public final String getResultId() {
        return resultId;
    }

    public final void setResultId(String str) {
        resultId = str;
    }
}
