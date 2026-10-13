package org.h.s;

import io.mobileshield.sdk.logger.LocalLogger;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
public final class h0 implements Callback {
    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        LocalLogger.log(4, 12006L, e.getMessage());
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        LocalLogger.log(16, 12005L, String.valueOf(response.code()));
    }
}
