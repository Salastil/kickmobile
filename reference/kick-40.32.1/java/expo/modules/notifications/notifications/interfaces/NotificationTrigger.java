package expo.modules.notifications.notifications.interfaces;

import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationTrigger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "Landroid/os/Parcelable;", "getNotificationChannel", "", "toBundle", "Landroid/os/Bundle;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationTrigger extends Parcelable {
    default String getNotificationChannel() {
        return null;
    }

    Bundle toBundle();

    /* JADX INFO: compiled from: NotificationTrigger.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getNotificationChannel(NotificationTrigger notificationTrigger) {
            return NotificationTrigger.super.getNotificationChannel();
        }
    }
}
