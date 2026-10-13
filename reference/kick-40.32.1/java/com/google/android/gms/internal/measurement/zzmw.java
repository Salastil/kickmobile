package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmw {
    private static final zzmw zza = new zzmw(ImmutableSortedSet.of());
    private final ImmutableSortedSet zzb;

    zzmw(ImmutableSortedSet immutableSortedSet) {
        this.zzb = immutableSortedSet;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0152  */
    /* JADX WARN: Multi-variable type inference failed */
    public static zzmw zza(zzmw zzmwVar, ImmutableMap immutableMap) {
        long j;
        if (immutableMap.isEmpty()) {
            return zzmwVar;
        }
        HashMap mapNewHashMap = Maps.newHashMap(immutableMap);
        ImmutableSortedSet immutableSortedSet = zzmwVar.zzb;
        ImmutableSortedSet.Builder builderNaturalOrder = ImmutableSortedSet.naturalOrder();
        UnmodifiableIterator it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            zzmv zzmvVar = (zzmv) it.next();
            Object objRemove = mapNewHashMap.remove(zzmvVar.zza());
            if (objRemove == null) {
                builderNaturalOrder.add(zzmvVar);
            } else if (objRemove instanceof String) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 4, 0L, objRemove));
            } else if (objRemove instanceof byte[]) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 5, 0L, objRemove));
            } else if (objRemove instanceof Boolean) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, ((Boolean) objRemove).booleanValue() ? 1 : 0, 0L, null));
            } else if (objRemove instanceof Long) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 2, ((Long) objRemove).longValue(), null));
            } else {
                if (!(objRemove instanceof Double)) {
                    String strZza = zzmvVar.zza();
                    String string = objRemove.toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 46 + string.length());
                    sb.append("Cannot serialize override for existing flag ");
                    sb.append(strZza);
                    sb.append(": ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 3, Double.doubleToRawLongBits(((Double) objRemove).doubleValue()), null));
            }
        }
        for (String str : mapNewHashMap.keySet()) {
            Object obj = mapNewHashMap.get(str);
            int length = str.length();
            if (length > 19 || length == 0) {
                j = 0;
                break;
            }
            boolean z = false;
            long jCharAt = str.charAt(0) - '0';
            if (jCharAt < 1 || jCharAt > 9) {
                j = 0;
                break;
            }
            int i = 1;
            while (true) {
                if (i >= length) {
                    if (jCharAt >= 0 && jCharAt <= 2305843009213693951L) {
                        j = jCharAt;
                        break;
                    }
                    break;
                }
                int iCharAt = str.charAt(i) - '0';
                if (!((iCharAt > 9) | (iCharAt < 0 ? true : z))) {
                    jCharAt = (jCharAt * 10) + ((long) iCharAt);
                    i++;
                    z = false;
                }
                j = 0;
                break;
            }
            String str2 = j == 0 ? str : null;
            if (obj instanceof String) {
                builderNaturalOrder.add(new zzmv(j, str2, 4, 0L, obj));
            } else if (obj instanceof byte[]) {
                builderNaturalOrder.add(new zzmv(j, str2, 5, 0L, obj));
            } else if (obj instanceof Boolean) {
                builderNaturalOrder.add(new zzmv(j, str2, ((Boolean) obj).booleanValue() ? 1 : 0, 0L, null));
            } else if (obj instanceof Long) {
                builderNaturalOrder.add(new zzmv(j, str2, 2, ((Long) obj).longValue(), null));
            } else {
                if (!(obj instanceof Double)) {
                    String strValueOf = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(strValueOf).length());
                    sb2.append("Cannot serialize override ");
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(strValueOf);
                    throw new IllegalStateException(sb2.toString());
                }
                builderNaturalOrder.add(new zzmv(j, str2, 3, Double.doubleToRawLongBits(((Double) obj).doubleValue()), null));
            }
        }
        return new zzmw(builderNaturalOrder.build());
    }

    public static zzmw zzb() {
        return zza;
    }

    public static zzmw zzd(zzacv zzacvVar) throws IOException {
        long j;
        String strZzl;
        zzmv zzmvVar;
        int iZzx = zzacvVar.zzx();
        if (iZzx < 0) {
            throw new zzaeh("Negative number of flags");
        }
        ImmutableSortedSet.Builder builderNaturalOrder = ImmutableSortedSet.naturalOrder();
        long j2 = 0;
        for (int i = 0; i < iZzx; i++) {
            long jZzz = zzacvVar.zzz();
            int i2 = (int) jZzz;
            long j3 = jZzz >>> 3;
            if (j3 == 0) {
                j = 0;
                strZzl = zzacvVar.zzl();
            } else {
                long j4 = j3 + j2;
                if (j4 > 2305843009213693951L) {
                    throw new zzaeh("Flag name larger than max size");
                }
                j = j4;
                strZzl = null;
            }
            int i3 = i2 & 7;
            if (i3 == 0 || i3 == 1) {
                zzmvVar = new zzmv(j, strZzl, i3, 0L, null);
            } else if (i3 == 2) {
                zzmvVar = new zzmv(j, strZzl, i3, zzacvVar.zzz(), null);
            } else if (i3 == 3) {
                zzmvVar = new zzmv(j, strZzl, i3, Double.doubleToRawLongBits(zzacvVar.zzd()), null);
            } else if (i3 == 4) {
                zzmvVar = new zzmv(j, strZzl, i3, 0L, zzacvVar.zzl());
            } else {
                if (i3 != 5) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 23);
                    sb.append("Unrecognized flag type ");
                    sb.append(i3);
                    throw new zzaeh(sb.toString());
                }
                zzmvVar = new zzmv(j, strZzl, i3, 0L, zzacvVar.zzo());
            }
            long j5 = zzmvVar.zza;
            if (j5 != 0) {
                j2 = j5;
            }
            builderNaturalOrder.add(zzmvVar);
        }
        return new zzmw(builderNaturalOrder.build());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzmw) {
            return this.zzb.equals(((zzmw) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(ImmutableMap.Builder builder) {
        UnmodifiableIterator it = this.zzb.iterator();
        while (it.hasNext()) {
            zzmv zzmvVar = (zzmv) it.next();
            builder.put(zzmvVar.zza(), zzmvVar.zzb());
        }
    }

    public final ImmutableSortedSet zze() {
        return this.zzb;
    }

    public final int zzf() {
        return this.zzb.size();
    }
}
