package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztx extends zzalt<zztx, zza> implements zzamx {
    private static final zztx zzc;
    private static volatile zzani<zztx> zzd;
    private int zze;
    private zzua zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zztx, zza> implements zzamx {
        public final zza zza(int i) {
            zzh();
            ((zztx) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzua zzuaVar) {
            zzh();
            zztx.zza((zztx) this.zza, zzuaVar);
            return this;
        }

        private zza() {
            super(zztx.zzc);
        }
    }

    public static zztx zzd() {
        return zzc;
    }

    public final zzua zze() {
        zzua zzuaVar = this.zzf;
        return zzuaVar == null ? zzua.zzd() : zzuaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zztw.zza[i - 1];
        switch (i2) {
            case 1:
                return new zztx();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zztx> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zztx.class) {
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

    static /* synthetic */ void zza(zztx zztxVar, zzua zzuaVar) {
        Objects.requireNonNull(zzuaVar);
        zztxVar.zzf = zzuaVar;
        zztxVar.zze |= 1;
    }

    static {
        zztx zztxVar = new zztx();
        zzc = zztxVar;
        zzalt.zza((Class<zztx>) zztx.class, zztxVar);
    }

    private zztx() {
    }
}
