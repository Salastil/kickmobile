package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztr extends zzalt<zztr, zza> implements zzamx {
    private static final zztr zzc;
    private static volatile zzani<zztr> zzd;
    private int zze;
    private zztx zzf;
    private zzwj zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zztr zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zztr) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zztr, zza> implements zzamx {
        public final zza zza(zztx zztxVar) {
            zzh();
            zztr.zza((zztr) this.zza, zztxVar);
            return this;
        }

        public final zza zza(zzwj zzwjVar) {
            zzh();
            zztr.zza((zztr) this.zza, zzwjVar);
            return this;
        }

        private zza() {
            super(zztr.zzc);
        }
    }

    public final zztx zzc() {
        zztx zztxVar = this.zzf;
        return zztxVar == null ? zztx.zzd() : zztxVar;
    }

    public final zzwj zzd() {
        zzwj zzwjVar = this.zzg;
        return zzwjVar == null ? zzwj.zze() : zzwjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zztq.zza[i - 1];
        switch (i2) {
            case 1:
                return new zztr();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zztr> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zztr.class) {
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

    static /* synthetic */ void zza(zztr zztrVar, zztx zztxVar) {
        Objects.requireNonNull(zztxVar);
        zztrVar.zzf = zztxVar;
        zztrVar.zze |= 1;
    }

    static /* synthetic */ void zza(zztr zztrVar, zzwj zzwjVar) {
        Objects.requireNonNull(zzwjVar);
        zztrVar.zzg = zzwjVar;
        zztrVar.zze |= 2;
    }

    static {
        zztr zztrVar = new zztr();
        zzc = zztrVar;
        zzalt.zza((Class<zztr>) zztr.class, zztrVar);
    }

    private zztr() {
    }
}
