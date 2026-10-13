package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkj {
    private static final Object zzf = new Object();
    private final Context zza;
    private final SharedPreferences zzb;
    private final String zzc;
    private final zzjs zzd;
    private boolean zze;

    public zzkj(Context context, int i, zzjs zzjsVar, boolean z) {
        this.zze = false;
        this.zza = context;
        this.zzc = Integer.toString(i - 1);
        this.zzb = context.getSharedPreferences("pcvmspf", 0);
        this.zzd = zzjsVar;
        this.zze = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zza.getDir("pccache", 0), this.zzc), str);
    }

    private final String zzf() {
        String str = this.zzc;
        String.valueOf(str);
        return "FBAMTD".concat(String.valueOf(str));
    }

    private final String zzg() {
        String str = this.zzc;
        String.valueOf(str);
        return "LATMTD".concat(String.valueOf(str));
    }

    private static String zzh(zzgt zzgtVar) {
        zzgu zzguVarZzh = zzgv.zzh();
        zzguVarZzh.zza(zzgtVar.zza().zza());
        zzguVarZzh.zzb(zzgtVar.zza().zzb());
        zzguVarZzh.zzd(zzgtVar.zza().zzd());
        zzguVarZzh.zze(zzgtVar.zza().zze());
        zzguVarZzh.zzc(zzgtVar.zza().zzc());
        return Hex.bytesToStringLowercase(((zzgv) zzguVarZzh.zzal()).zzaq());
    }

    private final void zzi(int i, long j) {
        this.zzd.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zzd.zzb(i, j, str);
    }

    public final boolean zza(zzgt zzgtVar, zzki zzkiVar) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzgv zzgvVarZzk = zzk(1);
            String strZza = zzgtVar.zza().zza();
            if (zzgvVarZzk != null && zzgvVarZzk.zza().equals(strZza)) {
                zzi(4014, jCurrentTimeMillis);
                return false;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            File fileZze = zze(strZza);
            if (fileZze.exists()) {
                String str = true != fileZze.isDirectory() ? "0" : "1";
                String str2 = true != fileZze.isFile() ? "0" : "1";
                z = false;
                StringBuilder sb = new StringBuilder(7);
                sb.append("d:");
                sb.append(str);
                sb.append(",f:");
                sb.append(str2);
                zzj(4023, jCurrentTimeMillis2, sb.toString());
                zzi(4015, jCurrentTimeMillis2);
            } else {
                z = false;
                if (!fileZze.mkdirs()) {
                    zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                    return false;
                }
            }
            File fileZze2 = zze(strZza);
            File file = new File(fileZze2, "pcam.jar");
            File file2 = new File(fileZze2, "pcbc");
            if (!zzkd.zzb(file, zzgtVar.zzb().zzx())) {
                zzi(4016, jCurrentTimeMillis);
                return z;
            }
            if (!zzkd.zzb(file2, zzgtVar.zzc().zzx())) {
                zzi(4017, jCurrentTimeMillis);
                return z;
            }
            if (zzkiVar != null && !zzkiVar.zza(file)) {
                zzi(4018, jCurrentTimeMillis);
                zzkd.zze(fileZze2);
                return z;
            }
            String strZzh = zzh(zzgtVar);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.zzb;
            String string = sharedPreferences.getString(zzg(), null);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(zzg(), strZzh);
            if (string != null) {
                editorEdit.putString(zzf(), string);
            }
            if (!editorEdit.commit()) {
                zzi(4019, jCurrentTimeMillis3);
                return z;
            }
            HashSet hashSet = new HashSet();
            zzgv zzgvVarZzk2 = zzk(1);
            if (zzgvVarZzk2 != null) {
                hashSet.add(zzgvVarZzk2.zza());
            }
            zzgv zzgvVarZzk3 = zzk(2);
            if (zzgvVarZzk3 != null) {
                hashSet.add(zzgvVarZzk3.zza());
            }
            boolean z2 = z;
            File[] fileArrListFiles = new File(this.zza.getDir("pccache", z2 ? 1 : 0), this.zzc).listFiles();
            int length = fileArrListFiles.length;
            for (int i = z2 ? 1 : 0; i < length; i++) {
                File file3 = fileArrListFiles[i];
                if (!hashSet.contains(file3.getName())) {
                    zzkd.zze(file3);
                }
            }
            zzi(5014, jCurrentTimeMillis);
            return true;
        }
    }

    public final boolean zzb(zzgt zzgtVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            if (!zzkd.zzb(new File(zze(zzgtVar.zza().zza()), "pcbc"), zzgtVar.zzc().zzx())) {
                zzi(4020, jCurrentTimeMillis);
                return false;
            }
            String strZzh = zzh(zzgtVar);
            SharedPreferences.Editor editorEdit = this.zzb.edit();
            editorEdit.putString(zzg(), strZzh);
            boolean zCommit = editorEdit.commit();
            if (zCommit) {
                zzi(5015, jCurrentTimeMillis);
            } else {
                zzi(4021, jCurrentTimeMillis);
            }
            return zCommit;
        }
    }

    public final zzkb zzc(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzgv zzgvVarZzk = zzk(1);
            if (zzgvVarZzk == null) {
                zzi(4022, jCurrentTimeMillis);
                return null;
            }
            File fileZze = zze(zzgvVarZzk.zza());
            File file = new File(fileZze, "pcam.jar");
            if (!file.exists()) {
                file = new File(fileZze, "pcam");
            }
            File file2 = new File(fileZze, "pcbc");
            File file3 = new File(fileZze, "pcopt");
            zzi(5016, jCurrentTimeMillis);
            return new zzkb(zzgvVarZzk, file, file2, file3);
        }
    }

    public final boolean zzd(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzgv zzgvVarZzk = zzk(1);
            if (zzgvVarZzk == null) {
                zzi(4025, jCurrentTimeMillis);
                return false;
            }
            File fileZze = zze(zzgvVarZzk.zza());
            if (!new File(fileZze, "pcam.jar").exists()) {
                zzi(4026, jCurrentTimeMillis);
                return false;
            }
            if (new File(fileZze, "pcbc").exists()) {
                zzi(5019, jCurrentTimeMillis);
                return true;
            }
            zzi(4027, jCurrentTimeMillis);
            return false;
        }
    }

    private final zzgv zzk(int i) {
        SharedPreferences sharedPreferences = this.zzb;
        String string = i == 1 ? sharedPreferences.getString(zzg(), null) : sharedPreferences.getString(zzf(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzatl zzatlVar = zzatl.zza;
            return zzgv.zzg(zzatl.zzr(bArrStringToBytes, 0, bArrStringToBytes.length), this.zze ? zzaty.zza() : zzaty.zzb());
        } catch (zzavb unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }
}
