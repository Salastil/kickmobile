package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqt {
    private static Boolean zza;
    private final zzlk zzb;
    private final Uri zzc;
    private final String zzd;
    private final String zze = "";

    public zzqt(zzlk zzlkVar, String str, String str2, boolean z) {
        this.zzb = zzlkVar;
        this.zzd = str;
        zzrz zzrzVarZza = zzsa.zza(zzlkVar.zzc());
        zzrzVarZza.zzb("phenotype");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(str);
        sb.append(".pb");
        zzrzVarZza.zzc(sb.toString());
        this.zzc = zzrzVarZza.zzd();
    }

    private static boolean zzf() {
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Boolean bool = (Boolean) Preconditions.checkNotNull(Process.class.getMethod("isIsolated", null).invoke(Process.class, null));
                    bool.booleanValue();
                    zza = bool;
                } catch (ReflectiveOperationException unused) {
                    zza = false;
                }
            }
        }
        return zza.booleanValue();
    }

    final zzqs zza() {
        String strSubstring;
        zznv zznvVar;
        zznv zznvVar2;
        StrictMode.ThreadPolicy threadPolicy;
        zzlk zzlkVar = this.zzb;
        if (zzky.zzb(zzlkVar.zzc())) {
            return zzqs.zza(zzqv.zzi(), new zzqr(3, 17));
        }
        if (zzf()) {
            return zzqs.zza(zzqv.zzi(), new zzqr(3, 18));
        }
        zzqn zzqnVarZzc = zzlkVar.zzd().zzc(false);
        String str = this.zzd;
        zzabz zzabzVar = zzabz.FILE;
        int i = zzlg.zza;
        int iIndexOf = str.indexOf("#");
        if (iIndexOf >= 0) {
            strSubstring = str.substring(0, iIndexOf);
        } else {
            if (str.contains("@")) {
                String.valueOf(str);
                throw new IllegalArgumentException("Invalid package name: ".concat(String.valueOf(str)));
            }
            strSubstring = str;
        }
        int iZzg = zzqnVarZzc.zzg(zzabzVar, strSubstring);
        if (iZzg != 0) {
            zznvVar2 = new zznv(null, new zzqr(iZzg));
        } else {
            try {
                String strZzc = zzqnVarZzc.zzc();
                if (strZzc.isEmpty()) {
                    Optional optionalZze = zzlkVar.zze();
                    if (optionalZze.isPresent()) {
                        strZzc = ((ApplicationInfo) optionalZze.get()).dataDir;
                        String str2 = File.separator;
                        String strZzb = zzqnVarZzc.zzb();
                        StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + String.valueOf(str2).length() + String.valueOf(strZzb).length());
                        sb.append(strZzc);
                        sb.append(str2);
                        sb.append(strZzb);
                        String string = sb.toString();
                        zzmz zzmzVar = new zzmz(zzqnVarZzc.zza(), str, this.zze);
                        Uri.Builder builderScheme = new Uri.Builder().scheme("file");
                        String str3 = File.separator;
                        String str4 = File.separator;
                        String string2 = zzmzVar.zza().toString();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + string.length() + String.valueOf(str4).length() + string2.length());
                        sb2.append(str3);
                        sb2.append(string);
                        sb2.append(str4);
                        sb2.append(string2);
                        Uri uriBuild = builderScheme.appendEncodedPath(sb2.toString()).build();
                        threadPolicy = StrictMode.getThreadPolicy();
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                        try {
                            try {
                                zznvVar = new zznv((zznd) zzlkVar.zzi().zza(uriBuild, new zzna(zzqnVarZzc.zzf().zza())), new zzqr(5, 2));
                                StrictMode.setThreadPolicy(threadPolicy);
                            } catch (zzaeh e) {
                                zzlz.zzb(Level.SEVERE, this.zzb.zzg(), e, "Failed to parse snapshot from shared storage for %s", this.zzd);
                                zznvVar2 = new zznv(null, new zzqr(9));
                                StrictMode.setThreadPolicy(threadPolicy);
                            } catch (FileNotFoundException unused) {
                                zzlz.zza(Level.INFO, this.zzb.zzg(), "Shared storage file not found for %s", this.zzd);
                                zznvVar2 = new zznv(null, new zzqr(8));
                                StrictMode.setThreadPolicy(threadPolicy);
                            }
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicy);
                            throw th;
                        }
                    } else {
                        zzlz.zza(Level.WARNING, zzlkVar.zzg(), "Unable to get GMS application info, using defaults.", new Object[0]);
                        zznvVar = new zznv(zznd.zza(), new zzqr(3, 7));
                    }
                    zznvVar2 = zznvVar;
                } else {
                    String str5 = File.separator;
                    String strZzb2 = zzqnVarZzc.zzb();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(strZzc).length() + String.valueOf(str5).length() + String.valueOf(strZzb2).length());
                    sb3.append(strZzc);
                    sb3.append(str5);
                    sb3.append(strZzb2);
                    String string3 = sb3.toString();
                    zzmz zzmzVar2 = new zzmz(zzqnVarZzc.zza(), str, this.zze);
                    Uri.Builder builderScheme2 = new Uri.Builder().scheme("file");
                    String str6 = File.separator;
                    String str7 = File.separator;
                    String string4 = zzmzVar2.zza().toString();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(str6).length() + string3.length() + String.valueOf(str7).length() + string4.length());
                    sb4.append(str6);
                    sb4.append(string3);
                    sb4.append(str7);
                    sb4.append(string4);
                    Uri uriBuild2 = builderScheme2.appendEncodedPath(sb4.toString()).build();
                    threadPolicy = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                    zznvVar = new zznv((zznd) zzlkVar.zzi().zza(uriBuild2, new zzna(zzqnVarZzc.zzf().zza())), new zzqr(5, 2));
                    StrictMode.setThreadPolicy(threadPolicy);
                    zznvVar2 = zznvVar;
                }
            } catch (Exception e2) {
                zzlz.zzb(Level.WARNING, this.zzb.zzg(), e2, "Failed to read shared file for %s", this.zzd);
                zznvVar = new zznv(zznd.zza(), new zzqr(3, 10));
            }
        }
        if (zznvVar2.zza() != null) {
            return zzqs.zzc((zznd) Preconditions.checkNotNull(zznvVar2.zza()), zznvVar2.zzb());
        }
        try {
            return zzqs.zza((zzqv) this.zzb.zzi().zza(this.zzc, zzss.zzb(zzqv.zzi())), new zzqr(4, zznvVar2.zzb().zzb()));
        } catch (IOException | RuntimeException unused2) {
            zzlz.zza(Level.INFO, this.zzb.zzg(), "Unable to retrieve flag snapshot for %s, using defaults.", this.zzd);
            return zzb() ? zzqs.zzc(zznd.zza(), new zzqr(3, 16)) : zzqs.zza(zzqv.zzi(), new zzqr(3, 11));
        }
    }

    final boolean zzb() {
        return this.zzb.zzd().zzb(false, zzabz.FILE);
    }

    public final ListenableFuture zzc(final zzqv zzqvVar) {
        return Futures.submit(new Callable() { // from class: com.google.android.gms.internal.measurement.zzqq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zze(zzqvVar);
                return null;
            }
        }, this.zzb.zzg());
    }

    final ListenableFuture zzd(String str) {
        zzlk zzlkVar = this.zzb;
        return Futures.transform(zzlkVar.zzh().zza(this.zzd, ""), zzqp.zza, zzlkVar.zzg());
    }

    final /* synthetic */ Void zze(zzqv zzqvVar) {
        zzse zzseVar = new zzse();
        try {
            zzru zzruVarZzi = this.zzb.zzi();
            Uri uri = this.zzc;
            zzsv zzsvVarZzb = zzsv.zzb(zzqvVar);
            zzsvVarZzb.zzc(zzseVar);
            return null;
        } catch (IOException | RuntimeException e) {
            zzlz.zzb(Level.WARNING, this.zzb.zzg(), e, "Failed to update snapshot for %s flags may be stale.", this.zzd);
            return null;
        }
    }
}
