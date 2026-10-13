package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyg extends zzwq {
    private final zzyl zza;
    private final zzars zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    private zzyg(zzyl zzylVar, zzars zzarsVar, zzarq zzarqVar, @Nullable Integer num) {
        this.zza = zzylVar;
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

    public final zzyl zzf() {
        return this.zza;
    }

    public static zzyg zzd(zzyk zzykVar, zzars zzarsVar, @Nullable Integer num) throws GeneralSecurityException {
        zzarq zzarqVarZzb;
        zzyk zzykVar2 = zzyk.zzc;
        if (zzykVar != zzykVar2 && num == null) {
            String string = zzykVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 62);
            sb.append("For given Variant ");
            sb.append(string);
            sb.append(" the value of idRequirement must be non-null");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzykVar == zzykVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzarsVar.zzc() != 32) {
            int iZzc = zzarsVar.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzc).length() + 74);
            sb2.append("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ");
            sb2.append(iZzc);
            throw new GeneralSecurityException(sb2.toString());
        }
        zzyl zzylVarZzb = zzyl.zzb(zzykVar);
        if (zzylVarZzb.zzc() == zzykVar2) {
            zzarqVarZzb = zzaim.zza;
        } else if (zzylVarZzb.zzc() == zzyk.zzb) {
            zzarqVarZzb = zzaim.zza(num.intValue());
        } else {
            if (zzylVarZzb.zzc() != zzyk.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzylVarZzb.zzc().toString()));
            }
            zzarqVarZzb = zzaim.zzb(num.intValue());
        }
        return new zzyg(zzylVarZzb, zzarsVar, zzarqVarZzb, num);
    }
}
