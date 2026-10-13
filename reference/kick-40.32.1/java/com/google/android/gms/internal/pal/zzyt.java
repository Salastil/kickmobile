package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyt extends zzwq {
    private final zzyv zza;
    private final zzarq zzb;

    @Nullable
    private final Integer zzc;

    private zzyt(zzyv zzyvVar, zzarq zzarqVar, @Nullable Integer num) {
        this.zza = zzyvVar;
        this.zzb = zzarqVar;
        this.zzc = num;
    }

    public static zzyt zzd(zzyv zzyvVar, @Nullable Integer num) throws GeneralSecurityException {
        zzarq zzarqVarZza;
        if (zzyvVar.zzd() == zzyu.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzarqVarZza = zzarq.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzyvVar.zzd() != zzyu.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzyvVar.zzd().toString()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzarqVarZza = zzarq.zza(new byte[0]);
        }
        return new zzyt(zzyvVar, zzarqVarZza, num);
    }

    @Override // com.google.android.gms.internal.pal.zzwq, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzwq
    public final zzarq zzc() {
        return this.zzb;
    }

    public final zzyv zze() {
        return this.zza;
    }
}
