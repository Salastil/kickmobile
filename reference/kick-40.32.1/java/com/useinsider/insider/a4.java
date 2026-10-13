package com.useinsider.insider;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.util.GmsVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class a4 {
    static void a(Context context, b4 b4Var, String str, int i) {
        try {
            ArrayList arrayListC = b4Var.c();
            File dir = new ContextWrapper(context).getDir("interactive_push-" + str + i, 0);
            if (dir.isDirectory()) {
                c4.a(dir);
            }
            int size = arrayListC.size();
            int iA = a(context) / (b4Var.b() == 2 ? size + 1 : size);
            for (int i2 = 0; i2 < size; i2++) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) arrayListC.get(i2);
                Bitmap bitmapA = c4.a(context, (String) concurrentHashMap.get("image_url"), b4Var.b(), iA);
                if (bitmapA == null) {
                    arrayListC.clear();
                    break;
                }
                String strA = c4.a(bitmapA, dir, String.valueOf(i2));
                if (strA.equals("")) {
                    bitmapA.recycle();
                    arrayListC.clear();
                    break;
                }
                concurrentHashMap.put("image_url", strA);
            }
            b4Var.a(arrayListC);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static boolean b(Context context, Notification notification, Intent intent, int i) {
        boolean z;
        boolean z2;
        try {
            b4 b4Var = (b4) intent.getSerializableExtra("interactivePush");
            ArrayList arrayListC = b4Var.c();
            int size = arrayListC.size();
            boolean z3 = false;
            int intExtra = intent.getIntExtra("insCurrentPage", 0);
            int i2 = intExtra % size;
            int i3 = i2 == 0 ? size : i2;
            String str = b4Var.b() == 0 ? "carousel" : "slider";
            notification.bigContentView = new RemoteViews(context.getPackageName(), w4.h(context, String.format(Locale.ENGLISH, "ins_lay_xcv_%s", str)));
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    z3 = true;
                    break;
                }
                try {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap((Map) arrayListC.get((i4 + intExtra) % size));
                    Bitmap bitmapB = c4.b((String) concurrentHashMap.remove("image_url"));
                    if (bitmapB == null) {
                        break;
                    }
                    Locale locale = Locale.ENGLISH;
                    int iF = w4.f(context, String.format(locale, "layout_%d", Integer.valueOf(i4)));
                    notification.bigContentView.setViewVisibility(iF, z3 ? 1 : 0);
                    ArrayList arrayList = arrayListC;
                    notification.bigContentView.setImageViewBitmap(w4.f(context, String.format(locale, "img_%d", Integer.valueOf(i4))), bitmapB);
                    notification.bigContentView.setTextViewText(w4.f(context, String.format(locale, "title_%d", Integer.valueOf(i4))), (CharSequence) concurrentHashMap.remove("headline"));
                    notification.bigContentView.setTextViewText(w4.f(context, String.format(locale, "content_%d", Integer.valueOf(i4))), (CharSequence) concurrentHashMap.remove("description"));
                    notification.bigContentView.setOnClickPendingIntent(iF, a(context, intent, concurrentHashMap, str));
                    i4++;
                    arrayListC = arrayList;
                    z3 = false;
                } catch (Exception e) {
                    e = e;
                    z = true;
                }
                Insider.Instance.putException(e);
                return z;
            }
            try {
                if (size == 1) {
                    notification.bigContentView.setViewVisibility(R.id.leftBt, 8);
                    notification.bigContentView.setViewVisibility(R.id.rightBt, 8);
                    z2 = true;
                } else {
                    z2 = true;
                    notification.bigContentView.setOnClickPendingIntent(R.id.leftBt, a(context, intent, i3 - 1, notification));
                    notification.bigContentView.setOnClickPendingIntent(R.id.rightBt, a(context, intent, i2 + 1, notification));
                }
                if (w4.a(context, "insider_advanced_notification_icon_flag", z2).booleanValue()) {
                    notification.bigContentView.setImageViewResource(R.id.carouselIconIv, i);
                }
                return z3;
            } catch (Exception e2) {
                e = e2;
                z = z3;
            }
        } catch (Exception e3) {
            e = e3;
            z = true;
        }
    }

    private static int a(Context context) {
        int integer;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_notificationStripRemoteViewSizeBytes", TypedValues.Custom.S_INT, "android");
            return (identifier == 0 || (integer = resources.getInteger(identifier)) <= 1000000) ? GmsVersion.VERSION_LONGHORN : integer;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return GmsVersion.VERSION_LONGHORN;
        }
    }

    static boolean a(Context context, Notification notification, Intent intent, int i) {
        try {
            b4 b4Var = (b4) intent.getSerializableExtra("interactivePush");
            boolean z = false;
            int intExtra = intent.getIntExtra("insCurrentPage", 0);
            ArrayList arrayListC = b4Var.c();
            int size = arrayListC.size();
            notification.bigContentView = new RemoteViews(context.getPackageName(), w4.h(context, "ins_lay_xcv_discovery"));
            ConcurrentHashMap concurrentHashMapA = b4Var.a();
            notification.bigContentView.setTextViewText(w4.f(context, "ins_direction_bt"), (CharSequence) concurrentHashMapA.get("button_text"));
            c4.a(context, notification, concurrentHashMapA, "setBackgroundColor", "ins_discovery_background", "background_color");
            c4.a(context, notification, concurrentHashMapA, "setBackgroundColor", "ins_direction_bt", "button_background_color");
            c4.a(context, notification, concurrentHashMapA, "setTextColor", "ins_direction_bt", "button_color");
            c4.a(context, notification, concurrentHashMapA, "setTextColor", "ins_dis_title", "text_color");
            int i2 = 0;
            while (i2 < size) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap((Map) arrayListC.get(i2));
                Bitmap bitmapB = c4.b((String) concurrentHashMap.remove("image_url"));
                if (bitmapB == null) {
                    return z;
                }
                Locale locale = Locale.ENGLISH;
                ArrayList arrayList = arrayListC;
                int i3 = size;
                int i4 = i2;
                c4.a(context, notification, concurrentHashMapA, "setBackgroundColor", String.format(locale, "bord_%d", Integer.valueOf(i2)), "background_color");
                c4.a(context, notification, concurrentHashMapA, "setBackgroundColor", String.format(locale, "inner_color_%d", Integer.valueOf(i4)), "background_color");
                if (intExtra == i4) {
                    notification.bigContentView.setImageViewBitmap(w4.f(context, "img_main"), bitmapB);
                    notification.bigContentView.setTextViewText(w4.f(context, "ins_dis_title"), (CharSequence) concurrentHashMap.remove("headline"));
                    PendingIntent pendingIntentA = a(context, intent, concurrentHashMap, "discovery");
                    notification.bigContentView.setOnClickPendingIntent(w4.f(context, "img_main"), pendingIntentA);
                    notification.bigContentView.setOnClickPendingIntent(w4.f(context, "ins_direction_bt"), pendingIntentA);
                    c4.a(context, notification, concurrentHashMapA, "setBackgroundColor", String.format(locale, "bord_%d", Integer.valueOf(i4)), "highlight_color");
                }
                notification.bigContentView.setImageViewBitmap(w4.f(context, String.format(locale, "img_%d", Integer.valueOf(i4))), bitmapB);
                notification.bigContentView.setOnClickPendingIntent(w4.f(context, String.format(locale, "img_%d", Integer.valueOf(i4))), a(context, intent, i4, notification));
                if (w4.a(context, "insider_advanced_notification_icon_flag", true).booleanValue()) {
                    notification.bigContentView.setImageViewResource(R.id.discoveryIconIv, i);
                }
                i2 = i4 + 1;
                arrayListC = arrayList;
                size = i3;
                z = false;
            }
            return true;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return true;
        }
    }

    private static PendingIntent a(Context context, Intent intent, ConcurrentHashMap concurrentHashMap, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            Intent intent2 = new Intent(context, (Class<?>) InsiderActivity.class);
            intent2.putExtra(str, (String) concurrentHashMap.remove("id"));
            intent2.putExtras(intent);
            if (concurrentHashMap.size() > 0) {
                for (String str2 : concurrentHashMap.keySet()) {
                    jSONObject.put(str2, concurrentHashMap.get(str2));
                    intent2.putExtra(str2, (String) concurrentHashMap.get(str2));
                }
            }
            intent2.putExtra(f.k, String.valueOf(jSONObject));
            return PendingIntent.getActivity(context, ((int) System.currentTimeMillis()) + new Random().nextInt(100) + 1, intent2, 201326592);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private static PendingIntent a(Context context, Intent intent, int i, Notification notification) {
        try {
            Intent intent2 = new Intent("direction_clicked");
            intent2.setClass(context, InteractiveDirectionReceiver.class);
            intent2.putExtras(intent);
            intent2.putExtra("insCurrentPage", i);
            if (notification.getGroup() != null) {
                intent2.putExtra("groupName", notification.getGroup());
            }
            return PendingIntent.getBroadcast(context, ((int) System.currentTimeMillis()) + new Random().nextInt(100) + 1, intent2, 201326592);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }
}
