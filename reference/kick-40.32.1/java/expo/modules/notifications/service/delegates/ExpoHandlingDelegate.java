package expo.modules.notifications.service.delegates;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import expo.modules.notifications.notifications.NotificationManager;
import expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.NotificationForwarderActivity;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.interfaces.HandlingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoHandlingDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\t*\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoHandlingDelegate;", "Lexpo/modules/notifications/service/interfaces/HandlingDelegate;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isAppInForeground", "", "getListeners", "", "Lexpo/modules/notifications/notifications/NotificationManager;", InsiderHybridMethods.HANDLE_NOTIFICATION, "", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "shouldPresent", "handleNotificationResponse", NotificationsService.NOTIFICATION_RESPONSE_KEY, "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "handleNotificationsDropped", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoHandlingDelegate implements HandlingDelegate {
    public static final String OPEN_APP_INTENT_ACTION = "expo.modules.notifications.OPEN_APP_ACTION";
    private final Context context;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Collection<NotificationResponse> sPendingNotificationResponses = new ArrayList();
    private static WeakHashMap<NotificationManager, WeakReference<NotificationManager>> sListenersReferences = new WeakHashMap<>();

    /* JADX INFO: compiled from: ExpoHandlingDelegate.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00100\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoHandlingDelegate$Companion;", "", "<init>", "()V", "OPEN_APP_INTENT_ACTION", "", "sPendingNotificationResponses", "", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "getSPendingNotificationResponses", "()Ljava/util/Collection;", "setSPendingNotificationResponses", "(Ljava/util/Collection;)V", "sListenersReferences", "Ljava/util/WeakHashMap;", "Lexpo/modules/notifications/notifications/NotificationManager;", "Ljava/lang/ref/WeakReference;", "getSListenersReferences", "()Ljava/util/WeakHashMap;", "setSListenersReferences", "(Ljava/util/WeakHashMap;)V", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "createPendingIntentForOpeningApp", "Landroid/app/PendingIntent;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "broadcastIntent", "Landroid/content/Intent;", "openAppToForeground", NotificationsService.NOTIFICATION_RESPONSE_KEY, "getNotificationActionLauncher", "getMainActivityLauncher", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        protected final Collection<NotificationResponse> getSPendingNotificationResponses() {
            return ExpoHandlingDelegate.sPendingNotificationResponses;
        }

        protected final void setSPendingNotificationResponses(Collection<NotificationResponse> collection) {
            Intrinsics.checkNotNullParameter(collection, "<set-?>");
            ExpoHandlingDelegate.sPendingNotificationResponses = collection;
        }

        protected final WeakHashMap<NotificationManager, WeakReference<NotificationManager>> getSListenersReferences() {
            return ExpoHandlingDelegate.sListenersReferences;
        }

        protected final void setSListenersReferences(WeakHashMap<NotificationManager, WeakReference<NotificationManager>> weakHashMap) {
            Intrinsics.checkNotNullParameter(weakHashMap, "<set-?>");
            ExpoHandlingDelegate.sListenersReferences = weakHashMap;
        }

        public final void addListener(NotificationManager listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (getSListenersReferences().containsKey(listener)) {
                return;
            }
            getSListenersReferences().put(listener, new WeakReference<>(listener));
            Iterator<NotificationResponse> it = getSPendingNotificationResponses().iterator();
            while (it.hasNext()) {
                listener.onNotificationResponseReceived(it.next());
                it.remove();
            }
        }

        public final PendingIntent createPendingIntentForOpeningApp(Context context, Intent broadcastIntent) {
            String className;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(broadcastIntent, "broadcastIntent");
            int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
            Intent intent = new Intent(context, (Class<?>) NotificationForwarderActivity.class);
            intent.setData(broadcastIntent.getData());
            intent.setFlags(402915328);
            intent.putExtras(broadcastIntent);
            ComponentName component = broadcastIntent.getComponent();
            PendingIntent activity = PendingIntent.getActivity(context, (component == null || (className = component.getClassName()) == null) ? NotificationsService.class.hashCode() : className.hashCode(), intent, i);
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            return activity;
        }

        public final void openAppToForeground(Context context, NotificationResponse notificationResponse) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notificationResponse, "notificationResponse");
            Intent notificationActionLauncher = getNotificationActionLauncher(context);
            if (notificationActionLauncher == null) {
                notificationActionLauncher = getMainActivityLauncher(context);
            }
            if (notificationActionLauncher != null) {
                NotificationsService.INSTANCE.setNotificationResponseToIntent(notificationActionLauncher, notificationResponse);
                context.startActivity(notificationActionLauncher);
            } else {
                Log.w("expo-notifications", "No launch intent found for application. Interacting with the notification won't open the app. The implementation uses `getLaunchIntentForPackage` to find appropriate activity.");
            }
        }

        private final Intent getNotificationActionLauncher(Context context) {
            Intent intent = new Intent(ExpoHandlingDelegate.OPEN_APP_INTENT_ACTION);
            intent.addFlags(268435456);
            intent.setPackage(context.getApplicationContext().getPackageName());
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                return intent;
            }
            return null;
        }

        public final Intent getMainActivityLauncher(Context context) {
            Object objM12684constructorimpl;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                objM12684constructorimpl = Result.m12684constructorimpl(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
            if (thM12687exceptionOrNullimpl != null) {
                Log.w("expo-notifications", "getLaunchIntentForPackage threw while resolving the main activity launcher; treating as no launch intent.", thM12687exceptionOrNullimpl);
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            return (Intent) objM12684constructorimpl;
        }
    }

    public ExpoHandlingDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    protected final Context getContext() {
        return this.context;
    }

    public final boolean isAppInForeground() {
        return ProcessLifecycleOwner.INSTANCE.get().getLifecycleRegistry().getState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public final List<NotificationManager> getListeners() {
        Collection<WeakReference<NotificationManager>> collectionValues = sListenersReferences.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            NotificationManager notificationManager = (NotificationManager) ((WeakReference) it.next()).get();
            if (notificationManager != null) {
                arrayList.add(notificationManager);
            }
        }
        return arrayList;
    }

    @Override // expo.modules.notifications.service.interfaces.HandlingDelegate
    public void handleNotification(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (!isAppInForeground()) {
            if (shouldPresent(notification)) {
                NotificationsService.Companion.present$default(NotificationsService.INSTANCE, this.context, notification, null, null, 12, null);
            }
        } else {
            Iterator<T> it = getListeners().iterator();
            while (it.hasNext()) {
                ((NotificationManager) it.next()).onNotificationReceived(notification);
            }
        }
    }

    private final boolean shouldPresent(Notification notification) {
        String title = notification.getNotificationRequest().getContent().getTitle();
        if (title != null && title.length() != 0) {
            return true;
        }
        String text = notification.getNotificationRequest().getContent().getText();
        return (text == null || text.length() == 0) ? false : true;
    }

    @Override // expo.modules.notifications.service.interfaces.HandlingDelegate
    public void handleNotificationResponse(NotificationResponse notificationResponse) {
        Intrinsics.checkNotNullParameter(notificationResponse, "notificationResponse");
        if (notificationResponse.getAction().opensAppToForeground()) {
            INSTANCE.openAppToForeground(this.context, notificationResponse);
        }
        if (!isAppInForeground() && !Intrinsics.areEqual(notificationResponse.getActionIdentifier(), NotificationResponse.DEFAULT_ACTION_IDENTIFIER)) {
            FirebaseMessagingDelegate.Companion companion = FirebaseMessagingDelegate.INSTANCE;
            Context applicationContext = this.context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Bundle bundle = NotificationSerializer.toBundle(notificationResponse);
            Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
            companion.runTaskManagerTasks(applicationContext, bundle);
        }
        List<NotificationManager> listeners = getListeners();
        if (listeners.isEmpty()) {
            sPendingNotificationResponses.add(notificationResponse);
            return;
        }
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((NotificationManager) it.next()).onNotificationResponseReceived(notificationResponse);
        }
    }

    @Override // expo.modules.notifications.service.interfaces.HandlingDelegate
    public void handleNotificationsDropped() {
        Iterator<T> it = getListeners().iterator();
        while (it.hasNext()) {
            ((NotificationManager) it.next()).onNotificationsDropped();
        }
    }
}
