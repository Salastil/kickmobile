package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgn extends zzadu implements zzafd {
    private static final zzgn zze;
    private static volatile zzafj zzf;
    private zzaef zzb = zzcy();

    static {
        zzgn zzgnVar = new zzgn();
        zze = zzgnVar;
        zzadu.zzcs(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zze, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzgn();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzgm(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzf;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzgn.class) {
            zzadqVar = zzf;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zze);
                zzf = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
