package expo.modules.notifications.notifications.channels.managers;

import android.app.NotificationChannelGroup;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0;
import com.useinsider.insider.k4$$ExternalSyntheticApiModelOutline0;
import expo.modules.core.arguments.ReadableArguments;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class AndroidXNotificationsChannelGroupManager implements NotificationsChannelGroupManager {
    private final NotificationManagerCompat mNotificationManager;

    public AndroidXNotificationsChannelGroupManager(Context context) {
        this.mNotificationManager = NotificationManagerCompat.from(context);
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public NotificationChannelGroup getNotificationChannelGroup(String str) {
        return this.mNotificationManager.getNotificationChannelGroup(str);
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return this.mNotificationManager.getNotificationChannelGroups();
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public NotificationChannelGroup createNotificationChannelGroup(String str, CharSequence charSequence, ReadableArguments readableArguments) {
        NotificationChannelGroup notificationChannelGroupM = k4$$ExternalSyntheticApiModelOutline0.m(str, charSequence);
        configureGroupWithOptions(notificationChannelGroupM, readableArguments);
        this.mNotificationManager.createNotificationChannelGroup(notificationChannelGroupM);
        return notificationChannelGroupM;
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public void deleteNotificationChannelGroup(String str) {
        this.mNotificationManager.deleteNotificationChannelGroup(str);
    }

    protected void configureGroupWithOptions(Object obj, ReadableArguments readableArguments) {
        if (k4$$ExternalSyntheticApiModelOutline0.m$1(obj)) {
            NotificationChannelGroup notificationChannelGroupM10437m = ColorKt$$ExternalSyntheticApiModelOutline0.m10437m(obj);
            if (Build.VERSION.SDK_INT < 28 || !readableArguments.containsKey("description")) {
                return;
            }
            notificationChannelGroupM10437m.setDescription(readableArguments.getString("description"));
        }
    }
}
