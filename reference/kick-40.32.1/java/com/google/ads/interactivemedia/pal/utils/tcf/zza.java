package com.google.ads.interactivemedia.pal.utils.tcf;

import com.google.android.gms.internal.pal.zznp;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zza extends zzc {
    private final String zza;

    @Nullable
    private final Boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final boolean zzf;
    private final zznp zzg;
    private final zznp zzh;
    private final zznp zzi;
    private final zznp zzj;

    @Nullable
    private final zznp zzk;
    private final zznp zzl;

    zza(String str, @Nullable Boolean bool, int i, int i2, String str2, boolean z, zznp zznpVar, zznp zznpVar2, zznp zznpVar3, zznp zznpVar4, @Nullable zznp zznpVar5, zznp zznpVar6) {
        if (str == null) {
            throw new NullPointerException("Null tcString");
        }
        this.zza = str;
        this.zzb = bool;
        this.zzc = i;
        this.zzd = i2;
        if (str2 == null) {
            throw new NullPointerException("Null publisherCc");
        }
        this.zze = str2;
        this.zzf = z;
        this.zzg = zznpVar;
        this.zzh = zznpVar2;
        this.zzi = zznpVar3;
        this.zzj = zznpVar4;
        this.zzk = zznpVar5;
        this.zzl = zznpVar6;
    }

    public final boolean equals(Object obj) {
        zznp zznpVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            if (this.zza.equals(zzcVar.zza()) && this.zzb.equals(zzcVar.zzb()) && this.zzc == zzcVar.zzc() && this.zzd == zzcVar.zzd() && this.zze.equals(zzcVar.zze()) && this.zzf == zzcVar.zzf() && this.zzg.equals(zzcVar.zzg()) && this.zzh.equals(zzcVar.zzh()) && this.zzi.equals(zzcVar.zzi()) && this.zzj.equals(zzcVar.zzj()) && ((zznpVar = this.zzk) != null ? zznpVar.equals(zzcVar.zzk()) : zzcVar.zzk() == null) && this.zzl.equals(zzcVar.zzl())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((((((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc) * 1000003) ^ this.zzd) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ (true != this.zzf ? 1237 : 1231)) * 1000003) ^ this.zzg.hashCode()) * 1000003) ^ this.zzh.hashCode()) * 1000003) ^ this.zzi.hashCode()) * 1000003) ^ this.zzj.hashCode();
        zznp zznpVar = this.zzk;
        return this.zzl.hashCode() ^ (((iHashCode * 1000003) ^ (zznpVar == null ? 0 : zznpVar.hashCode())) * 1000003);
    }

    public final String toString() {
        zznp zznpVar = this.zzl;
        zznp zznpVar2 = this.zzk;
        zznp zznpVar3 = this.zzj;
        zznp zznpVar4 = this.zzi;
        zznp zznpVar5 = this.zzh;
        String string = this.zzg.toString();
        String string2 = zznpVar5.toString();
        String string3 = zznpVar4.toString();
        String string4 = zznpVar3.toString();
        String strValueOf = String.valueOf(zznpVar2);
        String string5 = zznpVar.toString();
        Boolean bool = this.zzb;
        int length = bool.toString().length();
        int i = this.zzc;
        int length2 = String.valueOf(i).length();
        int i2 = this.zzd;
        int length3 = String.valueOf(i2).length();
        boolean z = this.zzf;
        int length4 = String.valueOf(z).length();
        int length5 = string.length();
        int length6 = string2.length();
        int length7 = string3.length();
        int length8 = string4.length();
        int length9 = String.valueOf(strValueOf).length();
        int length10 = string5.length();
        String str = this.zza;
        int length11 = str.length() + 30 + length + 8 + length2 + 13 + length3;
        String str2 = this.zze;
        StringBuilder sb = new StringBuilder(length11 + 14 + str2.length() + 22 + length4 + 18 + length5 + 29 + length6 + 17 + length7 + 28 + length8 + 19 + length9 + 24 + length10 + 1);
        sb.append("TcData{tcString=");
        sb.append(str);
        sb.append(", gdprApplies=");
        sb.append(bool);
        sb.append(", cmpId=");
        sb.append(i);
        sb.append(", cmpVersion=");
        sb.append(i2);
        sb.append(", publisherCc=");
        sb.append(str2);
        sb.append(", purposeOneTreatment=");
        sb.append(z);
        sb.append(", purposeConsents=");
        sb.append(string);
        sb.append(", purposeLegitimateInterests=");
        sb.append(string2);
        sb.append(", vendorConsents=");
        sb.append(string3);
        sb.append(", vendorLegitimateInterests=");
        sb.append(string4);
        sb.append(", vendorsDisclosed=");
        sb.append(strValueOf);
        sb.append(", publisherRestrictions=");
        sb.append(string5);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final String zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    @Nullable
    final Boolean zzb() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final int zzc() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final int zzd() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final String zze() {
        return this.zze;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final boolean zzf() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final zznp zzg() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final zznp zzh() {
        return this.zzh;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final zznp zzi() {
        return this.zzi;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final zznp zzj() {
        return this.zzj;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    @Nullable
    final zznp zzk() {
        return this.zzk;
    }

    @Override // com.google.ads.interactivemedia.pal.utils.tcf.zzc
    final zznp zzl() {
        return this.zzl;
    }
}
