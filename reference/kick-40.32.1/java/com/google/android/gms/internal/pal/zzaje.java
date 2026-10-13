package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaje implements zzaji {
    private final String zza;
    private final zzarq zzb;
    private final zzatl zzc;
    private final zzapm zzd;

    @Nullable
    private final Integer zze;
    private final int zzf;

    private zzaje(String str, zzarq zzarqVar, zzatl zzatlVar, int i, zzapm zzapmVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzarqVar;
        this.zzc = zzatlVar;
        this.zzf = i;
        this.zzd = zzapmVar;
        this.zze = num;
    }

    public static zzaje zzf(String str, zzatl zzatlVar, int i, zzapm zzapmVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzapmVar == zzapm.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzaje(str, zzajp.zzb(str), zzatlVar, i, zzapmVar, num);
    }

    public final zzatl zza() {
        return this.zzc;
    }

    public final zzapm zzb() {
        return this.zzd;
    }

    @Nullable
    public final Integer zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.pal.zzaji
    public final zzarq zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    public final int zzg() {
        return this.zzf;
    }
}
