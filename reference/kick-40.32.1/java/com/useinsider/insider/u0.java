package com.useinsider.insider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class u0 extends t0 {
    e4 d;

    u0(String str, Object obj) {
        super(str, obj);
        this.d = new e4(new f4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long[] a(int i) {
        return new Long[i];
    }

    private Long[] b(Object obj) {
        List list = (List) this.d.b(obj);
        if (list == null) {
            return null;
        }
        return (Long[]) list.stream().map(new Function() { // from class: com.useinsider.insider.u0$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return Long.valueOf(((BigDecimal) obj2).longValue());
            }
        }).toArray(new IntFunction() { // from class: com.useinsider.insider.u0$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return u0.a(i);
            }
        });
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        Long[] lArrB;
        Long lA = a(map.get(this.f435a));
        return lA != null && (lArrB = b(this.b)) != null && lArrB.length >= 2 && lA.longValue() >= lArrB[0].longValue() && lA.longValue() <= lArrB[1].longValue();
    }
}
