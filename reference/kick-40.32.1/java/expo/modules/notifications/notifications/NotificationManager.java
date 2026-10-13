package expo.modules.notifications.notifications;

import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.notifications.notifications.interfaces.NotificationListener;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.delegates.ExpoHandlingDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/notifications/notifications/NotificationManager;", "", "<init>", "()V", "listeners", "", "Lexpo/modules/notifications/notifications/interfaces/NotificationListener;", "pendingNotificationResponses", "", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "pendingNotificationResponsesFromExtras", "Landroid/os/Bundle;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "onNotificationReceived", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "onNotificationResponseReceived", "response", "onNotificationsDropped", "onNotificationResponseFromExtras", "extras", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationManager {
    public static final NotificationManager INSTANCE;
    private static final Set<NotificationListener> listeners;
    private static final List<NotificationResponse> pendingNotificationResponses;
    private static final List<Bundle> pendingNotificationResponsesFromExtras;

    private NotificationManager() {
    }

    static {
        NotificationManager notificationManager = new NotificationManager();
        INSTANCE = notificationManager;
        listeners = new LinkedHashSet();
        pendingNotificationResponses = new ArrayList();
        pendingNotificationResponsesFromExtras = new ArrayList();
        ExpoHandlingDelegate.INSTANCE.addListener(notificationManager);
    }

    public final void addListener(NotificationListener listener) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<NotificationListener> set = listeners;
        if (set.contains(listener)) {
            return;
        }
        set.add(listener);
        List<NotificationResponse> list = pendingNotificationResponses;
        if (!list.isEmpty()) {
            Iterator<NotificationResponse> it = list.iterator();
            loop0: while (true) {
                z2 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    } else if (listener.onNotificationResponseReceived(it.next()) || z2) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                pendingNotificationResponses.clear();
            }
        }
        List<Bundle> list2 = pendingNotificationResponsesFromExtras;
        if (list2.isEmpty()) {
            return;
        }
        Iterator<Bundle> it2 = list2.iterator();
        loop2: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop2;
                } else if (listener.onNotificationResponseIntentReceived(it2.next()) || z) {
                    z = true;
                }
            }
        }
        if (z) {
            pendingNotificationResponsesFromExtras.clear();
        }
    }

    public final void removeListener(NotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void onNotificationReceived(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Iterator<NotificationListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().onNotificationReceived(notification);
        }
    }

    public final void onNotificationResponseReceived(NotificationResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Set<NotificationListener> set = listeners;
        if (set.isEmpty()) {
            pendingNotificationResponses.add(response);
            return;
        }
        Iterator<NotificationListener> it = set.iterator();
        while (it.hasNext()) {
            it.next().onNotificationResponseReceived(response);
        }
    }

    public final void onNotificationsDropped() {
        Iterator<NotificationListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().onNotificationsDropped();
        }
    }

    public final void onNotificationResponseFromExtras(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Set<NotificationListener> set = listeners;
        if (!set.isEmpty()) {
            Iterator<NotificationListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onNotificationResponseIntentReceived(extras);
            }
        } else {
            List<Bundle> list = pendingNotificationResponsesFromExtras;
            if (list.isEmpty()) {
                list.add(extras);
            }
        }
    }
}
