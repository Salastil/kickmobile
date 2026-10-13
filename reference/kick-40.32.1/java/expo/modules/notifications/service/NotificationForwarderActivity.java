package expo.modules.notifications.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import expo.modules.notifications.service.delegates.ExpoHandlingDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationForwarderActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lexpo/modules/notifications/service/NotificationForwarderActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationForwarderActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            NotificationsService.Companion companion = NotificationsService.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Intent intentCreateNotificationResponseBroadcastIntent = companion.createNotificationResponseBroadcastIntent(applicationContext, getIntent());
            NotificationsService.Companion companion2 = NotificationsService.INSTANCE;
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            ExpoHandlingDelegate.INSTANCE.openAppToForeground(this, companion2.getNotificationResponseFromBroadcastIntent(intent));
            sendBroadcast(intentCreateNotificationResponseBroadcastIntent);
        } catch (IllegalArgumentException e) {
            Log.e("expo-notifications", "Failed to handle notification response: could not recover notification data from intent extras. This may happen on some Android versions. Opening app to foreground.", e);
            Intent mainActivityLauncher = ExpoHandlingDelegate.INSTANCE.getMainActivityLauncher(this);
            if (mainActivityLauncher != null) {
                startActivity(mainActivityLauncher);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
