package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzbq;
import com.google.android.gms.internal.cast.zzbx;
import com.google.android.gms.internal.cast.zzce;
import com.google.android.gms.internal.cast.zzee;
import com.google.android.gms.internal.cast.zzek;
import com.google.android.gms.internal.cast.zzwt;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class CastContext {
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    private static final Logger zzb = new Logger("CastContext");
    private static final Object zzc = new Object();
    private static volatile CastContext zzd;
    final com.google.android.gms.internal.cast.zzax zza;
    private final Context zze;
    private final zzah zzf;
    private final SessionManager zzg;
    private final zzaa zzh;
    private final PrecacheManager zzi;
    private final MediaNotificationManager zzj;
    private final CastOptions zzk;
    private final com.google.android.gms.cast.internal.zzn zzl;
    private final zzbx zzm;
    private final zzbq zzn;
    private final List zzo;
    private final zzce zzp;
    private com.google.android.gms.internal.cast.zzba zzq;
    private CastReasonCodes zzr;

    private CastContext(Context context, CastOptions castOptions, List list, zzbx zzbxVar, com.google.android.gms.cast.internal.zzn zznVar) throws ModuleUnavailableException {
        this.zze = context;
        this.zzk = castOptions;
        this.zzm = zzbxVar;
        this.zzl = zznVar;
        this.zzo = list;
        zzbq zzbqVar = new zzbq(context);
        this.zzn = zzbqVar;
        zzce zzceVarZzt = zzbxVar.zzt();
        this.zzp = zzceVarZzt;
        zzi();
        Map mapZzh = zzh();
        castOptions.zzg(new zzl(1));
        try {
            zzah zzahVarZza = com.google.android.gms.internal.cast.zzay.zza(context, castOptions, zzbxVar, mapZzh);
            this.zzf = zzahVarZza;
            try {
                this.zzh = new zzaa(zzahVarZza.zzh());
                try {
                    SessionManager sessionManager = new SessionManager(zzahVarZza.zzg(), context);
                    this.zzg = sessionManager;
                    this.zzj = new MediaNotificationManager(sessionManager);
                    this.zzi = new PrecacheManager(castOptions, sessionManager, zznVar);
                    if (zzceVarZzt != null) {
                        zzceVarZzt.zza(sessionManager);
                    }
                    zzek zzekVar = new zzek(context, zzwt.zza(Executors.newFixedThreadPool(3)));
                    new Logger("BaseNetUtils");
                    zzekVar.zza();
                    com.google.android.gms.internal.cast.zzax zzaxVar = new com.google.android.gms.internal.cast.zzax();
                    this.zza = zzaxVar;
                    try {
                        zzahVarZza.zzf(zzaxVar);
                        zzaxVar.zzf(zzbqVar.zza);
                        if (!castOptions.zze().isEmpty()) {
                            Logger logger = zzb;
                            String strValueOf = String.valueOf(castOptions.zze());
                            String.valueOf(strValueOf);
                            logger.i("Setting Route Discovery for appIds: ".concat(String.valueOf(strValueOf)), new Object[0]);
                            zzbqVar.zzf(castOptions.zze());
                        }
                        zznVar.zzb(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS"}).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzg
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final /* synthetic */ void onSuccess(Object obj) {
                                this.zza.zze((Bundle) obj);
                            }
                        });
                        zznVar.zzd(new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"}).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzh
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final /* synthetic */ void onSuccess(Object obj) {
                                this.zza.zzf((Bundle) obj);
                            }
                        });
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e);
                    }
                } catch (RemoteException e2) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e2);
                }
            } catch (RemoteException e3) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e3);
            }
        } catch (RemoteException e4) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e4);
        }
    }

    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return zzd;
    }

    public static CastContext zza(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e) {
            zzb.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e);
            return null;
        }
    }

    public static int zzb(int i) {
        if (zzd != null) {
            return zzd.getCastReasonCodeForCastStatusCode(i);
        }
        return 0;
    }

    static /* synthetic */ CastContext zzd(Context context, CastOptions castOptions, OptionsProvider optionsProvider, zzbx zzbxVar, com.google.android.gms.cast.internal.zzn zznVar) {
        synchronized (zzc) {
            if (zzd == null) {
                zzd = new CastContext(context, castOptions, optionsProvider.getAdditionalSessionProviders(context), zzbxVar, zznVar);
            }
        }
        return zzd;
    }

    private static OptionsProvider zzg(Context context) throws IllegalStateException {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zzb.e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString(OPTIONS_PROVIDER_CLASS_NAME_KEY);
            if (string != null) {
                return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(null).newInstance(null);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }

    private final Map zzh() {
        HashMap map = new HashMap();
        com.google.android.gms.internal.cast.zzba zzbaVar = this.zzq;
        if (zzbaVar != null) {
            map.put(zzbaVar.getCategory(), zzbaVar.zza());
        }
        List<SessionProvider> list = this.zzo;
        if (list != null) {
            for (SessionProvider sessionProvider : list) {
                Preconditions.checkNotNull(sessionProvider, "Additional SessionProvider must not be null.");
                String strCheckNotEmpty = Preconditions.checkNotEmpty(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!map.containsKey(strCheckNotEmpty), String.format("SessionProvider for category %s already added", strCheckNotEmpty));
                map.put(strCheckNotEmpty, sessionProvider.zza());
            }
        }
        return map;
    }

    @RequiresNonNull({"castOptions", "mediaRouter", "appContext"})
    private final void zzi() {
        CastOptions castOptions = this.zzk;
        if (TextUtils.isEmpty(castOptions.getReceiverApplicationId())) {
            this.zzq = null;
        } else {
            this.zzq = new com.google.android.gms.internal.cast.zzba(this.zze, castOptions, this.zzm);
        }
    }

    @Deprecated
    public void addAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException, NullPointerException {
    }

    public void addCastStateListener(CastStateListener castStateListener) throws IllegalStateException, NullPointerException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener);
        this.zzg.zzb(castStateListener);
    }

    public void addSessionTransferCallback(SessionTransferCallback sessionTransferCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        this.zzm.zzr(sessionTransferCallback);
    }

    public CastOptions getCastOptions() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public int getCastReasonCodeForCastStatusCode(int i) {
        CastReasonCodes castReasonCodes = this.zzr;
        if (castReasonCodes != null) {
            return castReasonCodes.zza(i);
        }
        zzb.w("castReasonCodes hasn't been initialized yet", new Object[0]);
        return 0;
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg.zza();
    }

    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public MediaRouteSelector getMergedSelector() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return MediaRouteSelector.fromBundle(this.zzf.zze());
        } catch (RemoteException e) {
            zzb.d(e, "Unable to call %s on %s.", "getMergedSelectorAsBundle", "zzah");
            return null;
        }
    }

    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    public SessionManager getSessionManager() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    @Deprecated
    public boolean isAppVisible() throws IllegalStateException {
        return false;
    }

    @Deprecated
    public boolean onDispatchVolumeKeyEventBeforeJellyBean(KeyEvent keyEvent) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return false;
    }

    @Deprecated
    public void removeAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException {
    }

    public void removeCastStateListener(CastStateListener castStateListener) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (castStateListener == null) {
            return;
        }
        this.zzg.zzc(castStateListener);
    }

    public void removeSessionTransferCallback(SessionTransferCallback sessionTransferCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        this.zzm.zzs(sessionTransferCallback);
    }

    public void setLaunchCredentialsData(CredentialsData credentialsData) {
        CastOptions castOptions = this.zzk;
        LaunchOptions.Builder builder = new LaunchOptions.Builder(castOptions.getLaunchOptions());
        builder.setCredentialsData(credentialsData);
        castOptions.zzb(builder.build());
        zzi();
    }

    public void setReceiverApplicationId(String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastOptions castOptions = this.zzk;
        if (TextUtils.equals(str, castOptions.getReceiverApplicationId())) {
            return;
        }
        castOptions.zza(str);
        zzi();
        try {
            this.zzf.zzi(str, zzh());
        } catch (RemoteException e) {
            zzb.d(e, "Unable to call %s on %s.", "setReceiverApplicationId", "zzah");
        }
        zzo zzoVar = new zzo();
        zzoVar.zza(getCastReasonCodeForCastStatusCode(2423));
        zzoVar.zzb(2423);
        zzp zzpVarZzc = zzoVar.zzc();
        Context context = this.zze;
        zzee.zza(context, this.zzk, this.zza).zzb(zzpVarZzc);
        CastButtonFactory.zza(context);
    }

    public final zzaa zzc() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    final /* synthetic */ void zze(Bundle bundle) {
        if (com.google.android.gms.internal.cast.zzj.zza) {
            com.google.android.gms.internal.cast.zzj.zza(this.zze, this.zzl, this.zzg, this.zzp, this.zza).zzb(bundle);
        }
    }

    final /* synthetic */ void zzf(Bundle bundle) {
        this.zzr = new CastReasonCodes(bundle);
    }

    public static CastContext getSharedInstance(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzd == null) {
            synchronized (zzc) {
                if (zzd == null) {
                    Context applicationContext = context.getApplicationContext();
                    OptionsProvider optionsProviderZzg = zzg(applicationContext);
                    CastOptions castOptions = optionsProviderZzg.getCastOptions(applicationContext);
                    com.google.android.gms.cast.internal.zzn zznVar = new com.google.android.gms.cast.internal.zzn(applicationContext);
                    try {
                        zzd = new CastContext(applicationContext, castOptions, optionsProviderZzg.getAdditionalSessionProviders(applicationContext), new zzbx(applicationContext, MediaRouter.getInstance(applicationContext), castOptions, zznVar), zznVar);
                    } catch (ModuleUnavailableException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return zzd;
    }

    public static Task<CastContext> getSharedInstance(Context context, Executor executor) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzd == null) {
            final Context applicationContext = context.getApplicationContext();
            final OptionsProvider optionsProviderZzg = zzg(applicationContext);
            final CastOptions castOptions = optionsProviderZzg.getCastOptions(applicationContext);
            final com.google.android.gms.cast.internal.zzn zznVar = new com.google.android.gms.cast.internal.zzn(applicationContext);
            final zzbx zzbxVar = new zzbx(applicationContext, MediaRouter.getInstance(applicationContext), castOptions, zznVar);
            return Tasks.call(executor, new Callable() { // from class: com.google.android.gms.cast.framework.zzi
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return CastContext.zzd(applicationContext, castOptions, optionsProviderZzg, zzbxVar, zznVar);
                }
            });
        }
        return Tasks.forResult(zzd);
    }
}
