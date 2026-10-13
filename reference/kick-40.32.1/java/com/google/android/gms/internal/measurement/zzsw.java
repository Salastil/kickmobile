package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsw implements zzrt {
    private zzro[] zza;

    private zzsw() {
    }

    public static zzsw zzb() {
        return new zzsw();
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        List listZzd = zzrsVar.zzd(zzrsVar.zza().zzj(zzrsVar.zzb()));
        zzro[] zzroVarArr = this.zza;
        if (zzroVarArr != null) {
            zzroVarArr[0].zza(listZzd);
        }
        return (OutputStream) listZzd.get(0);
    }

    public final zzsw zzc(zzro... zzroVarArr) {
        this.zza = zzroVarArr;
        return this;
    }
}
