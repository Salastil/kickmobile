package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjy extends zzjn {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zzjg zzc;
    private static final zzjw zzd;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zziq.zza, zziv.zza, zziw.zza)));
        zzb = setUnmodifiableSet;
        zzc = zzjj.zza(setUnmodifiableSet).zzb();
        zzd = new zzjw(null);
    }

    /* synthetic */ zzjy(String str, String str2, boolean z, int i, Level level, Set set, zzjg zzjgVar, byte[] bArr) {
        super(str2);
        if (str2.length() > 23) {
            int i2 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i2 = length;
                    break;
                }
            }
            str2 = str2.substring(i2 + 1);
        }
        String.valueOf(str2);
        String strConcat = "".concat(String.valueOf(str2));
        strConcat.substring(0, Math.min(strConcat.length(), 23));
    }

    public static zzjw zzb() {
        return zzd;
    }
}
