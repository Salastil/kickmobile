package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxa extends zzalt<zzxa, zza> implements zzamx {
    private static final zzxa zzc;
    private static volatile zzani<zzxa> zzd;
    private int zze;
    private int zzf;
    private zzxd zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzxa, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzxa.zza((zzxa) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzxd zzxdVar) {
            zzh();
            zzxa.zza((zzxa) this.zza, zzxdVar);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzxa) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzxa.zzc);
        }
    }

    public static zzxa zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzxa) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzxd zzd() {
        zzxd zzxdVar = this.zzg;
        return zzxdVar == null ? zzxd.zze() : zzxdVar;
    }

    public final zzakb zze() {
        return this.zzh;
    }

    public static zzani<zzxa> zzf() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwz.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxa();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxa> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxa.class) {
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

    static /* synthetic */ void zza(zzxa zzxaVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzxaVar.zzh = zzakbVar;
    }

    static /* synthetic */ void zza(zzxa zzxaVar, zzxd zzxdVar) {
        Objects.requireNonNull(zzxdVar);
        zzxaVar.zzg = zzxdVar;
        zzxaVar.zze |= 1;
    }

    static {
        zzxa zzxaVar = new zzxa();
        zzc = zzxaVar;
        zzalt.zza((Class<zzxa>) zzxa.class, zzxaVar);
    }

    private zzxa() {
    }
}
