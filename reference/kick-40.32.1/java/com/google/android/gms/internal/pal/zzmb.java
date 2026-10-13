package com.google.android.gms.internal.pal;

import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmb {
    private final zzma zza;

    private zzmb(zzma zzmaVar) {
        int i = zzlm.zzb;
        this.zza = zzmaVar;
    }

    public static zzmb zza(char c) {
        final zzlk zzlkVar = new zzlk(FilenameUtils.EXTENSION_SEPARATOR);
        return new zzmb(new zzma() { // from class: com.google.android.gms.internal.pal.zzly
            @Override // com.google.android.gms.internal.pal.zzma
            public final /* synthetic */ Iterator zza(zzmb zzmbVar, CharSequence charSequence) {
                return new zzlu(zzmbVar, charSequence, zzlkVar);
            }
        });
    }

    public static zzmb zzb(int i) {
        final int i2 = 4000;
        return new zzmb(new zzma(i2) { // from class: com.google.android.gms.internal.pal.zzlx
            @Override // com.google.android.gms.internal.pal.zzma
            public final /* synthetic */ Iterator zza(zzmb zzmbVar, CharSequence charSequence) {
                return new zzlv(zzmbVar, charSequence, 4000);
            }
        });
    }

    final /* synthetic */ Iterator zzd(CharSequence charSequence) {
        return this.zza.zza(this, charSequence);
    }

    public final Iterable zzc(CharSequence charSequence) {
        charSequence.getClass();
        return new zzlw(this, charSequence);
    }
}
