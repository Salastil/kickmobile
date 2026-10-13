package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxq extends zzalt<zzxq, zzb> implements zzamx {
    private static final zzxq zzc;
    private static volatile zzani<zzxq> zzd;
    private int zze;
    private zzalx<zza> zzf = zzp();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends zzalt<zza, C0114zza> implements zzamx {
        private static final zza zzc;
        private static volatile zzani<zza> zzd;
        private int zze;
        private zzxg zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        public final int zza() {
            return this.zzh;
        }

        public final zzxg zzb() {
            zzxg zzxgVar = this.zzf;
            return zzxgVar == null ? zzxg.zzd() : zzxgVar;
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
        public static final class C0114zza extends zzalt.zza<zza, C0114zza> implements zzamx {
            public final C0114zza zza(zzxg.zzb zzbVar) {
                zzh();
                zza.zza((zza) this.zza, (zzxg) ((zzalt) zzbVar.zze()));
                return this;
            }

            public final C0114zza zza(int i) {
                zzh();
                ((zza) this.zza).zzh = i;
                return this;
            }

            public final C0114zza zza(zzyi zzyiVar) {
                zzh();
                zza.zza((zza) this.zza, zzyiVar);
                return this;
            }

            public final C0114zza zza(zzxh zzxhVar) {
                zzh();
                zza.zza((zza) this.zza, zzxhVar);
                return this;
            }

            private C0114zza() {
                super(zza.zzc);
            }
        }

        public final zzxh zzc() {
            zzxh zzxhVarZza = zzxh.zza(this.zzg);
            return zzxhVarZza == null ? zzxh.UNRECOGNIZED : zzxhVarZza;
        }

        public static C0114zza zzd() {
            return (C0114zza) zzc.zzm();
        }

        public final zzyi zzf() {
            zzyi zzyiVarZza = zzyi.zza(this.zzi);
            return zzyiVarZza == null ? zzyi.UNRECOGNIZED : zzyiVarZza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
        protected final Object zza(int i, Object obj, Object obj2) {
            zzani zzcVar;
            int i2 = zzxp.zza[i - 1];
            switch (i2) {
                case 1:
                    return new zza();
                case 2:
                    return new C0114zza();
                case 3:
                    return zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzani<zza> zzaniVar = zzd;
                    if (zzaniVar != null) {
                        return zzaniVar;
                    }
                    synchronized (zza.class) {
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

        static /* synthetic */ void zza(zza zzaVar, zzxg zzxgVar) {
            Objects.requireNonNull(zzxgVar);
            zzaVar.zzf = zzxgVar;
            zzaVar.zze |= 1;
        }

        static /* synthetic */ void zza(zza zzaVar, zzyi zzyiVar) {
            zzaVar.zzi = zzyiVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, zzxh zzxhVar) {
            zzaVar.zzg = zzxhVar.zza();
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzalt.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean e_() {
            return (this.zze & 1) != 0;
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zzb extends zzalt.zza<zzxq, zzb> implements zzamx {
        public final zzb zza(zza zzaVar) {
            zzh();
            zzxq.zza((zzxq) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(int i) {
            zzh();
            ((zzxq) this.zza).zze = i;
            return this;
        }

        private zzb() {
            super(zzxq.zzc);
        }
    }

    public static zzb zzc() {
        return (zzb) zzc.zzm();
    }

    public static zzxq zza(InputStream inputStream, zzalf zzalfVar) throws IOException {
        return (zzxq) zzalt.zza(zzc, inputStream, zzalfVar);
    }

    public static zzxq zza(byte[] bArr, zzalf zzalfVar) throws zzamd {
        return (zzxq) zzalt.zza(zzc, bArr, zzalfVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxp.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxq();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzani<zzxq> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxq.class) {
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

    public final List<zza> zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzxq zzxqVar, zza zzaVar) {
        Objects.requireNonNull(zzaVar);
        zzalx<zza> zzalxVar = zzxqVar.zzf;
        if (!zzalxVar.zzc()) {
            zzxqVar.zzf = zzalt.zza(zzalxVar);
        }
        zzxqVar.zzf.add(zzaVar);
    }

    static {
        zzxq zzxqVar = new zzxq();
        zzc = zzxqVar;
        zzalt.zza((Class<zzxq>) zzxq.class, zzxqVar);
    }

    private zzxq() {
    }
}
