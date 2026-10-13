package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlk {
    public static final zzxk zza;
    private static final byte[] zzb;

    @Deprecated
    private static zzxk zza(zzwb zzwbVar, zzwh zzwhVar, zzvk zzvkVar, zzxk zzxkVar, zzyi zzyiVar, byte[] bArr) {
        zzvm.zza zzaVarZza = zzvm.zza();
        zzvy zzvyVar = (zzvy) ((zzalt) zzvy.zza().zza(zzwbVar).zza(zzwhVar).zza(zzakb.zza(bArr)).zze());
        return (zzxk) ((zzalt) zzxk.zza().zza(zzkh.zza()).zza(zzyiVar).zza(((zzvm) ((zzalt) zzaVarZza.zza((zzvp) ((zzalt) zzvp.zzc().zza(zzvyVar).zza((zzvj) ((zzalt) zzvj.zza().zza(zzxkVar).zze())).zza(zzvkVar).zze())).zze())).a_()).zze());
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zza = zza(zzwb.NIST_P256, zzwh.SHA256, zzvk.UNCOMPRESSED, zzdl.zza, zzyi.TINK, bArr);
        zza(zzwb.NIST_P256, zzwh.SHA256, zzvk.COMPRESSED, zzdl.zza, zzyi.RAW, bArr);
        zza(zzwb.NIST_P256, zzwh.SHA256, zzvk.UNCOMPRESSED, zzdl.zzc, zzyi.TINK, bArr);
    }
}
