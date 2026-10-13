package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzl extends zzd {
    zzl() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final void zza(zzm zzmVar, zzm zzmVar2) {
        zzmVar.zzc = zzmVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final void zzb(zzm zzmVar, Thread thread) {
        zzmVar.zzb = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zzc(zzo zzoVar, zzh zzhVar, zzh zzhVar2) {
        synchronized (zzoVar) {
            if (zzoVar.zzd != zzhVar) {
                return false;
            }
            zzoVar.zzd = zzhVar2;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zzd(zzo zzoVar, Object obj, Object obj2) {
        synchronized (zzoVar) {
            if (zzoVar.zzc != obj) {
                return false;
            }
            zzoVar.zzc = obj2;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zze(zzo zzoVar, zzm zzmVar, zzm zzmVar2) {
        synchronized (zzoVar) {
            if (zzoVar.zze != zzmVar) {
                return false;
            }
            zzoVar.zze = zzmVar2;
            return true;
        }
    }
}
