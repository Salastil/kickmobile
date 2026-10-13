package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvm extends zzaun implements zzavx {
    private static final zzauv zzq = new zzvj();
    private static final zzauv zzs = new zzvk();
    private static final zzvm zzy;
    private int zza;
    private int zzd;
    private zzawy zze;
    private zzawy zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzt;
    private String zzj = "";
    private zzauu zzo = zzaG();
    private zzauu zzp = zzaG();
    private zzauu zzr = zzaG();
    private String zzu = "";
    private zzauu zzv = zzaG();
    private zzauu zzw = zzaG();
    private zzauy zzx = zzaJ();

    static {
        zzvm zzvmVar = new zzvm();
        zzy = zzvmVar;
        zzaun.zzaD(zzvm.class, zzvmVar);
    }

    private zzvm() {
    }

    public static zzvl zzj() {
        return (zzvl) zzy.zzay();
    }

    public static zzvm zzk() {
        return zzy;
    }

    final /* synthetic */ void zzA(boolean z) {
        this.zzt = z;
    }

    final /* synthetic */ void zzB(String str) {
        this.zzu = str;
    }

    final /* synthetic */ void zzC(Iterable iterable) {
        zzauu zzauuVar = this.zzv;
        if (!zzauuVar.zza()) {
            this.zzv = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zzv);
    }

    final /* synthetic */ void zzD(Iterable iterable) {
        zzauu zzauuVar = this.zzw;
        if (!zzauuVar.zza()) {
            this.zzw = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zzw);
    }

    final /* synthetic */ void zzE(Iterable iterable) {
        zzauy zzauyVar = this.zzx;
        if (!zzauyVar.zza()) {
            this.zzx = zzaun.zzaK(zzauyVar);
        }
        zzasx.zzas(iterable, this.zzx);
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    public final List zzc() {
        return new zzauw(this.zzp, zzq);
    }

    public final List zzd() {
        return new zzauw(this.zzr, zzs);
    }

    public final boolean zze() {
        return this.zzt;
    }

    public final String zzf() {
        return this.zzu;
    }

    public final List zzg() {
        return this.zzv;
    }

    public final List zzh() {
        return this.zzw;
    }

    public final List zzi() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzy, "\u0004\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0006\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004\u0004\u0005\u0004\u0006\u0004\u0007Ȉ\b\u0004\t\u0004\n\u0007\u000b\u0007\f,\r,\u000e,\u000f\u0007\u0010Ȉ\u0011'\u0012'\u0013\u001b", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzr", "zzt", "zzu", "zzv", "zzw", "zzx", zzux.class});
        }
        if (i2 == 3) {
            return new zzvm();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzvl(bArr);
        }
        if (i2 == 5) {
            return zzy;
        }
        throw null;
    }

    final /* synthetic */ void zzm(int i) {
        this.zzd = i;
    }

    final /* synthetic */ void zzn(zzawy zzawyVar) {
        zzawyVar.getClass();
        this.zze = zzawyVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzo(zzawy zzawyVar) {
        zzawyVar.getClass();
        this.zzf = zzawyVar;
        this.zza |= 2;
    }

    final /* synthetic */ void zzp(int i) {
        this.zzg = i;
    }

    final /* synthetic */ void zzq(int i) {
        this.zzh = i;
    }

    final /* synthetic */ void zzr(int i) {
        this.zzi = i;
    }

    final /* synthetic */ void zzs(String str) {
        this.zzj = str;
    }

    final /* synthetic */ void zzt(int i) {
        this.zzk = i;
    }

    final /* synthetic */ void zzu(int i) {
        this.zzl = i;
    }

    final /* synthetic */ void zzv(boolean z) {
        this.zzm = z;
    }

    final /* synthetic */ void zzw(boolean z) {
        this.zzn = z;
    }

    final /* synthetic */ void zzx(Iterable iterable) {
        zzauu zzauuVar = this.zzo;
        if (!zzauuVar.zza()) {
            this.zzo = zzaun.zzaH(zzauuVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzo.zzh(((zzuq) it.next()).zza());
        }
    }

    final /* synthetic */ void zzy(Iterable iterable) {
        zzauu zzauuVar = this.zzp;
        if (!zzauuVar.zza()) {
            this.zzp = zzaun.zzaH(zzauuVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzp.zzh(((zzup) it.next()).zza());
        }
    }

    final /* synthetic */ void zzz(Iterable iterable) {
        zzauu zzauuVar = this.zzr;
        if (!zzauuVar.zza()) {
            this.zzr = zzaun.zzaH(zzauuVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzr.zzh(((zzup) it.next()).zza());
        }
    }
}
