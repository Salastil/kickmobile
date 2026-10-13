package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafm implements zzafp {
    private final zzxf zza;
    private final int zzb;

    public zzafm(zzxf zzxfVar) {
        this.zza = zzxfVar;
        this.zzb = zzxfVar.zzc() + zzxfVar.zzd();
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        zzxf zzxfVar = this.zza;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, zzxfVar.zzc());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, zzxfVar.zzc(), zzxfVar.zzc() + zzxfVar.zzd());
        zzww zzwwVarZzd = zzwx.zzd();
        zzwwVarZzd.zza(zzxfVar);
        zzwwVarZzd.zzb(zzars.zza(bArrCopyOf, zzvx.zza()));
        zzwwVarZzd.zzc(zzars.zza(bArrCopyOfRange, zzvx.zza()));
        return zzaqj.zza(bArr2, bArr3, zzaqs.zzb(zzwwVarZzd.zze()).zza(bArr4, zzafq.zza));
    }
}
