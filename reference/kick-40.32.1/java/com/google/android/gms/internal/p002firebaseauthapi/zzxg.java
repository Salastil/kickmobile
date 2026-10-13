package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxg extends zzalt<zzxg, zzb> implements zzamx {
    private static final zzxg zzc;
    private static volatile zzani<zzxg> zzd;
    private String zze = "";
    private zzakb zzf = zzakb.zza;
    private int zzg;

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    public final zza zzb() {
        zza zzaVarZza = zza.zza(this.zzg);
        return zzaVarZza == null ? zza.UNRECOGNIZED : zzaVarZza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zzb extends zzalt.zza<zzxg, zzb> implements zzamx {
        public final zzb zza(zza zzaVar) {
            zzh();
            zzxg.zza((zzxg) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(String str) {
            zzh();
            zzxg.zza((zzxg) this.zza, str);
            return this;
        }

        public final zzb zza(zzakb zzakbVar) {
            zzh();
            zzxg.zza((zzxg) this.zza, zzakbVar);
            return this;
        }

        private zzb() {
            super(zzxg.zzc);
        }
    }

    public static zzxg zzd() {
        return zzc;
    }

    public final zzakb zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalt
    protected final Object zza(int i, Object obj, Object obj2) {
        zzani zzcVar;
        int i2 = zzxf.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzxg();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzani<zzxg> zzaniVar = zzd;
                if (zzaniVar != null) {
                    return zzaniVar;
                }
                synchronized (zzxg.class) {
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

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public enum zza implements zzalv {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private final int zzh;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalv
        public final int zza() {
            return this == UNRECOGNIZED ? zzalw.zza() : this.zzh;
        }

        public static zza zza(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zza());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        zza(int i) {
            this.zzh = i;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzxg zzxgVar, zza zzaVar) {
        zzxgVar.zzg = zzaVar.zza();
    }

    static /* synthetic */ void zza(zzxg zzxgVar, String str) {
        Objects.requireNonNull(str);
        zzxgVar.zze = str;
    }

    static /* synthetic */ void zza(zzxg zzxgVar, zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        zzxgVar.zzf = zzakbVar;
    }

    static {
        zzxg zzxgVar = new zzxg();
        zzc = zzxgVar;
        zzalt.zza((Class<zzxg>) zzxg.class, zzxgVar);
    }

    private zzxg() {
    }
}
