package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultFileComparator implements Comparator, Serializable {
    public static final Comparator DEFAULT_COMPARATOR;
    public static final Comparator DEFAULT_REVERSE;

    static {
        DefaultFileComparator defaultFileComparator = new DefaultFileComparator();
        DEFAULT_COMPARATOR = defaultFileComparator;
        DEFAULT_REVERSE = new ReverseComparator(defaultFileComparator);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((File) obj).compareTo((File) obj2);
    }
}
