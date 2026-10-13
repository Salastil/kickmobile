package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwm extends zzalt<zzwm, zza> implements zzamx {
    private static final zzwm zzc;
    private static volatile zzani<zzwm> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zzf;
    }

    public final zzwh zzb() {
        zzwh zzwhVarZza = zzwh.zza(this.zze);
        return zzwhVarZza == null ? zzwh.UNRECOGNIZED : zzwhVarZza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwm, zza> implements zzamx {
        public final zza zza(zzwh zzwhVar) {
            zzh();
            zzwm.zza((zzwm) this.zza, zzwhVar);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzwm) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzwm.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwm zze() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwo.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwm();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwm> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwm.class) {
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

    static /* synthetic */ void zza(zzwm zzwmVar, zzwh zzwhVar) {
        zzwmVar.zze = zzwhVar.zza();
    }

    static {
        zzwm zzwmVar = new zzwm();
        zzc = zzwmVar;
        zzalt.zza((Class<zzwm>) zzwm.class, zzwmVar);
    }

    private zzwm() {
    }
}
