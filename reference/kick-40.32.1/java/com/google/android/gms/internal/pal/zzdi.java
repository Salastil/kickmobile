package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdi {
    public static final String zza(Context context, String str, long j, boolean z) {
        try {
            zzbo zzboVarZza = zzbp.zza();
            zzboVarZza.zzb(str);
            zzboVarZza.zza("0.828153725");
            zzboVarZza.zzd(context.getPackageName());
            zzboVarZza.zzf((System.currentTimeMillis() - j) / 1000);
            zzboVarZza.zzc(System.currentTimeMillis() / 1000);
            try {
                zzboVarZza.zze(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzboVarZza.zze(-1L);
            }
            zzbv zzbvVarZzc = zzct.zzc(((zzbp) zzboVarZza.zzal()).zzaq(), null);
            zzbvVarZzc.zzc(5);
            zzbvVarZzc.zzd(2);
            return Base64.encodeToString(((zzbw) zzbvVarZzc.zzal()).zzaq(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}
