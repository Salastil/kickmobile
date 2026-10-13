package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzasl extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzase();
    zzask zza;
    int zzb;
    int zzc;
    final zzask zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzasg zzh;
    private zzasi zzi;

    public zzasl() {
        this(zze, true);
    }

    private final void zzf(zzask zzaskVar, zzask zzaskVar2) {
        zzask zzaskVar3 = zzaskVar.zza;
        zzaskVar.zza = null;
        if (zzaskVar2 != null) {
            zzaskVar2.zza = zzaskVar3;
        }
        if (zzaskVar3 == null) {
            this.zza = zzaskVar2;
        } else if (zzaskVar3.zzb == zzaskVar) {
            zzaskVar3.zzb = zzaskVar2;
        } else {
            zzaskVar3.zzc = zzaskVar2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0080 A[SYNTHETIC] */
    private final void zzg(zzask zzaskVar, boolean z) {
        while (zzaskVar != null) {
            zzask zzaskVar2 = zzaskVar.zzb;
            zzask zzaskVar3 = zzaskVar.zzc;
            boolean z2 = false;
            int i = zzaskVar2 != null ? zzaskVar2.zzi : 0;
            int i2 = zzaskVar3 != null ? zzaskVar3.zzi : 0;
            int i3 = i - i2;
            boolean z3 = true;
            if (i3 == -2) {
                zzask zzaskVar4 = zzaskVar3.zzb;
                zzask zzaskVar5 = zzaskVar3.zzc;
                int i4 = (zzaskVar4 != null ? zzaskVar4.zzi : 0) - (zzaskVar5 != null ? zzaskVar5.zzi : 0);
                if (i4 != -1) {
                    if (i4 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzi(zzaskVar3);
                    zzh(zzaskVar);
                    if (z3) {
                        return;
                    }
                } else {
                    z2 = z;
                }
                zzh(zzaskVar);
                z3 = z2;
                if (z3) {
                    return;
                }
            } else if (i3 == 2) {
                zzask zzaskVar6 = zzaskVar2.zzb;
                zzask zzaskVar7 = zzaskVar2.zzc;
                int i5 = (zzaskVar6 != null ? zzaskVar6.zzi : 0) - (zzaskVar7 != null ? zzaskVar7.zzi : 0);
                if (i5 != 1) {
                    if (i5 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzh(zzaskVar2);
                    zzi(zzaskVar);
                    if (z3) {
                        return;
                    }
                } else {
                    z2 = z;
                }
                zzi(zzaskVar);
                z3 = z2;
                if (z3) {
                    return;
                }
            } else if (i3 == 0) {
                zzaskVar.zzi = i + 1;
                if (z) {
                    return;
                }
            } else {
                zzaskVar.zzi = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzaskVar = zzaskVar.zza;
        }
    }

    private final void zzh(zzask zzaskVar) {
        zzask zzaskVar2 = zzaskVar.zzb;
        zzask zzaskVar3 = zzaskVar.zzc;
        zzask zzaskVar4 = zzaskVar3.zzb;
        zzask zzaskVar5 = zzaskVar3.zzc;
        zzaskVar.zzc = zzaskVar4;
        if (zzaskVar4 != null) {
            zzaskVar4.zza = zzaskVar;
        }
        zzf(zzaskVar, zzaskVar3);
        zzaskVar3.zzb = zzaskVar;
        zzaskVar.zza = zzaskVar3;
        int iMax = Math.max(zzaskVar2 != null ? zzaskVar2.zzi : 0, zzaskVar4 != null ? zzaskVar4.zzi : 0) + 1;
        zzaskVar.zzi = iMax;
        zzaskVar3.zzi = Math.max(iMax, zzaskVar5 != null ? zzaskVar5.zzi : 0) + 1;
    }

    private final void zzi(zzask zzaskVar) {
        zzask zzaskVar2 = zzaskVar.zzb;
        zzask zzaskVar3 = zzaskVar.zzc;
        zzask zzaskVar4 = zzaskVar2.zzb;
        zzask zzaskVar5 = zzaskVar2.zzc;
        zzaskVar.zzb = zzaskVar5;
        if (zzaskVar5 != null) {
            zzaskVar5.zza = zzaskVar;
        }
        zzf(zzaskVar, zzaskVar2);
        zzaskVar2.zzc = zzaskVar;
        zzaskVar.zza = zzaskVar2;
        int iMax = Math.max(zzaskVar3 != null ? zzaskVar3.zzi : 0, zzaskVar5 != null ? zzaskVar5.zzi : 0) + 1;
        zzaskVar.zzi = iMax;
        zzaskVar2.zzi = Math.max(iMax, zzaskVar4 != null ? zzaskVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzask zzaskVar = this.zzd;
        zzaskVar.zze = zzaskVar;
        zzaskVar.zzd = zzaskVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzb(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzasg zzasgVar = this.zzh;
        if (zzasgVar != null) {
            return zzasgVar;
        }
        zzasg zzasgVar2 = new zzasg(this);
        this.zzh = zzasgVar2;
        return zzasgVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzask zzaskVarZzb = zzb(obj);
        if (zzaskVarZzb != null) {
            return zzaskVarZzb.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzasi zzasiVar = this.zzi;
        if (zzasiVar != null) {
            return zzasiVar;
        }
        zzasi zzasiVar2 = new zzasi(this);
        this.zzi = zzasiVar2;
        return zzasiVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzask zzaskVarZza = zza(obj, true);
        Object obj3 = zzaskVarZza.zzh;
        zzaskVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzask zzaskVarZze = zze(obj);
        if (zzaskVarZze != null) {
            return zzaskVarZze.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzask zza(Object obj, boolean z) {
        int iCompareTo;
        zzask zzaskVar;
        Comparator comparator = this.zzf;
        zzask zzaskVar2 = this.zza;
        if (zzaskVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzaskVar2.zzf) : comparator.compare(obj, zzaskVar2.zzf);
                if (iCompareTo == 0) {
                    return zzaskVar2;
                }
                zzask zzaskVar3 = iCompareTo < 0 ? zzaskVar2.zzb : zzaskVar2.zzc;
                if (zzaskVar3 == null) {
                    break;
                }
                zzaskVar2 = zzaskVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i = iCompareTo;
        if (!z) {
            return null;
        }
        zzask zzaskVar4 = this.zzd;
        if (zzaskVar2 != null) {
            zzask zzaskVar5 = zzaskVar2;
            zzaskVar = new zzask(this.zzg, zzaskVar5, obj, zzaskVar4, zzaskVar4.zze);
            if (i < 0) {
                zzaskVar5.zzb = zzaskVar;
            } else {
                zzaskVar5.zzc = zzaskVar;
            }
            zzg(zzaskVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                String name = obj.getClass().getName();
                String.valueOf(name);
                throw new ClassCastException(String.valueOf(name).concat(" is not Comparable"));
            }
            zzaskVar = new zzask(this.zzg, null, obj, zzaskVar4, zzaskVar4.zze);
            this.zza = zzaskVar;
        }
        this.zzb++;
        this.zzc++;
        return zzaskVar;
    }

    final zzask zzb(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    final zzask zzc(Map.Entry entry) {
        zzask zzaskVarZzb = zzb(entry.getKey());
        if (zzaskVarZzb == null || !Objects.equals(zzaskVarZzb.zzh, entry.getValue())) {
            return null;
        }
        return zzaskVarZzb;
    }

    final void zzd(zzask zzaskVar, boolean z) {
        zzask zzaskVar2;
        zzask zzaskVar3;
        int i;
        if (z) {
            zzask zzaskVar4 = zzaskVar.zze;
            zzaskVar4.zzd = zzaskVar.zzd;
            zzaskVar.zzd.zze = zzaskVar4;
        }
        zzask zzaskVar5 = zzaskVar.zzb;
        zzask zzaskVar6 = zzaskVar.zzc;
        zzask zzaskVar7 = zzaskVar.zza;
        int i2 = 0;
        if (zzaskVar5 == null || zzaskVar6 == null) {
            if (zzaskVar5 != null) {
                zzf(zzaskVar, zzaskVar5);
                zzaskVar.zzb = null;
            } else if (zzaskVar6 != null) {
                zzf(zzaskVar, zzaskVar6);
                zzaskVar.zzc = null;
            } else {
                zzf(zzaskVar, null);
            }
            zzg(zzaskVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzaskVar5.zzi > zzaskVar6.zzi) {
            do {
                zzaskVar3 = zzaskVar5;
                zzaskVar5 = zzaskVar5.zzc;
            } while (zzaskVar5 != null);
        } else {
            do {
                zzaskVar2 = zzaskVar6;
                zzaskVar6 = zzaskVar6.zzb;
            } while (zzaskVar6 != null);
            zzaskVar3 = zzaskVar2;
        }
        zzd(zzaskVar3, false);
        zzask zzaskVar8 = zzaskVar.zzb;
        if (zzaskVar8 != null) {
            i = zzaskVar8.zzi;
            zzaskVar3.zzb = zzaskVar8;
            zzaskVar8.zza = zzaskVar3;
            zzaskVar.zzb = null;
        } else {
            i = 0;
        }
        zzask zzaskVar9 = zzaskVar.zzc;
        if (zzaskVar9 != null) {
            i2 = zzaskVar9.zzi;
            zzaskVar3.zzc = zzaskVar9;
            zzaskVar9.zza = zzaskVar3;
            zzaskVar.zzc = null;
        }
        zzaskVar3.zzi = Math.max(i, i2) + 1;
        zzf(zzaskVar, zzaskVar3);
    }

    final zzask zze(Object obj) {
        zzask zzaskVarZzb = zzb(obj);
        if (zzaskVarZzb != null) {
            zzd(zzaskVarZzb, true);
        }
        return zzaskVarZzb;
    }

    public zzasl(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzask(z);
    }

    public zzasl(boolean z) {
        this(zze, false);
    }
}
