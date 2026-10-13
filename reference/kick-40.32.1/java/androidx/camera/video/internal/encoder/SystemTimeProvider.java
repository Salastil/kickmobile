package androidx.camera.video.internal.encoder;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SystemTimeProvider implements TimeProvider {
    @Override // androidx.camera.video.internal.encoder.TimeProvider
    public long uptimeUs() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return System.nanoTime() / 1000;
    }

    @Override // androidx.camera.video.internal.encoder.TimeProvider
    public long realtimeUs() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return SystemClock.elapsedRealtimeNanos() / 1000;
    }
}
