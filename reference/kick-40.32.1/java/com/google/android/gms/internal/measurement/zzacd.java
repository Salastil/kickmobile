package com.google.android.gms.internal.measurement;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzacd implements zzafj {
    static {
        int i = zzadf.zzb;
        int i2 = zzacf.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafj
    public final /* synthetic */ Object zza(InputStream inputStream, zzadf zzadfVar) throws zzaeh {
        zzafy zzafyVar;
        zzacv zzacvVarZzM = zzacv.zzM(inputStream, 4096);
        zzafc zzafcVar = (zzafc) zzb(zzacvVarZzM, zzadfVar);
        zzacvVarZzM.zzb(0);
        if (zzafcVar == null || zzafcVar.zzcJ()) {
            return zzafcVar;
        }
        if (zzafcVar instanceof zzacb) {
            zzafyVar = new zzafy((zzacb) zzafcVar);
        } else {
            if (zzafcVar instanceof zzacc) {
                throw null;
            }
            zzafyVar = new zzafy(zzafcVar);
        }
        throw zzafyVar.zza();
    }
}
