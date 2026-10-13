package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzck;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzg extends zzs {
    private zzck zza;
    private zzck zzb;
    private zzck zzc;
    private zzck zzd;
    private zzck zze;
    private int zzf;
    private byte zzg;

    zzg() {
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zza(zzck zzckVar) {
        this.zza = zzckVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zzb(zzck zzckVar) {
        this.zzb = zzckVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zzc(zzck zzckVar) {
        this.zzc = zzckVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zzd(zzck zzckVar) {
        this.zzd = zzckVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zze(zzck zzckVar) {
        this.zze = zzckVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzs zzf(int i) {
        this.zzf = i;
        this.zzg = (byte) 1;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzs
    final zzt zzg() {
        zzck zzckVar;
        zzck zzckVar2;
        zzck zzckVar3;
        zzck zzckVar4;
        zzck zzckVar5;
        if (this.zzg == 1 && (zzckVar = this.zza) != null && (zzckVar2 = this.zzb) != null && (zzckVar3 = this.zzc) != null && (zzckVar4 = this.zzd) != null && (zzckVar5 = this.zze) != null) {
            return new zzh(zzckVar, zzckVar2, zzckVar3, zzckVar4, zzckVar5, this.zzf, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" nonceLoaderInitTime");
        }
        if (this.zzb == null) {
            sb.append(" nonceRequestTime");
        }
        if (this.zzc == null) {
            sb.append(" nonceLoadedTime");
        }
        if (this.zzd == null) {
            sb.append(" resourceFetchStartTime");
        }
        if (this.zze == null) {
            sb.append(" resourceFetchEndTime");
        }
        if (this.zzg == 0) {
            sb.append(" nonceLength");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
