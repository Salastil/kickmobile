package com.mux.stats.sdk.core.util;

import com.mux.stats.sdk.core.events.DebugEvent;
import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.events.IEventListener;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.model.CustomerData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.muxstats.IDevice;
import com.mux.stats.sdk.muxstats.LogPriority;
import com.mux.stats.sdk.muxstats.MuxStats;
import expo.modules.notifications.service.NotificationsService;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public class MuxLogger {
    public static final int LOG_LEVEL_NORMAL = 0;
    public static final int LOG_LEVEL_VERBOSE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f272a;
    private static IEventListener b;
    private static Boolean c = Boolean.FALSE;

    private static boolean a() {
        return f272a != null;
    }

    private static boolean a(String str) {
        return a() && f272a.indexOf(str) >= 0;
    }

    private static boolean b() {
        return a() && f272a.indexOf("all") >= 0;
    }

    public static void d(String str, String str2) {
        IDevice hostDevice = MuxStats.getHostDevice();
        if (!c.booleanValue() || hostDevice == null) {
            return;
        }
        hostDevice.outputLog(LogPriority.DEBUG, str, str2);
    }

    public static void enable(String str, IEventListener iEventListener) {
        f272a = str;
        b = iEventListener;
    }

    public static void event(String str) {
        if (b() || a("event")) {
            b.handle(new DebugEvent("type=event " + str));
        }
    }

    public static void exception(Throwable th, String str, String str2) {
        exception(th, str, str2, (CustomerPlayerData) null);
    }

    public static void exception(Throwable th, String str, String str2, @Nullable CustomerData customerData) {
        exception(th, str, str2, customerData != null ? customerData.getCustomerPlayerData() : null);
    }

    public static void exception(Throwable th, String str, String str2, @Nullable CustomerPlayerData customerPlayerData) {
        if (b() || a(NotificationsService.EXCEPTION_KEY)) {
            String str3 = String.format(Locale.US, "type=exception For env %s\n%s\n%s", customerPlayerData != null ? customerPlayerData.getEnvironmentKey() : null, str2, th);
            IEventListener iEventListener = b;
            if (iEventListener != null) {
                iEventListener.handle(new DebugEvent(str3));
            }
            IDevice hostDevice = MuxStats.getHostDevice();
            if (!c.booleanValue() || hostDevice == null) {
                return;
            }
            hostDevice.outputLog(LogPriority.ERROR, str, str2, th);
        }
    }

    public static void info(String str) {
        if (b() || a("info")) {
            b.handle(new DebugEvent("type=info " + str));
        }
    }

    public static void printEvent(String str, IEvent iEvent) {
        if (iEvent.getType().equalsIgnoreCase(InternalHeartbeatEvent.TYPE) || iEvent.getType().equalsIgnoreCase(TimeUpdateEvent.TYPE)) {
            return;
        }
        d(str, "Sending event: " + iEvent.getType());
    }

    public static void setAllowLogcat(boolean z) {
        c = Boolean.valueOf(z);
    }

    public static void w(String str, String str2) {
        IDevice hostDevice = MuxStats.getHostDevice();
        if (!c.booleanValue() || hostDevice == null) {
            return;
        }
        hostDevice.outputLog(LogPriority.WARN, str, str2);
    }
}
