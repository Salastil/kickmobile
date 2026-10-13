package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarm implements zzwj {
    private static final byte[] zza = {0};
    private final zzalr zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzarm(zzajr zzajrVar) throws GeneralSecurityException {
        this.zzb = zzarj.zzb(zzalp.zzc(zzalq.zzb(zzajrVar.zzf().zzc()), zzajrVar.zzd()));
        this.zzc = zzajrVar.zzf().zzd();
        this.zzd = zzajrVar.zze().zzb();
        if (zzajrVar.zzf().zzf().equals(zzajx.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzwj zzb(zzajr zzajrVar) throws GeneralSecurityException {
        return new zzarm(zzajrVar);
    }

    public static zzwj zzc(zzakd zzakdVar) throws GeneralSecurityException {
        return new zzarm(zzakdVar);
    }

    @Override // com.google.android.gms.internal.pal.zzwj
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        byte[] bArr3 = this.zzd;
        return length > 0 ? zzaqj.zza(bArr3, this.zzb.zza(zzaqj.zza(bArr, bArr2), this.zzc)) : zzaqj.zza(bArr3, this.zzb.zza(bArr, this.zzc));
    }

    private zzarm(zzakd zzakdVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(zzakdVar.zzf().zzg());
        String.valueOf(strValueOf);
        String strValueOf2 = String.valueOf(strValueOf);
        this.zzb = new zzarl("HMAC".concat(strValueOf2), new SecretKeySpec(zzakdVar.zzd().zzb(zzvx.zza()), "HMAC"));
        this.zzc = zzakdVar.zzf().zzd();
        this.zzd = zzakdVar.zze().zzb();
        if (zzakdVar.zzf().zzf().equals(zzakl.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzarm(zzalr zzalrVar, int i) throws GeneralSecurityException {
        this.zzb = zzalrVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzalrVar.zza(new byte[0], i);
    }
}
