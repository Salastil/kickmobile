package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class z {
    public final String toString() {
        a0[] a0VarArrValues = a0.values();
        ArrayList arrayList = new ArrayList(a0VarArrValues.length);
        for (a0 a0Var : a0VarArrValues) {
            boolean zB = a0Var.b();
            TimeUnit timeUnit = t4.f575a;
            arrayList.add(zB + ServerSentEventKt.COLON + t4.a(a0Var.c()));
        }
        return CollectionsKt.toList(arrayList).toString();
    }
}
