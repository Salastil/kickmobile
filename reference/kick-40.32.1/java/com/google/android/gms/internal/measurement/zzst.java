package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzst implements zzrt {
    private zzst() {
    }

    public static zzst zzb() {
        return new zzst();
    }

    public static final InputStream zzc(zzrs zzrsVar) throws IOException {
        return (InputStream) zzrsVar.zzc(zzrsVar.zza().zzd(zzrsVar.zzb())).get(0);
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        return zzc(zzrsVar);
    }
}
