package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwx extends zzalt<zzwx, zza> implements zzamx {
    private static final zzwx zzc;
    private static volatile zzani<zzwx> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final zzwp zza() {
        zzwp zzwpVarZza = zzwp.zza(this.zzg);
        return zzwpVarZza == null ? zzwp.UNRECOGNIZED : zzwpVarZza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwx, zza> implements zzamx {
        public final zza zza(zzwp zzwpVar) {
            zzh();
            zzwx.zza((zzwx) this.zza, zzwpVar);
            return this;
        }

        public final zza zza(zzws zzwsVar) {
            zzh();
            zzwx.zza((zzwx) this.zza, zzwsVar);
            return this;
        }

        public final zza zza(zzwr zzwrVar) {
            zzh();
            zzwx.zza((zzwx) this.zza, zzwrVar);
            return this;
        }

        private zza() {
            super(zzwx.zzc);
        }
    }

    public final zzws zzb() {
        zzws zzwsVarZza = zzws.zza(this.zzf);
        return zzwsVarZza == null ? zzws.UNRECOGNIZED : zzwsVarZza;
    }

    public final zzwr zzc() {
        zzwr zzwrVarZza = zzwr.zza(this.zze);
        return zzwrVarZza == null ? zzwr.UNRECOGNIZED : zzwrVarZza;
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwx zzf() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzww.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwx();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwx> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwx.class) {
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

    static /* synthetic */ void zza(zzwx zzwxVar, zzwp zzwpVar) {
        zzwxVar.zzg = zzwpVar.zza();
    }

    static /* synthetic */ void zza(zzwx zzwxVar, zzws zzwsVar) {
        zzwxVar.zzf = zzwsVar.zza();
    }

    static /* synthetic */ void zza(zzwx zzwxVar, zzwr zzwrVar) {
        zzwxVar.zze = zzwrVar.zza();
    }

    static {
        zzwx zzwxVar = new zzwx();
        zzc = zzwxVar;
        zzalt.zza((Class<zzwx>) zzwx.class, zzwxVar);
    }

    private zzwx() {
    }
}
