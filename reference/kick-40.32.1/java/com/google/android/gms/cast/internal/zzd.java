package com.google.android.gms.cast.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzd extends zzq {
    private final List zzb;

    public zzd(String str, String str2, String str3) {
        super(str, "MediaControlChannel", null);
        this.zzb = Collections.synchronizedList(new ArrayList());
    }

    protected final void zza() {
        List list = this.zzb;
        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((zzav) it.next()).zze(2002);
            }
        }
    }

    protected final List zzb() {
        return this.zzb;
    }

    protected final void zzc(zzav zzavVar) {
        this.zzb.add(zzavVar);
    }
}
