package com.useinsider.insider;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.Util$$ExternalSyntheticApiModelOutline0;
import expo.modules.notifications.service.NotificationsService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InteractiveDirectionReceiver extends BroadcastReceiver {
    private void a(Context context, Intent intent, NotificationCompat.Builder builder) {
        try {
            Bitmap bitmapB = k4.b(context);
            if (bitmapB == null) {
                bitmapB = c4.b((String) new ConcurrentHashMap((Map) ((b4) intent.getSerializableExtra("interactivePush")).c().get(0)).remove("image_url"));
            }
            builder.setLargeIcon(bitmapB);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY);
            int iA = w4.a(intent);
            int i = Build.VERSION.SDK_INT;
            NotificationCompat.Builder builder = i >= 26 ? new NotificationCompat.Builder(context, "InteractivePush") : new NotificationCompat.Builder(context);
            int iA2 = c4.a(context);
            intent.setClass(context, InsiderActivity.class);
            builder.setSmallIcon(iA2).setContentTitle(intent.getStringExtra("title")).setContentText(intent.getStringExtra("message")).setTicker(intent.getStringExtra("message")).setDeleteIntent(c4.b(context, intent.getStringExtra("camp_id") + iA)).setContentIntent(PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 201326592)).setAutoCancel(true);
            if (intent.getStringExtra("groupName") != null) {
                builder.setGroup(intent.getStringExtra("groupName"));
            }
            if (i >= 26) {
                Util$$ExternalSyntheticApiModelOutline0.m10732m();
                NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("InteractivePush", "InteractivePush", 2);
                builder.setChannelId("InteractivePush");
                notificationManager.createNotificationChannel(notificationChannelM);
            }
            a(context, intent, builder);
            Notification notificationBuild = builder.build();
            if (intent.getIntExtra("interactiveType", 0) == 2 ? a4.a(context, notificationBuild, intent, iA2) : a4.b(context, notificationBuild, intent, iA2)) {
                notificationManager.notify(iA, notificationBuild);
            } else {
                notificationManager.cancel(iA);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
