package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabg extends zzabh {
    private final zzabf zza;

    private zzabg(zzza zzzaVar, int i, zzabf zzabfVar) {
        super(zzzaVar, i);
        this.zza = zzabfVar;
        StringBuilder sb = new StringBuilder("%");
        zzzaVar.zzl(sb);
        sb.append(true != zzzaVar.zzk() ? 't' : 'T');
        sb.append(zzabfVar.zzb());
    }

    public static zzabh zza(zzabf zzabfVar, zzza zzzaVar, int i) {
        return new zzabg(zzzaVar, i, zzabfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzabh
    protected final void zzb(zzabi zzabiVar, Object obj) {
        zzabiVar.zzd(obj, this.zza, zzd());
    }
}
