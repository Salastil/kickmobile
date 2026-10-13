package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvm extends zzalt<zzvm, zza> implements zzamx {
    private static final zzvm zzc;
    private static volatile zzani<zzvm> zzd;
    private int zze;
    private zzvp zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvm zza(zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (zzvm) zzalt.zza(zzc, zzakbVar, zzalfVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzvm, zza> implements zzamx {
        public final zza zza(zzvp zzvpVar) {
            zzh();
            zzvm.zza((zzvm) this.zza, zzvpVar);
            return this;
        }

        private zza() {
            super(zzvm.zzc);
        }
    }

    public final zzvp zzc() {
        zzvp zzvpVar = this.zzf;
        return zzvpVar == null ? zzvp.zze() : zzvpVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzvo.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvm();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzvm> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzvm.class) {
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

    static /* synthetic */ void zza(zzvm zzvmVar, zzvp zzvpVar) {
        Objects.requireNonNull(zzvpVar);
        zzvmVar.zzf = zzvpVar;
        zzvmVar.zze |= 1;
    }

    static {
        zzvm zzvmVar = new zzvm();
        zzc = zzvmVar;
        zzalt.zza((Class<zzvm>) zzvm.class, zzvmVar);
    }

    private zzvm() {
    }
}
