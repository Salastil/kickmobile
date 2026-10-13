package com.google.android.gms.internal.measurement;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzyl {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final long zze;

    protected zzyl(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzyl zzc(String str, Class cls) {
        return new zzyl(str, cls, false, false);
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

    protected void zza(Iterator it, zzyk zzykVar) {
        while (it.hasNext()) {
            zzb(it.next(), zzykVar);
        }
    }

    protected void zzb(Object obj, zzyk zzykVar) {
        zzykVar.zza(this.zza, obj);
    }

    public final String zzd() {
        return this.zza;
    }

    public final Object zze(Object obj) {
        return this.zzb.cast(obj);
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final void zzg(Object obj, zzyk zzykVar) {
        if (!this.zzd || zzaad.zza() <= 20) {
            zzb(obj, zzykVar);
        } else {
            zzykVar.zza(this.zza, obj);
        }
    }

    public final void zzh(Iterator it, zzyk zzykVar) {
        zzabr.zzc(this.zzc, "non repeating key");
        if (!this.zzd || zzaad.zza() <= 20) {
            zza(it, zzykVar);
        } else {
            while (it.hasNext()) {
                zzykVar.zza(this.zza, it.next());
            }
        }
    }

    public final long zzi() {
        return this.zze;
    }

    private zzyl(String str, Class cls, boolean z, boolean z2) {
        zzabr.zzd(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        this.zzd = z2;
        int iIdentityHashCode = System.identityHashCode(this);
        long j = 0;
        for (int i = 0; i < 5; i++) {
            j |= 1 << (iIdentityHashCode & 63);
            iIdentityHashCode >>>= 6;
        }
        this.zze = j;
    }
}
