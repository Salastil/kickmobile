package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzasq extends zzasb {
    public static final zzasq zza = new zzasq();

    private zzasq() {
    }

    public final void zza(zzasu zzasuVar, zzarv zzarvVar) throws IOException {
        if (zzarvVar == null || (zzarvVar instanceof zzarw)) {
            zzasuVar.zzj();
            return;
        }
        if (zzarvVar instanceof zzarz) {
            zzarz zzarzVarZzg = zzarvVar.zzg();
            if (zzarzVarZzg.zzc()) {
                zzasuVar.zzi(zzarzVarZzg.zzh());
                return;
            } else if (zzarzVarZzg.zza()) {
                zzasuVar.zzh(zzarzVarZzg.zzb());
                return;
            } else {
                zzasuVar.zzg(zzarzVarZzg.zzd());
                return;
            }
        }
        if (zzarvVar instanceof zzaru) {
            zzasuVar.zzb();
            Iterator it = zzarvVar.zzf().iterator();
            while (it.hasNext()) {
                zza(zzasuVar, (zzarv) it.next());
            }
            zzasuVar.zzc();
            return;
        }
        if (!(zzarvVar instanceof zzarx)) {
            String strValueOf = String.valueOf(zzarvVar.getClass());
            String.valueOf(strValueOf);
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(strValueOf)));
        }
        zzasuVar.zzd();
        for (Map.Entry entry : zzarvVar.zze().zzb()) {
            zzasuVar.zzf((String) entry.getKey());
            zza(zzasuVar, (zzarv) entry.getValue());
        }
        zzasuVar.zze();
    }
}
