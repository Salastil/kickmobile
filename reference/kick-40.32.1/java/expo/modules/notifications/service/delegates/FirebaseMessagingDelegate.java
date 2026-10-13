package expo.modules.notifications.service.delegates;

import android.content.Context;
import android.os.Bundle;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.interfaces.taskManager.TaskServiceProviderHelper;
import expo.modules.notifications.notifications.RemoteMessageSerializer;
import expo.modules.notifications.notifications.background.BackgroundRemoteNotificationTaskConsumer;
import expo.modules.notifications.notifications.debug.DebugLogging;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.model.RemoteNotificationContent;
import expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.tokens.interfaces.FirebaseTokenListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirebaseMessagingDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0004J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lexpo/modules/notifications/service/delegates/FirebaseMessagingDelegate;", "Lexpo/modules/notifications/service/interfaces/FirebaseMessagingDelegate;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onNewToken", "", "token", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "createNotification", "Lexpo/modules/notifications/notifications/model/Notification;", "getNotificationIdentifier", "createNotificationRequest", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", NotificationsService.IDENTIFIER_KEY, "content", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "notificationTrigger", "Lexpo/modules/notifications/notifications/model/triggers/FirebaseNotificationTrigger;", "onDeletedMessages", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FirebaseMessagingDelegate implements expo.modules.notifications.service.interfaces.FirebaseMessagingDelegate {
    private static String sLastToken;
    private final Context context;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashSet<FirebaseTokenListener> sTokenListenersReferences = new HashSet<>();
    private static Set<BackgroundRemoteNotificationTaskConsumer> sBackgroundTaskConsumers = new LinkedHashSet();

    @JvmStatic
    public static final void addTokenListener(FirebaseTokenListener firebaseTokenListener) {
        INSTANCE.addTokenListener(firebaseTokenListener);
    }

    @JvmStatic
    public static final boolean removeTokenListener(FirebaseTokenListener firebaseTokenListener) {
        return INSTANCE.removeTokenListener(firebaseTokenListener);
    }

    /* JADX INFO: compiled from: FirebaseMessagingDelegate.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001fJ\u0016\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lexpo/modules/notifications/service/delegates/FirebaseMessagingDelegate$Companion;", "", "<init>", "()V", "sLastToken", "", "getSLastToken", "()Ljava/lang/String;", "setSLastToken", "(Ljava/lang/String;)V", "sTokenListenersReferences", "Ljava/util/HashSet;", "Lexpo/modules/notifications/tokens/interfaces/FirebaseTokenListener;", "getSTokenListenersReferences", "()Ljava/util/HashSet;", "addTokenListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeTokenListener", "", "sBackgroundTaskConsumers", "", "Lexpo/modules/notifications/notifications/background/BackgroundRemoteNotificationTaskConsumer;", "getSBackgroundTaskConsumers", "()Ljava/util/Set;", "setSBackgroundTaskConsumers", "(Ljava/util/Set;)V", "addBackgroundTaskConsumer", "taskConsumer", "removeBackgroundTaskConsumer", "getBackgroundTasks", "", "runTaskManagerTasks", "applicationContext", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        protected final String getSLastToken() {
            return FirebaseMessagingDelegate.sLastToken;
        }

        protected final void setSLastToken(String str) {
            FirebaseMessagingDelegate.sLastToken = str;
        }

        protected final HashSet<FirebaseTokenListener> getSTokenListenersReferences() {
            return FirebaseMessagingDelegate.sTokenListenersReferences;
        }

        @JvmStatic
        public final void addTokenListener(FirebaseTokenListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (getSTokenListenersReferences()) {
                if (!FirebaseMessagingDelegate.INSTANCE.getSTokenListenersReferences().contains(listener)) {
                    FirebaseMessagingDelegate.INSTANCE.getSTokenListenersReferences().add(listener);
                    String sLastToken = FirebaseMessagingDelegate.INSTANCE.getSLastToken();
                    if (sLastToken != null) {
                        listener.onNewToken(sLastToken);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @JvmStatic
        public final boolean removeTokenListener(FirebaseTokenListener listener) {
            boolean zRemove;
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (getSTokenListenersReferences()) {
                zRemove = FirebaseMessagingDelegate.INSTANCE.getSTokenListenersReferences().remove(listener);
            }
            return zRemove;
        }

        protected final Set<BackgroundRemoteNotificationTaskConsumer> getSBackgroundTaskConsumers() {
            return FirebaseMessagingDelegate.sBackgroundTaskConsumers;
        }

        protected final void setSBackgroundTaskConsumers(Set<BackgroundRemoteNotificationTaskConsumer> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            FirebaseMessagingDelegate.sBackgroundTaskConsumers = set;
        }

        public final void addBackgroundTaskConsumer(BackgroundRemoteNotificationTaskConsumer taskConsumer) {
            Intrinsics.checkNotNullParameter(taskConsumer, "taskConsumer");
            getSBackgroundTaskConsumers().add(taskConsumer);
        }

        public final void removeBackgroundTaskConsumer(BackgroundRemoteNotificationTaskConsumer taskConsumer) {
            Intrinsics.checkNotNullParameter(taskConsumer, "taskConsumer");
            getSBackgroundTaskConsumers().remove(taskConsumer);
        }

        public final List<BackgroundRemoteNotificationTaskConsumer> getBackgroundTasks() {
            return CollectionsKt.toList(getSBackgroundTaskConsumers());
        }

        public final void runTaskManagerTasks(Context applicationContext, Bundle bundle) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            TaskServiceProviderHelper.INSTANCE.getTaskServiceImpl(applicationContext);
            Iterator<T> it = getBackgroundTasks().iterator();
            while (it.hasNext()) {
                ((BackgroundRemoteNotificationTaskConsumer) it.next()).executeTask(bundle);
            }
        }
    }

    public FirebaseMessagingDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    protected final Context getContext() {
        return this.context;
    }

    @Override // expo.modules.notifications.service.interfaces.FirebaseMessagingDelegate
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Iterator<FirebaseTokenListener> it = sTokenListenersReferences.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            FirebaseTokenListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onNewToken(token);
        }
        sLastToken = token;
    }

    @Override // expo.modules.notifications.service.interfaces.FirebaseMessagingDelegate
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        DebugLogging.INSTANCE.logRemoteMessage("FirebaseMessagingDelegate.onMessageReceived: message", remoteMessage);
        Notification notificationCreateNotification = createNotification(remoteMessage);
        DebugLogging.INSTANCE.logNotification("FirebaseMessagingDelegate.onMessageReceived: notification", notificationCreateNotification);
        NotificationsService.Companion.receive$default(NotificationsService.INSTANCE, this.context, notificationCreateNotification, null, 4, null);
        Companion companion = INSTANCE;
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Bundle bundle = RemoteMessageSerializer.toBundle(remoteMessage);
        Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
        companion.runTaskManagerTasks(applicationContext, bundle);
    }

    protected final Notification createNotification(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        return new Notification(createNotificationRequest(getNotificationIdentifier(remoteMessage), new RemoteNotificationContent(remoteMessage), new FirebaseNotificationTrigger(remoteMessage)), new Date(remoteMessage.getSentTime()));
    }

    protected final String getNotificationIdentifier(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        String str = remoteMessage.getData().get("tag");
        if (str != null) {
            return str;
        }
        String messageId = remoteMessage.getMessageId();
        if (messageId != null) {
            return messageId;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    protected NotificationRequest createNotificationRequest(String identifier, INotificationContent content, FirebaseNotificationTrigger notificationTrigger) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(notificationTrigger, "notificationTrigger");
        return new NotificationRequest(identifier, content, notificationTrigger);
    }

    @Override // expo.modules.notifications.service.interfaces.FirebaseMessagingDelegate
    public void onDeletedMessages() {
        NotificationsService.INSTANCE.handleDropped(this.context);
    }
}
