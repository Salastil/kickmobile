package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqs implements zzvr {
    private final zzarh zza;
    private final zzwj zzb;
    private final byte[] zzc;

    private zzaqs(zzarh zzarhVar, zzwj zzwjVar, int i, byte[] bArr) {
        this.zza = zzarhVar;
        this.zzb = zzwjVar;
        this.zzc = bArr;
    }

    public static zzvr zzb(zzwx zzwxVar) throws GeneralSecurityException {
        zzaqa zzaqaVar = new zzaqa(zzwxVar.zze().zzb(zzvx.zza()), zzwxVar.zzg().zzf());
        String strValueOf = String.valueOf(zzwxVar.zzg().zzh());
        String.valueOf(strValueOf);
        String strValueOf2 = String.valueOf(strValueOf);
        return new zzaqs(zzaqaVar, new zzarm(new zzarl("HMAC".concat(strValueOf2), new SecretKeySpec(zzwxVar.zzf().zzb(zzvx.zza()), "HMAC")), zzwxVar.zzg().zze()), zzwxVar.zzg().zze(), zzwxVar.zzc().zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZza = this.zza.zza(bArr);
        return zzaqj.zza(this.zzc, bArrZza, this.zzb.zza(zzaqj.zza(bArr2, bArrZza, Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8))));
    }
}
