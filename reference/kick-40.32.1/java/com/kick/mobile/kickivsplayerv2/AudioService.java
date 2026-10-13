package com.kick.mobile.kickivsplayerv2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.horcrux.svg.TSpanView$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudioService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002¨\u0006\u0019"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/AudioService;", "Landroid/app/Service;", "<init>", "()V", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "promoteToForeground", "", "onDestroy", "onTaskRemoved", "rootIntent", "onBind", "Landroid/os/IBinder;", "buildNotification", "Landroid/app/Notification;", "buildContentIntent", "Landroid/app/PendingIntent;", "createNotificationChannel", "Companion", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioService extends Service {
    private static final String CHANNEL_ID = "ivs_audio_channel";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "KickIvsPlayer";
    private static volatile boolean isForegroundStarted;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: compiled from: AudioService.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/AudioService$Companion;", "", "<init>", "()V", "NOTIFICATION_ID", "", "CHANNEL_ID", "", "TAG", "isForegroundStarted", "", ViewProps.START, "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "stop", "logForegroundServiceException", "message", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AudioService.isForegroundStarted) {
                return;
            }
            try {
                Context applicationContext = context.getApplicationContext();
                applicationContext.startService(new Intent(applicationContext, (Class<?>) AudioService.class));
            } catch (Exception e) {
                logForegroundServiceException("Failed to start audio service", e);
            }
        }

        public final void stop(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AudioService.isForegroundStarted = false;
            Context applicationContext = context.getApplicationContext();
            applicationContext.stopService(new Intent(applicationContext, (Class<?>) AudioService.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logForegroundServiceException(String message, Exception e) {
            if (Build.VERSION.SDK_INT >= 31 && TSpanView$$ExternalSyntheticApiModelOutline0.m11715m((Object) e)) {
                Log.e(AudioService.TAG, "ForegroundServiceStartNotAllowedException: " + e.getMessage());
                return;
            }
            Log.e(AudioService.TAG, message + ": " + e.getMessage(), e);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        if (promoteToForeground()) {
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (promoteToForeground()) {
            return 2;
        }
        stopSelf(startId);
        return 2;
    }

    private final boolean promoteToForeground() {
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                ServiceCompat.startForeground(this, 1, buildNotification(), 2);
            } else {
                startForeground(1, buildNotification());
            }
            isForegroundStarted = true;
            return true;
        } catch (Exception e) {
            isForegroundStarted = false;
            INSTANCE.logForegroundServiceException("Failed to promote audio service", e);
            return false;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (isForegroundStarted) {
            isForegroundStarted = false;
            stopForeground(1);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        KickIvsPlayerV2Manager kickIvsPlayerV2Manager = KickIvsPlayerV2Manager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        kickIvsPlayerV2Manager.onTaskRemoved(applicationContext);
        stopSelf();
        super.onTaskRemoved(rootIntent);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0030  */
    private final Notification buildNotification() {
        String str;
        int identifier = getResources().getIdentifier("ic_launcher_foreground", "mipmap", getPackageName());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        String title = KickIvsPlayerV2Manager.INSTANCE.getTitle();
        if (title == null) {
            title = "Kick";
        } else {
            if (StringsKt.isBlank(title)) {
                title = null;
            }
            if (title == null) {
                title = "Kick";
            }
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(title);
        String subtitle = KickIvsPlayerV2Manager.INSTANCE.getSubtitle();
        if (subtitle == null) {
            str = "Audio playing";
        } else {
            str = StringsKt.isBlank(subtitle) ? null : subtitle;
            if (str == null) {
                str = "Audio playing";
            }
        }
        NotificationCompat.Builder priority = contentTitle.setContentText(str).setPriority(-1);
        if (identifier == 0) {
            identifier = android.R.drawable.ic_media_play;
        }
        Notification notificationBuild = priority.setSmallIcon(identifier).setOngoing(true).setSilent(true).setContentIntent(buildContentIntent()).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final PendingIntent buildContentIntent() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(335544320);
        return PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            TSpanView$$ExternalSyntheticApiModelOutline0.m11717m$1();
            NotificationChannel notificationChannelM = TSpanView$$ExternalSyntheticApiModelOutline0.m(CHANNEL_ID, "IVS Audio Playback", 2);
            notificationChannelM.setSound(null, null);
            notificationChannelM.enableLights(false);
            notificationChannelM.enableVibration(false);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannelM);
            }
        }
    }
}
