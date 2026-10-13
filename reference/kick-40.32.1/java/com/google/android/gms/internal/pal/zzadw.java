package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzadw implements zzajn {
    static final /* synthetic */ zzadw zza = new zzadw();

    private /* synthetic */ zzadw() {
    }

    @Override // com.google.android.gms.internal.pal.zzajn
    public final /* synthetic */ Object zza() throws GeneralSecurityException {
        int i = zzaea.zza;
        HashSet hashSet = new HashSet();
        zzxu zzxuVarZzb = zzxw.zzb();
        zzxuVarZzb.zzb(12);
        zzxuVarZzb.zza(16);
        zzxuVarZzb.zzc(16);
        zzxv zzxvVar = zzxv.zzc;
        zzxuVarZzb.zzd(zzxvVar);
        hashSet.add(zzxuVarZzb.zze());
        zzxu zzxuVarZzb2 = zzxw.zzb();
        zzxuVarZzb2.zzb(12);
        zzxuVarZzb2.zza(32);
        zzxuVarZzb2.zzc(16);
        zzxuVarZzb2.zzd(zzxvVar);
        hashSet.add(zzxuVarZzb2.zze());
        zzxc zzxcVarZzb = zzxf.zzb();
        zzxcVarZzb.zza(16);
        zzxcVarZzb.zzb(32);
        zzxcVarZzb.zzd(16);
        zzxcVarZzb.zzc(16);
        zzxd zzxdVar = zzxd.zzc;
        zzxcVarZzb.zzf(zzxdVar);
        zzxe zzxeVar = zzxe.zzc;
        zzxcVarZzb.zze(zzxeVar);
        hashSet.add(zzxcVarZzb.zzg());
        zzxc zzxcVarZzb2 = zzxf.zzb();
        zzxcVarZzb2.zza(32);
        zzxcVarZzb2.zzb(32);
        zzxcVarZzb2.zzd(32);
        zzxcVarZzb2.zzc(16);
        zzxcVarZzb2.zzf(zzxdVar);
        zzxcVarZzb2.zze(zzxeVar);
        hashSet.add(zzxcVarZzb2.zzg());
        hashSet.add(zzaah.zzb());
        zzacx zzacxVarZzb = zzacz.zzb();
        zzacxVarZzb.zza(64);
        zzacxVarZzb.zzb(zzacy.zzc);
        hashSet.add(zzacxVarZzb.zzc());
        return Collections.unmodifiableSet(hashSet);
    }
}
