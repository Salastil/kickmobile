package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvh extends zzalt<zzvh, zza> implements zzamx {
    private static final zzvh zzc;
    private static volatile zzani<zzvh> zzd;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzvh, zza> implements zzamx {
        private zza() {
            super(zzvh.zzc);
        }
    }

    public static zzvh zzb() {
        return zzc;
    }

    public static zzvh zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzvh) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzvg.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzani<zzvh> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzvh.class) {
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

    static {
        zzvh zzvhVar = new zzvh();
        zzc = zzvhVar;
        zzalt.zza((Class<zzvh>) zzvh.class, zzvhVar);
    }

    private zzvh() {
    }
}
