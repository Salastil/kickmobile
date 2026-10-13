package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzud extends zzalt<zzud, zza> implements zzamx {
    private static final zzud zzc;
    private static volatile zzani<zzud> zzd;
    private int zze;
    private int zzf;
    private zzuj zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzud, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzud.zza((zzud) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzuj zzujVar) {
            zzh();
            zzud.zza((zzud) this.zza, zzujVar);
            return this;
        }

        private zza() {
            super(zzud.zzc);
        }
    }

    public static zzud zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzud) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzuj zzd() {
        zzuj zzujVar = this.zzg;
        return zzujVar == null ? zzuj.zzd() : zzujVar;
    }

    public final zzakb zze() {
        return this.zzh;
    }

    public static zzani<zzud> zzf() {
        return (zzani) zzc.zza(zzalt.zzf.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzuc.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzud();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzud> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzud.class) {
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

    static /* synthetic */ void zza(zzud zzudVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzudVar.zzh = zzakbVar;
    }

    static /* synthetic */ void zza(zzud zzudVar, zzuj zzujVar) {
        Objects.requireNonNull(zzujVar);
        zzudVar.zzg = zzujVar;
        zzudVar.zze |= 1;
    }

    static {
        zzud zzudVar = new zzud();
        zzc = zzudVar;
        zzalt.zza((Class<zzud>) zzud.class, zzudVar);
    }

    private zzud() {
    }
}
