package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxd extends zzalt<zzxd, zza> implements zzamx {
    private static final zzxd zzc;
    private static volatile zzani<zzxd> zzd;
    private int zze;
    private int zzf;
    private zzwx zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzwx zzb() {
        zzwx zzwxVar = this.zzg;
        return zzwxVar == null ? zzwx.zzf() : zzwxVar;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzxd, zza> implements zzamx {
        public final zza zza(zzwx zzwxVar) {
            zzh();
            zzxd.zza((zzxd) this.zza, zzwxVar);
            return this;
        }

        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzxd.zza((zzxd) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzxd) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzxd.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzxd zze() {
        return zzc;
    }

    public static zzxd zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzxd) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzakb zzf() {
        return this.zzh;
    }

    public static zzani<zzxd> d_() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxc.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxd();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxd> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxd.class) {
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

    static /* synthetic */ void zza(zzxd zzxdVar, zzwx zzwxVar) {
        Objects.requireNonNull(zzwxVar);
        zzxdVar.zzg = zzwxVar;
        zzxdVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzxd zzxdVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzxdVar.zzh = zzakbVar;
    }

    static {
        zzxd zzxdVar = new zzxd();
        zzc = zzxdVar;
        zzalt.zza((Class<zzxd>) zzxd.class, zzxdVar);
    }

    private zzxd() {
    }
}
