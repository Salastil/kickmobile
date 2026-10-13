package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxw extends zzalt<zzxw, zza> implements zzamx {
    private static final zzxw zzc;
    private static volatile zzani<zzxw> zzd;
    private int zze;
    private int zzf;
    private zzxz zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzxw, zza> implements zzamx {
        public final zza zza(zzxz zzxzVar) {
            zzh();
            zzxw.zza((zzxw) this.zza, zzxzVar);
            return this;
        }

        private zza() {
            super(zzxw.zzc);
        }
    }

    public static zzxw zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzxw) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzxz zzd() {
        zzxz zzxzVar = this.zzg;
        return zzxzVar == null ? zzxz.zzc() : zzxzVar;
    }

    public static zzani<zzxw> zze() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxv.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxw();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxw> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxw.class) {
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

    static /* synthetic */ void zza(zzxw zzxwVar, zzxz zzxzVar) {
        Objects.requireNonNull(zzxzVar);
        zzxwVar.zzg = zzxzVar;
        zzxwVar.zze |= 1;
    }

    static {
        zzxw zzxwVar = new zzxw();
        zzc = zzxwVar;
        zzalt.zza((Class<zzxw>) zzxw.class, zzxwVar);
    }

    private zzxw() {
    }
}
