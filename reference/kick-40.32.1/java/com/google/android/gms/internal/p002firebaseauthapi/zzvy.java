package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvy extends zzalt<zzvy, zza> implements zzamx {
    private static final zzvy zzc;
    private static volatile zzani<zzvy> zzd;
    private int zze;
    private int zzf;
    private zzakb zzg = zzakb.zza;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvy zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzvy, zza> implements zzamx {
        public final zza zza(zzwb zzwbVar) {
            zzh();
            zzvy.zza((zzvy) this.zza, zzwbVar);
            return this;
        }

        public final zza zza(zzwh zzwhVar) {
            zzh();
            zzvy.zza((zzvy) this.zza, zzwhVar);
            return this;
        }

        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzvy.zza((zzvy) this.zza, zzakbVar);
            return this;
        }

        private zza() {
            super(zzvy.zzc);
        }
    }

    public final zzwb zzd() {
        zzwb zzwbVarZza = zzwb.zza(this.zze);
        return zzwbVarZza == null ? zzwb.UNRECOGNIZED : zzwbVarZza;
    }

    public final zzwh zze() {
        zzwh zzwhVarZza = zzwh.zza(this.zzf);
        return zzwhVarZza == null ? zzwh.UNRECOGNIZED : zzwhVarZza;
    }

    public final zzakb zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwa.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvy();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzvy> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzvy.class) {
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

    static /* synthetic */ void zza(zzvy zzvyVar, zzwb zzwbVar) {
        zzvyVar.zze = zzwbVar.zza();
    }

    static /* synthetic */ void zza(zzvy zzvyVar, zzwh zzwhVar) {
        zzvyVar.zzf = zzwhVar.zza();
    }

    static /* synthetic */ void zza(zzvy zzvyVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzvyVar.zzg = zzakbVar;
    }

    static {
        zzvy zzvyVar = new zzvy();
        zzc = zzvyVar;
        zzalt.zza((Class<zzvy>) zzvy.class, zzvyVar);
    }

    private zzvy() {
    }
}
