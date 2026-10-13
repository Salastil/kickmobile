package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzv extends zzwq {
    private final zzaaa zza;
    private final zzars zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    private zzzv(zzaaa zzaaaVar, zzars zzarsVar, zzarq zzarqVar, @Nullable Integer num) {
        this.zza = zzaaaVar;
        this.zzb = zzarsVar;
        this.zzc = zzarqVar;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.pal.zzwq, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzwq
    public final zzarq zzc() {
        return this.zzc;
    }

    public final zzars zze() {
        return this.zzb;
    }

    public final zzaaa zzf() {
        return this.zza;
    }

    public static zzzv zzd(zzaaa zzaaaVar, zzars zzarsVar, @Nullable Integer num) throws GeneralSecurityException {
        zzarq zzarqVarZzb;
        zzzz zzzzVarZzc = zzaaaVar.zzc();
        zzzz zzzzVar = zzzz.zzb;
        if (zzzzVarZzc != zzzzVar && num == null) {
            String string = zzaaaVar.zzc().toString();
            StringBuilder sb = new StringBuilder(string.length() + 62);
            sb.append("For given Variant ");
            sb.append(string);
            sb.append(" the value of idRequirement must be non-null");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzaaaVar.zzc() == zzzzVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzarsVar.zzc() != 32) {
            int iZzc = zzarsVar.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzc).length() + 68);
            sb2.append("XAesGcmKey key must be constructed with key of length 32 bytes, not ");
            sb2.append(iZzc);
            throw new GeneralSecurityException(sb2.toString());
        }
        if (zzaaaVar.zzc() == zzzzVar) {
            zzarqVarZzb = zzaim.zza;
        } else {
            if (zzaaaVar.zzc() != zzzz.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzaaaVar.zzc().toString()));
            }
            zzarqVarZzb = zzaim.zzb(num.intValue());
        }
        return new zzzv(zzaaaVar, zzarsVar, zzarqVarZzb, num);
    }
}
