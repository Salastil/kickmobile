package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.bouncycastle.util.Strings;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        Strings.StringListImpl stringListImpl = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            stringListImpl.add(arrayList.get(i).freeze());
        }
        return stringListImpl;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        Strings.StringListImpl stringListImpl = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            stringListImpl.add(it.next().freeze());
        }
        return stringListImpl;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        Strings.StringListImpl stringListImpl = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            stringListImpl.add(e.freeze());
        }
        return stringListImpl;
    }
}
