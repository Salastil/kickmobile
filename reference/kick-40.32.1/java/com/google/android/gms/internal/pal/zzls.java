package com.google.android.gms.internal.pal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzls {
    public static void zza(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(zzmd.zzc(str, Character.valueOf(c)));
        }
    }

    public static void zzd(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zzmd.zzc(str, obj));
        }
    }

    public static void zze(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(zzmd.zzc(str, obj, obj2));
        }
    }

    public static void zzf(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzg(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static int zzh(int i, int i2, String str) {
        String strZzc;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzc = zzmd.zzc("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            strZzc = zzmd.zzc("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzc);
    }

    public static int zzi(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzk(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static void zzj(int i, int i2, int i3) {
        String strZzk;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzk = zzk(i, i3, "start index");
            } else {
                strZzk = (i2 < 0 || i2 > i3) ? zzk(i2, i3, "end index") : zzmd.zzc("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzk);
        }
    }

    private static String zzk(int i, int i2, String str) {
        if (i < 0) {
            return zzmd.zzc("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzmd.zzc("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}
