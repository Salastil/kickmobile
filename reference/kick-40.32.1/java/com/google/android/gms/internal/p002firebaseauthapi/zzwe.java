package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwe extends zzalt<zzwe, zza> implements zzamx {
    private static final zzwe zzc;
    private static volatile zzani<zzwe> zzd;
    private int zze;
    private zzakb zzf = zzakb.zza;
    private zzxt zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzwe zza(InputStream inputStream, zzalf zzalfVar) throws IOException {
        return (zzwe) zzalt.zza(zzc, inputStream, zzalfVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt.zza<zzwe, zza> implements zzamx {
        public final zza zza() {
            zzh();
            zzwe.zza((zzwe) this.zza);
            return this;
        }

        public final zza zza(zzakb zzakbVar) {
            zzh();
            zzwe.zza((zzwe) this.zza, zzakbVar);
            return this;
        }

        public final zza zza(zzxt zzxtVar) {
            zzh();
            zzwe.zza((zzwe) this.zza, zzxtVar);
            return this;
        }

        private zza() {
            super(zzwe.zzc);
        }
    }

    public final zzakb zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzwd.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwe();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzwe> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzwe.class) {
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

    static /* synthetic */ void zza(zzwe zzweVar) {
        zzweVar.zzg = null;
        zzweVar.zze &= -2;
    }

    static /* synthetic */ void zza(zzwe zzweVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzweVar.zzf = zzakbVar;
    }

    static /* synthetic */ void zza(zzwe zzweVar, zzxt zzxtVar) {
        Objects.requireNonNull(zzxtVar);
        zzweVar.zzg = zzxtVar;
        zzweVar.zze |= 1;
    }

    static {
        zzwe zzweVar = new zzwe();
        zzc = zzweVar;
        zzalt.zza((Class<zzwe>) zzwe.class, zzweVar);
    }

    private zzwe() {
    }
}
