package com.datadog.android.internal.heatmaps;

import expo.modules.notifications.service.NotificationsService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeatmapIdentifierStore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierStore;", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "()V", NotificationsService.IDENTIFIERS_KEY, "", "", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "snapshotScreenName", "", "getHeatmapIdentifier", "heatmapViewKey", "currentScreenName", "setHeatmapIdentifiers", "", "", "screenName", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HeatmapIdentifierStore implements HeatmapIdentifierRegistry {
    private String snapshotScreenName;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Long, HeatmapIdentifier> identifiers = new LinkedHashMap();

    @Override // com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry
    public void setHeatmapIdentifiers(Map<Long, HeatmapIdentifier> identifiers, String screenName) {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.snapshotScreenName = screenName;
            this.identifiers.clear();
            this.identifiers.putAll(identifiers);
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry
    public HeatmapIdentifier getHeatmapIdentifier(long heatmapViewKey, String currentScreenName) {
        Intrinsics.checkNotNullParameter(currentScreenName, "currentScreenName");
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            return Intrinsics.areEqual(this.snapshotScreenName, currentScreenName) ? this.identifiers.get(Long.valueOf(heatmapViewKey)) : null;
        } finally {
            lock.unlock();
        }
    }
}
