package com.facebook.common.disk;

import kotlin.Metadata;

/* JADX INFO: compiled from: DiskTrimmableRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/facebook/common/disk/DiskTrimmableRegistry;", "", "registerDiskTrimmable", "", "trimmable", "Lcom/facebook/common/disk/DiskTrimmable;", "unregisterDiskTrimmable", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(DiskTrimmable trimmable);

    void unregisterDiskTrimmable(DiskTrimmable trimmable);
}
