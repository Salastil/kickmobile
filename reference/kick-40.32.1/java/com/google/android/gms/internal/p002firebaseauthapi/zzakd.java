package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzakd implements Comparator<zzakb> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzakb zzakbVar, zzakb zzakbVar2) {
        zzakb zzakbVar3 = zzakbVar;
        zzakb zzakbVar4 = zzakbVar2;
        zzakh zzakhVar = (zzakh) zzakbVar3.iterator();
        zzakh zzakhVar2 = (zzakh) zzakbVar4.iterator();
        while (zzakhVar.hasNext() && zzakhVar2.hasNext()) {
            int iCompare = Integer.compare(zzakb.zza(zzakhVar.zza()), zzakb.zza(zzakhVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzakbVar3.zza(), zzakbVar4.zza());
    }

    zzakd() {
    }
}
