package com.google.android.gms.cast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.common.util.Util$$ExternalSyntheticApiModelOutline0;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzfg;
import com.google.android.gms.internal.cast.zzfk;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class CastRemoteDisplayLocalService extends Service {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastRDLocalService");
    private static final int zzc = R.id.cast_notification_id;
    private static final Object zzd = new Object();
    private static final AtomicBoolean zze = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzv;
    private String zzf;
    private WeakReference zzg;
    private zzak zzh;
    private NotificationSettings zzi;
    private Notification zzj;
    private boolean zzk;
    private PendingIntent zzl;
    private CastDevice zzm;
    private Display zzn;
    private Context zzo;
    private ServiceConnection zzp;
    private Handler zzq;
    private MediaRouter zzr;
    private CastRemoteDisplayClient zzt;
    private boolean zzs = false;
    private final MediaRouter.Callback zzu = new zzab(this);
    private final IBinder zzw = new zzaj(this);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    public interface Callbacks {
        void onRemoteDisplayMuteStateChanged(boolean z);

        void onRemoteDisplaySessionEnded(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    public static final class NotificationSettings {
        private Notification zza;
        private PendingIntent zzb;
        private String zzc;
        private String zzd;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
        public static final class Builder {
            private final NotificationSettings zza = new NotificationSettings(null);

            public NotificationSettings build() {
                NotificationSettings notificationSettings = this.zza;
                if (notificationSettings.zza() != null) {
                    if (!TextUtils.isEmpty(notificationSettings.zze())) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    }
                    if (!TextUtils.isEmpty(notificationSettings.zzg())) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    }
                    if (notificationSettings.zzc() != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(notificationSettings.zze()) && TextUtils.isEmpty(notificationSettings.zzg()) && notificationSettings.zzc() == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return notificationSettings;
            }

            public Builder setNotification(Notification notification) {
                this.zza.zzb(notification);
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent) {
                this.zza.zzd(pendingIntent);
                return this;
            }

            public Builder setNotificationText(String str) {
                this.zza.zzh(str);
                return this;
            }

            public Builder setNotificationTitle(String str) {
                this.zza.zzf(str);
                return this;
            }
        }

        private NotificationSettings() {
            throw null;
        }

        /* synthetic */ NotificationSettings(NotificationSettings notificationSettings, byte[] bArr) {
            this.zza = notificationSettings.zza;
            this.zzb = notificationSettings.zzb;
            this.zzc = notificationSettings.zzc;
            this.zzd = notificationSettings.zzd;
        }

        /* synthetic */ NotificationSettings(byte[] bArr) {
        }

        final /* synthetic */ Notification zza() {
            return this.zza;
        }

        final /* synthetic */ void zzb(Notification notification) {
            this.zza = notification;
        }

        final /* synthetic */ PendingIntent zzc() {
            return this.zzb;
        }

        final /* synthetic */ void zzd(PendingIntent pendingIntent) {
            this.zzb = pendingIntent;
        }

        final /* synthetic */ String zze() {
            return this.zzc;
        }

        final /* synthetic */ void zzf(String str) {
            this.zzc = str;
        }

        final /* synthetic */ String zzg() {
            return this.zzd;
        }

        final /* synthetic */ void zzh(String str) {
            this.zzd = str;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    public static class Options {
        int zza = 2;

        public int getConfigPreset() {
            return this.zza;
        }

        public void setConfigPreset(int i) {
            this.zza = i;
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzd) {
            castRemoteDisplayLocalService = zzv;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzb.zzb(true);
    }

    public static void startService(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, NotificationSettings notificationSettings, Callbacks callbacks) {
        startServiceWithOptions(context, cls, str, castDevice, new Options(), notificationSettings, callbacks);
    }

    public static void startServiceWithOptions(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Callbacks callbacks) {
        Logger logger = zzb;
        logger.d("Starting Service", new Object[0]);
        synchronized (zzd) {
            if (zzv != null) {
                logger.w("An existing service had not been stopped before starting one", new Object[0]);
                zzv(true);
            }
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
            Preconditions.checkNotNull(context, "activityContext is required.");
            Preconditions.checkNotNull(cls, "serviceClass is required.");
            Preconditions.checkNotNull(str, "applicationId is required.");
            Preconditions.checkNotNull(castDevice, "device is required.");
            Preconditions.checkNotNull(options, "options is required.");
            Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
            Preconditions.checkNotNull(callbacks, "callbacks is required.");
            if (notificationSettings.zza() == null && notificationSettings.zzc() == null) {
                throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
            }
            if (zze.getAndSet(true)) {
                logger.e("Service is already being started, startService has been called twice", new Object[0]);
                return;
            }
            Intent intent = new Intent(context, cls);
            context.startService(intent);
            ConnectionTracker.getInstance().bindService(context, intent, new zzad(str, castDevice, options, notificationSettings, context, callbacks), 64);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?", e);
        }
    }

    public static void stopService() {
        zzv(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zza(boolean z) {
        zzg("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if (!z && this.zzr != null) {
            zzg("Setting default route");
            MediaRouter mediaRouter = this.zzr;
            mediaRouter.selectRoute(mediaRouter.getDefaultRoute());
        }
        if (this.zzh != null) {
            zzg("Unregistering notification receiver");
            unregisterReceiver(this.zzh);
        }
        zzg("stopRemoteDisplaySession");
        zzg("stopRemoteDisplay");
        this.zzt.stopRemoteDisplay().addOnCompleteListener(new zzai(this));
        Callbacks callbacks = (Callbacks) this.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionEnded(this);
        }
        onDismissPresentation();
        zzg("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
        if (this.zzr != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzg("removeMediaRouterCallback");
            this.zzr.removeCallback(this.zzu);
        }
        Context context = this.zzo;
        ServiceConnection serviceConnection = this.zzp;
        if (context != null && serviceConnection != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
                zzg("No need to unbind service, already unbound");
            }
        }
        this.zzp = null;
        this.zzo = null;
        this.zzf = null;
        this.zzj = null;
        this.zzn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzv(boolean z) {
        Logger logger = zzb;
        logger.d("Stopping Service", new Object[0]);
        zze.set(false);
        synchronized (zzd) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzv;
            if (castRemoteDisplayLocalService == null) {
                logger.e("Service is already being stopped", new Object[0]);
                return;
            }
            zzv = null;
            if (castRemoteDisplayLocalService.zzq != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    castRemoteDisplayLocalService.zzq.post(new zzae(castRemoteDisplayLocalService, z));
                } else {
                    castRemoteDisplayLocalService.zza(z);
                }
            }
        }
    }

    private final Notification zzw(boolean z) {
        int i;
        int i2;
        zzg("createDefaultNotification");
        String strZze = this.zzi.zze();
        String strZzg = this.zzi.zzg();
        if (z) {
            i = R.string.cast_notification_connected_message;
            i2 = R.drawable.cast_ic_notification_on;
        } else {
            i = R.string.cast_notification_connecting_message;
            i2 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(strZze)) {
            strZze = (String) getPackageManager().getApplicationLabel(getApplicationInfo());
        }
        if (TextUtils.isEmpty(strZzg)) {
            strZzg = getString(i, new Object[]{this.zzm.getFriendlyName()});
        }
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, "cast_remote_display_local_service").setContentTitle(strZze).setContentText(strZzg).setContentIntent(this.zzi.zzc()).setSmallIcon(i2).setOngoing(true);
        String string = getString(R.string.cast_notification_disconnect);
        if (this.zzl == null) {
            Preconditions.checkNotNull(this.zzo, "activityContext is required.");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent.setPackage(this.zzo.getPackageName());
            int i3 = zzfg.zza;
            this.zzl = PendingIntent.getBroadcast(this, 0, intent, 201326592);
        }
        return ongoing.addAction(android.R.drawable.ic_menu_close_clear_cancel, string, this.zzl).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
    public final void zzg(String str) {
        zzb.d("[Instance: %s] %s", this, str);
    }

    protected Display getCastRemoteDisplay() {
        return this.zzn;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzg("onBind");
        return this.zzw;
    }

    @Override // android.app.Service
    public void onCreate() {
        zzg("onCreate");
        super.onCreate();
        zzfk zzfkVar = new zzfk(getMainLooper());
        this.zzq = zzfkVar;
        zzfkVar.postDelayed(new zzac(this), 100L);
        if (this.zzt == null) {
            this.zzt = CastRemoteDisplay.getClient(this);
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            Util$$ExternalSyntheticApiModelOutline0.m10732m();
            NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("cast_remote_display_local_service", getString(R.string.cast_notification_default_channel_name), 2);
            notificationChannelM.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannelM);
        }
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        zzg("onStartCommand");
        this.zzs = true;
        return 2;
    }

    @Deprecated
    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        if (PlatformVersion.isAtLeastS()) {
            return;
        }
        Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
        Preconditions.checkNotNull(this.zzq, "Service is not ready yet.");
        this.zzq.post(new zzaf(this, notificationSettings));
    }

    final /* synthetic */ void zzc(NotificationSettings notificationSettings) {
        Preconditions.checkMainThread("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzi == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzk) {
            Preconditions.checkNotNull(notificationSettings.zza(), "notification is required.");
            Notification notificationZza = notificationSettings.zza();
            this.zzj = notificationZza;
            this.zzi.zzb(notificationZza);
        } else {
            if (notificationSettings.zza() != null) {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if (notificationSettings.zzc() != null) {
                this.zzi.zzd(notificationSettings.zzc());
            }
            if (!TextUtils.isEmpty(notificationSettings.zze())) {
                this.zzi.zzf(notificationSettings.zze());
            }
            if (!TextUtils.isEmpty(notificationSettings.zzg())) {
                this.zzi.zzh(notificationSettings.zzg());
            }
            this.zzj = zzw(true);
        }
        startForeground(zzc, this.zzj);
    }

    final /* synthetic */ void zzd(Display display) {
        if (display == null) {
            zzb.e("Cast Remote Display session created without display", new Object[0]);
            return;
        }
        this.zzn = display;
        if (this.zzk) {
            Notification notificationZzw = zzw(true);
            this.zzj = notificationZzw;
            startForeground(zzc, notificationZzw);
        }
        Callbacks callbacks = (Callbacks) this.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionStarted(this);
        }
        Preconditions.checkNotNull(this.zzn, "display is required.");
        onCreatePresentation(this.zzn);
    }

    final /* synthetic */ boolean zze(String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzg("startRemoteDisplaySession");
        Preconditions.checkMainThread("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzd) {
            if (zzv != null) {
                zzb.w("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzv = this;
            this.zzg = new WeakReference(callbacks);
            this.zzf = str;
            this.zzm = castDevice;
            this.zzo = context;
            this.zzp = serviceConnection;
            if (this.zzr == null) {
                this.zzr = MediaRouter.getInstance(getApplicationContext());
            }
            Preconditions.checkNotNull(this.zzf, "applicationId is required.");
            MediaRouteSelector mediaRouteSelectorBuild = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzf)).build();
            zzg("addMediaRouterCallback");
            this.zzr.addCallback(mediaRouteSelectorBuild, this.zzu, 4);
            this.zzj = notificationSettings.zza();
            byte[] bArr = null;
            this.zzh = new zzak(bArr);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            boolean zIsAtLeastT = PlatformVersion.isAtLeastT();
            zzak zzakVar = this.zzh;
            if (zIsAtLeastT) {
                registerReceiver(zzakVar, intentFilter, 4);
            } else {
                ContextCompat.registerReceiver(this, zzakVar, intentFilter, 2);
            }
            NotificationSettings notificationSettings2 = new NotificationSettings(notificationSettings, bArr);
            this.zzi = notificationSettings2;
            if (notificationSettings2.zza() == null) {
                this.zzk = true;
                this.zzj = zzw(false);
            } else {
                this.zzk = false;
                this.zzj = this.zzi.zza();
            }
            startForeground(zzc, this.zzj);
            zzg("startRemoteDisplay");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            Preconditions.checkNotNull(this.zzo, "activityContext is required.");
            intent.setPackage(this.zzo.getPackageName());
            int i = zzfg.zza;
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent, 67108864);
            zzag zzagVar = new zzag(this);
            Preconditions.checkNotNull(this.zzf, "applicationId is required.");
            this.zzt.zze(castDevice, this.zzf, options.getConfigPreset(), broadcast, zzagVar).addOnCompleteListener(new zzah(this));
            Callbacks callbacks2 = (Callbacks) this.zzg.get();
            if (callbacks2 == null) {
                return true;
            }
            callbacks2.onServiceCreated(this);
            return true;
        }
    }

    final /* synthetic */ void zzf() {
        Callbacks callbacks = (Callbacks) this.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
        }
        stopService();
    }

    final /* synthetic */ void zzh(String str) {
        zzb.e("[Instance: %s] %s", this, "The local service has not been been started, stopping it");
    }

    final /* synthetic */ WeakReference zzl() {
        return this.zzg;
    }

    final /* synthetic */ CastDevice zzm() {
        return this.zzm;
    }

    final /* synthetic */ void zzn(Display display) {
        this.zzn = null;
    }

    final /* synthetic */ Context zzo() {
        return this.zzo;
    }

    final /* synthetic */ void zzp(Context context) {
        this.zzo = null;
    }

    final /* synthetic */ ServiceConnection zzq() {
        return this.zzp;
    }

    final /* synthetic */ void zzr(ServiceConnection serviceConnection) {
        this.zzp = null;
    }

    final /* synthetic */ boolean zzs() {
        return this.zzs;
    }
}
