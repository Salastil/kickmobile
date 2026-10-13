package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkr extends zzlp {
    private final zzkl zza;

    @Nullable
    private final ECPoint zzb;

    @Nullable
    private final zzaau zzc;
    private final zzaau zzd;

    @Nullable
    private final Integer zze;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzkl) zza();
    }

    public static zzkr zza(zzkl zzklVar, zzaau zzaauVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzklVar.zzd().equals(zzkl.zzc.zzd)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        zzb(zzklVar.zzg(), num);
        if (zzaauVar.zza() == 32) {
            return new zzkr(zzklVar, null, zzaauVar, zza(zzklVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    }

    public static zzkr zza(zzkl zzklVar, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        if (zzklVar.zzd().equals(zzkl.zzc.zzd)) {
            throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
        }
        zzb(zzklVar.zzg(), num);
        zzkl.zzc zzcVarZzd = zzklVar.zzd();
        if (zzcVarZzd == zzkl.zzc.zza) {
            curve = zznv.zza.getCurve();
        } else if (zzcVarZzd == zzkl.zzc.zzb) {
            curve = zznv.zzb.getCurve();
        } else if (zzcVarZzd == zzkl.zzc.zzc) {
            curve = zznv.zzc.getCurve();
        } else {
            throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzcVarZzd));
        }
        zznv.zza(eCPoint, curve);
        return new zzkr(zzklVar, eCPoint, null, zza(zzklVar.zzg(), num), num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzln zza() {
        return this.zza;
    }

    private static zzaau zza(zzkl.zzd zzdVar, @Nullable Integer num) {
        if (zzdVar == zzkl.zzd.zzc) {
            return zzpj.zza;
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzdVar));
        }
        if (zzdVar == zzkl.zzd.zzb) {
            return zzpj.zza(num.intValue());
        }
        if (zzdVar == zzkl.zzd.zza) {
            return zzpj.zzb(num.intValue());
        }
        throw new IllegalStateException("Unknown EciesParameters.Variant: " + String.valueOf(zzdVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    public final zzaau zzd() {
        return this.zzd;
    }

    @Nullable
    public final zzaau zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Nullable
    public final ECPoint zzf() {
        return this.zzb;
    }

    private zzkr(zzkl zzklVar, @Nullable ECPoint eCPoint, @Nullable zzaau zzaauVar, zzaau zzaauVar2, @Nullable Integer num) {
        this.zza = zzklVar;
        this.zzb = eCPoint;
        this.zzc = zzaauVar;
        this.zzd = zzaauVar2;
        this.zze = num;
    }

    private static void zzb(zzkl.zzd zzdVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzdVar.equals(zzkl.zzd.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzdVar) + " variant.");
        }
        if (zzdVar.equals(zzkl.zzd.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }
}
