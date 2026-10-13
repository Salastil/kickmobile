package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqo {
    private final ECPublicKey zza;

    public zzaqo(ECPublicKey eCPublicKey) {
        this.zza = eCPublicKey;
    }

    public final zzaqn zza(String str, byte[] bArr, byte[] bArr2, int i, zzaqq zzaqqVar) throws GeneralSecurityException {
        ECPublicKey eCPublicKey = this.zza;
        KeyPair keyPairZze = zzaqr.zze(eCPublicKey.getParams());
        ECPublicKey eCPublicKey2 = (ECPublicKey) keyPairZze.getPublic();
        byte[] bArrZzf = zzaqr.zzf((ECPrivateKey) keyPairZze.getPrivate(), eCPublicKey);
        byte[] bArrZzc = zzaqr.zzc(eCPublicKey2.getParams().getCurve(), zzaqqVar, eCPublicKey2.getW());
        byte[] bArrZza = zzaqj.zza(bArrZzc, bArrZzf);
        Mac mac = (Mac) zzaqx.zzb.zzb(str);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr, str));
        }
        byte[] bArr3 = new byte[i];
        mac.init(new SecretKeySpec(mac.doFinal(bArrZza), str));
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
                return new zzaqn(bArrZzc, bArr3);
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, i3, length);
            i2++;
            i3 = i4;
        }
    }
}
