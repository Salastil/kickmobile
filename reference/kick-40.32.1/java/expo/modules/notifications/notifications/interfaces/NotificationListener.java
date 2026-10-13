package expo.modules.notifications.notifications.interfaces;

import android.os.Bundle;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/NotificationListener;", "", "onNotificationReceived", "", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "onNotificationResponseReceived", "", "response", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "onNotificationResponseIntentReceived", "extras", "Landroid/os/Bundle;", "onNotificationsDropped", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationListener {
    default void onNotificationReceived(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
    }

    default boolean onNotificationResponseIntentReceived(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return false;
    }

    default boolean onNotificationResponseReceived(NotificationResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return false;
    }

    default void onNotificationsDropped() {
    }

    /* JADX INFO: compiled from: NotificationListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onNotificationReceived(NotificationListener notificationListener, Notification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            NotificationListener.super.onNotificationReceived(notification);
        }

        @Deprecated
        public static boolean onNotificationResponseReceived(NotificationListener notificationListener, NotificationResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return NotificationListener.super.onNotificationResponseReceived(response);
        }

        @Deprecated
        public static boolean onNotificationResponseIntentReceived(NotificationListener notificationListener, Bundle extras) {
            Intrinsics.checkNotNullParameter(extras, "extras");
            return NotificationListener.super.onNotificationResponseIntentReceived(extras);
        }

        @Deprecated
        public static void onNotificationsDropped(NotificationListener notificationListener) {
            NotificationListener.super.onNotificationsDropped();
        }
    }
}
