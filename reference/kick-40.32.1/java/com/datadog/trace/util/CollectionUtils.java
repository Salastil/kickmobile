package com.datadog.trace.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class CollectionUtils {
    public static <T> Set<T> tryMakeImmutableSet(Collection<T> collection) {
        return new HashSet(collection);
    }

    public static <T> List<T> tryMakeImmutableList(Collection<T> collection) {
        return new ArrayList(collection);
    }

    public static <K, V> Map<K, V> tryMakeImmutableMap(Map<K, V> map) {
        return new HashMap(map);
    }
}
