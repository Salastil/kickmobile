package org.h.s;

import android.net.NetworkCapabilities;
import android.os.Build;
import com.facebook.common.callercontext.ContextChain;
import io.mobileshield.sdk.config.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes11.dex */
public final class y1 {
    public static final u1 h = new u1();
    public static y1 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f591a;
    public final t1 b;
    public final List c;
    public final ConcurrentHashMap d;
    public final List e;
    public final ConcurrentHashMap f;
    public Config g;

    public y1(CoroutineDispatcher ioDispatcher, t1 metricsBatchAnalyser) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(metricsBatchAnalyser, "metricsBatchAnalyser");
        this.f591a = ioDispatcher;
        this.b = metricsBatchAnalyser;
        List listSynchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
        this.c = listSynchronizedList;
        this.d = new ConcurrentHashMap();
        this.e = CollectionsKt.listOf(r4.INTERROGATION);
        this.f = new ConcurrentHashMap();
    }

    public final void a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            ConcurrentHashMap concurrentHashMap = this.d;
            r4 r4Var = r4.INTERROGATION;
            q4 q4Var = (q4) concurrentHashMap.get(r4Var);
            z1 z1Var = q4Var != null ? q4Var.j : null;
            if (z1Var != null) {
                z1Var.a(Integer.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps() / 1024));
            }
            q4 q4Var2 = (q4) this.d.get(r4Var);
            z1 z1Var2 = q4Var2 != null ? q4Var2.j : null;
            if (z1Var2 != null) {
                z1Var2.c(Integer.valueOf(networkCapabilities.getLinkUpstreamBandwidthKbps() / 1024));
            }
            TimeUnit timeUnit = t4.f575a;
            if (Build.VERSION.SDK_INT >= 29) {
                q4 q4Var3 = (q4) this.d.get(r4Var);
                z1 z1Var3 = q4Var3 != null ? q4Var3.j : null;
                if (z1Var3 == null) {
                    return;
                }
                z1Var3.b(Integer.valueOf(networkCapabilities.getSignalStrength()));
            }
        }
    }

    public final synchronized void b() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f591a), null, null, new w1(this, null), 3, null);
    }

    public final void c() {
        q4 q4Var = (q4) this.d.get(r4.INITIALISATION);
        z1 z1Var = q4Var != null ? q4Var.j : null;
        if (z1Var == null) {
            return;
        }
        z1Var.b();
    }

    public static void a(y1 y1Var, r4 traceType) {
        y1Var.getClass();
        Intrinsics.checkNotNullParameter(traceType, "type");
        if (a0.e.c) {
            t1 t1Var = y1Var.b;
            ConcurrentHashMap singletonTraceStarted = y1Var.f;
            t1Var.getClass();
            Intrinsics.checkNotNullParameter(traceType, "traceType");
            Intrinsics.checkNotNullParameter(singletonTraceStarted, "singletonTraceStarted");
            Object obj = singletonTraceStarted.get(traceType);
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(obj, bool) && RangesKt.random(new IntRange(1, 10000), Random.INSTANCE) <= b3.j.c()) {
                y1Var.d.put(traceType, new q4(traceType, (String) null, 5));
            }
            if (y1Var.e.contains(traceType)) {
                y1Var.f.put(traceType, bool);
            }
        }
    }

    public final void a(r4 type, String label) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(label, "label");
        q4 q4Var = (q4) this.d.get(type);
        if (q4Var != null) {
            Intrinsics.checkNotNullParameter(label, "label");
            if (q4Var.f != 0) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - q4Var.h;
            q4Var.h = jCurrentTimeMillis;
            q4Var.d.add(new z3(label, j, null));
        }
    }

    public final String a() {
        return "AAE=" + CollectionsKt.joinToString$default(CollectionsKt.toList(this.c), ContextChain.TAG_INFRA, null, null, 0, null, v1.f581a, 30, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x0074  */
    /* JADX WARN: Code duplicated, block: B:25:0x0075 A[Catch: all -> 0x00f9, TryCatch #0 {, blocks: (B:22:0x0056, B:31:0x009a, B:25:0x0075, B:26:0x007e, B:28:0x0084, B:29:0x0090), top: B:45:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0084 A[Catch: all -> 0x00f9, LOOP:0: B:26:0x007e->B:28:0x0084, LOOP_END, TryCatch #0 {, blocks: (B:22:0x0056, B:31:0x009a, B:25:0x0075, B:26:0x007e, B:28:0x0084, B:29:0x0090), top: B:45:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00df  */
    /* JADX WARN: Code duplicated, block: B:45:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0046 -> B:18:0x0049). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.h.s.y1.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
