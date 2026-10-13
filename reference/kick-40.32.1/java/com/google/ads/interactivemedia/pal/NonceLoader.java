package com.google.ads.interactivemedia.pal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.preference.PreferenceManager;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.common.callercontext.ContextChain;
import com.google.ads.interactivemedia.pal.utils.tcf.TcfConsentSettings;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.pal.zzaxs;
import com.google.android.gms.internal.pal.zzbx;
import com.google.android.gms.internal.pal.zzbz;
import com.google.android.gms.internal.pal.zzca;
import com.google.android.gms.internal.pal.zzcc;
import com.google.android.gms.internal.pal.zzce;
import com.google.android.gms.internal.pal.zzcf;
import com.google.android.gms.internal.pal.zzci;
import com.google.android.gms.internal.pal.zzcj;
import com.google.android.gms.internal.pal.zzck;
import com.google.android.gms.internal.pal.zzgz;
import com.google.android.gms.internal.pal.zzlp;
import com.google.android.gms.internal.pal.zzlq;
import com.google.android.gms.internal.pal.zzno;
import com.google.android.gms.internal.pal.zznp;
import com.google.android.gms.internal.pal.zzou;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.kick.mobile.kickivsplayerv2.BuildConfig;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class NonceLoader {
    public static final /* synthetic */ int zza = 0;
    private static final Random zzb = new Random();
    private final Context zzc;
    private final ConsentSettings zzd;
    private final TcfConsentSettings zze;
    private final boolean zzf;
    private final Task zzg;
    private final zzbx zzh;
    private final zzci zzi;
    private final zzci zzj;
    private final zzci zzk;
    private final zzk zzl;
    private final zzce zzm;
    private final zzu zzn;
    private final long zzo;
    private final zzp zzp;
    private long zzq;
    private final String zzr;

    static Context zza(Context context) {
        DisplayManager displayManager;
        Display display;
        if (Build.VERSION.SDK_INT >= 31 && context.isUiContext()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return (Build.VERSION.SDK_INT < 31 || (displayManager = (DisplayManager) applicationContext.getSystemService("display")) == null || (display = displayManager.getDisplay(0)) == null) ? applicationContext : applicationContext.createWindowContext(display, 2, null);
    }

    static /* synthetic */ Map zze(zzno zznoVar, Task task, Task task2, Task task3, Task task4, Task task5) {
        zznoVar.zzb((Map) zzf(task).zzd(zzae.zza).zzc(zznp.zza()));
        zznoVar.zzb(((Boolean) zzf(task).zzd(zzab.zza).zzc(false)).booleanValue() ? zznp.zza() : (zznp) zzf(task2).zzd(zzac.zza).zzc(zznp.zza()));
        zznoVar.zzb((Map) zzf(task3).zzd(zzaf.zza).zzc(zznp.zza()));
        zznoVar.zzb((Map) zzf(task4).zzd(zzag.zza).zzc(zznp.zza()));
        return zznoVar.zzd();
    }

    private static zzlq zzf(Task task) {
        return !task.isSuccessful() ? zzlq.zze() : (zzlq) task.getResult();
    }

    private static String zzg(String str) {
        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException unused) {
            Log.e("NonceGenerator", "Failed to encode the input string.");
            return "";
        }
    }

    private static String zzh(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        String.valueOf(packageName);
        return "h.3.2.2/n.android.3.2.2/".concat(String.valueOf(packageName));
    }

    private static String zzi() {
        return Integer.toString(zzb.nextInt(Integer.MAX_VALUE));
    }

    private static boolean zzj(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static boolean zzk(ConsentSettings consentSettings, TcfConsentSettings tcfConsentSettings) {
        return consentSettings.forceLimitedAds() || !tcfConsentSettings.isStorageAllowed();
    }

    public void alwaysLog() {
        this.zzn.zza();
    }

    public Task<NonceManager> loadNonceManager(final NonceRequest nonceRequest) {
        String string;
        if (nonceRequest == null) {
            this.zzn.zzc(103, zznp.zza());
            return Tasks.forException(NonceLoaderException.zza(103));
        }
        final String strZzi = zzi();
        final zzno zznoVar = new zzno();
        if (nonceRequest.descriptionURL().length() <= 500) {
            zznoVar.zza(zzx.DESCRIPTION_URL.zza(), zzg(nonceRequest.descriptionURL()));
        }
        if (nonceRequest.ppid().length() <= 200) {
            zznoVar.zza(zzx.PPID.zza(), zzg(nonceRequest.ppid()));
        }
        if (nonceRequest.playerType().length() <= 200) {
            zznoVar.zza(zzx.PLAYER_TYPE.zza(), zzg(nonceRequest.playerType()));
        }
        if (nonceRequest.playerVersion().length() <= 200) {
            zznoVar.zza(zzx.PLAYER_VERSION.zza(), zzg(nonceRequest.playerVersion()));
        }
        String str = "";
        if (nonceRequest.omidPartnerName().length() == 0 || nonceRequest.omidPartnerName().length() > 200 || nonceRequest.omidPartnerVersion().length() == 0 || nonceRequest.omidPartnerVersion().length() > 200) {
            string = "";
        } else {
            String strOmidPartnerName = nonceRequest.omidPartnerName();
            String strOmidPartnerVersion = nonceRequest.omidPartnerVersion();
            StringBuilder sb = new StringBuilder(String.valueOf(strOmidPartnerName).length() + 1 + String.valueOf(strOmidPartnerVersion).length());
            sb.append(strOmidPartnerName);
            sb.append(DomExceptionUtils.SEPARATOR);
            sb.append(strOmidPartnerVersion);
            string = sb.toString();
        }
        zznoVar.zza(zzx.OMID_PARTNER.zza(), zzg(string));
        TreeSet treeSet = new TreeSet(nonceRequest.supportedApiFrameworks());
        if (!string.isEmpty()) {
            treeSet.add(7);
        }
        String strZza = zzx.API_FRAMEWORKS.zza();
        Iterator it = treeSet.iterator();
        StringBuilder sb2 = new StringBuilder();
        zzlp.zzb(sb2, it, WebViewLogEventConsumer.DDTAGS_SEPARATOR);
        zznoVar.zza(strZza, sb2.toString());
        Integer numVideoPlayerHeight = nonceRequest.videoPlayerHeight();
        if (numVideoPlayerHeight != null) {
            String strZza2 = zzx.PLAYER_HEIGHT.zza();
            StringBuilder sb3 = new StringBuilder(numVideoPlayerHeight.toString().length());
            sb3.append(numVideoPlayerHeight);
            zznoVar.zza(strZza2, sb3.toString());
        }
        Integer numVideoPlayerWidth = nonceRequest.videoPlayerWidth();
        if (numVideoPlayerWidth != null) {
            String strZza3 = zzx.PLAYER_WIDTH.zza();
            StringBuilder sb4 = new StringBuilder(numVideoPlayerWidth.toString().length());
            sb4.append(numVideoPlayerWidth);
            zznoVar.zza(strZza3, sb4.toString());
        }
        if (numVideoPlayerHeight != null && numVideoPlayerWidth != null) {
            zznoVar.zza(zzx.ORIENTATION.zza(), numVideoPlayerHeight.intValue() <= numVideoPlayerWidth.intValue() ? "l" : ContextChain.TAG_PRODUCT);
        }
        Boolean boolSkippablesSupported = nonceRequest.skippablesSupported();
        if (boolSkippablesSupported != null) {
            zznoVar.zza(zzx.PUBLISHER_SUPPORTS_SKIP.zza(), true != boolSkippablesSupported.booleanValue() ? "0" : "1");
        }
        Boolean boolWillAdAutoPlay = nonceRequest.willAdAutoPlay();
        if (boolWillAdAutoPlay != null) {
            zznoVar.zza(zzx.PLAY_ACTIVATION.zza(), true != boolWillAdAutoPlay.booleanValue() ? "click" : "auto");
        }
        Boolean boolIconsSupported = nonceRequest.iconsSupported();
        if (boolIconsSupported != null) {
            zznoVar.zza(zzx.WTA_SUPPORTED.zza(), true != boolIconsSupported.booleanValue() ? "0" : "1");
        }
        Boolean boolWillAdPlayMuted = nonceRequest.willAdPlayMuted();
        if (boolWillAdPlayMuted != null) {
            zznoVar.zza(zzx.PLAY_MUTED.zza(), true == boolWillAdPlayMuted.booleanValue() ? "1" : "0");
        }
        Boolean boolContinuousPlayback = nonceRequest.continuousPlayback();
        if (boolContinuousPlayback != null) {
            zznoVar.zza(zzx.CONTINUOUS_PLAYBACK.zza(), true != boolContinuousPlayback.booleanValue() ? "1" : ExifInterface.GPS_MEASUREMENT_2D);
        }
        zznoVar.zza(zzx.SESSION_ID.zza(), nonceRequest.sessionId());
        final zzno zznoVar2 = new zzno();
        zznoVar2.zza(zzx.PAL_VERSION.zza(), BuildConfig.PAL_SDK_VERSION);
        String strZza4 = zzx.SDK_VERSION.zza();
        Context context = this.zzc;
        zznoVar2.zza(strZza4, zzh(context));
        zznoVar2.zza(zzx.APP_NAME.zza(), context.getApplicationContext().getPackageName());
        zznoVar2.zza(zzx.PAGE_CORRELATOR.zza(), this.zzr);
        zznoVar2.zza(zzx.AD_SPAM_CAPABILITIES.zza(), ExifInterface.GPS_MEASUREMENT_3D);
        zznoVar2.zza(zzx.SPAM_CORRELATOR.zza(), strZzi);
        String strZza5 = zzx.USER_AGENT.zza();
        boolean zZzj = zzj(context);
        String packageName = context.getApplicationContext().getPackageName();
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo.versionName != null) {
                str = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        String str2 = str;
        String str3 = true != zZzj ? GetDeviceInfoUseCaseKt.PLATFORM : "Android TV";
        String str4 = Build.VERSION.RELEASE;
        String str5 = Build.MODEL;
        Locale locale = Locale.getDefault();
        String str6 = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
        String str7 = Build.ID;
        String.valueOf(str7);
        zznoVar2.zza(strZza5, zzg(String.format("%s/%s (%s %s; %s; %s; %s)", packageName, str2, str3, str4, str6, str5, "Build/".concat(String.valueOf(str7)))));
        if (zzj(context)) {
            zznoVar2.zza(zzx.CTV.zza(), "1");
        }
        if (this.zzd.forceLimitedAds()) {
            zznoVar2.zza(zzx.LTD.zza(), "1");
        }
        zzlq zzlqVarZza = this.zzl.zza();
        if (zzlqVarZza.zza()) {
            zzj zzjVar = (zzj) zzlqVarZza.zzb();
            zznoVar2.zza(zzx.ESSENTIAL_ONLY_ID.zza(), zzjVar.zza());
            zznoVar2.zza(zzx.ESSENTIAL_ONLY_ID_TIMESTAMP_SEC.zza(), Long.toString(zzjVar.zzb()));
        }
        zzci zzciVar = this.zzj;
        zzci zzciVar2 = this.zzk;
        zzbx zzbxVar = this.zzh;
        zzci zzciVar3 = this.zzi;
        final Task taskZzb = zzciVar.zzb();
        final Task taskZzb2 = zzciVar2.zzb();
        final Task taskZzb3 = zzbxVar.zzb();
        final Task taskZzb4 = zzciVar3.zzb();
        final Task taskContinueWith = Tasks.whenAllComplete((Task<?>[]) new Task[]{taskZzb, taskZzb2, taskZzb3, taskZzb4}).continueWith(new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzaa
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return NonceLoader.zze(zznoVar2, taskZzb, taskZzb2, taskZzb3, taskZzb4, task);
            }
        });
        PlatformSignalCollector platformSignalCollectorZzb = nonceRequest.zzb();
        Task<Map<String, String>> taskForResult = platformSignalCollectorZzb == null ? Tasks.forResult(zznp.zza()) : platformSignalCollectorZzb.collectSignals(context, zzv.zza());
        final Task taskZzb5 = this.zzm.zzb();
        final long jCurrentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
        Task[] taskArr = {taskContinueWith, taskZzb5, taskForResult};
        final Task<Map<String, String>> task = taskForResult;
        return Tasks.whenAllComplete((Task<?>[]) taskArr).continueWith(zzv.zza(), new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzy
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                return this.zza.zzc(zznoVar, taskContinueWith, task, taskZzb5, nonceRequest, strZzi, jCurrentTimeMillis, task2);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.ads.interactivemedia.pal.zzz
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.zza.zzd(exc);
            }
        });
    }

    public void release() {
        this.zzh.zzd();
        this.zzi.zzd();
        this.zzj.zzd();
        this.zzk.zzd();
        this.zzm.zzd();
    }

    final /* synthetic */ void zzb(Task task) {
        this.zzq = DefaultClock.getInstance().currentTimeMillis();
    }

    final /* synthetic */ NonceManager zzc(zzno zznoVar, Task task, Task task2, Task task3, NonceRequest nonceRequest, String str, long j, Task task4) throws NonceLoaderException {
        zznoVar.zzb((Map) task.getResult());
        if (task2.isSuccessful()) {
            zznoVar.zzb((Map) task2.getResult());
        }
        zzcc zzccVar = (zzcc) ((zzlq) task3.getResult()).zzb();
        zznp zznpVarZzd = zznoVar.zzd();
        StringBuilder sb = new StringBuilder();
        zzou it = zznpVarZzd.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue() != null && ((String) entry.getValue()).length() != 0) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        String strZza = zzccVar.zza(sb.toString());
        Integer numZza = nonceRequest.zza();
        if (numZza != null && strZza.length() > numZza.intValue()) {
            Log.e("NonceGenerator", "Nonce length limit crossed.");
            throw NonceLoaderException.zza(104);
        }
        zzav zzavVar = new zzav(this.zzp, str);
        int length = strZza.length();
        zzg zzgVar = new zzg();
        zzck zzckVar = zzck.zza;
        zzgVar.zza(zzckVar);
        long j2 = this.zzo;
        zzgVar.zzb(zzck.zza(j - j2));
        zzgVar.zzc(zzck.zza(DefaultClock.getInstance().currentTimeMillis() - j2));
        zzgVar.zzd(zzckVar);
        zzgVar.zze(zzck.zza(this.zzq - j2));
        zzgVar.zzf(length);
        this.zzn.zzb(zzgVar.zzg(), nonceRequest, this.zzd, this.zze, this.zzf);
        return new NonceManager(zza(this.zzc), zzw.zza(), zzv.zza(), this.zzg, zzavVar, strZza);
    }

    final /* synthetic */ void zzd(Exception exc) {
        boolean z = exc instanceof NonceLoaderException;
        zzu zzuVar = this.zzn;
        if (z) {
            zzuVar.zzc(((NonceLoaderException) exc).zzb(), zznp.zza());
        } else {
            zzuVar.zzc(100, zznp.zza());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonceLoader(Context context, ConsentSettings consentSettings) {
        this(context, consentSettings, GoogleAdManagerSettings.builder().build(), new zzw(), new zzv(), zzi());
        context.getClass();
        consentSettings.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonceLoader(Context context, ConsentSettings consentSettings, GoogleAdManagerSettings googleAdManagerSettings) {
        this(context, consentSettings, googleAdManagerSettings, new zzw(), new zzv(), zzi());
        context.getClass();
        consentSettings.getClass();
        googleAdManagerSettings.getClass();
    }

    private NonceLoader(Context context, ConsentSettings consentSettings, GoogleAdManagerSettings googleAdManagerSettings, zzaxs zzaxsVar, zzaxs zzaxsVar2, String str) {
        boolean zBooleanValue;
        Context context2;
        zzu zzuVar;
        zzci zzcfVar;
        zzci zzcfVar2;
        zzci zzcfVar3;
        String strZzh = zzh(context);
        zzc zzcVar = new zzc();
        zzcVar.zza(BuildConfig.PAL_SDK_VERSION);
        zzcVar.zzb(strZzh);
        zzcVar.zzc(str);
        zzp zzpVar = new zzp(zzcVar.zzd());
        TcfConsentSettings tcfConsentSettings = new TcfConsentSettings(PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
        boolean zZzj = zzj(context);
        final Context applicationContext = context.getApplicationContext();
        final ExecutorService executorServiceZza = zzv.zza();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executorServiceZza.execute(new Runnable() { // from class: com.google.ads.interactivemedia.pal.zzad
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                int i = NonceLoader.zza;
                com.google.android.gms.internal.pal.zzj zzjVarZzg = com.google.android.gms.internal.pal.zzk.zzg();
                zzjVarZzg.zzd(2);
                zzjVarZzg.zza("h.3.2.2/n.android.3.2.2");
                zzjVarZzg.zzb(false);
                zzjVarZzg.zzc(false);
                taskCompletionSource.setResult(new zzgz(applicationContext, executorServiceZza, (com.google.android.gms.internal.pal.zzk) zzjVarZzg.zzal()));
            }
        });
        Task task = taskCompletionSource.getTask();
        zzu zzuVar2 = new zzu(zzpVar);
        zzbx zzbxVar = new zzbx(zzw.zza(), zzv.zza(), zza(context), task, zzuVar2);
        if (zzk(consentSettings, tcfConsentSettings)) {
            zBooleanValue = false;
        } else {
            Boolean boolZza = consentSettings.zza();
            zBooleanValue = boolZza == null ? zZzj : boolZza.booleanValue();
        }
        zzaq zzaqVar = zZzj ? zzaq.GTV : zzaq.MOBILE;
        if (zBooleanValue) {
            context2 = context;
            zzuVar = zzuVar2;
            zzcfVar = new zzcj(zzw.zza(), zzv.zza(), context2, zzuVar, zzaqVar);
        } else {
            context2 = context;
            zzuVar = zzuVar2;
            zzcfVar = new zzcf(zzw.zza(), zzv.zza());
        }
        if (!zzk(consentSettings, tcfConsentSettings) && !consentSettings.directedForChildOrUnknownAge().booleanValue()) {
            zzcfVar2 = new zzbz(zzw.zza(), zzv.zza(), context2);
        } else {
            zzcfVar2 = new zzcf(zzw.zza(), zzv.zza());
        }
        if (!zzk(consentSettings, tcfConsentSettings)) {
            zzcfVar3 = new zzca(zzw.zza(), zzv.zza(), context2);
        } else {
            zzcfVar3 = new zzcf(zzw.zza(), zzv.zza());
        }
        zzk zzkVar = new zzk(PreferenceManager.getDefaultSharedPreferences(context2.getApplicationContext()), googleAdManagerSettings, consentSettings, tcfConsentSettings);
        zzce zzceVar = new zzce(zzw.zza(), zzv.zza());
        this.zzq = -1L;
        this.zzc = context2;
        this.zzd = consentSettings;
        this.zze = tcfConsentSettings;
        this.zzf = zZzj;
        this.zzg = task;
        this.zzh = zzbxVar;
        this.zzi = zzcfVar;
        this.zzj = zzcfVar2;
        this.zzk = zzcfVar3;
        this.zzl = zzkVar;
        this.zzm = zzceVar;
        this.zzn = zzuVar;
        this.zzp = zzpVar;
        this.zzr = str;
        this.zzo = DefaultClock.getInstance().currentTimeMillis();
        zzceVar.zzc();
        zzbxVar.zzc();
        zzcfVar2.zzc();
        zzcfVar3.zzc();
        zzcfVar.zzc();
        Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcfVar2.zzb(), zzcfVar3.zzb(), zzbxVar.zzb(), zzcfVar.zzb(), zzceVar.zzb()}).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.ads.interactivemedia.pal.zzah
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                this.zza.zzb(task2);
            }
        });
    }
}
