package org.h.s;

import com.google.android.gms.location.DeviceOrientationRequest;
import io.mobileshield.sdk.logger.LocalLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 extends a {
    public final long b;
    public long c;
    public final int d;

    public /* synthetic */ c0() {
        this(5000L, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, 5);
    }

    public final t3 a() {
        if (this.f485a > this.d) {
            LocalLogger.log(16, 23102L, "");
            b();
        }
        int i = this.f485a + 1;
        this.f485a = i;
        if (i > 1 && a0.e.c) {
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            ConcurrentHashMap concurrentHashMap = y1Var.d;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (entry.getKey() == r4.INTERROGATION) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                z1 z1Var = ((q4) ((Map.Entry) it.next()).getValue()).j;
                if (z1Var != null) {
                    z1Var.a(z1Var.getMobileSdkRetries() + 1);
                }
            }
        }
        if (this.c < 10000) {
            this.c = 10000L;
        }
        t3 t3Var = new t3(this.f485a, this.c, this.b);
        LocalLogger.log(16, 23100L, t3Var.toString());
        return t3Var;
    }

    public final void b() {
        LocalLogger.log(16, 23101L, "");
        this.f485a = 0;
    }

    public c0(long j, long j2, int i) {
        this.b = j;
        this.c = j2;
        this.d = i;
    }
}
