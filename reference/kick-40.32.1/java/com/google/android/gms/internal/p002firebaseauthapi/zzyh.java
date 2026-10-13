package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zzyh extends zzalt<zzyh, zza> implements zzamx {
    private static final zzyh zzc;
    private static volatile zzani<zzyh> zzd;
    private String zze = "";
    private zzalx<zzxn> zzf = zzp();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzyh, zza> implements zzamx {
        private zza() {
            super(zzyh.zzc);
        }
    }

    public static zzyh zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzyj.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzxn.class});
            case 4:
                return zzc;
            case 5:
                zzani<zzyh> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzyh.class) {
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
        zzyh zzyhVar = new zzyh();
        zzc = zzyhVar;
        zzalt.zza((Class<zzyh>) zzyh.class, zzyhVar);
    }

    private zzyh() {
    }
}
