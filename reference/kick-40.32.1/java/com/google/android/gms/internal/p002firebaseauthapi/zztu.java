package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztu extends zzalt<zztu, zza> implements zzamx {
    private static final zztu zzc;
    private static volatile zzani<zztu> zzd;
    private int zze;
    private int zzf;
    private zzua zzg;
    private zzakb zzh = zzakb.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zztu, zza> implements zzamx {
        public final zza zza(zzakb zzakbVar) {
            zzh();
            zztu.zza((zztu) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzua zzuaVar) {
            zzh();
            zztu.zza((zztu) this.zza, zzuaVar);
            return this;
        }

        private zza() {
            super(zztu.zzc);
        }
    }

    public static zztu zzd() {
        return zzc;
    }

    public final zzua zze() {
        zzua zzuaVar = this.zzg;
        return zzuaVar == null ? zzua.zzd() : zzuaVar;
    }

    public final zzakb zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zztt.zza[i - 1];
        switch (i2) {
            case 1:
                return new zztu();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzani<zztu> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zztu.class) {
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

    static /* synthetic */ void zza(zztu zztuVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zztuVar.zzh = zzakbVar;
    }

    static /* synthetic */ void zza(zztu zztuVar, zzua zzuaVar) {
        Objects.requireNonNull(zzuaVar);
        zztuVar.zzg = zzuaVar;
        zztuVar.zze |= 1;
    }

    static {
        zztu zztuVar = new zztu();
        zzc = zztuVar;
        zzalt.zza((Class<zztu>) zztu.class, zztuVar);
    }

    private zztu() {
    }
}
