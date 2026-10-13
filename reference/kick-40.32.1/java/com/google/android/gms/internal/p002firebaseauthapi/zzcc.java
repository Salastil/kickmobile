package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcc {
    private final List<zzcb> zza = new ArrayList();
    private final Map<Class<?>, zzbl> zzb = new HashMap();
    private boolean zzc = false;

    public final zzcc zza(zzcb zzcbVar) {
        if (zzcbVar.zze != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzcbVar.zza) {
            zzb();
        }
        zzcbVar.zze = this;
        this.zza.add(zzcbVar);
        return this;
    }

    public final zzbx zza() throws GeneralSecurityException {
        int iZza;
        zzxh zzxhVar;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        ArrayList arrayList = new ArrayList(this.zza.size());
        List<zzcb> list = this.zza;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).zzd == zzce.zza && list.get(i + 1).zzd != zzce.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
        }
        HashSet hashSet = new HashSet();
        Integer numValueOf = null;
        for (zzcb zzcbVar : this.zza) {
            if (zzcbVar.zzb == null) {
                throw new GeneralSecurityException("Key Status not set.");
            }
            if (zzcbVar.zzd == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzcbVar.zzd == zzce.zza) {
                iZza = 0;
                while (true) {
                    if (iZza != 0 && !hashSet.contains(Integer.valueOf(iZza))) {
                        break;
                    }
                    iZza = zzqu.zza();
                }
            } else {
                iZza = zzce.zza(zzcbVar.zzd);
            }
            int i2 = iZza;
            if (hashSet.contains(Integer.valueOf(i2))) {
                throw new GeneralSecurityException("Id " + i2 + " is used twice in the keyset");
            }
            hashSet.add(Integer.valueOf(i2));
            zzbt zzbtVarZza = zzoy.zza().zza(zzcbVar.zzc, zzcbVar.zzc.zza() ? Integer.valueOf(i2) : null);
            zzbv zzbvVar = zzcbVar.zzb;
            if (zzbv.zza.equals(zzbvVar)) {
                zzxhVar = zzxh.ENABLED;
            } else if (zzbv.zzb.equals(zzbvVar)) {
                zzxhVar = zzxh.DISABLED;
            } else if (zzbv.zzc.equals(zzbvVar)) {
                zzxhVar = zzxh.DESTROYED;
            } else {
                throw new IllegalStateException("Unknown key status");
            }
            zzcd zzcdVar = new zzcd(zzbtVarZza, zzxhVar, i2, zzcbVar.zza, false, zzcd.zza);
            if (zzcbVar.zza) {
                if (numValueOf != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                numValueOf = Integer.valueOf(i2);
                if (zzcbVar.zzb != zzbv.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
            }
            arrayList.add(zzcdVar);
        }
        if (numValueOf == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        return zzbx.zzb(new zzbx(arrayList, this.zzb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        Iterator<zzcb> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().zza = false;
        }
    }
}
