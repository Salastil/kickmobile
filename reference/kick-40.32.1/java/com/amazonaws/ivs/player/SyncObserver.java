package com.amazonaws.ivs.player;

/* JADX INFO: compiled from: Sync.java */
/* JADX INFO: loaded from: classes5.dex */
interface SyncObserver {
    void onSyncSourceConnected(SyncSource syncSource);

    void onSyncSourceDisconnected(SyncSource syncSource);

    void onTargetTimeChanged(SyncSource syncSource, long j);
}
