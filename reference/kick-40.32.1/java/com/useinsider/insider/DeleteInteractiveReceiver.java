package com.useinsider.insider;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import expo.modules.notifications.service.NotificationsService;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class DeleteInteractiveReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f284a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f284a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File dir = new ContextWrapper(this.f284a).getDir("interactive_push-" + this.b, 0);
                if (dir.isDirectory()) {
                    c4.a(dir);
                    dir.delete();
                    f3.b("push", "Image saved for Interactive Push has been deleted.", "{ 'folder_id': '" + this.b + "'}", "DeleteInteractiveReceiver-onReceive");
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:4:0x000d, B:6:0x0013, B:14:0x004e, B:7:0x0025, B:9:0x0030, B:13:0x0039), top: B:19:0x000d }] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        Log.e("Insider", "DeleteInteractiveReceiver called");
        if (intent != null) {
            try {
                if (intent.hasExtra("folder_id")) {
                    new Thread(new a(context, intent.getStringExtra("folder_id"))).start();
                } else {
                    StringBuilder sb = new StringBuilder("{ 'notification_id': '");
                    if (intent == null && intent.hasExtra("folder_id")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(String.valueOf(z));
                    sb.append("'}");
                    f3.a("push", "Failed to delete image saved for Interactive Push.", sb.toString(), "DeleteInteractiveReceiver-onReceive");
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return;
            }
        } else {
            StringBuilder sb2 = new StringBuilder("{ 'notification_id': '");
            if (intent == null) {
                z = false;
            } else {
                z = false;
            }
            sb2.append(String.valueOf(z));
            sb2.append("'}");
            f3.a("push", "Failed to delete image saved for Interactive Push.", sb2.toString(), "DeleteInteractiveReceiver-onReceive");
        }
        a(context);
    }

    private void a(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY);
            int i = 0;
            boolean z = false;
            int id = 0;
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                if (String.valueOf(statusBarNotification.getNotification().getGroup()).contains("ins_")) {
                    i++;
                    if (statusBarNotification.getNotification().tickerText == null) {
                        z = true;
                    }
                    id = statusBarNotification.getId();
                }
            }
            if (i == 1 && z && id != 0) {
                notificationManager.cancel(id);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
