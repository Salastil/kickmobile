package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzti extends zzalt<zzti, zza> implements zzamx {
    private static final zzti zzc;
    private static volatile zzani<zzti> zzd;
    private int zze;
    private int zzf;
    private zztl zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzti, zza> implements zzamx {
        public final zza zza(int i) {
            zzh();
            ((zzti) this.zza).zzf = i;
            return this;
        }

        public final zza zza(zztl zztlVar) {
            zzh();
            zzti.zza((zzti) this.zza, zztlVar);
            return this;
        }

        private zza() {
            super(zzti.zzc);
        }
    }

    public static zzti zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzti) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zztl zzd() {
        zztl zztlVar = this.zzg;
        return zztlVar == null ? zztl.zzd() : zztlVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzth.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzti();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzti> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzti.class) {
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

    static /* synthetic */ void zza(zzti zztiVar, zztl zztlVar) {
        Objects.requireNonNull(zztlVar);
        zztiVar.zzg = zztlVar;
        zztiVar.zze |= 1;
    }

    static {
        zzti zztiVar = new zzti();
        zzc = zztiVar;
        zzalt.zza((Class<zzti>) zzti.class, zztiVar);
    }

    private zzti() {
    }
}
