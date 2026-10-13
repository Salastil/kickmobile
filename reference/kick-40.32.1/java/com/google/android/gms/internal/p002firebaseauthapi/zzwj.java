package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwj extends zzalt<zzwj, zza> implements zzamx {
    private static final zzwj zzc;
    private static volatile zzani<zzwj> zzd;
    private int zze;
    private zzwm zzf;
    private int zzg;
    private int zzh;

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwj, zza> implements zzamx {
        public final zza zza(int i) {
            zzh();
            ((zzwj) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzwm zzwmVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzwmVar);
            return this;
        }

        private zza() {
            super(zzwj.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwj zze() {
        return zzc;
    }

    public static zzwj zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzwj) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    public final zzwm zzf() {
        zzwm zzwmVar = this.zzf;
        return zzwmVar == null ? zzwm.zze() : zzwmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwl.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwj();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwj> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwj.class) {
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

    static /* synthetic */ void zza(zzwj zzwjVar, zzwm zzwmVar) {
        Objects.requireNonNull(zzwmVar);
        zzwjVar.zzf = zzwmVar;
        zzwjVar.zze |= 1;
    }

    static {
        zzwj zzwjVar = new zzwj();
        zzc = zzwjVar;
        zzalt.zza((Class<zzwj>) zzwj.class, zzwjVar);
    }

    private zzwj() {
    }
}
