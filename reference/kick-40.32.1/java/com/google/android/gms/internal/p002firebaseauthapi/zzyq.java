package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyq extends zzalt<zzyq, zza> implements zzamx {
    private static final zzyq zzc;
    private static volatile zzani<zzyq> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzyq, zza> implements zzamx {
        public final zza zza(int i) {
            zzh();
            ((zzyq) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzyq.zzc);
        }
    }

    public static zzyq zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzys.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyq();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzani<zzyq> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzyq.class) {
                    zzcVar = zzd;
                    if (zzcVar == null) {
                        zzcVar = new zzalt.zzc(zzc);
                        zzd = zzcVar;
                    }
                    break;
                }
                return zzcVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    static {
        zzyq zzyqVar = new zzyq();
        zzc = zzyqVar;
        zzalt.zza((Class<zzyq>) zzyq.class, zzyqVar);
    }

    private zzyq() {
    }
}
