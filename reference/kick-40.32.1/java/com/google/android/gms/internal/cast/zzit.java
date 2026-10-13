package com.google.android.gms.internal.cast;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzit {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzit(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzit zza(String str, Class cls) {
        return new zzit(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        String name = getClass().getName();
        String name2 = cls.getName();
        int length = String.valueOf(name).length();
        int length2 = String.valueOf(name2).length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(length + 1 + str.length() + 1 + length2 + 1);
        sb.append(name);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(str);
        sb.append("[");
        sb.append(name2);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzit(String str, Class cls, boolean z, boolean z2) {
        zzkm.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
