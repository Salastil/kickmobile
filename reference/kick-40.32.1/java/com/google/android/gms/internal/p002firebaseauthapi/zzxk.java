package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxk extends zzalt<zzxk, zza> implements zzamx {
    private static final zzxk zzc;
    private static volatile zzani<zzxk> zzd;
    private String zze = "";
    private zzakb zzf = zzakb.zza;
    private int zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zza zza(zzxk zzxkVar) {
        return (zza) zzc.zzm().zza(zzxkVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzxk, zza> implements zzamx {
        public final zza zza(zzyi zzyiVar) {
            zzh();
            zzxk.zza((zzxk) this.zza, zzyiVar);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            zzxk.zza((zzxk) this.zza, str);
            return this;
        }

        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzxk.zza((zzxk) this.zza, zzakbVar);
            return this;
        }

        private zza() {
            super(zzxk.zzc);
        }
    }

    public static zzxk zzc() {
        return zzc;
    }

    public static zzxk zza(byte[] bArr, zzalf zzalfVar) throws zzamd {
        return (zzxk) zzalt.zza(zzc, bArr, zzalfVar);
    }

    public final zzyi zzd() {
        zzyi zzyiVarZza = zzyi.zza(this.zzg);
        return zzyiVarZza == null ? zzyi.UNRECOGNIZED : zzyiVarZza;
    }

    public final zzakb zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxj.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxk();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxk> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxk.class) {
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

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzxk zzxkVar, zzyi zzyiVar) {
        zzxkVar.zzg = zzyiVar.zza();
    }

    static /* synthetic */ void zza(zzxk zzxkVar, String str) {
        Objects.requireNonNull(str);
        zzxkVar.zze = str;
    }

    static /* synthetic */ void zza(zzxk zzxkVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzxkVar.zzf = zzakbVar;
    }

    static {
        zzxk zzxkVar = new zzxk();
        zzc = zzxkVar;
        zzalt.zza((Class<zzxk>) zzxk.class, zzxkVar);
    }

    private zzxk() {
    }
}
