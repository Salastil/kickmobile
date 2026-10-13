package com.android.billingclient.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.android.billingclient.BuildConfig;
import com.google.android.gms.internal.play_billing.zzim;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdl {
    static Bundle zza(com.google.android.gms.internal.play_billing.zzes zzesVar, zzim zzimVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("REQUEST_METADATA", zzesVar.zzQ());
        bundle.putByteArray("REQUEST_PARAMS", zzimVar.zzQ());
        return bundle;
    }

    static com.google.android.gms.internal.play_billing.zzes zzb(String str, int i, Context context, String str2) {
        String strValueOf;
        com.google.android.gms.internal.play_billing.zzer zzerVarZza = com.google.android.gms.internal.play_billing.zzes.zza();
        zzerVarZza.zzd(BuildConfig.VERSION_NAME);
        zzerVarZza.zze(24);
        zzerVarZza.zzb(context.getPackageName());
        zzerVarZza.zzc(str2);
        try {
            strValueOf = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            com.google.android.gms.internal.play_billing.zzc.zzn("DelegationApiParamsBuilder", "No version code is found!");
            strValueOf = null;
        }
        if (strValueOf != null) {
            zzerVarZza.zza(strValueOf);
        }
        return (com.google.android.gms.internal.play_billing.zzes) zzerVarZza.zzi();
    }
}
