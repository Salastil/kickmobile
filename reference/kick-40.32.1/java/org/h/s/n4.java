package org.h.s;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n4 implements j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f547a;
    public final Function0 b;

    public n4(d2 sdkDoneCallback, e2 sdkPauseCallback) {
        Intrinsics.checkNotNullParameter(sdkDoneCallback, "sdkDoneCallback");
        Intrinsics.checkNotNullParameter(sdkPauseCallback, "sdkPauseCallback");
        this.f547a = sdkDoneCallback;
        this.b = sdkPauseCallback;
    }

    @Override // org.h.s.j4
    public final void a(u3 sdkState) {
        Intrinsics.checkNotNullParameter(sdkState, "sdkState");
        int iOrdinal = sdkState.f579a.ordinal();
        if (iOrdinal == 5) {
            this.b.invoke();
        } else {
            if (iOrdinal != 6) {
                return;
            }
            this.f547a.invoke();
        }
    }
}
