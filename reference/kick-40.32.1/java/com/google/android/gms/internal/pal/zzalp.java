package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalp extends zzals {
    private final zzalq zza;
    private final zzars zzb;

    private zzalp(zzalq zzalqVar, zzars zzarsVar) {
        this.zza = zzalqVar;
        this.zzb = zzarsVar;
    }

    public static zzalp zzc(zzalq zzalqVar, zzars zzarsVar) throws GeneralSecurityException {
        if (zzalqVar.zzc() == zzarsVar.zzc()) {
            return new zzalp(zzalqVar, zzarsVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.pal.zzals, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return null;
    }

    public final zzars zzd() {
        return this.zzb;
    }
}
