package org.h.s;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class p4 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p4 f556a = new p4();

    public p4() {
        super(1);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0083  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String strA;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.mobileshield.sdk.global.performance.Span");
        z3 z3Var = (z3) obj;
        String str = z3Var.c;
        if (str != null) {
            return str;
        }
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(z3Var.f595a, y3.LABEL), TuplesKt.to(Long.valueOf(z3Var.b), y3.DURATION_MS), TuplesKt.to(null, y3.METADATA));
        ArrayList arrayList = new ArrayList(mapMapOf.size());
        for (Map.Entry entry : mapMapOf.entrySet()) {
            Object key = entry.getKey();
            y3 y3Var = (y3) entry.getValue();
            int iOrdinal = y3Var.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                strA = a2.a(String.valueOf(key), y3Var.ordinal());
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (key != null) {
                    int iOrdinal2 = y3Var.ordinal();
                    String json = new Gson().toJson((z1) key);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                    strA = a2.a(json, iOrdinal2);
                    if (strA == null) {
                        strA = "";
                    }
                } else {
                    strA = "";
                }
            }
            arrayList.add(strA);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, "w", null, null, 0, null, null, 62, null);
        z3Var.c = strJoinToString$default;
        return strJoinToString$default;
    }
}
