package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwg extends zzalt<zzwg, zza> implements zzamx {
    private static final zzwg zzc;
    private static volatile zzani<zzwg> zzd;
    private int zze;
    private int zzf;
    private zzwm zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwg, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzwg.zza((zzwg) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzwm zzwmVar) {
            zzh();
            zzwg.zza((zzwg) this.zza, zzwmVar);
            return this;
        }

        private zza() {
            super(zzwg.zzc);
        }
    }

    public static zzwg zzd() {
        return zzc;
    }

    public static zzwg zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzwg) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzwm zze() {
        zzwm zzwmVar = this.zzg;
        return zzwmVar == null ? zzwm.zze() : zzwmVar;
    }

    public final zzakb zzf() {
        return this.zzh;
    }

    public static zzani<zzwg> c_() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwi.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwg();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwg> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwg.class) {
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

    static /* synthetic */ void zza(zzwg zzwgVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzwgVar.zzh = zzakbVar;
    }

    static /* synthetic */ void zza(zzwg zzwgVar, zzwm zzwmVar) {
        Objects.requireNonNull(zzwmVar);
        zzwgVar.zzg = zzwmVar;
        zzwgVar.zze |= 1;
    }

    static {
        zzwg zzwgVar = new zzwg();
        zzc = zzwgVar;
        zzalt.zza((Class<zzwg>) zzwg.class, zzwgVar);
    }

    private zzwg() {
    }
}
