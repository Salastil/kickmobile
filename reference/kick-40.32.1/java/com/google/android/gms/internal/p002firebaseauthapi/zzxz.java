package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxz extends zzalt<zzxz, zza> implements zzamx {
    private static final zzxz zzc;
    private static volatile zzani<zzxz> zzd;
    private String zze = "";

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxz zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzxz, zza> implements zzamx {
        public final zza zza(String str) {
            zzh();
            zzxz.zza((zzxz) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxz.zzc);
        }
    }

    public static zzxz zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzxz) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxy.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxz();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxz> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxz.class) {
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

    public final String zzd() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzxz zzxzVar, String str) {
        Objects.requireNonNull(str);
        zzxzVar.zze = str;
    }

    static {
        zzxz zzxzVar = new zzxz();
        zzc = zzxzVar;
        zzalt.zza((Class<zzxz>) zzxz.class, zzxzVar);
    }

    private zzxz() {
    }
}
