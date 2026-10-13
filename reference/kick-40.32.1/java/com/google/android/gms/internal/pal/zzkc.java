package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkc {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzkc(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzkd.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzkd.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        int i = this.zzd - 1;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 6);
        sb.append("FBAMTD");
        sb.append(i);
        return sb.toString();
    }

    private final String zzf() {
        int i = this.zzd - 1;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 6);
        sb.append("LATMTD");
        sb.append(i);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007c  */
    public final boolean zza(zzgt zzgtVar, zzki zzkiVar) {
        boolean z;
        String strZza = zzgtVar.zza().zza();
        byte[] bArrZzx = zzgtVar.zzb().zzx();
        byte[] bArrZzx2 = zzgtVar.zzc().zzx();
        if (!TextUtils.isEmpty(strZza) && bArrZzx2 != null && bArrZzx2.length != 0) {
            File file = this.zza;
            zzkd.zze(file);
            file.mkdirs();
            zzkd.zzc(strZza, file).mkdirs();
            File fileZza = zzkd.zza(strZza, "pcam.jar", file);
            if ((bArrZzx == null || bArrZzx.length <= 0 || zzkd.zzb(fileZza, bArrZzx)) && zzkd.zzb(zzkd.zza(strZza, "pcbc", file), bArrZzx2)) {
                File fileZza2 = zzkd.zza(zzgtVar.zza().zza(), "pcam.jar", file);
                if (fileZza2.exists() && zzkiVar != null && !zzkiVar.zza(fileZza2)) {
                    return false;
                }
                String strZza2 = zzgtVar.zza().zza();
                if (TextUtils.isEmpty(strZza2)) {
                    z = false;
                } else {
                    File fileZza3 = zzkd.zza(strZza2, "pcam.jar", file);
                    File fileZza4 = zzkd.zza(strZza2, "pcbc", file);
                    File fileZza5 = zzkd.zza(strZza2, "pcam.jar", zzd());
                    File fileZza6 = zzkd.zza(strZza2, "pcbc", zzd());
                    if ((!fileZza3.exists() || fileZza3.renameTo(fileZza5)) && fileZza4.exists() && fileZza4.renameTo(fileZza6)) {
                        zzgu zzguVarZzh = zzgv.zzh();
                        zzguVarZzh.zza(zzgtVar.zza().zza());
                        zzguVarZzh.zzb(zzgtVar.zza().zzb());
                        zzguVarZzh.zzd(zzgtVar.zza().zzd());
                        zzguVarZzh.zze(zzgtVar.zza().zze());
                        zzguVarZzh.zzc(zzgtVar.zza().zzc());
                        zzgv zzgvVar = (zzgv) zzguVarZzh.zzal();
                        zzgv zzgvVarZzc = zzc(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzgvVarZzc != null && !zzgvVar.zza().equals(zzgvVarZzc.zza())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzgvVarZzc.zzaq()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzgvVar.zzaq()));
                        if (editorEdit.commit()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                }
                HashSet hashSet = new HashSet();
                zzgv zzgvVarZzc2 = zzc(1);
                if (zzgvVarZzc2 != null) {
                    hashSet.add(zzgvVarZzc2.zza());
                }
                zzgv zzgvVarZzc3 = zzc(2);
                if (zzgvVarZzc3 != null) {
                    hashSet.add(zzgvVarZzc3.zza());
                }
                for (File file2 : zzd().listFiles()) {
                    String name = file2.getName();
                    if (!hashSet.contains(name)) {
                        zzkd.zze(zzkd.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    public final zzkb zzb(int i) {
        zzgv zzgvVarZzc = zzc(1);
        if (zzgvVarZzc == null) {
            return null;
        }
        String strZza = zzgvVarZzc.zza();
        File fileZza = zzkd.zza(strZza, "pcam.jar", zzd());
        if (!fileZza.exists()) {
            fileZza = zzkd.zza(strZza, "pcam", zzd());
        }
        return new zzkb(zzgvVarZzc, fileZza, zzkd.zza(strZza, "pcbc", zzd()), zzkd.zza(strZza, "pcopt", zzd()));
    }

    final zzgv zzc(int i) {
        SharedPreferences sharedPreferences = this.zzc;
        String string = i == 1 ? sharedPreferences.getString(zzf(), null) : sharedPreferences.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzatl zzatlVar = zzatl.zza;
            zzgv zzgvVarZzf = zzgv.zzf(zzatl.zzr(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZza = zzgvVarZzf.zza();
            File fileZza = zzkd.zza(strZza, "pcam.jar", zzd());
            if (!fileZza.exists()) {
                fileZza = zzkd.zza(strZza, "pcam", zzd());
            }
            File fileZza2 = zzkd.zza(strZza, "pcbc", zzd());
            if (fileZza.exists() && fileZza2.exists()) {
                return zzgvVarZzf;
            }
            return null;
        } catch (zzavb unused) {
        }
    }
}
