package com.amazonaws.ivs.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: Sync.java */
/* JADX INFO: loaded from: classes5.dex */
class SyncSource {
    private final AtomicLong currentTimestamp = new AtomicLong(0);
    private boolean isConnected = false;
    private final LinkedList<SyncObserver> observers = new LinkedList<>();

    SyncSource() {
    }

    public synchronized void notifyTargetTimeChanged(long j) {
        this.currentTimestamp.set(j);
        Iterator<SyncObserver> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onTargetTimeChanged(this, j);
        }
    }

    public synchronized void addObserver(SyncObserver syncObserver) {
        this.observers.add(syncObserver);
        if (this.isConnected) {
            syncObserver.onSyncSourceConnected(this);
        }
    }

    public synchronized void removeObserver(SyncObserver syncObserver) {
        this.observers.remove(syncObserver);
        if (this.isConnected) {
            syncObserver.onSyncSourceDisconnected(this);
        }
    }

    public synchronized void clearObservers() {
        this.observers.clear();
    }

    public synchronized void setConnected(boolean z) {
        if (this.isConnected == z) {
            return;
        }
        this.isConnected = z;
        LinkedList<SyncObserver> linkedList = this.observers;
        if (z) {
            Iterator<SyncObserver> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next().onSyncSourceConnected(this);
            }
        } else {
            Iterator<SyncObserver> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                it2.next().onSyncSourceDisconnected(this);
            }
        }
    }

    long getCurrentTimestamp() {
        return this.currentTimestamp.get();
    }
}
