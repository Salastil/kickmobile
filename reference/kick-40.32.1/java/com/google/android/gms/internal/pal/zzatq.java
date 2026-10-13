package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatq implements zzawi {
    private final zzatp zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzatq(zzatp zzatpVar) {
        byte[] bArr = zzauz.zzb;
        this.zza = zzatpVar;
        zzatpVar.zzc = this;
    }

    private final void zzO(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzava("Protocol message tag had invalid wire type.");
        }
    }

    private final void zzP(Object obj, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        zzatp zzatpVar = this.zza;
        int iZzn = zzatpVar.zzn();
        if (zzatpVar.zza >= zzatpVar.zzb) {
            throw new zzavb("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iZzA = zzatpVar.zzA(iZzn);
        zzatpVar.zza++;
        zzawnVar.zzg(obj, this, zzatyVar);
        zzatpVar.zzb(0);
        zzatpVar.zza--;
        zzatpVar.zzB(iZzA);
    }

    private final void zzQ(Object obj, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzawnVar.zzg(obj, this, zzatyVar);
            if (this.zzb != this.zzc) {
                throw new zzavb("Failed to parse the message.");
            }
            this.zzc = i;
        } catch (Throwable th) {
            this.zzc = i;
            throw th;
        }
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzD() != i) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void zzS(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzavb("Failed to parse the message.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzavb("Failed to parse the message.");
        }
    }

    public static zzatq zza(zzatp zzatpVar) {
        Object obj = zzatpVar.zzc;
        return obj != null ? (zzatq) obj : new zzatq(zzatpVar);
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzA(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzauoVar.zzh(zzatpVar.zzg());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzg());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzg()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzg()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzB(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzavl) {
            zzavl zzavlVar = (zzavl) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzT(iZzn);
                int iZzD = iZzn + zzatpVar.zzD();
                do {
                    zzavlVar.zzf(zzatpVar.zzh());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzavlVar.zzf(zzatpVar2.zzh());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzT(iZzn2);
                int iZzD2 = iZzn2 + zzatpVar3.zzD();
                do {
                    list.add(Long.valueOf(zzatpVar3.zzh()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Long.valueOf(zzatpVar4.zzh()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzC(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzS(iZzn);
                int iZzD = zzatpVar.zzD() + iZzn;
                do {
                    zzauoVar.zzh(zzatpVar.zzi());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            if (i != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzi());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzS(iZzn2);
                int iZzD2 = zzatpVar3.zzD() + iZzn2;
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzi()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            if (i2 != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzi()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzD(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzatd) {
            zzatd zzatdVar = (zzatd) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzatdVar.zzf(zzatpVar.zzj());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzatdVar.zzf(zzatpVar2.zzj());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Boolean.valueOf(zzatpVar3.zzj()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Boolean.valueOf(zzatpVar4.zzj()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzE(List list, boolean z) throws IOException {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            throw new zzava("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzavi) && !z) {
            zzavi zzaviVar = (zzavi) list;
            do {
                zzp();
                zzaviVar.zzb();
                zzatp zzatpVar = this.zza;
                if (zzatpVar.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzm() : zzl());
                zzatp zzatpVar2 = this.zza;
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzF(List list, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzava("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZza = zzawnVar.zza();
            zzP(objZza, zzawnVar, zzatyVar);
            zzawnVar.zzk(objZza);
            list.add(objZza);
            zzatp zzatpVar = this.zza;
            if (zzatpVar.zzC() || this.zzd != 0) {
                return;
            } else {
                iZza = zzatpVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    @Deprecated
    public final void zzG(List list, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzava("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZza = zzawnVar.zza();
            zzQ(objZza, zzawnVar, zzatyVar);
            zzawnVar.zzk(objZza);
            list.add(objZza);
            zzatp zzatpVar = this.zza;
            if (zzatpVar.zzC() || this.zzd != 0) {
                return;
            } else {
                iZza = zzatpVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzI(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzauoVar.zzh(zzatpVar.zzn());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzn());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzn()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzn()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzJ(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzauoVar.zzh(zzatpVar.zzo());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzo());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzo()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzo()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzK(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzS(iZzn);
                int iZzD = zzatpVar.zzD() + iZzn;
                do {
                    zzauoVar.zzh(zzatpVar.zzp());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            if (i != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzp());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzS(iZzn2);
                int iZzD2 = zzatpVar3.zzD() + iZzn2;
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzp()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            if (i2 != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzp()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzL(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzavl) {
            zzavl zzavlVar = (zzavl) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzT(iZzn);
                int iZzD = iZzn + zzatpVar.zzD();
                do {
                    zzavlVar.zzf(zzatpVar.zzq());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzavlVar.zzf(zzatpVar2.zzq());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzT(iZzn2);
                int iZzD2 = iZzn2 + zzatpVar3.zzD();
                do {
                    list.add(Long.valueOf(zzatpVar3.zzq()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Long.valueOf(zzatpVar4.zzq()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzM(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauo) {
            zzauo zzauoVar = (zzauo) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzauoVar.zzh(zzatpVar.zzr());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzauoVar.zzh(zzatpVar2.zzr());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzatpVar3.zzr()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Integer.valueOf(zzatpVar4.zzr()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzN(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzavl) {
            zzavl zzavlVar = (zzavl) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzavlVar.zzf(zzatpVar.zzs());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzavlVar.zzf(zzatpVar2.zzs());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Long.valueOf(zzatpVar3.zzs()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Long.valueOf(zzatpVar4.zzs()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzb() throws IOException {
        int iZza = this.zzd;
        if (iZza != 0) {
            this.zzb = iZza;
            this.zzd = 0;
        } else {
            iZza = this.zza.zza();
            this.zzb = iZza;
        }
        if (iZza == 0 || iZza == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZza >>> 3;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final double zzd() throws IOException {
        zzO(1);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final float zze() throws IOException {
        zzO(5);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final long zzf() throws IOException {
        zzO(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final long zzg() throws IOException {
        zzO(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzh() throws IOException {
        zzO(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final long zzi() throws IOException {
        zzO(1);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzj() throws IOException {
        zzO(5);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final boolean zzk() throws IOException {
        zzO(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final String zzl() throws IOException {
        zzO(2);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final String zzm() throws IOException {
        zzO(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzn(Object obj, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        zzO(2);
        zzP(obj, zzawnVar, zzatyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzo(Object obj, zzawn zzawnVar, zzaty zzatyVar) throws IOException {
        zzO(3);
        zzQ(obj, zzawnVar, zzatyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final zzatl zzp() throws IOException {
        zzO(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzq() throws IOException {
        zzO(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzr() throws IOException {
        zzO(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzs() throws IOException {
        zzO(5);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final long zzt() throws IOException {
        zzO(1);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final int zzu() throws IOException {
        zzO(0);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final long zzv() throws IOException {
        zzO(0);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzw(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzT(iZzn);
                int iZzD = iZzn + zzatpVar.zzD();
                do {
                    zzatvVar.zzf(zzatpVar.zzc());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzatvVar.zzf(zzatpVar2.zzc());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzT(iZzn2);
                int iZzD2 = iZzn2 + zzatpVar3.zzD();
                do {
                    list.add(Double.valueOf(zzatpVar3.zzc()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Double.valueOf(zzatpVar4.zzc()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzx(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzauf) {
            zzauf zzaufVar = (zzauf) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzatp zzatpVar = this.zza;
                int iZzn = zzatpVar.zzn();
                zzS(iZzn);
                int iZzD = zzatpVar.zzD() + iZzn;
                do {
                    zzaufVar.zzf(zzatpVar.zzd());
                } while (zzatpVar.zzD() < iZzD);
                return;
            }
            if (i != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzaufVar.zzf(zzatpVar2.zzd());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzatp zzatpVar3 = this.zza;
                int iZzn2 = zzatpVar3.zzn();
                zzS(iZzn2);
                int iZzD2 = zzatpVar3.zzD() + iZzn2;
                do {
                    list.add(Float.valueOf(zzatpVar3.zzd()));
                } while (zzatpVar3.zzD() < iZzD2);
                return;
            }
            if (i2 != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Float.valueOf(zzatpVar4.zzd()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzy(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzavl) {
            zzavl zzavlVar = (zzavl) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzavlVar.zzf(zzatpVar.zze());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzavlVar.zzf(zzatpVar2.zze());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Long.valueOf(zzatpVar3.zze()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Long.valueOf(zzatpVar4.zze()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzz(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzavl) {
            zzavl zzavlVar = (zzavl) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar = this.zza;
                int iZzD = zzatpVar.zzD() + zzatpVar.zzn();
                do {
                    zzavlVar.zzf(zzatpVar.zzf());
                } while (zzatpVar.zzD() < iZzD);
                zzR(iZzD);
                return;
            }
            do {
                zzatp zzatpVar2 = this.zza;
                zzavlVar.zzf(zzatpVar2.zzf());
                if (zzatpVar2.zzC()) {
                    return;
                } else {
                    iZza2 = zzatpVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzava("Protocol message tag had invalid wire type.");
                }
                zzatp zzatpVar3 = this.zza;
                int iZzD2 = zzatpVar3.zzD() + zzatpVar3.zzn();
                do {
                    list.add(Long.valueOf(zzatpVar3.zzf()));
                } while (zzatpVar3.zzD() < iZzD2);
                zzR(iZzD2);
                return;
            }
            do {
                zzatp zzatpVar4 = this.zza;
                list.add(Long.valueOf(zzatpVar4.zzf()));
                if (zzatpVar4.zzC()) {
                    return;
                } else {
                    iZza = zzatpVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.pal.zzawi
    public final void zzH(List list) throws IOException {
        int iZza;
        if ((this.zzb & 7) != 2) {
            throw new zzava("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            zzatp zzatpVar = this.zza;
            if (zzatpVar.zzC()) {
                return;
            } else {
                iZza = zzatpVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }
}
