package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyk extends zzalt<zzyk, zza> implements zzamx {
    private static final zzyk zzc;
    private static volatile zzani<zzyk> zzd;
    private int zze;
    private int zzf;
    private zzyq zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzyk, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzyk.zza((zzyk) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzyq zzyqVar) {
            zzh();
            zzyk.zza((zzyk) this.zza, zzyqVar);
            return this;
        }

        private zza() {
            super(zzyk.zzc);
        }
    }

    public static zzyk zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzyk) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzyq zzd() {
        zzyq zzyqVar = this.zzg;
        return zzyqVar == null ? zzyq.zzd() : zzyqVar;
    }

    public final zzakb zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzym.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyk();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzyk> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzyk.class) {
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

    static /* synthetic */ void zza(zzyk zzykVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzykVar.zzh = zzakbVar;
    }

    static /* synthetic */ void zza(zzyk zzykVar, zzyq zzyqVar) {
        Objects.requireNonNull(zzyqVar);
        zzykVar.zzg = zzyqVar;
        zzykVar.zze |= 1;
    }

    static {
        zzyk zzykVar = new zzyk();
        zzc = zzykVar;
        zzalt.zza((Class<zzyk>) zzyk.class, zzykVar);
    }

    private zzyk() {
    }
}
