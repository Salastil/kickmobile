package expo.modules.notifications.service.delegates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.notifications.notifications.NotificationManager;
import expo.modules.notifications.notifications.debug.DebugLogging;
import expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoNotificationLifecycleListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoNotificationLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "<init>", "()V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "", "intent", "Landroid/content/Intent;", "isFCMIntent", "extras", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoNotificationLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        if (extras.containsKey(NotificationsService.NOTIFICATION_RESPONSE_KEY) || extras.containsKey(NotificationsService.TEXT_INPUT_NOTIFICATION_RESPONSE_KEY)) {
            Log.d("ReactNativeJS", "[native] ExpoNotificationLifecycleListener contains an unmarshalled notification response. Skipping.");
        } else if (isFCMIntent(extras)) {
            DebugLogging.logBundle("ExpoNotificationLifeCycleListener.onCreate:", extras);
            NotificationManager.INSTANCE.onNotificationResponseFromExtras(extras);
        }
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public boolean onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey(NotificationsService.NOTIFICATION_RESPONSE_KEY) || extras.containsKey(NotificationsService.TEXT_INPUT_NOTIFICATION_RESPONSE_KEY)) {
                intent.removeExtra(NotificationsService.NOTIFICATION_RESPONSE_KEY);
                intent.removeExtra(NotificationsService.TEXT_INPUT_NOTIFICATION_RESPONSE_KEY);
            } else {
                if (!isFCMIntent(extras)) {
                    return false;
                }
                DebugLogging.logBundle("ExpoNotificationLifeCycleListener.onNewIntent:", extras);
                NotificationManager.INSTANCE.onNotificationResponseFromExtras(extras);
            }
        }
        return false;
    }

    private final boolean isFCMIntent(Bundle extras) {
        return extras.containsKey("google.message_id");
    }
}
