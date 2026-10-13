package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class w2 {
    public static List a() {
        return (List) e3.c.getValue();
    }

    public static List b() {
        return (List) e3.d.getValue();
    }

    public final String toString() {
        List listA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            Integer numB = ((x2) it.next()).b();
            numB.intValue();
            arrayList.add(numB);
        }
        String string = arrayList.toString();
        List listB = b();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator it2 = listB.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((d3) it2.next()).b());
        }
        return string + ServerSentEventKt.SPACE + arrayList2.toString();
    }
}
