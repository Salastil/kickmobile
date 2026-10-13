package expo.modules.notifications.notifications.interfaces;

import java.io.Serializable;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: SchedulableNotificationTrigger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "Ljava/io/Serializable;", "nextTriggerDate", "Ljava/util/Date;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SchedulableNotificationTrigger extends NotificationTrigger, Serializable {
    Date nextTriggerDate();

    /* JADX INFO: compiled from: SchedulableNotificationTrigger.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getNotificationChannel(SchedulableNotificationTrigger schedulableNotificationTrigger) {
            return SchedulableNotificationTrigger.super.getNotificationChannel();
        }
    }
}
