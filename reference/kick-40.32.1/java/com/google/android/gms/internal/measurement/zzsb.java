package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.collect.ImmutableList;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsb {
    private final Uri.Builder zza = new Uri.Builder().scheme("file").authority("").path(DomExceptionUtils.SEPARATOR);
    private final ImmutableList.Builder zzb = ImmutableList.builder();

    private zzsb() {
    }

    public final zzsb zza(File file) {
        this.zza.path(file.getAbsolutePath());
        return this;
    }

    public final Uri zzb() {
        return this.zza.encodedFragment(zzsp.zzb(this.zzb.build())).build();
    }

    /* synthetic */ zzsb(byte[] bArr) {
    }
}
