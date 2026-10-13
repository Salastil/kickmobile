package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyf extends zzalt<zzyf, zza> implements zzamx {
    private static final zzyf zzc;
    private static volatile zzani<zzyf> zzd;
    private int zze;
    private String zzf = "";
    private zzxk zzg;

    public final zzxk zza() {
        zzxk zzxkVar = this.zzg;
        return zzxkVar == null ? zzxk.zzc() : zzxkVar;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzyf, zza> implements zzamx {
        public final zza zza(zzxk zzxkVar) {
            zzh();
            zzyf.zza((zzyf) this.zza, zzxkVar);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            zzyf.zza((zzyf) this.zza, str);
            return this;
        }

        private zza() {
            super(zzyf.zzc);
        }
    }

    public static zzyf zzd() {
        return zzc;
    }

    public static zzyf zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzyf) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzye.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyf();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzyf> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzyf.class) {
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

    public final String zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzyf zzyfVar, zzxk zzxkVar) {
        Objects.requireNonNull(zzxkVar);
        zzyfVar.zzg = zzxkVar;
        zzyfVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzyf zzyfVar, String str) {
        Objects.requireNonNull(str);
        zzyfVar.zzf = str;
    }

    static {
        zzyf zzyfVar = new zzyf();
        zzc = zzyfVar;
        zzalt.zza((Class<zzyf>) zzyf.class, zzyfVar);
    }

    private zzyf() {
    }
}
