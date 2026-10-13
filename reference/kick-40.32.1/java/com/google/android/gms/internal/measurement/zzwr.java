package com.google.android.gms.internal.measurement;

import android.os.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwr {
    static void zza(zzws zzwsVar, zzws zzwsVar2) {
        if (zzwsVar != null) {
            if (zzwsVar2 != null) {
                if (zzwsVar.zzb() == zzwsVar2 && !zzd(zzwsVar)) {
                    Trace.endSection();
                    return;
                } else if (zzwsVar == zzwsVar2.zzb() && !zzd(zzwsVar2)) {
                    zze(zzwsVar2);
                    return;
                }
            }
            zzc(zzwsVar);
        }
        if (zzwsVar2 != null) {
            zzb(zzwsVar2);
        }
    }

    static void zzb(zzws zzwsVar) {
        if (zzd(zzwsVar) || zzwsVar.zzb() == null) {
            Trace.beginSection(zzwsVar.zzd());
            zze(zzwsVar);
        } else {
            zzb(zzwsVar.zzb());
            zze(zzwsVar);
        }
    }

    static void zzc(zzws zzwsVar) {
        if (zzd(zzwsVar) || zzwsVar.zzb() == null) {
            Trace.endSection();
            Trace.endSection();
        } else {
            Trace.endSection();
            zzc(zzwsVar.zzb());
        }
    }

    private static boolean zzd(zzws zzwsVar) {
        return zzwsVar.zza() != Thread.currentThread();
    }

    private static void zze(zzws zzwsVar) {
        String strZze = zzwsVar.zze();
        int i = zzvy.zzb;
        if (strZze.length() > 127) {
            strZze = strZze.substring(0, 127);
        }
        Trace.beginSection(strZze);
    }
}
