package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
@ParametersAreNonnullByDefault
public final class zzhy implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zze(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhv
                    @Override // com.google.android.gms.internal.pal.zzme
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zze(sharedPreferences);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a4 A[Catch: all -> 0x016b, TRY_ENTER, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a8 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6 A[Catch: all -> 0x016b, TRY_ENTER, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0119 A[Catch: all -> 0x0174, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:11:0x000f, B:13:0x0014, B:14:0x0016, B:16:0x0028, B:17:0x002c, B:18:0x002e, B:43:0x009e, B:67:0x011d, B:68:0x0120, B:52:0x00d1, B:66:0x0119, B:81:0x0162, B:82:0x0169, B:85:0x016c, B:86:0x0173, B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:92:0x0009, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0122 A[Catch: all -> 0x016b, TRY_ENTER, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x012f A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0154 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:20:0x0043, B:33:0x005e, B:35:0x0067, B:36:0x006f, B:38:0x0075, B:40:0x0085, B:42:0x009a, B:45:0x00a4, B:47:0x00a8, B:49:0x00b8, B:51:0x00cd, B:54:0x00d6, B:64:0x0115, B:70:0x0122, B:72:0x012f, B:74:0x013d, B:75:0x0146, B:77:0x0154, B:79:0x0158, B:80:0x015b, B:57:0x00e7, B:59:0x00f5, B:61:0x00fd, B:62:0x0108, B:24:0x004a, B:28:0x0054), top: B:99:0x0043, outer: #0 }] */
    public final void zza(Context context) {
        Context applicationContext;
        final SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        ConditionVariable conditionVariable;
        zzic zzicVar;
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            if (this.zzd) {
                return;
            }
            if (!this.zza) {
                this.zza = true;
            }
            this.zzi = TextUtils.equals(context.getPackageName(), "com.google.android.gms");
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzg = context;
            try {
                this.zzf = Wrappers.packageManager(context).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context context2 = this.zzg;
                SharedPreferences sharedPreferencesZza = null;
                if (context2 == null) {
                    context2 = null;
                } else {
                    try {
                        applicationContext = context2.createPackageContext("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        applicationContext = null;
                    }
                    if (applicationContext != null || (applicationContext = context2.getApplicationContext()) != null) {
                        context2 = applicationContext;
                    }
                }
                if (context2 != null) {
                    zzhi.zza();
                    sharedPreferencesZza = zzht.zza(context2);
                }
                if (sharedPreferencesZza != null) {
                    zzij.zzc(new zzhu(this, sharedPreferencesZza));
                }
                if (!this.zzi) {
                    zzic zzicVar2 = zzid.zza;
                    if (((Long) zzicVar2.zzc()).longValue() > 0 && zzhl.zzb(this.zzg) >= ((Long) zzicVar2.zzc()).longValue()) {
                        this.zzj = true;
                        this.zzd = true;
                        this.zza = false;
                        conditionVariable = this.zzc;
                    } else if (this.zzi) {
                        Context context3 = this.zzg;
                        if (!((Boolean) zzie.zzd.zzc()).booleanValue()) {
                            if (((Boolean) zzie.zze.zzc()).booleanValue()) {
                                if (new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhw
                                    @Override // com.google.android.gms.internal.pal.zzme
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                zzhi.zza();
                                this.zze = zzht.zza(context2);
                                if (!this.zzi) {
                                    zzhi.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zze(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            conditionVariable = this.zzc;
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            zzhi.zza();
                            this.zze = zzht.zza(context2);
                            if (!this.zzi) {
                                zzhi.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zze(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        conditionVariable = this.zzc;
                    } else {
                        zzicVar = zzid.zzb;
                        if (((Long) zzicVar.zzc()).longValue() > 0 || zzhl.zza(this.zzg) < ((Long) zzicVar.zzc()).longValue()) {
                            Context context4 = this.zzg;
                            if (!((Boolean) zzie.zzd.zzc()).booleanValue()) {
                                if (((Boolean) zzie.zze.zzc()).booleanValue() && (sharedPreferences = context4.getSharedPreferences("admob", 0)) != null) {
                                    try {
                                        if (new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhw
                                            @Override // com.google.android.gms.internal.pal.zzme
                                            public final /* synthetic */ Object zza() {
                                                return sharedPreferences.getString("app_settings_json", "{}");
                                            }
                                        })).optBoolean("local_flags_enabled")) {
                                        }
                                    } catch (JSONException unused3) {
                                    }
                                }
                                if (context2 == null) {
                                    zzhi.zza();
                                    this.zze = zzht.zza(context2);
                                    if (!this.zzi && ((Boolean) zzie.zzc.zzc()).booleanValue()) {
                                        zzhi.zzd().zza(this.zzg);
                                    }
                                    if (!((Boolean) zzie.zzb.zzc()).booleanValue() && (sharedPreferences2 = this.zze) != null) {
                                        sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                    }
                                    zze(this.zze);
                                    this.zzd = true;
                                    this.zza = false;
                                    this.zzc.open();
                                    return;
                                }
                                this.zza = false;
                                conditionVariable = this.zzc;
                            }
                            context2 = this.zzg;
                            if (context2 == null) {
                                zzhi.zza();
                                this.zze = zzht.zza(context2);
                                if (!this.zzi) {
                                    zzhi.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zze(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            conditionVariable = this.zzc;
                        } else {
                            this.zzj = true;
                            this.zzd = true;
                            this.zza = false;
                            conditionVariable = this.zzc;
                        }
                    }
                } else if (this.zzi) {
                    zzicVar = zzid.zzb;
                    if (((Long) zzicVar.zzc()).longValue() > 0) {
                        Context context5 = this.zzg;
                        if (!((Boolean) zzie.zzd.zzc()).booleanValue()) {
                            if (((Boolean) zzie.zze.zzc()).booleanValue()) {
                                if (new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhw
                                    @Override // com.google.android.gms.internal.pal.zzme
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                zzhi.zza();
                                this.zze = zzht.zza(context2);
                                if (!this.zzi) {
                                    zzhi.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zze(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            conditionVariable = this.zzc;
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            zzhi.zza();
                            this.zze = zzht.zza(context2);
                            if (!this.zzi) {
                                zzhi.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zze(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        conditionVariable = this.zzc;
                    } else {
                        Context context6 = this.zzg;
                        if (!((Boolean) zzie.zzd.zzc()).booleanValue()) {
                            if (((Boolean) zzie.zze.zzc()).booleanValue()) {
                                if (new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhw
                                    @Override // com.google.android.gms.internal.pal.zzme
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                zzhi.zza();
                                this.zze = zzht.zza(context2);
                                if (!this.zzi) {
                                    zzhi.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zze(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            conditionVariable = this.zzc;
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            zzhi.zza();
                            this.zze = zzht.zza(context2);
                            if (!this.zzi) {
                                zzhi.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zze(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        conditionVariable = this.zzc;
                    }
                } else {
                    Context context7 = this.zzg;
                    if (!((Boolean) zzie.zzd.zzc()).booleanValue()) {
                        if (((Boolean) zzie.zze.zzc()).booleanValue()) {
                            if (new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhw
                                @Override // com.google.android.gms.internal.pal.zzme
                                public final /* synthetic */ Object zza() {
                                    return sharedPreferences.getString("app_settings_json", "{}");
                                }
                            })).optBoolean("local_flags_enabled")) {
                            }
                        }
                        if (context2 == null) {
                            zzhi.zza();
                            this.zze = zzht.zza(context2);
                            if (!this.zzi) {
                                zzhi.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zze(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        conditionVariable = this.zzc;
                    }
                    context2 = this.zzg;
                    if (context2 == null) {
                        zzhi.zza();
                        this.zze = zzht.zza(context2);
                        if (!this.zzi) {
                            zzhi.zzd().zza(this.zzg);
                        }
                        if (!((Boolean) zzie.zzb.zzc()).booleanValue()) {
                            sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                        }
                        zze(this.zze);
                        this.zzd = true;
                        this.zza = false;
                        this.zzc.open();
                        return;
                    }
                    this.zza = false;
                    conditionVariable = this.zzc;
                }
                conditionVariable.open();
            } catch (Throwable th) {
                this.zza = false;
                this.zzc.open();
                throw th;
            }
        }
    }

    final boolean zzb() {
        return this.zzi;
    }

    public final Object zzc(final zzhr zzhrVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzhrVar.zze();
            }
        }
        if (zzhrVar.zzk() != 2) {
            return (zzhrVar.zzk() == 1 && this.zzh.has(zzhrVar.zzd())) ? zzhrVar.zzb(this.zzh) : zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhx
                @Override // com.google.android.gms.internal.pal.zzme
                public final /* synthetic */ Object zza() {
                    return this.zza.zzd(zzhrVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzhrVar.zze() : zzhrVar.zza(bundle);
    }

    final /* synthetic */ Object zzd(zzhr zzhrVar) {
        return zzhrVar.zzc(this.zze);
    }
}
