package com.facebook.common.disk;

import kotlin.Metadata;

/* JADX INFO: compiled from: DiskTrimmable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/facebook/common/disk/DiskTrimmable;", "", "trimToMinimum", "", "trimToNothing", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DiskTrimmable {
    void trimToMinimum();

    void trimToNothing();
}
