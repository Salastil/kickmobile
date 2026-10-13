package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatb {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzaty zzd;
    public int zze;

    zzatb() {
        int i = zzaty.zzb;
        int i2 = zzata.zza;
        this.zzd = zzaty.zza;
    }

    static /* synthetic */ String zza(int i, int i2, byte b, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + b + String.valueOf(i).length());
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    zzatb(zzaty zzatyVar) {
        zzatyVar.getClass();
        this.zzd = zzatyVar;
    }
}
