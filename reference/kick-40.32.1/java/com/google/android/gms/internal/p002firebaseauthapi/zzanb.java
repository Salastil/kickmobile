package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzanb<T> implements zzanl<T> {
    private final zzamv zza;
    private final zzaob<?, ?> zzb;
    private final boolean zzc;
    private final zzalh<?> zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final int zza(T t) {
        zzaob<?, ?> zzaobVar = this.zzb;
        int iZzb = zzaobVar.zzb(zzaobVar.zzd(t));
        return this.zzc ? iZzb + this.zzd.zza(t).zza() : iZzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final int zzb(T t) {
        int iHashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    static <T> zzanb<T> zza(zzaob<?, ?> zzaobVar, zzalh<?> zzalhVar, zzamv zzamvVar) {
        return new zzanb<>(zzaobVar, zzalhVar, zzamvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final T zza() {
        zzamv zzamvVar = this.zza;
        if (zzamvVar instanceof zzalt) {
            return (T) ((zzalt) zzamvVar).zzo();
        }
        return (T) zzamvVar.zzq().zzf();
    }

    private zzanb(zzaob<?, ?> zzaobVar, zzalh<?> zzalhVar, zzamv zzamvVar) {
        this.zzb = zzaobVar;
        this.zzc = zzalhVar.zza(zzamvVar);
        this.zzd = zzalhVar;
        this.zza = zzamvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, T t2) {
        zzano.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzano.zza(this.zzd, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, zzakw zzakwVar, zzalf zzalfVar) throws IOException {
        boolean zZzt;
        zzaob<?, ?> zzaobVar = this.zzb;
        zzalh<?> zzalhVar = this.zzd;
        Object objZzc = zzaobVar.zzc(t);
        zzalm<T> zzalmVarZzb = zzalhVar.zzb(t);
        while (zzakwVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzakwVar.zzd();
                int iZzj = 0;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZza = zzalhVar.zza(zzalfVar, this.zza, iZzd >>> 3);
                        if (objZza != null) {
                            zzalhVar.zza(zzakwVar, objZza, zzalfVar, zzalmVarZzb);
                        } else {
                            zZzt = zzaobVar.zza(objZzc, zzakwVar, 0);
                        }
                    } else {
                        zZzt = zzakwVar.zzt();
                    }
                    if (!zZzt) {
                        zzaobVar.zzb(t, objZzc);
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    zzakb zzakbVarZzp = null;
                    while (zzakwVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzakwVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzakwVar.zzj();
                            objZza2 = zzalhVar.zza(zzalfVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZza2 != null) {
                                zzalhVar.zza(zzakwVar, objZza2, zzalfVar, zzalmVarZzb);
                            } else {
                                zzakbVarZzp = zzakwVar.zzp();
                            }
                        } else if (iZzd2 == 12 || !zzakwVar.zzt()) {
                            break;
                        }
                    }
                    if (zzakwVar.zzd() != 12) {
                        throw zzamd.zzb();
                    }
                    if (zzakbVarZzp != null) {
                        if (objZza2 != null) {
                            zzalhVar.zza(zzakbVarZzp, objZza2, zzalfVar, zzalmVarZzb);
                        } else {
                            zzaobVar.zza(objZzc, iZzj, zzakbVarZzp);
                        }
                    }
                }
                zZzt = true;
                if (!zZzt) {
                    zzaobVar.zzb(t, objZzc);
                    return;
                }
            } catch (Throwable th) {
                zzaobVar.zzb(t, objZzc);
                throw th;
            }
        }
        zzaobVar.zzb(t, objZzc);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1 A[EDGE_INSN: B:58:0x00a1->B:35:0x00a1 BREAK  A[LOOP:1: B:18:0x0059->B:63:0x0059], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, byte[] bArr, int i, int i2, zzaka zzakaVar) throws IOException {
        int iZzc;
        zzalt zzaltVar = (zzalt) t;
        zzaoa zzaoaVarZzd = zzaltVar.zzb;
        if (zzaoaVarZzd == zzaoa.zzc()) {
            zzaoaVarZzd = zzaoa.zzd();
            zzaltVar.zzb = zzaoaVarZzd;
        }
        zzaoa zzaoaVar = zzaoaVarZzd;
        ((zzalt.zzb) t).zza();
        zzalt.zzd zzdVar = null;
        while (i < i2) {
            int iZzc2 = zzajx.zzc(bArr, i, zzakaVar);
            int i3 = zzakaVar.zza;
            if (i3 == 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zzaka zzakaVar2 = zzakaVar;
                int i5 = 0;
                zzakb zzakbVar = null;
                while (true) {
                    if (iZzc2 >= i4) {
                        iZzc = iZzc2;
                        break;
                    }
                    iZzc = zzajx.zzc(bArr2, iZzc2, zzakaVar2);
                    int i6 = zzakaVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 == 2) {
                        if (i8 != 0) {
                            if (i6 != 12) {
                                break;
                                break;
                            }
                            iZzc2 = zzajx.zza(i6, bArr2, iZzc, i4, zzakaVar2);
                        } else {
                            iZzc2 = zzajx.zzc(bArr2, iZzc, zzakaVar2);
                            i5 = zzakaVar2.zza;
                            zzdVar = (zzalt.zzd) this.zzd.zza(zzakaVar2.zzd, this.zza, i5);
                        }
                    } else {
                        if (i7 == 3) {
                            if (zzdVar != null) {
                                zzank.zza();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                iZzc2 = zzajx.zza(bArr2, iZzc, zzakaVar2);
                                zzakbVar = (zzakb) zzakaVar2.zzc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZzc2 = zzajx.zza(i6, bArr2, iZzc, i4, zzakaVar2);
                        }
                    }
                }
                if (zzakbVar != null) {
                    zzaoaVar.zza((i5 << 3) | 2, zzakbVar);
                }
                i = iZzc;
                bArr = bArr2;
                i2 = i4;
                zzakaVar = zzakaVar2;
            } else if ((i3 & 7) == 2) {
                zzdVar = (zzalt.zzd) this.zzd.zza(zzakaVar.zzd, this.zza, i3 >>> 3);
                if (zzdVar != null) {
                    zzank.zza();
                    throw new NoSuchMethodError();
                }
                i = zzajx.zza(i3, bArr, iZzc2, i2, zzaoaVar, zzakaVar);
            } else {
                i = zzajx.zza(i3, bArr, iZzc2, i2, zzakaVar);
            }
        }
        if (i != i2) {
            throw zzamd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, zzale zzaleVar) throws IOException {
        Iterator itZzc = this.zzd.zza(t).zzc();
        while (itZzc.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzc.next();
            zzalo zzaloVar = (zzalo) entry.getKey();
            if (zzaloVar.zzc() != zzaoq.MESSAGE || zzaloVar.zze() || zzaloVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzalz) {
                zzaleVar.zza(zzaloVar.zza(), (Object) ((zzalz) entry).zza().zzb());
            } else {
                zzaleVar.zza(zzaloVar.zza(), entry.getValue());
            }
        }
        zzaob<?, ?> zzaobVar = this.zzb;
        zzaobVar.zza(zzaobVar.zzd(t), zzaleVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final boolean zze(T t) {
        return this.zzd.zza(t).zze();
    }
}
