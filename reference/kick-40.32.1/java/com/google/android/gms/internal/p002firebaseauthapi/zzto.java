package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzto extends zzalt<zzto, zza> implements zzamx {
    private static final zzto zzc;
    private static volatile zzani<zzto> zzd;
    private int zze;
    private int zzf;
    private zztu zzg;
    private zzwg zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzto, zza> implements zzamx {
        public final zza zza(zztu zztuVar) {
            zzh();
            zzto.zza((zzto) this.zza, zztuVar);
            return this;
        }

        public final zza zza(zzwg zzwgVar) {
            zzh();
            zzto.zza((zzto) this.zza, zzwgVar);
            return this;
        }

        private zza() {
            super(zzto.zzc);
        }
    }

    public static zzto zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzto) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zztu zzd() {
        zztu zztuVar = this.zzg;
        return zztuVar == null ? zztu.zzd() : zztuVar;
    }

    public final zzwg zze() {
        zzwg zzwgVar = this.zzh;
        return zzwgVar == null ? zzwg.zzd() : zzwgVar;
    }

    public static zzani<zzto> zzf() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zztn.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzto();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzto> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzto.class) {
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

    static /* synthetic */ void zza(zzto zztoVar, zztu zztuVar) {
        Objects.requireNonNull(zztuVar);
        zztoVar.zzg = zztuVar;
        zztoVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzto zztoVar, zzwg zzwgVar) {
        Objects.requireNonNull(zzwgVar);
        zztoVar.zzh = zzwgVar;
        zztoVar.zze |= 2;
    }

    static {
        zzto zztoVar = new zzto();
        zzc = zztoVar;
        zzalt.zza((Class<zzto>) zzto.class, zztoVar);
    }

    private zzto() {
    }
}
