package com.fingerprintjs.android.fpjs_pro;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/ProxyIntegrationSecretEnvironmentMismatch;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProxyIntegrationSecretEnvironmentMismatch extends Error {
    public static int D8871;
    public static int component5;

    public ProxyIntegrationSecretEnvironmentMismatch(String str, String str2) {
        super(str, str2, null);
    }

    public static int D8871() {
        int i = component5;
        int i2 = i % 7892908;
        component5 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        D8871 = iMaxMemory;
        return iMaxMemory;
    }
}
