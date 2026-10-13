package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import io.ktor.sse.ServerSentEventKt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagl {
    private static final Pattern zza = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");
    private static final Logger zzb = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final HashMap<String, zzago> zze = new HashMap<>();

    final zzaeu zza(zzaeu zzaeuVar, String str) {
        return new zzagm(this, zzaeuVar, str);
    }

    static String zza(String str) {
        Matcher matcher = zza.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    final String zzb() {
        Signature[] apkContentsSigners;
        try {
            String packageName = this.zzc.getPackageName();
            int i = Build.VERSION.SDK_INT;
            Context context = this.zzc;
            if (i < 28) {
                apkContentsSigners = Wrappers.packageManager(context).getPackageInfo(packageName, 64).signatures;
            } else {
                apkContentsSigners = Wrappers.packageManager(context).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String strZza = zza(packageName, apkContentsSigners[0].toCharsString());
            if (strZza != null) {
                return strZza;
            }
            zzb.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zzb.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        String str3 = str + ServerSentEventKt.SPACE + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str3.getBytes(StandardCharsets.UTF_8));
            String strSubstring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zzb.d("Package: " + str + " -- Hash: " + strSubstring, new Object[0]);
            return strSubstring;
        } catch (NoSuchAlgorithmException e) {
            zzb.e("NoSuchAlgorithm: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void zzb(zzagl zzaglVar, String str) {
        zzago zzagoVar = zzaglVar.zze.get(str);
        if (zzagoVar == null || zzac.zzc(zzagoVar.zzd) || zzac.zzc(zzagoVar.zze) || zzagoVar.zzb.isEmpty()) {
            return;
        }
        Iterator<zzaeu> it = zzagoVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(PhoneAuthCredential.zza(zzagoVar.zzd, zzagoVar.zze));
        }
        zzagoVar.zzh = true;
    }

    zzagl(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str) {
        zzago zzagoVar = this.zze.get(str);
        if (zzagoVar == null || zzagoVar.zzh || zzac.zzc(zzagoVar.zzd)) {
            return;
        }
        zzb.w("Timed out waiting for SMS.", new Object[0]);
        Iterator<zzaeu> it = zzagoVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(zzagoVar.zzd);
        }
        zzagoVar.zzi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(String str) {
        zzago zzagoVar = this.zze.get(str);
        if (zzagoVar == null) {
            return;
        }
        if (!zzagoVar.zzi) {
            zzd(str);
        }
        zzb(str);
    }

    final void zzb(zzaeu zzaeuVar, String str) {
        zzago zzagoVar = this.zze.get(str);
        if (zzagoVar == null) {
            return;
        }
        zzagoVar.zzb.add(zzaeuVar);
        if (zzagoVar.zzg) {
            zzaeuVar.zzb(zzagoVar.zzd);
        }
        if (zzagoVar.zzh) {
            zzaeuVar.zza(PhoneAuthCredential.zza(zzagoVar.zzd, zzagoVar.zze));
        }
        if (zzagoVar.zzi) {
            zzaeuVar.zza(zzagoVar.zzd);
        }
    }

    final void zzb(String str) {
        zzago zzagoVar = this.zze.get(str);
        if (zzagoVar == null) {
            return;
        }
        if (zzagoVar.zzf != null && !zzagoVar.zzf.isDone()) {
            zzagoVar.zzf.cancel(false);
        }
        zzagoVar.zzb.clear();
        this.zze.remove(str);
    }

    final void zza(final String str, zzaeu zzaeuVar, long j, boolean z) {
        this.zze.put(str, new zzago(j, z));
        zzb(zzaeuVar, str);
        zzago zzagoVar = this.zze.get(str);
        if (zzagoVar.zza <= 0) {
            zzb.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagoVar.zzf = this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzagk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(str);
            }
        }, zzagoVar.zza, TimeUnit.SECONDS);
        if (!zzagoVar.zzc) {
            zzb.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagp zzagpVar = new zzagp(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        ContextCompat.registerReceiver(this.zzc.getApplicationContext(), zzagpVar, intentFilter, 2);
        SmsRetriever.getClient(this.zzc).startSmsRetriever().addOnFailureListener(new zzagn(this));
    }

    final boolean zzc(String str) {
        return this.zze.get(str) != null;
    }
}
