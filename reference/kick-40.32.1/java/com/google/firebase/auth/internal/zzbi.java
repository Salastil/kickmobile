package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaih;
import com.google.android.gms.internal.p002firebaseauthapi.zzaje;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbi {
    public static MultiFactorInfo zza(zzaih zzaihVar) {
        if (zzaihVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzaihVar.zze())) {
            return new PhoneMultiFactorInfo(zzaihVar.zzd(), zzaihVar.zzc(), zzaihVar.zza(), Preconditions.checkNotEmpty(zzaihVar.zze()));
        }
        if (zzaihVar.zzb() != null) {
            return new TotpMultiFactorInfo(zzaihVar.zzd(), zzaihVar.zzc(), zzaihVar.zza(), (zzaje) Preconditions.checkNotNull(zzaihVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List<MultiFactorInfo> zza(List<zzaih> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<zzaih> it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfoZza = zza(it.next());
            if (multiFactorInfoZza != null) {
                arrayList.add(multiFactorInfoZza);
            }
        }
        return arrayList;
    }
}
