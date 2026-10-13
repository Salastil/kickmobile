package com.google.android.gms.internal.pal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlu extends zzlz {
    zzlu(zzmb zzmbVar, CharSequence charSequence, zzln zzlnVar) {
        super(zzmbVar, charSequence);
    }

    @Override // com.google.android.gms.internal.pal.zzlz
    final int zzc(int i) {
        CharSequence charSequence = this.zza;
        int length = charSequence.length();
        zzls.zzi(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (charSequence.charAt(i) == '.') {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzlz
    final int zzd(int i) {
        return i + 1;
    }
}
