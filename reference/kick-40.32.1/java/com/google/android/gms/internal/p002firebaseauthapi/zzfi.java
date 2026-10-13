package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfi extends zzdm {
    private final zzfh zza;
    private final zzaau zzb;

    @Nullable
    private final Integer zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzfh) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzdo zza() {
        return this.zza;
    }

    public static zzfi zza(zzfh zzfhVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaau zzaauVarZza;
        if (zzfhVar.zzb() == zzfh.zza.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzaauVarZza = zzaau.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzfhVar.zzb() != zzfh.zza.zzb) {
                throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzfhVar.zzb()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzaauVarZza = zzaau.zza(new byte[0]);
        }
        return new zzfi(zzfhVar, zzaauVarZza, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    public final zzaau zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final Integer zzb() {
        return this.zzc;
    }

    private zzfi(zzfh zzfhVar, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzfhVar;
        this.zzb = zzaauVar;
        this.zzc = num;
    }
}
