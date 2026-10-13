package com.facebook.common.disk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDiskTrimmableRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/common/disk/NoOpDiskTrimmableRegistry;", "Lcom/facebook/common/disk/DiskTrimmableRegistry;", "<init>", "()V", "registerDiskTrimmable", "", "trimmable", "Lcom/facebook/common/disk/DiskTrimmable;", "unregisterDiskTrimmable", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    public static final NoOpDiskTrimmableRegistry INSTANCE = new NoOpDiskTrimmableRegistry();

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void registerDiskTrimmable(DiskTrimmable trimmable) {
        Intrinsics.checkNotNullParameter(trimmable, "trimmable");
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void unregisterDiskTrimmable(DiskTrimmable trimmable) {
        Intrinsics.checkNotNullParameter(trimmable, "trimmable");
    }

    private NoOpDiskTrimmableRegistry() {
    }
}
