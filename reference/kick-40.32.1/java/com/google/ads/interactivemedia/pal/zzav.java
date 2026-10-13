package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzno;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzav {
    private final zzp zza;
    private final String zzb;

    zzav(zzp zzpVar, String str) {
        this.zza = zzpVar;
        this.zzb = str;
    }

    public final void zza(int i, String str) {
        zzno zznoVar = new zzno();
        zznoVar.zza(zzau.DEVICE_TYPE.zza(), String.valueOf(4));
        zznoVar.zza(zzau.EVENT_TYPE.zza(), String.valueOf(i - 1));
        zznoVar.zza(zzau.SPAM_CORRELATOR.zza(), this.zzb);
        String strZza = zzau.SPAM_SIGNAL.zza();
        if (str == null) {
            str = AbstractJsonLexerKt.NULL;
        }
        zznoVar.zza(strZza, str);
        this.zza.zza("asscs", "116", zznoVar.zzd());
    }
}
