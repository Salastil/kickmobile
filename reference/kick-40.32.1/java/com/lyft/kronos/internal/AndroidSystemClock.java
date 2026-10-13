package com.lyft.kronos.internal;

import android.os.SystemClock;
import com.lyft.kronos.Clock;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidSystemClock.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/lyft/kronos/internal/AndroidSystemClock;", "Lcom/lyft/kronos/Clock;", "()V", "getCurrentTimeMs", "", "getElapsedTimeMs", "kronos-android_release"}, k = 1, mv = {1, 4, 0})
public final class AndroidSystemClock implements Clock {
    @Override // com.lyft.kronos.Clock
    public long getCurrentTimeMs() {
        return System.currentTimeMillis();
    }

    @Override // com.lyft.kronos.Clock
    public long getElapsedTimeMs() {
        return SystemClock.elapsedRealtime();
    }
}
