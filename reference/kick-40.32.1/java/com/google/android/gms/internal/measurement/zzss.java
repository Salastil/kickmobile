package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzss implements zzrt {
    private final zzafj zza;
    private final zzadf zzb = zzadf.zza();

    private zzss(zzafj zzafjVar) {
        this.zza = zzafjVar;
    }

    public static zzss zzb(zzafc zzafcVar) {
        return new zzss(zzafcVar.zzcj());
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        InputStream inputStreamZzc = zzst.zzc(zzrsVar);
        try {
            zzafc zzafcVar = (zzafc) this.zza.zza(inputStreamZzc, this.zzb);
            if (inputStreamZzc != null) {
                inputStreamZzc.close();
            }
            return zzafcVar;
        } catch (Throwable th) {
            if (inputStreamZzc != null) {
                try {
                    inputStreamZzc.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
