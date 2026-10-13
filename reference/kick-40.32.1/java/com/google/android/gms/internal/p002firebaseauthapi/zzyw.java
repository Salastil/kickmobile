package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyw extends zzalt<zzyw, zza> implements zzamx {
    private static final zzyw zzc;
    private static volatile zzani<zzyw> zzd;
    private int zze;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzyw, zza> implements zzamx {
        private zza() {
            super(zzyw.zzc);
        }
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyw zzc() {
        return zzc;
    }

    public static zzyw zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzyw) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzyy.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyw();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzani<zzyw> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzyw.class) {
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
        zzyw zzywVar = new zzyw();
        zzc = zzywVar;
        zzalt.zza((Class<zzyw>) zzyw.class, zzywVar);
    }

    private zzyw() {
    }
}
