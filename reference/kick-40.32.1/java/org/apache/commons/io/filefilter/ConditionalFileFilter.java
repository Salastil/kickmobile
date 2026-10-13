package org.apache.commons.io.filefilter;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List list);
}
