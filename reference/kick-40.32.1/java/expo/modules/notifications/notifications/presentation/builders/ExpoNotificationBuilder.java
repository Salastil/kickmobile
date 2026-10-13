package expo.modules.notifications.notifications.presentation.builders;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.notifications.notifications.SoundResolver;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.model.NotificationAction;
import expo.modules.notifications.notifications.model.NotificationBehaviorRecord;
import expo.modules.notifications.notifications.model.NotificationCategory;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.notifications.model.TextInputNotificationAction;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.delegates.SharedPreferencesNotificationCategoriesStore;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ExpoNotificationBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0004\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0004J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0015H\u0004J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u0004\u0018\u00010(8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0016\u0010-\u001a\u0004\u0018\u00010.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/builders/ExpoNotificationBuilder;", "Lexpo/modules/notifications/notifications/presentation/builders/BaseNotificationBuilder;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "store", "Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;", "<init>", "(Landroid/content/Context;Lexpo/modules/notifications/notifications/model/Notification;Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;)V", "addActionsToBuilder", "", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "categoryIdentifier", "", "buildButtonAction", "Landroidx/core/app/NotificationCompat$Action;", "action", "Lexpo/modules/notifications/notifications/model/NotificationAction;", "buildTextInputAction", "Lexpo/modules/notifications/notifications/model/TextInputNotificationAction;", "build", "Landroid/app/Notification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applySoundsAndVibrations", "content", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "marshallNotificationRequest", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "shouldPlaySound", "", "shouldVibrate", "priority", "", "getPriority", "()I", "largeIcon", "Landroid/graphics/Bitmap;", "getLargeIcon", "()Landroid/graphics/Bitmap;", "icon", "getIcon", "color", "", "getColor", "()Ljava/lang/Number;", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExpoNotificationBuilder extends BaseNotificationBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRAS_BODY_KEY = "body";
    public static final String EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY = "expo.notification_request";
    public static final String META_DATA_DEFAULT_COLOR_KEY = "expo.modules.notifications.default_notification_color";
    public static final String META_DATA_DEFAULT_ICON_KEY = "expo.modules.notifications.default_notification_icon";
    public static final String META_DATA_LARGE_ICON_KEY = "expo.modules.notifications.large_notification_icon";
    private final SharedPreferencesNotificationCategoriesStore store;

    /* JADX INFO: renamed from: expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder$build$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExpoNotificationBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder", f = "ExpoNotificationBuilder.kt", i = {0, 0, 0, 0, 0}, l = {WebmConstants.MkvEbmlElement.FLAG_LACING}, m = "build$suspendImpl", n = {"$this", "builder", "content", "requestExtras", "defaultAction"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExpoNotificationBuilder.build$suspendImpl(ExpoNotificationBuilder.this, this);
        }
    }

    @JvmStatic
    public static final Bitmap largeIconFromManifest(Context context) {
        return INSTANCE.largeIconFromManifest(context);
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public Object build(Continuation<? super Notification> continuation) {
        return build$suspendImpl(this, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoNotificationBuilder(Context context, expo.modules.notifications.notifications.model.Notification notification, SharedPreferencesNotificationCategoriesStore store) {
        super(context, notification);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public void addActionsToBuilder(NotificationCompat.Builder builder, String categoryIdentifier) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(categoryIdentifier, "categoryIdentifier");
        List<NotificationAction> listEmptyList = CollectionsKt.emptyList();
        try {
            NotificationCategory notificationCategory = this.store.getNotificationCategory(categoryIdentifier);
            if (notificationCategory != null) {
                List<NotificationAction> actions = notificationCategory.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "getActions(...)");
                listEmptyList = actions;
            }
        } catch (IOException e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("Could not read category with identifier: %s. %s", Arrays.copyOf(new Object[]{categoryIdentifier, e.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Log.e("expo-notifications", str);
        } catch (ClassNotFoundException e2) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("Could not read category with identifier: %s. %s", Arrays.copyOf(new Object[]{categoryIdentifier, e2.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            Log.e("expo-notifications", str2);
        }
        for (NotificationAction notificationAction : listEmptyList) {
            if (notificationAction instanceof TextInputNotificationAction) {
                builder.addAction(buildTextInputAction((TextInputNotificationAction) notificationAction));
            } else {
                builder.addAction(buildButtonAction(notificationAction));
            }
        }
    }

    protected final NotificationCompat.Action buildButtonAction(NotificationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(getIcon(), action.getTitle(), NotificationsService.INSTANCE.createNotificationResponseIntent(getContext(), getNotification(), action)).build();
        Intrinsics.checkNotNullExpressionValue(actionBuild, "build(...)");
        return actionBuild;
    }

    protected final NotificationCompat.Action buildTextInputAction(TextInputNotificationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        PendingIntent pendingIntentCreateNotificationResponseIntent = NotificationsService.INSTANCE.createNotificationResponseIntent(getContext(), getNotification(), action);
        RemoteInput remoteInputBuild = new RemoteInput.Builder(NotificationsService.USER_TEXT_RESPONSE_KEY).setLabel(action.getPlaceholder()).build();
        Intrinsics.checkNotNullExpressionValue(remoteInputBuild, "build(...)");
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(getIcon(), action.getTitle(), pendingIntentCreateNotificationResponseIntent).addRemoteInput(remoteInputBuild).build();
        Intrinsics.checkNotNullExpressionValue(actionBuild, "build(...)");
        return actionBuild;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object build$suspendImpl(ExpoNotificationBuilder expoNotificationBuilder, Continuation<? super Notification> continuation) {
        AnonymousClass1 anonymousClass1;
        NotificationCompat.Builder builderCreateBuilder;
        NotificationCompat.Builder builder;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = expoNotificationBuilder.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = expoNotificationBuilder.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            builderCreateBuilder = expoNotificationBuilder.createBuilder();
            builderCreateBuilder.setSmallIcon(expoNotificationBuilder.getIcon());
            builderCreateBuilder.setPriority(expoNotificationBuilder.getPriority());
            INotificationContent notificationContent = expoNotificationBuilder.getNotificationContent();
            builderCreateBuilder.setAutoCancel(notificationContent.getIsAutoDismiss());
            builderCreateBuilder.setOngoing(notificationContent.getIsSticky());
            builderCreateBuilder.setContentTitle(notificationContent.getTitle());
            builderCreateBuilder.setContentText(notificationContent.getText());
            builderCreateBuilder.setSubText(notificationContent.getSubText());
            builderCreateBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationContent.getText()));
            Number color = expoNotificationBuilder.getColor();
            if (color != null) {
                builderCreateBuilder.setColor(color.intValue());
            }
            Number badgeCount = expoNotificationBuilder.getNotificationContent().getBadgeCount();
            if (badgeCount != null) {
                builderCreateBuilder.setNumber(badgeCount.intValue());
            }
            String categoryId = expoNotificationBuilder.getNotificationContent().getCategoryId();
            if (categoryId != null) {
                expoNotificationBuilder.addActionsToBuilder(builderCreateBuilder, categoryId);
            }
            expoNotificationBuilder.applySoundsAndVibrations(notificationContent, builderCreateBuilder);
            String group = notificationContent.getGroup();
            if (group != null) {
                builderCreateBuilder.setGroup(group);
                builderCreateBuilder.setDeleteIntent(NotificationsService.INSTANCE.createGroupedNotificationDeletedIntent(expoNotificationBuilder.getContext(), expoNotificationBuilder.getNotification()));
            }
            if (notificationContent.getBody() != null) {
                Bundle extras = builderCreateBuilder.getExtras();
                Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
                extras.putString(EXTRAS_BODY_KEY, String.valueOf(notificationContent.getBody()));
                builderCreateBuilder.setExtras(extras);
            }
            Bundle bundle = new Bundle();
            NotificationRequest notificationRequest = expoNotificationBuilder.getNotification().getNotificationRequest();
            Intrinsics.checkNotNullExpressionValue(notificationRequest, "getNotificationRequest(...)");
            bundle.putByteArray(EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY, expoNotificationBuilder.marshallNotificationRequest(notificationRequest));
            builderCreateBuilder.addExtras(bundle);
            NotificationAction notificationAction = new NotificationAction(NotificationResponse.DEFAULT_ACTION_IDENTIFIER, null, true);
            builderCreateBuilder.setContentIntent(NotificationsService.INSTANCE.createNotificationResponseIntent(expoNotificationBuilder.getContext(), expoNotificationBuilder.getNotification(), notificationAction));
            if (expoNotificationBuilder.getNotificationContent().containsImage()) {
                INotificationContent notificationContent2 = expoNotificationBuilder.getNotificationContent();
                Context context = expoNotificationBuilder.getContext();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(expoNotificationBuilder);
                anonymousClass1.L$1 = builderCreateBuilder;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(notificationContent);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(bundle);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(notificationAction);
                anonymousClass1.label = 1;
                Object image = notificationContent2.getImage(context, anonymousClass1);
                if (image == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = image;
                builder = builderCreateBuilder;
            } else {
                builderCreateBuilder.setLargeIcon(expoNotificationBuilder.getLargeIcon());
            }
            Notification notificationBuild = builderCreateBuilder.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            return notificationBuild;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        builder = (NotificationCompat.Builder) anonymousClass1.L$1;
        ResultKt.throwOnFailure(obj);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        builderCreateBuilder = builder;
        Notification notificationBuild2 = builderCreateBuilder.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild2, "build(...)");
        return notificationBuild2;
    }

    private final void applySoundsAndVibrations(INotificationContent content, NotificationCompat.Builder builder) {
        boolean zShouldPlaySound = shouldPlaySound();
        boolean zShouldVibrate = shouldVibrate();
        if (!zShouldPlaySound && !zShouldVibrate) {
            builder.setSilent(true);
        }
        if (Build.VERSION.SDK_INT < 26) {
            boolean z = false;
            boolean z2 = zShouldPlaySound && content.getShouldPlayDefaultSound();
            if (zShouldVibrate && content.getShouldUseDefaultVibrationPattern()) {
                z = true;
            }
            if (z && z2) {
                Intrinsics.checkNotNull(builder.setDefaults(-1));
                return;
            }
            if (zShouldPlaySound) {
                if (content.getSoundName() != null) {
                    builder.setSound(new SoundResolver(getContext()).resolve(content.getSoundName()));
                } else if (z2) {
                    builder.setDefaults(1);
                    builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                }
            }
            if (zShouldVibrate) {
                long[] vibrationPattern = content.getVibrationPattern();
                if (vibrationPattern != null) {
                    builder.setVibrate(vibrationPattern);
                } else if (z) {
                    builder.setDefaults(2);
                }
            }
        }
    }

    protected final byte[] marshallNotificationRequest(NotificationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
            request.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not marshall notification request: " + request.getIdentifier() + ".", e);
            return null;
        }
    }

    private final boolean shouldPlaySound() {
        NotificationBehaviorRecord notificationBehavior = getNotificationBehavior();
        return (notificationBehavior != null ? notificationBehavior.getShouldPlaySound() : true) && (getNotificationContent().getShouldPlayDefaultSound() || getNotificationContent().getSoundName() != null);
    }

    private final boolean shouldVibrate() {
        NotificationBehaviorRecord notificationBehavior = getNotificationBehavior();
        return (notificationBehavior != null ? notificationBehavior.getShouldPlaySound() : true) && (getNotificationContent().getShouldUseDefaultVibrationPattern() || getNotificationContent().getVibrationPattern() != null);
    }

    private final int getPriority() {
        double dMin;
        NotificationPriority priority = getNotificationContent().getPriority();
        NotificationBehaviorRecord notificationBehavior = getNotificationBehavior();
        if (notificationBehavior == null) {
            if (priority != null) {
                return priority.getNativeValue();
            }
            return 1;
        }
        NotificationPriority priorityOverride = notificationBehavior.getPriorityOverride();
        if (priorityOverride != null) {
            return priorityOverride.getNativeValue();
        }
        if (priority == null) {
            priority = NotificationPriority.DEFAULT;
        }
        int nativeValue = priority.getNativeValue();
        if (notificationBehavior.getShouldPresentAlert()) {
            dMin = Math.max(1.0d, nativeValue);
        } else {
            dMin = Math.min(0.0d, nativeValue);
        }
        return (int) dMin;
    }

    protected final Bitmap getLargeIcon() {
        return INSTANCE.largeIconFromManifest(getContext());
    }

    protected int getIcon() {
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_ICON_KEY)) {
                return applicationInfo.metaData.getInt(META_DATA_DEFAULT_ICON_KEY);
            }
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not fetch default notification icon.", e);
        }
        return getContext().getApplicationInfo().icon;
    }

    protected Number getColor() {
        Number color = getNotificationContent().getColor();
        if (color == null) {
            color = null;
            try {
                ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_COLOR_KEY)) {
                    return Integer.valueOf(getContext().getResources().getColor(applicationInfo.metaData.getInt(META_DATA_DEFAULT_COLOR_KEY), null));
                }
            } catch (Exception e) {
                Log.e("expo-notifications", "Could not fetch default notification color.", e);
            }
        }
        return color;
    }

    /* JADX INFO: compiled from: ExpoNotificationBuilder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/builders/ExpoNotificationBuilder$Companion;", "", "<init>", "()V", "META_DATA_DEFAULT_ICON_KEY", "", "META_DATA_LARGE_ICON_KEY", "META_DATA_DEFAULT_COLOR_KEY", "EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY", "EXTRAS_BODY_KEY", "largeIconFromManifest", "Landroid/graphics/Bitmap;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bitmap largeIconFromManifest(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle == null || !bundle.containsKey(ExpoNotificationBuilder.META_DATA_LARGE_ICON_KEY)) {
                    return null;
                }
                return BitmapFactory.decodeResource(context.getResources(), bundle.getInt(ExpoNotificationBuilder.META_DATA_LARGE_ICON_KEY));
            } catch (Exception e) {
                Log.e("expo-notifications", "Could not fetch large notification icon.", e);
                return null;
            }
        }
    }
}
