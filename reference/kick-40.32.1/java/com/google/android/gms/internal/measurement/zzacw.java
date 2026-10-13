package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacw implements zzafo {
    private final zzacv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzacw(zzacv zzacvVar) {
        this.zza = zzacvVar;
        zzacvVar.zzd = this;
    }

    private final void zzQ(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
    }

    private final void zzR(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzacv zzacvVar = this.zza;
        int iZzp = zzacvVar.zzp();
        zzacvVar.zzO();
        int iZzD = zzacvVar.zzD(iZzp);
        zzacvVar.zza++;
        zzafpVar.zzg(obj, this, zzadfVar);
        zzacvVar.zzb(0);
        zzacvVar.zza--;
        zzacvVar.zzE(iZzD);
    }

    private final Object zzS(zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        Object objZza = zzafpVar.zza();
        zzR(objZza, zzafpVar, zzadfVar);
        zzafpVar.zzk(objZza);
        return objZza;
    }

    private final void zzT(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzafpVar.zzg(obj, this, zzadfVar);
            if (this.zzb != this.zzc) {
                throw new zzaeh("Failed to parse the message.");
            }
            this.zzc = i;
        } catch (Throwable th) {
            this.zzc = i;
            throw th;
        }
    }

    private final Object zzU(zzagm zzagmVar, Class cls, zzadf zzadfVar) throws IOException {
        zzagm zzagmVar2 = zzagm.DOUBLE;
        switch (zzagmVar) {
            case DOUBLE:
                return Double.valueOf(zze());
            case FLOAT:
                return Float.valueOf(zzf());
            case INT64:
                return Long.valueOf(zzh());
            case UINT64:
                return Long.valueOf(zzg());
            case INT32:
                return Integer.valueOf(zzi());
            case FIXED64:
                return Long.valueOf(zzj());
            case FIXED32:
                return Integer.valueOf(zzk());
            case BOOL:
                return Boolean.valueOf(zzl());
            case STRING:
                return zzn();
            case GROUP:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case MESSAGE:
                zzQ(2);
                return zzS(zzafl.zza().zzb(cls), zzadfVar);
            case BYTES:
                return zzq();
            case UINT32:
                return Integer.valueOf(zzr());
            case ENUM:
                return Integer.valueOf(zzs());
            case SFIXED32:
                return Integer.valueOf(zzt());
            case SFIXED64:
                return Long.valueOf(zzu());
            case SINT32:
                return Integer.valueOf(zzv());
            case SINT64:
                return Long.valueOf(zzw());
        }
    }

    private final void zzV(int i) throws IOException {
        if (this.zza.zzH() != i) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void zzW(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzaeh("Failed to parse the message.");
        }
    }

    private static final void zzX(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzaeh("Failed to parse the message.");
        }
    }

    public static zzacw zza(zzacv zzacvVar) {
        Object obj = zzacvVar.zzd;
        return obj != null ? (zzacw) obj : new zzacw(zzacvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzA(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzg());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzg());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzg()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzg()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzB(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzh());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzh());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzh()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzh()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzC(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzX(iZzp);
                int iZzH = iZzp + zzacvVar.zzH();
                do {
                    zzaeqVar.zzf(zzacvVar.zzi());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzi());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzX(iZzp2);
                int iZzH2 = iZzp2 + zzacvVar3.zzH();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzi()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzi()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzD(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzW(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzj());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            if (i != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzj());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzW(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzj()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzj()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzE(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaciVar.zzf(zzacvVar.zzk());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaciVar.zzf(zzacvVar2.zzk());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Boolean.valueOf(zzacvVar3.zzk()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Boolean.valueOf(zzacvVar4.zzk()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzF(List list, boolean z) throws IOException {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzaen) && !z) {
            zzaen zzaenVar = (zzaen) list;
            do {
                zzq();
                zzaenVar.zzb();
                zzacv zzacvVar = this.zza;
                if (zzacvVar.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzn() : zzm());
                zzacv zzacvVar2 = this.zza;
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzG(List list, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzS(zzafpVar, zzadfVar));
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG() || this.zzd != 0) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    @Deprecated
    public final void zzH(List list, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZza = zzafpVar.zza();
            zzT(objZza, zzafpVar, zzadfVar);
            zzafpVar.zzk(objZza);
            list.add(objZza);
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG() || this.zzd != 0) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzJ(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzp());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzp());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzp()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzp()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzK(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzq());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzq());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzq()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzq()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzL(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzW(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzr());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            if (i != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzr());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzW(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzr()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzr()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzM(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzX(iZzp);
                int iZzH = iZzp + zzacvVar.zzH();
                do {
                    zzaeqVar.zzf(zzacvVar.zzs());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzs());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzX(iZzp2);
                int iZzH2 = iZzp2 + zzacvVar3.zzH();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzs()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzs()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzN(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzt());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzt());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzt()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzt()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzO(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzu());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzu());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzu()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzu()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzP(Map map, zzaeu zzaeuVar, zzadf zzadfVar) throws IOException {
        zzQ(2);
        zzacv zzacvVar = this.zza;
        int iZzD = zzacvVar.zzD(zzacvVar.zzp());
        Object obj = zzaeuVar.zzd;
        Object objZzU = zzaeuVar.zzb;
        Object objZzU2 = obj;
        while (true) {
            try {
                int iZzb = zzb();
                if (iZzb == Integer.MAX_VALUE || zzacvVar.zzG()) {
                    break;
                }
                if (iZzb == 1) {
                    objZzU = zzU(zzaeuVar.zza, null, null);
                } else if (iZzb != 2) {
                    try {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.");
                        }
                    } catch (zzaeg e) {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.", e);
                        }
                    }
                } else {
                    objZzU2 = zzU(zzaeuVar.zzc, obj.getClass(), zzadfVar);
                }
            } catch (Throwable th) {
                this.zza.zzE(iZzD);
                throw th;
            }
        }
        map.put(objZzU, objZzU2);
        this.zza.zzE(iZzD);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
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

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        zzacv zzacvVar = this.zza;
        if (zzacvVar.zzG() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzacvVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final double zze() throws IOException {
        zzQ(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final float zzf() throws IOException {
        zzQ(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzg() throws IOException {
        zzQ(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzh() throws IOException {
        zzQ(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzi() throws IOException {
        zzQ(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzj() throws IOException {
        zzQ(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzk() throws IOException {
        zzQ(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final boolean zzl() throws IOException {
        zzQ(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzm() throws IOException {
        zzQ(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzn() throws IOException {
        zzQ(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzo(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzQ(2);
        zzR(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzp(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzQ(3);
        zzT(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final zzacr zzq() throws IOException {
        zzQ(2);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzr() throws IOException {
        zzQ(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzs() throws IOException {
        zzQ(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzt() throws IOException {
        zzQ(5);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzu() throws IOException {
        zzQ(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzv() throws IOException {
        zzQ(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzw() throws IOException {
        zzQ(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzx(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadc) {
            zzadc zzadcVar = (zzadc) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzX(iZzp);
                int iZzH = iZzp + zzacvVar.zzH();
                do {
                    zzadcVar.zzf(zzacvVar.zzd());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadcVar.zzf(zzacvVar2.zzd());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzX(iZzp2);
                int iZzH2 = iZzp2 + zzacvVar3.zzH();
                do {
                    list.add(Double.valueOf(zzacvVar3.zzd()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Double.valueOf(zzacvVar4.zzd()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzy(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzadm) {
            zzadm zzadmVar = (zzadm) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzW(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzadmVar.zzf(zzacvVar.zze());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            if (i != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadmVar.zzf(zzacvVar2.zze());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzW(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Float.valueOf(zzacvVar3.zze()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Float.valueOf(zzacvVar4.zze()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzz(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzf());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzf());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzf()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzf()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzI(List list) throws IOException {
        int iZza;
        if ((this.zzb & 7) != 2) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzq());
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG()) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }
}
