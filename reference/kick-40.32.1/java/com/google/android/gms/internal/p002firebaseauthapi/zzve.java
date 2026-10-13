package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzve extends zzalt<zzve, zza> implements zzamx {
    private static final zzve zzc;
    private static volatile zzani<zzve> zzd;
    private int zze;
    private zzakb zzf = zzakb.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzve, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzve.zza((zzve) this.zza, zzakbVar);
            return this;
        }

        private zza() {
            super(zzve.zzc);
        }
    }

    public static zzve zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzve) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzakb zzd() {
        return this.zzf;
    }

    public static zzani<zzve> zze() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzvd.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzve();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzve> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzve.class) {
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

    static /* synthetic */ void zza(zzve zzveVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzveVar.zzf = zzakbVar;
    }

    static {
        zzve zzveVar = new zzve();
        zzc = zzveVar;
        zzalt.zza((Class<zzve>) zzve.class, zzveVar);
    }

    private zzve() {
    }
}
