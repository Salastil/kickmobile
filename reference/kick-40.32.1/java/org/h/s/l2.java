package org.h.s;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e4 f535a;
    public final AtomicBoolean b;
    public i2 c;
    public int d;
    public boolean e;
    public final j2 f;

    public l2(e4 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f535a = callback;
        this.b = new AtomicBoolean(false);
        this.f = new j2(this);
    }

    public final void a(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        s3 s3Var = f1.f506a;
        f1.a(w0.g0, null);
        boolean z = false;
        this.f535a.f503a.a(new u3(a4.NETWORKCHECK, 0));
        if (!this.b.getAndSet(true) || !a0.j.c) {
            i2 i2Var = new i2();
            this.c = i2Var;
            i2Var.addObserver(new Observer() { // from class: org.h.s.l2$$ExternalSyntheticLambda0
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    l2.a(this.f$0, observable, obj);
                }
            });
            b(ctx);
        }
        Object systemService = ctx.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            TimeUnit timeUnit = t4.f575a;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (y1.i == null) {
                    y1.i = new y1(Dispatchers.getIO(), new t1());
                }
                y1 y1Var = y1.i;
                Intrinsics.checkNotNull(y1Var);
                y1Var.a(networkCapabilities);
                if (networkCapabilities != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(4))) {
                    z = true;
                }
            }
        } catch (Exception e) {
            LocalLogger.log(16, 24003L, e.getLocalizedMessage());
        }
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1 y1Var2 = y1.i;
        Intrinsics.checkNotNull(y1Var2);
        y1Var2.a(r4.INTERROGATION, "check_network");
        LocalLogger.log(16, 24001L, String.valueOf(z));
        i2 i2Var2 = this.c;
        if (i2Var2 == null) {
            return;
        }
        i2Var2.a(z);
    }

    public final void b(Context context) {
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            this.d++;
            connectivityManager.registerNetworkCallback(networkRequestBuild, this.f);
            this.e = false;
            s3 s3Var = f1.f506a;
            f1.a(w0.i0, FirebaseAnalytics.Param.SUCCESS);
        } catch (Exception e) {
            s3 s3Var2 = f1.f506a;
            f1.a(w0.i0, "failure: " + y.a(e));
            this.e = true;
        }
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            Result.Companion companion = Result.INSTANCE;
            s3 s3Var = f1.f506a;
            f1.a(w0.j0, null);
            this.b.set(false);
            this.c = null;
            connectivityManager.unregisterNetworkCallback(this.f);
            Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final void a(l2 this$0, Observable observable, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) obj).booleanValue()) {
            this$0.a();
            return;
        }
        this$0.getClass();
        if (a0.e.c) {
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            Collection collectionValues = y1Var.d.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                z1 z1Var = ((q4) it.next()).j;
                if (z1Var != null) {
                    z1Var.c();
                }
            }
        }
        s3 s3Var = f1.f506a;
        f1.a(w0.h0, "not available");
        i4 i4Var = this$0.f535a.f503a;
        i4Var.getClass();
        LocalLogger.log(16, 22327L, GesturesListener.SCROLL_DIRECTION_DOWN);
        i4Var.i.a();
        i4Var.a((u) null);
        i4Var.a(new u3(a4.SLEEP_NETWORKDOWN, 0));
    }

    public final void a() {
        s3 s3Var = f1.f506a;
        f1.a(w0.h0, "available");
        i4 i4Var = this.f535a.f503a;
        synchronized (i4Var) {
            a4 a4Var = a4.RESUME;
            if (!ArraysKt.contains(new a4[]{a4.DONE, a4Var, a4.START, a4.INIT}, i4Var.l.f579a)) {
                LocalLogger.log(16, 22323L, "resume");
                i4Var.a(new u3(a4Var, 0));
                i4Var.i.a();
                Config[] configArr = null;
                i4Var.a((u) null);
                Config[] configArr2 = i4Var.c;
                if (configArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("localConfig");
                } else {
                    configArr = configArr2;
                }
                i4Var.a(configArr, i4Var.h.a(i4Var.f523a, configArr, i4Var.h()));
            }
        }
    }
}
