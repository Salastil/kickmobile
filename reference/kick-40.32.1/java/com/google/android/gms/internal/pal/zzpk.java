package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpk extends zzpz {
    zzpk(String str, Class cls, boolean z) {
        super("tags", cls, false);
    }

    @Override // com.google.android.gms.internal.pal.zzpz
    public final /* bridge */ /* synthetic */ void zzb(Object obj, zzpy zzpyVar) {
        zzss zzssVar = (zzss) obj;
        if (zzssVar == null) {
            return;
        }
        for (Map.Entry entry : zzssVar.zzb().entrySet()) {
            if (((Set) entry.getValue()).isEmpty()) {
                zzpyVar.zza((String) entry.getKey(), null);
            } else {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    zzpyVar.zza((String) entry.getKey(), it.next());
                }
            }
        }
    }
}
