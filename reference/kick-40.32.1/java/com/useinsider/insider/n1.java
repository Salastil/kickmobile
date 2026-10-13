package com.useinsider.insider;

import java.text.Normalizer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class n1 extends m1 {
    private final Pattern d;

    n1(String str, Object obj) {
        super(str, obj);
        this.d = Pattern.compile("\\p{M}+");
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return this.d.matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("").toLowerCase(Locale.ROOT);
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        List listA;
        List listA2 = a(map.get(getKey()));
        if (listA2 == null || (listA = a(a())) == null) {
            return false;
        }
        Iterator it = listA2.iterator();
        while (it.hasNext()) {
            String strA = a((String) it.next());
            if (strA != null) {
                Iterator it2 = listA.iterator();
                while (it2.hasNext()) {
                    String strA2 = a((String) it2.next());
                    if (strA2 != null && strA.contains(strA2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
