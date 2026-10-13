package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhi implements zzhg {
    private static final zzhg zzb = zzhh.zza;
    private final zzhk zza = new zzhk();
    private volatile zzhg zzc;
    private Object zzd;

    zzhi(zzhg zzhgVar) {
        this.zzc = zzhgVar;
    }

    public final String toString() {
        Object string = this.zzc;
        if (string == zzb) {
            String strValueOf = String.valueOf(this.zzd);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.cast.zzhg
    public final Object zza() {
        zzhg zzhgVar = this.zzc;
        zzhg zzhgVar2 = zzb;
        if (zzhgVar != zzhgVar2) {
            synchronized (this.zza) {
                if (this.zzc != zzhgVar2) {
                    Object objZza = this.zzc.zza();
                    this.zzd = objZza;
                    this.zzc = zzhgVar2;
                    return objZza;
                }
            }
        }
        return this.zzd;
    }
}
