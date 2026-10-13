package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzuy extends zzalt<zzuy, zza> implements zzamx {
    private static final zzuy zzc;
    private static volatile zzani<zzuy> zzd;
    private int zze;
    private zzakb zzf = zzakb.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzuy, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzuy.zza((zzuy) this.zza, zzakbVar);
            return this;
        }

        private zza() {
            super(zzuy.zzc);
        }
    }

    public static zzuy zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzuy) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzakb zzd() {
        return this.zzf;
    }

    public static zzani<zzuy> zze() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzux.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzuy();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzuy> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzuy.class) {
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

    static /* synthetic */ void zza(zzuy zzuyVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzuyVar.zzf = zzakbVar;
    }

    static {
        zzuy zzuyVar = new zzuy();
        zzc = zzuyVar;
        zzalt.zza((Class<zzuy>) zzuy.class, zzuyVar);
    }

    private zzuy() {
    }
}
