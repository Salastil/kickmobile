package org.h.s;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f543a;

    public n0(g requestHandler, p0 methodToListenToState) {
        Intrinsics.checkNotNullParameter(requestHandler, "requestHandler");
        Intrinsics.checkNotNullParameter(methodToListenToState, "methodToListenToState");
        this.f543a = requestHandler;
        methodToListenToState.invoke(requestHandler);
    }

    public /* synthetic */ n0(p0 p0Var) {
        this(new g(), p0Var);
    }
}
