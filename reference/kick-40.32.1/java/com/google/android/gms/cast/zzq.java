package com.google.android.gms.cast;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzq extends HasApiKey {
    boolean zza();

    void zzb(zzp zzpVar);

    Task zzc();

    Task zzd();

    Task zze();

    Task zzf(String str, String str2);

    Task zzg(String str, LaunchOptions launchOptions);

    Task zzh(String str);

    Task zzi(double d);

    double zzj();

    Task zzk(boolean z);

    boolean zzl();

    int zzm();

    int zzn();

    ApplicationMetadata zzo();

    String zzp();

    Task zzq(String str, Cast.MessageReceivedCallback messageReceivedCallback);

    Task zzr(String str);
}
