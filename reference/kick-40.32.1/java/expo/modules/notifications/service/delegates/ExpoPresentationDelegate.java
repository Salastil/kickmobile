package expo.modules.notifications.service.delegates;

import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.facebook.react.modules.dialog.DialogModule;
import expo.modules.notifications.notifications.SoundResolver;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehaviorRecord;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.interfaces.PresentationDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0080@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u00020\u000b2\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00180$0#H\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&H\u0016J\u0016\u0010'\u001a\u00020\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0&H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J \u0010*\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0094@¢\u0006\u0002\u0010\u0012J\u0012\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064²\u0006\u0010\u00105\u001a\b\u0012\u0004\u0012\u00020\r0&X\u008a\u0084\u0002"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate;", "Lexpo/modules/notifications/service/interfaces/PresentationDelegate;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "<init>", "(Landroid/content/Context;Landroidx/core/app/NotificationManagerCompat;)V", "getContext", "()Landroid/content/Context;", "presentNotification", "", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "behavior", "Lexpo/modules/notifications/notifications/model/NotificationBehaviorRecord;", "presentNotificationInternal", "presentNotificationInternal$expo_notifications_release", "(Lexpo/modules/notifications/notifications/model/Notification;Lexpo/modules/notifications/notifications/model/NotificationBehaviorRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeOrphanedGroupSummaries", DialogModule.ACTION_DISMISSED, "getNotificationSoundUri", "Landroid/net/Uri;", "getNotifyId", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "postGroupSummary", "group", "", "childTag", "childNotification", "Landroid/app/Notification;", "cleanUpOrphanedGroupSummaries", "cancelled", "", "Lkotlin/Pair;", "getAllPresentedNotifications", "", "dismissNotifications", NotificationsService.IDENTIFIERS_KEY, "dismissAllNotifications", "createNotification", NotificationsService.NOTIFICATION_BEHAVIOR_KEY, "getNotification", "statusBarNotification", "Landroid/service/notification/StatusBarNotification;", "fromBundle", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "Companion", "expo-notifications_release", "presentedNotifications"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExpoPresentationDelegate implements PresentationDelegate {
    protected static final int ANDROID_NOTIFICATION_ID = 0;
    public static final String GROUP_SUMMARY_TAG_SUFFIX = ":expo-group-summary";
    protected static final String INTERNAL_IDENTIFIER_AUTHORITY = "foreign_notifications";
    protected static final String INTERNAL_IDENTIFIER_ID_KEY = "id";
    protected static final String INTERNAL_IDENTIFIER_SCHEME = "expo-notifications";
    protected static final String INTERNAL_IDENTIFIER_TAG_KEY = "tag";
    private final Context context;
    private final NotificationManagerCompat notificationManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int GROUP_SUMMARY_NOTIFICATION_ID = 24669629;
    private static final Mutex presentationMutex = MutexKt.Mutex$default(false, 1, null);

    protected Object createNotification(Notification notification, NotificationBehaviorRecord notificationBehaviorRecord, Continuation<? super android.app.Notification> continuation) {
        return createNotification$suspendImpl(this, notification, notificationBehaviorRecord, continuation);
    }

    protected int getNotifyId(NotificationRequest request) {
        return 0;
    }

    public ExpoPresentationDelegate(Context context, NotificationManagerCompat notificationManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        this.context = context;
        this.notificationManager = notificationManager;
    }

    protected final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExpoPresentationDelegate(Context context, NotificationManagerCompat notificationManagerCompat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            notificationManagerCompat = NotificationManagerCompat.from(context);
            Intrinsics.checkNotNullExpressionValue(notificationManagerCompat, "from(...)");
        }
        this(context, notificationManagerCompat);
    }

    /* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate$Companion;", "", "<init>", "()V", "ANDROID_NOTIFICATION_ID", "", "GROUP_SUMMARY_TAG_SUFFIX", "", "GROUP_SUMMARY_NOTIFICATION_ID", "getGROUP_SUMMARY_NOTIFICATION_ID$expo_notifications_release", "()I", "isGroupSummary", "", NotificationsService.NOTIFICATION_KEY, "Landroid/service/notification/StatusBarNotification;", "presentationMutex", "Lkotlinx/coroutines/sync/Mutex;", "INTERNAL_IDENTIFIER_SCHEME", "INTERNAL_IDENTIFIER_AUTHORITY", "INTERNAL_IDENTIFIER_TAG_KEY", "INTERNAL_IDENTIFIER_ID_KEY", "parseNotificationIdentifier", "Landroid/util/Pair;", NotificationsService.IDENTIFIER_KEY, "getInternalIdentifierKey", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getGROUP_SUMMARY_NOTIFICATION_ID$expo_notifications_release() {
            return ExpoPresentationDelegate.GROUP_SUMMARY_NOTIFICATION_ID;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGroupSummary(StatusBarNotification notification) {
            String tag;
            return ((notification.getNotification().flags & 512) == 0 || (tag = notification.getTag()) == null || !StringsKt.endsWith$default(tag, ExpoPresentationDelegate.GROUP_SUMMARY_TAG_SUFFIX, false, 2, (Object) null)) ? false : true;
        }

        public final Pair<String, Integer> parseNotificationIdentifier(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            try {
                Uri uri = Uri.parse(identifier);
                if (!Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, uri.getScheme()) || !Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_AUTHORITY, uri.getAuthority())) {
                    return null;
                }
                String queryParameter = uri.getQueryParameter(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_TAG_KEY);
                String queryParameter2 = uri.getQueryParameter("id");
                Intrinsics.checkNotNull(queryParameter2);
                return new Pair<>(queryParameter, Integer.valueOf(Integer.parseInt(queryParameter2)));
            } catch (NullPointerException e) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e);
                return null;
            } catch (NumberFormatException e2) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e2);
                return null;
            } catch (UnsupportedOperationException e3) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e3);
                return null;
            }
        }

        protected final String getInternalIdentifierKey(StatusBarNotification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Uri.Builder builderBuildUpon = Uri.parse("expo-notifications://foreign_notifications").buildUpon();
            String tag = notification.getTag();
            if (tag != null) {
                builderBuildUpon.appendQueryParameter(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_TAG_KEY, tag);
            }
            builderBuildUpon.appendQueryParameter("id", String.valueOf(notification.getId()));
            String string = builderBuildUpon.toString();
            Intrinsics.checkNotNullExpressionValue(string, "with(...)");
            return string;
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void presentNotification(Notification notification, NotificationBehaviorRecord behavior) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (behavior == null || behavior.getShouldPresentAlert()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09231(notification, behavior, null), 3, null);
        } else if (behavior.getShouldPlaySound()) {
            Uri notificationSoundUri = getNotificationSoundUri(notification);
            if (notificationSoundUri == null) {
                notificationSoundUri = Settings.System.DEFAULT_NOTIFICATION_URI;
            }
            RingtoneManager.getRingtone(this.context, notificationSoundUri).play();
        }
    }

    /* JADX INFO: renamed from: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$presentNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$presentNotification$1", f = "ExpoPresentationDelegate.kt", i = {}, l = {TimeseriesConfiguration.DEFAULT_BUFFER_SIZE}, m = "invokeSuspend", n = {}, s = {})
    static final class C09231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotificationBehaviorRecord $behavior;
        final /* synthetic */ Notification $notification;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09231(Notification notification, NotificationBehaviorRecord notificationBehaviorRecord, Continuation<? super C09231> continuation) {
            super(2, continuation);
            this.$notification = notification;
            this.$behavior = notificationBehaviorRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoPresentationDelegate.this.new C09231(this.$notification, this.$behavior, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ExpoPresentationDelegate.this.presentNotificationInternal$expo_notifications_release(this.$notification, this.$behavior, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c0 A[Catch: all -> 0x016e, TryCatch #1 {all -> 0x016e, blocks: (B:23:0x00a9, B:24:0x00ba, B:26:0x00c0, B:28:0x00d1, B:32:0x00d9, B:34:0x00dd, B:45:0x0121, B:48:0x0129, B:49:0x012e, B:55:0x015a, B:57:0x0160, B:58:0x0165, B:54:0x0150, B:44:0x0117, B:37:0x00f4, B:39:0x00fb, B:41:0x010c, B:40:0x0108, B:51:0x013d), top: B:66:0x00a9, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fb A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:37:0x00f4, B:39:0x00fb, B:41:0x010c, B:40:0x0108), top: B:64:0x00f4, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0108 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:37:0x00f4, B:39:0x00fb, B:41:0x010c, B:40:0x0108), top: B:64:0x00f4, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0129 A[Catch: all -> 0x016e, TRY_ENTER, TryCatch #1 {all -> 0x016e, blocks: (B:23:0x00a9, B:24:0x00ba, B:26:0x00c0, B:28:0x00d1, B:32:0x00d9, B:34:0x00dd, B:45:0x0121, B:48:0x0129, B:49:0x012e, B:55:0x015a, B:57:0x0160, B:58:0x0165, B:54:0x0150, B:44:0x0117, B:37:0x00f4, B:39:0x00fb, B:41:0x010c, B:40:0x0108, B:51:0x013d), top: B:66:0x00a9, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0160 A[Catch: all -> 0x016e, TryCatch #1 {all -> 0x016e, blocks: (B:23:0x00a9, B:24:0x00ba, B:26:0x00c0, B:28:0x00d1, B:32:0x00d9, B:34:0x00dd, B:45:0x0121, B:48:0x0129, B:49:0x012e, B:55:0x015a, B:57:0x0160, B:58:0x0165, B:54:0x0150, B:44:0x0117, B:37:0x00f4, B:39:0x00fb, B:41:0x010c, B:40:0x0108, B:51:0x013d), top: B:66:0x00a9, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object presentNotificationInternal$expo_notifications_release(Notification notification, NotificationBehaviorRecord notificationBehaviorRecord, Continuation<? super Unit> continuation) {
        ExpoPresentationDelegate$presentNotificationInternal$1 expoPresentationDelegate$presentNotificationInternal$1;
        NotificationRequest notificationRequest;
        android.app.Notification notification2;
        String str;
        int i;
        Mutex mutex;
        Iterator<T> it;
        Object next;
        StatusBarNotification statusBarNotification;
        Object objM12684constructorimpl;
        Throwable thM12687exceptionOrNullimpl;
        String group;
        Object objM12684constructorimpl2;
        Throwable thM12687exceptionOrNullimpl2;
        Set<kotlin.Pair<String, Integer>> setEmptySet;
        StatusBarNotification statusBarNotification2;
        if (continuation instanceof ExpoPresentationDelegate$presentNotificationInternal$1) {
            expoPresentationDelegate$presentNotificationInternal$1 = (ExpoPresentationDelegate$presentNotificationInternal$1) continuation;
            if ((expoPresentationDelegate$presentNotificationInternal$1.label & Integer.MIN_VALUE) != 0) {
                expoPresentationDelegate$presentNotificationInternal$1.label -= Integer.MIN_VALUE;
            } else {
                expoPresentationDelegate$presentNotificationInternal$1 = new ExpoPresentationDelegate$presentNotificationInternal$1(this, continuation);
            }
        } else {
            expoPresentationDelegate$presentNotificationInternal$1 = new ExpoPresentationDelegate$presentNotificationInternal$1(this, continuation);
        }
        Object objCreateNotification = expoPresentationDelegate$presentNotificationInternal$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = expoPresentationDelegate$presentNotificationInternal$1.label;
        boolean z = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCreateNotification);
            expoPresentationDelegate$presentNotificationInternal$1.L$0 = notification;
            expoPresentationDelegate$presentNotificationInternal$1.L$1 = SpillingKt.nullOutSpilledVariable(notificationBehaviorRecord);
            expoPresentationDelegate$presentNotificationInternal$1.label = 1;
            objCreateNotification = createNotification(notification, notificationBehaviorRecord, expoPresentationDelegate$presentNotificationInternal$1);
            if (objCreateNotification != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            notificationBehaviorRecord = (NotificationBehaviorRecord) expoPresentationDelegate$presentNotificationInternal$1.L$1;
            notification = (Notification) expoPresentationDelegate$presentNotificationInternal$1.L$0;
            ResultKt.throwOnFailure(objCreateNotification);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = expoPresentationDelegate$presentNotificationInternal$1.I$1;
            i = expoPresentationDelegate$presentNotificationInternal$1.I$0;
            mutex = (Mutex) expoPresentationDelegate$presentNotificationInternal$1.L$5;
            str = (String) expoPresentationDelegate$presentNotificationInternal$1.L$4;
            notificationRequest = (NotificationRequest) expoPresentationDelegate$presentNotificationInternal$1.L$3;
            notification2 = (android.app.Notification) expoPresentationDelegate$presentNotificationInternal$1.L$2;
            ResultKt.throwOnFailure(objCreateNotification);
        }
        try {
            List<StatusBarNotification> activeNotifications = this.notificationManager.getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
            it = activeNotifications.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                statusBarNotification2 = (StatusBarNotification) next;
                if (!Intrinsics.areEqual(statusBarNotification2.getTag(), str) && statusBarNotification2.getId() == i) {
                    break;
                }
            }
            statusBarNotification = (StatusBarNotification) next;
            if (statusBarNotification != null && !Intrinsics.areEqual(statusBarNotification.getNotification().getGroup(), notificationRequest.getContent().getGroup())) {
                z = true;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                ExpoPresentationDelegate expoPresentationDelegate = this;
                if (z) {
                    setEmptySet = SetsKt.setOf(TuplesKt.to(str, Boxing.boxInt(i)));
                } else {
                    setEmptySet = SetsKt.emptySet();
                }
                cleanUpOrphanedGroupSummaries(setEmptySet);
                objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
            if (thM12687exceptionOrNullimpl != null) {
                Log.e(INTERNAL_IDENTIFIER_SCHEME, "Failed to clean up group summary notifications.", thM12687exceptionOrNullimpl);
            }
            this.notificationManager.notify(str, i, notification2);
            group = notificationRequest.getContent().getGroup();
            if (group != null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    ExpoPresentationDelegate expoPresentationDelegate2 = this;
                    Intrinsics.checkNotNull(str);
                    postGroupSummary(group, str, notification2);
                    objM12684constructorimpl2 = Result.m12684constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                thM12687exceptionOrNullimpl2 = Result.m12687exceptionOrNullimpl(objM12684constructorimpl2);
                if (thM12687exceptionOrNullimpl2 != null) {
                    Log.e(INTERNAL_IDENTIFIER_SCHEME, "Failed to post a group summary notification.", thM12687exceptionOrNullimpl2);
                }
                Result.m12683boximpl(objM12684constructorimpl2);
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            mutex.unlock(null);
            throw th3;
        }
        android.app.Notification notification3 = (android.app.Notification) objCreateNotification;
        notificationRequest = notification.getNotificationRequest();
        String identifier = notificationRequest.getIdentifier();
        int notifyId = getNotifyId(notificationRequest);
        Mutex mutex2 = presentationMutex;
        expoPresentationDelegate$presentNotificationInternal$1.L$0 = SpillingKt.nullOutSpilledVariable(notification);
        expoPresentationDelegate$presentNotificationInternal$1.L$1 = SpillingKt.nullOutSpilledVariable(notificationBehaviorRecord);
        expoPresentationDelegate$presentNotificationInternal$1.L$2 = notification3;
        expoPresentationDelegate$presentNotificationInternal$1.L$3 = notificationRequest;
        expoPresentationDelegate$presentNotificationInternal$1.L$4 = identifier;
        expoPresentationDelegate$presentNotificationInternal$1.L$5 = mutex2;
        expoPresentationDelegate$presentNotificationInternal$1.I$0 = notifyId;
        expoPresentationDelegate$presentNotificationInternal$1.I$1 = 0;
        expoPresentationDelegate$presentNotificationInternal$1.label = 2;
        if (mutex2.lock(null, expoPresentationDelegate$presentNotificationInternal$1) != coroutine_suspended) {
            notification2 = notification3;
            str = identifier;
            i = notifyId;
            mutex = mutex2;
            List<StatusBarNotification> activeNotifications2 = this.notificationManager.getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications2, "getActiveNotifications(...)");
            it = activeNotifications2.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                statusBarNotification2 = (StatusBarNotification) next;
                if (!Intrinsics.areEqual(statusBarNotification2.getTag(), str)) {
                }
            }
            statusBarNotification = (StatusBarNotification) next;
            if (statusBarNotification != null) {
                z = true;
            }
            Result.Companion companion5 = Result.INSTANCE;
            ExpoPresentationDelegate expoPresentationDelegate3 = this;
            if (z) {
                setEmptySet = SetsKt.setOf(TuplesKt.to(str, Boxing.boxInt(i)));
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            cleanUpOrphanedGroupSummaries(setEmptySet);
            objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
            thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
            if (thM12687exceptionOrNullimpl != null) {
                Log.e(INTERNAL_IDENTIFIER_SCHEME, "Failed to clean up group summary notifications.", thM12687exceptionOrNullimpl);
            }
            this.notificationManager.notify(str, i, notification2);
            group = notificationRequest.getContent().getGroup();
            if (group != null) {
                Result.Companion companion6 = Result.INSTANCE;
                ExpoPresentationDelegate expoPresentationDelegate4 = this;
                Intrinsics.checkNotNull(str);
                postGroupSummary(group, str, notification2);
                objM12684constructorimpl2 = Result.m12684constructorimpl(Unit.INSTANCE);
                thM12687exceptionOrNullimpl2 = Result.m12687exceptionOrNullimpl(objM12684constructorimpl2);
                if (thM12687exceptionOrNullimpl2 != null) {
                    Log.e(INTERNAL_IDENTIFIER_SCHEME, "Failed to post a group summary notification.", thM12687exceptionOrNullimpl2);
                }
                Result.m12683boximpl(objM12684constructorimpl2);
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$removeOrphanedGroupSummaries$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$removeOrphanedGroupSummaries$1", f = "ExpoPresentationDelegate.kt", i = {0, 0, 0}, l = {347}, m = "invokeSuspend", n = {"$this$runBlocking", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0"})
    static final class C09241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ NotificationRequest $request;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09241(NotificationRequest notificationRequest, Continuation<? super C09241> continuation) {
            super(2, continuation);
            this.$request = notificationRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09241 c09241 = ExpoPresentationDelegate.this.new C09241(this.$request, continuation);
            c09241.L$0 = obj;
            return c09241;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
            return ((C09241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            ExpoPresentationDelegate expoPresentationDelegate;
            NotificationRequest notificationRequest;
            Object objM12684constructorimpl;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = ExpoPresentationDelegate.presentationMutex;
                ExpoPresentationDelegate expoPresentationDelegate2 = ExpoPresentationDelegate.this;
                NotificationRequest notificationRequest2 = this.$request;
                this.L$0 = coroutineScope;
                this.L$1 = mutex2;
                this.L$2 = expoPresentationDelegate2;
                this.L$3 = notificationRequest2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                expoPresentationDelegate = expoPresentationDelegate2;
                notificationRequest = notificationRequest2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                notificationRequest = (NotificationRequest) this.L$3;
                expoPresentationDelegate = (ExpoPresentationDelegate) this.L$2;
                mutex = (Mutex) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            try {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    expoPresentationDelegate.cleanUpOrphanedGroupSummaries(SetsKt.setOf(TuplesKt.to(notificationRequest.getIdentifier(), Boxing.boxInt(expoPresentationDelegate.getNotifyId(notificationRequest)))));
                    objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
                if (thM12687exceptionOrNullimpl != null) {
                    Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Failed to clean up group summary notifications.", thM12687exceptionOrNullimpl);
                }
                return Result.m12683boximpl(objM12684constructorimpl);
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void removeOrphanedGroupSummaries(Notification dismissed) throws InterruptedException {
        Intrinsics.checkNotNullParameter(dismissed, "dismissed");
        BuildersKt__BuildersKt.runBlocking$default(null, new C09241(dismissed.getNotificationRequest(), null), 1, null);
    }

    private final Uri getNotificationSoundUri(Notification notification) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT >= 26) {
            String notificationChannel2 = notification.getNotificationRequest().getTrigger().getNotificationChannel();
            if (notificationChannel2 == null || (notificationChannel = this.notificationManager.getNotificationChannel(notificationChannel2)) == null) {
                return null;
            }
            return notificationChannel.getSound();
        }
        return new SoundResolver(this.context).resolve(notification.getNotificationRequest().getContent().getSoundName());
    }

    private final void postGroupSummary(String group, String childTag, android.app.Notification childNotification) {
        NotificationCompat.Builder builder;
        String channelId = Build.VERSION.SDK_INT >= 26 ? childNotification.getChannelId() : null;
        if (channelId != null) {
            builder = new NotificationCompat.Builder(this.context, channelId);
        } else {
            builder = new NotificationCompat.Builder(this.context);
        }
        Icon smallIcon = childNotification.getSmallIcon();
        IconCompat iconCompatCreateFromIcon = smallIcon != null ? IconCompat.createFromIcon(this.context, smallIcon) : null;
        if (iconCompatCreateFromIcon != null) {
            builder.setSmallIcon(iconCompatCreateFromIcon);
        } else {
            builder.setSmallIcon(this.context.getApplicationInfo().icon);
        }
        List<StatusBarNotification> activeNotifications = this.notificationManager.getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : activeNotifications) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
            Companion companion = INSTANCE;
            Intrinsics.checkNotNull(statusBarNotification);
            if (!companion.isGroupSummary(statusBarNotification) && Intrinsics.areEqual(statusBarNotification.getNotification().getGroup(), group) && !Intrinsics.areEqual(statusBarNotification.getTag(), childTag)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CharSequence contentTitle = NotificationCompat.getContentTitle(((StatusBarNotification) it.next()).getNotification());
            if (contentTitle != null) {
                arrayList2.add(contentTitle);
            }
        }
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        Iterator it2 = CollectionsKt.plus((Collection) arrayList2, (Iterable) CollectionsKt.listOfNotNull(NotificationCompat.getContentTitle(childNotification))).iterator();
        while (it2.hasNext()) {
            inboxStyle.addLine((CharSequence) it2.next());
        }
        android.app.Notification notificationBuild = builder.setContentTitle(this.context.getApplicationInfo().loadLabel(this.context.getPackageManager())).setStyle(inboxStyle).setGroup(group).setGroupSummary(true).setGroupAlertBehavior(2).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        this.notificationManager.notify(group + GROUP_SUMMARY_TAG_SUFFIX, GROUP_SUMMARY_NOTIFICATION_ID, notificationBuild);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void cleanUpOrphanedGroupSummaries$default(ExpoPresentationDelegate expoPresentationDelegate, Set set, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cleanUpOrphanedGroupSummaries");
        }
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        expoPresentationDelegate.cleanUpOrphanedGroupSummaries(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanUpOrphanedGroupSummaries(Set<kotlin.Pair<String, Integer>> cancelled) {
        List<StatusBarNotification> activeNotifications = this.notificationManager.getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : activeNotifications) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
            if (!cancelled.contains(TuplesKt.to(statusBarNotification.getTag(), Integer.valueOf(statusBarNotification.getId())))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList<StatusBarNotification> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            StatusBarNotification statusBarNotification2 = (StatusBarNotification) obj2;
            Companion companion = INSTANCE;
            Intrinsics.checkNotNull(statusBarNotification2);
            if (companion.isGroupSummary(statusBarNotification2)) {
                arrayList3.add(obj2);
            }
        }
        for (StatusBarNotification statusBarNotification3 : arrayList3) {
            String group = statusBarNotification3.getNotification().getGroup();
            if (group != null) {
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            StatusBarNotification statusBarNotification4 = (StatusBarNotification) it.next();
                            Companion companion2 = INSTANCE;
                            Intrinsics.checkNotNull(statusBarNotification4);
                            if (!companion2.isGroupSummary(statusBarNotification4) && Intrinsics.areEqual(statusBarNotification4.getNotification().getGroup(), group)) {
                                break;
                            }
                        }
                    }
                }
                this.notificationManager.cancel(statusBarNotification3.getTag(), statusBarNotification3.getId());
                break;
            }
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public Collection<Notification> getAllPresentedNotifications() {
        List<StatusBarNotification> activeNotifications = this.notificationManager.getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (Object obj : activeNotifications) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
            Companion companion = INSTANCE;
            Intrinsics.checkNotNull(statusBarNotification);
            if (!companion.isGroupSummary(statusBarNotification)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (StatusBarNotification statusBarNotification2 : arrayList) {
            Intrinsics.checkNotNull(statusBarNotification2);
            Notification notification = getNotification(statusBarNotification2);
            if (notification != null) {
                arrayList2.add(notification);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$dismissNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$dismissNotifications$1", f = "ExpoPresentationDelegate.kt", i = {0, 0}, l = {347}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"})
    static final class C09221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Collection<String> $identifiers;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ExpoPresentationDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09221(Collection<String> collection, ExpoPresentationDelegate expoPresentationDelegate, Continuation<? super C09221> continuation) {
            super(2, continuation);
            this.$identifiers = collection;
            this.this$0 = expoPresentationDelegate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09221(this.$identifiers, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Collection<String> collection;
            Mutex mutex;
            final ExpoPresentationDelegate expoPresentationDelegate;
            Object next;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = ExpoPresentationDelegate.presentationMutex;
                collection = this.$identifiers;
                ExpoPresentationDelegate expoPresentationDelegate2 = this.this$0;
                this.L$0 = mutex2;
                this.L$1 = collection;
                this.L$2 = expoPresentationDelegate2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                expoPresentationDelegate = expoPresentationDelegate2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                expoPresentationDelegate = (ExpoPresentationDelegate) this.L$2;
                collection = (Collection) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Lazy lazy = LazyKt.lazy(new Function0() { // from class: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$dismissNotifications$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return expoPresentationDelegate.getAllPresentedNotifications();
                    }
                });
                for (String str : collection) {
                    Pair<String, Integer> notificationIdentifier = ExpoPresentationDelegate.INSTANCE.parseNotificationIdentifier(str);
                    if (notificationIdentifier != null) {
                        NotificationManagerCompat notificationManagerCompat = expoPresentationDelegate.notificationManager;
                        String str2 = (String) notificationIdentifier.first;
                        Object second = notificationIdentifier.second;
                        Intrinsics.checkNotNullExpressionValue(second, "second");
                        notificationManagerCompat.cancel(str2, ((Number) second).intValue());
                        linkedHashSet.add(TuplesKt.to(notificationIdentifier.first, notificationIdentifier.second));
                    } else {
                        Iterator<T> it = invokeSuspend$lambda$4$lambda$1(lazy).iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.areEqual(((Notification) next).getNotificationRequest().getIdentifier(), str));
                        Notification notification = (Notification) next;
                        int notifyId = expoPresentationDelegate.getNotifyId(notification != null ? notification.getNotificationRequest() : null);
                        expoPresentationDelegate.notificationManager.cancel(str, notifyId);
                        linkedHashSet.add(TuplesKt.to(str, Boxing.boxInt(notifyId)));
                    }
                }
                expoPresentationDelegate.cleanUpOrphanedGroupSummaries(linkedHashSet);
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }

        private static final Collection<Notification> invokeSuspend$lambda$4$lambda$1(Lazy<? extends Collection<? extends Notification>> lazy) {
            return (Collection) lazy.getValue();
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissNotifications(Collection<String> identifiers) throws InterruptedException {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        BuildersKt__BuildersKt.runBlocking$default(null, new C09221(identifiers, this, null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$dismissAllNotifications$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$dismissAllNotifications$1", f = "ExpoPresentationDelegate.kt", i = {0, 0}, l = {347}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoPresentationDelegate.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            ExpoPresentationDelegate expoPresentationDelegate;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = ExpoPresentationDelegate.presentationMutex;
                ExpoPresentationDelegate expoPresentationDelegate2 = ExpoPresentationDelegate.this;
                this.L$0 = mutex2;
                this.L$1 = expoPresentationDelegate2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                expoPresentationDelegate = expoPresentationDelegate2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                expoPresentationDelegate = (ExpoPresentationDelegate) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                expoPresentationDelegate.notificationManager.cancelAll();
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissAllNotifications() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    static /* synthetic */ Object createNotification$suspendImpl(ExpoPresentationDelegate expoPresentationDelegate, Notification notification, NotificationBehaviorRecord notificationBehaviorRecord, Continuation<? super android.app.Notification> continuation) {
        ExpoNotificationBuilder expoNotificationBuilder = new ExpoNotificationBuilder(expoPresentationDelegate.context, notification, new SharedPreferencesNotificationCategoriesStore(expoPresentationDelegate.context));
        expoNotificationBuilder.setAllowedBehavior(notificationBehaviorRecord);
        return expoNotificationBuilder.build(continuation);
    }

    protected Notification getNotification(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "statusBarNotification");
        android.app.Notification notification = statusBarNotification.getNotification();
        byte[] byteArray = notification.extras.getByteArray(ExpoNotificationBuilder.EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY);
        if (byteArray != null) {
            try {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                NotificationRequest notificationRequestCreateFromParcel = NotificationRequest.CREATOR.createFromParcel(parcelObtain);
                Intrinsics.checkNotNullExpressionValue(notificationRequestCreateFromParcel, "createFromParcel(...)");
                parcelObtain.recycle();
                return new Notification(notificationRequestCreateFromParcel, new Date(statusBarNotification.getPostTime()));
            } catch (Exception unused) {
                Log.e(INTERNAL_IDENTIFIER_SCHEME, "Could not unmarshall NotificationRequest from (" + statusBarNotification.getTag() + ", " + statusBarNotification.getId() + ").");
            }
        }
        NotificationContent.Builder builder = new NotificationContent.Builder();
        CharSequence contentTitle = NotificationCompat.getContentTitle(notification);
        NotificationContent.Builder title = builder.setTitle(contentTitle != null ? contentTitle.toString() : null);
        CharSequence contentText = NotificationCompat.getContentText(notification);
        NotificationContent.Builder text = title.setText(contentText != null ? contentText.toString() : null);
        CharSequence subText = NotificationCompat.getSubText(notification);
        NotificationContent.Builder sticky = text.setSubtitle(subText != null ? subText.toString() : null).setAutoDismiss(NotificationCompat.getAutoCancel(notification)).setSticky(NotificationCompat.getOngoing(notification));
        String group = NotificationCompat.getGroup(notification);
        if (group == null || Intrinsics.areEqual(group, NotificationCompat.GROUP_KEY_SILENT)) {
            group = null;
        }
        NotificationContent.Builder sound = sticky.setGroup(group).setPriority(NotificationPriority.fromNativeValue(notification.priority)).setVibrationPattern(notification.vibrate).setSound(notification.sound);
        Bundle extras = notification.extras;
        Intrinsics.checkNotNullExpressionValue(extras, "extras");
        return new Notification(new NotificationRequest(INSTANCE.getInternalIdentifierKey(statusBarNotification), sound.setBody(fromBundle(extras)).build(), null), new Date(statusBarNotification.getPostTime()));
    }

    protected JSONObject fromBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
            } catch (JSONException e) {
                Log.d(INTERNAL_IDENTIFIER_SCHEME, "Error encountered while serializing Android notification extras: " + str + " -> " + bundle.get(str), e);
            }
        }
        return jSONObject;
    }
}
