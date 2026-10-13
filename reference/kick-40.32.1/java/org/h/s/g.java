package org.h.s;

import io.mobileshield.sdk.HeadersCallback;
import io.mobileshield.sdk.RequestHeaderReason;
import io.mobileshield.sdk.logger.LocalLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f509a = Executors.newSingleThreadScheduledExecutor();
    public u3 b = new u3(a4.NETWORKCHECK, 0);

    @Override // org.h.s.j4
    public final void a(u3 sdkState) {
        Intrinsics.checkNotNullParameter(sdkState, "sdkState");
        synchronized (this) {
            LocalLogger.log(16, 27000L, "");
            this.b = sdkState;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(final HeadersCallback headersCallback, final c4 c4Var) {
        LocalLogger.log(16, 27001L, "");
        int iOrdinal = this.b.b().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            LocalLogger.log(16, 27001L, "State = " + this.b.b());
            this.f509a.schedule(new Runnable() { // from class: org.h.s.g$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    g.a(this.f$0, c4Var, headersCallback);
                }
            }, 200L, TimeUnit.MILLISECONDS);
            return;
        }
        if (iOrdinal != 6) {
            s3 s3Var = f1.f506a;
            f1.a(w0.c0, String.valueOf(this.b.a()));
            headersCallback.onFailure(new RequestHeaderReason(this.b.b().a()));
        } else {
            s3 s3Var2 = f1.f506a;
            f1.a(w0.b0, null);
            i4 i4Var = (i4) c4Var;
            headersCallback.onSuccess(o0.a(i4Var.f(), i4Var.h()));
        }
    }

    public static final void a(g this$0, c4 store, HeadersCallback headersCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(store, "$store");
        Intrinsics.checkNotNullParameter(headersCallback, "$headersCallback");
        this$0.a(headersCallback, store);
    }
}
