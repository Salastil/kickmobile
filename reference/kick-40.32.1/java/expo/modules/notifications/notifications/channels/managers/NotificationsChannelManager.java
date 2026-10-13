package expo.modules.notifications.notifications.channels.managers;

import android.app.NotificationChannel;
import expo.modules.core.arguments.ReadableArguments;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface NotificationsChannelManager {
    NotificationChannel createNotificationChannel(String str, CharSequence charSequence, int i, ReadableArguments readableArguments);

    boolean customSoundExists(ReadableArguments readableArguments);

    void deleteNotificationChannel(String str);

    NotificationChannel getNotificationChannel(String str);

    List<NotificationChannel> getNotificationChannels();
}
