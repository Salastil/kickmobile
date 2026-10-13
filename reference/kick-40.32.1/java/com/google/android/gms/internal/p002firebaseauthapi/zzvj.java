package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvj extends zzalt<zzvj, zza> implements zzamx {
    private static final zzvj zzc;
    private static volatile zzani<zzvj> zzd;
    private int zze;
    private zzxk zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvj zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzvj, zza> implements zzamx {
        public final zza zza(zzxk zzxkVar) {
            zzh();
            zzvj.zza((zzvj) this.zza, zzxkVar);
            return this;
        }

        private zza() {
            super(zzvj.zzc);
        }
    }

    public final zzxk zzd() {
        zzxk zzxkVar = this.zzf;
        return zzxkVar == null ? zzxk.zzc() : zzxkVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzvl.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvj();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzani<zzvj> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzvj.class) {
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

    static /* synthetic */ void zza(zzvj zzvjVar, zzxk zzxkVar) {
        Objects.requireNonNull(zzxkVar);
        zzvjVar.zzf = zzxkVar;
        zzvjVar.zze |= 1;
    }

    static {
        zzvj zzvjVar = new zzvj();
        zzc = zzvjVar;
        zzalt.zza((Class<zzvj>) zzvj.class, zzvjVar);
    }

    private zzvj() {
    }
}
