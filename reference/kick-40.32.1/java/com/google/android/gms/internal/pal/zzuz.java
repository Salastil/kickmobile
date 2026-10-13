package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzuz extends zzaun implements zzavx {
    private static final zzuz zzg;
    private zzauu zza = zzaG();
    private zzauu zzd = zzaG();
    private zzauu zze = zzaG();
    private zzauu zzf = zzaG();

    static {
        zzuz zzuzVar = new zzuz();
        zzg = zzuzVar;
        zzaun.zzaD(zzuz.class, zzuzVar);
    }

    private zzuz() {
    }

    public static zzuy zza() {
        return (zzuy) zzg.zzay();
    }

    final /* synthetic */ void zzb(Iterable iterable) {
        zzauu zzauuVar = this.zza;
        if (!zzauuVar.zza()) {
            this.zza = zzaun.zzaH(zzauuVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zza.zzh(((zzup) it.next()).zza());
        }
    }

    final /* synthetic */ void zzc(Iterable iterable) {
        zzauu zzauuVar = this.zzd;
        if (!zzauuVar.zza()) {
            this.zzd = zzaun.zzaH(zzauuVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzd.zzh(((zzup) it.next()).zza());
        }
    }

    final /* synthetic */ void zzd(Iterable iterable) {
        zzauu zzauuVar = this.zze;
        if (!zzauuVar.zza()) {
            this.zze = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zze);
    }

    final /* synthetic */ void zze(Iterable iterable) {
        zzauu zzauuVar = this.zzf;
        if (!zzauuVar.zza()) {
            this.zzf = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zzf);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001,\u0002,\u0003'\u0004'", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzuz();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzuy(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
