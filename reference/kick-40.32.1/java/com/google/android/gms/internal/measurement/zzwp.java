package com.google.android.gms.internal.measurement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwp {
    private final int[] zza;
    private final zzwn zzb;
    private zzwn zzc;
    private int zzd;
    private int zze;
    private int zzf;

    private zzwp(int[] iArr) {
        this.zza = iArr;
        zzwn zzwnVar = new zzwn(-1, -1, null);
        this.zzb = zzwnVar;
        this.zzc = zzwnVar;
    }

    static zzwp zza(int[] iArr) {
        zzwn zzwnVar;
        zzwp zzwpVar = new zzwp(iArr);
        for (int i = 0; i < iArr.length; i++) {
            zzwpVar.zzf++;
            int[] iArr2 = zzwpVar.zza;
            int i2 = iArr2[i];
            while (true) {
                zzwn zzwnVar2 = null;
                while (true) {
                    if (zzwpVar.zzf <= 0) {
                        break;
                    }
                    int i3 = zzwpVar.zze;
                    zzwnVar = zzwpVar.zzc;
                    if (i3 == 0) {
                        break;
                    }
                    int i4 = ((zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr2[zzwpVar.zzd]))).zza;
                    int i5 = zzwpVar.zze;
                    if (iArr2[i4 + i5] == i2) {
                        if (zzwnVar2 != null) {
                            zzwnVar2.zzc = zzwpVar.zzc;
                        }
                        zzwpVar.zze = i5 + 1;
                        zzwpVar.zzb();
                        break;
                    }
                    zzwn zzwnVar3 = (zzwn) zzwpVar.zzc.zzd.get(Integer.valueOf(iArr2[zzwpVar.zzd]));
                    int i6 = zzwnVar3.zza;
                    zzwn zzwnVar4 = new zzwn(i6, (zzwpVar.zze + i6) - 1, null);
                    zzwpVar.zzc.zzd.put(Integer.valueOf(iArr2[zzwpVar.zzd]), zzwnVar4);
                    Map map = zzwnVar4.zzd;
                    int i7 = zzwnVar4.zzb + 1;
                    map.put(Integer.valueOf(iArr2[i7]), zzwnVar3);
                    zzwnVar3.zza = i7;
                    if (zzwnVar2 != null) {
                        zzwnVar2.zzc = zzwnVar4;
                    }
                    map.put(Integer.valueOf(i2), new zzwn(i, 1073741824, null));
                    zzwpVar.zzf--;
                    zzwpVar.zzc();
                    zzwnVar2 = zzwnVar4;
                }
                Map map2 = zzwnVar.zzd;
                Integer numValueOf = Integer.valueOf(i2);
                if (map2.containsKey(numValueOf)) {
                    if (zzwnVar2 != null) {
                        zzwnVar2.zzc = zzwpVar.zzc;
                    }
                    zzwpVar.zzd = i;
                    zzwpVar.zze++;
                    zzwpVar.zzb();
                    break;
                }
                zzwpVar.zzc.zzd.put(numValueOf, new zzwn(i, 1073741824, null));
                if (zzwnVar2 != null) {
                    zzwnVar2.zzc = zzwpVar.zzc;
                }
                zzwpVar.zzf--;
                zzwpVar.zzc();
            }
        }
        return zzwpVar;
    }

    private final void zze(zzwn zzwnVar, StringBuilder sb) {
        for (zzwn zzwnVar2 : zzwnVar.zzd.values()) {
            sb.append("  ");
            sb.append(zzwnVar);
            sb.append(" -> ");
            sb.append(zzwnVar2);
            sb.append(" [label=\"");
            int[] iArr = this.zza;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzwnVar2.zza, Math.min(iArr.length, zzwnVar2.zzb + 1))));
            sb.append("\"]\n");
            zze(zzwnVar2, sb);
        }
    }

    private final boolean zzf(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int[] iArr = this.zza;
            int length = iArr.length;
            int iMin = Math.min(length, i2);
            if (iMin - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= iMin; i5++) {
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        zze(this.zzb, sb);
        sb.append("}");
        return sb.toString();
    }

    final void zzb() {
        if (this.zze == 0) {
            return;
        }
        Map map = this.zzc.zzd;
        int[] iArr = this.zza;
        zzwn zzwnVar = (zzwn) map.get(Integer.valueOf(iArr[this.zzd]));
        while (true) {
            int i = (zzwnVar.zzb - zzwnVar.zza) + 1;
            int i2 = this.zze;
            if (i > i2) {
                return;
            }
            int i3 = this.zzd + i;
            this.zzd = i3;
            this.zzc = zzwnVar;
            int i4 = i2 - i;
            this.zze = i4;
            if (i4 > 0) {
                zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[i3]));
            }
        }
    }

    final void zzc() {
        zzwn zzwnVar = this.zzc.zzc;
        if (zzwnVar != null) {
            this.zzc = zzwnVar;
        } else {
            this.zzc = this.zzb;
            int i = this.zze;
            if (i > 0) {
                this.zze = i - 1;
            }
            if (this.zzf > 0) {
                this.zzd++;
            }
        }
        zzb();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    public final zzwo zzd() {
        int i;
        int i2;
        zzwm zzwmVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        zzwn zzwnVar = this.zzb;
        zzwm zzwmVar2 = new zzwm(zzwnVar, 0, -1, -1, null);
        arrayDeque.push(zzwmVar2);
        while (!arrayDeque.isEmpty()) {
            zzwm zzwmVar3 = (zzwm) arrayDeque.pop();
            for (zzwn zzwnVar2 : zzwmVar3.zzd.zzd.values()) {
                int i3 = zzwmVar3.zzb;
                int i4 = zzwmVar3.zzc;
                int i5 = zzwnVar2.zza;
                int i6 = zzwnVar2.zzb;
                if (zzf(i3, i4, i5, i6)) {
                    zzwmVar = new zzwm(zzwnVar2, zzwmVar3.zza + 1, i3, i4, null);
                } else {
                    if (zzwnVar2.zzd.isEmpty()) {
                        int i7 = zzwnVar2.zza;
                        if (zzf(i3, i4, i7, (i7 + i4) - i3)) {
                            zzwmVar = new zzwm(zzwnVar2, zzwmVar3.zza + 1, i3, i4, null);
                        }
                    }
                    zzwmVar = new zzwm(zzwnVar2, 1, zzwnVar2.zza, i6, null);
                }
                if (zzwmVar2.zza < zzwmVar.zza) {
                    zzwmVar2 = zzwmVar;
                }
                arrayDeque.push(zzwmVar);
            }
        }
        int[] iArr = this.zza;
        int iMin = Math.min(iArr.length, zzwmVar2.zzc + 1);
        int i8 = 0;
        loop2: while (true) {
            i = zzwmVar2.zzb;
            i2 = iMin - i;
            zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[(i8 % i2) + i]));
            if (zzwnVar == null) {
                break;
            }
            for (int i9 = zzwnVar.zza; i9 < zzwnVar.zzb + 1 && i9 < iArr.length; i9++) {
                if (iArr[(i8 % i2) + i] != iArr[i9]) {
                    break loop2;
                }
                i8++;
            }
        }
        return new zzwo(i, iMin, i8 / i2);
    }
}
