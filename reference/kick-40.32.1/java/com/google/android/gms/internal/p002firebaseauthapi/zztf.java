package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztf extends zzalt<zztf, zza> implements zzamx {
    private static final zztf zzc;
    private static volatile zzani<zztf> zzd;
    private int zze;
    private int zzf;
    private zzakb zzg = zzakb.zza;
    private zztl zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zztf, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zztf.zza((zztf) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zztl zztlVar) {
            zzh();
            zztf.zza((zztf) this.zza, zztlVar);
            return this;
        }

        private zza() {
            super(zztf.zzc);
        }
    }

    public static zztf zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zztf) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zztl zzd() {
        zztl zztlVar = this.zzh;
        return zztlVar == null ? zztl.zzd() : zztlVar;
    }

    public final zzakb zze() {
        return this.zzg;
    }

    public static zzani<zztf> zzf() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzte.zza[i - 1];
        switch (i2) {
            case 1:
                return new zztf();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zztf> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zztf.class) {
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

    static /* synthetic */ void zza(zztf zztfVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zztfVar.zzg = zzakbVar;
    }

    static /* synthetic */ void zza(zztf zztfVar, zztl zztlVar) {
        Objects.requireNonNull(zztlVar);
        zztfVar.zzh = zztlVar;
        zztfVar.zze |= 1;
    }

    static {
        zztf zztfVar = new zztf();
        zzc = zztfVar;
        zzalt.zza((Class<zztf>) zztf.class, zztfVar);
    }

    private zztf() {
    }
}
