package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgi extends zzgo {
    private final zzfi zzh;
    private long zzi;

    public zzgi(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, zzfi zzfiVar) {
        super(zzfbVar, "CX4J+2yEJ2HtJzNjBSAFoPZxV3S124qFqsrwrEik3kHdsHRX3oIIB4d/zi0EQ0fu", "gfLiyhD2OvLSOj6bwf+kcmK11rwQ90aeBshxHD6xXgk=", zzadVar, i, 53);
        this.zzh = zzfiVar;
        if (zzfiVar != null) {
            this.zzi = zzfiVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzH(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
