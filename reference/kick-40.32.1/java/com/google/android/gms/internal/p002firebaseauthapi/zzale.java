package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzale {
    private final zzaky zza;

    public static zzale zza(zzaky zzakyVar) {
        return zzakyVar.zza != null ? (zzale) zzakyVar.zza : new zzale(zzakyVar);
    }

    private zzale(zzaky zzakyVar) {
        zzaky zzakyVar2 = (zzaky) zzalw.zza(zzakyVar, "output");
        this.zza = zzakyVar2;
        zzakyVar2.zza = this;
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zza(i, z);
    }

    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajz)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    i3++;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        zzajz zzajzVar = (zzajz) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzajzVar.size(); i6++) {
                zzajzVar.zzb(i6);
                i5++;
            }
            this.zza.zzc(i5);
            while (i2 < zzajzVar.size()) {
                this.zza.zza(zzajzVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzajzVar.size()) {
            this.zza.zza(i, zzajzVar.zzb(i2));
            i2++;
        }
    }

    public final void zza(int i, zzakb zzakbVar) throws IOException {
        this.zza.zza(i, zzakbVar);
    }

    public final void zza(int i, List<zzakb> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zza(i, d);
    }

    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzald)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    i3 += 8;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).doubleValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        zzald zzaldVar = (zzald) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzaldVar.size(); i6++) {
                zzaldVar.zzb(i6);
                i5 += 8;
            }
            this.zza.zzc(i5);
            while (i2 < zzaldVar.size()) {
                this.zza.zza(zzaldVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaldVar.size()) {
            this.zza.zza(i, zzaldVar.zzb(i2));
            i2++;
        }
    }

    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzc(i, 4);
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzaky.zzc(list.get(i3).intValue());
                }
                this.zza.zzc(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzaluVar.size(); i4++) {
                iZzc2 += zzaky.zzc(zzaluVar.zzb(i4));
            }
            this.zza.zzc(iZzc2);
            while (i2 < zzaluVar.size()) {
                this.zza.zzb(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zzb(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    i3 += 4;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzaluVar.size(); i6++) {
                zzaluVar.zzb(i6);
                i5 += 4;
            }
            this.zza.zzc(i5);
            while (i2 < zzaluVar.size()) {
                this.zza.zza(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zza(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzamm)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    i3 += 8;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzamm zzammVar = (zzamm) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzammVar.size(); i6++) {
                zzammVar.zzb(i6);
                i5 += 8;
            }
            this.zza.zzc(i5);
            while (i2 < zzammVar.size()) {
                this.zza.zza(zzammVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzammVar.size()) {
            this.zza.zza(i, zzammVar.zzb(i2));
            i2++;
        }
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zza(i, f);
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzals)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    i3 += 4;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).floatValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        zzals zzalsVar = (zzals) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzalsVar.size(); i6++) {
                zzalsVar.zzb(i6);
                i5 += 4;
            }
            this.zza.zzc(i5);
            while (i2 < zzalsVar.size()) {
                this.zza.zza(zzalsVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzalsVar.size()) {
            this.zza.zza(i, zzalsVar.zzb(i2));
            i2++;
        }
    }

    public final void zza(int i, Object obj, zzanl zzanlVar) throws IOException {
        this.zza.zzc(i, 3);
        zzanlVar.zza((zzaju) obj, this);
        this.zza.zzc(i, 4);
    }

    public final void zza(int i, List<?> list, zzanl zzanlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzanlVar);
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzaky.zzc(list.get(i3).intValue());
                }
                this.zza.zzc(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzaluVar.size(); i4++) {
                iZzc2 += zzaky.zzc(zzaluVar.zzb(i4));
            }
            this.zza.zzc(iZzc2);
            while (i2 < zzaluVar.size()) {
                this.zza.zzb(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zzb(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzamm)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzaky.zzc(list.get(i3).longValue());
                }
                this.zza.zzc(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzamm zzammVar = (zzamm) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzammVar.size(); i4++) {
                iZzc2 += zzaky.zzc(zzammVar.zzb(i4));
            }
            this.zza.zzc(iZzc2);
            while (i2 < zzammVar.size()) {
                this.zza.zzb(zzammVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzammVar.size()) {
            this.zza.zzb(i, zzammVar.zzb(i2));
            i2++;
        }
    }

    public final <K, V> void zza(int i, zzamq<K, V> zzamqVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzc(i, 2);
            this.zza.zzc(zzamn.zza(zzamqVar, entry.getKey(), entry.getValue()));
            zzamn.zza(this.zza, zzamqVar, entry.getKey(), entry.getValue());
        }
    }

    public final void zzb(int i, Object obj, zzanl zzanlVar) throws IOException {
        zzaju zzajuVar = (zzaju) obj;
        this.zza.zzc(i, 2);
        this.zza.zzc(zzajuVar.zza(zzanlVar));
        zzanlVar.zza(zzajuVar, this);
    }

    public final void zzb(int i, List<?> list, zzanl zzanlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzanlVar);
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        boolean z = obj instanceof zzakb;
        zzaky zzakyVar = this.zza;
        if (z) {
            zzakyVar.zzb(i, (zzakb) obj);
        } else {
            zzakyVar.zza(i, (zzamv) obj);
        }
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    i3 += 4;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzaluVar.size(); i6++) {
                zzaluVar.zzb(i6);
                i5 += 4;
            }
            this.zza.zzc(i5);
            while (i2 < zzaluVar.size()) {
                this.zza.zza(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zza(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzamm)) {
            if (z) {
                this.zza.zzc(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    i3 += 8;
                }
                this.zza.zzc(i3);
                while (i2 < list.size()) {
                    this.zza.zza(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzamm zzammVar = (zzamm) list;
        if (z) {
            this.zza.zzc(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzammVar.size(); i6++) {
                zzammVar.zzb(i6);
                i5 += 8;
            }
            this.zza.zzc(i5);
            while (i2 < zzammVar.size()) {
                this.zza.zza(zzammVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzammVar.size()) {
            this.zza.zza(i, zzammVar.zzb(i2));
            i2++;
        }
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzaky.zzd(zzaky.zze(list.get(i3).intValue()));
                }
                this.zza.zzc(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzaluVar.size(); i4++) {
                iZzd2 += zzaky.zzd(zzaky.zze(zzaluVar.zzb(i4)));
            }
            this.zza.zzc(iZzd2);
            while (i2 < zzaluVar.size()) {
                this.zza.zzf(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zzi(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzamm)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzaky.zzc(zzaky.zzd(list.get(i3).longValue()));
                }
                this.zza.zzc(iZzc);
                while (i2 < list.size()) {
                    this.zza.zze(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzamm zzammVar = (zzamm) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzammVar.size(); i4++) {
                iZzc2 += zzaky.zzc(zzaky.zzd(zzammVar.zzb(i4)));
            }
            this.zza.zzc(iZzc2);
            while (i2 < zzammVar.size()) {
                this.zza.zze(zzammVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzammVar.size()) {
            this.zza.zzf(i, zzammVar.zzb(i2));
            i2++;
        }
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzc(i, 3);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zza(i, str);
    }

    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzami) {
            zzami zzamiVar = (zzami) list;
            while (i2 < list.size()) {
                Object objZza = zzamiVar.zza(i2);
                boolean z = objZza instanceof String;
                zzaky zzakyVar = this.zza;
                if (z) {
                    zzakyVar.zza(i, (String) objZza);
                } else {
                    zzakyVar.zza(i, (zzakb) objZza);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzalu)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzaky.zzd(list.get(i3).intValue());
                }
                this.zza.zzc(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzc(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzalu zzaluVar = (zzalu) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzaluVar.size(); i4++) {
                iZzd2 += zzaky.zzd(zzaluVar.zzb(i4));
            }
            this.zza.zzc(iZzd2);
            while (i2 < zzaluVar.size()) {
                this.zza.zzc(zzaluVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaluVar.size()) {
            this.zza.zzd(i, zzaluVar.zzb(i2));
            i2++;
        }
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzamm)) {
            if (z) {
                this.zza.zzc(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzaky.zzc(list.get(i3).longValue());
                }
                this.zza.zzc(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzamm zzammVar = (zzamm) list;
        if (z) {
            this.zza.zzc(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzammVar.size(); i4++) {
                iZzc2 += zzaky.zzc(zzammVar.zzb(i4));
            }
            this.zza.zzc(iZzc2);
            while (i2 < zzammVar.size()) {
                this.zza.zzb(zzammVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzammVar.size()) {
            this.zza.zzb(i, zzammVar.zzb(i2));
            i2++;
        }
    }
}
