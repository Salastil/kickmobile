package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatu implements zzaxp {
    private final zzatt zza;

    private zzatu(zzatt zzattVar) {
        byte[] bArr = zzauz.zzb;
        this.zza = zzattVar;
        zzattVar.zza = this;
    }

    public static zzatu zza(zzatt zzattVar) {
        Object obj = zzattVar.zza;
        return obj != null ? (zzatu) obj : new zzatu(zzattVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzG(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzi(i, (zzatl) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzc(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zze(int i, float f) throws IOException {
        this.zza.zzd(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzf(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzh(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzj(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzg(i, z);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzm(int i, String str) throws IOException {
        this.zza.zzh(i, str);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzn(int i, zzatl zzatlVar) throws IOException {
        this.zza.zzi(i, zzatlVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzp(int i, int i2) throws IOException {
        zzatt zzattVar = this.zza;
        zzattVar.zzc(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzq(int i, long j) throws IOException {
        zzatt zzattVar = this.zza;
        zzattVar.zze(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzr(int i, Object obj, zzawn zzawnVar) throws IOException {
        zzatt zzattVar = this.zza;
        zzasx zzasxVar = (zzasx) obj;
        zzattVar.zza(i, 2);
        zzattVar.zzn(zzasxVar.zzar(zzawnVar));
        zzawnVar.zzf(zzasxVar, this);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzs(int i, Object obj, zzawn zzawnVar) throws IOException {
        zzatt zzattVar = this.zza;
        zzattVar.zza(i, 3);
        zzawnVar.zzf((zzasx) obj, this);
        zzattVar.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    @Deprecated
    public final void zzt(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    @Deprecated
    public final void zzu(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzv(int i, Object obj) throws IOException {
        boolean z = obj instanceof zzatl;
        zzatt zzattVar = this.zza;
        if (z) {
            zzattVar.zzk(i, (zzatl) obj);
        } else {
            zzattVar.zzj(i, (zzavw) obj);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzF(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavi)) {
            while (i2 < list.size()) {
                this.zza.zzh(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzavi zzaviVar = (zzavi) list;
        while (i2 < list.size()) {
            Object objZzc = zzaviVar.zzc();
            boolean z = objZzc instanceof String;
            zzatt zzattVar = this.zza;
            if (z) {
                zzattVar.zzh(i, (String) objZzc);
            } else {
                zzattVar.zzi(i, (zzatl) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavl)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzq(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzavl zzavlVar = (zzavl) list;
        if (!z) {
            while (i2 < zzavlVar.size()) {
                this.zza.zzf(i, zzavlVar.zze(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzavlVar.size(); i6++) {
            zzavlVar.zze(i6);
            i5 += 8;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzavlVar.size()) {
            zzattVar2.zzq(zzavlVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzH(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int iZzu = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzu += zzatt.zzu(((Integer) list.get(i3)).intValue());
            }
            zzattVar.zzn(iZzu);
            while (i2 < list.size()) {
                zzattVar.zzn(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                this.zza.zzc(i, zzauoVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int iZzu2 = 0;
        for (int i4 = 0; i4 < zzauoVar.size(); i4++) {
            iZzu2 += zzatt.zzu(zzauoVar.zzf(i4));
        }
        zzattVar2.zzn(iZzu2);
        while (i2 < zzauoVar.size()) {
            zzattVar2.zzn(zzauoVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                this.zza.zzd(i, zzauoVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzauoVar.size(); i6++) {
            zzauoVar.zzf(i6);
            i5 += 4;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzauoVar.size()) {
            zzattVar2.zzo(zzauoVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavl)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzv += zzatt.zzv(((Long) list.get(i3)).longValue());
            }
            zzattVar.zzn(iZzv);
            while (i2 < list.size()) {
                zzattVar.zzp(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzavl zzavlVar = (zzavl) list;
        if (!z) {
            while (i2 < zzavlVar.size()) {
                this.zza.zze(i, zzavlVar.zze(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int iZzv2 = 0;
        for (int i4 = 0; i4 < zzavlVar.size(); i4++) {
            iZzv2 += zzatt.zzv(zzavlVar.zze(i4));
        }
        zzattVar2.zzn(iZzv2);
        while (i2 < zzavlVar.size()) {
            zzattVar2.zzp(zzavlVar.zze(i2));
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
    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzatd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzl(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzatd zzatdVar = (zzatd) list;
        if (!z) {
            while (i2 < zzatdVar.size()) {
                this.zza.zzg(i, zzatdVar.zze(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzatdVar.size(); i6++) {
            zzatdVar.zze(i6);
            i5++;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzatdVar.size()) {
            zzattVar2.zzl(zzatdVar.zze(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzw(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzv += zzatt.zzv(((Integer) list.get(i3)).intValue());
            }
            zzattVar.zzn(iZzv);
            while (i2 < list.size()) {
                zzattVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                this.zza.zzb(i, zzauoVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int iZzv2 = 0;
        for (int i4 = 0; i4 < zzauoVar.size(); i4++) {
            iZzv2 += zzatt.zzv(zzauoVar.zzf(i4));
        }
        zzattVar2.zzn(iZzv2);
        while (i2 < zzauoVar.size()) {
            zzattVar2.zzm(zzauoVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzo(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzauf zzaufVar = (zzauf) list;
        if (!z) {
            while (i2 < zzaufVar.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(zzaufVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaufVar.size(); i6++) {
            zzaufVar.zze(i6);
            i5 += 4;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzaufVar.size()) {
            zzattVar2.zzo(Float.floatToRawIntBits(zzaufVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzatv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzq(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzatv zzatvVar = (zzatv) list;
        if (!z) {
            while (i2 < zzatvVar.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(zzatvVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzatvVar.size(); i6++) {
            zzatvVar.zze(i6);
            i5 += 8;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzatvVar.size()) {
            zzattVar2.zzq(Double.doubleToRawLongBits(zzatvVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                this.zza.zzd(i, zzauoVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzauoVar.size(); i6++) {
            zzauoVar.zzf(i6);
            i5 += 4;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzauoVar.size()) {
            zzattVar2.zzo(zzauoVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavl)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzattVar.zzn(i3);
            while (i2 < list.size()) {
                zzattVar.zzq(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzavl zzavlVar = (zzavl) list;
        if (!z) {
            while (i2 < zzavlVar.size()) {
                this.zza.zzf(i, zzavlVar.zze(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzavlVar.size(); i6++) {
            zzavlVar.zze(i6);
            i5 += 8;
        }
        zzattVar2.zzn(i5);
        while (i2 < zzavlVar.size()) {
            zzattVar2.zzq(zzavlVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzv += zzatt.zzv(((Integer) list.get(i3)).intValue());
            }
            zzattVar.zzn(iZzv);
            while (i2 < list.size()) {
                zzattVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                this.zza.zzb(i, zzauoVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int iZzv2 = 0;
        for (int i4 = 0; i4 < zzauoVar.size(); i4++) {
            iZzv2 += zzatt.zzv(zzauoVar.zzf(i4));
        }
        zzattVar2.zzn(iZzv2);
        while (i2 < zzauoVar.size()) {
            zzattVar2.zzm(zzauoVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzauo)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzatt zzattVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzattVar.zzc(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzatt zzattVar2 = this.zza;
            zzattVar2.zza(i, 2);
            int iZzu = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzu += zzatt.zzu((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzattVar2.zzn(iZzu);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzattVar2.zzn((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzauo zzauoVar = (zzauo) list;
        if (!z) {
            while (i2 < zzauoVar.size()) {
                zzatt zzattVar3 = this.zza;
                int iZzf = zzauoVar.zzf(i2);
                zzattVar3.zzc(i, (iZzf >> 31) ^ (iZzf + iZzf));
                i2++;
            }
            return;
        }
        zzatt zzattVar4 = this.zza;
        zzattVar4.zza(i, 2);
        int iZzu2 = 0;
        for (int i4 = 0; i4 < zzauoVar.size(); i4++) {
            int iZzf2 = zzauoVar.zzf(i4);
            iZzu2 += zzatt.zzu((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzattVar4.zzn(iZzu2);
        while (i2 < zzauoVar.size()) {
            int iZzf3 = zzauoVar.zzf(i2);
            zzattVar4.zzn((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavl)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzatt zzattVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzattVar.zze(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzatt zzattVar2 = this.zza;
            zzattVar2.zza(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzv += zzatt.zzv((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzattVar2.zzn(iZzv);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzattVar2.zzp((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzavl zzavlVar = (zzavl) list;
        if (!z) {
            while (i2 < zzavlVar.size()) {
                zzatt zzattVar3 = this.zza;
                long jZze = zzavlVar.zze(i2);
                zzattVar3.zze(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        zzatt zzattVar4 = this.zza;
        zzattVar4.zza(i, 2);
        int iZzv2 = 0;
        for (int i4 = 0; i4 < zzavlVar.size(); i4++) {
            long jZze2 = zzavlVar.zze(i4);
            iZzv2 += zzatt.zzv((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzattVar4.zzn(iZzv2);
        while (i2 < zzavlVar.size()) {
            long jZze3 = zzavlVar.zze(i2);
            zzattVar4.zzp((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaxp
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzavl)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzatt zzattVar = this.zza;
            zzattVar.zza(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzv += zzatt.zzv(((Long) list.get(i3)).longValue());
            }
            zzattVar.zzn(iZzv);
            while (i2 < list.size()) {
                zzattVar.zzp(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzavl zzavlVar = (zzavl) list;
        if (!z) {
            while (i2 < zzavlVar.size()) {
                this.zza.zze(i, zzavlVar.zze(i2));
                i2++;
            }
            return;
        }
        zzatt zzattVar2 = this.zza;
        zzattVar2.zza(i, 2);
        int iZzv2 = 0;
        for (int i4 = 0; i4 < zzavlVar.size(); i4++) {
            iZzv2 += zzatt.zzv(zzavlVar.zze(i4));
        }
        zzattVar2.zzn(iZzv2);
        while (i2 < zzavlVar.size()) {
            zzattVar2.zzp(zzavlVar.zze(i2));
            i2++;
        }
    }
}
