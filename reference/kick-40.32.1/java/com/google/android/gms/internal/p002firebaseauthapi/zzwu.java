package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwu extends zzalt<zzwu, zza> implements zzamx {
    private static final zzwu zzc;
    private static volatile zzani<zzwu> zzd;
    private int zze;
    private zzwx zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzwu zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzwu) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwu, zza> implements zzamx {
        public final zza zza(zzwx zzwxVar) {
            zzh();
            zzwu.zza((zzwu) this.zza, zzwxVar);
            return this;
        }

        private zza() {
            super(zzwu.zzc);
        }
    }

    public final zzwx zzc() {
        zzwx zzwxVar = this.zzf;
        return zzwxVar == null ? zzwx.zzf() : zzwxVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwt.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwu();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwu> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwu.class) {
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

    static /* synthetic */ void zza(zzwu zzwuVar, zzwx zzwxVar) {
        Objects.requireNonNull(zzwxVar);
        zzwuVar.zzf = zzwxVar;
        zzwuVar.zze |= 1;
    }

    static {
        zzwu zzwuVar = new zzwu();
        zzc = zzwuVar;
        zzalt.zza((Class<zzwu>) zzwu.class, zzwuVar);
    }

    private zzwu() {
    }
}
