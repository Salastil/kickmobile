package org.h.s;

import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
public final class o2 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f551a;
    public final /* synthetic */ Function1 b;

    public o2(Function0 function0, Function1 function1) {
        this.f551a = function0;
        this.b = function1;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        s3 s3Var = f1.f506a;
        f1.a(w0.f0, e.getMessage());
        this.f551a.invoke();
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.b.invoke(response);
    }
}
