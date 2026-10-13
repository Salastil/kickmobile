package com.useinsider.insider;

import android.content.Context;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Timer f320a;
    private static int b;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Insider insider = Insider.Instance;
            insider.flushData();
            insider.postStartRequest(o4.SESSION_START_REQUEST_REASON_FLUSH);
        }
    }

    private static void a() {
        try {
            if (b > 0) {
                Timer timer = new Timer();
                f320a = timer;
                a aVar = new a();
                long j = ((long) b) * 1000;
                timer.schedule(aVar, j, j);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void b(Context context) {
        try {
            if (w4.m(context)) {
                int iA = a(context);
                if (iA <= 0) {
                    Debugger.a(DebuggingTag.flushingTimerStoppedDueToZeroInterval, 4);
                    return;
                }
                b = iA;
                b();
                a();
                HashMap map = new HashMap();
                map.put("flushing_time_interval_seconds", Integer.valueOf(b));
                Debugger.a(DebuggingTag.flushingTimerStarted, 4, map);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(Context context, int i) {
        try {
            h4.a().e(context, "Insider").edit().putInt("insider_flush_interval", i).apply();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void b() {
        try {
            Timer timer = f320a;
            if (timer != null) {
                timer.cancel();
                f320a = null;
                Debugger.a(DebuggingTag.flushingTimerStopped, 4);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static int a(Context context) {
        try {
            return h4.a().e(context, "Insider").getInt("insider_flush_interval", -1);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return -1;
        }
    }
}
