package com.mux.stats.sdk.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/* JADX INFO: loaded from: classes8.dex */
public class Util {

    public interface Consumer<T> {
        void apply(T t);
    }

    public interface Function1<T, R> {
        R accept(T t);
    }

    public static <T> List<T> filter(List<T> list, Function<T, Boolean> function) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (function.apply(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> T firstOrNull(Collection<T> collection, Function<T, Boolean> function) {
        for (T t : collection) {
            if (function.apply(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static <T> T lazyGet(T t, Callable<T> callable) {
        if (t != null) {
            return t;
        }
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException("lazyGet: factory threw an exception", e);
        }
    }

    public static <T> T let(T t, Consumer<T> consumer) {
        if (t == null) {
            return null;
        }
        consumer.apply(t);
        return t;
    }

    public static <T> boolean noneOf(T t, T... tArr) {
        for (T t2 : tArr) {
            if (t.equals(t2)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean oneOf(T t, T... tArr) {
        for (T t2 : tArr) {
            if (t.equals(t2)) {
                return true;
            }
        }
        return false;
    }
}
