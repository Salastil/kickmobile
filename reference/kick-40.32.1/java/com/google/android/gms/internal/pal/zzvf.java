package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzvf {
    static final zzawy zza(zzur zzurVar) {
        int iZza = zzurVar.zza(18);
        Integer.valueOf(iZza).getClass();
        int iZza2 = zzurVar.zza(18);
        Integer.valueOf(iZza2).getClass();
        return zzaxr.zza(((((long) iZza) << 18) | ((long) iZza2)) * 100);
    }

    static final String zzb(zzur zzurVar) {
        String strZzh = zzh(zzurVar);
        String strZzh2 = zzh(zzurVar);
        String.valueOf(strZzh);
        String.valueOf(strZzh2);
        return String.valueOf(strZzh).concat(String.valueOf(strZzh2));
    }

    static final zznm zzc(zzur zzurVar) {
        final int iZza = zzurVar.zza(16);
        Integer.valueOf(iZza).getClass();
        if (!zzf(zzurVar).booleanValue()) {
            return zze(iZza, zzurVar);
        }
        zznm zznmVarZzd = zzd(zzurVar);
        zznmVarZzd.forEach(new Consumer() { // from class: com.google.android.gms.internal.pal.zzve
            @Override // java.util.function.Consumer
            public final /* synthetic */ void accept(Object obj) {
                zzls.zzg(((Integer) obj).intValue() <= iZza, "ID is past maxVendorId.");
            }
        });
        return zznmVarZzd;
    }

    static final zznm zzd(zzur zzurVar) {
        zznu zznuVar = new zznu(zzod.zza());
        int iZza = zzurVar.zza(12);
        Integer.valueOf(iZza).getClass();
        while (iZza > 0) {
            iZza--;
            boolean zBooleanValue = zzf(zzurVar).booleanValue();
            int iZza2 = zzurVar.zza(16);
            Integer.valueOf(iZza2).getClass();
            if (zBooleanValue) {
                int iZza3 = zzurVar.zza(16);
                Integer.valueOf(iZza3).getClass();
                final IntStream intStreamRangeClosed = IntStream.rangeClosed(iZza2, iZza3);
                Objects.requireNonNull(intStreamRangeClosed);
                zznuVar.zzh(new Iterable() { // from class: com.google.android.gms.internal.pal.zzvd
                    @Override // java.lang.Iterable
                    public final /* synthetic */ Iterator iterator() {
                        return intStreamRangeClosed.iterator();
                    }
                });
            } else {
                zznuVar.zzg(Integer.valueOf(iZza2));
            }
        }
        return zznuVar.zzf().zzh();
    }

    static final zznm zze(int i, zzur zzurVar) {
        int i2 = zznm.zzd;
        zzni zzniVar = new zzni();
        int i3 = 0;
        while (i3 < i) {
            i3++;
            if (zzf(zzurVar).booleanValue()) {
                zzniVar.zzd(Integer.valueOf(i3));
            }
        }
        return zzniVar.zzf();
    }

    static final Boolean zzf(zzur zzurVar) {
        int iZza = zzurVar.zza(1);
        Integer.valueOf(iZza).getClass();
        return Boolean.valueOf(iZza == 1);
    }

    static final Boolean zzg(zzur zzurVar) {
        while (zzurVar.zzb() > 0) {
            if (zzurVar.zza(Math.min(32, zzurVar.zzb())) != 0) {
                return false;
            }
        }
        return true;
    }

    private static final String zzh(zzur zzurVar) {
        int iZza = zzurVar.zza(6);
        Integer.valueOf(iZza).getClass();
        char c = (char) (iZza + 97);
        if (c < 'a' || c > 'z') {
            throw new IllegalStateException(zzmd.zzc("Invalid character, expected in range [a,z], got: %s.", Character.valueOf(c)));
        }
        return Character.toString(c);
    }
}
