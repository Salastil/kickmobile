package com.google.android.gms.internal.pal;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpp extends zzpq {
    private final String zzb;
    private final int zzd;
    private final String zze;
    private int zzf = 0;
    private final String zzc = "decode";

    /* synthetic */ zzpp(String str, String str2, int i, String str3, byte[] bArr) {
        this.zzb = str;
        this.zzd = i;
        this.zze = str3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpp) {
            zzpp zzppVar = (zzpp) obj;
            if (this.zzc.equals(zzppVar.zzc) && this.zzd == zzppVar.zzd) {
                String str = this.zzb;
                String str2 = zzppVar.zzb;
                if (str != str2) {
                    if (str.length() == str2.length()) {
                        for (int i = 0; i < str.length(); i++) {
                            char cCharAt = str.charAt(i);
                            char cCharAt2 = str2.charAt(i);
                            if (cCharAt == cCharAt2 || ((cCharAt & (-2)) == 46 && (cCharAt ^ cCharAt2) == 1)) {
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((this.zzc.hashCode() + 4867) * 31) + this.zzd;
        this.zzf = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.pal.zzpq
    public final String zza() {
        return this.zzb.replace('/', FilenameUtils.EXTENSION_SEPARATOR);
    }

    @Override // com.google.android.gms.internal.pal.zzpq
    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzpq
    public final int zzc() {
        return (char) this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzpq
    public final String zzd() {
        String str = this.zze;
        return str.substring(str.lastIndexOf(File.separatorChar) + 1);
    }

    @Override // com.google.android.gms.internal.pal.zzpq
    public final String zze() {
        return this.zze;
    }
}
