package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzahr implements zzwa {
    final String zza;
    final Class zzb;
    final int zzc;

    zzahr(String str, Class cls, int i, zzawd zzawdVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = i;
    }

    public static zzwl zzd(String str, Class cls, zzawd zzawdVar) {
        return new zzahq(str, cls, zzawdVar);
    }

    public static zzwa zze(String str, Class cls, int i, zzawd zzawdVar) {
        return new zzahr(str, cls, i, zzawdVar);
    }

    @Override // com.google.android.gms.internal.pal.zzwa
    public final Object zza(zzatl zzatlVar) throws GeneralSecurityException {
        return zzaii.zza().zzd(zzail.zza().zzg(zzaje.zzf(this.zza, zzatlVar, this.zzc, zzapm.RAW, null), zzvx.zza()), this.zzb);
    }

    @Override // com.google.android.gms.internal.pal.zzwa
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzwa
    public final Class zzc() {
        return this.zzb;
    }
}
