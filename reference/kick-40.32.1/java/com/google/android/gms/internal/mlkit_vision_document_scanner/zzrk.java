package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrk {
    private static zzad zza;
    private static final zzaf zzb = zzaf.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzrd zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzrk(Context context, final SharedPrefManager sharedPrefManager, zzrd zzrdVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzrdVar;
        zzrw.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_document_scanner.zzri
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_document_scanner.zzrj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzaf zzafVar = zzb;
        this.zzj = zzafVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzafVar.get(str)) : -1;
    }

    private static synchronized zzad zzd() {
        zzad zzadVar = zza;
        if (zzadVar != null) {
            return zzadVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzaa zzaaVar = new zzaa();
        for (int i = 0; i < locales.size(); i++) {
            zzaaVar.zza(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzad zzadVarZzb = zzaaVar.zzb();
        zza = zzadVarZzb;
        return zzadVarZzb;
    }

    final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzb(zzrc zzrcVar, zzml zzmlVar, String str) {
        zzrcVar.zza(zzmlVar);
        String strZzc = zzrcVar.zzc();
        zzqc zzqcVar = new zzqc();
        zzqcVar.zzb(this.zzc);
        zzqcVar.zzc(this.zzd);
        zzqcVar.zzh(zzd());
        zzqcVar.zzg(true);
        zzqcVar.zzl(strZzc);
        zzqcVar.zzj(str);
        zzqcVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzqcVar.zzd(10);
        zzqcVar.zzk(Integer.valueOf(this.zzj));
        zzrcVar.zzb(zzqcVar);
        this.zze.zza(zzrcVar);
    }

    public final void zzc(final zzrc zzrcVar, final zzml zzmlVar) throws Throwable {
        final String version;
        if (this.zzg.isSuccessful()) {
            version = (String) this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion(this.zzi);
        }
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_document_scanner.zzrh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzrcVar, zzmlVar, version);
            }
        });
    }
}
