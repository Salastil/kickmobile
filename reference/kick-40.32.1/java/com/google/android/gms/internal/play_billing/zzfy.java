package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfy implements zzji {
    private final zzfx zza;

    private zzfy(zzfx zzfxVar) {
        this.zza = zzfxVar;
        zzfxVar.zza = this;
    }

    public static zzfy zza(zzfx zzfxVar) {
        Object obj = zzfxVar.zza;
        return obj != null ? (zzfy) obj : new zzfy(zzfxVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzA(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzC(int i, int i2) throws IOException {
        zzfx zzfxVar = this.zza;
        zzfxVar.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzE(int i, long j) throws IOException {
        zzfx zzfxVar = this.zza;
        zzfxVar.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    @Deprecated
    public final void zzG(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzH(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzJ(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzL(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzd(int i, zzfp zzfpVar) throws IOException {
        this.zza.zzf(i, zzfpVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzf(i, (zzfp) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzq(int i, Object obj, zzib zzibVar) throws IOException {
        zzfx zzfxVar = this.zza;
        zzfxVar.zzs(i, 3);
        zzibVar.zzi((zzfa) obj, this);
        zzfxVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzv(int i, zzhk zzhkVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            zzfxVar.zzu(zzhl.zzb(zzhkVar, entry.getKey(), entry.getValue()));
            zzhl.zze(zzfxVar, zzhkVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzw(int i, Object obj, zzib zzibVar) throws IOException {
        zzfx zzfxVar = this.zza;
        zzfa zzfaVar = (zzfa) obj;
        zzfxVar.zzs(i, 2);
        zzfxVar.zzu(zzfaVar.zzi(zzibVar));
        zzibVar.zzi(zzfaVar, this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzx(int i, Object obj) throws IOException {
        boolean z = obj instanceof zzfp;
        zzfx zzfxVar = this.zza;
        if (z) {
            zzfxVar.zzp(i, (zzfp) obj);
        } else {
            zzfxVar.zzo(i, (zzhr) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzy(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzI(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhd)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzhd zzhdVar = (zzhd) list;
        while (i2 < list.size()) {
            Object objZza = zzhdVar.zza();
            boolean z = objZza instanceof String;
            zzfx zzfxVar = this.zza;
            if (z) {
                zzfxVar.zzq(i, (String) objZza);
            } else {
                zzfxVar.zzf(i, (zzfp) objZza);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int iZzy = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzy += zzfx.zzy(((Integer) list.get(i3)).intValue());
            }
            zzfxVar.zzu(iZzy);
            while (i2 < list.size()) {
                zzfxVar.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                this.zza.zzt(i, zzgqVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int iZzy2 = 0;
        for (int i4 = 0; i4 < zzgqVar.size(); i4++) {
            iZzy2 += zzfx.zzy(zzgqVar.zze(i4));
        }
        zzfxVar2.zzu(iZzy2);
        while (i2 < zzgqVar.size()) {
            zzfxVar2.zzu(zzgqVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzM(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfx.zzz(((Long) list.get(i3)).longValue());
            }
            zzfxVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfxVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzv(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i4));
        }
        zzfxVar2.zzu(iZzz2);
        while (i2 < zzhjVar.size()) {
            zzfxVar2.zzw(zzhjVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                this.zza.zzh(i, zzgqVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgqVar.size(); i6++) {
            zzgqVar.zze(i6);
            i5 += 4;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzgqVar.size()) {
            zzfxVar2.zzi(zzgqVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzj(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhjVar.size(); i6++) {
            zzhjVar.zze(i6);
            i5 += 8;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzhjVar.size()) {
            zzfxVar2.zzk(zzhjVar.zze(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzff)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzff zzffVar = (zzff) list;
        if (!z) {
            while (i2 < zzffVar.size()) {
                this.zza.zzd(i, zzffVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzffVar.size(); i6++) {
            zzffVar.zzf(i6);
            i5++;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzffVar.size()) {
            zzfxVar2.zzb(zzffVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfx.zzz(((Integer) list.get(i3)).intValue());
            }
            zzfxVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfxVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                this.zza.zzl(i, zzgqVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzgqVar.size(); i4++) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i4));
        }
        zzfxVar2.zzu(iZzz2);
        while (i2 < zzgqVar.size()) {
            zzfxVar2.zzm(zzgqVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzj(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhjVar.size(); i6++) {
            zzhjVar.zze(i6);
            i5 += 8;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzhjVar.size()) {
            zzfxVar2.zzk(zzhjVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzfz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzfz zzfzVar = (zzfz) list;
        if (!z) {
            while (i2 < zzfzVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzfzVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzfzVar.size(); i6++) {
            zzfzVar.zze(i6);
            i5 += 8;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzfzVar.size()) {
            zzfxVar2.zzk(Double.doubleToRawLongBits(zzfzVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgj zzgjVar = (zzgj) list;
        if (!z) {
            while (i2 < zzgjVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgjVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgjVar.size(); i6++) {
            zzgjVar.zze(i6);
            i5 += 4;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzgjVar.size()) {
            zzfxVar2.zzi(Float.floatToRawIntBits(zzgjVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzfxVar.zzu(i3);
            while (i2 < list.size()) {
                zzfxVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                this.zza.zzh(i, zzgqVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgqVar.size(); i6++) {
            zzgqVar.zze(i6);
            i5 += 4;
        }
        zzfxVar2.zzu(i5);
        while (i2 < zzgqVar.size()) {
            zzfxVar2.zzi(zzgqVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzfx zzfxVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzfxVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzfx zzfxVar2 = this.zza;
            zzfxVar2.zzs(i, 2);
            int iZzy = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzy += zzfx.zzy((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzfxVar2.zzu(iZzy);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzfxVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                zzfx zzfxVar3 = this.zza;
                int iZze = zzgqVar.zze(i2);
                zzfxVar3.zzt(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        zzfx zzfxVar4 = this.zza;
        zzfxVar4.zzs(i, 2);
        int iZzy2 = 0;
        for (int i4 = 0; i4 < zzgqVar.size(); i4++) {
            int iZze2 = zzgqVar.zze(i4);
            iZzy2 += zzfx.zzy((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzfxVar4.zzu(iZzy2);
        while (i2 < zzgqVar.size()) {
            int iZze3 = zzgqVar.zze(i2);
            zzfxVar4.zzu((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzF(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzfx zzfxVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzfxVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzfx zzfxVar2 = this.zza;
            zzfxVar2.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzz += zzfx.zzz((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzfxVar2.zzu(iZzz);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzfxVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                zzfx zzfxVar3 = this.zza;
                long jZze = zzhjVar.zze(i2);
                zzfxVar3.zzv(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        zzfx zzfxVar4 = this.zza;
        zzfxVar4.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            long jZze2 = zzhjVar.zze(i4);
            iZzz2 += zzfx.zzz((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzfxVar4.zzu(iZzz2);
        while (i2 < zzhjVar.size()) {
            long jZze3 = zzhjVar.zze(i2);
            zzfxVar4.zzw((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfx.zzz(((Integer) list.get(i3)).intValue());
            }
            zzfxVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfxVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z) {
            while (i2 < zzgqVar.size()) {
                this.zza.zzl(i, zzgqVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzgqVar.size(); i4++) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i4));
        }
        zzfxVar2.zzu(iZzz2);
        while (i2 < zzgqVar.size()) {
            zzfxVar2.zzm(zzgqVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfx.zzz(((Long) list.get(i3)).longValue());
            }
            zzfxVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfxVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzv(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i4));
        }
        zzfxVar2.zzu(iZzz2);
        while (i2 < zzhjVar.size()) {
            zzfxVar2.zzw(zzhjVar.zze(i2));
            i2++;
        }
    }
}
