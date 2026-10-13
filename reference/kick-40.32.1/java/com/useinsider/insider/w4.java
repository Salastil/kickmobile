package com.useinsider.insider;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.service.notification.StatusBarNotification;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1;
import androidx.window.reflection.WindowExtensionsConstants;
import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.service.NotificationsService;
import io.ktor.sse.ServerSentEventKt;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.time.DurationKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class w4 {
    private static NotificationCompat.Builder f;
    private static String i;
    private static final ArrayList j;
    private static final ArrayList k;
    private static final ThreadLocal l;
    private static int m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Hashtable f442a = new Hashtable();
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private static final ExecutorService c = Executors.newSingleThreadExecutor();
    private static final Object d = new Object();
    static String e = "";
    private static String g = "";
    private static int h = 16;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f443a;

        static {
            int[] iArr = new int[l4.values().length];
            f443a = iArr;
            try {
                iArr[l4.STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f443a[l4.FLUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f443a[l4.GDPR_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f443a[l4.MOBILE_GDPR_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f443a[l4.MESSAGE_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f443a[l4.IDENTITY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f443a[l4.LOGGING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        l4 l4Var = l4.START;
        l4 l4Var2 = l4.IDENTITY;
        j = new ArrayList(Arrays.asList(l4Var, l4.STOP, l4.MESSAGE_CENTER, l4.LOGGING, l4Var2, l4.FLUSH));
        k = new ArrayList(Arrays.asList(l4Var, l4Var2));
        l = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: com.useinsider.insider.w4$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return w4.k();
            }
        });
        m = 0;
    }

    static boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    static long b() {
        return System.currentTimeMillis() / 1000;
    }

    static int c(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0f);
    }

    static String d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo.State state = connectivityManager.getNetworkInfo(1).getState();
        NetworkInfo.State state2 = NetworkInfo.State.CONNECTED;
        if (state == state2) {
            return "wifi";
        }
        return connectivityManager.getNetworkInfo(0).getState() == state2 ? "cellular" : "none";
    }

    static int e(Context context, String str) {
        int identifier = 0;
        try {
            Resources resources = context.getResources();
            String strK = k(context, str);
            if (strK != null) {
                str = strK;
            }
            identifier = resources.getIdentifier(str, "drawable", context.getPackageName());
            return identifier == 0 ? resources.getIdentifier(str, "mipmap", context.getPackageName()) : identifier;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return identifier;
        }
    }

    static boolean f(String str) {
        return str.matches("^\\+[1-9]\\d{1,14}$");
    }

    static JSONObject g(Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), c(entry.getValue()));
            }
            return jSONObject;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return jSONObject;
        }
    }

    private static int h(Context context) {
        int dimensionPixelSize;
        int i2 = 0;
        try {
            boolean zHasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
            int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier <= 0 || zHasPermanentMenuKey) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                try {
                    f3.b("web_view", "Navigation bar height value is updated with resource.", "{'navigation_bar_height': " + dimensionPixelSize + "}", "StaticUtils-getNavigationBarHeightFromResources");
                } catch (Exception e2) {
                    e = e2;
                    i2 = dimensionPixelSize;
                    Insider.Instance.putException(e);
                    return i2;
                }
            }
            if (dimensionPixelSize < 0) {
                return 0;
            }
            return dimensionPixelSize;
        } catch (Exception e3) {
            e = e3;
        }
    }

    static boolean i(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return str.matches("^[a-z0-9][a-z0-9_]*$");
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return false;
    }

    private static int j(Context context) {
        int dimensionPixelSize = 0;
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                f3.b("web_view", "Status bar height value is updated with resource.", "{'status_bar_height': " + dimensionPixelSize + "}", "StaticUtils-getStatusBarHeightFromResources");
            }
            return dimensionPixelSize < 0 ? (int) Math.ceil(24 * context.getResources().getDisplayMetrics().density) : dimensionPixelSize;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return dimensionPixelSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    static void l(Context context, String str) {
        try {
            if (context == null || str == null) {
                f3.b("common", "Set clipboard operation not done. Given parameters are not valid.", "{}", "StaticUtils-setClipboard");
            } else {
                ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static String m(String str) {
        try {
            return str.replaceAll("[^a-zA-Z0-9\\.\\-]+", "");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return str;
        }
    }

    static boolean n(Context context) {
        try {
            SharedPreferences sharedPreferencesE = h4.a().e(context, "InsiderCache");
            return sharedPreferencesE.contains("location_enabled") && sharedPreferencesE.getBoolean("location_enabled", false) && o(context);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
        return false;
    }

    static boolean o(Context context) {
        try {
            boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
            if (!z || Build.VERSION.SDK_INT < 29) {
                return z;
            }
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    static boolean p(Context context) {
        try {
            if (!r(context)) {
                return false;
            }
            SharedPreferences sharedPreferencesE = h4.a().e(context, "InsiderCache");
            if (sharedPreferencesE.contains("push_enabled")) {
                return sharedPreferencesE.getBoolean("push_enabled", false);
            }
            return true;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return true;
        }
    }

    static boolean r(Context context) {
        try {
            boolean zAreNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
            if (Build.VERSION.SDK_INT > 32) {
                return context.checkPermission("android.permission.POST_NOTIFICATIONS", Process.myPid(), Process.myUid()) == 0;
            }
            return zAreNotificationsEnabled;
        } catch (Exception unused) {
            return q(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Context context) {
        try {
            SharedPreferences sharedPreferencesE = h4.a().e(context, s4.INSIDER_CACHE.b());
            long jB = b() / 86400;
            Map<String, ?> all = sharedPreferencesE.getAll();
            SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
            int i2 = 0;
            for (String str : all.keySet()) {
                if (str.startsWith("ps_")) {
                    try {
                        int iIndexOf = str.indexOf("|");
                        if (iIndexOf <= 3) {
                            editorEdit.remove(str);
                        } else if (Long.parseLong(str.substring(3, iIndexOf)) < jB) {
                            editorEdit.remove(str);
                        }
                    } catch (Exception unused) {
                        editorEdit.remove(str);
                    }
                    i2++;
                }
            }
            if (i2 > 0) {
                editorEdit.apply();
                f3.b("push", "Cleaned up old push_session keys", new JSONObject().put("removed_count", i2), "StaticUtils-cleanupOldPushSessionKeys");
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void t(Context context) {
        try {
            String strM = m(l(h4.a().e(context, s4.INSIDER_CACHE.b()).getString(r4.INSIDER_ATTRIBUTES.b(), "{}")));
            if (strM.isEmpty()) {
                return;
            }
            g = strM;
            h4.a().e(context, s4.INSIDER.b()).edit().putString(r4.UDID.b(), g).apply();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static synchronized void u(Context context) {
        try {
            String strB = w3.SESSION_STOP.b();
            SharedPreferences sharedPreferencesE = h4.a().e(context, "InsiderQueue");
            Map<String, ?> all = sharedPreferencesE.getAll();
            if (!all.isEmpty()) {
                sharedPreferencesE.edit().clear().apply();
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        a(strB, new JSONObject((String) it.next().getValue()), context, true, l4.STOP);
                    } catch (Exception e2) {
                        Insider.Instance.putException(e2);
                    }
                }
            }
        } catch (Exception e3) {
            Insider.Instance.putException(e3);
        }
    }

    private static void v(Context context) {
        Bitmap bitmapB = k4.b(context);
        if (bitmapB != null) {
            f.setLargeIcon(bitmapB);
        }
    }

    private static void w(Context context) {
        int iA = k4.a(context);
        if (iA != 0) {
            f.setColor(iA);
        }
    }

    static void x(Context context) {
        try {
            h4.a().e(context, s4.INSIDER.b()).edit().putLong(r4.MOBILE_INSTALL_DATE.b(), b()).apply();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a(Activity activity, String str, InsiderEvent insiderEvent, boolean z) {
        try {
            Intent intent = new Intent(activity, (Class<?>) InsiderInappActivity.class);
            intent.putExtra(str, insiderEvent);
            intent.putExtra("keepActivity", z);
            activity.startActivity(intent);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static Typeface b(Context context, String str) {
        Typeface typeface;
        Hashtable hashtable = f442a;
        synchronized (hashtable) {
            if (!hashtable.containsKey(str)) {
                try {
                    hashtable.put(str, Typeface.createFromAsset(context.getAssets(), str));
                } catch (Exception e2) {
                    Insider.Instance.putException(e2);
                    return null;
                }
            }
            typeface = (Typeface) hashtable.get(str);
        }
        return typeface;
    }

    static int f(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    private static boolean q(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private static String k(Context context, String str) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
            if (identifier != 0) {
                return resources.getString(identifier);
            }
            return null;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    static void m(Context context, String str) {
        try {
            h4.a().e(context, s4.INSIDER.b()).edit().putString(r4.UDID.b(), str).apply();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
                if (obj instanceof Collection) {
                    return a((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return a(obj);
                }
                if (obj instanceof Map) {
                    return g((Map) obj);
                }
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                    if (obj.getClass().getName().startsWith("java.")) {
                        return obj.toString();
                    }
                    if (obj instanceof w) {
                        return g(((w) obj).a());
                    }
                    return null;
                }
                return obj;
            }
            return obj;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static String f(Context context) {
        try {
            String insiderID = Insider.Instance.getCurrentUser().getInsiderID();
            if (!h(insiderID)) {
                insiderID = h4.a().e(context, s4.INSIDER.b()).getString(r4.INSIDER_ID.b(), "");
            }
            return !h(insiderID) ? l(context) : insiderID;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static String i() {
        try {
            if (e.e == null) {
                return "16.0.7-nh";
            }
            return "16.0.7-nh-" + e.e;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static void n(String str) {
        try {
            i = str;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static JSONObject a(Context context, o4 o4Var, InsiderUser insiderUser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("insider_id", insiderUser.getInsiderID());
            jSONObject.put("udid", k(context));
            jSONObject.put(f.n, e.b);
            jSONObject.put("reason", o4Var.b());
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("app_version", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            concurrentHashMap.put("os_version", g());
            concurrentHashMap.put("push_enabled", Boolean.valueOf(p(context)));
            concurrentHashMap.put("location_enabled", Boolean.valueOf(n(context)));
            concurrentHashMap.put("battery", Integer.valueOf(c(context)));
            concurrentHashMap.put("connection", d(context));
            concurrentHashMap.put("sdk_version", i());
            jSONObject.put("device_info", g(concurrentHashMap));
            return jSONObject;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return jSONObject;
        }
    }

    static float d(Context context, String str) {
        try {
            Resources resources = context.getResources();
            return resources.getDimension(resources.getIdentifier(str, "dimen", context.getPackageName()));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0.0f;
        }
    }

    static String l(Context context) {
        String string;
        String strM = "";
        try {
            t(context);
            if (g.isEmpty()) {
                string = h4.a().e(context, s4.INSIDER.b()).getString(r4.UDID.b(), "");
            } else {
                string = g;
            }
            if (h(string)) {
                return string;
            }
            strM = m(string);
            m(context, strM);
            return strM;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return strM;
        }
    }

    private static boolean e(Map map) {
        try {
            return e((String) map.get(j4.TITLE.b())) || e((String) map.get(j4.MESSAGE.b()));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return true;
        }
    }

    static String k(Context context) {
        try {
            if (g.isEmpty()) {
                String strL = l(context);
                g = strL;
                if (strL.isEmpty()) {
                    String strH = h();
                    g = strH;
                    m(context, strH);
                    x(context);
                }
            }
            return g;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static String g() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static boolean m(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    return true;
                }
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
        return false;
    }

    static boolean i(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "raw", context.getPackageName()) != 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return true;
        }
    }

    static int b(View view) {
        int top = 0;
        try {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            Context context = view.getContext();
            top = rect.top - view.getTop();
            if (top <= view.getHeight() && top >= 0) {
                return top;
            }
            f3.b("web_view", "There was a problem calculating the navigation bar height.", "{'status_bar_height': " + top + "}", "StaticUtils-getStatusBarHeight");
            return j(context);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return top;
        }
    }

    static void d(Map map) {
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("source") && ((String) map.get("source")).equals("Insider") && !a(map) && map.containsKey("camp_id") && map.containsKey("camp_type") && map.containsKey("variant_id")) {
                Debugger.putLog(DebuggingTag.openLogRequestReceived, 4, String.valueOf(map));
                int i2 = Integer.parseInt((String) map.get("camp_id"));
                int i3 = Integer.parseInt((String) map.get("camp_type"));
                int i4 = Integer.parseInt((String) map.get("variant_id"));
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("camp_id", Integer.valueOf(i2));
                concurrentHashMap.put("camp_type", Integer.valueOf(i3));
                concurrentHashMap.put("variant_id", Integer.valueOf(i4));
                Insider insider = Insider.Instance;
                insider.putPushLog(concurrentHashMap);
                insider.tagEvent("push_session").addParameters(concurrentHashMap).build();
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static int g(Context context, String str) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, TypedValues.Custom.S_INT, context.getPackageName());
            if (identifier == 0) {
                return 0;
            }
            return resources.getInteger(identifier);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    static n4 e(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            return n4.GOOGLE;
        }
        return n4.OTHER;
    }

    static int h(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, WindowExtensionsConstants.LAYOUT_PACKAGE, context.getPackageName());
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    static boolean j(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    static JSONObject o(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static List e() {
        return Arrays.asList("mutable-content", "interactivePush", "category", "title", "insider_int_push", "channel", "notificationId", "message", "thread-id", "insider-test-push", "badge", "push_inapp", "enhanced_push_inapp", "inapp_test");
    }

    private static int f() {
        return ThreadLocalRandom.current().nextInt(0, 2147483646);
    }

    static String i(Context context) {
        try {
            String str = e.b;
            if (str != null && !str.equals("")) {
                return e.b;
            }
            return h4.a().e(context, s4.INSIDER.b()).getString(r4.PARTNER_NAME.b(), "");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static boolean e(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return true;
    }

    static boolean f(Map map) {
        try {
            return map.containsKey("source") && ((String) map.get("source")).equals("Insider");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    static String h() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, h);
    }

    static String j() {
        try {
            return i;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    static long g(Context context) {
        try {
            return h4.a().e(context, s4.INSIDER.b()).getLong(r4.MOBILE_INSTALL_DATE.b(), 0L);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0L;
        }
    }

    static int h(Map map) {
        if (map.get("notification_id") != null && !((String) map.get("notification_id")).trim().isEmpty()) {
            try {
                return Integer.parseInt((String) map.get("notification_id"));
            } catch (NumberFormatException unused) {
                return f();
            }
        }
        return f();
    }

    static JSONObject j(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    static int a(View view) {
        int i2 = 0;
        try {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            Context context = view.getContext();
            int iH = h(context);
            int bottom = view.getBottom() - rect.bottom;
            try {
                if (bottom <= f5.a(context, 180.0f) && bottom >= 0 && bottom >= iH) {
                    return bottom;
                }
                f3.b("web_view", "There was a problem calculating the navigation bar height.", "{'navigation_bar_height': " + bottom + "}", "StaticUtils-getNavigationBarHeight");
                int iH2 = h(context);
                if (iH2 < 0) {
                    return 0;
                }
                return iH2;
            } catch (Exception e2) {
                e = e2;
                i2 = bottom;
                Insider.Instance.putException(e);
                return i2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    static JSONObject k(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", f.f).put("repeats", 1).put("parameters", new JSONArray());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("relationship", q2.EQUAL.b()).put("events", new JSONArray().put(jSONObject2));
            JSONObject jSONObjectPut = jSONObject.put("content", new JSONObject(str));
            int i2 = m - 1;
            m = i2;
            jSONObjectPut.put("inapp_id", i2).put("priority", 1).put("variant_id", 0).put("delay", 0).put("show_type", "session").put("condition", jSONObject3).put("frequency", 0).put("source", "regular");
            return jSONObject;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    static boolean g(String str) {
        return str != null && Base64.encodeToString("__insider_security_pref_key_set__".getBytes(), 2).equals(str);
    }

    private static void b(JSONObject jSONObject, Context context) {
        if (context != null) {
            try {
                h4.a().e(context, s4.INSIDER.b()).edit().putString("saved_mobile_gdpr_consent", jSONObject.toString()).apply();
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
    }

    static String l(String str) {
        try {
            for (String str2 : str.replaceAll("^\\{|\\}$", "").split(", ")) {
                if (str2.startsWith("udid=")) {
                    return str2.replace("udid=", "");
                }
            }
            return "";
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static boolean h(String str) {
        if (str != null) {
            try {
                return str.matches("^[a-zA-Z0-9][a-zA-Z0-9-\\.]*$");
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return false;
    }

    static Bitmap b(String str) {
        for (int i2 = 1; i2 <= 3; i2++) {
            try {
                f3.b("push", "Attempting to download push image.", "{ 'imageAttempt': '" + i2 + "' }", "StaticUtils-getBitmapFromURL");
                return a(str);
            } catch (Exception e2) {
                if (i2 == 3) {
                    f3.a("push", "Push image receive exception.", "{ 'url': '" + str + "', 'error': '" + e2.getMessage() + "' }", "StaticUtils-getBitmapFromURL");
                    Insider.Instance.putException(e2);
                }
            }
        }
        return null;
    }

    static boolean c(String str) {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2).matcher(str).find();
    }

    static String d() {
        try {
            return (Locale.getDefault() == null || Locale.getDefault().getLanguage() == null) ? "" : Locale.getDefault().getLanguage();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static String c() {
        try {
            return Build.MODEL;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static int c(Context context, String str) {
        try {
            Resources resources = context.getResources();
            String strK = k(context, str);
            if (strK != null) {
                str = strK;
            }
            return resources.getIdentifier(str, "color", context.getPackageName());
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    static boolean d(String str) {
        String str2;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    boolean zMatches = str.matches("^[a-z][0-9a-z_]*$");
                    if (!zMatches) {
                        Debugger.putLog(DebuggingTag.isNameValid, 5, str);
                        f3.c("common", String.format("Validation failed: '%s' is not a valid name for event or attribute.", str), String.format("{ 'status': 'failed', 'reason': 'invalid_name_format', 'provided_name': '%s' }", str), "InsiderCore-isNameValid");
                    }
                    return zMatches;
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
                return false;
            }
        }
        Debugger.a(DebuggingTag.isNameValidEmpty, 5);
        if (str == null) {
            str2 = AbstractJsonLexerKt.NULL;
        } else {
            str2 = "empty";
        }
        f3.c("common", "Validation failed: Event or attribute name is empty.", String.format("{ 'status': 'failed', 'reason': 'empty_or_null_name', 'provided_name': '%s' }", str2), "InsiderCore-isNameValid");
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    private static void c(Map map) {
        Bitmap bitmapB;
        if (map.containsKey("image_url") && map.get("image_url") != null) {
            bitmapB = b((String) map.get("image_url"));
        } else if (map.containsKey("insider_int_push")) {
            ArrayList arrayListC = c4.a((String) map.get("insider_int_push")).c();
            if (arrayListC.isEmpty() || !((ConcurrentHashMap) arrayListC.get(0)).containsKey("image_url")) {
                bitmapB = null;
            } else {
                bitmapB = b((String) ((ConcurrentHashMap) arrayListC.get(0)).get("image_url"));
            }
        } else {
            bitmapB = null;
        }
        if (bitmapB != null) {
            NotificationCompat.BigPictureStyle summaryText = new NotificationCompat.BigPictureStyle().setBigContentTitle((CharSequence) map.get("title")).setSummaryText((CharSequence) map.get("message"));
            summaryText.bigPicture(bitmapB).bigLargeIcon((Bitmap) null);
            f3.a("push", "Rich Push image has been set.", "{ 'url': '" + ((String) map.get("image_url")) + "' }", "StaticUtils-getImageForPush");
            f.setLargeIcon(bitmapB).setStyle(summaryText);
            return;
        }
        f.setStyle(new NotificationCompat.BigTextStyle().bigText((CharSequence) map.get("message")));
    }

    static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                if (bundle.keySet() != null) {
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, c(bundle.get(str)));
                    }
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return jSONObject;
    }

    private static void b(String str, SharedPreferences sharedPreferences) {
        try {
            sharedPreferences.edit().putBoolean(str, true).apply();
            f3.b("push", "push_session allowed (first time)", new JSONObject().put("key", str), "StaticUtils-markKeyAsSeen");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static JSONArray a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            try {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    jSONArray.put(c(it.next()));
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return jSONArray;
    }

    static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        try {
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray.put(c(Array.get(obj, i2)));
            }
            return jSONArray;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return jSONArray;
        }
    }

    private static List b(SharedPreferences sharedPreferences, long j2) {
        ArrayList arrayList = new ArrayList();
        String str = "ps_" + j2;
        for (String str2 : sharedPreferences.getAll().keySet()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void b(final Context context) {
        b.execute(new Runnable() { // from class: com.useinsider.insider.w4$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                w4.s(context);
            }
        });
    }

    public static String[] b(Object[] objArr) {
        try {
            if (objArr == null) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    arrayList.add((String) obj);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return new String[0];
        }
    }

    private static String a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:139:0x0287  */
    static com.useinsider.insider.a a(String str, JSONObject jSONObject, Context context, boolean z, l4 l4Var) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        String strA;
        int iA;
        int i3;
        HttpURLConnection httpURLConnection;
        int i4;
        String str6;
        int i5;
        String str7;
        Object obj;
        y3 y3VarJ;
        String strA2;
        JSONObject jSONObjectA = jSONObject;
        String str8 = "";
        String strValueOf = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        try {
            try {
                URL url = new URL(str);
                if (str.startsWith("https")) {
                    try {
                        httpURLConnection = (HttpsURLConnection) url.openConnection();
                    } catch (Exception e2) {
                        e = e2;
                        i3 = -1;
                        Insider.Instance.putException(e);
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    } catch (Throwable th) {
                        th = th;
                        i3 = -1;
                        Insider.Instance.putException(new Exception(th));
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (l4Var == l4.RECOMMENDATION) {
                    i5 = 2000;
                    i4 = 2000;
                    str6 = "GET";
                } else {
                    i4 = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
                    str6 = "POST";
                    i5 = 10000;
                }
                if (l4Var == l4.WIZARD && (y3VarJ = m0.f().j()) != null && (strA2 = y3VarJ.a()) != null && !strA2.isEmpty()) {
                    httpURLConnection.setRequestProperty("Authorization", "Bearer " + strA2);
                }
                if (!j.contains(l4Var)) {
                    str7 = "";
                    obj = "GET";
                } else {
                    try {
                        if (jSONObjectA.has("q-timestamp")) {
                            strValueOf = jSONObjectA.getString("q-timestamp");
                            try {
                                jSONObjectA.remove("q-timestamp");
                            } catch (ConnectException unused) {
                                context = context;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (SocketTimeoutException unused2) {
                                context = context;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (UnknownHostException unused3) {
                                context = context;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (SSLHandshakeException unused4) {
                                context = context;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            }
                        } else {
                            jSONObjectA = p0.a(strValueOf, jSONObjectA);
                        }
                        try {
                            str7 = "";
                            try {
                                try {
                                    obj = "GET";
                                    Debugger.b(a(l4Var), 4, new JSONObject(jSONObjectA.toString()).put(HlsSegmentFormat.TS, strValueOf));
                                    if (l4Var == l4.START) {
                                        f3.b("common", "Start request has been encrypted.", "{'body': '" + jSONObjectA + "', 'ts': '" + strValueOf + "'}", "StaticUtils-startRequest");
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str8 = str7;
                                    i3 = -1;
                                    Insider.Instance.putException(e);
                                    strA = str8;
                                    iA = i3;
                                    return new com.useinsider.insider.a(strA, iA);
                                } catch (Throwable th2) {
                                    th = th2;
                                    str8 = str7;
                                    i3 = -1;
                                    Insider.Instance.putException(new Exception(th));
                                    strA = str8;
                                    iA = i3;
                                    return new com.useinsider.insider.a(strA, iA);
                                }
                            } catch (ConnectException unused5) {
                                context = context;
                                str8 = str7;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (SocketTimeoutException unused6) {
                                context = context;
                                str8 = str7;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (UnknownHostException unused7) {
                                context = context;
                                str8 = str7;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            } catch (SSLHandshakeException unused8) {
                                context = context;
                                str8 = str7;
                                i2 = -1;
                                strA = str8;
                                iA = i2;
                                if (z) {
                                    iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                }
                                return new com.useinsider.insider.a(strA, iA);
                            }
                        } catch (ConnectException unused9) {
                            str7 = "";
                        } catch (SocketTimeoutException unused10) {
                            str7 = "";
                        } catch (UnknownHostException unused11) {
                            str7 = "";
                        } catch (SSLHandshakeException unused12) {
                            str7 = "";
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i3 = -1;
                        Insider.Instance.putException(e);
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    } catch (Throwable th3) {
                        th = th3;
                        i3 = -1;
                        Insider.Instance.putException(new Exception(th));
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    }
                }
                try {
                    try {
                        httpURLConnection.setRequestProperty(HlsSegmentFormat.TS, strValueOf);
                        httpURLConnection.setReadTimeout(i4);
                        httpURLConnection.setConnectTimeout(i5);
                        httpURLConnection.setRequestMethod(str6);
                        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        httpURLConnection.setRequestProperty(HttpHeaders.X_REQUESTED_WITH, e.b);
                        if (!str6.equals(obj)) {
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
                            bufferedWriter.write(jSONObjectA.toString());
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();
                        }
                        iA = httpURLConnection.getResponseCode();
                        try {
                            try {
                                boolean zA = a(iA);
                                if (zA) {
                                    try {
                                        strA = a(httpURLConnection.getInputStream());
                                        try {
                                            try {
                                                if (k.contains(l4Var)) {
                                                    String headerField = httpURLConnection.getHeaderField(HlsSegmentFormat.TS);
                                                    if (l4Var == l4.START) {
                                                        f3.b("common", "Start response will be decrypted.", "{'body': '" + strA + "', 'ts': '" + headerField + "'}", "StaticUtils-startRequest");
                                                    }
                                                    strA = p0.a(strA, headerField);
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                i3 = iA;
                                                str8 = strA;
                                                Insider.Instance.putException(e);
                                                strA = str8;
                                                iA = i3;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                i3 = iA;
                                                str8 = strA;
                                                Insider.Instance.putException(new Exception(th));
                                                strA = str8;
                                                iA = i3;
                                            }
                                        } catch (ConnectException unused13) {
                                            context = context;
                                            i2 = iA;
                                            str8 = strA;
                                            strA = str8;
                                            iA = i2;
                                            if (z) {
                                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                            }
                                            return new com.useinsider.insider.a(strA, iA);
                                        } catch (SocketTimeoutException unused14) {
                                            context = context;
                                            i2 = iA;
                                            str8 = strA;
                                            strA = str8;
                                            iA = i2;
                                            if (z) {
                                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                            }
                                            return new com.useinsider.insider.a(strA, iA);
                                        } catch (UnknownHostException unused15) {
                                            context = context;
                                            i2 = iA;
                                            str8 = strA;
                                            strA = str8;
                                            iA = i2;
                                            if (z) {
                                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                            }
                                            return new com.useinsider.insider.a(strA, iA);
                                        } catch (SSLHandshakeException unused16) {
                                            context = context;
                                            i2 = iA;
                                            str8 = strA;
                                            strA = str8;
                                            iA = i2;
                                            if (z) {
                                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                            }
                                            return new com.useinsider.insider.a(strA, iA);
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        i3 = iA;
                                        str8 = str7;
                                        Insider.Instance.putException(e);
                                        strA = str8;
                                        iA = i3;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i3 = iA;
                                        str8 = str7;
                                        Insider.Instance.putException(new Exception(th));
                                        strA = str8;
                                        iA = i3;
                                    }
                                } else {
                                    strA = str7;
                                }
                                httpURLConnection.disconnect();
                                if ((!zA || strA.equals(str7)) && l4Var == l4.IDENTITY) {
                                    f3.b("common", "Request identity failed with response code: " + iA + ", insider_id: " + strA, "{}", "StaticUtils-startRequest");
                                }
                                if (!zA && z) {
                                    context = context;
                                    try {
                                        iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                    } catch (ConnectException | SocketTimeoutException | UnknownHostException | SSLHandshakeException unused17) {
                                        i2 = iA;
                                        str8 = strA;
                                        strA = str8;
                                        iA = i2;
                                        if (z) {
                                            iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                                        }
                                    }
                                }
                            } catch (Exception e7) {
                                e = e7;
                                str8 = str7;
                                i3 = iA;
                            } catch (Throwable th6) {
                                th = th6;
                                str8 = str7;
                                i3 = iA;
                            }
                        } catch (ConnectException unused18) {
                            str8 = str7;
                            i2 = iA;
                            strA = str8;
                            iA = i2;
                            if (z) {
                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                            }
                            return new com.useinsider.insider.a(strA, iA);
                        } catch (SocketTimeoutException unused19) {
                            str8 = str7;
                            i2 = iA;
                            strA = str8;
                            iA = i2;
                            if (z) {
                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                            }
                            return new com.useinsider.insider.a(strA, iA);
                        } catch (UnknownHostException unused20) {
                            str8 = str7;
                            i2 = iA;
                            strA = str8;
                            iA = i2;
                            if (z) {
                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                            }
                            return new com.useinsider.insider.a(strA, iA);
                        } catch (SSLHandshakeException unused21) {
                            str8 = str7;
                            i2 = iA;
                            strA = str8;
                            iA = i2;
                            if (z) {
                                iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                            }
                            return new com.useinsider.insider.a(strA, iA);
                        }
                    } catch (Exception e8) {
                        e = e8;
                        str8 = str7;
                        i3 = -1;
                        Insider.Instance.putException(e);
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    } catch (Throwable th7) {
                        th = th7;
                        str8 = str7;
                        i3 = -1;
                        Insider.Instance.putException(new Exception(th));
                        strA = str8;
                        iA = i3;
                        return new com.useinsider.insider.a(strA, iA);
                    }
                } catch (ConnectException unused22) {
                    str5 = str7;
                    str8 = str5;
                    i2 = -1;
                    strA = str8;
                    iA = i2;
                    if (z) {
                        iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                    }
                    return new com.useinsider.insider.a(strA, iA);
                } catch (SocketTimeoutException unused23) {
                    str4 = str7;
                    str8 = str4;
                    i2 = -1;
                    strA = str8;
                    iA = i2;
                    if (z) {
                        iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                    }
                    return new com.useinsider.insider.a(strA, iA);
                } catch (UnknownHostException unused24) {
                    str3 = str7;
                    str8 = str3;
                    i2 = -1;
                    strA = str8;
                    iA = i2;
                    if (z) {
                        iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                    }
                    return new com.useinsider.insider.a(strA, iA);
                } catch (SSLHandshakeException unused25) {
                    str2 = str7;
                    str8 = str2;
                    i2 = -1;
                    strA = str8;
                    iA = i2;
                    if (z) {
                        iA = a(iA, l4Var, jSONObjectA, context, strValueOf);
                    }
                    return new com.useinsider.insider.a(strA, iA);
                }
            } catch (Exception e9) {
                e = e9;
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (ConnectException unused26) {
            str5 = "";
        } catch (SocketTimeoutException unused27) {
            str4 = "";
        } catch (UnknownHostException unused28) {
            str3 = "";
        } catch (SSLHandshakeException unused29) {
            str2 = "";
        }
        return new com.useinsider.insider.a(strA, iA);
    }

    static void b(Intent intent, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectA = a((Intent) intent.clone(), jSONObject);
            if (jSONObjectA.has("source")) {
                JSONObject jSONObject2 = new JSONObject();
                InsiderCallbackType insiderCallbackType = InsiderCallbackType.NOTIFICATION_OPEN;
                jSONObject2.put("type", insiderCallbackType.ordinal());
                jSONObject2.put("data", jSONObjectA);
                Insider.Instance.performInsiderCallback(jSONObject2, insiderCallbackType);
                f3.b("push", "Notification opened action has been sent.", jSONObject2, "StaticUtils-sendNotificationOpenedAction");
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static String b(String[] strArr) {
        try {
            return "[\"" + UByte$$ExternalSyntheticBackport0.m((CharSequence) "\",\"", (CharSequence[]) strArr) + "\"]";
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static List b(Map map) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry entry : map.entrySet()) {
                HashMap map2 = new HashMap();
                map2.put("name", ((String) entry.getKey()).replaceFirst("^c_", ""));
                map2.put("value", entry.getValue());
                map2.put("type", b(entry.getValue()));
                arrayList.add(map2);
            }
            return arrayList;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return arrayList;
        }
    }

    private static String b(Object obj) {
        if (obj instanceof String) {
            return z3.f454a;
        }
        if (!(obj instanceof Double) && !(obj instanceof Integer)) {
            if (obj instanceof Boolean) {
                return z3.b;
            }
            if (obj instanceof Date) {
                return z3.e;
            }
            return obj instanceof String[] ? z3.d : "unknown";
        }
        return z3.c;
    }

    private static int a(int i2, l4 l4Var, JSONObject jSONObject, Context context, String str) {
        try {
            int i3 = a.f443a[l4Var.ordinal()];
            if (i3 == 1) {
                a(l4Var, jSONObject, context, str);
                return i2;
            }
            if (i3 == 2) {
                if (e.x == p4.SESSION_STOP_REQUEST_REASON_FLUSH) {
                    return i2;
                }
                a(l4Var, jSONObject, context, str);
                return 1000;
            }
            if (i3 == 3) {
                a(jSONObject, context);
                return i2;
            }
            if (i3 != 4) {
                return i2;
            }
            b(jSONObject, context);
            return i2;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return i2;
        }
    }

    private static DebuggingTag a(l4 l4Var) {
        int i2 = a.f443a[l4Var.ordinal()];
        if (i2 == 1) {
            return DebuggingTag.sessionStopRequestEncrypted;
        }
        if (i2 == 2) {
            return DebuggingTag.flushingDataEncrypted;
        }
        if (i2 == 5) {
            return DebuggingTag.messageCenterRequestEncrypted;
        }
        if (i2 == 6) {
            return DebuggingTag.identityRequestEncrypted;
        }
        if (i2 != 7) {
            return DebuggingTag.requestEncrypted;
        }
        return DebuggingTag.logSystemRequestEncrypted;
    }

    private static void a(JSONObject jSONObject, Context context) {
        if (context != null) {
            try {
                h4.a().e(context, s4.INSIDER.b()).edit().putString("saved_gdpr_consent", jSONObject.toString()).apply();
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
    }

    static JSONObject a(Context context) {
        synchronized (d) {
            try {
                if (context == null) {
                    return null;
                }
                try {
                    SharedPreferences sharedPreferencesE = h4.a().e(context, s4.INSIDER.b());
                    String strB = r4.STORED_LATEST_SESSION_DATA.b();
                    String string = sharedPreferencesE.getString(strB, null);
                    if (string != null && string.length() != 0) {
                        sharedPreferencesE.edit().remove(strB).commit();
                        return new JSONObject(string);
                    }
                    return null;
                } catch (Exception e2) {
                    Insider.Instance.putException(e2);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void a(l4 l4Var, JSONObject jSONObject, Context context, String str) {
        if (context != null) {
            try {
                jSONObject.put("q-timestamp", str);
                h4.a().e(context, "InsiderQueue").edit().putString("sessionQueueSize_" + str, jSONObject.toString()).apply();
                Debugger.putLog(DebuggingTag.requestAddedToQueue, 4, l4Var.toString());
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
    }

    static int a(long j2, long j3) {
        int i2;
        long j4 = j3 - j2;
        int i3 = 0;
        try {
            long j5 = j4 - ((long) (((int) (j4 / DurationKt.MILLIS_IN_HOUR)) * 3600000));
            i2 = ((int) j5) / DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS;
            try {
                i3 = ((int) (j5 - ((long) (DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS * i2)))) / 1000;
            } catch (Exception e2) {
                e = e2;
                Insider.Instance.putException(e);
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 0;
        }
        return i3 + (i2 * 60);
    }

    static Boolean a(Context context, String str, boolean z) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "bool", context.getPackageName());
            if (identifier != 0) {
                return Boolean.valueOf(resources.getBoolean(identifier));
            }
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return Boolean.valueOf(z);
        }
    }

    static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    static int a(Context context, int i2) {
        try {
            return context.getColor(i2);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    static Uri a(Context context, String str) {
        Uri uri = null;
        try {
            RingtoneManager ringtoneManager = new RingtoneManager(context);
            ringtoneManager.setType(2);
            Cursor cursor = ringtoneManager.getCursor();
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                String string2 = cursor.getString(2);
                if (cursor.getString(1).toLowerCase().equals(str)) {
                    uri = Uri.parse(string2 + DomExceptionUtils.SEPARATOR + string);
                }
            }
            return uri;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    private static Bitmap a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnection.disconnect();
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection.disconnect();
                throw th3;
            }
        }
        httpURLConnection.disconnect();
        throw new IOException("HTTP error code: " + responseCode);
    }

    static void a(Context context, Map map, boolean z) {
        String str;
        String str2;
        Notification notification;
        int i2;
        try {
            boolean zP = p(context);
            boolean zE = e(map);
            map.put("received_at", String.valueOf(b()));
            if (map.containsKey("push_buttons") && map.get("push_buttons") != null) {
                try {
                    map.put("buttons", new JSONArray((String) map.get("push_buttons")).toString());
                } catch (JSONException e2) {
                    Insider.Instance.putException(e2);
                }
            }
            if (zP && !zE) {
                f3.b("push", "Push received.", g(map), "StaticUtils-handleNotificationCommon");
                Debugger.b(DebuggingTag.pushReceived, 4, g(map));
                SharedPreferences sharedPreferencesE = h4.a().e(context, "InsiderCache");
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY);
                if (map.containsKey("channel")) {
                    String string = new JSONObject((String) map.get("channel")).getString("channel_name");
                    str = "ins_" + string.toLowerCase(Locale.ROOT).replace(ServerSentEventKt.SPACE, "_");
                    str2 = string;
                } else {
                    str = "";
                    str2 = str;
                }
                if (map.containsKey("test_contents") && m(context)) {
                    return;
                }
                if (map.containsKey("source") && ((String) map.get("source")).equals("Insider")) {
                    a(context, sharedPreferencesE, map, z);
                    if (a(map)) {
                        return;
                    }
                    int iH = h(map);
                    notificationManager.cancel(iH);
                    Intent intentA = a(context, map);
                    intentA.putExtra("notification_id", iH);
                    f = new NotificationCompat.Builder(context, "");
                    c(map);
                    v(context);
                    a(map, intentA);
                    int iA = c4.a(context);
                    a(context, map, intentA, iH, iA);
                    w(context);
                    if (map.containsKey("channel") && Build.VERSION.SDK_INT >= 26) {
                        k4.a(context, f, notificationManager, (String) map.get("channel"));
                    }
                    if (!str.isEmpty()) {
                        f.setGroup(str);
                    }
                    Notification notificationBuild = f.build();
                    if (map.containsKey("insider_int_push")) {
                        notification = notificationBuild;
                        i2 = iH;
                        a(context, map, notification, i2, intentA, iA);
                    } else {
                        notification = notificationBuild;
                        i2 = iH;
                    }
                    a(str, str2, notificationManager, context);
                    notificationManager.notify(i2, notification);
                    return;
                }
                if (!map.containsKey("channel") || Build.VERSION.SDK_INT < 26) {
                    return;
                }
                k4.a(context, null, notificationManager, (String) map.get("channel"));
                return;
            }
            f3.b("push", "Push message rendering discarded.", new JSONObject().put("push_content", g(map)).put("is_empty_push", zE).put("is_push_enabled_in_app_settings", zP), "StaticUtils-handleNotificationCommon");
        } catch (Exception e3) {
            Insider.Instance.putException(e3);
        }
    }

    private static void a(String str, String str2, NotificationManager notificationManager, Context context) {
        try {
            if (!str.isEmpty() && !str2.isEmpty()) {
                boolean z = false;
                int i2 = 0;
                for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                    if (String.valueOf(statusBarNotification.getNotification().getGroup()).equals(str)) {
                        i2++;
                        z = true;
                    }
                }
                if (z && i2 == 1) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "");
                    builder.setSmallIcon(c4.a(context)).setGroup(str).setChannelId(str2).setAutoCancel(true).setGroupSummary(true);
                    notificationManager.notify(f() * 10, builder.build());
                }
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a(Context context, RemoteMessage remoteMessage, boolean z) {
        if (remoteMessage == null) {
            return;
        }
        try {
            a(context, remoteMessage.getData(), z);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static boolean a(Map map) {
        return map.containsKey("deliver_silently") && ((String) map.get("deliver_silently")).equals("true");
    }

    private static void a(Context context, SharedPreferences sharedPreferences, Map map, boolean z) {
        try {
            if (map.containsKey("camp_id") && map.containsKey("camp_type") && map.containsKey("variant_id")) {
                String string = e.b;
                if (string == null || string.length() == 0) {
                    string = sharedPreferences.getString(f.n, "");
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("udid", k(context));
                jSONObject.put("insider_id", h4.a().e(context, s4.INSIDER.b()).getString(r4.INSIDER_ID.b(), ""));
                jSONObject.put(f.n, string);
                jSONObject.put("camp_id", Integer.parseInt((String) map.get("camp_id")));
                jSONObject.put("camp_type", Integer.parseInt((String) map.get("camp_type")));
                jSONObject.put("variant_id", Integer.parseInt((String) map.get("variant_id")));
                jSONObject.put("timestamp", b());
                jSONObject.put("is_amplified", z);
                jSONObject.put("insider_id", Insider.Instance.getCurrentUser().getInsiderID());
                Debugger.putLog(DebuggingTag.assurance, 4, String.valueOf(jSONObject));
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static JSONObject a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!h(str)) {
                str = str2;
            }
            jSONObject.put("insider_id", str);
            jSONObject.put("udid", str2);
            jSONObject.put("device_language", str3);
            return jSONObject;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return jSONObject;
        }
    }

    private static void a(Map map, Intent intent) {
        if (map.containsKey(f.i)) {
            String str = f.i;
            intent.putExtra(str, (String) map.get(str));
        } else if (map.containsKey(f.j)) {
            String str2 = f.j;
            intent.putExtra(str2, (String) map.get(str2));
        }
    }

    private static void a(Context context, Map map, Intent intent, int i2, int i3) {
        if (map.containsKey("insider_int_push")) {
            intent.putExtra("notificationId", i2);
            f.setDeleteIntent(c4.b(context, ((String) map.get("camp_id")) + i2));
        }
        PendingIntent activity = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 201326592);
        if (map.containsKey("sound")) {
            f.setSound(k4.a(context, (String) map.get("sound"))).setDefaults(6);
        } else {
            f.setDefaults(7);
        }
        f.setSmallIcon(i3).setContentTitle((CharSequence) map.get("title")).setContentText((CharSequence) map.get("message")).setTicker((CharSequence) map.get("message")).setContentIntent(activity).setAutoCancel(true);
        f.setPriority(k4.c(context));
        if (map.containsKey("buttons")) {
            try {
                JSONArray jSONArray = new JSONArray((String) map.get("buttons"));
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    a(context, f, jSONArray.getJSONObject(i4), i2, map);
                }
            } catch (JSONException e2) {
                Insider.Instance.putException(e2);
            }
        }
    }

    private static void a(Context context, NotificationCompat.Builder builder, JSONObject jSONObject, int i2, Map map) {
        try {
            int i3 = jSONObject.getInt("id");
            String string = jSONObject.getString("text");
            JSONArray jSONArray = jSONObject.getJSONArray("deep_links");
            Intent intent = new Intent(context, (Class<?>) InsiderActivity.class);
            intent.putExtra("notificationId", i2);
            intent.putExtra("buttonId", i3);
            intent.putExtra("buttonText", string);
            for (Map.Entry entry : map.entrySet()) {
                if (!((String) entry.getKey()).equals("image_url") && !((String) entry.getKey()).equals("buttons")) {
                    intent.putExtra((String) entry.getKey(), (String) entry.getValue());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                jSONObject2.put(jSONObject3.getString("key"), jSONObject3.get("value"));
            }
            intent.putExtra(f.m, String.valueOf(jSONObject2));
            builder.addAction(new NotificationCompat.Action.Builder(0, string, PendingIntent.getActivity(context, i2 + i3, intent, 201326592)).build());
        } catch (JSONException e2) {
            Insider.Instance.putException(e2);
        }
    }

    static Intent a(Context context, Map map) {
        Intent intent = new Intent(context, (Class<?>) InsiderActivity.class);
        List listAsList = Arrays.asList(Constants.MessagePayloadKeys.FROM, Constants.MessagePayloadKeys.COLLAPSE_KEY, "image_url", "buttons");
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj != null && str != null && !listAsList.contains(str)) {
                intent.putExtra(str, String.valueOf(obj));
            }
        }
        return intent;
    }

    static int a(Intent intent) {
        if (intent == null) {
            return 0;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return 0;
            }
            if (extras.containsKey("notification_id")) {
                Object obj = extras.get("notification_id");
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
            }
            if (extras.containsKey("notificationId")) {
                Object obj2 = extras.get("notificationId");
                if (obj2 instanceof Integer) {
                    return ((Integer) obj2).intValue();
                }
                if (obj2 instanceof String) {
                    return Integer.parseInt((String) obj2);
                }
            }
            return 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public static boolean a(Context context, Intent intent) {
        try {
            long jB = b() / 86400;
            String strA = a(jB, intent);
            SharedPreferences sharedPreferencesE = h4.a().e(context, s4.INSIDER_CACHE.b());
            if (a(strA, sharedPreferencesE)) {
                return true;
            }
            a(sharedPreferencesE, jB);
            b(strA, sharedPreferencesE);
            return false;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private static boolean a(String str, SharedPreferences sharedPreferences) {
        try {
            if (!sharedPreferences.contains(str)) {
                return false;
            }
            f3.b("push", "push_session skipped (duplicate detected)", new JSONObject().put("key", str), "StaticUtils-isKeySeenInDisk");
            return true;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private static void a(SharedPreferences sharedPreferences, long j2) {
        try {
            List listB = b(sharedPreferences, j2);
            if (listB.size() >= 20) {
                String str = (String) listB.get(0);
                sharedPreferences.edit().remove(str).apply();
                f3.b("push", "Removed oldest push_session key (max 20 limit)", new JSONObject().put("removed_key", str), "StaticUtils-enforceKeyLimit");
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static String a(long j2, Intent intent) {
        try {
            int iA = a(intent);
            String stringExtra = intent.getStringExtra("camp_id");
            String stringExtra2 = intent.getStringExtra("variant_id");
            String stringExtra3 = intent.getStringExtra("camp_type");
            String stringExtra4 = intent.getStringExtra("sent_at");
            if (iA <= 0) {
                StringBuilder sb = new StringBuilder();
                String str = "";
                sb.append(stringExtra == null ? "" : stringExtra);
                sb.append("|");
                sb.append(stringExtra3 == null ? "" : stringExtra3);
                sb.append("|");
                sb.append(stringExtra2 == null ? "" : stringExtra2);
                sb.append("|");
                if (stringExtra4 != null) {
                    str = stringExtra4;
                }
                sb.append(str);
                String string = sb.toString();
                iA = string.hashCode();
                f3.b("push", "Notification ID not found, using deterministic ID", new JSONObject().put("basis", string).put("nid", iA), "StaticUtils-buildUniqueKeyWithDay");
            }
            return "ps_" + j2 + "|nid=" + iA + "|camp=" + stringExtra + "|type=" + stringExtra3 + "|var=" + stringExtra2 + "|sent=" + stringExtra4;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "ps_" + j2 + "|fallback=" + System.currentTimeMillis();
        }
    }

    private static void a(Context context, Map map, Notification notification, int i2, Intent intent, int i3) {
        boolean zA;
        b4 b4VarA = c4.a((String) map.get("insider_int_push"));
        a4.a(context, b4VarA, (String) map.get("camp_id"), i2);
        if (b4VarA.c().size() > 0) {
            intent.putExtra("interactivePush", b4VarA);
            if (b4VarA.b() != 2) {
                zA = a4.b(context, notification, intent, i3);
            } else {
                intent.putExtra("interactiveType", 2);
                zA = a4.a(context, notification, intent, i3);
            }
        } else {
            zA = false;
        }
        if (zA) {
            return;
        }
        context.sendBroadcast(c4.a(context, ((String) map.get("camp_id")) + i2));
    }

    static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return ((SimpleDateFormat) l.get()).format(date);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    public static Number[] a(Object[] objArr) {
        try {
            if (objArr == null) {
                return new Number[0];
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                if (obj instanceof Number) {
                    double dDoubleValue = ((Number) obj).doubleValue();
                    if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue)) {
                        arrayList.add((Number) obj);
                    }
                }
            }
            return (Number[]) arrayList.toArray(new Number[0]);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return new Number[0];
        }
    }

    static void a(InsiderUser insiderUser, String str, n4 n4Var) {
        if (str == null) {
            return;
        }
        try {
            String strReplace = str.replace(ServerSentEventKt.SPACE, "");
            if (strReplace != "" && strReplace.length() >= 3) {
                HashMap map = new HashMap();
                map.put("provider", n4Var != null ? n4Var.b() : null);
                map.put("token", str);
                Debugger.a(DebuggingTag.getPushToken, 4, map);
                if (str.equals("BLACKLISTED")) {
                    return;
                }
                insiderUser.setPushToken(str);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static JSONObject a(Intent intent, JSONObject jSONObject) {
        try {
            Iterator it = e().iterator();
            while (it.hasNext()) {
                intent.removeExtra((String) it.next());
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    if (str != null && extras.get(str) != null && str.equals(f.k)) {
                        jSONObject = new JSONObject((String) extras.get(str));
                    }
                }
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("source");
                arrayList.add("buttonId");
                arrayList.add("buttonText");
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && next.length() > 0 && !arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                }
                Iterator<String> itKeys2 = a(intent.getExtras()).keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && next2.length() > 0 && !arrayList.contains(next2)) {
                        intent.removeExtra(next2);
                    }
                }
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
        JSONObject jSONObjectA = a(intent.getExtras());
        if (jSONObject != null) {
            try {
                if (jSONObject.has("button_id") && !jSONObjectA.has("button_id")) {
                    jSONObjectA.put("button_id", jSONObject.get("button_id"));
                }
                if (jSONObject.has("button_text") && !jSONObjectA.has("button_text")) {
                    jSONObjectA.put("button_text", jSONObject.get("button_text"));
                }
            } catch (JSONException e3) {
                Insider.Instance.putException(e3);
            }
        }
        return jSONObjectA;
    }

    static String a(String[] strArr) {
        try {
            return UByte$$ExternalSyntheticBackport0.m((CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence[]) strArr);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    static String[] a(JSONArray jSONArray) {
        String[] strArr = null;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = jSONArray.getString(i2);
                }
                return strArr;
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return strArr;
    }

    static HashMap a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    static JSONObject a(String str, String str2, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("key", str2);
            jSONObject.put("value", obj);
            return jSONObject;
        } catch (JSONException e2) {
            Insider.Instance.putException(e2);
            return jSONObject;
        }
    }

    static boolean a(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONObject jSONObjectPut = new JSONObject().put("event_name", str).put("event_parameters", g(map)).put("isValidEventParameters", false);
            if (map == null) {
                f3.a("error", "Parameters must be a dictionary.", jSONObjectPut, "StaticUtil-isValidEventParameters");
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (((String) entry.getKey()) == null) {
                    f3.a("error", "Parameter key is not a string.", jSONObjectPut, "StaticUtil-isValidEventParameters");
                    return false;
                }
                if (!(value instanceof String) && !(value instanceof Number) && !(value instanceof List) && !(value instanceof Map) && !(value instanceof Boolean) && !value.getClass().isArray()) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(value);
                }
            }
            if (sb.length() <= 0) {
                return true;
            }
            f3.a("error", "The event parameter is not valid.", jSONObjectPut.put("invalid_value", sb.toString()), "StaticUtil-isValidEventParameters");
            return false;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    static String a() {
        return String.valueOf(new Random().nextInt(2147483646));
    }

    static void a(final Intent intent, final Context context, final InsiderActivity.a aVar) {
        try {
            c.execute(new Runnable() { // from class: com.useinsider.insider.w4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    w4.a(context, intent, aVar);
                }
            });
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, Intent intent, InsiderActivity.a aVar) {
        try {
            h4.a().e(context, s4.INSIDER.b()).edit().putString(r4.STORED_LATEST_CLICKED_PUSH_INTENT.b(), intent.toUri(1)).commit();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
        if (aVar != null) {
            aVar.b();
        }
    }
}
