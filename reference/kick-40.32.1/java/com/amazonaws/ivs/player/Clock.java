package com.amazonaws.ivs.player;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
class Clock {
    private Clock() {
    }

    static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    static long getNanoTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
