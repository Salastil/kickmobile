package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes10.dex */
public class ExtensionFileComparator implements Comparator, Serializable {
    public static final Comparator EXTENSION_COMPARATOR;
    public static final Comparator EXTENSION_INSENSITIVE_COMPARATOR;
    public static final Comparator EXTENSION_INSENSITIVE_REVERSE;
    public static final Comparator EXTENSION_REVERSE;
    public static final Comparator EXTENSION_SYSTEM_COMPARATOR;
    public static final Comparator EXTENSION_SYSTEM_REVERSE;
    private final IOCase caseSensitivity;

    static {
        ExtensionFileComparator extensionFileComparator = new ExtensionFileComparator();
        EXTENSION_COMPARATOR = extensionFileComparator;
        EXTENSION_REVERSE = new ReverseComparator(extensionFileComparator);
        ExtensionFileComparator extensionFileComparator2 = new ExtensionFileComparator(IOCase.INSENSITIVE);
        EXTENSION_INSENSITIVE_COMPARATOR = extensionFileComparator2;
        EXTENSION_INSENSITIVE_REVERSE = new ReverseComparator(extensionFileComparator2);
        ExtensionFileComparator extensionFileComparator3 = new ExtensionFileComparator(IOCase.SYSTEM);
        EXTENSION_SYSTEM_COMPARATOR = extensionFileComparator3;
        EXTENSION_SYSTEM_REVERSE = new ReverseComparator(extensionFileComparator3);
    }

    public ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public ExtensionFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.caseSensitivity.checkCompareTo(FilenameUtils.getExtension(((File) obj).getName()), FilenameUtils.getExtension(((File) obj2).getName()));
    }
}
