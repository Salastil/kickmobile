package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbi implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbk zza;
    final /* synthetic */ zzbk zzb;
    final /* synthetic */ TracksChooserDialogFragment zzc;

    zzbi(TracksChooserDialogFragment tracksChooserDialogFragment, zzbk zzbkVar, zzbk zzbkVar2) {
        this.zza = zzbkVar;
        this.zzb = zzbkVar2;
        Objects.requireNonNull(tracksChooserDialogFragment);
        this.zzc = tracksChooserDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzc.zza(this.zza, this.zzb);
    }
}
