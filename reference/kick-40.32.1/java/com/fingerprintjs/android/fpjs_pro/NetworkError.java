package com.fingerprintjs.android.fpjs_pro;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/NetworkError;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "description", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkError extends Error {
    public /* synthetic */ NetworkError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Network error. Check your connection or the endpoint URL" : str);
    }

    public NetworkError(String str) {
        super(null, str, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkError() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
