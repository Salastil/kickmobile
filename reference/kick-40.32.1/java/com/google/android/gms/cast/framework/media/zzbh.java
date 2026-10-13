package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbh implements DialogInterface.OnClickListener {
    final /* synthetic */ TracksChooserDialogFragment zza;

    zzbh(TracksChooserDialogFragment tracksChooserDialogFragment) {
        Objects.requireNonNull(tracksChooserDialogFragment);
        this.zza = tracksChooserDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        TracksChooserDialogFragment tracksChooserDialogFragment = this.zza;
        if (tracksChooserDialogFragment.zzb() != null) {
            tracksChooserDialogFragment.zzb().cancel();
            tracksChooserDialogFragment.zzc(null);
        }
    }
}
