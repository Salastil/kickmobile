package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafy implements zzagd {
    private final String zza;

    zzafy(String str) {
        this.zza = str;
    }

    private final byte[] zzf(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzaqx zzaqxVar = zzaqx.zzb;
        String str = this.zza;
        Mac mac = (Mac) zzaqxVar.zzb(str);
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        return mac.doFinal(bArr);
    }

    private final byte[] zzg(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        zzaqx zzaqxVar = zzaqx.zzb;
        String str = this.zza;
        Mac mac = (Mac) zzaqxVar.zzb(str);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        mac.init(new SecretKeySpec(bArr, str));
        byte[] bArrDoFinal = new byte[0];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr2);
            mac.update((byte) i2);
            bArrDoFinal = mac.doFinal();
            int length = bArrDoFinal.length;
            int i4 = i3 + length;
            if (i4 >= i) {
                System.arraycopy(bArrDoFinal, 0, bArr3, i3, i - i3);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, i3, length);
            i2++;
            i3 = i4;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzagd
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zzf(zzagm.zzd(str, bArr2, bArr3), bArr);
    }

    @Override // com.google.android.gms.internal.pal.zzagd
    public final byte[] zzb(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException {
        return zzg(bArr, zzagm.zze(str, bArr2, bArr3, i), i);
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) throws GeneralSecurityException {
        return zzg(zzf(zzagm.zzd("eae_prk", bArr2, bArr4), null), zzagm.zze("shared_secret", bArr3, bArr4, i), i);
    }

    final int zze() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.pal.zzagd
    public final byte[] zzd() throws GeneralSecurityException {
        String str = this.zza;
        int iHashCode = str.hashCode();
        if (iHashCode != 984523022) {
            if (iHashCode != 984524074) {
                if (iHashCode == 984525777 && str.equals("HmacSha512")) {
                    return zzagm.zzh;
                }
            } else if (str.equals("HmacSha384")) {
                return zzagm.zzg;
            }
        } else if (str.equals("HmacSha256")) {
            return zzagm.zzf;
        }
        throw new GeneralSecurityException("Could not determine HPKE KDF ID");
    }
}
