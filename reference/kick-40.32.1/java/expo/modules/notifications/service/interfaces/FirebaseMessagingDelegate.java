package expo.modules.notifications.service.interfaces;

import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;

/* JADX INFO: compiled from: FirebaseMessagingDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/service/interfaces/FirebaseMessagingDelegate;", "", "onNewToken", "", "token", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onDeletedMessages", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FirebaseMessagingDelegate {
    void onDeletedMessages();

    void onMessageReceived(RemoteMessage remoteMessage);

    void onNewToken(String token);
}
