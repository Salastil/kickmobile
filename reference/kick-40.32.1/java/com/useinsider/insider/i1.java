package com.useinsider.insider;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class i1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f342a;
    private final Object b;
    private final Pattern c = Pattern.compile("\\p{M}+");
    private final e5 d = new y4();
    private final e4 e = new e4(new y4());

    i1(String str, Object obj) {
        this.f342a = str;
        this.b = obj;
    }

    private Object a(Object obj, e5 e5Var) {
        return e5Var.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f342a;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        final String strA = a((String) a(map.get(getKey()), this.d));
        if (strA == null) {
            return false;
        }
        return ((List) a(this.b, this.e)).stream().anyMatch(new Predicate() { // from class: com.useinsider.insider.i1$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.a(strA, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(String str, String str2) {
        return str.contains(a(str2));
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return this.c.matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("").toLowerCase(Locale.ROOT);
    }
}
