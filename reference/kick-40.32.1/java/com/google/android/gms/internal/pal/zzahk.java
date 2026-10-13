package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzahk extends zzahm {
    final /* synthetic */ zzahl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzahk(zzarq zzarqVar, Class cls, zzahl zzahlVar) {
        super(zzarqVar, cls, null);
        this.zza = zzahlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzahm
    public final zzvz zza(zzaji zzajiVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        return this.zza.zza(zzajiVar, zzwmVar);
    }
}
