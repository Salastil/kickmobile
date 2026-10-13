package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
class NativeRunnable implements Runnable {
    long handle;

    private native void runNative(long j);

    NativeRunnable(long j) {
        this.handle = j;
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        long j = this.handle;
        if (j != 0) {
            runNative(j);
        }
    }

    public synchronized void invalidate() {
        this.handle = 0L;
    }
}
