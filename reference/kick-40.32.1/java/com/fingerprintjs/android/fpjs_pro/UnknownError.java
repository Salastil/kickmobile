package com.fingerprintjs.android.fpjs_pro;

import android.os.SystemClock;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/UnknownError;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnknownError extends Error {
    public static int D8871;
    public static int setPivotYN16904;

    public /* synthetic */ UnknownError(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ViewUtilsKt.UNKNOWN_DESTINATION_URL : str, (i & 2) != 0 ? ViewUtilsKt.UNKNOWN_DESTINATION_URL : str2);
    }

    public UnknownError(String str, String str2) {
        super(str, str2, null);
    }

    public static int vD14832N6715() {
        int i = D8871;
        int i2 = i % 8227713;
        D8871 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        setPivotYN16904 = iElapsedRealtime;
        return iElapsedRealtime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnknownError() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
