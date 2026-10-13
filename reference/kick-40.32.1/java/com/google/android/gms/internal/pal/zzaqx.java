package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqx {
    public static final zzaqx zza = new zzaqx(new zzaqy());
    public static final zzaqx zzb = new zzaqx(new zzarc());
    public static final zzaqx zzc;
    public static final zzaqx zzd;
    public static final zzaqx zze;
    private final zzaqw zzf;

    static {
        new zzaqx(new zzare());
        new zzaqx(new zzard());
        zzc = new zzaqx(new zzaqz());
        zzd = new zzaqx(new zzarb());
        zze = new zzaqx(new zzara());
    }

    public zzaqx(zzarf zzarfVar) {
        this.zzf = !zzacp.zza() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzaqt(zzarfVar, null) : new zzaqu(zzarfVar, null) : new zzaqv(zzarfVar, null);
    }

    public static List zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zzb(String str) throws GeneralSecurityException {
        return this.zzf.zza(str);
    }
}
