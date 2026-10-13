package org.h.s;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class u1 {
    public final synchronized y1 a() {
        y1 y1Var;
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1Var = y1.i;
        Intrinsics.checkNotNull(y1Var);
        return y1Var;
    }
}
