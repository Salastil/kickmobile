package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class p1 extends q1 {
    public static final /* synthetic */ int d = 0;
    public final CoroutineDispatcher c;

    public /* synthetic */ p1(Context context) {
        this(context, Dispatchers.getIO());
    }

    public final void a(Context context) throws InterruptedException {
        Intrinsics.checkNotNullParameter(context, "context");
        LocalLogger.log(8, 22200L, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new n1(this, context, null), 1, null);
    }

    public p1(Context context, CoroutineDispatcher dispatcher) throws InterruptedException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.c = dispatcher;
        a(context);
    }
}
